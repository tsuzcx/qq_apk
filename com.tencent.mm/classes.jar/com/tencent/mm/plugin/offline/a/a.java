package com.tencent.mm.plugin.offline.a;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.protobuf.byz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.wallet_core.c.w;
import org.json.JSONObject;

public final class a
  extends w
{
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(66279);
    AppMethodBeat.o(66279);
    throw null;
  }
  
  public final int getType()
  {
    return 606;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(66280);
    if (paramInt2 != 0)
    {
      AppMethodBeat.o(66280);
      throw null;
    }
    paramString = (byz)d.c.b(((d)params).lBS);
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      try
      {
        if (!TextUtils.isEmpty(paramString.ThY))
        {
          paramString = new JSONObject(paramString.ThY);
          paramString.optInt("InitValue");
          paramString.optInt("FastChangedLimit");
          paramString.optString("guide_tips");
          AppMethodBeat.o(66280);
          throw null;
        }
      }
      catch (Exception paramString)
      {
        Log.printErrStackTrace("MicroMsg.NetSceneGetOffLineInfo", paramString, "", new Object[0]);
        MMApplicationContext.getContext().getString(a.i.wallet_data_err);
      }
    }
    while (TextUtils.isEmpty(paramString.ThZ))
    {
      AppMethodBeat.o(66280);
      throw null;
    }
    new JSONObject(paramString.ThZ);
    AppMethodBeat.o(66280);
    throw null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.a.a
 * JD-Core Version:    0.7.0.1
 */