package com.tencent.mm.plugin.voip_cs.b.c;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.compatible.b.g;
import com.tencent.mm.network.k;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.video.h;
import com.tencent.mm.plugin.voip_cs.b.c;
import com.tencent.mm.plugin.voip_cs.b.d;
import com.tencent.mm.protocal.protobuf.csb;
import com.tencent.mm.protocal.protobuf.csc;
import com.tencent.mm.protocal.protobuf.csd;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;

public final class e
  extends m
  implements k
{
  private f callback;
  public b rr;
  
  public e(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(135383);
    Object localObject1 = new b.a();
    ((b.a)localObject1).fsX = new csc();
    ((b.a)localObject1).fsY = new csd();
    ((b.a)localObject1).uri = "/cgi-bin/micromsg-bin/csvoipreport";
    ((b.a)localObject1).funcId = 312;
    ((b.a)localObject1).reqCmdId = 0;
    ((b.a)localObject1).respCmdId = 0;
    this.rr = ((b.a)localObject1).ado();
    localObject1 = (csc)this.rr.fsV.fta;
    ((csc)localObject1).xSP = paramLong1;
    ((csc)localObject1).wQQ = paramLong2;
    Object localObject2 = ((csc)localObject1).yaV;
    Object localObject3 = c.cQo();
    Object localObject4 = new csb();
    ((csb)localObject4).jKs = 1;
    ((csb)localObject4).yaU = ((d)localObject3).nOB;
    ab.i("MicroMsg.VoipCSReportHelper", "getVoipCSChannelReportData, result: %s", new Object[] { ((csb)localObject4).yaU });
    ((LinkedList)localObject2).add(localObject4);
    ((csc)localObject1).yaV.add(c.cQo().cQr());
    localObject2 = ((csc)localObject1).yaV;
    localObject3 = c.cQo();
    localObject4 = new csb();
    ((csb)localObject4).jKs = 3;
    ((d)localObject3).tAu = g.KC().KT();
    ((d)localObject3).Id(com.tencent.mm.plugin.voip_cs.b.a.a.cQv().tzl.cPO());
    int i = ((d)localObject3).cpuFlag0 & 0xFF;
    ((d)localObject3).tBM = i;
    ((d)localObject3).tBM = i;
    ((d)localObject3).tKu = c.cQm().tLy.field_audioDuration;
    ((d)localObject3).tKv = c.cQm().tLy.field_videoDuration;
    if ((((d)localObject3).tJY != 1) && (((d)localObject3).tKG != 1))
    {
      ((d)localObject3).tKm = 1;
      ((d)localObject3).tKf = com.tencent.mm.plugin.voip.a.a.getNetType(ah.getContext());
      com.tencent.mm.plugin.voip_cs.b.a locala = c.cQm().tLy;
      locala.setJNIAppCmd(1, locala.tBw, locala.tBw.length);
      i = (int)(v2protocal.bw(locala.tBw) / 1000L);
      if ((((d)localObject3).tKB == 0) || (i <= ((d)localObject3).tKB)) {
        break label1623;
      }
      i -= ((d)localObject3).tKB;
      label406:
      ((d)localObject3).tKt = i;
      ((csb)localObject4).yaU = (((d)localObject3).tAo + "," + ((d)localObject3).tKc + "," + ((d)localObject3).nNa + "," + ((d)localObject3).tKd + "," + ((d)localObject3).tKe + "," + ((d)localObject3).tzZ + "," + ((d)localObject3).tKf + "," + ((d)localObject3).tKg + "," + ((d)localObject3).tKh + "," + ((d)localObject3).tKi + "," + ((d)localObject3).tAu + "," + ((d)localObject3).tAt + "," + ((d)localObject3).tKj + "," + ((d)localObject3).tKk + "," + ((d)localObject3).tKl + "," + ((d)localObject3).tKm + "," + ((d)localObject3).tKn + "," + ((d)localObject3).tKo + "," + ((d)localObject3).tKp + "," + ((d)localObject3).tKq + "," + ((d)localObject3).tKr + "," + ((d)localObject3).tKs + "," + ((d)localObject3).tKt + "," + ((d)localObject3).nOr + "," + ((d)localObject3).tKu + "," + ((d)localObject3).tKv + "," + ((d)localObject3).channelStrategy + "," + ((d)localObject3).tBM + "," + ((d)localObject3).tAv + "," + ((d)localObject3).tKw + "," + ((d)localObject3).tKx + "," + ((d)localObject3).tKy + "," + ((d)localObject3).deviceModel + "," + ((d)localObject3).tKz + "," + ((d)localObject3).tKA);
      ab.i("MicroMsg.VoipCSReportHelper", "getVoipCSClientReportData, result: %s", new Object[] { ((csb)localObject4).yaU });
      ((LinkedList)localObject2).add(localObject4);
      localObject1 = ((csc)localObject1).yaV;
      localObject2 = c.cQo();
      localObject3 = new csb();
      ((csb)localObject3).jKs = 4;
      ((d)localObject2).networkType = d.getNetType(ah.getContext());
      localObject4 = ((TelephonyManager)ah.getContext().getSystemService("phone")).getSimOperator();
      if (localObject4 == null) {
        break label1663;
      }
      if ((!((String)localObject4).equals("46000")) && (!((String)localObject4).equals("46002")) && (!((String)localObject4).equals("46007"))) {
        break label1629;
      }
      i = 1;
      label1003:
      ((d)localObject2).tJZ = i;
      ((d)localObject2).tJQ = ((int)(System.currentTimeMillis() / 1000L));
      ((d)localObject2).tKa = d.cQs();
      ((d)localObject2).tAu = g.KC().KT();
      localObject4 = com.tencent.mm.plugin.voip.model.q.cNr();
      if (((com.tencent.mm.plugin.voip.model.q)localObject4).tyH == 0) {
        break label1669;
      }
      i = ((com.tencent.mm.plugin.voip.model.q)localObject4).tyG / ((com.tencent.mm.plugin.voip.model.q)localObject4).tyH;
      label1068:
      ((d)localObject2).tKb = i;
      if (((d)localObject2).tKb == -1)
      {
        localObject4 = new byte[4];
        if (c.cQm().tLy.setAppCmd(10, (byte[])localObject4, 4) >= 0) {
          break label1675;
        }
        ((d)localObject2).tKb = 0;
        ab.d("MicroMsg.VoipCSReportHelper", "get netStatus failed");
      }
    }
    for (;;)
    {
      ab.i("MicroMsg.VoipCSReportHelper", "getVoipCSThirdPartData Report dataType=%d, dataTime=%s, isClickClose=%d, clickCloseTime=%s, videoFps=%d, videoRate=%d, cameraPixelWidth=%d, cameraPixelHeight=%d, recordPixelWidth=%d, recordPixelHeight=%d, cameraState=%d, networkType=%s, mobileType=%s, mobileNetworkType=%s, networkQuality=%d", new Object[] { Integer.valueOf(((d)localObject2).dataType), Integer.valueOf(((d)localObject2).tJQ), Integer.valueOf(((d)localObject2).tJR), Integer.valueOf(((d)localObject2).tJS), Integer.valueOf(((d)localObject2).videoFps), Integer.valueOf(((d)localObject2).tJT), Integer.valueOf(((d)localObject2).tJU), Integer.valueOf(((d)localObject2).tJV), Integer.valueOf(((d)localObject2).tJW), Integer.valueOf(((d)localObject2).tJX), Integer.valueOf(((d)localObject2).tJY), Integer.valueOf(((d)localObject2).networkType), Integer.valueOf(((d)localObject2).tJZ), Integer.valueOf(((d)localObject2).tKa), Integer.valueOf(((d)localObject2).tKb) });
      ((csb)localObject3).yaU = (((d)localObject2).dataType + "," + ((d)localObject2).tJQ + "," + ((d)localObject2).tJR + "," + ((d)localObject2).tJS + "," + ((d)localObject2).videoFps + "," + ((d)localObject2).tJT + "," + ((d)localObject2).tJU + "," + ((d)localObject2).tJV + "," + ((d)localObject2).tJW + "," + ((d)localObject2).tJX + "," + ((d)localObject2).tJY + "," + ((d)localObject2).networkType + "," + ((d)localObject2).tJZ + "," + ((d)localObject2).tKa + "," + ((d)localObject2).tKb + "," + ((d)localObject2).tKc + "," + ((d)localObject2).nNa);
      ab.d("MicroMsg.VoipCSReportHelper", "getVoipCSThirdPartData, result: " + ((csb)localObject3).yaU);
      ((LinkedList)localObject1).add(localObject3);
      AppMethodBeat.o(135383);
      return;
      if (((d)localObject3).tJY != 1)
      {
        ((d)localObject3).tKm = 2;
        break;
      }
      if (((d)localObject3).tKG != 1)
      {
        ((d)localObject3).tKm = 3;
        break;
      }
      ((d)localObject3).tKm = 0;
      break;
      label1623:
      i = 0;
      break label406;
      label1629:
      if (((String)localObject4).equals("46001"))
      {
        i = 3;
        break label1003;
      }
      if (((String)localObject4).equals("46003"))
      {
        i = 2;
        break label1003;
      }
      label1663:
      i = 0;
      break label1003;
      label1669:
      i = -1;
      break label1068;
      label1675:
      ((d)localObject2).tKb = bo.bg((byte[])localObject4);
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(135385);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(135385);
    return i;
  }
  
  public final int getType()
  {
    return 312;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(135384);
    ab.i("MicroMsg.NetSceneVoipCSReport", "onGYNetEnd, errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(135384);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.b.c.e
 * JD-Core Version:    0.7.0.1
 */