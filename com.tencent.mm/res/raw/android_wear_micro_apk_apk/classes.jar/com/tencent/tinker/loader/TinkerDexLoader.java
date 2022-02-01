package com.tencent.tinker.loader;

import android.annotation.TargetApi;
import android.content.Intent;
import android.util.Log;
import com.tencent.tinker.loader.a.b;
import com.tencent.tinker.loader.a.c;
import com.tencent.tinker.loader.a.e;
import com.tencent.tinker.loader.a.f;
import com.tencent.tinker.loader.a.j;
import com.tencent.tinker.loader.a.k;
import com.tencent.tinker.loader.app.TinkerApplication;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TinkerDexLoader
{
  private static final ArrayList<c> anW = new ArrayList();
  private static HashSet<c> anX = new HashSet();
  private static boolean anY = k.pa();
  
  private static String a(c paramc)
  {
    if (anY) {
      return paramc.apx;
    }
    return paramc.apw;
  }
  
  @TargetApi(14)
  public static boolean a(TinkerApplication paramTinkerApplication, String paramString1, String paramString2, Intent paramIntent, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((anW.isEmpty()) && (anX.isEmpty()))
    {
      Log.w("Tinker.TinkerDexLoader", "there is no dex to load");
      return true;
    }
    BaseDexClassLoader localBaseDexClassLoader = (BaseDexClassLoader)TinkerDexLoader.class.getClassLoader();
    Object localObject1;
    ArrayList localArrayList;
    Object localObject2;
    if (localBaseDexClassLoader != null)
    {
      Log.i("Tinker.TinkerDexLoader", "classloader: " + localBaseDexClassLoader.toString());
      localObject1 = paramString1 + "/dex/";
      localArrayList = new ArrayList();
      localObject2 = anW.iterator();
    }
    Object localObject3;
    long l;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (c)((Iterator)localObject2).next();
      if (!b((c)localObject3))
      {
        File localFile = new File((String)localObject1 + ((c)localObject3).apD);
        if (paramTinkerApplication.isTinkerLoadVerifyFlag())
        {
          l = System.currentTimeMillis();
          if (!f.a(localFile, a((c)localObject3)))
          {
            e.a(paramIntent, -13);
            paramIntent.putExtra("intent_patch_mismatch_dex_path", localFile.getAbsolutePath());
            return false;
            Log.e("Tinker.TinkerDexLoader", "classloader is null");
            e.a(paramIntent, -12);
            return false;
          }
          Log.i("Tinker.TinkerDexLoader", "verify dex file:" + localFile.getPath() + " md5, use time: " + (System.currentTimeMillis() - l));
        }
        localArrayList.add(localFile);
      }
    }
    if ((anY) && (!anX.isEmpty()))
    {
      localObject1 = new File((String)localObject1 + "tinker_classN.apk");
      l = System.currentTimeMillis();
      if (paramTinkerApplication.isTinkerLoadVerifyFlag())
      {
        localObject2 = anX.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (c)((Iterator)localObject2).next();
          if (!f.a((File)localObject1, ((c)localObject3).apv, ((c)localObject3).apx))
          {
            e.a(paramIntent, -13);
            paramIntent.putExtra("intent_patch_mismatch_dex_path", ((File)localObject1).getAbsolutePath());
            return false;
          }
        }
      }
      Log.i("Tinker.TinkerDexLoader", "verify dex file:" + ((File)localObject1).getPath() + " md5, use time: " + (System.currentTimeMillis() - l));
      localArrayList.add(localObject1);
    }
    paramString2 = new File(paramString1 + "/" + paramString2);
    if (paramBoolean1)
    {
      localObject1 = new boolean[1];
      localObject1[0] = 1;
      localObject2 = new Throwable[1];
      try
      {
        localObject3 = k.pc();
        ad(paramString1);
        Log.w("Tinker.TinkerDexLoader", "systemOTA, try parallel oat dexes, targetISA:".concat(String.valueOf(localObject3)));
        paramString2 = new File(paramString1 + "/interpet");
        TinkerDexOptimizer.a(localArrayList, paramString2, (String)localObject3, new TinkerDexOptimizer.ResultCallback()
        {
          long alC;
          
          public final void b(File paramAnonymousFile, Throwable paramAnonymousThrowable)
          {
            TinkerDexLoader.this[0] = false;
            this.aoa[0] = paramAnonymousThrowable;
            Log.i("Tinker.TinkerDexLoader", "fail to optimize dex " + paramAnonymousFile.getPath() + ", use time " + (System.currentTimeMillis() - this.alC));
          }
          
          public final void g(File paramAnonymousFile)
          {
            this.alC = System.currentTimeMillis();
            Log.i("Tinker.TinkerDexLoader", "start to optimize dex:" + paramAnonymousFile.getPath());
          }
          
          public final void h(File paramAnonymousFile)
          {
            Log.i("Tinker.TinkerDexLoader", "success to optimize dex " + paramAnonymousFile.getPath() + ", use time " + (System.currentTimeMillis() - this.alC));
          }
        });
        if (localObject1[0] == 0)
        {
          Log.e("Tinker.TinkerDexLoader", "parallel oat dexes failed");
          paramIntent.putExtra("intent_patch_interpret_exception", localObject2[0]);
          e.a(paramIntent, -16);
          return false;
        }
      }
      catch (Throwable paramTinkerApplication)
      {
        Log.i("Tinker.TinkerDexLoader", "getCurrentInstructionSet fail:".concat(String.valueOf(paramTinkerApplication)));
        ad(paramString1);
        paramIntent.putExtra("intent_patch_interpret_exception", paramTinkerApplication);
        e.a(paramIntent, -15);
        return false;
      }
    }
    try
    {
      SystemClassLoaderAdder.a(paramTinkerApplication, localBaseDexClassLoader, paramString2, localArrayList, paramBoolean2);
      return true;
    }
    catch (Throwable paramTinkerApplication)
    {
      Log.e("Tinker.TinkerDexLoader", "install dexes failed");
      paramIntent.putExtra("intent_patch_exception", paramTinkerApplication);
      e.a(paramIntent, -14);
    }
    return false;
  }
  
  public static boolean a(String paramString1, j paramj, String paramString2, Intent paramIntent)
  {
    Object localObject = (String)paramj.oY().get("assets/dex_meta.txt");
    if (localObject == null) {
      return true;
    }
    anW.clear();
    anX.clear();
    paramj = new ArrayList();
    c.c((String)localObject, paramj);
    if (paramj.isEmpty()) {
      return true;
    }
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramj.iterator();
    paramj = null;
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      if (!b(localc))
      {
        int i;
        if (localc == null) {
          i = 0;
        }
        while (i == 0)
        {
          paramIntent.putExtra("intent_patch_package_patch_check", -3);
          e.a(paramIntent, -8);
          return false;
          String str = localc.apv;
          if (k.pa()) {}
          for (localObject = localc.apx;; localObject = localc.apw)
          {
            if ((str != null) && (str.length() > 0) && (localObject != null) && (((String)localObject).length() == 32)) {
              break label198;
            }
            i = 0;
            break;
          }
          label198:
          i = 1;
        }
        if ((anY) && (localc.apv.startsWith("test.dex")))
        {
          paramj = localc;
        }
        else if ((anY) && (b.apu.matcher(localc.apD).matches()))
        {
          anX.add(localc);
        }
        else
        {
          localHashMap.put(localc.apD, a(localc));
          anW.add(localc);
        }
      }
    }
    if ((anY) && ((paramj != null) || (!anX.isEmpty())))
    {
      if (paramj != null) {
        anX.add(k.a(paramj, anX.size() + 1));
      }
      localHashMap.put("tinker_classN.apk", "");
    }
    paramj = paramString1 + "/dex/";
    localObject = new File(paramj);
    if ((!((File)localObject).exists()) || (!((File)localObject).isDirectory()))
    {
      e.a(paramIntent, -9);
      return false;
    }
    paramString1 = new File(paramString1 + "/" + paramString2 + "/");
    paramString2 = localHashMap.keySet().iterator();
    while (paramString2.hasNext())
    {
      localObject = (String)paramString2.next();
      localObject = new File(paramj + (String)localObject);
      if (!f.j((File)localObject))
      {
        paramIntent.putExtra("intent_patch_missing_dex_path", ((File)localObject).getAbsolutePath());
        e.a(paramIntent, -10);
        return false;
      }
      localObject = new File(f.c((File)localObject, paramString1));
      if ((!f.j((File)localObject)) && (!f.k((File)localObject)))
      {
        paramIntent.putExtra("intent_patch_missing_dex_path", ((File)localObject).getAbsolutePath());
        e.a(paramIntent, -11);
        return false;
      }
    }
    paramIntent.putExtra("intent_patch_dexes_path", localHashMap);
    return true;
  }
  
  private static void ad(String paramString)
  {
    f.al(paramString + "/odex/");
    if (k.pb()) {
      f.al(paramString + "/dex/oat" + "/");
    }
  }
  
  private static boolean b(c paramc)
  {
    if (anY) {}
    while (!paramc.apw.equals("0")) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.tinker.loader.TinkerDexLoader
 * JD-Core Version:    0.7.0.1
 */