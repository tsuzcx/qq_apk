package com.tencent.mm.plugin.story.f.a;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.story.f.b.b.b;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.n.a;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dix;
import com.tencent.mm.protocal.protobuf.djc;
import com.tencent.mm.protocal.protobuf.djl;
import com.tencent.mm.protocal.protobuf.djs;
import com.tencent.mm.protocal.protobuf.djy;
import com.tencent.mm.protocal.protobuf.djz;
import com.tencent.mm.protocal.protobuf.dka;
import com.tencent.mm.protocal.protobuf.dkb;
import com.tencent.mm.protocal.protobuf.dkc;
import com.tencent.mm.protocal.protobuf.zu;
import com.tencent.mm.protocal.protobuf.zv;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import d.g.b.p;
import d.g.b.y.f;
import d.l;
import d.v;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStorySync;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "selector", "", "(I)V", "MAX_SYNC_COUNT", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "respHandler", "Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStorySync$RespHandler;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "processEnd", "processStoryComment", "", "item", "Lcom/tencent/mm/protocal/protobuf/CmdItem;", "h", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "processStoryCommentDel", "processStoryPost", "processStoryPostDel", "processStoryVisit", "securityLimitCount", "securityVerificationChecked", "Lcom/tencent/mm/modelbase/NetSceneBase$SecurityCheckStatus;", "Companion", "RespHandler", "plugin-story_release"})
public final class h
  extends com.tencent.mm.al.n
  implements com.tencent.mm.network.k
{
  private static final LinkedList<Object> ALq;
  public static final h.a ALr;
  private static final String TAG = "MicroMsg.StoryCgi.NetSceneStorySync";
  private b ALo;
  private final int ALp;
  f callback;
  final com.tencent.mm.al.b rr;
  
  static
  {
    AppMethodBeat.i(118838);
    ALr = new h.a((byte)0);
    TAG = "MicroMsg.StoryCgi.NetSceneStorySync";
    ALq = new LinkedList();
    AppMethodBeat.o(118838);
  }
  
  public h()
  {
    AppMethodBeat.i(118837);
    this.ALo = new b();
    this.ALp = 10;
    Object localObject = new com.tencent.mm.al.b.a();
    ((com.tencent.mm.al.b.a)localObject).c((com.tencent.mm.bx.a)new dka());
    ((com.tencent.mm.al.b.a)localObject).d((com.tencent.mm.bx.a)new dkb());
    ((com.tencent.mm.al.b.a)localObject).Dl("/cgi-bin/micromsg-bin/mmstorysync");
    ((com.tencent.mm.al.b.a)localObject).oP(513);
    ((com.tencent.mm.al.b.a)localObject).oR(0);
    ((com.tencent.mm.al.b.a)localObject).oS(0);
    localObject = ((com.tencent.mm.al.b.a)localObject).aDC();
    p.g(localObject, "builder.buildInstance()");
    this.rr = ((com.tencent.mm.al.b)localObject);
    localObject = this.rr.aEE();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncRequest");
      AppMethodBeat.o(118837);
      throw ((Throwable)localObject);
    }
    ((dka)localObject).FRq = 128;
    AppMethodBeat.o(118837);
  }
  
  public static boolean c(zu paramzu, ap paramap)
  {
    AppMethodBeat.i(118830);
    p.h(paramzu, "item");
    p.h(paramap, "h");
    try
    {
      localObject1 = new djy();
      paramzu = paramzu.FYV;
      p.g(paramzu, "item.CmdBuf");
      paramzu = ((djy)localObject1).parseFrom(paramzu.getBuffer().toByteArray());
      if (paramzu == null)
      {
        paramzu = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncMsg");
        AppMethodBeat.o(118830);
        throw paramzu;
      }
    }
    catch (Exception paramzu)
    {
      com.tencent.mm.sdk.platformtools.ad.w(TAG, "StorySyncMsg parse error!");
      AppMethodBeat.o(118830);
      return false;
    }
    paramzu = (djy)paramzu;
    Object localObject1 = paramzu.HyK.ukj;
    int i = paramzu.HyK.CreateTime;
    long l = paramzu.Id;
    Object localObject2 = com.tencent.mm.plugin.story.f.n.AKq;
    p.g(localObject1, "username");
    com.tencent.mm.plugin.story.i.j localj = n.a.a((String)localObject1, l, i, paramzu.HyK.HxW, false);
    localObject2 = com.tencent.mm.plugin.story.f.k.AKk;
    com.tencent.mm.plugin.story.f.k.a((String)localObject1, localj);
    localObject1 = TAG;
    localObject2 = new StringBuilder("processStoryPost username:").append(paramzu.HyK.ukj).append(" createTime:").append(paramzu.HyK.CreateTime).append(" id:").append(paramzu.Id).append(" scope:");
    if (localj != null)
    {
      paramzu = localj.elx();
      if (paramzu == null) {}
    }
    for (paramzu = Integer.valueOf(paramzu.HyP);; paramzu = null)
    {
      com.tencent.mm.sdk.platformtools.ad.i((String)localObject1, paramzu);
      paramzu = ALq.iterator();
      while (paramzu.hasNext()) {
        paramzu.next();
      }
    }
    paramap.sendEmptyMessage(0);
    AppMethodBeat.o(118830);
    return true;
  }
  
  public static boolean d(zu paramzu, ap paramap)
  {
    AppMethodBeat.i(118831);
    p.h(paramzu, "item");
    p.h(paramap, "h");
    Object localObject1;
    try
    {
      localObject1 = new djy();
      paramzu = paramzu.FYV;
      p.g(paramzu, "item.CmdBuf");
      paramzu = ((djy)localObject1).parseFrom(paramzu.getBuffer().toByteArray());
      if (paramzu == null)
      {
        paramzu = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncMsg");
        AppMethodBeat.o(118831);
        throw paramzu;
      }
    }
    catch (Exception paramzu)
    {
      com.tencent.mm.sdk.platformtools.ad.w(TAG, "StorySyncMsg parse error!");
      AppMethodBeat.o(118831);
      return false;
    }
    paramzu = (djy)paramzu;
    String str = paramzu.HyK.ukj;
    int i = paramzu.HyK.CreateTime;
    long l = paramzu.Id;
    paramzu = com.tencent.mm.plugin.story.f.n.AKq;
    p.g(str, "username");
    n.a.a(str, l, i, null, true);
    paramzu = com.tencent.mm.plugin.story.f.n.AKq;
    com.tencent.mm.plugin.story.i.j localj = n.a.aBL(str);
    Object localObject2 = localj.elx();
    paramzu = ((dkc)localObject2).HyN;
    if (paramzu != null)
    {
      paramzu = paramzu.GaQ;
      if (paramzu != null)
      {
        paramzu = (djl)d.a.j.E((List)paramzu, 0);
        if (paramzu != null)
        {
          paramzu = paramzu.GSI;
          localObject1 = ((dkc)localObject2).HyN;
          if (localObject1 == null) {
            break label444;
          }
          localObject1 = ((djc)localObject1).GaQ;
          if (localObject1 == null) {
            break label444;
          }
          localObject1 = (djl)d.a.j.E((List)localObject1, 0);
          if (localObject1 == null) {
            break label444;
          }
          localObject1 = ((djl)localObject1).Url;
          label248:
          localObject2 = ((dkc)localObject2).HyN;
          if (localObject2 == null) {
            break label450;
          }
          localObject2 = ((djc)localObject2).GaQ;
          if (localObject2 == null) {
            break label450;
          }
          localObject2 = (djl)d.a.j.E((List)localObject2, 0);
          if (localObject2 == null) {
            break label450;
          }
        }
      }
    }
    label444:
    label450:
    for (float f = ((djl)localObject2).Hyq;; f = 0.0F)
    {
      localObject2 = com.tencent.mm.plugin.story.f.k.AKk;
      com.tencent.mm.plugin.story.f.k.a(str, localj.field_storyID, localj.field_createTime, paramzu, (String)localObject1, (f * 1000.0F));
      com.tencent.mm.sdk.platformtools.ad.i(TAG, "processStoryPostDel username:" + str + " createTime:" + i + " id:" + l + " lastCreateTime:" + localj.field_createTime + " lastId:" + localj.field_storyID + "   ulonglong " + com.tencent.mm.ad.c.rc(l));
      paramzu = ALq.iterator();
      while (paramzu.hasNext()) {
        paramzu.next();
      }
      paramzu = null;
      break;
      localObject1 = null;
      break label248;
    }
    paramap.sendEmptyMessage(0);
    AppMethodBeat.o(118831);
    return true;
  }
  
  public static boolean e(zu paramzu, ap paramap)
  {
    AppMethodBeat.i(118832);
    p.h(paramzu, "item");
    p.h(paramap, "h");
    try
    {
      localObject1 = new djy();
      paramzu = paramzu.FYV;
      p.g(paramzu, "item.CmdBuf");
      paramzu = ((djy)localObject1).parseFrom(paramzu.getBuffer().toByteArray());
      if (paramzu == null)
      {
        paramzu = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncMsg");
        AppMethodBeat.o(118832);
        throw paramzu;
      }
    }
    catch (Exception paramzu)
    {
      com.tencent.mm.sdk.platformtools.ad.w(TAG, "StorySyncMsg parse error: " + paramzu.getMessage());
      AppMethodBeat.o(118832);
      return false;
    }
    paramzu = (djy)paramzu;
    Object localObject1 = paramzu.HyK.ukj;
    int i = paramzu.HyK.CreateTime;
    long l = paramzu.Id;
    com.tencent.mm.sdk.platformtools.ad.i(TAG, "processStoryComment username:" + (String)localObject1 + " createTime:" + i + " id:" + l + " ulonglong " + com.tencent.mm.ad.c.rc(l));
    localObject1 = com.tencent.mm.plugin.story.f.b.b.ALT;
    p.h(paramzu, "syncMsg");
    com.tencent.mm.sdk.platformtools.ad.i(com.tencent.mm.plugin.story.f.b.b.TAG, "addSyncComment " + paramzu.Id + ' ' + paramzu.HyK.HtH + ' ' + paramzu.HyK.CreateTime);
    localObject1 = new y.f();
    Object localObject2 = com.tencent.mm.plugin.story.f.j.AKb;
    ((y.f)localObject1).MLV = j.b.ehW().AT(paramzu.HyK.Id);
    if ((com.tencent.mm.plugin.story.i.c)((y.f)localObject1).MLV == null)
    {
      ((y.f)localObject1).MLV = new com.tencent.mm.plugin.story.i.c();
      ((com.tencent.mm.plugin.story.i.c)((y.f)localObject1).MLV).field_storyId = paramzu.Id;
    }
    com.tencent.mm.plugin.story.f.b.b.a(paramzu);
    if (((com.tencent.mm.plugin.story.i.c)((y.f)localObject1).MLV).field_readCommentTime == 0) {
      ((com.tencent.mm.plugin.story.i.c)((y.f)localObject1).MLV).field_readCommentTime = 1;
    }
    localObject2 = (com.tencent.mm.plugin.story.i.c)((y.f)localObject1).MLV;
    String str = paramzu.HyK.ukj;
    p.g(str, "syncMsg.SyncMsgDetail.FromUserName");
    ((com.tencent.mm.plugin.story.i.c)localObject2).aCd(str);
    localObject2 = (com.tencent.mm.plugin.story.i.c)((y.f)localObject1).MLV;
    str = paramzu.HyK.HxW.nDo;
    p.g(str, "syncMsg.SyncMsgDetail.StoryObject.UserName");
    ((com.tencent.mm.plugin.story.i.c)localObject2).aBP(str);
    ((com.tencent.mm.plugin.story.i.c)((y.f)localObject1).MLV).field_syncCommentId = paramzu.HyK.HtH;
    ((com.tencent.mm.plugin.story.i.c)((y.f)localObject1).MLV).field_syncCommentTime = paramzu.HyK.CreateTime;
    paramzu = com.tencent.mm.plugin.story.f.j.AKb;
    j.b.ehW().replace((com.tencent.mm.sdk.e.c)((y.f)localObject1).MLV);
    com.tencent.mm.ad.c.g((d.g.a.a)new com.tencent.mm.plugin.story.f.b.b.a((y.f)localObject1));
    paramzu = ALq.iterator();
    while (paramzu.hasNext()) {
      paramzu.next();
    }
    paramap.sendEmptyMessage(0);
    AppMethodBeat.o(118832);
    return true;
  }
  
  public static boolean f(zu paramzu, ap paramap)
  {
    AppMethodBeat.i(118833);
    p.h(paramzu, "item");
    p.h(paramap, "h");
    try
    {
      localdjy = new djy();
      paramzu = paramzu.FYV;
      p.g(paramzu, "item.CmdBuf");
      paramzu = localdjy.parseFrom(paramzu.getBuffer().toByteArray());
      if (paramzu == null)
      {
        paramzu = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncMsg");
        AppMethodBeat.o(118833);
        throw paramzu;
      }
    }
    catch (Exception paramzu)
    {
      com.tencent.mm.sdk.platformtools.ad.w(TAG, "StorySyncMsg parse error:  " + paramzu.getMessage());
      AppMethodBeat.o(118833);
      return false;
    }
    djy localdjy = (djy)paramzu;
    paramzu = localdjy.HyK.ukj;
    int i = localdjy.HyK.CreateTime;
    long l = localdjy.Id;
    com.tencent.mm.sdk.platformtools.ad.i(TAG, "processStoryVisit username:" + paramzu + " createTime:" + i + " id:" + l + " ulonglong " + com.tencent.mm.ad.c.rc(l));
    paramzu = com.tencent.mm.plugin.story.f.b.b.ALT;
    p.h(localdjy, "syncMsg");
    boolean bool = com.tencent.mm.plugin.story.c.a.e.AIM.egX();
    com.tencent.mm.sdk.platformtools.ad.i(com.tencent.mm.plugin.story.f.b.b.TAG, "addSyncVisit " + localdjy.Id + ' ' + localdjy.HyK.HtH + ' ' + localdjy.HyK.CreateTime + " enableVisit:" + bool);
    com.tencent.mm.plugin.story.f.b.b.a(localdjy);
    y.f localf = new y.f();
    paramzu = com.tencent.mm.plugin.story.f.j.AKb;
    localf.MLV = j.b.ehW().AT(localdjy.HyK.Id);
    if ((com.tencent.mm.plugin.story.i.c)localf.MLV == null)
    {
      localf.MLV = new com.tencent.mm.plugin.story.i.c();
      ((com.tencent.mm.plugin.story.i.c)localf.MLV).field_storyId = localdjy.Id;
    }
    Object localObject;
    if (((com.tencent.mm.plugin.story.i.c)localf.MLV).field_readCommentTime == 0)
    {
      if (!bt.isNullOrNil(localdjy.HyK.hDa)) {
        break label636;
      }
      paramzu = localdjy.HyK.HxW.HyB;
      p.g(paramzu, "bubbleList");
      paramzu = (dix)d.a.j.E((List)paramzu, paramzu.size() - 2);
      if (paramzu == null) {
        break label631;
      }
      paramzu = Integer.valueOf(paramzu.CreateTime);
      localObject = (com.tencent.mm.plugin.story.i.c)localf.MLV;
      if (paramzu == null) {
        break label694;
      }
    }
    label694:
    for (i = paramzu.intValue();; i = 1)
    {
      ((com.tencent.mm.plugin.story.i.c)localObject).field_readCommentTime = i;
      paramzu = (com.tencent.mm.plugin.story.i.c)localf.MLV;
      localObject = localdjy.HyK.ukj;
      p.g(localObject, "syncMsg.SyncMsgDetail.FromUserName");
      paramzu.aCd((String)localObject);
      paramzu = (com.tencent.mm.plugin.story.i.c)localf.MLV;
      localObject = localdjy.HyK.HxW.nDo;
      p.g(localObject, "syncMsg.SyncMsgDetail.StoryObject.UserName");
      paramzu.aBP((String)localObject);
      ((com.tencent.mm.plugin.story.i.c)localf.MLV).field_syncCommentId = localdjy.HyK.HtH;
      ((com.tencent.mm.plugin.story.i.c)localf.MLV).field_syncCommentTime = localdjy.HyK.CreateTime;
      paramzu = com.tencent.mm.plugin.story.f.j.AKb;
      j.b.ehW().replace((com.tencent.mm.sdk.e.c)localf.MLV);
      com.tencent.mm.ad.c.g((d.g.a.a)new b.b(localf));
      paramzu = ALq.iterator();
      while (paramzu.hasNext()) {
        paramzu.next();
      }
      label631:
      paramzu = null;
      break;
      label636:
      paramzu = localdjy.HyK.HxW.Hyz;
      p.g(paramzu, "commentList");
      paramzu = (dix)d.a.j.E((List)paramzu, paramzu.size() - 2);
      if (paramzu != null)
      {
        i = paramzu.CreateTime;
        paramzu = Integer.valueOf(i);
        break;
      }
      paramzu = null;
      break;
    }
    paramap.sendEmptyMessage(0);
    AppMethodBeat.o(118833);
    return true;
  }
  
  public static boolean g(zu paramzu, ap paramap)
  {
    AppMethodBeat.i(118834);
    p.h(paramzu, "item");
    p.h(paramap, "h");
    try
    {
      localObject = new djy();
      paramzu = paramzu.FYV;
      p.g(paramzu, "item.CmdBuf");
      paramzu = ((djy)localObject).parseFrom(paramzu.getBuffer().toByteArray());
      if (paramzu == null)
      {
        paramzu = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncMsg");
        AppMethodBeat.o(118834);
        throw paramzu;
      }
    }
    catch (Exception paramzu)
    {
      com.tencent.mm.sdk.platformtools.ad.w(TAG, "StorySyncMsg parse error!");
      AppMethodBeat.o(118834);
      return false;
    }
    paramzu = (djy)paramzu;
    Object localObject = paramzu.HyK.ukj;
    int i = paramzu.HyK.CreateTime;
    long l = paramzu.Id;
    com.tencent.mm.sdk.platformtools.ad.i(TAG, "processStoryCommentDel username:" + (String)localObject + " createTime:" + i + " id:" + l);
    localObject = com.tencent.mm.plugin.story.f.b.b.ALT;
    p.h(paramzu, "syncMsg");
    com.tencent.mm.sdk.platformtools.ad.i(com.tencent.mm.plugin.story.f.b.b.TAG, "delSyncComment " + paramzu.Id + ' ' + paramzu.HyK.HtH);
    com.tencent.mm.plugin.story.f.b.b.k(paramzu.HyK.Id, paramzu.HyK.HtH, paramzu.HyK.hDa);
    com.tencent.mm.plugin.story.f.b.b.AI(paramzu.HyK.Id);
    paramzu = ALq.iterator();
    while (paramzu.hasNext()) {
      paramzu.next();
    }
    paramap.sendEmptyMessage(0);
    AppMethodBeat.o(118834);
    return true;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(118835);
    p.h(parame, "dispatcher");
    p.h(paramf, "callback");
    Object localObject1 = g.ajC();
    p.g(localObject1, "MMKernel.storage()");
    Object localObject2 = bt.aRa(bt.nullAsNil((String)((com.tencent.mm.kernel.e)localObject1).ajl().get(8195)));
    localObject1 = new SKBuiltinBuffer_t();
    ((SKBuiltinBuffer_t)localObject1).setBuffer((byte[])localObject2);
    localObject2 = this.rr.aEE();
    if (localObject2 == null)
    {
      parame = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncRequest");
      AppMethodBeat.o(118835);
      throw parame;
    }
    ((dka)localObject2).FRr = ((SKBuiltinBuffer_t)localObject1);
    this.callback = paramf;
    int i = dispatch(parame, (q)this.rr, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(118835);
    return i;
  }
  
  public final int getType()
  {
    return 513;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(118836);
    com.tencent.mm.sdk.platformtools.ad.d(TAG, "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      paramq = this.callback;
      if (paramq == null) {
        p.bcb("callback");
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.al.n)this);
      AppMethodBeat.o(118836);
      return;
    }
    paramq = this.rr.aEF();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncResponse");
      AppMethodBeat.o(118836);
      throw paramString;
    }
    dkb localdkb = (dkb)paramq;
    paramq = localdkb.FRu;
    if (paramq != null)
    {
      paramArrayOfByte = paramq.nDj;
      paramq = paramArrayOfByte;
      if (paramArrayOfByte != null) {}
    }
    else
    {
      paramq = new LinkedList();
    }
    if (paramq.size() > 0)
    {
      paramString = this.ALo;
      p.h(paramq, "cmdList");
      paramString.rbl = paramq;
      paramString.rtH.sendEmptyMessage(0);
      AppMethodBeat.o(118836);
      return;
    }
    if (localdkb.FRr != null)
    {
      paramq = localdkb.FRr;
      p.g(paramq, "resp.KeyBuf");
      if (paramq.getBuffer() != null)
      {
        paramq = localdkb.FRr;
        p.g(paramq, "resp.KeyBuf");
        paramq = paramq.getBuffer().toByteArray();
        paramArrayOfByte = this.rr.aEE();
        if (paramArrayOfByte == null)
        {
          paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncRequest");
          AppMethodBeat.o(118836);
          throw paramString;
        }
        paramq = com.tencent.mm.protocal.ad.k(((dka)paramArrayOfByte).FRr.getBuffer().toByteArray(), paramq);
        if (paramq != null)
        {
          if (paramq.length != 0) {
            break label434;
          }
          paramInt1 = 1;
          if (paramInt1 != 0) {
            break label439;
          }
        }
      }
    }
    label434:
    label439:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (paramInt1 != 0)
      {
        paramArrayOfByte = g.ajC();
        p.g(paramArrayOfByte, "MMKernel.storage()");
        paramArrayOfByte.ajl().set(8195, bt.cE(paramq));
      }
      paramq = this.callback;
      if (paramq == null) {
        p.bcb("callback");
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.al.n)this);
      AppMethodBeat.o(118836);
      return;
      paramInt1 = 0;
      break;
    }
  }
  
  public final int securityLimitCount()
  {
    return this.ALp;
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    return n.b.hOp;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStorySync$RespHandler;", "", "(Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStorySync;)V", "cmdList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/CmdItem;", "getCmdList", "()Ljava/util/LinkedList;", "setCmdList", "(Ljava/util/LinkedList;)V", "h", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getH", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "setH", "(Lcom/tencent/mm/sdk/platformtools/MMHandler;)V", "delaWithCmdList", "", "plugin-story_release"})
  public final class b
  {
    LinkedList<zu> rbl;
    ap rtH;
    
    public b()
    {
      AppMethodBeat.i(118829);
      this.rtH = ((ap)new a(this));
      AppMethodBeat.o(118829);
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/story/model/cgi/NetSceneStorySync$RespHandler$h$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-story_release"})
    public static final class a
      extends ap
    {
      public final void handleMessage(final Message paramMessage)
      {
        AppMethodBeat.i(118828);
        p.h(paramMessage, "msg");
        if (!g.ajA().aiK())
        {
          AppMethodBeat.o(118828);
          return;
        }
        if (this.ALt.rbl != null)
        {
          paramMessage = this.ALt.rbl;
          if (paramMessage == null) {
            p.gfZ();
          }
          if (!paramMessage.isEmpty()) {}
        }
        else
        {
          paramMessage = this.ALt.ALs;
          localObject1 = paramMessage.rr.aEF();
          if (localObject1 == null)
          {
            paramMessage = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncResponse");
            AppMethodBeat.o(118828);
            throw paramMessage;
          }
          localObject1 = (dkb)localObject1;
          Object localObject2 = paramMessage.rr.aEE();
          if (localObject2 == null)
          {
            paramMessage = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncRequest");
            AppMethodBeat.o(118828);
            throw paramMessage;
          }
          localObject2 = (dka)localObject2;
          byte[] arrayOfByte = ((dkb)localObject1).FRr.getBuffer().toByteArray();
          arrayOfByte = com.tencent.mm.protocal.ad.k(((dka)localObject2).FRr.getBuffer().toByteArray(), arrayOfByte);
          if ((arrayOfByte != null) && (arrayOfByte.length > 0))
          {
            com.tencent.mm.kernel.e locale = g.ajC();
            p.g(locale, "MMKernel.storage()");
            locale.ajl().set(8195, bt.cE(arrayOfByte));
          }
          ((dka)localObject2).FRr.setBuffer(arrayOfByte);
          if ((((dkb)localObject1).FMr & ((dka)localObject2).FRq) == 0)
          {
            localObject1 = paramMessage.callback;
            if (localObject1 == null) {
              p.bcb("callback");
            }
            ((f)localObject1).onSceneEnd(0, 0, "", (com.tencent.mm.al.n)paramMessage);
            AppMethodBeat.o(118828);
            return;
          }
          localObject1 = paramMessage.dispatcher();
          p.g(localObject1, "dispatcher()");
          localObject2 = paramMessage.callback;
          if (localObject2 == null) {
            p.bcb("callback");
          }
          paramMessage.doScene((com.tencent.mm.network.e)localObject1, (f)localObject2);
          AppMethodBeat.o(118828);
          return;
        }
        paramMessage = this.ALt.rbl;
        if (paramMessage == null) {
          p.gfZ();
        }
        paramMessage = (zu)paramMessage.getFirst();
        com.tencent.mm.sdk.platformtools.ad.d(h.access$getTAG$cp(), "cmdId = " + paramMessage.FYU);
        Object localObject1 = this.ALt.rbl;
        if (localObject1 == null) {
          p.gfZ();
        }
        ((LinkedList)localObject1).removeFirst();
        switch (paramMessage.FYU)
        {
        case 5: 
        case 6: 
        default: 
          sendEmptyMessage(0);
          AppMethodBeat.o(118828);
          return;
        case 1: 
          localObject1 = com.tencent.mm.plugin.story.f.j.AKb;
          j.b.dFL().post((Runnable)new a(this, paramMessage));
          AppMethodBeat.o(118828);
          return;
        case 2: 
          localObject1 = com.tencent.mm.plugin.story.f.j.AKb;
          j.b.dFL().post((Runnable)new b(this, paramMessage));
          AppMethodBeat.o(118828);
          return;
        case 3: 
          localObject1 = com.tencent.mm.plugin.story.f.j.AKb;
          j.b.dFL().post((Runnable)new c(this, paramMessage));
          AppMethodBeat.o(118828);
          return;
        case 7: 
          localObject1 = com.tencent.mm.plugin.story.f.j.AKb;
          j.b.dFL().post((Runnable)new d(this, paramMessage));
          AppMethodBeat.o(118828);
          return;
        }
        localObject1 = com.tencent.mm.plugin.story.f.j.AKb;
        j.b.dFL().post((Runnable)new e(this, paramMessage));
        AppMethodBeat.o(118828);
      }
      
      @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
      static final class a
        implements Runnable
      {
        a(h.b.a parama, zu paramzu) {}
        
        public final void run()
        {
          AppMethodBeat.i(118823);
          zu localzu = paramMessage;
          p.g(localzu, "item");
          if (!h.c(localzu, (ap)this.ALu)) {
            this.ALu.sendEmptyMessage(0);
          }
          AppMethodBeat.o(118823);
        }
      }
      
      @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
      static final class b
        implements Runnable
      {
        b(h.b.a parama, zu paramzu) {}
        
        public final void run()
        {
          AppMethodBeat.i(118824);
          zu localzu = paramMessage;
          p.g(localzu, "item");
          if (!h.d(localzu, (ap)this.ALu)) {
            this.ALu.sendEmptyMessage(0);
          }
          AppMethodBeat.o(118824);
        }
      }
      
      @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
      static final class c
        implements Runnable
      {
        c(h.b.a parama, zu paramzu) {}
        
        public final void run()
        {
          AppMethodBeat.i(118825);
          zu localzu = paramMessage;
          p.g(localzu, "item");
          if (!h.e(localzu, (ap)this.ALu)) {
            this.ALu.sendEmptyMessage(0);
          }
          AppMethodBeat.o(118825);
        }
      }
      
      @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
      static final class d
        implements Runnable
      {
        d(h.b.a parama, zu paramzu) {}
        
        public final void run()
        {
          AppMethodBeat.i(118826);
          zu localzu = paramMessage;
          p.g(localzu, "item");
          if (!h.f(localzu, (ap)this.ALu)) {
            this.ALu.sendEmptyMessage(0);
          }
          AppMethodBeat.o(118826);
        }
      }
      
      @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
      static final class e
        implements Runnable
      {
        e(h.b.a parama, zu paramzu) {}
        
        public final void run()
        {
          AppMethodBeat.i(118827);
          zu localzu = paramMessage;
          p.g(localzu, "item");
          if (!h.g(localzu, (ap)this.ALu)) {
            this.ALu.sendEmptyMessage(0);
          }
          AppMethodBeat.o(118827);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.a.h
 * JD-Core Version:    0.7.0.1
 */