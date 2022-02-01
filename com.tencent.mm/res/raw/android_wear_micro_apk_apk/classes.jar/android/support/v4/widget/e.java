package android.support.v4.widget;

import android.support.v4.b.o;
import android.support.v4.b.p;
import android.support.v4.b.r;
import java.util.ArrayList;
import java.util.HashSet;

public final class e<T>
{
  private final o<ArrayList<T>> pO = new p(10);
  private final r<T, ArrayList<T>> pP = new r();
  private final ArrayList<T> pQ = new ArrayList();
  private final HashSet<T> pR = new HashSet();
  
  private void a(T paramT, ArrayList<T> paramArrayList, HashSet<T> paramHashSet)
  {
    if (paramArrayList.contains(paramT)) {
      return;
    }
    if (paramHashSet.contains(paramT)) {
      throw new RuntimeException("This graph contains cyclic dependencies");
    }
    paramHashSet.add(paramT);
    ArrayList localArrayList = (ArrayList)this.pP.get(paramT);
    if (localArrayList != null)
    {
      int i = 0;
      int j = localArrayList.size();
      while (i < j)
      {
        a(localArrayList.get(i), paramArrayList, paramHashSet);
        i += 1;
      }
    }
    paramHashSet.remove(paramT);
    paramArrayList.add(paramT);
  }
  
  public final ArrayList<T> cg()
  {
    this.pQ.clear();
    this.pR.clear();
    int i = 0;
    int j = this.pP.size();
    while (i < j)
    {
      a(this.pP.keyAt(i), this.pQ, this.pR);
      i += 1;
    }
    return this.pQ;
  }
  
  public final void clear()
  {
    int j = this.pP.size();
    int i = 0;
    while (i < j)
    {
      ArrayList localArrayList = (ArrayList)this.pP.valueAt(i);
      if (localArrayList != null)
      {
        localArrayList.clear();
        this.pO.t(localArrayList);
      }
      i += 1;
    }
    this.pP.clear();
  }
  
  public final boolean contains(T paramT)
  {
    return this.pP.containsKey(paramT);
  }
  
  public final void f(T paramT1, T paramT2)
  {
    if ((!this.pP.containsKey(paramT1)) || (!this.pP.containsKey(paramT2))) {
      throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
    }
    ArrayList localArrayList2 = (ArrayList)this.pP.get(paramT1);
    ArrayList localArrayList1 = localArrayList2;
    if (localArrayList2 == null)
    {
      localArrayList2 = (ArrayList)this.pO.bC();
      localArrayList1 = localArrayList2;
      if (localArrayList2 == null) {
        localArrayList1 = new ArrayList();
      }
      this.pP.put(paramT1, localArrayList1);
    }
    localArrayList1.add(paramT2);
  }
  
  public final void x(T paramT)
  {
    if (!this.pP.containsKey(paramT)) {
      this.pP.put(paramT, null);
    }
  }
  
  public final boolean y(T paramT)
  {
    int j = this.pP.size();
    int i = 0;
    while (i < j)
    {
      ArrayList localArrayList = (ArrayList)this.pP.valueAt(i);
      if ((localArrayList != null) && (localArrayList.contains(paramT))) {
        return true;
      }
      i += 1;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.widget.e
 * JD-Core Version:    0.7.0.1
 */