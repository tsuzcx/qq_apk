package com.google.android.gms.internal;

import com.google.android.gms.common.api.j;
import java.util.ArrayList;
import java.util.Iterator;

final class ad
  extends ag
{
  private final ArrayList<j> PC;
  
  public ad(ArrayList<j> paramArrayList)
  {
    super(paramArrayList, (byte)0);
    Object localObject;
    this.PC = localObject;
  }
  
  public final void iC()
  {
    aa.d(this.Pw).Oy.PN = aa.g(this.Pw);
    Iterator localIterator = this.PC.iterator();
    while (localIterator.hasNext()) {
      ((j)localIterator.next()).a(aa.h(this.Pw), aa.d(this.Pw).Oy.PN);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.ad
 * JD-Core Version:    0.7.0.1
 */