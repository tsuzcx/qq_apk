package com.tencent.mm.plugin.wepkg.utils;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.HandlerThread;
import com.tencent.mm.a.g;
import com.tencent.mm.plugin.wepkg.ipc.WepkgMainProcessService;
import com.tencent.mm.plugin.wepkg.model.WepkgCrossProcessTask;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class d
{
  private static volatile ai edy;
  private static final Set<Object> geC = new HashSet();
  private static final Object hkZ = new Object();
  
  public static ai DS()
  {
    if (edy == null) {}
    synchronized (hkZ)
    {
      if (edy == null) {
        edy = new ai("WebviewCache#WorkerThread");
      }
      return edy;
    }
  }
  
  public static String Vp(String paramString)
  {
    if (bk.bl(paramString)) {
      return "";
    }
    if (paramString.equals(com.tencent.mm.plugin.wepkg.a.cjz())) {
      return com.tencent.mm.plugin.wepkg.a.cjA();
    }
    return b.OBJECT_ROOT_DIR_PATH + paramString + "/";
  }
  
  public static String Vq(String paramString)
  {
    if (bk.bl(paramString)) {
      return "";
    }
    try
    {
      paramString = bk.pm(Uri.parse(paramString).getQueryParameter("wechat_pkgid"));
      return paramString;
    }
    catch (UnsupportedOperationException paramString)
    {
      y.e("MicroMsg.Wepkg.WepkgUtil", paramString.getMessage());
    }
    return "";
  }
  
  public static String Vr(String paramString)
  {
    if (bk.bl(paramString)) {
      return "";
    }
    return Uri.parse(paramString).getHost();
  }
  
  /* Error */
  public static String Vs(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 43	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   4: ifne +10 -> 14
    //   7: aload_0
    //   8: invokestatic 118	android/webkit/URLUtil:isNetworkUrl	(Ljava/lang/String;)Z
    //   11: ifne +8 -> 19
    //   14: ldc 45
    //   16: astore_1
    //   17: aload_1
    //   18: areturn
    //   19: aload_0
    //   20: invokestatic 87	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   23: astore_1
    //   24: aload_0
    //   25: new 62	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   32: aload_1
    //   33: invokevirtual 121	android/net/Uri:getScheme	()Ljava/lang/String;
    //   36: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: ldc 123
    //   41: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: ldc 45
    //   49: invokevirtual 127	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   52: astore_1
    //   53: aload_1
    //   54: astore_0
    //   55: aload_0
    //   56: astore_1
    //   57: aload_0
    //   58: ldc 129
    //   60: invokevirtual 133	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   63: ifeq -46 -> 17
    //   66: aload_0
    //   67: iconst_0
    //   68: aload_0
    //   69: ldc 129
    //   71: invokevirtual 137	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   74: invokevirtual 141	java/lang/String:substring	(II)Ljava/lang/String;
    //   77: astore_1
    //   78: aload_1
    //   79: areturn
    //   80: astore_1
    //   81: aload_0
    //   82: areturn
    //   83: astore_1
    //   84: aload_0
    //   85: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	86	0	paramString	String
    //   16	63	1	localObject	Object
    //   80	1	1	localException1	Exception
    //   83	1	1	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   19	53	80	java/lang/Exception
    //   57	78	83	java/lang/Exception
  }
  
  public static boolean Vt(String paramString)
  {
    if (!bk.bl(Vq(paramString)))
    {
      SharedPreferences localSharedPreferences = ae.getContext().getSharedPreferences("we_pkg_sp", 4);
      if ((localSharedPreferences != null) && (localSharedPreferences.getBoolean("disable_we_pkg", false)))
      {
        y.i("MicroMsg.Wepkg.WepkgUtil", "disable wepkg");
        a.b("EnterWeb", paramString, Vq(paramString), null, 0L, 0L, a.Dy(11));
        return false;
      }
      if (b.rQh)
      {
        y.i("MicroMsg.Wepkg.WepkgUtil", "config wepkg disable");
        a.b("EnterWeb", paramString, Vq(paramString), null, 0L, 0L, a.Dy(12));
        return false;
      }
      return true;
    }
    return false;
  }
  
  public static boolean Vu(String paramString)
  {
    try
    {
      paramString = new File(paramString);
      if ((!paramString.exists()) || (!paramString.isDirectory())) {
        paramString.mkdirs();
      }
      return true;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  public static void a(String paramString, com.tencent.mm.plugin.wepkg.model.a parama)
  {
    long l = System.currentTimeMillis();
    WepkgCrossProcessTask localWepkgCrossProcessTask = new WepkgCrossProcessTask();
    localWepkgCrossProcessTask.uC = 1001;
    localWepkgCrossProcessTask.rPn = paramString;
    if (ae.cqV())
    {
      DS().O(new d.1(localWepkgCrossProcessTask, parama));
      return;
    }
    localWepkgCrossProcessTask.gfD = new d.2(l, parama, localWepkgCrossProcessTask);
    localWepkgCrossProcessTask.ahC();
    WepkgMainProcessService.a(localWepkgCrossProcessTask);
  }
  
  public static <T> T aU(T paramT)
  {
    geC.add(paramT);
    return paramT;
  }
  
  public static void aa(Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    geC.remove(paramObject);
  }
  
  public static void aqp()
  {
    if (edy == null) {
      return;
    }
    synchronized (hkZ)
    {
      if (edy != null)
      {
        edy.mnU.quit();
        edy = null;
      }
      return;
    }
  }
  
  public static long aqv()
  {
    return bk.UX();
  }
  
  public static boolean cke()
  {
    GregorianCalendar localGregorianCalendar = new GregorianCalendar();
    int i = localGregorianCalendar.get(11);
    int j = localGregorianCalendar.get(12);
    if ((i >= 12) && (i < 14)) {}
    do
    {
      return true;
      if (i != 14) {
        break;
      }
    } while (j <= 30);
    while ((i < 18) || (i > 24)) {
      return false;
    }
    return true;
  }
  
  public static boolean dR(Context paramContext)
  {
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    if (paramContext == null) {
      return false;
    }
    paramContext = paramContext.iterator();
    while (paramContext.hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
      if ((localRunningAppProcessInfo.importance == 100) && ((localRunningAppProcessInfo.processName.equals("com.tencent.mm")) || (localRunningAppProcessInfo.processName.equals("com.tencent.mm:tools")) || (localRunningAppProcessInfo.processName.equals("com.tencent.mm:toolsmp")))) {
        return true;
      }
    }
    return false;
  }
  
  public static String fN(String paramString1, String paramString2)
  {
    if ((bk.bl(paramString1)) || (bk.bl(paramString2))) {
      return "";
    }
    return Vp(paramString1) + paramString2;
  }
  
  public static String fO(String paramString1, String paramString2)
  {
    return g.o((paramString1 + "_" + paramString2).getBytes());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.utils.d
 * JD-Core Version:    0.7.0.1
 */