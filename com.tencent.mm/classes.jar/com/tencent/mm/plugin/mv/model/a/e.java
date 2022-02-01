package com.tencent.mm.plugin.mv.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.dsm;
import com.tencent.mm.protocal.protobuf.dsn;
import com.tencent.mm.protocal.protobuf.dso;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/model/netscene/NetSceneMusicMidGetLink;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "reqInfos", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/MusicLiveGetLinkReqInfo;", "(Ljava/util/LinkedList;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "req", "Lcom/tencent/mm/protocal/protobuf/MusicLiveGetLinkReq;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "responseLinkMap", "Lcom/tencent/mm/protocal/protobuf/MusicLiveGetLinkRespInfo;", "Companion", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends p
  implements m
{
  public static final e.a LYN;
  private final dsm LNb;
  private h callback;
  public final c oDw;
  
  static
  {
    AppMethodBeat.i(286278);
    LYN = new e.a((byte)0);
    AppMethodBeat.o(286278);
  }
  
  public e(LinkedList<dsn> paramLinkedList)
  {
    AppMethodBeat.i(286271);
    Object localObject = new c.a();
    ((c.a)localObject).funcId = 6473;
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/musiclivegetlink";
    ((c.a)localObject).otE = ((a)new dsm());
    ((c.a)localObject).otF = ((a)new dso());
    localObject = ((c.a)localObject).bEF();
    kotlin.g.b.s.s(localObject, "commReqRespBuilder.buildInstance()");
    this.oDw = ((c)localObject);
    localObject = c.b.b(this.oDw.otB);
    if (localObject == null)
    {
      paramLinkedList = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.MusicLiveGetLinkReq");
      AppMethodBeat.o(286271);
      throw paramLinkedList;
    }
    this.LNb = ((dsm)localObject);
    this.LNb.ToF = paramLinkedList;
    localObject = new StringBuffer();
    ((StringBuffer)localObject).append("[");
    paramLinkedList = ((Iterable)paramLinkedList).iterator();
    while (paramLinkedList.hasNext())
    {
      dsn localdsn = (dsn)paramLinkedList.next();
      ((StringBuffer)localObject).append("(").append(localdsn.appid).append(",").append(localdsn.oOZ).append("),");
    }
    Log.i("MicroMsg.Music.NetSceneMusicLiveGetLink", "request music url:%s", new Object[] { kotlin.g.b.s.X(((StringBuffer)localObject).substring(0, ((StringBuffer)localObject).length() - 1), "]") });
    AppMethodBeat.o(286271);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(286292);
    kotlin.g.b.s.u(paramg, "dispatcher");
    kotlin.g.b.s.u(paramh, "callback");
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.oDw, (m)this);
    AppMethodBeat.o(286292);
    return i;
  }
  
  public final int getType()
  {
    return 6473;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(286299);
    Log.i("MicroMsg.Music.NetSceneMusicLiveGetLink", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      params = this.callback;
      if (params != null) {
        params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
      }
      AppMethodBeat.o(286299);
      return;
    }
    if (c.c.b(this.oDw.otC) == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.MusicLiveGetLinkResp");
      AppMethodBeat.o(286299);
      throw paramString;
    }
    params = this.callback;
    if (params != null) {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
    }
    AppMethodBeat.o(286299);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.model.a.e
 * JD-Core Version:    0.7.0.1
 */