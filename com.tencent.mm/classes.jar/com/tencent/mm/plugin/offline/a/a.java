package com.tencent.mm.plugin.offline.a;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.ahr;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c.s;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
  extends s
{
  private final b dmK;
  private f dmL;
  private ArrayList<String> gAi;
  private String mKG;
  private String mKH;
  
  private void X(JSONObject paramJSONObject)
  {
    this.mKG = paramJSONObject.optString("micropay_tips");
    for (;;)
    {
      int i;
      try
      {
        paramJSONObject = paramJSONObject.getJSONArray("head_url_list");
        if (paramJSONObject == null) {
          break label75;
        }
        if (paramJSONObject.length() != 0) {
          break label76;
        }
        return;
      }
      catch (JSONException paramJSONObject)
      {
        String str;
        y.printErrStackTrace("MicroMsg.NetSceneGetOffLineInfo", paramJSONObject, "", new Object[0]);
      }
      if (i < paramJSONObject.length())
      {
        str = (String)paramJSONObject.get(i);
        this.gAi.add(str);
        i += 1;
      }
      else
      {
        label75:
        return;
        label76:
        i = 0;
      }
    }
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void e(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    if (paramInt1 != 0) {
      y.e("MicroMsg.NetSceneGetOffLineInfo", "Cmd : 606, errType = " + paramInt1 + ", errCode = " + paramInt2 + ", errMsg = " + paramString);
    }
    ahr localahr = (ahr)((b)paramq).ecF.ecN;
    i = paramInt1;
    j = paramInt2;
    paramq = paramString;
    if (paramInt1 == 0)
    {
      i = paramInt1;
      j = paramInt2;
      paramq = paramString;
      if (paramInt2 != 0) {}
    }
    try
    {
      if (!TextUtils.isEmpty(localahr.tfg))
      {
        paramq = new JSONObject(localahr.tfg);
        i = paramq.optInt("InitValue");
        j = paramq.optInt("FastChangedLimit");
        this.mKH = paramq.optString("guide_tips");
        com.tencent.mm.plugin.offline.c.a.vE(i);
        com.tencent.mm.plugin.offline.c.a.vF(j);
        y.v("MicroMsg.NetSceneGetOffLineInfo", "initValue:" + i + " fastChangeValue:" + j);
      }
      i = paramInt1;
      j = paramInt2;
      paramq = paramString;
      if (!TextUtils.isEmpty(localahr.tfh))
      {
        X(new JSONObject(localahr.tfh));
        paramq = paramString;
        j = paramInt2;
        i = paramInt1;
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.NetSceneGetOffLineInfo", paramString, "", new Object[0]);
        i = 1000;
        j = 2;
        paramq = ae.getContext().getString(a.i.wallet_data_err);
      }
    }
    if (this.dmL != null) {
      this.dmL.onSceneEnd(i, j, paramq, this);
    }
  }
  
  public final int getType()
  {
    return 606;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.a.a
 * JD-Core Version:    0.7.0.1
 */