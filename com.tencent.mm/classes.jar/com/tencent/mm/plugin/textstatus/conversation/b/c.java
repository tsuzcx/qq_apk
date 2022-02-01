package com.tencent.mm.plugin.textstatus.conversation.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.a;
import com.tencent.mm.model.cn;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.textstatus.conversation.d.d;
import com.tencent.mm.plugin.textstatus.proto.bi;
import com.tencent.mm.plugin.textstatus.proto.bj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/conversation/cgi/NetSceneTextStatusPrivateChatSend;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "item", "Lcom/tencent/mm/plugin/textstatus/conversation/data/TextStatusGreetingItem;", "(Lcom/tencent/mm/plugin/textstatus/conversation/data/TextStatusGreetingItem;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "getItem", "()Lcom/tencent/mm/plugin/textstatus/conversation/data/TextStatusGreetingItem;", "request", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusPrivateChatSendReq;", "response", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusPrivateChatSendResp;", "getResponse", "()Lcom/tencent/mm/plugin/textstatus/proto/TextStatusPrivateChatSendResp;", "setResponse", "(Lcom/tencent/mm/plugin/textstatus/proto/TextStatusPrivateChatSendResp;)V", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends p
  implements m
{
  public static final c.a TiI;
  private final d TiJ;
  private final bi TiK;
  private bj TiL;
  private h callback;
  private final com.tencent.mm.am.c oDw;
  
  static
  {
    AppMethodBeat.i(290875);
    TiI = new c.a((byte)0);
    AppMethodBeat.o(290875);
  }
  
  public c(d paramd)
  {
    AppMethodBeat.i(290870);
    this.TiJ = paramd;
    paramd = new com.tencent.mm.am.c.a();
    paramd.funcId = getType();
    paramd.uri = "/cgi-bin/micromsg-bin/textstatusprivatechatsend";
    paramd.otE = ((a)new bi());
    paramd.otF = ((a)new bj());
    paramd = paramd.bEF();
    kotlin.g.b.s.s(paramd, "commReqRespBuilder.buildInstance()");
    this.oDw = paramd;
    paramd = c.b.b(this.oDw.otB);
    if (paramd == null)
    {
      paramd = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.textstatus.proto.TextStatusPrivateChatSendReq");
      AppMethodBeat.o(290870);
      throw paramd;
    }
    this.TiK = ((bi)paramd);
    paramd = this.TiK;
    paramd.tag = this.TiJ.field_tag;
    paramd.ToB = this.TiJ.field_source_id;
    paramd.Tpa = this.TiJ.field_card_key;
    paramd.ToW = this.TiJ.field_status_id;
    paramd.Tpb = this.TiJ.field_modify_count;
    paramd.Trm = this.TiJ.field_encUsername;
    paramd.Trn = this.TiJ.field_hash_username;
    paramd.session_id = this.TiJ.field_session_id;
    paramd.Tro = (MD5Util.getMD5String(z.bAM()) + paramd.session_id + this.TiJ.field_newMsgId + '_' + cn.bDu() + "_greetingReply");
    Log.d("MicroMsg.TextStatus.NetSceneTextStatusPrivateChatSend", "req cli_msg_id:" + this.TiK.Tro + " msg_session_id:" + this.TiK.session_id);
    AppMethodBeat.o(290870);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(290887);
    kotlin.g.b.s.u(paramg, "dispatcher");
    kotlin.g.b.s.u(paramh, "callback");
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.oDw, (m)this);
    AppMethodBeat.o(290887);
    return i;
  }
  
  public final int getType()
  {
    return 4290;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(290901);
    kotlin.g.b.s.u(params, "rr");
    Log.i("MicroMsg.TextStatus.NetSceneTextStatusPrivateChatSend", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = c.c.b(this.oDw.otC);
      if (params == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.textstatus.proto.TextStatusPrivateChatSendResp");
        AppMethodBeat.o(290901);
        throw paramString;
      }
      this.TiL = ((bj)params);
    }
    params = this.callback;
    if (params != null) {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
    }
    AppMethodBeat.o(290901);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.conversation.b.c
 * JD-Core Version:    0.7.0.1
 */