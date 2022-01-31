package com.tencent.mm.ui.chatting;

import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.chatting.a.a;
import com.tencent.mm.ui.chatting.c.l;
import com.tencent.mm.ui.chatting.view.MMChattingListView;

final class ChattingUIFragment$3
  implements AbsListView.OnScrollListener
{
  ChattingUIFragment$3(ChattingUIFragment paramChattingUIFragment) {}
  
  /* Error */
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 30832
    //   5: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 17	com/tencent/mm/ui/chatting/ChattingUIFragment$3:zBB	Lcom/tencent/mm/ui/chatting/ChattingUIFragment;
    //   12: getfield 34	com/tencent/mm/ui/chatting/BaseChattingUIFragment:zwN	Lcom/tencent/mm/ui/chatting/c/l;
    //   15: aload_1
    //   16: iload_2
    //   17: iload_3
    //   18: iload 4
    //   20: invokevirtual 38	com/tencent/mm/ui/chatting/c/l:onScroll	(Landroid/widget/AbsListView;III)V
    //   23: aload_0
    //   24: getfield 17	com/tencent/mm/ui/chatting/ChattingUIFragment$3:zBB	Lcom/tencent/mm/ui/chatting/ChattingUIFragment;
    //   27: invokestatic 41	com/tencent/mm/ui/chatting/ChattingUIFragment:i	(Lcom/tencent/mm/ui/chatting/ChattingUIFragment;)Z
    //   30: ifeq +37 -> 67
    //   33: aload_0
    //   34: getfield 17	com/tencent/mm/ui/chatting/ChattingUIFragment$3:zBB	Lcom/tencent/mm/ui/chatting/ChattingUIFragment;
    //   37: invokestatic 45	com/tencent/mm/ui/chatting/ChattingUIFragment:b	(Lcom/tencent/mm/ui/chatting/ChattingUIFragment;)Landroid/widget/ListView;
    //   40: invokevirtual 51	android/widget/ListView:getLastVisiblePosition	()I
    //   43: iload 4
    //   45: iconst_1
    //   46: isub
    //   47: if_icmpeq +12 -> 59
    //   50: sipush 30832
    //   53: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   56: aload_0
    //   57: monitorexit
    //   58: return
    //   59: aload_0
    //   60: getfield 17	com/tencent/mm/ui/chatting/ChattingUIFragment$3:zBB	Lcom/tencent/mm/ui/chatting/ChattingUIFragment;
    //   63: invokestatic 57	com/tencent/mm/ui/chatting/ChattingUIFragment:j	(Lcom/tencent/mm/ui/chatting/ChattingUIFragment;)Z
    //   66: pop
    //   67: sipush 30832
    //   70: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   73: goto -17 -> 56
    //   76: astore_1
    //   77: aload_0
    //   78: monitorexit
    //   79: aload_1
    //   80: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	81	0	this	3
    //   0	81	1	paramAbsListView	AbsListView
    //   0	81	2	paramInt1	int
    //   0	81	3	paramInt2	int
    //   0	81	4	paramInt3	int
    // Exception table:
    //   from	to	target	type
    //   2	56	76	finally
    //   59	67	76	finally
    //   67	73	76	finally
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(30831);
    this.zBB.zwN.onScrollStateChanged(paramAbsListView, paramInt);
    ChattingUIFragment.a(this.zBB, paramInt);
    if (paramInt == 0)
    {
      ab.d("MicroMsg.ChattingUIFragment", "[onScrollStateChanged] [%s:%s]", new Object[] { Integer.valueOf(ChattingUIFragment.b(this.zBB).getFirstVisiblePosition()), Integer.valueOf(ChattingUIFragment.b(this.zBB).getLastVisiblePosition()) });
      if (ChattingUIFragment.b(this.zBB).getFirstVisiblePosition() != 0) {
        break label199;
      }
      paramAbsListView = ChattingUIFragment.b(this.zBB).getChildAt(0);
      if (paramAbsListView != null)
      {
        if (paramAbsListView.getTop() != 0) {
          break label165;
        }
        ab.i("MicroMsg.ChattingUIFragment", "[onScrollStateChanged] auto load top more!");
        ChattingUIFragment.a(this.zBB).qD(true);
      }
    }
    for (;;)
    {
      this.zBB.zBq.dI(ChattingUIFragment.b(this.zBB).getFirstVisiblePosition(), ChattingUIFragment.b(this.zBB).getLastVisiblePosition());
      AppMethodBeat.o(30831);
      return;
      label165:
      if (paramAbsListView.getTop() < 0)
      {
        ab.w("MicroMsg.ChattingUIFragment", "[onScrollStateChanged] exception auto load top more wit reset adapter!");
        ChattingUIFragment.a(this.zBB).setAdapter(this.zBB.zBq);
        continue;
        label199:
        if (ChattingUIFragment.b(this.zBB).getLastVisiblePosition() == ChattingUIFragment.b(this.zBB).getCount() - 1)
        {
          paramAbsListView = ChattingUIFragment.b(this.zBB).getChildAt(ChattingUIFragment.b(this.zBB).getChildCount() - 1);
          if ((paramAbsListView != null) && (ChattingUIFragment.b(this.zBB).getBottom() - ChattingUIFragment.a(this.zBB).getBottomHeight() >= paramAbsListView.getBottom()))
          {
            ab.i("MicroMsg.ChattingUIFragment", "[onScrollStateChanged] auto load bottom more!");
            ChattingUIFragment.a(this.zBB).qE(true);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChattingUIFragment.3
 * JD-Core Version:    0.7.0.1
 */