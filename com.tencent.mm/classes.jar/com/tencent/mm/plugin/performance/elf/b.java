package com.tencent.mm.plugin.performance.elf;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.a;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b
{
  public static boolean DEBUG;
  public static long psO;
  public static final b psT;
  public static final b.b psU;
  public static final Runnable psV;
  public static final ak psk;
  public boolean bTy = false;
  
  static
  {
    AppMethodBeat.i(111072);
    psO = 1200000L;
    psT = new b();
    psk = new ak(Looper.getMainLooper());
    psU = new b.b((byte)0);
    psV = new b.a((byte)0);
    DEBUG = false;
    AppMethodBeat.o(111072);
  }
  
  public static boolean aR(float paramFloat)
  {
    AppMethodBeat.i(111071);
    Object localObject1 = ((a)g.E(a.class)).a(a.a.lTQ, "");
    int i;
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      try
      {
        localObject1 = new JSONObject((String)localObject1).getJSONArray("hard-open");
        i = 0;
        while (i < ((JSONArray)localObject1).length())
        {
          Object localObject2 = ((JSONArray)localObject1).getJSONObject(i);
          String str1 = ((JSONObject)localObject2).getString("device-brand");
          String str2 = ((JSONObject)localObject2).getString("device-model");
          int j = ((JSONObject)localObject2).getInt("sdk-version");
          localObject2 = Build.BRAND + " " + Build.MODEL;
          ab.i("MicroMsg.ProcessElf", "[checkHardOpen] name:%s model:%s version:%s | %s %s ", new Object[] { str1, str2, Integer.valueOf(j), localObject2, Integer.valueOf(Build.VERSION.SDK_INT) });
          if ((j <= Build.VERSION.SDK_INT) && (((String)localObject2).contains(str1)))
          {
            bool = ((String)localObject2).contains(str2);
            if (bool)
            {
              AppMethodBeat.o(111071);
              return true;
            }
          }
          i += 1;
        }
        i = new Random().nextInt(10000);
      }
      catch (Exception localException)
      {
        ab.printErrStackTrace("MicroMsg.ProcessElf", localException, "", new Object[0]);
      }
      if (10000.0F * paramFloat <= i) {
        break label298;
      }
    }
    label298:
    for (boolean bool = true;; bool = false)
    {
      ab.i("MicroMsg.ProcessElf", "[checkHardOpen] rand:%s test:%s isEnable:%s", new Object[] { Float.valueOf(paramFloat), Integer.valueOf(i), Boolean.valueOf(bool) });
      AppMethodBeat.o(111071);
      return bool;
      ab.i("MicroMsg.ProcessElf", "[checkHardOpen] json is Empty! just pass!");
      break;
    }
  }
  
  public static long caE()
  {
    if (DEBUG) {
      return 8000L;
    }
    return psO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.elf.b
 * JD-Core Version:    0.7.0.1
 */