package com.tencent.view;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class c$2
  extends HandlerThread
{
  c$2(c paramc, String paramString)
  {
    super(paramString);
  }
  
  protected final void onLooperPrepared()
  {
    AppMethodBeat.i(86632);
    super.onLooperPrepared();
    AppMethodBeat.o(86632);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.view.c.2
 * JD-Core Version:    0.7.0.1
 */