package com.tencent.mm.ui.contact.privacy;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.w;

public final class a
{
  Context mContext;
  protected w tipDialog = null;
  
  public a(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  protected final void b(Runnable paramRunnable1, final Runnable paramRunnable2)
  {
    AppMethodBeat.i(253304);
    paramRunnable1.run();
    paramRunnable1 = this.mContext;
    this.mContext.getResources().getString(R.l.app_tip);
    this.tipDialog = k.a(paramRunnable1, this.mContext.getResources().getString(R.l.gql), false, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(253325);
        if (paramRunnable2 != null) {
          paramRunnable2.run();
        }
        AppMethodBeat.o(253325);
      }
    });
    AppMethodBeat.o(253304);
  }
  
  protected final void bc(final Runnable paramRunnable)
  {
    AppMethodBeat.i(253298);
    Context localContext = this.mContext;
    this.mContext.getResources().getString(R.l.app_tip);
    this.tipDialog = k.a(localContext, this.mContext.getResources().getString(R.l.gqh), false, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(253323);
        if (paramRunnable != null) {
          paramRunnable.run();
        }
        AppMethodBeat.o(253323);
      }
    });
    AppMethodBeat.o(253298);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(253294);
    if (this.tipDialog != null)
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    AppMethodBeat.o(253294);
  }
  
  protected final void jzH()
  {
    AppMethodBeat.i(253310);
    Context localContext = this.mContext;
    this.mContext.getResources().getString(R.l.app_tip);
    this.tipDialog = k.a(localContext, this.mContext.getResources().getString(R.l.gqh), false, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    AppMethodBeat.o(253310);
  }
  
  protected final void jzI()
  {
    AppMethodBeat.i(253313);
    Context localContext = this.mContext;
    this.mContext.getResources().getString(R.l.app_tip);
    this.tipDialog = k.a(localContext, this.mContext.getResources().getString(R.l.gql), false, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    AppMethodBeat.o(253313);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.privacy.a
 * JD-Core Version:    0.7.0.1
 */