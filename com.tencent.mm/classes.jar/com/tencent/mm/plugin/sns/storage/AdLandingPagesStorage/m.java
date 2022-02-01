package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.x;
import com.tencent.mm.ak.x.a;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.storage.aa;
import com.tencent.mm.plugin.sns.storage.ab;
import com.tencent.mm.plugin.sns.storage.d;
import com.tencent.mm.protocal.protobuf.awh;
import com.tencent.mm.protocal.protobuf.awi;
import com.tencent.mm.protocal.protobuf.bff;
import com.tencent.mm.protocal.protobuf.bfg;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.HashMap;
import java.util.Map;

public final class m
{
  private static final m Adz;
  private d AdA;
  public ab AdB;
  public Map<String, String> AdC;
  private Map<Long, String> aOa;
  
  static
  {
    AppMethodBeat.i(97409);
    Adz = new m();
    AppMethodBeat.o(97409);
  }
  
  private m()
  {
    AppMethodBeat.i(97400);
    this.AdA = ah.dXF();
    this.aOa = new HashMap();
    this.AdB = ah.dXG();
    this.AdC = new HashMap();
    new aq("OpenCanvasMgr").postDelayed(new Runnable()
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
  
  private String Aw(long paramLong)
  {
    AppMethodBeat.i(97402);
    if (this.aOa.containsKey(Long.valueOf(paramLong)))
    {
      localObject = (String)this.aOa.get(Long.valueOf(paramLong));
      AppMethodBeat.o(97402);
      return localObject;
    }
    Object localObject = new com.tencent.mm.plugin.sns.storage.c();
    ((com.tencent.mm.plugin.sns.storage.c)localObject).field_canvasId = paramLong;
    this.AdA.get((com.tencent.mm.sdk.e.c)localObject, new String[0]);
    if (!TextUtils.isEmpty(((com.tencent.mm.plugin.sns.storage.c)localObject).field_canvasXml))
    {
      this.aOa.put(Long.valueOf(paramLong), ((com.tencent.mm.plugin.sns.storage.c)localObject).field_canvasXml);
      localObject = ((com.tencent.mm.plugin.sns.storage.c)localObject).field_canvasXml;
      AppMethodBeat.o(97402);
      return localObject;
    }
    AppMethodBeat.o(97402);
    return "";
  }
  
  private void W(final long paramLong, int paramInt)
  {
    AppMethodBeat.i(97403);
    final com.tencent.mm.plugin.sns.storage.c localc = new com.tencent.mm.plugin.sns.storage.c();
    localc.field_canvasId = paramLong;
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new awh();
    ((b.a)localObject).hQG = new awi();
    ((b.a)localObject).uri = "/cgi-bin/mmoc-bin/adplayinfo/get_adcanvasinfo";
    ((b.a)localObject).funcId = 1286;
    localObject = ((b.a)localObject).aDS();
    ((awh)((com.tencent.mm.ak.b)localObject).hQD.hQJ).GNZ = paramLong;
    x.a((com.tencent.mm.ak.b)localObject, new x.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.b paramAnonymousb, n paramAnonymousn)
      {
        AppMethodBeat.i(97398);
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          ae.e("OpenCanvasMgr", "cgi fail page id %d,preLoad %d, errType %d,errCode %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(localc), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
          AppMethodBeat.o(97398);
          return 0;
        }
        paramAnonymousString = (awi)paramAnonymousb.hQE.hQJ;
        ae.i("OpenCanvasMgr", "getCanvasInfo pageid %d ,xml %s", new Object[] { Long.valueOf(paramLong), paramAnonymousString.GOa });
        if (!TextUtils.isEmpty(paramAnonymousString.GOa))
        {
          m.b(m.this).put(Long.valueOf(paramLong), paramAnonymousString.GOa);
          this.AdG.field_canvasXml = paramAnonymousString.GOa;
          m.c(m.this).a(this.AdG);
        }
        AppMethodBeat.o(97398);
        return 0;
      }
    });
    AppMethodBeat.o(97403);
  }
  
  private void ae(final String paramString1, String paramString2, final int paramInt)
  {
    AppMethodBeat.i(97407);
    final aa localaa = new aa();
    localaa.field_canvasId = paramString1;
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new bff();
    ((b.a)localObject).hQG = new bfg();
    ((b.a)localObject).uri = "/cgi-bin/mmux-bin/wxaapp/mmuxwxa_getofficialcanvasinfo";
    ((b.a)localObject).funcId = 1890;
    localObject = ((b.a)localObject).aDS();
    bff localbff = (bff)((com.tencent.mm.ak.b)localObject).hQD.hQJ;
    localbff.GUj = paramString1;
    localbff.GUk = paramString2;
    x.a((com.tencent.mm.ak.b)localObject, new x.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.b paramAnonymousb, n paramAnonymousn)
      {
        AppMethodBeat.i(97399);
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          ae.e("OpenCanvasMgr", "cgi fail pageid %s,preLoad %d, errType %d,errCode %d", new Object[] { paramString1, Integer.valueOf(paramInt), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
          AppMethodBeat.o(97399);
          return 0;
        }
        paramAnonymousString = ((bfg)paramAnonymousb.hQE.hQJ).GUl.fjO();
        ae.i("OpenCanvasMgr", "getCanvasInfo pageid %s ,xml %s", new Object[] { paramString1, paramAnonymousString });
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
  
  public static m ebK()
  {
    return Adz;
  }
  
  private String jU(String paramString1, String paramString2)
  {
    AppMethodBeat.i(97406);
    if (!bu.isNullOrNil(paramString2)) {}
    for (String str = paramString1 + paramString2;; str = paramString1)
    {
      if (this.AdC.containsKey(str))
      {
        paramString1 = (String)this.AdC.get(str);
        AppMethodBeat.o(97406);
        return paramString1;
      }
      aa localaa = new aa();
      localaa.field_canvasId = paramString1;
      localaa.field_canvasExt = paramString2;
      this.AdB.get(localaa, new String[] { "canvasId", "canvasExt" });
      if (!TextUtils.isEmpty(localaa.field_canvasXml))
      {
        this.AdC.put(str, localaa.field_canvasXml);
        paramString1 = localaa.field_canvasXml;
        AppMethodBeat.o(97406);
        return paramString1;
      }
      AppMethodBeat.o(97406);
      return "";
    }
  }
  
  public final void D(long paramLong, String paramString)
  {
    AppMethodBeat.i(97404);
    if ((!TextUtils.isEmpty(paramString)) && (paramLong > 0L))
    {
      this.aOa.put(Long.valueOf(paramLong), paramString);
      com.tencent.mm.plugin.sns.storage.c localc = new com.tencent.mm.plugin.sns.storage.c();
      localc.field_canvasId = paramLong;
      localc.field_canvasXml = paramString;
      this.AdA.a(localc);
    }
    AppMethodBeat.o(97404);
  }
  
  public final String n(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(97405);
    ae.i("OpenCanvasMgr", "open pageId %s, canvasExt %s, preLoad %d", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1) });
    if (bu.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(97405);
      return "";
    }
    String str = "";
    if (paramInt2 != 1) {
      str = jU(paramString1, paramString2);
    }
    if (paramInt1 != 1)
    {
      AppMethodBeat.o(97405);
      return str;
    }
    if (TextUtils.isEmpty(str))
    {
      ae(paramString1, paramString2, paramInt1);
      AppMethodBeat.o(97405);
      return "";
    }
    AppMethodBeat.o(97405);
    return str;
  }
  
  public final String q(long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(97401);
    ae.i("OpenCanvasMgr", "open pageId %d, preLoad %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1) });
    if (paramLong <= 0L)
    {
      AppMethodBeat.o(97401);
      return "";
    }
    String str = "";
    if (paramInt2 != 1) {
      str = Aw(paramLong);
    }
    if (paramInt1 != 1)
    {
      AppMethodBeat.o(97401);
      return str;
    }
    if (TextUtils.isEmpty(str))
    {
      W(paramLong, paramInt1);
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