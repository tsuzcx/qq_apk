package com.tencent.mm.ui.chatting.m;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.messenger.a.a;
import java.lang.ref.WeakReference;

final class b$1
  extends a
{
  b$1(b paramb, WeakReference paramWeakReference, Bundle paramBundle, String paramString) {}
  
  public final void onClickImp(View paramView)
  {
    AppMethodBeat.i(32741);
    if ((this.eej != null) && (this.eej.get() != null))
    {
      paramView = this.val$params.getString("conv_talker_username", null);
      if (t.lA(paramView))
      {
        b.K((Context)this.eej.get(), this.fwC, paramView);
        AppMethodBeat.o(32741);
        return;
      }
      b.K((Context)this.eej.get(), this.fwC, null);
    }
    AppMethodBeat.o(32741);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.m.b.1
 * JD-Core Version:    0.7.0.1
 */