package com.tencent.mm.plugin.story.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.story.f.j;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.i.f;
import com.tencent.mm.plugin.story.i.m;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cxu;
import com.tencent.mm.protocal.protobuf.cxv;
import com.tencent.mm.protocal.protobuf.cxw;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ad;
import d.v;
import java.util.Iterator;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryChatRoomSync;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "chatRoom", "", "(Ljava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getChatRoom", "()Ljava/lang/String;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResp", "Lcom/tencent/mm/protocal/protobuf/StoryChatRoomSyncResponse;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-story_release"})
public final class b
  extends n
  implements com.tencent.mm.network.k
{
  private static final String TAG = "MicroMsg.StoryCgi.NetSceneStoryChatRoomSync";
  public static final a ygk;
  private g callback;
  public final String ies;
  public final com.tencent.mm.al.b rr;
  
  static
  {
    AppMethodBeat.i(118799);
    ygk = new a((byte)0);
    TAG = "MicroMsg.StoryCgi.NetSceneStoryChatRoomSync";
    AppMethodBeat.o(118799);
  }
  
  public b(String paramString)
  {
    AppMethodBeat.i(118798);
    this.ies = paramString;
    paramString = new com.tencent.mm.al.b.a();
    paramString.c((a)new cxv());
    paramString.d((a)new cxw());
    paramString.wg("/cgi-bin/micromsg-bin/mmstorychatroomsync");
    paramString.nB(998);
    paramString.nD(0);
    paramString.nE(0);
    paramString = paramString.atI();
    d.g.b.k.g(paramString, "builder.buildInstance()");
    this.rr = paramString;
    paramString = this.rr.auL();
    if (paramString == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryChatRoomSyncRequest");
      AppMethodBeat.o(118798);
      throw paramString;
    }
    cxv localcxv = (cxv)paramString;
    paramString = j.yfh;
    String str = j.b.dta();
    paramString = j.yfh;
    paramString = j.b.dHf().asa(this.ies);
    localcxv.mAQ = str;
    localcxv.Cxb = this.ies;
    paramString = paramString.field_extbuf;
    if (paramString != null)
    {
      paramString = z.am(paramString);
      if (paramString != null) {}
    }
    else
    {
      paramString = null;
    }
    for (;;)
    {
      localcxv.EpT = paramString;
      ad.i(TAG, "req userName " + str + " chatRoomName " + this.ies + " buf " + localcxv.EpT);
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
    ad.i(TAG, "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      paramInt1 = 1;
    }
    for (;;)
    {
      paramArrayOfByte = (cxw)this.rr.auM();
      if (paramArrayOfByte != null)
      {
        paramq = j.yfh;
        Object localObject = j.b.dHf().asa(this.ies);
        paramq = paramArrayOfByte.EpT;
        if (paramq != null) {}
        try
        {
          for (paramq = paramq.getBufferToBytes();; paramq = null)
          {
            ((com.tencent.mm.plugin.story.i.l)localObject).field_extbuf = paramq;
            ad.i(TAG, "onGYNetEnd: count " + paramArrayOfByte.EpU);
            if (paramInt1 == 0) {
              break label493;
            }
            ((com.tencent.mm.plugin.story.i.l)localObject).field_nextSyncTime = (60000L + System.currentTimeMillis());
            paramq = j.yfh;
            j.b.dHf().replace((c)localObject);
            ad.i(TAG, "response: count " + paramArrayOfByte.EpU + ", interval " + paramArrayOfByte.EpW);
            paramq = paramArrayOfByte.EpV;
            d.g.b.k.g(paramq, "resp.SyncInfoList");
            paramArrayOfByte = ((Iterable)paramq).iterator();
            for (;;)
            {
              if (!paramArrayOfByte.hasNext()) {
                break label521;
              }
              localObject = (cxu)paramArrayOfByte.next();
              if (localObject == null) {
                break;
              }
              paramq = ((cxu)localObject).mAQ;
              if ((paramq != null) && (((cxu)localObject).ThumbUrl != null))
              {
                paramq = com.tencent.mm.plugin.story.f.k.yfq;
                paramq = ((cxu)localObject).mAQ;
                d.g.b.k.g(paramq, "it.UserName");
                paramq = com.tencent.mm.plugin.story.f.k.arp(paramq);
                ad.d(TAG, "fetch " + ((cxu)localObject).mAQ + ' ' + ((cxu)localObject).EpQ + ' ' + ((cxu)localObject).EpR + ", oldId " + paramq.field_syncId);
                if (paramq.field_syncId != ((cxu)localObject).EpQ)
                {
                  paramq = com.tencent.mm.plugin.story.f.k.yfq;
                  paramq = ((cxu)localObject).mAQ;
                  d.g.b.k.g(paramq, "it.UserName");
                  com.tencent.mm.plugin.story.f.k.a(paramq, ((cxu)localObject).EpQ, ((cxu)localObject).EpR, ((cxu)localObject).ThumbUrl, ((cxu)localObject).sbz, 0L);
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
            ad.l("safeBufferToByte", "", new Object[] { paramq });
            paramq = null;
            continue;
            label493:
            ((com.tencent.mm.plugin.story.i.l)localObject).field_nextSyncTime = (paramArrayOfByte.EpW * 1000L + System.currentTimeMillis());
            continue;
            paramq = null;
          }
        }
      }
    }
    label521:
    paramq = this.callback;
    if (paramq == null) {
      d.g.b.k.aPZ("callback");
    }
    paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
    AppMethodBeat.o(118796);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryChatRoomSync$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.a.b
 * JD-Core Version:    0.7.0.1
 */