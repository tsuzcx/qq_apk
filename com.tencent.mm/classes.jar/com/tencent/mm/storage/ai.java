package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.mm.cf.g;
import com.tencent.mm.cf.g.a;
import com.tencent.mm.cf.h;
import com.tencent.mm.h.a.sq;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class ai
  extends i<af>
  implements g.a
{
  public static final String[] dXp = { i.a(af.buS, "ContactLabel") };
  private e dXw;
  private HashMap<String, int[]> uzU = null;
  public HashMap<Integer, ArrayList<String>> uzV = null;
  
  public ai(e parame)
  {
    this(parame, af.buS, "ContactLabel");
  }
  
  private ai(e parame, c.a parama, String paramString)
  {
    super(parame, parama, paramString, null);
    this.dXw = parame;
    parame.gk("ContactLabel", "CREATE INDEX IF NOT EXISTS  contact_label_createtime_index ON ContactLabel ( createTime )");
  }
  
  private static String a(String paramString, af paramaf)
  {
    if (paramaf != null)
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramaf);
      return v(paramString, localArrayList);
    }
    return null;
  }
  
  private boolean a(boolean paramBoolean, af paramaf)
  {
    boolean bool = super.b(paramaf);
    if ((bool) && (paramBoolean)) {
      aam(a("insert", paramaf));
    }
    return bool;
  }
  
  private ai.a b(af paramaf)
  {
    localObject2 = null;
    localObject1 = null;
    Object localObject3 = paramaf.field_labelID;
    try
    {
      localObject3 = this.dXw.a("select * from ContactLabel where labelID=?", new String[] { localObject3 }, 2);
      if (localObject3 != null)
      {
        localObject1 = localObject3;
        localObject2 = localObject3;
        if (((Cursor)localObject3).moveToFirst())
        {
          localObject1 = localObject3;
          localObject2 = localObject3;
          Object localObject4 = bk.aM(((Cursor)localObject3).getString(((Cursor)localObject3).getColumnIndex("labelName")), "");
          localObject1 = localObject3;
          localObject2 = localObject3;
          if (paramaf.field_labelName.equalsIgnoreCase((String)localObject4))
          {
            localObject1 = localObject3;
            localObject2 = localObject3;
            localObject4 = ai.a.uzX;
            paramaf = (af)localObject4;
            if (localObject3 != null)
            {
              ((Cursor)localObject3).close();
              paramaf = (af)localObject4;
            }
          }
          do
          {
            return paramaf;
            localObject1 = localObject3;
            localObject2 = localObject3;
            localObject4 = ai.a.uzY;
            paramaf = (af)localObject4;
          } while (localObject3 == null);
          ((Cursor)localObject3).close();
          return localObject4;
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
        y.w("MicroMsg.Label.ContactLabelStorage", "cpan[checkEqualsName] exception %s", new Object[] { paramaf.toString() });
        if (localObject1 != null) {
          localObject1.close();
        }
      }
    }
    finally
    {
      if (localObject2 == null) {
        break label235;
      }
      localObject2.close();
    }
    return ai.a.uzZ;
  }
  
  /* Error */
  private String c(af paramaf)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: new 92	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   10: aload_1
    //   11: getfield 138	com/tencent/mm/storage/af:field_labelName	Ljava/lang/String;
    //   14: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   20: astore_3
    //   21: aload_0
    //   22: getfield 51	com/tencent/mm/storage/ai:dXw	Lcom/tencent/mm/sdk/e/e;
    //   25: ldc 175
    //   27: iconst_2
    //   28: anewarray 22	java/lang/String
    //   31: dup
    //   32: iconst_0
    //   33: aload_3
    //   34: aastore
    //   35: dup
    //   36: iconst_1
    //   37: ldc 177
    //   39: aastore
    //   40: iconst_2
    //   41: invokeinterface 110 4 0
    //   46: astore 4
    //   48: aload 4
    //   50: ifnull +138 -> 188
    //   53: aload 4
    //   55: astore_3
    //   56: aload 4
    //   58: invokeinterface 116 1 0
    //   63: ifeq +125 -> 188
    //   66: aload 4
    //   68: astore_3
    //   69: aload 4
    //   71: aload 4
    //   73: ldc 118
    //   75: invokeinterface 122 2 0
    //   80: invokeinterface 126 2 0
    //   85: ldc 128
    //   87: invokestatic 134	com/tencent/mm/sdk/platformtools/bk:aM	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   90: astore 6
    //   92: aload 4
    //   94: astore_3
    //   95: aload_1
    //   96: getfield 138	com/tencent/mm/storage/af:field_labelName	Ljava/lang/String;
    //   99: aload 6
    //   101: invokevirtual 142	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   104: istore_2
    //   105: aload 4
    //   107: astore_3
    //   108: ldc 157
    //   110: ldc 179
    //   112: iconst_2
    //   113: anewarray 161	java/lang/Object
    //   116: dup
    //   117: iconst_0
    //   118: new 92	java/lang/StringBuilder
    //   121: dup
    //   122: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   125: aload_1
    //   126: getfield 138	com/tencent/mm/storage/af:field_labelName	Ljava/lang/String;
    //   129: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: aastore
    //   136: dup
    //   137: iconst_1
    //   138: aload 6
    //   140: aastore
    //   141: invokestatic 182	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   144: iload_2
    //   145: ifeq +43 -> 188
    //   148: aload 4
    //   150: astore_3
    //   151: aload 4
    //   153: aload 4
    //   155: ldc 184
    //   157: invokeinterface 122 2 0
    //   162: invokeinterface 126 2 0
    //   167: astore_1
    //   168: aload_1
    //   169: astore_3
    //   170: aload_3
    //   171: astore_1
    //   172: aload 4
    //   174: ifnull +12 -> 186
    //   177: aload 4
    //   179: invokeinterface 149 1 0
    //   184: aload_3
    //   185: astore_1
    //   186: aload_1
    //   187: areturn
    //   188: aload 5
    //   190: astore_1
    //   191: aload 4
    //   193: ifnull -7 -> 186
    //   196: aload 4
    //   198: invokeinterface 149 1 0
    //   203: aconst_null
    //   204: areturn
    //   205: astore_1
    //   206: aconst_null
    //   207: astore 4
    //   209: aload 4
    //   211: astore_3
    //   212: ldc 157
    //   214: ldc 159
    //   216: iconst_1
    //   217: anewarray 161	java/lang/Object
    //   220: dup
    //   221: iconst_0
    //   222: aload_1
    //   223: invokevirtual 162	java/lang/Exception:toString	()Ljava/lang/String;
    //   226: aastore
    //   227: invokestatic 168	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   230: aload 5
    //   232: astore_1
    //   233: aload 4
    //   235: ifnull -49 -> 186
    //   238: aload 4
    //   240: invokeinterface 149 1 0
    //   245: aconst_null
    //   246: areturn
    //   247: astore_1
    //   248: aconst_null
    //   249: astore_3
    //   250: aload_3
    //   251: ifnull +9 -> 260
    //   254: aload_3
    //   255: invokeinterface 149 1 0
    //   260: aload_1
    //   261: athrow
    //   262: astore_1
    //   263: goto -13 -> 250
    //   266: astore_1
    //   267: goto -58 -> 209
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	270	0	this	ai
    //   0	270	1	paramaf	af
    //   104	41	2	bool	boolean
    //   20	235	3	localObject1	Object
    //   46	193	4	localCursor	Cursor
    //   1	230	5	localObject2	Object
    //   90	49	6	str	String
    // Exception table:
    //   from	to	target	type
    //   21	48	205	java/lang/Exception
    //   21	48	247	finally
    //   56	66	262	finally
    //   69	92	262	finally
    //   95	105	262	finally
    //   108	144	262	finally
    //   151	168	262	finally
    //   212	230	262	finally
    //   56	66	266	java/lang/Exception
    //   69	92	266	java/lang/Exception
    //   95	105	266	java/lang/Exception
    //   108	144	266	java/lang/Exception
    //   151	168	266	java/lang/Exception
  }
  
  private static void cuk()
  {
    y.i("MicroMsg.Label.ContactLabelStorage", "cpan[publishUpdateSearchIndexEvent]");
    sq localsq = new sq();
    localsq.cci.brn = 3000L;
    com.tencent.mm.sdk.b.a.udP.m(localsq);
  }
  
  private static String v(String paramString, List<af> paramList)
  {
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
      y.i("MicroMsg.Label.ContactLabelStorage", "cpan[genNotifyString] event:%s", new Object[] { localStringBuilder.toString() });
      return localStringBuilder.toString();
    }
    return null;
  }
  
  /* Error */
  public final String Gk(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 51	com/tencent/mm/storage/ai:dXw	Lcom/tencent/mm/sdk/e/e;
    //   4: ldc 30
    //   6: iconst_1
    //   7: anewarray 22	java/lang/String
    //   10: dup
    //   11: iconst_0
    //   12: ldc 118
    //   14: aastore
    //   15: ldc 233
    //   17: iconst_1
    //   18: anewarray 22	java/lang/String
    //   21: dup
    //   22: iconst_0
    //   23: aload_1
    //   24: aastore
    //   25: aconst_null
    //   26: aconst_null
    //   27: aconst_null
    //   28: iconst_2
    //   29: invokeinterface 236 9 0
    //   34: astore_2
    //   35: aload_2
    //   36: ifnull +60 -> 96
    //   39: aload_2
    //   40: astore_1
    //   41: aload_2
    //   42: invokeinterface 116 1 0
    //   47: ifeq +49 -> 96
    //   50: aload_2
    //   51: astore_1
    //   52: aload_2
    //   53: aload_2
    //   54: ldc 118
    //   56: invokeinterface 122 2 0
    //   61: invokeinterface 126 2 0
    //   66: astore_3
    //   67: aload_2
    //   68: astore_1
    //   69: ldc 157
    //   71: ldc 238
    //   73: iconst_1
    //   74: anewarray 161	java/lang/Object
    //   77: dup
    //   78: iconst_0
    //   79: aload_3
    //   80: aastore
    //   81: invokestatic 182	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   84: aload_2
    //   85: ifnull +9 -> 94
    //   88: aload_2
    //   89: invokeinterface 149 1 0
    //   94: aload_3
    //   95: areturn
    //   96: aload_2
    //   97: ifnull +9 -> 106
    //   100: aload_2
    //   101: invokeinterface 149 1 0
    //   106: aconst_null
    //   107: areturn
    //   108: astore_3
    //   109: aconst_null
    //   110: astore_2
    //   111: aload_2
    //   112: astore_1
    //   113: ldc 157
    //   115: ldc 240
    //   117: iconst_1
    //   118: anewarray 161	java/lang/Object
    //   121: dup
    //   122: iconst_0
    //   123: aload_3
    //   124: invokevirtual 162	java/lang/Exception:toString	()Ljava/lang/String;
    //   127: aastore
    //   128: invokestatic 168	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   131: aload_2
    //   132: ifnull -26 -> 106
    //   135: aload_2
    //   136: invokeinterface 149 1 0
    //   141: goto -35 -> 106
    //   144: astore_2
    //   145: aconst_null
    //   146: astore_1
    //   147: aload_1
    //   148: ifnull +9 -> 157
    //   151: aload_1
    //   152: invokeinterface 149 1 0
    //   157: aload_2
    //   158: athrow
    //   159: astore_2
    //   160: goto -13 -> 147
    //   163: astore_3
    //   164: goto -53 -> 111
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	167	0	this	ai
    //   0	167	1	paramString	String
    //   34	102	2	localCursor	Cursor
    //   144	14	2	localObject1	Object
    //   159	1	2	localObject2	Object
    //   66	29	3	str	String
    //   108	16	3	localException1	Exception
    //   163	1	3	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   0	35	108	java/lang/Exception
    //   0	35	144	finally
    //   41	50	159	finally
    //   52	67	159	finally
    //   69	84	159	finally
    //   113	131	159	finally
    //   41	50	163	java/lang/Exception
    //   52	67	163	java/lang/Exception
    //   69	84	163	java/lang/Exception
  }
  
  /* Error */
  public final String Gl(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 51	com/tencent/mm/storage/ai:dXw	Lcom/tencent/mm/sdk/e/e;
    //   4: ldc 30
    //   6: iconst_1
    //   7: anewarray 22	java/lang/String
    //   10: dup
    //   11: iconst_0
    //   12: ldc 184
    //   14: aastore
    //   15: ldc 243
    //   17: iconst_1
    //   18: anewarray 22	java/lang/String
    //   21: dup
    //   22: iconst_0
    //   23: aload_1
    //   24: aastore
    //   25: aconst_null
    //   26: aconst_null
    //   27: aconst_null
    //   28: iconst_2
    //   29: invokeinterface 236 9 0
    //   34: astore_2
    //   35: aload_2
    //   36: ifnull +60 -> 96
    //   39: aload_2
    //   40: astore_1
    //   41: aload_2
    //   42: invokeinterface 116 1 0
    //   47: ifeq +49 -> 96
    //   50: aload_2
    //   51: astore_1
    //   52: aload_2
    //   53: aload_2
    //   54: ldc 184
    //   56: invokeinterface 122 2 0
    //   61: invokeinterface 126 2 0
    //   66: astore_3
    //   67: aload_2
    //   68: astore_1
    //   69: ldc 157
    //   71: ldc 245
    //   73: iconst_1
    //   74: anewarray 161	java/lang/Object
    //   77: dup
    //   78: iconst_0
    //   79: aload_3
    //   80: aastore
    //   81: invokestatic 182	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   84: aload_2
    //   85: ifnull +9 -> 94
    //   88: aload_2
    //   89: invokeinterface 149 1 0
    //   94: aload_3
    //   95: areturn
    //   96: aload_2
    //   97: ifnull +9 -> 106
    //   100: aload_2
    //   101: invokeinterface 149 1 0
    //   106: aconst_null
    //   107: areturn
    //   108: astore_3
    //   109: aconst_null
    //   110: astore_2
    //   111: aload_2
    //   112: astore_1
    //   113: ldc 157
    //   115: ldc 247
    //   117: iconst_1
    //   118: anewarray 161	java/lang/Object
    //   121: dup
    //   122: iconst_0
    //   123: aload_3
    //   124: invokevirtual 162	java/lang/Exception:toString	()Ljava/lang/String;
    //   127: aastore
    //   128: invokestatic 168	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   131: aload_2
    //   132: ifnull -26 -> 106
    //   135: aload_2
    //   136: invokeinterface 149 1 0
    //   141: goto -35 -> 106
    //   144: astore_2
    //   145: aconst_null
    //   146: astore_1
    //   147: aload_1
    //   148: ifnull +9 -> 157
    //   151: aload_1
    //   152: invokeinterface 149 1 0
    //   157: aload_2
    //   158: athrow
    //   159: astore_2
    //   160: goto -13 -> 147
    //   163: astore_3
    //   164: goto -53 -> 111
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	167	0	this	ai
    //   0	167	1	paramString	String
    //   34	102	2	localCursor	Cursor
    //   144	14	2	localObject1	Object
    //   159	1	2	localObject2	Object
    //   66	29	3	str	String
    //   108	16	3	localException1	Exception
    //   163	1	3	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   0	35	108	java/lang/Exception
    //   0	35	144	finally
    //   41	50	159	finally
    //   52	67	159	finally
    //   69	84	159	finally
    //   113	131	159	finally
    //   41	50	163	java/lang/Exception
    //   52	67	163	java/lang/Exception
    //   69	84	163	java/lang/Exception
  }
  
  /* Error */
  public final ArrayList<String> I(String[] paramArrayOfString)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +8 -> 9
    //   4: aload_1
    //   5: arraylength
    //   6: ifgt +7 -> 13
    //   9: aconst_null
    //   10: astore_1
    //   11: aload_1
    //   12: areturn
    //   13: aload_1
    //   14: arraylength
    //   15: istore_3
    //   16: new 92	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   23: astore 4
    //   25: aload 4
    //   27: ldc 250
    //   29: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: pop
    //   33: aload 4
    //   35: ldc 252
    //   37: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: iconst_0
    //   42: istore_2
    //   43: iload_2
    //   44: iload_3
    //   45: if_icmpge +55 -> 100
    //   48: aload 4
    //   50: new 92	java/lang/StringBuilder
    //   53: dup
    //   54: ldc 254
    //   56: invokespecial 256	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   59: aload_1
    //   60: iload_2
    //   61: aaload
    //   62: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: ldc 254
    //   67: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: iload_2
    //   78: iload_3
    //   79: iconst_1
    //   80: isub
    //   81: if_icmpge +12 -> 93
    //   84: aload 4
    //   86: ldc_w 258
    //   89: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: pop
    //   93: iload_2
    //   94: iconst_1
    //   95: iadd
    //   96: istore_2
    //   97: goto -54 -> 43
    //   100: aload 4
    //   102: ldc_w 260
    //   105: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: pop
    //   109: aload 4
    //   111: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   114: astore_1
    //   115: ldc 157
    //   117: ldc_w 262
    //   120: iconst_1
    //   121: anewarray 161	java/lang/Object
    //   124: dup
    //   125: iconst_0
    //   126: aload_1
    //   127: aastore
    //   128: invokestatic 265	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   131: aload_0
    //   132: getfield 51	com/tencent/mm/storage/ai:dXw	Lcom/tencent/mm/sdk/e/e;
    //   135: aload_1
    //   136: aconst_null
    //   137: iconst_2
    //   138: invokeinterface 110 4 0
    //   143: astore 4
    //   145: aload 4
    //   147: astore_1
    //   148: aload 4
    //   150: ldc 118
    //   152: invokeinterface 122 2 0
    //   157: istore_2
    //   158: aload 4
    //   160: astore_1
    //   161: aload 4
    //   163: invokeinterface 116 1 0
    //   168: ifeq +89 -> 257
    //   171: aload 4
    //   173: astore_1
    //   174: new 62	java/util/ArrayList
    //   177: dup
    //   178: invokespecial 64	java/util/ArrayList:<init>	()V
    //   181: astore 5
    //   183: aload 4
    //   185: astore_1
    //   186: aload 5
    //   188: aload 4
    //   190: iload_2
    //   191: invokeinterface 126 2 0
    //   196: invokevirtual 266	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   199: pop
    //   200: aload 4
    //   202: astore_1
    //   203: aload 4
    //   205: invokeinterface 269 1 0
    //   210: ifne -27 -> 183
    //   213: aload 4
    //   215: astore_1
    //   216: ldc 157
    //   218: ldc_w 271
    //   221: iconst_1
    //   222: anewarray 161	java/lang/Object
    //   225: dup
    //   226: iconst_0
    //   227: aload 5
    //   229: invokevirtual 272	java/util/ArrayList:size	()I
    //   232: invokestatic 278	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   235: aastore
    //   236: invokestatic 265	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   239: aload 5
    //   241: astore_1
    //   242: aload 4
    //   244: ifnull -233 -> 11
    //   247: aload 4
    //   249: invokeinterface 149 1 0
    //   254: aload 5
    //   256: areturn
    //   257: aload 4
    //   259: ifnull +10 -> 269
    //   262: aload 4
    //   264: invokeinterface 149 1 0
    //   269: aconst_null
    //   270: areturn
    //   271: astore 5
    //   273: aconst_null
    //   274: astore 4
    //   276: aload 4
    //   278: astore_1
    //   279: ldc 157
    //   281: ldc_w 280
    //   284: iconst_1
    //   285: anewarray 161	java/lang/Object
    //   288: dup
    //   289: iconst_0
    //   290: aload 5
    //   292: invokevirtual 162	java/lang/Exception:toString	()Ljava/lang/String;
    //   295: aastore
    //   296: invokestatic 168	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   299: aload 4
    //   301: ifnull -32 -> 269
    //   304: aload 4
    //   306: invokeinterface 149 1 0
    //   311: goto -42 -> 269
    //   314: astore 4
    //   316: aconst_null
    //   317: astore_1
    //   318: aload_1
    //   319: ifnull +9 -> 328
    //   322: aload_1
    //   323: invokeinterface 149 1 0
    //   328: aload 4
    //   330: athrow
    //   331: astore 4
    //   333: goto -15 -> 318
    //   336: astore 5
    //   338: goto -62 -> 276
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	341	0	this	ai
    //   0	341	1	paramArrayOfString	String[]
    //   42	149	2	i	int
    //   15	66	3	j	int
    //   23	282	4	localObject1	Object
    //   314	15	4	localObject2	Object
    //   331	1	4	localObject3	Object
    //   181	74	5	localArrayList	ArrayList
    //   271	20	5	localException1	Exception
    //   336	1	5	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   131	145	271	java/lang/Exception
    //   131	145	314	finally
    //   148	158	331	finally
    //   161	171	331	finally
    //   174	183	331	finally
    //   186	200	331	finally
    //   203	213	331	finally
    //   216	239	331	finally
    //   279	299	331	finally
    //   148	158	336	java/lang/Exception
    //   161	171	336	java/lang/Exception
    //   174	183	336	java/lang/Exception
    //   186	200	336	java/lang/Exception
    //   203	213	336	java/lang/Exception
    //   216	239	336	java/lang/Exception
  }
  
  public final int a(g paramg)
  {
    if (paramg != null) {
      this.dXw = paramg;
    }
    return 0;
  }
  
  public final boolean a(boolean paramBoolean, af paramaf, String... paramVarArgs)
  {
    boolean bool = super.a(paramaf, paramVarArgs);
    if ((bool) && (paramBoolean))
    {
      aam(a("delete", paramaf));
      cuk();
    }
    bdu();
    return bool;
  }
  
  public final ArrayList<String> aba(String paramString)
  {
    int i = -1;
    long l = bk.UY();
    int j = bk.getInt(paramString, -1);
    if (j == -1)
    {
      y.e("MicroMsg.Label.ContactLabelStorage", "getUserNameListById  failed id:%s", new Object[] { paramString });
      return null;
    }
    cuj();
    ArrayList localArrayList = (ArrayList)this.uzV.get(Integer.valueOf(j));
    l = bk.co(l);
    if (localArrayList == null) {}
    for (;;)
    {
      y.i("MicroMsg.Label.ContactLabelStorage", "getUserNameListById time:%s id:%s count:%s stack:%s", new Object[] { Long.valueOf(l), paramString, Integer.valueOf(i), bk.csb() });
      return localArrayList;
      i = localArrayList.size();
    }
  }
  
  /* Error */
  public final af abb(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: getfield 51	com/tencent/mm/storage/ai:dXw	Lcom/tencent/mm/sdk/e/e;
    //   6: ldc 30
    //   8: bipush 6
    //   10: anewarray 22	java/lang/String
    //   13: dup
    //   14: iconst_0
    //   15: ldc 184
    //   17: aastore
    //   18: dup
    //   19: iconst_1
    //   20: ldc_w 342
    //   23: aastore
    //   24: dup
    //   25: iconst_2
    //   26: ldc_w 344
    //   29: aastore
    //   30: dup
    //   31: iconst_3
    //   32: ldc 118
    //   34: aastore
    //   35: dup
    //   36: iconst_4
    //   37: ldc_w 346
    //   40: aastore
    //   41: dup
    //   42: iconst_5
    //   43: ldc_w 348
    //   46: aastore
    //   47: ldc 243
    //   49: iconst_1
    //   50: anewarray 22	java/lang/String
    //   53: dup
    //   54: iconst_0
    //   55: aload_1
    //   56: aastore
    //   57: aconst_null
    //   58: aconst_null
    //   59: aconst_null
    //   60: iconst_2
    //   61: invokeinterface 236 9 0
    //   66: astore_1
    //   67: aload_1
    //   68: astore_2
    //   69: aload_2
    //   70: ifnull +43 -> 113
    //   73: aload_2
    //   74: astore_1
    //   75: aload_2
    //   76: invokeinterface 116 1 0
    //   81: ifeq +32 -> 113
    //   84: aload_2
    //   85: astore_1
    //   86: new 24	com/tencent/mm/storage/af
    //   89: dup
    //   90: invokespecial 349	com/tencent/mm/storage/af:<init>	()V
    //   93: astore_3
    //   94: aload_2
    //   95: astore_1
    //   96: aload_3
    //   97: aload_2
    //   98: invokevirtual 352	com/tencent/mm/storage/af:d	(Landroid/database/Cursor;)V
    //   101: aload_2
    //   102: ifnull +9 -> 111
    //   105: aload_2
    //   106: invokeinterface 149 1 0
    //   111: aload_3
    //   112: areturn
    //   113: aload_2
    //   114: ifnull +9 -> 123
    //   117: aload_2
    //   118: invokeinterface 149 1 0
    //   123: aconst_null
    //   124: areturn
    //   125: astore_3
    //   126: aconst_null
    //   127: astore_2
    //   128: aload_2
    //   129: astore_1
    //   130: ldc 157
    //   132: ldc 247
    //   134: iconst_1
    //   135: anewarray 161	java/lang/Object
    //   138: dup
    //   139: iconst_0
    //   140: aload_3
    //   141: invokevirtual 162	java/lang/Exception:toString	()Ljava/lang/String;
    //   144: aastore
    //   145: invokestatic 168	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   148: aload_2
    //   149: ifnull -26 -> 123
    //   152: aload_2
    //   153: invokeinterface 149 1 0
    //   158: goto -35 -> 123
    //   161: astore_1
    //   162: aload_2
    //   163: ifnull +9 -> 172
    //   166: aload_2
    //   167: invokeinterface 149 1 0
    //   172: aload_1
    //   173: athrow
    //   174: astore_3
    //   175: aload_1
    //   176: astore_2
    //   177: aload_3
    //   178: astore_1
    //   179: goto -17 -> 162
    //   182: astore_3
    //   183: goto -55 -> 128
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	186	0	this	ai
    //   0	186	1	paramString	String
    //   1	176	2	str	String
    //   93	19	3	localaf	af
    //   125	16	3	localException1	Exception
    //   174	4	3	localObject	Object
    //   182	1	3	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   2	67	125	java/lang/Exception
    //   2	67	161	finally
    //   75	84	174	finally
    //   86	94	174	finally
    //   96	101	174	finally
    //   130	148	174	finally
    //   75	84	182	java/lang/Exception
    //   86	94	182	java/lang/Exception
    //   96	101	182	java/lang/Exception
  }
  
  /* Error */
  public final af abc(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: getfield 51	com/tencent/mm/storage/ai:dXw	Lcom/tencent/mm/sdk/e/e;
    //   6: ldc 30
    //   8: bipush 6
    //   10: anewarray 22	java/lang/String
    //   13: dup
    //   14: iconst_0
    //   15: ldc 184
    //   17: aastore
    //   18: dup
    //   19: iconst_1
    //   20: ldc_w 342
    //   23: aastore
    //   24: dup
    //   25: iconst_2
    //   26: ldc_w 344
    //   29: aastore
    //   30: dup
    //   31: iconst_3
    //   32: ldc 118
    //   34: aastore
    //   35: dup
    //   36: iconst_4
    //   37: ldc_w 346
    //   40: aastore
    //   41: dup
    //   42: iconst_5
    //   43: ldc_w 348
    //   46: aastore
    //   47: ldc 233
    //   49: iconst_1
    //   50: anewarray 22	java/lang/String
    //   53: dup
    //   54: iconst_0
    //   55: aload_1
    //   56: aastore
    //   57: aconst_null
    //   58: aconst_null
    //   59: aconst_null
    //   60: iconst_2
    //   61: invokeinterface 236 9 0
    //   66: astore_1
    //   67: aload_1
    //   68: astore_2
    //   69: aload_2
    //   70: ifnull +43 -> 113
    //   73: aload_2
    //   74: astore_1
    //   75: aload_2
    //   76: invokeinterface 116 1 0
    //   81: ifeq +32 -> 113
    //   84: aload_2
    //   85: astore_1
    //   86: new 24	com/tencent/mm/storage/af
    //   89: dup
    //   90: invokespecial 349	com/tencent/mm/storage/af:<init>	()V
    //   93: astore_3
    //   94: aload_2
    //   95: astore_1
    //   96: aload_3
    //   97: aload_2
    //   98: invokevirtual 352	com/tencent/mm/storage/af:d	(Landroid/database/Cursor;)V
    //   101: aload_2
    //   102: ifnull +9 -> 111
    //   105: aload_2
    //   106: invokeinterface 149 1 0
    //   111: aload_3
    //   112: areturn
    //   113: aload_2
    //   114: ifnull +9 -> 123
    //   117: aload_2
    //   118: invokeinterface 149 1 0
    //   123: aconst_null
    //   124: areturn
    //   125: astore_3
    //   126: aconst_null
    //   127: astore_2
    //   128: aload_2
    //   129: astore_1
    //   130: ldc 157
    //   132: ldc_w 355
    //   135: iconst_1
    //   136: anewarray 161	java/lang/Object
    //   139: dup
    //   140: iconst_0
    //   141: aload_3
    //   142: invokevirtual 162	java/lang/Exception:toString	()Ljava/lang/String;
    //   145: aastore
    //   146: invokestatic 168	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   149: aload_2
    //   150: ifnull -27 -> 123
    //   153: aload_2
    //   154: invokeinterface 149 1 0
    //   159: goto -36 -> 123
    //   162: astore_1
    //   163: aload_2
    //   164: ifnull +9 -> 173
    //   167: aload_2
    //   168: invokeinterface 149 1 0
    //   173: aload_1
    //   174: athrow
    //   175: astore_3
    //   176: aload_1
    //   177: astore_2
    //   178: aload_3
    //   179: astore_1
    //   180: goto -17 -> 163
    //   183: astore_3
    //   184: goto -56 -> 128
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	187	0	this	ai
    //   0	187	1	paramString	String
    //   1	177	2	str	String
    //   93	19	3	localaf	af
    //   125	17	3	localException1	Exception
    //   175	4	3	localObject	Object
    //   183	1	3	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   2	67	125	java/lang/Exception
    //   2	67	162	finally
    //   75	84	175	finally
    //   86	94	175	finally
    //   96	101	175	finally
    //   130	149	175	finally
    //   75	84	183	java/lang/Exception
    //   86	94	183	java/lang/Exception
    //   96	101	183	java/lang/Exception
  }
  
  /* Error */
  public final ArrayList<String> ad(ArrayList<String> paramArrayList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +10 -> 11
    //   4: aload_1
    //   5: invokevirtual 272	java/util/ArrayList:size	()I
    //   8: ifgt +7 -> 15
    //   11: aconst_null
    //   12: astore_1
    //   13: aload_1
    //   14: areturn
    //   15: aload_1
    //   16: invokevirtual 272	java/util/ArrayList:size	()I
    //   19: istore_3
    //   20: new 92	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   27: astore 4
    //   29: aload 4
    //   31: ldc_w 359
    //   34: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: aload 4
    //   40: ldc 252
    //   42: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: iconst_0
    //   47: istore_2
    //   48: iload_2
    //   49: iload_3
    //   50: if_icmpge +62 -> 112
    //   53: aload 4
    //   55: new 92	java/lang/StringBuilder
    //   58: dup
    //   59: ldc_w 361
    //   62: invokespecial 256	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   65: aload_1
    //   66: iload_2
    //   67: invokevirtual 362	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   70: checkcast 22	java/lang/String
    //   73: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: ldc_w 361
    //   79: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: pop
    //   89: iload_2
    //   90: iload_3
    //   91: iconst_1
    //   92: isub
    //   93: if_icmpge +12 -> 105
    //   96: aload 4
    //   98: ldc_w 258
    //   101: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: pop
    //   105: iload_2
    //   106: iconst_1
    //   107: iadd
    //   108: istore_2
    //   109: goto -61 -> 48
    //   112: aload 4
    //   114: ldc_w 260
    //   117: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: pop
    //   121: aload 4
    //   123: ldc_w 364
    //   126: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: pop
    //   130: aload 4
    //   132: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: astore_1
    //   136: ldc 157
    //   138: ldc_w 366
    //   141: iconst_1
    //   142: anewarray 161	java/lang/Object
    //   145: dup
    //   146: iconst_0
    //   147: aload_1
    //   148: aastore
    //   149: invokestatic 265	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   152: aload_0
    //   153: getfield 51	com/tencent/mm/storage/ai:dXw	Lcom/tencent/mm/sdk/e/e;
    //   156: aload_1
    //   157: aconst_null
    //   158: iconst_2
    //   159: invokeinterface 110 4 0
    //   164: astore 4
    //   166: aload 4
    //   168: astore_1
    //   169: aload 4
    //   171: ldc 184
    //   173: invokeinterface 122 2 0
    //   178: istore_2
    //   179: aload 4
    //   181: astore_1
    //   182: aload 4
    //   184: invokeinterface 116 1 0
    //   189: ifeq +89 -> 278
    //   192: aload 4
    //   194: astore_1
    //   195: new 62	java/util/ArrayList
    //   198: dup
    //   199: invokespecial 64	java/util/ArrayList:<init>	()V
    //   202: astore 5
    //   204: aload 4
    //   206: astore_1
    //   207: aload 5
    //   209: aload 4
    //   211: iload_2
    //   212: invokeinterface 126 2 0
    //   217: invokevirtual 266	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   220: pop
    //   221: aload 4
    //   223: astore_1
    //   224: aload 4
    //   226: invokeinterface 269 1 0
    //   231: ifne -27 -> 204
    //   234: aload 4
    //   236: astore_1
    //   237: ldc 157
    //   239: ldc_w 368
    //   242: iconst_1
    //   243: anewarray 161	java/lang/Object
    //   246: dup
    //   247: iconst_0
    //   248: aload 5
    //   250: invokevirtual 272	java/util/ArrayList:size	()I
    //   253: invokestatic 278	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   256: aastore
    //   257: invokestatic 265	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   260: aload 5
    //   262: astore_1
    //   263: aload 4
    //   265: ifnull -252 -> 13
    //   268: aload 4
    //   270: invokeinterface 149 1 0
    //   275: aload 5
    //   277: areturn
    //   278: aload 4
    //   280: ifnull +10 -> 290
    //   283: aload 4
    //   285: invokeinterface 149 1 0
    //   290: aconst_null
    //   291: areturn
    //   292: astore 5
    //   294: aconst_null
    //   295: astore 4
    //   297: aload 4
    //   299: astore_1
    //   300: ldc 157
    //   302: ldc_w 370
    //   305: iconst_1
    //   306: anewarray 161	java/lang/Object
    //   309: dup
    //   310: iconst_0
    //   311: aload 5
    //   313: invokevirtual 162	java/lang/Exception:toString	()Ljava/lang/String;
    //   316: aastore
    //   317: invokestatic 168	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   320: aload 4
    //   322: ifnull -32 -> 290
    //   325: aload 4
    //   327: invokeinterface 149 1 0
    //   332: goto -42 -> 290
    //   335: astore 4
    //   337: aconst_null
    //   338: astore_1
    //   339: aload_1
    //   340: ifnull +9 -> 349
    //   343: aload_1
    //   344: invokeinterface 149 1 0
    //   349: aload 4
    //   351: athrow
    //   352: astore 4
    //   354: goto -15 -> 339
    //   357: astore 5
    //   359: goto -62 -> 297
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	362	0	this	ai
    //   0	362	1	paramArrayList	ArrayList<String>
    //   47	165	2	i	int
    //   19	74	3	j	int
    //   27	299	4	localObject1	Object
    //   335	15	4	localObject2	Object
    //   352	1	4	localObject3	Object
    //   202	74	5	localArrayList	ArrayList
    //   292	20	5	localException1	Exception
    //   357	1	5	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   152	166	292	java/lang/Exception
    //   152	166	335	finally
    //   169	179	352	finally
    //   182	192	352	finally
    //   195	204	352	finally
    //   207	221	352	finally
    //   224	234	352	finally
    //   237	260	352	finally
    //   300	320	352	finally
    //   169	179	357	java/lang/Exception
    //   182	192	357	java/lang/Exception
    //   195	204	357	java/lang/Exception
    //   207	221	357	java/lang/Exception
    //   224	234	357	java/lang/Exception
    //   237	260	357	java/lang/Exception
  }
  
  public final boolean b(boolean paramBoolean, af paramaf, String... paramVarArgs)
  {
    boolean bool = super.c(paramaf, paramVarArgs);
    if ((bool) && (paramBoolean)) {
      aam(a("update", paramaf));
    }
    bdu();
    return bool;
  }
  
  public final void bdu()
  {
    y.v("MicroMsg.Label.ContactLabelStorage", "cleanCache %s", new Object[] { bk.csb() });
    this.uzU = null;
    this.uzV = null;
  }
  
  public final ArrayList<String> cuh()
  {
    long l = bk.UY();
    Cursor localCursor = this.dXw.a("ContactLabel", new String[] { "labelName" }, null, null, null, null, "createTime ASC ", 2);
    if (localCursor == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    while (localCursor.moveToNext()) {
      localArrayList.add(localCursor.getString(0));
    }
    localCursor.close();
    y.i("MicroMsg.Label.ContactLabelStorage", "getAllLabel time:%s count:%s stack:%s", new Object[] { Long.valueOf(bk.co(l)), Integer.valueOf(localArrayList.size()), bk.csb() });
    return localArrayList;
  }
  
  public final ArrayList<af> cui()
  {
    long l = bk.UY();
    Cursor localCursor = this.dXw.a("select * from ContactLabel order by createTime ASC ", null, 2);
    if (localCursor == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    while (localCursor.moveToNext())
    {
      af localaf = new af();
      localaf.d(localCursor);
      localArrayList.add(localaf);
    }
    localCursor.close();
    y.i("MicroMsg.Label.ContactLabelStorage", "getAllContactLable time:%s count:%s stack:%s", new Object[] { Long.valueOf(bk.co(l)), Integer.valueOf(localArrayList.size()), bk.csb() });
    return localArrayList;
  }
  
  public final void cuj()
  {
    if ((this.uzU != null) && (this.uzV != null)) {
      return;
    }
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    long l = bk.UY();
    Object localObject1 = "select username , contactLabelIds from rcontact where (type & " + com.tencent.mm.n.a.AY() + " !=0 ) and ( contactLabelIds != '') ;";
    localObject1 = this.dXw.a((String)localObject1, null, 2);
    Object localObject2;
    Object localObject3;
    if (localObject1 == null)
    {
      this.uzU = localHashMap1;
      this.uzV = localHashMap2;
      return;
      localHashMap1.put(localObject2, localObject3);
    }
    while (((Cursor)localObject1).moveToNext())
    {
      localObject2 = ((Cursor)localObject1).getString(0);
      if (!bk.bl((String)localObject2))
      {
        String[] arrayOfString = bk.pm(((Cursor)localObject1).getString(1)).split(",");
        if ((arrayOfString != null) && (arrayOfString.length > 0))
        {
          localObject3 = new int[arrayOfString.length];
          int i = 0;
          label174:
          if (i < arrayOfString.length)
          {
            localObject3[i] = bk.getInt(arrayOfString[i], -1);
            if (!localHashMap2.containsKey(Integer.valueOf(localObject3[i]))) {
              break label236;
            }
            ((ArrayList)localHashMap2.get(Integer.valueOf(localObject3[i]))).add(localObject2);
          }
          for (;;)
          {
            i += 1;
            break label174;
            break;
            label236:
            ArrayList localArrayList = new ArrayList();
            localArrayList.add(localObject2);
            localHashMap2.put(Integer.valueOf(localObject3[i]), localArrayList);
          }
        }
      }
    }
    ((Cursor)localObject1).close();
    y.i("MicroMsg.Label.ContactLabelStorage", "checkRebuildCache time:%s user:%s label:%s stack:%s", new Object[] { Long.valueOf(bk.co(l)), Integer.valueOf(localHashMap1.size()), Integer.valueOf(localHashMap2.size()), bk.csb() });
    this.uzU = localHashMap1;
    this.uzV = localHashMap2;
  }
  
  public final boolean dp(List<af> paramList)
  {
    if (paramList.size() <= 0)
    {
      y.i("MicroMsg.Label.ContactLabelStorage", "cpan[insertAddLabel] list is null.");
      return false;
    }
    h localh = null;
    long l;
    if ((this.dXw instanceof h))
    {
      localh = (h)this.dXw;
      l = localh.eV(Thread.currentThread().getId());
      y.i("MicroMsg.Label.ContactLabelStorage", "begin insertOrUpdateList in a transaction, ticket = %d", new Object[] { Long.valueOf(l) });
    }
    for (;;)
    {
      int j = paramList.size();
      new ArrayList();
      int i = 0;
      while (i < j)
      {
        String str = c((af)paramList.get(i));
        if (!bk.bl(str)) {
          jJ(str);
        }
        i += 1;
      }
      if (localh != null)
      {
        localh.hI(l);
        y.i("MicroMsg.Label.ContactLabelStorage", "end deleteLocalLabel transaction");
      }
      bdu();
      return false;
      l = -1L;
    }
  }
  
  public final boolean dq(List<af> paramList)
  {
    if (paramList.size() <= 0)
    {
      y.i("MicroMsg.Label.ContactLabelStorage", "cpan[insertOrUpdateList] list is null.");
      return false;
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    h localh = null;
    long l;
    if ((this.dXw instanceof h))
    {
      localh = (h)this.dXw;
      l = localh.eV(Thread.currentThread().getId());
      y.i("MicroMsg.Label.ContactLabelStorage", "begin insertOrUpdateList in a transaction, ticket = %d", new Object[] { Long.valueOf(l) });
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
          switch (ai.1.uzW[locala.ordinal()])
          {
          default: 
            y.w("MicroMsg.Label.ContactLabelStorage", "cpan[insertOrUpdateList] unknow result.");
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
        localh.hI(l);
        y.i("MicroMsg.Label.ContactLabelStorage", "end insertOrUpdateList transaction");
      }
      if (localArrayList1.size() > 0) {
        aam(v("insert", localArrayList1));
      }
      if (localArrayList2.size() > 0) {
        aam(v("update", localArrayList2));
      }
      bdu();
      return false;
      l = -1L;
    }
  }
  
  public final boolean dr(List<af> paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0))
    {
      y.w("MicroMsg.Label.ContactLabelStorage", "cpan[deleteList] list is null.");
      return false;
    }
    h localh = null;
    long l;
    if ((this.dXw instanceof h))
    {
      localh = (h)this.dXw;
      l = localh.eV(Thread.currentThread().getId());
      y.i("MicroMsg.Label.ContactLabelStorage", "begin deleteList in a transaction, ticket = %d", new Object[] { Long.valueOf(l) });
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
        localh.hI(l);
        y.i("MicroMsg.Label.ContactLabelStorage", "end insertOrUpdateList transaction");
      }
      aam(v("delete", paramList));
      cuk();
      return true;
      l = -1L;
    }
  }
  
  /* Error */
  public final ArrayList<af> ds(List<af> paramList)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokeinterface 221 1 0
    //   6: ifgt +7 -> 13
    //   9: aconst_null
    //   10: astore_1
    //   11: aload_1
    //   12: areturn
    //   13: aload_1
    //   14: invokeinterface 221 1 0
    //   19: istore_3
    //   20: new 92	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   27: astore 4
    //   29: aload 4
    //   31: ldc 250
    //   33: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: pop
    //   37: aload 4
    //   39: ldc_w 497
    //   42: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: iconst_0
    //   47: istore_2
    //   48: iload_2
    //   49: iload_3
    //   50: if_icmpge +65 -> 115
    //   53: aload 4
    //   55: new 92	java/lang/StringBuilder
    //   58: dup
    //   59: ldc 254
    //   61: invokespecial 256	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   64: aload_1
    //   65: iload_2
    //   66: invokeinterface 225 2 0
    //   71: checkcast 24	com/tencent/mm/storage/af
    //   74: getfield 97	com/tencent/mm/storage/af:field_labelID	I
    //   77: invokevirtual 101	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   80: ldc 254
    //   82: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: pop
    //   92: iload_2
    //   93: iload_3
    //   94: iconst_1
    //   95: isub
    //   96: if_icmpge +12 -> 108
    //   99: aload 4
    //   101: ldc_w 258
    //   104: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: pop
    //   108: iload_2
    //   109: iconst_1
    //   110: iadd
    //   111: istore_2
    //   112: goto -64 -> 48
    //   115: aload 4
    //   117: ldc_w 260
    //   120: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: pop
    //   124: aload 4
    //   126: ldc_w 364
    //   129: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: pop
    //   133: aload 4
    //   135: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   138: astore_1
    //   139: ldc 157
    //   141: ldc_w 499
    //   144: iconst_1
    //   145: anewarray 161	java/lang/Object
    //   148: dup
    //   149: iconst_0
    //   150: aload_1
    //   151: aastore
    //   152: invokestatic 265	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   155: aload_0
    //   156: getfield 51	com/tencent/mm/storage/ai:dXw	Lcom/tencent/mm/sdk/e/e;
    //   159: aload_1
    //   160: aconst_null
    //   161: iconst_2
    //   162: invokeinterface 110 4 0
    //   167: astore 4
    //   169: aload 4
    //   171: astore_1
    //   172: aload 4
    //   174: invokeinterface 116 1 0
    //   179: ifeq +105 -> 284
    //   182: aload 4
    //   184: astore_1
    //   185: new 62	java/util/ArrayList
    //   188: dup
    //   189: invokespecial 64	java/util/ArrayList:<init>	()V
    //   192: astore 5
    //   194: aload 4
    //   196: astore_1
    //   197: new 24	com/tencent/mm/storage/af
    //   200: dup
    //   201: invokespecial 349	com/tencent/mm/storage/af:<init>	()V
    //   204: astore 6
    //   206: aload 4
    //   208: astore_1
    //   209: aload 6
    //   211: aload 4
    //   213: invokevirtual 352	com/tencent/mm/storage/af:d	(Landroid/database/Cursor;)V
    //   216: aload 4
    //   218: astore_1
    //   219: aload 5
    //   221: aload 6
    //   223: invokevirtual 266	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   226: pop
    //   227: aload 4
    //   229: astore_1
    //   230: aload 4
    //   232: invokeinterface 269 1 0
    //   237: ifne -43 -> 194
    //   240: aload 4
    //   242: astore_1
    //   243: ldc 157
    //   245: ldc_w 501
    //   248: iconst_1
    //   249: anewarray 161	java/lang/Object
    //   252: dup
    //   253: iconst_0
    //   254: aload 5
    //   256: invokevirtual 272	java/util/ArrayList:size	()I
    //   259: invokestatic 278	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   262: aastore
    //   263: invokestatic 265	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   266: aload 5
    //   268: astore_1
    //   269: aload 4
    //   271: ifnull -260 -> 11
    //   274: aload 4
    //   276: invokeinterface 149 1 0
    //   281: aload 5
    //   283: areturn
    //   284: aload 4
    //   286: ifnull +10 -> 296
    //   289: aload 4
    //   291: invokeinterface 149 1 0
    //   296: aconst_null
    //   297: areturn
    //   298: astore 5
    //   300: aconst_null
    //   301: astore 4
    //   303: aload 4
    //   305: astore_1
    //   306: ldc 157
    //   308: ldc_w 503
    //   311: iconst_1
    //   312: anewarray 161	java/lang/Object
    //   315: dup
    //   316: iconst_0
    //   317: aload 5
    //   319: invokevirtual 162	java/lang/Exception:toString	()Ljava/lang/String;
    //   322: aastore
    //   323: invokestatic 168	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   326: aload 4
    //   328: ifnull -32 -> 296
    //   331: aload 4
    //   333: invokeinterface 149 1 0
    //   338: goto -42 -> 296
    //   341: astore 4
    //   343: aconst_null
    //   344: astore_1
    //   345: aload_1
    //   346: ifnull +9 -> 355
    //   349: aload_1
    //   350: invokeinterface 149 1 0
    //   355: aload 4
    //   357: athrow
    //   358: astore 4
    //   360: goto -15 -> 345
    //   363: astore 5
    //   365: goto -62 -> 303
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	368	0	this	ai
    //   0	368	1	paramList	List<af>
    //   47	65	2	i	int
    //   19	77	3	j	int
    //   27	305	4	localObject1	Object
    //   341	15	4	localObject2	Object
    //   358	1	4	localObject3	Object
    //   192	90	5	localArrayList	ArrayList
    //   298	20	5	localException1	Exception
    //   363	1	5	localException2	Exception
    //   204	18	6	localaf	af
    // Exception table:
    //   from	to	target	type
    //   155	169	298	java/lang/Exception
    //   155	169	341	finally
    //   172	182	358	finally
    //   185	194	358	finally
    //   197	206	358	finally
    //   209	216	358	finally
    //   219	227	358	finally
    //   230	240	358	finally
    //   243	266	358	finally
    //   306	326	358	finally
    //   172	182	363	java/lang/Exception
    //   185	194	363	java/lang/Exception
    //   197	206	363	java/lang/Exception
    //   209	216	363	java/lang/Exception
    //   219	227	363	java/lang/Exception
    //   230	240	363	java/lang/Exception
    //   243	266	363	java/lang/Exception
  }
  
  public final boolean jJ(String paramString)
  {
    y.i("MicroMsg.Label.ContactLabelStorage", "cpan[delete] labelID:%s", new Object[] { paramString });
    y.d("MicroMsg.Label.ContactLabelStorage", "cpan[query] SQL:%s", new Object[] { "labelID =? " });
    try
    {
      i = this.dXw.delete("ContactLabel", "labelID =? ", new String[] { paramString });
      if (i > 0) {
        return true;
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        y.w("MicroMsg.Label.ContactLabelStorage", "cpan[delete] exception %s", new Object[] { paramString.toString() });
        int i = -1;
      }
    }
    return false;
  }
  
  /* Error */
  public final ArrayList<String> u(String paramString, List<String> paramList)
  {
    // Byte code:
    //   0: ldc 157
    //   2: ldc_w 508
    //   5: iconst_1
    //   6: anewarray 161	java/lang/Object
    //   9: dup
    //   10: iconst_0
    //   11: ldc_w 519
    //   14: aastore
    //   15: invokestatic 265	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   18: new 92	java/lang/StringBuilder
    //   21: dup
    //   22: ldc_w 521
    //   25: invokespecial 256	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   28: aload_1
    //   29: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: ldc_w 521
    //   35: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: astore 5
    //   43: new 92	java/lang/StringBuilder
    //   46: dup
    //   47: ldc_w 521
    //   50: invokespecial 256	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   53: aload_1
    //   54: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: ldc_w 521
    //   60: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: astore 6
    //   68: new 92	java/lang/StringBuilder
    //   71: dup
    //   72: ldc_w 521
    //   75: invokespecial 256	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   78: aload_1
    //   79: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: ldc_w 521
    //   85: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   91: astore_1
    //   92: aload_0
    //   93: getfield 51	com/tencent/mm/storage/ai:dXw	Lcom/tencent/mm/sdk/e/e;
    //   96: ldc_w 519
    //   99: iconst_3
    //   100: anewarray 22	java/lang/String
    //   103: dup
    //   104: iconst_0
    //   105: aload 5
    //   107: aastore
    //   108: dup
    //   109: iconst_1
    //   110: aload 6
    //   112: aastore
    //   113: dup
    //   114: iconst_2
    //   115: aload_1
    //   116: aastore
    //   117: iconst_2
    //   118: invokeinterface 110 4 0
    //   123: astore 5
    //   125: aload 5
    //   127: astore_1
    //   128: aload 5
    //   130: ldc 118
    //   132: invokeinterface 122 2 0
    //   137: istore_3
    //   138: aload 5
    //   140: astore_1
    //   141: aload 5
    //   143: invokeinterface 116 1 0
    //   148: ifeq +101 -> 249
    //   151: aload 5
    //   153: astore_1
    //   154: new 62	java/util/ArrayList
    //   157: dup
    //   158: invokespecial 64	java/util/ArrayList:<init>	()V
    //   161: astore 6
    //   163: aload 5
    //   165: astore_1
    //   166: aload 5
    //   168: iload_3
    //   169: invokeinterface 126 2 0
    //   174: astore 7
    //   176: aload_2
    //   177: ifnull +29 -> 206
    //   180: aload 5
    //   182: astore_1
    //   183: aload_2
    //   184: invokeinterface 221 1 0
    //   189: ifle +17 -> 206
    //   192: aload 5
    //   194: astore_1
    //   195: aload_2
    //   196: aload 7
    //   198: invokeinterface 524 2 0
    //   203: ifne +14 -> 217
    //   206: aload 5
    //   208: astore_1
    //   209: aload 6
    //   211: aload 7
    //   213: invokevirtual 266	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   216: pop
    //   217: aload 5
    //   219: astore_1
    //   220: aload 5
    //   222: invokeinterface 269 1 0
    //   227: istore 4
    //   229: iload 4
    //   231: ifne -68 -> 163
    //   234: aload 5
    //   236: ifnull +10 -> 246
    //   239: aload 5
    //   241: invokeinterface 149 1 0
    //   246: aload 6
    //   248: areturn
    //   249: aload 5
    //   251: ifnull +10 -> 261
    //   254: aload 5
    //   256: invokeinterface 149 1 0
    //   261: aconst_null
    //   262: areturn
    //   263: astore_2
    //   264: aconst_null
    //   265: astore 5
    //   267: aload 5
    //   269: astore_1
    //   270: ldc 157
    //   272: ldc_w 526
    //   275: iconst_1
    //   276: anewarray 161	java/lang/Object
    //   279: dup
    //   280: iconst_0
    //   281: aload_2
    //   282: invokevirtual 162	java/lang/Exception:toString	()Ljava/lang/String;
    //   285: aastore
    //   286: invokestatic 168	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   289: aload 5
    //   291: ifnull -30 -> 261
    //   294: aload 5
    //   296: invokeinterface 149 1 0
    //   301: goto -40 -> 261
    //   304: astore_2
    //   305: aconst_null
    //   306: astore_1
    //   307: aload_1
    //   308: ifnull +9 -> 317
    //   311: aload_1
    //   312: invokeinterface 149 1 0
    //   317: aload_2
    //   318: athrow
    //   319: astore_2
    //   320: goto -13 -> 307
    //   323: astore_2
    //   324: goto -57 -> 267
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	327	0	this	ai
    //   0	327	1	paramString	String
    //   0	327	2	paramList	List<String>
    //   137	32	3	i	int
    //   227	3	4	bool	boolean
    //   41	254	5	localObject1	Object
    //   66	181	6	localObject2	Object
    //   174	38	7	str	String
    // Exception table:
    //   from	to	target	type
    //   92	125	263	java/lang/Exception
    //   92	125	304	finally
    //   128	138	319	finally
    //   141	151	319	finally
    //   154	163	319	finally
    //   166	176	319	finally
    //   183	192	319	finally
    //   195	206	319	finally
    //   209	217	319	finally
    //   220	229	319	finally
    //   270	289	319	finally
    //   128	138	323	java/lang/Exception
    //   141	151	323	java/lang/Exception
    //   154	163	323	java/lang/Exception
    //   166	176	323	java/lang/Exception
    //   183	192	323	java/lang/Exception
    //   195	206	323	java/lang/Exception
    //   209	217	323	java/lang/Exception
    //   220	229	323	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.storage.ai
 * JD-Core Version:    0.7.0.1
 */