package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.w;
import com.tencent.mm.ai.w.a;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.storage.x;
import com.tencent.mm.plugin.sns.storage.y;
import com.tencent.mm.protocal.protobuf.afn;
import com.tencent.mm.protocal.protobuf.afo;
import com.tencent.mm.protocal.protobuf.amq;
import com.tencent.mm.protocal.protobuf.amr;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Map;

public final class m
{
  private static final m rCK;
  private Map<Long, String> cache;
  private com.tencent.mm.plugin.sns.storage.d rCL;
  public y rCM;
  public Map<String, String> rCN;
  
  static
  {
    AppMethodBeat.i(37800);
    rCK = new m();
    AppMethodBeat.o(37800);
  }
  
  private m()
  {
    AppMethodBeat.i(37791);
    this.rCL = ag.cpg();
    this.cache = new HashMap();
    this.rCM = ag.cph();
    this.rCN = new HashMap();
    HandlerThread localHandlerThread = com.tencent.mm.sdk.g.d.aqu("OpenCanvasMgr");
    localHandlerThread.start();
    new ak(localHandlerThread.getLooper()).postDelayed(new m.1(this), 5000L);
    AppMethodBeat.o(37791);
  }
  
  private void F(final long paramLong, int paramInt)
  {
    AppMethodBeat.i(37794);
    final com.tencent.mm.plugin.sns.storage.c localc = new com.tencent.mm.plugin.sns.storage.c();
    localc.field_canvasId = paramLong;
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new afn();
    ((b.a)localObject).fsY = new afo();
    ((b.a)localObject).uri = "/cgi-bin/mmoc-bin/adplayinfo/get_adcanvasinfo";
    ((b.a)localObject).funcId = 1286;
    localObject = ((b.a)localObject).ado();
    ((afn)((b)localObject).fsV.fta).wYK = paramLong;
    w.a((b)localObject, new w.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, b paramAnonymousb, com.tencent.mm.ai.m paramAnonymousm)
      {
        AppMethodBeat.i(37789);
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          ab.e("OpenCanvasMgr", "cgi fail page id %d,preLoad %d, errType %d,errCode %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(localc), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
          AppMethodBeat.o(37789);
          return 0;
        }
        paramAnonymousString = (afo)paramAnonymousb.fsW.fta;
        ab.i("OpenCanvasMgr", "getCanvasInfo pageid %d ,xml %s", new Object[] { Long.valueOf(paramLong), paramAnonymousString.wYL });
        if (!TextUtils.isEmpty(paramAnonymousString.wYL))
        {
          m.b(m.this).put(Long.valueOf(paramLong), paramAnonymousString.wYL);
          this.rCR.field_canvasXml = paramAnonymousString.wYL;
          m.c(m.this).a(this.rCR);
        }
        AppMethodBeat.o(37789);
        return 0;
      }
    });
    AppMethodBeat.o(37794);
  }
  
  private void N(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(37798);
    x localx = new x();
    localx.field_canvasId = paramString1;
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new amq();
    ((b.a)localObject).fsY = new amr();
    ((b.a)localObject).uri = "/cgi-bin/mmux-bin/wxaapp/mmuxwxa_getofficialcanvasinfo";
    ((b.a)localObject).funcId = 1890;
    localObject = ((b.a)localObject).ado();
    amq localamq = (amq)((b)localObject).fsV.fta;
    localamq.xdo = paramString1;
    localamq.xdp = paramString2;
    w.a((b)localObject, new m.3(this, paramString1, paramInt, localx));
    AppMethodBeat.o(37798);
  }
  
  public static m csa()
  {
    return rCK;
  }
  
  private String gE(String paramString1, String paramString2)
  {
    AppMethodBeat.i(37797);
    if (!bo.isNullOrNil(paramString2)) {}
    for (String str = paramString1 + paramString2;; str = paramString1)
    {
      if (this.rCN.containsKey(str))
      {
        paramString1 = (String)this.rCN.get(str);
        AppMethodBeat.o(37797);
        return paramString1;
      }
      x localx = new x();
      localx.field_canvasId = paramString1;
      localx.field_canvasExt = paramString2;
      this.rCM.get(localx, new String[] { "canvasId", "canvasExt" });
      if (!TextUtils.isEmpty(localx.field_canvasXml))
      {
        this.rCN.put(str, localx.field_canvasXml);
        paramString1 = localx.field_canvasXml;
        AppMethodBeat.o(37797);
        return paramString1;
      }
      AppMethodBeat.o(37797);
      return "";
    }
  }
  
  private String lP(long paramLong)
  {
    AppMethodBeat.i(37793);
    if (this.cache.containsKey(Long.valueOf(paramLong)))
    {
      localObject = (String)this.cache.get(Long.valueOf(paramLong));
      AppMethodBeat.o(37793);
      return localObject;
    }
    Object localObject = new com.tencent.mm.plugin.sns.storage.c();
    ((com.tencent.mm.plugin.sns.storage.c)localObject).field_canvasId = paramLong;
    this.rCL.get((com.tencent.mm.sdk.e.c)localObject, new String[0]);
    if (!TextUtils.isEmpty(((com.tencent.mm.plugin.sns.storage.c)localObject).field_canvasXml))
    {
      this.cache.put(Long.valueOf(paramLong), ((com.tencent.mm.plugin.sns.storage.c)localObject).field_canvasXml);
      localObject = ((com.tencent.mm.plugin.sns.storage.c)localObject).field_canvasXml;
      AppMethodBeat.o(37793);
      return localObject;
    }
    AppMethodBeat.o(37793);
    return "";
  }
  
  public final String k(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(37796);
    ab.i("OpenCanvasMgr", "open pageId %s, canvasExt %s, preLoad %d", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1) });
    if (bo.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(37796);
      return "";
    }
    String str = "";
    if (paramInt2 != 1) {
      str = gE(paramString1, paramString2);
    }
    if (paramInt1 != 1)
    {
      AppMethodBeat.o(37796);
      return str;
    }
    if (TextUtils.isEmpty(str))
    {
      N(paramString1, paramString2, paramInt1);
      AppMethodBeat.o(37796);
      return "";
    }
    AppMethodBeat.o(37796);
    return str;
  }
  
  public final String m(long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(37792);
    ab.i("OpenCanvasMgr", "open pageId %d, preLoad %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1) });
    if (paramLong <= 0L)
    {
      AppMethodBeat.o(37792);
      return "";
    }
    String str = "";
    if (paramInt2 != 1) {
      str = lP(paramLong);
    }
    if (paramInt1 != 1)
    {
      AppMethodBeat.o(37792);
      return str;
    }
    if (TextUtils.isEmpty(str))
    {
      F(paramLong, paramInt1);
      AppMethodBeat.o(37792);
      return "";
    }
    AppMethodBeat.o(37792);
    return str;
  }
  
  public final void u(long paramLong, String paramString)
  {
    AppMethodBeat.i(37795);
    if ((!TextUtils.isEmpty(paramString)) && (paramLong > 0L))
    {
      this.cache.put(Long.valueOf(paramLong), paramString);
      com.tencent.mm.plugin.sns.storage.c localc = new com.tencent.mm.plugin.sns.storage.c();
      localc.field_canvasId = paramLong;
      localc.field_canvasXml = paramString;
      this.rCL.a(localc);
    }
    AppMethodBeat.o(37795);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.m
 * JD-Core Version:    0.7.0.1
 */