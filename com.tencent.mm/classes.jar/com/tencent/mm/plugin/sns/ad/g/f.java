package com.tencent.mm.plugin.sns.ad.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.sns.b.h;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.protocal.protobuf.bv;
import com.tencent.mm.protocal.protobuf.bw;
import com.tencent.mm.sdk.platformtools.Log;

public final class f
  extends q
  implements m
{
  public i callback;
  private d rr;
  
  public f(long paramLong1, String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, int paramInt4, String paramString3, int paramInt5, b paramb1, b paramb2, long paramLong2, String paramString4, String paramString5, a parama)
  {
    AppMethodBeat.i(192747);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new bv();
    ((d.a)localObject).iLO = new bw();
    int i = o.DCS.IY(paramLong1);
    if (i != 2)
    {
      ((d.a)localObject).uri = "/cgi-bin/mmoc-bin/ad/click";
      ((d.a)localObject).funcId = 1232;
    }
    for (;;)
    {
      ((d.a)localObject).iLP = 0;
      ((d.a)localObject).respCmdId = 0;
      this.rr = ((d.a)localObject).aXF();
      Log.i("MicroMsg.NetSceneAdClick", "source %d, uri %s", new Object[] { Integer.valueOf(i), this.rr.getUri() });
      localObject = (bv)this.rr.iLK.iLR;
      ((bv)localObject).KFK = paramInt1;
      ((bv)localObject).DvI = paramString1;
      ((bv)localObject).scene = paramInt3;
      ((bv)localObject).KFL = paramString2;
      ((bv)localObject).KFM = System.currentTimeMillis();
      ((bv)localObject).KFO = paramInt4;
      ((bv)localObject).KFP = paramInt2;
      ((bv)localObject).source = i;
      ((bv)localObject).KFQ = paramString3;
      ((bv)localObject).KFR = paramInt5;
      ((bv)localObject).KFU = paramLong2;
      ((bv)localObject).Dsg = com.tencent.mm.plugin.sns.ad.b.a.aoK();
      ((bv)localObject).imei = com.tencent.mm.plugin.sns.ad.b.a.eWE();
      ((bv)localObject).KFI = paramString4;
      ((bv)localObject).KFH = paramString5;
      if (paramb2 != null) {
        ((bv)localObject).KFT = paramb2;
      }
      if (paramb1 != null) {
        ((bv)localObject).KFS = paramb1;
      }
      ((bv)localObject).KFV = parama.Dur;
      ((bv)localObject).KFW = parama.Duq;
      ((bv)localObject).KFX = parama.Dup;
      ((bv)localObject).KFG = com.tencent.mm.plugin.sns.ad.b.a.eWC();
      ((bv)localObject).KFF = com.tencent.mm.plugin.sns.ad.i.f.eYk();
      try
      {
        parama = new StringBuilder();
        paramString2 = parama.append("##snsId:").append(paramLong1).append(", clickPos:").append(paramInt1).append(", clickAction:").append(paramInt2).append(", sceneType:").append(paramInt3).append(", descXml:").append(paramString2).append(", adtype:").append(paramInt4).append(", snsStatStr:").append(paramString3).append(", flipStatus:").append(paramInt5).append(", remind_source_info.length:");
        if (paramb1 == null)
        {
          paramInt1 = 0;
          label421:
          paramString2 = paramString2.append(paramInt1).append(", remind_self_info.length:");
          if (paramb2 != null) {
            break label665;
          }
          paramInt1 = 0;
          label443:
          paramString2.append(paramInt1).append(", exposure_start_time:").append(paramLong2).append(", followStatus:").append(((bv)localObject).KFW).append(", installStatus:").append(((bv)localObject).KFX).append(", videoCurTime:").append(((bv)localObject).KFV).append(", oaid:").append(((bv)localObject).Dsg).append(", imei:").append(((bv)localObject).imei).append(", waidPkg:").append(paramString4).append(", waid:").append(paramString5).append(", ua:").append(((bv)localObject).KFF).append(", common_device_id:").append(((bv)localObject).KFG);
          Log.i("MicroMsg.NetSceneAdClick", parama.toString());
          paramString2 = new StringBuilder("viewId.length=");
          if (paramString1 != null) {
            break label676;
          }
        }
        label665:
        label676:
        for (paramInt1 = 0;; paramInt1 = paramString1.length())
        {
          Log.i("MicroMsg.NetSceneAdClick", paramInt1 + ", viewId=" + paramString1);
          AppMethodBeat.o(192747);
          return;
          ((d.a)localObject).uri = "/cgi-bin/mmux-bin/adclick";
          ((d.a)localObject).funcId = 1817;
          break;
          paramInt1 = paramb1.zy.length;
          break label421;
          paramInt1 = paramb2.zy.length;
          break label443;
        }
        return;
      }
      catch (Throwable paramString1)
      {
        Log.e("MicroMsg.NetSceneAdClick", paramString1.toString());
        AppMethodBeat.o(192747);
      }
    }
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(125683);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(125683);
    return i;
  }
  
  public final int getType()
  {
    return 1232;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(125684);
    Log.d("MicroMsg.NetSceneAdClick", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(125684);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.g.f
 * JD-Core Version:    0.7.0.1
 */