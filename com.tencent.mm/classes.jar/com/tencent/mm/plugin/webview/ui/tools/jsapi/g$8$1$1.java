package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.os.Bundle;
import com.tencent.mm.aa.a.d;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.webview.ui.tools.widget.n.a;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

final class g$8$1$1
  implements n.a
{
  g$8$1$1(g.8.1 param1) {}
  
  public final void e(int paramInt, Bundle paramBundle)
  {
    y.i("MicroMsg.MsgHandler", "onRevMsg resultCode %d", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    default: 
      y.i("MicroMsg.MsgHandler", "press back button!");
      g.a(this.rzr.rzq.rzi, this.rzr.rzq.rzk, "login:fail auth cancel", null);
      this.rzr.rzq.rzo.aib();
    }
    do
    {
      return;
      g localg = this.rzr.rzq.rzi;
      String str1 = this.rzr.rzq.val$appId;
      String str2 = this.rzr.rdH;
      i locali = this.rzr.rzq.rzk;
      g.a locala = this.rzr.rzq.rzo;
      Object localObject = (ArrayList)paramBundle.getSerializable("key_scope");
      paramBundle = new LinkedList();
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramBundle.add((String)((Iterator)localObject).next());
      }
      au.Dk().a(new d(str1, paramBundle, str2, paramInt, new g.7(localg, locali, locala, paramInt)), 0);
    } while (paramInt != 2);
    y.e("MicroMsg.MsgHandler", "fail auth deny!");
    g.a(this.rzr.rzq.rzi, this.rzr.rzq.rzk, "login:fail auth deny", null);
    this.rzr.rzq.rzo.aib();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.8.1.1
 * JD-Core Version:    0.7.0.1
 */