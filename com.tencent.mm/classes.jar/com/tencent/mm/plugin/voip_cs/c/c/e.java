package com.tencent.mm.plugin.voip_cs.c.c;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.voip.model.r;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.video.i;
import com.tencent.mm.plugin.voip_cs.c.c;
import com.tencent.mm.plugin.voip_cs.c.d;
import com.tencent.mm.protocal.protobuf.dyy;
import com.tencent.mm.protocal.protobuf.dyz;
import com.tencent.mm.protocal.protobuf.dza;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.LinkedList;

public final class e
  extends n
  implements k
{
  private com.tencent.mm.ak.f callback;
  public b rr;
  
  public e(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(125434);
    Object localObject1 = new b.a();
    ((b.a)localObject1).hQF = new dyz();
    ((b.a)localObject1).hQG = new dza();
    ((b.a)localObject1).uri = "/cgi-bin/micromsg-bin/csvoipreport";
    ((b.a)localObject1).funcId = 312;
    ((b.a)localObject1).hQH = 0;
    ((b.a)localObject1).respCmdId = 0;
    this.rr = ((b.a)localObject1).aDS();
    localObject1 = (dyz)this.rr.hQD.hQJ;
    ((dyz)localObject1).HSD = paramLong1;
    ((dyz)localObject1).Gxr = paramLong2;
    Object localObject2 = ((dyz)localObject1).Iej;
    Object localObject3 = c.eFl();
    Object localObject4 = new dyy();
    ((dyy)localObject4).nJA = 1;
    ((dyy)localObject4).GcA = ((d)localObject3).uYE;
    ae.i("MicroMsg.VoipCSReportHelper", "getVoipCSChannelReportData, result: %s", new Object[] { ((dyy)localObject4).GcA });
    ((LinkedList)localObject2).add(localObject4);
    ((dyz)localObject1).Iej.add(c.eFl().eFo());
    localObject2 = ((dyz)localObject1).Iej;
    localObject3 = c.eFl();
    localObject4 = new dyy();
    ((dyy)localObject4).nJA = 3;
    ((d)localObject3).Cxb = com.tencent.mm.plugin.audio.c.a.bHB();
    ((d)localObject3).VJ(com.tencent.mm.plugin.voip_cs.c.a.a.eFt().ped.eEp());
    int i = ((d)localObject3).cpuFlag0 & 0xFF;
    ((d)localObject3).CyG = i;
    ((d)localObject3).CyG = i;
    ((d)localObject3).CMB = c.eFj().CNE.field_audioDuration;
    ((d)localObject3).CMC = c.eFj().CNE.field_videoDuration;
    if ((((d)localObject3).CMh != 1) && (((d)localObject3).CMN != 1))
    {
      ((d)localObject3).CMt = 1;
      ((d)localObject3).CMm = com.tencent.mm.plugin.voip.b.f.getNetType(ak.getContext());
      com.tencent.mm.plugin.voip_cs.c.a locala = c.eFj().CNE;
      locala.setJNIAppCmd(1, locala.Cyq, locala.Cyq.length);
      i = (int)(v2protocal.bX(locala.Cyq) / 1000L);
      if ((((d)localObject3).CMI == 0) || (i <= ((d)localObject3).CMI)) {
        break label1617;
      }
      i -= ((d)localObject3).CMI;
      label403:
      ((d)localObject3).CMA = i;
      ((dyy)localObject4).GcA = (((d)localObject3).CwV + "," + ((d)localObject3).roomId + "," + ((d)localObject3).uXg + "," + ((d)localObject3).CMk + "," + ((d)localObject3).CMl + "," + ((d)localObject3).CwF + "," + ((d)localObject3).CMm + "," + ((d)localObject3).CMn + "," + ((d)localObject3).CMo + "," + ((d)localObject3).CMp + "," + ((d)localObject3).Cxb + "," + ((d)localObject3).Cxa + "," + ((d)localObject3).CMq + "," + ((d)localObject3).CMr + "," + ((d)localObject3).CMs + "," + ((d)localObject3).CMt + "," + ((d)localObject3).CMu + "," + ((d)localObject3).CMv + "," + ((d)localObject3).CMw + "," + ((d)localObject3).CMx + "," + ((d)localObject3).CMy + "," + ((d)localObject3).CMz + "," + ((d)localObject3).CMA + "," + ((d)localObject3).uYu + "," + ((d)localObject3).CMB + "," + ((d)localObject3).CMC + "," + ((d)localObject3).channelStrategy + "," + ((d)localObject3).CyG + "," + ((d)localObject3).Cxc + "," + ((d)localObject3).CMD + "," + ((d)localObject3).CME + "," + ((d)localObject3).CMF + "," + ((d)localObject3).deviceModel + "," + ((d)localObject3).CMG + "," + ((d)localObject3).CMH);
      ae.i("MicroMsg.VoipCSReportHelper", "getVoipCSClientReportData, result: %s", new Object[] { ((dyy)localObject4).GcA });
      ((LinkedList)localObject2).add(localObject4);
      localObject1 = ((dyz)localObject1).Iej;
      localObject2 = c.eFl();
      localObject3 = new dyy();
      ((dyy)localObject3).nJA = 4;
      ((d)localObject2).networkType = d.getNetType(ak.getContext());
      localObject4 = ((TelephonyManager)ak.getContext().getSystemService("phone")).getSimOperator();
      if (localObject4 == null) {
        break label1657;
      }
      if ((!((String)localObject4).equals("46000")) && (!((String)localObject4).equals("46002")) && (!((String)localObject4).equals("46007"))) {
        break label1623;
      }
      i = 1;
      label1000:
      ((d)localObject2).CMi = i;
      ((d)localObject2).CLZ = ((int)(System.currentTimeMillis() / 1000L));
      ((d)localObject2).CMj = d.eFp();
      ((d)localObject2).Cxb = com.tencent.mm.plugin.audio.c.a.bHB();
      localObject4 = r.eAx();
      if (((r)localObject4).CuW == 0) {
        break label1663;
      }
      i = ((r)localObject4).CuV / ((r)localObject4).CuW;
      label1062:
      ((d)localObject2).gKA = i;
      if (((d)localObject2).gKA == -1)
      {
        localObject4 = new byte[4];
        if (c.eFj().CNE.setAppCmd(10, (byte[])localObject4, 4) >= 0) {
          break label1669;
        }
        ((d)localObject2).gKA = 0;
        ae.d("MicroMsg.VoipCSReportHelper", "get netStatus failed");
      }
    }
    for (;;)
    {
      ae.i("MicroMsg.VoipCSReportHelper", "getVoipCSThirdPartData Report dataType=%d, dataTime=%s, isClickClose=%d, clickCloseTime=%s, videoFps=%d, videoRate=%d, cameraPixelWidth=%d, cameraPixelHeight=%d, recordPixelWidth=%d, recordPixelHeight=%d, cameraState=%d, networkType=%s, mobileType=%s, mobileNetworkType=%s, networkQuality=%d", new Object[] { Integer.valueOf(((d)localObject2).dataType), Integer.valueOf(((d)localObject2).CLZ), Integer.valueOf(((d)localObject2).CMa), Integer.valueOf(((d)localObject2).CMb), Integer.valueOf(((d)localObject2).videoFps), Integer.valueOf(((d)localObject2).CMc), Integer.valueOf(((d)localObject2).CMd), Integer.valueOf(((d)localObject2).CMe), Integer.valueOf(((d)localObject2).CMf), Integer.valueOf(((d)localObject2).CMg), Integer.valueOf(((d)localObject2).CMh), Integer.valueOf(((d)localObject2).networkType), Integer.valueOf(((d)localObject2).CMi), Integer.valueOf(((d)localObject2).CMj), Integer.valueOf(((d)localObject2).gKA) });
      ((dyy)localObject3).GcA = (((d)localObject2).dataType + "," + ((d)localObject2).CLZ + "," + ((d)localObject2).CMa + "," + ((d)localObject2).CMb + "," + ((d)localObject2).videoFps + "," + ((d)localObject2).CMc + "," + ((d)localObject2).CMd + "," + ((d)localObject2).CMe + "," + ((d)localObject2).CMf + "," + ((d)localObject2).CMg + "," + ((d)localObject2).CMh + "," + ((d)localObject2).networkType + "," + ((d)localObject2).CMi + "," + ((d)localObject2).CMj + "," + ((d)localObject2).gKA + "," + ((d)localObject2).roomId + "," + ((d)localObject2).uXg);
      ae.d("MicroMsg.VoipCSReportHelper", "getVoipCSThirdPartData, result: " + ((dyy)localObject3).GcA);
      ((LinkedList)localObject1).add(localObject3);
      AppMethodBeat.o(125434);
      return;
      if (((d)localObject3).CMh != 1)
      {
        ((d)localObject3).CMt = 2;
        break;
      }
      if (((d)localObject3).CMN != 1)
      {
        ((d)localObject3).CMt = 3;
        break;
      }
      ((d)localObject3).CMt = 0;
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
      ((d)localObject2).gKA = bu.bF((byte[])localObject4);
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.f paramf)
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
    ae.i("MicroMsg.NetSceneVoipCSReport", "onGYNetEnd, errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(125435);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.c.c.e
 * JD-Core Version:    0.7.0.1
 */