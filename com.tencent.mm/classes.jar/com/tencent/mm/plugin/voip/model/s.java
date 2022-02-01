package com.tencent.mm.plugin.voip.model;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.xh;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.bi;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.voip.ui.InviteRemindDialog;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.bo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class s
{
  private static DialogInterface.OnClickListener AEA;
  private static boolean AEz;
  
  static
  {
    AppMethodBeat.i(115100);
    AEz = false;
    AEA = new DialogInterface.OnClickListener()
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
    bo localbo = new bo();
    localbo.oA(bi.yp(paramString1));
    localbo.jT(paramInt1);
    localbo.setType(50);
    localbo.re(paramString1);
    localbo.qf(paramString3);
    localbo.setContent(paramString2);
    localbo.setStatus(paramInt2);
    if (paramBoolean) {
      localbo.fbX();
    }
    long l = ((k)com.tencent.mm.kernel.g.ab(k.class)).dcr().ap(localbo);
    if (l < 0L) {
      ac.e("MicroMsg.VoipPluginManager", "inset voip  failed!");
    }
    ac.d("MicroMsg.VoipPluginManager", "inset voip  msgId ".concat(String.valueOf(l)));
    AppMethodBeat.o(115091);
    return l;
  }
  
  public static void bj(Context paramContext, final String paramString)
  {
    AppMethodBeat.i(115094);
    paramContext.getResources().getString(2131764795);
    AEz = false;
    try
    {
      if (((k)com.tencent.mm.kernel.g.ab(k.class)).dcr().all(paramString) != null) {
        AEz = com.tencent.mm.plugin.voip.b.l.emh();
      }
      if (bs.isNullOrNil(paramString))
      {
        ac.e("MicroMsg.VoipPluginManager", "talker is null");
        AppMethodBeat.o(115094);
        return;
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.VoipPluginManager", localException1, "", new Object[0]);
      }
      int i = com.tencent.mm.kernel.g.agi().aBK();
      ac.d("MicroMsg.VoipPluginManager", "startVoipVideoCall getNowStatus ".concat(String.valueOf(i)));
      if ((i != 4) && (i != 6))
      {
        com.tencent.mm.plugin.report.service.h.wUl.a(11518, true, true, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.c.ehb().AEF.Ayh.ABJ.roomId), Long.valueOf(com.tencent.mm.plugin.voip.c.ehb().AEF.Ayh.ABJ.tIG), Long.valueOf(com.tencent.mm.plugin.voip.c.ehb().AEF.Ayh.eim()), Integer.valueOf(4), Integer.valueOf(0) });
        com.tencent.mm.ui.base.h.a(paramContext, 2131764895, 2131764899, AEA);
        AppMethodBeat.o(115094);
        return;
      }
      if (!AEz)
      {
        Object localObject3;
        i.a locala;
        try
        {
          Object localObject1 = i.a.ayv((String)com.tencent.mm.kernel.g.agR().agA().get(77829, null));
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
              com.tencent.mm.kernel.g.agR().agA().set(77829, i.a.aN((Map)localObject1));
              localObject1 = ((Map)localObject1).entrySet().iterator();
              while (((Iterator)localObject1).hasNext())
              {
                localObject3 = (Map.Entry)((Iterator)localObject1).next();
                locala = (i.a)((Map.Entry)localObject3).getValue();
                ac.d("MicroMsg.VoipPluginManager", "val1 " + locala.hitCount + " " + locala.hPK + "name " + (String)((Map.Entry)localObject3).getKey());
              }
              InviteRemindDialog.p(paramContext, paramString, 0);
            }
          }
        }
        catch (Exception localException2)
        {
          ac.printErrStackTrace("MicroMsg.VoipPluginManager", localException2, "", new Object[0]);
        }
        for (;;)
        {
          ejk();
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
          com.tencent.mm.kernel.g.agR().agA().set(77829, i.a.aN((Map)localObject2));
          localObject2 = ((Map)localObject2).entrySet().iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (Map.Entry)((Iterator)localObject2).next();
            locala = (i.a)((Map.Entry)localObject3).getValue();
            ac.d("MicroMsg.VoipPluginManager", "val2 " + locala.hitCount + " " + locala.hPK + "  name " + (String)((Map.Entry)localObject3).getKey());
          }
        }
      }
      if ((ax.isWifi(paramContext)) || (ejj()))
      {
        com.tencent.mm.plugin.voip.c.ehb().bo(paramContext, paramString);
        AppMethodBeat.o(115094);
        return;
      }
      com.tencent.mm.ui.base.h.a(paramContext, 2131764898, 2131764899, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(115088);
          s.eji();
          com.tencent.mm.plugin.voip.c.ehb().bo(this.val$context, paramString);
          AppMethodBeat.o(115088);
        }
      }, AEA);
      AppMethodBeat.o(115094);
    }
  }
  
  public static void bk(Context paramContext, String paramString)
  {
    AppMethodBeat.i(115096);
    com.tencent.mm.m.g.ZZ();
    int i;
    if (com.tencent.mm.m.c.ZL() == 2) {
      i = 1;
    }
    for (;;)
    {
      d.eQD();
      if (i == 0) {
        ac.i("MicroMsg.VoipPluginManager", "showDouble %b, isLiteVersion: %b", new Object[] { Boolean.FALSE, Boolean.FALSE });
      }
      AEz = false;
      try
      {
        if (((k)com.tencent.mm.kernel.g.ab(k.class)).dcr().all(paramString) != null) {
          AEz = com.tencent.mm.plugin.voip.b.l.emh();
        }
        bm(paramContext, paramString);
        AppMethodBeat.o(115096);
        return;
        i = 0;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ac.printErrStackTrace("MicroMsg.VoipPluginManager", localException, "", new Object[0]);
        }
      }
    }
  }
  
  public static void bl(Context paramContext, String paramString)
  {
    AppMethodBeat.i(115097);
    AEz = false;
    try
    {
      if (((k)com.tencent.mm.kernel.g.ab(k.class)).dcr().all(paramString) != null) {
        AEz = com.tencent.mm.plugin.voip.b.l.emh();
      }
      bm(paramContext, paramString);
      AppMethodBeat.o(115097);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.VoipPluginManager", localException, "", new Object[0]);
      }
    }
  }
  
  private static void bm(Context paramContext, String paramString)
  {
    AppMethodBeat.i(115098);
    if (bs.isNullOrNil(paramString))
    {
      ac.e("MicroMsg.VoipPluginManager", "talker is null");
      AppMethodBeat.o(115098);
      return;
    }
    int i = com.tencent.mm.kernel.g.agi().aBK();
    ac.d("MicroMsg.VoipPluginManager", "startVoipVideoCall getNowStatus ".concat(String.valueOf(i)));
    if ((i != 4) && (i != 6))
    {
      com.tencent.mm.plugin.report.service.h.wUl.a(11518, true, true, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.c.ehb().AEF.Ayh.ABJ.roomId), Long.valueOf(com.tencent.mm.plugin.voip.c.ehb().AEF.Ayh.ABJ.tIG), Long.valueOf(com.tencent.mm.plugin.voip.c.ehb().AEF.Ayh.eim()), Integer.valueOf(4), Integer.valueOf(0) });
      com.tencent.mm.ui.base.h.a(paramContext, 2131764895, 2131764899, AEA);
      AppMethodBeat.o(115098);
      return;
    }
    if (!AEz)
    {
      Object localObject3;
      i.a locala;
      try
      {
        Object localObject1 = i.a.ayv((String)com.tencent.mm.kernel.g.agR().agA().get(77829, null));
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
            com.tencent.mm.kernel.g.agR().agA().set(77829, i.a.aN((Map)localObject1));
            localObject1 = ((Map)localObject1).entrySet().iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject3 = (Map.Entry)((Iterator)localObject1).next();
              locala = (i.a)((Map.Entry)localObject3).getValue();
              ac.d("MicroMsg.VoipPluginManager", "val1 " + locala.hitCount + " " + locala.hPK + "name " + (String)((Map.Entry)localObject3).getKey());
            }
            InviteRemindDialog.p(paramContext, paramString, 1);
          }
        }
      }
      catch (Exception localException)
      {
        ac.printErrStackTrace("MicroMsg.VoipPluginManager", localException, "", new Object[0]);
      }
      for (;;)
      {
        ejk();
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
        com.tencent.mm.kernel.g.agR().agA().set(77829, i.a.aN((Map)localObject2));
        localObject2 = ((Map)localObject2).entrySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (Map.Entry)((Iterator)localObject2).next();
          locala = (i.a)((Map.Entry)localObject3).getValue();
          ac.d("MicroMsg.VoipPluginManager", "val2 " + locala.hitCount + " " + locala.hPK + "  name " + (String)((Map.Entry)localObject3).getKey());
        }
      }
    }
    if ((ax.isWifi(paramContext)) || (ejj()))
    {
      com.tencent.mm.plugin.voip.c.ehb().bn(paramContext, paramString);
      AppMethodBeat.o(115098);
      return;
    }
    com.tencent.mm.plugin.voip.c.ehb().bn(paramContext, paramString);
    AppMethodBeat.o(115098);
  }
  
  public static long c(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3)
  {
    AppMethodBeat.i(115090);
    long l = a(paramString1, paramString2, paramInt1, paramInt2, paramString3, false);
    AppMethodBeat.o(115090);
    return l;
  }
  
  public static void eji()
  {
    AppMethodBeat.i(115092);
    com.tencent.mm.kernel.g.agR().agA().set(20480, Long.valueOf(System.currentTimeMillis()));
    AppMethodBeat.o(115092);
  }
  
  public static boolean ejj()
  {
    AppMethodBeat.i(115093);
    try
    {
      long l1 = System.currentTimeMillis();
      long l2 = ((Long)com.tencent.mm.kernel.g.agR().agA().get(20480, Integer.valueOf(-1))).longValue();
      if (l2 < 0L)
      {
        AppMethodBeat.o(115093);
        return false;
      }
      l1 -= l2;
      ac.d("MicroMsg.VoipPluginManager", "diff is".concat(String.valueOf(l1)));
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
  
  private static void ejk()
  {
    AppMethodBeat.i(115095);
    xh localxh = new xh();
    localxh.dAb.dgL = 8;
    a.GpY.l(localxh);
    AppMethodBeat.o(115095);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.s
 * JD-Core Version:    0.7.0.1
 */