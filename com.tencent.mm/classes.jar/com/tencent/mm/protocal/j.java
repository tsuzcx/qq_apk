package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.normsg.a.b;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bcd;
import com.tencent.mm.protocal.protobuf.bce;
import com.tencent.mm.protocal.protobuf.bcf;
import com.tencent.mm.protocal.protobuf.cmm;
import com.tencent.mm.protocal.protobuf.cuv;
import com.tencent.mm.protocal.protobuf.ft;
import com.tencent.mm.protocal.protobuf.gd;
import com.tencent.mm.protocal.protobuf.gf;
import com.tencent.mm.protocal.protobuf.gg;
import com.tencent.mm.protocal.protobuf.hm;
import com.tencent.mm.protocal.protobuf.zd;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bs;
import com.tencent.mm.storage.y;
import java.io.IOException;

public final class j
{
  public static final class a
    extends j.h
    implements l.b
  {
    public String username;
    public gf wij;
    
    public a()
    {
      AppMethodBeat.i(58833);
      this.wij = new gf();
      AppMethodBeat.o(58833);
    }
    
    public final int getFuncId()
    {
      if (f.whQ) {
        return 763;
      }
      return 702;
    }
    
    public final String getUri()
    {
      if (f.whQ) {
        return "/cgi-bin/micromsg-bin/secautoauth";
      }
      return "/cgi-bin/micromsg-bin/autoauth";
    }
    
    public final byte[] toProtoBuf()
    {
      int j = -1;
      AppMethodBeat.i(58834);
      a.mv("");
      int k = getSceneStatus();
      int i;
      Object localObject1;
      Object localObject2;
      if (k == 12)
      {
        i = 1;
        ab.d("MicroMsg.AutoReq", "summerstatus[%d] clientUpgrade[%d]", new Object[] { Integer.valueOf(k), Integer.valueOf(i) });
        setRsaInfo(aa.dqE());
        if ((10002 == ae.gkK) && (ae.gkL > 0))
        {
          ae.gkL = 0;
          aa.T("", "", 0);
        }
        localObject1 = this.wij.wsw;
        ((gd)localObject1).setBaseRequest(l.a(this));
        ab.i("MicroMsg.AutoReq", "summerauth autoauth toProtoBuf uin[%d]", new Object[] { Integer.valueOf(getUin()) });
        ((gd)localObject1).nGG = com.tencent.mm.compatible.e.q.bP(true);
        ((gd)localObject1).wsn = b.pgQ.AP(i);
        ((gd)localObject1).wso = 0;
        ((gd)localObject1).wsp = a.QX();
        ((gd)localObject1).gwS = bo.hk(ah.getContext());
        ((gd)localObject1).jJE = d.DEVICE_NAME;
        ((gd)localObject1).wsq = bs.dyO();
        ((gd)localObject1).lGH = com.tencent.mm.sdk.platformtools.aa.dsG();
        ((gd)localObject1).lGG = bo.dtS();
        ((gd)localObject1).wkX = com.tencent.mm.sdk.platformtools.g.bWu;
        com.tencent.mm.kernel.g.RM();
        localObject2 = (String)com.tencent.mm.kernel.g.RL().eHM.get(18);
        ab.d("MicroMsg.AutoReq", "summerecdh ksid:%s, flag:%d", new Object[] { localObject2, Integer.valueOf(((gd)localObject1).wsm.wuk) });
        ((gd)localObject1).wsm.wui.wwo = new SKBuiltinBuffer_t().setBuffer(bo.apQ((String)localObject2));
      }
      for (;;)
      {
        try
        {
          localObject2 = b.pgQ.bXq();
          if (localObject2 == null) {
            continue;
          }
          i = localObject2.length;
          ab.d("MicroMsg.AutoReq", "[tomys] ccd set on auto auth, len: %s", new Object[] { Integer.valueOf(i) });
          localObject3 = new cuv();
          ((cuv)localObject3).ydy = new SKBuiltinBuffer_t().setBuffer((byte[])localObject2);
          ((gd)localObject1).wss = new SKBuiltinBuffer_t().setBuffer(((cuv)localObject3).toByteArray());
        }
        catch (Throwable localThrowable)
        {
          Object localObject3;
          Object localObject5;
          Object localObject4;
          int m;
          ab.printErrStackTrace("MicroMsg.AutoReq", localThrowable, "cc throws exception.", new Object[0]);
          continue;
          i = localObject5.length;
          continue;
          j = localObject4.length;
          continue;
        }
        localObject2 = this.wij.wsv;
        localObject3 = new zd();
        ((zd)localObject3).wQb = 713;
        localObject5 = new PByteArray();
        localObject4 = new PByteArray();
        k = MMProtocalJni.generateECKey(((zd)localObject3).wQb, (PByteArray)localObject5, (PByteArray)localObject4);
        localObject5 = ((PByteArray)localObject5).value;
        localObject4 = ((PByteArray)localObject4).value;
        bO((byte[])localObject4);
        m = ((zd)localObject3).wQb;
        if (localObject5 != null) {
          continue;
        }
        i = -1;
        if (localObject4 != null) {
          continue;
        }
        ab.d("MicroMsg.AutoReq", "summerecdh nid:%d ret:%d, pub len: %d, pri len:%d, pub:%s, pri:%s", new Object[] { Integer.valueOf(m), Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(j), bo.cd((byte[])localObject5), bo.cd((byte[])localObject4) });
        ((zd)localObject3).wsu = new SKBuiltinBuffer_t().setBuffer((byte[])localObject5);
        ((gg)localObject2).wsy = ((zd)localObject3);
        ab.i("MicroMsg.AutoReq", "summerauth auto IMEI:%s SoftType:%s ClientSeqID:%s Signature:%s DeviceName:%s DeviceType:%s Language:%s TimeZone:%s chan[%d,%d,%d]", new Object[] { ((gd)localObject1).nGG, ((gd)localObject1).wsn, ((gd)localObject1).wsp, ((gd)localObject1).gwS, ((gd)localObject1).jJE, ((gd)localObject1).wsq, ((gd)localObject1).lGH, ((gd)localObject1).lGG, Integer.valueOf(((gd)localObject1).wkX), Integer.valueOf(com.tencent.mm.sdk.platformtools.g.bWu), Integer.valueOf(com.tencent.mm.sdk.platformtools.g.ymI) });
        try
        {
          localObject1 = this.wij.toByteArray();
          AppMethodBeat.o(58834);
          return localObject1;
        }
        catch (IOException localIOException)
        {
          ab.e("MicroMsg.AutoReq", "summerauth toProtoBuf :%s", new Object[] { bo.l(localIOException) });
          AppMethodBeat.o(58834);
        }
        com.tencent.mm.kernel.g.RM();
        i = com.tencent.mm.kernel.g.RL().eHM.Nr(46);
        break;
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
      AppMethodBeat.i(58835);
      try
      {
        this.wil = ((cmm)this.wil.parseFrom(paramArrayOfByte));
        l.a(this, this.wil.getBaseResponse());
        this.eBe = 0;
        if ((this.wil.getBaseResponse().Ret == 0) && ((this.wil.xWm == null) || (this.wil.xWm.lGw == 0) || (bo.ce(com.tencent.mm.platformtools.aa.a(this.wil.xWm.wrK)))))
        {
          ab.e("MicroMsg.MMAuth", "retcode 0 but invalid auth sect resp or invalid uin or invalid session");
          this.wil.getBaseResponse().Ret = -1;
        }
        paramArrayOfByte = getErrMsg();
        ab.i("MicroMsg.MMAuth", "summerauthkick auto errmsg[%s]", new Object[] { paramArrayOfByte });
        a.mv(paramArrayOfByte);
        int i = this.wil.getBaseResponse().Ret;
        AppMethodBeat.o(58835);
        return i;
      }
      catch (IOException paramArrayOfByte)
      {
        ab.e("MicroMsg.MMAuth", "toProtoBuf :%s", new Object[] { bo.l(paramArrayOfByte) });
        this.wil.getBaseResponse().Ret = -1;
        AppMethodBeat.o(58835);
      }
      return -1;
    }
  }
  
  public static final class c
    extends l.d
    implements l.b
  {
    public String username;
    public gf wij;
    private byte[] wik;
    
    public c()
    {
      AppMethodBeat.i(154764);
      this.wij = new gf();
      AppMethodBeat.o(154764);
    }
    
    public final int getFuncId()
    {
      return 3941;
    }
    
    public final byte[] toProtoBuf()
    {
      int j = -1;
      AppMethodBeat.i(154765);
      a.mv("");
      int k = getSceneStatus();
      int i;
      Object localObject1;
      Object localObject2;
      zd localzd;
      Object localObject4;
      Object localObject3;
      int m;
      if (k == 12)
      {
        i = 1;
        ab.d("MicroMsg.MMAuth", "summerstatus[%d] clientUpgrade[%d]", new Object[] { Integer.valueOf(k), Integer.valueOf(i) });
        setRsaInfo(aa.dqE());
        if ((10002 == ae.gkK) && (ae.gkL > 0))
        {
          ae.gkL = 0;
          aa.T("", "", 0);
        }
        localObject1 = this.wij.wsw;
        ((gd)localObject1).setBaseRequest(l.a(this));
        ab.i("MicroMsg.MMAuth", "summerauth autoauth toProtoBuf uin[%d]", new Object[] { Integer.valueOf(getUin()) });
        ((gd)localObject1).nGG = com.tencent.mm.compatible.e.q.LD();
        ((gd)localObject1).wsn = b.pgQ.AP(i);
        ((gd)localObject1).wso = 0;
        ((gd)localObject1).wsp = a.QX();
        ((gd)localObject1).gwS = bo.hk(ah.getContext());
        ((gd)localObject1).jJE = d.DEVICE_NAME;
        ((gd)localObject1).wsq = bs.dyO();
        ((gd)localObject1).lGH = com.tencent.mm.sdk.platformtools.aa.dsG();
        ((gd)localObject1).lGG = bo.dtS();
        ((gd)localObject1).wkX = com.tencent.mm.sdk.platformtools.g.bWu;
        com.tencent.mm.kernel.g.RM();
        localObject2 = (String)com.tencent.mm.kernel.g.RL().eHM.get(18);
        ab.d("MicroMsg.MMAuth", "summerecdh ksid:%s, flag:%d", new Object[] { localObject2, Integer.valueOf(((gd)localObject1).wsm.wuk) });
        ((gd)localObject1).wsm.wui.wwo = new SKBuiltinBuffer_t().setBuffer(bo.apQ((String)localObject2));
        localObject2 = this.wij.wsv;
        localzd = new zd();
        localzd.wQb = 713;
        localObject4 = new PByteArray();
        localObject3 = new PByteArray();
        k = MMProtocalJni.generateECKey(localzd.wQb, (PByteArray)localObject4, (PByteArray)localObject3);
        localObject4 = ((PByteArray)localObject4).value;
        localObject3 = ((PByteArray)localObject3).value;
        this.wik = ((byte[])localObject3);
        m = localzd.wQb;
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
        ab.d("MicroMsg.MMAuth", "summerecdh nid:%d ret:%d, pub len: %d, pri len:%d, pub:%s, pri:%s", new Object[] { Integer.valueOf(m), Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(j), bo.cd((byte[])localObject4), bo.cd((byte[])localObject3) });
        localzd.wsu = new SKBuiltinBuffer_t().setBuffer((byte[])localObject4);
        ((gg)localObject2).wsy = localzd;
        ab.i("MicroMsg.MMAuth", "summerauth auto IMEI:%s SoftType:%s ClientSeqID:%s Signature:%s DeviceName:%s DeviceType:%s Language:%s TimeZone:%s chan[%d,%d,%d]", new Object[] { ((gd)localObject1).nGG, ((gd)localObject1).wsn, ((gd)localObject1).wsp, ((gd)localObject1).gwS, ((gd)localObject1).jJE, ((gd)localObject1).wsq, ((gd)localObject1).lGH, ((gd)localObject1).lGG, Integer.valueOf(((gd)localObject1).wkX), Integer.valueOf(com.tencent.mm.sdk.platformtools.g.bWu), Integer.valueOf(com.tencent.mm.sdk.platformtools.g.ymI) });
        try
        {
          localObject1 = this.wij.toByteArray();
          AppMethodBeat.o(154765);
          return localObject1;
        }
        catch (IOException localIOException)
        {
          ab.e("MicroMsg.MMAuth", "summerauth toProtoBuf :%s", new Object[] { bo.l(localIOException) });
          AppMethodBeat.o(154765);
        }
        com.tencent.mm.kernel.g.RM();
        i = com.tencent.mm.kernel.g.RL().eHM.Nr(46);
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
  
  public static final class d
    extends l.e
    implements l.c
  {
    public cmm wil;
    
    public d()
    {
      AppMethodBeat.i(154766);
      this.wil = new cmm();
      AppMethodBeat.o(154766);
    }
    
    public final int fromProtoBuf(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(154767);
      try
      {
        this.wil = ((cmm)this.wil.parseFrom(paramArrayOfByte));
        l.a(this, this.wil.getBaseResponse());
        if ((this.wil.getBaseResponse().Ret == 0) && ((this.wil.xWm == null) || (this.wil.xWm.lGw == 0) || (bo.ce(com.tencent.mm.platformtools.aa.a(this.wil.xWm.wrK)))))
        {
          ab.e("MicroMsg.MMAuth", "retcode 0 but invalid auth sect resp or invalid uin or invalid session");
          this.wil.getBaseResponse().Ret = -1;
        }
        paramArrayOfByte = getErrMsg();
        ab.i("MicroMsg.MMAuth", "summerauthkick auto errmsg[%s]", new Object[] { paramArrayOfByte });
        a.mv(paramArrayOfByte);
        int i = this.wil.getBaseResponse().Ret;
        AppMethodBeat.o(154767);
        return i;
      }
      catch (IOException paramArrayOfByte)
      {
        ab.e("MicroMsg.MMAuth", "toProtoBuf :%s", new Object[] { bo.l(paramArrayOfByte) });
        this.wil.getBaseResponse().Ret = -1;
        AppMethodBeat.o(154767);
      }
      return -1;
    }
  }
  
  public static abstract interface e
  {
    public abstract void a(j.h paramh, j.i parami, int paramInt1, int paramInt2, String paramString);
    
    public abstract int aaE();
    
    public abstract com.tencent.mm.network.q cr(int paramInt1, int paramInt2);
    
    public static final class a
    {
      public static j.e wim;
    }
  }
  
  public static final class f
    extends j.h
    implements l.b
  {
    public bce win;
    public boolean wio;
    
    public f()
    {
      AppMethodBeat.i(58836);
      this.win = new bce();
      this.wio = false;
      AppMethodBeat.o(58836);
    }
    
    public final int getFuncId()
    {
      if (f.whQ) {
        return 252;
      }
      return 701;
    }
    
    public final String getUri()
    {
      if (f.whQ) {
        return "/cgi-bin/micromsg-bin/secmanualauth";
      }
      return "/cgi-bin/micromsg-bin/manualauth";
    }
    
    public final byte[] toProtoBuf()
    {
      int j = -1;
      AppMethodBeat.i(58837);
      a.mv("");
      int k = getSceneStatus();
      int i;
      Object localObject1;
      Object localObject2;
      if (k == 16)
      {
        i = 1;
        ab.d("MicroMsg.ManualReq", "summerstatus[%d] clientUpgrade[%d]", new Object[] { Integer.valueOf(k), Integer.valueOf(i) });
        if ((10002 == ae.gkK) && (ae.gkL > 0))
        {
          ae.gkL = 0;
          aa.T("", "", 0);
        }
        setRsaInfo(aa.dqE());
        localObject1 = this.win.xrn;
        ((bcd)localObject1).setBaseRequest(l.a(this));
        ((bcd)localObject1).nGG = com.tencent.mm.compatible.e.q.bP(true);
        ((bcd)localObject1).wsn = b.pgQ.AP(i);
        ((bcd)localObject1).wso = 0;
        ((bcd)localObject1).wsp = a.QX();
        ((bcd)localObject1).gwS = bo.hk(ah.getContext());
        ((bcd)localObject1).jJE = d.DEVICE_NAME;
        ((bcd)localObject1).wsq = bs.dyO();
        ((bcd)localObject1).lGH = com.tencent.mm.sdk.platformtools.aa.dsG();
        ((bcd)localObject1).lGG = bo.dtS();
        ((bcd)localObject1).wkX = com.tencent.mm.sdk.platformtools.g.bWu;
        if ((10012 == ae.gkK) && (ae.gkL > 0)) {
          ((bcd)localObject1).wkX = ae.gkL;
        }
        ((bcd)localObject1).wAc = d.whB;
        ((bcd)localObject1).wAb = d.whC;
        ((bcd)localObject1).xri = d.whD;
        ((bcd)localObject1).wQd = com.tencent.mm.compatible.e.q.getSimCountryIso();
        com.tencent.mm.kernel.g.RM();
        localObject2 = (String)com.tencent.mm.kernel.g.RL().eHM.get(18);
        ab.d("MicroMsg.ManualReq", "summerauth ksid:%s authreq flag:%d", new Object[] { localObject2, Integer.valueOf(((bcd)localObject1).wsm.wuk) });
        ((bcd)localObject1).wsm.wui.wwo = new SKBuiltinBuffer_t().setBuffer(bo.apQ((String)localObject2));
      }
      for (;;)
      {
        try
        {
          localObject2 = b.pgQ.bXq();
          if (localObject2 == null) {
            continue;
          }
          i = localObject2.length;
          ab.d("MicroMsg.ManualReq", "[debug] ccd set on manual auth, len: %s", new Object[] { Integer.valueOf(i) });
          localObject3 = new cuv();
          if ((2 == ((bcd)localObject1).xrl) || (1 == ((bcd)localObject1).xrl))
          {
            if (b.pgQ.VY("ie_login_id")) {
              b.pgQ.VX("ie_login_id");
            }
            ((cuv)localObject3).ydw = new SKBuiltinBuffer_t().setBuffer(b.pgQ.VZ("ie_login_id"));
            if (((cuv)localObject3).ydw == null) {
              continue;
            }
            i = ((cuv)localObject3).ydw.getILen();
            ab.d("MicroMsg.ManualReq", "[debug] wcstf set on manual auth, len: %s", new Object[] { Integer.valueOf(i) });
            ((cuv)localObject3).ydx = new SKBuiltinBuffer_t().setBuffer(b.pgQ.Wc("ce_login_id"));
            if (((cuv)localObject3).ydx == null) {
              continue;
            }
            i = ((cuv)localObject3).ydx.getILen();
            ab.d("MicroMsg.ManualReq", "[debug] wcste set on manual auth, len: %s", new Object[] { Integer.valueOf(i) });
          }
          ((cuv)localObject3).ydy = new SKBuiltinBuffer_t().setBuffer((byte[])localObject2);
          ((bcd)localObject1).wss = new SKBuiltinBuffer_t().setBuffer(((cuv)localObject3).toByteArray());
        }
        catch (Throwable localThrowable)
        {
          Object localObject3;
          Object localObject5;
          Object localObject4;
          int m;
          ab.printErrStackTrace("MicroMsg.ManualReq", localThrowable, "cc throws exception.", new Object[0]);
          continue;
          i = localObject5.length;
          continue;
          j = localObject4.length;
          continue;
        }
        localObject2 = this.win.xrm;
        ((bcf)localObject2).wvN = new SKBuiltinBuffer_t().setBuffer(bo.dtR());
        localObject3 = new zd();
        ((zd)localObject3).wQb = 713;
        localObject5 = new PByteArray();
        localObject4 = new PByteArray();
        k = MMProtocalJni.generateECKey(((zd)localObject3).wQb, (PByteArray)localObject5, (PByteArray)localObject4);
        localObject5 = ((PByteArray)localObject5).value;
        localObject4 = ((PByteArray)localObject4).value;
        bO((byte[])localObject4);
        m = ((zd)localObject3).wQb;
        if (localObject5 != null) {
          continue;
        }
        i = -1;
        if (localObject4 != null) {
          continue;
        }
        ab.d("MicroMsg.ManualReq", "summerecdh nid:%d ret:%d, pub len: %d, pri len:%d, pub:%s, pri:%s", new Object[] { Integer.valueOf(m), Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(j), bo.cd((byte[])localObject5), bo.cd((byte[])localObject4) });
        ((zd)localObject3).wsu = new SKBuiltinBuffer_t().setBuffer((byte[])localObject5);
        ((bcf)localObject2).wsy = ((zd)localObject3);
        ab.i("MicroMsg.ManualReq", "summerauth manual IMEI:%s SoftType:%s ClientSeqID:%s Signature:%s DeviceName:%s DeviceType:%s Language:%s TimeZone:%s chan[%d,%d,%d] DeviceBrand:%s DeviceModel:%s OSType:%s RealCountry:%s", new Object[] { ((bcd)localObject1).nGG, ((bcd)localObject1).wsn, ((bcd)localObject1).wsp, ((bcd)localObject1).gwS, ((bcd)localObject1).jJE, ((bcd)localObject1).wsq, ((bcd)localObject1).lGH, ((bcd)localObject1).lGG, Integer.valueOf(((bcd)localObject1).wkX), Integer.valueOf(com.tencent.mm.sdk.platformtools.g.bWu), Integer.valueOf(com.tencent.mm.sdk.platformtools.g.ymI), ((bcd)localObject1).wAc, ((bcd)localObject1).wAb, ((bcd)localObject1).xri, ((bcd)localObject1).wQd });
        try
        {
          localObject1 = this.win.toByteArray();
          AppMethodBeat.o(58837);
          return localObject1;
        }
        catch (IOException localIOException)
        {
          ab.e("MicroMsg.ManualReq", "summerauth toProtoBuf :%s", new Object[] { bo.l(localIOException) });
          AppMethodBeat.o(58837);
        }
        if (this.wio)
        {
          i = 3;
          break;
        }
        com.tencent.mm.kernel.g.RM();
        i = com.tencent.mm.kernel.g.RL().eHM.Nr(46);
        break;
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
      AppMethodBeat.i(58838);
      try
      {
        this.wil = ((cmm)this.wil.parseFrom(paramArrayOfByte));
        l.a(this, this.wil.getBaseResponse());
        this.eBe = 0;
        if ((this.wil.getBaseResponse().Ret == 0) && ((this.wil.xWm == null) || (this.wil.xWm.lGw == 0) || (bo.ce(com.tencent.mm.platformtools.aa.a(this.wil.xWm.wrK)))))
        {
          ab.e("MicroMsg.MMAuth", "retcode 0 but invalid auth sect resp or invalid uin or invalid session");
          this.wil.getBaseResponse().Ret = -1;
        }
        paramArrayOfByte = getErrMsg();
        ab.i("MicroMsg.MMAuth", "summerauthkick manual errmsg[%s]", new Object[] { paramArrayOfByte });
        a.mv(paramArrayOfByte);
        int i = this.wil.getBaseResponse().Ret;
        AppMethodBeat.o(58838);
        return i;
      }
      catch (IOException paramArrayOfByte)
      {
        ab.e("MicroMsg.MMAuth", "toProtoBuf :%s", new Object[] { bo.l(paramArrayOfByte) });
        this.wil.getBaseResponse().Ret = -1;
        AppMethodBeat.o(58838);
      }
      return -1;
    }
  }
  
  public static abstract class h
    extends l.d
    implements l.b
  {
    public byte[] wik;
    
    public final void bO(byte[] paramArrayOfByte)
    {
      if (paramArrayOfByte != null) {}
      for (;;)
      {
        this.wik = paramArrayOfByte;
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
    public int eBe = 0;
    private byte[] gda;
    private byte[] gdb;
    public String gde;
    public cmm wil = new cmm();
    public byte[] wip;
    private byte[] wiq;
    
    public final byte[] ME(int paramInt)
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
        ab.i("MicroMsg.MMAuth", "summerauths getSession seesionKeyType[%s] [%s]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
        return arrayOfByte;
        arrayOfByte = this.wiq;
        break;
        arrayOfByte = this.gda;
        break;
        arrayOfByte = this.gdb;
        break;
      }
    }
    
    public final void b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
    {
      this.wiq = paramArrayOfByte1;
      this.gda = paramArrayOfByte2;
      this.gdb = paramArrayOfByte3;
      ab.i("MicroMsg.MMAuth", "summerauths setSession [%s] [%s], [%s]", new Object[] { bo.aqg(bo.cd(this.wiq)), bo.aqg(bo.cd(this.gda)), bo.aqg(bo.cd(this.gdb)) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.j
 * JD-Core Version:    0.7.0.1
 */