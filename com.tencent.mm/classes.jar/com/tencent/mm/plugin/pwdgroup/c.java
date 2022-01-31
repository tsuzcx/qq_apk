package com.tencent.mm.plugin.pwdgroup;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.model.at;
import java.util.HashMap;

public final class c
  implements at
{
  public final void clearPluginData(int paramInt) {}
  
  public final HashMap<Integer, h.d> getBaseDBFactories()
  {
    return null;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(23979);
    b.a.pFL = new c.1(this);
    AppMethodBeat.o(23979);
  }
  
  public final void onAccountRelease() {}
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.pwdgroup.c
 * JD-Core Version:    0.7.0.1
 */