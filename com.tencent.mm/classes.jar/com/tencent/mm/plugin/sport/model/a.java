package com.tencent.mm.plugin.sport.model;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.wp;
import com.tencent.mm.g.a.wp.a;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.WeChatAuthorities;
import com.tencent.mm.sdk.vendor.MIUI;
import com.tencent.mm.storage.ck;
import java.util.Calendar;

public final class a
{
  public c FiX;
  public IListener<wp> FiY;
  public e FiZ;
  private long Fja;
  long Fjb;
  
  public a()
  {
    AppMethodBeat.i(149274);
    this.FiY = new IListener() {};
    this.FiY.alive();
    this.FiX = new c();
    AppMethodBeat.o(149274);
  }
  
  private void Kb(long paramLong)
  {
    AppMethodBeat.i(149278);
    this.Fja = paramLong;
    j.aK(4, this.Fja);
    AppMethodBeat.o(149278);
  }
  
  private void Kc(long paramLong)
  {
    AppMethodBeat.i(149279);
    this.Fjb = paramLong;
    j.aK(3, paramLong);
    AppMethodBeat.o(149279);
  }
  
  public static long fml()
  {
    AppMethodBeat.i(149280);
    long l1 = fmm();
    if (MIUI.ifMIUI()) {
      try
      {
        bool = ((b)com.tencent.mm.kernel.g.af(b.class)).a(b.a.rVP, true);
        if (bool)
        {
          long l2 = k.fmL();
          if (l2 > l1)
          {
            Log.i("MicroMsg.Sport.DeviceStepManager", "getTodayStep MIUI Step %d %d", new Object[] { Long.valueOf(l2), Long.valueOf(l1) });
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
  private static long fmm()
  {
    // Byte code:
    //   0: ldc 122
    //   2: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 127	java/lang/System:currentTimeMillis	()J
    //   8: lstore 4
    //   10: invokestatic 130	com/tencent/mm/plugin/sport/model/k:fmH	()J
    //   13: lstore 6
    //   15: aconst_null
    //   16: astore 9
    //   18: new 132	java/lang/StringBuilder
    //   21: dup
    //   22: ldc 134
    //   24: invokespecial 137	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   27: invokestatic 143	com/tencent/mm/sdk/platformtools/WeChatAuthorities:AUTHORITIES_PLUGIN_SPORT	()Ljava/lang/String;
    //   30: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: invokestatic 156	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   39: astore 8
    //   41: invokestatic 162	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   44: invokevirtual 168	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   47: aload 8
    //   49: aconst_null
    //   50: ldc 170
    //   52: aconst_null
    //   53: aconst_null
    //   54: invokevirtual 176	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   57: astore 8
    //   59: aload 8
    //   61: astore 9
    //   63: aload 9
    //   65: ifnull +165 -> 230
    //   68: aload 9
    //   70: invokeinterface 182 1 0
    //   75: astore 8
    //   77: aload 8
    //   79: ldc 184
    //   81: ldc2_w 185
    //   84: invokevirtual 192	android/os/Bundle:getLong	(Ljava/lang/String;J)J
    //   87: lstore_0
    //   88: aload 8
    //   90: ldc 194
    //   92: lconst_0
    //   93: invokevirtual 192	android/os/Bundle:getLong	(Ljava/lang/String;J)J
    //   96: lload 6
    //   98: lcmp
    //   99: ifne +120 -> 219
    //   102: ldc 196
    //   104: astore 8
    //   106: aload 8
    //   108: astore 10
    //   110: lload_0
    //   111: lstore_2
    //   112: aload 9
    //   114: ifnull +224 -> 338
    //   117: aload 9
    //   119: invokeinterface 199 1 0
    //   124: lload_0
    //   125: lstore_2
    //   126: lload_2
    //   127: lstore_0
    //   128: lload_2
    //   129: ldc2_w 185
    //   132: lcmp
    //   133: ifne +44 -> 177
    //   136: invokestatic 202	com/tencent/mm/plugin/sport/model/j:fmD	()Ljava/lang/String;
    //   139: astore 8
    //   141: aload 8
    //   143: invokestatic 208	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   146: ifne +162 -> 308
    //   149: aload 8
    //   151: invokestatic 212	com/tencent/mm/plugin/sport/model/k:aRG	(Ljava/lang/String;)[J
    //   154: astore 8
    //   156: aload 8
    //   158: iconst_0
    //   159: laload
    //   160: lstore_2
    //   161: aload 8
    //   163: iconst_5
    //   164: laload
    //   165: lstore_0
    //   166: lload_2
    //   167: lload 6
    //   169: lcmp
    //   170: ifne +129 -> 299
    //   173: ldc 214
    //   175: astore 8
    //   177: ldc 108
    //   179: ldc 216
    //   181: iconst_3
    //   182: anewarray 4	java/lang/Object
    //   185: dup
    //   186: iconst_0
    //   187: aload 8
    //   189: aastore
    //   190: dup
    //   191: iconst_1
    //   192: lload_0
    //   193: invokestatic 116	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   196: aastore
    //   197: dup
    //   198: iconst_2
    //   199: invokestatic 127	java/lang/System:currentTimeMillis	()J
    //   202: lload 4
    //   204: lsub
    //   205: invokestatic 116	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   208: aastore
    //   209: invokestatic 121	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   212: ldc 122
    //   214: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   217: lload_0
    //   218: lreturn
    //   219: ldc2_w 185
    //   222: lstore_0
    //   223: ldc 218
    //   225: astore 8
    //   227: goto -121 -> 106
    //   230: ldc2_w 185
    //   233: lstore_0
    //   234: ldc 218
    //   236: astore 8
    //   238: goto -132 -> 106
    //   241: astore 8
    //   243: aconst_null
    //   244: astore 9
    //   246: ldc2_w 185
    //   249: lstore_2
    //   250: ldc 218
    //   252: astore 8
    //   254: aload 8
    //   256: astore 10
    //   258: aload 9
    //   260: ifnull +78 -> 338
    //   263: aload 9
    //   265: invokeinterface 199 1 0
    //   270: ldc2_w 185
    //   273: lstore_2
    //   274: goto -148 -> 126
    //   277: astore 8
    //   279: aload 9
    //   281: ifnull +10 -> 291
    //   284: aload 9
    //   286: invokeinterface 199 1 0
    //   291: ldc 122
    //   293: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   296: aload 8
    //   298: athrow
    //   299: ldc 218
    //   301: astore 8
    //   303: lconst_0
    //   304: lstore_0
    //   305: goto -128 -> 177
    //   308: ldc 218
    //   310: astore 8
    //   312: lconst_0
    //   313: lstore_0
    //   314: goto -137 -> 177
    //   317: astore 8
    //   319: ldc 218
    //   321: astore 8
    //   323: lconst_0
    //   324: lstore_0
    //   325: goto -148 -> 177
    //   328: astore 8
    //   330: goto -51 -> 279
    //   333: astore 8
    //   335: goto -89 -> 246
    //   338: aload 10
    //   340: astore 8
    //   342: goto -216 -> 126
    // Local variable table:
    //   start	length	slot	name	signature
    //   87	238	0	l1	long
    //   111	163	2	l2	long
    //   8	195	4	l3	long
    //   13	155	6	l4	long
    //   39	198	8	localObject1	Object
    //   241	1	8	localException1	Exception
    //   252	3	8	str1	String
    //   277	20	8	localObject2	Object
    //   301	10	8	str2	String
    //   317	1	8	localException2	Exception
    //   321	1	8	str3	String
    //   328	1	8	localObject3	Object
    //   333	1	8	localException3	Exception
    //   340	1	8	localObject4	Object
    //   16	269	9	localObject5	Object
    //   108	231	10	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   18	59	241	java/lang/Exception
    //   18	59	277	finally
    //   136	156	317	java/lang/Exception
    //   68	102	328	finally
    //   68	102	333	java/lang/Exception
  }
  
  final boolean Ka(long paramLong)
  {
    AppMethodBeat.i(149276);
    if (this.FiZ != null) {
      com.tencent.mm.kernel.g.azz().a(this.FiZ);
    }
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    long l1 = localCalendar.getTimeInMillis();
    long l2 = System.currentTimeMillis();
    Log.i("MicroMsg.Sport.DeviceStepManager", "update device Step time: %s stepCount: %s", new Object[] { k.AF(l2), Long.valueOf(paramLong) });
    this.FiZ = new e("", "gh_43f2581f6fd6", (int)(l1 / 1000L), (int)(l2 / 1000L), (int)paramLong, ck.getFingerprint(), 1);
    com.tencent.mm.kernel.g.azz().a(this.FiZ, 0);
    Kc(System.currentTimeMillis());
    Kb(paramLong);
    AppMethodBeat.o(149276);
    return true;
  }
  
  public final void aRC(final String paramString)
  {
    AppMethodBeat.i(149282);
    h.RTc.b(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(149272);
        try
        {
          Uri localUri = Uri.parse("content://" + WeChatAuthorities.AUTHORITIES_PLUGIN_SPORT());
          MMApplicationContext.getContext().getContentResolver().query(localUri, null, "updateConfig", new String[] { paramString }, null);
          AppMethodBeat.o(149272);
          return;
        }
        catch (Exception localException)
        {
          AppMethodBeat.o(149272);
        }
      }
    }, "Sport.updateConfigToPush");
    AppMethodBeat.o(149282);
  }
  
  public final void fmj()
  {
    AppMethodBeat.i(149275);
    long l = fml();
    Log.i("MicroMsg.Sport.DeviceStepManager", "forceUploadDeviceStep %d", new Object[] { Long.valueOf(l) });
    Ka(l);
    AppMethodBeat.o(149275);
  }
  
  public final long fmk()
  {
    AppMethodBeat.i(149277);
    if (this.Fja == 0L) {
      this.Fja = j.aJ(4, 0L);
    }
    long l = this.Fja;
    AppMethodBeat.o(149277);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.model.a
 * JD-Core Version:    0.7.0.1
 */