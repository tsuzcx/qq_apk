package com.tencent.mm.plugin.wenote.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.a.e;
import com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI;

public final class a
  extends e
{
  private NoteEditorUI EQP;
  
  public a(NoteEditorUI paramNoteEditorUI)
  {
    super(paramNoteEditorUI);
    this.EQP = paramNoteEditorUI;
  }
  
  public final boolean bhh()
  {
    AppMethodBeat.i(30264);
    boolean bool = super.bhh();
    AppMethodBeat.o(30264);
    return bool;
  }
  
  public final void ge(boolean paramBoolean)
  {
    AppMethodBeat.i(30265);
    if (this.EQP != null)
    {
      this.EQP.goBack();
      super.ge(paramBoolean);
    }
    AppMethodBeat.o(30265);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.b.a
 * JD-Core Version:    0.7.0.1
 */