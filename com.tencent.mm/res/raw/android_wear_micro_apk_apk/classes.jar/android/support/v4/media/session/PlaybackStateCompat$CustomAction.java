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
  private final Bundle gl;
  private final String kE;
  private final CharSequence kF;
  private final int kG;
  private Object kH;
  
  PlaybackStateCompat$CustomAction(Parcel paramParcel)
  {
    this.kE = paramParcel.readString();
    this.kF = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    this.kG = paramParcel.readInt();
    this.gl = paramParcel.readBundle();
  }
  
  private PlaybackStateCompat$CustomAction(String paramString, CharSequence paramCharSequence, int paramInt, Bundle paramBundle)
  {
    this.kE = paramString;
    this.kF = paramCharSequence;
    this.kG = paramInt;
    this.gl = paramBundle;
  }
  
  public static CustomAction p(Object paramObject)
  {
    if ((paramObject == null) || (Build.VERSION.SDK_INT < 21)) {
      return null;
    }
    CustomAction localCustomAction = new CustomAction(((PlaybackState.CustomAction)paramObject).getAction(), ((PlaybackState.CustomAction)paramObject).getName(), ((PlaybackState.CustomAction)paramObject).getIcon(), ((PlaybackState.CustomAction)paramObject).getExtras());
    localCustomAction.kH = paramObject;
    return localCustomAction;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String toString()
  {
    return "Action:mName='" + this.kF + ", mIcon=" + this.kG + ", mExtras=" + this.gl;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.kE);
    TextUtils.writeToParcel(this.kF, paramParcel, paramInt);
    paramParcel.writeInt(this.kG);
    paramParcel.writeBundle(this.gl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.media.session.PlaybackStateCompat.CustomAction
 * JD-Core Version:    0.7.0.1
 */