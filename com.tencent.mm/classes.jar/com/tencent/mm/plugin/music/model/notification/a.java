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
import com.tencent.mm.g.a.mg;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.plugin.music.ui.MusicMainUI;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.protocal.protobuf.bzh;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a
{
  boolean cBE;
  MMMusicPlayerService wAS;
  NotificationManager wAT;
  Runnable wAU;
  BroadcastReceiver wAV;
  
  public a()
  {
    AppMethodBeat.i(63105);
    this.cBE = false;
    this.wAU = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(63102);
        ae.i("MicroMsg.Music.MMMusicNotification", "close");
        ar.ay(a.this.wAU);
        a.this.wAS.stopForeground(true);
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
    s.c localc = com.tencent.mm.bq.a.bJ(paramContext, "reminder_channel_id");
    localc.Hl = ((PendingIntent)localObject);
    paramContext = localc.as(com.tencent.mm.bq.a.dzu()).a(b(paramContext, parama, paramBoolean)).build();
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
    ae.i("MicroMsg.Music.MMMusicNotification", "sendMusicPlayerEvent action:%d", new Object[] { Integer.valueOf(paramInt) });
    mg localmg = new mg();
    localmg.dAP.action = paramInt;
    localmg.dAP.state = "";
    localmg.dAP.dAJ = parama.dwG();
    localmg.dAP.appId = "not from app brand appid";
    localmg.dAP.dAR = paramBoolean;
    com.tencent.mm.sdk.b.a.IvT.a(localmg, Looper.getMainLooper());
    AppMethodBeat.o(63106);
  }
  
  private RemoteViews b(Context paramContext, com.tencent.mm.plugin.music.model.e.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(63111);
    String str = parama.field_songName;
    Object localObject2 = parama.field_songSinger;
    Object localObject1 = localObject2;
    if (!bu.isNullOrNil(parama.field_songAlbum)) {
      localObject1 = (String)localObject2 + parama.field_songAlbum;
    }
    localObject2 = e(parama);
    parama = new RemoteViews(paramContext.getPackageName(), 2131495265);
    label112:
    boolean bool;
    if (localObject2 != null)
    {
      parama.setImageViewBitmap(2131302607, (Bitmap)localObject2);
      if (bu.isNullOrNil(str)) {
        break label393;
      }
      parama.setViewVisibility(2131302613, 0);
      parama.setTextViewText(2131302613, str);
      if (bu.isNullOrNil((String)localObject1)) {
        break label404;
      }
      parama.setViewVisibility(2131302609, 0);
      parama.setTextViewText(2131302609, (CharSequence)localObject1);
      label135:
      bool = sg(dm(this.wAS));
      localObject1 = new Intent("com.tencent.mm.Intent.ACTION_MMMUSIC_NOTIFICATION_CLICK");
      ((Intent)localObject1).putExtra("mm_music_notification_action_key", "mm_music_notification_action_pre");
      localObject1 = PendingIntent.getBroadcast(paramContext, 0, (Intent)localObject1, 134217728);
      parama.setImageViewResource(2131302612, fS(bool));
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
      parama.setImageViewResource(2131302610, fU(bool));
      parama.setOnClickPendingIntent(2131302610, (PendingIntent)localObject1);
      localObject1 = new Intent("com.tencent.mm.Intent.ACTION_MMMUSIC_NOTIFICATION_CLICK");
      ((Intent)localObject1).putExtra("mm_music_notification_action_key", "mm_music_notification_action_close");
      paramContext = PendingIntent.getBroadcast(paramContext, 3, (Intent)localObject1, 134217728);
      parama.setImageViewResource(2131302608, fV(bool));
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
    Object localObject = com.tencent.mm.bq.a.bJ(paramContext, "reminder_channel_id").build().contentView;
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
      ae.e("MicroMsg.Music.MMMusicNotification", "music is null, return");
      AppMethodBeat.o(63112);
      return null;
    }
    ae.i("MicroMsg.Music.MMMusicNotification", "music.field_musicType %d", new Object[] { Integer.valueOf(parama.field_musicType) });
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
        ae.printErrStackTrace("MicroMsg.Music.MMMusicNotification", localException, "get bitmap", new Object[0]);
        Object localObject2 = str;
        continue;
        localObject2 = q.aJb().Gf(parama.field_songAlbumUrl);
        if (localObject2 != null) {
          continue;
        }
        str = com.tencent.mm.plugin.music.h.b.bF(parama.field_musicId, false);
        Object localObject3 = new c.a();
        ((c.a)localObject3).hgD = com.tencent.mm.plugin.music.h.b.bF(parama.field_musicId, false);
        ((c.a)localObject3).igk = true;
        ((c.a)localObject3).dh(com.tencent.mm.cb.a.ax(this.wAS, 2131166662), com.tencent.mm.cb.a.ax(this.wAS, 2131166661));
        ((c.a)localObject3).igi = true;
        q.aJb().a(parama.field_songAlbumUrl, ((c.a)localObject3).aJu(), new com.tencent.mm.av.a.c.d()
        {
          public final void eM(boolean paramAnonymousVarArgs)
          {
            AppMethodBeat.i(63104);
            ae.i("MicroMsg.Music.MMMusicNotification", "music.field_songAlbumUrl:%s, success:%b", new Object[] { parama.field_songAlbumUrl, Boolean.valueOf(paramAnonymousVarArgs) });
            if (paramAnonymousVarArgs)
            {
              Bitmap localBitmap = h.decodeFile(str, null);
              if (localBitmap == null)
              {
                ae.e("MicroMsg.Music.MMMusicNotification", "bitmap is null, return");
                AppMethodBeat.o(63104);
                return;
              }
              q.aJb().h(parama.field_songAlbumUrl, localBitmap);
              a.this.wAS.refresh();
            }
            AppMethodBeat.o(63104);
          }
        });
        parama = h.a((Bitmap)localObject2, false, 12.0F, false);
        AppMethodBeat.o(63112);
      }
      if (localObject1 == null) {
        continue;
      }
      parama = h.a((Bitmap)localObject1, false, 12.0F, false);
      AppMethodBeat.o(63112);
      return parama;
      localObject1 = q.aIX().b(parama.field_songAlbumLocalPath, com.tencent.mm.cb.a.getDensity(this.wAS), true);
      continue;
      localObject1 = q.aIX().a(parama.field_songAlbumLocalPath, com.tencent.mm.cb.a.getDensity(this.wAS), true);
      continue;
      localObject3 = new bzh();
      ((bzh)localObject3).Id = parama.field_songMediaId;
      ((bzh)localObject3).Hmj = parama.field_songAlbumUrl;
      ((bzh)localObject3).Hmk = parama.field_songAlbumType;
      ((bzh)localObject3).Url = ((bzh)localObject3).Hmj;
      localObject1 = str;
      if (o.zsv != null) {
        localObject1 = o.zsv.a((bzh)localObject3);
      }
    }
    return parama;
  }
  
  private static int fS(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 2131233852;
    }
    return 2131233854;
  }
  
  private static int fU(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 2131233841;
    }
    return 2131233843;
  }
  
  private static int fV(boolean paramBoolean)
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
  
  private static boolean sg(int paramInt)
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
    if (!this.cBE)
    {
      ae.e("MicroMsg.Music.MMMusicNotification", "MMMusicNotification not init, play err");
      AppMethodBeat.o(63107);
      return;
    }
    if (this.wAS == null)
    {
      ae.e("MicroMsg.Music.MMMusicNotification", "mmMusicPlayerService is null, return");
      AppMethodBeat.o(63107);
      return;
    }
    ae.i("MicroMsg.Music.MMMusicNotification", "play");
    ar.ay(this.wAU);
    try
    {
      this.wAS.startForeground(291, a(this.wAS, parama, true));
      AppMethodBeat.o(63107);
      return;
    }
    catch (Exception parama)
    {
      ae.printErrStackTrace("MicroMsg.Music.MMMusicNotification", parama, "", new Object[0]);
      AppMethodBeat.o(63107);
    }
  }
  
  public final void close()
  {
    AppMethodBeat.i(63109);
    if (!this.cBE)
    {
      ae.e("MicroMsg.Music.MMMusicNotification", "MMMusicNotification not init, close err");
      AppMethodBeat.o(63109);
      return;
    }
    if (this.wAS == null)
    {
      ae.e("MicroMsg.Music.MMMusicNotification", "mmMusicPlayerService is null, return");
      AppMethodBeat.o(63109);
      return;
    }
    ae.i("MicroMsg.Music.MMMusicNotification", "close");
    ar.ay(this.wAU);
    ar.o(this.wAU, 1000L);
    AppMethodBeat.o(63109);
  }
  
  public final void d(com.tencent.mm.plugin.music.model.e.a parama)
  {
    AppMethodBeat.i(63108);
    if (!this.cBE)
    {
      ae.e("MicroMsg.Music.MMMusicNotification", "MMMusicNotification not init, pause err");
      AppMethodBeat.o(63108);
      return;
    }
    if (this.wAS == null)
    {
      ae.e("MicroMsg.Music.MMMusicNotification", "mmMusicPlayerService is null, return");
      AppMethodBeat.o(63108);
      return;
    }
    ae.i("MicroMsg.Music.MMMusicNotification", "pause");
    ar.ay(this.wAU);
    this.wAT.notify(291, a(this.wAS, parama, false));
    AppMethodBeat.o(63108);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.notification.a
 * JD-Core Version:    0.7.0.1
 */