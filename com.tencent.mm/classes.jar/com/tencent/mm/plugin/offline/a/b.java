package com.tencent.mm.plugin.offline.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.offline.c.d;
import com.tencent.mm.plugin.offline.e;
import com.tencent.mm.plugin.offline.k;
import com.tencent.mm.protocal.protobuf.fad;
import com.tencent.mm.protocal.protobuf.fae;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/offline/model/CgiSetOfflinePayment;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/SetOfflinePaymentResponse;", "bindSerial", "", "bankType", "settingState", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "getBankType", "()Ljava/lang/String;", "getBindSerial", "getSettingState", "()I", "onCgiBack", "", "errType", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "run", "Lcom/tencent/mm/wx/WxPipeline;", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Companion", "plugin-wxpay_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends com.tencent.mm.am.b<fae>
{
  public static final b.a MyA;
  private static boolean isLoading;
  private final int MyB;
  private final String hPf;
  private final String hPg;
  
  static
  {
    AppMethodBeat.i(269134);
    MyA = new b.a((byte)0);
    AppMethodBeat.o(269134);
  }
  
  public b(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(269130);
    this.hPg = paramString1;
    this.hPf = paramString2;
    this.MyB = paramInt;
    fad localfad = new fad();
    k.gvj();
    String str = k.afd(196617);
    Object localObject = d.getToken();
    k.gvj();
    paramString2 = k.afd(196628);
    paramString1 = paramString2;
    if (TextUtils.isEmpty((CharSequence)paramString2)) {
      paramString1 = q.aPg();
    }
    paramString2 = s.X("", Long.valueOf(System.currentTimeMillis() / 1000L));
    paramInt = 1000000 + (int)(Math.random() * 1000000.0D);
    if (TextUtils.isEmpty((CharSequence)localObject)) {}
    for (paramString1 = paramString1 + '&' + paramString2 + '&' + paramInt;; paramString1 = paramString1 + '&' + paramString2 + '&' + paramInt + '&' + localObject)
    {
      com.tencent.mm.wallet_core.model.b.jOG();
      paramString2 = com.tencent.mm.wallet_core.model.b.genUserSig(str, paramString1);
      localObject = h.baE().ban().get(at.a.acHB, null);
      if (localObject != null) {
        break;
      }
      paramString1 = new NullPointerException("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(269130);
      throw paramString1;
    }
    localObject = (String)localObject;
    k.gvj();
    k.gvl();
    paramInt = e.gvb();
    localfad.abAE = str;
    localfad.abAF = paramString1;
    localfad.sign = paramString2;
    localfad.hAk = this.hPf;
    localfad.MDt = this.hPg;
    localfad.abAH = Integer.parseInt((String)localObject);
    localfad.abAG = this.MyB;
    localfad.abAI = paramInt;
    paramString1 = new c.a();
    paramString1.otE = ((a)localfad);
    paramString1.otF = ((a)new fae());
    paramString1.funcId = 7140;
    paramString1.uri = "/cgi-bin/mmpay-bin/offlinesetpayment";
    paramString1.otG = 0;
    paramString1.respCmdId = 0;
    c(paramString1.bEF());
    this.otr = true;
    Log.i("MicroMsg.CgiSetOfflinePayment", "do setpayment: " + this.hPf + ", " + this.hPg + ", " + paramInt);
    AppMethodBeat.o(269130);
  }
  
  public final com.tencent.mm.cp.f<com.tencent.mm.am.b.a<fae>> bFJ()
  {
    AppMethodBeat.i(269137);
    isLoading = true;
    com.tencent.mm.cp.f localf = super.bFJ();
    s.s(localf, "super.run()");
    AppMethodBeat.o(269137);
    return localf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.a.b
 * JD-Core Version:    0.7.0.1
 */