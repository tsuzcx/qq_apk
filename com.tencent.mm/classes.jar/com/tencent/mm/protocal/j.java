package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.normsg.a.b;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.protocal.protobuf.bym;
import com.tencent.mm.protocal.protobuf.byn;
import com.tencent.mm.protocal.protobuf.byo;
import com.tencent.mm.protocal.protobuf.drp;
import com.tencent.mm.protocal.protobuf.eby;
import com.tencent.mm.protocal.protobuf.gx;
import com.tencent.mm.protocal.protobuf.hk;
import com.tencent.mm.protocal.protobuf.hm;
import com.tencent.mm.protocal.protobuf.hn;
import com.tencent.mm.protocal.protobuf.ix;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.cd;
import java.io.IOException;

public final class j
{
  public static final class a
    extends j.h
    implements l.b
  {
    public hm FGj;
    public String username;
    
    public a()
    {
      AppMethodBeat.i(133087);
      this.FGj = new hm();
      AppMethodBeat.o(133087);
    }
    
    public final int getFuncId()
    {
      if (f.FFQ) {
        return 763;
      }
      return 702;
    }
    
    public final String getUri()
    {
      if (f.FFQ) {
        return "/cgi-bin/micromsg-bin/secautoauth";
      }
      return "/cgi-bin/micromsg-bin/autoauth";
    }
    
    public final byte[] toProtoBuf()
    {
      int j = -1;
      AppMethodBeat.i(133088);
      a.xz("");
      int k = getSceneStatus();
      int i;
      Object localObject1;
      Object localObject2;
      if (k == 12)
      {
        i = 1;
        ae.d("MicroMsg.AutoReq", "summerstatus[%d] clientUpgrade[%d]", new Object[] { Integer.valueOf(k), Integer.valueOf(i) });
        setRsaInfo(ac.fkn());
        if ((10002 == com.tencent.mm.platformtools.ac.iRH) && (com.tencent.mm.platformtools.ac.iRI > 0))
        {
          com.tencent.mm.platformtools.ac.iRI = 0;
          ac.am("", "", 0);
        }
        localObject1 = this.FGj.FSn;
        ((hk)localObject1).setBaseRequest(l.a(this));
        ae.i("MicroMsg.AutoReq", "summerauth autoauth toProtoBuf uin[%d]", new Object[] { Integer.valueOf(getUin()) });
        ((hk)localObject1).uQx = com.tencent.mm.compatible.deviceinfo.q.cH(true);
        ((hk)localObject1).FSe = b.wJt.MD(i);
        ((hk)localObject1).FSf = 0;
        ((hk)localObject1).FSg = a.ajd();
        ((hk)localObject1).jfY = bu.jp(ak.getContext());
        ((hk)localObject1).nIN = d.DEVICE_NAME;
        ((hk)localObject1).FSh = cd.fwK();
        ((hk)localObject1).qkN = ad.fom();
        ((hk)localObject1).qkM = bu.fpH();
        ((hk)localObject1).FJf = k.cSM;
        g.ajS();
        localObject2 = (String)g.ajR().gDO.get(18);
        ae.d("MicroMsg.AutoReq", "summerecdh ksid:%s, flag:%d", new Object[] { localObject2, Integer.valueOf(((hk)localObject1).FSd.FUr) });
        ((hk)localObject1).FSd.FUp.FWO = new SKBuiltinBuffer_t().setBuffer(bu.aSx((String)localObject2));
      }
      for (;;)
      {
        try
        {
          localObject2 = b.wJt.dye();
          if (localObject2 == null) {
            continue;
          }
          i = localObject2.length;
          ae.d("MicroMsg.AutoReq", "[tomys] ccd set on auto auth, len: %s", new Object[] { Integer.valueOf(i) });
          localObject3 = new eby();
          ((eby)localObject3).Ihs = new SKBuiltinBuffer_t().setBuffer((byte[])localObject2);
          ((eby)localObject3).Ihw = new SKBuiltinBuffer_t().setBuffer(b.wJt.dyh());
          if (((eby)localObject3).Ihw == null) {
            continue;
          }
          i = ((eby)localObject3).Ihw.getILen();
          ae.d("MicroMsg.AutoReq", "[debug] devtok on auto auth, len: %s", new Object[] { Integer.valueOf(i) });
          ((hk)localObject1).FSj = new SKBuiltinBuffer_t().setBuffer(((eby)localObject3).toByteArray());
        }
        catch (Throwable localThrowable)
        {
          Object localObject3;
          Object localObject5;
          Object localObject4;
          int m;
          ae.printErrStackTrace("MicroMsg.AutoReq", localThrowable, "cc throws exception.", new Object[0]);
          continue;
          i = localObject5.length;
          continue;
          j = localObject4.length;
          continue;
        }
        localObject2 = this.FGj.FSm;
        localObject3 = new afy();
        ((afy)localObject3).Gwi = 713;
        localObject5 = new PByteArray();
        localObject4 = new PByteArray();
        k = MMProtocalJni.generateECKey(((afy)localObject3).Gwi, (PByteArray)localObject5, (PByteArray)localObject4);
        localObject5 = ((PByteArray)localObject5).value;
        localObject4 = ((PByteArray)localObject4).value;
        cp((byte[])localObject4);
        m = ((afy)localObject3).Gwi;
        if (localObject5 != null) {
          continue;
        }
        i = -1;
        if (localObject4 != null) {
          continue;
        }
        ae.d("MicroMsg.AutoReq", "summerecdh nid:%d ret:%d, pub len: %d, pri len:%d, pub:%s, pri:%s", new Object[] { Integer.valueOf(m), Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(j), bu.cE((byte[])localObject5), bu.cE((byte[])localObject4) });
        ((afy)localObject3).FSl = new SKBuiltinBuffer_t().setBuffer((byte[])localObject5);
        ((hn)localObject2).FSp = ((afy)localObject3);
        ae.i("MicroMsg.AutoReq", "summerauth auto IMEI:%s SoftType:%s ClientSeqID:%s Signature:%s DeviceName:%s DeviceType:%s Language:%s TimeZone:%s chan[%d,%d,%d]", new Object[] { ((hk)localObject1).uQx, ((hk)localObject1).FSe, ((hk)localObject1).FSg, ((hk)localObject1).jfY, ((hk)localObject1).nIN, ((hk)localObject1).FSh, ((hk)localObject1).qkN, ((hk)localObject1).qkM, Integer.valueOf(((hk)localObject1).FJf), Integer.valueOf(k.cSM), Integer.valueOf(k.IwF) });
        try
        {
          localObject1 = this.FGj.toByteArray();
          AppMethodBeat.o(133088);
          return localObject1;
        }
        catch (IOException localIOException)
        {
          ae.e("MicroMsg.AutoReq", "summerauth toProtoBuf :%s", new Object[] { bu.o(localIOException) });
          AppMethodBeat.o(133088);
        }
        g.ajS();
        i = g.ajR().gDO.abw(46);
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
        this.FGl = ((drp)this.FGl.parseFrom(paramArrayOfByte));
        l.a(this, this.FGl.getBaseResponse());
        this.gxH = 0;
        if ((this.FGl.getBaseResponse().Ret == 0) && ((this.FGl.HYs == null) || (this.FGl.HYs.qkC == 0) || (bu.cF(z.a(this.FGl.HYs.FRr)))))
        {
          ae.e("MicroMsg.MMAuth", "retcode 0 but invalid auth sect resp or invalid uin or invalid session");
          this.FGl.getBaseResponse().Ret = -1;
        }
        paramArrayOfByte = getErrMsg();
        ae.i("MicroMsg.MMAuth", "summerauthkick auto errmsg[%s]", new Object[] { paramArrayOfByte });
        a.xz(paramArrayOfByte);
        int i = this.FGl.getBaseResponse().Ret;
        AppMethodBeat.o(133089);
        return i;
      }
      catch (IOException paramArrayOfByte)
      {
        ae.e("MicroMsg.MMAuth", "toProtoBuf :%s", new Object[] { bu.o(paramArrayOfByte) });
        this.FGl.getBaseResponse().Ret = -1;
        AppMethodBeat.o(133089);
      }
      return -1;
    }
  }
  
  public static final class c
    extends l.d
    implements l.b
  {
    public hm FGj;
    private byte[] FGk;
    public String username;
    
    public c()
    {
      AppMethodBeat.i(133090);
      this.FGj = new hm();
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
      a.xz("");
      int k = getSceneStatus();
      int i;
      Object localObject1;
      Object localObject2;
      afy localafy;
      Object localObject4;
      Object localObject3;
      int m;
      if (k == 12)
      {
        i = 1;
        ae.d("MicroMsg.MMAuth", "summerstatus[%d] clientUpgrade[%d]", new Object[] { Integer.valueOf(k), Integer.valueOf(i) });
        setRsaInfo(ac.fkn());
        if ((10002 == com.tencent.mm.platformtools.ac.iRH) && (com.tencent.mm.platformtools.ac.iRI > 0))
        {
          com.tencent.mm.platformtools.ac.iRI = 0;
          ac.am("", "", 0);
        }
        localObject1 = this.FGj.FSn;
        ((hk)localObject1).setBaseRequest(l.a(this));
        ae.i("MicroMsg.MMAuth", "summerauth autoauth toProtoBuf uin[%d]", new Object[] { Integer.valueOf(getUin()) });
        ((hk)localObject1).uQx = com.tencent.mm.compatible.deviceinfo.q.aaA();
        ((hk)localObject1).FSe = b.wJt.MD(i);
        ((hk)localObject1).FSf = 0;
        ((hk)localObject1).FSg = a.ajd();
        ((hk)localObject1).jfY = bu.jp(ak.getContext());
        ((hk)localObject1).nIN = d.DEVICE_NAME;
        ((hk)localObject1).FSh = cd.fwK();
        ((hk)localObject1).qkN = ad.fom();
        ((hk)localObject1).qkM = bu.fpH();
        ((hk)localObject1).FJf = k.cSM;
        g.ajS();
        localObject2 = (String)g.ajR().gDO.get(18);
        ae.d("MicroMsg.MMAuth", "summerecdh ksid:%s, flag:%d", new Object[] { localObject2, Integer.valueOf(((hk)localObject1).FSd.FUr) });
        ((hk)localObject1).FSd.FUp.FWO = new SKBuiltinBuffer_t().setBuffer(bu.aSx((String)localObject2));
        localObject2 = this.FGj.FSm;
        localafy = new afy();
        localafy.Gwi = 713;
        localObject4 = new PByteArray();
        localObject3 = new PByteArray();
        k = MMProtocalJni.generateECKey(localafy.Gwi, (PByteArray)localObject4, (PByteArray)localObject3);
        localObject4 = ((PByteArray)localObject4).value;
        localObject3 = ((PByteArray)localObject3).value;
        this.FGk = ((byte[])localObject3);
        m = localafy.Gwi;
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
        ae.d("MicroMsg.MMAuth", "summerecdh nid:%d ret:%d, pub len: %d, pri len:%d, pub:%s, pri:%s", new Object[] { Integer.valueOf(m), Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(j), bu.cE((byte[])localObject4), bu.cE((byte[])localObject3) });
        localafy.FSl = new SKBuiltinBuffer_t().setBuffer((byte[])localObject4);
        ((hn)localObject2).FSp = localafy;
        ae.i("MicroMsg.MMAuth", "summerauth auto IMEI:%s SoftType:%s ClientSeqID:%s Signature:%s DeviceName:%s DeviceType:%s Language:%s TimeZone:%s chan[%d,%d,%d]", new Object[] { ((hk)localObject1).uQx, ((hk)localObject1).FSe, ((hk)localObject1).FSg, ((hk)localObject1).jfY, ((hk)localObject1).nIN, ((hk)localObject1).FSh, ((hk)localObject1).qkN, ((hk)localObject1).qkM, Integer.valueOf(((hk)localObject1).FJf), Integer.valueOf(k.cSM), Integer.valueOf(k.IwF) });
        try
        {
          localObject1 = this.FGj.toByteArray();
          AppMethodBeat.o(133091);
          return localObject1;
        }
        catch (IOException localIOException)
        {
          ae.e("MicroMsg.MMAuth", "summerauth toProtoBuf :%s", new Object[] { bu.o(localIOException) });
          AppMethodBeat.o(133091);
        }
        g.ajS();
        i = g.ajR().gDO.abw(46);
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
    
    public abstract int aCk();
    
    public abstract com.tencent.mm.network.q dc(int paramInt1, int paramInt2);
    
    public static final class a
    {
      public static j.e FGm;
    }
  }
  
  public static final class f
    extends j.h
    implements l.b
  {
    public byn FGn;
    public boolean FGo;
    
    public f()
    {
      AppMethodBeat.i(133094);
      this.FGn = new byn();
      this.FGo = false;
      AppMethodBeat.o(133094);
    }
    
    public final int getFuncId()
    {
      if (f.FFQ) {
        return 252;
      }
      return 701;
    }
    
    public final String getUri()
    {
      if (f.FFQ) {
        return "/cgi-bin/micromsg-bin/secmanualauth";
      }
      return "/cgi-bin/micromsg-bin/manualauth";
    }
    
    public final byte[] toProtoBuf()
    {
      int j = -1;
      AppMethodBeat.i(133095);
      a.xz("");
      int k = getSceneStatus();
      int i;
      Object localObject1;
      Object localObject2;
      if (k == 16)
      {
        i = 1;
        ae.d("MicroMsg.ManualReq", "summerstatus[%d] clientUpgrade[%d]", new Object[] { Integer.valueOf(k), Integer.valueOf(i) });
        if ((10002 == com.tencent.mm.platformtools.ac.iRH) && (com.tencent.mm.platformtools.ac.iRI > 0))
        {
          com.tencent.mm.platformtools.ac.iRI = 0;
          ac.am("", "", 0);
        }
        setRsaInfo(ac.fkn());
        localObject1 = this.FGn.Hlp;
        ((bym)localObject1).setBaseRequest(l.a(this));
        ((bym)localObject1).uQx = com.tencent.mm.compatible.deviceinfo.q.cH(true);
        ((bym)localObject1).FSe = b.wJt.MD(i);
        ((bym)localObject1).FSf = 0;
        ((bym)localObject1).FSg = a.ajd();
        ((bym)localObject1).jfY = bu.jp(ak.getContext());
        ((bym)localObject1).nIN = d.DEVICE_NAME;
        ((bym)localObject1).FSh = cd.fwK();
        ((bym)localObject1).qkN = ad.fom();
        ((bym)localObject1).qkM = bu.fpH();
        ((bym)localObject1).FJf = k.cSM;
        if ((10012 == com.tencent.mm.platformtools.ac.iRH) && (com.tencent.mm.platformtools.ac.iRI > 0)) {
          ((bym)localObject1).FJf = com.tencent.mm.platformtools.ac.iRI;
        }
        ((bym)localObject1).gvp = d.FFB;
        ((bym)localObject1).gvo = d.FFC;
        ((bym)localObject1).Hlk = d.FFD;
        ((bym)localObject1).GwD = com.tencent.mm.compatible.deviceinfo.q.getSimCountryIso();
        g.ajS();
        localObject2 = (String)g.ajR().gDO.get(18);
        ae.d("MicroMsg.ManualReq", "summerauth ksid:%s authreq flag:%d", new Object[] { localObject2, Integer.valueOf(((bym)localObject1).FSd.FUr) });
        ((bym)localObject1).FSd.FUp.FWO = new SKBuiltinBuffer_t().setBuffer(bu.aSx((String)localObject2));
      }
      for (;;)
      {
        try
        {
          localObject2 = b.wJt.dye();
          if (localObject2 == null) {
            continue;
          }
          i = localObject2.length;
          ae.d("MicroMsg.ManualReq", "[debug] ccd set on manual auth, len: %s", new Object[] { Integer.valueOf(i) });
          localObject3 = new eby();
          if ((2 == ((bym)localObject1).Hln) || (1 == ((bym)localObject1).Hln))
          {
            if (b.wJt.auF("ie_login_id")) {
              b.wJt.auE("ie_login_id");
            }
            ((eby)localObject3).Ihq = new SKBuiltinBuffer_t().setBuffer(b.wJt.auG("ie_login_id"));
            if (((eby)localObject3).Ihq == null) {
              continue;
            }
            i = ((eby)localObject3).Ihq.getILen();
            ae.d("MicroMsg.ManualReq", "[debug] wcstf set on manual auth, len: %s", new Object[] { Integer.valueOf(i) });
            ((eby)localObject3).Ihr = new SKBuiltinBuffer_t().setBuffer(b.wJt.auJ("ce_login_id"));
            if (((eby)localObject3).Ihr == null) {
              continue;
            }
            i = ((eby)localObject3).Ihr.getILen();
            ae.d("MicroMsg.ManualReq", "[debug] wcste set on manual auth, len: %s", new Object[] { Integer.valueOf(i) });
          }
          ((eby)localObject3).Ihw = new SKBuiltinBuffer_t().setBuffer(b.wJt.dyh());
          if (((eby)localObject3).Ihw == null) {
            continue;
          }
          i = ((eby)localObject3).Ihw.getILen();
          ae.d("MicroMsg.ManualReq", "[debug] devtok on manual auth, len: %s", new Object[] { Integer.valueOf(i) });
          ((eby)localObject3).Ihs = new SKBuiltinBuffer_t().setBuffer((byte[])localObject2);
          ((bym)localObject1).FSj = new SKBuiltinBuffer_t().setBuffer(((eby)localObject3).toByteArray());
        }
        catch (Throwable localThrowable)
        {
          Object localObject3;
          Object localObject5;
          Object localObject4;
          int m;
          ae.printErrStackTrace("MicroMsg.ManualReq", localThrowable, "cc throws exception.", new Object[0]);
          continue;
          i = localObject5.length;
          continue;
          j = localObject4.length;
          continue;
        }
        localObject2 = this.FGn.Hlo;
        ((byo)localObject2).FWl = new SKBuiltinBuffer_t().setBuffer(bu.fpG());
        localObject3 = new afy();
        ((afy)localObject3).Gwi = 713;
        localObject5 = new PByteArray();
        localObject4 = new PByteArray();
        k = MMProtocalJni.generateECKey(((afy)localObject3).Gwi, (PByteArray)localObject5, (PByteArray)localObject4);
        localObject5 = ((PByteArray)localObject5).value;
        localObject4 = ((PByteArray)localObject4).value;
        cp((byte[])localObject4);
        m = ((afy)localObject3).Gwi;
        if (localObject5 != null) {
          continue;
        }
        i = -1;
        if (localObject4 != null) {
          continue;
        }
        ae.d("MicroMsg.ManualReq", "summerecdh nid:%d ret:%d, pub len: %d, pri len:%d, pub:%s, pri:%s", new Object[] { Integer.valueOf(m), Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(j), bu.cE((byte[])localObject5), bu.cE((byte[])localObject4) });
        ((afy)localObject3).FSl = new SKBuiltinBuffer_t().setBuffer((byte[])localObject5);
        ((byo)localObject2).FSp = ((afy)localObject3);
        ae.i("MicroMsg.ManualReq", "summerauth manual IMEI:%s SoftType:%s ClientSeqID:%s Signature:%s DeviceName:%s DeviceType:%s Language:%s TimeZone:%s chan[%d,%d,%d] DeviceBrand:%s DeviceModel:%s OSType:%s RealCountry:%s", new Object[] { ((bym)localObject1).uQx, ((bym)localObject1).FSe, ((bym)localObject1).FSg, ((bym)localObject1).jfY, ((bym)localObject1).nIN, ((bym)localObject1).FSh, ((bym)localObject1).qkN, ((bym)localObject1).qkM, Integer.valueOf(((bym)localObject1).FJf), Integer.valueOf(k.cSM), Integer.valueOf(k.IwF), ((bym)localObject1).gvp, ((bym)localObject1).gvo, ((bym)localObject1).Hlk, ((bym)localObject1).GwD });
        try
        {
          localObject1 = this.FGn.toByteArray();
          AppMethodBeat.o(133095);
          return localObject1;
        }
        catch (IOException localIOException)
        {
          ae.e("MicroMsg.ManualReq", "summerauth toProtoBuf :%s", new Object[] { bu.o(localIOException) });
          AppMethodBeat.o(133095);
        }
        if (this.FGo)
        {
          i = 3;
          break;
        }
        g.ajS();
        i = g.ajR().gDO.abw(46);
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
        this.FGl = ((drp)this.FGl.parseFrom(paramArrayOfByte));
        l.a(this, this.FGl.getBaseResponse());
        this.gxH = 0;
        if ((this.FGl.getBaseResponse().Ret == 0) && ((this.FGl.HYs == null) || (this.FGl.HYs.qkC == 0) || (bu.cF(z.a(this.FGl.HYs.FRr)))))
        {
          ae.e("MicroMsg.MMAuth", "retcode 0 but invalid auth sect resp or invalid uin or invalid session");
          this.FGl.getBaseResponse().Ret = -1;
        }
        paramArrayOfByte = getErrMsg();
        ae.i("MicroMsg.MMAuth", "summerauthkick manual errmsg[%s]", new Object[] { paramArrayOfByte });
        a.xz(paramArrayOfByte);
        int i = this.FGl.getBaseResponse().Ret;
        AppMethodBeat.o(133096);
        return i;
      }
      catch (IOException paramArrayOfByte)
      {
        ae.e("MicroMsg.MMAuth", "toProtoBuf :%s", new Object[] { bu.o(paramArrayOfByte) });
        this.FGl.getBaseResponse().Ret = -1;
        AppMethodBeat.o(133096);
      }
      return -1;
    }
  }
  
  public static abstract class h
    extends l.d
    implements l.b
  {
    public byte[] FGk;
    
    public final void cp(byte[] paramArrayOfByte)
    {
      if (paramArrayOfByte != null) {}
      for (;;)
      {
        this.FGk = paramArrayOfByte;
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
    public drp FGl = new drp();
    public byte[] FGp;
    private byte[] FGq;
    public String dvq;
    public int gxH = 0;
    private byte[] iHg;
    private byte[] iHh;
    
    public final byte[] aak(int paramInt)
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
        ae.i("MicroMsg.MMAuth", "summerauths getSession seesionKeyType[%s] [%s]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
        return arrayOfByte;
        arrayOfByte = this.FGq;
        break;
        arrayOfByte = this.iHg;
        break;
        arrayOfByte = this.iHh;
        break;
      }
    }
    
    public final void b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
    {
      this.FGq = paramArrayOfByte1;
      this.iHg = paramArrayOfByte2;
      this.iHh = paramArrayOfByte3;
      ae.i("MicroMsg.MMAuth", "summerauths setSession [%s] [%s], [%s]", new Object[] { bu.aSM(bu.cE(this.FGq)), bu.aSM(bu.cE(this.iHg)), bu.aSM(bu.cE(this.iHh)) });
    }
    
    public byte[] getAuthResponse()
    {
      try
      {
        byte[] arrayOfByte = this.FGl.toByteArray();
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