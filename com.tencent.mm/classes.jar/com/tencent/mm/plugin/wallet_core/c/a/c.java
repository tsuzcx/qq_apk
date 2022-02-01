package com.tencent.mm.plugin.wallet_core.c.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.Orders.DiscountInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders.Promotions;
import com.tencent.mm.protocal.protobuf.byy;
import com.tencent.mm.protocal.protobuf.byz;
import com.tencent.mm.protocal.protobuf.bzc;
import com.tencent.mm.protocal.protobuf.bzj;
import com.tencent.mm.protocal.protobuf.bzk;
import com.tencent.mm.protocal.protobuf.bzl;
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
  private g callback;
  private b rr;
  public Orders zWL;
  public int zXc;
  
  public c(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    AppMethodBeat.i(69973);
    this.zXc = 0;
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new bzj();
    ((b.a)localObject).gUV = new bzk();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/payibgjsgettransaction";
    ((b.a)localObject).funcId = 1565;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (bzj)this.rr.gUS.gUX;
    ((bzj)localObject).hnC = paramString1;
    ((bzj)localObject).CXl = paramString4;
    ((bzj)localObject).CXk = paramString2;
    ((bzj)localObject).CXm = paramString5;
    ((bzj)localObject).CXn = paramString6;
    ((bzj)localObject).CFH = paramString3;
    ((bzj)localObject).CWf = paramString7;
    AppMethodBeat.o(69973);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(69975);
    this.callback = paramg;
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
    paramArrayOfByte = (bzk)((b)paramq).gUT.gUX;
    paramInt1 = paramInt3;
    paramq = paramString;
    if (paramInt3 == 0)
    {
      paramInt1 = paramInt3;
      paramq = paramString;
      if (paramInt2 == 0)
      {
        paramInt1 = paramArrayOfByte.oXv;
        paramq = paramArrayOfByte.oXw;
      }
    }
    ad.i("MicroMsg.NetSceneIbgGetTransaction", "resp.IsUseNewPage: %s", new Object[] { Integer.valueOf(paramArrayOfByte.DWg) });
    this.zXc = paramArrayOfByte.DWg;
    this.zWL = new Orders();
    this.zWL.zWA = 1;
    if ((paramArrayOfByte == null) || (paramArrayOfByte.DWd == null)) {
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
      this.zWL.dcH = paramArrayOfByte.DWd.DWj;
      paramString = new Orders.Commodity();
      paramString.dcF = paramArrayOfByte.DWd.vBv;
      paramString.desc = paramArrayOfByte.DWd.hiN;
      paramString.nUf = (paramArrayOfByte.DWd.DWj / 100.0D);
      paramString.uoi = String.valueOf(paramArrayOfByte.DWd.DWl);
      paramString.uoj = paramArrayOfByte.DWd.DWm;
      paramString.uon = paramArrayOfByte.DWd.DWi;
      paramString.uol = paramArrayOfByte.DWd.DWh;
      paramString.uop = paramArrayOfByte.DWd.uop;
      paramString.uoe = paramArrayOfByte.DWd.DWk;
      paramString.AfY = (paramArrayOfByte.DWd.DWn / 100.0D);
      Object localObject1;
      if (paramArrayOfByte.DWe != null)
      {
        paramString.uoq = paramArrayOfByte.DWe.CRC;
        localObject1 = new Orders.Promotions();
        ((Orders.Promotions)localObject1).name = paramArrayOfByte.DWe.DVO;
        ((Orders.Promotions)localObject1).uoq = paramArrayOfByte.DWe.CRC;
        paramString.AfZ = paramArrayOfByte.DWe.CRC;
        ((Orders.Promotions)localObject1).uwS = paramArrayOfByte.DWe.gGR;
        paramString.Afn = paramArrayOfByte.DWe.DVM;
        ((Orders.Promotions)localObject1).type = Orders.AfW;
        if (!bt.isNullOrNil(((Orders.Promotions)localObject1).name))
        {
          paramString.Agh.add(localObject1);
          paramString.Agi = true;
        }
      }
      Object localObject2;
      Object localObject3;
      for (this.zWL.Afn = paramArrayOfByte.DWe.DVM; (paramArrayOfByte.DWd.DWo != null) && (paramArrayOfByte.DWd.DWo.size() > 0); this.zWL.Afn = 0)
      {
        paramString.Agb = new ArrayList();
        localObject1 = paramArrayOfByte.DWd.DWo.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (bzc)((Iterator)localObject1).next();
          localObject3 = new Orders.DiscountInfo();
          ((Orders.DiscountInfo)localObject3).vzN = ((bzc)localObject2).DVP;
          paramString.Agb.add(localObject3);
        }
        ad.i("MicroMsg.NetSceneIbgGetTransaction", "hy: no biz info");
      }
      if ((paramArrayOfByte.DWf != null) && (paramArrayOfByte.DWf.size() > 0))
      {
        paramString.Agh = new ArrayList();
        localObject1 = paramArrayOfByte.DWf.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (byy)((Iterator)localObject1).next();
          localObject3 = new Orders.Promotions();
          ((Orders.Promotions)localObject3).type = Orders.AfX;
          ((Orders.Promotions)localObject3).url = ((byy)localObject2).url;
          ((Orders.Promotions)localObject3).name = ((byy)localObject2).doh;
          ((Orders.Promotions)localObject3).uwS = ((byy)localObject2).dub;
          ((Orders.Promotions)localObject3).AeZ = ((byy)localObject2).Aox;
          ((Orders.Promotions)localObject3).Agu = bt.getInt(((byy)localObject2).type, 0);
          ((Orders.Promotions)localObject3).title = ((byy)localObject2).title;
          ((Orders.Promotions)localObject3).zWi = ((byy)localObject2).AgE;
          ((Orders.Promotions)localObject3).LvT = ((int)((byy)localObject2).AgF);
          ((Orders.Promotions)localObject3).LvV = ((byy)localObject2).Afa;
          ((Orders.Promotions)localObject3).LvU = ((int)((byy)localObject2).AgG);
          ((Orders.Promotions)localObject3).AeW = ((byy)localObject2).AgH;
          ((Orders.Promotions)localObject3).AeX = ((byy)localObject2).AgI;
          ((Orders.Promotions)localObject3).LvW = ((byy)localObject2).DVJ;
          ((Orders.Promotions)localObject3).LvX = ((byy)localObject2).DVK;
          ((Orders.Promotions)localObject3).AeY = ((byy)localObject2).AgJ;
          ((Orders.Promotions)localObject3).LvY = ((byy)localObject2).DVL;
          paramString.Agh.add(localObject3);
        }
      }
      this.zWL.Afx = new ArrayList();
      this.zWL.Afx.add(paramString);
      this.zWL.Afp = paramArrayOfByte.DWd.DWm;
      ad.i("MicroMsg.NetSceneIbgGetTransaction", "formatOrders finish, mOrder.commoditys.size: %s, mOrder: %s", new Object[] { Integer.valueOf(this.zWL.Afx.size()), this.zWL });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.a.c
 * JD-Core Version:    0.7.0.1
 */