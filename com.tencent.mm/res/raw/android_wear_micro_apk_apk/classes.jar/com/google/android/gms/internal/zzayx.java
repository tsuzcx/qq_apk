package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.b;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class zzayx
  extends zza
  implements Comparable<zzayx>
{
  public static final Parcelable.Creator<zzayx> CREATOR = new cm();
  public final int RW;
  public final zzayz[] RX;
  public final String[] RY;
  public final Map<String, zzayz> RZ;
  
  public zzayx(int paramInt, zzayz[] paramArrayOfzzayz, String[] paramArrayOfString)
  {
    this.RW = paramInt;
    this.RX = paramArrayOfzzayz;
    this.RZ = new TreeMap();
    int i = paramArrayOfzzayz.length;
    paramInt = 0;
    while (paramInt < i)
    {
      zzayz localzzayz = paramArrayOfzzayz[paramInt];
      this.RZ.put(localzzayz.name, localzzayz);
      paramInt += 1;
    }
    this.RY = paramArrayOfString;
    if (this.RY != null) {
      Arrays.sort(this.RY);
    }
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramObject != null)
    {
      bool1 = bool2;
      if ((paramObject instanceof zzayx))
      {
        paramObject = (zzayx)paramObject;
        bool1 = bool2;
        if (this.RW == paramObject.RW)
        {
          bool1 = bool2;
          if (b.c(this.RZ, paramObject.RZ))
          {
            bool1 = bool2;
            if (Arrays.equals(this.RY, paramObject.RY)) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("Configuration(");
    localStringBuilder.append(this.RW);
    localStringBuilder.append(", ");
    localStringBuilder.append("(");
    Object localObject = this.RZ.values().iterator();
    while (((Iterator)localObject).hasNext())
    {
      localStringBuilder.append((zzayz)((Iterator)localObject).next());
      localStringBuilder.append(", ");
    }
    localStringBuilder.append(")");
    localStringBuilder.append(", ");
    localStringBuilder.append("(");
    if (this.RY != null)
    {
      localObject = this.RY;
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        localStringBuilder.append(localObject[i]);
        localStringBuilder.append(", ");
        i += 1;
      }
    }
    localStringBuilder.append("null");
    localStringBuilder.append(")");
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    cm.a(this, paramParcel, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.zzayx
 * JD-Core Version:    0.7.0.1
 */