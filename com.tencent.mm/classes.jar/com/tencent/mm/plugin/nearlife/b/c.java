package com.tencent.mm.plugin.nearlife.b;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ahd;
import com.tencent.mm.protocal.c.ahe;
import com.tencent.mm.protocal.c.atn;
import com.tencent.mm.protocal.c.ato;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.bml;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public final class c
  extends m
  implements k
{
  public static Vector<String> mEg = new Vector();
  public int bMC = 0;
  private final b dmK;
  private f dmL;
  public String fTF = "";
  public int lCZ;
  public String mEh = "";
  public String mEi = "";
  public List<a> mEj;
  public boolean mEk;
  
  public c(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, int paramInt3, int paramInt4, String paramString1, String paramString2, bmk parambmk, String paramString3, int paramInt5, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mEh = paramString3;
    if ((paramInt1 != 0) && (paramInt1 != 1)) {
      y.e("MicroMsg.NetSceneGetLbsLifeList", "OpCode Error :" + paramInt1);
    }
    this.bMC = paramInt1;
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new ahd();
    ((b.a)localObject).ecI = new ahe();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getlbslifelist";
    ((b.a)localObject).ecG = 603;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (ahd)this.dmK.ecE.ecN;
    ato localato = new ato();
    localato.sUp = paramString2;
    localato.sUq = paramInt4;
    localato.sGK = paramFloat2;
    localato.sGJ = paramFloat1;
    localato.sUo = paramString1;
    localato.sUn = paramInt3;
    ((ahd)localObject).sQj = localato;
    ((ahd)localObject).sYZ = paramString3;
    ((ahd)localObject).pyo = paramInt2;
    ((ahd)localObject).teI = paramInt5;
    if (parambmk == null)
    {
      ((ahd)localObject).teH = new bmk().bs(new byte[0]);
      ((ahd)localObject).syV = paramInt1;
      if (!paramBoolean2) {
        break label422;
      }
    }
    label422:
    for (int i = 1;; i = 0)
    {
      ((ahd)localObject).teJ = i;
      this.mEk = paramBoolean1;
      y.d("MicroMsg.NetSceneGetLbsLifeList", "Req: opcode:" + paramInt1 + " lon:" + paramFloat1 + " lat:" + paramFloat2 + " pre:" + paramInt3 + " gpsSource:" + paramInt4 + " mac" + paramString1 + " cell:" + paramString2 + " scene: " + paramInt2 + " entryTime: " + paramInt5);
      y.d("MicroMsg.NetSceneGetLbsLifeList", "isLoadMore: %s, buf: %s", new Object[] { Boolean.valueOf(paramBoolean1), Integer.valueOf(((ahd)localObject).teH.tFK) });
      return;
      ((ahd)localObject).teH = parambmk;
      break;
    }
  }
  
  public static void clear()
  {
    mEg.clear();
  }
  
  public static boolean vf(int paramInt)
  {
    String str = String.valueOf(paramInt);
    if (mEg.contains(str)) {
      return false;
    }
    mEg.add(str);
    return true;
  }
  
  public static boolean vg(int paramInt)
  {
    mEg.remove(String.valueOf(paramInt));
    return true;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneGetLbsLifeList", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
    paramq = (ahe)((b)paramq).ecF.ecN;
    this.fTF = paramq.sFF;
    this.lCZ = paramq.teR;
    y.d("MicroMsg.NetSceneGetLbsLifeList", "resp " + paramq.teO + "searchId " + this.fTF);
    if ((paramInt3 == 0) || (paramInt3 == 101)) {}
    for (paramInt1 = 1; (paramInt2 != 0) && (paramInt1 == 0); paramInt1 = 0)
    {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    y.d("MicroMsg.NetSceneGetLbsLifeList", "continueFlag %d lifeCount %d linkCount %d %s", new Object[] { Integer.valueOf(paramq.sFD), Integer.valueOf(paramq.teO), Integer.valueOf(paramq.teM), paramq.teQ });
    this.mEi = bk.aM(paramq.teQ, "");
    this.mEj = new ArrayList();
    paramArrayOfByte = paramq.teP.iterator();
    Object localObject;
    while (paramArrayOfByte.hasNext())
    {
      localObject = (atn)paramArrayOfByte.next();
      localObject = new a(paramq.sFF, (atn)localObject);
      this.mEj.add(localObject);
    }
    if (paramq.teO > 0)
    {
      paramArrayOfByte = (atn)paramq.teP.get(0);
      paramq = new StringBuffer();
      paramq.append(" Bid " + paramArrayOfByte.mDU);
      paramq.append(" title " + paramArrayOfByte.bGw);
      paramq.append(" link " + paramArrayOfByte.mEb);
      paramq.append(" price " + paramArrayOfByte.mDV);
      paramq.append(" rate " + paramArrayOfByte.mEa);
      paramq.append(" type " + paramArrayOfByte.hQR);
      paramq.append(" desc : ");
      paramArrayOfByte = paramArrayOfByte.mDZ.iterator();
      while (paramArrayOfByte.hasNext())
      {
        localObject = (bml)paramArrayOfByte.next();
        paramq.append(((bml)localObject).tFO + "-");
      }
      y.d("MicroMsg.NetSceneGetLbsLifeList", "resp one %s ", new Object[] { paramq.toString() });
    }
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final bmk boh()
  {
    bmk localbmk2 = ((ahe)this.dmK.ecF.ecN).teH;
    bmk localbmk1 = localbmk2;
    if (localbmk2 == null) {
      localbmk1 = new bmk().bs(new byte[0]);
    }
    return localbmk1;
  }
  
  public final int boi()
  {
    return ((ahe)this.dmK.ecF.ecN).sFD;
  }
  
  public final int getType()
  {
    return 603;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.b.c
 * JD-Core Version:    0.7.0.1
 */