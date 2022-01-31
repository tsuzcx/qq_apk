package com.tencent.mm.plugin.offline;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public abstract class a<T>
{
  protected List<WeakReference<T>> mJE = new ArrayList();
  
  public final void bA(T paramT)
  {
    if ((this.mJE == null) || (paramT == null)) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.mJE.size())
      {
        WeakReference localWeakReference = (WeakReference)this.mJE.get(i);
        if (localWeakReference != null)
        {
          Object localObject = localWeakReference.get();
          if ((localObject != null) && (localObject.equals(paramT)))
          {
            localWeakReference.clear();
            this.mJE.remove(localWeakReference);
          }
        }
        i += 1;
      }
    }
  }
  
  public final void bz(T paramT)
  {
    if (this.mJE != null) {
      this.mJE = new ArrayList();
    }
    if (paramT != null) {
      this.mJE.add(new WeakReference(paramT));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.a
 * JD-Core Version:    0.7.0.1
 */