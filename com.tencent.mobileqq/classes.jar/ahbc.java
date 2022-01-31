import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;

public final class ahbc
  extends SQLiteOpenHelper
{
  public ahbc(Context paramContext)
  {
    super(paramContext, "QWalletNotifyMsg.db", null, 1);
  }
  
  private void a(SQLiteDatabase paramSQLiteDatabase)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" CREATE TABLE IF NOT EXISTS ").append("record");
    localStringBuilder.append(" (");
    localStringBuilder.append("no").append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
    localStringBuilder.append("uin").append(" INTEGER(64) DEFAULT 0, ");
    localStringBuilder.append("btype").append(" INTEGER(16) DEFAULT 0, ");
    localStringBuilder.append("bid").append(" VARCHAR(64) , ");
    localStringBuilder.append("create_time").append(" INTEGER(64) DEFAULT 0, ");
    localStringBuilder.append("ext").append(" VARCHAR(128) ");
    localStringBuilder.append(")");
    paramSQLiteDatabase.execSQL(localStringBuilder.toString());
  }
  
  public void a(long paramLong, int[] paramArrayOfInt)
  {
    int i = 0;
    if (paramLong <= 0L) {}
    for (;;)
    {
      return;
      long l = NetConnInfoCenter.getServerTime();
      Object localObject2 = null;
      Object localObject1 = null;
      try
      {
        SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
        if (paramArrayOfInt != null)
        {
          localObject1 = localSQLiteDatabase;
          localObject2 = localSQLiteDatabase;
          if (paramArrayOfInt.length > 0)
          {
            localObject1 = localSQLiteDatabase;
            localObject2 = localSQLiteDatabase;
            StringBuilder localStringBuilder = new StringBuilder();
            localObject1 = localSQLiteDatabase;
            localObject2 = localSQLiteDatabase;
            if (i < paramArrayOfInt.length)
            {
              localObject1 = localSQLiteDatabase;
              localObject2 = localSQLiteDatabase;
              localStringBuilder.append(paramArrayOfInt[i]);
              localObject1 = localSQLiteDatabase;
              localObject2 = localSQLiteDatabase;
              if (i + 1 >= paramArrayOfInt.length) {
                break label333;
              }
              localObject1 = localSQLiteDatabase;
              localObject2 = localSQLiteDatabase;
              localStringBuilder.append(',');
              break label333;
            }
            localObject1 = localSQLiteDatabase;
            localObject2 = localSQLiteDatabase;
            localSQLiteDatabase.delete("record", " btype in (" + localStringBuilder.toString() + ") AND" + "create_time" + "< ? ", new String[] { String.valueOf(l - paramLong) });
          }
        }
        while (localSQLiteDatabase != null)
        {
          try
          {
            localSQLiteDatabase.close();
            return;
          }
          catch (Exception paramArrayOfInt)
          {
            paramArrayOfInt.printStackTrace();
            return;
          }
          localObject1 = localSQLiteDatabase;
          localObject2 = localSQLiteDatabase;
          localSQLiteDatabase.delete("record", " create_time< ? ", new String[] { String.valueOf(l - paramLong) });
        }
      }
      catch (Exception paramArrayOfInt)
      {
        localObject2 = localObject1;
        if (QLog.isColorLevel())
        {
          localObject2 = localObject1;
          QLog.i("NotifyMsgDBHelper", 2, "clearOverTimeRecords err:" + paramArrayOfInt.getMessage());
        }
        if (localObject1 == null) {
          continue;
        }
        try
        {
          localObject1.close();
          return;
        }
        catch (Exception paramArrayOfInt)
        {
          paramArrayOfInt.printStackTrace();
          return;
        }
      }
      finally
      {
        for (;;)
        {
          if (localObject2 != null) {}
          try
          {
            localObject2.close();
            throw paramArrayOfInt;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              localException.printStackTrace();
            }
          }
          label333:
          i += 1;
        }
      }
    }
  }
  
  /* Error */
  public void a(String paramString, java.util.List<ahbd> paramList)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 8
    //   6: aconst_null
    //   7: astore_3
    //   8: aconst_null
    //   9: astore 5
    //   11: aconst_null
    //   12: astore 7
    //   14: aload_1
    //   15: ifnull +7 -> 22
    //   18: aload_2
    //   19: ifnonnull +4 -> 23
    //   22: return
    //   23: aload_2
    //   24: invokeinterface 129 1 0
    //   29: aload_0
    //   30: invokevirtual 132	ahbc:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   33: astore 4
    //   35: aload 8
    //   37: astore_3
    //   38: aload 4
    //   40: ifnull +264 -> 304
    //   43: aload 7
    //   45: astore 6
    //   47: aload 5
    //   49: astore_3
    //   50: aload 4
    //   52: astore 5
    //   54: aload 4
    //   56: new 16	java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   63: ldc 134
    //   65: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: aload_1
    //   69: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: aconst_null
    //   76: invokevirtual 138	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   79: astore_1
    //   80: aload_1
    //   81: ifnull +200 -> 281
    //   84: aload_1
    //   85: astore 6
    //   87: aload_1
    //   88: astore_3
    //   89: aload 4
    //   91: astore 5
    //   93: aload_1
    //   94: invokeinterface 144 1 0
    //   99: ifle +182 -> 281
    //   102: aload_1
    //   103: astore 6
    //   105: aload_1
    //   106: astore_3
    //   107: aload 4
    //   109: astore 5
    //   111: aload_1
    //   112: invokeinterface 147 1 0
    //   117: pop
    //   118: aload_1
    //   119: astore 6
    //   121: aload_1
    //   122: astore_3
    //   123: aload 4
    //   125: astore 5
    //   127: aload_1
    //   128: invokeinterface 150 1 0
    //   133: ifne +148 -> 281
    //   136: aload_1
    //   137: astore 6
    //   139: aload_1
    //   140: astore_3
    //   141: aload 4
    //   143: astore 5
    //   145: aload_1
    //   146: invokestatic 155	ahbd:a	(Landroid/database/Cursor;)Lahbd;
    //   149: astore 7
    //   151: aload 7
    //   153: ifnull +21 -> 174
    //   156: aload_1
    //   157: astore 6
    //   159: aload_1
    //   160: astore_3
    //   161: aload 4
    //   163: astore 5
    //   165: aload_2
    //   166: aload 7
    //   168: invokeinterface 159 2 0
    //   173: pop
    //   174: aload_1
    //   175: astore 6
    //   177: aload_1
    //   178: astore_3
    //   179: aload 4
    //   181: astore 5
    //   183: aload_1
    //   184: invokeinterface 162 1 0
    //   189: pop
    //   190: goto -72 -> 118
    //   193: astore_1
    //   194: aload 6
    //   196: astore_3
    //   197: aload 4
    //   199: astore 5
    //   201: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   204: ifeq +38 -> 242
    //   207: aload 6
    //   209: astore_3
    //   210: aload 4
    //   212: astore 5
    //   214: ldc 114
    //   216: iconst_2
    //   217: new 16	java/lang/StringBuilder
    //   220: dup
    //   221: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   224: ldc 164
    //   226: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: aload_1
    //   230: invokevirtual 119	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   233: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   239: invokestatic 123	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   242: aload 6
    //   244: ifnull +20 -> 264
    //   247: aload 6
    //   249: invokeinterface 167 1 0
    //   254: ifne +10 -> 264
    //   257: aload 6
    //   259: invokeinterface 168 1 0
    //   264: aload 4
    //   266: ifnull -244 -> 22
    //   269: aload 4
    //   271: invokevirtual 101	android/database/sqlite/SQLiteDatabase:close	()V
    //   274: return
    //   275: astore_1
    //   276: aload_1
    //   277: invokevirtual 104	java/lang/Exception:printStackTrace	()V
    //   280: return
    //   281: aload_1
    //   282: astore_3
    //   283: aload_1
    //   284: ifnull +20 -> 304
    //   287: aload_1
    //   288: astore 6
    //   290: aload_1
    //   291: astore_3
    //   292: aload 4
    //   294: astore 5
    //   296: aload_1
    //   297: invokeinterface 168 1 0
    //   302: aload_1
    //   303: astore_3
    //   304: aload_3
    //   305: ifnull +18 -> 323
    //   308: aload_3
    //   309: invokeinterface 167 1 0
    //   314: ifne +9 -> 323
    //   317: aload_3
    //   318: invokeinterface 168 1 0
    //   323: aload 4
    //   325: ifnull -303 -> 22
    //   328: aload 4
    //   330: invokevirtual 101	android/database/sqlite/SQLiteDatabase:close	()V
    //   333: return
    //   334: astore_1
    //   335: aload_1
    //   336: invokevirtual 104	java/lang/Exception:printStackTrace	()V
    //   339: return
    //   340: astore_1
    //   341: aload_1
    //   342: invokevirtual 104	java/lang/Exception:printStackTrace	()V
    //   345: goto -22 -> 323
    //   348: astore_1
    //   349: aload_1
    //   350: invokevirtual 104	java/lang/Exception:printStackTrace	()V
    //   353: goto -89 -> 264
    //   356: astore_1
    //   357: aconst_null
    //   358: astore 5
    //   360: aload_3
    //   361: ifnull +18 -> 379
    //   364: aload_3
    //   365: invokeinterface 167 1 0
    //   370: ifne +9 -> 379
    //   373: aload_3
    //   374: invokeinterface 168 1 0
    //   379: aload 5
    //   381: ifnull +8 -> 389
    //   384: aload 5
    //   386: invokevirtual 101	android/database/sqlite/SQLiteDatabase:close	()V
    //   389: aload_1
    //   390: athrow
    //   391: astore_2
    //   392: aload_2
    //   393: invokevirtual 104	java/lang/Exception:printStackTrace	()V
    //   396: goto -17 -> 379
    //   399: astore_2
    //   400: aload_2
    //   401: invokevirtual 104	java/lang/Exception:printStackTrace	()V
    //   404: goto -15 -> 389
    //   407: astore_1
    //   408: goto -48 -> 360
    //   411: astore_1
    //   412: aconst_null
    //   413: astore 4
    //   415: goto -221 -> 194
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	418	0	this	ahbc
    //   0	418	1	paramString	String
    //   0	418	2	paramList	java.util.List<ahbd>
    //   7	367	3	localObject1	Object
    //   33	381	4	localSQLiteDatabase	SQLiteDatabase
    //   9	376	5	localObject2	Object
    //   1	288	6	localObject3	Object
    //   12	155	7	localahbd	ahbd
    //   4	32	8	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   54	80	193	java/lang/Exception
    //   93	102	193	java/lang/Exception
    //   111	118	193	java/lang/Exception
    //   127	136	193	java/lang/Exception
    //   145	151	193	java/lang/Exception
    //   165	174	193	java/lang/Exception
    //   183	190	193	java/lang/Exception
    //   296	302	193	java/lang/Exception
    //   269	274	275	java/lang/Exception
    //   328	333	334	java/lang/Exception
    //   308	323	340	java/lang/Exception
    //   247	264	348	java/lang/Exception
    //   29	35	356	finally
    //   364	379	391	java/lang/Exception
    //   384	389	399	java/lang/Exception
    //   54	80	407	finally
    //   93	102	407	finally
    //   111	118	407	finally
    //   127	136	407	finally
    //   145	151	407	finally
    //   165	174	407	finally
    //   183	190	407	finally
    //   201	207	407	finally
    //   214	242	407	finally
    //   296	302	407	finally
    //   29	35	411	java/lang/Exception
  }
  
  /* Error */
  public void b(String paramString, java.util.List<ahbd> paramList)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_1
    //   3: ifnull +16 -> 19
    //   6: aload_2
    //   7: ifnull +12 -> 19
    //   10: aload_2
    //   11: invokeinterface 174 1 0
    //   16: ifgt +4 -> 20
    //   19: return
    //   20: aload_0
    //   21: invokevirtual 76	ahbc:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   24: astore_1
    //   25: aload_2
    //   26: invokeinterface 178 1 0
    //   31: astore_3
    //   32: aload_3
    //   33: invokeinterface 183 1 0
    //   38: ifeq +279 -> 317
    //   41: aload_3
    //   42: invokeinterface 187 1 0
    //   47: checkcast 152	ahbd
    //   50: astore 4
    //   52: aload 4
    //   54: ifnull -22 -> 32
    //   57: new 189	android/content/ContentValues
    //   60: dup
    //   61: invokespecial 190	android/content/ContentValues:<init>	()V
    //   64: astore 5
    //   66: aload 5
    //   68: ldc 35
    //   70: aload 4
    //   72: getfield 193	ahbd:jdField_a_of_type_Long	J
    //   75: invokestatic 198	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   78: invokevirtual 202	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   81: aload 5
    //   83: ldc 39
    //   85: aload 4
    //   87: getfield 205	ahbd:b	I
    //   90: invokestatic 210	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   93: invokevirtual 213	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   96: aload 4
    //   98: getfield 216	ahbd:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   101: ifnonnull +195 -> 296
    //   104: ldc 218
    //   106: astore_2
    //   107: aload 5
    //   109: ldc 43
    //   111: aload_2
    //   112: invokevirtual 221	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   115: aload 5
    //   117: ldc 47
    //   119: invokestatic 72	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTime	()J
    //   122: invokestatic 198	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   125: invokevirtual 202	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   128: aload 4
    //   130: getfield 224	ahbd:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   133: ifnonnull +172 -> 305
    //   136: ldc 218
    //   138: astore_2
    //   139: aload 5
    //   141: ldc 49
    //   143: aload_2
    //   144: invokevirtual 221	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   147: aload_1
    //   148: ldc 27
    //   150: aconst_null
    //   151: aload 5
    //   153: invokevirtual 228	android/database/sqlite/SQLiteDatabase:insertOrThrow	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   156: pop2
    //   157: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   160: ifeq -128 -> 32
    //   163: ldc 114
    //   165: iconst_2
    //   166: new 16	java/lang/StringBuilder
    //   169: dup
    //   170: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   173: ldc 230
    //   175: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: aload 4
    //   180: getfield 216	ahbd:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   183: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   189: invokestatic 123	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   192: goto -160 -> 32
    //   195: astore_2
    //   196: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   199: ifeq -167 -> 32
    //   202: ldc 114
    //   204: iconst_2
    //   205: new 16	java/lang/StringBuilder
    //   208: dup
    //   209: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   212: ldc 232
    //   214: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: aload 4
    //   219: getfield 216	ahbd:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   222: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: ldc 234
    //   227: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: aload_2
    //   231: invokevirtual 119	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   234: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: invokestatic 123	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   243: goto -211 -> 32
    //   246: astore_2
    //   247: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   250: ifeq +31 -> 281
    //   253: ldc 114
    //   255: iconst_2
    //   256: new 16	java/lang/StringBuilder
    //   259: dup
    //   260: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   263: ldc 236
    //   265: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: aload_2
    //   269: invokevirtual 119	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   272: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   278: invokestatic 123	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   281: aload_1
    //   282: ifnull -263 -> 19
    //   285: aload_1
    //   286: invokevirtual 101	android/database/sqlite/SQLiteDatabase:close	()V
    //   289: return
    //   290: astore_1
    //   291: aload_1
    //   292: invokevirtual 104	java/lang/Exception:printStackTrace	()V
    //   295: return
    //   296: aload 4
    //   298: getfield 216	ahbd:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   301: astore_2
    //   302: goto -195 -> 107
    //   305: aload 4
    //   307: getfield 224	ahbd:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   310: invokevirtual 239	org/json/JSONObject:toString	()Ljava/lang/String;
    //   313: astore_2
    //   314: goto -175 -> 139
    //   317: aload_1
    //   318: ifnull -299 -> 19
    //   321: aload_1
    //   322: invokevirtual 101	android/database/sqlite/SQLiteDatabase:close	()V
    //   325: return
    //   326: astore_1
    //   327: aload_1
    //   328: invokevirtual 104	java/lang/Exception:printStackTrace	()V
    //   331: return
    //   332: astore_2
    //   333: aconst_null
    //   334: astore_1
    //   335: aload_1
    //   336: ifnull +7 -> 343
    //   339: aload_1
    //   340: invokevirtual 101	android/database/sqlite/SQLiteDatabase:close	()V
    //   343: aload_2
    //   344: athrow
    //   345: astore_1
    //   346: aload_1
    //   347: invokevirtual 104	java/lang/Exception:printStackTrace	()V
    //   350: goto -7 -> 343
    //   353: astore_2
    //   354: goto -19 -> 335
    //   357: astore_2
    //   358: goto -23 -> 335
    //   361: astore_2
    //   362: aload_3
    //   363: astore_1
    //   364: goto -117 -> 247
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	367	0	this	ahbc
    //   0	367	1	paramString	String
    //   0	367	2	paramList	java.util.List<ahbd>
    //   1	362	3	localIterator	java.util.Iterator
    //   50	256	4	localahbd	ahbd
    //   64	88	5	localContentValues	android.content.ContentValues
    // Exception table:
    //   from	to	target	type
    //   147	192	195	java/lang/Exception
    //   25	32	246	java/lang/Exception
    //   32	52	246	java/lang/Exception
    //   57	104	246	java/lang/Exception
    //   107	136	246	java/lang/Exception
    //   139	147	246	java/lang/Exception
    //   196	243	246	java/lang/Exception
    //   296	302	246	java/lang/Exception
    //   305	314	246	java/lang/Exception
    //   285	289	290	java/lang/Exception
    //   321	325	326	java/lang/Exception
    //   20	25	332	finally
    //   339	343	345	java/lang/Exception
    //   25	32	353	finally
    //   32	52	353	finally
    //   57	104	353	finally
    //   107	136	353	finally
    //   139	147	353	finally
    //   147	192	353	finally
    //   196	243	353	finally
    //   296	302	353	finally
    //   305	314	353	finally
    //   247	281	357	finally
    //   20	25	361	java/lang/Exception
  }
  
  /* Error */
  public void c(String paramString, java.util.List<ahbd> paramList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +16 -> 17
    //   4: aload_2
    //   5: ifnull +12 -> 17
    //   8: aload_2
    //   9: invokeinterface 174 1 0
    //   14: ifgt +4 -> 18
    //   17: return
    //   18: aconst_null
    //   19: astore_3
    //   20: aload_0
    //   21: invokevirtual 76	ahbc:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   24: astore 4
    //   26: aload 4
    //   28: astore_3
    //   29: aload_2
    //   30: invokeinterface 178 1 0
    //   35: astore 4
    //   37: aload 4
    //   39: invokeinterface 183 1 0
    //   44: ifeq +297 -> 341
    //   47: aload 4
    //   49: invokeinterface 187 1 0
    //   54: checkcast 152	ahbd
    //   57: astore 5
    //   59: aload 5
    //   61: ifnull -24 -> 37
    //   64: new 189	android/content/ContentValues
    //   67: dup
    //   68: invokespecial 190	android/content/ContentValues:<init>	()V
    //   71: astore 6
    //   73: aload 6
    //   75: ldc 35
    //   77: aload 5
    //   79: getfield 193	ahbd:jdField_a_of_type_Long	J
    //   82: invokestatic 198	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   85: invokevirtual 202	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   88: aload 6
    //   90: ldc 39
    //   92: aload 5
    //   94: getfield 205	ahbd:b	I
    //   97: invokestatic 210	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   100: invokevirtual 213	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   103: aload 5
    //   105: getfield 216	ahbd:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   108: ifnonnull +212 -> 320
    //   111: ldc 218
    //   113: astore_2
    //   114: aload 6
    //   116: ldc 43
    //   118: aload_2
    //   119: invokevirtual 221	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   122: aload 5
    //   124: getfield 224	ahbd:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   127: ifnonnull +202 -> 329
    //   130: ldc 218
    //   132: astore_2
    //   133: aload 6
    //   135: ldc 49
    //   137: aload_2
    //   138: invokevirtual 221	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   141: aload_3
    //   142: ldc 27
    //   144: aload 6
    //   146: ldc 242
    //   148: iconst_3
    //   149: anewarray 90	java/lang/String
    //   152: dup
    //   153: iconst_0
    //   154: aload_1
    //   155: aastore
    //   156: dup
    //   157: iconst_1
    //   158: aload 5
    //   160: getfield 205	ahbd:b	I
    //   163: invokestatic 245	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   166: aastore
    //   167: dup
    //   168: iconst_2
    //   169: aload 5
    //   171: getfield 216	ahbd:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   174: aastore
    //   175: invokevirtual 249	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   178: pop
    //   179: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   182: ifeq -145 -> 37
    //   185: ldc 114
    //   187: iconst_2
    //   188: new 16	java/lang/StringBuilder
    //   191: dup
    //   192: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   195: ldc 251
    //   197: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: aload 5
    //   202: getfield 216	ahbd:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   205: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   211: invokestatic 123	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   214: goto -177 -> 37
    //   217: astore_2
    //   218: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   221: ifeq -184 -> 37
    //   224: ldc 114
    //   226: iconst_2
    //   227: new 16	java/lang/StringBuilder
    //   230: dup
    //   231: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   234: ldc 253
    //   236: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: aload 5
    //   241: getfield 216	ahbd:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   244: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: ldc 234
    //   249: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: aload_2
    //   253: invokevirtual 119	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   256: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   262: invokestatic 123	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   265: goto -228 -> 37
    //   268: astore_2
    //   269: aload_3
    //   270: astore_1
    //   271: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   274: ifeq +31 -> 305
    //   277: ldc 114
    //   279: iconst_2
    //   280: new 16	java/lang/StringBuilder
    //   283: dup
    //   284: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   287: ldc 255
    //   289: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: aload_2
    //   293: invokevirtual 119	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   296: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   302: invokestatic 123	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   305: aload_1
    //   306: ifnull -289 -> 17
    //   309: aload_1
    //   310: invokevirtual 101	android/database/sqlite/SQLiteDatabase:close	()V
    //   313: return
    //   314: astore_1
    //   315: aload_1
    //   316: invokevirtual 104	java/lang/Exception:printStackTrace	()V
    //   319: return
    //   320: aload 5
    //   322: getfield 216	ahbd:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   325: astore_2
    //   326: goto -212 -> 114
    //   329: aload 5
    //   331: getfield 224	ahbd:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   334: invokevirtual 239	org/json/JSONObject:toString	()Ljava/lang/String;
    //   337: astore_2
    //   338: goto -205 -> 133
    //   341: aload_3
    //   342: ifnull -325 -> 17
    //   345: aload_3
    //   346: invokevirtual 101	android/database/sqlite/SQLiteDatabase:close	()V
    //   349: return
    //   350: astore_1
    //   351: aload_1
    //   352: invokevirtual 104	java/lang/Exception:printStackTrace	()V
    //   355: return
    //   356: astore_1
    //   357: aconst_null
    //   358: astore_3
    //   359: aload_3
    //   360: ifnull +7 -> 367
    //   363: aload_3
    //   364: invokevirtual 101	android/database/sqlite/SQLiteDatabase:close	()V
    //   367: aload_1
    //   368: athrow
    //   369: astore_2
    //   370: aload_2
    //   371: invokevirtual 104	java/lang/Exception:printStackTrace	()V
    //   374: goto -7 -> 367
    //   377: astore_1
    //   378: goto -19 -> 359
    //   381: astore_2
    //   382: aload_1
    //   383: astore_3
    //   384: aload_2
    //   385: astore_1
    //   386: goto -27 -> 359
    //   389: astore_2
    //   390: aload_3
    //   391: astore_1
    //   392: goto -121 -> 271
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	395	0	this	ahbc
    //   0	395	1	paramString	String
    //   0	395	2	paramList	java.util.List<ahbd>
    //   19	372	3	localObject1	Object
    //   24	24	4	localObject2	Object
    //   57	273	5	localahbd	ahbd
    //   71	74	6	localContentValues	android.content.ContentValues
    // Exception table:
    //   from	to	target	type
    //   141	214	217	java/lang/Exception
    //   29	37	268	java/lang/Exception
    //   37	59	268	java/lang/Exception
    //   64	111	268	java/lang/Exception
    //   114	130	268	java/lang/Exception
    //   133	141	268	java/lang/Exception
    //   218	265	268	java/lang/Exception
    //   320	326	268	java/lang/Exception
    //   329	338	268	java/lang/Exception
    //   309	313	314	java/lang/Exception
    //   345	349	350	java/lang/Exception
    //   20	26	356	finally
    //   363	367	369	java/lang/Exception
    //   29	37	377	finally
    //   37	59	377	finally
    //   64	111	377	finally
    //   114	130	377	finally
    //   133	141	377	finally
    //   141	214	377	finally
    //   218	265	377	finally
    //   320	326	377	finally
    //   329	338	377	finally
    //   271	305	381	finally
    //   20	26	389	java/lang/Exception
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    a(paramSQLiteDatabase);
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahbc
 * JD-Core Version:    0.7.0.1
 */