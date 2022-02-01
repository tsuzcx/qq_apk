package okhttp3.internal.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import j.j;
import j.q;
import java.net.ProtocolException;
import okhttp3.aa;
import okhttp3.s;
import okhttp3.s.a;
import okhttp3.x;
import okhttp3.z;
import okhttp3.z.a;

public final class b
  implements s
{
  private final boolean ajNG;
  
  public b(boolean paramBoolean)
  {
    this.ajNG = paramBoolean;
  }
  
  public final z a(s.a parama)
  {
    AppMethodBeat.i(186863);
    parama = (g)parama;
    c localc = parama.ajPP;
    okhttp3.internal.b.g localg = parama.ajPO;
    Object localObject = (okhttp3.internal.b.c)parama.ajPF;
    x localx = parama.ajNQ;
    long l = System.currentTimeMillis();
    localc.d(localx);
    parama = null;
    if ((f.bKI(localx.method)) && (localx.ajNK != null))
    {
      if ("100-continue".equalsIgnoreCase(localx.bKv("Expect")))
      {
        localc.kHD();
        parama = localc.PT(true);
      }
      if (parama == null)
      {
        localObject = q.b(new a(localc.a(localx, localx.ajNK.kGA())));
        localx.ajNK.a((j.g)localObject);
        ((j.g)localObject).close();
      }
    }
    for (;;)
    {
      localc.kHE();
      localObject = parama;
      if (parama == null) {
        localObject = localc.PT(false);
      }
      ((z.a)localObject).ajNQ = localx;
      ((z.a)localObject).ajJu = localg.kHA().ajJu;
      ((z.a)localObject).ajNV = l;
      ((z.a)localObject).ajNW = System.currentTimeMillis();
      parama = ((z.a)localObject).kHj();
      int j = parama.code;
      int i = j;
      if (j == 100)
      {
        parama = localc.PT(false);
        parama.ajNQ = localx;
        parama.ajJu = localg.kHA().ajJu;
        parama.ajNV = l;
        parama.ajNW = System.currentTimeMillis();
        parama = parama.kHj();
        i = parama.code;
      }
      if ((this.ajNG) && (i == 101))
      {
        parama = parama.kHi();
        parama.ajNR = okhttp3.internal.c.ajOi;
      }
      for (parama = parama.kHj();; parama = ((z.a)localObject).kHj())
      {
        if (("close".equalsIgnoreCase(parama.ajNQ.bKv("Connection"))) || ("close".equalsIgnoreCase(parama.bKv("Connection")))) {
          localg.kHB();
        }
        if (((i != 204) && (i != 205)) || (parama.ajNR.kGA() <= 0L)) {
          break label463;
        }
        parama = new ProtocolException("HTTP " + i + " had non-zero Content-Length: " + parama.ajNR.kGA());
        AppMethodBeat.o(186863);
        throw parama;
        if (!((okhttp3.internal.b.c)localObject).kHv()) {
          localg.kHB();
        }
        break;
        localObject = parama.kHi();
        ((z.a)localObject).ajNR = localc.e(parama);
      }
      label463:
      AppMethodBeat.o(186863);
      return parama;
      parama = null;
    }
  }
  
  static final class a
    extends j
  {
    long ajPI;
    
    a(j.y paramy)
    {
      super();
    }
    
    public final void b(j.f paramf, long paramLong)
    {
      AppMethodBeat.i(186826);
      super.b(paramf, paramLong);
      this.ajPI += paramLong;
      AppMethodBeat.o(186826);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     okhttp3.internal.c.b
 * JD-Core Version:    0.7.0.1
 */