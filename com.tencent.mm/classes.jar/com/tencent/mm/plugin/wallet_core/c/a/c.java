package com.tencent.mm.plugin.wallet_core.c.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.Orders.DiscountInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders.Promotions;
import com.tencent.mm.protocal.protobuf.cdu;
import com.tencent.mm.protocal.protobuf.cdv;
import com.tencent.mm.protocal.protobuf.cdy;
import com.tencent.mm.protocal.protobuf.cef;
import com.tencent.mm.protocal.protobuf.ceg;
import com.tencent.mm.protocal.protobuf.cej;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.wallet_core.c.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends w
{
  public Orders Bpf;
  public int Bpw;
  private g callback;
  private b rr;
  
  public c(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    AppMethodBeat.i(69973);
    this.Bpw = 0;
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new cef();
    ((b.a)localObject).hvu = new ceg();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/payibgjsgettransaction";
    ((b.a)localObject).funcId = 1565;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (cef)this.rr.hvr.hvw;
    ((cef)localObject).hOf = paramString1;
    ((cef)localObject).EpU = paramString4;
    ((cef)localObject).EpT = paramString2;
    ((cef)localObject).EpV = paramString5;
    ((cef)localObject).EpW = paramString6;
    ((cef)localObject).DYh = paramString3;
    ((cef)localObject).EoO = paramString7;
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
    ac.i("MicroMsg.NetSceneIbgGetTransaction", "hy: get h5 transaction: errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    paramArrayOfByte = (ceg)((b)paramq).hvs.hvw;
    paramInt1 = paramInt3;
    paramq = paramString;
    if (paramInt3 == 0)
    {
      paramInt1 = paramInt3;
      paramq = paramString;
      if (paramInt2 == 0)
      {
        paramInt1 = paramArrayOfByte.pAG;
        paramq = paramArrayOfByte.pAH;
      }
    }
    ac.i("MicroMsg.NetSceneIbgGetTransaction", "resp.IsUseNewPage: %s", new Object[] { Integer.valueOf(paramArrayOfByte.FsU) });
    this.Bpw = paramArrayOfByte.FsU;
    this.Bpf = new Orders();
    this.Bpf.BoU = 1;
    if ((paramArrayOfByte == null) || (paramArrayOfByte.FsR == null)) {
      ac.e("MicroMsg.NetSceneIbgGetTransaction", "hy: info not valid");
    }
    for (;;)
    {
      paramString = paramq;
      if (bs.isNullOrNil(paramq)) {
        paramString = ai.getContext().getString(2131765224);
      }
      this.callback.onSceneEnd(paramInt2, paramInt1, paramString, this);
      AppMethodBeat.o(69974);
      return;
      this.Bpf.daf = paramArrayOfByte.FsR.Ftb;
      paramString = new Orders.Commodity();
      paramString.dad = paramArrayOfByte.FsR.wLA;
      paramString.desc = paramArrayOfByte.FsR.hJq;
      paramString.oxA = (paramArrayOfByte.FsR.Ftb / 100.0D);
      paramString.vxe = String.valueOf(paramArrayOfByte.FsR.Ftd);
      paramString.vxf = paramArrayOfByte.FsR.Fte;
      paramString.vxj = paramArrayOfByte.FsR.Fta;
      paramString.vxh = paramArrayOfByte.FsR.FsZ;
      paramString.vxl = paramArrayOfByte.FsR.vxl;
      paramString.vxa = paramArrayOfByte.FsR.Ftc;
      paramString.Bys = (paramArrayOfByte.FsR.Ftf / 100.0D);
      Object localObject1;
      if (paramArrayOfByte.FsS != null)
      {
        paramString.vxm = paramArrayOfByte.FsS.Ekn;
        localObject1 = new Orders.Promotions();
        ((Orders.Promotions)localObject1).name = paramArrayOfByte.FsS.FsC;
        ((Orders.Promotions)localObject1).vxm = paramArrayOfByte.FsS.Ekn;
        paramString.Byt = paramArrayOfByte.FsS.Ekn;
        ((Orders.Promotions)localObject1).vFL = paramArrayOfByte.FsS.hhs;
        paramString.BxH = paramArrayOfByte.FsS.FsA;
        ((Orders.Promotions)localObject1).type = Orders.Byq;
        if (!bs.isNullOrNil(((Orders.Promotions)localObject1).name))
        {
          paramString.ByB.add(localObject1);
          paramString.ByC = true;
        }
      }
      Object localObject2;
      Object localObject3;
      for (this.Bpf.BxH = paramArrayOfByte.FsS.FsA; (paramArrayOfByte.FsR.Ftg != null) && (paramArrayOfByte.FsR.Ftg.size() > 0); this.Bpf.BxH = 0)
      {
        paramString.Byv = new ArrayList();
        localObject1 = paramArrayOfByte.FsR.Ftg.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (cdy)((Iterator)localObject1).next();
          localObject3 = new Orders.DiscountInfo();
          ((Orders.DiscountInfo)localObject3).wJS = ((cdy)localObject2).FsD;
          paramString.Byv.add(localObject3);
        }
        ac.i("MicroMsg.NetSceneIbgGetTransaction", "hy: no biz info");
      }
      if ((paramArrayOfByte.FsT != null) && (paramArrayOfByte.FsT.size() > 0))
      {
        paramString.ByB = new ArrayList();
        localObject1 = paramArrayOfByte.FsT.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (cdu)((Iterator)localObject1).next();
          localObject3 = new Orders.Promotions();
          ((Orders.Promotions)localObject3).type = Orders.Byr;
          ((Orders.Promotions)localObject3).url = ((cdu)localObject2).url;
          ((Orders.Promotions)localObject3).name = ((cdu)localObject2).dlQ;
          ((Orders.Promotions)localObject3).vFL = ((cdu)localObject2).drM;
          ((Orders.Promotions)localObject3).Bxt = ((cdu)localObject2).BGR;
          ((Orders.Promotions)localObject3).ByO = bs.getInt(((cdu)localObject2).type, 0);
          ((Orders.Promotions)localObject3).title = ((cdu)localObject2).title;
          ((Orders.Promotions)localObject3).BoC = ((cdu)localObject2).ByY;
          ((Orders.Promotions)localObject3).DeE = ((int)((cdu)localObject2).ByZ);
          ((Orders.Promotions)localObject3).DeG = ((cdu)localObject2).Bxu;
          ((Orders.Promotions)localObject3).DeF = ((int)((cdu)localObject2).Bza);
          ((Orders.Promotions)localObject3).Bxq = ((cdu)localObject2).Bzb;
          ((Orders.Promotions)localObject3).Bxr = ((cdu)localObject2).Bzc;
          ((Orders.Promotions)localObject3).DeH = ((cdu)localObject2).Fsx;
          ((Orders.Promotions)localObject3).DeI = ((cdu)localObject2).Fsy;
          ((Orders.Promotions)localObject3).Bxs = ((cdu)localObject2).Bzd;
          ((Orders.Promotions)localObject3).DeJ = ((cdu)localObject2).Fsz;
          paramString.ByB.add(localObject3);
        }
      }
      this.Bpf.BxR = new ArrayList();
      this.Bpf.BxR.add(paramString);
      this.Bpf.BxJ = paramArrayOfByte.FsR.Fte;
      ac.i("MicroMsg.NetSceneIbgGetTransaction", "formatOrders finish, mOrder.commoditys.size: %s, mOrder: %s", new Object[] { Integer.valueOf(this.Bpf.BxR.size()), this.Bpf });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.a.c
 * JD-Core Version:    0.7.0.1
 */