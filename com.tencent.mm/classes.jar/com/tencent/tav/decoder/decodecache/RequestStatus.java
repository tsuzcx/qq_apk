package com.tencent.tav.decoder.decodecache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

class RequestStatus
{
  private volatile AtomicBoolean finish;
  
  RequestStatus()
  {
    AppMethodBeat.i(192002);
    this.finish = new AtomicBoolean(false);
    AppMethodBeat.o(192002);
  }
  
  public boolean getFinish()
  {
    AppMethodBeat.i(192007);
    boolean bool = this.finish.get();
    AppMethodBeat.o(192007);
    return bool;
  }
  
  public void setFinish(boolean paramBoolean)
  {
    AppMethodBeat.i(192005);
    this.finish.set(paramBoolean);
    AppMethodBeat.o(192005);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tav.decoder.decodecache.RequestStatus
 * JD-Core Version:    0.7.0.1
 */