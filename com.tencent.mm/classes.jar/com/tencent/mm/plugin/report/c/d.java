package com.tencent.mm.plugin.report.c;

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
import com.tencent.mm.protocal.protobuf.cke;
import com.tencent.mm.protocal.protobuf.ckf;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;

public final class d
{
  private static i wTp;
  private static int wTq;
  
  static
  {
    AppMethodBeat.i(134233);
    wTp = i.aV(ai.getContext());
    wTq = 2;
    AppMethodBeat.o(134233);
  }
  
  public static int E(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(134232);
    if (!g.agM())
    {
      ac.i("MicroMsg.MidHelper", "checkReportMid acc not ready");
      AppMethodBeat.o(134232);
      return -1;
    }
    long l = bs.aNx();
    if ((paramInt1 == 3) && (bs.a((Long)g.agR().agA().get(331778, null), 0L) >= l))
    {
      AppMethodBeat.o(134232);
      return 0;
    }
    int i;
    if (ax.is2G(ai.getContext())) {
      i = 1;
    }
    for (;;)
    {
      String str = dyJ();
      ac.i("MicroMsg.MidHelper", "querymid checkReportMid moment:%d mid[%s]", new Object[] { Integer.valueOf(paramInt1), str });
      com.tencent.mm.plugin.report.e.wTc.f(11402, new Object[] { str, Integer.valueOf(paramInt1), Integer.valueOf(i), q.XX(), Integer.valueOf(paramInt2), paramString, ax.getISPName(ai.getContext()), Integer.valueOf(0), q.cF(false) });
      g.agR().agA().set(331778, Long.valueOf(259200L + l));
      AppMethodBeat.o(134232);
      return 0;
      if (ax.isWifi(ai.getContext())) {
        i = 3;
      } else if (ax.is3G(ai.getContext())) {
        i = 2;
      } else {
        i = 0;
      }
    }
  }
  
  public static void arB(String paramString)
  {
    AppMethodBeat.i(134231);
    try
    {
      i locali = wTp;
      if (i.mContext != null)
      {
        i.cDA = System.currentTimeMillis();
        com.tencent.b.a.a.n.cDL = -1L;
      }
      try
      {
        SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(i.mContext).edit();
        localEditor.putLong("__MID_LAST_CHECK_TIME__", i.cDA);
        localEditor.commit();
        if (i.mHandler != null) {
          i.mHandler.post(new i.1(locali, paramString));
        }
        ac.i("MicroMsg.MidHelper", "QueryMid local:%s", new Object[] { wTp.If() });
        AppMethodBeat.o(134231);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          s.Im();
        }
      }
      return;
    }
    catch (Exception paramString)
    {
      ac.e("MicroMsg.MidHelper", "procReturnData Error e:%s", new Object[] { bs.m(paramString) });
      AppMethodBeat.o(134231);
    }
  }
  
  public static String dyJ()
  {
    AppMethodBeat.i(134230);
    try
    {
      i.a(new f()
      {
        public final void dm(String paramAnonymousString)
        {
          AppMethodBeat.i(134229);
          ac.i("MicroMsg.MidHelper", "QueryMid onDispatch2WXServer req:%s limit:%d", new Object[] { paramAnonymousString, Integer.valueOf(d.wTq) });
          if (d.Ov() <= 0)
          {
            ac.e("MicroMsg.MidHelper", "THE FUCKING querymid do too much! :%d", new Object[] { Integer.valueOf(d.wTq) });
            AppMethodBeat.o(134229);
            return;
          }
          Object localObject = new b.a();
          ((b.a)localObject).hvt = new cke();
          ((b.a)localObject).hvu = new ckf();
          ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/querymid";
          ((b.a)localObject).funcId = 684;
          localObject = ((b.a)localObject).aAz();
          ((cke)((b)localObject).hvr.hvw).qzX = paramAnonymousString;
          ((cke)((b)localObject).hvr.hvw).fZz = 1;
          x.a((b)localObject, new x.a()
          {
            public final int a(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, b paramAnonymous2b, n paramAnonymous2n)
            {
              AppMethodBeat.i(134228);
              ac.i("MicroMsg.MidHelper", "onGYNetEnd errType:%d errCode:%d msg:%s", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), paramAnonymous2String });
              AppMethodBeat.o(134228);
              return 0;
            }
          }, true);
          AppMethodBeat.o(134229);
        }
      });
      String str = wTp.Ie();
      ac.i("MicroMsg.MidHelper", "QueryMid try Get Now getMid:%s getLocalMid:%s", new Object[] { str, wTp.If() });
      AppMethodBeat.o(134230);
      return str;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.MidHelper", "QueryMid Error e:%s", new Object[] { bs.m(localException) });
      AppMethodBeat.o(134230);
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.report.c.d
 * JD-Core Version:    0.7.0.1
 */