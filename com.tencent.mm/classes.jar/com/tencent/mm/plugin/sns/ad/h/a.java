package com.tencent.mm.plugin.sns.ad.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class a
{
  public static String aYC(String paramString)
  {
    AppMethodBeat.i(207272);
    str1 = "";
    try
    {
      String str2 = new JSONObject(paramString).optString("appId");
      paramString = str2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("OpenSdkAdHelper", "getAppIdFromExtra, exp=" + paramString.toString() + ", extInfo=" + paramString);
        paramString = str1;
      }
    }
    AppMethodBeat.o(207272);
    return paramString;
  }
  
  public static boolean aeP(int paramInt)
  {
    return paramInt == 29;
  }
  
  public static String e(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(207268);
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("appId", Util.nullAsNil(paramString1));
      if (paramLong == 0L) {}
      for (paramString1 = "";; paramString1 = String.valueOf(paramLong))
      {
        localJSONObject.put("canvasId", paramString1);
        localJSONObject.put("uxInfo", Util.nullAsNil(paramString2));
        paramString1 = localJSONObject.toString();
        AppMethodBeat.o(207268);
        return paramString1;
      }
      return "";
    }
    catch (Exception paramString1)
    {
      AppMethodBeat.o(207268);
    }
  }
  
  /* Error */
  public static void fU(String paramString, int paramInt)
  {
    // Byte code:
    //   0: ldc 88
    //   2: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 94	com/tencent/mm/kernel/h:aHB	()Z
    //   8: ifne +45 -> 53
    //   11: invokestatic 99	com/tencent/mm/sdk/platformtools/MMApplicationContext:isMainProcess	()Z
    //   14: ifeq +39 -> 53
    //   17: ldc 33
    //   19: new 35	java/lang/StringBuilder
    //   22: dup
    //   23: ldc 101
    //   25: invokespecial 38	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   28: iload_1
    //   29: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   32: ldc 106
    //   34: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: aload_0
    //   38: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: invokestatic 57	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   47: ldc 88
    //   49: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   52: return
    //   53: ldc 33
    //   55: new 35	java/lang/StringBuilder
    //   58: dup
    //   59: ldc 108
    //   61: invokespecial 38	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   64: iload_1
    //   65: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   68: ldc 106
    //   70: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: aload_0
    //   74: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: invokestatic 110	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   83: getstatic 116	com/tencent/mm/plugin/report/service/h:IzE	Lcom/tencent/mm/plugin/report/service/h;
    //   86: sipush 1667
    //   89: iload_1
    //   90: invokevirtual 120	com/tencent/mm/plugin/report/service/h:el	(II)V
    //   93: ldc 17
    //   95: astore_2
    //   96: aload_0
    //   97: invokestatic 126	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   100: ifeq +36 -> 136
    //   103: new 19	org/json/JSONObject
    //   106: dup
    //   107: invokespecial 65	org/json/JSONObject:<init>	()V
    //   110: astore_0
    //   111: aload_0
    //   112: ldc 128
    //   114: iload_1
    //   115: invokevirtual 131	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   118: pop
    //   119: aload_0
    //   120: invokevirtual 79	org/json/JSONObject:toString	()Ljava/lang/String;
    //   123: astore_0
    //   124: ldc 133
    //   126: aload_0
    //   127: invokestatic 138	com/tencent/mm/plugin/sns/data/m:ks	(Ljava/lang/String;Ljava/lang/String;)V
    //   130: ldc 88
    //   132: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   135: return
    //   136: new 19	org/json/JSONObject
    //   139: dup
    //   140: aload_0
    //   141: invokespecial 23	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   144: astore_0
    //   145: aload_0
    //   146: ldc 128
    //   148: iload_1
    //   149: invokevirtual 131	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   152: pop
    //   153: aload_0
    //   154: invokevirtual 79	org/json/JSONObject:toString	()Ljava/lang/String;
    //   157: astore_0
    //   158: goto -34 -> 124
    //   161: astore_0
    //   162: ldc 33
    //   164: new 35	java/lang/StringBuilder
    //   167: dup
    //   168: ldc 140
    //   170: invokespecial 38	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   173: aload_0
    //   174: invokevirtual 141	java/lang/Throwable:toString	()Ljava/lang/String;
    //   177: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   183: invokestatic 57	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   186: ldc 88
    //   188: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   191: return
    //   192: astore_0
    //   193: aload_2
    //   194: astore_0
    //   195: goto -71 -> 124
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	198	0	paramString	String
    //   0	198	1	paramInt	int
    //   95	99	2	str	String
    // Exception table:
    //   from	to	target	type
    //   5	47	161	java/lang/Throwable
    //   53	93	161	java/lang/Throwable
    //   96	124	161	java/lang/Throwable
    //   124	130	161	java/lang/Throwable
    //   136	158	161	java/lang/Throwable
    //   96	124	192	java/lang/Exception
    //   136	158	192	java/lang/Exception
  }
  
  public static String ko(String paramString1, String paramString2)
  {
    AppMethodBeat.i(207274);
    Object localObject2 = "";
    String str = "";
    Object localObject1 = localObject2;
    try
    {
      Object localObject3 = new JSONObject(paramString2);
      localObject1 = localObject2;
      localObject2 = ((JSONObject)localObject3).optString("canvasId");
      localObject1 = localObject2;
      localObject3 = ((JSONObject)localObject3).optString("uxInfo");
      paramString2 = (String)localObject3;
      localObject1 = localObject2;
      return "";
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("appId", Util.nullAsNil(paramString1));
          ((JSONObject)localObject2).put("canvasId", localObject1);
          ((JSONObject)localObject2).put("uxInfo", paramString2);
          paramString1 = ((JSONObject)localObject2).toString();
          AppMethodBeat.o(207274);
          return paramString1;
        }
        catch (Exception paramString1)
        {
          AppMethodBeat.o(207274);
        }
        localException = localException;
        Log.e("OpenSdkAdHelper", "getOpenCanvasAdExtraInfo, appId=" + paramString1 + ", extInfo=" + paramString2);
        paramString2 = str;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.h.a
 * JD-Core Version:    0.7.0.1
 */