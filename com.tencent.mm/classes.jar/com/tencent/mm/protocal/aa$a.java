package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;
import java.util.Locale;

public final class aa$a
  extends l.d
  implements l.b
{
  public int YxZ;
  public int YyJ;
  public byte[] ctx;
  public byte[] mCq;
  public int netType;
  public byte[] networkId;
  public byte[] oMc;
  private int uin;
  
  public aa$a()
  {
    AppMethodBeat.i(133125);
    this.oMc = new byte[0];
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
    if (this.oMc == null) {}
    for (int i = -1;; i = this.oMc.length)
    {
      Log.d("MicroMsg.MMSyncCheck", "toProtoBuf dksynccheck uin:%d keybuf:%d, stack[%s]", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Util.getStack() });
      if ((this.uin != 0) && (!Util.isNullOrNil(this.oMc))) {
        break;
      }
      AppMethodBeat.o(133126);
      return new byte[0];
    }
    j = (this.uin >> 13 & 0x7FFFF | this.oMc.length << 19) ^ 0x5601F281;
    int k = (this.oMc.length >> 13 & 0x7FFFF | this.uin << 19) ^ 0x5601F281;
    byte[] arrayOfByte = new byte[this.oMc.length + 32];
    if ((this.networkId != null) && (this.networkId.length == 32))
    {
      i = this.YyJ + 36;
      arrayOfByte = new byte[this.oMc.length + 32 + 32 + 4 + this.YyJ];
    }
    for (;;)
    {
      Log.d("MicroMsg.MMSyncCheck", "dksynccheck uin=[%d/%d], keyBufLen=[%d/%d] outBuf=[%d]", new Object[] { Integer.valueOf(this.uin), Integer.valueOf(j), Integer.valueOf(this.oMc.length), Integer.valueOf(k), Integer.valueOf(arrayOfByte.length) });
      arrayOfByte[0] = ((byte)(j >> 24 & 0xFF));
      arrayOfByte[1] = ((byte)(j >> 16 & 0xFF));
      arrayOfByte[2] = ((byte)(j >> 8 & 0xFF));
      arrayOfByte[3] = ((byte)(j & 0xFF));
      arrayOfByte[4] = ((byte)(k >> 24 & 0xFF));
      arrayOfByte[5] = ((byte)(k >> 16 & 0xFF));
      arrayOfByte[6] = ((byte)(k >> 8 & 0xFF));
      arrayOfByte[7] = ((byte)(k & 0xFF));
      System.arraycopy(this.oMc, 0, arrayOfByte, 8, this.oMc.length);
      arrayOfByte[(arrayOfByte.length - 24 - i)] = ((byte)(d.Yxh >> 24 & 0xFF));
      arrayOfByte[(arrayOfByte.length - 23 - i)] = ((byte)(d.Yxh >> 16 & 0xFF));
      arrayOfByte[(arrayOfByte.length - 22 - i)] = ((byte)(d.Yxh >> 8 & 0xFF));
      arrayOfByte[(arrayOfByte.length - 21 - i)] = ((byte)(d.Yxh & 0xFF));
      String str = Locale.getDefault().toString();
      Object localObject = str;
      if (str.length() > 8) {
        localObject = str.substring(0, 8);
      }
      localObject = ((String)localObject).getBytes();
      System.arraycopy(localObject, 0, arrayOfByte, arrayOfByte.length - 20 - i, localObject.length);
      Log.d("MicroMsg.MMSyncCheck", "language:%x" + Arrays.toString((byte[])localObject));
      arrayOfByte[(arrayOfByte.length - 12 - i)] = 0;
      arrayOfByte[(arrayOfByte.length - 11 - i)] = 0;
      arrayOfByte[(arrayOfByte.length - 10 - i)] = 0;
      arrayOfByte[(arrayOfByte.length - 9 - i)] = 2;
      arrayOfByte[(arrayOfByte.length - 8 - i)] = ((byte)(this.netType >> 24 & 0xFF));
      arrayOfByte[(arrayOfByte.length - 7 - i)] = ((byte)(this.netType >> 16 & 0xFF));
      arrayOfByte[(arrayOfByte.length - 6 - i)] = ((byte)(this.netType >> 8 & 0xFF));
      arrayOfByte[(arrayOfByte.length - 5 - i)] = ((byte)(this.netType & 0xFF));
      arrayOfByte[(arrayOfByte.length - 4 - i)] = ((byte)(this.YxZ >> 24 & 0xFF));
      arrayOfByte[(arrayOfByte.length - 3 - i)] = ((byte)(this.YxZ >> 16 & 0xFF));
      arrayOfByte[(arrayOfByte.length - 2 - i)] = ((byte)(this.YxZ >> 8 & 0xFF));
      arrayOfByte[(arrayOfByte.length - 1 - i)] = ((byte)(this.YxZ & 0xFF));
      if ((this.networkId != null) && (this.networkId.length == 32))
      {
        Log.i("MicroMsg.MMSyncCheck", "copy networkid " + this.networkId.length + " " + this.YyJ);
        System.arraycopy(this.networkId, 0, arrayOfByte, this.oMc.length + 32, this.networkId.length);
        arrayOfByte[(arrayOfByte.length - this.YyJ - 4)] = ((byte)(this.YyJ >> 24 & 0xFF));
        arrayOfByte[(arrayOfByte.length - this.YyJ - 3)] = ((byte)(this.YyJ >> 16 & 0xFF));
        arrayOfByte[(arrayOfByte.length - this.YyJ - 2)] = ((byte)(this.YyJ >> 8 & 0xFF));
        arrayOfByte[(arrayOfByte.length - this.YyJ - 1)] = ((byte)(this.YyJ & 0xFF));
        if ((this.YyJ > 0) && (this.ctx != null) && (this.ctx.length == this.YyJ)) {
          System.arraycopy(this.ctx, 0, arrayOfByte, this.oMc.length + 32 + this.networkId.length + 4, this.ctx.length);
        }
      }
      Log.d("MicroMsg.MMSyncCheck", "outbuf:%x" + Arrays.toString(arrayOfByte) + " " + arrayOfByte.length);
      this.mCq = g.U(arrayOfByte);
      AppMethodBeat.o(133126);
      return arrayOfByte;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.aa.a
 * JD-Core Version:    0.7.0.1
 */