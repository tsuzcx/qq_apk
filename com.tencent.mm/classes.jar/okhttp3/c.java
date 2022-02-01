package okhttp3;

import com.tencent.matrix.trace.core.AppMethodBeat;
import j.i;
import j.j;
import j.y;
import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import okhttp3.internal.a.b;
import okhttp3.internal.a.d;
import okhttp3.internal.a.d.a;
import okhttp3.internal.a.d.c;
import okhttp3.internal.c.e;
import okhttp3.internal.f.a;

public final class c
  implements Closeable, Flushable
{
  final okhttp3.internal.a.f ajIY;
  final d ajIZ;
  int ajJa;
  int ajJb;
  private int ajJc;
  private int hitCount;
  private int wrD;
  
  public c(File paramFile, long paramLong)
  {
    this(paramFile, paramLong, a.ajSf);
  }
  
  private c(File paramFile, long paramLong, a parama)
  {
    AppMethodBeat.i(186607);
    this.ajIY = new okhttp3.internal.a.f()
    {
      public final b a(z paramAnonymousz)
      {
        AppMethodBeat.i(186563);
        paramAnonymousz = c.this.a(paramAnonymousz);
        AppMethodBeat.o(186563);
        return paramAnonymousz;
      }
      
      public final z a(x paramAnonymousx)
      {
        AppMethodBeat.i(186556);
        paramAnonymousx = c.this.a(paramAnonymousx);
        AppMethodBeat.o(186556);
        return paramAnonymousx;
      }
      
      public final void a(okhttp3.internal.a.c paramAnonymousc)
      {
        AppMethodBeat.i(186594);
        c.this.a(paramAnonymousc);
        AppMethodBeat.o(186594);
      }
      
      public final void a(z paramAnonymousz1, z paramAnonymousz2)
      {
        AppMethodBeat.i(186577);
        c.c localc = new c.c(paramAnonymousz2);
        paramAnonymousz2 = ((c.b)paramAnonymousz1.ajNR).ajJk;
        paramAnonymousz1 = null;
        try
        {
          paramAnonymousz2 = paramAnonymousz2.ajOY.cJ(paramAnonymousz2.key, paramAnonymousz2.ahCm);
          if (paramAnonymousz2 != null)
          {
            paramAnonymousz1 = paramAnonymousz2;
            localc.b(paramAnonymousz2);
            paramAnonymousz1 = paramAnonymousz2;
            paramAnonymousz2.commit();
          }
          AppMethodBeat.o(186577);
          return;
        }
        catch (IOException paramAnonymousz2)
        {
          c.a(paramAnonymousz1);
          AppMethodBeat.o(186577);
        }
      }
      
      public final void b(x paramAnonymousx)
      {
        AppMethodBeat.i(186569);
        c.this.b(paramAnonymousx);
        AppMethodBeat.o(186569);
      }
      
      public final void kGx()
      {
        AppMethodBeat.i(186586);
        c.this.kGx();
        AppMethodBeat.o(186586);
      }
    };
    this.ajIZ = d.a(parama, paramFile, paramLong);
    AppMethodBeat.o(186607);
  }
  
  private static String a(r paramr)
  {
    AppMethodBeat.i(186612);
    paramr = i.bKT(paramr.toString()).bKS("MD5").kIL();
    AppMethodBeat.o(186612);
    return paramr;
  }
  
  static void a(d.a parama)
  {
    AppMethodBeat.i(186615);
    if (parama != null) {}
    try
    {
      parama.Fw();
      AppMethodBeat.o(186615);
      return;
    }
    catch (IOException parama)
    {
      AppMethodBeat.o(186615);
    }
  }
  
  static int b(j.h paramh)
  {
    AppMethodBeat.i(186623);
    long l;
    try
    {
      l = paramh.kIE();
      paramh = paramh.kIH();
      if ((l < 0L) || (l > 2147483647L) || (!paramh.isEmpty()))
      {
        paramh = new IOException("expected an int but was \"" + l + paramh + "\"");
        AppMethodBeat.o(186623);
        throw paramh;
      }
    }
    catch (NumberFormatException paramh)
    {
      paramh = new IOException(paramh.getMessage());
      AppMethodBeat.o(186623);
      throw paramh;
    }
    int i = (int)l;
    AppMethodBeat.o(186623);
    return i;
  }
  
  /* Error */
  final b a(z paramz)
  {
    // Byte code:
    //   0: ldc 145
    //   2: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: getfield 151	okhttp3/z:ajNQ	Lokhttp3/x;
    //   9: getfield 157	okhttp3/x:method	Ljava/lang/String;
    //   12: astore_2
    //   13: aload_1
    //   14: getfield 151	okhttp3/z:ajNQ	Lokhttp3/x;
    //   17: getfield 157	okhttp3/x:method	Ljava/lang/String;
    //   20: invokestatic 163	okhttp3/internal/c/f:bKG	(Ljava/lang/String;)Z
    //   23: ifeq +18 -> 41
    //   26: aload_0
    //   27: aload_1
    //   28: getfield 151	okhttp3/z:ajNQ	Lokhttp3/x;
    //   31: invokevirtual 166	okhttp3/c:b	(Lokhttp3/x;)V
    //   34: ldc 145
    //   36: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   39: aconst_null
    //   40: areturn
    //   41: aload_2
    //   42: ldc 168
    //   44: invokevirtual 172	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   47: ifne +10 -> 57
    //   50: ldc 145
    //   52: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   55: aconst_null
    //   56: areturn
    //   57: aload_1
    //   58: invokestatic 178	okhttp3/internal/c/e:g	(Lokhttp3/z;)Z
    //   61: ifeq +10 -> 71
    //   64: ldc 145
    //   66: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   69: aconst_null
    //   70: areturn
    //   71: new 22	okhttp3/c$c
    //   74: dup
    //   75: aload_1
    //   76: invokespecial 181	okhttp3/c$c:<init>	(Lokhttp3/z;)V
    //   79: astore_2
    //   80: aload_0
    //   81: getfield 67	okhttp3/c:ajIZ	Lokhttp3/internal/a/d;
    //   84: aload_1
    //   85: getfield 151	okhttp3/z:ajNQ	Lokhttp3/x;
    //   88: getfield 185	okhttp3/x:ajIN	Lokhttp3/r;
    //   91: invokestatic 187	okhttp3/c:a	(Lokhttp3/r;)Ljava/lang/String;
    //   94: ldc2_w 188
    //   97: invokevirtual 193	okhttp3/internal/a/d:cJ	(Ljava/lang/String;J)Lokhttp3/internal/a/d$a;
    //   100: astore_1
    //   101: aload_1
    //   102: ifnonnull +10 -> 112
    //   105: ldc 145
    //   107: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   110: aconst_null
    //   111: areturn
    //   112: aload_2
    //   113: aload_1
    //   114: invokevirtual 195	okhttp3/c$c:b	(Lokhttp3/internal/a/d$a;)V
    //   117: new 12	okhttp3/c$a
    //   120: dup
    //   121: aload_0
    //   122: aload_1
    //   123: invokespecial 198	okhttp3/c$a:<init>	(Lokhttp3/c;Lokhttp3/internal/a/d$a;)V
    //   126: astore_2
    //   127: ldc 145
    //   129: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   132: aload_2
    //   133: areturn
    //   134: astore_1
    //   135: aconst_null
    //   136: astore_1
    //   137: aload_1
    //   138: invokestatic 200	okhttp3/c:a	(Lokhttp3/internal/a/d$a;)V
    //   141: ldc 145
    //   143: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   146: aconst_null
    //   147: areturn
    //   148: astore_2
    //   149: goto -12 -> 137
    //   152: astore_1
    //   153: goto -119 -> 34
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	156	0	this	c
    //   0	156	1	paramz	z
    //   12	121	2	localObject	Object
    //   148	1	2	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   80	101	134	java/io/IOException
    //   112	127	148	java/io/IOException
    //   26	34	152	java/io/IOException
  }
  
  final z a(x paramx)
  {
    int i = 1;
    AppMethodBeat.i(186656);
    Object localObject1 = a(paramx.ajIN);
    d.c localc;
    try
    {
      localc = this.ajIZ.bKE((String)localObject1);
      if (localc == null)
      {
        AppMethodBeat.o(186656);
        return null;
      }
    }
    catch (IOException paramx)
    {
      AppMethodBeat.o(186656);
      return null;
    }
    c localc1;
    String str1;
    String str2;
    x.a locala;
    Object localObject2;
    try
    {
      localc1 = new c(localc.ajPg[0]);
      str1 = localc1.ajJt.get("Content-Type");
      str2 = localc1.ajJt.get("Content-Length");
      locala = new x.a();
      localObject2 = localc1.url;
      if (localObject2 == null)
      {
        paramx = new NullPointerException("url == null");
        AppMethodBeat.o(186656);
        throw paramx;
      }
    }
    catch (IOException paramx)
    {
      okhttp3.internal.c.closeQuietly(localc);
      AppMethodBeat.o(186656);
      return null;
    }
    if (((String)localObject2).regionMatches(true, 0, "ws:", 0, 3))
    {
      localObject1 = "http:" + ((String)localObject2).substring(3);
      localObject1 = locala.b(r.bKr((String)localObject1)).a(localc1.sCY, null).c(localc1.ajJr).kHh();
      localObject2 = new z.a();
      ((z.a)localObject2).ajNQ = ((x)localObject1);
      ((z.a)localObject2).ajJs = localc1.ajJs;
      ((z.a)localObject2).code = localc1.code;
      ((z.a)localObject2).message = localc1.message;
      localObject1 = ((z.a)localObject2).d(localc1.ajJt);
      ((z.a)localObject1).ajNR = new b(localc, str1, str2);
      ((z.a)localObject1).ajJu = localc1.ajJu;
      ((z.a)localObject1).ajNV = localc1.ajJv;
      ((z.a)localObject1).ajNW = localc1.ajJw;
      localObject1 = ((z.a)localObject1).kHj();
      if ((!localc1.url.equals(paramx.ajIN.toString())) || (!localc1.sCY.equals(paramx.method)) || (!e.a((z)localObject1, localc1.ajJr, paramx))) {
        break label415;
      }
    }
    for (;;)
    {
      if (i != 0) {
        break label420;
      }
      okhttp3.internal.c.closeQuietly(((z)localObject1).ajNR);
      AppMethodBeat.o(186656);
      return null;
      localObject1 = localObject2;
      if (!((String)localObject2).regionMatches(true, 0, "wss:", 0, 4)) {
        break;
      }
      localObject1 = "https:" + ((String)localObject2).substring(4);
      break;
      label415:
      i = 0;
    }
    label420:
    AppMethodBeat.o(186656);
    return localObject1;
  }
  
  /* Error */
  final void a(okhttp3.internal.a.c paramc)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_0
    //   4: getfield 342	okhttp3/c:wrD	I
    //   7: iconst_1
    //   8: iadd
    //   9: putfield 342	okhttp3/c:wrD	I
    //   12: aload_1
    //   13: getfield 347	okhttp3/internal/a/c:ajOC	Lokhttp3/x;
    //   16: ifnull +16 -> 32
    //   19: aload_0
    //   20: aload_0
    //   21: getfield 349	okhttp3/c:ajJc	I
    //   24: iconst_1
    //   25: iadd
    //   26: putfield 349	okhttp3/c:ajJc	I
    //   29: aload_0
    //   30: monitorexit
    //   31: return
    //   32: aload_1
    //   33: getfield 353	okhttp3/internal/a/c:ajNT	Lokhttp3/z;
    //   36: ifnull -7 -> 29
    //   39: aload_0
    //   40: aload_0
    //   41: getfield 355	okhttp3/c:hitCount	I
    //   44: iconst_1
    //   45: iadd
    //   46: putfield 355	okhttp3/c:hitCount	I
    //   49: goto -20 -> 29
    //   52: astore_1
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_1
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	this	c
    //   0	57	1	paramc	okhttp3.internal.a.c
    // Exception table:
    //   from	to	target	type
    //   2	29	52	finally
    //   32	49	52	finally
  }
  
  final void b(x paramx)
  {
    AppMethodBeat.i(186674);
    this.ajIZ.remove(a(paramx.ajIN));
    AppMethodBeat.o(186674);
  }
  
  public final void close()
  {
    AppMethodBeat.i(186683);
    this.ajIZ.close();
    AppMethodBeat.o(186683);
  }
  
  public final void flush()
  {
    AppMethodBeat.i(186680);
    this.ajIZ.flush();
    AppMethodBeat.o(186680);
  }
  
  final void kGx()
  {
    try
    {
      this.hitCount += 1;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  final class a
    implements b
  {
    private final d.a ajJe;
    private y ajJf;
    private y ajJg;
    boolean done;
    
    a(final d.a parama)
    {
      AppMethodBeat.i(186536);
      this.ajJe = parama;
      this.ajJf = parama.aMU(1);
      this.ajJg = new j(this.ajJf)
      {
        public final void close()
        {
          AppMethodBeat.i(186564);
          synchronized (c.this)
          {
            if (c.a.this.done)
            {
              AppMethodBeat.o(186564);
              return;
            }
            c.a.this.done = true;
            c localc2 = c.this;
            localc2.ajJa += 1;
            super.close();
            parama.commit();
            AppMethodBeat.o(186564);
            return;
          }
        }
      };
      AppMethodBeat.o(186536);
    }
    
    public final void Fw()
    {
      AppMethodBeat.i(186539);
      synchronized (c.this)
      {
        if (this.done)
        {
          AppMethodBeat.o(186539);
          return;
        }
        this.done = true;
        c localc2 = c.this;
        localc2.ajJb += 1;
        okhttp3.internal.c.closeQuietly(this.ajJf);
      }
    }
    
    public final y kGy()
    {
      return this.ajJg;
    }
  }
  
  static final class b
    extends aa
  {
    final d.c ajJk;
    private final j.h ajJl;
    private final String ajJm;
    private final String contentType;
    
    b(final d.c paramc, String paramString1, String paramString2)
    {
      AppMethodBeat.i(186541);
      this.ajJk = paramc;
      this.contentType = paramString1;
      this.ajJm = paramString2;
      this.ajJl = j.q.b(new j.k(paramc.ajPg[1])
      {
        public final void close()
        {
          AppMethodBeat.i(186665);
          paramc.close();
          super.close();
          AppMethodBeat.o(186665);
        }
      });
      AppMethodBeat.o(186541);
    }
    
    public final long kGA()
    {
      AppMethodBeat.i(186549);
      try
      {
        if (this.ajJm != null)
        {
          long l = Long.parseLong(this.ajJm);
          AppMethodBeat.o(186549);
          return l;
        }
        AppMethodBeat.o(186549);
        return -1L;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        AppMethodBeat.o(186549);
      }
      return -1L;
    }
    
    public final j.h kGB()
    {
      return this.ajJl;
    }
    
    public final t kGz()
    {
      AppMethodBeat.i(186544);
      if (this.contentType != null)
      {
        t localt = t.bKt(this.contentType);
        AppMethodBeat.o(186544);
        return localt;
      }
      AppMethodBeat.o(186544);
      return null;
    }
  }
  
  static final class c
  {
    private static final String ajJp;
    private static final String ajJq;
    final q ajJr;
    final v ajJs;
    final q ajJt;
    final p ajJu;
    final long ajJv;
    final long ajJw;
    final int code;
    final String message;
    final String sCY;
    final String url;
    
    static
    {
      AppMethodBeat.i(186602);
      StringBuilder localStringBuilder = new StringBuilder();
      okhttp3.internal.g.g.kIq();
      ajJp = okhttp3.internal.g.g.getPrefix() + "-Sent-Millis";
      localStringBuilder = new StringBuilder();
      okhttp3.internal.g.g.kIq();
      ajJq = okhttp3.internal.g.g.getPrefix() + "-Received-Millis";
      AppMethodBeat.o(186602);
    }
    
    c(j.aa paramaa)
    {
      AppMethodBeat.i(186547);
      for (;;)
      {
        try
        {
          Object localObject1 = j.q.b(paramaa);
          this.url = ((j.h)localObject1).kIH();
          this.sCY = ((j.h)localObject1).kIH();
          localObject3 = new q.a();
          int k = c.b((j.h)localObject1);
          int i = 0;
          if (i < k)
          {
            ((q.a)localObject3).bKm(((j.h)localObject1).kIH());
            i += 1;
            continue;
          }
          this.ajJr = ((q.a)localObject3).kGM();
          localObject3 = okhttp3.internal.c.k.bKJ(((j.h)localObject1).kIH());
          this.ajJs = ((okhttp3.internal.c.k)localObject3).ajJs;
          this.code = ((okhttp3.internal.c.k)localObject3).code;
          this.message = ((okhttp3.internal.c.k)localObject3).message;
          localObject3 = new q.a();
          k = c.b((j.h)localObject1);
          i = j;
          if (i < k)
          {
            ((q.a)localObject3).bKm(((j.h)localObject1).kIH());
            i += 1;
            continue;
          }
          localObject4 = ((q.a)localObject3).get(ajJp);
          localObject5 = ((q.a)localObject3).get(ajJq);
          ((q.a)localObject3).bKn(ajJp);
          ((q.a)localObject3).bKn(ajJq);
          if (localObject4 != null)
          {
            l1 = Long.parseLong((String)localObject4);
            this.ajJv = l1;
            l1 = l2;
            if (localObject5 != null) {
              l1 = Long.parseLong((String)localObject5);
            }
            this.ajJw = l1;
            this.ajJt = ((q.a)localObject3).kGM();
            if (!isHttps()) {
              break label491;
            }
            localObject3 = ((j.h)localObject1).kIH();
            if (((String)localObject3).length() <= 0) {
              break;
            }
            localObject1 = new IOException("expected \"\" but was \"" + (String)localObject3 + "\"");
            AppMethodBeat.o(186547);
            throw ((Throwable)localObject1);
          }
        }
        finally
        {
          paramaa.close();
          AppMethodBeat.o(186547);
        }
        long l1 = 0L;
      }
      Object localObject3 = h.bKg(localh.kIH());
      Object localObject4 = c(localh);
      Object localObject5 = c(localh);
      if (!localh.kIy()) {}
      for (Object localObject2 = ac.bKx(localh.kIH()); localObject2 == null; localObject2 = ac.ajOf)
      {
        localObject2 = new NullPointerException("tlsVersion == null");
        AppMethodBeat.o(186547);
        throw ((Throwable)localObject2);
      }
      if (localObject3 == null)
      {
        localObject2 = new NullPointerException("cipherSuite == null");
        AppMethodBeat.o(186547);
        throw ((Throwable)localObject2);
      }
      label491:
      for (this.ajJu = new p((ac)localObject2, (h)localObject3, okhttp3.internal.c.pj((List)localObject4), okhttp3.internal.c.pj((List)localObject5));; this.ajJu = null)
      {
        paramaa.close();
        AppMethodBeat.o(186547);
        return;
      }
    }
    
    c(z paramz)
    {
      AppMethodBeat.i(186562);
      this.url = paramz.ajNQ.ajIN.toString();
      this.ajJr = e.h(paramz);
      this.sCY = paramz.ajNQ.method;
      this.ajJs = paramz.ajJs;
      this.code = paramz.code;
      this.message = paramz.message;
      this.ajJt = paramz.cnu;
      this.ajJu = paramz.ajJu;
      this.ajJv = paramz.ajNV;
      this.ajJw = paramz.ajNW;
      AppMethodBeat.o(186562);
    }
    
    private static void a(j.g paramg, List<Certificate> paramList)
    {
      AppMethodBeat.i(186593);
      try
      {
        paramg.Ck(paramList.size()).aNh(10);
        int j = paramList.size();
        int i = 0;
        while (i < j)
        {
          paramg.bKR(i.ef(((Certificate)paramList.get(i)).getEncoded()).kIK()).aNh(10);
          i += 1;
        }
        AppMethodBeat.o(186593);
        return;
      }
      catch (CertificateEncodingException paramg)
      {
        paramg = new IOException(paramg.getMessage());
        AppMethodBeat.o(186593);
        throw paramg;
      }
    }
    
    private static List<Certificate> c(j.h paramh)
    {
      AppMethodBeat.i(186584);
      int j = c.b(paramh);
      if (j == -1)
      {
        paramh = Collections.emptyList();
        AppMethodBeat.o(186584);
        return paramh;
      }
      try
      {
        CertificateFactory localCertificateFactory = CertificateFactory.getInstance("X.509");
        ArrayList localArrayList = new ArrayList(j);
        int i = 0;
        while (i < j)
        {
          String str = paramh.kIH();
          j.f localf = new j.f();
          localf.d(i.bKU(str));
          localArrayList.add(localCertificateFactory.generateCertificate(localf.kIA()));
          i += 1;
        }
        AppMethodBeat.o(186584);
        return localArrayList;
      }
      catch (CertificateException paramh)
      {
        paramh = new IOException(paramh.getMessage());
        AppMethodBeat.o(186584);
        throw paramh;
      }
    }
    
    private boolean isHttps()
    {
      AppMethodBeat.i(186568);
      boolean bool = this.url.startsWith("https://");
      AppMethodBeat.o(186568);
      return bool;
    }
    
    public final void b(d.a parama)
    {
      int j = 0;
      AppMethodBeat.i(186627);
      parama = j.q.b(parama.aMU(0));
      parama.bKR(this.url).aNh(10);
      parama.bKR(this.sCY).aNh(10);
      parama.Ck(this.ajJr.ajMS.length / 2).aNh(10);
      int k = this.ajJr.ajMS.length / 2;
      int i = 0;
      while (i < k)
      {
        parama.bKR(this.ajJr.aMS(i)).bKR(": ").bKR(this.ajJr.aMT(i)).aNh(10);
        i += 1;
      }
      parama.bKR(new okhttp3.internal.c.k(this.ajJs, this.code, this.message).toString()).aNh(10);
      parama.Ck(this.ajJt.ajMS.length / 2 + 2).aNh(10);
      k = this.ajJt.ajMS.length / 2;
      i = j;
      while (i < k)
      {
        parama.bKR(this.ajJt.aMS(i)).bKR(": ").bKR(this.ajJt.aMT(i)).aNh(10);
        i += 1;
      }
      parama.bKR(ajJp).bKR(": ").Ck(this.ajJv).aNh(10);
      parama.bKR(ajJq).bKR(": ").Ck(this.ajJw).aNh(10);
      if (isHttps())
      {
        parama.aNh(10);
        parama.bKR(this.ajJu.ajMP.ajMe).aNh(10);
        a(parama, this.ajJu.ajMQ);
        a(parama, this.ajJu.ajMR);
        parama.bKR(this.ajJu.ajMO.ajMe).aNh(10);
      }
      parama.close();
      AppMethodBeat.o(186627);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     okhttp3.c
 * JD-Core Version:    0.7.0.1
 */