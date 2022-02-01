package okhttp3.internal.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import j.m;
import java.util.List;
import okhttp3.internal.c;
import okhttp3.k;
import okhttp3.l;
import okhttp3.q.a;
import okhttp3.s;
import okhttp3.s.a;
import okhttp3.t;
import okhttp3.x;
import okhttp3.x.a;
import okhttp3.y;
import okhttp3.z;
import okhttp3.z.a;

public final class a
  implements s
{
  private final l ajNk;
  
  public a(l paraml)
  {
    this.ajNk = paraml;
  }
  
  public final z a(s.a parama)
  {
    int j = 0;
    AppMethodBeat.i(186841);
    Object localObject1 = parama.kGV();
    Object localObject2 = ((x)localObject1).kHf();
    Object localObject3 = ((x)localObject1).ajNK;
    Object localObject4;
    if (localObject3 != null)
    {
      localObject4 = ((y)localObject3).kGz();
      if (localObject4 != null) {
        ((x.a)localObject2).rE("Content-Type", ((t)localObject4).toString());
      }
      long l = ((y)localObject3).kGA();
      if (l != -1L)
      {
        ((x.a)localObject2).rE("Content-Length", Long.toString(l));
        ((x.a)localObject2).bKw("Transfer-Encoding");
      }
    }
    else
    {
      if (((x)localObject1).bKv("Host") == null) {
        ((x.a)localObject2).rE("Host", c.a(((x)localObject1).ajIN, false));
      }
      if (((x)localObject1).bKv("Connection") == null) {
        ((x.a)localObject2).rE("Connection", "Keep-Alive");
      }
      if ((((x)localObject1).bKv("Accept-Encoding") != null) || (((x)localObject1).bKv("Range") != null)) {
        break label477;
      }
      ((x.a)localObject2).rE("Accept-Encoding", "gzip");
    }
    label477:
    for (int i = 1;; i = 0)
    {
      localObject3 = this.ajNk.kGG();
      if (!((List)localObject3).isEmpty())
      {
        localObject4 = new StringBuilder();
        int k = ((List)localObject3).size();
        for (;;)
        {
          if (j < k)
          {
            if (j > 0) {
              ((StringBuilder)localObject4).append("; ");
            }
            k localk = (k)((List)localObject3).get(j);
            ((StringBuilder)localObject4).append(localk.name).append('=').append(localk.value);
            j += 1;
            continue;
            ((x.a)localObject2).rE("Transfer-Encoding", "chunked");
            ((x.a)localObject2).bKw("Content-Length");
            break;
          }
        }
        ((x.a)localObject2).rE("Cookie", ((StringBuilder)localObject4).toString());
      }
      if (((x)localObject1).bKv("User-Agent") == null) {
        ((x.a)localObject2).rE("User-Agent", "okhttp/3.12.13");
      }
      parama = parama.c(((x.a)localObject2).kHh());
      e.a(this.ajNk, ((x)localObject1).ajIN, parama.cnu);
      localObject2 = parama.kHi();
      ((z.a)localObject2).ajNQ = ((x)localObject1);
      if ((i != 0) && ("gzip".equalsIgnoreCase(parama.bKv("Content-Encoding"))) && (e.i(parama)))
      {
        localObject1 = new m(parama.ajNR.kGB());
        ((z.a)localObject2).d(parama.cnu.kGL().bKn("Content-Encoding").bKn("Content-Length").kGM());
        ((z.a)localObject2).ajNR = new h(parama.bKv("Content-Type"), -1L, j.q.b((j.aa)localObject1));
      }
      parama = ((z.a)localObject2).kHj();
      AppMethodBeat.o(186841);
      return parama;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     okhttp3.internal.c.a
 * JD-Core Version:    0.7.0.1
 */