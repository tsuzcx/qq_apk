package com.tencent.mm.plugin.qmessage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.q.b;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.f.a.ys;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.adu;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.ka;
import com.tencent.mm.protocal.protobuf.kb;
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
  private Set<String> Hkx;
  private i callback;
  
  public b(Set<String> paramSet)
  {
    AppMethodBeat.i(27712);
    Assert.assertTrue(true);
    this.Hkx = paramSet;
    AppMethodBeat.o(27712);
  }
  
  private boolean h(s params)
  {
    AppMethodBeat.i(27715);
    Object localObject1 = (kb)d.c.b(((com.tencent.mm.an.d)params).lBS);
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
    localObject1 = ((kb)localObject1).RPB;
    if (localObject1 == null)
    {
      AppMethodBeat.o(27715);
      return false;
    }
    int j = 0;
    while (j < ((List)localObject1).size()) {
      try
      {
        params = (adu)new adu().parseFrom(z.a((eae)((List)localObject1).get(j)));
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
          if (!this.Hkx.contains(params.UserName))
          {
            Log.e("MicroMsg.NetSceneBatchGetContactProfile", "processContactProfile: resp data not in req");
            i = 0;
          }
          else
          {
            this.Hkx.remove(params.UserName);
            bh.beI();
            Object localObject2 = c.bbL().RG(params.UserName);
            if ((localObject2 == null) || ((int)((com.tencent.mm.contact.d)localObject2).jxt == 0))
            {
              Log.e("MicroMsg.NetSceneBatchGetContactProfile", "processContactProfile: did not find this contact");
              i = 0;
            }
            else
            {
              ((as)localObject2).setUsername(params.UserName);
              ((as)localObject2).Iq(params.mVD);
              ((as)localObject2).setType(params.Sqc & params.Sqd);
              ((as)localObject2).setNickname(params.rWI);
              ((as)localObject2).It(params.Sqa);
              ((as)localObject2).Iu(params.Sqb);
              ((as)localObject2).pw(params.mVy);
              ((as)localObject2).Ir(params.Sqe);
              ((as)localObject2).Iw(params.Sqh);
              ((as)localObject2).Ix(params.Sqg);
              ((as)localObject2).pz(params.Sqi);
              ((as)localObject2).Is(params.Sql);
              ((as)localObject2).pA(params.Sqm);
              bh.beI();
              if (c.bbL().c(((ax)localObject2).field_username, (as)localObject2) == -1) {
                Log.e("MicroMsg.NetSceneBatchGetContactProfile", "processContactProfile:update contact failed");
              }
              if (as.bvJ(params.UserName))
              {
                localObject2 = g.fsa().aVb(params.UserName);
                if ((localObject2 == null) || (Util.nullAsNil(((d)localObject2).getUsername()).length() <= 0))
                {
                  Log.e("MicroMsg.NetSceneBatchGetContactProfile", "processContactProfile: did not find qcontact");
                  i = 0;
                  continue;
                }
                ((d)localObject2).extInfo = params.CSe;
                ((d)localObject2).HkA = params.Sqo;
                ((d)localObject2).HkB = params.Sqp;
                ((d)localObject2).cUP = 52;
                if (!g.fsa().a(params.UserName, (d)localObject2)) {
                  Log.e("MicroMsg.NetSceneBatchGetContactProfile", "processContactProfile:update qcontact failed");
                }
              }
              if (as.bvH(params.UserName))
              {
                localObject2 = new ys();
                ((ys)localObject2).fXS.opType = 0;
                ((ys)localObject2).fXS.fPV = params.UserName;
                ((ys)localObject2).fXS.fPW = params.Sqo;
                ((ys)localObject2).fXS.fPX = params.Sqf;
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
    Object localObject = this.Hkx.iterator();
    while (((Iterator)localObject).hasNext()) {
      parami.add((String)((Iterator)localObject).next());
    }
    if (parami.size() == 0)
    {
      Log.e("MicroMsg.NetSceneBatchGetContactProfile", f.avD() + "doScene reqSize ==0");
      AppMethodBeat.o(27713);
      return -1;
    }
    localObject = new d.a();
    ((d.a)localObject).lBU = new ka();
    ((d.a)localObject).lBV = new kb();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/batchgetcontactprofile";
    ((d.a)localObject).funcId = 140;
    ((d.a)localObject).lBW = 28;
    ((d.a)localObject).respCmdId = 1000000028;
    localObject = ((d.a)localObject).bgN();
    LinkedList localLinkedList = new LinkedList();
    parami = parami.iterator();
    while (parami.hasNext()) {
      localLinkedList.add(z.ZW((String)parami.next()));
    }
    ((ka)d.b.b(((com.tencent.mm.an.d)localObject).lBR)).RIj = localLinkedList;
    ((ka)d.b.b(((com.tencent.mm.an.d)localObject).lBR)).RPA = 1;
    ((ka)d.b.b(((com.tencent.mm.an.d)localObject).lBR)).rVx = localLinkedList.size();
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
    if ((h(params)) && (this.Hkx.size() > 0)) {
      doScene(dispatcher(), this.callback);
    }
    Log.d("MicroMsg.NetSceneBatchGetContactProfile", "left cnt = " + this.Hkx.size());
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(27714);
  }
  
  public final int securityLimitCount()
  {
    return 50;
  }
  
  public final q.b securityVerificationChecked(s params)
  {
    return q.b.lCx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.a.b
 * JD-Core Version:    0.7.0.1
 */