package com.tencent.xweb.c;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.d;
import com.tencent.xweb.a;
import com.tencent.xweb.util.f;
import java.util.ArrayList;
import org.xwalk.core.NetworkUtil;
import org.xwalk.core.XWalkEnvironment;

public final class k
{
  static k BHc = null;
  int BGV;
  int BGW;
  long BGX;
  ArrayList<Long> BGY;
  WebView.d BGZ;
  long BHa;
  boolean BHb;
  
  private k(WebView.d paramd)
  {
    AppMethodBeat.i(3983);
    this.BGV = 0;
    this.BGW = 0;
    this.BGX = 0L;
    this.BGY = new ArrayList();
    this.BHa = 0L;
    this.BHb = false;
    this.BGZ = paramd;
    if ((this.BGZ != WebView.d.BEs) && (("tools".equals(WebView.getCurStrModule())) || ("toolsmp".equals(WebView.getCurStrModule()))))
    {
      paramd = a.iW("enable_err_watchdog", "tools");
      boolean bool1 = bool2;
      if (paramd != null)
      {
        bool1 = bool2;
        if (paramd.trim().toLowerCase().equals("true")) {
          bool1 = true;
        }
      }
      this.BHb = bool1;
      this.BHa = d(this.BGZ).getLong("SP_KEY_NEED_SWITCH_TIME", 0L);
      if (Math.abs(System.currentTimeMillis() - this.BHa) < 43200000L)
      {
        this.BGV = 3;
        AppMethodBeat.o(3983);
      }
    }
    else
    {
      this.BHb = false;
    }
    AppMethodBeat.o(3983);
  }
  
  public static void c(WebView.d paramd)
  {
    try
    {
      AppMethodBeat.i(3982);
      BHc = new k(paramd);
      AppMethodBeat.o(3982);
      return;
    }
    finally
    {
      paramd = finally;
      throw paramd;
    }
  }
  
  private static SharedPreferences d(WebView.d paramd)
  {
    try
    {
      AppMethodBeat.i(3992);
      paramd = XWalkEnvironment.getProcessSafePreferences(XWalkEnvironment.getProcessName() + "_LOAD_URL_" + paramd, 4);
      AppMethodBeat.o(3992);
      return paramd;
    }
    finally
    {
      paramd = finally;
      throw paramd;
    }
  }
  
  public static k dYQ()
  {
    try
    {
      AppMethodBeat.i(3981);
      if (BHc == null)
      {
        localObject1 = WebView.getCurWebType();
        WebView.getCurStrModule();
        BHc = new k((WebView.d)localObject1);
      }
      Object localObject1 = BHc;
      AppMethodBeat.o(3981);
      return localObject1;
    }
    finally {}
  }
  
  private int dYS()
  {
    try
    {
      int i = this.BGV;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void dYN()
  {
    try
    {
      AppMethodBeat.i(3984);
      this.BGX = System.currentTimeMillis();
      AppMethodBeat.o(3984);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public final void dYO()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 3989
    //   5: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 49	com/tencent/xweb/c/k:BHb	Z
    //   12: ifne +12 -> 24
    //   15: sipush 3989
    //   18: invokestatic 117	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: lconst_0
    //   26: putfield 40	com/tencent/xweb/c/k:BGX	J
    //   29: aload_0
    //   30: getfield 45	com/tencent/xweb/c/k:BGY	Ljava/util/ArrayList;
    //   33: invokevirtual 157	java/util/ArrayList:clear	()V
    //   36: aload_0
    //   37: lconst_0
    //   38: putfield 47	com/tencent/xweb/c/k:BHa	J
    //   41: aload_0
    //   42: iconst_0
    //   43: putfield 36	com/tencent/xweb/c/k:BGV	I
    //   46: sipush 3989
    //   49: invokestatic 117	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   52: goto -31 -> 21
    //   55: astore_1
    //   56: aload_0
    //   57: monitorexit
    //   58: aload_1
    //   59: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	this	k
    //   55	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	21	55	finally
    //   24	52	55	finally
  }
  
  public final void dYR()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(3985);
        if (!this.BHb)
        {
          AppMethodBeat.o(3985);
          return;
        }
        if (NetworkUtil.isNetworkAvailable()) {
          this.BGY.add(Long.valueOf(System.currentTimeMillis()));
        }
        if (this.BGY.size() < 3) {
          break label144;
        }
        long l = ((Long)this.BGY.get(this.BGY.size() - 3)).longValue();
        if (Math.abs(System.currentTimeMillis() - l) >= 120000L) {
          break label144;
        }
        this.BGV = 1;
        if (this.BGZ == WebView.d.BEq)
        {
          f.pf(220L);
          AppMethodBeat.o(3985);
          continue;
        }
        if (this.BGZ != WebView.d.BEr) {
          break label144;
        }
      }
      finally {}
      f.pf(226L);
      label144:
      AppMethodBeat.o(3985);
    }
  }
  
  public final boolean dYT()
  {
    boolean bool = true;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(3986);
        if ((dYS() == 3) || (dYS() == 2))
        {
          if (this.BGZ == WebView.d.BEq) {
            f.pf(222L);
          }
        }
        else
        {
          if ((dYS() != 1) && (dYS() != 3) && (dYS() != 2)) {
            break label100;
          }
          AppMethodBeat.o(3986);
          return bool;
        }
        if (this.BGZ != WebView.d.BEr) {
          continue;
        }
        f.pf(228L);
        continue;
        bool = false;
      }
      finally {}
      label100:
      AppMethodBeat.o(3986);
    }
  }
  
  /* Error */
  public final boolean dYU()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 3987
    //   5: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: invokespecial 204	com/tencent/xweb/c/k:dYS	()I
    //   12: iconst_2
    //   13: if_icmpne +15 -> 28
    //   16: iconst_1
    //   17: istore_1
    //   18: sipush 3987
    //   21: invokestatic 117	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: aload_0
    //   25: monitorexit
    //   26: iload_1
    //   27: ireturn
    //   28: iconst_0
    //   29: istore_1
    //   30: sipush 3987
    //   33: invokestatic 117	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   36: goto -12 -> 24
    //   39: astore_2
    //   40: aload_0
    //   41: monitorexit
    //   42: aload_2
    //   43: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	44	0	this	k
    //   17	13	1	bool	boolean
    //   39	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	16	39	finally
    //   18	24	39	finally
    //   30	36	39	finally
  }
  
  /* Error */
  public final boolean dYV()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 3988
    //   5: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: invokespecial 204	com/tencent/xweb/c/k:dYS	()I
    //   12: iconst_3
    //   13: if_icmpne +15 -> 28
    //   16: iconst_1
    //   17: istore_1
    //   18: sipush 3988
    //   21: invokestatic 117	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: aload_0
    //   25: monitorexit
    //   26: iload_1
    //   27: ireturn
    //   28: iconst_0
    //   29: istore_1
    //   30: sipush 3988
    //   33: invokestatic 117	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   36: goto -12 -> 24
    //   39: astore_2
    //   40: aload_0
    //   41: monitorexit
    //   42: aload_2
    //   43: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	44	0	this	k
    //   17	13	1	bool	boolean
    //   39	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	16	39	finally
    //   18	24	39	finally
    //   30	36	39	finally
  }
  
  public final void dYW()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(3990);
        if (!this.BHb)
        {
          AppMethodBeat.o(3990);
          return;
        }
        if (1 != this.BGV)
        {
          AppMethodBeat.o(3990);
          continue;
        }
        if (this.BGY.size() <= 0) {
          break label191;
        }
      }
      finally {}
      long l = ((Long)this.BGY.get(this.BGY.size() - 1)).longValue();
      if (Math.abs(System.currentTimeMillis() - l) < 60000L)
      {
        if (this.BGZ == WebView.d.BEq) {
          f.pf(221L);
        }
        for (;;)
        {
          this.BGX = 0L;
          this.BGY.clear();
          this.BGV = 2;
          this.BHa = System.currentTimeMillis();
          d(this.BGZ).edit().putLong("SP_KEY_NEED_SWITCH_TIME", this.BHa).commit();
          AppMethodBeat.o(3990);
          break;
          if (this.BGZ == WebView.d.BEr) {
            f.pf(227L);
          }
        }
      }
      label191:
      this.BGV = 0;
      AppMethodBeat.o(3990);
    }
  }
  
  public final void dYX()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(3991);
        if (!this.BHb)
        {
          AppMethodBeat.o(3991);
          return;
        }
        if (1 != this.BGV)
        {
          AppMethodBeat.o(3991);
          continue;
        }
        this.BGX = 0L;
      }
      finally {}
      this.BGY.clear();
      this.BGV = 0;
      AppMethodBeat.o(3991);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.xweb.c.k
 * JD-Core Version:    0.7.0.1
 */