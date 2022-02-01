package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/model/ExportResult;", "", "success", "", "canRetry", "isCancel", "result", "", "videoSoft", "audioSoft", "parallelExport", "(ZZZIZZZ)V", "getAudioSoft", "()Z", "setAudioSoft", "(Z)V", "getCanRetry", "setCanRetry", "setCancel", "getParallelExport", "setParallelExport", "getResult", "()I", "setResult", "(I)V", "getSuccess", "setSuccess", "getVideoSoft", "setVideoSoft", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
{
  boolean TXC;
  boolean TXD;
  boolean TYT;
  private boolean nzW;
  int result;
  public boolean success;
  public boolean ygJ;
  
  public k()
  {
    this(false, false, false, 127);
  }
  
  private k(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.success = paramBoolean1;
    this.ygJ = paramBoolean2;
    this.nzW = paramBoolean3;
    this.result = 0;
    this.TXC = false;
    this.TXD = false;
    this.TYT = false;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof k)) {
        return false;
      }
      paramObject = (k)paramObject;
      if (this.success != paramObject.success) {
        return false;
      }
      if (this.ygJ != paramObject.ygJ) {
        return false;
      }
      if (this.nzW != paramObject.nzW) {
        return false;
      }
      if (this.result != paramObject.result) {
        return false;
      }
      if (this.TXC != paramObject.TXC) {
        return false;
      }
      if (this.TXD != paramObject.TXD) {
        return false;
      }
    } while (this.TYT == paramObject.TYT);
    return false;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(283377);
    String str = "ExportResult(success=" + this.success + ", canRetry=" + this.ygJ + ", isCancel=" + this.nzW + ", result=" + this.result + ", videoSoft=" + this.TXC + ", audioSoft=" + this.TXD + ", parallelExport=" + this.TYT + ')';
    AppMethodBeat.o(283377);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.k
 * JD-Core Version:    0.7.0.1
 */