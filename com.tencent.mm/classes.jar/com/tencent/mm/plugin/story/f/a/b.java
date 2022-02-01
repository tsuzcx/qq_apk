package com.tencent.mm.plugin.story.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.story.f.j;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.i.m;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dit;
import com.tencent.mm.protocal.protobuf.diu;
import com.tencent.mm.protocal.protobuf.div;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.v;
import java.util.Iterator;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryChatRoomSync;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "chatRoom", "", "(Ljava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getChatRoom", "()Ljava/lang/String;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResp", "Lcom/tencent/mm/protocal/protobuf/StoryChatRoomSyncResponse;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-story_release"})
public final class b
  extends n
  implements com.tencent.mm.network.k
{
  public static final a ALe;
  private static final String TAG = "MicroMsg.StoryCgi.NetSceneStoryChatRoomSync";
  private com.tencent.mm.al.f callback;
  public final String iXK;
  public final com.tencent.mm.al.b rr;
  
  static
  {
    AppMethodBeat.i(118799);
    ALe = new a((byte)0);
    TAG = "MicroMsg.StoryCgi.NetSceneStoryChatRoomSync";
    AppMethodBeat.o(118799);
  }
  
  public b(String paramString)
  {
    AppMethodBeat.i(118798);
    this.iXK = paramString;
    paramString = new com.tencent.mm.al.b.a();
    paramString.c((a)new diu());
    paramString.d((a)new div());
    paramString.Dl("/cgi-bin/micromsg-bin/mmstorychatroomsync");
    paramString.oP(998);
    paramString.oR(0);
    paramString.oS(0);
    paramString = paramString.aDC();
    p.g(paramString, "builder.buildInstance()");
    this.rr = paramString;
    paramString = this.rr.aEE();
    if (paramString == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryChatRoomSyncRequest");
      AppMethodBeat.o(118798);
      throw paramString;
    }
    diu localdiu = (diu)paramString;
    paramString = j.AKb;
    String str = j.b.dTJ();
    paramString = j.AKb;
    paramString = j.b.ehV().aCn(this.iXK);
    localdiu.nDo = str;
    localdiu.FuL = this.iXK;
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
      localdiu.HxG = paramString;
      ad.i(TAG, "req userName " + str + " chatRoomName " + this.iXK + " buf " + localdiu.HxG);
      AppMethodBeat.o(118798);
      return;
    }
  }
  
  public final int doScene(e parame, com.tencent.mm.al.f paramf)
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
    ad.i(TAG, "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      paramInt1 = 1;
    }
    for (;;)
    {
      paramArrayOfByte = (div)this.rr.aEF();
      if (paramArrayOfByte != null)
      {
        paramq = j.AKb;
        Object localObject = j.b.ehV().aCn(this.iXK);
        paramq = paramArrayOfByte.HxG;
        if (paramq != null) {}
        try
        {
          for (paramq = paramq.getBufferToBytes();; paramq = null)
          {
            ((com.tencent.mm.plugin.story.i.l)localObject).field_extbuf = paramq;
            ad.i(TAG, "onGYNetEnd: count " + paramArrayOfByte.HxH);
            if (paramInt1 == 0) {
              break label493;
            }
            ((com.tencent.mm.plugin.story.i.l)localObject).field_nextSyncTime = (60000L + System.currentTimeMillis());
            paramq = j.AKb;
            j.b.ehV().replace((c)localObject);
            ad.i(TAG, "response: count " + paramArrayOfByte.HxH + ", interval " + paramArrayOfByte.HxJ);
            paramq = paramArrayOfByte.HxI;
            p.g(paramq, "resp.SyncInfoList");
            paramArrayOfByte = ((Iterable)paramq).iterator();
            for (;;)
            {
              if (!paramArrayOfByte.hasNext()) {
                break label521;
              }
              localObject = (dit)paramArrayOfByte.next();
              if (localObject == null) {
                break;
              }
              paramq = ((dit)localObject).nDo;
              if ((paramq != null) && (((dit)localObject).ThumbUrl != null))
              {
                paramq = com.tencent.mm.plugin.story.f.k.AKk;
                paramq = ((dit)localObject).nDo;
                p.g(paramq, "it.UserName");
                paramq = com.tencent.mm.plugin.story.f.k.aBD(paramq);
                ad.d(TAG, "fetch " + ((dit)localObject).nDo + ' ' + ((dit)localObject).HxD + ' ' + ((dit)localObject).HxE + ", oldId " + paramq.field_syncId);
                if (paramq.field_syncId != ((dit)localObject).HxD)
                {
                  paramq = com.tencent.mm.plugin.story.f.k.AKk;
                  paramq = ((dit)localObject).nDo;
                  p.g(paramq, "it.UserName");
                  com.tencent.mm.plugin.story.f.k.a(paramq, ((dit)localObject).HxD, ((dit)localObject).HxE, ((dit)localObject).ThumbUrl, ((dit)localObject).uht, 0L);
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
            ((com.tencent.mm.plugin.story.i.l)localObject).field_nextSyncTime = (paramArrayOfByte.HxJ * 1000L + System.currentTimeMillis());
            continue;
            paramq = null;
          }
        }
      }
    }
    label521:
    paramq = this.callback;
    if (paramq == null) {
      p.bcb("callback");
    }
    paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
    AppMethodBeat.o(118796);
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryChatRoomSync$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.a.b
 * JD-Core Version:    0.7.0.1
 */