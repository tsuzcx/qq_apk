package com.tencent.tinker.loader;

import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.tencent.tinker.loader.app.TinkerApplication;
import com.tencent.tinker.loader.hotplug.ComponentHotplug;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.tencent.tinker.loader.shareutil.ShareSecurityCheck;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;

public class TinkerLoader
  extends AbstractTinkerLoader
{
  private static final String TAG = "Tinker.TinkerLoader";
  private SharePatchInfo patchInfo;
  
  private boolean checkSafeModeCount(TinkerApplication paramTinkerApplication)
  {
    int i = ShareTinkerInternals.jG(paramTinkerApplication);
    if (i >= 2)
    {
      ShareTinkerInternals.aG(paramTinkerApplication, 0);
      return false;
    }
    paramTinkerApplication.setUseSafeMode(true);
    ShareTinkerInternals.aG(paramTinkerApplication, i + 1);
    return true;
  }
  
  private void tryLoadPatchFilesInternal(TinkerApplication paramTinkerApplication, Intent paramIntent)
  {
    int j = paramTinkerApplication.getTinkerFlags();
    if (!ShareTinkerInternals.Ti(j)) {
      ShareIntentUtil.b(paramIntent, -1);
    }
    Object localObject3;
    File localFile1;
    File localFile2;
    String str1;
    boolean bool2;
    int i;
    boolean bool4;
    boolean bool5;
    do
    {
      boolean bool3;
      do
      {
        Object localObject1;
        Object localObject2;
        String str2;
        boolean bool6;
        do
        {
          do
          {
            return;
            if (ShareTinkerInternals.jI(paramTinkerApplication))
            {
              ShareIntentUtil.b(paramIntent, -1);
              return;
            }
            localObject1 = SharePatchFileUtil.jy(paramTinkerApplication);
            if (localObject1 == null)
            {
              ShareIntentUtil.b(paramIntent, -2);
              return;
            }
            localObject3 = ((File)localObject1).getAbsolutePath();
            if (!((File)localObject1).exists())
            {
              ShareIntentUtil.b(paramIntent, -2);
              return;
            }
            localFile1 = SharePatchFileUtil.awZ((String)localObject3);
            if (!localFile1.exists())
            {
              new StringBuilder("tryLoadPatchFiles:patch info not exist:").append(localFile1.getAbsolutePath());
              ShareIntentUtil.b(paramIntent, -3);
              return;
            }
            localFile2 = SharePatchFileUtil.axa((String)localObject3);
            this.patchInfo = SharePatchInfo.l(localFile1, localFile2);
            if (this.patchInfo == null)
            {
              ShareIntentUtil.b(paramIntent, -4);
              return;
            }
            bool3 = this.patchInfo.BvW;
            paramIntent.putExtra("intent_is_protected_app", bool3);
            localObject2 = this.patchInfo.vFR;
            str1 = this.patchInfo.BvV;
            localObject1 = this.patchInfo.BsZ;
            if ((localObject2 == null) || (str1 == null) || (localObject1 == null))
            {
              ShareIntentUtil.b(paramIntent, -4);
              return;
            }
            bool2 = ShareTinkerInternals.jH(paramTinkerApplication);
            bool1 = this.patchInfo.BvX;
            if ((bool2) && (bool1))
            {
              str2 = SharePatchFileUtil.axb(str1);
              if (str2 != null)
              {
                SharePatchFileUtil.cO((String)localObject3 + "/" + str2);
                localObject1 = localObject2;
                if (((String)localObject2).equals(str1)) {
                  localObject1 = "";
                }
                this.patchInfo.vFR = ((String)localObject1);
                this.patchInfo.BvV = ((String)localObject1);
                this.patchInfo.BvX = false;
                SharePatchInfo.a(localFile1, this.patchInfo, localFile2);
                ShareTinkerInternals.jK(paramTinkerApplication);
                ShareIntentUtil.b(paramIntent, -2);
                return;
              }
            }
            paramIntent.putExtra("intent_patch_old_version", (String)localObject2);
            paramIntent.putExtra("intent_patch_new_version", str1);
            if (!((String)localObject2).equals(str1)) {}
            for (i = 1;; i = 0)
            {
              bool6 = ((String)localObject1).equals("changing");
              str2 = ShareTinkerInternals.cg(paramTinkerApplication, (String)localObject1);
              paramIntent.putExtra("intent_patch_oat_dir", str2);
              localObject1 = localObject2;
              if (i != 0)
              {
                localObject1 = localObject2;
                if (bool2) {
                  localObject1 = str1;
                }
              }
              if (!ShareTinkerInternals.isNullOrNil((String)localObject1)) {
                break;
              }
              ShareIntentUtil.b(paramIntent, -5);
              return;
            }
            localObject2 = SharePatchFileUtil.axb((String)localObject1);
            if (localObject2 == null)
            {
              ShareIntentUtil.b(paramIntent, -6);
              return;
            }
            str1 = (String)localObject3 + "/" + (String)localObject2;
            localObject2 = new File(str1);
            if (!((File)localObject2).exists())
            {
              ShareIntentUtil.b(paramIntent, -6);
              return;
            }
            localObject3 = SharePatchFileUtil.axc((String)localObject1);
            if (localObject3 != null) {}
            for (localObject2 = new File(((File)localObject2).getAbsolutePath(), (String)localObject3); !SharePatchFileUtil.an((File)localObject2); localObject2 = null)
            {
              ShareIntentUtil.b(paramIntent, -7);
              return;
            }
            localObject3 = new ShareSecurityCheck(paramTinkerApplication);
            int k = ShareTinkerInternals.a(paramTinkerApplication, j, (File)localObject2, (ShareSecurityCheck)localObject3);
            if (k != 0)
            {
              paramIntent.putExtra("intent_patch_package_patch_check", k);
              ShareIntentUtil.b(paramIntent, -8);
              return;
            }
            paramIntent.putExtra("intent_patch_package_config", ((ShareSecurityCheck)localObject3).dWD());
            bool4 = ShareTinkerInternals.Te(j);
          } while (((bool4) && (!TinkerDexLoader.a(str1, (ShareSecurityCheck)localObject3, str2, paramIntent))) || ((ShareTinkerInternals.Tf(j)) && (!TinkerSoLoader.a(str1, (ShareSecurityCheck)localObject3, paramIntent))));
          bool5 = ShareTinkerInternals.Tg(j);
        } while ((bool5) && (!TinkerResourceLoader.a(paramTinkerApplication, str1, (ShareSecurityCheck)localObject3, paramIntent)));
        if ((ShareTinkerInternals.dWE()) && (ShareTinkerInternals.axf(this.patchInfo.BvY)) && (Build.VERSION.SDK_INT >= 21) && (!ShareTinkerInternals.dWG())) {}
        for (boolean bool1 = true;; bool1 = false)
        {
          paramIntent.putExtra("intent_patch_system_ota", bool1);
          if (bool2)
          {
            if (i != 0) {
              this.patchInfo.vFR = ((String)localObject1);
            }
            if (bool6)
            {
              this.patchInfo.BsZ = str2;
              SharePatchFileUtil.cO(str1 + "/interpet");
            }
          }
          if (checkSafeModeCount(paramTinkerApplication)) {
            break;
          }
          paramIntent.putExtra("intent_patch_exception", new TinkerRuntimeException("checkSafeModeCount fail"));
          ShareIntentUtil.b(paramIntent, -25);
          return;
        }
        if (!bool4) {
          break;
        }
        bool3 = TinkerDexLoader.a(paramTinkerApplication, str1, str2, paramIntent, bool1, bool3);
        if (bool1)
        {
          this.patchInfo.BvY = Build.FINGERPRINT;
          localObject2 = this.patchInfo;
          if (bool3) {}
          for (localObject1 = "interpet";; localObject1 = "odex")
          {
            ((SharePatchInfo)localObject2).BsZ = ((String)localObject1);
            if (SharePatchInfo.a(localFile1, this.patchInfo, localFile2)) {
              break;
            }
            ShareIntentUtil.b(paramIntent, -19);
            return;
          }
          paramIntent.putExtra("intent_patch_oat_dir", this.patchInfo.BsZ);
        }
      } while (!bool3);
    } while ((bool5) && (!TinkerResourceLoader.a(paramTinkerApplication, str1, paramIntent)));
    if ((bool4) && (bool5)) {
      ComponentHotplug.a(paramTinkerApplication, (ShareSecurityCheck)localObject3);
    }
    if ((bool2) && (i != 0))
    {
      if (!SharePatchInfo.a(localFile1, this.patchInfo, localFile2))
      {
        ShareIntentUtil.b(paramIntent, -19);
        return;
      }
      ShareTinkerInternals.jK(paramTinkerApplication);
    }
    ShareIntentUtil.b(paramIntent, 0);
  }
  
  public Intent tryLoad(TinkerApplication paramTinkerApplication)
  {
    Intent localIntent = new Intent();
    long l = SystemClock.elapsedRealtime();
    tryLoadPatchFilesInternal(paramTinkerApplication, localIntent);
    ShareIntentUtil.a(localIntent, SystemClock.elapsedRealtime() - l);
    return localIntent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.loader.TinkerLoader
 * JD-Core Version:    0.7.0.1
 */