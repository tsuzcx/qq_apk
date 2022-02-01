package com.tencent.mm.plugin.soter;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.soter.b.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.soter.a.b.c;
import com.tencent.soter.a.f.e;
import com.tencent.soter.a.g.b.a;

public final class a
{
  private com.tencent.soter.a.a.a Fhf;
  private d Fhg;
  private b Fhh;
  
  public final void a(a parama, Context paramContext, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(130802);
    Log.i("MicroMsg.SoterManager", "request authorize and sign: %s, %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.Fhf == null) {
      this.Fhf = new com.tencent.soter.a.a.a();
    }
    this.Fhf.hlF();
    b.a locala = new b.a();
    locala.aqM(paramInt2);
    locala.aqL(paramInt1);
    locala.lh(paramContext);
    locala.a(this.Fhf);
    locala.bqn(paramString);
    if (this.Fhh != null) {
      this.Fhh.Fhn = null;
    }
    this.Fhh = new b(parama, paramInt2);
    locala.a(this.Fhh);
    if (this.Fhg != null) {
      this.Fhg.Fhn = null;
    }
    this.Fhg = new d(parama, paramInt1);
    com.tencent.soter.a.a.a(this.Fhg, locala.RQV);
    AppMethodBeat.o(130802);
  }
  
  public final void a(c paramc, e parame)
  {
    AppMethodBeat.i(130800);
    a(paramc, true, 1, parame, 0);
    AppMethodBeat.o(130800);
  }
  
  final void a(final c paramc, final boolean paramBoolean, final int paramInt1, final e parame, final int paramInt2)
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
    if (this.Fhf != null) {
      this.Fhf.DP(true);
    }
    if (this.Fhg != null) {
      this.Fhg.Fhn = null;
    }
    if (this.Fhh != null) {
      this.Fhh.Fhn = null;
    }
    AppMethodBeat.o(130803);
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt, com.tencent.soter.a.b.a parama);
    
    public abstract void b(com.tencent.soter.a.b.a parama);
  }
  
  static final class b
    implements com.tencent.soter.a.a.b
  {
    a.a Fhn;
    private int dFq;
    
    public b(a.a parama, int paramInt)
    {
      this.Fhn = parama;
      this.dFq = paramInt;
    }
    
    public final void fly() {}
    
    public final void flz() {}
    
    public final void onAuthenticationCancelled() {}
    
    public final void onAuthenticationError(int paramInt, CharSequence paramCharSequence) {}
    
    public final void onAuthenticationFailed()
    {
      AppMethodBeat.i(130798);
      Log.i("MicroMsg.SoterManager", "request authorize failed");
      if ((this.dFq == 1) && (this.Fhn != null)) {
        this.Fhn.a(1, new com.tencent.soter.a.b.a());
      }
      AppMethodBeat.o(130798);
    }
    
    public final void onAuthenticationHelp(int paramInt, CharSequence paramCharSequence) {}
  }
  
  public static abstract interface c
  {
    public abstract void a(c paramc);
    
    public abstract void b(c paramc);
  }
  
  static final class d
    implements com.tencent.soter.a.b.b<com.tencent.soter.a.b.a>
  {
    a.a Fhn;
    private int scene;
    
    public d(a.a parama, int paramInt)
    {
      this.Fhn = parama;
      this.scene = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.a
 * JD-Core Version:    0.7.0.1
 */