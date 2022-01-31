package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.tencent.mm.plugin.wenote.model.nativenote.c.e;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.g;
import com.tencent.mm.sdk.platformtools.ah;

final class NoteEditorUI$36
  implements View.OnTouchListener
{
  NoteEditorUI$36(NoteEditorUI paramNoteEditorUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      NoteEditorUI.a(this.rLT, paramMotionEvent.getX());
      NoteEditorUI.b(this.rLT, paramMotionEvent.getY());
    }
    float f1;
    float f2;
    if ((paramMotionEvent.getAction() == 1) && (NoteEditorUI.N(this.rLT).y(paramMotionEvent.getX(), paramMotionEvent.getY()) == null))
    {
      f1 = Math.abs(NoteEditorUI.Q(this.rLT) - paramMotionEvent.getX());
      f2 = Math.abs(NoteEditorUI.R(this.rLT) - paramMotionEvent.getY());
      if ((f1 < 30.0F) && (f2 < 30.0F))
      {
        if (NoteEditorUI.b(this.rLT).getVisibility() == 8) {
          break label160;
        }
        if (NoteEditorUI.a(this.rLT) != null) {
          NoteEditorUI.a(this.rLT).rHY.dismiss();
        }
        NoteEditorUI.b(this.rLT).setVisibility(8);
      }
    }
    label160:
    do
    {
      do
      {
        do
        {
          do
          {
            boolean bool;
            do
            {
              int i;
              do
              {
                return false;
                i = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX().size();
                paramView = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX().Dq(i - 1);
              } while (paramView == null);
              bool = paramView.rGn;
              com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX().cia();
              paramView.rGn = true;
              paramView.rGt = false;
              paramView.rGp = -1;
              NoteEditorUI.S(this.rLT).bL(i - 1);
              this.rLT.f(true, 50L);
              this.rLT.U(1, 0L);
            } while ((!NoteEditorUI.J(this.rLT)) || (!bool));
            NoteEditorUI.A(this.rLT).postDelayed(new NoteEditorUI.36.1(this), 100L);
            return false;
          } while (paramMotionEvent.getAction() != 2);
          f1 = Math.abs(NoteEditorUI.Q(this.rLT) - paramMotionEvent.getX());
          f2 = Math.abs(NoteEditorUI.R(this.rLT) - paramMotionEvent.getY());
        } while ((f1 <= 120.0F) && (f2 <= 120.0F));
        if (!NoteEditorUI.J(this.rLT)) {
          break;
        }
      } while (e.ciJ().ciI() != 1);
      this.rLT.chM();
      e.ciJ().ciN();
      return false;
    } while (NoteEditorUI.T(this.rLT));
    this.rLT.chM();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.36
 * JD-Core Version:    0.7.0.1
 */