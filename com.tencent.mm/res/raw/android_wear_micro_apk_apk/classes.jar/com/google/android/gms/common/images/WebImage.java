package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.b;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.Arrays;
import java.util.Locale;

public final class WebImage
  extends zza
{
  public static final Parcelable.Creator<WebImage> CREATOR = new h();
  final int Hc;
  private final Uri IN;
  private final int IO;
  private final int IP;
  
  WebImage(int paramInt1, Uri paramUri, int paramInt2, int paramInt3)
  {
    this.Hc = paramInt1;
    this.IN = paramUri;
    this.IO = paramInt2;
    this.IP = paramInt3;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (!(paramObject instanceof WebImage))) {
        return false;
      }
      paramObject = (WebImage)paramObject;
    } while ((b.b(this.IN, paramObject.IN)) && (this.IO == paramObject.IO) && (this.IP == paramObject.IP));
    return false;
  }
  
  public final int getHeight()
  {
    return this.IP;
  }
  
  public final Uri getUrl()
  {
    return this.IN;
  }
  
  public final int getWidth()
  {
    return this.IO;
  }
  
  public final int hashCode()
  {
    return Arrays.hashCode(new Object[] { this.IN, Integer.valueOf(this.IO), Integer.valueOf(this.IP) });
  }
  
  public final String toString()
  {
    return String.format(Locale.US, "Image %dx%d %s", new Object[] { Integer.valueOf(this.IO), Integer.valueOf(this.IP), this.IN.toString() });
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    h.a(this, paramParcel, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.images.WebImage
 * JD-Core Version:    0.7.0.1
 */