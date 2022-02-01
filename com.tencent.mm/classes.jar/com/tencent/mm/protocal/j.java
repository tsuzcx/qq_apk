package com.tencent.mm.protocal;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.b;
import com.tencent.mm.network.b.a;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.aif;
import com.tencent.mm.protocal.protobuf.cme;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.protocal.protobuf.cmg;
import com.tencent.mm.protocal.protobuf.dfx;
import com.tencent.mm.protocal.protobuf.ell;
import com.tencent.mm.protocal.protobuf.ewf;
import com.tencent.mm.protocal.protobuf.hk;
import com.tencent.mm.protocal.protobuf.hx;
import com.tencent.mm.protocal.protobuf.hz;
import com.tencent.mm.protocal.protobuf.ia;
import com.tencent.mm.protocal.protobuf.jk;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.ck;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public final class j
{
  public static final class a
    extends j.h
    implements l.b
  {
    public hz Kzu;
    public String username;
    
    public a()
    {
      AppMethodBeat.i(133087);
      this.Kzu = new hz();
      AppMethodBeat.o(133087);
    }
    
    public final int getFuncId()
    {
      if (f.KyZ) {
        return 763;
      }
      return 702;
    }
    
    public final String getUri()
    {
      if (f.KyZ) {
        return "/cgi-bin/micromsg-bin/secautoauth";
      }
      return "/cgi-bin/micromsg-bin/autoauth";
    }
    
    public final byte[] toProtoBuf()
    {
      int j = -1;
      AppMethodBeat.i(133088);
      a.FL("");
      int k = getSceneStatus();
      int i;
      Object localObject1;
      Object localObject2;
      if (k == 12)
      {
        i = 1;
        Log.d("MicroMsg.AutoReq", "summerstatus[%d] clientUpgrade[%d]", new Object[] { Integer.valueOf(k), Integer.valueOf(i) });
        setRsaInfo(ac.gtR());
        if ((10002 == com.tencent.mm.platformtools.ac.jOC) && (com.tencent.mm.platformtools.ac.jOD > 0))
        {
          com.tencent.mm.platformtools.ac.jOD = 0;
          ac.aq("", "", 0);
        }
        localObject1 = this.Kzu.KLW;
        ((hx)localObject1).setBaseRequest(l.a(this));
        Log.i("MicroMsg.AutoReq", "summerauth autoauth toProtoBuf uin[%d]", new Object[] { Integer.valueOf(getUin()) });
        ((hx)localObject1).yiZ = q.dr(true);
        ((hx)localObject1).KLL = com.tencent.mm.plugin.normsg.a.d.AEF.TK(i);
        ((hx)localObject1).KLM = 0;
        ((hx)localObject1).KLN = a.azt();
        ((hx)localObject1).keb = Util.getSourceeMd5(MMApplicationContext.getContext());
        ((hx)localObject1).oTI = d.DEVICE_NAME;
        ((hx)localObject1).KLO = ck.getFingerprint();
        ((hx)localObject1).rBI = LocaleUtil.getApplicationLanguage();
        ((hx)localObject1).rBH = Util.getTimeZoneOffset();
        ((hx)localObject1).KCx = ChannelUtil.channelId;
        ((hx)localObject1).KFu = MMApplicationContext.getApplicationId();
        g.aAi();
        localObject2 = (String)g.aAh().hqB.get(18);
        Log.d("MicroMsg.AutoReq", "summerecdh ksid:%s, flag:%d", new Object[] { localObject2, Integer.valueOf(((hx)localObject1).KLK.KOa) });
        ((hx)localObject1).KLK.KNY.KQA = new SKBuiltinBuffer_t().setBuffer(Util.decodeHexString((String)localObject2));
      }
      for (;;)
      {
        try
        {
          localObject2 = com.tencent.mm.plugin.normsg.a.d.AEF.exJ();
          if (localObject2 == null) {
            continue;
          }
          i = localObject2.length;
          Log.d("MicroMsg.AutoReq", "[tomys] ccd set on auto auth, len: %s", new Object[] { Integer.valueOf(i) });
          localObject3 = new ewf();
          ((ewf)localObject3).NtQ = new SKBuiltinBuffer_t().setBuffer((byte[])localObject2);
          ((ewf)localObject3).NtU = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.d.AEF.exM());
          if (((ewf)localObject3).NtU == null) {
            continue;
          }
          i = ((ewf)localObject3).NtU.getILen();
          Log.d("MicroMsg.AutoReq", "[debug] devtok on auto auth, len: %s", new Object[] { Integer.valueOf(i) });
          ((hx)localObject1).KLQ = new SKBuiltinBuffer_t().setBuffer(((ewf)localObject3).toByteArray());
        }
        catch (Throwable localThrowable)
        {
          Object localObject3;
          Object localObject5;
          Object localObject4;
          int m;
          Log.printErrStackTrace("MicroMsg.AutoReq", localThrowable, "cc throws exception.", new Object[0]);
          continue;
          ((hx)localObject1).KLS.LrO = 0;
          ((hx)localObject1).KLS.KLU = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
          Log.e("MicroMsg.AutoReq", "get sign key failed");
          continue;
          i = localObject5.length;
          continue;
          j = localObject4.length;
          continue;
        }
        ((hx)localObject1).KLS = new dfx();
        localObject2 = b.bjq().bjr();
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          continue;
        }
        ((hx)localObject1).KLS.LrO = b.bjq().jDB.LrO;
        ((hx)localObject1).KLS.KLU = new SKBuiltinBuffer_t().setBuffer(((String)localObject2).getBytes(StandardCharsets.ISO_8859_1));
        Log.i("MicroMsg.AutoReq", "autoauth add public key , length " + ((String)localObject2).length());
        localObject2 = new b.a();
        ((b.a)localObject2).jDD = b.bjq().bjr();
        ((b.a)localObject2).jDC = b.bjq().jDC;
        setCGiVerifyKey((b.a)localObject2);
        localObject2 = this.Kzu.KLV;
        localObject3 = new aif();
        ((aif)localObject3).LrO = 713;
        localObject5 = new PByteArray();
        localObject4 = new PByteArray();
        k = MMProtocalJni.generateECKey(((aif)localObject3).LrO, (PByteArray)localObject5, (PByteArray)localObject4);
        localObject5 = ((PByteArray)localObject5).value;
        localObject4 = ((PByteArray)localObject4).value;
        cG((byte[])localObject4);
        m = ((aif)localObject3).LrO;
        if (localObject5 != null) {
          continue;
        }
        i = -1;
        if (localObject4 != null) {
          continue;
        }
        Log.d("MicroMsg.AutoReq", "summerecdh nid:%d ret:%d, pub len: %d, pri len:%d, pub:%s, pri:%s", new Object[] { Integer.valueOf(m), Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(j), Util.dumpHex((byte[])localObject5), Util.dumpHex((byte[])localObject4) });
        ((aif)localObject3).KLU = new SKBuiltinBuffer_t().setBuffer((byte[])localObject5);
        ((ia)localObject2).KLY = ((aif)localObject3);
        Log.i("MicroMsg.AutoReq", "summerauth auto IMEI:%s SoftType:%s ClientSeqID:%s Signature:%s DeviceName:%s DeviceType:%s Language:%s TimeZone:%s AndroidPackageName:%s chan[%d,%d,%d]", new Object[] { ((hx)localObject1).yiZ, ((hx)localObject1).KLL, ((hx)localObject1).KLN, ((hx)localObject1).keb, ((hx)localObject1).oTI, ((hx)localObject1).KLO, ((hx)localObject1).rBI, ((hx)localObject1).rBH, ((hx)localObject1).KFu, Integer.valueOf(((hx)localObject1).KCx), Integer.valueOf(ChannelUtil.channelId), Integer.valueOf(ChannelUtil.historyChannelId) });
        try
        {
          localObject1 = this.Kzu.toByteArray();
          AppMethodBeat.o(133088);
          return localObject1;
        }
        catch (IOException localIOException)
        {
          Log.e("MicroMsg.AutoReq", "summerauth toProtoBuf :%s", new Object[] { Util.stackTraceToString(localIOException) });
          AppMethodBeat.o(133088);
        }
        g.aAi();
        i = g.aAh().hqB.ake(46);
        break;
        i = -1;
        continue;
        i = -1;
      }
      return null;
    }
  }
  
  public static final class b
    extends j.i
    implements l.c
  {
    public final int fromProtoBuf(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(133089);
      try
      {
        this.Kzw = ((ell)this.Kzw.parseFrom(paramArrayOfByte));
        l.a(this, this.Kzw.getBaseResponse());
        this.hku = 0;
        if ((this.Kzw.getBaseResponse().Ret == 0) && ((this.Kzw.Nky == null) || (this.Kzw.Nky.rBx == 0) || (Util.isNullOrNil(z.a(this.Kzw.Nky.KKY)))))
        {
          Log.e("MicroMsg.MMAuth", "retcode 0 but invalid auth sect resp or invalid uin or invalid session");
          this.Kzw.getBaseResponse().Ret = -1;
        }
        paramArrayOfByte = getErrMsg();
        Log.i("MicroMsg.MMAuth", "summerauthkick auto errmsg[%s]", new Object[] { paramArrayOfByte });
        a.FL(paramArrayOfByte);
        int i = this.Kzw.getBaseResponse().Ret;
        AppMethodBeat.o(133089);
        return i;
      }
      catch (IOException paramArrayOfByte)
      {
        Log.e("MicroMsg.MMAuth", "toProtoBuf :%s", new Object[] { Util.stackTraceToString(paramArrayOfByte) });
        this.Kzw.getBaseResponse().Ret = -1;
        AppMethodBeat.o(133089);
      }
      return -1;
    }
  }
  
  public static final class c
    extends l.d
    implements l.b
  {
    public hz Kzu;
    private byte[] Kzv;
    public String username;
    
    public c()
    {
      AppMethodBeat.i(133090);
      this.Kzu = new hz();
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
      a.FL("");
      int k = getSceneStatus();
      int i;
      Object localObject1;
      Object localObject2;
      label404:
      aif localaif;
      Object localObject4;
      Object localObject3;
      int m;
      if (k == 12)
      {
        i = 1;
        Log.d("MicroMsg.MMAuth", "summerstatus[%d] clientUpgrade[%d]", new Object[] { Integer.valueOf(k), Integer.valueOf(i) });
        setRsaInfo(ac.gtR());
        if ((10002 == com.tencent.mm.platformtools.ac.jOC) && (com.tencent.mm.platformtools.ac.jOD > 0))
        {
          com.tencent.mm.platformtools.ac.jOD = 0;
          ac.aq("", "", 0);
        }
        localObject1 = this.Kzu.KLW;
        ((hx)localObject1).setBaseRequest(l.a(this));
        Log.i("MicroMsg.MMAuth", "summerauth autoauth toProtoBuf uin[%d]", new Object[] { Integer.valueOf(getUin()) });
        ((hx)localObject1).yiZ = q.aoz();
        ((hx)localObject1).KLL = com.tencent.mm.plugin.normsg.a.d.AEF.TK(i);
        ((hx)localObject1).KLM = 0;
        ((hx)localObject1).KLN = a.azt();
        ((hx)localObject1).keb = Util.getSourceeMd5(MMApplicationContext.getContext());
        ((hx)localObject1).oTI = d.DEVICE_NAME;
        ((hx)localObject1).KLO = ck.getFingerprint();
        ((hx)localObject1).rBI = LocaleUtil.getApplicationLanguage();
        ((hx)localObject1).rBH = Util.getTimeZoneOffset();
        ((hx)localObject1).KCx = ChannelUtil.channelId;
        ((hx)localObject1).KFu = MMApplicationContext.getApplicationId();
        g.aAi();
        localObject2 = (String)g.aAh().hqB.get(18);
        Log.d("MicroMsg.MMAuth", "summerecdh ksid:%s, flag:%d", new Object[] { localObject2, Integer.valueOf(((hx)localObject1).KLK.KOa) });
        ((hx)localObject1).KLK.KNY.KQA = new SKBuiltinBuffer_t().setBuffer(Util.decodeHexString((String)localObject2));
        ((hx)localObject1).KLS = new dfx();
        localObject2 = b.bjq().bjr();
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break label775;
        }
        ((hx)localObject1).KLS.LrO = b.bjq().jDB.LrO;
        ((hx)localObject1).KLS.KLU = new SKBuiltinBuffer_t().setBuffer(((String)localObject2).getBytes(StandardCharsets.ISO_8859_1));
        Log.i("MicroMsg.MMAuth", "disaster auth add public key , length " + ((String)localObject2).length());
        localObject2 = new b.a();
        ((b.a)localObject2).jDD = b.bjq().bjr();
        ((b.a)localObject2).jDC = b.bjq().jDC;
        setCGiVerifyKey((b.a)localObject2);
        localObject2 = this.Kzu.KLV;
        localaif = new aif();
        localaif.LrO = 713;
        localObject4 = new PByteArray();
        localObject3 = new PByteArray();
        k = MMProtocalJni.generateECKey(localaif.LrO, (PByteArray)localObject4, (PByteArray)localObject3);
        localObject4 = ((PByteArray)localObject4).value;
        localObject3 = ((PByteArray)localObject3).value;
        this.Kzv = ((byte[])localObject3);
        m = localaif.LrO;
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
        localaif.KLU = new SKBuiltinBuffer_t().setBuffer((byte[])localObject4);
        ((ia)localObject2).KLY = localaif;
        Log.i("MicroMsg.MMAuth", "summerauth auto IMEI:%s SoftType:%s ClientSeqID:%s Signature:%s DeviceName:%s DeviceType:%s Language:%s TimeZone:%s AndroidPackageName:%s chan[%d,%d,%d]", new Object[] { ((hx)localObject1).yiZ, ((hx)localObject1).KLL, ((hx)localObject1).KLN, ((hx)localObject1).keb, ((hx)localObject1).oTI, ((hx)localObject1).KLO, ((hx)localObject1).rBI, ((hx)localObject1).rBH, ((hx)localObject1).KFu, Integer.valueOf(((hx)localObject1).KCx), Integer.valueOf(ChannelUtil.channelId), Integer.valueOf(ChannelUtil.historyChannelId) });
        try
        {
          localObject1 = this.Kzu.toByteArray();
          AppMethodBeat.o(133091);
          return localObject1;
        }
        catch (IOException localIOException)
        {
          Log.e("MicroMsg.MMAuth", "summerauth toProtoBuf :%s", new Object[] { Util.stackTraceToString(localIOException) });
          AppMethodBeat.o(133091);
        }
        g.aAi();
        i = g.aAh().hqB.ake(46);
        break;
        label775:
        ((hx)localObject1).KLS.LrO = 0;
        ((hx)localObject1).KLS.KLU = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
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
  
  public static abstract interface e
  {
    public abstract void a(j.h paramh, j.i parami, int paramInt1, int paramInt2, String paramString);
    
    public abstract int aVJ();
    
    public abstract s dm(int paramInt1, int paramInt2);
    
    public static final class a
    {
      public static j.e Kzx;
    }
  }
  
  public static final class f
    extends j.h
    implements l.b
  {
    public cmf Kzy;
    public boolean Kzz;
    
    public f()
    {
      AppMethodBeat.i(133094);
      this.Kzy = new cmf();
      this.Kzz = false;
      AppMethodBeat.o(133094);
    }
    
    public final int getFuncId()
    {
      if (f.KyZ) {
        return 252;
      }
      return 701;
    }
    
    public final String getUri()
    {
      if (f.KyZ) {
        return "/cgi-bin/micromsg-bin/secmanualauth";
      }
      return "/cgi-bin/micromsg-bin/manualauth";
    }
    
    public final byte[] toProtoBuf()
    {
      int j = -1;
      AppMethodBeat.i(133095);
      a.FL("");
      int k = getSceneStatus();
      int i;
      Object localObject1;
      Object localObject2;
      if (k == 16)
      {
        i = 1;
        Log.d("MicroMsg.ManualReq", "summerstatus[%d] clientUpgrade[%d]", new Object[] { Integer.valueOf(k), Integer.valueOf(i) });
        if ((10002 == com.tencent.mm.platformtools.ac.jOC) && (com.tencent.mm.platformtools.ac.jOD > 0))
        {
          com.tencent.mm.platformtools.ac.jOD = 0;
          ac.aq("", "", 0);
        }
        setRsaInfo(ac.gtR());
        localObject1 = this.Kzy.MrB;
        ((cme)localObject1).setBaseRequest(l.a(this));
        ((cme)localObject1).yiZ = q.dr(true);
        ((cme)localObject1).KLL = com.tencent.mm.plugin.normsg.a.d.AEF.TK(i);
        ((cme)localObject1).KLM = 0;
        ((cme)localObject1).KLN = a.azt();
        ((cme)localObject1).keb = Util.getSourceeMd5(MMApplicationContext.getContext());
        ((cme)localObject1).oTI = d.DEVICE_NAME;
        ((cme)localObject1).KLO = ck.getFingerprint();
        ((cme)localObject1).rBI = LocaleUtil.getApplicationLanguage();
        ((cme)localObject1).rBH = Util.getTimeZoneOffset();
        ((cme)localObject1).KCx = ChannelUtil.channelId;
        if ((10012 == com.tencent.mm.platformtools.ac.jOC) && (com.tencent.mm.platformtools.ac.jOD > 0)) {
          ((cme)localObject1).KCx = com.tencent.mm.platformtools.ac.jOD;
        }
        ((cme)localObject1).hie = d.KyI;
        ((cme)localObject1).hid = d.KyJ;
        ((cme)localObject1).Mrw = d.KyK;
        ((cme)localObject1).Lsj = q.getSimCountryIso();
        ((cme)localObject1).KFu = MMApplicationContext.getApplicationId();
        g.aAi();
        localObject2 = (String)g.aAh().hqB.get(18);
        Log.d("MicroMsg.ManualReq", "summerauth ksid:%s authreq flag:%d", new Object[] { localObject2, Integer.valueOf(((cme)localObject1).KLK.KOa) });
        ((cme)localObject1).KLK.KNY.KQA = new SKBuiltinBuffer_t().setBuffer(Util.decodeHexString((String)localObject2));
      }
      for (;;)
      {
        try
        {
          localObject2 = com.tencent.mm.plugin.normsg.a.d.AEF.exJ();
          if (localObject2 == null) {
            continue;
          }
          i = localObject2.length;
          Log.d("MicroMsg.ManualReq", "[debug] ccd set on manual auth, len: %s", new Object[] { Integer.valueOf(i) });
          localObject3 = new ewf();
          if ((2 == ((cme)localObject1).Mrz) || (1 == ((cme)localObject1).Mrz) || (((cme)localObject1).Mrz == 0))
          {
            if (com.tencent.mm.plugin.normsg.a.d.AEF.aIO("ie_login_id")) {
              com.tencent.mm.plugin.normsg.a.d.AEF.aIN("ie_login_id");
            }
            ((ewf)localObject3).NtO = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.d.AEF.aIP("ie_login_id"));
            if (((ewf)localObject3).NtO == null) {
              continue;
            }
            i = ((ewf)localObject3).NtO.getILen();
            Log.d("MicroMsg.ManualReq", "[debug] wcstf set on manual auth, len: %s", new Object[] { Integer.valueOf(i) });
            ((ewf)localObject3).NtP = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.d.AEF.aIS("ce_login_id"));
            if (((ewf)localObject3).NtP == null) {
              continue;
            }
            i = ((ewf)localObject3).NtP.getILen();
            Log.d("MicroMsg.ManualReq", "[debug] wcste set on manual auth, len: %s", new Object[] { Integer.valueOf(i) });
            localObject4 = com.tencent.mm.plugin.normsg.a.d.AEF.aIT("ce_login_id");
            if (localObject4 != null) {
              ((ewf)localObject3).NtV = new SKBuiltinBuffer_t().setBuffer(((String)localObject4).getBytes());
            }
          }
          ((ewf)localObject3).NtU = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.d.AEF.exM());
          if (((ewf)localObject3).NtU == null) {
            continue;
          }
          i = ((ewf)localObject3).NtU.getILen();
          Log.d("MicroMsg.ManualReq", "[debug] devtok on manual auth, len: %s", new Object[] { Integer.valueOf(i) });
          ((ewf)localObject3).NtQ = new SKBuiltinBuffer_t().setBuffer((byte[])localObject2);
          ((cme)localObject1).KLQ = new SKBuiltinBuffer_t().setBuffer(((ewf)localObject3).toByteArray());
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
          ((cme)localObject1).KLS.LrO = 0;
          ((cme)localObject1).KLS.KLU = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
          Log.e("MicroMsg.ManualReq", "get sign key failed");
          continue;
          i = localObject4.length;
          continue;
          j = localObject5.length;
          continue;
        }
        localObject2 = this.Kzy.MrA;
        ((cmg)localObject2).KPW = new SKBuiltinBuffer_t().setBuffer(Util.getUuidRandom());
        localObject3 = new aif();
        ((aif)localObject3).LrO = 713;
        localObject4 = new PByteArray();
        localObject5 = new PByteArray();
        k = MMProtocalJni.generateECKey(((aif)localObject3).LrO, (PByteArray)localObject4, (PByteArray)localObject5);
        localObject4 = ((PByteArray)localObject4).value;
        localObject5 = ((PByteArray)localObject5).value;
        cG((byte[])localObject5);
        ((cme)localObject1).KLS = new dfx();
        localObject6 = b.bjq().bjr();
        if (TextUtils.isEmpty((CharSequence)localObject6)) {
          continue;
        }
        ((cme)localObject1).KLS.LrO = b.bjq().jDB.LrO;
        ((cme)localObject1).KLS.KLU = new SKBuiltinBuffer_t().setBuffer(((String)localObject6).getBytes(StandardCharsets.ISO_8859_1));
        Log.i("MicroMsg.ManualReq", "manualauth add public key , length " + ((String)localObject6).length());
        localObject6 = new b.a();
        ((b.a)localObject6).jDD = b.bjq().bjr();
        ((b.a)localObject6).jDC = b.bjq().jDC;
        setCGiVerifyKey((b.a)localObject6);
        m = ((aif)localObject3).LrO;
        if (localObject4 != null) {
          continue;
        }
        i = -1;
        if (localObject5 != null) {
          continue;
        }
        Log.d("MicroMsg.ManualReq", "summerecdh nid:%d ret:%d, pub len: %d, pri len:%d, pub:%s, pri:%s", new Object[] { Integer.valueOf(m), Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(j), Util.dumpHex((byte[])localObject4), Util.dumpHex((byte[])localObject5) });
        ((aif)localObject3).KLU = new SKBuiltinBuffer_t().setBuffer((byte[])localObject4);
        ((cmg)localObject2).KLY = ((aif)localObject3);
        Log.i("MicroMsg.ManualReq", "summerauth manual IMEI:%s SoftType:%s ClientSeqID:%s Signature:%s DeviceName:%s DeviceType:%s Language:%s TimeZone:%s chan[%d,%d,%d] DeviceBrand:%s DeviceModel:%s OSType:%s RealCountry:%s AndroidPackageName:%s", new Object[] { ((cme)localObject1).yiZ, ((cme)localObject1).KLL, ((cme)localObject1).KLN, ((cme)localObject1).keb, ((cme)localObject1).oTI, ((cme)localObject1).KLO, ((cme)localObject1).rBI, ((cme)localObject1).rBH, Integer.valueOf(((cme)localObject1).KCx), Integer.valueOf(ChannelUtil.channelId), Integer.valueOf(ChannelUtil.historyChannelId), ((cme)localObject1).hie, ((cme)localObject1).hid, ((cme)localObject1).Mrw, ((cme)localObject1).Lsj, ((cme)localObject1).KFu });
        try
        {
          localObject1 = this.Kzy.toByteArray();
          AppMethodBeat.o(133095);
          return localObject1;
        }
        catch (IOException localIOException)
        {
          Log.e("MicroMsg.ManualReq", "summerauth toProtoBuf :%s", new Object[] { Util.stackTraceToString(localIOException) });
          AppMethodBeat.o(133095);
        }
        if (this.Kzz)
        {
          i = 3;
          break;
        }
        g.aAi();
        i = g.aAh().hqB.ake(46);
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
  
  public static final class g
    extends j.i
    implements l.c
  {
    public final int fromProtoBuf(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(133096);
      try
      {
        this.Kzw = ((ell)this.Kzw.parseFrom(paramArrayOfByte));
        l.a(this, this.Kzw.getBaseResponse());
        this.hku = 0;
        if ((this.Kzw.getBaseResponse().Ret == 0) && ((this.Kzw.Nky == null) || (this.Kzw.Nky.rBx == 0) || (Util.isNullOrNil(z.a(this.Kzw.Nky.KKY)))))
        {
          Log.e("MicroMsg.MMAuth", "retcode 0 but invalid auth sect resp or invalid uin or invalid session");
          this.Kzw.getBaseResponse().Ret = -1;
        }
        paramArrayOfByte = getErrMsg();
        Log.i("MicroMsg.MMAuth", "summerauthkick manual errmsg[%s]", new Object[] { paramArrayOfByte });
        a.FL(paramArrayOfByte);
        int i = this.Kzw.getBaseResponse().Ret;
        AppMethodBeat.o(133096);
        return i;
      }
      catch (IOException paramArrayOfByte)
      {
        Log.e("MicroMsg.MMAuth", "toProtoBuf :%s", new Object[] { Util.stackTraceToString(paramArrayOfByte) });
        this.Kzw.getBaseResponse().Ret = -1;
        AppMethodBeat.o(133096);
      }
      return -1;
    }
  }
  
  public static abstract class h
    extends l.d
    implements l.b
  {
    public byte[] Kzv;
    
    public final void cG(byte[] paramArrayOfByte)
    {
      if (paramArrayOfByte != null) {}
      for (;;)
      {
        this.Kzv = paramArrayOfByte;
        return;
        paramArrayOfByte = new byte[0];
      }
    }
    
    public abstract String getUri();
  }
  
  public static abstract class i
    extends l.e
    implements l.c
  {
    public byte[] KzA;
    private byte[] KzB;
    public ell Kzw = new ell();
    public String dMW;
    public int hku = 0;
    private byte[] jDp;
    private byte[] jDq;
    
    public final byte[] aiZ(int paramInt)
    {
      byte[] arrayOfByte = new byte[0];
      switch (paramInt)
      {
      default: 
        if (arrayOfByte != null) {
          break;
        }
      }
      for (int i = -1;; i = arrayOfByte.length)
      {
        Log.i("MicroMsg.MMAuth", "summerauths getSession seesionKeyType[%s] [%s]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
        return arrayOfByte;
        arrayOfByte = this.KzB;
        break;
        arrayOfByte = this.jDp;
        break;
        arrayOfByte = this.jDq;
        break;
      }
    }
    
    public final void b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
    {
      this.KzB = paramArrayOfByte1;
      this.jDp = paramArrayOfByte2;
      this.jDq = paramArrayOfByte3;
      Log.i("MicroMsg.MMAuth", "summerauths setSession [%s] [%s], [%s]", new Object[] { Util.secPrint(Util.dumpHex(this.KzB)), Util.secPrint(Util.dumpHex(this.jDp)), Util.secPrint(Util.dumpHex(this.jDq)) });
    }
    
    public byte[] getAuthResponse()
    {
      try
      {
        byte[] arrayOfByte = this.Kzw.toByteArray();
        return arrayOfByte;
      }
      catch (Exception localException) {}
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.j
 * JD-Core Version:    0.7.0.1
 */