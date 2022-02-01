package com.tencent.mm.plugin.qmessage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.g.a.vp;
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.jm;
import com.tencent.mm.protocal.protobuf.jn;
import com.tencent.mm.protocal.protobuf.zd;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
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
  private com.tencent.mm.ak.g callback;
  private Set<String> vSR;
  
  public b(Set<String> paramSet)
  {
    AppMethodBeat.i(27712);
    Assert.assertTrue(true);
    this.vSR = paramSet;
    AppMethodBeat.o(27712);
  }
  
  private boolean g(q paramq)
  {
    AppMethodBeat.i(27715);
    Object localObject1 = (jn)((com.tencent.mm.ak.b)paramq).hvs.hvw;
    if (localObject1 == null)
    {
      ac.e("MicroMsg.NetSceneBatchGetContactProfile", "dealResp: resp is null");
      AppMethodBeat.o(27715);
      return false;
    }
    if (paramq.getRespObj().getRetCode() == 1)
    {
      ac.e("MicroMsg.NetSceneBatchGetContactProfile", "dealResp : endless loop, should stop");
      AppMethodBeat.o(27715);
      return false;
    }
    if (paramq.getRespObj().getRetCode() == -1)
    {
      ac.e("MicroMsg.NetSceneBatchGetContactProfile", "dealResp : server err, can try again");
      AppMethodBeat.o(27715);
      return true;
    }
    localObject1 = ((jn)localObject1).DXe;
    if (localObject1 == null)
    {
      AppMethodBeat.o(27715);
      return false;
    }
    int j = 0;
    while (j < ((List)localObject1).size()) {
      try
      {
        paramq = (zd)new zd().parseFrom(z.a((SKBuiltinBuffer_t)((List)localObject1).get(j)));
        if ((paramq == null) || (paramq.ncR == null))
        {
          ac.e("MicroMsg.NetSceneBatchGetContactProfile", "processContactProfile: profile name is null");
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
          ac.printErrStackTrace("MicroMsg.NetSceneBatchGetContactProfile", paramq, "", new Object[0]);
          ac.e("MicroMsg.NetSceneBatchGetContactProfile", "ContactProfile.parseFrom fail");
          paramq = null;
          continue;
          if (!this.vSR.contains(paramq.ncR))
          {
            ac.e("MicroMsg.NetSceneBatchGetContactProfile", "processContactProfile: resp data not in req");
            i = 0;
          }
          else
          {
            this.vSR.remove(paramq.ncR);
            az.ayM();
            Object localObject2 = c.awB().aNt(paramq.ncR);
            if ((localObject2 == null) || ((int)((com.tencent.mm.n.b)localObject2).fLJ == 0))
            {
              ac.e("MicroMsg.NetSceneBatchGetContactProfile", "processContactProfile: did not find this contact");
              i = 0;
            }
            else
            {
              ((ai)localObject2).setUsername(paramq.ncR);
              ((ai)localObject2).qg(paramq.iJY);
              ((ai)localObject2).setType(paramq.Etk & paramq.Etl);
              ((ai)localObject2).qj(paramq.ndW);
              ((ai)localObject2).qk(paramq.Eti);
              ((ai)localObject2).ql(paramq.Etj);
              ((ai)localObject2).jH(paramq.iJT);
              ((ai)localObject2).qh(paramq.Etm);
              ((ai)localObject2).qn(paramq.Etp);
              ((ai)localObject2).qo(paramq.Eto);
              ((ai)localObject2).jJ(paramq.Etq);
              ((ai)localObject2).qi(paramq.Ett);
              ((ai)localObject2).jK(paramq.Etu);
              az.ayM();
              if (c.awB().c(((av)localObject2).field_username, (ai)localObject2) == -1) {
                ac.e("MicroMsg.NetSceneBatchGetContactProfile", "processContactProfile:update contact failed");
              }
              if (ai.aNb(paramq.ncR))
              {
                localObject2 = g.drr().apN(paramq.ncR);
                if ((localObject2 == null) || (bs.nullAsNil(((d)localObject2).getUsername()).length() <= 0))
                {
                  ac.e("MicroMsg.NetSceneBatchGetContactProfile", "processContactProfile: did not find qcontact");
                  i = 0;
                  continue;
                }
                ((d)localObject2).extInfo = paramq.tlX;
                ((d)localObject2).vSU = paramq.Etw;
                ((d)localObject2).vSV = paramq.Etx;
                ((d)localObject2).drx = 52;
                if (!g.drr().a(paramq.ncR, (d)localObject2)) {
                  ac.e("MicroMsg.NetSceneBatchGetContactProfile", "processContactProfile:update qcontact failed");
                }
              }
              if (ai.aMZ(paramq.ncR))
              {
                localObject2 = new vp();
                ((vp)localObject2).dys.opType = 0;
                ((vp)localObject2).dys.drG = paramq.ncR;
                ((vp)localObject2).dys.drH = paramq.Etw;
                ((vp)localObject2).dys.drI = paramq.Etn;
                a.GpY.l((com.tencent.mm.sdk.b.b)localObject2);
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
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(27713);
    this.callback = paramg;
    paramg = new LinkedList();
    Object localObject = this.vSR.iterator();
    while (((Iterator)localObject).hasNext()) {
      paramg.add((String)((Iterator)localObject).next());
    }
    if (paramg.size() == 0)
    {
      ac.e("MicroMsg.NetSceneBatchGetContactProfile", f.YG() + "doScene reqSize ==0");
      AppMethodBeat.o(27713);
      return -1;
    }
    localObject = new b.a();
    ((b.a)localObject).hvt = new jm();
    ((b.a)localObject).hvu = new jn();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/batchgetcontactprofile";
    ((b.a)localObject).funcId = 140;
    ((b.a)localObject).reqCmdId = 28;
    ((b.a)localObject).respCmdId = 1000000028;
    localObject = ((b.a)localObject).aAz();
    LinkedList localLinkedList = new LinkedList();
    paramg = paramg.iterator();
    while (paramg.hasNext()) {
      localLinkedList.add(z.FI((String)paramg.next()));
    }
    ((jm)((com.tencent.mm.ak.b)localObject).hvr.hvw).DPy = localLinkedList;
    ((jm)((com.tencent.mm.ak.b)localObject).hvr.hvw).DXd = 1;
    ((jm)((com.tencent.mm.ak.b)localObject).hvr.hvw).ncL = localLinkedList.size();
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
    if ((g(paramq)) && (this.vSR.size() > 0)) {
      doScene(dispatcher(), this.callback);
    }
    ac.d("MicroMsg.NetSceneBatchGetContactProfile", "left cnt = " + this.vSR.size());
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(27714);
  }
  
  public final int securityLimitCount()
  {
    return 50;
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    return n.b.hwa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.a.b
 * JD-Core Version:    0.7.0.1
 */