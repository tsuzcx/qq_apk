package com.tencent.mm.wallet_core.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.wallet_core.c.y;
import java.util.HashMap;
import org.json.JSONObject;

public final class b
  extends a
{
  public b()
  {
    AppMethodBeat.i(72877);
    setRequestData(new HashMap());
    AppMethodBeat.o(72877);
  }
  
  public final int eEK()
  {
    return 28;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(72878);
    ad.d("Micromsg.NetScenePayUTimeSeed", " errCode: " + paramInt + " errMsg :" + paramString);
    paramString = paramJSONObject.optString("time_stamp");
    if (!bt.isNullOrNil(paramString)) {
      y.setTimeStamp(paramString);
    }
    AppMethodBeat.o(72878);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.wallet_core.e.a.b
 * JD-Core Version:    0.7.0.1
 */