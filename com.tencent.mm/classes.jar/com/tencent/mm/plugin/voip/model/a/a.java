package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.plugin.voip.b.c;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.abu;
import com.tencent.mm.protocal.protobuf.abv;
import com.tencent.mm.protocal.protobuf.awq;
import com.tencent.mm.protocal.protobuf.bso;
import com.tencent.mm.protocal.protobuf.cir;
import com.tencent.mm.protocal.protobuf.cis;
import com.tencent.mm.protocal.protobuf.dlf;
import com.tencent.mm.protocal.protobuf.dlg;
import com.tencent.mm.protocal.protobuf.dmv;
import com.tencent.mm.protocal.protobuf.dnb;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import java.util.LinkedList;

public final class a
  extends n<dlf, dlg>
{
  String TAG;
  
  public a(int paramInt1, long paramLong, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString, LinkedList<bso> paramLinkedList)
  {
    AppMethodBeat.i(115215);
    this.TAG = "MicroMsg.NetSceneVoipAck";
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new dlf();
    ((b.a)localObject).gUV = new dlg();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/voipack";
    ((b.a)localObject).funcId = 305;
    ((b.a)localObject).reqCmdId = 123;
    ((b.a)localObject).respCmdId = 1000000123;
    this.rr = ((b.a)localObject).atI();
    localObject = (dlf)this.rr.gUS.gUX;
    ((dlf)localObject).DdZ = paramInt1;
    ((dlf)localObject).Dea = paramLong;
    ((dlf)localObject).EAX = paramInt2;
    if (paramInt2 != 1)
    {
      ((dlf)localObject).EAT = 0;
      AppMethodBeat.o(115215);
      return;
    }
    ((dlf)localObject).EAW = paramString;
    paramString = new dnb();
    paramString.mBH = 2;
    SKBuiltinBuffer_t localSKBuiltinBuffer_t = new SKBuiltinBuffer_t();
    localSKBuiltinBuffer_t.setBuffer(paramArrayOfByte1);
    paramString.CCV = localSKBuiltinBuffer_t;
    ((dlf)localObject).EAU = paramString;
    paramArrayOfByte1 = new dnb();
    paramArrayOfByte1.mBH = 3;
    paramString = new SKBuiltinBuffer_t();
    paramString.setBuffer(paramArrayOfByte2);
    paramArrayOfByte1.CCV = paramString;
    ((dlf)localObject).EAV = paramArrayOfByte1;
    ((dlf)localObject).EAY = System.currentTimeMillis();
    ((dlf)localObject).EAT = 1;
    paramInt1 = ((com.tencent.mm.plugin.misc.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.misc.a.a.class)).Gw(2);
    ad.i(this.TAG, "simType: %s", new Object[] { Integer.valueOf(paramInt1) });
    if (paramInt1 == 0) {
      paramInt1 = 0;
    }
    for (;;)
    {
      ((dlf)localObject).EAZ = paramInt1;
      ((dlf)localObject).EBa = paramLinkedList.size();
      ((dlf)localObject).EBb = paramLinkedList;
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
  
  public final com.tencent.mm.al.g dVg()
  {
    AppMethodBeat.i(115216);
    com.tencent.mm.al.g local1 = new com.tencent.mm.al.g()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, final com.tencent.mm.al.n paramAnonymousn)
      {
        AppMethodBeat.i(115214);
        c.Logi(a.this.TAG, "ack response:" + paramAnonymousInt1 + " errCode:" + paramAnonymousInt2 + " status:" + a.this.zjH.mStatus);
        if (a.this.zjH.mStatus == 1)
        {
          c.Logi(a.this.TAG, "reject ok!");
          AppMethodBeat.o(115214);
          return;
        }
        if (a.this.zjH.mStatus != 3)
        {
          c.Loge(a.this.TAG, "ack response not within WAITCONNECT, ignored.");
          AppMethodBeat.o(115214);
          return;
        }
        if (paramAnonymousInt1 != 0)
        {
          if (paramAnonymousInt1 == 4)
          {
            a.this.zjH.ziZ.zpq.zkh = 12;
            a.this.zjH.ziZ.zpq.zki = paramAnonymousInt2;
            a.this.zjH.I(1, paramAnonymousInt2, "");
            AppMethodBeat.o(115214);
            return;
          }
          a.this.zjH.ziZ.zpq.zkh = 12;
          a.this.zjH.ziZ.zpq.zki = paramAnonymousInt2;
          a.this.zjH.I(1, -9004, "");
          AppMethodBeat.o(115214);
          return;
        }
        paramAnonymousString = (dlg)a.this.dVk();
        if (paramAnonymousString.EAT != 1)
        {
          c.Logi(a.this.TAG, "onVoipAckResp: do not use preconnect");
          AppMethodBeat.o(115214);
          return;
        }
        a.this.zjH.ziB = true;
        a.this.zjH.ziZ.zoe = 1;
        a.this.zjH.ziZ.roomId = paramAnonymousString.DdZ;
        a.this.zjH.ziZ.sAY = paramAnonymousString.Dea;
        a.this.zjH.ziZ.sBf = paramAnonymousString.EBc;
        a.this.zjH.ziZ.znB = paramAnonymousString.EBg;
        a.this.zjH.ziZ.znF = paramAnonymousString.EBh;
        a.this.zjH.Qj(paramAnonymousString.EBe);
        c.Logi(a.this.TAG, "ack ok, roomid =" + a.this.zjH.ziZ.roomId + ",memberid = " + a.this.zjH.ziZ.sBf);
        paramAnonymousn = paramAnonymousString.EBd;
        if (paramAnonymousn.sBt > 0)
        {
          paramAnonymousn.sBt -= 1;
          c.Logi(a.this.TAG, "zhengxue[ENCRYPT] got encryptStrategy[" + paramAnonymousn.sBt + "] from ackresp relaydata");
        }
        for (;;)
        {
          c.Logi(a.this.TAG, "ack with switchtcpcnt  =" + a.this.zjH.ziZ.znA + " RedirectReqThreshold =" + paramAnonymousn.EDk + " BothSideSwitchFlag =" + paramAnonymousn.EDl + " WifiScanInterval =" + paramAnonymousString.EBh);
          a.this.zjH.ziZ.zoH = paramAnonymousn.EDl;
          if ((paramAnonymousn.EDn != null) && (paramAnonymousn.EDn.getBuffer() != null)) {
            a.this.zjH.ziZ.znC = paramAnonymousn.EDn.getBuffer().toByteArray();
          }
          a.this.zjH.Qi(paramAnonymousn.ECP);
          a.this.zjH.bJ(paramAnonymousn.EAU.CCV.getBuffer().toByteArray());
          a.this.zjH.dTl();
          if ((paramAnonymousn.ECW != null) && (paramAnonymousn.ECW.getBuffer() != null) && (paramAnonymousn.EDi != null) && (paramAnonymousn.EDi.getBuffer() != null)) {
            a.this.zjH.a(paramAnonymousn.ECW.getBuffer().toByteArray(), paramAnonymousn.ECV, paramAnonymousn.sBt, paramAnonymousn.EDi.getBuffer().toByteArray());
          }
          a.this.zjH.i(paramAnonymousn.ECZ, paramAnonymousn.EDa, paramAnonymousn.EDb, paramAnonymousn.EDc, paramAnonymousn.EDd);
          a.this.zjH.bK(paramAnonymousn.EAV.CCV.getBuffer().toByteArray());
          com.tencent.mm.kernel.g.afE().ax(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(115213);
              Object localObject;
              if ((paramAnonymousn.ECI == null) || (paramAnonymousn.ECI.Eee == 0))
              {
                localObject = new cir();
                ((cir)localObject).Dch = 0;
                ((cir)localObject).Dci = "";
                ((cir)localObject).Dcj = "";
                ((cir)localObject).Dck = a.this.zjH.ziZ.netType;
                ((cir)localObject).Dcl = 4;
                ((cir)localObject).Dcm = 2;
                ((cir)localObject).Eec = paramAnonymousn.ECQ;
                ((cir)localObject).Eed = paramAnonymousn.ECY;
                paramAnonymousn.ECI = new cis();
                paramAnonymousn.ECI.Eee = 1;
                paramAnonymousn.ECI.Eef = new LinkedList();
                paramAnonymousn.ECI.Eef.add(localObject);
              }
              if ((paramAnonymousn.ECJ == null) || (paramAnonymousn.ECJ.Dcs == 0))
              {
                localObject = new abu();
                ((abu)localObject).Dch = 1;
                ((abu)localObject).Dci = "";
                ((abu)localObject).Dcj = "";
                ((abu)localObject).Dck = a.this.zjH.ziZ.netType;
                ((abu)localObject).Dcl = 4;
                ((abu)localObject).Dcm = 2;
                ((abu)localObject).Dcn = paramAnonymousn.ECR;
                ((abu)localObject).Dco = paramAnonymousn.EDq;
                ((abu)localObject).Dcp = paramAnonymousn.EDr;
                paramAnonymousn.ECJ = new abv();
                paramAnonymousn.ECJ.Dcs = 1;
                paramAnonymousn.ECJ.Dct = new LinkedList();
                paramAnonymousn.ECJ.Dct.add(localObject);
              }
              c.Logi(a.this.TAG, "relay conn cnt: " + paramAnonymousn.ECI.Eee);
              try
              {
                a.this.zjH.ziZ.zoT = paramAnonymousn.ECI.toByteArray();
              }
              catch (Exception localException2)
              {
                try
                {
                  a.this.zjH.ziZ.zoU = paramAnonymousn.ECJ.toByteArray();
                }
                catch (Exception localException2)
                {
                  try
                  {
                    for (;;)
                    {
                      if (paramAnonymousn.EDs.DvR > 0) {
                        a.this.zjH.ziZ.zoV = paramAnonymousn.EDs.toByteArray();
                      }
                      a.this.zjH.Qh(paramAnonymousn.EDh);
                      a.this.zjH.Qg(paramAnonymousn.EDk);
                      if ((paramAnonymousn.EDf != null) && (paramAnonymousn.EDg != null)) {
                        a.this.zjH.c(paramAnonymousn.EDe, paramAnonymousn.EDf.getBuffer().toByteArray(), paramAnonymousn.EDg.getBuffer().toByteArray());
                      }
                      c.Logi(a.this.TAG, "ack success, try connect channel");
                      a.this.zjH.dTo();
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
          paramAnonymousn.sBt = 1;
          c.Logi(a.this.TAG, "zhengxue[LOGIC]:got no EncryptStrategy in ackresp mrdata");
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