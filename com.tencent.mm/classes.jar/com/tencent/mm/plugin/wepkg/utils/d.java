package com.tencent.mm.plugin.wepkg.utils;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.plugin.wepkg.ipc.WepkgMainProcessService;
import com.tencent.mm.plugin.wepkg.model.WepkgCrossProcessTask;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class d
{
  private static volatile al ftB;
  private static final Set<Object> hwB;
  private static final Object iXt;
  
  static
  {
    AppMethodBeat.i(63665);
    iXt = new Object();
    hwB = new HashSet();
    AppMethodBeat.o(63665);
  }
  
  public static void aNR()
  {
    AppMethodBeat.i(63654);
    if (ftB == null)
    {
      AppMethodBeat.o(63654);
      return;
    }
    synchronized (iXt)
    {
      if (ftB != null)
      {
        ftB.oNc.quit();
        ftB = null;
      }
      AppMethodBeat.o(63654);
      return;
    }
  }
  
  public static al aNS()
  {
    AppMethodBeat.i(63655);
    if (ftB == null) {}
    synchronized (iXt)
    {
      if (ftB == null) {
        ftB = new al("WebviewCache#WorkerThread");
      }
      ??? = ftB;
      AppMethodBeat.o(63655);
      return ???;
    }
  }
  
  public static long aNY()
  {
    AppMethodBeat.i(63651);
    long l = bo.aox();
    AppMethodBeat.o(63651);
    return l;
  }
  
  public static void ai(Object paramObject)
  {
    AppMethodBeat.i(63653);
    hwB.remove(paramObject);
    AppMethodBeat.o(63653);
  }
  
  public static String akM(String paramString)
  {
    AppMethodBeat.i(63657);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(63657);
      return "";
    }
    try
    {
      paramString = bo.nullAsNil(Uri.parse(paramString).getQueryParameter("wechat_pkgid"));
      AppMethodBeat.o(63657);
      return paramString;
    }
    catch (UnsupportedOperationException paramString)
    {
      ab.e("MicroMsg.Wepkg.WepkgUtil", paramString.getMessage());
      AppMethodBeat.o(63657);
    }
    return "";
  }
  
  public static String akN(String paramString)
  {
    AppMethodBeat.i(63658);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(63658);
      return "";
    }
    paramString = Uri.parse(paramString).getHost();
    AppMethodBeat.o(63658);
    return paramString;
  }
  
  /* Error */
  public static String akO(String paramString)
  {
    // Byte code:
    //   0: ldc 121
    //   2: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokestatic 84	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   9: ifne +10 -> 19
    //   12: aload_0
    //   13: invokestatic 126	android/webkit/URLUtil:isNetworkUrl	(Ljava/lang/String;)Z
    //   16: ifne +11 -> 27
    //   19: ldc 121
    //   21: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: ldc 86
    //   26: areturn
    //   27: aload_0
    //   28: invokestatic 92	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   31: astore_1
    //   32: aload_0
    //   33: new 128	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   40: aload_1
    //   41: invokevirtual 132	android/net/Uri:getScheme	()Ljava/lang/String;
    //   44: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: ldc 138
    //   49: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: ldc 86
    //   57: invokevirtual 147	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   60: astore_1
    //   61: aload_1
    //   62: astore_0
    //   63: aload_1
    //   64: ldc 149
    //   66: invokevirtual 153	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   69: ifeq +15 -> 84
    //   72: aload_1
    //   73: iconst_0
    //   74: aload_1
    //   75: ldc 149
    //   77: invokevirtual 157	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   80: invokevirtual 161	java/lang/String:substring	(II)Ljava/lang/String;
    //   83: astore_0
    //   84: ldc 121
    //   86: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public static boolean akP(String paramString)
  {
    AppMethodBeat.i(63660);
    if (!bo.isNullOrNil(akM(paramString)))
    {
      SharedPreferences localSharedPreferences = ah.getContext().getSharedPreferences("we_pkg_sp", 4);
      if ((localSharedPreferences != null) && (localSharedPreferences.getBoolean("disable_we_pkg", false)))
      {
        ab.i("MicroMsg.Wepkg.WepkgUtil", "disable wepkg");
        a.b("EnterWeb", paramString, akM(paramString), null, 0L, 0L, a.Lq(11));
        AppMethodBeat.o(63660);
        return false;
      }
      if (b.vGZ)
      {
        ab.i("MicroMsg.Wepkg.WepkgUtil", "config wepkg disable");
        a.b("EnterWeb", paramString, akM(paramString), null, 0L, 0L, a.Lq(12));
        AppMethodBeat.o(63660);
        return false;
      }
      AppMethodBeat.o(63660);
      return true;
    }
    AppMethodBeat.o(63660);
    return false;
  }
  
  public static boolean akQ(String paramString)
  {
    AppMethodBeat.i(63662);
    try
    {
      paramString = new File(paramString);
      if ((!paramString.exists()) || (!paramString.isDirectory())) {
        paramString.mkdirs();
      }
      AppMethodBeat.o(63662);
      return true;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(63662);
    }
    return false;
  }
  
  public static void b(String paramString, com.tencent.mm.plugin.wepkg.model.a parama)
  {
    AppMethodBeat.i(63656);
    long l = System.currentTimeMillis();
    WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.vA = 1001;
    localWepkgCrossProcessTask.vGg = paramString;
    if (ah.brt())
    {
      aNS().ac(new d.1(localWepkgCrossProcessTask, parama));
      AppMethodBeat.o(63656);
      return;
    }
    localWepkgCrossProcessTask.hxp = new d.2(l, parama, localWepkgCrossProcessTask);
    localWepkgCrossProcessTask.aBj();
    WepkgMainProcessService.a(localWepkgCrossProcessTask);
    AppMethodBeat.o(63656);
  }
  
  public static <T> T bq(T paramT)
  {
    AppMethodBeat.i(63652);
    hwB.add(paramT);
    AppMethodBeat.o(63652);
    return paramT;
  }
  
  public static boolean dkI()
  {
    AppMethodBeat.i(63663);
    GregorianCalendar localGregorianCalendar = new GregorianCalendar();
    int i = localGregorianCalendar.get(11);
    int j = localGregorianCalendar.get(12);
    if ((i >= 12) && (i < 14))
    {
      AppMethodBeat.o(63663);
      return true;
    }
    if (i == 14)
    {
      if (j <= 30)
      {
        AppMethodBeat.o(63663);
        return true;
      }
    }
    else if ((i >= 18) && (i <= 24))
    {
      AppMethodBeat.o(63663);
      return true;
    }
    AppMethodBeat.o(63663);
    return false;
  }
  
  public static boolean eD(Context paramContext)
  {
    AppMethodBeat.i(63664);
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    if (paramContext == null)
    {
      AppMethodBeat.o(63664);
      return false;
    }
    paramContext = paramContext.iterator();
    while (paramContext.hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
      if ((localRunningAppProcessInfo.importance == 100) && ((localRunningAppProcessInfo.processName.equals("com.tencent.mm")) || (localRunningAppProcessInfo.processName.equals("com.tencent.mm:tools")) || (localRunningAppProcessInfo.processName.equals("com.tencent.mm:toolsmp"))))
      {
        AppMethodBeat.o(63664);
        return true;
      }
    }
    AppMethodBeat.o(63664);
    return false;
  }
  
  public static String hQ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(63661);
    paramString1 = g.w((paramString1 + "_" + paramString2).getBytes());
    AppMethodBeat.o(63661);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.utils.d
 * JD-Core Version:    0.7.0.1
 */