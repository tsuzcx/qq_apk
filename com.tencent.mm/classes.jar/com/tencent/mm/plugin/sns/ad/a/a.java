package com.tencent.mm.plugin.sns.ad.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.e.c;
import com.tencent.mm.plugin.sns.ad.e.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import org.json.JSONObject;

public final class a
{
  public static String aaC()
  {
    AppMethodBeat.i(221436);
    String str = "";
    if (e.ftm()) {
      str = c.aaC();
    }
    AppMethodBeat.o(221436);
    return str;
  }
  
  /* Error */
  public static String dRf()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_0
    //   2: ldc 2
    //   4: monitorenter
    //   5: ldc 34
    //   7: invokestatic 16	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: new 6	com/tencent/mm/plugin/sns/ad/a/a$a
    //   13: dup
    //   14: invokespecial 38	com/tencent/mm/plugin/sns/ad/a/a$a:<init>	()V
    //   17: astore 5
    //   19: invokestatic 44	java/lang/System:currentTimeMillis	()J
    //   22: lstore_1
    //   23: invokestatic 24	com/tencent/mm/plugin/sns/ad/e/e:ftm	()Z
    //   26: ifeq +11 -> 37
    //   29: aload 5
    //   31: invokestatic 28	com/tencent/mm/plugin/sns/ad/e/c:aaC	()Ljava/lang/String;
    //   34: putfield 48	com/tencent/mm/plugin/sns/ad/a/a$a:yWM	Ljava/lang/String;
    //   37: invokestatic 51	com/tencent/mm/plugin/sns/ad/e/e:ftn	()Z
    //   40: ifeq +97 -> 137
    //   43: aload 5
    //   45: invokestatic 54	com/tencent/mm/plugin/sns/ad/e/c:dSb	()Ljava/lang/String;
    //   48: putfield 57	com/tencent/mm/plugin/sns/ad/a/a$a:yWN	Ljava/lang/String;
    //   51: aload 5
    //   53: invokestatic 60	com/tencent/mm/plugin/sns/ad/e/c:getDeviceId	()Ljava/lang/String;
    //   56: putfield 63	com/tencent/mm/plugin/sns/ad/a/a$a:cUi	Ljava/lang/String;
    //   59: aload 5
    //   61: iconst_0
    //   62: invokestatic 66	com/tencent/mm/plugin/sns/ad/e/c:getDeviceId	(I)Ljava/lang/String;
    //   65: putfield 69	com/tencent/mm/plugin/sns/ad/a/a$a:yWO	Ljava/lang/String;
    //   68: aload 5
    //   70: iconst_1
    //   71: invokestatic 66	com/tencent/mm/plugin/sns/ad/e/c:getDeviceId	(I)Ljava/lang/String;
    //   74: putfield 72	com/tencent/mm/plugin/sns/ad/a/a$a:yWP	Ljava/lang/String;
    //   77: aload 5
    //   79: invokestatic 75	com/tencent/mm/plugin/sns/ad/e/c:aar	()Ljava/lang/String;
    //   82: putfield 78	com/tencent/mm/plugin/sns/ad/a/a$a:imei	Ljava/lang/String;
    //   85: aload 5
    //   87: iconst_0
    //   88: invokestatic 81	com/tencent/mm/plugin/sns/ad/e/c:PC	(I)Ljava/lang/String;
    //   91: putfield 84	com/tencent/mm/plugin/sns/ad/a/a$a:yWQ	Ljava/lang/String;
    //   94: aload 5
    //   96: iconst_1
    //   97: invokestatic 81	com/tencent/mm/plugin/sns/ad/e/c:PC	(I)Ljava/lang/String;
    //   100: putfield 87	com/tencent/mm/plugin/sns/ad/a/a$a:yWR	Ljava/lang/String;
    //   103: aload 5
    //   105: invokestatic 90	com/tencent/mm/plugin/sns/ad/e/c:dSa	()Ljava/lang/String;
    //   108: putfield 93	com/tencent/mm/plugin/sns/ad/a/a$a:yWS	Ljava/lang/String;
    //   111: aload 5
    //   113: iconst_0
    //   114: invokestatic 96	com/tencent/mm/plugin/sns/ad/e/c:PD	(I)Ljava/lang/String;
    //   117: putfield 99	com/tencent/mm/plugin/sns/ad/a/a$a:yWT	Ljava/lang/String;
    //   120: aload 5
    //   122: iconst_1
    //   123: invokestatic 96	com/tencent/mm/plugin/sns/ad/e/c:PD	(I)Ljava/lang/String;
    //   126: putfield 102	com/tencent/mm/plugin/sns/ad/a/a$a:yWU	Ljava/lang/String;
    //   129: aload 5
    //   131: invokestatic 105	com/tencent/mm/plugin/sns/ad/e/c:aas	()Ljava/lang/String;
    //   134: putfield 108	com/tencent/mm/plugin/sns/ad/a/a$a:yWV	Ljava/lang/String;
    //   137: invokestatic 111	com/tencent/mm/plugin/sns/ad/e/e:fto	()Z
    //   140: ifeq +11 -> 151
    //   143: aload 5
    //   145: invokestatic 114	com/tencent/mm/plugin/sns/ad/e/c:dSe	()Ljava/lang/String;
    //   148: putfield 117	com/tencent/mm/plugin/sns/ad/a/a$a:uuid	Ljava/lang/String;
    //   151: invokestatic 120	com/tencent/mm/plugin/sns/ad/e/e:ftl	()Z
    //   154: ifeq +11 -> 165
    //   157: aload 5
    //   159: invokestatic 123	com/tencent/mm/plugin/sns/ad/e/c:getAndroidId	()Ljava/lang/String;
    //   162: putfield 126	com/tencent/mm/plugin/sns/ad/a/a$a:androidId	Ljava/lang/String;
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
    //   189: invokestatic 148	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   192: aload 5
    //   194: invokevirtual 151	com/tencent/mm/plugin/sns/ad/a/a$a:dRh	()Ljava/lang/String;
    //   197: invokestatic 157	com/tencent/mm/sdk/platformtools/bt:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
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
    //   229: invokestatic 164	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
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
  
  public static String dRg()
  {
    try
    {
      AppMethodBeat.i(213125);
      String str = c.dSe();
      AppMethodBeat.o(213125);
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String ftk()
  {
    AppMethodBeat.i(221437);
    String str = "";
    if (e.ftn()) {
      str = c.dSb();
    }
    AppMethodBeat.o(221437);
    return str;
  }
  
  public static final class a
  {
    String androidId;
    String cUi;
    String imei;
    String uuid;
    String yWM;
    String yWN;
    String yWO;
    String yWP;
    String yWQ;
    String yWR;
    String yWS;
    String yWT;
    String yWU;
    String yWV;
    
    final String dRh()
    {
      AppMethodBeat.i(213122);
      try
      {
        long l1 = System.currentTimeMillis();
        Object localObject = new JSONObject();
        if (!bt.isNullOrNil(this.yWM)) {
          ((JSONObject)localObject).put("oaid", this.yWM);
        }
        if (!bt.isNullOrNil(this.yWN)) {
          ((JSONObject)localObject).put("imeiWx", this.yWN);
        }
        if (!bt.isNullOrNil(this.cUi)) {
          ((JSONObject)localObject).put("deviceId", this.cUi);
        }
        if (!bt.isNullOrNil(this.yWO)) {
          ((JSONObject)localObject).put("deviceId0", this.yWO);
        }
        if (!bt.isNullOrNil(this.yWP)) {
          ((JSONObject)localObject).put("deviceId1", this.yWP);
        }
        if (!bt.isNullOrNil(this.imei)) {
          ((JSONObject)localObject).put("imei", this.imei);
        }
        if (!bt.isNullOrNil(this.yWQ)) {
          ((JSONObject)localObject).put("imei0", this.yWQ);
        }
        if (!bt.isNullOrNil(this.yWR)) {
          ((JSONObject)localObject).put("imei1", this.yWR);
        }
        if (!bt.isNullOrNil(this.yWS)) {
          ((JSONObject)localObject).put("meid", this.yWS);
        }
        if (!bt.isNullOrNil(this.yWT)) {
          ((JSONObject)localObject).put("meid0", this.yWT);
        }
        if (!bt.isNullOrNil(this.yWU)) {
          ((JSONObject)localObject).put("meid1", this.yWU);
        }
        if (!bt.isNullOrNil(this.yWV)) {
          ((JSONObject)localObject).put("subscriberId", this.yWV);
        }
        if (!bt.isNullOrNil(this.uuid)) {
          ((JSONObject)localObject).put("uuid", this.uuid);
        }
        if (!bt.isNullOrNil(this.androidId)) {
          ((JSONObject)localObject).put("androidId", this.androidId);
        }
        localObject = ((JSONObject)localObject).toString();
        long l2 = System.currentTimeMillis();
        ad.d("AdDeviceInfo", "buildPartDeviceInfo, timeCost = " + (l2 - l1) + ", ret = " + (String)localObject);
        AppMethodBeat.o(213122);
        return localObject;
      }
      catch (Throwable localThrowable)
      {
        ad.e("AdDeviceInfo", localThrowable.toString());
        AppMethodBeat.o(213122);
      }
      return "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.a.a
 * JD-Core Version:    0.7.0.1
 */