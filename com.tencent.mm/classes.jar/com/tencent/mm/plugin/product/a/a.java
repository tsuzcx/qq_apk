package com.tencent.mm.plugin.product.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.product.b.c;
import com.tencent.mm.plugin.product.b.d;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class a
  implements az
{
  private c xbr;
  private d xbs;
  private com.tencent.mm.plugin.product.b.a xbt;
  
  public a()
  {
    AppMethodBeat.i(66847);
    this.xbr = null;
    this.xbs = null;
    this.xbt = new com.tencent.mm.plugin.product.b.a();
    AppMethodBeat.o(66847);
  }
  
  public static a dCJ()
  {
    AppMethodBeat.i(66848);
    a locala = (a)u.ap(a.class);
    AppMethodBeat.o(66848);
    return locala;
  }
  
  public static c dCK()
  {
    AppMethodBeat.i(66851);
    g.ajP().aiU();
    if (dCJ().xbr == null) {
      dCJ().xbr = new c();
    }
    c localc = dCJ().xbr;
    AppMethodBeat.o(66851);
    return localc;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public final d dCL()
  {
    AppMethodBeat.i(66852);
    g.ajP().aiU();
    if (this.xbs == null) {
      this.xbs = new d();
    }
    d locald = this.xbs;
    AppMethodBeat.o(66852);
    return locald;
  }
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(66849);
    this.xbr = null;
    com.tencent.mm.sdk.b.a.IvT.c(this.xbt);
    AppMethodBeat.o(66849);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(66850);
    com.tencent.mm.sdk.b.a.IvT.d(this.xbt);
    AppMethodBeat.o(66850);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.product.a.a
 * JD-Core Version:    0.7.0.1
 */