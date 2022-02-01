package com.tencent.mm.plugin.wenote.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.a.e;
import com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI;

public final class a
  extends e
{
  private NoteEditorUI Eyt;
  
  public a(NoteEditorUI paramNoteEditorUI)
  {
    super(paramNoteEditorUI);
    this.Eyt = paramNoteEditorUI;
  }
  
  public final boolean bgz()
  {
    AppMethodBeat.i(30264);
    boolean bool = super.bgz();
    AppMethodBeat.o(30264);
    return bool;
  }
  
  public final void gg(boolean paramBoolean)
  {
    AppMethodBeat.i(30265);
    if (this.Eyt != null)
    {
      this.Eyt.goBack();
      super.gg(paramBoolean);
    }
    AppMethodBeat.o(30265);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.b.a
 * JD-Core Version:    0.7.0.1
 */