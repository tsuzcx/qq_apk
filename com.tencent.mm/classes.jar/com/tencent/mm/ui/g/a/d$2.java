package com.tencent.mm.ui.g.a;

import com.facebook.GraphRequest.Callback;
import com.facebook.GraphResponse;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class d$2
  implements GraphRequest.Callback
{
  d$2(d paramd, d.a parama) {}
  
  public final void onCompleted(GraphResponse paramGraphResponse)
  {
    AppMethodBeat.i(80313);
    if (paramGraphResponse != null) {
      try
      {
        paramGraphResponse = paramGraphResponse.getJSONObject();
        this.Aod.o(paramGraphResponse);
        AppMethodBeat.o(80313);
        return;
      }
      catch (Exception paramGraphResponse)
      {
        this.Aod.onError("Retrieve Failed, Error Format!");
        AppMethodBeat.o(80313);
        return;
      }
    }
    this.Aod.onError("Retrieve Failed, No response!");
    AppMethodBeat.o(80313);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.g.a.d.2
 * JD-Core Version:    0.7.0.1
 */