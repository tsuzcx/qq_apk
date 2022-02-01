package com.tencent.mm.protocal;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.b;
import com.tencent.mm.network.b.a;
import com.tencent.mm.plugin.normsg.a.d;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.aif;
import com.tencent.mm.protocal.protobuf.cto;
import com.tencent.mm.protocal.protobuf.ctp;
import com.tencent.mm.protocal.protobuf.dfx;
import com.tencent.mm.protocal.protobuf.ewf;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.charset.StandardCharsets;

public final class x
{
  public static final class a
    extends l.d
    implements l.b
  {
    public cto KAi;
    public byte[] Kzv;
    
    public a()
    {
      AppMethodBeat.i(133120);
      this.KAi = new cto();
      AppMethodBeat.o(133120);
    }
    
    public final int getCmdId()
    {
      return 0;
    }
    
    public final int getFuncId()
    {
      return 126;
    }
    
    public final byte[] toProtoBuf()
    {
      int k = -1;
      AppMethodBeat.i(133121);
      setRsaInfo(ac.gtR());
      this.KAi.KPW = new SKBuiltinBuffer_t().setBuffer(Util.getUuidRandom());
      this.KAi.setBaseRequest(l.a(this));
      this.KAi.Myz = ChannelUtil.historyChannelId;
      aif localaif = new aif();
      localaif.LrO = 713;
      Object localObject2 = new PByteArray();
      Object localObject1 = new PByteArray();
      int m = MMProtocalJni.generateECKey(localaif.LrO, (PByteArray)localObject2, (PByteArray)localObject1);
      byte[] arrayOfByte = ((PByteArray)localObject2).value;
      localObject2 = ((PByteArray)localObject1).value;
      int i;
      label148:
      int j;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        this.Kzv = ((byte[])localObject1);
        int n = localaif.LrO;
        if (arrayOfByte != null) {
          break label519;
        }
        i = -1;
        if (localObject2 != null) {
          break label526;
        }
        j = -1;
        label155:
        Log.d("MicroMsg.MMReg2.Req", "summerecdh nid:%d ret:%d, pub len: %d, pri len:%d, pub:%s, pri:%s", new Object[] { Integer.valueOf(n), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(j), Util.dumpHex(arrayOfByte), Util.dumpHex((byte[])localObject2) });
        localaif.KLU = new SKBuiltinBuffer_t().setBuffer(arrayOfByte);
        this.KAi.KLY = localaif;
      }
      for (;;)
      {
        try
        {
          localObject1 = d.AEF.exJ();
          if (localObject1 == null) {
            continue;
          }
          i = localObject1.length;
          Log.d("MicroMsg.MMReg2.Req", "[debug] ccd set on reg, len: %s", new Object[] { Integer.valueOf(i) });
          localObject2 = new ewf();
          ((ewf)localObject2).NtQ = new SKBuiltinBuffer_t().setBuffer((byte[])localObject1);
          ((ewf)localObject2).NtU = new SKBuiltinBuffer_t().setBuffer(d.AEF.exM());
          i = k;
          if (((ewf)localObject2).NtU != null) {
            i = ((ewf)localObject2).NtU.getILen();
          }
          Log.d("MicroMsg.MMReg2.Req", "[debug] devtok on reg, len: %s", new Object[] { Integer.valueOf(i) });
          this.KAi.KLQ = new SKBuiltinBuffer_t().setBuffer(((ewf)localObject2).toByteArray());
        }
        catch (Throwable localThrowable)
        {
          label519:
          label526:
          Log.printErrStackTrace("MicroMsg.MMReg2.Req", localThrowable, "cc throws exception.", new Object[0]);
          continue;
          this.KAi.KLS.LrO = 0;
          this.KAi.KLS.KLU = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
          Log.e("MicroMsg.MMReg2.Req", "get sign key failed");
          continue;
        }
        this.KAi.KLS = new dfx();
        localObject1 = b.bjq().bjr();
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          continue;
        }
        this.KAi.KLS.LrO = b.bjq().jDB.LrO;
        this.KAi.KLS.KLU = new SKBuiltinBuffer_t().setBuffer(((String)localObject1).getBytes(StandardCharsets.ISO_8859_1));
        localObject1 = new b.a();
        ((b.a)localObject1).jDD = b.bjq().bjr();
        ((b.a)localObject1).jDC = b.bjq().jDC;
        setCGiVerifyKey((b.a)localObject1);
        localObject1 = this.KAi.toByteArray();
        AppMethodBeat.o(133121);
        return localObject1;
        localObject1 = new byte[0];
        break;
        i = arrayOfByte.length;
        break label148;
        j = localObject2.length;
        break label155;
        i = -1;
      }
    }
  }
  
  public static final class b
    extends l.e
    implements l.c
  {
    public ctp KAj;
    public byte[] KzA;
    private byte[] KzB;
    public int hku;
    private byte[] jDp;
    private byte[] jDq;
    
    public b()
    {
      AppMethodBeat.i(133122);
      this.KAj = new ctp();
      this.hku = 0;
      AppMethodBeat.o(133122);
    }
    
    public final byte[] aiZ(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return new byte[0];
      case 1: 
        return this.KzB;
      case 2: 
        return this.jDp;
      }
      return this.jDq;
    }
    
    public final void b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
    {
      AppMethodBeat.i(133124);
      this.KzB = paramArrayOfByte1;
      this.jDp = paramArrayOfByte2;
      this.jDq = paramArrayOfByte3;
      Log.i("MicroMsg.MMReg2.Resp", "summerauths setSession [%s] [%s] [%s]", new Object[] { Util.secPrint(Util.dumpHex(this.KzB)), Util.secPrint(Util.dumpHex(this.jDp)), Util.secPrint(Util.dumpHex(this.jDq)) });
      AppMethodBeat.o(133124);
    }
    
    public final int fromProtoBuf(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(133123);
      this.hku = 0;
      this.KAj = ((ctp)new ctp().parseFrom(paramArrayOfByte));
      l.a(this, this.KAj.getBaseResponse());
      this.hku = 0;
      int i = this.KAj.getBaseResponse().Ret;
      AppMethodBeat.o(133123);
      return i;
    }
    
    public final int getCmdId()
    {
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.x
 * JD-Core Version:    0.7.0.1
 */