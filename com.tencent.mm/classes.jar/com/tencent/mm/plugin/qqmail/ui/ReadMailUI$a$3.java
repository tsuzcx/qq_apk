package com.tencent.mm.plugin.qqmail.ui;

import android.content.Intent;
import android.widget.ImageView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.qqmail.b.v;
import com.tencent.mm.plugin.qqmail.stub.QQMailStubProxyUI;
import com.tencent.mm.plugin.qqmail.stub.ReadMailProxy;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.ui.widget.MMWebView;

final class ReadMailUI$a$3
  implements Runnable
{
  ReadMailUI$a$3(ReadMailUI.a parama, int paramInt, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(68441);
    if (this.pPh.pOX.isFinishing())
    {
      AppMethodBeat.o(68441);
      return;
    }
    switch (this.pPh.pPf)
    {
    default: 
      ab.e("MicroMsg.ReadMailUI", "onError invalid userData = %d", new Object[] { Integer.valueOf(this.pPh.pPf) });
      AppMethodBeat.o(68441);
      return;
    case 1: 
      ReadMailUI.j(this.pPh.pOX).setVisibility(0);
      if (this.val$errCode == -5)
      {
        Intent localIntent1 = new Intent(this.pPh.pOX, QQMailStubProxyUI.class);
        localIntent1.addFlags(268435456);
        this.pPh.pOX.startActivityForResult(localIntent1, 1);
        AppMethodBeat.o(68441);
        return;
      }
      if (this.val$errCode == -7) {
        ReadMailUI.j(this.pPh.pOX).setVisibility(8);
      }
      try
      {
        new ReadMailProxy(ReadMailUI.l(this.pPh.pOX), null).REMOTE_CALL("replaceMsgContent", new Object[] { Long.valueOf(ReadMailUI.k(this.pPh.pOX)), this.hZi });
        if ((this.val$errCode == -10005) && (!at.isConnected(this.pPh.pOX))) {
          Toast.makeText(this.pPh.pOX, this.pPh.pOX.getString(2131300044, new Object[] { Integer.valueOf(2), Integer.valueOf(this.val$errCode) }), 1).show();
        }
        ReadMailUI.g(this.pPh.pOX).loadDataWithBaseURL(v.cdK(), this.hZi + "(" + this.val$errCode + ")", "text/html", "utf-8", null);
        AppMethodBeat.o(68441);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ab.w("MicroMsg.ReadMailUI", "replaceMsgContent fail, ex = %s", new Object[] { localException.getMessage() });
        }
      }
    }
    if (this.val$errCode == -5)
    {
      Intent localIntent2 = new Intent(this.pPh.pOX, QQMailStubProxyUI.class);
      localIntent2.addFlags(268435456);
      this.pPh.pOX.startActivityForResult(localIntent2, 2);
      AppMethodBeat.o(68441);
      return;
    }
    Toast.makeText(this.pPh.pOX, this.hZi, 1).show();
    AppMethodBeat.o(68441);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ReadMailUI.a.3
 * JD-Core Version:    0.7.0.1
 */