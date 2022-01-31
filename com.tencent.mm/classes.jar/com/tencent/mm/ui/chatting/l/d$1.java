package com.tencent.mm.ui.chatting.l;

import android.view.View;
import java.lang.ref.WeakReference;

final class d$1
  extends com.tencent.mm.plugin.messenger.a.a
{
  d$1(d paramd, a.a parama) {}
  
  public final void onClickImp(View paramView)
  {
    d locald = this.vAq;
    a.a locala = this.vAp;
    if ((locald.vAl != null) && (locald.vAl.get() != null)) {
      ((a.b)locald.vAl.get()).a(paramView, locala);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.l.d.1
 * JD-Core Version:    0.7.0.1
 */