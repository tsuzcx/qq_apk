package com.tencent.mm.plugin.nearlife.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.aly;
import com.tencent.mm.protocal.protobuf.alz;
import com.tencent.mm.protocal.protobuf.azs;
import com.tencent.mm.protocal.protobuf.azt;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public final class c
  extends m
  implements k
{
  public static Vector<String> pei;
  private f callback;
  public int ctW;
  public String hng;
  public int oal;
  public String pej;
  public String pek;
  public List<a> pel;
  public boolean pem;
  private final b rr;
  
  static
  {
    AppMethodBeat.i(22934);
    pei = new Vector();
    AppMethodBeat.o(22934);
  }
  
  public c(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, int paramInt3, int paramInt4, String paramString1, String paramString2, SKBuiltinBuffer_t paramSKBuiltinBuffer_t, String paramString3, int paramInt5, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(22930);
    this.ctW = 0;
    this.pej = "";
    this.pek = "";
    this.hng = "";
    this.pej = paramString3;
    if ((paramInt1 != 0) && (paramInt1 != 1)) {
      ab.e("MicroMsg.NetSceneGetLbsLifeList", "OpCode Error :".concat(String.valueOf(paramInt1)));
    }
    this.ctW = paramInt1;
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new aly();
    ((b.a)localObject).fsY = new alz();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getlbslifelist";
    ((b.a)localObject).funcId = 603;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (aly)this.rr.fsV.fta;
    azt localazt = new azt();
    localazt.wSm = paramString2;
    localazt.wSn = paramInt4;
    localazt.wDi = paramFloat2;
    localazt.wDh = paramFloat1;
    localazt.wSl = paramString1;
    localazt.wSk = paramInt3;
    ((aly)localObject).wOE = localazt;
    ((aly)localObject).wXt = paramString3;
    ((aly)localObject).Scene = paramInt2;
    ((aly)localObject).xcF = paramInt5;
    if (paramSKBuiltinBuffer_t == null)
    {
      ((aly)localObject).xcE = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
      ((aly)localObject).wsW = paramInt1;
      if (!paramBoolean2) {
        break label427;
      }
    }
    label427:
    for (int i = 1;; i = 0)
    {
      ((aly)localObject).xcG = i;
      this.pem = paramBoolean1;
      ab.d("MicroMsg.NetSceneGetLbsLifeList", "Req: opcode:" + paramInt1 + " lon:" + paramFloat1 + " lat:" + paramFloat2 + " pre:" + paramInt3 + " gpsSource:" + paramInt4 + " mac" + paramString1 + " cell:" + paramString2 + " scene: " + paramInt2 + " entryTime: " + paramInt5);
      ab.d("MicroMsg.NetSceneGetLbsLifeList", "isLoadMore: %s, buf: %s", new Object[] { Boolean.valueOf(paramBoolean1), Integer.valueOf(((aly)localObject).xcE.getILen()) });
      AppMethodBeat.o(22930);
      return;
      ((aly)localObject).xcE = paramSKBuiltinBuffer_t;
      break;
    }
  }
  
  public static boolean AD(int paramInt)
  {
    AppMethodBeat.i(22927);
    String str = String.valueOf(paramInt);
    if (pei.contains(str))
    {
      AppMethodBeat.o(22927);
      return false;
    }
    pei.add(str);
    AppMethodBeat.o(22927);
    return true;
  }
  
  public static boolean AE(int paramInt)
  {
    AppMethodBeat.i(22928);
    pei.remove(String.valueOf(paramInt));
    AppMethodBeat.o(22928);
    return true;
  }
  
  public static void clear()
  {
    AppMethodBeat.i(22929);
    pei.clear();
    AppMethodBeat.o(22929);
  }
  
  public final SKBuiltinBuffer_t bWG()
  {
    AppMethodBeat.i(22933);
    SKBuiltinBuffer_t localSKBuiltinBuffer_t = ((alz)this.rr.fsW.fta).xcE;
    if (localSKBuiltinBuffer_t == null)
    {
      localSKBuiltinBuffer_t = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
      AppMethodBeat.o(22933);
      return localSKBuiltinBuffer_t;
    }
    AppMethodBeat.o(22933);
    return localSKBuiltinBuffer_t;
  }
  
  public final int bWH()
  {
    return ((alz)this.rr.fsW.fta).wBX;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(22931);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(22931);
    return i;
  }
  
  public final int getType()
  {
    return 603;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(22932);
    ab.d("MicroMsg.NetSceneGetLbsLifeList", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
    paramq = (alz)((b)paramq).fsW.fta;
    this.hng = paramq.wBZ;
    this.oal = paramq.xcO;
    ab.d("MicroMsg.NetSceneGetLbsLifeList", "resp " + paramq.xcL + "searchId " + this.hng);
    if ((paramInt3 == 0) || (paramInt3 == 101)) {}
    for (paramInt1 = 1; (paramInt2 != 0) && (paramInt1 == 0); paramInt1 = 0)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(22932);
      return;
    }
    ab.d("MicroMsg.NetSceneGetLbsLifeList", "continueFlag %d lifeCount %d linkCount %d %s", new Object[] { Integer.valueOf(paramq.wBX), Integer.valueOf(paramq.xcL), Integer.valueOf(paramq.xcJ), paramq.xcN });
    this.pek = bo.bf(paramq.xcN, "");
    this.pel = new ArrayList();
    paramArrayOfByte = paramq.xcM.iterator();
    Object localObject;
    while (paramArrayOfByte.hasNext())
    {
      localObject = (azs)paramArrayOfByte.next();
      localObject = new a(paramq.wBZ, (azs)localObject);
      this.pel.add(localObject);
    }
    if (paramq.xcL > 0)
    {
      paramArrayOfByte = (azs)paramq.xcM.get(0);
      paramq = new StringBuffer();
      paramq.append(" Bid " + paramArrayOfByte.pdW);
      paramq.append(" title " + paramArrayOfByte.Title);
      paramq.append(" link " + paramArrayOfByte.ped);
      paramq.append(" price " + paramArrayOfByte.pdX);
      paramq.append(" rate " + paramArrayOfByte.pec);
      paramq.append(" type " + paramArrayOfByte.jKs);
      paramq.append(" desc : ");
      paramArrayOfByte = paramArrayOfByte.peb.iterator();
      while (paramArrayOfByte.hasNext())
      {
        localObject = (bwc)paramArrayOfByte.next();
        paramq.append(((bwc)localObject).xJE + "-");
      }
      ab.d("MicroMsg.NetSceneGetLbsLifeList", "resp one %s ", new Object[] { paramq.toString() });
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(22932);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.b.c
 * JD-Core Version:    0.7.0.1
 */