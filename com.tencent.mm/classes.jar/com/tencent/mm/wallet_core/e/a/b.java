package com.tencent.mm.wallet_core.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.c.w;
import java.util.HashMap;
import org.json.JSONObject;

public final class b
  extends a
{
  public b()
  {
    AppMethodBeat.i(49160);
    setRequestData(new HashMap());
    AppMethodBeat.o(49160);
  }
  
  public final int cTa()
  {
    return 28;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(49161);
    ab.d("Micromsg.NetScenePayUTimeSeed", " errCode: " + paramInt + " errMsg :" + paramString);
    paramString = paramJSONObject.optString("time_stamp");
    if (!bo.isNullOrNil(paramString)) {
      w.setTimeStamp(paramString);
    }
    AppMethodBeat.o(49161);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.e.a.b
 * JD-Core Version:    0.7.0.1
 */