package com.tencent.mm.plugin.mmsight.segment;

import android.content.Context;
import android.graphics.Matrix;
import android.view.View;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.MMTextureView;

final class VideoSegmentUI$a$1
  extends MMTextureView
{
  VideoSegmentUI$a$1(VideoSegmentUI.a parama, Context paramContext)
  {
    super(paramContext);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    y.d("MicroMsg.VideoSegmentUI", "onMeasure video size[%d, %d, %d] spec[%d, %d]", new Object[] { Integer.valueOf(VideoSegmentUI.a.a(this.mnH)), Integer.valueOf(VideoSegmentUI.a.b(this.mnH)), Integer.valueOf(VideoSegmentUI.a.c(this.mnH)), Integer.valueOf(View.getDefaultSize(1, paramInt1)), Integer.valueOf(View.getDefaultSize(1, paramInt2)) });
    if ((VideoSegmentUI.a.c(this.mnH) == 90) || (VideoSegmentUI.a.c(this.mnH) == 270))
    {
      Matrix localMatrix = new Matrix();
      localMatrix.set(getMatrix());
      int i = View.getDefaultSize(1, paramInt1);
      int j = View.getDefaultSize(1, paramInt2);
      float f1 = i / 2.0F;
      float f2 = j / 2.0F;
      float f3 = j / i;
      localMatrix.postRotate(VideoSegmentUI.a.c(this.mnH), f1, f2);
      localMatrix.postScale(1.0F / f3, f3, f1, f2);
      setTransform(localMatrix);
      y.i("MicroMsg.VideoSegmentUI", "rotate transform mDegrees[%d] screenSize[%d, %d]", new Object[] { Integer.valueOf(VideoSegmentUI.a.c(this.mnH)), Integer.valueOf(i), Integer.valueOf(j) });
    }
    super.onMeasure(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.VideoSegmentUI.a.1
 * JD-Core Version:    0.7.0.1
 */