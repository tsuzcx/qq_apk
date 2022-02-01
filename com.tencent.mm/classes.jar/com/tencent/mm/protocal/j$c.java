package com.tencent.mm.protocal;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.b.a;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.protobuf.aiq;
import com.tencent.mm.protocal.protobuf.dpr;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.hn;
import com.tencent.mm.protocal.protobuf.hp;
import com.tencent.mm.protocal.protobuf.hq;
import com.tencent.mm.protocal.protobuf.iz;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.cl;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public final class j$c
  extends l.d
  implements l.b
{
  public hp RBk;
  private byte[] RBl;
  public String username;
  
  public j$c()
  {
    AppMethodBeat.i(133090);
    this.RBk = new hp();
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
    com.tencent.mm.kernel.b.ML("");
    int k = getSceneStatus();
    int i;
    Object localObject1;
    Object localObject2;
    label404:
    aiq localaiq;
    Object localObject4;
    Object localObject3;
    int m;
    if (k == 12)
    {
      i = 1;
      Log.d("MicroMsg.MMAuth", "summerstatus[%d] clientUpgrade[%d]", new Object[] { Integer.valueOf(k), Integer.valueOf(i) });
      setRsaInfo(ac.hph());
      if ((10002 == com.tencent.mm.platformtools.ac.mFM) && (com.tencent.mm.platformtools.ac.mFN > 0))
      {
        com.tencent.mm.platformtools.ac.mFN = 0;
        ac.aA("", "", 0);
      }
      localObject1 = this.RBk.RMT;
      ((hn)localObject1).setBaseRequest(l.a(this));
      Log.i("MicroMsg.MMAuth", "summerauth autoauth toProtoBuf uin[%d]", new Object[] { Integer.valueOf(getUin()) });
      ((hn)localObject1).Dtb = q.auE();
      ((hn)localObject1).RMH = com.tencent.mm.plugin.normsg.a.d.GxJ.aax(i);
      ((hn)localObject1).RMI = 0;
      ((hn)localObject1).RMJ = com.tencent.mm.kernel.b.aGR();
      ((hn)localObject1).mVB = Util.getSourceeMd5(MMApplicationContext.getContext());
      ((hn)localObject1).rVG = d.RAB;
      ((hn)localObject1).RMK = cl.hAM();
      ((hn)localObject1).vhq = LocaleUtil.getApplicationLanguage();
      ((hn)localObject1).vhp = Util.getTimeZoneOffset();
      ((hn)localObject1).RML = ChannelUtil.channelId;
      ((hn)localObject1).RGL = MMApplicationContext.getApplicationId();
      h.aHH();
      localObject2 = (String)h.aHG().kcw.get(18);
      Log.d("MicroMsg.MMAuth", "summerecdh ksid:%s, flag:%d", new Object[] { localObject2, Integer.valueOf(((hn)localObject1).RMG.ROU) });
      ((hn)localObject1).RMG.ROS.RRy = new eae().dc(Util.decodeHexString((String)localObject2));
      ((hn)localObject1).RMP = new dpr();
      localObject2 = com.tencent.mm.network.b.bsU().bsV();
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        break label775;
      }
      ((hn)localObject1).RMP.Stl = com.tencent.mm.network.b.bsU().mue.Stl;
      ((hn)localObject1).RMP.RMR = new eae().dc(((String)localObject2).getBytes(StandardCharsets.ISO_8859_1));
      Log.i("MicroMsg.MMAuth", "disaster auth add public key , length " + ((String)localObject2).length());
      localObject2 = new b.a();
      ((b.a)localObject2).mug = com.tencent.mm.network.b.bsU().bsV();
      ((b.a)localObject2).muf = com.tencent.mm.network.b.bsU().muf;
      setCGiVerifyKey((b.a)localObject2);
      localObject2 = this.RBk.RMS;
      localaiq = new aiq();
      localaiq.Stl = 713;
      localObject4 = new PByteArray();
      localObject3 = new PByteArray();
      k = MMProtocalJni.generateECKey(localaiq.Stl, (PByteArray)localObject4, (PByteArray)localObject3);
      localObject4 = ((PByteArray)localObject4).value;
      localObject3 = ((PByteArray)localObject3).value;
      this.RBl = ((byte[])localObject3);
      m = localaiq.Stl;
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
      localaiq.RMR = new eae().dc((byte[])localObject4);
      ((hq)localObject2).RMV = localaiq;
      Log.i("MicroMsg.MMAuth", "summerauth auto IMEI:%s SoftType:%s ClientSeqID:%s Signature:%s DeviceName:%s DeviceType:%s Language:%s TimeZone:%s AndroidPackageName:%s chan[%d,%d,%d]", new Object[] { ((hn)localObject1).Dtb, ((hn)localObject1).RMH, ((hn)localObject1).RMJ, ((hn)localObject1).mVB, ((hn)localObject1).rVG, ((hn)localObject1).RMK, ((hn)localObject1).vhq, ((hn)localObject1).vhp, ((hn)localObject1).RGL, Integer.valueOf(((hn)localObject1).RML), Integer.valueOf(ChannelUtil.channelId), Integer.valueOf(ChannelUtil.historyChannelId) });
      try
      {
        localObject1 = this.RBk.toByteArray();
        AppMethodBeat.o(133091);
        return localObject1;
      }
      catch (IOException localIOException)
      {
        Log.e("MicroMsg.MMAuth", "summerauth toProtoBuf :%s", new Object[] { Util.stackTraceToString(localIOException) });
        AppMethodBeat.o(133091);
      }
      h.aHH();
      i = h.aHG().kcw.asB(46);
      break;
      label775:
      ((hn)localObject1).RMP.Stl = 0;
      ((hn)localObject1).RMP.RMR = new eae().dc(new byte[0]);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.j.c
 * JD-Core Version:    0.7.0.1
 */