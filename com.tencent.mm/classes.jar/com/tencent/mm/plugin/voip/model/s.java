package com.tencent.mm.plugin.voip.model;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.a.ww;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.bi;
import com.tencent.mm.plugin.voip.ui.InviteRemindDialog;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bl;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class s
{
  private static boolean zlL;
  private static DialogInterface.OnClickListener zlM;
  
  static
  {
    AppMethodBeat.i(115100);
    zlL = false;
    zlM = new DialogInterface.OnClickListener()
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
    bl localbl = new bl();
    localbl.kY(bi.uj(paramString1));
    localbl.jV(paramInt1);
    localbl.setType(50);
    localbl.nY(paramString1);
    localbl.mZ(paramString3);
    localbl.setContent(paramString2);
    localbl.setStatus(paramInt2);
    if (paramBoolean) {
      localbl.eMs();
    }
    long l = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().an(localbl);
    if (l < 0L) {
      ad.e("MicroMsg.VoipPluginManager", "inset voip  failed!");
    }
    ad.d("MicroMsg.VoipPluginManager", "inset voip  msgId ".concat(String.valueOf(l)));
    AppMethodBeat.o(115091);
    return l;
  }
  
  public static void bi(Context paramContext, final String paramString)
  {
    AppMethodBeat.i(115094);
    paramContext.getResources().getString(2131764795);
    zlL = false;
    try
    {
      if (((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().agr(paramString) != null) {
        zlL = com.tencent.mm.plugin.voip.b.k.dWM();
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
      int i = com.tencent.mm.kernel.g.aeS().auR();
      ad.d("MicroMsg.VoipPluginManager", "startVoipVideoCall getNowStatus ".concat(String.valueOf(i)));
      if ((i != 4) && (i != 6))
      {
        com.tencent.mm.plugin.report.service.h.vKh.a(11518, true, true, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.c.dRQ().zlR.zfA.ziZ.roomId), Long.valueOf(com.tencent.mm.plugin.voip.c.dRQ().zlR.zfA.ziZ.sAY), Long.valueOf(com.tencent.mm.plugin.voip.c.dRQ().zlR.zfA.dTa()), Integer.valueOf(4), Integer.valueOf(0) });
        com.tencent.mm.ui.base.h.a(paramContext, 2131764895, 2131764899, zlM);
        AppMethodBeat.o(115094);
        return;
      }
      if (!zlL)
      {
        Object localObject3;
        i.a locala;
        try
        {
          Object localObject1 = i.a.ate((String)com.tencent.mm.kernel.g.afB().afk().get(77829, null));
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
              com.tencent.mm.kernel.g.afB().afk().set(77829, i.a.aJ((Map)localObject1));
              localObject1 = ((Map)localObject1).entrySet().iterator();
              while (((Iterator)localObject1).hasNext())
              {
                localObject3 = (Map.Entry)((Iterator)localObject1).next();
                locala = (i.a)((Map.Entry)localObject3).getValue();
                ad.d("MicroMsg.VoipPluginManager", "val1 " + locala.hitCount + " " + locala.hpi + "name " + (String)((Map.Entry)localObject3).getKey());
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
          dTY();
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
          com.tencent.mm.kernel.g.afB().afk().set(77829, i.a.aJ((Map)localObject2));
          localObject2 = ((Map)localObject2).entrySet().iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (Map.Entry)((Iterator)localObject2).next();
            locala = (i.a)((Map.Entry)localObject3).getValue();
            ad.d("MicroMsg.VoipPluginManager", "val2 " + locala.hitCount + " " + locala.hpi + "  name " + (String)((Map.Entry)localObject3).getKey());
          }
        }
      }
      if ((ay.isWifi(paramContext)) || (dTX()))
      {
        com.tencent.mm.plugin.voip.c.dRQ().bn(paramContext, paramString);
        AppMethodBeat.o(115094);
        return;
      }
      com.tencent.mm.ui.base.h.a(paramContext, 2131764898, 2131764899, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(115088);
          s.dTW();
          com.tencent.mm.plugin.voip.c.dRQ().bn(this.val$context, paramString);
          AppMethodBeat.o(115088);
        }
      }, zlM);
      AppMethodBeat.o(115094);
    }
  }
  
  public static void bj(Context paramContext, String paramString)
  {
    AppMethodBeat.i(115096);
    com.tencent.mm.m.g.Ze();
    int i;
    if (com.tencent.mm.m.c.YO() == 2) {
      i = 1;
    }
    for (;;)
    {
      d.eBj();
      if (i == 0) {
        ad.i("MicroMsg.VoipPluginManager", "showDouble %b, isLiteVersion: %b", new Object[] { Boolean.FALSE, Boolean.FALSE });
      }
      zlL = false;
      try
      {
        if (((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().agr(paramString) != null) {
          zlL = com.tencent.mm.plugin.voip.b.k.dWM();
        }
        bl(paramContext, paramString);
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
  
  public static void bk(Context paramContext, String paramString)
  {
    AppMethodBeat.i(115097);
    zlL = false;
    try
    {
      if (((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().agr(paramString) != null) {
        zlL = com.tencent.mm.plugin.voip.b.k.dWM();
      }
      bl(paramContext, paramString);
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
  
  private static void bl(Context paramContext, String paramString)
  {
    AppMethodBeat.i(115098);
    if (bt.isNullOrNil(paramString))
    {
      ad.e("MicroMsg.VoipPluginManager", "talker is null");
      AppMethodBeat.o(115098);
      return;
    }
    int i = com.tencent.mm.kernel.g.aeS().auR();
    ad.d("MicroMsg.VoipPluginManager", "startVoipVideoCall getNowStatus ".concat(String.valueOf(i)));
    if ((i != 4) && (i != 6))
    {
      com.tencent.mm.plugin.report.service.h.vKh.a(11518, true, true, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.c.dRQ().zlR.zfA.ziZ.roomId), Long.valueOf(com.tencent.mm.plugin.voip.c.dRQ().zlR.zfA.ziZ.sAY), Long.valueOf(com.tencent.mm.plugin.voip.c.dRQ().zlR.zfA.dTa()), Integer.valueOf(4), Integer.valueOf(0) });
      com.tencent.mm.ui.base.h.a(paramContext, 2131764895, 2131764899, zlM);
      AppMethodBeat.o(115098);
      return;
    }
    if (!zlL)
    {
      Object localObject3;
      i.a locala;
      try
      {
        Object localObject1 = i.a.ate((String)com.tencent.mm.kernel.g.afB().afk().get(77829, null));
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
            com.tencent.mm.kernel.g.afB().afk().set(77829, i.a.aJ((Map)localObject1));
            localObject1 = ((Map)localObject1).entrySet().iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject3 = (Map.Entry)((Iterator)localObject1).next();
              locala = (i.a)((Map.Entry)localObject3).getValue();
              ad.d("MicroMsg.VoipPluginManager", "val1 " + locala.hitCount + " " + locala.hpi + "name " + (String)((Map.Entry)localObject3).getKey());
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
        dTY();
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
        com.tencent.mm.kernel.g.afB().afk().set(77829, i.a.aJ((Map)localObject2));
        localObject2 = ((Map)localObject2).entrySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (Map.Entry)((Iterator)localObject2).next();
          locala = (i.a)((Map.Entry)localObject3).getValue();
          ad.d("MicroMsg.VoipPluginManager", "val2 " + locala.hitCount + " " + locala.hpi + "  name " + (String)((Map.Entry)localObject3).getKey());
        }
      }
    }
    if ((ay.isWifi(paramContext)) || (dTX()))
    {
      com.tencent.mm.plugin.voip.c.dRQ().bm(paramContext, paramString);
      AppMethodBeat.o(115098);
      return;
    }
    com.tencent.mm.plugin.voip.c.dRQ().bm(paramContext, paramString);
    AppMethodBeat.o(115098);
  }
  
  public static long c(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3)
  {
    AppMethodBeat.i(115090);
    long l = a(paramString1, paramString2, paramInt1, paramInt2, paramString3, false);
    AppMethodBeat.o(115090);
    return l;
  }
  
  public static void dTW()
  {
    AppMethodBeat.i(115092);
    com.tencent.mm.kernel.g.afB().afk().set(20480, Long.valueOf(System.currentTimeMillis()));
    AppMethodBeat.o(115092);
  }
  
  public static boolean dTX()
  {
    AppMethodBeat.i(115093);
    try
    {
      long l1 = System.currentTimeMillis();
      long l2 = ((Long)com.tencent.mm.kernel.g.afB().afk().get(20480, Integer.valueOf(-1))).longValue();
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
  
  private static void dTY()
  {
    AppMethodBeat.i(115095);
    ww localww = new ww();
    localww.dCp.djq = 8;
    a.ESL.l(localww);
    AppMethodBeat.o(115095);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.s
 * JD-Core Version:    0.7.0.1
 */