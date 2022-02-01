package com.tencent.mm.plugin.webview.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.plugin.websearch.api.s;
import com.tencent.mm.protocal.protobuf.ege;
import com.tencent.mm.protocal.protobuf.egi;
import com.tencent.mm.protocal.protobuf.egj;
import com.tencent.mm.protocal.protobuf.ejs;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.LinkedList;
import org.json.JSONArray;

public final class g
  extends com.tencent.mm.plugin.websearch.api.b
  implements k
{
  private s DTs;
  private egj Ecp;
  private f callback;
  private com.tencent.mm.ak.b hZD;
  
  public g(s params)
  {
    AppMethodBeat.i(77934);
    this.DTs = params;
    this.Nl = params.dmf;
    this.mScene = params.scene;
    this.DSQ = params.dDY;
    Object localObject;
    int i;
    if (!bu.isNullOrNil(params.dmf))
    {
      ae.i("MicroMsg.WebSearch.NetSceneWebSuggest", "Constructors: query=%s", new Object[] { params.dmf });
      localObject = new b.a();
      if ((params.scene == 201) || (params.DTi == 1)) {
        i = 1;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        ((b.a)localObject).funcId = 1747;
        ((b.a)localObject).uri = "/cgi-bin/mmux-bin/wxaapp/mmuxwxa_weappsuggestion";
        label114:
        ((b.a)localObject).hQF = new egi();
        ((b.a)localObject).hQG = new egj();
        this.hZD = ((b.a)localObject).aDS();
        localObject = (egi)this.hZD.hQD.hQJ;
        ((egi)localObject).GLP = params.dmf;
        ((egi)localObject).GeP = params.businessType;
        ((egi)localObject).IjW = ad.WL(0);
        ((egi)localObject).HFR = params.DSW;
        ((egi)localObject).HkU = ad.bOD();
        ((egi)localObject).Scene = params.scene;
        ((egi)localObject).IjI = params.sessionId;
        if (params.DTk == null) {}
      }
      try
      {
        ((egi)localObject).Ikd = new com.tencent.mm.bw.b(params.DTk.toByteArray());
        label251:
        if (params.DTj != null) {}
        try
        {
          ((egi)localObject).Ikc = new com.tencent.mm.bw.b(params.DTj.toByteArray());
          try
          {
            label277:
            JSONArray localJSONArray = new JSONArray(params.DTb);
            ((egi)localObject).Ika = new LinkedList();
            i = 0;
            while (i < localJSONArray.length())
            {
              String str = URLDecoder.decode(localJSONArray.getString(i), "UTF-8");
              ((egi)localObject).Ika.add(str);
              i += 1;
            }
            i = 0;
          }
          catch (Exception localException1)
          {
            ae.printErrStackTrace("MicroMsg.WebSearch.NetSceneWebSuggest", localException1, "decode json error", new Object[0]);
            i = params.businessType;
            if (((egi)localObject).HkU == null) {
              break label469;
            }
          }
          ((b.a)localObject).funcId = 1161;
          ((b.a)localObject).uri = "/cgi-bin/mmsearch-bin/searchsuggestion";
          break label114;
          label469:
          for (boolean bool = true;; bool = false)
          {
            ae.i("MicroMsg.WebSearch.NetSceneWebSuggest", "businessTypeList is %d | contains location = %b | scene=%d | businessType=%d | isHomePage=%b | webViewId=%d", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool), Integer.valueOf(params.scene), Integer.valueOf(params.businessType), Integer.valueOf(params.DSW), Integer.valueOf(params.dDY) });
            AppMethodBeat.o(77934);
            return;
          }
          ae.e("MicroMsg.WebSearch.NetSceneWebSuggest", "keyword is unavailable");
          AppMethodBeat.o(77934);
          return;
        }
        catch (IOException localIOException)
        {
          break label277;
        }
      }
      catch (Exception localException2)
      {
        break label251;
      }
    }
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(77936);
    this.callback = paramf;
    int i = dispatch(parame, this.hZD, this);
    AppMethodBeat.o(77936);
    return i;
  }
  
  public final String ePw()
  {
    if (this.Ecp != null) {
      return this.Ecp.GWB;
    }
    return "";
  }
  
  public final int getType()
  {
    return 1161;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(77935);
    ae.i("MicroMsg.WebSearch.NetSceneWebSuggest", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(77935);
      return;
    }
    this.Ecp = ((egj)this.hZD.hQE.hQJ);
    if (this.Ecp != null) {
      ae.v("MicroMsg.WebSearch.NetSceneWebSuggest", "return data\n%s", new Object[] { this.Ecp.GWB });
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(77935);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.g
 * JD-Core Version:    0.7.0.1
 */