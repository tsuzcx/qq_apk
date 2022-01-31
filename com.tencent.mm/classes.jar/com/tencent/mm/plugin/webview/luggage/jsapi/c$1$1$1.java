package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.os.Bundle;
import com.tencent.luggage.e.a.a;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ipcinvoker.wx_extension.b;
import com.tencent.mm.plugin.webview.ui.tools.widget.n.a;
import com.tencent.mm.protocal.c.arl;
import com.tencent.mm.protocal.c.arm;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

final class c$1$1$1
  implements n.a
{
  c$1$1$1(c.1.1 param1) {}
  
  public final void e(int paramInt, Bundle paramBundle)
  {
    y.i("MicroMsg.JsApiAuthorize", "stev onRevMsg resultCode %d", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    default: 
      y.d("MicroMsg.JsApiAuthorize", "press back button!");
      this.rdv.rdu.kNj.a("auth_cancel", null);
    }
    do
    {
      return;
      c localc = this.rdv.rdu.rdr;
      String str = this.rdv.rdu.val$appId;
      a.a locala = this.rdv.rdu.kNj;
      Object localObject = (ArrayList)paramBundle.getSerializable("key_scope");
      paramBundle = new LinkedList();
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramBundle.add((String)((Iterator)localObject).next());
      }
      localObject = new b.a();
      arl localarl = new arl();
      ((b.a)localObject).ecH = localarl;
      ((b.a)localObject).ecI = new arm();
      ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/js-authorize-confirm";
      ((b.a)localObject).ecG = 1158;
      ((b.a)localObject).ecJ = 0;
      ((b.a)localObject).ecK = 0;
      localarl.euK = str;
      localarl.tmX = paramBundle;
      localarl.tmZ = 0;
      localarl.tmY = paramInt;
      b.a(((b.a)localObject).Kt(), new c.2(localc, locala, paramInt));
    } while (paramInt != 2);
    this.rdv.rdu.kNj.a("auth_deny", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.c.1.1.1
 * JD-Core Version:    0.7.0.1
 */