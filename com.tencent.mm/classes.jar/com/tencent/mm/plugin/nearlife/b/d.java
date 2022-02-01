package com.tencent.mm.plugin.nearlife.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.avp;
import com.tencent.mm.protocal.protobuf.avq;
import com.tencent.mm.protocal.protobuf.blc;
import com.tencent.mm.protocal.protobuf.bld;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public final class d
  extends n
  implements k
{
  public static Vector<String> ubI;
  private g callback;
  public String dct;
  public int diR;
  public String jko;
  final com.tencent.mm.al.b rr;
  public int sOL;
  public String ubJ;
  public List<b> ubK;
  public boolean ubL;
  
  static
  {
    AppMethodBeat.i(26558);
    ubI = new Vector();
    AppMethodBeat.o(26558);
  }
  
  public d(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, int paramInt3, int paramInt4, String paramString1, String paramString2, SKBuiltinBuffer_t paramSKBuiltinBuffer_t, String paramString3, int paramInt5, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(26554);
    this.diR = 0;
    this.ubJ = "";
    this.dct = "";
    this.jko = "";
    this.ubJ = paramString3;
    if ((paramInt1 != 0) && (paramInt1 != 1)) {
      ad.e("MicroMsg.NetSceneGetLbsLifeList", "OpCode Error :".concat(String.valueOf(paramInt1)));
    }
    this.diR = paramInt1;
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new avp();
    ((b.a)localObject).gUV = new avq();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getlbslifelist";
    ((b.a)localObject).funcId = 603;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (avp)this.rr.gUS.gUX;
    bld localbld = new bld();
    localbld.DfG = paramString2;
    localbld.DfH = paramInt4;
    localbld.COJ = paramFloat2;
    localbld.COI = paramFloat1;
    localbld.DfF = paramString1;
    localbld.DfE = paramInt3;
    ((avp)localObject).Dbk = localbld;
    ((avp)localObject).Dop = paramString3;
    ((avp)localObject).Scene = paramInt2;
    ((avp)localObject).Dvb = paramInt5;
    if (paramSKBuiltinBuffer_t == null)
    {
      ((avp)localObject).Dva = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
      ((avp)localObject).CCB = paramInt1;
      if (!paramBoolean2) {
        break label427;
      }
    }
    label427:
    for (int i = 1;; i = 0)
    {
      ((avp)localObject).Dvc = i;
      this.ubL = paramBoolean1;
      ad.d("MicroMsg.NetSceneGetLbsLifeList", "Req: opcode:" + paramInt1 + " lon:" + paramFloat1 + " lat:" + paramFloat2 + " pre:" + paramInt3 + " gpsSource:" + paramInt4 + " mac" + paramString1 + " cell:" + paramString2 + " scene: " + paramInt2 + " entryTime: " + paramInt5);
      ad.d("MicroMsg.NetSceneGetLbsLifeList", "isLoadMore: %s, buf: %s", new Object[] { Boolean.valueOf(paramBoolean1), Integer.valueOf(((avp)localObject).Dva.getILen()) });
      AppMethodBeat.o(26554);
      return;
      ((avp)localObject).Dva = paramSKBuiltinBuffer_t;
      break;
    }
  }
  
  public d(bld parambld)
  {
    AppMethodBeat.i(163197);
    this.diR = 0;
    this.ubJ = "";
    this.dct = "";
    this.jko = "";
    this.diR = 0;
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new avp();
    ((b.a)localObject).gUV = new avq();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getlbslifelist";
    ((b.a)localObject).funcId = 603;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (avp)this.rr.gUS.gUX;
    ((avp)localObject).Dbk = parambld;
    ((avp)localObject).Dop = this.ubJ;
    ((avp)localObject).Scene = 6;
    ((avp)localObject).Dva = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
    ((avp)localObject).CCB = 0;
    AppMethodBeat.o(163197);
  }
  
  public static boolean Ig(int paramInt)
  {
    AppMethodBeat.i(26551);
    String str = String.valueOf(paramInt);
    if (ubI.contains(str))
    {
      AppMethodBeat.o(26551);
      return false;
    }
    ubI.add(str);
    AppMethodBeat.o(26551);
    return true;
  }
  
  public static boolean Ih(int paramInt)
  {
    AppMethodBeat.i(26552);
    ubI.remove(String.valueOf(paramInt));
    AppMethodBeat.o(26552);
    return true;
  }
  
  public static void clear()
  {
    AppMethodBeat.i(26553);
    ubI.clear();
    AppMethodBeat.o(26553);
  }
  
  public final SKBuiltinBuffer_t cWh()
  {
    AppMethodBeat.i(26557);
    SKBuiltinBuffer_t localSKBuiltinBuffer_t = ((avq)this.rr.gUT.gUX).Dva;
    if (localSKBuiltinBuffer_t == null)
    {
      localSKBuiltinBuffer_t = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
      AppMethodBeat.o(26557);
      return localSKBuiltinBuffer_t;
    }
    AppMethodBeat.o(26557);
    return localSKBuiltinBuffer_t;
  }
  
  public final int ckO()
  {
    return ((avq)this.rr.gUT.gUX).CNq;
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(26555);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(26555);
    return i;
  }
  
  public final int getType()
  {
    return 603;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(26556);
    ad.d("MicroMsg.NetSceneGetLbsLifeList", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
    paramq = (avq)((com.tencent.mm.al.b)paramq).gUT.gUX;
    this.jko = paramq.CNs;
    this.sOL = paramq.Dvk;
    ad.d("MicroMsg.NetSceneGetLbsLifeList", "resp " + paramq.Dvh + "searchId " + this.jko);
    if ((paramInt3 == 0) || (paramInt3 == 101)) {}
    for (paramInt1 = 1; (paramInt2 != 0) && (paramInt1 == 0); paramInt1 = 0)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(26556);
      return;
    }
    ad.d("MicroMsg.NetSceneGetLbsLifeList", "continueFlag %d lifeCount %d linkCount %d %s", new Object[] { Integer.valueOf(paramq.CNq), Integer.valueOf(paramq.Dvh), Integer.valueOf(paramq.Dvf), paramq.Dvj });
    this.dct = bt.by(paramq.Dvj, "");
    this.ubK = new ArrayList();
    paramArrayOfByte = paramq.Dvi.iterator();
    Object localObject;
    while (paramArrayOfByte.hasNext())
    {
      localObject = (blc)paramArrayOfByte.next();
      localObject = new b(paramq.CNs, (blc)localObject);
      this.ubK.add(localObject);
    }
    if (paramq.Dvh > 0)
    {
      paramArrayOfByte = (blc)paramq.Dvi.get(0);
      paramq = new StringBuffer();
      paramq.append(" Bid " + paramArrayOfByte.ubw);
      paramq.append(" title " + paramArrayOfByte.Title);
      paramq.append(" link " + paramArrayOfByte.ubD);
      paramq.append(" price " + paramArrayOfByte.ubx);
      paramq.append(" rate " + paramArrayOfByte.ubC);
      paramq.append(" type " + paramArrayOfByte.mBH);
      paramq.append(" desc : ");
      paramArrayOfByte = paramArrayOfByte.ubB.iterator();
      while (paramArrayOfByte.hasNext())
      {
        localObject = (cmf)paramArrayOfByte.next();
        paramq.append(((cmf)localObject).Ehn + "-");
      }
      ad.d("MicroMsg.NetSceneGetLbsLifeList", "resp one %s ", new Object[] { paramq.toString() });
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(26556);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.b.d
 * JD-Core Version:    0.7.0.1
 */