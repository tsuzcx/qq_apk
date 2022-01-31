package com.tencent.mm.protocal;

import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.normsg.a.b;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.c.avp;
import com.tencent.mm.protocal.c.avq;
import com.tencent.mm.protocal.c.avr;
import com.tencent.mm.protocal.c.blm;
import com.tencent.mm.protocal.c.bly;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.bzo;
import com.tencent.mm.protocal.c.eq;
import com.tencent.mm.protocal.c.ez;
import com.tencent.mm.protocal.c.fb;
import com.tencent.mm.protocal.c.fc;
import com.tencent.mm.protocal.c.ga;
import com.tencent.mm.protocal.c.gd;
import com.tencent.mm.protocal.c.uq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bs;
import java.io.IOException;

public final class i
{
  public static final class a
    extends i.f
    implements k.b
  {
    public fb spu = new fb();
    public String username;
    
    public final byte[] HG()
    {
      int j = -1;
      a.gb("");
      int k = this.spI;
      int i;
      Object localObject1;
      Object localObject2;
      if (k == 12)
      {
        i = 1;
        com.tencent.mm.sdk.platformtools.y.d("MicroMsg.AutoReq", "summerstatus[%d] clientUpgrade[%d]", new Object[] { Integer.valueOf(k), Integer.valueOf(i) });
        this.spM = y.cph();
        if ((10002 == com.tencent.mm.platformtools.ae.eSP) && (com.tencent.mm.platformtools.ae.eSQ > 0))
        {
          com.tencent.mm.platformtools.ae.eSQ = 0;
          y.K("", "", 0);
        }
        localObject1 = this.spu.syM;
        ((blm)localObject1).tEX = k.a(this);
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.AutoReq", "summerauth autoauth toProtoBuf[%d]", new Object[] { Integer.valueOf(this.spE) });
        ((ez)localObject1).ljr = com.tencent.mm.compatible.e.q.zf();
        ((ez)localObject1).syF = b.mGK.vr(i);
        ((ez)localObject1).syG = 0;
        ((ez)localObject1).syH = a.Df();
        ((ez)localObject1).ffk = bk.fU(com.tencent.mm.sdk.platformtools.ae.getContext());
        ((ez)localObject1).hQc = d.DEVICE_NAME;
        ((ez)localObject1).syI = bs.cwc();
        ((ez)localObject1).jxi = x.cqJ();
        ((ez)localObject1).jxh = bk.crV();
        ((ez)localObject1).sss = com.tencent.mm.sdk.platformtools.e.bvj;
        g.DQ();
        localObject2 = (String)g.DP().dKo.get(18);
        com.tencent.mm.sdk.platformtools.y.d("MicroMsg.AutoReq", "summerecdh ksid:%s, flag:%d", new Object[] { localObject2, Integer.valueOf(((ez)localObject1).syE.sAf) });
        ((ez)localObject1).syE.sAd.sBT = new bmk().bs(bk.ZM((String)localObject2));
      }
      for (;;)
      {
        try
        {
          localObject2 = b.mGK.boP();
          if (localObject2 == null) {
            continue;
          }
          i = localObject2.length;
          com.tencent.mm.sdk.platformtools.y.d("MicroMsg.AutoReq", "[tomys] ccd set on auto auth, len: %s", new Object[] { Integer.valueOf(i) });
          ((ez)localObject1).tpt = new bmk().bs((byte[])localObject2);
        }
        catch (Throwable localThrowable)
        {
          uq localuq;
          Object localObject4;
          Object localObject3;
          int m;
          com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.AutoReq", localThrowable, "cc throws exception.", new Object[0]);
          continue;
          i = localObject4.length;
          continue;
          j = localObject3.length;
          continue;
        }
        localObject2 = this.spu.syL;
        localuq = new uq();
        localuq.sRn = 713;
        localObject4 = new PByteArray();
        localObject3 = new PByteArray();
        k = MMProtocalJni.generateECKey(localuq.sRn, (PByteArray)localObject4, (PByteArray)localObject3);
        localObject4 = ((PByteArray)localObject4).value;
        localObject3 = ((PByteArray)localObject3).value;
        bm((byte[])localObject3);
        m = localuq.sRn;
        if (localObject4 != null) {
          continue;
        }
        i = -1;
        if (localObject3 != null) {
          continue;
        }
        com.tencent.mm.sdk.platformtools.y.d("MicroMsg.AutoReq", "summerecdh nid:%d ret:%d, pub len: %d, pri len:%d, pub:%s, pri:%s", new Object[] { Integer.valueOf(m), Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(j), bk.bD((byte[])localObject4), bk.bD((byte[])localObject3) });
        localuq.syK = new bmk().bs((byte[])localObject4);
        ((fc)localObject2).syO = localuq;
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.AutoReq", "summerauth auto IMEI:%s SoftType:%s ClientSeqID:%s Signature:%s DeviceName:%s DeviceType:%s Language:%s TimeZone:%s chan[%d,%d,%d]", new Object[] { ((ez)localObject1).ljr, ((ez)localObject1).syF, ((ez)localObject1).syH, ((ez)localObject1).ffk, ((ez)localObject1).hQc, ((ez)localObject1).syI, ((ez)localObject1).jxi, ((ez)localObject1).jxh, Integer.valueOf(((ez)localObject1).sss), Integer.valueOf(com.tencent.mm.sdk.platformtools.e.bvj), Integer.valueOf(com.tencent.mm.sdk.platformtools.e.ueh) });
        try
        {
          localObject1 = this.spu.toByteArray();
          return localObject1;
        }
        catch (IOException localIOException)
        {
          com.tencent.mm.sdk.platformtools.y.e("MicroMsg.AutoReq", "summerauth toProtoBuf :%s", new Object[] { bk.j(localIOException) });
        }
        g.DQ();
        i = g.DP().dKo.Fl(46);
        break;
        i = -1;
      }
      return null;
    }
    
    public final int HH()
    {
      return 702;
    }
    
    public final String getUri()
    {
      return "/cgi-bin/micromsg-bin/autoauth";
    }
  }
  
  public static final class b
    extends i.g
    implements k.c
  {
    public final int A(byte[] paramArrayOfByte)
    {
      try
      {
        this.spz = ((bzo)this.spz.aH(paramArrayOfByte));
        k.a(this, this.spz.tFx);
        this.dDD = 0;
        if ((this.spz.tFx.sze == 0) && ((this.spz.tPv == null) || (this.spz.tPv.jwX == 0) || (bk.bE(aa.a(this.spz.tPv.syh)))))
        {
          com.tencent.mm.sdk.platformtools.y.e("MicroMsg.MMAuth", "retcode 0 but invalid auth sect resp or invalid uin or invalid session");
          this.spz.tFx.sze = -1;
        }
        paramArrayOfByte = this.spP;
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MMAuth", "summerauthkick auto errmsg[%s]", new Object[] { paramArrayOfByte });
        a.gb(paramArrayOfByte);
        return this.spz.tFx.sze;
      }
      catch (IOException paramArrayOfByte)
      {
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.MMAuth", "toProtoBuf :%s", new Object[] { bk.j(paramArrayOfByte) });
        this.spz.tFx.sze = -1;
      }
      return -1;
    }
  }
  
  public static abstract interface c
  {
    public abstract int HC();
    
    public abstract void a(i.f paramf, i.g paramg, int paramInt1, int paramInt2, String paramString);
    
    public abstract com.tencent.mm.network.q bh(int paramInt1, int paramInt2);
    
    public static final class a
    {
      public static i.c spv;
    }
  }
  
  public static final class d
    extends i.f
    implements k.b
  {
    public avq spw = new avq();
    public boolean spx = false;
    
    public final byte[] HG()
    {
      int j = -1;
      a.gb("");
      int k = this.spI;
      int i;
      Object localObject1;
      Object localObject2;
      if (k == 16)
      {
        i = 1;
        com.tencent.mm.sdk.platformtools.y.d("MicroMsg.ManualReq", "summerstatus[%d] clientUpgrade[%d]", new Object[] { Integer.valueOf(k), Integer.valueOf(i) });
        if ((10002 == com.tencent.mm.platformtools.ae.eSP) && (com.tencent.mm.platformtools.ae.eSQ > 0))
        {
          com.tencent.mm.platformtools.ae.eSQ = 0;
          y.K("", "", 0);
        }
        this.spM = y.cph();
        localObject1 = this.spw.trk;
        ((blm)localObject1).tEX = k.a(this);
        ((avp)localObject1).ljr = com.tencent.mm.compatible.e.q.zf();
        ((avp)localObject1).syF = b.mGK.vr(i);
        ((avp)localObject1).syG = 0;
        ((avp)localObject1).syH = a.Df();
        ((avp)localObject1).ffk = bk.fU(com.tencent.mm.sdk.platformtools.ae.getContext());
        ((avp)localObject1).hQc = d.DEVICE_NAME;
        ((avp)localObject1).syI = bs.cwc();
        ((avp)localObject1).jxi = x.cqJ();
        ((avp)localObject1).jxh = bk.crV();
        ((avp)localObject1).sss = com.tencent.mm.sdk.platformtools.e.bvj;
        if ((10012 == com.tencent.mm.platformtools.ae.eSP) && (com.tencent.mm.platformtools.ae.eSQ > 0)) {
          ((avp)localObject1).sss = com.tencent.mm.platformtools.ae.eSQ;
        }
        ((avp)localObject1).sEd = d.soU;
        ((avp)localObject1).sEc = d.soV;
        ((avp)localObject1).trf = d.soW;
        ((avp)localObject1).sRp = com.tencent.mm.compatible.e.q.getSimCountryIso();
        g.DQ();
        localObject2 = (String)g.DP().dKo.get(18);
        com.tencent.mm.sdk.platformtools.y.d("MicroMsg.ManualReq", "summerauth ksid:%s authreq flag:%d", new Object[] { localObject2, Integer.valueOf(((avp)localObject1).syE.sAf) });
        ((avp)localObject1).syE.sAd.sBT = new bmk().bs(bk.ZM((String)localObject2));
      }
      for (;;)
      {
        try
        {
          localObject2 = b.mGK.boP();
          if (localObject2 == null) {
            continue;
          }
          i = localObject2.length;
          com.tencent.mm.sdk.platformtools.y.d("MicroMsg.ManualReq", "[tomys] ccd set on manual auth, len: %s", new Object[] { Integer.valueOf(i) });
          ((avp)localObject1).tpt = new bmk().bs((byte[])localObject2);
        }
        catch (Throwable localThrowable)
        {
          uq localuq;
          Object localObject4;
          Object localObject3;
          int m;
          com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.ManualReq", localThrowable, "cc throws exception.", new Object[0]);
          continue;
          i = localObject4.length;
          continue;
          j = localObject3.length;
          continue;
        }
        localObject2 = this.spw.trj;
        ((avr)localObject2).sBt = new bmk().bs(bk.crT());
        localuq = new uq();
        localuq.sRn = 713;
        localObject4 = new PByteArray();
        localObject3 = new PByteArray();
        k = MMProtocalJni.generateECKey(localuq.sRn, (PByteArray)localObject4, (PByteArray)localObject3);
        localObject4 = ((PByteArray)localObject4).value;
        localObject3 = ((PByteArray)localObject3).value;
        bm((byte[])localObject3);
        m = localuq.sRn;
        if (localObject4 != null) {
          continue;
        }
        i = -1;
        if (localObject3 != null) {
          continue;
        }
        com.tencent.mm.sdk.platformtools.y.d("MicroMsg.ManualReq", "summerecdh nid:%d ret:%d, pub len: %d, pri len:%d, pub:%s, pri:%s", new Object[] { Integer.valueOf(m), Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(j), bk.bD((byte[])localObject4), bk.bD((byte[])localObject3) });
        localuq.syK = new bmk().bs((byte[])localObject4);
        ((avr)localObject2).syO = localuq;
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ManualReq", "summerauth manual IMEI:%s SoftType:%s ClientSeqID:%s Signature:%s DeviceName:%s DeviceType:%s Language:%s TimeZone:%s chan[%d,%d,%d] DeviceBrand:%s DeviceModel:%s OSType:%s RealCountry:%s", new Object[] { ((avp)localObject1).ljr, ((avp)localObject1).syF, ((avp)localObject1).syH, ((avp)localObject1).ffk, ((avp)localObject1).hQc, ((avp)localObject1).syI, ((avp)localObject1).jxi, ((avp)localObject1).jxh, Integer.valueOf(((avp)localObject1).sss), Integer.valueOf(com.tencent.mm.sdk.platformtools.e.bvj), Integer.valueOf(com.tencent.mm.sdk.platformtools.e.ueh), ((avp)localObject1).sEd, ((avp)localObject1).sEc, ((avp)localObject1).trf, ((avp)localObject1).sRp });
        try
        {
          localObject1 = this.spw.toByteArray();
          return localObject1;
        }
        catch (IOException localIOException)
        {
          com.tencent.mm.sdk.platformtools.y.e("MicroMsg.ManualReq", "summerauth toProtoBuf :%s", new Object[] { bk.j(localIOException) });
        }
        if (this.spx)
        {
          i = 3;
          break;
        }
        g.DQ();
        i = g.DP().dKo.Fl(46);
        break;
        i = -1;
      }
      return null;
    }
    
    public final int HH()
    {
      return 701;
    }
    
    public final String getUri()
    {
      return "/cgi-bin/micromsg-bin/manualauth";
    }
  }
  
  public static final class e
    extends i.g
    implements k.c
  {
    public final int A(byte[] paramArrayOfByte)
    {
      try
      {
        this.spz = ((bzo)this.spz.aH(paramArrayOfByte));
        k.a(this, this.spz.tFx);
        this.dDD = 0;
        if ((this.spz.tFx.sze == 0) && ((this.spz.tPv == null) || (this.spz.tPv.jwX == 0) || (bk.bE(aa.a(this.spz.tPv.syh)))))
        {
          com.tencent.mm.sdk.platformtools.y.e("MicroMsg.MMAuth", "retcode 0 but invalid auth sect resp or invalid uin or invalid session");
          this.spz.tFx.sze = -1;
        }
        paramArrayOfByte = this.spP;
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MMAuth", "summerauthkick manual errmsg[%s]", new Object[] { paramArrayOfByte });
        a.gb(paramArrayOfByte);
        return this.spz.tFx.sze;
      }
      catch (IOException paramArrayOfByte)
      {
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.MMAuth", "toProtoBuf :%s", new Object[] { bk.j(paramArrayOfByte) });
        this.spz.tFx.sze = -1;
      }
      return -1;
    }
  }
  
  public static abstract class f
    extends k.d
    implements k.b
  {
    public byte[] spy;
    
    public final void bm(byte[] paramArrayOfByte)
    {
      if (paramArrayOfByte != null) {}
      for (;;)
      {
        this.spy = paramArrayOfByte;
        return;
        paramArrayOfByte = new byte[0];
      }
    }
    
    public abstract String getUri();
  }
  
  public static abstract class g
    extends k.e
    implements k.c
  {
    public int dDD = 0;
    public byte[] eNt;
    public String eNw;
    public byte[] spA;
    public bzo spz = new bzo();
    
    public final void bn(byte[] paramArrayOfByte)
    {
      if (paramArrayOfByte != null) {}
      for (;;)
      {
        this.eNt = paramArrayOfByte;
        return;
        paramArrayOfByte = new byte[0];
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.i
 * JD-Core Version:    0.7.0.1
 */