package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.ui.nativenote.adapter.a;

final class NoteEditorUI$a
  extends a
{
  NoteEditorUI$a(NoteEditorUI paramNoteEditorUI) {}
  
  public final void cRA()
  {
    AppMethodBeat.i(30744);
    NoteEditorUI.af(this.QJv);
    AppMethodBeat.o(30744);
  }
  
  public final void cRB()
  {
    AppMethodBeat.i(30745);
    this.QJv.showActionbarLine();
    NoteEditorUI.af(this.QJv);
    AppMethodBeat.o(30745);
  }
  
  public final void cRC()
  {
    AppMethodBeat.i(30746);
    this.QJv.hideActionbarLine();
    AppMethodBeat.o(30746);
  }
  
  public final void heb()
  {
    AppMethodBeat.i(30747);
    NoteEditorUI.ag(this.QJv).wGz = true;
    NoteEditorUI.ah(this.QJv);
    AppMethodBeat.o(30747);
  }
  
  public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(271461);
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    if (paramRecyclerView.getLayoutManager() != null)
    {
      paramRecyclerView = (LinearLayoutManager)NoteEditorUI.R(this.QJv).getLayoutManager();
      View localView = paramRecyclerView.getChildAt(0);
      if (localView != null)
      {
        NoteEditorUI.b(this.QJv, localView.getTop());
        NoteEditorUI.a(this.QJv, paramRecyclerView.getPosition(localView));
      }
    }
    AppMethodBeat.o(271461);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.a
 * JD-Core Version:    0.7.0.1
 */