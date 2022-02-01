package com.tencent.mm.plugin.music.model.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Looper;
import android.support.v4.app.s.c;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RemoteViews;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.i;
import com.tencent.mm.av.q;
import com.tencent.mm.g.a.mx;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.protocal.protobuf.cnb;
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
  MMMusicPlayerService AkZ;
  NotificationManager Ala;
  Runnable Alb;
  BroadcastReceiver Alc;
  boolean isInit;
  
  public a()
  {
    AppMethodBeat.i(63105);
    this.isInit = false;
    this.Alb = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(63102);
        Log.i("MicroMsg.Music.MMMusicNotification", "close");
        MMHandlerThread.removeRunnable(a.this.Alb);
        a.this.AkZ.stopForeground(true);
        AppMethodBeat.o(63102);
      }
    };
    AppMethodBeat.o(63105);
  }
  
  private Notification a(Context paramContext, com.tencent.mm.plugin.music.model.e.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(63110);
    Object localObject = com.tencent.mm.plugin.music.model.d.euu().eut();
    if (parama.jfx) {
      ((Intent)localObject).setClassName(paramContext, "com.tencent.mm.plugin.mv.ui.MusicMvMainUI");
    }
    for (;;)
    {
      ((Intent)localObject).putExtra("key_scene", 5);
      localObject = PendingIntent.getActivity(paramContext, 0, (Intent)localObject, 134217728);
      s.c localc = com.tencent.mm.bq.a.cd(paramContext, "reminder_channel_id");
      localc.Hv = ((PendingIntent)localObject);
      paramContext = localc.as(com.tencent.mm.bq.a.ezb()).a(b(paramContext, parama, paramBoolean)).build();
      AppMethodBeat.o(63110);
      return paramContext;
      ((Intent)localObject).setClassName(paramContext, "com.tencent.mm.plugin.music.ui.MusicMainUI");
    }
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
    mx localmx = new mx();
    localmx.dSE.action = paramInt;
    localmx.dSE.state = "";
    localmx.dSE.dSy = parama.euO();
    localmx.dSE.appId = "not from app brand appid";
    localmx.dSE.dSG = paramBoolean;
    EventCenter.instance.asyncPublish(localmx, Looper.getMainLooper());
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
    parama = new RemoteViews(paramContext.getPackageName(), 2131496114);
    label112:
    boolean bool;
    if (localObject2 != null)
    {
      parama.setImageViewBitmap(2131305102, (Bitmap)localObject2);
      if (Util.isNullOrNil(str)) {
        break label395;
      }
      parama.setViewVisibility(2131305108, 0);
      parama.setTextViewText(2131305108, str);
      if (Util.isNullOrNil((String)localObject1)) {
        break label406;
      }
      parama.setViewVisibility(2131305104, 0);
      parama.setTextViewText(2131305104, (CharSequence)localObject1);
      label137:
      bool = wc(dH(this.AkZ));
      localObject1 = new Intent("com.tencent.mm.Intent.ACTION_MMMUSIC_NOTIFICATION_CLICK");
      ((Intent)localObject1).putExtra("mm_music_notification_action_key", "mm_music_notification_action_pre");
      localObject1 = PendingIntent.getBroadcast(paramContext, 0, (Intent)localObject1, 134217728);
      parama.setImageViewResource(2131305107, gP(bool));
      parama.setOnClickPendingIntent(2131305107, (PendingIntent)localObject1);
      localObject1 = new Intent("com.tencent.mm.Intent.ACTION_MMMUSIC_NOTIFICATION_CLICK");
      if (!paramBoolean) {
        break label418;
      }
      ((Intent)localObject1).putExtra("mm_music_notification_action_key", "mm_music_notification_action_pause");
    }
    for (;;)
    {
      localObject1 = PendingIntent.getBroadcast(paramContext, 1, (Intent)localObject1, 134217728);
      parama.setImageViewResource(2131305106, t(paramBoolean, bool));
      parama.setOnClickPendingIntent(2131305106, (PendingIntent)localObject1);
      localObject1 = new Intent("com.tencent.mm.Intent.ACTION_MMMUSIC_NOTIFICATION_CLICK");
      ((Intent)localObject1).putExtra("mm_music_notification_action_key", "mm_music_notification_action_next");
      localObject1 = PendingIntent.getBroadcast(paramContext, 2, (Intent)localObject1, 134217728);
      parama.setImageViewResource(2131305105, gR(bool));
      parama.setOnClickPendingIntent(2131305105, (PendingIntent)localObject1);
      localObject1 = new Intent("com.tencent.mm.Intent.ACTION_MMMUSIC_NOTIFICATION_CLICK");
      ((Intent)localObject1).putExtra("mm_music_notification_action_key", "mm_music_notification_action_close");
      paramContext = PendingIntent.getBroadcast(paramContext, 3, (Intent)localObject1, 134217728);
      parama.setImageViewResource(2131305103, gS(bool));
      parama.setOnClickPendingIntent(2131305103, paramContext);
      AppMethodBeat.o(63111);
      return parama;
      parama.setImageViewResource(2131305102, 2131231962);
      break;
      label395:
      parama.setViewVisibility(2131305108, 8);
      break label112;
      label406:
      parama.setViewVisibility(2131305104, 8);
      break label137;
      label418:
      ((Intent)localObject1).putExtra("mm_music_notification_action_key", "mm_music_notification_action_play");
    }
  }
  
  private static int dH(Context paramContext)
  {
    AppMethodBeat.i(63113);
    Object localObject = com.tencent.mm.bq.a.cd(paramContext, "reminder_channel_id").build().contentView;
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
    i = h(paramContext);
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
        localObject2 = q.bcV().OQ(parama.field_songAlbumUrl);
        if (localObject2 != null) {
          continue;
        }
        str = com.tencent.mm.plugin.music.h.b.bV(parama.field_musicId, false);
        Object localObject3 = new c.a();
        ((c.a)localObject3).fullPath = com.tencent.mm.plugin.music.h.b.bV(parama.field_musicId, false);
        ((c.a)localObject3).jbf = true;
        ((c.a)localObject3).dr(com.tencent.mm.cb.a.aG(this.AkZ, 2131166781), com.tencent.mm.cb.a.aG(this.AkZ, 2131166780));
        ((c.a)localObject3).jbd = true;
        q.bcV().a(parama.field_songAlbumUrl, ((c.a)localObject3).bdv(), new com.tencent.mm.av.a.c.d()
        {
          public final void a(boolean paramAnonymousBoolean, Object... paramAnonymousVarArgs)
          {
            AppMethodBeat.i(219851);
            Log.i("MicroMsg.Music.MMMusicNotification", "music.field_songAlbumUrl:%s, success:%b", new Object[] { parama.field_songAlbumUrl, Boolean.valueOf(paramAnonymousBoolean) });
            if (paramAnonymousBoolean)
            {
              paramAnonymousVarArgs = BitmapUtil.decodeFile(str, null);
              if (paramAnonymousVarArgs == null)
              {
                Log.e("MicroMsg.Music.MMMusicNotification", "bitmap is null, return");
                AppMethodBeat.o(219851);
                return;
              }
              q.bcV().h(parama.field_songAlbumUrl, paramAnonymousVarArgs);
              a.this.AkZ.refresh();
            }
            AppMethodBeat.o(219851);
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
      localObject1 = q.bcR().b(parama.field_songAlbumLocalPath, com.tencent.mm.cb.a.getDensity(this.AkZ), true);
      continue;
      localObject1 = q.bcR().a(parama.field_songAlbumLocalPath, com.tencent.mm.cb.a.getDensity(this.AkZ), true);
      continue;
      localObject3 = new cnb();
      ((cnb)localObject3).Id = parama.field_songMediaId;
      ((cnb)localObject3).Msz = parama.field_songAlbumUrl;
      ((cnb)localObject3).MsA = parama.field_songAlbumType;
      ((cnb)localObject3).Url = ((cnb)localObject3).Msz;
      localObject1 = str;
      if (o.DCM != null) {
        localObject1 = o.DCM.b((cnb)localObject3);
      }
    }
    return parama;
  }
  
  private static int gP(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 2131234676;
    }
    return 2131234678;
  }
  
  private static int gR(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 2131234665;
    }
    return 2131234667;
  }
  
  private static int gS(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 2131234662;
    }
    return 2131234663;
  }
  
  private static int h(ViewGroup paramViewGroup)
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
  
  private static int t(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if (paramBoolean2) {
        return 2131234669;
      }
      return 2131234671;
    }
    if (paramBoolean2) {
      return 2131234673;
    }
    return 2131234674;
  }
  
  private static boolean wc(int paramInt)
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
  
  public final void close()
  {
    AppMethodBeat.i(63109);
    if (!this.isInit)
    {
      Log.e("MicroMsg.Music.MMMusicNotification", "MMMusicNotification not init, close err");
      AppMethodBeat.o(63109);
      return;
    }
    if (this.AkZ == null)
    {
      Log.e("MicroMsg.Music.MMMusicNotification", "mmMusicPlayerService is null, return");
      AppMethodBeat.o(63109);
      return;
    }
    Log.i("MicroMsg.Music.MMMusicNotification", "close");
    MMHandlerThread.removeRunnable(this.Alb);
    MMHandlerThread.postToMainThreadDelayed(this.Alb, 1000L);
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
    if (this.AkZ == null)
    {
      Log.e("MicroMsg.Music.MMMusicNotification", "mmMusicPlayerService is null, return");
      AppMethodBeat.o(63107);
      return;
    }
    Log.i("MicroMsg.Music.MMMusicNotification", "play");
    MMHandlerThread.removeRunnable(this.Alb);
    try
    {
      this.AkZ.startForeground(291, a(this.AkZ, parama, true));
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
    if (this.AkZ == null)
    {
      Log.e("MicroMsg.Music.MMMusicNotification", "mmMusicPlayerService is null, return");
      AppMethodBeat.o(63108);
      return;
    }
    Log.i("MicroMsg.Music.MMMusicNotification", "pause");
    MMHandlerThread.removeRunnable(this.Alb);
    this.Ala.notify(291, a(this.AkZ, parama, false));
    AppMethodBeat.o(63108);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.notification.a
 * JD-Core Version:    0.7.0.1
 */