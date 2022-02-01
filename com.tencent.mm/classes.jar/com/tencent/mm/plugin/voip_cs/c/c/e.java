package com.tencent.mm.plugin.voip_cs.c.c;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.voip.model.r;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.video.i;
import com.tencent.mm.plugin.voip_cs.c.c;
import com.tencent.mm.protocal.protobuf.drn;
import com.tencent.mm.protocal.protobuf.dro;
import com.tencent.mm.protocal.protobuf.drp;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
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
    ((b.a)localObject1).hvt = new dro();
    ((b.a)localObject1).hvu = new drp();
    ((b.a)localObject1).uri = "/cgi-bin/micromsg-bin/csvoipreport";
    ((b.a)localObject1).funcId = 312;
    ((b.a)localObject1).reqCmdId = 0;
    ((b.a)localObject1).respCmdId = 0;
    this.rr = ((b.a)localObject1).aAz();
    localObject1 = (dro)this.rr.hvr.hvw;
    ((dro)localObject1).FOh = paramLong1;
    ((dro)localObject1).Exg = paramLong2;
    Object localObject2 = ((dro)localObject1).FZf;
    Object localObject3 = c.enE();
    Object localObject4 = new drn();
    ((drn)localObject4).ndI = 1;
    ((drn)localObject4).EVM = ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).tKe;
    ac.i("MicroMsg.VoipCSReportHelper", "getVoipCSChannelReportData, result: %s", new Object[] { ((drn)localObject4).EVM });
    ((LinkedList)localObject2).add(localObject4);
    ((dro)localObject1).FZf.add(c.enE().enH());
    localObject2 = ((dro)localObject1).FZf;
    localObject3 = c.enE();
    localObject4 = new drn();
    ((drn)localObject4).ndI = 3;
    ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).AGA = com.tencent.mm.plugin.audio.c.a.bCz();
    ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).Tj(com.tencent.mm.plugin.voip_cs.c.a.a.enM().oue.emJ());
    int i = ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).cpuFlag0 & 0xFF;
    ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).AIe = i;
    ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).AIe = i;
    ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).AUO = c.enC().AVR.field_audioDuration;
    ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).AUP = c.enC().AVR.field_videoDuration;
    if ((((com.tencent.mm.plugin.voip_cs.c.d)localObject3).AUu != 1) && (((com.tencent.mm.plugin.voip_cs.c.d)localObject3).AVa != 1))
    {
      ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).AUG = 1;
      ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).AUz = com.tencent.mm.plugin.voip.b.d.getNetType(ai.getContext());
      com.tencent.mm.plugin.voip_cs.c.a locala = c.enC().AVR;
      locala.setJNIAppCmd(1, locala.AHO, locala.AHO.length);
      i = (int)(v2protocal.bN(locala.AHO) / 1000L);
      if ((((com.tencent.mm.plugin.voip_cs.c.d)localObject3).AUV == 0) || (i <= ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).AUV)) {
        break label1617;
      }
      i -= ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).AUV;
      label403:
      ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).AUN = i;
      ((drn)localObject4).EVM = (((com.tencent.mm.plugin.voip_cs.c.d)localObject3).AGu + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).roomId + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).tIG + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).AUx + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).AUy + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).AGe + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).AUz + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).AUA + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).AUB + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).AUC + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).AGA + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).AGz + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).AUD + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).AUE + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).AUF + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).AUG + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).AUH + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).AUI + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).AUJ + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).AUK + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).AUL + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).AUM + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).AUN + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).tJU + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).AUO + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).AUP + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).channelStrategy + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).AIe + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).AGB + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).AUQ + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).AUR + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).AUS + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).deviceModel + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).AUT + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).AUU);
      ac.i("MicroMsg.VoipCSReportHelper", "getVoipCSClientReportData, result: %s", new Object[] { ((drn)localObject4).EVM });
      ((LinkedList)localObject2).add(localObject4);
      localObject1 = ((dro)localObject1).FZf;
      localObject2 = c.enE();
      localObject3 = new drn();
      ((drn)localObject3).ndI = 4;
      ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).networkType = com.tencent.mm.plugin.voip_cs.c.d.getNetType(ai.getContext());
      localObject4 = ((TelephonyManager)ai.getContext().getSystemService("phone")).getSimOperator();
      if (localObject4 == null) {
        break label1657;
      }
      if ((!((String)localObject4).equals("46000")) && (!((String)localObject4).equals("46002")) && (!((String)localObject4).equals("46007"))) {
        break label1623;
      }
      i = 1;
      label1000:
      ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).AUv = i;
      ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).AUm = ((int)(System.currentTimeMillis() / 1000L));
      ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).AUw = com.tencent.mm.plugin.voip_cs.c.d.enI();
      ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).AGA = com.tencent.mm.plugin.audio.c.a.bCz();
      localObject4 = r.ejf();
      if (((r)localObject4).AEv == 0) {
        break label1663;
      }
      i = ((r)localObject4).AEu / ((r)localObject4).AEv;
      label1062:
      ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).goi = i;
      if (((com.tencent.mm.plugin.voip_cs.c.d)localObject2).goi == -1)
      {
        localObject4 = new byte[4];
        if (c.enC().AVR.setAppCmd(10, (byte[])localObject4, 4) >= 0) {
          break label1669;
        }
        ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).goi = 0;
        ac.d("MicroMsg.VoipCSReportHelper", "get netStatus failed");
      }
    }
    for (;;)
    {
      ac.i("MicroMsg.VoipCSReportHelper", "getVoipCSThirdPartData Report dataType=%d, dataTime=%s, isClickClose=%d, clickCloseTime=%s, videoFps=%d, videoRate=%d, cameraPixelWidth=%d, cameraPixelHeight=%d, recordPixelWidth=%d, recordPixelHeight=%d, cameraState=%d, networkType=%s, mobileType=%s, mobileNetworkType=%s, networkQuality=%d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.voip_cs.c.d)localObject2).dataType), Integer.valueOf(((com.tencent.mm.plugin.voip_cs.c.d)localObject2).AUm), Integer.valueOf(((com.tencent.mm.plugin.voip_cs.c.d)localObject2).AUn), Integer.valueOf(((com.tencent.mm.plugin.voip_cs.c.d)localObject2).AUo), Integer.valueOf(((com.tencent.mm.plugin.voip_cs.c.d)localObject2).videoFps), Integer.valueOf(((com.tencent.mm.plugin.voip_cs.c.d)localObject2).AUp), Integer.valueOf(((com.tencent.mm.plugin.voip_cs.c.d)localObject2).AUq), Integer.valueOf(((com.tencent.mm.plugin.voip_cs.c.d)localObject2).AUr), Integer.valueOf(((com.tencent.mm.plugin.voip_cs.c.d)localObject2).AUs), Integer.valueOf(((com.tencent.mm.plugin.voip_cs.c.d)localObject2).AUt), Integer.valueOf(((com.tencent.mm.plugin.voip_cs.c.d)localObject2).AUu), Integer.valueOf(((com.tencent.mm.plugin.voip_cs.c.d)localObject2).networkType), Integer.valueOf(((com.tencent.mm.plugin.voip_cs.c.d)localObject2).AUv), Integer.valueOf(((com.tencent.mm.plugin.voip_cs.c.d)localObject2).AUw), Integer.valueOf(((com.tencent.mm.plugin.voip_cs.c.d)localObject2).goi) });
      ((drn)localObject3).EVM = (((com.tencent.mm.plugin.voip_cs.c.d)localObject2).dataType + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).AUm + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).AUn + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).AUo + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).videoFps + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).AUp + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).AUq + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).AUr + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).AUs + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).AUt + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).AUu + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).networkType + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).AUv + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).AUw + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).goi + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).roomId + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).tIG);
      ac.d("MicroMsg.VoipCSReportHelper", "getVoipCSThirdPartData, result: " + ((drn)localObject3).EVM);
      ((LinkedList)localObject1).add(localObject3);
      AppMethodBeat.o(125434);
      return;
      if (((com.tencent.mm.plugin.voip_cs.c.d)localObject3).AUu != 1)
      {
        ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).AUG = 2;
        break;
      }
      if (((com.tencent.mm.plugin.voip_cs.c.d)localObject3).AVa != 1)
      {
        ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).AUG = 3;
        break;
      }
      ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).AUG = 0;
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
      ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).goi = bs.bv((byte[])localObject4);
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
    ac.i("MicroMsg.NetSceneVoipCSReport", "onGYNetEnd, errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(125435);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.c.c.e
 * JD-Core Version:    0.7.0.1
 */