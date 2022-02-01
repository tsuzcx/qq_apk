package okhttp3.internal.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import j.ab;
import j.g;
import j.y;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import okhttp3.d;
import okhttp3.internal.c.e;
import okhttp3.q.a;
import okhttp3.r;
import okhttp3.s;
import okhttp3.s.a;
import okhttp3.v;
import okhttp3.x;
import okhttp3.x.a;
import okhttp3.z;
import okhttp3.z.a;

public final class a
  implements s
{
  final f ajOw;
  
  public a(f paramf)
  {
    this.ajOw = paramf;
  }
  
  private static okhttp3.q a(okhttp3.q paramq1, okhttp3.q paramq2)
  {
    int j = 0;
    AppMethodBeat.i(187050);
    q.a locala = new q.a();
    int k = paramq1.ajMS.length / 2;
    int i = 0;
    while (i < k)
    {
      String str1 = paramq1.aMS(i);
      String str2 = paramq1.aMT(i);
      if (((!"Warning".equalsIgnoreCase(str1)) || (!str2.startsWith("1"))) && ((bKD(str1)) || (!bKC(str1)) || (paramq2.get(str1) == null))) {
        okhttp3.internal.a.ajOh.a(locala, str1, str2);
      }
      i += 1;
    }
    k = paramq2.ajMS.length / 2;
    i = j;
    while (i < k)
    {
      paramq1 = paramq2.aMS(i);
      if ((!bKD(paramq1)) && (bKC(paramq1))) {
        okhttp3.internal.a.ajOh.a(locala, paramq1, paramq2.aMT(i));
      }
      i += 1;
    }
    paramq1 = locala.kGM();
    AppMethodBeat.o(187050);
    return paramq1;
  }
  
  private static boolean bKC(String paramString)
  {
    AppMethodBeat.i(187060);
    if ((!"Connection".equalsIgnoreCase(paramString)) && (!"Keep-Alive".equalsIgnoreCase(paramString)) && (!"Proxy-Authenticate".equalsIgnoreCase(paramString)) && (!"Proxy-Authorization".equalsIgnoreCase(paramString)) && (!"TE".equalsIgnoreCase(paramString)) && (!"Trailers".equalsIgnoreCase(paramString)) && (!"Transfer-Encoding".equalsIgnoreCase(paramString)) && (!"Upgrade".equalsIgnoreCase(paramString)))
    {
      AppMethodBeat.o(187060);
      return true;
    }
    AppMethodBeat.o(187060);
    return false;
  }
  
  private static boolean bKD(String paramString)
  {
    AppMethodBeat.i(187069);
    if (("Content-Length".equalsIgnoreCase(paramString)) || ("Content-Encoding".equalsIgnoreCase(paramString)) || ("Content-Type".equalsIgnoreCase(paramString)))
    {
      AppMethodBeat.o(187069);
      return true;
    }
    AppMethodBeat.o(187069);
    return false;
  }
  
  private static z d(z paramz)
  {
    AppMethodBeat.i(187035);
    if ((paramz != null) && (paramz.ajNR != null))
    {
      paramz = paramz.kHi();
      paramz.ajNR = null;
      paramz = paramz.kHj();
      AppMethodBeat.o(187035);
      return paramz;
    }
    AppMethodBeat.o(187035);
    return paramz;
  }
  
  public final z a(s.a parama)
  {
    AppMethodBeat.i(187175);
    z localz;
    Object localObject3;
    Object localObject1;
    if (this.ajOw != null)
    {
      localz = this.ajOw.a(parama.kGV());
      localObject3 = new c.a(System.currentTimeMillis(), parama.kGV(), localz);
      if (((c.a)localObject3).ajNT != null) {
        break label259;
      }
      localObject1 = new c(((c.a)localObject3).ajNQ, null);
    }
    Object localObject2;
    label259:
    label405:
    label410:
    long l1;
    for (;;)
    {
      localObject2 = localObject1;
      if (((c)localObject1).ajOC != null)
      {
        localObject2 = localObject1;
        if (((c.a)localObject3).ajNQ.kHg().ajJH) {
          localObject2 = new c(null, null);
        }
      }
      localObject3 = ((c)localObject2).ajOC;
      localObject1 = ((c)localObject2).ajNT;
      if (this.ajOw != null) {
        this.ajOw.a((c)localObject2);
      }
      if ((localz != null) && (localObject1 == null)) {
        okhttp3.internal.c.closeQuietly(localz.ajNR);
      }
      if ((localObject3 != null) || (localObject1 != null)) {
        break label1093;
      }
      localObject1 = new z.a();
      ((z.a)localObject1).ajNQ = parama.kGV();
      ((z.a)localObject1).ajJs = v.ajNv;
      ((z.a)localObject1).code = 504;
      ((z.a)localObject1).message = "Unsatisfiable Request (only-if-cached)";
      ((z.a)localObject1).ajNR = okhttp3.internal.c.ajOi;
      ((z.a)localObject1).ajNV = -1L;
      ((z.a)localObject1).ajNW = System.currentTimeMillis();
      parama = ((z.a)localObject1).kHj();
      AppMethodBeat.o(187175);
      return parama;
      localz = null;
      break;
      if ((((c.a)localObject3).ajNQ.ajIN.isHttps()) && (((c.a)localObject3).ajNT.ajJu == null))
      {
        localObject1 = new c(((c.a)localObject3).ajNQ, null);
      }
      else if (!c.a(((c.a)localObject3).ajNT, ((c.a)localObject3).ajNQ))
      {
        localObject1 = new c(((c.a)localObject3).ajNQ, null);
      }
      else
      {
        localObject2 = ((c.a)localObject3).ajNQ.kHg();
        if (!((d)localObject2).ajJz)
        {
          localObject1 = ((c.a)localObject3).ajNQ;
          if ((((x)localObject1).bKv("If-Modified-Since") == null) && (((x)localObject1).bKv("If-None-Match") == null)) {
            break label405;
          }
        }
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label410;
          }
          localObject1 = new c(((c.a)localObject3).ajNQ, null);
          break;
        }
        Object localObject4 = ((c.a)localObject3).ajNT.kHg();
        label447:
        long l2;
        if (((c.a)localObject3).ajOE != null)
        {
          l1 = Math.max(0L, ((c.a)localObject3).ajJw - ((c.a)localObject3).ajOE.getTime());
          l2 = l1;
          if (((c.a)localObject3).ajOJ != -1) {
            l2 = Math.max(l1, TimeUnit.SECONDS.toMillis(((c.a)localObject3).ajOJ));
          }
          long l5 = l2 + (((c.a)localObject3).ajJw - ((c.a)localObject3).ajJv) + (((c.a)localObject3).ajOD - ((c.a)localObject3).ajJw);
          localObject1 = ((c.a)localObject3).ajNT.kHg();
          if (((d)localObject1).ajJB == -1) {
            break label757;
          }
          l1 = TimeUnit.SECONDS.toMillis(((d)localObject1).ajJB);
          label537:
          l2 = l1;
          if (((d)localObject2).ajJB != -1) {
            l2 = Math.min(l1, TimeUnit.SECONDS.toMillis(((d)localObject2).ajJB));
          }
          l1 = 0L;
          if (((d)localObject2).ajJG != -1) {
            l1 = TimeUnit.SECONDS.toMillis(((d)localObject2).ajJG);
          }
          long l4 = 0L;
          long l3 = l4;
          if (!((d)localObject4).ajJE)
          {
            l3 = l4;
            if (((d)localObject2).ajJF != -1) {
              l3 = TimeUnit.SECONDS.toMillis(((d)localObject2).ajJF);
            }
          }
          if ((((d)localObject4).ajJz) || (l5 + l1 >= l3 + l2)) {
            break label951;
          }
          localObject1 = ((c.a)localObject3).ajNT.kHi();
          if (l1 + l5 >= l2) {
            ((z.a)localObject1).rF("Warning", "110 HttpURLConnection \"Response is stale\"");
          }
          if (l5 > 86400000L) {
            if ((((c.a)localObject3).ajNT.kHg().ajJB != -1) || (((c.a)localObject3).afyo != null)) {
              break label946;
            }
          }
        }
        label927:
        label936:
        label941:
        label946:
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            ((z.a)localObject1).rF("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
          }
          localObject1 = new c(null, ((z.a)localObject1).kHj());
          break;
          l1 = 0L;
          break label447;
          label757:
          if (((c.a)localObject3).afyo != null)
          {
            if (((c.a)localObject3).ajOE != null) {}
            for (l1 = ((c.a)localObject3).ajOE.getTime();; l1 = ((c.a)localObject3).ajJw)
            {
              l2 = ((c.a)localObject3).afyo.getTime() - l1;
              l1 = l2;
              if (l2 > 0L) {
                break;
              }
              l1 = 0L;
              break;
            }
          }
          if (((c.a)localObject3).ajOG != null)
          {
            localObject1 = ((c.a)localObject3).ajNT.ajNQ.ajIN;
            if (((r)localObject1).ajMV == null)
            {
              localObject1 = null;
              label850:
              if (localObject1 != null) {
                break label941;
              }
              if (((c.a)localObject3).ajOE == null) {
                break label927;
              }
            }
            for (l1 = ((c.a)localObject3).ajOE.getTime();; l1 = ((c.a)localObject3).ajJv)
            {
              l1 -= ((c.a)localObject3).ajOG.getTime();
              if (l1 <= 0L) {
                break label936;
              }
              l1 /= 10L;
              break;
              StringBuilder localStringBuilder = new StringBuilder();
              r.e(localStringBuilder, ((r)localObject1).ajMV);
              localObject1 = localStringBuilder.toString();
              break label850;
            }
            l1 = 0L;
            break label537;
          }
          l1 = 0L;
          break label537;
        }
        label951:
        if (((c.a)localObject3).ajOI != null)
        {
          localObject1 = "If-None-Match";
          localObject2 = ((c.a)localObject3).ajOI;
        }
        for (;;)
        {
          localObject4 = ((c.a)localObject3).ajNQ.cnu.kGL();
          okhttp3.internal.a.ajOh.a((q.a)localObject4, (String)localObject1, (String)localObject2);
          localObject1 = new c(((c.a)localObject3).ajNQ.kHf().c(((q.a)localObject4).kGM()).kHh(), ((c.a)localObject3).ajNT);
          break;
          if (((c.a)localObject3).ajOG != null)
          {
            localObject1 = "If-Modified-Since";
            localObject2 = ((c.a)localObject3).ajOH;
          }
          else
          {
            if (((c.a)localObject3).ajOE == null) {
              break label1075;
            }
            localObject1 = "If-Modified-Since";
            localObject2 = ((c.a)localObject3).ajOF;
          }
        }
        label1075:
        localObject1 = new c(((c.a)localObject3).ajNQ, null);
      }
    }
    label1093:
    if (localObject3 == null)
    {
      parama = ((z)localObject1).kHi().c(d((z)localObject1)).kHj();
      AppMethodBeat.o(187175);
      return parama;
    }
    try
    {
      parama = parama.c((x)localObject3);
      if ((parama == null) && (localz != null)) {
        okhttp3.internal.c.closeQuietly(localz.ajNR);
      }
      if (localObject1 == null) {
        break label1291;
      }
      if (parama.code == 304)
      {
        localObject2 = ((z)localObject1).kHi().d(a(((z)localObject1).cnu, parama.cnu));
        ((z.a)localObject2).ajNV = parama.ajNV;
        ((z.a)localObject2).ajNW = parama.ajNW;
        localObject2 = ((z.a)localObject2).c(d((z)localObject1)).b(d(parama)).kHj();
        parama.ajNR.close();
        this.ajOw.kGx();
        this.ajOw.a((z)localObject1, (z)localObject2);
        AppMethodBeat.o(187175);
        return localObject2;
      }
    }
    finally
    {
      if (localz != null) {
        okhttp3.internal.c.closeQuietly(localz.ajNR);
      }
      AppMethodBeat.o(187175);
    }
    okhttp3.internal.c.closeQuietly(((z)localObject1).ajNR);
    label1291:
    parama = parama.kHi().c(d((z)localObject1)).b(d(parama)).kHj();
    if (this.ajOw != null)
    {
      if ((e.i(parama)) && (c.a(parama, (x)localObject3)))
      {
        localObject1 = this.ajOw.a(parama);
        if (localObject1 == null)
        {
          AppMethodBeat.o(187175);
          return parama;
        }
        localObject2 = ((b)localObject1).kGy();
        if (localObject2 == null)
        {
          AppMethodBeat.o(187175);
          return parama;
        }
        localObject1 = new j.aa()
        {
          boolean ajOx;
          
          public final long a(j.f paramAnonymousf, long paramAnonymousLong)
          {
            AppMethodBeat.i(187032);
            try
            {
              paramAnonymousLong = this.ajOy.a(paramAnonymousf, paramAnonymousLong);
              if (paramAnonymousLong == -1L)
              {
                if (!this.ajOx)
                {
                  this.ajOx = true;
                  this.ajOA.close();
                }
                AppMethodBeat.o(187032);
                return -1L;
              }
            }
            catch (IOException paramAnonymousf)
            {
              if (!this.ajOx)
              {
                this.ajOx = true;
                this.ajOz.Fw();
              }
              AppMethodBeat.o(187032);
              throw paramAnonymousf;
            }
            paramAnonymousf.a(this.ajOA.kIv(), paramAnonymousf.size - paramAnonymousLong, paramAnonymousLong);
            this.ajOA.kIx();
            AppMethodBeat.o(187032);
            return paramAnonymousLong;
          }
          
          public final void close()
          {
            AppMethodBeat.i(187039);
            if ((!this.ajOx) && (!okhttp3.internal.c.a(this, TimeUnit.MILLISECONDS)))
            {
              this.ajOx = true;
              this.ajOz.Fw();
            }
            this.ajOy.close();
            AppMethodBeat.o(187039);
          }
          
          public final ab kHm()
          {
            AppMethodBeat.i(187033);
            ab localab = this.ajOy.kHm();
            AppMethodBeat.o(187033);
            return localab;
          }
        };
        localObject2 = parama.bKv("Content-Type");
        l1 = parama.ajNR.kGA();
        parama = parama.kHi();
        parama.ajNR = new okhttp3.internal.c.h((String)localObject2, l1, j.q.b((j.aa)localObject1));
        parama = parama.kHj();
        AppMethodBeat.o(187175);
        return parama;
      }
      if (!okhttp3.internal.c.f.bKG(((x)localObject3).method)) {}
    }
    try
    {
      this.ajOw.b((x)localObject3);
      label1480:
      AppMethodBeat.o(187175);
      return parama;
    }
    catch (IOException localIOException)
    {
      break label1480;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     okhttp3.internal.a.a
 * JD-Core Version:    0.7.0.1
 */