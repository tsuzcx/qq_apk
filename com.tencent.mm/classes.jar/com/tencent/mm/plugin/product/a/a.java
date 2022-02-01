package com.tencent.mm.plugin.product.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.product.b.c;
import com.tencent.mm.plugin.product.b.d;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class a
  implements bd
{
  private c AYT;
  private d AYU;
  private com.tencent.mm.plugin.product.b.a AYV;
  
  public a()
  {
    AppMethodBeat.i(66847);
    this.AYT = null;
    this.AYU = null;
    this.AYV = new com.tencent.mm.plugin.product.b.a();
    AppMethodBeat.o(66847);
  }
  
  public static a eDb()
  {
    AppMethodBeat.i(66848);
    a locala = (a)y.at(a.class);
    AppMethodBeat.o(66848);
    return locala;
  }
  
  public static c eDc()
  {
    AppMethodBeat.i(66851);
    g.aAf().azk();
    if (eDb().AYT == null) {
      eDb().AYT = new c();
    }
    c localc = eDb().AYT;
    AppMethodBeat.o(66851);
    return localc;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public final d eDd()
  {
    AppMethodBeat.i(66852);
    g.aAf().azk();
    if (this.AYU == null) {
      this.AYU = new d();
    }
    d locald = this.AYU;
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
    this.AYT = null;
    EventCenter.instance.addListener(this.AYV);
    AppMethodBeat.o(66849);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(66850);
    EventCenter.instance.removeListener(this.AYV);
    AppMethodBeat.o(66850);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.product.a.a
 * JD-Core Version:    0.7.0.1
 */