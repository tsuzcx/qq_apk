package com.tencent.mm.plugin.patmsg;

import android.content.Context;
import android.content.res.Resources;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.h.a;
import com.tencent.mm.an.q;
import com.tencent.mm.f.a.qd;
import com.tencent.mm.f.b.a.jq;
import com.tencent.mm.f.b.a.kc;
import com.tencent.mm.f.c.et;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.cm;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.protocal.protobuf.dit;
import com.tencent.mm.protocal.protobuf.diu;
import com.tencent.mm.protocal.protobuf.div;
import com.tencent.mm.protocal.protobuf.eea;
import com.tencent.mm.protocal.protobuf.eeb;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandler.Callback;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.ca;
import com.tencent.mm.util.g;
import com.tencent.mm.util.g.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class a
  implements com.tencent.mm.an.i, com.tencent.mm.plugin.patmsg.a.b
{
  private static final int GKf;
  private static Map<String, Long> GKg;
  public static final int GKj;
  private static final int GKk;
  private Set<Long> GKh;
  private com.tencent.mm.plugin.patmsg.b.c GKi;
  public final com.tencent.mm.plugin.messenger.foundation.a.t GKl;
  private MMHandler GKm;
  
  static
  {
    AppMethodBeat.i(186661);
    GKf = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vXZ, 10000);
    GKg = new HashMap();
    GKj = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vYc, 5000);
    GKk = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vYb, 10000);
    AppMethodBeat.o(186661);
  }
  
  public a()
  {
    AppMethodBeat.i(186616);
    this.GKh = new HashSet();
    this.GKl = new com.tencent.mm.plugin.messenger.foundation.a.t()
    {
      public final void onNewXmlReceived(String paramAnonymousString, final Map<String, String> paramAnonymousMap, final h.a paramAnonymousa)
      {
        AppMethodBeat.i(186595);
        if ("pat".equals(paramAnonymousString)) {
          com.tencent.e.h.ZvG.d(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(186483);
              String str1 = (String)paramAnonymousMap.get(".sysmsg.pat.fromusername");
              String str2 = (String)paramAnonymousMap.get(".sysmsg.pat.chatusername");
              String str3 = (String)paramAnonymousMap.get(".sysmsg.pat.pattedusername");
              String str4 = (String)paramAnonymousMap.get(".sysmsg.pat.template");
              Log.i("MicroMsg.PatMsgExtension", "fromUser: %s, chatUser: %s, pattedUser: %s, template:%s", new Object[] { str1, str2, str3, str4 });
              if (!((PluginPatMsg)com.tencent.mm.kernel.h.ag(PluginPatMsg.class)).isPatEnable())
              {
                AppMethodBeat.o(186483);
                return;
              }
              if (((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().Os(paramAnonymousa.jQG.HlH))
              {
                Log.w("MicroMsg.PatMsgExtension", "ignore insert, msg %d should be deleted!", new Object[] { Long.valueOf(paramAnonymousa.jQG.HlH) });
                AppMethodBeat.o(186483);
                return;
              }
              a.a(a.this, str2, str1, str3, str4, paramAnonymousa.jQG.CreateTime, paramAnonymousa.jQG.HlH);
              AppMethodBeat.o(186483);
            }
          }, "HandlePatMsg");
        }
        AppMethodBeat.o(186595);
      }
    };
    this.GKm = new MMHandler(Looper.getMainLooper(), new MMHandler.Callback()
    {
      public final boolean handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(186466);
        Pair localPair;
        boolean bool;
        dit localdit;
        diu localdiu;
        if (paramAnonymousMessage.what == 291)
        {
          localObject = (com.tencent.mm.plugin.patmsg.b.c)paramAnonymousMessage.obj;
          Log.i("MicroMsg.PatMsgExtension", "send pat msg, msgId:%d, createTime:%d scene:%d, talker:%s, patUser:%s", new Object[] { ((com.tencent.mm.plugin.patmsg.b.c)localObject).GKz.first, ((com.tencent.mm.plugin.patmsg.b.c)localObject).GKz.second, Integer.valueOf(((com.tencent.mm.plugin.patmsg.b.c)localObject).scene), ((com.tencent.mm.plugin.patmsg.b.c)localObject).talker, ((com.tencent.mm.plugin.patmsg.b.c)localObject).GKB });
          paramAnonymousMessage = a.this;
          i = ((com.tencent.mm.plugin.patmsg.b.c)localObject).scene;
          localPair = ((com.tencent.mm.plugin.patmsg.b.c)localObject).GKz;
          bool = ((com.tencent.mm.plugin.patmsg.b.c)localObject).GKC;
          Log.i("MicroMsg.PatMsgExtension", "send pat, scene %d, msg (%d,%d)", new Object[] { Integer.valueOf(i), localPair.first, localPair.second });
          if (((PluginPatMsg)com.tencent.mm.kernel.h.ag(PluginPatMsg.class)).isPatEnable())
          {
            localObject = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().Oq(((Long)localPair.first).longValue());
            if (((et)localObject).field_msgId == ((Long)localPair.first).longValue())
            {
              localdit = g.bBr(((et)localObject).field_content);
              localdiu = paramAnonymousMessage.a(localdit, ((Long)localPair.second).longValue());
              if (localdiu != null)
              {
                if (paramAnonymousMessage.M(i, localdit.iRq, localdiu.TQk)) {
                  break label300;
                }
                Log.w("MicroMsg.PatMsgExtension", "cannot pat, scene %d, talker %s, patUser %s", new Object[] { Integer.valueOf(i), localdit.iRq, localdiu.TQk });
              }
            }
          }
        }
        AppMethodBeat.o(186466);
        return false;
        label300:
        Object localObject = new kc();
        ((kc)localObject).ggl = i;
        if (ab.PP(localdit.iRq)) {
          ((kc)localObject).Bc(localdit.iRq);
        }
        ((kc)localObject).gMB = (((Long)localPair.second).longValue() - ((com.tencent.mm.plugin.patmsg.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.patmsg.a.b.class)).b(localdit.iRq, localPair));
        if (a.a(localdit.iRq, localPair))
        {
          i = 1;
          label389:
          ((kc)localObject).gMD = i;
          ((kc)localObject).gME = (paramAnonymousMessage.b(localdit, ((Long)localPair.second).longValue()) + 1);
          ((kc)localObject).Ba(localdiu.fLi);
          ((kc)localObject).Bb(localdiu.TQk);
          ((kc)localObject).gLF = localdiu.createTime;
          ((kc)localObject).Bd(c.aUh(localdiu.TQk));
          if (!bool) {
            break label520;
          }
        }
        label520:
        for (int i = 1;; i = 0)
        {
          ((kc)localObject).gMF = i;
          paramAnonymousMessage = new com.tencent.mm.plugin.patmsg.b.b(localPair, localdit.iRq, localdiu.TQk);
          paramAnonymousMessage.GKA = ((kc)localObject);
          com.tencent.mm.kernel.h.aGY().a(paramAnonymousMessage, 0);
          break;
          i = 0;
          break label389;
        }
      }
    });
    AppMethodBeat.o(186616);
  }
  
  private static Pair<Long, Long> a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, long paramLong)
  {
    AppMethodBeat.i(186617);
    Object localObject;
    long l1;
    if (!Util.isNullOrNil(new String[] { paramString2, paramString1, paramString3 }))
    {
      localObject = paramString1;
      if (paramString1.equals(z.bcZ())) {
        localObject = paramString2;
      }
      if ((ab.PP((String)localObject)) && (!((n)com.tencent.mm.kernel.h.ae(n.class)).eRZ().aOp((String)localObject)))
      {
        paramString1 = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aOH((String)localObject);
        if ((paramString1 != null) && (paramString1.field_msgId > 0L) && (paramString1.getType() == 922746929))
        {
          l1 = paramInt * 1000L;
          if (l1 > paramString1.field_createTime) {
            break label887;
          }
          l1 = paramString1.field_createTime + 1L;
        }
      }
    }
    label887:
    for (;;)
    {
      localObject = new diu();
      ((diu)localObject).lqH = paramString4;
      ((diu)localObject).createTime = l1;
      ((diu)localObject).fLi = paramString2;
      ((diu)localObject).TQk = paramString3;
      ((diu)localObject).rPF = paramLong;
      paramString2 = g.bBr(paramString1.field_content);
      paramString2.iRq = paramString1.field_talker;
      paramString2.Ezu.add(localObject);
      paramString3 = new k.b();
      paramString4 = new com.tencent.mm.plugin.patmsg.a.a();
      paramString4.GKw = paramString2;
      paramString3.a(paramString4);
      paramString3.type = 62;
      paramString3.title = MMApplicationContext.getContext().getString(d.f.low_version_upgrade_tip);
      paramString3.url = MMApplicationContext.getContext().getString(d.f.low_version_upgrade_url);
      paramString1.setContent(k.b.a(paramString3, "", null));
      paramLong = paramString1.field_msgId;
      if (paramLong != 0L) {
        ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().a(paramLong, paramString1);
      }
      ((PluginPatMsg)com.tencent.mm.kernel.h.ag(PluginPatMsg.class)).addRecvRecord(paramString1.field_msgSvrId, (diu)localObject);
      Log.i("MicroMsg.PatMsgExtension", "update pat msg %d, index %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramString2.Ezu.size() - 1) });
      paramString1 = Pair.create(Long.valueOf(paramLong), Long.valueOf(l1));
      AppMethodBeat.o(186617);
      return paramString1;
      l1 = bq.z((String)localObject, paramInt);
      paramString1 = new ca();
      dit localdit = new dit();
      localdit.iRq = ((String)localObject);
      diu localdiu = new diu();
      localdiu.lqH = paramString4;
      localdiu.createTime = l1;
      localdiu.fLi = paramString2;
      localdiu.TQk = paramString3;
      localdiu.rPF = paramLong;
      paramString4 = com.tencent.mm.kernel.h.aHG().aHp().a(ar.a.VDu, "");
      long l2 = com.tencent.mm.kernel.h.aHG().aHp().a(ar.a.VDC, 0L);
      paramInt = com.tencent.mm.kernel.h.aHG().aHp().getInt(ar.a.VDD, 0);
      if ((paramString3.equals(z.bcZ())) && (!Util.isNullOrNil(paramString4)) && (cm.bfE() - l2 > ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vXv, 86400L) * 1000L) && (paramInt < ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vXw, 2147483647)))
      {
        Log.i("MicroMsg.PatMsgExtension", "show modify tip %s %s %s %s %s", new Object[] { Long.valueOf(paramLong), paramString2, Long.valueOf(l2), Integer.valueOf(paramInt), paramString4 });
        localdiu.TQm = 1;
        com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VDC, Long.valueOf(cm.bfE()));
        com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VDD, Integer.valueOf(paramInt + 1));
      }
      localdit.Ezu.add(localdiu);
      paramString2 = new k.b();
      paramString3 = new com.tencent.mm.plugin.patmsg.a.a();
      paramString3.GKw = localdit;
      paramString2.a(paramString3);
      paramString2.type = 62;
      paramString2.title = MMApplicationContext.getContext().getString(d.f.low_version_upgrade_tip);
      paramString2.url = MMApplicationContext.getContext().getString(d.f.low_version_upgrade_url);
      paramString1.setContent(k.b.a(paramString2, "", null));
      paramString1.pJ(0);
      paramString1.Jm((String)localObject);
      paramString1.EG(paramLong);
      paramString1.setCreateTime(l1);
      paramString1.setType(922746929);
      ((PluginPatMsg)com.tencent.mm.kernel.h.ag(PluginPatMsg.class)).addRecvRecord(paramString1.field_msgSvrId, localdiu);
      paramLong = bq.z(paramString1);
      Log.i("MicroMsg.PatMsgExtension", "insert pat msg %d %s %s", new Object[] { Long.valueOf(paramLong), Integer.toHexString(paramString1.getType()), Integer.toHexString(922746929) });
      paramString1 = Pair.create(Long.valueOf(paramLong), Long.valueOf(l1));
      AppMethodBeat.o(186617);
      return paramString1;
      paramString1 = Pair.create(Long.valueOf(0L), Long.valueOf(0L));
      AppMethodBeat.o(186617);
      return paramString1;
    }
  }
  
  static boolean a(String paramString, Pair<Long, Long> paramPair)
  {
    AppMethodBeat.i(186625);
    long l = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aOZ(paramString);
    if (((Long)paramPair.second).longValue() <= l)
    {
      AppMethodBeat.o(186625);
      return true;
    }
    AppMethodBeat.o(186625);
    return false;
  }
  
  public final boolean M(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(186621);
    if (((paramInt == 3) || (paramInt == 4) || (paramInt == 5)) && (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vXt, 0) == 0))
    {
      AppMethodBeat.o(186621);
      return false;
    }
    if (((!ab.PP(paramString1)) && (!ab.PM(paramString1))) || (ab.QS(paramString1)) || (ab.QY(paramString1)) || (ab.QO(paramString1)) || (ab.Qm(paramString1)))
    {
      Log.i("MicroMsg.PatMsgExtension", "cannot pat, talker %s", new Object[] { paramString1 });
      AppMethodBeat.o(186621);
      return false;
    }
    if ((!ab.PM(paramString2)) || (ab.QS(paramString2)) || (ab.QY(paramString2)) || (ab.QO(paramString2)) || (ab.Qm(paramString2)))
    {
      Log.i("MicroMsg.PatMsgExtension", "cannot pat, user %s", new Object[] { paramString2 });
      AppMethodBeat.o(186621);
      return false;
    }
    if (ab.PP(paramString1))
    {
      List localList = v.Ps(paramString1);
      if ((localList != null) && (!localList.contains(paramString2)))
      {
        Log.w("MicroMsg.PatMsgExtension", "chatroom %s members %s, not contain %s", new Object[] { paramString1, localList, paramString2 });
        AppMethodBeat.o(186621);
        return false;
      }
    }
    AppMethodBeat.o(186621);
    return true;
  }
  
  public final Pair<Long, Long> N(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(186622);
    Log.i("MicroMsg.PatMsgExtension", "preSend pat, scene %d, talker %s, user %s", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2 });
    long l = cm.bfD();
    if (!((PluginPatMsg)com.tencent.mm.kernel.h.ag(PluginPatMsg.class)).isPatEnable())
    {
      AppMethodBeat.o(186622);
      return null;
    }
    if (!M(paramInt, paramString1, paramString2))
    {
      Log.w("MicroMsg.PatMsgExtension", "cannot pat, scene %d, talker %s, user %s", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2 });
      AppMethodBeat.o(186622);
      return null;
    }
    Object localObject2 = z.bcZ();
    Object localObject1 = new kc();
    ((kc)localObject1).ggl = paramInt;
    if (ab.PP(paramString1)) {
      ((kc)localObject1).Bc(paramString1);
    }
    ((kc)localObject1).Ba((String)localObject2);
    ((kc)localObject1).Bb(paramString2);
    ((kc)localObject1).gLF = l;
    ((kc)localObject1).Bd(c.aUh(paramString2));
    Object localObject3 = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aOH(paramString1);
    if ((localObject3 != null) && (((et)localObject3).field_msgId > 0L))
    {
      if (((ca)localObject3).getType() != 922746929) {
        break label356;
      }
      localObject3 = g.bBr(((et)localObject3).field_content);
      if (((dit)localObject3).Ezu.size() <= 0) {}
    }
    label356:
    for (((kc)localObject1).gMB = (l - ((diu)((dit)localObject3).Ezu.getLast()).createTime); (GKg.containsKey(paramString2)) && (l - ((Long)GKg.get(paramString2)).longValue() < GKf); ((kc)localObject1).gMB = (l - ((et)localObject3).field_createTime))
    {
      Log.w("MicroMsg.PatMsgExtension", "pat (%s) last time from now < %d", new Object[] { paramString2, Integer.valueOf(GKf) });
      ((kc)localObject1).gMC = 1;
      ((kc)localObject1).bpa();
      paramString1 = com.tencent.mm.util.c.Yyz;
      com.tencent.mm.util.c.a((com.tencent.mm.plugin.report.a)localObject1);
      AppMethodBeat.o(186622);
      return null;
    }
    this.GKi = null;
    GKg.put(paramString2, Long.valueOf(l));
    localObject1 = a(paramString1, (String)localObject2, paramString2, aUg(paramString2), (int)(l / 1000L), 0L);
    if (((Long)((Pair)localObject1).first).longValue() > 0L)
    {
      localObject2 = new com.tencent.mm.plugin.patmsg.b.b((Pair)localObject1, paramString1, paramString2, 1);
      com.tencent.mm.kernel.h.aGY().a((q)localObject2, 0);
      localObject2 = new com.tencent.mm.plugin.patmsg.b.c();
      ((com.tencent.mm.plugin.patmsg.b.c)localObject2).scene = paramInt;
      ((com.tencent.mm.plugin.patmsg.b.c)localObject2).talker = paramString1;
      ((com.tencent.mm.plugin.patmsg.b.c)localObject2).GKB = paramString2;
      ((com.tencent.mm.plugin.patmsg.b.c)localObject2).GKz = ((Pair)localObject1);
      this.GKm.sendMessageDelayed(this.GKm.obtainMessage(291, localObject2), GKj);
      this.GKi = ((com.tencent.mm.plugin.patmsg.b.c)localObject2);
    }
    AppMethodBeat.o(186622);
    return localObject1;
  }
  
  public final boolean OX(long paramLong)
  {
    AppMethodBeat.i(186620);
    if (this.GKh.contains(Long.valueOf(paramLong)))
    {
      AppMethodBeat.o(186620);
      return true;
    }
    Object localObject = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().Oq(paramLong);
    if (((et)localObject).field_msgId > 0L)
    {
      localObject = g.bBr(((et)localObject).field_content).Ezu.iterator();
      int i = 1;
      if (((Iterator)localObject).hasNext())
      {
        if (((diu)((Iterator)localObject).next()).TQl == 1) {}
        for (int j = 1;; j = 0)
        {
          i = j & i;
          break;
        }
      }
      if (i != 0)
      {
        this.GKh.add(Long.valueOf(paramLong));
        AppMethodBeat.o(186620);
        return true;
      }
    }
    AppMethodBeat.o(186620);
    return false;
  }
  
  public final List<ca> OY(long paramLong)
  {
    AppMethodBeat.i(186654);
    Object localObject1 = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().Oq(paramLong);
    if (((ca)localObject1).getType() == 922746929)
    {
      ArrayList localArrayList = new ArrayList();
      localObject1 = g.bBr(((et)localObject1).field_content);
      if (((dit)localObject1).Ezu == null) {}
      for (int i = 0;; i = ((dit)localObject1).Ezu.size())
      {
        Log.i("MicroMsg.PatMsgExtension", "split pat msg [%d] to %d child msg", new Object[] { Long.valueOf(paramLong), Integer.valueOf(i) });
        Iterator localIterator = ((dit)localObject1).Ezu.iterator();
        while (localIterator.hasNext())
        {
          diu localdiu = (diu)localIterator.next();
          ca localca = new ca();
          dit localdit = new dit();
          localdit.iRq = ((dit)localObject1).iRq;
          Object localObject2 = new g.a();
          ((g.a)localObject2).lqH = localdiu.lqH;
          ((g.a)localObject2).YyU = localdiu.lqH;
          ((g.a)localObject2).createTime = localdiu.createTime;
          ((g.a)localObject2).fLi = localdiu.fLi;
          ((g.a)localObject2).TQk = localdiu.TQk;
          ((g.a)localObject2).rPF = localdiu.rPF;
          localdit.Ezu.add(localObject2);
          localObject2 = new k.b();
          com.tencent.mm.plugin.patmsg.a.a locala = new com.tencent.mm.plugin.patmsg.a.a();
          locala.GKw = localdit;
          ((k.b)localObject2).a(locala);
          ((k.b)localObject2).type = 62;
          ((k.b)localObject2).title = MMApplicationContext.getContext().getString(d.f.low_version_upgrade_tip);
          ((k.b)localObject2).url = MMApplicationContext.getContext().getString(d.f.low_version_upgrade_url);
          localca.setContent(k.b.a((k.b)localObject2, "", null));
          localca.setType(922746929);
          localca.pJ(0);
          localca.Jm(((dit)localObject1).iRq);
          localca.EG(localdiu.rPF);
          localca.setCreateTime(localdiu.createTime);
          localArrayList.add(localca);
        }
      }
      AppMethodBeat.o(186654);
      return localArrayList;
    }
    AppMethodBeat.o(186654);
    return null;
  }
  
  public final diu a(dit paramdit, long paramLong)
  {
    AppMethodBeat.i(186623);
    paramdit = paramdit.Ezu.iterator();
    while (paramdit.hasNext())
    {
      diu localdiu = (diu)paramdit.next();
      if (localdiu.createTime == paramLong)
      {
        AppMethodBeat.o(186623);
        return localdiu;
      }
    }
    AppMethodBeat.o(186623);
    return null;
  }
  
  public final String a(dit paramdit)
  {
    AppMethodBeat.i(186618);
    k.b localb = new k.b();
    com.tencent.mm.plugin.patmsg.a.a locala = new com.tencent.mm.plugin.patmsg.a.a();
    locala.GKw = paramdit;
    localb.a(locala);
    localb.type = 62;
    localb.title = MMApplicationContext.getContext().getString(d.f.low_version_upgrade_tip);
    localb.url = MMApplicationContext.getContext().getString(d.f.low_version_upgrade_url);
    paramdit = k.b.a(localb, null, null);
    AppMethodBeat.o(186618);
    return paramdit;
  }
  
  public final void a(Pair<Long, Long> paramPair, int paramInt)
  {
    AppMethodBeat.i(186630);
    Log.i("MicroMsg.PatMsgExtension", "do revoke local pat msg (%d,%d)", new Object[] { paramPair.first, paramPair.second });
    Object localObject1 = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().Oq(((Long)paramPair.first).longValue());
    if (((et)localObject1).field_msgId == ((Long)paramPair.first).longValue())
    {
      localObject1 = g.bBr(((et)localObject1).field_content);
      Object localObject2 = a((dit)localObject1, ((Long)paramPair.second).longValue());
      if (localObject2 != null)
      {
        Object localObject3;
        if (((diu)localObject2).rPF == 0L)
        {
          if ((this.GKi != null) && (this.GKi.GKz.equals(paramPair)))
          {
            Log.i("MicroMsg.PatMsgExtension", "do revoke unsent pat msg (%d,%d)", new Object[] { paramPair.first, paramPair.second });
            this.GKm.removeMessages(291, this.GKi);
            localObject2 = new kc();
            ((kc)localObject2).ggl = this.GKi.scene;
            if (ab.PP(this.GKi.talker)) {
              ((kc)localObject2).Bc(this.GKi.talker);
            }
            ((kc)localObject2).gMB = (((Long)paramPair.second).longValue() - ((com.tencent.mm.plugin.patmsg.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.patmsg.a.b.class)).b(((dit)localObject1).iRq, paramPair));
            int i;
            if (a(this.GKi.talker, paramPair))
            {
              i = 1;
              ((kc)localObject2).gMD = i;
              ((kc)localObject2).gME = (b((dit)localObject1, ((Long)paramPair.second).longValue()) + 1);
              ((kc)localObject2).Ba(z.bcZ());
              ((kc)localObject2).Bb(this.GKi.GKB);
              ((kc)localObject2).gLF = this.GKi.createTime;
              ((kc)localObject2).Bd(c.aUh(this.GKi.GKB));
              ((kc)localObject2).gLM = 1;
              ((kc)localObject2).gLK = paramInt;
              if (!this.GKi.GKC) {
                break label609;
              }
            }
            label609:
            for (paramInt = 1;; paramInt = 0)
            {
              ((kc)localObject2).gMF = paramInt;
              ((kc)localObject2).bpa();
              localObject1 = com.tencent.mm.util.c.Yyz;
              com.tencent.mm.util.c.a((com.tencent.mm.plugin.report.a)localObject2);
              Log.i("MicroMsg.PatMsgExtension", "delete unsent pat msg (%d,%d)", new Object[] { paramPair.first, paramPair.second });
              localObject1 = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().Oq(((Long)paramPair.first).longValue());
              if (((et)localObject1).field_msgId != ((Long)paramPair.first).longValue()) {
                break label662;
              }
              localObject2 = g.bBr(((et)localObject1).field_content);
              Log.i("MicroMsg.PatMsgExtension", "before delete, pat record list size %d", new Object[] { Integer.valueOf(((dit)localObject2).Ezu.size()) });
              localObject3 = a((dit)localObject2, ((Long)paramPair.second).longValue());
              if (localObject3 == null) {
                break label662;
              }
              ((dit)localObject2).Ezu.remove(localObject3);
              if (!((dit)localObject2).Ezu.isEmpty()) {
                break label614;
              }
              ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().Or(((Long)paramPair.first).longValue());
              AppMethodBeat.o(186630);
              return;
              i = 0;
              break;
            }
            label614:
            ((ca)localObject1).setContent(a((dit)localObject2));
            ((ca)localObject1).setType(922746929);
            ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().a(((Long)paramPair.first).longValue(), (ca)localObject1);
            label662:
            AppMethodBeat.o(186630);
          }
        }
        else
        {
          Log.i("MicroMsg.PatMsgExtension", "do revoke sent pat msg %d, svrId %d", new Object[] { paramPair.first, Long.valueOf(((diu)localObject2).rPF) });
          localObject3 = new com.tencent.mm.plugin.patmsg.b.a(d(paramPair), ((Long)paramPair.first).longValue(), ((diu)localObject2).rPF, ((diu)localObject2).createTime, ((dit)localObject1).iRq);
          jq localjq = new jq();
          if ((this.GKi != null) && (this.GKi.GKz.equals(paramPair))) {
            localjq.ggl = this.GKi.scene;
          }
          localjq.gLF = ((diu)localObject2).createTime;
          localjq.gLG = System.currentTimeMillis();
          localjq.AD(((diu)localObject2).fLi);
          localjq.AE(((diu)localObject2).TQk);
          localjq.AF(c.aUh(((diu)localObject2).TQk));
          if (ab.PP(((dit)localObject1).iRq)) {
            localjq.AG(((dit)localObject1).iRq);
          }
          localjq.gLK = paramInt;
          localjq.gLM = 1;
          ((com.tencent.mm.plugin.patmsg.b.a)localObject3).GKy = localjq;
          com.tencent.mm.kernel.h.aGY().a((q)localObject3, 0);
          if (com.tencent.mm.kernel.h.aHG().aHp().getBoolean(ar.a.VDz, true))
          {
            com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VDz, Boolean.FALSE);
            com.tencent.e.h.ZvG.be(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(186754);
                ca localca = new ca();
                localca.setContent(MMApplicationContext.getContext().getString(d.f.revoke_pat_old_version_tip));
                localca.setType(10000);
                localca.pJ(0);
                localca.Jm(this.GKp.iRq);
                localca.setCreateTime(System.currentTimeMillis());
                bq.z(localca);
                AppMethodBeat.o(186754);
              }
            });
          }
        }
      }
    }
    AppMethodBeat.o(186630);
  }
  
  public final dit aUf(String paramString)
  {
    AppMethodBeat.i(186619);
    paramString = g.bBr(paramString);
    AppMethodBeat.o(186619);
    return paramString;
  }
  
  public final String aUg(String paramString)
  {
    AppMethodBeat.i(186629);
    String str = z.bcZ();
    int i = c.aUi(paramString);
    Log.i("MicroMsg.PatMsgExtension", "pattedUser %s, version %d", new Object[] { paramString, Integer.valueOf(i) });
    if (paramString.equals(str))
    {
      paramString = (String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VDu, null);
      if (Util.isNullOrNil(paramString)) {
        paramString = MMApplicationContext.getContext().getString(d.f.send_pat_msg_self_tip);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(186629);
      return paramString;
      if (i == 0)
      {
        paramString = MMApplicationContext.getContext().getString(d.f.send_pat_msg_self_tip_with_suffix, new Object[] { paramString });
      }
      else
      {
        paramString = MMApplicationContext.getContext().getString(d.f.send_pat_msg_self_tip_with_new_suffix, new Object[] { paramString });
        continue;
        str = c.aUh(paramString);
        Log.i("MicroMsg.PatMsgExtension", "pattedUser %s, suffix %s", new Object[] { paramString, str });
        if (Util.isNullOrNil(str)) {
          paramString = MMApplicationContext.getContext().getString(d.f.send_pat_msg_tip) + "\"" + aa.PJ(paramString) + "\"";
        } else if (i == 0) {
          paramString = MMApplicationContext.getContext().getString(d.f.send_pat_msg_tip_with_suffix, new Object[] { "\"" + aa.PJ(paramString) + "\"", str });
        } else {
          paramString = MMApplicationContext.getContext().getString(d.f.send_pat_msg_tip_with_new_suffix, new Object[] { "\"" + aa.PJ(paramString) + "\"", str });
        }
      }
    }
  }
  
  public final boolean am(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(186628);
    Log.i("MicroMsg.PatMsgExtension", "delete svr pat msg (%d,%d)", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    ca localca = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().Oq(paramLong1);
    dit localdit;
    diu localdiu;
    if ((localca.field_msgId == paramLong1) && (paramLong2 != 0L))
    {
      localdit = g.bBr(localca.field_content);
      Log.i("MicroMsg.PatMsgExtension", "pat record list size %d", new Object[] { Integer.valueOf(localdit.Ezu.size()) });
      Iterator localIterator = localdit.Ezu.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localdiu = (diu)localIterator.next();
      } while (localdiu.rPF != paramLong2);
    }
    for (;;)
    {
      if (localdiu != null)
      {
        localdit.Ezu.remove(localdiu);
        if (localdit.Ezu.isEmpty()) {
          ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().Or(paramLong1);
        }
        for (;;)
        {
          AppMethodBeat.o(186628);
          return true;
          localca.setContent(a(localdit));
          localca.setType(922746929);
          ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().a(paramLong1, localca);
        }
      }
      AppMethodBeat.o(186628);
      return false;
      localdiu = null;
    }
  }
  
  public final int b(dit paramdit, long paramLong)
  {
    AppMethodBeat.i(186624);
    int j = -1;
    int i = 0;
    while (i < paramdit.Ezu.size())
    {
      if (((diu)paramdit.Ezu.get(i)).createTime == paramLong) {
        j = i;
      }
      i += 1;
    }
    AppMethodBeat.o(186624);
    return j;
  }
  
  public final long b(String paramString, Pair<Long, Long> paramPair)
  {
    AppMethodBeat.i(186626);
    paramString = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().g(paramString, ((Long)paramPair.second).longValue(), 1);
    if ((!paramString.isEmpty()) && (((ca)paramString.get(0)).field_msgId > 0L))
    {
      long l;
      if (((ca)paramString.get(0)).getType() == 922746929)
      {
        dit localdit = g.bBr(((ca)paramString.get(0)).field_content);
        if (localdit.Ezu.size() == 0)
        {
          AppMethodBeat.o(186626);
          return 0L;
        }
        if (((Long)paramPair.first).longValue() == ((ca)paramString.get(0)).field_msgId)
        {
          int i = b(localdit, ((Long)paramPair.second).longValue());
          if (i > 1)
          {
            l = ((diu)localdit.Ezu.get(i - 1)).createTime;
            AppMethodBeat.o(186626);
            return l;
          }
        }
        else
        {
          l = ((diu)localdit.Ezu.getLast()).createTime;
          AppMethodBeat.o(186626);
          return l;
        }
      }
      else
      {
        l = ((ca)paramString.get(0)).field_createTime;
        AppMethodBeat.o(186626);
        return l;
      }
    }
    AppMethodBeat.o(186626);
    return 0L;
  }
  
  public final void be(String paramString, long paramLong)
  {
    AppMethodBeat.i(186643);
    Log.i("MicroMsg.PatMsgExtension", "do revoke svr pat msg %d from talker %s", new Object[] { Long.valueOf(paramLong), paramString });
    div localdiv = ((PluginPatMsg)com.tencent.mm.kernel.h.ag(PluginPatMsg.class)).getRecvRecord(paramLong);
    if (localdiv != null)
    {
      long l = localdiv.TQn;
      paramString = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aL(paramString, l);
      if (paramString.field_msgSvrId == l)
      {
        Log.i("MicroMsg.PatMsgExtension", "revoke pat msg %d,%d", new Object[] { Long.valueOf(paramString.field_msgId), Long.valueOf(paramLong) });
        am(paramString.field_msgId, paramLong);
      }
    }
    AppMethodBeat.o(186643);
  }
  
  public final String d(Pair<Long, Long> paramPair)
  {
    AppMethodBeat.i(186646);
    paramPair = z.bcZ() + "_" + paramPair.first + "_" + paramPair.second;
    AppMethodBeat.o(186646);
    return paramPair;
  }
  
  public final boolean e(Pair<Long, Long> paramPair)
  {
    AppMethodBeat.i(186650);
    if ((((PluginPatMsg)com.tencent.mm.kernel.h.ag(PluginPatMsg.class)).isRevokePatMsgEnable()) && (this.GKi != null) && (this.GKi.GKz != null) && (this.GKi.GKz.equals(paramPair)) && ((int)(System.currentTimeMillis() - this.GKi.createTime) < GKk))
    {
      Log.i("MicroMsg.PatMsgExtension", "try revoke last pat, msgId:%d, createTime:%d, scene:%d, talker:%s, patUser:%s", new Object[] { this.GKi.GKz.first, this.GKi.GKz.second, Integer.valueOf(this.GKi.scene), this.GKi.talker, this.GKi.GKB });
      paramPair = a(g.bBr(((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().Oq(((Long)this.GKi.GKz.first).longValue()).field_content), ((Long)paramPair.second).longValue());
      if (paramPair != null)
      {
        boolean bool = this.GKi.GKB.equalsIgnoreCase(paramPair.TQk);
        AppMethodBeat.o(186650);
        return bool;
      }
    }
    AppMethodBeat.o(186650);
    return false;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final q paramq)
  {
    AppMethodBeat.i(186627);
    Log.i("MicroMsg.PatMsgExtension", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    paramString = ((com.tencent.mm.plugin.patmsg.b.b)paramq).GKA;
    if (paramString != null) {
      paramString.ggm = paramInt2;
    }
    int i = ((eea)d.b.b(((com.tencent.mm.plugin.patmsg.b.b)paramq).lKU.lBR)).CPw;
    Log.i("MicroMsg.PatMsgExtension", "onSceneEnd, pat scene %d", new Object[] { Integer.valueOf(i) });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      if (i == 1)
      {
        AppMethodBeat.o(186627);
        return;
      }
      Toast.makeText(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(d.f.app_err_system_busy_tip) + "(" + paramInt1 + "," + paramInt2 + ")", 0).show();
      paramq = ((eea)d.b.b(((com.tencent.mm.plugin.patmsg.b.b)paramq).lKU.lBR)).Uia;
      if ((paramInt2 != -22) && (paramInt2 != -44)) {
        com.tencent.e.h.ZvG.be(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(186452);
            ca localca = new ca();
            localca.setContent(MMApplicationContext.getContext().getString(d.f.send_pat_msg_failed));
            localca.setType(10000);
            localca.pJ(0);
            localca.Jm(paramq);
            localca.setCreateTime(System.currentTimeMillis());
            Log.i("MicroMsg.PatMsgExtension", "insert pat failed msg %d", new Object[] { Long.valueOf(bq.z(localca)) });
            AppMethodBeat.o(186452);
          }
        });
      }
    }
    Object localObject1;
    String str;
    do
    {
      if (paramString != null)
      {
        paramString.bpa();
        paramq = com.tencent.mm.util.c.Yyz;
        com.tencent.mm.util.c.a(paramString);
      }
      AppMethodBeat.o(186627);
      return;
      localObject1 = ((com.tencent.mm.plugin.patmsg.b.b)paramq).GKz;
      str = ((eea)d.b.b(((com.tencent.mm.plugin.patmsg.b.b)paramq).lKU.lBR)).Uib;
      if (i != 1) {
        break;
      }
      paramq = Util.nullAsNil(((eeb)d.c.b(((com.tencent.mm.plugin.patmsg.b.b)paramq).lKU.lBS)).TGR);
    } while (Util.isNullOrNil(str));
    c.jv(str, paramq);
    Object localObject3;
    diu localdiu;
    if (((Long)((Pair)localObject1).first).longValue() > 0L)
    {
      localObject2 = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().Oq(((Long)((Pair)localObject1).first).longValue());
      if (((et)localObject2).field_msgId == ((Long)((Pair)localObject1).first).longValue())
      {
        localObject3 = g.bBr(((et)localObject2).field_content);
        localdiu = a((dit)localObject3, ((Long)((Pair)localObject1).second).longValue());
        if (localdiu != null)
        {
          if (!str.equalsIgnoreCase(localdiu.TQk)) {
            break label779;
          }
          localdiu.lqH = aUg(str);
          ((ca)localObject2).setContent(a((dit)localObject3));
          ((ca)localObject2).setType(922746929);
          ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().a(((Long)((Pair)localObject1).first).longValue(), (ca)localObject2);
          Log.i("MicroMsg.PatMsgExtension", "update pat msg suffix %d, createTime %d", new Object[] { ((Pair)localObject1).first, ((Pair)localObject1).second });
        }
      }
    }
    for (;;)
    {
      if ((!Util.isNullOrNil(paramq)) && (Util.isNullOrNil((String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VDu, null))) && (com.tencent.mm.kernel.h.aHG().aHp().getBoolean(ar.a.VDB, true)))
      {
        com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VDB, Boolean.FALSE);
        localObject1 = ((et)localObject2).field_talker;
        localObject2 = String.format(MMApplicationContext.getContext().getResources().getString(d.f.pat_set_tail_intro), new Object[] { "<_wc_custom_link_ href='weixin://jump/setpat/'>", "</_wc_custom_link_>" });
        localObject3 = new ca();
        ((ca)localObject3).pJ(0);
        ((ca)localObject3).Jm((String)localObject1);
        ((ca)localObject3).setStatus(3);
        ((ca)localObject3).setContent((String)localObject2);
        ((ca)localObject3).setCreateTime(bq.z((String)localObject1, System.currentTimeMillis() / 1000L));
        ((ca)localObject3).setType(10000);
        ((ca)localObject3).setFlag(((et)localObject3).field_flag);
        bq.z((ca)localObject3);
        if (this.GKi != null) {
          this.GKi.GKC = true;
        }
      }
      localObject1 = new qd();
      ((qd)localObject1).fON.fOO = str;
      ((qd)localObject1).fON.fOP = paramq;
      ((qd)localObject1).fON.fOQ = i;
      EventCenter.instance.publish((IEvent)localObject1);
      break;
      label779:
      Log.w("MicroMsg.PatMsgExtension", "update pat msg suffix %d, pattedUser (%s,%s) not match", new Object[] { ((Pair)localObject1).first, str, localdiu.TQk });
    }
    Object localObject2 = XmlParser.parseXml(((eeb)d.c.b(((com.tencent.mm.plugin.patmsg.b.b)paramq).lKU.lBS)).Uic, "sysmsg", null);
    if (localObject2 != null) {}
    for (paramInt1 = Util.safeParseInt((String)((Map)localObject2).get(".sysmsg.pat.patsuffixversion"));; paramInt1 = 0)
    {
      c.fB(str, paramInt1);
      long l = ((eeb)d.c.b(((com.tencent.mm.plugin.patmsg.b.b)paramq).lKU.lBS)).RNj;
      if ((l == 0L) || (((Long)((Pair)localObject1).first).longValue() <= 0L)) {
        break;
      }
      paramq = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().Oq(((Long)((Pair)localObject1).first).longValue());
      Log.i("MicroMsg.PatMsgExtension", "update pat msg %d, svrId %d", new Object[] { ((Pair)localObject1).first, Long.valueOf(l) });
      if (paramq.field_msgId != ((Long)((Pair)localObject1).first).longValue()) {
        break;
      }
      localObject2 = g.bBr(paramq.field_content);
      localObject3 = a((dit)localObject2, ((Long)((Pair)localObject1).second).longValue());
      if (localObject3 == null) {
        break;
      }
      if (str.equalsIgnoreCase(((diu)localObject3).TQk))
      {
        ((diu)localObject3).rPF = l;
        if (paramq.field_msgSvrId == 0L) {
          paramq.EG(l);
        }
        paramq.setContent(a((dit)localObject2));
        paramq.setType(922746929);
        ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().a(((Long)((Pair)localObject1).first).longValue(), paramq);
        Log.i("MicroMsg.PatMsgExtension", "update pat msg svrId %d, createTime %d", new Object[] { ((Pair)localObject1).first, ((Pair)localObject1).second });
        break;
      }
      Log.w("MicroMsg.PatMsgExtension", "update pat msg svrId %d, pattedUser (%s,%s) not match", new Object[] { ((Pair)localObject1).first, str, ((diu)localObject3).TQk });
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.patmsg.a
 * JD-Core Version:    0.7.0.1
 */