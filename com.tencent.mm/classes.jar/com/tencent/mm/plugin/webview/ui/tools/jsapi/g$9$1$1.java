package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.plugin.webview.ui.tools.widget.n.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.z.a.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

final class g$9$1$1
  implements n.a
{
  g$9$1$1(g.9.1 param1) {}
  
  public final void h(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(9050);
    ab.i("MicroMsg.MsgHandler", "stev onRevMsg resultCode %d", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    default: 
      ab.d("MicroMsg.MsgHandler", "press back button!");
      this.vqw.vqv.vqm.a(this.vqw.vqv.uZa, "authorize:fail auth cancel", null);
      this.vqw.vqv.vqq.aBV();
    }
    do
    {
      AppMethodBeat.o(9050);
      return;
      g localg = this.vqw.vqv.vqm;
      String str = this.vqw.vqv.val$appId;
      i locali = this.vqw.vqv.uZa;
      g.a locala = this.vqw.vqv.vqq;
      Object localObject = (ArrayList)paramBundle.getSerializable("key_scope");
      paramBundle = new LinkedList();
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramBundle.add((String)((Iterator)localObject).next());
      }
      com.tencent.mm.kernel.g.Rc().a(new b(str, paramBundle, paramInt, new g.8(localg, locali, locala, paramInt)), 0);
    } while (paramInt != 2);
    this.vqw.vqv.vqm.a(this.vqw.vqv.uZa, "authorize:fail auth deny", null);
    this.vqw.vqv.vqq.aBV();
    AppMethodBeat.o(9050);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.9.1.1
 * JD-Core Version:    0.7.0.1
 */