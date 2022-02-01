package com.tencent.mm.plugin.story.model.a;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.network.g;
import com.tencent.mm.plugin.story.c.a.e;
import com.tencent.mm.plugin.story.model.StoryCore;
import com.tencent.mm.plugin.story.model.StoryCore.b;
import com.tencent.mm.plugin.story.model.b.b.a;
import com.tencent.mm.plugin.story.model.b.b.b;
import com.tencent.mm.plugin.story.model.m.a;
import com.tencent.mm.protocal.ad;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.protocal.protobuf.adx;
import com.tencent.mm.protocal.protobuf.fie;
import com.tencent.mm.protocal.protobuf.fij;
import com.tencent.mm.protocal.protobuf.fis;
import com.tencent.mm.protocal.protobuf.fiz;
import com.tencent.mm.protocal.protobuf.fjf;
import com.tencent.mm.protocal.protobuf.fjg;
import com.tencent.mm.protocal.protobuf.fjh;
import com.tencent.mm.protocal.protobuf.fji;
import com.tencent.mm.protocal.protobuf.fjj;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.storage.aq;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.ah.f;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStorySync;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "selector", "", "(I)V", "MAX_SYNC_COUNT", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "respHandler", "Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStorySync$RespHandler;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "processEnd", "processStoryComment", "", "item", "Lcom/tencent/mm/protocal/protobuf/CmdItem;", "h", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "processStoryCommentDel", "processStoryPost", "processStoryPostDel", "processStoryVisit", "securityLimitCount", "securityVerificationChecked", "Lcom/tencent/mm/modelbase/NetSceneBase$SecurityCheckStatus;", "Companion", "RespHandler", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  extends com.tencent.mm.am.p
  implements com.tencent.mm.network.m
{
  public static final h.a Sln;
  private static final LinkedList<Object> Slq;
  private static final String TAG;
  private b Slo;
  private final int Slp;
  com.tencent.mm.am.h callback;
  final com.tencent.mm.am.c rr;
  
  static
  {
    AppMethodBeat.i(118838);
    Sln = new h.a((byte)0);
    TAG = "MicroMsg.StoryCgi.NetSceneStorySync";
    Slq = new LinkedList();
    AppMethodBeat.o(118838);
  }
  
  public h()
  {
    AppMethodBeat.i(118837);
    this.Slo = new b();
    this.Slp = 10;
    Object localObject = new c.a();
    ((c.a)localObject).otE = ((com.tencent.mm.bx.a)new fjh());
    ((c.a)localObject).otF = ((com.tencent.mm.bx.a)new fji());
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/mmstorysync";
    ((c.a)localObject).funcId = 513;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    localObject = ((c.a)localObject).bEF();
    kotlin.g.b.s.s(localObject, "builder.buildInstance()");
    this.rr = ((com.tencent.mm.am.c)localObject);
    localObject = c.b.b(this.rr.otB);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncRequest");
      AppMethodBeat.o(118837);
      throw ((Throwable)localObject);
    }
    ((fjh)localObject).ZdC = 128;
    AppMethodBeat.o(118837);
  }
  
  public static boolean c(adw paramadw, MMHandler paramMMHandler)
  {
    AppMethodBeat.i(118830);
    kotlin.g.b.s.u(paramadw, "item");
    kotlin.g.b.s.u(paramMMHandler, "h");
    for (;;)
    {
      try
      {
        localObject1 = new fjf();
        paramadw = paramadw.Zmd;
        if (paramadw == null)
        {
          paramadw = null;
          paramadw = ((fjf)localObject1).parseFrom(paramadw);
          if (paramadw != null) {
            break;
          }
          paramadw = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncMsg");
          AppMethodBeat.o(118830);
          throw paramadw;
        }
      }
      catch (Exception paramadw)
      {
        Log.w(TAG, "StorySyncMsg parse error!");
        AppMethodBeat.o(118830);
        return false;
      }
      paramadw = paramadw.aaxD;
      if (paramadw == null) {
        paramadw = null;
      } else {
        paramadw = paramadw.toByteArray();
      }
    }
    paramadw = (fjf)paramadw;
    Object localObject1 = paramadw.abJW.IMh;
    int i = paramadw.abJW.CreateTime;
    long l = paramadw.Id;
    Object localObject2 = com.tencent.mm.plugin.story.model.m.Sks;
    kotlin.g.b.s.s(localObject1, "username");
    com.tencent.mm.plugin.story.h.j localj = m.a.a((String)localObject1, l, i, paramadw.abJW.abJh, false);
    localObject2 = com.tencent.mm.plugin.story.model.j.Skm;
    com.tencent.mm.plugin.story.model.j.a((String)localObject1, localj);
    localObject1 = TAG;
    localObject2 = new StringBuilder("processStoryPost username:").append(paramadw.abJW.IMh).append(" createTime:").append(paramadw.abJW.CreateTime).append(" id:").append(paramadw.Id).append(" scope:");
    if (localj == null) {
      paramadw = null;
    }
    for (;;)
    {
      Log.i((String)localObject1, paramadw);
      paramadw = Slq.iterator();
      while (paramadw.hasNext()) {
        paramadw.next();
      }
      paramadw = localj.hzt();
      if (paramadw == null)
      {
        paramadw = null;
      }
      else
      {
        i = paramadw.abKb;
        paramadw = Integer.valueOf(i);
      }
    }
    paramMMHandler.sendEmptyMessage(0);
    AppMethodBeat.o(118830);
    return true;
  }
  
  public static boolean d(adw paramadw, MMHandler paramMMHandler)
  {
    AppMethodBeat.i(118831);
    kotlin.g.b.s.u(paramadw, "item");
    kotlin.g.b.s.u(paramMMHandler, "h");
    Object localObject1;
    for (;;)
    {
      try
      {
        localObject1 = new fjf();
        paramadw = paramadw.Zmd;
        if (paramadw == null)
        {
          paramadw = null;
          paramadw = ((fjf)localObject1).parseFrom(paramadw);
          if (paramadw != null) {
            break;
          }
          paramadw = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncMsg");
          AppMethodBeat.o(118831);
          throw paramadw;
        }
      }
      catch (Exception paramadw)
      {
        Log.w(TAG, "StorySyncMsg parse error!");
        AppMethodBeat.o(118831);
        return false;
      }
      paramadw = paramadw.aaxD;
      if (paramadw == null) {
        paramadw = null;
      } else {
        paramadw = paramadw.toByteArray();
      }
    }
    paramadw = (fjf)paramadw;
    String str = paramadw.abJW.IMh;
    int i = paramadw.abJW.CreateTime;
    long l = paramadw.Id;
    paramadw = com.tencent.mm.plugin.story.model.m.Sks;
    kotlin.g.b.s.s(str, "username");
    m.a.a(str, l, i, null, true);
    paramadw = com.tencent.mm.plugin.story.model.m.Sks;
    com.tencent.mm.plugin.story.h.j localj = m.a.bbQ(str);
    Object localObject2 = localj.hzt();
    paramadw = ((fjj)localObject2).abJZ;
    label201:
    float f;
    if (paramadw == null)
    {
      paramadw = null;
      localObject1 = ((fjj)localObject2).abJZ;
      if (localObject1 != null) {
        break label400;
      }
      localObject1 = null;
      localObject2 = ((fjj)localObject2).abJZ;
      if (localObject2 != null) {
        break label453;
      }
      f = 0.0F;
    }
    for (;;)
    {
      localObject2 = com.tencent.mm.plugin.story.model.j.Skm;
      com.tencent.mm.plugin.story.model.j.a(str, localj.field_storyID, localj.field_createTime, paramadw, (String)localObject1, (f * 1000.0F));
      Log.i(TAG, "processStoryPostDel username:" + str + " createTime:" + i + " id:" + l + " lastCreateTime:" + localj.field_createTime + " lastId:" + localj.field_storyID + "   ulonglong " + d.hF(l));
      paramadw = Slq.iterator();
      while (paramadw.hasNext()) {
        paramadw.next();
      }
      paramadw = paramadw.Zpr;
      if (paramadw == null)
      {
        paramadw = null;
        break;
      }
      paramadw = (fis)kotlin.a.p.ae((List)paramadw, 0);
      if (paramadw == null)
      {
        paramadw = null;
        break;
      }
      paramadw = paramadw.aaTl;
      break;
      label400:
      localObject1 = ((fij)localObject1).Zpr;
      if (localObject1 == null)
      {
        localObject1 = null;
        break label201;
      }
      localObject1 = (fis)kotlin.a.p.ae((List)localObject1, 0);
      if (localObject1 == null)
      {
        localObject1 = null;
        break label201;
      }
      localObject1 = ((fis)localObject1).Url;
      break label201;
      label453:
      localObject2 = ((fij)localObject2).Zpr;
      if (localObject2 == null)
      {
        f = 0.0F;
      }
      else
      {
        localObject2 = (fis)kotlin.a.p.ae((List)localObject2, 0);
        if (localObject2 == null) {
          f = 0.0F;
        } else {
          f = ((fis)localObject2).abJB;
        }
      }
    }
    paramMMHandler.sendEmptyMessage(0);
    AppMethodBeat.o(118831);
    return true;
  }
  
  public static boolean e(adw paramadw, MMHandler paramMMHandler)
  {
    Object localObject1 = null;
    AppMethodBeat.i(118832);
    kotlin.g.b.s.u(paramadw, "item");
    kotlin.g.b.s.u(paramMMHandler, "h");
    for (;;)
    {
      try
      {
        localObject2 = new fjf();
        paramadw = paramadw.Zmd;
        if (paramadw == null)
        {
          paramadw = (adw)localObject1;
          paramadw = ((fjf)localObject2).parseFrom(paramadw);
          if (paramadw != null) {
            break;
          }
          paramadw = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncMsg");
          AppMethodBeat.o(118832);
          throw paramadw;
        }
      }
      catch (Exception paramadw)
      {
        Log.w(TAG, kotlin.g.b.s.X("StorySyncMsg parse error: ", paramadw.getMessage()));
        AppMethodBeat.o(118832);
        return false;
      }
      localObject3 = paramadw.aaxD;
      paramadw = (adw)localObject1;
      if (localObject3 != null) {
        paramadw = ((com.tencent.mm.bx.b)localObject3).toByteArray();
      }
    }
    paramadw = (fjf)paramadw;
    localObject1 = paramadw.abJW.IMh;
    int i = paramadw.abJW.CreateTime;
    long l = paramadw.Id;
    Log.i(TAG, "processStoryComment username:" + localObject1 + " createTime:" + i + " id:" + l + " ulonglong " + d.hF(l));
    localObject1 = com.tencent.mm.plugin.story.model.b.b.SlF;
    kotlin.g.b.s.u(paramadw, "syncMsg");
    Log.i(com.tencent.mm.plugin.story.model.b.b.TAG, "addSyncComment " + paramadw.Id + ' ' + paramadw.abJW.abDh + ' ' + paramadw.abJW.CreateTime);
    localObject1 = new ah.f();
    Object localObject2 = StoryCore.SjP;
    ((ah.f)localObject1).aqH = StoryCore.b.hvU().vZ(paramadw.abJW.Id);
    if (((ah.f)localObject1).aqH == null)
    {
      ((ah.f)localObject1).aqH = new com.tencent.mm.plugin.story.h.c();
      ((com.tencent.mm.plugin.story.h.c)((ah.f)localObject1).aqH).field_storyId = paramadw.Id;
    }
    com.tencent.mm.plugin.story.model.b.b.a(paramadw);
    if (((com.tencent.mm.plugin.story.h.c)((ah.f)localObject1).aqH).field_readCommentTime == 0) {
      ((com.tencent.mm.plugin.story.h.c)((ah.f)localObject1).aqH).field_readCommentTime = 1;
    }
    localObject2 = (com.tencent.mm.plugin.story.h.c)((ah.f)localObject1).aqH;
    Object localObject3 = paramadw.abJW.IMh;
    kotlin.g.b.s.s(localObject3, "syncMsg.SyncMsgDetail.FromUserName");
    ((com.tencent.mm.plugin.story.h.c)localObject2).bci((String)localObject3);
    localObject2 = (com.tencent.mm.plugin.story.h.c)((ah.f)localObject1).aqH;
    localObject3 = paramadw.abJW.abJh.UserName;
    kotlin.g.b.s.s(localObject3, "syncMsg.SyncMsgDetail.StoryObject.UserName");
    ((com.tencent.mm.plugin.story.h.c)localObject2).bbU((String)localObject3);
    ((com.tencent.mm.plugin.story.h.c)((ah.f)localObject1).aqH).field_syncCommentId = paramadw.abJW.abDh;
    ((com.tencent.mm.plugin.story.h.c)((ah.f)localObject1).aqH).field_syncCommentTime = paramadw.abJW.CreateTime;
    paramadw = StoryCore.SjP;
    StoryCore.b.hvU().replace((IAutoDBItem)((ah.f)localObject1).aqH);
    d.uiThread((kotlin.g.a.a)new b.a((ah.f)localObject1));
    paramadw = Slq.iterator();
    while (paramadw.hasNext()) {
      paramadw.next();
    }
    paramMMHandler.sendEmptyMessage(0);
    AppMethodBeat.o(118832);
    return true;
  }
  
  public static boolean f(adw paramadw, MMHandler paramMMHandler)
  {
    AppMethodBeat.i(118833);
    kotlin.g.b.s.u(paramadw, "item");
    kotlin.g.b.s.u(paramMMHandler, "h");
    for (;;)
    {
      try
      {
        localfjf = new fjf();
        paramadw = paramadw.Zmd;
        if (paramadw == null)
        {
          paramadw = null;
          paramadw = localfjf.parseFrom(paramadw);
          if (paramadw != null) {
            break;
          }
          paramadw = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncMsg");
          AppMethodBeat.o(118833);
          throw paramadw;
        }
      }
      catch (Exception paramadw)
      {
        Log.w(TAG, kotlin.g.b.s.X("StorySyncMsg parse error:  ", paramadw.getMessage()));
        AppMethodBeat.o(118833);
        return false;
      }
      paramadw = paramadw.aaxD;
      if (paramadw == null) {
        paramadw = null;
      } else {
        paramadw = paramadw.toByteArray();
      }
    }
    fjf localfjf = (fjf)paramadw;
    paramadw = localfjf.abJW.IMh;
    int i = localfjf.abJW.CreateTime;
    long l = localfjf.Id;
    Log.i(TAG, "processStoryVisit username:" + paramadw + " createTime:" + i + " id:" + l + " ulonglong " + d.hF(l));
    paramadw = com.tencent.mm.plugin.story.model.b.b.SlF;
    kotlin.g.b.s.u(localfjf, "syncMsg");
    boolean bool = e.Sjb.huS();
    Log.i(com.tencent.mm.plugin.story.model.b.b.TAG, "addSyncVisit " + localfjf.Id + ' ' + localfjf.abJW.abDh + ' ' + localfjf.abJW.CreateTime + " enableVisit:" + bool);
    com.tencent.mm.plugin.story.model.b.b.a(localfjf);
    ah.f localf = new ah.f();
    paramadw = StoryCore.SjP;
    localf.aqH = StoryCore.b.hvU().vZ(localfjf.abJW.Id);
    if (localf.aqH == null)
    {
      localf.aqH = new com.tencent.mm.plugin.story.h.c();
      ((com.tencent.mm.plugin.story.h.c)localf.aqH).field_storyId = localfjf.Id;
    }
    Object localObject;
    if (((com.tencent.mm.plugin.story.h.c)localf.aqH).field_readCommentTime == 0)
    {
      if (!Util.isNullOrNil(localfjf.abJW.nUB)) {
        break label633;
      }
      paramadw = localfjf.abJW.abJh.abJN;
      kotlin.g.b.s.s(paramadw, "bubbleList");
      paramadw = (fie)kotlin.a.p.ae((List)paramadw, paramadw.size() - 2);
      if (paramadw != null) {
        break label622;
      }
      paramadw = null;
      localObject = (com.tencent.mm.plugin.story.h.c)localf.aqH;
      if (paramadw != null) {
        break label689;
      }
    }
    label689:
    for (i = 1;; i = paramadw.intValue())
    {
      ((com.tencent.mm.plugin.story.h.c)localObject).field_readCommentTime = i;
      paramadw = (com.tencent.mm.plugin.story.h.c)localf.aqH;
      localObject = localfjf.abJW.IMh;
      kotlin.g.b.s.s(localObject, "syncMsg.SyncMsgDetail.FromUserName");
      paramadw.bci((String)localObject);
      paramadw = (com.tencent.mm.plugin.story.h.c)localf.aqH;
      localObject = localfjf.abJW.abJh.UserName;
      kotlin.g.b.s.s(localObject, "syncMsg.SyncMsgDetail.StoryObject.UserName");
      paramadw.bbU((String)localObject);
      ((com.tencent.mm.plugin.story.h.c)localf.aqH).field_syncCommentId = localfjf.abJW.abDh;
      ((com.tencent.mm.plugin.story.h.c)localf.aqH).field_syncCommentTime = localfjf.abJW.CreateTime;
      paramadw = StoryCore.SjP;
      StoryCore.b.hvU().replace((IAutoDBItem)localf.aqH);
      d.uiThread((kotlin.g.a.a)new b.b(localf));
      paramadw = Slq.iterator();
      while (paramadw.hasNext()) {
        paramadw.next();
      }
      label622:
      paramadw = Integer.valueOf(paramadw.CreateTime);
      break;
      label633:
      paramadw = localfjf.abJW.abJh.abJL;
      kotlin.g.b.s.s(paramadw, "commentList");
      paramadw = (fie)kotlin.a.p.ae((List)paramadw, paramadw.size() - 2);
      if (paramadw == null)
      {
        paramadw = null;
        break;
      }
      paramadw = Integer.valueOf(paramadw.CreateTime);
      break;
    }
    paramMMHandler.sendEmptyMessage(0);
    AppMethodBeat.o(118833);
    return true;
  }
  
  public static boolean g(adw paramadw, MMHandler paramMMHandler)
  {
    Object localObject = null;
    AppMethodBeat.i(118834);
    kotlin.g.b.s.u(paramadw, "item");
    kotlin.g.b.s.u(paramMMHandler, "h");
    for (;;)
    {
      try
      {
        fjf localfjf = new fjf();
        paramadw = paramadw.Zmd;
        if (paramadw == null)
        {
          paramadw = (adw)localObject;
          paramadw = localfjf.parseFrom(paramadw);
          if (paramadw != null) {
            break;
          }
          paramadw = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncMsg");
          AppMethodBeat.o(118834);
          throw paramadw;
        }
      }
      catch (Exception paramadw)
      {
        Log.w(TAG, "StorySyncMsg parse error!");
        AppMethodBeat.o(118834);
        return false;
      }
      com.tencent.mm.bx.b localb = paramadw.aaxD;
      paramadw = (adw)localObject;
      if (localb != null) {
        paramadw = localb.toByteArray();
      }
    }
    paramadw = (fjf)paramadw;
    localObject = paramadw.abJW.IMh;
    int i = paramadw.abJW.CreateTime;
    long l = paramadw.Id;
    Log.i(TAG, "processStoryCommentDel username:" + localObject + " createTime:" + i + " id:" + l);
    localObject = com.tencent.mm.plugin.story.model.b.b.SlF;
    kotlin.g.b.s.u(paramadw, "syncMsg");
    Log.i(com.tencent.mm.plugin.story.model.b.b.TAG, "delSyncComment " + paramadw.Id + ' ' + paramadw.abJW.abDh);
    com.tencent.mm.plugin.story.model.b.b.l(paramadw.abJW.Id, paramadw.abJW.abDh, paramadw.abJW.nUB);
    com.tencent.mm.plugin.story.model.b.b.vO(paramadw.abJW.Id);
    paramadw = Slq.iterator();
    while (paramadw.hasNext()) {
      paramadw.next();
    }
    paramMMHandler.sendEmptyMessage(0);
    AppMethodBeat.o(118834);
    return true;
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(118835);
    kotlin.g.b.s.u(paramg, "dispatcher");
    kotlin.g.b.s.u(paramh, "callback");
    Object localObject = Util.decodeHexString(Util.nullAsNil((String)com.tencent.mm.kernel.h.baE().ban().d(8195, null)));
    gol localgol = new gol();
    localgol.df((byte[])localObject);
    localObject = c.b.b(this.rr.otB);
    if (localObject == null)
    {
      paramg = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncRequest");
      AppMethodBeat.o(118835);
      throw paramg;
    }
    ((fjh)localObject).ZdD = localgol;
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.rr, (com.tencent.mm.network.m)this);
    AppMethodBeat.o(118835);
    return i;
  }
  
  public final int getType()
  {
    return 513;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    Object localObject = null;
    AppMethodBeat.i(118836);
    Log.d(TAG, "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      paramArrayOfByte = this.callback;
      params = paramArrayOfByte;
      if (paramArrayOfByte == null)
      {
        kotlin.g.b.s.bIx("callback");
        params = null;
      }
      params.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.am.p)this);
      AppMethodBeat.o(118836);
      return;
    }
    params = c.c.b(this.rr.otC);
    if (params == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncResponse");
      AppMethodBeat.o(118836);
      throw paramString;
    }
    fji localfji = (fji)params;
    params = localfji.ZdG;
    if (params == null) {}
    for (params = null;; params = params.vgO)
    {
      paramArrayOfByte = params;
      if (params == null) {
        paramArrayOfByte = new LinkedList();
      }
      if (paramArrayOfByte.size() <= 0) {
        break;
      }
      paramString = this.Slo;
      kotlin.g.b.s.u(paramArrayOfByte, "cmdList");
      paramString.zMR = paramArrayOfByte;
      paramString.AdR.sendEmptyMessage(0);
      AppMethodBeat.o(118836);
      return;
    }
    if ((localfji.ZdD != null) && (localfji.ZdD.aaxD != null))
    {
      params = localfji.ZdD.aaxD.toByteArray();
      if (params != null)
      {
        paramArrayOfByte = c.b.b(this.rr.otB);
        if (paramArrayOfByte == null)
        {
          paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncRequest");
          AppMethodBeat.o(118836);
          throw paramString;
        }
        params = ad.o(((fjh)paramArrayOfByte).ZdD.aaxD.toByteArray(), params);
        if (params != null)
        {
          if (params.length != 0) {
            break label429;
          }
          paramInt1 = 1;
          if (paramInt1 != 0) {
            break label434;
          }
          paramInt1 = 1;
          label365:
          if (paramInt1 != 0) {
            com.tencent.mm.kernel.h.baE().ban().B(8195, Util.encodeHexString(params));
          }
        }
      }
    }
    params = this.callback;
    if (params == null)
    {
      kotlin.g.b.s.bIx("callback");
      params = localObject;
    }
    for (;;)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.am.p)this);
      AppMethodBeat.o(118836);
      return;
      label429:
      paramInt1 = 0;
      break;
      label434:
      paramInt1 = 0;
      break label365;
    }
  }
  
  public final int securityLimitCount()
  {
    return this.Slp;
  }
  
  public final p.b securityVerificationChecked(com.tencent.mm.network.s params)
  {
    return p.b.ouh;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStorySync$RespHandler;", "", "(Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStorySync;)V", "cmdList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/CmdItem;", "getCmdList", "()Ljava/util/LinkedList;", "setCmdList", "(Ljava/util/LinkedList;)V", "h", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getH", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "setH", "(Lcom/tencent/mm/sdk/platformtools/MMHandler;)V", "delaWithCmdList", "", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
  {
    MMHandler AdR;
    LinkedList<adw> zMR;
    
    public b()
    {
      AppMethodBeat.i(118829);
      this.AdR = ((MMHandler)new a(this, this.Slr));
      AppMethodBeat.o(118829);
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/story/model/cgi/NetSceneStorySync$RespHandler$h$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      extends MMHandler
    {
      a(h.b paramb, h paramh) {}
      
      private static final void a(h paramh, adw paramadw, a parama)
      {
        AppMethodBeat.i(367163);
        kotlin.g.b.s.u(paramh, "this$0");
        kotlin.g.b.s.u(parama, "this$1");
        kotlin.g.b.s.s(paramadw, "item");
        if (!h.c(paramadw, (MMHandler)parama)) {
          parama.sendEmptyMessage(0);
        }
        AppMethodBeat.o(367163);
      }
      
      private static final void b(h paramh, adw paramadw, a parama)
      {
        AppMethodBeat.i(367169);
        kotlin.g.b.s.u(paramh, "this$0");
        kotlin.g.b.s.u(parama, "this$1");
        kotlin.g.b.s.s(paramadw, "item");
        if (!h.d(paramadw, (MMHandler)parama)) {
          parama.sendEmptyMessage(0);
        }
        AppMethodBeat.o(367169);
      }
      
      private static final void c(h paramh, adw paramadw, a parama)
      {
        AppMethodBeat.i(367173);
        kotlin.g.b.s.u(paramh, "this$0");
        kotlin.g.b.s.u(parama, "this$1");
        kotlin.g.b.s.s(paramadw, "item");
        if (!h.e(paramadw, (MMHandler)parama)) {
          parama.sendEmptyMessage(0);
        }
        AppMethodBeat.o(367173);
      }
      
      private static final void d(h paramh, adw paramadw, a parama)
      {
        AppMethodBeat.i(367176);
        kotlin.g.b.s.u(paramh, "this$0");
        kotlin.g.b.s.u(parama, "this$1");
        kotlin.g.b.s.s(paramadw, "item");
        if (!h.f(paramadw, (MMHandler)parama)) {
          parama.sendEmptyMessage(0);
        }
        AppMethodBeat.o(367176);
      }
      
      private static final void e(h paramh, adw paramadw, a parama)
      {
        AppMethodBeat.i(367177);
        kotlin.g.b.s.u(paramh, "this$0");
        kotlin.g.b.s.u(parama, "this$1");
        kotlin.g.b.s.s(paramadw, "item");
        if (!h.g(paramadw, (MMHandler)parama)) {
          parama.sendEmptyMessage(0);
        }
        AppMethodBeat.o(367177);
      }
      
      public final void handleMessage(Message paramMessage)
      {
        Object localObject1 = null;
        AppMethodBeat.i(118828);
        kotlin.g.b.s.u(paramMessage, "msg");
        if (!com.tencent.mm.kernel.h.baC().aZN())
        {
          AppMethodBeat.o(118828);
          return;
        }
        if (this.Sls.zMR != null)
        {
          paramMessage = this.Sls.zMR;
          kotlin.g.b.s.checkNotNull(paramMessage);
          if (!paramMessage.isEmpty()) {}
        }
        else
        {
          h localh = this.Slt;
          paramMessage = c.c.b(localh.rr.otC);
          if (paramMessage == null)
          {
            paramMessage = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncResponse");
            AppMethodBeat.o(118828);
            throw paramMessage;
          }
          paramMessage = (fji)paramMessage;
          Object localObject2 = c.b.b(localh.rr.otB);
          if (localObject2 == null)
          {
            paramMessage = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncRequest");
            AppMethodBeat.o(118828);
            throw paramMessage;
          }
          localObject2 = (fjh)localObject2;
          byte[] arrayOfByte = paramMessage.ZdD.aaxD.toByteArray();
          if (arrayOfByte != null)
          {
            arrayOfByte = ad.o(((fjh)localObject2).ZdD.aaxD.toByteArray(), arrayOfByte);
            if ((arrayOfByte != null) && (arrayOfByte.length > 0)) {
              com.tencent.mm.kernel.h.baE().ban().B(8195, Util.encodeHexString(arrayOfByte));
            }
            ((fjh)localObject2).ZdD.df(arrayOfByte);
          }
          if ((paramMessage.YYp & ((fjh)localObject2).ZdC) == 0)
          {
            paramMessage = localh.callback;
            if (paramMessage == null)
            {
              kotlin.g.b.s.bIx("callback");
              paramMessage = null;
            }
            for (;;)
            {
              paramMessage.onSceneEnd(0, 0, "", (com.tencent.mm.am.p)localh);
              AppMethodBeat.o(118828);
              return;
            }
          }
          localObject2 = localh.dispatcher();
          kotlin.g.b.s.s(localObject2, "dispatcher()");
          paramMessage = localh.callback;
          if (paramMessage == null)
          {
            kotlin.g.b.s.bIx("callback");
            paramMessage = (Message)localObject1;
          }
          for (;;)
          {
            localh.doScene((g)localObject2, paramMessage);
            AppMethodBeat.o(118828);
            return;
          }
        }
        paramMessage = this.Sls.zMR;
        kotlin.g.b.s.checkNotNull(paramMessage);
        paramMessage = (adw)paramMessage.getFirst();
        Log.d(h.access$getTAG$cp(), kotlin.g.b.s.X("cmdId = ", Integer.valueOf(paramMessage.Zmc)));
        localObject1 = this.Sls.zMR;
        kotlin.g.b.s.checkNotNull(localObject1);
        ((LinkedList)localObject1).removeFirst();
        switch (paramMessage.Zmc)
        {
        case 5: 
        case 6: 
        default: 
          sendEmptyMessage(0);
          AppMethodBeat.o(118828);
          return;
        case 1: 
          localObject1 = StoryCore.SjP;
          StoryCore.b.gHI().post(new h.b.a..ExternalSyntheticLambda4(this.Slt, paramMessage, this));
          AppMethodBeat.o(118828);
          return;
        case 2: 
          localObject1 = StoryCore.SjP;
          StoryCore.b.gHI().post(new h.b.a..ExternalSyntheticLambda1(this.Slt, paramMessage, this));
          AppMethodBeat.o(118828);
          return;
        case 3: 
          localObject1 = StoryCore.SjP;
          StoryCore.b.gHI().post(new h.b.a..ExternalSyntheticLambda3(this.Slt, paramMessage, this));
          AppMethodBeat.o(118828);
          return;
        case 7: 
          localObject1 = StoryCore.SjP;
          StoryCore.b.gHI().post(new h.b.a..ExternalSyntheticLambda0(this.Slt, paramMessage, this));
          AppMethodBeat.o(118828);
          return;
        }
        localObject1 = StoryCore.SjP;
        StoryCore.b.gHI().post(new h.b.a..ExternalSyntheticLambda2(this.Slt, paramMessage, this));
        AppMethodBeat.o(118828);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.a.h
 * JD-Core Version:    0.7.0.1
 */