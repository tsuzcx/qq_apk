package com.tencent.tav.decoder.decodecache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

class RequestStatus
{
  private volatile AtomicBoolean finish;
  
  RequestStatus()
  {
    AppMethodBeat.i(216416);
    this.finish = new AtomicBoolean(false);
    AppMethodBeat.o(216416);
  }
  
  public boolean getFinish()
  {
    AppMethodBeat.i(216429);
    boolean bool = this.finish.get();
    AppMethodBeat.o(216429);
    return bool;
  }
  
  public void setFinish(boolean paramBoolean)
  {
    AppMethodBeat.i(216424);
    this.finish.set(paramBoolean);
    AppMethodBeat.o(216424);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tav.decoder.decodecache.RequestStatus
 * JD-Core Version:    0.7.0.1
 */