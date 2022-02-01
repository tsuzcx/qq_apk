package com.tencent.mm.protocal;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.b.a;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.protobuf.aiq;
import com.tencent.mm.protocal.protobuf.cva;
import com.tencent.mm.protocal.protobuf.cvb;
import com.tencent.mm.protocal.protobuf.cvc;
import com.tencent.mm.protocal.protobuf.dpr;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.fgr;
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

public final class j$f
  extends j.h
{
  public cvb RBo;
  public boolean RBp;
  
  public j$f()
  {
    AppMethodBeat.i(133094);
    this.RBo = new cvb();
    this.RBp = false;
    AppMethodBeat.o(133094);
  }
  
  public final int getFuncId()
  {
    if (f.RAO) {
      return 252;
    }
    return 701;
  }
  
  public final String getUri()
  {
    if (f.RAO) {
      return "/cgi-bin/micromsg-bin/secmanualauth";
    }
    return "/cgi-bin/micromsg-bin/manualauth";
  }
  
  public final byte[] toProtoBuf()
  {
    int j = -1;
    AppMethodBeat.i(133095);
    com.tencent.mm.kernel.b.ML("");
    int k = getSceneStatus();
    int i;
    Object localObject1;
    Object localObject2;
    if (k == 16)
    {
      i = 1;
      Log.d("MicroMsg.ManualReq", "summerstatus[%d] clientUpgrade[%d]", new Object[] { Integer.valueOf(k), Integer.valueOf(i) });
      if ((10002 == com.tencent.mm.platformtools.ac.mFM) && (com.tencent.mm.platformtools.ac.mFN > 0))
      {
        com.tencent.mm.platformtools.ac.mFN = 0;
        ac.aA("", "", 0);
      }
      setRsaInfo(ac.hph());
      localObject1 = this.RBo.TCL;
      ((cva)localObject1).setBaseRequest(l.a(this));
      ((cva)localObject1).Dtb = q.dR(true);
      ((cva)localObject1).RMH = com.tencent.mm.plugin.normsg.a.d.GxJ.aax(i);
      ((cva)localObject1).RMI = 0;
      ((cva)localObject1).RMJ = com.tencent.mm.kernel.b.aGR();
      ((cva)localObject1).mVB = Util.getSourceeMd5(MMApplicationContext.getContext());
      ((cva)localObject1).rVG = d.RAB;
      ((cva)localObject1).RMK = cl.hAM();
      ((cva)localObject1).vhq = LocaleUtil.getApplicationLanguage();
      ((cva)localObject1).vhp = Util.getTimeZoneOffset();
      ((cva)localObject1).RML = ChannelUtil.channelId;
      if ((10012 == com.tencent.mm.platformtools.ac.mFM) && (com.tencent.mm.platformtools.ac.mFN > 0)) {
        ((cva)localObject1).RML = com.tencent.mm.platformtools.ac.mFN;
      }
      ((cva)localObject1).jUc = d.RAw;
      ((cva)localObject1).jUb = d.RAx;
      ((cva)localObject1).TCG = d.RAy;
      ((cva)localObject1).StL = q.auI();
      ((cva)localObject1).RGL = MMApplicationContext.getApplicationId();
      h.aHH();
      localObject2 = (String)h.aHG().kcw.get(18);
      Log.d("MicroMsg.ManualReq", "summerauth ksid:%s authreq flag:%d", new Object[] { localObject2, Integer.valueOf(((cva)localObject1).RMG.ROU) });
      ((cva)localObject1).RMG.ROS.RRy = new eae().dc(Util.decodeHexString((String)localObject2));
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
        Log.d("MicroMsg.ManualReq", "[debug] ccd set on manual auth, len: %s", new Object[] { Integer.valueOf(i) });
        localObject3 = new fgr();
        if ((2 == ((cva)localObject1).TCJ) || (1 == ((cva)localObject1).TCJ) || (((cva)localObject1).TCJ == 0))
        {
          if (com.tencent.mm.plugin.normsg.a.d.GxJ.aTk("ie_login_id")) {
            com.tencent.mm.plugin.normsg.a.d.GxJ.aTj("ie_login_id");
          }
          ((fgr)localObject3).UGM = new eae().dc(com.tencent.mm.plugin.normsg.a.d.GxJ.aTl("ie_login_id"));
          if (((fgr)localObject3).UGM == null) {
            continue;
          }
          i = ((fgr)localObject3).UGM.Ufv;
          Log.d("MicroMsg.ManualReq", "[debug] wcstf set on manual auth, len: %s", new Object[] { Integer.valueOf(i) });
          ((fgr)localObject3).UGN = new eae().dc(com.tencent.mm.plugin.normsg.a.d.GxJ.aTo("ce_login_id"));
          if (((fgr)localObject3).UGN == null) {
            continue;
          }
          i = ((fgr)localObject3).UGN.Ufv;
          Log.d("MicroMsg.ManualReq", "[debug] wcste set on manual auth, len: %s", new Object[] { Integer.valueOf(i) });
          localObject4 = com.tencent.mm.plugin.normsg.a.d.GxJ.aTp("ce_login_id");
          if (localObject4 != null) {
            ((fgr)localObject3).UGT = new eae().dc(((String)localObject4).getBytes());
          }
        }
        ((fgr)localObject3).UGS = new eae().dc(com.tencent.mm.plugin.normsg.a.d.GxJ.fjq());
        if (((fgr)localObject3).UGS == null) {
          continue;
        }
        i = ((fgr)localObject3).UGS.Ufv;
        Log.d("MicroMsg.ManualReq", "[debug] devtok on manual auth, len: %s", new Object[] { Integer.valueOf(i) });
        ((fgr)localObject3).UGO = new eae().dc((byte[])localObject2);
        ((cva)localObject1).RMN = new eae().dc(((fgr)localObject3).toByteArray());
      }
      catch (Throwable localThrowable)
      {
        Object localObject3;
        Object localObject4;
        Object localObject5;
        Object localObject6;
        int m;
        Log.printErrStackTrace("MicroMsg.ManualReq", localThrowable, "cc throws exception.", new Object[0]);
        continue;
        ((cva)localObject1).RMP.Stl = 0;
        ((cva)localObject1).RMP.RMR = new eae().dc(new byte[0]);
        Log.e("MicroMsg.ManualReq", "get sign key failed");
        continue;
        i = localObject4.length;
        continue;
        j = localObject5.length;
        continue;
      }
      localObject2 = this.RBo.TCK;
      ((cvc)localObject2).RQU = new eae().dc(Util.getUuidRandom());
      localObject3 = new aiq();
      ((aiq)localObject3).Stl = 713;
      localObject4 = new PByteArray();
      localObject5 = new PByteArray();
      k = MMProtocalJni.generateECKey(((aiq)localObject3).Stl, (PByteArray)localObject4, (PByteArray)localObject5);
      localObject4 = ((PByteArray)localObject4).value;
      localObject5 = ((PByteArray)localObject5).value;
      cX((byte[])localObject5);
      ((cva)localObject1).RMP = new dpr();
      localObject6 = com.tencent.mm.network.b.bsU().bsV();
      if (TextUtils.isEmpty((CharSequence)localObject6)) {
        continue;
      }
      ((cva)localObject1).RMP.Stl = com.tencent.mm.network.b.bsU().mue.Stl;
      ((cva)localObject1).RMP.RMR = new eae().dc(((String)localObject6).getBytes(StandardCharsets.ISO_8859_1));
      Log.i("MicroMsg.ManualReq", "manualauth add public key , length " + ((String)localObject6).length());
      localObject6 = new b.a();
      ((b.a)localObject6).mug = com.tencent.mm.network.b.bsU().bsV();
      ((b.a)localObject6).muf = com.tencent.mm.network.b.bsU().muf;
      setCGiVerifyKey((b.a)localObject6);
      m = ((aiq)localObject3).Stl;
      if (localObject4 != null) {
        continue;
      }
      i = -1;
      if (localObject5 != null) {
        continue;
      }
      Log.d("MicroMsg.ManualReq", "summerecdh nid:%d ret:%d, pub len: %d, pri len:%d, pub:%s, pri:%s", new Object[] { Integer.valueOf(m), Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(j), Util.dumpHex((byte[])localObject4), Util.dumpHex((byte[])localObject5) });
      ((aiq)localObject3).RMR = new eae().dc((byte[])localObject4);
      ((cvc)localObject2).RMV = ((aiq)localObject3);
      Log.i("MicroMsg.ManualReq", "summerauth manual IMEI:%s SoftType:%s ClientSeqID:%s Signature:%s DeviceName:%s DeviceType:%s Language:%s TimeZone:%s chan[%d,%d,%d] DeviceBrand:%s DeviceModel:%s OSType:%s RealCountry:%s AndroidPackageName:%s", new Object[] { ((cva)localObject1).Dtb, ((cva)localObject1).RMH, ((cva)localObject1).RMJ, ((cva)localObject1).mVB, ((cva)localObject1).rVG, ((cva)localObject1).RMK, ((cva)localObject1).vhq, ((cva)localObject1).vhp, Integer.valueOf(((cva)localObject1).RML), Integer.valueOf(ChannelUtil.channelId), Integer.valueOf(ChannelUtil.historyChannelId), ((cva)localObject1).jUc, ((cva)localObject1).jUb, ((cva)localObject1).TCG, ((cva)localObject1).StL, ((cva)localObject1).RGL });
      try
      {
        localObject1 = this.RBo.toByteArray();
        AppMethodBeat.o(133095);
        return localObject1;
      }
      catch (IOException localIOException)
      {
        Log.e("MicroMsg.ManualReq", "summerauth toProtoBuf :%s", new Object[] { Util.stackTraceToString(localIOException) });
        AppMethodBeat.o(133095);
      }
      if (this.RBp)
      {
        i = 3;
        break;
      }
      h.aHH();
      i = h.aHG().kcw.asB(46);
      break;
      i = -1;
      continue;
      i = -1;
      continue;
      i = -1;
      continue;
      i = -1;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.j.f
 * JD-Core Version:    0.7.0.1
 */