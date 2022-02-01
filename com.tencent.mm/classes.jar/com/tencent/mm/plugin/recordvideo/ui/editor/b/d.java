package com.tencent.mm.plugin.recordvideo.ui.editor.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a;
import d.g.b.p;
import d.l;
import java.util.Arrays;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/RetrieverData;", "", "drawingRect", "", "validRect", "editorItems", "", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "width", "", "height", "videoWidth", "videoHeight", "rotate", "isForMix", "", "blurBgPath", "", "([F[FLjava/util/List;IIIIIZLjava/lang/String;)V", "getBlurBgPath", "()Ljava/lang/String;", "setBlurBgPath", "(Ljava/lang/String;)V", "getDrawingRect", "()[F", "setDrawingRect", "([F)V", "getEditorItems", "()Ljava/util/List;", "setEditorItems", "(Ljava/util/List;)V", "getHeight", "()I", "setHeight", "(I)V", "()Z", "setForMix", "(Z)V", "getRotate", "setRotate", "getValidRect", "setValidRect", "getVideoHeight", "setVideoHeight", "getVideoWidth", "setVideoWidth", "getWidth", "setWidth", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "plugin-recordvideo_release"})
public final class d
{
  int dGc;
  int height;
  List<a> pRU;
  int videoHeight;
  int videoWidth;
  int width;
  boolean xPJ;
  float[] xuU;
  float[] xuV;
  String xuZ;
  
  public d(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, List<a> paramList, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(200805);
    this.xuU = paramArrayOfFloat1;
    this.xuV = paramArrayOfFloat2;
    this.pRU = paramList;
    this.width = paramInt1;
    this.height = paramInt2;
    this.videoWidth = paramInt3;
    this.videoHeight = paramInt4;
    this.dGc = paramInt5;
    this.xPJ = paramBoolean;
    this.xuZ = paramString;
    AppMethodBeat.o(200805);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(200808);
    if (this != paramObject)
    {
      if ((paramObject instanceof d))
      {
        paramObject = (d)paramObject;
        if ((!p.i(this.xuU, paramObject.xuU)) || (!p.i(this.xuV, paramObject.xuV)) || (!p.i(this.pRU, paramObject.pRU)) || (this.width != paramObject.width) || (this.height != paramObject.height) || (this.videoWidth != paramObject.videoWidth) || (this.videoHeight != paramObject.videoHeight) || (this.dGc != paramObject.dGc) || (this.xPJ != paramObject.xPJ) || (!p.i(this.xuZ, paramObject.xuZ))) {}
      }
    }
    else
    {
      AppMethodBeat.o(200808);
      return true;
    }
    AppMethodBeat.o(200808);
    return false;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(200804);
    Object localObject1 = new StringBuilder("RetrieverData(drawingRect=");
    Object localObject2 = Arrays.toString(this.xuU);
    p.g(localObject2, "java.util.Arrays.toString(this)");
    localObject2 = ((StringBuilder)localObject1).append((String)localObject2).append(", validRect=");
    localObject1 = this.xuV;
    if (localObject1 != null)
    {
      localObject1 = Arrays.toString((float[])localObject1);
      p.g(localObject1, "java.util.Arrays.toString(this)");
    }
    for (;;)
    {
      localObject1 = (String)localObject1 + ", editorItems=" + this.pRU + ", width=" + this.width + ", height=" + this.height + ", videoWidth=" + this.videoWidth + ", videoHeight=" + this.videoHeight + ", rotate=" + this.dGc + ", isForMix=" + this.xPJ + ", blurBgPath='" + this.xuZ + "')";
      AppMethodBeat.o(200804);
      return localObject1;
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.b.d
 * JD-Core Version:    0.7.0.1
 */