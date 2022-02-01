package com.tencent.mm.plugin.recordvideo.b;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.e.a;
import com.tencent.mm.modelcontrol.VideoTransPara;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/config/ImageToVideoConfig;", "", "()V", "CheckRemuxFlag", "", "getCheckRemuxFlag", "()Z", "setCheckRemuxFlag", "(Z)V", "FrameRate", "", "getFrameRate", "()I", "setFrameRate", "(I)V", "Height", "getHeight", "setHeight", "IFrameInterval", "getIFrameInterval", "setIFrameInterval", "MaxSize", "RemuxFlag", "getRemuxFlag", "setRemuxFlag", "VIDEO_DURATION", "getVIDEO_DURATION", "Width", "getWidth", "setWidth", "maxSize", "getMaxSize", "getScaleSize", "Landroid/graphics/Point;", "origWidth", "origHeight", "setupWindowSize", "plugin-recordvideo_release"})
public final class e
{
  private static int Height = 0;
  private static int Width = 0;
  private static final int vgA = 15000;
  private static int vgB;
  private static int vgC;
  private static int vgD;
  private static boolean vgE;
  private static boolean vgF;
  public static final e vgG;
  
  static
  {
    AppMethodBeat.i(75372);
    vgG = new e();
    vgA = 15000;
    vgB = 15;
    vgC = 10;
    vgE = true;
    AppMethodBeat.o(75372);
  }
  
  public static int dhm()
  {
    return vgA;
  }
  
  public static boolean dho()
  {
    return vgE;
  }
  
  public static boolean dhp()
  {
    return vgF;
  }
  
  public static int getFrameRate()
  {
    return vgB;
  }
  
  public static int getHeight()
  {
    return Height;
  }
  
  public static int getWidth()
  {
    return Width;
  }
  
  public static void oq(boolean paramBoolean)
  {
    vgE = paramBoolean;
  }
  
  public static void or(boolean paramBoolean)
  {
    vgF = paramBoolean;
  }
  
  public final Point dhq()
  {
    try
    {
      AppMethodBeat.i(75371);
      if ((Width <= 0) || (Height <= 0))
      {
        localObject1 = com.tencent.mm.modelcontrol.d.awT();
        k.g(localObject1, "SubCoreVideoControl.getCore()");
        localObject1 = ((com.tencent.mm.modelcontrol.d)localObject1).awX();
        int k = ((VideoTransPara)localObject1).width;
        e.a locala = com.tencent.mm.media.j.e.gwv;
        int j = e.a.mC(((VideoTransPara)localObject1).width);
        int i = j;
        if (j % 16 != 0) {
          i = com.tencent.mm.plugin.mmsight.d.GN(j);
        }
        j = k;
        if (k % 16 != 0) {
          j = com.tencent.mm.plugin.mmsight.d.GN(k);
        }
        Width = j;
        Height = i;
        vgD = Width;
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
    if (vgD <= 0) {
      dhq();
    }
    int i = vgD;
    AppMethodBeat.o(75370);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.b.e
 * JD-Core Version:    0.7.0.1
 */