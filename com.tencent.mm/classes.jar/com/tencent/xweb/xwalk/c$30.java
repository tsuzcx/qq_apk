package com.tencent.xweb.xwalk;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.q;

final class c$30
  implements View.OnClickListener
{
  c$30(c paramc) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(139556);
    if (!q.dYn().BDM) {}
    for (boolean bool = true;; bool = false)
    {
      q.dYn().se(bool);
      if (!bool) {
        break;
      }
      this.BIO.dZX();
      this.BIO.BIJ.setVisibility(0);
      AppMethodBeat.o(139556);
      return;
    }
    if (this.BIO.BIJ != null) {
      this.BIO.BIJ.setVisibility(8);
    }
    AppMethodBeat.o(139556);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.xweb.xwalk.c.30
 * JD-Core Version:    0.7.0.1
 */