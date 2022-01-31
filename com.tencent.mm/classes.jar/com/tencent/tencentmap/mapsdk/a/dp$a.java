package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class dp$a
  extends ds
{
  private List<dn> e = null;
  private Context f;
  private Long[] g = null;
  private boolean h = false;
  
  public dp$a(Context paramContext, List<dn> paramList)
  {
    super(paramContext, 1, 2);
    this.e = paramList;
    this.f = paramContext;
    this.e.size();
    if ((this.e.size() == 1) && ("rqd_heartbeat".equals(((dn)this.e.get(0)).d()))) {
      this.h = true;
    }
    this.d = e.b(paramContext, 2);
    cy.a("real rid:%s", new Object[] { this.d });
  }
  
  private static cs a(int paramInt, List<dn> paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {}
    for (;;)
    {
      return null;
      try
      {
        cy.b(" current size:" + paramList.size(), new Object[0]);
        paramList = a(paramList);
        if (paramList != null)
        {
          paramList = paramList.a();
          if (paramList != null)
          {
            paramList = a(paramInt, paramList);
            return paramList;
          }
        }
      }
      catch (Throwable paramList)
      {
        cy.a(paramList);
        cy.d(" RealTimeRecordUploadDatas.encode2EventRecordPackage error}", new Object[0]);
      }
    }
    return null;
  }
  
  private static cv a(List<dn> paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {
      return null;
    }
    cv localcv;
    try
    {
      localcv = new cv();
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        cu localcu = e.a((dn)paramList.next());
        if (localcu != null) {
          localArrayList.add(localcu);
        }
      }
      localcv.a = localArrayList;
    }
    catch (Throwable paramList)
    {
      cy.a(paramList);
      return null;
    }
    cy.b(" RealTimeRecordUploadDatas.encode2EventRecordPackage() end}", new Object[0]);
    return localcv;
  }
  
  /* Error */
  public final cs a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 147
    //   4: iconst_0
    //   5: anewarray 66	java/lang/Object
    //   8: invokestatic 93	com/tencent/tencentmap/mapsdk/a/cy:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   11: aload_0
    //   12: getfield 23	com/tencent/tencentmap/mapsdk/a/dp$a:e	Ljava/util/List;
    //   15: ifnull +17 -> 32
    //   18: aload_0
    //   19: getfield 23	com/tencent/tencentmap/mapsdk/a/dp$a:e	Ljava/util/List;
    //   22: invokeinterface 35 1 0
    //   27: istore_1
    //   28: iload_1
    //   29: ifgt +9 -> 38
    //   32: aconst_null
    //   33: astore_2
    //   34: aload_0
    //   35: monitorexit
    //   36: aload_2
    //   37: areturn
    //   38: aload_0
    //   39: getfield 150	com/tencent/tencentmap/mapsdk/a/dp$a:a	I
    //   42: aload_0
    //   43: getfield 23	com/tencent/tencentmap/mapsdk/a/dp$a:e	Ljava/util/List;
    //   46: invokestatic 152	com/tencent/tencentmap/mapsdk/a/dp$a:a	(ILjava/util/List;)Lcom/tencent/tencentmap/mapsdk/a/cs;
    //   49: astore_3
    //   50: aload_3
    //   51: astore_2
    //   52: aload_3
    //   53: ifnonnull -19 -> 34
    //   56: aconst_null
    //   57: astore_2
    //   58: goto -24 -> 34
    //   61: astore_2
    //   62: aload_2
    //   63: invokestatic 107	com/tencent/tencentmap/mapsdk/a/cy:a	(Ljava/lang/Throwable;)V
    //   66: ldc 154
    //   68: iconst_0
    //   69: anewarray 66	java/lang/Object
    //   72: invokestatic 111	com/tencent/tencentmap/mapsdk/a/cy:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   75: goto -19 -> 56
    //   78: astore_2
    //   79: aload_0
    //   80: monitorexit
    //   81: aload_2
    //   82: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	83	0	this	a
    //   27	2	1	i	int
    //   33	25	2	localObject1	Object
    //   61	2	2	localThrowable	Throwable
    //   78	4	2	localObject2	Object
    //   49	4	3	localcs	cs
    // Exception table:
    //   from	to	target	type
    //   38	50	61	java/lang/Throwable
    //   2	28	78	finally
    //   38	50	78	finally
    //   62	75	78	finally
  }
  
  public final void b(boolean paramBoolean)
  {
    try
    {
      cy.b(" TimeUpUploadDatas.done(), result:%b", new Object[] { Boolean.valueOf(paramBoolean) });
      if ((this.e != null) && (!paramBoolean))
      {
        cy.f(" upload failed, save to db", new Object[0]);
        if (!this.h)
        {
          this.g = e.a(this.f, this.e);
          this.e = null;
        }
      }
      if ((paramBoolean) && (this.h))
      {
        Context localContext = this.f;
        b.a().a(108);
        a.a(localContext, "HEART_DENGTA", e.g());
        cy.a("heartbeat uploaded sucess!", new Object[0]);
      }
      if ((paramBoolean) && (this.g != null)) {
        e.a(this.f, this.g);
      }
      if ((paramBoolean) && (this.g == null) && (this.e != null)) {
        this.e = null;
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.dp.a
 * JD-Core Version:    0.7.0.1
 */