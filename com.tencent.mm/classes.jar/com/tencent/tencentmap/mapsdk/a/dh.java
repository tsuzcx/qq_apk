package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class dh
  extends ds
{
  private Context e = null;
  private Long[] f = null;
  private List<Long> g = null;
  private byte[] h = null;
  private boolean i = false;
  
  public dh(Context paramContext)
  {
    super(paramContext, 1, 4);
    this.e = paramContext;
  }
  
  private cr a(List<dn> paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {
      return null;
    }
    Object localObject1 = new ArrayList();
    int k = paramList.size();
    this.g = new ArrayList();
    int j = 0;
    for (;;)
    {
      if (j < k) {
        try
        {
          dn localdn = (dn)paramList.get(j);
          Object localObject2 = localdn.e();
          cy.a(" bean.getTP: " + localdn.b(), new Object[0]);
          if ((localObject2 == null) || (!"UA".equals(localdn.b()))) {
            break label356;
          }
          cy.f(" Pack2Upload eventName:}%s ", new Object[] { localdn.d() });
          localObject2 = e.a(localdn);
          if (localObject2 != null) {
            ((ArrayList)localObject1).add(localObject2);
          } else {
            this.g.add(Long.valueOf(localdn.a()));
          }
        }
        catch (Throwable paramList)
        {
          cy.a(paramList);
          cy.d(" CommonRecordUploadDatas.encode2MixPackage() error1", new Object[0]);
        }
      } else {
        for (;;)
        {
          try
          {
            if (((ArrayList)localObject1).size() > 0)
            {
              paramList = new cv();
              paramList.a = ((ArrayList)localObject1);
              if (paramList == null)
              {
                return null;
                if (this.g.size() > 0) {
                  e.a(this.e, (Long[])this.g.toArray(new Long[this.g.size()]));
                }
                cy.b(" up erList:" + ((ArrayList)localObject1).size(), new Object[0]);
                continue;
              }
              localObject1 = new HashMap();
              ((Map)localObject1).put(Integer.valueOf(1), paramList.a());
              paramList = new cr();
              paramList.a = ((Map)localObject1);
              return paramList;
            }
          }
          catch (Exception paramList)
          {
            cy.a(paramList);
            cy.d(" CommonRecordUploadDatas.encode2MixPackage() error2", new Object[0]);
            b();
            return null;
          }
          paramList = null;
        }
      }
      label356:
      j += 1;
    }
  }
  
  private boolean f()
  {
    try
    {
      boolean bool = this.i;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final cs a()
  {
    Object localObject9 = null;
    int k = 0;
    Object localObject6;
    try
    {
      Object localObject1 = dq.d();
      if ((localObject1 == null) || (!((dq)localObject1).e()))
      {
        cy.c(" imposiable! ua not ready!", new Object[0]);
        localObject1 = localObject9;
      }
      for (;;)
      {
        return localObject1;
        localObject6 = ((dq)localObject1).g();
        if (localObject6 == null)
        {
          cy.c(" imposiable! ua S not ready!", new Object[0]);
          localObject1 = localObject9;
        }
        else
        {
          try
          {
            if (f())
            {
              localObject7 = cg.a(this.e);
              if ((localObject7 != null) && (((List)localObject7).size() > 0))
              {
                localObject3 = (byte[])((List)localObject7).get(3);
                this.d = String.valueOf(((List)localObject7).get(1));
                ((Integer)((List)localObject7).get(4)).intValue();
                if (localObject3 != null)
                {
                  localObject3 = a(this.a, (byte[])localObject3);
                  continue;
                }
                m = ((dk)localObject6).e();
                j = m;
                if (!e.l(this.e)) {
                  j = m / 2;
                }
                if (j >= 0)
                {
                  localObject6 = e.a(this.e, j);
                  if ((localObject6 == null) || (((List)localObject6).size() <= 0))
                  {
                    cy.h(" no up datas", new Object[0]);
                    localObject3 = localObject9;
                  }
                }
              }
            }
          }
          catch (Throwable localThrowable)
          {
            cy.a(localThrowable);
            cy.d(" get req datas error: %s", new Object[] { localThrowable.toString() });
            localObject4 = localObject9;
          }
        }
      }
    }
    finally {}
    for (;;)
    {
      Object localObject7;
      Object localObject3;
      int m;
      break;
      int j = ((List)localObject6).size();
      cy.h(" size:%d", new Object[] { Integer.valueOf(j) });
      Object localObject8;
      try
      {
        localObject7 = a((List)localObject6);
        this.f = new Long[j];
        j = k;
        while (j < this.f.length)
        {
          this.f[j] = Long.valueOf(((dn)((List)localObject6).get(j)).a());
          j += 1;
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          b();
          localObject8 = null;
        }
        ((List)localObject6).clear();
        if (localObject8 == null) {
          break label458;
        }
      }
      Object localObject4 = localObject8.a();
      label458:
      for (;;)
      {
        for (;;)
        {
          this.h = new byte[localObject4.length];
          System.arraycopy(localObject4, 0, this.h, 0, localObject4.length);
          this.d = e.b(this.c, 4);
          cy.a("comm rid:%s", new Object[] { this.d });
          try
          {
            localObject4 = a(this.a, (byte[])localObject4);
          }
          catch (Exception localException1)
          {
            for (;;)
            {
              b();
              localObject5 = null;
            }
          }
        }
      }
      localObject6 = null;
      continue;
      Object localObject5 = null;
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    try
    {
      this.i = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void b()
  {
    try
    {
      cy.c(" encode failed, clear db data", new Object[0]);
      if ((this.f != null) && (this.f.length > 0))
      {
        int j = e.a(this.e, this.f);
        cy.b(" remove num :" + j, new Object[0]);
        this.f = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public final void b(boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 24	com/tencent/tencentmap/mapsdk/a/dh:f	[Ljava/lang/Long;
    //   8: ifnull +9 -> 17
    //   11: aload_0
    //   12: getfield 24	com/tencent/tencentmap/mapsdk/a/dh:f	[Ljava/lang/Long;
    //   15: arraylength
    //   16: istore_2
    //   17: iload_2
    //   18: ifle +39 -> 57
    //   21: aload_0
    //   22: getfield 22	com/tencent/tencentmap/mapsdk/a/dh:e	Landroid/content/Context;
    //   25: aload_0
    //   26: getfield 24	com/tencent/tencentmap/mapsdk/a/dh:f	[Ljava/lang/Long;
    //   29: invokestatic 137	com/tencent/tencentmap/mapsdk/a/e:a	(Landroid/content/Context;[Ljava/lang/Long;)I
    //   32: istore_3
    //   33: new 59	java/lang/StringBuilder
    //   36: dup
    //   37: ldc_w 261
    //   40: invokespecial 64	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   43: iload_3
    //   44: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   47: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: iconst_0
    //   51: anewarray 77	java/lang/Object
    //   54: invokestatic 144	com/tencent/tencentmap/mapsdk/a/cy:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   57: aload_0
    //   58: aconst_null
    //   59: putfield 24	com/tencent/tencentmap/mapsdk/a/dh:f	[Ljava/lang/Long;
    //   62: iload_1
    //   63: ifeq +30 -> 93
    //   66: aload_0
    //   67: invokespecial 194	com/tencent/tencentmap/mapsdk/a/dh:f	()Z
    //   70: ifeq +23 -> 93
    //   73: aload_0
    //   74: getfield 22	com/tencent/tencentmap/mapsdk/a/dh:e	Landroid/content/Context;
    //   77: aload_0
    //   78: getfield 206	com/tencent/tencentmap/mapsdk/a/dh:d	Ljava/lang/String;
    //   81: invokestatic 264	com/tencent/tencentmap/mapsdk/a/cg:a	(Landroid/content/Context;Ljava/lang/String;)Z
    //   84: pop
    //   85: aload_0
    //   86: aconst_null
    //   87: putfield 28	com/tencent/tencentmap/mapsdk/a/dh:h	[B
    //   90: aload_0
    //   91: monitorexit
    //   92: return
    //   93: iload_1
    //   94: ifne -9 -> 85
    //   97: aload_0
    //   98: getfield 28	com/tencent/tencentmap/mapsdk/a/dh:h	[B
    //   101: ifnull -16 -> 85
    //   104: ldc_w 266
    //   107: iconst_1
    //   108: anewarray 77	java/lang/Object
    //   111: dup
    //   112: iconst_0
    //   113: aload_0
    //   114: getfield 206	com/tencent/tencentmap/mapsdk/a/dh:d	Ljava/lang/String;
    //   117: aastore
    //   118: invokestatic 82	com/tencent/tencentmap/mapsdk/a/cy:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   121: aload_0
    //   122: getfield 22	com/tencent/tencentmap/mapsdk/a/dh:e	Landroid/content/Context;
    //   125: aload_0
    //   126: getfield 28	com/tencent/tencentmap/mapsdk/a/dh:h	[B
    //   129: aload_0
    //   130: getfield 206	com/tencent/tencentmap/mapsdk/a/dh:d	Ljava/lang/String;
    //   133: iload_2
    //   134: invokestatic 269	com/tencent/tencentmap/mapsdk/a/cg:a	(Landroid/content/Context;[BLjava/lang/String;I)Z
    //   137: pop
    //   138: goto -53 -> 85
    //   141: astore 4
    //   143: aload_0
    //   144: monitorexit
    //   145: aload 4
    //   147: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	148	0	this	dh
    //   0	148	1	paramBoolean	boolean
    //   1	133	2	j	int
    //   32	12	3	k	int
    //   141	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	17	141	finally
    //   21	57	141	finally
    //   57	62	141	finally
    //   66	85	141	finally
    //   85	90	141	finally
    //   97	138	141	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.dh
 * JD-Core Version:    0.7.0.1
 */