package com.tencent.mm.recoveryv2;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.concurrent.TimeUnit;

public final class h
{
  public int ackd;
  public int acke;
  public long ackf;
  public long ackg;
  public long ackh;
  public long acki;
  private f ackj;
  
  private h(Context paramContext)
  {
    AppMethodBeat.i(237918);
    this.ackj = new f.b(paramContext, "recovery_setting");
    this.ackj.iQF();
    this.ackd = Math.max(this.ackj.getInt("setting_threshold_1", 3), 2);
    this.acke = Math.max(this.ackj.getInt("setting_threshold_2", 5), 3);
    if (this.acke < this.ackd) {
      this.acke = this.ackd;
    }
    this.ackf = Math.max(this.ackj.getLong("setting_crash_interval", 10000L), 5000L);
    this.ackg = Math.max(this.ackj.getLong("setting_crash_interval_sub", 30000L), 5000L);
    this.ackh = Math.max(this.ackj.getLong("setting_crash_minimal_interval", 1000L), 0L);
    this.acki = Math.max(this.ackj.getLong("setting_reset_delay", 5000L), 1000L);
    AppMethodBeat.o(237918);
  }
  
  public static h lR(Context paramContext)
  {
    AppMethodBeat.i(237911);
    paramContext = new h(paramContext);
    AppMethodBeat.o(237911);
    return paramContext;
  }
  
  public final void sz()
  {
    AppMethodBeat.i(237925);
    this.ackj.iC("setting_threshold_1", this.ackd).iC("setting_threshold_2", this.acke).cm("setting_crash_interval", this.ackf).cm("setting_crash_interval_sub", this.ackg).cm("setting_crash_minimal_interval", this.ackh).cm("setting_reset_delay", this.acki).iQG();
    AppMethodBeat.o(237925);
  }
  
  public static final class a
  {
    public final f ackj;
    public boolean mEnabled;
    
    private a(Context paramContext)
    {
      AppMethodBeat.i(237955);
      this.ackj = new f.b(paramContext, "recovery_enable").iQF();
      this.mEnabled = this.ackj.getBoolean("enable", true);
      AppMethodBeat.o(237955);
    }
    
    public static a lS(Context paramContext)
    {
      AppMethodBeat.i(237939);
      paramContext = new a(paramContext);
      AppMethodBeat.o(237939);
      return paramContext;
    }
  }
  
  public static final class b
  {
    private static final long qPH;
    private final f ackj;
    long ackk;
    long ackl;
    long ackm;
    
    static
    {
      AppMethodBeat.i(237956);
      qPH = TimeUnit.DAYS.toMillis(1L) / 2L;
      AppMethodBeat.o(237956);
    }
    
    private b(Context paramContext)
    {
      AppMethodBeat.i(237948);
      this.ackj = new f.b(paramContext, "recovery_internal").iQF();
      this.ackm = this.ackj.getLong("internal_overheat_enable", 1L);
      this.ackk = this.ackj.getLong("internal_last_ui_launched", 0L);
      this.ackl = this.ackj.getLong("internal_ui_launch_interval", qPH);
      AppMethodBeat.o(237948);
    }
    
    public static b lT(Context paramContext)
    {
      AppMethodBeat.i(237938);
      paramContext = new b(paramContext);
      AppMethodBeat.o(237938);
      return paramContext;
    }
    
    public final void sz()
    {
      AppMethodBeat.i(237963);
      this.ackj.cm("internal_overheat_enable", this.ackm).cm("internal_last_ui_launched", this.ackk).cm("internal_ui_launch_interval", this.ackl).iQG();
      AppMethodBeat.o(237963);
    }
  }
  
  public static final class c
  {
    private final f ackj;
    public String ackn;
    private final Context mContext;
    
    private c(Context paramContext)
    {
      AppMethodBeat.i(237959);
      this.mContext = paramContext;
      this.ackj = new f.a(paramContext, "recovery_log").iQF();
      paramContext = new File(k.a.lX(paramContext), ".log").getAbsolutePath();
      String str = this.ackj.getString("setting_log_path", paramContext);
      try
      {
        k.a.b.K(new File(str));
        paramContext = str;
      }
      finally
      {
        for (;;)
        {
          this.ackj.btK("setting_log_path");
        }
      }
      this.ackn = paramContext;
      AppMethodBeat.o(237959);
    }
    
    public static c lU(Context paramContext)
    {
      AppMethodBeat.i(237951);
      paramContext = new c(paramContext);
      AppMethodBeat.o(237951);
      return paramContext;
    }
    
    public final void iQN()
    {
      AppMethodBeat.i(237967);
      k.b.a.M(new File(this.ackn));
      AppMethodBeat.o(237967);
    }
    
    /* Error */
    public final String iQO()
    {
      // Byte code:
      //   0: ldc 100
      //   2: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: new 44	java/io/File
      //   8: dup
      //   9: aload_0
      //   10: getfield 76	com/tencent/mm/recoveryv2/h$c:ackn	Ljava/lang/String;
      //   13: invokespecial 68	java/io/File:<init>	(Ljava/lang/String;)V
      //   16: astore_1
      //   17: aload_1
      //   18: invokevirtual 104	java/io/File:exists	()Z
      //   21: ifne +10 -> 31
      //   24: ldc 100
      //   26: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   29: aconst_null
      //   30: areturn
      //   31: new 106	java/lang/StringBuilder
      //   34: dup
      //   35: invokespecial 107	java/lang/StringBuilder:<init>	()V
      //   38: astore_3
      //   39: new 109	java/io/BufferedReader
      //   42: dup
      //   43: new 111	java/io/FileReader
      //   46: dup
      //   47: aload_1
      //   48: invokespecial 113	java/io/FileReader:<init>	(Ljava/io/File;)V
      //   51: invokespecial 116	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
      //   54: astore_2
      //   55: aload_2
      //   56: astore_1
      //   57: aload_2
      //   58: invokevirtual 119	java/io/BufferedReader:readLine	()Ljava/lang/String;
      //   61: astore 4
      //   63: aload 4
      //   65: ifnull +46 -> 111
      //   68: aload_2
      //   69: astore_1
      //   70: aload_3
      //   71: aload 4
      //   73: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   76: pop
      //   77: aload_2
      //   78: astore_1
      //   79: aload_3
      //   80: bipush 10
      //   82: invokevirtual 126	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
      //   85: pop
      //   86: goto -31 -> 55
      //   89: astore_3
      //   90: aload_2
      //   91: astore_1
      //   92: ldc 128
      //   94: ldc 130
      //   96: aload_3
      //   97: invokestatic 136	com/tencent/mm/recoveryv2/k$b:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   100: aload_2
      //   101: invokestatic 140	com/tencent/mm/recoveryv2/k$a$b:closeQuietly	(Ljava/lang/Object;)V
      //   104: ldc 100
      //   106: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   109: aconst_null
      //   110: areturn
      //   111: aload_2
      //   112: invokestatic 140	com/tencent/mm/recoveryv2/k$a$b:closeQuietly	(Ljava/lang/Object;)V
      //   115: aload_3
      //   116: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   119: astore_1
      //   120: ldc 100
      //   122: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   125: aload_1
      //   126: areturn
      //   127: astore_2
      //   128: aconst_null
      //   129: astore_1
      //   130: aload_1
      //   131: invokestatic 140	com/tencent/mm/recoveryv2/k$a$b:closeQuietly	(Ljava/lang/Object;)V
      //   134: ldc 100
      //   136: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.recoveryv2.h
 * JD-Core Version:    0.7.0.1
 */