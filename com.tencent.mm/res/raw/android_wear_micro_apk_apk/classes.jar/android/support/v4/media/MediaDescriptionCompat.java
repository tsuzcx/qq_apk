package android.support.v4.media;

import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.media.MediaDescription.Builder;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;

public final class MediaDescriptionCompat
  implements Parcelable
{
  public static final Parcelable.Creator<MediaDescriptionCompat> CREATOR = new Parcelable.Creator() {};
  private final Bundle ew;
  private final CharSequence hA;
  private final CharSequence hB;
  private final Bitmap hC;
  private final Uri hD;
  private final Uri hE;
  private Object hF;
  private final String hy;
  private final CharSequence hz;
  
  MediaDescriptionCompat(Parcel paramParcel)
  {
    this.hy = paramParcel.readString();
    this.hz = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    this.hA = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    this.hB = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    this.hC = ((Bitmap)paramParcel.readParcelable(null));
    this.hD = ((Uri)paramParcel.readParcelable(null));
    this.ew = paramParcel.readBundle();
    this.hE = ((Uri)paramParcel.readParcelable(null));
  }
  
  MediaDescriptionCompat(String paramString, CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3, Bitmap paramBitmap, Uri paramUri1, Bundle paramBundle, Uri paramUri2)
  {
    this.hy = paramString;
    this.hz = paramCharSequence1;
    this.hA = paramCharSequence2;
    this.hB = paramCharSequence3;
    this.hC = paramBitmap;
    this.hD = paramUri1;
    this.ew = paramBundle;
    this.hE = paramUri2;
  }
  
  public static MediaDescriptionCompat c(Object paramObject)
  {
    Bundle localBundle = null;
    Object localObject = localBundle;
    ah localah;
    if (paramObject != null)
    {
      localObject = localBundle;
      if (Build.VERSION.SDK_INT >= 21)
      {
        localah = new ah();
        localah.e(((MediaDescription)paramObject).getMediaId());
        localah.f(((MediaDescription)paramObject).getTitle());
        localah.g(((MediaDescription)paramObject).getSubtitle());
        localah.h(((MediaDescription)paramObject).getDescription());
        localah.a(((MediaDescription)paramObject).getIconBitmap());
        localah.b(((MediaDescription)paramObject).getIconUri());
        localBundle = ((MediaDescription)paramObject).getExtras();
        if (localBundle != null) {
          break label163;
        }
        localObject = null;
        if (localObject == null) {
          break label188;
        }
        if ((!localBundle.containsKey("android.support.v4.media.description.NULL_BUNDLE_FLAG")) || (localBundle.size() != 2)) {
          break label176;
        }
        localBundle = null;
        label135:
        localah.f(localBundle);
        if (localObject == null) {
          break label191;
        }
        localah.c((Uri)localObject);
      }
    }
    for (;;)
    {
      localObject = localah.aO();
      ((MediaDescriptionCompat)localObject).hF = paramObject;
      return localObject;
      label163:
      localObject = (Uri)localBundle.getParcelable("android.support.v4.media.description.MEDIA_URI");
      break;
      label176:
      localBundle.remove("android.support.v4.media.description.MEDIA_URI");
      localBundle.remove("android.support.v4.media.description.NULL_BUNDLE_FLAG");
      label188:
      break label135;
      label191:
      if (Build.VERSION.SDK_INT >= 23) {
        localah.c(((MediaDescription)paramObject).getMediaUri());
      }
    }
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String getMediaId()
  {
    return this.hy;
  }
  
  public final String toString()
  {
    return this.hz + ", " + this.hA + ", " + this.hB;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (Build.VERSION.SDK_INT < 21)
    {
      paramParcel.writeString(this.hy);
      TextUtils.writeToParcel(this.hz, paramParcel, paramInt);
      TextUtils.writeToParcel(this.hA, paramParcel, paramInt);
      TextUtils.writeToParcel(this.hB, paramParcel, paramInt);
      paramParcel.writeParcelable(this.hC, paramInt);
      paramParcel.writeParcelable(this.hD, paramInt);
      paramParcel.writeBundle(this.ew);
      paramParcel.writeParcelable(this.hE, paramInt);
      return;
    }
    if ((this.hF != null) || (Build.VERSION.SDK_INT < 21))
    {
      localObject = this.hF;
      ((MediaDescription)localObject).writeToParcel(paramParcel, paramInt);
      return;
    }
    MediaDescription.Builder localBuilder = new MediaDescription.Builder();
    Object localObject = this.hy;
    ((MediaDescription.Builder)localBuilder).setMediaId((String)localObject);
    localObject = this.hz;
    ((MediaDescription.Builder)localBuilder).setTitle((CharSequence)localObject);
    localObject = this.hA;
    ((MediaDescription.Builder)localBuilder).setSubtitle((CharSequence)localObject);
    localObject = this.hB;
    ((MediaDescription.Builder)localBuilder).setDescription((CharSequence)localObject);
    localObject = this.hC;
    ((MediaDescription.Builder)localBuilder).setIconBitmap((Bitmap)localObject);
    localObject = this.hD;
    ((MediaDescription.Builder)localBuilder).setIconUri((Uri)localObject);
    Bundle localBundle = this.ew;
    if ((Build.VERSION.SDK_INT < 23) && (this.hE != null))
    {
      localObject = localBundle;
      if (localBundle == null)
      {
        localObject = new Bundle();
        ((Bundle)localObject).putBoolean("android.support.v4.media.description.NULL_BUNDLE_FLAG", true);
      }
      ((Bundle)localObject).putParcelable("android.support.v4.media.description.MEDIA_URI", this.hE);
    }
    for (;;)
    {
      ((MediaDescription.Builder)localBuilder).setExtras((Bundle)localObject);
      if (Build.VERSION.SDK_INT >= 23)
      {
        localObject = this.hE;
        ((MediaDescription.Builder)localBuilder).setMediaUri((Uri)localObject);
      }
      this.hF = ((MediaDescription.Builder)localBuilder).build();
      localObject = this.hF;
      break;
      localObject = localBundle;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.media.MediaDescriptionCompat
 * JD-Core Version:    0.7.0.1
 */