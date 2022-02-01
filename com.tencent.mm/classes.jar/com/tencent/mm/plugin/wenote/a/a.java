package com.tencent.mm.plugin.wenote.a;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.a.e;
import com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI;
import java.util.Objects;

public final class a
  extends e
{
  private NoteEditorUI Xzr;
  
  public a(NoteEditorUI paramNoteEditorUI)
  {
    super(paramNoteEditorUI);
    this.Xzr = paramNoteEditorUI;
  }
  
  public final boolean bhU()
  {
    AppMethodBeat.i(30264);
    boolean bool = super.bhU();
    AppMethodBeat.o(30264);
    return bool;
  }
  
  public final Activity getActivity()
  {
    AppMethodBeat.i(275104);
    Activity localActivity = (Activity)Objects.requireNonNull(super.getActivity());
    AppMethodBeat.o(275104);
    return localActivity;
  }
  
  public final void iR(boolean paramBoolean)
  {
    AppMethodBeat.i(30265);
    if (this.Xzr != null)
    {
      this.Xzr.goBack();
      super.iR(paramBoolean);
    }
    AppMethodBeat.o(30265);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.a.a
 * JD-Core Version:    0.7.0.1
 */