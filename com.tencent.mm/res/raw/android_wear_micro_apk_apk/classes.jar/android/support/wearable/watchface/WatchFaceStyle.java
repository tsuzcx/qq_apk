package android.support.wearable.watchface;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

@TargetApi(21)
public class WatchFaceStyle
  implements Parcelable
{
  public static final Parcelable.Creator<WatchFaceStyle> CREATOR = new Parcelable.Creator() {};
  private final boolean HA;
  private final boolean HB;
  private final boolean HC;
  private final ComponentName Hp;
  private final int Hq;
  private final int Hr;
  private final int Hs;
  private final int Ht;
  private final int Hu;
  private final int Hv;
  private final int Hw;
  private final boolean Hx;
  private final int Hy;
  private final boolean Hz;
  
  public WatchFaceStyle(Bundle paramBundle)
  {
    this.Hp = ((ComponentName)paramBundle.getParcelable("component"));
    this.Hy = paramBundle.getInt("ambientPeekMode", 0);
    this.Hw = paramBundle.getInt("backgroundVisibility", 0);
    this.Hq = paramBundle.getInt("cardPeekMode", 0);
    this.Hr = paramBundle.getInt("cardProgressMode", 0);
    this.Hv = paramBundle.getInt("hotwordIndicatorGravity");
    this.Hs = paramBundle.getInt("peekOpacityMode", 0);
    this.Hx = paramBundle.getBoolean("showSystemUiTime");
    this.Hz = paramBundle.getBoolean("showUnreadIndicator");
    this.Hu = paramBundle.getInt("statusBarGravity");
    this.Ht = paramBundle.getInt("viewProtectionMode");
    this.HA = paramBundle.getBoolean("acceptsTapEvents");
    this.HB = paramBundle.getBoolean("hideHotwordIndicator");
    this.HC = paramBundle.getBoolean("hideStatusBar");
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof WatchFaceStyle))) {}
    do
    {
      return false;
      paramObject = (WatchFaceStyle)paramObject;
    } while ((!this.Hp.equals(paramObject.Hp)) || (this.Hq != paramObject.Hq) || (this.Hr != paramObject.Hr) || (this.Hw != paramObject.Hw) || (this.Hx != paramObject.Hx) || (this.Hy != paramObject.Hy) || (this.Hs != paramObject.Hs) || (this.Ht != paramObject.Ht) || (this.Hu != paramObject.Hu) || (this.Hv != paramObject.Hv) || (this.Hz != paramObject.Hz) || (this.HA != paramObject.HA) || (this.HB != paramObject.HB) || (this.HC != paramObject.HC));
    return true;
  }
  
  public int hashCode()
  {
    int n = 1;
    int i1 = this.Hp.hashCode();
    int i2 = this.Hq;
    int i3 = this.Hr;
    int i4 = this.Hw;
    int i;
    int i5;
    int i6;
    int i7;
    int i8;
    int i9;
    int j;
    label78:
    int k;
    label87:
    int m;
    if (this.Hx)
    {
      i = 1;
      i5 = this.Hy;
      i6 = this.Hs;
      i7 = this.Ht;
      i8 = this.Hu;
      i9 = this.Hv;
      if (!this.Hz) {
        break label190;
      }
      j = 1;
      if (!this.HA) {
        break label195;
      }
      k = 1;
      if (!this.HB) {
        break label200;
      }
      m = 1;
      label97:
      if (!this.HC) {
        break label206;
      }
    }
    for (;;)
    {
      return (m + (k + (j + ((((((i + ((((i1 + 31) * 31 + i2) * 31 + i3) * 31 + i4) * 31) * 31 + i5) * 31 + i6) * 31 + i7) * 31 + i8) * 31 + i9) * 31) * 31) * 31) * 31 + n;
      i = 0;
      break;
      label190:
      j = 0;
      break label78;
      label195:
      k = 0;
      break label87;
      label200:
      m = 0;
      break label97;
      label206:
      n = 0;
    }
  }
  
  public String toString()
  {
    if (this.Hp == null) {}
    for (String str = "default";; str = this.Hp.getShortClassName()) {
      return String.format("watch face %s (card %d/%d bg %d time %s ambientPeek %d peekOpacityMode %d viewProtectionMode %d statusBarGravity %d hotwordIndicatorGravity %d showUnreadCountIndicator %s acceptsTapEvents %s hideHotwordIndicator %s hideStatusBar %s)", new Object[] { str, Integer.valueOf(this.Hq), Integer.valueOf(this.Hr), Integer.valueOf(this.Hw), Boolean.valueOf(this.Hx), Integer.valueOf(this.Hy), Integer.valueOf(this.Hs), Integer.valueOf(this.Ht), Integer.valueOf(this.Hu), Integer.valueOf(this.Hv), Boolean.valueOf(this.Hz), Boolean.valueOf(this.HA), Boolean.valueOf(this.HB), Boolean.valueOf(this.HC) });
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("component", this.Hp);
    localBundle.putInt("ambientPeekMode", this.Hy);
    localBundle.putInt("backgroundVisibility", this.Hw);
    localBundle.putInt("cardPeekMode", this.Hq);
    localBundle.putInt("cardProgressMode", this.Hr);
    localBundle.putInt("hotwordIndicatorGravity", this.Hv);
    localBundle.putInt("peekOpacityMode", this.Hs);
    localBundle.putBoolean("showSystemUiTime", this.Hx);
    localBundle.putBoolean("showUnreadIndicator", this.Hz);
    localBundle.putInt("statusBarGravity", this.Hu);
    localBundle.putInt("viewProtectionMode", this.Ht);
    localBundle.putBoolean("acceptsTapEvents", this.HA);
    localBundle.putBoolean("hideHotwordIndicator", this.HB);
    localBundle.putBoolean("hideStatusBar", this.HC);
    paramParcel.writeBundle(localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.wearable.watchface.WatchFaceStyle
 * JD-Core Version:    0.7.0.1
 */