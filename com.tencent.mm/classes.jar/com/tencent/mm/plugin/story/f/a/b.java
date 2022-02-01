package com.tencent.mm.plugin.story.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.a;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.story.f.j;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.k;
import com.tencent.mm.plugin.story.i.f;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.enc;
import com.tencent.mm.protocal.protobuf.end;
import com.tencent.mm.protocal.protobuf.ene;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.t;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryChatRoomSync;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "chatRoom", "", "(Ljava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getChatRoom", "()Ljava/lang/String;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResp", "Lcom/tencent/mm/protocal/protobuf/StoryChatRoomSyncResponse;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-story_release"})
public final class b
  extends q
  implements com.tencent.mm.network.m
{
  public static final a LHB;
  private static final String TAG = "MicroMsg.StoryCgi.NetSceneStoryChatRoomSync";
  private i callback;
  public final String mMI;
  public final d rr;
  
  static
  {
    AppMethodBeat.i(118799);
    LHB = new a((byte)0);
    TAG = "MicroMsg.StoryCgi.NetSceneStoryChatRoomSync";
    AppMethodBeat.o(118799);
  }
  
  public b(String paramString)
  {
    AppMethodBeat.i(118798);
    this.mMI = paramString;
    paramString = new d.a();
    paramString.c((a)new end());
    paramString.d((a)new ene());
    paramString.TW("/cgi-bin/micromsg-bin/mmstorychatroomsync");
    paramString.vD(998);
    paramString.vF(0);
    paramString.vG(0);
    paramString = paramString.bgN();
    p.j(paramString, "builder.buildInstance()");
    this.rr = paramString;
    paramString = this.rr.bhX();
    if (paramString == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryChatRoomSyncRequest");
      AppMethodBeat.o(118798);
      throw paramString;
    }
    end localend = (end)paramString;
    paramString = j.LGA;
    String str = j.b.fOo();
    paramString = j.LGA;
    paramString = j.b.gcy().bdF(this.mMI);
    localend.UserName = str;
    localend.RIi = this.mMI;
    paramString = paramString.field_extbuf;
    if (paramString != null)
    {
      paramString = z.aN(paramString);
      if (paramString != null) {}
    }
    else
    {
      paramString = null;
    }
    for (;;)
    {
      localend.UpS = paramString;
      Log.i(TAG, "req userName " + str + " chatRoomName " + this.mMI + " buf " + localend.UpS);
      AppMethodBeat.o(118798);
      return;
    }
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(118797);
    p.k(paramg, "dispatcher");
    p.k(parami, "callback");
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
      paramArrayOfByte = (ene)this.rr.bhY();
      if (paramArrayOfByte != null)
      {
        params = j.LGA;
        Object localObject = j.b.gcy().bdF(this.mMI);
        params = paramArrayOfByte.UpS;
        if (params != null) {}
        try
        {
          for (params = params.Tkb.UH;; params = null)
          {
            ((com.tencent.mm.plugin.story.i.l)localObject).field_extbuf = params;
            Log.i(TAG, "onGYNetEnd: count " + paramArrayOfByte.UpT);
            if (paramInt1 == 0) {
              break label496;
            }
            ((com.tencent.mm.plugin.story.i.l)localObject).field_nextSyncTime = (60000L + System.currentTimeMillis());
            params = j.LGA;
            j.b.gcy().replace((IAutoDBItem)localObject);
            Log.i(TAG, "response: count " + paramArrayOfByte.UpT + ", interval " + paramArrayOfByte.UpV);
            params = paramArrayOfByte.UpU;
            p.j(params, "resp.SyncInfoList");
            paramArrayOfByte = ((Iterable)params).iterator();
            for (;;)
            {
              if (!paramArrayOfByte.hasNext()) {
                break label524;
              }
              localObject = (enc)paramArrayOfByte.next();
              if (localObject == null) {
                break;
              }
              params = ((enc)localObject).UserName;
              if ((params != null) && (((enc)localObject).ThumbUrl != null))
              {
                params = k.LGJ;
                params = ((enc)localObject).UserName;
                p.j(params, "it.UserName");
                params = k.bcW(params);
                Log.d(TAG, "fetch " + ((enc)localObject).UserName + ' ' + ((enc)localObject).UpP + ' ' + ((enc)localObject).UpQ + ", oldId " + params.field_syncId);
                if (params.field_syncId != ((enc)localObject).UpP)
                {
                  params = k.LGJ;
                  params = ((enc)localObject).UserName;
                  p.j(params, "it.UserName");
                  k.a(params, ((enc)localObject).UpP, ((enc)localObject).UpQ, ((enc)localObject).ThumbUrl, ((enc)localObject).CPs, 0L);
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
            label496:
            ((com.tencent.mm.plugin.story.i.l)localObject).field_nextSyncTime = (paramArrayOfByte.UpV * 1000L + System.currentTimeMillis());
            continue;
            params = null;
          }
        }
      }
    }
    label524:
    params = this.callback;
    if (params == null) {
      p.bGy("callback");
    }
    params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
    AppMethodBeat.o(118796);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryChatRoomSync$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.a.b
 * JD-Core Version:    0.7.0.1
 */