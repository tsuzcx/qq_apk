package com.tencent.xweb.xwalk;

import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.t;

public final class g$h
  implements t
{
  private ValueCallback<Boolean> aioS;
  
  public g$h(ValueCallback<Boolean> paramValueCallback)
  {
    this.aioS = paramValueCallback;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(154281);
    this.aioS.onReceiveValue(Boolean.FALSE);
    AppMethodBeat.o(154281);
  }
  
  public final void proceed()
  {
    AppMethodBeat.i(154280);
    this.aioS.onReceiveValue(Boolean.TRUE);
    AppMethodBeat.o(154280);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.xwalk.g.h
 * JD-Core Version:    0.7.0.1
 */