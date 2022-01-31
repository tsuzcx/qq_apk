package com.tencent.mm.plugin.record.b;

import android.util.SparseArray;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.record.a.b;
import com.tencent.mm.sdk.platformtools.ai;
import java.util.LinkedList;
import java.util.List;

public abstract class c<T extends b>
{
  private boolean nsO = false;
  final int nsP = 3;
  private final int nsQ = 300000;
  private SparseArray<c<T>.a> nsR = new SparseArray();
  private LinkedList<T> nsS = new LinkedList();
  private long nsT = 0L;
  
  protected abstract void a(T paramT);
  
  protected abstract List<T> bvw();
  
  protected final void bvx()
  {
    this.nsO = false;
    run();
  }
  
  final void finish()
  {
    this.nsS.clear();
    this.nsR.clear();
    this.nsO = false;
  }
  
  public final void run()
  {
    au.DS().O(new c.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.c
 * JD-Core Version:    0.7.0.1
 */