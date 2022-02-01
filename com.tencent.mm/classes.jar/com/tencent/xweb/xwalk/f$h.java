package com.tencent.xweb.xwalk;

import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.q;

public final class f$h
  implements q
{
  ValueCallback<Boolean> ITJ;
  
  public f$h(ValueCallback<Boolean> paramValueCallback)
  {
    this.ITJ = paramValueCallback;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(154281);
    this.ITJ.onReceiveValue(Boolean.FALSE);
    AppMethodBeat.o(154281);
  }
  
  public final void proceed()
  {
    AppMethodBeat.i(154280);
    this.ITJ.onReceiveValue(Boolean.TRUE);
    AppMethodBeat.o(154280);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.xwalk.f.h
 * JD-Core Version:    0.7.0.1
 */