package com.tencent.mm.plugin.wallet_core.c.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.Orders.DiscountInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders.Promotions;
import com.tencent.mm.protocal.protobuf.cjn;
import com.tencent.mm.protocal.protobuf.cjo;
import com.tencent.mm.protocal.protobuf.cjr;
import com.tencent.mm.protocal.protobuf.cjy;
import com.tencent.mm.protocal.protobuf.cjz;
import com.tencent.mm.protocal.protobuf.ckc;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.wallet_core.c.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends w
{
  public Orders DgZ;
  public int Dhp;
  private f callback;
  private b rr;
  
  public c(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    AppMethodBeat.i(69973);
    this.Dhp = 0;
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new cjy();
    ((b.a)localObject).hQG = new cjz();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/payibgjsgettransaction";
    ((b.a)localObject).funcId = 1565;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (cjy)this.rr.hQD.hQJ;
    ((cjy)localObject).ikm = paramString1;
    ((cjy)localObject).GpE = paramString4;
    ((cjy)localObject).GpD = paramString2;
    ((cjy)localObject).GpF = paramString5;
    ((cjy)localObject).GpG = paramString6;
    ((cjy)localObject).FVY = paramString3;
    ((cjy)localObject).Goz = paramString7;
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
    ae.i("MicroMsg.NetSceneIbgGetTransaction", "hy: get h5 transaction: errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    paramArrayOfByte = (cjz)((b)paramq).hQE.hQJ;
    paramInt1 = paramInt3;
    paramq = paramString;
    if (paramInt3 == 0)
    {
      paramInt1 = paramInt3;
      paramq = paramString;
      if (paramInt2 == 0)
      {
        paramInt1 = paramArrayOfByte.qkQ;
        paramq = paramArrayOfByte.qkR;
      }
    }
    ae.i("MicroMsg.NetSceneIbgGetTransaction", "resp.IsUseNewPage: %s", new Object[] { Integer.valueOf(paramArrayOfByte.HwB) });
    this.Dhp = paramArrayOfByte.HwB;
    this.DgZ = new Orders();
    this.DgZ.DgN = 1;
    if ((paramArrayOfByte == null) || (paramArrayOfByte.Hwy == null)) {
      ae.e("MicroMsg.NetSceneIbgGetTransaction", "hy: info not valid");
    }
    for (;;)
    {
      paramString = paramq;
      if (bu.isNullOrNil(paramq)) {
        paramString = ak.getContext().getString(2131765224);
      }
      this.callback.onSceneEnd(paramInt2, paramInt1, paramString, this);
      AppMethodBeat.o(69974);
      return;
      this.DgZ.dmz = paramArrayOfByte.Hwy.HwI;
      paramString = new Orders.Commodity();
      paramString.dmx = paramArrayOfByte.Hwy.yoZ;
      paramString.desc = paramArrayOfByte.Hwy.ieZ;
      paramString.phz = (paramArrayOfByte.Hwy.HwI / 100.0D);
      paramString.wSj = String.valueOf(paramArrayOfByte.Hwy.HwK);
      paramString.wSk = paramArrayOfByte.Hwy.HwL;
      paramString.wSo = paramArrayOfByte.Hwy.HwH;
      paramString.wSm = paramArrayOfByte.Hwy.HwG;
      paramString.wSq = paramArrayOfByte.Hwy.wSq;
      paramString.wSf = paramArrayOfByte.Hwy.HwJ;
      paramString.Dqq = (paramArrayOfByte.Hwy.HwM / 100.0D);
      Object localObject1;
      if (paramArrayOfByte.Hwz != null)
      {
        paramString.wSr = paramArrayOfByte.Hwz.GjV;
        localObject1 = new Orders.Promotions();
        ((Orders.Promotions)localObject1).name = paramArrayOfByte.Hwz.Hwj;
        ((Orders.Promotions)localObject1).wSr = paramArrayOfByte.Hwz.GjV;
        paramString.Dqr = paramArrayOfByte.Hwz.GjV;
        ((Orders.Promotions)localObject1).xcF = paramArrayOfByte.Hwz.hCp;
        paramString.DpF = paramArrayOfByte.Hwz.Hwh;
        ((Orders.Promotions)localObject1).type = Orders.Dqo;
        if (!bu.isNullOrNil(((Orders.Promotions)localObject1).name))
        {
          paramString.Dqz.add(localObject1);
          paramString.DqA = true;
        }
      }
      Object localObject2;
      Object localObject3;
      for (this.DgZ.DpF = paramArrayOfByte.Hwz.Hwh; (paramArrayOfByte.Hwy.HwN != null) && (paramArrayOfByte.Hwy.HwN.size() > 0); this.DgZ.DpF = 0)
      {
        paramString.Dqt = new ArrayList();
        localObject1 = paramArrayOfByte.Hwy.HwN.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (cjr)((Iterator)localObject1).next();
          localObject3 = new Orders.DiscountInfo();
          ((Orders.DiscountInfo)localObject3).ynr = ((cjr)localObject2).Hwk;
          paramString.Dqt.add(localObject3);
        }
        ae.i("MicroMsg.NetSceneIbgGetTransaction", "hy: no biz info");
      }
      if ((paramArrayOfByte.HwA != null) && (paramArrayOfByte.HwA.size() > 0))
      {
        paramString.Dqz = new ArrayList();
        localObject1 = paramArrayOfByte.HwA.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (cjn)((Iterator)localObject1).next();
          localObject3 = new Orders.Promotions();
          ((Orders.Promotions)localObject3).type = Orders.Dqp;
          ((Orders.Promotions)localObject3).url = ((cjn)localObject2).url;
          ((Orders.Promotions)localObject3).name = ((cjn)localObject2).dyI;
          ((Orders.Promotions)localObject3).xcF = ((cjn)localObject2).dEM;
          ((Orders.Promotions)localObject3).Dpr = ((cjn)localObject2).DyN;
          ((Orders.Promotions)localObject3).DqM = bu.getInt(((cjn)localObject2).type, 0);
          ((Orders.Promotions)localObject3).title = ((cjn)localObject2).title;
          ((Orders.Promotions)localObject3).vlr = ((cjn)localObject2).DqW;
          ((Orders.Promotions)localObject3).JhR = ((int)((cjn)localObject2).DqX);
          ((Orders.Promotions)localObject3).JhT = ((cjn)localObject2).Dps;
          ((Orders.Promotions)localObject3).JhS = ((int)((cjn)localObject2).DqY);
          ((Orders.Promotions)localObject3).Dpo = ((cjn)localObject2).DqZ;
          ((Orders.Promotions)localObject3).Dpp = ((cjn)localObject2).Dra;
          ((Orders.Promotions)localObject3).JhU = ((cjn)localObject2).Hwe;
          ((Orders.Promotions)localObject3).JhV = ((cjn)localObject2).Hwf;
          ((Orders.Promotions)localObject3).Dpq = ((cjn)localObject2).Drb;
          ((Orders.Promotions)localObject3).JhW = ((cjn)localObject2).Hwg;
          paramString.Dqz.add(localObject3);
        }
      }
      this.DgZ.DpP = new ArrayList();
      this.DgZ.DpP.add(paramString);
      this.DgZ.DpH = paramArrayOfByte.Hwy.HwL;
      ae.i("MicroMsg.NetSceneIbgGetTransaction", "formatOrders finish, mOrder.commoditys.size: %s, mOrder: %s", new Object[] { Integer.valueOf(this.DgZ.DpP.size()), this.DgZ });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.a.c
 * JD-Core Version:    0.7.0.1
 */