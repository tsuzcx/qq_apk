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
  final int IR;
  private final Uri KC;
  private final int KD;
  private final int KE;
  
  WebImage(int paramInt1, Uri paramUri, int paramInt2, int paramInt3)
  {
    this.IR = paramInt1;
    this.KC = paramUri;
    this.KD = paramInt2;
    this.KE = paramInt3;
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
    } while ((b.c(this.KC, paramObject.KC)) && (this.KD == paramObject.KD) && (this.KE == paramObject.KE));
    return false;
  }
  
  public final int getHeight()
  {
    return this.KE;
  }
  
  public final Uri getUrl()
  {
    return this.KC;
  }
  
  public final int getWidth()
  {
    return this.KD;
  }
  
  public final int hashCode()
  {
    return Arrays.hashCode(new Object[] { this.KC, Integer.valueOf(this.KD), Integer.valueOf(this.KE) });
  }
  
  public final String toString()
  {
    return String.format(Locale.US, "Image %dx%d %s", new Object[] { Integer.valueOf(this.KD), Integer.valueOf(this.KE), this.KC.toString() });
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