package com.tencent.mm.plugin.webview.model;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.protocal.protobuf.ddd;
import com.tencent.mm.sdk.platformtools.Log;

final class ag$b$9
  implements IPCRunCgi.a
{
  ag$b$9(e parame, ag.a parama, boolean paramBoolean, Context paramContext, ag.c paramc) {}
  
  public final void a(int paramInt1, int paramInt2, String paramString, d paramd)
  {
    AppMethodBeat.i(215095);
    Log.i("MicroMsg.OauthAuthorizeLogic", "onSceneEnd doOauthAuthorizeConfirm errType = %d, errCode = %d ,errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((this.PUw == null) || (this.PUx == null) || (!this.PUL))
    {
      AppMethodBeat.o(215095);
      return;
    }
    Bundle localBundle = new Bundle();
    if ((paramInt1 == 0) && (paramInt2 == 0) && (paramd != null) && (d.c.b(paramd.lBS) != null) && ((d.c.b(paramd.lBS) instanceof ddd)))
    {
      localBundle.putString("redirect_url", ((ddd)d.c.b(paramd.lBS)).SjB);
      ag.b.a(true, paramString, localBundle, this.val$context, this.PUA, this.PUx);
      AppMethodBeat.o(215095);
      return;
    }
    ag.b.a(false, paramString, localBundle, this.val$context, this.PUA, this.PUx);
    AppMethodBeat.o(215095);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ag.b.9
 * JD-Core Version:    0.7.0.1
 */