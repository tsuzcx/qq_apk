package com.tencent.mm.ui.chatting.m;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.LinkedList;

final class c$1
  extends com.tencent.mm.plugin.messenger.a.a
{
  c$1(c paramc, LinkedList paramLinkedList) {}
  
  public final void onClickImp(View paramView)
  {
    AppMethodBeat.i(32744);
    paramView = this.zQM;
    LinkedList localLinkedList = this.qFc;
    if ((paramView.zQJ != null) && (paramView.zQJ.get() != null)) {
      ((a.b)paramView.zQJ.get()).aQ(localLinkedList);
    }
    AppMethodBeat.o(32744);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.m.c.1
 * JD-Core Version:    0.7.0.1
 */