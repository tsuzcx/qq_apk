package com.tencent.mm.plugin.sns.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bl;
import com.tencent.mm.protocal.protobuf.bm;
import com.tencent.mm.protocal.protobuf.bn;
import com.tencent.mm.protocal.protobuf.bo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;

public final class d
  extends m
  implements k
{
  public f callback;
  private com.tencent.mm.ai.b rr;
  
  public d(String paramString1, int paramInt1, int paramInt2, int paramInt3, bl parambl, bo parambo, int paramInt4, String paramString2, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, com.tencent.mm.bv.b paramb1, com.tencent.mm.bv.b paramb2)
  {
    AppMethodBeat.i(35705);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new bm();
    ((b.a)localObject).fsY = new bn();
    if (paramInt6 != 2)
    {
      ((b.a)localObject).uri = "/cgi-bin/mmoc-bin/ad/exposure";
      ((b.a)localObject).funcId = 1231;
      ((b.a)localObject).reqCmdId = 0;
      ((b.a)localObject).respCmdId = 0;
      this.rr = ((b.a)localObject).ado();
      ab.i("MicroMsg.NetSceneAdExposure", "uri %s", new Object[] { this.rr.getUri() });
      localObject = (bm)this.rr.fsV.fta;
      ((bm)localObject).wnY = paramInt3;
      ((bm)localObject).type = paramInt2;
      ((bm)localObject).scene = paramInt1;
      ((bm)localObject).qZx = paramString1;
      ((bm)localObject).wob = paramInt5;
      ((bm)localObject).woc = paramInt7;
      ((bm)localObject).wod = paramInt8;
      ((bm)localObject).wnM = paramInt9;
      if (parambl != null)
      {
        ((bm)localObject).wnZ = parambl;
        ab.i("MicroMsg.NetSceneAdExposure", "exposure_info " + parambl.wnW);
      }
      if (parambo != null)
      {
        ((bm)localObject).woa = parambo;
        ab.i("MicroMsg.NetSceneAdExposure", "social_info " + parambo.wof + " " + parambo.woe);
      }
      ((bm)localObject).bssid = at.gY(ah.getContext());
      ((bm)localObject).ssid = at.gX(ah.getContext());
      ((bm)localObject).wnH = System.currentTimeMillis();
      ((bm)localObject).wnJ = paramInt4;
      if (paramString2 != null) {
        ((bm)localObject).wnG = paramString2;
      }
      if (paramb2 != null) {
        ((bm)localObject).wnO = paramb2;
      }
      if (paramb1 != null) {
        ((bm)localObject).wnN = paramb1;
      }
      paramString1 = new StringBuilder("##viewid:").append(paramString1).append(" scene:").append(paramInt1).append(" exposureScene:").append(paramInt2).append(" duration:").append(paramInt3).append(" feed_duration:").append(paramInt7).append(" feed_full_duration:").append(paramInt8).append(" ad_type:").append(paramInt4).append(" exposureCount:").append(paramInt5).append(" descXml:").append(paramString2).append(" flip_status:").append(paramInt9).append(" self_info.length:");
      if (paramb2 != null) {
        break label502;
      }
      paramInt1 = 0;
      label447:
      paramString1 = paramString1.append(paramInt1).append(" source_info.length:");
      if (paramb1 != null) {
        break label512;
      }
    }
    label512:
    for (paramInt1 = 0;; paramInt1 = paramb1.pW.length)
    {
      ab.i("MicroMsg.NetSceneAdExposure", paramInt1);
      AppMethodBeat.o(35705);
      return;
      ((b.a)localObject).uri = "/cgi-bin/mmux-bin/adexposure";
      ((b.a)localObject).funcId = 1875;
      break;
      label502:
      paramInt1 = paramb2.pW.length;
      break label447;
    }
  }
  
  public d(String paramString, int paramInt1, bo parambo, int paramInt2, int paramInt3, int paramInt4, com.tencent.mm.bv.b paramb1, com.tencent.mm.bv.b paramb2)
  {
    this(paramString, paramInt1, 1, 0, null, parambo, paramInt2, "", paramInt3, paramInt4, 0, 0, 0, paramb1, paramb2);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(35706);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(35706);
    return i;
  }
  
  public final int getType()
  {
    return 1231;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(35707);
    ab.i("MicroMsg.NetSceneAdExposure", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    paramq = (bn)this.rr.fsW.fta;
    ab.i("MicroMsg.NetSceneAdExposure", "resp " + paramq.ret + " msg: " + paramq.bjm);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(35707);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.a.b.d
 * JD-Core Version:    0.7.0.1
 */