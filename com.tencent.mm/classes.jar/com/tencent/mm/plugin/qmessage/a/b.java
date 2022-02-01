package com.tencent.mm.plugin.qmessage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.q.b;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.g.a.xm;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.model.bg;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.adn;
import com.tencent.mm.protocal.protobuf.kk;
import com.tencent.mm.protocal.protobuf.kl;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import junit.framework.Assert;

public final class b
  extends q
  implements m
{
  private Set<String> Bqe;
  private i callback;
  
  public b(Set<String> paramSet)
  {
    AppMethodBeat.i(27712);
    Assert.assertTrue(true);
    this.Bqe = paramSet;
    AppMethodBeat.o(27712);
  }
  
  private boolean g(s params)
  {
    AppMethodBeat.i(27715);
    Object localObject1 = (kl)((com.tencent.mm.ak.d)params).iLL.iLR;
    if (localObject1 == null)
    {
      Log.e("MicroMsg.NetSceneBatchGetContactProfile", "dealResp: resp is null");
      AppMethodBeat.o(27715);
      return false;
    }
    if (params.getRespObj().getRetCode() == 1)
    {
      Log.e("MicroMsg.NetSceneBatchGetContactProfile", "dealResp : endless loop, should stop");
      AppMethodBeat.o(27715);
      return false;
    }
    if (params.getRespObj().getRetCode() == -1)
    {
      Log.e("MicroMsg.NetSceneBatchGetContactProfile", "dealResp : server err, can try again");
      AppMethodBeat.o(27715);
      return true;
    }
    localObject1 = ((kl)localObject1).KOD;
    if (localObject1 == null)
    {
      AppMethodBeat.o(27715);
      return false;
    }
    int j = 0;
    while (j < ((List)localObject1).size()) {
      try
      {
        params = (adn)new adn().parseFrom(z.a((SKBuiltinBuffer_t)((List)localObject1).get(j)));
        if ((params == null) || (params.UserName == null))
        {
          Log.e("MicroMsg.NetSceneBatchGetContactProfile", "processContactProfile: profile name is null");
          i = 0;
          if (i != 0) {
            break label644;
          }
          AppMethodBeat.o(27715);
          return false;
        }
      }
      catch (IOException params)
      {
        for (;;)
        {
          int i;
          Log.printErrStackTrace("MicroMsg.NetSceneBatchGetContactProfile", params, "", new Object[0]);
          Log.e("MicroMsg.NetSceneBatchGetContactProfile", "ContactProfile.parseFrom fail");
          params = null;
          continue;
          if (!this.Bqe.contains(params.UserName))
          {
            Log.e("MicroMsg.NetSceneBatchGetContactProfile", "processContactProfile: resp data not in req");
            i = 0;
          }
          else
          {
            this.Bqe.remove(params.UserName);
            bg.aVF();
            Object localObject2 = com.tencent.mm.model.c.aSN().Kn(params.UserName);
            if ((localObject2 == null) || ((int)((com.tencent.mm.contact.c)localObject2).gMZ == 0))
            {
              Log.e("MicroMsg.NetSceneBatchGetContactProfile", "processContactProfile: did not find this contact");
              i = 0;
            }
            else
            {
              ((as)localObject2).setUsername(params.UserName);
              ((as)localObject2).BC(params.ked);
              ((as)localObject2).setType(params.LoG & params.LoH);
              ((as)localObject2).setNickname(params.oUJ);
              ((as)localObject2).BF(params.LoE);
              ((as)localObject2).BG(params.LoF);
              ((as)localObject2).nj(params.kdY);
              ((as)localObject2).BD(params.LoI);
              ((as)localObject2).BI(params.LoL);
              ((as)localObject2).BJ(params.LoK);
              ((as)localObject2).nl(params.LoM);
              ((as)localObject2).BE(params.LoP);
              ((as)localObject2).nm(params.LoQ);
              bg.aVF();
              if (com.tencent.mm.model.c.aSN().c(((ax)localObject2).field_username, (as)localObject2) == -1) {
                Log.e("MicroMsg.NetSceneBatchGetContactProfile", "processContactProfile:update contact failed");
              }
              if (as.bjo(params.UserName))
              {
                localObject2 = g.eFZ().aKB(params.UserName);
                if ((localObject2 == null) || (Util.nullAsNil(((d)localObject2).getUsername()).length() <= 0))
                {
                  Log.e("MicroMsg.NetSceneBatchGetContactProfile", "processContactProfile: did not find qcontact");
                  i = 0;
                  continue;
                }
                ((d)localObject2).extInfo = params.xNU;
                ((d)localObject2).Bqh = params.LoS;
                ((d)localObject2).Bqi = params.LoT;
                ((d)localObject2).cSx = 52;
                if (!g.eFZ().a(params.UserName, (d)localObject2)) {
                  Log.e("MicroMsg.NetSceneBatchGetContactProfile", "processContactProfile:update qcontact failed");
                }
              }
              if (as.bjm(params.UserName))
              {
                localObject2 = new xm();
                ((xm)localObject2).edJ.opType = 0;
                ((xm)localObject2).edJ.dWq = params.UserName;
                ((xm)localObject2).edJ.dWr = params.LoS;
                ((xm)localObject2).edJ.dWs = params.LoJ;
                EventCenter.instance.publish((IEvent)localObject2);
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
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(27713);
    this.callback = parami;
    parami = new LinkedList();
    Object localObject = this.Bqe.iterator();
    while (((Iterator)localObject).hasNext()) {
      parami.add((String)((Iterator)localObject).next());
    }
    if (parami.size() == 0)
    {
      Log.e("MicroMsg.NetSceneBatchGetContactProfile", f.apq() + "doScene reqSize ==0");
      AppMethodBeat.o(27713);
      return -1;
    }
    localObject = new d.a();
    ((d.a)localObject).iLN = new kk();
    ((d.a)localObject).iLO = new kl();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/batchgetcontactprofile";
    ((d.a)localObject).funcId = 140;
    ((d.a)localObject).iLP = 28;
    ((d.a)localObject).respCmdId = 1000000028;
    localObject = ((d.a)localObject).aXF();
    LinkedList localLinkedList = new LinkedList();
    parami = parami.iterator();
    while (parami.hasNext()) {
      localLinkedList.add(z.Su((String)parami.next()));
    }
    ((kk)((com.tencent.mm.ak.d)localObject).iLK.iLR).KGP = localLinkedList;
    ((kk)((com.tencent.mm.ak.d)localObject).iLK.iLR).KOC = 1;
    ((kk)((com.tencent.mm.ak.d)localObject).iLK.iLR).oTz = localLinkedList.size();
    int i = dispatch(paramg, (s)localObject, this);
    AppMethodBeat.o(27713);
    return i;
  }
  
  public final int getType()
  {
    return 140;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(27714);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(27714);
      return;
    }
    if ((g(params)) && (this.Bqe.size() > 0)) {
      doScene(dispatcher(), this.callback);
    }
    Log.d("MicroMsg.NetSceneBatchGetContactProfile", "left cnt = " + this.Bqe.size());
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(27714);
  }
  
  public final int securityLimitCount()
  {
    return 50;
  }
  
  public final q.b securityVerificationChecked(s params)
  {
    return q.b.iMq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.a.b
 * JD-Core Version:    0.7.0.1
 */