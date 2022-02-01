package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/vlog/model/MultiMediaVideoChecker$VideoInfo;", "", "width", "", "height", "fps", "", "duration", "", "bitrate", "rotate", "isH265", "", "(IIFJIIZ)V", "getBitrate", "()I", "getDuration", "()J", "getFps", "()F", "getHeight", "()Z", "getRotate", "getWidth", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "", "plugin-vlog_release"})
public final class l$a
{
  public final int bitrate;
  public final float clj;
  final int duc;
  public final long duration;
  public final int height;
  public final boolean uPV;
  public final int width;
  
  public l$a(int paramInt1, int paramInt2, float paramFloat, long paramLong, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    this.width = paramInt1;
    this.height = paramInt2;
    this.clj = paramFloat;
    this.duration = paramLong;
    this.bitrate = paramInt3;
    this.duc = paramInt4;
    this.uPV = paramBoolean;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(207537);
    if (this != paramObject)
    {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((this.width != paramObject.width) || (this.height != paramObject.height) || (Float.compare(this.clj, paramObject.clj) != 0) || (this.duration != paramObject.duration) || (this.bitrate != paramObject.bitrate) || (this.duc != paramObject.duc) || (this.uPV != paramObject.uPV)) {}
      }
    }
    else
    {
      AppMethodBeat.o(207537);
      return true;
    }
    AppMethodBeat.o(207537);
    return false;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(207535);
    String str = "VideoInfo(width=" + this.width + ", height=" + this.height + ", fps=" + this.clj + ", duration=" + this.duration + ", bitrate=" + this.bitrate + ", rotate=" + this.duc + ", isH265=" + this.uPV + ")";
    AppMethodBeat.o(207535);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.l.a
 * JD-Core Version:    0.7.0.1
 */