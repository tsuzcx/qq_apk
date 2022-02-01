package com.tencent.mm.plugin.subapp.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.d;
import com.tencent.mm.model.be;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class c
  implements be
{
  private b SEZ;
  
  public c()
  {
    AppMethodBeat.i(28923);
    this.SEZ = new b();
    AppMethodBeat.o(28923);
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(28925);
    g.d.a(Integer.valueOf(38), this.SEZ);
    AppMethodBeat.o(28925);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(28924);
    g.d.b(Integer.valueOf(38), this.SEZ);
    AppMethodBeat.o(28924);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.c.c
 * JD-Core Version:    0.7.0.1
 */