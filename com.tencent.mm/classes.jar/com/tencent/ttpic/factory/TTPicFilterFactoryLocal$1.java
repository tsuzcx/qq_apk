package com.tencent.ttpic.factory;

import android.graphics.Bitmap;
import com.tencent.a.a;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.h;
import com.tencent.ttpic.util.VideoBitmapUtil;
import com.tencent.util.c;
import com.tencent.view.f;
import java.io.File;

final class TTPicFilterFactoryLocal$1
  implements Runnable
{
  TTPicFilterFactoryLocal$1(int paramInt, String paramString) {}
  
  public final void run()
  {
    try
    {
      Bitmap localBitmap = TTPicFilterFactoryLocal.preloadBaseLUTImage();
      if (localBitmap == null) {
        return;
      }
      int i = f.ac(localBitmap);
      h localh2 = new h();
      BaseFilter localBaseFilter = a.dY(this.val$filterId);
      localBaseFilter.ApplyGLSLFilter(true, localBitmap.getWidth(), localBitmap.getHeight());
      localBaseFilter.RenderProcess(i, localBitmap.getWidth(), localBitmap.getHeight(), -1, 0.0D, localh2);
      for (h localh1 = localh2; (localh1.bcD != null) && (localh1.bcD.texture[0] != 0); localh1 = localh1.bcD) {}
      VideoBitmapUtil.saveBitmap2PNG(f.ax(localh1.texture[0], localBitmap.getWidth(), localBitmap.getHeight()), TTPicFilterFactoryLocal.access$000() + File.separator + this.val$filterName + ".png");
      c.gP(TTPicFilterFactoryLocal.access$000() + File.separator + this.val$filterName + ".png", TTPicFilterFactoryLocal.access$000() + File.separator + this.val$filterName + ".png2");
      new File(TTPicFilterFactoryLocal.access$000() + File.separator + this.val$filterName + ".png").delete();
      f.Ku(i);
      localh2.clear();
      localBaseFilter.ClearGLSL();
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.ttpic.factory.TTPicFilterFactoryLocal.1
 * JD-Core Version:    0.7.0.1
 */