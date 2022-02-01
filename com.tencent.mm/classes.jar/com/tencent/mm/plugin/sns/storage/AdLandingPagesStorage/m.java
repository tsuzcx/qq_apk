package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.aa.a;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.a;
import com.tencent.mm.plugin.sns.storage.ab;
import com.tencent.mm.plugin.sns.storage.ac;
import com.tencent.mm.protocal.protobuf.bhr;
import com.tencent.mm.protocal.protobuf.bhs;
import com.tencent.mm.protocal.protobuf.brb;
import com.tencent.mm.protocal.protobuf.brc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.util.HashMap;
import java.util.Map;

public final class m
{
  private static final m ElW;
  private com.tencent.mm.plugin.sns.storage.b ElX;
  public ac ElY;
  public Map<String, String> ElZ;
  private Map<Long, String> aNT;
  
  static
  {
    AppMethodBeat.i(97409);
    ElW = new m();
    AppMethodBeat.o(97409);
  }
  
  private m()
  {
    AppMethodBeat.i(97400);
    this.ElX = aj.faP();
    this.aNT = new HashMap();
    this.ElY = aj.faQ();
    this.ElZ = new HashMap();
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
  
  private String JD(long paramLong)
  {
    AppMethodBeat.i(97402);
    if (this.aNT.containsKey(Long.valueOf(paramLong)))
    {
      localObject = (String)this.aNT.get(Long.valueOf(paramLong));
      AppMethodBeat.o(97402);
      return localObject;
    }
    Object localObject = new a();
    ((a)localObject).field_canvasId = paramLong;
    this.ElX.get((IAutoDBItem)localObject, new String[0]);
    if (!TextUtils.isEmpty(((a)localObject).field_canvasXml))
    {
      this.aNT.put(Long.valueOf(paramLong), ((a)localObject).field_canvasXml);
      localObject = ((a)localObject).field_canvasXml;
      AppMethodBeat.o(97402);
      return localObject;
    }
    AppMethodBeat.o(97402);
    return "";
  }
  
  private void X(final long paramLong, int paramInt)
  {
    AppMethodBeat.i(97403);
    final a locala = new a();
    locala.field_canvasId = paramLong;
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new bhr();
    ((d.a)localObject).iLO = new bhs();
    ((d.a)localObject).uri = "/cgi-bin/mmoc-bin/adplayinfo/get_adcanvasinfo";
    ((d.a)localObject).funcId = 1286;
    localObject = ((d.a)localObject).aXF();
    ((bhr)((d)localObject).iLK.iLR).gTg = paramLong;
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
        paramAnonymousString = (bhs)paramAnonymousd.iLL.iLR;
        Log.i("OpenCanvasMgr", "getCanvasInfo pageid %d ,xml %s", new Object[] { Long.valueOf(paramLong), paramAnonymousString.LSf });
        if (!TextUtils.isEmpty(paramAnonymousString.LSf))
        {
          m.b(m.this).put(Long.valueOf(paramLong), paramAnonymousString.LSf);
          this.Emd.field_canvasXml = paramAnonymousString.LSf;
          m.c(m.this).a(this.Emd);
        }
        AppMethodBeat.o(97398);
        return 0;
      }
    });
    AppMethodBeat.o(97403);
  }
  
  private void ai(final String paramString1, String paramString2, final int paramInt)
  {
    AppMethodBeat.i(97407);
    final ab localab = new ab();
    localab.field_canvasId = paramString1;
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new brb();
    ((d.a)localObject).iLO = new brc();
    ((d.a)localObject).uri = "/cgi-bin/mmux-bin/wxaapp/mmuxwxa_getofficialcanvasinfo";
    ((d.a)localObject).funcId = 1890;
    localObject = ((d.a)localObject).aXF();
    brb localbrb = (brb)((d)localObject).iLK.iLR;
    localbrb.LYB = paramString1;
    localbrb.LYC = paramString2;
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
        paramAnonymousString = ((brc)paramAnonymousd.iLL.iLR).LYD.yO();
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
  
  public static m feB()
  {
    return ElW;
  }
  
  private String kI(String paramString1, String paramString2)
  {
    AppMethodBeat.i(97406);
    if (!Util.isNullOrNil(paramString2)) {}
    for (String str = paramString1 + paramString2;; str = paramString1)
    {
      if (this.ElZ.containsKey(str))
      {
        paramString1 = (String)this.ElZ.get(str);
        AppMethodBeat.o(97406);
        return paramString1;
      }
      ab localab = new ab();
      localab.field_canvasId = paramString1;
      localab.field_canvasExt = paramString2;
      this.ElY.get(localab, new String[] { "canvasId", "canvasExt" });
      if (!TextUtils.isEmpty(localab.field_canvasXml))
      {
        this.ElZ.put(str, localab.field_canvasXml);
        paramString1 = localab.field_canvasXml;
        AppMethodBeat.o(97406);
        return paramString1;
      }
      AppMethodBeat.o(97406);
      return "";
    }
  }
  
  public final void J(long paramLong, String paramString)
  {
    AppMethodBeat.i(97404);
    if ((!TextUtils.isEmpty(paramString)) && (paramLong > 0L))
    {
      this.aNT.put(Long.valueOf(paramLong), paramString);
      a locala = new a();
      locala.field_canvasId = paramLong;
      locala.field_canvasXml = paramString;
      this.ElX.a(locala);
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
      str = kI(paramString1, paramString2);
    }
    if (paramInt1 != 1)
    {
      AppMethodBeat.o(97405);
      return str;
    }
    if (TextUtils.isEmpty(str))
    {
      ai(paramString1, paramString2, paramInt1);
      AppMethodBeat.o(97405);
      return "";
    }
    AppMethodBeat.o(97405);
    return str;
  }
  
  public final String p(long paramLong, int paramInt1, int paramInt2)
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
      str = JD(paramLong);
    }
    if (paramInt1 != 1)
    {
      AppMethodBeat.o(97401);
      return str;
    }
    if (TextUtils.isEmpty(str))
    {
      X(paramLong, paramInt1);
      AppMethodBeat.o(97401);
      return "";
    }
    AppMethodBeat.o(97401);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.m
 * JD-Core Version:    0.7.0.1
 */