package com.tencent.scanlib.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.stubs.logger.Log;

public final class b$j
  extends b.e
{
  private f MlP;
  
  public b$j(f paramf)
  {
    this.MlP = paramf;
  }
  
  private Void call()
  {
    AppMethodBeat.i(174590);
    try
    {
      if (this.MlP.cOB())
      {
        Log.i("CameraTask.DefaultStopPreviewTask", "stop preview");
        this.MlP.stopPreview();
      }
      AppMethodBeat.o(174590);
      return null;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.i("CameraTask.DefaultStopPreviewTask", "stop preview failed! %s", new Object[] { localException.getMessage() });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.scanlib.a.b.j
 * JD-Core Version:    0.7.0.1
 */