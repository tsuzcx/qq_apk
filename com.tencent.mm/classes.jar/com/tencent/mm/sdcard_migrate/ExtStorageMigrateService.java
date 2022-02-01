package com.tencent.mm.sdcard_migrate;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Binder;
import android.os.Build.VERSION;
import android.os.CancellationSignal;
import android.os.IBinder;
import android.os.Parcelable;
import android.os.PowerManager.WakeLock;
import android.support.v4.app.s.a;
import android.support.v4.app.s.a.a;
import android.support.v4.app.s.c;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdcard_migrate.util.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ExtStorageMigrateService
  extends Service
{
  private final b NHc;
  private final a[] NHd;
  private Thread NHe;
  private final MigrateResultCallback[] NHf;
  private volatile int NHg;
  private final boolean[] NHh;
  private final PowerManager.WakeLock[] NHi;
  private final boolean[] NHj;
  private final e.a NHk;
  
  public ExtStorageMigrateService()
  {
    AppMethodBeat.i(169829);
    this.NHc = new b((byte)0);
    this.NHd = new a[] { null };
    this.NHe = null;
    this.NHf = new MigrateResultCallback[] { null };
    this.NHg = 0;
    this.NHh = new boolean[] { false };
    this.NHi = new PowerManager.WakeLock[] { null };
    this.NHj = new boolean[] { false };
    this.NHk = new e.a()
    {
      public final void a(ExtStorageMigrateConfig paramAnonymousExtStorageMigrateConfig)
      {
        AppMethodBeat.i(232388);
        ExtStorageMigrateService.a(ExtStorageMigrateService.this, paramAnonymousExtStorageMigrateConfig);
        AppMethodBeat.o(232388);
      }
      
      public final void a(MigrateResultCallback paramAnonymousMigrateResultCallback)
      {
        AppMethodBeat.i(232386);
        synchronized (ExtStorageMigrateService.a(ExtStorageMigrateService.this))
        {
          if ((ExtStorageMigrateService.a(ExtStorageMigrateService.this)[0] != null) && (ExtStorageMigrateService.a(ExtStorageMigrateService.this)[0] != paramAnonymousMigrateResultCallback)) {
            ExtStorageMigrateService.a(ExtStorageMigrateService.this)[0].kJ(ExtStorageMigrateService.c(ExtStorageMigrateService.this), Binder.getCallingPid());
          }
          ExtStorageMigrateService.a(ExtStorageMigrateService.this)[0] = paramAnonymousMigrateResultCallback;
          if (!gwS()) {
            break label147;
          }
        }
        synchronized (ExtStorageMigrateService.b(ExtStorageMigrateService.this))
        {
          paramAnonymousMigrateResultCallback.mN(ExtStorageMigrateService.a.c(ExtStorageMigrateService.b(ExtStorageMigrateService.this)[0]), ExtStorageMigrateService.a.d(ExtStorageMigrateService.b(ExtStorageMigrateService.this)[0]));
          AppMethodBeat.o(232386);
          return;
          paramAnonymousMigrateResultCallback = finally;
          AppMethodBeat.o(232386);
          throw paramAnonymousMigrateResultCallback;
        }
        label147:
        AppMethodBeat.o(232386);
      }
      
      public final void b(MigrateResultCallback arg1)
      {
        AppMethodBeat.i(232387);
        synchronized (ExtStorageMigrateService.a(ExtStorageMigrateService.this))
        {
          if (ExtStorageMigrateService.a(ExtStorageMigrateService.this)[0] != null) {
            ExtStorageMigrateService.a(ExtStorageMigrateService.this)[0] = null;
          }
          AppMethodBeat.o(232387);
          return;
        }
      }
      
      public final boolean gwS()
      {
        AppMethodBeat.i(232385);
        if ((ExtStorageMigrateService.b(ExtStorageMigrateService.this)[0] != null) && (ExtStorageMigrateService.a.b(ExtStorageMigrateService.b(ExtStorageMigrateService.this)[0])))
        {
          AppMethodBeat.o(232385);
          return true;
        }
        AppMethodBeat.o(232385);
        return false;
      }
      
      public final void gwW()
      {
        AppMethodBeat.i(232389);
        ExtStorageMigrateService.d(ExtStorageMigrateService.this);
        AppMethodBeat.o(232389);
      }
    };
    AppMethodBeat.o(169829);
  }
  
  private void AC(boolean paramBoolean)
  {
    synchronized (this.NHh)
    {
      this.NHh[0] = paramBoolean;
      return;
    }
  }
  
  private void AD(boolean paramBoolean)
  {
    synchronized (this.NHj)
    {
      this.NHj[0] = paramBoolean;
      return;
    }
  }
  
  private static File Q(File paramFile)
  {
    AppMethodBeat.i(169830);
    try
    {
      File localFile = paramFile.getCanonicalFile();
      AppMethodBeat.o(169830);
      return localFile;
    }
    catch (Throwable localThrowable)
    {
      ExtStorageMigrateMonitor.gwK().printErrStackTrace("MicroMsg.ExtStorageMigrateService", localThrowable, "[-] Fail to get canonical file for: %s", new Object[] { paramFile.getAbsolutePath() });
      paramFile = paramFile.getAbsoluteFile();
      AppMethodBeat.o(169830);
    }
    return paramFile;
  }
  
  private static String Wr(String paramString)
  {
    AppMethodBeat.i(169831);
    try
    {
      String str = new File(paramString).getCanonicalPath();
      AppMethodBeat.o(169831);
      return str;
    }
    catch (Throwable localThrowable)
    {
      ExtStorageMigrateMonitor.gwK().printErrStackTrace("MicroMsg.ExtStorageMigrateService", localThrowable, "[-] Fail to get canonical path for: %s", new Object[] { paramString });
      paramString = new File(paramString).getAbsolutePath();
      AppMethodBeat.o(169831);
    }
    return paramString;
  }
  
  private boolean gwS()
  {
    boolean bool2 = false;
    AppMethodBeat.i(232402);
    a[] arrayOfa = this.NHd;
    boolean bool1 = bool2;
    try
    {
      if (this.NHd[0] != null)
      {
        bool1 = bool2;
        if (a.b(this.NHd[0])) {
          bool1 = true;
        }
      }
      return bool1;
    }
    finally
    {
      AppMethodBeat.o(232402);
    }
  }
  
  private boolean gwT()
  {
    synchronized (this.NHh)
    {
      int i = this.NHh[0];
      return i;
    }
  }
  
  private boolean gwU()
  {
    synchronized (this.NHj)
    {
      int i = this.NHj[0];
      return i;
    }
  }
  
  private void gwV()
  {
    AppMethodBeat.i(232403);
    ExtStorageMigrateMonitor.gwK().i("MicroMsg.ExtStorageMigrateService", "[+] expectedStopSelf called.", new Object[0]);
    AD(true);
    stopSelf();
    AppMethodBeat.o(232403);
  }
  
  private void releaseWakeLock()
  {
    AppMethodBeat.i(232404);
    synchronized (this.NHi)
    {
      if ((this.NHi[0] != null) && (this.NHi[0].isHeld()))
      {
        this.NHi[0].release();
        this.NHi[0] = null;
        ExtStorageMigrateMonitor.gwK().i("MicroMsg.ExtStorageMigrateService", "[+] WakeLock released.", new Object[0]);
      }
      AppMethodBeat.o(232404);
      return;
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    AppMethodBeat.i(232401);
    paramIntent = this.NHk.asBinder();
    AppMethodBeat.o(232401);
    return paramIntent;
  }
  
  public void onCreate()
  {
    AppMethodBeat.i(232400);
    super.onCreate();
    synchronized (this.NHd)
    {
      this.NHd[0] = null;
      this.NHe = null;
    }
    synchronized (this.NHf)
    {
      this.NHf[0] = null;
      this.NHg = 0;
      AC(false);
      AppMethodBeat.o(232400);
      return;
      localObject2 = finally;
      AppMethodBeat.o(232400);
      throw localObject2;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(169833);
    ExtStorageMigrateMonitor.gwK().i("MicroMsg.ExtStorageMigrateService", "[+] OnDestroy called.", new Object[0]);
    synchronized (this.NHd)
    {
      if (gwS()) {
        a.a(this.NHd[0]);
      }
    }
    try
    {
      this.NHe.join();
      for (;;)
      {
        label53:
        this.NHd[0] = null;
        if (gwT()) {
          stopForeground(true);
        }
        releaseWakeLock();
        AppMethodBeat.o(169833);
        return;
        if (gwT()) {
          if (gwU())
          {
            AD(false);
            this.NHc.ajG(2);
            continue;
            localObject = finally;
            AppMethodBeat.o(169833);
            throw localObject;
          }
          else
          {
            this.NHc.c(6, null);
          }
        }
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      break label53;
    }
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(169832);
    ExtStorageMigrateMonitor.gwK().i("MicroMsg.ExtStorageMigrateService", "[+] OnStartCommand called, intent: %s", new Object[] { paramIntent });
    if (paramIntent == null)
    {
      ExtStorageMigrateMonitor.gwK().e("MicroMsg.ExtStorageMigrateService", "[-] intent is null, skip rest logic.", new Object[0]);
      gwV();
    }
    for (;;)
    {
      AppMethodBeat.o(169832);
      return 2;
      paramIntent = paramIntent.getAction();
      if (paramIntent == null)
      {
        ExtStorageMigrateMonitor.gwK().e("MicroMsg.ExtStorageMigrateService", "[-] action is null, skip rest logic.", new Object[0]);
        gwV();
      }
      else if ("service_action_startup".equals(paramIntent))
      {
        Object localObject = this.NHc;
        if ((((b)localObject).NHl.gwT()) || (((b)localObject).NHl.gwS()))
        {
          ExtStorageMigrateMonitor.gwK().w("MicroMsg.ExtStorageMigrateService", "[!] Already on foreground or migrating logic, skip startup steps.", new Object[0]);
        }
        else
        {
          paramIntent = ((b)localObject).AF(true);
          s.c localc = paramIntent.i(System.currentTimeMillis()).g(MMApplicationContext.getResources().getString(2131758973)).b(0, 0, true);
          localc.g(2, true);
          localc.a(((b)localObject).gwX()).Hv = ((b)localObject).AG(false);
          localObject = ((b)localObject).NHl;
          ((ExtStorageMigrateService)localObject).startForeground(1027, paramIntent.build());
          ((ExtStorageMigrateService)localObject).AC(true);
        }
      }
      else if ("service_action_cancel_migrate".equals(paramIntent))
      {
        gwV();
      }
      else
      {
        ExtStorageMigrateMonitor.gwK().e("MicroMsg.ExtStorageMigrateService", "[-] Unknown action: %s", new Object[] { paramIntent });
      }
    }
  }
  
  final class a
    implements Runnable
  {
    private final boolean NGN;
    private final boolean[] NHm;
    private final CancellationSignal NHn;
    private final Set<String> NHo;
    private final Set<String> NHp;
    private final Map<String, String> NHq;
    private String NHr;
    private String NHs;
    private ByteBuffer NHt;
    private float mProgress;
    
    a(ExtStorageMigrateConfig paramExtStorageMigrateConfig, CancellationSignal paramCancellationSignal)
    {
      AppMethodBeat.i(232390);
      this.NHm = new boolean[] { false };
      this.NHr = null;
      this.NHs = null;
      this.NHt = null;
      this.mProgress = 0.0F;
      this.NHn = paramCancellationSignal;
      this.NGN = paramExtStorageMigrateConfig.NGI;
      this.NHo = new HashSet(64);
      this.NHp = new HashSet(5);
      this.NHq = new HashMap(5);
      this.NHr = ExtStorageMigrateService.access$1500(paramExtStorageMigrateConfig.sourceDir);
      this.NHs = ExtStorageMigrateService.access$1500(paramExtStorageMigrateConfig.NGH);
      if (paramExtStorageMigrateConfig.NGI) {
        ExtStorageMigrateMonitor.gwK().w("MicroMsg.ExtStorageMigrateService", "[!] Force copy mode enabled, are we under test mode ??", new Object[0]);
      }
      b(paramExtStorageMigrateConfig.sourceDir, paramExtStorageMigrateConfig.NGJ);
      ExtStorageMigrateMonitor.gwK().i("MicroMsg.ExtStorageMigrateService", "[+] MigrateTask, pass in config: %s", new Object[] { paramExtStorageMigrateConfig });
      AppMethodBeat.o(232390);
    }
    
    private void AE(boolean paramBoolean)
    {
      synchronized (this.NHm)
      {
        this.NHm[0] = paramBoolean;
        return;
      }
    }
    
    private String S(File paramFile)
    {
      AppMethodBeat.i(169821);
      paramFile = bhP(paramFile.getAbsolutePath().substring(this.NHr.length()));
      if (paramFile.startsWith("/")) {
        paramFile = paramFile.substring(1);
      }
      for (;;)
      {
        ExtStorageMigrateMonitor.gwK().i("MicroMsg.ExtStorageMigrateService", "[+] getMigratedFilePath, relSrcPath: %s", new Object[] { paramFile });
        Object localObject2;
        label182:
        int i;
        for (Object localObject1 = paramFile;; localObject1 = ((String)localObject1).substring(0, i))
        {
          localObject2 = paramFile;
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject2 = (String)this.NHq.get(localObject1);
            ExtStorageMigrateMonitor.gwK().i("MicroMsg.ExtStorageMigrateService", "[+] getMigratedFilePath, currRelSrcPath: %s, newRelPath: %s", new Object[] { localObject1, localObject2 });
            if (localObject2 == null) {
              break label182;
            }
            localObject2 = (String)localObject2 + paramFile.substring(((String)localObject1).length());
          }
          do
          {
            if (!((String)localObject2).startsWith("/")) {
              break;
            }
            ExtStorageMigrateMonitor.gwK().i("MicroMsg.ExtStorageMigrateService", "[+] getMigratedFilePath, result: %s", new Object[] { localObject2 });
            AppMethodBeat.o(169821);
            return localObject2;
            i = ((String)localObject1).lastIndexOf('/');
            localObject2 = paramFile;
          } while (i < 0);
        }
        paramFile = this.NHs + "/" + (String)localObject2;
        ExtStorageMigrateMonitor.gwK().i("MicroMsg.ExtStorageMigrateService", "[+] getMigratedFilePath, result: %s", new Object[] { paramFile });
        AppMethodBeat.o(169821);
        return paramFile;
      }
    }
    
    private void b(String paramString, Collection<ExtStorageMigrateConfig.ExtraPathAction> paramCollection)
    {
      AppMethodBeat.i(232391);
      if (paramCollection == null)
      {
        AppMethodBeat.o(232391);
        return;
      }
      Iterator localIterator = paramCollection.iterator();
      while (localIterator.hasNext())
      {
        paramCollection = (Parcelable)localIterator.next();
        Object localObject;
        if ((paramCollection instanceof ExtStorageMigrateConfig.ExtraPathAction.Ignore))
        {
          paramCollection = (ExtStorageMigrateConfig.ExtraPathAction.Ignore)paramCollection;
          localObject = ExtStorageMigrateService.R(new File(paramString, paramCollection.NGP));
          this.NHp.add(((File)localObject).getAbsolutePath());
          mM(paramString, paramCollection.NGP);
        }
        else if ((paramCollection instanceof ExtStorageMigrateConfig.ExtraPathAction.Remap))
        {
          localObject = (ExtStorageMigrateConfig.ExtraPathAction.Remap)paramCollection;
          Map localMap = this.NHq;
          String str = bhP(((ExtStorageMigrateConfig.ExtraPathAction.Remap)localObject).NGQ);
          if (((ExtStorageMigrateConfig.ExtraPathAction.Remap)localObject).jrL.startsWith("/")) {}
          for (paramCollection = ((ExtStorageMigrateConfig.ExtraPathAction.Remap)localObject).jrL;; paramCollection = bhP(((ExtStorageMigrateConfig.ExtraPathAction.Remap)localObject).jrL))
          {
            localMap.put(str, paramCollection);
            mM(paramString, ((ExtStorageMigrateConfig.ExtraPathAction.Remap)localObject).NGQ);
            break;
          }
        }
      }
      this.NHo.add(paramString);
      ExtStorageMigrateMonitor.gwK().i("MicroMsg.ExtStorageMigrateService", "[+] MigrateTask, mSrcDirPath: %s, mDestDirPath: %s, mRemappedRelPaths: %s", new Object[] { this.NHr, this.NHs, this.NHq });
      AppMethodBeat.o(232391);
    }
    
    private static String bhO(String paramString)
    {
      AppMethodBeat.i(169817);
      if ((paramString == null) || (paramString.isEmpty()))
      {
        AppMethodBeat.o(169817);
        return paramString;
      }
      if ((paramString.endsWith("/")) || (paramString.endsWith("\\")))
      {
        paramString = paramString.substring(0, paramString.length() - 1);
        AppMethodBeat.o(169817);
        return paramString;
      }
      AppMethodBeat.o(169817);
      return paramString;
    }
    
    private static String bhP(String paramString)
    {
      AppMethodBeat.i(169818);
      if ((paramString == null) || (paramString.isEmpty()))
      {
        AppMethodBeat.o(169818);
        return paramString;
      }
      String str = new File(paramString).getPath();
      if (!str.endsWith("/"))
      {
        paramString = str;
        if (!str.endsWith("\\")) {}
      }
      else
      {
        paramString = str.substring(0, str.length() - 1);
      }
      AppMethodBeat.o(169818);
      return paramString;
    }
    
    /* Error */
    private void e(File paramFile1, File paramFile2)
    {
      // Byte code:
      //   0: ldc_w 275
      //   3: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   6: aload_2
      //   7: invokevirtual 278	java/io/File:exists	()Z
      //   10: ifne +11 -> 21
      //   13: aload_2
      //   14: invokevirtual 282	java/io/File:getParentFile	()Ljava/io/File;
      //   17: invokevirtual 285	java/io/File:mkdirs	()Z
      //   20: pop
      //   21: new 287	java/io/BufferedInputStream
      //   24: dup
      //   25: new 289	java/io/FileInputStream
      //   28: dup
      //   29: aload_1
      //   30: invokespecial 292	java/io/FileInputStream:<init>	(Ljava/io/File;)V
      //   33: invokespecial 295	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
      //   36: astore 4
      //   38: new 297	java/io/BufferedOutputStream
      //   41: dup
      //   42: new 299	java/io/FileOutputStream
      //   45: dup
      //   46: aload_2
      //   47: invokespecial 300	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
      //   50: invokespecial 303	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
      //   53: astore 5
      //   55: sipush 4096
      //   58: newarray byte
      //   60: astore 6
      //   62: aload 4
      //   64: aload 6
      //   66: invokevirtual 309	java/io/InputStream:read	([B)I
      //   69: istore_3
      //   70: iload_3
      //   71: ifle +43 -> 114
      //   74: aload_0
      //   75: getfield 59	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:NHn	Landroid/os/CancellationSignal;
      //   78: invokevirtual 312	android/os/CancellationSignal:throwIfCanceled	()V
      //   81: aload 5
      //   83: aload 6
      //   85: iconst_0
      //   86: iload_3
      //   87: invokevirtual 318	java/io/OutputStream:write	([BII)V
      //   90: goto -28 -> 62
      //   93: astore_1
      //   94: aload 5
      //   96: astore_2
      //   97: aload_2
      //   98: invokestatic 324	com/tencent/mm/vfs/aa:closeQuietly	(Ljava/io/Closeable;)V
      //   101: aload 4
      //   103: invokestatic 324	com/tencent/mm/vfs/aa:closeQuietly	(Ljava/io/Closeable;)V
      //   106: ldc_w 275
      //   109: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   112: aload_1
      //   113: athrow
      //   114: invokestatic 95	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:gwK	()Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$a;
      //   117: ldc 97
      //   119: ldc_w 326
      //   122: iconst_2
      //   123: anewarray 4	java/lang/Object
      //   126: dup
      //   127: iconst_0
      //   128: aload_1
      //   129: invokevirtual 131	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   132: aastore
      //   133: dup
      //   134: iconst_1
      //   135: aload_2
      //   136: invokevirtual 131	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   139: aastore
      //   140: invokeinterface 328 4 0
      //   145: aload 5
      //   147: invokestatic 324	com/tencent/mm/vfs/aa:closeQuietly	(Ljava/io/Closeable;)V
      //   150: aload 4
      //   152: invokestatic 324	com/tencent/mm/vfs/aa:closeQuietly	(Ljava/io/Closeable;)V
      //   155: ldc_w 275
      //   158: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   161: return
      //   162: astore_1
      //   163: aconst_null
      //   164: astore_2
      //   165: aconst_null
      //   166: astore 4
      //   168: goto -71 -> 97
      //   171: astore_1
      //   172: aconst_null
      //   173: astore_2
      //   174: goto -77 -> 97
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	177	0	this	a
      //   0	177	1	paramFile1	File
      //   0	177	2	paramFile2	File
      //   69	18	3	i	int
      //   36	131	4	localBufferedInputStream	java.io.BufferedInputStream
      //   53	93	5	localBufferedOutputStream	java.io.BufferedOutputStream
      //   60	24	6	arrayOfByte	byte[]
      // Exception table:
      //   from	to	target	type
      //   55	62	93	finally
      //   62	70	93	finally
      //   74	90	93	finally
      //   114	145	93	finally
      //   21	38	162	finally
      //   38	55	171	finally
    }
    
    private boolean isRunning()
    {
      synchronized (this.NHm)
      {
        int i = this.NHm[0];
        return i;
      }
    }
    
    private void mM(String paramString1, String paramString2)
    {
      AppMethodBeat.i(169816);
      String str = bhO(paramString1);
      paramString1 = new File(str, paramString2);
      do
      {
        this.NHo.add(bhO(paramString1.getAbsolutePath()));
        paramString2 = paramString1.getParentFile();
        if (paramString2 == null) {
          break;
        }
        paramString1 = paramString2;
      } while (!str.equals(paramString2.getAbsolutePath()));
      AppMethodBeat.o(169816);
    }
    
    /* Error */
    public final void run()
    {
      // Byte code:
      //   0: ldc_w 340
      //   3: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   6: aload_0
      //   7: getfield 37	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:NHl	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   10: invokestatic 343	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:e	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;)V
      //   13: aload_0
      //   14: iconst_1
      //   15: invokespecial 345	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:AE	(Z)V
      //   18: aload_0
      //   19: getfield 37	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:NHl	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   22: invokestatic 349	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:f	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;)Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b;
      //   25: astore 10
      //   27: aload_0
      //   28: getfield 51	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:NHr	Ljava/lang/String;
      //   31: astore 7
      //   33: aload_0
      //   34: getfield 53	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:NHs	Ljava/lang/String;
      //   37: astore 8
      //   39: aload 10
      //   41: iconst_1
      //   42: invokevirtual 355	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b:AF	(Z)Landroid/support/v4/app/s$c;
      //   45: ldc_w 356
      //   48: invokestatic 359	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:ajE	(I)Ljava/lang/String;
      //   51: invokevirtual 365	android/support/v4/app/s$c:g	(Ljava/lang/CharSequence;)Landroid/support/v4/app/s$c;
      //   54: bipush 100
      //   56: iconst_0
      //   57: iconst_0
      //   58: invokevirtual 368	android/support/v4/app/s$c:b	(IIZ)Landroid/support/v4/app/s$c;
      //   61: astore 9
      //   63: aload 9
      //   65: iconst_2
      //   66: iconst_1
      //   67: invokevirtual 371	android/support/v4/app/s$c:g	(IZ)V
      //   70: aload 9
      //   72: aload 10
      //   74: invokevirtual 375	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b:gwX	()Landroid/support/v4/app/s$a;
      //   77: invokevirtual 378	android/support/v4/app/s$c:a	(Landroid/support/v4/app/s$a;)Landroid/support/v4/app/s$c;
      //   80: astore 9
      //   82: aload 9
      //   84: aload 10
      //   86: iconst_0
      //   87: invokevirtual 382	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b:AG	(Z)Landroid/app/PendingIntent;
      //   90: putfield 386	android/support/v4/app/s$c:Hv	Landroid/app/PendingIntent;
      //   93: aload 10
      //   95: getfield 387	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b:NHl	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   98: ldc_w 389
      //   101: invokevirtual 393	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
      //   104: checkcast 395	android/app/NotificationManager
      //   107: sipush 1027
      //   110: aload 9
      //   112: invokevirtual 399	android/support/v4/app/s$c:build	()Landroid/app/Notification;
      //   115: invokevirtual 403	android/app/NotificationManager:notify	(ILandroid/app/Notification;)V
      //   118: aload 10
      //   120: getfield 387	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b:NHl	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   123: invokestatic 406	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:a	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;)[Lcom/tencent/mm/sdcard_migrate/MigrateResultCallback;
      //   126: astore 9
      //   128: aload 9
      //   130: monitorenter
      //   131: aload 10
      //   133: getfield 387	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b:NHl	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   136: invokestatic 406	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:a	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;)[Lcom/tencent/mm/sdcard_migrate/MigrateResultCallback;
      //   139: iconst_0
      //   140: aaload
      //   141: astore 10
      //   143: aload 10
      //   145: ifnull +25 -> 170
      //   148: aload 10
      //   150: invokevirtual 412	com/tencent/mm/sdcard_migrate/MigrateResultCallback:asBinder	()Landroid/os/IBinder;
      //   153: invokeinterface 417 1 0
      //   158: ifeq +12 -> 170
      //   161: aload 10
      //   163: aload 7
      //   165: aload 8
      //   167: invokevirtual 420	com/tencent/mm/sdcard_migrate/MigrateResultCallback:mN	(Ljava/lang/String;Ljava/lang/String;)V
      //   170: aload 9
      //   172: monitorexit
      //   173: aload_0
      //   174: getfield 51	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:NHr	Ljava/lang/String;
      //   177: aload_0
      //   178: getfield 53	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:NHs	Ljava/lang/String;
      //   181: invokevirtual 334	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   184: ifne +1209 -> 1393
      //   187: new 127	java/io/File
      //   190: dup
      //   191: aload_0
      //   192: getfield 51	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:NHr	Ljava/lang/String;
      //   195: invokespecial 266	java/io/File:<init>	(Ljava/lang/String;)V
      //   198: astore 9
      //   200: aload 9
      //   202: invokevirtual 278	java/io/File:exists	()Z
      //   205: ifeq +1188 -> 1393
      //   208: aload 9
      //   210: invokevirtual 423	java/io/File:canRead	()Z
      //   213: ifne +225 -> 438
      //   216: new 425	java/io/IOException
      //   219: dup
      //   220: new 168	java/lang/StringBuilder
      //   223: dup
      //   224: invokespecial 169	java/lang/StringBuilder:<init>	()V
      //   227: aload 9
      //   229: invokevirtual 131	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   232: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   235: ldc_w 427
      //   238: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   241: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   244: invokespecial 428	java/io/IOException:<init>	(Ljava/lang/String;)V
      //   247: astore 7
      //   249: ldc_w 340
      //   252: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   255: aload 7
      //   257: athrow
      //   258: astore 7
      //   260: invokestatic 95	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:gwK	()Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$a;
      //   263: ldc 97
      //   265: aload 7
      //   267: ldc_w 430
      //   270: iconst_0
      //   271: anewarray 4	java/lang/Object
      //   274: invokeinterface 434 5 0
      //   279: aload_0
      //   280: getfield 37	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:NHl	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   283: invokestatic 437	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:g	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;)Z
      //   286: ifeq +1306 -> 1592
      //   289: aload_0
      //   290: getfield 37	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:NHl	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   293: invokestatic 440	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:h	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;)V
      //   296: aload_0
      //   297: getfield 37	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:NHl	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   300: invokestatic 349	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:f	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;)Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b;
      //   303: iconst_3
      //   304: invokevirtual 443	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b:ajG	(I)V
      //   307: aload_0
      //   308: iconst_0
      //   309: invokespecial 345	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:AE	(Z)V
      //   312: invokestatic 446	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:gwN	()V
      //   315: aload_0
      //   316: getfield 37	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:NHl	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   319: invokestatic 448	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:i	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;)V
      //   322: aload_0
      //   323: getfield 37	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:NHl	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   326: invokestatic 451	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:j	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;)V
      //   329: ldc_w 340
      //   332: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   335: return
      //   336: astore 7
      //   338: invokestatic 95	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:gwK	()Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$a;
      //   341: ldc_w 453
      //   344: aload 7
      //   346: ldc_w 455
      //   349: iconst_0
      //   350: anewarray 4	java/lang/Object
      //   353: invokeinterface 434 5 0
      //   358: goto -188 -> 170
      //   361: astore 7
      //   363: aload 9
      //   365: monitorexit
      //   366: ldc_w 340
      //   369: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   372: aload 7
      //   374: athrow
      //   375: astore 7
      //   377: invokestatic 95	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:gwK	()Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$a;
      //   380: ldc 97
      //   382: aload 7
      //   384: ldc_w 457
      //   387: iconst_0
      //   388: anewarray 4	java/lang/Object
      //   391: invokeinterface 434 5 0
      //   396: aload_0
      //   397: getfield 37	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:NHl	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   400: invokestatic 349	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:f	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;)Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b;
      //   403: iconst_5
      //   404: aload 7
      //   406: invokevirtual 460	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b:c	(ILjava/lang/Throwable;)V
      //   409: aload_0
      //   410: iconst_0
      //   411: invokespecial 345	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:AE	(Z)V
      //   414: invokestatic 446	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:gwN	()V
      //   417: aload_0
      //   418: getfield 37	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:NHl	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   421: invokestatic 448	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:i	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;)V
      //   424: aload_0
      //   425: getfield 37	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:NHl	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   428: invokestatic 451	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:j	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;)V
      //   431: ldc_w 340
      //   434: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   437: return
      //   438: new 462	java/util/ArrayList
      //   441: dup
      //   442: bipush 20
      //   444: invokespecial 463	java/util/ArrayList:<init>	(I)V
      //   447: astore 8
      //   449: new 462	java/util/ArrayList
      //   452: dup
      //   453: bipush 64
      //   455: invokespecial 463	java/util/ArrayList:<init>	(I)V
      //   458: astore 7
      //   460: aload 8
      //   462: new 11	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a$a
      //   465: dup
      //   466: aload_0
      //   467: aload 9
      //   469: fconst_1
      //   470: invokespecial 466	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a$a:<init>	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a;Ljava/io/File;F)V
      //   473: invokeinterface 469 2 0
      //   478: pop
      //   479: aload_0
      //   480: fconst_0
      //   481: putfield 57	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:mProgress	F
      //   484: aload_0
      //   485: getfield 37	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:NHl	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   488: invokestatic 349	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:f	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;)Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b;
      //   491: aload_0
      //   492: getfield 57	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:mProgress	F
      //   495: f2i
      //   496: invokevirtual 472	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b:ajF	(I)V
      //   499: aload 8
      //   501: invokeinterface 473 1 0
      //   506: ifne +779 -> 1285
      //   509: aload_0
      //   510: getfield 59	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:NHn	Landroid/os/CancellationSignal;
      //   513: invokevirtual 312	android/os/CancellationSignal:throwIfCanceled	()V
      //   516: aload 8
      //   518: iconst_0
      //   519: invokeinterface 477 2 0
      //   524: checkcast 11	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a$a
      //   527: astore 10
      //   529: aload 10
      //   531: getfield 481	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a$a:NHu	Ljava/io/File;
      //   534: astore 9
      //   536: new 127	java/io/File
      //   539: dup
      //   540: aload_0
      //   541: aload 9
      //   543: invokespecial 483	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:S	(Ljava/io/File;)Ljava/lang/String;
      //   546: invokespecial 266	java/io/File:<init>	(Ljava/lang/String;)V
      //   549: astore 11
      //   551: aload_0
      //   552: getfield 74	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:NHp	Ljava/util/Set;
      //   555: aload 9
      //   557: invokevirtual 131	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   560: invokestatic 331	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:bhO	(Ljava/lang/String;)Ljava/lang/String;
      //   563: invokeinterface 486 2 0
      //   568: ifeq +64 -> 632
      //   571: invokestatic 95	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:gwK	()Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$a;
      //   574: ldc 97
      //   576: ldc_w 488
      //   579: iconst_1
      //   580: anewarray 4	java/lang/Object
      //   583: dup
      //   584: iconst_0
      //   585: aload 9
      //   587: invokevirtual 131	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   590: aastore
      //   591: invokeinterface 105 4 0
      //   596: goto -97 -> 499
      //   599: astore 7
      //   601: aload_0
      //   602: iconst_0
      //   603: invokespecial 345	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:AE	(Z)V
      //   606: invokestatic 446	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:gwN	()V
      //   609: aload_0
      //   610: getfield 37	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:NHl	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   613: invokestatic 448	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:i	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;)V
      //   616: aload_0
      //   617: getfield 37	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:NHl	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   620: invokestatic 451	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:j	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;)V
      //   623: ldc_w 340
      //   626: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   629: aload 7
      //   631: athrow
      //   632: invokestatic 95	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:gwK	()Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$a;
      //   635: ldc 97
      //   637: ldc_w 490
      //   640: iconst_2
      //   641: anewarray 4	java/lang/Object
      //   644: dup
      //   645: iconst_0
      //   646: aload 9
      //   648: invokevirtual 131	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   651: aastore
      //   652: dup
      //   653: iconst_1
      //   654: aload 11
      //   656: invokevirtual 131	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   659: aastore
      //   660: invokeinterface 116 4 0
      //   665: aload_0
      //   666: getfield 66	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:NGN	Z
      //   669: ifne +118 -> 787
      //   672: aload_0
      //   673: getfield 72	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:NHo	Ljava/util/Set;
      //   676: aload 9
      //   678: invokevirtual 131	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   681: invokestatic 331	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:bhO	(Ljava/lang/String;)Ljava/lang/String;
      //   684: invokeinterface 486 2 0
      //   689: istore 5
      //   691: iload 5
      //   693: ifne +94 -> 787
      //   696: aload 9
      //   698: aload 11
      //   700: invokevirtual 494	java/io/File:renameTo	(Ljava/io/File;)Z
      //   703: ifeq +84 -> 787
      //   706: invokestatic 95	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:gwK	()Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$a;
      //   709: ldc 97
      //   711: ldc_w 496
      //   714: iconst_2
      //   715: anewarray 4	java/lang/Object
      //   718: dup
      //   719: iconst_0
      //   720: aload 9
      //   722: invokevirtual 131	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   725: aastore
      //   726: dup
      //   727: iconst_1
      //   728: aload 11
      //   730: invokevirtual 131	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   733: aastore
      //   734: invokeinterface 328 4 0
      //   739: aload_0
      //   740: aload_0
      //   741: getfield 57	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:mProgress	F
      //   744: aload 10
      //   746: getfield 499	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a$a:NHv	F
      //   749: fadd
      //   750: putfield 57	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:mProgress	F
      //   753: aload_0
      //   754: getfield 57	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:mProgress	F
      //   757: ldc_w 500
      //   760: fmul
      //   761: ldc_w 501
      //   764: fmul
      //   765: f2d
      //   766: invokestatic 507	java/lang/Math:floor	(D)D
      //   769: d2i
      //   770: istore_2
      //   771: aload_0
      //   772: getfield 37	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:NHl	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   775: invokestatic 349	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:f	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;)Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b;
      //   778: iload_2
      //   779: invokevirtual 472	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b:ajF	(I)V
      //   782: goto -283 -> 499
      //   785: astore 12
      //   787: aload_0
      //   788: getfield 59	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:NHn	Landroid/os/CancellationSignal;
      //   791: invokevirtual 312	android/os/CancellationSignal:throwIfCanceled	()V
      //   794: aload 7
      //   796: aload 9
      //   798: invokeinterface 469 2 0
      //   803: pop
      //   804: aload 9
      //   806: invokevirtual 511	java/io/File:listFiles	()[Ljava/io/File;
      //   809: astore 9
      //   811: aload 9
      //   813: ifnull +383 -> 1196
      //   816: aload 9
      //   818: arraylength
      //   819: ifeq +377 -> 1196
      //   822: aload 10
      //   824: getfield 499	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a$a:NHv	F
      //   827: aload 9
      //   829: arraylength
      //   830: i2f
      //   831: fdiv
      //   832: fstore_1
      //   833: aload 9
      //   835: arraylength
      //   836: istore_3
      //   837: iconst_0
      //   838: istore_2
      //   839: iload_2
      //   840: iload_3
      //   841: if_icmpge -342 -> 499
      //   844: aload 9
      //   846: iload_2
      //   847: aaload
      //   848: astore 10
      //   850: aload_0
      //   851: getfield 59	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:NHn	Landroid/os/CancellationSignal;
      //   854: invokevirtual 312	android/os/CancellationSignal:throwIfCanceled	()V
      //   857: aload 10
      //   859: invokevirtual 514	java/io/File:isDirectory	()Z
      //   862: ifeq +25 -> 887
      //   865: aload 8
      //   867: new 11	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a$a
      //   870: dup
      //   871: aload_0
      //   872: aload 10
      //   874: fload_1
      //   875: invokespecial 466	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a$a:<init>	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a;Ljava/io/File;F)V
      //   878: invokeinterface 469 2 0
      //   883: pop
      //   884: goto +724 -> 1608
      //   887: aload_0
      //   888: getfield 74	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:NHp	Ljava/util/Set;
      //   891: aload 10
      //   893: invokevirtual 131	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   896: invokeinterface 486 2 0
      //   901: ifeq +72 -> 973
      //   904: invokestatic 95	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:gwK	()Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$a;
      //   907: ldc 97
      //   909: ldc_w 488
      //   912: iconst_1
      //   913: anewarray 4	java/lang/Object
      //   916: dup
      //   917: iconst_0
      //   918: aload 10
      //   920: invokevirtual 131	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   923: aastore
      //   924: invokeinterface 105 4 0
      //   929: aload_0
      //   930: aload_0
      //   931: getfield 57	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:mProgress	F
      //   934: fload_1
      //   935: fadd
      //   936: putfield 57	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:mProgress	F
      //   939: aload_0
      //   940: getfield 57	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:mProgress	F
      //   943: ldc_w 500
      //   946: fmul
      //   947: ldc_w 501
      //   950: fmul
      //   951: f2d
      //   952: invokestatic 507	java/lang/Math:floor	(D)D
      //   955: d2i
      //   956: istore 4
      //   958: aload_0
      //   959: getfield 37	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:NHl	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   962: invokestatic 349	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:f	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;)Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b;
      //   965: iload 4
      //   967: invokevirtual 472	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b:ajF	(I)V
      //   970: goto +638 -> 1608
      //   973: new 127	java/io/File
      //   976: dup
      //   977: aload_0
      //   978: aload 10
      //   980: invokespecial 483	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:S	(Ljava/io/File;)Ljava/lang/String;
      //   983: invokespecial 266	java/io/File:<init>	(Ljava/lang/String;)V
      //   986: astore 11
      //   988: aload 10
      //   990: invokevirtual 131	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   993: aload 11
      //   995: invokevirtual 131	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   998: invokevirtual 334	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   1001: ifeq +31 -> 1032
      //   1004: invokestatic 95	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:gwK	()Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$a;
      //   1007: ldc 97
      //   1009: ldc_w 516
      //   1012: iconst_1
      //   1013: anewarray 4	java/lang/Object
      //   1016: dup
      //   1017: iconst_0
      //   1018: aload 10
      //   1020: invokevirtual 131	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   1023: aastore
      //   1024: invokeinterface 105 4 0
      //   1029: goto -100 -> 929
      //   1032: aload 10
      //   1034: invokevirtual 278	java/io/File:exists	()Z
      //   1037: ifeq +47 -> 1084
      //   1040: aload 11
      //   1042: invokevirtual 278	java/io/File:exists	()Z
      //   1045: ifeq +39 -> 1084
      //   1048: invokestatic 95	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:gwK	()Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$a;
      //   1051: ldc 97
      //   1053: ldc_w 518
      //   1056: iconst_2
      //   1057: anewarray 4	java/lang/Object
      //   1060: dup
      //   1061: iconst_0
      //   1062: aload 10
      //   1064: invokevirtual 131	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   1067: aastore
      //   1068: dup
      //   1069: iconst_1
      //   1070: aload 11
      //   1072: invokevirtual 131	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   1075: aastore
      //   1076: invokeinterface 105 4 0
      //   1081: goto -152 -> 929
      //   1084: iconst_0
      //   1085: istore 5
      //   1087: aload_0
      //   1088: getfield 66	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:NGN	Z
      //   1091: istore 6
      //   1093: iload 6
      //   1095: ifne +52 -> 1147
      //   1098: aload_0
      //   1099: getfield 59	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:NHn	Landroid/os/CancellationSignal;
      //   1102: invokevirtual 312	android/os/CancellationSignal:throwIfCanceled	()V
      //   1105: aload 10
      //   1107: aload 11
      //   1109: invokevirtual 494	java/io/File:renameTo	(Ljava/io/File;)Z
      //   1112: istore 5
      //   1114: invokestatic 95	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:gwK	()Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$a;
      //   1117: ldc 97
      //   1119: ldc_w 496
      //   1122: iconst_2
      //   1123: anewarray 4	java/lang/Object
      //   1126: dup
      //   1127: iconst_0
      //   1128: aload 10
      //   1130: invokevirtual 131	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   1133: aastore
      //   1134: dup
      //   1135: iconst_1
      //   1136: aload 11
      //   1138: invokevirtual 131	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   1141: aastore
      //   1142: invokeinterface 328 4 0
      //   1147: iload 5
      //   1149: ifne -220 -> 929
      //   1152: aload_0
      //   1153: aload 10
      //   1155: aload 11
      //   1157: invokespecial 520	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:e	(Ljava/io/File;Ljava/io/File;)V
      //   1160: aload 10
      //   1162: invokevirtual 523	java/io/File:delete	()Z
      //   1165: ifne -236 -> 929
      //   1168: invokestatic 95	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:gwK	()Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$a;
      //   1171: ldc 97
      //   1173: ldc_w 525
      //   1176: iconst_1
      //   1177: anewarray 4	java/lang/Object
      //   1180: dup
      //   1181: iconst_0
      //   1182: aload 10
      //   1184: invokevirtual 131	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   1187: aastore
      //   1188: invokeinterface 105 4 0
      //   1193: goto -264 -> 929
      //   1196: aload 11
      //   1198: invokevirtual 278	java/io/File:exists	()Z
      //   1201: ifne +36 -> 1237
      //   1204: aload 11
      //   1206: invokevirtual 285	java/io/File:mkdirs	()Z
      //   1209: ifne +28 -> 1237
      //   1212: invokestatic 95	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:gwK	()Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$a;
      //   1215: ldc 97
      //   1217: ldc_w 527
      //   1220: iconst_1
      //   1221: anewarray 4	java/lang/Object
      //   1224: dup
      //   1225: iconst_0
      //   1226: aload 11
      //   1228: invokevirtual 131	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   1231: aastore
      //   1232: invokeinterface 529 4 0
      //   1237: aload_0
      //   1238: getfield 57	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:mProgress	F
      //   1241: fstore_1
      //   1242: aload_0
      //   1243: aload 10
      //   1245: getfield 499	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a$a:NHv	F
      //   1248: fload_1
      //   1249: fadd
      //   1250: putfield 57	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:mProgress	F
      //   1253: aload_0
      //   1254: getfield 57	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:mProgress	F
      //   1257: ldc_w 500
      //   1260: fmul
      //   1261: ldc_w 501
      //   1264: fmul
      //   1265: f2d
      //   1266: invokestatic 507	java/lang/Math:floor	(D)D
      //   1269: d2i
      //   1270: istore_2
      //   1271: aload_0
      //   1272: getfield 37	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:NHl	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   1275: invokestatic 349	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:f	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;)Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b;
      //   1278: iload_2
      //   1279: invokevirtual 472	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b:ajF	(I)V
      //   1282: goto -783 -> 499
      //   1285: aload 7
      //   1287: invokeinterface 532 1 0
      //   1292: iconst_1
      //   1293: isub
      //   1294: istore_2
      //   1295: iload_2
      //   1296: iflt +67 -> 1363
      //   1299: aload_0
      //   1300: getfield 59	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:NHn	Landroid/os/CancellationSignal;
      //   1303: invokevirtual 312	android/os/CancellationSignal:throwIfCanceled	()V
      //   1306: aload 7
      //   1308: iload_2
      //   1309: invokeinterface 534 2 0
      //   1314: checkcast 127	java/io/File
      //   1317: astore 8
      //   1319: aload 8
      //   1321: invokevirtual 278	java/io/File:exists	()Z
      //   1324: ifeq +299 -> 1623
      //   1327: aload 8
      //   1329: invokevirtual 523	java/io/File:delete	()Z
      //   1332: ifne +291 -> 1623
      //   1335: invokestatic 95	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:gwK	()Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$a;
      //   1338: ldc 97
      //   1340: ldc_w 536
      //   1343: iconst_1
      //   1344: anewarray 4	java/lang/Object
      //   1347: dup
      //   1348: iconst_0
      //   1349: aload 8
      //   1351: invokevirtual 131	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   1354: aastore
      //   1355: invokeinterface 105 4 0
      //   1360: goto +263 -> 1623
      //   1363: aload 7
      //   1365: invokeinterface 539 1 0
      //   1370: aload_0
      //   1371: getfield 57	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:mProgress	F
      //   1374: fconst_1
      //   1375: invokestatic 545	java/lang/Float:compare	(FF)I
      //   1378: ifeq +15 -> 1393
      //   1381: aload_0
      //   1382: getfield 37	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:NHl	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   1385: invokestatic 349	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:f	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;)Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b;
      //   1388: bipush 100
      //   1390: invokevirtual 472	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b:ajF	(I)V
      //   1393: aload_0
      //   1394: getfield 51	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:NHr	Ljava/lang/String;
      //   1397: invokestatic 550	com/tencent/mm/sdcard_migrate/b:bhR	(Ljava/lang/String;)V
      //   1400: aload_0
      //   1401: getfield 37	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:NHl	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   1404: invokestatic 349	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:f	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;)Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b;
      //   1407: astore 8
      //   1409: aload 8
      //   1411: iconst_1
      //   1412: invokevirtual 355	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b:AF	(Z)Landroid/support/v4/app/s$c;
      //   1415: invokestatic 556	java/lang/System:currentTimeMillis	()J
      //   1418: invokevirtual 559	android/support/v4/app/s$c:i	(J)Landroid/support/v4/app/s$c;
      //   1421: ldc_w 560
      //   1424: invokestatic 359	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:ajE	(I)Ljava/lang/String;
      //   1427: invokevirtual 365	android/support/v4/app/s$c:g	(Ljava/lang/CharSequence;)Landroid/support/v4/app/s$c;
      //   1430: iconst_0
      //   1431: iconst_0
      //   1432: iconst_0
      //   1433: invokevirtual 368	android/support/v4/app/s$c:b	(IIZ)Landroid/support/v4/app/s$c;
      //   1436: iconst_1
      //   1437: invokevirtual 563	android/support/v4/app/s$c:E	(Z)Landroid/support/v4/app/s$c;
      //   1440: astore 7
      //   1442: aload 7
      //   1444: aload 8
      //   1446: iconst_1
      //   1447: invokevirtual 382	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b:AG	(Z)Landroid/app/PendingIntent;
      //   1450: putfield 386	android/support/v4/app/s$c:Hv	Landroid/app/PendingIntent;
      //   1453: aload 7
      //   1455: iconst_2
      //   1456: iconst_0
      //   1457: invokevirtual 371	android/support/v4/app/s$c:g	(IZ)V
      //   1460: aload 8
      //   1462: getfield 387	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b:NHl	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   1465: aload 7
      //   1467: invokevirtual 399	android/support/v4/app/s$c:build	()Landroid/app/Notification;
      //   1470: invokestatic 566	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:a	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;Landroid/app/Notification;)V
      //   1473: aload 8
      //   1475: getfield 387	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b:NHl	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   1478: invokestatic 406	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:a	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;)[Lcom/tencent/mm/sdcard_migrate/MigrateResultCallback;
      //   1481: astore 7
      //   1483: aload 7
      //   1485: monitorenter
      //   1486: aload 8
      //   1488: getfield 387	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b:NHl	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   1491: invokestatic 406	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:a	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;)[Lcom/tencent/mm/sdcard_migrate/MigrateResultCallback;
      //   1494: iconst_0
      //   1495: aaload
      //   1496: astore 8
      //   1498: aload 8
      //   1500: ifnull +21 -> 1521
      //   1503: aload 8
      //   1505: invokevirtual 412	com/tencent/mm/sdcard_migrate/MigrateResultCallback:asBinder	()Landroid/os/IBinder;
      //   1508: invokeinterface 417 1 0
      //   1513: ifeq +8 -> 1521
      //   1516: aload 8
      //   1518: invokevirtual 569	com/tencent/mm/sdcard_migrate/MigrateResultCallback:gxi	()V
      //   1521: aload 7
      //   1523: monitorexit
      //   1524: aload_0
      //   1525: iconst_0
      //   1526: invokespecial 345	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:AE	(Z)V
      //   1529: invokestatic 446	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:gwN	()V
      //   1532: aload_0
      //   1533: getfield 37	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:NHl	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   1536: invokestatic 448	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:i	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;)V
      //   1539: aload_0
      //   1540: getfield 37	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:NHl	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   1543: invokestatic 451	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:j	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;)V
      //   1546: ldc_w 340
      //   1549: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1552: return
      //   1553: astore 8
      //   1555: invokestatic 95	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:gwK	()Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$a;
      //   1558: ldc_w 453
      //   1561: aload 8
      //   1563: ldc_w 455
      //   1566: iconst_0
      //   1567: anewarray 4	java/lang/Object
      //   1570: invokeinterface 434 5 0
      //   1575: goto -54 -> 1521
      //   1578: astore 8
      //   1580: aload 7
      //   1582: monitorexit
      //   1583: ldc_w 340
      //   1586: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1589: aload 8
      //   1591: athrow
      //   1592: aload_0
      //   1593: getfield 37	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:NHl	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   1596: invokestatic 349	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:f	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;)Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b;
      //   1599: bipush 6
      //   1601: aconst_null
      //   1602: invokevirtual 460	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b:c	(ILjava/lang/Throwable;)V
      //   1605: goto -1298 -> 307
      //   1608: iload_2
      //   1609: iconst_1
      //   1610: iadd
      //   1611: istore_2
      //   1612: goto -773 -> 839
      //   1615: astore 12
      //   1617: iconst_0
      //   1618: istore 5
      //   1620: goto -473 -> 1147
      //   1623: iload_2
      //   1624: iconst_1
      //   1625: isub
      //   1626: istore_2
      //   1627: goto -332 -> 1295
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	1630	0	this	a
      //   832	417	1	f	float
      //   770	857	2	i	int
      //   836	6	3	j	int
      //   956	10	4	k	int
      //   689	930	5	bool1	boolean
      //   1091	3	6	bool2	boolean
      //   31	225	7	localObject1	Object
      //   258	8	7	localOperationCanceledException	android.os.OperationCanceledException
      //   336	9	7	localThrowable1	Throwable
      //   361	12	7	localObject2	Object
      //   375	30	7	localThrowable2	Throwable
      //   458	1	7	localArrayList	java.util.ArrayList
      //   599	765	7	localObject3	Object
      //   37	1480	8	localObject5	Object
      //   1553	9	8	localThrowable3	Throwable
      //   1578	12	8	localObject6	Object
      //   25	1219	10	localObject8	Object
      //   549	678	11	localFile	File
      //   785	1	12	localThrowable4	Throwable
      //   1615	1	12	localThrowable5	Throwable
      // Exception table:
      //   from	to	target	type
      //   6	131	258	android/os/OperationCanceledException
      //   173	258	258	android/os/OperationCanceledException
      //   366	375	258	android/os/OperationCanceledException
      //   438	499	258	android/os/OperationCanceledException
      //   499	596	258	android/os/OperationCanceledException
      //   632	691	258	android/os/OperationCanceledException
      //   696	782	258	android/os/OperationCanceledException
      //   787	811	258	android/os/OperationCanceledException
      //   816	837	258	android/os/OperationCanceledException
      //   850	884	258	android/os/OperationCanceledException
      //   887	929	258	android/os/OperationCanceledException
      //   929	970	258	android/os/OperationCanceledException
      //   973	1029	258	android/os/OperationCanceledException
      //   1032	1081	258	android/os/OperationCanceledException
      //   1087	1093	258	android/os/OperationCanceledException
      //   1098	1147	258	android/os/OperationCanceledException
      //   1152	1193	258	android/os/OperationCanceledException
      //   1196	1237	258	android/os/OperationCanceledException
      //   1237	1282	258	android/os/OperationCanceledException
      //   1285	1295	258	android/os/OperationCanceledException
      //   1299	1360	258	android/os/OperationCanceledException
      //   1363	1393	258	android/os/OperationCanceledException
      //   1393	1486	258	android/os/OperationCanceledException
      //   1583	1592	258	android/os/OperationCanceledException
      //   148	170	336	java/lang/Throwable
      //   131	143	361	finally
      //   148	170	361	finally
      //   170	173	361	finally
      //   338	358	361	finally
      //   363	366	361	finally
      //   6	131	375	java/lang/Throwable
      //   173	258	375	java/lang/Throwable
      //   366	375	375	java/lang/Throwable
      //   438	499	375	java/lang/Throwable
      //   499	596	375	java/lang/Throwable
      //   632	691	375	java/lang/Throwable
      //   787	811	375	java/lang/Throwable
      //   816	837	375	java/lang/Throwable
      //   850	884	375	java/lang/Throwable
      //   887	929	375	java/lang/Throwable
      //   929	970	375	java/lang/Throwable
      //   973	1029	375	java/lang/Throwable
      //   1032	1081	375	java/lang/Throwable
      //   1087	1093	375	java/lang/Throwable
      //   1152	1193	375	java/lang/Throwable
      //   1196	1237	375	java/lang/Throwable
      //   1237	1282	375	java/lang/Throwable
      //   1285	1295	375	java/lang/Throwable
      //   1299	1360	375	java/lang/Throwable
      //   1363	1393	375	java/lang/Throwable
      //   1393	1486	375	java/lang/Throwable
      //   1583	1592	375	java/lang/Throwable
      //   6	131	599	finally
      //   173	258	599	finally
      //   260	307	599	finally
      //   366	375	599	finally
      //   377	409	599	finally
      //   438	499	599	finally
      //   499	596	599	finally
      //   632	691	599	finally
      //   696	782	599	finally
      //   787	811	599	finally
      //   816	837	599	finally
      //   850	884	599	finally
      //   887	929	599	finally
      //   929	970	599	finally
      //   973	1029	599	finally
      //   1032	1081	599	finally
      //   1087	1093	599	finally
      //   1098	1147	599	finally
      //   1152	1193	599	finally
      //   1196	1237	599	finally
      //   1237	1282	599	finally
      //   1285	1295	599	finally
      //   1299	1360	599	finally
      //   1363	1393	599	finally
      //   1393	1486	599	finally
      //   1583	1592	599	finally
      //   1592	1605	599	finally
      //   696	782	785	java/lang/Throwable
      //   1503	1521	1553	java/lang/Throwable
      //   1486	1498	1578	finally
      //   1503	1521	1578	finally
      //   1521	1524	1578	finally
      //   1555	1575	1578	finally
      //   1580	1583	1578	finally
      //   1098	1147	1615	java/lang/Throwable
    }
    
    final class a
    {
      final File NHu;
      final float NHv;
      
      a(File paramFile, float paramFloat)
      {
        this.NHu = paramFile;
        this.NHv = paramFloat;
      }
    }
  }
  
  final class b
  {
    private final s.c[] NHx;
    private final int[] NHy;
    
    private b()
    {
      AppMethodBeat.i(232393);
      this.NHx = new s.c[] { null };
      this.NHy = new int[] { -1 };
      AppMethodBeat.o(232393);
    }
    
    final s.c AF(boolean paramBoolean)
    {
      AppMethodBeat.i(232394);
      synchronized (this.NHx)
      {
        if ((this.NHx[0] != null) && (!paramBoolean))
        {
          localObject1 = this.NHx[0];
          AppMethodBeat.o(232394);
          return localObject1;
        }
        try
        {
          if (Build.VERSION.SDK_INT < 26) {
            break label156;
          }
          localObject1 = (NotificationManager)ExtStorageMigrateService.this.getSystemService("notification");
          localObject3 = ((NotificationManager)localObject1).getNotificationChannels().iterator();
          do
          {
            if (!((Iterator)localObject3).hasNext()) {
              break;
            }
          } while (!"reminder_channel_id".equals(((NotificationChannel)((Iterator)localObject3).next()).getId()));
          i = 1;
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            Object localObject3;
            continue;
            int i = 0;
          }
        }
        if (i == 0)
        {
          localObject3 = new NotificationChannel("reminder_channel_id", ExtStorageMigrateService.this.getString(2131763677), 2);
          ((NotificationChannel)localObject3).setDescription(ExtStorageMigrateService.this.getString(2131763676));
          ((NotificationManager)localObject1).createNotificationChannel((NotificationChannel)localObject3);
        }
        label156:
        Object localObject1 = new s.c(ExtStorageMigrateService.this.getApplicationContext(), "reminder_channel_id");
        ((s.c)localObject1).f(ExtStorageMigrateService.ajE(2131755908)).as(2131234305).E(false);
        this.NHx[0] = localObject1;
        AppMethodBeat.o(232394);
        return localObject1;
      }
    }
    
    final PendingIntent AG(boolean paramBoolean)
    {
      AppMethodBeat.i(232396);
      Object localObject = new Intent(ExtStorageMigrateService.this, ExtStorageMigrateAuxActivity.class);
      ((Intent)localObject).setAction("auxui_action_do_migrate_routine");
      ((Intent)localObject).putExtra("auxui_param_is_migration_end", paramBoolean);
      ((Intent)localObject).addFlags(268435456);
      localObject = PendingIntent.getActivity(ExtStorageMigrateService.this, 3841, (Intent)localObject, 268435456);
      AppMethodBeat.o(232396);
      return localObject;
    }
    
    final void ajF(int paramInt)
    {
      AppMethodBeat.i(232397);
      synchronized (this.NHy)
      {
        if ((this.NHy[0] == -1) || ((paramInt != this.NHy[0]) && (paramInt % 10 == 0)))
        {
          s.c localc = AF(false).g(ExtStorageMigrateService.ajE(2131758969));
          localc.g(2, true);
          localc = localc.b(100, paramInt, false);
          ((NotificationManager)ExtStorageMigrateService.this.getSystemService("notification")).notify(1027, localc.build());
        }
        this.NHy[0] = paramInt;
      }
      synchronized (ExtStorageMigrateService.a(ExtStorageMigrateService.this))
      {
        a.b(ExtStorageMigrateService.a(ExtStorageMigrateService.this)[0], paramInt);
        AppMethodBeat.o(232397);
        return;
        localObject2 = finally;
        AppMethodBeat.o(232397);
        throw localObject2;
      }
    }
    
    final void ajG(int paramInt)
    {
      AppMethodBeat.i(232399);
      ??? = AF(true).i(System.currentTimeMillis()).g(ExtStorageMigrateService.ajE(2131758962)).b(0, 0, false).E(true);
      ((s.c)???).Hv = AG(true);
      ((s.c)???).g(2, false);
      ExtStorageMigrateService.a(ExtStorageMigrateService.this, ((s.c)???).build());
      synchronized (ExtStorageMigrateService.a(ExtStorageMigrateService.this))
      {
        a.a(ExtStorageMigrateService.a(ExtStorageMigrateService.this)[0], paramInt);
        AppMethodBeat.o(232399);
        return;
      }
    }
    
    final void c(int paramInt, Throwable paramThrowable)
    {
      AppMethodBeat.i(232398);
      s.c localc = AF(true).i(System.currentTimeMillis());
      if (paramInt == 6) {
        ??? = ExtStorageMigrateService.ajE(2131758966);
      }
      for (;;)
      {
        ??? = localc.g((CharSequence)???).b(0, 0, false).E(true);
        ((s.c)???).Hv = AG(true);
        ((s.c)???).g(2, false);
        ExtStorageMigrateService.a(ExtStorageMigrateService.this, ((s.c)???).build());
        synchronized (ExtStorageMigrateService.a(ExtStorageMigrateService.this))
        {
          a.a(ExtStorageMigrateService.a(ExtStorageMigrateService.this)[0], paramInt, paramThrowable);
          AppMethodBeat.o(232398);
          return;
          ??? = ExtStorageMigrateService.ajE(2131758964);
        }
      }
    }
    
    final s.a gwX()
    {
      AppMethodBeat.i(232395);
      Object localObject = new Intent(ExtStorageMigrateService.this, ExtStorageMigrateService.class);
      ((Intent)localObject).setAction("service_action_cancel_migrate");
      localObject = PendingIntent.getService(ExtStorageMigrateService.this, 3843, (Intent)localObject, 268435456);
      localObject = new s.a.a(2131234307, ExtStorageMigrateService.ajE(2131756929), (PendingIntent)localObject);
      ((s.a.a)localObject).Hj = false;
      localObject = ((s.a.a)localObject).es();
      AppMethodBeat.o(232395);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sdcard_migrate.ExtStorageMigrateService
 * JD-Core Version:    0.7.0.1
 */