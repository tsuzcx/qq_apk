package com.tinkerboots.sdk.a.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tinkerboots.sdk.b.c;
import com.tinkerboots.sdk.b.d;
import java.util.Map;

public class a
  implements b
{
  public void ab(Map<String, String> paramMap) {}
  
  public boolean cGi()
  {
    AppMethodBeat.i(3437);
    Context localContext = c.getContext();
    com.tencent.tinker.lib.e.a locala = com.tencent.tinker.lib.e.a.kI(localContext);
    if (!com.tinkerboots.sdk.b.a.isConnected(localContext))
    {
      com.tencent.tinker.lib.f.a.i("Tinker.PatchRequestCallback", "TinkerBootsRequestCallback: beforePatchRequest return false, not connect to internet", new Object[0]);
      AppMethodBeat.o(3437);
      return false;
    }
    if (com.tencent.tinker.lib.f.b.kK(localContext))
    {
      com.tencent.tinker.lib.f.a.i("Tinker.PatchRequestCallback", "TinkerBootsRequestCallback: beforePatchRequest return false, tinker service is running", new Object[0]);
      AppMethodBeat.o(3437);
      return false;
    }
    if (!locala.xZI)
    {
      com.tencent.tinker.lib.f.a.i("Tinker.PatchRequestCallback", "TinkerBootsRequestCallback: beforePatchRequest return false, only request on the main process", new Object[0]);
      AppMethodBeat.o(3437);
      return false;
    }
    if (d.ftR())
    {
      com.tencent.tinker.lib.f.a.e("Tinker.PatchRequestCallback", "TinkerBootsRequestCallback: beforePatchRequest return false, is in ignore channel, current channel:%s", new Object[] { d.ftQ() });
      AppMethodBeat.o(3437);
      return false;
    }
    AppMethodBeat.o(3437);
    return true;
  }
  
  public void cGj() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tinkerboots.sdk.a.a.a
 * JD-Core Version:    0.7.0.1
 */