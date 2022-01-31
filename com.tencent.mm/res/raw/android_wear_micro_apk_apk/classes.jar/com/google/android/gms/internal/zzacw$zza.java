package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class zzacw$zza
  extends zza
{
  public static final Parcelable.Creator<zza> CREATOR = new cb();
  final ArrayList<zzacw.zzb> PV;
  final String className;
  final int versionCode;
  
  zzacw$zza(int paramInt, String paramString, ArrayList<zzacw.zzb> paramArrayList)
  {
    this.versionCode = paramInt;
    this.className = paramString;
    this.PV = paramArrayList;
  }
  
  zzacw$zza(String paramString, Map<String, zzacs.zza<?, ?>> paramMap)
  {
    this.versionCode = 1;
    this.className = paramString;
    if (paramMap == null) {
      paramString = null;
    }
    for (;;)
    {
      this.PV = paramString;
      return;
      paramString = new ArrayList();
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        paramString.add(new zzacw.zzb(str, (zzacs.zza)paramMap.get(str)));
      }
    }
  }
  
  final HashMap<String, zzacs.zza<?, ?>> jA()
  {
    HashMap localHashMap = new HashMap();
    int j = this.PV.size();
    int i = 0;
    while (i < j)
    {
      zzacw.zzb localzzb = (zzacw.zzb)this.PV.get(i);
      localHashMap.put(localzzb.PW, localzzb.PX);
      i += 1;
    }
    return localHashMap;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    cb.a(this, paramParcel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.zzacw.zza
 * JD-Core Version:    0.7.0.1
 */