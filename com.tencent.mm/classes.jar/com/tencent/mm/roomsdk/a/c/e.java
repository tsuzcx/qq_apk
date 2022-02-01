package com.tencent.mm.roomsdk.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;

public final class e
{
  protected com.tencent.mm.roomsdk.a.b.a NDM;
  protected com.tencent.mm.roomsdk.a.b.a NDN;
  protected com.tencent.mm.roomsdk.a.b.a NDO;
  private int NDY;
  private i gNh;
  
  private e(int paramInt)
  {
    AppMethodBeat.i(223905);
    this.gNh = new i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
      {
        AppMethodBeat.i(152786);
        if ((paramAnonymousq instanceof com.tencent.mm.roomsdk.a.a)) {
          ((com.tencent.mm.roomsdk.a.a)paramAnonymousq).a(e.this.NDO);
        }
        if (e.this.NDO != null) {
          e.this.NDO.a(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, e.this.NDO);
        }
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          if (e.this.NDM != null)
          {
            e.this.NDM.a(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, e.this.NDM);
            AppMethodBeat.o(152786);
          }
        }
        else if (e.this.NDN != null) {
          e.this.NDN.a(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, e.this.NDN);
        }
        AppMethodBeat.o(152786);
      }
    };
    this.NDY = 700;
    AppMethodBeat.o(223905);
  }
  
  public static e gvQ()
  {
    AppMethodBeat.i(223904);
    e locale = new e(700);
    AppMethodBeat.o(223904);
    return locale;
  }
  
  public final void dead()
  {
    AppMethodBeat.i(152789);
    Log.i("MicroMsg.RoomWatchCallbackFactory", "dead");
    g.aAi();
    g.aAg().hqi.b(this.NDY, this.gNh);
    AppMethodBeat.o(152789);
  }
  
  public final e e(com.tencent.mm.roomsdk.a.b.a parama)
  {
    this.NDM = parama;
    return this;
  }
  
  public final e f(com.tencent.mm.roomsdk.a.b.a parama)
  {
    this.NDN = parama;
    return this;
  }
  
  public final e gvR()
  {
    AppMethodBeat.i(152788);
    Log.i("MicroMsg.RoomWatchCallbackFactory", "alive");
    g.aAi();
    g.aAg().hqi.a(this.NDY, this.gNh);
    AppMethodBeat.o(152788);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.roomsdk.a.c.e
 * JD-Core Version:    0.7.0.1
 */