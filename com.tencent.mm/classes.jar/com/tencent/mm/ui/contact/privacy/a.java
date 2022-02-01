package com.tencent.mm.ui.contact.privacy;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.s;

public final class a
{
  Context mContext;
  protected s tipDialog = null;
  
  public a(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  protected final void aT(final Runnable paramRunnable)
  {
    AppMethodBeat.i(267332);
    Context localContext = this.mContext;
    this.mContext.getResources().getString(R.l.app_tip);
    this.tipDialog = h.a(localContext, this.mContext.getResources().getString(R.l.eng), false, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(291988);
        if (paramRunnable != null) {
          paramRunnable.run();
        }
        AppMethodBeat.o(291988);
      }
    });
    AppMethodBeat.o(267332);
  }
  
  protected final void b(Runnable paramRunnable1, final Runnable paramRunnable2)
  {
    AppMethodBeat.i(267333);
    paramRunnable1.run();
    paramRunnable1 = this.mContext;
    this.mContext.getResources().getString(R.l.app_tip);
    this.tipDialog = h.a(paramRunnable1, this.mContext.getResources().getString(R.l.enk), false, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(286631);
        if (paramRunnable2 != null) {
          paramRunnable2.run();
        }
        AppMethodBeat.o(286631);
      }
    });
    AppMethodBeat.o(267333);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(267330);
    if (this.tipDialog != null)
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    AppMethodBeat.o(267330);
  }
  
  protected final void hVL()
  {
    AppMethodBeat.i(267334);
    Context localContext = this.mContext;
    this.mContext.getResources().getString(R.l.app_tip);
    this.tipDialog = h.a(localContext, this.mContext.getResources().getString(R.l.eng), false, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    AppMethodBeat.o(267334);
  }
  
  protected final void hVM()
  {
    AppMethodBeat.i(267336);
    Context localContext = this.mContext;
    this.mContext.getResources().getString(R.l.app_tip);
    this.tipDialog = h.a(localContext, this.mContext.getResources().getString(R.l.enk), false, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    AppMethodBeat.o(267336);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.privacy.a
 * JD-Core Version:    0.7.0.1
 */