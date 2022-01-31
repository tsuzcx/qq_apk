package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class s
{
  public long ubC;
  public long uiJ;
  public long uiK;
  public int uiL;
  public int uiM;
  public long uiN;
  
  public final void aF(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(46792);
    this.ubC = paramJSONObject.optLong("activity_id");
    this.uiJ = paramJSONObject.optLong("activity_type", 0L);
    this.uiK = paramJSONObject.optLong("award_id");
    this.uiL = paramJSONObject.optInt("send_record_id");
    this.uiM = paramJSONObject.optInt("user_record_id");
    this.uiN = paramJSONObject.optLong("activity_mch_id", 0L);
    AppMethodBeat.o(46792);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.s
 * JD-Core Version:    0.7.0.1
 */