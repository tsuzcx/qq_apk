package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.gt;
import com.tencent.mm.sdk.platformtools.ab;

public final class k
{
  public static final class a
    extends l.d
    implements l.b
  {
    public gt wir;
    public byte[] wis;
    
    public a()
    {
      AppMethodBeat.i(28276);
      this.wir = new gt();
      AppMethodBeat.o(28276);
    }
    
    public final int getCmdId()
    {
      return 1000;
    }
    
    public final int getFuncId()
    {
      return 1000;
    }
    
    public final byte[] toProtoBuf()
    {
      AppMethodBeat.i(28277);
      this.wir.setBaseRequest(l.a(this));
      ab.d("MicroMsg.MMBakchatCreateQRcodeOffline.Req", "key:%s  AddrCount:%s  AddrList:%s, PCName:%s, PCAcctName:%s, Scene:%s, DataSize:%s, WifiName:%s, Tickit:%s", new Object[] { this.wis, Integer.valueOf(this.wir.wta), this.wir.wtb, this.wir.wtc, this.wir.wtd, Integer.valueOf(this.wir.Scene), Long.valueOf(this.wir.jJO), this.wir.wte, this.wir.wtf });
      byte[] arrayOfByte = this.wir.toByteArray();
      AppMethodBeat.o(28277);
      return arrayOfByte;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.k
 * JD-Core Version:    0.7.0.1
 */