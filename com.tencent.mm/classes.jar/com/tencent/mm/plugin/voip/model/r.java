package com.tencent.mm.plugin.voip.model;

import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.ux;
import com.tencent.mm.kernel.e;
import com.tencent.mm.m.c;
import com.tencent.mm.model.bf;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.voip.b;
import com.tencent.mm.plugin.voip.ui.InviteRemindDialog;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.z;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class r
{
  private static boolean tyL;
  private static DialogInterface.OnClickListener tyM;
  
  static
  {
    AppMethodBeat.i(4592);
    tyL = false;
    tyM = new r.3();
    AppMethodBeat.o(4592);
  }
  
  public static long a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3)
  {
    AppMethodBeat.i(4580);
    long l = a(paramString1, paramString2, paramInt1, paramInt2, paramString3, false);
    AppMethodBeat.o(4580);
    return l;
  }
  
  public static long a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(4581);
    bi localbi = new bi();
    localbi.fQ(bf.py(paramString1));
    localbi.hL(paramInt1);
    localbi.setType(50);
    localbi.kj(paramString1);
    localbi.jl(paramString3);
    localbi.setContent(paramString2);
    localbi.setStatus(paramInt2);
    if (paramBoolean) {
      localbi.dyg();
    }
    long l = ((j)com.tencent.mm.kernel.g.E(j.class)).bPQ().Z(localbi);
    if (l < 0L) {
      ab.e("MicroMsg.VoipPluginManager", "inset voip  failed!");
    }
    ab.d("MicroMsg.VoipPluginManager", "inset voip  msgId ".concat(String.valueOf(l)));
    AppMethodBeat.o(4581);
    return l;
  }
  
  public static void aV(Context paramContext, String paramString)
  {
    AppMethodBeat.i(4584);
    paramContext.getResources().getString(2131304619);
    tyL = false;
    try
    {
      if (((j)com.tencent.mm.kernel.g.E(j.class)).bPQ().Tn(paramString) != null) {
        tyL = com.tencent.mm.plugin.voip.a.d.cPr();
      }
      if (bo.isNullOrNil(paramString))
      {
        ab.e("MicroMsg.VoipPluginManager", "talker is null");
        AppMethodBeat.o(4584);
        return;
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.VoipPluginManager", localException1, "", new Object[0]);
      }
      int i = com.tencent.mm.kernel.g.Rc().adt();
      ab.d("MicroMsg.VoipPluginManager", "startVoipVideoCall getNowStatus ".concat(String.valueOf(i)));
      if ((i != 4) && (i != 6))
      {
        com.tencent.mm.plugin.report.service.h.qsU.a(11518, true, true, new Object[] { Integer.valueOf(b.cLC().tyR.ttm.tvj.nMZ), Long.valueOf(b.cLC().tyR.ttm.tvj.nNa), Long.valueOf(b.cLC().tyR.ttm.cMb()), Integer.valueOf(4), Integer.valueOf(0) });
        com.tencent.mm.ui.base.h.a(paramContext, 2131304713, 2131304717, tyM);
        AppMethodBeat.o(4584);
        return;
      }
      if (!tyL)
      {
        Object localObject3;
        i.a locala;
        try
        {
          Object localObject1 = i.a.aeE((String)com.tencent.mm.kernel.g.RL().Ru().get(77829, null));
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
              com.tencent.mm.kernel.g.RL().Ru().set(77829, i.a.ah((Map)localObject1));
              localObject1 = ((Map)localObject1).entrySet().iterator();
              while (((Iterator)localObject1).hasNext())
              {
                localObject3 = (Map.Entry)((Iterator)localObject1).next();
                locala = (i.a)((Map.Entry)localObject3).getValue();
                ab.d("MicroMsg.VoipPluginManager", "val1 " + locala.hitCount + " " + locala.fMA + "name " + (String)((Map.Entry)localObject3).getKey());
              }
              InviteRemindDialog.o(paramContext, paramString, 0);
            }
          }
        }
        catch (Exception localException2)
        {
          ab.printErrStackTrace("MicroMsg.VoipPluginManager", localException2, "", new Object[0]);
        }
        for (;;)
        {
          cNw();
          AppMethodBeat.o(4584);
          return;
          localObject3 = new i.a();
          ((i.a)localObject3).hitCount += 1;
          localException2.put(paramString, localObject3);
          break;
          Object localObject2 = new HashMap();
          localObject3 = new i.a();
          ((i.a)localObject3).hitCount += 1;
          ((Map)localObject2).put(paramString, localObject3);
          com.tencent.mm.kernel.g.RL().Ru().set(77829, i.a.ah((Map)localObject2));
          localObject2 = ((Map)localObject2).entrySet().iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (Map.Entry)((Iterator)localObject2).next();
            locala = (i.a)((Map.Entry)localObject3).getValue();
            ab.d("MicroMsg.VoipPluginManager", "val2 " + locala.hitCount + " " + locala.fMA + "  name " + (String)((Map.Entry)localObject3).getKey());
          }
        }
      }
      if (!at.isWap(paramContext))
      {
        if ((at.isWifi(paramContext)) || (cNv()))
        {
          b.cLC().ba(paramContext, paramString);
          AppMethodBeat.o(4584);
          return;
        }
        com.tencent.mm.ui.base.h.a(paramContext, 2131304716, 2131304717, new r.1(paramContext, paramString), tyM);
        AppMethodBeat.o(4584);
        return;
      }
      com.tencent.mm.ui.base.h.a(paramContext, 2131304746, 0, 2131304747, 2131296888, new r.2(paramContext), tyM);
      AppMethodBeat.o(4584);
    }
  }
  
  public static void aW(Context paramContext, String paramString)
  {
    AppMethodBeat.i(4588);
    com.tencent.mm.m.g.Nr();
    int i;
    if (c.Nb() == 2) {
      i = 1;
    }
    for (;;)
    {
      com.tencent.mm.bq.d.dpU();
      if (i == 0) {
        ab.i("MicroMsg.VoipPluginManager", "showDouble %b, isLiteVersion: %b", new Object[] { Boolean.FALSE, Boolean.FALSE });
      }
      tyL = false;
      try
      {
        if (((j)com.tencent.mm.kernel.g.E(j.class)).bPQ().Tn(paramString) != null) {
          tyL = com.tencent.mm.plugin.voip.a.d.cPr();
        }
        aY(paramContext, paramString);
        AppMethodBeat.o(4588);
        return;
        i = 0;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.VoipPluginManager", localException, "", new Object[0]);
        }
      }
    }
  }
  
  public static void aX(Context paramContext, String paramString)
  {
    AppMethodBeat.i(4589);
    tyL = false;
    try
    {
      if (((j)com.tencent.mm.kernel.g.E(j.class)).bPQ().Tn(paramString) != null) {
        tyL = com.tencent.mm.plugin.voip.a.d.cPr();
      }
      aY(paramContext, paramString);
      AppMethodBeat.o(4589);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.VoipPluginManager", localException, "", new Object[0]);
      }
    }
  }
  
  private static void aY(Context paramContext, String paramString)
  {
    AppMethodBeat.i(4590);
    if (bo.isNullOrNil(paramString))
    {
      ab.e("MicroMsg.VoipPluginManager", "talker is null");
      AppMethodBeat.o(4590);
      return;
    }
    int i = com.tencent.mm.kernel.g.Rc().adt();
    ab.d("MicroMsg.VoipPluginManager", "startVoipVideoCall getNowStatus ".concat(String.valueOf(i)));
    if ((i != 4) && (i != 6))
    {
      com.tencent.mm.plugin.report.service.h.qsU.a(11518, true, true, new Object[] { Integer.valueOf(b.cLC().tyR.ttm.tvj.nMZ), Long.valueOf(b.cLC().tyR.ttm.tvj.nNa), Long.valueOf(b.cLC().tyR.ttm.cMb()), Integer.valueOf(4), Integer.valueOf(0) });
      com.tencent.mm.ui.base.h.a(paramContext, 2131304713, 2131304717, tyM);
      AppMethodBeat.o(4590);
      return;
    }
    if (!tyL)
    {
      Object localObject3;
      i.a locala;
      try
      {
        Object localObject1 = i.a.aeE((String)com.tencent.mm.kernel.g.RL().Ru().get(77829, null));
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
            com.tencent.mm.kernel.g.RL().Ru().set(77829, i.a.ah((Map)localObject1));
            localObject1 = ((Map)localObject1).entrySet().iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject3 = (Map.Entry)((Iterator)localObject1).next();
              locala = (i.a)((Map.Entry)localObject3).getValue();
              ab.d("MicroMsg.VoipPluginManager", "val1 " + locala.hitCount + " " + locala.fMA + "name " + (String)((Map.Entry)localObject3).getKey());
            }
            InviteRemindDialog.o(paramContext, paramString, 1);
          }
        }
      }
      catch (Exception localException)
      {
        ab.printErrStackTrace("MicroMsg.VoipPluginManager", localException, "", new Object[0]);
      }
      for (;;)
      {
        cNw();
        AppMethodBeat.o(4590);
        return;
        localObject3 = new i.a();
        ((i.a)localObject3).hitCount += 1;
        localException.put(paramString, localObject3);
        break;
        Object localObject2 = new HashMap();
        localObject3 = new i.a();
        ((i.a)localObject3).hitCount += 1;
        ((Map)localObject2).put(paramString, localObject3);
        com.tencent.mm.kernel.g.RL().Ru().set(77829, i.a.ah((Map)localObject2));
        localObject2 = ((Map)localObject2).entrySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (Map.Entry)((Iterator)localObject2).next();
          locala = (i.a)((Map.Entry)localObject3).getValue();
          ab.d("MicroMsg.VoipPluginManager", "val2 " + locala.hitCount + " " + locala.fMA + "  name " + (String)((Map.Entry)localObject3).getKey());
        }
      }
    }
    if (!at.isWap(paramContext))
    {
      if ((at.isWifi(paramContext)) || (cNv()))
      {
        b.cLC().aZ(paramContext, paramString);
        AppMethodBeat.o(4590);
        return;
      }
      b.cLC().aZ(paramContext, paramString);
      AppMethodBeat.o(4590);
      return;
    }
    com.tencent.mm.ui.base.h.a(paramContext, 2131304746, 0, 2131304747, 2131296888, new r.4(paramContext), tyM);
    AppMethodBeat.o(4590);
  }
  
  public static void cNu()
  {
    AppMethodBeat.i(4582);
    com.tencent.mm.kernel.g.RL().Ru().set(20480, Long.valueOf(System.currentTimeMillis()));
    AppMethodBeat.o(4582);
  }
  
  public static boolean cNv()
  {
    AppMethodBeat.i(4583);
    try
    {
      long l1 = System.currentTimeMillis();
      long l2 = ((Long)com.tencent.mm.kernel.g.RL().Ru().get(20480, Integer.valueOf(-1))).longValue();
      if (l2 < 0L)
      {
        AppMethodBeat.o(4583);
        return false;
      }
      l1 -= l2;
      ab.d("MicroMsg.VoipPluginManager", "diff is".concat(String.valueOf(l1)));
      if (l1 < 21600000L)
      {
        AppMethodBeat.o(4583);
        return true;
      }
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(4583);
    }
    return false;
  }
  
  private static void cNw()
  {
    AppMethodBeat.i(4585);
    ux localux = new ux();
    localux.cLs.cut = 8;
    a.ymk.l(localux);
    AppMethodBeat.o(4585);
  }
  
  public static void fh(Context paramContext)
  {
    AppMethodBeat.i(4586);
    try
    {
      Intent localIntent = new Intent("/");
      localIntent.setComponent(new ComponentName("com.android.settings", "com.android.settings.ApnSettings"));
      localIntent.setAction("android.intent.action.VIEW");
      paramContext.startActivity(localIntent);
      AppMethodBeat.o(4586);
      return;
    }
    catch (Exception localException)
    {
      searchIntentByClass(paramContext, "ApnSettings");
      AppMethodBeat.o(4586);
    }
  }
  
  private static Intent searchIntentByClass(Context paramContext, String paramString)
  {
    AppMethodBeat.i(4587);
    try
    {
      PackageManager localPackageManager = paramContext.getPackageManager();
      List localList = localPackageManager.getInstalledPackages(0);
      if ((localList != null) && (localList.size() > 0))
      {
        ab.e("MicroMsg.VoipPluginManager", "package  size" + localList.size());
        int i = 0;
        for (;;)
        {
          int j = localList.size();
          if (i >= j) {
            break label348;
          }
          try
          {
            ab.e("MicroMsg.VoipPluginManager", "package " + ((PackageInfo)localList.get(i)).packageName);
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
                  ab.e("MicroMsg.VoipPluginManager", "activityName count ".concat(String.valueOf(j)));
                  int k = 0;
                  for (;;)
                  {
                    if (k >= j) {
                      break label310;
                    }
                    localObject1 = ((ResolveInfo)((List)localObject2).get(k)).activityInfo;
                    if (((ActivityInfo)localObject1).name.contains(paramString))
                    {
                      localObject2 = new Intent("/");
                      ((Intent)localObject2).setComponent(new ComponentName(((ActivityInfo)localObject1).packageName, ((ActivityInfo)localObject1).name));
                      ((Intent)localObject2).setAction("android.intent.action.VIEW");
                      paramContext.startActivity((Intent)localObject2);
                      AppMethodBeat.o(4587);
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
                  ab.printErrStackTrace("MicroMsg.VoipPluginManager", localException1, "", new Object[0]);
                }
              }
            }
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              label310:
              ab.printErrStackTrace("MicroMsg.VoipPluginManager", localException2, "", new Object[0]);
            }
          }
        }
      }
      label348:
      return null;
    }
    catch (Exception paramContext)
    {
      ab.printErrStackTrace("MicroMsg.VoipPluginManager", paramContext, "", new Object[0]);
      AppMethodBeat.o(4587);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.r
 * JD-Core Version:    0.7.0.1
 */