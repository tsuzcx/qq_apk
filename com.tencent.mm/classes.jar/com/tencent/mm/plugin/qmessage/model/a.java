package com.tencent.mm.plugin.qmessage.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.am.p.b;
import com.tencent.mm.autogen.a.aal;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.model.bh;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.agd;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.protocal.protobuf.kw;
import com.tencent.mm.protocal.protobuf.kx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import junit.framework.Assert;

public final class a
  extends p
  implements m
{
  private Set<String> Nik;
  private h callback;
  
  public a(Set<String> paramSet)
  {
    AppMethodBeat.i(27712);
    Assert.assertTrue(true);
    this.Nik = paramSet;
    AppMethodBeat.o(27712);
  }
  
  private boolean h(s params)
  {
    AppMethodBeat.i(27715);
    Object localObject1 = (kx)c.c.b(((com.tencent.mm.am.c)params).otC);
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
    localObject1 = ((kx)localObject1).YMP;
    if (localObject1 == null)
    {
      AppMethodBeat.o(27715);
      return false;
    }
    int j = 0;
    while (j < ((List)localObject1).size()) {
      try
      {
        params = (agd)new agd().parseFrom(w.a((gol)((List)localObject1).get(j)));
        if ((params == null) || (params.UserName == null))
        {
          Log.e("MicroMsg.NetSceneBatchGetContactProfile", "processContactProfile: profile name is null");
          i = 0;
          if (i != 0) {
            break label641;
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
          if (!this.Nik.contains(params.UserName))
          {
            Log.e("MicroMsg.NetSceneBatchGetContactProfile", "processContactProfile: resp data not in req");
            i = 0;
          }
          else
          {
            this.Nik.remove(params.UserName);
            bh.bCz();
            Object localObject2 = com.tencent.mm.model.c.bzA().JE(params.UserName);
            if ((localObject2 == null) || ((int)((com.tencent.mm.contact.d)localObject2).maN == 0))
            {
              Log.e("MicroMsg.NetSceneBatchGetContactProfile", "processContactProfile: did not find this contact");
              i = 0;
            }
            else
            {
              ((au)localObject2).setUsername(params.UserName);
              ((au)localObject2).AV(params.pSk);
              ((au)localObject2).setType(params.ZoY & params.ZoZ);
              ((au)localObject2).setNickname(params.vhX);
              ((au)localObject2).AY(params.ZoW);
              ((au)localObject2).AZ(params.ZoX);
              ((au)localObject2).pv(params.pSf);
              ((au)localObject2).AW(params.Zpa);
              ((au)localObject2).Bb(params.Zpd);
              ((au)localObject2).Bc(params.Zpc);
              ((au)localObject2).py(params.Zpe);
              ((au)localObject2).AX(params.Zph);
              ((au)localObject2).pz(params.Zpi);
              bh.bCz();
              if (com.tencent.mm.model.c.bzA().d(((az)localObject2).field_username, (au)localObject2) == -1) {
                Log.e("MicroMsg.NetSceneBatchGetContactProfile", "processContactProfile:update contact failed");
              }
              if (au.bwN(params.UserName))
              {
                localObject2 = f.gDI().aSj(params.UserName);
                if ((localObject2 == null) || (Util.nullAsNil(((c)localObject2).getUsername()).length() <= 0))
                {
                  Log.e("MicroMsg.NetSceneBatchGetContactProfile", "processContactProfile: did not find qcontact");
                  i = 0;
                  continue;
                }
                ((c)localObject2).extInfo = params.IMu;
                ((c)localObject2).Nin = params.Zpk;
                ((c)localObject2).Nio = params.Zpl;
                ((c)localObject2).eQp = 52;
                if (!f.gDI().a(params.UserName, (c)localObject2)) {
                  Log.e("MicroMsg.NetSceneBatchGetContactProfile", "processContactProfile:update qcontact failed");
                }
              }
              if (au.bwL(params.UserName))
              {
                localObject2 = new aal();
                ((aal)localObject2).idS.opType = 0;
                ((aal)localObject2).idS.hVQ = params.UserName;
                ((aal)localObject2).idS.hVR = params.Zpk;
                ((aal)localObject2).idS.hVS = params.Zpb;
                ((aal)localObject2).publish();
              }
              i = 1;
            }
          }
        }
        label641:
        j += 1;
      }
    }
    AppMethodBeat.o(27715);
    return true;
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(27713);
    this.callback = paramh;
    paramh = new LinkedList();
    Object localObject = this.Nik.iterator();
    while (((Iterator)localObject).hasNext()) {
      paramh.add((String)((Iterator)localObject).next());
    }
    if (paramh.size() == 0)
    {
      Log.e("MicroMsg.NetSceneBatchGetContactProfile", com.tencent.mm.compatible.util.f.aPX() + "doScene reqSize ==0");
      AppMethodBeat.o(27713);
      return -1;
    }
    localObject = new c.a();
    ((c.a)localObject).otE = new kw();
    ((c.a)localObject).otF = new kx();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/batchgetcontactprofile";
    ((c.a)localObject).funcId = 140;
    ((c.a)localObject).otG = 28;
    ((c.a)localObject).respCmdId = 1000000028;
    localObject = ((c.a)localObject).bEF();
    LinkedList localLinkedList = new LinkedList();
    paramh = paramh.iterator();
    while (paramh.hasNext()) {
      localLinkedList.add(w.Sk((String)paramh.next()));
    }
    ((kw)c.b.b(((com.tencent.mm.am.c)localObject).otB)).YFl = localLinkedList;
    ((kw)c.b.b(((com.tencent.mm.am.c)localObject).otB)).YMO = 1;
    ((kw)c.b.b(((com.tencent.mm.am.c)localObject).otB)).vgN = localLinkedList.size();
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
    if ((h(params)) && (this.Nik.size() > 0)) {
      doScene(dispatcher(), this.callback);
    }
    Log.d("MicroMsg.NetSceneBatchGetContactProfile", "left cnt = " + this.Nik.size());
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(27714);
  }
  
  public final int securityLimitCount()
  {
    return 50;
  }
  
  public final p.b securityVerificationChecked(s params)
  {
    return p.b.ouh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.model.a
 * JD-Core Version:    0.7.0.1
 */