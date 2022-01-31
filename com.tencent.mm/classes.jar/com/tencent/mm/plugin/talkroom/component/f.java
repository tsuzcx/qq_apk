package com.tencent.mm.plugin.talkroom.component;

import com.tencent.mm.f.b.c;
import com.tencent.mm.f.b.c.a;
import com.tencent.mm.plugin.talkroom.model.a;

public final class f
  extends d.a
{
  private c bCc;
  private c.a bDg = new f.1(this);
  private v2engine pzJ;
  private short pzK;
  private short pzL;
  
  public f(v2engine paramv2engine)
  {
    this.pzJ = paramv2engine;
  }
  
  public final void RG()
  {
    this.bCc = new c(a.pzY, 1, 2);
    this.bCc.t(8, false);
    this.bCc.bCP = this.bDg;
    this.bCc.ey(20);
    this.bCc.uq();
    this.pzL = 0;
    this.pzK = 0;
  }
  
  public final void bMq()
  {
    if (this.bCc != null)
    {
      this.bCc.uh();
      this.bCc = null;
    }
  }
  
  public final int bMr()
  {
    if (this.pzL < this.pzK) {
      this.pzL = this.pzK;
    }
    if (this.pzL == 0) {
      return 0;
    }
    int i = (short)(this.pzK * 100 / this.pzL);
    this.pzK = 0;
    return i;
  }
  
  public final void release()
  {
    bMq();
  }
  
  public final void start() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.component.f
 * JD-Core Version:    0.7.0.1
 */