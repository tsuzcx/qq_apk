package com.tencent.mm.plugin.wallet_core.c.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.Orders.DiscountInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders.Promotions;
import com.tencent.mm.protocal.protobuf.bky;
import com.tencent.mm.protocal.protobuf.bkz;
import com.tencent.mm.protocal.protobuf.blc;
import com.tencent.mm.protocal.protobuf.blj;
import com.tencent.mm.protocal.protobuf.blk;
import com.tencent.mm.protocal.protobuf.bll;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.c.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends u
{
  private f callback;
  private b rr;
  public Orders ucc;
  public int ucn;
  
  public c(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    AppMethodBeat.i(46566);
    this.ucn = 0;
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new blj();
    ((b.a)localObject).fsY = new blk();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/payibgjsgettransaction";
    ((b.a)localObject).funcId = 1565;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (blj)this.rr.fsV.fta;
    ((blj)localObject).fKw = paramString1;
    ((blj)localObject).wKW = paramString4;
    ((blj)localObject).wKV = paramString2;
    ((blj)localObject).wKX = paramString5;
    ((blj)localObject).wKY = paramString6;
    ((blj)localObject).wvC = paramString3;
    ((blj)localObject).wJT = paramString7;
    AppMethodBeat.o(46566);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(46568);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(46568);
    return i;
  }
  
  public final int getType()
  {
    return 1565;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(142396);
    ab.i("MicroMsg.NetSceneIbgGetTransaction", "hy: get h5 transaction: errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    paramArrayOfByte = (blk)((b)paramq).fsW.fta;
    paramInt1 = paramInt3;
    paramq = paramString;
    if (paramInt3 == 0)
    {
      paramInt1 = paramInt3;
      paramq = paramString;
      if (paramInt2 == 0)
      {
        paramInt1 = paramArrayOfByte.lGK;
        paramq = paramArrayOfByte.lGL;
      }
    }
    ab.i("MicroMsg.NetSceneIbgGetTransaction", "resp.IsUseNewPage: %s", new Object[] { Integer.valueOf(paramArrayOfByte.xzZ) });
    this.ucn = paramArrayOfByte.xzZ;
    this.ucc = new Orders();
    this.ucc.ubU = 1;
    if ((paramArrayOfByte == null) || (paramArrayOfByte.xzW == null)) {
      ab.e("MicroMsg.NetSceneIbgGetTransaction", "hy: info not valid");
    }
    for (;;)
    {
      paramString = paramq;
      if (bo.isNullOrNil(paramq)) {
        paramString = ah.getContext().getString(2131305032);
      }
      this.callback.onSceneEnd(paramInt2, paramInt1, paramString, this);
      AppMethodBeat.o(142396);
      return;
      this.ucc.cnL = paramArrayOfByte.xzW.xAc;
      paramString = new Orders.Commodity();
      paramString.cnJ = paramArrayOfByte.xzW.qkt;
      paramString.desc = paramArrayOfByte.xzW.fGn;
      paramString.kNS = (paramArrayOfByte.xzW.xAc / 100.0D);
      paramString.ppi = String.valueOf(paramArrayOfByte.xzW.xAe);
      paramString.ppj = paramArrayOfByte.xzW.xAf;
      paramString.ppn = paramArrayOfByte.xzW.xAb;
      paramString.ppl = paramArrayOfByte.xzW.xAa;
      paramString.ppp = paramArrayOfByte.xzW.ppp;
      paramString.ppe = paramArrayOfByte.xzW.xAd;
      paramString.ujM = (paramArrayOfByte.xzW.xAg / 100.0D);
      Object localObject1;
      if (paramArrayOfByte.xzX != null)
      {
        paramString.ppq = paramArrayOfByte.xzX.wFW;
        localObject1 = new Orders.Promotions();
        ((Orders.Promotions)localObject1).name = paramArrayOfByte.xzX.xzH;
        ((Orders.Promotions)localObject1).ppq = paramArrayOfByte.xzX.wFW;
        paramString.ujN = paramArrayOfByte.xzX.wFW;
        ((Orders.Promotions)localObject1).pvi = paramArrayOfByte.xzX.kmm;
        paramString.ujc = paramArrayOfByte.xzX.xzF;
        ((Orders.Promotions)localObject1).type = Orders.ujK;
        if (!bo.isNullOrNil(((Orders.Promotions)localObject1).name))
        {
          paramString.ujV.add(localObject1);
          paramString.ujW = true;
        }
      }
      Object localObject2;
      Object localObject3;
      for (this.ucc.ujc = paramArrayOfByte.xzX.xzF; (paramArrayOfByte.xzW.xAh != null) && (paramArrayOfByte.xzW.xAh.size() > 0); this.ucc.ujc = 0)
      {
        paramString.ujP = new ArrayList();
        localObject1 = paramArrayOfByte.xzW.xAh.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (blc)((Iterator)localObject1).next();
          localObject3 = new Orders.DiscountInfo();
          ((Orders.DiscountInfo)localObject3).qiO = ((blc)localObject2).xzI;
          paramString.ujP.add(localObject3);
        }
        ab.i("MicroMsg.NetSceneIbgGetTransaction", "hy: no biz info");
      }
      if ((paramArrayOfByte.xzY != null) && (paramArrayOfByte.xzY.size() > 0))
      {
        paramString.ujV = new ArrayList();
        localObject1 = paramArrayOfByte.xzY.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (bky)((Iterator)localObject1).next();
          localObject3 = new Orders.Promotions();
          ((Orders.Promotions)localObject3).type = Orders.ujL;
          ((Orders.Promotions)localObject3).url = ((bky)localObject2).url;
          ((Orders.Promotions)localObject3).name = ((bky)localObject2).cyA;
          ((Orders.Promotions)localObject3).pvi = ((bky)localObject2).cDz;
          ((Orders.Promotions)localObject3).uiO = ((bky)localObject2).urC;
          ((Orders.Promotions)localObject3).uki = bo.getInt(((bky)localObject2).type, 0);
          ((Orders.Promotions)localObject3).title = ((bky)localObject2).title;
          ((Orders.Promotions)localObject3).ubC = ((bky)localObject2).uks;
          ((Orders.Promotions)localObject3).ukk = ((int)((bky)localObject2).ukt);
          ((Orders.Promotions)localObject3).ukm = ((bky)localObject2).uiP;
          ((Orders.Promotions)localObject3).ukl = ((int)((bky)localObject2).uku);
          ((Orders.Promotions)localObject3).uiL = ((bky)localObject2).ukv;
          ((Orders.Promotions)localObject3).uiM = ((bky)localObject2).ukw;
          ((Orders.Promotions)localObject3).ukn = ((bky)localObject2).xzC;
          ((Orders.Promotions)localObject3).uko = ((bky)localObject2).xzD;
          ((Orders.Promotions)localObject3).uiN = ((bky)localObject2).ukx;
          ((Orders.Promotions)localObject3).ukp = ((bky)localObject2).xzE;
          paramString.ujV.add(localObject3);
        }
      }
      this.ucc.ujl = new ArrayList();
      this.ucc.ujl.add(paramString);
      this.ucc.uje = paramArrayOfByte.xzW.xAf;
      ab.i("MicroMsg.NetSceneIbgGetTransaction", "formatOrders finish, mOrder.commoditys.size: %s, mOrder: %s", new Object[] { Integer.valueOf(this.ucc.ujl.size()), this.ucc });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.a.c
 * JD-Core Version:    0.7.0.1
 */