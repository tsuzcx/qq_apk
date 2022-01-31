package com.tencent.mm.wear.app.d.a.a;

import com.tencent.mm.e.a.ab;
import com.tencent.mm.e.a.ac;
import com.tencent.mm.e.a.m;
import com.tencent.mm.e.a.s;
import com.tencent.mm.wear.a.f.c;
import com.tencent.mm.wear.app.d.a.a;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class j
  implements e
{
  private a adG = new a();
  private List<s> adH = new ArrayList();
  private com.tencent.mm.wear.app.f.b adI;
  private h adJ;
  private k adK;
  private com.tencent.mm.wear.app.f.d adL = new com.tencent.mm.wear.app.f.d()
  {
    public final void b(int paramAnonymousInt1, int paramAnonymousInt2, byte[] paramAnonymousArrayOfByte)
    {
      ac localac;
      if ((paramAnonymousInt1 == 11031) && (paramAnonymousInt2 == 0)) {
        localac = new ac();
      }
      try
      {
        localac.h(paramAnonymousArrayOfByte);
        label27:
        paramAnonymousArrayOfByte = new File(com.tencent.mm.wear.app.b.h.mi(), localac.VO + ".amr");
        boolean bool = c.a(paramAnonymousArrayOfByte, localac.Wo.getBytes());
        com.tencent.mm.wear.a.c.d.c("MicroMsg.VoiceMsgAutoPlay", "save voice file result %b %d %s", new Object[] { Boolean.valueOf(bool), Long.valueOf(localac.VO), paramAnonymousArrayOfByte.getAbsolutePath() });
        if (bool) {
          j.a(j.this, localac.VO);
        }
        return;
      }
      catch (IOException paramAnonymousArrayOfByte)
      {
        break label27;
      }
    }
  };
  private e adq;
  
  private void E(boolean paramBoolean)
  {
    if (this.adH.size() == 0)
    {
      this.adG.mF();
      return;
    }
    s locals = (s)this.adH.remove(0);
    if (!locals.VW) {
      locals.VW = true;
    }
    while (new File(com.tencent.mm.wear.app.b.h.mi(), String.valueOf(locals.VO) + ".amr").exists())
    {
      com.tencent.mm.wear.a.c.d.c("MicroMsg.VoiceMsgAutoPlay", "voice file exist %d", new Object[] { Long.valueOf(locals.VO) });
      i(locals.VO);
      return;
      if (!paramBoolean)
      {
        com.tencent.mm.wear.a.c.d.c("MicroMsg.VoiceMsgAutoPlay", "next voice msg is read already", new Object[0]);
        return;
      }
    }
    com.tencent.mm.wear.a.c.d.c("MicroMsg.VoiceMsgAutoPlay", "voice file not exist %d", new Object[] { Long.valueOf(locals.VO) });
    if (this.adI != null)
    {
      this.adI.cancel();
      this.adI.a(null);
    }
    ab localab = new ab();
    localab.VO = locals.VO;
    try
    {
      this.adI = new com.tencent.mm.wear.app.f.b(11031, localab.toByteArray());
      this.adI.a(this.adL);
      com.tencent.mm.wear.app.b.h.mc().a(this.adI);
      return;
    }
    catch (IOException localIOException) {}
  }
  
  private void i(long paramLong)
  {
    if (g.K(new File(com.tencent.mm.wear.app.b.h.mi(), paramLong + ".amr").getAbsolutePath()))
    {
      if (this.adJ != null)
      {
        this.adJ.mG();
        this.adJ = null;
      }
      this.adJ = new h();
      this.adJ.a(this);
      this.adJ.h(paramLong);
    }
    while (!g.J(new File(com.tencent.mm.wear.app.b.h.mi(), paramLong + ".amr").getAbsolutePath())) {
      return;
    }
    if (this.adK != null)
    {
      this.adK.mG();
      this.adK = null;
    }
    this.adK = new k();
    this.adK.a(this);
    this.adK.a(new File(com.tencent.mm.wear.app.b.h.mi(), paramLong + ".amr").getAbsolutePath(), paramLong);
    com.tencent.mm.wear.a.c.d.c("MicroMsg.VoiceMsgAutoPlay", "voice file arm header", new Object[0]);
  }
  
  public final void a(e parame)
  {
    this.adq = parame;
  }
  
  public final void c(int paramInt, long paramLong)
  {
    if (this.adq != null) {
      this.adq.c(paramInt, paramLong);
    }
    if (paramInt == 0) {
      E(false);
    }
  }
  
  public final void f(long paramLong)
  {
    if (this.adq != null) {
      this.adq.f(paramLong);
    }
  }
  
  public final void finish()
  {
    if (this.adI != null)
    {
      this.adI.cancel();
      this.adI.a(null);
    }
    mG();
    this.adH.clear();
  }
  
  public final void k(List<s> paramList)
  {
    mG();
    if (paramList.size() == 0) {}
    while (!this.adG.requestFocus()) {
      return;
    }
    int i = 0;
    for (;;)
    {
      s locals;
      if (i < paramList.size())
      {
        locals = (s)paramList.get(i);
        if (locals.VN.equals(com.tencent.mm.wear.app.b.h.mb().lT().Vm)) {
          break label122;
        }
      }
      label122:
      for (int j = 1; i == 0; j = 0)
      {
        this.adH.add(locals);
        if (j != 0) {
          break label143;
        }
        com.tencent.mm.wear.a.c.d.c("MicroMsg.VoiceMsgAutoPlay", "ready play list size %d", new Object[] { Integer.valueOf(this.adH.size()) });
        E(true);
        return;
      }
      if (j != 0) {
        this.adH.add(locals);
      }
      label143:
      i += 1;
    }
  }
  
  public final void mG()
  {
    if (this.adI != null) {
      this.adI.cancel();
    }
    if (this.adJ != null)
    {
      this.adJ.mG();
      this.adJ = null;
    }
    if (this.adK != null)
    {
      this.adK.mG();
      this.adK = null;
    }
    this.adH.clear();
    this.adG.mF();
  }
  
  public final long mH()
  {
    if ((this.adJ != null) && (this.adJ.isPlaying())) {
      return this.adJ.mH();
    }
    if ((this.adK != null) && (this.adK.isPlaying())) {
      return this.adK.mH();
    }
    return -1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.d.a.a.j
 * JD-Core Version:    0.7.0.1
 */