package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.vfs.s;

public final class bz
  extends MStorageEx
{
  public static final String[] SQL_CREATE = { "CREATE TABLE IF NOT EXISTS  MediaDuplication  (md5 text , size int , path text , createtime long, remuxing text, duration int, status int);", "DROP INDEX IF EXISTS MediaDuplicationMD5Index ", "CREATE INDEX IF NOT EXISTS MD5Index ON MediaDuplication ( md5 )" };
  public ISQLiteDatabase db;
  
  /* Error */
  public bz(com.tencent.mm.storagebase.h paramh)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 11
    //   3: aload_0
    //   4: invokespecial 27	com/tencent/mm/sdk/storage/MStorageEx:<init>	()V
    //   7: ldc 28
    //   9: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   12: aload_0
    //   13: aload_1
    //   14: putfield 36	com/tencent/mm/storage/bz:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   17: aload_0
    //   18: getfield 36	com/tencent/mm/storage/bz:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   21: new 38	java/lang/StringBuilder
    //   24: dup
    //   25: ldc 40
    //   27: invokespecial 43	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   30: ldc 45
    //   32: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: ldc 51
    //   37: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: aconst_null
    //   44: iconst_2
    //   45: invokeinterface 61 4 0
    //   50: astore 10
    //   52: aload 10
    //   54: astore_1
    //   55: aload 10
    //   57: ldc 63
    //   59: invokeinterface 69 2 0
    //   64: istore 5
    //   66: iconst_0
    //   67: istore 4
    //   69: iconst_0
    //   70: istore_3
    //   71: iconst_0
    //   72: istore_2
    //   73: aload 10
    //   75: astore_1
    //   76: aload 10
    //   78: invokeinterface 73 1 0
    //   83: ifeq +77 -> 160
    //   86: iload 5
    //   88: iflt -15 -> 73
    //   91: aload 10
    //   93: astore_1
    //   94: aload 10
    //   96: iload 5
    //   98: invokeinterface 77 2 0
    //   103: astore 12
    //   105: aload 10
    //   107: astore_1
    //   108: ldc 79
    //   110: aload 12
    //   112: invokevirtual 83	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   115: ifeq +8 -> 123
    //   118: iconst_1
    //   119: istore_2
    //   120: goto -47 -> 73
    //   123: aload 10
    //   125: astore_1
    //   126: ldc 85
    //   128: aload 12
    //   130: invokevirtual 83	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   133: ifeq +8 -> 141
    //   136: iconst_1
    //   137: istore_3
    //   138: goto -65 -> 73
    //   141: aload 10
    //   143: astore_1
    //   144: ldc 87
    //   146: aload 12
    //   148: invokevirtual 83	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   151: ifeq -78 -> 73
    //   154: iconst_1
    //   155: istore 4
    //   157: goto -84 -> 73
    //   160: aload 10
    //   162: astore_1
    //   163: aload 10
    //   165: invokeinterface 90 1 0
    //   170: invokestatic 96	com/tencent/mm/kernel/g:aAh	()Lcom/tencent/mm/kernel/e;
    //   173: getfield 102	com/tencent/mm/kernel/e:hqK	Lcom/tencent/mm/storagebase/h;
    //   176: invokestatic 108	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   179: invokevirtual 112	java/lang/Thread:getId	()J
    //   182: invokevirtual 118	com/tencent/mm/storagebase/h:beginTransaction	(J)J
    //   185: lstore 6
    //   187: iload_2
    //   188: ifne +24 -> 212
    //   191: ldc 120
    //   193: ldc 122
    //   195: invokestatic 127	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   198: aload_0
    //   199: getfield 36	com/tencent/mm/storage/bz:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   202: ldc 45
    //   204: ldc 129
    //   206: invokeinterface 133 3 0
    //   211: pop
    //   212: iload_3
    //   213: ifne +24 -> 237
    //   216: ldc 120
    //   218: ldc 135
    //   220: invokestatic 127	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   223: aload_0
    //   224: getfield 36	com/tencent/mm/storage/bz:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   227: ldc 45
    //   229: ldc 137
    //   231: invokeinterface 133 3 0
    //   236: pop
    //   237: iload 4
    //   239: ifne +24 -> 263
    //   242: ldc 120
    //   244: ldc 139
    //   246: invokestatic 127	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   249: aload_0
    //   250: getfield 36	com/tencent/mm/storage/bz:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   253: ldc 45
    //   255: ldc 141
    //   257: invokeinterface 133 3 0
    //   262: pop
    //   263: lload 6
    //   265: lconst_0
    //   266: lcmp
    //   267: ifle +15 -> 282
    //   270: invokestatic 96	com/tencent/mm/kernel/g:aAh	()Lcom/tencent/mm/kernel/e;
    //   273: getfield 102	com/tencent/mm/kernel/e:hqK	Lcom/tencent/mm/storagebase/h;
    //   276: lload 6
    //   278: invokevirtual 145	com/tencent/mm/storagebase/h:endTransaction	(J)I
    //   281: pop
    //   282: lconst_0
    //   283: lstore 8
    //   285: aload_0
    //   286: getfield 36	com/tencent/mm/storage/bz:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   289: ldc 147
    //   291: ldc 45
    //   293: invokestatic 151	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   296: invokevirtual 155	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   299: aconst_null
    //   300: iconst_2
    //   301: invokeinterface 61 4 0
    //   306: astore 10
    //   308: aload 10
    //   310: astore 11
    //   312: aload 10
    //   314: invokeinterface 158 1 0
    //   319: ifeq +326 -> 645
    //   322: aload 10
    //   324: astore 11
    //   326: aload 10
    //   328: iconst_0
    //   329: invokeinterface 162 2 0
    //   334: istore_2
    //   335: aload 10
    //   337: astore 11
    //   339: aload 10
    //   341: invokeinterface 90 1 0
    //   346: iload_2
    //   347: istore_3
    //   348: lload 8
    //   350: lstore 6
    //   352: iload_2
    //   353: sipush 5000
    //   356: if_icmplt +23 -> 379
    //   359: aload_0
    //   360: getfield 36	com/tencent/mm/storage/bz:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   363: ldc 45
    //   365: aconst_null
    //   366: aconst_null
    //   367: invokeinterface 166 4 0
    //   372: istore_3
    //   373: iload_3
    //   374: i2l
    //   375: lstore 6
    //   377: iload_2
    //   378: istore_3
    //   379: ldc 120
    //   381: ldc 168
    //   383: iconst_3
    //   384: anewarray 170	java/lang/Object
    //   387: dup
    //   388: iconst_0
    //   389: iload_3
    //   390: invokestatic 175	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   393: aastore
    //   394: dup
    //   395: iconst_1
    //   396: sipush 5000
    //   399: invokestatic 175	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   402: aastore
    //   403: dup
    //   404: iconst_2
    //   405: lload 6
    //   407: invokestatic 180	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   410: aastore
    //   411: invokestatic 183	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   414: ldc 28
    //   416: invokestatic 186	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   419: return
    //   420: astore 11
    //   422: aconst_null
    //   423: astore 10
    //   425: aload 10
    //   427: astore_1
    //   428: ldc 120
    //   430: aload 11
    //   432: ldc 188
    //   434: iconst_0
    //   435: anewarray 170	java/lang/Object
    //   438: invokestatic 192	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   441: aload 10
    //   443: astore_1
    //   444: ldc 120
    //   446: new 38	java/lang/StringBuilder
    //   449: dup
    //   450: ldc 194
    //   452: invokespecial 43	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   455: aload 11
    //   457: invokevirtual 195	java/lang/Exception:toString	()Ljava/lang/String;
    //   460: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   463: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   466: invokestatic 198	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   469: aload 10
    //   471: ifnull -189 -> 282
    //   474: aload 10
    //   476: invokeinterface 90 1 0
    //   481: goto -199 -> 282
    //   484: astore_1
    //   485: aload 11
    //   487: astore 10
    //   489: aload 10
    //   491: ifnull +10 -> 501
    //   494: aload 10
    //   496: invokeinterface 90 1 0
    //   501: ldc 28
    //   503: invokestatic 186	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   506: aload_1
    //   507: athrow
    //   508: astore_1
    //   509: iconst_0
    //   510: istore_2
    //   511: aconst_null
    //   512: astore 10
    //   514: aload 10
    //   516: astore 11
    //   518: ldc 120
    //   520: aload_1
    //   521: ldc 188
    //   523: iconst_0
    //   524: anewarray 170	java/lang/Object
    //   527: invokestatic 192	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   530: aload 10
    //   532: astore 11
    //   534: ldc 120
    //   536: new 38	java/lang/StringBuilder
    //   539: dup
    //   540: ldc 200
    //   542: invokespecial 43	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   545: aload_1
    //   546: invokevirtual 195	java/lang/Exception:toString	()Ljava/lang/String;
    //   549: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   552: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   555: invokestatic 198	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   558: iload_2
    //   559: istore_3
    //   560: lload 8
    //   562: lstore 6
    //   564: aload 10
    //   566: ifnull -187 -> 379
    //   569: aload 10
    //   571: invokeinterface 90 1 0
    //   576: iload_2
    //   577: istore_3
    //   578: lload 8
    //   580: lstore 6
    //   582: goto -203 -> 379
    //   585: astore_1
    //   586: aconst_null
    //   587: astore 11
    //   589: aload 11
    //   591: ifnull +10 -> 601
    //   594: aload 11
    //   596: invokeinterface 90 1 0
    //   601: ldc 28
    //   603: invokestatic 186	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   606: aload_1
    //   607: athrow
    //   608: astore_1
    //   609: goto -20 -> 589
    //   612: astore_1
    //   613: iconst_0
    //   614: istore_2
    //   615: goto -101 -> 514
    //   618: astore_1
    //   619: goto -105 -> 514
    //   622: astore_1
    //   623: aconst_null
    //   624: astore 10
    //   626: goto -112 -> 514
    //   629: astore 11
    //   631: aload_1
    //   632: astore 10
    //   634: aload 11
    //   636: astore_1
    //   637: goto -148 -> 489
    //   640: astore 11
    //   642: goto -217 -> 425
    //   645: iconst_0
    //   646: istore_2
    //   647: goto -312 -> 335
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	650	0	this	bz
    //   0	650	1	paramh	com.tencent.mm.storagebase.h
    //   72	575	2	i	int
    //   70	508	3	j	int
    //   67	171	4	k	int
    //   64	33	5	m	int
    //   185	396	6	l1	long
    //   283	296	8	l2	long
    //   50	583	10	localObject1	Object
    //   1	337	11	localObject2	Object
    //   420	66	11	localException1	Exception
    //   516	79	11	localObject3	Object
    //   629	6	11	localObject4	Object
    //   640	1	11	localException2	Exception
    //   103	44	12	str	String
    // Exception table:
    //   from	to	target	type
    //   17	52	420	java/lang/Exception
    //   170	187	420	java/lang/Exception
    //   191	212	420	java/lang/Exception
    //   216	237	420	java/lang/Exception
    //   242	263	420	java/lang/Exception
    //   270	282	420	java/lang/Exception
    //   17	52	484	finally
    //   170	187	484	finally
    //   191	212	484	finally
    //   216	237	484	finally
    //   242	263	484	finally
    //   270	282	484	finally
    //   285	308	508	java/lang/Exception
    //   285	308	585	finally
    //   359	373	585	finally
    //   312	322	608	finally
    //   326	335	608	finally
    //   339	346	608	finally
    //   518	530	608	finally
    //   534	558	608	finally
    //   312	322	612	java/lang/Exception
    //   326	335	612	java/lang/Exception
    //   339	346	618	java/lang/Exception
    //   359	373	622	java/lang/Exception
    //   55	66	629	finally
    //   76	86	629	finally
    //   94	105	629	finally
    //   108	118	629	finally
    //   126	136	629	finally
    //   144	154	629	finally
    //   163	170	629	finally
    //   428	441	629	finally
    //   444	469	629	finally
    //   55	66	640	java/lang/Exception
    //   76	86	640	java/lang/Exception
    //   94	105	640	java/lang/Exception
    //   108	118	640	java/lang/Exception
    //   126	136	640	java/lang/Exception
    //   144	154	640	java/lang/Exception
    //   163	170	640	java/lang/Exception
  }
  
  public final boolean P(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(152801);
    if (Util.isNullOrNil(paramString2))
    {
      Log.e("MicroMsg.MediaCheckDuplicationStorage", "insert path is null");
      AppMethodBeat.o(152801);
      return false;
    }
    long l1 = paramInt;
    if (paramInt <= 0)
    {
      l2 = (int)s.boW(paramString2);
      l1 = l2;
      if (l2 <= 0L)
      {
        Log.e("MicroMsg.MediaCheckDuplicationStorage", "insert path insize:%d size:%d  path:%s", new Object[] { Integer.valueOf(paramInt), Long.valueOf(l2), paramString2 });
        AppMethodBeat.o(152801);
        return false;
      }
    }
    String str = paramString1;
    if (Util.isNullOrNil(paramString1))
    {
      paramString1 = s.bhK(paramString2);
      str = paramString1;
      if (Util.isNullOrNil(paramString1))
      {
        Log.e("MicroMsg.MediaCheckDuplicationStorage", "insert path read md5 failed  path:%s", new Object[] { paramString2 });
        AppMethodBeat.o(152801);
        return false;
      }
    }
    paramString1 = new ContentValues();
    paramString1.put("md5", str);
    paramString1.put("size", Long.valueOf(l1));
    paramString1.put("path", paramString2);
    paramString1.put("createtime", Long.valueOf(Util.nowMilliSecond()));
    paramString1.put("status", Integer.valueOf(101));
    long l2 = this.db.insert("MediaDuplication", "", paramString1);
    Log.i("MicroMsg.MediaCheckDuplicationStorage", "insert Ret:%d size:%d md5:%s path:%s", new Object[] { Long.valueOf(l2), Long.valueOf(l1), str, paramString2 });
    if (l2 > 0L)
    {
      AppMethodBeat.o(152801);
      return true;
    }
    AppMethodBeat.o(152801);
    return false;
  }
  
  public final boolean a(String paramString, PString paramPString, PInt paramPInt)
  {
    AppMethodBeat.i(152804);
    if (Util.isNullOrNil(paramString))
    {
      Log.d("MicroMsg.MediaCheckDuplicationStorage", "check video remuxing, but import path is null.");
      AppMethodBeat.o(152804);
      return false;
    }
    int i = (int)s.boW(paramString);
    if (i <= 0)
    {
      Log.w("MicroMsg.MediaCheckDuplicationStorage", "check video remuxing, but file size is zero. path : ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(152804);
      return false;
    }
    String str = s.bhK(paramString);
    if (Util.isNullOrNil(str))
    {
      Log.w("MicroMsg.MediaCheckDuplicationStorage", "check video remuxing, but md5 is null. path : ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(152804);
      return false;
    }
    Object localObject2 = "select remuxing, duration from MediaDuplication  where md5 = '" + str + "' AND  size = " + i + " AND status = 100";
    long l = Util.currentTicks();
    Object localObject1 = null;
    paramString = null;
    try
    {
      localObject2 = this.db.rawQuery((String)localObject2, null, 2);
      if (localObject2 != null)
      {
        paramString = (String)localObject2;
        localObject1 = localObject2;
        if (((Cursor)localObject2).moveToFirst())
        {
          paramString = (String)localObject2;
          localObject1 = localObject2;
          paramPString.value = ((Cursor)localObject2).getString(0);
          paramString = (String)localObject2;
          localObject1 = localObject2;
          paramPInt.value = ((Cursor)localObject2).getInt(1);
        }
      }
      if (localObject2 != null) {
        ((Cursor)localObject2).close();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localObject1 = paramString;
        Log.printErrStackTrace("MicroMsg.MediaCheckDuplicationStorage", localException, "", new Object[0]);
        localObject1 = paramString;
        Log.e("MicroMsg.MediaCheckDuplicationStorage", "check video remuxing error: " + localException.toString());
        if (paramString != null) {
          paramString.close();
        }
      }
    }
    finally
    {
      if (localObject1 == null) {
        break label334;
      }
      ((Cursor)localObject1).close();
      AppMethodBeat.o(152804);
    }
    if (Util.isNullOrNil(paramPString.value))
    {
      Log.d("MicroMsg.MediaCheckDuplicationStorage", "it has no remuxing path.");
      AppMethodBeat.o(152804);
      return false;
    }
    label334:
    if ((int)s.boW(paramPString.value) <= 0)
    {
      Log.w("MicroMsg.MediaCheckDuplicationStorage", "remuxing file size is zero, delete db record now. remuxing path : " + paramPString.value);
      this.db.delete("MediaDuplication", "md5=? AND size=? AND status=?", new String[] { str, String.valueOf(i), "100" });
      paramPString.value = null;
      AppMethodBeat.o(152804);
      return false;
    }
    Log.i("MicroMsg.MediaCheckDuplicationStorage", "check remuxing file success. remuxing path[%s], duration [%d], cost time[%d]", new Object[] { paramPString.value, Integer.valueOf(paramPInt.value), Long.valueOf(Util.ticksToNow(l)) });
    AppMethodBeat.o(152804);
    return true;
  }
  
  public final boolean ar(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(152803);
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)))
    {
      Log.w("MicroMsg.MediaCheckDuplicationStorage", "insert video remuxing info, but path is null. [%s, %s] ", new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(152803);
      return false;
    }
    int i = (int)s.boW(paramString1);
    int j = (int)s.boW(paramString2);
    if ((i <= 0) || (j <= 0))
    {
      Log.w("MicroMsg.MediaCheckDuplicationStorage", "insert video remuxing info, but file size is zero.[%d, %d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      AppMethodBeat.o(152803);
      return false;
    }
    String str = s.bhK(paramString1);
    if (Util.isNullOrNil(str))
    {
      Log.w("MicroMsg.MediaCheckDuplicationStorage", "import file is not null, but md5 is null, path " + paramString1 + " size : " + i);
      AppMethodBeat.o(152803);
      return false;
    }
    long l1 = Util.currentTicks();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("md5", str);
    localContentValues.put("size", Integer.valueOf(i));
    localContentValues.put("createtime", Long.valueOf(Util.nowMilliSecond()));
    localContentValues.put("remuxing", paramString2);
    localContentValues.put("duration", Integer.valueOf(paramInt));
    localContentValues.put("status", Integer.valueOf(100));
    long l2 = this.db.insert("MediaDuplication", "", localContentValues);
    Log.i("MicroMsg.MediaCheckDuplicationStorage", "insert video remuxing ret[%d], size[%d], md5[%s], remuxingPath[%s], importPath[%s], duration[%d], cost time[%d]", new Object[] { Long.valueOf(l2), Integer.valueOf(i), str, paramString2, paramString1, Integer.valueOf(paramInt), Long.valueOf(Util.ticksToNow(l1)) });
    if (l2 > 0L)
    {
      AppMethodBeat.o(152803);
      return true;
    }
    AppMethodBeat.o(152803);
    return false;
  }
  
  public final String gS(String paramString, int paramInt)
  {
    AppMethodBeat.i(152802);
    if ((Util.isNullOrNil(paramString)) || (paramInt <= 0))
    {
      Log.e("MicroMsg.MediaCheckDuplicationStorage", "check  md5:%s size:%d", new Object[] { paramString, Integer.valueOf(paramInt) });
      AppMethodBeat.o(152802);
      return "";
    }
    String str = "select path from MediaDuplication where md5 = '" + paramString + "' and  size = " + paramInt + " and status != 100";
    Object localObject = this.db.rawQuery(str, null, 2);
    if (localObject == null)
    {
      Log.e("MicroMsg.MediaCheckDuplicationStorage", "check query return null sql:%s", new Object[] { str });
      AppMethodBeat.o(152802);
      return null;
    }
    str = "";
    if (((Cursor)localObject).moveToNext()) {
      str = ((Cursor)localObject).getString(0);
    }
    ((Cursor)localObject).close();
    localObject = str;
    if (!Util.isNullOrNil(str))
    {
      int i = (int)s.boW(str);
      localObject = str;
      if (i <= 0)
      {
        Log.w("MicroMsg.MediaCheckDuplicationStorage", "check file size is zero, delete db record now. path[%s], fileSize[%d], size[%d]", new Object[] { str, Integer.valueOf(i), Integer.valueOf(paramInt) });
        this.db.delete("MediaDuplication", "md5=? AND size=? AND status!=?", new String[] { paramString, String.valueOf(paramInt), "100" });
        localObject = "";
      }
    }
    AppMethodBeat.o(152802);
    return localObject;
  }
  
  public final boolean shouldProcessEvent()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.storage.bz
 * JD-Core Version:    0.7.0.1
 */