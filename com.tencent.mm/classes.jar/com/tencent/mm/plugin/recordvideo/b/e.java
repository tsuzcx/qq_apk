package com.tencent.mm.plugin.recordvideo.b;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.k.e.a;
import com.tencent.mm.modelcontrol.VideoTransPara;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/config/ImageToVideoConfig;", "", "()V", "CheckRemuxFlag", "", "getCheckRemuxFlag", "()Z", "setCheckRemuxFlag", "(Z)V", "FrameRate", "", "getFrameRate", "()I", "setFrameRate", "(I)V", "Height", "getHeight", "setHeight", "IFrameInterval", "getIFrameInterval", "setIFrameInterval", "MaxSize", "RemuxFlag", "getRemuxFlag", "setRemuxFlag", "VIDEO_DURATION", "getVIDEO_DURATION", "Width", "getWidth", "setWidth", "maxSize", "getMaxSize", "getScaleSize", "Landroid/graphics/Point;", "origWidth", "origHeight", "setupWindowSize", "plugin-recordvideo_release"})
public final class e
{
  private static int Height = 0;
  private static int Width = 0;
  private static final int xxc = 15000;
  private static int xxd;
  private static int xxe;
  private static int xxf;
  private static boolean xxg;
  private static boolean xxh;
  public static final e xxi;
  
  static
  {
    AppMethodBeat.i(75372);
    xxi = new e();
    xxc = 15000;
    xxd = 15;
    xxe = 10;
    xxg = true;
    AppMethodBeat.o(75372);
  }
  
  public static int dFo()
  {
    return xxc;
  }
  
  public static boolean dFp()
  {
    return xxg;
  }
  
  public static boolean dFq()
  {
    return xxh;
  }
  
  public static int getFrameRate()
  {
    return xxd;
  }
  
  public static int getHeight()
  {
    return Height;
  }
  
  public static int getWidth()
  {
    return Width;
  }
  
  public static void pH(boolean paramBoolean)
  {
    xxg = paramBoolean;
  }
  
  public static void pI(boolean paramBoolean)
  {
    xxh = paramBoolean;
  }
  
  public final Point dFr()
  {
    try
    {
      AppMethodBeat.i(75371);
      if ((Width <= 0) || (Height <= 0))
      {
        localObject1 = com.tencent.mm.modelcontrol.d.aGQ();
        p.g(localObject1, "SubCoreVideoControl.getCore()");
        localObject1 = ((com.tencent.mm.modelcontrol.d)localObject1).aGU();
        int k = ((VideoTransPara)localObject1).width;
        e.a locala = com.tencent.mm.media.k.e.hoY;
        int j = e.a.nP(((VideoTransPara)localObject1).width);
        int i = j;
        if (j % 16 != 0) {
          i = com.tencent.mm.plugin.mmsight.d.Kg(j);
        }
        j = k;
        if (k % 16 != 0) {
          j = com.tencent.mm.plugin.mmsight.d.Kg(k);
        }
        Width = j;
        Height = i;
        xxf = Width;
      }
      Object localObject1 = new Point(Width, Height);
      AppMethodBeat.o(75371);
      return localObject1;
    }
    finally {}
  }
  
  public final int getMaxSize()
  {
    AppMethodBeat.i(75370);
    if (xxf <= 0) {
      dFr();
    }
    int i = xxf;
    AppMethodBeat.o(75370);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.b.e
 * JD-Core Version:    0.7.0.1
 */