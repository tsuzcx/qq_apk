package com.tencent.mm.roomsdk.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;

public final class e
{
  protected com.tencent.mm.roomsdk.a.b.a URj;
  protected com.tencent.mm.roomsdk.a.b.a URk;
  protected com.tencent.mm.roomsdk.a.b.a URl;
  private int URv;
  private i jxB;
  
  private e(int paramInt)
  {
    AppMethodBeat.i(216342);
    this.jxB = new i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
      {
        AppMethodBeat.i(152786);
        if ((paramAnonymousq instanceof com.tencent.mm.roomsdk.a.a)) {
          ((com.tencent.mm.roomsdk.a.a)paramAnonymousq).a(e.this.URl);
        }
        if (e.this.URl != null) {
          e.this.URl.a(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, e.this.URl);
        }
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          if (e.this.URj != null)
          {
            e.this.URj.a(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, e.this.URj);
            AppMethodBeat.o(152786);
          }
        }
        else if (e.this.URk != null) {
          e.this.URk.a(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, e.this.URk);
        }
        AppMethodBeat.o(152786);
      }
    };
    this.URv = 700;
    AppMethodBeat.o(216342);
  }
  
  public static e hrO()
  {
    AppMethodBeat.i(216341);
    e locale = new e(700);
    AppMethodBeat.o(216341);
    return locale;
  }
  
  public final void dead()
  {
    AppMethodBeat.i(152789);
    Log.i("MicroMsg.RoomWatchCallbackFactory", "dead");
    h.aHH();
    h.aHF().kcd.b(this.URv, this.jxB);
    AppMethodBeat.o(152789);
  }
  
  public final e e(com.tencent.mm.roomsdk.a.b.a parama)
  {
    this.URj = parama;
    return this;
  }
  
  public final e f(com.tencent.mm.roomsdk.a.b.a parama)
  {
    this.URk = parama;
    return this;
  }
  
  public final e hrP()
  {
    AppMethodBeat.i(152788);
    Log.i("MicroMsg.RoomWatchCallbackFactory", "alive");
    h.aHH();
    h.aHF().kcd.a(this.URv, this.jxB);
    AppMethodBeat.o(152788);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.roomsdk.a.c.e
 * JD-Core Version:    0.7.0.1
 */