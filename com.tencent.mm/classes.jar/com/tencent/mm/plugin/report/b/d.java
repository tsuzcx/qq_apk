package com.tencent.mm.plugin.report.b;

import com.tencent.c.a.a.i;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.w;
import com.tencent.mm.ah.w.a;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.c.bhw;
import com.tencent.mm.protocal.c.bhx;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;

public final class d
{
  private static i nET = i.an(ae.getContext());
  private static int nEU = 2;
  
  /* Error */
  public static void LU(String paramString)
  {
    // Byte code:
    //   0: getstatic 28	com/tencent/mm/plugin/report/b/d:nET	Lcom/tencent/c/a/a/i;
    //   3: astore_1
    //   4: getstatic 39	com/tencent/c/a/a/i:mContext	Landroid/content/Context;
    //   7: ifnull +68 -> 75
    //   10: invokestatic 45	java/lang/System:currentTimeMillis	()J
    //   13: putstatic 49	com/tencent/c/a/a/i:bty	J
    //   16: ldc2_w 50
    //   19: putstatic 56	com/tencent/c/a/a/n:btJ	J
    //   22: getstatic 39	com/tencent/c/a/a/i:mContext	Landroid/content/Context;
    //   25: invokestatic 62	android/preference/PreferenceManager:getDefaultSharedPreferences	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   28: invokeinterface 68 1 0
    //   33: astore_2
    //   34: aload_2
    //   35: ldc 70
    //   37: getstatic 49	com/tencent/c/a/a/i:bty	J
    //   40: invokeinterface 76 4 0
    //   45: pop
    //   46: aload_2
    //   47: invokeinterface 80 1 0
    //   52: pop
    //   53: getstatic 84	com/tencent/c/a/a/i:mHandler	Landroid/os/Handler;
    //   56: ifnull +19 -> 75
    //   59: getstatic 84	com/tencent/c/a/a/i:mHandler	Landroid/os/Handler;
    //   62: new 86	com/tencent/c/a/a/i$1
    //   65: dup
    //   66: aload_1
    //   67: aload_0
    //   68: invokespecial 90	com/tencent/c/a/a/i$1:<init>	(Lcom/tencent/c/a/a/i;Ljava/lang/String;)V
    //   71: invokevirtual 96	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   74: pop
    //   75: ldc 98
    //   77: ldc 100
    //   79: iconst_1
    //   80: anewarray 4	java/lang/Object
    //   83: dup
    //   84: iconst_0
    //   85: getstatic 28	com/tencent/mm/plugin/report/b/d:nET	Lcom/tencent/c/a/a/i;
    //   88: invokevirtual 104	com/tencent/c/a/a/i:rz	()Ljava/lang/String;
    //   91: aastore
    //   92: invokestatic 110	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   95: return
    //   96: astore_0
    //   97: ldc 98
    //   99: ldc 112
    //   101: iconst_1
    //   102: anewarray 4	java/lang/Object
    //   105: dup
    //   106: iconst_0
    //   107: aload_0
    //   108: invokestatic 118	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   111: aastore
    //   112: invokestatic 121	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   115: return
    //   116: astore_2
    //   117: goto -64 -> 53
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	120	0	paramString	String
    //   3	64	1	locali	i
    //   33	14	2	localEditor	android.content.SharedPreferences.Editor
    //   116	1	2	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   0	22	96	java/lang/Exception
    //   53	75	96	java/lang/Exception
    //   75	95	96	java/lang/Exception
    //   22	53	116	java/lang/Exception
  }
  
  public static String bwO()
  {
    try
    {
      i.a(new com.tencent.c.a.a.f()
      {
        public final void bD(String paramAnonymousString)
        {
          y.i("MicroMsg.MidHelper", "QueryMid onDispatch2WXServer req:%s limit:%d", new Object[] { paramAnonymousString, Integer.valueOf(d.nEU) });
          if (d.uD() <= 0)
          {
            y.e("MicroMsg.MidHelper", "THE FUCKING querymid do too much! :%d", new Object[] { Integer.valueOf(d.nEU) });
            return;
          }
          Object localObject = new b.a();
          ((b.a)localObject).ecH = new bhw();
          ((b.a)localObject).ecI = new bhx();
          ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/querymid";
          ((b.a)localObject).ecG = 684;
          localObject = ((b.a)localObject).Kt();
          ((bhw)((b)localObject).ecE.ecN).gyF = paramAnonymousString;
          ((bhw)((b)localObject).ecE.ecN).kTS = 1;
          w.a((b)localObject, new w.a()
          {
            public final int a(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, b paramAnonymous2b, m paramAnonymous2m)
            {
              y.i("MicroMsg.MidHelper", "onGYNetEnd errType:%d errCode:%d msg:%s", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), paramAnonymous2String });
              return 0;
            }
          }, true);
        }
      });
      String str = nET.ry();
      y.i("MicroMsg.MidHelper", "QueryMid try Get Now getMid:%s getLocalMid:%s", new Object[] { str, nET.rz() });
      return str;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.MidHelper", "QueryMid Error e:%s", new Object[] { bk.j(localException) });
    }
    return "";
  }
  
  public static int r(int paramInt1, int paramInt2, String paramString)
  {
    int i = 0;
    if (!g.DK())
    {
      y.i("MicroMsg.MidHelper", "checkReportMid acc not ready");
      i = -1;
    }
    long l;
    do
    {
      return i;
      l = bk.UX();
    } while ((paramInt1 == 3) && (bk.a((Long)g.DP().Dz().get(331778, null), 0L) >= l));
    if (aq.is2G(ae.getContext())) {
      i = 1;
    }
    for (;;)
    {
      String str = bwO();
      y.i("MicroMsg.MidHelper", "querymid checkReportMid moment:%d mid[%s]", new Object[] { Integer.valueOf(paramInt1), str });
      com.tencent.mm.plugin.report.f.nEG.f(11402, new Object[] { str, Integer.valueOf(paramInt1), Integer.valueOf(i), q.zg(), Integer.valueOf(paramInt2), paramString, aq.getISPName(ae.getContext()), Integer.valueOf(0), q.getDeviceID(ae.getContext()) });
      g.DP().Dz().o(331778, Long.valueOf(259200L + l));
      return 0;
      if (aq.isWifi(ae.getContext())) {
        i = 3;
      } else if (aq.is3G(ae.getContext())) {
        i = 2;
      } else {
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.report.b.d
 * JD-Core Version:    0.7.0.1
 */