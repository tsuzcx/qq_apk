package com.tencent.mm.plugin.voip_cs.b.c;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.voip.model.p;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.video.i;
import com.tencent.mm.plugin.voip_cs.b.c;
import com.tencent.mm.plugin.voip_cs.b.d;
import com.tencent.mm.protocal.c.ceq;
import com.tencent.mm.protocal.c.cer;
import com.tencent.mm.protocal.c.ces;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

public final class e
  extends m
  implements k
{
  public b dmK;
  private com.tencent.mm.ah.f dmL;
  
  public e(long paramLong1, long paramLong2)
  {
    Object localObject1 = new b.a();
    ((b.a)localObject1).ecH = new cer();
    ((b.a)localObject1).ecI = new ces();
    ((b.a)localObject1).uri = "/cgi-bin/micromsg-bin/csvoipreport";
    ((b.a)localObject1).ecG = 312;
    ((b.a)localObject1).ecJ = 0;
    ((b.a)localObject1).ecK = 0;
    this.dmK = ((b.a)localObject1).Kt();
    localObject1 = (cer)this.dmK.ecE.ecN;
    ((cer)localObject1).tTo = paramLong1;
    ((cer)localObject1).sSU = paramLong2;
    Object localObject2 = ((cer)localObject1).tTE;
    Object localObject3 = c.bSQ();
    Object localObject4 = new ceq();
    ((ceq)localObject4).hQR = 1;
    ((ceq)localObject4).tTD = ((d)localObject3).lrf;
    y.i("MicroMsg.VoipCSReportHelper", "getVoipCSChannelReportData, result: %s", new Object[] { ((ceq)localObject4).tTD });
    ((LinkedList)localObject2).add(localObject4);
    ((cer)localObject1).tTE.add(c.bSQ().bSS());
    localObject2 = ((cer)localObject1).tTE;
    localObject3 = c.bSQ();
    localObject4 = new ceq();
    ((ceq)localObject4).hQR = 3;
    ((d)localObject3).pUS = com.tencent.mm.compatible.b.f.yi().yy();
    ((d)localObject3).AC(com.tencent.mm.plugin.voip_cs.b.a.a.bSW().pTJ.bSB());
    int i = ((d)localObject3).cpuFlag0 & 0xFF;
    ((d)localObject3).pWh = i;
    ((d)localObject3).pWh = i;
    ((d)localObject3).qdH = c.bSO().qeL.field_audioDuration;
    ((d)localObject3).qdI = c.bSO().qeL.field_videoDuration;
    if ((((d)localObject3).qdl != 1) && (((d)localObject3).qdT != 1))
    {
      ((d)localObject3).qdz = 1;
      ((d)localObject3).qds = com.tencent.mm.plugin.voip.a.a.getNetType(ae.getContext());
      com.tencent.mm.plugin.voip_cs.b.a locala = c.bSO().qeL;
      locala.setJNIAppCmd(1, locala.pVR, locala.pVR.length);
      i = (int)(v2protocal.aV(locala.pVR) / 1000L);
      if ((((d)localObject3).qdO == 0) || (i <= ((d)localObject3).qdO)) {
        break label1613;
      }
      i -= ((d)localObject3).qdO;
      label401:
      ((d)localObject3).qdG = i;
      ((ceq)localObject4).tTD = (((d)localObject3).pUM + "," + ((d)localObject3).qdp + "," + ((d)localObject3).lpE + "," + ((d)localObject3).qdq + "," + ((d)localObject3).qdr + "," + ((d)localObject3).pUy + "," + ((d)localObject3).qds + "," + ((d)localObject3).qdt + "," + ((d)localObject3).qdu + "," + ((d)localObject3).qdv + "," + ((d)localObject3).pUS + "," + ((d)localObject3).pUR + "," + ((d)localObject3).qdw + "," + ((d)localObject3).qdx + "," + ((d)localObject3).qdy + "," + ((d)localObject3).qdz + "," + ((d)localObject3).qdA + "," + ((d)localObject3).qdB + "," + ((d)localObject3).qdC + "," + ((d)localObject3).qdD + "," + ((d)localObject3).qdE + "," + ((d)localObject3).qdF + "," + ((d)localObject3).qdG + "," + ((d)localObject3).lqV + "," + ((d)localObject3).qdH + "," + ((d)localObject3).qdI + "," + ((d)localObject3).channelStrategy + "," + ((d)localObject3).pWh + "," + ((d)localObject3).pUT + "," + ((d)localObject3).qdJ + "," + ((d)localObject3).qdK + "," + ((d)localObject3).qdL + "," + ((d)localObject3).deviceModel + "," + ((d)localObject3).qdM + "," + ((d)localObject3).qdN);
      y.i("MicroMsg.VoipCSReportHelper", "getVoipCSClientReportData, result: %s", new Object[] { ((ceq)localObject4).tTD });
      ((LinkedList)localObject2).add(localObject4);
      localObject1 = ((cer)localObject1).tTE;
      localObject2 = c.bSQ();
      localObject3 = new ceq();
      ((ceq)localObject3).hQR = 4;
      ((d)localObject2).networkType = d.getNetType(ae.getContext());
      localObject4 = ((TelephonyManager)ae.getContext().getSystemService("phone")).getSimOperator();
      if (localObject4 == null) {
        break label1653;
      }
      if ((!((String)localObject4).equals("46000")) && (!((String)localObject4).equals("46002")) && (!((String)localObject4).equals("46007"))) {
        break label1619;
      }
      i = 1;
      label998:
      ((d)localObject2).qdm = i;
      ((d)localObject2).qdd = ((int)(System.currentTimeMillis() / 1000L));
      ((d)localObject2).qdn = d.bST();
      ((d)localObject2).pUS = com.tencent.mm.compatible.b.f.yi().yy();
      localObject4 = p.bQU();
      if (((p)localObject4).pTh == 0) {
        break label1659;
      }
      i = ((p)localObject4).pTg / ((p)localObject4).pTh;
      label1063:
      ((d)localObject2).qdo = i;
      if (((d)localObject2).qdo == -1)
      {
        localObject4 = new byte[4];
        if (c.bSO().qeL.setAppCmd(10, (byte[])localObject4, 4) >= 0) {
          break label1665;
        }
        ((d)localObject2).qdo = 0;
        y.d("MicroMsg.VoipCSReportHelper", "get netStatus failed");
      }
    }
    for (;;)
    {
      y.i("MicroMsg.VoipCSReportHelper", "getVoipCSThirdPartData Report dataType=%d, dataTime=%s, isClickClose=%d, clickCloseTime=%s, videoFps=%d, videoRate=%d, cameraPixelWidth=%d, cameraPixelHeight=%d, recordPixelWidth=%d, recordPixelHeight=%d, cameraState=%d, networkType=%s, mobileType=%s, mobileNetworkType=%s, networkQuality=%d", new Object[] { Integer.valueOf(((d)localObject2).aYU), Integer.valueOf(((d)localObject2).qdd), Integer.valueOf(((d)localObject2).qde), Integer.valueOf(((d)localObject2).qdf), Integer.valueOf(((d)localObject2).videoFps), Integer.valueOf(((d)localObject2).qdg), Integer.valueOf(((d)localObject2).qdh), Integer.valueOf(((d)localObject2).qdi), Integer.valueOf(((d)localObject2).qdj), Integer.valueOf(((d)localObject2).qdk), Integer.valueOf(((d)localObject2).qdl), Integer.valueOf(((d)localObject2).networkType), Integer.valueOf(((d)localObject2).qdm), Integer.valueOf(((d)localObject2).qdn), Integer.valueOf(((d)localObject2).qdo) });
      ((ceq)localObject3).tTD = (((d)localObject2).aYU + "," + ((d)localObject2).qdd + "," + ((d)localObject2).qde + "," + ((d)localObject2).qdf + "," + ((d)localObject2).videoFps + "," + ((d)localObject2).qdg + "," + ((d)localObject2).qdh + "," + ((d)localObject2).qdi + "," + ((d)localObject2).qdj + "," + ((d)localObject2).qdk + "," + ((d)localObject2).qdl + "," + ((d)localObject2).networkType + "," + ((d)localObject2).qdm + "," + ((d)localObject2).qdn + "," + ((d)localObject2).qdo + "," + ((d)localObject2).qdp + "," + ((d)localObject2).lpE);
      y.d("MicroMsg.VoipCSReportHelper", "getVoipCSThirdPartData, result: " + ((ceq)localObject3).tTD);
      ((LinkedList)localObject1).add(localObject3);
      return;
      if (((d)localObject3).qdl != 1)
      {
        ((d)localObject3).qdz = 2;
        break;
      }
      if (((d)localObject3).qdT != 1)
      {
        ((d)localObject3).qdz = 3;
        break;
      }
      ((d)localObject3).qdz = 0;
      break;
      label1613:
      i = 0;
      break label401;
      label1619:
      if (((String)localObject4).equals("46001"))
      {
        i = 3;
        break label998;
      }
      if (((String)localObject4).equals("46003"))
      {
        i = 2;
        break label998;
      }
      label1653:
      i = 0;
      break label998;
      label1659:
      i = -1;
      break label1063;
      label1665:
      ((d)localObject2).qdo = bk.aI((byte[])localObject4);
    }
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.ah.f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneVoipCSReport", "onGYNetEnd, errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 312;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.b.c.e
 * JD-Core Version:    0.7.0.1
 */