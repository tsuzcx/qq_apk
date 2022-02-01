package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.n;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestDialogUiData;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestDialogUiData.ItemUiData;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestResult;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cbc;
import com.tencent.mm.protocal.protobuf.czv;
import com.tencent.mm.protocal.protobuf.czw;
import com.tencent.mm.protocal.protobuf.czx;
import com.tencent.mm.protocal.protobuf.czz;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class g
  extends n
  implements k
{
  private int actionType;
  private com.tencent.mm.al.g callback;
  public List<czv> hGT;
  private String hGW;
  public SubscribeMsgRequestDialogUiData hGX;
  public byte[] hGY;
  private boolean hGj;
  private com.tencent.mm.al.b rr;
  private String userName;
  public b xfy;
  
  public g(String paramString)
  {
    this.userName = paramString;
    this.actionType = 2;
  }
  
  public g(String paramString, boolean paramBoolean)
  {
    this.userName = paramString;
    this.actionType = 6;
    this.hGj = paramBoolean;
  }
  
  public final int doScene(e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(179133);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(179133);
    return i;
  }
  
  public final g dxb()
  {
    int i = 1;
    AppMethodBeat.i(179134);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new czw();
    ((b.a)localObject).gUV = new czx();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/bizattr/subscribemsg";
    this.rr = ((b.a)localObject).atI();
    if ((this.rr.gUS.gUX instanceof czw)) {
      localObject = (czw)this.rr.gUS.gUX;
    }
    switch (this.actionType)
    {
    case 4: 
    default: 
    case 2: 
    case 3: 
    case 5: 
      for (;;)
      {
        AppMethodBeat.o(179134);
        return this;
        ((czw)localObject).CIt = this.userName;
        ((czw)localObject).CKO = this.actionType;
        ((czw)localObject).saZ.addAll(this.hGT);
        if (!bt.isNullOrNil(this.hGW)) {
          ((czw)localObject).ErE = this.hGW;
        }
      }
    }
    ((czw)localObject).CIt = this.userName;
    ((czw)localObject).CKO = this.actionType;
    ((czw)localObject).CID = 1;
    if (this.hGj) {}
    for (;;)
    {
      ((czw)localObject).Ery = i;
      ((czw)localObject).saZ.addAll(this.hGT);
      if (this.actionType != 6) {
        break;
      }
      ((czw)localObject).Buffer = new com.tencent.mm.bx.b(this.hGY);
      ((czw)localObject).ErF = new cbc();
      ((czw)localObject).ErF.DXr = this.hGX.hFQ;
      ((czw)localObject).ErF.fVE = this.hGX.opType;
      Iterator localIterator = this.hGX.hFR.iterator();
      while (localIterator.hasNext())
      {
        SubscribeMsgRequestDialogUiData.ItemUiData localItemUiData = (SubscribeMsgRequestDialogUiData.ItemUiData)localIterator.next();
        czz localczz = new czz();
        localczz.DKS = localItemUiData.gIj;
        localczz.Erw = localItemUiData.hFZ;
        ((czw)localObject).ErF.DXs.add(localczz);
      }
      break;
      i = 0;
    }
  }
  
  public final int getType()
  {
    return 2920;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(179135);
    ad.i("NetSceneSubscribeInfo", "errType=" + paramInt2 + ", errCode=" + paramInt3 + ", errMsg=" + paramString);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(179135);
  }
  
  public static final class a
  {
    public static g a(String paramString, List<String> paramList, g.b paramb)
    {
      AppMethodBeat.i(179132);
      paramString = new g(paramString);
      paramString.xfy = paramb;
      if (paramString.hGT == null) {
        paramString.hGT = new ArrayList();
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        paramb = (String)paramList.next();
        czv localczv = new czv();
        localczv.DKS = paramb;
        paramString.hGT.add(localczv);
      }
      AppMethodBeat.o(179132);
      return paramString;
    }
  }
  
  public static abstract interface b
  {
    public abstract void c(SubscribeMsgRequestResult paramSubscribeMsgRequestResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.g
 * JD-Core Version:    0.7.0.1
 */