package com.tencent.mm.plugin.wallet_core.c.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.Orders.DiscountInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders.Promotions;
import com.tencent.mm.plugin.wallet_core.model.Orders.ShowInfo;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.protobuf.ebt;
import com.tencent.mm.protocal.protobuf.ebu;
import com.tencent.mm.protocal.protobuf.ebx;
import com.tencent.mm.protocal.protobuf.ece;
import com.tencent.mm.protocal.protobuf.ecf;
import com.tencent.mm.protocal.protobuf.eci;
import com.tencent.mm.protocal.protobuf.fch;
import com.tencent.mm.protocal.protobuf.fvv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.model.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends w
{
  public int VyC;
  public Orders Vyn;
  private h callback;
  private com.tencent.mm.am.c rr;
  
  public c(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    AppMethodBeat.i(69973);
    this.VyC = 0;
    Object localObject = new c.a();
    ((c.a)localObject).otE = new ece();
    ((c.a)localObject).otF = new ecf();
    ((c.a)localObject).uri = "/cgi-bin/mmpay-bin/payibgjsgettransaction";
    ((c.a)localObject).funcId = 1565;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (ece)c.b.b(this.rr.otB);
    ((ece)localObject).oOI = paramString1;
    ((ece)localObject).ZjJ = paramString4;
    ((ece)localObject).ZjI = paramString2;
    ((ece)localObject).ZjK = paramString5;
    ((ece)localObject).ZjL = paramString6;
    ((ece)localObject).YNW = paramString3;
    ((ece)localObject).ZiL = paramString7;
    AppMethodBeat.o(69973);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(69975);
    this.callback = paramh;
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
    paramArrayOfByte = (ecf)c.c.b(((com.tencent.mm.am.c)params).otC);
    paramInt1 = paramInt3;
    params = paramString;
    if (paramInt3 == 0)
    {
      paramInt1 = paramInt3;
      params = paramString;
      if (paramInt2 == 0)
      {
        paramInt1 = paramArrayOfByte.ytv;
        params = paramArrayOfByte.ytw;
      }
    }
    Log.i("MicroMsg.NetSceneIbgGetTransaction", "resp.IsUseNewPage: %s", new Object[] { Integer.valueOf(paramArrayOfByte.abhL) });
    this.VyC = paramArrayOfByte.abhL;
    this.Vyn = new Orders();
    this.Vyn.Vyb = 1;
    if ((paramArrayOfByte == null) || (paramArrayOfByte.abhI == null)) {
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
      this.Vyn.VHj = paramArrayOfByte.VHj;
      this.Vyn.VHl = new ArrayList();
      paramString = paramArrayOfByte.abhM.iterator();
      Object localObject1;
      Object localObject2;
      while (paramString.hasNext())
      {
        localObject1 = (fch)paramString.next();
        localObject2 = new Orders.ShowInfo();
        ((Orders.ShowInfo)localObject2).name = ((fch)localObject1).name;
        ((Orders.ShowInfo)localObject2).value = ((fch)localObject1).value;
        ((Orders.ShowInfo)localObject2).ICv = ((fch)localObject1).abBW;
        ((Orders.ShowInfo)localObject2).VII = ((fch)localObject1).abBX;
        if (((fch)localObject1).abBV != null)
        {
          ((Orders.ShowInfo)localObject2).VIJ = ((fch)localObject1).abBV.mdV;
          ((Orders.ShowInfo)localObject2).VIK = ((fch)localObject1).abBV.VHR;
          ((Orders.ShowInfo)localObject2).VIL = ((fch)localObject1).abBV.VHS;
          ((Orders.ShowInfo)localObject2).VIM = ((fch)localObject1).abBV.VHT;
          ((Orders.ShowInfo)localObject2).VIN = ((fch)localObject1).abBV.abMH;
        }
        this.Vyn.VHl.add(localObject2);
      }
      this.Vyn.hAW = paramArrayOfByte.abhI.abhT;
      paramString = new Orders.Commodity();
      paramString.hAU = paramArrayOfByte.abhI.Oks;
      paramString.desc = paramArrayOfByte.abhI.des;
      paramString.wZe = (paramArrayOfByte.abhI.abhT / 100.0D);
      paramString.MEj = String.valueOf(paramArrayOfByte.abhI.abhV);
      paramString.MEk = paramArrayOfByte.abhI.abhW;
      paramString.MEo = paramArrayOfByte.abhI.abhS;
      paramString.MEm = paramArrayOfByte.abhI.abhR;
      paramString.MEq = paramArrayOfByte.abhI.MEq;
      paramString.MEf = paramArrayOfByte.abhI.abhU;
      paramString.VHy = (paramArrayOfByte.abhI.abhX / 100.0D);
      if (paramArrayOfByte.abhJ != null)
      {
        paramString.hzv = paramArrayOfByte.abhJ.YYZ;
        localObject1 = new Orders.Promotions();
        ((Orders.Promotions)localObject1).name = paramArrayOfByte.abhJ.abht;
        ((Orders.Promotions)localObject1).hzv = paramArrayOfByte.abhJ.YYZ;
        paramString.VHz = paramArrayOfByte.abhJ.YYZ;
        ((Orders.Promotions)localObject1).MRI = paramArrayOfByte.abhJ.nQG;
        paramString.VGN = paramArrayOfByte.abhJ.abhr;
        ((Orders.Promotions)localObject1).type = Orders.VHw;
        if (!Util.isNullOrNil(((Orders.Promotions)localObject1).name))
        {
          paramString.VHJ.add(localObject1);
          paramString.VHK = true;
        }
      }
      Object localObject3;
      for (this.Vyn.VGN = paramArrayOfByte.abhJ.abhr; (paramArrayOfByte.abhI.abhY != null) && (paramArrayOfByte.abhI.abhY.size() > 0); this.Vyn.VGN = 0)
      {
        paramString.VHB = new ArrayList();
        localObject1 = paramArrayOfByte.abhI.abhY.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (ebx)((Iterator)localObject1).next();
          localObject3 = new Orders.DiscountInfo();
          ((Orders.DiscountInfo)localObject3).OhO = ((ebx)localObject2).abhu;
          paramString.VHB.add(localObject3);
        }
        Log.i("MicroMsg.NetSceneIbgGetTransaction", "hy: no biz info");
      }
      if ((paramArrayOfByte.abhK != null) && (paramArrayOfByte.abhK.size() > 0))
      {
        localObject1 = paramArrayOfByte.abhK.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (ebt)((Iterator)localObject1).next();
          localObject3 = new Orders.Promotions();
          ((Orders.Promotions)localObject3).type = Orders.VHx;
          ((Orders.Promotions)localObject3).url = ((ebt)localObject2).url;
          ((Orders.Promotions)localObject3).name = ((ebt)localObject2).wording;
          ((Orders.Promotions)localObject3).MRI = ((ebt)localObject2).icon;
          ((Orders.Promotions)localObject3).VGz = ((ebt)localObject2).VQT;
          ((Orders.Promotions)localObject3).Avy = Util.getInt(((ebt)localObject2).type, 0);
          ((Orders.Promotions)localObject3).title = ((ebt)localObject2).title;
          ((Orders.Promotions)localObject3).ehe = ((ebt)localObject2).VIA;
          ((Orders.Promotions)localObject3).akjp = ((int)((ebt)localObject2).VIB);
          ((Orders.Promotions)localObject3).akjr = ((ebt)localObject2).VGA;
          ((Orders.Promotions)localObject3).akjq = ((int)((ebt)localObject2).VIC);
          ((Orders.Promotions)localObject3).VGw = ((ebt)localObject2).VID;
          ((Orders.Promotions)localObject3).VGx = ((ebt)localObject2).VIE;
          ((Orders.Promotions)localObject3).akjs = ((ebt)localObject2).abho;
          ((Orders.Promotions)localObject3).akjt = ((ebt)localObject2).abhp;
          ((Orders.Promotions)localObject3).VGy = ((ebt)localObject2).VIF;
          ((Orders.Promotions)localObject3).akju = ((ebt)localObject2).abhq;
          paramString.VHJ.add(localObject3);
        }
      }
      this.Vyn.VGX = new ArrayList();
      this.Vyn.VGX.add(paramString);
      this.Vyn.VGP = paramArrayOfByte.abhI.abhW;
      Log.i("MicroMsg.NetSceneIbgGetTransaction", "formatOrders finish, mOrder.commoditys.size: %s, mOrder: %s", new Object[] { Integer.valueOf(this.Vyn.VGX.size()), this.Vyn });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.a.c
 * JD-Core Version:    0.7.0.1
 */