package com.tencent.mm.plugin.websearch.api;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cyg;
import com.tencent.mm.protocal.protobuf.cyh;
import com.tencent.mm.protocal.protobuf.up;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

public final class t
  extends a
  implements k
{
  private f callback;
  private s fpY;
  private b rr;
  
  public t(s params)
  {
    AppMethodBeat.i(124061);
    this.fpY = params;
    this.uIC = params.cnv;
    this.Fb = params.offset;
    this.mScene = params.scene;
    this.uIB = params.cCT;
    this.fpY = params;
    this.uID = params.uIV;
    Object localObject1 = new b.a();
    ((b.a)localObject1).funcId = getType();
    ((b.a)localObject1).uri = "/cgi-bin/mmsearch-bin/mmwebrecommend";
    ((b.a)localObject1).fsX = new cyg();
    ((b.a)localObject1).fsY = new cyh();
    this.rr = ((b.a)localObject1).ado();
    localObject1 = (cyg)this.rr.fsV.fta;
    ((cyg)localObject1).wzS = params.offset;
    ((cyg)localObject1).xqT = aa.Jf(1);
    ((cyg)localObject1).xHM = params.uIE;
    ((cyg)localObject1).wXt = params.cnv;
    ((cyg)localObject1).xqU = aa.acv();
    ((cyg)localObject1).Scene = params.scene;
    ((cyg)localObject1).wBZ = params.low;
    ((cyg)localObject1).xHQ = params.cDa;
    ((cyg)localObject1).xpG = params.uIK;
    ((cyg)localObject1).xTB = params.bWu;
    ((cyg)localObject1).yfm = params.uIX;
    Object localObject2 = new up();
    ((up)localObject2).key = "client_system_version";
    ((up)localObject2).wMM = Build.VERSION.SDK_INT;
    params.uIO.add(localObject2);
    ((cyg)localObject1).yel = params.uIO;
    ((cyg)localObject1).xpJ = params.cpW;
    this.cCX = params.ohe;
    int i;
    String str;
    int j;
    if (params.uIY)
    {
      i = params.scene;
      localObject1 = params.cpW;
      localObject2 = params.cCW;
      str = params.low;
      j = params.offset;
      if (params.uIE != 1) {
        break label372;
      }
    }
    for (;;)
    {
      z.a(i, (String)localObject1, (String)localObject2, str, j, bool, params.ohe, params.cnv, params.businessType, params.uIU);
      AppMethodBeat.o(124061);
      return;
      label372:
      bool = false;
    }
  }
  
  private cyh cZi()
  {
    return (cyh)this.rr.fsW.fta;
  }
  
  public final String act()
  {
    AppMethodBeat.i(124064);
    if (cZi() != null)
    {
      String str = cZi().wAa;
      AppMethodBeat.o(124064);
      return str;
    }
    AppMethodBeat.o(124064);
    return "";
  }
  
  public final int acu()
  {
    AppMethodBeat.i(124065);
    if (cZi() != null)
    {
      int i = cZi().xpM;
      AppMethodBeat.o(124065);
      return i;
    }
    AppMethodBeat.o(124065);
    return 0;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(124062);
    an.reportIdKey649ForLook(this.mScene, 2);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(124062);
    return i;
  }
  
  public final int getType()
  {
    return 1943;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(124063);
    ab.i("MicroMsg.FTS.NetSceneWebRecommend", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    boolean bool1;
    boolean bool2;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      bool1 = true;
      if (this.fpY.uIY)
      {
        paramInt1 = this.fpY.scene;
        paramq = this.fpY.cpW;
        paramArrayOfByte = this.fpY.cCW;
        String str = this.fpY.low;
        int i = this.fpY.offset;
        if (this.fpY.uIE != 1) {
          break label208;
        }
        bool2 = true;
        label124:
        z.a(paramInt1, paramq, paramArrayOfByte, str, i, bool2, this.fpY.ohe, bool1, this.fpY.cnv, this.fpY.businessType, this.fpY.uIU);
      }
      if (paramInt3 != -1) {
        break label214;
      }
      an.reportIdKey649ForLook(this.mScene, 4);
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(124063);
      return;
      bool1 = false;
      break;
      label208:
      bool2 = false;
      break label124;
      label214:
      if ((paramInt2 != 0) || (paramInt3 != 0)) {
        an.reportIdKey649ForLook(this.mScene, 8);
      } else {
        an.reportIdKey649ForLook(this.mScene, 3);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.t
 * JD-Core Version:    0.7.0.1
 */