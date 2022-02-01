package com.tencent.mm.plugin.story.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.story.f.j;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.k;
import com.tencent.mm.plugin.story.i.f;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.edb;
import com.tencent.mm.protocal.protobuf.edc;
import com.tencent.mm.protocal.protobuf.edd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.t;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryChatRoomSync;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "chatRoom", "", "(Ljava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getChatRoom", "()Ljava/lang/String;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResp", "Lcom/tencent/mm/protocal/protobuf/StoryChatRoomSyncResponse;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-story_release"})
public final class b
  extends q
  implements com.tencent.mm.network.m
{
  public static final a Fnz;
  private static final String TAG = "MicroMsg.StoryCgi.NetSceneStoryChatRoomSync";
  private i callback;
  public final String jVv;
  public final d rr;
  
  static
  {
    AppMethodBeat.i(118799);
    Fnz = new a((byte)0);
    TAG = "MicroMsg.StoryCgi.NetSceneStoryChatRoomSync";
    AppMethodBeat.o(118799);
  }
  
  public b(String paramString)
  {
    AppMethodBeat.i(118798);
    this.jVv = paramString;
    paramString = new d.a();
    paramString.c((a)new edc());
    paramString.d((a)new edd());
    paramString.MB("/cgi-bin/micromsg-bin/mmstorychatroomsync");
    paramString.sG(998);
    paramString.sI(0);
    paramString.sJ(0);
    paramString = paramString.aXF();
    p.g(paramString, "builder.buildInstance()");
    this.rr = paramString;
    paramString = this.rr.aYJ();
    if (paramString == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryChatRoomSyncRequest");
      AppMethodBeat.o(118798);
      throw paramString;
    }
    edc localedc = (edc)paramString;
    paramString = j.Fmy;
    String str = j.b.fau();
    paramString = j.Fmy;
    paramString = j.b.foe().aSB(this.jVv);
    localedc.UserName = str;
    localedc.KGO = this.jVv;
    paramString = paramString.field_extbuf;
    if (paramString != null)
    {
      paramString = z.aC(paramString);
      if (paramString != null) {}
    }
    else
    {
      paramString = null;
    }
    for (;;)
    {
      localedc.Ndv = paramString;
      Log.i(TAG, "req userName " + str + " chatRoomName " + this.jVv + " buf " + localedc.Ndv);
      AppMethodBeat.o(118798);
      return;
    }
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(118797);
    p.h(paramg, "dispatcher");
    p.h(parami, "callback");
    this.callback = parami;
    int i = dispatch(paramg, (s)this.rr, (com.tencent.mm.network.m)this);
    AppMethodBeat.o(118797);
    return i;
  }
  
  public final int getType()
  {
    return 998;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(118796);
    Log.i(TAG, "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      paramInt1 = 1;
    }
    for (;;)
    {
      paramArrayOfByte = (edd)this.rr.aYK();
      if (paramArrayOfByte != null)
      {
        params = j.Fmy;
        Object localObject = j.b.foe().aSB(this.jVv);
        params = paramArrayOfByte.Ndv;
        if (params != null) {}
        try
        {
          for (params = params.getBufferToBytes();; params = null)
          {
            ((com.tencent.mm.plugin.story.i.l)localObject).field_extbuf = params;
            Log.i(TAG, "onGYNetEnd: count " + paramArrayOfByte.Ndw);
            if (paramInt1 == 0) {
              break label493;
            }
            ((com.tencent.mm.plugin.story.i.l)localObject).field_nextSyncTime = (60000L + System.currentTimeMillis());
            params = j.Fmy;
            j.b.foe().replace((IAutoDBItem)localObject);
            Log.i(TAG, "response: count " + paramArrayOfByte.Ndw + ", interval " + paramArrayOfByte.Ndy);
            params = paramArrayOfByte.Ndx;
            p.g(params, "resp.SyncInfoList");
            paramArrayOfByte = ((Iterable)params).iterator();
            for (;;)
            {
              if (!paramArrayOfByte.hasNext()) {
                break label521;
              }
              localObject = (edb)paramArrayOfByte.next();
              if (localObject == null) {
                break;
              }
              params = ((edb)localObject).UserName;
              if ((params != null) && (((edb)localObject).ThumbUrl != null))
              {
                params = k.FmH;
                params = ((edb)localObject).UserName;
                p.g(params, "it.UserName");
                params = k.aRS(params);
                Log.d(TAG, "fetch " + ((edb)localObject).UserName + ' ' + ((edb)localObject).Nds + ' ' + ((edb)localObject).Ndt + ", oldId " + params.field_syncId);
                if (params.field_syncId != ((edb)localObject).Nds)
                {
                  params = k.FmH;
                  params = ((edb)localObject).UserName;
                  p.g(params, "it.UserName");
                  k.a(params, ((edb)localObject).Nds, ((edb)localObject).Ndt, ((edb)localObject).ThumbUrl, ((edb)localObject).xLk, 0L);
                }
              }
            }
            paramInt1 = 0;
            break;
          }
        }
        catch (Exception params)
        {
          for (;;)
          {
            Log.printDebugStack("safeBufferToByte", "", new Object[] { params });
            params = null;
            continue;
            label493:
            ((com.tencent.mm.plugin.story.i.l)localObject).field_nextSyncTime = (paramArrayOfByte.Ndy * 1000L + System.currentTimeMillis());
            continue;
            params = null;
          }
        }
      }
    }
    label521:
    params = this.callback;
    if (params == null) {
      p.btv("callback");
    }
    params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
    AppMethodBeat.o(118796);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryChatRoomSync$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.a.b
 * JD-Core Version:    0.7.0.1
 */