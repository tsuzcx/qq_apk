package com.tencent.tinker.loader;

import android.annotation.TargetApi;
import android.content.Intent;
import com.tencent.tinker.loader.app.TinkerApplication;
import com.tencent.tinker.loader.shareutil.ShareArkHotDiffPatchInfo;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareSecurityCheck;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TinkerArkHotLoader
{
  private static final String ARKHOT_PATH = "arkHot";
  private static final String ARK_MEAT_FILE = "assets/arkHot_meta.txt";
  private static final String TAG = "Tinker.TinkerArkHotLoader";
  private static HashSet<ShareArkHotDiffPatchInfo> arkHotApkInfo = new HashSet();
  private static boolean isArkHotRuning = ShareTinkerInternals.isArkHotRuning();
  
  public static boolean checkComplete(String paramString, ShareSecurityCheck paramShareSecurityCheck, Intent paramIntent)
  {
    paramShareSecurityCheck = (String)paramShareSecurityCheck.getMetaContentMap().get("assets/arkHot_meta.txt");
    if (paramShareSecurityCheck == null) {
      return true;
    }
    arkHotApkInfo.clear();
    Object localObject1 = new ArrayList();
    ShareArkHotDiffPatchInfo.parseDiffPatchInfo(paramShareSecurityCheck, (ArrayList)localObject1);
    if (((ArrayList)localObject1).isEmpty()) {
      return true;
    }
    paramShareSecurityCheck = new HashMap(1);
    localObject1 = ((ArrayList)localObject1).iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (ShareArkHotDiffPatchInfo)((Iterator)localObject1).next();
      if (!ShareArkHotDiffPatchInfo.checkDiffPatchInfo((ShareArkHotDiffPatchInfo)localObject2))
      {
        paramIntent.putExtra("intent_patch_package_patch_check", -3);
        ShareIntentUtil.setIntentReturnCode(paramIntent, -8);
        return false;
      }
      if ((isArkHotRuning) && ("patch.apk".equals(((ShareArkHotDiffPatchInfo)localObject2).name))) {
        arkHotApkInfo.add(localObject2);
      }
    }
    if ((isArkHotRuning) && (!arkHotApkInfo.isEmpty())) {
      paramShareSecurityCheck.put("patch.apk", "");
    }
    paramString = paramString + "/arkHot/";
    localObject1 = new File(paramString);
    if ((!((File)localObject1).exists()) || (!((File)localObject1).isDirectory()))
    {
      ShareIntentUtil.setIntentReturnCode(paramIntent, -9);
      return false;
    }
    localObject1 = paramShareSecurityCheck.keySet().iterator();
    do
    {
      if (!((Iterator)localObject1).hasNext()) {
        break;
      }
      localObject2 = (String)((Iterator)localObject1).next();
      localObject2 = new File(paramString + (String)localObject2);
    } while (SharePatchFileUtil.isLegalFile((File)localObject2));
    try
    {
      paramIntent.putExtra("intent_patch_missing_dex_path", ((File)localObject2).getCanonicalPath());
      label290:
      ShareIntentUtil.setIntentReturnCode(paramIntent, -10);
      return false;
      paramIntent.putExtra("intent_patch_dexes_path", paramShareSecurityCheck);
      return true;
    }
    catch (IOException paramString)
    {
      break label290;
    }
  }
  
  @TargetApi(14)
  public static boolean loadTinkerArkHot(TinkerApplication paramTinkerApplication, String paramString, Intent paramIntent)
  {
    if (arkHotApkInfo.isEmpty())
    {
      ShareTinkerLog.w("Tinker.TinkerArkHotLoader", "there is no apk to load", new Object[0]);
      return true;
    }
    paramTinkerApplication = (PathClassLoader)TinkerArkHotLoader.class.getClassLoader();
    ArrayList localArrayList;
    if (paramTinkerApplication != null)
    {
      ShareTinkerLog.i("Tinker.TinkerArkHotLoader", "classloader: " + paramTinkerApplication.toString(), new Object[0]);
      paramString = paramString + "/arkHot/";
      localArrayList = new ArrayList();
      if ((isArkHotRuning) && (!arkHotApkInfo.isEmpty())) {
        localArrayList.add(new File(paramString + "patch.apk"));
      }
    }
    try
    {
      SystemClassLoaderAdder.installApk(paramTinkerApplication, localArrayList);
      return true;
    }
    catch (Throwable paramTinkerApplication)
    {
      ShareTinkerLog.e("Tinker.TinkerArkHotLoader", "install dexes failed", new Object[0]);
      paramIntent.putExtra("intent_patch_exception", paramTinkerApplication);
      ShareIntentUtil.setIntentReturnCode(paramIntent, -14);
    }
    ShareTinkerLog.e("Tinker.TinkerArkHotLoader", "classloader is null", new Object[0]);
    ShareIntentUtil.setIntentReturnCode(paramIntent, -12);
    return false;
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tinker.loader.TinkerArkHotLoader
 * JD-Core Version:    0.7.0.1
 */