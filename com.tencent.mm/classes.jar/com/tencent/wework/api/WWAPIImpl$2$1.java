package com.tencent.wework.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wework.api.model.BaseMessage;
import com.tencent.wework.api.model.WWBaseRespMessage;
import java.util.Map;

class WWAPIImpl$2$1
  implements Runnable
{
  WWAPIImpl$2$1(WWAPIImpl.2 param2, BaseMessage paramBaseMessage) {}
  
  public void run()
  {
    AppMethodBeat.i(140104);
    try
    {
      WWAPIImpl.b(this.BCI.BCG).get(((WWBaseRespMessage)this.BCH).transaction);
      WWAPIImpl.b(this.BCI.BCG).remove(((WWBaseRespMessage)this.BCH).transaction);
      AppMethodBeat.o(140104);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(140104);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.wework.api.WWAPIImpl.2.1
 * JD-Core Version:    0.7.0.1
 */