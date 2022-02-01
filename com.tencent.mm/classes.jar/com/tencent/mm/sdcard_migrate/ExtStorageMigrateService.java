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
import android.text.TextUtils;
import androidx.core.app.f.a;
import androidx.core.app.f.a.a;
import androidx.core.app.f.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.g;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.notification.g.b;
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
  private final b acpP;
  private final a[] acpQ;
  private Thread acpR;
  private final MigrateResultCallback[] acpS;
  private volatile int acpT;
  private final boolean[] acpU;
  private final PowerManager.WakeLock[] acpV;
  private final boolean[] acpW;
  private final e.a acpX;
  
  public ExtStorageMigrateService()
  {
    AppMethodBeat.i(169829);
    this.acpP = new b((byte)0);
    this.acpQ = new a[] { null };
    this.acpR = null;
    this.acpS = new MigrateResultCallback[] { null };
    this.acpT = 0;
    this.acpU = new boolean[] { false };
    this.acpV = new PowerManager.WakeLock[] { null };
    this.acpW = new boolean[] { false };
    this.acpX = new e.a()
    {
      public final void a(ExtStorageMigrateConfig paramAnonymousExtStorageMigrateConfig)
      {
        AppMethodBeat.i(257136);
        ExtStorageMigrateService.a(ExtStorageMigrateService.this, paramAnonymousExtStorageMigrateConfig);
        AppMethodBeat.o(257136);
      }
      
      public final void a(MigrateResultCallback paramAnonymousMigrateResultCallback)
      {
        AppMethodBeat.i(257123);
        synchronized (ExtStorageMigrateService.a(ExtStorageMigrateService.this))
        {
          if ((ExtStorageMigrateService.a(ExtStorageMigrateService.this)[0] != null) && (ExtStorageMigrateService.a(ExtStorageMigrateService.this)[0] != paramAnonymousMigrateResultCallback)) {
            ExtStorageMigrateService.a(ExtStorageMigrateService.this)[0].nQ(ExtStorageMigrateService.c(ExtStorageMigrateService.this), Binder.getCallingPid());
          }
          ExtStorageMigrateService.a(ExtStorageMigrateService.this)[0] = paramAnonymousMigrateResultCallback;
          if (!iSW()) {
            break label147;
          }
        }
        synchronized (ExtStorageMigrateService.b(ExtStorageMigrateService.this))
        {
          paramAnonymousMigrateResultCallback.pA(ExtStorageMigrateService.a.c(ExtStorageMigrateService.b(ExtStorageMigrateService.this)[0]), ExtStorageMigrateService.a.d(ExtStorageMigrateService.b(ExtStorageMigrateService.this)[0]));
          AppMethodBeat.o(257123);
          return;
          paramAnonymousMigrateResultCallback = finally;
          AppMethodBeat.o(257123);
          throw paramAnonymousMigrateResultCallback;
        }
        label147:
        AppMethodBeat.o(257123);
      }
      
      public final void b(MigrateResultCallback arg1)
      {
        AppMethodBeat.i(257129);
        synchronized (ExtStorageMigrateService.a(ExtStorageMigrateService.this))
        {
          if (ExtStorageMigrateService.a(ExtStorageMigrateService.this)[0] != null) {
            ExtStorageMigrateService.a(ExtStorageMigrateService.this)[0] = null;
          }
          AppMethodBeat.o(257129);
          return;
        }
      }
      
      public final boolean iSW()
      {
        AppMethodBeat.i(257118);
        if ((ExtStorageMigrateService.b(ExtStorageMigrateService.this)[0] != null) && (ExtStorageMigrateService.a.b(ExtStorageMigrateService.b(ExtStorageMigrateService.this)[0])))
        {
          AppMethodBeat.o(257118);
          return true;
        }
        AppMethodBeat.o(257118);
        return false;
      }
      
      public final void iTa()
      {
        AppMethodBeat.i(257143);
        ExtStorageMigrateService.d(ExtStorageMigrateService.this);
        AppMethodBeat.o(257143);
      }
    };
    AppMethodBeat.o(169829);
  }
  
  private void Kv(boolean paramBoolean)
  {
    synchronized (this.acpU)
    {
      this.acpU[0] = paramBoolean;
      return;
    }
  }
  
  private void Kw(boolean paramBoolean)
  {
    synchronized (this.acpW)
    {
      this.acpW[0] = paramBoolean;
      return;
    }
  }
  
  private static File N(File paramFile)
  {
    AppMethodBeat.i(169830);
    try
    {
      File localFile = paramFile.getCanonicalFile();
      AppMethodBeat.o(169830);
      return localFile;
    }
    finally
    {
      ExtStorageMigrateMonitor.iSO().printErrStackTrace("MicroMsg.ExtStorageMigrateService", localThrowable, "[-] Fail to get canonical file for: %s", new Object[] { paramFile.getAbsolutePath() });
      paramFile = paramFile.getAbsoluteFile();
      AppMethodBeat.o(169830);
    }
    return paramFile;
  }
  
  private static String buf(String paramString)
  {
    AppMethodBeat.i(169831);
    try
    {
      String str = new File(paramString).getCanonicalPath();
      AppMethodBeat.o(169831);
      return str;
    }
    finally
    {
      ExtStorageMigrateMonitor.iSO().printErrStackTrace("MicroMsg.ExtStorageMigrateService", localThrowable, "[-] Fail to get canonical path for: %s", new Object[] { paramString });
      paramString = new File(paramString).getAbsolutePath();
      AppMethodBeat.o(169831);
    }
    return paramString;
  }
  
  private boolean iSW()
  {
    boolean bool2 = false;
    AppMethodBeat.i(257116);
    a[] arrayOfa = this.acpQ;
    boolean bool1 = bool2;
    try
    {
      if (this.acpQ[0] != null)
      {
        bool1 = bool2;
        if (a.b(this.acpQ[0])) {
          bool1 = true;
        }
      }
      return bool1;
    }
    finally
    {
      AppMethodBeat.o(257116);
    }
  }
  
  private boolean iSX()
  {
    synchronized (this.acpU)
    {
      int i = this.acpU[0];
      return i;
    }
  }
  
  private boolean iSY()
  {
    synchronized (this.acpW)
    {
      int i = this.acpW[0];
      return i;
    }
  }
  
  private void iSZ()
  {
    AppMethodBeat.i(257146);
    ExtStorageMigrateMonitor.iSO().i("MicroMsg.ExtStorageMigrateService", "[+] expectedStopSelf called.", new Object[0]);
    Kw(true);
    stopSelf();
    AppMethodBeat.o(257146);
  }
  
  private void releaseWakeLock()
  {
    AppMethodBeat.i(257155);
    synchronized (this.acpV)
    {
      if ((this.acpV[0] != null) && (this.acpV[0].isHeld()))
      {
        PowerManager.WakeLock localWakeLock = this.acpV[0];
        com.tencent.mm.hellhoundlib.a.a.b(localWakeLock, "com/tencent/mm/sdcard_migrate/ExtStorageMigrateService", "releaseWakeLock", "()V", "android/os/PowerManager$WakeLock_EXEC_", "release", "()V");
        localWakeLock.release();
        com.tencent.mm.hellhoundlib.a.a.c(localWakeLock, "com/tencent/mm/sdcard_migrate/ExtStorageMigrateService", "releaseWakeLock", "()V", "android/os/PowerManager$WakeLock_EXEC_", "release", "()V");
        this.acpV[0] = null;
        ExtStorageMigrateMonitor.iSO().i("MicroMsg.ExtStorageMigrateService", "[+] WakeLock released.", new Object[0]);
      }
      AppMethodBeat.o(257155);
      return;
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    AppMethodBeat.i(257264);
    paramIntent = this.acpX.asBinder();
    AppMethodBeat.o(257264);
    return paramIntent;
  }
  
  public void onCreate()
  {
    AppMethodBeat.i(257255);
    super.onCreate();
    synchronized (this.acpQ)
    {
      this.acpQ[0] = null;
      this.acpR = null;
    }
    synchronized (this.acpS)
    {
      this.acpS[0] = null;
      this.acpT = 0;
      Kv(false);
      AppMethodBeat.o(257255);
      return;
      localObject2 = finally;
      AppMethodBeat.o(257255);
      throw localObject2;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(169833);
    ExtStorageMigrateMonitor.iSO().i("MicroMsg.ExtStorageMigrateService", "[+] OnDestroy called.", new Object[0]);
    synchronized (this.acpQ)
    {
      if (iSW()) {
        a.a(this.acpQ[0]);
      }
    }
    try
    {
      this.acpR.join();
      for (;;)
      {
        label53:
        this.acpQ[0] = null;
        if (iSX()) {
          stopForeground(true);
        }
        releaseWakeLock();
        AppMethodBeat.o(169833);
        return;
        if (iSX()) {
          if (iSY())
          {
            Kw(false);
            this.acpP.ayd(2);
            continue;
            localObject = finally;
            AppMethodBeat.o(169833);
            throw localObject;
          }
          else
          {
            this.acpP.d(6, null);
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
    ExtStorageMigrateMonitor.iSO().i("MicroMsg.ExtStorageMigrateService", "[+] OnStartCommand called, intent: %s", new Object[] { paramIntent });
    if (paramIntent == null)
    {
      ExtStorageMigrateMonitor.iSO().e("MicroMsg.ExtStorageMigrateService", "[-] intent is null, skip rest logic.", new Object[0]);
      iSZ();
    }
    for (;;)
    {
      AppMethodBeat.o(169832);
      return 2;
      paramIntent = paramIntent.getAction();
      if (paramIntent == null)
      {
        ExtStorageMigrateMonitor.iSO().e("MicroMsg.ExtStorageMigrateService", "[-] action is null, skip rest logic.", new Object[0]);
        iSZ();
      }
      else if ("service_action_startup".equals(paramIntent))
      {
        Object localObject = this.acpP;
        if ((((b)localObject).acpY.iSX()) || (((b)localObject).acpY.iSW()))
        {
          ExtStorageMigrateMonitor.iSO().w("MicroMsg.ExtStorageMigrateService", "[!] Already on foreground or migrating logic, skip startup steps.", new Object[0]);
        }
        else
        {
          paramIntent = ((b)localObject).Ky(true);
          f.d locald = paramIntent.bt(System.currentTimeMillis());
          paramInt1 = R.l.ext_storage_migration_dialog_startup_msg;
          locald = locald.m(MMApplicationContext.getResources().getString(paramInt1)).d(0, 0, true);
          locald.q(2, true);
          locald.a(((b)localObject).iTb()).bor = ((b)localObject).Kz(false);
          localObject = ((b)localObject).acpY;
          ((ExtStorageMigrateService)localObject).startForeground(1027, paramIntent.DA());
          ((ExtStorageMigrateService)localObject).Kv(true);
        }
      }
      else if ("service_action_cancel_migrate".equals(paramIntent))
      {
        iSZ();
      }
      else
      {
        ExtStorageMigrateMonitor.iSO().e("MicroMsg.ExtStorageMigrateService", "[-] Unknown action: %s", new Object[] { paramIntent });
      }
    }
  }
  
  final class a
    implements Runnable
  {
    private final boolean[] acpZ;
    private final boolean acpz;
    private final Set<String> acqa;
    private final Set<String> acqb;
    private final Map<String, String> acqc;
    private String acqd;
    private String acqe;
    private ByteBuffer acqf;
    private final CancellationSignal eMV;
    private float mProgress;
    
    a(ExtStorageMigrateConfig paramExtStorageMigrateConfig, CancellationSignal paramCancellationSignal)
    {
      AppMethodBeat.i(257132);
      this.acpZ = new boolean[] { false };
      this.acqd = null;
      this.acqe = null;
      this.acqf = null;
      this.mProgress = 0.0F;
      this.eMV = paramCancellationSignal;
      this.acpz = paramExtStorageMigrateConfig.acpu;
      this.acqa = new HashSet(64);
      this.acqb = new HashSet(5);
      this.acqc = new HashMap(5);
      this.acqd = ExtStorageMigrateService.access$1500(paramExtStorageMigrateConfig.acps);
      this.acqe = ExtStorageMigrateService.access$1500(paramExtStorageMigrateConfig.acpt);
      if (paramExtStorageMigrateConfig.acpu) {
        ExtStorageMigrateMonitor.iSO().w("MicroMsg.ExtStorageMigrateService", "[!] Force copy mode enabled, are we under test mode ??", new Object[0]);
      }
      b(paramExtStorageMigrateConfig.acps, paramExtStorageMigrateConfig.acpv);
      ExtStorageMigrateMonitor.iSO().i("MicroMsg.ExtStorageMigrateService", "[+] MigrateTask, pass in config: %s", new Object[] { paramExtStorageMigrateConfig });
      AppMethodBeat.o(257132);
    }
    
    private void Kx(boolean paramBoolean)
    {
      synchronized (this.acpZ)
      {
        this.acpZ[0] = paramBoolean;
        return;
      }
    }
    
    private String P(File paramFile)
    {
      AppMethodBeat.i(169821);
      paramFile = buh(paramFile.getAbsolutePath().substring(this.acqd.length()));
      if (paramFile.startsWith("/")) {
        paramFile = paramFile.substring(1);
      }
      for (;;)
      {
        ExtStorageMigrateMonitor.iSO().i("MicroMsg.ExtStorageMigrateService", "[+] getMigratedFilePath, relSrcPath: %s", new Object[] { paramFile });
        Object localObject2;
        label182:
        int i;
        for (Object localObject1 = paramFile;; localObject1 = ((String)localObject1).substring(0, i))
        {
          localObject2 = paramFile;
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject2 = (String)this.acqc.get(localObject1);
            ExtStorageMigrateMonitor.iSO().i("MicroMsg.ExtStorageMigrateService", "[+] getMigratedFilePath, currRelSrcPath: %s, newRelPath: %s", new Object[] { localObject1, localObject2 });
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
            ExtStorageMigrateMonitor.iSO().i("MicroMsg.ExtStorageMigrateService", "[+] getMigratedFilePath, result: %s", new Object[] { localObject2 });
            AppMethodBeat.o(169821);
            return localObject2;
            i = ((String)localObject1).lastIndexOf('/');
            localObject2 = paramFile;
          } while (i < 0);
        }
        paramFile = this.acqe + "/" + (String)localObject2;
        ExtStorageMigrateMonitor.iSO().i("MicroMsg.ExtStorageMigrateService", "[+] getMigratedFilePath, result: %s", new Object[] { paramFile });
        AppMethodBeat.o(169821);
        return paramFile;
      }
    }
    
    private void b(String paramString, Collection<ExtStorageMigrateConfig.ExtraPathAction> paramCollection)
    {
      AppMethodBeat.i(257147);
      if (paramCollection == null)
      {
        AppMethodBeat.o(257147);
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
          localObject = ExtStorageMigrateService.O(new File(paramString, paramCollection.acpB));
          this.acqb.add(((File)localObject).getAbsolutePath());
          pz(paramString, paramCollection.acpB);
        }
        else if ((paramCollection instanceof ExtStorageMigrateConfig.ExtraPathAction.Remap))
        {
          localObject = (ExtStorageMigrateConfig.ExtraPathAction.Remap)paramCollection;
          Map localMap = this.acqc;
          String str = buh(((ExtStorageMigrateConfig.ExtraPathAction.Remap)localObject).acpC);
          if (((ExtStorageMigrateConfig.ExtraPathAction.Remap)localObject).paz.startsWith("/")) {}
          for (paramCollection = ((ExtStorageMigrateConfig.ExtraPathAction.Remap)localObject).paz;; paramCollection = buh(((ExtStorageMigrateConfig.ExtraPathAction.Remap)localObject).paz))
          {
            localMap.put(str, paramCollection);
            pz(paramString, ((ExtStorageMigrateConfig.ExtraPathAction.Remap)localObject).acpC);
            break;
          }
        }
      }
      this.acqa.add(paramString);
      ExtStorageMigrateMonitor.iSO().i("MicroMsg.ExtStorageMigrateService", "[+] MigrateTask, mSrcDirPath: %s, mDestDirPath: %s, mRemappedRelPaths: %s", new Object[] { this.acqd, this.acqe, this.acqc });
      AppMethodBeat.o(257147);
    }
    
    private static String bug(String paramString)
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
    
    private static String buh(String paramString)
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
    private void d(File paramFile1, File paramFile2)
    {
      // Byte code:
      //   0: ldc_w 274
      //   3: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   6: aload_2
      //   7: invokevirtual 277	java/io/File:exists	()Z
      //   10: ifne +11 -> 21
      //   13: aload_2
      //   14: invokevirtual 281	java/io/File:getParentFile	()Ljava/io/File;
      //   17: invokevirtual 284	java/io/File:mkdirs	()Z
      //   20: pop
      //   21: new 286	java/io/BufferedInputStream
      //   24: dup
      //   25: new 288	java/io/FileInputStream
      //   28: dup
      //   29: aload_1
      //   30: invokespecial 291	java/io/FileInputStream:<init>	(Ljava/io/File;)V
      //   33: invokespecial 294	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
      //   36: astore 4
      //   38: new 296	java/io/BufferedOutputStream
      //   41: dup
      //   42: new 298	java/io/FileOutputStream
      //   45: dup
      //   46: aload_2
      //   47: invokespecial 299	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
      //   50: invokespecial 302	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
      //   53: astore 5
      //   55: sipush 4096
      //   58: newarray byte
      //   60: astore 6
      //   62: aload 4
      //   64: aload 6
      //   66: invokevirtual 308	java/io/InputStream:read	([B)I
      //   69: istore_3
      //   70: iload_3
      //   71: ifle +43 -> 114
      //   74: aload_0
      //   75: getfield 59	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:eMV	Landroid/os/CancellationSignal;
      //   78: invokevirtual 311	android/os/CancellationSignal:throwIfCanceled	()V
      //   81: aload 5
      //   83: aload 6
      //   85: iconst_0
      //   86: iload_3
      //   87: invokevirtual 317	java/io/OutputStream:write	([BII)V
      //   90: goto -28 -> 62
      //   93: astore_1
      //   94: aload 5
      //   96: astore_2
      //   97: aload_2
      //   98: invokestatic 323	com/tencent/mm/vfs/ah:closeQuietly	(Ljava/io/Closeable;)V
      //   101: aload 4
      //   103: invokestatic 323	com/tencent/mm/vfs/ah:closeQuietly	(Ljava/io/Closeable;)V
      //   106: ldc_w 274
      //   109: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   112: aload_1
      //   113: athrow
      //   114: invokestatic 95	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:iSO	()Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$a;
      //   117: ldc 97
      //   119: ldc_w 325
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
      //   140: invokeinterface 327 4 0
      //   145: aload 5
      //   147: invokestatic 323	com/tencent/mm/vfs/ah:closeQuietly	(Ljava/io/Closeable;)V
      //   150: aload 4
      //   152: invokestatic 323	com/tencent/mm/vfs/ah:closeQuietly	(Ljava/io/Closeable;)V
      //   155: ldc_w 274
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
      synchronized (this.acpZ)
      {
        int i = this.acpZ[0];
        return i;
      }
    }
    
    private void pz(String paramString1, String paramString2)
    {
      AppMethodBeat.i(169816);
      String str = bug(paramString1);
      paramString1 = new File(str, paramString2);
      do
      {
        this.acqa.add(bug(paramString1.getAbsolutePath()));
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
      //   0: ldc_w 337
      //   3: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   6: aload_0
      //   7: getfield 37	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:acpY	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   10: invokestatic 341	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:e	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;)V
      //   13: aload_0
      //   14: iconst_1
      //   15: invokespecial 343	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:Kx	(Z)V
      //   18: aload_0
      //   19: getfield 37	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:acpY	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   22: invokestatic 347	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:f	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;)Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b;
      //   25: astore 10
      //   27: aload_0
      //   28: getfield 51	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:acqd	Ljava/lang/String;
      //   31: astore 7
      //   33: aload_0
      //   34: getfield 53	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:acqe	Ljava/lang/String;
      //   37: astore 8
      //   39: aload 10
      //   41: iconst_1
      //   42: invokevirtual 353	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b:Ky	(Z)Landroidx/core/app/f$d;
      //   45: getstatic 359	com/tencent/mm/R$l:ext_storage_migration_dialog_migrating_msg	I
      //   48: invokestatic 362	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:ayb	(I)Ljava/lang/String;
      //   51: invokevirtual 368	androidx/core/app/f$d:m	(Ljava/lang/CharSequence;)Landroidx/core/app/f$d;
      //   54: bipush 100
      //   56: iconst_0
      //   57: iconst_0
      //   58: invokevirtual 371	androidx/core/app/f$d:d	(IIZ)Landroidx/core/app/f$d;
      //   61: astore 9
      //   63: aload 9
      //   65: iconst_2
      //   66: iconst_1
      //   67: invokevirtual 375	androidx/core/app/f$d:q	(IZ)V
      //   70: aload 9
      //   72: aload 10
      //   74: invokevirtual 379	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b:iTb	()Landroidx/core/app/f$a;
      //   77: invokevirtual 382	androidx/core/app/f$d:a	(Landroidx/core/app/f$a;)Landroidx/core/app/f$d;
      //   80: astore 9
      //   82: aload 9
      //   84: aload 10
      //   86: iconst_0
      //   87: invokevirtual 386	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b:Kz	(Z)Landroid/app/PendingIntent;
      //   90: putfield 390	androidx/core/app/f$d:bor	Landroid/app/PendingIntent;
      //   93: aload 10
      //   95: getfield 391	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b:acpY	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   98: ldc_w 393
      //   101: invokevirtual 397	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
      //   104: checkcast 399	android/app/NotificationManager
      //   107: sipush 1027
      //   110: aload 9
      //   112: invokevirtual 403	androidx/core/app/f$d:DA	()Landroid/app/Notification;
      //   115: invokevirtual 407	android/app/NotificationManager:notify	(ILandroid/app/Notification;)V
      //   118: aload 10
      //   120: getfield 391	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b:acpY	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   123: invokestatic 410	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:a	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;)[Lcom/tencent/mm/sdcard_migrate/MigrateResultCallback;
      //   126: astore 9
      //   128: aload 9
      //   130: monitorenter
      //   131: aload 10
      //   133: getfield 391	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b:acpY	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   136: invokestatic 410	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:a	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;)[Lcom/tencent/mm/sdcard_migrate/MigrateResultCallback;
      //   139: iconst_0
      //   140: aaload
      //   141: astore 10
      //   143: aload 10
      //   145: ifnull +25 -> 170
      //   148: aload 10
      //   150: invokevirtual 416	com/tencent/mm/sdcard_migrate/MigrateResultCallback:asBinder	()Landroid/os/IBinder;
      //   153: invokeinterface 421 1 0
      //   158: ifeq +12 -> 170
      //   161: aload 10
      //   163: aload 7
      //   165: aload 8
      //   167: invokevirtual 424	com/tencent/mm/sdcard_migrate/MigrateResultCallback:pA	(Ljava/lang/String;Ljava/lang/String;)V
      //   170: aload 9
      //   172: monitorexit
      //   173: aload_0
      //   174: getfield 51	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:acqd	Ljava/lang/String;
      //   177: aload_0
      //   178: getfield 53	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:acqe	Ljava/lang/String;
      //   181: invokevirtual 333	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   184: ifne +1176 -> 1360
      //   187: new 127	java/io/File
      //   190: dup
      //   191: aload_0
      //   192: getfield 51	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:acqd	Ljava/lang/String;
      //   195: invokespecial 266	java/io/File:<init>	(Ljava/lang/String;)V
      //   198: astore 9
      //   200: aload 9
      //   202: invokevirtual 277	java/io/File:exists	()Z
      //   205: ifeq +1155 -> 1360
      //   208: aload 9
      //   210: invokevirtual 427	java/io/File:canRead	()Z
      //   213: ifne +225 -> 438
      //   216: new 429	java/io/IOException
      //   219: dup
      //   220: new 168	java/lang/StringBuilder
      //   223: dup
      //   224: invokespecial 169	java/lang/StringBuilder:<init>	()V
      //   227: aload 9
      //   229: invokevirtual 131	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   232: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   235: ldc_w 431
      //   238: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   241: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   244: invokespecial 432	java/io/IOException:<init>	(Ljava/lang/String;)V
      //   247: astore 7
      //   249: ldc_w 337
      //   252: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   255: aload 7
      //   257: athrow
      //   258: astore 7
      //   260: invokestatic 95	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:iSO	()Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$a;
      //   263: ldc 97
      //   265: aload 7
      //   267: ldc_w 434
      //   270: iconst_0
      //   271: anewarray 4	java/lang/Object
      //   274: invokeinterface 438 5 0
      //   279: aload_0
      //   280: getfield 37	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:acpY	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   283: invokestatic 442	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:g	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;)Z
      //   286: ifeq +1273 -> 1559
      //   289: aload_0
      //   290: getfield 37	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:acpY	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   293: invokestatic 445	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:h	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;)V
      //   296: aload_0
      //   297: getfield 37	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:acpY	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   300: invokestatic 347	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:f	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;)Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b;
      //   303: iconst_3
      //   304: invokevirtual 448	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b:ayd	(I)V
      //   307: aload_0
      //   308: iconst_0
      //   309: invokespecial 343	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:Kx	(Z)V
      //   312: invokestatic 451	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:iSR	()V
      //   315: aload_0
      //   316: getfield 37	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:acpY	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   319: invokestatic 453	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:i	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;)V
      //   322: aload_0
      //   323: getfield 37	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:acpY	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   326: invokestatic 456	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:j	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;)V
      //   329: ldc_w 337
      //   332: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   335: return
      //   336: astore 7
      //   338: invokestatic 95	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:iSO	()Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$a;
      //   341: ldc_w 458
      //   344: aload 7
      //   346: ldc_w 460
      //   349: iconst_0
      //   350: anewarray 4	java/lang/Object
      //   353: invokeinterface 438 5 0
      //   358: goto -188 -> 170
      //   361: astore 7
      //   363: aload 9
      //   365: monitorexit
      //   366: ldc_w 337
      //   369: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   372: aload 7
      //   374: athrow
      //   375: astore 7
      //   377: invokestatic 95	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:iSO	()Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$a;
      //   380: ldc 97
      //   382: aload 7
      //   384: ldc_w 462
      //   387: iconst_0
      //   388: anewarray 4	java/lang/Object
      //   391: invokeinterface 438 5 0
      //   396: aload_0
      //   397: getfield 37	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:acpY	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   400: invokestatic 347	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:f	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;)Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b;
      //   403: iconst_5
      //   404: aload 7
      //   406: invokevirtual 465	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b:d	(ILjava/lang/Throwable;)V
      //   409: aload_0
      //   410: iconst_0
      //   411: invokespecial 343	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:Kx	(Z)V
      //   414: invokestatic 451	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:iSR	()V
      //   417: aload_0
      //   418: getfield 37	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:acpY	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   421: invokestatic 453	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:i	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;)V
      //   424: aload_0
      //   425: getfield 37	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:acpY	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   428: invokestatic 456	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:j	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;)V
      //   431: ldc_w 337
      //   434: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   437: return
      //   438: new 467	java/util/ArrayList
      //   441: dup
      //   442: bipush 20
      //   444: invokespecial 468	java/util/ArrayList:<init>	(I)V
      //   447: astore 8
      //   449: new 467	java/util/ArrayList
      //   452: dup
      //   453: bipush 64
      //   455: invokespecial 468	java/util/ArrayList:<init>	(I)V
      //   458: astore 7
      //   460: aload 8
      //   462: new 11	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a$a
      //   465: dup
      //   466: aload_0
      //   467: aload 9
      //   469: fconst_1
      //   470: invokespecial 471	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a$a:<init>	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a;Ljava/io/File;F)V
      //   473: invokeinterface 474 2 0
      //   478: pop
      //   479: aload_0
      //   480: fconst_0
      //   481: putfield 57	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:mProgress	F
      //   484: aload_0
      //   485: getfield 37	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:acpY	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   488: invokestatic 347	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:f	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;)Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b;
      //   491: aload_0
      //   492: getfield 57	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:mProgress	F
      //   495: f2i
      //   496: invokevirtual 477	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b:ayc	(I)V
      //   499: aload 8
      //   501: invokeinterface 478 1 0
      //   506: ifne +746 -> 1252
      //   509: aload_0
      //   510: getfield 59	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:eMV	Landroid/os/CancellationSignal;
      //   513: invokevirtual 311	android/os/CancellationSignal:throwIfCanceled	()V
      //   516: aload 8
      //   518: iconst_0
      //   519: invokeinterface 482 2 0
      //   524: checkcast 11	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a$a
      //   527: astore 10
      //   529: aload 10
      //   531: getfield 486	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a$a:acqg	Ljava/io/File;
      //   534: astore 9
      //   536: new 127	java/io/File
      //   539: dup
      //   540: aload_0
      //   541: aload 9
      //   543: invokespecial 488	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:P	(Ljava/io/File;)Ljava/lang/String;
      //   546: invokespecial 266	java/io/File:<init>	(Ljava/lang/String;)V
      //   549: astore 11
      //   551: aload_0
      //   552: getfield 74	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:acqb	Ljava/util/Set;
      //   555: aload 9
      //   557: invokevirtual 131	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   560: invokestatic 330	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:bug	(Ljava/lang/String;)Ljava/lang/String;
      //   563: invokeinterface 491 2 0
      //   568: ifeq +31 -> 599
      //   571: invokestatic 95	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:iSO	()Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$a;
      //   574: ldc 97
      //   576: ldc_w 493
      //   579: iconst_1
      //   580: anewarray 4	java/lang/Object
      //   583: dup
      //   584: iconst_0
      //   585: aload 9
      //   587: invokevirtual 131	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   590: aastore
      //   591: invokeinterface 105 4 0
      //   596: goto -97 -> 499
      //   599: invokestatic 95	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:iSO	()Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$a;
      //   602: ldc 97
      //   604: ldc_w 495
      //   607: iconst_2
      //   608: anewarray 4	java/lang/Object
      //   611: dup
      //   612: iconst_0
      //   613: aload 9
      //   615: invokevirtual 131	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   618: aastore
      //   619: dup
      //   620: iconst_1
      //   621: aload 11
      //   623: invokevirtual 131	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   626: aastore
      //   627: invokeinterface 116 4 0
      //   632: aload_0
      //   633: getfield 66	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:acpz	Z
      //   636: ifne +118 -> 754
      //   639: aload_0
      //   640: getfield 72	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:acqa	Ljava/util/Set;
      //   643: aload 9
      //   645: invokevirtual 131	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   648: invokestatic 330	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:bug	(Ljava/lang/String;)Ljava/lang/String;
      //   651: invokeinterface 491 2 0
      //   656: istore 5
      //   658: iload 5
      //   660: ifne +94 -> 754
      //   663: aload 9
      //   665: aload 11
      //   667: invokevirtual 499	java/io/File:renameTo	(Ljava/io/File;)Z
      //   670: ifeq +84 -> 754
      //   673: invokestatic 95	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:iSO	()Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$a;
      //   676: ldc 97
      //   678: ldc_w 501
      //   681: iconst_2
      //   682: anewarray 4	java/lang/Object
      //   685: dup
      //   686: iconst_0
      //   687: aload 9
      //   689: invokevirtual 131	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   692: aastore
      //   693: dup
      //   694: iconst_1
      //   695: aload 11
      //   697: invokevirtual 131	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   700: aastore
      //   701: invokeinterface 327 4 0
      //   706: aload_0
      //   707: aload_0
      //   708: getfield 57	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:mProgress	F
      //   711: aload 10
      //   713: getfield 504	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a$a:acqh	F
      //   716: fadd
      //   717: putfield 57	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:mProgress	F
      //   720: aload_0
      //   721: getfield 57	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:mProgress	F
      //   724: ldc_w 505
      //   727: fmul
      //   728: ldc_w 506
      //   731: fmul
      //   732: f2d
      //   733: invokestatic 512	java/lang/Math:floor	(D)D
      //   736: d2i
      //   737: istore_2
      //   738: aload_0
      //   739: getfield 37	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:acpY	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   742: invokestatic 347	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:f	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;)Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b;
      //   745: iload_2
      //   746: invokevirtual 477	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b:ayc	(I)V
      //   749: goto -250 -> 499
      //   752: astore 12
      //   754: aload_0
      //   755: getfield 59	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:eMV	Landroid/os/CancellationSignal;
      //   758: invokevirtual 311	android/os/CancellationSignal:throwIfCanceled	()V
      //   761: aload 7
      //   763: aload 9
      //   765: invokeinterface 474 2 0
      //   770: pop
      //   771: aload 9
      //   773: invokevirtual 516	java/io/File:listFiles	()[Ljava/io/File;
      //   776: astore 9
      //   778: aload 9
      //   780: ifnull +383 -> 1163
      //   783: aload 9
      //   785: arraylength
      //   786: ifeq +377 -> 1163
      //   789: aload 10
      //   791: getfield 504	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a$a:acqh	F
      //   794: aload 9
      //   796: arraylength
      //   797: i2f
      //   798: fdiv
      //   799: fstore_1
      //   800: aload 9
      //   802: arraylength
      //   803: istore_3
      //   804: iconst_0
      //   805: istore_2
      //   806: iload_2
      //   807: iload_3
      //   808: if_icmpge -309 -> 499
      //   811: aload 9
      //   813: iload_2
      //   814: aaload
      //   815: astore 10
      //   817: aload_0
      //   818: getfield 59	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:eMV	Landroid/os/CancellationSignal;
      //   821: invokevirtual 311	android/os/CancellationSignal:throwIfCanceled	()V
      //   824: aload 10
      //   826: invokevirtual 519	java/io/File:isDirectory	()Z
      //   829: ifeq +25 -> 854
      //   832: aload 8
      //   834: new 11	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a$a
      //   837: dup
      //   838: aload_0
      //   839: aload 10
      //   841: fload_1
      //   842: invokespecial 471	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a$a:<init>	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a;Ljava/io/File;F)V
      //   845: invokeinterface 474 2 0
      //   850: pop
      //   851: goto +757 -> 1608
      //   854: aload_0
      //   855: getfield 74	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:acqb	Ljava/util/Set;
      //   858: aload 10
      //   860: invokevirtual 131	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   863: invokeinterface 491 2 0
      //   868: ifeq +72 -> 940
      //   871: invokestatic 95	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:iSO	()Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$a;
      //   874: ldc 97
      //   876: ldc_w 493
      //   879: iconst_1
      //   880: anewarray 4	java/lang/Object
      //   883: dup
      //   884: iconst_0
      //   885: aload 10
      //   887: invokevirtual 131	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   890: aastore
      //   891: invokeinterface 105 4 0
      //   896: aload_0
      //   897: aload_0
      //   898: getfield 57	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:mProgress	F
      //   901: fload_1
      //   902: fadd
      //   903: putfield 57	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:mProgress	F
      //   906: aload_0
      //   907: getfield 57	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:mProgress	F
      //   910: ldc_w 505
      //   913: fmul
      //   914: ldc_w 506
      //   917: fmul
      //   918: f2d
      //   919: invokestatic 512	java/lang/Math:floor	(D)D
      //   922: d2i
      //   923: istore 4
      //   925: aload_0
      //   926: getfield 37	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:acpY	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   929: invokestatic 347	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:f	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;)Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b;
      //   932: iload 4
      //   934: invokevirtual 477	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b:ayc	(I)V
      //   937: goto +671 -> 1608
      //   940: new 127	java/io/File
      //   943: dup
      //   944: aload_0
      //   945: aload 10
      //   947: invokespecial 488	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:P	(Ljava/io/File;)Ljava/lang/String;
      //   950: invokespecial 266	java/io/File:<init>	(Ljava/lang/String;)V
      //   953: astore 11
      //   955: aload 10
      //   957: invokevirtual 131	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   960: aload 11
      //   962: invokevirtual 131	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   965: invokevirtual 333	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   968: ifeq +31 -> 999
      //   971: invokestatic 95	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:iSO	()Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$a;
      //   974: ldc 97
      //   976: ldc_w 521
      //   979: iconst_1
      //   980: anewarray 4	java/lang/Object
      //   983: dup
      //   984: iconst_0
      //   985: aload 10
      //   987: invokevirtual 131	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   990: aastore
      //   991: invokeinterface 105 4 0
      //   996: goto -100 -> 896
      //   999: aload 10
      //   1001: invokevirtual 277	java/io/File:exists	()Z
      //   1004: ifeq +47 -> 1051
      //   1007: aload 11
      //   1009: invokevirtual 277	java/io/File:exists	()Z
      //   1012: ifeq +39 -> 1051
      //   1015: invokestatic 95	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:iSO	()Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$a;
      //   1018: ldc 97
      //   1020: ldc_w 523
      //   1023: iconst_2
      //   1024: anewarray 4	java/lang/Object
      //   1027: dup
      //   1028: iconst_0
      //   1029: aload 10
      //   1031: invokevirtual 131	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   1034: aastore
      //   1035: dup
      //   1036: iconst_1
      //   1037: aload 11
      //   1039: invokevirtual 131	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   1042: aastore
      //   1043: invokeinterface 105 4 0
      //   1048: goto -152 -> 896
      //   1051: iconst_0
      //   1052: istore 5
      //   1054: aload_0
      //   1055: getfield 66	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:acpz	Z
      //   1058: istore 6
      //   1060: iload 6
      //   1062: ifne +52 -> 1114
      //   1065: aload_0
      //   1066: getfield 59	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:eMV	Landroid/os/CancellationSignal;
      //   1069: invokevirtual 311	android/os/CancellationSignal:throwIfCanceled	()V
      //   1072: aload 10
      //   1074: aload 11
      //   1076: invokevirtual 499	java/io/File:renameTo	(Ljava/io/File;)Z
      //   1079: istore 5
      //   1081: invokestatic 95	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:iSO	()Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$a;
      //   1084: ldc 97
      //   1086: ldc_w 501
      //   1089: iconst_2
      //   1090: anewarray 4	java/lang/Object
      //   1093: dup
      //   1094: iconst_0
      //   1095: aload 10
      //   1097: invokevirtual 131	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   1100: aastore
      //   1101: dup
      //   1102: iconst_1
      //   1103: aload 11
      //   1105: invokevirtual 131	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   1108: aastore
      //   1109: invokeinterface 327 4 0
      //   1114: iload 5
      //   1116: ifne -220 -> 896
      //   1119: aload_0
      //   1120: aload 10
      //   1122: aload 11
      //   1124: invokespecial 525	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:d	(Ljava/io/File;Ljava/io/File;)V
      //   1127: aload 10
      //   1129: invokevirtual 528	java/io/File:delete	()Z
      //   1132: ifne -236 -> 896
      //   1135: invokestatic 95	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:iSO	()Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$a;
      //   1138: ldc 97
      //   1140: ldc_w 530
      //   1143: iconst_1
      //   1144: anewarray 4	java/lang/Object
      //   1147: dup
      //   1148: iconst_0
      //   1149: aload 10
      //   1151: invokevirtual 131	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   1154: aastore
      //   1155: invokeinterface 105 4 0
      //   1160: goto -264 -> 896
      //   1163: aload 11
      //   1165: invokevirtual 277	java/io/File:exists	()Z
      //   1168: ifne +36 -> 1204
      //   1171: aload 11
      //   1173: invokevirtual 284	java/io/File:mkdirs	()Z
      //   1176: ifne +28 -> 1204
      //   1179: invokestatic 95	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:iSO	()Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$a;
      //   1182: ldc 97
      //   1184: ldc_w 532
      //   1187: iconst_1
      //   1188: anewarray 4	java/lang/Object
      //   1191: dup
      //   1192: iconst_0
      //   1193: aload 11
      //   1195: invokevirtual 131	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   1198: aastore
      //   1199: invokeinterface 534 4 0
      //   1204: aload_0
      //   1205: getfield 57	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:mProgress	F
      //   1208: fstore_1
      //   1209: aload_0
      //   1210: aload 10
      //   1212: getfield 504	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a$a:acqh	F
      //   1215: fload_1
      //   1216: fadd
      //   1217: putfield 57	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:mProgress	F
      //   1220: aload_0
      //   1221: getfield 57	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:mProgress	F
      //   1224: ldc_w 505
      //   1227: fmul
      //   1228: ldc_w 506
      //   1231: fmul
      //   1232: f2d
      //   1233: invokestatic 512	java/lang/Math:floor	(D)D
      //   1236: d2i
      //   1237: istore_2
      //   1238: aload_0
      //   1239: getfield 37	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:acpY	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   1242: invokestatic 347	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:f	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;)Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b;
      //   1245: iload_2
      //   1246: invokevirtual 477	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b:ayc	(I)V
      //   1249: goto -750 -> 499
      //   1252: aload 7
      //   1254: invokeinterface 537 1 0
      //   1259: iconst_1
      //   1260: isub
      //   1261: istore_2
      //   1262: iload_2
      //   1263: iflt +67 -> 1330
      //   1266: aload_0
      //   1267: getfield 59	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:eMV	Landroid/os/CancellationSignal;
      //   1270: invokevirtual 311	android/os/CancellationSignal:throwIfCanceled	()V
      //   1273: aload 7
      //   1275: iload_2
      //   1276: invokeinterface 539 2 0
      //   1281: checkcast 127	java/io/File
      //   1284: astore 8
      //   1286: aload 8
      //   1288: invokevirtual 277	java/io/File:exists	()Z
      //   1291: ifeq +332 -> 1623
      //   1294: aload 8
      //   1296: invokevirtual 528	java/io/File:delete	()Z
      //   1299: ifne +324 -> 1623
      //   1302: invokestatic 95	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:iSO	()Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$a;
      //   1305: ldc 97
      //   1307: ldc_w 541
      //   1310: iconst_1
      //   1311: anewarray 4	java/lang/Object
      //   1314: dup
      //   1315: iconst_0
      //   1316: aload 8
      //   1318: invokevirtual 131	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   1321: aastore
      //   1322: invokeinterface 105 4 0
      //   1327: goto +296 -> 1623
      //   1330: aload 7
      //   1332: invokeinterface 544 1 0
      //   1337: aload_0
      //   1338: getfield 57	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:mProgress	F
      //   1341: fconst_1
      //   1342: invokestatic 550	java/lang/Float:compare	(FF)I
      //   1345: ifeq +15 -> 1360
      //   1348: aload_0
      //   1349: getfield 37	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:acpY	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   1352: invokestatic 347	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:f	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;)Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b;
      //   1355: bipush 100
      //   1357: invokevirtual 477	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b:ayc	(I)V
      //   1360: aload_0
      //   1361: getfield 51	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:acqd	Ljava/lang/String;
      //   1364: invokestatic 555	com/tencent/mm/sdcard_migrate/b:buj	(Ljava/lang/String;)V
      //   1367: aload_0
      //   1368: getfield 37	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:acpY	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   1371: invokestatic 347	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:f	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;)Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b;
      //   1374: astore 8
      //   1376: aload 8
      //   1378: iconst_1
      //   1379: invokevirtual 353	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b:Ky	(Z)Landroidx/core/app/f$d;
      //   1382: invokestatic 561	java/lang/System:currentTimeMillis	()J
      //   1385: invokevirtual 565	androidx/core/app/f$d:bt	(J)Landroidx/core/app/f$d;
      //   1388: getstatic 568	com/tencent/mm/R$l:ext_storage_migration_dialog_success_msg	I
      //   1391: invokestatic 362	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:ayb	(I)Ljava/lang/String;
      //   1394: invokevirtual 368	androidx/core/app/f$d:m	(Ljava/lang/CharSequence;)Landroidx/core/app/f$d;
      //   1397: iconst_0
      //   1398: iconst_0
      //   1399: iconst_0
      //   1400: invokevirtual 371	androidx/core/app/f$d:d	(IIZ)Landroidx/core/app/f$d;
      //   1403: iconst_1
      //   1404: invokevirtual 571	androidx/core/app/f$d:aC	(Z)Landroidx/core/app/f$d;
      //   1407: astore 7
      //   1409: aload 7
      //   1411: aload 8
      //   1413: iconst_1
      //   1414: invokevirtual 386	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b:Kz	(Z)Landroid/app/PendingIntent;
      //   1417: putfield 390	androidx/core/app/f$d:bor	Landroid/app/PendingIntent;
      //   1420: aload 7
      //   1422: iconst_2
      //   1423: iconst_0
      //   1424: invokevirtual 375	androidx/core/app/f$d:q	(IZ)V
      //   1427: aload 8
      //   1429: getfield 391	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b:acpY	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   1432: aload 7
      //   1434: invokevirtual 403	androidx/core/app/f$d:DA	()Landroid/app/Notification;
      //   1437: invokestatic 574	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:a	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;Landroid/app/Notification;)V
      //   1440: aload 8
      //   1442: getfield 391	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b:acpY	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   1445: invokestatic 410	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:a	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;)[Lcom/tencent/mm/sdcard_migrate/MigrateResultCallback;
      //   1448: astore 7
      //   1450: aload 7
      //   1452: monitorenter
      //   1453: aload 8
      //   1455: getfield 391	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b:acpY	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   1458: invokestatic 410	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:a	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;)[Lcom/tencent/mm/sdcard_migrate/MigrateResultCallback;
      //   1461: iconst_0
      //   1462: aaload
      //   1463: astore 8
      //   1465: aload 8
      //   1467: ifnull +21 -> 1488
      //   1470: aload 8
      //   1472: invokevirtual 416	com/tencent/mm/sdcard_migrate/MigrateResultCallback:asBinder	()Landroid/os/IBinder;
      //   1475: invokeinterface 421 1 0
      //   1480: ifeq +8 -> 1488
      //   1483: aload 8
      //   1485: invokevirtual 577	com/tencent/mm/sdcard_migrate/MigrateResultCallback:iTn	()V
      //   1488: aload 7
      //   1490: monitorexit
      //   1491: aload_0
      //   1492: iconst_0
      //   1493: invokespecial 343	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:Kx	(Z)V
      //   1496: invokestatic 451	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:iSR	()V
      //   1499: aload_0
      //   1500: getfield 37	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:acpY	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   1503: invokestatic 453	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:i	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;)V
      //   1506: aload_0
      //   1507: getfield 37	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:acpY	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   1510: invokestatic 456	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:j	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;)V
      //   1513: ldc_w 337
      //   1516: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1519: return
      //   1520: astore 8
      //   1522: invokestatic 95	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:iSO	()Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$a;
      //   1525: ldc_w 458
      //   1528: aload 8
      //   1530: ldc_w 460
      //   1533: iconst_0
      //   1534: anewarray 4	java/lang/Object
      //   1537: invokeinterface 438 5 0
      //   1542: goto -54 -> 1488
      //   1545: astore 8
      //   1547: aload 7
      //   1549: monitorexit
      //   1550: ldc_w 337
      //   1553: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1556: aload 8
      //   1558: athrow
      //   1559: aload_0
      //   1560: getfield 37	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:acpY	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   1563: invokestatic 347	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:f	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;)Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b;
      //   1566: bipush 6
      //   1568: aconst_null
      //   1569: invokevirtual 465	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b:d	(ILjava/lang/Throwable;)V
      //   1572: goto -1265 -> 307
      //   1575: astore 7
      //   1577: aload_0
      //   1578: iconst_0
      //   1579: invokespecial 343	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:Kx	(Z)V
      //   1582: invokestatic 451	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:iSR	()V
      //   1585: aload_0
      //   1586: getfield 37	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:acpY	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   1589: invokestatic 453	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:i	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;)V
      //   1592: aload_0
      //   1593: getfield 37	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:acpY	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   1596: invokestatic 456	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:j	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;)V
      //   1599: ldc_w 337
      //   1602: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1605: aload 7
      //   1607: athrow
      //   1608: iload_2
      //   1609: iconst_1
      //   1610: iadd
      //   1611: istore_2
      //   1612: goto -806 -> 806
      //   1615: astore 12
      //   1617: iconst_0
      //   1618: istore 5
      //   1620: goto -506 -> 1114
      //   1623: iload_2
      //   1624: iconst_1
      //   1625: isub
      //   1626: istore_2
      //   1627: goto -365 -> 1262
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	1630	0	this	a
      //   799	417	1	f	float
      //   737	890	2	i	int
      //   803	6	3	j	int
      //   923	10	4	k	int
      //   656	963	5	bool1	boolean
      //   1058	3	6	bool2	boolean
      //   31	225	7	localObject1	Object
      //   258	8	7	localOperationCanceledException	android.os.OperationCanceledException
      //   336	9	7	localThrowable1	Throwable
      //   361	12	7	localObject2	Object
      //   375	30	7	localThrowable2	Throwable
      //   1575	31	7	localObject4	Object
      //   37	1447	8	localObject5	Object
      //   1520	9	8	localThrowable3	Throwable
      //   1545	12	8	localObject6	Object
      //   61	751	9	localObject7	Object
      //   25	1186	10	localObject8	Object
      //   549	645	11	localFile	File
      //   752	1	12	localObject9	Object
      //   1615	1	12	localObject10	Object
      // Exception table:
      //   from	to	target	type
      //   6	131	258	android/os/OperationCanceledException
      //   173	258	258	android/os/OperationCanceledException
      //   363	375	258	android/os/OperationCanceledException
      //   438	499	258	android/os/OperationCanceledException
      //   499	596	258	android/os/OperationCanceledException
      //   599	658	258	android/os/OperationCanceledException
      //   754	778	258	android/os/OperationCanceledException
      //   783	804	258	android/os/OperationCanceledException
      //   817	851	258	android/os/OperationCanceledException
      //   854	896	258	android/os/OperationCanceledException
      //   896	937	258	android/os/OperationCanceledException
      //   940	996	258	android/os/OperationCanceledException
      //   999	1048	258	android/os/OperationCanceledException
      //   1054	1060	258	android/os/OperationCanceledException
      //   1119	1160	258	android/os/OperationCanceledException
      //   1163	1204	258	android/os/OperationCanceledException
      //   1204	1249	258	android/os/OperationCanceledException
      //   1252	1262	258	android/os/OperationCanceledException
      //   1266	1327	258	android/os/OperationCanceledException
      //   1330	1360	258	android/os/OperationCanceledException
      //   1360	1453	258	android/os/OperationCanceledException
      //   1547	1559	258	android/os/OperationCanceledException
      //   148	170	336	finally
      //   131	143	361	finally
      //   170	173	361	finally
      //   338	358	361	finally
      //   6	131	375	finally
      //   173	258	375	finally
      //   363	375	375	finally
      //   438	499	375	finally
      //   499	596	375	finally
      //   599	658	375	finally
      //   754	778	375	finally
      //   783	804	375	finally
      //   817	851	375	finally
      //   854	896	375	finally
      //   896	937	375	finally
      //   940	996	375	finally
      //   999	1048	375	finally
      //   1054	1060	375	finally
      //   1119	1160	375	finally
      //   1163	1204	375	finally
      //   1204	1249	375	finally
      //   1252	1262	375	finally
      //   1266	1327	375	finally
      //   1330	1360	375	finally
      //   1360	1453	375	finally
      //   1547	1559	375	finally
      //   663	749	752	finally
      //   1470	1488	1520	finally
      //   1453	1465	1545	finally
      //   1488	1491	1545	finally
      //   1522	1542	1545	finally
      //   260	307	1575	finally
      //   377	409	1575	finally
      //   1559	1572	1575	finally
      //   1065	1114	1615	finally
    }
    
    final class a
    {
      final File acqg;
      final float acqh;
      
      a(File paramFile, float paramFloat)
      {
        this.acqg = paramFile;
        this.acqh = paramFloat;
      }
    }
  }
  
  final class b
  {
    private final f.d[] acqj;
    private final int[] acqk;
    
    private b()
    {
      AppMethodBeat.i(257128);
      this.acqj = new f.d[] { null };
      this.acqk = new int[] { -1 };
      AppMethodBeat.o(257128);
    }
    
    final f.d Ky(boolean paramBoolean)
    {
      AppMethodBeat.i(257151);
      synchronized (this.acqj)
      {
        if ((this.acqj[0] != null) && (!paramBoolean))
        {
          localObject1 = this.acqj[0];
          AppMethodBeat.o(257151);
          return localObject1;
        }
        try
        {
          if (Build.VERSION.SDK_INT < 26) {
            break label158;
          }
          localObject1 = (NotificationManager)ExtStorageMigrateService.this.getSystemService("notification");
          localObject4 = ((NotificationManager)localObject1).getNotificationChannels().iterator();
          do
          {
            if (!((Iterator)localObject4).hasNext()) {
              break;
            }
          } while (!"reminder_channel_id".equals(((NotificationChannel)((Iterator)localObject4).next()).getId()));
          i = 1;
        }
        finally
        {
          for (;;)
          {
            Object localObject4;
            continue;
            int i = 0;
          }
        }
        if (i == 0)
        {
          localObject4 = new NotificationChannel("reminder_channel_id", ExtStorageMigrateService.this.getString(g.b.notification_reminder_channel_name), 2);
          ((NotificationChannel)localObject4).setDescription(ExtStorageMigrateService.this.getString(g.b.notification_reminder_channel_desc));
          ((NotificationManager)localObject1).createNotificationChannel((NotificationChannel)localObject4);
        }
        label158:
        Object localObject1 = new f.d(ExtStorageMigrateService.this.getApplicationContext(), "reminder_channel_id");
        ((f.d)localObject1).l(ExtStorageMigrateService.ayb(R.l.app_name)).eb(R.g.notification_icon_gray).aC(false);
        this.acqj[0] = localObject1;
        AppMethodBeat.o(257151);
        return localObject1;
      }
    }
    
    final PendingIntent Kz(boolean paramBoolean)
    {
      AppMethodBeat.i(257166);
      Object localObject = new Intent(ExtStorageMigrateService.this, ExtStorageMigrateAuxActivity.class);
      ((Intent)localObject).setAction("auxui_action_do_migrate_routine");
      ((Intent)localObject).putExtra("auxui_param_is_migration_end", paramBoolean);
      ((Intent)localObject).addFlags(268435456);
      localObject = PendingIntent.getActivity(ExtStorageMigrateService.this, 3841, (Intent)localObject, 268435456);
      AppMethodBeat.o(257166);
      return localObject;
    }
    
    final void ayc(int paramInt)
    {
      AppMethodBeat.i(257174);
      synchronized (this.acqk)
      {
        if ((this.acqk[0] == -1) || ((paramInt != this.acqk[0]) && (paramInt % 10 == 0)))
        {
          f.d locald = Ky(false).m(ExtStorageMigrateService.ayb(R.l.ext_storage_migration_dialog_migrating_msg));
          locald.q(2, true);
          locald = locald.d(100, paramInt, false);
          ((NotificationManager)ExtStorageMigrateService.this.getSystemService("notification")).notify(1027, locald.DA());
        }
        this.acqk[0] = paramInt;
      }
      synchronized (ExtStorageMigrateService.a(ExtStorageMigrateService.this))
      {
        com.tencent.mm.sdcard_migrate.util.a.b(ExtStorageMigrateService.a(ExtStorageMigrateService.this)[0], paramInt);
        AppMethodBeat.o(257174);
        return;
        localObject2 = finally;
        AppMethodBeat.o(257174);
        throw localObject2;
      }
    }
    
    final void ayd(int paramInt)
    {
      AppMethodBeat.i(257187);
      ??? = Ky(true).bt(System.currentTimeMillis()).m(ExtStorageMigrateService.ayb(R.l.ext_storage_migration_dialog_cancel_msg)).d(0, 0, false).aC(true);
      ((f.d)???).bor = Kz(true);
      ((f.d)???).q(2, false);
      ExtStorageMigrateService.a(ExtStorageMigrateService.this, ((f.d)???).DA());
      synchronized (ExtStorageMigrateService.a(ExtStorageMigrateService.this))
      {
        com.tencent.mm.sdcard_migrate.util.a.a(ExtStorageMigrateService.a(ExtStorageMigrateService.this)[0], paramInt);
        AppMethodBeat.o(257187);
        return;
      }
    }
    
    final void d(int paramInt, Throwable paramThrowable)
    {
      AppMethodBeat.i(257181);
      f.d locald = Ky(true).bt(System.currentTimeMillis());
      if (paramInt == 6) {
        ??? = ExtStorageMigrateService.ayb(R.l.ext_storage_migration_dialog_interrupt_msg);
      }
      for (;;)
      {
        ??? = locald.m((CharSequence)???).d(0, 0, false).aC(true);
        ((f.d)???).bor = Kz(true);
        ((f.d)???).q(2, false);
        ExtStorageMigrateService.a(ExtStorageMigrateService.this, ((f.d)???).DA());
        synchronized (ExtStorageMigrateService.a(ExtStorageMigrateService.this))
        {
          com.tencent.mm.sdcard_migrate.util.a.a(ExtStorageMigrateService.a(ExtStorageMigrateService.this)[0], paramInt, paramThrowable);
          AppMethodBeat.o(257181);
          return;
          ??? = ExtStorageMigrateService.ayb(R.l.ext_storage_migration_dialog_failure_msg);
        }
      }
    }
    
    final f.a iTb()
    {
      AppMethodBeat.i(257160);
      Object localObject = new Intent(ExtStorageMigrateService.this, ExtStorageMigrateService.class);
      ((Intent)localObject).setAction("service_action_cancel_migrate");
      localObject = PendingIntent.getService(ExtStorageMigrateService.this, 3843, (Intent)localObject, 268435456);
      localObject = new f.a.a(R.g.notification_message_ignore_icon, ExtStorageMigrateService.ayb(R.l.cancel), (PendingIntent)localObject);
      ((f.a.a)localObject).boe = false;
      localObject = ((f.a.a)localObject).Dx();
      AppMethodBeat.o(257160);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.sdcard_migrate.ExtStorageMigrateService
 * JD-Core Version:    0.7.0.1
 */