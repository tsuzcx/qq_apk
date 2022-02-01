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
import com.tencent.mm.protocal.protobuf.afp;
import com.tencent.mm.protocal.protobuf.bxs;
import com.tencent.mm.protocal.protobuf.bxt;
import com.tencent.mm.protocal.protobuf.bxu;
import com.tencent.mm.protocal.protobuf.dqs;
import com.tencent.mm.protocal.protobuf.eah;
import com.tencent.mm.protocal.protobuf.gx;
import com.tencent.mm.protocal.protobuf.hk;
import com.tencent.mm.protocal.protobuf.hm;
import com.tencent.mm.protocal.protobuf.hn;
import com.tencent.mm.protocal.protobuf.ix;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.cc;
import java.io.IOException;

public final class j
{
  public static final class a
    extends j.h
    implements l.b
  {
    public hm FnL;
    public String username;
    
    public a()
    {
      AppMethodBeat.i(133087);
      this.FnL = new hm();
      AppMethodBeat.o(133087);
    }
    
    public final int getFuncId()
    {
      if (f.Fns) {
        return 763;
      }
      return 702;
    }
    
    public final String getUri()
    {
      if (f.Fns) {
        return "/cgi-bin/micromsg-bin/secautoauth";
      }
      return "/cgi-bin/micromsg-bin/autoauth";
    }
    
    public final byte[] toProtoBuf()
    {
      int j = -1;
      AppMethodBeat.i(133088);
      a.wQ("");
      int k = getSceneStatus();
      int i;
      Object localObject1;
      Object localObject2;
      if (k == 12)
      {
        i = 1;
        ad.d("MicroMsg.AutoReq", "summerstatus[%d] clientUpgrade[%d]", new Object[] { Integer.valueOf(k), Integer.valueOf(i) });
        setRsaInfo(ac.fgx());
        if ((10002 == com.tencent.mm.platformtools.ac.iON) && (com.tencent.mm.platformtools.ac.iOO > 0))
        {
          com.tencent.mm.platformtools.ac.iOO = 0;
          ac.ak("", "", 0);
        }
        localObject1 = this.FnL.FzP;
        ((hk)localObject1).setBaseRequest(l.a(this));
        ad.i("MicroMsg.AutoReq", "summerauth autoauth toProtoBuf uin[%d]", new Object[] { Integer.valueOf(getUin()) });
        ((hk)localObject1).uEK = com.tencent.mm.compatible.deviceinfo.q.cH(true);
        ((hk)localObject1).FzG = b.wtJ.LY(i);
        ((hk)localObject1).FzH = 0;
        ((hk)localObject1).FzI = a.aiO();
        ((hk)localObject1).jdf = bt.jj(aj.getContext());
        ((hk)localObject1).nDs = d.DEVICE_NAME;
        ((hk)localObject1).FzJ = cc.fsJ();
        ((hk)localObject1).qei = com.tencent.mm.sdk.platformtools.ac.fks();
        ((hk)localObject1).qeh = bt.flM();
        ((hk)localObject1).FqH = com.tencent.mm.sdk.platformtools.j.cSc;
        g.ajD();
        localObject2 = (String)g.ajC().gBh.get(18);
        ad.d("MicroMsg.AutoReq", "summerecdh ksid:%s, flag:%d", new Object[] { localObject2, Integer.valueOf(((hk)localObject1).FzF.FBW) });
        ((hk)localObject1).FzF.FBU.FEt = new SKBuiltinBuffer_t().setBuffer(bt.aRa((String)localObject2));
      }
      for (;;)
      {
        try
        {
          localObject2 = b.wtJ.duO();
          if (localObject2 == null) {
            continue;
          }
          i = localObject2.length;
          ad.d("MicroMsg.AutoReq", "[tomys] ccd set on auto auth, len: %s", new Object[] { Integer.valueOf(i) });
          localObject3 = new eah();
          ((eah)localObject3).HNl = new SKBuiltinBuffer_t().setBuffer((byte[])localObject2);
          ((eah)localObject3).HNp = new SKBuiltinBuffer_t().setBuffer(b.wtJ.duR());
          if (((eah)localObject3).HNp == null) {
            continue;
          }
          i = ((eah)localObject3).HNp.getILen();
          ad.d("MicroMsg.AutoReq", "[debug] devtok on auto auth, len: %s", new Object[] { Integer.valueOf(i) });
          ((hk)localObject1).FzL = new SKBuiltinBuffer_t().setBuffer(((eah)localObject3).toByteArray());
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
        localObject2 = this.FnL.FzO;
        localObject3 = new afp();
        ((afp)localObject3).GdB = 713;
        localObject5 = new PByteArray();
        localObject4 = new PByteArray();
        k = MMProtocalJni.generateECKey(((afp)localObject3).GdB, (PByteArray)localObject5, (PByteArray)localObject4);
        localObject5 = ((PByteArray)localObject5).value;
        localObject4 = ((PByteArray)localObject4).value;
        cm((byte[])localObject4);
        m = ((afp)localObject3).GdB;
        if (localObject5 != null) {
          continue;
        }
        i = -1;
        if (localObject4 != null) {
          continue;
        }
        ad.d("MicroMsg.AutoReq", "summerecdh nid:%d ret:%d, pub len: %d, pri len:%d, pub:%s, pri:%s", new Object[] { Integer.valueOf(m), Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(j), bt.cB((byte[])localObject5), bt.cB((byte[])localObject4) });
        ((afp)localObject3).FzN = new SKBuiltinBuffer_t().setBuffer((byte[])localObject5);
        ((hn)localObject2).FzR = ((afp)localObject3);
        ad.i("MicroMsg.AutoReq", "summerauth auto IMEI:%s SoftType:%s ClientSeqID:%s Signature:%s DeviceName:%s DeviceType:%s Language:%s TimeZone:%s chan[%d,%d,%d]", new Object[] { ((hk)localObject1).uEK, ((hk)localObject1).FzG, ((hk)localObject1).FzI, ((hk)localObject1).jdf, ((hk)localObject1).nDs, ((hk)localObject1).FzJ, ((hk)localObject1).qei, ((hk)localObject1).qeh, Integer.valueOf(((hk)localObject1).FqH), Integer.valueOf(com.tencent.mm.sdk.platformtools.j.cSc), Integer.valueOf(com.tencent.mm.sdk.platformtools.j.Icu) });
        try
        {
          localObject1 = this.FnL.toByteArray();
          AppMethodBeat.o(133088);
          return localObject1;
        }
        catch (IOException localIOException)
        {
          ad.e("MicroMsg.AutoReq", "summerauth toProtoBuf :%s", new Object[] { bt.n(localIOException) });
          AppMethodBeat.o(133088);
        }
        g.ajD();
        i = g.ajC().gBh.aaO(46);
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
        this.FnN = ((dqs)this.FnN.parseFrom(paramArrayOfByte));
        l.a(this, this.FnN.getBaseResponse());
        this.gva = 0;
        if ((this.FnN.getBaseResponse().Ret == 0) && ((this.FnN.HEF == null) || (this.FnN.HEF.qdX == 0) || (bt.cC(z.a(this.FnN.HEF.FyT)))))
        {
          ad.e("MicroMsg.MMAuth", "retcode 0 but invalid auth sect resp or invalid uin or invalid session");
          this.FnN.getBaseResponse().Ret = -1;
        }
        paramArrayOfByte = getErrMsg();
        ad.i("MicroMsg.MMAuth", "summerauthkick auto errmsg[%s]", new Object[] { paramArrayOfByte });
        a.wQ(paramArrayOfByte);
        int i = this.FnN.getBaseResponse().Ret;
        AppMethodBeat.o(133089);
        return i;
      }
      catch (IOException paramArrayOfByte)
      {
        ad.e("MicroMsg.MMAuth", "toProtoBuf :%s", new Object[] { bt.n(paramArrayOfByte) });
        this.FnN.getBaseResponse().Ret = -1;
        AppMethodBeat.o(133089);
      }
      return -1;
    }
  }
  
  public static final class c
    extends l.d
    implements l.b
  {
    public hm FnL;
    private byte[] FnM;
    public String username;
    
    public c()
    {
      AppMethodBeat.i(133090);
      this.FnL = new hm();
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
      a.wQ("");
      int k = getSceneStatus();
      int i;
      Object localObject1;
      Object localObject2;
      afp localafp;
      Object localObject4;
      Object localObject3;
      int m;
      if (k == 12)
      {
        i = 1;
        ad.d("MicroMsg.MMAuth", "summerstatus[%d] clientUpgrade[%d]", new Object[] { Integer.valueOf(k), Integer.valueOf(i) });
        setRsaInfo(ac.fgx());
        if ((10002 == com.tencent.mm.platformtools.ac.iON) && (com.tencent.mm.platformtools.ac.iOO > 0))
        {
          com.tencent.mm.platformtools.ac.iOO = 0;
          ac.ak("", "", 0);
        }
        localObject1 = this.FnL.FzP;
        ((hk)localObject1).setBaseRequest(l.a(this));
        ad.i("MicroMsg.MMAuth", "summerauth autoauth toProtoBuf uin[%d]", new Object[] { Integer.valueOf(getUin()) });
        ((hk)localObject1).uEK = com.tencent.mm.compatible.deviceinfo.q.aar();
        ((hk)localObject1).FzG = b.wtJ.LY(i);
        ((hk)localObject1).FzH = 0;
        ((hk)localObject1).FzI = a.aiO();
        ((hk)localObject1).jdf = bt.jj(aj.getContext());
        ((hk)localObject1).nDs = d.DEVICE_NAME;
        ((hk)localObject1).FzJ = cc.fsJ();
        ((hk)localObject1).qei = com.tencent.mm.sdk.platformtools.ac.fks();
        ((hk)localObject1).qeh = bt.flM();
        ((hk)localObject1).FqH = com.tencent.mm.sdk.platformtools.j.cSc;
        g.ajD();
        localObject2 = (String)g.ajC().gBh.get(18);
        ad.d("MicroMsg.MMAuth", "summerecdh ksid:%s, flag:%d", new Object[] { localObject2, Integer.valueOf(((hk)localObject1).FzF.FBW) });
        ((hk)localObject1).FzF.FBU.FEt = new SKBuiltinBuffer_t().setBuffer(bt.aRa((String)localObject2));
        localObject2 = this.FnL.FzO;
        localafp = new afp();
        localafp.GdB = 713;
        localObject4 = new PByteArray();
        localObject3 = new PByteArray();
        k = MMProtocalJni.generateECKey(localafp.GdB, (PByteArray)localObject4, (PByteArray)localObject3);
        localObject4 = ((PByteArray)localObject4).value;
        localObject3 = ((PByteArray)localObject3).value;
        this.FnM = ((byte[])localObject3);
        m = localafp.GdB;
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
        ad.d("MicroMsg.MMAuth", "summerecdh nid:%d ret:%d, pub len: %d, pri len:%d, pub:%s, pri:%s", new Object[] { Integer.valueOf(m), Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(j), bt.cB((byte[])localObject4), bt.cB((byte[])localObject3) });
        localafp.FzN = new SKBuiltinBuffer_t().setBuffer((byte[])localObject4);
        ((hn)localObject2).FzR = localafp;
        ad.i("MicroMsg.MMAuth", "summerauth auto IMEI:%s SoftType:%s ClientSeqID:%s Signature:%s DeviceName:%s DeviceType:%s Language:%s TimeZone:%s chan[%d,%d,%d]", new Object[] { ((hk)localObject1).uEK, ((hk)localObject1).FzG, ((hk)localObject1).FzI, ((hk)localObject1).jdf, ((hk)localObject1).nDs, ((hk)localObject1).FzJ, ((hk)localObject1).qei, ((hk)localObject1).qeh, Integer.valueOf(((hk)localObject1).FqH), Integer.valueOf(com.tencent.mm.sdk.platformtools.j.cSc), Integer.valueOf(com.tencent.mm.sdk.platformtools.j.Icu) });
        try
        {
          localObject1 = this.FnL.toByteArray();
          AppMethodBeat.o(133091);
          return localObject1;
        }
        catch (IOException localIOException)
        {
          ad.e("MicroMsg.MMAuth", "summerauth toProtoBuf :%s", new Object[] { bt.n(localIOException) });
          AppMethodBeat.o(133091);
        }
        g.ajD();
        i = g.ajC().gBh.aaO(46);
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
    
    public abstract int aBU();
    
    public abstract com.tencent.mm.network.q dc(int paramInt1, int paramInt2);
    
    public static final class a
    {
      public static j.e FnO;
    }
  }
  
  public static final class f
    extends j.h
    implements l.b
  {
    public bxt FnP;
    public boolean FnQ;
    
    public f()
    {
      AppMethodBeat.i(133094);
      this.FnP = new bxt();
      this.FnQ = false;
      AppMethodBeat.o(133094);
    }
    
    public final int getFuncId()
    {
      if (f.Fns) {
        return 252;
      }
      return 701;
    }
    
    public final String getUri()
    {
      if (f.Fns) {
        return "/cgi-bin/micromsg-bin/secmanualauth";
      }
      return "/cgi-bin/micromsg-bin/manualauth";
    }
    
    public final byte[] toProtoBuf()
    {
      int j = -1;
      AppMethodBeat.i(133095);
      a.wQ("");
      int k = getSceneStatus();
      int i;
      Object localObject1;
      Object localObject2;
      if (k == 16)
      {
        i = 1;
        ad.d("MicroMsg.ManualReq", "summerstatus[%d] clientUpgrade[%d]", new Object[] { Integer.valueOf(k), Integer.valueOf(i) });
        if ((10002 == com.tencent.mm.platformtools.ac.iON) && (com.tencent.mm.platformtools.ac.iOO > 0))
        {
          com.tencent.mm.platformtools.ac.iOO = 0;
          ac.ak("", "", 0);
        }
        setRsaInfo(ac.fgx());
        localObject1 = this.FnP.GRO;
        ((bxs)localObject1).setBaseRequest(l.a(this));
        ((bxs)localObject1).uEK = com.tencent.mm.compatible.deviceinfo.q.cH(true);
        ((bxs)localObject1).FzG = b.wtJ.LY(i);
        ((bxs)localObject1).FzH = 0;
        ((bxs)localObject1).FzI = a.aiO();
        ((bxs)localObject1).jdf = bt.jj(aj.getContext());
        ((bxs)localObject1).nDs = d.DEVICE_NAME;
        ((bxs)localObject1).FzJ = cc.fsJ();
        ((bxs)localObject1).qei = com.tencent.mm.sdk.platformtools.ac.fks();
        ((bxs)localObject1).qeh = bt.flM();
        ((bxs)localObject1).FqH = com.tencent.mm.sdk.platformtools.j.cSc;
        if ((10012 == com.tencent.mm.platformtools.ac.iON) && (com.tencent.mm.platformtools.ac.iOO > 0)) {
          ((bxs)localObject1).FqH = com.tencent.mm.platformtools.ac.iOO;
        }
        ((bxs)localObject1).gsN = d.Fnd;
        ((bxs)localObject1).gsM = d.Fne;
        ((bxs)localObject1).GRJ = d.Fnf;
        ((bxs)localObject1).GdW = com.tencent.mm.compatible.deviceinfo.q.getSimCountryIso();
        g.ajD();
        localObject2 = (String)g.ajC().gBh.get(18);
        ad.d("MicroMsg.ManualReq", "summerauth ksid:%s authreq flag:%d", new Object[] { localObject2, Integer.valueOf(((bxs)localObject1).FzF.FBW) });
        ((bxs)localObject1).FzF.FBU.FEt = new SKBuiltinBuffer_t().setBuffer(bt.aRa((String)localObject2));
      }
      for (;;)
      {
        try
        {
          localObject2 = b.wtJ.duO();
          if (localObject2 == null) {
            continue;
          }
          i = localObject2.length;
          ad.d("MicroMsg.ManualReq", "[debug] ccd set on manual auth, len: %s", new Object[] { Integer.valueOf(i) });
          localObject3 = new eah();
          if ((2 == ((bxs)localObject1).GRM) || (1 == ((bxs)localObject1).GRM))
          {
            if (b.wtJ.ats("ie_login_id")) {
              b.wtJ.atr("ie_login_id");
            }
            ((eah)localObject3).HNj = new SKBuiltinBuffer_t().setBuffer(b.wtJ.att("ie_login_id"));
            if (((eah)localObject3).HNj == null) {
              continue;
            }
            i = ((eah)localObject3).HNj.getILen();
            ad.d("MicroMsg.ManualReq", "[debug] wcstf set on manual auth, len: %s", new Object[] { Integer.valueOf(i) });
            ((eah)localObject3).HNk = new SKBuiltinBuffer_t().setBuffer(b.wtJ.atw("ce_login_id"));
            if (((eah)localObject3).HNk == null) {
              continue;
            }
            i = ((eah)localObject3).HNk.getILen();
            ad.d("MicroMsg.ManualReq", "[debug] wcste set on manual auth, len: %s", new Object[] { Integer.valueOf(i) });
          }
          ((eah)localObject3).HNp = new SKBuiltinBuffer_t().setBuffer(b.wtJ.duR());
          if (((eah)localObject3).HNp == null) {
            continue;
          }
          i = ((eah)localObject3).HNp.getILen();
          ad.d("MicroMsg.ManualReq", "[debug] devtok on manual auth, len: %s", new Object[] { Integer.valueOf(i) });
          ((eah)localObject3).HNl = new SKBuiltinBuffer_t().setBuffer((byte[])localObject2);
          ((bxs)localObject1).FzL = new SKBuiltinBuffer_t().setBuffer(((eah)localObject3).toByteArray());
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
        localObject2 = this.FnP.GRN;
        ((bxu)localObject2).FDQ = new SKBuiltinBuffer_t().setBuffer(bt.flL());
        localObject3 = new afp();
        ((afp)localObject3).GdB = 713;
        localObject5 = new PByteArray();
        localObject4 = new PByteArray();
        k = MMProtocalJni.generateECKey(((afp)localObject3).GdB, (PByteArray)localObject5, (PByteArray)localObject4);
        localObject5 = ((PByteArray)localObject5).value;
        localObject4 = ((PByteArray)localObject4).value;
        cm((byte[])localObject4);
        m = ((afp)localObject3).GdB;
        if (localObject5 != null) {
          continue;
        }
        i = -1;
        if (localObject4 != null) {
          continue;
        }
        ad.d("MicroMsg.ManualReq", "summerecdh nid:%d ret:%d, pub len: %d, pri len:%d, pub:%s, pri:%s", new Object[] { Integer.valueOf(m), Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(j), bt.cB((byte[])localObject5), bt.cB((byte[])localObject4) });
        ((afp)localObject3).FzN = new SKBuiltinBuffer_t().setBuffer((byte[])localObject5);
        ((bxu)localObject2).FzR = ((afp)localObject3);
        ad.i("MicroMsg.ManualReq", "summerauth manual IMEI:%s SoftType:%s ClientSeqID:%s Signature:%s DeviceName:%s DeviceType:%s Language:%s TimeZone:%s chan[%d,%d,%d] DeviceBrand:%s DeviceModel:%s OSType:%s RealCountry:%s", new Object[] { ((bxs)localObject1).uEK, ((bxs)localObject1).FzG, ((bxs)localObject1).FzI, ((bxs)localObject1).jdf, ((bxs)localObject1).nDs, ((bxs)localObject1).FzJ, ((bxs)localObject1).qei, ((bxs)localObject1).qeh, Integer.valueOf(((bxs)localObject1).FqH), Integer.valueOf(com.tencent.mm.sdk.platformtools.j.cSc), Integer.valueOf(com.tencent.mm.sdk.platformtools.j.Icu), ((bxs)localObject1).gsN, ((bxs)localObject1).gsM, ((bxs)localObject1).GRJ, ((bxs)localObject1).GdW });
        try
        {
          localObject1 = this.FnP.toByteArray();
          AppMethodBeat.o(133095);
          return localObject1;
        }
        catch (IOException localIOException)
        {
          ad.e("MicroMsg.ManualReq", "summerauth toProtoBuf :%s", new Object[] { bt.n(localIOException) });
          AppMethodBeat.o(133095);
        }
        if (this.FnQ)
        {
          i = 3;
          break;
        }
        g.ajD();
        i = g.ajC().gBh.aaO(46);
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
        this.FnN = ((dqs)this.FnN.parseFrom(paramArrayOfByte));
        l.a(this, this.FnN.getBaseResponse());
        this.gva = 0;
        if ((this.FnN.getBaseResponse().Ret == 0) && ((this.FnN.HEF == null) || (this.FnN.HEF.qdX == 0) || (bt.cC(z.a(this.FnN.HEF.FyT)))))
        {
          ad.e("MicroMsg.MMAuth", "retcode 0 but invalid auth sect resp or invalid uin or invalid session");
          this.FnN.getBaseResponse().Ret = -1;
        }
        paramArrayOfByte = getErrMsg();
        ad.i("MicroMsg.MMAuth", "summerauthkick manual errmsg[%s]", new Object[] { paramArrayOfByte });
        a.wQ(paramArrayOfByte);
        int i = this.FnN.getBaseResponse().Ret;
        AppMethodBeat.o(133096);
        return i;
      }
      catch (IOException paramArrayOfByte)
      {
        ad.e("MicroMsg.MMAuth", "toProtoBuf :%s", new Object[] { bt.n(paramArrayOfByte) });
        this.FnN.getBaseResponse().Ret = -1;
        AppMethodBeat.o(133096);
      }
      return -1;
    }
  }
  
  public static abstract class h
    extends l.d
    implements l.b
  {
    public byte[] FnM;
    
    public final void cm(byte[] paramArrayOfByte)
    {
      if (paramArrayOfByte != null) {}
      for (;;)
      {
        this.FnM = paramArrayOfByte;
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
    public dqs FnN = new dqs();
    public byte[] FnR;
    private byte[] FnS;
    public String dul;
    public int gva = 0;
    private byte[] iEn;
    private byte[] iEo;
    
    public final byte[] ZE(int paramInt)
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
        arrayOfByte = this.FnS;
        break;
        arrayOfByte = this.iEn;
        break;
        arrayOfByte = this.iEo;
        break;
      }
    }
    
    public final void b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
    {
      this.FnS = paramArrayOfByte1;
      this.iEn = paramArrayOfByte2;
      this.iEo = paramArrayOfByte3;
      ad.i("MicroMsg.MMAuth", "summerauths setSession [%s] [%s], [%s]", new Object[] { bt.aRp(bt.cB(this.FnS)), bt.aRp(bt.cB(this.iEn)), bt.aRp(bt.cB(this.iEo)) });
    }
    
    public byte[] getAuthResponse()
    {
      try
      {
        byte[] arrayOfByte = this.FnN.toByteArray();
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