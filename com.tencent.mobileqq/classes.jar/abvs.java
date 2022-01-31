import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.SparseArray;
import com.tencent.mfsdk.collector.ResultObject;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class abvs
{
  private static final long jdField_a_of_type_Long = ;
  private static abvs jdField_a_of_type_Abvs;
  private abvt jdField_a_of_type_Abvt;
  private SQLiteDatabase jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase;
  
  private abvs(Context paramContext)
  {
    this.jdField_a_of_type_Abvt = abvt.a(paramContext);
    try
    {
      this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase = this.jdField_a_of_type_Abvt.getWritableDatabase();
      return;
    }
    catch (Exception paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("Magnifier_DBHandler", 2, paramContext, new Object[0]);
    }
  }
  
  private int a(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    if ((this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase == null) || (!this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.isOpen())) {
      return -2;
    }
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("Magnifier_DBHandler", 2, new Object[] { "dropframe delete table", paramString1 });
      }
      int i = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.delete(paramString1, paramString2, paramArrayOfString);
      return i;
    }
    catch (Throwable paramString1)
    {
      QLog.e("Magnifier_DBHandler", 1, "delete dropframe table has a exception", paramString1);
    }
    return -1;
  }
  
  public static abvs a(Context paramContext)
  {
    if (jdField_a_of_type_Abvs == null) {}
    try
    {
      if (jdField_a_of_type_Abvs == null) {
        jdField_a_of_type_Abvs = new abvs(paramContext);
      }
      return jdField_a_of_type_Abvs;
    }
    finally {}
  }
  
  private ResultObject a(Cursor paramCursor)
  {
    if (paramCursor == null) {
      return null;
    }
    ResultObject localResultObject = new ResultObject();
    localResultObject.dbId = paramCursor.getInt(paramCursor.getColumnIndex("_id"));
    localResultObject.params = new JSONObject(paramCursor.getString(paramCursor.getColumnIndex("params")));
    if (paramCursor.getInt(paramCursor.getColumnIndex("is_real_time")) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      localResultObject.isRealTime = bool;
      localResultObject.uin = paramCursor.getLong(paramCursor.getColumnIndex("uin"));
      return localResultObject;
    }
  }
  
  private JSONObject a(abvp paramabvp)
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    localJSONObject2.put("dropDuration", (float)paramabvp.b / 1000.0F);
    int i = 0;
    while (i < 6)
    {
      localJSONArray.put(i, paramabvp.jdField_a_of_type_ArrayOfLong[i]);
      i += 1;
    }
    localJSONObject2.put("dropTimes", localJSONArray);
    localJSONObject1.put(String.valueOf(paramabvp.jdField_a_of_type_Int), localJSONObject2);
    return localJSONObject1;
  }
  
  private JSONObject a(HashMap<String, abvp> paramHashMap)
  {
    JSONObject localJSONObject = new JSONObject();
    Iterator localIterator = paramHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localJSONObject.put(str, a((abvp)paramHashMap.get(str)));
    }
    return localJSONObject;
  }
  
  /* Error */
  private java.util.List<ResultObject> b(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 39	abvs:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   4: ifnull +13 -> 17
    //   7: aload_0
    //   8: getfield 39	abvs:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   11: invokevirtual 59	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   14: ifne +5 -> 19
    //   17: aconst_null
    //   18: areturn
    //   19: bipush 101
    //   21: invokestatic 197	abvg:a	(I)V
    //   24: new 199	java/util/ArrayList
    //   27: dup
    //   28: invokespecial 200	java/util/ArrayList:<init>	()V
    //   31: astore 27
    //   33: new 164	java/util/HashMap
    //   36: dup
    //   37: invokespecial 201	java/util/HashMap:<init>	()V
    //   40: astore 26
    //   42: iconst_1
    //   43: iload_1
    //   44: if_icmpne +40 -> 84
    //   47: aload_0
    //   48: getfield 39	abvs:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   51: ldc 203
    //   53: aconst_null
    //   54: ldc 205
    //   56: aconst_null
    //   57: aconst_null
    //   58: aconst_null
    //   59: aconst_null
    //   60: invokevirtual 209	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   63: astore 25
    //   65: aload 25
    //   67: ifnonnull +37 -> 104
    //   70: aload 25
    //   72: ifnull -55 -> 17
    //   75: aload 25
    //   77: invokeinterface 212 1 0
    //   82: aconst_null
    //   83: areturn
    //   84: aload_0
    //   85: getfield 39	abvs:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   88: ldc 203
    //   90: aconst_null
    //   91: aconst_null
    //   92: aconst_null
    //   93: aconst_null
    //   94: aconst_null
    //   95: aconst_null
    //   96: invokevirtual 209	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   99: astore 25
    //   101: goto -36 -> 65
    //   104: aload 25
    //   106: invokeinterface 215 1 0
    //   111: pop
    //   112: aload 25
    //   114: invokeinterface 218 1 0
    //   119: ifne +579 -> 698
    //   122: aload 25
    //   124: aload 25
    //   126: ldc 220
    //   128: invokeinterface 90 2 0
    //   133: invokeinterface 106 2 0
    //   138: astore 28
    //   140: aload 25
    //   142: aload 25
    //   144: ldc 222
    //   146: invokeinterface 90 2 0
    //   151: invokeinterface 226 2 0
    //   156: istore_3
    //   157: iload_3
    //   158: istore_2
    //   159: iload_3
    //   160: ifgt +5 -> 165
    //   163: iconst_1
    //   164: istore_2
    //   165: aload 25
    //   167: aload 25
    //   169: ldc 228
    //   171: invokeinterface 90 2 0
    //   176: invokeinterface 124 2 0
    //   181: lstore 9
    //   183: aload 25
    //   185: aload 25
    //   187: ldc 230
    //   189: invokeinterface 90 2 0
    //   194: invokeinterface 124 2 0
    //   199: lstore 11
    //   201: aload 25
    //   203: aload 25
    //   205: ldc 232
    //   207: invokeinterface 90 2 0
    //   212: invokeinterface 94 2 0
    //   217: istore_3
    //   218: aload 25
    //   220: aload 25
    //   222: ldc 234
    //   224: invokeinterface 90 2 0
    //   229: invokeinterface 94 2 0
    //   234: istore 4
    //   236: aload 25
    //   238: aload 25
    //   240: ldc 236
    //   242: invokeinterface 90 2 0
    //   247: invokeinterface 94 2 0
    //   252: istore 5
    //   254: aload 25
    //   256: aload 25
    //   258: ldc 238
    //   260: invokeinterface 90 2 0
    //   265: invokeinterface 94 2 0
    //   270: istore 6
    //   272: aload 25
    //   274: aload 25
    //   276: ldc 240
    //   278: invokeinterface 90 2 0
    //   283: invokeinterface 94 2 0
    //   288: istore 7
    //   290: aload 25
    //   292: aload 25
    //   294: ldc 242
    //   296: invokeinterface 90 2 0
    //   301: invokeinterface 94 2 0
    //   306: istore 8
    //   308: iload_3
    //   309: i2l
    //   310: lstore 13
    //   312: iload 4
    //   314: i2l
    //   315: lstore 15
    //   317: iload 5
    //   319: i2l
    //   320: lstore 17
    //   322: iload 6
    //   324: i2l
    //   325: lstore 19
    //   327: iload 7
    //   329: i2l
    //   330: lstore 21
    //   332: iload 8
    //   334: i2l
    //   335: lstore 23
    //   337: invokestatic 45	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   340: ifeq +135 -> 475
    //   343: ldc 47
    //   345: iconst_2
    //   346: bipush 17
    //   348: anewarray 4	java/lang/Object
    //   351: dup
    //   352: iconst_0
    //   353: ldc 244
    //   355: aastore
    //   356: dup
    //   357: iconst_1
    //   358: ldc 246
    //   360: aastore
    //   361: dup
    //   362: iconst_2
    //   363: aload 28
    //   365: aastore
    //   366: dup
    //   367: iconst_3
    //   368: ldc 248
    //   370: aastore
    //   371: dup
    //   372: iconst_4
    //   373: lload 9
    //   375: invokestatic 253	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   378: aastore
    //   379: dup
    //   380: iconst_5
    //   381: ldc 255
    //   383: aastore
    //   384: dup
    //   385: bipush 6
    //   387: iload_3
    //   388: invokestatic 260	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   391: aastore
    //   392: dup
    //   393: bipush 7
    //   395: ldc_w 262
    //   398: aastore
    //   399: dup
    //   400: bipush 8
    //   402: iload 4
    //   404: invokestatic 260	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   407: aastore
    //   408: dup
    //   409: bipush 9
    //   411: ldc_w 264
    //   414: aastore
    //   415: dup
    //   416: bipush 10
    //   418: iload 5
    //   420: invokestatic 260	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   423: aastore
    //   424: dup
    //   425: bipush 11
    //   427: ldc_w 266
    //   430: aastore
    //   431: dup
    //   432: bipush 12
    //   434: iload 6
    //   436: invokestatic 260	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   439: aastore
    //   440: dup
    //   441: bipush 13
    //   443: ldc_w 268
    //   446: aastore
    //   447: dup
    //   448: bipush 14
    //   450: iload 7
    //   452: invokestatic 260	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   455: aastore
    //   456: dup
    //   457: bipush 15
    //   459: ldc_w 270
    //   462: aastore
    //   463: dup
    //   464: bipush 16
    //   466: iload 8
    //   468: invokestatic 260	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   471: aastore
    //   472: invokestatic 65	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   475: aload 26
    //   477: aload 28
    //   479: new 135	abvp
    //   482: dup
    //   483: lload 11
    //   485: lload 9
    //   487: bipush 6
    //   489: newarray long
    //   491: dup
    //   492: iconst_0
    //   493: lload 13
    //   495: lastore
    //   496: dup
    //   497: iconst_1
    //   498: lload 15
    //   500: lastore
    //   501: dup
    //   502: iconst_2
    //   503: lload 17
    //   505: lastore
    //   506: dup
    //   507: iconst_3
    //   508: lload 19
    //   510: lastore
    //   511: dup
    //   512: iconst_4
    //   513: lload 21
    //   515: lastore
    //   516: dup
    //   517: iconst_5
    //   518: lload 23
    //   520: lastore
    //   521: invokespecial 273	abvp:<init>	(JJ[J)V
    //   524: invokevirtual 276	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   527: pop
    //   528: new 100	org/json/JSONObject
    //   531: dup
    //   532: invokespecial 128	org/json/JSONObject:<init>	()V
    //   535: astore 28
    //   537: new 100	org/json/JSONObject
    //   540: dup
    //   541: invokespecial 128	org/json/JSONObject:<init>	()V
    //   544: astore 29
    //   546: aload 29
    //   548: ldc_w 278
    //   551: iconst_1
    //   552: invokestatic 161	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   555: invokevirtual 154	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   558: pop
    //   559: aload 29
    //   561: ldc_w 280
    //   564: iload_2
    //   565: invokestatic 161	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   568: invokevirtual 154	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   571: pop
    //   572: aload 28
    //   574: ldc_w 282
    //   577: aload_0
    //   578: aload 26
    //   580: invokespecial 284	abvs:a	(Ljava/util/HashMap;)Lorg/json/JSONObject;
    //   583: invokevirtual 154	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   586: pop
    //   587: aload 28
    //   589: ldc_w 286
    //   592: aload 29
    //   594: invokevirtual 154	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   597: pop
    //   598: aload 28
    //   600: ldc_w 288
    //   603: bipush 101
    //   605: invokevirtual 291	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   608: pop
    //   609: aload 27
    //   611: new 81	com/tencent/mfsdk/collector/ResultObject
    //   614: dup
    //   615: iconst_0
    //   616: ldc_w 293
    //   619: iconst_1
    //   620: lconst_1
    //   621: lconst_1
    //   622: aload 28
    //   624: iconst_0
    //   625: iconst_1
    //   626: getstatic 296	com/tencent/mfsdk/MagnifierSDK:jdField_a_of_type_Long	J
    //   629: invokespecial 299	com/tencent/mfsdk/collector/ResultObject:<init>	(ILjava/lang/String;ZJJLorg/json/JSONObject;ZZJ)V
    //   632: invokeinterface 305 2 0
    //   637: pop
    //   638: aload 26
    //   640: invokevirtual 308	java/util/HashMap:clear	()V
    //   643: aload 25
    //   645: invokeinterface 311 1 0
    //   650: pop
    //   651: goto -539 -> 112
    //   654: astore 26
    //   656: ldc 47
    //   658: iconst_1
    //   659: ldc_w 313
    //   662: aload 26
    //   664: invokestatic 73	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   667: aload 27
    //   669: invokeinterface 314 1 0
    //   674: aload_0
    //   675: ldc 203
    //   677: aconst_null
    //   678: aconst_null
    //   679: invokespecial 316	abvs:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   682: pop
    //   683: aload 25
    //   685: ifnull +10 -> 695
    //   688: aload 25
    //   690: invokeinterface 212 1 0
    //   695: aload 27
    //   697: areturn
    //   698: aload_0
    //   699: ldc 203
    //   701: aconst_null
    //   702: aconst_null
    //   703: invokespecial 316	abvs:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   706: pop
    //   707: aload 25
    //   709: ifnull -14 -> 695
    //   712: aload 25
    //   714: invokeinterface 212 1 0
    //   719: goto -24 -> 695
    //   722: astore 26
    //   724: aconst_null
    //   725: astore 25
    //   727: aload 25
    //   729: ifnull +10 -> 739
    //   732: aload 25
    //   734: invokeinterface 212 1 0
    //   739: aload 26
    //   741: athrow
    //   742: astore 26
    //   744: goto -17 -> 727
    //   747: astore 26
    //   749: goto -22 -> 727
    //   752: astore 26
    //   754: aconst_null
    //   755: astore 25
    //   757: goto -101 -> 656
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	760	0	this	abvs
    //   0	760	1	paramBoolean	boolean
    //   158	407	2	i	int
    //   156	232	3	j	int
    //   234	169	4	k	int
    //   252	167	5	m	int
    //   270	165	6	n	int
    //   288	163	7	i1	int
    //   306	161	8	i2	int
    //   181	305	9	l1	long
    //   199	285	11	l2	long
    //   310	184	13	l3	long
    //   315	184	15	l4	long
    //   320	184	17	l5	long
    //   325	184	19	l6	long
    //   330	184	21	l7	long
    //   335	184	23	l8	long
    //   63	693	25	localCursor	Cursor
    //   40	599	26	localHashMap	HashMap
    //   654	9	26	localThrowable1	Throwable
    //   722	18	26	localObject1	Object
    //   742	1	26	localObject2	Object
    //   747	1	26	localObject3	Object
    //   752	1	26	localThrowable2	Throwable
    //   31	665	27	localArrayList	java.util.ArrayList
    //   138	485	28	localObject4	Object
    //   544	49	29	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   104	112	654	java/lang/Throwable
    //   112	157	654	java/lang/Throwable
    //   165	308	654	java/lang/Throwable
    //   337	475	654	java/lang/Throwable
    //   475	651	654	java/lang/Throwable
    //   698	707	654	java/lang/Throwable
    //   47	65	722	finally
    //   84	101	722	finally
    //   104	112	742	finally
    //   112	157	742	finally
    //   165	308	742	finally
    //   337	475	742	finally
    //   475	651	742	finally
    //   698	707	742	finally
    //   656	683	747	finally
    //   47	65	752	java/lang/Throwable
    //   84	101	752	java/lang/Throwable
  }
  
  public int a()
  {
    return a("result_objects", null, null);
  }
  
  public int a(String paramString, long paramLong, int paramInt)
  {
    int j = -1;
    int i;
    if ((this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase == null) || (!this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.isOpen())) {
      i = -2;
    }
    do
    {
      do
      {
        return i;
        if (paramInt == 1) {
          break;
        }
        i = j;
      } while (paramInt != 2);
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("status", Integer.valueOf(paramInt));
      try
      {
        paramInt = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.update(paramString, localContentValues, "_id=" + paramLong, null);
        return paramInt;
      }
      catch (Exception paramString)
      {
        i = j;
      }
    } while (!QLog.isColorLevel());
    QLog.e("Magnifier_DBHandler", 2, paramString, new Object[0]);
    return -1;
  }
  
  public int a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      return a(paramString, "status=? OR occur_time<?", new String[] { String.valueOf(2), String.valueOf(System.currentTimeMillis() - 86400000L) });
    }
    return a(paramString, "status=?", new String[] { String.valueOf(2) });
  }
  
  public long a(long paramLong, String paramString, abvp paramabvp)
  {
    if ((this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase == null) || (!this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.isOpen())) {
      return -2L;
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("uin", Long.valueOf(paramLong));
    localContentValues.put("scene", paramString);
    localContentValues.put("state", Integer.valueOf(paramabvp.jdField_a_of_type_Int));
    localContentValues.put("drop_duration", Long.valueOf(paramabvp.b));
    localContentValues.put("drop_count", Long.valueOf(paramabvp.jdField_a_of_type_Long));
    localContentValues.put("range_0", Long.valueOf(paramabvp.jdField_a_of_type_ArrayOfLong[0]));
    localContentValues.put("range_1", Long.valueOf(paramabvp.jdField_a_of_type_ArrayOfLong[1]));
    localContentValues.put("range_2_4", Long.valueOf(paramabvp.jdField_a_of_type_ArrayOfLong[2]));
    localContentValues.put("range_4_8", Long.valueOf(paramabvp.jdField_a_of_type_ArrayOfLong[3]));
    localContentValues.put("range_8_15", Long.valueOf(paramabvp.jdField_a_of_type_ArrayOfLong[4]));
    localContentValues.put("range_over_15", Long.valueOf(paramabvp.jdField_a_of_type_ArrayOfLong[5]));
    localContentValues.put("status", Integer.valueOf(1));
    if (QLog.isColorLevel()) {
      QLog.d("Magnifier_DBHandler", 2, new Object[] { "insertDropFrame", ",scene = ", paramString, ",duration=", Long.valueOf(paramabvp.b), ",range_0=", Long.valueOf(paramabvp.jdField_a_of_type_ArrayOfLong[0]), ",range_1_2=", Long.valueOf(paramabvp.jdField_a_of_type_ArrayOfLong[1]), ",range_2_4=", Long.valueOf(paramabvp.jdField_a_of_type_ArrayOfLong[2]), ",range_4_8=", Long.valueOf(paramabvp.jdField_a_of_type_ArrayOfLong[3]), ",range_8_15=", Long.valueOf(paramabvp.jdField_a_of_type_ArrayOfLong[4]), ",range_bigegr=", Long.valueOf(paramabvp.jdField_a_of_type_ArrayOfLong[5]) });
    }
    try
    {
      paramLong = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.insert("drop_frame", "name", localContentValues);
      return paramLong;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Magnifier_DBHandler", 2, paramString, new Object[0]);
      }
    }
    return -1L;
  }
  
  public long a(SparseArray<abva> paramSparseArray)
  {
    if ((this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase == null) || (!this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.isOpen())) {
      return -2L;
    }
    a("configs", null, null);
    this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.beginTransaction();
    int j = paramSparseArray.size();
    ContentValues localContentValues = new ContentValues();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        int k = paramSparseArray.keyAt(i);
        abva localabva = (abva)paramSparseArray.get(k);
        localContentValues.put("plugin", Integer.valueOf(k));
        localContentValues.put("user_sample_ratio", Float.valueOf(localabva.jdField_a_of_type_Float));
        localContentValues.put("threshold", Integer.valueOf(localabva.jdField_a_of_type_Int));
        localContentValues.put("max_report_num", Integer.valueOf(localabva.jdField_b_of_type_Int));
        localContentValues.put("event_sample_ratio", Float.valueOf(localabva.jdField_b_of_type_Float));
        localContentValues.put("stack_depth", Integer.valueOf(localabva.c));
        try
        {
          this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.insert("configs", "name", localContentValues);
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("Magnifier_DBHandler", 2, localException, new Object[0]);
            }
          }
        }
      }
    }
    this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.setTransactionSuccessful();
    this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.endTransaction();
    return 0L;
  }
  
  public long a(ResultObject paramResultObject)
  {
    if ((this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase == null) || (!this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.isOpen())) {
      return -2L;
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("params", paramResultObject.params.toString());
    localContentValues.put("is_real_time", Boolean.valueOf(paramResultObject.isRealTime));
    localContentValues.put("uin", Long.valueOf(paramResultObject.uin));
    localContentValues.put("status", Integer.valueOf(1));
    try
    {
      l1 = paramResultObject.params.getJSONObject("clientinfo").optLong("event_time");
      long l2 = l1;
      if (l1 == 0L) {
        l2 = jdField_a_of_type_Long;
      }
      localContentValues.put("occur_time", Long.valueOf(l2));
    }
    catch (Exception paramResultObject)
    {
      for (;;)
      {
        try
        {
          l1 = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.insert("result_objects", "name", localContentValues);
          return l1;
        }
        catch (Exception paramResultObject)
        {
          long l1;
          if (!QLog.isColorLevel()) {
            break label170;
          }
          QLog.e("Magnifier_DBHandler", 2, paramResultObject, new Object[0]);
        }
        paramResultObject = paramResultObject;
        l1 = 0L;
      }
    }
    label170:
    return -1L;
  }
  
  /* Error */
  public SparseArray<abva> a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: getfield 39	abvs:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   6: ifnull +13 -> 19
    //   9: aload_0
    //   10: getfield 39	abvs:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   13: invokevirtual 59	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   16: ifne +9 -> 25
    //   19: aconst_null
    //   20: astore 4
    //   22: aload 4
    //   24: areturn
    //   25: aload_0
    //   26: getfield 39	abvs:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   29: ldc_w 382
    //   32: aconst_null
    //   33: aconst_null
    //   34: aconst_null
    //   35: aconst_null
    //   36: aconst_null
    //   37: aconst_null
    //   38: invokevirtual 209	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   41: astore_2
    //   42: aload_2
    //   43: ifnonnull +15 -> 58
    //   46: aload_2
    //   47: ifnull +9 -> 56
    //   50: aload_2
    //   51: invokeinterface 212 1 0
    //   56: aconst_null
    //   57: areturn
    //   58: aload_2
    //   59: invokeinterface 460 1 0
    //   64: istore_1
    //   65: iload_1
    //   66: iconst_1
    //   67: if_icmpge +15 -> 82
    //   70: aload_2
    //   71: ifnull +9 -> 80
    //   74: aload_2
    //   75: invokeinterface 212 1 0
    //   80: aconst_null
    //   81: areturn
    //   82: new 387	android/util/SparseArray
    //   85: dup
    //   86: iload_1
    //   87: invokespecial 462	android/util/SparseArray:<init>	(I)V
    //   90: astore 5
    //   92: aload_2
    //   93: invokeinterface 215 1 0
    //   98: pop
    //   99: aload_2
    //   100: invokeinterface 218 1 0
    //   105: ifne +155 -> 260
    //   108: aload 5
    //   110: aload_2
    //   111: aload_2
    //   112: ldc_w 278
    //   115: invokeinterface 90 2 0
    //   120: invokeinterface 94 2 0
    //   125: new 398	abva
    //   128: dup
    //   129: aload_2
    //   130: aload_2
    //   131: ldc_w 400
    //   134: invokeinterface 90 2 0
    //   139: invokeinterface 466 2 0
    //   144: aload_2
    //   145: aload_2
    //   146: ldc_w 413
    //   149: invokeinterface 90 2 0
    //   154: invokeinterface 94 2 0
    //   159: aload_2
    //   160: aload_2
    //   161: ldc_w 416
    //   164: invokeinterface 90 2 0
    //   169: invokeinterface 94 2 0
    //   174: aload_2
    //   175: aload_2
    //   176: ldc_w 420
    //   179: invokeinterface 90 2 0
    //   184: invokeinterface 466 2 0
    //   189: aload_2
    //   190: aload_2
    //   191: ldc_w 424
    //   194: invokeinterface 90 2 0
    //   199: invokeinterface 94 2 0
    //   204: invokespecial 469	abva:<init>	(FIIFI)V
    //   207: invokevirtual 472	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   210: aload_2
    //   211: invokeinterface 311 1 0
    //   216: pop
    //   217: goto -118 -> 99
    //   220: astore 4
    //   222: aload_2
    //   223: astore_3
    //   224: aload 5
    //   226: astore_2
    //   227: invokestatic 45	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   230: ifeq +15 -> 245
    //   233: ldc 47
    //   235: iconst_2
    //   236: aload 4
    //   238: iconst_0
    //   239: anewarray 4	java/lang/Object
    //   242: invokestatic 51	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   245: aload_2
    //   246: astore 4
    //   248: aload_3
    //   249: ifnull -227 -> 22
    //   252: aload_3
    //   253: invokeinterface 212 1 0
    //   258: aload_2
    //   259: areturn
    //   260: aload_2
    //   261: ifnull +61 -> 322
    //   264: aload_2
    //   265: invokeinterface 212 1 0
    //   270: aload 5
    //   272: areturn
    //   273: astore_3
    //   274: aconst_null
    //   275: astore_2
    //   276: aload_2
    //   277: ifnull +9 -> 286
    //   280: aload_2
    //   281: invokeinterface 212 1 0
    //   286: aload_3
    //   287: athrow
    //   288: astore_3
    //   289: goto -13 -> 276
    //   292: astore 4
    //   294: aload_3
    //   295: astore_2
    //   296: aload 4
    //   298: astore_3
    //   299: goto -23 -> 276
    //   302: astore 4
    //   304: aconst_null
    //   305: astore_2
    //   306: goto -79 -> 227
    //   309: astore 4
    //   311: aconst_null
    //   312: astore 5
    //   314: aload_2
    //   315: astore_3
    //   316: aload 5
    //   318: astore_2
    //   319: goto -92 -> 227
    //   322: aload 5
    //   324: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	325	0	this	abvs
    //   64	23	1	i	int
    //   41	278	2	localObject1	Object
    //   1	252	3	localObject2	Object
    //   273	14	3	localObject3	Object
    //   288	7	3	localObject4	Object
    //   298	18	3	localObject5	Object
    //   20	3	4	localSparseArray	SparseArray<abva>
    //   220	17	4	localException1	Exception
    //   246	1	4	localObject6	Object
    //   292	5	4	localObject7	Object
    //   302	1	4	localException2	Exception
    //   309	1	4	localException3	Exception
    //   90	233	5	localSparseArray1	SparseArray
    // Exception table:
    //   from	to	target	type
    //   92	99	220	java/lang/Exception
    //   99	217	220	java/lang/Exception
    //   25	42	273	finally
    //   58	65	288	finally
    //   82	92	288	finally
    //   92	99	288	finally
    //   99	217	288	finally
    //   227	245	292	finally
    //   25	42	302	java/lang/Exception
    //   58	65	309	java/lang/Exception
    //   82	92	309	java/lang/Exception
  }
  
  /* Error */
  public java.util.List<ResultObject> a(boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: invokestatic 17	java/lang/System:currentTimeMillis	()J
    //   6: lstore_2
    //   7: new 199	java/util/ArrayList
    //   10: dup
    //   11: invokespecial 200	java/util/ArrayList:<init>	()V
    //   14: astore 7
    //   16: aload_0
    //   17: getfield 39	abvs:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   20: ifnull +13 -> 33
    //   23: aload_0
    //   24: getfield 39	abvs:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   27: invokevirtual 59	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   30: ifne +6 -> 36
    //   33: aload 7
    //   35: areturn
    //   36: iconst_1
    //   37: iload_1
    //   38: if_icmpne +64 -> 102
    //   41: aload_0
    //   42: getfield 39	abvs:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   45: ldc_w 320
    //   48: aconst_null
    //   49: ldc_w 475
    //   52: iconst_2
    //   53: anewarray 158	java/lang/String
    //   56: dup
    //   57: iconst_0
    //   58: iconst_1
    //   59: invokestatic 161	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   62: aastore
    //   63: dup
    //   64: iconst_1
    //   65: lload_2
    //   66: ldc2_w 353
    //   69: lsub
    //   70: invokestatic 357	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   73: aastore
    //   74: aconst_null
    //   75: aconst_null
    //   76: aconst_null
    //   77: invokevirtual 209	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   80: astore 4
    //   82: aload 4
    //   84: ifnonnull +39 -> 123
    //   87: aload 4
    //   89: ifnull +10 -> 99
    //   92: aload 4
    //   94: invokeinterface 212 1 0
    //   99: aload 7
    //   101: areturn
    //   102: aload_0
    //   103: getfield 39	abvs:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   106: ldc_w 320
    //   109: aconst_null
    //   110: aconst_null
    //   111: aconst_null
    //   112: aconst_null
    //   113: aconst_null
    //   114: aconst_null
    //   115: invokevirtual 209	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   118: astore 4
    //   120: goto -38 -> 82
    //   123: aload 4
    //   125: astore 5
    //   127: aload 4
    //   129: invokeinterface 215 1 0
    //   134: pop
    //   135: aload 4
    //   137: astore 5
    //   139: aload 4
    //   141: invokeinterface 218 1 0
    //   146: ifne +124 -> 270
    //   149: aload 4
    //   151: astore 5
    //   153: aload_0
    //   154: aload 4
    //   156: invokespecial 477	abvs:a	(Landroid/database/Cursor;)Lcom/tencent/mfsdk/collector/ResultObject;
    //   159: astore 6
    //   161: aload 6
    //   163: ifnull +17 -> 180
    //   166: aload 4
    //   168: astore 5
    //   170: aload 7
    //   172: aload 6
    //   174: invokeinterface 305 2 0
    //   179: pop
    //   180: aload 4
    //   182: astore 5
    //   184: aload 4
    //   186: invokeinterface 311 1 0
    //   191: pop
    //   192: goto -57 -> 135
    //   195: astore 6
    //   197: aload 4
    //   199: astore 5
    //   201: invokestatic 45	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   204: ifeq +19 -> 223
    //   207: aload 4
    //   209: astore 5
    //   211: ldc 47
    //   213: iconst_2
    //   214: aload 6
    //   216: iconst_0
    //   217: anewarray 4	java/lang/Object
    //   220: invokestatic 51	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   223: aload 4
    //   225: ifnull +10 -> 235
    //   228: aload 4
    //   230: invokeinterface 212 1 0
    //   235: aload_0
    //   236: iload_1
    //   237: invokespecial 479	abvs:b	(Z)Ljava/util/List;
    //   240: astore 4
    //   242: aload 4
    //   244: ifnull +23 -> 267
    //   247: aload 4
    //   249: invokeinterface 482 1 0
    //   254: ifne +13 -> 267
    //   257: aload 7
    //   259: aload 4
    //   261: invokeinterface 486 2 0
    //   266: pop
    //   267: aload 7
    //   269: areturn
    //   270: aload 4
    //   272: ifnull -37 -> 235
    //   275: aload 4
    //   277: invokeinterface 212 1 0
    //   282: goto -47 -> 235
    //   285: astore 4
    //   287: aload 5
    //   289: ifnull +10 -> 299
    //   292: aload 5
    //   294: invokeinterface 212 1 0
    //   299: aload 4
    //   301: athrow
    //   302: astore 4
    //   304: goto -17 -> 287
    //   307: astore 6
    //   309: aconst_null
    //   310: astore 4
    //   312: goto -115 -> 197
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	315	0	this	abvs
    //   0	315	1	paramBoolean	boolean
    //   6	60	2	l	long
    //   80	196	4	localObject1	Object
    //   285	15	4	localObject2	Object
    //   302	1	4	localObject3	Object
    //   310	1	4	localObject4	Object
    //   1	292	5	localObject5	Object
    //   159	14	6	localResultObject	ResultObject
    //   195	20	6	localException1	Exception
    //   307	1	6	localException2	Exception
    //   14	254	7	localArrayList	java.util.ArrayList
    // Exception table:
    //   from	to	target	type
    //   127	135	195	java/lang/Exception
    //   139	149	195	java/lang/Exception
    //   153	161	195	java/lang/Exception
    //   170	180	195	java/lang/Exception
    //   184	192	195	java/lang/Exception
    //   41	82	285	finally
    //   102	120	285	finally
    //   127	135	302	finally
    //   139	149	302	finally
    //   153	161	302	finally
    //   170	180	302	finally
    //   184	192	302	finally
    //   201	207	302	finally
    //   211	223	302	finally
    //   41	82	307	java/lang/Exception
    //   102	120	307	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abvs
 * JD-Core Version:    0.7.0.1
 */