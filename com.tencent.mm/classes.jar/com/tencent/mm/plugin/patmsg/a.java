package com.tencent.mm.plugin.patmsg;

import android.content.Context;
import android.content.res.Resources;
import android.os.Looper;
import android.os.Message;
import android.text.SpannableString;
import android.util.Pair;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.rq;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.autogen.mmdata.rpt.mc;
import com.tencent.mm.autogen.mmdata.rpt.mt;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.br;
import com.tencent.mm.model.cn;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.t;
import com.tencent.mm.plugin.patmsg.a.b.a;
import com.tencent.mm.plugin.patmsg.a.f.a;
import com.tencent.mm.plugin.textstatus.a.a.b;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.protocal.protobuf.ebd;
import com.tencent.mm.protocal.protobuf.ebe;
import com.tencent.mm.protocal.protobuf.ebf;
import com.tencent.mm.protocal.protobuf.exr;
import com.tencent.mm.protocal.protobuf.exs;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandler.Callback;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.base.span.BoldForegroundColorSpan;
import com.tencent.mm.util.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class a
  implements com.tencent.mm.am.h, com.tencent.mm.plugin.patmsg.a.b
{
  private static final int MGU;
  private static Map<String, Long> MGV;
  public static final int MGY;
  private static final int MGZ;
  private Set<Long> MGW;
  private com.tencent.mm.plugin.patmsg.b.c MGX;
  public final t MHa;
  private MMHandler MHb;
  
  static
  {
    AppMethodBeat.i(266417);
    MGU = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zqP, 10000);
    MGV = new HashMap();
    MGY = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zqS, 5000);
    MGZ = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zqR, 10000);
    AppMethodBeat.o(266417);
  }
  
  public a()
  {
    AppMethodBeat.i(266354);
    this.MGW = new HashSet();
    this.MHa = new t()
    {
      public final void onNewXmlReceived(String paramAnonymousString, final Map<String, String> paramAnonymousMap, final com.tencent.mm.am.g.a paramAnonymousa)
      {
        AppMethodBeat.i(266365);
        if ("pat".equals(paramAnonymousString)) {
          com.tencent.threadpool.h.ahAA.g(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(266368);
              String str1 = (String)paramAnonymousMap.get(".sysmsg.pat.fromusername");
              String str2 = (String)paramAnonymousMap.get(".sysmsg.pat.chatusername");
              String str3 = (String)paramAnonymousMap.get(".sysmsg.pat.pattedusername");
              String str4 = (String)paramAnonymousMap.get(".sysmsg.pat.template");
              Log.i("MicroMsg.PatMsgExtension", "fromUser: %s, chatUser: %s, pattedUser: %s, template:%s", new Object[] { str1, str2, str3, str4 });
              if (!((PluginPatMsg)com.tencent.mm.kernel.h.az(PluginPatMsg.class)).isPatEnable())
              {
                AppMethodBeat.o(266368);
                return;
              }
              if (((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sn(paramAnonymousa.mpN.Njv))
              {
                Log.w("MicroMsg.PatMsgExtension", "ignore insert, msg %d should be deleted!", new Object[] { Long.valueOf(paramAnonymousa.mpN.Njv) });
                AppMethodBeat.o(266368);
                return;
              }
              a.a(a.this, str2, str1, str3, str4, paramAnonymousa.mpN.CreateTime, paramAnonymousa.mpN.Njv);
              AppMethodBeat.o(266368);
            }
          }, "HandlePatMsg");
        }
        AppMethodBeat.o(266365);
      }
    };
    this.MHb = new MMHandler(Looper.getMainLooper(), new MMHandler.Callback()
    {
      public final boolean handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(266374);
        Pair localPair;
        boolean bool;
        ebd localebd;
        ebe localebe;
        if (paramAnonymousMessage.what == 291)
        {
          localObject = (com.tencent.mm.plugin.patmsg.b.c)paramAnonymousMessage.obj;
          Log.i("MicroMsg.PatMsgExtension", "send pat msg, msgId:%d, createTime:%d scene:%d, talker:%s, patUser:%s", new Object[] { ((com.tencent.mm.plugin.patmsg.b.c)localObject).MHt.first, ((com.tencent.mm.plugin.patmsg.b.c)localObject).MHt.second, Integer.valueOf(((com.tencent.mm.plugin.patmsg.b.c)localObject).scene), ((com.tencent.mm.plugin.patmsg.b.c)localObject).talker, ((com.tencent.mm.plugin.patmsg.b.c)localObject).MHv });
          paramAnonymousMessage = a.this;
          i = ((com.tencent.mm.plugin.patmsg.b.c)localObject).scene;
          localPair = ((com.tencent.mm.plugin.patmsg.b.c)localObject).MHt;
          bool = ((com.tencent.mm.plugin.patmsg.b.c)localObject).MHw;
          Log.i("MicroMsg.PatMsgExtension", "send pat, scene %d, msg (%d,%d)", new Object[] { Integer.valueOf(i), localPair.first, localPair.second });
          if (((PluginPatMsg)com.tencent.mm.kernel.h.az(PluginPatMsg.class)).isPatEnable())
          {
            localObject = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sl(((Long)localPair.first).longValue());
            if ((localObject != null) && (((fi)localObject).field_msgId == ((Long)localPair.first).longValue()))
            {
              localebd = g.bDK(((fi)localObject).field_content);
              localebe = paramAnonymousMessage.a(localebd, ((Long)localPair.second).longValue());
              if (localebe != null)
              {
                if (paramAnonymousMessage.kM(localebd.ltm, localebe.abgI)) {
                  break label304;
                }
                Log.w("MicroMsg.PatMsgExtension", "cannot pat, scene %d, talker %s, patUser %s", new Object[] { Integer.valueOf(i), localebd.ltm, localebe.abgI });
              }
            }
          }
        }
        AppMethodBeat.o(266374);
        return false;
        label304:
        Object localObject = new mt();
        ((mt)localObject).imW = i;
        if (au.bwG(localebd.ltm)) {
          ((mt)localObject).vf(localebd.ltm);
        }
        ((mt)localObject).jcp = (((Long)localPair.second).longValue() - ((com.tencent.mm.plugin.patmsg.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.patmsg.a.b.class)).b(localebd.ltm, localPair));
        if (a.a(localebd.ltm, localPair))
        {
          i = 1;
          label393:
          ((mt)localObject).jcr = i;
          ((mt)localObject).jcs = (paramAnonymousMessage.b(localebd, ((Long)localPair.second).longValue()) + 1);
          ((mt)localObject).vd(localebe.hQQ);
          ((mt)localObject).ve(localebe.abgI);
          ((mt)localObject).jaZ = localebe.createTime;
          ((mt)localObject).vg(c.aRm(localebe.abgI));
          if (!bool) {
            break label524;
          }
        }
        label524:
        for (int i = 1;; i = 0)
        {
          ((mt)localObject).jct = i;
          paramAnonymousMessage = new com.tencent.mm.plugin.patmsg.b.b(localPair, localebd.ltm, localebe.abgI);
          paramAnonymousMessage.MHu = ((mt)localObject);
          com.tencent.mm.kernel.h.aZW().a(paramAnonymousMessage, 0);
          break;
          i = 0;
          break label393;
        }
      }
    });
    AppMethodBeat.o(266354);
  }
  
  private static Pair<Long, Long> a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, long paramLong)
  {
    AppMethodBeat.i(266370);
    Object localObject;
    long l1;
    if (!Util.isNullOrNil(new String[] { paramString2, paramString1, paramString3 }))
    {
      localObject = paramString1;
      if (paramString1.equals(z.bAM())) {
        localObject = paramString2;
      }
      if ((au.bwG((String)localObject)) && (!((n)com.tencent.mm.kernel.h.ax(n.class)).gaU().aLo((String)localObject)))
      {
        paramString1 = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().aLG((String)localObject);
        if ((paramString1 != null) && (paramString1.field_msgId > 0L) && (paramString1.getType() == 922746929))
        {
          l1 = paramInt * 1000L;
          if (l1 > paramString1.getCreateTime()) {
            break label887;
          }
          l1 = paramString1.getCreateTime() + 1L;
        }
      }
    }
    label887:
    for (;;)
    {
      localObject = new ebe();
      ((ebe)localObject).nVS = paramString4;
      ((ebe)localObject).createTime = l1;
      ((ebe)localObject).hQQ = paramString2;
      ((ebe)localObject).abgI = paramString3;
      ((ebe)localObject).vaU = paramLong;
      paramString2 = g.bDK(paramString1.field_content);
      paramString2.ltm = paramString1.field_talker;
      paramString2.Ksg.add(localObject);
      paramString3 = new k.b();
      paramString4 = new com.tencent.mm.plugin.patmsg.a.a();
      paramString4.MHl = paramString2;
      paramString3.a(paramString4);
      paramString3.type = 62;
      paramString3.title = MMApplicationContext.getContext().getString(d.f.low_version_upgrade_tip);
      paramString3.url = MMApplicationContext.getContext().getString(d.f.low_version_upgrade_url);
      paramString1.setContent(k.b.a(paramString3, "", null));
      paramLong = paramString1.field_msgId;
      if (paramLong != 0L) {
        ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().a(paramLong, paramString1);
      }
      ((PluginPatMsg)com.tencent.mm.kernel.h.az(PluginPatMsg.class)).addRecvRecord(paramString1.field_msgSvrId, (ebe)localObject);
      Log.i("MicroMsg.PatMsgExtension", "update pat msg %d, index %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramString2.Ksg.size() - 1) });
      paramString1 = Pair.create(Long.valueOf(paramLong), Long.valueOf(l1));
      AppMethodBeat.o(266370);
      return paramString1;
      l1 = br.D((String)localObject, paramInt);
      paramString1 = new cc();
      ebd localebd = new ebd();
      localebd.ltm = ((String)localObject);
      ebe localebe = new ebe();
      localebe.nVS = paramString4;
      localebe.createTime = l1;
      localebe.hQQ = paramString2;
      localebe.abgI = paramString3;
      localebe.vaU = paramLong;
      paramString4 = com.tencent.mm.kernel.h.baE().ban().b(at.a.adgr, "");
      long l2 = com.tencent.mm.kernel.h.baE().ban().a(at.a.adgz, 0L);
      paramInt = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adgA, 0);
      if ((paramString3.equals(z.bAM())) && (!Util.isNullOrNil(paramString4)) && (cn.bDw() - l2 > ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zqa, 86400L) * 1000L) && (paramInt < ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zqb, 2147483647)))
      {
        Log.i("MicroMsg.PatMsgExtension", "show modify tip %s %s %s %s %s", new Object[] { Long.valueOf(paramLong), paramString2, Long.valueOf(l2), Integer.valueOf(paramInt), paramString4 });
        localebe.abgK = 1;
        com.tencent.mm.kernel.h.baE().ban().set(at.a.adgz, Long.valueOf(cn.bDw()));
        com.tencent.mm.kernel.h.baE().ban().set(at.a.adgA, Integer.valueOf(paramInt + 1));
      }
      localebd.Ksg.add(localebe);
      paramString2 = new k.b();
      paramString3 = new com.tencent.mm.plugin.patmsg.a.a();
      paramString3.MHl = localebd;
      paramString2.a(paramString3);
      paramString2.type = 62;
      paramString2.title = MMApplicationContext.getContext().getString(d.f.low_version_upgrade_tip);
      paramString2.url = MMApplicationContext.getContext().getString(d.f.low_version_upgrade_url);
      paramString1.setContent(k.b.a(paramString2, "", null));
      paramString1.pI(0);
      paramString1.BS((String)localObject);
      paramString1.gX(paramLong);
      paramString1.setCreateTime(l1);
      paramString1.setType(922746929);
      ((PluginPatMsg)com.tencent.mm.kernel.h.az(PluginPatMsg.class)).addRecvRecord(paramString1.field_msgSvrId, localebe);
      paramLong = br.B(paramString1);
      Log.i("MicroMsg.PatMsgExtension", "insert pat msg %d %s %s", new Object[] { Long.valueOf(paramLong), Integer.toHexString(paramString1.getType()), Integer.toHexString(922746929) });
      paramString1 = Pair.create(Long.valueOf(paramLong), Long.valueOf(l1));
      AppMethodBeat.o(266370);
      return paramString1;
      paramString1 = Pair.create(Long.valueOf(0L), Long.valueOf(0L));
      AppMethodBeat.o(266370);
      return paramString1;
    }
  }
  
  public static void a(mt parammt)
  {
    AppMethodBeat.i(266401);
    if (parammt != null)
    {
      String str1 = parammt.imU;
      String str2 = parammt.jbb;
      parammt.vh(((com.tencent.mm.plugin.textstatus.a.f)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.textstatus.a.f.class)).getTextStatusId(str1));
      parammt.vi(((com.tencent.mm.plugin.textstatus.a.f)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.textstatus.a.f.class)).getTextStatusId(str2));
      parammt.vj(((com.tencent.mm.plugin.textstatus.a.f)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.textstatus.a.f.class)).getTextStatusIconId(str1));
      parammt.vk(((com.tencent.mm.plugin.textstatus.a.f)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.textstatus.a.f.class)).getTextStatusIconId(str2));
    }
    AppMethodBeat.o(266401);
  }
  
  static boolean a(String paramString, Pair<Long, Long> paramPair)
  {
    AppMethodBeat.i(266376);
    long l = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().aLZ(paramString);
    if (((Long)paramPair.second).longValue() <= l)
    {
      AppMethodBeat.o(266376);
      return true;
    }
    AppMethodBeat.o(266376);
    return false;
  }
  
  private static String afq(int paramInt)
  {
    AppMethodBeat.i(266395);
    String str = MMApplicationContext.getContext().getString(paramInt).replaceAll("\\[", "{").replaceAll("]", "}");
    AppMethodBeat.o(266395);
    return str;
  }
  
  private static String kN(String paramString1, String paramString2)
  {
    AppMethodBeat.i(266386);
    String str = z.bAM();
    int i = c.aRn(paramString1);
    Log.i("MicroMsg.PatMsgExtension", "pattedUser %s, version %d", new Object[] { paramString1, Integer.valueOf(i) });
    if (paramString1.equals(str))
    {
      paramString1 = (String)com.tencent.mm.kernel.h.baE().ban().get(at.a.adgr, null);
      if (Util.isNullOrNil(paramString1)) {
        paramString1 = afq(d.f.send_pat_msg_self_tip);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(266386);
      return paramString1;
      if (i == 0)
      {
        paramString1 = String.format(afq(d.f.send_pat_msg_self_tip_with_suffix), new Object[] { paramString1 });
      }
      else
      {
        paramString1 = String.format(afq(d.f.send_pat_msg_self_tip_with_new_suffix), new Object[] { paramString1 });
        continue;
        str = c.aRm(paramString1);
        Log.i("MicroMsg.PatMsgExtension", "pattedUser %s, suffix %s", new Object[] { paramString1, str });
        if (au.bwE(paramString2)) {}
        for (paramString1 = ab.aW(paramString2, paramString1);; paramString1 = aa.getDisplayName(paramString1))
        {
          if (!Util.isNullOrNil(str)) {
            break label207;
          }
          paramString1 = String.format(afq(d.f.send_pat_msg_tip), new Object[] { paramString1 });
          break;
        }
        label207:
        if (i == 0) {
          paramString1 = String.format(afq(d.f.send_pat_msg_tip_with_suffix), new Object[] { paramString1, str });
        } else {
          paramString1 = String.format(afq(d.f.send_pat_msg_tip_with_new_suffix), new Object[] { paramString1, str });
        }
      }
    }
  }
  
  public final Pair<Long, Long> Q(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(266453);
    Log.i("MicroMsg.PatMsgExtension", "preSend pat, scene %d, talker %s, user %s", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2 });
    long l = cn.bDv();
    if (!((PluginPatMsg)com.tencent.mm.kernel.h.az(PluginPatMsg.class)).isPatEnable())
    {
      AppMethodBeat.o(266453);
      return null;
    }
    if (!kM(paramString1, paramString2))
    {
      Log.w("MicroMsg.PatMsgExtension", "cannot pat, scene %d, talker %s, user %s", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2 });
      AppMethodBeat.o(266453);
      return null;
    }
    Object localObject2 = z.bAM();
    Object localObject1 = new mt();
    ((mt)localObject1).imW = paramInt;
    if (au.bwG(paramString1)) {
      ((mt)localObject1).vf(paramString1);
    }
    ((mt)localObject1).vd((String)localObject2);
    ((mt)localObject1).ve(paramString2);
    ((mt)localObject1).jaZ = l;
    ((mt)localObject1).vg(c.aRm(paramString2));
    Object localObject3 = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().aLG(paramString1);
    if ((localObject3 != null) && (((fi)localObject3).field_msgId > 0L))
    {
      if (((cc)localObject3).getType() != 922746929) {
        break label360;
      }
      localObject3 = g.bDK(((fi)localObject3).field_content);
      if (((ebd)localObject3).Ksg.size() <= 0) {}
    }
    label360:
    for (((mt)localObject1).jcp = (l - ((ebe)((ebd)localObject3).Ksg.getLast()).createTime); (MGV.containsKey(paramString2)) && (l - ((Long)MGV.get(paramString2)).longValue() < MGU); ((mt)localObject1).jcp = (l - ((cc)localObject3).getCreateTime()))
    {
      Log.w("MicroMsg.PatMsgExtension", "pat (%s) last time from now < %d", new Object[] { paramString2, Integer.valueOf(MGU) });
      ((mt)localObject1).jcq = 1;
      a((mt)localObject1);
      ((mt)localObject1).bMH();
      paramString1 = com.tencent.mm.util.c.agsX;
      com.tencent.mm.util.c.a((com.tencent.mm.plugin.report.a)localObject1);
      AppMethodBeat.o(266453);
      return null;
    }
    this.MGX = null;
    MGV.put(paramString2, Long.valueOf(l));
    localObject1 = a(paramString1, (String)localObject2, paramString2, kN(paramString2, paramString1), (int)(l / 1000L), 0L);
    if (((Long)((Pair)localObject1).first).longValue() > 0L)
    {
      localObject2 = new com.tencent.mm.plugin.patmsg.b.b((Pair)localObject1, paramString1, paramString2, 1);
      com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)localObject2, 0);
      localObject2 = new com.tencent.mm.plugin.patmsg.b.c();
      ((com.tencent.mm.plugin.patmsg.b.c)localObject2).scene = paramInt;
      ((com.tencent.mm.plugin.patmsg.b.c)localObject2).talker = paramString1;
      ((com.tencent.mm.plugin.patmsg.b.c)localObject2).MHv = paramString2;
      ((com.tencent.mm.plugin.patmsg.b.c)localObject2).MHt = ((Pair)localObject1);
      this.MHb.sendMessageDelayed(this.MHb.obtainMessage(291, localObject2), MGY);
      this.MGX = ((com.tencent.mm.plugin.patmsg.b.c)localObject2);
    }
    AppMethodBeat.o(266453);
    return localObject1;
  }
  
  public final ebe a(ebd paramebd, long paramLong)
  {
    AppMethodBeat.i(266456);
    paramebd = paramebd.Ksg.iterator();
    while (paramebd.hasNext())
    {
      ebe localebe = (ebe)paramebd.next();
      if (localebe.createTime == paramLong)
      {
        AppMethodBeat.o(266456);
        return localebe;
      }
    }
    AppMethodBeat.o(266456);
    return null;
  }
  
  public final CharSequence a(String paramString1, String paramString2, float paramFloat)
  {
    AppMethodBeat.i(266475);
    Object localObject = kN(paramString1, paramString2);
    paramString2 = ((PluginPatMsg)com.tencent.mm.kernel.h.az(PluginPatMsg.class)).parseDisplayTemplate(com.tencent.mm.plugin.auth.a.a.cUx(), paramString1, ((CharSequence)localObject).toString(), paramString2);
    paramString1 = new SpannableString(paramString2.result);
    if (paramString2.MHr.size() > 0)
    {
      paramString2 = paramString2.MHr.iterator();
      while (paramString2.hasNext())
      {
        localObject = (f.a)paramString2.next();
        paramString1.setSpan(((com.tencent.mm.plugin.textstatus.a.f)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.textstatus.a.f.class)).getTextStatusSpanSync(null, ((f.a)localObject).username, a.b.ThL, paramFloat), ((f.a)localObject).start, ((f.a)localObject).end, 17);
      }
    }
    AppMethodBeat.o(266475);
    return paramString1;
  }
  
  public final String a(ebd paramebd)
  {
    AppMethodBeat.i(266424);
    k.b localb = new k.b();
    com.tencent.mm.plugin.patmsg.a.a locala = new com.tencent.mm.plugin.patmsg.a.a();
    locala.MHl = paramebd;
    localb.a(locala);
    localb.type = 62;
    localb.title = MMApplicationContext.getContext().getString(d.f.low_version_upgrade_tip);
    localb.url = MMApplicationContext.getContext().getString(d.f.low_version_upgrade_url);
    paramebd = k.b.a(localb, null, null);
    AppMethodBeat.o(266424);
    return paramebd;
  }
  
  public final void a(Pair<Long, Long> paramPair, int paramInt)
  {
    AppMethodBeat.i(266478);
    Log.i("MicroMsg.PatMsgExtension", "do revoke local pat msg (%d,%d)", new Object[] { paramPair.first, paramPair.second });
    Object localObject1 = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sl(((Long)paramPair.first).longValue());
    if ((localObject1 != null) && (((fi)localObject1).field_msgId == ((Long)paramPair.first).longValue()))
    {
      localObject1 = g.bDK(((fi)localObject1).field_content);
      Object localObject2 = a((ebd)localObject1, ((Long)paramPair.second).longValue());
      if (localObject2 != null)
      {
        Object localObject3;
        if (((ebe)localObject2).vaU == 0L)
        {
          if ((this.MGX != null) && (this.MGX.MHt.equals(paramPair)))
          {
            Log.i("MicroMsg.PatMsgExtension", "do revoke unsent pat msg (%d,%d)", new Object[] { paramPair.first, paramPair.second });
            this.MHb.removeMessages(291, this.MGX);
            localObject2 = new mt();
            ((mt)localObject2).imW = this.MGX.scene;
            if (au.bwG(this.MGX.talker)) {
              ((mt)localObject2).vf(this.MGX.talker);
            }
            ((mt)localObject2).jcp = (((Long)paramPair.second).longValue() - ((com.tencent.mm.plugin.patmsg.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.patmsg.a.b.class)).b(((ebd)localObject1).ltm, paramPair));
            int i;
            if (a(this.MGX.talker, paramPair))
            {
              i = 1;
              ((mt)localObject2).jcr = i;
              ((mt)localObject2).jcs = (b((ebd)localObject1, ((Long)paramPair.second).longValue()) + 1);
              ((mt)localObject2).vd(z.bAM());
              ((mt)localObject2).ve(this.MGX.MHv);
              ((mt)localObject2).jaZ = this.MGX.createTime;
              ((mt)localObject2).vg(c.aRm(this.MGX.MHv));
              ((mt)localObject2).jbf = 1;
              ((mt)localObject2).jbe = paramInt;
              if (!this.MGX.MHw) {
                break label624;
              }
            }
            label624:
            for (paramInt = 1;; paramInt = 0)
            {
              ((mt)localObject2).jct = paramInt;
              a((mt)localObject2);
              ((mt)localObject2).bMH();
              localObject1 = com.tencent.mm.util.c.agsX;
              com.tencent.mm.util.c.a((com.tencent.mm.plugin.report.a)localObject2);
              Log.i("MicroMsg.PatMsgExtension", "delete unsent pat msg (%d,%d)", new Object[] { paramPair.first, paramPair.second });
              localObject1 = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sl(((Long)paramPair.first).longValue());
              if ((localObject1 == null) || (((fi)localObject1).field_msgId != ((Long)paramPair.first).longValue())) {
                break label677;
              }
              localObject2 = g.bDK(((fi)localObject1).field_content);
              Log.i("MicroMsg.PatMsgExtension", "before delete, pat record list size %d", new Object[] { Integer.valueOf(((ebd)localObject2).Ksg.size()) });
              localObject3 = a((ebd)localObject2, ((Long)paramPair.second).longValue());
              if (localObject3 == null) {
                break label677;
              }
              ((ebd)localObject2).Ksg.remove(localObject3);
              if (!((ebd)localObject2).Ksg.isEmpty()) {
                break label629;
              }
              ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sm(((Long)paramPair.first).longValue());
              AppMethodBeat.o(266478);
              return;
              i = 0;
              break;
            }
            label629:
            ((cc)localObject1).setContent(a((ebd)localObject2));
            ((cc)localObject1).setType(922746929);
            ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().a(((Long)paramPair.first).longValue(), (cc)localObject1);
            label677:
            AppMethodBeat.o(266478);
          }
        }
        else
        {
          Log.i("MicroMsg.PatMsgExtension", "do revoke sent pat msg %d, svrId %d", new Object[] { paramPair.first, Long.valueOf(((ebe)localObject2).vaU) });
          localObject3 = new com.tencent.mm.plugin.patmsg.b.a(d(paramPair), ((Long)paramPair.first).longValue(), ((ebe)localObject2).vaU, ((ebe)localObject2).createTime, ((ebd)localObject1).ltm);
          mc localmc = new mc();
          if ((this.MGX != null) && (this.MGX.MHt.equals(paramPair))) {
            localmc.imW = this.MGX.scene;
          }
          localmc.jaZ = ((ebe)localObject2).createTime;
          localmc.jba = System.currentTimeMillis();
          localmc.uJ(((ebe)localObject2).hQQ);
          localmc.uK(((ebe)localObject2).abgI);
          localmc.uL(c.aRm(((ebe)localObject2).abgI));
          if (au.bwG(((ebd)localObject1).ltm)) {
            localmc.uM(((ebd)localObject1).ltm);
          }
          localmc.jbe = paramInt;
          localmc.jbf = 1;
          ((com.tencent.mm.plugin.patmsg.b.a)localObject3).MHs = localmc;
          com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)localObject3, 0);
          if (com.tencent.mm.kernel.h.baE().ban().getBoolean(at.a.adgw, true))
          {
            com.tencent.mm.kernel.h.baE().ban().set(at.a.adgw, Boolean.FALSE);
            com.tencent.threadpool.h.ahAA.bm(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(266363);
                cc localcc = new cc();
                localcc.setContent(MMApplicationContext.getContext().getString(d.f.revoke_pat_old_version_tip));
                localcc.setType(10000);
                localcc.pI(0);
                localcc.BS(this.MHe.ltm);
                localcc.setCreateTime(System.currentTimeMillis());
                br.B(localcc);
                AppMethodBeat.o(266363);
              }
            });
          }
        }
      }
    }
    AppMethodBeat.o(266478);
  }
  
  public final ebd aRl(String paramString)
  {
    AppMethodBeat.i(266426);
    paramString = g.bDK(paramString);
    AppMethodBeat.o(266426);
    return paramString;
  }
  
  public final boolean aW(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(266473);
    Log.i("MicroMsg.PatMsgExtension", "delete svr pat msg (%d,%d)", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    cc localcc = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sl(paramLong1);
    ebd localebd;
    ebe localebe;
    if ((localcc != null) && (localcc.field_msgId == paramLong1) && (paramLong2 != 0L))
    {
      localebd = g.bDK(localcc.field_content);
      Log.i("MicroMsg.PatMsgExtension", "pat record list size %d", new Object[] { Integer.valueOf(localebd.Ksg.size()) });
      Iterator localIterator = localebd.Ksg.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localebe = (ebe)localIterator.next();
      } while (localebe.vaU != paramLong2);
    }
    for (;;)
    {
      if (localebe != null)
      {
        localebd.Ksg.remove(localebe);
        if (localebd.Ksg.isEmpty()) {
          ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sm(paramLong1);
        }
        for (;;)
        {
          AppMethodBeat.o(266473);
          return true;
          localcc.setContent(a(localebd));
          localcc.setType(922746929);
          ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().a(paramLong1, localcc);
        }
      }
      AppMethodBeat.o(266473);
      return false;
      localebe = null;
    }
  }
  
  public final int b(ebd paramebd, long paramLong)
  {
    AppMethodBeat.i(266460);
    int j = -1;
    int i = 0;
    while (i < paramebd.Ksg.size())
    {
      if (((ebe)paramebd.Ksg.get(i)).createTime == paramLong) {
        j = i;
      }
      i += 1;
    }
    AppMethodBeat.o(266460);
    return j;
  }
  
  public final long b(String paramString, Pair<Long, Long> paramPair)
  {
    AppMethodBeat.i(266464);
    paramString = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().i(paramString, ((Long)paramPair.second).longValue(), 1);
    if ((paramString != null) && (!paramString.isEmpty()) && (((cc)paramString.get(0)).field_msgId > 0L))
    {
      long l;
      if (((cc)paramString.get(0)).getType() == 922746929)
      {
        ebd localebd = g.bDK(((cc)paramString.get(0)).field_content);
        if (localebd.Ksg.size() == 0)
        {
          AppMethodBeat.o(266464);
          return 0L;
        }
        if (((Long)paramPair.first).longValue() == ((cc)paramString.get(0)).field_msgId)
        {
          int i = b(localebd, ((Long)paramPair.second).longValue());
          if (i > 1)
          {
            l = ((ebe)localebd.Ksg.get(i - 1)).createTime;
            AppMethodBeat.o(266464);
            return l;
          }
        }
        else
        {
          l = ((ebe)localebd.Ksg.getLast()).createTime;
          AppMethodBeat.o(266464);
          return l;
        }
      }
      else
      {
        l = ((cc)paramString.get(0)).getCreateTime();
        AppMethodBeat.o(266464);
        return l;
      }
    }
    AppMethodBeat.o(266464);
    return 0L;
  }
  
  public final CharSequence b(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(266438);
    Object localObject2 = new ebd();
    Object localObject1;
    if (paramInt1 == 889192497) {
      localObject1 = ((com.tencent.mm.plugin.patmsg.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.patmsg.a.b.class)).aRl(paramString1);
    }
    for (;;)
    {
      try
      {
        if (((ebd)localObject1).Ksg.size() > 0)
        {
          localObject1 = (ebe)((ebd)localObject1).Ksg.getLast();
          paramString1 = ((PluginPatMsg)com.tencent.mm.kernel.h.az(PluginPatMsg.class)).parseDisplayTemplate((ebe)localObject1, paramString2);
          paramString2 = new SpannableString(paramString1.result);
          if (paramString1.MHr.size() <= 0) {
            break;
          }
          localObject2 = paramString1.MHr.iterator();
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          f.a locala = (f.a)((Iterator)localObject2).next();
          paramString2.setSpan(((com.tencent.mm.plugin.textstatus.a.f)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.textstatus.a.f.class)).getTextStatusSpanSync(null, locala.username, a.b.ThL, paramInt2), locala.start, locala.end, 17);
          continue;
        }
        localObject1 = localObject2;
      }
      catch (Exception paramContext)
      {
        Log.printErrStackTrace("MicroMsg.PatMsgExtension", paramContext, "", new Object[0]);
        AppMethodBeat.o(266438);
        return "";
      }
      if (paramInt1 == 922746929)
      {
        paramString1 = k.b.Hf(paramString1);
        localObject1 = localObject2;
        if (paramString1 != null) {
          localObject1 = ((com.tencent.mm.plugin.patmsg.a.a)paramString1.aK(com.tencent.mm.plugin.patmsg.a.a.class)).MHl;
        }
      }
    }
    localObject2 = z.bAM();
    if ((!((ebe)localObject1).hQQ.equals(localObject2)) && (((ebe)localObject1).abgI.equals(localObject2)) && (((ebe)localObject1).abgJ == 0) && (!paramString1.MHq.isEmpty()))
    {
      localObject1 = new BoldForegroundColorSpan(paramContext.getResources().getColor(d.b.FG_0));
      localObject2 = paramContext.getString(d.f.pat_action_string);
      int j = paramString1.result.indexOf((String)localObject2, ((Integer)((Pair)paramString1.MHq.get(0)).second).intValue());
      int i = ((String)localObject2).length() + j;
      paramInt1 = i;
      if (i > paramString2.length()) {
        paramInt1 = paramString2.length();
      }
      paramString2.setSpan(localObject1, j, paramInt1, 17);
    }
    paramContext = com.tencent.mm.pluginsdk.ui.span.p.d(paramContext, paramString2, paramInt2);
    AppMethodBeat.o(266438);
    return paramContext;
  }
  
  public final void bo(String paramString, long paramLong)
  {
    AppMethodBeat.i(266480);
    Log.i("MicroMsg.PatMsgExtension", "do revoke svr pat msg %d from talker %s", new Object[] { Long.valueOf(paramLong), paramString });
    ebf localebf = ((PluginPatMsg)com.tencent.mm.kernel.h.az(PluginPatMsg.class)).getRecvRecord(paramLong);
    if (localebf != null)
    {
      long l = localebf.abgM;
      paramString = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().aU(paramString, l);
      if ((paramString != null) && (paramString.field_msgSvrId == l))
      {
        Log.i("MicroMsg.PatMsgExtension", "revoke pat msg %d,%d", new Object[] { Long.valueOf(paramString.field_msgId), Long.valueOf(paramLong) });
        aW(paramString.field_msgId, paramLong);
      }
    }
    AppMethodBeat.o(266480);
  }
  
  public final String d(Pair<Long, Long> paramPair)
  {
    AppMethodBeat.i(266481);
    paramPair = z.bAM() + "_" + paramPair.first + "_" + paramPair.second;
    AppMethodBeat.o(266481);
    return paramPair;
  }
  
  public final boolean e(Pair<Long, Long> paramPair)
  {
    AppMethodBeat.i(266483);
    if ((((PluginPatMsg)com.tencent.mm.kernel.h.az(PluginPatMsg.class)).isRevokePatMsgEnable()) && (this.MGX != null) && (this.MGX.MHt != null) && (this.MGX.MHt.equals(paramPair)) && ((int)(System.currentTimeMillis() - this.MGX.createTime) < MGZ))
    {
      Log.i("MicroMsg.PatMsgExtension", "try revoke last pat, msgId:%d, createTime:%d, scene:%d, talker:%s, patUser:%s", new Object[] { this.MGX.MHt.first, this.MGX.MHt.second, Integer.valueOf(this.MGX.scene), this.MGX.talker, this.MGX.MHv });
      cc localcc = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sl(((Long)this.MGX.MHt.first).longValue());
      if (localcc != null)
      {
        paramPair = a(g.bDK(localcc.field_content), ((Long)paramPair.second).longValue());
        if (paramPair != null)
        {
          boolean bool = this.MGX.MHv.equalsIgnoreCase(paramPair.abgI);
          AppMethodBeat.o(266483);
          return bool;
        }
      }
    }
    AppMethodBeat.o(266483);
    return false;
  }
  
  public final boolean kM(String paramString1, String paramString2)
  {
    AppMethodBeat.i(266448);
    if (((!au.bwG(paramString1)) && (!au.bwH(paramString1))) || (au.bww(paramString1)) || (ab.IW(paramString1)) || (au.bws(paramString1)) || (ab.IS(paramString1)))
    {
      Log.i("MicroMsg.PatMsgExtension", "cannot pat, talker %s", new Object[] { paramString1 });
      AppMethodBeat.o(266448);
      return false;
    }
    if ((!au.bwH(paramString2)) || (au.bww(paramString2)) || (ab.IW(paramString2)) || (au.bws(paramString2)) || (ab.IS(paramString2)))
    {
      Log.i("MicroMsg.PatMsgExtension", "cannot pat, user %s", new Object[] { paramString2 });
      AppMethodBeat.o(266448);
      return false;
    }
    if (au.bwG(paramString1))
    {
      List localList = v.Il(paramString1);
      if ((localList != null) && (!localList.contains(paramString2)))
      {
        Log.w("MicroMsg.PatMsgExtension", "chatroom %s members %s, not contain %s", new Object[] { paramString1, localList, paramString2 });
        AppMethodBeat.o(266448);
        return false;
      }
    }
    AppMethodBeat.o(266448);
    return true;
  }
  
  public final b.a kO(String paramString1, String paramString2)
  {
    AppMethodBeat.i(266486);
    b.a locala = new b.a();
    locala.MHm = ((com.tencent.mm.plugin.textstatus.a.f)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.textstatus.a.f.class)).getTextStatusId(paramString1);
    locala.MHn = ((com.tencent.mm.plugin.textstatus.a.f)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.textstatus.a.f.class)).getTextStatusIconId(paramString1);
    locala.MHo = ((com.tencent.mm.plugin.textstatus.a.f)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.textstatus.a.f.class)).getTextStatusId(paramString2);
    locala.MHp = ((com.tencent.mm.plugin.textstatus.a.f)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.textstatus.a.f.class)).getTextStatusIconId(paramString2);
    AppMethodBeat.o(266486);
    return locala;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(266472);
    Log.i("MicroMsg.PatMsgExtension", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    paramString = ((com.tencent.mm.plugin.patmsg.b.b)paramp).MHu;
    if (paramString != null) {
      paramString.inj = paramInt2;
    }
    int i = ((exr)c.b.b(((com.tencent.mm.plugin.patmsg.b.b)paramp).oDw.otB)).IJG;
    Log.i("MicroMsg.PatMsgExtension", "onSceneEnd, pat scene %d", new Object[] { Integer.valueOf(i) });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      if (i == 1)
      {
        AppMethodBeat.o(266472);
        return;
      }
      Toast.makeText(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(d.f.app_err_system_busy_tip) + "(" + paramInt1 + "," + paramInt2 + ")", 0).show();
      paramp = ((com.tencent.mm.plugin.patmsg.b.b)paramp).aJK();
      if ((paramInt2 != -22) && (paramInt2 != -44)) {
        com.tencent.threadpool.h.ahAA.bm(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(266362);
            cc localcc = new cc();
            localcc.setContent(MMApplicationContext.getContext().getString(d.f.send_pat_msg_failed));
            localcc.setType(10000);
            localcc.pI(0);
            localcc.BS(paramp);
            localcc.setCreateTime(System.currentTimeMillis());
            Log.i("MicroMsg.PatMsgExtension", "insert pat failed msg %d", new Object[] { Long.valueOf(br.B(localcc)) });
            AppMethodBeat.o(266362);
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
        a(paramString);
        paramString.bMH();
        paramp = com.tencent.mm.util.c.agsX;
        com.tencent.mm.util.c.a(paramString);
      }
      AppMethodBeat.o(266472);
      return;
      localObject1 = ((com.tencent.mm.plugin.patmsg.b.b)paramp).MHt;
      str = ((exr)c.b.b(((com.tencent.mm.plugin.patmsg.b.b)paramp).oDw.otB)).abzr;
      if (i != 1) {
        break;
      }
      localObject2 = Util.nullAsNil(((exs)c.c.b(((com.tencent.mm.plugin.patmsg.b.b)paramp).oDw.otC)).aaWy);
    } while (Util.isNullOrNil(str));
    c.kP(str, (String)localObject2);
    Object localObject3;
    ebe localebe;
    if (((Long)((Pair)localObject1).first).longValue() > 0L)
    {
      localObject3 = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sl(((Long)((Pair)localObject1).first).longValue());
      if ((localObject3 != null) && (((fi)localObject3).field_msgId == ((Long)((Pair)localObject1).first).longValue()))
      {
        ebd localebd = g.bDK(((fi)localObject3).field_content);
        localebe = a(localebd, ((Long)((Pair)localObject1).second).longValue());
        if (localebe != null)
        {
          if (!str.equalsIgnoreCase(localebe.abgI)) {
            break label780;
          }
          localebe.nVS = kN(str, ((com.tencent.mm.plugin.patmsg.b.b)paramp).aJK());
          ((cc)localObject3).setContent(a(localebd));
          ((cc)localObject3).setType(922746929);
          ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().a(((Long)((Pair)localObject1).first).longValue(), (cc)localObject3);
          Log.i("MicroMsg.PatMsgExtension", "update pat msg suffix %d, createTime %d", new Object[] { ((Pair)localObject1).first, ((Pair)localObject1).second });
        }
      }
    }
    for (;;)
    {
      if ((!Util.isNullOrNil((String)localObject2)) && (Util.isNullOrNil((String)com.tencent.mm.kernel.h.baE().ban().get(at.a.adgr, null))) && (com.tencent.mm.kernel.h.baE().ban().getBoolean(at.a.adgy, true)))
      {
        com.tencent.mm.kernel.h.baE().ban().set(at.a.adgy, Boolean.FALSE);
        paramp = ((fi)localObject3).field_talker;
        localObject1 = String.format(MMApplicationContext.getContext().getResources().getString(d.f.pat_set_tail_intro), new Object[] { "<_wc_custom_link_ href='weixin://jump/setpat/'>", "</_wc_custom_link_>" });
        localObject3 = new cc();
        ((cc)localObject3).pI(0);
        ((cc)localObject3).BS(paramp);
        ((cc)localObject3).setStatus(3);
        ((cc)localObject3).setContent((String)localObject1);
        ((cc)localObject3).setCreateTime(br.D(paramp, System.currentTimeMillis() / 1000L));
        ((cc)localObject3).setType(10000);
        ((cc)localObject3).setFlag(((fi)localObject3).field_flag);
        br.B((cc)localObject3);
        if (this.MGX != null) {
          this.MGX.MHw = true;
        }
      }
      paramp = new rq();
      paramp.hUG.hUH = str;
      paramp.hUG.hUI = ((String)localObject2);
      paramp.hUG.hUJ = i;
      paramp.publish();
      break;
      label780:
      Log.w("MicroMsg.PatMsgExtension", "update pat msg suffix %d, pattedUser (%s,%s) not match", new Object[] { ((Pair)localObject1).first, str, localebe.abgI });
    }
    Object localObject2 = XmlParser.parseXml(((exs)c.c.b(((com.tencent.mm.plugin.patmsg.b.b)paramp).oDw.otC)).abzs, "sysmsg", null);
    if (localObject2 != null) {}
    for (paramInt1 = Util.safeParseInt((String)((Map)localObject2).get(".sysmsg.pat.patsuffixversion"));; paramInt1 = 0)
    {
      c.gu(str, paramInt1);
      long l = ((exs)c.c.b(((com.tencent.mm.plugin.patmsg.b.b)paramp).oDw.otC)).YKx;
      if ((l == 0L) || (((Long)((Pair)localObject1).first).longValue() <= 0L)) {
        break;
      }
      paramp = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sl(((Long)((Pair)localObject1).first).longValue());
      Log.i("MicroMsg.PatMsgExtension", "update pat msg %d, svrId %d", new Object[] { ((Pair)localObject1).first, Long.valueOf(l) });
      if ((paramp == null) || (paramp.field_msgId != ((Long)((Pair)localObject1).first).longValue())) {
        break;
      }
      localObject2 = g.bDK(paramp.field_content);
      localObject3 = a((ebd)localObject2, ((Long)((Pair)localObject1).second).longValue());
      if (localObject3 == null) {
        break;
      }
      if (str.equalsIgnoreCase(((ebe)localObject3).abgI))
      {
        ((ebe)localObject3).vaU = l;
        if (paramp.field_msgSvrId == 0L) {
          paramp.gX(l);
        }
        paramp.setContent(a((ebd)localObject2));
        paramp.setType(922746929);
        ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().a(((Long)((Pair)localObject1).first).longValue(), paramp);
        Log.i("MicroMsg.PatMsgExtension", "update pat msg svrId %d, createTime %d", new Object[] { ((Pair)localObject1).first, ((Pair)localObject1).second });
        break;
      }
      Log.w("MicroMsg.PatMsgExtension", "update pat msg svrId %d, pattedUser (%s,%s) not match", new Object[] { ((Pair)localObject1).first, str, ((ebe)localObject3).abgI });
      break;
    }
  }
  
  public final boolean ta(long paramLong)
  {
    AppMethodBeat.i(266442);
    if (this.MGW.contains(Long.valueOf(paramLong)))
    {
      AppMethodBeat.o(266442);
      return true;
    }
    Object localObject = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sl(paramLong);
    if ((localObject != null) && (((fi)localObject).field_msgId > 0L))
    {
      localObject = g.bDK(((fi)localObject).field_content).Ksg.iterator();
      int i = 1;
      if (((Iterator)localObject).hasNext())
      {
        if (((ebe)((Iterator)localObject).next()).abgJ == 1) {}
        for (int j = 1;; j = 0)
        {
          i = j & i;
          break;
        }
      }
      if (i != 0)
      {
        this.MGW.add(Long.valueOf(paramLong));
        AppMethodBeat.o(266442);
        return true;
      }
    }
    AppMethodBeat.o(266442);
    return false;
  }
  
  public final List<cc> tb(long paramLong)
  {
    AppMethodBeat.i(266485);
    Object localObject1 = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sl(paramLong);
    if ((localObject1 != null) && (((cc)localObject1).getType() == 922746929))
    {
      ArrayList localArrayList = new ArrayList();
      localObject1 = g.bDK(((fi)localObject1).field_content);
      if (((ebd)localObject1).Ksg == null) {}
      for (int i = 0;; i = ((ebd)localObject1).Ksg.size())
      {
        Log.i("MicroMsg.PatMsgExtension", "split pat msg [%d] to %d child msg", new Object[] { Long.valueOf(paramLong), Integer.valueOf(i) });
        Iterator localIterator = ((ebd)localObject1).Ksg.iterator();
        while (localIterator.hasNext())
        {
          ebe localebe = (ebe)localIterator.next();
          cc localcc = new cc();
          ebd localebd = new ebd();
          localebd.ltm = ((ebd)localObject1).ltm;
          Object localObject2 = new com.tencent.mm.util.g.a();
          ((com.tencent.mm.util.g.a)localObject2).nVS = localebe.nVS;
          ((com.tencent.mm.util.g.a)localObject2).agts = localebe.nVS;
          ((com.tencent.mm.util.g.a)localObject2).createTime = localebe.createTime;
          ((com.tencent.mm.util.g.a)localObject2).hQQ = localebe.hQQ;
          ((com.tencent.mm.util.g.a)localObject2).abgI = localebe.abgI;
          ((com.tencent.mm.util.g.a)localObject2).vaU = localebe.vaU;
          localebd.Ksg.add(localObject2);
          localObject2 = new k.b();
          com.tencent.mm.plugin.patmsg.a.a locala = new com.tencent.mm.plugin.patmsg.a.a();
          locala.MHl = localebd;
          ((k.b)localObject2).a(locala);
          ((k.b)localObject2).type = 62;
          ((k.b)localObject2).title = MMApplicationContext.getContext().getString(d.f.low_version_upgrade_tip);
          ((k.b)localObject2).url = MMApplicationContext.getContext().getString(d.f.low_version_upgrade_url);
          localcc.setContent(k.b.a((k.b)localObject2, "", null));
          localcc.setType(922746929);
          localcc.pI(0);
          localcc.BS(((ebd)localObject1).ltm);
          localcc.gX(localebe.vaU);
          localcc.setCreateTime(localebe.createTime);
          localArrayList.add(localcc);
        }
      }
      AppMethodBeat.o(266485);
      return localArrayList;
    }
    AppMethodBeat.o(266485);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.patmsg.a
 * JD-Core Version:    0.7.0.1
 */