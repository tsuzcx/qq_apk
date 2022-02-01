package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.bc;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class l
  implements com.tencent.mm.ak.f
{
  public int CmT;
  public int Cnf;
  private String Cng;
  public int Cnh;
  public a Cni;
  
  public l()
  {
    AppMethodBeat.i(29792);
    this.Cnf = 71;
    this.Cng = null;
    this.Cnh = 0;
    this.CmT = 0;
    this.Cni = null;
    bc.ajj().a(611, this);
    bc.ajj().a(612, this);
    AppMethodBeat.o(29792);
  }
  
  public l(a parama)
  {
    this();
    this.Cni = parama;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(29793);
    ae.d("MicroMsg.VoicePrintCreateService", "onSceneEnd, errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 != 0) && (paramInt2 != 0))
    {
      if (paramInt2 == -34)
      {
        ae.d("MicroMsg.VoicePrintCreateService", "blocked by limit");
        if (this.Cni != null) {
          this.Cni.aEU(paramString);
        }
        AppMethodBeat.o(29793);
        return;
      }
      if (this.Cni != null) {
        this.Cni.exP();
      }
      AppMethodBeat.o(29793);
      return;
    }
    if (paramn.getType() == 611)
    {
      paramString = (d)paramn;
      this.Cnh = paramString.CmM;
      this.Cng = paramString.CmL;
      ae.d("MicroMsg.VoicePrintCreateService", "onFinishGetText, resId:%d, voiceText==null:%b", new Object[] { Integer.valueOf(this.Cnh), Boolean.valueOf(bu.isNullOrNil(this.Cng)) });
      if (this.Cni != null)
      {
        if (this.Cnf != 71) {
          break label333;
        }
        this.Cni.aES(this.Cng);
      }
    }
    if (paramn.getType() == 612)
    {
      paramString = (f)paramn;
      if (((paramString.CmV != 72) || (paramString.Nv != 0)) && (paramString.CmV != 71)) {
        break label358;
      }
      paramInt1 = 1;
      label239:
      if (paramInt1 == 0) {
        break label363;
      }
      ae.d("MicroMsg.VoicePrintCreateService", "onRegister, ok, step:%d", new Object[] { Integer.valueOf(paramString.CmV) });
      this.CmT = paramString.CmT;
      if (this.Cni != null) {
        this.Cni.V(true, paramString.CmV);
      }
    }
    for (;;)
    {
      if ((paramInt1 != 0) && (paramString.CmV == 71) && (this.Cni != null)) {
        this.Cni.aET(this.Cng);
      }
      AppMethodBeat.o(29793);
      return;
      label333:
      if (this.Cnf != 72) {
        break;
      }
      this.Cni.aET(this.Cng);
      break;
      label358:
      paramInt1 = 0;
      break label239;
      label363:
      ae.d("MicroMsg.VoicePrintCreateService", "onRegister, not ok, step:%d", new Object[] { Integer.valueOf(paramString.CmV) });
      if (this.Cni != null) {
        this.Cni.V(false, paramString.CmV);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void V(boolean paramBoolean, int paramInt);
    
    public abstract void aES(String paramString);
    
    public abstract void aET(String paramString);
    
    public abstract void aEU(String paramString);
    
    public abstract void exP();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.l
 * JD-Core Version:    0.7.0.1
 */