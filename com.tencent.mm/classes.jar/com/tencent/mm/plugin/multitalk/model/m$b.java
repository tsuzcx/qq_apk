package com.tencent.mm.plugin.multitalk.model;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitalk/model/MultiTalkCameraManager$FrameObj;", "", "isBusy", "", "w", "", "h", "MediaFmt", "mirror", "angle", "outImg", "", "bmp", "Landroid/graphics/Bitmap;", "(ZIIIII[ILandroid/graphics/Bitmap;)V", "getMediaFmt", "()I", "setMediaFmt", "(I)V", "getAngle", "setAngle", "getBmp", "()Landroid/graphics/Bitmap;", "setBmp", "(Landroid/graphics/Bitmap;)V", "getH", "setH", "()Z", "setBusy", "(Z)V", "getMirror", "setMirror", "getOutImg", "()[I", "setOutImg", "([I)V", "getW", "setW", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "toString", "", "plugin-multitalk_release"})
public final class m$b
{
  private int Frp = 0;
  private int Frq = 0;
  private int[] Frr = null;
  private int h = 0;
  private boolean jTm = false;
  private int mirror = 0;
  private Bitmap tJN = null;
  private int w = 0;
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(200397);
    if (this != paramObject)
    {
      if ((paramObject instanceof b))
      {
        paramObject = (b)paramObject;
        if ((this.jTm != paramObject.jTm) || (this.w != paramObject.w) || (this.h != paramObject.h) || (this.Frp != paramObject.Frp) || (this.mirror != paramObject.mirror) || (this.Frq != paramObject.Frq) || (!p.h(this.Frr, paramObject.Frr)) || (!p.h(this.tJN, paramObject.tJN))) {}
      }
    }
    else
    {
      AppMethodBeat.o(200397);
      return true;
    }
    AppMethodBeat.o(200397);
    return false;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(200386);
    String str = "FrameObj(isBusy=" + this.jTm + ", w=" + this.w + ", h=" + this.h + ", MediaFmt=" + this.Frp + ", mirror=" + this.mirror + ", angle=" + this.Frq + ", outImg=" + Arrays.toString(this.Frr) + ", bmp=" + this.tJN + ")";
    AppMethodBeat.o(200386);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.m.b
 * JD-Core Version:    0.7.0.1
 */