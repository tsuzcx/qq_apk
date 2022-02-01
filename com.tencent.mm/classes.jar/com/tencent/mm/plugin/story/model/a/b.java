package com.tencent.mm.plugin.story.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.g;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.story.h.f;
import com.tencent.mm.plugin.story.h.l;
import com.tencent.mm.plugin.story.model.StoryCore;
import com.tencent.mm.plugin.story.model.StoryCore.b;
import com.tencent.mm.plugin.story.model.j;
import com.tencent.mm.protocal.protobuf.fia;
import com.tencent.mm.protocal.protobuf.fib;
import com.tencent.mm.protocal.protobuf.fic;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.util.Iterator;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryChatRoomSync;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "chatRoom", "", "(Ljava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getChatRoom", "()Ljava/lang/String;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResp", "Lcom/tencent/mm/protocal/protobuf/StoryChatRoomSyncResponse;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends p
  implements com.tencent.mm.network.m
{
  public static final a Sld;
  private static final String TAG;
  private h callback;
  public final String pJq;
  public final c rr;
  
  static
  {
    AppMethodBeat.i(118799);
    Sld = new a((byte)0);
    TAG = "MicroMsg.StoryCgi.NetSceneStoryChatRoomSync";
    AppMethodBeat.o(118799);
  }
  
  public b(String paramString)
  {
    AppMethodBeat.i(118798);
    this.pJq = paramString;
    paramString = new c.a();
    paramString.otE = ((a)new fib());
    paramString.otF = ((a)new fic());
    paramString.uri = "/cgi-bin/micromsg-bin/mmstorychatroomsync";
    paramString.funcId = 998;
    paramString.otG = 0;
    paramString.respCmdId = 0;
    paramString = paramString.bEF();
    kotlin.g.b.s.s(paramString, "builder.buildInstance()");
    this.rr = paramString;
    paramString = c.b.b(this.rr.otB);
    if (paramString == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryChatRoomSyncRequest");
      AppMethodBeat.o(118798);
      throw paramString;
    }
    fib localfib = (fib)paramString;
    paramString = StoryCore.SjP;
    String str = StoryCore.b.hgg();
    paramString = StoryCore.SjP;
    paramString = StoryCore.b.hvT().bcr(this.pJq);
    localfib.UserName = str;
    localfib.YFk = this.pJq;
    paramString = paramString.field_extbuf;
    if (paramString == null) {
      paramString = localObject;
    }
    for (;;)
    {
      localfib.abIR = paramString;
      Log.i(TAG, "req userName " + str + " chatRoomName " + this.pJq + " buf " + localfib.abIR);
      AppMethodBeat.o(118798);
      return;
      paramString = w.aN(paramString);
      if (paramString == null) {
        paramString = localObject;
      }
    }
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(118797);
    kotlin.g.b.s.u(paramg, "dispatcher");
    kotlin.g.b.s.u(paramh, "callback");
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.rr, (com.tencent.mm.network.m)this);
    AppMethodBeat.o(118797);
    return i;
  }
  
  public final int getType()
  {
    return 998;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(118796);
    Log.i(TAG, "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    Object localObject;
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      paramInt1 = 1;
      paramArrayOfByte = (fic)c.c.b(this.rr.otC);
      if (paramArrayOfByte == null) {
        break label521;
      }
      params = StoryCore.SjP;
      localObject = StoryCore.b.hvT().bcr(this.pJq);
      params = paramArrayOfByte.abIR;
      if (params != null) {
        break label450;
      }
      params = null;
      label117:
      ((l)localObject).field_extbuf = params;
      Log.i(TAG, kotlin.g.b.s.X("onGYNetEnd: count ", Integer.valueOf(paramArrayOfByte.abIS)));
      if (paramInt1 == 0) {
        break label489;
      }
      ((l)localObject).field_nextSyncTime = (60000L + System.currentTimeMillis());
      label160:
      params = StoryCore.SjP;
      StoryCore.b.hvT().replace((IAutoDBItem)localObject);
      Log.i(TAG, "response: count " + paramArrayOfByte.abIS + ", interval " + paramArrayOfByte.abIU);
      params = paramArrayOfByte.abIT;
      kotlin.g.b.s.s(params, "resp.SyncInfoList");
      paramArrayOfByte = ((Iterable)params).iterator();
    }
    label519:
    for (;;)
    {
      label245:
      if (!paramArrayOfByte.hasNext()) {
        break label521;
      }
      localObject = (fia)paramArrayOfByte.next();
      if (localObject == null) {}
      for (params = null;; params = ((fia)localObject).UserName)
      {
        for (;;)
        {
          if ((params == null) || (((fia)localObject).ThumbUrl == null)) {
            break label519;
          }
          params = j.Skm;
          params = ((fia)localObject).UserName;
          kotlin.g.b.s.s(params, "it.UserName");
          params = j.bbJ(params);
          Log.d(TAG, "fetch " + ((fia)localObject).UserName + ' ' + ((fia)localObject).abIO + ' ' + ((fia)localObject).abIP + ", oldId " + params.field_syncId);
          if (params.field_syncId == ((fia)localObject).abIO) {
            break label245;
          }
          params = j.Skm;
          params = ((fia)localObject).UserName;
          kotlin.g.b.s.s(params, "it.UserName");
          j.a(params, ((fia)localObject).abIO, ((fia)localObject).abIP, ((fia)localObject).ThumbUrl, ((fia)localObject).IJC, 0L);
          break label245;
          paramInt1 = 0;
          break;
          try
          {
            label450:
            params = params.aaxD.Op;
          }
          catch (Exception params)
          {
            Log.printDebugStack("safeBufferToByte", "", new Object[] { params });
            params = null;
          }
        }
        break label117;
        label489:
        ((l)localObject).field_nextSyncTime = (paramArrayOfByte.abIU * 1000L + System.currentTimeMillis());
        break label160;
      }
    }
    label521:
    paramArrayOfByte = this.callback;
    params = paramArrayOfByte;
    if (paramArrayOfByte == null)
    {
      kotlin.g.b.s.bIx("callback");
      params = null;
    }
    params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
    AppMethodBeat.o(118796);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryChatRoomSync$Companion;", "", "()V", "TAG", "", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.a.b
 * JD-Core Version:    0.7.0.1
 */