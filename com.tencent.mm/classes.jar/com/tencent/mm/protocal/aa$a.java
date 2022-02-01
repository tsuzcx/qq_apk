package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Arrays;
import java.util.Locale;

public final class aa$a
  extends l.d
  implements l.b
{
  public int DIQ;
  public byte[] ghj;
  public byte[] hMd;
  public int netType;
  private int uin;
  
  public aa$a()
  {
    AppMethodBeat.i(133125);
    this.hMd = new byte[0];
    this.uin = 0;
    AppMethodBeat.o(133125);
  }
  
  public final int getCmdId()
  {
    return 205;
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
  
  public final void setUin(int paramInt)
  {
    this.uin = paramInt;
  }
  
  public final byte[] toProtoBuf()
  {
    AppMethodBeat.i(133126);
    int j = this.uin;
    if (this.hMd == null) {}
    for (int i = -1;; i = this.hMd.length)
    {
      ac.d("MicroMsg.MMSyncCheck", "toProtoBuf dksynccheck uin:%d keybuf:%d, stack[%s]", new Object[] { Integer.valueOf(j), Integer.valueOf(i), bs.eWi() });
      if ((this.uin != 0) && (!bs.cv(this.hMd))) {
        break;
      }
      AppMethodBeat.o(133126);
      return new byte[0];
    }
    i = (this.uin >> 13 & 0x7FFFF | this.hMd.length << 19) ^ 0x5601F281;
    j = 0x5601F281 ^ (this.hMd.length >> 13 & 0x7FFFF | this.uin << 19);
    byte[] arrayOfByte = new byte[this.hMd.length + 32];
    ac.d("MicroMsg.MMSyncCheck", "dksynccheck uin=[%d/%d], keyBufLen=[%d/%d] outBuf=[%d]", new Object[] { Integer.valueOf(this.uin), Integer.valueOf(i), Integer.valueOf(this.hMd.length), Integer.valueOf(j), Integer.valueOf(arrayOfByte.length) });
    arrayOfByte[0] = ((byte)(i >> 24 & 0xFF));
    arrayOfByte[1] = ((byte)(i >> 16 & 0xFF));
    arrayOfByte[2] = ((byte)(i >> 8 & 0xFF));
    arrayOfByte[3] = ((byte)(i & 0xFF));
    arrayOfByte[4] = ((byte)(j >> 24 & 0xFF));
    arrayOfByte[5] = ((byte)(j >> 16 & 0xFF));
    arrayOfByte[6] = ((byte)(j >> 8 & 0xFF));
    arrayOfByte[7] = ((byte)(j & 0xFF));
    System.arraycopy(this.hMd, 0, arrayOfByte, 8, this.hMd.length);
    arrayOfByte[(arrayOfByte.length - 24)] = ((byte)(d.DIc >> 24 & 0xFF));
    arrayOfByte[(arrayOfByte.length - 23)] = ((byte)(d.DIc >> 16 & 0xFF));
    arrayOfByte[(arrayOfByte.length - 22)] = ((byte)(d.DIc >> 8 & 0xFF));
    arrayOfByte[(arrayOfByte.length - 21)] = ((byte)(d.DIc & 0xFF));
    String str = Locale.getDefault().toString();
    Object localObject = str;
    if (str.length() > 8) {
      localObject = str.substring(0, 8);
    }
    localObject = ((String)localObject).getBytes();
    System.arraycopy(localObject, 0, arrayOfByte, arrayOfByte.length - 20, localObject.length);
    ac.d("MicroMsg.MMSyncCheck", "language:%x" + Arrays.toString((byte[])localObject));
    arrayOfByte[(arrayOfByte.length - 12)] = 0;
    arrayOfByte[(arrayOfByte.length - 11)] = 0;
    arrayOfByte[(arrayOfByte.length - 10)] = 0;
    arrayOfByte[(arrayOfByte.length - 9)] = 2;
    arrayOfByte[(arrayOfByte.length - 8)] = ((byte)(this.netType >> 24 & 0xFF));
    arrayOfByte[(arrayOfByte.length - 7)] = ((byte)(this.netType >> 16 & 0xFF));
    arrayOfByte[(arrayOfByte.length - 6)] = ((byte)(this.netType >> 8 & 0xFF));
    arrayOfByte[(arrayOfByte.length - 5)] = ((byte)(this.netType & 0xFF));
    arrayOfByte[(arrayOfByte.length - 4)] = ((byte)(this.DIQ >> 24 & 0xFF));
    arrayOfByte[(arrayOfByte.length - 3)] = ((byte)(this.DIQ >> 16 & 0xFF));
    arrayOfByte[(arrayOfByte.length - 2)] = ((byte)(this.DIQ >> 8 & 0xFF));
    arrayOfByte[(arrayOfByte.length - 1)] = ((byte)(this.DIQ & 0xFF));
    ac.d("MicroMsg.MMSyncCheck", "outbuf:%x" + Arrays.toString(arrayOfByte));
    this.ghj = g.C(arrayOfByte);
    AppMethodBeat.o(133126);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.aa.a
 * JD-Core Version:    0.7.0.1
 */