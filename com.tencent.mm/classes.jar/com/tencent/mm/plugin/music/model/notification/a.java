package com.tencent.mm.plugin.music.model.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RemoteViews;
import android.widget.TextView;
import androidx.core.app.e.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.a.a.c.a;
import com.tencent.mm.ay.i;
import com.tencent.mm.ay.q;
import com.tencent.mm.f.a.np;
import com.tencent.mm.plugin.music.a.c;
import com.tencent.mm.plugin.music.a.d;
import com.tencent.mm.plugin.music.a.e;
import com.tencent.mm.plugin.music.a.g;
import com.tencent.mm.plugin.music.a.h;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.plugin.music.model.d.c;
import com.tencent.mm.plugin.sns.b.h;
import com.tencent.mm.plugin.sns.b.p;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a
{
  Bundle FSf;
  MMMusicPlayerService FSg;
  NotificationManager FSh;
  d.c FSi;
  Runnable FSj;
  BroadcastReceiver FSk;
  boolean isInit;
  
  public a()
  {
    AppMethodBeat.i(63105);
    this.isInit = false;
    this.FSf = null;
    this.FSj = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(63102);
        Log.i("MicroMsg.Music.MMMusicNotification", "close");
        MMHandlerThread.removeRunnable(a.this.FSj);
        a.this.FSg.stopForeground(true);
        a.this.FSf = null;
        AppMethodBeat.o(63102);
      }
    };
    AppMethodBeat.o(63105);
  }
  
  private static String H(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(259922);
    if (paramBoolean)
    {
      paramContext = paramContext.getString(a.h.music_talk_back_notification_button_pause);
      AppMethodBeat.o(259922);
      return paramContext;
    }
    paramContext = paramContext.getString(a.h.music_talk_back_notification_button_play);
    AppMethodBeat.o(259922);
    return paramContext;
  }
  
  private static void a(View paramView, List<TextView> paramList)
  {
    AppMethodBeat.i(63115);
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      int i = 0;
      while (i < paramView.getChildCount())
      {
        a(paramView.getChildAt(i), paramList);
        i += 1;
      }
      AppMethodBeat.o(63115);
      return;
    }
    if ((paramView instanceof TextView)) {
      paramList.add((TextView)paramView);
    }
    AppMethodBeat.o(63115);
  }
  
  public static void a(com.tencent.mm.plugin.music.model.e.a parama, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(63106);
    Log.i("MicroMsg.Music.MMMusicNotification", "sendMusicPlayerEvent action:%d", new Object[] { Integer.valueOf(paramInt) });
    np localnp = new np();
    localnp.fMc.action = paramInt;
    localnp.fMc.state = "";
    localnp.fMc.fLV = parama.ffh();
    localnp.fMc.appId = "not from app brand appid";
    localnp.fMc.fMe = paramBoolean;
    EventCenter.instance.asyncPublish(localnp, Looper.getMainLooper());
    AppMethodBeat.o(63106);
  }
  
  private RemoteViews b(Context paramContext, com.tencent.mm.plugin.music.model.e.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(63111);
    String str = parama.field_songName;
    Object localObject2 = parama.field_songSinger;
    Object localObject1 = localObject2;
    if (!Util.isNullOrNil(parama.field_songAlbum)) {
      localObject1 = (String)localObject2 + parama.field_songAlbum;
    }
    localObject2 = f(parama);
    parama = new RemoteViews(paramContext.getPackageName(), a.g.remote_music_notification);
    label116:
    boolean bool;
    if (localObject2 != null)
    {
      parama.setImageViewBitmap(a.e.music_notification_album, (Bitmap)localObject2);
      if (Util.isNullOrNil(str)) {
        break label416;
      }
      parama.setViewVisibility(a.e.music_notification_title, 0);
      parama.setTextViewText(a.e.music_notification_title, str);
      if (Util.isNullOrNil((String)localObject1)) {
        break label428;
      }
      parama.setViewVisibility(a.e.music_notification_desc, 0);
      parama.setTextViewText(a.e.music_notification_desc, (CharSequence)localObject1);
      label141:
      bool = zn(dG(this.FSg));
      localObject1 = new Intent("com.tencent.mm.Intent.ACTION_MMMUSIC_NOTIFICATION_CLICK");
      ((Intent)localObject1).putExtra("mm_music_notification_action_key", "mm_music_notification_action_pre");
      localObject1 = PendingIntent.getBroadcast(paramContext, 0, (Intent)localObject1, 134217728);
      parama.setImageViewResource(a.e.music_notification_pre, hA(bool));
      parama.setOnClickPendingIntent(a.e.music_notification_pre, (PendingIntent)localObject1);
      localObject1 = new Intent("com.tencent.mm.Intent.ACTION_MMMUSIC_NOTIFICATION_CLICK");
      if (!paramBoolean) {
        break label440;
      }
      ((Intent)localObject1).putExtra("mm_music_notification_action_key", "mm_music_notification_action_pause");
    }
    for (;;)
    {
      localObject1 = PendingIntent.getBroadcast(paramContext, 1, (Intent)localObject1, 134217728);
      parama.setImageViewResource(a.e.music_notification_pause, w(paramBoolean, bool));
      parama.setContentDescription(a.e.music_notification_pause, H(paramContext, paramBoolean));
      parama.setOnClickPendingIntent(a.e.music_notification_pause, (PendingIntent)localObject1);
      localObject1 = new Intent("com.tencent.mm.Intent.ACTION_MMMUSIC_NOTIFICATION_CLICK");
      ((Intent)localObject1).putExtra("mm_music_notification_action_key", "mm_music_notification_action_next");
      localObject1 = PendingIntent.getBroadcast(paramContext, 2, (Intent)localObject1, 134217728);
      parama.setImageViewResource(a.e.music_notification_next, hC(bool));
      parama.setOnClickPendingIntent(a.e.music_notification_next, (PendingIntent)localObject1);
      localObject1 = new Intent("com.tencent.mm.Intent.ACTION_MMMUSIC_NOTIFICATION_CLICK");
      ((Intent)localObject1).putExtra("mm_music_notification_action_key", "mm_music_notification_action_close");
      paramContext = PendingIntent.getBroadcast(paramContext, 3, (Intent)localObject1, 134217728);
      parama.setImageViewResource(a.e.music_notification_close, hD(bool));
      parama.setOnClickPendingIntent(a.e.music_notification_close, paramContext);
      AppMethodBeat.o(63111);
      return parama;
      parama.setImageViewResource(a.e.music_notification_album, a.d.default_icon_music);
      break;
      label416:
      parama.setViewVisibility(a.e.music_notification_title, 8);
      break label116;
      label428:
      parama.setViewVisibility(a.e.music_notification_desc, 8);
      break label141;
      label440:
      ((Intent)localObject1).putExtra("mm_music_notification_action_key", "mm_music_notification_action_play");
    }
  }
  
  private static int dG(Context paramContext)
  {
    AppMethodBeat.i(63113);
    Object localObject = com.tencent.mm.bx.a.cp(paramContext, "reminder_channel_id").gr().contentView;
    if (localObject == null)
    {
      AppMethodBeat.o(63113);
      return -16777216;
    }
    int i = ((RemoteViews)localObject).getLayoutId();
    paramContext = (ViewGroup)LayoutInflater.from(paramContext).inflate(i, null);
    localObject = (TextView)paramContext.findViewById(16908310);
    if (localObject != null)
    {
      i = ((TextView)localObject).getCurrentTextColor();
      AppMethodBeat.o(63113);
      return i;
    }
    i = i(paramContext);
    AppMethodBeat.o(63113);
    return i;
  }
  
  private Bitmap f(final com.tencent.mm.plugin.music.model.e.a parama)
  {
    final String str = null;
    AppMethodBeat.i(63112);
    if (parama == null)
    {
      Log.e("MicroMsg.Music.MMMusicNotification", "music is null, return");
      AppMethodBeat.o(63112);
      return null;
    }
    Log.i("MicroMsg.Music.MMMusicNotification", "music.field_musicType %d", new Object[] { Integer.valueOf(parama.field_musicType) });
    for (;;)
    {
      try
      {
        int i = parama.field_musicType;
        localObject1 = str;
        switch (i)
        {
        default: 
          localObject1 = str;
        }
      }
      catch (Exception localException)
      {
        Object localObject1;
        Log.printErrStackTrace("MicroMsg.Music.MMMusicNotification", localException, "get bitmap", new Object[0]);
        Object localObject2 = str;
        continue;
        localObject2 = q.bml().Wo(parama.field_songAlbumUrl);
        if (localObject2 != null) {
          continue;
        }
        str = com.tencent.mm.plugin.music.h.b.ce(parama.field_musicId, false);
        Object localObject3 = new c.a();
        ((c.a)localObject3).fullPath = com.tencent.mm.plugin.music.h.b.ce(parama.field_musicId, false);
        ((c.a)localObject3).lRD = true;
        ((c.a)localObject3).dO(com.tencent.mm.ci.a.aY(this.FSg, a.c.notification_large_icon_width), com.tencent.mm.ci.a.aY(this.FSg, a.c.notification_large_icon_height));
        ((c.a)localObject3).lRB = true;
        q.bml().a(parama.field_songAlbumUrl, ((c.a)localObject3).bmL(), new com.tencent.mm.ay.a.c.d()
        {
          public final void a(boolean paramAnonymousBoolean, Object... paramAnonymousVarArgs)
          {
            AppMethodBeat.i(259650);
            Log.i("MicroMsg.Music.MMMusicNotification", "music.field_songAlbumUrl:%s, success:%b", new Object[] { parama.field_songAlbumUrl, Boolean.valueOf(paramAnonymousBoolean) });
            if (paramAnonymousBoolean)
            {
              paramAnonymousVarArgs = BitmapUtil.decodeFile(str, null);
              if (paramAnonymousVarArgs == null)
              {
                Log.e("MicroMsg.Music.MMMusicNotification", "bitmap is null, return");
                AppMethodBeat.o(259650);
                return;
              }
              q.bml().h(parama.field_songAlbumUrl, paramAnonymousVarArgs);
              a.this.FSg.bfU();
            }
            AppMethodBeat.o(259650);
          }
        });
        parama = BitmapUtil.getRoundedCornerBitmap((Bitmap)localObject2, false, 12.0F, false);
        AppMethodBeat.o(63112);
      }
      if (localObject1 == null) {
        continue;
      }
      parama = BitmapUtil.getRoundedCornerBitmap((Bitmap)localObject1, false, 12.0F, false);
      AppMethodBeat.o(63112);
      return parama;
      localObject1 = q.bmh().b(parama.field_songAlbumLocalPath, com.tencent.mm.ci.a.getDensity(this.FSg), true);
      continue;
      localObject1 = q.bmh().a(parama.field_songAlbumLocalPath, com.tencent.mm.ci.a.getDensity(this.FSg), true);
      continue;
      localObject3 = new cvt();
      ((cvt)localObject3).Id = parama.field_songMediaId;
      ((cvt)localObject3).TDF = parama.field_songAlbumUrl;
      ((cvt)localObject3).TDG = parama.field_songAlbumType;
      ((cvt)localObject3).Url = ((cvt)localObject3).TDF;
      localObject1 = str;
      if (p.JPc != null) {
        localObject1 = p.JPc.a((cvt)localObject3);
      }
    }
    return parama;
  }
  
  private static int hA(boolean paramBoolean)
  {
    if (paramBoolean) {
      return a.d.remote_notification_pre_dark;
    }
    return a.d.remote_notification_pre_light;
  }
  
  private static int hC(boolean paramBoolean)
  {
    if (paramBoolean) {
      return a.d.remote_notification_next_dark;
    }
    return a.d.remote_notification_next_light;
  }
  
  private static int hD(boolean paramBoolean)
  {
    if (paramBoolean) {
      return a.d.remote_notification_close_dark;
    }
    return a.d.remote_notification_close_light;
  }
  
  private static int i(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(63114);
    Object localObject = new ArrayList();
    a(paramViewGroup, (List)localObject);
    paramViewGroup = null;
    Iterator localIterator = ((List)localObject).iterator();
    if (localIterator.hasNext())
    {
      localObject = (TextView)localIterator.next();
      if (((TextView)localObject).getTextSize() <= -1.0F) {
        break label90;
      }
      paramViewGroup = (ViewGroup)localObject;
    }
    label90:
    for (;;)
    {
      break;
      if (paramViewGroup != null)
      {
        int i = paramViewGroup.getCurrentTextColor();
        AppMethodBeat.o(63114);
        return i;
      }
      AppMethodBeat.o(63114);
      return -16777216;
    }
  }
  
  private static int w(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if (paramBoolean2) {
        return a.d.remote_notification_pause_dark;
      }
      return a.d.remote_notification_pause_light;
    }
    if (paramBoolean2) {
      return a.d.remote_notification_play_dark;
    }
    return a.d.remote_notification_play_light;
  }
  
  private static boolean zn(int paramInt)
  {
    AppMethodBeat.i(63116);
    int j = paramInt | 0xFF000000;
    paramInt = Color.red(-16777216) - Color.red(j);
    int i = Color.green(-16777216) - Color.green(j);
    j = Color.blue(-16777216) - Color.blue(j);
    if (Math.sqrt(j * j + (paramInt * paramInt + i * i)) < 180.0D)
    {
      AppMethodBeat.o(63116);
      return true;
    }
    AppMethodBeat.o(63116);
    return false;
  }
  
  final Notification a(Context paramContext, com.tencent.mm.plugin.music.model.e.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(63110);
    Object localObject = com.tencent.mm.plugin.music.model.d.feM().feL();
    this.FSf = ((Intent)localObject).getExtras();
    if (parama.lVX) {
      ((Intent)localObject).setClassName(paramContext, "com.tencent.mm.plugin.mv.ui.MusicMvMainUI");
    }
    for (;;)
    {
      ((Intent)localObject).putExtra("key_scene", 5);
      localObject = PendingIntent.getActivity(paramContext, 0, (Intent)localObject, 134217728);
      e.d locald = com.tencent.mm.bx.a.cp(paramContext, "reminder_channel_id");
      locald.Ip = ((PendingIntent)localObject);
      paramContext = locald.bn(com.tencent.mm.bx.a.fkG()).a(b(paramContext, parama, paramBoolean)).gr();
      AppMethodBeat.o(63110);
      return paramContext;
      ((Intent)localObject).setClassName(paramContext, "com.tencent.mm.plugin.music.ui.MusicMainUI");
    }
  }
  
  public final void close()
  {
    AppMethodBeat.i(63109);
    if (!this.isInit)
    {
      Log.e("MicroMsg.Music.MMMusicNotification", "MMMusicNotification not init, close err");
      AppMethodBeat.o(63109);
      return;
    }
    if (this.FSg == null)
    {
      Log.e("MicroMsg.Music.MMMusicNotification", "mmMusicPlayerService is null, return");
      AppMethodBeat.o(63109);
      return;
    }
    Log.i("MicroMsg.Music.MMMusicNotification", "close");
    MMHandlerThread.removeRunnable(this.FSj);
    MMHandlerThread.postToMainThreadDelayed(this.FSj, 1000L);
    AppMethodBeat.o(63109);
  }
  
  public final void d(com.tencent.mm.plugin.music.model.e.a parama)
  {
    AppMethodBeat.i(63107);
    if (!this.isInit)
    {
      Log.e("MicroMsg.Music.MMMusicNotification", "MMMusicNotification not init, play err");
      AppMethodBeat.o(63107);
      return;
    }
    if (this.FSg == null)
    {
      Log.e("MicroMsg.Music.MMMusicNotification", "mmMusicPlayerService is null, return");
      AppMethodBeat.o(63107);
      return;
    }
    Log.i("MicroMsg.Music.MMMusicNotification", "play");
    MMHandlerThread.removeRunnable(this.FSj);
    try
    {
      this.FSg.startForeground(291, a(this.FSg, parama, true));
      AppMethodBeat.o(63107);
      return;
    }
    catch (Exception parama)
    {
      Log.printErrStackTrace("MicroMsg.Music.MMMusicNotification", parama, "", new Object[0]);
      AppMethodBeat.o(63107);
    }
  }
  
  public final void e(com.tencent.mm.plugin.music.model.e.a parama)
  {
    AppMethodBeat.i(63108);
    if (!this.isInit)
    {
      Log.e("MicroMsg.Music.MMMusicNotification", "MMMusicNotification not init, pause err");
      AppMethodBeat.o(63108);
      return;
    }
    if (this.FSg == null)
    {
      Log.e("MicroMsg.Music.MMMusicNotification", "mmMusicPlayerService is null, return");
      AppMethodBeat.o(63108);
      return;
    }
    Log.i("MicroMsg.Music.MMMusicNotification", "pause");
    MMHandlerThread.removeRunnable(this.FSj);
    this.FSh.notify(291, a(this.FSg, parama, false));
    AppMethodBeat.o(63108);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.notification.a
 * JD-Core Version:    0.7.0.1
 */