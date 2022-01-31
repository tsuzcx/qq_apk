package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.d;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class zzacw
  extends zza
{
  public static final Parcelable.Creator<zzacw> CREATOR = new ca();
  final int Hc;
  private final HashMap<String, Map<String, zzacs.zza<?, ?>>> PS;
  private final ArrayList<zzacw.zza> PT;
  private final String PU;
  
  zzacw(int paramInt, ArrayList<zzacw.zza> paramArrayList, String paramString)
  {
    this.Hc = paramInt;
    this.PT = null;
    HashMap localHashMap = new HashMap();
    int i = paramArrayList.size();
    paramInt = 0;
    while (paramInt < i)
    {
      zzacw.zza localzza = (zzacw.zza)paramArrayList.get(paramInt);
      localHashMap.put(localzza.className, localzza.jA());
      paramInt += 1;
    }
    this.PS = localHashMap;
    this.PU = ((String)d.u(paramString));
    jx();
  }
  
  private void jx()
  {
    Iterator localIterator1 = this.PS.keySet().iterator();
    while (localIterator1.hasNext())
    {
      Object localObject = (String)localIterator1.next();
      localObject = (Map)this.PS.get(localObject);
      Iterator localIterator2 = ((Map)localObject).keySet().iterator();
      while (localIterator2.hasNext()) {
        ((zzacs.zza)((Map)localObject).get((String)localIterator2.next())).a(this);
      }
    }
  }
  
  final ArrayList<zzacw.zza> jy()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.PS.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localArrayList.add(new zzacw.zza(str, (Map)this.PS.get(str)));
    }
    return localArrayList;
  }
  
  public final String jz()
  {
    return this.PU;
  }
  
  public final Map<String, zzacs.zza<?, ?>> p(String paramString)
  {
    return (Map)this.PS.get(paramString);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator1 = this.PS.keySet().iterator();
    while (localIterator1.hasNext())
    {
      Object localObject = (String)localIterator1.next();
      localStringBuilder.append((String)localObject).append(":\n");
      localObject = (Map)this.PS.get(localObject);
      Iterator localIterator2 = ((Map)localObject).keySet().iterator();
      while (localIterator2.hasNext())
      {
        String str = (String)localIterator2.next();
        localStringBuilder.append("  ").append(str).append(": ");
        localStringBuilder.append(((Map)localObject).get(str));
      }
    }
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ca.a(this, paramParcel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.zzacw
 * JD-Core Version:    0.7.0.1
 */