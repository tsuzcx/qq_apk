package com.tencent.mm.plugin.voip.model;

import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.td;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.kernel.e;
import com.tencent.mm.m.c;
import com.tencent.mm.model.bd;
import com.tencent.mm.plugin.voip.a.e;
import com.tencent.mm.plugin.voip.b;
import com.tencent.mm.plugin.voip.ui.InviteRemindDialog;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.z;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class q
{
  private static boolean pTl = false;
  private static DialogInterface.OnClickListener pTm = new q.3();
  
  public static long a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3)
  {
    return a(paramString1, paramString2, paramInt1, paramInt2, paramString3, false);
  }
  
  public static long a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, boolean paramBoolean)
  {
    bi localbi = new bi();
    localbi.bg(bd.iK(paramString1));
    localbi.fA(paramInt1);
    localbi.setType(50);
    localbi.ec(paramString1);
    localbi.cY(paramString3);
    localbi.setContent(paramString2);
    localbi.setStatus(paramInt2);
    if (paramBoolean) {
      localbi.ff(localbi.czq | 0x8);
    }
    long l = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bhO().T(localbi);
    if (l < 0L) {
      y.e("MicroMsg.VoipPluginManager", "inset voip  failed!");
    }
    y.d("MicroMsg.VoipPluginManager", "inset voip  msgId " + l);
    return l;
  }
  
  public static void aL(Context paramContext, final String paramString)
  {
    paramContext.getResources().getString(a.e.voip_call);
    pTl = false;
    try
    {
      bi localbi = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bhO().HB(paramString);
      if (localbi != null)
      {
        long l = localbi.field_createTime;
        pTl = com.tencent.mm.plugin.voip.a.d.bSi();
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.VoipPluginManager", localException1, "", new Object[0]);
      }
      int i = com.tencent.mm.kernel.g.Dk().KG();
      y.d("MicroMsg.VoipPluginManager", "startVoipVideoCall getNowStatus " + i);
      if ((i == 4) || (i == 6)) {
        break label223;
      }
      com.tencent.mm.plugin.report.service.h.nFQ.a(11518, true, true, new Object[] { Integer.valueOf(b.bPx().pTq.pNq.pQe.lpD), Long.valueOf(b.bPx().pTq.pNq.pQe.lpE), Long.valueOf(b.bPx().bRf()), Integer.valueOf(4), Integer.valueOf(0) });
      com.tencent.mm.ui.base.h.a(paramContext, a.e.voip_net_unavailable, a.e.voip_not_wifi_warnning_title, pTm);
      return;
      label223:
      if (pTl) {
        break label672;
      }
      Object localObject3;
      h.a locala;
      try
      {
        Object localObject1 = h.a.PY((String)com.tencent.mm.kernel.g.DP().Dz().get(77829, null));
        if (localObject1 != null) {
          if ((localObject1 != null) && (((Map)localObject1).size() > 0))
          {
            if (((Map)localObject1).containsKey(paramString))
            {
              localObject3 = (h.a)((Map)localObject1).get(paramString);
              ((h.a)localObject3).hitCount += 1;
              ((Map)localObject1).put(paramString, localObject3);
            }
          }
          else
          {
            com.tencent.mm.kernel.g.DP().Dz().o(77829, h.a.N((Map)localObject1));
            localObject1 = ((Map)localObject1).entrySet().iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject3 = (Map.Entry)((Iterator)localObject1).next();
              locala = (h.a)((Map.Entry)localObject3).getValue();
              y.d("MicroMsg.VoipPluginManager", "val1 " + locala.hitCount + " " + locala.ewK + "name " + (String)((Map.Entry)localObject3).getKey());
            }
            InviteRemindDialog.j(paramContext, paramString, 0);
          }
        }
      }
      catch (Exception localException2)
      {
        y.printErrStackTrace("MicroMsg.VoipPluginManager", localException2, "", new Object[0]);
      }
      for (;;)
      {
        bQZ();
        return;
        localObject3 = new h.a();
        ((h.a)localObject3).hitCount += 1;
        localException2.put(paramString, localObject3);
        break;
        Object localObject2 = new HashMap();
        localObject3 = new h.a();
        ((h.a)localObject3).hitCount += 1;
        ((Map)localObject2).put(paramString, localObject3);
        com.tencent.mm.kernel.g.DP().Dz().o(77829, h.a.N((Map)localObject2));
        localObject2 = ((Map)localObject2).entrySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (Map.Entry)((Iterator)localObject2).next();
          locala = (h.a)((Map.Entry)localObject3).getValue();
          y.d("MicroMsg.VoipPluginManager", "val2 " + locala.hitCount + " " + locala.ewK + "  name " + (String)((Map.Entry)localObject3).getKey());
        }
      }
      label672:
      if (aq.isWap(paramContext)) {
        break label725;
      }
      if ((!aq.isWifi(paramContext)) && (!bQY())) {
        break label701;
      }
      b.bPx().aQ(paramContext, paramString);
      return;
      label701:
      com.tencent.mm.ui.base.h.a(paramContext, a.e.voip_not_wifi_warnning_message, a.e.voip_not_wifi_warnning_title, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          q.bQX();
          b.bPx().aQ(this.val$context, paramString);
        }
      }, pTm);
      return;
      label725:
      com.tencent.mm.ui.base.h.a(paramContext, a.e.voip_using_wap_tip, 0, a.e.voip_using_wap_yes, a.e.app_cancel, new q.2(paramContext), pTm);
    }
    if (bk.bl(paramString))
    {
      y.e("MicroMsg.VoipPluginManager", "talker is null");
      return;
    }
  }
  
  public static void aM(Context paramContext, String paramString)
  {
    com.tencent.mm.m.g.AB();
    if (c.Am() == 2) {}
    for (int i = 1;; i = 0)
    {
      com.tencent.mm.br.d.coz();
      if (i == 0) {
        y.i("MicroMsg.VoipPluginManager", "showDouble %b, isLiteVersion: %b", new Object[] { Boolean.valueOf(false), Boolean.valueOf(false) });
      }
      pTl = false;
      try
      {
        bi localbi = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bhO().HB(paramString);
        if (localbi != null)
        {
          long l = localbi.field_createTime;
          pTl = com.tencent.mm.plugin.voip.a.d.bSi();
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          y.printErrStackTrace("MicroMsg.VoipPluginManager", localException, "", new Object[0]);
        }
      }
      aO(paramContext, paramString);
      return;
    }
  }
  
  public static void aN(Context paramContext, String paramString)
  {
    pTl = false;
    try
    {
      bi localbi = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bhO().HB(paramString);
      if (localbi != null)
      {
        long l = localbi.field_createTime;
        pTl = com.tencent.mm.plugin.voip.a.d.bSi();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.VoipPluginManager", localException, "", new Object[0]);
      }
    }
    aO(paramContext, paramString);
  }
  
  private static void aO(Context paramContext, String paramString)
  {
    if (bk.bl(paramString))
    {
      y.e("MicroMsg.VoipPluginManager", "talker is null");
      return;
    }
    int i = com.tencent.mm.kernel.g.Dk().KG();
    y.d("MicroMsg.VoipPluginManager", "startVoipVideoCall getNowStatus " + i);
    if ((i != 4) && (i != 6))
    {
      com.tencent.mm.plugin.report.service.h.nFQ.a(11518, true, true, new Object[] { Integer.valueOf(b.bPx().pTq.pNq.pQe.lpD), Long.valueOf(b.bPx().pTq.pNq.pQe.lpE), Long.valueOf(b.bPx().bRf()), Integer.valueOf(4), Integer.valueOf(0) });
      com.tencent.mm.ui.base.h.a(paramContext, a.e.voip_net_unavailable, a.e.voip_not_wifi_warnning_title, pTm);
      return;
    }
    if (!pTl)
    {
      Object localObject3;
      h.a locala;
      try
      {
        Object localObject1 = h.a.PY((String)com.tencent.mm.kernel.g.DP().Dz().get(77829, null));
        if (localObject1 != null) {
          if ((localObject1 != null) && (((Map)localObject1).size() > 0))
          {
            if (((Map)localObject1).containsKey(paramString))
            {
              localObject3 = (h.a)((Map)localObject1).get(paramString);
              ((h.a)localObject3).hitCount += 1;
              ((Map)localObject1).put(paramString, localObject3);
            }
          }
          else
          {
            com.tencent.mm.kernel.g.DP().Dz().o(77829, h.a.N((Map)localObject1));
            localObject1 = ((Map)localObject1).entrySet().iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject3 = (Map.Entry)((Iterator)localObject1).next();
              locala = (h.a)((Map.Entry)localObject3).getValue();
              y.d("MicroMsg.VoipPluginManager", "val1 " + locala.hitCount + " " + locala.ewK + "name " + (String)((Map.Entry)localObject3).getKey());
            }
            InviteRemindDialog.j(paramContext, paramString, 1);
          }
        }
      }
      catch (Exception localException)
      {
        y.printErrStackTrace("MicroMsg.VoipPluginManager", localException, "", new Object[0]);
      }
      for (;;)
      {
        bQZ();
        return;
        localObject3 = new h.a();
        ((h.a)localObject3).hitCount += 1;
        localException.put(paramString, localObject3);
        break;
        Object localObject2 = new HashMap();
        localObject3 = new h.a();
        ((h.a)localObject3).hitCount += 1;
        ((Map)localObject2).put(paramString, localObject3);
        com.tencent.mm.kernel.g.DP().Dz().o(77829, h.a.N((Map)localObject2));
        localObject2 = ((Map)localObject2).entrySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (Map.Entry)((Iterator)localObject2).next();
          locala = (h.a)((Map.Entry)localObject3).getValue();
          y.d("MicroMsg.VoipPluginManager", "val2 " + locala.hitCount + " " + locala.ewK + "  name " + (String)((Map.Entry)localObject3).getKey());
        }
      }
    }
    if (!aq.isWap(paramContext))
    {
      if ((aq.isWifi(paramContext)) || (bQY()))
      {
        b.bPx().aP(paramContext, paramString);
        return;
      }
      com.tencent.mm.ui.base.h.a(paramContext, a.e.voip_not_wifi_warnning_message, a.e.voip_not_wifi_warnning_title, new q.4(paramContext, paramString), pTm);
      return;
    }
    com.tencent.mm.ui.base.h.a(paramContext, a.e.voip_using_wap_tip, 0, a.e.voip_using_wap_yes, a.e.app_cancel, new q.5(paramContext), pTm);
  }
  
  public static void bQX()
  {
    com.tencent.mm.kernel.g.DP().Dz().o(20480, Long.valueOf(System.currentTimeMillis()));
  }
  
  public static boolean bQY()
  {
    try
    {
      long l1 = System.currentTimeMillis();
      long l2 = ((Long)com.tencent.mm.kernel.g.DP().Dz().get(20480, Integer.valueOf(-1))).longValue();
      if (l2 < 0L) {
        return false;
      }
      l1 -= l2;
      y.d("MicroMsg.VoipPluginManager", "diff is" + l1);
      if (l1 < 21600000L) {
        return true;
      }
    }
    catch (Exception localException) {}
    return false;
  }
  
  private static void bQZ()
  {
    td localtd = new td();
    localtd.ccJ.bNb = 8;
    a.udP.m(localtd);
  }
  
  public static void el(Context paramContext)
  {
    try
    {
      Intent localIntent = new Intent("/");
      localIntent.setComponent(new ComponentName("com.android.settings", "com.android.settings.ApnSettings"));
      localIntent.setAction("android.intent.action.VIEW");
      paramContext.startActivity(localIntent);
      return;
    }
    catch (Exception localException)
    {
      searchIntentByClass(paramContext, "ApnSettings");
    }
  }
  
  private static Intent searchIntentByClass(Context paramContext, String paramString)
  {
    try
    {
      PackageManager localPackageManager = paramContext.getPackageManager();
      List localList = localPackageManager.getInstalledPackages(0);
      if ((localList != null) && (localList.size() > 0))
      {
        y.e("MicroMsg.VoipPluginManager", "package  size" + localList.size());
        int i = 0;
        for (;;)
        {
          int j = localList.size();
          if (i >= j) {
            break label343;
          }
          try
          {
            y.e("MicroMsg.VoipPluginManager", "package " + ((PackageInfo)localList.get(i)).packageName);
            Object localObject1 = new Intent();
            ((Intent)localObject1).setPackage(((PackageInfo)localList.get(i)).packageName);
            Object localObject2 = localPackageManager.queryIntentActivities((Intent)localObject1, 0);
            if (localObject2 != null) {
              j = ((List)localObject2).size();
            }
            for (;;)
            {
              if (j > 0) {
                try
                {
                  y.e("MicroMsg.VoipPluginManager", "activityName count " + j);
                  int k = 0;
                  for (;;)
                  {
                    if (k >= j) {
                      break label305;
                    }
                    localObject1 = ((ResolveInfo)((List)localObject2).get(k)).activityInfo;
                    if (((ActivityInfo)localObject1).name.contains(paramString))
                    {
                      localObject2 = new Intent("/");
                      ((Intent)localObject2).setComponent(new ComponentName(((ActivityInfo)localObject1).packageName, ((ActivityInfo)localObject1).name));
                      ((Intent)localObject2).setAction("android.intent.action.VIEW");
                      paramContext.startActivity((Intent)localObject2);
                      return localObject2;
                      j = 0;
                      break;
                    }
                    k += 1;
                  }
                  i += 1;
                }
                catch (Exception localException1)
                {
                  y.printErrStackTrace("MicroMsg.VoipPluginManager", localException1, "", new Object[0]);
                }
              }
            }
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              label305:
              y.printErrStackTrace("MicroMsg.VoipPluginManager", localException2, "", new Object[0]);
            }
          }
        }
      }
      return null;
    }
    catch (Exception paramContext)
    {
      y.printErrStackTrace("MicroMsg.VoipPluginManager", paramContext, "", new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.q
 * JD-Core Version:    0.7.0.1
 */