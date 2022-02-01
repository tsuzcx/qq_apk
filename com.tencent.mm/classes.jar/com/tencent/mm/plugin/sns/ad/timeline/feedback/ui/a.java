package com.tencent.mm.plugin.sns.ad.timeline.feedback.ui;

import android.content.Context;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends PopupWindow
  implements PopupWindow.OnDismissListener
{
  private PopupWindow.OnDismissListener DyL;
  private boolean DyM;
  public Context mContext;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(202192);
    super.setOnDismissListener(this);
    this.mContext = paramContext;
    AppMethodBeat.o(202192);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(202193);
    try
    {
      super.dismiss();
      AppMethodBeat.o(202193);
      return;
    }
    catch (Throwable localThrowable)
    {
      if ((!this.DyM) && (this.DyL != null)) {
        this.DyL.onDismiss();
      }
      AppMethodBeat.o(202193);
    }
  }
  
  public final void onDismiss()
  {
    AppMethodBeat.i(202194);
    try
    {
      this.DyM = true;
      if (this.DyL != null) {
        this.DyL.onDismiss();
      }
      AppMethodBeat.o(202194);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(202194);
    }
  }
  
  public final void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.DyL = paramOnDismissListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.feedback.ui.a
 * JD-Core Version:    0.7.0.1
 */