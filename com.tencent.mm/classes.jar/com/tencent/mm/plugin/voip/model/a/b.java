package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.misc.a.a;
import com.tencent.mm.plugin.voip.SubCoreVoip;
import com.tencent.mm.plugin.voip.f.g;
import com.tencent.mm.plugin.voip.model.VoipScoreState;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.plugin.voip.model.o;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.protocal.protobuf.akl;
import com.tencent.mm.protocal.protobuf.akm;
import com.tencent.mm.protocal.protobuf.cnv;
import com.tencent.mm.protocal.protobuf.dtl;
import com.tencent.mm.protocal.protobuf.epe;
import com.tencent.mm.protocal.protobuf.epf;
import com.tencent.mm.protocal.protobuf.fzp;
import com.tencent.mm.protocal.protobuf.fzq;
import com.tencent.mm.protocal.protobuf.gbb;
import com.tencent.mm.protocal.protobuf.gbh;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.LinkedList;

public final class b
  extends n<fzp, fzq>
{
  private String TAG;
  
  public b(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong, boolean paramBoolean1, boolean paramBoolean2, LinkedList<dtl> paramLinkedList)
  {
    AppMethodBeat.i(115219);
    this.TAG = "MicroMsg.NetSceneVoipAnswer";
    Object localObject1 = new c.a();
    ((c.a)localObject1).otE = new fzp();
    ((c.a)localObject1).otF = new fzq();
    ((c.a)localObject1).uri = "/cgi-bin/micromsg-bin/voipanswer";
    ((c.a)localObject1).funcId = 172;
    ((c.a)localObject1).otG = 65;
    ((c.a)localObject1).respCmdId = 1000000065;
    this.rr = ((c.a)localObject1).bEF();
    localObject1 = (fzp)c.b.b(this.rr.otB);
    ((fzp)localObject1).abXh = paramInt1;
    ((fzp)localObject1).Zvz = paramInt3;
    ((fzp)localObject1).ZkT = paramInt2;
    Object localObject2 = new gbh();
    ((gbh)localObject2).vhJ = 2;
    gol localgol = new gol();
    localgol.df(paramArrayOfByte1);
    ((gbh)localObject2).YLa = localgol;
    ((fzp)localObject1).abWP = ((gbh)localObject2);
    paramArrayOfByte1 = new gbh();
    paramArrayOfByte1.vhJ = 3;
    localObject2 = new gol();
    ((gol)localObject2).df(paramArrayOfByte2);
    paramArrayOfByte1.YLa = ((gol)localObject2);
    ((fzp)localObject1).abWQ = paramArrayOfByte1;
    ((fzp)localObject1).abWX = this.UzB.UyU.getIpStack();
    ((fzp)localObject1).ZvA = paramLong;
    if (paramBoolean2)
    {
      if (paramBoolean1)
      {
        paramInt1 = 1;
        ((fzp)localObject1).abXi = paramInt1;
      }
    }
    else
    {
      ((fzp)localObject1).abWT = System.currentTimeMillis();
      paramInt1 = ((a)com.tencent.mm.kernel.h.ax(a.class)).aaG(2);
      g.Logi(this.TAG, "simType:" + paramInt1 + " ipstack:" + ((fzp)localObject1).abWX);
      if (paramInt1 != 0) {
        break label355;
      }
      paramInt1 = 0;
    }
    for (;;)
    {
      ((fzp)localObject1).abWU = paramInt1;
      if (paramLinkedList != null)
      {
        ((fzp)localObject1).abWV = paramLinkedList.size();
        ((fzp)localObject1).abWW = paramLinkedList;
      }
      AppMethodBeat.o(115219);
      return;
      paramInt1 = 0;
      break;
      label355:
      if (paramInt1 == 3) {
        paramInt1 = 3;
      } else if (paramInt1 == 1) {
        paramInt1 = 1;
      } else {
        paramInt1 = 2;
      }
    }
  }
  
  public final int getType()
  {
    return 172;
  }
  
  public final com.tencent.mm.am.h hYT()
  {
    AppMethodBeat.i(115220);
    com.tencent.mm.am.h local1 = new com.tencent.mm.am.h()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, final String paramAnonymousString, p paramAnonymousp)
      {
        AppMethodBeat.i(115218);
        g.Logi(b.a(b.this), "Anwser response:" + paramAnonymousInt1 + " errCode:" + paramAnonymousInt2 + " status:" + b.this.UzB.mStatus);
        if (b.this.UzB.mStatus == 1)
        {
          g.Logi(b.a(b.this), "reject ok!");
          AppMethodBeat.o(115218);
          return;
        }
        if (b.this.UzB.mStatus != 4)
        {
          g.Loge(b.a(b.this), "Anwser response not within WAITCONNECT, ignored.");
          AppMethodBeat.o(115218);
          return;
        }
        if (paramAnonymousInt1 != 0)
        {
          if (paramAnonymousInt1 == 4)
          {
            b.this.UzB.UyU.UFN.UAh = 12;
            b.this.UzB.UyU.UFN.UAi = paramAnonymousInt2;
            b.this.UzB.S(1, paramAnonymousInt2, "");
            AppMethodBeat.o(115218);
            return;
          }
          b.this.UzB.UyU.UFN.UAh = 12;
          b.this.UzB.UyU.UFN.UAi = paramAnonymousInt2;
          b.this.UzB.S(1, -9004, "");
          AppMethodBeat.o(115218);
          return;
        }
        paramAnonymousString = (fzq)b.this.hYX();
        b.this.UzB.UyU.roomId = paramAnonymousString.Zvz;
        b.this.UzB.UyU.Hnt = paramAnonymousString.ZvA;
        b.this.UzB.UyU.JHb = paramAnonymousString.abWY;
        b.this.UzB.UyU.UEC = paramAnonymousString.abXl;
        b.this.UzB.UyU.UED = paramAnonymousString.abXm;
        b.this.UzB.UyU.UEE = paramAnonymousString.abXn;
        b.this.UzB.UyU.UEF = paramAnonymousString.abXo;
        b.this.UzB.UyU.UEH = paramAnonymousString.abXq;
        b.this.UzB.UyU.UEG = paramAnonymousString.abXv;
        b.this.UzB.UyU.UDD = paramAnonymousString.abXc;
        b.this.UzB.UyU.UEJ = paramAnonymousString.abXx;
        b.this.UzB.aqs(paramAnonymousString.abXa);
        b.this.UzB.UyU.UDH = paramAnonymousString.abXd;
        if ((paramAnonymousString.abXe != null) && (paramAnonymousString.abXe.aaxD != null)) {
          b.this.UzB.UyU.UDF = paramAnonymousString.abXe.aaxD.toByteArray();
        }
        if (paramAnonymousString.abXe.abwJ >= 12)
        {
          paramAnonymousp = ByteBuffer.wrap(paramAnonymousString.abXe.aaxD.toByteArray(), 8, 4);
          ByteOrder localByteOrder1 = ByteOrder.nativeOrder();
          ByteOrder localByteOrder2 = paramAnonymousp.order();
          paramAnonymousInt1 = paramAnonymousp.getInt();
          g.Logd(b.a(b.this), "steve:nSvrBaseBRTuneRatio1:" + paramAnonymousInt1 + ", nativeOrder:" + localByteOrder1 + ", bbOrder:" + localByteOrder2);
          b.this.UzB.UyU.UEI = paramAnonymousInt1;
        }
        g.Logi(b.a(b.this), "onAnwserResp: audioTsdfBeyond3G = " + b.this.UzB.UyU.UEC + ",audioTsdEdge = " + b.this.UzB.UyU.UED + ",passthroughQosAlgorithm = " + b.this.UzB.UyU.UEE + ",fastPlayRepair = " + b.this.UzB.UyU.UEF + ", audioDtx = " + b.this.UzB.UyU.UEH + ", switchtcppktCnt=" + b.this.UzB.UyU.UDC + ", SvrCfgListV=" + b.this.UzB.UyU.UEG + ", setMaxBRForRelay=" + b.this.UzB.UyU.UEJ + ", RedirectreqThreshold=" + paramAnonymousString.abWZ.abZh + ", BothSideSwitchFlag=" + paramAnonymousString.abWZ.abZi + ", WifiScanInterval=" + paramAnonymousString.abXd + ", BaseBRTuneRatio=" + b.this.UzB.UyU.UEI);
        b.this.UzB.UyU.UEK = paramAnonymousString.abXu;
        b.this.UzB.UyU.UEL = paramAnonymousString.abXy;
        g.Logi(b.a(b.this), "answerResp AudioAecMode5 = " + b.this.UzB.UyU.UEK);
        b.this.UzB.hWM();
        b.this.UzB.hWN();
        b.this.UzB.Uyu = true;
        paramAnonymousp = b.this.UzB.UyU.UFN;
        paramAnonymousp.wS((int)(System.currentTimeMillis() - paramAnonymousp.UAP));
        g.Logi(b.a(b.this), "answer ok, roomid =" + b.this.UzB.UyU.roomId + ",memberid = " + b.this.UzB.UyU.JHb);
        paramAnonymousString = paramAnonymousString.abWZ;
        if (paramAnonymousString.JHp > 0)
        {
          paramAnonymousString.JHp -= 1;
          g.Logi(b.a(b.this), "zhengxue[ENCRYPT] got encryptStrategy[" + paramAnonymousString.JHp + "] from answerresp relaydata");
        }
        for (;;)
        {
          g.Logi(b.a(b.this), "answer with relayData peerid.length =" + paramAnonymousString.abWP.YLa.abwJ);
          g.Logi(b.a(b.this), "answer with relayData capinfo.length =" + paramAnonymousString.abWQ.YLa.abwJ);
          b.this.UzB.aqr(paramAnonymousString.abYM);
          b.this.UzB.Uzi.d(paramAnonymousString.abZm, paramAnonymousString.abZl, b.this.UzB.UyU.roomId, b.this.UzB.UyU.Hnt);
          try
          {
            com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(115217);
                SubCoreVoip.hVp().hYC();
                g.Logi(b.a(b.this), "steve:doublelink timer started!");
                Object localObject;
                if ((paramAnonymousString.abYF == null) || (paramAnonymousString.abYF.abtq == 0))
                {
                  localObject = new epe();
                  ((epe)localObject).ZrC = 0;
                  ((epe)localObject).ZrD = "";
                  ((epe)localObject).ZrE = "";
                  ((epe)localObject).ZrF = b.this.UzB.UyU.netType;
                  ((epe)localObject).ZrG = 4;
                  ((epe)localObject).ZrH = 2;
                  ((epe)localObject).abto = paramAnonymousString.abYN;
                  ((epe)localObject).abtp = paramAnonymousString.abYV;
                  paramAnonymousString.abYF = new epf();
                  paramAnonymousString.abYF.abtq = 1;
                  paramAnonymousString.abYF.abtr = new LinkedList();
                  paramAnonymousString.abYF.abtr.add(localObject);
                }
                if ((paramAnonymousString.abYG == null) || (paramAnonymousString.abYG.ZrN == 0))
                {
                  localObject = new akl();
                  ((akl)localObject).ZrC = 1;
                  ((akl)localObject).ZrD = "";
                  ((akl)localObject).ZrE = "";
                  ((akl)localObject).ZrF = b.this.UzB.UyU.netType;
                  ((akl)localObject).ZrG = 4;
                  ((akl)localObject).ZrH = 2;
                  ((akl)localObject).ZrI = paramAnonymousString.abYO;
                  ((akl)localObject).ZrJ = paramAnonymousString.abZn;
                  ((akl)localObject).ZrK = paramAnonymousString.abZo;
                  paramAnonymousString.abYG = new akm();
                  paramAnonymousString.abYG.ZrN = 1;
                  paramAnonymousString.abYG.ZrO = new LinkedList();
                  paramAnonymousString.abYG.ZrO.add(localObject);
                }
                g.Logi(b.a(b.this), "relay conn cnt: " + paramAnonymousString.abYF.abtq);
                try
                {
                  b.this.UzB.UyU.UFq = paramAnonymousString.abYF.toByteArray();
                }
                catch (Exception localException2)
                {
                  try
                  {
                    b.this.UzB.UyU.UFr = paramAnonymousString.abYG.toByteArray();
                  }
                  catch (Exception localException2)
                  {
                    try
                    {
                      for (;;)
                      {
                        if (paramAnonymousString.abZp.aavd > 0) {
                          b.this.UzB.UyU.UFs = paramAnonymousString.abZp.toByteArray();
                        }
                        if (paramAnonymousString.abWP.YLa.aaxD == null) {
                          break;
                        }
                        b.this.UzB.cC(paramAnonymousString.abWP.YLa.aaxD.toByteArray());
                        if ((paramAnonymousString.abYT != null) && (paramAnonymousString.abYT.aaxD != null) && (paramAnonymousString.abZf != null) && (paramAnonymousString.abZf.aaxD != null)) {
                          b.this.UzB.a(paramAnonymousString.abYT.aaxD.toByteArray(), paramAnonymousString.abYS, paramAnonymousString.JHp, paramAnonymousString.abZf.aaxD.toByteArray());
                        }
                        b.this.UzB.p(paramAnonymousString.abYW, paramAnonymousString.abYX, paramAnonymousString.abYY, paramAnonymousString.abYZ, paramAnonymousString.abZa);
                        b.this.UzB.aqq(paramAnonymousString.abZe);
                        if ((paramAnonymousString.abZc != null) && (paramAnonymousString.abZd != null) && (paramAnonymousString.abZc.aaxD != null) && (paramAnonymousString.abZd.aaxD != null)) {
                          b.this.UzB.c(paramAnonymousString.abZb, paramAnonymousString.abZc.aaxD.toByteArray(), paramAnonymousString.abZd.aaxD.toByteArray());
                        }
                        if (paramAnonymousString.abWQ.YLa.aaxD == null) {
                          break label1109;
                        }
                        b.this.UzB.cD(paramAnonymousString.abWQ.YLa.aaxD.toByteArray());
                        b.this.UzB.aqp(paramAnonymousString.abZh);
                        b.this.UzB.UyU.UFd = paramAnonymousString.abZi;
                        if ((paramAnonymousString.abZk != null) && (paramAnonymousString.abZk.aaxD != null)) {
                          b.this.UzB.UyU.UDE = paramAnonymousString.abZk.aaxD.toByteArray();
                        }
                        if (!b.this.UzB.Uyw) {
                          break label1205;
                        }
                        b.this.UzB.Uyw = false;
                        if (b.this.UzB.Uys != true) {
                          break label1128;
                        }
                        g.Logi(b.a(b.this), "channel pre-connect already success, start talk");
                        MMHandlerThread.postToMainThread(new Runnable()
                        {
                          public final void run()
                          {
                            AppMethodBeat.i(177027);
                            b.this.UzB.hWG();
                            AppMethodBeat.o(177027);
                          }
                        });
                        b.this.UzB.hWS();
                        b.this.UzB.hWQ();
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
                        if (b.this.UzB.Uyv == true)
                        {
                          g.Logi(b.a(b.this), "channel pre-connect already failed");
                          b.this.UzB.S(1, -9000, "");
                          AppMethodBeat.o(115217);
                          return;
                        }
                        g.Logi(b.a(b.this), "channel pre-connect still connecting...");
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
          paramAnonymousString.JHp = 1;
          g.Logi(b.a(b.this), "zhengxue[LOGIC]:got no EncryptStrategy in answerresp mrdata");
        }
      }
    };
    AppMethodBeat.o(115220);
    return local1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.b
 * JD-Core Version:    0.7.0.1
 */