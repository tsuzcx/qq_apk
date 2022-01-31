package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.b;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.Arrays;

public class Asset
  extends zza
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<Asset> CREATOR = new ah();
  private byte[] Sh;
  private String Si;
  public ParcelFileDescriptor Sj;
  public Uri uri;
  
  Asset(byte[] paramArrayOfByte, String paramString, ParcelFileDescriptor paramParcelFileDescriptor, Uri paramUri)
  {
    this.Sh = paramArrayOfByte;
    this.Si = paramString;
    this.Sj = paramParcelFileDescriptor;
    this.uri = paramUri;
  }
  
  public static Asset a(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    if (paramParcelFileDescriptor == null) {
      throw new IllegalArgumentException("Asset fd cannot be null");
    }
    return new Asset(null, null, paramParcelFileDescriptor, null);
  }
  
  public static Asset e(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      throw new IllegalArgumentException("Asset data cannot be null");
    }
    return new Asset(paramArrayOfByte, null, null, null);
  }
  
  public static Asset t(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("Asset digest cannot be null");
    }
    return new Asset(null, paramString, null, null);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof Asset)) {
        return false;
      }
      paramObject = (Asset)paramObject;
    } while ((Arrays.equals(this.Sh, paramObject.Sh)) && (b.b(this.Si, paramObject.Si)) && (b.b(this.Sj, paramObject.Sj)) && (b.b(this.uri, paramObject.uri)));
    return false;
  }
  
  public final byte[] getData()
  {
    return this.Sh;
  }
  
  public int hashCode()
  {
    return Arrays.deepHashCode(new Object[] { this.Sh, this.Si, this.Sj, this.uri });
  }
  
  public final String kp()
  {
    return this.Si;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Asset[@");
    localStringBuilder.append(Integer.toHexString(hashCode()));
    if (this.Si == null) {
      localStringBuilder.append(", nodigest");
    }
    for (;;)
    {
      if (this.Sh != null)
      {
        localStringBuilder.append(", size=");
        localStringBuilder.append(this.Sh.length);
      }
      if (this.Sj != null)
      {
        localStringBuilder.append(", fd=");
        localStringBuilder.append(this.Sj);
      }
      if (this.uri != null)
      {
        localStringBuilder.append(", uri=");
        localStringBuilder.append(this.uri);
      }
      localStringBuilder.append("]");
      return localStringBuilder.toString();
      localStringBuilder.append(", ");
      localStringBuilder.append(this.Si);
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ah.a(this, paramParcel, paramInt | 0x1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.wearable.Asset
 * JD-Core Version:    0.7.0.1
 */