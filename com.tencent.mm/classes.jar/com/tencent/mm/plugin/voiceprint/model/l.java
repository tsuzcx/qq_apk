package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class l
  implements com.tencent.mm.ai.f
{
  public int trh;
  public int trt;
  private String tru;
  public int trv;
  public a trw;
  
  public l()
  {
    AppMethodBeat.i(26111);
    this.trt = 71;
    this.tru = null;
    this.trv = 0;
    this.trh = 0;
    this.trw = null;
    aw.Rc().a(611, this);
    aw.Rc().a(612, this);
    AppMethodBeat.o(26111);
  }
  
  public l(a parama)
  {
    this();
    this.trw = parama;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(26112);
    ab.d("MicroMsg.VoicePrintCreateService", "onSceneEnd, errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 != 0) && (paramInt2 != 0))
    {
      if (paramInt2 == -34)
      {
        ab.d("MicroMsg.VoicePrintCreateService", "blocked by limit");
        if (this.trw != null) {
          this.trw.cLg();
        }
        AppMethodBeat.o(26112);
        return;
      }
      if (this.trw != null) {
        this.trw.cLf();
      }
      AppMethodBeat.o(26112);
      return;
    }
    if (paramm.getType() == 611)
    {
      paramString = (d)paramm;
      this.trv = paramString.tra;
      this.tru = paramString.tqZ;
      ab.d("MicroMsg.VoicePrintCreateService", "onFinishGetText, resId:%d, voiceText==null:%b", new Object[] { Integer.valueOf(this.trv), Boolean.valueOf(bo.isNullOrNil(this.tru)) });
      if (this.trw != null)
      {
        if (this.trt != 71) {
          break label332;
        }
        this.trw.aeB(this.tru);
      }
    }
    if (paramm.getType() == 612)
    {
      paramString = (f)paramm;
      if (((paramString.trj != 72) || (paramString.DW != 0)) && (paramString.trj != 71)) {
        break label357;
      }
      paramInt1 = 1;
      label238:
      if (paramInt1 == 0) {
        break label362;
      }
      ab.d("MicroMsg.VoicePrintCreateService", "onRegister, ok, step:%d", new Object[] { Integer.valueOf(paramString.trj) });
      this.trh = paramString.trh;
      if (this.trw != null) {
        this.trw.F(true, paramString.trj);
      }
    }
    for (;;)
    {
      if ((paramInt1 != 0) && (paramString.trj == 71) && (this.trw != null)) {
        this.trw.aeC(this.tru);
      }
      AppMethodBeat.o(26112);
      return;
      label332:
      if (this.trt != 72) {
        break;
      }
      this.trw.aeC(this.tru);
      break;
      label357:
      paramInt1 = 0;
      break label238;
      label362:
      ab.d("MicroMsg.VoicePrintCreateService", "onRegister, not ok, step:%d", new Object[] { Integer.valueOf(paramString.trj) });
      if (this.trw != null) {
        this.trw.F(false, paramString.trj);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void F(boolean paramBoolean, int paramInt);
    
    public abstract void aeB(String paramString);
    
    public abstract void aeC(String paramString);
    
    public abstract void cLf();
    
    public abstract void cLg();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.l
 * JD-Core Version:    0.7.0.1
 */