package com.tencent.mm.plugin.sns.ad.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.j.b;
import com.tencent.mm.plugin.sns.ad.j.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class a
{
  public static String aPk()
  {
    AppMethodBeat.i(309683);
    String str = "";
    if (b.hch()) {
      str = g.aPk();
    }
    AppMethodBeat.o(309683);
    return str;
  }
  
  public static String gZA()
  {
    try
    {
      AppMethodBeat.i(309676);
      String str = g.hco();
      AppMethodBeat.o(309676);
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String gZB()
  {
    AppMethodBeat.i(309686);
    String str = "";
    if (b.hci()) {
      str = g.hcm();
    }
    AppMethodBeat.o(309686);
    return str;
  }
  
  /* Error */
  public static String gZz()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_0
    //   2: ldc 2
    //   4: monitorenter
    //   5: ldc 47
    //   7: invokestatic 16	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: new 6	com/tencent/mm/plugin/sns/ad/a/a$a
    //   13: dup
    //   14: invokespecial 51	com/tencent/mm/plugin/sns/ad/a/a$a:<init>	()V
    //   17: astore 5
    //   19: invokestatic 57	java/lang/System:currentTimeMillis	()J
    //   22: lstore_1
    //   23: invokestatic 24	com/tencent/mm/plugin/sns/ad/j/b:hch	()Z
    //   26: ifeq +11 -> 37
    //   29: aload 5
    //   31: invokestatic 28	com/tencent/mm/plugin/sns/ad/j/g:aPk	()Ljava/lang/String;
    //   34: putfield 61	com/tencent/mm/plugin/sns/ad/a/a$a:PNk	Ljava/lang/String;
    //   37: invokestatic 42	com/tencent/mm/plugin/sns/ad/j/b:hci	()Z
    //   40: ifeq +97 -> 137
    //   43: aload 5
    //   45: invokestatic 45	com/tencent/mm/plugin/sns/ad/j/g:hcm	()Ljava/lang/String;
    //   48: putfield 64	com/tencent/mm/plugin/sns/ad/a/a$a:PNl	Ljava/lang/String;
    //   51: aload 5
    //   53: invokestatic 67	com/tencent/mm/plugin/sns/ad/j/g:bRM	()Ljava/lang/String;
    //   56: putfield 70	com/tencent/mm/plugin/sns/ad/a/a$a:hEl	Ljava/lang/String;
    //   59: aload 5
    //   61: iconst_0
    //   62: invokestatic 74	com/tencent/mm/plugin/sns/ad/j/g:ajQ	(I)Ljava/lang/String;
    //   65: putfield 77	com/tencent/mm/plugin/sns/ad/a/a$a:PNm	Ljava/lang/String;
    //   68: aload 5
    //   70: iconst_1
    //   71: invokestatic 74	com/tencent/mm/plugin/sns/ad/j/g:ajQ	(I)Ljava/lang/String;
    //   74: putfield 80	com/tencent/mm/plugin/sns/ad/a/a$a:PNn	Ljava/lang/String;
    //   77: aload 5
    //   79: invokestatic 83	com/tencent/mm/plugin/sns/ad/j/g:aOY	()Ljava/lang/String;
    //   82: putfield 86	com/tencent/mm/plugin/sns/ad/a/a$a:imei	Ljava/lang/String;
    //   85: aload 5
    //   87: iconst_0
    //   88: invokestatic 89	com/tencent/mm/plugin/sns/ad/j/g:ajR	(I)Ljava/lang/String;
    //   91: putfield 92	com/tencent/mm/plugin/sns/ad/a/a$a:PNo	Ljava/lang/String;
    //   94: aload 5
    //   96: iconst_1
    //   97: invokestatic 89	com/tencent/mm/plugin/sns/ad/j/g:ajR	(I)Ljava/lang/String;
    //   100: putfield 95	com/tencent/mm/plugin/sns/ad/a/a$a:PNp	Ljava/lang/String;
    //   103: aload 5
    //   105: invokestatic 98	com/tencent/mm/plugin/sns/ad/j/g:hcl	()Ljava/lang/String;
    //   108: putfield 101	com/tencent/mm/plugin/sns/ad/a/a$a:zxR	Ljava/lang/String;
    //   111: aload 5
    //   113: iconst_0
    //   114: invokestatic 104	com/tencent/mm/plugin/sns/ad/j/g:ajS	(I)Ljava/lang/String;
    //   117: putfield 107	com/tencent/mm/plugin/sns/ad/a/a$a:PNq	Ljava/lang/String;
    //   120: aload 5
    //   122: iconst_1
    //   123: invokestatic 104	com/tencent/mm/plugin/sns/ad/j/g:ajS	(I)Ljava/lang/String;
    //   126: putfield 110	com/tencent/mm/plugin/sns/ad/a/a$a:PNr	Ljava/lang/String;
    //   129: aload 5
    //   131: invokestatic 113	com/tencent/mm/plugin/sns/ad/j/g:aOZ	()Ljava/lang/String;
    //   134: putfield 116	com/tencent/mm/plugin/sns/ad/a/a$a:PNs	Ljava/lang/String;
    //   137: invokestatic 119	com/tencent/mm/plugin/sns/ad/j/b:hcj	()Z
    //   140: ifeq +11 -> 151
    //   143: aload 5
    //   145: invokestatic 37	com/tencent/mm/plugin/sns/ad/j/g:hco	()Ljava/lang/String;
    //   148: putfield 122	com/tencent/mm/plugin/sns/ad/a/a$a:uuid	Ljava/lang/String;
    //   151: invokestatic 125	com/tencent/mm/plugin/sns/ad/j/b:hcg	()Z
    //   154: ifeq +11 -> 165
    //   157: aload 5
    //   159: invokestatic 128	com/tencent/mm/plugin/sns/ad/j/g:getAndroidId	()Ljava/lang/String;
    //   162: putfield 131	com/tencent/mm/plugin/sns/ad/a/a$a:androidId	Ljava/lang/String;
    //   165: invokestatic 134	com/tencent/mm/plugin/sns/ad/j/b:hck	()Z
    //   168: ifeq +29 -> 197
    //   171: aload 5
    //   173: invokestatic 137	com/tencent/mm/plugin/sns/ad/j/g:hcp	()Z
    //   176: putfield 141	com/tencent/mm/plugin/sns/ad/a/a$a:PNt	Z
    //   179: aload 5
    //   181: ldc 143
    //   183: invokestatic 147	com/tencent/mm/plugin/sns/ad/j/g:aWS	(Ljava/lang/String;)Ljava/lang/String;
    //   186: putfield 150	com/tencent/mm/plugin/sns/ad/a/a$a:PNu	Ljava/lang/String;
    //   189: aload 5
    //   191: invokestatic 154	com/tencent/mm/plugin/sns/ad/j/g:hcq	()I
    //   194: putfield 158	com/tencent/mm/plugin/sns/ad/a/a$a:PNv	I
    //   197: invokestatic 57	java/lang/System:currentTimeMillis	()J
    //   200: lstore_3
    //   201: ldc 160
    //   203: new 162	java/lang/StringBuilder
    //   206: dup
    //   207: ldc 164
    //   209: invokespecial 167	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   212: lload_3
    //   213: lload_1
    //   214: lsub
    //   215: invokevirtual 171	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   218: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   221: invokestatic 180	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   224: aload 5
    //   226: invokevirtual 183	com/tencent/mm/plugin/sns/ad/a/a$a:gZC	()Ljava/lang/String;
    //   229: invokestatic 188	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   232: astore 5
    //   234: new 162	java/lang/StringBuilder
    //   237: dup
    //   238: ldc 190
    //   240: invokespecial 167	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   243: astore 6
    //   245: aload 5
    //   247: ifnonnull +28 -> 275
    //   250: ldc 160
    //   252: aload 6
    //   254: iload_0
    //   255: invokevirtual 193	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   258: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   261: invokestatic 195	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   264: ldc 47
    //   266: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   269: ldc 2
    //   271: monitorexit
    //   272: aload 5
    //   274: areturn
    //   275: aload 5
    //   277: invokevirtual 200	java/lang/String:length	()I
    //   280: istore_0
    //   281: goto -31 -> 250
    //   284: astore 5
    //   286: ldc 2
    //   288: monitorexit
    //   289: aload 5
    //   291: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   1	280	0	i	int
    //   22	192	1	l1	long
    //   200	13	3	l2	long
    //   17	259	5	localObject1	Object
    //   284	6	5	localObject2	Object
    //   243	10	6	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   5	37	284	finally
    //   37	137	284	finally
    //   137	151	284	finally
    //   151	165	284	finally
    //   165	197	284	finally
    //   197	245	284	finally
    //   250	269	284	finally
    //   275	281	284	finally
  }
  
  public static final class a
  {
    String PNk;
    String PNl;
    String PNm;
    String PNn;
    String PNo;
    String PNp;
    String PNq;
    String PNr;
    String PNs;
    boolean PNt;
    String PNu;
    int PNv;
    String androidId;
    String hEl;
    String imei;
    String uuid;
    String zxR;
    
    final String gZC()
    {
      AppMethodBeat.i(309675);
      try
      {
        long l1 = System.currentTimeMillis();
        Object localObject1 = new JSONObject();
        if (!Util.isNullOrNil(this.PNk)) {
          ((JSONObject)localObject1).put("oaid", this.PNk);
        }
        if (!Util.isNullOrNil(this.PNl)) {
          ((JSONObject)localObject1).put("imeiWx", this.PNl);
        }
        if (!Util.isNullOrNil(this.hEl)) {
          ((JSONObject)localObject1).put("deviceId", this.hEl);
        }
        if (!Util.isNullOrNil(this.PNm)) {
          ((JSONObject)localObject1).put("deviceId0", this.PNm);
        }
        if (!Util.isNullOrNil(this.PNn)) {
          ((JSONObject)localObject1).put("deviceId1", this.PNn);
        }
        if (!Util.isNullOrNil(this.imei)) {
          ((JSONObject)localObject1).put("imei", this.imei);
        }
        if (!Util.isNullOrNil(this.PNo)) {
          ((JSONObject)localObject1).put("imei0", this.PNo);
        }
        if (!Util.isNullOrNil(this.PNp)) {
          ((JSONObject)localObject1).put("imei1", this.PNp);
        }
        if (!Util.isNullOrNil(this.zxR)) {
          ((JSONObject)localObject1).put("meid", this.zxR);
        }
        if (!Util.isNullOrNil(this.PNq)) {
          ((JSONObject)localObject1).put("meid0", this.PNq);
        }
        if (!Util.isNullOrNil(this.PNr)) {
          ((JSONObject)localObject1).put("meid1", this.PNr);
        }
        if (!Util.isNullOrNil(this.PNs)) {
          ((JSONObject)localObject1).put("subscriberId", this.PNs);
        }
        if (!Util.isNullOrNil(this.uuid)) {
          ((JSONObject)localObject1).put("uuid", this.uuid);
        }
        if (!Util.isNullOrNil(this.androidId)) {
          ((JSONObject)localObject1).put("androidId", this.androidId);
        }
        if ((b.hck()) && (this.PNt))
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("is_harmony_os", this.PNt);
          localJSONObject.put("os_version", this.PNu);
          localJSONObject.put("harmony_pure_mode", this.PNv);
          ((JSONObject)localObject1).put("HarmonyInfo", localJSONObject);
        }
        localObject1 = ((JSONObject)localObject1).toString();
        long l2 = System.currentTimeMillis();
        Log.d("AdDeviceInfo", "buildPartDeviceInfo, timeCost = " + (l2 - l1) + ", ret = " + (String)localObject1);
        AppMethodBeat.o(309675);
        return localObject1;
      }
      finally
      {
        Log.e("AdDeviceInfo", localObject2.toString());
        AppMethodBeat.o(309675);
      }
      return "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.a.a
 * JD-Core Version:    0.7.0.1
 */