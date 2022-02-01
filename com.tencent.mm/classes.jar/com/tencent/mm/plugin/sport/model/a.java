package com.tencent.mm.plugin.sport.model;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.us;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.bw;
import java.util.Calendar;

public final class a
{
  public c zoG;
  public com.tencent.mm.sdk.b.c<us> zoH;
  public f zoI;
  private long zoJ;
  long zoK;
  
  public a()
  {
    AppMethodBeat.i(149274);
    this.zoH = new com.tencent.mm.sdk.b.c() {};
    this.zoH.alive();
    this.zoG = new c();
    AppMethodBeat.o(149274);
  }
  
  public static long dTP()
  {
    AppMethodBeat.i(149280);
    long l1 = dTQ();
    if (com.tencent.mm.sdk.h.b.eWK()) {
      try
      {
        bool = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pRA, true);
        if (bool)
        {
          long l2 = l.dUp();
          if (l2 > l1)
          {
            ac.i("MicroMsg.Sport.DeviceStepManager", "getTodayStep MIUI Step %d %d", new Object[] { Long.valueOf(l2), Long.valueOf(l1) });
            AppMethodBeat.o(149280);
            return l2;
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          boolean bool = true;
        }
      }
    }
    AppMethodBeat.o(149280);
    return l1;
  }
  
  /* Error */
  private static long dTQ()
  {
    // Byte code:
    //   0: ldc 101
    //   2: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 106	java/lang/System:currentTimeMillis	()J
    //   8: lstore 4
    //   10: invokestatic 109	com/tencent/mm/plugin/sport/model/l:dUl	()J
    //   13: lstore 6
    //   15: aconst_null
    //   16: astore 9
    //   18: ldc 111
    //   20: invokestatic 117	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   23: astore 8
    //   25: invokestatic 123	com/tencent/mm/sdk/platformtools/ai:getContext	()Landroid/content/Context;
    //   28: invokevirtual 129	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   31: aload 8
    //   33: aconst_null
    //   34: ldc 131
    //   36: aconst_null
    //   37: aconst_null
    //   38: invokevirtual 137	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   41: astore 8
    //   43: aload 8
    //   45: astore 9
    //   47: aload 9
    //   49: ifnull +165 -> 214
    //   52: aload 9
    //   54: invokeinterface 143 1 0
    //   59: astore 8
    //   61: aload 8
    //   63: ldc 145
    //   65: ldc2_w 146
    //   68: invokevirtual 153	android/os/Bundle:getLong	(Ljava/lang/String;J)J
    //   71: lstore_0
    //   72: aload 8
    //   74: ldc 155
    //   76: lconst_0
    //   77: invokevirtual 153	android/os/Bundle:getLong	(Ljava/lang/String;J)J
    //   80: lload 6
    //   82: lcmp
    //   83: ifne +120 -> 203
    //   86: ldc 157
    //   88: astore 8
    //   90: aload 8
    //   92: astore 10
    //   94: lload_0
    //   95: lstore_2
    //   96: aload 9
    //   98: ifnull +224 -> 322
    //   101: aload 9
    //   103: invokeinterface 160 1 0
    //   108: lload_0
    //   109: lstore_2
    //   110: lload_2
    //   111: lstore_0
    //   112: lload_2
    //   113: ldc2_w 146
    //   116: lcmp
    //   117: ifne +44 -> 161
    //   120: invokestatic 166	com/tencent/mm/plugin/sport/model/k:dUh	()Ljava/lang/String;
    //   123: astore 8
    //   125: aload 8
    //   127: invokestatic 172	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
    //   130: ifne +162 -> 292
    //   133: aload 8
    //   135: invokestatic 176	com/tencent/mm/plugin/sport/model/l:awl	(Ljava/lang/String;)[J
    //   138: astore 8
    //   140: aload 8
    //   142: iconst_0
    //   143: laload
    //   144: lstore_2
    //   145: aload 8
    //   147: iconst_5
    //   148: laload
    //   149: lstore_0
    //   150: lload_2
    //   151: lload 6
    //   153: lcmp
    //   154: ifne +129 -> 283
    //   157: ldc 178
    //   159: astore 8
    //   161: ldc 87
    //   163: ldc 180
    //   165: iconst_3
    //   166: anewarray 4	java/lang/Object
    //   169: dup
    //   170: iconst_0
    //   171: aload 8
    //   173: aastore
    //   174: dup
    //   175: iconst_1
    //   176: lload_0
    //   177: invokestatic 95	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   180: aastore
    //   181: dup
    //   182: iconst_2
    //   183: invokestatic 106	java/lang/System:currentTimeMillis	()J
    //   186: lload 4
    //   188: lsub
    //   189: invokestatic 95	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   192: aastore
    //   193: invokestatic 100	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   196: ldc 101
    //   198: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   201: lload_0
    //   202: lreturn
    //   203: ldc2_w 146
    //   206: lstore_0
    //   207: ldc 182
    //   209: astore 8
    //   211: goto -121 -> 90
    //   214: ldc2_w 146
    //   217: lstore_0
    //   218: ldc 182
    //   220: astore 8
    //   222: goto -132 -> 90
    //   225: astore 8
    //   227: aconst_null
    //   228: astore 9
    //   230: ldc2_w 146
    //   233: lstore_2
    //   234: ldc 182
    //   236: astore 8
    //   238: aload 8
    //   240: astore 10
    //   242: aload 9
    //   244: ifnull +78 -> 322
    //   247: aload 9
    //   249: invokeinterface 160 1 0
    //   254: ldc2_w 146
    //   257: lstore_2
    //   258: goto -148 -> 110
    //   261: astore 8
    //   263: aload 9
    //   265: ifnull +10 -> 275
    //   268: aload 9
    //   270: invokeinterface 160 1 0
    //   275: ldc 101
    //   277: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   280: aload 8
    //   282: athrow
    //   283: ldc 182
    //   285: astore 8
    //   287: lconst_0
    //   288: lstore_0
    //   289: goto -128 -> 161
    //   292: ldc 182
    //   294: astore 8
    //   296: lconst_0
    //   297: lstore_0
    //   298: goto -137 -> 161
    //   301: astore 8
    //   303: ldc 182
    //   305: astore 8
    //   307: lconst_0
    //   308: lstore_0
    //   309: goto -148 -> 161
    //   312: astore 8
    //   314: goto -51 -> 263
    //   317: astore 8
    //   319: goto -89 -> 230
    //   322: aload 10
    //   324: astore 8
    //   326: goto -216 -> 110
    // Local variable table:
    //   start	length	slot	name	signature
    //   71	238	0	l1	long
    //   95	163	2	l2	long
    //   8	179	4	l3	long
    //   13	139	6	l4	long
    //   23	198	8	localObject1	Object
    //   225	1	8	localException1	Exception
    //   236	3	8	str1	String
    //   261	20	8	localObject2	Object
    //   285	10	8	str2	String
    //   301	1	8	localException2	Exception
    //   305	1	8	str3	String
    //   312	1	8	localObject3	Object
    //   317	1	8	localException3	Exception
    //   324	1	8	localObject4	Object
    //   16	253	9	localObject5	Object
    //   92	231	10	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   18	43	225	java/lang/Exception
    //   18	43	261	finally
    //   120	140	301	java/lang/Exception
    //   52	86	312	finally
    //   52	86	317	java/lang/Exception
  }
  
  private void ya(long paramLong)
  {
    AppMethodBeat.i(149278);
    this.zoJ = paramLong;
    k.aw(4, this.zoJ);
    AppMethodBeat.o(149278);
  }
  
  private void yb(long paramLong)
  {
    AppMethodBeat.i(149279);
    this.zoK = paramLong;
    k.aw(3, paramLong);
    AppMethodBeat.o(149279);
  }
  
  public final void awh(String paramString)
  {
    AppMethodBeat.i(149282);
    h.JZN.f(new a.2(this, paramString), "Sport.updateConfigToPush");
    AppMethodBeat.o(149282);
  }
  
  public final void dTN()
  {
    AppMethodBeat.i(149275);
    long l = dTP();
    ac.i("MicroMsg.Sport.DeviceStepManager", "forceUploadDeviceStep %d", new Object[] { Long.valueOf(l) });
    xZ(l);
    AppMethodBeat.o(149275);
  }
  
  public final long dTO()
  {
    AppMethodBeat.i(149277);
    if (this.zoJ == 0L) {
      this.zoJ = k.av(4, 0L);
    }
    long l = this.zoJ;
    AppMethodBeat.o(149277);
    return l;
  }
  
  final boolean xZ(long paramLong)
  {
    AppMethodBeat.i(149276);
    if (this.zoI != null) {
      g.agi().a(this.zoI);
    }
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    long l1 = localCalendar.getTimeInMillis();
    long l2 = System.currentTimeMillis();
    ac.i("MicroMsg.Sport.DeviceStepManager", "update device Step time: %s stepCount: %s", new Object[] { l.qn(l2), Long.valueOf(paramLong) });
    this.zoI = new f("", "gh_43f2581f6fd6", (int)(l1 / 1000L), (int)(l2 / 1000L), (int)paramLong, bw.fcC(), 1);
    g.agi().a(this.zoI, 0);
    yb(System.currentTimeMillis());
    ya(paramLong);
    AppMethodBeat.o(149276);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.model.a
 * JD-Core Version:    0.7.0.1
 */