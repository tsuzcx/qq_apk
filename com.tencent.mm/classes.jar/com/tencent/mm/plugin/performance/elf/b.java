package com.tencent.mm.plugin.performance.elf;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b
{
  public static boolean DEBUG;
  public static long wXL;
  public static final b wXR;
  public static final b wXS;
  public static final Runnable wXT;
  public static final aq wXi;
  public boolean cNF = false;
  
  static
  {
    AppMethodBeat.i(125000);
    wXL = 1200000L;
    wXR = new b();
    wXi = new aq(Looper.getMainLooper());
    wXS = new b((byte)0);
    wXT = new a((byte)0);
    DEBUG = false;
    AppMethodBeat.o(125000);
  }
  
  public static boolean bn(float paramFloat)
  {
    AppMethodBeat.i(124999);
    Object localObject1 = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qzt, "");
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
          ae.i("MicroMsg.ProcessElf", "[checkHardOpen] name:%s model:%s version:%s | %s %s ", new Object[] { str1, str2, Integer.valueOf(j), localObject2, Integer.valueOf(Build.VERSION.SDK_INT) });
          if ((j <= Build.VERSION.SDK_INT) && (((String)localObject2).contains(str1)))
          {
            bool = ((String)localObject2).contains(str2);
            if (bool)
            {
              AppMethodBeat.o(124999);
              return true;
            }
          }
          i += 1;
        }
        i = new Random().nextInt(10000);
      }
      catch (Exception localException)
      {
        ae.printErrStackTrace("MicroMsg.ProcessElf", localException, "", new Object[0]);
      }
      if (10000.0F * paramFloat <= i) {
        break label298;
      }
    }
    label298:
    for (boolean bool = true;; bool = false)
    {
      ae.i("MicroMsg.ProcessElf", "[checkHardOpen] rand:%s test:%s isEnable:%s", new Object[] { Float.valueOf(paramFloat), Integer.valueOf(i), Boolean.valueOf(bool) });
      AppMethodBeat.o(124999);
      return bool;
      ae.i("MicroMsg.ProcessElf", "[checkHardOpen] json is Empty! just pass!");
      break;
    }
  }
  
  public static long dCc()
  {
    if (DEBUG) {
      return 8000L;
    }
    return wXL;
  }
  
  static final class a
    implements Runnable
  {
    public final void run()
    {
      AppMethodBeat.i(124996);
      ae.i("MicroMsg.ProcessElf", "send check broadcast!");
      ElfCheckRequest localElfCheckRequest = new ElfCheckRequest();
      localElfCheckRequest.cJR = b.dCc();
      Intent localIntent = new Intent("ACTION_ELF_CHECK");
      localIntent.putExtra("MicroMsg.ElfCheckRequest", localElfCheckRequest);
      ak.getContext().sendBroadcast(localIntent);
      b.dCh().postDelayed(this, b.dCc());
      AppMethodBeat.o(124996);
    }
  }
  
  static final class b
    extends BroadcastReceiver
  {
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(124998);
      if ("ACTION_ELF_CHECK_RESPONSE".equals(paramIntent.getAction()))
      {
        paramIntent = (ElfCheckResponse)paramIntent.getParcelableExtra("MicroMsg.ElfCheckResponse");
        if (paramIntent == null)
        {
          ae.i("MicroMsg.ProcessElf", "[onReceive] response is null!");
          AppMethodBeat.o(124998);
          return;
        }
        if (!paramIntent.cNF) {
          b.dCh().removeCallbacksAndMessages(null);
        }
        aq localaq = b.dCh();
        if ((paramIntent.cNF) && (paramIntent.wXp) && (paramIntent.wXq)) {
          localaq.postDelayed(new ElfCheckResponse.1(paramIntent, paramContext), paramIntent.wXt);
        }
        for (boolean bool = true;; bool = false)
        {
          ae.i("MicroMsg.ProcessElf", "[onReceive] %s, isEnable:%s, CHECK_TIME:%s", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(paramIntent.cNF), Long.valueOf(b.dCc()) });
          AppMethodBeat.o(124998);
          return;
          ae.w("MicroMsg.ElfCheckResponse", "can't call process[%s]", new Object[] { paramIntent.processName });
        }
      }
      if ("com.tencent.mm.MMUIModeManager".equals(paramIntent.getAction()))
      {
        ae.i("MicroMsg.ProcessElf", "restart mm for uimode change!");
        new Handler(Looper.getMainLooper()).postDelayed(new b.b.1(this, paramContext), 500L);
      }
      AppMethodBeat.o(124998);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.elf.b
 * JD-Core Version:    0.7.0.1
 */