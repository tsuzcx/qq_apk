package com.tinkerboots.sdk.a.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tinkerboots.sdk.b.d;
import java.util.Map;

public class a
  implements b
{
  public void ax(Map<String, String> paramMap) {}
  
  public boolean fQe()
  {
    AppMethodBeat.i(3437);
    Context localContext = com.tinkerboots.sdk.b.c.getContext();
    com.tencent.tinker.lib.e.a locala = com.tencent.tinker.lib.e.a.oy(localContext);
    if (!com.tinkerboots.sdk.b.a.isConnected(localContext))
    {
      com.tencent.tinker.lib.f.a.i("Tinker.PatchRequestCallback", "TinkerBootsRequestCallback: beforePatchRequest return false, not connect to internet", new Object[0]);
      AppMethodBeat.o(3437);
      return false;
    }
    if (com.tencent.tinker.lib.f.c.oA(localContext))
    {
      com.tencent.tinker.lib.f.a.i("Tinker.PatchRequestCallback", "TinkerBootsRequestCallback: beforePatchRequest return false, tinker service is running", new Object[0]);
      AppMethodBeat.o(3437);
      return false;
    }
    if (!locala.isMainProcess())
    {
      com.tencent.tinker.lib.f.a.i("Tinker.PatchRequestCallback", "TinkerBootsRequestCallback: beforePatchRequest return false, only request on the main process", new Object[0]);
      AppMethodBeat.o(3437);
      return false;
    }
    if (d.kkw())
    {
      com.tencent.tinker.lib.f.a.e("Tinker.PatchRequestCallback", "TinkerBootsRequestCallback: beforePatchRequest return false, is in ignore channel, current channel:%s", new Object[] { d.kkv() });
      AppMethodBeat.o(3437);
      return false;
    }
    AppMethodBeat.o(3437);
    return true;
  }
  
  public void fQf() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tinkerboots.sdk.a.a.a
 * JD-Core Version:    0.7.0.1
 */