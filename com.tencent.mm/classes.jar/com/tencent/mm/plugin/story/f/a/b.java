package com.tencent.mm.plugin.story.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.story.f.j;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.i.m;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.djo;
import com.tencent.mm.protocal.protobuf.djp;
import com.tencent.mm.protocal.protobuf.djq;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.v;
import java.util.Iterator;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryChatRoomSync;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "chatRoom", "", "(Ljava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getChatRoom", "()Ljava/lang/String;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResp", "Lcom/tencent/mm/protocal/protobuf/StoryChatRoomSyncResponse;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-story_release"})
public final class b
  extends n
  implements com.tencent.mm.network.k
{
  public static final a BcH;
  private static final String TAG = "MicroMsg.StoryCgi.NetSceneStoryChatRoomSync";
  private com.tencent.mm.ak.f callback;
  public final String jaD;
  public final com.tencent.mm.ak.b rr;
  
  static
  {
    AppMethodBeat.i(118799);
    BcH = new a((byte)0);
    TAG = "MicroMsg.StoryCgi.NetSceneStoryChatRoomSync";
    AppMethodBeat.o(118799);
  }
  
  public b(String paramString)
  {
    AppMethodBeat.i(118798);
    this.jaD = paramString;
    paramString = new com.tencent.mm.ak.b.a();
    paramString.c((a)new djp());
    paramString.d((a)new djq());
    paramString.DN("/cgi-bin/micromsg-bin/mmstorychatroomsync");
    paramString.oS(998);
    paramString.oU(0);
    paramString.oV(0);
    paramString = paramString.aDS();
    p.g(paramString, "builder.buildInstance()");
    this.rr = paramString;
    paramString = this.rr.aEU();
    if (paramString == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryChatRoomSyncRequest");
      AppMethodBeat.o(118798);
      throw paramString;
    }
    djp localdjp = (djp)paramString;
    paramString = j.BbE;
    String str = j.b.dXj();
    paramString = j.BbE;
    paramString = j.b.elD().aDG(this.jaD);
    localdjp.nIJ = str;
    localdjp.FNj = this.jaD;
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
      localdjp.HRr = paramString;
      ae.i(TAG, "req userName " + str + " chatRoomName " + this.jaD + " buf " + localdjp.HRr);
      AppMethodBeat.o(118798);
      return;
    }
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.f paramf)
  {
    AppMethodBeat.i(118797);
    p.h(parame, "dispatcher");
    p.h(paramf, "callback");
    this.callback = paramf;
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
    ae.i(TAG, "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      paramInt1 = 1;
    }
    for (;;)
    {
      paramArrayOfByte = (djq)this.rr.aEV();
      if (paramArrayOfByte != null)
      {
        paramq = j.BbE;
        Object localObject = j.b.elD().aDG(this.jaD);
        paramq = paramArrayOfByte.HRr;
        if (paramq != null) {}
        try
        {
          for (paramq = paramq.getBufferToBytes();; paramq = null)
          {
            ((com.tencent.mm.plugin.story.i.l)localObject).field_extbuf = paramq;
            ae.i(TAG, "onGYNetEnd: count " + paramArrayOfByte.HRs);
            if (paramInt1 == 0) {
              break label493;
            }
            ((com.tencent.mm.plugin.story.i.l)localObject).field_nextSyncTime = (60000L + System.currentTimeMillis());
            paramq = j.BbE;
            j.b.elD().replace((c)localObject);
            ae.i(TAG, "response: count " + paramArrayOfByte.HRs + ", interval " + paramArrayOfByte.HRu);
            paramq = paramArrayOfByte.HRt;
            p.g(paramq, "resp.SyncInfoList");
            paramArrayOfByte = ((Iterable)paramq).iterator();
            for (;;)
            {
              if (!paramArrayOfByte.hasNext()) {
                break label521;
              }
              localObject = (djo)paramArrayOfByte.next();
              if (localObject == null) {
                break;
              }
              paramq = ((djo)localObject).nIJ;
              if ((paramq != null) && (((djo)localObject).ThumbUrl != null))
              {
                paramq = com.tencent.mm.plugin.story.f.k.BbN;
                paramq = ((djo)localObject).nIJ;
                p.g(paramq, "it.UserName");
                paramq = com.tencent.mm.plugin.story.f.k.aCW(paramq);
                ae.d(TAG, "fetch " + ((djo)localObject).nIJ + ' ' + ((djo)localObject).HRo + ' ' + ((djo)localObject).HRp + ", oldId " + paramq.field_syncId);
                if (paramq.field_syncId != ((djo)localObject).HRo)
                {
                  paramq = com.tencent.mm.plugin.story.f.k.BbN;
                  paramq = ((djo)localObject).nIJ;
                  p.g(paramq, "it.UserName");
                  com.tencent.mm.plugin.story.f.k.a(paramq, ((djo)localObject).HRo, ((djo)localObject).HRp, ((djo)localObject).ThumbUrl, ((djo)localObject).usR, 0L);
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
            ae.l("safeBufferToByte", "", new Object[] { paramq });
            paramq = null;
            continue;
            label493:
            ((com.tencent.mm.plugin.story.i.l)localObject).field_nextSyncTime = (paramArrayOfByte.HRu * 1000L + System.currentTimeMillis());
            continue;
            paramq = null;
          }
        }
      }
    }
    label521:
    paramq = this.callback;
    if (paramq == null) {
      p.bdF("callback");
    }
    paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
    AppMethodBeat.o(118796);
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryChatRoomSync$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.a.b
 * JD-Core Version:    0.7.0.1
 */