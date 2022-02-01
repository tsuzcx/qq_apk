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
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.x;
import com.tencent.mm.ak.x.a;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.cpy;
import com.tencent.mm.protocal.protobuf.cpz;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;

public final class d
{
  private static i ywQ;
  private static int ywR;
  
  static
  {
    AppMethodBeat.i(134233);
    ywQ = i.aW(ak.getContext());
    ywR = 2;
    AppMethodBeat.o(134233);
  }
  
  public static int F(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(134232);
    if (!g.ajM())
    {
      ae.i("MicroMsg.MidHelper", "checkReportMid acc not ready");
      AppMethodBeat.o(134232);
      return -1;
    }
    long l = bu.aRi();
    if ((paramInt1 == 3) && (bu.a((Long)g.ajR().ajA().get(331778, null), 0L) >= l))
    {
      AppMethodBeat.o(134232);
      return 0;
    }
    int i;
    if (az.is2G(ak.getContext())) {
      i = 1;
    }
    for (;;)
    {
      String str = dNz();
      ae.i("MicroMsg.MidHelper", "querymid checkReportMid moment:%d mid[%s]", new Object[] { Integer.valueOf(paramInt1), str });
      com.tencent.mm.plugin.report.e.ywz.f(11402, new Object[] { str, Integer.valueOf(paramInt1), Integer.valueOf(i), q.aaH(), Integer.valueOf(paramInt2), paramString, az.getISPName(ak.getContext()), Integer.valueOf(0), q.cH(false) });
      g.ajR().ajA().set(331778, Long.valueOf(259200L + l));
      AppMethodBeat.o(134232);
      return 0;
      if (az.isWifi(ak.getContext())) {
        i = 3;
      } else if (az.is3G(ak.getContext())) {
        i = 2;
      } else {
        i = 0;
      }
    }
  }
  
  public static void axQ(String paramString)
  {
    AppMethodBeat.i(134231);
    try
    {
      i locali = ywQ;
      if (i.mContext != null)
      {
        i.cPp = System.currentTimeMillis();
        com.tencent.b.a.a.n.cPA = -1L;
      }
      try
      {
        SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(i.mContext).edit();
        localEditor.putLong("__MID_LAST_CHECK_TIME__", i.cPp);
        localEditor.commit();
        if (i.mHandler != null) {
          i.mHandler.post(new i.1(locali, paramString));
        }
        ae.i("MicroMsg.MidHelper", "QueryMid local:%s", new Object[] { ywQ.JN() });
        AppMethodBeat.o(134231);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          s.JU();
        }
      }
      return;
    }
    catch (Exception paramString)
    {
      ae.e("MicroMsg.MidHelper", "procReturnData Error e:%s", new Object[] { bu.o(paramString) });
      AppMethodBeat.o(134231);
    }
  }
  
  public static String dNz()
  {
    AppMethodBeat.i(134230);
    try
    {
      i.a(new f()
      {
        public final void en(String paramAnonymousString)
        {
          AppMethodBeat.i(134229);
          ae.i("MicroMsg.MidHelper", "QueryMid onDispatch2WXServer req:%s limit:%d", new Object[] { paramAnonymousString, Integer.valueOf(d.ywR) });
          if (d.bKJ() <= 0)
          {
            ae.e("MicroMsg.MidHelper", "THE FUCKING querymid do too much! :%d", new Object[] { Integer.valueOf(d.ywR) });
            AppMethodBeat.o(134229);
            return;
          }
          Object localObject = new b.a();
          ((b.a)localObject).hQF = new cpy();
          ((b.a)localObject).hQG = new cpz();
          ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/querymid";
          ((b.a)localObject).funcId = 684;
          localObject = ((b.a)localObject).aDS();
          ((cpy)((b)localObject).hQD.hQJ).rrQ = paramAnonymousString;
          ((cpy)((b)localObject).hQD.hQJ).gvx = 1;
          x.a((b)localObject, new x.a()
          {
            public final int a(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, b paramAnonymous2b, n paramAnonymous2n)
            {
              AppMethodBeat.i(134228);
              ae.i("MicroMsg.MidHelper", "onGYNetEnd errType:%d errCode:%d msg:%s", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), paramAnonymous2String });
              AppMethodBeat.o(134228);
              return 0;
            }
          }, true);
          AppMethodBeat.o(134229);
        }
      });
      String str = ywQ.JM();
      ae.i("MicroMsg.MidHelper", "QueryMid try Get Now getMid:%s getLocalMid:%s", new Object[] { str, ywQ.JN() });
      AppMethodBeat.o(134230);
      return str;
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.MidHelper", "QueryMid Error e:%s", new Object[] { bu.o(localException) });
      AppMethodBeat.o(134230);
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.report.b.d
 * JD-Core Version:    0.7.0.1
 */