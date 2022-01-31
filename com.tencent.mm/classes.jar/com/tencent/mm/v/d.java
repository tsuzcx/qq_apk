package com.tencent.mm.v;

import a.d.b.g;
import com.tencent.mm.api.e;
import com.tencent.mm.w.b;

public final class d
{
  final int bMU;
  public final e dBy;
  public final b dBz;
  
  public d(int paramInt, e parame, b paramb)
  {
    this.bMU = paramInt;
    this.dBy = parame;
    this.dBz = paramb;
  }
  
  public final boolean equals(Object paramObject)
  {
    if ((paramObject instanceof d)) {
      return g.e(((d)paramObject).dBy.rO(), this.dBy.rO());
    }
    return false;
  }
  
  public final String toString()
  {
    return "FunctionMsgTask(mOpCode=" + this.bMU + ", mItem=" + this.dBy + ')';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.v.d
 * JD-Core Version:    0.7.0.1
 */