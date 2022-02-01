package com.tencent.mm.plugin.nearlife.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bdp;
import com.tencent.mm.protocal.protobuf.bdq;
import com.tencent.mm.protocal.protobuf.buf;
import com.tencent.mm.protocal.protobuf.bug;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public final class d
  extends n
  implements k
{
  public static Vector<String> wFH;
  private f callback;
  public int dsO;
  public String kid;
  final com.tencent.mm.ak.b rr;
  public int vlS;
  public String wFI;
  public String wFJ;
  public List<b> wFK;
  public boolean wFL;
  
  static
  {
    AppMethodBeat.i(26558);
    wFH = new Vector();
    AppMethodBeat.o(26558);
  }
  
  public d(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, int paramInt3, int paramInt4, String paramString1, String paramString2, SKBuiltinBuffer_t paramSKBuiltinBuffer_t, String paramString3, int paramInt5, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(26554);
    this.dsO = 0;
    this.wFI = "";
    this.wFJ = "";
    this.kid = "";
    this.wFI = paramString3;
    if ((paramInt1 != 0) && (paramInt1 != 1)) {
      ae.e("MicroMsg.NetSceneGetLbsLifeList", "OpCode Error :".concat(String.valueOf(paramInt1)));
    }
    this.dsO = paramInt1;
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new bdp();
    ((b.a)localObject).hQG = new bdq();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getlbslifelist";
    ((b.a)localObject).funcId = 603;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (bdp)this.rr.hQD.hQJ;
    bug localbug = new bug();
    localbug.Gzh = paramString2;
    localbug.Gzi = paramInt4;
    localbug.Gha = paramFloat2;
    localbug.GgZ = paramFloat1;
    localbug.Gzg = paramString1;
    localbug.Gzf = paramInt3;
    ((bdp)localObject).Guj = localbug;
    ((bdp)localObject).GLP = paramString3;
    ((bdp)localObject).Scene = paramInt2;
    ((bdp)localObject).GTb = paramInt5;
    if (paramSKBuiltinBuffer_t == null)
    {
      ((bdp)localObject).GTa = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
      ((bdp)localObject).FSQ = paramInt1;
      if (!paramBoolean2) {
        break label427;
      }
    }
    label427:
    for (int i = 1;; i = 0)
    {
      ((bdp)localObject).GTc = i;
      this.wFL = paramBoolean1;
      ae.d("MicroMsg.NetSceneGetLbsLifeList", "Req: opcode:" + paramInt1 + " lon:" + paramFloat1 + " lat:" + paramFloat2 + " pre:" + paramInt3 + " gpsSource:" + paramInt4 + " mac" + paramString1 + " cell:" + paramString2 + " scene: " + paramInt2 + " entryTime: " + paramInt5);
      ae.d("MicroMsg.NetSceneGetLbsLifeList", "isLoadMore: %s, buf: %s", new Object[] { Boolean.valueOf(paramBoolean1), Integer.valueOf(((bdp)localObject).GTa.getILen()) });
      AppMethodBeat.o(26554);
      return;
      ((bdp)localObject).GTa = paramSKBuiltinBuffer_t;
      break;
    }
  }
  
  public d(bug parambug)
  {
    AppMethodBeat.i(163197);
    this.dsO = 0;
    this.wFI = "";
    this.wFJ = "";
    this.kid = "";
    this.dsO = 0;
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new bdp();
    ((b.a)localObject).hQG = new bdq();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getlbslifelist";
    ((b.a)localObject).funcId = 603;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (bdp)this.rr.hQD.hQJ;
    ((bdp)localObject).Guj = parambug;
    ((bdp)localObject).GLP = this.wFI;
    ((bdp)localObject).Scene = 6;
    ((bdp)localObject).GTa = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
    ((bdp)localObject).FSQ = 0;
    AppMethodBeat.o(163197);
  }
  
  public static boolean Mm(int paramInt)
  {
    AppMethodBeat.i(26551);
    String str = String.valueOf(paramInt);
    if (wFH.contains(str))
    {
      AppMethodBeat.o(26551);
      return false;
    }
    wFH.add(str);
    AppMethodBeat.o(26551);
    return true;
  }
  
  public static boolean Mn(int paramInt)
  {
    AppMethodBeat.i(26552);
    wFH.remove(String.valueOf(paramInt));
    AppMethodBeat.o(26552);
    return true;
  }
  
  public static void clear()
  {
    AppMethodBeat.i(26553);
    wFH.clear();
    AppMethodBeat.o(26553);
  }
  
  public final int czR()
  {
    return ((bdq)this.rr.hQE.hQJ).GeQ;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(26555);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(26555);
    return i;
  }
  
  public final SKBuiltinBuffer_t dxq()
  {
    AppMethodBeat.i(26557);
    SKBuiltinBuffer_t localSKBuiltinBuffer_t = ((bdq)this.rr.hQE.hQJ).GTa;
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
    ae.d("MicroMsg.NetSceneGetLbsLifeList", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
    paramq = (bdq)((com.tencent.mm.ak.b)paramq).hQE.hQJ;
    this.kid = paramq.GeS;
    this.vlS = paramq.GTk;
    ae.d("MicroMsg.NetSceneGetLbsLifeList", "resp " + paramq.GTh + "searchId " + this.kid);
    if ((paramInt3 == 0) || (paramInt3 == 101)) {}
    for (paramInt1 = 1; (paramInt2 != 0) && (paramInt1 == 0); paramInt1 = 0)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(26556);
      return;
    }
    ae.d("MicroMsg.NetSceneGetLbsLifeList", "continueFlag %d lifeCount %d linkCount %d %s", new Object[] { Integer.valueOf(paramq.GeQ), Integer.valueOf(paramq.GTh), Integer.valueOf(paramq.GTf), paramq.GTj });
    this.wFJ = bu.bI(paramq.GTj, "");
    this.wFK = new ArrayList();
    paramArrayOfByte = paramq.GTi.iterator();
    Object localObject;
    while (paramArrayOfByte.hasNext())
    {
      localObject = (buf)paramArrayOfByte.next();
      localObject = new b(paramq.GeS, (buf)localObject);
      this.wFK.add(localObject);
    }
    if (paramq.GTh > 0)
    {
      paramArrayOfByte = (buf)paramq.GTi.get(0);
      paramq = new StringBuffer();
      paramq.append(" Bid " + paramArrayOfByte.wFv);
      paramq.append(" title " + paramArrayOfByte.Title);
      paramq.append(" link " + paramArrayOfByte.wFC);
      paramq.append(" price " + paramArrayOfByte.wFw);
      paramq.append(" rate " + paramArrayOfByte.wFB);
      paramq.append(" type " + paramArrayOfByte.nJA);
      paramq.append(" desc : ");
      paramArrayOfByte = paramArrayOfByte.wFA.iterator();
      while (paramArrayOfByte.hasNext())
      {
        localObject = (cxn)paramArrayOfByte.next();
        paramq.append(((cxn)localObject).HId + "-");
      }
      ae.d("MicroMsg.NetSceneGetLbsLifeList", "resp one %s ", new Object[] { paramq.toString() });
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(26556);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.b.d
 * JD-Core Version:    0.7.0.1
 */