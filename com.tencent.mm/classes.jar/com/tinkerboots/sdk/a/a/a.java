package com.tinkerboots.sdk.a.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import com.tinkerboots.sdk.b.c;
import com.tinkerboots.sdk.b.d;
import java.util.Map;

public class a
  implements b
{
  public void ah(Map<String, String> paramMap) {}
  
  public boolean dcC()
  {
    AppMethodBeat.i(3437);
    Context localContext = c.getContext();
    com.tencent.tinker.lib.e.a locala = com.tencent.tinker.lib.e.a.lk(localContext);
    if (!com.tinkerboots.sdk.b.a.isConnected(localContext))
    {
      ShareTinkerLog.v("Tinker.PatchRequestCallback", "TinkerBootsRequestCallback: beforePatchRequest return false, not connect to internet", new Object[0]);
      AppMethodBeat.o(3437);
      return false;
    }
    if (com.tencent.tinker.lib.util.b.lm(localContext))
    {
      ShareTinkerLog.v("Tinker.PatchRequestCallback", "TinkerBootsRequestCallback: beforePatchRequest return false, tinker service is running", new Object[0]);
      AppMethodBeat.o(3437);
      return false;
    }
    if (!locala.AEC)
    {
      ShareTinkerLog.v("Tinker.PatchRequestCallback", "TinkerBootsRequestCallback: beforePatchRequest return false, only request on the main process", new Object[0]);
      AppMethodBeat.o(3437);
      return false;
    }
    if (d.gdZ())
    {
      ShareTinkerLog.v("Tinker.PatchRequestCallback", "TinkerBootsRequestCallback: beforePatchRequest return false, is in ignore channel, current channel:%s", new Object[] { d.gdY() });
      AppMethodBeat.o(3437);
      return false;
    }
    AppMethodBeat.o(3437);
    return true;
  }
  
  public void dcD() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tinkerboots.sdk.a.a.a
 * JD-Core Version:    0.7.0.1
 */