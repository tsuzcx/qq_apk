package com.tencent.mm.plugin.sight.decode.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.xc;
import com.tencent.mm.g.a.xc.a;
import com.tencent.mm.sdk.b.c;
import java.lang.ref.WeakReference;

final class b$a
  extends c<xc>
{
  int rwG;
  int sWU;
  int ySd;
  WeakReference<b> ySe;
  
  public b$a(b paramb)
  {
    super(0);
    AppMethodBeat.i(116075);
    this.sWU = 0;
    this.ySd = 0;
    this.rwG = 0;
    this.ySe = new WeakReference(paramb);
    this.__eventId = xc.class.getName().hashCode();
    AppMethodBeat.o(116075);
  }
  
  private void a(xc paramxc)
  {
    this.sWU = paramxc.dLv.dLy;
    this.ySd = paramxc.dLv.dLw;
    this.rwG = paramxc.dLv.dLx;
  }
  
  private boolean dQi()
  {
    AppMethodBeat.i(116076);
    if (this.ySe.get() == null)
    {
      AppMethodBeat.o(116076);
      return false;
    }
    int i = b.G((b)this.ySe.get()) + this.sWU;
    if ((i < this.ySd) || (i > this.rwG))
    {
      AppMethodBeat.o(116076);
      return false;
    }
    AppMethodBeat.o(116076);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.a.b.a
 * JD-Core Version:    0.7.0.1
 */