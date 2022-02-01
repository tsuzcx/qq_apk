package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.aeu;
import com.tencent.mm.protocal.protobuf.aev;
import com.tencent.mm.protocal.protobuf.bem;
import com.tencent.mm.protocal.protobuf.cbv;
import com.tencent.mm.protocal.protobuf.ctb;
import com.tencent.mm.protocal.protobuf.ctc;
import com.tencent.mm.protocal.protobuf.dwq;
import com.tencent.mm.protocal.protobuf.dwr;
import com.tencent.mm.protocal.protobuf.dyg;
import com.tencent.mm.protocal.protobuf.dym;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import java.util.LinkedList;

public final class a
  extends n<dwq, dwr>
{
  String TAG;
  
  public a(int paramInt1, long paramLong, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString, LinkedList<cbv> paramLinkedList)
  {
    AppMethodBeat.i(115215);
    this.TAG = "MicroMsg.NetSceneVoipAck";
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new dwq();
    ((b.a)localObject).hNN = new dwr();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/voipack";
    ((b.a)localObject).funcId = 305;
    ((b.a)localObject).hNO = 123;
    ((b.a)localObject).respCmdId = 1000000123;
    this.rr = ((b.a)localObject).aDC();
    localObject = (dwq)this.rr.hNK.hNQ;
    ((dwq)localObject).GeI = paramInt1;
    ((dwq)localObject).GeJ = paramLong;
    ((dwq)localObject).HJg = paramInt2;
    if (paramInt2 != 1)
    {
      ((dwq)localObject).HJc = 0;
      AppMethodBeat.o(115215);
      return;
    }
    ((dwq)localObject).HJf = paramString;
    paramString = new dym();
    paramString.nEf = 2;
    SKBuiltinBuffer_t localSKBuiltinBuffer_t = new SKBuiltinBuffer_t();
    localSKBuiltinBuffer_t.setBuffer(paramArrayOfByte1);
    paramString.FAN = localSKBuiltinBuffer_t;
    ((dwq)localObject).HJd = paramString;
    paramArrayOfByte1 = new dym();
    paramArrayOfByte1.nEf = 3;
    paramString = new SKBuiltinBuffer_t();
    paramString.setBuffer(paramArrayOfByte2);
    paramArrayOfByte1.FAN = paramString;
    ((dwq)localObject).HJe = paramArrayOfByte1;
    ((dwq)localObject).HJh = System.currentTimeMillis();
    ((dwq)localObject).HJc = 1;
    paramInt1 = ((com.tencent.mm.plugin.misc.a.a)g.ab(com.tencent.mm.plugin.misc.a.a.class)).JP(2);
    ad.i(this.TAG, "simType: %s", new Object[] { Integer.valueOf(paramInt1) });
    if (paramInt1 == 0) {
      paramInt1 = 0;
    }
    for (;;)
    {
      ((dwq)localObject).HJi = paramInt1;
      ((dwq)localObject).HJj = paramLinkedList.size();
      ((dwq)localObject).HJk = paramLinkedList;
      AppMethodBeat.o(115215);
      return;
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
    AppMethodBeat.i(115216);
    com.tencent.mm.al.f local1 = new com.tencent.mm.al.f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, final com.tencent.mm.al.n paramAnonymousn)
      {
        AppMethodBeat.i(115214);
        com.tencent.mm.plugin.voip.b.f.Logi(a.this.TAG, "ack response:" + paramAnonymousInt1 + " errCode:" + paramAnonymousInt2 + " status:" + a.this.Cbq.mStatus);
        if (a.this.Cbq.mStatus == 1)
        {
          com.tencent.mm.plugin.voip.b.f.Logi(a.this.TAG, "reject ok!");
          AppMethodBeat.o(115214);
          return;
        }
        if (a.this.Cbq.mStatus != 3)
        {
          com.tencent.mm.plugin.voip.b.f.Loge(a.this.TAG, "ack response not within WAITCONNECT, ignored.");
          AppMethodBeat.o(115214);
          return;
        }
        if (paramAnonymousInt1 != 0)
        {
          if (paramAnonymousInt1 == 4)
          {
            a.this.Cbq.CaI.Chg.CbS = 12;
            a.this.Cbq.CaI.Chg.CbT = paramAnonymousInt2;
            a.this.Cbq.J(1, paramAnonymousInt2, "");
            AppMethodBeat.o(115214);
            return;
          }
          a.this.Cbq.CaI.Chg.CbS = 12;
          a.this.Cbq.CaI.Chg.CbT = paramAnonymousInt2;
          a.this.Cbq.J(1, -9004, "");
          AppMethodBeat.o(115214);
          return;
        }
        paramAnonymousString = (dwr)a.this.eyh();
        if (paramAnonymousString.HJc != 1)
        {
          com.tencent.mm.plugin.voip.b.f.Logi(a.this.TAG, "onVoipAckResp: do not use preconnect");
          AppMethodBeat.o(115214);
          return;
        }
        a.this.Cbq.Cak = true;
        a.this.Cbq.CaI.CfU = 1;
        a.this.Cbq.CaI.roomId = paramAnonymousString.GeI;
        a.this.Cbq.CaI.uLt = paramAnonymousString.GeJ;
        a.this.Cbq.CaI.uLA = paramAnonymousString.HJl;
        a.this.Cbq.CaI.Cfp = paramAnonymousString.HJp;
        a.this.Cbq.CaI.Cft = paramAnonymousString.HJq;
        a.this.Cbq.Uk(paramAnonymousString.HJn);
        com.tencent.mm.plugin.voip.b.f.Logi(a.this.TAG, "ack ok, roomid =" + a.this.Cbq.CaI.roomId + ",memberid = " + a.this.Cbq.CaI.uLA);
        paramAnonymousn = paramAnonymousString.HJm;
        if (paramAnonymousn.uLO > 0)
        {
          paramAnonymousn.uLO -= 1;
          com.tencent.mm.plugin.voip.b.f.Logi(a.this.TAG, "zhengxue[ENCRYPT] got encryptStrategy[" + paramAnonymousn.uLO + "] from ackresp relaydata");
        }
        for (;;)
        {
          com.tencent.mm.plugin.voip.b.f.Logi(a.this.TAG, "ack with switchtcpcnt  =" + a.this.Cbq.CaI.Cfo + " RedirectReqThreshold =" + paramAnonymousn.HLt + " BothSideSwitchFlag =" + paramAnonymousn.HLu + " WifiScanInterval =" + paramAnonymousString.HJq);
          a.this.Cbq.CaI.Cgx = paramAnonymousn.HLu;
          if ((paramAnonymousn.HLw != null) && (paramAnonymousn.HLw.getBuffer() != null)) {
            a.this.Cbq.CaI.Cfq = paramAnonymousn.HLw.getBuffer().toByteArray();
          }
          a.this.Cbq.Uj(paramAnonymousn.HKY);
          a.this.Cbq.bP(paramAnonymousn.HJd.FAN.getBuffer().toByteArray());
          a.this.Cbq.ewi();
          if ((paramAnonymousn.HLf != null) && (paramAnonymousn.HLf.getBuffer() != null) && (paramAnonymousn.HLr != null) && (paramAnonymousn.HLr.getBuffer() != null)) {
            a.this.Cbq.a(paramAnonymousn.HLf.getBuffer().toByteArray(), paramAnonymousn.HLe, paramAnonymousn.uLO, paramAnonymousn.HLr.getBuffer().toByteArray());
          }
          a.this.Cbq.j(paramAnonymousn.HLi, paramAnonymousn.HLj, paramAnonymousn.HLk, paramAnonymousn.HLl, paramAnonymousn.HLm);
          a.this.Cbq.bQ(paramAnonymousn.HJe.FAN.getBuffer().toByteArray());
          g.ajF().ay(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(115213);
              Object localObject;
              if ((paramAnonymousn.HKR == null) || (paramAnonymousn.HKR.Hlr == 0))
              {
                localObject = new ctb();
                ((ctb)localObject).GcK = 0;
                ((ctb)localObject).GcL = "";
                ((ctb)localObject).GcM = "";
                ((ctb)localObject).GcN = a.this.Cbq.CaI.netType;
                ((ctb)localObject).GcO = 4;
                ((ctb)localObject).GcP = 2;
                ((ctb)localObject).Hlp = paramAnonymousn.HKZ;
                ((ctb)localObject).Hlq = paramAnonymousn.HLh;
                paramAnonymousn.HKR = new ctc();
                paramAnonymousn.HKR.Hlr = 1;
                paramAnonymousn.HKR.Hls = new LinkedList();
                paramAnonymousn.HKR.Hls.add(localObject);
              }
              if ((paramAnonymousn.HKS == null) || (paramAnonymousn.HKS.GcV == 0))
              {
                localObject = new aeu();
                ((aeu)localObject).GcK = 1;
                ((aeu)localObject).GcL = "";
                ((aeu)localObject).GcM = "";
                ((aeu)localObject).GcN = a.this.Cbq.CaI.netType;
                ((aeu)localObject).GcO = 4;
                ((aeu)localObject).GcP = 2;
                ((aeu)localObject).GcQ = paramAnonymousn.HLa;
                ((aeu)localObject).GcR = paramAnonymousn.HLz;
                ((aeu)localObject).GcS = paramAnonymousn.HLA;
                paramAnonymousn.HKS = new aev();
                paramAnonymousn.HKS.GcV = 1;
                paramAnonymousn.HKS.GcW = new LinkedList();
                paramAnonymousn.HKS.GcW.add(localObject);
              }
              com.tencent.mm.plugin.voip.b.f.Logi(a.this.TAG, "relay conn cnt: " + paramAnonymousn.HKR.Hlr);
              try
              {
                a.this.Cbq.CaI.CgJ = paramAnonymousn.HKR.toByteArray();
              }
              catch (Exception localException2)
              {
                try
                {
                  a.this.Cbq.CaI.CgK = paramAnonymousn.HKS.toByteArray();
                }
                catch (Exception localException2)
                {
                  try
                  {
                    for (;;)
                    {
                      if (paramAnonymousn.HLB.GAE > 0) {
                        a.this.Cbq.CaI.CgL = paramAnonymousn.HLB.toByteArray();
                      }
                      a.this.Cbq.Ui(paramAnonymousn.HLq);
                      a.this.Cbq.Uh(paramAnonymousn.HLt);
                      if ((paramAnonymousn.HLo != null) && (paramAnonymousn.HLp != null)) {
                        a.this.Cbq.c(paramAnonymousn.HLn, paramAnonymousn.HLo.getBuffer().toByteArray(), paramAnonymousn.HLp.getBuffer().toByteArray());
                      }
                      com.tencent.mm.plugin.voip.b.f.Logi(a.this.TAG, "ack success, try connect channel");
                      a.this.Cbq.ewl();
                      AppMethodBeat.o(115213);
                      return;
                      localException1 = localException1;
                      ad.e(a.this.TAG, "relay conn info to byte array fail..");
                      continue;
                      localException2 = localException2;
                      ad.e(a.this.TAG, "direct conn info to byte array fail..");
                    }
                  }
                  catch (Exception localException3)
                  {
                    for (;;)
                    {
                      ad.e(a.this.TAG, "nic query info to byte array fail..");
                    }
                  }
                }
              }
            }
          });
          AppMethodBeat.o(115214);
          return;
          paramAnonymousn.uLO = 1;
          com.tencent.mm.plugin.voip.b.f.Logi(a.this.TAG, "zhengxue[LOGIC]:got no EncryptStrategy in ackresp mrdata");
        }
      }
    };
    AppMethodBeat.o(115216);
    return local1;
  }
  
  public final int getType()
  {
    return 305;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.a
 * JD-Core Version:    0.7.0.1
 */