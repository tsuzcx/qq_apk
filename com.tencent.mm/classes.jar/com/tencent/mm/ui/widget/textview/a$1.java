package com.tencent.mm.ui.widget.textview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.ak;

final class a$1
  implements Runnable
{
  a$1(a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(113118);
    if (this.ANs.ANh)
    {
      ak.d("SelectableTextHelper", "isReInit, return.", new Object[0]);
      AppMethodBeat.o(113118);
      return;
    }
    ak.d("SelectableTextHelper", "in mShowSelectViewRunnable. opener: %s, inScrolling: %s.", new Object[] { Boolean.valueOf(this.ANs.ANl), Boolean.valueOf(this.ANs.ANm) });
    if (this.ANs.AMU != null)
    {
      if (!this.ANs.ANl)
      {
        this.ANs.ANl = true;
        if (this.ANs.ANm)
        {
          ak.d("SelectableTextHelper", "menu is hide: %s, cursor is hide: %s.", new Object[] { Boolean.valueOf(this.ANs.ANj), Boolean.valueOf(this.ANs.ANk) });
          if (!this.ANs.ANj) {
            this.ANs.dPW();
          }
          if (!this.ANs.ANk)
          {
            this.ANs.dPS();
            this.ANs.hZ(this.ANs.AMQ.akX, this.ANs.AMQ.Fe);
          }
          if ((this.ANs.AMU != null) && (this.ANs.ANj) && (!this.ANs.ANk)) {
            this.ANs.AMU.eW(this.ANs.AMT);
          }
        }
        this.ANs.ANm = false;
        AppMethodBeat.o(113118);
        return;
      }
      if (this.ANs.ANn)
      {
        this.ANs.ANn = false;
        ak.d("SelectableTextHelper", "judge result(delay), click outside.", new Object[0]);
        if (this.ANs.ANq != null)
        {
          this.ANs.ANq.dLu();
          AppMethodBeat.o(113118);
        }
      }
      else
      {
        ak.d("SelectableTextHelper", "Oh, bypass the judge logic! Don't worry, that's reasonable.", new Object[0]);
        AppMethodBeat.o(113118);
      }
    }
    else
    {
      if (!this.ANs.ANj) {
        this.ANs.dPW();
      }
      if (!this.ANs.ANk) {
        this.ANs.dPS();
      }
    }
    AppMethodBeat.o(113118);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.textview.a.1
 * JD-Core Version:    0.7.0.1
 */