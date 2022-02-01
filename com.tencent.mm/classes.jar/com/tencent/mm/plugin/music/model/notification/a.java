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
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.aw.i;
import com.tencent.mm.aw.q;
import com.tencent.mm.g.a.mf;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.plugin.music.ui.MusicMainUI;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.protocal.protobuf.byn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a
{
  boolean cAX;
  MMMusicPlayerService wlj;
  NotificationManager wlk;
  Runnable wll;
  BroadcastReceiver wlm;
  
  public a()
  {
    AppMethodBeat.i(63105);
    this.cAX = false;
    this.wll = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(63102);
        ad.i("MicroMsg.Music.MMMusicNotification", "close");
        aq.aA(a.this.wll);
        a.this.wlj.stopForeground(true);
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
    s.c localc = com.tencent.mm.br.a.bI(paramContext, "reminder_channel_id");
    localc.Hl = ((PendingIntent)localObject);
    paramContext = localc.as(com.tencent.mm.br.a.dwe()).a(b(paramContext, parama, paramBoolean)).build();
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
    ad.i("MicroMsg.Music.MMMusicNotification", "sendMusicPlayerEvent action:%d", new Object[] { Integer.valueOf(paramInt) });
    mf localmf = new mf();
    localmf.dzK.action = paramInt;
    localmf.dzK.state = "";
    localmf.dzK.dzE = parama.dtr();
    localmf.dzK.appId = "not from app brand appid";
    localmf.dzK.dzM = paramBoolean;
    com.tencent.mm.sdk.b.a.IbL.a(localmf, Looper.getMainLooper());
    AppMethodBeat.o(63106);
  }
  
  private RemoteViews b(Context paramContext, com.tencent.mm.plugin.music.model.e.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(63111);
    String str = parama.field_songName;
    Object localObject2 = parama.field_songSinger;
    Object localObject1 = localObject2;
    if (!bt.isNullOrNil(parama.field_songAlbum)) {
      localObject1 = (String)localObject2 + parama.field_songAlbum;
    }
    localObject2 = e(parama);
    parama = new RemoteViews(paramContext.getPackageName(), 2131495265);
    label112:
    boolean bool;
    if (localObject2 != null)
    {
      parama.setImageViewBitmap(2131302607, (Bitmap)localObject2);
      if (bt.isNullOrNil(str)) {
        break label393;
      }
      parama.setViewVisibility(2131302613, 0);
      parama.setTextViewText(2131302613, str);
      if (bt.isNullOrNil((String)localObject1)) {
        break label404;
      }
      parama.setViewVisibility(2131302609, 0);
      parama.setTextViewText(2131302609, (CharSequence)localObject1);
      label135:
      bool = sd(dk(this.wlj));
      localObject1 = new Intent("com.tencent.mm.Intent.ACTION_MMMUSIC_NOTIFICATION_CLICK");
      ((Intent)localObject1).putExtra("mm_music_notification_action_key", "mm_music_notification_action_pre");
      localObject1 = PendingIntent.getBroadcast(paramContext, 0, (Intent)localObject1, 134217728);
      parama.setImageViewResource(2131302612, fT(bool));
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
      parama.setImageViewResource(2131302610, fV(bool));
      parama.setOnClickPendingIntent(2131302610, (PendingIntent)localObject1);
      localObject1 = new Intent("com.tencent.mm.Intent.ACTION_MMMUSIC_NOTIFICATION_CLICK");
      ((Intent)localObject1).putExtra("mm_music_notification_action_key", "mm_music_notification_action_close");
      paramContext = PendingIntent.getBroadcast(paramContext, 3, (Intent)localObject1, 134217728);
      parama.setImageViewResource(2131302608, fW(bool));
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
  
  private static int dk(Context paramContext)
  {
    AppMethodBeat.i(63113);
    Object localObject = com.tencent.mm.br.a.bI(paramContext, "reminder_channel_id").build().contentView;
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
  
  private Bitmap e(final com.tencent.mm.plugin.music.model.e.a parama)
  {
    final String str = null;
    AppMethodBeat.i(63112);
    if (parama == null)
    {
      ad.e("MicroMsg.Music.MMMusicNotification", "music is null, return");
      AppMethodBeat.o(63112);
      return null;
    }
    ad.i("MicroMsg.Music.MMMusicNotification", "music.field_musicType %d", new Object[] { Integer.valueOf(parama.field_musicType) });
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
        ad.printErrStackTrace("MicroMsg.Music.MMMusicNotification", localException, "get bitmap", new Object[0]);
        Object localObject2 = str;
        continue;
        localObject2 = q.aIJ().FD(parama.field_songAlbumUrl);
        if (localObject2 != null) {
          continue;
        }
        str = com.tencent.mm.plugin.music.h.b.bB(parama.field_musicId, false);
        Object localObject3 = new c.a();
        ((c.a)localObject3).hdP = com.tencent.mm.plugin.music.h.b.bB(parama.field_musicId, false);
        ((c.a)localObject3).idr = true;
        ((c.a)localObject3).dh(com.tencent.mm.cc.a.ax(this.wlj, 2131166662), com.tencent.mm.cc.a.ax(this.wlj, 2131166661));
        ((c.a)localObject3).idp = true;
        q.aIJ().a(parama.field_songAlbumUrl, ((c.a)localObject3).aJc(), new com.tencent.mm.aw.a.c.d()
        {
          public final void eK(boolean paramAnonymousVarArgs)
          {
            AppMethodBeat.i(63104);
            ad.i("MicroMsg.Music.MMMusicNotification", "music.field_songAlbumUrl:%s, success:%b", new Object[] { parama.field_songAlbumUrl, Boolean.valueOf(paramAnonymousVarArgs) });
            if (paramAnonymousVarArgs)
            {
              Bitmap localBitmap = com.tencent.mm.sdk.platformtools.g.decodeFile(str, null);
              if (localBitmap == null)
              {
                ad.e("MicroMsg.Music.MMMusicNotification", "bitmap is null, return");
                AppMethodBeat.o(63104);
                return;
              }
              q.aIJ().h(parama.field_songAlbumUrl, localBitmap);
              a.this.wlj.refresh();
            }
            AppMethodBeat.o(63104);
          }
        });
        parama = com.tencent.mm.sdk.platformtools.g.a((Bitmap)localObject2, false, 12.0F, false);
        AppMethodBeat.o(63112);
      }
      if (localObject1 == null) {
        continue;
      }
      parama = com.tencent.mm.sdk.platformtools.g.a((Bitmap)localObject1, false, 12.0F, false);
      AppMethodBeat.o(63112);
      return parama;
      localObject1 = q.aIF().b(parama.field_songAlbumLocalPath, com.tencent.mm.cc.a.getDensity(this.wlj), true);
      continue;
      localObject1 = q.aIF().a(parama.field_songAlbumLocalPath, com.tencent.mm.cc.a.getDensity(this.wlj), true);
      continue;
      localObject3 = new byn();
      ((byn)localObject3).Id = parama.field_songMediaId;
      ((byn)localObject3).GSI = parama.field_songAlbumUrl;
      ((byn)localObject3).GSJ = parama.field_songAlbumType;
      ((byn)localObject3).Url = ((byn)localObject3).GSI;
      localObject1 = str;
      if (o.zbS != null) {
        localObject1 = o.zbS.a((byn)localObject3);
      }
    }
    return parama;
  }
  
  private static int fT(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 2131233852;
    }
    return 2131233854;
  }
  
  private static int fV(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 2131233841;
    }
    return 2131233843;
  }
  
  private static int fW(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 2131233838;
    }
    return 2131233839;
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
  
  private static boolean sd(int paramInt)
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
    if (!this.cAX)
    {
      ad.e("MicroMsg.Music.MMMusicNotification", "MMMusicNotification not init, play err");
      AppMethodBeat.o(63107);
      return;
    }
    if (this.wlj == null)
    {
      ad.e("MicroMsg.Music.MMMusicNotification", "mmMusicPlayerService is null, return");
      AppMethodBeat.o(63107);
      return;
    }
    ad.i("MicroMsg.Music.MMMusicNotification", "play");
    aq.aA(this.wll);
    try
    {
      this.wlj.startForeground(291, a(this.wlj, parama, true));
      AppMethodBeat.o(63107);
      return;
    }
    catch (Exception parama)
    {
      ad.printErrStackTrace("MicroMsg.Music.MMMusicNotification", parama, "", new Object[0]);
      AppMethodBeat.o(63107);
    }
  }
  
  public final void close()
  {
    AppMethodBeat.i(63109);
    if (!this.cAX)
    {
      ad.e("MicroMsg.Music.MMMusicNotification", "MMMusicNotification not init, close err");
      AppMethodBeat.o(63109);
      return;
    }
    if (this.wlj == null)
    {
      ad.e("MicroMsg.Music.MMMusicNotification", "mmMusicPlayerService is null, return");
      AppMethodBeat.o(63109);
      return;
    }
    ad.i("MicroMsg.Music.MMMusicNotification", "close");
    aq.aA(this.wll);
    aq.o(this.wll, 1000L);
    AppMethodBeat.o(63109);
  }
  
  public final void d(com.tencent.mm.plugin.music.model.e.a parama)
  {
    AppMethodBeat.i(63108);
    if (!this.cAX)
    {
      ad.e("MicroMsg.Music.MMMusicNotification", "MMMusicNotification not init, pause err");
      AppMethodBeat.o(63108);
      return;
    }
    if (this.wlj == null)
    {
      ad.e("MicroMsg.Music.MMMusicNotification", "mmMusicPlayerService is null, return");
      AppMethodBeat.o(63108);
      return;
    }
    ad.i("MicroMsg.Music.MMMusicNotification", "pause");
    aq.aA(this.wll);
    this.wlk.notify(291, a(this.wlj, parama, false));
    AppMethodBeat.o(63108);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.notification.a
 * JD-Core Version:    0.7.0.1
 */