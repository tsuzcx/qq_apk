package com.tencent.mm.plugin.qmessage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.m.b;
import com.tencent.mm.g.a.ti;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.ij;
import com.tencent.mm.protocal.protobuf.ik;
import com.tencent.mm.protocal.protobuf.vg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import junit.framework.Assert;

public final class b
  extends m
  implements k
{
  private f callback;
  private Set<String> pHK;
  
  public b(Set<String> paramSet)
  {
    AppMethodBeat.i(24072);
    Assert.assertTrue(true);
    this.pHK = paramSet;
    AppMethodBeat.o(24072);
  }
  
  private boolean g(q paramq)
  {
    AppMethodBeat.i(24075);
    Object localObject1 = (ik)((com.tencent.mm.ai.b)paramq).fsW.fta;
    if (localObject1 == null)
    {
      ab.e("MicroMsg.NetSceneBatchGetContactProfile", "dealResp: resp is null");
      AppMethodBeat.o(24075);
      return false;
    }
    if (paramq.getRespObj().getRetCode() == 1)
    {
      ab.e("MicroMsg.NetSceneBatchGetContactProfile", "dealResp : endless loop, should stop");
      AppMethodBeat.o(24075);
      return false;
    }
    if (paramq.getRespObj().getRetCode() == -1)
    {
      ab.e("MicroMsg.NetSceneBatchGetContactProfile", "dealResp : server err, can try again");
      AppMethodBeat.o(24075);
      return true;
    }
    localObject1 = ((ik)localObject1).wuO;
    if (localObject1 == null)
    {
      AppMethodBeat.o(24075);
      return false;
    }
    int j = 0;
    while (j < ((List)localObject1).size()) {
      try
      {
        paramq = (vg)new vg().parseFrom(aa.a((SKBuiltinBuffer_t)((List)localObject1).get(j)));
        if ((paramq == null) || (paramq.jJA == null))
        {
          ab.e("MicroMsg.NetSceneBatchGetContactProfile", "processContactProfile: profile name is null");
          i = 0;
          if (i != 0) {
            break label644;
          }
          AppMethodBeat.o(24075);
          return false;
        }
      }
      catch (IOException paramq)
      {
        for (;;)
        {
          int i;
          ab.printErrStackTrace("MicroMsg.NetSceneBatchGetContactProfile", paramq, "", new Object[0]);
          ab.e("MicroMsg.NetSceneBatchGetContactProfile", "ContactProfile.parseFrom fail");
          paramq = null;
          continue;
          if (!this.pHK.contains(paramq.jJA))
          {
            ab.e("MicroMsg.NetSceneBatchGetContactProfile", "processContactProfile: resp data not in req");
            i = 0;
          }
          else
          {
            this.pHK.remove(paramq.jJA);
            aw.aaz();
            Object localObject2 = c.YA().arw(paramq.jJA);
            if ((localObject2 == null) || ((int)((com.tencent.mm.n.a)localObject2).euF == 0))
            {
              ab.e("MicroMsg.NetSceneBatchGetContactProfile", "processContactProfile: did not find this contact");
              i = 0;
            }
            else
            {
              ((ad)localObject2).setUsername(paramq.jJA);
              ((ad)localObject2).jm(paramq.gwU);
              ((ad)localObject2).setType(paramq.wNK & paramq.wNL);
              ((ad)localObject2).jp(paramq.jKG);
              ((ad)localObject2).jq(paramq.wNI);
              ((ad)localObject2).jr(paramq.wNJ);
              ((ad)localObject2).hy(paramq.gwP);
              ((ad)localObject2).jn(paramq.wNM);
              ((ad)localObject2).jt(paramq.wNP);
              ((ad)localObject2).ju(paramq.wNO);
              ((ad)localObject2).hA(paramq.wNQ);
              ((ad)localObject2).jo(paramq.wNT);
              ((ad)localObject2).hB(paramq.wNU);
              aw.aaz();
              if (c.YA().b(((aq)localObject2).field_username, (ad)localObject2) == -1) {
                ab.e("MicroMsg.NetSceneBatchGetContactProfile", "processContactProfile:update contact failed");
              }
              if (ad.are(paramq.jJA))
              {
                localObject2 = g.cdr().Xl(paramq.jJA);
                if ((localObject2 == null) || (bo.nullAsNil(((d)localObject2).getUsername()).length() <= 0))
                {
                  ab.e("MicroMsg.NetSceneBatchGetContactProfile", "processContactProfile: did not find qcontact");
                  i = 0;
                  continue;
                }
                ((d)localObject2).extInfo = paramq.nuz;
                ((d)localObject2).pHN = paramq.wNW;
                ((d)localObject2).pHO = paramq.wNX;
                ((d)localObject2).bsY = 52;
                if (!g.cdr().a(paramq.jJA, (d)localObject2)) {
                  ab.e("MicroMsg.NetSceneBatchGetContactProfile", "processContactProfile:update qcontact failed");
                }
              }
              if (ad.arc(paramq.jJA))
              {
                localObject2 = new ti();
                ((ti)localObject2).cJM.opType = 0;
                ((ti)localObject2).cJM.cDt = paramq.jJA;
                ((ti)localObject2).cJM.cDu = paramq.wNW;
                ((ti)localObject2).cJM.cDv = paramq.wNN;
                com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject2);
              }
              i = 1;
            }
          }
        }
        label644:
        j += 1;
      }
    }
    AppMethodBeat.o(24075);
    return true;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(24073);
    this.callback = paramf;
    paramf = new LinkedList();
    Object localObject = this.pHK.iterator();
    while (((Iterator)localObject).hasNext()) {
      paramf.add((String)((Iterator)localObject).next());
    }
    if (paramf.size() == 0)
    {
      ab.e("MicroMsg.NetSceneBatchGetContactProfile", com.tencent.mm.compatible.util.g.Ml() + "doScene reqSize ==0");
      AppMethodBeat.o(24073);
      return -1;
    }
    localObject = new b.a();
    ((b.a)localObject).fsX = new ij();
    ((b.a)localObject).fsY = new ik();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/batchgetcontactprofile";
    ((b.a)localObject).funcId = 140;
    ((b.a)localObject).reqCmdId = 28;
    ((b.a)localObject).respCmdId = 1000000028;
    localObject = ((b.a)localObject).ado();
    LinkedList localLinkedList = new LinkedList();
    paramf = paramf.iterator();
    while (paramf.hasNext()) {
      localLinkedList.add(aa.wA((String)paramf.next()));
    }
    ((ij)((com.tencent.mm.ai.b)localObject).fsV.fta).wou = localLinkedList;
    ((ij)((com.tencent.mm.ai.b)localObject).fsV.fta).wuN = 1;
    ((ij)((com.tencent.mm.ai.b)localObject).fsV.fta).jJu = localLinkedList.size();
    int i = dispatch(parame, (q)localObject, this);
    AppMethodBeat.o(24073);
    return i;
  }
  
  public final int getType()
  {
    return 140;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(24074);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(24074);
      return;
    }
    if ((g(paramq)) && (this.pHK.size() > 0)) {
      doScene(dispatcher(), this.callback);
    }
    ab.d("MicroMsg.NetSceneBatchGetContactProfile", "left cnt = " + this.pHK.size());
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(24074);
  }
  
  public final int securityLimitCount()
  {
    return 50;
  }
  
  public final m.b securityVerificationChecked(q paramq)
  {
    return m.b.ftu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.a.b
 * JD-Core Version:    0.7.0.1
 */