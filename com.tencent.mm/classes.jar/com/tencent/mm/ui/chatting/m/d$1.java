package com.tencent.mm.ui.chatting.m;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

final class d$1
  extends com.tencent.mm.plugin.messenger.a.a
{
  d$1(d paramd, a.a parama) {}
  
  public final void onClickImp(View paramView)
  {
    AppMethodBeat.i(32746);
    d locald = this.zQO;
    a.a locala = this.zQN;
    if ((locald.zQJ != null) && (locald.zQJ.get() != null)) {
      ((a.b)locald.zQJ.get()).a(paramView, locala);
    }
    AppMethodBeat.o(32746);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.m.d.1
 * JD-Core Version:    0.7.0.1
 */