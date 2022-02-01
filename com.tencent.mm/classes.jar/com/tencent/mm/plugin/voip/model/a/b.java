package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.misc.a.a;
import com.tencent.mm.plugin.voip.c;
import com.tencent.mm.plugin.voip.c.e;
import com.tencent.mm.plugin.voip.model.VoipScoreState;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.protocal.protobuf.ahu;
import com.tencent.mm.protocal.protobuf.ahv;
import com.tencent.mm.protocal.protobuf.bys;
import com.tencent.mm.protocal.protobuf.dbt;
import com.tencent.mm.protocal.protobuf.dwc;
import com.tencent.mm.protocal.protobuf.dwd;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.fdd;
import com.tencent.mm.protocal.protobuf.fde;
import com.tencent.mm.protocal.protobuf.fep;
import com.tencent.mm.protocal.protobuf.fev;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.LinkedList;

public final class b
  extends n<fdd, fde>
{
  private String TAG;
  
  public b(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong, boolean paramBoolean1, boolean paramBoolean2, LinkedList<dbt> paramLinkedList)
  {
    AppMethodBeat.i(115219);
    this.TAG = "MicroMsg.NetSceneVoipAnswer";
    Object localObject1 = new d.a();
    ((d.a)localObject1).lBU = new fdd();
    ((d.a)localObject1).lBV = new fde();
    ((d.a)localObject1).uri = "/cgi-bin/micromsg-bin/voipanswer";
    ((d.a)localObject1).funcId = 172;
    ((d.a)localObject1).lBW = 65;
    ((d.a)localObject1).respCmdId = 1000000065;
    this.rr = ((d.a)localObject1).bgN();
    localObject1 = (fdd)d.b.b(this.rr.lBR);
    ((fdd)localObject1).UCW = paramInt1;
    ((fdd)localObject1).Svu = paramInt3;
    ((fdd)localObject1).SmH = paramInt2;
    Object localObject2 = new fev();
    ((fev)localObject2).rWu = 2;
    eae localeae = new eae();
    localeae.dc(paramArrayOfByte1);
    ((fev)localObject2).RNM = localeae;
    ((fdd)localObject1).UCF = ((fev)localObject2);
    paramArrayOfByte1 = new fev();
    paramArrayOfByte1.rWu = 3;
    localObject2 = new eae();
    ((eae)localObject2).dc(paramArrayOfByte2);
    paramArrayOfByte1.RNM = ((eae)localObject2);
    ((fdd)localObject1).UCG = paramArrayOfByte1;
    ((fdd)localObject1).Svv = paramLong;
    if (paramBoolean2)
    {
      if (paramBoolean1)
      {
        paramInt1 = 1;
        ((fdd)localObject1).UCX = paramInt1;
      }
    }
    else
    {
      ((fdd)localObject1).UCJ = System.currentTimeMillis();
      paramInt1 = ((a)h.ae(a.class)).WE(2);
      Log.i(this.TAG, "simType: %s", new Object[] { Integer.valueOf(paramInt1) });
      if (paramInt1 != 0) {
        break label324;
      }
      paramInt1 = 0;
    }
    for (;;)
    {
      ((fdd)localObject1).UCK = paramInt1;
      if (paramLinkedList != null)
      {
        ((fdd)localObject1).UCL = paramLinkedList.size();
        ((fdd)localObject1).UCM = paramLinkedList;
      }
      AppMethodBeat.o(115219);
      return;
      paramInt1 = 0;
      break;
      label324:
      if (paramInt1 == 3) {
        paramInt1 = 3;
      } else if (paramInt1 == 1) {
        paramInt1 = 1;
      } else {
        paramInt1 = 2;
      }
    }
  }
  
  public final i gAU()
  {
    AppMethodBeat.i(115220);
    i local1 = new i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, final String paramAnonymousString, q paramAnonymousq)
      {
        AppMethodBeat.i(115218);
        e.Logi(b.a(b.this), "Anwser response:" + paramAnonymousInt1 + " errCode:" + paramAnonymousInt2 + " status:" + b.this.NMN.mStatus);
        if (b.this.NMN.mStatus == 1)
        {
          e.Logi(b.a(b.this), "reject ok!");
          AppMethodBeat.o(115218);
          return;
        }
        if (b.this.NMN.mStatus != 4)
        {
          e.Loge(b.a(b.this), "Anwser response not within WAITCONNECT, ignored.");
          AppMethodBeat.o(115218);
          return;
        }
        if (paramAnonymousInt1 != 0)
        {
          if (paramAnonymousInt1 == 4)
          {
            b.this.NMN.NMi.NSI.NNq = 12;
            b.this.NMN.NMi.NSI.NNr = paramAnonymousInt2;
            b.this.NMN.J(1, paramAnonymousInt2, "");
            AppMethodBeat.o(115218);
            return;
          }
          b.this.NMN.NMi.NSI.NNq = 12;
          b.this.NMN.NMi.NSI.NNr = paramAnonymousInt2;
          b.this.NMN.J(1, -9004, "");
          AppMethodBeat.o(115218);
          return;
        }
        paramAnonymousString = (fde)b.this.gAY();
        b.this.NMN.NMi.roomId = paramAnonymousString.Svu;
        b.this.NMN.NMi.DPJ = paramAnonymousString.Svv;
        b.this.NMN.NMi.DPQ = paramAnonymousString.UCN;
        b.this.NMN.NMi.NRx = paramAnonymousString.UDa;
        b.this.NMN.NMi.NRy = paramAnonymousString.UDb;
        b.this.NMN.NMi.NRz = paramAnonymousString.UDc;
        b.this.NMN.NMi.NRA = paramAnonymousString.UDd;
        b.this.NMN.NMi.NRC = paramAnonymousString.UDf;
        b.this.NMN.NMi.NRB = paramAnonymousString.UDk;
        b.this.NMN.NMi.NQR = paramAnonymousString.UCR;
        b.this.NMN.NMi.NRE = paramAnonymousString.UDm;
        b.this.NMN.akW(paramAnonymousString.UCP);
        b.this.NMN.NMi.NQV = paramAnonymousString.UCS;
        if ((paramAnonymousString.UCT != null) && (paramAnonymousString.UCT.Tkb != null)) {
          b.this.NMN.NMi.NQT = paramAnonymousString.UCT.Tkb.toByteArray();
        }
        if (paramAnonymousString.UCT.Ufv >= 12)
        {
          paramAnonymousq = ByteBuffer.wrap(paramAnonymousString.UCT.Tkb.toByteArray(), 8, 4);
          ByteOrder localByteOrder1 = ByteOrder.nativeOrder();
          ByteOrder localByteOrder2 = paramAnonymousq.order();
          paramAnonymousInt1 = paramAnonymousq.getInt();
          e.Logd(b.a(b.this), "steve:nSvrBaseBRTuneRatio1:" + paramAnonymousInt1 + ", nativeOrder:" + localByteOrder1 + ", bbOrder:" + localByteOrder2);
          b.this.NMN.NMi.NRD = paramAnonymousInt1;
        }
        e.Logi(b.a(b.this), "onAnwserResp: audioTsdfBeyond3G = " + b.this.NMN.NMi.NRx + ",audioTsdEdge = " + b.this.NMN.NMi.NRy + ",passthroughQosAlgorithm = " + b.this.NMN.NMi.NRz + ",fastPlayRepair = " + b.this.NMN.NMi.NRA + ", audioDtx = " + b.this.NMN.NMi.NRC + ", switchtcppktCnt=" + b.this.NMN.NMi.NQQ + ", SvrCfgListV=" + b.this.NMN.NMi.NRB + ", setMaxBRForRelay=" + b.this.NMN.NMi.NRE + ", RedirectreqThreshold=" + paramAnonymousString.UCO.UEW + ", BothSideSwitchFlag=" + paramAnonymousString.UCO.UEX + ", WifiScanInterval=" + paramAnonymousString.UCS + ", BaseBRTuneRatio=" + b.this.NMN.NMi.NRD);
        b.this.NMN.NMi.NRF = paramAnonymousString.UDj;
        b.this.NMN.NMi.NRG = paramAnonymousString.UDn;
        e.Logi(b.a(b.this), "answerResp AudioAecMode5 = " + b.this.NMN.NMi.NRF);
        b.this.NMN.gyS();
        b.this.NMN.gyT();
        b.this.NMN.NLI = true;
        e.Logi(b.a(b.this), "answer ok, roomid =" + b.this.NMN.NMi.roomId + ",memberid = " + b.this.NMN.NMi.DPQ);
        paramAnonymousString = paramAnonymousString.UCO;
        if (paramAnonymousString.DQe > 0)
        {
          paramAnonymousString.DQe -= 1;
          e.Logi(b.a(b.this), "zhengxue[ENCRYPT] got encryptStrategy[" + paramAnonymousString.DQe + "] from answerresp relaydata");
        }
        for (;;)
        {
          e.Logi(b.a(b.this), "answer with relayData peerid.length =" + paramAnonymousString.UCF.RNM.Ufv);
          e.Logi(b.a(b.this), "answer with relayData capinfo.length =" + paramAnonymousString.UCG.RNM.Ufv);
          b.this.NMN.akV(paramAnonymousString.UEB);
          b.this.NMN.NMw.d(paramAnonymousString.UFb, paramAnonymousString.UFa, b.this.NMN.NMi.roomId, b.this.NMN.NMi.DPJ);
          try
          {
            h.aHJ().postToWorker(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(115217);
                c.gxs().gAC();
                e.Logi(b.a(b.this), "steve:doublelink timer started!");
                Object localObject;
                if ((paramAnonymousString.UEu == null) || (paramAnonymousString.UEu.Ucd == 0))
                {
                  localObject = new dwc();
                  ((dwc)localObject).Ssu = 0;
                  ((dwc)localObject).Ssv = "";
                  ((dwc)localObject).Ssw = "";
                  ((dwc)localObject).Ssx = b.this.NMN.NMi.netType;
                  ((dwc)localObject).Ssy = 4;
                  ((dwc)localObject).Ssz = 2;
                  ((dwc)localObject).Ucb = paramAnonymousString.UEC;
                  ((dwc)localObject).Ucc = paramAnonymousString.UEK;
                  paramAnonymousString.UEu = new dwd();
                  paramAnonymousString.UEu.Ucd = 1;
                  paramAnonymousString.UEu.Uce = new LinkedList();
                  paramAnonymousString.UEu.Uce.add(localObject);
                }
                if ((paramAnonymousString.UEv == null) || (paramAnonymousString.UEv.SsF == 0))
                {
                  localObject = new ahu();
                  ((ahu)localObject).Ssu = 1;
                  ((ahu)localObject).Ssv = "";
                  ((ahu)localObject).Ssw = "";
                  ((ahu)localObject).Ssx = b.this.NMN.NMi.netType;
                  ((ahu)localObject).Ssy = 4;
                  ((ahu)localObject).Ssz = 2;
                  ((ahu)localObject).SsA = paramAnonymousString.UED;
                  ((ahu)localObject).SsB = paramAnonymousString.UFc;
                  ((ahu)localObject).SsC = paramAnonymousString.UFd;
                  paramAnonymousString.UEv = new ahv();
                  paramAnonymousString.UEv.SsF = 1;
                  paramAnonymousString.UEv.SsG = new LinkedList();
                  paramAnonymousString.UEv.SsG.add(localObject);
                }
                e.Logi(b.a(b.this), "relay conn cnt: " + paramAnonymousString.UEu.Ucd);
                try
                {
                  b.this.NMN.NMi.NSl = paramAnonymousString.UEu.toByteArray();
                }
                catch (Exception localException2)
                {
                  try
                  {
                    b.this.NMN.NMi.NSm = paramAnonymousString.UEv.toByteArray();
                  }
                  catch (Exception localException2)
                  {
                    try
                    {
                      for (;;)
                      {
                        if (paramAnonymousString.UFe.ThN > 0) {
                          b.this.NMN.NMi.NSn = paramAnonymousString.UFe.toByteArray();
                        }
                        if (paramAnonymousString.UCF.RNM.Tkb == null) {
                          break;
                        }
                        b.this.NMN.cy(paramAnonymousString.UCF.RNM.Tkb.toByteArray());
                        if ((paramAnonymousString.UEI != null) && (paramAnonymousString.UEI.Tkb != null) && (paramAnonymousString.UEU != null) && (paramAnonymousString.UEU.Tkb != null)) {
                          b.this.NMN.a(paramAnonymousString.UEI.Tkb.toByteArray(), paramAnonymousString.UEH, paramAnonymousString.DQe, paramAnonymousString.UEU.Tkb.toByteArray());
                        }
                        b.this.NMN.n(paramAnonymousString.UEL, paramAnonymousString.UEM, paramAnonymousString.UEN, paramAnonymousString.UEO, paramAnonymousString.UEP);
                        b.this.NMN.akU(paramAnonymousString.UET);
                        if ((paramAnonymousString.UER != null) && (paramAnonymousString.UES != null) && (paramAnonymousString.UER.Tkb != null) && (paramAnonymousString.UES.Tkb != null)) {
                          b.this.NMN.c(paramAnonymousString.UEQ, paramAnonymousString.UER.Tkb.toByteArray(), paramAnonymousString.UES.Tkb.toByteArray());
                        }
                        if (paramAnonymousString.UCG.RNM.Tkb == null) {
                          break label1109;
                        }
                        b.this.NMN.cz(paramAnonymousString.UCG.RNM.Tkb.toByteArray());
                        b.this.NMN.akT(paramAnonymousString.UEW);
                        b.this.NMN.NMi.NRY = paramAnonymousString.UEX;
                        if ((paramAnonymousString.UEZ != null) && (paramAnonymousString.UEZ.Tkb != null)) {
                          b.this.NMN.NMi.NQS = paramAnonymousString.UEZ.Tkb.toByteArray();
                        }
                        if (!b.this.NMN.NLK) {
                          break label1205;
                        }
                        b.this.NMN.NLK = false;
                        if (b.this.NMN.NLG != true) {
                          break label1128;
                        }
                        e.Logi(b.a(b.this), "channel pre-connect already success, start talk");
                        MMHandlerThread.postToMainThread(new Runnable()
                        {
                          public final void run()
                          {
                            AppMethodBeat.i(177027);
                            b.this.NMN.gyM();
                            AppMethodBeat.o(177027);
                          }
                        });
                        b.this.NMN.gyY();
                        b.this.NMN.gyW();
                        AppMethodBeat.o(115217);
                        return;
                        localException1 = localException1;
                        Log.e(b.a(b.this), "relay conn info to byte array fail..");
                        continue;
                        localException2 = localException2;
                        Log.e(b.a(b.this), "direct conn info to byte array fail..");
                      }
                    }
                    catch (Exception localException3)
                    {
                      for (;;)
                      {
                        Log.e(b.a(b.this), "nic query info to byte array fail..");
                        continue;
                        Log.e(b.a(b.this), "multiRelayData.PeerId.Buffer.getBuffer() is null");
                        continue;
                        label1109:
                        Log.e(b.a(b.this), "multiRelayData.CapInfo.Buffer.getBuffer() is null");
                        continue;
                        label1128:
                        if (b.this.NMN.NLJ == true)
                        {
                          e.Logi(b.a(b.this), "channel pre-connect already failed");
                          b.this.NMN.J(1, -9000, "");
                          AppMethodBeat.o(115217);
                          return;
                        }
                        e.Logi(b.a(b.this), "channel pre-connect still connecting...");
                        continue;
                        label1205:
                        Log.i(b.a(b.this), "isPreConnect is false");
                      }
                    }
                  }
                }
              }
            });
            AppMethodBeat.o(115218);
            return;
          }
          catch (Exception paramAnonymousString)
          {
            Log.e(b.a(b.this), "get proxy ip fail..");
            AppMethodBeat.o(115218);
          }
          paramAnonymousString.DQe = 1;
          e.Logi(b.a(b.this), "zhengxue[LOGIC]:got no EncryptStrategy in answerresp mrdata");
        }
      }
    };
    AppMethodBeat.o(115220);
    return local1;
  }
  
  public final int getType()
  {
    return 172;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.b
 * JD-Core Version:    0.7.0.1
 */