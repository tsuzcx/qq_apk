package com.tencent.mm.plugin.webview.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.protocal.protobuf.dsu;
import com.tencent.mm.protocal.protobuf.dsy;
import com.tencent.mm.protocal.protobuf.dsz;
import com.tencent.mm.protocal.protobuf.dwe;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.LinkedList;
import org.json.JSONArray;

public final class f
  extends com.tencent.mm.plugin.websearch.api.b
  implements k
{
  private com.tencent.mm.plugin.websearch.api.q AGj;
  private dsz AOU;
  private g callback;
  private com.tencent.mm.al.b hdD;
  
  public f(com.tencent.mm.plugin.websearch.api.q paramq)
  {
    AppMethodBeat.i(77934);
    this.AGj = paramq;
    this.Ky = paramq.dcm;
    this.mScene = paramq.scene;
    this.AFI = paramq.dtt;
    Object localObject;
    int i;
    if (!bt.isNullOrNil(paramq.dcm))
    {
      ad.i("MicroMsg.WebSearch.NetSceneWebSuggest", "Constructors: query=%s", new Object[] { paramq.dcm });
      localObject = new b.a();
      if ((paramq.scene == 201) || (paramq.AFZ == 1)) {
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
        ((b.a)localObject).gUU = new dsy();
        ((b.a)localObject).gUV = new dsz();
        this.hdD = ((b.a)localObject).atI();
        localObject = (dsy)this.hdD.gUS.gUX;
        ((dsy)localObject).Dop = paramq.dcm;
        ((dsy)localObject).CNp = paramq.businessType;
        ((dsy)localObject).EHx = aa.Sb(0);
        ((dsy)localObject).Efc = paramq.AFN;
        ((dsy)localObject).DLE = aa.bCk();
        ((dsy)localObject).Scene = paramq.scene;
        ((dsy)localObject).EHj = paramq.sessionId;
        if (paramq.AGb == null) {}
      }
      try
      {
        ((dsy)localObject).EHE = new com.tencent.mm.bx.b(paramq.AGb.toByteArray());
        label251:
        if (paramq.AGa != null) {}
        try
        {
          ((dsy)localObject).EHD = new com.tencent.mm.bx.b(paramq.AGa.toByteArray());
          try
          {
            label277:
            JSONArray localJSONArray = new JSONArray(paramq.AFS);
            ((dsy)localObject).EHB = new LinkedList();
            i = 0;
            while (i < localJSONArray.length())
            {
              String str = URLDecoder.decode(localJSONArray.getString(i), "UTF-8");
              ((dsy)localObject).EHB.add(str);
              i += 1;
            }
            i = 0;
          }
          catch (Exception localException1)
          {
            ad.printErrStackTrace("MicroMsg.WebSearch.NetSceneWebSuggest", localException1, "decode json error", new Object[0]);
            i = paramq.businessType;
            if (((dsy)localObject).DLE == null) {
              break label469;
            }
          }
          ((b.a)localObject).funcId = 1161;
          ((b.a)localObject).uri = "/cgi-bin/mmsearch-bin/searchsuggestion";
          break label114;
          label469:
          for (boolean bool = true;; bool = false)
          {
            ad.i("MicroMsg.WebSearch.NetSceneWebSuggest", "businessTypeList is %d | contains location = %b | scene=%d | businessType=%d | isHomePage=%b | webViewId=%d", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool), Integer.valueOf(paramq.scene), Integer.valueOf(paramq.businessType), Integer.valueOf(paramq.AFN), Integer.valueOf(paramq.dtt) });
            AppMethodBeat.o(77934);
            return;
          }
          ad.e("MicroMsg.WebSearch.NetSceneWebSuggest", "keyword is unavailable");
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
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(77936);
    this.callback = paramg;
    int i = dispatch(parame, this.hdD, this);
    AppMethodBeat.o(77936);
    return i;
  }
  
  public final String ehF()
  {
    if (this.AOU != null) {
      return this.AOU.DLy;
    }
    return "";
  }
  
  public final int getType()
  {
    return 1161;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(77935);
    ad.i("MicroMsg.WebSearch.NetSceneWebSuggest", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(77935);
      return;
    }
    this.AOU = ((dsz)this.hdD.gUT.gUX);
    if (this.AOU != null) {
      ad.v("MicroMsg.WebSearch.NetSceneWebSuggest", "return data\n%s", new Object[] { this.AOU.DLy });
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(77935);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.f
 * JD-Core Version:    0.7.0.1
 */