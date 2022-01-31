package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.a.g;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class bh
  extends m
{
  public static final String[] dXp = { "CREATE TABLE IF NOT EXISTS  MediaDuplication  (md5 text , size int , path text , createtime long, remuxing text, duration int, status int);", "DROP INDEX IF EXISTS MediaDuplicationMD5Index ", "CREATE INDEX IF NOT EXISTS MD5Index ON MediaDuplication ( md5 )" };
  public com.tencent.mm.sdk.e.e dXw;
  
  /* Error */
  public bh(com.tencent.mm.cf.h paramh)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 11
    //   3: aload_0
    //   4: invokespecial 27	com/tencent/mm/sdk/e/m:<init>	()V
    //   7: aload_0
    //   8: aload_1
    //   9: putfield 29	com/tencent/mm/storage/bh:dXw	Lcom/tencent/mm/sdk/e/e;
    //   12: aload_0
    //   13: getfield 29	com/tencent/mm/storage/bh:dXw	Lcom/tencent/mm/sdk/e/e;
    //   16: new 31	java/lang/StringBuilder
    //   19: dup
    //   20: ldc 33
    //   22: invokespecial 36	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   25: ldc 38
    //   27: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: ldc 44
    //   32: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: aconst_null
    //   39: iconst_2
    //   40: invokeinterface 54 4 0
    //   45: astore 10
    //   47: aload 10
    //   49: astore_1
    //   50: aload 10
    //   52: ldc 56
    //   54: invokeinterface 62 2 0
    //   59: istore 5
    //   61: iconst_0
    //   62: istore 4
    //   64: iconst_0
    //   65: istore_3
    //   66: iconst_0
    //   67: istore_2
    //   68: aload 10
    //   70: astore_1
    //   71: aload 10
    //   73: invokeinterface 66 1 0
    //   78: ifeq +77 -> 155
    //   81: iload 5
    //   83: iflt -15 -> 68
    //   86: aload 10
    //   88: astore_1
    //   89: aload 10
    //   91: iload 5
    //   93: invokeinterface 70 2 0
    //   98: astore 12
    //   100: aload 10
    //   102: astore_1
    //   103: ldc 72
    //   105: aload 12
    //   107: invokevirtual 76	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   110: ifeq +8 -> 118
    //   113: iconst_1
    //   114: istore_2
    //   115: goto -47 -> 68
    //   118: aload 10
    //   120: astore_1
    //   121: ldc 78
    //   123: aload 12
    //   125: invokevirtual 76	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   128: ifeq +8 -> 136
    //   131: iconst_1
    //   132: istore_3
    //   133: goto -65 -> 68
    //   136: aload 10
    //   138: astore_1
    //   139: ldc 80
    //   141: aload 12
    //   143: invokevirtual 76	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   146: ifeq -78 -> 68
    //   149: iconst_1
    //   150: istore 4
    //   152: goto -84 -> 68
    //   155: aload 10
    //   157: astore_1
    //   158: aload 10
    //   160: invokeinterface 83 1 0
    //   165: invokestatic 89	com/tencent/mm/kernel/g:DP	()Lcom/tencent/mm/kernel/e;
    //   168: getfield 95	com/tencent/mm/kernel/e:dKu	Lcom/tencent/mm/cf/h;
    //   171: invokestatic 101	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   174: invokevirtual 105	java/lang/Thread:getId	()J
    //   177: invokevirtual 111	com/tencent/mm/cf/h:eV	(J)J
    //   180: lstore 6
    //   182: iload_2
    //   183: ifne +24 -> 207
    //   186: ldc 113
    //   188: ldc 115
    //   190: invokestatic 121	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   193: aload_0
    //   194: getfield 29	com/tencent/mm/storage/bh:dXw	Lcom/tencent/mm/sdk/e/e;
    //   197: ldc 38
    //   199: ldc 123
    //   201: invokeinterface 127 3 0
    //   206: pop
    //   207: iload_3
    //   208: ifne +24 -> 232
    //   211: ldc 113
    //   213: ldc 129
    //   215: invokestatic 121	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   218: aload_0
    //   219: getfield 29	com/tencent/mm/storage/bh:dXw	Lcom/tencent/mm/sdk/e/e;
    //   222: ldc 38
    //   224: ldc 131
    //   226: invokeinterface 127 3 0
    //   231: pop
    //   232: iload 4
    //   234: ifne +24 -> 258
    //   237: ldc 113
    //   239: ldc 133
    //   241: invokestatic 121	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   244: aload_0
    //   245: getfield 29	com/tencent/mm/storage/bh:dXw	Lcom/tencent/mm/sdk/e/e;
    //   248: ldc 38
    //   250: ldc 135
    //   252: invokeinterface 127 3 0
    //   257: pop
    //   258: lload 6
    //   260: lconst_0
    //   261: lcmp
    //   262: ifle +15 -> 277
    //   265: invokestatic 89	com/tencent/mm/kernel/g:DP	()Lcom/tencent/mm/kernel/e;
    //   268: getfield 95	com/tencent/mm/kernel/e:dKu	Lcom/tencent/mm/cf/h;
    //   271: lload 6
    //   273: invokevirtual 139	com/tencent/mm/cf/h:hI	(J)I
    //   276: pop
    //   277: lconst_0
    //   278: lstore 8
    //   280: aload_0
    //   281: getfield 29	com/tencent/mm/storage/bh:dXw	Lcom/tencent/mm/sdk/e/e;
    //   284: new 31	java/lang/StringBuilder
    //   287: dup
    //   288: ldc 141
    //   290: invokespecial 36	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   293: ldc 38
    //   295: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   301: aconst_null
    //   302: iconst_2
    //   303: invokeinterface 54 4 0
    //   308: astore 10
    //   310: aload 10
    //   312: astore 11
    //   314: aload 10
    //   316: invokeinterface 144 1 0
    //   321: ifeq +311 -> 632
    //   324: aload 10
    //   326: astore 11
    //   328: aload 10
    //   330: iconst_0
    //   331: invokeinterface 148 2 0
    //   336: istore_2
    //   337: aload 10
    //   339: astore 11
    //   341: aload 10
    //   343: invokeinterface 83 1 0
    //   348: iload_2
    //   349: istore_3
    //   350: lload 8
    //   352: lstore 6
    //   354: iload_2
    //   355: sipush 5000
    //   358: if_icmplt +23 -> 381
    //   361: aload_0
    //   362: getfield 29	com/tencent/mm/storage/bh:dXw	Lcom/tencent/mm/sdk/e/e;
    //   365: ldc 38
    //   367: aconst_null
    //   368: aconst_null
    //   369: invokeinterface 152 4 0
    //   374: istore_3
    //   375: iload_3
    //   376: i2l
    //   377: lstore 6
    //   379: iload_2
    //   380: istore_3
    //   381: ldc 113
    //   383: ldc 154
    //   385: iconst_3
    //   386: anewarray 156	java/lang/Object
    //   389: dup
    //   390: iconst_0
    //   391: iload_3
    //   392: invokestatic 162	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   395: aastore
    //   396: dup
    //   397: iconst_1
    //   398: sipush 5000
    //   401: invokestatic 162	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   404: aastore
    //   405: dup
    //   406: iconst_2
    //   407: lload 6
    //   409: invokestatic 167	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   412: aastore
    //   413: invokestatic 170	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   416: return
    //   417: astore 11
    //   419: aconst_null
    //   420: astore 10
    //   422: aload 10
    //   424: astore_1
    //   425: ldc 113
    //   427: aload 11
    //   429: ldc 172
    //   431: iconst_0
    //   432: anewarray 156	java/lang/Object
    //   435: invokestatic 176	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   438: aload 10
    //   440: astore_1
    //   441: ldc 113
    //   443: new 31	java/lang/StringBuilder
    //   446: dup
    //   447: ldc 178
    //   449: invokespecial 36	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   452: aload 11
    //   454: invokevirtual 179	java/lang/Exception:toString	()Ljava/lang/String;
    //   457: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   460: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   463: invokestatic 182	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   466: aload 10
    //   468: ifnull -191 -> 277
    //   471: aload 10
    //   473: invokeinterface 83 1 0
    //   478: goto -201 -> 277
    //   481: astore_1
    //   482: aload 11
    //   484: astore 10
    //   486: aload 10
    //   488: ifnull +10 -> 498
    //   491: aload 10
    //   493: invokeinterface 83 1 0
    //   498: aload_1
    //   499: athrow
    //   500: astore_1
    //   501: iconst_0
    //   502: istore_2
    //   503: aconst_null
    //   504: astore 10
    //   506: aload 10
    //   508: astore 11
    //   510: ldc 113
    //   512: aload_1
    //   513: ldc 172
    //   515: iconst_0
    //   516: anewarray 156	java/lang/Object
    //   519: invokestatic 176	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   522: aload 10
    //   524: astore 11
    //   526: ldc 113
    //   528: new 31	java/lang/StringBuilder
    //   531: dup
    //   532: ldc 184
    //   534: invokespecial 36	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   537: aload_1
    //   538: invokevirtual 179	java/lang/Exception:toString	()Ljava/lang/String;
    //   541: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   544: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   547: invokestatic 182	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   550: iload_2
    //   551: istore_3
    //   552: lload 8
    //   554: lstore 6
    //   556: aload 10
    //   558: ifnull -177 -> 381
    //   561: aload 10
    //   563: invokeinterface 83 1 0
    //   568: iload_2
    //   569: istore_3
    //   570: lload 8
    //   572: lstore 6
    //   574: goto -193 -> 381
    //   577: astore_1
    //   578: aconst_null
    //   579: astore 11
    //   581: aload 11
    //   583: ifnull +10 -> 593
    //   586: aload 11
    //   588: invokeinterface 83 1 0
    //   593: aload_1
    //   594: athrow
    //   595: astore_1
    //   596: goto -15 -> 581
    //   599: astore_1
    //   600: iconst_0
    //   601: istore_2
    //   602: goto -96 -> 506
    //   605: astore_1
    //   606: goto -100 -> 506
    //   609: astore_1
    //   610: aconst_null
    //   611: astore 10
    //   613: goto -107 -> 506
    //   616: astore 11
    //   618: aload_1
    //   619: astore 10
    //   621: aload 11
    //   623: astore_1
    //   624: goto -138 -> 486
    //   627: astore 11
    //   629: goto -207 -> 422
    //   632: iconst_0
    //   633: istore_2
    //   634: goto -297 -> 337
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	637	0	this	bh
    //   0	637	1	paramh	com.tencent.mm.cf.h
    //   67	567	2	i	int
    //   65	505	3	j	int
    //   62	171	4	k	int
    //   59	33	5	m	int
    //   180	393	6	l1	long
    //   278	293	8	l2	long
    //   45	575	10	localObject1	Object
    //   1	339	11	localObject2	Object
    //   417	66	11	localException1	Exception
    //   508	79	11	localObject3	Object
    //   616	6	11	localObject4	Object
    //   627	1	11	localException2	Exception
    //   98	44	12	str	String
    // Exception table:
    //   from	to	target	type
    //   12	47	417	java/lang/Exception
    //   165	182	417	java/lang/Exception
    //   186	207	417	java/lang/Exception
    //   211	232	417	java/lang/Exception
    //   237	258	417	java/lang/Exception
    //   265	277	417	java/lang/Exception
    //   12	47	481	finally
    //   165	182	481	finally
    //   186	207	481	finally
    //   211	232	481	finally
    //   237	258	481	finally
    //   265	277	481	finally
    //   280	310	500	java/lang/Exception
    //   280	310	577	finally
    //   361	375	577	finally
    //   314	324	595	finally
    //   328	337	595	finally
    //   341	348	595	finally
    //   510	522	595	finally
    //   526	550	595	finally
    //   314	324	599	java/lang/Exception
    //   328	337	599	java/lang/Exception
    //   341	348	605	java/lang/Exception
    //   361	375	609	java/lang/Exception
    //   50	61	616	finally
    //   71	81	616	finally
    //   89	100	616	finally
    //   103	113	616	finally
    //   121	131	616	finally
    //   139	149	616	finally
    //   158	165	616	finally
    //   425	438	616	finally
    //   441	466	616	finally
    //   50	61	627	java/lang/Exception
    //   71	81	627	java/lang/Exception
    //   89	100	627	java/lang/Exception
    //   103	113	627	java/lang/Exception
    //   121	131	627	java/lang/Exception
    //   139	149	627	java/lang/Exception
    //   158	165	627	java/lang/Exception
  }
  
  public final boolean A(String paramString1, int paramInt, String paramString2)
  {
    if (bk.bl(paramString2))
    {
      y.e("MicroMsg.MediaCheckDuplicationStorage", "insert path is null");
      return false;
    }
    int i = paramInt;
    if (paramInt <= 0)
    {
      i = com.tencent.mm.a.e.bJ(paramString2);
      if (i <= 0)
      {
        y.e("MicroMsg.MediaCheckDuplicationStorage", "insert path insize:%d size:%d  path:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramString2 });
        return false;
      }
    }
    String str = paramString1;
    if (bk.bl(paramString1))
    {
      paramString1 = g.bQ(paramString2);
      str = paramString1;
      if (bk.bl(paramString1))
      {
        y.e("MicroMsg.MediaCheckDuplicationStorage", "insert path read md5 failed  path:%s", new Object[] { paramString2 });
        return false;
      }
    }
    paramString1 = new ContentValues();
    paramString1.put("md5", str);
    paramString1.put("size", Integer.valueOf(i));
    paramString1.put("path", paramString2);
    paramString1.put("createtime", Long.valueOf(bk.UY()));
    paramString1.put("status", Integer.valueOf(101));
    long l = this.dXw.insert("MediaDuplication", "", paramString1);
    y.i("MicroMsg.MediaCheckDuplicationStorage", "insert Ret:%d size:%d md5:%s path:%s", new Object[] { Long.valueOf(l), Integer.valueOf(i), str, paramString2 });
    return l > 0L;
  }
  
  public final boolean L(String paramString1, String paramString2, int paramInt)
  {
    if ((bk.bl(paramString1)) || (bk.bl(paramString2)))
    {
      y.w("MicroMsg.MediaCheckDuplicationStorage", "insert video remuxing info, but path is null. [%s, %s] ", new Object[] { paramString1, paramString2 });
      return false;
    }
    int i = com.tencent.mm.a.e.bJ(paramString1);
    int j = com.tencent.mm.a.e.bJ(paramString2);
    if ((i <= 0) || (j <= 0))
    {
      y.w("MicroMsg.MediaCheckDuplicationStorage", "insert video remuxing info, but file size is zero.[%d, %d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      return false;
    }
    String str = g.bQ(paramString1);
    if (bk.bl(str))
    {
      y.w("MicroMsg.MediaCheckDuplicationStorage", "import file is not null, but md5 is null, path " + paramString1 + " size : " + i);
      return false;
    }
    long l1 = bk.UZ();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("md5", str);
    localContentValues.put("size", Integer.valueOf(i));
    localContentValues.put("createtime", Long.valueOf(bk.UY()));
    localContentValues.put("remuxing", paramString2);
    localContentValues.put("duration", Integer.valueOf(paramInt));
    localContentValues.put("status", Integer.valueOf(100));
    long l2 = this.dXw.insert("MediaDuplication", "", localContentValues);
    y.i("MicroMsg.MediaCheckDuplicationStorage", "insert video remuxing ret[%d], size[%d], md5[%s], remuxingPath[%s], importPath[%s], duration[%d], cost time[%d]", new Object[] { Long.valueOf(l2), Integer.valueOf(i), str, paramString2, paramString1, Integer.valueOf(paramInt), Long.valueOf(bk.cp(l1)) });
    return l2 > 0L;
  }
  
  protected final boolean WH()
  {
    return false;
  }
  
  public final boolean a(String paramString, PString paramPString, PInt paramPInt)
  {
    if (bk.bl(paramString))
    {
      y.d("MicroMsg.MediaCheckDuplicationStorage", "check video remuxing, but import path is null.");
      return false;
    }
    int i = com.tencent.mm.a.e.bJ(paramString);
    if (i <= 0)
    {
      y.w("MicroMsg.MediaCheckDuplicationStorage", "check video remuxing, but file size is zero. path : " + paramString);
      return false;
    }
    String str = g.bQ(paramString);
    if (bk.bl(str))
    {
      y.w("MicroMsg.MediaCheckDuplicationStorage", "check video remuxing, but md5 is null. path : " + paramString);
      return false;
    }
    Object localObject2 = "select remuxing, duration from MediaDuplication  where md5 = '" + str + "' AND  size = " + i + " AND status = 100";
    long l = bk.UZ();
    Object localObject1 = null;
    paramString = null;
    try
    {
      localObject2 = this.dXw.a((String)localObject2, null, 2);
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
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localObject1 = paramString;
        y.printErrStackTrace("MicroMsg.MediaCheckDuplicationStorage", localException, "", new Object[0]);
        localObject1 = paramString;
        y.e("MicroMsg.MediaCheckDuplicationStorage", "check video remuxing error: " + localException.toString());
        if (paramString != null) {
          paramString.close();
        }
      }
    }
    finally
    {
      if (localObject1 == null) {
        break label317;
      }
      ((Cursor)localObject1).close();
    }
    if (bk.bl(paramPString.value))
    {
      y.d("MicroMsg.MediaCheckDuplicationStorage", "it has no remuxing path.");
      return false;
    }
    label317:
    if (com.tencent.mm.a.e.bJ(paramPString.value) <= 0)
    {
      y.w("MicroMsg.MediaCheckDuplicationStorage", "remuxing file size is zero, delete db record now. remuxing path : " + paramPString.value);
      this.dXw.delete("MediaDuplication", "md5=? AND size=? AND status=?", new String[] { str, String.valueOf(i), "100" });
      paramPString.value = null;
      return false;
    }
    y.i("MicroMsg.MediaCheckDuplicationStorage", "check remuxing file success. remuxing path[%s], duration [%d], cost time[%d]", new Object[] { paramPString.value, Integer.valueOf(paramPInt.value), Long.valueOf(bk.cp(l)) });
    return true;
  }
  
  public final String dx(String paramString, int paramInt)
  {
    Object localObject;
    if ((bk.bl(paramString)) || (paramInt <= 0))
    {
      y.e("MicroMsg.MediaCheckDuplicationStorage", "check  md5:%s size:%d", new Object[] { paramString, Integer.valueOf(paramInt) });
      localObject = "";
    }
    String str;
    int i;
    do
    {
      do
      {
        return localObject;
        str = "select path from MediaDuplication where md5 = '" + paramString + "' and  size = " + paramInt + " and status != 100";
        localObject = this.dXw.a(str, null, 2);
        if (localObject == null)
        {
          y.e("MicroMsg.MediaCheckDuplicationStorage", "check query return null sql:%s", new Object[] { str });
          return null;
        }
        str = "";
        if (((Cursor)localObject).moveToNext()) {
          str = ((Cursor)localObject).getString(0);
        }
        ((Cursor)localObject).close();
        localObject = str;
      } while (bk.bl(str));
      i = com.tencent.mm.a.e.bJ(str);
      localObject = str;
    } while (i > 0);
    y.w("MicroMsg.MediaCheckDuplicationStorage", "check file size is zero, delete db record now. path[%s], fileSize[%d], size[%d]", new Object[] { str, Integer.valueOf(i), Integer.valueOf(paramInt) });
    this.dXw.delete("MediaDuplication", "md5=? AND size=? AND status!=?", new String[] { paramString, String.valueOf(paramInt), "100" });
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.storage.bh
 * JD-Core Version:    0.7.0.1
 */