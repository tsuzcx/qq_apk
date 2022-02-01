package com.tencent.mm.sensitive.business;

import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sensitive.d.a;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sensitive/business/BusinessStackRecorder$MsgData;", "", "action", "", "pageName", "pageRef", "process", "timeStamp", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "getAction", "()Ljava/lang/String;", "business", "Lcom/tencent/mm/sensitive/IPluginSensitive$BUSINESS;", "getBusiness", "()Lcom/tencent/mm/sensitive/IPluginSensitive$BUSINESS;", "setBusiness", "(Lcom/tencent/mm/sensitive/IPluginSensitive$BUSINESS;)V", "getPageName", "getPageRef", "getProcess", "getTimeStamp", "()J", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "sensitive_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class BusinessStackRecorder$c
{
  final String action;
  final String acuG;
  d.a acuH;
  final String hJW;
  private final String mzg;
  private final long timeStamp;
  
  public BusinessStackRecorder$c(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
  {
    AppMethodBeat.i(241045);
    this.action = paramString1;
    this.hJW = paramString2;
    this.acuG = paramString3;
    this.mzg = paramString4;
    this.timeStamp = paramLong;
    AppMethodBeat.o(241045);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(241058);
    if ((paramObject != null) && ((paramObject instanceof c)) && (s.p(this.hJW, ((c)paramObject).hJW)) && (s.p(this.mzg, ((c)paramObject).mzg)))
    {
      AppMethodBeat.o(241058);
      return true;
    }
    AppMethodBeat.o(241058);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(241065);
    int i = this.action.hashCode();
    int j = this.hJW.hashCode();
    int k = this.acuG.hashCode();
    int m = this.mzg.hashCode();
    int n = q.a..ExternalSyntheticBackport0.m(this.timeStamp);
    AppMethodBeat.o(241065);
    return (((i * 31 + j) * 31 + k) * 31 + m) * 31 + n;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(241053);
    String str = "page:" + this.hJW + ", action:" + this.action + ", process:" + this.mzg + ", time:" + this.timeStamp;
    AppMethodBeat.o(241053);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.sensitive.business.BusinessStackRecorder.c
 * JD-Core Version:    0.7.0.1
 */