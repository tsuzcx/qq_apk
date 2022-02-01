package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.plugin.misc.a.a;
import com.tencent.mm.plugin.voip.b.d;
import com.tencent.mm.plugin.voip.c;
import com.tencent.mm.plugin.voip.model.VoipScoreState;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.act;
import com.tencent.mm.protocal.protobuf.acu;
import com.tencent.mm.protocal.protobuf.bai;
import com.tencent.mm.protocal.protobuf.bxf;
import com.tencent.mm.protocal.protobuf.cny;
import com.tencent.mm.protocal.protobuf.cnz;
import com.tencent.mm.protocal.protobuf.dra;
import com.tencent.mm.protocal.protobuf.drb;
import com.tencent.mm.protocal.protobuf.dsm;
import com.tencent.mm.protocal.protobuf.dss;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.LinkedList;

public final class b
  extends n<dra, drb>
{
  String TAG;
  
  public b(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong, boolean paramBoolean1, boolean paramBoolean2, LinkedList<bxf> paramLinkedList)
  {
    AppMethodBeat.i(115219);
    this.TAG = "MicroMsg.NetSceneVoipAnswer";
    Object localObject1 = new b.a();
    ((b.a)localObject1).hvt = new dra();
    ((b.a)localObject1).hvu = new drb();
    ((b.a)localObject1).uri = "/cgi-bin/micromsg-bin/voipanswer";
    ((b.a)localObject1).funcId = 172;
    ((b.a)localObject1).reqCmdId = 65;
    ((b.a)localObject1).respCmdId = 1000000065;
    this.rr = ((b.a)localObject1).aAz();
    localObject1 = (dra)this.rr.hvr.hvw;
    ((dra)localObject1).FYy = paramInt1;
    ((dra)localObject1).Exf = paramInt3;
    ((dra)localObject1).EqS = paramInt2;
    Object localObject2 = new dss();
    ((dss)localObject2).ndI = 2;
    SKBuiltinBuffer_t localSKBuiltinBuffer_t = new SKBuiltinBuffer_t();
    localSKBuiltinBuffer_t.setBuffer(paramArrayOfByte1);
    ((dss)localObject2).DVs = localSKBuiltinBuffer_t;
    ((dra)localObject1).FYh = ((dss)localObject2);
    paramArrayOfByte1 = new dss();
    paramArrayOfByte1.ndI = 3;
    localObject2 = new SKBuiltinBuffer_t();
    ((SKBuiltinBuffer_t)localObject2).setBuffer(paramArrayOfByte2);
    paramArrayOfByte1.DVs = ((SKBuiltinBuffer_t)localObject2);
    ((dra)localObject1).FYi = paramArrayOfByte1;
    ((dra)localObject1).Exg = paramLong;
    if (paramBoolean2)
    {
      if (paramBoolean1)
      {
        paramInt1 = 1;
        ((dra)localObject1).FYz = paramInt1;
      }
    }
    else
    {
      ((dra)localObject1).FYl = System.currentTimeMillis();
      paramInt1 = ((a)com.tencent.mm.kernel.g.ab(a.class)).Is(2);
      ac.i(this.TAG, "simType: %s", new Object[] { Integer.valueOf(paramInt1) });
      if (paramInt1 != 0) {
        break label324;
      }
      paramInt1 = 0;
    }
    for (;;)
    {
      ((dra)localObject1).FYm = paramInt1;
      if (paramLinkedList != null)
      {
        ((dra)localObject1).FYn = paramLinkedList.size();
        ((dra)localObject1).FYo = paramLinkedList;
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
  
  public final com.tencent.mm.ak.g eks()
  {
    AppMethodBeat.i(115220);
    com.tencent.mm.ak.g local1 = new com.tencent.mm.ak.g()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, final String paramAnonymousString, com.tencent.mm.ak.n paramAnonymousn)
      {
        AppMethodBeat.i(115218);
        d.Logi(b.this.TAG, "Anwser response:" + paramAnonymousInt1 + " errCode:" + paramAnonymousInt2 + " status:" + b.this.ACr.mStatus);
        if (b.this.ACr.mStatus == 1)
        {
          d.Logi(b.this.TAG, "reject ok!");
          AppMethodBeat.o(115218);
          return;
        }
        if (b.this.ACr.mStatus != 4)
        {
          d.Loge(b.this.TAG, "Anwser response not within WAITCONNECT, ignored.");
          AppMethodBeat.o(115218);
          return;
        }
        if (paramAnonymousInt1 != 0)
        {
          if (paramAnonymousInt1 == 4)
          {
            b.this.ACr.ABJ.AIf.ACR = 12;
            b.this.ACr.ABJ.AIf.ACS = paramAnonymousInt2;
            b.this.ACr.H(1, paramAnonymousInt2, "");
            AppMethodBeat.o(115218);
            return;
          }
          b.this.ACr.ABJ.AIf.ACR = 12;
          b.this.ACr.ABJ.AIf.ACS = paramAnonymousInt2;
          b.this.ACr.H(1, -9004, "");
          AppMethodBeat.o(115218);
          return;
        }
        paramAnonymousString = (drb)b.this.ekw();
        b.this.ACr.ABJ.roomId = paramAnonymousString.Exf;
        b.this.ACr.ABJ.tIG = paramAnonymousString.Exg;
        b.this.ACr.ABJ.tIN = paramAnonymousString.FYp;
        b.this.ACr.ABJ.AGV = paramAnonymousString.FYC;
        b.this.ACr.ABJ.AGW = paramAnonymousString.FYD;
        b.this.ACr.ABJ.AGX = paramAnonymousString.FYE;
        b.this.ACr.ABJ.AGY = paramAnonymousString.FYF;
        b.this.ACr.ABJ.AHa = paramAnonymousString.FYH;
        b.this.ACr.ABJ.AGZ = paramAnonymousString.FYM;
        b.this.ACr.ABJ.AGp = paramAnonymousString.FYt;
        b.this.ACr.ABJ.AHc = paramAnonymousString.FYO;
        b.this.ACr.Ss(paramAnonymousString.FYr);
        b.this.ACr.ABJ.AGt = paramAnonymousString.FYu;
        if ((paramAnonymousString.FYv != null) && (paramAnonymousString.FYv.getBuffer() != null)) {
          b.this.ACr.ABJ.AGr = paramAnonymousString.FYv.getBuffer().toByteArray();
        }
        if (paramAnonymousString.FYv.getILen() >= 12)
        {
          paramAnonymousn = ByteBuffer.wrap(paramAnonymousString.FYv.getBuffer().toByteArray(), 8, 4);
          ByteOrder localByteOrder1 = ByteOrder.nativeOrder();
          ByteOrder localByteOrder2 = paramAnonymousn.order();
          paramAnonymousInt1 = paramAnonymousn.getInt();
          d.Logd(b.this.TAG, "steve:nSvrBaseBRTuneRatio1:" + paramAnonymousInt1 + ", nativeOrder:" + localByteOrder1 + ", bbOrder:" + localByteOrder2);
          b.this.ACr.ABJ.AHb = paramAnonymousInt1;
        }
        d.Logi(b.this.TAG, "onAnwserResp: audioTsdfBeyond3G = " + b.this.ACr.ABJ.AGV + ",audioTsdEdge = " + b.this.ACr.ABJ.AGW + ",passthroughQosAlgorithm = " + b.this.ACr.ABJ.AGX + ",fastPlayRepair = " + b.this.ACr.ABJ.AGY + ", audioDtx = " + b.this.ACr.ABJ.AHa + ", switchtcppktCnt=" + b.this.ACr.ABJ.AGo + ", SvrCfgListV=" + b.this.ACr.ABJ.AGZ + ", setMaxBRForRelay=" + b.this.ACr.ABJ.AHc + ", RedirectreqThreshold=" + paramAnonymousString.FYq.Gax + ", BothSideSwitchFlag=" + paramAnonymousString.FYq.Gay + ", WifiScanInterval=" + paramAnonymousString.FYu + ", BaseBRTuneRatio=" + b.this.ACr.ABJ.AHb);
        b.this.ACr.ABJ.AHd = paramAnonymousString.FYL;
        b.this.ACr.ABJ.AHe = paramAnonymousString.FYP;
        d.Logi(b.this.TAG, "answerResp AudioAecMode5 = " + b.this.ACr.ABJ.AHd);
        b.this.ACr.eix();
        b.this.ACr.ABj = true;
        d.Logi(b.this.TAG, "answer ok, roomid =" + b.this.ACr.ABJ.roomId + ",memberid = " + b.this.ACr.ABJ.tIN);
        paramAnonymousString = paramAnonymousString.FYq;
        if (paramAnonymousString.tJb > 0)
        {
          paramAnonymousString.tJb -= 1;
          d.Logi(b.this.TAG, "zhengxue[ENCRYPT] got encryptStrategy[" + paramAnonymousString.tJb + "] from answerresp relaydata");
        }
        for (;;)
        {
          d.Logi(b.this.TAG, "answer with relayData peerid.length =" + paramAnonymousString.FYh.DVs.getILen());
          d.Logi(b.this.TAG, "answer with relayData capinfo.length =" + paramAnonymousString.FYi.DVs.getILen());
          b.this.ACr.Sr(paramAnonymousString.Gac);
          b.this.ACr.ABX.a(paramAnonymousString.GaC, paramAnonymousString.GaB, b.this.ACr.ABJ.roomId, b.this.ACr.ABJ.tIG);
          try
          {
            com.tencent.mm.kernel.g.agU().az(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(115217);
                c.ehb().ejW();
                d.Logi(b.this.TAG, "steve:doublelink timer started!");
                Object localObject;
                if ((paramAnonymousString.FZV == null) || (paramAnonymousString.FZV.FBe == 0))
                {
                  localObject = new cny();
                  ((cny)localObject).Evo = 0;
                  ((cny)localObject).Evp = "";
                  ((cny)localObject).Evq = "";
                  ((cny)localObject).Evr = b.this.ACr.ABJ.netType;
                  ((cny)localObject).Evs = 4;
                  ((cny)localObject).Evt = 2;
                  ((cny)localObject).FBc = paramAnonymousString.Gad;
                  ((cny)localObject).FBd = paramAnonymousString.Gal;
                  paramAnonymousString.FZV = new cnz();
                  paramAnonymousString.FZV.FBe = 1;
                  paramAnonymousString.FZV.FBf = new LinkedList();
                  paramAnonymousString.FZV.FBf.add(localObject);
                }
                if ((paramAnonymousString.FZW == null) || (paramAnonymousString.FZW.Evz == 0))
                {
                  localObject = new act();
                  ((act)localObject).Evo = 1;
                  ((act)localObject).Evp = "";
                  ((act)localObject).Evq = "";
                  ((act)localObject).Evr = b.this.ACr.ABJ.netType;
                  ((act)localObject).Evs = 4;
                  ((act)localObject).Evt = 2;
                  ((act)localObject).Evu = paramAnonymousString.Gae;
                  ((act)localObject).Evv = paramAnonymousString.GaD;
                  ((act)localObject).Evw = paramAnonymousString.GaE;
                  paramAnonymousString.FZW = new acu();
                  paramAnonymousString.FZW.Evz = 1;
                  paramAnonymousString.FZW.EvA = new LinkedList();
                  paramAnonymousString.FZW.EvA.add(localObject);
                }
                d.Logi(b.this.TAG, "relay conn cnt: " + paramAnonymousString.FZV.FBe);
                try
                {
                  b.this.ACr.ABJ.AHI = paramAnonymousString.FZV.toByteArray();
                }
                catch (Exception localException2)
                {
                  try
                  {
                    b.this.ACr.ABJ.AHJ = paramAnonymousString.FZW.toByteArray();
                  }
                  catch (Exception localException2)
                  {
                    try
                    {
                      for (;;)
                      {
                        if (paramAnonymousString.GaF.ERm > 0) {
                          b.this.ACr.ABJ.AHK = paramAnonymousString.GaF.toByteArray();
                        }
                        if (paramAnonymousString.FYh.DVs.getBuffer() == null) {
                          break;
                        }
                        b.this.ACr.bI(paramAnonymousString.FYh.DVs.getBuffer().toByteArray());
                        if ((paramAnonymousString.Gaj != null) && (paramAnonymousString.Gaj.getBuffer() != null) && (paramAnonymousString.Gav != null) && (paramAnonymousString.Gav.getBuffer() != null)) {
                          b.this.ACr.a(paramAnonymousString.Gaj.getBuffer().toByteArray(), paramAnonymousString.Gai, paramAnonymousString.tJb, paramAnonymousString.Gav.getBuffer().toByteArray());
                        }
                        b.this.ACr.i(paramAnonymousString.Gam, paramAnonymousString.Gan, paramAnonymousString.Gao, paramAnonymousString.Gap, paramAnonymousString.Gaq);
                        b.this.ACr.Sq(paramAnonymousString.Gau);
                        if ((paramAnonymousString.Gas != null) && (paramAnonymousString.Gat != null) && (paramAnonymousString.Gas.getBuffer() != null) && (paramAnonymousString.Gat.getBuffer() != null)) {
                          b.this.ACr.c(paramAnonymousString.Gar, paramAnonymousString.Gas.getBuffer().toByteArray(), paramAnonymousString.Gat.getBuffer().toByteArray());
                        }
                        if (paramAnonymousString.FYi.DVs.getBuffer() == null) {
                          break label1109;
                        }
                        b.this.ACr.bJ(paramAnonymousString.FYi.DVs.getBuffer().toByteArray());
                        b.this.ACr.Sp(paramAnonymousString.Gax);
                        b.this.ACr.ABJ.AHw = paramAnonymousString.Gay;
                        if ((paramAnonymousString.GaA != null) && (paramAnonymousString.GaA.getBuffer() != null)) {
                          b.this.ACr.ABJ.AGq = paramAnonymousString.GaA.getBuffer().toByteArray();
                        }
                        if (!b.this.ACr.ABl) {
                          break label1205;
                        }
                        b.this.ACr.ABl = false;
                        if (b.this.ACr.ABh != true) {
                          break label1128;
                        }
                        d.Logi(b.this.TAG, "channel pre-connect already success, start talk");
                        ap.f(new Runnable()
                        {
                          public final void run()
                          {
                            AppMethodBeat.i(177027);
                            b.this.ACr.eis();
                            AppMethodBeat.o(177027);
                          }
                        });
                        b.this.ACr.eiC();
                        b.this.ACr.eiA();
                        AppMethodBeat.o(115217);
                        return;
                        localException1 = localException1;
                        ac.e(b.this.TAG, "relay conn info to byte array fail..");
                        continue;
                        localException2 = localException2;
                        ac.e(b.this.TAG, "direct conn info to byte array fail..");
                      }
                    }
                    catch (Exception localException3)
                    {
                      for (;;)
                      {
                        ac.e(b.this.TAG, "nic query info to byte array fail..");
                        continue;
                        ac.e(b.this.TAG, "multiRelayData.PeerId.Buffer.getBuffer() is null");
                        continue;
                        label1109:
                        ac.e(b.this.TAG, "multiRelayData.CapInfo.Buffer.getBuffer() is null");
                        continue;
                        label1128:
                        if (b.this.ACr.ABk == true)
                        {
                          d.Logi(b.this.TAG, "channel pre-connect already failed");
                          b.this.ACr.H(1, -9000, "");
                          AppMethodBeat.o(115217);
                          return;
                        }
                        d.Logi(b.this.TAG, "channel pre-connect still connecting...");
                        continue;
                        label1205:
                        ac.i(b.this.TAG, "isPreConnect is false");
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
            ac.e(b.this.TAG, "get proxy ip fail..");
            AppMethodBeat.o(115218);
          }
          paramAnonymousString.tJb = 1;
          d.Logi(b.this.TAG, "zhengxue[LOGIC]:got no EncryptStrategy in answerresp mrdata");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.b
 * JD-Core Version:    0.7.0.1
 */