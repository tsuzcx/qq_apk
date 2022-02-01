package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.km;
import com.tencent.mm.protocal.protobuf.kn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.IOException;

public final class m
  extends a
{
  public static final class a
    extends l.d
    implements l.b
  {
    public int Cqy = 0;
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
      Object localObject2 = new km();
      ((km)localObject2).CEj = d.CpK;
      ((km)localObject2).CFp = 2;
      ((km)localObject2).CFq = this.netType;
      ((km)localObject2).CFr = this.Cqy;
      ad.i("MicroMsg.MMBgFg", "somr online:%d nettype:%d ver:%d devid:%d", new Object[] { Integer.valueOf(((km)localObject2).CFr), Integer.valueOf(((km)localObject2).CFq), Integer.valueOf(((km)localObject2).CEj), Integer.valueOf(((km)localObject2).CFp) });
      Object localObject1 = null;
      try
      {
        localObject2 = ((km)localObject2).toByteArray();
        localObject1 = localObject2;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          ad.e("MicroMsg.MMBgFg", "MMBgfg toProtoBuf exception:%s", new Object[] { bt.m(localIOException) });
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
    public kn Cqz;
    
    public b()
    {
      AppMethodBeat.i(32085);
      this.Cqz = new kn();
      AppMethodBeat.o(32085);
    }
    
    public final int fromProtoBuf(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(32086);
      this.Cqz = ((kn)new kn().parseFrom(paramArrayOfByte));
      ad.d("MicroMsg.MMBgFg", "retcode:" + this.Cqz.dcG);
      int i = this.Cqz.dcG;
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