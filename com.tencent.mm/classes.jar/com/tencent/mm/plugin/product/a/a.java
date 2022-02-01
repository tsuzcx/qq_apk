package com.tencent.mm.plugin.product.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.product.b.c;
import com.tencent.mm.plugin.product.b.d;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class a
  implements ax
{
  private c wLD;
  private d wLE;
  private com.tencent.mm.plugin.product.b.a wLF;
  
  public a()
  {
    AppMethodBeat.i(66847);
    this.wLD = null;
    this.wLE = null;
    this.wLF = new com.tencent.mm.plugin.product.b.a();
    AppMethodBeat.o(66847);
  }
  
  public static a dzs()
  {
    AppMethodBeat.i(66848);
    a locala = (a)t.ap(a.class);
    AppMethodBeat.o(66848);
    return locala;
  }
  
  public static c dzt()
  {
    AppMethodBeat.i(66851);
    g.ajA().aiF();
    if (dzs().wLD == null) {
      dzs().wLD = new c();
    }
    c localc = dzs().wLD;
    AppMethodBeat.o(66851);
    return localc;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public final d dzu()
  {
    AppMethodBeat.i(66852);
    g.ajA().aiF();
    if (this.wLE == null) {
      this.wLE = new d();
    }
    d locald = this.wLE;
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
    this.wLD = null;
    com.tencent.mm.sdk.b.a.IbL.c(this.wLF);
    AppMethodBeat.o(66849);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(66850);
    com.tencent.mm.sdk.b.a.IbL.d(this.wLF);
    AppMethodBeat.o(66850);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.product.a.a
 * JD-Core Version:    0.7.0.1
 */