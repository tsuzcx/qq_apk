package com.tencent.mm.plugin.product.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.product.b.c;
import com.tencent.mm.plugin.product.b.d;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class a
  implements aw
{
  private c vEx;
  private d vEy;
  private com.tencent.mm.plugin.product.b.a vEz;
  
  public a()
  {
    AppMethodBeat.i(66847);
    this.vEx = null;
    this.vEy = null;
    this.vEz = new com.tencent.mm.plugin.product.b.a();
    AppMethodBeat.o(66847);
  }
  
  public static a doQ()
  {
    AppMethodBeat.i(66848);
    a locala = (a)t.ap(a.class);
    AppMethodBeat.o(66848);
    return locala;
  }
  
  public static c doR()
  {
    AppMethodBeat.i(66851);
    g.agP().afT();
    if (doQ().vEx == null) {
      doQ().vEx = new c();
    }
    c localc = doQ().vEx;
    AppMethodBeat.o(66851);
    return localc;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public final d doS()
  {
    AppMethodBeat.i(66852);
    g.agP().afT();
    if (this.vEy == null) {
      this.vEy = new d();
    }
    d locald = this.vEy;
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
    this.vEx = null;
    com.tencent.mm.sdk.b.a.GpY.c(this.vEz);
    AppMethodBeat.o(66849);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(66850);
    com.tencent.mm.sdk.b.a.GpY.d(this.vEz);
    AppMethodBeat.o(66850);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.product.a.a
 * JD-Core Version:    0.7.0.1
 */