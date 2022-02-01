package com.tencent.mm.ui.n.b;

import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/magicemoji/jsapi/MEShakeBubblesAndAvatars$RotateAnimationPara;", "", "degree", "", "duration", "", "startOffset", "(FJJ)V", "getDegree", "()F", "setDegree", "(F)V", "getDuration", "()J", "setDuration", "(J)V", "getStartOffset", "setStartOffset", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
final class h$c
{
  float afxh;
  long cXM;
  long duration;
  
  public h$c(float paramFloat, long paramLong1, long paramLong2)
  {
    this.afxh = paramFloat;
    this.duration = paramLong1;
    this.cXM = paramLong2;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(249827);
    if (this == paramObject)
    {
      AppMethodBeat.o(249827);
      return true;
    }
    if (!(paramObject instanceof c))
    {
      AppMethodBeat.o(249827);
      return false;
    }
    paramObject = (c)paramObject;
    if (!s.p(Float.valueOf(this.afxh), Float.valueOf(paramObject.afxh)))
    {
      AppMethodBeat.o(249827);
      return false;
    }
    if (this.duration != paramObject.duration)
    {
      AppMethodBeat.o(249827);
      return false;
    }
    if (this.cXM != paramObject.cXM)
    {
      AppMethodBeat.o(249827);
      return false;
    }
    AppMethodBeat.o(249827);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(249824);
    int i = Float.floatToIntBits(this.afxh);
    int j = q.a..ExternalSyntheticBackport0.m(this.duration);
    int k = q.a..ExternalSyntheticBackport0.m(this.cXM);
    AppMethodBeat.o(249824);
    return (i * 31 + j) * 31 + k;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(249820);
    String str = "RotateAnimationPara(degree=" + this.afxh + ", duration=" + this.duration + ", startOffset=" + this.cXM + ')';
    AppMethodBeat.o(249820);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.n.b.h.c
 * JD-Core Version:    0.7.0.1
 */