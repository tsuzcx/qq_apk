package com.tencent.mm.plugin.recordvideo.background.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.c.c;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/background/data/VideoMixData;", "", "captureInfo", "Lcom/tencent/mm/plugin/recordvideo/config/CaptureInfo;", "editorItems", "", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "drawingRect", "", "validRect", "mixVideoPath", "", "mixThumbPath", "retryTime", "", "useSoftEncode", "", "enableHevc", "thumbShortSide", "blurBgPath", "(Lcom/tencent/mm/plugin/recordvideo/config/CaptureInfo;Ljava/util/List;[F[FLjava/lang/String;Ljava/lang/String;IZZILjava/lang/String;)V", "getBlurBgPath", "()Ljava/lang/String;", "setBlurBgPath", "(Ljava/lang/String;)V", "getCaptureInfo", "()Lcom/tencent/mm/plugin/recordvideo/config/CaptureInfo;", "setCaptureInfo", "(Lcom/tencent/mm/plugin/recordvideo/config/CaptureInfo;)V", "getDrawingRect", "()[F", "setDrawingRect", "([F)V", "getEditorItems", "()Ljava/util/List;", "setEditorItems", "(Ljava/util/List;)V", "getEnableHevc", "()Z", "setEnableHevc", "(Z)V", "getMixThumbPath", "setMixThumbPath", "getMixVideoPath", "setMixVideoPath", "getRetryTime", "()I", "setRetryTime", "(I)V", "getThumbShortSide", "setThumbShortSide", "getUseSoftEncode", "setUseSoftEncode", "getValidRect", "setValidRect", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "getEndTimeMs", "", "getStartTimeMs", "hashCode", "toString", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public float[] NEA;
  public float[] NEB;
  public String NEC;
  public String NED;
  public int NEE;
  public String NEF;
  public c NEp;
  public boolean nBZ;
  private int nrO;
  public boolean nyh;
  public List<com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a> yhJ;
  
  private a(c paramc, List<com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a> paramList, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, String paramString1, String paramString2, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, String paramString3)
  {
    AppMethodBeat.i(279489);
    this.NEp = paramc;
    this.yhJ = paramList;
    this.NEA = paramArrayOfFloat1;
    this.NEB = paramArrayOfFloat2;
    this.NEC = paramString1;
    this.NED = paramString2;
    this.nrO = paramInt1;
    this.nBZ = paramBoolean1;
    this.nyh = paramBoolean2;
    this.NEE = paramInt2;
    this.NEF = paramString3;
    AppMethodBeat.o(279489);
  }
  
  public final void aSX(String paramString)
  {
    AppMethodBeat.i(279492);
    s.u(paramString, "<set-?>");
    this.NEC = paramString;
    AppMethodBeat.o(279492);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(279495);
    if (this == paramObject)
    {
      AppMethodBeat.o(279495);
      return true;
    }
    if (!(paramObject instanceof a))
    {
      AppMethodBeat.o(279495);
      return false;
    }
    paramObject = (a)paramObject;
    if (!s.p(this.NEp, paramObject.NEp))
    {
      AppMethodBeat.o(279495);
      return false;
    }
    if (!s.p(this.yhJ, paramObject.yhJ))
    {
      AppMethodBeat.o(279495);
      return false;
    }
    if (!s.p(this.NEA, paramObject.NEA))
    {
      AppMethodBeat.o(279495);
      return false;
    }
    if (!s.p(this.NEB, paramObject.NEB))
    {
      AppMethodBeat.o(279495);
      return false;
    }
    if (!s.p(this.NEC, paramObject.NEC))
    {
      AppMethodBeat.o(279495);
      return false;
    }
    if (!s.p(this.NED, paramObject.NED))
    {
      AppMethodBeat.o(279495);
      return false;
    }
    if (this.nrO != paramObject.nrO)
    {
      AppMethodBeat.o(279495);
      return false;
    }
    if (this.nBZ != paramObject.nBZ)
    {
      AppMethodBeat.o(279495);
      return false;
    }
    if (this.nyh != paramObject.nyh)
    {
      AppMethodBeat.o(279495);
      return false;
    }
    if (this.NEE != paramObject.NEE)
    {
      AppMethodBeat.o(279495);
      return false;
    }
    if (!s.p(this.NEF, paramObject.NEF))
    {
      AppMethodBeat.o(279495);
      return false;
    }
    AppMethodBeat.o(279495);
    return true;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(279493);
    Object localObject = new StringBuilder("VideoMixData(captureInfo=").append(this.NEp).append(", editorItems=").append(this.yhJ).append(", drawingRect=");
    String str = Arrays.toString(this.NEA);
    s.s(str, "java.util.Arrays.toString(this)");
    localObject = str + ", mixVideoPath='" + this.NEC + "', mixThumbPath='" + this.NED + "', retryTime=" + this.nrO + ", useSoftEncode=" + this.nBZ + ", enableHevc=" + this.nyh + ", thumbShortSide=" + this.NEE + ", blurBgPath='" + this.NEF + "')";
    AppMethodBeat.o(279493);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.background.a.a
 * JD-Core Version:    0.7.0.1
 */