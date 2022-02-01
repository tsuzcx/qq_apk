package com.tencent.scanlib.a;

import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.stubs.logger.Log;

public final class b$g
  extends b.b
{
  private f ahvH;
  private int rotation;
  
  public b$g(f paramf, int paramInt)
  {
    this.ahvH = paramf;
    this.rotation = paramInt;
  }
  
  private Void cni()
  {
    AppMethodBeat.i(174584);
    try
    {
      if (!this.ahvH.isOpen())
      {
        Log.i("CameraTask.DefaultOpenTask", "open camera");
        this.ahvH.aHb(this.rotation);
        this.ahvH.c(new Camera.PreviewCallback()
        {
          public final void onPreviewFrame(byte[] paramAnonymousArrayOfByte, Camera paramAnonymousCamera) {}
        });
      }
      AppMethodBeat.o(174584);
      return null;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("CameraTask.DefaultOpenTask", "open camera failed! %s", new Object[] { localException.getMessage() });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.scanlib.a.b.g
 * JD-Core Version:    0.7.0.1
 */