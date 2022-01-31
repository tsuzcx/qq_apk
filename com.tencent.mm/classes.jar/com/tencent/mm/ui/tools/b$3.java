package com.tencent.mm.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.d;
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.o;
import com.tencent.mm.aj.z;
import com.tencent.mm.g.a.ah;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf.a;
import com.tencent.mm.sdk.b.a;

final class b$3
  implements bf.a
{
  b$3(d paramd, String paramString) {}
  
  public final boolean JS()
  {
    AppMethodBeat.i(34787);
    boolean bool = b.access$000();
    AppMethodBeat.o(34787);
    return bool;
  }
  
  public final void JT()
  {
    AppMethodBeat.i(34788);
    if (this.Aqz.aee())
    {
      g.E(o.class);
      com.tencent.mm.storage.p.aqS(this.pxM);
      ah localah = new ah();
      localah.cnr.userName = this.pxM;
      a.ymk.l(localah);
    }
    z.afi().delete(this.pxM);
    if (b.dNF() != null)
    {
      b.dNF().dismiss();
      b.dNG();
    }
    AppMethodBeat.o(34788);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.tools.b.3
 * JD-Core Version:    0.7.0.1
 */