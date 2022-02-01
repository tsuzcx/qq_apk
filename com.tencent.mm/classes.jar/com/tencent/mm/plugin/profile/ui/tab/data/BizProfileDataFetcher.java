package com.tencent.mm.plugin.profile.ui.tab.data;

import androidx.lifecycle.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.z;
import com.tencent.mm.bx.a;
import com.tencent.mm.protocal.protobuf.ql;
import com.tencent.mm.protocal.protobuf.qm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.MMActivity;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/profile/ui/tab/data/BizProfileDataFetcher;", "Landroidx/lifecycle/LifecycleObserver;", "addContactScene", "", "bizUsername", "", "context", "Lcom/tencent/mm/ui/MMActivity;", "searchClickId", "(ILjava/lang/String;Lcom/tencent/mm/ui/MMActivity;Ljava/lang/String;)V", "bizProfileMsgResp", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/mm/protocal/protobuf/BizProfileV2Resp;", "getBizProfileMsgResp", "()Landroidx/lifecycle/MutableLiveData;", "bizProfileVideoResp", "getBizProfileVideoResp", "isLoading", "", "isMsgLoading", "isVideoLoading", "profileInfo", "profileInitRespData", "getProfileInitRespData", "createFetchReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "dataType", "pageSize", "offset", "Lcom/tencent/mm/protobuf/ByteString;", "fetchBizInfo", "", "initFetch", "fetchInitPage", "fetchMessageList", "fetchVideoList", "loadCacheProfileInfo", "userName", "Companion", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class BizProfileDataFetcher
  implements androidx.lifecycle.p
{
  public static final BizProfileDataFetcher.a Neh;
  private qm NcO;
  private final String Ndp;
  public final x<qm> Nei;
  public final x<qm> Nej;
  public final x<qm> Nek;
  private boolean Nel;
  private boolean Nem;
  private final String hUQ;
  private boolean isLoading;
  private final MMActivity lzt;
  private int pUt;
  
  static
  {
    AppMethodBeat.i(306014);
    Neh = new BizProfileDataFetcher.a((byte)0);
    AppMethodBeat.o(306014);
  }
  
  public BizProfileDataFetcher(int paramInt, String paramString1, MMActivity paramMMActivity, String paramString2)
  {
    AppMethodBeat.i(305929);
    this.pUt = paramInt;
    this.hUQ = paramString1;
    this.lzt = paramMMActivity;
    this.Ndp = paramString2;
    this.Nei = new x();
    this.NcO = com.tencent.mm.plugin.profile.ui.newbizinfo.b.aSd(this.hUQ);
    this.Nej = new x();
    this.Nek = new x();
    AppMethodBeat.o(305929);
  }
  
  private static final int a(BizProfileDataFetcher paramBizProfileDataFetcher, int paramInt1, int paramInt2, String paramString, c paramc, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(305978);
    s.u(paramBizProfileDataFetcher, "this$0");
    paramp = (qm)c.c.b(paramc.otC);
    if ((paramInt1 != 0) || (paramInt2 != 0) || (paramp == null))
    {
      paramBizProfileDataFetcher.Nel = false;
      AppMethodBeat.o(305978);
      return 0;
    }
    paramString = paramBizProfileDataFetcher.Nej;
    paramc = new qm();
    paramc.parseFrom(paramp.toByteArray());
    paramp = ah.aiuX;
    paramString.setValue(paramc);
    paramBizProfileDataFetcher.Nel = false;
    AppMethodBeat.o(305978);
    return 0;
  }
  
  private static final int a(boolean paramBoolean, BizProfileDataFetcher paramBizProfileDataFetcher, int paramInt1, int paramInt2, String paramString, c paramc, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(306007);
    s.u(paramBizProfileDataFetcher, "this$0");
    Log.i("MicroMsg.BizProfileDataFetcher", "callback, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    paramString = (qm)c.c.b(paramc.otC);
    if ((paramInt1 != 0) || (paramInt2 != 0) || (paramString == null))
    {
      AppMethodBeat.o(306007);
      return 0;
    }
    paramc = com.tencent.mm.plugin.profile.ui.newbizinfo.b.Ncd;
    com.tencent.mm.plugin.profile.ui.newbizinfo.b.a(paramString.YVn);
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        com.tencent.mm.plugin.profile.ui.newbizinfo.b.a(paramString);
        paramBizProfileDataFetcher.Nei.setValue(paramString);
        paramBizProfileDataFetcher.isLoading = false;
        AppMethodBeat.o(306007);
        return 0;
      }
      catch (IOException paramString)
      {
        Log.printErrStackTrace("MicroMsg.BizProfileDataFetcher", (Throwable)paramString, "profileInfo.parseFrom", new Object[0]);
        continue;
      }
      paramc = paramBizProfileDataFetcher.Nej;
      paramp = new qm();
      paramp.parseFrom(paramString.toByteArray());
      paramString = ah.aiuX;
      paramc.setValue(paramp);
    }
  }
  
  private final c a(int paramInt, com.tencent.mm.bx.b paramb)
  {
    AppMethodBeat.i(305949);
    c.a locala = new c.a();
    locala.funcId = 2656;
    locala.uri = "/cgi-bin/mmbiz-bin/bizattr/bizprofilev2";
    locala.otG = 0;
    locala.respCmdId = 0;
    ql localql = new ql();
    localql.YRs = this.hUQ;
    localql.YVh = paramInt;
    localql.YVf = paramb;
    localql.YVi = 20;
    localql.IJG = this.pUt;
    localql.YVj = ad.getSessionId();
    localql.YVk = this.Ndp;
    locala.otE = ((a)localql);
    locala.otF = ((a)new qm());
    paramb = locala.bEF();
    s.s(paramb, "Builder().apply {\n      …        }.buildInstance()");
    AppMethodBeat.o(305949);
    return paramb;
  }
  
  private static final int b(BizProfileDataFetcher paramBizProfileDataFetcher, int paramInt1, int paramInt2, String paramString, c paramc, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(305988);
    s.u(paramBizProfileDataFetcher, "this$0");
    paramp = (qm)c.c.b(paramc.otC);
    if ((paramInt1 != 0) || (paramInt2 != 0) || (paramp == null))
    {
      paramBizProfileDataFetcher.Nem = false;
      AppMethodBeat.o(305988);
      return 0;
    }
    paramString = paramBizProfileDataFetcher.Nek;
    paramc = new qm();
    paramc.parseFrom(paramp.toByteArray());
    paramp = ah.aiuX;
    paramString.setValue(paramc);
    paramBizProfileDataFetcher.Nem = false;
    AppMethodBeat.o(305988);
    return 0;
  }
  
  private void gCT()
  {
    AppMethodBeat.i(305962);
    if (this.isLoading)
    {
      Log.i("MicroMsg.BizProfileDataFetcher", "not obtailBizInfoFromCgi, use cache");
      AppMethodBeat.o(305962);
      return;
    }
    this.isLoading = true;
    c.a locala = new c.a();
    locala.funcId = 2656;
    locala.uri = "/cgi-bin/mmbiz-bin/bizattr/bizprofilev2";
    locala.otG = 0;
    locala.respCmdId = 0;
    ql localql = new ql();
    localql.YRs = this.hUQ;
    localql.YVh = 0;
    localql.YVi = 5;
    localql.IJG = this.pUt;
    localql.YVj = ad.getSessionId();
    localql.YVk = this.Ndp;
    locala.otE = ((a)localql);
    locala.otF = ((a)new qm());
    z.a(locala.bEF(), new BizProfileDataFetcher..ExternalSyntheticLambda2(true, this), false, (com.tencent.mm.vending.e.b)this.lzt);
    AppMethodBeat.o(305962);
  }
  
  public final void gCS()
  {
    AppMethodBeat.i(306057);
    gCT();
    AppMethodBeat.o(306057);
  }
  
  public final void h(com.tencent.mm.bx.b paramb)
  {
    AppMethodBeat.i(306072);
    if (this.Nel)
    {
      AppMethodBeat.o(306072);
      return;
    }
    this.Nel = true;
    z.a(a(2, paramb), new BizProfileDataFetcher..ExternalSyntheticLambda1(this), false, (com.tencent.mm.vending.e.b)this.lzt);
    AppMethodBeat.o(306072);
  }
  
  public final void i(com.tencent.mm.bx.b paramb)
  {
    AppMethodBeat.i(306086);
    if (this.Nem)
    {
      AppMethodBeat.o(306086);
      return;
    }
    this.Nem = true;
    z.a(a(1, paramb), new BizProfileDataFetcher..ExternalSyntheticLambda0(this), false, (com.tencent.mm.vending.e.b)this.lzt);
    AppMethodBeat.o(306086);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.tab.data.BizProfileDataFetcher
 * JD-Core Version:    0.7.0.1
 */