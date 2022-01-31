package com.tencent.mm.protocal;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import com.tencent.mm.a.g;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Locale;

public final class w
{
  public static final class a
    extends k.d
    implements k.b
  {
    public byte[] dKa;
    public byte[] esK = new byte[0];
    public int netType;
    public int spQ;
    public int uin = 0;
    
    public final byte[] HG()
    {
      int j = this.uin;
      if (this.esK == null) {}
      for (int i = -1;; i = this.esK.length)
      {
        y.d("MicroMsg.MMSyncCheck", "toProtoBuf dksynccheck uin:%d keybuf:%d, stack[%s]", new Object[] { Integer.valueOf(j), Integer.valueOf(i), bk.csb() });
        if ((this.uin != 0) && (!bk.bE(this.esK))) {
          break;
        }
        return new byte[0];
      }
      i = (this.uin >> 13 & 0x7FFFF | this.esK.length << 19) ^ 0x5601F281;
      j = 0x5601F281 ^ (this.esK.length >> 13 & 0x7FFFF | this.uin << 19);
      byte[] arrayOfByte = new byte[this.esK.length + 32];
      y.d("MicroMsg.MMSyncCheck", "dksynccheck uin=[%d/%d], keyBufLen=[%d/%d] outBuf=[%d]", new Object[] { Integer.valueOf(this.uin), Integer.valueOf(i), Integer.valueOf(this.esK.length), Integer.valueOf(j), Integer.valueOf(arrayOfByte.length) });
      arrayOfByte[0] = ((byte)(i >> 24 & 0xFF));
      arrayOfByte[1] = ((byte)(i >> 16 & 0xFF));
      arrayOfByte[2] = ((byte)(i >> 8 & 0xFF));
      arrayOfByte[3] = ((byte)(i & 0xFF));
      arrayOfByte[4] = ((byte)(j >> 24 & 0xFF));
      arrayOfByte[5] = ((byte)(j >> 16 & 0xFF));
      arrayOfByte[6] = ((byte)(j >> 8 & 0xFF));
      arrayOfByte[7] = ((byte)(j & 0xFF));
      System.arraycopy(this.esK, 0, arrayOfByte, 8, this.esK.length);
      arrayOfByte[(arrayOfByte.length - 24)] = ((byte)(d.spa >> 24 & 0xFF));
      arrayOfByte[(arrayOfByte.length - 23)] = ((byte)(d.spa >> 16 & 0xFF));
      arrayOfByte[(arrayOfByte.length - 22)] = ((byte)(d.spa >> 8 & 0xFF));
      arrayOfByte[(arrayOfByte.length - 21)] = ((byte)(d.spa & 0xFF));
      String str = Locale.getDefault().toString();
      Object localObject = str;
      if (str.length() > 8) {
        localObject = str.substring(0, 8);
      }
      localObject = ((String)localObject).getBytes();
      System.arraycopy(localObject, 0, arrayOfByte, arrayOfByte.length - 20, localObject.length);
      y.d("MicroMsg.MMSyncCheck", "language:%x" + Arrays.toString((byte[])localObject));
      arrayOfByte[(arrayOfByte.length - 12)] = 0;
      arrayOfByte[(arrayOfByte.length - 11)] = 0;
      arrayOfByte[(arrayOfByte.length - 10)] = 0;
      arrayOfByte[(arrayOfByte.length - 9)] = 2;
      arrayOfByte[(arrayOfByte.length - 8)] = ((byte)(this.netType >> 24 & 0xFF));
      arrayOfByte[(arrayOfByte.length - 7)] = ((byte)(this.netType >> 16 & 0xFF));
      arrayOfByte[(arrayOfByte.length - 6)] = ((byte)(this.netType >> 8 & 0xFF));
      arrayOfByte[(arrayOfByte.length - 5)] = ((byte)(this.netType & 0xFF));
      arrayOfByte[(arrayOfByte.length - 4)] = ((byte)(this.spQ >> 24 & 0xFF));
      arrayOfByte[(arrayOfByte.length - 3)] = ((byte)(this.spQ >> 16 & 0xFF));
      arrayOfByte[(arrayOfByte.length - 2)] = ((byte)(this.spQ >> 8 & 0xFF));
      arrayOfByte[(arrayOfByte.length - 1)] = ((byte)(this.spQ & 0xFF));
      y.d("MicroMsg.MMSyncCheck", "outbuf:%x" + Arrays.toString(arrayOfByte));
      this.dKa = g.p(arrayOfByte);
      return arrayOfByte;
    }
    
    public final int HH()
    {
      return 0;
    }
    
    public final boolean Lb()
    {
      return false;
    }
    
    public final boolean cpe()
    {
      return true;
    }
    
    public final void fn(int paramInt)
    {
      this.uin = paramInt;
    }
    
    public final int getCmdId()
    {
      return 205;
    }
  }
  
  public static final class b
    extends k.e
    implements k.c
  {
    private String bUr = null;
    public byte[] dKa = null;
    public long sqp = 7L;
    private byte[] sqq;
    
    public final int A(byte[] paramArrayOfByte)
    {
      if ((paramArrayOfByte == null) || (paramArrayOfByte.length < 12))
      {
        StringBuilder localStringBuilder = new StringBuilder("dksynccheck err resp buf:");
        if (paramArrayOfByte == null) {}
        for (i = -1;; i = paramArrayOfByte.length)
        {
          y.e("MicroMsg.MMSyncCheck", i);
          return -1;
        }
      }
      this.sqp = (paramArrayOfByte[3] & 0xFF | (paramArrayOfByte[2] & 0xFF) << 8 | (paramArrayOfByte[1] & 0xFF) << 16 | (paramArrayOfByte[0] & 0xFF) << 24);
      int i = paramArrayOfByte[7] & 0xFF | (paramArrayOfByte[6] & 0xFF) << 8 | (paramArrayOfByte[5] & 0xFF) << 16 | (paramArrayOfByte[4] & 0xFF) << 24;
      int j = paramArrayOfByte[11] & 0xFF | (paramArrayOfByte[10] & 0xFF) << 8 | (paramArrayOfByte[9] & 0xFF) << 16 | (paramArrayOfByte[8] & 0xFF) << 24;
      y.d("MicroMsg.MMSyncCheck", " fromProtoBuf oreh synccheck resp selector:%d, redCode:%d, keyLen:%d", new Object[] { Long.valueOf(this.sqp), Integer.valueOf(i), Integer.valueOf(j) });
      if (i != -3002)
      {
        this.bUr = "";
        return i;
      }
      if ((j != paramArrayOfByte.length - 12) && (j != paramArrayOfByte.length - 12 - 16))
      {
        y.e("MicroMsg.MMSyncCheck", " the key len is invalid keyLen:%d, bufLen:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(paramArrayOfByte.length) });
        return -1;
      }
      if (j == paramArrayOfByte.length - 12 - 16)
      {
        this.dKa = new byte[16];
        System.arraycopy(paramArrayOfByte, paramArrayOfByte.length - 16, this.dKa, 0, 16);
      }
      this.sqq = new byte[j];
      System.arraycopy(paramArrayOfByte, 12, this.sqq, 0, j);
      return i;
    }
    
    public final boolean cpe()
    {
      return true;
    }
    
    @TargetApi(9)
    public final String cpg()
    {
      if (this.dKa == null) {
        return "";
      }
      byte[] arrayOfByte;
      if (this.bUr == null)
      {
        arrayOfByte = MMProtocalJni.aesDecrypt(this.sqq, this.dKa);
        if (bk.bE(arrayOfByte)) {
          return "";
        }
        if (Build.VERSION.SDK_INT < 9) {
          break label69;
        }
      }
      label69:
      for (this.bUr = new String(arrayOfByte, Charset.forName("UTF-8"));; this.bUr = new String(arrayOfByte)) {
        return this.bUr;
      }
    }
    
    public final int getCmdId()
    {
      return 1000000205;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.w
 * JD-Core Version:    0.7.0.1
 */