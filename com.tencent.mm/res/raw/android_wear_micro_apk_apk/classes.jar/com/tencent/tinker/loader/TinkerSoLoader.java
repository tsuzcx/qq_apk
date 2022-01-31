package com.tencent.tinker.loader;

import android.content.Intent;
import com.tencent.tinker.loader.a.a;
import com.tencent.tinker.loader.a.e;
import com.tencent.tinker.loader.a.f;
import com.tencent.tinker.loader.a.j;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class TinkerSoLoader
{
  public static boolean a(String paramString, j paramj, Intent paramIntent)
  {
    paramj = (String)paramj.ol().get("assets/so_meta.txt");
    if (paramj == null) {
      return true;
    }
    Object localObject1 = new ArrayList();
    a.b(paramj, (ArrayList)localObject1);
    if (((ArrayList)localObject1).isEmpty()) {
      return true;
    }
    paramString = paramString + "/lib/";
    paramj = new HashMap();
    localObject1 = ((ArrayList)localObject1).iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (a)((Iterator)localObject1).next();
      int i;
      if (localObject2 == null) {
        i = 0;
      }
      while (i == 0)
      {
        paramIntent.putExtra("intent_patch_package_patch_check", -4);
        e.a(paramIntent, -8);
        return false;
        String str1 = ((a)localObject2).name;
        String str2 = ((a)localObject2).afE;
        if ((str1 == null) || (str1.length() <= 0) || (str2 == null) || (str2.length() != 32)) {
          i = 0;
        } else {
          i = 1;
        }
      }
      paramj.put(((a)localObject2).aat + "/" + ((a)localObject2).name, ((a)localObject2).afE);
    }
    localObject1 = new File(paramString);
    if ((!((File)localObject1).exists()) || (!((File)localObject1).isDirectory()))
    {
      e.a(paramIntent, -17);
      return false;
    }
    localObject1 = paramj.keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      localObject2 = new File(paramString + (String)localObject2);
      if (!f.j((File)localObject2))
      {
        e.a(paramIntent, -18);
        paramIntent.putExtra("intent_patch_missing_lib_path", ((File)localObject2).getAbsolutePath());
        return false;
      }
    }
    paramIntent.putExtra("intent_patch_libs_path", paramj);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.tinker.loader.TinkerSoLoader
 * JD-Core Version:    0.7.0.1
 */