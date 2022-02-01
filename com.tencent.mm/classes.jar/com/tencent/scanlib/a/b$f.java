package com.tencent.scanlib.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.stubs.logger.Log;

public final class b$f
  extends b.a
{
  private f ZqS;
  
  public b$f(f paramf)
  {
    this.ZqS = paramf;
  }
  
  private Void call()
  {
    AppMethodBeat.i(174582);
    try
    {
      if (this.ZqS.isOpen())
      {
        this.ZqS.close();
        Log.i("CameraTask.DefaultCloseTask", "close camera");
      }
      AppMethodBeat.o(174582);
      return null;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("CameraTask.DefaultCloseTask", "close camera failed! %s", new Object[] { localException.getMessage() });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.scanlib.a.b.f
 * JD-Core Version:    0.7.0.1
 */