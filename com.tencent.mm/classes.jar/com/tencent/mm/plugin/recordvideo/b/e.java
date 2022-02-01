package com.tencent.mm.plugin.recordvideo.b;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.k.f;
import com.tencent.mm.media.k.f.a;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.d;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/config/ImageToVideoConfig;", "", "()V", "CheckRemuxFlag", "", "getCheckRemuxFlag", "()Z", "setCheckRemuxFlag", "(Z)V", "FrameRate", "", "getFrameRate", "()I", "setFrameRate", "(I)V", "Height", "getHeight", "setHeight", "IFrameInterval", "getIFrameInterval", "setIFrameInterval", "MaxSize", "RemuxFlag", "getRemuxFlag", "setRemuxFlag", "VIDEO_DURATION", "getVIDEO_DURATION", "Width", "getWidth", "setWidth", "maxSize", "getMaxSize", "getScaleSize", "Landroid/graphics/Point;", "origWidth", "origHeight", "setupWindowSize", "plugin-recordvideo_release"})
public final class e
{
  private static final int BNg = 15000;
  private static int BNh;
  private static int BNi;
  private static int BNj;
  private static boolean BNk;
  private static boolean BNl;
  public static final e BNm;
  private static int Height;
  private static int Width;
  
  static
  {
    AppMethodBeat.i(75372);
    BNm = new e();
    BNg = 15000;
    BNh = 15;
    BNi = 10;
    BNk = true;
    AppMethodBeat.o(75372);
  }
  
  public static int eJs()
  {
    return BNg;
  }
  
  public static boolean eJt()
  {
    return BNk;
  }
  
  public static boolean eJu()
  {
    return BNl;
  }
  
  public static int getFrameRate()
  {
    return BNh;
  }
  
  public static int getHeight()
  {
    return Height;
  }
  
  public static int getWidth()
  {
    return Width;
  }
  
  public static void ta(boolean paramBoolean)
  {
    BNk = paramBoolean;
  }
  
  public static void tb(boolean paramBoolean)
  {
    BNl = paramBoolean;
  }
  
  public final Point eJv()
  {
    try
    {
      AppMethodBeat.i(75371);
      if ((Width <= 0) || (Height <= 0))
      {
        localObject1 = com.tencent.mm.modelcontrol.e.baZ();
        p.g(localObject1, "SubCoreVideoControl.getCore()");
        localObject1 = ((com.tencent.mm.modelcontrol.e)localObject1).bbd();
        int k = ((VideoTransPara)localObject1).width;
        f.a locala = f.ilG;
        int j = f.a.ro(((VideoTransPara)localObject1).width);
        int i = j;
        if (j % 16 != 0) {
          i = d.QH(j);
        }
        j = k;
        if (k % 16 != 0) {
          j = d.QH(k);
        }
        Width = j;
        Height = i;
        BNj = Width;
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
    if (BNj <= 0) {
      eJv();
    }
    int i = BNj;
    AppMethodBeat.o(75370);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.b.e
 * JD-Core Version:    0.7.0.1
 */