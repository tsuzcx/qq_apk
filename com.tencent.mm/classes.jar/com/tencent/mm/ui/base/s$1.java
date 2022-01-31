package com.tencent.mm.ui.base;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

final class s$1
  extends ak
{
  s$1(Looper paramLooper, Context paramContext, s params)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(106865);
    if (((this.val$context instanceof Activity)) && (((Activity)this.val$context).isFinishing()))
    {
      AppMethodBeat.o(106865);
      return;
    }
    this.zmX.dismiss();
    AppMethodBeat.o(106865);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.base.s.1
 * JD-Core Version:    0.7.0.1
 */