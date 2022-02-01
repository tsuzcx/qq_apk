package com.tencent.mm.plugin.qmessage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.g.a.wm;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.bc;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.abm;
import com.tencent.mm.protocal.protobuf.jv;
import com.tencent.mm.protocal.protobuf.jw;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
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
  private com.tencent.mm.ak.f callback;
  private Set<String> xpS;
  
  public b(Set<String> paramSet)
  {
    AppMethodBeat.i(27712);
    Assert.assertTrue(true);
    this.xpS = paramSet;
    AppMethodBeat.o(27712);
  }
  
  private boolean g(q paramq)
  {
    AppMethodBeat.i(27715);
    Object localObject1 = (jw)((com.tencent.mm.ak.b)paramq).hQE.hQJ;
    if (localObject1 == null)
    {
      ae.e("MicroMsg.NetSceneBatchGetContactProfile", "dealResp: resp is null");
      AppMethodBeat.o(27715);
      return false;
    }
    if (paramq.getRespObj().getRetCode() == 1)
    {
      ae.e("MicroMsg.NetSceneBatchGetContactProfile", "dealResp : endless loop, should stop");
      AppMethodBeat.o(27715);
      return false;
    }
    if (paramq.getRespObj().getRetCode() == -1)
    {
      ae.e("MicroMsg.NetSceneBatchGetContactProfile", "dealResp : server err, can try again");
      AppMethodBeat.o(27715);
      return true;
    }
    localObject1 = ((jw)localObject1).FUV;
    if (localObject1 == null)
    {
      AppMethodBeat.o(27715);
      return false;
    }
    int j = 0;
    while (j < ((List)localObject1).size()) {
      try
      {
        paramq = (abm)new abm().parseFrom(z.a((SKBuiltinBuffer_t)((List)localObject1).get(j)));
        if ((paramq == null) || (paramq.nIJ == null))
        {
          ae.e("MicroMsg.NetSceneBatchGetContactProfile", "processContactProfile: profile name is null");
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
          ae.printErrStackTrace("MicroMsg.NetSceneBatchGetContactProfile", paramq, "", new Object[0]);
          ae.e("MicroMsg.NetSceneBatchGetContactProfile", "ContactProfile.parseFrom fail");
          paramq = null;
          continue;
          if (!this.xpS.contains(paramq.nIJ))
          {
            ae.e("MicroMsg.NetSceneBatchGetContactProfile", "processContactProfile: resp data not in req");
            i = 0;
          }
          else
          {
            this.xpS.remove(paramq.nIJ);
            bc.aCg();
            Object localObject2 = com.tencent.mm.model.c.azF().BH(paramq.nIJ);
            if ((localObject2 == null) || ((int)((com.tencent.mm.contact.c)localObject2).ght == 0))
            {
              ae.e("MicroMsg.NetSceneBatchGetContactProfile", "processContactProfile: did not find this contact");
              i = 0;
            }
            else
            {
              ((an)localObject2).setUsername(paramq.nIJ);
              ((an)localObject2).tl(paramq.jga);
              ((an)localObject2).setType(paramq.Gti & paramq.Gtj);
              ((an)localObject2).to(paramq.nJO);
              ((an)localObject2).tp(paramq.Gtg);
              ((an)localObject2).tq(paramq.Gth);
              ((an)localObject2).kh(paramq.jfV);
              ((an)localObject2).tm(paramq.Gtk);
              ((an)localObject2).ts(paramq.Gtn);
              ((an)localObject2).tt(paramq.Gtm);
              ((an)localObject2).kj(paramq.Gto);
              ((an)localObject2).tn(paramq.Gtr);
              ((an)localObject2).kk(paramq.Gts);
              bc.aCg();
              if (com.tencent.mm.model.c.azF().c(((aw)localObject2).field_username, (an)localObject2) == -1) {
                ae.e("MicroMsg.NetSceneBatchGetContactProfile", "processContactProfile:update contact failed");
              }
              if (an.aUp(paramq.nIJ))
              {
                localObject2 = g.dFk().awi(paramq.nIJ);
                if ((localObject2 == null) || (bu.nullAsNil(((d)localObject2).getUsername()).length() <= 0))
                {
                  ae.e("MicroMsg.NetSceneBatchGetContactProfile", "processContactProfile: did not find qcontact");
                  i = 0;
                  continue;
                }
                ((d)localObject2).extInfo = paramq.uvT;
                ((d)localObject2).xpV = paramq.Gtu;
                ((d)localObject2).xpW = paramq.Gtv;
                ((d)localObject2).dEu = 52;
                if (!g.dFk().a(paramq.nIJ, (d)localObject2)) {
                  ae.e("MicroMsg.NetSceneBatchGetContactProfile", "processContactProfile:update qcontact failed");
                }
              }
              if (an.aUn(paramq.nIJ))
              {
                localObject2 = new wm();
                ((wm)localObject2).dLU.opType = 0;
                ((wm)localObject2).dLU.dED = paramq.nIJ;
                ((wm)localObject2).dLU.dEE = paramq.Gtu;
                ((wm)localObject2).dLU.dEF = paramq.Gtl;
                a.IvT.l((com.tencent.mm.sdk.b.b)localObject2);
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
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.f paramf)
  {
    AppMethodBeat.i(27713);
    this.callback = paramf;
    paramf = new LinkedList();
    Object localObject = this.xpS.iterator();
    while (((Iterator)localObject).hasNext()) {
      paramf.add((String)((Iterator)localObject).next());
    }
    if (paramf.size() == 0)
    {
      ae.e("MicroMsg.NetSceneBatchGetContactProfile", com.tencent.mm.compatible.util.f.abr() + "doScene reqSize ==0");
      AppMethodBeat.o(27713);
      return -1;
    }
    localObject = new b.a();
    ((b.a)localObject).hQF = new jv();
    ((b.a)localObject).hQG = new jw();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/batchgetcontactprofile";
    ((b.a)localObject).funcId = 140;
    ((b.a)localObject).hQH = 28;
    ((b.a)localObject).respCmdId = 1000000028;
    localObject = ((b.a)localObject).aDS();
    LinkedList localLinkedList = new LinkedList();
    paramf = paramf.iterator();
    while (paramf.hasNext()) {
      localLinkedList.add(z.Jw((String)paramf.next()));
    }
    ((jv)((com.tencent.mm.ak.b)localObject).hQD.hQJ).FNk = localLinkedList;
    ((jv)((com.tencent.mm.ak.b)localObject).hQD.hQJ).FUU = 1;
    ((jv)((com.tencent.mm.ak.b)localObject).hQD.hQJ).nID = localLinkedList.size();
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
    if ((g(paramq)) && (this.xpS.size() > 0)) {
      doScene(dispatcher(), this.callback);
    }
    ae.d("MicroMsg.NetSceneBatchGetContactProfile", "left cnt = " + this.xpS.size());
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(27714);
  }
  
  public final int securityLimitCount()
  {
    return 50;
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    return n.b.hRi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.a.b
 * JD-Core Version:    0.7.0.1
 */