package com.tencent.thumbplayer.b;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.a.a.a;
import com.tencent.thumbplayer.api.TPCaptureCallBack;
import com.tencent.thumbplayer.core.imagegenerator.TPImageGeneratorParams;
import java.io.FileDescriptor;
import java.util.HashMap;
import java.util.Map;

public final class c
  implements a, b.a
{
  private FileDescriptor RYF;
  private Map<Integer, TPCaptureCallBack> mCallBackMap;
  private String mUrl;
  
  public c(FileDescriptor paramFileDescriptor)
  {
    AppMethodBeat.i(189093);
    this.mCallBackMap = new HashMap();
    this.RYF = paramFileDescriptor;
    AppMethodBeat.o(189093);
  }
  
  public c(String paramString)
  {
    AppMethodBeat.i(189092);
    this.mCallBackMap = new HashMap();
    this.mUrl = paramString;
    AppMethodBeat.o(189092);
  }
  
  public final void a(long paramLong, TPImageGeneratorParams paramTPImageGeneratorParams, TPCaptureCallBack paramTPCaptureCallBack)
  {
    AppMethodBeat.i(189094);
    int i = b.hne().a(this.mUrl, this.RYF, paramLong, paramTPImageGeneratorParams.width, paramTPImageGeneratorParams.height, this);
    this.mCallBackMap.put(Integer.valueOf(i), paramTPCaptureCallBack);
    AppMethodBeat.o(189094);
  }
  
  public final void arl(int paramInt)
  {
    AppMethodBeat.i(189097);
    TPCaptureCallBack localTPCaptureCallBack = (TPCaptureCallBack)this.mCallBackMap.get(Integer.valueOf(paramInt));
    if (localTPCaptureCallBack != null) {
      localTPCaptureCallBack.onCaptureVideoFailed(1000001);
    }
    AppMethodBeat.o(189097);
  }
  
  public final void f(int paramInt, Bitmap paramBitmap)
  {
    AppMethodBeat.i(189096);
    TPCaptureCallBack localTPCaptureCallBack = (TPCaptureCallBack)this.mCallBackMap.get(Integer.valueOf(paramInt));
    if (localTPCaptureCallBack != null) {
      localTPCaptureCallBack.onCaptureVideoSuccess(paramBitmap);
    }
    AppMethodBeat.o(189096);
  }
  
  public final void release()
  {
    AppMethodBeat.i(189095);
    this.mCallBackMap.clear();
    AppMethodBeat.o(189095);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.thumbplayer.b.c
 * JD-Core Version:    0.7.0.1
 */