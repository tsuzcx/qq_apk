package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.ui.nativenote.a.b;

final class NoteEditorUI$a
  extends b
{
  NoteEditorUI$a(NoteEditorUI paramNoteEditorUI) {}
  
  public final void c(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(27052);
    super.c(paramRecyclerView, paramInt);
    if (paramRecyclerView.getLayoutManager() != null)
    {
      paramRecyclerView = ((LinearLayoutManager)NoteEditorUI.N(this.vCx).getLayoutManager()).getChildAt(0);
      if (paramRecyclerView != null)
      {
        NoteEditorUI.b(this.vCx, paramRecyclerView.getTop());
        NoteEditorUI.a(this.vCx, LinearLayoutManager.bv(paramRecyclerView));
      }
    }
    AppMethodBeat.o(27052);
  }
  
  public final void djT()
  {
    AppMethodBeat.i(27048);
    NoteEditorUI.aa(this.vCx);
    AppMethodBeat.o(27048);
  }
  
  public final void djU()
  {
    AppMethodBeat.i(27049);
    this.vCx.showActionbarLine();
    NoteEditorUI.aa(this.vCx);
    AppMethodBeat.o(27049);
  }
  
  public final void djV()
  {
    AppMethodBeat.i(27050);
    this.vCx.hideActionbarLine();
    AppMethodBeat.o(27050);
  }
  
  public final void djW()
  {
    AppMethodBeat.i(27051);
    NoteEditorUI.ab(this.vCx).mtk = true;
    AppMethodBeat.o(27051);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.a
 * JD-Core Version:    0.7.0.1
 */