package com.tencent.ttpic.filter;

import android.graphics.Bitmap;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.BitmapUtils;
import com.tencent.ttpic.gles.GlUtil;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.view.g;

public class ImageOffsetGuideFilter
  extends BaseFilter
{
  private float xOffset = 0.0F;
  
  public ImageOffsetGuideFilter()
  {
    super(GLSLRender.btg);
  }
  
  private void updatePosition()
  {
    AppMethodBeat.i(82609);
    float f1 = this.xOffset - 0.16F;
    float f2 = this.xOffset + 0.16F;
    setPositions(new float[] { f1, -1.0F, f1, 1.0F, f2, 1.0F, f2, -1.0F });
    AppMethodBeat.o(82609);
  }
  
  public void RenderProcess(int paramInt1, int paramInt2, int paramInt3, int paramInt4, double paramDouble, h paramh)
  {
    AppMethodBeat.i(82610);
    if ((this.xOffset >= 0.0F) || (this.xOffset <= -1.0F))
    {
      AppMethodBeat.o(82610);
      return;
    }
    updatePosition();
    GlUtil.setBlendMode(true);
    super.RenderProcess(paramInt1, paramInt2, paramInt3, paramInt4, paramDouble, paramh);
    GlUtil.setBlendMode(false);
    AppMethodBeat.o(82610);
  }
  
  public void initFrame(h paramh)
  {
    AppMethodBeat.i(82608);
    Bitmap localBitmap = BitmapUtils.decodeSampleBitmapFromAssets(VideoGlobalContext.getContext(), "raw/guide_line.png", 1);
    int i = g.at(localBitmap);
    paramh.texture[0] = i;
    paramh.width = localBitmap.getWidth();
    paramh.height = localBitmap.getHeight();
    AppMethodBeat.o(82608);
  }
  
  public void setxOffset(float paramFloat)
  {
    this.xOffset = (-paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.ttpic.filter.ImageOffsetGuideFilter
 * JD-Core Version:    0.7.0.1
 */