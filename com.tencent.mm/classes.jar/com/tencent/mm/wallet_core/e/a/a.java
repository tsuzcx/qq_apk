package com.tencent.mm.wallet_core.e.a;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.k;
import com.tencent.mm.model.q;
import com.tencent.mm.network.e;
import com.tencent.mm.protocal.c.beh;
import com.tencent.mm.protocal.c.bei;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c.o;
import com.tencent.mm.wallet_core.c.t;
import com.tenpay.android.wechat.TenpayUtil;
import java.net.URLEncoder;

public abstract class a
  extends o
{
  public final void L(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject2 = this.dmK;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new b.a();
      ((b.a)localObject1).ecH = new beh();
      ((b.a)localObject1).ecI = new bei();
      ((b.a)localObject1).uri = "/cgi-bin/mmpay-bin/payu";
      ((b.a)localObject1).ecG = 1518;
      ((b.a)localObject1).ecJ = 0;
      ((b.a)localObject1).ecK = 0;
      localObject1 = ((b.a)localObject1).Kt();
      ((k)localObject1).ecZ = true;
    }
    localObject2 = (beh)((b)localObject1).ecE.ecN;
    if (paramBoolean1) {
      ((beh)localObject2).tlp = bUM();
    }
    if (paramBoolean2) {
      ((beh)localObject2).tlq = 1;
    }
    this.dmK = ((b)localObject1);
  }
  
  public final String Qm(String paramString)
  {
    return TenpayUtil.signWith3Des(paramString);
  }
  
  public int a(e parame, f paramf)
  {
    this.dmL = paramf;
    if (!q.Gw())
    {
      y.e("MicroMsg.NetScenePayUBase", "hy: serious error: not payupay");
      paramf.onSceneEnd(1000, -100868, "Pay Method Err", this);
      return 1;
    }
    return a(parame, this.dmK, this);
  }
  
  public final void a(b paramb, bmk parambmk)
  {
    ((beh)paramb.ecE.ecN).tlr = parambmk;
  }
  
  public final void b(b paramb, bmk parambmk)
  {
    ((beh)paramb.ecE.ecN).tzn = parambmk;
  }
  
  public final void b(StringBuilder paramStringBuilder, String paramString)
  {
    paramStringBuilder.append(URLEncoder.encode(paramString));
  }
  
  public abstract int bUM();
  
  public final int bUs()
  {
    return bUM();
  }
  
  public final t e(b paramb)
  {
    paramb = (bei)paramb.ecF.ecN;
    t localt = new t();
    localt.tlv = paramb.tlv;
    localt.tlu = paramb.tlu;
    localt.tlt = paramb.tlt;
    localt.tls = paramb.tls;
    localt.jxm = paramb.tzp;
    localt.wAI = paramb.tzo;
    return localt;
  }
  
  public final int getType()
  {
    return 1518;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.e.a.a
 * JD-Core Version:    0.7.0.1
 */