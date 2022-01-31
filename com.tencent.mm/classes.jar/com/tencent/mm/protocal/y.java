package com.tencent.mm.protocal;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Locale;

public final class y
{
  public static final class a
    extends l.d
    implements l.b
  {
    public byte[] eHy;
    public byte[] fIx;
    public int netType;
    private int uin;
    public int wiu;
    
    public a()
    {
      AppMethodBeat.i(58866);
      this.fIx = new byte[0];
      this.uin = 0;
      AppMethodBeat.o(58866);
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
      AppMethodBeat.i(58867);
      int j = this.uin;
      if (this.fIx == null) {}
      for (int i = -1;; i = this.fIx.length)
      {
        ab.d("MicroMsg.MMSyncCheck", "toProtoBuf dksynccheck uin:%d keybuf:%d, stack[%s]", new Object[] { Integer.valueOf(j), Integer.valueOf(i), bo.dtY() });
        if ((this.uin != 0) && (!bo.ce(this.fIx))) {
          break;
        }
        AppMethodBeat.o(58867);
        return new byte[0];
      }
      i = (this.uin >> 13 & 0x7FFFF | this.fIx.length << 19) ^ 0x5601F281;
      j = 0x5601F281 ^ (this.fIx.length >> 13 & 0x7FFFF | this.uin << 19);
      byte[] arrayOfByte = new byte[this.fIx.length + 32];
      ab.d("MicroMsg.MMSyncCheck", "dksynccheck uin=[%d/%d], keyBufLen=[%d/%d] outBuf=[%d]", new Object[] { Integer.valueOf(this.uin), Integer.valueOf(i), Integer.valueOf(this.fIx.length), Integer.valueOf(j), Integer.valueOf(arrayOfByte.length) });
      arrayOfByte[0] = ((byte)(i >> 24 & 0xFF));
      arrayOfByte[1] = ((byte)(i >> 16 & 0xFF));
      arrayOfByte[2] = ((byte)(i >> 8 & 0xFF));
      arrayOfByte[3] = ((byte)(i & 0xFF));
      arrayOfByte[4] = ((byte)(j >> 24 & 0xFF));
      arrayOfByte[5] = ((byte)(j >> 16 & 0xFF));
      arrayOfByte[6] = ((byte)(j >> 8 & 0xFF));
      arrayOfByte[7] = ((byte)(j & 0xFF));
      System.arraycopy(this.fIx, 0, arrayOfByte, 8, this.fIx.length);
      arrayOfByte[(arrayOfByte.length - 24)] = ((byte)(d.whH >> 24 & 0xFF));
      arrayOfByte[(arrayOfByte.length - 23)] = ((byte)(d.whH >> 16 & 0xFF));
      arrayOfByte[(arrayOfByte.length - 22)] = ((byte)(d.whH >> 8 & 0xFF));
      arrayOfByte[(arrayOfByte.length - 21)] = ((byte)(d.whH & 0xFF));
      String str = Locale.getDefault().toString();
      Object localObject = str;
      if (str.length() > 8) {
        localObject = str.substring(0, 8);
      }
      localObject = ((String)localObject).getBytes();
      System.arraycopy(localObject, 0, arrayOfByte, arrayOfByte.length - 20, localObject.length);
      ab.d("MicroMsg.MMSyncCheck", "language:%x" + Arrays.toString((byte[])localObject));
      arrayOfByte[(arrayOfByte.length - 12)] = 0;
      arrayOfByte[(arrayOfByte.length - 11)] = 0;
      arrayOfByte[(arrayOfByte.length - 10)] = 0;
      arrayOfByte[(arrayOfByte.length - 9)] = 2;
      arrayOfByte[(arrayOfByte.length - 8)] = ((byte)(this.netType >> 24 & 0xFF));
      arrayOfByte[(arrayOfByte.length - 7)] = ((byte)(this.netType >> 16 & 0xFF));
      arrayOfByte[(arrayOfByte.length - 6)] = ((byte)(this.netType >> 8 & 0xFF));
      arrayOfByte[(arrayOfByte.length - 5)] = ((byte)(this.netType & 0xFF));
      arrayOfByte[(arrayOfByte.length - 4)] = ((byte)(this.wiu >> 24 & 0xFF));
      arrayOfByte[(arrayOfByte.length - 3)] = ((byte)(this.wiu >> 16 & 0xFF));
      arrayOfByte[(arrayOfByte.length - 2)] = ((byte)(this.wiu >> 8 & 0xFF));
      arrayOfByte[(arrayOfByte.length - 1)] = ((byte)(this.wiu & 0xFF));
      ab.d("MicroMsg.MMSyncCheck", "outbuf:%x" + Arrays.toString(arrayOfByte));
      this.eHy = g.x(arrayOfByte);
      AppMethodBeat.o(58867);
      return arrayOfByte;
    }
  }
  
  public static final class b
    extends l.e
    implements l.c
  {
    private String cBW = null;
    public byte[] eHy = null;
    public long wiX = 7L;
    private byte[] wiY;
    
    @TargetApi(9)
    public final String dqD()
    {
      AppMethodBeat.i(58868);
      if (this.eHy == null)
      {
        AppMethodBeat.o(58868);
        return "";
      }
      Object localObject;
      if (this.cBW == null)
      {
        localObject = MMProtocalJni.aesDecrypt(this.wiY, this.eHy);
        if (bo.ce((byte[])localObject))
        {
          AppMethodBeat.o(58868);
          return "";
        }
        if (Build.VERSION.SDK_INT < 9) {
          break label91;
        }
      }
      label91:
      for (this.cBW = new String((byte[])localObject, Charset.forName("UTF-8"));; this.cBW = new String((byte[])localObject))
      {
        localObject = this.cBW;
        AppMethodBeat.o(58868);
        return localObject;
      }
    }
    
    public final int fromProtoBuf(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(58869);
      if ((paramArrayOfByte == null) || (paramArrayOfByte.length < 12))
      {
        StringBuilder localStringBuilder = new StringBuilder("dksynccheck err resp buf:");
        if (paramArrayOfByte == null) {}
        for (i = -1;; i = paramArrayOfByte.length)
        {
          ab.e("MicroMsg.MMSyncCheck", i);
          AppMethodBeat.o(58869);
          return -1;
        }
      }
      this.wiX = (paramArrayOfByte[3] & 0xFF | (paramArrayOfByte[2] & 0xFF) << 8 | (paramArrayOfByte[1] & 0xFF) << 16 | (paramArrayOfByte[0] & 0xFF) << 24);
      int i = paramArrayOfByte[7] & 0xFF | (paramArrayOfByte[6] & 0xFF) << 8 | (paramArrayOfByte[5] & 0xFF) << 16 | (paramArrayOfByte[4] & 0xFF) << 24;
      int j = paramArrayOfByte[11] & 0xFF | (paramArrayOfByte[10] & 0xFF) << 8 | (paramArrayOfByte[9] & 0xFF) << 16 | (paramArrayOfByte[8] & 0xFF) << 24;
      ab.d("MicroMsg.MMSyncCheck", " fromProtoBuf oreh synccheck resp selector:%d, redCode:%d, keyLen:%d", new Object[] { Long.valueOf(this.wiX), Integer.valueOf(i), Integer.valueOf(j) });
      if (i != -3002)
      {
        this.cBW = "";
        AppMethodBeat.o(58869);
        return i;
      }
      if ((j != paramArrayOfByte.length - 12) && (j != paramArrayOfByte.length - 12 - 16))
      {
        ab.e("MicroMsg.MMSyncCheck", " the key len is invalid keyLen:%d, bufLen:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(paramArrayOfByte.length) });
        AppMethodBeat.o(58869);
        return -1;
      }
      if (j == paramArrayOfByte.length - 12 - 16)
      {
        this.eHy = new byte[16];
        System.arraycopy(paramArrayOfByte, paramArrayOfByte.length - 16, this.eHy, 0, 16);
      }
      this.wiY = new byte[j];
      System.arraycopy(paramArrayOfByte, 12, this.wiY, 0, j);
      AppMethodBeat.o(58869);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.y
 * JD-Core Version:    0.7.0.1
 */