package com.tencent.mm.ui.base;

import android.app.ProgressDialog;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public class q
  extends ProgressDialog
{
  public q(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public void dismiss()
  {
    AppMethodBeat.i(106763);
    try
    {
      super.dismiss();
      AppMethodBeat.o(106763);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.MMSafeProgressDialog", "dismiss exception, e = " + localException.getMessage());
      AppMethodBeat.o(106763);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.q
 * JD-Core Version:    0.7.0.1
 */