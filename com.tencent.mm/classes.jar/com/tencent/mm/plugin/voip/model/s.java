package com.tencent.mm.plugin.voip.model;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.acn;
import com.tencent.mm.br.c;
import com.tencent.mm.k.d;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.br;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.voip.SubCoreVoip;
import com.tencent.mm.plugin.voip.b.g;
import com.tencent.mm.plugin.voip.f.m;
import com.tencent.mm.plugin.voip.widget.InviteRemindDialog;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.k;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class s
{
  private static boolean TiC;
  private static DialogInterface.OnClickListener UBz;
  
  static
  {
    AppMethodBeat.i(115100);
    TiC = false;
    UBz = new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(293315);
        s.access$000();
        AppMethodBeat.o(293315);
      }
    };
    AppMethodBeat.o(115100);
  }
  
  public static long a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(115091);
    cc localcc = new cc();
    localcc.setCreateTime(br.JN(paramString1));
    localcc.pI(paramInt1);
    localcc.setType(50);
    localcc.BS(paramString1);
    localcc.AU(paramString3);
    localcc.setContent(paramString2);
    localcc.setStatus(paramInt2);
    if (paramBoolean) {
      localcc.jbZ();
    }
    long l = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().ba(localcc);
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
  
  public static void cd(Context paramContext, String paramString)
  {
    AppMethodBeat.i(115094);
    paramContext.getResources().getString(b.g.voip_call);
    TiC = false;
    try
    {
      cc localcc = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().aLI(paramString);
      if (localcc != null)
      {
        localcc.getCreateTime();
        TiC = m.icb();
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.VoipPluginManager", localException1, "", new Object[0]);
      }
      int i = com.tencent.mm.kernel.h.aZW().bFQ();
      Log.d("MicroMsg.VoipPluginManager", "startVoipVideoCall getNowStatus ".concat(String.valueOf(i)));
      if ((i == 4) || (i == 6)) {
        break label232;
      }
      com.tencent.mm.plugin.report.service.h.OAn.a(11518, true, true, new Object[] { Integer.valueOf(SubCoreVoip.hVp().UBE.UvO.UyU.roomId), Long.valueOf(SubCoreVoip.hVp().UBE.UvO.UyU.Hnt), Long.valueOf(SubCoreVoip.hVp().UBE.UvO.hWC()), Integer.valueOf(4), Integer.valueOf(0) });
      k.a(paramContext, b.g.voip_net_unavailable, b.g.voip_not_wifi_warnning_title, UBz);
      AppMethodBeat.o(115094);
      return;
      if (TiC) {
        break label664;
      }
      Object localObject3;
      i.a locala;
      try
      {
        Object localObject1 = i.a.bfH((String)com.tencent.mm.kernel.h.baE().ban().d(77829, null));
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
            com.tencent.mm.kernel.h.baE().ban().B(77829, i.a.bg((Map)localObject1));
            localObject1 = ((Map)localObject1).entrySet().iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject3 = (Map.Entry)((Iterator)localObject1).next();
              locala = (i.a)((Map.Entry)localObject3).getValue();
              Log.d("MicroMsg.VoipPluginManager", "val1 " + locala.hitCount + " " + locala.oQA + "name " + (String)((Map.Entry)localObject3).getKey());
            }
            InviteRemindDialog.s(paramContext, paramString, 0);
          }
        }
      }
      catch (Exception localException2)
      {
        Log.printErrStackTrace("MicroMsg.VoipPluginManager", localException2, "", new Object[0]);
      }
      for (;;)
      {
        hXO();
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
        com.tencent.mm.kernel.h.baE().ban().B(77829, i.a.bg((Map)localObject2));
        localObject2 = ((Map)localObject2).entrySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (Map.Entry)((Iterator)localObject2).next();
          locala = (i.a)((Map.Entry)localObject3).getValue();
          Log.d("MicroMsg.VoipPluginManager", "val2 " + locala.hitCount + " " + locala.oQA + "  name " + (String)((Map.Entry)localObject3).getKey());
        }
      }
      if ((!NetStatusUtil.isWifi(paramContext)) && (!hXN())) {
        break label691;
      }
      SubCoreVoip.hVp().ci(paramContext, paramString);
      AppMethodBeat.o(115094);
      return;
      SubCoreVoip.hVp().ci(paramContext, paramString);
      AppMethodBeat.o(115094);
    }
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.VoipPluginManager", "talker is null");
      AppMethodBeat.o(115094);
      return;
    }
    label232:
  }
  
  public static void ce(Context paramContext, String paramString)
  {
    AppMethodBeat.i(115096);
    com.tencent.mm.k.i.aRD();
    if (d.aRq() == 2) {}
    for (int i = 1;; i = 0)
    {
      boolean bool = c.iPe();
      if ((!bool) && (i == 0)) {
        Log.i("MicroMsg.VoipPluginManager", "showDouble %b, isLiteVersion: %b", new Object[] { Boolean.FALSE, Boolean.valueOf(bool) });
      }
      TiC = false;
      try
      {
        cc localcc = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().aLI(paramString);
        if (localcc != null)
        {
          localcc.getCreateTime();
          TiC = m.icb();
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.VoipPluginManager", localException, "", new Object[0]);
        }
      }
      cg(paramContext, paramString);
      AppMethodBeat.o(115096);
      return;
    }
  }
  
  public static void cf(Context paramContext, String paramString)
  {
    AppMethodBeat.i(115097);
    TiC = false;
    try
    {
      cc localcc = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().aLI(paramString);
      if (localcc != null)
      {
        localcc.getCreateTime();
        TiC = m.icb();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.VoipPluginManager", localException, "", new Object[0]);
      }
    }
    cg(paramContext, paramString);
    AppMethodBeat.o(115097);
  }
  
  private static void cg(Context paramContext, String paramString)
  {
    AppMethodBeat.i(115098);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.VoipPluginManager", "talker is null");
      AppMethodBeat.o(115098);
      return;
    }
    int i = com.tencent.mm.kernel.h.aZW().bFQ();
    Log.d("MicroMsg.VoipPluginManager", "startVoipVideoCall getNowStatus ".concat(String.valueOf(i)));
    if ((i != 4) && (i != 6))
    {
      com.tencent.mm.plugin.report.service.h.OAn.a(11518, true, true, new Object[] { Integer.valueOf(SubCoreVoip.hVp().UBE.UvO.UyU.roomId), Long.valueOf(SubCoreVoip.hVp().UBE.UvO.UyU.Hnt), Long.valueOf(SubCoreVoip.hVp().UBE.UvO.hWC()), Integer.valueOf(4), Integer.valueOf(0) });
      k.a(paramContext, b.g.voip_net_unavailable, b.g.voip_not_wifi_warnning_title, UBz);
      AppMethodBeat.o(115098);
      return;
    }
    if (!TiC)
    {
      Object localObject3;
      i.a locala;
      try
      {
        Object localObject1 = i.a.bfH((String)com.tencent.mm.kernel.h.baE().ban().d(77829, null));
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
            com.tencent.mm.kernel.h.baE().ban().B(77829, i.a.bg((Map)localObject1));
            localObject1 = ((Map)localObject1).entrySet().iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject3 = (Map.Entry)((Iterator)localObject1).next();
              locala = (i.a)((Map.Entry)localObject3).getValue();
              Log.d("MicroMsg.VoipPluginManager", "val1 " + locala.hitCount + " " + locala.oQA + "name " + (String)((Map.Entry)localObject3).getKey());
            }
            InviteRemindDialog.s(paramContext, paramString, 1);
          }
        }
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.VoipPluginManager", localException, "", new Object[0]);
      }
      for (;;)
      {
        hXO();
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
        com.tencent.mm.kernel.h.baE().ban().B(77829, i.a.bg((Map)localObject2));
        localObject2 = ((Map)localObject2).entrySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (Map.Entry)((Iterator)localObject2).next();
          locala = (i.a)((Map.Entry)localObject3).getValue();
          Log.d("MicroMsg.VoipPluginManager", "val2 " + locala.hitCount + " " + locala.oQA + "  name " + (String)((Map.Entry)localObject3).getKey());
        }
      }
    }
    if ((NetStatusUtil.isWifi(paramContext)) || (hXN()))
    {
      SubCoreVoip.hVp().ch(paramContext, paramString);
      AppMethodBeat.o(115098);
      return;
    }
    SubCoreVoip.hVp().ch(paramContext, paramString);
    AppMethodBeat.o(115098);
  }
  
  public static void hXM()
  {
    AppMethodBeat.i(115092);
    com.tencent.mm.kernel.h.baE().ban().B(20480, Long.valueOf(System.currentTimeMillis()));
    AppMethodBeat.o(115092);
  }
  
  public static boolean hXN()
  {
    AppMethodBeat.i(115093);
    try
    {
      long l1 = System.currentTimeMillis();
      long l2 = ((Long)com.tencent.mm.kernel.h.baE().ban().d(20480, Integer.valueOf(-1))).longValue();
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
  
  private static void hXO()
  {
    AppMethodBeat.i(115095);
    acn localacn = new acn();
    localacn.ifU.hId = 8;
    localacn.publish();
    AppMethodBeat.o(115095);
  }
  
  public static void kx(Context paramContext)
  {
    AppMethodBeat.i(293299);
    if ((!NetStatusUtil.isWifi(paramContext)) && (!SubCoreVoip.hVp().UBI)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        SubCoreVoip.hVp().UBJ = true;
        aa.da(paramContext, paramContext.getResources().getText(b.g.voip_cellular_cost_tip).toString());
      }
      AppMethodBeat.o(293299);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.s
 * JD-Core Version:    0.7.0.1
 */