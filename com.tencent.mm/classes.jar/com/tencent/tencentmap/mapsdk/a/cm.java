package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.util.Base64;
import android.util.SparseArray;
import java.util.Map;
import java.util.Set;

public class cm
{
  private static cm a = null;
  private String b = "http://oth.str.mdt.qq.com:8080/analytics/upload";
  private int c = 360;
  private int d = 100;
  private SparseArray<a> e = null;
  private Map<String, String> f = null;
  private byte g = 3;
  private byte h = 2;
  private String i = "";
  private String j = "";
  private String k = "";
  
  private cm()
  {
    this.e.put(1, new a(1));
    this.e.put(2, new a(2));
    this.e.put(3, new a(3));
  }
  
  public static cm a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new cm();
      }
      return a;
    }
    finally {}
  }
  
  private void b(String paramString)
  {
    try
    {
      this.j = paramString;
      this.i = Base64.encodeToString(e.a(paramString), 2);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private void c(String paramString)
  {
    try
    {
      this.k = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  /* Error */
  final void a(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ldc 86
    //   5: invokestatic 89	com/tencent/tencentmap/mapsdk/a/e:a	(Landroid/content/Context;Ljava/lang/String;)[Ljava/lang/Object;
    //   8: astore 6
    //   10: aload 6
    //   12: ifnull +55 -> 67
    //   15: aload 6
    //   17: arraylength
    //   18: iconst_3
    //   19: if_icmpne +48 -> 67
    //   22: new 91	java/util/Date
    //   25: dup
    //   26: invokespecial 92	java/util/Date:<init>	()V
    //   29: invokevirtual 96	java/util/Date:getTime	()J
    //   32: ldc2_w 97
    //   35: ldiv
    //   36: lstore 4
    //   38: aload 6
    //   40: iconst_2
    //   41: aaload
    //   42: checkcast 100	java/lang/Long
    //   45: invokevirtual 103	java/lang/Long:longValue	()J
    //   48: lstore_2
    //   49: lload_2
    //   50: lload 4
    //   52: lcmp
    //   53: ifle +14 -> 67
    //   56: aload_0
    //   57: aload 6
    //   59: iconst_1
    //   60: aaload
    //   61: checkcast 105	java/lang/String
    //   64: invokespecial 107	com/tencent/tencentmap/mapsdk/a/cm:c	(Ljava/lang/String;)V
    //   67: aload_0
    //   68: aload_1
    //   69: invokestatic 110	com/tencent/tencentmap/mapsdk/a/e:k	(Landroid/content/Context;)Ljava/lang/String;
    //   72: invokespecial 112	com/tencent/tencentmap/mapsdk/a/cm:b	(Ljava/lang/String;)V
    //   75: aload_0
    //   76: monitorexit
    //   77: return
    //   78: astore 7
    //   80: lconst_0
    //   81: lstore_2
    //   82: goto -33 -> 49
    //   85: astore_1
    //   86: aload_0
    //   87: monitorexit
    //   88: aload_1
    //   89: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	this	cm
    //   0	90	1	paramContext	Context
    //   48	34	2	l1	long
    //   36	15	4	l2	long
    //   8	50	6	arrayOfObject	Object[]
    //   78	1	7	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   38	49	78	java/lang/Exception
    //   2	10	85	finally
    //   15	38	85	finally
    //   38	49	85	finally
    //   56	67	85	finally
    //   67	75	85	finally
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      this.k = paramString1;
      paramContext = new cm.1(this, paramString1, paramString2, paramContext);
      b.a().a(paramContext);
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public final void a(String paramString)
  {
    this.b = paramString;
  }
  
  public final void a(Map<String, String> paramMap)
  {
    this.f = paramMap;
  }
  
  /* Error */
  public final a b(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 43	com/tencent/tencentmap/mapsdk/a/cm:e	Landroid/util/SparseArray;
    //   6: ifnull +19 -> 25
    //   9: aload_0
    //   10: getfield 43	com/tencent/tencentmap/mapsdk/a/cm:e	Landroid/util/SparseArray;
    //   13: iload_1
    //   14: invokevirtual 134	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   17: checkcast 6	com/tencent/tencentmap/mapsdk/a/cm$a
    //   20: astore_2
    //   21: aload_0
    //   22: monitorexit
    //   23: aload_2
    //   24: areturn
    //   25: aconst_null
    //   26: astore_2
    //   27: goto -6 -> 21
    //   30: astore_2
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_2
    //   34: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	35	0	this	cm
    //   0	35	1	paramInt	int
    //   20	7	2	locala	a
    //   30	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	21	30	finally
  }
  
  public final String b()
  {
    return this.b;
  }
  
  public final int c()
  {
    return this.c;
  }
  
  public final Map<String, String> d()
  {
    return this.f;
  }
  
  /* Error */
  public final SparseArray<a> e()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 43	com/tencent/tencentmap/mapsdk/a/cm:e	Landroid/util/SparseArray;
    //   6: ifnull +23 -> 29
    //   9: new 141	com/tencent/tencentmap/mapsdk/a/cz
    //   12: dup
    //   13: invokespecial 142	com/tencent/tencentmap/mapsdk/a/cz:<init>	()V
    //   16: pop
    //   17: aload_0
    //   18: getfield 43	com/tencent/tencentmap/mapsdk/a/cm:e	Landroid/util/SparseArray;
    //   21: invokestatic 145	com/tencent/tencentmap/mapsdk/a/cz:a	(Landroid/util/SparseArray;)Landroid/util/SparseArray;
    //   24: astore_1
    //   25: aload_0
    //   26: monitorexit
    //   27: aload_1
    //   28: areturn
    //   29: aconst_null
    //   30: astore_1
    //   31: goto -6 -> 25
    //   34: astore_1
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_1
    //   38: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	39	0	this	cm
    //   24	7	1	localSparseArray	SparseArray
    //   34	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	25	34	finally
  }
  
  public final int f()
  {
    if (this.f != null)
    {
      String str = (String)this.f.get("maxStrategyQueryOneDay");
      if ((str != null) && (!str.trim().equals("")))
      {
        int m = this.d;
        try
        {
          int n = Integer.valueOf(str).intValue();
          return n;
        }
        catch (Exception localException)
        {
          return m;
        }
      }
    }
    return this.d;
  }
  
  /* Error */
  public final boolean g()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 45	com/tencent/tencentmap/mapsdk/a/cm:f	Ljava/util/Map;
    //   6: ifnull +50 -> 56
    //   9: aload_0
    //   10: getfield 45	com/tencent/tencentmap/mapsdk/a/cm:f	Ljava/util/Map;
    //   13: ldc 172
    //   15: invokeinterface 153 2 0
    //   20: checkcast 105	java/lang/String
    //   23: astore_3
    //   24: aload_3
    //   25: ifnull +31 -> 56
    //   28: ldc 174
    //   30: aload_3
    //   31: invokevirtual 178	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   34: ifeq +22 -> 56
    //   37: invokestatic 184	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   40: bipush 11
    //   42: invokevirtual 187	java/util/Calendar:get	(I)I
    //   45: istore_1
    //   46: iload_1
    //   47: ifne +9 -> 56
    //   50: iconst_1
    //   51: istore_2
    //   52: aload_0
    //   53: monitorexit
    //   54: iload_2
    //   55: ireturn
    //   56: iconst_0
    //   57: istore_2
    //   58: goto -6 -> 52
    //   61: astore_3
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_3
    //   65: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	66	0	this	cm
    //   45	2	1	m	int
    //   51	7	2	bool	boolean
    //   23	8	3	str	String
    //   61	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	24	61	finally
    //   28	46	61	finally
  }
  
  public final byte h()
  {
    try
    {
      byte b1 = this.g;
      return b1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final byte i()
  {
    try
    {
      byte b1 = this.h;
      return b1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final String j()
  {
    try
    {
      String str = this.i;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final String k()
  {
    try
    {
      String str = this.j;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final String l()
  {
    try
    {
      String str = this.k;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static final class a
  {
    private final int a;
    private boolean b = false;
    private String c = "http://oth.eve.mdt.qq.com:8080/analytics/upload";
    private String d = "http://jrlt.beacon.qq.com/analytics/upload";
    private Map<String, String> e = null;
    private Set<String> f = null;
    private Set<String> g = null;
    
    public a(int paramInt)
    {
      this.a = paramInt;
    }
    
    public final void a(String paramString)
    {
      this.c = paramString;
    }
    
    public final void a(Map<String, String> paramMap)
    {
      this.e = paramMap;
    }
    
    public final void a(Set<String> paramSet)
    {
      this.f = paramSet;
    }
    
    public final void a(boolean paramBoolean)
    {
      this.b = paramBoolean;
    }
    
    public final boolean a()
    {
      return this.b;
    }
    
    public final String b()
    {
      if (cy.b) {
        return this.d;
      }
      return this.c;
    }
    
    public final void b(Set<String> paramSet)
    {
      this.g = paramSet;
    }
    
    public final Map<String, String> c()
    {
      return this.e;
    }
    
    public final Set<String> d()
    {
      return this.f;
    }
    
    public final int e()
    {
      return this.a;
    }
    
    public final Set<String> f()
    {
      return this.g;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.cm
 * JD-Core Version:    0.7.0.1
 */