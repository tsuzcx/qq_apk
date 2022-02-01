package okhttp3.internal.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import j.ab;
import j.y;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.a;
import okhttp3.internal.c.e;
import okhttp3.internal.c.h;
import okhttp3.q.a;
import okhttp3.r;
import okhttp3.s.a;
import okhttp3.u;
import okhttp3.v;
import okhttp3.x;
import okhttp3.z;
import okhttp3.z.a;

public final class f
  implements okhttp3.internal.c.c
{
  private static final List<String> ajQK;
  private static final List<String> ajQL;
  private final v ajJs;
  final okhttp3.internal.b.g ajPO;
  private final s.a ajQM;
  private final g ajQN;
  private i ajQO;
  
  static
  {
    AppMethodBeat.i(186894);
    ajQK = okhttp3.internal.c.au(new String[] { "connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade", ":method", ":path", ":scheme", ":authority" });
    ajQL = okhttp3.internal.c.au(new String[] { "connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade" });
    AppMethodBeat.o(186894);
  }
  
  public f(u paramu, s.a parama, okhttp3.internal.b.g paramg, g paramg1)
  {
    AppMethodBeat.i(186888);
    this.ajQM = parama;
    this.ajPO = paramg;
    this.ajQN = paramg1;
    if (paramu.ajIR.contains(v.ajNy)) {}
    for (paramu = v.ajNy;; paramu = v.ajNx)
    {
      this.ajJs = paramu;
      AppMethodBeat.o(186888);
      return;
    }
  }
  
  public final z.a PT(boolean paramBoolean)
  {
    AppMethodBeat.i(186940);
    okhttp3.q localq = this.ajQO.kHU();
    v localv = this.ajJs;
    q.a locala = new q.a();
    int i = 0;
    int j = localq.ajMS.length / 2;
    Object localObject1 = null;
    if (i < j)
    {
      String str1 = localq.aMS(i);
      String str2 = localq.aMT(i);
      if (str1.equals(":status")) {
        localObject2 = okhttp3.internal.c.k.bKJ("HTTP/1.1 ".concat(String.valueOf(str2)));
      }
      for (;;)
      {
        i += 1;
        localObject1 = localObject2;
        break;
        localObject2 = localObject1;
        if (!ajQL.contains(str1))
        {
          a.ajOh.a(locala, str1, str2);
          localObject2 = localObject1;
        }
      }
    }
    if (localObject1 == null)
    {
      localObject1 = new ProtocolException("Expected ':status' header not present");
      AppMethodBeat.o(186940);
      throw ((Throwable)localObject1);
    }
    Object localObject2 = new z.a();
    ((z.a)localObject2).ajJs = localv;
    ((z.a)localObject2).code = ((okhttp3.internal.c.k)localObject1).code;
    ((z.a)localObject2).message = ((okhttp3.internal.c.k)localObject1).message;
    localObject1 = ((z.a)localObject2).d(locala.kGM());
    if ((paramBoolean) && (a.ajOh.a((z.a)localObject1) == 100))
    {
      AppMethodBeat.o(186940);
      return null;
    }
    AppMethodBeat.o(186940);
    return localObject1;
  }
  
  public final y a(x paramx, long paramLong)
  {
    AppMethodBeat.i(186896);
    paramx = this.ajQO.kHV();
    AppMethodBeat.o(186896);
    return paramx;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(186951);
    if (this.ajQO != null) {
      this.ajQO.c(b.ajQd);
    }
    AppMethodBeat.o(186951);
  }
  
  public final void d(x paramx)
  {
    int i = 0;
    AppMethodBeat.i(186912);
    if (this.ajQO != null)
    {
      AppMethodBeat.o(186912);
      return;
    }
    if (paramx.ajNK != null) {}
    ArrayList localArrayList;
    for (boolean bool = true;; bool = false)
    {
      okhttp3.q localq = paramx.cnu;
      localArrayList = new ArrayList(localq.ajMS.length / 2 + 4);
      localArrayList.add(new c(c.ajQn, paramx.method));
      localArrayList.add(new c(c.ajQo, okhttp3.internal.c.i.d(paramx.ajIN)));
      String str = paramx.bKv("Host");
      if (str != null) {
        localArrayList.add(new c(c.ajQq, str));
      }
      localArrayList.add(new c(c.ajQp, paramx.ajIN.scheme));
      int j = localq.ajMS.length / 2;
      while (i < j)
      {
        paramx = j.i.bKT(localq.aMS(i).toLowerCase(Locale.US));
        if (!ajQK.contains(paramx.kIJ())) {
          localArrayList.add(new c(paramx, localq.aMT(i)));
        }
        i += 1;
      }
    }
    this.ajQO = this.ajQN.T(localArrayList, bool);
    this.ajQO.ajRN.b(this.ajQM.kGX(), TimeUnit.MILLISECONDS);
    this.ajQO.ajRO.b(this.ajQM.kGY(), TimeUnit.MILLISECONDS);
    AppMethodBeat.o(186912);
  }
  
  public final okhttp3.aa e(z paramz)
  {
    AppMethodBeat.i(186947);
    paramz = new h(paramz.bKv("Content-Type"), e.f(paramz), j.q.b(new a(this.ajQO.ajRL)));
    AppMethodBeat.o(186947);
    return paramz;
  }
  
  public final void kHD()
  {
    AppMethodBeat.i(186916);
    this.ajQN.ajRk.flush();
    AppMethodBeat.o(186916);
  }
  
  public final void kHE()
  {
    AppMethodBeat.i(186921);
    this.ajQO.kHV().close();
    AppMethodBeat.o(186921);
  }
  
  final class a
    extends j.k
  {
    boolean TGl = false;
    long bytesRead = 0L;
    
    a(j.aa paramaa)
    {
      super();
    }
    
    private void f(IOException paramIOException)
    {
      AppMethodBeat.i(186962);
      if (this.TGl)
      {
        AppMethodBeat.o(186962);
        return;
      }
      this.TGl = true;
      f.this.ajPO.a(false, f.this, paramIOException);
      AppMethodBeat.o(186962);
    }
    
    public final long a(j.f paramf, long paramLong)
    {
      AppMethodBeat.i(186972);
      try
      {
        paramLong = kIP().a(paramf, paramLong);
        if (paramLong > 0L) {
          this.bytesRead += paramLong;
        }
        AppMethodBeat.o(186972);
        return paramLong;
      }
      catch (IOException paramf)
      {
        f(paramf);
        AppMethodBeat.o(186972);
        throw paramf;
      }
    }
    
    public final void close()
    {
      AppMethodBeat.i(186978);
      super.close();
      f(null);
      AppMethodBeat.o(186978);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     okhttp3.internal.e.f
 * JD-Core Version:    0.7.0.1
 */