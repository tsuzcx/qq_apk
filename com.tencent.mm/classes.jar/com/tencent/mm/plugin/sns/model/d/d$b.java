package com.tencent.mm.plugin.sns.model.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(k=3, mv={1, 5, 1}, xi=48)
final class d$b
  extends kotlin.d.b.a.d
{
  int label;
  
  d$b(d paramd, kotlin.d.d<? super b> paramd1)
  {
    super(paramd1);
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(309638);
    this.result = paramObject;
    this.label |= 0x80000000;
    paramObject = this.QAV.f(null, 0, (kotlin.d.d)this);
    AppMethodBeat.o(309638);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.d.d.b
 * JD-Core Version:    0.7.0.1
 */