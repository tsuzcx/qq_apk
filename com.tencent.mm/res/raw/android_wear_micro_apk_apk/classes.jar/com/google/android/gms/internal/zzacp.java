package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.SparseArray;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public final class zzacp
  extends zza
  implements bx<String, Integer>
{
  public static final Parcelable.Creator<zzacp> CREATOR = new bv();
  final int Hc;
  private final HashMap<String, Integer> PD;
  private final SparseArray<String> PE;
  private final ArrayList<zzacp.zza> PF;
  
  public zzacp()
  {
    this.Hc = 1;
    this.PD = new HashMap();
    this.PE = new SparseArray();
    this.PF = null;
  }
  
  zzacp(int paramInt, ArrayList<zzacp.zza> paramArrayList)
  {
    this.Hc = paramInt;
    this.PD = new HashMap();
    this.PE = new SparseArray();
    this.PF = null;
    c(paramArrayList);
  }
  
  private void c(ArrayList<zzacp.zza> paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      zzacp.zza localzza = (zzacp.zza)paramArrayList.next();
      String str = localzza.PG;
      int i = localzza.PH;
      this.PD.put(str, Integer.valueOf(i));
      this.PE.put(i, str);
    }
  }
  
  final ArrayList<zzacp.zza> jk()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.PD.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localArrayList.add(new zzacp.zza(str, ((Integer)this.PD.get(str)).intValue()));
    }
    return localArrayList;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    bv.a(this, paramParcel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.zzacp
 * JD-Core Version:    0.7.0.1
 */