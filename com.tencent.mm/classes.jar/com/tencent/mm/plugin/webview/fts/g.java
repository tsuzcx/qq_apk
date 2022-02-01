package com.tencent.mm.plugin.webview.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.plugin.websearch.api.w;
import com.tencent.mm.protocal.protobuf.ghx;
import com.tencent.mm.protocal.protobuf.gic;
import com.tencent.mm.protocal.protobuf.gid;
import com.tencent.mm.protocal.protobuf.gmm;
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
  private gid WnR;
  private w WnS;
  private h callback;
  private c oDw;
  
  public g(w paramw)
  {
    AppMethodBeat.i(77934);
    this.WnS = paramw;
    this.brD = paramw.hAB;
    this.mScene = paramw.scene;
    this.WnM = paramw.hVk;
    Object localObject;
    int i;
    if (!Util.isNullOrNil(paramw.hAB))
    {
      Log.i("MicroMsg.WebSearch.NetSceneWebSuggest", "Constructors: query=%s", new Object[] { paramw.hAB });
      localObject = new c.a();
      if (paramw.Won == 1) {
        i = 1;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        ((c.a)localObject).funcId = 1747;
        ((c.a)localObject).uri = "/cgi-bin/mmux-bin/wxaapp/mmuxwxa_weappsuggestion";
        label104:
        ((c.a)localObject).otE = new gic();
        ((c.a)localObject).otF = new gid();
        this.oDw = ((c.a)localObject).bEF();
        localObject = (gic)c.b.b(this.oDw.otB);
        ((gic)localObject).aakp = paramw.hAB;
        ((gic)localObject).YYo = paramw.businessType;
        ((gic)localObject).acet = aj.asY(0);
        ((gic)localObject).abuB = paramw.Wob;
        ((gic)localObject).aaLr = aj.dch();
        ((gic)localObject).IJG = paramw.scene;
        ((gic)localObject).acee = paramw.sessionId;
        ((gic)localObject).aaLs = aj.iqa();
        if (paramw.Wop == null) {}
      }
      try
      {
        ((gic)localObject).aceA = new com.tencent.mm.bx.b(paramw.Wop.toByteArray());
        label249:
        if (paramw.Woo != null) {}
        try
        {
          ((gic)localObject).acez = new com.tencent.mm.bx.b(paramw.Woo.toByteArray());
          try
          {
            label275:
            JSONArray localJSONArray = new JSONArray(paramw.Wog);
            ((gic)localObject).acex = new LinkedList();
            i = 0;
            while (i < localJSONArray.length())
            {
              String str = URLDecoder.decode(localJSONArray.getString(i), "UTF-8");
              ((gic)localObject).acex.add(str);
              i += 1;
            }
            i = 0;
          }
          catch (Exception localException1)
          {
            Log.printErrStackTrace("MicroMsg.WebSearch.NetSceneWebSuggest", localException1, "decode json error", new Object[0]);
            i = paramw.businessType;
            if (((gic)localObject).aaLr == null) {
              break label467;
            }
          }
          ((c.a)localObject).funcId = 1161;
          ((c.a)localObject).uri = "/cgi-bin/mmsearch-bin/searchsuggestion";
          break label104;
          label467:
          for (boolean bool = true;; bool = false)
          {
            Log.i("MicroMsg.WebSearch.NetSceneWebSuggest", "businessTypeList is %d | contains location = %b | scene=%d | businessType=%d | isHomePage=%b | webViewId=%d", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool), Integer.valueOf(paramw.scene), Integer.valueOf(paramw.businessType), Integer.valueOf(paramw.Wob), Integer.valueOf(paramw.hVk) });
            AppMethodBeat.o(77934);
            return;
          }
          Log.e("MicroMsg.WebSearch.NetSceneWebSuggest", "keyword is unavailable");
          AppMethodBeat.o(77934);
          return;
        }
        catch (IOException localIOException)
        {
          break label275;
        }
      }
      catch (Exception localException2)
      {
        break label249;
      }
    }
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, h paramh)
  {
    AppMethodBeat.i(77936);
    this.callback = paramh;
    int i = dispatch(paramg, this.oDw, this);
    AppMethodBeat.o(77936);
    return i;
  }
  
  public final int getType()
  {
    return 1161;
  }
  
  public final String ipG()
  {
    if (this.WnR != null) {
      return this.WnR.aayd;
    }
    return "";
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
    this.WnR = ((gid)c.c.b(this.oDw.otC));
    if (this.WnR != null) {
      Log.v("MicroMsg.WebSearch.NetSceneWebSuggest", "return data\n%s", new Object[] { this.WnR.aayd });
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(77935);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.g
 * JD-Core Version:    0.7.0.1
 */