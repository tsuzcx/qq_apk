package com.tencent.mm.protocal;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.charset.Charset;

public final class aa$b
  extends l.e
  implements l.c
{
  public long YyK = 7L;
  private byte[] YyL;
  public int YyM = 0;
  public byte[] ctx;
  public byte[] mCq = null;
  public byte[] networkId;
  private String xml = null;
  
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(133128);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length < 12))
    {
      StringBuilder localStringBuilder = new StringBuilder("dksynccheck err resp buf:");
      if (paramArrayOfByte == null) {}
      for (i = -1;; i = paramArrayOfByte.length)
      {
        Log.e("MicroMsg.MMSyncCheck", i);
        AppMethodBeat.o(133128);
        return -1;
      }
    }
    this.YyK = (paramArrayOfByte[3] & 0xFF | (paramArrayOfByte[2] & 0xFF) << 8 | (paramArrayOfByte[1] & 0xFF) << 16 | (paramArrayOfByte[0] & 0xFF) << 24);
    int i = paramArrayOfByte[7] & 0xFF | (paramArrayOfByte[6] & 0xFF) << 8 | (paramArrayOfByte[5] & 0xFF) << 16 | (paramArrayOfByte[4] & 0xFF) << 24;
    int j = paramArrayOfByte[11] & 0xFF | (paramArrayOfByte[10] & 0xFF) << 8 | (paramArrayOfByte[9] & 0xFF) << 16 | (paramArrayOfByte[8] & 0xFF) << 24;
    Log.d("MicroMsg.MMSyncCheck", " fromProtoBuf oreh synccheck resp selector:%d, redCode:%d, keyLen:%d, buf length:%d", new Object[] { Long.valueOf(this.YyK), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramArrayOfByte.length) });
    if (i != -3002)
    {
      this.xml = "";
      if (paramArrayOfByte.length > j + 12)
      {
        this.YyM = (paramArrayOfByte[(j + 15)] & 0xFF | (paramArrayOfByte[(j + 14)] & 0xFF) << 8 | (paramArrayOfByte[(j + 13)] & 0xFF) << 16 | (paramArrayOfByte[(j + 12)] & 0xFF) << 24);
        this.networkId = new byte[32];
        System.arraycopy(paramArrayOfByte, j + 16, this.networkId, 0, 32);
        int k = paramArrayOfByte[(j + 51)] & 0xFF | (paramArrayOfByte[(j + 50)] & 0xFF) << 8 | (paramArrayOfByte[(j + 49)] & 0xFF) << 16 | (paramArrayOfByte[(j + 48)] & 0xFF) << 24;
        this.ctx = new byte[0];
        if (k > 0)
        {
          this.ctx = new byte[k];
          System.arraycopy(paramArrayOfByte, j + 52, this.ctx, 0, k);
        }
      }
      AppMethodBeat.o(133128);
      return i;
    }
    if ((j != paramArrayOfByte.length - 12) && (j != paramArrayOfByte.length - 12 - 16))
    {
      Log.e("MicroMsg.MMSyncCheck", " the key len is invalid keyLen:%d, bufLen:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(paramArrayOfByte.length) });
      AppMethodBeat.o(133128);
      return -1;
    }
    if (j == paramArrayOfByte.length - 12 - 16)
    {
      this.mCq = new byte[16];
      System.arraycopy(paramArrayOfByte, paramArrayOfByte.length - 16, this.mCq, 0, 16);
    }
    this.YyL = new byte[j];
    System.arraycopy(paramArrayOfByte, 12, this.YyL, 0, j);
    AppMethodBeat.o(133128);
    return i;
  }
  
  public final int getCmdId()
  {
    return 1000000205;
  }
  
  public final String iQa()
  {
    AppMethodBeat.i(133127);
    if (this.mCq == null)
    {
      AppMethodBeat.o(133127);
      return "";
    }
    Object localObject;
    if (this.xml == null)
    {
      localObject = MMProtocalJni.aesDecrypt(this.YyL, this.mCq);
      if (Util.isNullOrNil((byte[])localObject))
      {
        AppMethodBeat.o(133127);
        return "";
      }
      if (Build.VERSION.SDK_INT < 9) {
        break label91;
      }
    }
    label91:
    for (this.xml = new String((byte[])localObject, Charset.forName("UTF-8"));; this.xml = new String((byte[])localObject))
    {
      localObject = this.xml;
      AppMethodBeat.o(133127);
      return localObject;
    }
  }
  
  public final boolean isRawData()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.aa.b
 * JD-Core Version:    0.7.0.1
 */