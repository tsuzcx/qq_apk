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
  private final ComponentName FA;
  private final int FB;
  private final int FC;
  private final int FD;
  private final int FE;
  private final int FF;
  private final int FG;
  private final int FH;
  private final boolean FI;
  private final int FJ;
  private final boolean FK;
  private final boolean FL;
  private final boolean FM;
  private final boolean FN;
  
  public WatchFaceStyle(Bundle paramBundle)
  {
    this.FA = ((ComponentName)paramBundle.getParcelable("component"));
    this.FJ = paramBundle.getInt("ambientPeekMode", 0);
    this.FH = paramBundle.getInt("backgroundVisibility", 0);
    this.FB = paramBundle.getInt("cardPeekMode", 0);
    this.FC = paramBundle.getInt("cardProgressMode", 0);
    this.FG = paramBundle.getInt("hotwordIndicatorGravity");
    this.FD = paramBundle.getInt("peekOpacityMode", 0);
    this.FI = paramBundle.getBoolean("showSystemUiTime");
    this.FK = paramBundle.getBoolean("showUnreadIndicator");
    this.FF = paramBundle.getInt("statusBarGravity");
    this.FE = paramBundle.getInt("viewProtectionMode");
    this.FL = paramBundle.getBoolean("acceptsTapEvents");
    this.FM = paramBundle.getBoolean("hideHotwordIndicator");
    this.FN = paramBundle.getBoolean("hideStatusBar");
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
    } while ((!this.FA.equals(paramObject.FA)) || (this.FB != paramObject.FB) || (this.FC != paramObject.FC) || (this.FH != paramObject.FH) || (this.FI != paramObject.FI) || (this.FJ != paramObject.FJ) || (this.FD != paramObject.FD) || (this.FE != paramObject.FE) || (this.FF != paramObject.FF) || (this.FG != paramObject.FG) || (this.FK != paramObject.FK) || (this.FL != paramObject.FL) || (this.FM != paramObject.FM) || (this.FN != paramObject.FN));
    return true;
  }
  
  public int hashCode()
  {
    int n = 1;
    int i1 = this.FA.hashCode();
    int i2 = this.FB;
    int i3 = this.FC;
    int i4 = this.FH;
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
    if (this.FI)
    {
      i = 1;
      i5 = this.FJ;
      i6 = this.FD;
      i7 = this.FE;
      i8 = this.FF;
      i9 = this.FG;
      if (!this.FK) {
        break label190;
      }
      j = 1;
      if (!this.FL) {
        break label195;
      }
      k = 1;
      if (!this.FM) {
        break label200;
      }
      m = 1;
      label97:
      if (!this.FN) {
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
    if (this.FA == null) {}
    for (String str = "default";; str = this.FA.getShortClassName()) {
      return String.format("watch face %s (card %d/%d bg %d time %s ambientPeek %d peekOpacityMode %d viewProtectionMode %d statusBarGravity %d hotwordIndicatorGravity %d showUnreadCountIndicator %s acceptsTapEvents %s hideHotwordIndicator %s hideStatusBar %s)", new Object[] { str, Integer.valueOf(this.FB), Integer.valueOf(this.FC), Integer.valueOf(this.FH), Boolean.valueOf(this.FI), Integer.valueOf(this.FJ), Integer.valueOf(this.FD), Integer.valueOf(this.FE), Integer.valueOf(this.FF), Integer.valueOf(this.FG), Boolean.valueOf(this.FK), Boolean.valueOf(this.FL), Boolean.valueOf(this.FM), Boolean.valueOf(this.FN) });
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("component", this.FA);
    localBundle.putInt("ambientPeekMode", this.FJ);
    localBundle.putInt("backgroundVisibility", this.FH);
    localBundle.putInt("cardPeekMode", this.FB);
    localBundle.putInt("cardProgressMode", this.FC);
    localBundle.putInt("hotwordIndicatorGravity", this.FG);
    localBundle.putInt("peekOpacityMode", this.FD);
    localBundle.putBoolean("showSystemUiTime", this.FI);
    localBundle.putBoolean("showUnreadIndicator", this.FK);
    localBundle.putInt("statusBarGravity", this.FF);
    localBundle.putInt("viewProtectionMode", this.FE);
    localBundle.putBoolean("acceptsTapEvents", this.FL);
    localBundle.putBoolean("hideHotwordIndicator", this.FM);
    localBundle.putBoolean("hideStatusBar", this.FN);
    paramParcel.writeBundle(localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.wearable.watchface.WatchFaceStyle
 * JD-Core Version:    0.7.0.1
 */