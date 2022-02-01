package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.misc.a.a;
import com.tencent.mm.plugin.voip.b.e;
import com.tencent.mm.plugin.voip.c;
import com.tencent.mm.plugin.voip.model.VoipScoreState;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.ahj;
import com.tencent.mm.protocal.protobuf.ahk;
import com.tencent.mm.protocal.protobuf.bqy;
import com.tencent.mm.protocal.protobuf.csu;
import com.tencent.mm.protocal.protobuf.dml;
import com.tencent.mm.protocal.protobuf.dmm;
import com.tencent.mm.protocal.protobuf.ess;
import com.tencent.mm.protocal.protobuf.est;
import com.tencent.mm.protocal.protobuf.eue;
import com.tencent.mm.protocal.protobuf.euk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.LinkedList;

public final class b
  extends n<ess, est>
{
  String TAG;
  
  public b(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong, boolean paramBoolean1, boolean paramBoolean2, LinkedList<csu> paramLinkedList)
  {
    AppMethodBeat.i(115219);
    this.TAG = "MicroMsg.NetSceneVoipAnswer";
    Object localObject1 = new d.a();
    ((d.a)localObject1).iLN = new ess();
    ((d.a)localObject1).iLO = new est();
    ((d.a)localObject1).uri = "/cgi-bin/micromsg-bin/voipanswer";
    ((d.a)localObject1).funcId = 172;
    ((d.a)localObject1).iLP = 65;
    ((d.a)localObject1).respCmdId = 1000000065;
    this.rr = ((d.a)localObject1).aXF();
    localObject1 = (ess)this.rr.iLK.iLR;
    ((ess)localObject1).Nqa = paramInt1;
    ((ess)localObject1).LsZ = paramInt3;
    ((ess)localObject1).Llx = paramInt2;
    Object localObject2 = new euk();
    ((euk)localObject2).oUv = 2;
    SKBuiltinBuffer_t localSKBuiltinBuffer_t = new SKBuiltinBuffer_t();
    localSKBuiltinBuffer_t.setBuffer(paramArrayOfByte1);
    ((euk)localObject2).KMS = localSKBuiltinBuffer_t;
    ((ess)localObject1).NpJ = ((euk)localObject2);
    paramArrayOfByte1 = new euk();
    paramArrayOfByte1.oUv = 3;
    localObject2 = new SKBuiltinBuffer_t();
    ((SKBuiltinBuffer_t)localObject2).setBuffer(paramArrayOfByte2);
    paramArrayOfByte1.KMS = ((SKBuiltinBuffer_t)localObject2);
    ((ess)localObject1).NpK = paramArrayOfByte1;
    ((ess)localObject1).Lta = paramLong;
    if (paramBoolean2)
    {
      if (paramBoolean1)
      {
        paramInt1 = 1;
        ((ess)localObject1).Nqb = paramInt1;
      }
    }
    else
    {
      ((ess)localObject1).NpN = System.currentTimeMillis();
      paramInt1 = ((a)g.af(a.class)).Qr(2);
      Log.i(this.TAG, "simType: %s", new Object[] { Integer.valueOf(paramInt1) });
      if (paramInt1 != 0) {
        break label324;
      }
      paramInt1 = 0;
    }
    for (;;)
    {
      ((ess)localObject1).NpO = paramInt1;
      if (paramLinkedList != null)
      {
        ((ess)localObject1).NpP = paramLinkedList.size();
        ((ess)localObject1).NpQ = paramLinkedList;
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
  
  public final i fIF()
  {
    AppMethodBeat.i(115220);
    i local1 = new i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, final String paramAnonymousString, q paramAnonymousq)
      {
        AppMethodBeat.i(115218);
        e.Logi(b.this.TAG, "Anwser response:" + paramAnonymousInt1 + " errCode:" + paramAnonymousInt2 + " status:" + b.this.GWA.mStatus);
        if (b.this.GWA.mStatus == 1)
        {
          e.Logi(b.this.TAG, "reject ok!");
          AppMethodBeat.o(115218);
          return;
        }
        if (b.this.GWA.mStatus != 4)
        {
          e.Loge(b.this.TAG, "Anwser response not within WAITCONNECT, ignored.");
          AppMethodBeat.o(115218);
          return;
        }
        if (paramAnonymousInt1 != 0)
        {
          if (paramAnonymousInt1 == 4)
          {
            b.this.GWA.GVV.Hcw.GXc = 12;
            b.this.GWA.GVV.Hcw.GXd = paramAnonymousInt2;
            b.this.GWA.K(1, paramAnonymousInt2, "");
            AppMethodBeat.o(115218);
            return;
          }
          b.this.GWA.GVV.Hcw.GXc = 12;
          b.this.GWA.GVV.Hcw.GXd = paramAnonymousInt2;
          b.this.GWA.K(1, -9004, "");
          AppMethodBeat.o(115218);
          return;
        }
        paramAnonymousString = (est)b.this.fIJ();
        b.this.GWA.GVV.roomId = paramAnonymousString.LsZ;
        b.this.GWA.GVV.ypH = paramAnonymousString.Lta;
        b.this.GWA.GVV.ypO = paramAnonymousString.NpR;
        b.this.GWA.GVV.Hbl = paramAnonymousString.Nqe;
        b.this.GWA.GVV.Hbm = paramAnonymousString.Nqf;
        b.this.GWA.GVV.Hbn = paramAnonymousString.Nqg;
        b.this.GWA.GVV.Hbo = paramAnonymousString.Nqh;
        b.this.GWA.GVV.Hbq = paramAnonymousString.Nqj;
        b.this.GWA.GVV.Hbp = paramAnonymousString.Nqo;
        b.this.GWA.GVV.HaF = paramAnonymousString.NpV;
        b.this.GWA.GVV.Hbs = paramAnonymousString.Nqq;
        b.this.GWA.adl(paramAnonymousString.NpT);
        b.this.GWA.GVV.HaJ = paramAnonymousString.NpW;
        if ((paramAnonymousString.NpX != null) && (paramAnonymousString.NpX.getBuffer() != null)) {
          b.this.GWA.GVV.HaH = paramAnonymousString.NpX.getBuffer().toByteArray();
        }
        if (paramAnonymousString.NpX.getILen() >= 12)
        {
          paramAnonymousq = ByteBuffer.wrap(paramAnonymousString.NpX.getBuffer().toByteArray(), 8, 4);
          ByteOrder localByteOrder1 = ByteOrder.nativeOrder();
          ByteOrder localByteOrder2 = paramAnonymousq.order();
          paramAnonymousInt1 = paramAnonymousq.getInt();
          e.Logd(b.this.TAG, "steve:nSvrBaseBRTuneRatio1:" + paramAnonymousInt1 + ", nativeOrder:" + localByteOrder1 + ", bbOrder:" + localByteOrder2);
          b.this.GWA.GVV.Hbr = paramAnonymousInt1;
        }
        e.Logi(b.this.TAG, "onAnwserResp: audioTsdfBeyond3G = " + b.this.GWA.GVV.Hbl + ",audioTsdEdge = " + b.this.GWA.GVV.Hbm + ",passthroughQosAlgorithm = " + b.this.GWA.GVV.Hbn + ",fastPlayRepair = " + b.this.GWA.GVV.Hbo + ", audioDtx = " + b.this.GWA.GVV.Hbq + ", switchtcppktCnt=" + b.this.GWA.GVV.HaE + ", SvrCfgListV=" + b.this.GWA.GVV.Hbp + ", setMaxBRForRelay=" + b.this.GWA.GVV.Hbs + ", RedirectreqThreshold=" + paramAnonymousString.NpS.NrZ + ", BothSideSwitchFlag=" + paramAnonymousString.NpS.Nsa + ", WifiScanInterval=" + paramAnonymousString.NpW + ", BaseBRTuneRatio=" + b.this.GWA.GVV.Hbr);
        b.this.GWA.GVV.Hbt = paramAnonymousString.Nqn;
        b.this.GWA.GVV.Hbu = paramAnonymousString.Nqr;
        e.Logi(b.this.TAG, "answerResp AudioAecMode5 = " + b.this.GWA.GVV.Hbt);
        b.this.GWA.fGE();
        b.this.GWA.fGF();
        b.this.GWA.GVv = true;
        e.Logi(b.this.TAG, "answer ok, roomid =" + b.this.GWA.GVV.roomId + ",memberid = " + b.this.GWA.GVV.ypO);
        paramAnonymousString = paramAnonymousString.NpS;
        if (paramAnonymousString.yqc > 0)
        {
          paramAnonymousString.yqc -= 1;
          e.Logi(b.this.TAG, "zhengxue[ENCRYPT] got encryptStrategy[" + paramAnonymousString.yqc + "] from answerresp relaydata");
        }
        for (;;)
        {
          e.Logi(b.this.TAG, "answer with relayData peerid.length =" + paramAnonymousString.NpJ.KMS.getILen());
          e.Logi(b.this.TAG, "answer with relayData capinfo.length =" + paramAnonymousString.NpK.KMS.getILen());
          b.this.GWA.adk(paramAnonymousString.NrE);
          b.this.GWA.GWj.d(paramAnonymousString.Nse, paramAnonymousString.Nsd, b.this.GWA.GVV.roomId, b.this.GWA.GVV.ypH);
          try
          {
            g.aAk().postToWorker(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(115217);
                c.fFg().fIj();
                e.Logi(b.this.TAG, "steve:doublelink timer started!");
                Object localObject;
                if ((paramAnonymousString.Nrx == null) || (paramAnonymousString.Nrx.MPZ == 0))
                {
                  localObject = new dml();
                  ((dml)localObject).LqX = 0;
                  ((dml)localObject).LqY = "";
                  ((dml)localObject).LqZ = "";
                  ((dml)localObject).Lra = b.this.GWA.GVV.netType;
                  ((dml)localObject).Lrb = 4;
                  ((dml)localObject).Lrc = 2;
                  ((dml)localObject).MPX = paramAnonymousString.NrF;
                  ((dml)localObject).MPY = paramAnonymousString.NrN;
                  paramAnonymousString.Nrx = new dmm();
                  paramAnonymousString.Nrx.MPZ = 1;
                  paramAnonymousString.Nrx.MQa = new LinkedList();
                  paramAnonymousString.Nrx.MQa.add(localObject);
                }
                if ((paramAnonymousString.Nry == null) || (paramAnonymousString.Nry.Lri == 0))
                {
                  localObject = new ahj();
                  ((ahj)localObject).LqX = 1;
                  ((ahj)localObject).LqY = "";
                  ((ahj)localObject).LqZ = "";
                  ((ahj)localObject).Lra = b.this.GWA.GVV.netType;
                  ((ahj)localObject).Lrb = 4;
                  ((ahj)localObject).Lrc = 2;
                  ((ahj)localObject).Lrd = paramAnonymousString.NrG;
                  ((ahj)localObject).Lre = paramAnonymousString.Nsf;
                  ((ahj)localObject).Lrf = paramAnonymousString.Nsg;
                  paramAnonymousString.Nry = new ahk();
                  paramAnonymousString.Nry.Lri = 1;
                  paramAnonymousString.Nry.Lrj = new LinkedList();
                  paramAnonymousString.Nry.Lrj.add(localObject);
                }
                e.Logi(b.this.TAG, "relay conn cnt: " + paramAnonymousString.Nrx.MPZ);
                try
                {
                  b.this.GWA.GVV.HbZ = paramAnonymousString.Nrx.toByteArray();
                }
                catch (Exception localException2)
                {
                  try
                  {
                    b.this.GWA.GVV.Hca = paramAnonymousString.Nry.toByteArray();
                  }
                  catch (Exception localException2)
                  {
                    try
                    {
                      for (;;)
                      {
                        if (paramAnonymousString.Nsh.LYw > 0) {
                          b.this.GWA.GVV.Hcb = paramAnonymousString.Nsh.toByteArray();
                        }
                        if (paramAnonymousString.NpJ.KMS.getBuffer() == null) {
                          break;
                        }
                        b.this.GWA.ci(paramAnonymousString.NpJ.KMS.getBuffer().toByteArray());
                        if ((paramAnonymousString.NrL != null) && (paramAnonymousString.NrL.getBuffer() != null) && (paramAnonymousString.NrX != null) && (paramAnonymousString.NrX.getBuffer() != null)) {
                          b.this.GWA.a(paramAnonymousString.NrL.getBuffer().toByteArray(), paramAnonymousString.NrK, paramAnonymousString.yqc, paramAnonymousString.NrX.getBuffer().toByteArray());
                        }
                        b.this.GWA.k(paramAnonymousString.NrO, paramAnonymousString.NrP, paramAnonymousString.NrQ, paramAnonymousString.NrR, paramAnonymousString.NrS);
                        b.this.GWA.adj(paramAnonymousString.NrW);
                        if ((paramAnonymousString.NrU != null) && (paramAnonymousString.NrV != null) && (paramAnonymousString.NrU.getBuffer() != null) && (paramAnonymousString.NrV.getBuffer() != null)) {
                          b.this.GWA.c(paramAnonymousString.NrT, paramAnonymousString.NrU.getBuffer().toByteArray(), paramAnonymousString.NrV.getBuffer().toByteArray());
                        }
                        if (paramAnonymousString.NpK.KMS.getBuffer() == null) {
                          break label1109;
                        }
                        b.this.GWA.cj(paramAnonymousString.NpK.KMS.getBuffer().toByteArray());
                        b.this.GWA.adi(paramAnonymousString.NrZ);
                        b.this.GWA.GVV.HbM = paramAnonymousString.Nsa;
                        if ((paramAnonymousString.Nsc != null) && (paramAnonymousString.Nsc.getBuffer() != null)) {
                          b.this.GWA.GVV.HaG = paramAnonymousString.Nsc.getBuffer().toByteArray();
                        }
                        if (!b.this.GWA.GVx) {
                          break label1205;
                        }
                        b.this.GWA.GVx = false;
                        if (b.this.GWA.GVt != true) {
                          break label1128;
                        }
                        e.Logi(b.this.TAG, "channel pre-connect already success, start talk");
                        MMHandlerThread.postToMainThread(new Runnable()
                        {
                          public final void run()
                          {
                            AppMethodBeat.i(177027);
                            b.this.GWA.fGy();
                            AppMethodBeat.o(177027);
                          }
                        });
                        b.this.GWA.fGK();
                        b.this.GWA.fGI();
                        AppMethodBeat.o(115217);
                        return;
                        localException1 = localException1;
                        Log.e(b.this.TAG, "relay conn info to byte array fail..");
                        continue;
                        localException2 = localException2;
                        Log.e(b.this.TAG, "direct conn info to byte array fail..");
                      }
                    }
                    catch (Exception localException3)
                    {
                      for (;;)
                      {
                        Log.e(b.this.TAG, "nic query info to byte array fail..");
                        continue;
                        Log.e(b.this.TAG, "multiRelayData.PeerId.Buffer.getBuffer() is null");
                        continue;
                        label1109:
                        Log.e(b.this.TAG, "multiRelayData.CapInfo.Buffer.getBuffer() is null");
                        continue;
                        label1128:
                        if (b.this.GWA.GVw == true)
                        {
                          e.Logi(b.this.TAG, "channel pre-connect already failed");
                          b.this.GWA.K(1, -9000, "");
                          AppMethodBeat.o(115217);
                          return;
                        }
                        e.Logi(b.this.TAG, "channel pre-connect still connecting...");
                        continue;
                        label1205:
                        Log.i(b.this.TAG, "isPreConnect is false");
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
            Log.e(b.this.TAG, "get proxy ip fail..");
            AppMethodBeat.o(115218);
          }
          paramAnonymousString.yqc = 1;
          e.Logi(b.this.TAG, "zhengxue[LOGIC]:got no EncryptStrategy in answerresp mrdata");
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