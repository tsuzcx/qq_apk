package com.tencent.mm.plugin.wallet_index.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.model.at;
import com.tencent.mm.plugin.wallet_index.c.l;
import java.util.HashMap;

public class a
  implements at
{
  private l uzS;
  
  public a()
  {
    AppMethodBeat.i(48162);
    this.uzS = new l();
    AppMethodBeat.o(48162);
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.d> getBaseDBFactories()
  {
    return null;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(48163);
    com.tencent.mm.sdk.b.a.ymk.c(this.uzS.uAn);
    com.tencent.mm.sdk.b.a.ymk.c(this.uzS.uAo);
    AppMethodBeat.o(48163);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(48164);
    com.tencent.mm.sdk.b.a.ymk.d(this.uzS.uAn);
    com.tencent.mm.sdk.b.a.ymk.d(this.uzS.uAo);
    AppMethodBeat.o(48164);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.a.a
 * JD-Core Version:    0.7.0.1
 */