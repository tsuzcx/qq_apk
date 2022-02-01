package com.tencent.tinker.loader;

import android.content.Intent;
import com.tencent.tinker.loader.shareutil.ShareBsDiffPatchInfo;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareSecurityCheck;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class TinkerSoLoader
{
  protected static final String SO_MEAT_FILE = "assets/so_meta.txt";
  protected static final String SO_PATH = "lib";
  private static final String TAG = "Tinker.TinkerSoLoader";
  
  public static boolean checkComplete(String paramString, ShareSecurityCheck paramShareSecurityCheck, Intent paramIntent)
  {
    paramShareSecurityCheck = (String)paramShareSecurityCheck.getMetaContentMap().get("assets/so_meta.txt");
    if (paramShareSecurityCheck == null) {
      return true;
    }
    Object localObject1 = new ArrayList();
    ShareBsDiffPatchInfo.parseDiffPatchInfo(paramShareSecurityCheck, (ArrayList)localObject1);
    if (((ArrayList)localObject1).isEmpty()) {
      return true;
    }
    paramString = paramString + "/lib/";
    paramShareSecurityCheck = new HashMap();
    localObject1 = ((ArrayList)localObject1).iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (ShareBsDiffPatchInfo)((Iterator)localObject1).next();
      if (!ShareBsDiffPatchInfo.checkDiffPatchInfo((ShareBsDiffPatchInfo)localObject2))
      {
        paramIntent.putExtra("intent_patch_package_patch_check", -4);
        ShareIntentUtil.setIntentReturnCode(paramIntent, -8);
        return false;
      }
      paramShareSecurityCheck.put(((ShareBsDiffPatchInfo)localObject2).path + "/" + ((ShareBsDiffPatchInfo)localObject2).name, ((ShareBsDiffPatchInfo)localObject2).md5);
    }
    localObject1 = new File(paramString);
    if ((!((File)localObject1).exists()) || (!((File)localObject1).isDirectory()))
    {
      ShareIntentUtil.setIntentReturnCode(paramIntent, -17);
      return false;
    }
    localObject1 = paramShareSecurityCheck.keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      localObject2 = new File(paramString + (String)localObject2);
      if (!SharePatchFileUtil.isLegalFile((File)localObject2))
      {
        ShareIntentUtil.setIntentReturnCode(paramIntent, -18);
        paramIntent.putExtra("intent_patch_missing_lib_path", ((File)localObject2).getAbsolutePath());
        return false;
      }
    }
    paramIntent.putExtra("intent_patch_libs_path", paramShareSecurityCheck);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.loader.TinkerSoLoader
 * JD-Core Version:    0.7.0.1
 */