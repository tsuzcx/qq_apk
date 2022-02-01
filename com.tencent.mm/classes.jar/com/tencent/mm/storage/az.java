package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.abv;
import com.tencent.mm.contact.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class az
  extends MAutoStorage<aw>
{
  public static final String[] SQL_CREATE;
  private HashMap<String, int[]> adif;
  public HashMap<Integer, ArrayList<String>> adig;
  private ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(32877);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(aw.info, "ContactLabel") };
    AppMethodBeat.o(32877);
  }
  
  public az(ISQLiteDatabase paramISQLiteDatabase)
  {
    this(paramISQLiteDatabase, aw.info, "ContactLabel");
  }
  
  private az(ISQLiteDatabase paramISQLiteDatabase, IAutoDBItem.MAutoDBInfo paramMAutoDBInfo, String paramString)
  {
    super(paramISQLiteDatabase, paramMAutoDBInfo, paramString, null);
    AppMethodBeat.i(32846);
    this.adif = null;
    this.adig = null;
    this.db = paramISQLiteDatabase;
    paramISQLiteDatabase.execSQL("ContactLabel", "CREATE INDEX IF NOT EXISTS  contact_label_createtime_index ON ContactLabel ( createTime )");
    AppMethodBeat.o(32846);
  }
  
  private static String R(String paramString, List<aw> paramList)
  {
    AppMethodBeat.i(32869);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(" ");
    if ((paramList != null) && (paramList.size() > 0))
    {
      int j = paramList.size();
      int i = 0;
      while (i < j)
      {
        paramString = (aw)paramList.get(i);
        if (paramString != null)
        {
          localStringBuilder.append(paramString.field_labelID);
          if (i < j - 1) {
            localStringBuilder.append(" ");
          }
        }
        i += 1;
      }
      Log.i("MicroMsg.Label.ContactLabelStorage", "cpan[genNotifyString] event:%s", new Object[] { localStringBuilder.toString() });
      paramString = localStringBuilder.toString();
      AppMethodBeat.o(32869);
      return paramString;
    }
    AppMethodBeat.o(32869);
    return null;
  }
  
  private static String a(String paramString, aw paramaw)
  {
    AppMethodBeat.i(32868);
    if (paramaw != null)
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramaw);
      paramString = R(paramString, localArrayList);
      AppMethodBeat.o(32868);
      return paramString;
    }
    AppMethodBeat.o(32868);
    return null;
  }
  
  private boolean a(boolean paramBoolean, aw paramaw)
  {
    AppMethodBeat.i(32855);
    boolean bool = super.insert(paramaw);
    if ((bool) && (paramBoolean)) {
      doNotify(a("insert", paramaw));
    }
    AppMethodBeat.o(32855);
    return bool;
  }
  
  private boolean a(boolean paramBoolean, aw paramaw, String... paramVarArgs)
  {
    AppMethodBeat.i(32857);
    boolean bool = super.delete(paramaw, paramVarArgs);
    if ((bool) && (paramBoolean))
    {
      doNotify(a("delete", paramaw));
      iZR();
    }
    bja();
    AppMethodBeat.o(32857);
    return bool;
  }
  
  private a b(aw paramaw)
  {
    AppMethodBeat.i(32866);
    localObject2 = null;
    localObject1 = null;
    Object localObject3 = paramaw.field_labelID;
    try
    {
      localObject3 = this.db.rawQuery("select * from ContactLabel where labelID=?", new String[] { localObject3 }, 2);
      if (localObject3 != null)
      {
        localObject1 = localObject3;
        localObject2 = localObject3;
        if (((Cursor)localObject3).moveToFirst())
        {
          localObject1 = localObject3;
          localObject2 = localObject3;
          String str = Util.nullAs(((Cursor)localObject3).getString(((Cursor)localObject3).getColumnIndex("labelName")), "");
          localObject1 = localObject3;
          localObject2 = localObject3;
          if (paramaw.field_labelName.equalsIgnoreCase(str))
          {
            localObject1 = localObject3;
            localObject2 = localObject3;
            paramaw = a.adii;
            if (localObject3 != null) {
              ((Cursor)localObject3).close();
            }
            AppMethodBeat.o(32866);
            return paramaw;
          }
          localObject1 = localObject3;
          localObject2 = localObject3;
          paramaw = a.adij;
          if (localObject3 != null) {
            ((Cursor)localObject3).close();
          }
          AppMethodBeat.o(32866);
          return paramaw;
        }
      }
      if (localObject3 != null) {
        ((Cursor)localObject3).close();
      }
    }
    catch (Exception paramaw)
    {
      for (;;)
      {
        localObject2 = localObject1;
        Log.w("MicroMsg.Label.ContactLabelStorage", "cpan[checkEqualsName] exception %s", new Object[] { paramaw.toString() });
        if (localObject1 != null) {
          localObject1.close();
        }
      }
    }
    finally
    {
      if (localObject2 == null) {
        break label245;
      }
      localObject2.close();
      AppMethodBeat.o(32866);
    }
    paramaw = a.adik;
    AppMethodBeat.o(32866);
    return paramaw;
  }
  
  private boolean b(boolean paramBoolean, aw paramaw, String... paramVarArgs)
  {
    AppMethodBeat.i(32859);
    boolean bool = super.update(paramaw, paramVarArgs);
    if ((bool) && (paramBoolean)) {
      doNotify(a("update", paramaw));
    }
    bja();
    AppMethodBeat.o(32859);
    return bool;
  }
  
  /* Error */
  private String c(aw paramaw)
  {
    // Byte code:
    //   0: ldc 225
    //   2: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 76	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   12: aload_1
    //   13: getfield 194	com/tencent/mm/storage/aw:field_labelName	Ljava/lang/String;
    //   16: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   22: astore_3
    //   23: aload_0
    //   24: getfield 63	com/tencent/mm/storage/az:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   27: ldc 227
    //   29: iconst_2
    //   30: anewarray 30	java/lang/String
    //   33: dup
    //   34: iconst_0
    //   35: aload_3
    //   36: aastore
    //   37: dup
    //   38: iconst_1
    //   39: ldc 229
    //   41: aastore
    //   42: iconst_2
    //   43: invokeinterface 166 4 0
    //   48: astore 4
    //   50: aload 4
    //   52: ifnull +140 -> 192
    //   55: aload 4
    //   57: astore_3
    //   58: aload 4
    //   60: invokeinterface 172 1 0
    //   65: ifeq +127 -> 192
    //   68: aload 4
    //   70: astore_3
    //   71: aload 4
    //   73: aload 4
    //   75: ldc 174
    //   77: invokeinterface 178 2 0
    //   82: invokeinterface 182 2 0
    //   87: ldc 184
    //   89: invokestatic 190	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   92: astore 5
    //   94: aload 4
    //   96: astore_3
    //   97: aload_1
    //   98: getfield 194	com/tencent/mm/storage/aw:field_labelName	Ljava/lang/String;
    //   101: aload 5
    //   103: invokevirtual 198	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   106: istore_2
    //   107: aload 4
    //   109: astore_3
    //   110: ldc 103
    //   112: ldc 231
    //   114: iconst_2
    //   115: anewarray 107	java/lang/Object
    //   118: dup
    //   119: iconst_0
    //   120: new 76	java/lang/StringBuilder
    //   123: dup
    //   124: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   127: aload_1
    //   128: getfield 194	com/tencent/mm/storage/aw:field_labelName	Ljava/lang/String;
    //   131: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: aastore
    //   138: dup
    //   139: iconst_1
    //   140: aload 5
    //   142: invokestatic 235	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   145: aastore
    //   146: invokestatic 116	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   149: iload_2
    //   150: ifeq +42 -> 192
    //   153: aload 4
    //   155: astore_3
    //   156: aload 4
    //   158: aload 4
    //   160: ldc 237
    //   162: invokeinterface 178 2 0
    //   167: invokeinterface 182 2 0
    //   172: astore_1
    //   173: aload 4
    //   175: ifnull +10 -> 185
    //   178: aload 4
    //   180: invokeinterface 205 1 0
    //   185: ldc 225
    //   187: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   190: aload_1
    //   191: areturn
    //   192: aload 4
    //   194: ifnull +10 -> 204
    //   197: aload 4
    //   199: invokeinterface 205 1 0
    //   204: ldc 225
    //   206: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   209: aconst_null
    //   210: areturn
    //   211: astore_1
    //   212: aconst_null
    //   213: astore 4
    //   215: aload 4
    //   217: astore_3
    //   218: ldc 103
    //   220: ldc 213
    //   222: iconst_1
    //   223: anewarray 107	java/lang/Object
    //   226: dup
    //   227: iconst_0
    //   228: aload_1
    //   229: invokevirtual 214	java/lang/Exception:toString	()Ljava/lang/String;
    //   232: aastore
    //   233: invokestatic 217	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   236: aload 4
    //   238: ifnull -34 -> 204
    //   241: aload 4
    //   243: invokeinterface 205 1 0
    //   248: goto -44 -> 204
    //   251: astore_1
    //   252: aconst_null
    //   253: astore_3
    //   254: aload_3
    //   255: ifnull +9 -> 264
    //   258: aload_3
    //   259: invokeinterface 205 1 0
    //   264: ldc 225
    //   266: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   269: aload_1
    //   270: athrow
    //   271: astore_1
    //   272: goto -18 -> 254
    //   275: astore_1
    //   276: goto -61 -> 215
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	279	0	this	az
    //   0	279	1	paramaw	aw
    //   106	44	2	bool	boolean
    //   22	237	3	localObject	Object
    //   48	194	4	localCursor	Cursor
    //   92	49	5	str	String
    // Exception table:
    //   from	to	target	type
    //   23	50	211	java/lang/Exception
    //   23	50	251	finally
    //   58	68	271	finally
    //   71	94	271	finally
    //   97	107	271	finally
    //   110	149	271	finally
    //   156	173	271	finally
    //   218	236	271	finally
    //   58	68	275	java/lang/Exception
    //   71	94	275	java/lang/Exception
    //   97	107	275	java/lang/Exception
    //   110	149	275	java/lang/Exception
    //   156	173	275	java/lang/Exception
  }
  
  private boolean iP(String paramString)
  {
    AppMethodBeat.i(32856);
    Log.i("MicroMsg.Label.ContactLabelStorage", "cpan[delete] labelID:%s", new Object[] { String.valueOf(paramString) });
    Log.d("MicroMsg.Label.ContactLabelStorage", "cpan[query] SQL:%s", new Object[] { "labelID =? " });
    try
    {
      i = this.db.delete("ContactLabel", "labelID =? ", new String[] { paramString });
      if (i > 0)
      {
        AppMethodBeat.o(32856);
        return true;
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.w("MicroMsg.Label.ContactLabelStorage", "cpan[delete] exception %s", new Object[] { paramString.toString() });
        int i = -1;
      }
      AppMethodBeat.o(32856);
    }
    return false;
  }
  
  private static void iZR()
  {
    AppMethodBeat.i(32870);
    Log.i("MicroMsg.Label.ContactLabelStorage", "cpan[publishUpdateSearchIndexEvent]");
    abv localabv = new abv();
    localabv.ifq.delay = 3000L;
    localabv.publish();
    AppMethodBeat.o(32870);
  }
  
  public final boolean N(List<aw> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(248685);
    if ((paramList == null) || (paramList.size() <= 0))
    {
      Log.i("MicroMsg.Label.ContactLabelStorage", "cpan[updateLabelListSort] list is null.");
      AppMethodBeat.o(248685);
      return false;
    }
    ArrayList localArrayList = new ArrayList();
    h localh = null;
    long l;
    if ((this.db instanceof h))
    {
      localh = (h)this.db;
      l = localh.beginTransaction(Thread.currentThread().getId());
      Log.i("MicroMsg.Label.ContactLabelStorage", "begin insertOrUpdateList in a transaction, ticket = %d", new Object[] { Long.valueOf(l) });
    }
    for (;;)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        aw localaw = (aw)paramList.next();
        if (localaw != null)
        {
          b(false, localaw, new String[] { "labelID" });
          localArrayList.add(localaw);
        }
      }
      if (localh != null)
      {
        localh.endTransaction(l);
        Log.i("MicroMsg.Label.ContactLabelStorage", "end insertOrUpdateList transaction");
      }
      if ((localArrayList.size() > 0) && (paramBoolean)) {
        doNotify(R("update", localArrayList));
      }
      bja();
      AppMethodBeat.o(248685);
      return false;
      l = -1L;
    }
  }
  
  /* Error */
  public final ArrayList<String> Q(String paramString, List<String> paramList)
  {
    // Byte code:
    //   0: ldc_w 334
    //   3: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 103
    //   8: ldc 243
    //   10: iconst_1
    //   11: anewarray 107	java/lang/Object
    //   14: dup
    //   15: iconst_0
    //   16: ldc_w 336
    //   19: aastore
    //   20: invokestatic 248	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   23: new 76	java/lang/StringBuilder
    //   26: dup
    //   27: ldc_w 338
    //   30: invokespecial 340	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   33: aload_1
    //   34: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: ldc_w 338
    //   40: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: astore 5
    //   48: new 76	java/lang/StringBuilder
    //   51: dup
    //   52: ldc_w 338
    //   55: invokespecial 340	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   58: aload_1
    //   59: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: ldc_w 338
    //   65: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   71: astore 6
    //   73: new 76	java/lang/StringBuilder
    //   76: dup
    //   77: ldc_w 338
    //   80: invokespecial 340	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   83: aload_1
    //   84: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: ldc_w 338
    //   90: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: astore_1
    //   97: aload_0
    //   98: getfield 63	com/tencent/mm/storage/az:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   101: ldc_w 336
    //   104: iconst_3
    //   105: anewarray 30	java/lang/String
    //   108: dup
    //   109: iconst_0
    //   110: aload 5
    //   112: aastore
    //   113: dup
    //   114: iconst_1
    //   115: aload 6
    //   117: aastore
    //   118: dup
    //   119: iconst_2
    //   120: aload_1
    //   121: aastore
    //   122: iconst_2
    //   123: invokeinterface 166 4 0
    //   128: astore 5
    //   130: aload 5
    //   132: astore_1
    //   133: aload 5
    //   135: ldc 174
    //   137: invokeinterface 178 2 0
    //   142: istore_3
    //   143: aload 5
    //   145: astore_1
    //   146: aload 5
    //   148: invokeinterface 172 1 0
    //   153: ifeq +107 -> 260
    //   156: aload 5
    //   158: astore_1
    //   159: new 122	java/util/ArrayList
    //   162: dup
    //   163: invokespecial 123	java/util/ArrayList:<init>	()V
    //   166: astore 6
    //   168: aload 5
    //   170: astore_1
    //   171: aload 5
    //   173: iload_3
    //   174: invokeinterface 182 2 0
    //   179: astore 7
    //   181: aload_2
    //   182: ifnull +29 -> 211
    //   185: aload 5
    //   187: astore_1
    //   188: aload_2
    //   189: invokeinterface 90 1 0
    //   194: ifle +17 -> 211
    //   197: aload 5
    //   199: astore_1
    //   200: aload_2
    //   201: aload 7
    //   203: invokeinterface 343 2 0
    //   208: ifne +14 -> 222
    //   211: aload 5
    //   213: astore_1
    //   214: aload 6
    //   216: aload 7
    //   218: invokevirtual 321	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   221: pop
    //   222: aload 5
    //   224: astore_1
    //   225: aload 5
    //   227: invokeinterface 346 1 0
    //   232: istore 4
    //   234: iload 4
    //   236: ifne -68 -> 168
    //   239: aload 5
    //   241: ifnull +10 -> 251
    //   244: aload 5
    //   246: invokeinterface 205 1 0
    //   251: ldc_w 334
    //   254: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   257: aload 6
    //   259: areturn
    //   260: aload 5
    //   262: ifnull +10 -> 272
    //   265: aload 5
    //   267: invokeinterface 205 1 0
    //   272: ldc_w 334
    //   275: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   278: aconst_null
    //   279: areturn
    //   280: astore_2
    //   281: aconst_null
    //   282: astore 5
    //   284: aload 5
    //   286: astore_1
    //   287: ldc 103
    //   289: ldc_w 348
    //   292: iconst_1
    //   293: anewarray 107	java/lang/Object
    //   296: dup
    //   297: iconst_0
    //   298: aload_2
    //   299: invokevirtual 214	java/lang/Exception:toString	()Ljava/lang/String;
    //   302: aastore
    //   303: invokestatic 217	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   306: aload 5
    //   308: ifnull -36 -> 272
    //   311: aload 5
    //   313: invokeinterface 205 1 0
    //   318: goto -46 -> 272
    //   321: astore_2
    //   322: aconst_null
    //   323: astore_1
    //   324: aload_1
    //   325: ifnull +9 -> 334
    //   328: aload_1
    //   329: invokeinterface 205 1 0
    //   334: ldc_w 334
    //   337: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   340: aload_2
    //   341: athrow
    //   342: astore_2
    //   343: goto -19 -> 324
    //   346: astore_2
    //   347: goto -63 -> 284
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	350	0	this	az
    //   0	350	1	paramString	String
    //   0	350	2	paramList	List<String>
    //   142	32	3	i	int
    //   232	3	4	bool	boolean
    //   46	266	5	localObject1	Object
    //   71	187	6	localObject2	Object
    //   179	38	7	str	String
    // Exception table:
    //   from	to	target	type
    //   97	130	280	java/lang/Exception
    //   97	130	321	finally
    //   133	143	342	finally
    //   146	156	342	finally
    //   159	168	342	finally
    //   171	181	342	finally
    //   188	197	342	finally
    //   200	211	342	finally
    //   214	222	342	finally
    //   225	234	342	finally
    //   287	306	342	finally
    //   133	143	346	java/lang/Exception
    //   146	156	346	java/lang/Exception
    //   159	168	346	java/lang/Exception
    //   171	181	346	java/lang/Exception
    //   188	197	346	java/lang/Exception
    //   200	211	346	java/lang/Exception
    //   214	222	346	java/lang/Exception
    //   225	234	346	java/lang/Exception
  }
  
  /* Error */
  public final ArrayList<String> Z(String[] paramArrayOfString)
  {
    // Byte code:
    //   0: ldc_w 352
    //   3: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: ifnull +8 -> 15
    //   10: aload_1
    //   11: arraylength
    //   12: ifgt +11 -> 23
    //   15: ldc_w 352
    //   18: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aconst_null
    //   22: areturn
    //   23: aload_1
    //   24: arraylength
    //   25: istore_3
    //   26: new 76	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   33: astore 4
    //   35: aload 4
    //   37: ldc_w 354
    //   40: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: pop
    //   44: aload 4
    //   46: ldc_w 356
    //   49: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: iconst_0
    //   54: istore_2
    //   55: iload_2
    //   56: iload_3
    //   57: if_icmpge +57 -> 114
    //   60: aload 4
    //   62: new 76	java/lang/StringBuilder
    //   65: dup
    //   66: ldc_w 358
    //   69: invokespecial 340	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   72: aload_1
    //   73: iload_2
    //   74: aaload
    //   75: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: ldc_w 358
    //   81: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: pop
    //   91: iload_2
    //   92: iload_3
    //   93: iconst_1
    //   94: isub
    //   95: if_icmpge +12 -> 107
    //   98: aload 4
    //   100: ldc_w 360
    //   103: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: pop
    //   107: iload_2
    //   108: iconst_1
    //   109: iadd
    //   110: istore_2
    //   111: goto -56 -> 55
    //   114: aload 4
    //   116: ldc_w 362
    //   119: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: pop
    //   123: aload 4
    //   125: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: astore_1
    //   129: ldc 103
    //   131: ldc_w 364
    //   134: iconst_1
    //   135: anewarray 107	java/lang/Object
    //   138: dup
    //   139: iconst_0
    //   140: aload_1
    //   141: aastore
    //   142: invokestatic 248	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   145: aload_0
    //   146: getfield 63	com/tencent/mm/storage/az:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   149: aload_1
    //   150: aconst_null
    //   151: iconst_2
    //   152: invokeinterface 166 4 0
    //   157: astore 4
    //   159: aload 4
    //   161: astore_1
    //   162: aload 4
    //   164: ldc 174
    //   166: invokeinterface 178 2 0
    //   171: istore_2
    //   172: aload 4
    //   174: astore_1
    //   175: aload 4
    //   177: invokeinterface 172 1 0
    //   182: ifeq +92 -> 274
    //   185: aload 4
    //   187: astore_1
    //   188: new 122	java/util/ArrayList
    //   191: dup
    //   192: invokespecial 123	java/util/ArrayList:<init>	()V
    //   195: astore 5
    //   197: aload 4
    //   199: astore_1
    //   200: aload 5
    //   202: aload 4
    //   204: iload_2
    //   205: invokeinterface 182 2 0
    //   210: invokevirtual 321	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   213: pop
    //   214: aload 4
    //   216: astore_1
    //   217: aload 4
    //   219: invokeinterface 346 1 0
    //   224: ifne -27 -> 197
    //   227: aload 4
    //   229: astore_1
    //   230: ldc 103
    //   232: ldc_w 366
    //   235: iconst_1
    //   236: anewarray 107	java/lang/Object
    //   239: dup
    //   240: iconst_0
    //   241: aload 5
    //   243: invokevirtual 328	java/util/ArrayList:size	()I
    //   246: invokestatic 371	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   249: aastore
    //   250: invokestatic 248	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   253: aload 4
    //   255: ifnull +10 -> 265
    //   258: aload 4
    //   260: invokeinterface 205 1 0
    //   265: ldc_w 352
    //   268: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   271: aload 5
    //   273: areturn
    //   274: aload 4
    //   276: ifnull +10 -> 286
    //   279: aload 4
    //   281: invokeinterface 205 1 0
    //   286: ldc_w 352
    //   289: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   292: aconst_null
    //   293: areturn
    //   294: astore 5
    //   296: aconst_null
    //   297: astore 4
    //   299: aload 4
    //   301: astore_1
    //   302: ldc 103
    //   304: ldc_w 373
    //   307: iconst_1
    //   308: anewarray 107	java/lang/Object
    //   311: dup
    //   312: iconst_0
    //   313: aload 5
    //   315: invokevirtual 214	java/lang/Exception:toString	()Ljava/lang/String;
    //   318: aastore
    //   319: invokestatic 217	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   322: aload 4
    //   324: ifnull -38 -> 286
    //   327: aload 4
    //   329: invokeinterface 205 1 0
    //   334: goto -48 -> 286
    //   337: astore 4
    //   339: aconst_null
    //   340: astore_1
    //   341: aload_1
    //   342: ifnull +9 -> 351
    //   345: aload_1
    //   346: invokeinterface 205 1 0
    //   351: ldc_w 352
    //   354: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   357: aload 4
    //   359: athrow
    //   360: astore 4
    //   362: goto -21 -> 341
    //   365: astore 5
    //   367: goto -68 -> 299
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	370	0	this	az
    //   0	370	1	paramArrayOfString	String[]
    //   54	151	2	i	int
    //   25	70	3	j	int
    //   33	295	4	localObject1	Object
    //   337	21	4	localObject2	Object
    //   360	1	4	localObject3	Object
    //   195	77	5	localArrayList	ArrayList
    //   294	20	5	localException1	Exception
    //   365	1	5	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   145	159	294	java/lang/Exception
    //   145	159	337	finally
    //   162	172	360	finally
    //   175	185	360	finally
    //   188	197	360	finally
    //   200	214	360	finally
    //   217	227	360	finally
    //   230	253	360	finally
    //   302	322	360	finally
    //   162	172	365	java/lang/Exception
    //   175	185	365	java/lang/Exception
    //   188	197	365	java/lang/Exception
    //   200	214	365	java/lang/Exception
    //   217	227	365	java/lang/Exception
    //   230	253	365	java/lang/Exception
  }
  
  public final boolean a(aw paramaw, String... paramVarArgs)
  {
    AppMethodBeat.i(32858);
    boolean bool = a(true, paramaw, paramVarArgs);
    AppMethodBeat.o(32858);
    return bool;
  }
  
  /* Error */
  public final String aJG(String paramString)
  {
    // Byte code:
    //   0: ldc_w 381
    //   3: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 63	com/tencent/mm/storage/az:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   10: ldc 38
    //   12: iconst_1
    //   13: anewarray 30	java/lang/String
    //   16: dup
    //   17: iconst_0
    //   18: ldc 174
    //   20: aastore
    //   21: ldc_w 383
    //   24: iconst_1
    //   25: anewarray 30	java/lang/String
    //   28: dup
    //   29: iconst_0
    //   30: aload_1
    //   31: aastore
    //   32: aconst_null
    //   33: aconst_null
    //   34: aconst_null
    //   35: iconst_2
    //   36: invokeinterface 387 9 0
    //   41: astore_2
    //   42: aload_2
    //   43: ifnull +70 -> 113
    //   46: aload_2
    //   47: astore_1
    //   48: aload_2
    //   49: invokeinterface 172 1 0
    //   54: ifeq +59 -> 113
    //   57: aload_2
    //   58: astore_1
    //   59: aload_2
    //   60: aload_2
    //   61: ldc 174
    //   63: invokeinterface 178 2 0
    //   68: invokeinterface 182 2 0
    //   73: astore_3
    //   74: aload_2
    //   75: astore_1
    //   76: ldc 103
    //   78: ldc_w 389
    //   81: iconst_1
    //   82: anewarray 107	java/lang/Object
    //   85: dup
    //   86: iconst_0
    //   87: aload_3
    //   88: invokestatic 235	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   91: aastore
    //   92: invokestatic 116	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   95: aload_2
    //   96: ifnull +9 -> 105
    //   99: aload_2
    //   100: invokeinterface 205 1 0
    //   105: ldc_w 381
    //   108: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   111: aload_3
    //   112: areturn
    //   113: aload_2
    //   114: ifnull +9 -> 123
    //   117: aload_2
    //   118: invokeinterface 205 1 0
    //   123: ldc_w 381
    //   126: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   129: aconst_null
    //   130: areturn
    //   131: astore_3
    //   132: aconst_null
    //   133: astore_2
    //   134: aload_2
    //   135: astore_1
    //   136: ldc 103
    //   138: ldc_w 391
    //   141: iconst_1
    //   142: anewarray 107	java/lang/Object
    //   145: dup
    //   146: iconst_0
    //   147: aload_3
    //   148: invokevirtual 214	java/lang/Exception:toString	()Ljava/lang/String;
    //   151: aastore
    //   152: invokestatic 217	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   155: aload_2
    //   156: ifnull -33 -> 123
    //   159: aload_2
    //   160: invokeinterface 205 1 0
    //   165: goto -42 -> 123
    //   168: astore_2
    //   169: aconst_null
    //   170: astore_1
    //   171: aload_1
    //   172: ifnull +9 -> 181
    //   175: aload_1
    //   176: invokeinterface 205 1 0
    //   181: ldc_w 381
    //   184: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   187: aload_2
    //   188: athrow
    //   189: astore_2
    //   190: goto -19 -> 171
    //   193: astore_3
    //   194: goto -60 -> 134
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	197	0	this	az
    //   0	197	1	paramString	String
    //   41	119	2	localCursor	Cursor
    //   168	20	2	localObject1	Object
    //   189	1	2	localObject2	Object
    //   73	39	3	str	String
    //   131	17	3	localException1	Exception
    //   193	1	3	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   6	42	131	java/lang/Exception
    //   6	42	168	finally
    //   48	57	189	finally
    //   59	74	189	finally
    //   76	95	189	finally
    //   136	155	189	finally
    //   48	57	193	java/lang/Exception
    //   59	74	193	java/lang/Exception
    //   76	95	193	java/lang/Exception
  }
  
  /* Error */
  public final String aJH(String paramString)
  {
    // Byte code:
    //   0: ldc_w 393
    //   3: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 63	com/tencent/mm/storage/az:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   10: ldc 38
    //   12: iconst_1
    //   13: anewarray 30	java/lang/String
    //   16: dup
    //   17: iconst_0
    //   18: ldc 237
    //   20: aastore
    //   21: ldc_w 395
    //   24: iconst_1
    //   25: anewarray 30	java/lang/String
    //   28: dup
    //   29: iconst_0
    //   30: aload_1
    //   31: aastore
    //   32: aconst_null
    //   33: aconst_null
    //   34: aconst_null
    //   35: iconst_2
    //   36: invokeinterface 387 9 0
    //   41: astore_2
    //   42: aload_2
    //   43: ifnull +70 -> 113
    //   46: aload_2
    //   47: astore_1
    //   48: aload_2
    //   49: invokeinterface 172 1 0
    //   54: ifeq +59 -> 113
    //   57: aload_2
    //   58: astore_1
    //   59: aload_2
    //   60: aload_2
    //   61: ldc 237
    //   63: invokeinterface 178 2 0
    //   68: invokeinterface 182 2 0
    //   73: astore_3
    //   74: aload_2
    //   75: astore_1
    //   76: ldc 103
    //   78: ldc_w 397
    //   81: iconst_1
    //   82: anewarray 107	java/lang/Object
    //   85: dup
    //   86: iconst_0
    //   87: aload_3
    //   88: invokestatic 235	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   91: aastore
    //   92: invokestatic 116	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   95: aload_2
    //   96: ifnull +9 -> 105
    //   99: aload_2
    //   100: invokeinterface 205 1 0
    //   105: ldc_w 393
    //   108: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   111: aload_3
    //   112: areturn
    //   113: aload_2
    //   114: ifnull +9 -> 123
    //   117: aload_2
    //   118: invokeinterface 205 1 0
    //   123: ldc_w 393
    //   126: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   129: aconst_null
    //   130: areturn
    //   131: astore_3
    //   132: aconst_null
    //   133: astore_2
    //   134: aload_2
    //   135: astore_1
    //   136: ldc 103
    //   138: ldc_w 399
    //   141: iconst_1
    //   142: anewarray 107	java/lang/Object
    //   145: dup
    //   146: iconst_0
    //   147: aload_3
    //   148: invokevirtual 214	java/lang/Exception:toString	()Ljava/lang/String;
    //   151: aastore
    //   152: invokestatic 217	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   155: aload_2
    //   156: ifnull -33 -> 123
    //   159: aload_2
    //   160: invokeinterface 205 1 0
    //   165: goto -42 -> 123
    //   168: astore_2
    //   169: aconst_null
    //   170: astore_1
    //   171: aload_1
    //   172: ifnull +9 -> 181
    //   175: aload_1
    //   176: invokeinterface 205 1 0
    //   181: ldc_w 393
    //   184: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   187: aload_2
    //   188: athrow
    //   189: astore_2
    //   190: goto -19 -> 171
    //   193: astore_3
    //   194: goto -60 -> 134
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	197	0	this	az
    //   0	197	1	paramString	String
    //   41	119	2	localCursor	Cursor
    //   168	20	2	localObject1	Object
    //   189	1	2	localObject2	Object
    //   73	39	3	str	String
    //   131	17	3	localException1	Exception
    //   193	1	3	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   6	42	131	java/lang/Exception
    //   6	42	168	finally
    //   48	57	189	finally
    //   59	74	189	finally
    //   76	95	189	finally
    //   136	155	189	finally
    //   48	57	193	java/lang/Exception
    //   59	74	193	java/lang/Exception
    //   76	95	193	java/lang/Exception
  }
  
  public final boolean b(aw paramaw, String... paramVarArgs)
  {
    AppMethodBeat.i(248670);
    boolean bool = b(true, paramaw, paramVarArgs);
    AppMethodBeat.o(248670);
    return bool;
  }
  
  /* Error */
  public final ArrayList<String> bY(ArrayList<String> paramArrayList)
  {
    // Byte code:
    //   0: ldc_w 403
    //   3: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: ifnull +10 -> 17
    //   10: aload_1
    //   11: invokevirtual 328	java/util/ArrayList:size	()I
    //   14: ifgt +11 -> 25
    //   17: ldc_w 403
    //   20: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: aconst_null
    //   24: areturn
    //   25: aload_1
    //   26: invokevirtual 328	java/util/ArrayList:size	()I
    //   29: istore_3
    //   30: new 76	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   37: astore 4
    //   39: aload 4
    //   41: ldc_w 405
    //   44: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: aload 4
    //   50: ldc_w 356
    //   53: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: iconst_0
    //   58: istore_2
    //   59: iload_2
    //   60: iload_3
    //   61: if_icmpge +62 -> 123
    //   64: aload 4
    //   66: new 76	java/lang/StringBuilder
    //   69: dup
    //   70: ldc_w 407
    //   73: invokespecial 340	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   76: aload_1
    //   77: iload_2
    //   78: invokevirtual 408	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   81: checkcast 30	java/lang/String
    //   84: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: ldc_w 407
    //   90: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: pop
    //   100: iload_2
    //   101: iload_3
    //   102: iconst_1
    //   103: isub
    //   104: if_icmpge +12 -> 116
    //   107: aload 4
    //   109: ldc_w 360
    //   112: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: pop
    //   116: iload_2
    //   117: iconst_1
    //   118: iadd
    //   119: istore_2
    //   120: goto -61 -> 59
    //   123: aload 4
    //   125: ldc_w 362
    //   128: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: pop
    //   132: aload 4
    //   134: ldc_w 410
    //   137: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: pop
    //   141: aload 4
    //   143: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: astore_1
    //   147: ldc 103
    //   149: ldc_w 412
    //   152: iconst_1
    //   153: anewarray 107	java/lang/Object
    //   156: dup
    //   157: iconst_0
    //   158: aload_1
    //   159: aastore
    //   160: invokestatic 248	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   163: aload_0
    //   164: getfield 63	com/tencent/mm/storage/az:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   167: aload_1
    //   168: aconst_null
    //   169: iconst_2
    //   170: invokeinterface 166 4 0
    //   175: astore 4
    //   177: aload 4
    //   179: astore_1
    //   180: aload 4
    //   182: ldc 237
    //   184: invokeinterface 178 2 0
    //   189: istore_2
    //   190: aload 4
    //   192: astore_1
    //   193: aload 4
    //   195: invokeinterface 172 1 0
    //   200: ifeq +92 -> 292
    //   203: aload 4
    //   205: astore_1
    //   206: new 122	java/util/ArrayList
    //   209: dup
    //   210: invokespecial 123	java/util/ArrayList:<init>	()V
    //   213: astore 5
    //   215: aload 4
    //   217: astore_1
    //   218: aload 5
    //   220: aload 4
    //   222: iload_2
    //   223: invokeinterface 182 2 0
    //   228: invokevirtual 321	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   231: pop
    //   232: aload 4
    //   234: astore_1
    //   235: aload 4
    //   237: invokeinterface 346 1 0
    //   242: ifne -27 -> 215
    //   245: aload 4
    //   247: astore_1
    //   248: ldc 103
    //   250: ldc_w 414
    //   253: iconst_1
    //   254: anewarray 107	java/lang/Object
    //   257: dup
    //   258: iconst_0
    //   259: aload 5
    //   261: invokevirtual 328	java/util/ArrayList:size	()I
    //   264: invokestatic 371	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   267: aastore
    //   268: invokestatic 248	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   271: aload 4
    //   273: ifnull +10 -> 283
    //   276: aload 4
    //   278: invokeinterface 205 1 0
    //   283: ldc_w 403
    //   286: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   289: aload 5
    //   291: areturn
    //   292: aload 4
    //   294: ifnull +10 -> 304
    //   297: aload 4
    //   299: invokeinterface 205 1 0
    //   304: ldc_w 403
    //   307: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   310: aconst_null
    //   311: areturn
    //   312: astore 5
    //   314: aconst_null
    //   315: astore 4
    //   317: aload 4
    //   319: astore_1
    //   320: ldc 103
    //   322: ldc_w 416
    //   325: iconst_1
    //   326: anewarray 107	java/lang/Object
    //   329: dup
    //   330: iconst_0
    //   331: aload 5
    //   333: invokevirtual 214	java/lang/Exception:toString	()Ljava/lang/String;
    //   336: aastore
    //   337: invokestatic 217	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   340: aload 4
    //   342: ifnull -38 -> 304
    //   345: aload 4
    //   347: invokeinterface 205 1 0
    //   352: goto -48 -> 304
    //   355: astore 4
    //   357: aconst_null
    //   358: astore_1
    //   359: aload_1
    //   360: ifnull +9 -> 369
    //   363: aload_1
    //   364: invokeinterface 205 1 0
    //   369: ldc_w 403
    //   372: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   375: aload 4
    //   377: athrow
    //   378: astore 4
    //   380: goto -21 -> 359
    //   383: astore 5
    //   385: goto -68 -> 317
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	388	0	this	az
    //   0	388	1	paramArrayList	ArrayList<String>
    //   58	165	2	i	int
    //   29	75	3	j	int
    //   37	309	4	localObject1	Object
    //   355	21	4	localObject2	Object
    //   378	1	4	localObject3	Object
    //   213	77	5	localArrayList	ArrayList
    //   312	20	5	localException1	Exception
    //   383	1	5	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   163	177	312	java/lang/Exception
    //   163	177	355	finally
    //   180	190	378	finally
    //   193	203	378	finally
    //   206	215	378	finally
    //   218	232	378	finally
    //   235	245	378	finally
    //   248	271	378	finally
    //   320	340	378	finally
    //   180	190	383	java/lang/Exception
    //   193	203	383	java/lang/Exception
    //   206	215	383	java/lang/Exception
    //   218	232	383	java/lang/Exception
    //   235	245	383	java/lang/Exception
    //   248	271	383	java/lang/Exception
  }
  
  public final void bja()
  {
    AppMethodBeat.i(32849);
    Log.v("MicroMsg.Label.ContactLabelStorage", "cleanCache %s", new Object[] { Util.getStack() });
    this.adif = null;
    this.adig = null;
    AppMethodBeat.o(32849);
  }
  
  public final ArrayList<String> bxk(String paramString)
  {
    int i = -1;
    AppMethodBeat.i(32851);
    long l = Util.nowMilliSecond();
    int j = Util.getInt(paramString, -1);
    if (j == -1)
    {
      Log.e("MicroMsg.Label.ContactLabelStorage", "getUserNameListById  failed id:%s", new Object[] { paramString });
      AppMethodBeat.o(32851);
      return null;
    }
    iZQ();
    ArrayList localArrayList = (ArrayList)this.adig.get(Integer.valueOf(j));
    l = Util.milliSecondsToNow(l);
    if (localArrayList == null) {}
    for (;;)
    {
      Log.i("MicroMsg.Label.ContactLabelStorage", "getUserNameListById time:%s id:%s count:%s stack:%s", new Object[] { Long.valueOf(l), paramString, Integer.valueOf(i), Util.getStack() });
      AppMethodBeat.o(32851);
      return localArrayList;
      i = localArrayList.size();
    }
  }
  
  /* Error */
  public final aw bxl(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc_w 459
    //   5: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 63	com/tencent/mm/storage/az:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   12: ldc 38
    //   14: bipush 6
    //   16: anewarray 30	java/lang/String
    //   19: dup
    //   20: iconst_0
    //   21: ldc 237
    //   23: aastore
    //   24: dup
    //   25: iconst_1
    //   26: ldc_w 461
    //   29: aastore
    //   30: dup
    //   31: iconst_2
    //   32: ldc_w 463
    //   35: aastore
    //   36: dup
    //   37: iconst_3
    //   38: ldc 174
    //   40: aastore
    //   41: dup
    //   42: iconst_4
    //   43: ldc_w 465
    //   46: aastore
    //   47: dup
    //   48: iconst_5
    //   49: ldc_w 467
    //   52: aastore
    //   53: ldc_w 395
    //   56: iconst_1
    //   57: anewarray 30	java/lang/String
    //   60: dup
    //   61: iconst_0
    //   62: aload_1
    //   63: aastore
    //   64: aconst_null
    //   65: aconst_null
    //   66: aconst_null
    //   67: iconst_2
    //   68: invokeinterface 387 9 0
    //   73: astore_1
    //   74: aload_1
    //   75: astore_2
    //   76: aload_2
    //   77: ifnull +49 -> 126
    //   80: aload_2
    //   81: astore_1
    //   82: aload_2
    //   83: invokeinterface 172 1 0
    //   88: ifeq +38 -> 126
    //   91: aload_2
    //   92: astore_1
    //   93: new 32	com/tencent/mm/storage/aw
    //   96: dup
    //   97: invokespecial 468	com/tencent/mm/storage/aw:<init>	()V
    //   100: astore_3
    //   101: aload_2
    //   102: astore_1
    //   103: aload_3
    //   104: aload_2
    //   105: invokevirtual 472	com/tencent/mm/storage/aw:convertFrom	(Landroid/database/Cursor;)V
    //   108: aload_2
    //   109: ifnull +9 -> 118
    //   112: aload_2
    //   113: invokeinterface 205 1 0
    //   118: ldc_w 459
    //   121: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   124: aload_3
    //   125: areturn
    //   126: aload_2
    //   127: ifnull +9 -> 136
    //   130: aload_2
    //   131: invokeinterface 205 1 0
    //   136: ldc_w 459
    //   139: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   142: aconst_null
    //   143: areturn
    //   144: astore_3
    //   145: aconst_null
    //   146: astore_2
    //   147: aload_2
    //   148: astore_1
    //   149: ldc 103
    //   151: ldc_w 399
    //   154: iconst_1
    //   155: anewarray 107	java/lang/Object
    //   158: dup
    //   159: iconst_0
    //   160: aload_3
    //   161: invokevirtual 214	java/lang/Exception:toString	()Ljava/lang/String;
    //   164: aastore
    //   165: invokestatic 217	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   168: aload_2
    //   169: ifnull -33 -> 136
    //   172: aload_2
    //   173: invokeinterface 205 1 0
    //   178: goto -42 -> 136
    //   181: astore_1
    //   182: aload_2
    //   183: ifnull +9 -> 192
    //   186: aload_2
    //   187: invokeinterface 205 1 0
    //   192: ldc_w 459
    //   195: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   198: aload_1
    //   199: athrow
    //   200: astore_3
    //   201: aload_1
    //   202: astore_2
    //   203: aload_3
    //   204: astore_1
    //   205: goto -23 -> 182
    //   208: astore_3
    //   209: goto -62 -> 147
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	212	0	this	az
    //   0	212	1	paramString	String
    //   1	202	2	str	String
    //   100	25	3	localaw	aw
    //   144	17	3	localException1	Exception
    //   200	4	3	localObject	Object
    //   208	1	3	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   8	74	144	java/lang/Exception
    //   8	74	181	finally
    //   82	91	200	finally
    //   93	101	200	finally
    //   103	108	200	finally
    //   149	168	200	finally
    //   82	91	208	java/lang/Exception
    //   93	101	208	java/lang/Exception
    //   103	108	208	java/lang/Exception
  }
  
  /* Error */
  public final ArrayList<aw> bxm(String paramString)
  {
    // Byte code:
    //   0: ldc_w 474
    //   3: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 76	java/lang/StringBuilder
    //   9: dup
    //   10: ldc_w 338
    //   13: invokespecial 340	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   16: aload_1
    //   17: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: ldc_w 338
    //   23: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: astore_1
    //   30: aload_0
    //   31: getfield 63	com/tencent/mm/storage/az:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   34: ldc 38
    //   36: bipush 6
    //   38: anewarray 30	java/lang/String
    //   41: dup
    //   42: iconst_0
    //   43: ldc 237
    //   45: aastore
    //   46: dup
    //   47: iconst_1
    //   48: ldc_w 461
    //   51: aastore
    //   52: dup
    //   53: iconst_2
    //   54: ldc_w 463
    //   57: aastore
    //   58: dup
    //   59: iconst_3
    //   60: ldc 174
    //   62: aastore
    //   63: dup
    //   64: iconst_4
    //   65: ldc_w 465
    //   68: aastore
    //   69: dup
    //   70: iconst_5
    //   71: ldc_w 467
    //   74: aastore
    //   75: ldc_w 476
    //   78: iconst_1
    //   79: anewarray 30	java/lang/String
    //   82: dup
    //   83: iconst_0
    //   84: aload_1
    //   85: aastore
    //   86: aconst_null
    //   87: aconst_null
    //   88: aconst_null
    //   89: iconst_2
    //   90: invokeinterface 387 9 0
    //   95: astore_2
    //   96: aload_2
    //   97: astore_3
    //   98: aload_2
    //   99: invokeinterface 172 1 0
    //   104: ifeq +180 -> 284
    //   107: aload_2
    //   108: astore_3
    //   109: new 122	java/util/ArrayList
    //   112: dup
    //   113: invokespecial 123	java/util/ArrayList:<init>	()V
    //   116: astore_1
    //   117: aload_2
    //   118: astore_3
    //   119: new 32	com/tencent/mm/storage/aw
    //   122: dup
    //   123: invokespecial 468	com/tencent/mm/storage/aw:<init>	()V
    //   126: astore 4
    //   128: aload_2
    //   129: astore_3
    //   130: aload 4
    //   132: aload_2
    //   133: invokevirtual 472	com/tencent/mm/storage/aw:convertFrom	(Landroid/database/Cursor;)V
    //   136: aload_2
    //   137: astore_3
    //   138: aload_1
    //   139: aload 4
    //   141: invokevirtual 321	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   144: pop
    //   145: aload_2
    //   146: astore_3
    //   147: aload_2
    //   148: invokeinterface 346 1 0
    //   153: ifne -36 -> 117
    //   156: aload_2
    //   157: astore_3
    //   158: ldc 103
    //   160: ldc_w 478
    //   163: iconst_1
    //   164: anewarray 107	java/lang/Object
    //   167: dup
    //   168: iconst_0
    //   169: aload_1
    //   170: invokevirtual 328	java/util/ArrayList:size	()I
    //   173: invokestatic 371	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   176: aastore
    //   177: invokestatic 248	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   180: aload_1
    //   181: astore_3
    //   182: aload_2
    //   183: ifnull +11 -> 194
    //   186: aload_2
    //   187: invokeinterface 205 1 0
    //   192: aload_1
    //   193: astore_3
    //   194: ldc_w 474
    //   197: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   200: aload_3
    //   201: areturn
    //   202: astore 4
    //   204: aconst_null
    //   205: astore_1
    //   206: aconst_null
    //   207: astore_2
    //   208: aload_2
    //   209: astore_3
    //   210: ldc 103
    //   212: ldc_w 399
    //   215: iconst_1
    //   216: anewarray 107	java/lang/Object
    //   219: dup
    //   220: iconst_0
    //   221: aload 4
    //   223: invokevirtual 214	java/lang/Exception:toString	()Ljava/lang/String;
    //   226: aastore
    //   227: invokestatic 217	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   230: aload_1
    //   231: astore_3
    //   232: aload_2
    //   233: ifnull -39 -> 194
    //   236: aload_2
    //   237: invokeinterface 205 1 0
    //   242: aload_1
    //   243: astore_3
    //   244: goto -50 -> 194
    //   247: astore_1
    //   248: aconst_null
    //   249: astore_3
    //   250: aload_3
    //   251: ifnull +9 -> 260
    //   254: aload_3
    //   255: invokeinterface 205 1 0
    //   260: ldc_w 474
    //   263: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   266: aload_1
    //   267: athrow
    //   268: astore_1
    //   269: goto -19 -> 250
    //   272: astore 4
    //   274: aconst_null
    //   275: astore_1
    //   276: goto -68 -> 208
    //   279: astore 4
    //   281: goto -73 -> 208
    //   284: aconst_null
    //   285: astore_1
    //   286: goto -106 -> 180
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	289	0	this	az
    //   0	289	1	paramString	String
    //   95	142	2	localCursor	Cursor
    //   97	158	3	localObject	Object
    //   126	14	4	localaw	aw
    //   202	20	4	localException1	Exception
    //   272	1	4	localException2	Exception
    //   279	1	4	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   30	96	202	java/lang/Exception
    //   30	96	247	finally
    //   98	107	268	finally
    //   109	117	268	finally
    //   119	128	268	finally
    //   130	136	268	finally
    //   138	145	268	finally
    //   147	156	268	finally
    //   158	180	268	finally
    //   210	230	268	finally
    //   98	107	272	java/lang/Exception
    //   109	117	272	java/lang/Exception
    //   119	128	279	java/lang/Exception
    //   130	136	279	java/lang/Exception
    //   138	145	279	java/lang/Exception
    //   147	156	279	java/lang/Exception
    //   158	180	279	java/lang/Exception
  }
  
  /* Error */
  public final aw bxn(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc_w 481
    //   5: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 63	com/tencent/mm/storage/az:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   12: ldc 38
    //   14: bipush 6
    //   16: anewarray 30	java/lang/String
    //   19: dup
    //   20: iconst_0
    //   21: ldc 237
    //   23: aastore
    //   24: dup
    //   25: iconst_1
    //   26: ldc_w 461
    //   29: aastore
    //   30: dup
    //   31: iconst_2
    //   32: ldc_w 463
    //   35: aastore
    //   36: dup
    //   37: iconst_3
    //   38: ldc 174
    //   40: aastore
    //   41: dup
    //   42: iconst_4
    //   43: ldc_w 465
    //   46: aastore
    //   47: dup
    //   48: iconst_5
    //   49: ldc_w 467
    //   52: aastore
    //   53: ldc_w 383
    //   56: iconst_1
    //   57: anewarray 30	java/lang/String
    //   60: dup
    //   61: iconst_0
    //   62: aload_1
    //   63: aastore
    //   64: aconst_null
    //   65: aconst_null
    //   66: aconst_null
    //   67: iconst_2
    //   68: invokeinterface 387 9 0
    //   73: astore_1
    //   74: aload_1
    //   75: astore_2
    //   76: aload_2
    //   77: ifnull +49 -> 126
    //   80: aload_2
    //   81: astore_1
    //   82: aload_2
    //   83: invokeinterface 172 1 0
    //   88: ifeq +38 -> 126
    //   91: aload_2
    //   92: astore_1
    //   93: new 32	com/tencent/mm/storage/aw
    //   96: dup
    //   97: invokespecial 468	com/tencent/mm/storage/aw:<init>	()V
    //   100: astore_3
    //   101: aload_2
    //   102: astore_1
    //   103: aload_3
    //   104: aload_2
    //   105: invokevirtual 472	com/tencent/mm/storage/aw:convertFrom	(Landroid/database/Cursor;)V
    //   108: aload_2
    //   109: ifnull +9 -> 118
    //   112: aload_2
    //   113: invokeinterface 205 1 0
    //   118: ldc_w 481
    //   121: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   124: aload_3
    //   125: areturn
    //   126: aload_2
    //   127: ifnull +9 -> 136
    //   130: aload_2
    //   131: invokeinterface 205 1 0
    //   136: ldc_w 481
    //   139: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   142: aconst_null
    //   143: areturn
    //   144: astore_3
    //   145: aconst_null
    //   146: astore_2
    //   147: aload_2
    //   148: astore_1
    //   149: ldc 103
    //   151: ldc_w 483
    //   154: iconst_1
    //   155: anewarray 107	java/lang/Object
    //   158: dup
    //   159: iconst_0
    //   160: aload_3
    //   161: invokevirtual 214	java/lang/Exception:toString	()Ljava/lang/String;
    //   164: aastore
    //   165: invokestatic 217	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   168: aload_2
    //   169: ifnull -33 -> 136
    //   172: aload_2
    //   173: invokeinterface 205 1 0
    //   178: goto -42 -> 136
    //   181: astore_1
    //   182: aload_2
    //   183: ifnull +9 -> 192
    //   186: aload_2
    //   187: invokeinterface 205 1 0
    //   192: ldc_w 481
    //   195: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   198: aload_1
    //   199: athrow
    //   200: astore_3
    //   201: aload_1
    //   202: astore_2
    //   203: aload_3
    //   204: astore_1
    //   205: goto -23 -> 182
    //   208: astore_3
    //   209: goto -62 -> 147
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	212	0	this	az
    //   0	212	1	paramString	String
    //   1	202	2	str	String
    //   100	25	3	localaw	aw
    //   144	17	3	localException1	Exception
    //   200	4	3	localObject	Object
    //   208	1	3	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   8	74	144	java/lang/Exception
    //   8	74	181	finally
    //   82	91	200	finally
    //   93	101	200	finally
    //   103	108	200	finally
    //   149	168	200	finally
    //   82	91	208	java/lang/Exception
    //   93	101	208	java/lang/Exception
    //   103	108	208	java/lang/Exception
  }
  
  public final ArrayList<String> iZN()
  {
    AppMethodBeat.i(32847);
    long l = Util.nowMilliSecond();
    Cursor localCursor = this.db.query("ContactLabel", new String[] { "labelName" }, null, null, null, null, "createTime ASC ", 2);
    if (localCursor == null)
    {
      AppMethodBeat.o(32847);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    while (localCursor.moveToNext()) {
      localArrayList.add(localCursor.getString(0));
    }
    localCursor.close();
    Log.i("MicroMsg.Label.ContactLabelStorage", "getAllLabel time:%s count:%s stack:%s", new Object[] { Long.valueOf(Util.milliSecondsToNow(l)), Integer.valueOf(localArrayList.size()), Util.getStack() });
    AppMethodBeat.o(32847);
    return localArrayList;
  }
  
  public final ArrayList<aw> iZO()
  {
    AppMethodBeat.i(32848);
    long l = Util.nowMilliSecond();
    Cursor localCursor = this.db.rawQuery("select * from ContactLabel order by createTime ASC ", null, 2);
    if (localCursor == null)
    {
      AppMethodBeat.o(32848);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    while (localCursor.moveToNext())
    {
      aw localaw = new aw();
      localaw.convertFrom(localCursor);
      localArrayList.add(localaw);
    }
    localCursor.close();
    Log.i("MicroMsg.Label.ContactLabelStorage", "getAllContactLable time:%s count:%s stack:%s", new Object[] { Long.valueOf(Util.milliSecondsToNow(l)), Integer.valueOf(localArrayList.size()), Util.getStack() });
    AppMethodBeat.o(32848);
    return localArrayList;
  }
  
  public final ArrayList<aw> iZP()
  {
    AppMethodBeat.i(248629);
    long l = Util.nowMilliSecond();
    Cursor localCursor = this.db.rawQuery("select * from ContactLabel where isTemporary = 0  order by createTime ASC ", null, 2);
    if (localCursor == null)
    {
      AppMethodBeat.o(248629);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    while (localCursor.moveToNext())
    {
      aw localaw = new aw();
      localaw.convertFrom(localCursor);
      localArrayList.add(localaw);
    }
    localCursor.close();
    Log.i("MicroMsg.Label.ContactLabelStorage", "getAllContactLable time:%s count:%s stack:%s", new Object[] { Long.valueOf(Util.milliSecondsToNow(l)), Integer.valueOf(localArrayList.size()), Util.getStack() });
    AppMethodBeat.o(248629);
    return localArrayList;
  }
  
  public final void iZQ()
  {
    AppMethodBeat.i(32850);
    if ((this.adif != null) && (this.adig != null))
    {
      AppMethodBeat.o(32850);
      return;
    }
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    long l = Util.nowMilliSecond();
    Object localObject1 = "select username , contactLabelIds from rcontact where (type & " + d.aSp() + " !=0 ) and ( contactLabelIds != '') ;";
    localObject1 = this.db.rawQuery((String)localObject1, null, 2);
    Object localObject2;
    Object localObject3;
    if (localObject1 == null)
    {
      this.adif = localHashMap1;
      this.adig = localHashMap2;
      AppMethodBeat.o(32850);
      return;
      localHashMap1.put(localObject2, localObject3);
    }
    while (((Cursor)localObject1).moveToNext())
    {
      localObject2 = ((Cursor)localObject1).getString(0);
      if (!Util.isNullOrNil((String)localObject2))
      {
        String[] arrayOfString = Util.nullAsNil(((Cursor)localObject1).getString(1)).split(",");
        if ((arrayOfString != null) && (arrayOfString.length > 0))
        {
          localObject3 = new int[arrayOfString.length];
          int i = 0;
          label192:
          if (i < arrayOfString.length)
          {
            localObject3[i] = Util.getInt(arrayOfString[i], -1);
            if (!localHashMap2.containsKey(Integer.valueOf(localObject3[i]))) {
              break label254;
            }
            ((ArrayList)localHashMap2.get(Integer.valueOf(localObject3[i]))).add(localObject2);
          }
          for (;;)
          {
            i += 1;
            break label192;
            break;
            label254:
            ArrayList localArrayList = new ArrayList();
            localArrayList.add(localObject2);
            localHashMap2.put(Integer.valueOf(localObject3[i]), localArrayList);
          }
        }
      }
    }
    ((Cursor)localObject1).close();
    Log.i("MicroMsg.Label.ContactLabelStorage", "checkRebuildCache time:%s user:%s label:%s stack:%s", new Object[] { Long.valueOf(Util.milliSecondsToNow(l)), Integer.valueOf(localHashMap1.size()), Integer.valueOf(localHashMap2.size()), Util.getStack() });
    this.adif = localHashMap1;
    this.adig = localHashMap2;
    AppMethodBeat.o(32850);
  }
  
  public final boolean mJ(List<aw> paramList)
  {
    AppMethodBeat.i(32860);
    if (paramList.size() <= 0)
    {
      Log.i("MicroMsg.Label.ContactLabelStorage", "cpan[insertAddLabel] list is null.");
      AppMethodBeat.o(32860);
      return false;
    }
    h localh = null;
    long l;
    if ((this.db instanceof h))
    {
      localh = (h)this.db;
      l = localh.beginTransaction(Thread.currentThread().getId());
      Log.i("MicroMsg.Label.ContactLabelStorage", "begin deleteLocalLabel in a transaction, ticket = %d", new Object[] { Long.valueOf(l) });
    }
    for (;;)
    {
      int j = paramList.size();
      new ArrayList();
      int i = 0;
      while (i < j)
      {
        String str = c((aw)paramList.get(i));
        if (!Util.isNullOrNil(str)) {
          iP(str);
        }
        i += 1;
      }
      if (localh != null)
      {
        localh.endTransaction(l);
        Log.i("MicroMsg.Label.ContactLabelStorage", "end deleteLocalLabel transaction");
      }
      bja();
      AppMethodBeat.o(32860);
      return false;
      l = -1L;
    }
  }
  
  public final boolean mK(List<aw> paramList)
  {
    AppMethodBeat.i(32861);
    if (paramList.size() <= 0)
    {
      Log.i("MicroMsg.Label.ContactLabelStorage", "cpan[insertOrUpdateList] list is null.");
      AppMethodBeat.o(32861);
      return false;
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    h localh = null;
    long l;
    if ((this.db instanceof h))
    {
      localh = (h)this.db;
      l = localh.beginTransaction(Thread.currentThread().getId());
      Log.i("MicroMsg.Label.ContactLabelStorage", "begin insertOrUpdateList in a transaction, ticket = %d", new Object[] { Long.valueOf(l) });
    }
    for (;;)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        aw localaw = (aw)paramList.next();
        if (localaw != null)
        {
          a locala = b(localaw);
          switch (1.adih[locala.ordinal()])
          {
          case 1: 
          default: 
            Log.w("MicroMsg.Label.ContactLabelStorage", "cpan[insertOrUpdateList] unknow result.");
            break;
          case 2: 
            b(false, localaw, new String[] { "labelID" });
            localArrayList2.add(localaw);
            break;
          case 3: 
            localaw.field_createTime = System.currentTimeMillis();
            a(false, localaw);
            localArrayList1.add(localaw);
          }
        }
      }
      if (localh != null)
      {
        localh.endTransaction(l);
        Log.i("MicroMsg.Label.ContactLabelStorage", "end insertOrUpdateList transaction");
      }
      if (localArrayList1.size() > 0) {
        doNotify(R("insert", localArrayList1));
      }
      if (localArrayList2.size() > 0) {
        doNotify(R("update", localArrayList2));
      }
      bja();
      AppMethodBeat.o(32861);
      return false;
      l = -1L;
    }
  }
  
  public final boolean mL(List<aw> paramList)
  {
    AppMethodBeat.i(248681);
    boolean bool = N(paramList, true);
    AppMethodBeat.o(248681);
    return bool;
  }
  
  public final boolean mM(List<aw> paramList)
  {
    AppMethodBeat.i(32871);
    if ((paramList == null) || (paramList.size() <= 0))
    {
      Log.w("MicroMsg.Label.ContactLabelStorage", "cpan[deleteList] list is null.");
      AppMethodBeat.o(32871);
      return false;
    }
    h localh = null;
    long l;
    if ((this.db instanceof h))
    {
      localh = (h)this.db;
      l = localh.beginTransaction(Thread.currentThread().getId());
      Log.i("MicroMsg.Label.ContactLabelStorage", "begin deleteList in a transaction, ticket = %d", new Object[] { Long.valueOf(l) });
    }
    for (;;)
    {
      int j = paramList.size();
      int i = 0;
      while (i < j)
      {
        a(false, (aw)paramList.get(i), new String[] { "labelID" });
        i += 1;
      }
      if (localh != null)
      {
        localh.endTransaction(l);
        Log.i("MicroMsg.Label.ContactLabelStorage", "end insertOrUpdateList transaction");
      }
      doNotify(R("delete", paramList));
      iZR();
      AppMethodBeat.o(32871);
      return true;
      l = -1L;
    }
  }
  
  /* Error */
  public final ArrayList<aw> mN(List<aw> paramList)
  {
    // Byte code:
    //   0: ldc_w 589
    //   3: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: invokeinterface 90 1 0
    //   12: ifgt +11 -> 23
    //   15: ldc_w 589
    //   18: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aconst_null
    //   22: areturn
    //   23: aload_1
    //   24: invokeinterface 90 1 0
    //   29: istore_3
    //   30: new 76	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   37: astore 4
    //   39: aload 4
    //   41: ldc_w 354
    //   44: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: aload 4
    //   50: ldc_w 591
    //   53: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: iconst_0
    //   58: istore_2
    //   59: iload_2
    //   60: iload_3
    //   61: if_icmpge +67 -> 128
    //   64: aload 4
    //   66: new 76	java/lang/StringBuilder
    //   69: dup
    //   70: ldc_w 358
    //   73: invokespecial 340	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   76: aload_1
    //   77: iload_2
    //   78: invokeinterface 94 2 0
    //   83: checkcast 32	com/tencent/mm/storage/aw
    //   86: getfield 98	com/tencent/mm/storage/aw:field_labelID	I
    //   89: invokevirtual 101	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   92: ldc_w 358
    //   95: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: pop
    //   105: iload_2
    //   106: iload_3
    //   107: iconst_1
    //   108: isub
    //   109: if_icmpge +12 -> 121
    //   112: aload 4
    //   114: ldc_w 360
    //   117: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: pop
    //   121: iload_2
    //   122: iconst_1
    //   123: iadd
    //   124: istore_2
    //   125: goto -66 -> 59
    //   128: aload 4
    //   130: ldc_w 362
    //   133: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: pop
    //   137: aload 4
    //   139: ldc_w 410
    //   142: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: pop
    //   146: aload 4
    //   148: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   151: astore_1
    //   152: ldc 103
    //   154: ldc_w 593
    //   157: iconst_1
    //   158: anewarray 107	java/lang/Object
    //   161: dup
    //   162: iconst_0
    //   163: aload_1
    //   164: aastore
    //   165: invokestatic 248	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   168: aload_0
    //   169: getfield 63	com/tencent/mm/storage/az:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   172: aload_1
    //   173: aconst_null
    //   174: iconst_2
    //   175: invokeinterface 166 4 0
    //   180: astore 4
    //   182: aload 4
    //   184: astore_1
    //   185: aload 4
    //   187: invokeinterface 172 1 0
    //   192: ifeq +108 -> 300
    //   195: aload 4
    //   197: astore_1
    //   198: new 122	java/util/ArrayList
    //   201: dup
    //   202: invokespecial 123	java/util/ArrayList:<init>	()V
    //   205: astore 5
    //   207: aload 4
    //   209: astore_1
    //   210: new 32	com/tencent/mm/storage/aw
    //   213: dup
    //   214: invokespecial 468	com/tencent/mm/storage/aw:<init>	()V
    //   217: astore 6
    //   219: aload 4
    //   221: astore_1
    //   222: aload 6
    //   224: aload 4
    //   226: invokevirtual 472	com/tencent/mm/storage/aw:convertFrom	(Landroid/database/Cursor;)V
    //   229: aload 4
    //   231: astore_1
    //   232: aload 5
    //   234: aload 6
    //   236: invokevirtual 321	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   239: pop
    //   240: aload 4
    //   242: astore_1
    //   243: aload 4
    //   245: invokeinterface 346 1 0
    //   250: ifne -43 -> 207
    //   253: aload 4
    //   255: astore_1
    //   256: ldc 103
    //   258: ldc_w 478
    //   261: iconst_1
    //   262: anewarray 107	java/lang/Object
    //   265: dup
    //   266: iconst_0
    //   267: aload 5
    //   269: invokevirtual 328	java/util/ArrayList:size	()I
    //   272: invokestatic 371	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   275: aastore
    //   276: invokestatic 248	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   279: aload 4
    //   281: ifnull +10 -> 291
    //   284: aload 4
    //   286: invokeinterface 205 1 0
    //   291: ldc_w 589
    //   294: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   297: aload 5
    //   299: areturn
    //   300: aload 4
    //   302: ifnull +10 -> 312
    //   305: aload 4
    //   307: invokeinterface 205 1 0
    //   312: ldc_w 589
    //   315: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   318: aconst_null
    //   319: areturn
    //   320: astore 5
    //   322: aconst_null
    //   323: astore 4
    //   325: aload 4
    //   327: astore_1
    //   328: ldc 103
    //   330: ldc_w 595
    //   333: iconst_1
    //   334: anewarray 107	java/lang/Object
    //   337: dup
    //   338: iconst_0
    //   339: aload 5
    //   341: invokevirtual 214	java/lang/Exception:toString	()Ljava/lang/String;
    //   344: aastore
    //   345: invokestatic 217	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   348: aload 4
    //   350: ifnull -38 -> 312
    //   353: aload 4
    //   355: invokeinterface 205 1 0
    //   360: goto -48 -> 312
    //   363: astore 4
    //   365: aconst_null
    //   366: astore_1
    //   367: aload_1
    //   368: ifnull +9 -> 377
    //   371: aload_1
    //   372: invokeinterface 205 1 0
    //   377: ldc_w 589
    //   380: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   383: aload 4
    //   385: athrow
    //   386: astore 4
    //   388: goto -21 -> 367
    //   391: astore 5
    //   393: goto -68 -> 325
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	396	0	this	az
    //   0	396	1	paramList	List<aw>
    //   58	67	2	i	int
    //   29	80	3	j	int
    //   37	317	4	localObject1	Object
    //   363	21	4	localObject2	Object
    //   386	1	4	localObject3	Object
    //   205	93	5	localArrayList	ArrayList
    //   320	20	5	localException1	Exception
    //   391	1	5	localException2	Exception
    //   217	18	6	localaw	aw
    // Exception table:
    //   from	to	target	type
    //   168	182	320	java/lang/Exception
    //   168	182	363	finally
    //   185	195	386	finally
    //   198	207	386	finally
    //   210	219	386	finally
    //   222	229	386	finally
    //   232	240	386	finally
    //   243	253	386	finally
    //   256	279	386	finally
    //   328	348	386	finally
    //   185	195	391	java/lang/Exception
    //   198	207	391	java/lang/Exception
    //   210	219	391	java/lang/Exception
    //   222	229	391	java/lang/Exception
    //   232	240	391	java/lang/Exception
    //   243	253	391	java/lang/Exception
    //   256	279	391	java/lang/Exception
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(32845);
      adii = new a("EQUAL", 0);
      adij = new a("NOEQUAL", 1);
      adik = new a("NOEXISTS", 2);
      adil = new a[] { adii, adij, adik };
      AppMethodBeat.o(32845);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.az
 * JD-Core Version:    0.7.0.1
 */