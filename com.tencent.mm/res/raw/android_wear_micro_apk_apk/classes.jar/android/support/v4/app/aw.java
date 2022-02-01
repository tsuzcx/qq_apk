package android.support.v4.app;

import android.app.Notification;
import android.app.Notification.Action;
import android.app.Notification.Action.Builder;
import android.app.PendingIntent;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;

public final class aw
  implements au
{
  private int eT = 1;
  private ArrayList<ar> gq = new ArrayList();
  private PendingIntent hg;
  private ArrayList<Notification> hh = new ArrayList();
  private Bitmap hi;
  private int hj;
  private int hk = 8388613;
  private int hl = -1;
  private int hm = 0;
  private int hn;
  private int ho = 80;
  private int hp;
  private String hq;
  private String hr;
  
  private static Notification.Action b(ar paramar)
  {
    Notification.Action.Builder localBuilder = new Notification.Action.Builder(paramar.icon, paramar.title, paramar.actionIntent);
    if (paramar.gl != null) {}
    for (Bundle localBundle = new Bundle(paramar.gl);; localBundle = new Bundle())
    {
      localBundle.putBoolean("android.support.allowGeneratedReplies", paramar.getAllowGeneratedReplies());
      if (Build.VERSION.SDK_INT >= 24) {
        localBuilder.setAllowGeneratedReplies(paramar.getAllowGeneratedReplies());
      }
      localBuilder.addExtras(localBundle);
      paramar = paramar.aK();
      if (paramar == null) {
        break;
      }
      paramar = ba.b(paramar);
      int j = paramar.length;
      int i = 0;
      while (i < j)
      {
        localBuilder.addRemoteInput(paramar[i]);
        i += 1;
      }
    }
    return localBuilder.build();
  }
  
  public final at a(at paramat)
  {
    Bundle localBundle = new Bundle();
    if (!this.gq.isEmpty())
    {
      if (Build.VERSION.SDK_INT < 16) {
        break label397;
      }
      ArrayList localArrayList = new ArrayList(this.gq.size());
      Iterator localIterator = this.gq.iterator();
      while (localIterator.hasNext())
      {
        ar localar = (ar)localIterator.next();
        if (Build.VERSION.SDK_INT >= 20) {
          localArrayList.add(b(localar));
        } else if (Build.VERSION.SDK_INT >= 16) {
          localArrayList.add(ay.e(localar));
        }
      }
      localBundle.putParcelableArrayList("actions", localArrayList);
    }
    for (;;)
    {
      if (this.eT != 1) {
        localBundle.putInt("flags", this.eT);
      }
      if (this.hg != null) {
        localBundle.putParcelable("displayIntent", this.hg);
      }
      if (!this.hh.isEmpty()) {
        localBundle.putParcelableArray("pages", (Parcelable[])this.hh.toArray(new Notification[this.hh.size()]));
      }
      if (this.hi != null) {
        localBundle.putParcelable("background", this.hi);
      }
      if (this.hj != 0) {
        localBundle.putInt("contentIcon", this.hj);
      }
      if (this.hk != 8388613) {
        localBundle.putInt("contentIconGravity", this.hk);
      }
      if (this.hl != -1) {
        localBundle.putInt("contentActionIndex", this.hl);
      }
      if (this.hm != 0) {
        localBundle.putInt("customSizePreset", this.hm);
      }
      if (this.hn != 0) {
        localBundle.putInt("customContentHeight", this.hn);
      }
      if (this.ho != 80) {
        localBundle.putInt("gravity", this.ho);
      }
      if (this.hp != 0) {
        localBundle.putInt("hintScreenTimeout", this.hp);
      }
      if (this.hq != null) {
        localBundle.putString("dismissalId", this.hq);
      }
      if (this.hr != null) {
        localBundle.putString("bridgeTag", this.hr);
      }
      if (paramat.gl == null) {
        paramat.gl = new Bundle();
      }
      paramat.gl.putBundle("android.wearable.EXTENSIONS", localBundle);
      return paramat;
      label397:
      localBundle.putParcelableArrayList("actions", null);
    }
  }
  
  public final aw aP()
  {
    this.hj = 2130837581;
    return this;
  }
  
  public final aw aQ()
  {
    this.hl = 0;
    return this;
  }
  
  public final aw aR()
  {
    this.eT |= 0x2;
    return this;
  }
  
  public final aw c(ar paramar)
  {
    this.gq.add(paramar);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.app.aw
 * JD-Core Version:    0.7.0.1
 */