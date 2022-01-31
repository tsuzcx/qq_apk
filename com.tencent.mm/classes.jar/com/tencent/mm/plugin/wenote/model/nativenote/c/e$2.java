package com.tencent.mm.plugin.wenote.model.nativenote.c;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.model.nativenote.b.a;
import com.tencent.mm.sdk.platformtools.ab;

public final class e$2
  implements View.OnClickListener
{
  public e$2(e parame) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(26859);
    ab.i("NoteSelectManager", "delete");
    if ((!e.djy()) || (!e.k(this.vAR)))
    {
      ab.e("NoteSelectManager", "delete: not init or not editable");
      this.vAR.dji();
      AppMethodBeat.o(26859);
      return;
    }
    if (e.l(this.vAR))
    {
      if (e.m(this.vAR) != null) {
        e.m(this.vAR).dhZ();
      }
      AppMethodBeat.o(26859);
      return;
    }
    if (e.m(this.vAR) != null)
    {
      e.m(this.vAR).dia();
      AppMethodBeat.o(26859);
      return;
    }
    this.vAR.djq();
    AppMethodBeat.o(26859);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.c.e.2
 * JD-Core Version:    0.7.0.1
 */