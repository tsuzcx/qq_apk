package com.tencent.mm.plugin.wear.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wear.model.d;
import com.tencent.mm.protocal.protobuf.gfw;
import com.tencent.mm.protocal.protobuf.gfx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.y;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class h
  extends a
{
  public final List<Integer> iob()
  {
    AppMethodBeat.i(30083);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(11000));
    localArrayList.add(Integer.valueOf(11003));
    localArrayList.add(Integer.valueOf(11035));
    AppMethodBeat.o(30083);
    return localArrayList;
  }
  
  public final boolean ioc()
  {
    return false;
  }
  
  protected final byte[] u(int paramInt, byte[] paramArrayOfByte)
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
        localObject = y.bEn(str2);
        paramArrayOfByte = (byte[])localObject;
      }
      catch (IOException localIOException1)
      {
        for (;;)
        {
          Object localObject;
          Log.printErrStackTrace("MicroMsg.Wear.HttpLogServer", localIOException1, "handleData", new Object[0]);
        }
        if (localIOException1.size() <= 0) {
          break label151;
        }
        com.tencent.mm.plugin.report.service.h.OAn.F("WearCrash", localIOException1);
        localIOException1.clear();
        y.deleteFile(str2);
      }
      paramArrayOfByte = paramArrayOfByte.split("​​");
      localObject = new ArrayList();
      paramInt = 0;
      while (paramInt < paramArrayOfByte.length)
      {
        ((List)localObject).add(paramArrayOfByte[paramInt]);
        if (paramInt % 50 == 9)
        {
          com.tencent.mm.plugin.report.service.h.OAn.F("WearCrash", (List)localObject);
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
          String str1 = y.bEn(str2);
          paramArrayOfByte = str1;
        }
        catch (IOException localIOException2)
        {
          for (;;)
          {
            int j;
            Log.printErrStackTrace("MicroMsg.Wear.HttpLogServer", localIOException2, "handleData", new Object[0]);
          }
          y.deleteFile(str2);
        }
        paramArrayOfByte = paramArrayOfByte.split("​​");
        j = paramArrayOfByte.length;
        paramInt = i;
        while (paramInt < j)
        {
          Log.i("MicroMsg.Wear.LOG", paramArrayOfByte[paramInt]);
          paramInt += 1;
        }
        continue;
      }
      if (paramInt != 11035) {
        continue;
      }
      gfw localgfw = new gfw();
      try
      {
        localgfw.parseFrom(paramArrayOfByte);
        label279:
        paramArrayOfByte = com.tencent.mm.plugin.wear.model.a.inI().Wiz.Wjk;
        if (paramArrayOfByte == null) {
          continue;
        }
        Log.v("MicroMsg.Wear.HttpLogServer", "report kv id=%d %s %s %s %s data=%s", new Object[] { Integer.valueOf(localgfw.IMf), paramArrayOfByte.vgX, paramArrayOfByte.accI, Integer.valueOf(paramArrayOfByte.YHj), paramArrayOfByte.accJ, localgfw.YVP });
        com.tencent.mm.plugin.report.service.h.OAn.b(localgfw.IMf, new Object[] { paramArrayOfByte.vgX, paramArrayOfByte.accI, Integer.valueOf(paramArrayOfByte.YHj), paramArrayOfByte.accJ, localgfw.YVP });
      }
      catch (IOException paramArrayOfByte)
      {
        break label279;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.e.h
 * JD-Core Version:    0.7.0.1
 */