package com.tencent.mm.roomsdk.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;

public final class e
{
  protected com.tencent.mm.roomsdk.a.b.a HWh;
  protected com.tencent.mm.roomsdk.a.b.a HWi;
  protected com.tencent.mm.roomsdk.a.b.a HWj;
  private int HWt;
  private f hPn;
  
  public e()
  {
    AppMethodBeat.i(152787);
    this.hPn = new f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(152786);
        if ((paramAnonymousn instanceof com.tencent.mm.roomsdk.a.a)) {
          ((com.tencent.mm.roomsdk.a.a)paramAnonymousn).a(e.this.HWj);
        }
        if (e.this.HWj != null) {
          e.this.HWj.a(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, e.this.HWj);
        }
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          if (e.this.HWh != null)
          {
            e.this.HWh.a(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, e.this.HWh);
            AppMethodBeat.o(152786);
          }
        }
        else if (e.this.HWi != null) {
          e.this.HWi.a(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, e.this.HWi);
        }
        AppMethodBeat.o(152786);
      }
    };
    this.HWt = 700;
    AppMethodBeat.o(152787);
  }
  
  public final void dead()
  {
    AppMethodBeat.i(152789);
    ad.i("MicroMsg.RoomWatchCallbackFactory", "dead");
    g.ajD();
    g.ajB().gAO.b(this.HWt, this.hPn);
    AppMethodBeat.o(152789);
  }
  
  public final e e(com.tencent.mm.roomsdk.a.b.a parama)
  {
    this.HWh = parama;
    return this;
  }
  
  public final e f(com.tencent.mm.roomsdk.a.b.a parama)
  {
    this.HWi = parama;
    return this;
  }
  
  public final e fim()
  {
    AppMethodBeat.i(152788);
    ad.i("MicroMsg.RoomWatchCallbackFactory", "alive");
    g.ajD();
    g.ajB().gAO.a(this.HWt, this.hPn);
    AppMethodBeat.o(152788);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.roomsdk.a.c.e
 * JD-Core Version:    0.7.0.1
 */