package com.tencent.mm.plugin.wenote.model.nativenote.c;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class e$11
  implements View.OnClickListener
{
  public e$11(e parame) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(26868);
    ab.i("NoteSelectManager", "unbold");
    this.vAR.dji();
    AppMethodBeat.o(26868);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.c.e.11
 * JD-Core Version:    0.7.0.1
 */