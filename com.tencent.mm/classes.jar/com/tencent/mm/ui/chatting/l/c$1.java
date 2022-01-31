package com.tencent.mm.ui.chatting.l;

import android.view.View;
import java.lang.ref.WeakReference;
import java.util.LinkedList;

final class c$1
  extends com.tencent.mm.plugin.messenger.a.a
{
  c$1(c paramc, LinkedList paramLinkedList) {}
  
  public final void onClickImp(View paramView)
  {
    paramView = this.vAo;
    LinkedList localLinkedList = this.nRf;
    if ((paramView.vAl != null) && (paramView.vAl.get() != null)) {
      ((a.b)paramView.vAl.get()).aG(localLinkedList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.l.c.1
 * JD-Core Version:    0.7.0.1
 */