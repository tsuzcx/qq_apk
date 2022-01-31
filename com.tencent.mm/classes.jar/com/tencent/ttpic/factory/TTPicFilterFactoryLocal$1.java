package com.tencent.ttpic.factory;

import android.graphics.Bitmap;
import com.tencent.a.a;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.BitmapUtils;
import com.tencent.util.e;
import com.tencent.view.g;
import java.io.File;

final class TTPicFilterFactoryLocal$1
  implements Runnable
{
  TTPicFilterFactoryLocal$1(int paramInt, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(81924);
    try
    {
      Bitmap localBitmap = TTPicFilterFactoryLocal.preloadBaseLUTImage();
      if (localBitmap == null)
      {
        AppMethodBeat.o(81924);
        return;
      }
      int i = g.at(localBitmap);
      h localh2 = new h();
      BaseFilter localBaseFilter = a.createFilter(this.val$filterId);
      localBaseFilter.ApplyGLSLFilter(true, localBitmap.getWidth(), localBitmap.getHeight());
      localBaseFilter.RenderProcess(i, localBitmap.getWidth(), localBitmap.getHeight(), -1, 0.0D, localh2);
      for (h localh1 = localh2; (localh1.btf != null) && (localh1.btf.texture[0] != 0); localh1 = localh1.btf) {}
      BitmapUtils.saveBitmap2PNG(g.aJ(localh1.texture[0], localBitmap.getWidth(), localBitmap.getHeight()), TTPicFilterFactoryLocal.LUT_DIR_ROOT + File.separator + this.val$filterName + ".png");
      e.iV(TTPicFilterFactoryLocal.LUT_DIR_ROOT + File.separator + this.val$filterName + ".png", TTPicFilterFactoryLocal.LUT_DIR_ROOT + File.separator + this.val$filterName + ".png2");
      new File(TTPicFilterFactoryLocal.LUT_DIR_ROOT + File.separator + this.val$filterName + ".png").delete();
      g.Tn(i);
      localh2.clear();
      localBaseFilter.ClearGLSL();
      AppMethodBeat.o(81924);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      AppMethodBeat.o(81924);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.ttpic.factory.TTPicFilterFactoryLocal.1
 * JD-Core Version:    0.7.0.1
 */