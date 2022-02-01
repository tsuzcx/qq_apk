package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.mj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;

public final class m
  extends a
{
  public static final class a
    extends l.d
    implements l.b
  {
    public int YxZ = 0;
    public int netType;
    
    public final int getCmdId()
    {
      return 312;
    }
    
    public final int getFuncId()
    {
      return 0;
    }
    
    public final boolean getShortSupport()
    {
      return false;
    }
    
    public final boolean isRawData()
    {
      return true;
    }
    
    public final byte[] toProtoBuf()
    {
      AppMethodBeat.i(32084);
      Object localObject2 = new mj();
      ((mj)localObject2).YMr = d.Yxh;
      ((mj)localObject2).YNF = 2;
      ((mj)localObject2).YNG = this.netType;
      ((mj)localObject2).YNH = this.YxZ;
      Log.i("MicroMsg.MMBgFg", "somr online:%d nettype:%d ver:%d devid:%d", new Object[] { Integer.valueOf(((mj)localObject2).YNH), Integer.valueOf(((mj)localObject2).YNG), Integer.valueOf(((mj)localObject2).YMr), Integer.valueOf(((mj)localObject2).YNF) });
      Object localObject1 = null;
      try
      {
        localObject2 = ((mj)localObject2).toByteArray();
        localObject1 = localObject2;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          Log.e("MicroMsg.MMBgFg", "MMBgfg toProtoBuf exception:%s", new Object[] { Util.stackTraceToString(localIOException) });
        }
      }
      AppMethodBeat.o(32084);
      return localObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.m
 * JD-Core Version:    0.7.0.1
 */