package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.be;
import java.lang.ref.WeakReference;

final class l$3
  implements View.OnClickListener
{
  l$3(l paraml, int paramInt1, int paramInt2) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(34678);
    be.aaG().cs(this.bHS, this.yWR);
    l.D((Context)this.AmR.vUD.get(), false);
    AppMethodBeat.o(34678);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.l.3
 * JD-Core Version:    0.7.0.1
 */