package com.google.android.gms.internal;

import com.google.android.gms.common.api.j;
import java.util.ArrayList;
import java.util.Iterator;

final class ad
  extends ag
{
  private final ArrayList<j> NN;
  
  public ad(ArrayList<j> paramArrayList)
  {
    super(paramArrayList, (byte)0);
    Object localObject;
    this.NN = localObject;
  }
  
  public final void iu()
  {
    aa.d(this.NH).MJ.NY = aa.g(this.NH);
    Iterator localIterator = this.NN.iterator();
    while (localIterator.hasNext()) {
      ((j)localIterator.next()).a(aa.h(this.NH), aa.d(this.NH).MJ.NY);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.ad
 * JD-Core Version:    0.7.0.1
 */