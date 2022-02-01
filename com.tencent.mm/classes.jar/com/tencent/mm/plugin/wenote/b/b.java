package com.tencent.mm.plugin.wenote.b;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.a.e;
import com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI;
import java.util.Objects;

public final class b
  extends e
{
  private NoteEditorUI UtH;
  
  public b(NoteEditorUI paramNoteEditorUI)
  {
    super(paramNoteEditorUI);
    this.UtH = paramNoteEditorUI;
  }
  
  public final boolean aGg()
  {
    AppMethodBeat.i(30264);
    boolean bool = super.aGg();
    AppMethodBeat.o(30264);
    return bool;
  }
  
  public final Activity getActivity()
  {
    AppMethodBeat.i(258249);
    Activity localActivity = (Activity)Objects.requireNonNull(super.getActivity());
    AppMethodBeat.o(258249);
    return localActivity;
  }
  
  public final void hb(boolean paramBoolean)
  {
    AppMethodBeat.i(30265);
    if (this.UtH != null)
    {
      this.UtH.goBack();
      super.hb(paramBoolean);
    }
    AppMethodBeat.o(30265);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.b.b
 * JD-Core Version:    0.7.0.1
 */