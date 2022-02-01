package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.b;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.nio.charset.Charset;
import java.util.Arrays;

public class zzayz
  extends zza
  implements Comparable<zzayz>
{
  public static final Parcelable.Creator<zzayz> CREATOR = new co();
  public static final cn Sg = new cn();
  private static final Charset UTF_8 = Charset.forName("UTF-8");
  final String Rv;
  final long Sa;
  final boolean Sb;
  final double Sc;
  final byte[] Sd;
  public final int Se;
  public final int Sf;
  public final String name;
  
  public zzayz(String paramString1, long paramLong, boolean paramBoolean, double paramDouble, String paramString2, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.name = paramString1;
    this.Sa = paramLong;
    this.Sb = paramBoolean;
    this.Sc = paramDouble;
    this.Rv = paramString2;
    this.Sd = paramArrayOfByte;
    this.Se = paramInt1;
    this.Sf = paramInt2;
  }
  
  private static int compare(int paramInt1, int paramInt2)
  {
    if (paramInt1 < paramInt2) {
      return -1;
    }
    if (paramInt1 == paramInt2) {
      return 0;
    }
    return 1;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if ((paramObject != null) && ((paramObject instanceof zzayz)))
    {
      paramObject = (zzayz)paramObject;
      if ((!b.c(this.name, paramObject.name)) || (this.Se != paramObject.Se) || (this.Sf != paramObject.Sf)) {
        bool = false;
      }
      do
      {
        do
        {
          do
          {
            return bool;
            switch (this.Se)
            {
            default: 
              int i = this.Se;
              throw new AssertionError(31 + "Invalid enum value: " + i);
            }
          } while (this.Sa == paramObject.Sa);
          return false;
        } while (this.Sb == paramObject.Sb);
        return false;
      } while (this.Sc == paramObject.Sc);
      return false;
      return b.c(this.Rv, paramObject.Rv);
      return Arrays.equals(this.Sd, paramObject.Sd);
    }
    return false;
  }
  
  public String toString()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Flag(");
    ((StringBuilder)localObject).append(this.name);
    ((StringBuilder)localObject).append(", ");
    switch (this.Se)
    {
    default: 
      localObject = this.name;
      int i = this.Se;
      throw new AssertionError(String.valueOf(localObject).length() + 27 + "Invalid type: " + (String)localObject + ", " + i);
    case 1: 
      ((StringBuilder)localObject).append(this.Sa);
    }
    for (;;)
    {
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(this.Se);
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(this.Sf);
      ((StringBuilder)localObject).append(")");
      return ((StringBuilder)localObject).toString();
      ((StringBuilder)localObject).append(this.Sb);
      continue;
      ((StringBuilder)localObject).append(this.Sc);
      continue;
      ((StringBuilder)localObject).append("'");
      ((StringBuilder)localObject).append(this.Rv);
      ((StringBuilder)localObject).append("'");
      continue;
      if (this.Sd == null)
      {
        ((StringBuilder)localObject).append("null");
      }
      else
      {
        ((StringBuilder)localObject).append("'");
        ((StringBuilder)localObject).append(new String(this.Sd, UTF_8));
        ((StringBuilder)localObject).append("'");
      }
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    co.a(this, paramParcel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.zzayz
 * JD-Core Version:    0.7.0.1
 */