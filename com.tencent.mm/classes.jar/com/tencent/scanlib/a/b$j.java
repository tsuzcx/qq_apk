package com.tencent.scanlib.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.stubs.logger.Log;

public final class b$j
  extends b.e
{
  private f ahvH;
  
  public b$j(f paramf)
  {
    this.ahvH = paramf;
  }
  
  private Void cni()
  {
    AppMethodBeat.i(174590);
    try
    {
      if (this.ahvH.boa())
      {
        Log.i("CameraTask.DefaultStopPreviewTask", "stop preview");
        this.ahvH.auq();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.scanlib.a.b.j
 * JD-Core Version:    0.7.0.1
 */