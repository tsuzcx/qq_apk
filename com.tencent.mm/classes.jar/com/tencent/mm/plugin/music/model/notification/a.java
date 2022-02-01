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
import com.tencent.mm.g.a.lw;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.plugin.music.ui.MusicMainUI;
import com.tencent.mm.protocal.protobuf.btz;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a
{
  boolean cqf;
  MMMusicPlayerService vfO;
  NotificationManager vfP;
  Runnable vfQ;
  BroadcastReceiver vfR;
  
  public a()
  {
    AppMethodBeat.i(63105);
    this.cqf = false;
    this.vfQ = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(63102);
        ac.i("MicroMsg.Music.MMMusicNotification", "close");
        ap.aB(a.this.vfQ);
        a.this.vfO.stopForeground(true);
        AppMethodBeat.o(63102);
      }
    };
    AppMethodBeat.o(63105);
  }
  
  private Notification a(Context paramContext, com.tencent.mm.plugin.music.model.e.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(63110);
    Object localObject = new Intent(paramContext, MusicMainUI.class);
    ((Intent)localObject).putExtra("key_scene", 5);
    localObject = PendingIntent.getActivity(paramContext, 0, (Intent)localObject, 134217728);
    s.c localc = com.tencent.mm.bq.a.bE(paramContext, "reminder_channel_id");
    localc.Fu = ((PendingIntent)localObject);
    paramContext = localc.as(com.tencent.mm.bq.a.dlN()).a(b(paramContext, parama, paramBoolean)).build();
    AppMethodBeat.o(63110);
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
    ac.i("MicroMsg.Music.MMMusicNotification", "sendMusicPlayerEvent action:%d", new Object[] { Integer.valueOf(paramInt) });
    lw locallw = new lw();
    locallw.dnW.action = paramInt;
    locallw.dnW.state = "";
    locallw.dnW.dnQ = parama.djf();
    locallw.dnW.appId = "not from app brand appid";
    locallw.dnW.dnY = paramBoolean;
    com.tencent.mm.sdk.b.a.GpY.a(locallw, Looper.getMainLooper());
    AppMethodBeat.o(63106);
  }
  
  private RemoteViews b(Context paramContext, com.tencent.mm.plugin.music.model.e.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(63111);
    String str = parama.field_songName;
    Object localObject2 = parama.field_songSinger;
    Object localObject1 = localObject2;
    if (!bs.isNullOrNil(parama.field_songAlbum)) {
      localObject1 = (String)localObject2 + parama.field_songAlbum;
    }
    localObject2 = e(parama);
    parama = new RemoteViews(paramContext.getPackageName(), 2131495265);
    label112:
    boolean bool;
    if (localObject2 != null)
    {
      parama.setImageViewBitmap(2131302607, (Bitmap)localObject2);
      if (bs.isNullOrNil(str)) {
        break label393;
      }
      parama.setViewVisibility(2131302613, 0);
      parama.setTextViewText(2131302613, str);
      if (bs.isNullOrNil((String)localObject1)) {
        break label404;
      }
      parama.setViewVisibility(2131302609, 0);
      parama.setTextViewText(2131302609, (CharSequence)localObject1);
      label135:
      bool = rD(dm(this.vfO));
      localObject1 = new Intent("com.tencent.mm.Intent.ACTION_MMMUSIC_NOTIFICATION_CLICK");
      ((Intent)localObject1).putExtra("mm_music_notification_action_key", "mm_music_notification_action_pre");
      localObject1 = PendingIntent.getBroadcast(paramContext, 0, (Intent)localObject1, 134217728);
      parama.setImageViewResource(2131302612, fP(bool));
      parama.setOnClickPendingIntent(2131302612, (PendingIntent)localObject1);
      localObject1 = new Intent("com.tencent.mm.Intent.ACTION_MMMUSIC_NOTIFICATION_CLICK");
      if (!paramBoolean) {
        break label415;
      }
      ((Intent)localObject1).putExtra("mm_music_notification_action_key", "mm_music_notification_action_pause");
    }
    for (;;)
    {
      localObject1 = PendingIntent.getBroadcast(paramContext, 1, (Intent)localObject1, 134217728);
      parama.setImageViewResource(2131302611, t(paramBoolean, bool));
      parama.setOnClickPendingIntent(2131302611, (PendingIntent)localObject1);
      localObject1 = new Intent("com.tencent.mm.Intent.ACTION_MMMUSIC_NOTIFICATION_CLICK");
      ((Intent)localObject1).putExtra("mm_music_notification_action_key", "mm_music_notification_action_next");
      localObject1 = PendingIntent.getBroadcast(paramContext, 2, (Intent)localObject1, 134217728);
      parama.setImageViewResource(2131302610, fR(bool));
      parama.setOnClickPendingIntent(2131302610, (PendingIntent)localObject1);
      localObject1 = new Intent("com.tencent.mm.Intent.ACTION_MMMUSIC_NOTIFICATION_CLICK");
      ((Intent)localObject1).putExtra("mm_music_notification_action_key", "mm_music_notification_action_close");
      paramContext = PendingIntent.getBroadcast(paramContext, 3, (Intent)localObject1, 134217728);
      parama.setImageViewResource(2131302608, fS(bool));
      parama.setOnClickPendingIntent(2131302608, paramContext);
      AppMethodBeat.o(63111);
      return parama;
      parama.setImageViewResource(2131302607, 2131231880);
      break;
      label393:
      parama.setViewVisibility(2131302613, 8);
      break label112;
      label404:
      parama.setViewVisibility(2131302609, 8);
      break label135;
      label415:
      ((Intent)localObject1).putExtra("mm_music_notification_action_key", "mm_music_notification_action_play");
    }
  }
  
  private static int dm(Context paramContext)
  {
    AppMethodBeat.i(63113);
    Object localObject = com.tencent.mm.bq.a.bE(paramContext, "reminder_channel_id").build().contentView;
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
    i = g(paramContext);
    AppMethodBeat.o(63113);
    return i;
  }
  
  private Bitmap e(final com.tencent.mm.plugin.music.model.e.a parama)
  {
    final String str = null;
    AppMethodBeat.i(63112);
    if (parama == null)
    {
      ac.e("MicroMsg.Music.MMMusicNotification", "music is null, return");
      AppMethodBeat.o(63112);
      return null;
    }
    ac.i("MicroMsg.Music.MMMusicNotification", "music.field_musicType %d", new Object[] { Integer.valueOf(parama.field_musicType) });
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
        ac.printErrStackTrace("MicroMsg.Music.MMMusicNotification", localException, "get bitmap", new Object[0]);
        Object localObject2 = str;
        continue;
        localObject2 = com.tencent.mm.av.o.aFB().Cz(parama.field_songAlbumUrl);
        if (localObject2 != null) {
          continue;
        }
        str = com.tencent.mm.plugin.music.h.b.bu(parama.field_musicId, false);
        Object localObject3 = new c.a();
        ((c.a)localObject3).gKe = com.tencent.mm.plugin.music.h.b.bu(parama.field_musicId, false);
        ((c.a)localObject3).hKx = true;
        ((c.a)localObject3).de(com.tencent.mm.cc.a.au(this.vfO, 2131166662), com.tencent.mm.cc.a.au(this.vfO, 2131166661));
        ((c.a)localObject3).hKv = true;
        com.tencent.mm.av.o.aFB().a(parama.field_songAlbumUrl, ((c.a)localObject3).aFT(), new com.tencent.mm.av.a.c.d()
        {
          public final void eI(boolean paramAnonymousVarArgs)
          {
            AppMethodBeat.i(63104);
            ac.i("MicroMsg.Music.MMMusicNotification", "music.field_songAlbumUrl:%s, success:%b", new Object[] { parama.field_songAlbumUrl, Boolean.valueOf(paramAnonymousVarArgs) });
            if (paramAnonymousVarArgs)
            {
              Bitmap localBitmap = f.decodeFile(str, null);
              if (localBitmap == null)
              {
                ac.e("MicroMsg.Music.MMMusicNotification", "bitmap is null, return");
                AppMethodBeat.o(63104);
                return;
              }
              com.tencent.mm.av.o.aFB().h(parama.field_songAlbumUrl, localBitmap);
              a.this.vfO.refresh();
            }
            AppMethodBeat.o(63104);
          }
        });
        parama = f.a((Bitmap)localObject2, false, 12.0F, false);
        AppMethodBeat.o(63112);
      }
      if (localObject1 == null) {
        continue;
      }
      parama = f.a((Bitmap)localObject1, false, 12.0F, false);
      AppMethodBeat.o(63112);
      return parama;
      localObject1 = com.tencent.mm.av.o.aFx().b(parama.field_songAlbumLocalPath, com.tencent.mm.cc.a.getDensity(this.vfO), true);
      continue;
      localObject1 = com.tencent.mm.av.o.aFx().a(parama.field_songAlbumLocalPath, com.tencent.mm.cc.a.getDensity(this.vfO), true);
      continue;
      localObject3 = new btz();
      ((btz)localObject3).Id = parama.field_songMediaId;
      ((btz)localObject3).Fjh = parama.field_songAlbumUrl;
      ((btz)localObject3).Fji = parama.field_songAlbumType;
      ((btz)localObject3).Url = ((btz)localObject3).Fjh;
      localObject1 = str;
      if (com.tencent.mm.plugin.sns.b.o.xMa != null) {
        localObject1 = com.tencent.mm.plugin.sns.b.o.xMa.a((btz)localObject3);
      }
    }
    return parama;
  }
  
  private static int fP(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 2131233852;
    }
    return 2131233854;
  }
  
  private static int fR(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 2131233841;
    }
    return 2131233843;
  }
  
  private static int fS(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 2131233838;
    }
    return 2131233839;
  }
  
  private static int g(ViewGroup paramViewGroup)
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
  
  private static boolean rD(int paramInt)
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
  
  private static int t(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if (paramBoolean2) {
        return 2131233845;
      }
      return 2131233847;
    }
    if (paramBoolean2) {
      return 2131233849;
    }
    return 2131233850;
  }
  
  public final void c(com.tencent.mm.plugin.music.model.e.a parama)
  {
    AppMethodBeat.i(63107);
    if (!this.cqf)
    {
      ac.e("MicroMsg.Music.MMMusicNotification", "MMMusicNotification not init, play err");
      AppMethodBeat.o(63107);
      return;
    }
    if (this.vfO == null)
    {
      ac.e("MicroMsg.Music.MMMusicNotification", "mmMusicPlayerService is null, return");
      AppMethodBeat.o(63107);
      return;
    }
    ac.i("MicroMsg.Music.MMMusicNotification", "play");
    ap.aB(this.vfQ);
    try
    {
      this.vfO.startForeground(291, a(this.vfO, parama, true));
      AppMethodBeat.o(63107);
      return;
    }
    catch (Exception parama)
    {
      ac.printErrStackTrace("MicroMsg.Music.MMMusicNotification", parama, "", new Object[0]);
      AppMethodBeat.o(63107);
    }
  }
  
  public final void close()
  {
    AppMethodBeat.i(63109);
    if (!this.cqf)
    {
      ac.e("MicroMsg.Music.MMMusicNotification", "MMMusicNotification not init, close err");
      AppMethodBeat.o(63109);
      return;
    }
    if (this.vfO == null)
    {
      ac.e("MicroMsg.Music.MMMusicNotification", "mmMusicPlayerService is null, return");
      AppMethodBeat.o(63109);
      return;
    }
    ac.i("MicroMsg.Music.MMMusicNotification", "close");
    ap.aB(this.vfQ);
    ap.n(this.vfQ, 1000L);
    AppMethodBeat.o(63109);
  }
  
  public final void d(com.tencent.mm.plugin.music.model.e.a parama)
  {
    AppMethodBeat.i(63108);
    if (!this.cqf)
    {
      ac.e("MicroMsg.Music.MMMusicNotification", "MMMusicNotification not init, pause err");
      AppMethodBeat.o(63108);
      return;
    }
    if (this.vfO == null)
    {
      ac.e("MicroMsg.Music.MMMusicNotification", "mmMusicPlayerService is null, return");
      AppMethodBeat.o(63108);
      return;
    }
    ac.i("MicroMsg.Music.MMMusicNotification", "pause");
    ap.aB(this.vfQ);
    this.vfP.notify(291, a(this.vfO, parama, false));
    AppMethodBeat.o(63108);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.notification.a
 * JD-Core Version:    0.7.0.1
 */