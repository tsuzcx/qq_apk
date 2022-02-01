package com.google.android.gms.wearable.internal;

import com.google.android.gms.internal.h;
import com.google.android.gms.wearable.v;
import java.util.ArrayList;
import java.util.List;

final class bq
  extends bn<v>
{
  public bq(h<v> paramh)
  {
    super(paramh);
  }
  
  public final void a(zzbl paramzzbl)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(paramzzbl.Vk);
    K(new az(bj.ca(paramzzbl.statusCode), localArrayList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.bq
 * JD-Core Version:    0.7.0.1
 */