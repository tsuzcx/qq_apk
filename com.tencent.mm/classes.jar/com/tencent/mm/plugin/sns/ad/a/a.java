package com.tencent.mm.plugin.sns.ad.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.i.b;
import com.tencent.mm.plugin.sns.ad.i.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class a
{
  public static String auQ()
  {
    AppMethodBeat.i(261230);
    String str = "";
    if (b.fLN()) {
      str = g.auQ();
    }
    AppMethodBeat.o(261230);
    return str;
  }
  
  /* Error */
  public static String fJF()
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
    //   23: invokestatic 24	com/tencent/mm/plugin/sns/ad/i/b:fLN	()Z
    //   26: ifeq +11 -> 37
    //   29: aload 5
    //   31: invokestatic 28	com/tencent/mm/plugin/sns/ad/i/g:auQ	()Ljava/lang/String;
    //   34: putfield 48	com/tencent/mm/plugin/sns/ad/a/a$a:JyL	Ljava/lang/String;
    //   37: invokestatic 51	com/tencent/mm/plugin/sns/ad/i/b:fLO	()Z
    //   40: ifeq +97 -> 137
    //   43: aload 5
    //   45: invokestatic 54	com/tencent/mm/plugin/sns/ad/i/g:fLS	()Ljava/lang/String;
    //   48: putfield 57	com/tencent/mm/plugin/sns/ad/a/a$a:JyM	Ljava/lang/String;
    //   51: aload 5
    //   53: invokestatic 60	com/tencent/mm/plugin/sns/ad/i/g:getDeviceId	()Ljava/lang/String;
    //   56: putfield 63	com/tencent/mm/plugin/sns/ad/a/a$a:fzB	Ljava/lang/String;
    //   59: aload 5
    //   61: iconst_0
    //   62: invokestatic 67	com/tencent/mm/plugin/sns/ad/i/g:afh	(I)Ljava/lang/String;
    //   65: putfield 70	com/tencent/mm/plugin/sns/ad/a/a$a:JyN	Ljava/lang/String;
    //   68: aload 5
    //   70: iconst_1
    //   71: invokestatic 67	com/tencent/mm/plugin/sns/ad/i/g:afh	(I)Ljava/lang/String;
    //   74: putfield 73	com/tencent/mm/plugin/sns/ad/a/a$a:JyO	Ljava/lang/String;
    //   77: aload 5
    //   79: invokestatic 76	com/tencent/mm/plugin/sns/ad/i/g:auE	()Ljava/lang/String;
    //   82: putfield 79	com/tencent/mm/plugin/sns/ad/a/a$a:imei	Ljava/lang/String;
    //   85: aload 5
    //   87: iconst_0
    //   88: invokestatic 82	com/tencent/mm/plugin/sns/ad/i/g:afi	(I)Ljava/lang/String;
    //   91: putfield 85	com/tencent/mm/plugin/sns/ad/a/a$a:JyP	Ljava/lang/String;
    //   94: aload 5
    //   96: iconst_1
    //   97: invokestatic 82	com/tencent/mm/plugin/sns/ad/i/g:afi	(I)Ljava/lang/String;
    //   100: putfield 88	com/tencent/mm/plugin/sns/ad/a/a$a:JyQ	Ljava/lang/String;
    //   103: aload 5
    //   105: invokestatic 91	com/tencent/mm/plugin/sns/ad/i/g:fLR	()Ljava/lang/String;
    //   108: putfield 94	com/tencent/mm/plugin/sns/ad/a/a$a:JyR	Ljava/lang/String;
    //   111: aload 5
    //   113: iconst_0
    //   114: invokestatic 97	com/tencent/mm/plugin/sns/ad/i/g:afj	(I)Ljava/lang/String;
    //   117: putfield 100	com/tencent/mm/plugin/sns/ad/a/a$a:JyS	Ljava/lang/String;
    //   120: aload 5
    //   122: iconst_1
    //   123: invokestatic 97	com/tencent/mm/plugin/sns/ad/i/g:afj	(I)Ljava/lang/String;
    //   126: putfield 103	com/tencent/mm/plugin/sns/ad/a/a$a:JyT	Ljava/lang/String;
    //   129: aload 5
    //   131: invokestatic 106	com/tencent/mm/plugin/sns/ad/i/g:auF	()Ljava/lang/String;
    //   134: putfield 109	com/tencent/mm/plugin/sns/ad/a/a$a:JyU	Ljava/lang/String;
    //   137: invokestatic 112	com/tencent/mm/plugin/sns/ad/i/b:fLP	()Z
    //   140: ifeq +11 -> 151
    //   143: aload 5
    //   145: invokestatic 115	com/tencent/mm/plugin/sns/ad/i/g:fLU	()Ljava/lang/String;
    //   148: putfield 118	com/tencent/mm/plugin/sns/ad/a/a$a:uuid	Ljava/lang/String;
    //   151: invokestatic 121	com/tencent/mm/plugin/sns/ad/i/b:fLM	()Z
    //   154: ifeq +11 -> 165
    //   157: aload 5
    //   159: invokestatic 124	com/tencent/mm/plugin/sns/ad/i/g:getAndroidId	()Ljava/lang/String;
    //   162: putfield 127	com/tencent/mm/plugin/sns/ad/a/a$a:androidId	Ljava/lang/String;
    //   165: invokestatic 130	com/tencent/mm/plugin/sns/ad/i/b:fLQ	()Z
    //   168: ifeq +27 -> 195
    //   171: aload 5
    //   173: invokestatic 133	com/tencent/mm/plugin/sns/ad/i/g:fLV	()Z
    //   176: putfield 137	com/tencent/mm/plugin/sns/ad/a/a$a:JyV	Z
    //   179: aload 5
    //   181: invokestatic 140	com/tencent/mm/plugin/sns/ad/i/g:fLW	()Ljava/lang/String;
    //   184: putfield 143	com/tencent/mm/plugin/sns/ad/a/a$a:JyW	Ljava/lang/String;
    //   187: aload 5
    //   189: invokestatic 147	com/tencent/mm/plugin/sns/ad/i/g:fLX	()I
    //   192: putfield 151	com/tencent/mm/plugin/sns/ad/a/a$a:JyX	I
    //   195: invokestatic 44	java/lang/System:currentTimeMillis	()J
    //   198: lstore_3
    //   199: ldc 153
    //   201: new 155	java/lang/StringBuilder
    //   204: dup
    //   205: ldc 157
    //   207: invokespecial 160	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   210: lload_3
    //   211: lload_1
    //   212: lsub
    //   213: invokevirtual 164	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   216: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   219: invokestatic 173	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   222: aload 5
    //   224: invokevirtual 176	com/tencent/mm/plugin/sns/ad/a/a$a:fJI	()Ljava/lang/String;
    //   227: invokestatic 182	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   230: astore 5
    //   232: new 155	java/lang/StringBuilder
    //   235: dup
    //   236: ldc 184
    //   238: invokespecial 160	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   241: astore 6
    //   243: aload 5
    //   245: ifnonnull +28 -> 273
    //   248: ldc 153
    //   250: aload 6
    //   252: iload_0
    //   253: invokevirtual 187	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   256: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   259: invokestatic 189	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   262: ldc 34
    //   264: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   267: ldc 2
    //   269: monitorexit
    //   270: aload 5
    //   272: areturn
    //   273: aload 5
    //   275: invokevirtual 194	java/lang/String:length	()I
    //   278: istore_0
    //   279: goto -31 -> 248
    //   282: astore 5
    //   284: ldc 2
    //   286: monitorexit
    //   287: aload 5
    //   289: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   1	278	0	i	int
    //   22	190	1	l1	long
    //   198	13	3	l2	long
    //   17	257	5	localObject1	Object
    //   282	6	5	localObject2	Object
    //   241	10	6	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   5	37	282	finally
    //   37	137	282	finally
    //   137	151	282	finally
    //   151	165	282	finally
    //   165	195	282	finally
    //   195	243	282	finally
    //   248	267	282	finally
    //   273	279	282	finally
  }
  
  public static String fJG()
  {
    try
    {
      AppMethodBeat.i(261228);
      String str = g.fLU();
      AppMethodBeat.o(261228);
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String fJH()
  {
    AppMethodBeat.i(261232);
    String str = "";
    if (b.fLO()) {
      str = g.fLS();
    }
    AppMethodBeat.o(261232);
    return str;
  }
  
  public static final class a
  {
    String JyL;
    String JyM;
    String JyN;
    String JyO;
    String JyP;
    String JyQ;
    String JyR;
    String JyS;
    String JyT;
    String JyU;
    boolean JyV;
    String JyW;
    int JyX;
    String androidId;
    String fzB;
    String imei;
    String uuid;
    
    final String fJI()
    {
      AppMethodBeat.i(260317);
      try
      {
        long l1 = System.currentTimeMillis();
        Object localObject = new JSONObject();
        if (!Util.isNullOrNil(this.JyL)) {
          ((JSONObject)localObject).put("oaid", this.JyL);
        }
        if (!Util.isNullOrNil(this.JyM)) {
          ((JSONObject)localObject).put("imeiWx", this.JyM);
        }
        if (!Util.isNullOrNil(this.fzB)) {
          ((JSONObject)localObject).put("deviceId", this.fzB);
        }
        if (!Util.isNullOrNil(this.JyN)) {
          ((JSONObject)localObject).put("deviceId0", this.JyN);
        }
        if (!Util.isNullOrNil(this.JyO)) {
          ((JSONObject)localObject).put("deviceId1", this.JyO);
        }
        if (!Util.isNullOrNil(this.imei)) {
          ((JSONObject)localObject).put("imei", this.imei);
        }
        if (!Util.isNullOrNil(this.JyP)) {
          ((JSONObject)localObject).put("imei0", this.JyP);
        }
        if (!Util.isNullOrNil(this.JyQ)) {
          ((JSONObject)localObject).put("imei1", this.JyQ);
        }
        if (!Util.isNullOrNil(this.JyR)) {
          ((JSONObject)localObject).put("meid", this.JyR);
        }
        if (!Util.isNullOrNil(this.JyS)) {
          ((JSONObject)localObject).put("meid0", this.JyS);
        }
        if (!Util.isNullOrNil(this.JyT)) {
          ((JSONObject)localObject).put("meid1", this.JyT);
        }
        if (!Util.isNullOrNil(this.JyU)) {
          ((JSONObject)localObject).put("subscriberId", this.JyU);
        }
        if (!Util.isNullOrNil(this.uuid)) {
          ((JSONObject)localObject).put("uuid", this.uuid);
        }
        if (!Util.isNullOrNil(this.androidId)) {
          ((JSONObject)localObject).put("androidId", this.androidId);
        }
        if ((b.fLQ()) && (this.JyV))
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("is_harmony_os", this.JyV);
          localJSONObject.put("os_version", this.JyW);
          localJSONObject.put("harmony_pure_mode", this.JyX);
          ((JSONObject)localObject).put("HarmonyInfo", localJSONObject);
        }
        localObject = ((JSONObject)localObject).toString();
        long l2 = System.currentTimeMillis();
        Log.d("AdDeviceInfo", "buildPartDeviceInfo, timeCost = " + (l2 - l1) + ", ret = " + (String)localObject);
        AppMethodBeat.o(260317);
        return localObject;
      }
      catch (Throwable localThrowable)
      {
        Log.e("AdDeviceInfo", localThrowable.toString());
        AppMethodBeat.o(260317);
      }
      return "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.a.a
 * JD-Core Version:    0.7.0.1
 */