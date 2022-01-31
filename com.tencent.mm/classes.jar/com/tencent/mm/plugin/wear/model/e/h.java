package com.tencent.mm.plugin.wear.model.e;

import com.tencent.mm.plugin.wear.model.d;
import com.tencent.mm.protocal.c.cjk;
import com.tencent.mm.protocal.c.cjl;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.e;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class h
  extends a
{
  public final List<Integer> bYY()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(11000));
    localArrayList.add(Integer.valueOf(11003));
    localArrayList.add(Integer.valueOf(11035));
    return localArrayList;
  }
  
  public final boolean bYZ()
  {
    return false;
  }
  
  protected final byte[] p(int paramInt, byte[] paramArrayOfByte)
  {
    int i = 0;
    String str2;
    if (paramInt == 11000)
    {
      str2 = new String(paramArrayOfByte);
      paramArrayOfByte = "";
      try
      {
        localObject = e.bP(str2);
        paramArrayOfByte = (byte[])localObject;
      }
      catch (IOException localIOException1)
      {
        for (;;)
        {
          Object localObject;
          y.printErrStackTrace("MicroMsg.Wear.HttpLogServer", localIOException1, "handleData", new Object[0]);
        }
        if (localIOException1.size() <= 0) {
          break label145;
        }
        com.tencent.mm.plugin.report.service.h.nFQ.q("WearCrash", localIOException1);
        localIOException1.clear();
        e.deleteFile(str2);
      }
      paramArrayOfByte = paramArrayOfByte.split("​​");
      localObject = new ArrayList();
      paramInt = 0;
      while (paramInt < paramArrayOfByte.length)
      {
        ((List)localObject).add(paramArrayOfByte[paramInt]);
        if (paramInt % 50 == 9)
        {
          com.tencent.mm.plugin.report.service.h.nFQ.q("WearCrash", (List)localObject);
          ((List)localObject).clear();
        }
        paramInt += 1;
      }
    }
    for (;;)
    {
      label145:
      return null;
      if (paramInt == 11003)
      {
        str2 = new String(paramArrayOfByte);
        paramArrayOfByte = "";
        try
        {
          String str1 = e.bP(str2);
          paramArrayOfByte = str1;
        }
        catch (IOException localIOException2)
        {
          for (;;)
          {
            int j;
            y.printErrStackTrace("MicroMsg.Wear.HttpLogServer", localIOException2, "handleData", new Object[0]);
          }
          e.deleteFile(str2);
        }
        paramArrayOfByte = paramArrayOfByte.split("​​");
        j = paramArrayOfByte.length;
        paramInt = i;
        while (paramInt < j)
        {
          y.i("MicroMsg.Wear.LOG", paramArrayOfByte[paramInt]);
          paramInt += 1;
        }
        continue;
      }
      if (paramInt != 11035) {
        continue;
      }
      cjk localcjk = new cjk();
      try
      {
        localcjk.aH(paramArrayOfByte);
        label267:
        paramArrayOfByte = com.tencent.mm.plugin.wear.model.a.bYL().qRu.qRL.qSA;
        if (paramArrayOfByte == null) {
          continue;
        }
        y.v("MicroMsg.Wear.HttpLogServer", "report kv id=%d %s %s %s %s data=%s", new Object[] { Integer.valueOf(localcjk.kWl), paramArrayOfByte.hQd, paramArrayOfByte.tXi, Integer.valueOf(paramArrayOfByte.swP), paramArrayOfByte.tXj, localcjk.tTD });
        com.tencent.mm.plugin.report.service.h.nFQ.f(localcjk.kWl, new Object[] { paramArrayOfByte.hQd, paramArrayOfByte.tXi, Integer.valueOf(paramArrayOfByte.swP), paramArrayOfByte.tXj, localcjk.tTD });
      }
      catch (IOException paramArrayOfByte)
      {
        break label267;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.e.h
 * JD-Core Version:    0.7.0.1
 */