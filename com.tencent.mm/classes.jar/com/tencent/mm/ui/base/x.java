package com.tencent.mm.ui.base;

import android.app.ProgressDialog;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public class x
  extends ProgressDialog
{
  public x(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public void dismiss()
  {
    AppMethodBeat.i(142120);
    try
    {
      super.dismiss();
      AppMethodBeat.o(142120);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.MMSafeProgressDialog", "dismiss exception, e = " + localException.getMessage());
      AppMethodBeat.o(142120);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.x
 * JD-Core Version:    0.7.0.1
 */