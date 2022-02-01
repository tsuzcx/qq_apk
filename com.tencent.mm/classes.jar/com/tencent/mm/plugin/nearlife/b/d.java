package com.tencent.mm.plugin.nearlife.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cma;
import com.tencent.mm.protocal.protobuf.cmb;
import com.tencent.mm.protocal.protobuf.dgz;
import com.tencent.mm.protocal.protobuf.dha;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public final class d
  extends p
  implements m
{
  public static Vector<String> MpU;
  public boolean AXC;
  public int Kcm;
  public String MpV;
  public String MpW;
  public List<b> MpX;
  private h callback;
  public int hHC;
  public String mpa;
  final c rr;
  
  static
  {
    AppMethodBeat.i(26558);
    MpU = new Vector();
    AppMethodBeat.o(26558);
  }
  
  public d(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, int paramInt3, int paramInt4, String paramString1, String paramString2, gol paramgol, String paramString3, int paramInt5, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(26554);
    this.hHC = 0;
    this.MpV = "";
    this.MpW = "";
    this.mpa = "";
    this.MpV = paramString3;
    if ((paramInt1 != 0) && (paramInt1 != 1)) {
      Log.e("MicroMsg.NetSceneGetLbsLifeList", "OpCode Error :".concat(String.valueOf(paramInt1)));
    }
    this.hHC = paramInt1;
    Object localObject = new c.a();
    ((c.a)localObject).otE = new cma();
    ((c.a)localObject).otF = new cmb();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/getlbslifelist";
    ((c.a)localObject).funcId = 603;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (cma)c.b.b(this.rr.otB);
    dha localdha = new dha();
    localdha.Zyn = paramString2;
    localdha.Zyo = paramInt4;
    localdha.ZaH = paramFloat2;
    localdha.ZaG = paramFloat1;
    localdha.Zym = paramString1;
    localdha.Zyl = paramInt3;
    ((cma)localObject).Zqj = localdha;
    ((cma)localObject).aakp = paramString3;
    ((cma)localObject).IJG = paramInt2;
    ((cma)localObject).aatU = paramInt5;
    if (paramgol == null)
    {
      ((cma)localObject).aatT = new gol().df(new byte[0]);
      ((cma)localObject).YKH = paramInt1;
      if (!paramBoolean2) {
        break label427;
      }
    }
    label427:
    for (int i = 1;; i = 0)
    {
      ((cma)localObject).aatV = i;
      this.AXC = paramBoolean1;
      Log.d("MicroMsg.NetSceneGetLbsLifeList", "Req: opcode:" + paramInt1 + " lon:" + paramFloat1 + " lat:" + paramFloat2 + " pre:" + paramInt3 + " gpsSource:" + paramInt4 + " mac" + paramString1 + " cell:" + paramString2 + " scene: " + paramInt2 + " entryTime: " + paramInt5);
      Log.d("MicroMsg.NetSceneGetLbsLifeList", "isLoadMore: %s, buf: %s", new Object[] { Boolean.valueOf(paramBoolean1), Integer.valueOf(((cma)localObject).aatT.abwJ) });
      AppMethodBeat.o(26554);
      return;
      ((cma)localObject).aatT = paramgol;
      break;
    }
  }
  
  public d(dha paramdha)
  {
    AppMethodBeat.i(163197);
    this.hHC = 0;
    this.MpV = "";
    this.MpW = "";
    this.mpa = "";
    this.hHC = 0;
    Object localObject = new c.a();
    ((c.a)localObject).otE = new cma();
    ((c.a)localObject).otF = new cmb();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/getlbslifelist";
    ((c.a)localObject).funcId = 603;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (cma)c.b.b(this.rr.otB);
    ((cma)localObject).Zqj = paramdha;
    ((cma)localObject).aakp = this.MpV;
    ((cma)localObject).IJG = 6;
    ((cma)localObject).aatT = new gol().df(new byte[0]);
    ((cma)localObject).YKH = 0;
    AppMethodBeat.o(163197);
  }
  
  public static boolean aey(int paramInt)
  {
    AppMethodBeat.i(26551);
    String str = String.valueOf(paramInt);
    if (MpU.contains(str))
    {
      AppMethodBeat.o(26551);
      return false;
    }
    MpU.add(str);
    AppMethodBeat.o(26551);
    return true;
  }
  
  public static boolean aez(int paramInt)
  {
    AppMethodBeat.i(26552);
    MpU.remove(String.valueOf(paramInt));
    AppMethodBeat.o(26552);
    return true;
  }
  
  public static void clear()
  {
    AppMethodBeat.i(26553);
    MpU.clear();
    AppMethodBeat.o(26553);
  }
  
  public final int dVZ()
  {
    AppMethodBeat.i(267295);
    int i = ((cmb)c.c.b(this.rr.otC)).YYp;
    AppMethodBeat.o(267295);
    return i;
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(26555);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(26555);
    return i;
  }
  
  public final int getType()
  {
    return 603;
  }
  
  public final gol gsS()
  {
    AppMethodBeat.i(26557);
    gol localgol = ((cmb)c.c.b(this.rr.otC)).aatT;
    if (localgol == null)
    {
      localgol = new gol().df(new byte[0]);
      AppMethodBeat.o(26557);
      return localgol;
    }
    AppMethodBeat.o(26557);
    return localgol;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(26556);
    Log.d("MicroMsg.NetSceneGetLbsLifeList", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
    params = (cmb)c.c.b(((c)params).otC);
    this.mpa = params.YYr;
    this.Kcm = params.aaud;
    Log.d("MicroMsg.NetSceneGetLbsLifeList", "resp " + params.aaua + "searchId " + this.mpa);
    if ((paramInt3 == 0) || (paramInt3 == 101)) {}
    for (paramInt1 = 1; (paramInt2 != 0) && (paramInt1 == 0); paramInt1 = 0)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(26556);
      return;
    }
    Log.d("MicroMsg.NetSceneGetLbsLifeList", "continueFlag %d lifeCount %d linkCount %d %s", new Object[] { Integer.valueOf(params.YYp), Integer.valueOf(params.aaua), Integer.valueOf(params.aatY), params.aauc });
    this.MpW = Util.nullAs(params.aauc, "");
    this.MpX = new ArrayList();
    paramArrayOfByte = params.aaub.iterator();
    Object localObject;
    while (paramArrayOfByte.hasNext())
    {
      localObject = (dgz)paramArrayOfByte.next();
      localObject = new b(params.YYr, (dgz)localObject);
      this.MpX.add(localObject);
    }
    if (params.aaua > 0)
    {
      paramArrayOfByte = (dgz)params.aaub.get(0);
      params = new StringBuffer();
      params.append(" Bid " + paramArrayOfByte.MpI);
      params.append(" title " + paramArrayOfByte.hAP);
      params.append(" link " + paramArrayOfByte.MpP);
      params.append(" price " + paramArrayOfByte.MpJ);
      params.append(" rate " + paramArrayOfByte.MpO);
      params.append(" type " + paramArrayOfByte.vhJ);
      params.append(" desc : ");
      paramArrayOfByte = paramArrayOfByte.MpN.iterator();
      while (paramArrayOfByte.hasNext())
      {
        localObject = (etl)paramArrayOfByte.next();
        params.append(((etl)localObject).abwM + "-");
      }
      Log.d("MicroMsg.NetSceneGetLbsLifeList", "resp one %s ", new Object[] { params.toString() });
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(26556);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.b.d
 * JD-Core Version:    0.7.0.1
 */