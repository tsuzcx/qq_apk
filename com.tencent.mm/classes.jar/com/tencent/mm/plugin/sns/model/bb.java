package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.bq;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class bb
  implements e
{
  public List<WeakReference<e>> DOu;
  
  public bb()
  {
    AppMethodBeat.i(95990);
    this.DOu = new LinkedList();
    AppMethodBeat.o(95990);
  }
  
  public final void a(int paramInt, String paramString, long paramLong, TimeLineObject paramTimeLineObject, boolean paramBoolean)
  {
    AppMethodBeat.i(95993);
    Iterator localIterator = this.DOu.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if ((localWeakReference != null) && (localWeakReference.get() != null)) {
        ((e)localWeakReference.get()).a(paramInt, paramString, paramLong, paramTimeLineObject, paramBoolean);
      }
    }
    AppMethodBeat.o(95993);
  }
  
  public final void a(int paramInt, String paramString, long paramLong, TimeLineObject paramTimeLineObject, boolean paramBoolean, bq parambq)
  {
    AppMethodBeat.i(95992);
    Iterator localIterator = this.DOu.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if ((localWeakReference != null) && (localWeakReference.get() != null)) {
        ((e)localWeakReference.get()).a(paramInt, paramString, paramLong, paramTimeLineObject, paramBoolean, parambq);
      }
    }
    AppMethodBeat.o(95992);
  }
  
  public final void a(e parame)
  {
    AppMethodBeat.i(95991);
    Iterator localIterator = this.DOu.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if ((localWeakReference != null) && (localWeakReference.get() != null) && (((e)localWeakReference.get()).equals(parame)))
      {
        AppMethodBeat.o(95991);
        return;
      }
    }
    this.DOu.add(new WeakReference(parame));
    AppMethodBeat.o(95991);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.bb
 * JD-Core Version:    0.7.0.1
 */