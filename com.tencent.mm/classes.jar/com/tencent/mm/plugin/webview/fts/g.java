package com.tencent.mm.plugin.webview.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.v;
import com.tencent.mm.protocal.protobuf.fap;
import com.tencent.mm.protocal.protobuf.fau;
import com.tencent.mm.protocal.protobuf.fav;
import com.tencent.mm.protocal.protobuf.fel;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.LinkedList;
import org.json.JSONArray;

public final class g
  extends com.tencent.mm.plugin.websearch.api.b
  implements m
{
  private fav IDA;
  private v IDt;
  private i callback;
  private d iUB;
  
  public g(v paramv)
  {
    AppMethodBeat.i(77934);
    this.IDt = paramv;
    this.Nv = paramv.dDv;
    this.mScene = paramv.scene;
    this.IDq = paramv.dVL;
    Object localObject;
    int i;
    if (!Util.isNullOrNil(paramv.dDv))
    {
      Log.i("MicroMsg.WebSearch.NetSceneWebSuggest", "Constructors: query=%s", new Object[] { paramv.dDv });
      localObject = new d.a();
      if ((paramv.scene == 201) || (paramv.IDQ == 1)) {
        i = 1;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        ((d.a)localObject).funcId = 1747;
        ((d.a)localObject).uri = "/cgi-bin/mmux-bin/wxaapp/mmuxwxa_weappsuggestion";
        label114:
        ((d.a)localObject).iLN = new fau();
        ((d.a)localObject).iLO = new fav();
        this.iUB = ((d.a)localObject).aXF();
        localObject = (fau)this.iUB.iLK.iLR;
        ((fau)localObject).LPT = paramv.dDv;
        ((fau)localObject).KZg = paramv.businessType;
        ((fau)localObject).NwV = ai.aft(0);
        ((fau)localObject).MRb = paramv.IDE;
        ((fau)localObject).MlQ = ai.clJ();
        ((fau)localObject).Scene = paramv.scene;
        ((fau)localObject).NwH = paramv.sessionId;
        ((fau)localObject).MlR = ai.fYd();
        if (paramv.IDS == null) {}
      }
      try
      {
        ((fau)localObject).Nxc = new com.tencent.mm.bw.b(paramv.IDS.toByteArray());
        label259:
        if (paramv.IDR != null) {}
        try
        {
          ((fau)localObject).Nxb = new com.tencent.mm.bw.b(paramv.IDR.toByteArray());
          try
          {
            label285:
            JSONArray localJSONArray = new JSONArray(paramv.IDJ);
            ((fau)localObject).NwZ = new LinkedList();
            i = 0;
            while (i < localJSONArray.length())
            {
              String str = URLDecoder.decode(localJSONArray.getString(i), "UTF-8");
              ((fau)localObject).NwZ.add(str);
              i += 1;
            }
            i = 0;
          }
          catch (Exception localException1)
          {
            Log.printErrStackTrace("MicroMsg.WebSearch.NetSceneWebSuggest", localException1, "decode json error", new Object[0]);
            i = paramv.businessType;
            if (((fau)localObject).MlQ == null) {
              break label477;
            }
          }
          ((d.a)localObject).funcId = 1161;
          ((d.a)localObject).uri = "/cgi-bin/mmsearch-bin/searchsuggestion";
          break label114;
          label477:
          for (boolean bool = true;; bool = false)
          {
            Log.i("MicroMsg.WebSearch.NetSceneWebSuggest", "businessTypeList is %d | contains location = %b | scene=%d | businessType=%d | isHomePage=%b | webViewId=%d", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool), Integer.valueOf(paramv.scene), Integer.valueOf(paramv.businessType), Integer.valueOf(paramv.IDE), Integer.valueOf(paramv.dVL) });
            AppMethodBeat.o(77934);
            return;
          }
          Log.e("MicroMsg.WebSearch.NetSceneWebSuggest", "keyword is unavailable");
          AppMethodBeat.o(77934);
          return;
        }
        catch (IOException localIOException)
        {
          break label285;
        }
      }
      catch (Exception localException2)
      {
        break label259;
      }
    }
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(77936);
    this.callback = parami;
    int i = dispatch(paramg, this.iUB, this);
    AppMethodBeat.o(77936);
    return i;
  }
  
  public final String fXC()
  {
    if (this.IDA != null) {
      return this.IDA.MaZ;
    }
    return "";
  }
  
  public final int getType()
  {
    return 1161;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(77935);
    Log.i("MicroMsg.WebSearch.NetSceneWebSuggest", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(77935);
      return;
    }
    this.IDA = ((fav)this.iUB.iLL.iLR);
    if (this.IDA != null) {
      Log.v("MicroMsg.WebSearch.NetSceneWebSuggest", "return data\n%s", new Object[] { this.IDA.MaZ });
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(77935);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.g
 * JD-Core Version:    0.7.0.1
 */