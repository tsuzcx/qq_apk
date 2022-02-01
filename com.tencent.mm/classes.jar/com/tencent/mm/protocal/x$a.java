package com.tencent.mm.protocal;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.b;
import com.tencent.mm.network.b.a;
import com.tencent.mm.plugin.normsg.a.d;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.protobuf.aiq;
import com.tencent.mm.protocal.protobuf.dcn;
import com.tencent.mm.protocal.protobuf.dpr;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.fgr;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.charset.StandardCharsets;

public final class x$a
  extends l.d
  implements l.b
{
  public dcn RBY;
  public byte[] RBl;
  
  public x$a()
  {
    AppMethodBeat.i(133120);
    this.RBY = new dcn();
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
    setRsaInfo(ac.hph());
    this.RBY.RQU = new eae().dc(Util.getUuidRandom());
    this.RBY.setBaseRequest(l.a(this));
    this.RBY.TKa = ChannelUtil.historyChannelId;
    aiq localaiq = new aiq();
    localaiq.Stl = 713;
    Object localObject2 = new PByteArray();
    Object localObject1 = new PByteArray();
    int m = MMProtocalJni.generateECKey(localaiq.Stl, (PByteArray)localObject2, (PByteArray)localObject1);
    byte[] arrayOfByte = ((PByteArray)localObject2).value;
    localObject2 = ((PByteArray)localObject1).value;
    int i;
    label148:
    int j;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      this.RBl = ((byte[])localObject1);
      int n = localaiq.Stl;
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
      localaiq.RMR = new eae().dc(arrayOfByte);
      this.RBY.RMV = localaiq;
    }
    for (;;)
    {
      try
      {
        localObject1 = d.GxJ.fjn();
        if (localObject1 == null) {
          continue;
        }
        i = localObject1.length;
        Log.d("MicroMsg.MMReg2.Req", "[debug] ccd set on reg, len: %s", new Object[] { Integer.valueOf(i) });
        localObject2 = new fgr();
        ((fgr)localObject2).UGO = new eae().dc((byte[])localObject1);
        ((fgr)localObject2).UGS = new eae().dc(d.GxJ.fjq());
        i = k;
        if (((fgr)localObject2).UGS != null) {
          i = ((fgr)localObject2).UGS.Ufv;
        }
        Log.d("MicroMsg.MMReg2.Req", "[debug] devtok on reg, len: %s", new Object[] { Integer.valueOf(i) });
        this.RBY.RMN = new eae().dc(((fgr)localObject2).toByteArray());
      }
      catch (Throwable localThrowable)
      {
        label519:
        label526:
        Log.printErrStackTrace("MicroMsg.MMReg2.Req", localThrowable, "cc throws exception.", new Object[0]);
        continue;
        this.RBY.RMP.Stl = 0;
        this.RBY.RMP.RMR = new eae().dc(new byte[0]);
        Log.e("MicroMsg.MMReg2.Req", "get sign key failed");
        continue;
      }
      this.RBY.RMP = new dpr();
      localObject1 = b.bsU().bsV();
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        continue;
      }
      this.RBY.RMP.Stl = b.bsU().mue.Stl;
      this.RBY.RMP.RMR = new eae().dc(((String)localObject1).getBytes(StandardCharsets.ISO_8859_1));
      localObject1 = new b.a();
      ((b.a)localObject1).mug = b.bsU().bsV();
      ((b.a)localObject1).muf = b.bsU().muf;
      setCGiVerifyKey((b.a)localObject1);
      localObject1 = this.RBY.toByteArray();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.x.a
 * JD-Core Version:    0.7.0.1
 */