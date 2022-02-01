package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.aa;
import com.tencent.mm.an.aa.a;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.q;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.a;
import com.tencent.mm.plugin.sns.storage.ab;
import com.tencent.mm.plugin.sns.storage.ac;
import com.tencent.mm.protocal.protobuf.bpc;
import com.tencent.mm.protocal.protobuf.bpd;
import com.tencent.mm.protocal.protobuf.byx;
import com.tencent.mm.protocal.protobuf.byy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.util.HashMap;
import java.util.Map;

public final class m
{
  private static final m Kze;
  private com.tencent.mm.plugin.sns.storage.b Kzf;
  public ac Kzg;
  public Map<String, String> Kzh;
  private Map<Long, String> axy;
  
  static
  {
    AppMethodBeat.i(97409);
    Kze = new m();
    AppMethodBeat.o(97409);
  }
  
  private m()
  {
    AppMethodBeat.i(97400);
    this.Kzf = aj.fOJ();
    this.axy = new HashMap();
    this.Kzg = aj.fOK();
    this.Kzh = new HashMap();
    new MMHandler("OpenCanvasMgr").postDelayed(new Runnable()
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
  
  private String QW(long paramLong)
  {
    AppMethodBeat.i(97402);
    if (this.axy.containsKey(Long.valueOf(paramLong)))
    {
      localObject = (String)this.axy.get(Long.valueOf(paramLong));
      AppMethodBeat.o(97402);
      return localObject;
    }
    Object localObject = new a();
    ((a)localObject).field_canvasId = paramLong;
    this.Kzf.get((IAutoDBItem)localObject, new String[0]);
    if (!TextUtils.isEmpty(((a)localObject).field_canvasXml))
    {
      this.axy.put(Long.valueOf(paramLong), ((a)localObject).field_canvasXml);
      localObject = ((a)localObject).field_canvasXml;
      AppMethodBeat.o(97402);
      return localObject;
    }
    AppMethodBeat.o(97402);
    return "";
  }
  
  private void ag(final long paramLong, int paramInt)
  {
    AppMethodBeat.i(97403);
    final a locala = new a();
    locala.field_canvasId = paramLong;
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new bpc();
    ((d.a)localObject).lBV = new bpd();
    ((d.a)localObject).uri = "/cgi-bin/mmoc-bin/adplayinfo/get_adcanvasinfo";
    ((d.a)localObject).funcId = 1286;
    localObject = ((d.a)localObject).bgN();
    ((bpc)d.b.b(((d)localObject).lBR)).jDF = paramLong;
    aa.a((d)localObject, new aa.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, d paramAnonymousd, q paramAnonymousq)
      {
        AppMethodBeat.i(97398);
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          Log.e("OpenCanvasMgr", "cgi fail page id %d,preLoad %d, errType %d,errCode %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(locala), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
          AppMethodBeat.o(97398);
          return 0;
        }
        paramAnonymousString = (bpd)d.c.b(paramAnonymousd.lBS);
        Log.i("OpenCanvasMgr", "getCanvasInfo pageid %d ,xml %s", new Object[] { Long.valueOf(paramLong), paramAnonymousString.TaQ });
        if (!TextUtils.isEmpty(paramAnonymousString.TaQ))
        {
          m.b(m.this).put(Long.valueOf(paramLong), paramAnonymousString.TaQ);
          this.Kzl.field_canvasXml = paramAnonymousString.TaQ;
          m.c(m.this).a(this.Kzl);
        }
        AppMethodBeat.o(97398);
        return 0;
      }
    });
    AppMethodBeat.o(97403);
  }
  
  private void ap(final String paramString1, String paramString2, final int paramInt)
  {
    AppMethodBeat.i(97407);
    final ab localab = new ab();
    localab.field_canvasId = paramString1;
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new byx();
    ((d.a)localObject).lBV = new byy();
    ((d.a)localObject).uri = "/cgi-bin/mmux-bin/wxaapp/mmuxwxa_getofficialcanvasinfo";
    ((d.a)localObject).funcId = 1890;
    localObject = ((d.a)localObject).bgN();
    byx localbyx = (byx)d.b.b(((d)localObject).lBR);
    localbyx.RHW = paramString1;
    localbyx.ThW = paramString2;
    aa.a((d)localObject, new aa.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, d paramAnonymousd, q paramAnonymousq)
      {
        AppMethodBeat.i(97399);
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          Log.e("OpenCanvasMgr", "cgi fail pageid %s,preLoad %d, errType %d,errCode %d", new Object[] { paramString1, Integer.valueOf(paramInt), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
          AppMethodBeat.o(97399);
          return 0;
        }
        paramAnonymousString = ((byy)d.c.b(paramAnonymousd.lBS)).ThX.Ap();
        Log.i("OpenCanvasMgr", "getCanvasInfo pageid %s ,xml %s", new Object[] { paramString1, paramAnonymousString });
        if (!TextUtils.isEmpty(paramAnonymousString))
        {
          m.d(m.this).put(paramString1, paramAnonymousString);
          localab.field_canvasXml = paramAnonymousString;
          m.e(m.this).a(localab);
        }
        AppMethodBeat.o(97399);
        return 0;
      }
    });
    AppMethodBeat.o(97407);
  }
  
  public static m fSv()
  {
    return Kze;
  }
  
  private String le(String paramString1, String paramString2)
  {
    AppMethodBeat.i(97406);
    if (!Util.isNullOrNil(paramString2)) {}
    for (String str = paramString1 + paramString2;; str = paramString1)
    {
      if (this.Kzh.containsKey(str))
      {
        paramString1 = (String)this.Kzh.get(str);
        AppMethodBeat.o(97406);
        return paramString1;
      }
      ab localab = new ab();
      localab.field_canvasId = paramString1;
      localab.field_canvasExt = paramString2;
      this.Kzg.get(localab, new String[] { "canvasId", "canvasExt" });
      if (!TextUtils.isEmpty(localab.field_canvasXml))
      {
        this.Kzh.put(str, localab.field_canvasXml);
        paramString1 = localab.field_canvasXml;
        AppMethodBeat.o(97406);
        return paramString1;
      }
      AppMethodBeat.o(97406);
      return "";
    }
  }
  
  public final void R(long paramLong, String paramString)
  {
    AppMethodBeat.i(97404);
    if ((!TextUtils.isEmpty(paramString)) && (paramLong > 0L))
    {
      this.axy.put(Long.valueOf(paramLong), paramString);
      a locala = new a();
      locala.field_canvasId = paramLong;
      locala.field_canvasXml = paramString;
      this.Kzf.a(locala);
    }
    AppMethodBeat.o(97404);
  }
  
  public final String n(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(97405);
    Log.i("OpenCanvasMgr", "open pageId %s, canvasExt %s, preLoad %d", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1) });
    if (Util.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(97405);
      return "";
    }
    String str = "";
    if (paramInt2 != 1) {
      str = le(paramString1, paramString2);
    }
    if (paramInt1 != 1)
    {
      AppMethodBeat.o(97405);
      return str;
    }
    if (TextUtils.isEmpty(str))
    {
      ap(paramString1, paramString2, paramInt1);
      AppMethodBeat.o(97405);
      return "";
    }
    AppMethodBeat.o(97405);
    return str;
  }
  
  public final String q(long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(97401);
    Log.i("OpenCanvasMgr", "open pageId %d, preLoad %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1) });
    if (paramLong <= 0L)
    {
      AppMethodBeat.o(97401);
      return "";
    }
    String str = "";
    if (paramInt2 != 1) {
      str = QW(paramLong);
    }
    if (paramInt1 != 1)
    {
      AppMethodBeat.o(97401);
      return str;
    }
    if (TextUtils.isEmpty(str))
    {
      ag(paramLong, paramInt1);
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