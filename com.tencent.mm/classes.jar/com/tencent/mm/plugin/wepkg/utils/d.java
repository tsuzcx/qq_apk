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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class d
{
  private static final Set<Object> lwZ;
  private static final Object ogA;
  private static volatile MMHandler xvA;
  
  static
  {
    AppMethodBeat.i(110824);
    ogA = new Object();
    lwZ = new HashSet();
    AppMethodBeat.o(110824);
  }
  
  public static void b(String paramString, final com.tencent.mm.plugin.wepkg.model.a parama)
  {
    AppMethodBeat.i(110815);
    long l = System.currentTimeMillis();
    final WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.EX = 1001;
    localWepkgCrossProcessTask.JNm = paramString;
    if (MMApplicationContext.isMMProcess())
    {
      cyh().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(110808);
          this.JNt.bjj();
          if (parama != null) {
            parama.a(this.JNt);
          }
          AppMethodBeat.o(110808);
        }
      });
      AppMethodBeat.o(110815);
      return;
    }
    localWepkgCrossProcessTask.lyv = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(110809);
        Log.i("MicroMsg.Wepkg.WepkgUtil", "bind service time:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - this.JOq) });
        if (localWepkgCrossProcessTask != null) {
          localWepkgCrossProcessTask.a(this.JNt);
        }
        this.JNt.bDK();
        AppMethodBeat.o(110809);
      }
    };
    localWepkgCrossProcessTask.bDJ();
    AppBrandMainProcessService.a(localWepkgCrossProcessTask);
    AppMethodBeat.o(110815);
  }
  
  public static void bZm()
  {
    AppMethodBeat.i(110813);
    if (xvA == null)
    {
      AppMethodBeat.o(110813);
      return;
    }
    synchronized (ogA)
    {
      if (xvA != null)
      {
        xvA.quit();
        xvA = null;
      }
      AppMethodBeat.o(110813);
      return;
    }
  }
  
  public static String bcO(String paramString)
  {
    AppMethodBeat.i(110816);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(110816);
      return "";
    }
    try
    {
      paramString = Util.nullAsNil(Uri.parse(paramString).getQueryParameter("wechat_pkgid"));
      AppMethodBeat.o(110816);
      return paramString;
    }
    catch (UnsupportedOperationException paramString)
    {
      Log.e("MicroMsg.Wepkg.WepkgUtil", paramString.getMessage());
      AppMethodBeat.o(110816);
    }
    return "";
  }
  
  public static String bcP(String paramString)
  {
    AppMethodBeat.i(110817);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(110817);
      return "";
    }
    paramString = Uri.parse(paramString).getHost();
    AppMethodBeat.o(110817);
    return paramString;
  }
  
  /* Error */
  public static String bcQ(String paramString)
  {
    // Byte code:
    //   0: ldc 148
    //   2: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokestatic 111	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   9: ifne +10 -> 19
    //   12: aload_0
    //   13: invokestatic 153	android/webkit/URLUtil:isNetworkUrl	(Ljava/lang/String;)Z
    //   16: ifne +11 -> 27
    //   19: ldc 148
    //   21: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: ldc 113
    //   26: areturn
    //   27: aload_0
    //   28: invokestatic 119	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   31: astore_1
    //   32: aload_0
    //   33: new 155	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   40: aload_1
    //   41: invokevirtual 159	android/net/Uri:getScheme	()Ljava/lang/String;
    //   44: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: ldc 165
    //   49: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: ldc 113
    //   57: invokevirtual 174	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   60: astore_1
    //   61: aload_1
    //   62: astore_0
    //   63: aload_1
    //   64: ldc 176
    //   66: invokevirtual 180	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   69: ifeq +15 -> 84
    //   72: aload_1
    //   73: iconst_0
    //   74: aload_1
    //   75: ldc 176
    //   77: invokevirtual 184	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   80: invokevirtual 188	java/lang/String:substring	(II)Ljava/lang/String;
    //   83: astore_0
    //   84: ldc 148
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
  
  public static boolean bcR(String paramString)
  {
    AppMethodBeat.i(110819);
    if (!Util.isNullOrNil(bcO(paramString)))
    {
      SharedPreferences localSharedPreferences = MMApplicationContext.getContext().getSharedPreferences("we_pkg_sp", 4);
      if ((localSharedPreferences != null) && (localSharedPreferences.getBoolean("disable_we_pkg", false)))
      {
        Log.i("MicroMsg.Wepkg.WepkgUtil", "disable wepkg");
        a.b("EnterWeb", paramString, bcO(paramString), null, 0L, 0L, a.ahr(11));
        AppMethodBeat.o(110819);
        return false;
      }
      if (com.tencent.mm.plugin.game.commlib.a.dSV())
      {
        Log.i("MicroMsg.Wepkg.WepkgUtil", "config wepkg disable");
        a.b("EnterWeb", paramString, bcO(paramString), null, 0L, 0L, a.ahr(12));
        AppMethodBeat.o(110819);
        return false;
      }
      AppMethodBeat.o(110819);
      return true;
    }
    AppMethodBeat.o(110819);
    return false;
  }
  
  public static void bs(Object paramObject)
  {
    AppMethodBeat.i(110812);
    lwZ.remove(paramObject);
    AppMethodBeat.o(110812);
  }
  
  public static <T> T cP(T paramT)
  {
    AppMethodBeat.i(110811);
    lwZ.add(paramT);
    AppMethodBeat.o(110811);
    return paramT;
  }
  
  public static boolean checkMkdir(String paramString)
  {
    AppMethodBeat.i(110821);
    try
    {
      paramString = new o(paramString);
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
  
  public static long currentTime()
  {
    AppMethodBeat.i(110810);
    long l = Util.nowSecond();
    AppMethodBeat.o(110810);
    return l;
  }
  
  public static MMHandler cyh()
  {
    AppMethodBeat.i(184500);
    if (xvA == null) {}
    synchronized (ogA)
    {
      if (xvA == null) {
        xvA = new MMHandler("WebviewCache#WorkerThread");
      }
      ??? = xvA;
      AppMethodBeat.o(184500);
      return ???;
    }
  }
  
  public static boolean gkY()
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
  
  public static boolean isAppOnForeground(Context paramContext)
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
      if ((localRunningAppProcessInfo.importance == 100) && ((localRunningAppProcessInfo.processName.equals(MMApplicationContext.getApplicationId())) || (localRunningAppProcessInfo.processName.equals(MMApplicationContext.getApplicationId() + ":tools")) || (localRunningAppProcessInfo.processName.equals(MMApplicationContext.getApplicationId() + ":toolsmp"))))
      {
        AppMethodBeat.o(110823);
        return true;
      }
    }
    AppMethodBeat.o(110823);
    return false;
  }
  
  public static String mv(String paramString1, String paramString2)
  {
    AppMethodBeat.i(110820);
    paramString1 = g.getMessageDigest((paramString1 + "_" + paramString2).getBytes());
    AppMethodBeat.o(110820);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.utils.d
 * JD-Core Version:    0.7.0.1
 */