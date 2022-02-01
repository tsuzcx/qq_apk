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
  private c uvE;
  private d uvF;
  private com.tencent.mm.plugin.product.b.a uvG;
  
  public a()
  {
    AppMethodBeat.i(66847);
    this.uvE = null;
    this.uvF = null;
    this.uvG = new com.tencent.mm.plugin.product.b.a();
    AppMethodBeat.o(66847);
  }
  
  public static a dbi()
  {
    AppMethodBeat.i(66848);
    a locala = (a)t.ap(a.class);
    AppMethodBeat.o(66848);
    return locala;
  }
  
  public static c dbj()
  {
    AppMethodBeat.i(66851);
    g.afz().aeD();
    if (dbi().uvE == null) {
      dbi().uvE = new c();
    }
    c localc = dbi().uvE;
    AppMethodBeat.o(66851);
    return localc;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public final d dbk()
  {
    AppMethodBeat.i(66852);
    g.afz().aeD();
    if (this.uvF == null) {
      this.uvF = new d();
    }
    d locald = this.uvF;
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
    this.uvE = null;
    com.tencent.mm.sdk.b.a.ESL.c(this.uvG);
    AppMethodBeat.o(66849);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(66850);
    com.tencent.mm.sdk.b.a.ESL.d(this.uvG);
    AppMethodBeat.o(66850);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.product.a.a
 * JD-Core Version:    0.7.0.1
 */