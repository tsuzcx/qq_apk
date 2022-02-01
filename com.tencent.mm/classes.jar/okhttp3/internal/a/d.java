package okhttp3.internal.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import j.aa;
import j.h;
import j.q;
import j.y;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Flushable;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.internal.c;
import okhttp3.internal.f.a;

public final class d
  implements Closeable, Flushable
{
  static final Pattern ajOK;
  private final Runnable ajMh;
  final a ajOL;
  final File ajOM;
  private final File ajON;
  private final File ajOO;
  private final File ajOP;
  final int ajOQ;
  j.g ajOR;
  final LinkedHashMap<String, b> ajOS;
  int ajOT;
  boolean ajOU;
  boolean ajOV;
  boolean ajOW;
  private long ajOX;
  private final int appVersion;
  private long cBA;
  boolean closed;
  private final Executor executor;
  boolean initialized;
  private long size;
  
  static
  {
    AppMethodBeat.i(187160);
    if (!d.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      ajOK = Pattern.compile("[a-z0-9_-]{1,120}");
      AppMethodBeat.o(187160);
      return;
    }
  }
  
  private d(a parama, File paramFile, long paramLong, Executor paramExecutor)
  {
    AppMethodBeat.i(187038);
    this.size = 0L;
    this.ajOS = new LinkedHashMap(0, 0.75F, true);
    this.ajOX = 0L;
    this.ajMh = new Runnable()
    {
      /* Error */
      public final void run()
      {
        // Byte code:
        //   0: iconst_1
        //   1: istore_1
        //   2: ldc 22
        //   4: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   7: aload_0
        //   8: getfield 14	okhttp3/internal/a/d$1:ajOY	Lokhttp3/internal/a/d;
        //   11: astore_2
        //   12: aload_2
        //   13: monitorenter
        //   14: aload_0
        //   15: getfield 14	okhttp3/internal/a/d$1:ajOY	Lokhttp3/internal/a/d;
        //   18: getfield 32	okhttp3/internal/a/d:initialized	Z
        //   21: ifne +23 -> 44
        //   24: iload_1
        //   25: aload_0
        //   26: getfield 14	okhttp3/internal/a/d$1:ajOY	Lokhttp3/internal/a/d;
        //   29: getfield 35	okhttp3/internal/a/d:closed	Z
        //   32: ior
        //   33: ifeq +16 -> 49
        //   36: aload_2
        //   37: monitorexit
        //   38: ldc 22
        //   40: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   43: return
        //   44: iconst_0
        //   45: istore_1
        //   46: goto -22 -> 24
        //   49: aload_0
        //   50: getfield 14	okhttp3/internal/a/d$1:ajOY	Lokhttp3/internal/a/d;
        //   53: invokevirtual 41	okhttp3/internal/a/d:kHs	()V
        //   56: aload_0
        //   57: getfield 14	okhttp3/internal/a/d$1:ajOY	Lokhttp3/internal/a/d;
        //   60: invokevirtual 45	okhttp3/internal/a/d:kHr	()Z
        //   63: ifeq +18 -> 81
        //   66: aload_0
        //   67: getfield 14	okhttp3/internal/a/d$1:ajOY	Lokhttp3/internal/a/d;
        //   70: invokevirtual 48	okhttp3/internal/a/d:kHq	()V
        //   73: aload_0
        //   74: getfield 14	okhttp3/internal/a/d$1:ajOY	Lokhttp3/internal/a/d;
        //   77: iconst_0
        //   78: putfield 52	okhttp3/internal/a/d:ajOT	I
        //   81: aload_2
        //   82: monitorexit
        //   83: ldc 22
        //   85: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   88: return
        //   89: astore_3
        //   90: aload_0
        //   91: getfield 14	okhttp3/internal/a/d$1:ajOY	Lokhttp3/internal/a/d;
        //   94: iconst_1
        //   95: putfield 55	okhttp3/internal/a/d:ajOV	Z
        //   98: goto -42 -> 56
        //   101: astore_3
        //   102: aload_2
        //   103: monitorexit
        //   104: ldc 22
        //   106: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   109: aload_3
        //   110: athrow
        //   111: astore_3
        //   112: aload_0
        //   113: getfield 14	okhttp3/internal/a/d$1:ajOY	Lokhttp3/internal/a/d;
        //   116: iconst_1
        //   117: putfield 58	okhttp3/internal/a/d:ajOW	Z
        //   120: aload_0
        //   121: getfield 14	okhttp3/internal/a/d$1:ajOY	Lokhttp3/internal/a/d;
        //   124: invokestatic 64	j/q:kIX	()Lj/y;
        //   127: invokestatic 68	j/q:b	(Lj/y;)Lj/g;
        //   130: putfield 72	okhttp3/internal/a/d:ajOR	Lj/g;
        //   133: goto -52 -> 81
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	136	0	this	1
        //   1	45	1	i	int
        //   11	92	2	locald	d
        //   89	1	3	localIOException1	IOException
        //   101	9	3	localObject	Object
        //   111	1	3	localIOException2	IOException
        // Exception table:
        //   from	to	target	type
        //   49	56	89	java/io/IOException
        //   14	24	101	finally
        //   24	38	101	finally
        //   49	56	101	finally
        //   56	81	101	finally
        //   81	83	101	finally
        //   90	98	101	finally
        //   112	133	101	finally
        //   56	81	111	java/io/IOException
      }
    };
    this.ajOL = parama;
    this.ajOM = paramFile;
    this.appVersion = 201105;
    this.ajON = new File(paramFile, "journal");
    this.ajOO = new File(paramFile, "journal.tmp");
    this.ajOP = new File(paramFile, "journal.bkp");
    this.ajOQ = 2;
    this.cBA = paramLong;
    this.executor = paramExecutor;
    AppMethodBeat.o(187038);
  }
  
  public static d a(a parama, File paramFile, long paramLong)
  {
    AppMethodBeat.i(187067);
    if (paramLong <= 0L)
    {
      parama = new IllegalArgumentException("maxSize <= 0");
      AppMethodBeat.o(187067);
      throw parama;
    }
    parama = new d(parama, paramFile, paramLong, new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), c.threadFactory("OkHttp DiskLruCache", true)));
    AppMethodBeat.o(187067);
    return parama;
  }
  
  private static void bKF(String paramString)
  {
    AppMethodBeat.i(187151);
    if (!ajOK.matcher(paramString).matches())
    {
      paramString = new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + paramString + "\"");
      AppMethodBeat.o(187151);
      throw paramString;
    }
    AppMethodBeat.o(187151);
  }
  
  private void initialize()
  {
    try
    {
      AppMethodBeat.i(187058);
      if ((!$assertionsDisabled) && (!Thread.holdsLock(this)))
      {
        AssertionError localAssertionError = new AssertionError();
        AppMethodBeat.o(187058);
        throw localAssertionError;
      }
    }
    finally {}
    if (this.initialized) {
      AppMethodBeat.o(187058);
    }
    for (;;)
    {
      return;
      if (this.ajOL.aq(this.ajOP))
      {
        if (!this.ajOL.aq(this.ajON)) {
          break label139;
        }
        this.ajOL.ap(this.ajOP);
      }
      for (;;)
      {
        for (;;)
        {
          boolean bool = this.ajOL.aq(this.ajON);
          if (!bool) {
            break label226;
          }
          try
          {
            kHn();
            kHp();
            this.initialized = true;
            AppMethodBeat.o(187058);
          }
          catch (IOException localIOException)
          {
            label139:
            okhttp3.internal.g.g.kIq().g(5, "DiskLruCache " + this.ajOM + " is corrupt: " + localIOException.getMessage() + ", removing", localIOException);
          }
        }
        this.ajOL.g(this.ajOP, this.ajON);
      }
      try
      {
        close();
        this.ajOL.as(this.ajOM);
        this.closed = false;
        label226:
        kHq();
        this.initialized = true;
        AppMethodBeat.o(187058);
      }
      finally
      {
        this.closed = false;
        AppMethodBeat.o(187058);
      }
    }
  }
  
  private boolean isClosed()
  {
    try
    {
      boolean bool = this.closed;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void kHn()
  {
    AppMethodBeat.i(187112);
    h localh = q.b(this.ajOL.am(this.ajON));
    Object localObject4;
    Object localObject5;
    String str1;
    try
    {
      Object localObject1 = localh.kIH();
      localObject4 = localh.kIH();
      localObject5 = localh.kIH();
      str1 = localh.kIH();
      String str2 = localh.kIH();
      if ((!"libcore.io.DiskLruCache".equals(localObject1)) || (!"1".equals(localObject4)) || (!Integer.toString(this.appVersion).equals(localObject5)) || (!Integer.toString(this.ajOQ).equals(str1)) || (!"".equals(str2)))
      {
        localObject1 = new IOException("unexpected journal header: [" + (String)localObject1 + ", " + (String)localObject4 + ", " + str1 + ", " + str2 + "]");
        AppMethodBeat.o(187112);
        throw ((Throwable)localObject1);
      }
    }
    finally
    {
      c.closeQuietly(localh);
      AppMethodBeat.o(187112);
    }
    int i = 0;
    for (;;)
    {
      try
      {
        str1 = localh.kIH();
        j = str1.indexOf(' ');
        if (j == -1)
        {
          IOException localIOException = new IOException("unexpected journal line: ".concat(String.valueOf(str1)));
          AppMethodBeat.o(187112);
          throw localIOException;
        }
      }
      catch (EOFException localEOFException)
      {
        int j;
        this.ajOT = (i - this.ajOS.size());
        if (!localh.kIy())
        {
          kHq();
          c.closeQuietly(localh);
          AppMethodBeat.o(187112);
          return;
          int k = j + 1;
          int m = str1.indexOf(' ', k);
          Object localObject3;
          if (m == -1)
          {
            localObject3 = str1.substring(k);
            if ((j == 6) && (str1.startsWith("REMOVE")))
            {
              this.ajOS.remove(localObject3);
              continue;
            }
          }
          else
          {
            localObject3 = str1.substring(k, m);
            localObject5 = (b)this.ajOS.get(localObject3);
            localObject4 = localObject5;
            if (localObject5 == null)
            {
              localObject4 = new b((String)localObject3);
              this.ajOS.put(localObject3, localObject4);
            }
            if ((m != -1) && (j == 5) && (str1.startsWith("CLEAN")))
            {
              localObject3 = str1.substring(m + 1).split(" ");
              ((b)localObject4).readable = true;
              ((b)localObject4).ajPf = null;
              ((b)localObject4).at((String[])localObject3);
              continue;
            }
            if ((m == -1) && (j == 5) && (str1.startsWith("DIRTY")))
            {
              ((b)localObject4).ajPf = new a((b)localObject4);
              continue;
            }
            if ((m == -1) && (j == 4) && (str1.startsWith("READ"))) {
              continue;
            }
            localObject3 = new IOException("unexpected journal line: ".concat(String.valueOf(str1)));
            AppMethodBeat.o(187112);
            throw ((Throwable)localObject3);
          }
        }
        else
        {
          this.ajOR = kHo();
          continue;
        }
        continue;
        i += 1;
      }
    }
  }
  
  private j.g kHo()
  {
    AppMethodBeat.i(187124);
    j.g localg = q.b(new e(this.ajOL.ao(this.ajON))
    {
      static
      {
        AppMethodBeat.i(187070);
        if (!d.class.desiredAssertionStatus()) {}
        for (boolean bool = true;; bool = false)
        {
          $assertionsDisabled = bool;
          AppMethodBeat.o(187070);
          return;
        }
      }
      
      protected final void kHt()
      {
        AppMethodBeat.i(187077);
        if ((!$assertionsDisabled) && (!Thread.holdsLock(d.this)))
        {
          AssertionError localAssertionError = new AssertionError();
          AppMethodBeat.o(187077);
          throw localAssertionError;
        }
        d.this.ajOU = true;
        AppMethodBeat.o(187077);
      }
    });
    AppMethodBeat.o(187124);
    return localg;
  }
  
  private void kHp()
  {
    AppMethodBeat.i(187139);
    this.ajOL.ap(this.ajOO);
    Iterator localIterator = this.ajOS.values().iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      int i;
      if (localb.ajPf == null)
      {
        i = 0;
        while (i < this.ajOQ)
        {
          this.size += localb.ajPc[i];
          i += 1;
        }
      }
      else
      {
        localb.ajPf = null;
        i = 0;
        while (i < this.ajOQ)
        {
          this.ajOL.ap(localb.ajPd[i]);
          this.ajOL.ap(localb.ajPe[i]);
          i += 1;
        }
        localIterator.remove();
      }
    }
    AppMethodBeat.o(187139);
  }
  
  private void kcl()
  {
    try
    {
      AppMethodBeat.i(187144);
      if (isClosed())
      {
        IllegalStateException localIllegalStateException = new IllegalStateException("cache is closed");
        AppMethodBeat.o(187144);
        throw localIllegalStateException;
      }
    }
    finally {}
    AppMethodBeat.o(187144);
  }
  
  final void a(a parama, boolean paramBoolean)
  {
    int k = 0;
    b localb;
    try
    {
      AppMethodBeat.i(187188);
      localb = parama.ajOZ;
      if (localb.ajPf != parama)
      {
        parama = new IllegalStateException();
        AppMethodBeat.o(187188);
        throw parama;
      }
    }
    finally {}
    int j = k;
    if (paramBoolean)
    {
      j = k;
      if (!localb.readable)
      {
        int i = 0;
        for (;;)
        {
          j = k;
          if (i >= this.ajOQ) {
            break;
          }
          if (parama.ajPa[i] == 0)
          {
            parama.Fw();
            parama = new IllegalStateException("Newly created entry didn't create value for index ".concat(String.valueOf(i)));
            AppMethodBeat.o(187188);
            throw parama;
          }
          if (!this.ajOL.aq(localb.ajPe[i]))
          {
            parama.Fw();
            AppMethodBeat.o(187188);
            return;
          }
          i += 1;
        }
      }
    }
    for (;;)
    {
      long l1;
      if (j < this.ajOQ)
      {
        parama = localb.ajPe[j];
        if (paramBoolean)
        {
          if (this.ajOL.aq(parama))
          {
            File localFile = localb.ajPd[j];
            this.ajOL.g(parama, localFile);
            l1 = localb.ajPc[j];
            long l2 = this.ajOL.ar(localFile);
            localb.ajPc[j] = l2;
            this.size = (this.size - l1 + l2);
          }
        }
        else {
          this.ajOL.ap(parama);
        }
      }
      else
      {
        this.ajOT += 1;
        localb.ajPf = null;
        if ((localb.readable | paramBoolean))
        {
          localb.readable = true;
          this.ajOR.bKR("CLEAN").aNh(32);
          this.ajOR.bKR(localb.key);
          localb.b(this.ajOR);
          this.ajOR.aNh(10);
          if (paramBoolean)
          {
            l1 = this.ajOX;
            this.ajOX = (1L + l1);
            localb.ahCm = l1;
          }
        }
        for (;;)
        {
          this.ajOR.flush();
          if ((this.size > this.cBA) || (kHr())) {
            this.executor.execute(this.ajMh);
          }
          AppMethodBeat.o(187188);
          break;
          this.ajOS.remove(localb.key);
          this.ajOR.bKR("REMOVE").aNh(32);
          this.ajOR.bKR(localb.key);
          this.ajOR.aNh(10);
        }
      }
      j += 1;
    }
  }
  
  final boolean a(b paramb)
  {
    AppMethodBeat.i(187200);
    if (paramb.ajPf != null) {
      paramb.ajPf.detach();
    }
    int i = 0;
    while (i < this.ajOQ)
    {
      this.ajOL.ap(paramb.ajPd[i]);
      this.size -= paramb.ajPc[i];
      paramb.ajPc[i] = 0L;
      i += 1;
    }
    this.ajOT += 1;
    this.ajOR.bKR("REMOVE").aNh(32).bKR(paramb.key).aNh(10);
    this.ajOS.remove(paramb.key);
    if (kHr()) {
      this.executor.execute(this.ajMh);
    }
    AppMethodBeat.o(187200);
    return true;
  }
  
  /* Error */
  public final c bKE(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 510
    //   5: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: invokespecial 512	okhttp3/internal/a/d:initialize	()V
    //   12: aload_0
    //   13: invokespecial 514	okhttp3/internal/a/d:kcl	()V
    //   16: aload_1
    //   17: invokestatic 516	okhttp3/internal/a/d:bKF	(Ljava/lang/String;)V
    //   20: aload_0
    //   21: getfield 102	okhttp3/internal/a/d:ajOS	Ljava/util/LinkedHashMap;
    //   24: aload_1
    //   25: invokevirtual 356	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   28: checkcast 19	okhttp3/internal/a/d$b
    //   31: astore_2
    //   32: aload_2
    //   33: ifnull +10 -> 43
    //   36: aload_2
    //   37: getfield 374	okhttp3/internal/a/d$b:readable	Z
    //   40: ifne +15 -> 55
    //   43: ldc_w 510
    //   46: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   49: aconst_null
    //   50: astore_1
    //   51: aload_0
    //   52: monitorexit
    //   53: aload_1
    //   54: areturn
    //   55: aload_2
    //   56: invokevirtual 520	okhttp3/internal/a/d$b:kHu	()Lokhttp3/internal/a/d$c;
    //   59: astore_2
    //   60: aload_2
    //   61: ifnonnull +14 -> 75
    //   64: ldc_w 510
    //   67: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   70: aconst_null
    //   71: astore_1
    //   72: goto -21 -> 51
    //   75: aload_0
    //   76: aload_0
    //   77: getfield 331	okhttp3/internal/a/d:ajOT	I
    //   80: iconst_1
    //   81: iadd
    //   82: putfield 331	okhttp3/internal/a/d:ajOT	I
    //   85: aload_0
    //   86: getfield 395	okhttp3/internal/a/d:ajOR	Lj/g;
    //   89: ldc_w 389
    //   92: invokeinterface 476 2 0
    //   97: bipush 32
    //   99: invokeinterface 480 2 0
    //   104: aload_1
    //   105: invokeinterface 476 2 0
    //   110: bipush 10
    //   112: invokeinterface 480 2 0
    //   117: pop
    //   118: aload_0
    //   119: invokevirtual 496	okhttp3/internal/a/d:kHr	()Z
    //   122: ifeq +16 -> 138
    //   125: aload_0
    //   126: getfield 139	okhttp3/internal/a/d:executor	Ljava/util/concurrent/Executor;
    //   129: aload_0
    //   130: getfield 109	okhttp3/internal/a/d:ajMh	Ljava/lang/Runnable;
    //   133: invokeinterface 502 2 0
    //   138: ldc_w 510
    //   141: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   144: aload_2
    //   145: astore_1
    //   146: goto -95 -> 51
    //   149: astore_1
    //   150: aload_0
    //   151: monitorexit
    //   152: aload_1
    //   153: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	154	0	this	d
    //   0	154	1	paramString	String
    //   31	114	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	32	149	finally
    //   36	43	149	finally
    //   43	49	149	finally
    //   55	60	149	finally
    //   64	70	149	finally
    //   75	138	149	finally
    //   138	144	149	finally
  }
  
  public final a cJ(String paramString, long paramLong)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(187186);
        initialize();
        kcl();
        bKF(paramString);
        Object localObject = (b)this.ajOS.get(paramString);
        if ((paramLong != -1L) && ((localObject == null) || (((b)localObject).ahCm != paramLong)))
        {
          AppMethodBeat.o(187186);
          paramString = null;
          return paramString;
        }
        if ((localObject != null) && (((b)localObject).ajPf != null))
        {
          AppMethodBeat.o(187186);
          paramString = null;
        }
        else if ((this.ajOV) || (this.ajOW))
        {
          this.executor.execute(this.ajMh);
          AppMethodBeat.o(187186);
          paramString = null;
        }
        else
        {
          this.ajOR.bKR("DIRTY").aNh(32).bKR(paramString).aNh(10);
          this.ajOR.flush();
          if (this.ajOU)
          {
            AppMethodBeat.o(187186);
            paramString = null;
          }
          else if (localObject == null)
          {
            localObject = new b(paramString);
            this.ajOS.put(paramString, localObject);
            paramString = (String)localObject;
            localObject = new a(paramString);
            paramString.ajPf = ((a)localObject);
            AppMethodBeat.o(187186);
            paramString = (String)localObject;
          }
          else
          {
            paramString = (String)localObject;
          }
        }
      }
      finally {}
    }
  }
  
  public final void close()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(187208);
        if ((!this.initialized) || (this.closed))
        {
          this.closed = true;
          AppMethodBeat.o(187208);
          return;
        }
        b[] arrayOfb = (b[])this.ajOS.values().toArray(new b[this.ajOS.size()]);
        int j = arrayOfb.length;
        int i = 0;
        if (i < j)
        {
          b localb = arrayOfb[i];
          if (localb.ajPf != null) {
            localb.ajPf.Fw();
          }
        }
        else
        {
          kHs();
          this.ajOR.close();
          this.ajOR = null;
          this.closed = true;
          AppMethodBeat.o(187208);
          continue;
        }
        i += 1;
      }
      finally {}
    }
  }
  
  /* Error */
  public final void flush()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 543
    //   5: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 215	okhttp3/internal/a/d:initialized	Z
    //   12: ifne +12 -> 24
    //   15: ldc_w 543
    //   18: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: invokespecial 514	okhttp3/internal/a/d:kcl	()V
    //   28: aload_0
    //   29: invokevirtual 541	okhttp3/internal/a/d:kHs	()V
    //   32: aload_0
    //   33: getfield 395	okhttp3/internal/a/d:ajOR	Lj/g;
    //   36: invokeinterface 493 1 0
    //   41: ldc_w 543
    //   44: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   47: goto -26 -> 21
    //   50: astore_1
    //   51: aload_0
    //   52: monitorexit
    //   53: aload_1
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	this	d
    //   50	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	21	50	finally
    //   24	47	50	finally
  }
  
  final void kHq()
  {
    for (;;)
    {
      b localb;
      try
      {
        AppMethodBeat.i(187177);
        if (this.ajOR != null) {
          this.ajOR.close();
        }
        j.g localg1 = q.b(this.ajOL.an(this.ajOO));
        try
        {
          localg1.bKR("libcore.io.DiskLruCache").aNh(10);
          localg1.bKR("1").aNh(10);
          localg1.Ck(this.appVersion).aNh(10);
          localg1.Ck(this.ajOQ).aNh(10);
          localg1.aNh(10);
          Iterator localIterator = this.ajOS.values().iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          localb = (b)localIterator.next();
          if (localb.ajPf != null)
          {
            localg1.bKR("DIRTY").aNh(32);
            localg1.bKR(localb.key);
            localg1.aNh(10);
            continue;
            localg2 = finally;
          }
        }
        finally
        {
          localg1.close();
          AppMethodBeat.o(187177);
        }
        localg2.bKR("CLEAN").aNh(32);
      }
      finally {}
      localg2.bKR(localb.key);
      localb.b(localg2);
      localg2.aNh(10);
    }
    localg2.close();
    if (this.ajOL.aq(this.ajON)) {
      this.ajOL.g(this.ajON, this.ajOP);
    }
    this.ajOL.g(this.ajOO, this.ajON);
    this.ajOL.ap(this.ajOP);
    this.ajOR = kHo();
    this.ajOU = false;
    this.ajOW = false;
    AppMethodBeat.o(187177);
  }
  
  final boolean kHr()
  {
    AppMethodBeat.i(187192);
    if ((this.ajOT >= 2000) && (this.ajOT >= this.ajOS.size()))
    {
      AppMethodBeat.o(187192);
      return true;
    }
    AppMethodBeat.o(187192);
    return false;
  }
  
  final void kHs()
  {
    AppMethodBeat.i(187213);
    while (this.size > this.cBA) {
      a((b)this.ajOS.values().iterator().next());
    }
    this.ajOV = false;
    AppMethodBeat.o(187213);
  }
  
  /* Error */
  public final boolean remove(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 556
    //   5: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: invokespecial 512	okhttp3/internal/a/d:initialize	()V
    //   12: aload_0
    //   13: invokespecial 514	okhttp3/internal/a/d:kcl	()V
    //   16: aload_1
    //   17: invokestatic 516	okhttp3/internal/a/d:bKF	(Ljava/lang/String;)V
    //   20: aload_0
    //   21: getfield 102	okhttp3/internal/a/d:ajOS	Ljava/util/LinkedHashMap;
    //   24: aload_1
    //   25: invokevirtual 356	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   28: checkcast 19	okhttp3/internal/a/d$b
    //   31: astore_1
    //   32: aload_1
    //   33: ifnonnull +15 -> 48
    //   36: ldc_w 556
    //   39: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   42: iconst_0
    //   43: istore_2
    //   44: aload_0
    //   45: monitorexit
    //   46: iload_2
    //   47: ireturn
    //   48: aload_0
    //   49: aload_1
    //   50: invokevirtual 555	okhttp3/internal/a/d:a	(Lokhttp3/internal/a/d$b;)Z
    //   53: istore_2
    //   54: iload_2
    //   55: ifeq +20 -> 75
    //   58: aload_0
    //   59: getfield 94	okhttp3/internal/a/d:size	J
    //   62: aload_0
    //   63: getfield 137	okhttp3/internal/a/d:cBA	J
    //   66: lcmp
    //   67: ifgt +8 -> 75
    //   70: aload_0
    //   71: iconst_0
    //   72: putfield 527	okhttp3/internal/a/d:ajOV	Z
    //   75: ldc_w 556
    //   78: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   81: goto -37 -> 44
    //   84: astore_1
    //   85: aload_0
    //   86: monitorexit
    //   87: aload_1
    //   88: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	this	d
    //   0	89	1	paramString	String
    //   43	12	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	32	84	finally
    //   36	42	84	finally
    //   48	54	84	finally
    //   58	75	84	finally
    //   75	81	84	finally
  }
  
  public final class a
  {
    final d.b ajOZ;
    final boolean[] ajPa;
    private boolean done;
    
    a(d.b paramb)
    {
      AppMethodBeat.i(187048);
      this.ajOZ = paramb;
      if (paramb.readable) {}
      for (this$1 = null;; this$1 = new boolean[d.this.ajOQ])
      {
        this.ajPa = d.this;
        AppMethodBeat.o(187048);
        return;
      }
    }
    
    public final void Fw()
    {
      AppMethodBeat.i(187093);
      synchronized (d.this)
      {
        if (this.done)
        {
          IllegalStateException localIllegalStateException = new IllegalStateException();
          AppMethodBeat.o(187093);
          throw localIllegalStateException;
        }
      }
      if (this.ajOZ.ajPf == this) {
        d.this.a(this, false);
      }
      this.done = true;
      AppMethodBeat.o(187093);
    }
    
    public final y aMU(int paramInt)
    {
      AppMethodBeat.i(187071);
      synchronized (d.this)
      {
        if (this.done)
        {
          IllegalStateException localIllegalStateException = new IllegalStateException();
          AppMethodBeat.o(187071);
          throw localIllegalStateException;
        }
      }
      if (this.ajOZ.ajPf != this)
      {
        localObject2 = q.kIX();
        AppMethodBeat.o(187071);
        return localObject2;
      }
      if (!this.ajOZ.readable) {
        this.ajPa[paramInt] = true;
      }
      Object localObject2 = this.ajOZ.ajPe[paramInt];
      try
      {
        localObject2 = d.this.ajOL.an((File)localObject2);
        localObject2 = new e((y)localObject2)
        {
          protected final void kHt()
          {
            AppMethodBeat.i(187061);
            synchronized (d.this)
            {
              d.a.this.detach();
              AppMethodBeat.o(187061);
              return;
            }
          }
        };
        AppMethodBeat.o(187071);
        return localObject2;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        y localy = q.kIX();
        AppMethodBeat.o(187071);
        return localy;
      }
    }
    
    public final void commit()
    {
      AppMethodBeat.i(187085);
      synchronized (d.this)
      {
        if (this.done)
        {
          IllegalStateException localIllegalStateException = new IllegalStateException();
          AppMethodBeat.o(187085);
          throw localIllegalStateException;
        }
      }
      if (this.ajOZ.ajPf == this) {
        d.this.a(this, true);
      }
      this.done = true;
      AppMethodBeat.o(187085);
    }
    
    final void detach()
    {
      AppMethodBeat.i(187059);
      int i;
      if (this.ajOZ.ajPf == this) {
        i = 0;
      }
      for (;;)
      {
        if (i < d.this.ajOQ) {}
        try
        {
          d.this.ajOL.ap(this.ajOZ.ajPe[i]);
          label50:
          i += 1;
          continue;
          this.ajOZ.ajPf = null;
          AppMethodBeat.o(187059);
          return;
        }
        catch (IOException localIOException)
        {
          break label50;
        }
      }
    }
  }
  
  final class b
  {
    long ahCm;
    final long[] ajPc;
    final File[] ajPd;
    final File[] ajPe;
    d.a ajPf;
    final String key;
    boolean readable;
    
    b(String paramString)
    {
      AppMethodBeat.i(187047);
      this.key = paramString;
      this.ajPc = new long[d.this.ajOQ];
      this.ajPd = new File[d.this.ajOQ];
      this.ajPe = new File[d.this.ajOQ];
      paramString = new StringBuilder(paramString).append('.');
      int j = paramString.length();
      int i = 0;
      while (i < d.this.ajOQ)
      {
        paramString.append(i);
        this.ajPd[i] = new File(d.this.ajOM, paramString.toString());
        paramString.append(".tmp");
        this.ajPe[i] = new File(d.this.ajOM, paramString.toString());
        paramString.setLength(j);
        i += 1;
      }
      AppMethodBeat.o(187047);
    }
    
    private static IOException au(String[] paramArrayOfString)
    {
      AppMethodBeat.i(187052);
      paramArrayOfString = new IOException("unexpected journal line: " + Arrays.toString(paramArrayOfString));
      AppMethodBeat.o(187052);
      throw paramArrayOfString;
    }
    
    final void at(String[] paramArrayOfString)
    {
      AppMethodBeat.i(187065);
      if (paramArrayOfString.length != d.this.ajOQ)
      {
        paramArrayOfString = au(paramArrayOfString);
        AppMethodBeat.o(187065);
        throw paramArrayOfString;
      }
      int i = 0;
      try
      {
        while (i < paramArrayOfString.length)
        {
          this.ajPc[i] = Long.parseLong(paramArrayOfString[i]);
          i += 1;
        }
        AppMethodBeat.o(187065);
        return;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        paramArrayOfString = au(paramArrayOfString);
        AppMethodBeat.o(187065);
        throw paramArrayOfString;
      }
    }
    
    final void b(j.g paramg)
    {
      AppMethodBeat.i(187072);
      long[] arrayOfLong = this.ajPc;
      int j = arrayOfLong.length;
      int i = 0;
      while (i < j)
      {
        long l = arrayOfLong[i];
        paramg.aNh(32).Ck(l);
        i += 1;
      }
      AppMethodBeat.o(187072);
    }
    
    final d.c kHu()
    {
      j = 0;
      AppMethodBeat.i(187090);
      if (!Thread.holdsLock(d.this))
      {
        localObject1 = new AssertionError();
        AppMethodBeat.o(187090);
        throw ((Throwable)localObject1);
      }
      Object localObject1 = new aa[d.this.ajOQ];
      Object localObject2 = (long[])this.ajPc.clone();
      i = 0;
      for (;;)
      {
        try
        {
          if (i < d.this.ajOQ)
          {
            localObject1[i] = d.this.ajOL.am(this.ajPd[i]);
            i += 1;
            continue;
          }
          localObject2 = new d.c(d.this, this.key, this.ahCm, (aa[])localObject1, (long[])localObject2);
          AppMethodBeat.o(187090);
          return localObject2;
        }
        catch (FileNotFoundException localFileNotFoundException)
        {
          i = j;
          continue;
        }
        if ((i >= d.this.ajOQ) || (localObject1[i] == null)) {
          continue;
        }
        c.closeQuietly(localObject1[i]);
        i += 1;
      }
      try
      {
        d.this.a(this);
        label167:
        AppMethodBeat.o(187090);
        return null;
      }
      catch (IOException localIOException)
      {
        break label167;
      }
    }
  }
  
  public final class c
    implements Closeable
  {
    public final long ahCm;
    private final long[] ajPc;
    public final aa[] ajPg;
    public final String key;
    
    c(String paramString, long paramLong, aa[] paramArrayOfaa, long[] paramArrayOfLong)
    {
      this.key = paramString;
      this.ahCm = paramLong;
      this.ajPg = paramArrayOfaa;
      this.ajPc = paramArrayOfLong;
    }
    
    public final void close()
    {
      AppMethodBeat.i(187054);
      aa[] arrayOfaa = this.ajPg;
      int j = arrayOfaa.length;
      int i = 0;
      while (i < j)
      {
        c.closeQuietly(arrayOfaa[i]);
        i += 1;
      }
      AppMethodBeat.o(187054);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     okhttp3.internal.a.d
 * JD-Core Version:    0.7.0.1
 */