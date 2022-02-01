package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.x;
import com.tencent.mm.al.x.a;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.aa;
import com.tencent.mm.plugin.sns.storage.ab;
import com.tencent.mm.plugin.sns.storage.d;
import com.tencent.mm.protocal.protobuf.aor;
import com.tencent.mm.protocal.protobuf.aos;
import com.tencent.mm.protocal.protobuf.awt;
import com.tencent.mm.protocal.protobuf.awu;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;
import java.util.Map;

public final class m
{
  private static final m xiq;
  private Map<Long, String> aLt;
  private d xir;
  public ab xis;
  public Map<String, String> xit;
  
  static
  {
    AppMethodBeat.i(97409);
    xiq = new m();
    AppMethodBeat.o(97409);
  }
  
  private m()
  {
    AppMethodBeat.i(97400);
    this.xir = af.dtv();
    this.aLt = new HashMap();
    this.xis = af.dtw();
    this.xit = new HashMap();
    new ap("OpenCanvasMgr").postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(97397);
        m.a(m.this);
        AppMethodBeat.o(97397);
      }
    }, 5000L);
    AppMethodBeat.o(97400);
  }
  
  private void O(final long paramLong, int paramInt)
  {
    AppMethodBeat.i(97403);
    final com.tencent.mm.plugin.sns.storage.c localc = new com.tencent.mm.plugin.sns.storage.c();
    localc.field_canvasId = paramLong;
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new aor();
    ((b.a)localObject).gUV = new aos();
    ((b.a)localObject).uri = "/cgi-bin/mmoc-bin/adplayinfo/get_adcanvasinfo";
    ((b.a)localObject).funcId = 1286;
    localObject = ((b.a)localObject).atI();
    ((aor)((com.tencent.mm.al.b)localObject).gUS.gUX).Dqv = paramLong;
    x.a((com.tencent.mm.al.b)localObject, new x.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.b paramAnonymousb, n paramAnonymousn)
      {
        AppMethodBeat.i(97398);
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          ad.e("OpenCanvasMgr", "cgi fail page id %d,preLoad %d, errType %d,errCode %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(localc), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
          AppMethodBeat.o(97398);
          return 0;
        }
        paramAnonymousString = (aos)paramAnonymousb.gUT.gUX;
        ad.i("OpenCanvasMgr", "getCanvasInfo pageid %d ,xml %s", new Object[] { Long.valueOf(paramLong), paramAnonymousString.Dqw });
        if (!TextUtils.isEmpty(paramAnonymousString.Dqw))
        {
          m.b(m.this).put(Long.valueOf(paramLong), paramAnonymousString.Dqw);
          this.xix.field_canvasXml = paramAnonymousString.Dqw;
          m.c(m.this).a(this.xix);
        }
        AppMethodBeat.o(97398);
        return 0;
      }
    });
    AppMethodBeat.o(97403);
  }
  
  private void Z(final String paramString1, String paramString2, final int paramInt)
  {
    AppMethodBeat.i(97407);
    final aa localaa = new aa();
    localaa.field_canvasId = paramString1;
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new awt();
    ((b.a)localObject).gUV = new awu();
    ((b.a)localObject).uri = "/cgi-bin/mmux-bin/wxaapp/mmuxwxa_getofficialcanvasinfo";
    ((b.a)localObject).funcId = 1890;
    localObject = ((b.a)localObject).atI();
    awt localawt = (awt)((com.tencent.mm.al.b)localObject).gUS.gUX;
    localawt.DvW = paramString1;
    localawt.DvX = paramString2;
    x.a((com.tencent.mm.al.b)localObject, new x.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.b paramAnonymousb, n paramAnonymousn)
      {
        AppMethodBeat.i(97399);
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          ad.e("OpenCanvasMgr", "cgi fail pageid %s,preLoad %d, errType %d,errCode %d", new Object[] { paramString1, Integer.valueOf(paramInt), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
          AppMethodBeat.o(97399);
          return 0;
        }
        paramAnonymousString = ((awu)paramAnonymousb.gUT.gUX).DvY.eBA();
        ad.i("OpenCanvasMgr", "getCanvasInfo pageid %s ,xml %s", new Object[] { paramString1, paramAnonymousString });
        if (!TextUtils.isEmpty(paramAnonymousString))
        {
          m.d(m.this).put(paramString1, paramAnonymousString);
          localaa.field_canvasXml = paramAnonymousString;
          m.e(m.this).a(localaa);
        }
        AppMethodBeat.o(97399);
        return 0;
      }
    });
    AppMethodBeat.o(97407);
  }
  
  public static m dxr()
  {
    return xiq;
  }
  
  private String jd(String paramString1, String paramString2)
  {
    AppMethodBeat.i(97406);
    if (!bt.isNullOrNil(paramString2)) {}
    for (String str = paramString1 + paramString2;; str = paramString1)
    {
      if (this.xit.containsKey(str))
      {
        paramString1 = (String)this.xit.get(str);
        AppMethodBeat.o(97406);
        return paramString1;
      }
      aa localaa = new aa();
      localaa.field_canvasId = paramString1;
      localaa.field_canvasExt = paramString2;
      this.xis.get(localaa, new String[] { "canvasId", "canvasExt" });
      if (!TextUtils.isEmpty(localaa.field_canvasXml))
      {
        this.xit.put(str, localaa.field_canvasXml);
        paramString1 = localaa.field_canvasXml;
        AppMethodBeat.o(97406);
        return paramString1;
      }
      AppMethodBeat.o(97406);
      return "";
    }
  }
  
  private String sX(long paramLong)
  {
    AppMethodBeat.i(97402);
    if (this.aLt.containsKey(Long.valueOf(paramLong)))
    {
      localObject = (String)this.aLt.get(Long.valueOf(paramLong));
      AppMethodBeat.o(97402);
      return localObject;
    }
    Object localObject = new com.tencent.mm.plugin.sns.storage.c();
    ((com.tencent.mm.plugin.sns.storage.c)localObject).field_canvasId = paramLong;
    this.xir.get((com.tencent.mm.sdk.e.c)localObject, new String[0]);
    if (!TextUtils.isEmpty(((com.tencent.mm.plugin.sns.storage.c)localObject).field_canvasXml))
    {
      this.aLt.put(Long.valueOf(paramLong), ((com.tencent.mm.plugin.sns.storage.c)localObject).field_canvasXml);
      localObject = ((com.tencent.mm.plugin.sns.storage.c)localObject).field_canvasXml;
      AppMethodBeat.o(97402);
      return localObject;
    }
    AppMethodBeat.o(97402);
    return "";
  }
  
  public final void A(long paramLong, String paramString)
  {
    AppMethodBeat.i(97404);
    if ((!TextUtils.isEmpty(paramString)) && (paramLong > 0L))
    {
      this.aLt.put(Long.valueOf(paramLong), paramString);
      com.tencent.mm.plugin.sns.storage.c localc = new com.tencent.mm.plugin.sns.storage.c();
      localc.field_canvasId = paramLong;
      localc.field_canvasXml = paramString;
      this.xir.a(localc);
    }
    AppMethodBeat.o(97404);
  }
  
  public final String m(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(97405);
    ad.i("OpenCanvasMgr", "open pageId %s, canvasExt %s, preLoad %d", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1) });
    if (bt.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(97405);
      return "";
    }
    String str = "";
    if (paramInt2 != 1) {
      str = jd(paramString1, paramString2);
    }
    if (paramInt1 != 1)
    {
      AppMethodBeat.o(97405);
      return str;
    }
    if (TextUtils.isEmpty(str))
    {
      Z(paramString1, paramString2, paramInt1);
      AppMethodBeat.o(97405);
      return "";
    }
    AppMethodBeat.o(97405);
    return str;
  }
  
  public final String n(long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(97401);
    ad.i("OpenCanvasMgr", "open pageId %d, preLoad %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1) });
    if (paramLong <= 0L)
    {
      AppMethodBeat.o(97401);
      return "";
    }
    String str = "";
    if (paramInt2 != 1) {
      str = sX(paramLong);
    }
    if (paramInt1 != 1)
    {
      AppMethodBeat.o(97401);
      return str;
    }
    if (TextUtils.isEmpty(str))
    {
      O(paramLong, paramInt1);
      AppMethodBeat.o(97401);
      return "";
    }
    AppMethodBeat.o(97401);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.m
 * JD-Core Version:    0.7.0.1
 */