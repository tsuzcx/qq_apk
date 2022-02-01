package com.tencent.xweb.xwalk;

import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.r;

public final class g$h
  implements r
{
  ValueCallback<Boolean> KGk;
  
  public g$h(ValueCallback<Boolean> paramValueCallback)
  {
    this.KGk = paramValueCallback;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(154281);
    this.KGk.onReceiveValue(Boolean.FALSE);
    AppMethodBeat.o(154281);
  }
  
  public final void proceed()
  {
    AppMethodBeat.i(154280);
    this.KGk.onReceiveValue(Boolean.TRUE);
    AppMethodBeat.o(154280);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.xwalk.g.h
 * JD-Core Version:    0.7.0.1
 */