package com.tencent.mm.plugin.soter;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.soter.b.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.soter.a.b.c;
import com.tencent.soter.a.f.e;
import com.tencent.soter.a.g.b.a;

public final class a
{
  private com.tencent.soter.a.a.a xZP;
  private d xZQ;
  private b xZR;
  
  public final void a(a parama, Context paramContext, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(130802);
    ad.i("MicroMsg.SoterManager", "request authorize and sign: %s, %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.xZP == null) {
      this.xZP = new com.tencent.soter.a.a.a();
    }
    this.xZP.fnn();
    b.a locala = new b.a();
    locala.abX(paramInt2);
    locala.abW(paramInt1);
    locala.kH(paramContext);
    locala.a(this.xZP);
    locala.aNV(paramString);
    if (this.xZR != null) {
      this.xZR.xZX = null;
    }
    this.xZR = new b(parama, paramInt2);
    locala.a(this.xZR);
    if (this.xZQ != null) {
      this.xZQ.xZX = null;
    }
    this.xZQ = new d(parama, paramInt1);
    com.tencent.soter.a.a.a(this.xZQ, locala.IvW);
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
    ad.i("MicroMsg.SoterManager", "prepare auth key internal: %s, %s, %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    com.tencent.soter.a.a.a(new com.tencent.soter.a.b.b() {}, paramBoolean, paramInt1, parame, new f());
    AppMethodBeat.o(130801);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(130803);
    ad.i("MicroMsg.SoterManager", "cancel");
    if (this.xZP != null) {
      this.xZP.xu(true);
    }
    if (this.xZQ != null) {
      this.xZQ.xZX = null;
    }
    if (this.xZR != null) {
      this.xZR.xZX = null;
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
    private int deh;
    a.a xZX;
    
    public b(a.a parama, int paramInt)
    {
      this.xZX = parama;
      this.deh = paramInt;
    }
    
    public final void dED() {}
    
    public final void dEE() {}
    
    public final void onAuthenticationCancelled() {}
    
    public final void onAuthenticationError(int paramInt, CharSequence paramCharSequence) {}
    
    public final void onAuthenticationFailed()
    {
      AppMethodBeat.i(130798);
      ad.i("MicroMsg.SoterManager", "request authorize failed");
      if ((this.deh == 1) && (this.xZX != null)) {
        this.xZX.a(1, new com.tencent.soter.a.b.a());
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
    private int scene;
    a.a xZX;
    
    public d(a.a parama, int paramInt)
    {
      this.xZX = parama;
      this.scene = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.a
 * JD-Core Version:    0.7.0.1
 */