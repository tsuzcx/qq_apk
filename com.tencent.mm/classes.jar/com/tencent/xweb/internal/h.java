package com.tencent.xweb.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.c;
import com.tencent.xweb.a;
import com.tencent.xweb.util.g;
import java.util.ArrayList;
import org.xwalk.core.NetworkUtil;
import org.xwalk.core.XWalkEnvironment;

public final class h
{
  static h MQL = null;
  int MQE;
  int MQF;
  long MQG;
  ArrayList<Long> MQH;
  WebView.c MQI;
  long MQJ;
  boolean MQK;
  
  private h(WebView.c paramc)
  {
    AppMethodBeat.i(156971);
    this.MQE = 0;
    this.MQF = 0;
    this.MQG = 0L;
    this.MQH = new ArrayList();
    this.MQJ = 0L;
    this.MQK = false;
    this.MQI = paramc;
    if ((this.MQI != WebView.c.MNA) && (("tools".equals(WebView.getCurStrModule())) || ("toolsmp".equals(WebView.getCurStrModule()))))
    {
      paramc = a.nb("enable_err_watchdog", "tools");
      boolean bool1 = bool2;
      if (paramc != null)
      {
        bool1 = bool2;
        if (paramc.trim().toLowerCase().equals("true")) {
          bool1 = true;
        }
      }
      this.MQK = bool1;
      this.MQJ = e(this.MQI).getLong("SP_KEY_NEED_SWITCH_TIME", 0L);
      if (Math.abs(System.currentTimeMillis() - this.MQJ) < 43200000L)
      {
        this.MQE = 3;
        AppMethodBeat.o(156971);
      }
    }
    else
    {
      this.MQK = false;
    }
    AppMethodBeat.o(156971);
  }
  
  public static void d(WebView.c paramc)
  {
    try
    {
      AppMethodBeat.i(156970);
      MQL = new h(paramc);
      AppMethodBeat.o(156970);
      return;
    }
    finally
    {
      paramc = finally;
      throw paramc;
    }
  }
  
  private static SharedPreferences e(WebView.c paramc)
  {
    try
    {
      AppMethodBeat.i(156980);
      paramc = XWalkEnvironment.getProcessSafePreferences(XWalkEnvironment.getProcessName() + "_LOAD_URL_" + paramc, 4);
      AppMethodBeat.o(156980);
      return paramc;
    }
    finally
    {
      paramc = finally;
      throw paramc;
    }
  }
  
  public static h ggn()
  {
    try
    {
      AppMethodBeat.i(156969);
      if (MQL == null)
      {
        localObject1 = WebView.getCurWebType();
        WebView.getCurStrModule();
        MQL = new h((WebView.c)localObject1);
      }
      Object localObject1 = MQL;
      AppMethodBeat.o(156969);
      return localObject1;
    }
    finally {}
  }
  
  private int ggp()
  {
    try
    {
      int i = this.MQE;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void ggi()
  {
    try
    {
      AppMethodBeat.i(156972);
      this.MQG = System.currentTimeMillis();
      AppMethodBeat.o(156972);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public final void ggj()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 160
    //   4: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 50	com/tencent/xweb/internal/h:MQK	Z
    //   11: ifne +11 -> 22
    //   14: ldc 160
    //   16: invokestatic 118	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: aload_0
    //   23: lconst_0
    //   24: putfield 41	com/tencent/xweb/internal/h:MQG	J
    //   27: aload_0
    //   28: getfield 46	com/tencent/xweb/internal/h:MQH	Ljava/util/ArrayList;
    //   31: invokevirtual 163	java/util/ArrayList:clear	()V
    //   34: aload_0
    //   35: lconst_0
    //   36: putfield 48	com/tencent/xweb/internal/h:MQJ	J
    //   39: aload_0
    //   40: iconst_0
    //   41: putfield 37	com/tencent/xweb/internal/h:MQE	I
    //   44: ldc 160
    //   46: invokestatic 118	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   49: goto -30 -> 19
    //   52: astore_1
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_1
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	this	h
    //   52	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	52	finally
    //   22	49	52	finally
  }
  
  public final void ggo()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(156973);
        if (!this.MQK)
        {
          AppMethodBeat.o(156973);
          return;
        }
        if (NetworkUtil.isNetworkAvailable()) {
          this.MQH.add(Long.valueOf(System.currentTimeMillis()));
        }
        if (this.MQH.size() < 3) {
          break label141;
        }
        long l = ((Long)this.MQH.get(this.MQH.size() - 3)).longValue();
        if (Math.abs(System.currentTimeMillis() - l) >= 120000L) {
          break label141;
        }
        this.MQE = 1;
        if (this.MQI == WebView.c.MNy)
        {
          g.FJ(220L);
          AppMethodBeat.o(156973);
          continue;
        }
        if (this.MQI != WebView.c.MNz) {
          break label141;
        }
      }
      finally {}
      g.FJ(226L);
      label141:
      AppMethodBeat.o(156973);
    }
  }
  
  public final boolean ggq()
  {
    boolean bool = true;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(156974);
        if ((ggp() == 3) || (ggp() == 2))
        {
          if (this.MQI == WebView.c.MNy) {
            g.FJ(222L);
          }
        }
        else
        {
          if ((ggp() != 1) && (ggp() != 3) && (ggp() != 2)) {
            break label98;
          }
          AppMethodBeat.o(156974);
          return bool;
        }
        if (this.MQI != WebView.c.MNz) {
          continue;
        }
        g.FJ(228L);
        continue;
        bool = false;
      }
      finally {}
      label98:
      AppMethodBeat.o(156974);
    }
  }
  
  /* Error */
  public final boolean ggr()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 218
    //   4: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: invokespecial 212	com/tencent/xweb/internal/h:ggp	()I
    //   11: iconst_2
    //   12: if_icmpne +14 -> 26
    //   15: iconst_1
    //   16: istore_1
    //   17: ldc 218
    //   19: invokestatic 118	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   22: aload_0
    //   23: monitorexit
    //   24: iload_1
    //   25: ireturn
    //   26: iconst_0
    //   27: istore_1
    //   28: ldc 218
    //   30: invokestatic 118	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   33: goto -11 -> 22
    //   36: astore_2
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_2
    //   40: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	41	0	this	h
    //   16	12	1	bool	boolean
    //   36	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	15	36	finally
    //   17	22	36	finally
    //   28	33	36	finally
  }
  
  /* Error */
  public final boolean ggs()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 220
    //   4: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: invokespecial 212	com/tencent/xweb/internal/h:ggp	()I
    //   11: iconst_3
    //   12: if_icmpne +14 -> 26
    //   15: iconst_1
    //   16: istore_1
    //   17: ldc 220
    //   19: invokestatic 118	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   22: aload_0
    //   23: monitorexit
    //   24: iload_1
    //   25: ireturn
    //   26: iconst_0
    //   27: istore_1
    //   28: ldc 220
    //   30: invokestatic 118	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   33: goto -11 -> 22
    //   36: astore_2
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_2
    //   40: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	41	0	this	h
    //   16	12	1	bool	boolean
    //   36	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	15	36	finally
    //   17	22	36	finally
    //   28	33	36	finally
  }
  
  public final void ggt()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(156978);
        if (!this.MQK)
        {
          AppMethodBeat.o(156978);
          return;
        }
        if (1 != this.MQE)
        {
          AppMethodBeat.o(156978);
          continue;
        }
        if (this.MQH.size() <= 0) {
          break label187;
        }
      }
      finally {}
      long l = ((Long)this.MQH.get(this.MQH.size() - 1)).longValue();
      if (Math.abs(System.currentTimeMillis() - l) < 60000L)
      {
        if (this.MQI == WebView.c.MNy) {
          g.FJ(221L);
        }
        for (;;)
        {
          this.MQG = 0L;
          this.MQH.clear();
          this.MQE = 2;
          this.MQJ = System.currentTimeMillis();
          e(this.MQI).edit().putLong("SP_KEY_NEED_SWITCH_TIME", this.MQJ).commit();
          AppMethodBeat.o(156978);
          break;
          if (this.MQI == WebView.c.MNz) {
            g.FJ(227L);
          }
        }
      }
      label187:
      this.MQE = 0;
      AppMethodBeat.o(156978);
    }
  }
  
  public final void ggu()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(156979);
        if (!this.MQK)
        {
          AppMethodBeat.o(156979);
          return;
        }
        if (1 != this.MQE)
        {
          AppMethodBeat.o(156979);
          continue;
        }
        this.MQG = 0L;
      }
      finally {}
      this.MQH.clear();
      this.MQE = 0;
      AppMethodBeat.o(156979);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.internal.h
 * JD-Core Version:    0.7.0.1
 */