package com.tencent.mm.ui.chatting.d;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Util;

final class q$1
  implements View.OnClickListener
{
  q$1(q paramq, boolean paramBoolean, Context paramContext) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(233089);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/ui/chatting/component/ChattingServiceNotifyComponent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    if (this.PoO) {
      q.a(this.PoP, this.val$context);
    }
    for (;;)
    {
      h.CyF.a(21825, new Object[] { Integer.valueOf(6), q.a(this.PoP), Long.valueOf(Util.nowSecond()), null, null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
      a.a(this, "com/tencent/mm/ui/chatting/component/ChattingServiceNotifyComponent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(233089);
      return;
      q.b(this.PoP, this.val$context);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.q.1
 * JD-Core Version:    0.7.0.1
 */