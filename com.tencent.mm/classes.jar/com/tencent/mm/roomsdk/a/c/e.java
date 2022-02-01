package com.tencent.mm.roomsdk.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.sdk.platformtools.ac;

public final class e
{
  private int GkH;
  protected com.tencent.mm.roomsdk.a.b.a Gkv;
  protected com.tencent.mm.roomsdk.a.b.a Gkw;
  protected com.tencent.mm.roomsdk.a.b.a Gkx;
  private com.tencent.mm.ak.g hwV;
  
  public e()
  {
    AppMethodBeat.i(152787);
    this.hwV = new com.tencent.mm.ak.g()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(152786);
        if ((paramAnonymousn instanceof com.tencent.mm.roomsdk.a.a)) {
          ((com.tencent.mm.roomsdk.a.a)paramAnonymousn).a(e.this.Gkx);
        }
        if (e.this.Gkx != null) {
          e.this.Gkx.a(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, e.this.Gkx);
        }
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          if (e.this.Gkv != null)
          {
            e.this.Gkv.a(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, e.this.Gkv);
            AppMethodBeat.o(152786);
          }
        }
        else if (e.this.Gkw != null) {
          e.this.Gkw.a(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, e.this.Gkw);
        }
        AppMethodBeat.o(152786);
      }
    };
    this.GkH = 700;
    AppMethodBeat.o(152787);
  }
  
  public final void dead()
  {
    AppMethodBeat.i(152789);
    ac.i("MicroMsg.RoomWatchCallbackFactory", "dead");
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.b(this.GkH, this.hwV);
    AppMethodBeat.o(152789);
  }
  
  public final e e(com.tencent.mm.roomsdk.a.b.a parama)
  {
    this.Gkv = parama;
    return this;
  }
  
  public final e eSK()
  {
    AppMethodBeat.i(152788);
    ac.i("MicroMsg.RoomWatchCallbackFactory", "alive");
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.a(this.GkH, this.hwV);
    AppMethodBeat.o(152788);
    return this;
  }
  
  public final e f(com.tencent.mm.roomsdk.a.b.a parama)
  {
    this.Gkw = parama;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.roomsdk.a.c.e
 * JD-Core Version:    0.7.0.1
 */