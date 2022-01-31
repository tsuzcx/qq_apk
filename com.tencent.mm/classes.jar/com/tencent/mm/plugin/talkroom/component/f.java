package com.tencent.mm.plugin.talkroom.component;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c;
import com.tencent.mm.audio.b.c.a;
import com.tencent.mm.plugin.talkroom.model.a;

public final class f
  extends d.a
{
  private c ciR;
  private c.a cjU;
  private v2engine tbv;
  private short tbw;
  private short tbx;
  
  public f(v2engine paramv2engine)
  {
    AppMethodBeat.i(25714);
    this.cjU = new f.1(this);
    this.tbv = paramv2engine;
    AppMethodBeat.o(25714);
  }
  
  public final void akP()
  {
    AppMethodBeat.i(25716);
    this.ciR = new c(a.tbK, 1, 2);
    this.ciR.t(8, false);
    this.ciR.cjD = this.cjU;
    this.ciR.gA(20);
    this.ciR.EC();
    this.tbx = 0;
    this.tbw = 0;
    AppMethodBeat.o(25716);
  }
  
  public final void cHp()
  {
    AppMethodBeat.i(25715);
    if (this.ciR != null)
    {
      this.ciR.Et();
      this.ciR = null;
    }
    AppMethodBeat.o(25715);
  }
  
  public final int cHq()
  {
    if (this.tbx < this.tbw) {
      this.tbx = this.tbw;
    }
    if (this.tbx == 0) {
      return 0;
    }
    int i = (short)(this.tbw * 100 / this.tbx);
    this.tbw = 0;
    return i;
  }
  
  public final void release()
  {
    AppMethodBeat.i(25717);
    cHp();
    AppMethodBeat.o(25717);
  }
  
  public final void start() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.component.f
 * JD-Core Version:    0.7.0.1
 */