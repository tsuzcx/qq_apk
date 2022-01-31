package com.tencent.xweb.xwalk.a;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import org.xwalk.core.NetworkUtil;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializer;
import org.xwalk.core.XWalkUpdater.UpdateConfig;

public class c
{
  static c xnc;
  static a xnd;
  
  public static void KK(int paramInt)
  {
    if (paramInt == -10)
    {
      localObject = XWalkEnvironment.getSharedPreferencesForUpdateConfig();
      paramInt = ((SharedPreferences)localObject).getInt("nTryUseSharedCoreCount", 0);
      XWalkInitializer.addXWalkInitializeLog("onUpdateFailed shared mode, current nTryUseSharedCoreCount: " + paramInt);
      paramInt += 1;
      cTR().xnk = paramInt;
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putInt("nTryUseSharedCoreCount", paramInt);
      a((SharedPreferences.Editor)localObject, paramInt);
      ((SharedPreferences.Editor)localObject).commit();
    }
    while (!NetworkUtil.isNetworkAvailable()) {
      return;
    }
    Object localObject = XWalkEnvironment.getSharedPreferencesForUpdateConfig();
    int j = ((SharedPreferences)localObject).getInt("nTryCnt", 0) + 1;
    int i;
    if ((paramInt == -3) || (paramInt == -4))
    {
      cTR().xnf = false;
      cTR().xmS = cTR().xng;
      cTR().xmT = false;
      a(cTR());
      XWalkInitializer.addXWalkInitializeLog("switch to full package update");
      i = j;
    }
    while (i > 3)
    {
      XWalkInitializer.addXWalkInitializeLog("FailedTooManytimes at this version");
      XWalkInitializer.addXWalkInitializeLog("abandon Current Scheduler");
      a(null);
      return;
      i = j;
      if (paramInt <= -2)
      {
        i = j;
        if (paramInt >= -5) {
          i = j + 3;
        }
      }
    }
    cTR().xnj = i;
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putInt("nTryCnt", i);
    a((SharedPreferences.Editor)localObject, i);
    ((SharedPreferences.Editor)localObject).commit();
  }
  
  private static boolean V(long paramLong1, long paramLong2)
  {
    if ((paramLong1 > paramLong2 + 86400000L) || (paramLong1 + 86400000L < paramLong2)) {
      return true;
    }
    XWalkInitializer.addXWalkInitializeLog("the most recent time to fetch config is too close");
    return false;
  }
  
  public static a a(a.a parama)
  {
    if (parama == null) {}
    label193:
    label219:
    label478:
    label488:
    label507:
    label510:
    do
    {
      for (;;)
      {
        return null;
        if ((XWalkEnvironment.isForbidDownloadCode()) && (!XWalkEnvironment.isInTestMode()))
        {
          XWalkInitializer.addXWalkInitializeLog("it's gp version , dont down load any runtime version");
          return null;
        }
        a locala2 = cTR();
        if ((locala2 != null) && (locala2.xmO != parama.xmO))
        {
          a locala1 = new a();
          Object localObject1;
          Object localObject2;
          int j;
          int i;
          if ((parama == null) || (parama.xmP == null) || (parama.xmP.length == 0))
          {
            localObject1 = null;
            if ((localObject1 == null) || (localObject1.xmZ <= XWalkEnvironment.getInstalledNewstVersion())) {
              break label507;
            }
            XWalkInitializer.addXWalkInitializeLog("got matched version");
            locala1.xmO = parama.xmO;
            locala1.xmN = localObject1.xmN;
            locala1.xmZ = localObject1.xmZ;
            locala1.xni = localObject1.xna.xnb;
            locala1.xmT = localObject1.xmT;
            locala1.bUseCdn = localObject1.bUseCdn;
            locala1.bTryUseSharedCore = localObject1.bTryUseSharedCore;
            if (localObject1.xmY == null) {
              break label478;
            }
            localObject2 = localObject1.xmY;
            j = localObject2.length;
            i = 0;
            if (i >= j) {
              break label478;
            }
            parama = localObject2[i];
            if (parama.xmR != XWalkEnvironment.getInstalledNewstVersion()) {
              break label471;
            }
            XWalkInitializer.addXWalkInitializeLog("got matched patch");
            locala1.xng = localObject1.xmS;
            if (parama == null) {
              break label488;
            }
            locala1.xnf = true;
            locala1.xmS = parama.xmS;
            locala1.bvC = parama.xmN;
            locala1.xmT = parama.xmT;
            locala1.bUseCdn = parama.bUseCdn;
            double d = Math.random();
            i = (int)(localObject1.xmX * d);
            locala1.xnh = (i * 60 * 1000 + System.currentTimeMillis());
            XWalkInitializer.addXWalkInitializeLog("schedul after " + i + " minute to update");
          }
          for (parama = locala1;; parama = null)
          {
            if (parama == null) {
              break label510;
            }
            if ((parama.xmZ != locala2.xmZ) && ((parama.xmN == null) || (!parama.xmN.equals(locala2.xmN)))) {
              break label512;
            }
            XWalkInitializer.addXWalkInitializeLog("got same version to scheduler, abandon it ");
            return null;
            i = Build.VERSION.SDK_INT;
            localObject2 = parama.xmP;
            j = localObject2.length;
            i = 0;
            if (i < j)
            {
              localObject1 = localObject2[i];
              if (localObject1 == null) {
                XWalkInitializer.addXWalkInitializeLog("no matched version  version == null");
              }
              while ((localObject1.xmZ < 49) || (localObject1.xmZ <= XWalkEnvironment.getInstalledNewstVersion()) || (!localObject1.xiX.cSF()))
              {
                i += 1;
                break;
              }
              break;
            }
            XWalkInitializer.addXWalkInitializeLog("no matched version");
            localObject1 = null;
            break;
            i += 1;
            break label193;
            XWalkInitializer.addXWalkInitializeLog("no matched patch");
            parama = null;
            break label219;
            locala1.xnf = false;
            locala1.xmS = localObject1.xmS;
            break label275;
          }
        }
      }
      if (cTM()) {
        XWalkInitializer.addXWalkInitializeLog("got new scheduler replace current , version is " + parama.xmZ);
      }
    } while (parama == null);
    label275:
    label471:
    a(parama);
    label512:
    return parama;
  }
  
  private static void a(SharedPreferences.Editor paramEditor, int paramInt)
  {
    try
    {
      long l1 = System.currentTimeMillis();
      long l2 = 7200000 * paramInt;
      XWalkInitializer.addXWalkInitializeLog("rescheduler update time after " + 7200000 * paramInt / 60000 + " minute");
      paramEditor.putLong("nTimeToUpdate", l1 + l2);
      return;
    }
    finally {}
  }
  
  public static void a(a parama)
  {
    try
    {
      xnd = parama;
      if (parama == null) {
        xnd = new a();
      }
      parama = XWalkEnvironment.getSharedPreferencesForUpdateConfig().edit();
      parama.putString("strMd5", xnd.xmN);
      parama.putString("strUrl", xnd.xmS);
      parama.putString("strFullPackageUrl", xnd.xng);
      parama.putString("strConfigVer", xnd.xmO);
      parama.putBoolean("bIsPatchUpdate", xnd.xnf);
      parama.putBoolean("bCanUseCellular", xnd.xmT);
      parama.putBoolean("bUseCdn", xnd.bUseCdn);
      parama.putLong("nTimeToUpdate", xnd.xnh);
      parama.putInt("nApkVer", xnd.xmZ);
      parama.putInt("nTryCnt", xnd.xnj);
      parama.putInt("nTryUseSharedCoreCount", xnd.xnk);
      parama.putString("strPatchMd5", xnd.bvC);
      parama.putString("strVersionDetail", xnd.xni);
      parama.putBoolean("bTryUseSharedCore", xnd.bTryUseSharedCore);
      parama.commit();
      return;
    }
    finally {}
  }
  
  public static c cTK()
  {
    try
    {
      if (xnc == null) {
        xnc = new c();
      }
      c localc = xnc;
      return localc;
    }
    finally {}
  }
  
  public static boolean cTL()
  {
    if (!cTM()) {
      return false;
    }
    XWalkInitializer.addXWalkInitializeLog("has scheduler for update");
    return true;
  }
  
  /* Error */
  public static boolean cTM()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: ldc 2
    //   4: monitorenter
    //   5: iload_3
    //   6: istore_2
    //   7: invokestatic 56	com/tencent/xweb/xwalk/a/c:cTR	()Lcom/tencent/xweb/xwalk/a/c$a;
    //   10: ifnull +30 -> 40
    //   13: iload_3
    //   14: istore_2
    //   15: invokestatic 56	com/tencent/xweb/xwalk/a/c:cTR	()Lcom/tencent/xweb/xwalk/a/c$a;
    //   18: getfield 95	com/tencent/xweb/xwalk/a/c$a:xmS	Ljava/lang/String;
    //   21: ifnull +19 -> 40
    //   24: invokestatic 56	com/tencent/xweb/xwalk/a/c:cTR	()Lcom/tencent/xweb/xwalk/a/c$a;
    //   27: getfield 95	com/tencent/xweb/xwalk/a/c$a:xmS	Ljava/lang/String;
    //   30: invokevirtual 304	java/lang/String:isEmpty	()Z
    //   33: istore_2
    //   34: iload_2
    //   35: ifeq +10 -> 45
    //   38: iload_3
    //   39: istore_2
    //   40: ldc 2
    //   42: monitorexit
    //   43: iload_2
    //   44: ireturn
    //   45: invokestatic 56	com/tencent/xweb/xwalk/a/c:cTR	()Lcom/tencent/xweb/xwalk/a/c$a;
    //   48: getfield 152	com/tencent/xweb/xwalk/a/c$a:xmZ	I
    //   51: istore_0
    //   52: invokestatic 145	org/xwalk/core/XWalkEnvironment:getInstalledNewstVersion	()I
    //   55: istore_1
    //   56: iload_3
    //   57: istore_2
    //   58: iload_0
    //   59: iload_1
    //   60: if_icmple -20 -> 40
    //   63: iconst_1
    //   64: istore_2
    //   65: goto -25 -> 40
    //   68: astore 4
    //   70: ldc 2
    //   72: monitorexit
    //   73: aload 4
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   51	10	0	i	int
    //   55	6	1	j	int
    //   6	59	2	bool1	boolean
    //   1	56	3	bool2	boolean
    //   68	6	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   7	13	68	finally
    //   15	34	68	finally
    //   45	56	68	finally
  }
  
  public static void cTP()
  {
    cTR().xne = System.currentTimeMillis();
    SharedPreferences.Editor localEditor = XWalkEnvironment.getSharedPreferencesForUpdateConfig().edit();
    localEditor.putLong("nLastFetchConfigTime", cTR().xne);
    localEditor.commit();
  }
  
  public static boolean cTQ()
  {
    long l1 = System.currentTimeMillis();
    if (V(l1, cTR().xne))
    {
      long l2 = XWalkEnvironment.getSharedPreferencesForUpdateConfig().getLong("nLastFetchConfigTime", 0L);
      cTR().xne = l2;
      if (V(l1, l2))
      {
        XWalkInitializer.addXWalkInitializeLog("enough time after last time fetch config");
        return true;
      }
    }
    return false;
  }
  
  public static a cTR()
  {
    if (xnd != null) {
      return xnd;
    }
    xnd = new a();
    SharedPreferences localSharedPreferences = XWalkEnvironment.getSharedPreferencesForUpdateConfig();
    xnd.xne = localSharedPreferences.getLong("nLastFetchConfigTime", 0L);
    if (!localSharedPreferences.contains("strUrl")) {
      return xnd;
    }
    xnd.xmN = localSharedPreferences.getString("strMd5", null);
    xnd.xmS = localSharedPreferences.getString("strUrl", null);
    xnd.xng = localSharedPreferences.getString("strFullPackageUrl", null);
    xnd.xmO = localSharedPreferences.getString("strConfigVer", null);
    xnd.xnf = localSharedPreferences.getBoolean("bIsPatchUpdate", false);
    xnd.xnh = localSharedPreferences.getLong("nTimeToUpdate", 0L);
    xnd.xmZ = localSharedPreferences.getInt("nApkVer", 0);
    xnd.xnj = localSharedPreferences.getInt("nTryCnt", 0);
    xnd.xnk = localSharedPreferences.getInt("nTryUseSharedCoreCount", 0);
    xnd.bvC = localSharedPreferences.getString("strPatchMd5", null);
    xnd.xni = localSharedPreferences.getString("strVersionDetail", null);
    xnd.xmT = localSharedPreferences.getBoolean("bCanUseCellular", false);
    xnd.bUseCdn = localSharedPreferences.getBoolean("bUseCdn", false);
    xnd.bTryUseSharedCore = localSharedPreferences.getBoolean("bTryUseSharedCore", true);
    return xnd;
  }
  
  /* Error */
  public final boolean cTN()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: invokestatic 249	com/tencent/xweb/xwalk/a/c:cTM	()Z
    //   7: istore_2
    //   8: iload_2
    //   9: ifne +7 -> 16
    //   12: aload_0
    //   13: monitorexit
    //   14: iload_1
    //   15: ireturn
    //   16: invokestatic 207	java/lang/System:currentTimeMillis	()J
    //   19: invokestatic 56	com/tencent/xweb/xwalk/a/c:cTR	()Lcom/tencent/xweb/xwalk/a/c$a;
    //   22: getfield 211	com/tencent/xweb/xwalk/a/c$a:xnh	J
    //   25: lcmp
    //   26: iflt +14 -> 40
    //   29: ldc_w 334
    //   32: invokestatic 52	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   35: iconst_1
    //   36: istore_1
    //   37: goto -25 -> 12
    //   40: ldc_w 336
    //   43: invokestatic 52	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   46: goto -34 -> 12
    //   49: astore_3
    //   50: aload_0
    //   51: monitorexit
    //   52: aload_3
    //   53: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	this	c
    //   1	36	1	bool1	boolean
    //   7	2	2	bool2	boolean
    //   49	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	8	49	finally
    //   16	35	49	finally
    //   40	46	49	finally
  }
  
  public final void cTO()
  {
    try
    {
      SharedPreferences.Editor localEditor = XWalkEnvironment.getSharedPreferencesForUpdateConfig().edit();
      localEditor.putLong("nLastFetchConfigTime", 0L);
      localEditor.commit();
      cTR().xne = 0L;
      cTR().xnh = 0L;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static final class a
  {
    public boolean bTryUseSharedCore;
    public boolean bUseCdn;
    public String bvC;
    public String xmN;
    public String xmO;
    public String xmS;
    public boolean xmT;
    public int xmZ;
    public long xne;
    public boolean xnf;
    public String xng;
    public long xnh;
    public String xni;
    public int xnj;
    public int xnk;
    
    static
    {
      if (!c.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        return;
      }
    }
    
    public final XWalkUpdater.UpdateConfig cTS()
    {
      try
      {
        if (this.xnf) {
          break label120;
        }
        if ((this.xmN != null) && (!this.xmN.isEmpty())) {
          break label95;
        }
        if (!$assertionsDisabled) {
          throw new AssertionError("royle:no md5 info, maybe something wrong");
        }
      }
      catch (Exception localException)
      {
        XWalkInitializer.addXWalkInitializeLog("create  UpdateConfig failed , args is not valid");
        c.a(null);
        return null;
      }
      XWalkUpdater.UpdateConfig localUpdateConfig = new XWalkUpdater.UpdateConfig(this.xmS, false, this.xmZ);
      for (;;)
      {
        localUpdateConfig.versionDetail = this.xni;
        localUpdateConfig.bUseCdn = this.bUseCdn;
        localUpdateConfig.bTryUseSharedCore = this.bTryUseSharedCore;
        return localUpdateConfig;
        label95:
        localUpdateConfig = new XWalkUpdater.UpdateConfig(this.xmN, false, null, this.xmS, this.xmZ);
        continue;
        label120:
        if ((this.xmN == null) || (this.xmN.isEmpty()) || (this.bvC == null) || (this.bvC.isEmpty()))
        {
          if (!$assertionsDisabled) {
            throw new AssertionError("royle:no md5 info, maybe something wrong");
          }
          localUpdateConfig = new XWalkUpdater.UpdateConfig(this.xmS, true, this.xmZ);
        }
        else
        {
          localUpdateConfig = new XWalkUpdater.UpdateConfig(this.bvC, true, this.xmN, this.xmS, this.xmZ);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.xweb.xwalk.a.c
 * JD-Core Version:    0.7.0.1
 */