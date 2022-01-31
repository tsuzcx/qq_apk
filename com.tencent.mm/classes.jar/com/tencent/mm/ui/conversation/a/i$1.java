package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.forcenotify.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.ref.WeakReference;

final class i$1
  implements View.OnClickListener
{
  i$1(i parami) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(34658);
    ab.i("MicroMsg.ForceNotifyBanner", "[onClick]");
    paramView = (b)g.E(b.class);
    if (paramView != null) {
      paramView.dW((Context)this.AmI.vUD.get());
    }
    AppMethodBeat.o(34658);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.i.1
 * JD-Core Version:    0.7.0.1
 */