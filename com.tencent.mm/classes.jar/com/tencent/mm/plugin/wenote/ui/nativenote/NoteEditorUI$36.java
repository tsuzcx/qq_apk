package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.model.nativenote.c.e;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.g;
import com.tencent.mm.sdk.platformtools.ak;

final class NoteEditorUI$36
  implements View.OnTouchListener
{
  NoteEditorUI$36(NoteEditorUI paramNoteEditorUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(27047);
    if (paramMotionEvent.getAction() == 0)
    {
      NoteEditorUI.a(this.vCx, paramMotionEvent.getX());
      NoteEditorUI.b(this.vCx, paramMotionEvent.getY());
    }
    float f1;
    float f2;
    if ((paramMotionEvent.getAction() == 1) && (NoteEditorUI.N(this.vCx).x(paramMotionEvent.getX(), paramMotionEvent.getY()) == null))
    {
      f1 = Math.abs(NoteEditorUI.Q(this.vCx) - paramMotionEvent.getX());
      f2 = Math.abs(NoteEditorUI.R(this.vCx) - paramMotionEvent.getY());
      if ((f1 < 30.0F) && (f2 < 30.0F))
      {
        if (NoteEditorUI.b(this.vCx).getVisibility() == 8) {
          break label172;
        }
        if (NoteEditorUI.a(this.vCx) != null) {
          NoteEditorUI.a(this.vCx).vyE.dismiss();
        }
        NoteEditorUI.b(this.vCx).setVisibility(8);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(27047);
      return false;
      label172:
      int i = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din().size();
      paramView = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din().Lj(i - 1);
      if (paramView != null)
      {
        boolean bool = paramView.vwW;
        com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din().diq();
        paramView.vwW = true;
        paramView.vxc = false;
        paramView.vwY = -1;
        NoteEditorUI.S(this.vCx).bR(i - 1);
        this.vCx.h(true, 50L);
        this.vCx.aj(1, 0L);
        if ((NoteEditorUI.J(this.vCx)) && (bool))
        {
          NoteEditorUI.A(this.vCx).postDelayed(new NoteEditorUI.36.1(this), 100L);
          continue;
          if (paramMotionEvent.getAction() == 2)
          {
            f1 = Math.abs(NoteEditorUI.Q(this.vCx) - paramMotionEvent.getX());
            f2 = Math.abs(NoteEditorUI.R(this.vCx) - paramMotionEvent.getY());
            if ((f1 > 120.0F) || (f2 > 120.0F)) {
              if (NoteEditorUI.J(this.vCx))
              {
                if (e.djc().djb() == 1)
                {
                  this.vCx.dic();
                  e.djc().djg();
                }
              }
              else if (!NoteEditorUI.T(this.vCx)) {
                this.vCx.dic();
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.36
 * JD-Core Version:    0.7.0.1
 */