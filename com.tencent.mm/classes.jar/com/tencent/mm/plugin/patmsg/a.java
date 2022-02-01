package com.tencent.mm.plugin.patmsg;

import android.content.Context;
import android.content.res.Resources;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import android.widget.Toast;
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.g.a.on;
import com.tencent.mm.g.b.a.ee;
import com.tencent.mm.g.b.a.em;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.ch;
import com.tencent.mm.model.r;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.ciz;
import com.tencent.mm.protocal.protobuf.cja;
import com.tencent.mm.protocal.protobuf.cjb;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.protocal.protobuf.dau;
import com.tencent.mm.protocal.protobuf.dav;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.aq.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.bv;
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
  private static final int wUY;
  private static Map<String, Long> wUZ;
  public static final int wVc;
  private static final int wVd;
  private Set<Long> wVa;
  private com.tencent.mm.plugin.patmsg.b.c wVb;
  public final com.tencent.mm.plugin.messenger.foundation.a.q wVe;
  private aq wVf;
  
  static
  {
    AppMethodBeat.i(220314);
    wUY = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qPM, 10000);
    wUZ = new HashMap();
    wVc = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qPP, 5000);
    wVd = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qPO, 10000);
    AppMethodBeat.o(220314);
  }
  
  public a()
  {
    AppMethodBeat.i(220294);
    this.wVa = new HashSet();
    this.wVe = new com.tencent.mm.plugin.messenger.foundation.a.q()
    {
      public final void onNewXmlReceived(String paramAnonymousString, final Map<String, String> paramAnonymousMap, final com.tencent.mm.ak.e.a paramAnonymousa)
      {
        AppMethodBeat.i(220290);
        if ("pat".equals(paramAnonymousString)) {
          h.MqF.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(220289);
              String str1 = (String)paramAnonymousMap.get(".sysmsg.pat.fromusername");
              String str2 = (String)paramAnonymousMap.get(".sysmsg.pat.chatusername");
              String str3 = (String)paramAnonymousMap.get(".sysmsg.pat.pattedusername");
              String str4 = (String)paramAnonymousMap.get(".sysmsg.pat.template");
              ae.i("MicroMsg.PatMsgExtension", "fromUser: %s, chatUser: %s, pattedUser: %s, template:%s", new Object[] { str1, str2, str3, str4 });
              if (!((PluginPatMsg)g.ad(PluginPatMsg.class)).isPatEnable())
              {
                AppMethodBeat.o(220289);
                return;
              }
              if (((l)g.ab(l.class)).doJ().yu(paramAnonymousa.gte.xrk))
              {
                ae.w("MicroMsg.PatMsgExtension", "ignore insert, msg %d should be deleted!", new Object[] { Long.valueOf(paramAnonymousa.gte.xrk) });
                AppMethodBeat.o(220289);
                return;
              }
              a.b(str2, str1, str3, str4, paramAnonymousa.gte.CreateTime, paramAnonymousa.gte.xrk);
              AppMethodBeat.o(220289);
            }
          }, "HandlePatMsg");
        }
        AppMethodBeat.o(220290);
      }
    };
    this.wVf = new aq(Looper.getMainLooper(), new aq.a()
    {
      public final boolean handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(220291);
        Pair localPair;
        boolean bool;
        ciz localciz;
        cja localcja;
        if (paramAnonymousMessage.what == 291)
        {
          localObject = (com.tencent.mm.plugin.patmsg.b.c)paramAnonymousMessage.obj;
          ae.i("MicroMsg.PatMsgExtension", "send pat msg, msgId:%d, createTime:%d scene:%d, talker:%s, patUser:%s", new Object[] { ((com.tencent.mm.plugin.patmsg.b.c)localObject).wVv.first, ((com.tencent.mm.plugin.patmsg.b.c)localObject).wVv.second, Integer.valueOf(((com.tencent.mm.plugin.patmsg.b.c)localObject).scene), ((com.tencent.mm.plugin.patmsg.b.c)localObject).talker, ((com.tencent.mm.plugin.patmsg.b.c)localObject).wVx });
          paramAnonymousMessage = a.this;
          i = ((com.tencent.mm.plugin.patmsg.b.c)localObject).scene;
          localPair = ((com.tencent.mm.plugin.patmsg.b.c)localObject).wVv;
          bool = ((com.tencent.mm.plugin.patmsg.b.c)localObject).wVy;
          ae.i("MicroMsg.PatMsgExtension", "send pat, scene %d, msg (%d,%d)", new Object[] { Integer.valueOf(i), localPair.first, localPair.second });
          if (((PluginPatMsg)g.ad(PluginPatMsg.class)).isPatEnable())
          {
            localObject = ((l)g.ab(l.class)).doJ().ys(((Long)localPair.first).longValue());
            if (((ei)localObject).field_msgId == ((Long)localPair.first).longValue())
            {
              localciz = com.tencent.mm.util.e.aZx(((ei)localObject).field_content);
              localcja = paramAnonymousMessage.a(localciz, ((Long)localPair.second).longValue());
              if (localcja != null)
              {
                if (paramAnonymousMessage.G(i, localciz.fHV, localcja.HvD)) {
                  break label300;
                }
                ae.w("MicroMsg.PatMsgExtension", "cannot pat, scene %d, talker %s, patUser %s", new Object[] { Integer.valueOf(i), localciz.fHV, localcja.HvD });
              }
            }
          }
        }
        AppMethodBeat.o(220291);
        return false;
        label300:
        Object localObject = new em();
        ((em)localObject).dTw = i;
        if (x.zU(localciz.fHV)) {
          ((em)localObject).of(localciz.fHV);
        }
        ((em)localObject).ejH = (((Long)localPair.second).longValue() - ((com.tencent.mm.plugin.patmsg.a.b)g.ab(com.tencent.mm.plugin.patmsg.a.b.class)).b(localciz.fHV, localPair));
        if (a.a(localciz.fHV, localPair))
        {
          i = 1;
          label389:
          ((em)localObject).ejJ = i;
          ((em)localObject).ejK = (paramAnonymousMessage.b(localciz, ((Long)localPair.second).longValue()) + 1);
          ((em)localObject).od(localcja.dzZ);
          ((em)localObject).oe(localcja.HvD);
          ((em)localObject).ejh = localcja.createTime;
          ((em)localObject).og(c.avy(localcja.HvD));
          if (!bool) {
            break label520;
          }
        }
        label520:
        for (int i = 1;; i = 0)
        {
          ((em)localObject).ejL = i;
          paramAnonymousMessage = new com.tencent.mm.plugin.patmsg.b.b(localPair, localciz.fHV, localcja.HvD);
          paramAnonymousMessage.wVw = ((em)localObject);
          g.ajj().a(paramAnonymousMessage, 0);
          break;
          i = 0;
          break label389;
        }
      }
    });
    AppMethodBeat.o(220294);
  }
  
  private static Pair<Long, Long> a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, long paramLong)
  {
    AppMethodBeat.i(220295);
    Object localObject;
    long l;
    if (!bu.V(new String[] { paramString2, paramString1, paramString3 }))
    {
      localObject = paramString1;
      if (paramString1.equals(v.aAC())) {
        localObject = paramString2;
      }
      if ((x.zU((String)localObject)) && (!((l)g.ab(l.class)).doE().aqK((String)localObject)))
      {
        paramString1 = ((l)g.ab(l.class)).doJ().arc((String)localObject);
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
      localObject = new cja();
      ((cja)localObject).hGT = paramString4;
      ((cja)localObject).createTime = l;
      ((cja)localObject).dzZ = paramString2;
      ((cja)localObject).HvD = paramString3;
      ((cja)localObject).nCM = paramLong;
      paramString2 = com.tencent.mm.util.e.aZx(paramString1.field_content);
      paramString2.vAC.add(localObject);
      paramString3 = new k.b();
      paramString4 = new com.tencent.mm.plugin.patmsg.a.a();
      paramString4.wVs = paramString2;
      paramString3.a(paramString4);
      paramString3.type = 62;
      paramString3.title = ak.getContext().getString(2131760809);
      paramString3.url = ak.getContext().getString(2131760810);
      paramString1.setContent(k.b.a(paramString3, "", null));
      paramLong = paramString1.field_msgId;
      if (paramLong != 0L) {
        ((l)g.ab(l.class)).doJ().a(paramLong, paramString1);
      }
      ((PluginPatMsg)g.ad(PluginPatMsg.class)).addRecvRecord(paramString1.field_msgSvrId, (cja)localObject);
      ae.i("MicroMsg.PatMsgExtension", "update pat msg %d, index %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramString2.vAC.size() - 1) });
      paramString1 = Pair.create(Long.valueOf(paramLong), Long.valueOf(l));
      AppMethodBeat.o(220295);
      return paramString1;
      l = bl.B((String)localObject, paramInt);
      paramString1 = new bv();
      ciz localciz = new ciz();
      localciz.fHV = ((String)localObject);
      cja localcja = new cja();
      localcja.hGT = paramString4;
      localcja.createTime = l;
      localcja.dzZ = paramString2;
      localcja.HvD = paramString3;
      localcja.nCM = paramLong;
      localciz.vAC.add(localcja);
      paramString2 = new k.b();
      paramString3 = new com.tencent.mm.plugin.patmsg.a.a();
      paramString3.wVs = localciz;
      paramString2.a(paramString3);
      paramString2.type = 62;
      paramString2.title = ak.getContext().getString(2131760809);
      paramString2.url = ak.getContext().getString(2131760810);
      paramString1.setContent(k.b.a(paramString2, "", null));
      paramString1.kt(0);
      paramString1.ui((String)localObject);
      paramString1.qM(paramLong);
      paramString1.qN(l);
      paramString1.setType(922746929);
      ((PluginPatMsg)g.ad(PluginPatMsg.class)).addRecvRecord(paramString1.field_msgSvrId, localcja);
      paramLong = bl.v(paramString1);
      ae.i("MicroMsg.PatMsgExtension", "insert pat msg %d %s %s", new Object[] { Long.valueOf(paramLong), Integer.toHexString(paramString1.getType()), Integer.toHexString(922746929) });
      paramString1 = Pair.create(Long.valueOf(paramLong), Long.valueOf(l));
      AppMethodBeat.o(220295);
      return paramString1;
      paramString1 = Pair.create(Long.valueOf(0L), Long.valueOf(0L));
      AppMethodBeat.o(220295);
      return paramString1;
    }
  }
  
  static boolean a(String paramString, Pair<Long, Long> paramPair)
  {
    AppMethodBeat.i(220303);
    long l = ((l)g.ab(l.class)).doJ().aru(paramString);
    if (((Long)paramPair.second).longValue() <= l)
    {
      AppMethodBeat.o(220303);
      return true;
    }
    AppMethodBeat.o(220303);
    return false;
  }
  
  public final boolean G(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(220299);
    if (((paramInt == 3) || (paramInt == 4) || (paramInt == 5)) && (((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qPp, 0) == 0))
    {
      AppMethodBeat.o(220299);
      return false;
    }
    if (((!x.zU(paramString1)) && (!x.zS(paramString1))) || (x.AU(paramString1)) || (x.Ba(paramString1)) || (x.AQ(paramString1)) || (x.Ao(paramString1)))
    {
      ae.i("MicroMsg.PatMsgExtension", "cannot pat, talker %s", new Object[] { paramString1 });
      AppMethodBeat.o(220299);
      return false;
    }
    if ((!x.zS(paramString2)) || (x.AU(paramString2)) || (x.Ba(paramString2)) || (x.AQ(paramString2)) || (x.Ao(paramString2)))
    {
      ae.i("MicroMsg.PatMsgExtension", "cannot pat, user %s", new Object[] { paramString2 });
      AppMethodBeat.o(220299);
      return false;
    }
    if (x.zU(paramString1))
    {
      List localList = r.zA(paramString1);
      if ((localList != null) && (!localList.contains(paramString2)))
      {
        ae.w("MicroMsg.PatMsgExtension", "chatroom %s members %s, not contain %s", new Object[] { paramString1, localList, paramString2 });
        AppMethodBeat.o(220299);
        return false;
      }
    }
    AppMethodBeat.o(220299);
    return true;
  }
  
  public final Pair<Long, Long> H(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(220300);
    ae.i("MicroMsg.PatMsgExtension", "preSend pat, scene %d, talker %s, user %s", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2 });
    long l = ch.aDb();
    if (!((PluginPatMsg)g.ad(PluginPatMsg.class)).isPatEnable())
    {
      AppMethodBeat.o(220300);
      return null;
    }
    if (!G(paramInt, paramString1, paramString2))
    {
      ae.w("MicroMsg.PatMsgExtension", "cannot pat, scene %d, talker %s, user %s", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2 });
      AppMethodBeat.o(220300);
      return null;
    }
    Object localObject2 = v.aAC();
    Object localObject1 = new em();
    ((em)localObject1).dTw = paramInt;
    if (x.zU(paramString1)) {
      ((em)localObject1).of(paramString1);
    }
    ((em)localObject1).od((String)localObject2);
    ((em)localObject1).oe(paramString2);
    ((em)localObject1).ejh = l;
    ((em)localObject1).og(c.avy(paramString2));
    Object localObject3 = ((l)g.ab(l.class)).doJ().arc(paramString1);
    if ((localObject3 != null) && (((ei)localObject3).field_msgId > 0L))
    {
      if (((bv)localObject3).getType() != 922746929) {
        break label356;
      }
      localObject3 = com.tencent.mm.util.e.aZx(((ei)localObject3).field_content);
      if (((ciz)localObject3).vAC.size() <= 0) {}
    }
    label356:
    for (((em)localObject1).ejH = (l - ((cja)((ciz)localObject3).vAC.getLast()).createTime); (wUZ.containsKey(paramString2)) && (l - ((Long)wUZ.get(paramString2)).longValue() < wUY); ((em)localObject1).ejH = (l - ((ei)localObject3).field_createTime))
    {
      ae.w("MicroMsg.PatMsgExtension", "pat (%s) last time from now < %d", new Object[] { paramString2, Integer.valueOf(wUY) });
      ((em)localObject1).ejI = 1;
      ((em)localObject1).aLH();
      paramString1 = com.tencent.mm.util.b.LDa;
      com.tencent.mm.util.b.a((com.tencent.mm.plugin.report.a)localObject1);
      AppMethodBeat.o(220300);
      return null;
    }
    this.wVb = null;
    wUZ.put(paramString2, Long.valueOf(l));
    localObject1 = a(paramString1, (String)localObject2, paramString2, avx(paramString2), (int)(l / 1000L), 0L);
    if (((Long)((Pair)localObject1).first).longValue() > 0L)
    {
      localObject2 = new com.tencent.mm.plugin.patmsg.b.b((Pair)localObject1, paramString1, paramString2, 1);
      g.ajj().a((n)localObject2, 0);
      localObject2 = new com.tencent.mm.plugin.patmsg.b.c();
      ((com.tencent.mm.plugin.patmsg.b.c)localObject2).scene = paramInt;
      ((com.tencent.mm.plugin.patmsg.b.c)localObject2).talker = paramString1;
      ((com.tencent.mm.plugin.patmsg.b.c)localObject2).wVx = paramString2;
      ((com.tencent.mm.plugin.patmsg.b.c)localObject2).wVv = ((Pair)localObject1);
      this.wVf.sendMessageDelayed(this.wVf.obtainMessage(291, localObject2), wVc);
      this.wVb = ((com.tencent.mm.plugin.patmsg.b.c)localObject2);
    }
    AppMethodBeat.o(220300);
    return localObject1;
  }
  
  public final cja a(ciz paramciz, long paramLong)
  {
    AppMethodBeat.i(220301);
    paramciz = paramciz.vAC.iterator();
    while (paramciz.hasNext())
    {
      cja localcja = (cja)paramciz.next();
      if (localcja.createTime == paramLong)
      {
        AppMethodBeat.o(220301);
        return localcja;
      }
    }
    AppMethodBeat.o(220301);
    return null;
  }
  
  public final String a(ciz paramciz)
  {
    AppMethodBeat.i(220296);
    k.b localb = new k.b();
    com.tencent.mm.plugin.patmsg.a.a locala = new com.tencent.mm.plugin.patmsg.a.a();
    locala.wVs = paramciz;
    localb.a(locala);
    localb.type = 62;
    localb.title = ak.getContext().getString(2131760809);
    localb.url = ak.getContext().getString(2131760810);
    paramciz = k.b.a(localb, null, null);
    AppMethodBeat.o(220296);
    return paramciz;
  }
  
  public final void a(Pair<Long, Long> paramPair, int paramInt)
  {
    AppMethodBeat.i(220308);
    ae.i("MicroMsg.PatMsgExtension", "do revoke local pat msg (%d,%d)", new Object[] { paramPair.first, paramPair.second });
    Object localObject1 = ((l)g.ab(l.class)).doJ().ys(((Long)paramPair.first).longValue());
    if (((ei)localObject1).field_msgId == ((Long)paramPair.first).longValue())
    {
      localObject1 = com.tencent.mm.util.e.aZx(((ei)localObject1).field_content);
      Object localObject2 = a((ciz)localObject1, ((Long)paramPair.second).longValue());
      if (localObject2 != null)
      {
        Object localObject3;
        if (((cja)localObject2).nCM == 0L)
        {
          if ((this.wVb != null) && (this.wVb.wVv.equals(paramPair)))
          {
            ae.i("MicroMsg.PatMsgExtension", "do revoke unsent pat msg (%d,%d)", new Object[] { paramPair.first, paramPair.second });
            this.wVf.removeMessages(291, this.wVb);
            localObject2 = new em();
            ((em)localObject2).dTw = this.wVb.scene;
            if (x.zU(this.wVb.talker)) {
              ((em)localObject2).of(this.wVb.talker);
            }
            ((em)localObject2).ejH = (((Long)paramPair.second).longValue() - ((com.tencent.mm.plugin.patmsg.a.b)g.ab(com.tencent.mm.plugin.patmsg.a.b.class)).b(((ciz)localObject1).fHV, paramPair));
            int i;
            if (a(this.wVb.talker, paramPair))
            {
              i = 1;
              ((em)localObject2).ejJ = i;
              ((em)localObject2).ejK = (b((ciz)localObject1, ((Long)paramPair.second).longValue()) + 1);
              ((em)localObject2).od(v.aAC());
              ((em)localObject2).oe(this.wVb.wVx);
              ((em)localObject2).ejh = this.wVb.createTime;
              ((em)localObject2).og(c.avy(this.wVb.wVx));
              ((em)localObject2).ejo = 1;
              ((em)localObject2).ejm = paramInt;
              if (!this.wVb.wVy) {
                break label609;
              }
            }
            label609:
            for (paramInt = 1;; paramInt = 0)
            {
              ((em)localObject2).ejL = paramInt;
              ((em)localObject2).aLH();
              localObject1 = com.tencent.mm.util.b.LDa;
              com.tencent.mm.util.b.a((com.tencent.mm.plugin.report.a)localObject2);
              ae.i("MicroMsg.PatMsgExtension", "delete unsent pat msg (%d,%d)", new Object[] { paramPair.first, paramPair.second });
              localObject1 = ((l)g.ab(l.class)).doJ().ys(((Long)paramPair.first).longValue());
              if (((ei)localObject1).field_msgId != ((Long)paramPair.first).longValue()) {
                break label662;
              }
              localObject2 = com.tencent.mm.util.e.aZx(((ei)localObject1).field_content);
              ae.i("MicroMsg.PatMsgExtension", "before delete, pat record list size %d", new Object[] { Integer.valueOf(((ciz)localObject2).vAC.size()) });
              localObject3 = a((ciz)localObject2, ((Long)paramPair.second).longValue());
              if (localObject3 == null) {
                break label662;
              }
              ((ciz)localObject2).vAC.remove(localObject3);
              if (!((ciz)localObject2).vAC.isEmpty()) {
                break label614;
              }
              ((l)g.ab(l.class)).doJ().yt(((Long)paramPair.first).longValue());
              AppMethodBeat.o(220308);
              return;
              i = 0;
              break;
            }
            label614:
            ((bv)localObject1).setContent(a((ciz)localObject2));
            ((bv)localObject1).setType(922746929);
            ((l)g.ab(l.class)).doJ().a(((Long)paramPair.first).longValue(), (bv)localObject1);
            label662:
            AppMethodBeat.o(220308);
          }
        }
        else
        {
          ae.i("MicroMsg.PatMsgExtension", "do revoke sent pat msg %d, svrId %d", new Object[] { paramPair.first, Long.valueOf(((cja)localObject2).nCM) });
          localObject3 = new com.tencent.mm.plugin.patmsg.b.a(d(paramPair), ((Long)paramPair.first).longValue(), ((cja)localObject2).nCM, ((cja)localObject2).createTime, ((ciz)localObject1).fHV);
          ee localee = new ee();
          if ((this.wVb != null) && (this.wVb.wVv.equals(paramPair))) {
            localee.dTw = this.wVb.scene;
          }
          localee.ejh = ((cja)localObject2).createTime;
          localee.eji = System.currentTimeMillis();
          localee.nL(((cja)localObject2).dzZ);
          localee.nM(((cja)localObject2).HvD);
          localee.nN(c.avy(((cja)localObject2).HvD));
          if (x.zU(((ciz)localObject1).fHV)) {
            localee.nO(((ciz)localObject1).fHV);
          }
          localee.ejm = paramInt;
          localee.ejo = 1;
          ((com.tencent.mm.plugin.patmsg.b.a)localObject3).wVu = localee;
          g.ajj().a((n)localObject3, 0);
          if (g.ajR().ajA().getBoolean(am.a.Jey, true))
          {
            g.ajR().ajA().set(am.a.Jey, Boolean.FALSE);
            h.MqF.aO(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(220293);
                bv localbv = new bv();
                localbv.setContent(ak.getContext().getString(2131767133));
                localbv.setType(10000);
                localbv.kt(0);
                localbv.ui(this.wVi.fHV);
                localbv.qN(System.currentTimeMillis());
                bl.v(localbv);
                AppMethodBeat.o(220293);
              }
            });
          }
        }
      }
    }
    AppMethodBeat.o(220308);
  }
  
  public final boolean aa(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(220306);
    ae.i("MicroMsg.PatMsgExtension", "delete svr pat msg (%d,%d)", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    bv localbv = ((l)g.ab(l.class)).doJ().ys(paramLong1);
    ciz localciz;
    cja localcja;
    if ((localbv.field_msgId == paramLong1) && (paramLong2 != 0L))
    {
      localciz = com.tencent.mm.util.e.aZx(localbv.field_content);
      ae.i("MicroMsg.PatMsgExtension", "pat record list size %d", new Object[] { Integer.valueOf(localciz.vAC.size()) });
      Iterator localIterator = localciz.vAC.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localcja = (cja)localIterator.next();
      } while (localcja.nCM != paramLong2);
    }
    for (;;)
    {
      if (localcja != null)
      {
        localciz.vAC.remove(localcja);
        if (localciz.vAC.isEmpty()) {
          ((l)g.ab(l.class)).doJ().yt(paramLong1);
        }
        for (;;)
        {
          AppMethodBeat.o(220306);
          return true;
          localbv.setContent(a(localciz));
          localbv.setType(922746929);
          ((l)g.ab(l.class)).doJ().a(paramLong1, localbv);
        }
      }
      AppMethodBeat.o(220306);
      return false;
      localcja = null;
    }
  }
  
  public final ciz avw(String paramString)
  {
    AppMethodBeat.i(220297);
    paramString = com.tencent.mm.util.e.aZx(paramString);
    AppMethodBeat.o(220297);
    return paramString;
  }
  
  public final String avx(String paramString)
  {
    AppMethodBeat.i(220307);
    String str = v.aAC();
    int i = c.avz(paramString);
    ae.i("MicroMsg.PatMsgExtension", "pattedUser %s, version %d", new Object[] { paramString, Integer.valueOf(i) });
    if (paramString.equals(str))
    {
      paramString = (String)g.ajR().ajA().get(am.a.Jet, null);
      if (bu.isNullOrNil(paramString)) {
        paramString = ak.getContext().getString(2131766389);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(220307);
      return paramString;
      if (i == 0)
      {
        paramString = ak.getContext().getString(2131766969, new Object[] { paramString });
      }
      else
      {
        paramString = ak.getContext().getString(2131767166, new Object[] { paramString });
        continue;
        str = c.avy(paramString);
        ae.i("MicroMsg.PatMsgExtension", "pattedUser %s, suffix %s", new Object[] { paramString, str });
        if (bu.isNullOrNil(str)) {
          paramString = ak.getContext().getString(2131766390) + "\"" + w.zP(paramString) + "\"";
        } else if (i == 0) {
          paramString = ak.getContext().getString(2131766970, new Object[] { "\"" + w.zP(paramString) + "\"", str });
        } else {
          paramString = ak.getContext().getString(2131767167, new Object[] { "\"" + w.zP(paramString) + "\"", str });
        }
      }
    }
  }
  
  public final int b(ciz paramciz, long paramLong)
  {
    AppMethodBeat.i(220302);
    int j = -1;
    int i = 0;
    while (i < paramciz.vAC.size())
    {
      if (((cja)paramciz.vAC.get(i)).createTime == paramLong) {
        j = i;
      }
      i += 1;
    }
    AppMethodBeat.o(220302);
    return j;
  }
  
  public final long b(String paramString, Pair<Long, Long> paramPair)
  {
    AppMethodBeat.i(220304);
    paramString = ((l)g.ab(l.class)).doJ().f(paramString, ((Long)paramPair.second).longValue(), 1);
    if ((!paramString.isEmpty()) && (((bv)paramString.get(0)).field_msgId > 0L))
    {
      long l;
      if (((bv)paramString.get(0)).getType() == 922746929)
      {
        ciz localciz = com.tencent.mm.util.e.aZx(((bv)paramString.get(0)).field_content);
        if (localciz.vAC.size() == 0)
        {
          AppMethodBeat.o(220304);
          return 0L;
        }
        if (((Long)paramPair.first).longValue() == ((bv)paramString.get(0)).field_msgId)
        {
          int i = b(localciz, ((Long)paramPair.second).longValue());
          if (i > 1)
          {
            l = ((cja)localciz.vAC.get(i - 1)).createTime;
            AppMethodBeat.o(220304);
            return l;
          }
        }
        else
        {
          l = ((cja)localciz.vAC.getLast()).createTime;
          AppMethodBeat.o(220304);
          return l;
        }
      }
      else
      {
        l = ((bv)paramString.get(0)).field_createTime;
        AppMethodBeat.o(220304);
        return l;
      }
    }
    AppMethodBeat.o(220304);
    return 0L;
  }
  
  public final void bb(String paramString, long paramLong)
  {
    AppMethodBeat.i(220309);
    ae.i("MicroMsg.PatMsgExtension", "do revoke svr pat msg %d from talker %s", new Object[] { Long.valueOf(paramLong), paramString });
    cjb localcjb = ((PluginPatMsg)g.ad(PluginPatMsg.class)).getRecvRecord(paramLong);
    if (localcjb != null)
    {
      long l = localcjb.HvF;
      paramString = ((l)g.ab(l.class)).doJ().aJ(paramString, l);
      if (paramString.field_msgSvrId == l)
      {
        ae.i("MicroMsg.PatMsgExtension", "revoke pat msg %d,%d", new Object[] { Long.valueOf(paramString.field_msgId), Long.valueOf(paramLong) });
        aa(paramString.field_msgId, paramLong);
      }
    }
    AppMethodBeat.o(220309);
  }
  
  public final String d(Pair<Long, Long> paramPair)
  {
    AppMethodBeat.i(220310);
    paramPair = v.aAC() + "_" + paramPair.first + "_" + paramPair.second;
    AppMethodBeat.o(220310);
    return paramPair;
  }
  
  public final boolean e(Pair<Long, Long> paramPair)
  {
    AppMethodBeat.i(220311);
    if ((((PluginPatMsg)g.ad(PluginPatMsg.class)).isRevokePatMsgEnable()) && (this.wVb != null) && (this.wVb.wVv != null) && (this.wVb.wVv.equals(paramPair)) && ((int)(System.currentTimeMillis() - this.wVb.createTime) < wVd))
    {
      ae.i("MicroMsg.PatMsgExtension", "try revoke last pat, msgId:%d, createTime:%d, scene:%d, talker:%s, patUser:%s", new Object[] { this.wVb.wVv.first, this.wVb.wVv.second, Integer.valueOf(this.wVb.scene), this.wVb.talker, this.wVb.wVx });
      paramPair = a(com.tencent.mm.util.e.aZx(((l)g.ab(l.class)).doJ().ys(((Long)this.wVb.wVv.first).longValue()).field_content), ((Long)paramPair.second).longValue());
      if (paramPair != null)
      {
        boolean bool = this.wVb.wVx.equalsIgnoreCase(paramPair.HvD);
        AppMethodBeat.o(220311);
        return bool;
      }
    }
    AppMethodBeat.o(220311);
    return false;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final n paramn)
  {
    AppMethodBeat.i(220305);
    ae.i("MicroMsg.PatMsgExtension", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    paramString = ((com.tencent.mm.plugin.patmsg.b.b)paramn).wVw;
    if (paramString != null) {
      paramString.ejG = paramInt2;
    }
    int i = ((dau)((com.tencent.mm.plugin.patmsg.b.b)paramn).hZD.hQD.hQJ).Scene;
    ae.i("MicroMsg.PatMsgExtension", "onSceneEnd, pat scene %d", new Object[] { Integer.valueOf(i) });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      if (i == 1)
      {
        AppMethodBeat.o(220305);
        return;
      }
      Toast.makeText(ak.getContext(), ak.getContext().getString(2131755733) + "(" + paramInt1 + "," + paramInt2 + ")", 0).show();
      paramn = ((dau)((com.tencent.mm.plugin.patmsg.b.b)paramn).hZD.hQD.hQJ).HJV;
      if ((paramInt2 != -22) && (paramInt2 != -44)) {
        h.MqF.aO(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(220292);
            bv localbv = new bv();
            localbv.setContent(ak.getContext().getString(2131766388));
            localbv.setType(10000);
            localbv.kt(0);
            localbv.ui(paramn);
            localbv.qN(System.currentTimeMillis());
            ae.i("MicroMsg.PatMsgExtension", "insert pat failed msg %d", new Object[] { Long.valueOf(bl.v(localbv)) });
            AppMethodBeat.o(220292);
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
        paramString.aLH();
        paramn = com.tencent.mm.util.b.LDa;
        com.tencent.mm.util.b.a(paramString);
      }
      AppMethodBeat.o(220305);
      return;
      localObject1 = ((com.tencent.mm.plugin.patmsg.b.b)paramn).wVv;
      str = ((dau)((com.tencent.mm.plugin.patmsg.b.b)paramn).hZD.hQD.hQJ).HJW;
      if (i != 1) {
        break;
      }
      paramn = bu.nullAsNil(((dav)((com.tencent.mm.plugin.patmsg.b.b)paramn).hZD.hQE.hQJ).Hoy);
    } while (bu.isNullOrNil(str));
    c.iz(str, paramn);
    Object localObject3;
    cja localcja;
    if (((Long)((Pair)localObject1).first).longValue() > 0L)
    {
      localObject2 = ((l)g.ab(l.class)).doJ().ys(((Long)((Pair)localObject1).first).longValue());
      if (((ei)localObject2).field_msgId == ((Long)((Pair)localObject1).first).longValue())
      {
        localObject3 = com.tencent.mm.util.e.aZx(((ei)localObject2).field_content);
        localcja = a((ciz)localObject3, ((Long)((Pair)localObject1).second).longValue());
        if (localcja != null)
        {
          if (!str.equalsIgnoreCase(localcja.HvD)) {
            break label779;
          }
          localcja.hGT = avx(str);
          ((bv)localObject2).setContent(a((ciz)localObject3));
          ((bv)localObject2).setType(922746929);
          ((l)g.ab(l.class)).doJ().a(((Long)((Pair)localObject1).first).longValue(), (bv)localObject2);
          ae.i("MicroMsg.PatMsgExtension", "update pat msg suffix %d, createTime %d", new Object[] { ((Pair)localObject1).first, ((Pair)localObject1).second });
        }
      }
    }
    for (;;)
    {
      if ((!bu.isNullOrNil(paramn)) && (bu.isNullOrNil((String)g.ajR().ajA().get(am.a.Jet, null))) && (g.ajR().ajA().getBoolean(am.a.JeA, true)))
      {
        g.ajR().ajA().set(am.a.JeA, Boolean.FALSE);
        localObject1 = ((ei)localObject2).field_talker;
        localObject2 = String.format(ak.getContext().getResources().getString(2131767111), new Object[] { "<_wc_custom_link_ href='weixin://jump/setpat/'>", "</_wc_custom_link_>" });
        localObject3 = new bv();
        ((bv)localObject3).kt(0);
        ((bv)localObject3).ui((String)localObject1);
        ((bv)localObject3).setStatus(3);
        ((bv)localObject3).setContent((String)localObject2);
        ((bv)localObject3).qN(bl.B((String)localObject1, System.currentTimeMillis() / 1000L));
        ((bv)localObject3).setType(10000);
        ((bv)localObject3).setFlag(((ei)localObject3).field_flag);
        bl.v((bv)localObject3);
        if (this.wVb != null) {
          this.wVb.wVy = true;
        }
      }
      localObject1 = new on();
      ((on)localObject1).dDv.dDw = str;
      ((on)localObject1).dDv.dDx = paramn;
      ((on)localObject1).dDv.dDy = i;
      com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject1);
      break;
      label779:
      ae.w("MicroMsg.PatMsgExtension", "update pat msg suffix %d, pattedUser (%s,%s) not match", new Object[] { ((Pair)localObject1).first, str, localcja.HvD });
    }
    Object localObject2 = bx.M(((dav)((com.tencent.mm.plugin.patmsg.b.b)paramn).hZD.hQE.hQJ).HJX, "sysmsg");
    if (localObject2 != null) {}
    for (paramInt1 = bu.aSB((String)((Map)localObject2).get(".sysmsg.pat.patsuffixversion"));; paramInt1 = 0)
    {
      c.eK(str, paramInt1);
      long l = ((dav)((com.tencent.mm.plugin.patmsg.b.b)paramn).hZD.hQE.hQJ).FSD;
      if ((l == 0L) || (((Long)((Pair)localObject1).first).longValue() <= 0L)) {
        break;
      }
      paramn = ((l)g.ab(l.class)).doJ().ys(((Long)((Pair)localObject1).first).longValue());
      ae.i("MicroMsg.PatMsgExtension", "update pat msg %d, svrId %d", new Object[] { ((Pair)localObject1).first, Long.valueOf(l) });
      if (paramn.field_msgId != ((Long)((Pair)localObject1).first).longValue()) {
        break;
      }
      localObject2 = com.tencent.mm.util.e.aZx(paramn.field_content);
      localObject3 = a((ciz)localObject2, ((Long)((Pair)localObject1).second).longValue());
      if (localObject3 == null) {
        break;
      }
      if (str.equalsIgnoreCase(((cja)localObject3).HvD))
      {
        ((cja)localObject3).nCM = l;
        if (paramn.field_msgSvrId == 0L) {
          paramn.qM(l);
        }
        paramn.setContent(a((ciz)localObject2));
        paramn.setType(922746929);
        ((l)g.ab(l.class)).doJ().a(((Long)((Pair)localObject1).first).longValue(), paramn);
        ae.i("MicroMsg.PatMsgExtension", "update pat msg svrId %d, createTime %d", new Object[] { ((Pair)localObject1).first, ((Pair)localObject1).second });
        break;
      }
      ae.w("MicroMsg.PatMsgExtension", "update pat msg svrId %d, pattedUser (%s,%s) not match", new Object[] { ((Pair)localObject1).first, str, ((cja)localObject3).HvD });
      break;
    }
  }
  
  public final boolean yL(long paramLong)
  {
    AppMethodBeat.i(220298);
    if (this.wVa.contains(Long.valueOf(paramLong)))
    {
      AppMethodBeat.o(220298);
      return true;
    }
    Object localObject = ((l)g.ab(l.class)).doJ().ys(paramLong);
    if (((ei)localObject).field_msgId > 0L)
    {
      localObject = com.tencent.mm.util.e.aZx(((ei)localObject).field_content).vAC.iterator();
      int i = 1;
      if (((Iterator)localObject).hasNext())
      {
        if (((cja)((Iterator)localObject).next()).HvE == 1) {}
        for (int j = 1;; j = 0)
        {
          i = j & i;
          break;
        }
      }
      if (i != 0)
      {
        this.wVa.add(Long.valueOf(paramLong));
        AppMethodBeat.o(220298);
        return true;
      }
    }
    AppMethodBeat.o(220298);
    return false;
  }
  
  public final List<bv> yM(long paramLong)
  {
    AppMethodBeat.i(220312);
    Object localObject1 = ((l)g.ab(l.class)).doJ().ys(paramLong);
    if (((bv)localObject1).getType() == 922746929)
    {
      ArrayList localArrayList = new ArrayList();
      localObject1 = com.tencent.mm.util.e.aZx(((ei)localObject1).field_content);
      if (((ciz)localObject1).vAC == null) {}
      for (int i = 0;; i = ((ciz)localObject1).vAC.size())
      {
        ae.i("MicroMsg.PatMsgExtension", "split pat msg [%d] to %d child msg", new Object[] { Long.valueOf(paramLong), Integer.valueOf(i) });
        Iterator localIterator = ((ciz)localObject1).vAC.iterator();
        while (localIterator.hasNext())
        {
          cja localcja = (cja)localIterator.next();
          bv localbv = new bv();
          ciz localciz = new ciz();
          localciz.fHV = ((ciz)localObject1).fHV;
          Object localObject2 = new com.tencent.mm.util.e.a();
          ((com.tencent.mm.util.e.a)localObject2).hGT = localcja.hGT;
          ((com.tencent.mm.util.e.a)localObject2).LDn = localcja.hGT;
          ((com.tencent.mm.util.e.a)localObject2).createTime = localcja.createTime;
          ((com.tencent.mm.util.e.a)localObject2).dzZ = localcja.dzZ;
          ((com.tencent.mm.util.e.a)localObject2).HvD = localcja.HvD;
          ((com.tencent.mm.util.e.a)localObject2).nCM = localcja.nCM;
          localciz.vAC.add(localObject2);
          localObject2 = new k.b();
          com.tencent.mm.plugin.patmsg.a.a locala = new com.tencent.mm.plugin.patmsg.a.a();
          locala.wVs = localciz;
          ((k.b)localObject2).a(locala);
          ((k.b)localObject2).type = 62;
          ((k.b)localObject2).title = ak.getContext().getString(2131760809);
          ((k.b)localObject2).url = ak.getContext().getString(2131760810);
          localbv.setContent(k.b.a((k.b)localObject2, "", null));
          localbv.setType(922746929);
          localbv.kt(0);
          localbv.ui(((ciz)localObject1).fHV);
          localbv.qM(localcja.nCM);
          localbv.qN(localcja.createTime);
          localArrayList.add(localbv);
        }
      }
      AppMethodBeat.o(220312);
      return localArrayList;
    }
    AppMethodBeat.o(220312);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.patmsg.a
 * JD-Core Version:    0.7.0.1
 */