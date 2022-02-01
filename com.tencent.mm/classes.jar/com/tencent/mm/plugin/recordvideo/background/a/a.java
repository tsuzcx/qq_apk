package com.tencent.mm.plugin.recordvideo.background.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.b.c;
import d.g.b.p;
import d.l;
import java.util.Arrays;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/background/data/VideoMixData;", "", "captureInfo", "Lcom/tencent/mm/plugin/recordvideo/config/CaptureInfo;", "editorItems", "", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "drawingRect", "", "validRect", "mixVideoPath", "", "mixThumbPath", "retryTime", "", "useSoftEncode", "", "enableHevc", "thumbShortSide", "blurBgPath", "(Lcom/tencent/mm/plugin/recordvideo/config/CaptureInfo;Ljava/util/List;[F[FLjava/lang/String;Ljava/lang/String;IZZILjava/lang/String;)V", "getBlurBgPath", "()Ljava/lang/String;", "setBlurBgPath", "(Ljava/lang/String;)V", "getCaptureInfo", "()Lcom/tencent/mm/plugin/recordvideo/config/CaptureInfo;", "setCaptureInfo", "(Lcom/tencent/mm/plugin/recordvideo/config/CaptureInfo;)V", "getDrawingRect", "()[F", "setDrawingRect", "([F)V", "getEditorItems", "()Ljava/util/List;", "setEditorItems", "(Ljava/util/List;)V", "getEnableHevc", "()Z", "setEnableHevc", "(Z)V", "getMixThumbPath", "setMixThumbPath", "getMixVideoPath", "setMixVideoPath", "getRetryTime", "()I", "setRetryTime", "(I)V", "getThumbShortSide", "setThumbShortSide", "getUseSoftEncode", "setUseSoftEncode", "getValidRect", "setValidRect", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "getEndTimeMs", "", "getStartTimeMs", "hashCode", "toString", "plugin-recordvideo_release"})
public final class a
{
  private int hfT;
  public boolean hms;
  public boolean hmt;
  public List<com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a> pRU;
  public c xuH;
  public float[] xuU;
  public float[] xuV;
  public String xuW;
  public String xuX;
  public int xuY;
  public String xuZ;
  
  private a(c paramc, List<com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a> paramList, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, String paramString1, String paramString2, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, String paramString3)
  {
    AppMethodBeat.i(200284);
    this.xuH = paramc;
    this.pRU = paramList;
    this.xuU = paramArrayOfFloat1;
    this.xuV = paramArrayOfFloat2;
    this.xuW = paramString1;
    this.xuX = paramString2;
    this.hfT = paramInt1;
    this.hms = paramBoolean1;
    this.hmt = paramBoolean2;
    this.xuY = paramInt2;
    this.xuZ = paramString3;
    AppMethodBeat.o(200284);
  }
  
  public final void avG(String paramString)
  {
    AppMethodBeat.i(200283);
    p.h(paramString, "<set-?>");
    this.xuW = paramString;
    AppMethodBeat.o(200283);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(200287);
    if (this != paramObject)
    {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((!p.i(this.xuH, paramObject.xuH)) || (!p.i(this.pRU, paramObject.pRU)) || (!p.i(this.xuU, paramObject.xuU)) || (!p.i(this.xuV, paramObject.xuV)) || (!p.i(this.xuW, paramObject.xuW)) || (!p.i(this.xuX, paramObject.xuX)) || (this.hfT != paramObject.hfT) || (this.hms != paramObject.hms) || (this.hmt != paramObject.hmt) || (this.xuY != paramObject.xuY) || (!p.i(this.xuZ, paramObject.xuZ))) {}
      }
    }
    else
    {
      AppMethodBeat.o(200287);
      return true;
    }
    AppMethodBeat.o(200287);
    return false;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(200282);
    Object localObject = new StringBuilder("VideoMixData(captureInfo=").append(this.xuH).append(", editorItems=").append(this.pRU).append(", drawingRect=");
    String str = Arrays.toString(this.xuU);
    p.g(str, "java.util.Arrays.toString(this)");
    localObject = str + ", mixVideoPath='" + this.xuW + "', mixThumbPath='" + this.xuX + "', retryTime=" + this.hfT + ", useSoftEncode=" + this.hms + ", enableHevc=" + this.hmt + ", thumbShortSide=" + this.xuY + ", blurBgPath='" + this.xuZ + "')";
    AppMethodBeat.o(200282);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.background.a.a
 * JD-Core Version:    0.7.0.1
 */