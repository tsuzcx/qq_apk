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
  private final b GnL;
  private final a[] GnM;
  private Thread GnN;
  private final MigrateResultCallback[] GnO;
  private volatile int GnP;
  private final boolean[] GnQ;
  private final PowerManager.WakeLock[] GnR;
  private final boolean[] GnS;
  private final e.a GnT;
  
  public ExtStorageMigrateService()
  {
    AppMethodBeat.i(169829);
    this.GnL = new b((byte)0);
    this.GnM = new a[] { null };
    this.GnN = null;
    this.GnO = new MigrateResultCallback[] { null };
    this.GnP = 0;
    this.GnQ = new boolean[] { false };
    this.GnR = new PowerManager.WakeLock[] { null };
    this.GnS = new boolean[] { false };
    this.GnT = new e.a()
    {
      public final void a(ExtStorageMigrateConfig paramAnonymousExtStorageMigrateConfig)
      {
        AppMethodBeat.i(196204);
        ExtStorageMigrateService.a(ExtStorageMigrateService.this, paramAnonymousExtStorageMigrateConfig);
        AppMethodBeat.o(196204);
      }
      
      public final void a(MigrateResultCallback paramAnonymousMigrateResultCallback)
      {
        AppMethodBeat.i(196202);
        synchronized (ExtStorageMigrateService.a(ExtStorageMigrateService.this))
        {
          if ((ExtStorageMigrateService.a(ExtStorageMigrateService.this)[0] != null) && (ExtStorageMigrateService.a(ExtStorageMigrateService.this)[0] != paramAnonymousMigrateResultCallback)) {
            ExtStorageMigrateService.a(ExtStorageMigrateService.this)[0].jh(ExtStorageMigrateService.c(ExtStorageMigrateService.this), Binder.getCallingPid());
          }
          ExtStorageMigrateService.a(ExtStorageMigrateService.this)[0] = paramAnonymousMigrateResultCallback;
          if (!eTK()) {
            break label147;
          }
        }
        synchronized (ExtStorageMigrateService.b(ExtStorageMigrateService.this))
        {
          paramAnonymousMigrateResultCallback.lj(ExtStorageMigrateService.a.c(ExtStorageMigrateService.b(ExtStorageMigrateService.this)[0]), ExtStorageMigrateService.a.d(ExtStorageMigrateService.b(ExtStorageMigrateService.this)[0]));
          AppMethodBeat.o(196202);
          return;
          paramAnonymousMigrateResultCallback = finally;
          AppMethodBeat.o(196202);
          throw paramAnonymousMigrateResultCallback;
        }
        label147:
        AppMethodBeat.o(196202);
      }
      
      public final void b(MigrateResultCallback arg1)
      {
        AppMethodBeat.i(196203);
        synchronized (ExtStorageMigrateService.a(ExtStorageMigrateService.this))
        {
          if (ExtStorageMigrateService.a(ExtStorageMigrateService.this)[0] != null) {
            ExtStorageMigrateService.a(ExtStorageMigrateService.this)[0] = null;
          }
          AppMethodBeat.o(196203);
          return;
        }
      }
      
      public final boolean eTK()
      {
        AppMethodBeat.i(196201);
        if ((ExtStorageMigrateService.b(ExtStorageMigrateService.this)[0] != null) && (ExtStorageMigrateService.a.b(ExtStorageMigrateService.b(ExtStorageMigrateService.this)[0])))
        {
          AppMethodBeat.o(196201);
          return true;
        }
        AppMethodBeat.o(196201);
        return false;
      }
      
      public final void eTO()
      {
        AppMethodBeat.i(196205);
        ExtStorageMigrateService.d(ExtStorageMigrateService.this);
        AppMethodBeat.o(196205);
      }
    };
    AppMethodBeat.o(169829);
  }
  
  private static String Jk(String paramString)
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
      ExtStorageMigrateMonitor.eTC().printErrStackTrace("MicroMsg.ExtStorageMigrateService", localThrowable, "[-] Fail to get canonical path for: %s", new Object[] { paramString });
      paramString = new File(paramString).getAbsolutePath();
      AppMethodBeat.o(169831);
    }
    return paramString;
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
    catch (Throwable localThrowable)
    {
      ExtStorageMigrateMonitor.eTC().printErrStackTrace("MicroMsg.ExtStorageMigrateService", localThrowable, "[-] Fail to get canonical file for: %s", new Object[] { paramFile.getAbsolutePath() });
      paramFile = paramFile.getAbsoluteFile();
      AppMethodBeat.o(169830);
    }
    return paramFile;
  }
  
  private boolean eTK()
  {
    boolean bool2 = false;
    AppMethodBeat.i(196218);
    a[] arrayOfa = this.GnM;
    boolean bool1 = bool2;
    try
    {
      if (this.GnM[0] != null)
      {
        bool1 = bool2;
        if (a.b(this.GnM[0])) {
          bool1 = true;
        }
      }
      return bool1;
    }
    finally
    {
      AppMethodBeat.o(196218);
    }
  }
  
  private boolean eTL()
  {
    synchronized (this.GnQ)
    {
      int i = this.GnQ[0];
      return i;
    }
  }
  
  private boolean eTM()
  {
    synchronized (this.GnS)
    {
      int i = this.GnS[0];
      return i;
    }
  }
  
  private void eTN()
  {
    AppMethodBeat.i(196219);
    ExtStorageMigrateMonitor.eTC().i("MicroMsg.ExtStorageMigrateService", "[+] expectedStopSelf called.", new Object[0]);
    vJ(true);
    stopSelf();
    AppMethodBeat.o(196219);
  }
  
  private void releaseWakeLock()
  {
    AppMethodBeat.i(196220);
    synchronized (this.GnR)
    {
      if ((this.GnR[0] != null) && (this.GnR[0].isHeld()))
      {
        this.GnR[0].release();
        this.GnR[0] = null;
        ExtStorageMigrateMonitor.eTC().i("MicroMsg.ExtStorageMigrateService", "[+] WakeLock released.", new Object[0]);
      }
      AppMethodBeat.o(196220);
      return;
    }
  }
  
  private void vI(boolean paramBoolean)
  {
    synchronized (this.GnQ)
    {
      this.GnQ[0] = paramBoolean;
      return;
    }
  }
  
  private void vJ(boolean paramBoolean)
  {
    synchronized (this.GnS)
    {
      this.GnS[0] = paramBoolean;
      return;
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    AppMethodBeat.i(196217);
    paramIntent = this.GnT.asBinder();
    AppMethodBeat.o(196217);
    return paramIntent;
  }
  
  public void onCreate()
  {
    AppMethodBeat.i(196216);
    super.onCreate();
    synchronized (this.GnM)
    {
      this.GnM[0] = null;
      this.GnN = null;
    }
    synchronized (this.GnO)
    {
      this.GnO[0] = null;
      this.GnP = 0;
      vI(false);
      AppMethodBeat.o(196216);
      return;
      localObject2 = finally;
      AppMethodBeat.o(196216);
      throw localObject2;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(169833);
    ExtStorageMigrateMonitor.eTC().i("MicroMsg.ExtStorageMigrateService", "[+] OnDestroy called.", new Object[0]);
    synchronized (this.GnM)
    {
      if (eTK()) {
        a.a(this.GnM[0]);
      }
    }
    try
    {
      this.GnN.join();
      for (;;)
      {
        label53:
        this.GnM[0] = null;
        if (eTL()) {
          stopForeground(true);
        }
        releaseWakeLock();
        AppMethodBeat.o(169833);
        return;
        if (eTL()) {
          if (eTM())
          {
            vJ(false);
            this.GnL.Yg(2);
            continue;
            localObject = finally;
            AppMethodBeat.o(169833);
            throw localObject;
          }
          else
          {
            this.GnL.c(6, null);
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
    ExtStorageMigrateMonitor.eTC().i("MicroMsg.ExtStorageMigrateService", "[+] OnStartCommand called, intent: %s", new Object[] { paramIntent });
    if (paramIntent == null) {
      ExtStorageMigrateMonitor.eTC().e("MicroMsg.ExtStorageMigrateService", "[-] intent is null, skip rest logic.", new Object[0]);
    }
    for (;;)
    {
      AppMethodBeat.o(169832);
      return 1;
      paramIntent = paramIntent.getAction();
      if (paramIntent == null)
      {
        ExtStorageMigrateMonitor.eTC().e("MicroMsg.ExtStorageMigrateService", "[-] action is null, skip rest logic.", new Object[0]);
      }
      else if ("service_action_startup".equals(paramIntent))
      {
        Object localObject = this.GnL;
        if ((((b)localObject).GnU.eTL()) || (((b)localObject).GnU.eTK()))
        {
          ExtStorageMigrateMonitor.eTC().w("MicroMsg.ExtStorageMigrateService", "[!] Already on foreground or migrating logic, skip startup steps.", new Object[0]);
        }
        else
        {
          paramIntent = ((b)localObject).vL(true);
          s.c localc = paramIntent.i(System.currentTimeMillis()).g(((b)localObject).GnU.getString(2131758667)).b(0, 0, true);
          localc.f(2, true);
          localc.a(((b)localObject).eTP()).Fu = ((b)localObject).vM(false);
          localObject = ((b)localObject).GnU;
          ((ExtStorageMigrateService)localObject).startForeground(1027, paramIntent.build());
          ((ExtStorageMigrateService)localObject).vI(true);
        }
      }
      else if ("service_action_cancel_migrate".equals(paramIntent))
      {
        eTN();
      }
      else
      {
        ExtStorageMigrateMonitor.eTC().e("MicroMsg.ExtStorageMigrateService", "[-] Unknown action: %s", new Object[] { paramIntent });
      }
    }
  }
  
  final class a
    implements Runnable
  {
    private final boolean[] GnV;
    private final CancellationSignal GnW;
    private final Set<String> GnX;
    private final Set<String> GnY;
    private final Map<String, String> GnZ;
    private final boolean Gnv;
    private String Goa;
    private String Gob;
    private ByteBuffer Goc;
    private float aaZ;
    
    a(ExtStorageMigrateConfig paramExtStorageMigrateConfig, CancellationSignal paramCancellationSignal)
    {
      AppMethodBeat.i(196206);
      this.GnV = new boolean[] { false };
      this.Goa = null;
      this.Gob = null;
      this.Goc = null;
      this.aaZ = 0.0F;
      this.GnW = paramCancellationSignal;
      this.Gnv = paramExtStorageMigrateConfig.Gnq;
      this.GnX = new HashSet(64);
      this.GnY = new HashSet(5);
      this.GnZ = new HashMap(5);
      this.Goa = ExtStorageMigrateService.aKi(paramExtStorageMigrateConfig.sourceDir);
      this.Gob = ExtStorageMigrateService.aKi(paramExtStorageMigrateConfig.Gnp);
      if (paramExtStorageMigrateConfig.Gnq) {
        ExtStorageMigrateMonitor.eTC().w("MicroMsg.ExtStorageMigrateService", "[!] Force copy mode enabled, are we under test mode ??", new Object[0]);
      }
      a(paramExtStorageMigrateConfig.sourceDir, paramExtStorageMigrateConfig.Gnr);
      ExtStorageMigrateMonitor.eTC().i("MicroMsg.ExtStorageMigrateService", "[+] MigrateTask, pass in config: %s", new Object[] { paramExtStorageMigrateConfig });
      AppMethodBeat.o(196206);
    }
    
    private String P(File paramFile)
    {
      AppMethodBeat.i(169821);
      paramFile = aKk(paramFile.getAbsolutePath().substring(this.Goa.length()));
      if (paramFile.startsWith("/")) {
        paramFile = paramFile.substring(1);
      }
      for (;;)
      {
        ExtStorageMigrateMonitor.eTC().i("MicroMsg.ExtStorageMigrateService", "[+] getMigratedFilePath, relSrcPath: %s", new Object[] { paramFile });
        Object localObject2;
        label182:
        int i;
        for (Object localObject1 = paramFile;; localObject1 = ((String)localObject1).substring(0, i))
        {
          localObject2 = paramFile;
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject2 = (String)this.GnZ.get(localObject1);
            ExtStorageMigrateMonitor.eTC().i("MicroMsg.ExtStorageMigrateService", "[+] getMigratedFilePath, currRelSrcPath: %s, newRelPath: %s", new Object[] { localObject1, localObject2 });
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
            ExtStorageMigrateMonitor.eTC().i("MicroMsg.ExtStorageMigrateService", "[+] getMigratedFilePath, result: %s", new Object[] { localObject2 });
            AppMethodBeat.o(169821);
            return localObject2;
            i = ((String)localObject1).lastIndexOf('/');
            localObject2 = paramFile;
          } while (i < 0);
        }
        paramFile = this.Gob + "/" + (String)localObject2;
        ExtStorageMigrateMonitor.eTC().i("MicroMsg.ExtStorageMigrateService", "[+] getMigratedFilePath, result: %s", new Object[] { paramFile });
        AppMethodBeat.o(169821);
        return paramFile;
      }
    }
    
    private void a(String paramString, Collection<ExtStorageMigrateConfig.ExtraPathAction> paramCollection)
    {
      AppMethodBeat.i(196207);
      if (paramCollection == null)
      {
        AppMethodBeat.o(196207);
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
          localObject = ExtStorageMigrateService.O(new File(paramString, paramCollection.Gnx));
          this.GnY.add(((File)localObject).getAbsolutePath());
          li(paramString, paramCollection.Gnx);
        }
        else if ((paramCollection instanceof ExtStorageMigrateConfig.ExtraPathAction.Remap))
        {
          localObject = (ExtStorageMigrateConfig.ExtraPathAction.Remap)paramCollection;
          Map localMap = this.GnZ;
          String str = aKk(((ExtStorageMigrateConfig.ExtraPathAction.Remap)localObject).Gny);
          if (((ExtStorageMigrateConfig.ExtraPathAction.Remap)localObject).iah.startsWith("/")) {}
          for (paramCollection = ((ExtStorageMigrateConfig.ExtraPathAction.Remap)localObject).iah;; paramCollection = aKk(((ExtStorageMigrateConfig.ExtraPathAction.Remap)localObject).iah))
          {
            localMap.put(str, paramCollection);
            li(paramString, ((ExtStorageMigrateConfig.ExtraPathAction.Remap)localObject).Gny);
            break;
          }
        }
      }
      this.GnX.add(paramString);
      ExtStorageMigrateMonitor.eTC().i("MicroMsg.ExtStorageMigrateService", "[+] MigrateTask, mSrcDirPath: %s, mDestDirPath: %s, mRemappedRelPaths: %s", new Object[] { this.Goa, this.Gob, this.GnZ });
      AppMethodBeat.o(196207);
    }
    
    private static String aKj(String paramString)
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
    
    private static String aKk(String paramString)
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
      //   75: getfield 59	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:GnW	Landroid/os/CancellationSignal;
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
      //   98: invokestatic 322	com/tencent/mm/vfs/q:closeQuietly	(Ljava/io/Closeable;)V
      //   101: aload 4
      //   103: invokestatic 322	com/tencent/mm/vfs/q:closeQuietly	(Ljava/io/Closeable;)V
      //   106: ldc_w 273
      //   109: invokestatic 118	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   112: aload_1
      //   113: athrow
      //   114: invokestatic 95	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:eTC	()Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$a;
      //   117: ldc 97
      //   119: ldc_w 324
      //   122: iconst_2
      //   123: anewarray 4	java/lang/Object
      //   126: dup
      //   127: iconst_0
      //   128: aload_1
      //   129: invokevirtual 128	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   132: aastore
      //   133: dup
      //   134: iconst_1
      //   135: aload_2
      //   136: invokevirtual 128	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   139: aastore
      //   140: invokeinterface 326 4 0
      //   145: aload 5
      //   147: invokestatic 322	com/tencent/mm/vfs/q:closeQuietly	(Ljava/io/Closeable;)V
      //   150: aload 4
      //   152: invokestatic 322	com/tencent/mm/vfs/q:closeQuietly	(Ljava/io/Closeable;)V
      //   155: ldc_w 273
      //   158: invokestatic 118	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
      synchronized (this.GnV)
      {
        int i = this.GnV[0];
        return i;
      }
    }
    
    private void li(String paramString1, String paramString2)
    {
      AppMethodBeat.i(169816);
      String str = aKj(paramString1);
      paramString1 = new File(str, paramString2);
      do
      {
        this.GnX.add(aKj(paramString1.getAbsolutePath()));
        paramString2 = paramString1.getParentFile();
        if (paramString2 == null) {
          break;
        }
        paramString1 = paramString2;
      } while (!str.equals(paramString2.getAbsolutePath()));
      AppMethodBeat.o(169816);
    }
    
    private void vK(boolean paramBoolean)
    {
      synchronized (this.GnV)
      {
        this.GnV[0] = paramBoolean;
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
      //   7: getfield 37	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:GnU	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   10: invokestatic 343	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:e	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;)V
      //   13: aload_0
      //   14: iconst_1
      //   15: invokespecial 345	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:vK	(Z)V
      //   18: aload_0
      //   19: getfield 37	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:GnU	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   22: invokestatic 349	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:f	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;)Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b;
      //   25: astore 10
      //   27: aload_0
      //   28: getfield 51	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:Goa	Ljava/lang/String;
      //   31: astore 7
      //   33: aload_0
      //   34: getfield 53	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:Gob	Ljava/lang/String;
      //   37: astore 8
      //   39: aload 10
      //   41: iconst_1
      //   42: invokevirtual 355	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b:vL	(Z)Landroid/support/v4/app/s$c;
      //   45: aload 10
      //   47: getfield 356	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b:GnU	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   50: ldc_w 357
      //   53: invokevirtual 360	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:getString	(I)Ljava/lang/String;
      //   56: invokevirtual 366	android/support/v4/app/s$c:g	(Ljava/lang/CharSequence;)Landroid/support/v4/app/s$c;
      //   59: bipush 100
      //   61: iconst_0
      //   62: iconst_0
      //   63: invokevirtual 369	android/support/v4/app/s$c:b	(IIZ)Landroid/support/v4/app/s$c;
      //   66: astore 9
      //   68: aload 9
      //   70: iconst_2
      //   71: iconst_1
      //   72: invokevirtual 372	android/support/v4/app/s$c:f	(IZ)V
      //   75: aload 9
      //   77: aload 10
      //   79: invokevirtual 376	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b:eTP	()Landroid/support/v4/app/s$a;
      //   82: invokevirtual 379	android/support/v4/app/s$c:a	(Landroid/support/v4/app/s$a;)Landroid/support/v4/app/s$c;
      //   85: astore 9
      //   87: aload 9
      //   89: aload 10
      //   91: iconst_0
      //   92: invokevirtual 383	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b:vM	(Z)Landroid/app/PendingIntent;
      //   95: putfield 387	android/support/v4/app/s$c:Fu	Landroid/app/PendingIntent;
      //   98: aload 10
      //   100: getfield 356	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b:GnU	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   103: ldc_w 389
      //   106: invokevirtual 393	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
      //   109: checkcast 395	android/app/NotificationManager
      //   112: sipush 1027
      //   115: aload 9
      //   117: invokevirtual 399	android/support/v4/app/s$c:build	()Landroid/app/Notification;
      //   120: invokevirtual 403	android/app/NotificationManager:notify	(ILandroid/app/Notification;)V
      //   123: aload 10
      //   125: getfield 356	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b:GnU	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   128: invokestatic 406	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:a	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;)[Lcom/tencent/mm/sdcard_migrate/MigrateResultCallback;
      //   131: astore 9
      //   133: aload 9
      //   135: monitorenter
      //   136: aload 10
      //   138: getfield 356	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b:GnU	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   141: invokestatic 406	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:a	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;)[Lcom/tencent/mm/sdcard_migrate/MigrateResultCallback;
      //   144: iconst_0
      //   145: aaload
      //   146: astore 10
      //   148: aload 10
      //   150: ifnull +25 -> 175
      //   153: aload 10
      //   155: invokevirtual 412	com/tencent/mm/sdcard_migrate/MigrateResultCallback:asBinder	()Landroid/os/IBinder;
      //   158: invokeinterface 417 1 0
      //   163: ifeq +12 -> 175
      //   166: aload 10
      //   168: aload 7
      //   170: aload 8
      //   172: invokevirtual 420	com/tencent/mm/sdcard_migrate/MigrateResultCallback:lj	(Ljava/lang/String;Ljava/lang/String;)V
      //   175: aload 9
      //   177: monitorexit
      //   178: aload_0
      //   179: getfield 51	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:Goa	Ljava/lang/String;
      //   182: aload_0
      //   183: getfield 53	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:Gob	Ljava/lang/String;
      //   186: invokevirtual 332	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   189: ifne +1209 -> 1398
      //   192: new 124	java/io/File
      //   195: dup
      //   196: aload_0
      //   197: getfield 51	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:Goa	Ljava/lang/String;
      //   200: invokespecial 258	java/io/File:<init>	(Ljava/lang/String;)V
      //   203: astore 9
      //   205: aload 9
      //   207: invokevirtual 276	java/io/File:exists	()Z
      //   210: ifeq +1188 -> 1398
      //   213: aload 9
      //   215: invokevirtual 423	java/io/File:canRead	()Z
      //   218: ifne +225 -> 443
      //   221: new 425	java/io/IOException
      //   224: dup
      //   225: new 165	java/lang/StringBuilder
      //   228: dup
      //   229: invokespecial 166	java/lang/StringBuilder:<init>	()V
      //   232: aload 9
      //   234: invokevirtual 128	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   237: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   240: ldc_w 427
      //   243: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   246: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   249: invokespecial 428	java/io/IOException:<init>	(Ljava/lang/String;)V
      //   252: astore 7
      //   254: ldc_w 340
      //   257: invokestatic 118	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   260: aload 7
      //   262: athrow
      //   263: astore 7
      //   265: invokestatic 95	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:eTC	()Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$a;
      //   268: ldc 97
      //   270: aload 7
      //   272: ldc_w 430
      //   275: iconst_0
      //   276: anewarray 4	java/lang/Object
      //   279: invokeinterface 434 5 0
      //   284: aload_0
      //   285: getfield 37	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:GnU	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   288: invokestatic 437	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:g	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;)Z
      //   291: ifeq +1311 -> 1602
      //   294: aload_0
      //   295: getfield 37	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:GnU	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   298: invokestatic 440	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:h	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;)V
      //   301: aload_0
      //   302: getfield 37	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:GnU	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   305: invokestatic 349	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:f	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;)Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b;
      //   308: iconst_3
      //   309: invokevirtual 443	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b:Yg	(I)V
      //   312: aload_0
      //   313: iconst_0
      //   314: invokespecial 345	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:vK	(Z)V
      //   317: invokestatic 446	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:eTF	()V
      //   320: aload_0
      //   321: getfield 37	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:GnU	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   324: invokestatic 448	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:i	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;)V
      //   327: aload_0
      //   328: getfield 37	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:GnU	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   331: invokestatic 451	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:j	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;)V
      //   334: ldc_w 340
      //   337: invokestatic 118	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   340: return
      //   341: astore 7
      //   343: invokestatic 95	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:eTC	()Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$a;
      //   346: ldc_w 453
      //   349: aload 7
      //   351: ldc_w 455
      //   354: iconst_0
      //   355: anewarray 4	java/lang/Object
      //   358: invokeinterface 434 5 0
      //   363: goto -188 -> 175
      //   366: astore 7
      //   368: aload 9
      //   370: monitorexit
      //   371: ldc_w 340
      //   374: invokestatic 118	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   377: aload 7
      //   379: athrow
      //   380: astore 7
      //   382: invokestatic 95	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:eTC	()Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$a;
      //   385: ldc 97
      //   387: aload 7
      //   389: ldc_w 457
      //   392: iconst_0
      //   393: anewarray 4	java/lang/Object
      //   396: invokeinterface 434 5 0
      //   401: aload_0
      //   402: getfield 37	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:GnU	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   405: invokestatic 349	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:f	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;)Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b;
      //   408: iconst_5
      //   409: aload 7
      //   411: invokevirtual 460	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b:c	(ILjava/lang/Throwable;)V
      //   414: aload_0
      //   415: iconst_0
      //   416: invokespecial 345	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:vK	(Z)V
      //   419: invokestatic 446	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:eTF	()V
      //   422: aload_0
      //   423: getfield 37	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:GnU	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   426: invokestatic 448	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:i	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;)V
      //   429: aload_0
      //   430: getfield 37	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:GnU	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   433: invokestatic 451	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:j	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;)V
      //   436: ldc_w 340
      //   439: invokestatic 118	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   442: return
      //   443: new 462	java/util/ArrayList
      //   446: dup
      //   447: bipush 20
      //   449: invokespecial 463	java/util/ArrayList:<init>	(I)V
      //   452: astore 8
      //   454: new 462	java/util/ArrayList
      //   457: dup
      //   458: bipush 64
      //   460: invokespecial 463	java/util/ArrayList:<init>	(I)V
      //   463: astore 7
      //   465: aload 8
      //   467: new 11	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a$a
      //   470: dup
      //   471: aload_0
      //   472: aload 9
      //   474: fconst_1
      //   475: invokespecial 466	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a$a:<init>	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a;Ljava/io/File;F)V
      //   478: invokeinterface 469 2 0
      //   483: pop
      //   484: aload_0
      //   485: fconst_0
      //   486: putfield 57	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:aaZ	F
      //   489: aload_0
      //   490: getfield 37	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:GnU	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   493: invokestatic 349	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:f	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;)Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b;
      //   496: aload_0
      //   497: getfield 57	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:aaZ	F
      //   500: f2i
      //   501: invokevirtual 472	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b:Yf	(I)V
      //   504: aload 8
      //   506: invokeinterface 473 1 0
      //   511: ifne +779 -> 1290
      //   514: aload_0
      //   515: getfield 59	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:GnW	Landroid/os/CancellationSignal;
      //   518: invokevirtual 310	android/os/CancellationSignal:throwIfCanceled	()V
      //   521: aload 8
      //   523: iconst_0
      //   524: invokeinterface 477 2 0
      //   529: checkcast 11	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a$a
      //   532: astore 10
      //   534: aload 10
      //   536: getfield 481	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a$a:God	Ljava/io/File;
      //   539: astore 9
      //   541: new 124	java/io/File
      //   544: dup
      //   545: aload_0
      //   546: aload 9
      //   548: invokespecial 483	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:P	(Ljava/io/File;)Ljava/lang/String;
      //   551: invokespecial 258	java/io/File:<init>	(Ljava/lang/String;)V
      //   554: astore 11
      //   556: aload_0
      //   557: getfield 74	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:GnY	Ljava/util/Set;
      //   560: aload 9
      //   562: invokevirtual 128	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   565: invokestatic 329	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:aKj	(Ljava/lang/String;)Ljava/lang/String;
      //   568: invokeinterface 486 2 0
      //   573: ifeq +64 -> 637
      //   576: invokestatic 95	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:eTC	()Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$a;
      //   579: ldc 97
      //   581: ldc_w 488
      //   584: iconst_1
      //   585: anewarray 4	java/lang/Object
      //   588: dup
      //   589: iconst_0
      //   590: aload 9
      //   592: invokevirtual 128	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   595: aastore
      //   596: invokeinterface 105 4 0
      //   601: goto -97 -> 504
      //   604: astore 7
      //   606: aload_0
      //   607: iconst_0
      //   608: invokespecial 345	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:vK	(Z)V
      //   611: invokestatic 446	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:eTF	()V
      //   614: aload_0
      //   615: getfield 37	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:GnU	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   618: invokestatic 448	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:i	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;)V
      //   621: aload_0
      //   622: getfield 37	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:GnU	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   625: invokestatic 451	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:j	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;)V
      //   628: ldc_w 340
      //   631: invokestatic 118	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   634: aload 7
      //   636: athrow
      //   637: invokestatic 95	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:eTC	()Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$a;
      //   640: ldc 97
      //   642: ldc_w 490
      //   645: iconst_2
      //   646: anewarray 4	java/lang/Object
      //   649: dup
      //   650: iconst_0
      //   651: aload 9
      //   653: invokevirtual 128	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   656: aastore
      //   657: dup
      //   658: iconst_1
      //   659: aload 11
      //   661: invokevirtual 128	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   664: aastore
      //   665: invokeinterface 115 4 0
      //   670: aload_0
      //   671: getfield 66	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:Gnv	Z
      //   674: ifne +118 -> 792
      //   677: aload_0
      //   678: getfield 72	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:GnX	Ljava/util/Set;
      //   681: aload 9
      //   683: invokevirtual 128	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   686: invokestatic 329	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:aKj	(Ljava/lang/String;)Ljava/lang/String;
      //   689: invokeinterface 486 2 0
      //   694: istore 5
      //   696: iload 5
      //   698: ifne +94 -> 792
      //   701: aload 9
      //   703: aload 11
      //   705: invokevirtual 494	java/io/File:renameTo	(Ljava/io/File;)Z
      //   708: ifeq +84 -> 792
      //   711: invokestatic 95	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:eTC	()Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$a;
      //   714: ldc 97
      //   716: ldc_w 496
      //   719: iconst_2
      //   720: anewarray 4	java/lang/Object
      //   723: dup
      //   724: iconst_0
      //   725: aload 9
      //   727: invokevirtual 128	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   730: aastore
      //   731: dup
      //   732: iconst_1
      //   733: aload 11
      //   735: invokevirtual 128	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   738: aastore
      //   739: invokeinterface 326 4 0
      //   744: aload_0
      //   745: aload_0
      //   746: getfield 57	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:aaZ	F
      //   749: aload 10
      //   751: getfield 499	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a$a:Goe	F
      //   754: fadd
      //   755: putfield 57	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:aaZ	F
      //   758: aload_0
      //   759: getfield 57	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:aaZ	F
      //   762: ldc_w 500
      //   765: fmul
      //   766: ldc_w 501
      //   769: fmul
      //   770: f2d
      //   771: invokestatic 507	java/lang/Math:floor	(D)D
      //   774: d2i
      //   775: istore_2
      //   776: aload_0
      //   777: getfield 37	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:GnU	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   780: invokestatic 349	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:f	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;)Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b;
      //   783: iload_2
      //   784: invokevirtual 472	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b:Yf	(I)V
      //   787: goto -283 -> 504
      //   790: astore 12
      //   792: aload_0
      //   793: getfield 59	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:GnW	Landroid/os/CancellationSignal;
      //   796: invokevirtual 310	android/os/CancellationSignal:throwIfCanceled	()V
      //   799: aload 7
      //   801: aload 9
      //   803: invokeinterface 469 2 0
      //   808: pop
      //   809: aload 9
      //   811: invokevirtual 511	java/io/File:listFiles	()[Ljava/io/File;
      //   814: astore 9
      //   816: aload 9
      //   818: ifnull +383 -> 1201
      //   821: aload 9
      //   823: arraylength
      //   824: ifeq +377 -> 1201
      //   827: aload 10
      //   829: getfield 499	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a$a:Goe	F
      //   832: aload 9
      //   834: arraylength
      //   835: i2f
      //   836: fdiv
      //   837: fstore_1
      //   838: aload 9
      //   840: arraylength
      //   841: istore_3
      //   842: iconst_0
      //   843: istore_2
      //   844: iload_2
      //   845: iload_3
      //   846: if_icmpge -342 -> 504
      //   849: aload 9
      //   851: iload_2
      //   852: aaload
      //   853: astore 10
      //   855: aload_0
      //   856: getfield 59	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:GnW	Landroid/os/CancellationSignal;
      //   859: invokevirtual 310	android/os/CancellationSignal:throwIfCanceled	()V
      //   862: aload 10
      //   864: invokevirtual 514	java/io/File:isDirectory	()Z
      //   867: ifeq +25 -> 892
      //   870: aload 8
      //   872: new 11	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a$a
      //   875: dup
      //   876: aload_0
      //   877: aload 10
      //   879: fload_1
      //   880: invokespecial 466	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a$a:<init>	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a;Ljava/io/File;F)V
      //   883: invokeinterface 469 2 0
      //   888: pop
      //   889: goto +729 -> 1618
      //   892: aload_0
      //   893: getfield 74	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:GnY	Ljava/util/Set;
      //   896: aload 10
      //   898: invokevirtual 128	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   901: invokeinterface 486 2 0
      //   906: ifeq +72 -> 978
      //   909: invokestatic 95	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:eTC	()Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$a;
      //   912: ldc 97
      //   914: ldc_w 488
      //   917: iconst_1
      //   918: anewarray 4	java/lang/Object
      //   921: dup
      //   922: iconst_0
      //   923: aload 10
      //   925: invokevirtual 128	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   928: aastore
      //   929: invokeinterface 105 4 0
      //   934: aload_0
      //   935: aload_0
      //   936: getfield 57	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:aaZ	F
      //   939: fload_1
      //   940: fadd
      //   941: putfield 57	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:aaZ	F
      //   944: aload_0
      //   945: getfield 57	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:aaZ	F
      //   948: ldc_w 500
      //   951: fmul
      //   952: ldc_w 501
      //   955: fmul
      //   956: f2d
      //   957: invokestatic 507	java/lang/Math:floor	(D)D
      //   960: d2i
      //   961: istore 4
      //   963: aload_0
      //   964: getfield 37	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:GnU	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   967: invokestatic 349	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:f	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;)Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b;
      //   970: iload 4
      //   972: invokevirtual 472	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b:Yf	(I)V
      //   975: goto +643 -> 1618
      //   978: new 124	java/io/File
      //   981: dup
      //   982: aload_0
      //   983: aload 10
      //   985: invokespecial 483	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:P	(Ljava/io/File;)Ljava/lang/String;
      //   988: invokespecial 258	java/io/File:<init>	(Ljava/lang/String;)V
      //   991: astore 11
      //   993: aload 10
      //   995: invokevirtual 128	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   998: aload 11
      //   1000: invokevirtual 128	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   1003: invokevirtual 332	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   1006: ifeq +31 -> 1037
      //   1009: invokestatic 95	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:eTC	()Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$a;
      //   1012: ldc 97
      //   1014: ldc_w 516
      //   1017: iconst_1
      //   1018: anewarray 4	java/lang/Object
      //   1021: dup
      //   1022: iconst_0
      //   1023: aload 10
      //   1025: invokevirtual 128	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   1028: aastore
      //   1029: invokeinterface 105 4 0
      //   1034: goto -100 -> 934
      //   1037: aload 10
      //   1039: invokevirtual 276	java/io/File:exists	()Z
      //   1042: ifeq +47 -> 1089
      //   1045: aload 11
      //   1047: invokevirtual 276	java/io/File:exists	()Z
      //   1050: ifeq +39 -> 1089
      //   1053: invokestatic 95	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:eTC	()Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$a;
      //   1056: ldc 97
      //   1058: ldc_w 518
      //   1061: iconst_2
      //   1062: anewarray 4	java/lang/Object
      //   1065: dup
      //   1066: iconst_0
      //   1067: aload 10
      //   1069: invokevirtual 128	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   1072: aastore
      //   1073: dup
      //   1074: iconst_1
      //   1075: aload 11
      //   1077: invokevirtual 128	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   1080: aastore
      //   1081: invokeinterface 105 4 0
      //   1086: goto -152 -> 934
      //   1089: iconst_0
      //   1090: istore 5
      //   1092: aload_0
      //   1093: getfield 66	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:Gnv	Z
      //   1096: istore 6
      //   1098: iload 6
      //   1100: ifne +52 -> 1152
      //   1103: aload_0
      //   1104: getfield 59	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:GnW	Landroid/os/CancellationSignal;
      //   1107: invokevirtual 310	android/os/CancellationSignal:throwIfCanceled	()V
      //   1110: aload 10
      //   1112: aload 11
      //   1114: invokevirtual 494	java/io/File:renameTo	(Ljava/io/File;)Z
      //   1117: istore 5
      //   1119: invokestatic 95	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:eTC	()Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$a;
      //   1122: ldc 97
      //   1124: ldc_w 496
      //   1127: iconst_2
      //   1128: anewarray 4	java/lang/Object
      //   1131: dup
      //   1132: iconst_0
      //   1133: aload 10
      //   1135: invokevirtual 128	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   1138: aastore
      //   1139: dup
      //   1140: iconst_1
      //   1141: aload 11
      //   1143: invokevirtual 128	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   1146: aastore
      //   1147: invokeinterface 326 4 0
      //   1152: iload 5
      //   1154: ifne -220 -> 934
      //   1157: aload_0
      //   1158: aload 10
      //   1160: aload 11
      //   1162: invokespecial 520	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:e	(Ljava/io/File;Ljava/io/File;)V
      //   1165: aload 10
      //   1167: invokevirtual 523	java/io/File:delete	()Z
      //   1170: ifne -236 -> 934
      //   1173: invokestatic 95	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:eTC	()Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$a;
      //   1176: ldc 97
      //   1178: ldc_w 525
      //   1181: iconst_1
      //   1182: anewarray 4	java/lang/Object
      //   1185: dup
      //   1186: iconst_0
      //   1187: aload 10
      //   1189: invokevirtual 128	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   1192: aastore
      //   1193: invokeinterface 105 4 0
      //   1198: goto -264 -> 934
      //   1201: aload 11
      //   1203: invokevirtual 276	java/io/File:exists	()Z
      //   1206: ifne +36 -> 1242
      //   1209: aload 11
      //   1211: invokevirtual 283	java/io/File:mkdirs	()Z
      //   1214: ifne +28 -> 1242
      //   1217: invokestatic 95	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:eTC	()Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$a;
      //   1220: ldc 97
      //   1222: ldc_w 527
      //   1225: iconst_1
      //   1226: anewarray 4	java/lang/Object
      //   1229: dup
      //   1230: iconst_0
      //   1231: aload 11
      //   1233: invokevirtual 128	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   1236: aastore
      //   1237: invokeinterface 529 4 0
      //   1242: aload_0
      //   1243: getfield 57	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:aaZ	F
      //   1246: fstore_1
      //   1247: aload_0
      //   1248: aload 10
      //   1250: getfield 499	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a$a:Goe	F
      //   1253: fload_1
      //   1254: fadd
      //   1255: putfield 57	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:aaZ	F
      //   1258: aload_0
      //   1259: getfield 57	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:aaZ	F
      //   1262: ldc_w 500
      //   1265: fmul
      //   1266: ldc_w 501
      //   1269: fmul
      //   1270: f2d
      //   1271: invokestatic 507	java/lang/Math:floor	(D)D
      //   1274: d2i
      //   1275: istore_2
      //   1276: aload_0
      //   1277: getfield 37	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:GnU	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   1280: invokestatic 349	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:f	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;)Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b;
      //   1283: iload_2
      //   1284: invokevirtual 472	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b:Yf	(I)V
      //   1287: goto -783 -> 504
      //   1290: aload 7
      //   1292: invokeinterface 532 1 0
      //   1297: iconst_1
      //   1298: isub
      //   1299: istore_2
      //   1300: iload_2
      //   1301: iflt +67 -> 1368
      //   1304: aload_0
      //   1305: getfield 59	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:GnW	Landroid/os/CancellationSignal;
      //   1308: invokevirtual 310	android/os/CancellationSignal:throwIfCanceled	()V
      //   1311: aload 7
      //   1313: iload_2
      //   1314: invokeinterface 534 2 0
      //   1319: checkcast 124	java/io/File
      //   1322: astore 8
      //   1324: aload 8
      //   1326: invokevirtual 276	java/io/File:exists	()Z
      //   1329: ifeq +304 -> 1633
      //   1332: aload 8
      //   1334: invokevirtual 523	java/io/File:delete	()Z
      //   1337: ifne +296 -> 1633
      //   1340: invokestatic 95	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:eTC	()Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$a;
      //   1343: ldc 97
      //   1345: ldc_w 536
      //   1348: iconst_1
      //   1349: anewarray 4	java/lang/Object
      //   1352: dup
      //   1353: iconst_0
      //   1354: aload 8
      //   1356: invokevirtual 128	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   1359: aastore
      //   1360: invokeinterface 105 4 0
      //   1365: goto +268 -> 1633
      //   1368: aload 7
      //   1370: invokeinterface 539 1 0
      //   1375: aload_0
      //   1376: getfield 57	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:aaZ	F
      //   1379: fconst_1
      //   1380: invokestatic 545	java/lang/Float:compare	(FF)I
      //   1383: ifeq +15 -> 1398
      //   1386: aload_0
      //   1387: getfield 37	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:GnU	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   1390: invokestatic 349	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:f	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;)Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b;
      //   1393: bipush 100
      //   1395: invokevirtual 472	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b:Yf	(I)V
      //   1398: aload_0
      //   1399: getfield 51	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:Goa	Ljava/lang/String;
      //   1402: invokestatic 550	com/tencent/mm/sdcard_migrate/b:aKm	(Ljava/lang/String;)V
      //   1405: aload_0
      //   1406: getfield 37	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:GnU	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   1409: invokestatic 349	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:f	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;)Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b;
      //   1412: astore 8
      //   1414: aload 8
      //   1416: iconst_1
      //   1417: invokevirtual 355	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b:vL	(Z)Landroid/support/v4/app/s$c;
      //   1420: invokestatic 556	java/lang/System:currentTimeMillis	()J
      //   1423: invokevirtual 559	android/support/v4/app/s$c:i	(J)Landroid/support/v4/app/s$c;
      //   1426: aload 8
      //   1428: getfield 356	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b:GnU	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   1431: ldc_w 560
      //   1434: invokevirtual 360	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:getString	(I)Ljava/lang/String;
      //   1437: invokevirtual 366	android/support/v4/app/s$c:g	(Ljava/lang/CharSequence;)Landroid/support/v4/app/s$c;
      //   1440: iconst_0
      //   1441: iconst_0
      //   1442: iconst_0
      //   1443: invokevirtual 369	android/support/v4/app/s$c:b	(IIZ)Landroid/support/v4/app/s$c;
      //   1446: iconst_1
      //   1447: invokevirtual 562	android/support/v4/app/s$c:F	(Z)Landroid/support/v4/app/s$c;
      //   1450: astore 7
      //   1452: aload 7
      //   1454: aload 8
      //   1456: iconst_1
      //   1457: invokevirtual 383	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b:vM	(Z)Landroid/app/PendingIntent;
      //   1460: putfield 387	android/support/v4/app/s$c:Fu	Landroid/app/PendingIntent;
      //   1463: aload 7
      //   1465: iconst_2
      //   1466: iconst_0
      //   1467: invokevirtual 372	android/support/v4/app/s$c:f	(IZ)V
      //   1470: aload 8
      //   1472: getfield 356	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b:GnU	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   1475: aload 7
      //   1477: invokevirtual 399	android/support/v4/app/s$c:build	()Landroid/app/Notification;
      //   1480: invokestatic 565	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:a	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;Landroid/app/Notification;)V
      //   1483: aload 8
      //   1485: getfield 356	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b:GnU	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   1488: invokestatic 406	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:a	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;)[Lcom/tencent/mm/sdcard_migrate/MigrateResultCallback;
      //   1491: astore 7
      //   1493: aload 7
      //   1495: monitorenter
      //   1496: aload 8
      //   1498: getfield 356	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b:GnU	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   1501: invokestatic 406	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:a	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;)[Lcom/tencent/mm/sdcard_migrate/MigrateResultCallback;
      //   1504: iconst_0
      //   1505: aaload
      //   1506: astore 8
      //   1508: aload 8
      //   1510: ifnull +21 -> 1531
      //   1513: aload 8
      //   1515: invokevirtual 412	com/tencent/mm/sdcard_migrate/MigrateResultCallback:asBinder	()Landroid/os/IBinder;
      //   1518: invokeinterface 417 1 0
      //   1523: ifeq +8 -> 1531
      //   1526: aload 8
      //   1528: invokevirtual 568	com/tencent/mm/sdcard_migrate/MigrateResultCallback:eUb	()V
      //   1531: aload 7
      //   1533: monitorexit
      //   1534: aload_0
      //   1535: iconst_0
      //   1536: invokespecial 345	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:vK	(Z)V
      //   1539: invokestatic 446	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:eTF	()V
      //   1542: aload_0
      //   1543: getfield 37	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:GnU	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   1546: invokestatic 448	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:i	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;)V
      //   1549: aload_0
      //   1550: getfield 37	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:GnU	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   1553: invokestatic 451	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:j	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;)V
      //   1556: ldc_w 340
      //   1559: invokestatic 118	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1562: return
      //   1563: astore 8
      //   1565: invokestatic 95	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:eTC	()Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$a;
      //   1568: ldc_w 453
      //   1571: aload 8
      //   1573: ldc_w 455
      //   1576: iconst_0
      //   1577: anewarray 4	java/lang/Object
      //   1580: invokeinterface 434 5 0
      //   1585: goto -54 -> 1531
      //   1588: astore 8
      //   1590: aload 7
      //   1592: monitorexit
      //   1593: ldc_w 340
      //   1596: invokestatic 118	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1599: aload 8
      //   1601: athrow
      //   1602: aload_0
      //   1603: getfield 37	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:GnU	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;
      //   1606: invokestatic 349	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService:f	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService;)Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b;
      //   1609: bipush 6
      //   1611: aconst_null
      //   1612: invokevirtual 460	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$b:c	(ILjava/lang/Throwable;)V
      //   1615: goto -1303 -> 312
      //   1618: iload_2
      //   1619: iconst_1
      //   1620: iadd
      //   1621: istore_2
      //   1622: goto -778 -> 844
      //   1625: astore 12
      //   1627: iconst_0
      //   1628: istore 5
      //   1630: goto -478 -> 1152
      //   1633: iload_2
      //   1634: iconst_1
      //   1635: isub
      //   1636: istore_2
      //   1637: goto -337 -> 1300
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	1640	0	this	a
      //   837	417	1	f	float
      //   775	862	2	i	int
      //   841	6	3	j	int
      //   961	10	4	k	int
      //   694	935	5	bool1	boolean
      //   1096	3	6	bool2	boolean
      //   31	230	7	localObject1	Object
      //   263	8	7	localOperationCanceledException	android.os.OperationCanceledException
      //   341	9	7	localThrowable1	Throwable
      //   366	12	7	localObject2	Object
      //   380	30	7	localThrowable2	Throwable
      //   463	1	7	localArrayList	java.util.ArrayList
      //   604	765	7	localObject3	Object
      //   37	1490	8	localObject5	Object
      //   1563	9	8	localThrowable3	Throwable
      //   1588	12	8	localObject6	Object
      //   25	1224	10	localObject8	Object
      //   554	678	11	localFile	File
      //   790	1	12	localThrowable4	Throwable
      //   1625	1	12	localThrowable5	Throwable
      // Exception table:
      //   from	to	target	type
      //   6	136	263	android/os/OperationCanceledException
      //   178	263	263	android/os/OperationCanceledException
      //   371	380	263	android/os/OperationCanceledException
      //   443	504	263	android/os/OperationCanceledException
      //   504	601	263	android/os/OperationCanceledException
      //   637	696	263	android/os/OperationCanceledException
      //   701	787	263	android/os/OperationCanceledException
      //   792	816	263	android/os/OperationCanceledException
      //   821	842	263	android/os/OperationCanceledException
      //   855	889	263	android/os/OperationCanceledException
      //   892	934	263	android/os/OperationCanceledException
      //   934	975	263	android/os/OperationCanceledException
      //   978	1034	263	android/os/OperationCanceledException
      //   1037	1086	263	android/os/OperationCanceledException
      //   1092	1098	263	android/os/OperationCanceledException
      //   1103	1152	263	android/os/OperationCanceledException
      //   1157	1198	263	android/os/OperationCanceledException
      //   1201	1242	263	android/os/OperationCanceledException
      //   1242	1287	263	android/os/OperationCanceledException
      //   1290	1300	263	android/os/OperationCanceledException
      //   1304	1365	263	android/os/OperationCanceledException
      //   1368	1398	263	android/os/OperationCanceledException
      //   1398	1496	263	android/os/OperationCanceledException
      //   1593	1602	263	android/os/OperationCanceledException
      //   153	175	341	java/lang/Throwable
      //   136	148	366	finally
      //   153	175	366	finally
      //   175	178	366	finally
      //   343	363	366	finally
      //   368	371	366	finally
      //   6	136	380	java/lang/Throwable
      //   178	263	380	java/lang/Throwable
      //   371	380	380	java/lang/Throwable
      //   443	504	380	java/lang/Throwable
      //   504	601	380	java/lang/Throwable
      //   637	696	380	java/lang/Throwable
      //   792	816	380	java/lang/Throwable
      //   821	842	380	java/lang/Throwable
      //   855	889	380	java/lang/Throwable
      //   892	934	380	java/lang/Throwable
      //   934	975	380	java/lang/Throwable
      //   978	1034	380	java/lang/Throwable
      //   1037	1086	380	java/lang/Throwable
      //   1092	1098	380	java/lang/Throwable
      //   1157	1198	380	java/lang/Throwable
      //   1201	1242	380	java/lang/Throwable
      //   1242	1287	380	java/lang/Throwable
      //   1290	1300	380	java/lang/Throwable
      //   1304	1365	380	java/lang/Throwable
      //   1368	1398	380	java/lang/Throwable
      //   1398	1496	380	java/lang/Throwable
      //   1593	1602	380	java/lang/Throwable
      //   6	136	604	finally
      //   178	263	604	finally
      //   265	312	604	finally
      //   371	380	604	finally
      //   382	414	604	finally
      //   443	504	604	finally
      //   504	601	604	finally
      //   637	696	604	finally
      //   701	787	604	finally
      //   792	816	604	finally
      //   821	842	604	finally
      //   855	889	604	finally
      //   892	934	604	finally
      //   934	975	604	finally
      //   978	1034	604	finally
      //   1037	1086	604	finally
      //   1092	1098	604	finally
      //   1103	1152	604	finally
      //   1157	1198	604	finally
      //   1201	1242	604	finally
      //   1242	1287	604	finally
      //   1290	1300	604	finally
      //   1304	1365	604	finally
      //   1368	1398	604	finally
      //   1398	1496	604	finally
      //   1593	1602	604	finally
      //   1602	1615	604	finally
      //   701	787	790	java/lang/Throwable
      //   1513	1531	1563	java/lang/Throwable
      //   1496	1508	1588	finally
      //   1513	1531	1588	finally
      //   1531	1534	1588	finally
      //   1565	1585	1588	finally
      //   1590	1593	1588	finally
      //   1103	1152	1625	java/lang/Throwable
    }
    
    final class a
    {
      final File God;
      final float Goe;
      
      a(File paramFile, float paramFloat)
      {
        this.God = paramFile;
        this.Goe = paramFloat;
      }
    }
  }
  
  final class b
  {
    private final s.c[] Gog;
    private final int[] Goh;
    
    private b()
    {
      AppMethodBeat.i(196209);
      this.Gog = new s.c[] { null };
      this.Goh = new int[] { -1 };
      AppMethodBeat.o(196209);
    }
    
    final void Yf(int paramInt)
    {
      AppMethodBeat.i(196213);
      synchronized (this.Goh)
      {
        if ((this.Goh[0] == -1) || ((paramInt != this.Goh[0]) && (paramInt % 10 == 0)))
        {
          s.c localc = vL(false).g(ExtStorageMigrateService.this.getString(2131758664));
          localc.f(2, true);
          localc = localc.b(100, paramInt, false);
          ((NotificationManager)ExtStorageMigrateService.this.getSystemService("notification")).notify(1027, localc.build());
        }
        this.Goh[0] = paramInt;
      }
      synchronized (ExtStorageMigrateService.a(ExtStorageMigrateService.this))
      {
        a.b(ExtStorageMigrateService.a(ExtStorageMigrateService.this)[0], paramInt);
        AppMethodBeat.o(196213);
        return;
        localObject2 = finally;
        AppMethodBeat.o(196213);
        throw localObject2;
      }
    }
    
    final void Yg(int paramInt)
    {
      AppMethodBeat.i(196215);
      ??? = vL(true).i(System.currentTimeMillis()).g(ExtStorageMigrateService.this.getString(2131758657)).b(0, 0, false).F(true);
      ((s.c)???).Fu = vM(true);
      ((s.c)???).f(2, false);
      ExtStorageMigrateService.a(ExtStorageMigrateService.this, ((s.c)???).build());
      synchronized (ExtStorageMigrateService.a(ExtStorageMigrateService.this))
      {
        a.a(ExtStorageMigrateService.a(ExtStorageMigrateService.this)[0], paramInt);
        AppMethodBeat.o(196215);
        return;
      }
    }
    
    final void c(int paramInt, Throwable paramThrowable)
    {
      AppMethodBeat.i(196214);
      s.c localc = vL(true).i(System.currentTimeMillis());
      if (paramInt == 6) {
        ??? = ExtStorageMigrateService.this.getString(2131758661);
      }
      for (;;)
      {
        ??? = localc.g((CharSequence)???).b(0, 0, false).F(true);
        ((s.c)???).Fu = vM(true);
        ((s.c)???).f(2, false);
        ExtStorageMigrateService.a(ExtStorageMigrateService.this, ((s.c)???).build());
        synchronized (ExtStorageMigrateService.a(ExtStorageMigrateService.this))
        {
          a.a(ExtStorageMigrateService.a(ExtStorageMigrateService.this)[0], paramInt, paramThrowable);
          AppMethodBeat.o(196214);
          return;
          ??? = ExtStorageMigrateService.this.getString(2131758659);
        }
      }
    }
    
    final s.a eTP()
    {
      AppMethodBeat.i(196211);
      Object localObject = new Intent(ExtStorageMigrateService.this, ExtStorageMigrateService.class);
      ((Intent)localObject).setAction("service_action_cancel_migrate");
      localObject = PendingIntent.getService(ExtStorageMigrateService.this, 3843, (Intent)localObject, 268435456);
      localObject = new s.a.a(2131233504, ExtStorageMigrateService.this.getResources().getString(2131756766), (PendingIntent)localObject);
      ((s.a.a)localObject).Fi = false;
      localObject = ((s.a.a)localObject).dT();
      AppMethodBeat.o(196211);
      return localObject;
    }
    
    final s.c vL(boolean paramBoolean)
    {
      AppMethodBeat.i(196210);
      synchronized (this.Gog)
      {
        if ((this.Gog[0] != null) && (!paramBoolean))
        {
          localObject1 = this.Gog[0];
          AppMethodBeat.o(196210);
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
        ((s.c)localObject1).f(ExtStorageMigrateService.this.getResources().getString(2131755822)).as(2131233502).F(false);
        this.Gog[0] = localObject1;
        AppMethodBeat.o(196210);
        return localObject1;
      }
    }
    
    final PendingIntent vM(boolean paramBoolean)
    {
      AppMethodBeat.i(196212);
      Object localObject = new Intent(ExtStorageMigrateService.this, ExtStorageMigrateAuxActivity.class);
      ((Intent)localObject).setAction("auxui_action_do_migrate_routine");
      ((Intent)localObject).putExtra("auxui_param_is_migration_end", paramBoolean);
      ((Intent)localObject).addFlags(268435456);
      localObject = PendingIntent.getActivity(ExtStorageMigrateService.this, 3841, (Intent)localObject, 268435456);
      AppMethodBeat.o(196212);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sdcard_migrate.ExtStorageMigrateService
 * JD-Core Version:    0.7.0.1
 */