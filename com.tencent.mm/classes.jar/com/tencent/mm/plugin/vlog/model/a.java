package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.base.ABAPrams;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/model/ABAResult;", "", "errCode", "", "width", "height", "bitrate", "abaParams", "Lcom/tencent/mm/plugin/sight/base/ABAPrams;", "(IIIILcom/tencent/mm/plugin/sight/base/ABAPrams;)V", "getAbaParams", "()Lcom/tencent/mm/plugin/sight/base/ABAPrams;", "getBitrate", "()I", "getErrCode", "getHeight", "getWidth", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public final ABAPrams Gbz;
  public final int bitrate;
  public final int errCode;
  public final int height;
  public final int width;
  
  public a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, ABAPrams paramABAPrams)
  {
    this.errCode = paramInt1;
    this.width = paramInt2;
    this.height = paramInt3;
    this.bitrate = paramInt4;
    this.Gbz = paramABAPrams;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(283495);
    if (this == paramObject)
    {
      AppMethodBeat.o(283495);
      return true;
    }
    if (!(paramObject instanceof a))
    {
      AppMethodBeat.o(283495);
      return false;
    }
    paramObject = (a)paramObject;
    if (this.errCode != paramObject.errCode)
    {
      AppMethodBeat.o(283495);
      return false;
    }
    if (this.width != paramObject.width)
    {
      AppMethodBeat.o(283495);
      return false;
    }
    if (this.height != paramObject.height)
    {
      AppMethodBeat.o(283495);
      return false;
    }
    if (this.bitrate != paramObject.bitrate)
    {
      AppMethodBeat.o(283495);
      return false;
    }
    if (!s.p(this.Gbz, paramObject.Gbz))
    {
      AppMethodBeat.o(283495);
      return false;
    }
    AppMethodBeat.o(283495);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(283484);
    int j = this.errCode;
    int k = this.width;
    int m = this.height;
    int n = this.bitrate;
    if (this.Gbz == null) {}
    for (int i = 0;; i = this.Gbz.hashCode())
    {
      AppMethodBeat.o(283484);
      return i + (((j * 31 + k) * 31 + m) * 31 + n) * 31;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(283475);
    String str = "ABAResult(errCode=" + this.errCode + ", width=" + this.width + ", height=" + this.height + ", bitrate=" + this.bitrate + ", abaParams=" + this.Gbz + ')';
    AppMethodBeat.o(283475);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.a
 * JD-Core Version:    0.7.0.1
 */