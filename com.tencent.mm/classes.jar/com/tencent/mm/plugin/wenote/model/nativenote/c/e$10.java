package com.tencent.mm.plugin.wenote.model.nativenote.c;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class e$10
  implements View.OnClickListener
{
  public e$10(e parame) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(26867);
    ab.i("NoteSelectManager", "bold");
    this.vAR.dji();
    AppMethodBeat.o(26867);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.c.e.10
 * JD-Core Version:    0.7.0.1
 */