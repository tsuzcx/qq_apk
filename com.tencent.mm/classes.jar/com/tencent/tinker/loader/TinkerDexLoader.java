package com.tencent.tinker.loader;

import android.annotation.TargetApi;
import android.content.Intent;
import com.tencent.tinker.loader.app.TinkerApplication;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.tinker.loader.shareutil.ShareDexDiffPatchInfo;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareSecurityCheck;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
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
  private static boolean BsB = ShareTinkerInternals.dWE();
  private static final ArrayList<ShareDexDiffPatchInfo> BtC = new ArrayList();
  private static HashSet<ShareDexDiffPatchInfo> BtD = new HashSet();
  
  private static String a(ShareDexDiffPatchInfo paramShareDexDiffPatchInfo)
  {
    if (BsB) {
      return paramShareDexDiffPatchInfo.BuS;
    }
    return paramShareDexDiffPatchInfo.BuR;
  }
  
  @TargetApi(14)
  public static boolean a(TinkerApplication paramTinkerApplication, String paramString1, String paramString2, Intent paramIntent, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((BtC.isEmpty()) && (BtD.isEmpty())) {
      return true;
    }
    BaseDexClassLoader localBaseDexClassLoader = (BaseDexClassLoader)TinkerDexLoader.class.getClassLoader();
    Object localObject1;
    ArrayList localArrayList;
    Object localObject2;
    if (localBaseDexClassLoader != null)
    {
      new StringBuilder("classloader: ").append(localBaseDexClassLoader.toString());
      localObject1 = paramString1 + "/dex/";
      localArrayList = new ArrayList();
      localObject2 = BtC.iterator();
    }
    Object localObject3;
    long l;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (ShareDexDiffPatchInfo)((Iterator)localObject2).next();
      if (!b((ShareDexDiffPatchInfo)localObject3))
      {
        File localFile = new File((String)localObject1 + ((ShareDexDiffPatchInfo)localObject3).ezj);
        if (paramTinkerApplication.isTinkerLoadVerifyFlag())
        {
          l = System.currentTimeMillis();
          if (!SharePatchFileUtil.i(localFile, a((ShareDexDiffPatchInfo)localObject3)))
          {
            ShareIntentUtil.b(paramIntent, -13);
            paramIntent.putExtra("intent_patch_mismatch_dex_path", localFile.getAbsolutePath());
            return false;
            ShareIntentUtil.b(paramIntent, -12);
            return false;
          }
          new StringBuilder("verify dex file:").append(localFile.getPath()).append(" md5, use time: ").append(System.currentTimeMillis() - l);
        }
        localArrayList.add(localFile);
      }
    }
    if ((BsB) && (!BtD.isEmpty()))
    {
      localObject1 = new File((String)localObject1 + "tinker_classN.apk");
      l = System.currentTimeMillis();
      if (paramTinkerApplication.isTinkerLoadVerifyFlag())
      {
        localObject2 = BtD.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (ShareDexDiffPatchInfo)((Iterator)localObject2).next();
          if (!SharePatchFileUtil.b((File)localObject1, ((ShareDexDiffPatchInfo)localObject3).BuQ, ((ShareDexDiffPatchInfo)localObject3).BuS))
          {
            ShareIntentUtil.b(paramIntent, -13);
            paramIntent.putExtra("intent_patch_mismatch_dex_path", ((File)localObject1).getAbsolutePath());
            return false;
          }
        }
      }
      new StringBuilder("verify dex file:").append(((File)localObject1).getPath()).append(" md5, use time: ").append(System.currentTimeMillis() - l);
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
        localObject3 = ShareTinkerInternals.dWH();
        awW(paramString1);
        paramString2 = new File(paramString1 + "/interpet");
        TinkerDexOptimizer.a(localArrayList, paramString2, true, (String)localObject3, new TinkerDexOptimizer.ResultCallback()
        {
          long start;
          
          public final void ag(File paramAnonymousFile)
          {
            this.start = System.currentTimeMillis();
            new StringBuilder("start to optimize dex:").append(paramAnonymousFile.getPath());
          }
          
          public final void b(File paramAnonymousFile, Throwable paramAnonymousThrowable)
          {
            this.BtE[0] = false;
            this.BtF[0] = paramAnonymousThrowable;
            new StringBuilder("fail to optimize dex ").append(paramAnonymousFile.getPath()).append(", use time ").append(System.currentTimeMillis() - this.start);
          }
          
          public final void i(File paramAnonymousFile1, File paramAnonymousFile2)
          {
            new StringBuilder("success to optimize dex ").append(paramAnonymousFile1.getPath()).append(", use time ").append(System.currentTimeMillis() - this.start);
          }
        });
        if (localObject1[0] == 0)
        {
          paramIntent.putExtra("intent_patch_interpret_exception", localObject2[0]);
          ShareIntentUtil.b(paramIntent, -16);
          return false;
        }
      }
      catch (Throwable paramTinkerApplication)
      {
        new StringBuilder("getCurrentInstructionSet fail:").append(paramTinkerApplication);
        awW(paramString1);
        paramIntent.putExtra("intent_patch_interpret_exception", paramTinkerApplication);
        ShareIntentUtil.b(paramIntent, -15);
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
      paramIntent.putExtra("intent_patch_exception", paramTinkerApplication);
      ShareIntentUtil.b(paramIntent, -14);
    }
    return false;
  }
  
  public static boolean a(String paramString1, ShareSecurityCheck paramShareSecurityCheck, String paramString2, Intent paramIntent)
  {
    Object localObject = (String)paramShareSecurityCheck.Bwk.get("assets/dex_meta.txt");
    if (localObject == null) {
      return true;
    }
    BtC.clear();
    BtD.clear();
    paramShareSecurityCheck = new ArrayList();
    ShareDexDiffPatchInfo.o((String)localObject, paramShareSecurityCheck);
    if (paramShareSecurityCheck.isEmpty()) {
      return true;
    }
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramShareSecurityCheck.iterator();
    paramShareSecurityCheck = null;
    while (localIterator.hasNext())
    {
      localObject = (ShareDexDiffPatchInfo)localIterator.next();
      if (!b((ShareDexDiffPatchInfo)localObject))
      {
        if (!ShareDexDiffPatchInfo.c((ShareDexDiffPatchInfo)localObject))
        {
          paramIntent.putExtra("intent_patch_package_patch_check", -3);
          ShareIntentUtil.b(paramIntent, -8);
          return false;
        }
        if ((BsB) && (((ShareDexDiffPatchInfo)localObject).BuQ.startsWith("test.dex")))
        {
          paramShareSecurityCheck = (ShareSecurityCheck)localObject;
        }
        else if ((BsB) && (ShareConstants.BuP.matcher(((ShareDexDiffPatchInfo)localObject).ezj).matches()))
        {
          BtD.add(localObject);
        }
        else
        {
          localHashMap.put(((ShareDexDiffPatchInfo)localObject).ezj, a((ShareDexDiffPatchInfo)localObject));
          BtC.add(localObject);
        }
      }
    }
    if ((BsB) && ((paramShareSecurityCheck != null) || (!BtD.isEmpty())))
    {
      if (paramShareSecurityCheck != null) {
        BtD.add(ShareTinkerInternals.a(paramShareSecurityCheck, BtD.size() + 1));
      }
      localHashMap.put("tinker_classN.apk", "");
    }
    paramShareSecurityCheck = paramString1 + "/dex/";
    localObject = new File(paramShareSecurityCheck);
    if ((!((File)localObject).exists()) || (!((File)localObject).isDirectory()))
    {
      ShareIntentUtil.b(paramIntent, -9);
      return false;
    }
    paramString1 = new File(paramString1 + "/" + paramString2 + "/");
    paramString2 = localHashMap.keySet().iterator();
    while (paramString2.hasNext())
    {
      localObject = (String)paramString2.next();
      localObject = new File(paramShareSecurityCheck + (String)localObject);
      if (!SharePatchFileUtil.an((File)localObject))
      {
        paramIntent.putExtra("intent_patch_missing_dex_path", ((File)localObject).getAbsolutePath());
        ShareIntentUtil.b(paramIntent, -10);
        return false;
      }
      localObject = new File(SharePatchFileUtil.k((File)localObject, paramString1));
      if ((!SharePatchFileUtil.an((File)localObject)) && (!SharePatchFileUtil.ao((File)localObject)))
      {
        paramIntent.putExtra("intent_patch_missing_dex_path", ((File)localObject).getAbsolutePath());
        ShareIntentUtil.b(paramIntent, -11);
        return false;
      }
    }
    paramIntent.putExtra("intent_patch_dexes_path", localHashMap);
    return true;
  }
  
  private static void awW(String paramString)
  {
    SharePatchFileUtil.cO(paramString + "/odex/");
    if (ShareTinkerInternals.dWG()) {
      SharePatchFileUtil.cO(paramString + "/dex/oat/");
    }
  }
  
  private static boolean b(ShareDexDiffPatchInfo paramShareDexDiffPatchInfo)
  {
    if (BsB) {}
    while (!paramShareDexDiffPatchInfo.BuR.equals("0")) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.loader.TinkerDexLoader
 * JD-Core Version:    0.7.0.1
 */