package com.tencent.thumbplayer.c;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.a.a.a;
import com.tencent.thumbplayer.b.d;
import com.tencent.thumbplayer.core.common.TPVideoFrame;
import com.tencent.thumbplayer.core.imagegenerator.ITPImageGeneratorCallback;
import com.tencent.thumbplayer.core.imagegenerator.TPImageGenerator;
import com.tencent.thumbplayer.core.imagegenerator.TPImageGeneratorParams;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

public final class c
  implements a, ITPImageGeneratorCallback
{
  private Map<Long, d> EDW;
  private long Maa;
  private TPImageGenerator Mab;
  
  public c(int paramInt)
  {
    AppMethodBeat.i(191873);
    this.Maa = 0L;
    this.Mab = new TPImageGenerator(paramInt, this);
    this.EDW = new HashMap();
    this.Mab.init();
    AppMethodBeat.o(191873);
  }
  
  public c(String paramString)
  {
    AppMethodBeat.i(191872);
    this.Maa = 0L;
    this.Mab = new TPImageGenerator(paramString, this);
    this.EDW = new HashMap();
    this.Mab.init();
    AppMethodBeat.o(191872);
  }
  
  public final void a(long paramLong, TPImageGeneratorParams paramTPImageGeneratorParams, d paramd)
  {
    AppMethodBeat.i(191874);
    this.Maa += 1L;
    this.EDW.put(Long.valueOf(this.Maa), paramd);
    this.Mab.generateImageAsyncAtTime(paramLong, this.Maa, paramTPImageGeneratorParams);
    AppMethodBeat.o(191874);
  }
  
  public final void onImageGenerationCompleted(int paramInt, long paramLong1, long paramLong2, long paramLong3, TPVideoFrame paramTPVideoFrame)
  {
    AppMethodBeat.i(191876);
    if (((d)this.EDW.get(Long.valueOf(paramLong3)) == null) || (paramInt != 0) || (paramTPVideoFrame == null) || (paramTPVideoFrame.data.length <= 0) || (paramTPVideoFrame.height == 0) || (paramTPVideoFrame.width == 0)) {}
    for (;;)
    {
      this.EDW.remove(Long.valueOf(paramLong3));
      AppMethodBeat.o(191876);
      return;
      Object localObject = paramTPVideoFrame.data[0];
      paramInt = paramTPVideoFrame.width;
      int i = paramTPVideoFrame.height;
      int j = paramTPVideoFrame.rotation;
      localObject = ByteBuffer.wrap((byte[])localObject);
      paramTPVideoFrame = Bitmap.createBitmap(paramInt, i, Bitmap.Config.RGB_565);
      paramTPVideoFrame.copyPixelsFromBuffer((Buffer)localObject);
      if (j != 0)
      {
        localObject = new Matrix();
        ((Matrix)localObject).postRotate(j);
        Bitmap.createBitmap(paramTPVideoFrame, 0, 0, paramTPVideoFrame.getWidth(), paramTPVideoFrame.getHeight(), (Matrix)localObject, true);
      }
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(191875);
    this.Mab.cancelAllImageGenerations();
    this.EDW.clear();
    this.Mab.unInit();
    this.Mab = null;
    AppMethodBeat.o(191875);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.thumbplayer.c.c
 * JD-Core Version:    0.7.0.1
 */