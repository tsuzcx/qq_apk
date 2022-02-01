package com.tencent.mm.plugin.nearlife.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bwx;
import com.tencent.mm.protocal.protobuf.bwy;
import com.tencent.mm.protocal.protobuf.cqf;
import com.tencent.mm.protocal.protobuf.cqg;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public final class d
  extends q
  implements m
{
  public static Vector<String> GtU;
  public int EjD;
  public String GtV;
  public String GtW;
  public List<b> GtX;
  public boolean GtY;
  private i callback;
  public int fCN;
  public String jQi;
  final com.tencent.mm.an.d rr;
  
  static
  {
    AppMethodBeat.i(26558);
    GtU = new Vector();
    AppMethodBeat.o(26558);
  }
  
  public d(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, int paramInt3, int paramInt4, String paramString1, String paramString2, eae parameae, String paramString3, int paramInt5, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(26554);
    this.fCN = 0;
    this.GtV = "";
    this.GtW = "";
    this.jQi = "";
    this.GtV = paramString3;
    if ((paramInt1 != 0) && (paramInt1 != 1)) {
      Log.e("MicroMsg.NetSceneGetLbsLifeList", "OpCode Error :".concat(String.valueOf(paramInt1)));
    }
    this.fCN = paramInt1;
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new bwx();
    ((d.a)localObject).lBV = new bwy();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/getlbslifelist";
    ((d.a)localObject).funcId = 603;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (bwx)d.b.b(this.rr.lBR);
    cqg localcqg = new cqg();
    localcqg.Sxv = paramString2;
    localcqg.Sxw = paramInt4;
    localcqg.ScP = paramFloat2;
    localcqg.ScO = paramFloat1;
    localcqg.Sxu = paramString1;
    localcqg.Sxt = paramInt3;
    ((bwx)localObject).Srh = localcqg;
    ((bwx)localObject).SYn = paramString3;
    ((bwx)localObject).CPw = paramInt2;
    ((bwx)localObject).TgE = paramInt5;
    if (parameae == null)
    {
      ((bwx)localObject).TgD = new eae().dc(new byte[0]);
      ((bwx)localObject).RNt = paramInt1;
      if (!paramBoolean2) {
        break label427;
      }
    }
    label427:
    for (int i = 1;; i = 0)
    {
      ((bwx)localObject).TgF = i;
      this.GtY = paramBoolean1;
      Log.d("MicroMsg.NetSceneGetLbsLifeList", "Req: opcode:" + paramInt1 + " lon:" + paramFloat1 + " lat:" + paramFloat2 + " pre:" + paramInt3 + " gpsSource:" + paramInt4 + " mac" + paramString1 + " cell:" + paramString2 + " scene: " + paramInt2 + " entryTime: " + paramInt5);
      Log.d("MicroMsg.NetSceneGetLbsLifeList", "isLoadMore: %s, buf: %s", new Object[] { Boolean.valueOf(paramBoolean1), Integer.valueOf(((bwx)localObject).TgD.Ufv) });
      AppMethodBeat.o(26554);
      return;
      ((bwx)localObject).TgD = parameae;
      break;
    }
  }
  
  public d(cqg paramcqg)
  {
    AppMethodBeat.i(163197);
    this.fCN = 0;
    this.GtV = "";
    this.GtW = "";
    this.jQi = "";
    this.fCN = 0;
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new bwx();
    ((d.a)localObject).lBV = new bwy();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/getlbslifelist";
    ((d.a)localObject).funcId = 603;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (bwx)d.b.b(this.rr.lBR);
    ((bwx)localObject).Srh = paramcqg;
    ((bwx)localObject).SYn = this.GtV;
    ((bwx)localObject).CPw = 6;
    ((bwx)localObject).TgD = new eae().dc(new byte[0]);
    ((bwx)localObject).RNt = 0;
    AppMethodBeat.o(163197);
  }
  
  public static boolean aaf(int paramInt)
  {
    AppMethodBeat.i(26551);
    String str = String.valueOf(paramInt);
    if (GtU.contains(str))
    {
      AppMethodBeat.o(26551);
      return false;
    }
    GtU.add(str);
    AppMethodBeat.o(26551);
    return true;
  }
  
  public static boolean aag(int paramInt)
  {
    AppMethodBeat.i(26552);
    GtU.remove(String.valueOf(paramInt));
    AppMethodBeat.o(26552);
    return true;
  }
  
  public static void clear()
  {
    AppMethodBeat.i(26553);
    GtU.clear();
    AppMethodBeat.o(26553);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(26555);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(26555);
    return i;
  }
  
  public final int doo()
  {
    AppMethodBeat.i(291665);
    int i = ((bwy)d.c.b(this.rr.lBS)).Saq;
    AppMethodBeat.o(291665);
    return i;
  }
  
  public final eae fiB()
  {
    AppMethodBeat.i(26557);
    eae localeae = ((bwy)d.c.b(this.rr.lBS)).TgD;
    if (localeae == null)
    {
      localeae = new eae().dc(new byte[0]);
      AppMethodBeat.o(26557);
      return localeae;
    }
    AppMethodBeat.o(26557);
    return localeae;
  }
  
  public final int getType()
  {
    return 603;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(26556);
    Log.d("MicroMsg.NetSceneGetLbsLifeList", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
    params = (bwy)d.c.b(((com.tencent.mm.an.d)params).lBS);
    this.jQi = params.Sas;
    this.EjD = params.TgN;
    Log.d("MicroMsg.NetSceneGetLbsLifeList", "resp " + params.TgK + "searchId " + this.jQi);
    if ((paramInt3 == 0) || (paramInt3 == 101)) {}
    for (paramInt1 = 1; (paramInt2 != 0) && (paramInt1 == 0); paramInt1 = 0)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(26556);
      return;
    }
    Log.d("MicroMsg.NetSceneGetLbsLifeList", "continueFlag %d lifeCount %d linkCount %d %s", new Object[] { Integer.valueOf(params.Saq), Integer.valueOf(params.TgK), Integer.valueOf(params.TgI), params.TgM });
    this.GtW = Util.nullAs(params.TgM, "");
    this.GtX = new ArrayList();
    paramArrayOfByte = params.TgL.iterator();
    Object localObject;
    while (paramArrayOfByte.hasNext())
    {
      localObject = (cqf)paramArrayOfByte.next();
      localObject = new b(params.Sas, (cqf)localObject);
      this.GtX.add(localObject);
    }
    if (params.TgK > 0)
    {
      paramArrayOfByte = (cqf)params.TgL.get(0);
      params = new StringBuffer();
      params.append(" Bid " + paramArrayOfByte.GtI);
      params.append(" title " + paramArrayOfByte.fwr);
      params.append(" link " + paramArrayOfByte.GtP);
      params.append(" price " + paramArrayOfByte.GtJ);
      params.append(" rate " + paramArrayOfByte.GtO);
      params.append(" type " + paramArrayOfByte.rWu);
      params.append(" desc : ");
      paramArrayOfByte = paramArrayOfByte.GtN.iterator();
      while (paramArrayOfByte.hasNext())
      {
        localObject = (eaf)paramArrayOfByte.next();
        params.append(((eaf)localObject).Ufy + "-");
      }
      Log.d("MicroMsg.NetSceneGetLbsLifeList", "resp one %s ", new Object[] { params.toString() });
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(26556);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.b.d
 * JD-Core Version:    0.7.0.1
 */