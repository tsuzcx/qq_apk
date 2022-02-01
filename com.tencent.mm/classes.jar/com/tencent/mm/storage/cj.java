package com.tencent.mm.storage;

import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/storage/RecMsgReportInfo;", "", "mid", "", "idx", "", "style", "recInfo", "", "extData", "bizUsername", "(JIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBizUsername", "()Ljava/lang/String;", "getExtData", "getIdx", "()I", "getMid", "()J", "getRecInfo", "getStyle", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "plugin-biz_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class cj
{
  final String adln;
  final String extData;
  final String hUQ;
  final int idx;
  final long nVr;
  final int style;
  
  public cj(long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    this.nVr = paramLong;
    this.idx = paramInt1;
    this.style = paramInt2;
    this.adln = paramString1;
    this.extData = paramString2;
    this.hUQ = paramString3;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(248440);
    if (this == paramObject)
    {
      AppMethodBeat.o(248440);
      return true;
    }
    if (!(paramObject instanceof cj))
    {
      AppMethodBeat.o(248440);
      return false;
    }
    paramObject = (cj)paramObject;
    if (this.nVr != paramObject.nVr)
    {
      AppMethodBeat.o(248440);
      return false;
    }
    if (this.idx != paramObject.idx)
    {
      AppMethodBeat.o(248440);
      return false;
    }
    if (this.style != paramObject.style)
    {
      AppMethodBeat.o(248440);
      return false;
    }
    if (!s.p(this.adln, paramObject.adln))
    {
      AppMethodBeat.o(248440);
      return false;
    }
    if (!s.p(this.extData, paramObject.extData))
    {
      AppMethodBeat.o(248440);
      return false;
    }
    if (!s.p(this.hUQ, paramObject.hUQ))
    {
      AppMethodBeat.o(248440);
      return false;
    }
    AppMethodBeat.o(248440);
    return true;
  }
  
  public final int hashCode()
  {
    int k = 0;
    AppMethodBeat.i(248438);
    int m = q.a..ExternalSyntheticBackport0.m(this.nVr);
    int n = this.idx;
    int i1 = this.style;
    int i;
    int j;
    if (this.adln == null)
    {
      i = 0;
      if (this.extData != null) {
        break label99;
      }
      j = 0;
      label46:
      if (this.hUQ != null) {
        break label110;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(248438);
      return (j + (i + ((m * 31 + n) * 31 + i1) * 31) * 31) * 31 + k;
      i = this.adln.hashCode();
      break;
      label99:
      j = this.extData.hashCode();
      break label46;
      label110:
      k = this.hUQ.hashCode();
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(248436);
    String str = "RecMsgReportInfo(mid=" + this.nVr + ", idx=" + this.idx + ", style=" + this.style + ", recInfo=" + this.adln + ", extData=" + this.extData + ", bizUsername=" + this.hUQ + ')';
    AppMethodBeat.o(248436);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.storage.cj
 * JD-Core Version:    0.7.0.1
 */