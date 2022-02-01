import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aitr
{
  public static volatile aitq a;
  
  /* Error */
  public static aitq a(android.content.Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: ldc 2
    //   8: monitorenter
    //   9: aload 5
    //   11: astore_3
    //   12: aload_0
    //   13: ifnull +10 -> 23
    //   16: aload_1
    //   17: ifnonnull +11 -> 28
    //   20: aload 5
    //   22: astore_3
    //   23: ldc 2
    //   25: monitorexit
    //   26: aload_3
    //   27: areturn
    //   28: getstatic 11	aitr:a	Laitq;
    //   31: ifnonnull +64 -> 95
    //   34: aload_0
    //   35: ldc 13
    //   37: iconst_4
    //   38: invokevirtual 19	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   41: new 21	java/lang/StringBuilder
    //   44: dup
    //   45: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   48: ldc 27
    //   50: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: aload_1
    //   54: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: aconst_null
    //   61: invokeinterface 41 3 0
    //   66: astore_1
    //   67: aload_1
    //   68: invokestatic 47	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   71: istore_2
    //   72: aload 5
    //   74: astore_3
    //   75: iload_2
    //   76: ifne -53 -> 23
    //   79: new 49	org/json/JSONObject
    //   82: dup
    //   83: aload_1
    //   84: invokespecial 52	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   87: astore_0
    //   88: aload_0
    //   89: invokestatic 55	aitr:a	(Lorg/json/JSONObject;)Laitq;
    //   92: putstatic 11	aitr:a	Laitq;
    //   95: getstatic 11	aitr:a	Laitq;
    //   98: astore_3
    //   99: goto -76 -> 23
    //   102: astore_0
    //   103: ldc 57
    //   105: iconst_2
    //   106: new 21	java/lang/StringBuilder
    //   109: dup
    //   110: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   113: ldc 59
    //   115: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: aload_1
    //   119: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: aload_0
    //   126: invokestatic 65	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   129: aload 4
    //   131: astore_0
    //   132: goto -44 -> 88
    //   135: astore_0
    //   136: ldc 2
    //   138: monitorexit
    //   139: aload_0
    //   140: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	141	0	paramContext	android.content.Context
    //   0	141	1	paramString	String
    //   71	5	2	bool	boolean
    //   11	88	3	localObject1	Object
    //   1	129	4	localObject2	Object
    //   4	69	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   79	88	102	java/lang/Exception
    //   28	72	135	finally
    //   79	88	135	finally
    //   88	95	135	finally
    //   95	99	135	finally
    //   103	129	135	finally
  }
  
  /* Error */
  public static aitq a(JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: iconst_0
    //   3: istore 4
    //   5: iconst_0
    //   6: istore_2
    //   7: new 70	java/util/ArrayList
    //   10: dup
    //   11: invokespecial 71	java/util/ArrayList:<init>	()V
    //   14: astore 6
    //   16: aload_0
    //   17: ldc 73
    //   19: invokevirtual 77	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   22: ifeq +164 -> 186
    //   25: aload_0
    //   26: ldc 73
    //   28: invokevirtual 81	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   31: istore_1
    //   32: iload_1
    //   33: iconst_1
    //   34: if_icmpne +78 -> 112
    //   37: aload_0
    //   38: ldc 83
    //   40: invokevirtual 77	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   43: ifeq +138 -> 181
    //   46: aload_0
    //   47: ldc 83
    //   49: invokevirtual 81	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   52: istore_1
    //   53: aload_0
    //   54: ldc 85
    //   56: invokevirtual 77	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   59: ifeq +58 -> 117
    //   62: aload_0
    //   63: ldc 85
    //   65: invokevirtual 89	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   68: astore 5
    //   70: iload_2
    //   71: aload 5
    //   73: invokevirtual 95	org/json/JSONArray:length	()I
    //   76: if_icmpge +41 -> 117
    //   79: aload 5
    //   81: iload_2
    //   82: invokevirtual 99	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   85: invokestatic 102	aitr:a	(Lorg/json/JSONObject;)Laitw;
    //   88: astore 7
    //   90: aload 7
    //   92: ifnull +13 -> 105
    //   95: aload 6
    //   97: aload 7
    //   99: invokeinterface 108 2 0
    //   104: pop
    //   105: iload_2
    //   106: iconst_1
    //   107: iadd
    //   108: istore_2
    //   109: goto -39 -> 70
    //   112: iconst_0
    //   113: istore_3
    //   114: goto -77 -> 37
    //   117: new 110	aitq
    //   120: dup
    //   121: iload_3
    //   122: iload_1
    //   123: aload 6
    //   125: invokespecial 113	aitq:<init>	(ZILjava/util/List;)V
    //   128: areturn
    //   129: astore 5
    //   131: iconst_0
    //   132: istore_1
    //   133: iload 4
    //   135: istore_3
    //   136: ldc 57
    //   138: iconst_2
    //   139: new 21	java/lang/StringBuilder
    //   142: dup
    //   143: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   146: ldc 115
    //   148: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: aload_0
    //   152: invokevirtual 116	org/json/JSONObject:toString	()Ljava/lang/String;
    //   155: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   161: aload 5
    //   163: invokestatic 65	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   166: goto -49 -> 117
    //   169: astore 5
    //   171: iconst_0
    //   172: istore_1
    //   173: goto -37 -> 136
    //   176: astore 5
    //   178: goto -42 -> 136
    //   181: iconst_0
    //   182: istore_1
    //   183: goto -130 -> 53
    //   186: iconst_0
    //   187: istore_3
    //   188: goto -151 -> 37
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	191	0	paramJSONObject	JSONObject
    //   31	152	1	i	int
    //   6	103	2	j	int
    //   1	187	3	bool1	boolean
    //   3	131	4	bool2	boolean
    //   68	12	5	localJSONArray	JSONArray
    //   129	33	5	localJSONException1	JSONException
    //   169	1	5	localJSONException2	JSONException
    //   176	1	5	localJSONException3	JSONException
    //   14	110	6	localArrayList	ArrayList
    //   88	10	7	localaitw	aitw
    // Exception table:
    //   from	to	target	type
    //   16	32	129	org/json/JSONException
    //   37	53	169	org/json/JSONException
    //   53	70	176	org/json/JSONException
    //   70	90	176	org/json/JSONException
    //   95	105	176	org/json/JSONException
  }
  
  public static aitw a(JSONObject paramJSONObject)
  {
    int j = 0;
    localArrayList1 = new ArrayList();
    localArrayList2 = new ArrayList();
    try
    {
      JSONArray localJSONArray;
      int i;
      if (paramJSONObject.has("keyWords"))
      {
        localJSONArray = paramJSONObject.getJSONArray("keyWords");
        i = 0;
        while (i < localJSONArray.length())
        {
          localArrayList1.add(localJSONArray.getString(i));
          i += 1;
        }
      }
      if (paramJSONObject.has("emos"))
      {
        localJSONArray = paramJSONObject.getJSONArray("emos");
        i = j;
        while (i < localJSONArray.length())
        {
          Object localObject = localJSONArray.getJSONObject(i);
          String str1 = ((JSONObject)localObject).optString("imgUrl", "");
          String str2 = ((JSONObject)localObject).optString("md5", "");
          long l = ((JSONObject)localObject).optLong("fileSize", 0L);
          j = ((JSONObject)localObject).optInt("width", 0);
          int k = ((JSONObject)localObject).optInt("height", 0);
          String str3 = ((JSONObject)localObject).optString("jumpUrl", "");
          localObject = ((JSONObject)localObject).optString("desc", "");
          aitu localaitu = new aitu();
          localaitu.jdField_a_of_type_JavaLangString = str1;
          localaitu.jdField_b_of_type_JavaLangString = str2;
          localaitu.jdField_a_of_type_Long = Long.valueOf(l).longValue();
          localaitu.jdField_a_of_type_Int = j;
          localaitu.jdField_b_of_type_Int = k;
          localaitu.c = str3;
          localaitu.d = ((String)localObject);
          localArrayList2.add(localaitu);
          i += 1;
        }
      }
      return new aitw(localArrayList1, localArrayList2);
    }
    catch (JSONException localJSONException)
    {
      QLog.e("AdEmoCfgProvider", 2, "parseAdItemJson has exception， adObject = " + paramJSONObject.toString(), localJSONException);
    }
  }
  
  /* Error */
  public static void a(android.content.Context paramContext, String paramString, JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 195	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +39 -> 45
    //   9: new 21	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   16: ldc 197
    //   18: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: astore 4
    //   23: aload_2
    //   24: ifnonnull +81 -> 105
    //   27: ldc 199
    //   29: astore_3
    //   30: ldc 57
    //   32: iconst_2
    //   33: aload 4
    //   35: aload_3
    //   36: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokestatic 202	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   45: aload_2
    //   46: invokestatic 55	aitr:a	(Lorg/json/JSONObject;)Laitq;
    //   49: putstatic 11	aitr:a	Laitq;
    //   52: aload_0
    //   53: ifnull +48 -> 101
    //   56: aload_0
    //   57: ldc 13
    //   59: iconst_4
    //   60: invokevirtual 19	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   63: invokeinterface 206 1 0
    //   68: new 21	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   75: ldc 27
    //   77: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: aload_1
    //   81: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: aload_2
    //   88: invokevirtual 116	org/json/JSONObject:toString	()Ljava/lang/String;
    //   91: invokeinterface 212 3 0
    //   96: invokeinterface 215 1 0
    //   101: ldc 2
    //   103: monitorexit
    //   104: return
    //   105: aload_2
    //   106: invokevirtual 116	org/json/JSONObject:toString	()Ljava/lang/String;
    //   109: astore_3
    //   110: goto -80 -> 30
    //   113: astore_0
    //   114: ldc 2
    //   116: monitorexit
    //   117: aload_0
    //   118: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	119	0	paramContext	android.content.Context
    //   0	119	1	paramString	String
    //   0	119	2	paramJSONObject	JSONObject
    //   29	81	3	str	String
    //   21	13	4	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   3	23	113	finally
    //   30	45	113	finally
    //   45	52	113	finally
    //   56	101	113	finally
    //   105	110	113	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aitr
 * JD-Core Version:    0.7.0.1
 */