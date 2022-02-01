package com.tencent.mm.plugin.voip_cs.c.c;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.voip.model.r;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.video.i;
import com.tencent.mm.plugin.voip_cs.c.d;
import com.tencent.mm.protocal.protobuf.dlw;
import com.tencent.mm.protocal.protobuf.dlx;
import com.tencent.mm.protocal.protobuf.dly;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;

public final class e
  extends n
  implements k
{
  private g callback;
  public b rr;
  
  public e(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(125434);
    Object localObject1 = new b.a();
    ((b.a)localObject1).gUU = new dlx();
    ((b.a)localObject1).gUV = new dly();
    ((b.a)localObject1).uri = "/cgi-bin/micromsg-bin/csvoipreport";
    ((b.a)localObject1).funcId = 312;
    ((b.a)localObject1).reqCmdId = 0;
    ((b.a)localObject1).respCmdId = 0;
    this.rr = ((b.a)localObject1).atI();
    localObject1 = (dlx)this.rr.gUS.gUX;
    ((dlx)localObject1).Erf = paramLong1;
    ((dlx)localObject1).Dea = paramLong2;
    Object localObject2 = ((dlx)localObject1).EBS;
    Object localObject3 = com.tencent.mm.plugin.voip_cs.c.c.dYi();
    Object localObject4 = new dlw();
    ((dlw)localObject4).mBH = 1;
    ((dlw)localObject4).DAq = ((d)localObject3).sCw;
    ad.i("MicroMsg.VoipCSReportHelper", "getVoipCSChannelReportData, result: %s", new Object[] { ((dlw)localObject4).DAq });
    ((LinkedList)localObject2).add(localObject4);
    ((dlx)localObject1).EBS.add(com.tencent.mm.plugin.voip_cs.c.c.dYi().dYl());
    localObject2 = ((dlx)localObject1).EBS;
    localObject3 = com.tencent.mm.plugin.voip_cs.c.c.dYi();
    localObject4 = new dlw();
    ((dlw)localObject4).mBH = 3;
    ((d)localObject3).znM = com.tencent.mm.plugin.audio.c.a.bvD();
    ((d)localObject3).Ra(com.tencent.mm.plugin.voip_cs.c.a.a.dYq().zmt.dXo());
    int i = ((d)localObject3).cpuFlag0 & 0xFF;
    ((d)localObject3).zpp = i;
    ((d)localObject3).zpp = i;
    ((d)localObject3).zCB = com.tencent.mm.plugin.voip_cs.c.c.dYg().zDE.field_audioDuration;
    ((d)localObject3).zCC = com.tencent.mm.plugin.voip_cs.c.c.dYg().zDE.field_videoDuration;
    if ((((d)localObject3).zCg != 1) && (((d)localObject3).zCN != 1))
    {
      ((d)localObject3).zCt = 1;
      ((d)localObject3).zCm = com.tencent.mm.plugin.voip.b.c.getNetType(aj.getContext());
      com.tencent.mm.plugin.voip_cs.c.a locala = com.tencent.mm.plugin.voip_cs.c.c.dYg().zDE;
      locala.setJNIAppCmd(1, locala.zoZ, locala.zoZ.length);
      i = (int)(v2protocal.bO(locala.zoZ) / 1000L);
      if ((((d)localObject3).zCI == 0) || (i <= ((d)localObject3).zCI)) {
        break label1617;
      }
      i -= ((d)localObject3).zCI;
      label403:
      ((d)localObject3).zCA = i;
      ((dlw)localObject4).DAq = (((d)localObject3).znG + "," + ((d)localObject3).roomId + "," + ((d)localObject3).sAY + "," + ((d)localObject3).zCk + "," + ((d)localObject3).zCl + "," + ((d)localObject3).znq + "," + ((d)localObject3).zCm + "," + ((d)localObject3).zCn + "," + ((d)localObject3).zCo + "," + ((d)localObject3).zCp + "," + ((d)localObject3).znM + "," + ((d)localObject3).znL + "," + ((d)localObject3).zCq + "," + ((d)localObject3).zCr + "," + ((d)localObject3).zCs + "," + ((d)localObject3).zCt + "," + ((d)localObject3).zCu + "," + ((d)localObject3).zCv + "," + ((d)localObject3).zCw + "," + ((d)localObject3).zCx + "," + ((d)localObject3).zCy + "," + ((d)localObject3).zCz + "," + ((d)localObject3).zCA + "," + ((d)localObject3).sCm + "," + ((d)localObject3).zCB + "," + ((d)localObject3).zCC + "," + ((d)localObject3).channelStrategy + "," + ((d)localObject3).zpp + "," + ((d)localObject3).znN + "," + ((d)localObject3).zCD + "," + ((d)localObject3).zCE + "," + ((d)localObject3).zCF + "," + ((d)localObject3).deviceModel + "," + ((d)localObject3).zCG + "," + ((d)localObject3).zCH);
      ad.i("MicroMsg.VoipCSReportHelper", "getVoipCSClientReportData, result: %s", new Object[] { ((dlw)localObject4).DAq });
      ((LinkedList)localObject2).add(localObject4);
      localObject1 = ((dlx)localObject1).EBS;
      localObject2 = com.tencent.mm.plugin.voip_cs.c.c.dYi();
      localObject3 = new dlw();
      ((dlw)localObject3).mBH = 4;
      ((d)localObject2).networkType = d.getNetType(aj.getContext());
      localObject4 = ((TelephonyManager)aj.getContext().getSystemService("phone")).getSimOperator();
      if (localObject4 == null) {
        break label1657;
      }
      if ((!((String)localObject4).equals("46000")) && (!((String)localObject4).equals("46002")) && (!((String)localObject4).equals("46007"))) {
        break label1623;
      }
      i = 1;
      label1000:
      ((d)localObject2).zCh = i;
      ((d)localObject2).zBY = ((int)(System.currentTimeMillis() / 1000L));
      ((d)localObject2).zCi = d.dYm();
      ((d)localObject2).znM = com.tencent.mm.plugin.audio.c.a.bvD();
      localObject4 = r.dTT();
      if (((r)localObject4).zlH == 0) {
        break label1663;
      }
      i = ((r)localObject4).zlG / ((r)localObject4).zlH;
      label1062:
      ((d)localObject2).zCj = i;
      if (((d)localObject2).zCj == -1)
      {
        localObject4 = new byte[4];
        if (com.tencent.mm.plugin.voip_cs.c.c.dYg().zDE.setAppCmd(10, (byte[])localObject4, 4) >= 0) {
          break label1669;
        }
        ((d)localObject2).zCj = 0;
        ad.d("MicroMsg.VoipCSReportHelper", "get netStatus failed");
      }
    }
    for (;;)
    {
      ad.i("MicroMsg.VoipCSReportHelper", "getVoipCSThirdPartData Report dataType=%d, dataTime=%s, isClickClose=%d, clickCloseTime=%s, videoFps=%d, videoRate=%d, cameraPixelWidth=%d, cameraPixelHeight=%d, recordPixelWidth=%d, recordPixelHeight=%d, cameraState=%d, networkType=%s, mobileType=%s, mobileNetworkType=%s, networkQuality=%d", new Object[] { Integer.valueOf(((d)localObject2).dataType), Integer.valueOf(((d)localObject2).zBY), Integer.valueOf(((d)localObject2).zBZ), Integer.valueOf(((d)localObject2).zCa), Integer.valueOf(((d)localObject2).videoFps), Integer.valueOf(((d)localObject2).zCb), Integer.valueOf(((d)localObject2).zCc), Integer.valueOf(((d)localObject2).zCd), Integer.valueOf(((d)localObject2).zCe), Integer.valueOf(((d)localObject2).zCf), Integer.valueOf(((d)localObject2).zCg), Integer.valueOf(((d)localObject2).networkType), Integer.valueOf(((d)localObject2).zCh), Integer.valueOf(((d)localObject2).zCi), Integer.valueOf(((d)localObject2).zCj) });
      ((dlw)localObject3).DAq = (((d)localObject2).dataType + "," + ((d)localObject2).zBY + "," + ((d)localObject2).zBZ + "," + ((d)localObject2).zCa + "," + ((d)localObject2).videoFps + "," + ((d)localObject2).zCb + "," + ((d)localObject2).zCc + "," + ((d)localObject2).zCd + "," + ((d)localObject2).zCe + "," + ((d)localObject2).zCf + "," + ((d)localObject2).zCg + "," + ((d)localObject2).networkType + "," + ((d)localObject2).zCh + "," + ((d)localObject2).zCi + "," + ((d)localObject2).zCj + "," + ((d)localObject2).roomId + "," + ((d)localObject2).sAY);
      ad.d("MicroMsg.VoipCSReportHelper", "getVoipCSThirdPartData, result: " + ((dlw)localObject3).DAq);
      ((LinkedList)localObject1).add(localObject3);
      AppMethodBeat.o(125434);
      return;
      if (((d)localObject3).zCg != 1)
      {
        ((d)localObject3).zCt = 2;
        break;
      }
      if (((d)localObject3).zCN != 1)
      {
        ((d)localObject3).zCt = 3;
        break;
      }
      ((d)localObject3).zCt = 0;
      break;
      label1617:
      i = 0;
      break label403;
      label1623:
      if (((String)localObject4).equals("46001"))
      {
        i = 3;
        break label1000;
      }
      if (((String)localObject4).equals("46003"))
      {
        i = 2;
        break label1000;
      }
      label1657:
      i = 0;
      break label1000;
      label1663:
      i = -1;
      break label1062;
      label1669:
      ((d)localObject2).zCj = bt.bw((byte[])localObject4);
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, g paramg)
  {
    AppMethodBeat.i(125436);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(125436);
    return i;
  }
  
  public final int getType()
  {
    return 312;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(125435);
    ad.i("MicroMsg.NetSceneVoipCSReport", "onGYNetEnd, errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(125435);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.c.c.e
 * JD-Core Version:    0.7.0.1
 */