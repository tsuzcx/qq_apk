package okhttp3.internal.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import okhttp3.s;
import okhttp3.s.a;
import okhttp3.u;
import okhttp3.x;
import okhttp3.z;

public final class a
  implements s
{
  public final u ajNB;
  
  public a(u paramu)
  {
    this.ajNB = paramu;
  }
  
  public final z a(s.a parama)
  {
    AppMethodBeat.i(186871);
    okhttp3.internal.c.g localg = (okhttp3.internal.c.g)parama;
    x localx = localg.ajNQ;
    g localg1 = localg.ajPO;
    if (!localx.method.equals("GET")) {}
    for (boolean bool = true;; bool = false)
    {
      parama = localg.a(localx, localg1, localg1.a(this.ajNB, parama, bool), localg1.kHA());
      AppMethodBeat.o(186871);
      return parama;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     okhttp3.internal.b.a
 * JD-Core Version:    0.7.0.1
 */