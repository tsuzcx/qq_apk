package com.tencent.mm.plugin.offline.a;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ams;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.wallet_core.c.u;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
  extends u
{
  private f callback;
  private ArrayList<String> hXv;
  private String pkX;
  private String pkY;
  private final b rr;
  
  private void ai(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(43383);
    this.pkX = paramJSONObject.optString("micropay_tips");
    try
    {
      paramJSONObject = paramJSONObject.getJSONArray("head_url_list");
      if (paramJSONObject != null)
      {
        i = paramJSONObject.length();
        if (i != 0) {}
      }
      else
      {
        AppMethodBeat.o(43383);
        return;
      }
      int i = 0;
      while (i < paramJSONObject.length())
      {
        String str = (String)paramJSONObject.get(i);
        this.hXv.add(str);
        i += 1;
      }
      AppMethodBeat.o(43383);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      ab.printErrStackTrace("MicroMsg.NetSceneGetOffLineInfo", paramJSONObject, "", new Object[0]);
      AppMethodBeat.o(43383);
    }
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(43381);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(43381);
    return i;
  }
  
  public final int getType()
  {
    return 606;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(142115);
    if (paramInt2 != 0) {
      ab.e("MicroMsg.NetSceneGetOffLineInfo", "Cmd : " + getType() + ", errType = " + paramInt2 + ", errCode = " + paramInt3 + ", errMsg = " + paramString);
    }
    paramArrayOfByte = (ams)((b)paramq).fsW.fta;
    paramInt1 = paramInt2;
    i = paramInt3;
    paramq = paramString;
    if (paramInt2 == 0)
    {
      paramInt1 = paramInt2;
      i = paramInt3;
      paramq = paramString;
      if (paramInt3 != 0) {}
    }
    try
    {
      if (!TextUtils.isEmpty(paramArrayOfByte.xdr))
      {
        paramq = new JSONObject(paramArrayOfByte.xdr);
        paramInt1 = paramq.optInt("InitValue");
        i = paramq.optInt("FastChangedLimit");
        this.pkY = paramq.optString("guide_tips");
        com.tencent.mm.plugin.offline.c.a.Bc(paramInt1);
        com.tencent.mm.plugin.offline.c.a.Bd(i);
        ab.v("MicroMsg.NetSceneGetOffLineInfo", "initValue:" + paramInt1 + " fastChangeValue:" + i);
      }
      paramInt1 = paramInt2;
      i = paramInt3;
      paramq = paramString;
      if (!TextUtils.isEmpty(paramArrayOfByte.xds))
      {
        ai(new JSONObject(paramArrayOfByte.xds));
        paramq = paramString;
        i = paramInt3;
        paramInt1 = paramInt2;
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.NetSceneGetOffLineInfo", paramString, "", new Object[0]);
        paramInt1 = 1000;
        i = 2;
        paramq = ah.getContext().getString(2131305032);
      }
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, i, paramq, this);
    }
    AppMethodBeat.o(142115);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.a.a
 * JD-Core Version:    0.7.0.1
 */