package com.tencent.ttpic.thread;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.BitmapUtils;
import com.tencent.ttpic.fabby.FabbyManager;
import com.tencent.ttpic.filter.ExpFilter;
import com.tencent.ttpic.gles.GLSegSharedData;
import com.tencent.ttpic.gles.GlUtil;
import com.tencent.ttpic.gles.SegmentDataPipe;
import com.tencent.ttpic.util.BenchUtil;
import com.tencent.view.g;

class SegmentGLThread$2
  implements Runnable
{
  SegmentGLThread$2(SegmentGLThread paramSegmentGLThread, boolean paramBoolean, h paramh) {}
  
  public void run()
  {
    AppMethodBeat.i(83774);
    if (SegmentGLThread.access$1400(this.this$0) == null)
    {
      AppMethodBeat.o(83774);
      return;
    }
    SegmentDataPipe localSegmentDataPipe = SegmentGLThread.access$700(this.this$0).getFreeTexturePileMakeBusy();
    if (localSegmentDataPipe == null)
    {
      AppMethodBeat.o(83774);
      return;
    }
    int i;
    if (this.val$horizon)
    {
      i = SegmentGLThread.access$1500();
      if (!this.val$horizon) {
        break label294;
      }
    }
    label294:
    for (int j = SegmentGLThread.access$1600();; j = SegmentGLThread.access$1500())
    {
      localSegmentDataPipe.mTimestamp = System.currentTimeMillis();
      BenchUtil.benchStart("[showPreview][FABBY] segment");
      SegmentGLThread.access$200(this.this$0).RenderProcess(this.val$inputFrame.texture[0], this.val$inputFrame.width, this.val$inputFrame.height, -1, 0.0D, localSegmentDataPipe.mTexFrame);
      SegmentGLThread.access$1002(this.this$0, localSegmentDataPipe.mTexFrame);
      localSegmentDataPipe.mMaskFrame.a(-1, SegmentGLThread.access$1000(this.this$0).width, SegmentGLThread.access$1000(this.this$0).height, 0.0D);
      if ((!FabbyManager.getInstance().isGPUSupportOpenCL()) || (SegmentGLThread.access$1700(this.this$0))) {
        break label301;
      }
      if (FabbyManager.getInstance().segmentOnTexture(SegmentGLThread.access$1000(this.this$0).texture[0], localSegmentDataPipe.mMaskFrame.texture[0], SegmentGLThread.access$1000(this.this$0).width, SegmentGLThread.access$1000(this.this$0).height, false, i, j) != 0) {
        SegmentGLThread.access$1702(this.this$0, true);
      }
      localSegmentDataPipe.makeDataReady();
      SegmentGLThread.access$700(this.this$0).makeBrotherTextureFree(localSegmentDataPipe);
      SegmentGLThread.access$1400(this.this$0).onDataReady(localSegmentDataPipe);
      BenchUtil.benchEnd("[showPreview][FABBY] segment");
      AppMethodBeat.o(83774);
      return;
      i = SegmentGLThread.access$1600();
      break;
    }
    label301:
    SegmentGLThread.access$200(this.this$0).RenderProcess(SegmentGLThread.access$1000(this.this$0).texture[0], i * 16, j * 16, -1, 0.0D, SegmentGLThread.access$900(this.this$0));
    if (!BitmapUtils.isLegal(SegmentGLThread.access$1800(this.this$0))) {
      SegmentGLThread.access$1802(this.this$0, Bitmap.createBitmap(SegmentGLThread.access$1600() * 16, SegmentGLThread.access$1500() * 16, Bitmap.Config.ARGB_8888));
    }
    if (!BitmapUtils.isLegal(SegmentGLThread.access$1900(this.this$0))) {
      SegmentGLThread.access$1902(this.this$0, Bitmap.createBitmap(SegmentGLThread.access$1500() * 16, SegmentGLThread.access$1600() * 16, Bitmap.Config.ARGB_8888));
    }
    if (!BitmapUtils.isLegal(SegmentGLThread.access$2000(this.this$0))) {
      SegmentGLThread.access$2002(this.this$0, Bitmap.createBitmap(SegmentGLThread.access$1600(), SegmentGLThread.access$1500(), Bitmap.Config.ARGB_8888));
    }
    if (!BitmapUtils.isLegal(SegmentGLThread.access$2100(this.this$0))) {
      SegmentGLThread.access$2102(this.this$0, Bitmap.createBitmap(SegmentGLThread.access$1500(), SegmentGLThread.access$1600(), Bitmap.Config.ARGB_8888));
    }
    Bitmap localBitmap1;
    if (this.val$horizon)
    {
      localBitmap1 = SegmentGLThread.access$1900(this.this$0);
      label499:
      if (!this.val$horizon) {
        break label666;
      }
    }
    label666:
    for (Bitmap localBitmap2 = SegmentGLThread.access$2100(this.this$0);; localBitmap2 = SegmentGLThread.access$2000(this.this$0))
    {
      g.a(SegmentGLThread.access$900(this.this$0).texture[0], i * 16, j * 16, localBitmap1);
      FabbyManager.getInstance().segmentOnBitmap(localBitmap1, localBitmap2, i * 16, j * 16, i, j);
      GlUtil.loadTexture(SegmentGLThread.access$1100(this.this$0)[0], localBitmap2);
      SegmentGLThread.access$500(this.this$0).updateParam(SegmentGLThread.access$1000(this.this$0).width, SegmentGLThread.access$1000(this.this$0).height, i, j);
      SegmentGLThread.access$500(this.this$0).RenderProcess(SegmentGLThread.access$1100(this.this$0)[0], SegmentGLThread.access$1000(this.this$0).width, SegmentGLThread.access$1000(this.this$0).height, -1, 0.0D, localSegmentDataPipe.mMaskFrame);
      break;
      localBitmap1 = SegmentGLThread.access$1800(this.this$0);
      break label499;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.ttpic.thread.SegmentGLThread.2
 * JD-Core Version:    0.7.0.1
 */