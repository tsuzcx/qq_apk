package com.tencent.mm.plugin.voip_cs.model.c;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.voip.model.r;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip_cs.model.d;
import com.tencent.mm.protocal.protobuf.gac;
import com.tencent.mm.protocal.protobuf.gad;
import com.tencent.mm.protocal.protobuf.gae;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class e
  extends p
  implements m
{
  private h callback;
  public com.tencent.mm.am.c rr;
  
  public e(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(125434);
    Object localObject1 = new c.a();
    ((c.a)localObject1).otE = new gad();
    ((c.a)localObject1).otF = new gae();
    ((c.a)localObject1).uri = "/cgi-bin/micromsg-bin/csvoipreport";
    ((c.a)localObject1).funcId = 312;
    ((c.a)localObject1).otG = 0;
    ((c.a)localObject1).respCmdId = 0;
    this.rr = ((c.a)localObject1).bEF();
    localObject1 = (gad)c.b.b(this.rr.otB);
    ((gad)localObject1).abKe = paramLong1;
    ((gad)localObject1).ZvA = paramLong2;
    Object localObject2 = ((gad)localObject1).abXO;
    Object localObject3 = com.tencent.mm.plugin.voip_cs.model.c.idY();
    Object localObject4 = new gac();
    ((gac)localObject4).vhJ = 1;
    ((gac)localObject4).YVP = ((d)localObject3).JIq;
    Log.i("MicroMsg.VoipCSReportHelper", "getVoipCSChannelReportData, result: %s", new Object[] { ((gac)localObject4).YVP });
    ((LinkedList)localObject2).add(localObject4);
    ((gad)localObject1).abXO.add(com.tencent.mm.plugin.voip_cs.model.c.idY().ieb());
    localObject2 = ((gad)localObject1).abXO;
    localObject3 = com.tencent.mm.plugin.voip_cs.model.c.idY();
    localObject4 = new gac();
    ((gac)localObject4).vhJ = 3;
    ((d)localObject3).UDN = com.tencent.mm.plugin.audio.c.a.cTZ();
    ((d)localObject3).arD(com.tencent.mm.plugin.voip_cs.model.a.a.ief().wVi.ict());
    int i = ((d)localObject3).cpuFlag0 & 0xFF;
    ((d)localObject3).UFM = i;
    ((d)localObject3).UFM = i;
    ((d)localObject3).UXx = com.tencent.mm.plugin.voip_cs.model.c.idW().UYC.field_audioDuration;
    ((d)localObject3).UXy = com.tencent.mm.plugin.voip_cs.model.c.idW().UYC.field_videoDuration;
    if ((((d)localObject3).UXd != 1) && (((d)localObject3).UXJ != 1))
    {
      ((d)localObject3).UXp = 1;
      MMApplicationContext.getContext();
      ((d)localObject3).UXi = com.tencent.mm.plugin.voip.f.g.ibq();
      com.tencent.mm.plugin.voip_cs.model.a locala = com.tencent.mm.plugin.voip_cs.model.c.idW().UYC;
      locala.setJNIAppCmd(1, locala.UFw, locala.UFw.length);
      i = (int)(v2protocal.cH(locala.UFw) / 1000L);
      if ((((d)localObject3).UXE == 0) || (i <= ((d)localObject3).UXE)) {
        break label1619;
      }
      i -= ((d)localObject3).UXE;
      label404:
      ((d)localObject3).UXw = i;
      ((gac)localObject4).YVP = (((d)localObject3).UDI + "," + ((d)localObject3).roomId + "," + ((d)localObject3).Hnt + "," + ((d)localObject3).UXg + "," + ((d)localObject3).UXh + "," + ((d)localObject3).UDs + "," + ((d)localObject3).UXi + "," + ((d)localObject3).UXj + "," + ((d)localObject3).UXk + "," + ((d)localObject3).UXl + "," + ((d)localObject3).UDN + "," + ((d)localObject3).UDM + "," + ((d)localObject3).UXm + "," + ((d)localObject3).UXn + "," + ((d)localObject3).UXo + "," + ((d)localObject3).UXp + "," + ((d)localObject3).UXq + "," + ((d)localObject3).UXr + "," + ((d)localObject3).UXs + "," + ((d)localObject3).UXt + "," + ((d)localObject3).UXu + "," + ((d)localObject3).UXv + "," + ((d)localObject3).UXw + "," + ((d)localObject3).JIg + "," + ((d)localObject3).UXx + "," + ((d)localObject3).UXy + "," + ((d)localObject3).channelStrategy + "," + ((d)localObject3).UFM + "," + ((d)localObject3).UDO + "," + ((d)localObject3).UXz + "," + ((d)localObject3).UXA + "," + ((d)localObject3).UXB + "," + ((d)localObject3).deviceModel + "," + ((d)localObject3).UXC + "," + ((d)localObject3).UXD);
      Log.i("MicroMsg.VoipCSReportHelper", "getVoipCSClientReportData, result: %s", new Object[] { ((gac)localObject4).YVP });
      ((LinkedList)localObject2).add(localObject4);
      localObject1 = ((gad)localObject1).abXO;
      localObject2 = com.tencent.mm.plugin.voip_cs.model.c.idY();
      localObject3 = new gac();
      ((gac)localObject3).vhJ = 4;
      MMApplicationContext.getContext();
      ((d)localObject2).networkType = com.tencent.mm.plugin.voip.f.g.ibq();
      localObject4 = ((TelephonyManager)MMApplicationContext.getContext().getSystemService("phone")).getSimOperator();
      if (localObject4 == null) {
        break label1659;
      }
      if ((!((String)localObject4).equals("46000")) && (!((String)localObject4).equals("46002")) && (!((String)localObject4).equals("46007"))) {
        break label1625;
      }
      i = 1;
      label1002:
      ((d)localObject2).UXe = i;
      ((d)localObject2).UWV = ((int)(System.currentTimeMillis() / 1000L));
      ((d)localObject2).UXf = d.iec();
      ((d)localObject2).UDN = com.tencent.mm.plugin.audio.c.a.cTZ();
      localObject4 = r.hXJ();
      if (((r)localObject4).UBv == 0) {
        break label1665;
      }
      i = ((r)localObject4).UBu / ((r)localObject4).UBv;
      label1064:
      ((d)localObject2).mNT = i;
      if (((d)localObject2).mNT == -1)
      {
        localObject4 = new byte[4];
        if (com.tencent.mm.plugin.voip_cs.model.c.idW().UYC.setAppCmd(10, (byte[])localObject4, 4) >= 0) {
          break label1671;
        }
        ((d)localObject2).mNT = 0;
        Log.d("MicroMsg.VoipCSReportHelper", "get netStatus failed");
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.VoipCSReportHelper", "getVoipCSThirdPartData Report dataType=%d, dataTime=%s, isClickClose=%d, clickCloseTime=%s, videoFps=%d, videoRate=%d, cameraPixelWidth=%d, cameraPixelHeight=%d, recordPixelWidth=%d, recordPixelHeight=%d, cameraState=%d, networkType=%s, mobileType=%s, mobileNetworkType=%s, networkQuality=%d", new Object[] { Integer.valueOf(((d)localObject2).dataType), Integer.valueOf(((d)localObject2).UWV), Integer.valueOf(((d)localObject2).UWW), Integer.valueOf(((d)localObject2).UWX), Integer.valueOf(((d)localObject2).videoFps), Integer.valueOf(((d)localObject2).UWY), Integer.valueOf(((d)localObject2).UWZ), Integer.valueOf(((d)localObject2).UXa), Integer.valueOf(((d)localObject2).UXb), Integer.valueOf(((d)localObject2).UXc), Integer.valueOf(((d)localObject2).UXd), Integer.valueOf(((d)localObject2).networkType), Integer.valueOf(((d)localObject2).UXe), Integer.valueOf(((d)localObject2).UXf), Integer.valueOf(((d)localObject2).mNT) });
      ((gac)localObject3).YVP = (((d)localObject2).dataType + "," + ((d)localObject2).UWV + "," + ((d)localObject2).UWW + "," + ((d)localObject2).UWX + "," + ((d)localObject2).videoFps + "," + ((d)localObject2).UWY + "," + ((d)localObject2).UWZ + "," + ((d)localObject2).UXa + "," + ((d)localObject2).UXb + "," + ((d)localObject2).UXc + "," + ((d)localObject2).UXd + "," + ((d)localObject2).networkType + "," + ((d)localObject2).UXe + "," + ((d)localObject2).UXf + "," + ((d)localObject2).mNT + "," + ((d)localObject2).roomId + "," + ((d)localObject2).Hnt);
      Log.d("MicroMsg.VoipCSReportHelper", "getVoipCSThirdPartData, result: " + ((gac)localObject3).YVP);
      ((LinkedList)localObject1).add(localObject3);
      AppMethodBeat.o(125434);
      return;
      if (((d)localObject3).UXd != 1)
      {
        ((d)localObject3).UXp = 2;
        break;
      }
      if (((d)localObject3).UXJ != 1)
      {
        ((d)localObject3).UXp = 3;
        break;
      }
      ((d)localObject3).UXp = 0;
      break;
      label1619:
      i = 0;
      break label404;
      label1625:
      if (((String)localObject4).equals("46001"))
      {
        i = 3;
        break label1002;
      }
      if (((String)localObject4).equals("46003"))
      {
        i = 2;
        break label1002;
      }
      label1659:
      i = 0;
      break label1002;
      label1665:
      i = -1;
      break label1064;
      label1671:
      ((d)localObject2).mNT = Util.byteArrayToInt((byte[])localObject4);
    }
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, h paramh)
  {
    AppMethodBeat.i(125436);
    this.callback = paramh;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.model.c.e
 * JD-Core Version:    0.7.0.1
 */