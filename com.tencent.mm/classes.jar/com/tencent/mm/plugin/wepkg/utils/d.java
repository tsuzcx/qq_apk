package com.tencent.mm.plugin.wepkg.utils;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.wepkg.model.WepkgCrossProcessTask;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.e;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class d
{
  private static final Set<Object> jVK;
  private static final Object mnR;
  private static volatile ao sWp;
  
  static
  {
    AppMethodBeat.i(110824);
    mnR = new Object();
    jVK = new HashSet();
    AppMethodBeat.o(110824);
  }
  
  /* Error */
  public static String aFA(String paramString)
  {
    // Byte code:
    //   0: ldc 43
    //   2: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokestatic 49	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
    //   9: ifne +10 -> 19
    //   12: aload_0
    //   13: invokestatic 54	android/webkit/URLUtil:isNetworkUrl	(Ljava/lang/String;)Z
    //   16: ifne +11 -> 27
    //   19: ldc 43
    //   21: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: ldc 56
    //   26: areturn
    //   27: aload_0
    //   28: invokestatic 62	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   31: astore_1
    //   32: aload_0
    //   33: new 64	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   40: aload_1
    //   41: invokevirtual 69	android/net/Uri:getScheme	()Ljava/lang/String;
    //   44: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: ldc 75
    //   49: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: ldc 56
    //   57: invokevirtual 84	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   60: astore_1
    //   61: aload_1
    //   62: astore_0
    //   63: aload_1
    //   64: ldc 86
    //   66: invokevirtual 90	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   69: ifeq +15 -> 84
    //   72: aload_1
    //   73: iconst_0
    //   74: aload_1
    //   75: ldc 86
    //   77: invokevirtual 94	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   80: invokevirtual 98	java/lang/String:substring	(II)Ljava/lang/String;
    //   83: astore_0
    //   84: ldc 43
    //   86: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   89: aload_0
    //   90: areturn
    //   91: astore_1
    //   92: goto -8 -> 84
    //   95: astore_0
    //   96: aload_1
    //   97: astore_0
    //   98: goto -14 -> 84
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	paramString	String
    //   31	44	1	localObject	Object
    //   91	6	1	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   27	61	91	java/lang/Exception
    //   63	84	95	java/lang/Exception
  }
  
  public static boolean aFB(String paramString)
  {
    AppMethodBeat.i(110819);
    if (!bs.isNullOrNil(aFy(paramString)))
    {
      SharedPreferences localSharedPreferences = ai.getContext().getSharedPreferences("we_pkg_sp", 4);
      if ((localSharedPreferences != null) && (localSharedPreferences.getBoolean("disable_we_pkg", false)))
      {
        ac.i("MicroMsg.Wepkg.WepkgUtil", "disable wepkg");
        a.b("EnterWeb", paramString, aFy(paramString), null, 0L, 0L, a.Wj(11));
        AppMethodBeat.o(110819);
        return false;
      }
      if (b.DbS)
      {
        ac.i("MicroMsg.Wepkg.WepkgUtil", "config wepkg disable");
        a.b("EnterWeb", paramString, aFy(paramString), null, 0L, 0L, a.Wj(12));
        AppMethodBeat.o(110819);
        return false;
      }
      AppMethodBeat.o(110819);
      return true;
    }
    AppMethodBeat.o(110819);
    return false;
  }
  
  public static boolean aFC(String paramString)
  {
    AppMethodBeat.i(110821);
    try
    {
      paramString = new e(paramString);
      if ((!paramString.exists()) || (!paramString.isDirectory())) {
        paramString.mkdirs();
      }
      AppMethodBeat.o(110821);
      return true;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(110821);
    }
    return false;
  }
  
  public static String aFy(String paramString)
  {
    AppMethodBeat.i(110816);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(110816);
      return "";
    }
    try
    {
      paramString = bs.nullAsNil(Uri.parse(paramString).getQueryParameter("wechat_pkgid"));
      AppMethodBeat.o(110816);
      return paramString;
    }
    catch (UnsupportedOperationException paramString)
    {
      ac.e("MicroMsg.Wepkg.WepkgUtil", paramString.getMessage());
      AppMethodBeat.o(110816);
    }
    return "";
  }
  
  public static String aFz(String paramString)
  {
    AppMethodBeat.i(110817);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(110817);
      return "";
    }
    paramString = Uri.parse(paramString).getHost();
    AppMethodBeat.o(110817);
    return paramString;
  }
  
  public static void b(String paramString, final com.tencent.mm.plugin.wepkg.model.a parama)
  {
    AppMethodBeat.i(110815);
    long l = System.currentTimeMillis();
    final WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.CW = 1001;
    localWepkgCrossProcessTask.DaZ = paramString;
    if (ai.ciE())
    {
      bUw().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(110808);
          this.Dbg.aLq();
          if (parama != null) {
            parama.a(this.Dbg);
          }
          AppMethodBeat.o(110808);
        }
      });
      AppMethodBeat.o(110815);
      return;
    }
    localWepkgCrossProcessTask.jWP = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(110809);
        ac.i("MicroMsg.Wepkg.WepkgUtil", "bind service time:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - this.Dce) });
        if (localWepkgCrossProcessTask != null) {
          localWepkgCrossProcessTask.a(this.Dbg);
        }
        this.Dbg.bek();
        AppMethodBeat.o(110809);
      }
    };
    localWepkgCrossProcessTask.bej();
    AppBrandMainProcessService.a(localWepkgCrossProcessTask);
    AppMethodBeat.o(110815);
  }
  
  public static ao bUw()
  {
    AppMethodBeat.i(184500);
    if (sWp == null) {}
    synchronized (mnR)
    {
      if (sWp == null) {
        sWp = new ao("WebviewCache#WorkerThread");
      }
      ??? = sWp;
      AppMethodBeat.o(184500);
      return ???;
    }
  }
  
  public static void bh(Object paramObject)
  {
    AppMethodBeat.i(110812);
    jVK.remove(paramObject);
    AppMethodBeat.o(110812);
  }
  
  public static void bxi()
  {
    AppMethodBeat.i(110813);
    if (sWp == null)
    {
      AppMethodBeat.o(110813);
      return;
    }
    synchronized (mnR)
    {
      if (sWp != null)
      {
        sWp.quit();
        sWp = null;
      }
      AppMethodBeat.o(110813);
      return;
    }
  }
  
  public static long bxm()
  {
    AppMethodBeat.i(110810);
    long l = bs.aNx();
    AppMethodBeat.o(110810);
    return l;
  }
  
  public static <T> T cF(T paramT)
  {
    AppMethodBeat.i(110811);
    jVK.add(paramT);
    AppMethodBeat.o(110811);
    return paramT;
  }
  
  public static boolean cK(Context paramContext)
  {
    AppMethodBeat.i(110823);
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    if (paramContext == null)
    {
      AppMethodBeat.o(110823);
      return false;
    }
    paramContext = paramContext.iterator();
    while (paramContext.hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
      if ((localRunningAppProcessInfo.importance == 100) && ((localRunningAppProcessInfo.processName.equals("com.tencent.mm")) || (localRunningAppProcessInfo.processName.equals("com.tencent.mm:tools")) || (localRunningAppProcessInfo.processName.equals("com.tencent.mm:toolsmp"))))
      {
        AppMethodBeat.o(110823);
        return true;
      }
    }
    AppMethodBeat.o(110823);
    return false;
  }
  
  public static boolean eJm()
  {
    AppMethodBeat.i(110822);
    GregorianCalendar localGregorianCalendar = new GregorianCalendar();
    int i = localGregorianCalendar.get(11);
    int j = localGregorianCalendar.get(12);
    if ((i >= 12) && (i < 14))
    {
      AppMethodBeat.o(110822);
      return true;
    }
    if (i == 14)
    {
      if (j <= 30)
      {
        AppMethodBeat.o(110822);
        return true;
      }
    }
    else if ((i >= 18) && (i <= 24))
    {
      AppMethodBeat.o(110822);
      return true;
    }
    AppMethodBeat.o(110822);
    return false;
  }
  
  public static String kS(String paramString1, String paramString2)
  {
    AppMethodBeat.i(110820);
    paramString1 = g.getMessageDigest((paramString1 + "_" + paramString2).getBytes());
    AppMethodBeat.o(110820);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.utils.d
 * JD-Core Version:    0.7.0.1
 */