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
import com.tencent.mm.sdk.platformtools.ak;
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
  private final b ItF;
  private final a[] ItG;
  private Thread ItH;
  private final MigrateResultCallback[] ItI;
  private volatile int ItJ;
  private final boolean[] ItK;
  private final PowerManager.WakeLock[] ItL;
  private final boolean[] ItM;
  private final e.a ItN;
  
  public ExtStorageMigrateService()
  {
    AppMethodBeat.i(169829);
    this.ItF = new b((byte)0);
    this.ItG = new a[] { null };
    this.ItH = null;
    this.ItI = new MigrateResultCallback[] { null };
    this.ItJ = 0;
    this.ItK = new boolean[] { false };
    this.ItL = new PowerManager.WakeLock[] { null };
    this.ItM = new boolean[] { false };
    this.ItN = new e.a()
    {
      public final void a(ExtStorageMigrateConfig paramAnonymousExtStorageMigrateConfig)
      {
        AppMethodBeat.i(186831);
        ExtStorageMigrateService.a(ExtStorageMigrateService.this, paramAnonymousExtStorageMigrateConfig);
        AppMethodBeat.o(186831);
      }
      
      public final void a(MigrateResultCallback paramAnonymousMigrateResultCallback)
      {
        AppMethodBeat.i(186829);
        synchronized (ExtStorageMigrateService.a(ExtStorageMigrateService.this))
        {
          if ((ExtStorageMigrateService.a(ExtStorageMigrateService.this)[0] != null) && (ExtStorageMigrateService.a(ExtStorageMigrateService.this)[0] != paramAnonymousMigrateResultCallback)) {
            ExtStorageMigrateService.a(ExtStorageMigrateService.this)[0].jx(ExtStorageMigrateService.c(ExtStorageMigrateService.this), Binder.getCallingPid());
          }
          ExtStorageMigrateService.a(ExtStorageMigrateService.this)[0] = paramAnonymousMigrateResultCallback;
          if (!fnf()) {
            break label147;
          }
        }
        synchronized (ExtStorageMigrateService.b(ExtStorageMigrateService.this))
        {
          paramAnonymousMigrateResultCallback.lP(ExtStorageMigrateService.a.c(ExtStorageMigrateService.b(ExtStorageMigrateService.this)[0]), ExtStorageMigrateService.a.d(ExtStorageMigrateService.b(ExtStorageMigrateService.this)[0]));
          AppMethodBeat.o(186829);
          return;
          paramAnonymousMigrateResultCallback = finally;
          AppMethodBeat.o(186829);
          throw paramAnonymousMigrateResultCallback;
        }
        label147:
        AppMethodBeat.o(186829);
      }
      
      public final void b(MigrateResultCallback arg1)
      {
        AppMethodBeat.i(186830);
        synchronized (ExtStorageMigrateService.a(ExtStorageMigrateService.this))
        {
          if (ExtStorageMigrateService.a(ExtStorageMigrateService.this)[0] != null) {
            ExtStorageMigrateService.a(ExtStorageMigrateService.this)[0] = null;
          }
          AppMethodBeat.o(186830);
          return;
        }
      }
      
      public final boolean fnf()
      {
        AppMethodBeat.i(186828);
        if ((ExtStorageMigrateService.b(ExtStorageMigrateService.this)[0] != null) && (ExtStorageMigrateService.a.b(ExtStorageMigrateService.b(ExtStorageMigrateService.this)[0])))
        {
          AppMethodBeat.o(186828);
          return true;
        }
        AppMethodBeat.o(186828);
        return false;
      }
      
      public final void fnj()
      {
        AppMethodBeat.i(186832);
        ExtStorageMigrateService.d(ExtStorageMigrateService.this);
        AppMethodBeat.o(186832);
      }
    };
    AppMethodBeat.o(169829);
  }
  
  private static String Ni(String paramString)
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
      ExtStorageMigrateMonitor.fmX().printErrStackTrace("MicroMsg.ExtStorageMigrateService", localThrowable, "[-] Fail to get canonical path for: %s", new Object[] { paramString });
      paramString = new File(paramString).getAbsolutePath();
      AppMethodBeat.o(169831);
    }
    return paramString;
  }
  
  private static File P(File paramFile)
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
      ExtStorageMigrateMonitor.fmX().printErrStackTrace("MicroMsg.ExtStorageMigrateService", localThrowable, "[-] Fail to get canonical file for: %s", new Object[] { paramFile.getAbsolutePath() });
      paramFile = paramFile.getAbsoluteFile();
      AppMethodBeat.o(169830);
    }
    return paramFile;
  }
  
  private boolean fnf()
  {
    boolean bool2 = false;
    AppMethodBeat.i(186845);
    a[] arrayOfa = this.ItG;
    boolean bool1 = bool2;
    try
    {
      if (this.ItG[0] != null)
      {
        bool1 = bool2;
        if (a.b(this.ItG[0])) {
          bool1 = true;
        }
      }
      return bool1;
    }
    finally
    {
      AppMethodBeat.o(186845);
    }
  }
  
  private boolean fng()
  {
    synchronized (this.ItK)
    {
      int i = this.ItK[0];
      return i;
    }
  }
  
  private boolean fnh()
  {
    synchronized (this.ItM)
    {
      int i = this.ItM[0];
      return i;
    }
  }
  
  private void fni()
  {
    AppMethodBeat.i(186846);
    ExtStorageMigrateMonitor.fmX().i("MicroMsg.ExtStorageMigrateService", "[+] expectedStopSelf called.", new Object[0]);
    wD(true);
    stopSelf();
    AppMethodBeat.o(186846);
  }
  
  private void releaseWakeLock()
  {
    AppMethodBeat.i(186847);
    synchronized (this.ItL)
    {
      if ((this.ItL[0] != null) && (this.ItL[0].isHeld()))
      {
        this.ItL[0].release();
        this.ItL[0] = null;
        ExtStorageMigrateMonitor.fmX().i("MicroMsg.ExtStorageMigrateService", "[+] WakeLock released.", new Object[0]);
      }
      AppMethodBeat.o(186847);
      return;
    }
  }
  
  private void wC(boolean paramBoolean)
  {
    synchronized (this.ItK)
    {
      this.ItK[0] = paramBoolean;
      return;
    }
  }
  
  private void wD(boolean paramBoolean)
  {
    synchronized (this.ItM)
    {
      this.ItM[0] = paramBoolean;
      return;
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    AppMethodBeat.i(186844);
    paramIntent = this.ItN.asBinder();
    AppMethodBeat.o(186844);
    return paramIntent;
  }
  
  public void onCreate()
  {
    AppMethodBeat.i(186843);
    super.onCreate();
    synchronized (this.ItG)
    {
      this.ItG[0] = null;
      this.ItH = null;
    }
    synchronized (this.ItI)
    {
      this.ItI[0] = null;
      this.ItJ = 0;
      wC(false);
      AppMethodBeat.o(186843);
      return;
      localObject2 = finally;
      AppMethodBeat.o(186843);
      throw localObject2;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(169833);
    ExtStorageMigrateMonitor.fmX().i("MicroMsg.ExtStorageMigrateService", "[+] OnDestroy called.", new Object[0]);
    synchronized (this.ItG)
    {
      if (fnf()) {
        a.a(this.ItG[0]);
      }
    }
    try
    {
      this.ItH.join();
      for (;;)
      {
        label53:
        this.ItG[0] = null;
        if (fng()) {
          stopForeground(true);
        }
        releaseWakeLock();
        AppMethodBeat.o(169833);
        return;
        if (fng()) {
          if (fnh())
          {
            wD(false);
            this.ItF.aaR(2);
            continue;
            localObject = finally;
            AppMethodBeat.o(169833);
            throw localObject;
          }
          else
          {
            this.ItF.c(6, null);
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
    ExtStorageMigrateMonitor.fmX().i("MicroMsg.ExtStorageMigrateService", "[+] OnStartCommand called, intent: %s", new Object[] { paramIntent });
    if (paramIntent == null)
    {
      ExtStorageMigrateMonitor.fmX().e("MicroMsg.ExtStorageMigrateService", "[-] intent is null, skip rest logic.", new Object[0]);
      fni();
    }
    for (;;)
    {
      AppMethodBeat.o(169832);
      return 2;
      paramIntent = paramIntent.getAction();
      if (paramIntent == null)
      {
        ExtStorageMigrateMonitor.fmX().e("MicroMsg.ExtStorageMigrateService", "[-] action is null, skip rest logic.", new Object[0]);
        fni();
      }
      else if ("service_action_startup".equals(paramIntent))
      {
        Object localObject = this.ItF;
        if ((((b)localObject).ItO.fng()) || (((b)localObject).ItO.fnf()))
        {
          ExtStorageMigrateMonitor.fmX().w("MicroMsg.ExtStorageMigrateService", "[!] Already on foreground or migrating logic, skip startup steps.", new Object[0]);
        }
        else
        {
          paramIntent = ((b)localObject).wF(true);
          s.c localc = paramIntent.i(System.currentTimeMillis()).g(ak.getResources().getString(2131758667)).b(0, 0, true);
          localc.f(2, true);
          localc.a(((b)localObject).fnk()).Hl = ((b)localObject).wG(false);
          localObject = ((b)localObject).ItO;
          ((ExtStorageMigrateService)localObject).startForeground(1027, paramIntent.build());
          ((ExtStorageMigrateService)localObject).wC(true);
        }
      }
      else if ("service_action_cancel_migrate".equals(paramIntent))
      {
        fni();
      }
      else
      {
        ExtStorageMigrateMonitor.fmX().e("MicroMsg.ExtStorageMigrateService", "[-] Unknown action: %s", new Object[] { paramIntent });
      }
    }
  }
  
  final class a
    implements Runnable
  {
    private final boolean[] ItP;
    private final CancellationSignal ItQ;
    private final Set<String> ItR;
    private final Set<String> ItS;
    private final Map<String, String> ItT;
    private String ItU;
    private String ItV;
    private ByteBuffer ItW;
    private final boolean Itp;
    private float mProgress;
    
    a(ExtStorageMigrateConfig paramExtStorageMigrateConfig, CancellationSignal paramCancellationSignal)
    {
      AppMethodBeat.i(186833);
      this.ItP = new boolean[] { false };
      this.ItU = null;
      this.ItV = null;
      this.ItW = null;
      this.mProgress = 0.0F;
      this.ItQ = paramCancellationSignal;
      this.Itp = paramExtStorageMigrateConfig.Itk;
      this.ItR = new HashSet(64);
      this.ItS = new HashSet(5);
      this.ItT = new HashMap(5);
      this.ItU = ExtStorageMigrateService.access$1500(paramExtStorageMigrateConfig.sourceDir);
      this.ItV = ExtStorageMigrateService.access$1500(paramExtStorageMigrateConfig.Itj);
      if (paramExtStorageMigrateConfig.Itk) {
        ExtStorageMigrateMonitor.fmX().w("MicroMsg.ExtStorageMigrateService", "[!] Force copy mode enabled, are we under test mode ??", new Object[0]);
      }
      b(paramExtStorageMigrateConfig.sourceDir, paramExtStorageMigrateConfig.Itl);
      ExtStorageMigrateMonitor.fmX().i("MicroMsg.ExtStorageMigrateService", "[+] MigrateTask, pass in config: %s", new Object[] { paramExtStorageMigrateConfig });
      AppMethodBeat.o(186833);
    }
    
    private String R(File paramFile)
    {
      AppMethodBeat.i(169821);
      paramFile = aRm(paramFile.getAbsolutePath().substring(this.ItU.length()));
      if (paramFile.startsWith("/")) {
        paramFile = paramFile.substring(1);
      }
      for (;;)
      {
        ExtStorageMigrateMonitor.fmX().i("MicroMsg.ExtStorageMigrateService", "[+] getMigratedFilePath, relSrcPath: %s", new Object[] { paramFile });
        Object localObject2;
        label182:
        int i;
        for (Object localObject1 = paramFile;; localObject1 = ((String)localObject1).substring(0, i))
        {
          localObject2 = paramFile;
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject2 = (String)this.ItT.get(localObject1);
            ExtStorageMigrateMonitor.fmX().i("MicroMsg.ExtStorageMigrateService", "[+] getMigratedFilePath, currRelSrcPath: %s, newRelPath: %s", new Object[] { localObject1, localObject2 });
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
            ExtStorageMigrateMonitor.fmX().i("MicroMsg.ExtStorageMigrateService", "[+] getMigratedFilePath, result: %s", new Object[] { localObject2 });
            AppMethodBeat.o(169821);
            return localObject2;
            i = ((String)localObject1).lastIndexOf('/');
            localObject2 = paramFile;
          } while (i < 0);
        }
        paramFile = this.ItV + "/" + (String)localObject2;
        ExtStorageMigrateMonitor.fmX().i("MicroMsg.ExtStorageMigrateService", "[+] getMigratedFilePath, result: %s", new Object[] { paramFile });
        AppMethodBeat.o(169821);
        return paramFile;
      }
    }
    
    private static String aRl(String paramString)
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
    
    private static String aRm(String paramString)
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
    
    private void b(String paramString, Collection<ExtStorageMigrateConfig.ExtraPathAction> paramCollection)
    {
      AppMethodBeat.i(186834);
      if (paramCollection == null)
      {
        AppMethodBeat.o(186834);
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
          localObject = ExtStorageMigrateService.Q(new File(paramString, paramCollection.Itr));
          this.ItS.add(((File)localObject).getAbsolutePath());
          lO(paramString, paramCollection.Itr);
        }
        else if ((paramCollection instanceof ExtStorageMigrateConfig.ExtraPathAction.Remap))
        {
          localObject = (ExtStorageMigrateConfig.ExtraPathAction.Remap)paramCollection;
          Map localMap = this.ItT;
          String str = aRm(((ExtStorageMigrateConfig.ExtraPathAction.Remap)localObject).Its);
          if (((ExtStorageMigrateConfig.ExtraPathAction.Remap)localObject).iww.startsWith("/")) {}
          for (paramCollection = ((ExtStorageMigrateConfig.ExtraPathAction.Remap)localObject).iww;; paramCollection = aRm(((ExtStorageMigrateConfig.ExtraPathAction.Remap)localObject).iww))
          {
            localMap.put(str, paramCollection);
            lO(paramString, ((ExtStorageMigrateConfig.ExtraPathAction.Remap)localObject).Its);
            break;
          }
        }
      }
      this.ItR.add(paramString);
      ExtStorageMigrateMonitor.fmX().i("MicroMsg.ExtStorageMigrateService", "[+] MigrateTask, mSrcDirPath: %s, mDestDirPath: %s, mRemappedRelPaths: %s", new Object[] { this.ItU, this.ItV, this.ItT });
      AppMethodBeat.o(186834);
    }
    
    /* Error */
    private void e(File paramFile1, File paramFile2)
    {
      // Byte code:
      //   0: ldc_w 273
      //   3: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   6: aload_2
      //   7: invokevirtual 276	java/io/File:exists	()Z
      //   10: ifne +11 -> 21
      //   13: aload_2
      //   14: invokevirtual 280	java/io/File:getParentFile	()Ljava/io/File;
      //   17: invokevirtual 283	java/io/File:mkdirs	()Z
      //   20: pop
      //   21: new 285	java/io/BufferedInputStream
      //   24: dup
      //   25: new 287	java/io/FileInputStream
      //   28: dup
      //   29: aload_1
      //   30: invokespecial 290	java/io/FileInputStream:<init>	(Ljava/io/File;)V
      //   33: invokespecial 293	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
      //   36: astore 4
      //   38: new 295	java/io/BufferedOutputStream
      //   41: dup
      //   42: new 297	java/io/FileOutputStream
      //   45: dup
      //   46: aload_2
      //   47: invokespecial 298	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
      //   50: invokespecial 301	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
      //   53: astore 5
      //   55: sipush 4096
      //   58: newarray byte
      //   60: astore 6
      //   62: aload 4
      //   64: aload 6
      //   66: invokevirtual 307	java/io/InputStream:read	([B)I
      //   69: istore_3
      //   70: iload_3
      //   71: ifle +43 -> 114
      //   74: aload_0
      //   75: getfield 59	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:ItQ	Landroid/os/CancellationSignal;
      //   78: invokevirtual 310	android/os/CancellationSignal:throwIfCanceled	()V
      //   81: aload 5
      //   83: aload 6
      //   85: iconst_0
      //   86: iload_3
      //   87: invokevirtual 316	java/io/OutputStream:write	([BII)V
      //   90: goto -28 -> 62
      //   93: astore_1
      //   94: aload 5
      //   96: astore_2
      //   97: aload_2
      //   98: invokestatic 322	com/tencent/mm/vfs/w:closeQuietly	(Ljava/io/Closeable;)V
      //   101: aload 4
      //   103: invokestatic 322	com/tencent/mm/vfs/w:closeQuietly	(Ljava/io/Closeable;)V
      //   106: ldc_w 273
      //   109: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   112: aload_1
      //   113: athrow
      //   114: invokestatic 95	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:fmX	()Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$a;
      //   117: ldc 97
      //   119: ldc_w 324
      //   122: iconst_2
      //   123: anewarray 4	java/lang/Object
      //   126: dup
      //   127: iconst_0
      //   128: aload_1
      //   129: invokevirtual 129	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   132: aastore
      //   133: dup
      //   134: iconst_1
      //   135: aload_2
      //   136: invokevirtual 129	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   139: aastore
      //   140: invokeinterface 326 4 0
      //   145: aload 5
      //   147: invokestatic 322	com/tencent/mm/vfs/w:closeQuietly	(Ljava/io/Closeable;)V
      //   150: aload 4
      //   152: invokestatic 322	com/tencent/mm/vfs/w:closeQuietly	(Ljava/io/Closeable;)V
      //   155: ldc_w 273
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
      synchronized (this.ItP)
      {
        int i = this.ItP[0];
        return i;
      }
    }
    
    private void lO(String paramString1, String paramString2)
    {
      AppMethodBeat.i(169816);
      String str = aRl(paramString1);
      paramString1 = new File(str, paramString2);
      do
      {
        this.ItR.add(aRl(paramString1.getAbsolutePath()));
        paramString2 = paramString1.getParentFile();
        if (paramString2 == null) {
          break;
        }
        paramString1 = paramString2;
      } while (!str.equals(paramString2.getAbsolutePath()));
      AppMethodBeat.o(169816);
    }
    
    private void wE(boolean paramBoolean)
    {
      synchronized (this.ItP)
      {
        this.ItP[0] = paramBoolean;
        return;
      }
    }
    
    /* Error */
    public final void run()
    {
      // Byte code:
      //   0: ldc_w 340
      //   3: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   6: aload_0
      //   7: getfield 37	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:ItO	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   10: invokestatic 343	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:e	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;)V
      //   13: aload_0
      //   14: iconst_1
      //   15: invokespecial 345	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:wE	(Z)V
      //   18: aload_0
      //   19: getfield 37	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:ItO	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   22: invokestatic 349	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:f	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;)Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b;
      //   25: astore 10
      //   27: aload_0
      //   28: getfield 51	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:ItU	Ljava/lang/String;
      //   31: astore 7
      //   33: aload_0
      //   34: getfield 53	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:ItV	Ljava/lang/String;
      //   37: astore 8
      //   39: aload 10
      //   41: iconst_1
      //   42: invokevirtual 355	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b:wF	(Z)Landroid/support/v4/app/s$c;
      //   45: ldc_w 356
      //   48: invokestatic 359	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:aaP	(I)Ljava/lang/String;
      //   51: invokevirtual 365	android/support/v4/app/s$c:g	(Ljava/lang/CharSequence;)Landroid/support/v4/app/s$c;
      //   54: bipush 100
      //   56: iconst_0
      //   57: iconst_0
      //   58: invokevirtual 368	android/support/v4/app/s$c:b	(IIZ)Landroid/support/v4/app/s$c;
      //   61: astore 9
      //   63: aload 9
      //   65: iconst_2
      //   66: iconst_1
      //   67: invokevirtual 371	android/support/v4/app/s$c:f	(IZ)V
      //   70: aload 9
      //   72: aload 10
      //   74: invokevirtual 375	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b:fnk	()Landroid/support/v4/app/s$a;
      //   77: invokevirtual 378	android/support/v4/app/s$c:a	(Landroid/support/v4/app/s$a;)Landroid/support/v4/app/s$c;
      //   80: astore 9
      //   82: aload 9
      //   84: aload 10
      //   86: iconst_0
      //   87: invokevirtual 382	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b:wG	(Z)Landroid/app/PendingIntent;
      //   90: putfield 386	android/support/v4/app/s$c:Hl	Landroid/app/PendingIntent;
      //   93: aload 10
      //   95: getfield 387	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b:ItO	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   98: ldc_w 389
      //   101: invokevirtual 393	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
      //   104: checkcast 395	android/app/NotificationManager
      //   107: sipush 1027
      //   110: aload 9
      //   112: invokevirtual 399	android/support/v4/app/s$c:build	()Landroid/app/Notification;
      //   115: invokevirtual 403	android/app/NotificationManager:notify	(ILandroid/app/Notification;)V
      //   118: aload 10
      //   120: getfield 387	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b:ItO	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   123: invokestatic 406	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:a	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;)[Lcom/tencent/mm/sdcard_migrate/MigrateResultCallback;
      //   126: astore 9
      //   128: aload 9
      //   130: monitorenter
      //   131: aload 10
      //   133: getfield 387	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b:ItO	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
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
      //   167: invokevirtual 420	com/tencent/mm/sdcard_migrate/MigrateResultCallback:lP	(Ljava/lang/String;Ljava/lang/String;)V
      //   170: aload 9
      //   172: monitorexit
      //   173: aload_0
      //   174: getfield 51	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:ItU	Ljava/lang/String;
      //   177: aload_0
      //   178: getfield 53	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:ItV	Ljava/lang/String;
      //   181: invokevirtual 332	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   184: ifne +1209 -> 1393
      //   187: new 125	java/io/File
      //   190: dup
      //   191: aload_0
      //   192: getfield 51	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:ItU	Ljava/lang/String;
      //   195: invokespecial 204	java/io/File:<init>	(Ljava/lang/String;)V
      //   198: astore 9
      //   200: aload 9
      //   202: invokevirtual 276	java/io/File:exists	()Z
      //   205: ifeq +1188 -> 1393
      //   208: aload 9
      //   210: invokevirtual 423	java/io/File:canRead	()Z
      //   213: ifne +225 -> 438
      //   216: new 425	java/io/IOException
      //   219: dup
      //   220: new 166	java/lang/StringBuilder
      //   223: dup
      //   224: invokespecial 167	java/lang/StringBuilder:<init>	()V
      //   227: aload 9
      //   229: invokevirtual 129	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   232: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   235: ldc_w 427
      //   238: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   241: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   244: invokespecial 428	java/io/IOException:<init>	(Ljava/lang/String;)V
      //   247: astore 7
      //   249: ldc_w 340
      //   252: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   255: aload 7
      //   257: athrow
      //   258: astore 7
      //   260: invokestatic 95	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:fmX	()Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$a;
      //   263: ldc 97
      //   265: aload 7
      //   267: ldc_w 430
      //   270: iconst_0
      //   271: anewarray 4	java/lang/Object
      //   274: invokeinterface 434 5 0
      //   279: aload_0
      //   280: getfield 37	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:ItO	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   283: invokestatic 437	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:g	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;)Z
      //   286: ifeq +1306 -> 1592
      //   289: aload_0
      //   290: getfield 37	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:ItO	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   293: invokestatic 440	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:h	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;)V
      //   296: aload_0
      //   297: getfield 37	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:ItO	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   300: invokestatic 349	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:f	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;)Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b;
      //   303: iconst_3
      //   304: invokevirtual 443	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b:aaR	(I)V
      //   307: aload_0
      //   308: iconst_0
      //   309: invokespecial 345	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:wE	(Z)V
      //   312: invokestatic 446	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:fna	()V
      //   315: aload_0
      //   316: getfield 37	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:ItO	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   319: invokestatic 448	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:i	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;)V
      //   322: aload_0
      //   323: getfield 37	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:ItO	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   326: invokestatic 451	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:j	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;)V
      //   329: ldc_w 340
      //   332: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   335: return
      //   336: astore 7
      //   338: invokestatic 95	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:fmX	()Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$a;
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
      //   377: invokestatic 95	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:fmX	()Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$a;
      //   380: ldc 97
      //   382: aload 7
      //   384: ldc_w 457
      //   387: iconst_0
      //   388: anewarray 4	java/lang/Object
      //   391: invokeinterface 434 5 0
      //   396: aload_0
      //   397: getfield 37	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:ItO	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   400: invokestatic 349	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:f	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;)Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b;
      //   403: iconst_5
      //   404: aload 7
      //   406: invokevirtual 460	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b:c	(ILjava/lang/Throwable;)V
      //   409: aload_0
      //   410: iconst_0
      //   411: invokespecial 345	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:wE	(Z)V
      //   414: invokestatic 446	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:fna	()V
      //   417: aload_0
      //   418: getfield 37	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:ItO	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   421: invokestatic 448	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:i	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;)V
      //   424: aload_0
      //   425: getfield 37	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:ItO	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
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
      //   485: getfield 37	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:ItO	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   488: invokestatic 349	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:f	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;)Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b;
      //   491: aload_0
      //   492: getfield 57	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:mProgress	F
      //   495: f2i
      //   496: invokevirtual 472	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b:aaQ	(I)V
      //   499: aload 8
      //   501: invokeinterface 473 1 0
      //   506: ifne +779 -> 1285
      //   509: aload_0
      //   510: getfield 59	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:ItQ	Landroid/os/CancellationSignal;
      //   513: invokevirtual 310	android/os/CancellationSignal:throwIfCanceled	()V
      //   516: aload 8
      //   518: iconst_0
      //   519: invokeinterface 477 2 0
      //   524: checkcast 11	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a$a
      //   527: astore 10
      //   529: aload 10
      //   531: getfield 481	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a$a:ItX	Ljava/io/File;
      //   534: astore 9
      //   536: new 125	java/io/File
      //   539: dup
      //   540: aload_0
      //   541: aload 9
      //   543: invokespecial 483	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:R	(Ljava/io/File;)Ljava/lang/String;
      //   546: invokespecial 204	java/io/File:<init>	(Ljava/lang/String;)V
      //   549: astore 11
      //   551: aload_0
      //   552: getfield 74	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:ItS	Ljava/util/Set;
      //   555: aload 9
      //   557: invokevirtual 129	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   560: invokestatic 329	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:aRl	(Ljava/lang/String;)Ljava/lang/String;
      //   563: invokeinterface 486 2 0
      //   568: ifeq +64 -> 632
      //   571: invokestatic 95	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:fmX	()Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$a;
      //   574: ldc 97
      //   576: ldc_w 488
      //   579: iconst_1
      //   580: anewarray 4	java/lang/Object
      //   583: dup
      //   584: iconst_0
      //   585: aload 9
      //   587: invokevirtual 129	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   590: aastore
      //   591: invokeinterface 105 4 0
      //   596: goto -97 -> 499
      //   599: astore 7
      //   601: aload_0
      //   602: iconst_0
      //   603: invokespecial 345	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:wE	(Z)V
      //   606: invokestatic 446	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:fna	()V
      //   609: aload_0
      //   610: getfield 37	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:ItO	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   613: invokestatic 448	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:i	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;)V
      //   616: aload_0
      //   617: getfield 37	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:ItO	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   620: invokestatic 451	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:j	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;)V
      //   623: ldc_w 340
      //   626: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   629: aload 7
      //   631: athrow
      //   632: invokestatic 95	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:fmX	()Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$a;
      //   635: ldc 97
      //   637: ldc_w 490
      //   640: iconst_2
      //   641: anewarray 4	java/lang/Object
      //   644: dup
      //   645: iconst_0
      //   646: aload 9
      //   648: invokevirtual 129	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   651: aastore
      //   652: dup
      //   653: iconst_1
      //   654: aload 11
      //   656: invokevirtual 129	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   659: aastore
      //   660: invokeinterface 116 4 0
      //   665: aload_0
      //   666: getfield 66	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:Itp	Z
      //   669: ifne +118 -> 787
      //   672: aload_0
      //   673: getfield 72	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:ItR	Ljava/util/Set;
      //   676: aload 9
      //   678: invokevirtual 129	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   681: invokestatic 329	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:aRl	(Ljava/lang/String;)Ljava/lang/String;
      //   684: invokeinterface 486 2 0
      //   689: istore 5
      //   691: iload 5
      //   693: ifne +94 -> 787
      //   696: aload 9
      //   698: aload 11
      //   700: invokevirtual 494	java/io/File:renameTo	(Ljava/io/File;)Z
      //   703: ifeq +84 -> 787
      //   706: invokestatic 95	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:fmX	()Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$a;
      //   709: ldc 97
      //   711: ldc_w 496
      //   714: iconst_2
      //   715: anewarray 4	java/lang/Object
      //   718: dup
      //   719: iconst_0
      //   720: aload 9
      //   722: invokevirtual 129	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   725: aastore
      //   726: dup
      //   727: iconst_1
      //   728: aload 11
      //   730: invokevirtual 129	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   733: aastore
      //   734: invokeinterface 326 4 0
      //   739: aload_0
      //   740: aload_0
      //   741: getfield 57	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:mProgress	F
      //   744: aload 10
      //   746: getfield 499	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a$a:ItY	F
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
      //   772: getfield 37	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:ItO	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   775: invokestatic 349	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:f	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;)Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b;
      //   778: iload_2
      //   779: invokevirtual 472	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b:aaQ	(I)V
      //   782: goto -283 -> 499
      //   785: astore 12
      //   787: aload_0
      //   788: getfield 59	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:ItQ	Landroid/os/CancellationSignal;
      //   791: invokevirtual 310	android/os/CancellationSignal:throwIfCanceled	()V
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
      //   824: getfield 499	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a$a:ItY	F
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
      //   851: getfield 59	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:ItQ	Landroid/os/CancellationSignal;
      //   854: invokevirtual 310	android/os/CancellationSignal:throwIfCanceled	()V
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
      //   888: getfield 74	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:ItS	Ljava/util/Set;
      //   891: aload 10
      //   893: invokevirtual 129	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   896: invokeinterface 486 2 0
      //   901: ifeq +72 -> 973
      //   904: invokestatic 95	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:fmX	()Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$a;
      //   907: ldc 97
      //   909: ldc_w 488
      //   912: iconst_1
      //   913: anewarray 4	java/lang/Object
      //   916: dup
      //   917: iconst_0
      //   918: aload 10
      //   920: invokevirtual 129	java/io/File:getAbsolutePath	()Ljava/lang/String;
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
      //   959: getfield 37	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:ItO	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   962: invokestatic 349	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:f	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;)Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b;
      //   965: iload 4
      //   967: invokevirtual 472	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b:aaQ	(I)V
      //   970: goto +638 -> 1608
      //   973: new 125	java/io/File
      //   976: dup
      //   977: aload_0
      //   978: aload 10
      //   980: invokespecial 483	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:R	(Ljava/io/File;)Ljava/lang/String;
      //   983: invokespecial 204	java/io/File:<init>	(Ljava/lang/String;)V
      //   986: astore 11
      //   988: aload 10
      //   990: invokevirtual 129	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   993: aload 11
      //   995: invokevirtual 129	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   998: invokevirtual 332	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   1001: ifeq +31 -> 1032
      //   1004: invokestatic 95	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:fmX	()Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$a;
      //   1007: ldc 97
      //   1009: ldc_w 516
      //   1012: iconst_1
      //   1013: anewarray 4	java/lang/Object
      //   1016: dup
      //   1017: iconst_0
      //   1018: aload 10
      //   1020: invokevirtual 129	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   1023: aastore
      //   1024: invokeinterface 105 4 0
      //   1029: goto -100 -> 929
      //   1032: aload 10
      //   1034: invokevirtual 276	java/io/File:exists	()Z
      //   1037: ifeq +47 -> 1084
      //   1040: aload 11
      //   1042: invokevirtual 276	java/io/File:exists	()Z
      //   1045: ifeq +39 -> 1084
      //   1048: invokestatic 95	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:fmX	()Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$a;
      //   1051: ldc 97
      //   1053: ldc_w 518
      //   1056: iconst_2
      //   1057: anewarray 4	java/lang/Object
      //   1060: dup
      //   1061: iconst_0
      //   1062: aload 10
      //   1064: invokevirtual 129	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   1067: aastore
      //   1068: dup
      //   1069: iconst_1
      //   1070: aload 11
      //   1072: invokevirtual 129	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   1075: aastore
      //   1076: invokeinterface 105 4 0
      //   1081: goto -152 -> 929
      //   1084: iconst_0
      //   1085: istore 5
      //   1087: aload_0
      //   1088: getfield 66	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:Itp	Z
      //   1091: istore 6
      //   1093: iload 6
      //   1095: ifne +52 -> 1147
      //   1098: aload_0
      //   1099: getfield 59	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:ItQ	Landroid/os/CancellationSignal;
      //   1102: invokevirtual 310	android/os/CancellationSignal:throwIfCanceled	()V
      //   1105: aload 10
      //   1107: aload 11
      //   1109: invokevirtual 494	java/io/File:renameTo	(Ljava/io/File;)Z
      //   1112: istore 5
      //   1114: invokestatic 95	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:fmX	()Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$a;
      //   1117: ldc 97
      //   1119: ldc_w 496
      //   1122: iconst_2
      //   1123: anewarray 4	java/lang/Object
      //   1126: dup
      //   1127: iconst_0
      //   1128: aload 10
      //   1130: invokevirtual 129	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   1133: aastore
      //   1134: dup
      //   1135: iconst_1
      //   1136: aload 11
      //   1138: invokevirtual 129	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   1141: aastore
      //   1142: invokeinterface 326 4 0
      //   1147: iload 5
      //   1149: ifne -220 -> 929
      //   1152: aload_0
      //   1153: aload 10
      //   1155: aload 11
      //   1157: invokespecial 520	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:e	(Ljava/io/File;Ljava/io/File;)V
      //   1160: aload 10
      //   1162: invokevirtual 523	java/io/File:delete	()Z
      //   1165: ifne -236 -> 929
      //   1168: invokestatic 95	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:fmX	()Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$a;
      //   1171: ldc 97
      //   1173: ldc_w 525
      //   1176: iconst_1
      //   1177: anewarray 4	java/lang/Object
      //   1180: dup
      //   1181: iconst_0
      //   1182: aload 10
      //   1184: invokevirtual 129	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   1187: aastore
      //   1188: invokeinterface 105 4 0
      //   1193: goto -264 -> 929
      //   1196: aload 11
      //   1198: invokevirtual 276	java/io/File:exists	()Z
      //   1201: ifne +36 -> 1237
      //   1204: aload 11
      //   1206: invokevirtual 283	java/io/File:mkdirs	()Z
      //   1209: ifne +28 -> 1237
      //   1212: invokestatic 95	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:fmX	()Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$a;
      //   1215: ldc 97
      //   1217: ldc_w 527
      //   1220: iconst_1
      //   1221: anewarray 4	java/lang/Object
      //   1224: dup
      //   1225: iconst_0
      //   1226: aload 11
      //   1228: invokevirtual 129	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   1231: aastore
      //   1232: invokeinterface 529 4 0
      //   1237: aload_0
      //   1238: getfield 57	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:mProgress	F
      //   1241: fstore_1
      //   1242: aload_0
      //   1243: aload 10
      //   1245: getfield 499	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a$a:ItY	F
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
      //   1272: getfield 37	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:ItO	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   1275: invokestatic 349	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:f	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;)Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b;
      //   1278: iload_2
      //   1279: invokevirtual 472	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b:aaQ	(I)V
      //   1282: goto -783 -> 499
      //   1285: aload 7
      //   1287: invokeinterface 532 1 0
      //   1292: iconst_1
      //   1293: isub
      //   1294: istore_2
      //   1295: iload_2
      //   1296: iflt +67 -> 1363
      //   1299: aload_0
      //   1300: getfield 59	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:ItQ	Landroid/os/CancellationSignal;
      //   1303: invokevirtual 310	android/os/CancellationSignal:throwIfCanceled	()V
      //   1306: aload 7
      //   1308: iload_2
      //   1309: invokeinterface 534 2 0
      //   1314: checkcast 125	java/io/File
      //   1317: astore 8
      //   1319: aload 8
      //   1321: invokevirtual 276	java/io/File:exists	()Z
      //   1324: ifeq +299 -> 1623
      //   1327: aload 8
      //   1329: invokevirtual 523	java/io/File:delete	()Z
      //   1332: ifne +291 -> 1623
      //   1335: invokestatic 95	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:fmX	()Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$a;
      //   1338: ldc 97
      //   1340: ldc_w 536
      //   1343: iconst_1
      //   1344: anewarray 4	java/lang/Object
      //   1347: dup
      //   1348: iconst_0
      //   1349: aload 8
      //   1351: invokevirtual 129	java/io/File:getAbsolutePath	()Ljava/lang/String;
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
      //   1382: getfield 37	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:ItO	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   1385: invokestatic 349	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:f	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;)Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b;
      //   1388: bipush 100
      //   1390: invokevirtual 472	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b:aaQ	(I)V
      //   1393: aload_0
      //   1394: getfield 51	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:ItU	Ljava/lang/String;
      //   1397: invokestatic 550	com/tencent/mm/sdcard_migrate/b:aRo	(Ljava/lang/String;)V
      //   1400: aload_0
      //   1401: getfield 37	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:ItO	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   1404: invokestatic 349	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:f	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;)Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b;
      //   1407: astore 8
      //   1409: aload 8
      //   1411: iconst_1
      //   1412: invokevirtual 355	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b:wF	(Z)Landroid/support/v4/app/s$c;
      //   1415: invokestatic 556	java/lang/System:currentTimeMillis	()J
      //   1418: invokevirtual 559	android/support/v4/app/s$c:i	(J)Landroid/support/v4/app/s$c;
      //   1421: ldc_w 560
      //   1424: invokestatic 359	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:aaP	(I)Ljava/lang/String;
      //   1427: invokevirtual 365	android/support/v4/app/s$c:g	(Ljava/lang/CharSequence;)Landroid/support/v4/app/s$c;
      //   1430: iconst_0
      //   1431: iconst_0
      //   1432: iconst_0
      //   1433: invokevirtual 368	android/support/v4/app/s$c:b	(IIZ)Landroid/support/v4/app/s$c;
      //   1436: iconst_1
      //   1437: invokevirtual 562	android/support/v4/app/s$c:F	(Z)Landroid/support/v4/app/s$c;
      //   1440: astore 7
      //   1442: aload 7
      //   1444: aload 8
      //   1446: iconst_1
      //   1447: invokevirtual 382	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b:wG	(Z)Landroid/app/PendingIntent;
      //   1450: putfield 386	android/support/v4/app/s$c:Hl	Landroid/app/PendingIntent;
      //   1453: aload 7
      //   1455: iconst_2
      //   1456: iconst_0
      //   1457: invokevirtual 371	android/support/v4/app/s$c:f	(IZ)V
      //   1460: aload 8
      //   1462: getfield 387	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b:ItO	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   1465: aload 7
      //   1467: invokevirtual 399	android/support/v4/app/s$c:build	()Landroid/app/Notification;
      //   1470: invokestatic 565	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:a	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;Landroid/app/Notification;)V
      //   1473: aload 8
      //   1475: getfield 387	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b:ItO	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   1478: invokestatic 406	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:a	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;)[Lcom/tencent/mm/sdcard_migrate/MigrateResultCallback;
      //   1481: astore 7
      //   1483: aload 7
      //   1485: monitorenter
      //   1486: aload 8
      //   1488: getfield 387	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b:ItO	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
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
      //   1518: invokevirtual 568	com/tencent/mm/sdcard_migrate/MigrateResultCallback:fnw	()V
      //   1521: aload 7
      //   1523: monitorexit
      //   1524: aload_0
      //   1525: iconst_0
      //   1526: invokespecial 345	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:wE	(Z)V
      //   1529: invokestatic 446	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:fna	()V
      //   1532: aload_0
      //   1533: getfield 37	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:ItO	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   1536: invokestatic 448	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:i	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;)V
      //   1539: aload_0
      //   1540: getfield 37	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:ItO	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   1543: invokestatic 451	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:j	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;)V
      //   1546: ldc_w 340
      //   1549: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1552: return
      //   1553: astore 8
      //   1555: invokestatic 95	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:fmX	()Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$a;
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
      //   1593: getfield 37	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:ItO	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
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
      final File ItX;
      final float ItY;
      
      a(File paramFile, float paramFloat)
      {
        this.ItX = paramFile;
        this.ItY = paramFloat;
      }
    }
  }
  
  final class b
  {
    private final s.c[] Iua;
    private final int[] Iub;
    
    private b()
    {
      AppMethodBeat.i(186836);
      this.Iua = new s.c[] { null };
      this.Iub = new int[] { -1 };
      AppMethodBeat.o(186836);
    }
    
    final void aaQ(int paramInt)
    {
      AppMethodBeat.i(186840);
      synchronized (this.Iub)
      {
        if ((this.Iub[0] == -1) || ((paramInt != this.Iub[0]) && (paramInt % 10 == 0)))
        {
          s.c localc = wF(false).g(ExtStorageMigrateService.aaP(2131758664));
          localc.f(2, true);
          localc = localc.b(100, paramInt, false);
          ((NotificationManager)ExtStorageMigrateService.this.getSystemService("notification")).notify(1027, localc.build());
        }
        this.Iub[0] = paramInt;
      }
      synchronized (ExtStorageMigrateService.a(ExtStorageMigrateService.this))
      {
        a.b(ExtStorageMigrateService.a(ExtStorageMigrateService.this)[0], paramInt);
        AppMethodBeat.o(186840);
        return;
        localObject2 = finally;
        AppMethodBeat.o(186840);
        throw localObject2;
      }
    }
    
    final void aaR(int paramInt)
    {
      AppMethodBeat.i(186842);
      ??? = wF(true).i(System.currentTimeMillis()).g(ExtStorageMigrateService.aaP(2131758657)).b(0, 0, false).F(true);
      ((s.c)???).Hl = wG(true);
      ((s.c)???).f(2, false);
      ExtStorageMigrateService.a(ExtStorageMigrateService.this, ((s.c)???).build());
      synchronized (ExtStorageMigrateService.a(ExtStorageMigrateService.this))
      {
        a.a(ExtStorageMigrateService.a(ExtStorageMigrateService.this)[0], paramInt);
        AppMethodBeat.o(186842);
        return;
      }
    }
    
    final void c(int paramInt, Throwable paramThrowable)
    {
      AppMethodBeat.i(186841);
      s.c localc = wF(true).i(System.currentTimeMillis());
      if (paramInt == 6) {
        ??? = ExtStorageMigrateService.aaP(2131758661);
      }
      for (;;)
      {
        ??? = localc.g((CharSequence)???).b(0, 0, false).F(true);
        ((s.c)???).Hl = wG(true);
        ((s.c)???).f(2, false);
        ExtStorageMigrateService.a(ExtStorageMigrateService.this, ((s.c)???).build());
        synchronized (ExtStorageMigrateService.a(ExtStorageMigrateService.this))
        {
          a.a(ExtStorageMigrateService.a(ExtStorageMigrateService.this)[0], paramInt, paramThrowable);
          AppMethodBeat.o(186841);
          return;
          ??? = ExtStorageMigrateService.aaP(2131758659);
        }
      }
    }
    
    final s.a fnk()
    {
      AppMethodBeat.i(186838);
      Object localObject = new Intent(ExtStorageMigrateService.this, ExtStorageMigrateService.class);
      ((Intent)localObject).setAction("service_action_cancel_migrate");
      localObject = PendingIntent.getService(ExtStorageMigrateService.this, 3843, (Intent)localObject, 268435456);
      localObject = new s.a.a(2131233504, ExtStorageMigrateService.aaP(2131756766), (PendingIntent)localObject);
      ((s.a.a)localObject).GZ = false;
      localObject = ((s.a.a)localObject).eo();
      AppMethodBeat.o(186838);
      return localObject;
    }
    
    final s.c wF(boolean paramBoolean)
    {
      AppMethodBeat.i(186837);
      synchronized (this.Iua)
      {
        if ((this.Iua[0] != null) && (!paramBoolean))
        {
          localObject1 = this.Iua[0];
          AppMethodBeat.o(186837);
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
          localObject3 = new NotificationChannel("reminder_channel_id", ExtStorageMigrateService.this.getString(2131761709), 2);
          ((NotificationChannel)localObject3).setDescription(ExtStorageMigrateService.this.getString(2131761708));
          ((NotificationManager)localObject1).createNotificationChannel((NotificationChannel)localObject3);
        }
        label156:
        Object localObject1 = new s.c(ExtStorageMigrateService.this.getApplicationContext(), "reminder_channel_id");
        ((s.c)localObject1).f(ExtStorageMigrateService.aaP(2131755822)).as(2131233502).F(false);
        this.Iua[0] = localObject1;
        AppMethodBeat.o(186837);
        return localObject1;
      }
    }
    
    final PendingIntent wG(boolean paramBoolean)
    {
      AppMethodBeat.i(186839);
      Object localObject = new Intent(ExtStorageMigrateService.this, ExtStorageMigrateAuxActivity.class);
      ((Intent)localObject).setAction("auxui_action_do_migrate_routine");
      ((Intent)localObject).putExtra("auxui_param_is_migration_end", paramBoolean);
      ((Intent)localObject).addFlags(268435456);
      localObject = PendingIntent.getActivity(ExtStorageMigrateService.this, 3841, (Intent)localObject, 268435456);
      AppMethodBeat.o(186839);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sdcard_migrate.ExtStorageMigrateService
 * JD-Core Version:    0.7.0.1
 */