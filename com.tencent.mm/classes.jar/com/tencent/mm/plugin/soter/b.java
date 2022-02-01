package com.tencent.mm.plugin.soter;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.soter.b.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.soter.a.f.e;

public final class b
{
  private com.tencent.soter.a.a.a LvK;
  private b.d LvL;
  private b LvM;
  
  public final void a(b.a parama, Context paramContext, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(130802);
    Log.i("MicroMsg.SoterManager", "request authorize and sign: %s, %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.LvK == null) {
      this.LvK = new com.tencent.soter.a.a.a();
    }
    this.LvK.ipe();
    com.tencent.soter.a.g.b.a locala = new com.tencent.soter.a.g.b.a();
    locala.aAz(paramInt2);
    locala.aAy(paramInt1);
    locala.mf(paramContext);
    locala.a(this.LvK);
    locala.bDg(paramString);
    if (this.LvM != null) {
      this.LvM.LvS = null;
    }
    this.LvM = new b(parama, paramInt2);
    locala.a(this.LvM);
    if (this.LvL != null) {
      this.LvL.LvS = null;
    }
    this.LvL = new b.d(parama, paramInt1);
    com.tencent.soter.a.a.a(this.LvL, locala.Ztz);
    AppMethodBeat.o(130802);
  }
  
  public final void a(b.c paramc, e parame)
  {
    AppMethodBeat.i(130800);
    a(paramc, true, 1, parame, 0);
    AppMethodBeat.o(130800);
  }
  
  final void a(b.c paramc, boolean paramBoolean, int paramInt1, e parame, int paramInt2)
  {
    AppMethodBeat.i(130801);
    Log.i("MicroMsg.SoterManager", "prepare auth key internal: %s, %s, %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    com.tencent.soter.a.a.a(new b.1(this, paramc, paramInt2, parame, paramBoolean, paramInt1), paramBoolean, paramInt1, parame, new f());
    AppMethodBeat.o(130801);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(130803);
    Log.i("MicroMsg.SoterManager", "cancel");
    if (this.LvK != null) {
      this.LvK.Iq(true);
    }
    if (this.LvL != null) {
      this.LvL.LvS = null;
    }
    if (this.LvM != null) {
      this.LvM.LvS = null;
    }
    AppMethodBeat.o(130803);
  }
  
  static final class b
    implements com.tencent.soter.a.a.b
  {
    b.a LvS;
    private int fxY;
    
    public b(b.a parama, int paramInt)
    {
      this.LvS = parama;
      this.fxY = paramInt;
    }
    
    public final void fZU() {}
    
    public final void fZV() {}
    
    public final void onAuthenticationCancelled() {}
    
    public final void onAuthenticationError(int paramInt, CharSequence paramCharSequence) {}
    
    public final void onAuthenticationFailed()
    {
      AppMethodBeat.i(130798);
      Log.i("MicroMsg.SoterManager", "request authorize failed");
      if ((this.fxY == 1) && (this.LvS != null)) {
        this.LvS.a(1, new com.tencent.soter.a.b.a());
      }
      AppMethodBeat.o(130798);
    }
    
    public final void onAuthenticationHelp(int paramInt, CharSequence paramCharSequence) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.b
 * JD-Core Version:    0.7.0.1
 */