package com.tencent.mm.plugin.qqmail.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.qqmail.stub.ReadMailProxy;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;

final class ReadMailUI$7
  implements View.OnClickListener
{
  ReadMailUI$7(ReadMailUI paramReadMailUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(68426);
    switch (ReadMailUI.w(this.pOX))
    {
    }
    for (;;)
    {
      AppMethodBeat.o(68426);
      return;
      ReadMailUI.a(this.pOX, 2);
      if ((!bo.isNullOrNil(ReadMailUI.x(this.pOX))) && (!bo.isNullOrNil(ReadMailUI.y(this.pOX))))
      {
        ReadMailUI.z(this.pOX);
        AppMethodBeat.o(68426);
        return;
      }
      ReadMailUI.A(this.pOX);
      AppMethodBeat.o(68426);
      return;
      ReadMailUI.a(this.pOX, 1);
      int i = ((Integer)new ReadMailProxy(ReadMailUI.l(this.pOX), null).REMOTE_CALL("removeDownloadQQMailAppTask", new Object[] { Long.valueOf(ReadMailUI.B(this.pOX)) })).intValue();
      if (i == -1)
      {
        ab.e("MicroMsg.ReadMailUI", "cancel_download_task:fail_apilevel_too_low downloadId = %d", new Object[] { Long.valueOf(ReadMailUI.B(this.pOX)) });
        AppMethodBeat.o(68426);
        return;
      }
      if (i <= 0)
      {
        ab.e("MicroMsg.ReadMailUI", "cancel_download_task:fail downloadId = %d", new Object[] { Long.valueOf(ReadMailUI.B(this.pOX)) });
        AppMethodBeat.o(68426);
        return;
      }
      ab.i("MicroMsg.ReadMailUI", "cancel_download_task:ok downloadId = %d", new Object[] { Long.valueOf(ReadMailUI.B(this.pOX)) });
      ReadMailUI.C(this.pOX).stopTimer();
      ReadMailUI.b(this.pOX, 0);
      ReadMailUI.D(this.pOX);
      ReadMailUI.p(this.pOX);
      AppMethodBeat.o(68426);
      return;
      ReadMailUI.a(this.pOX, 3);
      ReadMailUI.E(this.pOX);
      AppMethodBeat.o(68426);
      return;
      ReadMailUI.a(this.pOX, 4);
      ReadMailUI.F(this.pOX);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ReadMailUI.7
 * JD-Core Version:    0.7.0.1
 */