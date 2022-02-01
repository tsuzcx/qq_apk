package okhttp3;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import okhttp3.internal.c;
import okhttp3.internal.c.f;

public final class x
{
  public final r ajIN;
  public final y ajNK;
  final Map<Class<?>, Object> ajNL;
  private volatile d ajNM;
  public final q cnu;
  public final String method;
  
  x(a parama)
  {
    AppMethodBeat.i(186706);
    this.ajIN = parama.ajIN;
    this.method = parama.method;
    this.cnu = parama.cpH.kGM();
    this.ajNK = parama.ajNK;
    this.ajNL = c.dG(parama.ajNL);
    AppMethodBeat.o(186706);
  }
  
  public final String bKv(String paramString)
  {
    AppMethodBeat.i(186713);
    paramString = this.cnu.get(paramString);
    AppMethodBeat.o(186713);
    return paramString;
  }
  
  public final a kHf()
  {
    AppMethodBeat.i(186717);
    a locala = new a(this);
    AppMethodBeat.o(186717);
    return locala;
  }
  
  public final d kHg()
  {
    AppMethodBeat.i(186724);
    d locald = this.ajNM;
    if (locald != null)
    {
      AppMethodBeat.o(186724);
      return locald;
    }
    locald = d.b(this.cnu);
    this.ajNM = locald;
    AppMethodBeat.o(186724);
    return locald;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(186729);
    String str = "Request{method=" + this.method + ", url=" + this.ajIN + ", tags=" + this.ajNL + '}';
    AppMethodBeat.o(186729);
    return str;
  }
  
  public static final class a
  {
    r ajIN;
    y ajNK;
    Map<Class<?>, Object> ajNL;
    q.a cpH;
    String method;
    
    public a()
    {
      AppMethodBeat.i(186535);
      this.ajNL = Collections.emptyMap();
      this.method = "GET";
      this.cpH = new q.a();
      AppMethodBeat.o(186535);
    }
    
    a(x paramx)
    {
      AppMethodBeat.i(186538);
      this.ajNL = Collections.emptyMap();
      this.ajIN = paramx.ajIN;
      this.method = paramx.method;
      this.ajNK = paramx.ajNK;
      if (paramx.ajNL.isEmpty()) {}
      for (Object localObject = Collections.emptyMap();; localObject = new LinkedHashMap(paramx.ajNL))
      {
        this.ajNL = ((Map)localObject);
        this.cpH = paramx.cnu.kGL();
        AppMethodBeat.o(186538);
        return;
      }
    }
    
    public final a a(String paramString, y paramy)
    {
      AppMethodBeat.i(186570);
      if (paramString == null)
      {
        paramString = new NullPointerException("method == null");
        AppMethodBeat.o(186570);
        throw paramString;
      }
      if (paramString.length() == 0)
      {
        paramString = new IllegalArgumentException("method.length() == 0");
        AppMethodBeat.o(186570);
        throw paramString;
      }
      if ((paramy != null) && (!f.bKI(paramString)))
      {
        paramString = new IllegalArgumentException("method " + paramString + " must not have a request body.");
        AppMethodBeat.o(186570);
        throw paramString;
      }
      if ((paramy == null) && (f.bKH(paramString)))
      {
        paramString = new IllegalArgumentException("method " + paramString + " must have a request body.");
        AppMethodBeat.o(186570);
        throw paramString;
      }
      this.method = paramString;
      this.ajNK = paramy;
      AppMethodBeat.o(186570);
      return this;
    }
    
    public final a a(d paramd)
    {
      AppMethodBeat.i(186560);
      paramd = paramd.toString();
      if (paramd.isEmpty())
      {
        paramd = bKw("Cache-Control");
        AppMethodBeat.o(186560);
        return paramd;
      }
      paramd = rE("Cache-Control", paramd);
      AppMethodBeat.o(186560);
      return paramd;
    }
    
    public final a b(r paramr)
    {
      AppMethodBeat.i(186542);
      if (paramr == null)
      {
        paramr = new NullPointerException("url == null");
        AppMethodBeat.o(186542);
        throw paramr;
      }
      this.ajIN = paramr;
      AppMethodBeat.o(186542);
      return this;
    }
    
    public final a bKw(String paramString)
    {
      AppMethodBeat.i(186551);
      this.cpH.bKn(paramString);
      AppMethodBeat.o(186551);
      return this;
    }
    
    public final a c(q paramq)
    {
      AppMethodBeat.i(186554);
      this.cpH = paramq.kGL();
      AppMethodBeat.o(186554);
      return this;
    }
    
    public final x kHh()
    {
      AppMethodBeat.i(186576);
      if (this.ajIN == null)
      {
        localObject = new IllegalStateException("url == null");
        AppMethodBeat.o(186576);
        throw ((Throwable)localObject);
      }
      Object localObject = new x(this);
      AppMethodBeat.o(186576);
      return localObject;
    }
    
    public final a rE(String paramString1, String paramString2)
    {
      AppMethodBeat.i(186545);
      this.cpH.rD(paramString1, paramString2);
      AppMethodBeat.o(186545);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     okhttp3.x
 * JD-Core Version:    0.7.0.1
 */