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
  private final Bundle gl;
  private final CharSequence jA;
  private final Bitmap jB;
  private final Uri jC;
  private final Uri jD;
  private Object jE;
  private final String jx;
  private final CharSequence jy;
  private final CharSequence jz;
  
  MediaDescriptionCompat(Parcel paramParcel)
  {
    this.jx = paramParcel.readString();
    this.jy = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    this.jz = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    this.jA = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    this.jB = ((Bitmap)paramParcel.readParcelable(null));
    this.jC = ((Uri)paramParcel.readParcelable(null));
    this.gl = paramParcel.readBundle();
    this.jD = ((Uri)paramParcel.readParcelable(null));
  }
  
  MediaDescriptionCompat(String paramString, CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3, Bitmap paramBitmap, Uri paramUri1, Bundle paramBundle, Uri paramUri2)
  {
    this.jx = paramString;
    this.jy = paramCharSequence1;
    this.jz = paramCharSequence2;
    this.jA = paramCharSequence3;
    this.jB = paramBitmap;
    this.jC = paramUri1;
    this.gl = paramBundle;
    this.jD = paramUri2;
  }
  
  public static MediaDescriptionCompat i(Object paramObject)
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
        localah.b(((MediaDescription)paramObject).getIconBitmap());
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
      localObject = localah.be();
      ((MediaDescriptionCompat)localObject).jE = paramObject;
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
    return this.jx;
  }
  
  public final String toString()
  {
    return this.jy + ", " + this.jz + ", " + this.jA;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (Build.VERSION.SDK_INT < 21)
    {
      paramParcel.writeString(this.jx);
      TextUtils.writeToParcel(this.jy, paramParcel, paramInt);
      TextUtils.writeToParcel(this.jz, paramParcel, paramInt);
      TextUtils.writeToParcel(this.jA, paramParcel, paramInt);
      paramParcel.writeParcelable(this.jB, paramInt);
      paramParcel.writeParcelable(this.jC, paramInt);
      paramParcel.writeBundle(this.gl);
      paramParcel.writeParcelable(this.jD, paramInt);
      return;
    }
    if ((this.jE != null) || (Build.VERSION.SDK_INT < 21))
    {
      localObject = this.jE;
      ((MediaDescription)localObject).writeToParcel(paramParcel, paramInt);
      return;
    }
    MediaDescription.Builder localBuilder = new MediaDescription.Builder();
    Object localObject = this.jx;
    ((MediaDescription.Builder)localBuilder).setMediaId((String)localObject);
    localObject = this.jy;
    ((MediaDescription.Builder)localBuilder).setTitle((CharSequence)localObject);
    localObject = this.jz;
    ((MediaDescription.Builder)localBuilder).setSubtitle((CharSequence)localObject);
    localObject = this.jA;
    ((MediaDescription.Builder)localBuilder).setDescription((CharSequence)localObject);
    localObject = this.jB;
    ((MediaDescription.Builder)localBuilder).setIconBitmap((Bitmap)localObject);
    localObject = this.jC;
    ((MediaDescription.Builder)localBuilder).setIconUri((Uri)localObject);
    Bundle localBundle = this.gl;
    if ((Build.VERSION.SDK_INT < 23) && (this.jD != null))
    {
      localObject = localBundle;
      if (localBundle == null)
      {
        localObject = new Bundle();
        ((Bundle)localObject).putBoolean("android.support.v4.media.description.NULL_BUNDLE_FLAG", true);
      }
      ((Bundle)localObject).putParcelable("android.support.v4.media.description.MEDIA_URI", this.jD);
    }
    for (;;)
    {
      ((MediaDescription.Builder)localBuilder).setExtras((Bundle)localObject);
      if (Build.VERSION.SDK_INT >= 23)
      {
        localObject = this.jD;
        ((MediaDescription.Builder)localBuilder).setMediaUri((Uri)localObject);
      }
      this.jE = ((MediaDescription.Builder)localBuilder).build();
      localObject = this.jE;
      break;
      localObject = localBundle;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.media.MediaDescriptionCompat
 * JD-Core Version:    0.7.0.1
 */