package com.tencent.mm.wallet_core.tenpay.model;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.k;
import com.tencent.mm.model.q;
import com.tencent.mm.network.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.wallet.d;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.bxg;
import com.tencent.mm.protocal.c.bxh;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.wallet_core.c.a;
import com.tencent.mm.wallet_core.c.o;
import com.tencent.mm.wallet_core.c.t;
import com.tencent.mm.wallet_core.c.z;
import com.tenpay.android.wechat.TenpayUtil;
import java.util.Vector;
import org.json.JSONObject;

public abstract class j
  extends o
{
  public static Vector<String> wBt = new Vector();
  protected boolean wBs = false;
  
  static
  {
    int i = 0;
    while (i < d.sof.length)
    {
      wBt.add(d.sof[i]);
      i += 1;
    }
  }
  
  private int f(com.tencent.mm.ah.b paramb)
  {
    Object localObject1 = (bxg)paramb.ecE.ecN;
    if (((bxg)localObject1).tlr != null) {
      new String(((bxg)localObject1).tlr.tFM.oY);
    }
    if (((bxg)localObject1).tzn != null) {
      new String(((bxg)localObject1).tzn.tFM.oY);
    }
    z.cMJ();
    if (this.wBs)
    {
      Object localObject2 = (bxh)paramb.ecF.ecN;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new bxh();
      }
      localObject2 = "".getBytes();
      ((bxh)localObject1).tls = new bmk().bs((byte[])localObject2);
      ((bxh)localObject1).tlv = bUs();
      ((bxh)localObject1).tlt = 0;
      try
      {
        localObject2 = new JSONObject(null);
        ((bxh)localObject1).tzo = ((JSONObject)localObject2).optInt("TenpayErrType");
        ((bxh)localObject1).tzp = ((JSONObject)localObject2).optString("TenpayErrMsg");
        a(1, 0, 0, "", paramb, null);
        return 1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.NetSenceTenPayBase", localException, "", new Object[0]);
        }
      }
    }
    return -1;
  }
  
  public int HH()
  {
    return 385;
  }
  
  public void L(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1 = this.dmK;
    Object localObject2;
    boolean bool;
    if (localObject1 == null)
    {
      localObject1 = new b.a();
      ((b.a)localObject1).ecH = new bxg();
      ((b.a)localObject1).ecI = new bxh();
      localObject2 = getUri();
      int i = HH();
      ((b.a)localObject1).uri = ((String)localObject2);
      ((b.a)localObject1).ecG = i;
      ((b.a)localObject1).ecJ = 185;
      ((b.a)localObject1).ecK = 1000000185;
      localObject1 = ((b.a)localObject1).Kt();
      if (!cMP())
      {
        bool = true;
        ((k)localObject1).ecZ = bool;
      }
    }
    for (;;)
    {
      localObject2 = (bxg)((com.tencent.mm.ah.b)localObject1).ecE.ecN;
      if (paramBoolean1) {
        ((bxg)localObject2).tlp = aEC();
      }
      if (paramBoolean2) {
        ((bxg)localObject2).tlq = 1;
      }
      this.dmK = ((com.tencent.mm.ah.b)localObject1);
      return;
      bool = false;
      break;
    }
  }
  
  public final String Qm(String paramString)
  {
    return TenpayUtil.signWith3Des(paramString);
  }
  
  public int a(e parame, f paramf)
  {
    this.dmL = paramf;
    String str1 = this.dmK.uri;
    if (wBt.contains(str1))
    {
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.NetSenceTenPayBase", "black cgi bye bye %s", new Object[] { str1 });
      if (this.wBs)
      {
        int i = f(this.dmK);
        if (i != -1) {
          return i;
        }
      }
    }
    else
    {
      a.cMr();
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.NetSenceTenPayBase", "cert try get errormsg %s", new Object[] { Integer.valueOf(a.getLastError()) });
      long l = System.currentTimeMillis();
      a.cMr();
      a.init(ae.getContext());
      bxg localbxg = (bxg)this.dmK.ecE.ecN;
      str1 = "";
      String str2 = "";
      if (localbxg.tlr != null) {
        str1 = new String(localbxg.tlr.tFM.oY);
      }
      if (localbxg.tzn != null) {
        str2 = new String(localbxg.tzn.tFM.oY);
      }
      str1 = new String((str1 + "&&" + str2).getBytes());
      com.tencent.mm.wallet_core.c.y.cMH();
      str2 = com.tencent.mm.wallet_core.c.y.cMG();
      a.cMr();
      if (a.isCertExist(str2))
      {
        h.nFQ.a(414L, 20L, 1L, true);
        a.cMr();
        String str3 = a.genUserSig(str2, str1);
        h.nFQ.a(414L, 21L, System.currentTimeMillis() - l, true);
        com.tencent.mm.sdk.platformtools.y.v("MicroMsg.NetSenceTenPayBase", "sign ret src:%s sign:%s", new Object[] { str1, str3 });
        localbxg.sign = str3;
        localbxg.tNl = str2;
      }
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.NetSenceTenPayBase", "sign cost time %s cn %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), str2 });
        break;
        a.cMr();
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.NetSenceTenPayBase", "cert not exist cn %s %s", new Object[] { str2, Integer.valueOf(a.getLastError()) });
      }
    }
    if (q.Gw())
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.NetSenceTenPayBase", "hy: serious error: is payupay");
      paramf.onSceneEnd(1000, -100868, "Pay Method Err", this);
      return 1;
    }
    return a(parame, this.dmK, this);
  }
  
  public final void a(com.tencent.mm.ah.b paramb, bmk parambmk)
  {
    ((bxg)paramb.ecE.ecN).tlr = parambmk;
  }
  
  public abstract int aEC();
  
  public final void b(com.tencent.mm.ah.b paramb, bmk parambmk)
  {
    ((bxg)paramb.ecE.ecN).tzn = parambmk;
  }
  
  public int bUs()
  {
    return aEC();
  }
  
  public boolean cMP()
  {
    return true;
  }
  
  public final void cMY()
  {
    this.wBs = true;
  }
  
  public final t e(com.tencent.mm.ah.b paramb)
  {
    paramb = (bxh)paramb.ecF.ecN;
    t localt = new t();
    localt.tlv = paramb.tlv;
    localt.tlu = paramb.tlu;
    localt.tlt = paramb.tlt;
    localt.tls = paramb.tls;
    localt.jxm = paramb.tzp;
    localt.wAI = paramb.tzo;
    return localt;
  }
  
  public int getType()
  {
    return 385;
  }
  
  public String getUri()
  {
    return "/cgi-bin/micromsg-bin/tenpay";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.wallet_core.tenpay.model.j
 * JD-Core Version:    0.7.0.1
 */