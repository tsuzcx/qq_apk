package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.mm.plugin.wenote.ui.nativenote.a.b;

final class NoteEditorUI$a
  extends b
{
  NoteEditorUI$a(NoteEditorUI paramNoteEditorUI) {}
  
  public final void c(RecyclerView paramRecyclerView, int paramInt)
  {
    super.c(paramRecyclerView, paramInt);
    if (paramRecyclerView.getLayoutManager() != null)
    {
      paramRecyclerView = ((LinearLayoutManager)NoteEditorUI.N(this.rLT).getLayoutManager()).getChildAt(0);
      if (paramRecyclerView != null)
      {
        NoteEditorUI.b(this.rLT, paramRecyclerView.getTop());
        NoteEditorUI.a(this.rLT, LinearLayoutManager.bl(paramRecyclerView));
      }
    }
  }
  
  public final void cjr()
  {
    NoteEditorUI.aa(this.rLT);
  }
  
  public final void cjs()
  {
    this.rLT.czp();
    NoteEditorUI.aa(this.rLT);
  }
  
  public final void cjt()
  {
    this.rLT.czo();
  }
  
  public final void cju()
  {
    NoteEditorUI.ab(this.rLT).jYR = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.a
 * JD-Core Version:    0.7.0.1
 */