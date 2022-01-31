package com.tencent.mm.ui.h;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

final class b$1
  extends ak
{
  b$1(b paramb) {}
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(107426);
    switch (paramMessage.what)
    {
    default: 
      super.handleMessage(paramMessage);
      AppMethodBeat.o(107426);
      return;
    }
    this.Apr.dismiss();
    AppMethodBeat.o(107426);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.h.b.1
 * JD-Core Version:    0.7.0.1
 */