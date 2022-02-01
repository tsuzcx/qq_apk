package okhttp3.internal.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import j.f;
import j.l;
import j.y;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.util.concurrent.TimeUnit;
import kotlin.g.b.s;
import okhttp3.internal.c.e;
import okhttp3.internal.c.i;
import okhttp3.internal.c.k;
import okhttp3.q.a;
import okhttp3.r;
import okhttp3.u;
import okhttp3.x;
import okhttp3.z;
import okhttp3.z.a;

public final class a
  implements okhttp3.internal.c.c
{
  final u ajNB;
  final okhttp3.internal.b.g ajPO;
  private long ajPS = 262144L;
  final j.g ajPn;
  final j.h cnO;
  int state = 0;
  
  public a(u paramu, okhttp3.internal.b.g paramg, j.h paramh, j.g paramg1)
  {
    this.ajNB = paramu;
    this.ajPO = paramg;
    this.cnO = paramh;
    this.ajPn = paramg1;
  }
  
  static void a(l paraml)
  {
    AppMethodBeat.i(186755);
    j.ab localab1 = paraml.ajTi;
    j.ab localab2 = j.ab.ajTJ;
    s.u(localab2, "delegate");
    paraml.ajTi = localab2;
    localab1.kIU();
    localab1.kIT();
    AppMethodBeat.o(186755);
  }
  
  private String kHF()
  {
    AppMethodBeat.i(186746);
    String str = this.cnO.Cg(this.ajPS);
    this.ajPS -= str.length();
    AppMethodBeat.o(186746);
    return str;
  }
  
  public final j.aa BY(long paramLong)
  {
    AppMethodBeat.i(186856);
    if (this.state != 4)
    {
      localObject = new IllegalStateException("state: " + this.state);
      AppMethodBeat.o(186856);
      throw ((Throwable)localObject);
    }
    this.state = 5;
    Object localObject = new e(paramLong);
    AppMethodBeat.o(186856);
    return localObject;
  }
  
  public final z.a PT(boolean paramBoolean)
  {
    AppMethodBeat.i(186846);
    Object localObject1;
    if ((this.state != 1) && (this.state != 3))
    {
      localObject1 = new IllegalStateException("state: " + this.state);
      AppMethodBeat.o(186846);
      throw ((Throwable)localObject1);
    }
    try
    {
      localObject1 = k.bKJ(kHF());
      localObject2 = new z.a();
      ((z.a)localObject2).ajJs = ((k)localObject1).ajJs;
      ((z.a)localObject2).code = ((k)localObject1).code;
      ((z.a)localObject2).message = ((k)localObject1).message;
      localObject2 = ((z.a)localObject2).d(kHG());
      if (paramBoolean)
      {
        int i = ((k)localObject1).code;
        if (i == 100)
        {
          AppMethodBeat.o(186846);
          return null;
        }
      }
      if (((k)localObject1).code == 100)
      {
        this.state = 3;
        AppMethodBeat.o(186846);
        return localObject2;
      }
      this.state = 4;
      AppMethodBeat.o(186846);
      return localObject2;
    }
    catch (EOFException localEOFException)
    {
      Object localObject2 = new IOException("unexpected end of stream on " + this.ajPO);
      ((IOException)localObject2).initCause(localEOFException);
      AppMethodBeat.o(186846);
      throw ((Throwable)localObject2);
    }
  }
  
  public final y a(x paramx, long paramLong)
  {
    AppMethodBeat.i(186765);
    if ("chunked".equalsIgnoreCase(paramx.bKv("Transfer-Encoding")))
    {
      if (this.state != 1)
      {
        paramx = new IllegalStateException("state: " + this.state);
        AppMethodBeat.o(186765);
        throw paramx;
      }
      this.state = 2;
      paramx = new b();
      AppMethodBeat.o(186765);
      return paramx;
    }
    if (paramLong != -1L)
    {
      if (this.state != 1)
      {
        paramx = new IllegalStateException("state: " + this.state);
        AppMethodBeat.o(186765);
        throw paramx;
      }
      this.state = 2;
      paramx = new d(paramLong);
      AppMethodBeat.o(186765);
      return paramx;
    }
    paramx = new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    AppMethodBeat.o(186765);
    throw paramx;
  }
  
  public final void a(okhttp3.q paramq, String paramString)
  {
    AppMethodBeat.i(186830);
    if (this.state != 0)
    {
      paramq = new IllegalStateException("state: " + this.state);
      AppMethodBeat.o(186830);
      throw paramq;
    }
    this.ajPn.bKR(paramString).bKR("\r\n");
    int i = 0;
    int j = paramq.ajMS.length / 2;
    while (i < j)
    {
      this.ajPn.bKR(paramq.aMS(i)).bKR(": ").bKR(paramq.aMT(i)).bKR("\r\n");
      i += 1;
    }
    this.ajPn.bKR("\r\n");
    this.state = 1;
    AppMethodBeat.o(186830);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(186770);
    okhttp3.internal.b.c localc = this.ajPO.kHA();
    if (localc != null) {
      okhttp3.internal.c.closeQuietly(localc.ajPl);
    }
    AppMethodBeat.o(186770);
  }
  
  public final void d(x paramx)
  {
    AppMethodBeat.i(186786);
    Object localObject = this.ajPO.kHA().ajPk.uuH.type();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramx.method);
    localStringBuilder.append(' ');
    int i;
    if ((!paramx.ajIN.isHttps()) && (localObject == Proxy.Type.HTTP))
    {
      i = 1;
      if (i == 0) {
        break label117;
      }
      localStringBuilder.append(paramx.ajIN);
    }
    for (;;)
    {
      localStringBuilder.append(" HTTP/1.1");
      localObject = localStringBuilder.toString();
      a(paramx.cnu, (String)localObject);
      AppMethodBeat.o(186786);
      return;
      i = 0;
      break;
      label117:
      localStringBuilder.append(i.d(paramx.ajIN));
    }
  }
  
  public final okhttp3.aa e(z paramz)
  {
    AppMethodBeat.i(186805);
    String str = paramz.bKv("Content-Type");
    if (!e.i(paramz))
    {
      paramz = new okhttp3.internal.c.h(str, 0L, j.q.b(BY(0L)));
      AppMethodBeat.o(186805);
      return paramz;
    }
    if ("chunked".equalsIgnoreCase(paramz.bKv("Transfer-Encoding")))
    {
      paramz = paramz.ajNQ.ajIN;
      if (this.state != 4)
      {
        paramz = new IllegalStateException("state: " + this.state);
        AppMethodBeat.o(186805);
        throw paramz;
      }
      this.state = 5;
      paramz = new okhttp3.internal.c.h(str, -1L, j.q.b(new c(paramz)));
      AppMethodBeat.o(186805);
      return paramz;
    }
    long l = e.f(paramz);
    if (l != -1L)
    {
      paramz = new okhttp3.internal.c.h(str, l, j.q.b(BY(l)));
      AppMethodBeat.o(186805);
      return paramz;
    }
    if (this.state != 4)
    {
      paramz = new IllegalStateException("state: " + this.state);
      AppMethodBeat.o(186805);
      throw paramz;
    }
    if (this.ajPO == null)
    {
      paramz = new IllegalStateException("streamAllocation == null");
      AppMethodBeat.o(186805);
      throw paramz;
    }
    this.state = 5;
    this.ajPO.kHB();
    paramz = new okhttp3.internal.c.h(str, -1L, j.q.b(new f()));
    AppMethodBeat.o(186805);
    return paramz;
  }
  
  public final void kHD()
  {
    AppMethodBeat.i(186815);
    this.ajPn.flush();
    AppMethodBeat.o(186815);
  }
  
  public final void kHE()
  {
    AppMethodBeat.i(186819);
    this.ajPn.flush();
    AppMethodBeat.o(186819);
  }
  
  public final okhttp3.q kHG()
  {
    AppMethodBeat.i(186850);
    Object localObject = new q.a();
    for (;;)
    {
      String str = kHF();
      if (str.length() == 0) {
        break;
      }
      okhttp3.internal.a.ajOh.a((q.a)localObject, str);
    }
    localObject = ((q.a)localObject).kGM();
    AppMethodBeat.o(186850);
    return localObject;
  }
  
  abstract class a
    implements j.aa
  {
    protected final l ajPT = new l(a.this.cnO.kHm());
    protected long bytesRead = 0L;
    protected boolean closed;
    
    private a() {}
    
    public long a(f paramf, long paramLong)
    {
      try
      {
        paramLong = a.this.cnO.a(paramf, paramLong);
        if (paramLong > 0L) {
          this.bytesRead += paramLong;
        }
        return paramLong;
      }
      catch (IOException paramf)
      {
        a(false, paramf);
        throw paramf;
      }
    }
    
    protected final void a(boolean paramBoolean, IOException paramIOException)
    {
      if (a.this.state == 6) {}
      do
      {
        return;
        if (a.this.state != 5) {
          throw new IllegalStateException("state: " + a.this.state);
        }
        a.a(this.ajPT);
        a.this.state = 6;
      } while (a.this.ajPO == null);
      okhttp3.internal.b.g localg = a.this.ajPO;
      if (!paramBoolean) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        localg.a(paramBoolean, a.this, paramIOException);
        return;
      }
    }
    
    public final j.ab kHm()
    {
      return this.ajPT;
    }
  }
  
  final class b
    implements y
  {
    private final l ajPT;
    private boolean closed;
    
    b()
    {
      AppMethodBeat.i(186748);
      this.ajPT = new l(a.this.ajPn.kHm());
      AppMethodBeat.o(186748);
    }
    
    public final void b(f paramf, long paramLong)
    {
      AppMethodBeat.i(186766);
      if (this.closed)
      {
        paramf = new IllegalStateException("closed");
        AppMethodBeat.o(186766);
        throw paramf;
      }
      if (paramLong == 0L)
      {
        AppMethodBeat.o(186766);
        return;
      }
      a.this.ajPn.Cm(paramLong);
      a.this.ajPn.bKR("\r\n");
      a.this.ajPn.b(paramf, paramLong);
      a.this.ajPn.bKR("\r\n");
      AppMethodBeat.o(186766);
    }
    
    /* Error */
    public final void close()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: ldc 74
      //   4: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   7: aload_0
      //   8: getfield 54	okhttp3/internal/d/a$b:closed	Z
      //   11: ifeq +11 -> 22
      //   14: ldc 74
      //   16: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   19: aload_0
      //   20: monitorexit
      //   21: return
      //   22: aload_0
      //   23: iconst_1
      //   24: putfield 54	okhttp3/internal/d/a$b:closed	Z
      //   27: aload_0
      //   28: getfield 19	okhttp3/internal/d/a$b:ajPU	Lokhttp3/internal/d/a;
      //   31: getfield 35	okhttp3/internal/d/a:ajPn	Lj/g;
      //   34: ldc 76
      //   36: invokeinterface 70 2 0
      //   41: pop
      //   42: aload_0
      //   43: getfield 46	okhttp3/internal/d/a$b:ajPT	Lj/l;
      //   46: invokestatic 80	okhttp3/internal/d/a:a	(Lj/l;)V
      //   49: aload_0
      //   50: getfield 19	okhttp3/internal/d/a$b:ajPU	Lokhttp3/internal/d/a;
      //   53: iconst_3
      //   54: putfield 84	okhttp3/internal/d/a:state	I
      //   57: ldc 74
      //   59: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   62: goto -43 -> 19
      //   65: astore_1
      //   66: aload_0
      //   67: monitorexit
      //   68: aload_1
      //   69: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	70	0	this	b
      //   65	4	1	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   2	19	65	finally
      //   22	62	65	finally
    }
    
    /* Error */
    public final void flush()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: ldc 86
      //   4: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   7: aload_0
      //   8: getfield 54	okhttp3/internal/d/a$b:closed	Z
      //   11: ifeq +11 -> 22
      //   14: ldc 86
      //   16: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   19: aload_0
      //   20: monitorexit
      //   21: return
      //   22: aload_0
      //   23: getfield 19	okhttp3/internal/d/a$b:ajPU	Lokhttp3/internal/d/a;
      //   26: getfield 35	okhttp3/internal/d/a:ajPn	Lj/g;
      //   29: invokeinterface 88 1 0
      //   34: ldc 86
      //   36: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   39: goto -20 -> 19
      //   42: astore_1
      //   43: aload_0
      //   44: monitorexit
      //   45: aload_1
      //   46: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	47	0	this	b
      //   42	4	1	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   2	19	42	finally
      //   22	39	42	finally
    }
    
    public final j.ab kHm()
    {
      return this.ajPT;
    }
  }
  
  final class c
    extends a.a
  {
    private final r ajIN;
    private long ajPV = -1L;
    private boolean ajPW = true;
    
    c(r paramr)
    {
      super((byte)0);
      this.ajIN = paramr;
    }
    
    public final long a(f paramf, long paramLong)
    {
      AppMethodBeat.i(186769);
      if (paramLong < 0L)
      {
        paramf = new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(paramLong)));
        AppMethodBeat.o(186769);
        throw paramf;
      }
      if (this.closed)
      {
        paramf = new IllegalStateException("closed");
        AppMethodBeat.o(186769);
        throw paramf;
      }
      if (!this.ajPW)
      {
        AppMethodBeat.o(186769);
        return -1L;
      }
      if ((this.ajPV == 0L) || (this.ajPV == -1L))
      {
        if (this.ajPV != -1L) {
          a.this.cnO.kIH();
        }
        try
        {
          this.ajPV = a.this.cnO.kIF();
          String str = a.this.cnO.kIH().trim();
          if ((this.ajPV < 0L) || ((!str.isEmpty()) && (!str.startsWith(";"))))
          {
            paramf = new ProtocolException("expected chunk size and optional extensions but was \"" + this.ajPV + str + "\"");
            AppMethodBeat.o(186769);
            throw paramf;
          }
        }
        catch (NumberFormatException paramf)
        {
          paramf = new ProtocolException(paramf.getMessage());
          AppMethodBeat.o(186769);
          throw paramf;
        }
        if (this.ajPV == 0L)
        {
          this.ajPW = false;
          e.a(a.this.ajNB.ajNk, this.ajIN, a.this.kHG());
          a(true, null);
        }
        if (!this.ajPW)
        {
          AppMethodBeat.o(186769);
          return -1L;
        }
      }
      paramLong = super.a(paramf, Math.min(paramLong, this.ajPV));
      if (paramLong == -1L)
      {
        paramf = new ProtocolException("unexpected end of stream");
        a(false, paramf);
        AppMethodBeat.o(186769);
        throw paramf;
      }
      this.ajPV -= paramLong;
      AppMethodBeat.o(186769);
      return paramLong;
    }
    
    public final void close()
    {
      AppMethodBeat.i(186778);
      if (this.closed)
      {
        AppMethodBeat.o(186778);
        return;
      }
      if ((this.ajPW) && (!okhttp3.internal.c.a(this, TimeUnit.MILLISECONDS))) {
        a(false, null);
      }
      this.closed = true;
      AppMethodBeat.o(186778);
    }
  }
  
  final class d
    implements y
  {
    private final l ajPT;
    private boolean closed;
    private long die;
    
    d(long paramLong)
    {
      AppMethodBeat.i(186751);
      this.ajPT = new l(a.this.ajPn.kHm());
      this.die = paramLong;
      AppMethodBeat.o(186751);
    }
    
    public final void b(f paramf, long paramLong)
    {
      AppMethodBeat.i(186771);
      if (this.closed)
      {
        paramf = new IllegalStateException("closed");
        AppMethodBeat.o(186771);
        throw paramf;
      }
      okhttp3.internal.c.bU(paramf.size, paramLong);
      if (paramLong > this.die)
      {
        paramf = new ProtocolException("expected " + this.die + " bytes but received " + paramLong);
        AppMethodBeat.o(186771);
        throw paramf;
      }
      a.this.ajPn.b(paramf, paramLong);
      this.die -= paramLong;
      AppMethodBeat.o(186771);
    }
    
    public final void close()
    {
      AppMethodBeat.i(186792);
      if (this.closed)
      {
        AppMethodBeat.o(186792);
        return;
      }
      this.closed = true;
      if (this.die > 0L)
      {
        ProtocolException localProtocolException = new ProtocolException("unexpected end of stream");
        AppMethodBeat.o(186792);
        throw localProtocolException;
      }
      a.a(this.ajPT);
      a.this.state = 3;
      AppMethodBeat.o(186792);
    }
    
    public final void flush()
    {
      AppMethodBeat.i(186783);
      if (this.closed)
      {
        AppMethodBeat.o(186783);
        return;
      }
      a.this.ajPn.flush();
      AppMethodBeat.o(186783);
    }
    
    public final j.ab kHm()
    {
      return this.ajPT;
    }
  }
  
  final class e
    extends a.a
  {
    private long die;
    
    e(long paramLong)
    {
      super((byte)0);
      AppMethodBeat.i(186744);
      this.die = paramLong;
      if (this.die == 0L) {
        a(true, null);
      }
      AppMethodBeat.o(186744);
    }
    
    public final long a(f paramf, long paramLong)
    {
      AppMethodBeat.i(186754);
      if (paramLong < 0L)
      {
        paramf = new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(paramLong)));
        AppMethodBeat.o(186754);
        throw paramf;
      }
      if (this.closed)
      {
        paramf = new IllegalStateException("closed");
        AppMethodBeat.o(186754);
        throw paramf;
      }
      if (this.die == 0L)
      {
        AppMethodBeat.o(186754);
        return -1L;
      }
      paramLong = super.a(paramf, Math.min(this.die, paramLong));
      if (paramLong == -1L)
      {
        paramf = new ProtocolException("unexpected end of stream");
        a(false, paramf);
        AppMethodBeat.o(186754);
        throw paramf;
      }
      this.die -= paramLong;
      if (this.die == 0L) {
        a(true, null);
      }
      AppMethodBeat.o(186754);
      return paramLong;
    }
    
    public final void close()
    {
      AppMethodBeat.i(186760);
      if (this.closed)
      {
        AppMethodBeat.o(186760);
        return;
      }
      if ((this.die != 0L) && (!okhttp3.internal.c.a(this, TimeUnit.MILLISECONDS))) {
        a(false, null);
      }
      this.closed = true;
      AppMethodBeat.o(186760);
    }
  }
  
  final class f
    extends a.a
  {
    private boolean ajPX;
    
    f()
    {
      super((byte)0);
    }
    
    public final long a(f paramf, long paramLong)
    {
      AppMethodBeat.i(186762);
      if (paramLong < 0L)
      {
        paramf = new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(paramLong)));
        AppMethodBeat.o(186762);
        throw paramf;
      }
      if (this.closed)
      {
        paramf = new IllegalStateException("closed");
        AppMethodBeat.o(186762);
        throw paramf;
      }
      if (this.ajPX)
      {
        AppMethodBeat.o(186762);
        return -1L;
      }
      paramLong = super.a(paramf, paramLong);
      if (paramLong == -1L)
      {
        this.ajPX = true;
        a(true, null);
        AppMethodBeat.o(186762);
        return -1L;
      }
      AppMethodBeat.o(186762);
      return paramLong;
    }
    
    public final void close()
    {
      AppMethodBeat.i(186768);
      if (this.closed)
      {
        AppMethodBeat.o(186768);
        return;
      }
      if (!this.ajPX) {
        a(false, null);
      }
      this.closed = true;
      AppMethodBeat.o(186768);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     okhttp3.internal.d.a
 * JD-Core Version:    0.7.0.1
 */