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
  private PopupWindow.OnDismissListener zbj;
  private boolean zbk;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(197648);
    super.setOnDismissListener(this);
    this.mContext = paramContext;
    AppMethodBeat.o(197648);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(197649);
    try
    {
      super.dismiss();
      AppMethodBeat.o(197649);
      return;
    }
    catch (Throwable localThrowable)
    {
      if ((!this.zbk) && (this.zbj != null)) {
        this.zbj.onDismiss();
      }
      AppMethodBeat.o(197649);
    }
  }
  
  public final void onDismiss()
  {
    AppMethodBeat.i(197650);
    try
    {
      this.zbk = true;
      if (this.zbj != null) {
        this.zbj.onDismiss();
      }
      AppMethodBeat.o(197650);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(197650);
    }
  }
  
  public final void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.zbj = paramOnDismissListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.feedback.ui.a
 * JD-Core Version:    0.7.0.1
 */