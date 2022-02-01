package com.tencent.mm.plugin.subapp.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h.d;
import com.tencent.mm.model.bd;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class c
  implements bd
{
  private b FJM;
  
  public c()
  {
    AppMethodBeat.i(28923);
    this.FJM = new b();
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
    h.d.a(Integer.valueOf(38), this.FJM);
    AppMethodBeat.o(28925);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(28924);
    h.d.b(Integer.valueOf(38), this.FJM);
    AppMethodBeat.o(28924);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.c.c
 * JD-Core Version:    0.7.0.1
 */