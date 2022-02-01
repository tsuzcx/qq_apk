package com.tencent.mm.plugin.offline.a;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.brd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.wallet_core.c.w;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
  extends w
{
  private String AJi;
  private String AJj;
  private i callback;
  private ArrayList<String> jBE;
  private final d rr;
  
  private void bd(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(66281);
    this.AJi = paramJSONObject.optString("micropay_tips");
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
        this.jBE.add(str);
        i += 1;
      }
      AppMethodBeat.o(66281);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      Log.printErrStackTrace("MicroMsg.NetSceneGetOffLineInfo", paramJSONObject, "", new Object[0]);
      AppMethodBeat.o(66281);
    }
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(66279);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(66279);
    return i;
  }
  
  public final int getType()
  {
    return 606;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(66280);
    if (paramInt2 != 0) {
      Log.e("MicroMsg.NetSceneGetOffLineInfo", "Cmd : " + getType() + ", errType = " + paramInt2 + ", errCode = " + paramInt3 + ", errMsg = " + paramString);
    }
    paramArrayOfByte = (brd)((d)params).iLL.iLR;
    paramInt1 = paramInt2;
    i = paramInt3;
    params = paramString;
    if (paramInt2 == 0)
    {
      paramInt1 = paramInt2;
      i = paramInt3;
      params = paramString;
      if (paramInt3 != 0) {}
    }
    try
    {
      if (!TextUtils.isEmpty(paramArrayOfByte.LYE))
      {
        params = new JSONObject(paramArrayOfByte.LYE);
        paramInt1 = params.optInt("InitValue");
        i = params.optInt("FastChangedLimit");
        this.AJj = params.optString("guide_tips");
        com.tencent.mm.plugin.offline.c.a.Ud(paramInt1);
        com.tencent.mm.plugin.offline.c.a.Ue(i);
        Log.v("MicroMsg.NetSceneGetOffLineInfo", "initValue:" + paramInt1 + " fastChangeValue:" + i);
      }
      paramInt1 = paramInt2;
      i = paramInt3;
      params = paramString;
      if (!TextUtils.isEmpty(paramArrayOfByte.LYF))
      {
        bd(new JSONObject(paramArrayOfByte.LYF));
        params = paramString;
        i = paramInt3;
        paramInt1 = paramInt2;
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.NetSceneGetOffLineInfo", paramString, "", new Object[0]);
        paramInt1 = 1000;
        i = 2;
        params = MMApplicationContext.getContext().getString(2131767667);
      }
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, i, params, this);
    }
    AppMethodBeat.o(66280);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.a.a
 * JD-Core Version:    0.7.0.1
 */