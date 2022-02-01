package com.tencent.mm.plugin.voip_cs.c.c;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.voip.model.r;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.video.i;
import com.tencent.mm.plugin.voip_cs.c.c;
import com.tencent.mm.plugin.voip_cs.c.d;
import com.tencent.mm.protocal.protobuf.dxh;
import com.tencent.mm.protocal.protobuf.dxi;
import com.tencent.mm.protocal.protobuf.dxj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;

public final class e
  extends n
  implements k
{
  private com.tencent.mm.al.f callback;
  public b rr;
  
  public e(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(125434);
    Object localObject1 = new b.a();
    ((b.a)localObject1).hNM = new dxi();
    ((b.a)localObject1).hNN = new dxj();
    ((b.a)localObject1).uri = "/cgi-bin/micromsg-bin/csvoipreport";
    ((b.a)localObject1).funcId = 312;
    ((b.a)localObject1).hNO = 0;
    ((b.a)localObject1).respCmdId = 0;
    this.rr = ((b.a)localObject1).aDC();
    localObject1 = (dxi)this.rr.hNK.hNQ;
    ((dxi)localObject1).HyS = paramLong1;
    ((dxi)localObject1).GeJ = paramLong2;
    Object localObject2 = ((dxi)localObject1).HKb;
    Object localObject3 = c.eBD();
    Object localObject4 = new dxh();
    ((dxh)localObject4).nEf = 1;
    ((dxh)localObject4).FKb = ((d)localObject3).uMR;
    ad.i("MicroMsg.VoipCSReportHelper", "getVoipCSChannelReportData, result: %s", new Object[] { ((dxh)localObject4).FKb });
    ((LinkedList)localObject2).add(localObject4);
    ((dxi)localObject1).HKb.add(c.eBD().eBG());
    localObject2 = ((dxi)localObject1).HKb;
    localObject3 = c.eBD();
    localObject4 = new dxh();
    ((dxh)localObject4).nEf = 3;
    ((d)localObject3).CfA = com.tencent.mm.plugin.audio.c.a.bGF();
    ((d)localObject3).Vc(com.tencent.mm.plugin.voip_cs.c.a.a.eBL().oXA.eAH());
    int i = ((d)localObject3).cpuFlag0 & 0xFF;
    ((d)localObject3).Chf = i;
    ((d)localObject3).Chf = i;
    ((d)localObject3).CuW = c.eBB().CvZ.field_audioDuration;
    ((d)localObject3).CuX = c.eBB().CvZ.field_videoDuration;
    if ((((d)localObject3).CuC != 1) && (((d)localObject3).Cvi != 1))
    {
      ((d)localObject3).CuO = 1;
      ((d)localObject3).CuH = com.tencent.mm.plugin.voip.b.f.getNetType(aj.getContext());
      com.tencent.mm.plugin.voip_cs.c.a locala = c.eBB().CvZ;
      locala.setJNIAppCmd(1, locala.CgP, locala.CgP.length);
      i = (int)(v2protocal.bU(locala.CgP) / 1000L);
      if ((((d)localObject3).Cvd == 0) || (i <= ((d)localObject3).Cvd)) {
        break label1617;
      }
      i -= ((d)localObject3).Cvd;
      label403:
      ((d)localObject3).CuV = i;
      ((dxh)localObject4).FKb = (((d)localObject3).Cfu + "," + ((d)localObject3).roomId + "," + ((d)localObject3).uLt + "," + ((d)localObject3).CuF + "," + ((d)localObject3).CuG + "," + ((d)localObject3).Cfe + "," + ((d)localObject3).CuH + "," + ((d)localObject3).CuI + "," + ((d)localObject3).CuJ + "," + ((d)localObject3).CuK + "," + ((d)localObject3).CfA + "," + ((d)localObject3).Cfz + "," + ((d)localObject3).CuL + "," + ((d)localObject3).CuM + "," + ((d)localObject3).CuN + "," + ((d)localObject3).CuO + "," + ((d)localObject3).CuP + "," + ((d)localObject3).CuQ + "," + ((d)localObject3).CuR + "," + ((d)localObject3).CuS + "," + ((d)localObject3).CuT + "," + ((d)localObject3).CuU + "," + ((d)localObject3).CuV + "," + ((d)localObject3).uMH + "," + ((d)localObject3).CuW + "," + ((d)localObject3).CuX + "," + ((d)localObject3).channelStrategy + "," + ((d)localObject3).Chf + "," + ((d)localObject3).CfB + "," + ((d)localObject3).CuY + "," + ((d)localObject3).CuZ + "," + ((d)localObject3).Cva + "," + ((d)localObject3).deviceModel + "," + ((d)localObject3).Cvb + "," + ((d)localObject3).Cvc);
      ad.i("MicroMsg.VoipCSReportHelper", "getVoipCSClientReportData, result: %s", new Object[] { ((dxh)localObject4).FKb });
      ((LinkedList)localObject2).add(localObject4);
      localObject1 = ((dxi)localObject1).HKb;
      localObject2 = c.eBD();
      localObject3 = new dxh();
      ((dxh)localObject3).nEf = 4;
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
      ((d)localObject2).CuD = i;
      ((d)localObject2).Cuu = ((int)(System.currentTimeMillis() / 1000L));
      ((d)localObject2).CuE = d.eBH();
      ((d)localObject2).CfA = com.tencent.mm.plugin.audio.c.a.bGF();
      localObject4 = r.ewQ();
      if (((r)localObject4).Cdv == 0) {
        break label1663;
      }
      i = ((r)localObject4).Cdu / ((r)localObject4).Cdv;
      label1062:
      ((d)localObject2).gHR = i;
      if (((d)localObject2).gHR == -1)
      {
        localObject4 = new byte[4];
        if (c.eBB().CvZ.setAppCmd(10, (byte[])localObject4, 4) >= 0) {
          break label1669;
        }
        ((d)localObject2).gHR = 0;
        ad.d("MicroMsg.VoipCSReportHelper", "get netStatus failed");
      }
    }
    for (;;)
    {
      ad.i("MicroMsg.VoipCSReportHelper", "getVoipCSThirdPartData Report dataType=%d, dataTime=%s, isClickClose=%d, clickCloseTime=%s, videoFps=%d, videoRate=%d, cameraPixelWidth=%d, cameraPixelHeight=%d, recordPixelWidth=%d, recordPixelHeight=%d, cameraState=%d, networkType=%s, mobileType=%s, mobileNetworkType=%s, networkQuality=%d", new Object[] { Integer.valueOf(((d)localObject2).dataType), Integer.valueOf(((d)localObject2).Cuu), Integer.valueOf(((d)localObject2).Cuv), Integer.valueOf(((d)localObject2).Cuw), Integer.valueOf(((d)localObject2).videoFps), Integer.valueOf(((d)localObject2).Cux), Integer.valueOf(((d)localObject2).Cuy), Integer.valueOf(((d)localObject2).Cuz), Integer.valueOf(((d)localObject2).CuA), Integer.valueOf(((d)localObject2).CuB), Integer.valueOf(((d)localObject2).CuC), Integer.valueOf(((d)localObject2).networkType), Integer.valueOf(((d)localObject2).CuD), Integer.valueOf(((d)localObject2).CuE), Integer.valueOf(((d)localObject2).gHR) });
      ((dxh)localObject3).FKb = (((d)localObject2).dataType + "," + ((d)localObject2).Cuu + "," + ((d)localObject2).Cuv + "," + ((d)localObject2).Cuw + "," + ((d)localObject2).videoFps + "," + ((d)localObject2).Cux + "," + ((d)localObject2).Cuy + "," + ((d)localObject2).Cuz + "," + ((d)localObject2).CuA + "," + ((d)localObject2).CuB + "," + ((d)localObject2).CuC + "," + ((d)localObject2).networkType + "," + ((d)localObject2).CuD + "," + ((d)localObject2).CuE + "," + ((d)localObject2).gHR + "," + ((d)localObject2).roomId + "," + ((d)localObject2).uLt);
      ad.d("MicroMsg.VoipCSReportHelper", "getVoipCSThirdPartData, result: " + ((dxh)localObject3).FKb);
      ((LinkedList)localObject1).add(localObject3);
      AppMethodBeat.o(125434);
      return;
      if (((d)localObject3).CuC != 1)
      {
        ((d)localObject3).CuO = 2;
        break;
      }
      if (((d)localObject3).Cvi != 1)
      {
        ((d)localObject3).CuO = 3;
        break;
      }
      ((d)localObject3).CuO = 0;
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
      ((d)localObject2).gHR = bt.bC((byte[])localObject4);
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.f paramf)
  {
    AppMethodBeat.i(125436);
    this.callback = paramf;
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