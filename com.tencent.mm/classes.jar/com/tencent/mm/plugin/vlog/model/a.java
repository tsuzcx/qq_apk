package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import java.util.Arrays;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/model/ABAResult;", "", "errCode", "", "width", "height", "bitrate", "abaParams", "", "(IIII[I)V", "getAbaParams", "()[I", "getBitrate", "()I", "getErrCode", "getHeight", "getWidth", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-vlog_release"})
public final class a
{
  final int bitrate;
  final int errCode;
  final int height;
  final int[] sTT;
  final int width;
  
  public a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    this.errCode = paramInt1;
    this.width = paramInt2;
    this.height = paramInt3;
    this.bitrate = paramInt4;
    this.sTT = paramArrayOfInt;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(191139);
    if (this != paramObject)
    {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((this.errCode != paramObject.errCode) || (this.width != paramObject.width) || (this.height != paramObject.height) || (this.bitrate != paramObject.bitrate) || (!p.i(this.sTT, paramObject.sTT))) {}
      }
    }
    else
    {
      AppMethodBeat.o(191139);
      return true;
    }
    AppMethodBeat.o(191139);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(191138);
    int j = this.errCode;
    int k = this.width;
    int m = this.height;
    int n = this.bitrate;
    int[] arrayOfInt = this.sTT;
    if (arrayOfInt != null) {}
    for (int i = Arrays.hashCode(arrayOfInt);; i = 0)
    {
      AppMethodBeat.o(191138);
      return i + (((j * 31 + k) * 31 + m) * 31 + n) * 31;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(191137);
    String str = "ABAResult(errCode=" + this.errCode + ", width=" + this.width + ", height=" + this.height + ", bitrate=" + this.bitrate + ", abaParams=" + Arrays.toString(this.sTT) + ")";
    AppMethodBeat.o(191137);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.a
 * JD-Core Version:    0.7.0.1
 */