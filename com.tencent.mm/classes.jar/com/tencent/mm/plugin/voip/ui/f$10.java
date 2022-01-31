package com.tencent.mm.plugin.voip.ui;

import android.support.v4.app.FragmentActivity;
import android.widget.TextView;

final class f$10
  implements Runnable
{
  f$10(f paramf) {}
  
  public final void run()
  {
    if ((this.pZw.getActivity() == null) || (this.pZw.getActivity().isFinishing())) {
      return;
    }
    f.k(this.pZw).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.f.10
 * JD-Core Version:    0.7.0.1
 */