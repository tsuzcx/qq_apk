package com.tencent.mm.plugin.soter;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.soter.b.f;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.soter.a.b.c;
import com.tencent.soter.a.f.e;
import com.tencent.soter.a.g.b.a;

public final class a
{
  private com.tencent.soter.a.a.a AWm;
  private d AWn;
  private b AWo;
  
  public final void a(a parama, Context paramContext, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(130802);
    ae.i("MicroMsg.SoterManager", "request authorize and sign: %s, %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.AWm == null) {
      this.AWm = new com.tencent.soter.a.a.a();
    }
    this.AWm.fZu();
    b.a locala = new b.a();
    locala.ahz(paramInt2);
    locala.ahy(paramInt1);
    locala.lm(paramContext);
    locala.a(this.AWm);
    locala.bbb(paramString);
    if (this.AWo != null) {
      this.AWo.AWu = null;
    }
    this.AWo = new b(parama, paramInt2);
    locala.a(this.AWo);
    if (this.AWn != null) {
      this.AWn.AWu = null;
    }
    this.AWn = new d(parama, paramInt1);
    com.tencent.soter.a.a.a(this.AWn, locala.Mox);
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
    ae.i("MicroMsg.SoterManager", "prepare auth key internal: %s, %s, %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    com.tencent.soter.a.a.a(new com.tencent.soter.a.b.b() {}, paramBoolean, paramInt1, parame, new f());
    AppMethodBeat.o(130801);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(130803);
    ae.i("MicroMsg.SoterManager", "cancel");
    if (this.AWm != null) {
      this.AWm.zF(true);
    }
    if (this.AWn != null) {
      this.AWn.AWu = null;
    }
    if (this.AWo != null) {
      this.AWo.AWu = null;
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
    a.a AWu;
    private int dob;
    
    public b(a.a parama, int paramInt)
    {
      this.AWu = parama;
      this.dob = paramInt;
    }
    
    public final void eiY() {}
    
    public final void eiZ() {}
    
    public final void onAuthenticationCancelled() {}
    
    public final void onAuthenticationError(int paramInt, CharSequence paramCharSequence) {}
    
    public final void onAuthenticationFailed()
    {
      AppMethodBeat.i(130798);
      ae.i("MicroMsg.SoterManager", "request authorize failed");
      if ((this.dob == 1) && (this.AWu != null)) {
        this.AWu.a(1, new com.tencent.soter.a.b.a());
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
    a.a AWu;
    private int scene;
    
    public d(a.a parama, int paramInt)
    {
      this.AWu = parama;
      this.scene = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.a
 * JD-Core Version:    0.7.0.1
 */