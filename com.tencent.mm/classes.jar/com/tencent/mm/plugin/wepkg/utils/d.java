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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.e;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class d
{
  private static final Set<Object> kpY;
  private static final Object mOt;
  private static volatile ap tSX;
  
  static
  {
    AppMethodBeat.i(110824);
    mOt = new Object();
    kpY = new HashSet();
    AppMethodBeat.o(110824);
  }
  
  public static String aKY(String paramString)
  {
    AppMethodBeat.i(110816);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(110816);
      return "";
    }
    try
    {
      paramString = bt.nullAsNil(Uri.parse(paramString).getQueryParameter("wechat_pkgid"));
      AppMethodBeat.o(110816);
      return paramString;
    }
    catch (UnsupportedOperationException paramString)
    {
      ad.e("MicroMsg.Wepkg.WepkgUtil", paramString.getMessage());
      AppMethodBeat.o(110816);
    }
    return "";
  }
  
  public static String aKZ(String paramString)
  {
    AppMethodBeat.i(110817);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(110817);
      return "";
    }
    paramString = Uri.parse(paramString).getHost();
    AppMethodBeat.o(110817);
    return paramString;
  }
  
  /* Error */
  public static String aLa(String paramString)
  {
    // Byte code:
    //   0: ldc 86
    //   2: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokestatic 49	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   9: ifne +10 -> 19
    //   12: aload_0
    //   13: invokestatic 91	android/webkit/URLUtil:isNetworkUrl	(Ljava/lang/String;)Z
    //   16: ifne +11 -> 27
    //   19: ldc 86
    //   21: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: ldc 51
    //   26: areturn
    //   27: aload_0
    //   28: invokestatic 57	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   31: astore_1
    //   32: aload_0
    //   33: new 93	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   40: aload_1
    //   41: invokevirtual 97	android/net/Uri:getScheme	()Ljava/lang/String;
    //   44: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: ldc 103
    //   49: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: ldc 51
    //   57: invokevirtual 112	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   60: astore_1
    //   61: aload_1
    //   62: astore_0
    //   63: aload_1
    //   64: ldc 114
    //   66: invokevirtual 118	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   69: ifeq +15 -> 84
    //   72: aload_1
    //   73: iconst_0
    //   74: aload_1
    //   75: ldc 114
    //   77: invokevirtual 122	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   80: invokevirtual 126	java/lang/String:substring	(II)Ljava/lang/String;
    //   83: astore_0
    //   84: ldc 86
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
  
  public static boolean aLb(String paramString)
  {
    AppMethodBeat.i(110819);
    if (!bt.isNullOrNil(aKY(paramString)))
    {
      SharedPreferences localSharedPreferences = aj.getContext().getSharedPreferences("we_pkg_sp", 4);
      if ((localSharedPreferences != null) && (localSharedPreferences.getBoolean("disable_we_pkg", false)))
      {
        ad.i("MicroMsg.Wepkg.WepkgUtil", "disable wepkg");
        a.b("EnterWeb", paramString, aKY(paramString), null, 0L, 0L, a.Ya(11));
        AppMethodBeat.o(110819);
        return false;
      }
      if (b.EFR)
      {
        ad.i("MicroMsg.Wepkg.WepkgUtil", "config wepkg disable");
        a.b("EnterWeb", paramString, aKY(paramString), null, 0L, 0L, a.Ya(12));
        AppMethodBeat.o(110819);
        return false;
      }
      AppMethodBeat.o(110819);
      return true;
    }
    AppMethodBeat.o(110819);
    return false;
  }
  
  public static boolean aLc(String paramString)
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
  
  public static void b(String paramString, final com.tencent.mm.plugin.wepkg.model.a parama)
  {
    AppMethodBeat.i(110815);
    long l = System.currentTimeMillis();
    final WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.EN = 1001;
    localWepkgCrossProcessTask.EEY = paramString;
    if (aj.cnC())
    {
      bZb().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(110808);
          this.EFf.aOA();
          if (parama != null) {
            parama.a(this.EFf);
          }
          AppMethodBeat.o(110808);
        }
      });
      AppMethodBeat.o(110815);
      return;
    }
    localWepkgCrossProcessTask.krg = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(110809);
        ad.i("MicroMsg.Wepkg.WepkgUtil", "bind service time:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - this.EGe) });
        if (localWepkgCrossProcessTask != null) {
          localWepkgCrossProcessTask.a(this.EFf);
        }
        this.EFf.bhO();
        AppMethodBeat.o(110809);
      }
    };
    localWepkgCrossProcessTask.bhN();
    AppBrandMainProcessService.a(localWepkgCrossProcessTask);
    AppMethodBeat.o(110815);
  }
  
  public static void bBo()
  {
    AppMethodBeat.i(110813);
    if (tSX == null)
    {
      AppMethodBeat.o(110813);
      return;
    }
    synchronized (mOt)
    {
      if (tSX != null)
      {
        tSX.quit();
        tSX = null;
      }
      AppMethodBeat.o(110813);
      return;
    }
  }
  
  public static ap bZb()
  {
    AppMethodBeat.i(184500);
    if (tSX == null) {}
    synchronized (mOt)
    {
      if (tSX == null) {
        tSX = new ap("WebviewCache#WorkerThread");
      }
      ??? = tSX;
      AppMethodBeat.o(184500);
      return ???;
    }
  }
  
  public static void bj(Object paramObject)
  {
    AppMethodBeat.i(110812);
    kpY.remove(paramObject);
    AppMethodBeat.o(110812);
  }
  
  public static <T> T cH(T paramT)
  {
    AppMethodBeat.i(110811);
    kpY.add(paramT);
    AppMethodBeat.o(110811);
    return paramT;
  }
  
  public static boolean cH(Context paramContext)
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
  
  public static long currentTime()
  {
    AppMethodBeat.i(110810);
    long l = bt.aQJ();
    AppMethodBeat.o(110810);
    return l;
  }
  
  public static boolean eYg()
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
  
  public static String lp(String paramString1, String paramString2)
  {
    AppMethodBeat.i(110820);
    paramString1 = g.getMessageDigest((paramString1 + "_" + paramString2).getBytes());
    AppMethodBeat.o(110820);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.utils.d
 * JD-Core Version:    0.7.0.1
 */