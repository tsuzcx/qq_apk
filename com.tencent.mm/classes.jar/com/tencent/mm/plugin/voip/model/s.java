package com.tencent.mm.plugin.voip.model;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.a.yb;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.bj;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.voip.b.n;
import com.tencent.mm.plugin.voip.ui.InviteRemindDialog;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.base.h;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class s
{
  private static DialogInterface.OnClickListener CdA;
  private static boolean Cdz;
  
  static
  {
    AppMethodBeat.i(115100);
    Cdz = false;
    CdA = new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(115089);
        s.access$000();
        AppMethodBeat.o(115089);
      }
    };
    AppMethodBeat.o(115100);
  }
  
  public static long a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(115091);
    bu localbu = new bu();
    localbu.qA(bj.Bo(paramString1));
    localbu.kr(paramInt1);
    localbu.setType(50);
    localbu.tN(paramString1);
    localbu.sP(paramString3);
    localbu.setContent(paramString2);
    localbu.setStatus(paramInt2);
    if (paramBoolean) {
      localbu.fsa();
    }
    long l = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().as(localbu);
    if (l < 0L) {
      ad.e("MicroMsg.VoipPluginManager", "inset voip  failed!");
    }
    ad.d("MicroMsg.VoipPluginManager", "inset voip  msgId ".concat(String.valueOf(l)));
    AppMethodBeat.o(115091);
    return l;
  }
  
  public static void bm(Context paramContext, final String paramString)
  {
    AppMethodBeat.i(115094);
    paramContext.getResources().getString(2131764795);
    Cdz = false;
    try
    {
      if (((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().apZ(paramString) != null) {
        Cdz = n.eAc();
      }
      if (bt.isNullOrNil(paramString))
      {
        ad.e("MicroMsg.VoipPluginManager", "talker is null");
        AppMethodBeat.o(115094);
        return;
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.VoipPluginManager", localException1, "", new Object[0]);
      }
      int i = com.tencent.mm.kernel.g.aiU().aEN();
      ad.d("MicroMsg.VoipPluginManager", "startVoipVideoCall getNowStatus ".concat(String.valueOf(i)));
      if ((i != 4) && (i != 6))
      {
        com.tencent.mm.plugin.report.service.g.yhR.a(11518, true, true, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.c.euM().CdF.BXC.CaI.roomId), Long.valueOf(com.tencent.mm.plugin.voip.c.euM().CdF.BXC.CaI.uLt), Long.valueOf(com.tencent.mm.plugin.voip.c.euM().CdF.BXC.evX()), Integer.valueOf(4), Integer.valueOf(0) });
        h.a(paramContext, 2131764895, 2131764899, CdA);
        AppMethodBeat.o(115094);
        return;
      }
      if (!Cdz)
      {
        Object localObject3;
        i.a locala;
        try
        {
          Object localObject1 = i.a.aDE((String)com.tencent.mm.kernel.g.ajC().ajl().get(77829, null));
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
              com.tencent.mm.kernel.g.ajC().ajl().set(77829, i.a.aQ((Map)localObject1));
              localObject1 = ((Map)localObject1).entrySet().iterator();
              while (((Iterator)localObject1).hasNext())
              {
                localObject3 = (Map.Entry)((Iterator)localObject1).next();
                locala = (i.a)((Map.Entry)localObject3).getValue();
                ad.d("MicroMsg.VoipPluginManager", "val1 " + locala.hitCount + " " + locala.iiY + "name " + (String)((Map.Entry)localObject3).getKey());
              }
              InviteRemindDialog.p(paramContext, paramString, 0);
            }
          }
        }
        catch (Exception localException2)
        {
          ad.printErrStackTrace("MicroMsg.VoipPluginManager", localException2, "", new Object[0]);
        }
        for (;;)
        {
          ewV();
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
          com.tencent.mm.kernel.g.ajC().ajl().set(77829, i.a.aQ((Map)localObject2));
          localObject2 = ((Map)localObject2).entrySet().iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (Map.Entry)((Iterator)localObject2).next();
            locala = (i.a)((Map.Entry)localObject3).getValue();
            ad.d("MicroMsg.VoipPluginManager", "val2 " + locala.hitCount + " " + locala.iiY + "  name " + (String)((Map.Entry)localObject3).getKey());
          }
        }
      }
      if ((ay.isWifi(paramContext)) || (ewU()))
      {
        com.tencent.mm.plugin.voip.c.euM().br(paramContext, paramString);
        AppMethodBeat.o(115094);
        return;
      }
      h.a(paramContext, 2131764898, 2131764899, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(115088);
          s.ewT();
          com.tencent.mm.plugin.voip.c.euM().br(this.val$context, paramString);
          AppMethodBeat.o(115088);
        }
      }, CdA);
      AppMethodBeat.o(115094);
    }
  }
  
  public static void bn(Context paramContext, String paramString)
  {
    AppMethodBeat.i(115096);
    com.tencent.mm.n.g.acB();
    int i;
    if (com.tencent.mm.n.c.acm() == 2) {
      i = 1;
    }
    for (;;)
    {
      d.ffH();
      if (i == 0) {
        ad.i("MicroMsg.VoipPluginManager", "showDouble %b, isLiteVersion: %b", new Object[] { Boolean.FALSE, Boolean.FALSE });
      }
      Cdz = false;
      try
      {
        if (((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().apZ(paramString) != null) {
          Cdz = n.eAc();
        }
        bp(paramContext, paramString);
        AppMethodBeat.o(115096);
        return;
        i = 0;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.VoipPluginManager", localException, "", new Object[0]);
        }
      }
    }
  }
  
  public static void bo(Context paramContext, String paramString)
  {
    AppMethodBeat.i(115097);
    Cdz = false;
    try
    {
      if (((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().apZ(paramString) != null) {
        Cdz = n.eAc();
      }
      bp(paramContext, paramString);
      AppMethodBeat.o(115097);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.VoipPluginManager", localException, "", new Object[0]);
      }
    }
  }
  
  private static void bp(Context paramContext, String paramString)
  {
    AppMethodBeat.i(115098);
    if (bt.isNullOrNil(paramString))
    {
      ad.e("MicroMsg.VoipPluginManager", "talker is null");
      AppMethodBeat.o(115098);
      return;
    }
    int i = com.tencent.mm.kernel.g.aiU().aEN();
    ad.d("MicroMsg.VoipPluginManager", "startVoipVideoCall getNowStatus ".concat(String.valueOf(i)));
    if ((i != 4) && (i != 6))
    {
      com.tencent.mm.plugin.report.service.g.yhR.a(11518, true, true, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.c.euM().CdF.BXC.CaI.roomId), Long.valueOf(com.tencent.mm.plugin.voip.c.euM().CdF.BXC.CaI.uLt), Long.valueOf(com.tencent.mm.plugin.voip.c.euM().CdF.BXC.evX()), Integer.valueOf(4), Integer.valueOf(0) });
      h.a(paramContext, 2131764895, 2131764899, CdA);
      AppMethodBeat.o(115098);
      return;
    }
    if (!Cdz)
    {
      Object localObject3;
      i.a locala;
      try
      {
        Object localObject1 = i.a.aDE((String)com.tencent.mm.kernel.g.ajC().ajl().get(77829, null));
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
            com.tencent.mm.kernel.g.ajC().ajl().set(77829, i.a.aQ((Map)localObject1));
            localObject1 = ((Map)localObject1).entrySet().iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject3 = (Map.Entry)((Iterator)localObject1).next();
              locala = (i.a)((Map.Entry)localObject3).getValue();
              ad.d("MicroMsg.VoipPluginManager", "val1 " + locala.hitCount + " " + locala.iiY + "name " + (String)((Map.Entry)localObject3).getKey());
            }
            InviteRemindDialog.p(paramContext, paramString, 1);
          }
        }
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace("MicroMsg.VoipPluginManager", localException, "", new Object[0]);
      }
      for (;;)
      {
        ewV();
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
        com.tencent.mm.kernel.g.ajC().ajl().set(77829, i.a.aQ((Map)localObject2));
        localObject2 = ((Map)localObject2).entrySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (Map.Entry)((Iterator)localObject2).next();
          locala = (i.a)((Map.Entry)localObject3).getValue();
          ad.d("MicroMsg.VoipPluginManager", "val2 " + locala.hitCount + " " + locala.iiY + "  name " + (String)((Map.Entry)localObject3).getKey());
        }
      }
    }
    if ((ay.isWifi(paramContext)) || (ewU()))
    {
      com.tencent.mm.plugin.voip.c.euM().bq(paramContext, paramString);
      AppMethodBeat.o(115098);
      return;
    }
    com.tencent.mm.plugin.voip.c.euM().bq(paramContext, paramString);
    AppMethodBeat.o(115098);
  }
  
  public static long c(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3)
  {
    AppMethodBeat.i(115090);
    long l = a(paramString1, paramString2, paramInt1, paramInt2, paramString3, false);
    AppMethodBeat.o(115090);
    return l;
  }
  
  public static void ewT()
  {
    AppMethodBeat.i(115092);
    com.tencent.mm.kernel.g.ajC().ajl().set(20480, Long.valueOf(System.currentTimeMillis()));
    AppMethodBeat.o(115092);
  }
  
  public static boolean ewU()
  {
    AppMethodBeat.i(115093);
    try
    {
      long l1 = System.currentTimeMillis();
      long l2 = ((Long)com.tencent.mm.kernel.g.ajC().ajl().get(20480, Integer.valueOf(-1))).longValue();
      if (l2 < 0L)
      {
        AppMethodBeat.o(115093);
        return false;
      }
      l1 -= l2;
      ad.d("MicroMsg.VoipPluginManager", "diff is".concat(String.valueOf(l1)));
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
  
  private static void ewV()
  {
    AppMethodBeat.i(115095);
    yb localyb = new yb();
    localyb.dMo.dsi = 8;
    a.IbL.l(localyb);
    AppMethodBeat.o(115095);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.s
 * JD-Core Version:    0.7.0.1
 */