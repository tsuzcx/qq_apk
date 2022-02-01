package com.tencent.mm.plugin.wxpayreport;

import androidx.compose.a.a.q..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/wxpayreport/LABColor;", "", "L", "", "a", "b", "(DDD)V", "getL", "()D", "getA", "getB", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-wxpay-report_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  final double XIM;
  final double a;
  final double b;
  
  public b(double paramDouble1, double paramDouble2, double paramDouble3)
  {
    this.XIM = paramDouble1;
    this.a = paramDouble2;
    this.b = paramDouble3;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(261087);
    if (this == paramObject)
    {
      AppMethodBeat.o(261087);
      return true;
    }
    if (!(paramObject instanceof b))
    {
      AppMethodBeat.o(261087);
      return false;
    }
    paramObject = (b)paramObject;
    if (!s.p(Double.valueOf(this.XIM), Double.valueOf(paramObject.XIM)))
    {
      AppMethodBeat.o(261087);
      return false;
    }
    if (!s.p(Double.valueOf(this.a), Double.valueOf(paramObject.a)))
    {
      AppMethodBeat.o(261087);
      return false;
    }
    if (!s.p(Double.valueOf(this.b), Double.valueOf(paramObject.b)))
    {
      AppMethodBeat.o(261087);
      return false;
    }
    AppMethodBeat.o(261087);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(261078);
    int i = q..ExternalSyntheticBackport0.m(this.XIM);
    int j = q..ExternalSyntheticBackport0.m(this.a);
    int k = q..ExternalSyntheticBackport0.m(this.b);
    AppMethodBeat.o(261078);
    return (i * 31 + j) * 31 + k;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(261072);
    String str = "LABColor(L=" + this.XIM + ", a=" + this.a + ", b=" + this.b + ')';
    AppMethodBeat.o(261072);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wxpayreport.b
 * JD-Core Version:    0.7.0.1
 */