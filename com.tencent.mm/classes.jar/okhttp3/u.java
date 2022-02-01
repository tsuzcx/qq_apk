package okhttp3;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import okhttp3.internal.a.f;

public class u
  implements Cloneable, e.a
{
  static final List<v> ajNf;
  static final List<j> ajNg;
  public final n ajIO;
  public final SocketFactory ajIP;
  public final b ajIQ;
  public final List<v> ajIR;
  public final List<j> ajIS;
  public final ProxySelector ajIT;
  public final SSLSocketFactory ajIU;
  public final HostnameVerifier ajIV;
  public final g ajIW;
  final f ajIY;
  final okhttp3.internal.i.c ajJM;
  final m ajNh;
  final List<s> ajNi;
  final o.a ajNj;
  public final l ajNk;
  final c ajNl;
  public final b ajNm;
  public final i ajNn;
  public final boolean ajNo;
  public final boolean ajNp;
  public final boolean ajNq;
  final int ajNr;
  final int ajNs;
  public final int ajNt;
  final int connectTimeout;
  final List<s> interceptors;
  final int readTimeout;
  public final Proxy uuH;
  
  static
  {
    AppMethodBeat.i(186701);
    ajNf = okhttp3.internal.c.au(new v[] { v.ajNx, v.ajNv });
    ajNg = okhttp3.internal.c.au(new j[] { j.ajMp, j.ajMr });
    okhttp3.internal.a.ajOh = new okhttp3.internal.a()
    {
      public final int a(z.a paramAnonymousa)
      {
        return paramAnonymousa.code;
      }
      
      public final Socket a(i paramAnonymousi, a paramAnonymousa, okhttp3.internal.b.g paramAnonymousg)
      {
        AppMethodBeat.i(186636);
        if ((!i.$assertionsDisabled) && (!Thread.holdsLock(paramAnonymousi)))
        {
          paramAnonymousi = new AssertionError();
          AppMethodBeat.o(186636);
          throw paramAnonymousi;
        }
        Object localObject = paramAnonymousi.ajMi.iterator();
        while (((Iterator)localObject).hasNext())
        {
          paramAnonymousi = (okhttp3.internal.b.c)((Iterator)localObject).next();
          if ((paramAnonymousi.a(paramAnonymousa, null)) && (paramAnonymousi.kHv()) && (paramAnonymousi != paramAnonymousg.kHA()))
          {
            if ((!okhttp3.internal.b.g.$assertionsDisabled) && (!Thread.holdsLock(paramAnonymousg.ajNn)))
            {
              paramAnonymousi = new AssertionError();
              AppMethodBeat.o(186636);
              throw paramAnonymousi;
            }
            if ((paramAnonymousg.ajPH != null) || (paramAnonymousg.ajPF.ajPq.size() != 1))
            {
              paramAnonymousi = new IllegalStateException();
              AppMethodBeat.o(186636);
              throw paramAnonymousi;
            }
            paramAnonymousa = (Reference)paramAnonymousg.ajPF.ajPq.get(0);
            localObject = paramAnonymousg.u(true, false, false);
            paramAnonymousg.ajPF = paramAnonymousi;
            paramAnonymousi.ajPq.add(paramAnonymousa);
            AppMethodBeat.o(186636);
            return localObject;
          }
        }
        AppMethodBeat.o(186636);
        return null;
      }
      
      public final okhttp3.internal.b.c a(i paramAnonymousi, a paramAnonymousa, okhttp3.internal.b.g paramAnonymousg, ab paramAnonymousab)
      {
        AppMethodBeat.i(186618);
        if ((!i.$assertionsDisabled) && (!Thread.holdsLock(paramAnonymousi)))
        {
          paramAnonymousi = new AssertionError();
          AppMethodBeat.o(186618);
          throw paramAnonymousi;
        }
        paramAnonymousi = paramAnonymousi.ajMi.iterator();
        while (paramAnonymousi.hasNext())
        {
          okhttp3.internal.b.c localc = (okhttp3.internal.b.c)paramAnonymousi.next();
          if (localc.a(paramAnonymousa, paramAnonymousab))
          {
            paramAnonymousg.a(localc, true);
            AppMethodBeat.o(186618);
            return localc;
          }
        }
        AppMethodBeat.o(186618);
        return null;
      }
      
      public final okhttp3.internal.b.d a(i paramAnonymousi)
      {
        return paramAnonymousi.ajMj;
      }
      
      public final void a(j paramAnonymousj, SSLSocket paramAnonymousSSLSocket, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(186658);
        String[] arrayOfString1;
        if (paramAnonymousj.ajMu != null)
        {
          arrayOfString1 = okhttp3.internal.c.a(h.ajJO, paramAnonymousSSLSocket.getEnabledCipherSuites(), paramAnonymousj.ajMu);
          if (paramAnonymousj.ajMv == null) {
            break label166;
          }
        }
        label166:
        for (String[] arrayOfString2 = okhttp3.internal.c.a(okhttp3.internal.c.dFE, paramAnonymousSSLSocket.getEnabledProtocols(), paramAnonymousj.ajMv);; arrayOfString2 = paramAnonymousSSLSocket.getEnabledProtocols())
        {
          String[] arrayOfString4 = paramAnonymousSSLSocket.getSupportedCipherSuites();
          int i = okhttp3.internal.c.a(h.ajJO, arrayOfString4, "TLS_FALLBACK_SCSV");
          String[] arrayOfString3 = arrayOfString1;
          if (paramAnonymousBoolean)
          {
            arrayOfString3 = arrayOfString1;
            if (i != -1) {
              arrayOfString3 = okhttp3.internal.c.g(arrayOfString1, arrayOfString4[i]);
            }
          }
          paramAnonymousj = new j.a(paramAnonymousj).ar(arrayOfString3).as(arrayOfString2).kGF();
          if (paramAnonymousj.ajMv != null) {
            paramAnonymousSSLSocket.setEnabledProtocols(paramAnonymousj.ajMv);
          }
          if (paramAnonymousj.ajMu != null) {
            paramAnonymousSSLSocket.setEnabledCipherSuites(paramAnonymousj.ajMu);
          }
          AppMethodBeat.o(186658);
          return;
          arrayOfString1 = paramAnonymousSSLSocket.getEnabledCipherSuites();
          break;
        }
      }
      
      public final void a(q.a paramAnonymousa, String paramAnonymousString)
      {
        AppMethodBeat.i(186601);
        paramAnonymousa.bKm(paramAnonymousString);
        AppMethodBeat.o(186601);
      }
      
      public final void a(q.a paramAnonymousa, String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(186603);
        paramAnonymousa.rC(paramAnonymousString1, paramAnonymousString2);
        AppMethodBeat.o(186603);
      }
      
      public final boolean a(a paramAnonymousa1, a paramAnonymousa2)
      {
        AppMethodBeat.i(186621);
        boolean bool = paramAnonymousa1.a(paramAnonymousa2);
        AppMethodBeat.o(186621);
        return bool;
      }
      
      public final boolean a(i paramAnonymousi, okhttp3.internal.b.c paramAnonymousc)
      {
        AppMethodBeat.i(186610);
        if ((!i.$assertionsDisabled) && (!Thread.holdsLock(paramAnonymousi)))
        {
          paramAnonymousi = new AssertionError();
          AppMethodBeat.o(186610);
          throw paramAnonymousi;
        }
        if ((paramAnonymousc.ajPo) || (paramAnonymousi.ajMf == 0))
        {
          paramAnonymousi.ajMi.remove(paramAnonymousc);
          AppMethodBeat.o(186610);
          return true;
        }
        paramAnonymousi.notifyAll();
        AppMethodBeat.o(186610);
        return false;
      }
      
      public final IOException b(e paramAnonymouse, IOException paramAnonymousIOException)
      {
        AppMethodBeat.i(186659);
        paramAnonymouse = ((w)paramAnonymouse).d(paramAnonymousIOException);
        AppMethodBeat.o(186659);
        return paramAnonymouse;
      }
      
      public final void b(i paramAnonymousi, okhttp3.internal.b.c paramAnonymousc)
      {
        AppMethodBeat.i(186642);
        if ((!i.$assertionsDisabled) && (!Thread.holdsLock(paramAnonymousi)))
        {
          paramAnonymousi = new AssertionError();
          AppMethodBeat.o(186642);
          throw paramAnonymousi;
        }
        if (!paramAnonymousi.ajMk)
        {
          paramAnonymousi.ajMk = true;
          i.executor.execute(paramAnonymousi.ajMh);
        }
        paramAnonymousi.ajMi.add(paramAnonymousc);
        AppMethodBeat.o(186642);
      }
    };
    AppMethodBeat.o(186701);
  }
  
  public u()
  {
    this(new a());
    AppMethodBeat.i(186651);
    AppMethodBeat.o(186651);
  }
  
  public u(a parama)
  {
    AppMethodBeat.i(186679);
    this.ajNh = parama.ajNh;
    this.uuH = parama.uuH;
    this.ajIR = parama.ajIR;
    this.ajIS = parama.ajIS;
    this.interceptors = okhttp3.internal.c.pj(parama.interceptors);
    this.ajNi = okhttp3.internal.c.pj(parama.ajNi);
    this.ajNj = parama.ajNj;
    this.ajIT = parama.ajIT;
    this.ajNk = parama.ajNk;
    this.ajNl = parama.ajNl;
    this.ajIY = parama.ajIY;
    this.ajIP = parama.ajIP;
    Object localObject1 = this.ajIS.iterator();
    int i = 0;
    Object localObject2;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (j)((Iterator)localObject1).next();
      if ((i != 0) || (((j)localObject2).ajMs)) {}
      for (i = 1;; i = 0) {
        break;
      }
    }
    if ((parama.ajIU != null) || (i == 0))
    {
      this.ajIU = parama.ajIU;
      this.ajJM = parama.ajJM;
      if (this.ajIU != null) {
        okhttp3.internal.g.g.kIq().a(this.ajIU);
      }
      this.ajIV = parama.ajIV;
      localObject1 = parama.ajIW;
      localObject2 = this.ajJM;
      if (!okhttp3.internal.c.equal(((g)localObject1).ajJM, localObject2)) {
        break label414;
      }
    }
    for (;;)
    {
      this.ajIW = ((g)localObject1);
      this.ajIQ = parama.ajIQ;
      this.ajNm = parama.ajNm;
      this.ajNn = parama.ajNn;
      this.ajIO = parama.ajIO;
      this.ajNo = parama.ajNo;
      this.ajNp = parama.ajNp;
      this.ajNq = parama.ajNq;
      this.ajNr = parama.ajNr;
      this.connectTimeout = parama.connectTimeout;
      this.readTimeout = parama.readTimeout;
      this.ajNs = parama.ajNs;
      this.ajNt = parama.ajNt;
      if (!this.interceptors.contains(null)) {
        break label431;
      }
      parama = new IllegalStateException("Null interceptor: " + this.interceptors);
      AppMethodBeat.o(186679);
      throw parama;
      localObject1 = okhttp3.internal.c.kHl();
      this.ajIU = a((X509TrustManager)localObject1);
      this.ajJM = okhttp3.internal.g.g.kIq().b((X509TrustManager)localObject1);
      break;
      label414:
      localObject1 = new g(((g)localObject1).ajJL, (okhttp3.internal.i.c)localObject2);
    }
    label431:
    if (this.ajNi.contains(null))
    {
      parama = new IllegalStateException("Null network interceptor: " + this.ajNi);
      AppMethodBeat.o(186679);
      throw parama;
    }
    AppMethodBeat.o(186679);
  }
  
  private static SSLSocketFactory a(X509TrustManager paramX509TrustManager)
  {
    AppMethodBeat.i(186689);
    try
    {
      SSLContext localSSLContext = okhttp3.internal.g.g.kIq().kIk();
      localSSLContext.init(null, new TrustManager[] { paramX509TrustManager }, null);
      paramX509TrustManager = localSSLContext.getSocketFactory();
      AppMethodBeat.o(186689);
      return paramX509TrustManager;
    }
    catch (GeneralSecurityException paramX509TrustManager)
    {
      paramX509TrustManager = okhttp3.internal.c.c("No System TLS", paramX509TrustManager);
      AppMethodBeat.o(186689);
      throw paramX509TrustManager;
    }
  }
  
  final f kGZ()
  {
    if (this.ajNl != null) {
      return this.ajNl.ajIY;
    }
    return this.ajIY;
  }
  
  public e newCall(x paramx)
  {
    AppMethodBeat.i(186714);
    paramx = w.a(this, paramx, false);
    AppMethodBeat.o(186714);
    return paramx;
  }
  
  public static final class a
  {
    n ajIO;
    SocketFactory ajIP;
    b ajIQ;
    List<v> ajIR;
    List<j> ajIS;
    ProxySelector ajIT;
    SSLSocketFactory ajIU;
    HostnameVerifier ajIV;
    g ajIW;
    public f ajIY;
    okhttp3.internal.i.c ajJM;
    m ajNh;
    final List<s> ajNi;
    o.a ajNj;
    l ajNk;
    public c ajNl;
    b ajNm;
    i ajNn;
    boolean ajNo;
    boolean ajNp;
    boolean ajNq;
    int ajNr;
    int ajNs;
    int ajNt;
    int connectTimeout;
    final List<s> interceptors;
    int readTimeout;
    Proxy uuH;
    
    public a()
    {
      AppMethodBeat.i(186585);
      this.interceptors = new ArrayList();
      this.ajNi = new ArrayList();
      this.ajNh = new m();
      this.ajIR = u.ajNf;
      this.ajIS = u.ajNg;
      this.ajNj = o.a(o.ajMM);
      this.ajIT = ProxySelector.getDefault();
      if (this.ajIT == null) {
        this.ajIT = new okhttp3.internal.h.a();
      }
      this.ajNk = l.ajME;
      this.ajIP = SocketFactory.getDefault();
      this.ajIV = okhttp3.internal.i.d.ajSO;
      this.ajIW = g.ajJK;
      this.ajIQ = b.ajIX;
      this.ajNm = b.ajIX;
      this.ajNn = new i();
      this.ajIO = n.ajML;
      this.ajNo = true;
      this.ajNp = true;
      this.ajNq = true;
      this.ajNr = 0;
      this.connectTimeout = 10000;
      this.readTimeout = 10000;
      this.ajNs = 10000;
      this.ajNt = 0;
      AppMethodBeat.o(186585);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     okhttp3.u
 * JD-Core Version:    0.7.0.1
 */