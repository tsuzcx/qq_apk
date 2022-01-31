package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.content.Context;
import android.support.v4.view.q;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.c;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.g;

final class NoteEditorUI$22
  implements Runnable
{
  NoteEditorUI$22(NoteEditorUI paramNoteEditorUI, Context paramContext) {}
  
  public final void run()
  {
    int i = c.chX().size();
    int j = NoteEditorUI.N(this.rLT).getChildCount();
    Object localObject;
    if (i == j)
    {
      float f1 = 0.0F;
      i = j - 1;
      if (i >= 0)
      {
        localObject = NoteEditorUI.N(this.rLT).getChildAt(i);
        float f2 = q.V((View)localObject);
        if (f1 > ((View)localObject).getBottom() + f2) {}
        for (;;)
        {
          i -= 1;
          break;
          f1 = ((View)localObject).getBottom() + f2;
        }
      }
      if ((f1 < com.tencent.mm.compatible.util.j.cY(this.val$context)[1]) && (f1 > 0.0F))
      {
        localObject = (RelativeLayout.LayoutParams)NoteEditorUI.b(this.rLT).getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).height = ((int)f1);
        NoteEditorUI.b(this.rLT).setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
    NoteEditorUI.b(this.rLT).setVisibility(0);
    if (NoteEditorUI.a(this.rLT) != null)
    {
      localObject = NoteEditorUI.a(this.rLT);
      int[] arrayOfInt = new int[2];
      int[] tmp179_177 = arrayOfInt;
      tmp179_177[0] = 0;
      int[] tmp183_179 = tmp179_177;
      tmp183_179[1] = 0;
      tmp183_179;
      ((g)localObject).mParentView.getLocationOnScreen(arrayOfInt);
      ((g)localObject).rHY.showAtLocation(((g)localObject).mParentView, 49, 0, arrayOfInt[1] + 50);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.22
 * JD-Core Version:    0.7.0.1
 */