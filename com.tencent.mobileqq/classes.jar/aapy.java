import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class aapy
  extends mui
{
  aapz jdField_a_of_type_Aapz;
  final String jdField_a_of_type_JavaLangString;
  
  aapy(String paramString, aapz paramaapz)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Aapz = paramaapz;
  }
  
  public static void a(String paramString1, String paramString2, aapz paramaapz)
  {
    String str = "http://pubacc.mobile.qq.com/mqqweb-rtx2qq/mqqweb/get_confid_by_discid?discid=" + paramString2;
    QLog.w(paramString1, 1, "getConfId, uin[" + paramString2 + "]");
    paramString1 = new aapy(paramString1, paramaapz);
    paramString2 = new ArrayList();
    paramaapz = new mum();
    paramaapz.jdField_a_of_type_JavaLangString = str;
    paramaapz.b = 1000;
    paramaapz.c = 1000;
    paramaapz.jdField_a_of_type_Int = 0;
    paramString2.add(paramaapz);
    paramString1.execute(new ArrayList[] { paramString2 });
  }
  
  /* Error */
  @android.annotation.TargetApi(9)
  public void a(mum parammum)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: bipush 156
    //   5: istore_2
    //   6: aload_1
    //   7: getfield 78	mum:jdField_a_of_type_Mun	Lmun;
    //   10: getfield 83	mun:jdField_a_of_type_Boolean	Z
    //   13: ifeq +472 -> 485
    //   16: new 85	java/lang/String
    //   19: dup
    //   20: aload_1
    //   21: getfield 78	mum:jdField_a_of_type_Mun	Lmun;
    //   24: getfield 88	mun:jdField_a_of_type_ArrayOfByte	[B
    //   27: ldc 90
    //   29: invokespecial 93	java/lang/String:<init>	([BLjava/lang/String;)V
    //   32: astore_1
    //   33: aload_1
    //   34: ifnull +443 -> 477
    //   37: new 95	org/json/JSONObject
    //   40: dup
    //   41: aload_1
    //   42: invokespecial 98	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   45: astore 6
    //   47: aload 6
    //   49: ldc 100
    //   51: invokevirtual 104	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   54: istore_2
    //   55: invokestatic 108	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   58: ifeq +30 -> 88
    //   61: aload_0
    //   62: getfield 14	aapy:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   65: iconst_2
    //   66: new 20	java/lang/StringBuilder
    //   69: dup
    //   70: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   73: ldc 110
    //   75: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: iload_2
    //   79: invokevirtual 113	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   82: invokevirtual 31	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: invokestatic 116	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   88: iload_2
    //   89: ifne +380 -> 469
    //   92: aload 6
    //   94: ldc 118
    //   96: invokevirtual 122	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   99: astore 7
    //   101: aload 7
    //   103: ifnull +366 -> 469
    //   106: aload 7
    //   108: ldc 124
    //   110: invokevirtual 128	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   113: astore 6
    //   115: aload 6
    //   117: ldc 130
    //   119: invokevirtual 133	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   122: ifeq +347 -> 469
    //   125: aload 7
    //   127: ldc 135
    //   129: invokevirtual 128	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   132: astore 8
    //   134: aload 7
    //   136: ldc 137
    //   138: invokevirtual 128	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   141: astore 7
    //   143: aload 8
    //   145: invokestatic 143	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   148: ifne +164 -> 312
    //   151: aload 8
    //   153: ldc 145
    //   155: invokevirtual 148	java/lang/String:compareToIgnoreCase	(Ljava/lang/String;)I
    //   158: ifeq +154 -> 312
    //   161: aload 8
    //   163: invokestatic 154	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   166: invokevirtual 158	java/lang/Integer:intValue	()I
    //   169: istore 4
    //   171: aload 7
    //   173: invokestatic 154	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   176: invokevirtual 158	java/lang/Integer:intValue	()I
    //   179: istore_3
    //   180: iload 5
    //   182: istore_2
    //   183: aload_0
    //   184: getfield 14	aapy:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   187: iconst_1
    //   188: new 20	java/lang/StringBuilder
    //   191: dup
    //   192: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   195: ldc 160
    //   197: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: iload_2
    //   201: invokevirtual 113	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   204: ldc 162
    //   206: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: iload_3
    //   210: invokevirtual 113	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   213: ldc 164
    //   215: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: iload 4
    //   220: invokevirtual 113	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   223: ldc 166
    //   225: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: aload_1
    //   229: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: ldc 35
    //   234: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: invokevirtual 31	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: invokestatic 41	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   243: aload_0
    //   244: getfield 16	aapy:jdField_a_of_type_Aapz	Laapz;
    //   247: ifnull +20 -> 267
    //   250: aload_0
    //   251: getfield 16	aapy:jdField_a_of_type_Aapz	Laapz;
    //   254: iload_3
    //   255: iload 4
    //   257: invokeinterface 171 3 0
    //   262: aload_0
    //   263: aconst_null
    //   264: putfield 16	aapy:jdField_a_of_type_Aapz	Laapz;
    //   267: return
    //   268: astore_1
    //   269: invokestatic 108	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   272: ifeq +33 -> 305
    //   275: aload_0
    //   276: getfield 14	aapy:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   279: iconst_2
    //   280: new 20	java/lang/StringBuilder
    //   283: dup
    //   284: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   287: ldc 173
    //   289: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: aload_1
    //   293: invokevirtual 174	java/lang/Exception:toString	()Ljava/lang/String;
    //   296: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: invokevirtual 31	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   302: invokestatic 177	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   305: aconst_null
    //   306: astore_1
    //   307: iconst_m1
    //   308: istore_2
    //   309: goto -276 -> 33
    //   312: iconst_0
    //   313: istore 4
    //   315: bipush 254
    //   317: istore_2
    //   318: iconst_0
    //   319: istore_3
    //   320: goto -137 -> 183
    //   323: astore 6
    //   325: aconst_null
    //   326: astore 6
    //   328: iconst_0
    //   329: istore 4
    //   331: bipush 253
    //   333: istore_2
    //   334: invokestatic 108	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   337: ifeq +41 -> 378
    //   340: aload_0
    //   341: getfield 14	aapy:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   344: iconst_2
    //   345: new 20	java/lang/StringBuilder
    //   348: dup
    //   349: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   352: ldc 179
    //   354: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: aload 6
    //   359: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: ldc 181
    //   364: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: bipush 253
    //   369: invokevirtual 113	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   372: invokevirtual 31	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   375: invokestatic 177	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   378: iconst_0
    //   379: istore_3
    //   380: goto -197 -> 183
    //   383: astore 6
    //   385: aconst_null
    //   386: astore 6
    //   388: iconst_0
    //   389: istore 4
    //   391: bipush 252
    //   393: istore_2
    //   394: invokestatic 108	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   397: ifeq +41 -> 438
    //   400: aload_0
    //   401: getfield 14	aapy:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   404: iconst_2
    //   405: new 20	java/lang/StringBuilder
    //   408: dup
    //   409: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   412: ldc 179
    //   414: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   417: aload 6
    //   419: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   422: ldc 181
    //   424: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: bipush 252
    //   429: invokevirtual 113	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   432: invokevirtual 31	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   435: invokestatic 177	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   438: iconst_0
    //   439: istore_3
    //   440: goto -257 -> 183
    //   443: astore 7
    //   445: iconst_0
    //   446: istore 4
    //   448: goto -57 -> 391
    //   451: astore 7
    //   453: goto -62 -> 391
    //   456: astore 7
    //   458: iconst_0
    //   459: istore 4
    //   461: goto -130 -> 331
    //   464: astore 7
    //   466: goto -135 -> 331
    //   469: iconst_0
    //   470: istore 4
    //   472: iconst_0
    //   473: istore_3
    //   474: goto -291 -> 183
    //   477: iconst_0
    //   478: istore_3
    //   479: iconst_0
    //   480: istore 4
    //   482: goto -299 -> 183
    //   485: iconst_0
    //   486: istore_3
    //   487: iconst_0
    //   488: istore 4
    //   490: aconst_null
    //   491: astore_1
    //   492: goto -309 -> 183
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	495	0	this	aapy
    //   0	495	1	parammum	mum
    //   5	389	2	i	int
    //   179	308	3	j	int
    //   169	320	4	k	int
    //   1	180	5	m	int
    //   45	71	6	localObject1	java.lang.Object
    //   323	1	6	localJSONException1	org.json.JSONException
    //   326	32	6	str1	String
    //   383	1	6	localException1	java.lang.Exception
    //   386	32	6	str2	String
    //   99	73	7	localObject2	java.lang.Object
    //   443	1	7	localException2	java.lang.Exception
    //   451	1	7	localException3	java.lang.Exception
    //   456	1	7	localJSONException2	org.json.JSONException
    //   464	1	7	localJSONException3	org.json.JSONException
    //   132	30	8	str3	String
    // Exception table:
    //   from	to	target	type
    //   16	33	268	java/lang/Exception
    //   37	88	323	org/json/JSONException
    //   92	101	323	org/json/JSONException
    //   106	115	323	org/json/JSONException
    //   37	88	383	java/lang/Exception
    //   92	101	383	java/lang/Exception
    //   106	115	383	java/lang/Exception
    //   115	171	443	java/lang/Exception
    //   171	180	451	java/lang/Exception
    //   115	171	456	org/json/JSONException
    //   171	180	464	org/json/JSONException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aapy
 * JD-Core Version:    0.7.0.1
 */