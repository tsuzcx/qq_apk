package okhttp3;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;

public final class z
  implements Closeable
{
  final v ajJs;
  public final p ajJu;
  private volatile d ajNM;
  public final x ajNQ;
  public final aa ajNR;
  public final z ajNS;
  public final z ajNT;
  public final z ajNU;
  public final long ajNV;
  public final long ajNW;
  public final q cnu;
  public final int code;
  public final String message;
  
  z(a parama)
  {
    AppMethodBeat.i(186681);
    this.ajNQ = parama.ajNQ;
    this.ajJs = parama.ajJs;
    this.code = parama.code;
    this.message = parama.message;
    this.ajJu = parama.ajJu;
    this.cnu = parama.cpH.kGM();
    this.ajNR = parama.ajNR;
    this.ajNS = parama.ajNS;
    this.ajNT = parama.ajNT;
    this.ajNU = parama.ajNU;
    this.ajNV = parama.ajNV;
    this.ajNW = parama.ajNW;
    AppMethodBeat.o(186681);
  }
  
  public final String bKv(String paramString)
  {
    AppMethodBeat.i(186686);
    paramString = this.cnu.get(paramString);
    if (paramString != null)
    {
      AppMethodBeat.o(186686);
      return paramString;
    }
    AppMethodBeat.o(186686);
    return null;
  }
  
  public final void close()
  {
    AppMethodBeat.i(186712);
    if (this.ajNR == null)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("response is not eligible for a body and must not be closed");
      AppMethodBeat.o(186712);
      throw localIllegalStateException;
    }
    this.ajNR.close();
    AppMethodBeat.o(186712);
  }
  
  public final d kHg()
  {
    AppMethodBeat.i(186705);
    d locald = this.ajNM;
    if (locald != null)
    {
      AppMethodBeat.o(186705);
      return locald;
    }
    locald = d.b(this.cnu);
    this.ajNM = locald;
    AppMethodBeat.o(186705);
    return locald;
  }
  
  public final a kHi()
  {
    AppMethodBeat.i(186695);
    a locala = new a(this);
    AppMethodBeat.o(186695);
    return locala;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(186718);
    String str = "Response{protocol=" + this.ajJs + ", code=" + this.code + ", message=" + this.message + ", url=" + this.ajNQ.ajIN + '}';
    AppMethodBeat.o(186718);
    return str;
  }
  
  public static final class a
  {
    public v ajJs;
    public p ajJu;
    public x ajNQ;
    public aa ajNR;
    z ajNS;
    z ajNT;
    public z ajNU;
    public long ajNV;
    public long ajNW;
    public int code;
    public q.a cpH;
    public String message;
    
    public a()
    {
      AppMethodBeat.i(186543);
      this.code = -1;
      this.cpH = new q.a();
      AppMethodBeat.o(186543);
    }
    
    a(z paramz)
    {
      AppMethodBeat.i(186550);
      this.code = -1;
      this.ajNQ = paramz.ajNQ;
      this.ajJs = paramz.ajJs;
      this.code = paramz.code;
      this.message = paramz.message;
      this.ajJu = paramz.ajJu;
      this.cpH = paramz.cnu.kGL();
      this.ajNR = paramz.ajNR;
      this.ajNS = paramz.ajNS;
      this.ajNT = paramz.ajNT;
      this.ajNU = paramz.ajNU;
      this.ajNV = paramz.ajNV;
      this.ajNW = paramz.ajNW;
      AppMethodBeat.o(186550);
    }
    
    private static void a(String paramString, z paramz)
    {
      AppMethodBeat.i(186558);
      if (paramz.ajNR != null)
      {
        paramString = new IllegalArgumentException(paramString + ".body != null");
        AppMethodBeat.o(186558);
        throw paramString;
      }
      if (paramz.ajNS != null)
      {
        paramString = new IllegalArgumentException(paramString + ".networkResponse != null");
        AppMethodBeat.o(186558);
        throw paramString;
      }
      if (paramz.ajNT != null)
      {
        paramString = new IllegalArgumentException(paramString + ".cacheResponse != null");
        AppMethodBeat.o(186558);
        throw paramString;
      }
      if (paramz.ajNU != null)
      {
        paramString = new IllegalArgumentException(paramString + ".priorResponse != null");
        AppMethodBeat.o(186558);
        throw paramString;
      }
      AppMethodBeat.o(186558);
    }
    
    public final a b(z paramz)
    {
      AppMethodBeat.i(186579);
      if (paramz != null) {
        a("networkResponse", paramz);
      }
      this.ajNS = paramz;
      AppMethodBeat.o(186579);
      return this;
    }
    
    public final a c(z paramz)
    {
      AppMethodBeat.i(186590);
      if (paramz != null) {
        a("cacheResponse", paramz);
      }
      this.ajNT = paramz;
      AppMethodBeat.o(186590);
      return this;
    }
    
    public final a d(q paramq)
    {
      AppMethodBeat.i(186574);
      this.cpH = paramq.kGL();
      AppMethodBeat.o(186574);
      return this;
    }
    
    public final z kHj()
    {
      AppMethodBeat.i(186600);
      if (this.ajNQ == null)
      {
        localObject = new IllegalStateException("request == null");
        AppMethodBeat.o(186600);
        throw ((Throwable)localObject);
      }
      if (this.ajJs == null)
      {
        localObject = new IllegalStateException("protocol == null");
        AppMethodBeat.o(186600);
        throw ((Throwable)localObject);
      }
      if (this.code < 0)
      {
        localObject = new IllegalStateException("code < 0: " + this.code);
        AppMethodBeat.o(186600);
        throw ((Throwable)localObject);
      }
      if (this.message == null)
      {
        localObject = new IllegalStateException("message == null");
        AppMethodBeat.o(186600);
        throw ((Throwable)localObject);
      }
      Object localObject = new z(this);
      AppMethodBeat.o(186600);
      return localObject;
    }
    
    public final a rF(String paramString1, String paramString2)
    {
      AppMethodBeat.i(186566);
      this.cpH.rB(paramString1, paramString2);
      AppMethodBeat.o(186566);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     okhttp3.z
 * JD-Core Version:    0.7.0.1
 */