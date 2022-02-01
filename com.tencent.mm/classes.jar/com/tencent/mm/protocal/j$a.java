package com.tencent.mm.protocal;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.b.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.protobuf.all;
import com.tencent.mm.protocal.protobuf.eil;
import com.tencent.mm.protocal.protobuf.gdd;
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

public final class j$a
  extends j.h
{
  public il YxN;
  public String username;
  
  public j$a()
  {
    AppMethodBeat.i(133087);
    this.YxN = new il();
    AppMethodBeat.o(133087);
  }
  
  public final int getFuncId()
  {
    if (f.Yxs) {
      return 763;
    }
    return 702;
  }
  
  public final String getUri()
  {
    if (f.Yxs) {
      return "/cgi-bin/micromsg-bin/secautoauth";
    }
    return "/cgi-bin/micromsg-bin/autoauth";
  }
  
  public final byte[] toProtoBuf()
  {
    int j = -1;
    AppMethodBeat.i(133088);
    com.tencent.mm.kernel.b.Fu("");
    int k = getSceneStatus();
    int i;
    Object localObject1;
    Object localObject2;
    if (k == 12)
    {
      i = 1;
      Log.d("MicroMsg.AutoReq", "summerstatus[%d] clientUpgrade[%d]", new Object[] { Integer.valueOf(k), Integer.valueOf(i) });
      setRsaInfo(ac.iQc());
      if ((10002 == z.pCm) && (z.pCn > 0))
      {
        z.pCn = 0;
        ac.aM("", "", 0);
      }
      localObject1 = this.YxN.YKh;
      ((ij)localObject1).setBaseRequest(l.a(this));
      Log.i("MicroMsg.AutoReq", "summerauth autoauth toProtoBuf uin[%d]", new Object[] { Integer.valueOf(getUin()) });
      ((ij)localObject1).Jmq = q.eD(true);
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
      Log.d("MicroMsg.AutoReq", "summerecdh ksid:%s, flag:%d", new Object[] { localObject2, Integer.valueOf(((ij)localObject1).YJU.YMi) });
      ((ij)localObject1).YJU.YMg.YOQ = new gol().df(Util.decodeHexString((String)localObject2));
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
        Log.d("MicroMsg.AutoReq", "[tomys] ccd set on auto auth, len: %s", new Object[] { Integer.valueOf(i) });
        localObject3 = new gdd();
        ((gdd)localObject3).acaX = new gol().df((byte[])localObject2);
        ((gdd)localObject3).acbb = new gol().df(com.tencent.mm.plugin.normsg.a.d.MtP.gtH());
        if (((gdd)localObject3).acbb == null) {
          continue;
        }
        i = ((gdd)localObject3).acbb.abwJ;
        Log.d("MicroMsg.AutoReq", "[debug] devtok on auto auth, len: %s", new Object[] { Integer.valueOf(i) });
        ((ij)localObject1).YKb = new gol().df(((gdd)localObject3).toByteArray());
      }
      finally
      {
        Object localObject3;
        Object localObject5;
        Object localObject4;
        int m;
        Log.printErrStackTrace("MicroMsg.AutoReq", localThrowable, "cc throws exception.", new Object[0]);
        continue;
        ((ij)localObject1).YKd.Zsz = 0;
        ((ij)localObject1).YKd.YKf = new gol().df(new byte[0]);
        Log.e("MicroMsg.AutoReq", "get sign key failed");
        continue;
        i = localObject5.length;
        continue;
        j = localObject4.length;
        continue;
      }
      ((ij)localObject1).YKd = new eil();
      localObject2 = com.tencent.mm.network.b.bQD().bQE();
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        continue;
      }
      ((ij)localObject1).YKd.Zsz = com.tencent.mm.network.b.bQD().pny.Zsz;
      ((ij)localObject1).YKd.YKf = new gol().df(((String)localObject2).getBytes(StandardCharsets.ISO_8859_1));
      Log.i("MicroMsg.AutoReq", "autoauth add public key , length " + ((String)localObject2).length());
      localObject2 = new b.a();
      ((b.a)localObject2).pnA = com.tencent.mm.network.b.bQD().bQE();
      ((b.a)localObject2).pnz = com.tencent.mm.network.b.bQD().pnz;
      setCGiVerifyKey((b.a)localObject2);
      localObject2 = this.YxN.YKg;
      localObject3 = new all();
      ((all)localObject3).Zsz = 713;
      localObject5 = new PByteArray();
      localObject4 = new PByteArray();
      k = MMProtocalJni.generateECKey(((all)localObject3).Zsz, (PByteArray)localObject5, (PByteArray)localObject4);
      localObject5 = ((PByteArray)localObject5).value;
      localObject4 = ((PByteArray)localObject4).value;
      da((byte[])localObject4);
      m = ((all)localObject3).Zsz;
      if (localObject5 != null) {
        continue;
      }
      i = -1;
      if (localObject4 != null) {
        continue;
      }
      Log.d("MicroMsg.AutoReq", "summerecdh nid:%d ret:%d, pub len: %d, pri len:%d, pub:%s, pri:%s", new Object[] { Integer.valueOf(m), Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(j), Util.dumpHex((byte[])localObject5), Util.dumpHex((byte[])localObject4) });
      ((all)localObject3).YKf = new gol().df((byte[])localObject5);
      ((im)localObject2).YKj = ((all)localObject3);
      Log.i("MicroMsg.AutoReq", "summerauth auto IMEI:%s SoftType:%s ClientSeqID:%s Signature:%s DeviceName:%s DeviceType:%s Language:%s TimeZone:%s AndroidPackageName:%s chan[%d,%d,%d]", new Object[] { ((ij)localObject1).Jmq, ((ij)localObject1).YJV, ((ij)localObject1).YJX, ((ij)localObject1).pSi, ((ij)localObject1).vgW, ((ij)localObject1).YJY, ((ij)localObject1).yts, ((ij)localObject1).ytr, ((ij)localObject1).YDN, Integer.valueOf(((ij)localObject1).YJZ), Integer.valueOf(ChannelUtil.channelId), Integer.valueOf(ChannelUtil.historyChannelId) });
      try
      {
        localObject1 = this.YxN.toByteArray();
        AppMethodBeat.o(133088);
        return localObject1;
      }
      catch (IOException localIOException)
      {
        Log.e("MicroMsg.AutoReq", "summerauth toProtoBuf :%s", new Object[] { Util.stackTraceToString(localIOException) });
        AppMethodBeat.o(133088);
      }
      h.baF();
      i = h.baE().mCE.ayQ(46);
      break;
      i = -1;
      continue;
      i = -1;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.j.a
 * JD-Core Version:    0.7.0.1
 */