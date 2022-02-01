package com.tencent.mm.plugin.webview.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.websearch.api.p;
import com.tencent.mm.plugin.websearch.api.z;
import com.tencent.mm.protocal.protobuf.dyl;
import com.tencent.mm.protocal.protobuf.dyp;
import com.tencent.mm.protocal.protobuf.dyq;
import com.tencent.mm.protocal.protobuf.ebv;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.LinkedList;
import org.json.JSONArray;

public final class f
  extends com.tencent.mm.plugin.websearch.api.b
  implements k
{
  private p BYB;
  private dyq Chk;
  private g callback;
  private com.tencent.mm.ak.b hEg;
  
  public f(p paramp)
  {
    AppMethodBeat.i(77934);
    this.BYB = paramp;
    this.Lt = paramp.cZL;
    this.mScene = paramp.scene;
    this.BYb = paramp.drc;
    Object localObject;
    int i;
    if (!bs.isNullOrNil(paramp.cZL))
    {
      ac.i("MicroMsg.WebSearch.NetSceneWebSuggest", "Constructors: query=%s", new Object[] { paramp.cZL });
      localObject = new b.a();
      if ((paramp.scene == 201) || (paramp.BYs == 1)) {
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
        ((b.a)localObject).hvt = new dyp();
        ((b.a)localObject).hvu = new dyq();
        this.hEg = ((b.a)localObject).aAz();
        localObject = (dyp)this.hEg.hvr.hvw;
        ((dyp)localObject).EJp = paramp.cZL;
        ((dyp)localObject).EfR = paramp.businessType;
        ((dyp)localObject).GeJ = z.Ul(0);
        ((dyp)localObject).FCc = paramp.BYg;
        ((dyp)localObject).FhT = z.bJn();
        ((dyp)localObject).Scene = paramp.scene;
        ((dyp)localObject).Gev = paramp.sessionId;
        if (paramp.BYu == null) {}
      }
      try
      {
        ((dyp)localObject).GeQ = new com.tencent.mm.bw.b(paramp.BYu.toByteArray());
        label251:
        if (paramp.BYt != null) {}
        try
        {
          ((dyp)localObject).GeP = new com.tencent.mm.bw.b(paramp.BYt.toByteArray());
          try
          {
            label277:
            JSONArray localJSONArray = new JSONArray(paramp.BYl);
            ((dyp)localObject).GeN = new LinkedList();
            i = 0;
            while (i < localJSONArray.length())
            {
              String str = URLDecoder.decode(localJSONArray.getString(i), "UTF-8");
              ((dyp)localObject).GeN.add(str);
              i += 1;
            }
            i = 0;
          }
          catch (Exception localException1)
          {
            ac.printErrStackTrace("MicroMsg.WebSearch.NetSceneWebSuggest", localException1, "decode json error", new Object[0]);
            i = paramp.businessType;
            if (((dyp)localObject).FhT == null) {
              break label469;
            }
          }
          ((b.a)localObject).funcId = 1161;
          ((b.a)localObject).uri = "/cgi-bin/mmsearch-bin/searchsuggestion";
          break label114;
          label469:
          for (boolean bool = true;; bool = false)
          {
            ac.i("MicroMsg.WebSearch.NetSceneWebSuggest", "businessTypeList is %d | contains location = %b | scene=%d | businessType=%d | isHomePage=%b | webViewId=%d", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool), Integer.valueOf(paramp.scene), Integer.valueOf(paramp.businessType), Integer.valueOf(paramp.BYg), Integer.valueOf(paramp.drc) });
            AppMethodBeat.o(77934);
            return;
          }
          ac.e("MicroMsg.WebSearch.NetSceneWebSuggest", "keyword is unavailable");
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
    int i = dispatch(parame, this.hEg, this);
    AppMethodBeat.o(77936);
    return i;
  }
  
  public final String ewZ()
  {
    if (this.Chk != null) {
      return this.Chk.FhN;
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
    ac.i("MicroMsg.WebSearch.NetSceneWebSuggest", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(77935);
      return;
    }
    this.Chk = ((dyq)this.hEg.hvs.hvw);
    if (this.Chk != null) {
      ac.v("MicroMsg.WebSearch.NetSceneWebSuggest", "return data\n%s", new Object[] { this.Chk.FhN });
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(77935);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.f
 * JD-Core Version:    0.7.0.1
 */