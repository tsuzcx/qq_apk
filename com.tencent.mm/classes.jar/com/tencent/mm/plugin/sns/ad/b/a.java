package com.tencent.mm.plugin.sns.ad.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.i.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class a
{
  public static String aoK()
  {
    AppMethodBeat.i(192741);
    String str = "";
    if (com.tencent.mm.plugin.sns.ad.i.a.eYf()) {
      str = f.aoK();
    }
    AppMethodBeat.o(192741);
    return str;
  }
  
  /* Error */
  public static String eWC()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_0
    //   2: ldc 2
    //   4: monitorenter
    //   5: ldc 34
    //   7: invokestatic 16	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: new 6	com/tencent/mm/plugin/sns/ad/b/a$a
    //   13: dup
    //   14: invokespecial 38	com/tencent/mm/plugin/sns/ad/b/a$a:<init>	()V
    //   17: astore 5
    //   19: invokestatic 44	java/lang/System:currentTimeMillis	()J
    //   22: lstore_1
    //   23: invokestatic 24	com/tencent/mm/plugin/sns/ad/i/a:eYf	()Z
    //   26: ifeq +11 -> 37
    //   29: aload 5
    //   31: invokestatic 28	com/tencent/mm/plugin/sns/ad/i/f:aoK	()Ljava/lang/String;
    //   34: putfield 48	com/tencent/mm/plugin/sns/ad/b/a$a:Dsg	Ljava/lang/String;
    //   37: invokestatic 51	com/tencent/mm/plugin/sns/ad/i/a:eYg	()Z
    //   40: ifeq +97 -> 137
    //   43: aload 5
    //   45: invokestatic 54	com/tencent/mm/plugin/sns/ad/i/f:eYj	()Ljava/lang/String;
    //   48: putfield 57	com/tencent/mm/plugin/sns/ad/b/a$a:Dsh	Ljava/lang/String;
    //   51: aload 5
    //   53: invokestatic 60	com/tencent/mm/plugin/sns/ad/i/f:getDeviceId	()Ljava/lang/String;
    //   56: putfield 63	com/tencent/mm/plugin/sns/ad/b/a$a:dGL	Ljava/lang/String;
    //   59: aload 5
    //   61: iconst_0
    //   62: invokestatic 66	com/tencent/mm/plugin/sns/ad/i/f:getDeviceId	(I)Ljava/lang/String;
    //   65: putfield 69	com/tencent/mm/plugin/sns/ad/b/a$a:Dsi	Ljava/lang/String;
    //   68: aload 5
    //   70: iconst_1
    //   71: invokestatic 66	com/tencent/mm/plugin/sns/ad/i/f:getDeviceId	(I)Ljava/lang/String;
    //   74: putfield 72	com/tencent/mm/plugin/sns/ad/b/a$a:Dsj	Ljava/lang/String;
    //   77: aload 5
    //   79: invokestatic 75	com/tencent/mm/plugin/sns/ad/i/f:aoz	()Ljava/lang/String;
    //   82: putfield 78	com/tencent/mm/plugin/sns/ad/b/a$a:imei	Ljava/lang/String;
    //   85: aload 5
    //   87: iconst_0
    //   88: invokestatic 81	com/tencent/mm/plugin/sns/ad/i/f:XT	(I)Ljava/lang/String;
    //   91: putfield 84	com/tencent/mm/plugin/sns/ad/b/a$a:Dsk	Ljava/lang/String;
    //   94: aload 5
    //   96: iconst_1
    //   97: invokestatic 81	com/tencent/mm/plugin/sns/ad/i/f:XT	(I)Ljava/lang/String;
    //   100: putfield 87	com/tencent/mm/plugin/sns/ad/b/a$a:Dsl	Ljava/lang/String;
    //   103: aload 5
    //   105: invokestatic 90	com/tencent/mm/plugin/sns/ad/i/f:eYi	()Ljava/lang/String;
    //   108: putfield 93	com/tencent/mm/plugin/sns/ad/b/a$a:Dsm	Ljava/lang/String;
    //   111: aload 5
    //   113: iconst_0
    //   114: invokestatic 96	com/tencent/mm/plugin/sns/ad/i/f:XU	(I)Ljava/lang/String;
    //   117: putfield 99	com/tencent/mm/plugin/sns/ad/b/a$a:Dsn	Ljava/lang/String;
    //   120: aload 5
    //   122: iconst_1
    //   123: invokestatic 96	com/tencent/mm/plugin/sns/ad/i/f:XU	(I)Ljava/lang/String;
    //   126: putfield 102	com/tencent/mm/plugin/sns/ad/b/a$a:Dso	Ljava/lang/String;
    //   129: aload 5
    //   131: invokestatic 105	com/tencent/mm/plugin/sns/ad/i/f:aoA	()Ljava/lang/String;
    //   134: putfield 108	com/tencent/mm/plugin/sns/ad/b/a$a:Dsp	Ljava/lang/String;
    //   137: invokestatic 111	com/tencent/mm/plugin/sns/ad/i/a:eYh	()Z
    //   140: ifeq +11 -> 151
    //   143: aload 5
    //   145: invokestatic 114	com/tencent/mm/plugin/sns/ad/i/f:eYl	()Ljava/lang/String;
    //   148: putfield 117	com/tencent/mm/plugin/sns/ad/b/a$a:uuid	Ljava/lang/String;
    //   151: invokestatic 120	com/tencent/mm/plugin/sns/ad/i/a:eYe	()Z
    //   154: ifeq +11 -> 165
    //   157: aload 5
    //   159: invokestatic 123	com/tencent/mm/plugin/sns/ad/i/f:getAndroidId	()Ljava/lang/String;
    //   162: putfield 126	com/tencent/mm/plugin/sns/ad/b/a$a:androidId	Ljava/lang/String;
    //   165: invokestatic 44	java/lang/System:currentTimeMillis	()J
    //   168: lstore_3
    //   169: ldc 128
    //   171: new 130	java/lang/StringBuilder
    //   174: dup
    //   175: ldc 132
    //   177: invokespecial 135	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   180: lload_3
    //   181: lload_1
    //   182: lsub
    //   183: invokevirtual 139	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   186: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   189: invokestatic 148	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   192: aload 5
    //   194: invokevirtual 151	com/tencent/mm/plugin/sns/ad/b/a$a:eWF	()Ljava/lang/String;
    //   197: invokestatic 157	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   200: astore 5
    //   202: new 130	java/lang/StringBuilder
    //   205: dup
    //   206: ldc 159
    //   208: invokespecial 135	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   211: astore 6
    //   213: aload 5
    //   215: ifnonnull +28 -> 243
    //   218: ldc 128
    //   220: aload 6
    //   222: iload_0
    //   223: invokevirtual 162	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   226: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   229: invokestatic 164	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   232: ldc 34
    //   234: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   237: ldc 2
    //   239: monitorexit
    //   240: aload 5
    //   242: areturn
    //   243: aload 5
    //   245: invokevirtual 170	java/lang/String:length	()I
    //   248: istore_0
    //   249: goto -31 -> 218
    //   252: astore 5
    //   254: ldc 2
    //   256: monitorexit
    //   257: aload 5
    //   259: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   1	248	0	i	int
    //   22	160	1	l1	long
    //   168	13	3	l2	long
    //   17	227	5	localObject1	Object
    //   252	6	5	localObject2	Object
    //   211	10	6	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   5	37	252	finally
    //   37	137	252	finally
    //   137	151	252	finally
    //   151	165	252	finally
    //   165	213	252	finally
    //   218	237	252	finally
    //   243	249	252	finally
  }
  
  public static String eWD()
  {
    try
    {
      AppMethodBeat.i(192740);
      String str = f.eYl();
      AppMethodBeat.o(192740);
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String eWE()
  {
    AppMethodBeat.i(192742);
    String str = "";
    if (com.tencent.mm.plugin.sns.ad.i.a.eYg()) {
      str = f.eYj();
    }
    AppMethodBeat.o(192742);
    return str;
  }
  
  public static final class a
  {
    String Dsg;
    String Dsh;
    String Dsi;
    String Dsj;
    String Dsk;
    String Dsl;
    String Dsm;
    String Dsn;
    String Dso;
    String Dsp;
    String androidId;
    String dGL;
    String imei;
    String uuid;
    
    final String eWF()
    {
      AppMethodBeat.i(192738);
      try
      {
        long l1 = System.currentTimeMillis();
        Object localObject = new JSONObject();
        if (!Util.isNullOrNil(this.Dsg)) {
          ((JSONObject)localObject).put("oaid", this.Dsg);
        }
        if (!Util.isNullOrNil(this.Dsh)) {
          ((JSONObject)localObject).put("imeiWx", this.Dsh);
        }
        if (!Util.isNullOrNil(this.dGL)) {
          ((JSONObject)localObject).put("deviceId", this.dGL);
        }
        if (!Util.isNullOrNil(this.Dsi)) {
          ((JSONObject)localObject).put("deviceId0", this.Dsi);
        }
        if (!Util.isNullOrNil(this.Dsj)) {
          ((JSONObject)localObject).put("deviceId1", this.Dsj);
        }
        if (!Util.isNullOrNil(this.imei)) {
          ((JSONObject)localObject).put("imei", this.imei);
        }
        if (!Util.isNullOrNil(this.Dsk)) {
          ((JSONObject)localObject).put("imei0", this.Dsk);
        }
        if (!Util.isNullOrNil(this.Dsl)) {
          ((JSONObject)localObject).put("imei1", this.Dsl);
        }
        if (!Util.isNullOrNil(this.Dsm)) {
          ((JSONObject)localObject).put("meid", this.Dsm);
        }
        if (!Util.isNullOrNil(this.Dsn)) {
          ((JSONObject)localObject).put("meid0", this.Dsn);
        }
        if (!Util.isNullOrNil(this.Dso)) {
          ((JSONObject)localObject).put("meid1", this.Dso);
        }
        if (!Util.isNullOrNil(this.Dsp)) {
          ((JSONObject)localObject).put("subscriberId", this.Dsp);
        }
        if (!Util.isNullOrNil(this.uuid)) {
          ((JSONObject)localObject).put("uuid", this.uuid);
        }
        if (!Util.isNullOrNil(this.androidId)) {
          ((JSONObject)localObject).put("androidId", this.androidId);
        }
        localObject = ((JSONObject)localObject).toString();
        long l2 = System.currentTimeMillis();
        Log.d("AdDeviceInfo", "buildPartDeviceInfo, timeCost = " + (l2 - l1) + ", ret = " + (String)localObject);
        AppMethodBeat.o(192738);
        return localObject;
      }
      catch (Throwable localThrowable)
      {
        Log.e("AdDeviceInfo", localThrowable.toString());
        AppMethodBeat.o(192738);
      }
      return "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.b.a
 * JD-Core Version:    0.7.0.1
 */