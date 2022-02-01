package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.misc.a.a;
import com.tencent.mm.plugin.voip.c;
import com.tencent.mm.plugin.voip.model.VoipScoreState;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.afd;
import com.tencent.mm.protocal.protobuf.afe;
import com.tencent.mm.protocal.protobuf.bfc;
import com.tencent.mm.protocal.protobuf.ccp;
import com.tencent.mm.protocal.protobuf.ctv;
import com.tencent.mm.protocal.protobuf.ctw;
import com.tencent.mm.protocal.protobuf.dyl;
import com.tencent.mm.protocal.protobuf.dym;
import com.tencent.mm.protocal.protobuf.dzx;
import com.tencent.mm.protocal.protobuf.ead;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.LinkedList;

public final class b
  extends n<dyl, dym>
{
  String TAG;
  
  public b(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong, boolean paramBoolean1, boolean paramBoolean2, LinkedList<ccp> paramLinkedList)
  {
    AppMethodBeat.i(115219);
    this.TAG = "MicroMsg.NetSceneVoipAnswer";
    Object localObject1 = new b.a();
    ((b.a)localObject1).hQF = new dyl();
    ((b.a)localObject1).hQG = new dym();
    ((b.a)localObject1).uri = "/cgi-bin/micromsg-bin/voipanswer";
    ((b.a)localObject1).funcId = 172;
    ((b.a)localObject1).hQH = 65;
    ((b.a)localObject1).respCmdId = 1000000065;
    this.rr = ((b.a)localObject1).aDS();
    localObject1 = (dyl)this.rr.hQD.hQJ;
    ((dyl)localObject1).IdC = paramInt1;
    ((dyl)localObject1).Gxq = paramInt3;
    ((dyl)localObject1).GqB = paramInt2;
    Object localObject2 = new ead();
    ((ead)localObject2).nJA = 2;
    SKBuiltinBuffer_t localSKBuiltinBuffer_t = new SKBuiltinBuffer_t();
    localSKBuiltinBuffer_t.setBuffer(paramArrayOfByte1);
    ((ead)localObject2).FTj = localSKBuiltinBuffer_t;
    ((dyl)localObject1).Idl = ((ead)localObject2);
    paramArrayOfByte1 = new ead();
    paramArrayOfByte1.nJA = 3;
    localObject2 = new SKBuiltinBuffer_t();
    ((SKBuiltinBuffer_t)localObject2).setBuffer(paramArrayOfByte2);
    paramArrayOfByte1.FTj = ((SKBuiltinBuffer_t)localObject2);
    ((dyl)localObject1).Idm = paramArrayOfByte1;
    ((dyl)localObject1).Gxr = paramLong;
    if (paramBoolean2)
    {
      if (paramBoolean1)
      {
        paramInt1 = 1;
        ((dyl)localObject1).IdD = paramInt1;
      }
    }
    else
    {
      ((dyl)localObject1).Idp = System.currentTimeMillis();
      paramInt1 = ((a)g.ab(a.class)).Kp(2);
      ae.i(this.TAG, "simType: %s", new Object[] { Integer.valueOf(paramInt1) });
      if (paramInt1 != 0) {
        break label324;
      }
      paramInt1 = 0;
    }
    for (;;)
    {
      ((dyl)localObject1).Idq = paramInt1;
      if (paramLinkedList != null)
      {
        ((dyl)localObject1).Idr = paramLinkedList.size();
        ((dyl)localObject1).Ids = paramLinkedList;
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
  
  public final com.tencent.mm.ak.f eBL()
  {
    AppMethodBeat.i(115220);
    com.tencent.mm.ak.f local1 = new com.tencent.mm.ak.f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, final String paramAnonymousString, com.tencent.mm.ak.n paramAnonymousn)
      {
        AppMethodBeat.i(115218);
        com.tencent.mm.plugin.voip.b.f.Logi(b.this.TAG, "Anwser response:" + paramAnonymousInt1 + " errCode:" + paramAnonymousInt2 + " status:" + b.this.CsR.mStatus);
        if (b.this.CsR.mStatus == 1)
        {
          com.tencent.mm.plugin.voip.b.f.Logi(b.this.TAG, "reject ok!");
          AppMethodBeat.o(115218);
          return;
        }
        if (b.this.CsR.mStatus != 4)
        {
          com.tencent.mm.plugin.voip.b.f.Loge(b.this.TAG, "Anwser response not within WAITCONNECT, ignored.");
          AppMethodBeat.o(115218);
          return;
        }
        if (paramAnonymousInt1 != 0)
        {
          if (paramAnonymousInt1 == 4)
          {
            b.this.CsR.Csj.CyH.Ctt = 12;
            b.this.CsR.Csj.CyH.Ctu = paramAnonymousInt2;
            b.this.CsR.J(1, paramAnonymousInt2, "");
            AppMethodBeat.o(115218);
            return;
          }
          b.this.CsR.Csj.CyH.Ctt = 12;
          b.this.CsR.Csj.CyH.Ctu = paramAnonymousInt2;
          b.this.CsR.J(1, -9004, "");
          AppMethodBeat.o(115218);
          return;
        }
        paramAnonymousString = (dym)b.this.eBP();
        b.this.CsR.Csj.roomId = paramAnonymousString.Gxq;
        b.this.CsR.Csj.uXg = paramAnonymousString.Gxr;
        b.this.CsR.Csj.uXn = paramAnonymousString.Idt;
        b.this.CsR.Csj.Cxx = paramAnonymousString.IdG;
        b.this.CsR.Csj.Cxy = paramAnonymousString.IdH;
        b.this.CsR.Csj.Cxz = paramAnonymousString.IdI;
        b.this.CsR.Csj.CxA = paramAnonymousString.IdJ;
        b.this.CsR.Csj.CxC = paramAnonymousString.IdL;
        b.this.CsR.Csj.CxB = paramAnonymousString.IdQ;
        b.this.CsR.Csj.CwQ = paramAnonymousString.Idx;
        b.this.CsR.Csj.CxE = paramAnonymousString.IdS;
        b.this.CsR.UR(paramAnonymousString.Idv);
        b.this.CsR.Csj.CwU = paramAnonymousString.Idy;
        if ((paramAnonymousString.Idz != null) && (paramAnonymousString.Idz.getBuffer() != null)) {
          b.this.CsR.Csj.CwS = paramAnonymousString.Idz.getBuffer().toByteArray();
        }
        if (paramAnonymousString.Idz.getILen() >= 12)
        {
          paramAnonymousn = ByteBuffer.wrap(paramAnonymousString.Idz.getBuffer().toByteArray(), 8, 4);
          ByteOrder localByteOrder1 = ByteOrder.nativeOrder();
          ByteOrder localByteOrder2 = paramAnonymousn.order();
          paramAnonymousInt1 = paramAnonymousn.getInt();
          com.tencent.mm.plugin.voip.b.f.Logd(b.this.TAG, "steve:nSvrBaseBRTuneRatio1:" + paramAnonymousInt1 + ", nativeOrder:" + localByteOrder1 + ", bbOrder:" + localByteOrder2);
          b.this.CsR.Csj.CxD = paramAnonymousInt1;
        }
        com.tencent.mm.plugin.voip.b.f.Logi(b.this.TAG, "onAnwserResp: audioTsdfBeyond3G = " + b.this.CsR.Csj.Cxx + ",audioTsdEdge = " + b.this.CsR.Csj.Cxy + ",passthroughQosAlgorithm = " + b.this.CsR.Csj.Cxz + ",fastPlayRepair = " + b.this.CsR.Csj.CxA + ", audioDtx = " + b.this.CsR.Csj.CxC + ", switchtcppktCnt=" + b.this.CsR.Csj.CwP + ", SvrCfgListV=" + b.this.CsR.Csj.CxB + ", setMaxBRForRelay=" + b.this.CsR.Csj.CxE + ", RedirectreqThreshold=" + paramAnonymousString.Idu.IfB + ", BothSideSwitchFlag=" + paramAnonymousString.Idu.IfC + ", WifiScanInterval=" + paramAnonymousString.Idy + ", BaseBRTuneRatio=" + b.this.CsR.Csj.CxD);
        b.this.CsR.Csj.CxF = paramAnonymousString.IdP;
        b.this.CsR.Csj.CxG = paramAnonymousString.IdT;
        com.tencent.mm.plugin.voip.b.f.Logi(b.this.TAG, "answerResp AudioAecMode5 = " + b.this.CsR.Csj.CxF);
        b.this.CsR.ezP();
        b.this.CsR.CrJ = true;
        com.tencent.mm.plugin.voip.b.f.Logi(b.this.TAG, "answer ok, roomid =" + b.this.CsR.Csj.roomId + ",memberid = " + b.this.CsR.Csj.uXn);
        paramAnonymousString = paramAnonymousString.Idu;
        if (paramAnonymousString.uXB > 0)
        {
          paramAnonymousString.uXB -= 1;
          com.tencent.mm.plugin.voip.b.f.Logi(b.this.TAG, "zhengxue[ENCRYPT] got encryptStrategy[" + paramAnonymousString.uXB + "] from answerresp relaydata");
        }
        for (;;)
        {
          com.tencent.mm.plugin.voip.b.f.Logi(b.this.TAG, "answer with relayData peerid.length =" + paramAnonymousString.Idl.FTj.getILen());
          com.tencent.mm.plugin.voip.b.f.Logi(b.this.TAG, "answer with relayData capinfo.length =" + paramAnonymousString.Idm.FTj.getILen());
          b.this.CsR.UQ(paramAnonymousString.Ifg);
          b.this.CsR.Csx.c(paramAnonymousString.IfG, paramAnonymousString.IfF, b.this.CsR.Csj.roomId, b.this.CsR.Csj.uXg);
          try
          {
            g.ajU().aw(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(115217);
                c.eys().eBp();
                com.tencent.mm.plugin.voip.b.f.Logi(b.this.TAG, "steve:doublelink timer started!");
                Object localObject;
                if ((paramAnonymousString.IeZ == null) || (paramAnonymousString.IeZ.HER == 0))
                {
                  localObject = new ctv();
                  ((ctv)localObject).Gvr = 0;
                  ((ctv)localObject).Gvs = "";
                  ((ctv)localObject).Gvt = "";
                  ((ctv)localObject).Gvu = b.this.CsR.Csj.netType;
                  ((ctv)localObject).Gvv = 4;
                  ((ctv)localObject).Gvw = 2;
                  ((ctv)localObject).HEP = paramAnonymousString.Ifh;
                  ((ctv)localObject).HEQ = paramAnonymousString.Ifp;
                  paramAnonymousString.IeZ = new ctw();
                  paramAnonymousString.IeZ.HER = 1;
                  paramAnonymousString.IeZ.HES = new LinkedList();
                  paramAnonymousString.IeZ.HES.add(localObject);
                }
                if ((paramAnonymousString.Ifa == null) || (paramAnonymousString.Ifa.GvC == 0))
                {
                  localObject = new afd();
                  ((afd)localObject).Gvr = 1;
                  ((afd)localObject).Gvs = "";
                  ((afd)localObject).Gvt = "";
                  ((afd)localObject).Gvu = b.this.CsR.Csj.netType;
                  ((afd)localObject).Gvv = 4;
                  ((afd)localObject).Gvw = 2;
                  ((afd)localObject).Gvx = paramAnonymousString.Ifi;
                  ((afd)localObject).Gvy = paramAnonymousString.IfH;
                  ((afd)localObject).Gvz = paramAnonymousString.IfI;
                  paramAnonymousString.Ifa = new afe();
                  paramAnonymousString.Ifa.GvC = 1;
                  paramAnonymousString.Ifa.GvD = new LinkedList();
                  paramAnonymousString.Ifa.GvD.add(localObject);
                }
                com.tencent.mm.plugin.voip.b.f.Logi(b.this.TAG, "relay conn cnt: " + paramAnonymousString.IeZ.HER);
                try
                {
                  b.this.CsR.Csj.Cyk = paramAnonymousString.IeZ.toByteArray();
                }
                catch (Exception localException2)
                {
                  try
                  {
                    b.this.CsR.Csj.Cyl = paramAnonymousString.Ifa.toByteArray();
                  }
                  catch (Exception localException2)
                  {
                    try
                    {
                      for (;;)
                      {
                        if (paramAnonymousString.IfJ.GUe > 0) {
                          b.this.CsR.Csj.Cym = paramAnonymousString.IfJ.toByteArray();
                        }
                        if (paramAnonymousString.Idl.FTj.getBuffer() == null) {
                          break;
                        }
                        b.this.CsR.bS(paramAnonymousString.Idl.FTj.getBuffer().toByteArray());
                        if ((paramAnonymousString.Ifn != null) && (paramAnonymousString.Ifn.getBuffer() != null) && (paramAnonymousString.Ifz != null) && (paramAnonymousString.Ifz.getBuffer() != null)) {
                          b.this.CsR.a(paramAnonymousString.Ifn.getBuffer().toByteArray(), paramAnonymousString.Ifm, paramAnonymousString.uXB, paramAnonymousString.Ifz.getBuffer().toByteArray());
                        }
                        b.this.CsR.j(paramAnonymousString.Ifq, paramAnonymousString.Ifr, paramAnonymousString.Ifs, paramAnonymousString.Ift, paramAnonymousString.Ifu);
                        b.this.CsR.UP(paramAnonymousString.Ify);
                        if ((paramAnonymousString.Ifw != null) && (paramAnonymousString.Ifx != null) && (paramAnonymousString.Ifw.getBuffer() != null) && (paramAnonymousString.Ifx.getBuffer() != null)) {
                          b.this.CsR.c(paramAnonymousString.Ifv, paramAnonymousString.Ifw.getBuffer().toByteArray(), paramAnonymousString.Ifx.getBuffer().toByteArray());
                        }
                        if (paramAnonymousString.Idm.FTj.getBuffer() == null) {
                          break label1109;
                        }
                        b.this.CsR.bT(paramAnonymousString.Idm.FTj.getBuffer().toByteArray());
                        b.this.CsR.UO(paramAnonymousString.IfB);
                        b.this.CsR.Csj.CxY = paramAnonymousString.IfC;
                        if ((paramAnonymousString.IfE != null) && (paramAnonymousString.IfE.getBuffer() != null)) {
                          b.this.CsR.Csj.CwR = paramAnonymousString.IfE.getBuffer().toByteArray();
                        }
                        if (!b.this.CsR.CrL) {
                          break label1205;
                        }
                        b.this.CsR.CrL = false;
                        if (b.this.CsR.CrH != true) {
                          break label1128;
                        }
                        com.tencent.mm.plugin.voip.b.f.Logi(b.this.TAG, "channel pre-connect already success, start talk");
                        ar.f(new Runnable()
                        {
                          public final void run()
                          {
                            AppMethodBeat.i(177027);
                            b.this.CsR.ezK();
                            AppMethodBeat.o(177027);
                          }
                        });
                        b.this.CsR.ezU();
                        b.this.CsR.ezS();
                        AppMethodBeat.o(115217);
                        return;
                        localException1 = localException1;
                        ae.e(b.this.TAG, "relay conn info to byte array fail..");
                        continue;
                        localException2 = localException2;
                        ae.e(b.this.TAG, "direct conn info to byte array fail..");
                      }
                    }
                    catch (Exception localException3)
                    {
                      for (;;)
                      {
                        ae.e(b.this.TAG, "nic query info to byte array fail..");
                        continue;
                        ae.e(b.this.TAG, "multiRelayData.PeerId.Buffer.getBuffer() is null");
                        continue;
                        label1109:
                        ae.e(b.this.TAG, "multiRelayData.CapInfo.Buffer.getBuffer() is null");
                        continue;
                        label1128:
                        if (b.this.CsR.CrK == true)
                        {
                          com.tencent.mm.plugin.voip.b.f.Logi(b.this.TAG, "channel pre-connect already failed");
                          b.this.CsR.J(1, -9000, "");
                          AppMethodBeat.o(115217);
                          return;
                        }
                        com.tencent.mm.plugin.voip.b.f.Logi(b.this.TAG, "channel pre-connect still connecting...");
                        continue;
                        label1205:
                        ae.i(b.this.TAG, "isPreConnect is false");
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
            ae.e(b.this.TAG, "get proxy ip fail..");
            AppMethodBeat.o(115218);
          }
          paramAnonymousString.uXB = 1;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.b
 * JD-Core Version:    0.7.0.1
 */