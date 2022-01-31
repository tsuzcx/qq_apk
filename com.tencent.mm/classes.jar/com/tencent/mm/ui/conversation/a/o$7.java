package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMAppMgr;
import java.lang.ref.WeakReference;

final class o$7
  implements View.OnClickListener
{
  o$7(o paramo, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(34718);
    MMAppMgr.a((Context)this.Anv.vUD.get(), this.bHS, new o.7.1(this), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(34717);
        o.7.this.Anv.jIo.setVisibility(8);
        o.7.this.Anv.Anu = true;
        AppMethodBeat.o(34717);
      }
    });
    AppMethodBeat.o(34718);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.o.7
 * JD-Core Version:    0.7.0.1
 */