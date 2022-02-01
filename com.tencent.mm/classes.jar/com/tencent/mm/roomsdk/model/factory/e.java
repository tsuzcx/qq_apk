package com.tencent.mm.roomsdk.model.factory;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.kernel.c;
import com.tencent.mm.sdk.platformtools.Log;

public final class e
{
  private int acmI;
  protected com.tencent.mm.roomsdk.model.b.a acmx;
  protected com.tencent.mm.roomsdk.model.b.a acmy;
  protected com.tencent.mm.roomsdk.model.b.a acmz;
  private com.tencent.mm.am.h maV;
  
  private e(int paramInt)
  {
    AppMethodBeat.i(234082);
    this.maV = new com.tencent.mm.am.h()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
      {
        AppMethodBeat.i(152786);
        if ((paramAnonymousp instanceof com.tencent.mm.roomsdk.model.a)) {
          ((com.tencent.mm.roomsdk.model.a)paramAnonymousp).a(e.this.acmz);
        }
        if (e.this.acmz != null) {
          e.this.acmz.onResult(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, e.this.acmz);
        }
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          if (e.this.acmx != null)
          {
            e.this.acmx.onResult(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, e.this.acmx);
            AppMethodBeat.o(152786);
          }
        }
        else if (e.this.acmy != null) {
          e.this.acmy.onResult(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, e.this.acmy);
        }
        AppMethodBeat.o(152786);
      }
    };
    this.acmI = 700;
    AppMethodBeat.o(234082);
  }
  
  public static e iRU()
  {
    AppMethodBeat.i(234081);
    e locale = new e(700);
    AppMethodBeat.o(234081);
    return locale;
  }
  
  public final void dead()
  {
    AppMethodBeat.i(152789);
    Log.i("MicroMsg.RoomWatchCallbackFactory", "dead");
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(this.acmI, this.maV);
    AppMethodBeat.o(152789);
  }
  
  public final e e(com.tencent.mm.roomsdk.model.b.a parama)
  {
    this.acmx = parama;
    return this;
  }
  
  public final e f(com.tencent.mm.roomsdk.model.b.a parama)
  {
    this.acmy = parama;
    return this;
  }
  
  public final e iRV()
  {
    AppMethodBeat.i(152788);
    Log.i("MicroMsg.RoomWatchCallbackFactory", "alive");
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(this.acmI, this.maV);
    AppMethodBeat.o(152788);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.roomsdk.model.factory.e
 * JD-Core Version:    0.7.0.1
 */