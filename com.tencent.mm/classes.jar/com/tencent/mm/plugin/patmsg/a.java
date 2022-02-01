package com.tencent.mm.plugin.patmsg;

import android.content.Context;
import android.content.res.Resources;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import android.widget.Toast;
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.g.a.om;
import com.tencent.mm.g.b.a.ec;
import com.tencent.mm.g.b.a.ek;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.cf;
import com.tencent.mm.model.u;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.cif;
import com.tencent.mm.protocal.protobuf.cig;
import com.tencent.mm.protocal.protobuf.cih;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.protocal.protobuf.daa;
import com.tencent.mm.protocal.protobuf.dab;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storage.bu;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class a
  implements f, com.tencent.mm.plugin.patmsg.a.b
{
  private static final int wFn;
  private static Map<String, Long> wFo;
  public static final int wFr;
  private static final int wFs;
  private Set<Long> wFp;
  private com.tencent.mm.plugin.patmsg.b.c wFq;
  public final com.tencent.mm.plugin.messenger.foundation.a.q wFt;
  private ap wFu;
  
  static
  {
    AppMethodBeat.i(215680);
    wFn = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qIf, 10000);
    wFo = new HashMap();
    wFr = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qIi, 5000);
    wFs = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qIh, 10000);
    AppMethodBeat.o(215680);
  }
  
  public a()
  {
    AppMethodBeat.i(215660);
    this.wFp = new HashSet();
    this.wFt = new com.tencent.mm.plugin.messenger.foundation.a.q()
    {
      public final void onNewXmlReceived(String paramAnonymousString, final Map<String, String> paramAnonymousMap, final com.tencent.mm.al.e.a paramAnonymousa)
      {
        AppMethodBeat.i(215656);
        if ("pat".equals(paramAnonymousString)) {
          h.LTJ.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(215655);
              String str1 = (String)paramAnonymousMap.get(".sysmsg.pat.fromusername");
              String str2 = (String)paramAnonymousMap.get(".sysmsg.pat.chatusername");
              String str3 = (String)paramAnonymousMap.get(".sysmsg.pat.pattedusername");
              String str4 = (String)paramAnonymousMap.get(".sysmsg.pat.template");
              ad.i("MicroMsg.PatMsgExtension", "fromUser: %s, chatUser: %s, pattedUser: %s, template:%s", new Object[] { str1, str2, str3, str4 });
              if (!((PluginPatMsg)g.ad(PluginPatMsg.class)).isPatEnable())
              {
                AppMethodBeat.o(215655);
                return;
              }
              if (((l)g.ab(l.class)).dlK().ya(paramAnonymousa.gqE.xbt))
              {
                ad.w("MicroMsg.PatMsgExtension", "ignore insert, msg %d should be deleted!", new Object[] { Long.valueOf(paramAnonymousa.gqE.xbt) });
                AppMethodBeat.o(215655);
                return;
              }
              a.b(str2, str1, str3, str4, paramAnonymousa.gqE.CreateTime, paramAnonymousa.gqE.xbt);
              AppMethodBeat.o(215655);
            }
          }, "HandlePatMsg");
        }
        AppMethodBeat.o(215656);
      }
    };
    this.wFu = new ap(Looper.getMainLooper(), new ap.a()
    {
      public final boolean handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(215657);
        Pair localPair;
        boolean bool;
        cif localcif;
        cig localcig;
        if (paramAnonymousMessage.what == 291)
        {
          localObject = (com.tencent.mm.plugin.patmsg.b.c)paramAnonymousMessage.obj;
          ad.i("MicroMsg.PatMsgExtension", "send pat msg, msgId:%d, createTime:%d scene:%d, talker:%s, patUser:%s", new Object[] { ((com.tencent.mm.plugin.patmsg.b.c)localObject).wFK.first, ((com.tencent.mm.plugin.patmsg.b.c)localObject).wFK.second, Integer.valueOf(((com.tencent.mm.plugin.patmsg.b.c)localObject).scene), ((com.tencent.mm.plugin.patmsg.b.c)localObject).talker, ((com.tencent.mm.plugin.patmsg.b.c)localObject).wFM });
          paramAnonymousMessage = a.this;
          i = ((com.tencent.mm.plugin.patmsg.b.c)localObject).scene;
          localPair = ((com.tencent.mm.plugin.patmsg.b.c)localObject).wFK;
          bool = ((com.tencent.mm.plugin.patmsg.b.c)localObject).OdD;
          ad.i("MicroMsg.PatMsgExtension", "send pat, scene %d, msg (%d,%d)", new Object[] { Integer.valueOf(i), localPair.first, localPair.second });
          if (((PluginPatMsg)g.ad(PluginPatMsg.class)).isPatEnable())
          {
            localObject = ((l)g.ab(l.class)).dlK().xY(((Long)localPair.first).longValue());
            if (((ei)localObject).field_msgId == ((Long)localPair.first).longValue())
            {
              localcif = com.tencent.mm.util.e.aXV(((ei)localObject).field_content);
              localcig = paramAnonymousMessage.a(localcif, ((Long)localPair.second).longValue());
              if (localcig != null)
              {
                if (paramAnonymousMessage.G(i, localcif.fFR, localcig.Hcd)) {
                  break label300;
                }
                ad.w("MicroMsg.PatMsgExtension", "cannot pat, scene %d, talker %s, patUser %s", new Object[] { Integer.valueOf(i), localcif.fFR, localcig.Hcd });
              }
            }
          }
        }
        AppMethodBeat.o(215657);
        return false;
        label300:
        Object localObject = new ek();
        ((ek)localObject).dSg = i;
        if (w.zk(localcif.fFR)) {
          ((ek)localObject).nK(localcif.fFR);
        }
        ((ek)localObject).ehX = (((Long)localPair.second).longValue() - ((com.tencent.mm.plugin.patmsg.a.b)g.ab(com.tencent.mm.plugin.patmsg.a.b.class)).b(localcif.fFR, localPair));
        if (a.a(localcif.fFR, localPair))
        {
          i = 1;
          label389:
          ((ek)localObject).ehZ = i;
          ((ek)localObject).eia = (paramAnonymousMessage.b(localcif, ((Long)localPair.second).longValue()) + 1);
          ((ek)localObject).nI(localcig.dyU);
          ((ek)localObject).nJ(localcig.Hcd);
          ((ek)localObject).ehx = localcig.createTime;
          ((ek)localObject).nL(c.auj(localcig.Hcd));
          if (!bool) {
            break label520;
          }
        }
        label520:
        for (int i = 1;; i = 0)
        {
          ((ek)localObject).eib = i;
          paramAnonymousMessage = new com.tencent.mm.plugin.patmsg.b.b(localPair, localcif.fFR, localcig.Hcd);
          paramAnonymousMessage.wFL = ((ek)localObject);
          g.aiU().a(paramAnonymousMessage, 0);
          break;
          i = 0;
          break label389;
        }
      }
    });
    AppMethodBeat.o(215660);
  }
  
  private static Pair<Long, Long> a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, long paramLong)
  {
    AppMethodBeat.i(215661);
    Object localObject;
    long l;
    if (!bt.V(new String[] { paramString2, paramString1, paramString3 }))
    {
      localObject = paramString1;
      if (paramString1.equals(u.aAm())) {
        localObject = paramString2;
      }
      if ((w.zk((String)localObject)) && (!((l)g.ab(l.class)).dlF().apF((String)localObject)))
      {
        paramString1 = ((l)g.ab(l.class)).dlK().apX((String)localObject);
        if ((paramString1 != null) && (paramString1.field_msgId > 0L) && (paramString1.getType() == 922746929))
        {
          l = paramInt * 1000L;
          if (l > paramString1.field_createTime) {
            break label665;
          }
          l = paramString1.field_createTime + 1L;
        }
      }
    }
    label665:
    for (;;)
    {
      localObject = new cig();
      ((cig)localObject).hEb = paramString4;
      ((cig)localObject).createTime = l;
      ((cig)localObject).dyU = paramString2;
      ((cig)localObject).Hcd = paramString3;
      ((cig)localObject).nxr = paramLong;
      paramString2 = com.tencent.mm.util.e.aXV(paramString1.field_content);
      paramString2.vox.add(localObject);
      paramString3 = new k.b();
      paramString4 = new com.tencent.mm.plugin.patmsg.a.a();
      paramString4.wFH = paramString2;
      paramString3.a(paramString4);
      paramString3.type = 62;
      paramString3.title = aj.getContext().getString(2131760809);
      paramString3.url = aj.getContext().getString(2131760810);
      paramString1.setContent(k.b.a(paramString3, "", null));
      paramLong = paramString1.field_msgId;
      if (paramLong != 0L) {
        ((l)g.ab(l.class)).dlK().a(paramLong, paramString1);
      }
      ((PluginPatMsg)g.ad(PluginPatMsg.class)).addRecvRecord(paramString1.field_msgSvrId, (cig)localObject);
      ad.i("MicroMsg.PatMsgExtension", "update pat msg %d, index %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramString2.vox.size() - 1) });
      paramString1 = Pair.create(Long.valueOf(paramLong), Long.valueOf(l));
      AppMethodBeat.o(215661);
      return paramString1;
      l = bj.B((String)localObject, paramInt);
      paramString1 = new bu();
      cif localcif = new cif();
      localcif.fFR = ((String)localObject);
      cig localcig = new cig();
      localcig.hEb = paramString4;
      localcig.createTime = l;
      localcig.dyU = paramString2;
      localcig.Hcd = paramString3;
      localcig.nxr = paramLong;
      localcif.vox.add(localcig);
      paramString2 = new k.b();
      paramString3 = new com.tencent.mm.plugin.patmsg.a.a();
      paramString3.wFH = localcif;
      paramString2.a(paramString3);
      paramString2.type = 62;
      paramString2.title = aj.getContext().getString(2131760809);
      paramString2.url = aj.getContext().getString(2131760810);
      paramString1.setContent(k.b.a(paramString2, "", null));
      paramString1.kr(0);
      paramString1.tN((String)localObject);
      paramString1.qz(paramLong);
      paramString1.qA(l);
      paramString1.setType(922746929);
      ((PluginPatMsg)g.ad(PluginPatMsg.class)).addRecvRecord(paramString1.field_msgSvrId, localcig);
      paramLong = bj.v(paramString1);
      ad.i("MicroMsg.PatMsgExtension", "insert pat msg %d %s %s", new Object[] { Long.valueOf(paramLong), Integer.toHexString(paramString1.getType()), Integer.toHexString(922746929) });
      paramString1 = Pair.create(Long.valueOf(paramLong), Long.valueOf(l));
      AppMethodBeat.o(215661);
      return paramString1;
      paramString1 = Pair.create(Long.valueOf(0L), Long.valueOf(0L));
      AppMethodBeat.o(215661);
      return paramString1;
    }
  }
  
  static boolean a(String paramString, Pair<Long, Long> paramPair)
  {
    AppMethodBeat.i(215669);
    long l = ((l)g.ab(l.class)).dlK().aqp(paramString);
    if (((Long)paramPair.second).longValue() <= l)
    {
      AppMethodBeat.o(215669);
      return true;
    }
    AppMethodBeat.o(215669);
    return false;
  }
  
  public final boolean G(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(215665);
    if (((paramInt == 3) || (paramInt == 4) || (paramInt == 5)) && (((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qHJ, 0) == 0))
    {
      AppMethodBeat.o(215665);
      return false;
    }
    if (((!w.zk(paramString1)) && (!w.zi(paramString1))) || (w.Ak(paramString1)) || (w.Aq(paramString1)) || (w.Ag(paramString1)) || (w.zE(paramString1)))
    {
      ad.i("MicroMsg.PatMsgExtension", "cannot pat, talker %s", new Object[] { paramString1 });
      AppMethodBeat.o(215665);
      return false;
    }
    if ((!w.zi(paramString2)) || (w.Ak(paramString2)) || (w.Aq(paramString2)) || (w.Ag(paramString2)) || (w.zE(paramString2)))
    {
      ad.i("MicroMsg.PatMsgExtension", "cannot pat, user %s", new Object[] { paramString2 });
      AppMethodBeat.o(215665);
      return false;
    }
    if (w.zk(paramString1))
    {
      List localList = com.tencent.mm.model.q.yQ(paramString1);
      if ((localList != null) && (!localList.contains(paramString2)))
      {
        ad.w("MicroMsg.PatMsgExtension", "chatroom %s members %s, not contain %s", new Object[] { paramString1, localList, paramString2 });
        AppMethodBeat.o(215665);
        return false;
      }
    }
    AppMethodBeat.o(215665);
    return true;
  }
  
  public final Pair<Long, Long> H(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(215666);
    ad.i("MicroMsg.PatMsgExtension", "preSend pat, scene %d, talker %s, user %s", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2 });
    long l = cf.aCL();
    if (!((PluginPatMsg)g.ad(PluginPatMsg.class)).isPatEnable())
    {
      AppMethodBeat.o(215666);
      return null;
    }
    if (!G(paramInt, paramString1, paramString2))
    {
      ad.w("MicroMsg.PatMsgExtension", "cannot pat, scene %d, talker %s, user %s", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2 });
      AppMethodBeat.o(215666);
      return null;
    }
    Object localObject2 = u.aAm();
    Object localObject1 = new ek();
    ((ek)localObject1).dSg = paramInt;
    if (w.zk(paramString1)) {
      ((ek)localObject1).nK(paramString1);
    }
    ((ek)localObject1).nI((String)localObject2);
    ((ek)localObject1).nJ(paramString2);
    ((ek)localObject1).ehx = l;
    ((ek)localObject1).nL(c.auj(paramString2));
    Object localObject3 = ((l)g.ab(l.class)).dlK().apX(paramString1);
    if ((localObject3 != null) && (((ei)localObject3).field_msgId > 0L))
    {
      if (((bu)localObject3).getType() != 922746929) {
        break label356;
      }
      localObject3 = com.tencent.mm.util.e.aXV(((ei)localObject3).field_content);
      if (((cif)localObject3).vox.size() <= 0) {}
    }
    label356:
    for (((ek)localObject1).ehX = (l - ((cig)((cif)localObject3).vox.getLast()).createTime); (wFo.containsKey(paramString2)) && (l - ((Long)wFo.get(paramString2)).longValue() < wFn); ((ek)localObject1).ehX = (l - ((ei)localObject3).field_createTime))
    {
      ad.w("MicroMsg.PatMsgExtension", "pat (%s) last time from now < %d", new Object[] { paramString2, Integer.valueOf(wFn) });
      ((ek)localObject1).ehY = 1;
      ((ek)localObject1).aLk();
      paramString1 = com.tencent.mm.util.b.Lgy;
      com.tencent.mm.util.b.a((com.tencent.mm.plugin.report.a)localObject1);
      AppMethodBeat.o(215666);
      return null;
    }
    this.wFq = null;
    wFo.put(paramString2, Long.valueOf(l));
    localObject1 = a(paramString1, (String)localObject2, paramString2, aui(paramString2), (int)(l / 1000L), 0L);
    if (((Long)((Pair)localObject1).first).longValue() > 0L)
    {
      localObject2 = new com.tencent.mm.plugin.patmsg.b.b((Pair)localObject1, paramString1, paramString2, 1);
      g.aiU().a((n)localObject2, 0);
      localObject2 = new com.tencent.mm.plugin.patmsg.b.c();
      ((com.tencent.mm.plugin.patmsg.b.c)localObject2).scene = paramInt;
      ((com.tencent.mm.plugin.patmsg.b.c)localObject2).talker = paramString1;
      ((com.tencent.mm.plugin.patmsg.b.c)localObject2).wFM = paramString2;
      ((com.tencent.mm.plugin.patmsg.b.c)localObject2).wFK = ((Pair)localObject1);
      this.wFu.sendMessageDelayed(this.wFu.obtainMessage(291, localObject2), wFr);
      this.wFq = ((com.tencent.mm.plugin.patmsg.b.c)localObject2);
    }
    AppMethodBeat.o(215666);
    return localObject1;
  }
  
  public final cig a(cif paramcif, long paramLong)
  {
    AppMethodBeat.i(215667);
    paramcif = paramcif.vox.iterator();
    while (paramcif.hasNext())
    {
      cig localcig = (cig)paramcif.next();
      if (localcig.createTime == paramLong)
      {
        AppMethodBeat.o(215667);
        return localcig;
      }
    }
    AppMethodBeat.o(215667);
    return null;
  }
  
  public final String a(cif paramcif)
  {
    AppMethodBeat.i(215662);
    k.b localb = new k.b();
    com.tencent.mm.plugin.patmsg.a.a locala = new com.tencent.mm.plugin.patmsg.a.a();
    locala.wFH = paramcif;
    localb.a(locala);
    localb.type = 62;
    localb.title = aj.getContext().getString(2131760809);
    localb.url = aj.getContext().getString(2131760810);
    paramcif = k.b.a(localb, null, null);
    AppMethodBeat.o(215662);
    return paramcif;
  }
  
  public final void a(Pair<Long, Long> paramPair, int paramInt)
  {
    AppMethodBeat.i(215674);
    ad.i("MicroMsg.PatMsgExtension", "do revoke local pat msg (%d,%d)", new Object[] { paramPair.first, paramPair.second });
    Object localObject1 = ((l)g.ab(l.class)).dlK().xY(((Long)paramPair.first).longValue());
    if (((ei)localObject1).field_msgId == ((Long)paramPair.first).longValue())
    {
      localObject1 = com.tencent.mm.util.e.aXV(((ei)localObject1).field_content);
      Object localObject2 = a((cif)localObject1, ((Long)paramPair.second).longValue());
      if (localObject2 != null)
      {
        Object localObject3;
        if (((cig)localObject2).nxr == 0L)
        {
          if ((this.wFq != null) && (this.wFq.wFK.equals(paramPair)))
          {
            ad.i("MicroMsg.PatMsgExtension", "do revoke unsent pat msg (%d,%d)", new Object[] { paramPair.first, paramPair.second });
            this.wFu.removeMessages(291, this.wFq);
            localObject2 = new ek();
            ((ek)localObject2).dSg = this.wFq.scene;
            if (w.zk(this.wFq.talker)) {
              ((ek)localObject2).nK(this.wFq.talker);
            }
            ((ek)localObject2).ehX = (((Long)paramPair.second).longValue() - ((com.tencent.mm.plugin.patmsg.a.b)g.ab(com.tencent.mm.plugin.patmsg.a.b.class)).b(((cif)localObject1).fFR, paramPair));
            int i;
            if (a(this.wFq.talker, paramPair))
            {
              i = 1;
              ((ek)localObject2).ehZ = i;
              ((ek)localObject2).eia = (b((cif)localObject1, ((Long)paramPair.second).longValue()) + 1);
              ((ek)localObject2).nI(u.aAm());
              ((ek)localObject2).nJ(this.wFq.wFM);
              ((ek)localObject2).ehx = this.wFq.createTime;
              ((ek)localObject2).nL(c.auj(this.wFq.wFM));
              ((ek)localObject2).ehE = 1;
              ((ek)localObject2).ehC = paramInt;
              if (!this.wFq.OdD) {
                break label609;
              }
            }
            label609:
            for (paramInt = 1;; paramInt = 0)
            {
              ((ek)localObject2).eib = paramInt;
              ((ek)localObject2).aLk();
              localObject1 = com.tencent.mm.util.b.Lgy;
              com.tencent.mm.util.b.a((com.tencent.mm.plugin.report.a)localObject2);
              ad.i("MicroMsg.PatMsgExtension", "delete unsent pat msg (%d,%d)", new Object[] { paramPair.first, paramPair.second });
              localObject1 = ((l)g.ab(l.class)).dlK().xY(((Long)paramPair.first).longValue());
              if (((ei)localObject1).field_msgId != ((Long)paramPair.first).longValue()) {
                break label662;
              }
              localObject2 = com.tencent.mm.util.e.aXV(((ei)localObject1).field_content);
              ad.i("MicroMsg.PatMsgExtension", "before delete, pat record list size %d", new Object[] { Integer.valueOf(((cif)localObject2).vox.size()) });
              localObject3 = a((cif)localObject2, ((Long)paramPair.second).longValue());
              if (localObject3 == null) {
                break label662;
              }
              ((cif)localObject2).vox.remove(localObject3);
              if (!((cif)localObject2).vox.isEmpty()) {
                break label614;
              }
              ((l)g.ab(l.class)).dlK().xZ(((Long)paramPair.first).longValue());
              AppMethodBeat.o(215674);
              return;
              i = 0;
              break;
            }
            label614:
            ((bu)localObject1).setContent(a((cif)localObject2));
            ((bu)localObject1).setType(922746929);
            ((l)g.ab(l.class)).dlK().a(((Long)paramPair.first).longValue(), (bu)localObject1);
            label662:
            AppMethodBeat.o(215674);
          }
        }
        else
        {
          ad.i("MicroMsg.PatMsgExtension", "do revoke sent pat msg %d, svrId %d", new Object[] { paramPair.first, Long.valueOf(((cig)localObject2).nxr) });
          localObject3 = new com.tencent.mm.plugin.patmsg.b.a(d(paramPair), ((Long)paramPair.first).longValue(), ((cig)localObject2).nxr, ((cig)localObject2).createTime, ((cif)localObject1).fFR);
          ec localec = new ec();
          if ((this.wFq != null) && (this.wFq.wFK.equals(paramPair))) {
            localec.dSg = this.wFq.scene;
          }
          localec.ehx = ((cig)localObject2).createTime;
          localec.ehy = System.currentTimeMillis();
          localec.nq(((cig)localObject2).dyU);
          localec.nr(((cig)localObject2).Hcd);
          localec.ns(c.auj(((cig)localObject2).Hcd));
          if (w.zk(((cif)localObject1).fFR)) {
            localec.nt(((cif)localObject1).fFR);
          }
          localec.ehC = paramInt;
          localec.ehE = 1;
          ((com.tencent.mm.plugin.patmsg.b.a)localObject3).wFJ = localec;
          g.aiU().a((n)localObject3, 0);
          if (g.ajC().ajl().getBoolean(al.a.IJR, true))
          {
            g.ajC().ajl().set(al.a.IJR, Boolean.FALSE);
            h.LTJ.aR(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(215659);
                bu localbu = new bu();
                localbu.setContent(aj.getContext().getString(2131767133));
                localbu.setType(10000);
                localbu.kr(0);
                localbu.tN(this.wFx.fFR);
                localbu.qA(System.currentTimeMillis());
                bj.v(localbu);
                AppMethodBeat.o(215659);
              }
            });
          }
        }
      }
    }
    AppMethodBeat.o(215674);
  }
  
  public final boolean ab(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(215672);
    ad.i("MicroMsg.PatMsgExtension", "delete svr pat msg (%d,%d)", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    bu localbu = ((l)g.ab(l.class)).dlK().xY(paramLong1);
    cif localcif;
    cig localcig;
    if ((localbu.field_msgId == paramLong1) && (paramLong2 != 0L))
    {
      localcif = com.tencent.mm.util.e.aXV(localbu.field_content);
      ad.i("MicroMsg.PatMsgExtension", "pat record list size %d", new Object[] { Integer.valueOf(localcif.vox.size()) });
      Iterator localIterator = localcif.vox.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localcig = (cig)localIterator.next();
      } while (localcig.nxr != paramLong2);
    }
    for (;;)
    {
      if (localcig != null)
      {
        localcif.vox.remove(localcig);
        if (localcif.vox.isEmpty()) {
          ((l)g.ab(l.class)).dlK().xZ(paramLong1);
        }
        for (;;)
        {
          AppMethodBeat.o(215672);
          return true;
          localbu.setContent(a(localcif));
          localbu.setType(922746929);
          ((l)g.ab(l.class)).dlK().a(paramLong1, localbu);
        }
      }
      AppMethodBeat.o(215672);
      return false;
      localcig = null;
    }
  }
  
  public final cif auh(String paramString)
  {
    AppMethodBeat.i(215663);
    paramString = com.tencent.mm.util.e.aXV(paramString);
    AppMethodBeat.o(215663);
    return paramString;
  }
  
  public final String aui(String paramString)
  {
    AppMethodBeat.i(215673);
    String str = u.aAm();
    int i = c.auk(paramString);
    ad.i("MicroMsg.PatMsgExtension", "pattedUser %s, version %d", new Object[] { paramString, Integer.valueOf(i) });
    if (paramString.equals(str))
    {
      paramString = (String)g.ajC().ajl().get(al.a.IJN, null);
      if (bt.isNullOrNil(paramString)) {
        paramString = aj.getContext().getString(2131766389);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(215673);
      return paramString;
      if (i == 0)
      {
        paramString = aj.getContext().getString(2131766969, new Object[] { paramString });
      }
      else
      {
        paramString = aj.getContext().getString(2131767166, new Object[] { paramString });
        continue;
        str = c.auj(paramString);
        ad.i("MicroMsg.PatMsgExtension", "pattedUser %s, suffix %s", new Object[] { paramString, str });
        if (bt.isNullOrNil(str)) {
          paramString = aj.getContext().getString(2131766390) + "\"" + v.zf(paramString) + "\"";
        } else if (i == 0) {
          paramString = aj.getContext().getString(2131766970, new Object[] { "\"" + v.zf(paramString) + "\"", str });
        } else {
          paramString = aj.getContext().getString(2131767167, new Object[] { "\"" + v.zf(paramString) + "\"", str });
        }
      }
    }
  }
  
  public final int b(cif paramcif, long paramLong)
  {
    AppMethodBeat.i(215668);
    int j = -1;
    int i = 0;
    while (i < paramcif.vox.size())
    {
      if (((cig)paramcif.vox.get(i)).createTime == paramLong) {
        j = i;
      }
      i += 1;
    }
    AppMethodBeat.o(215668);
    return j;
  }
  
  public final long b(String paramString, Pair<Long, Long> paramPair)
  {
    AppMethodBeat.i(215670);
    paramString = ((l)g.ab(l.class)).dlK().f(paramString, ((Long)paramPair.second).longValue(), 1);
    if ((!paramString.isEmpty()) && (((bu)paramString.get(0)).field_msgId > 0L))
    {
      long l;
      if (((bu)paramString.get(0)).getType() == 922746929)
      {
        cif localcif = com.tencent.mm.util.e.aXV(((bu)paramString.get(0)).field_content);
        if (((Long)paramPair.first).longValue() == ((bu)paramString.get(0)).field_msgId)
        {
          int i = b(localcif, ((Long)paramPair.second).longValue());
          if (i > 1)
          {
            l = ((cig)localcif.vox.get(i - 1)).createTime;
            AppMethodBeat.o(215670);
            return l;
          }
        }
        else
        {
          l = ((cig)localcif.vox.getLast()).createTime;
          AppMethodBeat.o(215670);
          return l;
        }
      }
      else
      {
        l = ((bu)paramString.get(0)).field_createTime;
        AppMethodBeat.o(215670);
        return l;
      }
    }
    AppMethodBeat.o(215670);
    return 0L;
  }
  
  public final void ba(String paramString, long paramLong)
  {
    AppMethodBeat.i(215675);
    ad.i("MicroMsg.PatMsgExtension", "do revoke svr pat msg %d from talker %s", new Object[] { Long.valueOf(paramLong), paramString });
    cih localcih = ((PluginPatMsg)g.ad(PluginPatMsg.class)).getRecvRecord(paramLong);
    if (localcih != null)
    {
      long l = localcih.Hcf;
      paramString = ((l)g.ab(l.class)).dlK().aI(paramString, l);
      if (paramString.field_msgSvrId == l)
      {
        ad.i("MicroMsg.PatMsgExtension", "revoke pat msg %d,%d", new Object[] { Long.valueOf(paramString.field_msgId), Long.valueOf(paramLong) });
        ab(paramString.field_msgId, paramLong);
      }
    }
    AppMethodBeat.o(215675);
  }
  
  public final String d(Pair<Long, Long> paramPair)
  {
    AppMethodBeat.i(215676);
    paramPair = u.aAm() + "_" + paramPair.first + "_" + paramPair.second;
    AppMethodBeat.o(215676);
    return paramPair;
  }
  
  public final boolean e(Pair<Long, Long> paramPair)
  {
    AppMethodBeat.i(215677);
    if ((((PluginPatMsg)g.ad(PluginPatMsg.class)).isRevokePatMsgEnable()) && (this.wFq != null) && (this.wFq.wFK != null) && (this.wFq.wFK.equals(paramPair)) && ((int)(System.currentTimeMillis() - this.wFq.createTime) < wFs))
    {
      ad.i("MicroMsg.PatMsgExtension", "try revoke last pat, msgId:%d, createTime:%d, scene:%d, talker:%s, patUser:%s", new Object[] { this.wFq.wFK.first, this.wFq.wFK.second, Integer.valueOf(this.wFq.scene), this.wFq.talker, this.wFq.wFM });
      paramPair = a(com.tencent.mm.util.e.aXV(((l)g.ab(l.class)).dlK().xY(((Long)this.wFq.wFK.first).longValue()).field_content), ((Long)paramPair.second).longValue());
      if (paramPair != null)
      {
        boolean bool = this.wFq.wFM.equalsIgnoreCase(paramPair.Hcd);
        AppMethodBeat.o(215677);
        return bool;
      }
    }
    AppMethodBeat.o(215677);
    return false;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final n paramn)
  {
    AppMethodBeat.i(215671);
    ad.i("MicroMsg.PatMsgExtension", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    paramString = ((com.tencent.mm.plugin.patmsg.b.b)paramn).wFL;
    if (paramString != null) {
      paramString.ehW = paramInt2;
    }
    int i = ((daa)((com.tencent.mm.plugin.patmsg.b.b)paramn).hWL.hNK.hNQ).Scene;
    ad.i("MicroMsg.PatMsgExtension", "onSceneEnd, pat scene %d", new Object[] { Integer.valueOf(i) });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      if (i == 1)
      {
        AppMethodBeat.o(215671);
        return;
      }
      Toast.makeText(aj.getContext(), aj.getContext().getString(2131755733) + "(" + paramInt1 + "," + paramInt2 + ")", 0).show();
      paramn = ((daa)((com.tencent.mm.plugin.patmsg.b.b)paramn).hWL.hNK.hNQ).Hqt;
      if ((paramInt2 != -22) && (paramInt2 != -44)) {
        h.LTJ.aR(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(215658);
            bu localbu = new bu();
            localbu.setContent(aj.getContext().getString(2131766388));
            localbu.setType(10000);
            localbu.kr(0);
            localbu.tN(paramn);
            localbu.qA(System.currentTimeMillis());
            ad.i("MicroMsg.PatMsgExtension", "insert pat failed msg %d", new Object[] { Long.valueOf(bj.v(localbu)) });
            AppMethodBeat.o(215658);
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
        paramString.aLk();
        paramn = com.tencent.mm.util.b.Lgy;
        com.tencent.mm.util.b.a(paramString);
      }
      AppMethodBeat.o(215671);
      return;
      localObject1 = ((com.tencent.mm.plugin.patmsg.b.b)paramn).wFK;
      str = ((daa)((com.tencent.mm.plugin.patmsg.b.b)paramn).hWL.hNK.hNQ).Hqu;
      if (i != 1) {
        break;
      }
      paramn = bt.nullAsNil(((dab)((com.tencent.mm.plugin.patmsg.b.b)paramn).hWL.hNL.hNQ).GUX);
    } while (bt.isNullOrNil(str));
    c.it(str, paramn);
    Object localObject3;
    cig localcig;
    if (((Long)((Pair)localObject1).first).longValue() > 0L)
    {
      localObject2 = ((l)g.ab(l.class)).dlK().xY(((Long)((Pair)localObject1).first).longValue());
      if (((ei)localObject2).field_msgId == ((Long)((Pair)localObject1).first).longValue())
      {
        localObject3 = com.tencent.mm.util.e.aXV(((ei)localObject2).field_content);
        localcig = a((cif)localObject3, ((Long)((Pair)localObject1).second).longValue());
        if (localcig != null)
        {
          if (!str.equalsIgnoreCase(localcig.Hcd)) {
            break label779;
          }
          localcig.hEb = aui(str);
          ((bu)localObject2).setContent(a((cif)localObject3));
          ((bu)localObject2).setType(922746929);
          ((l)g.ab(l.class)).dlK().a(((Long)((Pair)localObject1).first).longValue(), (bu)localObject2);
          ad.i("MicroMsg.PatMsgExtension", "update pat msg suffix %d, createTime %d", new Object[] { ((Pair)localObject1).first, ((Pair)localObject1).second });
        }
      }
    }
    for (;;)
    {
      if ((!bt.isNullOrNil(paramn)) && (bt.isNullOrNil((String)g.ajC().ajl().get(al.a.IJN, null))) && (g.ajC().ajl().getBoolean(al.a.IJT, true)))
      {
        g.ajC().ajl().set(al.a.IJT, Boolean.FALSE);
        localObject1 = ((ei)localObject2).field_talker;
        localObject2 = String.format(aj.getContext().getResources().getString(2131767111), new Object[] { "<_wc_custom_link_ href='weixin://jump/setpat/'>", "</_wc_custom_link_>" });
        localObject3 = new bu();
        ((bu)localObject3).kr(0);
        ((bu)localObject3).tN((String)localObject1);
        ((bu)localObject3).setStatus(3);
        ((bu)localObject3).setContent((String)localObject2);
        ((bu)localObject3).qA(bj.B((String)localObject1, System.currentTimeMillis() / 1000L));
        ((bu)localObject3).setType(10000);
        ((bu)localObject3).setFlag(((ei)localObject3).field_flag);
        bj.v((bu)localObject3);
        if (this.wFq != null) {
          this.wFq.OdD = true;
        }
      }
      localObject1 = new om();
      ((om)localObject1).dCq.dCr = str;
      ((om)localObject1).dCq.dCs = paramn;
      ((om)localObject1).dCq.dCt = i;
      com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject1);
      break;
      label779:
      ad.w("MicroMsg.PatMsgExtension", "update pat msg suffix %d, pattedUser (%s,%s) not match", new Object[] { ((Pair)localObject1).first, str, localcig.Hcd });
    }
    Object localObject2 = bw.M(((dab)((com.tencent.mm.plugin.patmsg.b.b)paramn).hWL.hNL.hNQ).Hqv, "sysmsg");
    if (localObject2 != null) {}
    for (paramInt1 = bt.aRe((String)((Map)localObject2).get(".sysmsg.pat.patsuffixversion"));; paramInt1 = 0)
    {
      c.eC(str, paramInt1);
      long l = ((dab)((com.tencent.mm.plugin.patmsg.b.b)paramn).hWL.hNL.hNQ).FAf;
      if ((l == 0L) || (((Long)((Pair)localObject1).first).longValue() <= 0L)) {
        break;
      }
      paramn = ((l)g.ab(l.class)).dlK().xY(((Long)((Pair)localObject1).first).longValue());
      ad.i("MicroMsg.PatMsgExtension", "update pat msg %d, svrId %d", new Object[] { ((Pair)localObject1).first, Long.valueOf(l) });
      if (paramn.field_msgId != ((Long)((Pair)localObject1).first).longValue()) {
        break;
      }
      localObject2 = com.tencent.mm.util.e.aXV(paramn.field_content);
      localObject3 = a((cif)localObject2, ((Long)((Pair)localObject1).second).longValue());
      if (localObject3 == null) {
        break;
      }
      if (str.equalsIgnoreCase(((cig)localObject3).Hcd))
      {
        ((cig)localObject3).nxr = l;
        if (paramn.field_msgSvrId == 0L) {
          paramn.qz(l);
        }
        paramn.setContent(a((cif)localObject2));
        paramn.setType(922746929);
        ((l)g.ab(l.class)).dlK().a(((Long)((Pair)localObject1).first).longValue(), paramn);
        ad.i("MicroMsg.PatMsgExtension", "update pat msg svrId %d, createTime %d", new Object[] { ((Pair)localObject1).first, ((Pair)localObject1).second });
        break;
      }
      ad.w("MicroMsg.PatMsgExtension", "update pat msg svrId %d, pattedUser (%s,%s) not match", new Object[] { ((Pair)localObject1).first, str, ((cig)localObject3).Hcd });
      break;
    }
  }
  
  public final boolean yr(long paramLong)
  {
    AppMethodBeat.i(215664);
    if (this.wFp.contains(Long.valueOf(paramLong)))
    {
      AppMethodBeat.o(215664);
      return true;
    }
    Object localObject = ((l)g.ab(l.class)).dlK().xY(paramLong);
    if (((ei)localObject).field_msgId > 0L)
    {
      localObject = com.tencent.mm.util.e.aXV(((ei)localObject).field_content).vox.iterator();
      int i = 1;
      if (((Iterator)localObject).hasNext())
      {
        if (((cig)((Iterator)localObject).next()).Hce == 1) {}
        for (int j = 1;; j = 0)
        {
          i = j & i;
          break;
        }
      }
      if (i != 0)
      {
        this.wFp.add(Long.valueOf(paramLong));
        AppMethodBeat.o(215664);
        return true;
      }
    }
    AppMethodBeat.o(215664);
    return false;
  }
  
  public final List<bu> ys(long paramLong)
  {
    AppMethodBeat.i(215678);
    Object localObject1 = ((l)g.ab(l.class)).dlK().xY(paramLong);
    if (((bu)localObject1).getType() == 922746929)
    {
      ArrayList localArrayList = new ArrayList();
      localObject1 = com.tencent.mm.util.e.aXV(((ei)localObject1).field_content);
      if (((cif)localObject1).vox == null) {}
      for (int i = 0;; i = ((cif)localObject1).vox.size())
      {
        ad.i("MicroMsg.PatMsgExtension", "split pat msg [%d] to %d child msg", new Object[] { Long.valueOf(paramLong), Integer.valueOf(i) });
        Iterator localIterator = ((cif)localObject1).vox.iterator();
        while (localIterator.hasNext())
        {
          cig localcig = (cig)localIterator.next();
          bu localbu = new bu();
          cif localcif = new cif();
          localcif.fFR = ((cif)localObject1).fFR;
          Object localObject2 = new com.tencent.mm.util.e.a();
          ((com.tencent.mm.util.e.a)localObject2).hEb = localcig.hEb;
          ((com.tencent.mm.util.e.a)localObject2).LgL = localcig.hEb;
          ((com.tencent.mm.util.e.a)localObject2).createTime = localcig.createTime;
          ((com.tencent.mm.util.e.a)localObject2).dyU = localcig.dyU;
          ((com.tencent.mm.util.e.a)localObject2).Hcd = localcig.Hcd;
          ((com.tencent.mm.util.e.a)localObject2).nxr = localcig.nxr;
          localcif.vox.add(localObject2);
          localObject2 = new k.b();
          com.tencent.mm.plugin.patmsg.a.a locala = new com.tencent.mm.plugin.patmsg.a.a();
          locala.wFH = localcif;
          ((k.b)localObject2).a(locala);
          ((k.b)localObject2).type = 62;
          ((k.b)localObject2).title = aj.getContext().getString(2131760809);
          ((k.b)localObject2).url = aj.getContext().getString(2131760810);
          localbu.setContent(k.b.a((k.b)localObject2, "", null));
          localbu.setType(922746929);
          localbu.kr(0);
          localbu.tN(((cif)localObject1).fFR);
          localbu.qz(localcig.nxr);
          localbu.qA(localcig.createTime);
          localArrayList.add(localbu);
        }
      }
      AppMethodBeat.o(215678);
      return localArrayList;
    }
    AppMethodBeat.o(215678);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.patmsg.a
 * JD-Core Version:    0.7.0.1
 */