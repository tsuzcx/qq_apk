package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.pk;
import com.tencent.mm.protocal.protobuf.pl;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/model/NetSceneBizFinderLiveQrCode;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "url", "", "(Ljava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResp", "Lcom/tencent/mm/protocal/protobuf/BizFinderLiveQrCodeResp;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class o
  extends p
  implements m
{
  public static final a ORI;
  private h callback;
  private final c oDw;
  
  static
  {
    AppMethodBeat.i(314367);
    ORI = new a((byte)0);
    AppMethodBeat.o(314367);
  }
  
  public o(String paramString)
  {
    AppMethodBeat.i(314363);
    Object localObject = new c.a();
    ((c.a)localObject).otE = ((a)new pk());
    ((c.a)localObject).otF = ((a)new pl());
    ((c.a)localObject).uri = "/cgi-bin/mmbiz-bin/finder/bizfinderliveqrcode";
    ((c.a)localObject).funcId = 5900;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    localObject = ((c.a)localObject).bEF();
    kotlin.g.b.s.s(localObject, "builder.buildInstance()");
    this.oDw = ((c)localObject);
    localObject = c.b.b(this.oDw.otB);
    if (localObject == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizFinderLiveQrCodeReq");
      AppMethodBeat.o(314363);
      throw paramString;
    }
    ((pk)localObject).url = paramString;
    Log.d("MicroMsg.NetSceneBizFinderLiveQrCode", kotlin.g.b.s.X("#init url=", paramString));
    AppMethodBeat.o(314363);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(314374);
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.oDw, (m)this);
    AppMethodBeat.o(314374);
    return i;
  }
  
  public final int getType()
  {
    return 5900;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(314378);
    Log.i("MicroMsg.NetSceneBizFinderLiveQrCode", "#onGYNetEnd errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    params = this.callback;
    if (params != null) {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
    }
    AppMethodBeat.o(314378);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/model/NetSceneBizFinderLiveQrCode$Companion;", "", "()V", "ERR_ARGS", "", "ERR_NOT_BIND_SAME_FINDER", "ERR_NOT_BIZ_OP", "ERR_SYS", "TAG", "", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.o
 * JD-Core Version:    0.7.0.1
 */