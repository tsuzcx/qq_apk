package com.tencent.mm.plugin.websearch.api;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dyj;
import com.tencent.mm.protocal.protobuf.dyk;
import com.tencent.mm.protocal.protobuf.yh;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.LinkedList;

public final class s
  extends a
  implements k
{
  private p BYB;
  private g callback;
  private b rr;
  
  public s(p paramp)
  {
    AppMethodBeat.i(117630);
    this.BYB = paramp;
    this.sTA = paramp.cZL;
    this.MW = paramp.offset;
    this.mScene = paramp.scene;
    this.BYb = paramp.drc;
    this.BYB = paramp;
    this.BYc = paramp.wWc;
    Object localObject1 = new b.a();
    ((b.a)localObject1).funcId = getType();
    ((b.a)localObject1).uri = "/cgi-bin/mmsearch-bin/mmwebrecommend";
    ((b.a)localObject1).hvt = new dyj();
    ((b.a)localObject1).hvu = new dyk();
    this.rr = ((b.a)localObject1).aAz();
    localObject1 = (dyj)this.rr.hvr.hvw;
    ((dyj)localObject1).EfV = paramp.offset;
    ((dyj)localObject1).FhS = z.Ul(1);
    ((dyj)localObject1).FCc = paramp.BYg;
    ((dyj)localObject1).EJp = paramp.cZL;
    ((dyj)localObject1).FhT = z.bJn();
    ((dyj)localObject1).Scene = paramp.scene;
    ((dyj)localObject1).EfU = paramp.pik;
    ((dyj)localObject1).FCg = paramp.drj;
    ((dyj)localObject1).Geu = paramp.BYm;
    ((dyj)localObject1).FPQ = paramp.cGY;
    ((dyj)localObject1).Gew = paramp.BYy;
    Object localObject2 = new yh();
    ((yh)localObject2).key = "client_system_version";
    ((yh)localObject2).ErV = Build.VERSION.SDK_INT;
    paramp.BYq.add(localObject2);
    ((dyj)localObject1).Gdj = paramp.BYq;
    ((dyj)localObject1).Gev = paramp.sessionId;
    this.drg = paramp.dlj;
    int i;
    String str;
    int j;
    if (paramp.BYz)
    {
      i = paramp.scene;
      localObject1 = paramp.sessionId;
      localObject2 = paramp.drf;
      str = paramp.pik;
      j = paramp.offset;
      if (paramp.BYg != 1) {
        break label372;
      }
    }
    for (;;)
    {
      y.a(i, (String)localObject1, (String)localObject2, str, j, bool, paramp.dlj, paramp.cZL, paramp.businessType, paramp.BYw);
      AppMethodBeat.o(117630);
      return;
      label372:
      bool = false;
    }
  }
  
  private dyk exh()
  {
    return (dyk)this.rr.hvs.hvw;
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(117631);
    ai.iE(this.mScene, 2);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(117631);
    return i;
  }
  
  public final String ewZ()
  {
    AppMethodBeat.i(117633);
    if (exh() != null)
    {
      String str = exh().FhN;
      AppMethodBeat.o(117633);
      return str;
    }
    AppMethodBeat.o(117633);
    return "";
  }
  
  public final int exa()
  {
    AppMethodBeat.i(117634);
    if (exh() != null)
    {
      int i = exh().GeA;
      AppMethodBeat.o(117634);
      return i;
    }
    AppMethodBeat.o(117634);
    return 0;
  }
  
  public final int getType()
  {
    return 1943;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(117632);
    ac.i("MicroMsg.FTS.NetSceneWebRecommend", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    boolean bool1;
    boolean bool2;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      bool1 = true;
      if (this.BYB.BYz)
      {
        paramInt1 = this.BYB.scene;
        paramq = this.BYB.sessionId;
        paramArrayOfByte = this.BYB.drf;
        String str = this.BYB.pik;
        int i = this.BYB.offset;
        if (this.BYB.BYg != 1) {
          break label208;
        }
        bool2 = true;
        label124:
        y.a(paramInt1, paramq, paramArrayOfByte, str, i, bool2, this.BYB.dlj, bool1, this.BYB.cZL, this.BYB.businessType, this.BYB.BYw);
      }
      if (paramInt3 != -1) {
        break label214;
      }
      ai.iE(this.mScene, 4);
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(117632);
      return;
      bool1 = false;
      break;
      label208:
      bool2 = false;
      break label124;
      label214:
      if ((paramInt2 != 0) || (paramInt3 != 0)) {
        ai.iE(this.mScene, 8);
      } else {
        ai.iE(this.mScene, 3);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.s
 * JD-Core Version:    0.7.0.1
 */