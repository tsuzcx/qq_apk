package com.tencent.mm.plugin.nearlife.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.ayv;
import com.tencent.mm.protocal.protobuf.ayw;
import com.tencent.mm.protocal.protobuf.boy;
import com.tencent.mm.protocal.protobuf.boz;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public final class d
  extends n
  implements k
{
  public static Vector<String> vkG;
  private g callback;
  public int dgm;
  public String jKB;
  final com.tencent.mm.ak.b rr;
  public int tWY;
  public String vkH;
  public String vkI;
  public List<b> vkJ;
  public boolean vkK;
  
  static
  {
    AppMethodBeat.i(26558);
    vkG = new Vector();
    AppMethodBeat.o(26558);
  }
  
  public d(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, int paramInt3, int paramInt4, String paramString1, String paramString2, SKBuiltinBuffer_t paramSKBuiltinBuffer_t, String paramString3, int paramInt5, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(26554);
    this.dgm = 0;
    this.vkH = "";
    this.vkI = "";
    this.jKB = "";
    this.vkH = paramString3;
    if ((paramInt1 != 0) && (paramInt1 != 1)) {
      ac.e("MicroMsg.NetSceneGetLbsLifeList", "OpCode Error :".concat(String.valueOf(paramInt1)));
    }
    this.dgm = paramInt1;
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new ayv();
    ((b.a)localObject).hvu = new ayw();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getlbslifelist";
    ((b.a)localObject).funcId = 603;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (ayv)this.rr.hvr.hvw;
    boz localboz = new boz();
    localboz.EyM = paramString2;
    localboz.EyN = paramInt4;
    localboz.Ehu = paramFloat2;
    localboz.Eht = paramFloat1;
    localboz.EyL = paramString1;
    localboz.EyK = paramInt3;
    ((ayv)localObject).Euj = localboz;
    ((ayv)localObject).EJp = paramString3;
    ((ayv)localObject).Scene = paramInt2;
    ((ayv)localObject).EQk = paramInt5;
    if (paramSKBuiltinBuffer_t == null)
    {
      ((ayv)localObject).EQj = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
      ((ayv)localObject).DUY = paramInt1;
      if (!paramBoolean2) {
        break label427;
      }
    }
    label427:
    for (int i = 1;; i = 0)
    {
      ((ayv)localObject).EQl = i;
      this.vkK = paramBoolean1;
      ac.d("MicroMsg.NetSceneGetLbsLifeList", "Req: opcode:" + paramInt1 + " lon:" + paramFloat1 + " lat:" + paramFloat2 + " pre:" + paramInt3 + " gpsSource:" + paramInt4 + " mac" + paramString1 + " cell:" + paramString2 + " scene: " + paramInt2 + " entryTime: " + paramInt5);
      ac.d("MicroMsg.NetSceneGetLbsLifeList", "isLoadMore: %s, buf: %s", new Object[] { Boolean.valueOf(paramBoolean1), Integer.valueOf(((ayv)localObject).EQj.getILen()) });
      AppMethodBeat.o(26554);
      return;
      ((ayv)localObject).EQj = paramSKBuiltinBuffer_t;
      break;
    }
  }
  
  public d(boz paramboz)
  {
    AppMethodBeat.i(163197);
    this.dgm = 0;
    this.vkH = "";
    this.vkI = "";
    this.jKB = "";
    this.dgm = 0;
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new ayv();
    ((b.a)localObject).hvu = new ayw();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getlbslifelist";
    ((b.a)localObject).funcId = 603;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (ayv)this.rr.hvr.hvw;
    ((ayv)localObject).Euj = paramboz;
    ((ayv)localObject).EJp = this.vkH;
    ((ayv)localObject).Scene = 6;
    ((ayv)localObject).EQj = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
    ((ayv)localObject).DUY = 0;
    AppMethodBeat.o(163197);
  }
  
  public static boolean Kf(int paramInt)
  {
    AppMethodBeat.i(26551);
    String str = String.valueOf(paramInt);
    if (vkG.contains(str))
    {
      AppMethodBeat.o(26551);
      return false;
    }
    vkG.add(str);
    AppMethodBeat.o(26551);
    return true;
  }
  
  public static boolean Kg(int paramInt)
  {
    AppMethodBeat.i(26552);
    vkG.remove(String.valueOf(paramInt));
    AppMethodBeat.o(26552);
    return true;
  }
  
  public static void clear()
  {
    AppMethodBeat.i(26553);
    vkG.clear();
    AppMethodBeat.o(26553);
  }
  
  public final int csz()
  {
    return ((ayw)this.rr.hvs.hvw).EfS;
  }
  
  public final SKBuiltinBuffer_t djP()
  {
    AppMethodBeat.i(26557);
    SKBuiltinBuffer_t localSKBuiltinBuffer_t = ((ayw)this.rr.hvs.hvw).EQj;
    if (localSKBuiltinBuffer_t == null)
    {
      localSKBuiltinBuffer_t = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
      AppMethodBeat.o(26557);
      return localSKBuiltinBuffer_t;
    }
    AppMethodBeat.o(26557);
    return localSKBuiltinBuffer_t;
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
    ac.d("MicroMsg.NetSceneGetLbsLifeList", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
    paramq = (ayw)((com.tencent.mm.ak.b)paramq).hvs.hvw;
    this.jKB = paramq.EfU;
    this.tWY = paramq.EQt;
    ac.d("MicroMsg.NetSceneGetLbsLifeList", "resp " + paramq.EQq + "searchId " + this.jKB);
    if ((paramInt3 == 0) || (paramInt3 == 101)) {}
    for (paramInt1 = 1; (paramInt2 != 0) && (paramInt1 == 0); paramInt1 = 0)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(26556);
      return;
    }
    ac.d("MicroMsg.NetSceneGetLbsLifeList", "continueFlag %d lifeCount %d linkCount %d %s", new Object[] { Integer.valueOf(paramq.EfS), Integer.valueOf(paramq.EQq), Integer.valueOf(paramq.EQo), paramq.EQs });
    this.vkI = bs.bG(paramq.EQs, "");
    this.vkJ = new ArrayList();
    paramArrayOfByte = paramq.EQr.iterator();
    Object localObject;
    while (paramArrayOfByte.hasNext())
    {
      localObject = (boy)paramArrayOfByte.next();
      localObject = new b(paramq.EfU, (boy)localObject);
      this.vkJ.add(localObject);
    }
    if (paramq.EQq > 0)
    {
      paramArrayOfByte = (boy)paramq.EQr.get(0);
      paramq = new StringBuffer();
      paramq.append(" Bid " + paramArrayOfByte.vku);
      paramq.append(" title " + paramArrayOfByte.Title);
      paramq.append(" link " + paramArrayOfByte.vkB);
      paramq.append(" price " + paramArrayOfByte.vkv);
      paramq.append(" rate " + paramArrayOfByte.vkA);
      paramq.append(" type " + paramArrayOfByte.ndI);
      paramq.append(" desc : ");
      paramArrayOfByte = paramArrayOfByte.vkz.iterator();
      while (paramArrayOfByte.hasNext())
      {
        localObject = (crm)paramArrayOfByte.next();
        paramq.append(((crm)localObject).FEm + "-");
      }
      ac.d("MicroMsg.NetSceneGetLbsLifeList", "resp one %s ", new Object[] { paramq.toString() });
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(26556);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.b.d
 * JD-Core Version:    0.7.0.1
 */