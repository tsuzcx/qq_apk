package com.tencent.pb.common.c;

import com.tencent.pb.common.b.a.a.c;
import com.tencent.pb.common.b.a.a.w;
import com.tencent.pb.common.b.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public final class f
{
  private static HashMap<String, String> Bhi = new HashMap();
  private static Object sLock = new Object();
  
  public static void F(int paramInt1, int paramInt2, String paramString)
  {
    if (paramString == null)
    {
      c.w("gyz", new Object[] { "addEmergencyRecord value is null" });
      return;
    }
    try
    {
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append(paramInt1);
      localStringBuffer.append("---");
      localStringBuffer.append(paramInt2);
      synchronized (sLock)
      {
        String str = (String)Bhi.get(localStringBuffer.toString());
        Object localObject1 = paramString;
        if (str != null)
        {
          localObject1 = paramString;
          if (str.length() > 0)
          {
            localObject1 = new StringBuffer(str);
            ((StringBuffer)localObject1).append("---");
            ((StringBuffer)localObject1).append(paramString);
            localObject1 = ((StringBuffer)localObject1).toString();
          }
        }
        Bhi.put(localStringBuffer.toString(), localObject1);
        return;
      }
      return;
    }
    catch (Throwable paramString)
    {
      c.w("gyz", new Object[] { paramString });
    }
  }
  
  private static void au(ArrayList<a.w> paramArrayList)
  {
    for (;;)
    {
      StringBuffer localStringBuffer;
      Object localObject4;
      Object localObject3;
      String str;
      synchronized (sLock)
      {
        Object localObject2 = Bhi.keySet();
        if ((localObject2 == null) || (((Set)localObject2).size() <= 0)) {
          return;
        }
        localStringBuffer = new StringBuffer();
        localObject2 = ((Set)localObject2).iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject4 = (String)((Iterator)localObject2).next();
        ??? = ((String)localObject4).split("---");
        if (???.length < 2) {
          continue;
        }
        localObject3 = ???[0];
        str = ???[1];
      }
      synchronized (sLock)
      {
        localObject4 = (String)Bhi.get(localObject4);
        if ((localObject4 != null) && (((String)localObject4).length() != 0))
        {
          localObject4 = ((String)localObject4).split("---");
          if ((localObject4 != null) && (localObject4.length != 0))
          {
            int j = localObject4.length;
            int i = 0;
            while (i < j)
            {
              ??? = localObject4[i];
              if ((??? != null) && (((String)???).length() != 0))
              {
                Object localObject5 = ((String)???).split("%");
                if (localObject5.length == 2) {
                  ??? = localObject5[1];
                }
                localObject5 = new a.w();
                ((a.w)localObject5).BeX = localObject3;
                localStringBuffer.setLength(0);
                localStringBuffer.append(str);
                localStringBuffer.append("%");
                localStringBuffer.append((String)???);
                ((a.w)localObject5).BeY = localStringBuffer.toString();
                paramArrayList.add(localObject5);
              }
              i += 1;
            }
            paramArrayList = finally;
            throw paramArrayList;
          }
        }
      }
    }
  }
  
  public static void clearData()
  {
    synchronized (sLock)
    {
      Bhi.clear();
      return;
    }
  }
  
  public static void dTW()
  {
    if (!h.isNetworkConnected())
    {
      c.w("StatisticsUtil", new Object[] { "reportStatisticsData network is false" });
      return;
    }
    ArrayList localArrayList = new ArrayList();
    au(localArrayList);
    a.c localc;
    if (localArrayList.size() > 0)
    {
      localc = new a.c();
      a.w[] arrayOfw = new a.w[localArrayList.size()];
      localArrayList.toArray(arrayOfw);
      localc.BdH = arrayOfw;
    }
    while (localc == null)
    {
      c.w("StatisticsUtil", new Object[] { "reportStatisticsData CSClientReportReq is null" });
      return;
      localc = null;
    }
    c.w("yunying", new Object[] { "reportStatisticsData" });
    c.d("StatisticsUtil", new Object[] { "reportStatisticsData start ret: ", Integer.valueOf(com.tencent.pb.common.b.f.dTH().a(new f.1(), "CsCmd.Cmd_CSClientReportReq", localc)) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.pb.common.c.f
 * JD-Core Version:    0.7.0.1
 */