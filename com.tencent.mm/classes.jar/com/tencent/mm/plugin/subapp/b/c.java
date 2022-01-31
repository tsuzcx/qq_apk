package com.tencent.mm.plugin.subapp.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.d;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.model.at;
import java.util.HashMap;

public class c
  implements at
{
  private b sXb;
  
  public c()
  {
    AppMethodBeat.i(25244);
    this.sXb = new b();
    AppMethodBeat.o(25244);
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.d> getBaseDBFactories()
  {
    return null;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(25246);
    e.d.a(Integer.valueOf(38), this.sXb);
    AppMethodBeat.o(25246);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(25245);
    e.d.b(Integer.valueOf(38), this.sXb);
    AppMethodBeat.o(25245);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.b.c
 * JD-Core Version:    0.7.0.1
 */