package com.tencent.mm.protocal;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.b.a;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.protobuf.aiq;
import com.tencent.mm.protocal.protobuf.dpr;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.fgr;
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

public final class j$a
  extends j.h
{
  public hp RBk;
  public String username;
  
  public j$a()
  {
    AppMethodBeat.i(133087);
    this.RBk = new hp();
    AppMethodBeat.o(133087);
  }
  
  public final int getFuncId()
  {
    if (f.RAO) {
      return 763;
    }
    return 702;
  }
  
  public final String getUri()
  {
    if (f.RAO) {
      return "/cgi-bin/micromsg-bin/secautoauth";
    }
    return "/cgi-bin/micromsg-bin/autoauth";
  }
  
  public final byte[] toProtoBuf()
  {
    int j = -1;
    AppMethodBeat.i(133088);
    com.tencent.mm.kernel.b.ML("");
    int k = getSceneStatus();
    int i;
    Object localObject1;
    Object localObject2;
    if (k == 12)
    {
      i = 1;
      Log.d("MicroMsg.AutoReq", "summerstatus[%d] clientUpgrade[%d]", new Object[] { Integer.valueOf(k), Integer.valueOf(i) });
      setRsaInfo(ac.hph());
      if ((10002 == com.tencent.mm.platformtools.ac.mFM) && (com.tencent.mm.platformtools.ac.mFN > 0))
      {
        com.tencent.mm.platformtools.ac.mFN = 0;
        ac.aA("", "", 0);
      }
      localObject1 = this.RBk.RMT;
      ((hn)localObject1).setBaseRequest(l.a(this));
      Log.i("MicroMsg.AutoReq", "summerauth autoauth toProtoBuf uin[%d]", new Object[] { Integer.valueOf(getUin()) });
      ((hn)localObject1).Dtb = q.dR(true);
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
      Log.d("MicroMsg.AutoReq", "summerecdh ksid:%s, flag:%d", new Object[] { localObject2, Integer.valueOf(((hn)localObject1).RMG.ROU) });
      ((hn)localObject1).RMG.ROS.RRy = new eae().dc(Util.decodeHexString((String)localObject2));
    }
    for (;;)
    {
      try
      {
        localObject2 = com.tencent.mm.plugin.normsg.a.d.GxJ.fjn();
        if (localObject2 == null) {
          continue;
        }
        i = localObject2.length;
        Log.d("MicroMsg.AutoReq", "[tomys] ccd set on auto auth, len: %s", new Object[] { Integer.valueOf(i) });
        localObject3 = new fgr();
        ((fgr)localObject3).UGO = new eae().dc((byte[])localObject2);
        ((fgr)localObject3).UGS = new eae().dc(com.tencent.mm.plugin.normsg.a.d.GxJ.fjq());
        if (((fgr)localObject3).UGS == null) {
          continue;
        }
        i = ((fgr)localObject3).UGS.Ufv;
        Log.d("MicroMsg.AutoReq", "[debug] devtok on auto auth, len: %s", new Object[] { Integer.valueOf(i) });
        ((hn)localObject1).RMN = new eae().dc(((fgr)localObject3).toByteArray());
      }
      catch (Throwable localThrowable)
      {
        Object localObject3;
        Object localObject5;
        Object localObject4;
        int m;
        Log.printErrStackTrace("MicroMsg.AutoReq", localThrowable, "cc throws exception.", new Object[0]);
        continue;
        ((hn)localObject1).RMP.Stl = 0;
        ((hn)localObject1).RMP.RMR = new eae().dc(new byte[0]);
        Log.e("MicroMsg.AutoReq", "get sign key failed");
        continue;
        i = localObject5.length;
        continue;
        j = localObject4.length;
        continue;
      }
      ((hn)localObject1).RMP = new dpr();
      localObject2 = com.tencent.mm.network.b.bsU().bsV();
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        continue;
      }
      ((hn)localObject1).RMP.Stl = com.tencent.mm.network.b.bsU().mue.Stl;
      ((hn)localObject1).RMP.RMR = new eae().dc(((String)localObject2).getBytes(StandardCharsets.ISO_8859_1));
      Log.i("MicroMsg.AutoReq", "autoauth add public key , length " + ((String)localObject2).length());
      localObject2 = new b.a();
      ((b.a)localObject2).mug = com.tencent.mm.network.b.bsU().bsV();
      ((b.a)localObject2).muf = com.tencent.mm.network.b.bsU().muf;
      setCGiVerifyKey((b.a)localObject2);
      localObject2 = this.RBk.RMS;
      localObject3 = new aiq();
      ((aiq)localObject3).Stl = 713;
      localObject5 = new PByteArray();
      localObject4 = new PByteArray();
      k = MMProtocalJni.generateECKey(((aiq)localObject3).Stl, (PByteArray)localObject5, (PByteArray)localObject4);
      localObject5 = ((PByteArray)localObject5).value;
      localObject4 = ((PByteArray)localObject4).value;
      cX((byte[])localObject4);
      m = ((aiq)localObject3).Stl;
      if (localObject5 != null) {
        continue;
      }
      i = -1;
      if (localObject4 != null) {
        continue;
      }
      Log.d("MicroMsg.AutoReq", "summerecdh nid:%d ret:%d, pub len: %d, pri len:%d, pub:%s, pri:%s", new Object[] { Integer.valueOf(m), Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(j), Util.dumpHex((byte[])localObject5), Util.dumpHex((byte[])localObject4) });
      ((aiq)localObject3).RMR = new eae().dc((byte[])localObject5);
      ((hq)localObject2).RMV = ((aiq)localObject3);
      Log.i("MicroMsg.AutoReq", "summerauth auto IMEI:%s SoftType:%s ClientSeqID:%s Signature:%s DeviceName:%s DeviceType:%s Language:%s TimeZone:%s AndroidPackageName:%s chan[%d,%d,%d]", new Object[] { ((hn)localObject1).Dtb, ((hn)localObject1).RMH, ((hn)localObject1).RMJ, ((hn)localObject1).mVB, ((hn)localObject1).rVG, ((hn)localObject1).RMK, ((hn)localObject1).vhq, ((hn)localObject1).vhp, ((hn)localObject1).RGL, Integer.valueOf(((hn)localObject1).RML), Integer.valueOf(ChannelUtil.channelId), Integer.valueOf(ChannelUtil.historyChannelId) });
      try
      {
        localObject1 = this.RBk.toByteArray();
        AppMethodBeat.o(133088);
        return localObject1;
      }
      catch (IOException localIOException)
      {
        Log.e("MicroMsg.AutoReq", "summerauth toProtoBuf :%s", new Object[] { Util.stackTraceToString(localIOException) });
        AppMethodBeat.o(133088);
      }
      h.aHH();
      i = h.aHG().kcw.asB(46);
      break;
      i = -1;
      continue;
      i = -1;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.j.a
 * JD-Core Version:    0.7.0.1
 */