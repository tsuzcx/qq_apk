package com.tencent.mm.plugin.offline.a;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bfh;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.wallet_core.c.w;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
  extends w
{
  private f callback;
  private ArrayList<String> iFA;
  private final b rr;
  private String wNC;
  private String wND;
  
  private void aH(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(66281);
    this.wNC = paramJSONObject.optString("micropay_tips");
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
        AppMethodBeat.o(66281);
        return;
      }
      int i = 0;
      while (i < paramJSONObject.length())
      {
        String str = (String)paramJSONObject.get(i);
        this.iFA.add(str);
        i += 1;
      }
      AppMethodBeat.o(66281);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      ae.printErrStackTrace("MicroMsg.NetSceneGetOffLineInfo", paramJSONObject, "", new Object[0]);
      AppMethodBeat.o(66281);
    }
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(66279);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(66279);
    return i;
  }
  
  public final int getType()
  {
    return 606;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(66280);
    if (paramInt2 != 0) {
      ae.e("MicroMsg.NetSceneGetOffLineInfo", "Cmd : " + getType() + ", errType = " + paramInt2 + ", errCode = " + paramInt3 + ", errMsg = " + paramString);
    }
    paramArrayOfByte = (bfh)((b)paramq).hQE.hQJ;
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
      if (!TextUtils.isEmpty(paramArrayOfByte.GUm))
      {
        paramq = new JSONObject(paramArrayOfByte.GUm);
        paramInt1 = paramq.optInt("InitValue");
        i = paramq.optInt("FastChangedLimit");
        this.wND = paramq.optString("guide_tips");
        com.tencent.mm.plugin.offline.c.a.MT(paramInt1);
        com.tencent.mm.plugin.offline.c.a.MU(i);
        ae.v("MicroMsg.NetSceneGetOffLineInfo", "initValue:" + paramInt1 + " fastChangeValue:" + i);
      }
      paramInt1 = paramInt2;
      i = paramInt3;
      paramq = paramString;
      if (!TextUtils.isEmpty(paramArrayOfByte.GUn))
      {
        aH(new JSONObject(paramArrayOfByte.GUn));
        paramq = paramString;
        i = paramInt3;
        paramInt1 = paramInt2;
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.NetSceneGetOffLineInfo", paramString, "", new Object[0]);
        paramInt1 = 1000;
        i = 2;
        paramq = ak.getContext().getString(2131765224);
      }
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, i, paramq, this);
    }
    AppMethodBeat.o(66280);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.a.a
 * JD-Core Version:    0.7.0.1
 */