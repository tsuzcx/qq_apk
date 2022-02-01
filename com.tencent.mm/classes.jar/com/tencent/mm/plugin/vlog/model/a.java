package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/model/ABAResult;", "", "errCode", "", "width", "height", "bitrate", "abaParams", "", "(IIII[I)V", "getAbaParams", "()[I", "getBitrate", "()I", "getErrCode", "getHeight", "getWidth", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-vlog_release"})
public final class a
{
  final int bitrate;
  final int errCode;
  final int height;
  final int[] vRR;
  final int width;
  
  public a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    this.errCode = paramInt1;
    this.width = paramInt2;
    this.height = paramInt3;
    this.bitrate = paramInt4;
    this.vRR = paramArrayOfInt;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(190475);
    if (this != paramObject)
    {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((this.errCode != paramObject.errCode) || (this.width != paramObject.width) || (this.height != paramObject.height) || (this.bitrate != paramObject.bitrate) || (!p.j(this.vRR, paramObject.vRR))) {}
      }
    }
    else
    {
      AppMethodBeat.o(190475);
      return true;
    }
    AppMethodBeat.o(190475);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(190474);
    int j = this.errCode;
    int k = this.width;
    int m = this.height;
    int n = this.bitrate;
    int[] arrayOfInt = this.vRR;
    if (arrayOfInt != null) {}
    for (int i = Arrays.hashCode(arrayOfInt);; i = 0)
    {
      AppMethodBeat.o(190474);
      return i + (((j * 31 + k) * 31 + m) * 31 + n) * 31;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(190473);
    String str = "ABAResult(errCode=" + this.errCode + ", width=" + this.width + ", height=" + this.height + ", bitrate=" + this.bitrate + ", abaParams=" + Arrays.toString(this.vRR) + ")";
    AppMethodBeat.o(190473);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.a
 * JD-Core Version:    0.7.0.1
 */