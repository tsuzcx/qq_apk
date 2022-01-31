package com.tencent.mm.plugin.story.model.a;

import a.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.bv.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.story.model.j.b;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cgs;
import com.tencent.mm.protocal.protobuf.cgt;
import com.tencent.mm.protocal.protobuf.cgu;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryChatRoomSync;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "chatRoom", "", "(Ljava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getChatRoom", "()Ljava/lang/String;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResp", "Lcom/tencent/mm/protocal/protobuf/StoryChatRoomSyncResponse;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-story_release"})
public final class c
  extends com.tencent.mm.ai.m
  implements com.tencent.mm.network.k
{
  private static final String TAG = "MicroMsg.StoryCgi.NetSceneStoryChatRoomSync";
  public static final c.a sxa;
  private com.tencent.mm.ai.f callback;
  public final String grA;
  public final b rr;
  
  static
  {
    AppMethodBeat.i(109212);
    sxa = new c.a((byte)0);
    TAG = "MicroMsg.StoryCgi.NetSceneStoryChatRoomSync";
    AppMethodBeat.o(109212);
  }
  
  public c(String paramString)
  {
    AppMethodBeat.i(109211);
    this.grA = paramString;
    paramString = new b.a();
    paramString.a((a)new cgt());
    paramString.b((a)new cgu());
    paramString.rl("/cgi-bin/micromsg-bin/mmstorychatroomsync");
    paramString.kT(998);
    paramString.kU(0);
    paramString.kV(0);
    paramString = paramString.ado();
    a.f.b.j.p(paramString, "builder.buildInstance()");
    this.rr = paramString;
    paramString = this.rr.adm();
    if (paramString == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryChatRoomSyncRequest");
      AppMethodBeat.o(109211);
      throw paramString;
    }
    cgt localcgt = (cgt)paramString;
    paramString = com.tencent.mm.plugin.story.model.j.svi;
    String str = j.b.coK();
    paramString = com.tencent.mm.plugin.story.model.j.svi;
    paramString = j.b.cAD().adH(this.grA);
    localcgt.jJA = str;
    localcgt.wot = this.grA;
    paramString = paramString.field_extbuf;
    if (paramString != null)
    {
      paramString = aa.ac(paramString);
      if (paramString != null) {}
    }
    else
    {
      paramString = null;
    }
    for (;;)
    {
      localcgt.xRz = paramString;
      ab.i(TAG, "req userName " + str + " chatRoomName " + this.grA + " buf " + localcgt.xRz);
      AppMethodBeat.o(109211);
      return;
    }
  }
  
  public final int doScene(e parame, com.tencent.mm.ai.f paramf)
  {
    AppMethodBeat.i(109210);
    a.f.b.j.q(parame, "dispatcher");
    a.f.b.j.q(paramf, "callback");
    this.callback = paramf;
    int i = dispatch(parame, (q)this.rr, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(109210);
    return i;
  }
  
  public final int getType()
  {
    return 998;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(109209);
    ab.i(TAG, "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      paramInt1 = 1;
    }
    for (;;)
    {
      paramArrayOfByte = (cgu)this.rr.adn();
      if (paramArrayOfByte != null)
      {
        paramq = com.tencent.mm.plugin.story.model.j.svi;
        Object localObject = j.b.cAD().adH(this.grA);
        paramq = paramArrayOfByte.xRz;
        if (paramq != null) {}
        try
        {
          for (paramq = paramq.getBufferToBytes();; paramq = null)
          {
            ((com.tencent.mm.plugin.story.h.l)localObject).field_extbuf = paramq;
            ab.i(TAG, "onGYNetEnd: count " + paramArrayOfByte.xRA);
            if (paramInt1 == 0) {
              break label493;
            }
            ((com.tencent.mm.plugin.story.h.l)localObject).field_nextSyncTime = (60000L + System.currentTimeMillis());
            paramq = com.tencent.mm.plugin.story.model.j.svi;
            j.b.cAD().replace((com.tencent.mm.sdk.e.c)localObject);
            ab.i(TAG, "response: count " + paramArrayOfByte.xRA + ", interval " + paramArrayOfByte.xRC);
            paramq = paramArrayOfByte.xRB;
            a.f.b.j.p(paramq, "resp.SyncInfoList");
            paramArrayOfByte = ((Iterable)paramq).iterator();
            for (;;)
            {
              if (!paramArrayOfByte.hasNext()) {
                break label521;
              }
              localObject = (cgs)paramArrayOfByte.next();
              if (localObject == null) {
                break;
              }
              paramq = ((cgs)localObject).jJA;
              if ((paramq != null) && (((cgs)localObject).ThumbUrl != null))
              {
                paramq = com.tencent.mm.plugin.story.model.k.svr;
                paramq = ((cgs)localObject).jJA;
                a.f.b.j.p(paramq, "it.UserName");
                paramq = com.tencent.mm.plugin.story.model.k.acU(paramq);
                ab.d(TAG, "fetch " + ((cgs)localObject).jJA + ' ' + ((cgs)localObject).xRw + ' ' + ((cgs)localObject).xRx + ", oldId " + paramq.field_syncId);
                if (paramq.field_syncId != ((cgs)localObject).xRw)
                {
                  paramq = com.tencent.mm.plugin.story.model.k.svr;
                  paramq = ((cgs)localObject).jJA;
                  a.f.b.j.p(paramq, "it.UserName");
                  com.tencent.mm.plugin.story.model.k.a(paramq, ((cgs)localObject).xRw, ((cgs)localObject).xRx, ((cgs)localObject).ThumbUrl, ((cgs)localObject).nrZ, 0L);
                }
              }
            }
            paramInt1 = 0;
            break;
          }
        }
        catch (Exception paramq)
        {
          for (;;)
          {
            ab.a("safeBufferToByte", "", new Object[] { paramq });
            paramq = null;
            continue;
            label493:
            ((com.tencent.mm.plugin.story.h.l)localObject).field_nextSyncTime = (paramArrayOfByte.xRC * 1000L + System.currentTimeMillis());
            continue;
            paramq = null;
          }
        }
      }
    }
    label521:
    paramq = this.callback;
    if (paramq == null) {
      a.f.b.j.ays("callback");
    }
    paramq.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.ai.m)this);
    AppMethodBeat.o(109209);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.a.c
 * JD-Core Version:    0.7.0.1
 */