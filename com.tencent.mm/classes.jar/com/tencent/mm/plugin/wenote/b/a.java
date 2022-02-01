package com.tencent.mm.plugin.wenote.b;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.a.e;
import com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI;
import java.util.Objects;

public final class a
  extends e
{
  private NoteEditorUI QFT;
  
  public a(NoteEditorUI paramNoteEditorUI)
  {
    super(paramNoteEditorUI);
    this.QFT = paramNoteEditorUI;
  }
  
  public final boolean aOg()
  {
    AppMethodBeat.i(30264);
    boolean bool = super.aOg();
    AppMethodBeat.o(30264);
    return bool;
  }
  
  public final Activity getActivity()
  {
    AppMethodBeat.i(292194);
    Activity localActivity = (Activity)Objects.requireNonNull(super.getActivity());
    AppMethodBeat.o(292194);
    return localActivity;
  }
  
  public final void hS(boolean paramBoolean)
  {
    AppMethodBeat.i(30265);
    if (this.QFT != null)
    {
      this.QFT.goBack();
      super.hS(paramBoolean);
    }
    AppMethodBeat.o(30265);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.b.a
 * JD-Core Version:    0.7.0.1
 */