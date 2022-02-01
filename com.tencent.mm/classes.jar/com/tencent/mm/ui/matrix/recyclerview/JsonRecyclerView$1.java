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
    AppMethodBeat.i(188204);
    switch (paramMotionEvent.getAction() & paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(188204);
      return false;
      this.KYs.mode = 1;
      continue;
      this.KYs.mode = 0;
      continue;
      paramRecyclerView = this.KYs;
      paramRecyclerView.mode -= 1;
      continue;
      this.KYs.KYq = JsonRecyclerView.ad(paramMotionEvent);
      paramRecyclerView = this.KYs;
      paramRecyclerView.mode += 1;
      continue;
      if (this.KYs.mode >= 2)
      {
        float f = JsonRecyclerView.ad(paramMotionEvent);
        if (Math.abs(f - this.KYs.KYq) > 0.5F)
        {
          JsonRecyclerView.a(this.KYs, f / this.KYs.KYq);
          this.KYs.KYq = f;
        }
      }
    }
  }
  
  public final void ai(boolean paramBoolean) {}
  
  public final void b(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(188205);
    b localb = new b();
    localb.bd(paramRecyclerView);
    localb.bd(paramMotionEvent);
    a.b("com/tencent/mm/ui/matrix/recyclerview/JsonRecyclerView$1", "android/support/v7/widget/RecyclerView$OnItemTouchListener", "onTouchEvent", "(Landroid/support/v7/widget/RecyclerView;Landroid/view/MotionEvent;)V", this, localb.ahF());
    a.a(this, "com/tencent/mm/ui/matrix/recyclerview/JsonRecyclerView$1", "android/support/v7/widget/RecyclerView$OnItemTouchListener", "onTouchEvent", "(Landroid/support/v7/widget/RecyclerView;Landroid/view/MotionEvent;)V");
    AppMethodBeat.o(188205);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.matrix.recyclerview.JsonRecyclerView.1
 * JD-Core Version:    0.7.0.1
 */