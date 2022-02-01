package com.tencent.mm.ui.base;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler;

final class aa$10
  extends MMHandler
{
  aa$10(v paramv) {}
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(142233);
    this.adUr.dismiss();
    super.handleMessage(paramMessage);
    AppMethodBeat.o(142233);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.aa.10
 * JD-Core Version:    0.7.0.1
 */