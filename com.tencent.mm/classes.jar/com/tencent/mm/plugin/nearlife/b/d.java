package com.tencent.mm.plugin.nearlife.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bpd;
import com.tencent.mm.protocal.protobuf.bpe;
import com.tencent.mm.protocal.protobuf.chj;
import com.tencent.mm.protocal.protobuf.chk;
import com.tencent.mm.protocal.protobuf.dqi;
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
  public static Vector<String> AAS;
  public String AAT;
  public String AAU;
  public List<b> AAV;
  public boolean AAW;
  private i callback;
  public int dJY;
  public String hes;
  final com.tencent.mm.ak.d rr;
  public int yFK;
  
  static
  {
    AppMethodBeat.i(26558);
    AAS = new Vector();
    AppMethodBeat.o(26558);
  }
  
  public d(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, int paramInt3, int paramInt4, String paramString1, String paramString2, SKBuiltinBuffer_t paramSKBuiltinBuffer_t, String paramString3, int paramInt5, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(26554);
    this.dJY = 0;
    this.AAT = "";
    this.AAU = "";
    this.hes = "";
    this.AAT = paramString3;
    if ((paramInt1 != 0) && (paramInt1 != 1)) {
      Log.e("MicroMsg.NetSceneGetLbsLifeList", "OpCode Error :".concat(String.valueOf(paramInt1)));
    }
    this.dJY = paramInt1;
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new bpd();
    ((d.a)localObject).iLO = new bpe();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/getlbslifelist";
    ((d.a)localObject).funcId = 603;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (bpd)this.rr.iLK.iLR;
    chk localchk = new chk();
    localchk.LuV = paramString2;
    localchk.LuW = paramInt4;
    localchk.LbD = paramFloat2;
    localchk.LbC = paramFloat1;
    localchk.LuU = paramString1;
    localchk.LuT = paramInt3;
    ((bpd)localObject).LpL = localchk;
    ((bpd)localObject).LPT = paramString3;
    ((bpd)localObject).Scene = paramInt2;
    ((bpd)localObject).LXn = paramInt5;
    if (paramSKBuiltinBuffer_t == null)
    {
      ((bpd)localObject).LXm = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
      ((bpd)localObject).KMz = paramInt1;
      if (!paramBoolean2) {
        break label427;
      }
    }
    label427:
    for (int i = 1;; i = 0)
    {
      ((bpd)localObject).LXo = i;
      this.AAW = paramBoolean1;
      Log.d("MicroMsg.NetSceneGetLbsLifeList", "Req: opcode:" + paramInt1 + " lon:" + paramFloat1 + " lat:" + paramFloat2 + " pre:" + paramInt3 + " gpsSource:" + paramInt4 + " mac" + paramString1 + " cell:" + paramString2 + " scene: " + paramInt2 + " entryTime: " + paramInt5);
      Log.d("MicroMsg.NetSceneGetLbsLifeList", "isLoadMore: %s, buf: %s", new Object[] { Boolean.valueOf(paramBoolean1), Integer.valueOf(((bpd)localObject).LXm.getILen()) });
      AppMethodBeat.o(26554);
      return;
      ((bpd)localObject).LXm = paramSKBuiltinBuffer_t;
      break;
    }
  }
  
  public d(chk paramchk)
  {
    AppMethodBeat.i(163197);
    this.dJY = 0;
    this.AAT = "";
    this.AAU = "";
    this.hes = "";
    this.dJY = 0;
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new bpd();
    ((d.a)localObject).iLO = new bpe();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/getlbslifelist";
    ((d.a)localObject).funcId = 603;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (bpd)this.rr.iLK.iLR;
    ((bpd)localObject).LpL = paramchk;
    ((bpd)localObject).LPT = this.AAT;
    ((bpd)localObject).Scene = 6;
    ((bpd)localObject).LXm = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
    ((bpd)localObject).KMz = 0;
    AppMethodBeat.o(163197);
  }
  
  public static boolean Tt(int paramInt)
  {
    AppMethodBeat.i(26551);
    String str = String.valueOf(paramInt);
    if (AAS.contains(str))
    {
      AppMethodBeat.o(26551);
      return false;
    }
    AAS.add(str);
    AppMethodBeat.o(26551);
    return true;
  }
  
  public static boolean Tu(int paramInt)
  {
    AppMethodBeat.i(26552);
    AAS.remove(String.valueOf(paramInt));
    AppMethodBeat.o(26552);
    return true;
  }
  
  public static void clear()
  {
    AppMethodBeat.i(26553);
    AAS.clear();
    AppMethodBeat.o(26553);
  }
  
  public final int cYA()
  {
    return ((bpe)this.rr.iLL.iLR).KZh;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(26555);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(26555);
    return i;
  }
  
  public final SKBuiltinBuffer_t ewY()
  {
    AppMethodBeat.i(26557);
    SKBuiltinBuffer_t localSKBuiltinBuffer_t = ((bpe)this.rr.iLL.iLR).LXm;
    if (localSKBuiltinBuffer_t == null)
    {
      localSKBuiltinBuffer_t = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
      AppMethodBeat.o(26557);
      return localSKBuiltinBuffer_t;
    }
    AppMethodBeat.o(26557);
    return localSKBuiltinBuffer_t;
  }
  
  public final int getType()
  {
    return 603;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(26556);
    Log.d("MicroMsg.NetSceneGetLbsLifeList", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
    params = (bpe)((com.tencent.mm.ak.d)params).iLL.iLR;
    this.hes = params.KZj;
    this.yFK = params.LXw;
    Log.d("MicroMsg.NetSceneGetLbsLifeList", "resp " + params.LXt + "searchId " + this.hes);
    if ((paramInt3 == 0) || (paramInt3 == 101)) {}
    for (paramInt1 = 1; (paramInt2 != 0) && (paramInt1 == 0); paramInt1 = 0)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(26556);
      return;
    }
    Log.d("MicroMsg.NetSceneGetLbsLifeList", "continueFlag %d lifeCount %d linkCount %d %s", new Object[] { Integer.valueOf(params.KZh), Integer.valueOf(params.LXt), Integer.valueOf(params.LXr), params.LXv });
    this.AAU = Util.nullAs(params.LXv, "");
    this.AAV = new ArrayList();
    paramArrayOfByte = params.LXu.iterator();
    Object localObject;
    while (paramArrayOfByte.hasNext())
    {
      localObject = (chj)paramArrayOfByte.next();
      localObject = new b(params.KZj, (chj)localObject);
      this.AAV.add(localObject);
    }
    if (params.LXt > 0)
    {
      paramArrayOfByte = (chj)params.LXu.get(0);
      params = new StringBuffer();
      params.append(" Bid " + paramArrayOfByte.AAG);
      params.append(" title " + paramArrayOfByte.Title);
      params.append(" link " + paramArrayOfByte.AAN);
      params.append(" price " + paramArrayOfByte.AAH);
      params.append(" rate " + paramArrayOfByte.AAM);
      params.append(" type " + paramArrayOfByte.oUv);
      params.append(" desc : ");
      paramArrayOfByte = paramArrayOfByte.AAL.iterator();
      while (paramArrayOfByte.hasNext())
      {
        localObject = (dqi)paramArrayOfByte.next();
        params.append(((dqi)localObject).MTo + "-");
      }
      Log.d("MicroMsg.NetSceneGetLbsLifeList", "resp one %s ", new Object[] { params.toString() });
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(26556);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.b.d
 * JD-Core Version:    0.7.0.1
 */