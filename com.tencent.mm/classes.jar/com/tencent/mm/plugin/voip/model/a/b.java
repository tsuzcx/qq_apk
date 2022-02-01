package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.plugin.misc.a.a;
import com.tencent.mm.plugin.voip.model.VoipScoreState;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.abu;
import com.tencent.mm.protocal.protobuf.abv;
import com.tencent.mm.protocal.protobuf.awq;
import com.tencent.mm.protocal.protobuf.bso;
import com.tencent.mm.protocal.protobuf.cir;
import com.tencent.mm.protocal.protobuf.cis;
import com.tencent.mm.protocal.protobuf.dlj;
import com.tencent.mm.protocal.protobuf.dlk;
import com.tencent.mm.protocal.protobuf.dmv;
import com.tencent.mm.protocal.protobuf.dnb;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.LinkedList;

public final class b
  extends n<dlj, dlk>
{
  String TAG;
  
  public b(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong, boolean paramBoolean1, boolean paramBoolean2, LinkedList<bso> paramLinkedList)
  {
    AppMethodBeat.i(115219);
    this.TAG = "MicroMsg.NetSceneVoipAnswer";
    Object localObject1 = new b.a();
    ((b.a)localObject1).gUU = new dlj();
    ((b.a)localObject1).gUV = new dlk();
    ((b.a)localObject1).uri = "/cgi-bin/micromsg-bin/voipanswer";
    ((b.a)localObject1).funcId = 172;
    ((b.a)localObject1).reqCmdId = 65;
    ((b.a)localObject1).respCmdId = 1000000065;
    this.rr = ((b.a)localObject1).atI();
    localObject1 = (dlj)this.rr.gUS.gUX;
    ((dlj)localObject1).EBl = paramInt1;
    ((dlj)localObject1).DdZ = paramInt3;
    ((dlj)localObject1).CYi = paramInt2;
    Object localObject2 = new dnb();
    ((dnb)localObject2).mBH = 2;
    SKBuiltinBuffer_t localSKBuiltinBuffer_t = new SKBuiltinBuffer_t();
    localSKBuiltinBuffer_t.setBuffer(paramArrayOfByte1);
    ((dnb)localObject2).CCV = localSKBuiltinBuffer_t;
    ((dlj)localObject1).EAU = ((dnb)localObject2);
    paramArrayOfByte1 = new dnb();
    paramArrayOfByte1.mBH = 3;
    localObject2 = new SKBuiltinBuffer_t();
    ((SKBuiltinBuffer_t)localObject2).setBuffer(paramArrayOfByte2);
    paramArrayOfByte1.CCV = ((SKBuiltinBuffer_t)localObject2);
    ((dlj)localObject1).EAV = paramArrayOfByte1;
    ((dlj)localObject1).Dea = paramLong;
    if (paramBoolean2)
    {
      if (paramBoolean1)
      {
        paramInt1 = 1;
        ((dlj)localObject1).EBm = paramInt1;
      }
    }
    else
    {
      ((dlj)localObject1).EAY = System.currentTimeMillis();
      paramInt1 = ((a)com.tencent.mm.kernel.g.ab(a.class)).Gw(2);
      ad.i(this.TAG, "simType: %s", new Object[] { Integer.valueOf(paramInt1) });
      if (paramInt1 != 0) {
        break label324;
      }
      paramInt1 = 0;
    }
    for (;;)
    {
      ((dlj)localObject1).EAZ = paramInt1;
      if (paramLinkedList != null)
      {
        ((dlj)localObject1).EBa = paramLinkedList.size();
        ((dlj)localObject1).EBb = paramLinkedList;
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
  
  public final com.tencent.mm.al.g dVg()
  {
    AppMethodBeat.i(115220);
    com.tencent.mm.al.g local1 = new com.tencent.mm.al.g()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, final String paramAnonymousString, com.tencent.mm.al.n paramAnonymousn)
      {
        AppMethodBeat.i(115218);
        com.tencent.mm.plugin.voip.b.c.Logi(b.this.TAG, "Anwser response:" + paramAnonymousInt1 + " errCode:" + paramAnonymousInt2 + " status:" + b.this.zjH.mStatus);
        if (b.this.zjH.mStatus == 1)
        {
          com.tencent.mm.plugin.voip.b.c.Logi(b.this.TAG, "reject ok!");
          AppMethodBeat.o(115218);
          return;
        }
        if (b.this.zjH.mStatus != 4)
        {
          com.tencent.mm.plugin.voip.b.c.Loge(b.this.TAG, "Anwser response not within WAITCONNECT, ignored.");
          AppMethodBeat.o(115218);
          return;
        }
        if (paramAnonymousInt1 != 0)
        {
          if (paramAnonymousInt1 == 4)
          {
            b.this.zjH.ziZ.zpq.zkh = 12;
            b.this.zjH.ziZ.zpq.zki = paramAnonymousInt2;
            b.this.zjH.I(1, paramAnonymousInt2, "");
            AppMethodBeat.o(115218);
            return;
          }
          b.this.zjH.ziZ.zpq.zkh = 12;
          b.this.zjH.ziZ.zpq.zki = paramAnonymousInt2;
          b.this.zjH.I(1, -9004, "");
          AppMethodBeat.o(115218);
          return;
        }
        paramAnonymousString = (dlk)b.this.dVk();
        b.this.zjH.ziZ.roomId = paramAnonymousString.DdZ;
        b.this.zjH.ziZ.sAY = paramAnonymousString.Dea;
        b.this.zjH.ziZ.sBf = paramAnonymousString.EBc;
        b.this.zjH.ziZ.zog = paramAnonymousString.EBp;
        b.this.zjH.ziZ.zoh = paramAnonymousString.EBq;
        b.this.zjH.ziZ.zoi = paramAnonymousString.EBr;
        b.this.zjH.ziZ.zoj = paramAnonymousString.EBs;
        b.this.zjH.ziZ.zol = paramAnonymousString.EBu;
        b.this.zjH.ziZ.zok = paramAnonymousString.EBz;
        b.this.zjH.ziZ.znB = paramAnonymousString.EBg;
        b.this.zjH.ziZ.zon = paramAnonymousString.EBB;
        b.this.zjH.Qj(paramAnonymousString.EBe);
        b.this.zjH.ziZ.znF = paramAnonymousString.EBh;
        if ((paramAnonymousString.EBi != null) && (paramAnonymousString.EBi.getBuffer() != null)) {
          b.this.zjH.ziZ.znD = paramAnonymousString.EBi.getBuffer().toByteArray();
        }
        if (paramAnonymousString.EBi.getILen() >= 12)
        {
          paramAnonymousn = ByteBuffer.wrap(paramAnonymousString.EBi.getBuffer().toByteArray(), 8, 4);
          ByteOrder localByteOrder1 = ByteOrder.nativeOrder();
          ByteOrder localByteOrder2 = paramAnonymousn.order();
          paramAnonymousInt1 = paramAnonymousn.getInt();
          com.tencent.mm.plugin.voip.b.c.Logd(b.this.TAG, "steve:nSvrBaseBRTuneRatio1:" + paramAnonymousInt1 + ", nativeOrder:" + localByteOrder1 + ", bbOrder:" + localByteOrder2);
          b.this.zjH.ziZ.zom = paramAnonymousInt1;
        }
        com.tencent.mm.plugin.voip.b.c.Logi(b.this.TAG, "onAnwserResp: audioTsdfBeyond3G = " + b.this.zjH.ziZ.zog + ",audioTsdEdge = " + b.this.zjH.ziZ.zoh + ",passthroughQosAlgorithm = " + b.this.zjH.ziZ.zoi + ",fastPlayRepair = " + b.this.zjH.ziZ.zoj + ", audioDtx = " + b.this.zjH.ziZ.zol + ", switchtcppktCnt=" + b.this.zjH.ziZ.znA + ", SvrCfgListV=" + b.this.zjH.ziZ.zok + ", setMaxBRForRelay=" + b.this.zjH.ziZ.zon + ", RedirectreqThreshold=" + paramAnonymousString.EBd.EDk + ", BothSideSwitchFlag=" + paramAnonymousString.EBd.EDl + ", WifiScanInterval=" + paramAnonymousString.EBh + ", BaseBRTuneRatio=" + b.this.zjH.ziZ.zom);
        b.this.zjH.ziZ.zoo = paramAnonymousString.EBy;
        b.this.zjH.ziZ.zop = paramAnonymousString.EBC;
        com.tencent.mm.plugin.voip.b.c.Logi(b.this.TAG, "answerResp AudioAecMode5 = " + b.this.zjH.ziZ.zoo);
        b.this.zjH.dTl();
        b.this.zjH.ziz = true;
        com.tencent.mm.plugin.voip.b.c.Logi(b.this.TAG, "answer ok, roomid =" + b.this.zjH.ziZ.roomId + ",memberid = " + b.this.zjH.ziZ.sBf);
        paramAnonymousString = paramAnonymousString.EBd;
        if (paramAnonymousString.sBt > 0)
        {
          paramAnonymousString.sBt -= 1;
          com.tencent.mm.plugin.voip.b.c.Logi(b.this.TAG, "zhengxue[ENCRYPT] got encryptStrategy[" + paramAnonymousString.sBt + "] from answerresp relaydata");
        }
        for (;;)
        {
          com.tencent.mm.plugin.voip.b.c.Logi(b.this.TAG, "answer with relayData peerid.length =" + paramAnonymousString.EAU.CCV.getILen());
          com.tencent.mm.plugin.voip.b.c.Logi(b.this.TAG, "answer with relayData capinfo.length =" + paramAnonymousString.EAV.CCV.getILen());
          b.this.zjH.Qi(paramAnonymousString.ECP);
          b.this.zjH.zjn.b(paramAnonymousString.EDp, paramAnonymousString.EDo, b.this.zjH.ziZ.roomId, b.this.zjH.ziZ.sAY);
          try
          {
            com.tencent.mm.kernel.g.afE().ax(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(115217);
                com.tencent.mm.plugin.voip.c.dRQ().dUK();
                com.tencent.mm.plugin.voip.b.c.Logi(b.this.TAG, "steve:doublelink timer started!");
                Object localObject;
                if ((paramAnonymousString.ECI == null) || (paramAnonymousString.ECI.Eee == 0))
                {
                  localObject = new cir();
                  ((cir)localObject).Dch = 0;
                  ((cir)localObject).Dci = "";
                  ((cir)localObject).Dcj = "";
                  ((cir)localObject).Dck = b.this.zjH.ziZ.netType;
                  ((cir)localObject).Dcl = 4;
                  ((cir)localObject).Dcm = 2;
                  ((cir)localObject).Eec = paramAnonymousString.ECQ;
                  ((cir)localObject).Eed = paramAnonymousString.ECY;
                  paramAnonymousString.ECI = new cis();
                  paramAnonymousString.ECI.Eee = 1;
                  paramAnonymousString.ECI.Eef = new LinkedList();
                  paramAnonymousString.ECI.Eef.add(localObject);
                }
                if ((paramAnonymousString.ECJ == null) || (paramAnonymousString.ECJ.Dcs == 0))
                {
                  localObject = new abu();
                  ((abu)localObject).Dch = 1;
                  ((abu)localObject).Dci = "";
                  ((abu)localObject).Dcj = "";
                  ((abu)localObject).Dck = b.this.zjH.ziZ.netType;
                  ((abu)localObject).Dcl = 4;
                  ((abu)localObject).Dcm = 2;
                  ((abu)localObject).Dcn = paramAnonymousString.ECR;
                  ((abu)localObject).Dco = paramAnonymousString.EDq;
                  ((abu)localObject).Dcp = paramAnonymousString.EDr;
                  paramAnonymousString.ECJ = new abv();
                  paramAnonymousString.ECJ.Dcs = 1;
                  paramAnonymousString.ECJ.Dct = new LinkedList();
                  paramAnonymousString.ECJ.Dct.add(localObject);
                }
                com.tencent.mm.plugin.voip.b.c.Logi(b.this.TAG, "relay conn cnt: " + paramAnonymousString.ECI.Eee);
                try
                {
                  b.this.zjH.ziZ.zoT = paramAnonymousString.ECI.toByteArray();
                }
                catch (Exception localException2)
                {
                  try
                  {
                    b.this.zjH.ziZ.zoU = paramAnonymousString.ECJ.toByteArray();
                  }
                  catch (Exception localException2)
                  {
                    try
                    {
                      for (;;)
                      {
                        if (paramAnonymousString.EDs.DvR > 0) {
                          b.this.zjH.ziZ.zoV = paramAnonymousString.EDs.toByteArray();
                        }
                        if (paramAnonymousString.EAU.CCV.getBuffer() == null) {
                          break;
                        }
                        b.this.zjH.bJ(paramAnonymousString.EAU.CCV.getBuffer().toByteArray());
                        if ((paramAnonymousString.ECW != null) && (paramAnonymousString.ECW.getBuffer() != null) && (paramAnonymousString.EDi != null) && (paramAnonymousString.EDi.getBuffer() != null)) {
                          b.this.zjH.a(paramAnonymousString.ECW.getBuffer().toByteArray(), paramAnonymousString.ECV, paramAnonymousString.sBt, paramAnonymousString.EDi.getBuffer().toByteArray());
                        }
                        b.this.zjH.i(paramAnonymousString.ECZ, paramAnonymousString.EDa, paramAnonymousString.EDb, paramAnonymousString.EDc, paramAnonymousString.EDd);
                        b.this.zjH.Qh(paramAnonymousString.EDh);
                        if ((paramAnonymousString.EDf != null) && (paramAnonymousString.EDg != null) && (paramAnonymousString.EDf.getBuffer() != null) && (paramAnonymousString.EDg.getBuffer() != null)) {
                          b.this.zjH.c(paramAnonymousString.EDe, paramAnonymousString.EDf.getBuffer().toByteArray(), paramAnonymousString.EDg.getBuffer().toByteArray());
                        }
                        if (paramAnonymousString.EAV.CCV.getBuffer() == null) {
                          break label1109;
                        }
                        b.this.zjH.bK(paramAnonymousString.EAV.CCV.getBuffer().toByteArray());
                        b.this.zjH.Qg(paramAnonymousString.EDk);
                        b.this.zjH.ziZ.zoH = paramAnonymousString.EDl;
                        if ((paramAnonymousString.EDn != null) && (paramAnonymousString.EDn.getBuffer() != null)) {
                          b.this.zjH.ziZ.znC = paramAnonymousString.EDn.getBuffer().toByteArray();
                        }
                        if (!b.this.zjH.ziB) {
                          break label1205;
                        }
                        b.this.zjH.ziB = false;
                        if (b.this.zjH.zix != true) {
                          break label1128;
                        }
                        com.tencent.mm.plugin.voip.b.c.Logi(b.this.TAG, "channel pre-connect already success, start talk");
                        aq.f(new Runnable()
                        {
                          public final void run()
                          {
                            AppMethodBeat.i(177027);
                            b.this.zjH.dTg();
                            AppMethodBeat.o(177027);
                          }
                        });
                        b.this.zjH.dTq();
                        b.this.zjH.dTo();
                        AppMethodBeat.o(115217);
                        return;
                        localException1 = localException1;
                        ad.e(b.this.TAG, "relay conn info to byte array fail..");
                        continue;
                        localException2 = localException2;
                        ad.e(b.this.TAG, "direct conn info to byte array fail..");
                      }
                    }
                    catch (Exception localException3)
                    {
                      for (;;)
                      {
                        ad.e(b.this.TAG, "nic query info to byte array fail..");
                        continue;
                        ad.e(b.this.TAG, "multiRelayData.PeerId.Buffer.getBuffer() is null");
                        continue;
                        label1109:
                        ad.e(b.this.TAG, "multiRelayData.CapInfo.Buffer.getBuffer() is null");
                        continue;
                        label1128:
                        if (b.this.zjH.ziA == true)
                        {
                          com.tencent.mm.plugin.voip.b.c.Logi(b.this.TAG, "channel pre-connect already failed");
                          b.this.zjH.I(1, -9000, "");
                          AppMethodBeat.o(115217);
                          return;
                        }
                        com.tencent.mm.plugin.voip.b.c.Logi(b.this.TAG, "channel pre-connect still connecting...");
                        continue;
                        label1205:
                        ad.i(b.this.TAG, "isPreConnect is false");
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
            ad.e(b.this.TAG, "get proxy ip fail..");
            AppMethodBeat.o(115218);
          }
          paramAnonymousString.sBt = 1;
          com.tencent.mm.plugin.voip.b.c.Logi(b.this.TAG, "zhengxue[LOGIC]:got no EncryptStrategy in answerresp mrdata");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.b
 * JD-Core Version:    0.7.0.1
 */