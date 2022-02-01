package com.tencent.mm.plugin.recordvideo.ui.editor.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a;
import java.util.Arrays;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/RetrieverData;", "", "drawingRect", "", "validRect", "editorItems", "", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "width", "", "height", "videoWidth", "videoHeight", "rotate", "isForMix", "", "blurBgPath", "", "([F[FLjava/util/List;IIIIIZLjava/lang/String;)V", "getBlurBgPath", "()Ljava/lang/String;", "setBlurBgPath", "(Ljava/lang/String;)V", "getDrawingRect", "()[F", "setDrawingRect", "([F)V", "getEditorItems", "()Ljava/util/List;", "setEditorItems", "(Ljava/util/List;)V", "getHeight", "()I", "setHeight", "(I)V", "()Z", "setForMix", "(Z)V", "getRotate", "setRotate", "getValidRect", "setValidRect", "getVideoHeight", "setVideoHeight", "getVideoWidth", "setVideoWidth", "getWidth", "setWidth", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "plugin-recordvideo_release"})
public final class d
{
  float[] BKV;
  float[] BKW;
  String BLa;
  boolean CgB;
  int dYT;
  int height;
  List<a> rpx;
  int videoHeight;
  int videoWidth;
  int width;
  
  public d(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, List<a> paramList, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(237904);
    this.BKV = paramArrayOfFloat1;
    this.BKW = paramArrayOfFloat2;
    this.rpx = paramList;
    this.width = paramInt1;
    this.height = paramInt2;
    this.videoWidth = paramInt3;
    this.videoHeight = paramInt4;
    this.dYT = paramInt5;
    this.CgB = paramBoolean;
    this.BLa = paramString;
    AppMethodBeat.o(237904);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(237907);
    if (this != paramObject)
    {
      if ((paramObject instanceof d))
      {
        paramObject = (d)paramObject;
        if ((!p.j(this.BKV, paramObject.BKV)) || (!p.j(this.BKW, paramObject.BKW)) || (!p.j(this.rpx, paramObject.rpx)) || (this.width != paramObject.width) || (this.height != paramObject.height) || (this.videoWidth != paramObject.videoWidth) || (this.videoHeight != paramObject.videoHeight) || (this.dYT != paramObject.dYT) || (this.CgB != paramObject.CgB) || (!p.j(this.BLa, paramObject.BLa))) {}
      }
    }
    else
    {
      AppMethodBeat.o(237907);
      return true;
    }
    AppMethodBeat.o(237907);
    return false;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(237903);
    Object localObject1 = new StringBuilder("RetrieverData(drawingRect=");
    Object localObject2 = Arrays.toString(this.BKV);
    p.g(localObject2, "java.util.Arrays.toString(this)");
    localObject2 = ((StringBuilder)localObject1).append((String)localObject2).append(", validRect=");
    localObject1 = this.BKW;
    if (localObject1 != null)
    {
      localObject1 = Arrays.toString((float[])localObject1);
      p.g(localObject1, "java.util.Arrays.toString(this)");
    }
    for (;;)
    {
      localObject1 = (String)localObject1 + ", editorItems=" + this.rpx + ", width=" + this.width + ", height=" + this.height + ", videoWidth=" + this.videoWidth + ", videoHeight=" + this.videoHeight + ", rotate=" + this.dYT + ", isForMix=" + this.CgB + ", blurBgPath='" + this.BLa + "')";
      AppMethodBeat.o(237903);
      return localObject1;
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.b.d
 * JD-Core Version:    0.7.0.1
 */