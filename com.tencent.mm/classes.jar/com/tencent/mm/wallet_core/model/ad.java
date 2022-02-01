package com.tencent.mm.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class ad
{
  public String ZQS;
  public String abMG;
  public String acao;
  public String agTD;
  public int agTE;
  
  public ad()
  {
    this.ZQS = "";
    this.acao = "";
    this.agTD = "";
    this.abMG = "";
    this.agTE = 0;
  }
  
  public ad(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(72811);
    this.ZQS = "";
    this.acao = "";
    this.agTD = "";
    this.abMG = "";
    this.agTE = 0;
    this.ZQS = paramJSONObject.optString("device_id");
    this.acao = paramJSONObject.optString("device_name");
    this.agTD = paramJSONObject.optString("device_os");
    this.agTE = paramJSONObject.optInt("Is_cur_device");
    this.abMG = paramJSONObject.optString("crt_no");
    AppMethodBeat.o(72811);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.wallet_core.model.ad
 * JD-Core Version:    0.7.0.1
 */