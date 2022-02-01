package com.tencent.mm.plugin.recordvideo.b;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.e.a;
import com.tencent.mm.modelcontrol.VideoTransPara;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/config/ImageToVideoConfig;", "", "()V", "CheckRemuxFlag", "", "getCheckRemuxFlag", "()Z", "setCheckRemuxFlag", "(Z)V", "FrameRate", "", "getFrameRate", "()I", "setFrameRate", "(I)V", "Height", "getHeight", "setHeight", "IFrameInterval", "getIFrameInterval", "setIFrameInterval", "MaxSize", "RemuxFlag", "getRemuxFlag", "setRemuxFlag", "VIDEO_DURATION", "getVIDEO_DURATION", "Width", "getWidth", "setWidth", "maxSize", "getMaxSize", "getScaleSize", "Landroid/graphics/Point;", "origWidth", "origHeight", "setupWindowSize", "plugin-recordvideo_release"})
public final class e
{
  private static int Height = 0;
  private static int Width = 0;
  private static final int wpm = 15000;
  private static int wpn;
  private static int wpo;
  private static int wpp;
  private static boolean wpq;
  private static boolean wpr;
  public static final e wps;
  
  static
  {
    AppMethodBeat.i(75372);
    wps = new e();
    wpm = 15000;
    wpn = 15;
    wpo = 10;
    wpq = true;
    AppMethodBeat.o(75372);
  }
  
  public static int duT()
  {
    return wpm;
  }
  
  public static boolean duU()
  {
    return wpq;
  }
  
  public static boolean duV()
  {
    return wpr;
  }
  
  public static int getFrameRate()
  {
    return wpn;
  }
  
  public static int getHeight()
  {
    return Height;
  }
  
  public static int getWidth()
  {
    return Width;
  }
  
  public static void pk(boolean paramBoolean)
  {
    wpq = paramBoolean;
  }
  
  public static void pl(boolean paramBoolean)
  {
    wpr = paramBoolean;
  }
  
  public final Point duW()
  {
    try
    {
      AppMethodBeat.i(75371);
      if ((Width <= 0) || (Height <= 0))
      {
        localObject1 = com.tencent.mm.modelcontrol.d.aDL();
        k.g(localObject1, "SubCoreVideoControl.getCore()");
        localObject1 = ((com.tencent.mm.modelcontrol.d)localObject1).aDP();
        int k = ((VideoTransPara)localObject1).width;
        e.a locala = com.tencent.mm.media.j.e.gWS;
        int j = e.a.nq(((VideoTransPara)localObject1).width);
        int i = j;
        if (j % 16 != 0) {
          i = com.tencent.mm.plugin.mmsight.d.IJ(j);
        }
        j = k;
        if (k % 16 != 0) {
          j = com.tencent.mm.plugin.mmsight.d.IJ(k);
        }
        Width = j;
        Height = i;
        wpp = Width;
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
    if (wpp <= 0) {
      duW();
    }
    int i = wpp;
    AppMethodBeat.o(75370);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.b.e
 * JD-Core Version:    0.7.0.1
 */