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
  private FileDescriptor ZBp;
  private Map<Integer, TPCaptureCallBack> mCallBackMap;
  private String mUrl;
  
  public c(FileDescriptor paramFileDescriptor)
  {
    AppMethodBeat.i(220067);
    this.mCallBackMap = new HashMap();
    this.ZBp = paramFileDescriptor;
    AppMethodBeat.o(220067);
  }
  
  public c(String paramString)
  {
    AppMethodBeat.i(220065);
    this.mCallBackMap = new HashMap();
    this.mUrl = paramString;
    AppMethodBeat.o(220065);
  }
  
  public final void a(long paramLong, TPImageGeneratorParams paramTPImageGeneratorParams, TPCaptureCallBack paramTPCaptureCallBack)
  {
    AppMethodBeat.i(220071);
    int i = b.iqF().a(this.mUrl, this.ZBp, paramLong, paramTPImageGeneratorParams.width, paramTPImageGeneratorParams.height, this);
    this.mCallBackMap.put(Integer.valueOf(i), paramTPCaptureCallBack);
    AppMethodBeat.o(220071);
  }
  
  public final void aAY(int paramInt)
  {
    AppMethodBeat.i(220077);
    TPCaptureCallBack localTPCaptureCallBack = (TPCaptureCallBack)this.mCallBackMap.get(Integer.valueOf(paramInt));
    if (localTPCaptureCallBack != null) {
      localTPCaptureCallBack.onCaptureVideoFailed(1000001);
    }
    AppMethodBeat.o(220077);
  }
  
  public final void f(int paramInt, Bitmap paramBitmap)
  {
    AppMethodBeat.i(220075);
    TPCaptureCallBack localTPCaptureCallBack = (TPCaptureCallBack)this.mCallBackMap.get(Integer.valueOf(paramInt));
    if (localTPCaptureCallBack != null) {
      localTPCaptureCallBack.onCaptureVideoSuccess(paramBitmap);
    }
    AppMethodBeat.o(220075);
  }
  
  public final void release()
  {
    AppMethodBeat.i(220073);
    this.mCallBackMap.clear();
    AppMethodBeat.o(220073);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.thumbplayer.b.c
 * JD-Core Version:    0.7.0.1
 */