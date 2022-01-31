package com.tencent.tencentmap.mapsdk.maps.a;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.m;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class li
  extends AsyncTask<Object, Void, Void>
{
  private Handler a;
  private String b;
  private WeakReference<lh> c;
  
  public li(Handler paramHandler, lh paramlh, String paramString1, String paramString2)
  {
    AppMethodBeat.i(149152);
    this.a = paramHandler;
    this.c = new WeakReference(paramlh);
    this.b = ("https://apikey.map.qq.com/mkey/index.php/mkey/check?" + ka.a(paramString1, paramString2));
    AppMethodBeat.o(149152);
  }
  
  private void a(int paramInt, String paramString)
  {
    AppMethodBeat.i(149158);
    Object localObject = new ArrayList(4);
    ((List)localObject).add("腾讯地图鉴权失败，请访问 lbs.qq.com 检查 key 配置");
    ((List)localObject).add("错误码：".concat(String.valueOf(paramInt)));
    ((List)localObject).add("错误信息：".concat(String.valueOf(paramString)));
    paramString = new StringBuilder(1024);
    paramString.append("Auth Fail:\n");
    char[] arrayOfChar = new char[81];
    Arrays.fill(arrayOfChar, '*');
    arrayOfChar[80] = '\n';
    paramString.append(arrayOfChar);
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramString.append((String)((Iterator)localObject).next()).append("\n");
    }
    paramString.append(arrayOfChar);
    AppMethodBeat.o(149158);
  }
  
  private void a(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(149154);
    if (paramJSONObject == null)
    {
      if ((this.c != null) && (this.c.get() != null)) {
        ((lh)this.c.get()).a(null, null);
      }
      AppMethodBeat.o(149154);
      return;
    }
    JSONArray localJSONArray = paramJSONObject.optJSONObject("custom_map_style").optJSONArray("style_list");
    paramJSONObject = b(paramJSONObject.optJSONObject("indoor_map"));
    if ((this.c != null) && (this.c.get() != null)) {
      ((lh)this.c.get()).a(localJSONArray, paramJSONObject);
    }
    AppMethodBeat.o(149154);
  }
  
  private m b(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(149155);
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(149155);
      return null;
    }
    int i = paramJSONObject.optInt("enable", -1);
    int j = paramJSONObject.optInt("type", -1);
    if ((i == -1) || (j == -1))
    {
      AppMethodBeat.o(149155);
      return null;
    }
    paramJSONObject = new m(i, j, paramJSONObject.optJSONArray("building_list"));
    AppMethodBeat.o(149155);
    return paramJSONObject;
  }
  
  private void b()
  {
    AppMethodBeat.i(149157);
    if (this.a != null)
    {
      Object localObject = new nf();
      ((nf)localObject).a = 3;
      localObject = this.a.obtainMessage(((nf)localObject).a, localObject);
      this.a.sendMessage((Message)localObject);
    }
    AppMethodBeat.o(149157);
  }
  
  protected Void a(Object... paramVarArgs)
  {
    AppMethodBeat.i(149156);
    a();
    AppMethodBeat.o(149156);
    return null;
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: ldc 191
    //   4: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: invokestatic 196	com/tencent/tencentmap/mapsdk/a/dp:a	()Lcom/tencent/tencentmap/mapsdk/a/dp;
    //   10: aload_0
    //   11: getfield 55	com/tencent/tencentmap/mapsdk/maps/a/li:b	Ljava/lang/String;
    //   14: invokevirtual 199	com/tencent/tencentmap/mapsdk/a/dp:a	(Ljava/lang/String;)Lcom/tencent/tencentmap/mapsdk/a/dq;
    //   17: astore 4
    //   19: aload 4
    //   21: ifnonnull +16 -> 37
    //   24: ldc 191
    //   26: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: return
    //   30: astore_2
    //   31: ldc 191
    //   33: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   36: return
    //   37: aload 4
    //   39: getfield 202	com/tencent/tencentmap/mapsdk/a/dq:b	Ljava/lang/String;
    //   42: astore_2
    //   43: aload 4
    //   45: getfield 205	com/tencent/tencentmap/mapsdk/a/dq:a	[B
    //   48: astore 4
    //   50: new 77	java/lang/String
    //   53: dup
    //   54: aload 4
    //   56: aload_2
    //   57: invokespecial 208	java/lang/String:<init>	([BLjava/lang/String;)V
    //   60: astore_2
    //   61: new 132	org/json/JSONObject
    //   64: dup
    //   65: aload_2
    //   66: invokespecial 209	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   69: astore 4
    //   71: aload 4
    //   73: ldc 211
    //   75: invokevirtual 214	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   78: astore_2
    //   79: aload_0
    //   80: aload_2
    //   81: ldc 216
    //   83: invokevirtual 214	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   86: invokespecial 218	com/tencent/tencentmap/mapsdk/maps/a/li:a	(Lorg/json/JSONObject;)V
    //   89: aload 4
    //   91: ldc 220
    //   93: invokevirtual 214	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   96: astore_2
    //   97: aload_2
    //   98: ldc 222
    //   100: invokevirtual 226	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   103: istore_1
    //   104: aload_2
    //   105: ldc 228
    //   107: invokevirtual 231	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   110: astore_2
    //   111: iload_1
    //   112: ifne +89 -> 201
    //   115: iconst_0
    //   116: putstatic 234	com/tencent/tencentmap/mapsdk/maps/a/ka:f	I
    //   119: invokestatic 240	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   122: iconst_1
    //   123: invokevirtual 243	java/util/Calendar:get	(I)I
    //   126: putstatic 246	com/tencent/tencentmap/mapsdk/maps/a/ka:g	I
    //   129: invokestatic 240	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   132: iconst_2
    //   133: invokevirtual 243	java/util/Calendar:get	(I)I
    //   136: putstatic 249	com/tencent/tencentmap/mapsdk/maps/a/ka:h	I
    //   139: invokestatic 240	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   142: iconst_5
    //   143: invokevirtual 243	java/util/Calendar:get	(I)I
    //   146: putstatic 251	com/tencent/tencentmap/mapsdk/maps/a/ka:i	I
    //   149: aload_0
    //   150: invokespecial 253	com/tencent/tencentmap/mapsdk/maps/a/li:b	()V
    //   153: ldc 191
    //   155: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   158: return
    //   159: astore_2
    //   160: ldc 191
    //   162: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   165: return
    //   166: astore_2
    //   167: ldc 191
    //   169: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   172: return
    //   173: astore_2
    //   174: aconst_null
    //   175: astore_2
    //   176: goto -97 -> 79
    //   179: astore_2
    //   180: aload_0
    //   181: aconst_null
    //   182: invokespecial 218	com/tencent/tencentmap/mapsdk/maps/a/li:a	(Lorg/json/JSONObject;)V
    //   185: goto -96 -> 89
    //   188: astore_3
    //   189: iconst_0
    //   190: istore_1
    //   191: goto -87 -> 104
    //   194: astore_2
    //   195: ldc 255
    //   197: astore_2
    //   198: goto -87 -> 111
    //   201: aload_0
    //   202: iload_1
    //   203: aload_2
    //   204: invokespecial 257	com/tencent/tencentmap/mapsdk/maps/a/li:a	(ILjava/lang/String;)V
    //   207: iload_1
    //   208: sipush -400
    //   211: if_icmpge +10 -> 221
    //   214: iconst_m1
    //   215: putstatic 234	com/tencent/tencentmap/mapsdk/maps/a/ka:f	I
    //   218: goto -99 -> 119
    //   221: iconst_1
    //   222: putstatic 234	com/tencent/tencentmap/mapsdk/maps/a/ka:f	I
    //   225: goto -106 -> 119
    //   228: astore_2
    //   229: aload_3
    //   230: astore_2
    //   231: goto -134 -> 97
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	234	0	this	li
    //   103	109	1	i	int
    //   30	1	2	localException1	java.lang.Exception
    //   42	69	2	localObject1	Object
    //   159	1	2	localUnsupportedEncodingException	java.io.UnsupportedEncodingException
    //   166	1	2	localException2	java.lang.Exception
    //   173	1	2	localException3	java.lang.Exception
    //   175	1	2	localObject2	Object
    //   179	1	2	localException4	java.lang.Exception
    //   194	1	2	localJSONException	org.json.JSONException
    //   197	7	2	str	String
    //   228	1	2	localException5	java.lang.Exception
    //   230	1	2	localException6	java.lang.Exception
    //   1	1	3	localObject3	Object
    //   188	42	3	localException7	java.lang.Exception
    //   17	73	4	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   7	19	30	java/lang/Exception
    //   50	61	159	java/io/UnsupportedEncodingException
    //   61	71	166	java/lang/Exception
    //   71	79	173	java/lang/Exception
    //   79	89	179	java/lang/Exception
    //   97	104	188	java/lang/Exception
    //   104	111	194	org/json/JSONException
    //   89	97	228	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.li
 * JD-Core Version:    0.7.0.1
 */