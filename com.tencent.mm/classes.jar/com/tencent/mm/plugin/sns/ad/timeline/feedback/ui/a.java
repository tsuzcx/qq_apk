package com.tencent.mm.plugin.sns.ad.timeline.feedback.ui;

import android.content.Context;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends PopupWindow
  implements PopupWindow.OnDismissListener
{
  private PopupWindow.OnDismissListener PZI;
  private boolean PZJ;
  public Context mContext;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(310991);
    super.setOnDismissListener(this);
    this.mContext = paramContext;
    AppMethodBeat.o(310991);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(311000);
    try
    {
      super.dismiss();
      AppMethodBeat.o(311000);
      return;
    }
    finally
    {
      if ((!this.PZJ) && (this.PZI != null)) {
        this.PZI.onDismiss();
      }
      AppMethodBeat.o(311000);
    }
  }
  
  public final void onDismiss()
  {
    AppMethodBeat.i(311010);
    try
    {
      this.PZJ = true;
      if (this.PZI != null) {
        this.PZI.onDismiss();
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(311010);
    }
  }
  
  public final void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.PZI = paramOnDismissListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.feedback.ui.a
 * JD-Core Version:    0.7.0.1
 */