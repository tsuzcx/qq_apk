package com.tencent.xweb.xwalk;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.Log;

public final class b
{
  private static final String[] ainG = { "_id" };
  private final Object ainH;
  SQLiteDatabase mDatabase;
  private boolean mInitialized;
  
  private b()
  {
    AppMethodBeat.i(212871);
    this.ainH = new Object();
    AppMethodBeat.o(212871);
  }
  
  public static b dt(final Context paramContext, final String paramString)
  {
    AppMethodBeat.i(212866);
    b localb = new b();
    new Thread()
    {
      public final void run()
      {
        AppMethodBeat.i(212936);
        b.a(b.this, paramContext, paramString);
        AppMethodBeat.o(212936);
      }
    }.start();
    AppMethodBeat.o(212866);
    return localb;
  }
  
  /* Error */
  public final String[] getHttpAuthUsernamePassword(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 116
    //   2: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: ifnull +14 -> 20
    //   9: aload_2
    //   10: ifnull +10 -> 20
    //   13: aload_0
    //   14: invokevirtual 120	com/tencent/xweb/xwalk/b:kja	()Z
    //   17: ifne +10 -> 27
    //   20: ldc 116
    //   22: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   25: aconst_null
    //   26: areturn
    //   27: aload_0
    //   28: getfield 53	com/tencent/xweb/xwalk/b:mDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   31: ldc 122
    //   33: iconst_2
    //   34: anewarray 18	java/lang/String
    //   37: dup
    //   38: iconst_0
    //   39: ldc 124
    //   41: aastore
    //   42: dup
    //   43: iconst_1
    //   44: ldc 126
    //   46: aastore
    //   47: ldc 128
    //   49: iconst_2
    //   50: anewarray 18	java/lang/String
    //   53: dup
    //   54: iconst_0
    //   55: aload_1
    //   56: aastore
    //   57: dup
    //   58: iconst_1
    //   59: aload_2
    //   60: aastore
    //   61: aconst_null
    //   62: aconst_null
    //   63: aconst_null
    //   64: invokevirtual 132	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   67: astore_1
    //   68: aload_1
    //   69: astore_2
    //   70: aload_1
    //   71: invokeinterface 137 1 0
    //   76: ifeq +132 -> 208
    //   79: aload_1
    //   80: astore_2
    //   81: iconst_2
    //   82: anewarray 18	java/lang/String
    //   85: astore_3
    //   86: aload_1
    //   87: astore_2
    //   88: aload_3
    //   89: iconst_0
    //   90: aload_1
    //   91: aload_1
    //   92: ldc 124
    //   94: invokeinterface 141 2 0
    //   99: invokeinterface 145 2 0
    //   104: aastore
    //   105: aload_1
    //   106: astore_2
    //   107: aload_3
    //   108: iconst_1
    //   109: aload_1
    //   110: aload_1
    //   111: ldc 126
    //   113: invokeinterface 141 2 0
    //   118: invokeinterface 145 2 0
    //   123: aastore
    //   124: aload_3
    //   125: astore_2
    //   126: aload_2
    //   127: astore_3
    //   128: aload_1
    //   129: ifnull +11 -> 140
    //   132: aload_1
    //   133: invokeinterface 148 1 0
    //   138: aload_2
    //   139: astore_3
    //   140: ldc 116
    //   142: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   145: aload_3
    //   146: areturn
    //   147: astore_3
    //   148: aconst_null
    //   149: astore_1
    //   150: aload_1
    //   151: astore_2
    //   152: ldc 55
    //   154: ldc 149
    //   156: aload_3
    //   157: invokestatic 152	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   160: aload_1
    //   161: ifnull +42 -> 203
    //   164: aload_1
    //   165: invokeinterface 148 1 0
    //   170: aconst_null
    //   171: astore_3
    //   172: goto -32 -> 140
    //   175: astore_1
    //   176: aconst_null
    //   177: astore_2
    //   178: aload_2
    //   179: ifnull +9 -> 188
    //   182: aload_2
    //   183: invokeinterface 148 1 0
    //   188: ldc 116
    //   190: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   193: aload_1
    //   194: athrow
    //   195: astore_1
    //   196: goto -18 -> 178
    //   199: astore_3
    //   200: goto -50 -> 150
    //   203: aconst_null
    //   204: astore_3
    //   205: goto -65 -> 140
    //   208: aconst_null
    //   209: astore_2
    //   210: goto -84 -> 126
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	213	0	this	b
    //   0	213	1	paramString1	String
    //   0	213	2	paramString2	String
    //   85	61	3	localObject1	Object
    //   147	10	3	localIllegalStateException1	java.lang.IllegalStateException
    //   171	1	3	localObject2	Object
    //   199	1	3	localIllegalStateException2	java.lang.IllegalStateException
    //   204	1	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   27	68	147	java/lang/IllegalStateException
    //   27	68	175	finally
    //   70	79	195	finally
    //   81	86	195	finally
    //   88	105	195	finally
    //   107	124	195	finally
    //   152	160	195	finally
    //   70	79	199	java/lang/IllegalStateException
    //   81	86	199	java/lang/IllegalStateException
    //   88	105	199	java/lang/IllegalStateException
    //   107	124	199	java/lang/IllegalStateException
  }
  
  final boolean kja()
  {
    AppMethodBeat.i(212893);
    synchronized (this.ainH)
    {
      for (;;)
      {
        boolean bool = this.mInitialized;
        if (!bool) {
          try
          {
            this.ainH.wait();
          }
          catch (InterruptedException localInterruptedException)
          {
            Log.e("HttpAuthDatabase", "Caught exception while checking initialization", localInterruptedException);
          }
        }
      }
    }
    if (this.mDatabase != null)
    {
      AppMethodBeat.o(212893);
      return true;
    }
    AppMethodBeat.o(212893);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.xwalk.b
 * JD-Core Version:    0.7.0.1
 */