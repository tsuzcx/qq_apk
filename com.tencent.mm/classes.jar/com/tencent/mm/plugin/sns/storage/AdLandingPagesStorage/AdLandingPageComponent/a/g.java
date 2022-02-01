package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.n;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestDialogUiData;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestDialogUiData.ItemUiData;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestResult;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cgc;
import com.tencent.mm.protocal.protobuf.dfh;
import com.tencent.mm.protocal.protobuf.dfi;
import com.tencent.mm.protocal.protobuf.dfj;
import com.tencent.mm.protocal.protobuf.dfl;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class g
  extends n
  implements k
{
  private int actionType;
  private com.tencent.mm.ak.g callback;
  private boolean igL;
  public byte[] ihA;
  public List<dfh> ihv;
  private String ihy;
  public SubscribeMsgRequestDialogUiData ihz;
  private com.tencent.mm.ak.b rr;
  private String userName;
  public b ysm;
  
  public g(String paramString)
  {
    this.userName = paramString;
    this.actionType = 2;
  }
  
  public g(String paramString, boolean paramBoolean)
  {
    this.userName = paramString;
    this.actionType = 6;
    this.igL = paramBoolean;
  }
  
  public final g dLA()
  {
    int i = 1;
    AppMethodBeat.i(179134);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new dfi();
    ((b.a)localObject).hvu = new dfj();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/bizattr/subscribemsg";
    this.rr = ((b.a)localObject).aAz();
    if ((this.rr.hvr.hvw instanceof dfi)) {
      localObject = (dfi)this.rr.hvr.hvw;
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
        ((dfi)localObject).EaV = this.userName;
        ((dfi)localObject).Edq = this.actionType;
        ((dfi)localObject).tiT.addAll(this.ihv);
        if (!bs.isNullOrNil(this.ihy)) {
          ((dfi)localObject).FOG = this.ihy;
        }
      }
    }
    ((dfi)localObject).EaV = this.userName;
    ((dfi)localObject).Edq = this.actionType;
    ((dfi)localObject).Ebf = 1;
    if (this.igL) {}
    for (;;)
    {
      ((dfi)localObject).FOA = i;
      ((dfi)localObject).tiT.addAll(this.ihv);
      if (this.actionType != 6) {
        break;
      }
      ((dfi)localObject).Buffer = new com.tencent.mm.bw.b(this.ihA);
      ((dfi)localObject).FOH = new cgc();
      ((dfi)localObject).FOH.Ful = this.ihz.igs;
      ((dfi)localObject).FOH.fZz = this.ihz.opType;
      Iterator localIterator = this.ihz.igt.iterator();
      while (localIterator.hasNext())
      {
        SubscribeMsgRequestDialogUiData.ItemUiData localItemUiData = (SubscribeMsgRequestDialogUiData.ItemUiData)localIterator.next();
        dfl localdfl = new dfl();
        localdfl.Fhh = localItemUiData.hiK;
        localdfl.FOy = localItemUiData.igB;
        ((dfi)localObject).FOH.Fum.add(localdfl);
      }
      break;
      i = 0;
    }
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(179133);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(179133);
    return i;
  }
  
  public final int getType()
  {
    return 2920;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(179135);
    ac.i("NetSceneSubscribeInfo", "errType=" + paramInt2 + ", errCode=" + paramInt3 + ", errMsg=" + paramString);
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
      paramString.ysm = paramb;
      if (paramString.ihv == null) {
        paramString.ihv = new ArrayList();
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        paramb = (String)paramList.next();
        dfh localdfh = new dfh();
        localdfh.Fhh = paramb;
        paramString.ihv.add(localdfh);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.g
 * JD-Core Version:    0.7.0.1
 */