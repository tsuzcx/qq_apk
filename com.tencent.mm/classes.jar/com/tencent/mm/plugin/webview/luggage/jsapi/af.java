package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.d.a;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.plugin.webview.luggage.r;
import com.tencent.mm.plugin.webview.ui.tools.widget.n;
import com.tencent.mm.protocal.protobuf.axe;
import com.tencent.mm.protocal.protobuf.axw;
import com.tencent.mm.protocal.protobuf.axx;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.LinkedList;

public class af
  extends bi<com.tencent.mm.plugin.webview.luggage.e>
{
  public final void a(Context paramContext, String paramString, bh.a parama) {}
  
  public final void b(final a<com.tencent.mm.plugin.webview.luggage.e>.a parama)
  {
    AppMethodBeat.i(6336);
    ab.i("MicroMsg.JsApiLogin", "invoke");
    LinkedList localLinkedList = new LinkedList();
    final String str = ((com.tencent.mm.plugin.webview.luggage.e)parama.byE).uRD.getAppId();
    if (bo.isNullOrNil(str))
    {
      ab.e("MicroMsg.JsApiLogin", "appId is null!");
      parama.a("fail", null);
      AppMethodBeat.o(6336);
      return;
    }
    com.tencent.mm.ai.b.a locala = new com.tencent.mm.ai.b.a();
    axw localaxw = new axw();
    locala.fsX = localaxw;
    locala.fsY = new axx();
    locala.uri = "/cgi-bin/mmbiz-bin/js-login";
    locala.funcId = 1029;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    localaxw.fKw = str;
    localaxw.xmO = localLinkedList;
    localaxw.xmX = 0;
    localaxw.Url = "";
    localaxw.xmY = "";
    localaxw.xmQ = 0;
    com.tencent.mm.ipcinvoker.wx_extension.b.a(locala.ado(), new com.tencent.mm.ipcinvoker.wx_extension.b.a()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, final String paramAnonymousString, final com.tencent.mm.ai.b paramAnonymousb)
      {
        AppMethodBeat.i(6334);
        ab.i("MicroMsg.JsApiLogin", "errType = %d, errCode = %d ,errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          parama.a("fail", null);
          AppMethodBeat.o(6334);
          return;
        }
        paramAnonymousb = (axx)paramAnonymousb.fsW.fta;
        if ((paramAnonymousb == null) || (paramAnonymousb.xmS == null))
        {
          parama.a("fail", null);
          AppMethodBeat.o(6334);
          return;
        }
        paramAnonymousInt1 = paramAnonymousb.xmS.csV;
        Object localObject = paramAnonymousb.xmS.csW;
        paramAnonymousString = paramAnonymousb.xmY;
        ab.i("MicroMsg.JsApiLogin", "NetSceneJSLogin jsErrcode %d", new Object[] { Integer.valueOf(paramAnonymousInt1) });
        if (paramAnonymousInt1 == -12000)
        {
          localObject = paramAnonymousb.wYt;
          final String str = paramAnonymousb.ntp;
          paramAnonymousb = paramAnonymousb.wnz;
          ab.d("MicroMsg.JsApiLogin", "appName %s, appIconUrl %s", new Object[] { str, paramAnonymousb });
          al.d(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(6333);
              n localn = new n(((com.tencent.mm.plugin.webview.luggage.e)af.1.this.njN.byE).mContext);
              af.1.1.1 local1 = new af.1.1.1(this);
              if ((this.hDM != null) && (this.hDM.size() > 0))
              {
                if (!localn.a(this.hDM, str, paramAnonymousb, local1)) {
                  af.1.this.njN.a("fail", null);
                }
                AppMethodBeat.o(6333);
                return;
              }
              ab.e("MicroMsg.JsApiLogin", "scopeInfoList is empty!");
              af.1.this.njN.a("fail", null);
              AppMethodBeat.o(6333);
            }
          });
          AppMethodBeat.o(6334);
          return;
        }
        if (paramAnonymousInt1 == 0)
        {
          paramAnonymousString = paramAnonymousb.xmZ;
          new HashMap().put("code", paramAnonymousString);
          ab.d("MicroMsg.JsApiLogin", "resp data code [%s]", new Object[] { paramAnonymousString });
          parama.a("", null);
          AppMethodBeat.o(6334);
          return;
        }
        ab.e("MicroMsg.JsApiLogin", "onSceneEnd NetSceneJSLogin %s", new Object[] { localObject });
        parama.a("fail", null);
        AppMethodBeat.o(6334);
      }
    });
    AppMethodBeat.o(6336);
  }
  
  public final int bjL()
  {
    return 0;
  }
  
  public final String name()
  {
    return "login";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.af
 * JD-Core Version:    0.7.0.1
 */