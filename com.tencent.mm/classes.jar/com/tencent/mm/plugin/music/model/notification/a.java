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
import com.tencent.mm.at.a.a.c.a;
import com.tencent.mm.at.g;
import com.tencent.mm.at.o;
import com.tencent.mm.g.a.ki;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.plugin.music.ui.MusicMainUI;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a
{
  boolean bRB;
  MMMusicPlayerService oZR;
  NotificationManager oZS;
  Runnable oZT;
  BroadcastReceiver oZU;
  
  public a()
  {
    AppMethodBeat.i(104974);
    this.bRB = false;
    this.oZT = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(104971);
        ab.i("MicroMsg.Music.MMMusicNotification", "close");
        al.ae(a.this.oZT);
        a.this.oZR.stopForeground(true);
        AppMethodBeat.o(104971);
      }
    };
    AppMethodBeat.o(104974);
  }
  
  private static boolean Ak(int paramInt)
  {
    AppMethodBeat.i(104985);
    int j = paramInt | 0xFF000000;
    paramInt = Color.red(-16777216) - Color.red(j);
    int i = Color.green(-16777216) - Color.green(j);
    j = Color.blue(-16777216) - Color.blue(j);
    if (Math.sqrt(j * j + (paramInt * paramInt + i * i)) < 180.0D)
    {
      AppMethodBeat.o(104985);
      return true;
    }
    AppMethodBeat.o(104985);
    return false;
  }
  
  private static int D(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if (paramBoolean2) {
        return 2130840156;
      }
      return 2130840158;
    }
    if (paramBoolean2) {
      return 2130840160;
    }
    return 2130840161;
  }
  
  private Notification a(Context paramContext, com.tencent.mm.plugin.music.model.e.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(104979);
    Object localObject = new Intent(paramContext, MusicMainUI.class);
    ((Intent)localObject).putExtra("key_scene", 5);
    localObject = PendingIntent.getActivity(paramContext, 0, (Intent)localObject, 134217728);
    s.c localc = com.tencent.mm.bp.a.br(paramContext, "reminder_channel_id");
    localc.ya = ((PendingIntent)localObject);
    paramContext = localc.Y(com.tencent.mm.bp.a.bYt()).a(b(paramContext, parama, paramBoolean)).build();
    AppMethodBeat.o(104979);
    return paramContext;
  }
  
  private static void a(View paramView, List<TextView> paramList)
  {
    AppMethodBeat.i(104984);
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      int i = 0;
      while (i < paramView.getChildCount())
      {
        a(paramView.getChildAt(i), paramList);
        i += 1;
      }
      AppMethodBeat.o(104984);
      return;
    }
    if ((paramView instanceof TextView)) {
      paramList.add((TextView)paramView);
    }
    AppMethodBeat.o(104984);
  }
  
  public static void a(com.tencent.mm.plugin.music.model.e.a parama, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(104975);
    ab.i("MicroMsg.Music.MMMusicNotification", "sendMusicPlayerEvent action:%d", new Object[] { Integer.valueOf(paramInt) });
    ki localki = new ki();
    localki.cAc.action = paramInt;
    localki.cAc.state = "";
    localki.cAc.czW = parama.bVY();
    localki.cAc.appId = "not from app brand appid";
    localki.cAc.cAe = paramBoolean;
    com.tencent.mm.sdk.b.a.ymk.a(localki, Looper.getMainLooper());
    AppMethodBeat.o(104975);
  }
  
  private RemoteViews b(Context paramContext, com.tencent.mm.plugin.music.model.e.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(104980);
    String str = parama.field_songName;
    Object localObject2 = parama.field_songSinger;
    Object localObject1 = localObject2;
    if (!bo.isNullOrNil(parama.field_songAlbum)) {
      localObject1 = (String)localObject2 + parama.field_songAlbum;
    }
    localObject2 = e(parama);
    parama = new RemoteViews(paramContext.getPackageName(), 2130970581);
    label116:
    boolean bool;
    if (localObject2 != null)
    {
      parama.setImageViewBitmap(2131827359, (Bitmap)localObject2);
      if (bo.isNullOrNil(str)) {
        break label400;
      }
      parama.setViewVisibility(2131827360, 0);
      parama.setTextViewText(2131827360, str);
      if (bo.isNullOrNil((String)localObject1)) {
        break label412;
      }
      parama.setViewVisibility(2131827361, 0);
      parama.setTextViewText(2131827361, (CharSequence)localObject1);
      label141:
      bool = Ak(eG(this.oZR));
      localObject1 = new Intent("com.tencent.mm.Intent.ACTION_MMMUSIC_NOTIFICATION_CLICK");
      ((Intent)localObject1).putExtra("mm_music_notification_action_key", "mm_music_notification_action_pre");
      localObject1 = PendingIntent.getBroadcast(paramContext, 0, (Intent)localObject1, 134217728);
      parama.setImageViewResource(2131827362, jM(bool));
      parama.setOnClickPendingIntent(2131827362, (PendingIntent)localObject1);
      localObject1 = new Intent("com.tencent.mm.Intent.ACTION_MMMUSIC_NOTIFICATION_CLICK");
      if (!paramBoolean) {
        break label424;
      }
      ((Intent)localObject1).putExtra("mm_music_notification_action_key", "mm_music_notification_action_pause");
    }
    for (;;)
    {
      localObject1 = PendingIntent.getBroadcast(paramContext, 1, (Intent)localObject1, 134217728);
      parama.setImageViewResource(2131827363, D(paramBoolean, bool));
      parama.setOnClickPendingIntent(2131827363, (PendingIntent)localObject1);
      localObject1 = new Intent("com.tencent.mm.Intent.ACTION_MMMUSIC_NOTIFICATION_CLICK");
      ((Intent)localObject1).putExtra("mm_music_notification_action_key", "mm_music_notification_action_next");
      localObject1 = PendingIntent.getBroadcast(paramContext, 2, (Intent)localObject1, 134217728);
      parama.setImageViewResource(2131827364, jN(bool));
      parama.setOnClickPendingIntent(2131827364, (PendingIntent)localObject1);
      localObject1 = new Intent("com.tencent.mm.Intent.ACTION_MMMUSIC_NOTIFICATION_CLICK");
      ((Intent)localObject1).putExtra("mm_music_notification_action_key", "mm_music_notification_action_close");
      paramContext = PendingIntent.getBroadcast(paramContext, 3, (Intent)localObject1, 134217728);
      parama.setImageViewResource(2131827365, jO(bool));
      parama.setOnClickPendingIntent(2131827365, paramContext);
      AppMethodBeat.o(104980);
      return parama;
      parama.setImageViewResource(2131827359, 2130838497);
      break;
      label400:
      parama.setViewVisibility(2131827360, 8);
      break label116;
      label412:
      parama.setViewVisibility(2131827361, 8);
      break label141;
      label424:
      ((Intent)localObject1).putExtra("mm_music_notification_action_key", "mm_music_notification_action_play");
    }
  }
  
  private Bitmap e(com.tencent.mm.plugin.music.model.e.a parama)
  {
    String str = null;
    AppMethodBeat.i(104981);
    if (parama == null)
    {
      ab.e("MicroMsg.Music.MMMusicNotification", "music is null, return");
      AppMethodBeat.o(104981);
      return null;
    }
    ab.i("MicroMsg.Music.MMMusicNotification", "music.field_musicType %d", new Object[] { Integer.valueOf(parama.field_musicType) });
    Object localObject1 = str;
    switch (parama.field_musicType)
    {
    default: 
      localObject1 = str;
    }
    Object localObject2;
    while (localObject1 != null)
    {
      parama = com.tencent.mm.sdk.platformtools.d.a((Bitmap)localObject1, false, 12.0F, false);
      AppMethodBeat.o(104981);
      return parama;
      localObject1 = o.ahC().b(parama.field_songAlbumLocalPath, com.tencent.mm.cb.a.getDensity(this.oZR), true);
      continue;
      localObject1 = o.ahC().a(parama.field_songAlbumLocalPath, com.tencent.mm.cb.a.getDensity(this.oZR), true);
      continue;
      localObject2 = new bcs();
      ((bcs)localObject2).Id = parama.field_songMediaId;
      ((bcs)localObject2).xrS = parama.field_songAlbumUrl;
      ((bcs)localObject2).xrT = parama.field_songAlbumType;
      ((bcs)localObject2).Url = ((bcs)localObject2).xrS;
      localObject1 = str;
      if (n.raQ != null) {
        localObject1 = n.raQ.b((bcs)localObject2);
      }
    }
    localObject1 = o.ahG().tx(parama.field_songAlbumUrl);
    if (localObject1 == null)
    {
      str = com.tencent.mm.plugin.music.h.b.be(parama.field_musicId, false);
      localObject2 = new c.a();
      ((c.a)localObject2).eNO = com.tencent.mm.plugin.music.h.b.be(parama.field_musicId, false);
      ((c.a)localObject2).eNM = true;
      ((c.a)localObject2).cx(com.tencent.mm.cb.a.ao(this.oZR, 2131428609), com.tencent.mm.cb.a.ao(this.oZR, 2131428608));
      ((c.a)localObject2).eNK = true;
      o.ahG().a(parama.field_songAlbumUrl, ((c.a)localObject2).ahY(), new a.3(this, parama, str));
    }
    parama = com.tencent.mm.sdk.platformtools.d.a((Bitmap)localObject1, false, 12.0F, false);
    AppMethodBeat.o(104981);
    return parama;
  }
  
  private static int eG(Context paramContext)
  {
    AppMethodBeat.i(104982);
    Object localObject = com.tencent.mm.bp.a.br(paramContext, "reminder_channel_id").build().contentView;
    if (localObject == null)
    {
      AppMethodBeat.o(104982);
      return -16777216;
    }
    int i = ((RemoteViews)localObject).getLayoutId();
    paramContext = (ViewGroup)LayoutInflater.from(paramContext).inflate(i, null);
    localObject = (TextView)paramContext.findViewById(16908310);
    if (localObject != null)
    {
      i = ((TextView)localObject).getCurrentTextColor();
      AppMethodBeat.o(104982);
      return i;
    }
    i = q(paramContext);
    AppMethodBeat.o(104982);
    return i;
  }
  
  private static int jM(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 2130840163;
    }
    return 2130840165;
  }
  
  private static int jN(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 2130840152;
    }
    return 2130840154;
  }
  
  private static int jO(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 2130840149;
    }
    return 2130840150;
  }
  
  private static int q(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(104983);
    Object localObject = new ArrayList();
    a(paramViewGroup, (List)localObject);
    paramViewGroup = null;
    Iterator localIterator = ((List)localObject).iterator();
    if (localIterator.hasNext())
    {
      localObject = (TextView)localIterator.next();
      if (((TextView)localObject).getTextSize() <= -1.0F) {
        break label89;
      }
      paramViewGroup = (ViewGroup)localObject;
    }
    label89:
    for (;;)
    {
      break;
      if (paramViewGroup != null)
      {
        int i = paramViewGroup.getCurrentTextColor();
        AppMethodBeat.o(104983);
        return i;
      }
      AppMethodBeat.o(104983);
      return -16777216;
    }
  }
  
  public final void c(com.tencent.mm.plugin.music.model.e.a parama)
  {
    AppMethodBeat.i(104976);
    if (!this.bRB)
    {
      ab.e("MicroMsg.Music.MMMusicNotification", "MMMusicNotification not init, play err");
      AppMethodBeat.o(104976);
      return;
    }
    if (this.oZR == null)
    {
      ab.e("MicroMsg.Music.MMMusicNotification", "mmMusicPlayerService is null, return");
      AppMethodBeat.o(104976);
      return;
    }
    ab.i("MicroMsg.Music.MMMusicNotification", "play");
    al.ae(this.oZT);
    try
    {
      this.oZR.startForeground(291, a(this.oZR, parama, true));
      AppMethodBeat.o(104976);
      return;
    }
    catch (Exception parama)
    {
      ab.printErrStackTrace("MicroMsg.Music.MMMusicNotification", parama, "", new Object[0]);
      AppMethodBeat.o(104976);
    }
  }
  
  public final void close()
  {
    AppMethodBeat.i(104978);
    if (!this.bRB)
    {
      ab.e("MicroMsg.Music.MMMusicNotification", "MMMusicNotification not init, close err");
      AppMethodBeat.o(104978);
      return;
    }
    if (this.oZR == null)
    {
      ab.e("MicroMsg.Music.MMMusicNotification", "mmMusicPlayerService is null, return");
      AppMethodBeat.o(104978);
      return;
    }
    ab.i("MicroMsg.Music.MMMusicNotification", "close");
    al.ae(this.oZT);
    al.p(this.oZT, 1000L);
    AppMethodBeat.o(104978);
  }
  
  public final void d(com.tencent.mm.plugin.music.model.e.a parama)
  {
    AppMethodBeat.i(104977);
    if (!this.bRB)
    {
      ab.e("MicroMsg.Music.MMMusicNotification", "MMMusicNotification not init, pause err");
      AppMethodBeat.o(104977);
      return;
    }
    if (this.oZR == null)
    {
      ab.e("MicroMsg.Music.MMMusicNotification", "mmMusicPlayerService is null, return");
      AppMethodBeat.o(104977);
      return;
    }
    ab.i("MicroMsg.Music.MMMusicNotification", "pause");
    al.ae(this.oZT);
    this.oZS.notify(291, a(this.oZR, parama, false));
    AppMethodBeat.o(104977);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.notification.a
 * JD-Core Version:    0.7.0.1
 */