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
  private Map<Long, d> CZX;
  private long KgK;
  private TPImageGenerator KgL;
  
  public c(int paramInt)
  {
    AppMethodBeat.i(187852);
    this.KgK = 0L;
    this.KgL = new TPImageGenerator(paramInt, this);
    this.CZX = new HashMap();
    this.KgL.init();
    AppMethodBeat.o(187852);
  }
  
  public c(String paramString)
  {
    AppMethodBeat.i(187851);
    this.KgK = 0L;
    this.KgL = new TPImageGenerator(paramString, this);
    this.CZX = new HashMap();
    this.KgL.init();
    AppMethodBeat.o(187851);
  }
  
  public final void a(long paramLong, TPImageGeneratorParams paramTPImageGeneratorParams, d paramd)
  {
    AppMethodBeat.i(187853);
    this.KgK += 1L;
    this.CZX.put(Long.valueOf(this.KgK), paramd);
    this.KgL.generateImageAsyncAtTime(paramLong, this.KgK, paramTPImageGeneratorParams);
    AppMethodBeat.o(187853);
  }
  
  public final void onImageGenerationCompleted(int paramInt, long paramLong1, long paramLong2, long paramLong3, TPVideoFrame paramTPVideoFrame)
  {
    AppMethodBeat.i(187855);
    if (((d)this.CZX.get(Long.valueOf(paramLong3)) == null) || (paramInt != 0) || (paramTPVideoFrame == null) || (paramTPVideoFrame.data.length <= 0) || (paramTPVideoFrame.height == 0) || (paramTPVideoFrame.width == 0)) {}
    for (;;)
    {
      this.CZX.remove(Long.valueOf(paramLong3));
      AppMethodBeat.o(187855);
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
    AppMethodBeat.i(187854);
    this.KgL.cancelAllImageGenerations();
    this.CZX.clear();
    this.KgL.unInit();
    this.KgL = null;
    AppMethodBeat.o(187854);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.thumbplayer.c.c
 * JD-Core Version:    0.7.0.1
 */