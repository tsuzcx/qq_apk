package com.tencent.mm.plugin.recordvideo.c;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.util.h;
import com.tencent.mm.media.util.h.a;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelcontrol.e;
import com.tencent.mm.plugin.mmsight.d;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/config/ImageToVideoConfig;", "", "()V", "CheckRemuxFlag", "", "getCheckRemuxFlag", "()Z", "setCheckRemuxFlag", "(Z)V", "FrameRate", "", "getFrameRate", "()I", "setFrameRate", "(I)V", "Height", "getHeight", "setHeight", "IFrameInterval", "getIFrameInterval", "setIFrameInterval", "MaxSize", "RemuxFlag", "getRemuxFlag", "setRemuxFlag", "VIDEO_DURATION", "getVIDEO_DURATION", "Width", "getWidth", "setWidth", "maxSize", "getMaxSize", "getScaleSize", "Landroid/graphics/Point;", "origWidth", "origHeight", "setupWindowSize", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
{
  private static int Height;
  public static final f NGM;
  private static final int NGN;
  private static int NGO;
  private static int NGP;
  private static int NGQ;
  private static boolean NGR;
  private static boolean NGS;
  private static int Width;
  
  static
  {
    AppMethodBeat.i(75372);
    NGM = new f();
    NGN = 15000;
    NGO = 15;
    NGP = 10;
    NGR = true;
    AppMethodBeat.o(75372);
  }
  
  public static void AV(boolean paramBoolean)
  {
    NGR = paramBoolean;
  }
  
  public static void AW(boolean paramBoolean)
  {
    NGS = paramBoolean;
  }
  
  public static int gHp()
  {
    return NGN;
  }
  
  public static boolean gHq()
  {
    return NGR;
  }
  
  public static boolean gHr()
  {
    return NGS;
  }
  
  public static int getFrameRate()
  {
    return NGO;
  }
  
  public static int getHeight()
  {
    return Height;
  }
  
  public static int getWidth()
  {
    return Width;
  }
  
  public final int gHs()
  {
    AppMethodBeat.i(75370);
    if (NGQ <= 0) {
      gHt();
    }
    int i = NGQ;
    AppMethodBeat.o(75370);
    return i;
  }
  
  public final Point gHt()
  {
    try
    {
      AppMethodBeat.i(75371);
      if ((Width <= 0) || (Height <= 0))
      {
        localObject1 = e.bIg().bIl();
        int k = ((VideoTransPara)localObject1).width;
        h.a locala = h.nFI;
        int j = h.a.uf(((VideoTransPara)localObject1).width);
        int i = j;
        if (j % 16 != 0) {
          i = d.aaX(j);
        }
        j = k;
        if (k % 16 != 0) {
          j = d.aaX(k);
        }
        Width = j;
        Height = i;
        NGQ = Width;
      }
      Object localObject1 = new Point(Width, Height);
      AppMethodBeat.o(75371);
      return localObject1;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.c.f
 * JD-Core Version:    0.7.0.1
 */