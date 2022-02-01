package com.tencent.xweb.xwalk;

import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.r;

public final class g$h
  implements r
{
  ValueCallback<Boolean> aail;
  
  public g$h(ValueCallback<Boolean> paramValueCallback)
  {
    this.aail = paramValueCallback;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(154281);
    this.aail.onReceiveValue(Boolean.FALSE);
    AppMethodBeat.o(154281);
  }
  
  public final void proceed()
  {
    AppMethodBeat.i(154280);
    this.aail.onReceiveValue(Boolean.TRUE);
    AppMethodBeat.o(154280);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.xwalk.g.h
 * JD-Core Version:    0.7.0.1
 */