package com.tencent.mm.ui.matrix.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.l;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class JsonRecyclerView$1
  implements RecyclerView.l
{
  JsonRecyclerView$1(JsonRecyclerView paramJsonRecyclerView) {}
  
  public final boolean a(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(194802);
    switch (paramMotionEvent.getAction() & paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(194802);
      return false;
      this.KBY.mode = 1;
      continue;
      this.KBY.mode = 0;
      continue;
      paramRecyclerView = this.KBY;
      paramRecyclerView.mode -= 1;
      continue;
      this.KBY.KBW = JsonRecyclerView.af(paramMotionEvent);
      paramRecyclerView = this.KBY;
      paramRecyclerView.mode += 1;
      continue;
      if (this.KBY.mode >= 2)
      {
        float f = JsonRecyclerView.af(paramMotionEvent);
        if (Math.abs(f - this.KBY.KBW) > 0.5F)
        {
          JsonRecyclerView.a(this.KBY, f / this.KBY.KBW);
          this.KBY.KBW = f;
        }
      }
    }
  }
  
  public final void ai(boolean paramBoolean) {}
  
  public final void b(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(194803);
    b localb = new b();
    localb.bd(paramRecyclerView);
    localb.bd(paramMotionEvent);
    a.b("com/tencent/mm/ui/matrix/recyclerview/JsonRecyclerView$1", "android/support/v7/widget/RecyclerView$OnItemTouchListener", "onTouchEvent", "(Landroid/support/v7/widget/RecyclerView;Landroid/view/MotionEvent;)V", this, localb.ahq());
    a.a(this, "com/tencent/mm/ui/matrix/recyclerview/JsonRecyclerView$1", "android/support/v7/widget/RecyclerView$OnItemTouchListener", "onTouchEvent", "(Landroid/support/v7/widget/RecyclerView;Landroid/view/MotionEvent;)V");
    AppMethodBeat.o(194803);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.matrix.recyclerview.JsonRecyclerView.1
 * JD-Core Version:    0.7.0.1
 */