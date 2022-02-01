package com.tencent.mm.plugin.voip.model;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.aaq;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.bq;
import com.tencent.mm.n.d;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.voip.b.g;
import com.tencent.mm.plugin.voip.c.m;
import com.tencent.mm.plugin.voip.ui.InviteRemindDialog;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.w;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class s
{
  private static boolean NOZ;
  private static DialogInterface.OnClickListener NPa;
  
  static
  {
    AppMethodBeat.i(115100);
    NOZ = false;
    NPa = new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(233920);
        s.access$000();
        AppMethodBeat.o(233920);
      }
    };
    AppMethodBeat.o(115100);
  }
  
  public static long a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(115091);
    ca localca = new ca();
    localca.setCreateTime(bq.RP(paramString1));
    localca.pJ(paramInt1);
    localca.setType(50);
    localca.Jm(paramString1);
    localca.Ip(paramString3);
    localca.setContent(paramString2);
    localca.setStatus(paramInt2);
    if (paramBoolean) {
      localca.hzV();
    }
    long l = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aM(localca);
    if (l < 0L) {
      Log.e("MicroMsg.VoipPluginManager", "inset voip  failed!");
    }
    Log.d("MicroMsg.VoipPluginManager", "inset voip  msgId ".concat(String.valueOf(l)));
    AppMethodBeat.o(115091);
    return l;
  }
  
  public static long b(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3)
  {
    AppMethodBeat.i(115090);
    long l = a(paramString1, paramString2, paramInt1, paramInt2, paramString3, false);
    AppMethodBeat.o(115090);
    return l;
  }
  
  public static void bS(Context paramContext, String paramString)
  {
    AppMethodBeat.i(115094);
    paramContext.getResources().getString(b.g.voip_call);
    NOZ = false;
    try
    {
      if (((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aOJ(paramString) != null) {
        NOZ = m.gDf();
      }
      if (Util.isNullOrNil(paramString))
      {
        Log.e("MicroMsg.VoipPluginManager", "talker is null");
        AppMethodBeat.o(115094);
        return;
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.VoipPluginManager", localException1, "", new Object[0]);
      }
      int i = com.tencent.mm.kernel.h.aGY().bih();
      Log.d("MicroMsg.VoipPluginManager", "startVoipVideoCall getNowStatus ".concat(String.valueOf(i)));
      if ((i != 4) && (i != 6))
      {
        com.tencent.mm.plugin.report.service.h.IzE.a(11518, true, true, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.c.gxs().NPf.NJk.NMi.roomId), Long.valueOf(com.tencent.mm.plugin.voip.c.gxs().NPf.NJk.NMi.DPJ), Long.valueOf(com.tencent.mm.plugin.voip.c.gxs().NPf.NJk.gyI()), Integer.valueOf(4), Integer.valueOf(0) });
        com.tencent.mm.ui.base.h.a(paramContext, b.g.voip_net_unavailable, b.g.voip_not_wifi_warnning_title, NPa);
        AppMethodBeat.o(115094);
        return;
      }
      if (!NOZ)
      {
        Object localObject3;
        i.a locala;
        try
        {
          Object localObject1 = i.a.bgc((String)com.tencent.mm.kernel.h.aHG().aHp().b(77829, null));
          if (localObject1 != null) {
            if ((localObject1 != null) && (((Map)localObject1).size() > 0))
            {
              if (((Map)localObject1).containsKey(paramString))
              {
                localObject3 = (i.a)((Map)localObject1).get(paramString);
                ((i.a)localObject3).hitCount += 1;
                ((Map)localObject1).put(paramString, localObject3);
              }
            }
            else
            {
              com.tencent.mm.kernel.h.aHG().aHp().i(77829, i.a.aP((Map)localObject1));
              localObject1 = ((Map)localObject1).entrySet().iterator();
              while (((Iterator)localObject1).hasNext())
              {
                localObject3 = (Map.Entry)((Iterator)localObject1).next();
                locala = (i.a)((Map.Entry)localObject3).getValue();
                Log.d("MicroMsg.VoipPluginManager", "val1 " + locala.hitCount + " " + locala.lXw + "name " + (String)((Map.Entry)localObject3).getKey());
              }
              InviteRemindDialog.q(paramContext, paramString, 0);
            }
          }
        }
        catch (Exception localException2)
        {
          Log.printErrStackTrace("MicroMsg.VoipPluginManager", localException2, "", new Object[0]);
        }
        for (;;)
        {
          gzH();
          AppMethodBeat.o(115094);
          return;
          localObject3 = new i.a();
          ((i.a)localObject3).hitCount += 1;
          localException2.put(paramString, localObject3);
          break;
          Object localObject2 = new HashMap();
          localObject3 = new i.a();
          ((i.a)localObject3).hitCount += 1;
          ((Map)localObject2).put(paramString, localObject3);
          com.tencent.mm.kernel.h.aHG().aHp().i(77829, i.a.aP((Map)localObject2));
          localObject2 = ((Map)localObject2).entrySet().iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (Map.Entry)((Iterator)localObject2).next();
            locala = (i.a)((Map.Entry)localObject3).getValue();
            Log.d("MicroMsg.VoipPluginManager", "val2 " + locala.hitCount + " " + locala.lXw + "  name " + (String)((Map.Entry)localObject3).getKey());
          }
        }
      }
      if ((NetStatusUtil.isWifi(paramContext)) || (gzG()))
      {
        com.tencent.mm.plugin.voip.c.gxs().bX(paramContext, paramString);
        AppMethodBeat.o(115094);
        return;
      }
      com.tencent.mm.plugin.voip.c.gxs().bX(paramContext, paramString);
      AppMethodBeat.o(115094);
    }
  }
  
  public static void bT(Context paramContext, String paramString)
  {
    AppMethodBeat.i(115096);
    com.tencent.mm.n.h.axd();
    int i;
    if (d.awQ() == 2) {
      i = 1;
    }
    for (;;)
    {
      com.tencent.mm.by.c.hok();
      if (i == 0) {
        Log.i("MicroMsg.VoipPluginManager", "showDouble %b, isLiteVersion: %b", new Object[] { Boolean.FALSE, Boolean.FALSE });
      }
      NOZ = false;
      try
      {
        if (((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aOJ(paramString) != null) {
          NOZ = m.gDf();
        }
        bV(paramContext, paramString);
        AppMethodBeat.o(115096);
        return;
        i = 0;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.VoipPluginManager", localException, "", new Object[0]);
        }
      }
    }
  }
  
  public static void bU(Context paramContext, String paramString)
  {
    AppMethodBeat.i(115097);
    NOZ = false;
    try
    {
      if (((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aOJ(paramString) != null) {
        NOZ = m.gDf();
      }
      bV(paramContext, paramString);
      AppMethodBeat.o(115097);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.VoipPluginManager", localException, "", new Object[0]);
      }
    }
  }
  
  private static void bV(Context paramContext, String paramString)
  {
    AppMethodBeat.i(115098);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.VoipPluginManager", "talker is null");
      AppMethodBeat.o(115098);
      return;
    }
    int i = com.tencent.mm.kernel.h.aGY().bih();
    Log.d("MicroMsg.VoipPluginManager", "startVoipVideoCall getNowStatus ".concat(String.valueOf(i)));
    if ((i != 4) && (i != 6))
    {
      com.tencent.mm.plugin.report.service.h.IzE.a(11518, true, true, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.c.gxs().NPf.NJk.NMi.roomId), Long.valueOf(com.tencent.mm.plugin.voip.c.gxs().NPf.NJk.NMi.DPJ), Long.valueOf(com.tencent.mm.plugin.voip.c.gxs().NPf.NJk.gyI()), Integer.valueOf(4), Integer.valueOf(0) });
      com.tencent.mm.ui.base.h.a(paramContext, b.g.voip_net_unavailable, b.g.voip_not_wifi_warnning_title, NPa);
      AppMethodBeat.o(115098);
      return;
    }
    if (!NOZ)
    {
      Object localObject3;
      i.a locala;
      try
      {
        Object localObject1 = i.a.bgc((String)com.tencent.mm.kernel.h.aHG().aHp().b(77829, null));
        if (localObject1 != null) {
          if ((localObject1 != null) && (((Map)localObject1).size() > 0))
          {
            if (((Map)localObject1).containsKey(paramString))
            {
              localObject3 = (i.a)((Map)localObject1).get(paramString);
              ((i.a)localObject3).hitCount += 1;
              ((Map)localObject1).put(paramString, localObject3);
            }
          }
          else
          {
            com.tencent.mm.kernel.h.aHG().aHp().i(77829, i.a.aP((Map)localObject1));
            localObject1 = ((Map)localObject1).entrySet().iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject3 = (Map.Entry)((Iterator)localObject1).next();
              locala = (i.a)((Map.Entry)localObject3).getValue();
              Log.d("MicroMsg.VoipPluginManager", "val1 " + locala.hitCount + " " + locala.lXw + "name " + (String)((Map.Entry)localObject3).getKey());
            }
            InviteRemindDialog.q(paramContext, paramString, 1);
          }
        }
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.VoipPluginManager", localException, "", new Object[0]);
      }
      for (;;)
      {
        gzH();
        AppMethodBeat.o(115098);
        return;
        localObject3 = new i.a();
        ((i.a)localObject3).hitCount += 1;
        localException.put(paramString, localObject3);
        break;
        Object localObject2 = new HashMap();
        localObject3 = new i.a();
        ((i.a)localObject3).hitCount += 1;
        ((Map)localObject2).put(paramString, localObject3);
        com.tencent.mm.kernel.h.aHG().aHp().i(77829, i.a.aP((Map)localObject2));
        localObject2 = ((Map)localObject2).entrySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (Map.Entry)((Iterator)localObject2).next();
          locala = (i.a)((Map.Entry)localObject3).getValue();
          Log.d("MicroMsg.VoipPluginManager", "val2 " + locala.hitCount + " " + locala.lXw + "  name " + (String)((Map.Entry)localObject3).getKey());
        }
      }
    }
    if ((NetStatusUtil.isWifi(paramContext)) || (gzG()))
    {
      com.tencent.mm.plugin.voip.c.gxs().bW(paramContext, paramString);
      AppMethodBeat.o(115098);
      return;
    }
    com.tencent.mm.plugin.voip.c.gxs().bW(paramContext, paramString);
    AppMethodBeat.o(115098);
  }
  
  public static void gzF()
  {
    AppMethodBeat.i(115092);
    com.tencent.mm.kernel.h.aHG().aHp().i(20480, Long.valueOf(System.currentTimeMillis()));
    AppMethodBeat.o(115092);
  }
  
  public static boolean gzG()
  {
    AppMethodBeat.i(115093);
    try
    {
      long l1 = System.currentTimeMillis();
      long l2 = ((Long)com.tencent.mm.kernel.h.aHG().aHp().b(20480, Integer.valueOf(-1))).longValue();
      if (l2 < 0L)
      {
        AppMethodBeat.o(115093);
        return false;
      }
      l1 -= l2;
      Log.d("MicroMsg.VoipPluginManager", "diff is".concat(String.valueOf(l1)));
      if (l1 < 21600000L)
      {
        AppMethodBeat.o(115093);
        return true;
      }
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(115093);
    }
    return false;
  }
  
  private static void gzH()
  {
    AppMethodBeat.i(115095);
    aaq localaaq = new aaq();
    localaaq.fZM.fDn = 8;
    EventCenter.instance.publish(localaaq);
    AppMethodBeat.o(115095);
  }
  
  public static void iF(Context paramContext)
  {
    AppMethodBeat.i(235335);
    if ((!NetStatusUtil.isWifi(paramContext)) && (!com.tencent.mm.plugin.voip.c.gxs().NPj)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        com.tencent.mm.plugin.voip.c.gxs().NPk = true;
        w.cQ(paramContext, paramContext.getResources().getText(b.g.voip_cellular_cost_tip).toString());
      }
      AppMethodBeat.o(235335);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.s
 * JD-Core Version:    0.7.0.1
 */