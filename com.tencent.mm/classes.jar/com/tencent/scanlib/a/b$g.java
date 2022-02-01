package com.tencent.scanlib.a;

import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.stubs.logger.Log;

public final class b$g
  extends b.b
{
  private f MlP;
  private int rotation;
  
  public b$g(f paramf, int paramInt)
  {
    this.MlP = paramf;
    this.rotation = paramInt;
  }
  
  private Void call()
  {
    AppMethodBeat.i(174584);
    try
    {
      if (!this.MlP.isOpen())
      {
        Log.i("CameraTask.DefaultOpenTask", "open camera");
        this.MlP.ahq(this.rotation);
        this.MlP.a(new Camera.PreviewCallback()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.scanlib.a.b.g
 * JD-Core Version:    0.7.0.1
 */