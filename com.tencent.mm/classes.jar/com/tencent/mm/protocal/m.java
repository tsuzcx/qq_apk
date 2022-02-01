package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.lb;
import com.tencent.mm.protocal.protobuf.lc;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.io.IOException;

public final class m
  extends a
{
  public static final class a
    extends l.d
    implements l.b
  {
    public int FGv = 0;
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
      Object localObject2 = new lb();
      ((lb)localObject2).FUA = d.FFH;
      ((lb)localObject2).FVG = 2;
      ((lb)localObject2).FVH = this.netType;
      ((lb)localObject2).FVI = this.FGv;
      ae.i("MicroMsg.MMBgFg", "somr online:%d nettype:%d ver:%d devid:%d", new Object[] { Integer.valueOf(((lb)localObject2).FVI), Integer.valueOf(((lb)localObject2).FVH), Integer.valueOf(((lb)localObject2).FUA), Integer.valueOf(((lb)localObject2).FVG) });
      Object localObject1 = null;
      try
      {
        localObject2 = ((lb)localObject2).toByteArray();
        localObject1 = localObject2;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          ae.e("MicroMsg.MMBgFg", "MMBgfg toProtoBuf exception:%s", new Object[] { bu.o(localIOException) });
        }
      }
      AppMethodBeat.o(32084);
      return localObject1;
    }
  }
  
  public static final class b
    extends l.e
    implements l.c
  {
    public lc FGw;
    
    public b()
    {
      AppMethodBeat.i(32085);
      this.FGw = new lc();
      AppMethodBeat.o(32085);
    }
    
    public final int fromProtoBuf(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(32086);
      this.FGw = ((lc)new lc().parseFrom(paramArrayOfByte));
      ae.d("MicroMsg.MMBgFg", "retcode:" + this.FGw.dmy);
      int i = this.FGw.dmy;
      AppMethodBeat.o(32086);
      return i;
    }
    
    public final int getCmdId()
    {
      return 1000000312;
    }
    
    public final boolean isRawData()
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.m
 * JD-Core Version:    0.7.0.1
 */