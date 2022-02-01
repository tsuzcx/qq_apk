package com.tencent.mm.plugin.voip_cs.c.c;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.voip.model.r;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip_cs.c.c;
import com.tencent.mm.protocal.protobuf.fdq;
import com.tencent.mm.protocal.protobuf.fdr;
import com.tencent.mm.protocal.protobuf.fds;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class e
  extends q
  implements m
{
  private i callback;
  public com.tencent.mm.an.d rr;
  
  public e(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(125434);
    Object localObject1 = new d.a();
    ((d.a)localObject1).lBU = new fdr();
    ((d.a)localObject1).lBV = new fds();
    ((d.a)localObject1).uri = "/cgi-bin/micromsg-bin/csvoipreport";
    ((d.a)localObject1).funcId = 312;
    ((d.a)localObject1).lBW = 0;
    ((d.a)localObject1).respCmdId = 0;
    this.rr = ((d.a)localObject1).bgN();
    localObject1 = (fdr)d.b.b(this.rr.lBR);
    ((fdr)localObject1).Urf = paramLong1;
    ((fdr)localObject1).Svv = paramLong2;
    Object localObject2 = ((fdr)localObject1).UDD;
    Object localObject3 = c.gEX();
    Object localObject4 = new fdq();
    ((fdq)localObject4).rWu = 1;
    ((fdq)localObject4).RXT = ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).DRg;
    Log.i("MicroMsg.VoipCSReportHelper", "getVoipCSChannelReportData, result: %s", new Object[] { ((fdq)localObject4).RXT });
    ((LinkedList)localObject2).add(localObject4);
    ((fdr)localObject1).UDD.add(c.gEX().gFa());
    localObject2 = ((fdr)localObject1).UDD;
    localObject3 = c.gEX();
    localObject4 = new fdq();
    ((fdq)localObject4).rWu = 3;
    ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).NRb = com.tencent.mm.plugin.audio.c.a.crq();
    ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).alV(com.tencent.mm.plugin.voip_cs.c.a.a.gFf().tRS.gDx());
    int i = ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).cpuFlag0 & 0xFF;
    ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).NSH = i;
    ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).NSH = i;
    ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).Ojc = c.gEV().Okf.field_audioDuration;
    ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).Ojd = c.gEV().Okf.field_videoDuration;
    if ((((com.tencent.mm.plugin.voip_cs.c.d)localObject3).OiI != 1) && (((com.tencent.mm.plugin.voip_cs.c.d)localObject3).Ojo != 1))
    {
      ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).OiU = 1;
      ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).OiN = com.tencent.mm.plugin.voip.c.e.getNetType(MMApplicationContext.getContext());
      com.tencent.mm.plugin.voip_cs.c.a locala = c.gEV().Okf;
      locala.setJNIAppCmd(1, locala.NSr, locala.NSr.length);
      i = (int)(v2protocal.cD(locala.NSr) / 1000L);
      if ((((com.tencent.mm.plugin.voip_cs.c.d)localObject3).Ojj == 0) || (i <= ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).Ojj)) {
        break label1617;
      }
      i -= ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).Ojj;
      label403:
      ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).Ojb = i;
      ((fdq)localObject4).RXT = (((com.tencent.mm.plugin.voip_cs.c.d)localObject3).NQW + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).roomId + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).DPJ + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).OiL + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).OiM + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).NQG + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).OiN + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).OiO + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).OiP + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).OiQ + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).NRb + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).NRa + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).OiR + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).OiS + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).OiT + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).OiU + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).OiV + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).OiW + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).OiX + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).OiY + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).OiZ + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).Oja + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).Ojb + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).DQW + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).Ojc + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).Ojd + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).channelStrategy + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).NSH + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).NRc + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).Oje + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).Ojf + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).Ojg + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).deviceModel + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).Ojh + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).Oji);
      Log.i("MicroMsg.VoipCSReportHelper", "getVoipCSClientReportData, result: %s", new Object[] { ((fdq)localObject4).RXT });
      ((LinkedList)localObject2).add(localObject4);
      localObject1 = ((fdr)localObject1).UDD;
      localObject2 = c.gEX();
      localObject3 = new fdq();
      ((fdq)localObject3).rWu = 4;
      ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).networkType = com.tencent.mm.plugin.voip_cs.c.d.getNetType(MMApplicationContext.getContext());
      localObject4 = ((TelephonyManager)MMApplicationContext.getContext().getSystemService("phone")).getSimOperator();
      if (localObject4 == null) {
        break label1657;
      }
      if ((!((String)localObject4).equals("46000")) && (!((String)localObject4).equals("46002")) && (!((String)localObject4).equals("46007"))) {
        break label1623;
      }
      i = 1;
      label1000:
      ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).OiJ = i;
      ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).OiA = ((int)(System.currentTimeMillis() / 1000L));
      ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).OiK = com.tencent.mm.plugin.voip_cs.c.d.gFb();
      ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).NRb = com.tencent.mm.plugin.audio.c.a.crq();
      localObject4 = r.gzC();
      if (((r)localObject4).NOV == 0) {
        break label1663;
      }
      i = ((r)localObject4).NOU / ((r)localObject4).NOV;
      label1062:
      ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).kmJ = i;
      if (((com.tencent.mm.plugin.voip_cs.c.d)localObject2).kmJ == -1)
      {
        localObject4 = new byte[4];
        if (c.gEV().Okf.setAppCmd(10, (byte[])localObject4, 4) >= 0) {
          break label1669;
        }
        ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).kmJ = 0;
        Log.d("MicroMsg.VoipCSReportHelper", "get netStatus failed");
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.VoipCSReportHelper", "getVoipCSThirdPartData Report dataType=%d, dataTime=%s, isClickClose=%d, clickCloseTime=%s, videoFps=%d, videoRate=%d, cameraPixelWidth=%d, cameraPixelHeight=%d, recordPixelWidth=%d, recordPixelHeight=%d, cameraState=%d, networkType=%s, mobileType=%s, mobileNetworkType=%s, networkQuality=%d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.voip_cs.c.d)localObject2).dataType), Integer.valueOf(((com.tencent.mm.plugin.voip_cs.c.d)localObject2).OiA), Integer.valueOf(((com.tencent.mm.plugin.voip_cs.c.d)localObject2).OiB), Integer.valueOf(((com.tencent.mm.plugin.voip_cs.c.d)localObject2).OiC), Integer.valueOf(((com.tencent.mm.plugin.voip_cs.c.d)localObject2).videoFps), Integer.valueOf(((com.tencent.mm.plugin.voip_cs.c.d)localObject2).OiD), Integer.valueOf(((com.tencent.mm.plugin.voip_cs.c.d)localObject2).OiE), Integer.valueOf(((com.tencent.mm.plugin.voip_cs.c.d)localObject2).OiF), Integer.valueOf(((com.tencent.mm.plugin.voip_cs.c.d)localObject2).OiG), Integer.valueOf(((com.tencent.mm.plugin.voip_cs.c.d)localObject2).OiH), Integer.valueOf(((com.tencent.mm.plugin.voip_cs.c.d)localObject2).OiI), Integer.valueOf(((com.tencent.mm.plugin.voip_cs.c.d)localObject2).networkType), Integer.valueOf(((com.tencent.mm.plugin.voip_cs.c.d)localObject2).OiJ), Integer.valueOf(((com.tencent.mm.plugin.voip_cs.c.d)localObject2).OiK), Integer.valueOf(((com.tencent.mm.plugin.voip_cs.c.d)localObject2).kmJ) });
      ((fdq)localObject3).RXT = (((com.tencent.mm.plugin.voip_cs.c.d)localObject2).dataType + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).OiA + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).OiB + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).OiC + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).videoFps + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).OiD + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).OiE + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).OiF + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).OiG + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).OiH + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).OiI + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).networkType + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).OiJ + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).OiK + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).kmJ + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).roomId + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).DPJ);
      Log.d("MicroMsg.VoipCSReportHelper", "getVoipCSThirdPartData, result: " + ((fdq)localObject3).RXT);
      ((LinkedList)localObject1).add(localObject3);
      AppMethodBeat.o(125434);
      return;
      if (((com.tencent.mm.plugin.voip_cs.c.d)localObject3).OiI != 1)
      {
        ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).OiU = 2;
        break;
      }
      if (((com.tencent.mm.plugin.voip_cs.c.d)localObject3).Ojo != 1)
      {
        ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).OiU = 3;
        break;
      }
      ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).OiU = 0;
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
      ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).kmJ = Util.byteArrayToInt((byte[])localObject4);
    }
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(125436);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(125436);
    return i;
  }
  
  public final int getType()
  {
    return 312;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(125435);
    Log.i("MicroMsg.NetSceneVoipCSReport", "onGYNetEnd, errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(125435);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.c.c.e
 * JD-Core Version:    0.7.0.1
 */