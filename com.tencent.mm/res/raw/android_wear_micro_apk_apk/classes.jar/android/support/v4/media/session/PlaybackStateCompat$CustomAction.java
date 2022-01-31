package android.support.v4.media.session;

import android.media.session.PlaybackState.CustomAction;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;

public final class PlaybackStateCompat$CustomAction
  implements Parcelable
{
  public static final Parcelable.Creator<CustomAction> CREATOR = new Parcelable.Creator() {};
  private final Bundle ew;
  private final String iG;
  private final CharSequence iH;
  private final int iI;
  private Object iJ;
  
  PlaybackStateCompat$CustomAction(Parcel paramParcel)
  {
    this.iG = paramParcel.readString();
    this.iH = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    this.iI = paramParcel.readInt();
    this.ew = paramParcel.readBundle();
  }
  
  private PlaybackStateCompat$CustomAction(String paramString, CharSequence paramCharSequence, int paramInt, Bundle paramBundle)
  {
    this.iG = paramString;
    this.iH = paramCharSequence;
    this.iI = paramInt;
    this.ew = paramBundle;
  }
  
  public static CustomAction i(Object paramObject)
  {
    if ((paramObject == null) || (Build.VERSION.SDK_INT < 21)) {
      return null;
    }
    CustomAction localCustomAction = new CustomAction(((PlaybackState.CustomAction)paramObject).getAction(), ((PlaybackState.CustomAction)paramObject).getName(), ((PlaybackState.CustomAction)paramObject).getIcon(), ((PlaybackState.CustomAction)paramObject).getExtras());
    localCustomAction.iJ = paramObject;
    return localCustomAction;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String toString()
  {
    return "Action:mName='" + this.iH + ", mIcon=" + this.iI + ", mExtras=" + this.ew;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.iG);
    TextUtils.writeToParcel(this.iH, paramParcel, paramInt);
    paramParcel.writeInt(this.iI);
    paramParcel.writeBundle(this.ew);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.media.session.PlaybackStateCompat.CustomAction
 * JD-Core Version:    0.7.0.1
 */