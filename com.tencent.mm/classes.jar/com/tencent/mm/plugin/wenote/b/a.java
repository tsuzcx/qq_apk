package com.tencent.mm.plugin.wenote.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.a.e;
import com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI;

public final class a
  extends e
{
  private NoteEditorUI BCq;
  
  public a(NoteEditorUI paramNoteEditorUI)
  {
    super(paramNoteEditorUI);
    this.BCq = paramNoteEditorUI;
  }
  
  public final boolean aVX()
  {
    AppMethodBeat.i(30264);
    boolean bool = super.aVX();
    AppMethodBeat.o(30264);
    return bool;
  }
  
  public final void fF(boolean paramBoolean)
  {
    AppMethodBeat.i(30265);
    if (this.BCq != null)
    {
      this.BCq.goBack();
      super.fF(paramBoolean);
    }
    AppMethodBeat.o(30265);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.b.a
 * JD-Core Version:    0.7.0.1
 */