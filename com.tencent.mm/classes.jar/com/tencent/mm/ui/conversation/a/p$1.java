package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import java.lang.ref.WeakReference;

final class p$1
  implements View.OnClickListener
{
  p$1(p paramp, Intent paramIntent) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(34727);
    d.b((Context)this.Anz.vUD.get(), "webwx", ".ui.WebWXLogoutUI", this.val$intent);
    AppMethodBeat.o(34727);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.p.1
 * JD-Core Version:    0.7.0.1
 */