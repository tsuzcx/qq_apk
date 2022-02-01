package com.tencent.pb.common.c;

import com.tencent.pb.common.b.a;
import com.tencent.pb.common.b.a.a.a.c;
import com.tencent.pb.common.b.a.a.a.x;
import com.tencent.pb.common.b.f;
import com.tencent.pb.common.b.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public final class e
{
  private static HashMap<String, String> Iod = new HashMap();
  private static Object sLock = new Object();
  
  public static void R(int paramInt1, int paramInt2, String paramString)
  {
    if (paramString == null)
    {
      b.w("gyz", new Object[] { "addEmergencyRecord value is null" });
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
        String str = (String)Iod.get(localStringBuffer.toString());
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
        Iod.put(localStringBuffer.toString(), localObject1);
        return;
      }
      return;
    }
    catch (Throwable paramString)
    {
      b.w("gyz", new Object[] { paramString });
    }
  }
  
  private static void aR(ArrayList<a.x> paramArrayList)
  {
    for (;;)
    {
      StringBuffer localStringBuffer;
      Object localObject4;
      Object localObject3;
      String str;
      synchronized (sLock)
      {
        Object localObject2 = Iod.keySet();
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
        localObject4 = (String)Iod.get(localObject4);
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
                localObject5 = new a.x();
                ((a.x)localObject5).IlT = localObject3;
                localStringBuffer.setLength(0);
                localStringBuffer.append(str);
                localStringBuffer.append("%");
                localStringBuffer.append((String)???);
                ((a.x)localObject5).IlU = localStringBuffer.toString();
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
      Iod.clear();
      return;
    }
  }
  
  public static void flD()
  {
    if (!h.isNetworkConnected())
    {
      b.w("StatisticsUtil", new Object[] { "reportStatisticsData network is false" });
      return;
    }
    ArrayList localArrayList = new ArrayList();
    aR(localArrayList);
    a.c localc;
    if (localArrayList.size() > 0)
    {
      localc = new a.c();
      a.x[] arrayOfx = new a.x[localArrayList.size()];
      localArrayList.toArray(arrayOfx);
      localc.IkC = arrayOfx;
    }
    while (localc == null)
    {
      b.w("StatisticsUtil", new Object[] { "reportStatisticsData CSClientReportReq is null" });
      return;
      localc = null;
    }
    b.w("yunying", new Object[] { "reportStatisticsData" });
    b.d("StatisticsUtil", new Object[] { "reportStatisticsData start ret: ", Integer.valueOf(f.flo().a(new a()
    {
      public final void gp(String paramAnonymousString, int paramAnonymousInt)
      {
        if ("CsCmd.Cmd_CSClientReportReq".equals(paramAnonymousString))
        {
          if (paramAnonymousInt == 0) {
            e.clearData();
          }
          b.w("yunying", new Object[] { "reportStatisticsData isCommonData:  errCode: ".concat(String.valueOf(paramAnonymousInt)) });
        }
      }
    }, "CsCmd.Cmd_CSClientReportReq", localc)) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.pb.common.c.e
 * JD-Core Version:    0.7.0.1
 */