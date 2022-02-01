package com.tencent.mm.plugin.textstatus.conversation.b;

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
import com.tencent.mm.plugin.textstatus.proto.be;
import com.tencent.mm.plugin.textstatus.proto.bf;
import com.tencent.mm.plugin.textstatus.proto.u;
import com.tencent.mm.plugin.textstatus.proto.v;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/conversation/cgi/NetSceneTextStatusOplog;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "cmds", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusCmdItem;", "(Ljava/util/LinkedList;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusOplogReq;", "response", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusOplogResp;", "getResponse", "()Lcom/tencent/mm/plugin/textstatus/proto/TextStatusOplogResp;", "setResponse", "(Lcom/tencent/mm/plugin/textstatus/proto/TextStatusOplogResp;)V", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "print", "Companion", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends p
  implements m
{
  public static final a TiF;
  private final be TiG;
  public bf TiH;
  private h callback;
  private final c oDw;
  
  static
  {
    AppMethodBeat.i(290865);
    TiF = new a((byte)0);
    AppMethodBeat.o(290865);
  }
  
  public b(LinkedList<u> paramLinkedList)
  {
    AppMethodBeat.i(290854);
    Object localObject = new c.a();
    ((c.a)localObject).funcId = getType();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/textstatusoplog";
    ((c.a)localObject).otE = ((a)new be());
    ((c.a)localObject).otF = ((a)new bf());
    localObject = ((c.a)localObject).bEF();
    kotlin.g.b.s.s(localObject, "commReqRespBuilder.buildInstance()");
    this.oDw = ((c)localObject);
    localObject = c.b.b(this.oDw.otB);
    if (localObject == null)
    {
      paramLinkedList = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.textstatus.proto.TextStatusOplogReq");
      AppMethodBeat.o(290854);
      throw paramLinkedList;
    }
    this.TiG = ((be)localObject);
    this.TiG.Tqg = paramLinkedList;
    Log.i("MicroMsg.TextStatus.NetSceneTextStatusOplog", kotlin.g.b.s.X("req cmds:", bY(paramLinkedList)));
    AppMethodBeat.o(290854);
  }
  
  private static String bY(LinkedList<u> paramLinkedList)
  {
    AppMethodBeat.i(290861);
    kotlin.g.b.s.u(paramLinkedList, "<this>");
    StringBuilder localStringBuilder = new StringBuilder("items:");
    paramLinkedList = ((Iterable)paramLinkedList).iterator();
    while (paramLinkedList.hasNext())
    {
      u localu = (u)paramLinkedList.next();
      localStringBuilder.append(localu + '-' + localu.Tps + ',');
    }
    paramLinkedList = localStringBuilder.toString();
    kotlin.g.b.s.s(paramLinkedList, "sb.toString()");
    AppMethodBeat.o(290861);
    return paramLinkedList;
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(290873);
    kotlin.g.b.s.u(paramg, "dispatcher");
    kotlin.g.b.s.u(paramh, "callback");
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.oDw, (m)this);
    AppMethodBeat.o(290873);
    return i;
  }
  
  public final int getType()
  {
    return 5907;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    paramArrayOfByte = null;
    AppMethodBeat.i(290879);
    kotlin.g.b.s.u(params, "rr");
    Log.i("MicroMsg.TextStatus.NetSceneTextStatusOplog", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    Object localObject;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = c.c.b(this.oDw.otC);
      if (!(params instanceof bf)) {
        break label153;
      }
      params = (bf)params;
      this.TiH = params;
      localObject = this.TiH;
      if (localObject != null) {
        break label159;
      }
      params = paramArrayOfByte;
    }
    for (;;)
    {
      Log.i("MicroMsg.TextStatus.NetSceneTextStatusOplog", kotlin.g.b.s.X("rsp:", params));
      params = this.callback;
      if (params != null) {
        params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
      }
      AppMethodBeat.o(290879);
      return;
      label153:
      params = null;
      break;
      label159:
      kotlin.g.b.s.u(localObject, "<this>");
      params = new StringBuilder("items:");
      paramArrayOfByte = ((bf)localObject).Tqh;
      if (paramArrayOfByte != null)
      {
        paramArrayOfByte = ((Iterable)paramArrayOfByte).iterator();
        while (paramArrayOfByte.hasNext())
        {
          localObject = (v)paramArrayOfByte.next();
          params.append(localObject + '-' + ((v)localObject).Tps + '-' + ((v)localObject).wuz + '-' + ((v)localObject).wuA);
        }
      }
      params = params.toString();
      kotlin.g.b.s.s(params, "sb.toString()");
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/conversation/cgi/NetSceneTextStatusOplog$Companion;", "", "()V", "TAG", "", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.conversation.b.b
 * JD-Core Version:    0.7.0.1
 */