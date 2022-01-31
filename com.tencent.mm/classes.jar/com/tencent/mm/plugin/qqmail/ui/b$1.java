package com.tencent.mm.plugin.qqmail.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b$1
  implements View.OnClickListener
{
  b$1(b paramb, ImageView paramImageView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(68282);
    if (this.pMV.getVisibility() == 0) {
      this.pMV.performClick();
    }
    AppMethodBeat.o(68282);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.b.1
 * JD-Core Version:    0.7.0.1
 */