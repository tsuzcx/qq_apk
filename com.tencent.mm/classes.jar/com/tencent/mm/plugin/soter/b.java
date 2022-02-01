package com.tencent.mm.plugin.soter;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.soter.b.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.soter.a.b.c;
import com.tencent.soter.a.f.e;

public final class b
{
  private com.tencent.soter.a.a.a RZi;
  private e RZj;
  private c RZk;
  
  public final void a(b paramb, Context paramContext, int paramInt1, int paramInt2, String paramString, a parama)
  {
    AppMethodBeat.i(262498);
    Log.i("MicroMsg.SoterManager", "request authorize and sign: %s, %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.RZi == null) {
      this.RZi = new com.tencent.soter.a.a.a();
    }
    this.RZi.jYs();
    com.tencent.soter.a.g.b.a locala = new com.tencent.soter.a.g.b.a();
    locala.aHl(paramInt2);
    locala.aHk(paramInt1);
    locala.os(paramContext);
    locala.a(this.RZi);
    locala.bFL(paramString);
    if (parama != null)
    {
      locala.jYz();
      locala.bFM(parama.title);
      locala.bFN(parama.uCW);
      locala.bFO(parama.description);
      locala.bFP(parama.RZq);
    }
    if (this.RZk != null) {
      this.RZk.RZr = null;
    }
    this.RZk = new c(paramb, paramInt2);
    locala.a(this.RZk);
    if (this.RZj != null) {
      this.RZj.RZr = null;
    }
    this.RZj = new e(paramb, paramInt1);
    com.tencent.soter.a.a.a(this.RZj, locala.ahys);
    AppMethodBeat.o(262498);
  }
  
  public final void a(d paramd, e parame)
  {
    AppMethodBeat.i(130800);
    a(paramd, true, 1, parame, 0);
    AppMethodBeat.o(130800);
  }
  
  final void a(final d paramd, final boolean paramBoolean, final int paramInt1, final e parame, final int paramInt2)
  {
    AppMethodBeat.i(130801);
    Log.i("MicroMsg.SoterManager", "prepare auth key internal: %s, %s, %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    com.tencent.soter.a.a.a(new com.tencent.soter.a.b.b() {}, paramBoolean, paramInt1, parame, new f());
    AppMethodBeat.o(130801);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(130803);
    Log.i("MicroMsg.SoterManager", "cancel");
    if (this.RZi != null) {
      this.RZi.Os(true);
    }
    if (this.RZj != null) {
      this.RZj.RZr = null;
    }
    if (this.RZk != null) {
      this.RZk.RZr = null;
    }
    AppMethodBeat.o(130803);
  }
  
  public static final class a
  {
    public String RZq;
    public String description;
    public String title;
    public String uCW;
  }
  
  public static abstract interface b
  {
    public abstract void a(int paramInt, com.tencent.soter.a.b.a parama);
    
    public abstract void b(com.tencent.soter.a.b.a parama);
  }
  
  static final class c
    implements com.tencent.soter.a.a.b
  {
    b.b RZr;
    private int hCD;
    
    public c(b.b paramb, int paramInt)
    {
      this.RZr = paramb;
      this.hCD = paramInt;
    }
    
    public final void htl() {}
    
    public final void htm() {}
    
    public final void onAuthenticationCancelled() {}
    
    public final void onAuthenticationError(int paramInt, CharSequence paramCharSequence) {}
    
    public final void onAuthenticationFailed()
    {
      AppMethodBeat.i(130798);
      Log.i("MicroMsg.SoterManager", "request authorize failed");
      if ((this.hCD == 1) && (this.RZr != null)) {
        this.RZr.a(1, new com.tencent.soter.a.b.a());
      }
      AppMethodBeat.o(130798);
    }
    
    public final void onAuthenticationHelp(int paramInt, CharSequence paramCharSequence) {}
  }
  
  public static abstract interface d
  {
    public abstract void a(c paramc);
    
    public abstract void b(c paramc);
  }
  
  static final class e
    implements com.tencent.soter.a.b.b<com.tencent.soter.a.b.a>
  {
    b.b RZr;
    private int scene;
    
    public e(b.b paramb, int paramInt)
    {
      this.RZr = paramb;
      this.scene = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.b
 * JD-Core Version:    0.7.0.1
 */