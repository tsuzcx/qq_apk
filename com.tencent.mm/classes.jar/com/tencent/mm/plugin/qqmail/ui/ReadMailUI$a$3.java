package com.tencent.mm.plugin.qqmail.ui;

import android.content.Intent;
import android.widget.ImageView;
import android.widget.Toast;
import com.tencent.mm.plugin.qqmail.b.j;
import com.tencent.mm.plugin.qqmail.b.v;
import com.tencent.mm.plugin.qqmail.stub.QQMailStubProxyUI;
import com.tencent.mm.plugin.qqmail.stub.ReadMailProxy;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.MMWebView;

final class ReadMailUI$a$3
  implements Runnable
{
  ReadMailUI$a$3(ReadMailUI.a parama, int paramInt, String paramString) {}
  
  public final void run()
  {
    if (this.njU.njK.isFinishing()) {
      return;
    }
    switch (this.njU.njS)
    {
    default: 
      y.e("MicroMsg.ReadMailUI", "onError invalid userData = %d", new Object[] { Integer.valueOf(this.njU.njS) });
      return;
    case 1: 
      ReadMailUI.j(this.njU.njK).setVisibility(0);
      if (this.bEg == -5)
      {
        Intent localIntent1 = new Intent(this.njU.njK, QQMailStubProxyUI.class);
        localIntent1.addFlags(268435456);
        this.njU.njK.startActivityForResult(localIntent1, 1);
        return;
      }
      if (this.bEg == -7) {
        ReadMailUI.j(this.njU.njK).setVisibility(8);
      }
      try
      {
        new ReadMailProxy(ReadMailUI.l(this.njU.njK), null).REMOTE_CALL("replaceMsgContent", new Object[] { Long.valueOf(ReadMailUI.k(this.njU.njK)), this.gBn });
        if ((this.bEg == -10005) && (!aq.isConnected(this.njU.njK))) {
          Toast.makeText(this.njU.njK, this.njU.njK.getString(b.j.fmt_iap_err, new Object[] { Integer.valueOf(2), Integer.valueOf(this.bEg) }), 1).show();
        }
        ReadMailUI.g(this.njU.njK).loadDataWithBaseURL(v.btz(), this.gBn + "(" + this.bEg + ")", "text/html", "utf-8", null);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          y.w("MicroMsg.ReadMailUI", "replaceMsgContent fail, ex = %s", new Object[] { localException.getMessage() });
        }
      }
    }
    if (this.bEg == -5)
    {
      Intent localIntent2 = new Intent(this.njU.njK, QQMailStubProxyUI.class);
      localIntent2.addFlags(268435456);
      this.njU.njK.startActivityForResult(localIntent2, 2);
      return;
    }
    Toast.makeText(this.njU.njK, this.gBn, 1).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ReadMailUI.a.3
 * JD-Core Version:    0.7.0.1
 */