package com.tencent.mm.plugin.sns.ad.timeline.feedback.ui;

import android.content.Context;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends PopupWindow
  implements PopupWindow.OnDismissListener
{
  private PopupWindow.OnDismissListener JIG;
  private boolean JIH;
  public Context mContext;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(199817);
    super.setOnDismissListener(this);
    this.mContext = paramContext;
    AppMethodBeat.o(199817);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(199820);
    try
    {
      super.dismiss();
      AppMethodBeat.o(199820);
      return;
    }
    catch (Throwable localThrowable)
    {
      if ((!this.JIH) && (this.JIG != null)) {
        this.JIG.onDismiss();
      }
      AppMethodBeat.o(199820);
    }
  }
  
  public final void onDismiss()
  {
    AppMethodBeat.i(199823);
    try
    {
      this.JIH = true;
      if (this.JIG != null) {
        this.JIG.onDismiss();
      }
      AppMethodBeat.o(199823);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(199823);
    }
  }
  
  public final void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.JIG = paramOnDismissListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.feedback.ui.a
 * JD-Core Version:    0.7.0.1
 */