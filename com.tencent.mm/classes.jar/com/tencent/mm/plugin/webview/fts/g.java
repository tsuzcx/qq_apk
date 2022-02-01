package com.tencent.mm.plugin.webview.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.websearch.api.s;
import com.tencent.mm.protocal.protobuf.een;
import com.tencent.mm.protocal.protobuf.eer;
import com.tencent.mm.protocal.protobuf.ees;
import com.tencent.mm.protocal.protobuf.eib;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.LinkedList;
import org.json.JSONArray;

public final class g
  extends com.tencent.mm.plugin.websearch.api.b
  implements k
{
  private s DBv;
  private ees DKr;
  private f callback;
  private com.tencent.mm.al.b hWL;
  
  public g(s params)
  {
    AppMethodBeat.i(77934);
    this.DBv = params;
    this.Nl = params.dld;
    this.mScene = params.scene;
    this.DAT = params.dCT;
    Object localObject;
    int i;
    if (!bt.isNullOrNil(params.dld))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.NetSceneWebSuggest", "Constructors: query=%s", new Object[] { params.dld });
      localObject = new b.a();
      if ((params.scene == 201) || (params.DBl == 1)) {
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
        ((b.a)localObject).hNM = new eer();
        ((b.a)localObject).hNN = new ees();
        this.hWL = ((b.a)localObject).aDC();
        localObject = (eer)this.hWL.hNK.hNQ;
        ((eer)localObject).Gsr = params.dld;
        ((eer)localObject).FMq = params.businessType;
        ((eer)localObject).HPP = com.tencent.mm.plugin.websearch.api.ad.We(0);
        ((eer)localObject).Hmr = params.DAZ;
        ((eer)localObject).GRt = com.tencent.mm.plugin.websearch.api.ad.bNG();
        ((eer)localObject).Scene = params.scene;
        ((eer)localObject).HPB = params.sessionId;
        if (params.DBn == null) {}
      }
      try
      {
        ((eer)localObject).HPW = new com.tencent.mm.bx.b(params.DBn.toByteArray());
        label251:
        if (params.DBm != null) {}
        try
        {
          ((eer)localObject).HPV = new com.tencent.mm.bx.b(params.DBm.toByteArray());
          try
          {
            label277:
            JSONArray localJSONArray = new JSONArray(params.DBe);
            ((eer)localObject).HPT = new LinkedList();
            i = 0;
            while (i < localJSONArray.length())
            {
              String str = URLDecoder.decode(localJSONArray.getString(i), "UTF-8");
              ((eer)localObject).HPT.add(str);
              i += 1;
            }
            i = 0;
          }
          catch (Exception localException1)
          {
            com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.WebSearch.NetSceneWebSuggest", localException1, "decode json error", new Object[0]);
            i = params.businessType;
            if (((eer)localObject).GRt == null) {
              break label469;
            }
          }
          ((b.a)localObject).funcId = 1161;
          ((b.a)localObject).uri = "/cgi-bin/mmsearch-bin/searchsuggestion";
          break label114;
          label469:
          for (boolean bool = true;; bool = false)
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.NetSceneWebSuggest", "businessTypeList is %d | contains location = %b | scene=%d | businessType=%d | isHomePage=%b | webViewId=%d", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool), Integer.valueOf(params.scene), Integer.valueOf(params.businessType), Integer.valueOf(params.DAZ), Integer.valueOf(params.dCT) });
            AppMethodBeat.o(77934);
            return;
          }
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.WebSearch.NetSceneWebSuggest", "keyword is unavailable");
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
    int i = dispatch(parame, this.hWL, this);
    AppMethodBeat.o(77936);
    return i;
  }
  
  public final String eLN()
  {
    if (this.DKr != null) {
      return this.DKr.GDb;
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
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.NetSceneWebSuggest", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(77935);
      return;
    }
    this.DKr = ((ees)this.hWL.hNL.hNQ);
    if (this.DKr != null) {
      com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.WebSearch.NetSceneWebSuggest", "return data\n%s", new Object[] { this.DKr.GDb });
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(77935);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.g
 * JD-Core Version:    0.7.0.1
 */