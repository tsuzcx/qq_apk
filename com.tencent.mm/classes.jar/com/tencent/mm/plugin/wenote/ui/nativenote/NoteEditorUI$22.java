package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.content.Context;
import android.support.v4.view.t;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.c;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.g;

final class NoteEditorUI$22
  implements Runnable
{
  NoteEditorUI$22(NoteEditorUI paramNoteEditorUI, Context paramContext) {}
  
  public final void run()
  {
    AppMethodBeat.i(27018);
    int i = c.din().size();
    int j = NoteEditorUI.N(this.vCx).getChildCount();
    Object localObject;
    if (i == j)
    {
      float f1 = 0.0F;
      i = j - 1;
      if (i >= 0)
      {
        localObject = NoteEditorUI.N(this.vCx).getChildAt(i);
        float f2 = t.Y((View)localObject);
        if (f1 > ((View)localObject).getBottom() + f2) {}
        for (;;)
        {
          i -= 1;
          break;
          f1 = ((View)localObject).getBottom() + f2;
        }
      }
      if ((f1 < com.tencent.mm.compatible.util.j.dh(this.val$context)[1]) && (f1 > 0.0F))
      {
        localObject = (RelativeLayout.LayoutParams)NoteEditorUI.b(this.vCx).getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).height = ((int)f1);
        NoteEditorUI.b(this.vCx).setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
    NoteEditorUI.b(this.vCx).setVisibility(0);
    if (NoteEditorUI.a(this.vCx) != null)
    {
      localObject = NoteEditorUI.a(this.vCx);
      int[] arrayOfInt = new int[2];
      int[] tmp185_183 = arrayOfInt;
      tmp185_183[0] = 0;
      int[] tmp189_185 = tmp185_183;
      tmp189_185[1] = 0;
      tmp189_185;
      ((g)localObject).mParentView.getLocationOnScreen(arrayOfInt);
      ((g)localObject).vyE.showAtLocation(((g)localObject).mParentView, 49, 0, arrayOfInt[1] + 50);
    }
    AppMethodBeat.o(27018);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.22
 * JD-Core Version:    0.7.0.1
 */