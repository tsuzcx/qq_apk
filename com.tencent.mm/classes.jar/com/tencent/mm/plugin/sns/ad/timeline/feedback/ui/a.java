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
  private PopupWindow.OnDismissListener xLU;
  private boolean xLV;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(200002);
    super.setOnDismissListener(this);
    this.mContext = paramContext;
    AppMethodBeat.o(200002);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(200003);
    try
    {
      super.dismiss();
      AppMethodBeat.o(200003);
      return;
    }
    catch (Throwable localThrowable)
    {
      if ((!this.xLV) && (this.xLU != null)) {
        this.xLU.onDismiss();
      }
      AppMethodBeat.o(200003);
    }
  }
  
  public final void onDismiss()
  {
    AppMethodBeat.i(200004);
    try
    {
      this.xLV = true;
      if (this.xLU != null) {
        this.xLU.onDismiss();
      }
      AppMethodBeat.o(200004);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(200004);
    }
  }
  
  public final void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.xLU = paramOnDismissListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.feedback.ui.a
 * JD-Core Version:    0.7.0.1
 */