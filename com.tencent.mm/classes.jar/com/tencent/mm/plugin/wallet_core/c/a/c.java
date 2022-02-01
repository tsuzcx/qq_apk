package com.tencent.mm.plugin.wallet_core.c.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.Orders.DiscountInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders.Promotions;
import com.tencent.mm.plugin.wallet_core.model.Orders.ShowInfo;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.protobuf.djj;
import com.tencent.mm.protocal.protobuf.djk;
import com.tencent.mm.protocal.protobuf.djn;
import com.tencent.mm.protocal.protobuf.dju;
import com.tencent.mm.protocal.protobuf.djv;
import com.tencent.mm.protocal.protobuf.djy;
import com.tencent.mm.protocal.protobuf.eif;
import com.tencent.mm.protocal.protobuf.ezr;
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
  public Orders OIB;
  public int OIQ;
  private i callback;
  private d rr;
  
  public c(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    AppMethodBeat.i(69973);
    this.OIQ = 0;
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new dju();
    ((d.a)localObject).lBV = new djv();
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/payibgjsgettransaction";
    ((d.a)localObject).funcId = 1565;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (dju)d.b.b(this.rr.lBR);
    ((dju)localObject).lVG = paramString1;
    ((dju)localObject).Slz = paramString4;
    ((dju)localObject).Sly = paramString2;
    ((dju)localObject).SlA = paramString5;
    ((dju)localObject).SlB = paramString6;
    ((dju)localObject).RQH = paramString3;
    ((dju)localObject).SkB = paramString7;
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
    paramArrayOfByte = (djv)d.c.b(((d)params).lBS);
    paramInt1 = paramInt3;
    params = paramString;
    if (paramInt3 == 0)
    {
      paramInt1 = paramInt3;
      params = paramString;
      if (paramInt2 == 0)
      {
        paramInt1 = paramArrayOfByte.vht;
        params = paramArrayOfByte.vhu;
      }
    }
    Log.i("MicroMsg.NetSceneIbgGetTransaction", "resp.IsUseNewPage: %s", new Object[] { Integer.valueOf(paramArrayOfByte.TRm) });
    this.OIQ = paramArrayOfByte.TRm;
    this.OIB = new Orders();
    this.OIB.OIp = 1;
    if ((paramArrayOfByte == null) || (paramArrayOfByte.TRj == null)) {
      Log.e("MicroMsg.NetSceneIbgGetTransaction", "hy: info not valid");
    }
    for (;;)
    {
      paramString = params;
      if (Util.isNullOrNil(params)) {
        paramString = MMApplicationContext.getContext().getString(a.i.wallet_data_err);
      }
      this.callback.onSceneEnd(paramInt2, paramInt1, paramString, this);
      AppMethodBeat.o(69974);
      return;
      this.OIB.ORp = paramArrayOfByte.ORp;
      this.OIB.ORr = new ArrayList();
      paramString = paramArrayOfByte.TRn.iterator();
      Object localObject1;
      Object localObject2;
      while (paramString.hasNext())
      {
        localObject1 = (eif)paramString.next();
        localObject2 = new Orders.ShowInfo();
        ((Orders.ShowInfo)localObject2).name = ((eif)localObject1).name;
        ((Orders.ShowInfo)localObject2).value = ((eif)localObject1).value;
        ((Orders.ShowInfo)localObject2).CIl = ((eif)localObject1).Ukn;
        ((Orders.ShowInfo)localObject2).OSB = ((eif)localObject1).Uko;
        if (((eif)localObject1).Ukm != null)
        {
          ((Orders.ShowInfo)localObject2).OSC = ((eif)localObject1).Ukm.jDZ;
          ((Orders.ShowInfo)localObject2).OSD = ((eif)localObject1).Ukm.ORW;
          ((Orders.ShowInfo)localObject2).OSE = ((eif)localObject1).Ukm.ORX;
          ((Orders.ShowInfo)localObject2).OSF = ((eif)localObject1).Ukm.ORY;
          ((Orders.ShowInfo)localObject2).OSG = ((eif)localObject1).Ukm.Utq;
        }
        this.OIB.ORr.add(localObject2);
      }
      this.OIB.fwy = paramArrayOfByte.TRj.TRu;
      paramString = new Orders.Commodity();
      paramString.fww = paramArrayOfByte.TRj.Ine;
      paramString.desc = paramArrayOfByte.TRj.des;
      paramString.tVK = (paramArrayOfByte.TRj.TRu / 100.0D);
      paramString.GHs = String.valueOf(paramArrayOfByte.TRj.TRw);
      paramString.GHt = paramArrayOfByte.TRj.TRx;
      paramString.GHx = paramArrayOfByte.TRj.TRt;
      paramString.GHv = paramArrayOfByte.TRj.TRs;
      paramString.GHz = paramArrayOfByte.TRj.GHz;
      paramString.GHo = paramArrayOfByte.TRj.TRv;
      paramString.ORE = (paramArrayOfByte.TRj.TRy / 100.0D);
      if (paramArrayOfByte.TRk != null)
      {
        paramString.fvb = paramArrayOfByte.TRk.Sba;
        localObject1 = new Orders.Promotions();
        ((Orders.Promotions)localObject1).name = paramArrayOfByte.TRk.TQU;
        ((Orders.Promotions)localObject1).fvb = paramArrayOfByte.TRk.Sba;
        paramString.ORF = paramArrayOfByte.TRk.Sba;
        ((Orders.Promotions)localObject1).GUf = paramArrayOfByte.TRk.llI;
        paramString.OQT = paramArrayOfByte.TRk.TQS;
        ((Orders.Promotions)localObject1).type = Orders.ORC;
        if (!Util.isNullOrNil(((Orders.Promotions)localObject1).name))
        {
          paramString.ORO.add(localObject1);
          paramString.ORP = true;
        }
      }
      Object localObject3;
      for (this.OIB.OQT = paramArrayOfByte.TRk.TQS; (paramArrayOfByte.TRj.TRz != null) && (paramArrayOfByte.TRj.TRz.size() > 0); this.OIB.OQT = 0)
      {
        paramString.ORH = new ArrayList();
        localObject1 = paramArrayOfByte.TRj.TRz.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (djn)((Iterator)localObject1).next();
          localObject3 = new Orders.DiscountInfo();
          ((Orders.DiscountInfo)localObject3).Ila = ((djn)localObject2).TQV;
          paramString.ORH.add(localObject3);
        }
        Log.i("MicroMsg.NetSceneIbgGetTransaction", "hy: no biz info");
      }
      if ((paramArrayOfByte.TRl != null) && (paramArrayOfByte.TRl.size() > 0))
      {
        localObject1 = paramArrayOfByte.TRl.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (djj)((Iterator)localObject1).next();
          localObject3 = new Orders.Promotions();
          ((Orders.Promotions)localObject3).type = Orders.ORD;
          ((Orders.Promotions)localObject3).url = ((djj)localObject2).url;
          ((Orders.Promotions)localObject3).name = ((djj)localObject2).wording;
          ((Orders.Promotions)localObject3).GUf = ((djj)localObject2).icon;
          ((Orders.Promotions)localObject3).OQF = ((djj)localObject2).Pap;
          ((Orders.Promotions)localObject3).wYj = Util.getInt(((djj)localObject2).type, 0);
          ((Orders.Promotions)localObject3).title = ((djj)localObject2).title;
          ((Orders.Promotions)localObject3).cpu = ((djj)localObject2).OSt;
          ((Orders.Promotions)localObject3).SuA = ((int)((djj)localObject2).OSu);
          ((Orders.Promotions)localObject3).SuC = ((djj)localObject2).OQG;
          ((Orders.Promotions)localObject3).SuB = ((int)((djj)localObject2).OSv);
          ((Orders.Promotions)localObject3).OQC = ((djj)localObject2).OSw;
          ((Orders.Promotions)localObject3).OQD = ((djj)localObject2).OSx;
          ((Orders.Promotions)localObject3).SuD = ((djj)localObject2).TQP;
          ((Orders.Promotions)localObject3).SuE = ((djj)localObject2).TQQ;
          ((Orders.Promotions)localObject3).OQE = ((djj)localObject2).OSy;
          ((Orders.Promotions)localObject3).SuF = ((djj)localObject2).TQR;
          paramString.ORO.add(localObject3);
        }
      }
      this.OIB.ORd = new ArrayList();
      this.OIB.ORd.add(paramString);
      this.OIB.OQV = paramArrayOfByte.TRj.TRx;
      Log.i("MicroMsg.NetSceneIbgGetTransaction", "formatOrders finish, mOrder.commoditys.size: %s, mOrder: %s", new Object[] { Integer.valueOf(this.OIB.ORd.size()), this.OIB });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.a.c
 * JD-Core Version:    0.7.0.1
 */