package com.tencent.mm.plugin.wallet_core.c.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.Orders.DiscountInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders.Promotions;
import com.tencent.mm.protocal.protobuf.cit;
import com.tencent.mm.protocal.protobuf.ciu;
import com.tencent.mm.protocal.protobuf.cix;
import com.tencent.mm.protocal.protobuf.cje;
import com.tencent.mm.protocal.protobuf.cjf;
import com.tencent.mm.protocal.protobuf.cji;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.wallet_core.c.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends w
{
  public int CPL;
  public Orders CPv;
  private f callback;
  private b rr;
  
  public c(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    AppMethodBeat.i(69973);
    this.CPL = 0;
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new cje();
    ((b.a)localObject).hNN = new cjf();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/payibgjsgettransaction";
    ((b.a)localObject).funcId = 1565;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (cje)this.rr.hNK.hNQ;
    ((cje)localObject).iht = paramString1;
    ((cje)localObject).FXf = paramString4;
    ((cje)localObject).FXe = paramString2;
    ((cje)localObject).FXg = paramString5;
    ((cje)localObject).FXh = paramString6;
    ((cje)localObject).FDD = paramString3;
    ((cje)localObject).FWa = paramString7;
    AppMethodBeat.o(69973);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(69975);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(69975);
    return i;
  }
  
  public final int getType()
  {
    return 1565;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(69974);
    ad.i("MicroMsg.NetSceneIbgGetTransaction", "hy: get h5 transaction: errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    paramArrayOfByte = (cjf)((b)paramq).hNL.hNQ;
    paramInt1 = paramInt3;
    paramq = paramString;
    if (paramInt3 == 0)
    {
      paramInt1 = paramInt3;
      paramq = paramString;
      if (paramInt2 == 0)
      {
        paramInt1 = paramArrayOfByte.qel;
        paramq = paramArrayOfByte.qem;
      }
    }
    ad.i("MicroMsg.NetSceneIbgGetTransaction", "resp.IsUseNewPage: %s", new Object[] { Integer.valueOf(paramArrayOfByte.Hdb) });
    this.CPL = paramArrayOfByte.Hdb;
    this.CPv = new Orders();
    this.CPv.CPj = 1;
    if ((paramArrayOfByte == null) || (paramArrayOfByte.HcY == null)) {
      ad.e("MicroMsg.NetSceneIbgGetTransaction", "hy: info not valid");
    }
    for (;;)
    {
      paramString = paramq;
      if (bt.isNullOrNil(paramq)) {
        paramString = aj.getContext().getString(2131765224);
      }
      this.callback.onSceneEnd(paramInt2, paramInt1, paramString, this);
      AppMethodBeat.o(69974);
      return;
      this.CPv.dlx = paramArrayOfByte.HcY.Hdi;
      paramString = new Orders.Commodity();
      paramString.dlv = paramArrayOfByte.HcY.xZh;
      paramString.desc = paramArrayOfByte.HcY.icg;
      paramString.paV = (paramArrayOfByte.HcY.Hdi / 100.0D);
      paramString.wCy = String.valueOf(paramArrayOfByte.HcY.Hdk);
      paramString.wCz = paramArrayOfByte.HcY.Hdl;
      paramString.wCD = paramArrayOfByte.HcY.Hdh;
      paramString.wCB = paramArrayOfByte.HcY.Hdg;
      paramString.wCF = paramArrayOfByte.HcY.wCF;
      paramString.wCu = paramArrayOfByte.HcY.Hdj;
      paramString.CYL = (paramArrayOfByte.HcY.Hdm / 100.0D);
      Object localObject1;
      if (paramArrayOfByte.HcZ != null)
      {
        paramString.wCG = paramArrayOfByte.HcZ.FRw;
        localObject1 = new Orders.Promotions();
        ((Orders.Promotions)localObject1).name = paramArrayOfByte.HcZ.HcJ;
        ((Orders.Promotions)localObject1).wCG = paramArrayOfByte.HcZ.FRw;
        paramString.CYM = paramArrayOfByte.HcZ.FRw;
        ((Orders.Promotions)localObject1).wMR = paramArrayOfByte.HcZ.hzB;
        paramString.CYa = paramArrayOfByte.HcZ.HcH;
        ((Orders.Promotions)localObject1).type = Orders.CYJ;
        if (!bt.isNullOrNil(((Orders.Promotions)localObject1).name))
        {
          paramString.CYU.add(localObject1);
          paramString.CYV = true;
        }
      }
      Object localObject2;
      Object localObject3;
      for (this.CPv.CYa = paramArrayOfByte.HcZ.HcH; (paramArrayOfByte.HcY.Hdn != null) && (paramArrayOfByte.HcY.Hdn.size() > 0); this.CPv.CYa = 0)
      {
        paramString.CYO = new ArrayList();
        localObject1 = paramArrayOfByte.HcY.Hdn.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (cix)((Iterator)localObject1).next();
          localObject3 = new Orders.DiscountInfo();
          ((Orders.DiscountInfo)localObject3).xXz = ((cix)localObject2).HcK;
          paramString.CYO.add(localObject3);
        }
        ad.i("MicroMsg.NetSceneIbgGetTransaction", "hy: no biz info");
      }
      if ((paramArrayOfByte.Hda != null) && (paramArrayOfByte.Hda.size() > 0))
      {
        paramString.CYU = new ArrayList();
        localObject1 = paramArrayOfByte.Hda.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (cit)((Iterator)localObject1).next();
          localObject3 = new Orders.Promotions();
          ((Orders.Promotions)localObject3).type = Orders.CYK;
          ((Orders.Promotions)localObject3).url = ((cit)localObject2).url;
          ((Orders.Promotions)localObject3).name = ((cit)localObject2).dxD;
          ((Orders.Promotions)localObject3).wMR = ((cit)localObject2).dDH;
          ((Orders.Promotions)localObject3).CXM = ((cit)localObject2).Dhj;
          ((Orders.Promotions)localObject3).CZh = bt.getInt(((cit)localObject2).type, 0);
          ((Orders.Promotions)localObject3).title = ((cit)localObject2).title;
          ((Orders.Promotions)localObject3).COR = ((cit)localObject2).CZr;
          ((Orders.Promotions)localObject3).OdM = ((int)((cit)localObject2).CZs);
          ((Orders.Promotions)localObject3).OdO = ((cit)localObject2).CXN;
          ((Orders.Promotions)localObject3).OdN = ((int)((cit)localObject2).CZt);
          ((Orders.Promotions)localObject3).CXJ = ((cit)localObject2).CZu;
          ((Orders.Promotions)localObject3).CXK = ((cit)localObject2).CZv;
          ((Orders.Promotions)localObject3).OdP = ((cit)localObject2).HcE;
          ((Orders.Promotions)localObject3).OdQ = ((cit)localObject2).HcF;
          ((Orders.Promotions)localObject3).CXL = ((cit)localObject2).CZw;
          ((Orders.Promotions)localObject3).OdR = ((cit)localObject2).HcG;
          paramString.CYU.add(localObject3);
        }
      }
      this.CPv.CYk = new ArrayList();
      this.CPv.CYk.add(paramString);
      this.CPv.CYc = paramArrayOfByte.HcY.Hdl;
      ad.i("MicroMsg.NetSceneIbgGetTransaction", "formatOrders finish, mOrder.commoditys.size: %s, mOrder: %s", new Object[] { Integer.valueOf(this.CPv.CYk.size()), this.CPv });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.a.c
 * JD-Core Version:    0.7.0.1
 */