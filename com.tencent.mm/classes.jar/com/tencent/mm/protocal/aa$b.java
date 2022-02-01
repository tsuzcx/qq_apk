package com.tencent.mm.protocal;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.nio.charset.Charset;

public final class aa$b
  extends l.e
  implements l.c
{
  public long FHg = 7L;
  private byte[] FHh;
  private String dCX = null;
  public byte[] gDA = null;
  
  @TargetApi(9)
  public final String fkm()
  {
    AppMethodBeat.i(133127);
    if (this.gDA == null)
    {
      AppMethodBeat.o(133127);
      return "";
    }
    Object localObject;
    if (this.dCX == null)
    {
      localObject = MMProtocalJni.aesDecrypt(this.FHh, this.gDA);
      if (bu.cF((byte[])localObject))
      {
        AppMethodBeat.o(133127);
        return "";
      }
      if (Build.VERSION.SDK_INT < 9) {
        break label91;
      }
    }
    label91:
    for (this.dCX = new String((byte[])localObject, Charset.forName("UTF-8"));; this.dCX = new String((byte[])localObject))
    {
      localObject = this.dCX;
      AppMethodBeat.o(133127);
      return localObject;
    }
  }
  
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(133128);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length < 12))
    {
      StringBuilder localStringBuilder = new StringBuilder("dksynccheck err resp buf:");
      if (paramArrayOfByte == null) {}
      for (i = -1;; i = paramArrayOfByte.length)
      {
        ae.e("MicroMsg.MMSyncCheck", i);
        AppMethodBeat.o(133128);
        return -1;
      }
    }
    this.FHg = (paramArrayOfByte[3] & 0xFF | (paramArrayOfByte[2] & 0xFF) << 8 | (paramArrayOfByte[1] & 0xFF) << 16 | (paramArrayOfByte[0] & 0xFF) << 24);
    int i = paramArrayOfByte[7] & 0xFF | (paramArrayOfByte[6] & 0xFF) << 8 | (paramArrayOfByte[5] & 0xFF) << 16 | (paramArrayOfByte[4] & 0xFF) << 24;
    int j = paramArrayOfByte[11] & 0xFF | (paramArrayOfByte[10] & 0xFF) << 8 | (paramArrayOfByte[9] & 0xFF) << 16 | (paramArrayOfByte[8] & 0xFF) << 24;
    ae.d("MicroMsg.MMSyncCheck", " fromProtoBuf oreh synccheck resp selector:%d, redCode:%d, keyLen:%d", new Object[] { Long.valueOf(this.FHg), Integer.valueOf(i), Integer.valueOf(j) });
    if (i != -3002)
    {
      this.dCX = "";
      AppMethodBeat.o(133128);
      return i;
    }
    if ((j != paramArrayOfByte.length - 12) && (j != paramArrayOfByte.length - 12 - 16))
    {
      ae.e("MicroMsg.MMSyncCheck", " the key len is invalid keyLen:%d, bufLen:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(paramArrayOfByte.length) });
      AppMethodBeat.o(133128);
      return -1;
    }
    if (j == paramArrayOfByte.length - 12 - 16)
    {
      this.gDA = new byte[16];
      System.arraycopy(paramArrayOfByte, paramArrayOfByte.length - 16, this.gDA, 0, 16);
    }
    this.FHh = new byte[j];
    System.arraycopy(paramArrayOfByte, 12, this.FHh, 0, j);
    AppMethodBeat.o(133128);
    return i;
  }
  
  public final int getCmdId()
  {
    return 1000000205;
  }
  
  public final boolean isRawData()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.aa.b
 * JD-Core Version:    0.7.0.1
 */