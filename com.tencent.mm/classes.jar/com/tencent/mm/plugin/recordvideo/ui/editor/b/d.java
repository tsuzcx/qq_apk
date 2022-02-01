package com.tencent.mm.plugin.recordvideo.ui.editor.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/RetrieverData;", "", "drawingRect", "", "validRect", "editorItems", "", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "width", "", "height", "videoWidth", "videoHeight", "rotate", "isForMix", "", "blurBgPath", "", "([F[FLjava/util/List;IIIIIZLjava/lang/String;)V", "getBlurBgPath", "()Ljava/lang/String;", "setBlurBgPath", "(Ljava/lang/String;)V", "getDrawingRect", "()[F", "setDrawingRect", "([F)V", "getEditorItems", "()Ljava/util/List;", "setEditorItems", "(Ljava/util/List;)V", "getHeight", "()I", "setHeight", "(I)V", "()Z", "setForMix", "(Z)V", "getRotate", "setRotate", "getValidRect", "setValidRect", "getVideoHeight", "setVideoHeight", "getVideoWidth", "setVideoWidth", "getWidth", "setWidth", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  float[] NEA;
  float[] NEB;
  String NEF;
  boolean NZN;
  int hYK;
  int height;
  int videoHeight;
  int videoWidth;
  int width;
  List<a> yhJ;
  
  public d(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, List<a> paramList, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(279954);
    this.NEA = paramArrayOfFloat1;
    this.NEB = paramArrayOfFloat2;
    this.yhJ = paramList;
    this.width = paramInt1;
    this.height = paramInt2;
    this.videoWidth = paramInt3;
    this.videoHeight = paramInt4;
    this.hYK = paramInt5;
    this.NZN = paramBoolean;
    this.NEF = paramString;
    AppMethodBeat.o(279954);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(279977);
    if (this == paramObject)
    {
      AppMethodBeat.o(279977);
      return true;
    }
    if (!(paramObject instanceof d))
    {
      AppMethodBeat.o(279977);
      return false;
    }
    paramObject = (d)paramObject;
    if (!s.p(this.NEA, paramObject.NEA))
    {
      AppMethodBeat.o(279977);
      return false;
    }
    if (!s.p(this.NEB, paramObject.NEB))
    {
      AppMethodBeat.o(279977);
      return false;
    }
    if (!s.p(this.yhJ, paramObject.yhJ))
    {
      AppMethodBeat.o(279977);
      return false;
    }
    if (this.width != paramObject.width)
    {
      AppMethodBeat.o(279977);
      return false;
    }
    if (this.height != paramObject.height)
    {
      AppMethodBeat.o(279977);
      return false;
    }
    if (this.videoWidth != paramObject.videoWidth)
    {
      AppMethodBeat.o(279977);
      return false;
    }
    if (this.videoHeight != paramObject.videoHeight)
    {
      AppMethodBeat.o(279977);
      return false;
    }
    if (this.hYK != paramObject.hYK)
    {
      AppMethodBeat.o(279977);
      return false;
    }
    if (this.NZN != paramObject.NZN)
    {
      AppMethodBeat.o(279977);
      return false;
    }
    if (!s.p(this.NEF, paramObject.NEF))
    {
      AppMethodBeat.o(279977);
      return false;
    }
    AppMethodBeat.o(279977);
    return true;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(279967);
    Object localObject1 = new StringBuilder("RetrieverData(drawingRect=");
    Object localObject2 = Arrays.toString(this.NEA);
    s.s(localObject2, "java.util.Arrays.toString(this)");
    localObject2 = ((StringBuilder)localObject1).append((String)localObject2).append(", validRect=");
    localObject1 = this.NEB;
    if (localObject1 == null) {
      localObject1 = null;
    }
    for (;;)
    {
      localObject1 = localObject1 + ", editorItems=" + this.yhJ + ", width=" + this.width + ", height=" + this.height + ", videoWidth=" + this.videoWidth + ", videoHeight=" + this.videoHeight + ", rotate=" + this.hYK + ", isForMix=" + this.NZN + ", blurBgPath='" + this.NEF + "')";
      AppMethodBeat.o(279967);
      return localObject1;
      localObject1 = Arrays.toString((float[])localObject1);
      s.s(localObject1, "java.util.Arrays.toString(this)");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.b.d
 * JD-Core Version:    0.7.0.1
 */