package com.tencent.mm.plugin.qmessage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.n.b;
import com.tencent.mm.g.a.wi;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.abd;
import com.tencent.mm.protocal.protobuf.jv;
import com.tencent.mm.protocal.protobuf.jw;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import junit.framework.Assert;

public final class b
  extends n
  implements k
{
  private com.tencent.mm.al.f callback;
  private Set<String> xab;
  
  public b(Set<String> paramSet)
  {
    AppMethodBeat.i(27712);
    Assert.assertTrue(true);
    this.xab = paramSet;
    AppMethodBeat.o(27712);
  }
  
  private boolean g(q paramq)
  {
    AppMethodBeat.i(27715);
    Object localObject1 = (jw)((com.tencent.mm.al.b)paramq).hNL.hNQ;
    if (localObject1 == null)
    {
      ad.e("MicroMsg.NetSceneBatchGetContactProfile", "dealResp: resp is null");
      AppMethodBeat.o(27715);
      return false;
    }
    if (paramq.getRespObj().getRetCode() == 1)
    {
      ad.e("MicroMsg.NetSceneBatchGetContactProfile", "dealResp : endless loop, should stop");
      AppMethodBeat.o(27715);
      return false;
    }
    if (paramq.getRespObj().getRetCode() == -1)
    {
      ad.e("MicroMsg.NetSceneBatchGetContactProfile", "dealResp : server err, can try again");
      AppMethodBeat.o(27715);
      return true;
    }
    localObject1 = ((jw)localObject1).FCA;
    if (localObject1 == null)
    {
      AppMethodBeat.o(27715);
      return false;
    }
    int j = 0;
    while (j < ((List)localObject1).size()) {
      try
      {
        paramq = (abd)new abd().parseFrom(z.a((SKBuiltinBuffer_t)((List)localObject1).get(j)));
        if ((paramq == null) || (paramq.nDo == null))
        {
          ad.e("MicroMsg.NetSceneBatchGetContactProfile", "processContactProfile: profile name is null");
          i = 0;
          if (i != 0) {
            break label644;
          }
          AppMethodBeat.o(27715);
          return false;
        }
      }
      catch (IOException paramq)
      {
        for (;;)
        {
          int i;
          ad.printErrStackTrace("MicroMsg.NetSceneBatchGetContactProfile", paramq, "", new Object[0]);
          ad.e("MicroMsg.NetSceneBatchGetContactProfile", "ContactProfile.parseFrom fail");
          paramq = null;
          continue;
          if (!this.xab.contains(paramq.nDo))
          {
            ad.e("MicroMsg.NetSceneBatchGetContactProfile", "processContactProfile: resp data not in req");
            i = 0;
          }
          else
          {
            this.xab.remove(paramq.nDo);
            ba.aBQ();
            Object localObject2 = c.azp().Bf(paramq.nDo);
            if ((localObject2 == null) || ((int)((com.tencent.mm.o.b)localObject2).gfj == 0))
            {
              ad.e("MicroMsg.NetSceneBatchGetContactProfile", "processContactProfile: did not find this contact");
              i = 0;
            }
            else
            {
              ((am)localObject2).setUsername(paramq.nDo);
              ((am)localObject2).sQ(paramq.jdh);
              ((am)localObject2).setType(paramq.GaB & paramq.GaC);
              ((am)localObject2).sT(paramq.nEt);
              ((am)localObject2).sU(paramq.Gaz);
              ((am)localObject2).sV(paramq.GaA);
              ((am)localObject2).kf(paramq.jdc);
              ((am)localObject2).sR(paramq.GaD);
              ((am)localObject2).sX(paramq.GaG);
              ((am)localObject2).sY(paramq.GaF);
              ((am)localObject2).kh(paramq.GaH);
              ((am)localObject2).sS(paramq.GaK);
              ((am)localObject2).ki(paramq.GaL);
              ba.aBQ();
              if (c.azp().c(((aw)localObject2).field_username, (am)localObject2) == -1) {
                ad.e("MicroMsg.NetSceneBatchGetContactProfile", "processContactProfile:update contact failed");
              }
              if (am.aSP(paramq.nDo))
              {
                localObject2 = g.dBT().auT(paramq.nDo);
                if ((localObject2 == null) || (bt.nullAsNil(((d)localObject2).getUsername()).length() <= 0))
                {
                  ad.e("MicroMsg.NetSceneBatchGetContactProfile", "processContactProfile: did not find qcontact");
                  i = 0;
                  continue;
                }
                ((d)localObject2).extInfo = paramq.ukw;
                ((d)localObject2).xae = paramq.GaN;
                ((d)localObject2).xaf = paramq.GaO;
                ((d)localObject2).dDp = 52;
                if (!g.dBT().a(paramq.nDo, (d)localObject2)) {
                  ad.e("MicroMsg.NetSceneBatchGetContactProfile", "processContactProfile:update qcontact failed");
                }
              }
              if (am.aSN(paramq.nDo))
              {
                localObject2 = new wi();
                ((wi)localObject2).dKF.opType = 0;
                ((wi)localObject2).dKF.dDy = paramq.nDo;
                ((wi)localObject2).dKF.dDz = paramq.GaN;
                ((wi)localObject2).dKF.dDA = paramq.GaE;
                a.IbL.l((com.tencent.mm.sdk.b.b)localObject2);
              }
              i = 1;
            }
          }
        }
        label644:
        j += 1;
      }
    }
    AppMethodBeat.o(27715);
    return true;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.f paramf)
  {
    AppMethodBeat.i(27713);
    this.callback = paramf;
    paramf = new LinkedList();
    Object localObject = this.xab.iterator();
    while (((Iterator)localObject).hasNext()) {
      paramf.add((String)((Iterator)localObject).next());
    }
    if (paramf.size() == 0)
    {
      ad.e("MicroMsg.NetSceneBatchGetContactProfile", com.tencent.mm.compatible.util.f.abi() + "doScene reqSize ==0");
      AppMethodBeat.o(27713);
      return -1;
    }
    localObject = new b.a();
    ((b.a)localObject).hNM = new jv();
    ((b.a)localObject).hNN = new jw();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/batchgetcontactprofile";
    ((b.a)localObject).funcId = 140;
    ((b.a)localObject).hNO = 28;
    ((b.a)localObject).respCmdId = 1000000028;
    localObject = ((b.a)localObject).aDC();
    LinkedList localLinkedList = new LinkedList();
    paramf = paramf.iterator();
    while (paramf.hasNext()) {
      localLinkedList.add(z.IX((String)paramf.next()));
    }
    ((jv)((com.tencent.mm.al.b)localObject).hNK.hNQ).FuM = localLinkedList;
    ((jv)((com.tencent.mm.al.b)localObject).hNK.hNQ).FCz = 1;
    ((jv)((com.tencent.mm.al.b)localObject).hNK.hNQ).nDi = localLinkedList.size();
    int i = dispatch(parame, (q)localObject, this);
    AppMethodBeat.o(27713);
    return i;
  }
  
  public final int getType()
  {
    return 140;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(27714);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(27714);
      return;
    }
    if ((g(paramq)) && (this.xab.size() > 0)) {
      doScene(dispatcher(), this.callback);
    }
    ad.d("MicroMsg.NetSceneBatchGetContactProfile", "left cnt = " + this.xab.size());
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(27714);
  }
  
  public final int securityLimitCount()
  {
    return 50;
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    return n.b.hOp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.a.b
 * JD-Core Version:    0.7.0.1
 */