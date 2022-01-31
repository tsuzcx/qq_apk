package com.tencent.mm.plugin.sns.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.protocal.protobuf.bh;
import com.tencent.mm.protocal.protobuf.bi;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;

public final class c
  extends m
  implements k
{
  public f callback;
  private com.tencent.mm.ai.b rr;
  
  public c(long paramLong1, String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, int paramInt4, String paramString3, int paramInt5, com.tencent.mm.bv.b paramb1, com.tencent.mm.bv.b paramb2, long paramLong2)
  {
    AppMethodBeat.i(152148);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new bh();
    ((b.a)localObject).fsY = new bi();
    int j = n.raW.ln(paramLong1);
    if (j != 2)
    {
      ((b.a)localObject).uri = "/cgi-bin/mmoc-bin/ad/click";
      ((b.a)localObject).funcId = 1232;
      ((b.a)localObject).reqCmdId = 0;
      ((b.a)localObject).respCmdId = 0;
      this.rr = ((b.a)localObject).ado();
      ab.i("MicroMsg.NetSceneAdClick", "source %d, uri %s", new Object[] { Integer.valueOf(j), this.rr.getUri() });
      localObject = new StringBuilder("snsId:").append(paramLong1).append(" viewId:").append(paramString1).append(" clickPos:").append(paramInt1).append(" clickAction:").append(paramInt2).append(" sceneType:").append(paramInt3).append(" descXml:").append(paramString2).append(" adtype:").append(paramInt4).append(" snsStatStr:").append(paramString3).append(" flipStatus:").append(paramInt5).append(" remind_source_info.length:");
      if (paramb1 == null) {
        break label456;
      }
      i = paramb1.pW.length;
      label236:
      localObject = ((StringBuilder)localObject).append(String.valueOf(i)).append(" remind_self_info.length:");
      if (paramb2 == null) {
        break label462;
      }
    }
    label456:
    label462:
    for (int i = paramb2.pW.length;; i = 0)
    {
      ab.i("MicroMsg.NetSceneAdClick", String.valueOf(i) + " exposure_start_time:" + paramLong2);
      localObject = (bh)this.rr.fsV.fta;
      ((bh)localObject).wnF = paramInt1;
      ((bh)localObject).qZx = paramString1;
      ((bh)localObject).scene = paramInt3;
      ((bh)localObject).wnG = paramString2;
      ((bh)localObject).bssid = at.gY(ah.getContext());
      ((bh)localObject).ssid = at.gX(ah.getContext());
      ((bh)localObject).wnH = System.currentTimeMillis();
      ((bh)localObject).wnJ = paramInt4;
      ((bh)localObject).wnK = paramInt2;
      ((bh)localObject).cpt = j;
      ((bh)localObject).wnL = paramString3;
      ((bh)localObject).wnM = paramInt5;
      ((bh)localObject).wnP = paramLong2;
      if (paramb2 != null) {
        ((bh)localObject).wnO = paramb2;
      }
      if (paramb1 != null) {
        ((bh)localObject).wnN = paramb1;
      }
      AppMethodBeat.o(152148);
      return;
      ((b.a)localObject).uri = "/cgi-bin/mmux-bin/adclick";
      ((b.a)localObject).funcId = 1817;
      break;
      i = 0;
      break label236;
    }
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(94484);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(94484);
    return i;
  }
  
  public final int getType()
  {
    return 1232;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(94485);
    ab.d("MicroMsg.NetSceneAdClick", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(94485);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.a.b.c
 * JD-Core Version:    0.7.0.1
 */