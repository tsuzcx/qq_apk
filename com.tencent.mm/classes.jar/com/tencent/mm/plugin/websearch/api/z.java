package com.tencent.mm.plugin.websearch.api;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.aci;
import com.tencent.mm.protocal.protobuf.fle;
import com.tencent.mm.protocal.protobuf.flf;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class z
  extends a
  implements m
{
  private v PxJ;
  private i callback;
  private d rr;
  
  public z(v paramv)
  {
    AppMethodBeat.i(117630);
    this.PxJ = paramv;
    this.CeE = paramv.fwe;
    this.zP = paramv.offset;
    this.mScene = paramv.scene;
    this.PxG = paramv.fPp;
    this.PxJ = paramv;
    this.PxH = paramv.IGp;
    Object localObject1 = new d.a();
    ((d.a)localObject1).funcId = getType();
    ((d.a)localObject1).uri = "/cgi-bin/mmsearch-bin/mmwebrecommend";
    ((d.a)localObject1).lBU = new fle();
    ((d.a)localObject1).lBV = new flf();
    this.rr = ((d.a)localObject1).bgN();
    localObject1 = (fle)d.b.b(this.rr.lBR);
    ((fle)localObject1).Sat = paramv.offset;
    ((fle)localObject1).Tkv = ai.anh(1);
    ((fle)localObject1).Udh = paramv.PxU;
    ((fle)localObject1).SYn = paramv.fwe;
    ((fle)localObject1).TwK = ai.czn();
    ((fle)localObject1).CPw = paramv.scene;
    ((fle)localObject1).Sas = paramv.uMC;
    ((fle)localObject1).Udl = paramv.fPw;
    ((fle)localObject1).UJW = paramv.Pya;
    ((fle)localObject1).Ute = paramv.channelId;
    ((fle)localObject1).UJY = paramv.Pym;
    Object localObject2 = new aci();
    ((aci)localObject2).key = "client_system_version";
    ((aci)localObject2).SnV = Build.VERSION.SDK_INT;
    paramv.Pye.add(localObject2);
    ((fle)localObject1).UIj = paramv.Pye;
    ((fle)localObject1).UJX = paramv.sessionId;
    this.fPt = paramv.fIY;
    int i;
    String str;
    int j;
    if (paramv.Pyq)
    {
      i = paramv.scene;
      localObject1 = paramv.sessionId;
      localObject2 = paramv.fPs;
      str = paramv.uMC;
      j = paramv.offset;
      if (paramv.PxU != 1) {
        break label372;
      }
    }
    for (;;)
    {
      ah.a(i, (String)localObject1, (String)localObject2, str, j, bool, paramv.fIY, paramv.fwe, paramv.businessType, paramv.Pyk);
      AppMethodBeat.o(117630);
      return;
      label372:
      bool = false;
    }
  }
  
  private flf gQC()
  {
    AppMethodBeat.i(212234);
    flf localflf = (flf)d.c.b(this.rr.lBS);
    AppMethodBeat.o(212234);
    return localflf;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(117631);
    ar.lr(this.mScene, 2);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(117631);
    return i;
  }
  
  public final String gQp()
  {
    AppMethodBeat.i(117633);
    if (gQC() != null)
    {
      String str = gQC().Tkw;
      AppMethodBeat.o(117633);
      return str;
    }
    AppMethodBeat.o(117633);
    return "";
  }
  
  public final int gQq()
  {
    AppMethodBeat.i(117634);
    if (gQC() != null)
    {
      int i = gQC().UKc;
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
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(117632);
    Log.i("MicroMsg.FTS.NetSceneWebRecommend", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    boolean bool1;
    boolean bool2;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      bool1 = true;
      if (this.PxJ.Pyq)
      {
        paramInt1 = this.PxJ.scene;
        params = this.PxJ.sessionId;
        paramArrayOfByte = this.PxJ.fPs;
        String str = this.PxJ.uMC;
        int i = this.PxJ.offset;
        if (this.PxJ.PxU != 1) {
          break label208;
        }
        bool2 = true;
        label124:
        ah.a(paramInt1, params, paramArrayOfByte, str, i, bool2, this.PxJ.fIY, bool1, this.PxJ.fwe, this.PxJ.businessType, this.PxJ.Pyk);
      }
      if (paramInt3 != -1) {
        break label214;
      }
      ar.lr(this.mScene, 4);
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
        ar.lr(this.mScene, 8);
      } else {
        ar.lr(this.mScene, 3);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.z
 * JD-Core Version:    0.7.0.1
 */