package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.misc.a.a;
import com.tencent.mm.plugin.voip.c;
import com.tencent.mm.plugin.voip.model.VoipScoreState;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.aeu;
import com.tencent.mm.protocal.protobuf.aev;
import com.tencent.mm.protocal.protobuf.bem;
import com.tencent.mm.protocal.protobuf.cbv;
import com.tencent.mm.protocal.protobuf.ctb;
import com.tencent.mm.protocal.protobuf.ctc;
import com.tencent.mm.protocal.protobuf.dwu;
import com.tencent.mm.protocal.protobuf.dwv;
import com.tencent.mm.protocal.protobuf.dyg;
import com.tencent.mm.protocal.protobuf.dym;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.LinkedList;

public final class b
  extends n<dwu, dwv>
{
  String TAG;
  
  public b(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong, boolean paramBoolean1, boolean paramBoolean2, LinkedList<cbv> paramLinkedList)
  {
    AppMethodBeat.i(115219);
    this.TAG = "MicroMsg.NetSceneVoipAnswer";
    Object localObject1 = new b.a();
    ((b.a)localObject1).hNM = new dwu();
    ((b.a)localObject1).hNN = new dwv();
    ((b.a)localObject1).uri = "/cgi-bin/micromsg-bin/voipanswer";
    ((b.a)localObject1).funcId = 172;
    ((b.a)localObject1).hNO = 65;
    ((b.a)localObject1).respCmdId = 1000000065;
    this.rr = ((b.a)localObject1).aDC();
    localObject1 = (dwu)this.rr.hNK.hNQ;
    ((dwu)localObject1).HJu = paramInt1;
    ((dwu)localObject1).GeI = paramInt3;
    ((dwu)localObject1).FYc = paramInt2;
    Object localObject2 = new dym();
    ((dym)localObject2).nEf = 2;
    SKBuiltinBuffer_t localSKBuiltinBuffer_t = new SKBuiltinBuffer_t();
    localSKBuiltinBuffer_t.setBuffer(paramArrayOfByte1);
    ((dym)localObject2).FAN = localSKBuiltinBuffer_t;
    ((dwu)localObject1).HJd = ((dym)localObject2);
    paramArrayOfByte1 = new dym();
    paramArrayOfByte1.nEf = 3;
    localObject2 = new SKBuiltinBuffer_t();
    ((SKBuiltinBuffer_t)localObject2).setBuffer(paramArrayOfByte2);
    paramArrayOfByte1.FAN = ((SKBuiltinBuffer_t)localObject2);
    ((dwu)localObject1).HJe = paramArrayOfByte1;
    ((dwu)localObject1).GeJ = paramLong;
    if (paramBoolean2)
    {
      if (paramBoolean1)
      {
        paramInt1 = 1;
        ((dwu)localObject1).HJv = paramInt1;
      }
    }
    else
    {
      ((dwu)localObject1).HJh = System.currentTimeMillis();
      paramInt1 = ((a)g.ab(a.class)).JP(2);
      ad.i(this.TAG, "simType: %s", new Object[] { Integer.valueOf(paramInt1) });
      if (paramInt1 != 0) {
        break label324;
      }
      paramInt1 = 0;
    }
    for (;;)
    {
      ((dwu)localObject1).HJi = paramInt1;
      if (paramLinkedList != null)
      {
        ((dwu)localObject1).HJj = paramLinkedList.size();
        ((dwu)localObject1).HJk = paramLinkedList;
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
  
  public final com.tencent.mm.al.f eyd()
  {
    AppMethodBeat.i(115220);
    com.tencent.mm.al.f local1 = new com.tencent.mm.al.f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, final String paramAnonymousString, com.tencent.mm.al.n paramAnonymousn)
      {
        AppMethodBeat.i(115218);
        com.tencent.mm.plugin.voip.b.f.Logi(b.this.TAG, "Anwser response:" + paramAnonymousInt1 + " errCode:" + paramAnonymousInt2 + " status:" + b.this.Cbq.mStatus);
        if (b.this.Cbq.mStatus == 1)
        {
          com.tencent.mm.plugin.voip.b.f.Logi(b.this.TAG, "reject ok!");
          AppMethodBeat.o(115218);
          return;
        }
        if (b.this.Cbq.mStatus != 4)
        {
          com.tencent.mm.plugin.voip.b.f.Loge(b.this.TAG, "Anwser response not within WAITCONNECT, ignored.");
          AppMethodBeat.o(115218);
          return;
        }
        if (paramAnonymousInt1 != 0)
        {
          if (paramAnonymousInt1 == 4)
          {
            b.this.Cbq.CaI.Chg.CbS = 12;
            b.this.Cbq.CaI.Chg.CbT = paramAnonymousInt2;
            b.this.Cbq.J(1, paramAnonymousInt2, "");
            AppMethodBeat.o(115218);
            return;
          }
          b.this.Cbq.CaI.Chg.CbS = 12;
          b.this.Cbq.CaI.Chg.CbT = paramAnonymousInt2;
          b.this.Cbq.J(1, -9004, "");
          AppMethodBeat.o(115218);
          return;
        }
        paramAnonymousString = (dwv)b.this.eyh();
        b.this.Cbq.CaI.roomId = paramAnonymousString.GeI;
        b.this.Cbq.CaI.uLt = paramAnonymousString.GeJ;
        b.this.Cbq.CaI.uLA = paramAnonymousString.HJl;
        b.this.Cbq.CaI.CfW = paramAnonymousString.HJy;
        b.this.Cbq.CaI.CfX = paramAnonymousString.HJz;
        b.this.Cbq.CaI.CfY = paramAnonymousString.HJA;
        b.this.Cbq.CaI.CfZ = paramAnonymousString.HJB;
        b.this.Cbq.CaI.Cgb = paramAnonymousString.HJD;
        b.this.Cbq.CaI.Cga = paramAnonymousString.HJI;
        b.this.Cbq.CaI.Cfp = paramAnonymousString.HJp;
        b.this.Cbq.CaI.Cgd = paramAnonymousString.HJK;
        b.this.Cbq.Uk(paramAnonymousString.HJn);
        b.this.Cbq.CaI.Cft = paramAnonymousString.HJq;
        if ((paramAnonymousString.HJr != null) && (paramAnonymousString.HJr.getBuffer() != null)) {
          b.this.Cbq.CaI.Cfr = paramAnonymousString.HJr.getBuffer().toByteArray();
        }
        if (paramAnonymousString.HJr.getILen() >= 12)
        {
          paramAnonymousn = ByteBuffer.wrap(paramAnonymousString.HJr.getBuffer().toByteArray(), 8, 4);
          ByteOrder localByteOrder1 = ByteOrder.nativeOrder();
          ByteOrder localByteOrder2 = paramAnonymousn.order();
          paramAnonymousInt1 = paramAnonymousn.getInt();
          com.tencent.mm.plugin.voip.b.f.Logd(b.this.TAG, "steve:nSvrBaseBRTuneRatio1:" + paramAnonymousInt1 + ", nativeOrder:" + localByteOrder1 + ", bbOrder:" + localByteOrder2);
          b.this.Cbq.CaI.Cgc = paramAnonymousInt1;
        }
        com.tencent.mm.plugin.voip.b.f.Logi(b.this.TAG, "onAnwserResp: audioTsdfBeyond3G = " + b.this.Cbq.CaI.CfW + ",audioTsdEdge = " + b.this.Cbq.CaI.CfX + ",passthroughQosAlgorithm = " + b.this.Cbq.CaI.CfY + ",fastPlayRepair = " + b.this.Cbq.CaI.CfZ + ", audioDtx = " + b.this.Cbq.CaI.Cgb + ", switchtcppktCnt=" + b.this.Cbq.CaI.Cfo + ", SvrCfgListV=" + b.this.Cbq.CaI.Cga + ", setMaxBRForRelay=" + b.this.Cbq.CaI.Cgd + ", RedirectreqThreshold=" + paramAnonymousString.HJm.HLt + ", BothSideSwitchFlag=" + paramAnonymousString.HJm.HLu + ", WifiScanInterval=" + paramAnonymousString.HJq + ", BaseBRTuneRatio=" + b.this.Cbq.CaI.Cgc);
        b.this.Cbq.CaI.Cge = paramAnonymousString.HJH;
        b.this.Cbq.CaI.Cgf = paramAnonymousString.HJL;
        com.tencent.mm.plugin.voip.b.f.Logi(b.this.TAG, "answerResp AudioAecMode5 = " + b.this.Cbq.CaI.Cge);
        b.this.Cbq.ewi();
        b.this.Cbq.Cai = true;
        com.tencent.mm.plugin.voip.b.f.Logi(b.this.TAG, "answer ok, roomid =" + b.this.Cbq.CaI.roomId + ",memberid = " + b.this.Cbq.CaI.uLA);
        paramAnonymousString = paramAnonymousString.HJm;
        if (paramAnonymousString.uLO > 0)
        {
          paramAnonymousString.uLO -= 1;
          com.tencent.mm.plugin.voip.b.f.Logi(b.this.TAG, "zhengxue[ENCRYPT] got encryptStrategy[" + paramAnonymousString.uLO + "] from answerresp relaydata");
        }
        for (;;)
        {
          com.tencent.mm.plugin.voip.b.f.Logi(b.this.TAG, "answer with relayData peerid.length =" + paramAnonymousString.HJd.FAN.getILen());
          com.tencent.mm.plugin.voip.b.f.Logi(b.this.TAG, "answer with relayData capinfo.length =" + paramAnonymousString.HJe.FAN.getILen());
          b.this.Cbq.Uj(paramAnonymousString.HKY);
          b.this.Cbq.CaW.c(paramAnonymousString.HLy, paramAnonymousString.HLx, b.this.Cbq.CaI.roomId, b.this.Cbq.CaI.uLt);
          try
          {
            g.ajF().ay(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(115217);
                c.euM().exH();
                com.tencent.mm.plugin.voip.b.f.Logi(b.this.TAG, "steve:doublelink timer started!");
                Object localObject;
                if ((paramAnonymousString.HKR == null) || (paramAnonymousString.HKR.Hlr == 0))
                {
                  localObject = new ctb();
                  ((ctb)localObject).GcK = 0;
                  ((ctb)localObject).GcL = "";
                  ((ctb)localObject).GcM = "";
                  ((ctb)localObject).GcN = b.this.Cbq.CaI.netType;
                  ((ctb)localObject).GcO = 4;
                  ((ctb)localObject).GcP = 2;
                  ((ctb)localObject).Hlp = paramAnonymousString.HKZ;
                  ((ctb)localObject).Hlq = paramAnonymousString.HLh;
                  paramAnonymousString.HKR = new ctc();
                  paramAnonymousString.HKR.Hlr = 1;
                  paramAnonymousString.HKR.Hls = new LinkedList();
                  paramAnonymousString.HKR.Hls.add(localObject);
                }
                if ((paramAnonymousString.HKS == null) || (paramAnonymousString.HKS.GcV == 0))
                {
                  localObject = new aeu();
                  ((aeu)localObject).GcK = 1;
                  ((aeu)localObject).GcL = "";
                  ((aeu)localObject).GcM = "";
                  ((aeu)localObject).GcN = b.this.Cbq.CaI.netType;
                  ((aeu)localObject).GcO = 4;
                  ((aeu)localObject).GcP = 2;
                  ((aeu)localObject).GcQ = paramAnonymousString.HLa;
                  ((aeu)localObject).GcR = paramAnonymousString.HLz;
                  ((aeu)localObject).GcS = paramAnonymousString.HLA;
                  paramAnonymousString.HKS = new aev();
                  paramAnonymousString.HKS.GcV = 1;
                  paramAnonymousString.HKS.GcW = new LinkedList();
                  paramAnonymousString.HKS.GcW.add(localObject);
                }
                com.tencent.mm.plugin.voip.b.f.Logi(b.this.TAG, "relay conn cnt: " + paramAnonymousString.HKR.Hlr);
                try
                {
                  b.this.Cbq.CaI.CgJ = paramAnonymousString.HKR.toByteArray();
                }
                catch (Exception localException2)
                {
                  try
                  {
                    b.this.Cbq.CaI.CgK = paramAnonymousString.HKS.toByteArray();
                  }
                  catch (Exception localException2)
                  {
                    try
                    {
                      for (;;)
                      {
                        if (paramAnonymousString.HLB.GAE > 0) {
                          b.this.Cbq.CaI.CgL = paramAnonymousString.HLB.toByteArray();
                        }
                        if (paramAnonymousString.HJd.FAN.getBuffer() == null) {
                          break;
                        }
                        b.this.Cbq.bP(paramAnonymousString.HJd.FAN.getBuffer().toByteArray());
                        if ((paramAnonymousString.HLf != null) && (paramAnonymousString.HLf.getBuffer() != null) && (paramAnonymousString.HLr != null) && (paramAnonymousString.HLr.getBuffer() != null)) {
                          b.this.Cbq.a(paramAnonymousString.HLf.getBuffer().toByteArray(), paramAnonymousString.HLe, paramAnonymousString.uLO, paramAnonymousString.HLr.getBuffer().toByteArray());
                        }
                        b.this.Cbq.j(paramAnonymousString.HLi, paramAnonymousString.HLj, paramAnonymousString.HLk, paramAnonymousString.HLl, paramAnonymousString.HLm);
                        b.this.Cbq.Ui(paramAnonymousString.HLq);
                        if ((paramAnonymousString.HLo != null) && (paramAnonymousString.HLp != null) && (paramAnonymousString.HLo.getBuffer() != null) && (paramAnonymousString.HLp.getBuffer() != null)) {
                          b.this.Cbq.c(paramAnonymousString.HLn, paramAnonymousString.HLo.getBuffer().toByteArray(), paramAnonymousString.HLp.getBuffer().toByteArray());
                        }
                        if (paramAnonymousString.HJe.FAN.getBuffer() == null) {
                          break label1109;
                        }
                        b.this.Cbq.bQ(paramAnonymousString.HJe.FAN.getBuffer().toByteArray());
                        b.this.Cbq.Uh(paramAnonymousString.HLt);
                        b.this.Cbq.CaI.Cgx = paramAnonymousString.HLu;
                        if ((paramAnonymousString.HLw != null) && (paramAnonymousString.HLw.getBuffer() != null)) {
                          b.this.Cbq.CaI.Cfq = paramAnonymousString.HLw.getBuffer().toByteArray();
                        }
                        if (!b.this.Cbq.Cak) {
                          break label1205;
                        }
                        b.this.Cbq.Cak = false;
                        if (b.this.Cbq.Cag != true) {
                          break label1128;
                        }
                        com.tencent.mm.plugin.voip.b.f.Logi(b.this.TAG, "channel pre-connect already success, start talk");
                        aq.f(new Runnable()
                        {
                          public final void run()
                          {
                            AppMethodBeat.i(177027);
                            b.this.Cbq.ewd();
                            AppMethodBeat.o(177027);
                          }
                        });
                        b.this.Cbq.ewn();
                        b.this.Cbq.ewl();
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
                        if (b.this.Cbq.Caj == true)
                        {
                          com.tencent.mm.plugin.voip.b.f.Logi(b.this.TAG, "channel pre-connect already failed");
                          b.this.Cbq.J(1, -9000, "");
                          AppMethodBeat.o(115217);
                          return;
                        }
                        com.tencent.mm.plugin.voip.b.f.Logi(b.this.TAG, "channel pre-connect still connecting...");
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
          paramAnonymousString.uLO = 1;
          com.tencent.mm.plugin.voip.b.f.Logi(b.this.TAG, "zhengxue[LOGIC]:got no EncryptStrategy in answerresp mrdata");
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