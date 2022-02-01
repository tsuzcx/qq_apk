package com.tencent.mm.plugin.voip.model;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.zj;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bp;
import com.tencent.mm.n.d;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.voip.b.m;
import com.tencent.mm.plugin.voip.ui.InviteRemindDialog;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ca;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class s
{
  private static boolean GYM;
  private static DialogInterface.OnClickListener GYN;
  
  static
  {
    AppMethodBeat.i(115100);
    GYM = false;
    GYN = new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(235663);
        s.access$000();
        AppMethodBeat.o(235663);
      }
    };
    AppMethodBeat.o(115100);
  }
  
  public static long a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(115091);
    ca localca = new ca();
    localca.setCreateTime(bp.Kw(paramString1));
    localca.nv(paramInt1);
    localca.setType(50);
    localca.Cy(paramString1);
    localca.BB(paramString3);
    localca.setContent(paramString2);
    localca.setStatus(paramInt2);
    if (paramBoolean) {
      localca.gDH();
    }
    long l = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().aC(localca);
    if (l < 0L) {
      Log.e("MicroMsg.VoipPluginManager", "inset voip  failed!");
    }
    Log.d("MicroMsg.VoipPluginManager", "inset voip  msgId ".concat(String.valueOf(l)));
    AppMethodBeat.o(115091);
    return l;
  }
  
  public static void bH(Context paramContext, String paramString)
  {
    AppMethodBeat.i(115094);
    paramContext.getResources().getString(2131767233);
    GYM = false;
    try
    {
      if (((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().aEz(paramString) != null) {
        GYM = m.fKF();
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
      int i = g.azz().aYS();
      Log.d("MicroMsg.VoipPluginManager", "startVoipVideoCall getNowStatus ".concat(String.valueOf(i)));
      if ((i != 4) && (i != 6))
      {
        com.tencent.mm.plugin.report.service.h.CyF.a(11518, true, true, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.GVV.roomId), Long.valueOf(com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.GVV.ypH), Long.valueOf(com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.fGu()), Integer.valueOf(4), Integer.valueOf(0) });
        com.tencent.mm.ui.base.h.a(paramContext, 2131767334, 2131767338, GYN);
        AppMethodBeat.o(115094);
        return;
      }
      if (!GYM)
      {
        Object localObject3;
        i.a locala;
        try
        {
          Object localObject1 = i.a.aUx((String)g.aAh().azQ().get(77829, null));
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
              g.aAh().azQ().set(77829, i.a.aV((Map)localObject1));
              localObject1 = ((Map)localObject1).entrySet().iterator();
              while (((Iterator)localObject1).hasNext())
              {
                localObject3 = (Map.Entry)((Iterator)localObject1).next();
                locala = (i.a)((Map.Entry)localObject3).getValue();
                Log.d("MicroMsg.VoipPluginManager", "val1 " + locala.hitCount + " " + locala.jgU + "name " + (String)((Map.Entry)localObject3).getKey());
              }
              InviteRemindDialog.o(paramContext, paramString, 0);
            }
          }
        }
        catch (Exception localException2)
        {
          Log.printErrStackTrace("MicroMsg.VoipPluginManager", localException2, "", new Object[0]);
        }
        for (;;)
        {
          fHt();
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
          g.aAh().azQ().set(77829, i.a.aV((Map)localObject2));
          localObject2 = ((Map)localObject2).entrySet().iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (Map.Entry)((Iterator)localObject2).next();
            locala = (i.a)((Map.Entry)localObject3).getValue();
            Log.d("MicroMsg.VoipPluginManager", "val2 " + locala.hitCount + " " + locala.jgU + "  name " + (String)((Map.Entry)localObject3).getKey());
          }
        }
      }
      if ((NetStatusUtil.isWifi(paramContext)) || (fHs()))
      {
        com.tencent.mm.plugin.voip.c.fFg().bM(paramContext, paramString);
        AppMethodBeat.o(115094);
        return;
      }
      com.tencent.mm.plugin.voip.c.fFg().bM(paramContext, paramString);
      AppMethodBeat.o(115094);
    }
  }
  
  public static void bI(Context paramContext, String paramString)
  {
    AppMethodBeat.i(115096);
    com.tencent.mm.n.h.aqK();
    int i;
    if (d.aqw() == 2) {
      i = 1;
    }
    for (;;)
    {
      com.tencent.mm.br.c.gsX();
      if (i == 0) {
        Log.i("MicroMsg.VoipPluginManager", "showDouble %b, isLiteVersion: %b", new Object[] { Boolean.FALSE, Boolean.FALSE });
      }
      GYM = false;
      try
      {
        if (((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().aEz(paramString) != null) {
          GYM = m.fKF();
        }
        bK(paramContext, paramString);
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
  
  public static void bJ(Context paramContext, String paramString)
  {
    AppMethodBeat.i(115097);
    GYM = false;
    try
    {
      if (((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().aEz(paramString) != null) {
        GYM = m.fKF();
      }
      bK(paramContext, paramString);
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
  
  private static void bK(Context paramContext, String paramString)
  {
    AppMethodBeat.i(115098);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.VoipPluginManager", "talker is null");
      AppMethodBeat.o(115098);
      return;
    }
    int i = g.azz().aYS();
    Log.d("MicroMsg.VoipPluginManager", "startVoipVideoCall getNowStatus ".concat(String.valueOf(i)));
    if ((i != 4) && (i != 6))
    {
      com.tencent.mm.plugin.report.service.h.CyF.a(11518, true, true, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.GVV.roomId), Long.valueOf(com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.GVV.ypH), Long.valueOf(com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.fGu()), Integer.valueOf(4), Integer.valueOf(0) });
      com.tencent.mm.ui.base.h.a(paramContext, 2131767334, 2131767338, GYN);
      AppMethodBeat.o(115098);
      return;
    }
    if (!GYM)
    {
      Object localObject3;
      i.a locala;
      try
      {
        Object localObject1 = i.a.aUx((String)g.aAh().azQ().get(77829, null));
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
            g.aAh().azQ().set(77829, i.a.aV((Map)localObject1));
            localObject1 = ((Map)localObject1).entrySet().iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject3 = (Map.Entry)((Iterator)localObject1).next();
              locala = (i.a)((Map.Entry)localObject3).getValue();
              Log.d("MicroMsg.VoipPluginManager", "val1 " + locala.hitCount + " " + locala.jgU + "name " + (String)((Map.Entry)localObject3).getKey());
            }
            InviteRemindDialog.o(paramContext, paramString, 1);
          }
        }
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.VoipPluginManager", localException, "", new Object[0]);
      }
      for (;;)
      {
        fHt();
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
        g.aAh().azQ().set(77829, i.a.aV((Map)localObject2));
        localObject2 = ((Map)localObject2).entrySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (Map.Entry)((Iterator)localObject2).next();
          locala = (i.a)((Map.Entry)localObject3).getValue();
          Log.d("MicroMsg.VoipPluginManager", "val2 " + locala.hitCount + " " + locala.jgU + "  name " + (String)((Map.Entry)localObject3).getKey());
        }
      }
    }
    if ((NetStatusUtil.isWifi(paramContext)) || (fHs()))
    {
      com.tencent.mm.plugin.voip.c.fFg().bL(paramContext, paramString);
      AppMethodBeat.o(115098);
      return;
    }
    com.tencent.mm.plugin.voip.c.fFg().bL(paramContext, paramString);
    AppMethodBeat.o(115098);
  }
  
  public static long c(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3)
  {
    AppMethodBeat.i(115090);
    long l = a(paramString1, paramString2, paramInt1, paramInt2, paramString3, false);
    AppMethodBeat.o(115090);
    return l;
  }
  
  public static void fHr()
  {
    AppMethodBeat.i(115092);
    g.aAh().azQ().set(20480, Long.valueOf(System.currentTimeMillis()));
    AppMethodBeat.o(115092);
  }
  
  public static boolean fHs()
  {
    AppMethodBeat.i(115093);
    try
    {
      long l1 = System.currentTimeMillis();
      long l2 = ((Long)g.aAh().azQ().get(20480, Integer.valueOf(-1))).longValue();
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
  
  private static void fHt()
  {
    AppMethodBeat.i(115095);
    zj localzj = new zj();
    localzj.efx.dKy = 8;
    EventCenter.instance.publish(localzj);
    AppMethodBeat.o(115095);
  }
  
  public static void hA(Context paramContext)
  {
    AppMethodBeat.i(235664);
    if (!NetStatusUtil.isWifi(paramContext)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        com.tencent.mm.ui.base.u.cF(paramContext, paramContext.getResources().getText(2131767252).toString());
      }
      AppMethodBeat.o(235664);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.s
 * JD-Core Version:    0.7.0.1
 */