package com.tencent.mm.plugin.webview.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.s.r;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.s;
import com.tencent.mm.protocal.protobuf.cyi;
import com.tencent.mm.protocal.protobuf.cym;
import com.tencent.mm.protocal.protobuf.cyn;
import com.tencent.mm.protocal.protobuf.dbf;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.LinkedList;
import org.json.JSONArray;

public final class f
  extends com.tencent.mm.plugin.websearch.api.b
  implements k
{
  private com.tencent.mm.ai.f callback;
  private com.tencent.mm.ai.b fBd;
  s fpY;
  private cyn uPc;
  
  public f(s params)
  {
    AppMethodBeat.i(5718);
    this.fpY = params;
    this.DK = params.cnv;
    this.mScene = params.scene;
    this.uIB = params.cCT;
    Object localObject;
    int i;
    if (!bo.isNullOrNil(params.cnv))
    {
      ab.i("MicroMsg.WebSearch.NetSceneWebSuggest", "Constructors: query=%s", new Object[] { params.cnv });
      localObject = new b.a();
      if ((params.scene == 201) || (params.uIQ == 1)) {
        i = 1;
      }
    }
    for (;;)
    {
      if ((i != 0) && (r.aNV()))
      {
        ((b.a)localObject).funcId = 1747;
        ((b.a)localObject).uri = "/cgi-bin/mmux-bin/wxaapp/mmuxwxa_weappsuggestion";
        label121:
        ((b.a)localObject).fsX = new cym();
        ((b.a)localObject).fsY = new cyn();
        this.fBd = ((b.a)localObject).ado();
        localObject = (cym)this.fBd.fsV.fta;
        ((cym)localObject).wXt = params.cnv;
        ((cym)localObject).wBW = params.businessType;
        ((cym)localObject).xpF = aa.Jf(0);
        ((cym)localObject).xHM = params.uIE;
        ((cym)localObject).xqU = aa.acv();
        ((cym)localObject).Scene = params.scene;
        ((cym)localObject).xpJ = params.cpW;
        if (params.uIS == null) {}
      }
      try
      {
        ((cym)localObject).xpK = new com.tencent.mm.bv.b(params.uIS.toByteArray());
        label258:
        if (params.uIR != null) {}
        try
        {
          ((cym)localObject).xpL = new com.tencent.mm.bv.b(params.uIR.toByteArray());
          try
          {
            label284:
            JSONArray localJSONArray = new JSONArray(params.uIJ);
            ((cym)localObject).yfA = new LinkedList();
            i = 0;
            while (i < localJSONArray.length())
            {
              String str = URLDecoder.decode(localJSONArray.getString(i), "UTF-8");
              ((cym)localObject).yfA.add(str);
              i += 1;
            }
            i = 0;
          }
          catch (Exception localException1)
          {
            ab.printErrStackTrace("MicroMsg.WebSearch.NetSceneWebSuggest", localException1, "decode json error", new Object[0]);
            i = params.businessType;
            if (((cym)localObject).xqU == null) {
              break label477;
            }
          }
          ((b.a)localObject).funcId = 1161;
          ((b.a)localObject).uri = "/cgi-bin/mmsearch-bin/searchsuggestion";
          break label121;
          label477:
          for (boolean bool = true;; bool = false)
          {
            ab.i("MicroMsg.WebSearch.NetSceneWebSuggest", "businessTypeList is %d | contains location = %b | scene=%d | businessType=%d | isHomePage=%b | webViewId=%d", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool), Integer.valueOf(params.scene), Integer.valueOf(params.businessType), Integer.valueOf(params.uIE), Integer.valueOf(params.cCT) });
            AppMethodBeat.o(5718);
            return;
          }
          ab.e("MicroMsg.WebSearch.NetSceneWebSuggest", "keyword is unavailable");
          AppMethodBeat.o(5718);
          return;
        }
        catch (IOException localIOException)
        {
          break label284;
        }
      }
      catch (Exception localException2)
      {
        break label258;
      }
    }
  }
  
  public final String act()
  {
    if (this.uPc != null) {
      return this.uPc.wAa;
    }
    return "";
  }
  
  public final int doScene(e parame, com.tencent.mm.ai.f paramf)
  {
    AppMethodBeat.i(5720);
    this.callback = paramf;
    int i = dispatch(parame, this.fBd, this);
    AppMethodBeat.o(5720);
    return i;
  }
  
  public final int getType()
  {
    return 1161;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(5719);
    ab.i("MicroMsg.WebSearch.NetSceneWebSuggest", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(5719);
      return;
    }
    this.uPc = ((cyn)this.fBd.fsW.fta);
    if (this.uPc != null) {
      ab.v("MicroMsg.WebSearch.NetSceneWebSuggest", "return data\n%s", new Object[] { this.uPc.wAa });
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(5719);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.f
 * JD-Core Version:    0.7.0.1
 */