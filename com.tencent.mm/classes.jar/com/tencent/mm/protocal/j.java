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
import com.tencent.mm.protocal.protobuf.ado;
import com.tencent.mm.protocal.protobuf.bte;
import com.tencent.mm.protocal.protobuf.btf;
import com.tencent.mm.protocal.protobuf.btg;
import com.tencent.mm.protocal.protobuf.dlb;
import com.tencent.mm.protocal.protobuf.dun;
import com.tencent.mm.protocal.protobuf.gq;
import com.tencent.mm.protocal.protobuf.hd;
import com.tencent.mm.protocal.protobuf.hf;
import com.tencent.mm.protocal.protobuf.hg;
import com.tencent.mm.protocal.protobuf.iq;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bw;
import java.io.IOException;

public final class j
{
  public static final class a
    extends j.h
    implements l.b
  {
    public hf DIE;
    public String username;
    
    public a()
    {
      AppMethodBeat.i(133087);
      this.DIE = new hf();
      AppMethodBeat.o(133087);
    }
    
    public final int getFuncId()
    {
      if (f.DIl) {
        return 763;
      }
      return 702;
    }
    
    public final String getUri()
    {
      if (f.DIl) {
        return "/cgi-bin/micromsg-bin/secautoauth";
      }
      return "/cgi-bin/micromsg-bin/autoauth";
    }
    
    public final byte[] toProtoBuf()
    {
      int j = -1;
      AppMethodBeat.i(133088);
      a.ua("");
      int k = getSceneStatus();
      int i;
      Object localObject1;
      Object localObject2;
      if (k == 12)
      {
        i = 1;
        com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.AutoReq", "summerstatus[%d] clientUpgrade[%d]", new Object[] { Integer.valueOf(k), Integer.valueOf(i) });
        setRsaInfo(ac.eRt());
        if ((10002 == com.tencent.mm.platformtools.ab.ivG) && (com.tencent.mm.platformtools.ab.ivH > 0))
        {
          com.tencent.mm.platformtools.ab.ivH = 0;
          ac.ag("", "", 0);
        }
        localObject1 = this.DIE.DUv;
        ((hd)localObject1).setBaseRequest(l.a(this));
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.AutoReq", "summerauth autoauth toProtoBuf uin[%d]", new Object[] { Integer.valueOf(getUin()) });
        ((hd)localObject1).tCb = com.tencent.mm.compatible.deviceinfo.q.cF(true);
        ((hd)localObject1).DUm = b.vor.Kw(i);
        ((hd)localObject1).DUn = 0;
        ((hd)localObject1).DUo = a.agc();
        ((hd)localObject1).iJW = bs.iZ(ai.getContext());
        ((hd)localObject1).ncV = d.DEVICE_NAME;
        ((hd)localObject1).DUp = bw.fcC();
        ((hd)localObject1).pAD = com.tencent.mm.sdk.platformtools.ab.eUO();
        ((hd)localObject1).pAC = bs.eWc();
        ((hd)localObject1).DLC = i.cGY;
        g.agS();
        localObject2 = (String)g.agR().ghx.get(18);
        com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.AutoReq", "summerecdh ksid:%s, flag:%d", new Object[] { localObject2, Integer.valueOf(((hd)localObject1).DUl.DWA) });
        ((hd)localObject1).DUl.DWy.DYX = new SKBuiltinBuffer_t().setBuffer(bs.aLu((String)localObject2));
      }
      for (;;)
      {
        try
        {
          localObject2 = b.vor.dkC();
          if (localObject2 == null) {
            continue;
          }
          i = localObject2.length;
          com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.AutoReq", "[tomys] ccd set on auto auth, len: %s", new Object[] { Integer.valueOf(i) });
          localObject3 = new dun();
          ((dun)localObject3).Gco = new SKBuiltinBuffer_t().setBuffer((byte[])localObject2);
          ((dun)localObject3).Gcs = new SKBuiltinBuffer_t().setBuffer(b.vor.dkF());
          if (((dun)localObject3).Gcs == null) {
            continue;
          }
          i = ((dun)localObject3).Gcs.getILen();
          com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.AutoReq", "[debug] devtok on auto auth, len: %s", new Object[] { Integer.valueOf(i) });
          ((hd)localObject1).DUr = new SKBuiltinBuffer_t().setBuffer(((dun)localObject3).toByteArray());
        }
        catch (Throwable localThrowable)
        {
          Object localObject3;
          Object localObject5;
          Object localObject4;
          int m;
          com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("MicroMsg.AutoReq", localThrowable, "cc throws exception.", new Object[0]);
          continue;
          i = localObject5.length;
          continue;
          j = localObject4.length;
          continue;
        }
        localObject2 = this.DIE.DUu;
        localObject3 = new ado();
        ((ado)localObject3).Ewf = 713;
        localObject5 = new PByteArray();
        localObject4 = new PByteArray();
        k = MMProtocalJni.generateECKey(((ado)localObject3).Ewf, (PByteArray)localObject5, (PByteArray)localObject4);
        localObject5 = ((PByteArray)localObject5).value;
        localObject4 = ((PByteArray)localObject4).value;
        cf((byte[])localObject4);
        m = ((ado)localObject3).Ewf;
        if (localObject5 != null) {
          continue;
        }
        i = -1;
        if (localObject4 != null) {
          continue;
        }
        com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.AutoReq", "summerecdh nid:%d ret:%d, pub len: %d, pri len:%d, pub:%s, pri:%s", new Object[] { Integer.valueOf(m), Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(j), bs.cu((byte[])localObject5), bs.cu((byte[])localObject4) });
        ((ado)localObject3).DUt = new SKBuiltinBuffer_t().setBuffer((byte[])localObject5);
        ((hg)localObject2).DUx = ((ado)localObject3);
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.AutoReq", "summerauth auto IMEI:%s SoftType:%s ClientSeqID:%s Signature:%s DeviceName:%s DeviceType:%s Language:%s TimeZone:%s chan[%d,%d,%d]", new Object[] { ((hd)localObject1).tCb, ((hd)localObject1).DUm, ((hd)localObject1).DUo, ((hd)localObject1).iJW, ((hd)localObject1).ncV, ((hd)localObject1).DUp, ((hd)localObject1).pAD, ((hd)localObject1).pAC, Integer.valueOf(((hd)localObject1).DLC), Integer.valueOf(i.cGY), Integer.valueOf(i.GqG) });
        try
        {
          localObject1 = this.DIE.toByteArray();
          AppMethodBeat.o(133088);
          return localObject1;
        }
        catch (IOException localIOException)
        {
          com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.AutoReq", "summerauth toProtoBuf :%s", new Object[] { bs.m(localIOException) });
          AppMethodBeat.o(133088);
        }
        g.agS();
        i = g.agR().ghx.YF(46);
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
        this.DIG = ((dlb)this.DIG.parseFrom(paramArrayOfByte));
        l.a(this, this.DIG.getBaseResponse());
        this.gbq = 0;
        if ((this.DIG.getBaseResponse().Ret == 0) && ((this.DIG.FTR == null) || (this.DIG.FTR.pAs == 0) || (bs.cv(z.a(this.DIG.FTR.DTz)))))
        {
          com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.MMAuth", "retcode 0 but invalid auth sect resp or invalid uin or invalid session");
          this.DIG.getBaseResponse().Ret = -1;
        }
        paramArrayOfByte = getErrMsg();
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.MMAuth", "summerauthkick auto errmsg[%s]", new Object[] { paramArrayOfByte });
        a.ua(paramArrayOfByte);
        int i = this.DIG.getBaseResponse().Ret;
        AppMethodBeat.o(133089);
        return i;
      }
      catch (IOException paramArrayOfByte)
      {
        com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.MMAuth", "toProtoBuf :%s", new Object[] { bs.m(paramArrayOfByte) });
        this.DIG.getBaseResponse().Ret = -1;
        AppMethodBeat.o(133089);
      }
      return -1;
    }
  }
  
  public static final class c
    extends l.d
    implements l.b
  {
    public hf DIE;
    private byte[] DIF;
    public String username;
    
    public c()
    {
      AppMethodBeat.i(133090);
      this.DIE = new hf();
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
      a.ua("");
      int k = getSceneStatus();
      int i;
      Object localObject1;
      Object localObject2;
      ado localado;
      Object localObject4;
      Object localObject3;
      int m;
      if (k == 12)
      {
        i = 1;
        com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.MMAuth", "summerstatus[%d] clientUpgrade[%d]", new Object[] { Integer.valueOf(k), Integer.valueOf(i) });
        setRsaInfo(ac.eRt());
        if ((10002 == com.tencent.mm.platformtools.ab.ivG) && (com.tencent.mm.platformtools.ab.ivH > 0))
        {
          com.tencent.mm.platformtools.ab.ivH = 0;
          ac.ag("", "", 0);
        }
        localObject1 = this.DIE.DUv;
        ((hd)localObject1).setBaseRequest(l.a(this));
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.MMAuth", "summerauth autoauth toProtoBuf uin[%d]", new Object[] { Integer.valueOf(getUin()) });
        ((hd)localObject1).tCb = com.tencent.mm.compatible.deviceinfo.q.XQ();
        ((hd)localObject1).DUm = b.vor.Kw(i);
        ((hd)localObject1).DUn = 0;
        ((hd)localObject1).DUo = a.agc();
        ((hd)localObject1).iJW = bs.iZ(ai.getContext());
        ((hd)localObject1).ncV = d.DEVICE_NAME;
        ((hd)localObject1).DUp = bw.fcC();
        ((hd)localObject1).pAD = com.tencent.mm.sdk.platformtools.ab.eUO();
        ((hd)localObject1).pAC = bs.eWc();
        ((hd)localObject1).DLC = i.cGY;
        g.agS();
        localObject2 = (String)g.agR().ghx.get(18);
        com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.MMAuth", "summerecdh ksid:%s, flag:%d", new Object[] { localObject2, Integer.valueOf(((hd)localObject1).DUl.DWA) });
        ((hd)localObject1).DUl.DWy.DYX = new SKBuiltinBuffer_t().setBuffer(bs.aLu((String)localObject2));
        localObject2 = this.DIE.DUu;
        localado = new ado();
        localado.Ewf = 713;
        localObject4 = new PByteArray();
        localObject3 = new PByteArray();
        k = MMProtocalJni.generateECKey(localado.Ewf, (PByteArray)localObject4, (PByteArray)localObject3);
        localObject4 = ((PByteArray)localObject4).value;
        localObject3 = ((PByteArray)localObject3).value;
        this.DIF = ((byte[])localObject3);
        m = localado.Ewf;
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
        com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.MMAuth", "summerecdh nid:%d ret:%d, pub len: %d, pri len:%d, pub:%s, pri:%s", new Object[] { Integer.valueOf(m), Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(j), bs.cu((byte[])localObject4), bs.cu((byte[])localObject3) });
        localado.DUt = new SKBuiltinBuffer_t().setBuffer((byte[])localObject4);
        ((hg)localObject2).DUx = localado;
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.MMAuth", "summerauth auto IMEI:%s SoftType:%s ClientSeqID:%s Signature:%s DeviceName:%s DeviceType:%s Language:%s TimeZone:%s chan[%d,%d,%d]", new Object[] { ((hd)localObject1).tCb, ((hd)localObject1).DUm, ((hd)localObject1).DUo, ((hd)localObject1).iJW, ((hd)localObject1).ncV, ((hd)localObject1).DUp, ((hd)localObject1).pAD, ((hd)localObject1).pAC, Integer.valueOf(((hd)localObject1).DLC), Integer.valueOf(i.cGY), Integer.valueOf(i.GqG) });
        try
        {
          localObject1 = this.DIE.toByteArray();
          AppMethodBeat.o(133091);
          return localObject1;
        }
        catch (IOException localIOException)
        {
          com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.MMAuth", "summerauth toProtoBuf :%s", new Object[] { bs.m(localIOException) });
          AppMethodBeat.o(133091);
        }
        g.agS();
        i = g.agR().ghx.YF(46);
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
    
    public abstract int ayQ();
    
    public abstract com.tencent.mm.network.q da(int paramInt1, int paramInt2);
    
    public static final class a
    {
      public static j.e DIH;
    }
  }
  
  public static final class f
    extends j.h
    implements l.b
  {
    public btf DII;
    public boolean DIJ;
    
    public f()
    {
      AppMethodBeat.i(133094);
      this.DII = new btf();
      this.DIJ = false;
      AppMethodBeat.o(133094);
    }
    
    public final int getFuncId()
    {
      if (f.DIl) {
        return 252;
      }
      return 701;
    }
    
    public final String getUri()
    {
      if (f.DIl) {
        return "/cgi-bin/micromsg-bin/secmanualauth";
      }
      return "/cgi-bin/micromsg-bin/manualauth";
    }
    
    public final byte[] toProtoBuf()
    {
      int j = -1;
      AppMethodBeat.i(133095);
      a.ua("");
      int k = getSceneStatus();
      int i;
      Object localObject1;
      Object localObject2;
      if (k == 16)
      {
        i = 1;
        com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.ManualReq", "summerstatus[%d] clientUpgrade[%d]", new Object[] { Integer.valueOf(k), Integer.valueOf(i) });
        if ((10002 == com.tencent.mm.platformtools.ab.ivG) && (com.tencent.mm.platformtools.ab.ivH > 0))
        {
          com.tencent.mm.platformtools.ab.ivH = 0;
          ac.ag("", "", 0);
        }
        setRsaInfo(ac.eRt());
        localObject1 = this.DII.Fin;
        ((bte)localObject1).setBaseRequest(l.a(this));
        ((bte)localObject1).tCb = com.tencent.mm.compatible.deviceinfo.q.cF(true);
        ((bte)localObject1).DUm = b.vor.Kw(i);
        ((bte)localObject1).DUn = 0;
        ((bte)localObject1).DUo = a.agc();
        ((bte)localObject1).iJW = bs.iZ(ai.getContext());
        ((bte)localObject1).ncV = d.DEVICE_NAME;
        ((bte)localObject1).DUp = bw.fcC();
        ((bte)localObject1).pAD = com.tencent.mm.sdk.platformtools.ab.eUO();
        ((bte)localObject1).pAC = bs.eWc();
        ((bte)localObject1).DLC = i.cGY;
        if ((10012 == com.tencent.mm.platformtools.ab.ivG) && (com.tencent.mm.platformtools.ab.ivH > 0)) {
          ((bte)localObject1).DLC = com.tencent.mm.platformtools.ab.ivH;
        }
        ((bte)localObject1).fZr = d.DHW;
        ((bte)localObject1).fZq = d.DHX;
        ((bte)localObject1).Fii = d.DHY;
        ((bte)localObject1).Ews = com.tencent.mm.compatible.deviceinfo.q.getSimCountryIso();
        g.agS();
        localObject2 = (String)g.agR().ghx.get(18);
        com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.ManualReq", "summerauth ksid:%s authreq flag:%d", new Object[] { localObject2, Integer.valueOf(((bte)localObject1).DUl.DWA) });
        ((bte)localObject1).DUl.DWy.DYX = new SKBuiltinBuffer_t().setBuffer(bs.aLu((String)localObject2));
      }
      for (;;)
      {
        try
        {
          localObject2 = b.vor.dkC();
          if (localObject2 == null) {
            continue;
          }
          i = localObject2.length;
          com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.ManualReq", "[debug] ccd set on manual auth, len: %s", new Object[] { Integer.valueOf(i) });
          localObject3 = new dun();
          if ((2 == ((bte)localObject1).Fil) || (1 == ((bte)localObject1).Fil))
          {
            if (b.vor.aos("ie_login_id")) {
              b.vor.aor("ie_login_id");
            }
            ((dun)localObject3).Gcm = new SKBuiltinBuffer_t().setBuffer(b.vor.aot("ie_login_id"));
            if (((dun)localObject3).Gcm == null) {
              continue;
            }
            i = ((dun)localObject3).Gcm.getILen();
            com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.ManualReq", "[debug] wcstf set on manual auth, len: %s", new Object[] { Integer.valueOf(i) });
            ((dun)localObject3).Gcn = new SKBuiltinBuffer_t().setBuffer(b.vor.aow("ce_login_id"));
            if (((dun)localObject3).Gcn == null) {
              continue;
            }
            i = ((dun)localObject3).Gcn.getILen();
            com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.ManualReq", "[debug] wcste set on manual auth, len: %s", new Object[] { Integer.valueOf(i) });
          }
          ((dun)localObject3).Gcs = new SKBuiltinBuffer_t().setBuffer(b.vor.dkF());
          if (((dun)localObject3).Gcs == null) {
            continue;
          }
          i = ((dun)localObject3).Gcs.getILen();
          com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.ManualReq", "[debug] devtok on manual auth, len: %s", new Object[] { Integer.valueOf(i) });
          ((dun)localObject3).Gco = new SKBuiltinBuffer_t().setBuffer((byte[])localObject2);
          ((bte)localObject1).DUr = new SKBuiltinBuffer_t().setBuffer(((dun)localObject3).toByteArray());
        }
        catch (Throwable localThrowable)
        {
          Object localObject3;
          Object localObject5;
          Object localObject4;
          int m;
          com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("MicroMsg.ManualReq", localThrowable, "cc throws exception.", new Object[0]);
          continue;
          i = localObject5.length;
          continue;
          j = localObject4.length;
          continue;
        }
        localObject2 = this.DII.Fim;
        ((btg)localObject2).DYu = new SKBuiltinBuffer_t().setBuffer(bs.eWb());
        localObject3 = new ado();
        ((ado)localObject3).Ewf = 713;
        localObject5 = new PByteArray();
        localObject4 = new PByteArray();
        k = MMProtocalJni.generateECKey(((ado)localObject3).Ewf, (PByteArray)localObject5, (PByteArray)localObject4);
        localObject5 = ((PByteArray)localObject5).value;
        localObject4 = ((PByteArray)localObject4).value;
        cf((byte[])localObject4);
        m = ((ado)localObject3).Ewf;
        if (localObject5 != null) {
          continue;
        }
        i = -1;
        if (localObject4 != null) {
          continue;
        }
        com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.ManualReq", "summerecdh nid:%d ret:%d, pub len: %d, pri len:%d, pub:%s, pri:%s", new Object[] { Integer.valueOf(m), Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(j), bs.cu((byte[])localObject5), bs.cu((byte[])localObject4) });
        ((ado)localObject3).DUt = new SKBuiltinBuffer_t().setBuffer((byte[])localObject5);
        ((btg)localObject2).DUx = ((ado)localObject3);
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.ManualReq", "summerauth manual IMEI:%s SoftType:%s ClientSeqID:%s Signature:%s DeviceName:%s DeviceType:%s Language:%s TimeZone:%s chan[%d,%d,%d] DeviceBrand:%s DeviceModel:%s OSType:%s RealCountry:%s", new Object[] { ((bte)localObject1).tCb, ((bte)localObject1).DUm, ((bte)localObject1).DUo, ((bte)localObject1).iJW, ((bte)localObject1).ncV, ((bte)localObject1).DUp, ((bte)localObject1).pAD, ((bte)localObject1).pAC, Integer.valueOf(((bte)localObject1).DLC), Integer.valueOf(i.cGY), Integer.valueOf(i.GqG), ((bte)localObject1).fZr, ((bte)localObject1).fZq, ((bte)localObject1).Fii, ((bte)localObject1).Ews });
        try
        {
          localObject1 = this.DII.toByteArray();
          AppMethodBeat.o(133095);
          return localObject1;
        }
        catch (IOException localIOException)
        {
          com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.ManualReq", "summerauth toProtoBuf :%s", new Object[] { bs.m(localIOException) });
          AppMethodBeat.o(133095);
        }
        if (this.DIJ)
        {
          i = 3;
          break;
        }
        g.agS();
        i = g.agR().ghx.YF(46);
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
        this.DIG = ((dlb)this.DIG.parseFrom(paramArrayOfByte));
        l.a(this, this.DIG.getBaseResponse());
        this.gbq = 0;
        if ((this.DIG.getBaseResponse().Ret == 0) && ((this.DIG.FTR == null) || (this.DIG.FTR.pAs == 0) || (bs.cv(z.a(this.DIG.FTR.DTz)))))
        {
          com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.MMAuth", "retcode 0 but invalid auth sect resp or invalid uin or invalid session");
          this.DIG.getBaseResponse().Ret = -1;
        }
        paramArrayOfByte = getErrMsg();
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.MMAuth", "summerauthkick manual errmsg[%s]", new Object[] { paramArrayOfByte });
        a.ua(paramArrayOfByte);
        int i = this.DIG.getBaseResponse().Ret;
        AppMethodBeat.o(133096);
        return i;
      }
      catch (IOException paramArrayOfByte)
      {
        com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.MMAuth", "toProtoBuf :%s", new Object[] { bs.m(paramArrayOfByte) });
        this.DIG.getBaseResponse().Ret = -1;
        AppMethodBeat.o(133096);
      }
      return -1;
    }
  }
  
  public static abstract class h
    extends l.d
    implements l.b
  {
    public byte[] DIF;
    
    public final void cf(byte[] paramArrayOfByte)
    {
      if (paramArrayOfByte != null) {}
      for (;;)
      {
        this.DIF = paramArrayOfByte;
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
    public dlb DIG = new dlb();
    public byte[] DIK;
    private byte[] DIL;
    public String diA;
    public int gbq = 0;
    private byte[] ikW;
    private byte[] ikX;
    
    public final byte[] XI(int paramInt)
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
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.MMAuth", "summerauths getSession seesionKeyType[%s] [%s]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
        return arrayOfByte;
        arrayOfByte = this.DIL;
        break;
        arrayOfByte = this.ikW;
        break;
        arrayOfByte = this.ikX;
        break;
      }
    }
    
    public final void b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
    {
      this.DIL = paramArrayOfByte1;
      this.ikW = paramArrayOfByte2;
      this.ikX = paramArrayOfByte3;
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.MMAuth", "summerauths setSession [%s] [%s], [%s]", new Object[] { bs.aLJ(bs.cu(this.DIL)), bs.aLJ(bs.cu(this.ikW)), bs.aLJ(bs.cu(this.ikX)) });
    }
    
    public byte[] getAuthResponse()
    {
      try
      {
        byte[] arrayOfByte = this.DIG.toByteArray();
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