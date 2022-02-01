package com.tencent.mm.plugin.wxpayreport;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.model.bu.a;
import com.tencent.mm.network.m;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/wxpayreport/WcPayReportNetInterceptor;", "Lcom/tencent/mm/model/NetInterceptor$Interceptor;", "()V", "intercept", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "wrapCallback", "Lcom/tencent/mm/network/IOnGYNetEnd;", "callback", "IOnGYNetEndWrapper", "plugin-wxpay-report_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  implements bu.a
{
  public final m a(m paramm, p paramp)
  {
    AppMethodBeat.i(261113);
    paramm = (m)new a(paramm, paramp);
    AppMethodBeat.o(261113);
    return paramm;
  }
  
  public final int bCS()
  {
    return 0;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/wxpayreport/WcPayReportNetInterceptor$IOnGYNetEndWrapper;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "callback", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "(Lcom/tencent/mm/network/IOnGYNetEnd;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "getCallback", "()Lcom/tencent/mm/network/IOnGYNetEnd;", "getScene", "()Lcom/tencent/mm/modelbase/NetSceneBase;", "onGYNetEnd", "", "netId", "", "errType", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-wxpay-report_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class a
    implements m
  {
    private final p hEi;
    private final m ouI;
    
    public a(m paramm, p paramp)
    {
      this.ouI = paramm;
      this.hEi = paramp;
    }
    
    public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(261065);
      m localm = this.ouI;
      if (localm != null) {
        localm.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, params, paramArrayOfByte);
      }
      if (params != null)
      {
        paramArrayOfByte = params.getUri();
        if ((paramArrayOfByte != null) && (n.a((CharSequence)paramArrayOfByte, (CharSequence)"mmpay-bin", false) == true))
        {
          paramInt1 = 1;
          if ((paramInt1 == 0) || (paramInt2 == 0) || (paramInt3 == 0)) {
            break label316;
          }
          if (params == null) {
            break label147;
          }
          paramArrayOfByte = params.getUri();
          if ((paramArrayOfByte == null) || (paramArrayOfByte.equals("/cgi-bin/mmpay-bin/cpucardgetconfig2") != true)) {
            break label147;
          }
        }
      }
      label147:
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        if ((paramInt1 == 0) || (!kotlin.g.b.s.p("autoauth_errmsg_", paramString))) {
          break label152;
        }
        Log.w("WcPayReport", "ignore bad case");
        AppMethodBeat.o(261065);
        return;
        paramInt1 = 0;
        break;
      }
      label152:
      Log.d("WcPayReport", "report pay cgi error: " + params.getUri() + ", errCode: " + paramInt3);
      paramArrayOfByte = h.XIV;
      params = params.getUri();
      kotlin.g.b.s.s(params, "rr.uri");
      paramArrayOfByte = paramInt2 + ':' + paramInt3;
      kotlin.g.b.s.u(params, "cgiUrl");
      kotlin.g.b.s.u(paramArrayOfByte, "errorCode");
      com.tencent.mm.plugin.report.service.h.OAn.b(24610, new Object[] { "1", params, paramArrayOfByte, paramString, "", Integer.valueOf(h.iFD()), Integer.valueOf(h.iFE()), Integer.valueOf(h.iFF()) });
      label316:
      AppMethodBeat.o(261065);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wxpayreport.i
 * JD-Core Version:    0.7.0.1
 */