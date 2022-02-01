package com.tencent.mm.plugin.recordvideo.ui.editor.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a;
import d.g.b.p;
import d.l;
import java.util.Arrays;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/RetrieverData;", "", "drawingRect", "", "validRect", "editorItems", "", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "width", "", "height", "videoWidth", "videoHeight", "rotate", "isForMix", "", "blurBgPath", "", "([F[FLjava/util/List;IIIIIZLjava/lang/String;)V", "getBlurBgPath", "()Ljava/lang/String;", "setBlurBgPath", "(Ljava/lang/String;)V", "getDrawingRect", "()[F", "setDrawingRect", "([F)V", "getEditorItems", "()Ljava/util/List;", "setEditorItems", "(Ljava/util/List;)V", "getHeight", "()I", "setHeight", "(I)V", "()Z", "setForMix", "(Z)V", "getRotate", "setRotate", "getValidRect", "setValidRect", "getVideoHeight", "setVideoHeight", "getVideoWidth", "setVideoWidth", "getWidth", "setWidth", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "plugin-recordvideo_release"})
public final class d
{
  int dHi;
  int height;
  List<a> pYz;
  int videoHeight;
  int videoWidth;
  int width;
  float[] xKR;
  float[] xKS;
  String xKW;
  boolean yfC;
  
  public d(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, List<a> paramList, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(207063);
    this.xKR = paramArrayOfFloat1;
    this.xKS = paramArrayOfFloat2;
    this.pYz = paramList;
    this.width = paramInt1;
    this.height = paramInt2;
    this.videoWidth = paramInt3;
    this.videoHeight = paramInt4;
    this.dHi = paramInt5;
    this.yfC = paramBoolean;
    this.xKW = paramString;
    AppMethodBeat.o(207063);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(207066);
    if (this != paramObject)
    {
      if ((paramObject instanceof d))
      {
        paramObject = (d)paramObject;
        if ((!p.i(this.xKR, paramObject.xKR)) || (!p.i(this.xKS, paramObject.xKS)) || (!p.i(this.pYz, paramObject.pYz)) || (this.width != paramObject.width) || (this.height != paramObject.height) || (this.videoWidth != paramObject.videoWidth) || (this.videoHeight != paramObject.videoHeight) || (this.dHi != paramObject.dHi) || (this.yfC != paramObject.yfC) || (!p.i(this.xKW, paramObject.xKW))) {}
      }
    }
    else
    {
      AppMethodBeat.o(207066);
      return true;
    }
    AppMethodBeat.o(207066);
    return false;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(207062);
    Object localObject1 = new StringBuilder("RetrieverData(drawingRect=");
    Object localObject2 = Arrays.toString(this.xKR);
    p.g(localObject2, "java.util.Arrays.toString(this)");
    localObject2 = ((StringBuilder)localObject1).append((String)localObject2).append(", validRect=");
    localObject1 = this.xKS;
    if (localObject1 != null)
    {
      localObject1 = Arrays.toString((float[])localObject1);
      p.g(localObject1, "java.util.Arrays.toString(this)");
    }
    for (;;)
    {
      localObject1 = (String)localObject1 + ", editorItems=" + this.pYz + ", width=" + this.width + ", height=" + this.height + ", videoWidth=" + this.videoWidth + ", videoHeight=" + this.videoHeight + ", rotate=" + this.dHi + ", isForMix=" + this.yfC + ", blurBgPath='" + this.xKW + "')";
      AppMethodBeat.o(207062);
      return localObject1;
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.b.d
 * JD-Core Version:    0.7.0.1
 */