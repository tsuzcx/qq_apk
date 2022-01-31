package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.SparseArray;
import com.google.android.gms.common.internal.d;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.util.i;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class zzacz
  extends zzact
{
  public static final Parcelable.Creator<zzacz> CREATOR = new cc();
  private final int Hc;
  private final zzacw PQ;
  private final Parcel PY;
  private final int PZ;
  private int Qa;
  private int Qb;
  private final String dp;
  
  zzacz(int paramInt, Parcel paramParcel, zzacw paramzzacw)
  {
    this.Hc = paramInt;
    this.PY = ((Parcel)d.u(paramParcel));
    this.PZ = 2;
    this.PQ = paramzzacw;
    if (this.PQ == null) {}
    for (this.dp = null;; this.dp = this.PQ.jz())
    {
      this.Qa = 2;
      return;
    }
  }
  
  private static void a(StringBuilder paramStringBuilder, int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException(26 + "Unknown type = " + paramInt);
    case 0: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
      paramStringBuilder.append(paramObject);
      return;
    case 7: 
      paramStringBuilder.append("\"").append(i.n(paramObject.toString())).append("\"");
      return;
    case 8: 
      paramStringBuilder.append("\"").append(com.google.android.gms.common.util.c.a((byte[])paramObject)).append("\"");
      return;
    case 9: 
      paramStringBuilder.append("\"").append(com.google.android.gms.common.util.c.b((byte[])paramObject));
      paramStringBuilder.append("\"");
      return;
    case 10: 
      paramObject = (HashMap)paramObject;
      paramStringBuilder.append("{");
      Iterator localIterator = paramObject.keySet().iterator();
      paramInt = 1;
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        if (paramInt == 0) {
          paramStringBuilder.append(",");
        }
        String str2;
        for (;;)
        {
          str2 = (String)paramObject.get(str1);
          paramStringBuilder.append("\"").append(str1).append("\":");
          if (str2 != null) {
            break label274;
          }
          paramStringBuilder.append("null");
          break;
          paramInt = 0;
        }
        label274:
        paramStringBuilder.append("\"").append(str2).append("\"");
      }
      paramStringBuilder.append("}");
      return;
    }
    throw new IllegalArgumentException("Method does not accept concrete type.");
  }
  
  private void a(StringBuilder paramStringBuilder, zzacs.zza<?, ?> paramzza, Parcel paramParcel, int paramInt)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject4 = null;
    Object localObject5 = null;
    String str = null;
    int j = 0;
    int i = 0;
    if (paramzza.jq())
    {
      paramStringBuilder.append("[");
      int k;
      switch (paramzza.jp())
      {
      default: 
        throw new IllegalStateException("Unknown field type out.");
      case 0: 
        paramInt = a.a(paramParcel, paramInt);
        j = paramParcel.dataPosition();
        if (paramInt == 0) {
          paramzza = str;
        }
        for (;;)
        {
          j = paramzza.length;
          paramInt = i;
          while (paramInt < j)
          {
            if (paramInt != 0) {
              paramStringBuilder.append(",");
            }
            paramStringBuilder.append(Integer.toString(paramzza[paramInt]));
            paramInt += 1;
          }
          paramzza = paramParcel.createIntArray();
          paramParcel.setDataPosition(paramInt + j);
        }
      case 1: 
        i = a.a(paramParcel, paramInt);
        k = paramParcel.dataPosition();
        if (i == 0)
        {
          paramzza = localObject1;
          com.google.android.gms.common.util.b.a(paramStringBuilder, paramzza);
        }
        break;
      }
      for (;;)
      {
        paramStringBuilder.append("]");
        return;
        int m = paramParcel.readInt();
        paramzza = new BigInteger[m];
        paramInt = j;
        while (paramInt < m)
        {
          paramzza[paramInt] = new BigInteger(paramParcel.createByteArray());
          paramInt += 1;
        }
        paramParcel.setDataPosition(i + k);
        break;
        paramInt = a.a(paramParcel, paramInt);
        i = paramParcel.dataPosition();
        if (paramInt == 0) {
          paramzza = localObject2;
        }
        for (;;)
        {
          com.google.android.gms.common.util.b.a(paramStringBuilder, paramzza);
          break;
          paramzza = paramParcel.createLongArray();
          paramParcel.setDataPosition(paramInt + i);
        }
        paramInt = a.a(paramParcel, paramInt);
        i = paramParcel.dataPosition();
        if (paramInt == 0) {
          paramzza = localObject3;
        }
        for (;;)
        {
          com.google.android.gms.common.util.b.a(paramStringBuilder, paramzza);
          break;
          paramzza = paramParcel.createFloatArray();
          paramParcel.setDataPosition(paramInt + i);
        }
        paramInt = a.a(paramParcel, paramInt);
        i = paramParcel.dataPosition();
        if (paramInt == 0) {
          paramzza = localObject4;
        }
        for (;;)
        {
          com.google.android.gms.common.util.b.a(paramStringBuilder, paramzza);
          break;
          paramzza = paramParcel.createDoubleArray();
          paramParcel.setDataPosition(paramInt + i);
        }
        com.google.android.gms.common.util.b.a(paramStringBuilder, a.p(paramParcel, paramInt));
        continue;
        paramInt = a.a(paramParcel, paramInt);
        i = paramParcel.dataPosition();
        if (paramInt == 0) {
          paramzza = localObject5;
        }
        for (;;)
        {
          com.google.android.gms.common.util.b.a(paramStringBuilder, paramzza);
          break;
          paramzza = paramParcel.createBooleanArray();
          paramParcel.setDataPosition(paramInt + i);
        }
        com.google.android.gms.common.util.b.a(paramStringBuilder, a.q(paramParcel, paramInt));
        continue;
        throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
        paramParcel = a.s(paramParcel, paramInt);
        i = paramParcel.length;
        paramInt = 0;
        while (paramInt < i)
        {
          if (paramInt > 0) {
            paramStringBuilder.append(",");
          }
          paramParcel[paramInt].setDataPosition(0);
          a(paramStringBuilder, paramzza.jw(), paramParcel[paramInt]);
          paramInt += 1;
        }
      }
    }
    switch (paramzza.jp())
    {
    default: 
      throw new IllegalStateException("Unknown field type out");
    case 0: 
      paramStringBuilder.append(a.e(paramParcel, paramInt));
      return;
    case 1: 
      paramStringBuilder.append(a.h(paramParcel, paramInt));
      return;
    case 2: 
      paramStringBuilder.append(a.g(paramParcel, paramInt));
      return;
    case 3: 
      paramStringBuilder.append(a.i(paramParcel, paramInt));
      return;
    case 4: 
      paramStringBuilder.append(a.j(paramParcel, paramInt));
      return;
    case 5: 
      paramStringBuilder.append(a.k(paramParcel, paramInt));
      return;
    case 6: 
      paramStringBuilder.append(a.c(paramParcel, paramInt));
      return;
    case 7: 
      paramzza = a.l(paramParcel, paramInt);
      paramStringBuilder.append("\"").append(i.n(paramzza)).append("\"");
      return;
    case 8: 
      paramzza = a.o(paramParcel, paramInt);
      paramStringBuilder.append("\"").append(com.google.android.gms.common.util.c.a(paramzza)).append("\"");
      return;
    case 9: 
      paramzza = a.o(paramParcel, paramInt);
      paramStringBuilder.append("\"").append(com.google.android.gms.common.util.c.b(paramzza));
      paramStringBuilder.append("\"");
      return;
    case 10: 
      paramzza = a.n(paramParcel, paramInt);
      paramParcel = paramzza.keySet();
      paramParcel.size();
      paramStringBuilder.append("{");
      paramParcel = paramParcel.iterator();
      for (paramInt = 1; paramParcel.hasNext(); paramInt = 0)
      {
        str = (String)paramParcel.next();
        if (paramInt == 0) {
          paramStringBuilder.append(",");
        }
        paramStringBuilder.append("\"").append(str).append("\"");
        paramStringBuilder.append(":");
        paramStringBuilder.append("\"").append(i.n(paramzza.getString(str))).append("\"");
      }
      paramStringBuilder.append("}");
      return;
    }
    paramParcel = a.r(paramParcel, paramInt);
    paramParcel.setDataPosition(0);
    a(paramStringBuilder, paramzza.jw(), paramParcel);
  }
  
  private void a(StringBuilder paramStringBuilder, zzacs.zza<?, ?> paramzza, Object paramObject)
  {
    if (paramzza.jo())
    {
      paramObject = (ArrayList)paramObject;
      paramStringBuilder.append("[");
      int j = paramObject.size();
      int i = 0;
      while (i < j)
      {
        if (i != 0) {
          paramStringBuilder.append(",");
        }
        a(paramStringBuilder, paramzza.jn(), paramObject.get(i));
        i += 1;
      }
      paramStringBuilder.append("]");
      return;
    }
    a(paramStringBuilder, paramzza.jn(), paramObject);
  }
  
  private void a(StringBuilder paramStringBuilder, Map<String, zzacs.zza<?, ?>> paramMap, Parcel paramParcel)
  {
    SparseArray localSparseArray = new SparseArray();
    paramMap = paramMap.entrySet().iterator();
    Object localObject;
    while (paramMap.hasNext())
    {
      localObject = (Map.Entry)paramMap.next();
      localSparseArray.put(((zzacs.zza)((Map.Entry)localObject).getValue()).js(), localObject);
    }
    paramStringBuilder.append('{');
    int j = a.a(paramParcel);
    int i = 0;
    while (paramParcel.dataPosition() < j)
    {
      int k = paramParcel.readInt();
      localObject = (Map.Entry)localSparseArray.get(0xFFFF & k);
      if (localObject != null)
      {
        if (i != 0) {
          paramStringBuilder.append(",");
        }
        paramMap = (String)((Map.Entry)localObject).getKey();
        localObject = (zzacs.zza)((Map.Entry)localObject).getValue();
        paramStringBuilder.append("\"").append(paramMap).append("\":");
        if (((zzacs.zza)localObject).ju()) {
          switch (((zzacs.zza)localObject).jp())
          {
          default: 
            i = ((zzacs.zza)localObject).jp();
            throw new IllegalArgumentException(36 + "Unknown field out type = " + i);
          case 0: 
            a(paramStringBuilder, (zzacs.zza)localObject, a((zzacs.zza)localObject, Integer.valueOf(a.e(paramParcel, k))));
          }
        }
        for (;;)
        {
          i = 1;
          break;
          a(paramStringBuilder, (zzacs.zza)localObject, a((zzacs.zza)localObject, a.h(paramParcel, k)));
          continue;
          a(paramStringBuilder, (zzacs.zza)localObject, a((zzacs.zza)localObject, Long.valueOf(a.g(paramParcel, k))));
          continue;
          a(paramStringBuilder, (zzacs.zza)localObject, a((zzacs.zza)localObject, Float.valueOf(a.i(paramParcel, k))));
          continue;
          a(paramStringBuilder, (zzacs.zza)localObject, a((zzacs.zza)localObject, Double.valueOf(a.j(paramParcel, k))));
          continue;
          a(paramStringBuilder, (zzacs.zza)localObject, a((zzacs.zza)localObject, a.k(paramParcel, k)));
          continue;
          a(paramStringBuilder, (zzacs.zza)localObject, a((zzacs.zza)localObject, Boolean.valueOf(a.c(paramParcel, k))));
          continue;
          a(paramStringBuilder, (zzacs.zza)localObject, a((zzacs.zza)localObject, a.l(paramParcel, k)));
          continue;
          a(paramStringBuilder, (zzacs.zza)localObject, a((zzacs.zza)localObject, a.o(paramParcel, k)));
          continue;
          a(paramStringBuilder, (zzacs.zza)localObject, a((zzacs.zza)localObject, k(a.n(paramParcel, k))));
          continue;
          throw new IllegalArgumentException("Method does not accept concrete type.");
          a(paramStringBuilder, (zzacs.zza)localObject, paramParcel, k);
        }
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new com.google.android.gms.common.internal.safeparcel.b(37 + "Overread allowed size end=" + j, paramParcel);
    }
    paramStringBuilder.append('}');
  }
  
  private static HashMap<String, String> k(Bundle paramBundle)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localHashMap.put(str, paramBundle.getString(str));
    }
    return localHashMap;
  }
  
  public final int getVersionCode()
  {
    return this.Hc;
  }
  
  public final Parcel jB()
  {
    switch (this.Qa)
    {
    }
    for (;;)
    {
      return this.PY;
      this.Qb = com.google.android.gms.common.internal.safeparcel.c.b(this.PY);
      com.google.android.gms.common.internal.safeparcel.c.v(this.PY, this.Qb);
      this.Qa = 2;
    }
  }
  
  final zzacw jC()
  {
    switch (this.PZ)
    {
    default: 
      int i = this.PZ;
      throw new IllegalStateException(34 + "Invalid creation type: " + i);
    case 0: 
      return null;
    case 1: 
      return this.PQ;
    }
    return this.PQ;
  }
  
  public final Map<String, zzacs.zza<?, ?>> jl()
  {
    if (this.PQ == null) {
      return null;
    }
    return this.PQ.p(this.dp);
  }
  
  public final boolean jm()
  {
    throw new UnsupportedOperationException("Converting to JSON does not require this method.");
  }
  
  public String toString()
  {
    d.e(this.PQ, "Cannot convert to JSON on client side.");
    Parcel localParcel = jB();
    localParcel.setDataPosition(0);
    StringBuilder localStringBuilder = new StringBuilder(100);
    a(localStringBuilder, this.PQ.p(this.dp), localParcel);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    cc.a(this, paramParcel, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.zzacz
 * JD-Core Version:    0.7.0.1
 */