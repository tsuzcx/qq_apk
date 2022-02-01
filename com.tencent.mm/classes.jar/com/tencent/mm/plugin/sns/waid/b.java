package com.tencent.mm.plugin.sns.waid;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class b
  implements c
{
  protected Context mContext;
  protected SharedPreferences xZp;
  protected ArrayList<h> xZq = new ArrayList();
  
  private void aq(ArrayList<h> paramArrayList)
  {
    long l1 = System.currentTimeMillis();
    try
    {
      JSONArray localJSONArray = new JSONArray();
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext())
      {
        JSONObject localJSONObject = ((h)localIterator.next()).toJson();
        if (localJSONObject != null)
        {
          localJSONArray.put(localJSONObject);
          continue;
          l2 = System.currentTimeMillis();
        }
      }
    }
    catch (Exception localException)
    {
      ad.e("ad.waid.BaseSpWaidStorageImpl", "saveAll exp=" + localException.toString());
    }
    for (;;)
    {
      long l2;
      ad.i("ad.waid.BaseSpWaidStorageImpl", "saveAll, cost=" + (l2 - l1) + ", total=" + paramArrayList.size());
      return;
      this.xZp.edit().putString(dEy(), localException.toString()).apply();
    }
  }
  
  private ArrayList<h> aqV(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      int i;
      try
      {
        long l1 = System.currentTimeMillis();
        paramString = new JSONArray(paramString);
        int j = paramString.length();
        i = 0;
        if (i < j)
        {
          h localh = h.aH(paramString.getJSONObject(i));
          if ((localh.isValid()) && (!localArrayList.contains(localh))) {
            localArrayList.add(localh);
          }
        }
        else
        {
          long l2 = System.currentTimeMillis();
          ad.i("ad.waid.BaseSpWaidStorageImpl", "parseAll, cost=" + (l2 - l1) + ", count=" + localArrayList.size() + ", sp=" + dEx());
          return localArrayList;
        }
      }
      catch (Exception paramString)
      {
        ad.e("ad.waid.BaseSpWaidStorageImpl", "parseAll exp=" + paramString.toString() + ", sp=" + dEx());
        return localArrayList;
      }
      i += 1;
    }
  }
  
  public final boolean a(h paramh)
  {
    if (paramh == null)
    {
      ad.w("ad.waid.BaseSpWaidStorageImpl", "addWaid, item==null");
      return false;
    }
    try
    {
      this.xZq.remove(paramh);
      this.xZq.add(paramh);
      ad.i("ad.waid.BaseSpWaidStorageImpl", "addWaid, item=".concat(String.valueOf(paramh)));
      aq(this.xZq);
      return true;
    }
    finally {}
  }
  
  public final boolean b(h paramh)
  {
    boolean bool = true;
    for (;;)
    {
      try
      {
        if (!this.xZq.remove(paramh)) {
          break label61;
        }
        i = 1;
        if (i > 0)
        {
          ad.i("ad.waid.BaseSpWaidStorageImpl", "delWaid, ret=".concat(String.valueOf(bool)));
          if (bool) {
            aq(this.xZq);
          }
          return bool;
        }
      }
      finally {}
      bool = false;
      continue;
      label61:
      int i = 0;
    }
  }
  
  /* Error */
  public final boolean dEA()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 22	com/tencent/mm/plugin/sns/waid/b:xZq	Ljava/util/ArrayList;
    //   8: invokevirtual 194	java/util/ArrayList:isEmpty	()Z
    //   11: ifne +33 -> 44
    //   14: aload_0
    //   15: getfield 22	com/tencent/mm/plugin/sns/waid/b:xZq	Ljava/util/ArrayList;
    //   18: iconst_0
    //   19: invokevirtual 197	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   22: pop
    //   23: ldc 62
    //   25: ldc 199
    //   27: invokestatic 101	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   30: aload_0
    //   31: aload_0
    //   32: getfield 22	com/tencent/mm/plugin/sns/waid/b:xZq	Ljava/util/ArrayList;
    //   35: invokespecial 184	com/tencent/mm/plugin/sns/waid/b:aq	(Ljava/util/ArrayList;)V
    //   38: iconst_1
    //   39: istore_1
    //   40: aload_0
    //   41: monitorexit
    //   42: iload_1
    //   43: ireturn
    //   44: ldc 62
    //   46: ldc 201
    //   48: invokestatic 101	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   51: goto -11 -> 40
    //   54: astore_2
    //   55: aload_0
    //   56: monitorexit
    //   57: aload_2
    //   58: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	this	b
    //   1	42	1	bool	boolean
    //   54	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	38	54	finally
    //   44	51	54	finally
  }
  
  public final int dEB()
  {
    int i = 0;
    for (;;)
    {
      int j;
      try
      {
        j = this.xZq.size() - 1;
        if (j >= 0)
        {
          h localh = (h)this.xZq.get(j);
          if (localh.isExpired())
          {
            this.xZq.remove(localh);
            i += 1;
          }
        }
        else
        {
          ad.i("ad.waid.BaseSpWaidStorageImpl", "delExpireItems, delNum=".concat(String.valueOf(i)));
          if (i > 0) {
            aq(this.xZq);
          }
          return i;
        }
      }
      finally {}
      j -= 1;
    }
  }
  
  public final int getCount()
  {
    try
    {
      int i = this.xZq.size();
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void init(Context paramContext)
  {
    try
    {
      this.mContext = paramContext;
      this.xZp = paramContext.getSharedPreferences(dEx(), 0);
      this.xZq = aqV(this.xZp.getString(dEy(), "[]"));
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.waid.b
 * JD-Core Version:    0.7.0.1
 */