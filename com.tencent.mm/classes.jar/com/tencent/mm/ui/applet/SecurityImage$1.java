package com.tencent.mm.ui.applet;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SecurityImage$1
  implements View.OnClickListener
{
  SecurityImage$1(SecurityImage paramSecurityImage) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(106231);
    SecurityImage.a(this.zgU);
    if (SecurityImage.b(this.zgU) != null) {
      SecurityImage.b(this.zgU).apW();
    }
    AppMethodBeat.o(106231);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.applet.SecurityImage.1
 * JD-Core Version:    0.7.0.1
 */