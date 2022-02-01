package com.tencent.mm.plugin.webview.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.v;
import com.tencent.mm.protocal.protobuf.fli;
import com.tencent.mm.protocal.protobuf.fln;
import com.tencent.mm.protocal.protobuf.flo;
import com.tencent.mm.protocal.protobuf.fpm;
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
  private v PxJ;
  private flo PxQ;
  private i callback;
  private d lKU;
  
  public g(v paramv)
  {
    AppMethodBeat.i(77934);
    this.PxJ = paramv;
    this.Ln = paramv.fwe;
    this.mScene = paramv.scene;
    this.PxG = paramv.fPp;
    Object localObject;
    int i;
    if (!Util.isNullOrNil(paramv.fwe))
    {
      Log.i("MicroMsg.WebSearch.NetSceneWebSuggest", "Constructors: query=%s", new Object[] { paramv.fwe });
      localObject = new d.a();
      if ((paramv.scene == 201) || (paramv.Pyg == 1)) {
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
        ((d.a)localObject).lBU = new fln();
        ((d.a)localObject).lBV = new flo();
        this.lKU = ((d.a)localObject).bgN();
        localObject = (fln)d.b.b(this.lKU.lBR);
        ((fln)localObject).SYn = paramv.fwe;
        ((fln)localObject).Sap = paramv.businessType;
        ((fln)localObject).UKl = ai.anh(0);
        ((fln)localObject).Udh = paramv.PxU;
        ((fln)localObject).TwK = ai.czn();
        ((fln)localObject).CPw = paramv.scene;
        ((fln)localObject).UJX = paramv.sessionId;
        ((fln)localObject).TwL = ai.gQO();
        if (paramv.Pyi == null) {}
      }
      try
      {
        ((fln)localObject).UKs = new com.tencent.mm.cd.b(paramv.Pyi.toByteArray());
        label259:
        if (paramv.Pyh != null) {}
        try
        {
          ((fln)localObject).UKr = new com.tencent.mm.cd.b(paramv.Pyh.toByteArray());
          try
          {
            label285:
            JSONArray localJSONArray = new JSONArray(paramv.PxZ);
            ((fln)localObject).UKp = new LinkedList();
            i = 0;
            while (i < localJSONArray.length())
            {
              String str = URLDecoder.decode(localJSONArray.getString(i), "UTF-8");
              ((fln)localObject).UKp.add(str);
              i += 1;
            }
            i = 0;
          }
          catch (Exception localException1)
          {
            Log.printErrStackTrace("MicroMsg.WebSearch.NetSceneWebSuggest", localException1, "decode json error", new Object[0]);
            i = paramv.businessType;
            if (((fln)localObject).TwK == null) {
              break label477;
            }
          }
          ((d.a)localObject).funcId = 1161;
          ((d.a)localObject).uri = "/cgi-bin/mmsearch-bin/searchsuggestion";
          break label114;
          label477:
          for (boolean bool = true;; bool = false)
          {
            Log.i("MicroMsg.WebSearch.NetSceneWebSuggest", "businessTypeList is %d | contains location = %b | scene=%d | businessType=%d | isHomePage=%b | webViewId=%d", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool), Integer.valueOf(paramv.scene), Integer.valueOf(paramv.businessType), Integer.valueOf(paramv.PxU), Integer.valueOf(paramv.fPp) });
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
    int i = dispatch(paramg, this.lKU, this);
    AppMethodBeat.o(77936);
    return i;
  }
  
  public final String gQp()
  {
    if (this.PxQ != null) {
      return this.PxQ.Tkw;
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
    this.PxQ = ((flo)d.c.b(this.lKU.lBS));
    if (this.PxQ != null) {
      Log.v("MicroMsg.WebSearch.NetSceneWebSuggest", "return data\n%s", new Object[] { this.PxQ.Tkw });
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(77935);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.g
 * JD-Core Version:    0.7.0.1
 */