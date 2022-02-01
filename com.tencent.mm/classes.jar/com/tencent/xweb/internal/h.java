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
  static h KDh = null;
  int KDa;
  int KDb;
  long KDc;
  ArrayList<Long> KDd;
  WebView.c KDe;
  long KDf;
  boolean KDg;
  
  private h(WebView.c paramc)
  {
    AppMethodBeat.i(156971);
    this.KDa = 0;
    this.KDb = 0;
    this.KDc = 0L;
    this.KDd = new ArrayList();
    this.KDf = 0L;
    this.KDg = false;
    this.KDe = paramc;
    if ((this.KDe != WebView.c.KAb) && (("tools".equals(WebView.getCurStrModule())) || ("toolsmp".equals(WebView.getCurStrModule()))))
    {
      paramc = a.mx("enable_err_watchdog", "tools");
      boolean bool1 = bool2;
      if (paramc != null)
      {
        bool1 = bool2;
        if (paramc.trim().toLowerCase().equals("true")) {
          bool1 = true;
        }
      }
      this.KDg = bool1;
      this.KDf = e(this.KDe).getLong("SP_KEY_NEED_SWITCH_TIME", 0L);
      if (Math.abs(System.currentTimeMillis() - this.KDf) < 43200000L)
      {
        this.KDa = 3;
        AppMethodBeat.o(156971);
      }
    }
    else
    {
      this.KDg = false;
    }
    AppMethodBeat.o(156971);
  }
  
  public static void d(WebView.c paramc)
  {
    try
    {
      AppMethodBeat.i(156970);
      KDh = new h(paramc);
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
  
  public static h fKq()
  {
    try
    {
      AppMethodBeat.i(156969);
      if (KDh == null)
      {
        localObject1 = WebView.getCurWebType();
        WebView.getCurStrModule();
        KDh = new h((WebView.c)localObject1);
      }
      Object localObject1 = KDh;
      AppMethodBeat.o(156969);
      return localObject1;
    }
    finally {}
  }
  
  private int fKs()
  {
    try
    {
      int i = this.KDa;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void fKl()
  {
    try
    {
      AppMethodBeat.i(156972);
      this.KDc = System.currentTimeMillis();
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
  public final void fKm()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 160
    //   4: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 50	com/tencent/xweb/internal/h:KDg	Z
    //   11: ifne +11 -> 22
    //   14: ldc 160
    //   16: invokestatic 118	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: aload_0
    //   23: lconst_0
    //   24: putfield 41	com/tencent/xweb/internal/h:KDc	J
    //   27: aload_0
    //   28: getfield 46	com/tencent/xweb/internal/h:KDd	Ljava/util/ArrayList;
    //   31: invokevirtual 163	java/util/ArrayList:clear	()V
    //   34: aload_0
    //   35: lconst_0
    //   36: putfield 48	com/tencent/xweb/internal/h:KDf	J
    //   39: aload_0
    //   40: iconst_0
    //   41: putfield 37	com/tencent/xweb/internal/h:KDa	I
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
  
  public final void fKr()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(156973);
        if (!this.KDg)
        {
          AppMethodBeat.o(156973);
          return;
        }
        if (NetworkUtil.isNetworkAvailable()) {
          this.KDd.add(Long.valueOf(System.currentTimeMillis()));
        }
        if (this.KDd.size() < 3) {
          break label141;
        }
        long l = ((Long)this.KDd.get(this.KDd.size() - 3)).longValue();
        if (Math.abs(System.currentTimeMillis() - l) >= 120000L) {
          break label141;
        }
        this.KDa = 1;
        if (this.KDe == WebView.c.KzZ)
        {
          g.Cf(220L);
          AppMethodBeat.o(156973);
          continue;
        }
        if (this.KDe != WebView.c.KAa) {
          break label141;
        }
      }
      finally {}
      g.Cf(226L);
      label141:
      AppMethodBeat.o(156973);
    }
  }
  
  public final boolean fKt()
  {
    boolean bool = true;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(156974);
        if ((fKs() == 3) || (fKs() == 2))
        {
          if (this.KDe == WebView.c.KzZ) {
            g.Cf(222L);
          }
        }
        else
        {
          if ((fKs() != 1) && (fKs() != 3) && (fKs() != 2)) {
            break label98;
          }
          AppMethodBeat.o(156974);
          return bool;
        }
        if (this.KDe != WebView.c.KAa) {
          continue;
        }
        g.Cf(228L);
        continue;
        bool = false;
      }
      finally {}
      label98:
      AppMethodBeat.o(156974);
    }
  }
  
  /* Error */
  public final boolean fKu()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 218
    //   4: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: invokespecial 212	com/tencent/xweb/internal/h:fKs	()I
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
  public final boolean fKv()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 220
    //   4: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: invokespecial 212	com/tencent/xweb/internal/h:fKs	()I
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
  
  public final void fKw()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(156978);
        if (!this.KDg)
        {
          AppMethodBeat.o(156978);
          return;
        }
        if (1 != this.KDa)
        {
          AppMethodBeat.o(156978);
          continue;
        }
        if (this.KDd.size() <= 0) {
          break label187;
        }
      }
      finally {}
      long l = ((Long)this.KDd.get(this.KDd.size() - 1)).longValue();
      if (Math.abs(System.currentTimeMillis() - l) < 60000L)
      {
        if (this.KDe == WebView.c.KzZ) {
          g.Cf(221L);
        }
        for (;;)
        {
          this.KDc = 0L;
          this.KDd.clear();
          this.KDa = 2;
          this.KDf = System.currentTimeMillis();
          e(this.KDe).edit().putLong("SP_KEY_NEED_SWITCH_TIME", this.KDf).commit();
          AppMethodBeat.o(156978);
          break;
          if (this.KDe == WebView.c.KAa) {
            g.Cf(227L);
          }
        }
      }
      label187:
      this.KDa = 0;
      AppMethodBeat.o(156978);
    }
  }
  
  public final void fKx()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(156979);
        if (!this.KDg)
        {
          AppMethodBeat.o(156979);
          return;
        }
        if (1 != this.KDa)
        {
          AppMethodBeat.o(156979);
          continue;
        }
        this.KDc = 0L;
      }
      finally {}
      this.KDd.clear();
      this.KDa = 0;
      AppMethodBeat.o(156979);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.internal.h
 * JD-Core Version:    0.7.0.1
 */