package com.tencent.mm.plugin.product.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.be;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.product.model.MallProductListener;
import com.tencent.mm.plugin.product.model.c;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class a
  implements be
{
  private com.tencent.mm.plugin.product.model.b MQv;
  private c MQw;
  private MallProductListener MQx;
  
  public a()
  {
    AppMethodBeat.i(66847);
    this.MQv = null;
    this.MQw = null;
    this.MQx = new MallProductListener();
    AppMethodBeat.o(66847);
  }
  
  public static a gzY()
  {
    AppMethodBeat.i(66848);
    a locala = (a)y.aL(a.class);
    AppMethodBeat.o(66848);
    return locala;
  }
  
  public static com.tencent.mm.plugin.product.model.b gzZ()
  {
    AppMethodBeat.i(66851);
    h.baC().aZJ();
    if (gzY().MQv == null) {
      gzY().MQv = new com.tencent.mm.plugin.product.model.b();
    }
    com.tencent.mm.plugin.product.model.b localb = gzY().MQv;
    AppMethodBeat.o(66851);
    return localb;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public final c gAa()
  {
    AppMethodBeat.i(66852);
    h.baC().aZJ();
    if (this.MQw == null) {
      this.MQw = new c();
    }
    c localc = this.MQw;
    AppMethodBeat.o(66852);
    return localc;
  }
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(66849);
    this.MQv = null;
    this.MQx.alive();
    AppMethodBeat.o(66849);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(66850);
    this.MQx.dead();
    AppMethodBeat.o(66850);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.product.a.a
 * JD-Core Version:    0.7.0.1
 */