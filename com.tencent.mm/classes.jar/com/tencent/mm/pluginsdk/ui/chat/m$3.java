package com.tencent.mm.pluginsdk.ui.chat;

import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.MMHandler;

final class m$3
  implements RecyclerView.k
{
  m$3(m paramm) {}
  
  public final boolean a(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(245413);
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(245413);
      return false;
      this.YkH.mHandler.sendEmptyMessage(20002);
      continue;
      this.YkH.mHandler.sendEmptyMessageDelayed(20001, 3000L);
    }
  }
  
  public final void aX(boolean paramBoolean) {}
  
  public final void b(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(245417);
    b localb = new b();
    localb.cH(paramRecyclerView);
    localb.cH(paramMotionEvent);
    a.c("com/tencent/mm/pluginsdk/ui/chat/SuggestEmoticonBubble$3", "androidx/recyclerview/widget/RecyclerView$OnItemTouchListener", "onTouchEvent", "(Landroidx/recyclerview/widget/RecyclerView;Landroid/view/MotionEvent;)V", this, localb.aYj());
    a.a(this, "com/tencent/mm/pluginsdk/ui/chat/SuggestEmoticonBubble$3", "androidx/recyclerview/widget/RecyclerView$OnItemTouchListener", "onTouchEvent", "(Landroidx/recyclerview/widget/RecyclerView;Landroid/view/MotionEvent;)V");
    AppMethodBeat.o(245417);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.m.3
 * JD-Core Version:    0.7.0.1
 */