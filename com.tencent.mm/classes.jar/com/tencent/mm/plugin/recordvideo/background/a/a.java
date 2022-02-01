package com.tencent.mm.plugin.recordvideo.background.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.b.c;
import java.util.Arrays;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/background/data/VideoMixData;", "", "captureInfo", "Lcom/tencent/mm/plugin/recordvideo/config/CaptureInfo;", "editorItems", "", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "drawingRect", "", "validRect", "mixVideoPath", "", "mixThumbPath", "retryTime", "", "useSoftEncode", "", "enableHevc", "thumbShortSide", "blurBgPath", "(Lcom/tencent/mm/plugin/recordvideo/config/CaptureInfo;Ljava/util/List;[F[FLjava/lang/String;Ljava/lang/String;IZZILjava/lang/String;)V", "getBlurBgPath", "()Ljava/lang/String;", "setBlurBgPath", "(Ljava/lang/String;)V", "getCaptureInfo", "()Lcom/tencent/mm/plugin/recordvideo/config/CaptureInfo;", "setCaptureInfo", "(Lcom/tencent/mm/plugin/recordvideo/config/CaptureInfo;)V", "getDrawingRect", "()[F", "setDrawingRect", "([F)V", "getEditorItems", "()Ljava/util/List;", "setEditorItems", "(Ljava/util/List;)V", "getEnableHevc", "()Z", "setEnableHevc", "(Z)V", "getMixThumbPath", "setMixThumbPath", "getMixVideoPath", "setMixVideoPath", "getRetryTime", "()I", "setRetryTime", "(I)V", "getThumbShortSide", "setThumbShortSide", "getUseSoftEncode", "setUseSoftEncode", "getValidRect", "setValidRect", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "getEndTimeMs", "", "getStartTimeMs", "hashCode", "toString", "plugin-recordvideo_release"})
public final class a
{
  public c BKI;
  public float[] BKV;
  public float[] BKW;
  public String BKX;
  public String BKY;
  public int BKZ;
  public String BLa;
  private int ibF;
  public boolean iiC;
  public boolean iiD;
  public List<com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a> rpx;
  
  private a(c paramc, List<com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a> paramList, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, String paramString1, String paramString2, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, String paramString3)
  {
    AppMethodBeat.i(237250);
    this.BKI = paramc;
    this.rpx = paramList;
    this.BKV = paramArrayOfFloat1;
    this.BKW = paramArrayOfFloat2;
    this.BKX = paramString1;
    this.BKY = paramString2;
    this.ibF = paramInt1;
    this.iiC = paramBoolean1;
    this.iiD = paramBoolean2;
    this.BKZ = paramInt2;
    this.BLa = paramString3;
    AppMethodBeat.o(237250);
  }
  
  public final void aLn(String paramString)
  {
    AppMethodBeat.i(237249);
    p.h(paramString, "<set-?>");
    this.BKX = paramString;
    AppMethodBeat.o(237249);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(237253);
    if (this != paramObject)
    {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((!p.j(this.BKI, paramObject.BKI)) || (!p.j(this.rpx, paramObject.rpx)) || (!p.j(this.BKV, paramObject.BKV)) || (!p.j(this.BKW, paramObject.BKW)) || (!p.j(this.BKX, paramObject.BKX)) || (!p.j(this.BKY, paramObject.BKY)) || (this.ibF != paramObject.ibF) || (this.iiC != paramObject.iiC) || (this.iiD != paramObject.iiD) || (this.BKZ != paramObject.BKZ) || (!p.j(this.BLa, paramObject.BLa))) {}
      }
    }
    else
    {
      AppMethodBeat.o(237253);
      return true;
    }
    AppMethodBeat.o(237253);
    return false;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(237248);
    Object localObject = new StringBuilder("VideoMixData(captureInfo=").append(this.BKI).append(", editorItems=").append(this.rpx).append(", drawingRect=");
    String str = Arrays.toString(this.BKV);
    p.g(str, "java.util.Arrays.toString(this)");
    localObject = str + ", mixVideoPath='" + this.BKX + "', mixThumbPath='" + this.BKY + "', retryTime=" + this.ibF + ", useSoftEncode=" + this.iiC + ", enableHevc=" + this.iiD + ", thumbShortSide=" + this.BKZ + ", blurBgPath='" + this.BLa + "')";
    AppMethodBeat.o(237248);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.background.a.a
 * JD-Core Version:    0.7.0.1
 */