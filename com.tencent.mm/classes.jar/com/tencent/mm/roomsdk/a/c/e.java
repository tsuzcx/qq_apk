package com.tencent.mm.roomsdk.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ae;

public final class e
{
  private int IqB;
  protected com.tencent.mm.roomsdk.a.b.a Iqp;
  protected com.tencent.mm.roomsdk.a.b.a Iqq;
  protected com.tencent.mm.roomsdk.a.b.a Iqr;
  private f ghB;
  
  public e()
  {
    AppMethodBeat.i(152787);
    this.ghB = new f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(152786);
        if ((paramAnonymousn instanceof com.tencent.mm.roomsdk.a.a)) {
          ((com.tencent.mm.roomsdk.a.a)paramAnonymousn).a(e.this.Iqr);
        }
        if (e.this.Iqr != null) {
          e.this.Iqr.a(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, e.this.Iqr);
        }
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          if (e.this.Iqp != null)
          {
            e.this.Iqp.a(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, e.this.Iqp);
            AppMethodBeat.o(152786);
          }
        }
        else if (e.this.Iqq != null) {
          e.this.Iqq.a(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, e.this.Iqq);
        }
        AppMethodBeat.o(152786);
      }
    };
    this.IqB = 700;
    AppMethodBeat.o(152787);
  }
  
  public final void dead()
  {
    AppMethodBeat.i(152789);
    ae.i("MicroMsg.RoomWatchCallbackFactory", "dead");
    g.ajS();
    g.ajQ().gDv.b(this.IqB, this.ghB);
    AppMethodBeat.o(152789);
  }
  
  public final e e(com.tencent.mm.roomsdk.a.b.a parama)
  {
    this.Iqp = parama;
    return this;
  }
  
  public final e f(com.tencent.mm.roomsdk.a.b.a parama)
  {
    this.Iqq = parama;
    return this;
  }
  
  public final e fme()
  {
    AppMethodBeat.i(152788);
    ae.i("MicroMsg.RoomWatchCallbackFactory", "alive");
    g.ajS();
    g.ajQ().gDv.a(this.IqB, this.ghB);
    AppMethodBeat.o(152788);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.roomsdk.a.c.e
 * JD-Core Version:    0.7.0.1
 */