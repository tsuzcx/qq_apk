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
  private FileDescriptor ahGs;
  private Map<Integer, TPCaptureCallBack> mCallBackMap;
  private String mUrl;
  
  public c(FileDescriptor paramFileDescriptor)
  {
    AppMethodBeat.i(227290);
    this.mCallBackMap = new HashMap();
    this.ahGs = paramFileDescriptor;
    AppMethodBeat.o(227290);
  }
  
  public c(String paramString)
  {
    AppMethodBeat.i(227284);
    this.mCallBackMap = new HashMap();
    this.mUrl = paramString;
    AppMethodBeat.o(227284);
  }
  
  public final void a(long paramLong, TPImageGeneratorParams paramTPImageGeneratorParams, TPCaptureCallBack paramTPCaptureCallBack)
  {
    AppMethodBeat.i(227297);
    int i = b.kab().a(this.mUrl, this.ahGs, paramLong, paramTPImageGeneratorParams.width, paramTPImageGeneratorParams.height, this);
    this.mCallBackMap.put(Integer.valueOf(i), paramTPCaptureCallBack);
    AppMethodBeat.o(227297);
  }
  
  public final void aHL(int paramInt)
  {
    AppMethodBeat.i(227316);
    TPCaptureCallBack localTPCaptureCallBack = (TPCaptureCallBack)this.mCallBackMap.get(Integer.valueOf(paramInt));
    if (localTPCaptureCallBack != null) {
      localTPCaptureCallBack.onCaptureVideoFailed(1000001);
    }
    AppMethodBeat.o(227316);
  }
  
  public final void h(int paramInt, Bitmap paramBitmap)
  {
    AppMethodBeat.i(227311);
    TPCaptureCallBack localTPCaptureCallBack = (TPCaptureCallBack)this.mCallBackMap.get(Integer.valueOf(paramInt));
    if (localTPCaptureCallBack != null) {
      localTPCaptureCallBack.onCaptureVideoSuccess(paramBitmap);
    }
    AppMethodBeat.o(227311);
  }
  
  public final void release()
  {
    AppMethodBeat.i(227305);
    this.mCallBackMap.clear();
    AppMethodBeat.o(227305);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.b.c
 * JD-Core Version:    0.7.0.1
 */