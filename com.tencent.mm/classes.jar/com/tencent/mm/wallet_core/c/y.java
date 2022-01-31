package com.tencent.mm.wallet_core.c;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import java.util.HashMap;
import junit.framework.Assert;

public final class y
  extends n
{
  public static final String[] SQL_CREATE;
  private static final Object yxd;
  private a<String> AXj;
  private h fnw;
  private Handler mHandler;
  private HandlerThread mHandlerThread;
  private HashMap<Integer, y.b> yxg;
  private HashMap<String, y.b> yxh;
  private volatile boolean yxi;
  private final Runnable yxj;
  
  static
  {
    AppMethodBeat.i(5482);
    SQL_CREATE = new String[] { "CREATE TABLE IF NOT EXISTS walletcache ( sid TEXT PRIMARY KEY, type INT, value TEXT )" };
    yxd = new Object();
    AppMethodBeat.o(5482);
  }
  
  public y(h paramh)
  {
    AppMethodBeat.i(5478);
    this.AXj = new a("walletcache", "sid");
    this.yxg = new HashMap();
    this.yxh = new HashMap();
    this.yxj = new y.1(this);
    this.fnw = paramh;
    this.mHandlerThread = new HandlerThread("ConfigStorage");
    this.mHandlerThread.start();
    this.mHandler = new Handler(this.mHandlerThread.getLooper());
    AppMethodBeat.o(5478);
  }
  
  private static boolean a(String paramString, Object paramObject, boolean paramBoolean)
  {
    AppMethodBeat.i(5480);
    if ((paramObject == null) && (paramBoolean))
    {
      AppMethodBeat.o(5480);
      return true;
    }
    if ((paramString.equals("INT")) && ((paramObject instanceof Integer)))
    {
      AppMethodBeat.o(5480);
      return true;
    }
    if ((paramString.equals("LONG")) && ((paramObject instanceof Long)))
    {
      AppMethodBeat.o(5480);
      return true;
    }
    if ((paramString.equals("STRING")) && ((paramObject instanceof String)))
    {
      AppMethodBeat.o(5480);
      return true;
    }
    if ((paramString.equals("BOOLEAN")) && ((paramObject instanceof Boolean)))
    {
      AppMethodBeat.o(5480);
      return true;
    }
    if ((paramString.equals("FLOAT")) && ((paramObject instanceof Float)))
    {
      AppMethodBeat.o(5480);
      return true;
    }
    if ((paramString.equals("DOUBLE")) && ((paramObject instanceof Double)))
    {
      AppMethodBeat.o(5480);
      return true;
    }
    if ((paramObject != null) && (b.dsf())) {
      Assert.assertTrue("checkType failed, input type and value[" + paramString + ", " + paramObject + "] are not match", false);
    }
    if (paramBoolean) {
      ab.e("MicroMsg.ConfigStorage", "checkType failed, input type and value[%s, %s] are not match", new Object[] { paramString, paramObject });
    }
    AppMethodBeat.o(5480);
    return false;
  }
  
  private Object get(String paramString, Object paramObject)
  {
    AppMethodBeat.i(146042);
    Assert.assertNotNull("db is null", this.fnw);
    paramString = this.AXj.get(paramString);
    if ((paramString == null) || (paramString == yxd))
    {
      AppMethodBeat.o(146042);
      return paramObject;
    }
    AppMethodBeat.o(146042);
    return paramString;
  }
  
  public final boolean aqj()
  {
    AppMethodBeat.i(5481);
    if ((this.fnw == null) || (this.fnw.dun()))
    {
      if (this.fnw == null) {}
      for (Object localObject = "null";; localObject = Boolean.valueOf(this.fnw.dun()))
      {
        ab.w("MicroMsg.ConfigStorage", "shouldProcessEvent db is close :%s", new Object[] { localObject });
        AppMethodBeat.o(5481);
        return false;
      }
    }
    AppMethodBeat.o(5481);
    return true;
  }
  
  public final Object get(ac.a parama, Object paramObject)
  {
    AppMethodBeat.i(146041);
    if (parama == null)
    {
      AppMethodBeat.o(146041);
      return paramObject;
    }
    String str = parama.name();
    if (bo.isNullOrNil(str))
    {
      AppMethodBeat.o(146041);
      return paramObject;
    }
    String[] arrayOfString = str.split("_");
    Object localObject = arrayOfString[(arrayOfString.length - 1)];
    parama = (ac.a)localObject;
    if (((String)localObject).equals("SYNC")) {
      parama = arrayOfString[(arrayOfString.length - 2)];
    }
    localObject = get(str.substring(0, str.lastIndexOf(parama) + parama.length()), paramObject);
    if (!a(parama, localObject, false))
    {
      AppMethodBeat.o(146041);
      return paramObject;
    }
    AppMethodBeat.o(146041);
    return localObject;
  }
  
  public final void set(ac.a parama, Object paramObject)
  {
    AppMethodBeat.i(5479);
    if (parama == null)
    {
      AppMethodBeat.o(5479);
      return;
    }
    Object localObject = parama.name();
    if (bo.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(5479);
      return;
    }
    String[] arrayOfString = ((String)localObject).split("_");
    parama = arrayOfString[(arrayOfString.length - 1)];
    if (parama.equals("SYNC")) {
      parama = arrayOfString[(arrayOfString.length - 2)];
    }
    for (int i = 1;; i = 0)
    {
      if (!a(parama, paramObject, true))
      {
        AppMethodBeat.o(5479);
        return;
      }
      int j = ((String)localObject).lastIndexOf(parama);
      localObject = ((String)localObject).substring(0, parama.length() + j);
      if (!paramObject.equals(this.AXj.put(localObject, paramObject)))
      {
        if (paramObject != yxd) {
          break label272;
        }
        parama = null;
      }
      for (;;)
      {
        try
        {
          this.yxh.put(localObject, parama);
          if (i != 0)
          {
            label272:
            try
            {
              this.mHandler.removeCallbacks(this.yxj);
              this.mHandler.post(this.yxj);
              this.yxi = true;
              ab.i("MicroMsg.ConfigStorage", "Posted appendAllToDisk");
              if (paramObject != yxd) {
                break label340;
              }
              i = 5;
              b(i, this, localObject);
              localObject = new StringBuilder("SET: ").append((String)localObject).append(" => ");
              if (paramObject != yxd) {
                break label345;
              }
              parama = "(DELETED)";
              ab.i("MicroMsg.ConfigStorage", parama);
              AppMethodBeat.o(5479);
              return;
            }
            finally {}
            parama = new y.b(3, paramObject.toString());
            break;
          }
        }
        finally
        {
          AppMethodBeat.o(5479);
        }
        if (!this.yxi)
        {
          this.yxi = true;
          this.mHandler.postDelayed(this.yxj, 30000L);
          continue;
          label340:
          i = 4;
          continue;
          label345:
          parama = paramObject.toString();
        }
      }
    }
  }
  
  final class a<K>
    extends ae<K, Object>
  {
    private final String yxl;
    
    a(String paramString1, String paramString2)
    {
      super();
      AppMethodBeat.i(5474);
      this.yxl = ("SELECT * FROM " + paramString1 + " WHERE " + paramString2 + "=?;");
      AppMethodBeat.o(5474);
    }
    
    /* Error */
    public final Object create(K paramK)
    {
      // Byte code:
      //   0: sipush 5475
      //   3: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   6: aload_0
      //   7: getfield 16	com/tencent/mm/wallet_core/c/y$a:AXk	Lcom/tencent/mm/wallet_core/c/y;
      //   10: invokestatic 58	com/tencent/mm/wallet_core/c/y:a	(Lcom/tencent/mm/wallet_core/c/y;)Lcom/tencent/mm/cg/h;
      //   13: aload_0
      //   14: getfield 45	com/tencent/mm/wallet_core/c/y$a:yxl	Ljava/lang/String;
      //   17: iconst_1
      //   18: anewarray 60	java/lang/String
      //   21: dup
      //   22: iconst_0
      //   23: aload_1
      //   24: invokevirtual 63	java/lang/Object:toString	()Ljava/lang/String;
      //   27: aastore
      //   28: iconst_2
      //   29: invokevirtual 68	com/tencent/mm/cg/h:a	(Ljava/lang/String;[Ljava/lang/String;I)Landroid/database/Cursor;
      //   32: astore 4
      //   34: aload 4
      //   36: invokeinterface 74 1 0
      //   41: ifeq +88 -> 129
      //   44: new 76	com/tencent/mm/wallet_core/c/y$b
      //   47: dup
      //   48: aload 4
      //   50: iconst_1
      //   51: invokeinterface 80 2 0
      //   56: aload 4
      //   58: iconst_2
      //   59: invokeinterface 84 2 0
      //   64: invokespecial 87	com/tencent/mm/wallet_core/c/y$b:<init>	(ILjava/lang/String;)V
      //   67: astore_2
      //   68: ldc 89
      //   70: new 26	java/lang/StringBuilder
      //   73: dup
      //   74: ldc 91
      //   76: invokespecial 31	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   79: aload_1
      //   80: invokevirtual 63	java/lang/Object:toString	()Ljava/lang/String;
      //   83: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   86: ldc 93
      //   88: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   91: aload_2
      //   92: getfield 96	com/tencent/mm/wallet_core/c/y$b:fnF	Ljava/lang/String;
      //   95: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   98: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   101: invokestatic 101	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   104: aload_2
      //   105: invokevirtual 105	com/tencent/mm/wallet_core/c/y$b:aoU	()Ljava/lang/Object;
      //   108: astore_2
      //   109: aload 4
      //   111: ifnull +10 -> 121
      //   114: aload 4
      //   116: invokeinterface 109 1 0
      //   121: sipush 5475
      //   124: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   127: aload_2
      //   128: areturn
      //   129: ldc 89
      //   131: new 26	java/lang/StringBuilder
      //   134: dup
      //   135: ldc 91
      //   137: invokespecial 31	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   140: aload_1
      //   141: invokevirtual 63	java/lang/Object:toString	()Ljava/lang/String;
      //   144: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   147: ldc 111
      //   149: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   152: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   155: invokestatic 101	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   158: invokestatic 114	com/tencent/mm/wallet_core/c/y:cPJ	()Ljava/lang/Object;
      //   161: astore_2
      //   162: aload 4
      //   164: ifnull +10 -> 174
      //   167: aload 4
      //   169: invokeinterface 109 1 0
      //   174: sipush 5475
      //   177: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   180: aload_2
      //   181: areturn
      //   182: astore_3
      //   183: sipush 5475
      //   186: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   189: aload_3
      //   190: athrow
      //   191: astore_2
      //   192: aload 4
      //   194: ifnull +14 -> 208
      //   197: aload_3
      //   198: ifnull +57 -> 255
      //   201: aload 4
      //   203: invokeinterface 109 1 0
      //   208: sipush 5475
      //   211: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   214: aload_2
      //   215: athrow
      //   216: astore_2
      //   217: ldc 89
      //   219: aload_2
      //   220: ldc 116
      //   222: aload_1
      //   223: invokestatic 120	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   226: invokevirtual 124	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
      //   229: iconst_0
      //   230: anewarray 62	java/lang/Object
      //   233: invokestatic 128	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   236: sipush 5475
      //   239: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   242: aconst_null
      //   243: areturn
      //   244: astore 4
      //   246: aload_3
      //   247: aload 4
      //   249: invokevirtual 132	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
      //   252: goto -44 -> 208
      //   255: aload 4
      //   257: invokeinterface 109 1 0
      //   262: goto -54 -> 208
      //   265: astore_2
      //   266: aconst_null
      //   267: astore_3
      //   268: goto -76 -> 192
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	271	0	this	a
      //   0	271	1	paramK	K
      //   67	114	2	localObject1	Object
      //   191	24	2	localObject2	Object
      //   216	4	2	localRuntimeException	java.lang.RuntimeException
      //   265	1	2	localObject3	Object
      //   182	65	3	localThrowable1	java.lang.Throwable
      //   267	1	3	localObject4	Object
      //   32	170	4	localCursor	android.database.Cursor
      //   244	12	4	localThrowable2	java.lang.Throwable
      // Exception table:
      //   from	to	target	type
      //   34	109	182	java/lang/Throwable
      //   129	162	182	java/lang/Throwable
      //   183	191	191	finally
      //   6	34	216	java/lang/RuntimeException
      //   114	121	216	java/lang/RuntimeException
      //   167	174	216	java/lang/RuntimeException
      //   201	208	216	java/lang/RuntimeException
      //   208	216	216	java/lang/RuntimeException
      //   246	252	216	java/lang/RuntimeException
      //   255	262	216	java/lang/RuntimeException
      //   201	208	244	java/lang/Throwable
      //   34	109	265	finally
      //   129	162	265	finally
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.y
 * JD-Core Version:    0.7.0.1
 */