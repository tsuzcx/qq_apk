package com.tencent.mm.plugin.story.ui.view.editor.item;

import a.f.b.j;
import a.l;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.g.i;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/story/ui/view/editor/item/EditorItemContainer$itemStateResolve$1", "Lcom/tencent/mm/plugin/story/ui/view/editor/item/EditorItemContainer$ItemStateResolve;", "handleItemTouch", "", "itemView", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "plugin-story_release"})
public final class EditorItemContainer$d
  implements EditorItemContainer.b
{
  public final void e(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(110634);
    j.q(paramView, "itemView");
    j.q(paramMotionEvent, "event");
    if (EditorItemContainer.c(this.sQT)) {
      EditorItemContainer.d(this.sQT);
    }
    switch (paramMotionEvent.getActionMasked())
    {
    default: 
    case 0: 
    case 2: 
      do
      {
        AppMethodBeat.o(110634);
        return;
        this.sQT.removeCallbacks(EditorItemContainer.e(this.sQT));
        paramMotionEvent = ((c)paramView).getContentBoundary();
        float f1 = (paramMotionEvent[0] + paramMotionEvent[2]) / 2.0F;
        float f2 = paramMotionEvent[1];
        paramView.setTag(new Float[] { Float.valueOf(f1), Float.valueOf((paramMotionEvent[3] + f2) / 2.0F) });
        if (EditorItemContainer.el(paramView))
        {
          this.sQT.s(paramView, false);
          AppMethodBeat.o(110634);
          return;
        }
        this.sQT.s(paramView, true);
        AppMethodBeat.o(110634);
        return;
        if (!EditorItemContainer.em(paramView)) {
          EditorItemContainer.a(this.sQT, paramView);
        }
      } while (EditorItemContainer.en(paramView));
      EditorItemContainer.a(this.sQT, paramView, paramMotionEvent);
      EditorItemContainer.a(this.sQT, true);
      AppMethodBeat.o(110634);
      return;
    }
    if ((paramView instanceof b))
    {
      paramMotionEvent = i.sFa;
      i.FR(7);
    }
    if ((paramView instanceof g))
    {
      paramMotionEvent = i.sFa;
      i.FR(9);
    }
    if ((paramView instanceof f))
    {
      paramMotionEvent = i.sFa;
      i.FR(11);
    }
    if (EditorItemContainer.f(this.sQT) != null) {
      this.sQT.post((Runnable)new EditorItemContainer.d.a(this, paramView));
    }
    for (;;)
    {
      EditorItemContainer.a(this.sQT, false);
      EditorItemContainer.i(this.sQT);
      EditorItemContainer.j(this.sQT);
      EditorItemContainer.k(this.sQT);
      EditorItemContainer.l(this.sQT);
      break;
      if (EditorItemContainer.a(this.sQT) != null) {
        this.sQT.postDelayed(EditorItemContainer.e(this.sQT), 1500L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.editor.item.EditorItemContainer.d
 * JD-Core Version:    0.7.0.1
 */