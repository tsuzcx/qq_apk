package com.tencent.mm.storage;

import android.content.ContentValues;
import android.os.HandlerThread;
import com.tencent.mm.cf.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.ax.b;
import com.tencent.mm.sdk.platformtools.ax.c;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import junit.framework.Assert;

public final class z
  extends m
  implements ax.c<Object, Object>
{
  public static final String[] dXp = { "CREATE TABLE IF NOT EXISTS userinfo ( id INTEGER PRIMARY KEY, type INT, value TEXT )", "CREATE TABLE IF NOT EXISTS userinfo2 ( sid TEXT PRIMARY KEY, type INT, value TEXT )" };
  private h dXo;
  private long eEo;
  private ax<Object, Object> unr;
  private ax<Object, Object> uns;
  private BlockingQueue<Integer> unt = new LinkedBlockingQueue();
  private BlockingQueue<String> unu = new LinkedBlockingQueue();
  
  public z(h paramh)
  {
    this.dXo = paramh;
    this.unr = new ax(this, g.DS().mnU.getLooper(), 100, 20, 60000L, 100L);
    this.unr.setTag(Integer.valueOf(1));
    this.uns = new ax(this, g.DS().mnU.getLooper(), 100, 20, 60000L, 100L);
    this.uns.setTag(Integer.valueOf(3));
  }
  
  private static boolean a(String paramString, Object paramObject, boolean paramBoolean)
  {
    if ((paramObject == null) && (paramBoolean)) {}
    while (((paramString.equals("INT")) && ((paramObject instanceof Integer))) || ((paramString.equals("LONG")) && ((paramObject instanceof Long))) || ((paramString.equals("STRING")) && ((paramObject instanceof String))) || ((paramString.equals("BOOLEAN")) && ((paramObject instanceof Boolean))) || ((paramString.equals("FLOAT")) && ((paramObject instanceof Float))) || ((paramString.equals("DOUBLE")) && ((paramObject instanceof Double)))) {
      return true;
    }
    if ((paramObject != null) && (b.cqk())) {
      Assert.assertTrue("checkType failed, input type and value[" + paramString + ", " + paramObject + "] are not match", false);
    }
    if (paramBoolean) {
      y.e("MicroMsg.ConfigStorage", "checkType failed, input type and value[%s, %s] are not match", new Object[] { paramString, paramObject });
    }
    return false;
  }
  
  private static int bW(Object paramObject)
  {
    if ((paramObject instanceof Integer)) {
      return 1;
    }
    if ((paramObject instanceof Long)) {
      return 2;
    }
    if ((paramObject instanceof String)) {
      return 3;
    }
    if ((paramObject instanceof Boolean)) {
      return 4;
    }
    if ((paramObject instanceof Float)) {
      return 5;
    }
    if ((paramObject instanceof Double)) {
      return 6;
    }
    y.e("MicroMsg.ConfigStorage", "unresolve failed, unknown type=" + paramObject.getClass().toString());
    return -1;
  }
  
  /* Error */
  private Object get(String paramString, Object paramObject)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 49	com/tencent/mm/storage/z:dXo	Lcom/tencent/mm/cf/h;
    //   8: ifnull +153 -> 161
    //   11: ldc 179
    //   13: iload_3
    //   14: invokestatic 149	junit/framework/Assert:assertTrue	(Ljava/lang/String;Z)V
    //   17: aload_0
    //   18: getfield 90	com/tencent/mm/storage/z:uns	Lcom/tencent/mm/sdk/platformtools/ax;
    //   21: aload_1
    //   22: invokevirtual 182	com/tencent/mm/sdk/platformtools/ax:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   25: astore 4
    //   27: aload 4
    //   29: ifnonnull +137 -> 166
    //   32: aload_0
    //   33: getfield 47	com/tencent/mm/storage/z:unu	Ljava/util/concurrent/BlockingQueue;
    //   36: aload_1
    //   37: invokeinterface 187 2 0
    //   42: ifne +124 -> 166
    //   45: new 9	com/tencent/mm/storage/z$a
    //   48: dup
    //   49: invokespecial 188	com/tencent/mm/storage/z$a:<init>	()V
    //   52: astore 5
    //   54: aload_0
    //   55: getfield 49	com/tencent/mm/storage/z:dXo	Lcom/tencent/mm/cf/h;
    //   58: ldc 190
    //   60: aconst_null
    //   61: ldc 192
    //   63: iconst_1
    //   64: anewarray 29	java/lang/String
    //   67: dup
    //   68: iconst_0
    //   69: aload_1
    //   70: aastore
    //   71: aconst_null
    //   72: aconst_null
    //   73: aconst_null
    //   74: iconst_2
    //   75: invokevirtual 197	com/tencent/mm/cf/h:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Landroid/database/Cursor;
    //   78: astore 4
    //   80: aload 4
    //   82: invokeinterface 202 1 0
    //   87: ifeq +29 -> 116
    //   90: aload 5
    //   92: aload 4
    //   94: iconst_1
    //   95: invokeinterface 206 2 0
    //   100: putfield 210	com/tencent/mm/storage/z$a:type	I
    //   103: aload 5
    //   105: aload 4
    //   107: iconst_2
    //   108: invokeinterface 214 2 0
    //   113: putfield 218	com/tencent/mm/storage/z$a:dXz	Ljava/lang/String;
    //   116: aload 4
    //   118: invokeinterface 221 1 0
    //   123: aload 5
    //   125: getfield 210	com/tencent/mm/storage/z$a:type	I
    //   128: aload 5
    //   130: getfield 218	com/tencent/mm/storage/z$a:dXz	Ljava/lang/String;
    //   133: invokestatic 225	com/tencent/mm/storage/z:j	(ILjava/lang/String;)Ljava/lang/Object;
    //   136: astore 4
    //   138: aload_0
    //   139: getfield 90	com/tencent/mm/storage/z:uns	Lcom/tencent/mm/sdk/platformtools/ax;
    //   142: aload_1
    //   143: aload 5
    //   145: invokevirtual 229	com/tencent/mm/sdk/platformtools/ax:n	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   148: pop
    //   149: aload 4
    //   151: astore_1
    //   152: aload 4
    //   154: ifnonnull +45 -> 199
    //   157: aload_0
    //   158: monitorexit
    //   159: aload_2
    //   160: areturn
    //   161: iconst_0
    //   162: istore_3
    //   163: goto -152 -> 11
    //   166: aload 4
    //   168: astore_1
    //   169: aload 4
    //   171: instanceof 9
    //   174: ifeq +25 -> 199
    //   177: aload 4
    //   179: checkcast 9	com/tencent/mm/storage/z$a
    //   182: astore_1
    //   183: aload_1
    //   184: getfield 210	com/tencent/mm/storage/z$a:type	I
    //   187: aload_1
    //   188: getfield 218	com/tencent/mm/storage/z$a:dXz	Ljava/lang/String;
    //   191: invokestatic 225	com/tencent/mm/storage/z:j	(ILjava/lang/String;)Ljava/lang/Object;
    //   194: astore_1
    //   195: aload_1
    //   196: ifnull -39 -> 157
    //   199: aload_1
    //   200: astore_2
    //   201: goto -44 -> 157
    //   204: astore_1
    //   205: aload_0
    //   206: monitorexit
    //   207: aload_1
    //   208: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	209	0	this	z
    //   0	209	1	paramString	String
    //   0	209	2	paramObject	Object
    //   1	162	3	bool	boolean
    //   25	153	4	localObject	Object
    //   52	92	5	locala	a
    // Exception table:
    //   from	to	target	type
    //   4	11	204	finally
    //   11	27	204	finally
    //   32	116	204	finally
    //   116	149	204	finally
    //   169	195	204	finally
  }
  
  private static Object j(int paramInt, String paramString)
  {
    String str = paramString;
    switch (paramInt)
    {
    }
    for (;;)
    {
      str = null;
      return str;
      try
      {
        return Integer.valueOf(paramString);
      }
      catch (Exception paramString)
      {
        y.e("MicroMsg.ConfigStorage", "exception:%s", new Object[] { bk.j(paramString) });
      }
      return Long.valueOf(paramString);
      return Boolean.valueOf(paramString);
      return Float.valueOf(paramString);
      paramString = Double.valueOf(paramString);
      return paramString;
    }
  }
  
  public final long Fm(int paramInt)
  {
    Long localLong = (Long)get(paramInt, null);
    if (localLong == null) {
      return 0L;
    }
    return localLong.longValue();
  }
  
  public final boolean Rw()
  {
    if (this.dXo.inTransaction())
    {
      y.i("MicroMsg.ConfigStorage", "summer preAppend inTransaction return false");
      return false;
    }
    this.eEo = this.dXo.eV(Thread.currentThread().getId());
    if (this.eEo <= 0L)
    {
      y.i("MicroMsg.ConfigStorage", "summer preAppend ticket: " + this.eEo + " return false");
      return false;
    }
    return true;
  }
  
  public final void Rx()
  {
    if (this.eEo > 0L) {
      this.dXo.hI(this.eEo);
    }
  }
  
  protected final boolean WH()
  {
    boolean bool = true;
    if ((this.dXo == null) || (this.dXo.csp())) {
      if (this.dXo != null) {
        break label50;
      }
    }
    label50:
    for (Object localObject = "null";; localObject = Boolean.valueOf(this.dXo.csp()))
    {
      y.w("MicroMsg.ConfigStorage", "shouldProcessEvent db is close :%s", new Object[] { localObject });
      bool = false;
      return bool;
    }
  }
  
  public final long a(ac.a parama, long paramLong)
  {
    parama = get(parama, Long.valueOf(paramLong));
    long l = paramLong;
    if (parama != null)
    {
      l = paramLong;
      if ((parama instanceof Long)) {
        l = ((Long)parama).longValue();
      }
    }
    return l;
  }
  
  public final void a(ax<Object, Object> paramax, ax.b<Object, Object> paramb)
  {
    Object localObject1 = paramb.smD;
    Object localObject2 = paramb.values;
    int i = paramb.uhL;
    switch (((Integer)paramax.getTag()).intValue())
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                if (i != 1) {
                  break;
                }
              } while ((localObject2 == null) || (!(localObject2 instanceof a)));
              paramax = (a)localObject2;
            } while (paramax.type == -1);
            localObject1 = new ContentValues();
            ((ContentValues)localObject1).put("id", (Integer)paramb.smD);
            ((ContentValues)localObject1).put("type", Integer.valueOf(paramax.type));
            ((ContentValues)localObject1).put("value", paramax.dXz.toString());
            this.dXo.replace("userinfo", "id", (ContentValues)localObject1);
            return;
          } while (i != 2);
          this.dXo.delete("userinfo", "id=" + localObject1, null);
          return;
          if (i != 1) {
            break;
          }
        } while ((localObject2 == null) || (!(localObject2 instanceof a)));
        paramax = (a)localObject2;
      } while (paramax.type == -1);
      localObject1 = new ContentValues();
      ((ContentValues)localObject1).put("sid", (String)paramb.smD);
      ((ContentValues)localObject1).put("type", Integer.valueOf(paramax.type));
      ((ContentValues)localObject1).put("value", paramax.dXz.toString());
      this.dXo.replace("userinfo2", "id", (ContentValues)localObject1);
      return;
    } while (i != 2);
    this.dXo.delete("userinfo2", "sid= ?", new String[] { localObject1.toString() });
  }
  
  public final void c(ac.a parama, Object paramObject)
  {
    int i = 1;
    label8:
    if (parama == null) {
      break label171;
    }
    for (;;)
    {
      String str;
      label163:
      try
      {
        localObject = parama.name();
        if (bk.bl((String)localObject)) {
          break label8;
        }
        String[] arrayOfString = ((String)localObject).split("_");
        str = arrayOfString[(arrayOfString.length - 1)];
        if (!str.equals("SYNC")) {
          break label289;
        }
        str = arrayOfString[(arrayOfString.length - 2)];
        label66:
        if (!a(str, paramObject, true)) {
          break label8;
        }
        j = ((String)localObject).lastIndexOf(str);
        str = ((String)localObject).substring(0, str.length() + j);
        if (paramObject != null) {
          break label188;
        }
        bool2 = this.uns.n(str, null);
        bool1 = bool2;
        if (!bool2) {
          break label294;
        }
        bool1 = bool2;
        if (this.unu.contains(str)) {
          break label294;
        }
        this.unu.add(str);
        bool1 = bool2;
      }
      finally {}
      b(j, this, parama);
      label171:
      if (i == 0) {
        break label8;
      }
      mC(true);
      break label8;
      label188:
      Object localObject = new a();
      ((a)localObject).type = bW(paramObject);
      if (((a)localObject).type == -1) {
        break label8;
      }
      ((a)localObject).dXz = paramObject.toString();
      boolean bool2 = this.uns.n(str, localObject);
      boolean bool1 = bool2;
      if (bool2)
      {
        bool1 = bool2;
        if (this.unu.contains(str))
        {
          this.unu.remove(str);
          bool1 = bool2;
        }
      }
      label289:
      label294:
      do
      {
        j = 4;
        break label163;
        i = 0;
        break label66;
        if (!bool1) {
          break;
        }
      } while (paramObject != null);
      int j = 5;
    }
  }
  
  public final Object ctW()
  {
    return get(274436, null);
  }
  
  /* Error */
  public final Object get(int paramInt, Object paramObject)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 49	com/tencent/mm/storage/z:dXo	Lcom/tencent/mm/cf/h;
    //   8: ifnull +172 -> 180
    //   11: ldc 179
    //   13: iload_3
    //   14: invokestatic 149	junit/framework/Assert:assertTrue	(Ljava/lang/String;Z)V
    //   17: aload_0
    //   18: getfield 78	com/tencent/mm/storage/z:unr	Lcom/tencent/mm/sdk/platformtools/ax;
    //   21: iload_1
    //   22: invokestatic 84	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   25: invokevirtual 182	com/tencent/mm/sdk/platformtools/ax:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   28: astore 5
    //   30: aload 5
    //   32: ifnonnull +153 -> 185
    //   35: aload_0
    //   36: getfield 45	com/tencent/mm/storage/z:unt	Ljava/util/concurrent/BlockingQueue;
    //   39: iload_1
    //   40: invokestatic 84	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   43: invokeinterface 187 2 0
    //   48: ifne +137 -> 185
    //   51: new 9	com/tencent/mm/storage/z$a
    //   54: dup
    //   55: invokespecial 188	com/tencent/mm/storage/z$a:<init>	()V
    //   58: astore 4
    //   60: aload_0
    //   61: getfield 49	com/tencent/mm/storage/z:dXo	Lcom/tencent/mm/cf/h;
    //   64: ldc_w 357
    //   67: aconst_null
    //   68: new 123	java/lang/StringBuilder
    //   71: dup
    //   72: ldc_w 363
    //   75: invokespecial 128	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   78: iload_1
    //   79: invokevirtual 427	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   82: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: aconst_null
    //   86: aconst_null
    //   87: aconst_null
    //   88: aconst_null
    //   89: iconst_2
    //   90: invokevirtual 197	com/tencent/mm/cf/h:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Landroid/database/Cursor;
    //   93: astore 5
    //   95: aload 5
    //   97: invokeinterface 202 1 0
    //   102: ifeq +29 -> 131
    //   105: aload 4
    //   107: aload 5
    //   109: iconst_1
    //   110: invokeinterface 206 2 0
    //   115: putfield 210	com/tencent/mm/storage/z$a:type	I
    //   118: aload 4
    //   120: aload 5
    //   122: iconst_2
    //   123: invokeinterface 214 2 0
    //   128: putfield 218	com/tencent/mm/storage/z$a:dXz	Ljava/lang/String;
    //   131: aload 5
    //   133: invokeinterface 221 1 0
    //   138: aload 4
    //   140: getfield 210	com/tencent/mm/storage/z$a:type	I
    //   143: aload 4
    //   145: getfield 218	com/tencent/mm/storage/z$a:dXz	Ljava/lang/String;
    //   148: invokestatic 225	com/tencent/mm/storage/z:j	(ILjava/lang/String;)Ljava/lang/Object;
    //   151: astore 5
    //   153: aload_0
    //   154: getfield 78	com/tencent/mm/storage/z:unr	Lcom/tencent/mm/sdk/platformtools/ax;
    //   157: iload_1
    //   158: invokestatic 84	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   161: aload 4
    //   163: invokevirtual 229	com/tencent/mm/sdk/platformtools/ax:n	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   166: pop
    //   167: aload 5
    //   169: astore 4
    //   171: aload 5
    //   173: ifnonnull +51 -> 224
    //   176: aload_0
    //   177: monitorexit
    //   178: aload_2
    //   179: areturn
    //   180: iconst_0
    //   181: istore_3
    //   182: goto -171 -> 11
    //   185: aload 5
    //   187: astore 4
    //   189: aload 5
    //   191: instanceof 9
    //   194: ifeq +30 -> 224
    //   197: aload 5
    //   199: checkcast 9	com/tencent/mm/storage/z$a
    //   202: astore 4
    //   204: aload 4
    //   206: getfield 210	com/tencent/mm/storage/z$a:type	I
    //   209: aload 4
    //   211: getfield 218	com/tencent/mm/storage/z$a:dXz	Ljava/lang/String;
    //   214: invokestatic 225	com/tencent/mm/storage/z:j	(ILjava/lang/String;)Ljava/lang/Object;
    //   217: astore 4
    //   219: aload 4
    //   221: ifnull -45 -> 176
    //   224: aload 4
    //   226: astore_2
    //   227: goto -51 -> 176
    //   230: astore_2
    //   231: aload_0
    //   232: monitorexit
    //   233: aload_2
    //   234: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	235	0	this	z
    //   0	235	1	paramInt	int
    //   0	235	2	paramObject	Object
    //   1	181	3	bool	boolean
    //   58	167	4	localObject1	Object
    //   28	170	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   4	11	230	finally
    //   11	30	230	finally
    //   35	131	230	finally
    //   131	167	230	finally
    //   189	219	230	finally
  }
  
  public final Object get(ac.a parama, Object paramObject)
  {
    if (parama == null) {}
    Object localObject;
    do
    {
      String str;
      do
      {
        return paramObject;
        str = parama.name();
      } while (bk.bl(str));
      String[] arrayOfString = str.split("_");
      localObject = arrayOfString[(arrayOfString.length - 1)];
      parama = (ac.a)localObject;
      if (((String)localObject).equals("SYNC")) {
        parama = arrayOfString[(arrayOfString.length - 2)];
      }
      localObject = get(str.substring(0, str.lastIndexOf(parama) + parama.length()), paramObject);
    } while (!a(parama, localObject, false));
    return localObject;
  }
  
  public final boolean getBoolean(ac.a parama, boolean paramBoolean)
  {
    parama = get(parama, Boolean.valueOf(paramBoolean));
    boolean bool = paramBoolean;
    if (parama != null)
    {
      bool = paramBoolean;
      if ((parama instanceof Boolean)) {
        bool = ((Boolean)parama).booleanValue();
      }
    }
    return bool;
  }
  
  public final int getInt(int paramInt1, int paramInt2)
  {
    Integer localInteger = (Integer)get(paramInt1, null);
    if (localInteger == null) {
      return paramInt2;
    }
    return localInteger.intValue();
  }
  
  public final Object i(ac.a parama)
  {
    return get(parama, null);
  }
  
  public final int j(ac.a parama)
  {
    parama = get(parama, Integer.valueOf(0));
    if ((parama != null) && ((parama instanceof Integer))) {
      return ((Integer)parama).intValue();
    }
    return 0;
  }
  
  public final void mC(boolean paramBoolean)
  {
    long l = System.currentTimeMillis();
    this.unr.mx(paramBoolean);
    this.uns.mx(paramBoolean);
    y.i("MicroMsg.ConfigStorage", "summer config appendAllToDisk force[%b] end takes[%d]ms ", new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(System.currentTimeMillis() - l) });
  }
  
  public final void o(int paramInt, Object paramObject)
  {
    for (;;)
    {
      boolean bool1;
      try
      {
        if (this.dXo != null)
        {
          bool1 = true;
          Assert.assertTrue("db is null", bool1);
          if (paramObject == null)
          {
            bool2 = this.unr.n(Integer.valueOf(paramInt), null);
            bool1 = bool2;
            if (!bool2) {
              break label217;
            }
            bool1 = bool2;
            if (this.unt.contains(Integer.valueOf(paramInt))) {
              break label217;
            }
            this.unt.add(Integer.valueOf(paramInt));
            bool1 = bool2;
            break label217;
            b(i, this, Integer.valueOf(paramInt));
          }
        }
        else
        {
          label97:
          bool1 = false;
          continue;
        }
        a locala = new a();
        locala.type = bW(paramObject);
        if (locala.type == -1) {
          continue;
        }
        locala.dXz = paramObject.toString();
        boolean bool2 = this.unr.n(Integer.valueOf(paramInt), locala);
        bool1 = bool2;
        if (bool2)
        {
          bool1 = bool2;
          if (this.unt.contains(Integer.valueOf(paramInt)))
          {
            this.unt.remove(Integer.valueOf(paramInt));
            bool1 = bool2;
          }
        }
      }
      finally {}
      label217:
      do
      {
        i = 4;
        break;
        if (!bool1) {
          break label97;
        }
      } while (paramObject != null);
      int i = 5;
    }
  }
  
  public final void set(int paramInt, Object paramObject)
  {
    o(paramInt, paramObject);
  }
  
  public final void setInt(int paramInt1, int paramInt2)
  {
    o(paramInt1, Integer.valueOf(paramInt2));
  }
  
  public final void setLong(int paramInt, long paramLong)
  {
    o(paramInt, Long.valueOf(paramLong));
  }
  
  static final class a
  {
    public String dXz = null;
    public int type = -1;
    
    public final boolean equals(Object paramObject)
    {
      if (paramObject == null) {}
      do
      {
        do
        {
          do
          {
            return false;
          } while (!(paramObject instanceof a));
          paramObject = (a)paramObject;
        } while (this.type != paramObject.type);
        if (this.dXz != null) {
          break;
        }
      } while (paramObject.dXz != null);
      return true;
      return this.dXz.equals(paramObject.dXz);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.z
 * JD-Core Version:    0.7.0.1
 */