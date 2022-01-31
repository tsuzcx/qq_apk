package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.plugin.sns.ui.be;
import com.tencent.mm.protocal.c.bxk;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class at
  implements e
{
  public List<WeakReference<e>> otS = new LinkedList();
  
  public final void a(int paramInt, String paramString, long paramLong, bxk parambxk, boolean paramBoolean)
  {
    Iterator localIterator = this.otS.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if ((localWeakReference != null) && (localWeakReference.get() != null)) {
        ((e)localWeakReference.get()).a(paramInt, paramString, paramLong, parambxk, paramBoolean);
      }
    }
  }
  
  public final void a(int paramInt, String paramString, long paramLong, bxk parambxk, boolean paramBoolean, be parambe)
  {
    Iterator localIterator = this.otS.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if ((localWeakReference != null) && (localWeakReference.get() != null)) {
        ((e)localWeakReference.get()).a(paramInt, paramString, paramLong, parambxk, paramBoolean, parambe);
      }
    }
  }
  
  public final void a(e parame)
  {
    Iterator localIterator = this.otS.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if ((localWeakReference != null) && (localWeakReference.get() != null) && (((e)localWeakReference.get()).equals(parame))) {
        return;
      }
    }
    this.otS.add(new WeakReference(parame));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.at
 * JD-Core Version:    0.7.0.1
 */