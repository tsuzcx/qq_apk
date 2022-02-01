package com.tencent.mm.plugin.nearlife.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bcz;
import com.tencent.mm.protocal.protobuf.bda;
import com.tencent.mm.protocal.protobuf.btl;
import com.tencent.mm.protocal.protobuf.btm;
import com.tencent.mm.protocal.protobuf.cwt;
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
  public static Vector<String> wpY;
  private f callback;
  public int drI;
  public String keN;
  final com.tencent.mm.al.b rr;
  public int uZH;
  public String wpZ;
  public String wqa;
  public List<b> wqb;
  public boolean wqc;
  
  static
  {
    AppMethodBeat.i(26558);
    wpY = new Vector();
    AppMethodBeat.o(26558);
  }
  
  public d(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, int paramInt3, int paramInt4, String paramString1, String paramString2, SKBuiltinBuffer_t paramSKBuiltinBuffer_t, String paramString3, int paramInt5, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(26554);
    this.drI = 0;
    this.wpZ = "";
    this.wqa = "";
    this.keN = "";
    this.wpZ = paramString3;
    if ((paramInt1 != 0) && (paramInt1 != 1)) {
      ad.e("MicroMsg.NetSceneGetLbsLifeList", "OpCode Error :".concat(String.valueOf(paramInt1)));
    }
    this.drI = paramInt1;
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new bcz();
    ((b.a)localObject).hNN = new bda();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getlbslifelist";
    ((b.a)localObject).funcId = 603;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (bcz)this.rr.hNK.hNQ;
    btm localbtm = new btm();
    localbtm.Ggy = paramString2;
    localbtm.Ggz = paramInt4;
    localbtm.FOB = paramFloat2;
    localbtm.FOA = paramFloat1;
    localbtm.Ggx = paramString1;
    localbtm.Ggw = paramInt3;
    ((bcz)localObject).GbC = localbtm;
    ((bcz)localObject).Gsr = paramString3;
    ((bcz)localObject).Scene = paramInt2;
    ((bcz)localObject).GzB = paramInt5;
    if (paramSKBuiltinBuffer_t == null)
    {
      ((bcz)localObject).GzA = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
      ((bcz)localObject).FAt = paramInt1;
      if (!paramBoolean2) {
        break label427;
      }
    }
    label427:
    for (int i = 1;; i = 0)
    {
      ((bcz)localObject).GzC = i;
      this.wqc = paramBoolean1;
      ad.d("MicroMsg.NetSceneGetLbsLifeList", "Req: opcode:" + paramInt1 + " lon:" + paramFloat1 + " lat:" + paramFloat2 + " pre:" + paramInt3 + " gpsSource:" + paramInt4 + " mac" + paramString1 + " cell:" + paramString2 + " scene: " + paramInt2 + " entryTime: " + paramInt5);
      ad.d("MicroMsg.NetSceneGetLbsLifeList", "isLoadMore: %s, buf: %s", new Object[] { Boolean.valueOf(paramBoolean1), Integer.valueOf(((bcz)localObject).GzA.getILen()) });
      AppMethodBeat.o(26554);
      return;
      ((bcz)localObject).GzA = paramSKBuiltinBuffer_t;
      break;
    }
  }
  
  public d(btm parambtm)
  {
    AppMethodBeat.i(163197);
    this.drI = 0;
    this.wpZ = "";
    this.wqa = "";
    this.keN = "";
    this.drI = 0;
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new bcz();
    ((b.a)localObject).hNN = new bda();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getlbslifelist";
    ((b.a)localObject).funcId = 603;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (bcz)this.rr.hNK.hNQ;
    ((bcz)localObject).GbC = parambtm;
    ((bcz)localObject).Gsr = this.wpZ;
    ((bcz)localObject).Scene = 6;
    ((bcz)localObject).GzA = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
    ((bcz)localObject).FAt = 0;
    AppMethodBeat.o(163197);
  }
  
  public static boolean LH(int paramInt)
  {
    AppMethodBeat.i(26551);
    String str = String.valueOf(paramInt);
    if (wpY.contains(str))
    {
      AppMethodBeat.o(26551);
      return false;
    }
    wpY.add(str);
    AppMethodBeat.o(26551);
    return true;
  }
  
  public static boolean LI(int paramInt)
  {
    AppMethodBeat.i(26552);
    wpY.remove(String.valueOf(paramInt));
    AppMethodBeat.o(26552);
    return true;
  }
  
  public static void clear()
  {
    AppMethodBeat.i(26553);
    wpY.clear();
    AppMethodBeat.o(26553);
  }
  
  public final int cyq()
  {
    return ((bda)this.rr.hNL.hNQ).FMr;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(26555);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(26555);
    return i;
  }
  
  public final SKBuiltinBuffer_t dub()
  {
    AppMethodBeat.i(26557);
    SKBuiltinBuffer_t localSKBuiltinBuffer_t = ((bda)this.rr.hNL.hNQ).GzA;
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
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(26556);
    ad.d("MicroMsg.NetSceneGetLbsLifeList", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
    paramq = (bda)((com.tencent.mm.al.b)paramq).hNL.hNQ;
    this.keN = paramq.FMt;
    this.uZH = paramq.GzK;
    ad.d("MicroMsg.NetSceneGetLbsLifeList", "resp " + paramq.GzH + "searchId " + this.keN);
    if ((paramInt3 == 0) || (paramInt3 == 101)) {}
    for (paramInt1 = 1; (paramInt2 != 0) && (paramInt1 == 0); paramInt1 = 0)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(26556);
      return;
    }
    ad.d("MicroMsg.NetSceneGetLbsLifeList", "continueFlag %d lifeCount %d linkCount %d %s", new Object[] { Integer.valueOf(paramq.FMr), Integer.valueOf(paramq.GzH), Integer.valueOf(paramq.GzF), paramq.GzJ });
    this.wqa = bt.bI(paramq.GzJ, "");
    this.wqb = new ArrayList();
    paramArrayOfByte = paramq.GzI.iterator();
    Object localObject;
    while (paramArrayOfByte.hasNext())
    {
      localObject = (btl)paramArrayOfByte.next();
      localObject = new b(paramq.FMt, (btl)localObject);
      this.wqb.add(localObject);
    }
    if (paramq.GzH > 0)
    {
      paramArrayOfByte = (btl)paramq.GzI.get(0);
      paramq = new StringBuffer();
      paramq.append(" Bid " + paramArrayOfByte.wpM);
      paramq.append(" title " + paramArrayOfByte.Title);
      paramq.append(" link " + paramArrayOfByte.wpT);
      paramq.append(" price " + paramArrayOfByte.wpN);
      paramq.append(" rate " + paramArrayOfByte.wpS);
      paramq.append(" type " + paramArrayOfByte.nEf);
      paramq.append(" desc : ");
      paramArrayOfByte = paramArrayOfByte.wpR.iterator();
      while (paramArrayOfByte.hasNext())
      {
        localObject = (cwt)paramArrayOfByte.next();
        paramq.append(((cwt)localObject).HoB + "-");
      }
      ad.d("MicroMsg.NetSceneGetLbsLifeList", "resp one %s ", new Object[] { paramq.toString() });
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(26556);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.b.d
 * JD-Core Version:    0.7.0.1
 */