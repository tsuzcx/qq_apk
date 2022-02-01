package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ks;
import com.tencent.mm.protocal.protobuf.kt;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.io.IOException;

public final class m
  extends a
{
  public static final class a
    extends l.d
    implements l.b
  {
    public int DIQ = 0;
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
      Object localObject2 = new ks();
      ((ks)localObject2).DWJ = d.DIc;
      ((ks)localObject2).DXP = 2;
      ((ks)localObject2).DXQ = this.netType;
      ((ks)localObject2).DXR = this.DIQ;
      ac.i("MicroMsg.MMBgFg", "somr online:%d nettype:%d ver:%d devid:%d", new Object[] { Integer.valueOf(((ks)localObject2).DXR), Integer.valueOf(((ks)localObject2).DXQ), Integer.valueOf(((ks)localObject2).DWJ), Integer.valueOf(((ks)localObject2).DXP) });
      Object localObject1 = null;
      try
      {
        localObject2 = ((ks)localObject2).toByteArray();
        localObject1 = localObject2;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          ac.e("MicroMsg.MMBgFg", "MMBgfg toProtoBuf exception:%s", new Object[] { bs.m(localIOException) });
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
    public kt DIR;
    
    public b()
    {
      AppMethodBeat.i(32085);
      this.DIR = new kt();
      AppMethodBeat.o(32085);
    }
    
    public final int fromProtoBuf(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(32086);
      this.DIR = ((kt)new kt().parseFrom(paramArrayOfByte));
      ac.d("MicroMsg.MMBgFg", "retcode:" + this.DIR.dae);
      int i = this.DIR.dae;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.m
 * JD-Core Version:    0.7.0.1
 */