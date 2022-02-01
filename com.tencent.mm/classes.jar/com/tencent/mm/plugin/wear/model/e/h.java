package com.tencent.mm.plugin.wear.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wear.model.d;
import com.tencent.mm.protocal.protobuf.drb;
import com.tencent.mm.protocal.protobuf.drc;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class h
  extends a
{
  public final List<Integer> ehn()
  {
    AppMethodBeat.i(30083);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(11000));
    localArrayList.add(Integer.valueOf(11003));
    localArrayList.add(Integer.valueOf(11035));
    AppMethodBeat.o(30083);
    return localArrayList;
  }
  
  public final boolean eho()
  {
    return false;
  }
  
  protected final byte[] s(int paramInt, byte[] paramArrayOfByte)
  {
    int i = 0;
    AppMethodBeat.i(30084);
    String str2;
    if (paramInt == 11000)
    {
      str2 = new String(paramArrayOfByte);
      paramArrayOfByte = "";
      try
      {
        localObject = com.tencent.mm.vfs.i.aMP(str2);
        paramArrayOfByte = (byte[])localObject;
      }
      catch (IOException localIOException1)
      {
        for (;;)
        {
          Object localObject;
          ad.printErrStackTrace("MicroMsg.Wear.HttpLogServer", localIOException1, "handleData", new Object[0]);
        }
        if (localIOException1.size() <= 0) {
          break label151;
        }
        com.tencent.mm.plugin.report.service.h.vKh.w("WearCrash", localIOException1);
        localIOException1.clear();
        com.tencent.mm.vfs.i.deleteFile(str2);
      }
      paramArrayOfByte = paramArrayOfByte.split("​​");
      localObject = new ArrayList();
      paramInt = 0;
      while (paramInt < paramArrayOfByte.length)
      {
        ((List)localObject).add(paramArrayOfByte[paramInt]);
        if (paramInt % 50 == 9)
        {
          com.tencent.mm.plugin.report.service.h.vKh.w("WearCrash", (List)localObject);
          ((List)localObject).clear();
        }
        paramInt += 1;
      }
    }
    for (;;)
    {
      label151:
      AppMethodBeat.o(30084);
      return null;
      if (paramInt == 11003)
      {
        str2 = new String(paramArrayOfByte);
        paramArrayOfByte = "";
        try
        {
          String str1 = com.tencent.mm.vfs.i.aMP(str2);
          paramArrayOfByte = str1;
        }
        catch (IOException localIOException2)
        {
          for (;;)
          {
            int j;
            ad.printErrStackTrace("MicroMsg.Wear.HttpLogServer", localIOException2, "handleData", new Object[0]);
          }
          com.tencent.mm.vfs.i.deleteFile(str2);
        }
        paramArrayOfByte = paramArrayOfByte.split("​​");
        j = paramArrayOfByte.length;
        paramInt = i;
        while (paramInt < j)
        {
          ad.i("MicroMsg.Wear.LOG", paramArrayOfByte[paramInt]);
          paramInt += 1;
        }
        continue;
      }
      if (paramInt != 11035) {
        continue;
      }
      drb localdrb = new drb();
      try
      {
        localdrb.parseFrom(paramArrayOfByte);
        label279:
        paramArrayOfByte = com.tencent.mm.plugin.wear.model.a.egV().ADZ.AEM;
        if (paramArrayOfByte == null) {
          continue;
        }
        ad.v("MicroMsg.Wear.HttpLogServer", "report kv id=%d %s %s %s %s data=%s", new Object[] { Integer.valueOf(localdrb.sdO), paramArrayOfByte.mAV, paramArrayOfByte.EGm, Integer.valueOf(paramArrayOfByte.CyE), paramArrayOfByte.EGn, localdrb.DAq });
        com.tencent.mm.plugin.report.service.h.vKh.f(localdrb.sdO, new Object[] { paramArrayOfByte.mAV, paramArrayOfByte.EGm, Integer.valueOf(paramArrayOfByte.CyE), paramArrayOfByte.EGn, localdrb.DAq });
      }
      catch (IOException paramArrayOfByte)
      {
        break label279;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.e.h
 * JD-Core Version:    0.7.0.1
 */