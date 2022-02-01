package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.normsg.a.b;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.acp;
import com.tencent.mm.protocal.protobuf.boo;
import com.tencent.mm.protocal.protobuf.bop;
import com.tencent.mm.protocal.protobuf.boq;
import com.tencent.mm.protocal.protobuf.dfm;
import com.tencent.mm.protocal.protobuf.dow;
import com.tencent.mm.protocal.protobuf.gm;
import com.tencent.mm.protocal.protobuf.gz;
import com.tencent.mm.protocal.protobuf.hb;
import com.tencent.mm.protocal.protobuf.hc;
import com.tencent.mm.protocal.protobuf.ik;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.storage.aa;
import java.io.IOException;

public final class j
{
  public static final class a
    extends j.h
    implements l.b
  {
    public hb Cqm;
    public String username;
    
    public a()
    {
      AppMethodBeat.i(133087);
      this.Cqm = new hb();
      AppMethodBeat.o(133087);
    }
    
    public final int getFuncId()
    {
      if (f.CpT) {
        return 763;
      }
      return 702;
    }
    
    public final String getUri()
    {
      if (f.CpT) {
        return "/cgi-bin/micromsg-bin/secautoauth";
      }
      return "/cgi-bin/micromsg-bin/autoauth";
    }
    
    public final byte[] toProtoBuf()
    {
      int j = -1;
      AppMethodBeat.i(133088);
      a.qL("");
      int k = getSceneStatus();
      int i;
      Object localObject1;
      Object localObject2;
      if (k == 12)
      {
        i = 1;
        ad.d("MicroMsg.AutoReq", "summerstatus[%d] clientUpgrade[%d]", new Object[] { Integer.valueOf(k), Integer.valueOf(i) });
        setRsaInfo(ac.eBY());
        if ((10002 == ab.hVC) && (ab.hVD > 0))
        {
          ab.hVD = 0;
          ac.af("", "", 0);
        }
        localObject1 = this.Cqm.CBY;
        ((gz)localObject1).setBaseRequest(l.a(this));
        ad.i("MicroMsg.AutoReq", "summerauth autoauth toProtoBuf uin[%d]", new Object[] { Integer.valueOf(getUin()) });
        ((gz)localObject1).sul = com.tencent.mm.compatible.deviceinfo.q.cG(true);
        ((gz)localObject1).CBO = b.ufs.Ix(i);
        ((gz)localObject1).CBP = 0;
        ((gz)localObject1).CBQ = a.aeM();
        ((gz)localObject1).ijP = com.tencent.mm.sdk.platformtools.bt.iO(aj.getContext());
        ((gz)localObject1).mAU = d.DEVICE_NAME;
        ((gz)localObject1).CBS = com.tencent.mm.storage.bt.eMY();
        ((gz)localObject1).oXs = com.tencent.mm.sdk.platformtools.ac.eFu();
        ((gz)localObject1).oXr = com.tencent.mm.sdk.platformtools.bt.eGH();
        ((gz)localObject1).Ctl = i.cJR;
        g.afC();
        localObject2 = (String)g.afB().gcR.get(18);
        ad.d("MicroMsg.AutoReq", "summerecdh ksid:%s, flag:%d", new Object[] { localObject2, Integer.valueOf(((gz)localObject1).CBN.CEa) });
        ((gz)localObject1).CBN.CDY.CGx = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.sdk.platformtools.bt.aGd((String)localObject2));
      }
      for (;;)
      {
        try
        {
          localObject2 = b.ufs.cWU();
          if (localObject2 == null) {
            continue;
          }
          i = localObject2.length;
          ad.d("MicroMsg.AutoReq", "[tomys] ccd set on auto auth, len: %s", new Object[] { Integer.valueOf(i) });
          localObject3 = new dow();
          ((dow)localObject3).EFc = new SKBuiltinBuffer_t().setBuffer((byte[])localObject2);
          ((dow)localObject3).EFg = new SKBuiltinBuffer_t().setBuffer(b.ufs.cWX());
          if (((dow)localObject3).EFg == null) {
            continue;
          }
          i = ((dow)localObject3).EFg.getILen();
          ad.d("MicroMsg.AutoReq", "[debug] devtok on auto auth, len: %s", new Object[] { Integer.valueOf(i) });
          ((gz)localObject1).CBU = new SKBuiltinBuffer_t().setBuffer(((dow)localObject3).toByteArray());
        }
        catch (Throwable localThrowable)
        {
          Object localObject3;
          Object localObject5;
          Object localObject4;
          int m;
          ad.printErrStackTrace("MicroMsg.AutoReq", localThrowable, "cc throws exception.", new Object[0]);
          continue;
          i = localObject5.length;
          continue;
          j = localObject4.length;
          continue;
        }
        localObject2 = this.Cqm.CBX;
        localObject3 = new acp();
        ((acp)localObject3).DcY = 713;
        localObject5 = new PByteArray();
        localObject4 = new PByteArray();
        k = MMProtocalJni.generateECKey(((acp)localObject3).DcY, (PByteArray)localObject5, (PByteArray)localObject4);
        localObject5 = ((PByteArray)localObject5).value;
        localObject4 = ((PByteArray)localObject4).value;
        cg((byte[])localObject4);
        m = ((acp)localObject3).DcY;
        if (localObject5 != null) {
          continue;
        }
        i = -1;
        if (localObject4 != null) {
          continue;
        }
        ad.d("MicroMsg.AutoReq", "summerecdh nid:%d ret:%d, pub len: %d, pri len:%d, pub:%s, pri:%s", new Object[] { Integer.valueOf(m), Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(j), com.tencent.mm.sdk.platformtools.bt.cv((byte[])localObject5), com.tencent.mm.sdk.platformtools.bt.cv((byte[])localObject4) });
        ((acp)localObject3).CBW = new SKBuiltinBuffer_t().setBuffer((byte[])localObject5);
        ((hc)localObject2).CCa = ((acp)localObject3);
        ad.i("MicroMsg.AutoReq", "summerauth auto IMEI:%s SoftType:%s ClientSeqID:%s Signature:%s DeviceName:%s DeviceType:%s Language:%s TimeZone:%s chan[%d,%d,%d]", new Object[] { ((gz)localObject1).sul, ((gz)localObject1).CBO, ((gz)localObject1).CBQ, ((gz)localObject1).ijP, ((gz)localObject1).mAU, ((gz)localObject1).CBS, ((gz)localObject1).oXs, ((gz)localObject1).oXr, Integer.valueOf(((gz)localObject1).Ctl), Integer.valueOf(i.cJR), Integer.valueOf(i.ETt) });
        try
        {
          localObject1 = this.Cqm.toByteArray();
          AppMethodBeat.o(133088);
          return localObject1;
        }
        catch (IOException localIOException)
        {
          ad.e("MicroMsg.AutoReq", "summerauth toProtoBuf :%s", new Object[] { com.tencent.mm.sdk.platformtools.bt.m(localIOException) });
          AppMethodBeat.o(133088);
        }
        g.afC();
        i = g.afB().gcR.Wv(46);
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
        this.Cqo = ((dfm)this.Cqo.parseFrom(paramArrayOfByte));
        l.a(this, this.Cqo.getBaseResponse());
        this.fWJ = 0;
        if ((this.Cqo.getBaseResponse().Ret == 0) && ((this.Cqo.EwP == null) || (this.Cqo.EwP.oXh == 0) || (com.tencent.mm.sdk.platformtools.bt.cw(z.a(this.Cqo.EwP.CBb)))))
        {
          ad.e("MicroMsg.MMAuth", "retcode 0 but invalid auth sect resp or invalid uin or invalid session");
          this.Cqo.getBaseResponse().Ret = -1;
        }
        paramArrayOfByte = getErrMsg();
        ad.i("MicroMsg.MMAuth", "summerauthkick auto errmsg[%s]", new Object[] { paramArrayOfByte });
        a.qL(paramArrayOfByte);
        int i = this.Cqo.getBaseResponse().Ret;
        AppMethodBeat.o(133089);
        return i;
      }
      catch (IOException paramArrayOfByte)
      {
        ad.e("MicroMsg.MMAuth", "toProtoBuf :%s", new Object[] { com.tencent.mm.sdk.platformtools.bt.m(paramArrayOfByte) });
        this.Cqo.getBaseResponse().Ret = -1;
        AppMethodBeat.o(133089);
      }
      return -1;
    }
  }
  
  public static final class c
    extends l.d
    implements l.b
  {
    public hb Cqm;
    private byte[] Cqn;
    public String username;
    
    public c()
    {
      AppMethodBeat.i(133090);
      this.Cqm = new hb();
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
      a.qL("");
      int k = getSceneStatus();
      int i;
      Object localObject1;
      Object localObject2;
      acp localacp;
      Object localObject4;
      Object localObject3;
      int m;
      if (k == 12)
      {
        i = 1;
        ad.d("MicroMsg.MMAuth", "summerstatus[%d] clientUpgrade[%d]", new Object[] { Integer.valueOf(k), Integer.valueOf(i) });
        setRsaInfo(ac.eBY());
        if ((10002 == ab.hVC) && (ab.hVD > 0))
        {
          ab.hVD = 0;
          ac.af("", "", 0);
        }
        localObject1 = this.Cqm.CBY;
        ((gz)localObject1).setBaseRequest(l.a(this));
        ad.i("MicroMsg.MMAuth", "summerauth autoauth toProtoBuf uin[%d]", new Object[] { Integer.valueOf(getUin()) });
        ((gz)localObject1).sul = com.tencent.mm.compatible.deviceinfo.q.WT();
        ((gz)localObject1).CBO = b.ufs.Ix(i);
        ((gz)localObject1).CBP = 0;
        ((gz)localObject1).CBQ = a.aeM();
        ((gz)localObject1).ijP = com.tencent.mm.sdk.platformtools.bt.iO(aj.getContext());
        ((gz)localObject1).mAU = d.DEVICE_NAME;
        ((gz)localObject1).CBS = com.tencent.mm.storage.bt.eMY();
        ((gz)localObject1).oXs = com.tencent.mm.sdk.platformtools.ac.eFu();
        ((gz)localObject1).oXr = com.tencent.mm.sdk.platformtools.bt.eGH();
        ((gz)localObject1).Ctl = i.cJR;
        g.afC();
        localObject2 = (String)g.afB().gcR.get(18);
        ad.d("MicroMsg.MMAuth", "summerecdh ksid:%s, flag:%d", new Object[] { localObject2, Integer.valueOf(((gz)localObject1).CBN.CEa) });
        ((gz)localObject1).CBN.CDY.CGx = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.sdk.platformtools.bt.aGd((String)localObject2));
        localObject2 = this.Cqm.CBX;
        localacp = new acp();
        localacp.DcY = 713;
        localObject4 = new PByteArray();
        localObject3 = new PByteArray();
        k = MMProtocalJni.generateECKey(localacp.DcY, (PByteArray)localObject4, (PByteArray)localObject3);
        localObject4 = ((PByteArray)localObject4).value;
        localObject3 = ((PByteArray)localObject3).value;
        this.Cqn = ((byte[])localObject3);
        m = localacp.DcY;
        if (localObject4 != null) {
          break label624;
        }
        i = -1;
        label390:
        if (localObject3 != null) {
          break label631;
        }
      }
      for (;;)
      {
        ad.d("MicroMsg.MMAuth", "summerecdh nid:%d ret:%d, pub len: %d, pri len:%d, pub:%s, pri:%s", new Object[] { Integer.valueOf(m), Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(j), com.tencent.mm.sdk.platformtools.bt.cv((byte[])localObject4), com.tencent.mm.sdk.platformtools.bt.cv((byte[])localObject3) });
        localacp.CBW = new SKBuiltinBuffer_t().setBuffer((byte[])localObject4);
        ((hc)localObject2).CCa = localacp;
        ad.i("MicroMsg.MMAuth", "summerauth auto IMEI:%s SoftType:%s ClientSeqID:%s Signature:%s DeviceName:%s DeviceType:%s Language:%s TimeZone:%s chan[%d,%d,%d]", new Object[] { ((gz)localObject1).sul, ((gz)localObject1).CBO, ((gz)localObject1).CBQ, ((gz)localObject1).ijP, ((gz)localObject1).mAU, ((gz)localObject1).CBS, ((gz)localObject1).oXs, ((gz)localObject1).oXr, Integer.valueOf(((gz)localObject1).Ctl), Integer.valueOf(i.cJR), Integer.valueOf(i.ETt) });
        try
        {
          localObject1 = this.Cqm.toByteArray();
          AppMethodBeat.o(133091);
          return localObject1;
        }
        catch (IOException localIOException)
        {
          ad.e("MicroMsg.MMAuth", "summerauth toProtoBuf :%s", new Object[] { com.tencent.mm.sdk.platformtools.bt.m(localIOException) });
          AppMethodBeat.o(133091);
        }
        g.afC();
        i = g.afB().gcR.Wv(46);
        break;
        label624:
        i = localObject4.length;
        break label390;
        label631:
        j = localObject3.length;
      }
      return null;
    }
  }
  
  public static abstract interface e
  {
    public abstract void a(j.h paramh, j.i parami, int paramInt1, int paramInt2, String paramString);
    
    public abstract int arZ();
    
    public abstract com.tencent.mm.network.q da(int paramInt1, int paramInt2);
    
    public static final class a
    {
      public static j.e Cqp;
    }
  }
  
  public static final class f
    extends j.h
    implements l.b
  {
    public bop Cqq;
    public boolean Cqr;
    
    public f()
    {
      AppMethodBeat.i(133094);
      this.Cqq = new bop();
      this.Cqr = false;
      AppMethodBeat.o(133094);
    }
    
    public final int getFuncId()
    {
      if (f.CpT) {
        return 252;
      }
      return 701;
    }
    
    public final String getUri()
    {
      if (f.CpT) {
        return "/cgi-bin/micromsg-bin/secmanualauth";
      }
      return "/cgi-bin/micromsg-bin/manualauth";
    }
    
    public final byte[] toProtoBuf()
    {
      int j = -1;
      AppMethodBeat.i(133095);
      a.qL("");
      int k = getSceneStatus();
      int i;
      Object localObject1;
      Object localObject2;
      if (k == 16)
      {
        i = 1;
        ad.d("MicroMsg.ManualReq", "summerstatus[%d] clientUpgrade[%d]", new Object[] { Integer.valueOf(k), Integer.valueOf(i) });
        if ((10002 == ab.hVC) && (ab.hVD > 0))
        {
          ab.hVD = 0;
          ac.af("", "", 0);
        }
        setRsaInfo(ac.eBY());
        localObject1 = this.Cqq.DLY;
        ((boo)localObject1).setBaseRequest(l.a(this));
        ((boo)localObject1).sul = com.tencent.mm.compatible.deviceinfo.q.cG(true);
        ((boo)localObject1).CBO = b.ufs.Ix(i);
        ((boo)localObject1).CBP = 0;
        ((boo)localObject1).CBQ = a.aeM();
        ((boo)localObject1).ijP = com.tencent.mm.sdk.platformtools.bt.iO(aj.getContext());
        ((boo)localObject1).mAU = d.DEVICE_NAME;
        ((boo)localObject1).CBS = com.tencent.mm.storage.bt.eMY();
        ((boo)localObject1).oXs = com.tencent.mm.sdk.platformtools.ac.eFu();
        ((boo)localObject1).oXr = com.tencent.mm.sdk.platformtools.bt.eGH();
        ((boo)localObject1).Ctl = i.cJR;
        if ((10012 == ab.hVC) && (ab.hVD > 0)) {
          ((boo)localObject1).Ctl = ab.hVD;
        }
        ((boo)localObject1).fVw = d.CpE;
        ((boo)localObject1).fVv = d.CpF;
        ((boo)localObject1).DLT = d.CpG;
        ((boo)localObject1).Ddm = com.tencent.mm.compatible.deviceinfo.q.getSimCountryIso();
        g.afC();
        localObject2 = (String)g.afB().gcR.get(18);
        ad.d("MicroMsg.ManualReq", "summerauth ksid:%s authreq flag:%d", new Object[] { localObject2, Integer.valueOf(((boo)localObject1).CBN.CEa) });
        ((boo)localObject1).CBN.CDY.CGx = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.sdk.platformtools.bt.aGd((String)localObject2));
      }
      for (;;)
      {
        try
        {
          localObject2 = b.ufs.cWU();
          if (localObject2 == null) {
            continue;
          }
          i = localObject2.length;
          ad.d("MicroMsg.ManualReq", "[debug] ccd set on manual auth, len: %s", new Object[] { Integer.valueOf(i) });
          localObject3 = new dow();
          if ((2 == ((boo)localObject1).DLW) || (1 == ((boo)localObject1).DLW))
          {
            if (b.ufs.aju("ie_login_id")) {
              b.ufs.ajt("ie_login_id");
            }
            ((dow)localObject3).EFa = new SKBuiltinBuffer_t().setBuffer(b.ufs.ajv("ie_login_id"));
            if (((dow)localObject3).EFa == null) {
              continue;
            }
            i = ((dow)localObject3).EFa.getILen();
            ad.d("MicroMsg.ManualReq", "[debug] wcstf set on manual auth, len: %s", new Object[] { Integer.valueOf(i) });
            ((dow)localObject3).EFb = new SKBuiltinBuffer_t().setBuffer(b.ufs.ajy("ce_login_id"));
            if (((dow)localObject3).EFb == null) {
              continue;
            }
            i = ((dow)localObject3).EFb.getILen();
            ad.d("MicroMsg.ManualReq", "[debug] wcste set on manual auth, len: %s", new Object[] { Integer.valueOf(i) });
          }
          ((dow)localObject3).EFg = new SKBuiltinBuffer_t().setBuffer(b.ufs.cWX());
          if (((dow)localObject3).EFg == null) {
            continue;
          }
          i = ((dow)localObject3).EFg.getILen();
          ad.d("MicroMsg.ManualReq", "[debug] devtok on manual auth, len: %s", new Object[] { Integer.valueOf(i) });
          ((dow)localObject3).EFc = new SKBuiltinBuffer_t().setBuffer((byte[])localObject2);
          ((boo)localObject1).CBU = new SKBuiltinBuffer_t().setBuffer(((dow)localObject3).toByteArray());
        }
        catch (Throwable localThrowable)
        {
          Object localObject3;
          Object localObject5;
          Object localObject4;
          int m;
          ad.printErrStackTrace("MicroMsg.ManualReq", localThrowable, "cc throws exception.", new Object[0]);
          continue;
          i = localObject5.length;
          continue;
          j = localObject4.length;
          continue;
        }
        localObject2 = this.Cqq.DLX;
        ((boq)localObject2).CFU = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.sdk.platformtools.bt.eGG());
        localObject3 = new acp();
        ((acp)localObject3).DcY = 713;
        localObject5 = new PByteArray();
        localObject4 = new PByteArray();
        k = MMProtocalJni.generateECKey(((acp)localObject3).DcY, (PByteArray)localObject5, (PByteArray)localObject4);
        localObject5 = ((PByteArray)localObject5).value;
        localObject4 = ((PByteArray)localObject4).value;
        cg((byte[])localObject4);
        m = ((acp)localObject3).DcY;
        if (localObject5 != null) {
          continue;
        }
        i = -1;
        if (localObject4 != null) {
          continue;
        }
        ad.d("MicroMsg.ManualReq", "summerecdh nid:%d ret:%d, pub len: %d, pri len:%d, pub:%s, pri:%s", new Object[] { Integer.valueOf(m), Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(j), com.tencent.mm.sdk.platformtools.bt.cv((byte[])localObject5), com.tencent.mm.sdk.platformtools.bt.cv((byte[])localObject4) });
        ((acp)localObject3).CBW = new SKBuiltinBuffer_t().setBuffer((byte[])localObject5);
        ((boq)localObject2).CCa = ((acp)localObject3);
        ad.i("MicroMsg.ManualReq", "summerauth manual IMEI:%s SoftType:%s ClientSeqID:%s Signature:%s DeviceName:%s DeviceType:%s Language:%s TimeZone:%s chan[%d,%d,%d] DeviceBrand:%s DeviceModel:%s OSType:%s RealCountry:%s", new Object[] { ((boo)localObject1).sul, ((boo)localObject1).CBO, ((boo)localObject1).CBQ, ((boo)localObject1).ijP, ((boo)localObject1).mAU, ((boo)localObject1).CBS, ((boo)localObject1).oXs, ((boo)localObject1).oXr, Integer.valueOf(((boo)localObject1).Ctl), Integer.valueOf(i.cJR), Integer.valueOf(i.ETt), ((boo)localObject1).fVw, ((boo)localObject1).fVv, ((boo)localObject1).DLT, ((boo)localObject1).Ddm });
        try
        {
          localObject1 = this.Cqq.toByteArray();
          AppMethodBeat.o(133095);
          return localObject1;
        }
        catch (IOException localIOException)
        {
          ad.e("MicroMsg.ManualReq", "summerauth toProtoBuf :%s", new Object[] { com.tencent.mm.sdk.platformtools.bt.m(localIOException) });
          AppMethodBeat.o(133095);
        }
        if (this.Cqr)
        {
          i = 3;
          break;
        }
        g.afC();
        i = g.afB().gcR.Wv(46);
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
        this.Cqo = ((dfm)this.Cqo.parseFrom(paramArrayOfByte));
        l.a(this, this.Cqo.getBaseResponse());
        this.fWJ = 0;
        if ((this.Cqo.getBaseResponse().Ret == 0) && ((this.Cqo.EwP == null) || (this.Cqo.EwP.oXh == 0) || (com.tencent.mm.sdk.platformtools.bt.cw(z.a(this.Cqo.EwP.CBb)))))
        {
          ad.e("MicroMsg.MMAuth", "retcode 0 but invalid auth sect resp or invalid uin or invalid session");
          this.Cqo.getBaseResponse().Ret = -1;
        }
        paramArrayOfByte = getErrMsg();
        ad.i("MicroMsg.MMAuth", "summerauthkick manual errmsg[%s]", new Object[] { paramArrayOfByte });
        a.qL(paramArrayOfByte);
        int i = this.Cqo.getBaseResponse().Ret;
        AppMethodBeat.o(133096);
        return i;
      }
      catch (IOException paramArrayOfByte)
      {
        ad.e("MicroMsg.MMAuth", "toProtoBuf :%s", new Object[] { com.tencent.mm.sdk.platformtools.bt.m(paramArrayOfByte) });
        this.Cqo.getBaseResponse().Ret = -1;
        AppMethodBeat.o(133096);
      }
      return -1;
    }
  }
  
  public static abstract class h
    extends l.d
    implements l.b
  {
    public byte[] Cqn;
    
    public final void cg(byte[] paramArrayOfByte)
    {
      if (paramArrayOfByte != null) {}
      for (;;)
      {
        this.Cqn = paramArrayOfByte;
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
    public dfm Cqo = new dfm();
    public byte[] Cqs;
    private byte[] Cqt;
    public int fWJ = 0;
    private byte[] hKA;
    public String hKD;
    private byte[] hKz;
    
    public final byte[] Vz(int paramInt)
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
        ad.i("MicroMsg.MMAuth", "summerauths getSession seesionKeyType[%s] [%s]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
        return arrayOfByte;
        arrayOfByte = this.Cqt;
        break;
        arrayOfByte = this.hKz;
        break;
        arrayOfByte = this.hKA;
        break;
      }
    }
    
    public final void b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
    {
      this.Cqt = paramArrayOfByte1;
      this.hKz = paramArrayOfByte2;
      this.hKA = paramArrayOfByte3;
      ad.i("MicroMsg.MMAuth", "summerauths setSession [%s] [%s], [%s]", new Object[] { com.tencent.mm.sdk.platformtools.bt.aGs(com.tencent.mm.sdk.platformtools.bt.cv(this.Cqt)), com.tencent.mm.sdk.platformtools.bt.aGs(com.tencent.mm.sdk.platformtools.bt.cv(this.hKz)), com.tencent.mm.sdk.platformtools.bt.aGs(com.tencent.mm.sdk.platformtools.bt.cv(this.hKA)) });
    }
    
    public byte[] getAuthResponse()
    {
      try
      {
        byte[] arrayOfByte = this.Cqo.toByteArray();
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