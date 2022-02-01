package com.tencent.mm.plugin.webview.model;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.protocal.protobuf.ddf;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;

final class ag$b$2
  implements IPCRunCgi.a
{
  ag$b$2(WeakReference paramWeakReference, e parame, ag.c paramc, ag.a parama, String paramString, int paramInt) {}
  
  public final void a(int paramInt1, int paramInt2, String paramString, d paramd)
  {
    AppMethodBeat.i(227400);
    Context localContext = (Context)this.PUv.get();
    Log.i("MicroMsg.OauthAuthorizeLogic", "onSceneEnd doOauthAuthorize errType = %d, errCode = %d ,errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((localContext == null) || (this.PUw == null) || (this.PUu == null) || (this.PUx == null))
    {
      AppMethodBeat.o(227400);
      return;
    }
    Bundle localBundle = new Bundle();
    if ((paramInt1 == 0) && (paramInt2 == 0) && (paramd != null) && (d.c.b(paramd.lBS) != null) && ((d.c.b(paramd.lBS) instanceof ddf)))
    {
      paramd = (ddf)d.c.b(paramd.lBS);
      localBundle.putString("oauth_url", this.PUy);
      localBundle.putSerializable("scope_list", ag.bY(paramd.TKY));
      localBundle.putString("appname", paramd.lnp);
      localBundle.putString("appicon_url", paramd.TKZ);
      localBundle.putString("redirect_url", paramd.SjB);
      localBundle.putBoolean("is_recent_has_auth", paramd.TLa);
      localBundle.putBoolean("is_silence_auth", paramd.TLb);
      localBundle.putBoolean("is_call_server_when_confirm", paramd.TLc);
      localBundle.putSerializable("avatar_list", ah.bZ(paramd.TLd));
      localBundle.putBoolean("is_use_new_page", paramd.TLe);
      localBundle.putBoolean("is_ban_modify_avatar", paramd.oDO);
      localBundle.putInt("avatar_limit", paramd.oDP);
      localBundle.putInt("default_avatar_id", paramd.oDQ);
      localBundle.putString("default_headimg_url", paramd.oDR);
      localBundle.putString("default_headimg_fileid", paramd.oDS);
      ag.b.a(true, paramString, localBundle, localContext, this.PUw, this.PUu, this.PUx, this.PUz, paramInt2);
      AppMethodBeat.o(227400);
      return;
    }
    ag.b.a(false, paramString, localBundle, localContext, this.PUw, this.PUu, this.PUx, this.PUz, paramInt2);
    AppMethodBeat.o(227400);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ag.b.2
 * JD-Core Version:    0.7.0.1
 */