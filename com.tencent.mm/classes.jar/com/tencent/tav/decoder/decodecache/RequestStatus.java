package com.tencent.tav.decoder.decodecache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

class RequestStatus
{
  private volatile AtomicBoolean finish;
  
  RequestStatus()
  {
    AppMethodBeat.i(198048);
    this.finish = new AtomicBoolean(false);
    AppMethodBeat.o(198048);
  }
  
  public boolean getFinish()
  {
    AppMethodBeat.i(198050);
    boolean bool = this.finish.get();
    AppMethodBeat.o(198050);
    return bool;
  }
  
  public void setFinish(boolean paramBoolean)
  {
    AppMethodBeat.i(198049);
    this.finish.set(paramBoolean);
    AppMethodBeat.o(198049);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tav.decoder.decodecache.RequestStatus
 * JD-Core Version:    0.7.0.1
 */