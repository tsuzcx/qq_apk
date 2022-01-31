package com.tencent.mm.plugin.story.image2video;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.i.d.a;
import com.tencent.mm.modelcontrol.VideoTransPara;

public final class d
{
  public static int Height = 0;
  public static int Width;
  public static int ssU = 15;
  public static int ssV = 10;
  private static int ssW = 0;
  public static boolean ssX = true;
  public static boolean ssY = false;
  
  static
  {
    Width = 0;
  }
  
  public static Point czT()
  {
    try
    {
      AppMethodBeat.i(150937);
      if ((Width <= 0) || (Height <= 0))
      {
        localObject1 = com.tencent.mm.plugin.story.proxy.d.sDB;
        com.tencent.mm.plugin.story.proxy.d.cCz();
        localObject1 = com.tencent.mm.plugin.story.proxy.d.getVideoPara();
        int k = ((VideoTransPara)localObject1).width;
        d.a locala = com.tencent.mm.media.i.d.eZG;
        int j = d.a.ka(((VideoTransPara)localObject1).width);
        int i = j;
        if (j % 16 != 0) {
          i = com.tencent.mm.plugin.mmsight.d.zn(j);
        }
        j = k;
        if (k % 16 != 0) {
          j = com.tencent.mm.plugin.mmsight.d.zn(k);
        }
        Width = j;
        Height = i;
        ssW = Width;
      }
      Object localObject1 = new Point(Width, Height);
      AppMethodBeat.o(150937);
      return localObject1;
    }
    finally {}
  }
  
  public static Point fX(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(150939);
    int i = getMaxSize();
    Point localPoint = new Point(paramInt1, paramInt2);
    float f;
    if (paramInt1 > paramInt2) {
      if (paramInt2 > i)
      {
        localPoint.y = i;
        f = paramInt1;
        localPoint.x = ((int)(i / paramInt2 * f));
      }
    }
    for (;;)
    {
      AppMethodBeat.o(150939);
      return localPoint;
      if (paramInt1 > i)
      {
        localPoint.x = i;
        f = paramInt2;
        localPoint.y = ((int)(i * f / paramInt1));
      }
    }
  }
  
  public static int getMaxSize()
  {
    AppMethodBeat.i(150938);
    if (ssW <= 0) {
      czT();
    }
    int i = ssW;
    AppMethodBeat.o(150938);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.story.image2video.d
 * JD-Core Version:    0.7.0.1
 */