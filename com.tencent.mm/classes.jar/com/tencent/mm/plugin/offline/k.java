package com.tencent.mm.plugin.offline;

import android.os.Looper;
import com.tencent.mm.cf.h.d;
import com.tencent.mm.h.a.tn;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.bx;
import com.tencent.mm.model.bx.a;
import com.tencent.mm.plugin.offline.a.s;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.z;
import java.util.HashMap;
import java.util.Map;

public class k
  implements ar
{
  private static Map<String, String> dHb;
  private static HashMap<Integer, h.d> dgp;
  public static int mKA;
  public static boolean mKz = false;
  private com.tencent.mm.vending.b.b fBp;
  private bx.a iGD = new k.4(this);
  private ah mHandler = new ah(Looper.getMainLooper());
  private com.tencent.mm.sdk.b.c<tn> mKB = new com.tencent.mm.sdk.b.c() {};
  private m mKC;
  private s mKt = null;
  private e mKu = null;
  private i mKv = null;
  private com.tencent.mm.plugin.offline.b.a mKw = null;
  private com.tencent.mm.plugin.offline.ui.d mKx = new com.tencent.mm.plugin.offline.ui.d();
  public f mKy = new f();
  
  static
  {
    mKA = 10;
    dHb = new HashMap();
    dgp = new HashMap();
    com.tencent.mm.wallet_core.a.i("OfflineBindCardRegProcess", d.class);
    com.tencent.mm.wallet_core.a.i("OfflineBindCardProcess", c.class);
    dgp.put(Integer.valueOf("OFFLINE_ORDER_STATUS".hashCode()), new h.d()
    {
      public final String[] rK()
      {
        return com.tencent.mm.plugin.offline.b.a.dXp;
      }
    });
  }
  
  public static void ax(int paramInt, String paramString)
  {
    if (paramString != null)
    {
      g.DQ();
      g.DP().Dz().o(paramInt, paramString);
      g.DQ();
      g.DP().Dz().mC(true);
    }
  }
  
  public static k bpX()
  {
    return (k)com.tencent.mm.model.p.B(k.class);
  }
  
  public static s bpY()
  {
    g.DN().CX();
    if (bpX().mKt == null) {
      bpX().mKt = new s();
    }
    return bpX().mKt;
  }
  
  public static e bpZ()
  {
    g.DN().CX();
    if (bpX().mKu == null) {
      bpX().mKu = new e();
    }
    return bpX().mKu;
  }
  
  public static i bqa()
  {
    g.DN().CX();
    if (bpX().mKv == null) {
      bpX().mKv = new i();
    }
    return bpX().mKv;
  }
  
  public static com.tencent.mm.plugin.offline.b.a bqb()
  {
    if (!g.DK()) {
      throw new com.tencent.mm.model.b();
    }
    if (bpX().mKw == null)
    {
      k localk = bpX();
      g.DQ();
      localk.mKw = new com.tencent.mm.plugin.offline.b.a(g.DP().dKu);
    }
    return bpX().mKw;
  }
  
  public static String vA(int paramInt)
  {
    g.DQ();
    return (String)g.DP().Dz().get(paramInt, null);
  }
  
  public final void bh(boolean paramBoolean)
  {
    this.fBp = ((com.tencent.mm.plugin.auth.a.b)g.t(com.tencent.mm.plugin.auth.a.b.class)).addHandleAuthResponse(new k.3(this));
    ((com.tencent.mm.plugin.messenger.foundation.a.p)g.t(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().a("paymsg", this.iGD, true);
    com.tencent.mm.sdk.b.a.udP.c(this.mKx);
    com.tencent.mm.sdk.b.a.udP.c(this.mKB);
    this.mKt = null;
    this.mKu = null;
    this.mKv = null;
    this.mKC = new m();
  }
  
  public final void bi(boolean paramBoolean) {}
  
  public final void gf(int paramInt) {}
  
  public final void onAccountRelease()
  {
    ((com.tencent.mm.plugin.messenger.foundation.a.p)g.t(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().b("paymsg", this.iGD, true);
    com.tencent.mm.sdk.b.a.udP.d(this.mKx);
    com.tencent.mm.sdk.b.a.udP.d(this.mKB);
    if (this.mKC != null)
    {
      m localm = this.mKC;
      bpX();
      bpY().b(localm);
      com.tencent.mm.sdk.b.a.udP.d(localm.lRT);
    }
    this.mKC = null;
    this.fBp.dead();
  }
  
  public final HashMap<Integer, h.d> xe()
  {
    return dgp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.k
 * JD-Core Version:    0.7.0.1
 */