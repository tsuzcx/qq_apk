package com.tencent.tencentmap.mapsdk.a;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;
import org.json.JSONArray;
import org.json.JSONObject;

public class md
  extends AsyncTask<String, Void, Void>
{
  private Handler a;
  private String b;
  private WeakReference<mc> c;
  
  public md(Handler paramHandler, mc parammc, String paramString1, String paramString2)
  {
    this.a = paramHandler;
    this.c = new WeakReference(parammc);
    this.b = lq.a(paramString1, paramString2);
  }
  
  private void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      if ((this.c != null) && (this.c.get() != null)) {
        ((mc)this.c.get()).a(null, null);
      }
    }
    JSONArray localJSONArray;
    do
    {
      return;
      localJSONArray = paramJSONObject.optJSONObject("custom_map_style").optJSONArray("style_list");
      paramJSONObject = b(paramJSONObject.optJSONObject("indoor_map"));
    } while ((this.c == null) || (this.c.get() == null));
    ((mc)this.c.get()).a(localJSONArray, paramJSONObject);
  }
  
  private o b(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    int i;
    int j;
    do
    {
      return null;
      i = paramJSONObject.optInt("enable", -1);
      j = paramJSONObject.optInt("type", -1);
    } while ((i == -1) || (j == -1));
    return new o(i, j, paramJSONObject.optJSONArray("building_list"));
  }
  
  private void b()
  {
    if (this.a != null)
    {
      Object localObject = new mt();
      ((mt)localObject).a = 3;
      localObject = this.a.obtainMessage(((mt)localObject).a, localObject);
      this.a.sendMessage((Message)localObject);
    }
  }
  
  protected Void a(String... paramVarArgs)
  {
    a();
    return null;
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: invokestatic 106	com/tencent/tencentmap/mapsdk/a/qs:a	()Lcom/tencent/tencentmap/mapsdk/a/qs;
    //   5: aload_0
    //   6: getfield 33	com/tencent/tencentmap/mapsdk/a/md:b	Ljava/lang/String;
    //   9: invokevirtual 109	com/tencent/tencentmap/mapsdk/a/qs:a	(Ljava/lang/String;)Lcom/tencent/tencentmap/mapsdk/a/qt;
    //   12: astore 4
    //   14: aload 4
    //   16: ifnonnull +4 -> 20
    //   19: return
    //   20: aload 4
    //   22: getfield 112	com/tencent/tencentmap/mapsdk/a/qt:b	Ljava/lang/String;
    //   25: astore_2
    //   26: aload 4
    //   28: getfield 115	com/tencent/tencentmap/mapsdk/a/qt:a	[B
    //   31: astore 4
    //   33: new 117	java/lang/String
    //   36: dup
    //   37: aload 4
    //   39: aload_2
    //   40: invokespecial 120	java/lang/String:<init>	([BLjava/lang/String;)V
    //   43: astore_2
    //   44: new 48	org/json/JSONObject
    //   47: dup
    //   48: aload_2
    //   49: invokespecial 123	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   52: astore 4
    //   54: aload 4
    //   56: ldc 125
    //   58: invokevirtual 128	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   61: astore_2
    //   62: aload_0
    //   63: aload_2
    //   64: ldc 130
    //   66: invokevirtual 128	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   69: invokespecial 132	com/tencent/tencentmap/mapsdk/a/md:a	(Lorg/json/JSONObject;)V
    //   72: aload 4
    //   74: ldc 134
    //   76: invokevirtual 128	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   79: astore_2
    //   80: aload_2
    //   81: ldc 136
    //   83: invokevirtual 140	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   86: istore_1
    //   87: iload_1
    //   88: ifne +63 -> 151
    //   91: iconst_0
    //   92: putstatic 143	com/tencent/tencentmap/mapsdk/a/lq:e	I
    //   95: invokestatic 149	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   98: iconst_1
    //   99: invokevirtual 152	java/util/Calendar:get	(I)I
    //   102: putstatic 155	com/tencent/tencentmap/mapsdk/a/lq:f	I
    //   105: invokestatic 149	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   108: iconst_2
    //   109: invokevirtual 152	java/util/Calendar:get	(I)I
    //   112: putstatic 158	com/tencent/tencentmap/mapsdk/a/lq:g	I
    //   115: invokestatic 149	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   118: iconst_5
    //   119: invokevirtual 152	java/util/Calendar:get	(I)I
    //   122: putstatic 161	com/tencent/tencentmap/mapsdk/a/lq:h	I
    //   125: aload_0
    //   126: invokespecial 163	com/tencent/tencentmap/mapsdk/a/md:b	()V
    //   129: return
    //   130: astore_2
    //   131: aconst_null
    //   132: astore_2
    //   133: goto -71 -> 62
    //   136: astore_2
    //   137: aload_0
    //   138: aconst_null
    //   139: invokespecial 132	com/tencent/tencentmap/mapsdk/a/md:a	(Lorg/json/JSONObject;)V
    //   142: goto -70 -> 72
    //   145: astore_2
    //   146: iconst_0
    //   147: istore_1
    //   148: goto -61 -> 87
    //   151: iconst_1
    //   152: putstatic 143	com/tencent/tencentmap/mapsdk/a/lq:e	I
    //   155: goto -60 -> 95
    //   158: astore_2
    //   159: aload_3
    //   160: astore_2
    //   161: goto -81 -> 80
    //   164: astore_2
    //   165: return
    //   166: astore_2
    //   167: return
    //   168: astore_2
    //   169: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	170	0	this	md
    //   86	62	1	i	int
    //   25	56	2	localObject1	Object
    //   130	1	2	localException1	java.lang.Exception
    //   132	1	2	localObject2	Object
    //   136	1	2	localException2	java.lang.Exception
    //   145	1	2	localException3	java.lang.Exception
    //   158	1	2	localException4	java.lang.Exception
    //   160	1	2	localObject3	Object
    //   164	1	2	localException5	java.lang.Exception
    //   166	1	2	localUnsupportedEncodingException	java.io.UnsupportedEncodingException
    //   168	1	2	localException6	java.lang.Exception
    //   1	159	3	localObject4	Object
    //   12	61	4	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   54	62	130	java/lang/Exception
    //   62	72	136	java/lang/Exception
    //   80	87	145	java/lang/Exception
    //   72	80	158	java/lang/Exception
    //   44	54	164	java/lang/Exception
    //   33	44	166	java/io/UnsupportedEncodingException
    //   2	14	168	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.md
 * JD-Core Version:    0.7.0.1
 */