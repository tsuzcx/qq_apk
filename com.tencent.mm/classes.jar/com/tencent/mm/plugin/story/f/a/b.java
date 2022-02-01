package com.tencent.mm.plugin.story.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.story.f.j;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.i.f;
import com.tencent.mm.plugin.story.i.m;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.ddg;
import com.tencent.mm.protocal.protobuf.ddh;
import com.tencent.mm.protocal.protobuf.ddi;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ac;
import d.v;
import java.util.Iterator;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryChatRoomSync;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "chatRoom", "", "(Ljava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getChatRoom", "()Ljava/lang/String;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResp", "Lcom/tencent/mm/protocal/protobuf/StoryChatRoomSyncResponse;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-story_release"})
public final class b
  extends n
  implements com.tencent.mm.network.k
{
  private static final String TAG = "MicroMsg.StoryCgi.NetSceneStoryChatRoomSync";
  public static final b.a ztk;
  private g callback;
  public final String iEB;
  public final com.tencent.mm.ak.b rr;
  
  static
  {
    AppMethodBeat.i(118799);
    ztk = new b.a((byte)0);
    TAG = "MicroMsg.StoryCgi.NetSceneStoryChatRoomSync";
    AppMethodBeat.o(118799);
  }
  
  public b(String paramString)
  {
    AppMethodBeat.i(118798);
    this.iEB = paramString;
    paramString = new com.tencent.mm.ak.b.a();
    paramString.c((a)new ddh());
    paramString.d((a)new ddi());
    paramString.Am("/cgi-bin/micromsg-bin/mmstorychatroomsync");
    paramString.op(998);
    paramString.or(0);
    paramString.os(0);
    paramString = paramString.aAz();
    d.g.b.k.g(paramString, "builder.buildInstance()");
    this.rr = paramString;
    paramString = this.rr.aBC();
    if (paramString == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryChatRoomSyncRequest");
      AppMethodBeat.o(118798);
      throw paramString;
    }
    ddh localddh = (ddh)paramString;
    paramString = j.zsh;
    String str = j.b.dHx();
    paramString = j.zsh;
    paramString = j.b.dVG().axj(this.iEB);
    localddh.ncR = str;
    localddh.DPx = this.iEB;
    paramString = paramString.field_extbuf;
    if (paramString != null)
    {
      paramString = z.al(paramString);
      if (paramString != null) {}
    }
    else
    {
      paramString = null;
    }
    for (;;)
    {
      localddh.FMV = paramString;
      ac.i(TAG, "req userName " + str + " chatRoomName " + this.iEB + " buf " + localddh.FMV);
      AppMethodBeat.o(118798);
      return;
    }
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(118797);
    d.g.b.k.h(parame, "dispatcher");
    d.g.b.k.h(paramg, "callback");
    this.callback = paramg;
    int i = dispatch(parame, (q)this.rr, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(118797);
    return i;
  }
  
  public final int getType()
  {
    return 998;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(118796);
    ac.i(TAG, "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      paramInt1 = 1;
    }
    for (;;)
    {
      paramArrayOfByte = (ddi)this.rr.aBD();
      if (paramArrayOfByte != null)
      {
        paramq = j.zsh;
        Object localObject = j.b.dVG().axj(this.iEB);
        paramq = paramArrayOfByte.FMV;
        if (paramq != null) {}
        try
        {
          for (paramq = paramq.getBufferToBytes();; paramq = null)
          {
            ((com.tencent.mm.plugin.story.i.l)localObject).field_extbuf = paramq;
            ac.i(TAG, "onGYNetEnd: count " + paramArrayOfByte.FMW);
            if (paramInt1 == 0) {
              break label493;
            }
            ((com.tencent.mm.plugin.story.i.l)localObject).field_nextSyncTime = (60000L + System.currentTimeMillis());
            paramq = j.zsh;
            j.b.dVG().replace((c)localObject);
            ac.i(TAG, "response: count " + paramArrayOfByte.FMW + ", interval " + paramArrayOfByte.FMY);
            paramq = paramArrayOfByte.FMX;
            d.g.b.k.g(paramq, "resp.SyncInfoList");
            paramArrayOfByte = ((Iterable)paramq).iterator();
            for (;;)
            {
              if (!paramArrayOfByte.hasNext()) {
                break label521;
              }
              localObject = (ddg)paramArrayOfByte.next();
              if (localObject == null) {
                break;
              }
              paramq = ((ddg)localObject).ncR;
              if ((paramq != null) && (((ddg)localObject).ThumbUrl != null))
              {
                paramq = com.tencent.mm.plugin.story.f.k.zsq;
                paramq = ((ddg)localObject).ncR;
                d.g.b.k.g(paramq, "it.UserName");
                paramq = com.tencent.mm.plugin.story.f.k.awy(paramq);
                ac.d(TAG, "fetch " + ((ddg)localObject).ncR + ' ' + ((ddg)localObject).FMS + ' ' + ((ddg)localObject).FMT + ", oldId " + paramq.field_syncId);
                if (paramq.field_syncId != ((ddg)localObject).FMS)
                {
                  paramq = com.tencent.mm.plugin.story.f.k.zsq;
                  paramq = ((ddg)localObject).ncR;
                  d.g.b.k.g(paramq, "it.UserName");
                  com.tencent.mm.plugin.story.f.k.a(paramq, ((ddg)localObject).FMS, ((ddg)localObject).FMT, ((ddg)localObject).ThumbUrl, ((ddg)localObject).tjt, 0L);
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
            ac.l("safeBufferToByte", "", new Object[] { paramq });
            paramq = null;
            continue;
            label493:
            ((com.tencent.mm.plugin.story.i.l)localObject).field_nextSyncTime = (paramArrayOfByte.FMY * 1000L + System.currentTimeMillis());
            continue;
            paramq = null;
          }
        }
      }
    }
    label521:
    paramq = this.callback;
    if (paramq == null) {
      d.g.b.k.aVY("callback");
    }
    paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
    AppMethodBeat.o(118796);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.a.b
 * JD-Core Version:    0.7.0.1
 */