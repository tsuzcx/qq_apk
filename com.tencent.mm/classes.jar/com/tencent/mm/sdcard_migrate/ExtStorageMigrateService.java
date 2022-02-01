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
import android.os.OperationCanceledException;
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
import java.util.ArrayList;
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
  private Thread EQA;
  private final MigrateResultCallback[] EQB;
  private volatile int EQC;
  private final boolean[] EQD;
  private final PowerManager.WakeLock[] EQE;
  private final boolean[] EQF;
  private final e.a EQG;
  private final b EQy;
  private final a[] EQz;
  
  public ExtStorageMigrateService()
  {
    AppMethodBeat.i(169829);
    this.EQy = new b((byte)0);
    this.EQz = new a[] { null };
    this.EQA = null;
    this.EQB = new MigrateResultCallback[] { null };
    this.EQC = 0;
    this.EQD = new boolean[] { false };
    this.EQE = new PowerManager.WakeLock[] { null };
    this.EQF = new boolean[] { false };
    this.EQG = new e.a()
    {
      public final void a(ExtStorageMigrateConfig paramAnonymousExtStorageMigrateConfig)
      {
        AppMethodBeat.i(191348);
        ExtStorageMigrateService.a(ExtStorageMigrateService.this, paramAnonymousExtStorageMigrateConfig);
        AppMethodBeat.o(191348);
      }
      
      public final void a(MigrateResultCallback paramAnonymousMigrateResultCallback)
      {
        AppMethodBeat.i(191346);
        synchronized (ExtStorageMigrateService.a(ExtStorageMigrateService.this))
        {
          if ((ExtStorageMigrateService.a(ExtStorageMigrateService.this)[0] != null) && (ExtStorageMigrateService.a(ExtStorageMigrateService.this)[0] != paramAnonymousMigrateResultCallback)) {
            ExtStorageMigrateService.a(ExtStorageMigrateService.this)[0].iU(ExtStorageMigrateService.c(ExtStorageMigrateService.this), Binder.getCallingPid());
          }
          ExtStorageMigrateService.a(ExtStorageMigrateService.this)[0] = paramAnonymousMigrateResultCallback;
          if (!eEq()) {
            break label147;
          }
        }
        synchronized (ExtStorageMigrateService.b(ExtStorageMigrateService.this))
        {
          paramAnonymousMigrateResultCallback.kM(ExtStorageMigrateService.a.c(ExtStorageMigrateService.b(ExtStorageMigrateService.this)[0]), ExtStorageMigrateService.a.d(ExtStorageMigrateService.b(ExtStorageMigrateService.this)[0]));
          AppMethodBeat.o(191346);
          return;
          paramAnonymousMigrateResultCallback = finally;
          AppMethodBeat.o(191346);
          throw paramAnonymousMigrateResultCallback;
        }
        label147:
        AppMethodBeat.o(191346);
      }
      
      public final void b(MigrateResultCallback arg1)
      {
        AppMethodBeat.i(191347);
        synchronized (ExtStorageMigrateService.a(ExtStorageMigrateService.this))
        {
          if (ExtStorageMigrateService.a(ExtStorageMigrateService.this)[0] != null) {
            ExtStorageMigrateService.a(ExtStorageMigrateService.this)[0] = null;
          }
          AppMethodBeat.o(191347);
          return;
        }
      }
      
      public final boolean eEq()
      {
        AppMethodBeat.i(191345);
        if ((ExtStorageMigrateService.b(ExtStorageMigrateService.this)[0] != null) && (ExtStorageMigrateService.a.b(ExtStorageMigrateService.b(ExtStorageMigrateService.this)[0])))
        {
          AppMethodBeat.o(191345);
          return true;
        }
        AppMethodBeat.o(191345);
        return false;
      }
      
      public final void eEu()
      {
        AppMethodBeat.i(191349);
        ExtStorageMigrateService.d(ExtStorageMigrateService.this);
        AppMethodBeat.o(191349);
      }
    };
    AppMethodBeat.o(169829);
  }
  
  private static String Fh(String paramString)
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
      ExtStorageMigrateMonitor.eEi().printErrStackTrace("MicroMsg.ExtStorageMigrateService", localThrowable, "[-] Fail to get canonical path for: %s", new Object[] { paramString });
      paramString = new File(paramString).getAbsolutePath();
      AppMethodBeat.o(169831);
    }
    return paramString;
  }
  
  private static File K(File paramFile)
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
      ExtStorageMigrateMonitor.eEi().printErrStackTrace("MicroMsg.ExtStorageMigrateService", localThrowable, "[-] Fail to get canonical file for: %s", new Object[] { paramFile.getAbsolutePath() });
      paramFile = paramFile.getAbsoluteFile();
      AppMethodBeat.o(169830);
    }
    return paramFile;
  }
  
  private boolean eEq()
  {
    boolean bool2 = false;
    AppMethodBeat.i(191362);
    a[] arrayOfa = this.EQz;
    boolean bool1 = bool2;
    try
    {
      if (this.EQz[0] != null)
      {
        bool1 = bool2;
        if (a.b(this.EQz[0])) {
          bool1 = true;
        }
      }
      return bool1;
    }
    finally
    {
      AppMethodBeat.o(191362);
    }
  }
  
  private boolean eEr()
  {
    synchronized (this.EQD)
    {
      int i = this.EQD[0];
      return i;
    }
  }
  
  private boolean eEs()
  {
    synchronized (this.EQF)
    {
      int i = this.EQF[0];
      return i;
    }
  }
  
  private void eEt()
  {
    AppMethodBeat.i(191363);
    ExtStorageMigrateMonitor.eEi().i("MicroMsg.ExtStorageMigrateService", "[+] expectedStopSelf called.", new Object[0]);
    uH(true);
    stopSelf();
    AppMethodBeat.o(191363);
  }
  
  private void releaseWakeLock()
  {
    AppMethodBeat.i(191364);
    synchronized (this.EQE)
    {
      if ((this.EQE[0] != null) && (this.EQE[0].isHeld()))
      {
        this.EQE[0].release();
        this.EQE[0] = null;
        ExtStorageMigrateMonitor.eEi().i("MicroMsg.ExtStorageMigrateService", "[+] WakeLock released.", new Object[0]);
      }
      AppMethodBeat.o(191364);
      return;
    }
  }
  
  private void uG(boolean paramBoolean)
  {
    synchronized (this.EQD)
    {
      this.EQD[0] = paramBoolean;
      return;
    }
  }
  
  private void uH(boolean paramBoolean)
  {
    synchronized (this.EQF)
    {
      this.EQF[0] = paramBoolean;
      return;
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    AppMethodBeat.i(191361);
    paramIntent = this.EQG.asBinder();
    AppMethodBeat.o(191361);
    return paramIntent;
  }
  
  public void onCreate()
  {
    AppMethodBeat.i(191360);
    super.onCreate();
    synchronized (this.EQz)
    {
      this.EQz[0] = null;
      this.EQA = null;
    }
    synchronized (this.EQB)
    {
      this.EQB[0] = null;
      this.EQC = 0;
      uG(false);
      AppMethodBeat.o(191360);
      return;
      localObject2 = finally;
      AppMethodBeat.o(191360);
      throw localObject2;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(169833);
    ExtStorageMigrateMonitor.eEi().i("MicroMsg.ExtStorageMigrateService", "[+] OnDestroy called.", new Object[0]);
    synchronized (this.EQz)
    {
      if (eEq()) {
        a.a(this.EQz[0]);
      }
    }
    try
    {
      this.EQA.join();
      for (;;)
      {
        label53:
        this.EQz[0] = null;
        if (eEr()) {
          stopForeground(true);
        }
        releaseWakeLock();
        AppMethodBeat.o(169833);
        return;
        if (eEr()) {
          if (eEs())
          {
            uH(false);
            this.EQy.VX(2);
            continue;
            localObject = finally;
            AppMethodBeat.o(169833);
            throw localObject;
          }
          else
          {
            this.EQy.c(6, null);
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
    ExtStorageMigrateMonitor.eEi().i("MicroMsg.ExtStorageMigrateService", "[+] OnStartCommand called, intent: %s", new Object[] { paramIntent });
    if (paramIntent == null) {
      ExtStorageMigrateMonitor.eEi().e("MicroMsg.ExtStorageMigrateService", "[-] intent is null, skip rest logic.", new Object[0]);
    }
    for (;;)
    {
      AppMethodBeat.o(169832);
      return 1;
      paramIntent = paramIntent.getAction();
      if (paramIntent == null)
      {
        ExtStorageMigrateMonitor.eEi().e("MicroMsg.ExtStorageMigrateService", "[-] action is null, skip rest logic.", new Object[0]);
      }
      else if ("service_action_startup".equals(paramIntent))
      {
        Object localObject = this.EQy;
        if ((((b)localObject).EQH.eEr()) || (((b)localObject).EQH.eEq()))
        {
          ExtStorageMigrateMonitor.eEi().w("MicroMsg.ExtStorageMigrateService", "[!] Already on foreground or migrating logic, skip startup steps.", new Object[0]);
        }
        else
        {
          paramIntent = ((b)localObject).uJ(true);
          s.c localc = paramIntent.g(System.currentTimeMillis()).g(((b)localObject).EQH.getString(2131758667)).b(0, 0, true);
          localc.f(2, true);
          localc.a(((b)localObject).eEv()).Ew = ((b)localObject).uK(false);
          localObject = ((b)localObject).EQH;
          ((ExtStorageMigrateService)localObject).startForeground(1027, paramIntent.build());
          ((ExtStorageMigrateService)localObject).uG(true);
        }
      }
      else if ("service_action_cancel_migrate".equals(paramIntent))
      {
        eEt();
      }
      else
      {
        ExtStorageMigrateMonitor.eEi().e("MicroMsg.ExtStorageMigrateService", "[-] Unknown action: %s", new Object[] { paramIntent });
      }
    }
  }
  
  final class a
    implements Runnable
  {
    private final boolean[] EQI;
    private final CancellationSignal EQJ;
    private final Set<String> EQK;
    private final Set<String> EQL;
    private final Map<String, String> EQM;
    private String EQN;
    private String EQO;
    private ByteBuffer EQP;
    private final boolean EQi;
    private float aae;
    
    a(ExtStorageMigrateConfig paramExtStorageMigrateConfig, CancellationSignal paramCancellationSignal)
    {
      AppMethodBeat.i(191350);
      this.EQI = new boolean[] { false };
      this.EQN = null;
      this.EQO = null;
      this.EQP = null;
      this.aae = 0.0F;
      this.EQJ = paramCancellationSignal;
      this.EQi = paramExtStorageMigrateConfig.EQd;
      this.EQK = new HashSet(64);
      this.EQL = new HashSet(5);
      this.EQM = new HashMap(5);
      this.EQN = ExtStorageMigrateService.aER(paramExtStorageMigrateConfig.sourceDir);
      this.EQO = ExtStorageMigrateService.aER(paramExtStorageMigrateConfig.EQc);
      if (paramExtStorageMigrateConfig.EQd) {
        ExtStorageMigrateMonitor.eEi().w("MicroMsg.ExtStorageMigrateService", "[!] Force copy mode enabled, are we under test mode ??", new Object[0]);
      }
      a(paramExtStorageMigrateConfig.sourceDir, paramExtStorageMigrateConfig.EQe);
      AppMethodBeat.o(191350);
    }
    
    private String M(File paramFile)
    {
      AppMethodBeat.i(169821);
      paramFile = aET(paramFile.getAbsolutePath().substring(this.EQN.length()));
      if (paramFile.startsWith("/")) {
        paramFile = paramFile.substring(1);
      }
      for (;;)
      {
        Object localObject2;
        label116:
        int i;
        for (Object localObject1 = paramFile;; localObject1 = ((String)localObject1).substring(0, i))
        {
          localObject2 = paramFile;
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject2 = (String)this.EQM.get(localObject1);
            if (localObject2 == null) {
              break label116;
            }
            localObject2 = (String)localObject2 + paramFile.substring(((String)localObject1).length());
          }
          do
          {
            if (!((String)localObject2).startsWith("/")) {
              break;
            }
            AppMethodBeat.o(169821);
            return localObject2;
            i = ((String)localObject1).lastIndexOf('/');
            localObject2 = paramFile;
          } while (i < 0);
        }
        paramFile = this.EQO + "/" + (String)localObject2;
        AppMethodBeat.o(169821);
        return paramFile;
      }
    }
    
    private void a(String paramString, Collection<ExtStorageMigrateConfig.ExtraPathAction> paramCollection)
    {
      AppMethodBeat.i(191351);
      if (paramCollection == null)
      {
        AppMethodBeat.o(191351);
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
          localObject = ExtStorageMigrateService.L(new File(paramString, paramCollection.EQk));
          this.EQL.add(((File)localObject).getAbsolutePath());
          kL(paramString, paramCollection.EQk);
        }
        else if ((paramCollection instanceof ExtStorageMigrateConfig.ExtraPathAction.Remap))
        {
          localObject = (ExtStorageMigrateConfig.ExtraPathAction.Remap)paramCollection;
          Map localMap = this.EQM;
          String str = aET(((ExtStorageMigrateConfig.ExtraPathAction.Remap)localObject).EQl);
          if (((ExtStorageMigrateConfig.ExtraPathAction.Remap)localObject).hzG.startsWith("/")) {}
          for (paramCollection = ((ExtStorageMigrateConfig.ExtraPathAction.Remap)localObject).hzG;; paramCollection = aET(((ExtStorageMigrateConfig.ExtraPathAction.Remap)localObject).hzG))
          {
            localMap.put(str, paramCollection);
            kL(paramString, ((ExtStorageMigrateConfig.ExtraPathAction.Remap)localObject).EQl);
            break;
          }
        }
      }
      this.EQK.add(paramString);
      AppMethodBeat.o(191351);
    }
    
    private static String aES(String paramString)
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
    
    private static String aET(String paramString)
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
      //   0: ldc_w 261
      //   3: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   6: aload_2
      //   7: invokevirtual 264	java/io/File:exists	()Z
      //   10: ifne +11 -> 21
      //   13: aload_2
      //   14: invokevirtual 268	java/io/File:getParentFile	()Ljava/io/File;
      //   17: invokevirtual 271	java/io/File:mkdirs	()Z
      //   20: pop
      //   21: new 273	java/io/BufferedInputStream
      //   24: dup
      //   25: new 275	java/io/FileInputStream
      //   28: dup
      //   29: aload_1
      //   30: invokespecial 278	java/io/FileInputStream:<init>	(Ljava/io/File;)V
      //   33: invokespecial 281	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
      //   36: astore 4
      //   38: new 283	java/io/BufferedOutputStream
      //   41: dup
      //   42: new 285	java/io/FileOutputStream
      //   45: dup
      //   46: aload_2
      //   47: invokespecial 286	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
      //   50: invokespecial 289	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
      //   53: astore 5
      //   55: sipush 4096
      //   58: newarray byte
      //   60: astore 6
      //   62: aload 4
      //   64: aload 6
      //   66: invokevirtual 295	java/io/InputStream:read	([B)I
      //   69: istore_3
      //   70: iload_3
      //   71: ifle +43 -> 114
      //   74: aload_0
      //   75: getfield 59	com/tencent/mm/sdcard_migrate/ExtStorageMigrateService$a:EQJ	Landroid/os/CancellationSignal;
      //   78: invokevirtual 298	android/os/CancellationSignal:throwIfCanceled	()V
      //   81: aload 5
      //   83: aload 6
      //   85: iconst_0
      //   86: iload_3
      //   87: invokevirtual 304	java/io/OutputStream:write	([BII)V
      //   90: goto -28 -> 62
      //   93: astore_1
      //   94: aload 5
      //   96: astore_2
      //   97: aload_2
      //   98: invokestatic 310	com/tencent/mm/vfs/q:closeQuietly	(Ljava/io/Closeable;)V
      //   101: aload 4
      //   103: invokestatic 310	com/tencent/mm/vfs/q:closeQuietly	(Ljava/io/Closeable;)V
      //   106: ldc_w 261
      //   109: invokestatic 114	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   112: aload_1
      //   113: athrow
      //   114: invokestatic 95	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:eEi	()Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$a;
      //   117: ldc 97
      //   119: ldc_w 312
      //   122: iconst_2
      //   123: anewarray 4	java/lang/Object
      //   126: dup
      //   127: iconst_0
      //   128: aload_1
      //   129: invokevirtual 124	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   132: aastore
      //   133: dup
      //   134: iconst_1
      //   135: aload_2
      //   136: invokevirtual 124	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   139: aastore
      //   140: invokeinterface 314 4 0
      //   145: aload 5
      //   147: invokestatic 310	com/tencent/mm/vfs/q:closeQuietly	(Ljava/io/Closeable;)V
      //   150: aload 4
      //   152: invokestatic 310	com/tencent/mm/vfs/q:closeQuietly	(Ljava/io/Closeable;)V
      //   155: ldc_w 261
      //   158: invokestatic 114	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
      synchronized (this.EQI)
      {
        int i = this.EQI[0];
        return i;
      }
    }
    
    private void kL(String paramString1, String paramString2)
    {
      AppMethodBeat.i(169816);
      String str = aES(paramString1);
      paramString1 = new File(str, paramString2);
      do
      {
        this.EQK.add(aES(paramString1.getAbsolutePath()));
        paramString2 = paramString1.getParentFile();
        if (paramString2 == null) {
          break;
        }
        paramString1 = paramString2;
      } while (!str.equals(paramString2.getAbsolutePath()));
      AppMethodBeat.o(169816);
    }
    
    private void uI(boolean paramBoolean)
    {
      synchronized (this.EQI)
      {
        this.EQI[0] = paramBoolean;
        return;
      }
    }
    
    public final void run()
    {
      AppMethodBeat.i(169819);
      for (;;)
      {
        Object localObject8;
        Object localObject5;
        File localFile;
        try
        {
          ExtStorageMigrateService.e(ExtStorageMigrateService.this);
          uI(true);
          localObject8 = ExtStorageMigrateService.f(ExtStorageMigrateService.this);
          Object localObject1 = this.EQN;
          localObject5 = this.EQO;
          ??? = ((ExtStorageMigrateService.b)localObject8).uJ(true).g(((ExtStorageMigrateService.b)localObject8).EQH.getString(2131758664)).b(100, 0, false);
          ((s.c)???).f(2, true);
          ??? = ((s.c)???).a(((ExtStorageMigrateService.b)localObject8).eEv());
          ((s.c)???).Ew = ((ExtStorageMigrateService.b)localObject8).uK(false);
          ((NotificationManager)((ExtStorageMigrateService.b)localObject8).EQH.getSystemService("notification")).notify(1027, ((s.c)???).build());
          ArrayList localArrayList;
          if (this.EQi) {
            break label759;
          }
        }
        catch (OperationCanceledException localOperationCanceledException) {}catch (Throwable localThrowable2)
        {
          ExtStorageMigrateMonitor.eEi().printErrStackTrace("MicroMsg.ExtStorageMigrateService", localThrowable2, "[-] Error happened.", new Object[0]);
          ExtStorageMigrateService.f(ExtStorageMigrateService.this).c(5, localThrowable2);
          return;
          localObject5 = new ArrayList(20);
          localArrayList = new ArrayList(64);
          ((List)localObject5).add(new a((File)???, 1.0F));
          this.aae = 0.0F;
          ExtStorageMigrateService.f(ExtStorageMigrateService.this).VW((int)this.aae);
          if (((List)localObject5).isEmpty()) {
            break label1205;
          }
          this.EQJ.throwIfCanceled();
          localObject8 = (a)((List)localObject5).remove(0);
          ??? = ((a)localObject8).EQQ;
          localFile = new File(M((File)???));
          if (this.EQL.contains(aES(((File)???).getAbsolutePath())))
          {
            ExtStorageMigrateMonitor.eEi().w("MicroMsg.ExtStorageMigrateService", "[!] Do not migrate %s since it was skipped manually.", new Object[] { ((File)???).getAbsolutePath() });
            continue;
          }
        }
        finally
        {
          uI(false);
          ExtStorageMigrateMonitor.eEl();
          ExtStorageMigrateService.i(ExtStorageMigrateService.this);
          ExtStorageMigrateService.j(ExtStorageMigrateService.this);
          AppMethodBeat.o(169819);
        }
        boolean bool1 = this.EQK.contains(aES(((File)???).getAbsolutePath()));
        int i;
        if (!bool1) {
          try
          {
            if (((File)???).renameTo(localFile))
            {
              ExtStorageMigrateMonitor.eEi().d("MicroMsg.ExtStorageMigrateService", "[*] Move %s to %s.", new Object[] { ((File)???).getAbsolutePath(), localFile.getAbsolutePath() });
              this.aae += ((a)localObject8).EQR;
              i = (int)Math.floor(this.aae * 0.9F * 100.0F);
              ExtStorageMigrateService.f(ExtStorageMigrateService.this).VW(i);
            }
          }
          catch (Throwable localThrowable4) {}
        }
        label759:
        this.EQJ.throwIfCanceled();
        localObject3.add(???);
        ??? = ((File)???).listFiles();
        float f;
        if ((??? != null) && (???.length != 0))
        {
          f = ((a)localObject8).EQR / ???.length;
          int j = ???.length;
          i = 0;
          if (i >= j) {
            continue;
          }
          localObject8 = ???[i];
          this.EQJ.throwIfCanceled();
          if (((File)localObject8).isDirectory())
          {
            ((List)localObject5).add(new a((File)localObject8, f));
            break label1533;
          }
          if (this.EQL.contains(((File)localObject8).getAbsolutePath())) {
            ExtStorageMigrateMonitor.eEi().w("MicroMsg.ExtStorageMigrateService", "[!] Do not migrate %s since it was skipped manually.", new Object[] { ((File)localObject8).getAbsolutePath() });
          }
          for (;;)
          {
            label901:
            this.aae += f;
            int k = (int)Math.floor(this.aae * 0.9F * 100.0F);
            ExtStorageMigrateService.f(ExtStorageMigrateService.this).VW(k);
            break label1533;
            localFile = new File(M((File)localObject8));
            if (!((File)localObject8).getAbsolutePath().equals(localFile.getAbsolutePath())) {
              break;
            }
            ExtStorageMigrateMonitor.eEi().w("MicroMsg.ExtStorageMigrateService", "[!] Same source and destination: %s, skip migration.", new Object[] { ((File)localObject8).getAbsolutePath() });
          }
          bool1 = false;
          boolean bool2 = this.EQi;
          if (bool2) {}
        }
        try
        {
          this.EQJ.throwIfCanceled();
          bool1 = ((File)localObject8).renameTo(localFile);
          ExtStorageMigrateMonitor.eEi().d("MicroMsg.ExtStorageMigrateService", "[*] Move %s to %s.", new Object[] { ((File)localObject8).getAbsolutePath(), localFile.getAbsolutePath() });
          if (bool1) {
            break label901;
          }
          e((File)localObject8, localFile);
          if (((File)localObject8).delete()) {
            break label901;
          }
          ExtStorageMigrateMonitor.eEi().w("MicroMsg.ExtStorageMigrateService", "[!] Fail to delete src file: %s", new Object[] { ((File)localObject8).getAbsolutePath() });
          break label901;
          if ((!localFile.exists()) && (!localFile.mkdirs())) {
            ExtStorageMigrateMonitor.eEi().e("MicroMsg.ExtStorageMigrateService", "[-] Fail to create dest dir: %s", new Object[] { localFile.getAbsolutePath() });
          }
          f = this.aae;
          this.aae = (((a)localObject8).EQR + f);
          i = (int)Math.floor(this.aae * 0.9F * 100.0F);
          ExtStorageMigrateService.f(ExtStorageMigrateService.this).VW(i);
          continue;
          label1205:
          i = localObject3.size() - 1;
          if (i >= 0)
          {
            this.EQJ.throwIfCanceled();
            localObject5 = (File)localObject3.get(i);
            if ((((File)localObject5).exists()) && (!((File)localObject5).delete())) {
              ExtStorageMigrateMonitor.eEi().w("MicroMsg.ExtStorageMigrateService", "[!] Fail to delete dir: %s", new Object[] { ((File)localObject5).getAbsolutePath() });
            }
          }
          else
          {
            localObject3.clear();
            if (Float.compare(this.aae, 1.0F) != 0) {
              ExtStorageMigrateService.f(ExtStorageMigrateService.this).VW(100);
            }
            b.aEV(this.EQN);
            localObject5 = ExtStorageMigrateService.f(ExtStorageMigrateService.this);
            ??? = ((ExtStorageMigrateService.b)localObject5).uJ(true).g(System.currentTimeMillis()).g(((ExtStorageMigrateService.b)localObject5).EQH.getString(2131758668)).b(0, 0, false).F(true);
            ((s.c)???).Ew = ((ExtStorageMigrateService.b)localObject5).uK(true);
            ((s.c)???).f(2, false);
            ExtStorageMigrateService.a(((ExtStorageMigrateService.b)localObject5).EQH, ((s.c)???).build());
            synchronized (ExtStorageMigrateService.a(((ExtStorageMigrateService.b)localObject5).EQH))
            {
              localObject5 = ExtStorageMigrateService.a(localObject5.EQH)[0];
              if (localObject5 != null) {}
              try
              {
                if (((MigrateResultCallback)localObject5).asBinder().isBinderAlive()) {
                  ((MigrateResultCallback)localObject5).eEH();
                }
                uI(false);
                ExtStorageMigrateMonitor.eEl();
                ExtStorageMigrateService.i(ExtStorageMigrateService.this);
                ExtStorageMigrateService.j(ExtStorageMigrateService.this);
                AppMethodBeat.o(169819);
                return;
              }
              catch (Throwable localThrowable3)
              {
                for (;;)
                {
                  ExtStorageMigrateMonitor.eEi().printErrStackTrace("MicroMsg.MigrateResultCallbackHelper", localThrowable3, "[-] Exception occurred.", new Object[0]);
                }
              }
            }
            ExtStorageMigrateService.f(ExtStorageMigrateService.this).c(6, null);
            continue;
            label1533:
            i += 1;
          }
        }
        catch (Throwable localThrowable5)
        {
          for (;;)
          {
            bool1 = false;
            continue;
            i -= 1;
          }
        }
      }
    }
    
    final class a
    {
      final File EQQ;
      final float EQR;
      
      a(File paramFile, float paramFloat)
      {
        this.EQQ = paramFile;
        this.EQR = paramFloat;
      }
    }
  }
  
  final class b
  {
    private final s.c[] EQT;
    private final int[] EQU;
    
    private b()
    {
      AppMethodBeat.i(191353);
      this.EQT = new s.c[] { null };
      this.EQU = new int[] { -1 };
      AppMethodBeat.o(191353);
    }
    
    final void VW(int paramInt)
    {
      AppMethodBeat.i(191357);
      synchronized (this.EQU)
      {
        if ((this.EQU[0] == -1) || ((paramInt != this.EQU[0]) && (paramInt % 10 == 0)))
        {
          s.c localc = uJ(false).g(ExtStorageMigrateService.this.getString(2131758664));
          localc.f(2, true);
          localc = localc.b(100, paramInt, false);
          ((NotificationManager)ExtStorageMigrateService.this.getSystemService("notification")).notify(1027, localc.build());
        }
        this.EQU[0] = paramInt;
      }
      synchronized (ExtStorageMigrateService.a(ExtStorageMigrateService.this))
      {
        a.b(ExtStorageMigrateService.a(ExtStorageMigrateService.this)[0], paramInt);
        AppMethodBeat.o(191357);
        return;
        localObject2 = finally;
        AppMethodBeat.o(191357);
        throw localObject2;
      }
    }
    
    final void VX(int paramInt)
    {
      AppMethodBeat.i(191359);
      ??? = uJ(true).g(System.currentTimeMillis()).g(ExtStorageMigrateService.this.getString(2131758657)).b(0, 0, false).F(true);
      ((s.c)???).Ew = uK(true);
      ((s.c)???).f(2, false);
      ExtStorageMigrateService.a(ExtStorageMigrateService.this, ((s.c)???).build());
      synchronized (ExtStorageMigrateService.a(ExtStorageMigrateService.this))
      {
        a.a(ExtStorageMigrateService.a(ExtStorageMigrateService.this)[0], paramInt);
        AppMethodBeat.o(191359);
        return;
      }
    }
    
    final void c(int paramInt, Throwable paramThrowable)
    {
      AppMethodBeat.i(191358);
      s.c localc = uJ(true).g(System.currentTimeMillis());
      if (paramInt == 6) {
        ??? = ExtStorageMigrateService.this.getString(2131758661);
      }
      for (;;)
      {
        ??? = localc.g((CharSequence)???).b(0, 0, false).F(true);
        ((s.c)???).Ew = uK(true);
        ((s.c)???).f(2, false);
        ExtStorageMigrateService.a(ExtStorageMigrateService.this, ((s.c)???).build());
        synchronized (ExtStorageMigrateService.a(ExtStorageMigrateService.this))
        {
          a.a(ExtStorageMigrateService.a(ExtStorageMigrateService.this)[0], paramInt, paramThrowable);
          AppMethodBeat.o(191358);
          return;
          ??? = ExtStorageMigrateService.this.getString(2131758659);
        }
      }
    }
    
    final s.a eEv()
    {
      AppMethodBeat.i(191355);
      Object localObject = new Intent(ExtStorageMigrateService.this, ExtStorageMigrateService.class);
      ((Intent)localObject).setAction("service_action_cancel_migrate");
      localObject = PendingIntent.getService(ExtStorageMigrateService.this, 3843, (Intent)localObject, 268435456);
      localObject = new s.a.a(2131233504, ExtStorageMigrateService.this.getResources().getString(2131756766), (PendingIntent)localObject);
      ((s.a.a)localObject).Ek = false;
      localObject = ((s.a.a)localObject).dM();
      AppMethodBeat.o(191355);
      return localObject;
    }
    
    final s.c uJ(boolean paramBoolean)
    {
      AppMethodBeat.i(191354);
      synchronized (this.EQT)
      {
        if ((this.EQT[0] != null) && (!paramBoolean))
        {
          localObject1 = this.EQT[0];
          AppMethodBeat.o(191354);
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
        this.EQT[0] = localObject1;
        AppMethodBeat.o(191354);
        return localObject1;
      }
    }
    
    final PendingIntent uK(boolean paramBoolean)
    {
      AppMethodBeat.i(191356);
      Object localObject = new Intent(ExtStorageMigrateService.this, ExtStorageMigrateAuxActivity.class);
      ((Intent)localObject).setAction("auxui_action_do_migrate_routine");
      ((Intent)localObject).putExtra("auxui_param_is_migration_end", paramBoolean);
      ((Intent)localObject).addFlags(268435456);
      localObject = PendingIntent.getActivity(ExtStorageMigrateService.this, 3841, (Intent)localObject, 268435456);
      AppMethodBeat.o(191356);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sdcard_migrate.ExtStorageMigrateService
 * JD-Core Version:    0.7.0.1
 */