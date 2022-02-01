package com.tencent.tinker.loader;

import android.content.Intent;
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
    int i = k.R(paramTinkerApplication);
    if (i >= 2)
    {
      k.j(paramTinkerApplication, 0);
      return false;
    }
    paramTinkerApplication.setUseSafeMode(true);
    k.j(paramTinkerApplication, i + 1);
    return true;
  }
  
  private void tryLoadPatchFilesInternal(TinkerApplication paramTinkerApplication, Intent paramIntent)
  {
    int j = paramTinkerApplication.getTinkerFlags();
    if (!k.cD(j))
    {
      Log.w("Tinker.TinkerLoader", "tryLoadPatchFiles: tinker is disable, just return");
      e.a(paramIntent, -1);
      return;
    }
    if (k.T(paramTinkerApplication))
    {
      Log.w("Tinker.TinkerLoader", "tryLoadPatchFiles: we don't load patch with :patch process itself, just return");
      e.a(paramIntent, -1);
      return;
    }
    Object localObject1 = f.N(paramTinkerApplication);
    if (localObject1 == null)
    {
      Log.w("Tinker.TinkerLoader", "tryLoadPatchFiles:getPatchDirectory == null");
      e.a(paramIntent, -2);
      return;
    }
    Object localObject3 = ((File)localObject1).getAbsolutePath();
    if (!((File)localObject1).exists())
    {
      Log.w("Tinker.TinkerLoader", "tryLoadPatchFiles:patch dir not exist:".concat(String.valueOf(localObject3)));
      e.a(paramIntent, -2);
      return;
    }
    File localFile1 = f.ag((String)localObject3);
    if (!localFile1.exists())
    {
      Log.w("Tinker.TinkerLoader", "tryLoadPatchFiles:patch info not exist:" + localFile1.getAbsolutePath());
      e.a(paramIntent, -3);
      return;
    }
    File localFile2 = f.ah((String)localObject3);
    this.patchInfo = g.d(localFile1, localFile2);
    if (this.patchInfo == null)
    {
      e.a(paramIntent, -4);
      return;
    }
    boolean bool3 = this.patchInfo.apJ;
    paramIntent.putExtra("intent_is_protected_app", bool3);
    Object localObject2 = this.patchInfo.apH;
    String str1 = this.patchInfo.apI;
    localObject1 = this.patchInfo.apM;
    if ((localObject2 == null) || (str1 == null) || (localObject1 == null))
    {
      Log.w("Tinker.TinkerLoader", "tryLoadPatchFiles:onPatchInfoCorrupted");
      e.a(paramIntent, -4);
      return;
    }
    boolean bool2 = k.S(paramTinkerApplication);
    boolean bool1 = this.patchInfo.apK;
    String str2;
    if ((bool2) && (bool1))
    {
      Log.w("Tinker.TinkerLoader", "found clean patch mark and we are in main process, delete patch file now.");
      str2 = f.ai(str1);
      if (str2 != null)
      {
        f.al((String)localObject3 + "/" + str2);
        localObject1 = localObject2;
        if (((String)localObject2).equals(str1)) {
          localObject1 = "";
        }
        this.patchInfo.apH = ((String)localObject1);
        this.patchInfo.apI = ((String)localObject1);
        this.patchInfo.apK = false;
        g.a(localFile1, this.patchInfo, localFile2);
        k.U(paramTinkerApplication);
        e.a(paramIntent, -2);
        return;
      }
    }
    paramIntent.putExtra("intent_patch_old_version", (String)localObject2);
    paramIntent.putExtra("intent_patch_new_version", str1);
    if (!((String)localObject2).equals(str1)) {}
    boolean bool6;
    for (int i = 1;; i = 0)
    {
      bool6 = ((String)localObject1).equals("changing");
      str2 = k.l(paramTinkerApplication, (String)localObject1);
      paramIntent.putExtra("intent_patch_oat_dir", str2);
      localObject1 = localObject2;
      if (i != 0)
      {
        localObject1 = localObject2;
        if (bool2) {
          localObject1 = str1;
        }
      }
      if (!k.D((String)localObject1)) {
        break;
      }
      Log.w("Tinker.TinkerLoader", "tryLoadPatchFiles:version is blank, wait main process to restart");
      e.a(paramIntent, -5);
      return;
    }
    localObject2 = f.ai((String)localObject1);
    if (localObject2 == null)
    {
      Log.w("Tinker.TinkerLoader", "tryLoadPatchFiles:patchName is null");
      e.a(paramIntent, -6);
      return;
    }
    str1 = (String)localObject3 + "/" + (String)localObject2;
    localObject2 = new File(str1);
    if (!((File)localObject2).exists())
    {
      Log.w("Tinker.TinkerLoader", "tryLoadPatchFiles:onPatchVersionDirectoryNotFound");
      e.a(paramIntent, -6);
      return;
    }
    localObject3 = f.aj((String)localObject1);
    if (localObject3 != null) {}
    for (localObject2 = new File(((File)localObject2).getAbsolutePath(), (String)localObject3); !f.j((File)localObject2); localObject2 = null)
    {
      Log.w("Tinker.TinkerLoader", "tryLoadPatchFiles:onPatchVersionFileNotFound");
      e.a(paramIntent, -7);
      return;
    }
    localObject3 = new j(paramTinkerApplication);
    int k = k.a(paramTinkerApplication, j, (File)localObject2, (j)localObject3);
    if (k != 0)
    {
      Log.w("Tinker.TinkerLoader", "tryLoadPatchFiles:checkTinkerPackage");
      paramIntent.putExtra("intent_patch_package_patch_check", k);
      e.a(paramIntent, -8);
      return;
    }
    paramIntent.putExtra("intent_patch_package_config", ((j)localObject3).oZ());
    boolean bool4 = k.cA(j);
    if ((bool4) && (!TinkerDexLoader.a(str1, (j)localObject3, str2, paramIntent)))
    {
      Log.w("Tinker.TinkerLoader", "tryLoadPatchFiles:dex check fail");
      return;
    }
    if ((k.cB(j)) && (!TinkerSoLoader.a(str1, (j)localObject3, paramIntent)))
    {
      Log.w("Tinker.TinkerLoader", "tryLoadPatchFiles:native lib check fail");
      return;
    }
    boolean bool5 = k.cC(j);
    Log.w("Tinker.TinkerLoader", "tryLoadPatchFiles:isEnabledForResource:".concat(String.valueOf(bool5)));
    if ((bool5) && (!TinkerResourceLoader.a(paramTinkerApplication, str1, (j)localObject3, paramIntent)))
    {
      Log.w("Tinker.TinkerLoader", "tryLoadPatchFiles:resource check fail");
      return;
    }
    if ((k.pa()) && (k.an(this.patchInfo.apL)) && (Build.VERSION.SDK_INT >= 21) && (!k.pb())) {}
    for (bool1 = true;; bool1 = false)
    {
      paramIntent.putExtra("intent_patch_system_ota", bool1);
      if (bool2)
      {
        if (i != 0) {
          this.patchInfo.apH = ((String)localObject1);
        }
        if (bool6)
        {
          this.patchInfo.apM = str2;
          Log.i("Tinker.TinkerLoader", "tryLoadPatchFiles:oatModeChanged, try to delete interpret optimize files");
          f.al(str1 + "/interpet");
        }
      }
      if (checkSafeModeCount(paramTinkerApplication)) {
        break;
      }
      paramIntent.putExtra("intent_patch_exception", new TinkerRuntimeException("checkSafeModeCount fail"));
      e.a(paramIntent, -25);
      Log.w("Tinker.TinkerLoader", "tryLoadPatchFiles:checkSafeModeCount fail");
      return;
    }
    if (bool4)
    {
      bool3 = TinkerDexLoader.a(paramTinkerApplication, str1, str2, paramIntent, bool1, bool3);
      if (bool1)
      {
        this.patchInfo.apL = Build.FINGERPRINT;
        localObject2 = this.patchInfo;
        if (bool3) {}
        for (localObject1 = "interpet";; localObject1 = "odex")
        {
          ((g)localObject2).apM = ((String)localObject1);
          if (g.a(localFile1, this.patchInfo, localFile2)) {
            break;
          }
          e.a(paramIntent, -19);
          Log.w("Tinker.TinkerLoader", "tryLoadPatchFiles:onReWritePatchInfoCorrupted");
          return;
        }
        paramIntent.putExtra("intent_patch_oat_dir", this.patchInfo.apM);
      }
      if (!bool3)
      {
        Log.w("Tinker.TinkerLoader", "tryLoadPatchFiles:onPatchLoadDexesFail");
        return;
      }
    }
    if ((bool5) && (!TinkerResourceLoader.a(paramTinkerApplication, str1, paramIntent)))
    {
      Log.w("Tinker.TinkerLoader", "tryLoadPatchFiles:onPatchLoadResourcesFail");
      return;
    }
    if ((bool4) && (bool5)) {
      b.a(paramTinkerApplication, (j)localObject3);
    }
    if ((bool2) && (i != 0))
    {
      if (!g.a(localFile1, this.patchInfo, localFile2))
      {
        e.a(paramIntent, -19);
        Log.w("Tinker.TinkerLoader", "tryLoadPatchFiles:onReWritePatchInfoCorrupted");
        return;
      }
      k.U(paramTinkerApplication);
    }
    e.a(paramIntent, 0);
    Log.i("Tinker.TinkerLoader", "tryLoadPatchFiles: load end, ok!");
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