package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.x;
import com.tencent.mm.ak.x.a;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.aa;
import com.tencent.mm.plugin.sns.storage.ab;
import com.tencent.mm.plugin.sns.storage.d;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.protocal.protobuf.arw;
import com.tencent.mm.protocal.protobuf.bal;
import com.tencent.mm.protocal.protobuf.bam;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.HashMap;
import java.util.Map;

public final class m
{
  private static final m yve;
  private Map<Long, String> aMj;
  private d yvf;
  public ab yvg;
  public Map<String, String> yvh;
  
  static
  {
    AppMethodBeat.i(97409);
    yve = new m();
    AppMethodBeat.o(97409);
  }
  
  private m()
  {
    AppMethodBeat.i(97400);
    this.yvf = af.dHS();
    this.aMj = new HashMap();
    this.yvg = af.dHT();
    this.yvh = new HashMap();
    new ao("OpenCanvasMgr").postDelayed(new Runnable()
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
  
  private void R(final long paramLong, int paramInt)
  {
    AppMethodBeat.i(97403);
    final com.tencent.mm.plugin.sns.storage.c localc = new com.tencent.mm.plugin.sns.storage.c();
    localc.field_canvasId = paramLong;
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new arv();
    ((b.a)localObject).hvu = new arw();
    ((b.a)localObject).uri = "/cgi-bin/mmoc-bin/adplayinfo/get_adcanvasinfo";
    ((b.a)localObject).funcId = 1286;
    localObject = ((b.a)localObject).aAz();
    ((arv)((com.tencent.mm.ak.b)localObject).hvr.hvw).ELx = paramLong;
    x.a((com.tencent.mm.ak.b)localObject, new x.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.b paramAnonymousb, n paramAnonymousn)
      {
        AppMethodBeat.i(97398);
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          ac.e("OpenCanvasMgr", "cgi fail page id %d,preLoad %d, errType %d,errCode %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(localc), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
          AppMethodBeat.o(97398);
          return 0;
        }
        paramAnonymousString = (arw)paramAnonymousb.hvs.hvw;
        ac.i("OpenCanvasMgr", "getCanvasInfo pageid %d ,xml %s", new Object[] { Long.valueOf(paramLong), paramAnonymousString.ELy });
        if (!TextUtils.isEmpty(paramAnonymousString.ELy))
        {
          m.b(m.this).put(Long.valueOf(paramLong), paramAnonymousString.ELy);
          this.yvl.field_canvasXml = paramAnonymousString.ELy;
          m.c(m.this).a(this.yvl);
        }
        AppMethodBeat.o(97398);
        return 0;
      }
    });
    AppMethodBeat.o(97403);
  }
  
  private void aa(final String paramString1, String paramString2, final int paramInt)
  {
    AppMethodBeat.i(97407);
    final aa localaa = new aa();
    localaa.field_canvasId = paramString1;
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new bal();
    ((b.a)localObject).hvu = new bam();
    ((b.a)localObject).uri = "/cgi-bin/mmux-bin/wxaapp/mmuxwxa_getofficialcanvasinfo";
    ((b.a)localObject).funcId = 1890;
    localObject = ((b.a)localObject).aAz();
    bal localbal = (bal)((com.tencent.mm.ak.b)localObject).hvr.hvw;
    localbal.ERr = paramString1;
    localbal.ERs = paramString2;
    x.a((com.tencent.mm.ak.b)localObject, new x.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.b paramAnonymousb, n paramAnonymousn)
      {
        AppMethodBeat.i(97399);
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          ac.e("OpenCanvasMgr", "cgi fail pageid %s,preLoad %d, errType %d,errCode %d", new Object[] { paramString1, Integer.valueOf(paramInt), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
          AppMethodBeat.o(97399);
          return 0;
        }
        paramAnonymousString = ((bam)paramAnonymousb.hvs.hvw).ERt.eQU();
        ac.i("OpenCanvasMgr", "getCanvasInfo pageid %s ,xml %s", new Object[] { paramString1, paramAnonymousString });
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
  
  public static m dLQ()
  {
    return yve;
  }
  
  private String jB(String paramString1, String paramString2)
  {
    AppMethodBeat.i(97406);
    if (!bs.isNullOrNil(paramString2)) {}
    for (String str = paramString1 + paramString2;; str = paramString1)
    {
      if (this.yvh.containsKey(str))
      {
        paramString1 = (String)this.yvh.get(str);
        AppMethodBeat.o(97406);
        return paramString1;
      }
      aa localaa = new aa();
      localaa.field_canvasId = paramString1;
      localaa.field_canvasExt = paramString2;
      this.yvg.get(localaa, new String[] { "canvasId", "canvasExt" });
      if (!TextUtils.isEmpty(localaa.field_canvasXml))
      {
        this.yvh.put(str, localaa.field_canvasXml);
        paramString1 = localaa.field_canvasXml;
        AppMethodBeat.o(97406);
        return paramString1;
      }
      AppMethodBeat.o(97406);
      return "";
    }
  }
  
  private String xA(long paramLong)
  {
    AppMethodBeat.i(97402);
    if (this.aMj.containsKey(Long.valueOf(paramLong)))
    {
      localObject = (String)this.aMj.get(Long.valueOf(paramLong));
      AppMethodBeat.o(97402);
      return localObject;
    }
    Object localObject = new com.tencent.mm.plugin.sns.storage.c();
    ((com.tencent.mm.plugin.sns.storage.c)localObject).field_canvasId = paramLong;
    this.yvf.get((com.tencent.mm.sdk.e.c)localObject, new String[0]);
    if (!TextUtils.isEmpty(((com.tencent.mm.plugin.sns.storage.c)localObject).field_canvasXml))
    {
      this.aMj.put(Long.valueOf(paramLong), ((com.tencent.mm.plugin.sns.storage.c)localObject).field_canvasXml);
      localObject = ((com.tencent.mm.plugin.sns.storage.c)localObject).field_canvasXml;
      AppMethodBeat.o(97402);
      return localObject;
    }
    AppMethodBeat.o(97402);
    return "";
  }
  
  public final String m(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(97405);
    ac.i("OpenCanvasMgr", "open pageId %s, canvasExt %s, preLoad %d", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1) });
    if (bs.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(97405);
      return "";
    }
    String str = "";
    if (paramInt2 != 1) {
      str = jB(paramString1, paramString2);
    }
    if (paramInt1 != 1)
    {
      AppMethodBeat.o(97405);
      return str;
    }
    if (TextUtils.isEmpty(str))
    {
      aa(paramString1, paramString2, paramInt1);
      AppMethodBeat.o(97405);
      return "";
    }
    AppMethodBeat.o(97405);
    return str;
  }
  
  public final String p(long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(97401);
    ac.i("OpenCanvasMgr", "open pageId %d, preLoad %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1) });
    if (paramLong <= 0L)
    {
      AppMethodBeat.o(97401);
      return "";
    }
    String str = "";
    if (paramInt2 != 1) {
      str = xA(paramLong);
    }
    if (paramInt1 != 1)
    {
      AppMethodBeat.o(97401);
      return str;
    }
    if (TextUtils.isEmpty(str))
    {
      R(paramLong, paramInt1);
      AppMethodBeat.o(97401);
      return "";
    }
    AppMethodBeat.o(97401);
    return str;
  }
  
  public final void y(long paramLong, String paramString)
  {
    AppMethodBeat.i(97404);
    if ((!TextUtils.isEmpty(paramString)) && (paramLong > 0L))
    {
      this.aMj.put(Long.valueOf(paramLong), paramString);
      com.tencent.mm.plugin.sns.storage.c localc = new com.tencent.mm.plugin.sns.storage.c();
      localc.field_canvasId = paramLong;
      localc.field_canvasXml = paramString;
      this.yvf.a(localc);
    }
    AppMethodBeat.o(97404);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.m
 * JD-Core Version:    0.7.0.1
 */