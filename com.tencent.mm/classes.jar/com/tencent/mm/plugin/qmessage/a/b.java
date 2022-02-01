package com.tencent.mm.plugin.qmessage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.n.b;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.g.a.vf;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.jg;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.protocal.protobuf.yi;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
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
  private com.tencent.mm.al.g callback;
  private Set<String> uKa;
  
  public b(Set<String> paramSet)
  {
    AppMethodBeat.i(27712);
    Assert.assertTrue(true);
    this.uKa = paramSet;
    AppMethodBeat.o(27712);
  }
  
  private boolean g(q paramq)
  {
    AppMethodBeat.i(27715);
    Object localObject1 = (jh)((com.tencent.mm.al.b)paramq).gUT.gUX;
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
    localObject1 = ((jh)localObject1).CEE;
    if (localObject1 == null)
    {
      AppMethodBeat.o(27715);
      return false;
    }
    int j = 0;
    while (j < ((List)localObject1).size()) {
      try
      {
        paramq = (yi)new yi().parseFrom(z.a((SKBuiltinBuffer_t)((List)localObject1).get(j)));
        if ((paramq == null) || (paramq.mAQ == null))
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
          if (!this.uKa.contains(paramq.mAQ))
          {
            ad.e("MicroMsg.NetSceneBatchGetContactProfile", "processContactProfile: resp data not in req");
            i = 0;
          }
          else
          {
            this.uKa.remove(paramq.mAQ);
            az.arV();
            Object localObject2 = c.apM().aHY(paramq.mAQ);
            if ((localObject2 == null) || ((int)((com.tencent.mm.n.b)localObject2).fId == 0))
            {
              ad.e("MicroMsg.NetSceneBatchGetContactProfile", "processContactProfile: did not find this contact");
              i = 0;
            }
            else
            {
              ((af)localObject2).setUsername(paramq.mAQ);
              ((af)localObject2).na(paramq.ijR);
              ((af)localObject2).setType(paramq.Dan & paramq.Dao);
              ((af)localObject2).nd(paramq.mBV);
              ((af)localObject2).ne(paramq.Dal);
              ((af)localObject2).nf(paramq.Dam);
              ((af)localObject2).jJ(paramq.ijM);
              ((af)localObject2).nb(paramq.Dap);
              ((af)localObject2).nh(paramq.Das);
              ((af)localObject2).ni(paramq.Dar);
              ((af)localObject2).jL(paramq.Dat);
              ((af)localObject2).nc(paramq.Daw);
              ((af)localObject2).jM(paramq.Dax);
              az.arV();
              if (c.apM().c(((au)localObject2).field_username, (af)localObject2) == -1) {
                ad.e("MicroMsg.NetSceneBatchGetContactProfile", "processContactProfile:update contact failed");
              }
              if (af.aHG(paramq.mAQ))
              {
                localObject2 = g.ddJ().akO(paramq.mAQ);
                if ((localObject2 == null) || (bt.nullAsNil(((d)localObject2).getUsername()).length() <= 0))
                {
                  ad.e("MicroMsg.NetSceneBatchGetContactProfile", "processContactProfile: did not find qcontact");
                  i = 0;
                  continue;
                }
                ((d)localObject2).extInfo = paramq.sed;
                ((d)localObject2).uKd = paramq.Daz;
                ((d)localObject2).uKe = paramq.DaA;
                ((d)localObject2).dtM = 52;
                if (!g.ddJ().a(paramq.mAQ, (d)localObject2)) {
                  ad.e("MicroMsg.NetSceneBatchGetContactProfile", "processContactProfile:update qcontact failed");
                }
              }
              if (af.aHE(paramq.mAQ))
              {
                localObject2 = new vf();
                ((vf)localObject2).dAG.opType = 0;
                ((vf)localObject2).dAG.dtV = paramq.mAQ;
                ((vf)localObject2).dAG.dtW = paramq.Daz;
                ((vf)localObject2).dAG.dtX = paramq.Daq;
                a.ESL.l((com.tencent.mm.sdk.b.b)localObject2);
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
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(27713);
    this.callback = paramg;
    paramg = new LinkedList();
    Object localObject = this.uKa.iterator();
    while (((Iterator)localObject).hasNext()) {
      paramg.add((String)((Iterator)localObject).next());
    }
    if (paramg.size() == 0)
    {
      ad.e("MicroMsg.NetSceneBatchGetContactProfile", f.XJ() + "doScene reqSize ==0");
      AppMethodBeat.o(27713);
      return -1;
    }
    localObject = new b.a();
    ((b.a)localObject).gUU = new jg();
    ((b.a)localObject).gUV = new jh();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/batchgetcontactprofile";
    ((b.a)localObject).funcId = 140;
    ((b.a)localObject).reqCmdId = 28;
    ((b.a)localObject).respCmdId = 1000000028;
    localObject = ((b.a)localObject).atI();
    LinkedList localLinkedList = new LinkedList();
    paramg = paramg.iterator();
    while (paramg.hasNext()) {
      localLinkedList.add(z.BE((String)paramg.next()));
    }
    ((jg)((com.tencent.mm.al.b)localObject).gUS.gUX).Cxc = localLinkedList;
    ((jg)((com.tencent.mm.al.b)localObject).gUS.gUX).CED = 1;
    ((jg)((com.tencent.mm.al.b)localObject).gUS.gUX).mAK = localLinkedList.size();
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
    if ((g(paramq)) && (this.uKa.size() > 0)) {
      doScene(dispatcher(), this.callback);
    }
    ad.d("MicroMsg.NetSceneBatchGetContactProfile", "left cnt = " + this.uKa.size());
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(27714);
  }
  
  public final int securityLimitCount()
  {
    return 50;
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    return n.b.gVB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.a.b
 * JD-Core Version:    0.7.0.1
 */