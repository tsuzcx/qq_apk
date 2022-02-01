package com.tencent.mm.plugin.profile.ui.tab.data;

import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.MutableLiveData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.aa.a;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.q;
import com.tencent.mm.protocal.protobuf.pg;
import com.tencent.mm.protocal.protobuf.ph;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vending.e.b;
import java.io.IOException;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/profile/ui/tab/data/BizProfileDataFetcher;", "Landroid/arch/lifecycle/LifecycleObserver;", "addContactScene", "", "bizUsername", "", "context", "Lcom/tencent/mm/ui/MMActivity;", "(ILjava/lang/String;Lcom/tencent/mm/ui/MMActivity;)V", "bizProfileMsgResp", "Landroid/arch/lifecycle/MutableLiveData;", "Lcom/tencent/mm/protocal/protobuf/BizProfileV2Resp;", "getBizProfileMsgResp", "()Landroid/arch/lifecycle/MutableLiveData;", "bizProfileVideoResp", "getBizProfileVideoResp", "isLoading", "", "isMsgLoading", "isVideoLoading", "profileInfo", "profileInitRespData", "getProfileInitRespData", "createFetchReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "dataType", "pageSize", "offset", "Lcom/tencent/mm/protobuf/ByteString;", "fetchBizInfo", "", "initFetch", "fetchInitPage", "fetchMessageList", "fetchVideoList", "loadCacheProfileInfo", "userName", "Companion", "app_release"})
public final class BizProfileDataFetcher
  implements LifecycleObserver
{
  public static final BizProfileDataFetcher.a BmE;
  private ph BiU;
  public final MutableLiveData<ph> BmA;
  public final MutableLiveData<ph> BmB;
  public boolean BmC;
  public boolean BmD;
  public final MutableLiveData<ph> Bmz;
  private final String dVu;
  public final MMActivity gte;
  private boolean isLoading;
  private int kgm;
  
  static
  {
    AppMethodBeat.i(230713);
    BmE = new BizProfileDataFetcher.a((byte)0);
    AppMethodBeat.o(230713);
  }
  
  public BizProfileDataFetcher(int paramInt, String paramString, MMActivity paramMMActivity)
  {
    AppMethodBeat.i(230712);
    this.kgm = paramInt;
    this.dVu = paramString;
    this.gte = paramMMActivity;
    this.Bmz = new MutableLiveData();
    this.BiU = com.tencent.mm.plugin.profile.ui.newbizinfo.a.aKy(this.dVu);
    this.BmA = new MutableLiveData();
    this.BmB = new MutableLiveData();
    AppMethodBeat.o(230712);
  }
  
  public final void eFI()
  {
    AppMethodBeat.i(230711);
    if (this.isLoading)
    {
      Log.i("MicroMsg.BizProfileDataFetcher", "not obtailBizInfoFromCgi, use cache");
      AppMethodBeat.o(230711);
      return;
    }
    this.isLoading = true;
    d.a locala = new d.a();
    locala.sG(2656);
    locala.MB("/cgi-bin/mmbiz-bin/bizattr/bizprofilev2");
    locala.sI(0);
    locala.sJ(0);
    pg localpg = new pg();
    localpg.KSV = this.dVu;
    localpg.KWb = 0;
    localpg.KWc = 5;
    localpg.Scene = this.kgm;
    localpg.KWd = ab.getSessionId();
    locala.c((com.tencent.mm.bw.a)localpg);
    locala.d((com.tencent.mm.bw.a)new ph());
    aa.a(locala.aXF(), (aa.a)new b(this, true), false, (b)this.gte);
    AppMethodBeat.o(230711);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "errType", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
  static final class b
    implements aa.a
  {
    b(BizProfileDataFetcher paramBizProfileDataFetcher, boolean paramBoolean) {}
    
    public final int a(int paramInt1, int paramInt2, String paramString, d paramd, q paramq)
    {
      AppMethodBeat.i(230707);
      Log.i("MicroMsg.BizProfileDataFetcher", "callback, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      p.g(paramd, "rr");
      paramString = (ph)paramd.aYK();
      if ((paramInt1 != 0) || (paramInt2 != 0) || (paramString == null))
      {
        AppMethodBeat.o(230707);
        return 0;
      }
      paramd = com.tencent.mm.plugin.profile.ui.newbizinfo.a.BjZ;
      com.tencent.mm.plugin.profile.ui.newbizinfo.a.a(paramString.KWg);
      if (this.BmG) {}
      for (;;)
      {
        try
        {
          com.tencent.mm.plugin.profile.ui.newbizinfo.a.b(paramString);
          this.BmF.Bmz.setValue(paramString);
          BizProfileDataFetcher.c(this.BmF);
          AppMethodBeat.o(230707);
          return 0;
        }
        catch (IOException paramString)
        {
          Log.printErrStackTrace("MicroMsg.BizProfileDataFetcher", (Throwable)paramString, "profileInfo.parseFrom", new Object[0]);
          continue;
        }
        paramd = this.BmF.BmA;
        paramq = new ph();
        paramq.parseFrom(paramString.toByteArray());
        paramd.setValue(paramq);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "errType", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
  public static final class c
    implements aa.a
  {
    public c(BizProfileDataFetcher paramBizProfileDataFetcher) {}
    
    public final int a(int paramInt1, int paramInt2, String paramString, d paramd, q paramq)
    {
      AppMethodBeat.i(230708);
      p.g(paramd, "rr");
      paramString = (ph)paramd.aYK();
      if ((paramInt1 != 0) || (paramInt2 != 0) || (paramString == null))
      {
        BizProfileDataFetcher.b(this.BmF);
        AppMethodBeat.o(230708);
        return 0;
      }
      paramd = this.BmF.BmB;
      paramq = new ph();
      paramq.parseFrom(paramString.toByteArray());
      paramd.setValue(paramq);
      BizProfileDataFetcher.b(this.BmF);
      AppMethodBeat.o(230708);
      return 0;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "errType", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
  public static final class d
    implements aa.a
  {
    public d(BizProfileDataFetcher paramBizProfileDataFetcher) {}
    
    public final int a(int paramInt1, int paramInt2, String paramString, d paramd, q paramq)
    {
      AppMethodBeat.i(230709);
      p.g(paramd, "rr");
      paramString = (ph)paramd.aYK();
      if ((paramInt1 != 0) || (paramInt2 != 0) || (paramString == null))
      {
        BizProfileDataFetcher.a(this.BmF);
        AppMethodBeat.o(230709);
        return 0;
      }
      paramd = this.BmF.BmA;
      paramq = new ph();
      paramq.parseFrom(paramString.toByteArray());
      paramd.setValue(paramq);
      BizProfileDataFetcher.a(this.BmF);
      AppMethodBeat.o(230709);
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.tab.data.BizProfileDataFetcher
 * JD-Core Version:    0.7.0.1
 */