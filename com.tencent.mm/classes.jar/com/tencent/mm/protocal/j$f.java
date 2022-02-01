package com.tencent.mm.protocal;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.b.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.protobuf.all;
import com.tencent.mm.protocal.protobuf.dmg;
import com.tencent.mm.protocal.protobuf.dmh;
import com.tencent.mm.protocal.protobuf.dmi;
import com.tencent.mm.protocal.protobuf.eil;
import com.tencent.mm.protocal.protobuf.gdd;
import com.tencent.mm.protocal.protobuf.gol;
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

public final class j$f
  extends j.h
{
  public dmh YxR;
  public boolean YxS;
  
  public j$f()
  {
    AppMethodBeat.i(133094);
    this.YxR = new dmh();
    this.YxS = false;
    AppMethodBeat.o(133094);
  }
  
  public final int getFuncId()
  {
    if (f.Yxs) {
      return 252;
    }
    return 701;
  }
  
  public final String getUri()
  {
    if (f.Yxs) {
      return "/cgi-bin/micromsg-bin/secmanualauth";
    }
    return "/cgi-bin/micromsg-bin/manualauth";
  }
  
  public final byte[] toProtoBuf()
  {
    int j = -1;
    AppMethodBeat.i(133095);
    com.tencent.mm.kernel.b.Fu("");
    int k = getSceneStatus();
    int i;
    Object localObject1;
    Object localObject2;
    if (k == 16)
    {
      i = 1;
      Log.d("MicroMsg.ManualReq", "summerstatus[%d] clientUpgrade[%d]", new Object[] { Integer.valueOf(k), Integer.valueOf(i) });
      if ((10002 == z.pCm) && (z.pCn > 0))
      {
        z.pCn = 0;
        ac.aM("", "", 0);
      }
      setRsaInfo(ac.iQc());
      localObject1 = this.YxR.aaSs;
      ((dmg)localObject1).setBaseRequest(l.a(this));
      ((dmg)localObject1).Jmq = q.eD(true);
      ((dmg)localObject1).YJV = com.tencent.mm.plugin.normsg.a.d.MtP.aeQ(i);
      ((dmg)localObject1).YJW = 0;
      ((dmg)localObject1).YJX = com.tencent.mm.kernel.b.aZR();
      ((dmg)localObject1).pSi = Util.getSourceeMd5(MMApplicationContext.getContext());
      ((dmg)localObject1).vgW = d.Yxf;
      ((dmg)localObject1).YJY = co.jcP();
      ((dmg)localObject1).yts = LocaleUtil.getApplicationLanguage();
      ((dmg)localObject1).ytr = Util.getTimeZoneOffset();
      ((dmg)localObject1).YJZ = ChannelUtil.channelId;
      if ((10012 == z.pCm) && (z.pCn > 0)) {
        ((dmg)localObject1).YJZ = z.pCn;
      }
      ((dmg)localObject1).muu = d.Yxa;
      ((dmg)localObject1).mut = d.Yxb;
      ((dmg)localObject1).aaSn = d.Yxc;
      ((dmg)localObject1).Ztv = q.aPc();
      ((dmg)localObject1).YDN = MMApplicationContext.getApplicationId();
      h.baF();
      localObject2 = (String)h.baE().mCE.get(18);
      Log.d("MicroMsg.ManualReq", "summerauth ksid:%s authreq flag:%d", new Object[] { localObject2, Integer.valueOf(((dmg)localObject1).YJU.YMi) });
      ((dmg)localObject1).YJU.YMg.YOQ = new gol().df(Util.decodeHexString((String)localObject2));
    }
    for (;;)
    {
      try
      {
        localObject2 = com.tencent.mm.plugin.normsg.a.d.MtP.gtE();
        if (localObject2 == null) {
          continue;
        }
        i = localObject2.length;
        Log.d("MicroMsg.ManualReq", "[debug] ccd set on manual auth, len: %s", new Object[] { Integer.valueOf(i) });
        localObject3 = new gdd();
        if ((2 == ((dmg)localObject1).aaSq) || (1 == ((dmg)localObject1).aaSq) || (((dmg)localObject1).aaSq == 0))
        {
          if (com.tencent.mm.plugin.normsg.a.d.MtP.aQk("ie_login_id")) {
            com.tencent.mm.plugin.normsg.a.d.MtP.aQj("ie_login_id");
          }
          ((gdd)localObject3).acaV = new gol().df(com.tencent.mm.plugin.normsg.a.d.MtP.aQl("ie_login_id"));
          if (((gdd)localObject3).acaV == null) {
            continue;
          }
          i = ((gdd)localObject3).acaV.abwJ;
          Log.d("MicroMsg.ManualReq", "[debug] wcstf set on manual auth, len: %s", new Object[] { Integer.valueOf(i) });
          ((gdd)localObject3).acaW = new gol().df(com.tencent.mm.plugin.normsg.a.d.MtP.aQo("ce_login_id"));
          if (((gdd)localObject3).acaW == null) {
            continue;
          }
          i = ((gdd)localObject3).acaW.abwJ;
          Log.d("MicroMsg.ManualReq", "[debug] wcste set on manual auth, len: %s", new Object[] { Integer.valueOf(i) });
          localObject4 = com.tencent.mm.plugin.normsg.a.d.MtP.aQp("ce_login_id");
          if (localObject4 != null) {
            ((gdd)localObject3).acbc = new gol().df(((String)localObject4).getBytes());
          }
        }
        ((gdd)localObject3).acbb = new gol().df(com.tencent.mm.plugin.normsg.a.d.MtP.gtH());
        if (((gdd)localObject3).acbb == null) {
          continue;
        }
        i = ((gdd)localObject3).acbb.abwJ;
        Log.d("MicroMsg.ManualReq", "[debug] devtok on manual auth, len: %s", new Object[] { Integer.valueOf(i) });
        ((gdd)localObject3).acaX = new gol().df((byte[])localObject2);
        ((dmg)localObject1).YKb = new gol().df(((gdd)localObject3).toByteArray());
      }
      finally
      {
        Object localObject3;
        Object localObject4;
        Object localObject5;
        Object localObject6;
        int m;
        Log.printErrStackTrace("MicroMsg.ManualReq", localThrowable, "cc throws exception.", new Object[0]);
        continue;
        ((dmg)localObject1).YKd.Zsz = 0;
        ((dmg)localObject1).YKd.YKf = new gol().df(new byte[0]);
        Log.e("MicroMsg.ManualReq", "get sign key failed");
        continue;
        i = localObject4.length;
        continue;
        j = localObject5.length;
        continue;
      }
      localObject2 = this.YxR.aaSr;
      ((dmi)localObject2).YOj = new gol().df(Util.getUuidRandom());
      localObject3 = new all();
      ((all)localObject3).Zsz = 713;
      localObject4 = new PByteArray();
      localObject5 = new PByteArray();
      k = MMProtocalJni.generateECKey(((all)localObject3).Zsz, (PByteArray)localObject4, (PByteArray)localObject5);
      localObject4 = ((PByteArray)localObject4).value;
      localObject5 = ((PByteArray)localObject5).value;
      da((byte[])localObject5);
      ((dmg)localObject1).YKd = new eil();
      localObject6 = com.tencent.mm.network.b.bQD().bQE();
      if (TextUtils.isEmpty((CharSequence)localObject6)) {
        continue;
      }
      ((dmg)localObject1).YKd.Zsz = com.tencent.mm.network.b.bQD().pny.Zsz;
      ((dmg)localObject1).YKd.YKf = new gol().df(((String)localObject6).getBytes(StandardCharsets.ISO_8859_1));
      Log.i("MicroMsg.ManualReq", "manualauth add public key , length " + ((String)localObject6).length());
      localObject6 = new b.a();
      ((b.a)localObject6).pnA = com.tencent.mm.network.b.bQD().bQE();
      ((b.a)localObject6).pnz = com.tencent.mm.network.b.bQD().pnz;
      setCGiVerifyKey((b.a)localObject6);
      m = ((all)localObject3).Zsz;
      if (localObject4 != null) {
        continue;
      }
      i = -1;
      if (localObject5 != null) {
        continue;
      }
      Log.d("MicroMsg.ManualReq", "summerecdh nid:%d ret:%d, pub len: %d, pri len:%d, pub:%s, pri:%s", new Object[] { Integer.valueOf(m), Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(j), Util.dumpHex((byte[])localObject4), Util.dumpHex((byte[])localObject5) });
      ((all)localObject3).YKf = new gol().df((byte[])localObject4);
      ((dmi)localObject2).YKj = ((all)localObject3);
      Log.i("MicroMsg.ManualReq", "summerauth manual IMEI:%s SoftType:%s ClientSeqID:%s Signature:%s DeviceName:%s DeviceType:%s Language:%s TimeZone:%s chan[%d,%d,%d] DeviceBrand:%s DeviceModel:%s OSType:%s RealCountry:%s AndroidPackageName:%s", new Object[] { ((dmg)localObject1).Jmq, ((dmg)localObject1).YJV, ((dmg)localObject1).YJX, ((dmg)localObject1).pSi, ((dmg)localObject1).vgW, ((dmg)localObject1).YJY, ((dmg)localObject1).yts, ((dmg)localObject1).ytr, Integer.valueOf(((dmg)localObject1).YJZ), Integer.valueOf(ChannelUtil.channelId), Integer.valueOf(ChannelUtil.historyChannelId), ((dmg)localObject1).muu, ((dmg)localObject1).mut, ((dmg)localObject1).aaSn, ((dmg)localObject1).Ztv, ((dmg)localObject1).YDN });
      try
      {
        localObject1 = this.YxR.toByteArray();
        AppMethodBeat.o(133095);
        return localObject1;
      }
      catch (IOException localIOException)
      {
        Log.e("MicroMsg.ManualReq", "summerauth toProtoBuf :%s", new Object[] { Util.stackTraceToString(localIOException) });
        AppMethodBeat.o(133095);
      }
      if (this.YxS)
      {
        i = 3;
        break;
      }
      h.baF();
      i = h.baE().mCE.ayQ(46);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.j.f
 * JD-Core Version:    0.7.0.1
 */