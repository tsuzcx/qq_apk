package com.tencent.tav.decoder.decodecache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

class RequestStatus
{
  private volatile AtomicBoolean finish;
  
  RequestStatus()
  {
    AppMethodBeat.i(218435);
    this.finish = new AtomicBoolean(false);
    AppMethodBeat.o(218435);
  }
  
  public boolean getFinish()
  {
    AppMethodBeat.i(218437);
    boolean bool = this.finish.get();
    AppMethodBeat.o(218437);
    return bool;
  }
  
  public void setFinish(boolean paramBoolean)
  {
    AppMethodBeat.i(218436);
    this.finish.set(paramBoolean);
    AppMethodBeat.o(218436);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tav.decoder.decodecache.RequestStatus
 * JD-Core Version:    0.7.0.1
 */