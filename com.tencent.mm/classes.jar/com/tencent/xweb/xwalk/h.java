package com.tencent.xweb.xwalk;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.c.g;
import org.xwalk.core.XWalkV8;

public final class h
  implements g
{
  XWalkV8 BJG;
  private HandlerThread BJH;
  private Handler BJI;
  
  public h()
  {
    AppMethodBeat.i(85241);
    this.BJH = new HandlerThread("j2v8");
    this.BJH.start();
    this.BJI = new Handler(this.BJH.getLooper());
    AppMethodBeat.o(85241);
  }
  
  public final void init(int paramInt)
  {
    AppMethodBeat.i(85242);
    this.BJI.post(new h.1(this, paramInt));
    AppMethodBeat.o(85242);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.xweb.xwalk.h
 * JD-Core Version:    0.7.0.1
 */