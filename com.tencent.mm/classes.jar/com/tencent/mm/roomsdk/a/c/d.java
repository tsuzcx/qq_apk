package com.tencent.mm.roomsdk.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.sdk.platformtools.ad;

public final class d
{
  protected com.tencent.mm.roomsdk.a.b.a ENj;
  protected com.tencent.mm.roomsdk.a.b.a ENk;
  protected com.tencent.mm.roomsdk.a.b.a ENl;
  private int ENt;
  private com.tencent.mm.al.g gWw;
  
  public d()
  {
    AppMethodBeat.i(152787);
    this.gWw = new com.tencent.mm.al.g()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(152786);
        if ((paramAnonymousn instanceof com.tencent.mm.roomsdk.a.a)) {
          ((com.tencent.mm.roomsdk.a.a)paramAnonymousn).a(d.this.ENl);
        }
        if (d.this.ENl != null) {
          d.this.ENl.a(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, d.this.ENl);
        }
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          if (d.this.ENj != null)
          {
            d.this.ENj.a(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, d.this.ENj);
            AppMethodBeat.o(152786);
          }
        }
        else if (d.this.ENk != null) {
          d.this.ENk.a(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, d.this.ENk);
        }
        AppMethodBeat.o(152786);
      }
    };
    this.ENt = 700;
    AppMethodBeat.o(152787);
  }
  
  public final void dead()
  {
    AppMethodBeat.i(152789);
    ad.i("MicroMsg.RoomWatchCallbackFactory", "dead");
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.b(this.ENt, this.gWw);
    AppMethodBeat.o(152789);
  }
  
  public final d e(com.tencent.mm.roomsdk.a.b.a parama)
  {
    this.ENj = parama;
    return this;
  }
  
  public final d eDq()
  {
    AppMethodBeat.i(152788);
    ad.i("MicroMsg.RoomWatchCallbackFactory", "alive");
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(this.ENt, this.gWw);
    AppMethodBeat.o(152788);
    return this;
  }
  
  public final d f(com.tencent.mm.roomsdk.a.b.a parama)
  {
    this.ENk = parama;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.roomsdk.a.c.d
 * JD-Core Version:    0.7.0.1
 */