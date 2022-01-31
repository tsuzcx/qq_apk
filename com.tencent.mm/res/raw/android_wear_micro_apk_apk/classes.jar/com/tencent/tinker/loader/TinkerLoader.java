package com.tencent.tinker.loader;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.util.Log;
import com.tencent.tinker.loader.a.e;
import com.tencent.tinker.loader.a.f;
import com.tencent.tinker.loader.a.g;
import com.tencent.tinker.loader.a.j;
import com.tencent.tinker.loader.a.k;
import com.tencent.tinker.loader.app.TinkerApplication;
import com.tencent.tinker.loader.hotplug.b;
import java.io.File;

public class TinkerLoader
  extends AbstractTinkerLoader
{
  private static final String TAG = "Tinker.TinkerLoader";
  private g patchInfo;
  
  private boolean checkSafeModeCount(TinkerApplication paramTinkerApplication)
  {
    String str = k.T(paramTinkerApplication);
    str = "tinker_own_config_" + str;
    SharedPreferences localSharedPreferences = paramTinkerApplication.getSharedPreferences(str, 0);
    int i = localSharedPreferences.getInt("safe_mode_count", 0) + 1;
    Log.w("Tinker.TinkerLoader", "tinker safe mode preferName:" + str + " count:" + i);
    if (i >= 3)
    {
      localSharedPreferences.edit().putInt("safe_mode_count", 0).commit();
      return false;
    }
    paramTinkerApplication.setUseSafeMode(true);
    localSharedPreferences.edit().putInt("safe_mode_count", i).commit();
    return true;
  }
  
  private void tryLoadPatchFilesInternal(TinkerApplication paramTinkerApplication, Intent paramIntent)
  {
    int k = paramTinkerApplication.getTinkerFlags();
    if (!k.ch(k))
    {
      Log.w("Tinker.TinkerLoader", "tryLoadPatchFiles: tinker is disable, just return");
      e.a(paramIntent, -1);
      return;
    }
    if (k.R(paramTinkerApplication))
    {
      Log.w("Tinker.TinkerLoader", "tryLoadPatchFiles: we don't load patch with :patch process itself, just return");
      e.a(paramIntent, -1);
      return;
    }
    Object localObject1 = f.M(paramTinkerApplication);
    if (localObject1 == null)
    {
      Log.w("Tinker.TinkerLoader", "tryLoadPatchFiles:getPatchDirectory == null");
      e.a(paramIntent, -2);
      return;
    }
    String str2 = ((File)localObject1).getAbsolutePath();
    if (!((File)localObject1).exists())
    {
      Log.w("Tinker.TinkerLoader", "tryLoadPatchFiles:patch dir not exist:" + str2);
      e.a(paramIntent, -2);
      return;
    }
    File localFile1 = f.ac(str2);
    if (!localFile1.exists())
    {
      Log.w("Tinker.TinkerLoader", "tryLoadPatchFiles:patch info not exist:" + localFile1.getAbsolutePath());
      e.a(paramIntent, -3);
      return;
    }
    File localFile2 = f.ad(str2);
    this.patchInfo = g.d(localFile1, localFile2);
    if (this.patchInfo == null)
    {
      e.a(paramIntent, -4);
      return;
    }
    localObject1 = this.patchInfo.amh;
    Object localObject2 = this.patchInfo.ami;
    String str1 = this.patchInfo.amk;
    if ((localObject1 == null) || (localObject2 == null) || (str1 == null))
    {
      Log.w("Tinker.TinkerLoader", "tryLoadPatchFiles:onPatchInfoCorrupted");
      e.a(paramIntent, -4);
      return;
    }
    paramIntent.putExtra("intent_patch_old_version", (String)localObject1);
    paramIntent.putExtra("intent_patch_new_version", (String)localObject2);
    boolean bool4 = k.Q(paramTinkerApplication);
    int i;
    int j;
    if (!((String)localObject1).equals(localObject2))
    {
      i = 1;
      if ((!str1.equals("changing")) || (!bool4)) {
        break label369;
      }
      j = 1;
      label311:
      str1 = k.k(paramTinkerApplication, str1);
      paramIntent.putExtra("intent_patch_oat_dir", str1);
      if ((i == 0) || (!bool4)) {
        break label1090;
      }
      localObject1 = localObject2;
    }
    label1090:
    for (;;)
    {
      if (k.D((String)localObject1))
      {
        Log.w("Tinker.TinkerLoader", "tryLoadPatchFiles:version is blank, wait main process to restart");
        e.a(paramIntent, -5);
        return;
        i = 0;
        break;
        label369:
        j = 0;
        break label311;
      }
      localObject2 = f.ae((String)localObject1);
      if (localObject2 == null)
      {
        Log.w("Tinker.TinkerLoader", "tryLoadPatchFiles:patchName is null");
        e.a(paramIntent, -6);
        return;
      }
      str2 = str2 + "/" + (String)localObject2;
      localObject2 = new File(str2);
      if (!((File)localObject2).exists())
      {
        Log.w("Tinker.TinkerLoader", "tryLoadPatchFiles:onPatchVersionDirectoryNotFound");
        e.a(paramIntent, -6);
        return;
      }
      Object localObject3 = f.af((String)localObject1);
      if (localObject3 != null) {}
      for (localObject2 = new File(((File)localObject2).getAbsolutePath(), (String)localObject3); !f.j((File)localObject2); localObject2 = null)
      {
        Log.w("Tinker.TinkerLoader", "tryLoadPatchFiles:onPatchVersionFileNotFound");
        e.a(paramIntent, -7);
        return;
      }
      localObject3 = new j(paramTinkerApplication);
      int m = k.a(paramTinkerApplication, k, (File)localObject2, (j)localObject3);
      if (m != 0)
      {
        Log.w("Tinker.TinkerLoader", "tryLoadPatchFiles:checkTinkerPackage");
        paramIntent.putExtra("intent_patch_package_patch_check", m);
        e.a(paramIntent, -8);
        return;
      }
      paramIntent.putExtra("intent_patch_package_config", ((j)localObject3).om());
      boolean bool2 = k.ce(k);
      if ((bool2) && (!TinkerDexLoader.a(str2, (j)localObject3, str1, paramIntent)))
      {
        Log.w("Tinker.TinkerLoader", "tryLoadPatchFiles:dex check fail");
        return;
      }
      if ((k.cf(k)) && (!TinkerSoLoader.a(str2, (j)localObject3, paramIntent)))
      {
        Log.w("Tinker.TinkerLoader", "tryLoadPatchFiles:native lib check fail");
        return;
      }
      boolean bool3 = k.cg(k);
      Log.w("Tinker.TinkerLoader", "tryLoadPatchFiles:isEnabledForResource:" + bool3);
      if ((bool3) && (!TinkerResourceLoader.a(paramTinkerApplication, str2, (j)localObject3, paramIntent)))
      {
        Log.w("Tinker.TinkerLoader", "tryLoadPatchFiles:resource check fail");
        return;
      }
      if ((k.on()) && (k.aj(this.patchInfo.amj)) && (Build.VERSION.SDK_INT >= 21) && (!k.oo())) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        paramIntent.putExtra("intent_patch_system_ota", bool1);
        if (((!bool4) || (i == 0)) && (j == 0)) {
          break label869;
        }
        this.patchInfo.amh = ((String)localObject1);
        this.patchInfo.amk = str1;
        if (g.a(localFile1, this.patchInfo, localFile2)) {
          break;
        }
        e.a(paramIntent, -19);
        Log.w("Tinker.TinkerLoader", "tryLoadPatchFiles:onReWritePatchInfoCorrupted");
        return;
      }
      Log.i("Tinker.TinkerLoader", "tryLoadPatchFiles:success to rewrite patch info, kill other process.");
      k.S(paramTinkerApplication);
      if (j != 0)
      {
        Log.i("Tinker.TinkerLoader", "tryLoadPatchFiles:oatModeChanged, try to delete interpret optimize files");
        f.ah(str2 + "/interpet");
      }
      label869:
      if (!checkSafeModeCount(paramTinkerApplication))
      {
        paramIntent.putExtra("intent_patch_exception", new TinkerRuntimeException("checkSafeModeCount fail"));
        e.a(paramIntent, -25);
        Log.w("Tinker.TinkerLoader", "tryLoadPatchFiles:checkSafeModeCount fail");
        return;
      }
      if (bool2)
      {
        bool4 = TinkerDexLoader.a(paramTinkerApplication, str2, str1, paramIntent, bool1);
        if (bool1)
        {
          this.patchInfo.amj = Build.FINGERPRINT;
          localObject2 = this.patchInfo;
          if (bool4) {}
          for (localObject1 = "interpet";; localObject1 = "odex")
          {
            ((g)localObject2).amk = ((String)localObject1);
            if (g.a(localFile1, this.patchInfo, localFile2)) {
              break;
            }
            e.a(paramIntent, -19);
            Log.w("Tinker.TinkerLoader", "tryLoadPatchFiles:onReWritePatchInfoCorrupted");
            return;
          }
          paramIntent.putExtra("intent_patch_oat_dir", this.patchInfo.amk);
        }
        if (!bool4)
        {
          Log.w("Tinker.TinkerLoader", "tryLoadPatchFiles:onPatchLoadDexesFail");
          return;
        }
      }
      if ((bool3) && (!TinkerResourceLoader.a(paramTinkerApplication, str2, paramIntent)))
      {
        Log.w("Tinker.TinkerLoader", "tryLoadPatchFiles:onPatchLoadResourcesFail");
        return;
      }
      if ((bool2) && (bool3)) {
        b.a(paramTinkerApplication, (j)localObject3);
      }
      e.a(paramIntent, 0);
      Log.i("Tinker.TinkerLoader", "tryLoadPatchFiles: load end, ok!");
      return;
    }
  }
  
  public Intent tryLoad(TinkerApplication paramTinkerApplication)
  {
    Intent localIntent = new Intent();
    long l = SystemClock.elapsedRealtime();
    tryLoadPatchFilesInternal(paramTinkerApplication, localIntent);
    localIntent.putExtra("intent_patch_cost_time", SystemClock.elapsedRealtime() - l);
    return localIntent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.tinker.loader.TinkerLoader
 * JD-Core Version:    0.7.0.1
 */