package com.tencent.scanlib.a;

import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.stubs.logger.Log;

public final class b$h
  extends b.c
{
  private f MlP;
  private int rotation;
  
  public b$h(f paramf, int paramInt)
  {
    this.MlP = paramf;
    this.rotation = paramInt;
  }
  
  private Void call()
  {
    AppMethodBeat.i(174586);
    try
    {
      Log.i("CameraTask.CameraReOpenTask", "reopen camera");
      this.MlP.close();
      this.MlP.ahq(this.rotation);
      this.MlP.a(new Camera.PreviewCallback()
      {
        public final void onPreviewFrame(byte[] paramAnonymousArrayOfByte, Camera paramAnonymousCamera) {}
      });
      AppMethodBeat.o(174586);
      return null;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("CameraTask.CameraReOpenTask", "reopen camera failed! %s", new Object[] { localException.getMessage() });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.scanlib.a.b.h
 * JD-Core Version:    0.7.0.1
 */