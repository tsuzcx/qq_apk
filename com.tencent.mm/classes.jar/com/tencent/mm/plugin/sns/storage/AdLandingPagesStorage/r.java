package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.z;
import com.tencent.mm.am.z.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.sns.storage.am;
import com.tencent.mm.plugin.sns.storage.d;
import com.tencent.mm.protocal.protobuf.cdt;
import com.tencent.mm.protocal.protobuf.cdu;
import com.tencent.mm.protocal.protobuf.coa;
import com.tencent.mm.protocal.protobuf.cob;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.HashMap;
import java.util.Map;

public final class r
{
  private static final r QXW;
  private d QXX;
  public am QXY;
  public Map<String, String> QXZ;
  private Map<Long, String> ctm;
  
  static
  {
    AppMethodBeat.i(97409);
    QXW = new r();
    AppMethodBeat.o(97409);
  }
  
  private r()
  {
    AppMethodBeat.i(97400);
    this.QXX = com.tencent.mm.plugin.sns.model.al.hgC();
    this.ctm = new HashMap();
    this.QXY = com.tencent.mm.plugin.sns.model.al.hgD();
    this.QXZ = new HashMap();
    new MMHandler("OpenCanvasMgr").postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(97397);
        r.a(r.this);
        AppMethodBeat.o(97397);
      }
    }, 5000L);
    AppMethodBeat.o(97400);
  }
  
  private void aA(final String paramString1, String paramString2, final int paramInt)
  {
    AppMethodBeat.i(97407);
    final com.tencent.mm.plugin.sns.storage.al localal = new com.tencent.mm.plugin.sns.storage.al();
    localal.field_canvasId = paramString1;
    Object localObject = new c.a();
    ((c.a)localObject).otE = new coa();
    ((c.a)localObject).otF = new cob();
    ((c.a)localObject).uri = "/cgi-bin/mmux-bin/wxaapp/mmuxwxa_getofficialcanvasinfo";
    ((c.a)localObject).funcId = 1890;
    localObject = ((c.a)localObject).bEF();
    coa localcoa = (coa)c.b.b(((com.tencent.mm.am.c)localObject).otB);
    localcoa.YEY = paramString1;
    localcoa.aavm = paramString2;
    z.a((com.tencent.mm.am.c)localObject, new z.a()
    {
      public final int callback(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.am.c paramAnonymousc, p paramAnonymousp)
      {
        AppMethodBeat.i(97399);
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          Log.e("OpenCanvasMgr", "cgi fail pageid %s,preLoad %d, errType %d,errCode %d", new Object[] { paramString1, Integer.valueOf(paramInt), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
          AppMethodBeat.o(97399);
          return 0;
        }
        paramAnonymousString = ((cob)c.c.b(paramAnonymousc.otC)).aavn.ZV();
        Log.i("OpenCanvasMgr", "getCanvasInfo pageid %s ,xml %s", new Object[] { paramString1, paramAnonymousString });
        if (!TextUtils.isEmpty(paramAnonymousString))
        {
          r.d(r.this).put(paramString1, paramAnonymousString);
          localal.field_canvasXml = paramAnonymousString;
          r.e(r.this).a(localal);
        }
        AppMethodBeat.o(97399);
        return 0;
      }
    });
    AppMethodBeat.o(97407);
  }
  
  private void ay(final long paramLong, int paramInt)
  {
    AppMethodBeat.i(97403);
    final com.tencent.mm.plugin.sns.storage.c localc = new com.tencent.mm.plugin.sns.storage.c();
    localc.field_canvasId = paramLong;
    Object localObject = new c.a();
    ((c.a)localObject).otE = new cdt();
    ((c.a)localObject).otF = new cdu();
    ((c.a)localObject).uri = "/cgi-bin/mmoc-bin/adplayinfo/get_adcanvasinfo";
    ((c.a)localObject).funcId = 1286;
    localObject = ((c.a)localObject).bEF();
    ((cdt)c.b.b(((com.tencent.mm.am.c)localObject).otB)).mdA = paramLong;
    z.a((com.tencent.mm.am.c)localObject, new z.a()
    {
      public final int callback(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.am.c paramAnonymousc, p paramAnonymousp)
      {
        AppMethodBeat.i(97398);
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          Log.e("OpenCanvasMgr", "cgi fail page id %d,preLoad %d, errType %d,errCode %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(localc), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
          AppMethodBeat.o(97398);
          return 0;
        }
        paramAnonymousString = (cdu)c.c.b(paramAnonymousc.otC);
        Log.i("OpenCanvasMgr", "getCanvasInfo pageid %d ,xml %s", new Object[] { Long.valueOf(paramLong), paramAnonymousString.aaoc });
        if (!TextUtils.isEmpty(paramAnonymousString.aaoc))
        {
          r.b(r.this).put(Long.valueOf(paramLong), paramAnonymousString.aaoc);
          this.QYd.field_canvasXml = paramAnonymousString.aaoc;
          r.c(r.this).a(this.QYd);
          paramAnonymousString = paramAnonymousString.aaoc;
          if (!Util.isNullOrNil(paramAnonymousString)) {
            h.ahAA.bm(new m.5(paramAnonymousString));
          }
        }
        AppMethodBeat.o(97398);
        return 0;
      }
    });
    AppMethodBeat.o(97403);
  }
  
  public static r hkH()
  {
    return QXW;
  }
  
  private String mN(String paramString1, String paramString2)
  {
    AppMethodBeat.i(97406);
    if (!Util.isNullOrNil(paramString2)) {}
    for (String str = paramString1 + paramString2;; str = paramString1)
    {
      if (this.QXZ.containsKey(str))
      {
        paramString1 = (String)this.QXZ.get(str);
        AppMethodBeat.o(97406);
        return paramString1;
      }
      com.tencent.mm.plugin.sns.storage.al localal = new com.tencent.mm.plugin.sns.storage.al();
      localal.field_canvasId = paramString1;
      localal.field_canvasExt = paramString2;
      this.QXY.get(localal, new String[] { "canvasId", "canvasExt" });
      if (!TextUtils.isEmpty(localal.field_canvasXml))
      {
        this.QXZ.put(str, localal.field_canvasXml);
        paramString1 = localal.field_canvasXml;
        AppMethodBeat.o(97406);
        return paramString1;
      }
      AppMethodBeat.o(97406);
      return "";
    }
  }
  
  private String vc(long paramLong)
  {
    AppMethodBeat.i(97402);
    if (this.ctm.containsKey(Long.valueOf(paramLong)))
    {
      localObject = (String)this.ctm.get(Long.valueOf(paramLong));
      AppMethodBeat.o(97402);
      return localObject;
    }
    Object localObject = new com.tencent.mm.plugin.sns.storage.c();
    ((com.tencent.mm.plugin.sns.storage.c)localObject).field_canvasId = paramLong;
    this.QXX.get((IAutoDBItem)localObject, new String[0]);
    if (!TextUtils.isEmpty(((com.tencent.mm.plugin.sns.storage.c)localObject).field_canvasXml))
    {
      this.ctm.put(Long.valueOf(paramLong), ((com.tencent.mm.plugin.sns.storage.c)localObject).field_canvasXml);
      localObject = ((com.tencent.mm.plugin.sns.storage.c)localObject).field_canvasXml;
      AppMethodBeat.o(97402);
      return localObject;
    }
    AppMethodBeat.o(97402);
    return "";
  }
  
  public final void ag(long paramLong, String paramString)
  {
    AppMethodBeat.i(97404);
    if ((!TextUtils.isEmpty(paramString)) && (paramLong > 0L))
    {
      this.ctm.put(Long.valueOf(paramLong), paramString);
      com.tencent.mm.plugin.sns.storage.c localc = new com.tencent.mm.plugin.sns.storage.c();
      localc.field_canvasId = paramLong;
      localc.field_canvasXml = paramString;
      this.QXX.a(localc);
    }
    AppMethodBeat.o(97404);
  }
  
  public final String r(String paramString1, String paramString2, int paramInt1, int paramInt2)
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
      str = mN(paramString1, paramString2);
    }
    if (paramInt1 != 1)
    {
      AppMethodBeat.o(97405);
      return str;
    }
    if (TextUtils.isEmpty(str))
    {
      aA(paramString1, paramString2, paramInt1);
      AppMethodBeat.o(97405);
      return "";
    }
    AppMethodBeat.o(97405);
    return str;
  }
  
  public final String y(long paramLong, int paramInt1, int paramInt2)
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
      str = vc(paramLong);
    }
    if (paramInt1 != 1)
    {
      AppMethodBeat.o(97401);
      return str;
    }
    if (TextUtils.isEmpty(str))
    {
      ay(paramLong, paramInt1);
      AppMethodBeat.o(97401);
      return "";
    }
    AppMethodBeat.o(97401);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.r
 * JD-Core Version:    0.7.0.1
 */