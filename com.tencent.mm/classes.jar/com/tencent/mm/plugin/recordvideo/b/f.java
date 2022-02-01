package com.tencent.mm.plugin.recordvideo.b;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.k.h;
import com.tencent.mm.media.k.h.a;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelcontrol.e;
import com.tencent.mm.plugin.mmsight.d;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/config/ImageToVideoConfig;", "", "()V", "CheckRemuxFlag", "", "getCheckRemuxFlag", "()Z", "setCheckRemuxFlag", "(Z)V", "FrameRate", "", "getFrameRate", "()I", "setFrameRate", "(I)V", "Height", "getHeight", "setHeight", "IFrameInterval", "getIFrameInterval", "setIFrameInterval", "MaxSize", "RemuxFlag", "getRemuxFlag", "setRemuxFlag", "VIDEO_DURATION", "getVIDEO_DURATION", "Width", "getWidth", "setWidth", "maxSize", "getMaxSize", "getScaleSize", "Landroid/graphics/Point;", "origWidth", "origHeight", "setupWindowSize", "plugin-recordvideo_release"})
public final class f
{
  private static final int HJO = 15000;
  private static int HJP;
  private static int HJQ;
  private static int HJR;
  private static boolean HJS;
  private static boolean HJT;
  public static final f HJU;
  private static int Height;
  private static int Width;
  
  static
  {
    AppMethodBeat.i(75372);
    HJU = new f();
    HJO = 15000;
    HJP = 15;
    HJQ = 10;
    HJS = true;
    AppMethodBeat.o(75372);
  }
  
  public static int fvB()
  {
    return HJO;
  }
  
  public static boolean fvC()
  {
    return HJS;
  }
  
  public static boolean fvD()
  {
    return HJT;
  }
  
  public static int getFrameRate()
  {
    return HJP;
  }
  
  public static int getHeight()
  {
    return Height;
  }
  
  public static int getWidth()
  {
    return Width;
  }
  
  public static void ww(boolean paramBoolean)
  {
    HJS = paramBoolean;
  }
  
  public static void wx(boolean paramBoolean)
  {
    HJT = paramBoolean;
  }
  
  public final int fvE()
  {
    AppMethodBeat.i(75370);
    if (HJR <= 0) {
      fvF();
    }
    int i = HJR;
    AppMethodBeat.o(75370);
    return i;
  }
  
  public final Point fvF()
  {
    try
    {
      AppMethodBeat.i(75371);
      if ((Width <= 0) || (Height <= 0))
      {
        localObject1 = e.bkp();
        p.j(localObject1, "SubCoreVideoControl.getCore()");
        localObject1 = ((e)localObject1).bkt();
        int k = ((VideoTransPara)localObject1).width;
        h.a locala = h.laG;
        int j = h.a.ug(((VideoTransPara)localObject1).width);
        int i = j;
        if (j % 16 != 0) {
          i = d.WV(j);
        }
        j = k;
        if (k % 16 != 0) {
          j = d.WV(k);
        }
        Width = j;
        Height = i;
        HJR = Width;
      }
      Object localObject1 = new Point(Width, Height);
      AppMethodBeat.o(75371);
      return localObject1;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.b.f
 * JD-Core Version:    0.7.0.1
 */