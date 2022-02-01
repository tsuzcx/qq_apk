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
  private e agS;
  private a ahi = new a();
  private List<s> ahj = new ArrayList();
  private com.tencent.mm.wear.app.f.b ahk;
  private h ahl;
  private k ahm;
  private com.tencent.mm.wear.app.f.d ahn = new com.tencent.mm.wear.app.f.d()
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
        paramAnonymousArrayOfByte = new File(com.tencent.mm.wear.app.b.h.mU(), localac.XJ + ".amr");
        boolean bool = c.a(paramAnonymousArrayOfByte, localac.Yj.getBytes());
        com.tencent.mm.wear.a.c.d.c("MicroMsg.VoiceMsgAutoPlay", "save voice file result %b %d %s", new Object[] { Boolean.valueOf(bool), Long.valueOf(localac.XJ), paramAnonymousArrayOfByte.getAbsolutePath() });
        if (bool) {
          j.a(j.this, localac.XJ);
        }
        return;
      }
      catch (IOException paramAnonymousArrayOfByte)
      {
        break label27;
      }
    }
  };
  
  private void H(boolean paramBoolean)
  {
    if (this.ahj.size() == 0)
    {
      this.ahi.nr();
      return;
    }
    s locals = (s)this.ahj.remove(0);
    if (!locals.XR) {
      locals.XR = true;
    }
    while (a(locals))
    {
      com.tencent.mm.wear.a.c.d.c("MicroMsg.VoiceMsgAutoPlay", "voice file exist %d", new Object[] { Long.valueOf(locals.XJ) });
      l(locals.XJ);
      return;
      if (!paramBoolean)
      {
        com.tencent.mm.wear.a.c.d.c("MicroMsg.VoiceMsgAutoPlay", "next voice msg is read already", new Object[0]);
        return;
      }
    }
    com.tencent.mm.wear.a.c.d.c("MicroMsg.VoiceMsgAutoPlay", "voice file not exist %d", new Object[] { Long.valueOf(locals.XJ) });
    if (this.ahk != null)
    {
      this.ahk.cancel();
      this.ahk.a(null);
    }
    ab localab = new ab();
    localab.XJ = locals.XJ;
    try
    {
      this.ahk = new com.tencent.mm.wear.app.f.b(11031, localab.toByteArray());
      this.ahk.a(this.ahn);
      com.tencent.mm.wear.app.b.h.mP().a(this.ahk);
      return;
    }
    catch (IOException localIOException) {}
  }
  
  private static boolean a(s params)
  {
    return new File(com.tencent.mm.wear.app.b.h.mU(), String.valueOf(params.XJ) + ".amr").exists();
  }
  
  private void l(long paramLong)
  {
    if (g.j(paramLong))
    {
      if (this.ahl != null)
      {
        this.ahl.ns();
        this.ahl = null;
      }
      this.ahl = new h();
      this.ahl.a(this);
      this.ahl.k(paramLong);
    }
    while (!g.i(paramLong)) {
      return;
    }
    if (this.ahm != null)
    {
      this.ahm.ns();
      this.ahm = null;
    }
    this.ahm = new k();
    this.ahm.a(this);
    this.ahm.k(paramLong);
    com.tencent.mm.wear.a.c.d.c("MicroMsg.VoiceMsgAutoPlay", "voice file arm header", new Object[0]);
  }
  
  public final void a(e parame)
  {
    this.agS = parame;
  }
  
  public final void c(int paramInt, long paramLong)
  {
    if (this.agS != null) {
      this.agS.c(paramInt, paramLong);
    }
    if (paramInt == 0) {
      H(false);
    }
  }
  
  public final void finish()
  {
    if (this.ahk != null)
    {
      this.ahk.cancel();
      this.ahk.a(null);
    }
    ns();
    this.ahj.clear();
  }
  
  public final void g(long paramLong)
  {
    if (this.agS != null) {
      this.agS.g(paramLong);
    }
  }
  
  public final void k(List<s> paramList)
  {
    ns();
    if (paramList.size() == 0) {}
    while (!this.ahi.requestFocus()) {
      return;
    }
    int i = 0;
    for (;;)
    {
      s locals;
      if (i < paramList.size())
      {
        locals = (s)paramList.get(i);
        if (locals.XI.equals(com.tencent.mm.wear.app.b.h.mO().mG().Xh)) {
          break label122;
        }
      }
      label122:
      for (int j = 1; i == 0; j = 0)
      {
        this.ahj.add(locals);
        if (j != 0) {
          break label143;
        }
        com.tencent.mm.wear.a.c.d.c("MicroMsg.VoiceMsgAutoPlay", "ready play list size %d", new Object[] { Integer.valueOf(this.ahj.size()) });
        H(true);
        return;
      }
      if (j != 0) {
        this.ahj.add(locals);
      }
      label143:
      i += 1;
    }
  }
  
  public final void ns()
  {
    if (this.ahk != null) {
      this.ahk.cancel();
    }
    if (this.ahl != null)
    {
      this.ahl.ns();
      this.ahl = null;
    }
    if (this.ahm != null)
    {
      this.ahm.ns();
      this.ahm = null;
    }
    this.ahj.clear();
    this.ahi.nr();
  }
  
  public final long nt()
  {
    if ((this.ahl != null) && (this.ahl.isPlaying())) {
      return this.ahl.nt();
    }
    if ((this.ahm != null) && (this.ahm.isPlaying())) {
      return this.ahm.nt();
    }
    return -1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.d.a.a.j
 * JD-Core Version:    0.7.0.1
 */