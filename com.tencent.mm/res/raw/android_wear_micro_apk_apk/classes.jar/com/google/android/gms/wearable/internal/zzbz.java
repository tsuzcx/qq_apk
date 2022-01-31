package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.wearable.s;

public class zzbz
  extends zza
  implements s
{
  public static final Parcelable.Creator<zzbz> CREATOR = new ax();
  private final String RV;
  private final byte[] Sh;
  private final int TF;
  private final String TG;
  
  public zzbz(int paramInt, String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    this.TF = paramInt;
    this.TG = paramString1;
    this.Sh = paramArrayOfByte;
    this.RV = paramString2;
  }
  
  public final byte[] getData()
  {
    return this.Sh;
  }
  
  public final String getPath()
  {
    return this.TG;
  }
  
  public final int getRequestId()
  {
    return this.TF;
  }
  
  public final String kI()
  {
    return this.RV;
  }
  
  public String toString()
  {
    int i = this.TF;
    String str = this.TG;
    if (this.Sh == null) {}
    for (Object localObject = "null";; localObject = Integer.valueOf(this.Sh.length))
    {
      localObject = String.valueOf(localObject);
      return String.valueOf(str).length() + 43 + String.valueOf(localObject).length() + "MessageEventParcelable[" + i + "," + str + ", size=" + (String)localObject + "]";
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ax.a(this, paramParcel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzbz
 * JD-Core Version:    0.7.0.1
 */