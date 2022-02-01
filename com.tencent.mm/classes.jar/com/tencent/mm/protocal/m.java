package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ls;
import com.tencent.mm.protocal.protobuf.lt;
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
    public int KzG = 0;
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
      Object localObject2 = new ls();
      ((ls)localObject2).KOj = d.KyO;
      ((ls)localObject2).KPr = 2;
      ((ls)localObject2).KPs = this.netType;
      ((ls)localObject2).KPt = this.KzG;
      Log.i("MicroMsg.MMBgFg", "somr online:%d nettype:%d ver:%d devid:%d", new Object[] { Integer.valueOf(((ls)localObject2).KPt), Integer.valueOf(((ls)localObject2).KPs), Integer.valueOf(((ls)localObject2).KOj), Integer.valueOf(((ls)localObject2).KPr) });
      Object localObject1 = null;
      try
      {
        localObject2 = ((ls)localObject2).toByteArray();
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
    public lt KzH;
    
    public b()
    {
      AppMethodBeat.i(32085);
      this.KzH = new lt();
      AppMethodBeat.o(32085);
    }
    
    public final int fromProtoBuf(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(32086);
      this.KzH = ((lt)new lt().parseFrom(paramArrayOfByte));
      Log.d("MicroMsg.MMBgFg", "retcode:" + this.KzH.dDN);
      int i = this.KzH.dDN;
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