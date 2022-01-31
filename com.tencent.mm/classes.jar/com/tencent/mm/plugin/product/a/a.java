package com.tencent.mm.plugin.product.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.product.b.c;
import com.tencent.mm.plugin.product.b.d;
import java.util.HashMap;

public class a
  implements at
{
  private c ptQ;
  private d ptR;
  private com.tencent.mm.plugin.product.b.a ptS;
  
  public a()
  {
    AppMethodBeat.i(43940);
    this.ptQ = null;
    this.ptR = null;
    this.ptS = new com.tencent.mm.plugin.product.b.a();
    AppMethodBeat.o(43940);
  }
  
  public static a caT()
  {
    AppMethodBeat.i(43941);
    a locala = (a)q.S(a.class);
    AppMethodBeat.o(43941);
    return locala;
  }
  
  public static c caU()
  {
    AppMethodBeat.i(43944);
    g.RJ().QQ();
    if (caT().ptQ == null) {
      caT().ptQ = new c();
    }
    c localc = caT().ptQ;
    AppMethodBeat.o(43944);
    return localc;
  }
  
  public final d caV()
  {
    AppMethodBeat.i(43945);
    g.RJ().QQ();
    if (this.ptR == null) {
      this.ptR = new d();
    }
    d locald = this.ptR;
    AppMethodBeat.o(43945);
    return locald;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.d> getBaseDBFactories()
  {
    return null;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(43942);
    this.ptQ = null;
    com.tencent.mm.sdk.b.a.ymk.c(this.ptS);
    AppMethodBeat.o(43942);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(43943);
    com.tencent.mm.sdk.b.a.ymk.d(this.ptS);
    AppMethodBeat.o(43943);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.product.a.a
 * JD-Core Version:    0.7.0.1
 */