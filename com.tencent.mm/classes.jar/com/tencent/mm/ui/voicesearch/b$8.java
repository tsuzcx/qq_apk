package com.tencent.mm.ui.voicesearch;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.protocal.protobuf.bxf;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.applet.b.b;
import java.util.LinkedList;

final class b$8
  implements b.b
{
  b$8(b paramb) {}
  
  public final int aqn()
  {
    AppMethodBeat.i(35335);
    if (b.f(this.ABH) == null)
    {
      AppMethodBeat.o(35335);
      return 0;
    }
    int i = b.f(this.ABH).size();
    AppMethodBeat.o(35335);
    return i;
  }
  
  public final String mS(int paramInt)
  {
    AppMethodBeat.i(35334);
    if (paramInt < 0)
    {
      ab.e("MicroMsg.SearchResultAdapter", "pos is invalid");
      AppMethodBeat.o(35334);
      return null;
    }
    Object localObject = this.ABH;
    localObject = ((b)localObject).QU(b.e((b)localObject) + paramInt + 1);
    if (localObject == null)
    {
      AppMethodBeat.o(35334);
      return null;
    }
    localObject = ((bxf)localObject).wOT.xJE;
    AppMethodBeat.o(35334);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.voicesearch.b.8
 * JD-Core Version:    0.7.0.1
 */