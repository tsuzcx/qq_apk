package com.tencent.mm.plugin.voip.model;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.yh;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.bl;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.voip.b.n;
import com.tencent.mm.plugin.voip.ui.InviteRemindDialog;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.h;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class s
{
  private static boolean Cva;
  private static DialogInterface.OnClickListener Cvb;
  
  static
  {
    AppMethodBeat.i(115100);
    Cva = false;
    Cvb = new DialogInterface.OnClickListener()
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
    bv localbv = new bv();
    localbv.qN(bl.BQ(paramString1));
    localbv.kt(paramInt1);
    localbv.setType(50);
    localbv.ui(paramString1);
    localbv.tk(paramString3);
    localbv.setContent(paramString2);
    localbv.setStatus(paramInt2);
    if (paramBoolean) {
      localbv.fwb();
    }
    long l = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().ar(localbv);
    if (l < 0L) {
      ae.e("MicroMsg.VoipPluginManager", "inset voip  failed!");
    }
    ae.d("MicroMsg.VoipPluginManager", "inset voip  msgId ".concat(String.valueOf(l)));
    AppMethodBeat.o(115091);
    return l;
  }
  
  public static void bo(Context paramContext, final String paramString)
  {
    AppMethodBeat.i(115094);
    paramContext.getResources().getString(2131764795);
    Cva = false;
    try
    {
      if (((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().are(paramString) != null) {
        Cva = n.eDK();
      }
      if (bu.isNullOrNil(paramString))
      {
        ae.e("MicroMsg.VoipPluginManager", "talker is null");
        AppMethodBeat.o(115094);
        return;
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.VoipPluginManager", localException1, "", new Object[0]);
      }
      int i = com.tencent.mm.kernel.g.ajj().aFd();
      ae.d("MicroMsg.VoipPluginManager", "startVoipVideoCall getNowStatus ".concat(String.valueOf(i)));
      if ((i != 4) && (i != 6))
      {
        com.tencent.mm.plugin.report.service.g.yxI.a(11518, true, true, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.c.eys().Cvg.Cpd.Csj.roomId), Long.valueOf(com.tencent.mm.plugin.voip.c.eys().Cvg.Cpd.Csj.uXg), Long.valueOf(com.tencent.mm.plugin.voip.c.eys().Cvg.Cpd.ezE()), Integer.valueOf(4), Integer.valueOf(0) });
        h.a(paramContext, 2131764895, 2131764899, Cvb);
        AppMethodBeat.o(115094);
        return;
      }
      if (!Cva)
      {
        Object localObject3;
        i.a locala;
        try
        {
          Object localObject1 = i.a.aEX((String)com.tencent.mm.kernel.g.ajR().ajA().get(77829, null));
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
              com.tencent.mm.kernel.g.ajR().ajA().set(77829, i.a.aW((Map)localObject1));
              localObject1 = ((Map)localObject1).entrySet().iterator();
              while (((Iterator)localObject1).hasNext())
              {
                localObject3 = (Map.Entry)((Iterator)localObject1).next();
                locala = (i.a)((Map.Entry)localObject3).getValue();
                ae.d("MicroMsg.VoipPluginManager", "val1 " + locala.hitCount + " " + locala.ilR + "name " + (String)((Map.Entry)localObject3).getKey());
              }
              InviteRemindDialog.o(paramContext, paramString, 0);
            }
          }
        }
        catch (Exception localException2)
        {
          ae.printErrStackTrace("MicroMsg.VoipPluginManager", localException2, "", new Object[0]);
        }
        for (;;)
        {
          eAC();
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
          com.tencent.mm.kernel.g.ajR().ajA().set(77829, i.a.aW((Map)localObject2));
          localObject2 = ((Map)localObject2).entrySet().iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (Map.Entry)((Iterator)localObject2).next();
            locala = (i.a)((Map.Entry)localObject3).getValue();
            ae.d("MicroMsg.VoipPluginManager", "val2 " + locala.hitCount + " " + locala.ilR + "  name " + (String)((Map.Entry)localObject3).getKey());
          }
        }
      }
      if ((az.isWifi(paramContext)) || (eAB()))
      {
        com.tencent.mm.plugin.voip.c.eys().bt(paramContext, paramString);
        AppMethodBeat.o(115094);
        return;
      }
      h.a(paramContext, 2131764898, 2131764899, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(115088);
          s.eAA();
          com.tencent.mm.plugin.voip.c.eys().bt(this.val$context, paramString);
          AppMethodBeat.o(115088);
        }
      }, Cvb);
      AppMethodBeat.o(115094);
    }
  }
  
  public static void bp(Context paramContext, String paramString)
  {
    AppMethodBeat.i(115096);
    com.tencent.mm.n.g.acM();
    int i;
    if (com.tencent.mm.n.c.acx() == 2) {
      i = 1;
    }
    for (;;)
    {
      d.fjx();
      if (i == 0) {
        ae.i("MicroMsg.VoipPluginManager", "showDouble %b, isLiteVersion: %b", new Object[] { Boolean.FALSE, Boolean.FALSE });
      }
      Cva = false;
      try
      {
        if (((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().are(paramString) != null) {
          Cva = n.eDK();
        }
        br(paramContext, paramString);
        AppMethodBeat.o(115096);
        return;
        i = 0;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ae.printErrStackTrace("MicroMsg.VoipPluginManager", localException, "", new Object[0]);
        }
      }
    }
  }
  
  public static void bq(Context paramContext, String paramString)
  {
    AppMethodBeat.i(115097);
    Cva = false;
    try
    {
      if (((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().are(paramString) != null) {
        Cva = n.eDK();
      }
      br(paramContext, paramString);
      AppMethodBeat.o(115097);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.VoipPluginManager", localException, "", new Object[0]);
      }
    }
  }
  
  private static void br(Context paramContext, String paramString)
  {
    AppMethodBeat.i(115098);
    if (bu.isNullOrNil(paramString))
    {
      ae.e("MicroMsg.VoipPluginManager", "talker is null");
      AppMethodBeat.o(115098);
      return;
    }
    int i = com.tencent.mm.kernel.g.ajj().aFd();
    ae.d("MicroMsg.VoipPluginManager", "startVoipVideoCall getNowStatus ".concat(String.valueOf(i)));
    if ((i != 4) && (i != 6))
    {
      com.tencent.mm.plugin.report.service.g.yxI.a(11518, true, true, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.c.eys().Cvg.Cpd.Csj.roomId), Long.valueOf(com.tencent.mm.plugin.voip.c.eys().Cvg.Cpd.Csj.uXg), Long.valueOf(com.tencent.mm.plugin.voip.c.eys().Cvg.Cpd.ezE()), Integer.valueOf(4), Integer.valueOf(0) });
      h.a(paramContext, 2131764895, 2131764899, Cvb);
      AppMethodBeat.o(115098);
      return;
    }
    if (!Cva)
    {
      Object localObject3;
      i.a locala;
      try
      {
        Object localObject1 = i.a.aEX((String)com.tencent.mm.kernel.g.ajR().ajA().get(77829, null));
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
            com.tencent.mm.kernel.g.ajR().ajA().set(77829, i.a.aW((Map)localObject1));
            localObject1 = ((Map)localObject1).entrySet().iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject3 = (Map.Entry)((Iterator)localObject1).next();
              locala = (i.a)((Map.Entry)localObject3).getValue();
              ae.d("MicroMsg.VoipPluginManager", "val1 " + locala.hitCount + " " + locala.ilR + "name " + (String)((Map.Entry)localObject3).getKey());
            }
            InviteRemindDialog.o(paramContext, paramString, 1);
          }
        }
      }
      catch (Exception localException)
      {
        ae.printErrStackTrace("MicroMsg.VoipPluginManager", localException, "", new Object[0]);
      }
      for (;;)
      {
        eAC();
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
        com.tencent.mm.kernel.g.ajR().ajA().set(77829, i.a.aW((Map)localObject2));
        localObject2 = ((Map)localObject2).entrySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (Map.Entry)((Iterator)localObject2).next();
          locala = (i.a)((Map.Entry)localObject3).getValue();
          ae.d("MicroMsg.VoipPluginManager", "val2 " + locala.hitCount + " " + locala.ilR + "  name " + (String)((Map.Entry)localObject3).getKey());
        }
      }
    }
    if ((az.isWifi(paramContext)) || (eAB()))
    {
      com.tencent.mm.plugin.voip.c.eys().bs(paramContext, paramString);
      AppMethodBeat.o(115098);
      return;
    }
    com.tencent.mm.plugin.voip.c.eys().bs(paramContext, paramString);
    AppMethodBeat.o(115098);
  }
  
  public static long c(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3)
  {
    AppMethodBeat.i(115090);
    long l = a(paramString1, paramString2, paramInt1, paramInt2, paramString3, false);
    AppMethodBeat.o(115090);
    return l;
  }
  
  public static void eAA()
  {
    AppMethodBeat.i(115092);
    com.tencent.mm.kernel.g.ajR().ajA().set(20480, Long.valueOf(System.currentTimeMillis()));
    AppMethodBeat.o(115092);
  }
  
  public static boolean eAB()
  {
    AppMethodBeat.i(115093);
    try
    {
      long l1 = System.currentTimeMillis();
      long l2 = ((Long)com.tencent.mm.kernel.g.ajR().ajA().get(20480, Integer.valueOf(-1))).longValue();
      if (l2 < 0L)
      {
        AppMethodBeat.o(115093);
        return false;
      }
      l1 -= l2;
      ae.d("MicroMsg.VoipPluginManager", "diff is".concat(String.valueOf(l1)));
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
  
  private static void eAC()
  {
    AppMethodBeat.i(115095);
    yh localyh = new yh();
    localyh.dNE.dto = 8;
    a.IvT.l(localyh);
    AppMethodBeat.o(115095);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.s
 * JD-Core Version:    0.7.0.1
 */