package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.g;
import com.tencent.mm.cg.g.a;
import com.tencent.mm.cg.h;
import com.tencent.mm.g.a.uj;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class ai
  extends j<af>
  implements g.a
{
  public static final String[] SQL_CREATE;
  private e db;
  private HashMap<String, int[]> yMd;
  public HashMap<Integer, ArrayList<String>> yMe;
  
  static
  {
    AppMethodBeat.i(29061);
    SQL_CREATE = new String[] { j.getCreateSQLs(af.info, "ContactLabel") };
    AppMethodBeat.o(29061);
  }
  
  public ai(e parame)
  {
    this(parame, af.info, "ContactLabel");
  }
  
  private ai(e parame, c.a parama, String paramString)
  {
    super(parame, parama, paramString, null);
    AppMethodBeat.i(29030);
    this.yMd = null;
    this.yMe = null;
    this.db = parame;
    parame.execSQL("ContactLabel", "CREATE INDEX IF NOT EXISTS  contact_label_createtime_index ON ContactLabel ( createTime )");
    AppMethodBeat.o(29030);
  }
  
  private static String a(String paramString, af paramaf)
  {
    AppMethodBeat.i(29052);
    if (paramaf != null)
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramaf);
      paramString = y(paramString, localArrayList);
      AppMethodBeat.o(29052);
      return paramString;
    }
    AppMethodBeat.o(29052);
    return null;
  }
  
  private boolean a(boolean paramBoolean, af paramaf)
  {
    AppMethodBeat.i(29039);
    boolean bool = super.insert(paramaf);
    if ((bool) && (paramBoolean)) {
      doNotify(a("insert", paramaf));
    }
    AppMethodBeat.o(29039);
    return bool;
  }
  
  private boolean a(boolean paramBoolean, af paramaf, String... paramVarArgs)
  {
    AppMethodBeat.i(29041);
    boolean bool = super.delete(paramaf, paramVarArgs);
    if ((bool) && (paramBoolean))
    {
      doNotify(a("delete", paramaf));
      dwJ();
    }
    ahN();
    AppMethodBeat.o(29041);
    return bool;
  }
  
  private ai.a b(af paramaf)
  {
    AppMethodBeat.i(29050);
    localObject2 = null;
    localObject1 = null;
    Object localObject3 = paramaf.field_labelID;
    try
    {
      localObject3 = this.db.a("select * from ContactLabel where labelID=?", new String[] { localObject3 }, 2);
      if (localObject3 != null)
      {
        localObject1 = localObject3;
        localObject2 = localObject3;
        if (((Cursor)localObject3).moveToFirst())
        {
          localObject1 = localObject3;
          localObject2 = localObject3;
          String str = bo.bf(((Cursor)localObject3).getString(((Cursor)localObject3).getColumnIndex("labelName")), "");
          localObject1 = localObject3;
          localObject2 = localObject3;
          if (paramaf.field_labelName.equalsIgnoreCase(str))
          {
            localObject1 = localObject3;
            localObject2 = localObject3;
            paramaf = ai.a.yMg;
            if (localObject3 != null) {
              ((Cursor)localObject3).close();
            }
            AppMethodBeat.o(29050);
            return paramaf;
          }
          localObject1 = localObject3;
          localObject2 = localObject3;
          paramaf = ai.a.yMh;
          if (localObject3 != null) {
            ((Cursor)localObject3).close();
          }
          AppMethodBeat.o(29050);
          return paramaf;
        }
      }
      if (localObject3 != null) {
        ((Cursor)localObject3).close();
      }
    }
    catch (Exception paramaf)
    {
      for (;;)
      {
        localObject2 = localObject1;
        ab.w("MicroMsg.Label.ContactLabelStorage", "cpan[checkEqualsName] exception %s", new Object[] { paramaf.toString() });
        if (localObject1 != null) {
          localObject1.close();
        }
      }
    }
    finally
    {
      if (localObject2 == null) {
        break label249;
      }
      localObject2.close();
      AppMethodBeat.o(29050);
    }
    paramaf = ai.a.yMi;
    AppMethodBeat.o(29050);
    return paramaf;
  }
  
  /* Error */
  private String c(af paramaf)
  {
    // Byte code:
    //   0: sipush 29051
    //   3: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 114	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   13: aload_1
    //   14: getfield 160	com/tencent/mm/storage/af:field_labelName	Ljava/lang/String;
    //   17: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   23: astore_3
    //   24: aload_0
    //   25: getfield 60	com/tencent/mm/storage/ai:db	Lcom/tencent/mm/sdk/e/e;
    //   28: ldc 197
    //   30: iconst_2
    //   31: anewarray 28	java/lang/String
    //   34: dup
    //   35: iconst_0
    //   36: aload_3
    //   37: aastore
    //   38: dup
    //   39: iconst_1
    //   40: ldc 199
    //   42: aastore
    //   43: iconst_2
    //   44: invokeinterface 132 4 0
    //   49: astore 4
    //   51: aload 4
    //   53: ifnull +141 -> 194
    //   56: aload 4
    //   58: astore_3
    //   59: aload 4
    //   61: invokeinterface 138 1 0
    //   66: ifeq +128 -> 194
    //   69: aload 4
    //   71: astore_3
    //   72: aload 4
    //   74: aload 4
    //   76: ldc 140
    //   78: invokeinterface 144 2 0
    //   83: invokeinterface 148 2 0
    //   88: ldc 150
    //   90: invokestatic 156	com/tencent/mm/sdk/platformtools/bo:bf	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   93: astore 5
    //   95: aload 4
    //   97: astore_3
    //   98: aload_1
    //   99: getfield 160	com/tencent/mm/storage/af:field_labelName	Ljava/lang/String;
    //   102: aload 5
    //   104: invokevirtual 164	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   107: istore_2
    //   108: aload 4
    //   110: astore_3
    //   111: ldc 179
    //   113: ldc 201
    //   115: iconst_2
    //   116: anewarray 183	java/lang/Object
    //   119: dup
    //   120: iconst_0
    //   121: new 114	java/lang/StringBuilder
    //   124: dup
    //   125: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   128: aload_1
    //   129: getfield 160	com/tencent/mm/storage/af:field_labelName	Ljava/lang/String;
    //   132: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   138: aastore
    //   139: dup
    //   140: iconst_1
    //   141: aload 5
    //   143: invokestatic 205	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   146: aastore
    //   147: invokestatic 207	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   150: iload_2
    //   151: ifeq +43 -> 194
    //   154: aload 4
    //   156: astore_3
    //   157: aload 4
    //   159: aload 4
    //   161: ldc 209
    //   163: invokeinterface 144 2 0
    //   168: invokeinterface 148 2 0
    //   173: astore_1
    //   174: aload 4
    //   176: ifnull +10 -> 186
    //   179: aload 4
    //   181: invokeinterface 171 1 0
    //   186: sipush 29051
    //   189: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   192: aload_1
    //   193: areturn
    //   194: aload 4
    //   196: ifnull +10 -> 206
    //   199: aload 4
    //   201: invokeinterface 171 1 0
    //   206: sipush 29051
    //   209: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   212: aconst_null
    //   213: areturn
    //   214: astore_1
    //   215: aconst_null
    //   216: astore 4
    //   218: aload 4
    //   220: astore_3
    //   221: ldc 179
    //   223: ldc 181
    //   225: iconst_1
    //   226: anewarray 183	java/lang/Object
    //   229: dup
    //   230: iconst_0
    //   231: aload_1
    //   232: invokevirtual 184	java/lang/Exception:toString	()Ljava/lang/String;
    //   235: aastore
    //   236: invokestatic 190	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   239: aload 4
    //   241: ifnull -35 -> 206
    //   244: aload 4
    //   246: invokeinterface 171 1 0
    //   251: goto -45 -> 206
    //   254: astore_1
    //   255: aconst_null
    //   256: astore_3
    //   257: aload_3
    //   258: ifnull +9 -> 267
    //   261: aload_3
    //   262: invokeinterface 171 1 0
    //   267: sipush 29051
    //   270: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   273: aload_1
    //   274: athrow
    //   275: astore_1
    //   276: goto -19 -> 257
    //   279: astore_1
    //   280: goto -62 -> 218
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	283	0	this	ai
    //   0	283	1	paramaf	af
    //   107	44	2	bool	boolean
    //   23	239	3	localObject	Object
    //   49	196	4	localCursor	Cursor
    //   93	49	5	str	String
    // Exception table:
    //   from	to	target	type
    //   24	51	214	java/lang/Exception
    //   24	51	254	finally
    //   59	69	275	finally
    //   72	95	275	finally
    //   98	108	275	finally
    //   111	150	275	finally
    //   157	174	275	finally
    //   221	239	275	finally
    //   59	69	279	java/lang/Exception
    //   72	95	279	java/lang/Exception
    //   98	108	279	java/lang/Exception
    //   111	150	279	java/lang/Exception
    //   157	174	279	java/lang/Exception
  }
  
  private static void dwJ()
  {
    AppMethodBeat.i(29054);
    ab.i("MicroMsg.Label.ContactLabelStorage", "cpan[publishUpdateSearchIndexEvent]");
    uj localuj = new uj();
    localuj.cKS.cps = 3000L;
    com.tencent.mm.sdk.b.a.ymk.l(localuj);
    AppMethodBeat.o(29054);
  }
  
  private static String y(String paramString, List<af> paramList)
  {
    AppMethodBeat.i(29053);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(" ");
    if ((paramList != null) && (paramList.size() > 0))
    {
      int j = paramList.size();
      int i = 0;
      while (i < j)
      {
        paramString = (af)paramList.get(i);
        if (paramString != null)
        {
          localStringBuilder.append(paramString.field_labelID);
          if (i < j - 1) {
            localStringBuilder.append(" ");
          }
        }
        i += 1;
      }
      ab.i("MicroMsg.Label.ContactLabelStorage", "cpan[genNotifyString] event:%s", new Object[] { localStringBuilder.toString() });
      paramString = localStringBuilder.toString();
      AppMethodBeat.o(29053);
      return paramString;
    }
    AppMethodBeat.o(29053);
    return null;
  }
  
  /* Error */
  public final ArrayList<String> R(String[] paramArrayOfString)
  {
    // Byte code:
    //   0: sipush 29037
    //   3: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: ifnull +8 -> 15
    //   10: aload_1
    //   11: arraylength
    //   12: ifgt +11 -> 23
    //   15: sipush 29037
    //   18: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aconst_null
    //   22: areturn
    //   23: aload_1
    //   24: arraylength
    //   25: istore_3
    //   26: new 114	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   33: astore 4
    //   35: aload 4
    //   37: ldc_w 257
    //   40: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: pop
    //   44: aload 4
    //   46: ldc_w 259
    //   49: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: iconst_0
    //   54: istore_2
    //   55: iload_2
    //   56: iload_3
    //   57: if_icmpge +57 -> 114
    //   60: aload 4
    //   62: new 114	java/lang/StringBuilder
    //   65: dup
    //   66: ldc_w 261
    //   69: invokespecial 263	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   72: aload_1
    //   73: iload_2
    //   74: aaload
    //   75: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: ldc_w 261
    //   81: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: pop
    //   91: iload_2
    //   92: iload_3
    //   93: iconst_1
    //   94: isub
    //   95: if_icmpge +12 -> 107
    //   98: aload 4
    //   100: ldc_w 265
    //   103: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: pop
    //   107: iload_2
    //   108: iconst_1
    //   109: iadd
    //   110: istore_2
    //   111: goto -56 -> 55
    //   114: aload 4
    //   116: ldc_w 267
    //   119: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: pop
    //   123: aload 4
    //   125: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: astore_1
    //   129: ldc 179
    //   131: ldc_w 269
    //   134: iconst_1
    //   135: anewarray 183	java/lang/Object
    //   138: dup
    //   139: iconst_0
    //   140: aload_1
    //   141: aastore
    //   142: invokestatic 272	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   145: aload_0
    //   146: getfield 60	com/tencent/mm/storage/ai:db	Lcom/tencent/mm/sdk/e/e;
    //   149: aload_1
    //   150: aconst_null
    //   151: iconst_2
    //   152: invokeinterface 132 4 0
    //   157: astore 4
    //   159: aload 4
    //   161: astore_1
    //   162: aload 4
    //   164: ldc 140
    //   166: invokeinterface 144 2 0
    //   171: istore_2
    //   172: aload 4
    //   174: astore_1
    //   175: aload 4
    //   177: invokeinterface 138 1 0
    //   182: ifeq +92 -> 274
    //   185: aload 4
    //   187: astore_1
    //   188: new 72	java/util/ArrayList
    //   191: dup
    //   192: invokespecial 74	java/util/ArrayList:<init>	()V
    //   195: astore 5
    //   197: aload 4
    //   199: astore_1
    //   200: aload 5
    //   202: aload 4
    //   204: iload_2
    //   205: invokeinterface 148 2 0
    //   210: invokevirtual 273	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   213: pop
    //   214: aload 4
    //   216: astore_1
    //   217: aload 4
    //   219: invokeinterface 276 1 0
    //   224: ifne -27 -> 197
    //   227: aload 4
    //   229: astore_1
    //   230: ldc 179
    //   232: ldc_w 278
    //   235: iconst_1
    //   236: anewarray 183	java/lang/Object
    //   239: dup
    //   240: iconst_0
    //   241: aload 5
    //   243: invokevirtual 279	java/util/ArrayList:size	()I
    //   246: invokestatic 284	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   249: aastore
    //   250: invokestatic 272	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   253: aload 4
    //   255: ifnull +10 -> 265
    //   258: aload 4
    //   260: invokeinterface 171 1 0
    //   265: sipush 29037
    //   268: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   271: aload 5
    //   273: areturn
    //   274: aload 4
    //   276: ifnull +10 -> 286
    //   279: aload 4
    //   281: invokeinterface 171 1 0
    //   286: sipush 29037
    //   289: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   292: aconst_null
    //   293: areturn
    //   294: astore 5
    //   296: aconst_null
    //   297: astore 4
    //   299: aload 4
    //   301: astore_1
    //   302: ldc 179
    //   304: ldc_w 286
    //   307: iconst_1
    //   308: anewarray 183	java/lang/Object
    //   311: dup
    //   312: iconst_0
    //   313: aload 5
    //   315: invokevirtual 184	java/lang/Exception:toString	()Ljava/lang/String;
    //   318: aastore
    //   319: invokestatic 190	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   322: aload 4
    //   324: ifnull -38 -> 286
    //   327: aload 4
    //   329: invokeinterface 171 1 0
    //   334: goto -48 -> 286
    //   337: astore 4
    //   339: aconst_null
    //   340: astore_1
    //   341: aload_1
    //   342: ifnull +9 -> 351
    //   345: aload_1
    //   346: invokeinterface 171 1 0
    //   351: sipush 29037
    //   354: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   357: aload 4
    //   359: athrow
    //   360: astore 4
    //   362: goto -21 -> 341
    //   365: astore 5
    //   367: goto -68 -> 299
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	370	0	this	ai
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
  
  /* Error */
  public final String RN(String paramString)
  {
    // Byte code:
    //   0: sipush 29046
    //   3: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 60	com/tencent/mm/storage/ai:db	Lcom/tencent/mm/sdk/e/e;
    //   10: ldc 36
    //   12: iconst_1
    //   13: anewarray 28	java/lang/String
    //   16: dup
    //   17: iconst_0
    //   18: ldc 140
    //   20: aastore
    //   21: ldc_w 291
    //   24: iconst_1
    //   25: anewarray 28	java/lang/String
    //   28: dup
    //   29: iconst_0
    //   30: aload_1
    //   31: aastore
    //   32: aconst_null
    //   33: aconst_null
    //   34: aconst_null
    //   35: iconst_2
    //   36: invokeinterface 294 9 0
    //   41: astore_2
    //   42: aload_2
    //   43: ifnull +70 -> 113
    //   46: aload_2
    //   47: astore_1
    //   48: aload_2
    //   49: invokeinterface 138 1 0
    //   54: ifeq +59 -> 113
    //   57: aload_2
    //   58: astore_1
    //   59: aload_2
    //   60: aload_2
    //   61: ldc 140
    //   63: invokeinterface 144 2 0
    //   68: invokeinterface 148 2 0
    //   73: astore_3
    //   74: aload_2
    //   75: astore_1
    //   76: ldc 179
    //   78: ldc_w 296
    //   81: iconst_1
    //   82: anewarray 183	java/lang/Object
    //   85: dup
    //   86: iconst_0
    //   87: aload_3
    //   88: invokestatic 205	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   91: aastore
    //   92: invokestatic 207	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   95: aload_2
    //   96: ifnull +9 -> 105
    //   99: aload_2
    //   100: invokeinterface 171 1 0
    //   105: sipush 29046
    //   108: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   111: aload_3
    //   112: areturn
    //   113: aload_2
    //   114: ifnull +9 -> 123
    //   117: aload_2
    //   118: invokeinterface 171 1 0
    //   123: sipush 29046
    //   126: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   129: aconst_null
    //   130: areturn
    //   131: astore_3
    //   132: aconst_null
    //   133: astore_2
    //   134: aload_2
    //   135: astore_1
    //   136: ldc 179
    //   138: ldc_w 298
    //   141: iconst_1
    //   142: anewarray 183	java/lang/Object
    //   145: dup
    //   146: iconst_0
    //   147: aload_3
    //   148: invokevirtual 184	java/lang/Exception:toString	()Ljava/lang/String;
    //   151: aastore
    //   152: invokestatic 190	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   155: aload_2
    //   156: ifnull -33 -> 123
    //   159: aload_2
    //   160: invokeinterface 171 1 0
    //   165: goto -42 -> 123
    //   168: astore_2
    //   169: aconst_null
    //   170: astore_1
    //   171: aload_1
    //   172: ifnull +9 -> 181
    //   175: aload_1
    //   176: invokeinterface 171 1 0
    //   181: sipush 29046
    //   184: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   187: aload_2
    //   188: athrow
    //   189: astore_2
    //   190: goto -19 -> 171
    //   193: astore_3
    //   194: goto -60 -> 134
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	197	0	this	ai
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
  public final String RO(String paramString)
  {
    // Byte code:
    //   0: sipush 29047
    //   3: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 60	com/tencent/mm/storage/ai:db	Lcom/tencent/mm/sdk/e/e;
    //   10: ldc 36
    //   12: iconst_1
    //   13: anewarray 28	java/lang/String
    //   16: dup
    //   17: iconst_0
    //   18: ldc 209
    //   20: aastore
    //   21: ldc_w 301
    //   24: iconst_1
    //   25: anewarray 28	java/lang/String
    //   28: dup
    //   29: iconst_0
    //   30: aload_1
    //   31: aastore
    //   32: aconst_null
    //   33: aconst_null
    //   34: aconst_null
    //   35: iconst_2
    //   36: invokeinterface 294 9 0
    //   41: astore_2
    //   42: aload_2
    //   43: ifnull +70 -> 113
    //   46: aload_2
    //   47: astore_1
    //   48: aload_2
    //   49: invokeinterface 138 1 0
    //   54: ifeq +59 -> 113
    //   57: aload_2
    //   58: astore_1
    //   59: aload_2
    //   60: aload_2
    //   61: ldc 209
    //   63: invokeinterface 144 2 0
    //   68: invokeinterface 148 2 0
    //   73: astore_3
    //   74: aload_2
    //   75: astore_1
    //   76: ldc 179
    //   78: ldc_w 303
    //   81: iconst_1
    //   82: anewarray 183	java/lang/Object
    //   85: dup
    //   86: iconst_0
    //   87: aload_3
    //   88: invokestatic 205	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   91: aastore
    //   92: invokestatic 207	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   95: aload_2
    //   96: ifnull +9 -> 105
    //   99: aload_2
    //   100: invokeinterface 171 1 0
    //   105: sipush 29047
    //   108: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   111: aload_3
    //   112: areturn
    //   113: aload_2
    //   114: ifnull +9 -> 123
    //   117: aload_2
    //   118: invokeinterface 171 1 0
    //   123: sipush 29047
    //   126: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   129: aconst_null
    //   130: areturn
    //   131: astore_3
    //   132: aconst_null
    //   133: astore_2
    //   134: aload_2
    //   135: astore_1
    //   136: ldc 179
    //   138: ldc_w 305
    //   141: iconst_1
    //   142: anewarray 183	java/lang/Object
    //   145: dup
    //   146: iconst_0
    //   147: aload_3
    //   148: invokevirtual 184	java/lang/Exception:toString	()Ljava/lang/String;
    //   151: aastore
    //   152: invokestatic 190	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   155: aload_2
    //   156: ifnull -33 -> 123
    //   159: aload_2
    //   160: invokeinterface 171 1 0
    //   165: goto -42 -> 123
    //   168: astore_2
    //   169: aconst_null
    //   170: astore_1
    //   171: aload_1
    //   172: ifnull +9 -> 181
    //   175: aload_1
    //   176: invokeinterface 171 1 0
    //   181: sipush 29047
    //   184: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   187: aload_2
    //   188: athrow
    //   189: astore_2
    //   190: goto -19 -> 171
    //   193: astore_3
    //   194: goto -60 -> 134
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	197	0	this	ai
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
  
  public final int a(g paramg)
  {
    this.db = paramg;
    return 0;
  }
  
  public final boolean a(af paramaf, String... paramVarArgs)
  {
    AppMethodBeat.i(29042);
    boolean bool = a(true, paramaf, paramVarArgs);
    AppMethodBeat.o(29042);
    return bool;
  }
  
  public final void ahN()
  {
    AppMethodBeat.i(29033);
    ab.v("MicroMsg.Label.ContactLabelStorage", "cleanCache %s", new Object[] { bo.dtY() });
    this.yMd = null;
    this.yMe = null;
    AppMethodBeat.o(29033);
  }
  
  /* Error */
  public final ArrayList<String> aj(ArrayList<String> paramArrayList)
  {
    // Byte code:
    //   0: sipush 29038
    //   3: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: ifnull +10 -> 17
    //   10: aload_1
    //   11: invokevirtual 279	java/util/ArrayList:size	()I
    //   14: ifgt +11 -> 25
    //   17: sipush 29038
    //   20: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: aconst_null
    //   24: areturn
    //   25: aload_1
    //   26: invokevirtual 279	java/util/ArrayList:size	()I
    //   29: istore_3
    //   30: new 114	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   37: astore 4
    //   39: aload 4
    //   41: ldc_w 322
    //   44: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: aload 4
    //   50: ldc_w 259
    //   53: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: iconst_0
    //   58: istore_2
    //   59: iload_2
    //   60: iload_3
    //   61: if_icmpge +62 -> 123
    //   64: aload 4
    //   66: new 114	java/lang/StringBuilder
    //   69: dup
    //   70: ldc_w 324
    //   73: invokespecial 263	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   76: aload_1
    //   77: iload_2
    //   78: invokevirtual 325	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   81: checkcast 28	java/lang/String
    //   84: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: ldc_w 324
    //   90: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: pop
    //   100: iload_2
    //   101: iload_3
    //   102: iconst_1
    //   103: isub
    //   104: if_icmpge +12 -> 116
    //   107: aload 4
    //   109: ldc_w 265
    //   112: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: pop
    //   116: iload_2
    //   117: iconst_1
    //   118: iadd
    //   119: istore_2
    //   120: goto -61 -> 59
    //   123: aload 4
    //   125: ldc_w 267
    //   128: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: pop
    //   132: aload 4
    //   134: ldc_w 327
    //   137: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: pop
    //   141: aload 4
    //   143: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: astore_1
    //   147: ldc 179
    //   149: ldc_w 329
    //   152: iconst_1
    //   153: anewarray 183	java/lang/Object
    //   156: dup
    //   157: iconst_0
    //   158: aload_1
    //   159: aastore
    //   160: invokestatic 272	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   163: aload_0
    //   164: getfield 60	com/tencent/mm/storage/ai:db	Lcom/tencent/mm/sdk/e/e;
    //   167: aload_1
    //   168: aconst_null
    //   169: iconst_2
    //   170: invokeinterface 132 4 0
    //   175: astore 4
    //   177: aload 4
    //   179: astore_1
    //   180: aload 4
    //   182: ldc 209
    //   184: invokeinterface 144 2 0
    //   189: istore_2
    //   190: aload 4
    //   192: astore_1
    //   193: aload 4
    //   195: invokeinterface 138 1 0
    //   200: ifeq +92 -> 292
    //   203: aload 4
    //   205: astore_1
    //   206: new 72	java/util/ArrayList
    //   209: dup
    //   210: invokespecial 74	java/util/ArrayList:<init>	()V
    //   213: astore 5
    //   215: aload 4
    //   217: astore_1
    //   218: aload 5
    //   220: aload 4
    //   222: iload_2
    //   223: invokeinterface 148 2 0
    //   228: invokevirtual 273	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   231: pop
    //   232: aload 4
    //   234: astore_1
    //   235: aload 4
    //   237: invokeinterface 276 1 0
    //   242: ifne -27 -> 215
    //   245: aload 4
    //   247: astore_1
    //   248: ldc 179
    //   250: ldc_w 331
    //   253: iconst_1
    //   254: anewarray 183	java/lang/Object
    //   257: dup
    //   258: iconst_0
    //   259: aload 5
    //   261: invokevirtual 279	java/util/ArrayList:size	()I
    //   264: invokestatic 284	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   267: aastore
    //   268: invokestatic 272	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   271: aload 4
    //   273: ifnull +10 -> 283
    //   276: aload 4
    //   278: invokeinterface 171 1 0
    //   283: sipush 29038
    //   286: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   289: aload 5
    //   291: areturn
    //   292: aload 4
    //   294: ifnull +10 -> 304
    //   297: aload 4
    //   299: invokeinterface 171 1 0
    //   304: sipush 29038
    //   307: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   310: aconst_null
    //   311: areturn
    //   312: astore 5
    //   314: aconst_null
    //   315: astore 4
    //   317: aload 4
    //   319: astore_1
    //   320: ldc 179
    //   322: ldc_w 333
    //   325: iconst_1
    //   326: anewarray 183	java/lang/Object
    //   329: dup
    //   330: iconst_0
    //   331: aload 5
    //   333: invokevirtual 184	java/lang/Exception:toString	()Ljava/lang/String;
    //   336: aastore
    //   337: invokestatic 190	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   340: aload 4
    //   342: ifnull -38 -> 304
    //   345: aload 4
    //   347: invokeinterface 171 1 0
    //   352: goto -48 -> 304
    //   355: astore 4
    //   357: aconst_null
    //   358: astore_1
    //   359: aload_1
    //   360: ifnull +9 -> 369
    //   363: aload_1
    //   364: invokeinterface 171 1 0
    //   369: sipush 29038
    //   372: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   375: aload 4
    //   377: athrow
    //   378: astore 4
    //   380: goto -21 -> 359
    //   383: astore 5
    //   385: goto -68 -> 317
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	388	0	this	ai
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
  
  public final ArrayList<String> arl(String paramString)
  {
    int i = -1;
    AppMethodBeat.i(29035);
    long l = bo.aoy();
    int j = bo.getInt(paramString, -1);
    if (j == -1)
    {
      ab.e("MicroMsg.Label.ContactLabelStorage", "getUserNameListById  failed id:%s", new Object[] { paramString });
      AppMethodBeat.o(29035);
      return null;
    }
    dwI();
    ArrayList localArrayList = (ArrayList)this.yMe.get(Integer.valueOf(j));
    l = bo.hl(l);
    if (localArrayList == null) {}
    for (;;)
    {
      ab.i("MicroMsg.Label.ContactLabelStorage", "getUserNameListById time:%s id:%s count:%s stack:%s", new Object[] { Long.valueOf(l), paramString, Integer.valueOf(i), bo.dtY() });
      AppMethodBeat.o(29035);
      return localArrayList;
      i = localArrayList.size();
    }
  }
  
  /* Error */
  public final af arm(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: sipush 29048
    //   5: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 60	com/tencent/mm/storage/ai:db	Lcom/tencent/mm/sdk/e/e;
    //   12: ldc 36
    //   14: bipush 6
    //   16: anewarray 28	java/lang/String
    //   19: dup
    //   20: iconst_0
    //   21: ldc 209
    //   23: aastore
    //   24: dup
    //   25: iconst_1
    //   26: ldc_w 373
    //   29: aastore
    //   30: dup
    //   31: iconst_2
    //   32: ldc_w 375
    //   35: aastore
    //   36: dup
    //   37: iconst_3
    //   38: ldc 140
    //   40: aastore
    //   41: dup
    //   42: iconst_4
    //   43: ldc_w 377
    //   46: aastore
    //   47: dup
    //   48: iconst_5
    //   49: ldc_w 379
    //   52: aastore
    //   53: ldc_w 301
    //   56: iconst_1
    //   57: anewarray 28	java/lang/String
    //   60: dup
    //   61: iconst_0
    //   62: aload_1
    //   63: aastore
    //   64: aconst_null
    //   65: aconst_null
    //   66: aconst_null
    //   67: iconst_2
    //   68: invokeinterface 294 9 0
    //   73: astore_1
    //   74: aload_1
    //   75: astore_2
    //   76: aload_2
    //   77: ifnull +49 -> 126
    //   80: aload_2
    //   81: astore_1
    //   82: aload_2
    //   83: invokeinterface 138 1 0
    //   88: ifeq +38 -> 126
    //   91: aload_2
    //   92: astore_1
    //   93: new 30	com/tencent/mm/storage/af
    //   96: dup
    //   97: invokespecial 380	com/tencent/mm/storage/af:<init>	()V
    //   100: astore_3
    //   101: aload_2
    //   102: astore_1
    //   103: aload_3
    //   104: aload_2
    //   105: invokevirtual 384	com/tencent/mm/storage/af:convertFrom	(Landroid/database/Cursor;)V
    //   108: aload_2
    //   109: ifnull +9 -> 118
    //   112: aload_2
    //   113: invokeinterface 171 1 0
    //   118: sipush 29048
    //   121: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   124: aload_3
    //   125: areturn
    //   126: aload_2
    //   127: ifnull +9 -> 136
    //   130: aload_2
    //   131: invokeinterface 171 1 0
    //   136: sipush 29048
    //   139: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   142: aconst_null
    //   143: areturn
    //   144: astore_3
    //   145: aconst_null
    //   146: astore_2
    //   147: aload_2
    //   148: astore_1
    //   149: ldc 179
    //   151: ldc_w 305
    //   154: iconst_1
    //   155: anewarray 183	java/lang/Object
    //   158: dup
    //   159: iconst_0
    //   160: aload_3
    //   161: invokevirtual 184	java/lang/Exception:toString	()Ljava/lang/String;
    //   164: aastore
    //   165: invokestatic 190	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   168: aload_2
    //   169: ifnull -33 -> 136
    //   172: aload_2
    //   173: invokeinterface 171 1 0
    //   178: goto -42 -> 136
    //   181: astore_1
    //   182: aload_2
    //   183: ifnull +9 -> 192
    //   186: aload_2
    //   187: invokeinterface 171 1 0
    //   192: sipush 29048
    //   195: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   0	212	0	this	ai
    //   0	212	1	paramString	String
    //   1	202	2	str	String
    //   100	25	3	localaf	af
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
  public final af arn(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: sipush 29049
    //   5: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 60	com/tencent/mm/storage/ai:db	Lcom/tencent/mm/sdk/e/e;
    //   12: ldc 36
    //   14: bipush 6
    //   16: anewarray 28	java/lang/String
    //   19: dup
    //   20: iconst_0
    //   21: ldc 209
    //   23: aastore
    //   24: dup
    //   25: iconst_1
    //   26: ldc_w 373
    //   29: aastore
    //   30: dup
    //   31: iconst_2
    //   32: ldc_w 375
    //   35: aastore
    //   36: dup
    //   37: iconst_3
    //   38: ldc 140
    //   40: aastore
    //   41: dup
    //   42: iconst_4
    //   43: ldc_w 377
    //   46: aastore
    //   47: dup
    //   48: iconst_5
    //   49: ldc_w 379
    //   52: aastore
    //   53: ldc_w 291
    //   56: iconst_1
    //   57: anewarray 28	java/lang/String
    //   60: dup
    //   61: iconst_0
    //   62: aload_1
    //   63: aastore
    //   64: aconst_null
    //   65: aconst_null
    //   66: aconst_null
    //   67: iconst_2
    //   68: invokeinterface 294 9 0
    //   73: astore_1
    //   74: aload_1
    //   75: astore_2
    //   76: aload_2
    //   77: ifnull +49 -> 126
    //   80: aload_2
    //   81: astore_1
    //   82: aload_2
    //   83: invokeinterface 138 1 0
    //   88: ifeq +38 -> 126
    //   91: aload_2
    //   92: astore_1
    //   93: new 30	com/tencent/mm/storage/af
    //   96: dup
    //   97: invokespecial 380	com/tencent/mm/storage/af:<init>	()V
    //   100: astore_3
    //   101: aload_2
    //   102: astore_1
    //   103: aload_3
    //   104: aload_2
    //   105: invokevirtual 384	com/tencent/mm/storage/af:convertFrom	(Landroid/database/Cursor;)V
    //   108: aload_2
    //   109: ifnull +9 -> 118
    //   112: aload_2
    //   113: invokeinterface 171 1 0
    //   118: sipush 29049
    //   121: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   124: aload_3
    //   125: areturn
    //   126: aload_2
    //   127: ifnull +9 -> 136
    //   130: aload_2
    //   131: invokeinterface 171 1 0
    //   136: sipush 29049
    //   139: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   142: aconst_null
    //   143: areturn
    //   144: astore_3
    //   145: aconst_null
    //   146: astore_2
    //   147: aload_2
    //   148: astore_1
    //   149: ldc 179
    //   151: ldc_w 387
    //   154: iconst_1
    //   155: anewarray 183	java/lang/Object
    //   158: dup
    //   159: iconst_0
    //   160: aload_3
    //   161: invokevirtual 184	java/lang/Exception:toString	()Ljava/lang/String;
    //   164: aastore
    //   165: invokestatic 190	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   168: aload_2
    //   169: ifnull -33 -> 136
    //   172: aload_2
    //   173: invokeinterface 171 1 0
    //   178: goto -42 -> 136
    //   181: astore_1
    //   182: aload_2
    //   183: ifnull +9 -> 192
    //   186: aload_2
    //   187: invokeinterface 171 1 0
    //   192: sipush 29049
    //   195: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   0	212	0	this	ai
    //   0	212	1	paramString	String
    //   1	202	2	str	String
    //   100	25	3	localaf	af
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
  
  public final boolean b(boolean paramBoolean, af paramaf, String... paramVarArgs)
  {
    AppMethodBeat.i(29043);
    boolean bool = super.update(paramaf, paramVarArgs);
    if ((bool) && (paramBoolean)) {
      doNotify(a("update", paramaf));
    }
    ahN();
    AppMethodBeat.o(29043);
    return bool;
  }
  
  public final ArrayList<String> dwG()
  {
    AppMethodBeat.i(29031);
    long l = bo.aoy();
    Cursor localCursor = this.db.a("ContactLabel", new String[] { "labelName" }, null, null, null, null, "createTime ASC ", 2);
    if (localCursor == null)
    {
      AppMethodBeat.o(29031);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    while (localCursor.moveToNext()) {
      localArrayList.add(localCursor.getString(0));
    }
    localCursor.close();
    ab.i("MicroMsg.Label.ContactLabelStorage", "getAllLabel time:%s count:%s stack:%s", new Object[] { Long.valueOf(bo.hl(l)), Integer.valueOf(localArrayList.size()), bo.dtY() });
    AppMethodBeat.o(29031);
    return localArrayList;
  }
  
  public final ArrayList<af> dwH()
  {
    AppMethodBeat.i(29032);
    long l = bo.aoy();
    Cursor localCursor = this.db.a("select * from ContactLabel order by createTime ASC ", null, 2);
    if (localCursor == null)
    {
      AppMethodBeat.o(29032);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    while (localCursor.moveToNext())
    {
      af localaf = new af();
      localaf.convertFrom(localCursor);
      localArrayList.add(localaf);
    }
    localCursor.close();
    ab.i("MicroMsg.Label.ContactLabelStorage", "getAllContactLable time:%s count:%s stack:%s", new Object[] { Long.valueOf(bo.hl(l)), Integer.valueOf(localArrayList.size()), bo.dtY() });
    AppMethodBeat.o(29032);
    return localArrayList;
  }
  
  public final void dwI()
  {
    AppMethodBeat.i(29034);
    if ((this.yMd != null) && (this.yMe != null))
    {
      AppMethodBeat.o(29034);
      return;
    }
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    long l = bo.aoy();
    Object localObject1 = "select username , contactLabelIds from rcontact where (type & " + com.tencent.mm.n.a.NO() + " !=0 ) and ( contactLabelIds != '') ;";
    localObject1 = this.db.a((String)localObject1, null, 2);
    Object localObject2;
    Object localObject3;
    if (localObject1 == null)
    {
      this.yMd = localHashMap1;
      this.yMe = localHashMap2;
      AppMethodBeat.o(29034);
      return;
      localHashMap1.put(localObject2, localObject3);
    }
    while (((Cursor)localObject1).moveToNext())
    {
      localObject2 = ((Cursor)localObject1).getString(0);
      if (!bo.isNullOrNil((String)localObject2))
      {
        String[] arrayOfString = bo.nullAsNil(((Cursor)localObject1).getString(1)).split(",");
        if ((arrayOfString != null) && (arrayOfString.length > 0))
        {
          localObject3 = new int[arrayOfString.length];
          int i = 0;
          label192:
          if (i < arrayOfString.length)
          {
            localObject3[i] = bo.getInt(arrayOfString[i], -1);
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
    ab.i("MicroMsg.Label.ContactLabelStorage", "checkRebuildCache time:%s user:%s label:%s stack:%s", new Object[] { Long.valueOf(bo.hl(l)), Integer.valueOf(localHashMap1.size()), Integer.valueOf(localHashMap2.size()), bo.dtY() });
    this.yMd = localHashMap1;
    this.yMe = localHashMap2;
    AppMethodBeat.o(29034);
  }
  
  public final boolean eA(List<af> paramList)
  {
    AppMethodBeat.i(29055);
    if ((paramList == null) || (paramList.size() <= 0))
    {
      ab.w("MicroMsg.Label.ContactLabelStorage", "cpan[deleteList] list is null.");
      AppMethodBeat.o(29055);
      return false;
    }
    h localh = null;
    long l;
    if ((this.db instanceof h))
    {
      localh = (h)this.db;
      l = localh.kr(Thread.currentThread().getId());
      ab.i("MicroMsg.Label.ContactLabelStorage", "begin deleteList in a transaction, ticket = %d", new Object[] { Long.valueOf(l) });
    }
    for (;;)
    {
      int j = paramList.size();
      int i = 0;
      while (i < j)
      {
        a(false, (af)paramList.get(i), new String[] { "labelID" });
        i += 1;
      }
      if (localh != null)
      {
        localh.nY(l);
        ab.i("MicroMsg.Label.ContactLabelStorage", "end insertOrUpdateList transaction");
      }
      doNotify(y("delete", paramList));
      dwJ();
      AppMethodBeat.o(29055);
      return true;
      l = -1L;
    }
  }
  
  /* Error */
  public final ArrayList<af> eB(List<af> paramList)
  {
    // Byte code:
    //   0: sipush 29056
    //   3: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: invokeinterface 245 1 0
    //   12: ifgt +11 -> 23
    //   15: sipush 29056
    //   18: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aconst_null
    //   22: areturn
    //   23: aload_1
    //   24: invokeinterface 245 1 0
    //   29: istore_3
    //   30: new 114	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   37: astore 4
    //   39: aload 4
    //   41: ldc_w 257
    //   44: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: aload 4
    //   50: ldc_w 469
    //   53: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: iconst_0
    //   58: istore_2
    //   59: iload_2
    //   60: iload_3
    //   61: if_icmpge +67 -> 128
    //   64: aload 4
    //   66: new 114	java/lang/StringBuilder
    //   69: dup
    //   70: ldc_w 261
    //   73: invokespecial 263	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   76: aload_1
    //   77: iload_2
    //   78: invokeinterface 249 2 0
    //   83: checkcast 30	com/tencent/mm/storage/af
    //   86: getfield 119	com/tencent/mm/storage/af:field_labelID	I
    //   89: invokevirtual 123	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   92: ldc_w 261
    //   95: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: pop
    //   105: iload_2
    //   106: iload_3
    //   107: iconst_1
    //   108: isub
    //   109: if_icmpge +12 -> 121
    //   112: aload 4
    //   114: ldc_w 265
    //   117: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: pop
    //   121: iload_2
    //   122: iconst_1
    //   123: iadd
    //   124: istore_2
    //   125: goto -66 -> 59
    //   128: aload 4
    //   130: ldc_w 267
    //   133: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: pop
    //   137: aload 4
    //   139: ldc_w 327
    //   142: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: pop
    //   146: aload 4
    //   148: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   151: astore_1
    //   152: ldc 179
    //   154: ldc_w 471
    //   157: iconst_1
    //   158: anewarray 183	java/lang/Object
    //   161: dup
    //   162: iconst_0
    //   163: aload_1
    //   164: aastore
    //   165: invokestatic 272	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   168: aload_0
    //   169: getfield 60	com/tencent/mm/storage/ai:db	Lcom/tencent/mm/sdk/e/e;
    //   172: aload_1
    //   173: aconst_null
    //   174: iconst_2
    //   175: invokeinterface 132 4 0
    //   180: astore 4
    //   182: aload 4
    //   184: astore_1
    //   185: aload 4
    //   187: invokeinterface 138 1 0
    //   192: ifeq +108 -> 300
    //   195: aload 4
    //   197: astore_1
    //   198: new 72	java/util/ArrayList
    //   201: dup
    //   202: invokespecial 74	java/util/ArrayList:<init>	()V
    //   205: astore 5
    //   207: aload 4
    //   209: astore_1
    //   210: new 30	com/tencent/mm/storage/af
    //   213: dup
    //   214: invokespecial 380	com/tencent/mm/storage/af:<init>	()V
    //   217: astore 6
    //   219: aload 4
    //   221: astore_1
    //   222: aload 6
    //   224: aload 4
    //   226: invokevirtual 384	com/tencent/mm/storage/af:convertFrom	(Landroid/database/Cursor;)V
    //   229: aload 4
    //   231: astore_1
    //   232: aload 5
    //   234: aload 6
    //   236: invokevirtual 273	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   239: pop
    //   240: aload 4
    //   242: astore_1
    //   243: aload 4
    //   245: invokeinterface 276 1 0
    //   250: ifne -43 -> 207
    //   253: aload 4
    //   255: astore_1
    //   256: ldc 179
    //   258: ldc_w 473
    //   261: iconst_1
    //   262: anewarray 183	java/lang/Object
    //   265: dup
    //   266: iconst_0
    //   267: aload 5
    //   269: invokevirtual 279	java/util/ArrayList:size	()I
    //   272: invokestatic 284	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   275: aastore
    //   276: invokestatic 272	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   279: aload 4
    //   281: ifnull +10 -> 291
    //   284: aload 4
    //   286: invokeinterface 171 1 0
    //   291: sipush 29056
    //   294: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   297: aload 5
    //   299: areturn
    //   300: aload 4
    //   302: ifnull +10 -> 312
    //   305: aload 4
    //   307: invokeinterface 171 1 0
    //   312: sipush 29056
    //   315: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   318: aconst_null
    //   319: areturn
    //   320: astore 5
    //   322: aconst_null
    //   323: astore 4
    //   325: aload 4
    //   327: astore_1
    //   328: ldc 179
    //   330: ldc_w 475
    //   333: iconst_1
    //   334: anewarray 183	java/lang/Object
    //   337: dup
    //   338: iconst_0
    //   339: aload 5
    //   341: invokevirtual 184	java/lang/Exception:toString	()Ljava/lang/String;
    //   344: aastore
    //   345: invokestatic 190	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   348: aload 4
    //   350: ifnull -38 -> 312
    //   353: aload 4
    //   355: invokeinterface 171 1 0
    //   360: goto -48 -> 312
    //   363: astore 4
    //   365: aconst_null
    //   366: astore_1
    //   367: aload_1
    //   368: ifnull +9 -> 377
    //   371: aload_1
    //   372: invokeinterface 171 1 0
    //   377: sipush 29056
    //   380: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   383: aload 4
    //   385: athrow
    //   386: astore 4
    //   388: goto -21 -> 367
    //   391: astore 5
    //   393: goto -68 -> 325
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	396	0	this	ai
    //   0	396	1	paramList	List<af>
    //   58	67	2	i	int
    //   29	80	3	j	int
    //   37	317	4	localObject1	Object
    //   363	21	4	localObject2	Object
    //   386	1	4	localObject3	Object
    //   205	93	5	localArrayList	ArrayList
    //   320	20	5	localException1	Exception
    //   391	1	5	localException2	Exception
    //   217	18	6	localaf	af
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
  
  public final boolean ey(List<af> paramList)
  {
    AppMethodBeat.i(29044);
    if (paramList.size() <= 0)
    {
      ab.i("MicroMsg.Label.ContactLabelStorage", "cpan[insertAddLabel] list is null.");
      AppMethodBeat.o(29044);
      return false;
    }
    h localh = null;
    long l;
    if ((this.db instanceof h))
    {
      localh = (h)this.db;
      l = localh.kr(Thread.currentThread().getId());
      ab.i("MicroMsg.Label.ContactLabelStorage", "begin insertOrUpdateList in a transaction, ticket = %d", new Object[] { Long.valueOf(l) });
    }
    for (;;)
    {
      int j = paramList.size();
      new ArrayList();
      int i = 0;
      while (i < j)
      {
        String str = c((af)paramList.get(i));
        if (!bo.isNullOrNil(str)) {
          qD(str);
        }
        i += 1;
      }
      if (localh != null)
      {
        localh.nY(l);
        ab.i("MicroMsg.Label.ContactLabelStorage", "end deleteLocalLabel transaction");
      }
      ahN();
      AppMethodBeat.o(29044);
      return false;
      l = -1L;
    }
  }
  
  public final boolean ez(List<af> paramList)
  {
    AppMethodBeat.i(29045);
    if (paramList.size() <= 0)
    {
      ab.i("MicroMsg.Label.ContactLabelStorage", "cpan[insertOrUpdateList] list is null.");
      AppMethodBeat.o(29045);
      return false;
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    h localh = null;
    long l;
    if ((this.db instanceof h))
    {
      localh = (h)this.db;
      l = localh.kr(Thread.currentThread().getId());
      ab.i("MicroMsg.Label.ContactLabelStorage", "begin insertOrUpdateList in a transaction, ticket = %d", new Object[] { Long.valueOf(l) });
    }
    for (;;)
    {
      int j = paramList.size();
      int i = 0;
      if (i < j)
      {
        af localaf = (af)paramList.get(i);
        if (localaf != null)
        {
          ai.a locala = b(localaf);
          switch (ai.1.yMf[locala.ordinal()])
          {
          default: 
            ab.w("MicroMsg.Label.ContactLabelStorage", "cpan[insertOrUpdateList] unknow result.");
          }
        }
        for (;;)
        {
          i += 1;
          break;
          b(false, localaf, new String[] { "labelID" });
          localArrayList2.add(localaf);
          continue;
          localaf.field_createTime = System.currentTimeMillis();
          a(false, localaf);
          localArrayList1.add(localaf);
        }
      }
      if (localh != null)
      {
        localh.nY(l);
        ab.i("MicroMsg.Label.ContactLabelStorage", "end insertOrUpdateList transaction");
      }
      if (localArrayList1.size() > 0) {
        doNotify(y("insert", localArrayList1));
      }
      if (localArrayList2.size() > 0) {
        doNotify(y("update", localArrayList2));
      }
      ahN();
      AppMethodBeat.o(29045);
      return false;
      l = -1L;
    }
  }
  
  public final boolean qD(String paramString)
  {
    AppMethodBeat.i(29040);
    ab.i("MicroMsg.Label.ContactLabelStorage", "cpan[delete] labelID:%s", new Object[] { String.valueOf(paramString) });
    ab.d("MicroMsg.Label.ContactLabelStorage", "cpan[query] SQL:%s", new Object[] { "labelID =? " });
    try
    {
      i = this.db.delete("ContactLabel", "labelID =? ", new String[] { paramString });
      if (i > 0)
      {
        AppMethodBeat.o(29040);
        return true;
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ab.w("MicroMsg.Label.ContactLabelStorage", "cpan[delete] exception %s", new Object[] { paramString.toString() });
        int i = -1;
      }
      AppMethodBeat.o(29040);
    }
    return false;
  }
  
  /* Error */
  public final ArrayList<String> x(String paramString, List<String> paramList)
  {
    // Byte code:
    //   0: sipush 29036
    //   3: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 179
    //   8: ldc_w 520
    //   11: iconst_1
    //   12: anewarray 183	java/lang/Object
    //   15: dup
    //   16: iconst_0
    //   17: ldc_w 535
    //   20: aastore
    //   21: invokestatic 272	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   24: new 114	java/lang/StringBuilder
    //   27: dup
    //   28: ldc_w 537
    //   31: invokespecial 263	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   34: aload_1
    //   35: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: ldc_w 537
    //   41: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: astore 5
    //   49: new 114	java/lang/StringBuilder
    //   52: dup
    //   53: ldc_w 537
    //   56: invokespecial 263	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   59: aload_1
    //   60: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: ldc_w 537
    //   66: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   72: astore 6
    //   74: new 114	java/lang/StringBuilder
    //   77: dup
    //   78: ldc_w 537
    //   81: invokespecial 263	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   84: aload_1
    //   85: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: ldc_w 537
    //   91: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: astore_1
    //   98: aload_0
    //   99: getfield 60	com/tencent/mm/storage/ai:db	Lcom/tencent/mm/sdk/e/e;
    //   102: ldc_w 535
    //   105: iconst_3
    //   106: anewarray 28	java/lang/String
    //   109: dup
    //   110: iconst_0
    //   111: aload 5
    //   113: aastore
    //   114: dup
    //   115: iconst_1
    //   116: aload 6
    //   118: aastore
    //   119: dup
    //   120: iconst_2
    //   121: aload_1
    //   122: aastore
    //   123: iconst_2
    //   124: invokeinterface 132 4 0
    //   129: astore 5
    //   131: aload 5
    //   133: astore_1
    //   134: aload 5
    //   136: ldc 140
    //   138: invokeinterface 144 2 0
    //   143: istore_3
    //   144: aload 5
    //   146: astore_1
    //   147: aload 5
    //   149: invokeinterface 138 1 0
    //   154: ifeq +107 -> 261
    //   157: aload 5
    //   159: astore_1
    //   160: new 72	java/util/ArrayList
    //   163: dup
    //   164: invokespecial 74	java/util/ArrayList:<init>	()V
    //   167: astore 6
    //   169: aload 5
    //   171: astore_1
    //   172: aload 5
    //   174: iload_3
    //   175: invokeinterface 148 2 0
    //   180: astore 7
    //   182: aload_2
    //   183: ifnull +29 -> 212
    //   186: aload 5
    //   188: astore_1
    //   189: aload_2
    //   190: invokeinterface 245 1 0
    //   195: ifle +17 -> 212
    //   198: aload 5
    //   200: astore_1
    //   201: aload_2
    //   202: aload 7
    //   204: invokeinterface 540 2 0
    //   209: ifne +14 -> 223
    //   212: aload 5
    //   214: astore_1
    //   215: aload 6
    //   217: aload 7
    //   219: invokevirtual 273	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   222: pop
    //   223: aload 5
    //   225: astore_1
    //   226: aload 5
    //   228: invokeinterface 276 1 0
    //   233: istore 4
    //   235: iload 4
    //   237: ifne -68 -> 169
    //   240: aload 5
    //   242: ifnull +10 -> 252
    //   245: aload 5
    //   247: invokeinterface 171 1 0
    //   252: sipush 29036
    //   255: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   258: aload 6
    //   260: areturn
    //   261: aload 5
    //   263: ifnull +10 -> 273
    //   266: aload 5
    //   268: invokeinterface 171 1 0
    //   273: sipush 29036
    //   276: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   279: aconst_null
    //   280: areturn
    //   281: astore_2
    //   282: aconst_null
    //   283: astore 5
    //   285: aload 5
    //   287: astore_1
    //   288: ldc 179
    //   290: ldc_w 542
    //   293: iconst_1
    //   294: anewarray 183	java/lang/Object
    //   297: dup
    //   298: iconst_0
    //   299: aload_2
    //   300: invokevirtual 184	java/lang/Exception:toString	()Ljava/lang/String;
    //   303: aastore
    //   304: invokestatic 190	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   307: aload 5
    //   309: ifnull -36 -> 273
    //   312: aload 5
    //   314: invokeinterface 171 1 0
    //   319: goto -46 -> 273
    //   322: astore_2
    //   323: aconst_null
    //   324: astore_1
    //   325: aload_1
    //   326: ifnull +9 -> 335
    //   329: aload_1
    //   330: invokeinterface 171 1 0
    //   335: sipush 29036
    //   338: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   341: aload_2
    //   342: athrow
    //   343: astore_2
    //   344: goto -19 -> 325
    //   347: astore_2
    //   348: goto -63 -> 285
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	351	0	this	ai
    //   0	351	1	paramString	String
    //   0	351	2	paramList	List<String>
    //   143	32	3	i	int
    //   233	3	4	bool	boolean
    //   47	266	5	localObject1	Object
    //   72	187	6	localObject2	Object
    //   180	38	7	str	String
    // Exception table:
    //   from	to	target	type
    //   98	131	281	java/lang/Exception
    //   98	131	322	finally
    //   134	144	343	finally
    //   147	157	343	finally
    //   160	169	343	finally
    //   172	182	343	finally
    //   189	198	343	finally
    //   201	212	343	finally
    //   215	223	343	finally
    //   226	235	343	finally
    //   288	307	343	finally
    //   134	144	347	java/lang/Exception
    //   147	157	347	java/lang/Exception
    //   160	169	347	java/lang/Exception
    //   172	182	347	java/lang/Exception
    //   189	198	347	java/lang/Exception
    //   201	212	347	java/lang/Exception
    //   215	223	347	java/lang/Exception
    //   226	235	347	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.storage.ai
 * JD-Core Version:    0.7.0.1
 */