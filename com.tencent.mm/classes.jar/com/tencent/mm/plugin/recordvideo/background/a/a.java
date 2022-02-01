package com.tencent.mm.plugin.recordvideo.background.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.b.c;
import java.util.Arrays;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/background/data/VideoMixData;", "", "captureInfo", "Lcom/tencent/mm/plugin/recordvideo/config/CaptureInfo;", "editorItems", "", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "drawingRect", "", "validRect", "mixVideoPath", "", "mixThumbPath", "retryTime", "", "useSoftEncode", "", "enableHevc", "thumbShortSide", "blurBgPath", "(Lcom/tencent/mm/plugin/recordvideo/config/CaptureInfo;Ljava/util/List;[F[FLjava/lang/String;Ljava/lang/String;IZZILjava/lang/String;)V", "getBlurBgPath", "()Ljava/lang/String;", "setBlurBgPath", "(Ljava/lang/String;)V", "getCaptureInfo", "()Lcom/tencent/mm/plugin/recordvideo/config/CaptureInfo;", "setCaptureInfo", "(Lcom/tencent/mm/plugin/recordvideo/config/CaptureInfo;)V", "getDrawingRect", "()[F", "setDrawingRect", "([F)V", "getEditorItems", "()Ljava/util/List;", "setEditorItems", "(Ljava/util/List;)V", "getEnableHevc", "()Z", "setEnableHevc", "(Z)V", "getMixThumbPath", "setMixThumbPath", "getMixVideoPath", "setMixVideoPath", "getRetryTime", "()I", "setRetryTime", "(I)V", "getThumbShortSide", "setThumbShortSide", "getUseSoftEncode", "setUseSoftEncode", "getValidRect", "setValidRect", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "getEndTimeMs", "", "getStartTimeMs", "hashCode", "toString", "plugin-recordvideo_release"})
public final class a
{
  public c HGS;
  public float[] HHg;
  public float[] HHh;
  public String HHi;
  public String HHj;
  public int HHk;
  public String HHl;
  private int kQm;
  public boolean kSJ;
  public boolean kXp;
  public List<com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a> uVd;
  
  private a(c paramc, List<com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a> paramList, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, String paramString1, String paramString2, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, String paramString3)
  {
    AppMethodBeat.i(216695);
    this.HGS = paramc;
    this.uVd = paramList;
    this.HHg = paramArrayOfFloat1;
    this.HHh = paramArrayOfFloat2;
    this.HHi = paramString1;
    this.HHj = paramString2;
    this.kQm = paramInt1;
    this.kXp = paramBoolean1;
    this.kSJ = paramBoolean2;
    this.HHk = paramInt2;
    this.HHl = paramString3;
    AppMethodBeat.o(216695);
  }
  
  public final void aVP(String paramString)
  {
    AppMethodBeat.i(216693);
    p.k(paramString, "<set-?>");
    this.HHi = paramString;
    AppMethodBeat.o(216693);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(216699);
    if (this != paramObject)
    {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((!p.h(this.HGS, paramObject.HGS)) || (!p.h(this.uVd, paramObject.uVd)) || (!p.h(this.HHg, paramObject.HHg)) || (!p.h(this.HHh, paramObject.HHh)) || (!p.h(this.HHi, paramObject.HHi)) || (!p.h(this.HHj, paramObject.HHj)) || (this.kQm != paramObject.kQm) || (this.kXp != paramObject.kXp) || (this.kSJ != paramObject.kSJ) || (this.HHk != paramObject.HHk) || (!p.h(this.HHl, paramObject.HHl))) {}
      }
    }
    else
    {
      AppMethodBeat.o(216699);
      return true;
    }
    AppMethodBeat.o(216699);
    return false;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(216692);
    Object localObject = new StringBuilder("VideoMixData(captureInfo=").append(this.HGS).append(", editorItems=").append(this.uVd).append(", drawingRect=");
    String str = Arrays.toString(this.HHg);
    p.j(str, "java.util.Arrays.toString(this)");
    localObject = str + ", mixVideoPath='" + this.HHi + "', mixThumbPath='" + this.HHj + "', retryTime=" + this.kQm + ", useSoftEncode=" + this.kXp + ", enableHevc=" + this.kSJ + ", thumbShortSide=" + this.HHk + ", blurBgPath='" + this.HHl + "')";
    AppMethodBeat.o(216692);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.background.a.a
 * JD-Core Version:    0.7.0.1
 */