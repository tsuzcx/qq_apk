package com.tencent.mm.protocal;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.b;
import com.tencent.mm.network.b.a;
import com.tencent.mm.plugin.normsg.a.d;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.protobuf.all;
import com.tencent.mm.protocal.protobuf.duf;
import com.tencent.mm.protocal.protobuf.eil;
import com.tencent.mm.protocal.protobuf.gdd;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.charset.StandardCharsets;

public final class x$a
  extends l.d
  implements l.b
{
  public byte[] YxO;
  public duf YyB;
  
  public x$a()
  {
    AppMethodBeat.i(133120);
    this.YyB = new duf();
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
    setRsaInfo(ac.iQc());
    this.YyB.YOj = new gol().df(Util.getUuidRandom());
    this.YyB.setBaseRequest(l.a(this));
    this.YyB.aaZP = ChannelUtil.historyChannelId;
    all localall = new all();
    localall.Zsz = 713;
    Object localObject2 = new PByteArray();
    Object localObject1 = new PByteArray();
    int m = MMProtocalJni.generateECKey(localall.Zsz, (PByteArray)localObject2, (PByteArray)localObject1);
    byte[] arrayOfByte = ((PByteArray)localObject2).value;
    localObject2 = ((PByteArray)localObject1).value;
    int i;
    label148:
    int j;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      this.YxO = ((byte[])localObject1);
      int n = localall.Zsz;
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
      localall.YKf = new gol().df(arrayOfByte);
      this.YyB.YKj = localall;
    }
    for (;;)
    {
      try
      {
        localObject1 = d.MtP.gtE();
        if (localObject1 == null) {
          continue;
        }
        i = localObject1.length;
        Log.d("MicroMsg.MMReg2.Req", "[debug] ccd set on reg, len: %s", new Object[] { Integer.valueOf(i) });
        localObject2 = new gdd();
        ((gdd)localObject2).acaX = new gol().df((byte[])localObject1);
        ((gdd)localObject2).acbb = new gol().df(d.MtP.gtH());
        i = k;
        if (((gdd)localObject2).acbb != null) {
          i = ((gdd)localObject2).acbb.abwJ;
        }
        Log.d("MicroMsg.MMReg2.Req", "[debug] devtok on reg, len: %s", new Object[] { Integer.valueOf(i) });
        this.YyB.YKb = new gol().df(((gdd)localObject2).toByteArray());
      }
      finally
      {
        label519:
        label526:
        Log.printErrStackTrace("MicroMsg.MMReg2.Req", localThrowable, "cc throws exception.", new Object[0]);
        continue;
        this.YyB.YKd.Zsz = 0;
        this.YyB.YKd.YKf = new gol().df(new byte[0]);
        Log.e("MicroMsg.MMReg2.Req", "get sign key failed");
        continue;
      }
      this.YyB.YKd = new eil();
      localObject1 = b.bQD().bQE();
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        continue;
      }
      this.YyB.YKd.Zsz = b.bQD().pny.Zsz;
      this.YyB.YKd.YKf = new gol().df(((String)localObject1).getBytes(StandardCharsets.ISO_8859_1));
      localObject1 = new b.a();
      ((b.a)localObject1).pnA = b.bQD().bQE();
      ((b.a)localObject1).pnz = b.bQD().pnz;
      setCGiVerifyKey((b.a)localObject1);
      localObject1 = this.YyB.toByteArray();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.x.a
 * JD-Core Version:    0.7.0.1
 */