package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.bn;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ay
  implements d
{
  public List<WeakReference<d>> znc;
  
  public ay()
  {
    AppMethodBeat.i(95990);
    this.znc = new LinkedList();
    AppMethodBeat.o(95990);
  }
  
  public final void a(int paramInt, String paramString, long paramLong, TimeLineObject paramTimeLineObject, boolean paramBoolean)
  {
    AppMethodBeat.i(95993);
    Iterator localIterator = this.znc.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if ((localWeakReference != null) && (localWeakReference.get() != null)) {
        ((d)localWeakReference.get()).a(paramInt, paramString, paramLong, paramTimeLineObject, paramBoolean);
      }
    }
    AppMethodBeat.o(95993);
  }
  
  public final void a(int paramInt, String paramString, long paramLong, TimeLineObject paramTimeLineObject, boolean paramBoolean, bn parambn)
  {
    AppMethodBeat.i(95992);
    Iterator localIterator = this.znc.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if ((localWeakReference != null) && (localWeakReference.get() != null)) {
        ((d)localWeakReference.get()).a(paramInt, paramString, paramLong, paramTimeLineObject, paramBoolean, parambn);
      }
    }
    AppMethodBeat.o(95992);
  }
  
  public final void a(d paramd)
  {
    AppMethodBeat.i(95991);
    Iterator localIterator = this.znc.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if ((localWeakReference != null) && (localWeakReference.get() != null) && (((d)localWeakReference.get()).equals(paramd)))
      {
        AppMethodBeat.o(95991);
        return;
      }
    }
    this.znc.add(new WeakReference(paramd));
    AppMethodBeat.o(95991);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ay
 * JD-Core Version:    0.7.0.1
 */