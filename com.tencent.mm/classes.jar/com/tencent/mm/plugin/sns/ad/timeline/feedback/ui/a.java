package com.tencent.mm.plugin.sns.ad.timeline.feedback.ui;

import android.content.Context;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends PopupWindow
  implements PopupWindow.OnDismissListener
{
  public Context mContext;
  private PopupWindow.OnDismissListener zrK;
  private boolean zrL;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(219114);
    super.setOnDismissListener(this);
    this.mContext = paramContext;
    AppMethodBeat.o(219114);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(219115);
    try
    {
      super.dismiss();
      AppMethodBeat.o(219115);
      return;
    }
    catch (Throwable localThrowable)
    {
      if ((!this.zrL) && (this.zrK != null)) {
        this.zrK.onDismiss();
      }
      AppMethodBeat.o(219115);
    }
  }
  
  public final void onDismiss()
  {
    AppMethodBeat.i(219116);
    try
    {
      this.zrL = true;
      if (this.zrK != null) {
        this.zrK.onDismiss();
      }
      AppMethodBeat.o(219116);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(219116);
    }
  }
  
  public final void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.zrK = paramOnDismissListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.feedback.ui.a
 * JD-Core Version:    0.7.0.1
 */