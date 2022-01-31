package com.tencent.mm.plugin.offline.a;

import com.tencent.mm.network.q;
import org.json.JSONObject;

public final class l
  extends h
{
  public String mKk;
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    super.a(paramInt1, paramInt2, paramInt3, paramString, paramq, paramArrayOfByte);
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    this.mKk = paramJSONObject.optString("barcode");
  }
  
  public final int aEC()
  {
    return 78;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.a.l
 * JD-Core Version:    0.7.0.1
 */