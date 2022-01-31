package com.tencent.mm.plugin.wallet_core.c.a;

import android.content.Context;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.Orders.DiscountInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders.Promotions;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.bde;
import com.tencent.mm.protocal.c.bdf;
import com.tencent.mm.protocal.c.bdi;
import com.tencent.mm.protocal.c.bdp;
import com.tencent.mm.protocal.c.bdq;
import com.tencent.mm.protocal.c.bdr;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends s
{
  private b dmK;
  private f dmL;
  public Orders qre;
  public int qrp = 0;
  
  public c(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new bdp();
    ((b.a)localObject).ecI = new bdq();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/payibgjsgettransaction";
    ((b.a)localObject).ecG = 1565;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (bdp)this.dmK.ecE.ecN;
    ((bdp)localObject).euK = paramString1;
    ((bdp)localObject).sNg = paramString4;
    ((bdp)localObject).sNf = paramString2;
    ((bdp)localObject).sNh = paramString5;
    ((bdp)localObject).sNi = paramString6;
    ((bdp)localObject).sBi = paramString3;
    ((bdp)localObject).sMg = paramString7;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void e(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    y.i("MicroMsg.NetSceneIbgGetTransaction", "hy: get h5 transaction: errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    bdq localbdq = (bdq)((b)paramq).ecF.ecN;
    int i = paramInt2;
    paramq = paramString;
    if (paramInt2 == 0)
    {
      i = paramInt2;
      paramq = paramString;
      if (paramInt1 == 0)
      {
        i = localbdq.jxl;
        paramq = localbdq.jxm;
      }
    }
    y.i("MicroMsg.NetSceneIbgGetTransaction", "resp.IsUseNewPage: %s", new Object[] { Integer.valueOf(localbdq.tyR) });
    this.qrp = localbdq.tyR;
    this.qre = new Orders();
    this.qre.qqY = 1;
    if ((localbdq == null) || (localbdq.tyO == null)) {
      y.e("MicroMsg.NetSceneIbgGetTransaction", "hy: info not valid");
    }
    for (;;)
    {
      paramString = paramq;
      if (bk.bl(paramq)) {
        paramString = ae.getContext().getString(a.i.wallet_data_err);
      }
      this.dmL.onSceneEnd(paramInt1, i, paramString, this);
      return;
      this.qre.nCq = localbdq.tyO.tyU;
      paramString = new Orders.Commodity();
      paramString.bMY = localbdq.tyO.nzq;
      paramString.desc = localbdq.tyO.epN;
      paramString.iHP = (localbdq.tyO.tyU / 100.0D);
      paramString.mOS = String.valueOf(localbdq.tyO.tyW);
      paramString.mOT = localbdq.tyO.tyX;
      paramString.mOX = localbdq.tyO.tyT;
      paramString.mOV = localbdq.tyO.tyS;
      paramString.mOZ = localbdq.tyO.mOZ;
      paramString.mOO = localbdq.tyO.tyV;
      paramString.qxe = (localbdq.tyO.tyY / 100.0D);
      Object localObject1;
      if (localbdq.tyP != null)
      {
        paramString.mPa = localbdq.tyP.sIn;
        localObject1 = new Orders.Promotions();
        ((Orders.Promotions)localObject1).name = localbdq.tyP.tyz;
        ((Orders.Promotions)localObject1).mPa = localbdq.tyP.sIn;
        paramString.qxf = localbdq.tyP.sIn;
        ((Orders.Promotions)localObject1).mTc = localbdq.tyP.ilp;
        paramString.qwE = localbdq.tyP.tyx;
        ((Orders.Promotions)localObject1).type = Orders.qxc;
        if (!bk.bl(((Orders.Promotions)localObject1).name))
        {
          paramString.qxn.add(localObject1);
          paramString.qxo = true;
        }
      }
      Object localObject2;
      Object localObject3;
      for (this.qre.qwE = localbdq.tyP.tyx; (localbdq.tyO.tyZ != null) && (localbdq.tyO.tyZ.size() > 0); this.qre.qwE = 0)
      {
        paramString.qxh = new ArrayList();
        localObject1 = localbdq.tyO.tyZ.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (bdi)((Iterator)localObject1).next();
          localObject3 = new Orders.DiscountInfo();
          ((Orders.DiscountInfo)localObject3).nxN = ((bdi)localObject2).tyA;
          paramString.qxh.add(localObject3);
        }
        y.i("MicroMsg.NetSceneIbgGetTransaction", "hy: no biz info");
      }
      if ((localbdq.tyQ != null) && (localbdq.tyQ.size() > 0))
      {
        paramString.qxn = new ArrayList();
        localObject1 = localbdq.tyQ.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (bde)((Iterator)localObject1).next();
          localObject3 = new Orders.Promotions();
          ((Orders.Promotions)localObject3).type = Orders.qxd;
          ((Orders.Promotions)localObject3).url = ((bde)localObject2).url;
          ((Orders.Promotions)localObject3).name = ((bde)localObject2).bQZ;
          ((Orders.Promotions)localObject3).mTc = ((bde)localObject2).bVO;
          ((Orders.Promotions)localObject3).qwp = ((bde)localObject2).qEu;
          ((Orders.Promotions)localObject3).qxA = bk.getInt(((bde)localObject2).type, 0);
          ((Orders.Promotions)localObject3).title = ((bde)localObject2).title;
          ((Orders.Promotions)localObject3).qqG = ((bde)localObject2).qxK;
          ((Orders.Promotions)localObject3).qxB = ((int)((bde)localObject2).qxL);
          ((Orders.Promotions)localObject3).qxD = ((bde)localObject2).qwq;
          ((Orders.Promotions)localObject3).qxC = ((int)((bde)localObject2).qxM);
          ((Orders.Promotions)localObject3).qwm = ((bde)localObject2).qxN;
          ((Orders.Promotions)localObject3).qwn = ((bde)localObject2).qxO;
          ((Orders.Promotions)localObject3).qxE = ((bde)localObject2).tyu;
          ((Orders.Promotions)localObject3).qxF = ((bde)localObject2).tyv;
          ((Orders.Promotions)localObject3).qwo = ((bde)localObject2).qxP;
          ((Orders.Promotions)localObject3).qxG = ((bde)localObject2).tyw;
          paramString.qxn.add(localObject3);
        }
      }
      this.qre.qwN = new ArrayList();
      this.qre.qwN.add(paramString);
      this.qre.qwG = localbdq.tyO.tyX;
      y.i("MicroMsg.NetSceneIbgGetTransaction", "formatOrders finish, mOrder.commoditys.size: %s, mOrder: %s", new Object[] { Integer.valueOf(this.qre.qwN.size()), this.qre });
    }
  }
  
  public final int getType()
  {
    return 1565;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.a.c
 * JD-Core Version:    0.7.0.1
 */