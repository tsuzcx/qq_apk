package com.tencent.mm.recoveryv2;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

public final class h$c
{
  private final g NBQ;
  public String NBT;
  private final Context mContext;
  
  private h$c(Context paramContext)
  {
    AppMethodBeat.i(193828);
    this.mContext = paramContext;
    this.NBQ = new g.a(paramContext, "recovery_log").guE();
    paramContext = new File(l.iU(paramContext), ".log").getAbsolutePath();
    String str = this.NBQ.getString("setting_log_path", paramContext);
    try
    {
      l.b.O(new File(str));
      paramContext = str;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        this.NBQ.bhB("setting_log_path");
      }
    }
    this.NBT = paramContext;
    AppMethodBeat.o(193828);
  }
  
  public static c iP(Context paramContext)
  {
    AppMethodBeat.i(193827);
    paramContext = new c(paramContext);
    AppMethodBeat.o(193827);
    return paramContext;
  }
  
  public final void guM()
  {
    AppMethodBeat.i(193829);
    a.a.L(new File(this.NBT));
    AppMethodBeat.o(193829);
  }
  
  /* Error */
  public final String guN()
  {
    // Byte code:
    //   0: ldc 102
    //   2: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 46	java/io/File
    //   8: dup
    //   9: aload_0
    //   10: getfield 78	com/tencent/mm/recoveryv2/h$c:NBT	Ljava/lang/String;
    //   13: invokespecial 70	java/io/File:<init>	(Ljava/lang/String;)V
    //   16: astore_1
    //   17: aload_1
    //   18: invokevirtual 106	java/io/File:exists	()Z
    //   21: ifne +10 -> 31
    //   24: ldc 102
    //   26: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: aconst_null
    //   30: areturn
    //   31: new 108	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   38: astore_3
    //   39: new 111	java/io/BufferedReader
    //   42: dup
    //   43: new 113	java/io/FileReader
    //   46: dup
    //   47: aload_1
    //   48: invokespecial 115	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   51: invokespecial 118	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   54: astore_2
    //   55: aload_2
    //   56: astore_1
    //   57: aload_2
    //   58: invokevirtual 121	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   61: astore 4
    //   63: aload 4
    //   65: ifnull +46 -> 111
    //   68: aload_2
    //   69: astore_1
    //   70: aload_3
    //   71: aload 4
    //   73: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: aload_2
    //   78: astore_1
    //   79: aload_3
    //   80: bipush 10
    //   82: invokevirtual 128	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   85: pop
    //   86: goto -31 -> 55
    //   89: astore_3
    //   90: aload_2
    //   91: astore_1
    //   92: ldc 130
    //   94: ldc 132
    //   96: aload_3
    //   97: invokestatic 138	com/tencent/mm/recoveryv2/a:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   100: aload_2
    //   101: invokestatic 142	com/tencent/mm/recoveryv2/l$b:closeQuietly	(Ljava/lang/Object;)V
    //   104: ldc 102
    //   106: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   109: aconst_null
    //   110: areturn
    //   111: aload_2
    //   112: invokestatic 142	com/tencent/mm/recoveryv2/l$b:closeQuietly	(Ljava/lang/Object;)V
    //   115: aload_3
    //   116: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: astore_1
    //   120: ldc 102
    //   122: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   125: aload_1
    //   126: areturn
    //   127: astore_2
    //   128: aconst_null
    //   129: astore_1
    //   130: aload_1
    //   131: invokestatic 142	com/tencent/mm/recoveryv2/l$b:closeQuietly	(Ljava/lang/Object;)V
    //   134: ldc 102
    //   136: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   139: aload_2
    //   140: athrow
    //   141: astore_2
    //   142: goto -12 -> 130
    //   145: astore_3
    //   146: aconst_null
    //   147: astore_2
    //   148: goto -58 -> 90
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	151	0	this	c
    //   16	115	1	localObject1	Object
    //   54	58	2	localBufferedReader	java.io.BufferedReader
    //   127	13	2	localObject2	Object
    //   141	1	2	localObject3	Object
    //   147	1	2	localObject4	Object
    //   38	42	3	localStringBuilder	java.lang.StringBuilder
    //   89	27	3	localIOException1	java.io.IOException
    //   145	1	3	localIOException2	java.io.IOException
    //   61	11	4	str	String
    // Exception table:
    //   from	to	target	type
    //   57	63	89	java/io/IOException
    //   70	77	89	java/io/IOException
    //   79	86	89	java/io/IOException
    //   39	55	127	finally
    //   57	63	141	finally
    //   70	77	141	finally
    //   79	86	141	finally
    //   92	100	141	finally
    //   39	55	145	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.recoveryv2.h.c
 * JD-Core Version:    0.7.0.1
 */