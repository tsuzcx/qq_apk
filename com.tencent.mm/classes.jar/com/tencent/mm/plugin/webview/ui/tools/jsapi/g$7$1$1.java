package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.plugin.webview.ui.tools.widget.n.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.z.a.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

final class g$7$1$1
  implements n.a
{
  g$7$1$1(g.7.1 param1) {}
  
  public final void h(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(154927);
    ab.i("MicroMsg.MsgHandler", "onRevMsg resultCode %d", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    default: 
      ab.i("MicroMsg.MsgHandler", "press back button!");
      this.vqt.vqs.vqm.a(this.vqt.vqs.uZa, "login:fail auth cancel", null);
      this.vqt.vqs.vqq.aBV();
    }
    do
    {
      AppMethodBeat.o(154927);
      return;
      g localg = this.vqt.vqs.vqm;
      String str1 = this.vqt.vqs.val$appId;
      String str2 = this.vqt.uTJ;
      i locali = this.vqt.vqs.uZa;
      g.a locala = this.vqt.vqs.vqq;
      Object localObject = (ArrayList)paramBundle.getSerializable("key_scope");
      paramBundle = new LinkedList();
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramBundle.add((String)((Iterator)localObject).next());
      }
      com.tencent.mm.kernel.g.Rc().a(new d(str1, paramBundle, str2, paramInt, new g.6(localg, locali, locala, paramInt)), 0);
    } while (paramInt != 2);
    ab.e("MicroMsg.MsgHandler", "fail auth deny!");
    this.vqt.vqs.vqm.a(this.vqt.vqs.uZa, "login:fail auth deny", null);
    this.vqt.vqs.vqq.aBV();
    AppMethodBeat.o(154927);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.7.1.1
 * JD-Core Version:    0.7.0.1
 */