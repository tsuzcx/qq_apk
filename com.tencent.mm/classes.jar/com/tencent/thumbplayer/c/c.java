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
  private Map<Long, d> EWs;
  private long MwV;
  private TPImageGenerator MwW;
  
  public c(int paramInt)
  {
    AppMethodBeat.i(194551);
    this.MwV = 0L;
    this.MwW = new TPImageGenerator(paramInt, this);
    this.EWs = new HashMap();
    this.MwW.init();
    AppMethodBeat.o(194551);
  }
  
  public c(String paramString)
  {
    AppMethodBeat.i(194550);
    this.MwV = 0L;
    this.MwW = new TPImageGenerator(paramString, this);
    this.EWs = new HashMap();
    this.MwW.init();
    AppMethodBeat.o(194550);
  }
  
  public final void a(long paramLong, TPImageGeneratorParams paramTPImageGeneratorParams, d paramd)
  {
    AppMethodBeat.i(194552);
    this.MwV += 1L;
    this.EWs.put(Long.valueOf(this.MwV), paramd);
    this.MwW.generateImageAsyncAtTime(paramLong, this.MwV, paramTPImageGeneratorParams);
    AppMethodBeat.o(194552);
  }
  
  public final void onImageGenerationCompleted(int paramInt, long paramLong1, long paramLong2, long paramLong3, TPVideoFrame paramTPVideoFrame)
  {
    AppMethodBeat.i(194554);
    if (((d)this.EWs.get(Long.valueOf(paramLong3)) == null) || (paramInt != 0) || (paramTPVideoFrame == null) || (paramTPVideoFrame.data.length <= 0) || (paramTPVideoFrame.height == 0) || (paramTPVideoFrame.width == 0)) {}
    for (;;)
    {
      this.EWs.remove(Long.valueOf(paramLong3));
      AppMethodBeat.o(194554);
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
    AppMethodBeat.i(194553);
    this.MwW.cancelAllImageGenerations();
    this.EWs.clear();
    this.MwW.unInit();
    this.MwW = null;
    AppMethodBeat.o(194553);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.thumbplayer.c.c
 * JD-Core Version:    0.7.0.1
 */