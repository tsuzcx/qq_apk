package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

public final class cg
{
  public long a = -1L;
  public byte[] b = null;
  private int c = -1;
  private int d = -1;
  private long e = -1L;
  private long f = 0L;
  
  public cg() {}
  
  public cg(long paramLong, byte[] paramArrayOfByte)
  {
    this.c = 1;
    this.d = 3;
    this.e = paramLong;
    this.b = paramArrayOfByte;
    if (paramArrayOfByte != null) {
      this.f = paramArrayOfByte.length;
    }
  }
  
  public static int a(Context paramContext, int[] paramArrayOfInt)
  {
    int i = -1;
    int j = 0;
    for (;;)
    {
      try
      {
        cy.b(" AnalyticsDAO.delete() start", new Object[0]);
        if (paramContext == null)
        {
          cy.a(" delete() context is null arg", new Object[0]);
          return i;
        }
        if (-1L > 9223372036854775807L)
        {
          i = 0;
        }
        else if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0))
        {
          String str = "";
          i = j;
          if (i < paramArrayOfInt.length)
          {
            str = str + " or _type = " + paramArrayOfInt[i];
            i += 1;
          }
          else
          {
            paramArrayOfInt = str.substring(4);
            paramArrayOfInt = "_time >= -1 and _time <= 9223372036854775807" + " and ( " + paramArrayOfInt + " )";
            cy.b(" delete where: " + paramArrayOfInt, new Object[0]);
            try
            {
              i = ci.a(paramContext).getWritableDatabase().delete("t_event", paramArrayOfInt, null);
              cy.b(" deleted num: " + i, new Object[0]);
              cy.b(" AnalyticsDAO.delete() end", new Object[0]);
              continue;
            }
            catch (Throwable paramContext)
            {
              cy.b(paramContext.getMessage(), new Object[0]);
              cy.b(" AnalyticsDAO.delete() end", new Object[0]);
              i = -1;
              continue;
            }
            finally
            {
              cy.b(" AnalyticsDAO.delete() end", new Object[0]);
            }
          }
        }
        else
        {
          paramArrayOfInt = "_time >= -1 and _time <= 9223372036854775807";
        }
      }
      finally {}
    }
  }
  
  /* Error */
  public static int a(Context paramContext, java.lang.Long[] paramArrayOfLong)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 111
    //   5: iconst_0
    //   6: anewarray 4	java/lang/Object
    //   9: invokestatic 43	com/tencent/tencentmap/mapsdk/a/cy:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   12: aload_0
    //   13: ifnonnull +21 -> 34
    //   16: ldc 113
    //   18: iconst_0
    //   19: anewarray 4	java/lang/Object
    //   22: invokestatic 115	com/tencent/tencentmap/mapsdk/a/cy:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   25: iconst_m1
    //   26: istore 4
    //   28: ldc 2
    //   30: monitorexit
    //   31: iload 4
    //   33: ireturn
    //   34: aload_1
    //   35: ifnull +10 -> 45
    //   38: aload_1
    //   39: arraylength
    //   40: istore_2
    //   41: iload_2
    //   42: ifgt +9 -> 51
    //   45: iconst_0
    //   46: istore 4
    //   48: goto -20 -> 28
    //   51: aload_0
    //   52: invokestatic 89	com/tencent/tencentmap/mapsdk/a/ci:a	(Landroid/content/Context;)Lcom/tencent/tencentmap/mapsdk/a/ci;
    //   55: invokevirtual 93	com/tencent/tencentmap/mapsdk/a/ci:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   58: astore_0
    //   59: new 117	java/lang/StringBuffer
    //   62: dup
    //   63: invokespecial 118	java/lang/StringBuffer:<init>	()V
    //   66: astore 7
    //   68: iconst_0
    //   69: istore 4
    //   71: iconst_0
    //   72: istore_3
    //   73: iload_3
    //   74: istore_2
    //   75: iload 4
    //   77: aload_1
    //   78: arraylength
    //   79: if_icmpge +138 -> 217
    //   82: iload_3
    //   83: istore_2
    //   84: aload_1
    //   85: iload 4
    //   87: aaload
    //   88: invokevirtual 124	java/lang/Long:longValue	()J
    //   91: lstore 5
    //   93: iload_3
    //   94: istore_2
    //   95: aload 7
    //   97: new 53	java/lang/StringBuilder
    //   100: dup
    //   101: ldc 126
    //   103: invokespecial 84	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   106: lload 5
    //   108: invokevirtual 129	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   111: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   114: invokevirtual 132	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   117: pop
    //   118: iload_3
    //   119: istore_2
    //   120: iload 4
    //   122: ifle +226 -> 348
    //   125: iload_3
    //   126: istore_2
    //   127: iload 4
    //   129: bipush 25
    //   131: irem
    //   132: ifne +216 -> 348
    //   135: iload_3
    //   136: istore_2
    //   137: new 53	java/lang/StringBuilder
    //   140: dup
    //   141: ldc 134
    //   143: invokespecial 84	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   146: iload 4
    //   148: invokevirtual 63	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   151: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   154: iconst_0
    //   155: anewarray 4	java/lang/Object
    //   158: invokestatic 43	com/tencent/tencentmap/mapsdk/a/cy:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   161: iload_3
    //   162: istore_2
    //   163: iload_3
    //   164: aload_0
    //   165: ldc 95
    //   167: aload 7
    //   169: iconst_4
    //   170: invokevirtual 135	java/lang/StringBuffer:substring	(I)Ljava/lang/String;
    //   173: aconst_null
    //   174: invokevirtual 101	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   177: iadd
    //   178: istore_3
    //   179: iload_3
    //   180: istore_2
    //   181: aload 7
    //   183: iconst_0
    //   184: invokevirtual 139	java/lang/StringBuffer:setLength	(I)V
    //   187: iload_3
    //   188: istore_2
    //   189: new 53	java/lang/StringBuilder
    //   192: dup
    //   193: ldc 141
    //   195: invokespecial 84	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   198: iload_3
    //   199: invokevirtual 63	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   202: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   205: iconst_0
    //   206: anewarray 4	java/lang/Object
    //   209: invokestatic 43	com/tencent/tencentmap/mapsdk/a/cy:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   212: iload_3
    //   213: istore_2
    //   214: goto +134 -> 348
    //   217: iload_3
    //   218: istore 4
    //   220: iload_3
    //   221: istore_2
    //   222: aload 7
    //   224: invokevirtual 145	java/lang/StringBuffer:length	()I
    //   227: ifle +31 -> 258
    //   230: iload_3
    //   231: istore_2
    //   232: iload_3
    //   233: aload_0
    //   234: ldc 95
    //   236: aload 7
    //   238: iconst_4
    //   239: invokevirtual 135	java/lang/StringBuffer:substring	(I)Ljava/lang/String;
    //   242: aconst_null
    //   243: invokevirtual 101	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   246: iadd
    //   247: istore 4
    //   249: iload 4
    //   251: istore_2
    //   252: aload 7
    //   254: iconst_0
    //   255: invokevirtual 139	java/lang/StringBuffer:setLength	(I)V
    //   258: iload 4
    //   260: istore_2
    //   261: new 53	java/lang/StringBuilder
    //   264: dup
    //   265: ldc 147
    //   267: invokespecial 84	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   270: iload 4
    //   272: invokevirtual 63	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   275: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   278: iconst_0
    //   279: anewarray 4	java/lang/Object
    //   282: invokestatic 47	com/tencent/tencentmap/mapsdk/a/cy:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   285: ldc 149
    //   287: iconst_0
    //   288: anewarray 4	java/lang/Object
    //   291: invokestatic 43	com/tencent/tencentmap/mapsdk/a/cy:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   294: goto -266 -> 28
    //   297: astore_0
    //   298: ldc 2
    //   300: monitorexit
    //   301: aload_0
    //   302: athrow
    //   303: astore_0
    //   304: iconst_0
    //   305: istore_2
    //   306: aload_0
    //   307: invokevirtual 108	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   310: iconst_0
    //   311: anewarray 4	java/lang/Object
    //   314: invokestatic 115	com/tencent/tencentmap/mapsdk/a/cy:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   317: ldc 149
    //   319: iconst_0
    //   320: anewarray 4	java/lang/Object
    //   323: invokestatic 43	com/tencent/tencentmap/mapsdk/a/cy:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   326: iload_2
    //   327: istore 4
    //   329: goto -301 -> 28
    //   332: astore_0
    //   333: ldc 149
    //   335: iconst_0
    //   336: anewarray 4	java/lang/Object
    //   339: invokestatic 43	com/tencent/tencentmap/mapsdk/a/cy:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   342: aload_0
    //   343: athrow
    //   344: astore_0
    //   345: goto -39 -> 306
    //   348: iload 4
    //   350: iconst_1
    //   351: iadd
    //   352: istore 4
    //   354: iload_2
    //   355: istore_3
    //   356: goto -283 -> 73
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	359	0	paramContext	Context
    //   0	359	1	paramArrayOfLong	java.lang.Long[]
    //   40	315	2	i	int
    //   72	284	3	j	int
    //   26	327	4	k	int
    //   91	16	5	l	long
    //   66	187	7	localStringBuffer	java.lang.StringBuffer
    // Exception table:
    //   from	to	target	type
    //   3	12	297	finally
    //   16	25	297	finally
    //   38	41	297	finally
    //   285	294	297	finally
    //   317	326	297	finally
    //   333	344	297	finally
    //   51	68	303	java/lang/Throwable
    //   51	68	332	finally
    //   75	82	332	finally
    //   84	93	332	finally
    //   95	118	332	finally
    //   137	161	332	finally
    //   163	179	332	finally
    //   181	187	332	finally
    //   189	212	332	finally
    //   222	230	332	finally
    //   232	249	332	finally
    //   252	258	332	finally
    //   261	285	332	finally
    //   306	317	332	finally
    //   75	82	344	java/lang/Throwable
    //   84	93	344	java/lang/Throwable
    //   95	118	344	java/lang/Throwable
    //   137	161	344	java/lang/Throwable
    //   163	179	344	java/lang/Throwable
    //   181	187	344	java/lang/Throwable
    //   189	212	344	java/lang/Throwable
    //   222	230	344	java/lang/Throwable
    //   232	249	344	java/lang/Throwable
    //   252	258	344	java/lang/Throwable
    //   261	285	344	java/lang/Throwable
  }
  
  /* Error */
  public static List a(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 154
    //   5: iconst_0
    //   6: anewarray 4	java/lang/Object
    //   9: invokestatic 43	com/tencent/tencentmap/mapsdk/a/cy:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   12: aload_0
    //   13: ifnonnull +19 -> 32
    //   16: ldc 156
    //   18: iconst_0
    //   19: anewarray 4	java/lang/Object
    //   22: invokestatic 115	com/tencent/tencentmap/mapsdk/a/cy:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   25: aconst_null
    //   26: astore_0
    //   27: ldc 2
    //   29: monitorexit
    //   30: aload_0
    //   31: areturn
    //   32: aload_0
    //   33: invokestatic 89	com/tencent/tencentmap/mapsdk/a/ci:a	(Landroid/content/Context;)Lcom/tencent/tencentmap/mapsdk/a/ci;
    //   36: invokevirtual 93	com/tencent/tencentmap/mapsdk/a/ci:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   39: ldc 158
    //   41: aconst_null
    //   42: aconst_null
    //   43: aconst_null
    //   44: aconst_null
    //   45: aconst_null
    //   46: ldc 160
    //   48: ldc 162
    //   50: invokevirtual 166	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   53: astore_1
    //   54: aload_1
    //   55: invokeinterface 172 1 0
    //   60: ifeq +269 -> 329
    //   63: new 174	java/util/ArrayList
    //   66: dup
    //   67: invokespecial 175	java/util/ArrayList:<init>	()V
    //   70: astore_0
    //   71: aload_0
    //   72: astore_2
    //   73: aload_0
    //   74: aload_1
    //   75: aload_1
    //   76: ldc 177
    //   78: invokeinterface 181 2 0
    //   83: invokeinterface 185 2 0
    //   88: invokestatic 191	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   91: invokeinterface 197 2 0
    //   96: pop
    //   97: aload_0
    //   98: astore_2
    //   99: aload_0
    //   100: aload_1
    //   101: aload_1
    //   102: ldc 199
    //   104: invokeinterface 181 2 0
    //   109: invokeinterface 202 2 0
    //   114: invokeinterface 197 2 0
    //   119: pop
    //   120: aload_0
    //   121: astore_2
    //   122: aload_0
    //   123: aload_1
    //   124: aload_1
    //   125: ldc 204
    //   127: invokeinterface 181 2 0
    //   132: invokeinterface 208 2 0
    //   137: invokestatic 211	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   140: invokeinterface 197 2 0
    //   145: pop
    //   146: aload_0
    //   147: astore_2
    //   148: aload_0
    //   149: aload_1
    //   150: aload_1
    //   151: ldc 213
    //   153: invokeinterface 181 2 0
    //   158: invokeinterface 217 2 0
    //   163: invokeinterface 197 2 0
    //   168: pop
    //   169: aload_0
    //   170: astore_2
    //   171: aload_0
    //   172: aload_1
    //   173: aload_1
    //   174: ldc 219
    //   176: invokeinterface 181 2 0
    //   181: invokeinterface 185 2 0
    //   186: invokestatic 191	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   189: invokeinterface 197 2 0
    //   194: pop
    //   195: aload_0
    //   196: ifnull +14 -> 210
    //   199: aload_0
    //   200: astore_2
    //   201: ldc 221
    //   203: iconst_0
    //   204: anewarray 4	java/lang/Object
    //   207: invokestatic 47	com/tencent/tencentmap/mapsdk/a/cy:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   210: aload_1
    //   211: ifnull +18 -> 229
    //   214: aload_1
    //   215: invokeinterface 224 1 0
    //   220: ifne +9 -> 229
    //   223: aload_1
    //   224: invokeinterface 227 1 0
    //   229: ldc 229
    //   231: iconst_0
    //   232: anewarray 4	java/lang/Object
    //   235: invokestatic 43	com/tencent/tencentmap/mapsdk/a/cy:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   238: goto -211 -> 27
    //   241: astore_0
    //   242: ldc 2
    //   244: monitorexit
    //   245: aload_0
    //   246: athrow
    //   247: astore_0
    //   248: aconst_null
    //   249: astore_0
    //   250: aconst_null
    //   251: astore_1
    //   252: aload_1
    //   253: ifnull +18 -> 271
    //   256: aload_1
    //   257: invokeinterface 224 1 0
    //   262: ifne +9 -> 271
    //   265: aload_1
    //   266: invokeinterface 227 1 0
    //   271: ldc 229
    //   273: iconst_0
    //   274: anewarray 4	java/lang/Object
    //   277: invokestatic 43	com/tencent/tencentmap/mapsdk/a/cy:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   280: goto -253 -> 27
    //   283: aload_1
    //   284: ifnull +18 -> 302
    //   287: aload_1
    //   288: invokeinterface 224 1 0
    //   293: ifne +9 -> 302
    //   296: aload_1
    //   297: invokeinterface 227 1 0
    //   302: ldc 229
    //   304: iconst_0
    //   305: anewarray 4	java/lang/Object
    //   308: invokestatic 43	com/tencent/tencentmap/mapsdk/a/cy:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   311: aload_0
    //   312: athrow
    //   313: astore_0
    //   314: goto -31 -> 283
    //   317: astore_0
    //   318: aconst_null
    //   319: astore_0
    //   320: goto -68 -> 252
    //   323: astore_0
    //   324: aload_2
    //   325: astore_0
    //   326: goto -74 -> 252
    //   329: aconst_null
    //   330: astore_0
    //   331: goto -136 -> 195
    //   334: astore_0
    //   335: aconst_null
    //   336: astore_1
    //   337: goto -54 -> 283
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	340	0	paramContext	Context
    //   53	284	1	localCursor	Cursor
    //   72	253	2	localContext	Context
    // Exception table:
    //   from	to	target	type
    //   3	12	241	finally
    //   16	25	241	finally
    //   214	229	241	finally
    //   229	238	241	finally
    //   256	271	241	finally
    //   271	280	241	finally
    //   287	302	241	finally
    //   302	313	241	finally
    //   32	54	247	java/lang/Exception
    //   54	71	313	finally
    //   73	97	313	finally
    //   99	120	313	finally
    //   122	146	313	finally
    //   148	169	313	finally
    //   171	195	313	finally
    //   201	210	313	finally
    //   54	71	317	java/lang/Exception
    //   73	97	323	java/lang/Exception
    //   99	120	323	java/lang/Exception
    //   122	146	323	java/lang/Exception
    //   148	169	323	java/lang/Exception
    //   171	195	323	java/lang/Exception
    //   201	210	323	java/lang/Exception
    //   32	54	334	finally
  }
  
  public static List<cg> a(Context paramContext, int[] paramArrayOfInt, int paramInt)
  {
    try
    {
      paramContext = b(paramContext, paramArrayOfInt, paramInt);
      return paramContext;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  private static List<cg> a(Cursor paramCursor)
  {
    cy.b(" in AnalyticsDAO.paserCursor() start", new Object[0]);
    if (paramCursor == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i = paramCursor.getColumnIndex("_id");
    int j = paramCursor.getColumnIndex("_prority");
    int k = paramCursor.getColumnIndex("_time");
    int m = paramCursor.getColumnIndex("_type");
    int n = paramCursor.getColumnIndex("_datas");
    int i1 = paramCursor.getColumnIndex("_length");
    while (paramCursor.moveToNext())
    {
      cg localcg = new cg();
      localcg.a = paramCursor.getLong(i);
      localcg.b = paramCursor.getBlob(n);
      localcg.d = paramCursor.getInt(j);
      localcg.e = paramCursor.getLong(k);
      localcg.c = paramCursor.getInt(m);
      localcg.f = paramCursor.getLong(i1);
      localArrayList.add(localcg);
    }
    cy.b(" in AnalyticsDAO.paserCursor() end", new Object[0]);
    return localArrayList;
  }
  
  /* Error */
  public static boolean a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: iconst_0
    //   4: istore 4
    //   6: ldc 2
    //   8: monitorenter
    //   9: ldc 250
    //   11: iconst_0
    //   12: anewarray 4	java/lang/Object
    //   15: invokestatic 43	com/tencent/tencentmap/mapsdk/a/cy:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   18: aload_0
    //   19: ifnonnull +20 -> 39
    //   22: ldc 45
    //   24: iconst_0
    //   25: anewarray 4	java/lang/Object
    //   28: invokestatic 47	com/tencent/tencentmap/mapsdk/a/cy:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   31: iload 4
    //   33: istore_3
    //   34: ldc 2
    //   36: monitorexit
    //   37: iload_3
    //   38: ireturn
    //   39: iload 4
    //   41: istore_3
    //   42: aload_1
    //   43: ifnull -9 -> 34
    //   46: iload 4
    //   48: istore_3
    //   49: aload_1
    //   50: invokevirtual 253	java/lang/String:trim	()Ljava/lang/String;
    //   53: ldc 51
    //   55: invokevirtual 256	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   58: ifne -24 -> 34
    //   61: new 53	java/lang/StringBuilder
    //   64: dup
    //   65: ldc_w 258
    //   68: invokespecial 84	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   71: aload_1
    //   72: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: ldc_w 260
    //   78: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   84: astore_1
    //   85: new 53	java/lang/StringBuilder
    //   88: dup
    //   89: ldc 81
    //   91: invokespecial 84	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   94: aload_1
    //   95: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: iconst_0
    //   102: anewarray 4	java/lang/Object
    //   105: invokestatic 43	com/tencent/tencentmap/mapsdk/a/cy:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   108: aload_0
    //   109: invokestatic 89	com/tencent/tencentmap/mapsdk/a/ci:a	(Landroid/content/Context;)Lcom/tencent/tencentmap/mapsdk/a/ci;
    //   112: invokevirtual 93	com/tencent/tencentmap/mapsdk/a/ci:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   115: ldc 158
    //   117: aload_1
    //   118: aconst_null
    //   119: invokevirtual 101	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   122: istore_2
    //   123: new 53	java/lang/StringBuilder
    //   126: dup
    //   127: ldc 103
    //   129: invokespecial 84	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   132: iload_2
    //   133: invokevirtual 63	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   136: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   139: iconst_0
    //   140: anewarray 4	java/lang/Object
    //   143: invokestatic 43	com/tencent/tencentmap/mapsdk/a/cy:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   146: iload 5
    //   148: istore_3
    //   149: iload_2
    //   150: iconst_1
    //   151: if_icmpne +5 -> 156
    //   154: iconst_1
    //   155: istore_3
    //   156: ldc_w 262
    //   159: iconst_0
    //   160: anewarray 4	java/lang/Object
    //   163: invokestatic 43	com/tencent/tencentmap/mapsdk/a/cy:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   166: goto -132 -> 34
    //   169: astore_0
    //   170: ldc 2
    //   172: monitorexit
    //   173: aload_0
    //   174: athrow
    //   175: astore_0
    //   176: aload_0
    //   177: invokevirtual 108	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   180: iconst_0
    //   181: anewarray 4	java/lang/Object
    //   184: invokestatic 43	com/tencent/tencentmap/mapsdk/a/cy:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   187: ldc_w 262
    //   190: iconst_0
    //   191: anewarray 4	java/lang/Object
    //   194: invokestatic 43	com/tencent/tencentmap/mapsdk/a/cy:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   197: iload 4
    //   199: istore_3
    //   200: goto -166 -> 34
    //   203: astore_0
    //   204: ldc_w 262
    //   207: iconst_0
    //   208: anewarray 4	java/lang/Object
    //   211: invokestatic 43	com/tencent/tencentmap/mapsdk/a/cy:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   214: aload_0
    //   215: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	216	0	paramContext	Context
    //   0	216	1	paramString	String
    //   122	30	2	i	int
    //   33	167	3	bool1	boolean
    //   4	194	4	bool2	boolean
    //   1	146	5	bool3	boolean
    // Exception table:
    //   from	to	target	type
    //   9	18	169	finally
    //   22	31	169	finally
    //   49	108	169	finally
    //   156	166	169	finally
    //   187	197	169	finally
    //   204	216	169	finally
    //   108	146	175	java/lang/Throwable
    //   108	146	203	finally
    //   176	187	203	finally
  }
  
  /* Error */
  public static boolean a(Context paramContext, List<cg> paramList)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: ldc 2
    //   4: monitorenter
    //   5: ldc_w 265
    //   8: iconst_0
    //   9: anewarray 4	java/lang/Object
    //   12: invokestatic 43	com/tencent/tencentmap/mapsdk/a/cy:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   15: aload_0
    //   16: ifnull +7 -> 23
    //   19: aload_1
    //   20: ifnonnull +20 -> 40
    //   23: ldc_w 267
    //   26: iconst_0
    //   27: anewarray 4	java/lang/Object
    //   30: invokestatic 115	com/tencent/tencentmap/mapsdk/a/cy:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   33: iconst_0
    //   34: istore_3
    //   35: ldc 2
    //   37: monitorexit
    //   38: iload_3
    //   39: ireturn
    //   40: aload_1
    //   41: invokeinterface 270 1 0
    //   46: ifgt +22 -> 68
    //   49: ldc_w 272
    //   52: iconst_0
    //   53: anewarray 4	java/lang/Object
    //   56: invokestatic 43	com/tencent/tencentmap/mapsdk/a/cy:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   59: goto -24 -> 35
    //   62: astore_0
    //   63: ldc 2
    //   65: monitorexit
    //   66: aload_0
    //   67: athrow
    //   68: aconst_null
    //   69: astore 6
    //   71: aload_0
    //   72: invokestatic 89	com/tencent/tencentmap/mapsdk/a/ci:a	(Landroid/content/Context;)Lcom/tencent/tencentmap/mapsdk/a/ci;
    //   75: invokevirtual 93	com/tencent/tencentmap/mapsdk/a/ci:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   78: astore_0
    //   79: aload_0
    //   80: invokevirtual 275	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   83: iconst_0
    //   84: istore_2
    //   85: iload_2
    //   86: aload_1
    //   87: invokeinterface 270 1 0
    //   92: if_icmpge +164 -> 256
    //   95: aload_1
    //   96: iload_2
    //   97: invokeinterface 279 2 0
    //   102: checkcast 2	com/tencent/tencentmap/mapsdk/a/cg
    //   105: astore 6
    //   107: new 281	android/content/ContentValues
    //   110: dup
    //   111: invokespecial 282	android/content/ContentValues:<init>	()V
    //   114: astore 7
    //   116: aload 6
    //   118: getfield 21	com/tencent/tencentmap/mapsdk/a/cg:a	J
    //   121: lconst_0
    //   122: lcmp
    //   123: ifle +18 -> 141
    //   126: aload 7
    //   128: ldc 177
    //   130: aload 6
    //   132: getfield 21	com/tencent/tencentmap/mapsdk/a/cg:a	J
    //   135: invokestatic 211	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   138: invokevirtual 286	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   141: aload 7
    //   143: ldc 239
    //   145: aload 6
    //   147: getfield 25	com/tencent/tencentmap/mapsdk/a/cg:d	I
    //   150: invokestatic 191	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   153: invokevirtual 289	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   156: aload 7
    //   158: ldc 204
    //   160: aload 6
    //   162: getfield 27	com/tencent/tencentmap/mapsdk/a/cg:e	J
    //   165: invokestatic 211	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   168: invokevirtual 286	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   171: aload 7
    //   173: ldc 241
    //   175: aload 6
    //   177: getfield 23	com/tencent/tencentmap/mapsdk/a/cg:c	I
    //   180: invokestatic 191	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   183: invokevirtual 289	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   186: aload 7
    //   188: ldc 213
    //   190: aload 6
    //   192: getfield 29	com/tencent/tencentmap/mapsdk/a/cg:b	[B
    //   195: invokevirtual 292	android/content/ContentValues:put	(Ljava/lang/String;[B)V
    //   198: aload 7
    //   200: ldc 243
    //   202: aload 6
    //   204: getfield 31	com/tencent/tencentmap/mapsdk/a/cg:f	J
    //   207: invokestatic 211	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   210: invokevirtual 286	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   213: aload_0
    //   214: ldc 95
    //   216: ldc 177
    //   218: aload 7
    //   220: invokevirtual 296	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   223: lstore 4
    //   225: lload 4
    //   227: lconst_0
    //   228: lcmp
    //   229: ifge +13 -> 242
    //   232: ldc_w 298
    //   235: iconst_0
    //   236: anewarray 4	java/lang/Object
    //   239: invokestatic 115	com/tencent/tencentmap/mapsdk/a/cy:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   242: aload 6
    //   244: lload 4
    //   246: putfield 21	com/tencent/tencentmap/mapsdk/a/cg:a	J
    //   249: iload_2
    //   250: iconst_1
    //   251: iadd
    //   252: istore_2
    //   253: goto -168 -> 85
    //   256: aload_0
    //   257: invokevirtual 301	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   260: aload_0
    //   261: invokevirtual 304	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   264: ldc_w 306
    //   267: iconst_0
    //   268: anewarray 4	java/lang/Object
    //   271: invokestatic 43	com/tencent/tencentmap/mapsdk/a/cy:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   274: iconst_1
    //   275: istore_3
    //   276: goto +109 -> 385
    //   279: astore_0
    //   280: ldc_w 308
    //   283: iconst_0
    //   284: anewarray 4	java/lang/Object
    //   287: invokestatic 43	com/tencent/tencentmap/mapsdk/a/cy:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   290: goto -26 -> 264
    //   293: astore_0
    //   294: aload 6
    //   296: astore_0
    //   297: ldc_w 310
    //   300: iconst_0
    //   301: anewarray 4	java/lang/Object
    //   304: invokestatic 43	com/tencent/tencentmap/mapsdk/a/cy:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   307: aload_0
    //   308: invokevirtual 304	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   311: ldc_w 306
    //   314: iconst_0
    //   315: anewarray 4	java/lang/Object
    //   318: invokestatic 43	com/tencent/tencentmap/mapsdk/a/cy:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   321: iconst_0
    //   322: istore_3
    //   323: goto +62 -> 385
    //   326: astore_0
    //   327: ldc_w 308
    //   330: iconst_0
    //   331: anewarray 4	java/lang/Object
    //   334: invokestatic 43	com/tencent/tencentmap/mapsdk/a/cy:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   337: goto -26 -> 311
    //   340: astore_1
    //   341: aconst_null
    //   342: astore_0
    //   343: aload_0
    //   344: invokevirtual 304	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   347: ldc_w 306
    //   350: iconst_0
    //   351: anewarray 4	java/lang/Object
    //   354: invokestatic 43	com/tencent/tencentmap/mapsdk/a/cy:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   357: aload_1
    //   358: athrow
    //   359: astore_0
    //   360: ldc_w 308
    //   363: iconst_0
    //   364: anewarray 4	java/lang/Object
    //   367: invokestatic 43	com/tencent/tencentmap/mapsdk/a/cy:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   370: goto -23 -> 347
    //   373: astore_1
    //   374: goto -31 -> 343
    //   377: astore_1
    //   378: goto -35 -> 343
    //   381: astore_1
    //   382: goto -85 -> 297
    //   385: goto -350 -> 35
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	388	0	paramContext	Context
    //   0	388	1	paramList	List<cg>
    //   84	169	2	i	int
    //   1	322	3	bool	boolean
    //   223	22	4	l	long
    //   69	226	6	localcg	cg
    //   114	105	7	localContentValues	android.content.ContentValues
    // Exception table:
    //   from	to	target	type
    //   5	15	62	finally
    //   23	33	62	finally
    //   40	59	62	finally
    //   260	264	62	finally
    //   264	274	62	finally
    //   280	290	62	finally
    //   307	311	62	finally
    //   311	321	62	finally
    //   327	337	62	finally
    //   343	347	62	finally
    //   347	359	62	finally
    //   360	370	62	finally
    //   260	264	279	java/lang/Exception
    //   71	79	293	java/lang/Throwable
    //   307	311	326	java/lang/Exception
    //   71	79	340	finally
    //   343	347	359	java/lang/Exception
    //   79	83	373	finally
    //   85	141	373	finally
    //   141	225	373	finally
    //   232	242	373	finally
    //   242	249	373	finally
    //   256	260	373	finally
    //   297	307	377	finally
    //   79	83	381	java/lang/Throwable
    //   85	141	381	java/lang/Throwable
    //   141	225	381	java/lang/Throwable
    //   232	242	381	java/lang/Throwable
    //   242	249	381	java/lang/Throwable
    //   256	260	381	java/lang/Throwable
  }
  
  /* Error */
  public static boolean a(Context paramContext, byte[] paramArrayOfByte, String paramString, int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: iconst_0
    //   4: istore 4
    //   6: ldc 2
    //   8: monitorenter
    //   9: ldc_w 314
    //   12: iconst_0
    //   13: anewarray 4	java/lang/Object
    //   16: invokestatic 43	com/tencent/tencentmap/mapsdk/a/cy:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   19: aload_0
    //   20: ifnull +11 -> 31
    //   23: aload_1
    //   24: ifnull +7 -> 31
    //   27: aload_2
    //   28: ifnonnull +19 -> 47
    //   31: ldc_w 316
    //   34: iconst_0
    //   35: anewarray 4	java/lang/Object
    //   38: invokestatic 115	com/tencent/tencentmap/mapsdk/a/cy:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   41: ldc 2
    //   43: monitorexit
    //   44: iload 4
    //   46: ireturn
    //   47: aload_0
    //   48: invokestatic 89	com/tencent/tencentmap/mapsdk/a/ci:a	(Landroid/content/Context;)Lcom/tencent/tencentmap/mapsdk/a/ci;
    //   51: invokevirtual 93	com/tencent/tencentmap/mapsdk/a/ci:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   54: astore_0
    //   55: new 281	android/content/ContentValues
    //   58: dup
    //   59: invokespecial 282	android/content/ContentValues:<init>	()V
    //   62: astore 6
    //   64: aload 6
    //   66: ldc 199
    //   68: aload_2
    //   69: invokevirtual 319	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   72: aload 6
    //   74: ldc 204
    //   76: new 321	java/util/Date
    //   79: dup
    //   80: invokespecial 322	java/util/Date:<init>	()V
    //   83: invokevirtual 325	java/util/Date:getTime	()J
    //   86: invokestatic 211	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   89: invokevirtual 286	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   92: aload 6
    //   94: ldc 219
    //   96: iload_3
    //   97: invokestatic 191	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   100: invokevirtual 289	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   103: aload 6
    //   105: ldc 213
    //   107: aload_1
    //   108: invokevirtual 292	android/content/ContentValues:put	(Ljava/lang/String;[B)V
    //   111: aload_0
    //   112: ldc 158
    //   114: aconst_null
    //   115: aload 6
    //   117: invokevirtual 296	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   120: lconst_0
    //   121: lcmp
    //   122: ifge +36 -> 158
    //   125: ldc_w 327
    //   128: iconst_0
    //   129: anewarray 4	java/lang/Object
    //   132: invokestatic 115	com/tencent/tencentmap/mapsdk/a/cy:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   135: iload 5
    //   137: istore 4
    //   139: ldc_w 329
    //   142: iconst_0
    //   143: anewarray 4	java/lang/Object
    //   146: invokestatic 43	com/tencent/tencentmap/mapsdk/a/cy:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   149: goto -108 -> 41
    //   152: astore_0
    //   153: ldc 2
    //   155: monitorexit
    //   156: aload_0
    //   157: athrow
    //   158: iconst_1
    //   159: istore 4
    //   161: goto -22 -> 139
    //   164: astore_0
    //   165: ldc_w 331
    //   168: iconst_0
    //   169: anewarray 4	java/lang/Object
    //   172: invokestatic 43	com/tencent/tencentmap/mapsdk/a/cy:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   175: ldc_w 329
    //   178: iconst_0
    //   179: anewarray 4	java/lang/Object
    //   182: invokestatic 43	com/tencent/tencentmap/mapsdk/a/cy:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   185: goto -144 -> 41
    //   188: astore_0
    //   189: ldc_w 329
    //   192: iconst_0
    //   193: anewarray 4	java/lang/Object
    //   196: invokestatic 43	com/tencent/tencentmap/mapsdk/a/cy:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   199: aload_0
    //   200: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	201	0	paramContext	Context
    //   0	201	1	paramArrayOfByte	byte[]
    //   0	201	2	paramString	String
    //   0	201	3	paramInt	int
    //   4	156	4	bool1	boolean
    //   1	135	5	bool2	boolean
    //   62	54	6	localContentValues	android.content.ContentValues
    // Exception table:
    //   from	to	target	type
    //   9	19	152	finally
    //   31	41	152	finally
    //   139	149	152	finally
    //   175	185	152	finally
    //   189	201	152	finally
    //   47	135	164	java/lang/Throwable
    //   47	135	188	finally
    //   165	175	188	finally
  }
  
  /* Error */
  public static int b(Context paramContext, int[] paramArrayOfInt)
  {
    // Byte code:
    //   0: iconst_m1
    //   1: istore_2
    //   2: iconst_0
    //   3: istore_3
    //   4: ldc 2
    //   6: monitorenter
    //   7: ldc_w 333
    //   10: iconst_0
    //   11: anewarray 4	java/lang/Object
    //   14: invokestatic 43	com/tencent/tencentmap/mapsdk/a/cy:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   17: aload_0
    //   18: ifnonnull +18 -> 36
    //   21: ldc_w 335
    //   24: iconst_0
    //   25: anewarray 4	java/lang/Object
    //   28: invokestatic 47	com/tencent/tencentmap/mapsdk/a/cy:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   31: ldc 2
    //   33: monitorexit
    //   34: iload_2
    //   35: ireturn
    //   36: ldc2_w 18
    //   39: ldc2_w 48
    //   42: lcmp
    //   43: ifle +8 -> 51
    //   46: iconst_0
    //   47: istore_2
    //   48: goto -17 -> 31
    //   51: ldc 75
    //   53: astore 5
    //   55: aload 5
    //   57: astore 4
    //   59: aload_1
    //   60: ifnull +97 -> 157
    //   63: aload 5
    //   65: astore 4
    //   67: aload_1
    //   68: arraylength
    //   69: ifle +88 -> 157
    //   72: ldc 51
    //   74: astore 4
    //   76: iload_3
    //   77: istore_2
    //   78: iload_2
    //   79: aload_1
    //   80: arraylength
    //   81: if_icmpge +38 -> 119
    //   84: new 53	java/lang/StringBuilder
    //   87: dup
    //   88: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   91: aload 4
    //   93: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: ldc 60
    //   98: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: aload_1
    //   102: iload_2
    //   103: iaload
    //   104: invokevirtual 63	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   107: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: astore 4
    //   112: iload_2
    //   113: iconst_1
    //   114: iadd
    //   115: istore_2
    //   116: goto -38 -> 78
    //   119: aload 4
    //   121: iconst_4
    //   122: invokevirtual 73	java/lang/String:substring	(I)Ljava/lang/String;
    //   125: astore_1
    //   126: new 53	java/lang/StringBuilder
    //   129: dup
    //   130: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   133: ldc 75
    //   135: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: ldc 77
    //   140: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: aload_1
    //   144: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: ldc 79
    //   149: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   155: astore 4
    //   157: new 53	java/lang/StringBuilder
    //   160: dup
    //   161: ldc_w 337
    //   164: invokespecial 84	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   167: aload 4
    //   169: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   175: iconst_0
    //   176: anewarray 4	java/lang/Object
    //   179: invokestatic 43	com/tencent/tencentmap/mapsdk/a/cy:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   182: aload_0
    //   183: invokestatic 89	com/tencent/tencentmap/mapsdk/a/ci:a	(Landroid/content/Context;)Lcom/tencent/tencentmap/mapsdk/a/ci;
    //   186: invokevirtual 93	com/tencent/tencentmap/mapsdk/a/ci:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   189: ldc 95
    //   191: iconst_1
    //   192: anewarray 69	java/lang/String
    //   195: dup
    //   196: iconst_0
    //   197: ldc_w 339
    //   200: aastore
    //   201: aload 4
    //   203: aconst_null
    //   204: aconst_null
    //   205: aconst_null
    //   206: aconst_null
    //   207: invokevirtual 342	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   210: astore_1
    //   211: aload_1
    //   212: astore_0
    //   213: aload_1
    //   214: invokeinterface 172 1 0
    //   219: pop
    //   220: aload_1
    //   221: astore_0
    //   222: aload_1
    //   223: aload_1
    //   224: ldc_w 344
    //   227: invokeinterface 181 2 0
    //   232: invokeinterface 185 2 0
    //   237: istore_2
    //   238: aload_1
    //   239: astore_0
    //   240: new 53	java/lang/StringBuilder
    //   243: dup
    //   244: ldc_w 346
    //   247: invokespecial 84	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   250: iload_2
    //   251: invokevirtual 63	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   254: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   257: iconst_0
    //   258: anewarray 4	java/lang/Object
    //   261: invokestatic 43	com/tencent/tencentmap/mapsdk/a/cy:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   264: aload_1
    //   265: ifnull +18 -> 283
    //   268: aload_1
    //   269: invokeinterface 224 1 0
    //   274: ifne +9 -> 283
    //   277: aload_1
    //   278: invokeinterface 227 1 0
    //   283: ldc_w 348
    //   286: iconst_0
    //   287: anewarray 4	java/lang/Object
    //   290: invokestatic 43	com/tencent/tencentmap/mapsdk/a/cy:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   293: goto -262 -> 31
    //   296: astore 4
    //   298: aconst_null
    //   299: astore_1
    //   300: aload_1
    //   301: astore_0
    //   302: aload 4
    //   304: invokevirtual 108	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   307: iconst_0
    //   308: anewarray 4	java/lang/Object
    //   311: invokestatic 43	com/tencent/tencentmap/mapsdk/a/cy:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   314: aload_1
    //   315: ifnull +18 -> 333
    //   318: aload_1
    //   319: invokeinterface 224 1 0
    //   324: ifne +9 -> 333
    //   327: aload_1
    //   328: invokeinterface 227 1 0
    //   333: ldc_w 348
    //   336: iconst_0
    //   337: anewarray 4	java/lang/Object
    //   340: invokestatic 43	com/tencent/tencentmap/mapsdk/a/cy:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   343: iconst_m1
    //   344: istore_2
    //   345: goto -52 -> 293
    //   348: aload_0
    //   349: ifnull +18 -> 367
    //   352: aload_0
    //   353: invokeinterface 224 1 0
    //   358: ifne +9 -> 367
    //   361: aload_0
    //   362: invokeinterface 227 1 0
    //   367: ldc_w 348
    //   370: iconst_0
    //   371: anewarray 4	java/lang/Object
    //   374: invokestatic 43	com/tencent/tencentmap/mapsdk/a/cy:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   377: aload_1
    //   378: athrow
    //   379: astore_0
    //   380: ldc 2
    //   382: monitorexit
    //   383: aload_0
    //   384: athrow
    //   385: astore_1
    //   386: goto -38 -> 348
    //   389: astore 4
    //   391: goto -91 -> 300
    //   394: astore_1
    //   395: aconst_null
    //   396: astore_0
    //   397: goto -49 -> 348
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	400	0	paramContext	Context
    //   0	400	1	paramArrayOfInt	int[]
    //   1	344	2	i	int
    //   3	74	3	j	int
    //   57	145	4	str1	String
    //   296	7	4	localThrowable1	Throwable
    //   389	1	4	localThrowable2	Throwable
    //   53	11	5	str2	String
    // Exception table:
    //   from	to	target	type
    //   182	211	296	java/lang/Throwable
    //   7	17	379	finally
    //   21	31	379	finally
    //   67	72	379	finally
    //   78	112	379	finally
    //   119	157	379	finally
    //   157	182	379	finally
    //   268	283	379	finally
    //   283	293	379	finally
    //   318	333	379	finally
    //   333	343	379	finally
    //   352	367	379	finally
    //   367	379	379	finally
    //   213	220	385	finally
    //   222	238	385	finally
    //   240	264	385	finally
    //   302	314	385	finally
    //   213	220	389	java/lang/Throwable
    //   222	238	389	java/lang/Throwable
    //   240	264	389	java/lang/Throwable
    //   182	211	394	finally
  }
  
  private static List<cg> b(Context paramContext, int[] paramArrayOfInt, int paramInt)
  {
    try
    {
      paramContext = c(paramContext, paramArrayOfInt, paramInt);
      return paramContext;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  /* Error */
  private static List<cg> c(Context paramContext, int[] paramArrayOfInt, int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: ldc 2
    //   4: monitorenter
    //   5: ldc_w 352
    //   8: iconst_0
    //   9: anewarray 4	java/lang/Object
    //   12: invokestatic 43	com/tencent/tencentmap/mapsdk/a/cy:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   15: aload_0
    //   16: ifnull +87 -> 103
    //   19: ldc2_w 18
    //   22: lconst_0
    //   23: lcmp
    //   24: ifle +13 -> 37
    //   27: ldc2_w 18
    //   30: ldc2_w 18
    //   33: lcmp
    //   34: ifgt +69 -> 103
    //   37: ldc 51
    //   39: astore 5
    //   41: aload 5
    //   43: astore 4
    //   45: aload_1
    //   46: ifnull +100 -> 146
    //   49: aload 5
    //   51: astore 4
    //   53: aload_1
    //   54: arraylength
    //   55: ifle +91 -> 146
    //   58: ldc 51
    //   60: astore 4
    //   62: iload_3
    //   63: aload_1
    //   64: arraylength
    //   65: if_icmpge +55 -> 120
    //   68: new 53	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   75: aload 4
    //   77: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: ldc 60
    //   82: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: aload_1
    //   86: iload_3
    //   87: iaload
    //   88: invokevirtual 63	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   91: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   94: astore 4
    //   96: iload_3
    //   97: iconst_1
    //   98: iadd
    //   99: istore_3
    //   100: goto -38 -> 62
    //   103: ldc_w 354
    //   106: iconst_0
    //   107: anewarray 4	java/lang/Object
    //   110: invokestatic 115	com/tencent/tencentmap/mapsdk/a/cy:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   113: aconst_null
    //   114: astore_0
    //   115: ldc 2
    //   117: monitorexit
    //   118: aload_0
    //   119: areturn
    //   120: new 53	java/lang/StringBuilder
    //   123: dup
    //   124: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   127: ldc 51
    //   129: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: aload 4
    //   134: iconst_4
    //   135: invokevirtual 73	java/lang/String:substring	(I)Ljava/lang/String;
    //   138: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   144: astore 4
    //   146: aload 4
    //   148: invokevirtual 355	java/lang/String:length	()I
    //   151: ifle +380 -> 531
    //   154: new 53	java/lang/StringBuilder
    //   157: dup
    //   158: ldc_w 357
    //   161: invokespecial 84	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   164: aload 4
    //   166: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: ldc_w 359
    //   172: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   178: astore 4
    //   180: aload 4
    //   182: astore_1
    //   183: ldc2_w 18
    //   186: lconst_0
    //   187: lcmp
    //   188: iflt +45 -> 233
    //   191: new 53	java/lang/StringBuilder
    //   194: dup
    //   195: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   198: aload 4
    //   200: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: astore 5
    //   205: aload 4
    //   207: invokevirtual 355	java/lang/String:length	()I
    //   210: ifle +447 -> 657
    //   213: ldc_w 361
    //   216: astore_1
    //   217: aload 5
    //   219: aload_1
    //   220: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: ldc_w 363
    //   226: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   232: astore_1
    //   233: aload_1
    //   234: astore 4
    //   236: ldc2_w 18
    //   239: lconst_0
    //   240: lcmp
    //   241: iflt +44 -> 285
    //   244: new 53	java/lang/StringBuilder
    //   247: dup
    //   248: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   251: aload_1
    //   252: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: astore 4
    //   257: aload_1
    //   258: invokevirtual 355	java/lang/String:length	()I
    //   261: ifle +277 -> 538
    //   264: ldc_w 361
    //   267: astore_1
    //   268: aload 4
    //   270: aload_1
    //   271: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: ldc_w 365
    //   277: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   283: astore 4
    //   285: new 53	java/lang/StringBuilder
    //   288: dup
    //   289: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   292: ldc 51
    //   294: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: ldc_w 367
    //   300: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   306: astore_1
    //   307: new 53	java/lang/StringBuilder
    //   310: dup
    //   311: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   314: aload_1
    //   315: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: ldc 160
    //   320: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   326: astore 5
    //   328: aload 5
    //   330: astore_1
    //   331: aload 5
    //   333: ldc_w 369
    //   336: invokevirtual 373	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   339: ifeq +17 -> 356
    //   342: aload 5
    //   344: iconst_0
    //   345: aload 5
    //   347: invokevirtual 355	java/lang/String:length	()I
    //   350: iconst_3
    //   351: isub
    //   352: invokevirtual 376	java/lang/String:substring	(II)Ljava/lang/String;
    //   355: astore_1
    //   356: ldc_w 378
    //   359: iconst_1
    //   360: anewarray 4	java/lang/Object
    //   363: dup
    //   364: iconst_0
    //   365: aload 4
    //   367: aastore
    //   368: invokestatic 43	com/tencent/tencentmap/mapsdk/a/cy:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   371: aload_0
    //   372: invokestatic 89	com/tencent/tencentmap/mapsdk/a/ci:a	(Landroid/content/Context;)Lcom/tencent/tencentmap/mapsdk/a/ci;
    //   375: invokevirtual 93	com/tencent/tencentmap/mapsdk/a/ci:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   378: astore 5
    //   380: iload_2
    //   381: iflt +163 -> 544
    //   384: iload_2
    //   385: invokestatic 380	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   388: astore_0
    //   389: aload 5
    //   391: ldc 95
    //   393: aconst_null
    //   394: aload 4
    //   396: aconst_null
    //   397: aconst_null
    //   398: aconst_null
    //   399: aload_1
    //   400: aload_0
    //   401: invokevirtual 166	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   404: astore_1
    //   405: aload_1
    //   406: astore 4
    //   408: new 53	java/lang/StringBuilder
    //   411: dup
    //   412: ldc_w 382
    //   415: invokespecial 84	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   418: aload_1
    //   419: invokeinterface 385 1 0
    //   424: invokevirtual 63	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   427: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   430: iconst_0
    //   431: anewarray 4	java/lang/Object
    //   434: invokestatic 47	com/tencent/tencentmap/mapsdk/a/cy:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   437: aload_1
    //   438: astore 4
    //   440: aload_1
    //   441: invokeinterface 385 1 0
    //   446: ifle +206 -> 652
    //   449: aload_1
    //   450: astore 4
    //   452: aload_1
    //   453: invokestatic 387	com/tencent/tencentmap/mapsdk/a/cg:a	(Landroid/database/Cursor;)Ljava/util/List;
    //   456: astore_0
    //   457: aload_0
    //   458: ifnull +35 -> 493
    //   461: aload_1
    //   462: astore 4
    //   464: new 53	java/lang/StringBuilder
    //   467: dup
    //   468: ldc_w 389
    //   471: invokespecial 84	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   474: aload_0
    //   475: invokeinterface 270 1 0
    //   480: invokevirtual 63	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   483: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   486: iconst_0
    //   487: anewarray 4	java/lang/Object
    //   490: invokestatic 47	com/tencent/tencentmap/mapsdk/a/cy:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   493: aload_1
    //   494: ifnull +18 -> 512
    //   497: aload_1
    //   498: invokeinterface 224 1 0
    //   503: ifne +9 -> 512
    //   506: aload_1
    //   507: invokeinterface 227 1 0
    //   512: ldc_w 391
    //   515: iconst_0
    //   516: anewarray 4	java/lang/Object
    //   519: invokestatic 43	com/tencent/tencentmap/mapsdk/a/cy:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   522: goto -407 -> 115
    //   525: astore_0
    //   526: ldc 2
    //   528: monitorexit
    //   529: aload_0
    //   530: athrow
    //   531: ldc 51
    //   533: astore 4
    //   535: goto -355 -> 180
    //   538: ldc 51
    //   540: astore_1
    //   541: goto -273 -> 268
    //   544: aconst_null
    //   545: astore_0
    //   546: goto -157 -> 389
    //   549: astore 5
    //   551: aconst_null
    //   552: astore_1
    //   553: aconst_null
    //   554: astore_0
    //   555: aload_1
    //   556: astore 4
    //   558: aload 5
    //   560: invokevirtual 108	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   563: iconst_0
    //   564: anewarray 4	java/lang/Object
    //   567: invokestatic 43	com/tencent/tencentmap/mapsdk/a/cy:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   570: aload_1
    //   571: ifnull +18 -> 589
    //   574: aload_1
    //   575: invokeinterface 224 1 0
    //   580: ifne +9 -> 589
    //   583: aload_1
    //   584: invokeinterface 227 1 0
    //   589: ldc_w 391
    //   592: iconst_0
    //   593: anewarray 4	java/lang/Object
    //   596: invokestatic 43	com/tencent/tencentmap/mapsdk/a/cy:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   599: goto -484 -> 115
    //   602: aload 4
    //   604: ifnull +20 -> 624
    //   607: aload 4
    //   609: invokeinterface 224 1 0
    //   614: ifne +10 -> 624
    //   617: aload 4
    //   619: invokeinterface 227 1 0
    //   624: ldc_w 391
    //   627: iconst_0
    //   628: anewarray 4	java/lang/Object
    //   631: invokestatic 43	com/tencent/tencentmap/mapsdk/a/cy:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   634: aload_0
    //   635: athrow
    //   636: astore_0
    //   637: goto -35 -> 602
    //   640: astore 5
    //   642: aconst_null
    //   643: astore_0
    //   644: goto -89 -> 555
    //   647: astore 5
    //   649: goto -94 -> 555
    //   652: aconst_null
    //   653: astore_0
    //   654: goto -197 -> 457
    //   657: ldc 51
    //   659: astore_1
    //   660: goto -443 -> 217
    //   663: astore_0
    //   664: aconst_null
    //   665: astore 4
    //   667: goto -65 -> 602
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	670	0	paramContext	Context
    //   0	670	1	paramArrayOfInt	int[]
    //   0	670	2	paramInt	int
    //   1	99	3	i	int
    //   43	623	4	localObject1	Object
    //   39	351	5	localObject2	Object
    //   549	10	5	localThrowable1	Throwable
    //   640	1	5	localThrowable2	Throwable
    //   647	1	5	localThrowable3	Throwable
    // Exception table:
    //   from	to	target	type
    //   5	15	525	finally
    //   53	58	525	finally
    //   62	96	525	finally
    //   103	113	525	finally
    //   120	146	525	finally
    //   146	180	525	finally
    //   191	213	525	finally
    //   217	233	525	finally
    //   244	264	525	finally
    //   268	285	525	finally
    //   285	328	525	finally
    //   331	356	525	finally
    //   356	371	525	finally
    //   497	512	525	finally
    //   512	522	525	finally
    //   574	589	525	finally
    //   589	599	525	finally
    //   607	624	525	finally
    //   624	636	525	finally
    //   371	380	549	java/lang/Throwable
    //   384	389	549	java/lang/Throwable
    //   389	405	549	java/lang/Throwable
    //   408	437	636	finally
    //   440	449	636	finally
    //   452	457	636	finally
    //   464	493	636	finally
    //   558	570	636	finally
    //   408	437	640	java/lang/Throwable
    //   440	449	640	java/lang/Throwable
    //   452	457	640	java/lang/Throwable
    //   464	493	647	java/lang/Throwable
    //   371	380	663	finally
    //   384	389	663	finally
    //   389	405	663	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.cg
 * JD-Core Version:    0.7.0.1
 */