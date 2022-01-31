import com.tencent.mobileqq.jsp.MediaApiPlugin;
import java.util.concurrent.atomic.AtomicBoolean;

public class admh
  implements Runnable
{
  public admh(MediaApiPlugin paramMediaApiPlugin, String paramString1, String paramString2, AtomicBoolean paramAtomicBoolean) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: new 36	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 37	org/json/JSONObject:<init>	()V
    //   7: astore 4
    //   9: invokestatic 43	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   12: astore 5
    //   14: aconst_null
    //   15: astore_3
    //   16: aload_3
    //   17: astore_2
    //   18: aload_0
    //   19: getfield 17	admh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   22: ldc 45
    //   24: invokevirtual 51	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   27: ifeq +32 -> 59
    //   30: aload_0
    //   31: getfield 17	admh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   34: bipush 44
    //   36: invokevirtual 55	java/lang/String:indexOf	(I)I
    //   39: istore_1
    //   40: aload_3
    //   41: astore_2
    //   42: iload_1
    //   43: ifle +16 -> 59
    //   46: aload_0
    //   47: getfield 17	admh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   50: iload_1
    //   51: invokevirtual 59	java/lang/String:substring	(I)Ljava/lang/String;
    //   54: iconst_0
    //   55: invokestatic 65	com/tencent/mobileqq/utils/Base64Util:decode	(Ljava/lang/String;I)[B
    //   58: astore_2
    //   59: aload_2
    //   60: ifnonnull +82 -> 142
    //   63: new 30	java/lang/IllegalArgumentException
    //   66: dup
    //   67: invokespecial 66	java/lang/IllegalArgumentException:<init>	()V
    //   70: athrow
    //   71: astore_2
    //   72: aload 4
    //   74: ldc 68
    //   76: iconst_1
    //   77: invokevirtual 72	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   80: pop
    //   81: aload 4
    //   83: ldc 74
    //   85: aload 5
    //   87: ldc 75
    //   89: invokevirtual 80	android/content/Context:getString	(I)Ljava/lang/String;
    //   92: invokevirtual 83	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   95: pop
    //   96: aload_0
    //   97: getfield 19	admh:b	Ljava/lang/String;
    //   100: invokestatic 89	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   103: ifne +152 -> 255
    //   106: aload_0
    //   107: getfield 21	admh:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   110: iconst_0
    //   111: iconst_1
    //   112: invokevirtual 95	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   115: ifeq +140 -> 255
    //   118: aload_0
    //   119: getfield 15	admh:jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   122: aload_0
    //   123: getfield 19	admh:b	Ljava/lang/String;
    //   126: iconst_1
    //   127: anewarray 47	java/lang/String
    //   130: dup
    //   131: iconst_0
    //   132: aload 4
    //   134: invokevirtual 99	org/json/JSONObject:toString	()Ljava/lang/String;
    //   137: aastore
    //   138: invokevirtual 105	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   141: return
    //   142: aload_0
    //   143: getfield 15	admh:jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   146: aload_2
    //   147: invokevirtual 108	com/tencent/mobileqq/jsp/MediaApiPlugin:a	([B)Ljava/lang/String;
    //   150: astore_2
    //   151: aload 4
    //   153: ldc 68
    //   155: iconst_0
    //   156: invokevirtual 72	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   159: pop
    //   160: aload 4
    //   162: ldc 74
    //   164: aload 5
    //   166: ldc 109
    //   168: invokevirtual 80	android/content/Context:getString	(I)Ljava/lang/String;
    //   171: invokevirtual 83	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   174: pop
    //   175: aload 4
    //   177: ldc 111
    //   179: aload_2
    //   180: invokevirtual 83	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   183: pop
    //   184: goto -88 -> 96
    //   187: astore_2
    //   188: goto -92 -> 96
    //   191: astore_2
    //   192: aload 4
    //   194: ldc 68
    //   196: iconst_2
    //   197: invokevirtual 72	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   200: pop
    //   201: aload 4
    //   203: ldc 74
    //   205: aload 5
    //   207: ldc 112
    //   209: invokevirtual 80	android/content/Context:getString	(I)Ljava/lang/String;
    //   212: invokevirtual 83	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   215: pop
    //   216: goto -120 -> 96
    //   219: astore_2
    //   220: goto -124 -> 96
    //   223: astore_2
    //   224: aload 4
    //   226: ldc 68
    //   228: iconst_m1
    //   229: invokevirtual 72	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   232: pop
    //   233: aload 4
    //   235: ldc 74
    //   237: aload 5
    //   239: ldc 113
    //   241: invokevirtual 80	android/content/Context:getString	(I)Ljava/lang/String;
    //   244: invokevirtual 83	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   247: pop
    //   248: goto -152 -> 96
    //   251: astore_2
    //   252: goto -156 -> 96
    //   255: aload_0
    //   256: getfield 15	admh:jdField_a_of_type_ComTencentMobileqqJspMediaApiPlugin	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   259: ldc 115
    //   261: iconst_0
    //   262: aload 4
    //   264: invokevirtual 99	org/json/JSONObject:toString	()Ljava/lang/String;
    //   267: invokevirtual 119	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs4OpenApiIfNeeded	(Ljava/lang/String;ILjava/lang/String;)V
    //   270: return
    //   271: astore_2
    //   272: goto -176 -> 96
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	275	0	this	admh
    //   39	12	1	i	int
    //   17	43	2	localObject1	Object
    //   71	76	2	localIOException	java.io.IOException
    //   150	30	2	str	String
    //   187	1	2	localJSONException1	org.json.JSONException
    //   191	1	2	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   219	1	2	localJSONException2	org.json.JSONException
    //   223	1	2	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   251	1	2	localJSONException3	org.json.JSONException
    //   271	1	2	localJSONException4	org.json.JSONException
    //   15	26	3	localObject2	Object
    //   7	256	4	localJSONObject	org.json.JSONObject
    //   12	226	5	localBaseApplication	com.tencent.qphone.base.util.BaseApplication
    // Exception table:
    //   from	to	target	type
    //   18	40	71	java/io/IOException
    //   46	59	71	java/io/IOException
    //   63	71	71	java/io/IOException
    //   142	151	71	java/io/IOException
    //   151	184	71	java/io/IOException
    //   151	184	187	org/json/JSONException
    //   18	40	191	java/lang/IllegalArgumentException
    //   46	59	191	java/lang/IllegalArgumentException
    //   63	71	191	java/lang/IllegalArgumentException
    //   142	151	191	java/lang/IllegalArgumentException
    //   151	184	191	java/lang/IllegalArgumentException
    //   192	216	219	org/json/JSONException
    //   18	40	223	java/lang/OutOfMemoryError
    //   46	59	223	java/lang/OutOfMemoryError
    //   63	71	223	java/lang/OutOfMemoryError
    //   142	151	223	java/lang/OutOfMemoryError
    //   151	184	223	java/lang/OutOfMemoryError
    //   224	248	251	org/json/JSONException
    //   72	96	271	org/json/JSONException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     admh
 * JD-Core Version:    0.7.0.1
 */