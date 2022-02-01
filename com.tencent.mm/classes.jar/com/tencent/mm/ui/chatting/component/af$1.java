package com.tencent.mm.ui.chatting.component;

import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;

final class af$1
  extends RecyclerView.l
{
  af$1(af paramaf) {}
  
  public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(255849);
    b localb = new b();
    localb.cH(paramRecyclerView);
    localb.sc(paramInt);
    a.c("com/tencent/mm/ui/chatting/component/GroupTodoComponent$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    Log.d("MicroMsg.roomTodo.GroupTodoComponent", "onScrollStateChanged newState:%s canScrollHorizontally(-1):%s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramRecyclerView.canScrollHorizontally(-1)) });
    if ((paramInt == 0) && (!paramRecyclerView.canScrollHorizontally(-1)))
    {
      af.d(this.aesW).setVisibility(8);
      af.e(this.aesW).setVisibility(8);
    }
    for (;;)
    {
      a.a(this, "com/tencent/mm/ui/chatting/component/GroupTodoComponent$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
      AppMethodBeat.o(255849);
      return;
      af.d(this.aesW).setVisibility(0);
      af.e(this.aesW).setVisibility(0);
    }
  }
  
  public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(255853);
    b localb = new b();
    localb.cH(paramRecyclerView);
    localb.sc(paramInt1);
    localb.sc(paramInt2);
    a.c("com/tencent/mm/ui/chatting/component/GroupTodoComponent$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
    a.a(this, "com/tencent/mm/ui/chatting/component/GroupTodoComponent$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
    AppMethodBeat.o(255853);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.component.af.1
 * JD-Core Version:    0.7.0.1
 */