package com.tencent.ttpic.thread;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.h;
import com.tencent.ttpic.filter.ExpFilter;
import com.tencent.ttpic.gles.GLSegSharedData;
import com.tencent.ttpic.gles.GlUtil;
import com.tencent.ttpic.gles.OnSegDataReadyListener;
import com.tencent.ttpic.gles.SegmentDataPipe;
import com.tencent.ttpic.util.BenchUtil;
import com.tencent.ttpic.util.FabbyManager;
import com.tencent.ttpic.util.VideoBitmapUtil;
import com.tencent.view.f;

class SegmentGLThread$2
  implements Runnable
{
  SegmentGLThread$2(SegmentGLThread paramSegmentGLThread, boolean paramBoolean, h paramh) {}
  
  public void run()
  {
    if (SegmentGLThread.access$1300(this.this$0) == null) {}
    SegmentDataPipe localSegmentDataPipe;
    do
    {
      return;
      localSegmentDataPipe = SegmentGLThread.access$700(this.this$0).getFreeTexturePileMakeBusy();
    } while (localSegmentDataPipe == null);
    int i;
    int j;
    label49:
    Bitmap localBitmap1;
    if (this.val$horizon)
    {
      i = SegmentGLThread.access$1400();
      if (!this.val$horizon) {
        break label677;
      }
      j = 16;
      localSegmentDataPipe.mTimestamp = System.currentTimeMillis();
      BenchUtil.benchStart("[showPreview][FABBY] segment");
      SegmentGLThread.access$200(this.this$0).RenderProcess(this.val$inputFrame.texture[0], this.val$inputFrame.width, this.val$inputFrame.height, -1, 0.0D, localSegmentDataPipe.mTexFrame);
      SegmentGLThread.access$1002(this.this$0, localSegmentDataPipe.mTexFrame);
      localSegmentDataPipe.mMaskFrame.a(-1, SegmentGLThread.access$1000(this.this$0).width, SegmentGLThread.access$1000(this.this$0).height, 0.0D);
      if ((FabbyManager.getInstance().isGPUSupportOpenCL()) && (!SegmentGLThread.access$1500(this.this$0)))
      {
        int k = FabbyManager.getInstance().segmentOnTexture(SegmentGLThread.access$1000(this.this$0).texture[0], localSegmentDataPipe.mMaskFrame.texture[0], SegmentGLThread.access$1000(this.this$0).width, SegmentGLThread.access$1000(this.this$0).height, false, i, j);
        SegmentGLThread.access$200(this.this$0).RenderProcess(SegmentGLThread.access$1000(this.this$0).texture[0], i * 16, j * 16, -1, 0.0D, SegmentGLThread.access$900(this.this$0));
        if (k != 0) {
          SegmentGLThread.access$1502(this.this$0, true);
        }
      }
      if ((SegmentGLThread.access$1500(this.this$0)) || (!FabbyManager.getInstance().isGPUSupportOpenCL()))
      {
        SegmentGLThread.access$200(this.this$0).RenderProcess(SegmentGLThread.access$1000(this.this$0).texture[0], i * 16, j * 16, -1, 0.0D, SegmentGLThread.access$900(this.this$0));
        if (!VideoBitmapUtil.isLegal(SegmentGLThread.access$1600(this.this$0))) {
          SegmentGLThread.access$1602(this.this$0, Bitmap.createBitmap(256, SegmentGLThread.access$1400() * 16, Bitmap.Config.ARGB_8888));
        }
        if (!VideoBitmapUtil.isLegal(SegmentGLThread.access$1700(this.this$0))) {
          SegmentGLThread.access$1702(this.this$0, Bitmap.createBitmap(SegmentGLThread.access$1400() * 16, 256, Bitmap.Config.ARGB_8888));
        }
        if (!VideoBitmapUtil.isLegal(SegmentGLThread.access$1800(this.this$0))) {
          SegmentGLThread.access$1802(this.this$0, Bitmap.createBitmap(16, SegmentGLThread.access$1400(), Bitmap.Config.ARGB_8888));
        }
        if (!VideoBitmapUtil.isLegal(SegmentGLThread.access$1900(this.this$0))) {
          SegmentGLThread.access$1902(this.this$0, Bitmap.createBitmap(SegmentGLThread.access$1400(), 16, Bitmap.Config.ARGB_8888));
        }
        if (!this.val$horizon) {
          break label684;
        }
        localBitmap1 = SegmentGLThread.access$1700(this.this$0);
        label478:
        if (!this.val$horizon) {
          break label696;
        }
      }
    }
    label677:
    label684:
    label696:
    for (Bitmap localBitmap2 = SegmentGLThread.access$1900(this.this$0);; localBitmap2 = SegmentGLThread.access$1800(this.this$0))
    {
      f.a(SegmentGLThread.access$900(this.this$0).texture[0], i * 16, j * 16, localBitmap1);
      FabbyManager.getInstance().segmentOnBitmap(localBitmap1, localBitmap2, i * 16, j * 16, i, j);
      GlUtil.loadTexture(SegmentGLThread.access$1100(this.this$0)[0], localBitmap2);
      SegmentGLThread.access$500(this.this$0).updateParam(SegmentGLThread.access$1000(this.this$0).width, SegmentGLThread.access$1000(this.this$0).height, i, j);
      SegmentGLThread.access$500(this.this$0).RenderProcess(SegmentGLThread.access$1100(this.this$0)[0], SegmentGLThread.access$1000(this.this$0).width, SegmentGLThread.access$1000(this.this$0).height, -1, 0.0D, localSegmentDataPipe.mMaskFrame);
      localSegmentDataPipe.makeDataReady();
      SegmentGLThread.access$700(this.this$0).makeBrotherTextureFree(localSegmentDataPipe);
      SegmentGLThread.access$1300(this.this$0).onDataReady(localSegmentDataPipe);
      BenchUtil.benchEnd("[showPreview][FABBY] segment");
      return;
      i = 16;
      break;
      j = SegmentGLThread.access$1400();
      break label49;
      localBitmap1 = SegmentGLThread.access$1600(this.this$0);
      break label478;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.ttpic.thread.SegmentGLThread.2
 * JD-Core Version:    0.7.0.1
 */