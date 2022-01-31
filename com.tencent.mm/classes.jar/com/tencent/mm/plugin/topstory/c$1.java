package com.tencent.mm.plugin.topstory;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

final class c$1
  extends ak
{
  c$1(c paramc, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(65492);
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(65492);
      return;
      ((c.a)paramMessage.obj).run();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.c.1
 * JD-Core Version:    0.7.0.1
 */