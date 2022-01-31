package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.mm.sdk.platformtools.bk;
import org.json.JSONObject;

public final class g
{
  private static g quu;
  public String mOd;
  public int quv = 0;
  JSONObject quw;
  
  public static g bUY()
  {
    if (quu == null) {
      quu = new g();
    }
    return quu;
  }
  
  public final boolean akH()
  {
    return (this.quv == 1) && (!bk.bl(this.mOd));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.g
 * JD-Core Version:    0.7.0.1
 */