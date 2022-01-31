package com.tencent.mm.plugin.offline.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.q;
import org.json.JSONObject;

public final class l
  extends h
{
  public String pkz;
  
  public final int getTenpayCgicmd()
  {
    return 78;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(43406);
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, paramq, paramArrayOfByte);
    AppMethodBeat.o(43406);
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(43405);
    this.pkz = paramJSONObject.optString("barcode");
    AppMethodBeat.o(43405);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.a.l
 * JD-Core Version:    0.7.0.1
 */