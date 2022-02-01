package com.tencent.mm.plugin.product.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.be;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.product.b.c;
import com.tencent.mm.plugin.product.b.d;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class a
  implements be
{
  private c GSR;
  private d GSS;
  private com.tencent.mm.plugin.product.b.a GST;
  
  public a()
  {
    AppMethodBeat.i(66847);
    this.GSR = null;
    this.GSS = null;
    this.GST = new com.tencent.mm.plugin.product.b.a();
    AppMethodBeat.o(66847);
  }
  
  public static a foU()
  {
    AppMethodBeat.i(66848);
    a locala = (a)y.as(a.class);
    AppMethodBeat.o(66848);
    return locala;
  }
  
  public static c foV()
  {
    AppMethodBeat.i(66851);
    h.aHE().aGH();
    if (foU().GSR == null) {
      foU().GSR = new c();
    }
    c localc = foU().GSR;
    AppMethodBeat.o(66851);
    return localc;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public final d foW()
  {
    AppMethodBeat.i(66852);
    h.aHE().aGH();
    if (this.GSS == null) {
      this.GSS = new d();
    }
    d locald = this.GSS;
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
    this.GSR = null;
    EventCenter.instance.addListener(this.GST);
    AppMethodBeat.o(66849);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(66850);
    EventCenter.instance.removeListener(this.GST);
    AppMethodBeat.o(66850);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.product.a.a
 * JD-Core Version:    0.7.0.1
 */