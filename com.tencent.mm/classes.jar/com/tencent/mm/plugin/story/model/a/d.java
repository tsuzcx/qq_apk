package com.tencent.mm.plugin.story.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.plugin.story.model.m.a;
import com.tencent.mm.protocal.protobuf.fik;
import com.tencent.mm.protocal.protobuf.fil;
import com.tencent.mm.protocal.protobuf.fiz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryDateDetail;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "userName", "", "maxId", "", "date", "(Ljava/lang/String;JLjava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getDate", "()Ljava/lang/String;", "setDate", "(Ljava/lang/String;)V", "forSameMd5Count", "", "fp", "", "getFp", "()Z", "setFp", "(Z)V", "getMaxId", "()J", "setMaxId", "(J)V", "minId", "getMinId", "setMinId", "originMaxId", "recentLimitID", "getRecentLimitID", "setRecentLimitID", "requestMd5", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "sourceType", "getUserName", "setUserName", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "insertList", "", "resp", "Lcom/tencent/mm/protocal/protobuf/StoryDateDetailResponse;", "onGYNetEnd", "netId", "errType", "errCode", "errMsg", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends p
  implements com.tencent.mm.network.m
{
  public static final d.a Slh;
  private static final String TAG;
  private String NjO;
  private String QsM;
  private boolean Qsg;
  private long Qsh;
  private long QtH;
  private long Sli;
  private h callback;
  private long maxId;
  private c rr;
  private int sourceType;
  public String userName;
  
  static
  {
    AppMethodBeat.i(118807);
    Slh = new d.a((byte)0);
    TAG = "MicroMsg.StoryCgi.NetSceneStoryDateDetail";
    AppMethodBeat.o(118807);
  }
  
  public d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(118806);
    this.userName = paramString1;
    this.maxId = 0L;
    this.NjO = paramString2;
    this.QsM = "";
    if (this.maxId == 0L) {
      Log.i(TAG, kotlin.g.b.s.X("fp mUserName ", this.userName));
    }
    for (;;)
    {
      paramString1 = com.tencent.mm.plugin.story.h.a.Sry;
      this.sourceType = com.tencent.mm.plugin.story.h.a.hyu();
      paramString1 = new c.a();
      paramString1.otE = ((com.tencent.mm.bx.a)new fik());
      paramString1.otF = ((com.tencent.mm.bx.a)new fil());
      paramString1.uri = "/cgi-bin/micromsg-bin/mmstorydatedetail";
      paramString1.funcId = 529;
      paramString1.otG = 0;
      paramString1.respCmdId = 0;
      paramString1 = paramString1.bEF();
      kotlin.g.b.s.s(paramString1, "builder.buildInstance()");
      this.rr = paramString1;
      paramString1 = c.b.b(this.rr.otB);
      if (paramString1 != null) {
        break;
      }
      paramString1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryDateDetailRequest");
      AppMethodBeat.o(118806);
      throw paramString1;
      Log.i(TAG, kotlin.g.b.s.X("np mUserName ", this.userName));
    }
    paramString1 = (fik)paramString1;
    paramString1.UserName = this.userName;
    paramString1.abDv = this.maxId;
    try
    {
      paramString2 = Util.getTimeZoneOffset();
      kotlin.g.b.s.s(paramString2, "getTimeZoneOffset()");
      float f = Float.parseFloat(paramString2);
      i = (int)f;
    }
    catch (Exception paramString2)
    {
      for (;;)
      {
        int i = 0;
      }
    }
    paramString1.ytH = i;
    paramString1.ZrX = this.NjO;
    if (this.maxId == 0L) {
      bool = true;
    }
    this.Qsg = bool;
    this.Sli = this.maxId;
    Log.i(TAG, "req.mUserName:" + paramString1.UserName + " req.MaxId:" + paramString1.abDv + " req.TimeZone:" + paramString1.ytH + " req.Date:" + paramString1.ZrX);
    AppMethodBeat.o(118806);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(118804);
    kotlin.g.b.s.u(paramh, "callback");
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.rr, (com.tencent.mm.network.m)this);
    AppMethodBeat.o(118804);
    return i;
  }
  
  public final int getType()
  {
    return 529;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    params = null;
    AppMethodBeat.i(118805);
    Log.d(TAG, "netId=" + paramInt1 + " errType=" + paramInt2 + " errCode=" + paramInt3 + " errMsg=" + paramString);
    paramArrayOfByte = c.c.b(this.rr.otC);
    if (paramArrayOfByte == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryDateDetailResponse");
      AppMethodBeat.o(118805);
      throw paramString;
    }
    paramArrayOfByte = (fil)paramArrayOfByte;
    this.QtH = paramArrayOfByte.abJj;
    Log.i(TAG, "objCount: " + paramArrayOfByte.abIQ + ", expiredTime: " + paramArrayOfByte.aaiS);
    if (paramArrayOfByte.abJi.isEmpty())
    {
      Log.d(TAG, "error: server give size zero");
      paramArrayOfByte = this.callback;
      params = paramArrayOfByte;
      if (paramArrayOfByte == null)
      {
        kotlin.g.b.s.bIx("callback");
        params = null;
      }
      params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
      AppMethodBeat.o(118805);
      return;
    }
    m.a locala = com.tencent.mm.plugin.story.model.m.Sks;
    m.a.e(this.userName, (List)paramArrayOfByte.abJi, this.sourceType);
    if (this.maxId == 0L) {
      this.maxId = ((fiz)paramArrayOfByte.abJi.getFirst()).Id;
    }
    Log.i(TAG, "insertList mUserName %s maxId %s minId %s", new Object[] { this.userName, Long.valueOf(this.maxId), Long.valueOf(this.Qsh) });
    paramArrayOfByte = this.callback;
    if (paramArrayOfByte == null) {
      kotlin.g.b.s.bIx("callback");
    }
    for (;;)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
      AppMethodBeat.o(118805);
      return;
      params = paramArrayOfByte;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.a.d
 * JD-Core Version:    0.7.0.1
 */