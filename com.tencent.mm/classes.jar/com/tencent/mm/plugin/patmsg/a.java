package com.tencent.mm.plugin.patmsg;

import android.content.Context;
import android.content.res.Resources;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import android.widget.Toast;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.pf;
import com.tencent.mm.g.b.a.hk;
import com.tencent.mm.g.b.a.hu;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.czg;
import com.tencent.mm.protocal.protobuf.czh;
import com.tencent.mm.protocal.protobuf.czi;
import com.tencent.mm.protocal.protobuf.dty;
import com.tencent.mm.protocal.protobuf.dtz;
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
import com.tencent.mm.util.e.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class a
  implements com.tencent.mm.ak.i, com.tencent.mm.plugin.patmsg.a.b
{
  private static final int AQU;
  private static Map<String, Long> AQV;
  public static final int AQY;
  private static final int AQZ;
  private Set<Long> AQW;
  private com.tencent.mm.plugin.patmsg.b.c AQX;
  public final com.tencent.mm.plugin.messenger.foundation.a.q ARa;
  private MMHandler ARb;
  
  static
  {
    AppMethodBeat.i(206936);
    AQU = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.smX, 10000);
    AQV = new HashMap();
    AQY = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sna, 5000);
    AQZ = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.smZ, 10000);
    AppMethodBeat.o(206936);
  }
  
  public a()
  {
    AppMethodBeat.i(206916);
    this.AQW = new HashSet();
    this.ARa = new a.1(this);
    this.ARb = new MMHandler(Looper.getMainLooper(), new MMHandler.Callback()
    {
      public final boolean handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(206913);
        Pair localPair;
        boolean bool;
        czg localczg;
        czh localczh;
        if (paramAnonymousMessage.what == 291)
        {
          localObject = (com.tencent.mm.plugin.patmsg.b.c)paramAnonymousMessage.obj;
          Log.i("MicroMsg.PatMsgExtension", "send pat msg, msgId:%d, createTime:%d scene:%d, talker:%s, patUser:%s", new Object[] { ((com.tencent.mm.plugin.patmsg.b.c)localObject).ARo.first, ((com.tencent.mm.plugin.patmsg.b.c)localObject).ARo.second, Integer.valueOf(((com.tencent.mm.plugin.patmsg.b.c)localObject).scene), ((com.tencent.mm.plugin.patmsg.b.c)localObject).talker, ((com.tencent.mm.plugin.patmsg.b.c)localObject).ARq });
          paramAnonymousMessage = a.this;
          i = ((com.tencent.mm.plugin.patmsg.b.c)localObject).scene;
          localPair = ((com.tencent.mm.plugin.patmsg.b.c)localObject).ARo;
          bool = ((com.tencent.mm.plugin.patmsg.b.c)localObject).ARr;
          Log.i("MicroMsg.PatMsgExtension", "send pat, scene %d, msg (%d,%d)", new Object[] { Integer.valueOf(i), localPair.first, localPair.second });
          if (((PluginPatMsg)g.ah(PluginPatMsg.class)).isPatEnable())
          {
            localObject = ((l)g.af(l.class)).eiy().Hb(((Long)localPair.first).longValue());
            if (((eo)localObject).field_msgId == ((Long)localPair.first).longValue())
            {
              localczg = com.tencent.mm.util.e.boC(((eo)localObject).field_content);
              localczh = paramAnonymousMessage.a(localczg, ((Long)localPair.second).longValue());
              if (localczh != null)
              {
                if (paramAnonymousMessage.J(i, localczg.gnh, localczh.MEA)) {
                  break label300;
                }
                Log.w("MicroMsg.PatMsgExtension", "cannot pat, scene %d, talker %s, patUser %s", new Object[] { Integer.valueOf(i), localczg.gnh, localczh.MEA });
              }
            }
          }
        }
        AppMethodBeat.o(206913);
        return false;
        label300:
        Object localObject = new hu();
        ((hu)localObject).enq = i;
        if (ab.Ix(localczg.gnh)) {
          ((hu)localObject).vz(localczg.gnh);
        }
        ((hu)localObject).eMu = (((Long)localPair.second).longValue() - ((com.tencent.mm.plugin.patmsg.a.b)g.af(com.tencent.mm.plugin.patmsg.a.b.class)).b(localczg.gnh, localPair));
        if (a.a(localczg.gnh, localPair))
        {
          i = 1;
          label389:
          ((hu)localObject).eMw = i;
          ((hu)localObject).eMx = (paramAnonymousMessage.b(localczg, ((Long)localPair.second).longValue()) + 1);
          ((hu)localObject).vx(localczh.dRL);
          ((hu)localObject).vy(localczh.MEA);
          ((hu)localObject).eLQ = localczh.createTime;
          ((hu)localObject).vA(c.aJL(localczh.MEA));
          if (!bool) {
            break label520;
          }
        }
        label520:
        for (int i = 1;; i = 0)
        {
          ((hu)localObject).eMy = i;
          paramAnonymousMessage = new com.tencent.mm.plugin.patmsg.b.b(localPair, localczg.gnh, localczh.MEA);
          paramAnonymousMessage.ARp = ((hu)localObject);
          g.azz().a(paramAnonymousMessage, 0);
          break;
          i = 0;
          break label389;
        }
      }
    });
    AppMethodBeat.o(206916);
  }
  
  private static Pair<Long, Long> a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, long paramLong)
  {
    AppMethodBeat.i(206917);
    Object localObject;
    long l1;
    if (!Util.isNullOrNil(new String[] { paramString2, paramString1, paramString3 }))
    {
      localObject = paramString1;
      if (paramString1.equals(z.aTY())) {
        localObject = paramString2;
      }
      if ((ab.Ix((String)localObject)) && (!((l)g.af(l.class)).eit().aEf((String)localObject)))
      {
        paramString1 = ((l)g.af(l.class)).eiy().aEx((String)localObject);
        if ((paramString1 != null) && (paramString1.field_msgId > 0L) && (paramString1.getType() == 922746929))
        {
          l1 = paramInt * 1000L;
          if (l1 > paramString1.field_createTime) {
            break label834;
          }
          l1 = paramString1.field_createTime + 1L;
        }
      }
    }
    label834:
    for (;;)
    {
      localObject = new czh();
      ((czh)localObject).iBd = paramString4;
      ((czh)localObject).createTime = l1;
      ((czh)localObject).dRL = paramString2;
      ((czh)localObject).MEA = paramString3;
      ((czh)localObject).oNJ = paramLong;
      paramString2 = com.tencent.mm.util.e.boC(paramString1.field_content);
      paramString2.yVw.add(localObject);
      paramString3 = new k.b();
      paramString4 = new com.tencent.mm.plugin.patmsg.a.a();
      paramString4.ARl = paramString2;
      paramString3.a(paramString4);
      paramString3.type = 62;
      paramString3.title = MMApplicationContext.getContext().getString(2131762562);
      paramString3.url = MMApplicationContext.getContext().getString(2131762563);
      paramString1.setContent(k.b.a(paramString3, "", null));
      paramLong = paramString1.field_msgId;
      if (paramLong != 0L) {
        ((l)g.af(l.class)).eiy().a(paramLong, paramString1);
      }
      ((PluginPatMsg)g.ah(PluginPatMsg.class)).addRecvRecord(paramString1.field_msgSvrId, (czh)localObject);
      Log.i("MicroMsg.PatMsgExtension", "update pat msg %d, index %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramString2.yVw.size() - 1) });
      paramString1 = Pair.create(Long.valueOf(paramLong), Long.valueOf(l1));
      AppMethodBeat.o(206917);
      return paramString1;
      l1 = bp.C((String)localObject, paramInt);
      paramString1 = new ca();
      czg localczg = new czg();
      localczg.gnh = ((String)localObject);
      czh localczh = new czh();
      localczh.iBd = paramString4;
      localczh.createTime = l1;
      localczh.dRL = paramString2;
      localczh.MEA = paramString3;
      localczh.oNJ = paramLong;
      paramString4 = g.aAh().azQ().a(ar.a.Oob, "");
      long l2 = g.aAh().azQ().a(ar.a.Ooj, 0L);
      paramInt = g.aAh().azQ().getInt(ar.a.Ook, 0);
      if ((paramString3.equals(z.aTY())) && (!Util.isNullOrNil(paramString4)) && (cl.aWA() - l2 > 604800000L) && (paramInt < 5))
      {
        Log.i("MicroMsg.PatMsgExtension", "show modify tip %s %s %s %s %s", new Object[] { Long.valueOf(paramLong), paramString2, Long.valueOf(l2), Integer.valueOf(paramInt), paramString4 });
        localczh.MEC = 1;
        g.aAh().azQ().set(ar.a.Ooj, Long.valueOf(cl.aWA()));
        g.aAh().azQ().set(ar.a.Ook, Integer.valueOf(paramInt + 1));
      }
      localczg.yVw.add(localczh);
      paramString2 = new k.b();
      paramString3 = new com.tencent.mm.plugin.patmsg.a.a();
      paramString3.ARl = localczg;
      paramString2.a(paramString3);
      paramString2.type = 62;
      paramString2.title = MMApplicationContext.getContext().getString(2131762562);
      paramString2.url = MMApplicationContext.getContext().getString(2131762563);
      paramString1.setContent(k.b.a(paramString2, "", null));
      paramString1.nv(0);
      paramString1.Cy((String)localObject);
      paramString1.yF(paramLong);
      paramString1.setCreateTime(l1);
      paramString1.setType(922746929);
      ((PluginPatMsg)g.ah(PluginPatMsg.class)).addRecvRecord(paramString1.field_msgSvrId, localczh);
      paramLong = bp.x(paramString1);
      Log.i("MicroMsg.PatMsgExtension", "insert pat msg %d %s %s", new Object[] { Long.valueOf(paramLong), Integer.toHexString(paramString1.getType()), Integer.toHexString(922746929) });
      paramString1 = Pair.create(Long.valueOf(paramLong), Long.valueOf(l1));
      AppMethodBeat.o(206917);
      return paramString1;
      paramString1 = Pair.create(Long.valueOf(0L), Long.valueOf(0L));
      AppMethodBeat.o(206917);
      return paramString1;
    }
  }
  
  static boolean a(String paramString, Pair<Long, Long> paramPair)
  {
    AppMethodBeat.i(206925);
    long l = ((l)g.af(l.class)).eiy().aEP(paramString);
    if (((Long)paramPair.second).longValue() <= l)
    {
      AppMethodBeat.o(206925);
      return true;
    }
    AppMethodBeat.o(206925);
    return false;
  }
  
  public final boolean HD(long paramLong)
  {
    AppMethodBeat.i(206920);
    if (this.AQW.contains(Long.valueOf(paramLong)))
    {
      AppMethodBeat.o(206920);
      return true;
    }
    Object localObject = ((l)g.af(l.class)).eiy().Hb(paramLong);
    if (((eo)localObject).field_msgId > 0L)
    {
      localObject = com.tencent.mm.util.e.boC(((eo)localObject).field_content).yVw.iterator();
      int i = 1;
      if (((Iterator)localObject).hasNext())
      {
        if (((czh)((Iterator)localObject).next()).MEB == 1) {}
        for (int j = 1;; j = 0)
        {
          i = j & i;
          break;
        }
      }
      if (i != 0)
      {
        this.AQW.add(Long.valueOf(paramLong));
        AppMethodBeat.o(206920);
        return true;
      }
    }
    AppMethodBeat.o(206920);
    return false;
  }
  
  public final List<ca> HE(long paramLong)
  {
    AppMethodBeat.i(206934);
    Object localObject1 = ((l)g.af(l.class)).eiy().Hb(paramLong);
    if (((ca)localObject1).getType() == 922746929)
    {
      ArrayList localArrayList = new ArrayList();
      localObject1 = com.tencent.mm.util.e.boC(((eo)localObject1).field_content);
      if (((czg)localObject1).yVw == null) {}
      for (int i = 0;; i = ((czg)localObject1).yVw.size())
      {
        Log.i("MicroMsg.PatMsgExtension", "split pat msg [%d] to %d child msg", new Object[] { Long.valueOf(paramLong), Integer.valueOf(i) });
        Iterator localIterator = ((czg)localObject1).yVw.iterator();
        while (localIterator.hasNext())
        {
          czh localczh = (czh)localIterator.next();
          ca localca = new ca();
          czg localczg = new czg();
          localczg.gnh = ((czg)localObject1).gnh;
          Object localObject2 = new e.a();
          ((e.a)localObject2).iBd = localczh.iBd;
          ((e.a)localObject2).QYI = localczh.iBd;
          ((e.a)localObject2).createTime = localczh.createTime;
          ((e.a)localObject2).dRL = localczh.dRL;
          ((e.a)localObject2).MEA = localczh.MEA;
          ((e.a)localObject2).oNJ = localczh.oNJ;
          localczg.yVw.add(localObject2);
          localObject2 = new k.b();
          com.tencent.mm.plugin.patmsg.a.a locala = new com.tencent.mm.plugin.patmsg.a.a();
          locala.ARl = localczg;
          ((k.b)localObject2).a(locala);
          ((k.b)localObject2).type = 62;
          ((k.b)localObject2).title = MMApplicationContext.getContext().getString(2131762562);
          ((k.b)localObject2).url = MMApplicationContext.getContext().getString(2131762563);
          localca.setContent(k.b.a((k.b)localObject2, "", null));
          localca.setType(922746929);
          localca.nv(0);
          localca.Cy(((czg)localObject1).gnh);
          localca.yF(localczh.oNJ);
          localca.setCreateTime(localczh.createTime);
          localArrayList.add(localca);
        }
      }
      AppMethodBeat.o(206934);
      return localArrayList;
    }
    AppMethodBeat.o(206934);
    return null;
  }
  
  public final boolean J(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(206921);
    if (((paramInt == 3) || (paramInt == 4) || (paramInt == 5)) && (((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.smy, 0) == 0))
    {
      AppMethodBeat.o(206921);
      return false;
    }
    if (((!ab.Ix(paramString1)) && (!ab.Iu(paramString1))) || (ab.Jz(paramString1)) || (ab.JF(paramString1)) || (ab.Jv(paramString1)) || (ab.IT(paramString1)))
    {
      Log.i("MicroMsg.PatMsgExtension", "cannot pat, talker %s", new Object[] { paramString1 });
      AppMethodBeat.o(206921);
      return false;
    }
    if ((!ab.Iu(paramString2)) || (ab.Jz(paramString2)) || (ab.JF(paramString2)) || (ab.Jv(paramString2)) || (ab.IT(paramString2)))
    {
      Log.i("MicroMsg.PatMsgExtension", "cannot pat, user %s", new Object[] { paramString2 });
      AppMethodBeat.o(206921);
      return false;
    }
    if (ab.Ix(paramString1))
    {
      List localList = v.Ic(paramString1);
      if ((localList != null) && (!localList.contains(paramString2)))
      {
        Log.w("MicroMsg.PatMsgExtension", "chatroom %s members %s, not contain %s", new Object[] { paramString1, localList, paramString2 });
        AppMethodBeat.o(206921);
        return false;
      }
    }
    AppMethodBeat.o(206921);
    return true;
  }
  
  public final Pair<Long, Long> K(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(206922);
    Log.i("MicroMsg.PatMsgExtension", "preSend pat, scene %d, talker %s, user %s", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2 });
    long l = cl.aWz();
    if (!((PluginPatMsg)g.ah(PluginPatMsg.class)).isPatEnable())
    {
      AppMethodBeat.o(206922);
      return null;
    }
    if (!J(paramInt, paramString1, paramString2))
    {
      Log.w("MicroMsg.PatMsgExtension", "cannot pat, scene %d, talker %s, user %s", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2 });
      AppMethodBeat.o(206922);
      return null;
    }
    Object localObject2 = z.aTY();
    Object localObject1 = new hu();
    ((hu)localObject1).enq = paramInt;
    if (ab.Ix(paramString1)) {
      ((hu)localObject1).vz(paramString1);
    }
    ((hu)localObject1).vx((String)localObject2);
    ((hu)localObject1).vy(paramString2);
    ((hu)localObject1).eLQ = l;
    ((hu)localObject1).vA(c.aJL(paramString2));
    Object localObject3 = ((l)g.af(l.class)).eiy().aEx(paramString1);
    if ((localObject3 != null) && (((eo)localObject3).field_msgId > 0L))
    {
      if (((ca)localObject3).getType() != 922746929) {
        break label356;
      }
      localObject3 = com.tencent.mm.util.e.boC(((eo)localObject3).field_content);
      if (((czg)localObject3).yVw.size() <= 0) {}
    }
    label356:
    for (((hu)localObject1).eMu = (l - ((czh)((czg)localObject3).yVw.getLast()).createTime); (AQV.containsKey(paramString2)) && (l - ((Long)AQV.get(paramString2)).longValue() < AQU); ((hu)localObject1).eMu = (l - ((eo)localObject3).field_createTime))
    {
      Log.w("MicroMsg.PatMsgExtension", "pat (%s) last time from now < %d", new Object[] { paramString2, Integer.valueOf(AQU) });
      ((hu)localObject1).eMv = 1;
      ((hu)localObject1).bfK();
      paramString1 = com.tencent.mm.util.b.QYu;
      com.tencent.mm.util.b.a((com.tencent.mm.plugin.report.a)localObject1);
      AppMethodBeat.o(206922);
      return null;
    }
    this.AQX = null;
    AQV.put(paramString2, Long.valueOf(l));
    localObject1 = a(paramString1, (String)localObject2, paramString2, aJK(paramString2), (int)(l / 1000L), 0L);
    if (((Long)((Pair)localObject1).first).longValue() > 0L)
    {
      localObject2 = new com.tencent.mm.plugin.patmsg.b.b((Pair)localObject1, paramString1, paramString2, 1);
      g.azz().a((com.tencent.mm.ak.q)localObject2, 0);
      localObject2 = new com.tencent.mm.plugin.patmsg.b.c();
      ((com.tencent.mm.plugin.patmsg.b.c)localObject2).scene = paramInt;
      ((com.tencent.mm.plugin.patmsg.b.c)localObject2).talker = paramString1;
      ((com.tencent.mm.plugin.patmsg.b.c)localObject2).ARq = paramString2;
      ((com.tencent.mm.plugin.patmsg.b.c)localObject2).ARo = ((Pair)localObject1);
      this.ARb.sendMessageDelayed(this.ARb.obtainMessage(291, localObject2), AQY);
      this.AQX = ((com.tencent.mm.plugin.patmsg.b.c)localObject2);
    }
    AppMethodBeat.o(206922);
    return localObject1;
  }
  
  public final czh a(czg paramczg, long paramLong)
  {
    AppMethodBeat.i(206923);
    paramczg = paramczg.yVw.iterator();
    while (paramczg.hasNext())
    {
      czh localczh = (czh)paramczg.next();
      if (localczh.createTime == paramLong)
      {
        AppMethodBeat.o(206923);
        return localczh;
      }
    }
    AppMethodBeat.o(206923);
    return null;
  }
  
  public final String a(czg paramczg)
  {
    AppMethodBeat.i(206918);
    k.b localb = new k.b();
    com.tencent.mm.plugin.patmsg.a.a locala = new com.tencent.mm.plugin.patmsg.a.a();
    locala.ARl = paramczg;
    localb.a(locala);
    localb.type = 62;
    localb.title = MMApplicationContext.getContext().getString(2131762562);
    localb.url = MMApplicationContext.getContext().getString(2131762563);
    paramczg = k.b.a(localb, null, null);
    AppMethodBeat.o(206918);
    return paramczg;
  }
  
  public final void a(Pair<Long, Long> paramPair, int paramInt)
  {
    AppMethodBeat.i(206930);
    Log.i("MicroMsg.PatMsgExtension", "do revoke local pat msg (%d,%d)", new Object[] { paramPair.first, paramPair.second });
    Object localObject1 = ((l)g.af(l.class)).eiy().Hb(((Long)paramPair.first).longValue());
    if (((eo)localObject1).field_msgId == ((Long)paramPair.first).longValue())
    {
      localObject1 = com.tencent.mm.util.e.boC(((eo)localObject1).field_content);
      Object localObject2 = a((czg)localObject1, ((Long)paramPair.second).longValue());
      if (localObject2 != null)
      {
        Object localObject3;
        if (((czh)localObject2).oNJ == 0L)
        {
          if ((this.AQX != null) && (this.AQX.ARo.equals(paramPair)))
          {
            Log.i("MicroMsg.PatMsgExtension", "do revoke unsent pat msg (%d,%d)", new Object[] { paramPair.first, paramPair.second });
            this.ARb.removeMessages(291, this.AQX);
            localObject2 = new hu();
            ((hu)localObject2).enq = this.AQX.scene;
            if (ab.Ix(this.AQX.talker)) {
              ((hu)localObject2).vz(this.AQX.talker);
            }
            ((hu)localObject2).eMu = (((Long)paramPair.second).longValue() - ((com.tencent.mm.plugin.patmsg.a.b)g.af(com.tencent.mm.plugin.patmsg.a.b.class)).b(((czg)localObject1).gnh, paramPair));
            int i;
            if (a(this.AQX.talker, paramPair))
            {
              i = 1;
              ((hu)localObject2).eMw = i;
              ((hu)localObject2).eMx = (b((czg)localObject1, ((Long)paramPair.second).longValue()) + 1);
              ((hu)localObject2).vx(z.aTY());
              ((hu)localObject2).vy(this.AQX.ARq);
              ((hu)localObject2).eLQ = this.AQX.createTime;
              ((hu)localObject2).vA(c.aJL(this.AQX.ARq));
              ((hu)localObject2).eLX = 1;
              ((hu)localObject2).eLV = paramInt;
              if (!this.AQX.ARr) {
                break label609;
              }
            }
            label609:
            for (paramInt = 1;; paramInt = 0)
            {
              ((hu)localObject2).eMy = paramInt;
              ((hu)localObject2).bfK();
              localObject1 = com.tencent.mm.util.b.QYu;
              com.tencent.mm.util.b.a((com.tencent.mm.plugin.report.a)localObject2);
              Log.i("MicroMsg.PatMsgExtension", "delete unsent pat msg (%d,%d)", new Object[] { paramPair.first, paramPair.second });
              localObject1 = ((l)g.af(l.class)).eiy().Hb(((Long)paramPair.first).longValue());
              if (((eo)localObject1).field_msgId != ((Long)paramPair.first).longValue()) {
                break label662;
              }
              localObject2 = com.tencent.mm.util.e.boC(((eo)localObject1).field_content);
              Log.i("MicroMsg.PatMsgExtension", "before delete, pat record list size %d", new Object[] { Integer.valueOf(((czg)localObject2).yVw.size()) });
              localObject3 = a((czg)localObject2, ((Long)paramPair.second).longValue());
              if (localObject3 == null) {
                break label662;
              }
              ((czg)localObject2).yVw.remove(localObject3);
              if (!((czg)localObject2).yVw.isEmpty()) {
                break label614;
              }
              ((l)g.af(l.class)).eiy().Hc(((Long)paramPair.first).longValue());
              AppMethodBeat.o(206930);
              return;
              i = 0;
              break;
            }
            label614:
            ((ca)localObject1).setContent(a((czg)localObject2));
            ((ca)localObject1).setType(922746929);
            ((l)g.af(l.class)).eiy().a(((Long)paramPair.first).longValue(), (ca)localObject1);
            label662:
            AppMethodBeat.o(206930);
          }
        }
        else
        {
          Log.i("MicroMsg.PatMsgExtension", "do revoke sent pat msg %d, svrId %d", new Object[] { paramPair.first, Long.valueOf(((czh)localObject2).oNJ) });
          localObject3 = new com.tencent.mm.plugin.patmsg.b.a(d(paramPair), ((Long)paramPair.first).longValue(), ((czh)localObject2).oNJ, ((czh)localObject2).createTime, ((czg)localObject1).gnh);
          hk localhk = new hk();
          if ((this.AQX != null) && (this.AQX.ARo.equals(paramPair))) {
            localhk.enq = this.AQX.scene;
          }
          localhk.eLQ = ((czh)localObject2).createTime;
          localhk.eLR = System.currentTimeMillis();
          localhk.ve(((czh)localObject2).dRL);
          localhk.vf(((czh)localObject2).MEA);
          localhk.vg(c.aJL(((czh)localObject2).MEA));
          if (ab.Ix(((czg)localObject1).gnh)) {
            localhk.vh(((czg)localObject1).gnh);
          }
          localhk.eLV = paramInt;
          localhk.eLX = 1;
          ((com.tencent.mm.plugin.patmsg.b.a)localObject3).ARn = localhk;
          g.azz().a((com.tencent.mm.ak.q)localObject3, 0);
          if (g.aAh().azQ().getBoolean(ar.a.Oog, true))
          {
            g.aAh().azQ().set(ar.a.Oog, Boolean.FALSE);
            h.RTc.aX(new a.4(this, (czg)localObject1));
          }
        }
      }
    }
    AppMethodBeat.o(206930);
  }
  
  public final czg aJJ(String paramString)
  {
    AppMethodBeat.i(206919);
    paramString = com.tencent.mm.util.e.boC(paramString);
    AppMethodBeat.o(206919);
    return paramString;
  }
  
  public final String aJK(String paramString)
  {
    AppMethodBeat.i(206929);
    String str = z.aTY();
    int i = c.aJM(paramString);
    Log.i("MicroMsg.PatMsgExtension", "pattedUser %s, version %d", new Object[] { paramString, Integer.valueOf(i) });
    if (paramString.equals(str))
    {
      paramString = (String)g.aAh().azQ().get(ar.a.Oob, null);
      if (Util.isNullOrNil(paramString)) {
        paramString = MMApplicationContext.getContext().getString(2131765218);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(206929);
      return paramString;
      if (i == 0)
      {
        paramString = MMApplicationContext.getContext().getString(2131765220, new Object[] { paramString });
      }
      else
      {
        paramString = MMApplicationContext.getContext().getString(2131765219, new Object[] { paramString });
        continue;
        str = c.aJL(paramString);
        Log.i("MicroMsg.PatMsgExtension", "pattedUser %s, suffix %s", new Object[] { paramString, str });
        if (Util.isNullOrNil(str)) {
          paramString = MMApplicationContext.getContext().getString(2131765221) + "\"" + aa.getDisplayName(paramString) + "\"";
        } else if (i == 0) {
          paramString = MMApplicationContext.getContext().getString(2131765223, new Object[] { "\"" + aa.getDisplayName(paramString) + "\"", str });
        } else {
          paramString = MMApplicationContext.getContext().getString(2131765222, new Object[] { "\"" + aa.getDisplayName(paramString) + "\"", str });
        }
      }
    }
  }
  
  public final boolean ae(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(206928);
    Log.i("MicroMsg.PatMsgExtension", "delete svr pat msg (%d,%d)", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    ca localca = ((l)g.af(l.class)).eiy().Hb(paramLong1);
    czg localczg;
    czh localczh;
    if ((localca.field_msgId == paramLong1) && (paramLong2 != 0L))
    {
      localczg = com.tencent.mm.util.e.boC(localca.field_content);
      Log.i("MicroMsg.PatMsgExtension", "pat record list size %d", new Object[] { Integer.valueOf(localczg.yVw.size()) });
      Iterator localIterator = localczg.yVw.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localczh = (czh)localIterator.next();
      } while (localczh.oNJ != paramLong2);
    }
    for (;;)
    {
      if (localczh != null)
      {
        localczg.yVw.remove(localczh);
        if (localczg.yVw.isEmpty()) {
          ((l)g.af(l.class)).eiy().Hc(paramLong1);
        }
        for (;;)
        {
          AppMethodBeat.o(206928);
          return true;
          localca.setContent(a(localczg));
          localca.setType(922746929);
          ((l)g.af(l.class)).eiy().a(paramLong1, localca);
        }
      }
      AppMethodBeat.o(206928);
      return false;
      localczh = null;
    }
  }
  
  public final int b(czg paramczg, long paramLong)
  {
    AppMethodBeat.i(206924);
    int j = -1;
    int i = 0;
    while (i < paramczg.yVw.size())
    {
      if (((czh)paramczg.yVw.get(i)).createTime == paramLong) {
        j = i;
      }
      i += 1;
    }
    AppMethodBeat.o(206924);
    return j;
  }
  
  public final long b(String paramString, Pair<Long, Long> paramPair)
  {
    AppMethodBeat.i(206926);
    paramString = ((l)g.af(l.class)).eiy().f(paramString, ((Long)paramPair.second).longValue(), 1);
    if ((!paramString.isEmpty()) && (((ca)paramString.get(0)).field_msgId > 0L))
    {
      long l;
      if (((ca)paramString.get(0)).getType() == 922746929)
      {
        czg localczg = com.tencent.mm.util.e.boC(((ca)paramString.get(0)).field_content);
        if (localczg.yVw.size() == 0)
        {
          AppMethodBeat.o(206926);
          return 0L;
        }
        if (((Long)paramPair.first).longValue() == ((ca)paramString.get(0)).field_msgId)
        {
          int i = b(localczg, ((Long)paramPair.second).longValue());
          if (i > 1)
          {
            l = ((czh)localczg.yVw.get(i - 1)).createTime;
            AppMethodBeat.o(206926);
            return l;
          }
        }
        else
        {
          l = ((czh)localczg.yVw.getLast()).createTime;
          AppMethodBeat.o(206926);
          return l;
        }
      }
      else
      {
        l = ((ca)paramString.get(0)).field_createTime;
        AppMethodBeat.o(206926);
        return l;
      }
    }
    AppMethodBeat.o(206926);
    return 0L;
  }
  
  public final void bd(String paramString, long paramLong)
  {
    AppMethodBeat.i(206931);
    Log.i("MicroMsg.PatMsgExtension", "do revoke svr pat msg %d from talker %s", new Object[] { Long.valueOf(paramLong), paramString });
    czi localczi = ((PluginPatMsg)g.ah(PluginPatMsg.class)).getRecvRecord(paramLong);
    if (localczi != null)
    {
      long l = localczi.MED;
      paramString = ((l)g.af(l.class)).eiy().aJ(paramString, l);
      if (paramString.field_msgSvrId == l)
      {
        Log.i("MicroMsg.PatMsgExtension", "revoke pat msg %d,%d", new Object[] { Long.valueOf(paramString.field_msgId), Long.valueOf(paramLong) });
        ae(paramString.field_msgId, paramLong);
      }
    }
    AppMethodBeat.o(206931);
  }
  
  public final String d(Pair<Long, Long> paramPair)
  {
    AppMethodBeat.i(206932);
    paramPair = z.aTY() + "_" + paramPair.first + "_" + paramPair.second;
    AppMethodBeat.o(206932);
    return paramPair;
  }
  
  public final boolean e(Pair<Long, Long> paramPair)
  {
    AppMethodBeat.i(206933);
    if ((((PluginPatMsg)g.ah(PluginPatMsg.class)).isRevokePatMsgEnable()) && (this.AQX != null) && (this.AQX.ARo != null) && (this.AQX.ARo.equals(paramPair)) && ((int)(System.currentTimeMillis() - this.AQX.createTime) < AQZ))
    {
      Log.i("MicroMsg.PatMsgExtension", "try revoke last pat, msgId:%d, createTime:%d, scene:%d, talker:%s, patUser:%s", new Object[] { this.AQX.ARo.first, this.AQX.ARo.second, Integer.valueOf(this.AQX.scene), this.AQX.talker, this.AQX.ARq });
      paramPair = a(com.tencent.mm.util.e.boC(((l)g.af(l.class)).eiy().Hb(((Long)this.AQX.ARo.first).longValue()).field_content), ((Long)paramPair.second).longValue());
      if (paramPair != null)
      {
        boolean bool = this.AQX.ARq.equalsIgnoreCase(paramPair.MEA);
        AppMethodBeat.o(206933);
        return bool;
      }
    }
    AppMethodBeat.o(206933);
    return false;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(206927);
    Log.i("MicroMsg.PatMsgExtension", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    paramString = ((com.tencent.mm.plugin.patmsg.b.b)paramq).ARp;
    if (paramString != null) {
      paramString.eqN = paramInt2;
    }
    int i = ((dty)((com.tencent.mm.plugin.patmsg.b.b)paramq).iUB.iLK.iLR).Scene;
    Log.i("MicroMsg.PatMsgExtension", "onSceneEnd, pat scene %d", new Object[] { Integer.valueOf(i) });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      if (i == 1)
      {
        AppMethodBeat.o(206927);
        return;
      }
      Toast.makeText(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(2131755804) + "(" + paramInt1 + "," + paramInt2 + ")", 0).show();
      paramq = ((dty)((com.tencent.mm.plugin.patmsg.b.b)paramq).iUB.iLK.iLR).MVH;
      if ((paramInt2 != -22) && (paramInt2 != -44)) {
        h.RTc.aX(new a.3(this, paramq));
      }
    }
    Object localObject1;
    String str;
    do
    {
      if (paramString != null)
      {
        paramString.bfK();
        paramq = com.tencent.mm.util.b.QYu;
        com.tencent.mm.util.b.a(paramString);
      }
      AppMethodBeat.o(206927);
      return;
      localObject1 = ((com.tencent.mm.plugin.patmsg.b.b)paramq).ARo;
      str = ((dty)((com.tencent.mm.plugin.patmsg.b.b)paramq).iUB.iLK.iLR).MVI;
      if (i != 1) {
        break;
      }
      paramq = Util.nullAsNil(((dtz)((com.tencent.mm.plugin.patmsg.b.b)paramq).iUB.iLL.iLR).MvT);
    } while (Util.isNullOrNil(str));
    c.jk(str, paramq);
    Object localObject3;
    czh localczh;
    if (((Long)((Pair)localObject1).first).longValue() > 0L)
    {
      localObject2 = ((l)g.af(l.class)).eiy().Hb(((Long)((Pair)localObject1).first).longValue());
      if (((eo)localObject2).field_msgId == ((Long)((Pair)localObject1).first).longValue())
      {
        localObject3 = com.tencent.mm.util.e.boC(((eo)localObject2).field_content);
        localczh = a((czg)localObject3, ((Long)((Pair)localObject1).second).longValue());
        if (localczh != null)
        {
          if (!str.equalsIgnoreCase(localczh.MEA)) {
            break label779;
          }
          localczh.iBd = aJK(str);
          ((ca)localObject2).setContent(a((czg)localObject3));
          ((ca)localObject2).setType(922746929);
          ((l)g.af(l.class)).eiy().a(((Long)((Pair)localObject1).first).longValue(), (ca)localObject2);
          Log.i("MicroMsg.PatMsgExtension", "update pat msg suffix %d, createTime %d", new Object[] { ((Pair)localObject1).first, ((Pair)localObject1).second });
        }
      }
    }
    for (;;)
    {
      if ((!Util.isNullOrNil(paramq)) && (Util.isNullOrNil((String)g.aAh().azQ().get(ar.a.Oob, null))) && (g.aAh().azQ().getBoolean(ar.a.Ooi, true)))
      {
        g.aAh().azQ().set(ar.a.Ooi, Boolean.FALSE);
        localObject1 = ((eo)localObject2).field_talker;
        localObject2 = String.format(MMApplicationContext.getContext().getResources().getString(2131763815), new Object[] { "<_wc_custom_link_ href='weixin://jump/setpat/'>", "</_wc_custom_link_>" });
        localObject3 = new ca();
        ((ca)localObject3).nv(0);
        ((ca)localObject3).Cy((String)localObject1);
        ((ca)localObject3).setStatus(3);
        ((ca)localObject3).setContent((String)localObject2);
        ((ca)localObject3).setCreateTime(bp.C((String)localObject1, System.currentTimeMillis() / 1000L));
        ((ca)localObject3).setType(10000);
        ((ca)localObject3).setFlag(((eo)localObject3).field_flag);
        bp.x((ca)localObject3);
        if (this.AQX != null) {
          this.AQX.ARr = true;
        }
      }
      localObject1 = new pf();
      ((pf)localObject1).dVk.dVl = str;
      ((pf)localObject1).dVk.dVm = paramq;
      ((pf)localObject1).dVk.dVn = i;
      EventCenter.instance.publish((IEvent)localObject1);
      break;
      label779:
      Log.w("MicroMsg.PatMsgExtension", "update pat msg suffix %d, pattedUser (%s,%s) not match", new Object[] { ((Pair)localObject1).first, str, localczh.MEA });
    }
    Object localObject2 = XmlParser.parseXml(((dtz)((com.tencent.mm.plugin.patmsg.b.b)paramq).iUB.iLL.iLR).MVJ, "sysmsg", null);
    if (localObject2 != null) {}
    for (paramInt1 = Util.safeParseInt((String)((Map)localObject2).get(".sysmsg.pat.patsuffixversion"));; paramInt1 = 0)
    {
      c.fa(str, paramInt1);
      long l = ((dtz)((com.tencent.mm.plugin.patmsg.b.b)paramq).iUB.iLL.iLR).KMm;
      if ((l == 0L) || (((Long)((Pair)localObject1).first).longValue() <= 0L)) {
        break;
      }
      paramq = ((l)g.af(l.class)).eiy().Hb(((Long)((Pair)localObject1).first).longValue());
      Log.i("MicroMsg.PatMsgExtension", "update pat msg %d, svrId %d", new Object[] { ((Pair)localObject1).first, Long.valueOf(l) });
      if (paramq.field_msgId != ((Long)((Pair)localObject1).first).longValue()) {
        break;
      }
      localObject2 = com.tencent.mm.util.e.boC(paramq.field_content);
      localObject3 = a((czg)localObject2, ((Long)((Pair)localObject1).second).longValue());
      if (localObject3 == null) {
        break;
      }
      if (str.equalsIgnoreCase(((czh)localObject3).MEA))
      {
        ((czh)localObject3).oNJ = l;
        if (paramq.field_msgSvrId == 0L) {
          paramq.yF(l);
        }
        paramq.setContent(a((czg)localObject2));
        paramq.setType(922746929);
        ((l)g.af(l.class)).eiy().a(((Long)((Pair)localObject1).first).longValue(), paramq);
        Log.i("MicroMsg.PatMsgExtension", "update pat msg svrId %d, createTime %d", new Object[] { ((Pair)localObject1).first, ((Pair)localObject1).second });
        break;
      }
      Log.w("MicroMsg.PatMsgExtension", "update pat msg svrId %d, pattedUser (%s,%s) not match", new Object[] { ((Pair)localObject1).first, str, ((czh)localObject3).MEA });
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.patmsg.a
 * JD-Core Version:    0.7.0.1
 */