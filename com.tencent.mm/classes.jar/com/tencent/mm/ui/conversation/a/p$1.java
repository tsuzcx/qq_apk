package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import java.lang.ref.WeakReference;

final class p$1
  implements View.OnClickListener
{
  p$1(p paramp, Intent paramIntent) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(38852);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/ui/conversation/banner/OtherOnlineBanner$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    d.b((Context)this.Kzk.EXg.get(), "webwx", ".ui.WebWXLogoutUI", this.val$intent);
    a.a(this, "com/tencent/mm/ui/conversation/banner/OtherOnlineBanner$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(38852);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.p.1
 * JD-Core Version:    0.7.0.1
 */