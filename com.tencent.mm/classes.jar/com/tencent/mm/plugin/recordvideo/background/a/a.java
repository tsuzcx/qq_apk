package com.tencent.mm.plugin.recordvideo.background.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.b.c;
import d.g.b.p;
import d.l;
import java.util.Arrays;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/background/data/VideoMixData;", "", "captureInfo", "Lcom/tencent/mm/plugin/recordvideo/config/CaptureInfo;", "editorItems", "", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "drawingRect", "", "validRect", "mixVideoPath", "", "mixThumbPath", "retryTime", "", "useSoftEncode", "", "enableHevc", "thumbShortSide", "blurBgPath", "(Lcom/tencent/mm/plugin/recordvideo/config/CaptureInfo;Ljava/util/List;[F[FLjava/lang/String;Ljava/lang/String;IZZILjava/lang/String;)V", "getBlurBgPath", "()Ljava/lang/String;", "setBlurBgPath", "(Ljava/lang/String;)V", "getCaptureInfo", "()Lcom/tencent/mm/plugin/recordvideo/config/CaptureInfo;", "setCaptureInfo", "(Lcom/tencent/mm/plugin/recordvideo/config/CaptureInfo;)V", "getDrawingRect", "()[F", "setDrawingRect", "([F)V", "getEditorItems", "()Ljava/util/List;", "setEditorItems", "(Ljava/util/List;)V", "getEnableHevc", "()Z", "setEnableHevc", "(Z)V", "getMixThumbPath", "setMixThumbPath", "getMixVideoPath", "setMixVideoPath", "getRetryTime", "()I", "setRetryTime", "(I)V", "getThumbShortSide", "setThumbShortSide", "getUseSoftEncode", "setUseSoftEncode", "getValidRect", "setValidRect", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "getEndTimeMs", "", "getStartTimeMs", "hashCode", "toString", "plugin-recordvideo_release"})
public final class a
{
  private int hiH;
  public boolean hpg;
  public boolean hph;
  public List<com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a> pYz;
  public c xKE;
  public float[] xKR;
  public float[] xKS;
  public String xKT;
  public String xKU;
  public int xKV;
  public String xKW;
  
  private a(c paramc, List<com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a> paramList, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, String paramString1, String paramString2, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, String paramString3)
  {
    AppMethodBeat.i(206545);
    this.xKE = paramc;
    this.pYz = paramList;
    this.xKR = paramArrayOfFloat1;
    this.xKS = paramArrayOfFloat2;
    this.xKT = paramString1;
    this.xKU = paramString2;
    this.hiH = paramInt1;
    this.hpg = paramBoolean1;
    this.hph = paramBoolean2;
    this.xKV = paramInt2;
    this.xKW = paramString3;
    AppMethodBeat.o(206545);
  }
  
  public final void awV(String paramString)
  {
    AppMethodBeat.i(206544);
    p.h(paramString, "<set-?>");
    this.xKT = paramString;
    AppMethodBeat.o(206544);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(206548);
    if (this != paramObject)
    {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((!p.i(this.xKE, paramObject.xKE)) || (!p.i(this.pYz, paramObject.pYz)) || (!p.i(this.xKR, paramObject.xKR)) || (!p.i(this.xKS, paramObject.xKS)) || (!p.i(this.xKT, paramObject.xKT)) || (!p.i(this.xKU, paramObject.xKU)) || (this.hiH != paramObject.hiH) || (this.hpg != paramObject.hpg) || (this.hph != paramObject.hph) || (this.xKV != paramObject.xKV) || (!p.i(this.xKW, paramObject.xKW))) {}
      }
    }
    else
    {
      AppMethodBeat.o(206548);
      return true;
    }
    AppMethodBeat.o(206548);
    return false;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(206543);
    Object localObject = new StringBuilder("VideoMixData(captureInfo=").append(this.xKE).append(", editorItems=").append(this.pYz).append(", drawingRect=");
    String str = Arrays.toString(this.xKR);
    p.g(str, "java.util.Arrays.toString(this)");
    localObject = str + ", mixVideoPath='" + this.xKT + "', mixThumbPath='" + this.xKU + "', retryTime=" + this.hiH + ", useSoftEncode=" + this.hpg + ", enableHevc=" + this.hph + ", thumbShortSide=" + this.xKV + ", blurBgPath='" + this.xKW + "')";
    AppMethodBeat.o(206543);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.background.a.a
 * JD-Core Version:    0.7.0.1
 */