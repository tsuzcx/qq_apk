package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.os.Bundle;
import com.tencent.mm.aa.a.b;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.webview.ui.tools.widget.n.a;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

final class g$10$1$1
  implements n.a
{
  g$10$1$1(g.10.1 param1) {}
  
  public final void e(int paramInt, Bundle paramBundle)
  {
    y.i("MicroMsg.MsgHandler", "stev onRevMsg resultCode %d", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    default: 
      y.d("MicroMsg.MsgHandler", "press back button!");
      g.a(this.rzu.rzt.rzi, this.rzu.rzt.rzk, "authorize:fail auth cancel", null);
      this.rzu.rzt.rzo.aib();
    }
    do
    {
      return;
      g localg = this.rzu.rzt.rzi;
      String str = this.rzu.rzt.val$appId;
      i locali = this.rzu.rzt.rzk;
      g.a locala = this.rzu.rzt.rzo;
      Object localObject = (ArrayList)paramBundle.getSerializable("key_scope");
      paramBundle = new LinkedList();
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramBundle.add((String)((Iterator)localObject).next());
      }
      au.Dk().a(new b(str, paramBundle, paramInt, new g.9(localg, locali, locala, paramInt)), 0);
    } while (paramInt != 2);
    g.a(this.rzu.rzt.rzi, this.rzu.rzt.rzk, "authorize:fail auth deny", null);
    this.rzu.rzt.rzo.aib();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.10.1.1
 * JD-Core Version:    0.7.0.1
 */