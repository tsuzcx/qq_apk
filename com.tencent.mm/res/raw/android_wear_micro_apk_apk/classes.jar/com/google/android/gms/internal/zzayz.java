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
  public static final cn Qr = new cn();
  private static final Charset UTF_8 = Charset.forName("UTF-8");
  final String PG;
  final long Ql;
  final boolean Qm;
  final double Qn;
  final byte[] Qo;
  public final int Qp;
  public final int Qq;
  public final String name;
  
  public zzayz(String paramString1, long paramLong, boolean paramBoolean, double paramDouble, String paramString2, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.name = paramString1;
    this.Ql = paramLong;
    this.Qm = paramBoolean;
    this.Qn = paramDouble;
    this.PG = paramString2;
    this.Qo = paramArrayOfByte;
    this.Qp = paramInt1;
    this.Qq = paramInt2;
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
      if ((!b.b(this.name, paramObject.name)) || (this.Qp != paramObject.Qp) || (this.Qq != paramObject.Qq)) {
        bool = false;
      }
      do
      {
        do
        {
          do
          {
            return bool;
            switch (this.Qp)
            {
            default: 
              int i = this.Qp;
              throw new AssertionError(31 + "Invalid enum value: " + i);
            }
          } while (this.Ql == paramObject.Ql);
          return false;
        } while (this.Qm == paramObject.Qm);
        return false;
      } while (this.Qn == paramObject.Qn);
      return false;
      return b.b(this.PG, paramObject.PG);
      return Arrays.equals(this.Qo, paramObject.Qo);
    }
    return false;
  }
  
  public String toString()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Flag(");
    ((StringBuilder)localObject).append(this.name);
    ((StringBuilder)localObject).append(", ");
    switch (this.Qp)
    {
    default: 
      localObject = this.name;
      int i = this.Qp;
      throw new AssertionError(String.valueOf(localObject).length() + 27 + "Invalid type: " + (String)localObject + ", " + i);
    case 1: 
      ((StringBuilder)localObject).append(this.Ql);
    }
    for (;;)
    {
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(this.Qp);
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(this.Qq);
      ((StringBuilder)localObject).append(")");
      return ((StringBuilder)localObject).toString();
      ((StringBuilder)localObject).append(this.Qm);
      continue;
      ((StringBuilder)localObject).append(this.Qn);
      continue;
      ((StringBuilder)localObject).append("'");
      ((StringBuilder)localObject).append(this.PG);
      ((StringBuilder)localObject).append("'");
      continue;
      if (this.Qo == null)
      {
        ((StringBuilder)localObject).append("null");
      }
      else
      {
        ((StringBuilder)localObject).append("'");
        ((StringBuilder)localObject).append(new String(this.Qo, UTF_8));
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