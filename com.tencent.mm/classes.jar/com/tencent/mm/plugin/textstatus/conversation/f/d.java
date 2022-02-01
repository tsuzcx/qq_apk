package com.tencent.mm.plugin.textstatus.conversation.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.textstatus.a.ac;
import com.tencent.mm.plugin.textstatus.conversation.d.g;
import com.tencent.mm.plugin.textstatus.h.f.i;
import com.tencent.mm.protocal.protobuf.cy;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.v;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/conversation/middler/TextStatusMsgSyncHandler;", "Lcom/tencent/mm/plugin/byp/config/BasePrivateMsgReceiveHanlder;", "Lcom/tencent/mm/plugin/textstatus/conversation/data/TextStatusSessionInfo;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "TAG$1", "retryMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "getRetryMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "checkFetchContact", "", "addBypMsg", "Lcom/tencent/mm/protocal/protobuf/AddBypMsg;", "getBypBizSyncKeyType", "getLocalSeesionInfo", "sessionId", "getRoleType", "ifIgnore", "", "rawBypMsg", "processMsg", "saveSession", "session", "updateSession", "localSesionInfo", "Companion", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends com.tencent.mm.plugin.byp.c.b<g>
{
  public static final d.a Tjo;
  private final ConcurrentHashMap<String, Integer> Tjp;
  private final String mgf;
  
  static
  {
    AppMethodBeat.i(291087);
    Tjo = new d.a((byte)0);
    AppMethodBeat.o(291087);
  }
  
  public d()
  {
    AppMethodBeat.i(291042);
    this.mgf = "MicroMsg.TextStatus.TextStatusMsgSyncHandler";
    this.Tjp = new ConcurrentHashMap();
    AppMethodBeat.o(291042);
  }
  
  private static final void a(d paramd, String paramString, boolean paramBoolean, List paramList)
  {
    AppMethodBeat.i(291075);
    s.u(paramd, "this$0");
    if (!paramBoolean)
    {
      Map localMap = (Map)paramd.Tjp;
      s.s(paramString, "sessionId");
      paramList = (Integer)paramd.Tjp.get(paramString);
      paramd = paramList;
      if (paramList == null) {
        paramd = Integer.valueOf(0);
      }
      localMap.put(paramString, Integer.valueOf(paramd.intValue() + 1));
    }
    AppMethodBeat.o(291075);
  }
  
  private final boolean f(cy paramcy)
  {
    Object localObject1 = null;
    AppMethodBeat.i(291066);
    if (!ac.hFT())
    {
      AppMethodBeat.o(291066);
      return true;
    }
    Log.d(this.mgf, "processMsg() called with msgType: " + paramcy.YFg.IIs + " addBypMsg" + com.tencent.mm.plugin.byp.d.a.e(paramcy));
    Object localObject4 = com.tencent.mm.plugin.textstatus.conversation.g.d.Tjx;
    if (!com.tencent.mm.plugin.textstatus.conversation.g.d.hGA()) {
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adhk, Boolean.TRUE);
    }
    if (paramcy.YFg.IIs == 10002) {}
    for (;;)
    {
      try
      {
        localObject4 = paramcy.YFg;
        if (localObject4 != null) {
          break label316;
        }
        localObject1 = XmlParser.parseXml((String)localObject1, "statussquareprivatechatgreeting", null);
        if ((localObject1 != null) && (((Map)localObject1).size() > 0))
        {
          localObject4 = com.tencent.mm.plugin.textstatus.b.f.TjQ;
          localObject1 = com.tencent.mm.plugin.textstatus.b.f.hGN().a((Map)localObject1, paramcy);
          localObject4 = com.tencent.mm.plugin.textstatus.conversation.g.a.Tjq;
          com.tencent.mm.plugin.textstatus.conversation.g.a.a((com.tencent.mm.plugin.textstatus.conversation.d.d)localObject1, null, null, 14);
          AppMethodBeat.o(291066);
          return true;
        }
      }
      finally {}
      s.u(paramcy, "addBypMsg");
      String str1 = paramcy.YFh;
      String str2 = w.a(paramcy.YFg.YFE);
      Object localObject3 = com.tencent.mm.plugin.textstatus.conversation.g.a.Tjq;
      localObject3 = com.tencent.mm.plugin.textstatus.conversation.g.a.bdK(str1);
      if (localObject3 != null)
      {
        ((com.tencent.mm.plugin.textstatus.h.f.h)localObject3).field_canTalk = 1;
        localObject4 = com.tencent.mm.plugin.textstatus.b.f.TjQ;
        com.tencent.mm.plugin.textstatus.b.f.hGK().update((IAutoDBItem)localObject3, new String[0]);
      }
      if (localObject3 == null)
      {
        localObject4 = (Integer)this.Tjp.get(str1);
        localObject3 = localObject4;
        if (localObject4 == null) {
          localObject3 = Integer.valueOf(0);
        }
        if (((Number)localObject3).intValue() < 5)
        {
          Log.i(this.mgf, s.X("checkFetchContact() contact is null, addBypMsg:", com.tencent.mm.plugin.byp.d.a.e(paramcy)));
          paramcy = com.tencent.mm.plugin.textstatus.conversation.g.a.Tjq;
          com.tencent.mm.plugin.textstatus.conversation.g.a.a(v.Y(str1, str2), new d..ExternalSyntheticLambda0(this, str1), false, 12);
        }
      }
      AppMethodBeat.o(291066);
      return false;
      label316:
      localObject4 = ((dl)localObject4).YFG;
      if (localObject4 != null) {
        localObject3 = ((etl)localObject4).toString();
      }
    }
  }
  
  public final boolean d(cy paramcy)
  {
    AppMethodBeat.i(291128);
    s.u(paramcy, "rawBypMsg");
    boolean bool = f(paramcy);
    AppMethodBeat.o(291128);
    return bool;
  }
  
  public final int dij()
  {
    return 6;
  }
  
  public final int dik()
  {
    return 4;
  }
  
  public final String getTAG()
  {
    return this.mgf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.conversation.f.d
 * JD-Core Version:    0.7.0.1
 */