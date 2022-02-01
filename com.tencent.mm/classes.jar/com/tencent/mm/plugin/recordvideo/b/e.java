package com.tencent.mm.plugin.recordvideo.b;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.k.e.a;
import com.tencent.mm.modelcontrol.VideoTransPara;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/config/ImageToVideoConfig;", "", "()V", "CheckRemuxFlag", "", "getCheckRemuxFlag", "()Z", "setCheckRemuxFlag", "(Z)V", "FrameRate", "", "getFrameRate", "()I", "setFrameRate", "(I)V", "Height", "getHeight", "setHeight", "IFrameInterval", "getIFrameInterval", "setIFrameInterval", "MaxSize", "RemuxFlag", "getRemuxFlag", "setRemuxFlag", "VIDEO_DURATION", "getVIDEO_DURATION", "Width", "getWidth", "setWidth", "maxSize", "getMaxSize", "getScaleSize", "Landroid/graphics/Point;", "origWidth", "origHeight", "setupWindowSize", "plugin-recordvideo_release"})
public final class e
{
  private static int Height = 0;
  private static int Width = 0;
  private static final int xMZ = 15000;
  private static int xNa;
  private static int xNb;
  private static int xNc;
  private static boolean xNd;
  private static boolean xNe;
  public static final e xNf;
  
  static
  {
    AppMethodBeat.i(75372);
    xNf = new e();
    xMZ = 15000;
    xNa = 15;
    xNb = 10;
    xNd = true;
    AppMethodBeat.o(75372);
  }
  
  public static int dIF()
  {
    return xMZ;
  }
  
  public static boolean dIG()
  {
    return xNd;
  }
  
  public static boolean dIH()
  {
    return xNe;
  }
  
  public static int getFrameRate()
  {
    return xNa;
  }
  
  public static int getHeight()
  {
    return Height;
  }
  
  public static int getWidth()
  {
    return Width;
  }
  
  public static void pP(boolean paramBoolean)
  {
    xNd = paramBoolean;
  }
  
  public static void pQ(boolean paramBoolean)
  {
    xNe = paramBoolean;
  }
  
  public final Point dII()
  {
    try
    {
      AppMethodBeat.i(75371);
      if ((Width <= 0) || (Height <= 0))
      {
        localObject1 = com.tencent.mm.modelcontrol.d.aHh();
        p.g(localObject1, "SubCoreVideoControl.getCore()");
        localObject1 = ((com.tencent.mm.modelcontrol.d)localObject1).aHl();
        int k = ((VideoTransPara)localObject1).width;
        e.a locala = com.tencent.mm.media.k.e.hrM;
        int j = e.a.nS(((VideoTransPara)localObject1).width);
        int i = j;
        if (j % 16 != 0) {
          i = com.tencent.mm.plugin.mmsight.d.KG(j);
        }
        j = k;
        if (k % 16 != 0) {
          j = com.tencent.mm.plugin.mmsight.d.KG(k);
        }
        Width = j;
        Height = i;
        xNc = Width;
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
    if (xNc <= 0) {
      dII();
    }
    int i = xNc;
    AppMethodBeat.o(75370);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.b.e
 * JD-Core Version:    0.7.0.1
 */