package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.li;
import com.tencent.mm.protocal.protobuf.lj;
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
    public int RBw = 0;
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
      Object localObject2 = new li();
      ((li)localObject2).RPe = d.RAD;
      ((li)localObject2).RQp = 2;
      ((li)localObject2).RQq = this.netType;
      ((li)localObject2).RQr = this.RBw;
      Log.i("MicroMsg.MMBgFg", "somr online:%d nettype:%d ver:%d devid:%d", new Object[] { Integer.valueOf(((li)localObject2).RQr), Integer.valueOf(((li)localObject2).RQq), Integer.valueOf(((li)localObject2).RPe), Integer.valueOf(((li)localObject2).RQp) });
      Object localObject1 = null;
      try
      {
        localObject2 = ((li)localObject2).toByteArray();
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
  
  public static final class b
    extends l.e
    implements l.c
  {
    public lj RBx;
    
    public b()
    {
      AppMethodBeat.i(32085);
      this.RBx = new lj();
      AppMethodBeat.o(32085);
    }
    
    public final int fromProtoBuf(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(32086);
      this.RBx = ((lj)new lj().parseFrom(paramArrayOfByte));
      Log.d("MicroMsg.MMBgFg", "retcode:" + this.RBx.fwx);
      int i = this.RBx.fwx;
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