package com.tencent.xweb.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.WebViewKind;
import com.tencent.xweb.a;
import com.tencent.xweb.util.l;
import java.util.ArrayList;
import org.xwalk.core.NetworkUtil;
import org.xwalk.core.XWalkSharedPreferenceUtil;

public final class i
{
  private static i aikf = null;
  private int aijZ;
  private long aika;
  private ArrayList<Long> aikb;
  private WebView.WebViewKind aikc;
  private long aikd;
  private boolean aike;
  
  private i(WebView.WebViewKind paramWebViewKind, String paramString)
  {
    AppMethodBeat.i(212583);
    this.aijZ = 0;
    this.aika = 0L;
    this.aikb = new ArrayList();
    this.aikd = 0L;
    this.aike = false;
    this.aikc = paramWebViewKind;
    if ((this.aikc != WebView.WebViewKind.aifK) && (("tools".equals(paramString)) || ("toolsmp".equals(paramString))))
    {
      paramWebViewKind = a.keX().qM("enable_err_watchdog", "tools");
      boolean bool1 = bool2;
      if (paramWebViewKind != null)
      {
        bool1 = bool2;
        if (paramWebViewKind.trim().toLowerCase().equals("true")) {
          bool1 = true;
        }
      }
      this.aike = bool1;
      this.aikd = XWalkSharedPreferenceUtil.getSharedPreferencesForInitLog(this.aikc).getLong("SP_KEY_NEED_SWITCH_TIME", 0L);
      if (Math.abs(System.currentTimeMillis() - this.aikd) < 43200000L)
      {
        this.aijZ = 3;
        AppMethodBeat.o(212583);
      }
    }
    else
    {
      this.aike = false;
    }
    AppMethodBeat.o(212583);
  }
  
  public static void b(WebView.WebViewKind paramWebViewKind, String paramString)
  {
    try
    {
      AppMethodBeat.i(212577);
      aikf = new i(paramWebViewKind, paramString);
      AppMethodBeat.o(212577);
      return;
    }
    finally
    {
      paramWebViewKind = finally;
      throw paramWebViewKind;
    }
  }
  
  public static i khf()
  {
    try
    {
      AppMethodBeat.i(156969);
      if (aikf == null) {
        aikf = new i(WebView.getCurWebType(), WebView.getCurStrModule());
      }
      i locali = aikf;
      AppMethodBeat.o(156969);
      return locali;
    }
    finally {}
  }
  
  private int khh()
  {
    try
    {
      int i = this.aijZ;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void kgZ()
  {
    try
    {
      AppMethodBeat.i(156972);
      this.aika = System.currentTimeMillis();
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
  public final void kha()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 138
    //   4: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 47	com/tencent/xweb/internal/i:aike	Z
    //   11: ifne +11 -> 22
    //   14: ldc 138
    //   16: invokestatic 116	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: aload_0
    //   23: lconst_0
    //   24: putfield 38	com/tencent/xweb/internal/i:aika	J
    //   27: aload_0
    //   28: getfield 43	com/tencent/xweb/internal/i:aikb	Ljava/util/ArrayList;
    //   31: invokevirtual 141	java/util/ArrayList:clear	()V
    //   34: aload_0
    //   35: lconst_0
    //   36: putfield 45	com/tencent/xweb/internal/i:aikd	J
    //   39: aload_0
    //   40: iconst_0
    //   41: putfield 36	com/tencent/xweb/internal/i:aijZ	I
    //   44: ldc 138
    //   46: invokestatic 116	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   49: goto -30 -> 19
    //   52: astore_1
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_1
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	this	i
    //   52	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	52	finally
    //   22	49	52	finally
  }
  
  public final void khg()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(156973);
        if (!this.aike)
        {
          AppMethodBeat.o(156973);
          return;
        }
        if (NetworkUtil.isNetworkAvailable()) {
          this.aikb.add(Long.valueOf(System.currentTimeMillis()));
        }
        if (this.aikb.size() < 3) {
          break label151;
        }
        long l = ((Long)this.aikb.get(this.aikb.size() - 3)).longValue();
        if (Math.abs(System.currentTimeMillis() - l) >= 120000L) {
          break label151;
        }
        this.aijZ = 1;
        if ((this.aikc == WebView.WebViewKind.aifI) || (this.aikc == WebView.WebViewKind.aifL))
        {
          l.Br(220L);
          AppMethodBeat.o(156973);
          continue;
        }
        if (this.aikc != WebView.WebViewKind.aifJ) {
          break label151;
        }
      }
      finally {}
      l.Br(226L);
      label151:
      AppMethodBeat.o(156973);
    }
  }
  
  public final boolean khi()
  {
    boolean bool = true;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(156974);
        if ((khh() == 3) || (khh() == 2))
        {
          if ((this.aikc == WebView.WebViewKind.aifI) || (this.aikc == WebView.WebViewKind.aifL)) {
            l.Br(222L);
          }
        }
        else
        {
          if ((khh() != 1) && (khh() != 3) && (khh() != 2)) {
            break label108;
          }
          AppMethodBeat.o(156974);
          return bool;
        }
        if (this.aikc != WebView.WebViewKind.aifJ) {
          continue;
        }
        l.Br(228L);
        continue;
        bool = false;
      }
      finally {}
      label108:
      AppMethodBeat.o(156974);
    }
  }
  
  /* Error */
  public final boolean khj()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 199
    //   4: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: invokespecial 193	com/tencent/xweb/internal/i:khh	()I
    //   11: iconst_2
    //   12: if_icmpne +14 -> 26
    //   15: iconst_1
    //   16: istore_1
    //   17: ldc 199
    //   19: invokestatic 116	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   22: aload_0
    //   23: monitorexit
    //   24: iload_1
    //   25: ireturn
    //   26: iconst_0
    //   27: istore_1
    //   28: ldc 199
    //   30: invokestatic 116	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   33: goto -11 -> 22
    //   36: astore_2
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_2
    //   40: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	41	0	this	i
    //   16	12	1	bool	boolean
    //   36	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	15	36	finally
    //   17	22	36	finally
    //   28	33	36	finally
  }
  
  /* Error */
  public final boolean khk()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 201
    //   4: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: invokespecial 193	com/tencent/xweb/internal/i:khh	()I
    //   11: iconst_3
    //   12: if_icmpne +14 -> 26
    //   15: iconst_1
    //   16: istore_1
    //   17: ldc 201
    //   19: invokestatic 116	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   22: aload_0
    //   23: monitorexit
    //   24: iload_1
    //   25: ireturn
    //   26: iconst_0
    //   27: istore_1
    //   28: ldc 201
    //   30: invokestatic 116	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   33: goto -11 -> 22
    //   36: astore_2
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_2
    //   40: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	41	0	this	i
    //   16	12	1	bool	boolean
    //   36	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	15	36	finally
    //   17	22	36	finally
    //   28	33	36	finally
  }
  
  public final void khl()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(156978);
        if (!this.aike)
        {
          AppMethodBeat.o(156978);
          return;
        }
        if (1 != this.aijZ)
        {
          AppMethodBeat.o(156978);
          continue;
        }
        if (this.aikb.size() <= 0) {
          break label197;
        }
      }
      finally {}
      long l = ((Long)this.aikb.get(this.aikb.size() - 1)).longValue();
      if (Math.abs(System.currentTimeMillis() - l) < 60000L)
      {
        if ((this.aikc == WebView.WebViewKind.aifI) || (this.aikc == WebView.WebViewKind.aifL)) {
          l.Br(221L);
        }
        for (;;)
        {
          this.aika = 0L;
          this.aikb.clear();
          this.aijZ = 2;
          this.aikd = System.currentTimeMillis();
          XWalkSharedPreferenceUtil.getSharedPreferencesForInitLog(this.aikc).edit().putLong("SP_KEY_NEED_SWITCH_TIME", this.aikd).commit();
          AppMethodBeat.o(156978);
          break;
          if (this.aikc == WebView.WebViewKind.aifJ) {
            l.Br(227L);
          }
        }
      }
      label197:
      this.aijZ = 0;
      AppMethodBeat.o(156978);
    }
  }
  
  public final void khm()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(156979);
        if (!this.aike)
        {
          AppMethodBeat.o(156979);
          return;
        }
        if (1 != this.aijZ)
        {
          AppMethodBeat.o(156979);
          continue;
        }
        this.aika = 0L;
      }
      finally {}
      this.aikb.clear();
      this.aijZ = 0;
      AppMethodBeat.o(156979);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.internal.i
 * JD-Core Version:    0.7.0.1
 */