package com.tencent.mm.plugin.voip_cs.c.c;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.voip.model.r;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip_cs.c.c;
import com.tencent.mm.protocal.protobuf.etf;
import com.tencent.mm.protocal.protobuf.etg;
import com.tencent.mm.protocal.protobuf.eth;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class e
  extends q
  implements m
{
  private i callback;
  public com.tencent.mm.ak.d rr;
  
  public e(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(125434);
    Object localObject1 = new d.a();
    ((d.a)localObject1).iLN = new etg();
    ((d.a)localObject1).iLO = new eth();
    ((d.a)localObject1).uri = "/cgi-bin/micromsg-bin/csvoipreport";
    ((d.a)localObject1).funcId = 312;
    ((d.a)localObject1).iLP = 0;
    ((d.a)localObject1).respCmdId = 0;
    this.rr = ((d.a)localObject1).aXF();
    localObject1 = (etg)this.rr.iLK.iLR;
    ((etg)localObject1).NeG = paramLong1;
    ((etg)localObject1).Lta = paramLong2;
    Object localObject2 = ((etg)localObject1).NqH;
    Object localObject3 = c.fMt();
    Object localObject4 = new etf();
    ((etf)localObject4).oUv = 1;
    ((etf)localObject4).KWF = ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).yre;
    Log.i("MicroMsg.VoipCSReportHelper", "getVoipCSChannelReportData, result: %s", new Object[] { ((etf)localObject4).KWF });
    ((LinkedList)localObject2).add(localObject4);
    ((etg)localObject1).NqH.add(c.fMt().fMw());
    localObject2 = ((etg)localObject1).NqH;
    localObject3 = c.fMt();
    localObject4 = new etf();
    ((etf)localObject4).oUv = 3;
    ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).HaP = com.tencent.mm.plugin.audio.c.a.ced();
    ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).aei(com.tencent.mm.plugin.voip_cs.c.a.a.fMB().qtg.fKX());
    int i = ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).cpuFlag0 & 0xFF;
    ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).Hcv = i;
    ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).Hcv = i;
    ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).Hrr = c.fMr().Hsv.field_audioDuration;
    ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).Hrs = c.fMr().Hsv.field_videoDuration;
    if ((((com.tencent.mm.plugin.voip_cs.c.d)localObject3).HqX != 1) && (((com.tencent.mm.plugin.voip_cs.c.d)localObject3).HrD != 1))
    {
      ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).Hrj = 1;
      ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).Hrc = com.tencent.mm.plugin.voip.b.e.getNetType(MMApplicationContext.getContext());
      com.tencent.mm.plugin.voip_cs.c.a locala = c.fMr().Hsv;
      locala.setJNIAppCmd(1, locala.Hcf, locala.Hcf.length);
      i = (int)(v2protocal.cn(locala.Hcf) / 1000L);
      if ((((com.tencent.mm.plugin.voip_cs.c.d)localObject3).Hry == 0) || (i <= ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).Hry)) {
        break label1617;
      }
      i -= ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).Hry;
      label403:
      ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).Hrq = i;
      ((etf)localObject4).KWF = (((com.tencent.mm.plugin.voip_cs.c.d)localObject3).HaK + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).roomId + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).ypH + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).Hra + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).Hrb + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).Hau + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).Hrc + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).Hrd + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).Hre + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).Hrf + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).HaP + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).HaO + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).Hrg + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).Hrh + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).Hri + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).Hrj + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).Hrk + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).Hrl + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).Hrm + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).Hrn + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).Hro + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).Hrp + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).Hrq + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).yqU + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).Hrr + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).Hrs + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).channelStrategy + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).Hcv + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).HaQ + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).Hrt + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).Hru + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).Hrv + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).deviceModel + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).Hrw + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).Hrx);
      Log.i("MicroMsg.VoipCSReportHelper", "getVoipCSClientReportData, result: %s", new Object[] { ((etf)localObject4).KWF });
      ((LinkedList)localObject2).add(localObject4);
      localObject1 = ((etg)localObject1).NqH;
      localObject2 = c.fMt();
      localObject3 = new etf();
      ((etf)localObject3).oUv = 4;
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
      ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).HqY = i;
      ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).HqP = ((int)(System.currentTimeMillis() / 1000L));
      ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).HqZ = com.tencent.mm.plugin.voip_cs.c.d.fMx();
      ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).HaP = com.tencent.mm.plugin.audio.c.a.ced();
      localObject4 = r.fHo();
      if (((r)localObject4).GYI == 0) {
        break label1663;
      }
      i = ((r)localObject4).GYH / ((r)localObject4).GYI;
      label1062:
      ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).hzL = i;
      if (((com.tencent.mm.plugin.voip_cs.c.d)localObject2).hzL == -1)
      {
        localObject4 = new byte[4];
        if (c.fMr().Hsv.setAppCmd(10, (byte[])localObject4, 4) >= 0) {
          break label1669;
        }
        ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).hzL = 0;
        Log.d("MicroMsg.VoipCSReportHelper", "get netStatus failed");
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.VoipCSReportHelper", "getVoipCSThirdPartData Report dataType=%d, dataTime=%s, isClickClose=%d, clickCloseTime=%s, videoFps=%d, videoRate=%d, cameraPixelWidth=%d, cameraPixelHeight=%d, recordPixelWidth=%d, recordPixelHeight=%d, cameraState=%d, networkType=%s, mobileType=%s, mobileNetworkType=%s, networkQuality=%d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.voip_cs.c.d)localObject2).dataType), Integer.valueOf(((com.tencent.mm.plugin.voip_cs.c.d)localObject2).HqP), Integer.valueOf(((com.tencent.mm.plugin.voip_cs.c.d)localObject2).HqQ), Integer.valueOf(((com.tencent.mm.plugin.voip_cs.c.d)localObject2).HqR), Integer.valueOf(((com.tencent.mm.plugin.voip_cs.c.d)localObject2).videoFps), Integer.valueOf(((com.tencent.mm.plugin.voip_cs.c.d)localObject2).HqS), Integer.valueOf(((com.tencent.mm.plugin.voip_cs.c.d)localObject2).HqT), Integer.valueOf(((com.tencent.mm.plugin.voip_cs.c.d)localObject2).HqU), Integer.valueOf(((com.tencent.mm.plugin.voip_cs.c.d)localObject2).HqV), Integer.valueOf(((com.tencent.mm.plugin.voip_cs.c.d)localObject2).HqW), Integer.valueOf(((com.tencent.mm.plugin.voip_cs.c.d)localObject2).HqX), Integer.valueOf(((com.tencent.mm.plugin.voip_cs.c.d)localObject2).networkType), Integer.valueOf(((com.tencent.mm.plugin.voip_cs.c.d)localObject2).HqY), Integer.valueOf(((com.tencent.mm.plugin.voip_cs.c.d)localObject2).HqZ), Integer.valueOf(((com.tencent.mm.plugin.voip_cs.c.d)localObject2).hzL) });
      ((etf)localObject3).KWF = (((com.tencent.mm.plugin.voip_cs.c.d)localObject2).dataType + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).HqP + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).HqQ + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).HqR + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).videoFps + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).HqS + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).HqT + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).HqU + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).HqV + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).HqW + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).HqX + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).networkType + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).HqY + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).HqZ + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).hzL + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).roomId + "," + ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).ypH);
      Log.d("MicroMsg.VoipCSReportHelper", "getVoipCSThirdPartData, result: " + ((etf)localObject3).KWF);
      ((LinkedList)localObject1).add(localObject3);
      AppMethodBeat.o(125434);
      return;
      if (((com.tencent.mm.plugin.voip_cs.c.d)localObject3).HqX != 1)
      {
        ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).Hrj = 2;
        break;
      }
      if (((com.tencent.mm.plugin.voip_cs.c.d)localObject3).HrD != 1)
      {
        ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).Hrj = 3;
        break;
      }
      ((com.tencent.mm.plugin.voip_cs.c.d)localObject3).Hrj = 0;
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
      ((com.tencent.mm.plugin.voip_cs.c.d)localObject2).hzL = Util.byteArrayToInt((byte[])localObject4);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.c.c.e
 * JD-Core Version:    0.7.0.1
 */