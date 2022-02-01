package com.tencent.tav.decoder.decodecache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

class RequestStatus
{
  private volatile AtomicBoolean finish;
  
  RequestStatus()
  {
    AppMethodBeat.i(215084);
    this.finish = new AtomicBoolean(false);
    AppMethodBeat.o(215084);
  }
  
  public boolean getFinish()
  {
    AppMethodBeat.i(215086);
    boolean bool = this.finish.get();
    AppMethodBeat.o(215086);
    return bool;
  }
  
  public void setFinish(boolean paramBoolean)
  {
    AppMethodBeat.i(215085);
    this.finish.set(paramBoolean);
    AppMethodBeat.o(215085);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tav.decoder.decodecache.RequestStatus
 * JD-Core Version:    0.7.0.1
 */