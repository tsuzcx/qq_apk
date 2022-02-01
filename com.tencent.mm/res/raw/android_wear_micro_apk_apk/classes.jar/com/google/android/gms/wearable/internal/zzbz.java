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
  private final String TK;
  private final byte[] TW;
  private final int Vu;
  private final String Vv;
  
  public zzbz(int paramInt, String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    this.Vu = paramInt;
    this.Vv = paramString1;
    this.TW = paramArrayOfByte;
    this.TK = paramString2;
  }
  
  public final byte[] getData()
  {
    return this.TW;
  }
  
  public final String getPath()
  {
    return this.Vv;
  }
  
  public final int getRequestId()
  {
    return this.Vu;
  }
  
  public final String kR()
  {
    return this.TK;
  }
  
  public String toString()
  {
    int i = this.Vu;
    String str = this.Vv;
    if (this.TW == null) {}
    for (Object localObject = "null";; localObject = Integer.valueOf(this.TW.length))
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