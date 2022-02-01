package com.tencent.xweb.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.WebViewKind;
import java.util.Date;
import org.xwalk.core.XWalkEnvironment;

public final class c
{
  private SharedPreferences aijP;
  private String aijQ;
  private String aijR;
  private String aijS;
  private long aijT;
  private long aijU;
  public long aijV;
  private String aijW;
  private boolean aijX;
  
  private c(String paramString, WebView.WebViewKind paramWebViewKind)
  {
    AppMethodBeat.i(156958);
    this.aijX = false;
    this.aijP = e(paramString, paramWebViewKind);
    this.aijQ = "INIT_START_TIME".concat(String.valueOf(paramString));
    this.aijR = "INIT_END_TIME".concat(String.valueOf(paramString));
    this.aijS = "INIT_TRY_COUNT".concat(String.valueOf(paramString));
    this.aijW = paramString;
    if (this.aijP == null)
    {
      AppMethodBeat.o(156958);
      return;
    }
    this.aijT = this.aijP.getLong(this.aijQ, 0L);
    this.aijU = this.aijP.getLong(this.aijR, 0L);
    this.aijV = this.aijP.getLong(this.aijS, 0L);
    AppMethodBeat.o(156958);
  }
  
  private boolean Bp(long paramLong)
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(212613);
        if (0L == this.aijT)
        {
          AppMethodBeat.o(212613);
          return bool;
        }
        if ((this.aijU - this.aijT >= 0L) || (Math.abs(paramLong - this.aijT) > 10800000L))
        {
          AppMethodBeat.o(212613);
          continue;
        }
        if (this.aijU >= this.aijT) {
          break label94;
        }
      }
      finally {}
      bool = true;
      AppMethodBeat.o(212613);
      continue;
      label94:
      AppMethodBeat.o(212613);
    }
  }
  
  private static c a(String paramString1, WebView.WebViewKind paramWebViewKind, String paramString2)
  {
    try
    {
      AppMethodBeat.i(212579);
      paramString1 = c(paramString1 + ":" + paramString2, paramWebViewKind);
      AppMethodBeat.o(212579);
      return paramString1;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  /* Error */
  public static boolean a(WebView.WebViewKind paramWebViewKind, String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: ldc 2
    //   4: monitorenter
    //   5: ldc 110
    //   7: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: invokestatic 116	com/tencent/xweb/aa:kfE	()Lcom/tencent/xweb/aa;
    //   13: getfield 119	com/tencent/xweb/aa:aifj	Z
    //   16: ifeq +13 -> 29
    //   19: ldc 110
    //   21: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: ldc 2
    //   26: monitorexit
    //   27: iload_2
    //   28: ireturn
    //   29: ldc 121
    //   31: aload_0
    //   32: aload_1
    //   33: invokestatic 123	com/tencent/xweb/internal/c:a	(Ljava/lang/String;Lcom/tencent/xweb/WebView$WebViewKind;Ljava/lang/String;)Lcom/tencent/xweb/internal/c;
    //   36: invokespecial 127	com/tencent/xweb/internal/c:khb	()Z
    //   39: ifeq +50 -> 89
    //   42: ldc 129
    //   44: new 93	java/lang/StringBuilder
    //   47: dup
    //   48: ldc 131
    //   50: invokespecial 134	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   53: aload_1
    //   54: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: ldc 136
    //   59: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: aload_0
    //   63: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   66: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: invokestatic 144	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   72: aload_0
    //   73: getstatic 150	com/tencent/xweb/util/l$b$a:aimK	I
    //   76: invokestatic 155	com/tencent/xweb/util/l:a	(Lcom/tencent/xweb/WebView$WebViewKind;I)V
    //   79: ldc 110
    //   81: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   84: iconst_1
    //   85: istore_2
    //   86: goto -62 -> 24
    //   89: ldc 157
    //   91: aload_0
    //   92: aload_1
    //   93: invokestatic 123	com/tencent/xweb/internal/c:a	(Ljava/lang/String;Lcom/tencent/xweb/WebView$WebViewKind;Ljava/lang/String;)Lcom/tencent/xweb/internal/c;
    //   96: invokespecial 127	com/tencent/xweb/internal/c:khb	()Z
    //   99: ifeq +50 -> 149
    //   102: ldc 129
    //   104: new 93	java/lang/StringBuilder
    //   107: dup
    //   108: ldc 159
    //   110: invokespecial 134	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   113: aload_1
    //   114: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: ldc 136
    //   119: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: aload_0
    //   123: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   126: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   129: invokestatic 144	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   132: aload_0
    //   133: getstatic 162	com/tencent/xweb/util/l$b$a:aimL	I
    //   136: invokestatic 155	com/tencent/xweb/util/l:a	(Lcom/tencent/xweb/WebView$WebViewKind;I)V
    //   139: ldc 110
    //   141: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   144: iconst_1
    //   145: istore_2
    //   146: goto -122 -> 24
    //   149: ldc 110
    //   151: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   154: goto -130 -> 24
    //   157: astore_0
    //   158: ldc 2
    //   160: monitorexit
    //   161: aload_0
    //   162: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	163	0	paramWebViewKind	WebView.WebViewKind
    //   0	163	1	paramString	String
    //   1	145	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   5	24	157	finally
    //   29	84	157	finally
    //   89	144	157	finally
    //   149	154	157	finally
  }
  
  public static c c(String paramString, WebView.WebViewKind paramWebViewKind)
  {
    try
    {
      AppMethodBeat.i(156959);
      paramString = new c(paramString, paramWebViewKind);
      AppMethodBeat.o(156959);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  /* Error */
  public static boolean c(WebView.WebViewKind paramWebViewKind)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: ldc 2
    //   4: monitorenter
    //   5: ldc 167
    //   7: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: invokestatic 116	com/tencent/xweb/aa:kfE	()Lcom/tencent/xweb/aa;
    //   13: getfield 119	com/tencent/xweb/aa:aifj	Z
    //   16: ifeq +13 -> 29
    //   19: ldc 167
    //   21: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: ldc 2
    //   26: monitorexit
    //   27: iload_1
    //   28: ireturn
    //   29: ldc 121
    //   31: aload_0
    //   32: invokestatic 170	com/tencent/xweb/internal/c:d	(Ljava/lang/String;Lcom/tencent/xweb/WebView$WebViewKind;)Lcom/tencent/xweb/internal/c;
    //   35: invokespecial 127	com/tencent/xweb/internal/c:khb	()Z
    //   38: ifeq +52 -> 90
    //   41: ldc 129
    //   43: new 93	java/lang/StringBuilder
    //   46: dup
    //   47: ldc 131
    //   49: invokespecial 134	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   52: invokestatic 175	com/tencent/xweb/WebView:getCurStrModule	()Ljava/lang/String;
    //   55: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: ldc 136
    //   60: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: aload_0
    //   64: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   67: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: invokestatic 144	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   73: aload_0
    //   74: getstatic 150	com/tencent/xweb/util/l$b$a:aimK	I
    //   77: invokestatic 155	com/tencent/xweb/util/l:a	(Lcom/tencent/xweb/WebView$WebViewKind;I)V
    //   80: ldc 167
    //   82: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   85: iconst_1
    //   86: istore_1
    //   87: goto -63 -> 24
    //   90: ldc 157
    //   92: aload_0
    //   93: invokestatic 170	com/tencent/xweb/internal/c:d	(Ljava/lang/String;Lcom/tencent/xweb/WebView$WebViewKind;)Lcom/tencent/xweb/internal/c;
    //   96: invokespecial 127	com/tencent/xweb/internal/c:khb	()Z
    //   99: ifeq +52 -> 151
    //   102: ldc 129
    //   104: new 93	java/lang/StringBuilder
    //   107: dup
    //   108: ldc 159
    //   110: invokespecial 134	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   113: invokestatic 175	com/tencent/xweb/WebView:getCurStrModule	()Ljava/lang/String;
    //   116: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: ldc 136
    //   121: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: aload_0
    //   125: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   128: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   131: invokestatic 144	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   134: aload_0
    //   135: getstatic 162	com/tencent/xweb/util/l$b$a:aimL	I
    //   138: invokestatic 155	com/tencent/xweb/util/l:a	(Lcom/tencent/xweb/WebView$WebViewKind;I)V
    //   141: ldc 167
    //   143: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   146: iconst_1
    //   147: istore_1
    //   148: goto -124 -> 24
    //   151: ldc 167
    //   153: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   156: goto -132 -> 24
    //   159: astore_0
    //   160: ldc 2
    //   162: monitorexit
    //   163: aload_0
    //   164: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	165	0	paramWebViewKind	WebView.WebViewKind
    //   1	147	1	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   5	24	159	finally
    //   29	85	159	finally
    //   90	146	159	finally
    //   151	156	159	finally
  }
  
  public static c d(String paramString, WebView.WebViewKind paramWebViewKind)
  {
    try
    {
      AppMethodBeat.i(212586);
      paramString = a(paramString, paramWebViewKind, WebView.getCurStrModule());
      AppMethodBeat.o(212586);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  /* Error */
  private static SharedPreferences e(String paramString, WebView.WebViewKind paramWebViewKind)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 177
    //   5: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: getstatic 183	com/tencent/xweb/WebView$WebViewKind:aifI	Lcom/tencent/xweb/WebView$WebViewKind;
    //   12: if_acmpeq +29 -> 41
    //   15: aload_1
    //   16: getstatic 186	com/tencent/xweb/WebView$WebViewKind:aifL	Lcom/tencent/xweb/WebView$WebViewKind;
    //   19: if_acmpeq +22 -> 41
    //   22: aload_1
    //   23: getstatic 189	com/tencent/xweb/WebView$WebViewKind:aifK	Lcom/tencent/xweb/WebView$WebViewKind;
    //   26: if_acmpeq +15 -> 41
    //   29: aconst_null
    //   30: astore_0
    //   31: ldc 177
    //   33: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   36: ldc 2
    //   38: monitorexit
    //   39: aload_0
    //   40: areturn
    //   41: new 93	java/lang/StringBuilder
    //   44: dup
    //   45: ldc 191
    //   47: invokespecial 134	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   50: aload_1
    //   51: invokevirtual 192	com/tencent/xweb/WebView$WebViewKind:toString	()Ljava/lang/String;
    //   54: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: aload_0
    //   58: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: invokestatic 198	org/xwalk/core/XWalkSharedPreferenceUtil:getMMKVSharedPreferencesTransportOld	(Ljava/lang/String;)Landroid/content/SharedPreferences;
    //   67: astore_0
    //   68: ldc 177
    //   70: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   73: goto -37 -> 36
    //   76: astore_0
    //   77: ldc 2
    //   79: monitorexit
    //   80: aload_0
    //   81: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	paramString	String
    //   0	82	1	paramWebViewKind	WebView.WebViewKind
    // Exception table:
    //   from	to	target	type
    //   3	29	76	finally
    //   31	36	76	finally
    //   41	73	76	finally
  }
  
  private boolean khb()
  {
    boolean bool = false;
    for (;;)
    {
      long l;
      try
      {
        AppMethodBeat.i(212627);
        if (this.aijP == null)
        {
          AppMethodBeat.o(212627);
          return bool;
        }
        l = new Date().getTime();
        if (!Bp(l))
        {
          AppMethodBeat.o(212627);
          continue;
        }
        if (this.aijV <= 4L) {
          break label134;
        }
      }
      finally {}
      XWalkEnvironment.addXWalkInitializeLog("CrashWatchDog", "Scene " + this.aijW + " crashed " + (l - this.aijT) / 60000L + " minutes ago, try count = " + this.aijV);
      bool = true;
      AppMethodBeat.o(212627);
      continue;
      label134:
      AppMethodBeat.o(212627);
    }
  }
  
  public final void kgZ()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(156960);
        if (this.aijX)
        {
          AppMethodBeat.o(156960);
          return;
        }
        this.aijX = true;
        if (this.aijP == null)
        {
          AppMethodBeat.o(156960);
          continue;
        }
        localEditor = this.aijP.edit();
      }
      finally {}
      SharedPreferences.Editor localEditor;
      localEditor.putLong(this.aijS, this.aijV + 1L);
      long l = new Date().getTime();
      if (Bp(l))
      {
        localEditor.commit();
        AppMethodBeat.o(156960);
      }
      else
      {
        localEditor.putLong(this.aijQ, l);
        localEditor.commit();
        AppMethodBeat.o(156960);
      }
    }
  }
  
  /* Error */
  public final void kha()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 243
    //   4: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 37	com/tencent/xweb/internal/c:aijP	Landroid/content/SharedPreferences;
    //   11: ifnonnull +11 -> 22
    //   14: ldc 243
    //   16: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: aload_0
    //   23: getfield 37	com/tencent/xweb/internal/c:aijP	Landroid/content/SharedPreferences;
    //   26: invokeinterface 232 1 0
    //   31: astore_1
    //   32: aload_1
    //   33: aload_0
    //   34: getfield 55	com/tencent/xweb/internal/c:aijR	Ljava/lang/String;
    //   37: new 201	java/util/Date
    //   40: dup
    //   41: invokespecial 202	java/util/Date:<init>	()V
    //   44: invokevirtual 206	java/util/Date:getTime	()J
    //   47: invokeinterface 238 4 0
    //   52: pop
    //   53: aload_1
    //   54: aload_0
    //   55: getfield 59	com/tencent/xweb/internal/c:aijS	Ljava/lang/String;
    //   58: lconst_0
    //   59: invokeinterface 238 4 0
    //   64: pop
    //   65: aload_1
    //   66: invokeinterface 241 1 0
    //   71: pop
    //   72: aload_0
    //   73: aconst_null
    //   74: putfield 37	com/tencent/xweb/internal/c:aijP	Landroid/content/SharedPreferences;
    //   77: ldc 243
    //   79: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   82: goto -63 -> 19
    //   85: astore_1
    //   86: aload_0
    //   87: monitorexit
    //   88: aload_1
    //   89: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	this	c
    //   31	35	1	localEditor	SharedPreferences.Editor
    //   85	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	85	finally
    //   22	82	85	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.internal.c
 * JD-Core Version:    0.7.0.1
 */