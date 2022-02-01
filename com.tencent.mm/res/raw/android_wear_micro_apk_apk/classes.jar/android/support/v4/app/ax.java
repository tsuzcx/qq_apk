package android.support.v4.app;

import android.app.Notification;
import android.app.Notification.Action.Builder;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

final class ax
  implements ap
{
  private RemoteViews gS;
  private RemoteViews gT;
  private RemoteViews gU;
  private int gZ;
  private final Bundle gl = new Bundle();
  private final at hs;
  private final List<Bundle> ht = new ArrayList();
  private final Notification.Builder mBuilder;
  
  ax(at paramat)
  {
    this.hs = paramat;
    Object localObject1;
    Object localObject2;
    label138:
    label158:
    label178:
    PendingIntent localPendingIntent;
    if (Build.VERSION.SDK_INT >= 26)
    {
      this.mBuilder = new Notification.Builder(paramat.mContext, paramat.gV);
      localObject1 = paramat.ha;
      localObject2 = this.mBuilder.setWhen(((Notification)localObject1).when).setSmallIcon(((Notification)localObject1).icon, ((Notification)localObject1).iconLevel).setContent(((Notification)localObject1).contentView).setTicker(((Notification)localObject1).tickerText, paramat.gv).setVibrate(((Notification)localObject1).vibrate).setLights(((Notification)localObject1).ledARGB, ((Notification)localObject1).ledOnMS, ((Notification)localObject1).ledOffMS);
      if ((((Notification)localObject1).flags & 0x2) == 0) {
        break label397;
      }
      bool = true;
      localObject2 = ((Notification.Builder)localObject2).setOngoing(bool);
      if ((((Notification)localObject1).flags & 0x8) == 0) {
        break label402;
      }
      bool = true;
      localObject2 = ((Notification.Builder)localObject2).setOnlyAlertOnce(bool);
      if ((((Notification)localObject1).flags & 0x10) == 0) {
        break label407;
      }
      bool = true;
      localObject2 = ((Notification.Builder)localObject2).setAutoCancel(bool).setDefaults(((Notification)localObject1).defaults).setContentTitle(paramat.gr).setContentText(paramat.gs).setContentInfo(paramat.gx).setContentIntent(paramat.gt).setDeleteIntent(((Notification)localObject1).deleteIntent);
      localPendingIntent = paramat.gu;
      if ((((Notification)localObject1).flags & 0x80) == 0) {
        break label412;
      }
    }
    label397:
    label402:
    label407:
    label412:
    for (boolean bool = true;; bool = false)
    {
      ((Notification.Builder)localObject2).setFullScreenIntent(localPendingIntent, bool).setLargeIcon(paramat.gw).setNumber(paramat.gy).setProgress(paramat.gF, paramat.gG, paramat.gH);
      if (Build.VERSION.SDK_INT < 21) {
        this.mBuilder.setSound(((Notification)localObject1).sound, ((Notification)localObject1).audioStreamType);
      }
      if (Build.VERSION.SDK_INT < 16) {
        break label537;
      }
      this.mBuilder.setSubText(paramat.gD).setUsesChronometer(paramat.gB).setPriority(paramat.gz);
      localObject2 = paramat.gq.iterator();
      while (((Iterator)localObject2).hasNext()) {
        d((ar)((Iterator)localObject2).next());
      }
      this.mBuilder = new Notification.Builder(paramat.mContext);
      break;
      bool = false;
      break label138;
      bool = false;
      break label158;
      bool = false;
      break label178;
    }
    if (paramat.gl != null) {
      this.gl.putAll(paramat.gl);
    }
    if (Build.VERSION.SDK_INT < 20)
    {
      if (paramat.gL) {
        this.gl.putBoolean("android.support.localOnly", true);
      }
      if (paramat.gI != null)
      {
        this.gl.putString("android.support.groupKey", paramat.gI);
        if (!paramat.gJ) {
          break label754;
        }
        this.gl.putBoolean("android.support.isGroupSummary", true);
      }
    }
    for (;;)
    {
      if (paramat.gK != null) {
        this.gl.putString("android.support.sortKey", paramat.gK);
      }
      this.gS = paramat.gS;
      this.gT = paramat.gT;
      label537:
      if (Build.VERSION.SDK_INT >= 19)
      {
        this.mBuilder.setShowWhen(paramat.gA);
        if ((Build.VERSION.SDK_INT < 21) && (paramat.hb != null) && (!paramat.hb.isEmpty())) {
          this.gl.putStringArray("android.people", (String[])paramat.hb.toArray(new String[paramat.hb.size()]));
        }
      }
      if (Build.VERSION.SDK_INT >= 20)
      {
        this.mBuilder.setLocalOnly(paramat.gL).setGroup(paramat.gI).setGroupSummary(paramat.gJ).setSortKey(paramat.gK);
        this.gZ = paramat.gZ;
      }
      if (Build.VERSION.SDK_INT < 21) {
        break label776;
      }
      this.mBuilder.setCategory(paramat.gO).setColor(paramat.gP).setVisibility(paramat.gQ).setPublicVersion(paramat.gR).setSound(((Notification)localObject1).sound, ((Notification)localObject1).audioAttributes);
      localObject1 = paramat.hb.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        this.mBuilder.addPerson((String)localObject2);
      }
      label754:
      this.gl.putBoolean("android.support.useSideChannel", true);
    }
    this.gU = paramat.gU;
    label776:
    if (Build.VERSION.SDK_INT >= 24)
    {
      this.mBuilder.setExtras(paramat.gl).setRemoteInputHistory(paramat.gE);
      if (paramat.gS != null) {
        this.mBuilder.setCustomContentView(paramat.gS);
      }
      if (paramat.gT != null) {
        this.mBuilder.setCustomBigContentView(paramat.gT);
      }
      if (paramat.gU != null) {
        this.mBuilder.setCustomHeadsUpContentView(paramat.gU);
      }
    }
    if (Build.VERSION.SDK_INT >= 26)
    {
      this.mBuilder.setBadgeIconType(paramat.gW).setShortcutId(paramat.gX).setTimeoutAfter(paramat.gY).setGroupAlertBehavior(paramat.gZ);
      if (paramat.gN) {
        this.mBuilder.setColorized(paramat.gM);
      }
      if (!TextUtils.isEmpty(paramat.gV)) {
        this.mBuilder.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
      }
    }
  }
  
  private static void b(Notification paramNotification)
  {
    paramNotification.sound = null;
    paramNotification.vibrate = null;
    paramNotification.defaults &= 0xFFFFFFFE;
    paramNotification.defaults &= 0xFFFFFFFD;
  }
  
  private void d(ar paramar)
  {
    if (Build.VERSION.SDK_INT >= 20)
    {
      localBuilder = new Notification.Action.Builder(paramar.icon, paramar.title, paramar.actionIntent);
      if (paramar.aK() != null)
      {
        localObject = ba.b(paramar.aK());
        j = localObject.length;
        i = 0;
        while (i < j)
        {
          localBuilder.addRemoteInput(localObject[i]);
          i += 1;
        }
      }
      if (paramar.gl != null)
      {
        localObject = new Bundle(paramar.gl);
        ((Bundle)localObject).putBoolean("android.support.allowGeneratedReplies", paramar.getAllowGeneratedReplies());
        if (Build.VERSION.SDK_INT >= 24) {
          localBuilder.setAllowGeneratedReplies(paramar.getAllowGeneratedReplies());
        }
        localBuilder.addExtras((Bundle)localObject);
        this.mBuilder.addAction(localBuilder.build());
      }
    }
    while (Build.VERSION.SDK_INT < 16) {
      for (;;)
      {
        Notification.Action.Builder localBuilder;
        int j;
        int i;
        return;
        Object localObject = new Bundle();
      }
    }
    this.ht.add(ay.a(this.mBuilder, paramar));
  }
  
  public final Notification.Builder aJ()
  {
    return this.mBuilder;
  }
  
  public final Notification build()
  {
    av localav = this.hs.gC;
    if (localav != null) {
      localav.a(this);
    }
    Object localObject1;
    if (Build.VERSION.SDK_INT >= 26) {
      localObject1 = this.mBuilder.build();
    }
    for (;;)
    {
      if (this.hs.gS != null) {
        ((Notification)localObject1).contentView = this.hs.gS;
      }
      int i = Build.VERSION.SDK_INT;
      i = Build.VERSION.SDK_INT;
      if ((Build.VERSION.SDK_INT >= 16) && (localav != null)) {
        aq.a((Notification)localObject1);
      }
      return localObject1;
      Object localObject2;
      if (Build.VERSION.SDK_INT >= 24)
      {
        localObject2 = this.mBuilder.build();
        localObject1 = localObject2;
        if (this.gZ != 0)
        {
          if ((((Notification)localObject2).getGroup() != null) && ((((Notification)localObject2).flags & 0x200) != 0) && (this.gZ == 2)) {
            b((Notification)localObject2);
          }
          localObject1 = localObject2;
          if (((Notification)localObject2).getGroup() != null)
          {
            localObject1 = localObject2;
            if ((((Notification)localObject2).flags & 0x200) == 0)
            {
              localObject1 = localObject2;
              if (this.gZ == 1)
              {
                b((Notification)localObject2);
                localObject1 = localObject2;
              }
            }
          }
        }
      }
      else if (Build.VERSION.SDK_INT >= 21)
      {
        this.mBuilder.setExtras(this.gl);
        localObject2 = this.mBuilder.build();
        if (this.gS != null) {
          ((Notification)localObject2).contentView = this.gS;
        }
        if (this.gT != null) {
          ((Notification)localObject2).bigContentView = this.gT;
        }
        if (this.gU != null) {
          ((Notification)localObject2).headsUpContentView = this.gU;
        }
        localObject1 = localObject2;
        if (this.gZ != 0)
        {
          if ((((Notification)localObject2).getGroup() != null) && ((((Notification)localObject2).flags & 0x200) != 0) && (this.gZ == 2)) {
            b((Notification)localObject2);
          }
          localObject1 = localObject2;
          if (((Notification)localObject2).getGroup() != null)
          {
            localObject1 = localObject2;
            if ((((Notification)localObject2).flags & 0x200) == 0)
            {
              localObject1 = localObject2;
              if (this.gZ == 1)
              {
                b((Notification)localObject2);
                localObject1 = localObject2;
              }
            }
          }
        }
      }
      else if (Build.VERSION.SDK_INT >= 20)
      {
        this.mBuilder.setExtras(this.gl);
        localObject2 = this.mBuilder.build();
        if (this.gS != null) {
          ((Notification)localObject2).contentView = this.gS;
        }
        if (this.gT != null) {
          ((Notification)localObject2).bigContentView = this.gT;
        }
        localObject1 = localObject2;
        if (this.gZ != 0)
        {
          if ((((Notification)localObject2).getGroup() != null) && ((((Notification)localObject2).flags & 0x200) != 0) && (this.gZ == 2)) {
            b((Notification)localObject2);
          }
          localObject1 = localObject2;
          if (((Notification)localObject2).getGroup() != null)
          {
            localObject1 = localObject2;
            if ((((Notification)localObject2).flags & 0x200) == 0)
            {
              localObject1 = localObject2;
              if (this.gZ == 1)
              {
                b((Notification)localObject2);
                localObject1 = localObject2;
              }
            }
          }
        }
      }
      else if (Build.VERSION.SDK_INT >= 19)
      {
        localObject1 = ay.b(this.ht);
        if (localObject1 != null) {
          this.gl.putSparseParcelableArray("android.support.actionExtras", (SparseArray)localObject1);
        }
        this.mBuilder.setExtras(this.gl);
        localObject2 = this.mBuilder.build();
        if (this.gS != null) {
          ((Notification)localObject2).contentView = this.gS;
        }
        localObject1 = localObject2;
        if (this.gT != null)
        {
          ((Notification)localObject2).bigContentView = this.gT;
          localObject1 = localObject2;
        }
      }
      else if (Build.VERSION.SDK_INT >= 16)
      {
        localObject1 = this.mBuilder.build();
        localObject2 = aq.a((Notification)localObject1);
        Bundle localBundle = new Bundle(this.gl);
        Iterator localIterator = this.gl.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if (((Bundle)localObject2).containsKey(str)) {
            localBundle.remove(str);
          }
        }
        ((Bundle)localObject2).putAll(localBundle);
        localObject2 = ay.b(this.ht);
        if (localObject2 != null) {
          aq.a((Notification)localObject1).putSparseParcelableArray("android.support.actionExtras", (SparseArray)localObject2);
        }
        if (this.gS != null) {
          ((Notification)localObject1).contentView = this.gS;
        }
        if (this.gT != null) {
          ((Notification)localObject1).bigContentView = this.gT;
        }
      }
      else
      {
        localObject1 = this.mBuilder.getNotification();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.app.ax
 * JD-Core Version:    0.7.0.1
 */