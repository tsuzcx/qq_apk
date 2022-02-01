package com.tencent.mm.plugin.report.b;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.preference.PreferenceManager;
import com.tencent.b.a.a.f;
import com.tencent.b.a.a.i;
import com.tencent.b.a.a.i.1;
import com.tencent.b.a.a.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.n;
import com.tencent.mm.al.x;
import com.tencent.mm.al.x.a;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.cfb;
import com.tencent.mm.protocal.protobuf.cfc;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;

public final class d
{
  private static i vJl;
  private static int vJm;
  
  static
  {
    AppMethodBeat.i(134233);
    vJl = i.aU(aj.getContext());
    vJm = 2;
    AppMethodBeat.o(134233);
  }
  
  public static int F(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(134232);
    if (!g.afw())
    {
      ad.i("MicroMsg.MidHelper", "checkReportMid acc not ready");
      AppMethodBeat.o(134232);
      return -1;
    }
    long l = bt.aGK();
    if ((paramInt1 == 3) && (bt.a((Long)g.afB().afk().get(331778, null), 0L) >= l))
    {
      AppMethodBeat.o(134232);
      return 0;
    }
    int i;
    if (ay.is2G(aj.getContext())) {
      i = 1;
    }
    for (;;)
    {
      String str = dkG();
      ad.i("MicroMsg.MidHelper", "querymid checkReportMid moment:%d mid[%s]", new Object[] { Integer.valueOf(paramInt1), str });
      com.tencent.mm.plugin.report.e.vIY.f(11402, new Object[] { str, Integer.valueOf(paramInt1), Integer.valueOf(i), q.Xa(), Integer.valueOf(paramInt2), paramString, ay.getISPName(aj.getContext()), Integer.valueOf(0), q.cG(false) });
      g.afB().afk().set(331778, Long.valueOf(259200L + l));
      AppMethodBeat.o(134232);
      return 0;
      if (ay.isWifi(aj.getContext())) {
        i = 3;
      } else if (ay.is3G(aj.getContext())) {
        i = 2;
      } else {
        i = 0;
      }
    }
  }
  
  public static void amu(String paramString)
  {
    AppMethodBeat.i(134231);
    try
    {
      i locali = vJl;
      if (i.mContext != null)
      {
        i.cGs = System.currentTimeMillis();
        com.tencent.b.a.a.n.cGD = -1L;
      }
      try
      {
        SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(i.mContext).edit();
        localEditor.putLong("__MID_LAST_CHECK_TIME__", i.cGs);
        localEditor.commit();
        if (i.mHandler != null) {
          i.mHandler.post(new i.1(locali, paramString));
        }
        ad.i("MicroMsg.MidHelper", "QueryMid local:%s", new Object[] { vJl.Iw() });
        AppMethodBeat.o(134231);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          s.ID();
        }
      }
      return;
    }
    catch (Exception paramString)
    {
      ad.e("MicroMsg.MidHelper", "procReturnData Error e:%s", new Object[] { bt.m(paramString) });
      AppMethodBeat.o(134231);
    }
  }
  
  public static String dkG()
  {
    AppMethodBeat.i(134230);
    try
    {
      i.a(new f()
      {
        public final void dx(String paramAnonymousString)
        {
          AppMethodBeat.i(134229);
          ad.i("MicroMsg.MidHelper", "QueryMid onDispatch2WXServer req:%s limit:%d", new Object[] { paramAnonymousString, Integer.valueOf(d.vJm) });
          if (d.Oz() <= 0)
          {
            ad.e("MicroMsg.MidHelper", "THE FUCKING querymid do too much! :%d", new Object[] { Integer.valueOf(d.vJm) });
            AppMethodBeat.o(134229);
            return;
          }
          Object localObject = new b.a();
          ((b.a)localObject).gUU = new cfb();
          ((b.a)localObject).gUV = new cfc();
          ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/querymid";
          ((b.a)localObject).funcId = 684;
          localObject = ((b.a)localObject).atI();
          ((cfb)((b)localObject).gUS.gUX).pRp = paramAnonymousString;
          ((cfb)((b)localObject).gUS.gUX).fVE = 1;
          x.a((b)localObject, new x.a()
          {
            public final int a(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, b paramAnonymous2b, n paramAnonymous2n)
            {
              AppMethodBeat.i(134228);
              ad.i("MicroMsg.MidHelper", "onGYNetEnd errType:%d errCode:%d msg:%s", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), paramAnonymous2String });
              AppMethodBeat.o(134228);
              return 0;
            }
          }, true);
          AppMethodBeat.o(134229);
        }
      });
      String str = vJl.Iv();
      ad.i("MicroMsg.MidHelper", "QueryMid try Get Now getMid:%s getLocalMid:%s", new Object[] { str, vJl.Iw() });
      AppMethodBeat.o(134230);
      return str;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.MidHelper", "QueryMid Error e:%s", new Object[] { bt.m(localException) });
      AppMethodBeat.o(134230);
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.report.b.d
 * JD-Core Version:    0.7.0.1
 */