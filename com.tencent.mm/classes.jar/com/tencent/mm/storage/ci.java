package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/storage/RecMsgReportInfo;", "", "mid", "", "idx", "", "style", "recInfo", "", "extData", "bizUsername", "(JIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBizUsername", "()Ljava/lang/String;", "getExtData", "getIdx", "()I", "getMid", "()J", "getRecInfo", "getStyle", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "plugin-biz_release"})
public final class ci
{
  final String VHs;
  final String extData;
  final String fOX;
  final int idx;
  final long lqo;
  final int style;
  
  public ci(long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    this.lqo = paramLong;
    this.idx = paramInt1;
    this.style = paramInt2;
    this.VHs = paramString1;
    this.extData = paramString2;
    this.fOX = paramString3;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(206851);
    if (this != paramObject)
    {
      if ((paramObject instanceof ci))
      {
        paramObject = (ci)paramObject;
        if ((this.lqo != paramObject.lqo) || (this.idx != paramObject.idx) || (this.style != paramObject.style) || (!p.h(this.VHs, paramObject.VHs)) || (!p.h(this.extData, paramObject.extData)) || (!p.h(this.fOX, paramObject.fOX))) {}
      }
    }
    else
    {
      AppMethodBeat.o(206851);
      return true;
    }
    AppMethodBeat.o(206851);
    return false;
  }
  
  public final int hashCode()
  {
    int k = 0;
    AppMethodBeat.i(206850);
    long l = this.lqo;
    int m = (int)(l ^ l >>> 32);
    int n = this.idx;
    int i1 = this.style;
    String str = this.VHs;
    int i;
    if (str != null)
    {
      i = str.hashCode();
      str = this.extData;
      if (str == null) {
        break label127;
      }
    }
    label127:
    for (int j = str.hashCode();; j = 0)
    {
      str = this.fOX;
      if (str != null) {
        k = str.hashCode();
      }
      AppMethodBeat.o(206850);
      return (j + (i + ((m * 31 + n) * 31 + i1) * 31) * 31) * 31 + k;
      i = 0;
      break;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(206849);
    String str = "RecMsgReportInfo(mid=" + this.lqo + ", idx=" + this.idx + ", style=" + this.style + ", recInfo=" + this.VHs + ", extData=" + this.extData + ", bizUsername=" + this.fOX + ")";
    AppMethodBeat.o(206849);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.storage.ci
 * JD-Core Version:    0.7.0.1
 */