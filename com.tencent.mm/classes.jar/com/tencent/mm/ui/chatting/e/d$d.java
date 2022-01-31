package com.tencent.mm.ui.chatting.e;

import android.os.Bundle;
import android.util.SparseArray;
import java.util.LinkedList;
import java.util.List;

public final class d$d<T>
{
  public int dsw;
  public int nul = -1;
  public Bundle vyi;
  public d.a vyj;
  public List<T> vyk;
  public int vyl;
  public SparseArray<T> vym;
  
  d$d(d.a parama)
  {
    this.vyj = parama;
    this.vyk = new LinkedList();
  }
  
  public final String toString()
  {
    return "LoadedResult{sourceArgs=" + this.vyi + ", mode=" + this.vyj + ", selection=" + this.nul + ", count=" + this.vyl + ", totalCount=" + this.dsw + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.e.d.d
 * JD-Core Version:    0.7.0.1
 */