package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.os.Bundle;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ipcinvoker.wx_extension.b;
import com.tencent.mm.plugin.webview.ui.tools.widget.n.a;
import com.tencent.mm.protocal.protobuf.axq;
import com.tencent.mm.protocal.protobuf.axr;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

final class c$1$1$1
  implements n.a
{
  c$1$1$1(c.1.1 param1) {}
  
  public final void h(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(6277);
    ab.i("MicroMsg.JsApiAuthorize", "stev onRevMsg resultCode %d", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    default: 
      ab.d("MicroMsg.JsApiAuthorize", "press back button!");
      this.uTq.uTp.njN.a("auth_cancel", null);
    }
    do
    {
      AppMethodBeat.o(6277);
      return;
      c localc = this.uTq.uTp.uTm;
      String str = this.uTq.uTp.val$appId;
      a.a locala = this.uTq.uTp.njN;
      Object localObject = (ArrayList)paramBundle.getSerializable("key_scope");
      paramBundle = new LinkedList();
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramBundle.add((String)((Iterator)localObject).next());
      }
      localObject = new b.a();
      axq localaxq = new axq();
      ((b.a)localObject).fsX = localaxq;
      ((b.a)localObject).fsY = new axr();
      ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/js-authorize-confirm";
      ((b.a)localObject).funcId = 1158;
      ((b.a)localObject).reqCmdId = 0;
      ((b.a)localObject).respCmdId = 0;
      localaxq.fKw = str;
      localaxq.xmO = paramBundle;
      localaxq.xmQ = 0;
      localaxq.xmP = paramInt;
      b.a(((b.a)localObject).ado(), new c.2(localc, locala, paramInt));
    } while (paramInt != 2);
    this.uTq.uTp.njN.a("auth_deny", null);
    AppMethodBeat.o(6277);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.c.1.1.1
 * JD-Core Version:    0.7.0.1
 */