package com.tencent.mm.plugin.subapp.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f.d;
import com.tencent.mm.model.aw;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class c
  implements aw
{
  private b yCO;
  
  public c()
  {
    AppMethodBeat.i(28923);
    this.yCO = new b();
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
    f.d.a(Integer.valueOf(38), this.yCO);
    AppMethodBeat.o(28925);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(28924);
    f.d.b(Integer.valueOf(38), this.yCO);
    AppMethodBeat.o(28924);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.c.c
 * JD-Core Version:    0.7.0.1
 */