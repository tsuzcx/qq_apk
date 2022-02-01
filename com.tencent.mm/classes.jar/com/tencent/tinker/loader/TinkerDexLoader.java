package com.tencent.tinker.loader;

import android.content.Intent;
import com.tencent.tinker.loader.app.TinkerApplication;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.tinker.loader.shareutil.ShareDexDiffPatchInfo;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareSecurityCheck;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
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
  private static final String DEFAULT_DEX_OPTIMIZE_PATH = "odex";
  private static final String DEX_MEAT_FILE = "assets/dex_meta.txt";
  private static final String DEX_PATH = "dex";
  private static final String INTERPRET_DEX_OPTIMIZE_PATH = "interpet";
  private static final ArrayList<ShareDexDiffPatchInfo> LOAD_DEX_LIST = new ArrayList();
  private static final String TAG = "Tinker.TinkerDexLoader";
  private static HashSet<ShareDexDiffPatchInfo> classNDexInfo = new HashSet();
  private static boolean isVmArt = ShareTinkerInternals.isVmArt();
  
  public static boolean checkComplete(String paramString1, ShareSecurityCheck paramShareSecurityCheck, String paramString2, Intent paramIntent)
  {
    Object localObject = (String)paramShareSecurityCheck.getMetaContentMap().get("assets/dex_meta.txt");
    if (localObject == null) {
      return true;
    }
    LOAD_DEX_LIST.clear();
    classNDexInfo.clear();
    paramShareSecurityCheck = new ArrayList();
    ShareDexDiffPatchInfo.parseDexDiffPatchInfo((String)localObject, paramShareSecurityCheck);
    if (paramShareSecurityCheck.isEmpty()) {
      return true;
    }
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramShareSecurityCheck.iterator();
    paramShareSecurityCheck = null;
    while (localIterator.hasNext())
    {
      localObject = (ShareDexDiffPatchInfo)localIterator.next();
      if (!isJustArtSupportDex((ShareDexDiffPatchInfo)localObject))
      {
        if (!ShareDexDiffPatchInfo.checkDexDiffPatchInfo((ShareDexDiffPatchInfo)localObject))
        {
          paramIntent.putExtra("intent_patch_package_patch_check", -3);
          ShareIntentUtil.setIntentReturnCode(paramIntent, -8);
          return false;
        }
        if ((isVmArt) && (((ShareDexDiffPatchInfo)localObject).rawName.startsWith("test.dex")))
        {
          paramShareSecurityCheck = (ShareSecurityCheck)localObject;
        }
        else if ((isVmArt) && (ShareConstants.CLASS_N_PATTERN.matcher(((ShareDexDiffPatchInfo)localObject).realName).matches()))
        {
          classNDexInfo.add(localObject);
        }
        else
        {
          localHashMap.put(((ShareDexDiffPatchInfo)localObject).realName, getInfoMd5((ShareDexDiffPatchInfo)localObject));
          LOAD_DEX_LIST.add(localObject);
        }
      }
    }
    if ((isVmArt) && ((paramShareSecurityCheck != null) || (!classNDexInfo.isEmpty())))
    {
      if (paramShareSecurityCheck != null) {
        classNDexInfo.add(ShareTinkerInternals.changeTestDexToClassN(paramShareSecurityCheck, classNDexInfo.size() + 1));
      }
      localHashMap.put("tinker_classN.apk", "");
    }
    paramShareSecurityCheck = paramString1 + "/dex/";
    localObject = new File(paramShareSecurityCheck);
    if ((!((File)localObject).exists()) || (!((File)localObject).isDirectory()))
    {
      ShareIntentUtil.setIntentReturnCode(paramIntent, -9);
      return false;
    }
    paramString1 = new File(paramString1 + "/" + paramString2 + "/");
    paramString2 = localHashMap.keySet().iterator();
    while (paramString2.hasNext())
    {
      localObject = (String)paramString2.next();
      localObject = new File(paramShareSecurityCheck + (String)localObject);
      if (!SharePatchFileUtil.isLegalFile((File)localObject))
      {
        paramIntent.putExtra("intent_patch_missing_dex_path", ((File)localObject).getAbsolutePath());
        ShareIntentUtil.setIntentReturnCode(paramIntent, -10);
        return false;
      }
      localObject = new File(SharePatchFileUtil.optimizedPathFor((File)localObject, paramString1));
      if ((!SharePatchFileUtil.isLegalFile((File)localObject)) && (!SharePatchFileUtil.shouldAcceptEvenIfIllegal((File)localObject)))
      {
        paramIntent.putExtra("intent_patch_missing_dex_path", ((File)localObject).getAbsolutePath());
        ShareIntentUtil.setIntentReturnCode(paramIntent, -11);
        return false;
      }
    }
    paramIntent.putExtra("intent_patch_dexes_path", localHashMap);
    return true;
  }
  
  private static void deleteOutOfDateOATFile(String paramString)
  {
    SharePatchFileUtil.deleteDir(paramString + "/odex/");
    if (ShareTinkerInternals.isAfterAndroidO()) {
      SharePatchFileUtil.deleteDir(paramString + "/dex/oat/");
    }
  }
  
  private static String getInfoMd5(ShareDexDiffPatchInfo paramShareDexDiffPatchInfo)
  {
    if (isVmArt) {
      return paramShareDexDiffPatchInfo.destMd5InArt;
    }
    return paramShareDexDiffPatchInfo.destMd5InDvm;
  }
  
  private static boolean isJustArtSupportDex(ShareDexDiffPatchInfo paramShareDexDiffPatchInfo)
  {
    if (isVmArt) {}
    while (!paramShareDexDiffPatchInfo.destMd5InDvm.equals("0")) {
      return false;
    }
    return true;
  }
  
  public static boolean loadTinkerJars(TinkerApplication paramTinkerApplication, String paramString1, String paramString2, Intent paramIntent, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((LOAD_DEX_LIST.isEmpty()) && (classNDexInfo.isEmpty()))
    {
      ShareTinkerLog.w("Tinker.TinkerDexLoader", "there is no dex to load", new Object[0]);
      return true;
    }
    ClassLoader localClassLoader = TinkerDexLoader.class.getClassLoader();
    Object localObject1;
    ArrayList localArrayList;
    Object localObject2;
    if (localClassLoader != null)
    {
      ShareTinkerLog.i("Tinker.TinkerDexLoader", "classloader: " + localClassLoader.toString(), new Object[0]);
      localObject1 = paramString1 + "/dex/";
      localArrayList = new ArrayList();
      localObject2 = LOAD_DEX_LIST.iterator();
    }
    Object localObject3;
    long l;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (ShareDexDiffPatchInfo)((Iterator)localObject2).next();
      if (!isJustArtSupportDex((ShareDexDiffPatchInfo)localObject3))
      {
        File localFile = new File((String)localObject1 + ((ShareDexDiffPatchInfo)localObject3).realName);
        if (paramTinkerApplication.isTinkerLoadVerifyFlag())
        {
          l = System.currentTimeMillis();
          if (!SharePatchFileUtil.verifyDexFileMd5(localFile, getInfoMd5((ShareDexDiffPatchInfo)localObject3)))
          {
            ShareIntentUtil.setIntentReturnCode(paramIntent, -13);
            paramIntent.putExtra("intent_patch_mismatch_dex_path", localFile.getAbsolutePath());
            return false;
            ShareTinkerLog.e("Tinker.TinkerDexLoader", "classloader is null", new Object[0]);
            ShareIntentUtil.setIntentReturnCode(paramIntent, -12);
            return false;
          }
          ShareTinkerLog.i("Tinker.TinkerDexLoader", "verify dex file:" + localFile.getPath() + " md5, use time: " + (System.currentTimeMillis() - l), new Object[0]);
        }
        localArrayList.add(localFile);
      }
    }
    if ((isVmArt) && (!classNDexInfo.isEmpty()))
    {
      localObject1 = new File((String)localObject1 + "tinker_classN.apk");
      l = System.currentTimeMillis();
      if (paramTinkerApplication.isTinkerLoadVerifyFlag())
      {
        localObject2 = classNDexInfo.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (ShareDexDiffPatchInfo)((Iterator)localObject2).next();
          if (!SharePatchFileUtil.verifyDexFileMd5((File)localObject1, ((ShareDexDiffPatchInfo)localObject3).rawName, ((ShareDexDiffPatchInfo)localObject3).destMd5InArt))
          {
            ShareIntentUtil.setIntentReturnCode(paramIntent, -13);
            paramIntent.putExtra("intent_patch_mismatch_dex_path", ((File)localObject1).getAbsolutePath());
            return false;
          }
        }
      }
      ShareTinkerLog.i("Tinker.TinkerDexLoader", "verify dex file:" + ((File)localObject1).getPath() + " md5, use time: " + (System.currentTimeMillis() - l), new Object[0]);
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
        localObject3 = ShareTinkerInternals.getCurrentInstructionSet();
        deleteOutOfDateOATFile(paramString1);
        ShareTinkerLog.w("Tinker.TinkerDexLoader", "systemOTA, try parallel oat dexes, targetISA:".concat(String.valueOf(localObject3)), new Object[0]);
        paramString2 = new File(paramString1 + "/interpet");
        TinkerDexOptimizer.optimizeAll(paramTinkerApplication, localArrayList, paramString2, true, paramTinkerApplication.isUseDelegateLastClassLoader(), (String)localObject3, new TinkerDexOptimizer.ResultCallback()
        {
          long start;
          
          public final void onFailed(File paramAnonymousFile1, File paramAnonymousFile2, Throwable paramAnonymousThrowable)
          {
            this.val$parallelOTAResult[0] = false;
            this.val$parallelOTAThrowable[0] = paramAnonymousThrowable;
            ShareTinkerLog.i("Tinker.TinkerDexLoader", "fail to optimize dex " + paramAnonymousFile1.getPath() + ", use time " + (System.currentTimeMillis() - this.start), new Object[0]);
          }
          
          public final void onStart(File paramAnonymousFile1, File paramAnonymousFile2)
          {
            this.start = System.currentTimeMillis();
            ShareTinkerLog.i("Tinker.TinkerDexLoader", "start to optimize dex:" + paramAnonymousFile1.getPath(), new Object[0]);
          }
          
          public final void onSuccess(File paramAnonymousFile1, File paramAnonymousFile2, File paramAnonymousFile3)
          {
            ShareTinkerLog.i("Tinker.TinkerDexLoader", "success to optimize dex " + paramAnonymousFile1.getPath() + ", use time " + (System.currentTimeMillis() - this.start), new Object[0]);
          }
        });
        if (localObject1[0] == 0)
        {
          ShareTinkerLog.e("Tinker.TinkerDexLoader", "parallel oat dexes failed", new Object[0]);
          paramIntent.putExtra("intent_patch_interpret_exception", localObject2[0]);
          ShareIntentUtil.setIntentReturnCode(paramIntent, -16);
          return false;
        }
      }
      finally
      {
        ShareTinkerLog.i("Tinker.TinkerDexLoader", "getCurrentInstructionSet fail:".concat(String.valueOf(paramTinkerApplication)), new Object[0]);
        deleteOutOfDateOATFile(paramString1);
        paramIntent.putExtra("intent_patch_interpret_exception", paramTinkerApplication);
        ShareIntentUtil.setIntentReturnCode(paramIntent, -15);
        return false;
      }
    }
    try
    {
      SystemClassLoaderAdder.installDexes(paramTinkerApplication, localClassLoader, paramString2, localArrayList, paramBoolean2, paramTinkerApplication.isUseDelegateLastClassLoader());
      return true;
    }
    finally
    {
      ShareTinkerLog.e("Tinker.TinkerDexLoader", "install dexes failed", new Object[0]);
      paramIntent.putExtra("intent_patch_exception", paramTinkerApplication);
      ShareIntentUtil.setIntentReturnCode(paramIntent, -14);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tinker.loader.TinkerDexLoader
 * JD-Core Version:    0.7.0.1
 */