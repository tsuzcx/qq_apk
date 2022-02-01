package com.tencent.mm.plugin.profile.ui.tab.data;

import androidx.lifecycle.k;
import androidx.lifecycle.r;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.aa;
import com.tencent.mm.an.aa.a;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.q;
import com.tencent.mm.protocal.protobuf.pc;
import com.tencent.mm.protocal.protobuf.pd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vending.e.b;
import java.io.IOException;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/profile/ui/tab/data/BizProfileDataFetcher;", "Landroidx/lifecycle/LifecycleObserver;", "addContactScene", "", "bizUsername", "", "context", "Lcom/tencent/mm/ui/MMActivity;", "(ILjava/lang/String;Lcom/tencent/mm/ui/MMActivity;)V", "bizProfileMsgResp", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/mm/protocal/protobuf/BizProfileV2Resp;", "getBizProfileMsgResp", "()Landroidx/lifecycle/MutableLiveData;", "bizProfileVideoResp", "getBizProfileVideoResp", "isLoading", "", "isMsgLoading", "isVideoLoading", "profileInfo", "profileInitRespData", "getProfileInitRespData", "createFetchReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "dataType", "pageSize", "offset", "Lcom/tencent/mm/protobuf/ByteString;", "fetchBizInfo", "", "initFetch", "fetchInitPage", "fetchMessageList", "fetchVideoList", "loadCacheProfileInfo", "userName", "Companion", "app_release"})
public final class BizProfileDataFetcher
  implements k
{
  public static final BizProfileDataFetcher.a HgY;
  private pd Hdu;
  public final r<pd> HgT;
  public final r<pd> HgU;
  public final r<pd> HgV;
  public boolean HgW;
  public boolean HgX;
  private final String fOX;
  public final MMActivity iXq;
  private boolean isLoading;
  private int mXL;
  
  static
  {
    AppMethodBeat.i(272431);
    HgY = new BizProfileDataFetcher.a((byte)0);
    AppMethodBeat.o(272431);
  }
  
  public BizProfileDataFetcher(int paramInt, String paramString, MMActivity paramMMActivity)
  {
    AppMethodBeat.i(272429);
    this.mXL = paramInt;
    this.fOX = paramString;
    this.iXq = paramMMActivity;
    this.HgT = new r();
    this.Hdu = com.tencent.mm.plugin.profile.ui.newbizinfo.a.aUW(this.fOX);
    this.HgU = new r();
    this.HgV = new r();
    AppMethodBeat.o(272429);
  }
  
  public final void frF()
  {
    AppMethodBeat.i(272427);
    if (this.isLoading)
    {
      Log.i("MicroMsg.BizProfileDataFetcher", "not obtailBizInfoFromCgi, use cache");
      AppMethodBeat.o(272427);
      return;
    }
    this.isLoading = true;
    d.a locala = new d.a();
    locala.vD(2656);
    locala.TW("/cgi-bin/mmbiz-bin/bizattr/bizprofilev2");
    locala.vF(0);
    locala.vG(0);
    pc localpc = new pc();
    localpc.RTS = this.fOX;
    localpc.RXp = 0;
    localpc.RXq = 5;
    localpc.CPw = this.mXL;
    localpc.RXr = ab.getSessionId();
    locala.c((com.tencent.mm.cd.a)localpc);
    locala.d((com.tencent.mm.cd.a)new pd());
    aa.a(locala.bgN(), (aa.a)new b(this, true), false, (b)this.iXq);
    AppMethodBeat.o(272427);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "errType", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
  static final class b
    implements aa.a
  {
    b(BizProfileDataFetcher paramBizProfileDataFetcher, boolean paramBoolean) {}
    
    public final int a(int paramInt1, int paramInt2, String paramString, d paramd, q paramq)
    {
      AppMethodBeat.i(288008);
      Log.i("MicroMsg.BizProfileDataFetcher", "callback, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      p.j(paramd, "rr");
      paramString = (pd)paramd.bhY();
      if ((paramInt1 != 0) || (paramInt2 != 0) || (paramString == null))
      {
        AppMethodBeat.o(288008);
        return 0;
      }
      paramd = com.tencent.mm.plugin.profile.ui.newbizinfo.a.Hes;
      com.tencent.mm.plugin.profile.ui.newbizinfo.a.a(paramString.RXu);
      if (this.Hha) {}
      for (;;)
      {
        try
        {
          com.tencent.mm.plugin.profile.ui.newbizinfo.a.b(paramString);
          this.HgZ.HgT.setValue(paramString);
          BizProfileDataFetcher.c(this.HgZ);
          AppMethodBeat.o(288008);
          return 0;
        }
        catch (IOException paramString)
        {
          Log.printErrStackTrace("MicroMsg.BizProfileDataFetcher", (Throwable)paramString, "profileInfo.parseFrom", new Object[0]);
          continue;
        }
        paramd = this.HgZ.HgU;
        paramq = new pd();
        paramq.parseFrom(paramString.toByteArray());
        paramd.setValue(paramq);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "errType", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
  public static final class c
    implements aa.a
  {
    public c(BizProfileDataFetcher paramBizProfileDataFetcher) {}
    
    public final int a(int paramInt1, int paramInt2, String paramString, d paramd, q paramq)
    {
      AppMethodBeat.i(279928);
      p.j(paramd, "rr");
      paramString = (pd)paramd.bhY();
      if ((paramInt1 != 0) || (paramInt2 != 0) || (paramString == null))
      {
        BizProfileDataFetcher.b(this.HgZ);
        AppMethodBeat.o(279928);
        return 0;
      }
      paramd = this.HgZ.HgV;
      paramq = new pd();
      paramq.parseFrom(paramString.toByteArray());
      paramd.setValue(paramq);
      BizProfileDataFetcher.b(this.HgZ);
      AppMethodBeat.o(279928);
      return 0;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "errType", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
  public static final class d
    implements aa.a
  {
    public d(BizProfileDataFetcher paramBizProfileDataFetcher) {}
    
    public final int a(int paramInt1, int paramInt2, String paramString, d paramd, q paramq)
    {
      AppMethodBeat.i(289466);
      p.j(paramd, "rr");
      paramString = (pd)paramd.bhY();
      if ((paramInt1 != 0) || (paramInt2 != 0) || (paramString == null))
      {
        BizProfileDataFetcher.a(this.HgZ);
        AppMethodBeat.o(289466);
        return 0;
      }
      paramd = this.HgZ.HgU;
      paramq = new pd();
      paramq.parseFrom(paramString.toByteArray());
      paramd.setValue(paramq);
      BizProfileDataFetcher.a(this.HgZ);
      AppMethodBeat.o(289466);
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.tab.data.BizProfileDataFetcher
 * JD-Core Version:    0.7.0.1
 */