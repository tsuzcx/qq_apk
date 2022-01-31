package com.tencent.mm.plugin.voip.ui;

import android.support.v4.app.FragmentActivity;
import android.widget.TextView;

final class e$9
  implements Runnable
{
  e$9(e parame) {}
  
  public final void run()
  {
    if ((this.pYP.getActivity() == null) || (this.pYP.getActivity().isFinishing())) {
      return;
    }
    e.g(this.pYP).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.e.9
 * JD-Core Version:    0.7.0.1
 */