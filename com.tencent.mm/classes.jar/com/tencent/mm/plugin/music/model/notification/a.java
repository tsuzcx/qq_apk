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
import android.support.v4.app.x.c;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RemoteViews;
import android.widget.TextView;
import com.tencent.mm.as.a.a.c.a;
import com.tencent.mm.as.g;
import com.tencent.mm.as.o;
import com.tencent.mm.h.a.jy;
import com.tencent.mm.plugin.music.a.b;
import com.tencent.mm.plugin.music.a.c;
import com.tencent.mm.plugin.music.a.d;
import com.tencent.mm.plugin.music.a.e;
import com.tencent.mm.plugin.music.h.b;
import com.tencent.mm.plugin.music.ui.MusicMainUI;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a
{
  boolean dBn = false;
  MMMusicPlayerService mzL;
  NotificationManager mzM;
  Runnable mzN = new a.1(this);
  BroadcastReceiver mzO;
  
  private static void a(View paramView, List<TextView> paramList)
  {
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      int i = 0;
      while (i < paramView.getChildCount())
      {
        a(paramView.getChildAt(i), paramList);
        i += 1;
      }
    }
    if ((paramView instanceof TextView)) {
      paramList.add((TextView)paramView);
    }
  }
  
  public static void a(com.tencent.mm.plugin.music.model.e.a parama, int paramInt, boolean paramBoolean)
  {
    y.i("MicroMsg.Music.MMMusicNotification", "sendMusicPlayerEvent action:%d", new Object[] { Integer.valueOf(paramInt) });
    jy localjy = new jy();
    localjy.bSA.action = paramInt;
    localjy.bSA.state = "";
    localjy.bSA.bSu = parama.bnB();
    localjy.bSA.appId = "not from app brand appid";
    localjy.bSA.bSC = paramBoolean;
    com.tencent.mm.sdk.b.a.udP.a(localjy, Looper.getMainLooper());
  }
  
  private static int n(ViewGroup paramViewGroup)
  {
    Object localObject = new ArrayList();
    a(paramViewGroup, (List)localObject);
    paramViewGroup = null;
    Iterator localIterator = ((List)localObject).iterator();
    if (localIterator.hasNext())
    {
      localObject = (TextView)localIterator.next();
      if (((TextView)localObject).getTextSize() <= -1.0F) {
        break label68;
      }
      paramViewGroup = (ViewGroup)localObject;
    }
    label68:
    for (;;)
    {
      break;
      if (paramViewGroup != null) {
        return paramViewGroup.getCurrentTextColor();
      }
      return -16777216;
    }
  }
  
  final Notification a(Context paramContext, com.tencent.mm.plugin.music.model.e.a parama, boolean paramBoolean)
  {
    Object localObject1 = new Intent(paramContext, MusicMainUI.class);
    ((Intent)localObject1).putExtra("key_scene", 5);
    localObject1 = PendingIntent.getActivity(paramContext, 0, (Intent)localObject1, 134217728);
    Object localObject2 = new x.c(paramContext, (byte)0);
    ((x.c)localObject2).xz = ((PendingIntent)localObject1);
    x.c localc = ((x.c)localObject2).ah(com.tencent.mm.bq.a.bSL());
    String str = parama.field_songName;
    localObject2 = parama.field_songSinger;
    if (!bk.bl(parama.field_songAlbum)) {
      localObject2 = (String)localObject2 + parama.field_songAlbum;
    }
    label148:
    label175:
    label202:
    label1103:
    for (;;)
    {
      label233:
      int k;
      int j;
      if (parama == null)
      {
        y.e("MicroMsg.Music.MMMusicNotification", "music is null, return");
        parama = null;
        localObject1 = new RemoteViews(paramContext.getPackageName(), a.e.remote_music_notification);
        if (parama == null) {
          break label949;
        }
        ((RemoteViews)localObject1).setImageViewBitmap(a.d.music_notification_album, parama);
        if (bk.bl(str)) {
          break label963;
        }
        ((RemoteViews)localObject1).setViewVisibility(a.d.music_notification_title, 0);
        ((RemoteViews)localObject1).setTextViewText(a.d.music_notification_title, str);
        if (bk.bl((String)localObject2)) {
          break label976;
        }
        ((RemoteViews)localObject1).setViewVisibility(a.d.music_notification_desc, 0);
        ((RemoteViews)localObject1).setTextViewText(a.d.music_notification_desc, (CharSequence)localObject2);
        parama = this.mzL;
        localObject2 = new x.c(parama, (byte)0).build().contentView;
        if (localObject2 != null) {
          break label989;
        }
        i = -16777216;
        k = i | 0xFF000000;
        i = Color.red(-16777216) - Color.red(k);
        j = Color.green(-16777216) - Color.green(k);
        k = Color.blue(-16777216) - Color.blue(k);
        if (Math.sqrt(k * k + (i * i + j * j)) >= 180.0D) {
          break label1046;
        }
        j = 1;
        parama = new Intent("com.tencent.mm.Intent.ACTION_MMMUSIC_NOTIFICATION_CLICK");
        parama.putExtra("mm_music_notification_action_key", "mm_music_notification_action_pre");
        parama = PendingIntent.getBroadcast(paramContext, 0, parama, 134217728);
        k = a.d.music_notification_pre;
        if (j == 0) {
          break label1052;
        }
        i = a.c.remote_notification_pre_dark;
        label356:
        ((RemoteViews)localObject1).setImageViewResource(k, i);
        ((RemoteViews)localObject1).setOnClickPendingIntent(a.d.music_notification_pre, parama);
        parama = new Intent("com.tencent.mm.Intent.ACTION_MMMUSIC_NOTIFICATION_CLICK");
        if (!paramBoolean) {
          break label1060;
        }
        parama.putExtra("mm_music_notification_action_key", "mm_music_notification_action_pause");
        parama = PendingIntent.getBroadcast(paramContext, 1, parama, 134217728);
        k = a.d.music_notification_pause;
        if (!paramBoolean) {
          break label1082;
        }
        if (j == 0) {
          break label1074;
        }
        i = a.c.remote_notification_pause_dark;
        ((RemoteViews)localObject1).setImageViewResource(k, i);
        ((RemoteViews)localObject1).setOnClickPendingIntent(a.d.music_notification_pause, parama);
        parama = new Intent("com.tencent.mm.Intent.ACTION_MMMUSIC_NOTIFICATION_CLICK");
        parama.putExtra("mm_music_notification_action_key", "mm_music_notification_action_next");
        parama = PendingIntent.getBroadcast(paramContext, 2, parama, 134217728);
        k = a.d.music_notification_next;
        if (j == 0) {
          break label1103;
        }
        i = a.c.remote_notification_next_dark;
        label492:
        ((RemoteViews)localObject1).setImageViewResource(k, i);
        ((RemoteViews)localObject1).setOnClickPendingIntent(a.d.music_notification_next, parama);
        parama = new Intent("com.tencent.mm.Intent.ACTION_MMMUSIC_NOTIFICATION_CLICK");
        parama.putExtra("mm_music_notification_action_key", "mm_music_notification_action_close");
        paramContext = PendingIntent.getBroadcast(paramContext, 3, parama, 134217728);
        k = a.d.music_notification_close;
        if (j == 0) {
          break label1111;
        }
      }
      label976:
      label1111:
      for (int i = a.c.remote_notification_close_dark;; i = a.c.remote_notification_close_light)
      {
        ((RemoteViews)localObject1).setImageViewResource(k, i);
        ((RemoteViews)localObject1).setOnClickPendingIntent(a.d.music_notification_close, paramContext);
        localc.yb.contentView = ((RemoteViews)localObject1);
        return localc.build();
        Object localObject3 = null;
        y.i("MicroMsg.Music.MMMusicNotification", "music.field_musicType %d", new Object[] { Integer.valueOf(parama.field_musicType) });
        localObject1 = localObject3;
        switch (parama.field_musicType)
        {
        default: 
          localObject1 = localObject3;
        }
        for (;;)
        {
          localObject3 = localObject1;
          if (localObject1 == null)
          {
            localObject1 = o.ON().mr(parama.field_songAlbumUrl);
            localObject3 = localObject1;
            if (localObject1 == null)
            {
              localObject3 = b.aO(parama.field_musicId, false);
              localObject4 = new c.a();
              ((c.a)localObject4).erh = b.aO(parama.field_musicId, false);
              ((c.a)localObject4).erf = true;
              ((c.a)localObject4).bn(com.tencent.mm.cb.a.aa(this.mzL, a.b.notification_large_icon_width), com.tencent.mm.cb.a.aa(this.mzL, a.b.notification_large_icon_height));
              ((c.a)localObject4).erd = true;
              o.ON().a(parama.field_songAlbumUrl, ((c.a)localObject4).OV(), new a.3(this, parama, (String)localObject3));
              localObject3 = localObject1;
            }
          }
          parama = c.a((Bitmap)localObject3, false, 12.0F, false);
          break;
          localObject1 = o.OJ().b(parama.field_songAlbumLocalPath, com.tencent.mm.cb.a.getDensity(this.mzL), true);
          continue;
          localObject1 = o.OJ().a(parama.field_songAlbumLocalPath, com.tencent.mm.cb.a.getDensity(this.mzL), true);
          continue;
          Object localObject4 = new awd();
          ((awd)localObject4).lsK = parama.field_songMediaId;
          ((awd)localObject4).trP = parama.field_songAlbumUrl;
          ((awd)localObject4).trQ = parama.field_songAlbumType;
          ((awd)localObject4).kSC = ((awd)localObject4).trP;
          localObject1 = localObject3;
          if (n.omC != null) {
            localObject1 = n.omC.b((awd)localObject4);
          }
        }
        ((RemoteViews)localObject1).setImageViewResource(a.d.music_notification_album, a.c.default_icon_music);
        break label148;
        ((RemoteViews)localObject1).setViewVisibility(a.d.music_notification_title, 8);
        break label175;
        ((RemoteViews)localObject1).setViewVisibility(a.d.music_notification_desc, 8);
        break label202;
        label989:
        i = ((RemoteViews)localObject2).getLayoutId();
        parama = (ViewGroup)LayoutInflater.from(parama).inflate(i, null);
        localObject2 = (TextView)parama.findViewById(16908310);
        if (localObject2 != null)
        {
          i = ((TextView)localObject2).getCurrentTextColor();
          break label233;
        }
        i = n(parama);
        break label233;
        j = 0;
        break label310;
        i = a.c.remote_notification_pre_light;
        break label356;
        parama.putExtra("mm_music_notification_action_key", "mm_music_notification_action_play");
        break label400;
        i = a.c.remote_notification_pause_light;
        break label428;
        if (j != 0)
        {
          i = a.c.remote_notification_play_dark;
          break label428;
        }
        i = a.c.remote_notification_play_light;
        break label428;
        i = a.c.remote_notification_next_light;
        break label492;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.notification.a
 * JD-Core Version:    0.7.0.1
 */