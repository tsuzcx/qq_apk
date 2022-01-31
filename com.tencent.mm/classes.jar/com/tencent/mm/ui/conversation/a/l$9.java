package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.model.be;
import java.lang.ref.WeakReference;

final class l$9
  implements View.OnClickListener
{
  l$9(l paraml, int paramInt1, int paramInt2) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(34684);
    be.aaG().cs(this.bHS, this.yWR);
    d.b((Context)this.AmR.vUD.get(), "subapp", ".ui.autoadd.AutoAddFriendUI", new Intent());
    AppMethodBeat.o(34684);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.l.9
 * JD-Core Version:    0.7.0.1
 */