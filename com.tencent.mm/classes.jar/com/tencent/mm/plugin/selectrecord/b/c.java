package com.tencent.mm.plugin.selectrecord.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.a;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.br;
import com.tencent.mm.model.bt;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.ae;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.messenger.foundation.d;
import com.tencent.mm.plugin.messenger.foundation.i.a;
import com.tencent.mm.plugin.selectrecord.PluginSelectRecord;
import com.tencent.mm.protocal.protobuf.czy;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.zd;
import com.tencent.mm.protocal.protobuf.ze;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/selectrecord/model/HistoryRecordUnPackMsgLogic;", "", "downloadInfo", "Lcom/tencent/mm/protocal/protobuf/HistoryDownloadInfo;", "(Lcom/tencent/mm/protocal/protobuf/HistoryDownloadInfo;)V", "cmdIndex", "", "getDownloadInfo", "()Lcom/tencent/mm/protocal/protobuf/HistoryDownloadInfo;", "setDownloadInfo", "existMsgMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/storage/MsgInfo;", "Lkotlin/collections/HashMap;", "handler", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "getHandler", "()Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "setHandler", "(Lcom/tencent/mm/sdk/platformtools/MTimerHandler;)V", "lastFixTime", "getLastFixTime", "()J", "setLastFixTime", "(J)V", "msgList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/AddMsg;", "msgMaxCreateTime", "msgMinCreateTime", "doCmd", "", "addMsg", "Companion", "plugin-select-record_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final a PmA;
  private czy PmB;
  private final LinkedList<dl> PmC;
  private final HashMap<Long, cc> PmD;
  private long PmE;
  private long PmF;
  private long PmG;
  private int oLT;
  MTimerHandler oNL;
  
  static
  {
    AppMethodBeat.i(266791);
    PmA = new a((byte)0);
    AppMethodBeat.o(266791);
  }
  
  public c(czy paramczy)
  {
    AppMethodBeat.i(266726);
    this.PmB = paramczy;
    this.PmC = new LinkedList();
    this.PmD = new HashMap();
    this.oNL = new MTimerHandler(com.tencent.mm.kernel.h.baH().getLooper(), new c..ExternalSyntheticLambda0(this), true);
    AppMethodBeat.o(266726);
  }
  
  private static final boolean a(c paramc)
  {
    AppMethodBeat.i(266755);
    s.u(paramc, "this$0");
    if ((!com.tencent.mm.kernel.h.baz()) || (com.tencent.mm.kernel.b.aZG()) || (com.tencent.mm.kernel.h.baE() == null) || (com.tencent.mm.kernel.h.baE().ban() == null))
    {
      Log.e("MicroMsg.selectRecord.HistoryRecordUnPackMsgLogic", "accready:%s hold:%s accstg:%s ", new Object[] { Boolean.valueOf(com.tencent.mm.kernel.h.baz()), Boolean.valueOf(com.tencent.mm.kernel.b.aZG()), com.tencent.mm.kernel.h.baE() });
      AppMethodBeat.o(266755);
      return false;
    }
    Log.d("MicroMsg.selectRecord.HistoryRecordUnPackMsgLogic", "msgInfoStg lockForSync called");
    ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().aLB("MicroMsg.selectRecord.HistoryRecordUnPackMsgLogic");
    long l1 = Util.nowMilliSecond();
    long l2;
    do
    {
      if (paramc.oLT >= paramc.PmC.size()) {
        break;
      }
      boolean bool = paramc.e((dl)paramc.PmC.get(paramc.oLT));
      paramc.oLT += 1;
      l2 = Util.milliSecondsToNow(l1);
      Log.i("MicroMsg.selectRecord.HistoryRecordUnPackMsgLogic", "time:%s size:%s index:%s, ret:%s", new Object[] { Long.valueOf(l2), Integer.valueOf(paramc.PmC.size()), Integer.valueOf(paramc.oLT - 1), Boolean.valueOf(bool) });
    } while (l2 < 500L);
    ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().aLC("MicroMsg.selectRecord.HistoryRecordUnPackMsgLogic");
    Log.d("MicroMsg.selectRecord.HistoryRecordUnPackMsgLogic", "msgInfoStg unlockForSync called");
    if (paramc.oLT < paramc.PmC.size())
    {
      Log.i("MicroMsg.selectRecord.HistoryRecordUnPackMsgLogic", "time:%s size:%s index:%s Shold Continue.", new Object[] { Long.valueOf(Util.milliSecondsToNow(l1)), Integer.valueOf(paramc.PmC.size()), Integer.valueOf(paramc.oLT - 1) });
      AppMethodBeat.o(266755);
      return true;
    }
    zd localzd = new zd();
    Object localObject = ((Iterable)paramc.PmC).iterator();
    while (((Iterator)localObject).hasNext())
    {
      dl localdl = (dl)((Iterator)localObject).next();
      localzd.ZhI.add(Long.valueOf(localdl.Njv));
    }
    localObject = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sl(paramc.PmB.msgId);
    ((cc)localObject).po(((fi)localObject).jUq | 0x40000);
    ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().a(((fi)localObject).field_msgId, (cc)localObject);
    ((PluginSelectRecord)com.tencent.mm.kernel.h.az(PluginSelectRecord.class)).getSelectRecordStorage().a(paramc.PmB.aaFt, localzd);
    Log.i("MicroMsg.selectRecord.HistoryRecordUnPackMsgLogic", "should finish");
    AppMethodBeat.o(266755);
    return false;
  }
  
  private final boolean e(dl paramdl)
  {
    AppMethodBeat.i(266744);
    if (paramdl == null)
    {
      AppMethodBeat.o(266744);
      return false;
    }
    if (!com.tencent.mm.kernel.h.baz())
    {
      Log.e("MicroMsg.selectRecord.HistoryRecordUnPackMsgLogic", "account storage disabled, discard all commands");
      AppMethodBeat.o(266744);
      return false;
    }
    long l2 = 1000L * paramdl.CreateTime;
    long l1 = l2;
    if (l2 <= this.PmG) {
      l1 = this.PmG + 1L;
    }
    this.PmG = l1;
    Object localObject1;
    Object localObject2;
    if ((paramdl.YFJ == null) || (bt.JR(paramdl.YFJ) == -1L))
    {
      localObject1 = paramdl.YFJ;
      l2 = paramdl.Njv;
      localObject2 = b.Pmz;
      paramdl.YFJ = bt.b((String)localObject1, l1, l2, b.d(paramdl));
    }
    if ((this.PmD.containsKey(Long.valueOf(paramdl.Njv))) || (((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sn(paramdl.Njv)))
    {
      l2 = paramdl.Njv;
      paramdl.Njv = bt.JS(paramdl.YFJ);
      Log.d("MicroMsg.selectRecord.HistoryRecordUnPackMsgLogic", "srvId exist oldSrvId:%s newSrvId:%s", new Object[] { Long.valueOf(l2), Long.valueOf(paramdl.Njv) });
    }
    int i;
    int k;
    int j;
    if (l1 <= this.PmF)
    {
      Log.d("MicroMsg.selectRecord.HistoryRecordUnPackMsgLogic", "doCmd() case 1 fixTime:%s, msgMinCreateTime:%s", new Object[] { Long.valueOf(l1), Long.valueOf(this.PmF) });
      l2 = this.PmF + 1L;
      this.PmF = l2;
      if (Log.getLogLevel() <= 1) {
        Log.d("MicroMsg.selectRecord.HistoryRecordUnPackMsgLogic", "doCmd() after fix fixTime:%s SrvId:%S content:%s", new Object[] { Long.valueOf(l2), Long.valueOf(paramdl.Njv), paramdl.YFG });
      }
      if (Util.isEqual(paramdl.YFF.abwM, z.bAM()))
      {
        localObject1 = paramdl.YFF;
        paramdl.YFF = paramdl.YFE;
        paramdl.YFE = ((etl)localObject1);
        localObject1 = paramdl.YFG;
        if (localObject1 != null)
        {
          localObject2 = ((etl)localObject1).abwM;
          if (localObject2 != null)
          {
            i = br.JG((String)localObject2);
            if (i != -1)
            {
              localObject1 = new etl();
              localObject2 = ((String)localObject2).substring(i + 1);
              s.s(localObject2, "(this as java.lang.String).substring(startIndex)");
              localObject2 = (CharSequence)localObject2;
              i = ((CharSequence)localObject2).length() - 1;
              k = 0;
              j = 0;
            }
          }
        }
      }
    }
    else
    {
      for (;;)
      {
        label440:
        if (j > i) {
          break label581;
        }
        int m;
        if (k == 0)
        {
          m = j;
          label453:
          if (s.compare(((CharSequence)localObject2).charAt(m), 32) > 0) {
            break label556;
          }
          m = 1;
        }
        for (;;)
        {
          if (k == 0)
          {
            if (m == 0)
            {
              k = 1;
              break label440;
              l2 = l1;
              if (l1 < this.PmE) {
                break;
              }
              Log.d("MicroMsg.selectRecord.HistoryRecordUnPackMsgLogic", "doCmd() case 2 fixTime:%s, msgMinCreateTime:%s", new Object[] { Long.valueOf(l1), Long.valueOf(this.PmF) });
              l2 = this.PmE - 1L;
              this.PmE = l2;
              break;
              m = i;
              break label453;
              label556:
              m = 0;
              continue;
            }
            j += 1;
            break label440;
          }
        }
        if (m == 0) {
          break label581;
        }
        i -= 1;
      }
      label581:
      paramdl.YFG = ((etl)localObject1).btH(((CharSequence)localObject2).subSequence(j, i + 1).toString());
    }
    try
    {
      d.processAddMsg(new g.a(paramdl, l2), (ae)new i.a());
      AppMethodBeat.o(266744);
      return true;
    }
    catch (Exception paramdl)
    {
      Log.printErrStackTrace("MicroMsg.selectRecord.HistoryRecordUnPackMsgLogic", (Throwable)paramdl, "", new Object[0]);
      AppMethodBeat.o(266744);
    }
    return false;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/selectrecord/model/HistoryRecordUnPackMsgLogic$Companion;", "", "()V", "TAG", "", "unPackMsg", "", "chatHistoryMsgList", "Lcom/tencent/mm/protocal/protobuf/ChatHistoryMsgList;", "info", "Lcom/tencent/mm/protocal/protobuf/HistoryDownloadInfo;", "plugin-select-record_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    private static final void a(czy paramczy, LinkedList paramLinkedList)
    {
      AppMethodBeat.i(266727);
      s.u(paramczy, "$info");
      s.u(paramLinkedList, "$msgs");
      c localc = new c(paramczy);
      c.e(localc);
      c.f(localc).addAll((Collection)paramLinkedList);
      c.b(localc, paramczy.lxm - 1L);
      paramLinkedList = ((Iterable)paramLinkedList).iterator();
      while (paramLinkedList.hasNext())
      {
        Object localObject = (dl)paramLinkedList.next();
        localObject = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().aU(paramczy.talker, ((dl)localObject).Njv);
        if ((localObject != null) && (((fi)localObject).field_msgId != 0L)) {
          ((Map)c.b(localc)).put(Long.valueOf(((fi)localObject).field_msgSvrId), localObject);
        }
      }
      paramLinkedList = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().bk(paramczy.talker, paramczy.lxm);
      if (paramLinkedList == null) {}
      for (paramLinkedList = null;; paramLinkedList = ah.aiuX)
      {
        if (paramLinkedList == null)
        {
          c.a(localc, ((n)com.tencent.mm.kernel.h.ax(n.class)).bAd().aLt(paramczy.talker));
          Log.i("MicroMsg.selectRecord.HistoryRecordUnPackMsgLogic", "no before msg, talker:" + paramczy.talker + ", createTime:" + paramczy.lxm + ", msgMinCreateTime:" + c.c(localc) + ", msgMaxCreateTime:" + c.d(localc) + " existSize:" + c.b(localc).size());
        }
        c.f(localc).size();
        com.tencent.mm.kernel.h.baH().postToWorker(new c.a..ExternalSyntheticLambda0(localc));
        AppMethodBeat.o(266727);
        return;
        c.a(localc, paramLinkedList.getCreateTime());
        Log.i("MicroMsg.selectRecord.HistoryRecordUnPackMsgLogic", "getBeforeMsg talker:" + paramczy.talker + ", msgCreateTime:" + paramczy.lxm + ", msgMinCreateTime:" + c.c(localc) + ", msgMaxCreateTime:" + c.d(localc) + " existSize:" + c.b(localc).size() + " lastContent:" + paramLinkedList.field_content);
      }
    }
    
    public static void a(ze paramze, czy paramczy)
    {
      AppMethodBeat.i(266708);
      s.u(paramczy, "info");
      paramze = paramze.PmC;
      if (paramze == null) {}
      for (paramze = null;; paramze = com.tencent.threadpool.h.ahAA.bm(new c.a..ExternalSyntheticLambda1(paramczy, paramze)))
      {
        paramczy = paramze;
        if (paramze == null)
        {
          Log.e("MicroMsg.selectRecord.HistoryRecordUnPackMsgLogic", "unPackMsg magList is null");
          paramczy = ah.aiuX;
        }
        if (paramczy == null) {
          Log.e("MicroMsg.selectRecord.HistoryRecordUnPackMsgLogic", "unPackMsg chatHistoryMsgList is null");
        }
        AppMethodBeat.o(266708);
        return;
      }
    }
    
    private static final void g(c paramc)
    {
      AppMethodBeat.i(266714);
      s.u(paramc, "$this_apply");
      paramc.oNL.startTimer(50L);
      AppMethodBeat.o(266714);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.selectrecord.b.c
 * JD-Core Version:    0.7.0.1
 */