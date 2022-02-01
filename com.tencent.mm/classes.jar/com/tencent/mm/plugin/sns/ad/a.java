package com.tencent.mm.plugin.sns.ad;

import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public final class a
{
  private static HashMap<String, HashMap<String, String>> PKS;
  private static HashMap<String, Boolean> PKT;
  
  static
  {
    AppMethodBeat.i(309720);
    PKS = new HashMap();
    PKT = new HashMap();
    AppMethodBeat.o(309720);
  }
  
  private static String aR(Map<String, String> paramMap)
  {
    AppMethodBeat.i(309708);
    if ((paramMap == null) || (paramMap.size() == 0))
    {
      AppMethodBeat.o(309708);
      return "{}";
    }
    try
    {
      paramMap = new JSONObject(paramMap).toString();
      return paramMap;
    }
    finally
    {
      AppMethodBeat.o(309708);
    }
    return "{}";
  }
  
  public static void aWe(String paramString)
  {
    AppMethodBeat.i(309680);
    try
    {
      long l = System.currentTimeMillis();
      if (!TextUtils.isEmpty(paramString)) {}
      synchronized (PKS)
      {
        PKS.remove(paramString);
        MultiProcessMMKV.getMMKV("sns_ad_mmkv").edit().remove(paramString).apply();
        Log.i("SnsAdLocalStoreage", "delAd, snsId=" + paramString + ", cost=" + (System.currentTimeMillis() - l));
        AppMethodBeat.o(309680);
        return;
      }
      return;
    }
    finally
    {
      Log.e("SnsAdLocalStoreage", "delAd, exp=" + paramString.toString());
      AppMethodBeat.o(309680);
    }
  }
  
  private static void aWf(String paramString)
  {
    AppMethodBeat.i(309694);
    try
    {
      long l = System.currentTimeMillis();
      if (PKT.containsKey(paramString))
      {
        boolean bool = ((Boolean)PKT.get(paramString)).booleanValue();
        if (bool)
        {
          AppMethodBeat.o(309694);
          return;
        }
      }
      HashMap localHashMap = new HashMap();
      for (;;)
      {
        try
        {
          String str1 = MultiProcessMMKV.getMMKV("sns_ad_mmkv").getString(paramString, "");
          if (!TextUtils.isEmpty(str1))
          {
            JSONObject localJSONObject = new JSONObject(str1);
            Iterator localIterator = localJSONObject.keys();
            if (localIterator.hasNext())
            {
              String str3 = (String)localIterator.next();
              String str4 = Util.nullAsNil(localJSONObject.optString(str3));
              if (TextUtils.isEmpty(str3)) {
                continue;
              }
              localHashMap.put(str3, str4);
              continue;
            }
          }
          Log.i("SnsAdLocalStoreage", "checkInit, snsId=" + paramString + ", value=" + str2 + ", cost=" + (System.currentTimeMillis() - l));
        }
        finally
        {
          Log.e("SnsAdLocalStoreage", "checkInit exp=" + str2.toString());
          PKS.put(paramString, localHashMap);
          PKT.put(paramString, Boolean.TRUE);
          AppMethodBeat.o(309694);
          return;
        }
      }
      return;
    }
    finally
    {
      Log.e("SnsAdLocalStoreage", "checkInit, exp=" + paramString.toString());
      AppMethodBeat.o(309694);
    }
  }
  
  public static String getAdValue(String arg0, String paramString2)
  {
    AppMethodBeat.i(309657);
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramString2))
        {
          AppMethodBeat.o(309657);
          return "";
        }
        localObject = ???;
        if (TextUtils.isEmpty(???)) {
          localObject = "default_snsid_123456";
        }
      }
      finally
      {
        Object localObject;
        Log.e("SnsAdLocalStoreage", "getAdValue, exp=" + ???.toString());
        continue;
      }
      synchronized (PKS)
      {
        aWf((String)localObject);
        localObject = (HashMap)PKS.get(localObject);
        if (localObject != null)
        {
          paramString2 = Util.nullAsNil((String)((HashMap)localObject).get(paramString2));
          AppMethodBeat.o(309657);
          return paramString2;
        }
        AppMethodBeat.o(309657);
        return "";
      }
    }
  }
  
  /* Error */
  public static void setAdValue(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: ldc 196
    //   2: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: invokestatic 68	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9: istore_3
    //   10: iload_3
    //   11: ifeq +9 -> 20
    //   14: ldc 196
    //   16: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: return
    //   20: aload_0
    //   21: astore 6
    //   23: aload_0
    //   24: invokestatic 68	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   27: ifeq +7 -> 34
    //   30: ldc 189
    //   32: astore 6
    //   34: aload_2
    //   35: invokestatic 169	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   38: astore 8
    //   40: getstatic 25	com/tencent/mm/plugin/sns/ad/a:PKS	Ljava/util/HashMap;
    //   43: astore 7
    //   45: aload 7
    //   47: monitorenter
    //   48: aload 6
    //   50: invokestatic 191	com/tencent/mm/plugin/sns/ad/a:aWf	(Ljava/lang/String;)V
    //   53: getstatic 25	com/tencent/mm/plugin/sns/ad/a:PKS	Ljava/util/HashMap;
    //   56: aload 6
    //   58: invokevirtual 132	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   61: checkcast 20	java/util/HashMap
    //   64: astore_2
    //   65: aload_2
    //   66: astore_0
    //   67: aload_2
    //   68: ifnonnull +11 -> 79
    //   71: new 20	java/util/HashMap
    //   74: dup
    //   75: invokespecial 23	java/util/HashMap:<init>	()V
    //   78: astore_0
    //   79: aload_0
    //   80: aload_1
    //   81: aload 8
    //   83: invokevirtual 173	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   86: pop
    //   87: invokestatic 62	java/lang/System:currentTimeMillis	()J
    //   90: lstore 4
    //   92: getstatic 25	com/tencent/mm/plugin/sns/ad/a:PKS	Ljava/util/HashMap;
    //   95: aload 6
    //   97: invokevirtual 132	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   100: checkcast 20	java/util/HashMap
    //   103: invokestatic 198	com/tencent/mm/plugin/sns/ad/a:aR	(Ljava/util/Map;)Ljava/lang/String;
    //   106: astore_0
    //   107: ldc 74
    //   109: invokestatic 80	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:getMMKV	(Ljava/lang/String;)Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;
    //   112: invokevirtual 84	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:edit	()Landroid/content/SharedPreferences$Editor;
    //   115: aload 6
    //   117: aload_0
    //   118: invokeinterface 202 3 0
    //   123: invokeinterface 92 1 0
    //   128: ldc 94
    //   130: new 96	java/lang/StringBuilder
    //   133: dup
    //   134: ldc 204
    //   136: invokespecial 100	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   139: aload 6
    //   141: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: ldc 106
    //   146: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: invokestatic 62	java/lang/System:currentTimeMillis	()J
    //   152: lload 4
    //   154: lsub
    //   155: invokevirtual 109	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   158: ldc 183
    //   160: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: aload_0
    //   164: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   170: invokestatic 115	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   173: aload 7
    //   175: monitorexit
    //   176: ldc 196
    //   178: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   181: return
    //   182: astore_0
    //   183: ldc 94
    //   185: new 96	java/lang/StringBuilder
    //   188: dup
    //   189: ldc 206
    //   191: invokespecial 100	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   194: aload_0
    //   195: invokevirtual 120	java/lang/Throwable:toString	()Ljava/lang/String;
    //   198: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   204: invokestatic 123	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   207: ldc 196
    //   209: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   212: return
    //   213: astore_0
    //   214: ldc 94
    //   216: new 96	java/lang/StringBuilder
    //   219: dup
    //   220: ldc 208
    //   222: invokespecial 100	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   225: aload_0
    //   226: invokevirtual 120	java/lang/Throwable:toString	()Ljava/lang/String;
    //   229: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   235: invokestatic 123	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   238: goto -65 -> 173
    //   241: astore_0
    //   242: aload 7
    //   244: monitorexit
    //   245: ldc 196
    //   247: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   250: aload_0
    //   251: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	252	0	paramString1	String
    //   0	252	1	paramString2	String
    //   0	252	2	paramString3	String
    //   9	2	3	bool	boolean
    //   90	63	4	l	long
    //   21	119	6	str1	String
    //   38	44	8	str2	String
    // Exception table:
    //   from	to	target	type
    //   5	10	182	finally
    //   23	30	182	finally
    //   34	48	182	finally
    //   176	181	182	finally
    //   242	252	182	finally
    //   87	173	213	finally
    //   48	65	241	finally
    //   71	79	241	finally
    //   79	87	241	finally
    //   173	176	241	finally
    //   214	238	241	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.a
 * JD-Core Version:    0.7.0.1
 */