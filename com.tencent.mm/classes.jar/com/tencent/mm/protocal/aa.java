package com.tencent.mm.protocal;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Locale;

public final class aa
{
  public static final class a
    extends l.d
    implements l.b
  {
    public int KAr;
    public int KzG;
    public byte[] ctx;
    public byte[] hqn;
    public byte[] jcK;
    public int netType;
    public byte[] networkId;
    private int uin;
    
    public a()
    {
      AppMethodBeat.i(133125);
      this.jcK = new byte[0];
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
      if (this.jcK == null) {}
      for (int i = -1;; i = this.jcK.length)
      {
        Log.d("MicroMsg.MMSyncCheck", "toProtoBuf dksynccheck uin:%d keybuf:%d, stack[%s]", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Util.getStack() });
        if ((this.uin != 0) && (!Util.isNullOrNil(this.jcK))) {
          break;
        }
        AppMethodBeat.o(133126);
        return new byte[0];
      }
      j = (this.uin >> 13 & 0x7FFFF | this.jcK.length << 19) ^ 0x5601F281;
      int k = (this.jcK.length >> 13 & 0x7FFFF | this.uin << 19) ^ 0x5601F281;
      byte[] arrayOfByte = new byte[this.jcK.length + 32];
      if ((this.networkId != null) && (this.networkId.length == 32))
      {
        i = this.KAr + 36;
        arrayOfByte = new byte[this.jcK.length + 32 + 32 + 4 + this.KAr];
      }
      for (;;)
      {
        Log.d("MicroMsg.MMSyncCheck", "dksynccheck uin=[%d/%d], keyBufLen=[%d/%d] outBuf=[%d]", new Object[] { Integer.valueOf(this.uin), Integer.valueOf(j), Integer.valueOf(this.jcK.length), Integer.valueOf(k), Integer.valueOf(arrayOfByte.length) });
        arrayOfByte[0] = ((byte)(j >> 24 & 0xFF));
        arrayOfByte[1] = ((byte)(j >> 16 & 0xFF));
        arrayOfByte[2] = ((byte)(j >> 8 & 0xFF));
        arrayOfByte[3] = ((byte)(j & 0xFF));
        arrayOfByte[4] = ((byte)(k >> 24 & 0xFF));
        arrayOfByte[5] = ((byte)(k >> 16 & 0xFF));
        arrayOfByte[6] = ((byte)(k >> 8 & 0xFF));
        arrayOfByte[7] = ((byte)(k & 0xFF));
        System.arraycopy(this.jcK, 0, arrayOfByte, 8, this.jcK.length);
        arrayOfByte[(arrayOfByte.length - 24 - i)] = ((byte)(d.KyO >> 24 & 0xFF));
        arrayOfByte[(arrayOfByte.length - 23 - i)] = ((byte)(d.KyO >> 16 & 0xFF));
        arrayOfByte[(arrayOfByte.length - 22 - i)] = ((byte)(d.KyO >> 8 & 0xFF));
        arrayOfByte[(arrayOfByte.length - 21 - i)] = ((byte)(d.KyO & 0xFF));
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
        arrayOfByte[(arrayOfByte.length - 4 - i)] = ((byte)(this.KzG >> 24 & 0xFF));
        arrayOfByte[(arrayOfByte.length - 3 - i)] = ((byte)(this.KzG >> 16 & 0xFF));
        arrayOfByte[(arrayOfByte.length - 2 - i)] = ((byte)(this.KzG >> 8 & 0xFF));
        arrayOfByte[(arrayOfByte.length - 1 - i)] = ((byte)(this.KzG & 0xFF));
        if ((this.networkId != null) && (this.networkId.length == 32))
        {
          Log.i("MicroMsg.MMSyncCheck", "copy networkid " + this.networkId.length + " " + this.KAr);
          System.arraycopy(this.networkId, 0, arrayOfByte, this.jcK.length + 32, this.networkId.length);
          arrayOfByte[(arrayOfByte.length - this.KAr - 4)] = ((byte)(this.KAr >> 24 & 0xFF));
          arrayOfByte[(arrayOfByte.length - this.KAr - 3)] = ((byte)(this.KAr >> 16 & 0xFF));
          arrayOfByte[(arrayOfByte.length - this.KAr - 2)] = ((byte)(this.KAr >> 8 & 0xFF));
          arrayOfByte[(arrayOfByte.length - this.KAr - 1)] = ((byte)(this.KAr & 0xFF));
          if ((this.KAr > 0) && (this.ctx != null) && (this.ctx.length == this.KAr)) {
            System.arraycopy(this.ctx, 0, arrayOfByte, this.jcK.length + 32 + this.networkId.length + 4, this.ctx.length);
          }
        }
        Log.d("MicroMsg.MMSyncCheck", "outbuf:%x" + Arrays.toString(arrayOfByte) + " " + arrayOfByte.length);
        this.hqn = g.Q(arrayOfByte);
        AppMethodBeat.o(133126);
        return arrayOfByte;
        i = 0;
      }
    }
  }
  
  public static final class b
    extends l.e
    implements l.c
  {
    public long KAs = 7L;
    private byte[] KAt;
    public int KAu = 0;
    public byte[] ctx;
    public byte[] hqn = null;
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
      this.KAs = (paramArrayOfByte[3] & 0xFF | (paramArrayOfByte[2] & 0xFF) << 8 | (paramArrayOfByte[1] & 0xFF) << 16 | (paramArrayOfByte[0] & 0xFF) << 24);
      int i = paramArrayOfByte[7] & 0xFF | (paramArrayOfByte[6] & 0xFF) << 8 | (paramArrayOfByte[5] & 0xFF) << 16 | (paramArrayOfByte[4] & 0xFF) << 24;
      int j = paramArrayOfByte[11] & 0xFF | (paramArrayOfByte[10] & 0xFF) << 8 | (paramArrayOfByte[9] & 0xFF) << 16 | (paramArrayOfByte[8] & 0xFF) << 24;
      Log.d("MicroMsg.MMSyncCheck", " fromProtoBuf oreh synccheck resp selector:%d, redCode:%d, keyLen:%d, buf length:%d", new Object[] { Long.valueOf(this.KAs), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramArrayOfByte.length) });
      if (i != -3002)
      {
        this.xml = "";
        if (paramArrayOfByte.length > j + 12)
        {
          this.KAu = (paramArrayOfByte[(j + 15)] & 0xFF | (paramArrayOfByte[(j + 14)] & 0xFF) << 8 | (paramArrayOfByte[(j + 13)] & 0xFF) << 16 | (paramArrayOfByte[(j + 12)] & 0xFF) << 24);
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
        this.hqn = new byte[16];
        System.arraycopy(paramArrayOfByte, paramArrayOfByte.length - 16, this.hqn, 0, 16);
      }
      this.KAt = new byte[j];
      System.arraycopy(paramArrayOfByte, 12, this.KAt, 0, j);
      AppMethodBeat.o(133128);
      return i;
    }
    
    public final int getCmdId()
    {
      return 1000000205;
    }
    
    @TargetApi(9)
    public final String gtP()
    {
      AppMethodBeat.i(133127);
      if (this.hqn == null)
      {
        AppMethodBeat.o(133127);
        return "";
      }
      Object localObject;
      if (this.xml == null)
      {
        localObject = MMProtocalJni.aesDecrypt(this.KAt, this.hqn);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.aa
 * JD-Core Version:    0.7.0.1
 */