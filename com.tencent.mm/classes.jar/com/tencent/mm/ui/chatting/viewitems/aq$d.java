package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class aq$d
  implements View.OnClickListener
{
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(255486);
    Object localObject = new b();
    ((b)localObject).cH(paramView);
    a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$LineDataClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
    localObject = (bz)paramView.getTag();
    if (localObject == null)
    {
      a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$LineDataClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(255486);
      return;
    }
    if ((localObject instanceof aq.f))
    {
      while ((paramView != null) && (paramView.getParent() != null) && (paramView.getId() != R.h.fyB)) {
        paramView = (View)paramView.getParent();
      }
      if ((paramView != null) && (paramView.getId() == R.h.fyB)) {
        paramView.performClick();
      }
    }
    for (;;)
    {
      a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$LineDataClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(255486);
      return;
      if ((localObject instanceof aq.b))
      {
        while ((paramView != null) && (paramView.getParent() != null) && (paramView.getId() != R.h.fyD)) {
          paramView = (View)paramView.getParent();
        }
        if ((paramView != null) && (paramView.getId() == R.h.fyD)) {
          paramView.performClick();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.aq.d
 * JD-Core Version:    0.7.0.1
 */