package com.tencent.mm.plugin.wallet_core.c.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.Orders.DiscountInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders.Promotions;
import com.tencent.mm.plugin.wallet_core.model.Orders.ShowInfo;
import com.tencent.mm.protocal.protobuf.czv;
import com.tencent.mm.protocal.protobuf.czw;
import com.tencent.mm.protocal.protobuf.czz;
import com.tencent.mm.protocal.protobuf.dag;
import com.tencent.mm.protocal.protobuf.dah;
import com.tencent.mm.protocal.protobuf.dak;
import com.tencent.mm.protocal.protobuf.dye;
import com.tencent.mm.protocal.protobuf.epg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.c.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends w
{
  public int HQI;
  public Orders HQs;
  private i callback;
  private d rr;
  
  public c(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    AppMethodBeat.i(69973);
    this.HQI = 0;
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new dag();
    ((d.a)localObject).iLO = new dah();
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/payibgjsgettransaction";
    ((d.a)localObject).funcId = 1565;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (dag)this.rr.iLK.iLR;
    ((dag)localObject).jfi = paramString1;
    ((dag)localObject).Lkq = paramString4;
    ((dag)localObject).Lkp = paramString2;
    ((dag)localObject).Lkr = paramString5;
    ((dag)localObject).Lks = paramString6;
    ((dag)localObject).KPJ = paramString3;
    ((dag)localObject).Ljk = paramString7;
    AppMethodBeat.o(69973);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(69975);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(69975);
    return i;
  }
  
  public final int getType()
  {
    return 1565;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(69974);
    Log.i("MicroMsg.NetSceneIbgGetTransaction", "hy: get h5 transaction: errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    paramArrayOfByte = (dah)((d)params).iLL.iLR;
    paramInt1 = paramInt3;
    params = paramString;
    if (paramInt3 == 0)
    {
      paramInt1 = paramInt3;
      params = paramString;
      if (paramInt2 == 0)
      {
        paramInt1 = paramArrayOfByte.rBL;
        params = paramArrayOfByte.rBM;
      }
    }
    Log.i("MicroMsg.NetSceneIbgGetTransaction", "resp.IsUseNewPage: %s", new Object[] { Integer.valueOf(paramArrayOfByte.MFA) });
    this.HQI = paramArrayOfByte.MFA;
    this.HQs = new Orders();
    this.HQs.HQg = 1;
    if ((paramArrayOfByte == null) || (paramArrayOfByte.MFx == null)) {
      Log.e("MicroMsg.NetSceneIbgGetTransaction", "hy: info not valid");
    }
    for (;;)
    {
      paramString = params;
      if (Util.isNullOrNil(params)) {
        paramString = MMApplicationContext.getContext().getString(2131767667);
      }
      this.callback.onSceneEnd(paramInt2, paramInt1, paramString, this);
      AppMethodBeat.o(69974);
      return;
      this.HQs.HZp = paramArrayOfByte.HZp;
      this.HQs.HZr = new ArrayList();
      paramString = paramArrayOfByte.MFB.iterator();
      Object localObject1;
      Object localObject2;
      while (paramString.hasNext())
      {
        localObject1 = (dye)paramString.next();
        localObject2 = new Orders.ShowInfo();
        ((Orders.ShowInfo)localObject2).name = ((dye)localObject1).name;
        ((Orders.ShowInfo)localObject2).value = ((dye)localObject1).value;
        ((Orders.ShowInfo)localObject2).xEk = ((dye)localObject1).MXS;
        ((Orders.ShowInfo)localObject2).Iaq = ((dye)localObject1).MXT;
        if (((dye)localObject1).MXR != null)
        {
          ((Orders.ShowInfo)localObject2).Iar = ((dye)localObject1).MXR.gTx;
          ((Orders.ShowInfo)localObject2).Ias = ((dye)localObject1).MXR.HZV;
          ((Orders.ShowInfo)localObject2).Iat = ((dye)localObject1).MXR.HZW;
          ((Orders.ShowInfo)localObject2).Iau = ((dye)localObject1).MXR.HZX;
          ((Orders.ShowInfo)localObject2).Iav = ((dye)localObject1).MXR.NgM;
        }
        this.HQs.HZr.add(localObject2);
      }
      this.HQs.dDO = paramArrayOfByte.MFx.MFI;
      paramString = new Orders.Commodity();
      paramString.dDM = paramArrayOfByte.MFx.CpP;
      paramString.desc = paramArrayOfByte.MFx.iZU;
      paramString.qwJ = (paramArrayOfByte.MFx.MFI / 100.0D);
      paramString.AOe = String.valueOf(paramArrayOfByte.MFx.MFK);
      paramString.AOf = paramArrayOfByte.MFx.MFL;
      paramString.AOj = paramArrayOfByte.MFx.MFH;
      paramString.AOh = paramArrayOfByte.MFx.MFG;
      paramString.AOl = paramArrayOfByte.MFx.AOl;
      paramString.AOa = paramArrayOfByte.MFx.MFJ;
      paramString.HZE = (paramArrayOfByte.MFx.MFM / 100.0D);
      if (paramArrayOfByte.MFy != null)
      {
        paramString.dCu = paramArrayOfByte.MFy.KZR;
        localObject1 = new Orders.Promotions();
        ((Orders.Promotions)localObject1).name = paramArrayOfByte.MFy.MFi;
        ((Orders.Promotions)localObject1).dCu = paramArrayOfByte.MFy.KZR;
        paramString.HZF = paramArrayOfByte.MFy.KZR;
        ((Orders.Promotions)localObject1).Bah = paramArrayOfByte.MFy.iwv;
        paramString.HYT = paramArrayOfByte.MFy.MFg;
        ((Orders.Promotions)localObject1).type = Orders.HZC;
        if (!Util.isNullOrNil(((Orders.Promotions)localObject1).name))
        {
          paramString.HZN.add(localObject1);
          paramString.HZO = true;
        }
      }
      Object localObject3;
      for (this.HQs.HYT = paramArrayOfByte.MFy.MFg; (paramArrayOfByte.MFx.MFN != null) && (paramArrayOfByte.MFx.MFN.size() > 0); this.HQs.HYT = 0)
      {
        paramString.HZH = new ArrayList();
        localObject1 = paramArrayOfByte.MFx.MFN.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (czz)((Iterator)localObject1).next();
          localObject3 = new Orders.DiscountInfo();
          ((Orders.DiscountInfo)localObject3).Coh = ((czz)localObject2).MFj;
          paramString.HZH.add(localObject3);
        }
        Log.i("MicroMsg.NetSceneIbgGetTransaction", "hy: no biz info");
      }
      if ((paramArrayOfByte.MFz != null) && (paramArrayOfByte.MFz.size() > 0))
      {
        localObject1 = paramArrayOfByte.MFz.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (czv)((Iterator)localObject1).next();
          localObject3 = new Orders.Promotions();
          ((Orders.Promotions)localObject3).type = Orders.HZD;
          ((Orders.Promotions)localObject3).url = ((czv)localObject2).url;
          ((Orders.Promotions)localObject3).name = ((czv)localObject2).dQx;
          ((Orders.Promotions)localObject3).Bah = ((czv)localObject2).icon;
          ((Orders.Promotions)localObject3).HYF = ((czv)localObject2).IhY;
          ((Orders.Promotions)localObject3).trD = Util.getInt(((czv)localObject2).type, 0);
          ((Orders.Promotions)localObject3).title = ((czv)localObject2).title;
          ((Orders.Promotions)localObject3).crw = ((czv)localObject2).Iai;
          ((Orders.Promotions)localObject3).Utv = ((int)((czv)localObject2).Iaj);
          ((Orders.Promotions)localObject3).Utx = ((czv)localObject2).HYG;
          ((Orders.Promotions)localObject3).Utw = ((int)((czv)localObject2).Iak);
          ((Orders.Promotions)localObject3).HYC = ((czv)localObject2).Ial;
          ((Orders.Promotions)localObject3).HYD = ((czv)localObject2).Iam;
          ((Orders.Promotions)localObject3).Uty = ((czv)localObject2).MFd;
          ((Orders.Promotions)localObject3).Utz = ((czv)localObject2).MFe;
          ((Orders.Promotions)localObject3).HYE = ((czv)localObject2).Ian;
          ((Orders.Promotions)localObject3).UtA = ((czv)localObject2).MFf;
          paramString.HZN.add(localObject3);
        }
      }
      this.HQs.HZd = new ArrayList();
      this.HQs.HZd.add(paramString);
      this.HQs.HYV = paramArrayOfByte.MFx.MFL;
      Log.i("MicroMsg.NetSceneIbgGetTransaction", "formatOrders finish, mOrder.commoditys.size: %s, mOrder: %s", new Object[] { Integer.valueOf(this.HQs.HZd.size()), this.HQs });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.a.c
 * JD-Core Version:    0.7.0.1
 */