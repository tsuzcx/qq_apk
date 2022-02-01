package com.tencent.mm.protocal;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.b.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.protobuf.all;
import com.tencent.mm.protocal.protobuf.eil;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.protocal.protobuf.ij;
import com.tencent.mm.protocal.protobuf.il;
import com.tencent.mm.protocal.protobuf.im;
import com.tencent.mm.protocal.protobuf.jv;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.co;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public final class j$c
  extends l.d
  implements l.b
{
  public il YxN;
  private byte[] YxO;
  public String username;
  
  public j$c()
  {
    AppMethodBeat.i(133090);
    this.YxN = new il();
    AppMethodBeat.o(133090);
  }
  
  public final int getFuncId()
  {
    return 3941;
  }
  
  public final byte[] toProtoBuf()
  {
    int j = -1;
    AppMethodBeat.i(133091);
    com.tencent.mm.kernel.b.Fu("");
    int k = getSceneStatus();
    int i;
    Object localObject1;
    Object localObject2;
    label404:
    all localall;
    Object localObject4;
    Object localObject3;
    int m;
    if (k == 12)
    {
      i = 1;
      Log.d("MicroMsg.MMAuth", "summerstatus[%d] clientUpgrade[%d]", new Object[] { Integer.valueOf(k), Integer.valueOf(i) });
      setRsaInfo(ac.iQc());
      if ((10002 == z.pCm) && (z.pCn > 0))
      {
        z.pCn = 0;
        ac.aM("", "", 0);
      }
      localObject1 = this.YxN.YKh;
      ((ij)localObject1).setBaseRequest(l.a(this));
      Log.i("MicroMsg.MMAuth", "summerauth autoauth toProtoBuf uin[%d]", new Object[] { Integer.valueOf(getUin()) });
      ((ij)localObject1).Jmq = q.aOY();
      ((ij)localObject1).YJV = com.tencent.mm.plugin.normsg.a.d.MtP.aeQ(i);
      ((ij)localObject1).YJW = 0;
      ((ij)localObject1).YJX = com.tencent.mm.kernel.b.aZR();
      ((ij)localObject1).pSi = Util.getSourceeMd5(MMApplicationContext.getContext());
      ((ij)localObject1).vgW = d.Yxf;
      ((ij)localObject1).YJY = co.jcP();
      ((ij)localObject1).yts = LocaleUtil.getApplicationLanguage();
      ((ij)localObject1).ytr = Util.getTimeZoneOffset();
      ((ij)localObject1).YJZ = ChannelUtil.channelId;
      ((ij)localObject1).YDN = MMApplicationContext.getApplicationId();
      h.baF();
      localObject2 = (String)h.baE().mCE.get(18);
      Log.d("MicroMsg.MMAuth", "summerecdh ksid:%s, flag:%d", new Object[] { localObject2, Integer.valueOf(((ij)localObject1).YJU.YMi) });
      ((ij)localObject1).YJU.YMg.YOQ = new gol().df(Util.decodeHexString((String)localObject2));
      ((ij)localObject1).YKd = new eil();
      localObject2 = com.tencent.mm.network.b.bQD().bQE();
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        break label775;
      }
      ((ij)localObject1).YKd.Zsz = com.tencent.mm.network.b.bQD().pny.Zsz;
      ((ij)localObject1).YKd.YKf = new gol().df(((String)localObject2).getBytes(StandardCharsets.ISO_8859_1));
      Log.i("MicroMsg.MMAuth", "disaster auth add public key , length " + ((String)localObject2).length());
      localObject2 = new b.a();
      ((b.a)localObject2).pnA = com.tencent.mm.network.b.bQD().bQE();
      ((b.a)localObject2).pnz = com.tencent.mm.network.b.bQD().pnz;
      setCGiVerifyKey((b.a)localObject2);
      localObject2 = this.YxN.YKg;
      localall = new all();
      localall.Zsz = 713;
      localObject4 = new PByteArray();
      localObject3 = new PByteArray();
      k = MMProtocalJni.generateECKey(localall.Zsz, (PByteArray)localObject4, (PByteArray)localObject3);
      localObject4 = ((PByteArray)localObject4).value;
      localObject3 = ((PByteArray)localObject3).value;
      this.YxO = ((byte[])localObject3);
      m = localall.Zsz;
      if (localObject4 != null) {
        break label816;
      }
      i = -1;
      label532:
      if (localObject3 != null) {
        break label823;
      }
    }
    for (;;)
    {
      Log.d("MicroMsg.MMAuth", "summerecdh nid:%d ret:%d, pub len: %d, pri len:%d, pub:%s, pri:%s", new Object[] { Integer.valueOf(m), Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(j), Util.dumpHex((byte[])localObject4), Util.dumpHex((byte[])localObject3) });
      localall.YKf = new gol().df((byte[])localObject4);
      ((im)localObject2).YKj = localall;
      Log.i("MicroMsg.MMAuth", "summerauth auto IMEI:%s SoftType:%s ClientSeqID:%s Signature:%s DeviceName:%s DeviceType:%s Language:%s TimeZone:%s AndroidPackageName:%s chan[%d,%d,%d]", new Object[] { ((ij)localObject1).Jmq, ((ij)localObject1).YJV, ((ij)localObject1).YJX, ((ij)localObject1).pSi, ((ij)localObject1).vgW, ((ij)localObject1).YJY, ((ij)localObject1).yts, ((ij)localObject1).ytr, ((ij)localObject1).YDN, Integer.valueOf(((ij)localObject1).YJZ), Integer.valueOf(ChannelUtil.channelId), Integer.valueOf(ChannelUtil.historyChannelId) });
      try
      {
        localObject1 = this.YxN.toByteArray();
        AppMethodBeat.o(133091);
        return localObject1;
      }
      catch (IOException localIOException)
      {
        Log.e("MicroMsg.MMAuth", "summerauth toProtoBuf :%s", new Object[] { Util.stackTraceToString(localIOException) });
        AppMethodBeat.o(133091);
      }
      h.baF();
      i = h.baE().mCE.ayQ(46);
      break;
      label775:
      ((ij)localObject1).YKd.Zsz = 0;
      ((ij)localObject1).YKd.YKf = new gol().df(new byte[0]);
      Log.e("MicroMsg.MMAuth", "get sign key failed");
      break label404;
      label816:
      i = localObject4.length;
      break label532;
      label823:
      j = localObject3.length;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.j.c
 * JD-Core Version:    0.7.0.1
 */