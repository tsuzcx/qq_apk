package com.tencent.tav.decoder.decodecache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

class RequestStatus
{
  private volatile AtomicBoolean finish;
  
  RequestStatus()
  {
    AppMethodBeat.i(218444);
    this.finish = new AtomicBoolean(false);
    AppMethodBeat.o(218444);
  }
  
  public boolean getFinish()
  {
    AppMethodBeat.i(218446);
    boolean bool = this.finish.get();
    AppMethodBeat.o(218446);
    return bool;
  }
  
  public void setFinish(boolean paramBoolean)
  {
    AppMethodBeat.i(218445);
    this.finish.set(paramBoolean);
    AppMethodBeat.o(218445);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tav.decoder.decodecache.RequestStatus
 * JD-Core Version:    0.7.0.1
 */