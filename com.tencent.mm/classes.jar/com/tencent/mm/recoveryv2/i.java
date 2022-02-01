package com.tencent.mm.recoveryv2;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.concurrent.TimeUnit;

public final class i
{
  int UPm;
  int UPn;
  long UPo;
  long UPp;
  long UPq;
  long UPr;
  private h UPs;
  
  private i(Context paramContext)
  {
    AppMethodBeat.i(190182);
    this.UPs = new h.b(paramContext, "recovery_setting");
    this.UPs.hqf();
    this.UPm = Math.max(this.UPs.getInt("setting_threshold_1", 3), 2);
    this.UPn = Math.max(this.UPs.getInt("setting_threshold_2", 5), 3);
    if (this.UPn < this.UPm) {
      this.UPn = this.UPm;
    }
    this.UPo = Math.max(this.UPs.getLong("setting_crash_interval", 10000L), 5000L);
    this.UPp = Math.max(this.UPs.getLong("setting_crash_interval_sub", 30000L), 5000L);
    this.UPq = Math.max(this.UPs.getLong("setting_crash_minimal_interval", 1000L), 0L);
    this.UPr = Math.max(this.UPs.getLong("setting_reset_delay", 5000L), 1000L);
    AppMethodBeat.o(190182);
  }
  
  public static i jP(Context paramContext)
  {
    AppMethodBeat.i(190175);
    paramContext = new i(paramContext);
    AppMethodBeat.o(190175);
    return paramContext;
  }
  
  public final i Ug(long paramLong)
  {
    this.UPo = paramLong;
    return this;
  }
  
  public final i Uh(long paramLong)
  {
    this.UPp = paramLong;
    return this;
  }
  
  public final i Ui(long paramLong)
  {
    this.UPr = paramLong;
    return this;
  }
  
  public final i arH(int paramInt)
  {
    this.UPm = paramInt;
    return this;
  }
  
  public final i arI(int paramInt)
  {
    this.UPn = paramInt;
    return this;
  }
  
  public final void arg()
  {
    AppMethodBeat.i(190203);
    this.UPs.hu("setting_threshold_1", this.UPm).hu("setting_threshold_2", this.UPn).ca("setting_crash_interval", this.UPo).ca("setting_crash_interval_sub", this.UPp).ca("setting_crash_minimal_interval", this.UPq).ca("setting_reset_delay", this.UPr).hqg();
    AppMethodBeat.o(190203);
  }
  
  public final long hqn()
  {
    return this.UPo;
  }
  
  public final long hqo()
  {
    return this.UPp;
  }
  
  public final int hqp()
  {
    return this.UPm;
  }
  
  public final int hqq()
  {
    return this.UPn;
  }
  
  public final long hqr()
  {
    return this.UPr;
  }
  
  public final long hqs()
  {
    return this.UPq;
  }
  
  public final i hqt()
  {
    this.UPq = 0L;
    return this;
  }
  
  public static final class a
  {
    private final h UPs;
    boolean mEnabled;
    
    private a(Context paramContext)
    {
      AppMethodBeat.i(190144);
      this.UPs = new h.b(paramContext, "recovery_enable").hqf();
      this.mEnabled = this.UPs.getBoolean("enable", true);
      AppMethodBeat.o(190144);
    }
    
    public static a jQ(Context paramContext)
    {
      AppMethodBeat.i(190135);
      paramContext = new a(paramContext);
      AppMethodBeat.o(190135);
      return paramContext;
    }
    
    public final a Ez(boolean paramBoolean)
    {
      this.mEnabled = paramBoolean;
      return this;
    }
    
    public final void arg()
    {
      AppMethodBeat.i(190148);
      this.UPs.dp("enable", this.mEnabled).hqg();
      AppMethodBeat.o(190148);
    }
    
    public final boolean isEnabled()
    {
      return this.mEnabled;
    }
  }
  
  public static final class b
  {
    private static final long nPQ;
    private final h UPs;
    long UPt;
    long UPu;
    
    static
    {
      AppMethodBeat.i(190156);
      nPQ = TimeUnit.DAYS.toMillis(1L) / 2L;
      AppMethodBeat.o(190156);
    }
    
    private b(Context paramContext)
    {
      AppMethodBeat.i(190152);
      this.UPs = new h.b(paramContext, "recovery_internal").hqf();
      this.UPt = this.UPs.getLong("internal_last_ui_launched", 0L);
      this.UPu = this.UPs.getLong("internal_ui_launch_interval", nPQ);
      AppMethodBeat.o(190152);
    }
    
    public static b jR(Context paramContext)
    {
      AppMethodBeat.i(190150);
      paramContext = new b(paramContext);
      AppMethodBeat.o(190150);
      return paramContext;
    }
    
    public final void arg()
    {
      AppMethodBeat.i(190155);
      this.UPs.ca("internal_last_ui_launched", this.UPt).ca("internal_ui_launch_interval", this.UPu).hqg();
      AppMethodBeat.o(190155);
    }
  }
  
  public static final class c
  {
    private final h UPs;
    private String UPv;
    private final Context mContext;
    
    private c(Context paramContext)
    {
      AppMethodBeat.i(190166);
      this.mContext = paramContext;
      this.UPs = new h.a(paramContext, "recovery_log").hqf();
      paramContext = new File(m.jY(paramContext), ".log").getAbsolutePath();
      String str = this.UPs.getString("setting_log_path", paramContext);
      try
      {
        m.b.G(new File(str));
        paramContext = str;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          this.UPs.btT("setting_log_path");
        }
      }
      this.UPv = paramContext;
      AppMethodBeat.o(190166);
    }
    
    public static c jS(Context paramContext)
    {
      AppMethodBeat.i(190159);
      paramContext = new c(paramContext);
      AppMethodBeat.o(190159);
      return paramContext;
    }
    
    public final void hqu()
    {
      AppMethodBeat.i(190167);
      a.a.D(new File(this.UPv));
      AppMethodBeat.o(190167);
    }
    
    /* Error */
    public final String hqv()
    {
      // Byte code:
      //   0: ldc 102
      //   2: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: new 46	java/io/File
      //   8: dup
      //   9: aload_0
      //   10: getfield 78	com/tencent/mm/recoveryv2/i$c:UPv	Ljava/lang/String;
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
      //   101: invokestatic 142	com/tencent/mm/recoveryv2/m$b:closeQuietly	(Ljava/lang/Object;)V
      //   104: ldc 102
      //   106: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   109: aconst_null
      //   110: areturn
      //   111: aload_2
      //   112: invokestatic 142	com/tencent/mm/recoveryv2/m$b:closeQuietly	(Ljava/lang/Object;)V
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
      //   131: invokestatic 142	com/tencent/mm/recoveryv2/m$b:closeQuietly	(Ljava/lang/Object;)V
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
    
    public final void hqw()
    {
      AppMethodBeat.i(190170);
      m.b.E(new File(this.UPv));
      AppMethodBeat.o(190170);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.recoveryv2.i
 * JD-Core Version:    0.7.0.1
 */