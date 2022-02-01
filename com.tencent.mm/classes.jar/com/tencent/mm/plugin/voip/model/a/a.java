package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.voip.c.e;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.protocal.protobuf.ahu;
import com.tencent.mm.protocal.protobuf.ahv;
import com.tencent.mm.protocal.protobuf.bys;
import com.tencent.mm.protocal.protobuf.dbt;
import com.tencent.mm.protocal.protobuf.dwc;
import com.tencent.mm.protocal.protobuf.dwd;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.fcz;
import com.tencent.mm.protocal.protobuf.fda;
import com.tencent.mm.protocal.protobuf.fep;
import com.tencent.mm.protocal.protobuf.fev;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.LinkedList;

public final class a
  extends n<fcz, fda>
{
  private String TAG;
  
  public a(int paramInt1, long paramLong, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString, LinkedList<dbt> paramLinkedList)
  {
    AppMethodBeat.i(115215);
    this.TAG = "MicroMsg.NetSceneVoipAck";
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new fcz();
    ((d.a)localObject).lBV = new fda();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/voipack";
    ((d.a)localObject).funcId = 305;
    ((d.a)localObject).lBW = 123;
    ((d.a)localObject).respCmdId = 1000000123;
    this.rr = ((d.a)localObject).bgN();
    localObject = (fcz)d.b.b(this.rr.lBR);
    ((fcz)localObject).Svu = paramInt1;
    ((fcz)localObject).Svv = paramLong;
    ((fcz)localObject).UCI = paramInt2;
    if (paramInt2 != 1)
    {
      ((fcz)localObject).UCE = 0;
      AppMethodBeat.o(115215);
      return;
    }
    ((fcz)localObject).UCH = paramString;
    paramString = new fev();
    paramString.rWu = 2;
    eae localeae = new eae();
    localeae.dc(paramArrayOfByte1);
    paramString.RNM = localeae;
    ((fcz)localObject).UCF = paramString;
    paramArrayOfByte1 = new fev();
    paramArrayOfByte1.rWu = 3;
    paramString = new eae();
    paramString.dc(paramArrayOfByte2);
    paramArrayOfByte1.RNM = paramString;
    ((fcz)localObject).UCG = paramArrayOfByte1;
    ((fcz)localObject).UCJ = System.currentTimeMillis();
    ((fcz)localObject).UCE = 1;
    paramInt1 = ((com.tencent.mm.plugin.misc.a.a)h.ae(com.tencent.mm.plugin.misc.a.a.class)).WE(2);
    Log.i(this.TAG, "simType: %s", new Object[] { Integer.valueOf(paramInt1) });
    if (paramInt1 == 0) {
      paramInt1 = 0;
    }
    for (;;)
    {
      ((fcz)localObject).UCK = paramInt1;
      ((fcz)localObject).UCL = paramLinkedList.size();
      ((fcz)localObject).UCM = paramLinkedList;
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
  
  public final i gAU()
  {
    AppMethodBeat.i(115216);
    i local1 = new i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, final q paramAnonymousq)
      {
        AppMethodBeat.i(115214);
        e.Logi(a.a(a.this), "ack response:" + paramAnonymousInt1 + " errCode:" + paramAnonymousInt2 + " status:" + a.this.NMN.mStatus);
        if (a.this.NMN.mStatus == 1)
        {
          e.Logi(a.a(a.this), "reject ok!");
          AppMethodBeat.o(115214);
          return;
        }
        if (a.this.NMN.mStatus != 3)
        {
          e.Loge(a.a(a.this), "ack response not within WAITCONNECT, ignored.");
          AppMethodBeat.o(115214);
          return;
        }
        if (paramAnonymousInt1 != 0)
        {
          if (paramAnonymousInt1 == 4)
          {
            a.this.NMN.NMi.NSI.NNq = 12;
            a.this.NMN.NMi.NSI.NNr = paramAnonymousInt2;
            a.this.NMN.J(1, paramAnonymousInt2, "");
            AppMethodBeat.o(115214);
            return;
          }
          a.this.NMN.NMi.NSI.NNq = 12;
          a.this.NMN.NMi.NSI.NNr = paramAnonymousInt2;
          a.this.NMN.J(1, -9004, "");
          AppMethodBeat.o(115214);
          return;
        }
        paramAnonymousString = (fda)a.this.gAY();
        if (paramAnonymousString.UCE != 1)
        {
          e.Logi(a.a(a.this), "onVoipAckResp: do not use preconnect");
          AppMethodBeat.o(115214);
          return;
        }
        a.this.NMN.NLK = true;
        a.this.NMN.NMi.NRv = 1;
        a.this.NMN.NMi.roomId = paramAnonymousString.Svu;
        a.this.NMN.NMi.DPJ = paramAnonymousString.Svv;
        a.this.NMN.NMi.DPQ = paramAnonymousString.UCN;
        a.this.NMN.NMi.NQR = paramAnonymousString.UCR;
        a.this.NMN.NMi.NQV = paramAnonymousString.UCS;
        a.this.NMN.akW(paramAnonymousString.UCP);
        e.Logi(a.a(a.this), "ack ok, roomid =" + a.this.NMN.NMi.roomId + ",memberid = " + a.this.NMN.NMi.DPQ);
        paramAnonymousq = paramAnonymousString.UCO;
        if (paramAnonymousq.DQe > 0)
        {
          paramAnonymousq.DQe -= 1;
          e.Logi(a.a(a.this), "zhengxue[ENCRYPT] got encryptStrategy[" + paramAnonymousq.DQe + "] from ackresp relaydata");
        }
        for (;;)
        {
          e.Logi(a.a(a.this), "ack with switchtcpcnt  =" + a.this.NMN.NMi.NQQ + " RedirectReqThreshold =" + paramAnonymousq.UEW + " BothSideSwitchFlag =" + paramAnonymousq.UEX + " WifiScanInterval =" + paramAnonymousString.UCS);
          a.this.NMN.NMi.NRY = paramAnonymousq.UEX;
          if ((paramAnonymousq.UEZ != null) && (paramAnonymousq.UEZ.Tkb != null)) {
            a.this.NMN.NMi.NQS = paramAnonymousq.UEZ.Tkb.toByteArray();
          }
          a.this.NMN.akV(paramAnonymousq.UEB);
          a.this.NMN.cy(paramAnonymousq.UCF.RNM.Tkb.toByteArray());
          a.this.NMN.gyS();
          a.this.NMN.gyT();
          if ((paramAnonymousq.UEI != null) && (paramAnonymousq.UEI.Tkb != null) && (paramAnonymousq.UEU != null) && (paramAnonymousq.UEU.Tkb != null)) {
            a.this.NMN.a(paramAnonymousq.UEI.Tkb.toByteArray(), paramAnonymousq.UEH, paramAnonymousq.DQe, paramAnonymousq.UEU.Tkb.toByteArray());
          }
          a.this.NMN.n(paramAnonymousq.UEL, paramAnonymousq.UEM, paramAnonymousq.UEN, paramAnonymousq.UEO, paramAnonymousq.UEP);
          a.this.NMN.cz(paramAnonymousq.UCG.RNM.Tkb.toByteArray());
          h.aHJ().postToWorker(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(115213);
              Object localObject;
              if ((paramAnonymousq.UEu == null) || (paramAnonymousq.UEu.Ucd == 0))
              {
                localObject = new dwc();
                ((dwc)localObject).Ssu = 0;
                ((dwc)localObject).Ssv = "";
                ((dwc)localObject).Ssw = "";
                ((dwc)localObject).Ssx = a.this.NMN.NMi.netType;
                ((dwc)localObject).Ssy = 4;
                ((dwc)localObject).Ssz = 2;
                ((dwc)localObject).Ucb = paramAnonymousq.UEC;
                ((dwc)localObject).Ucc = paramAnonymousq.UEK;
                paramAnonymousq.UEu = new dwd();
                paramAnonymousq.UEu.Ucd = 1;
                paramAnonymousq.UEu.Uce = new LinkedList();
                paramAnonymousq.UEu.Uce.add(localObject);
              }
              if ((paramAnonymousq.UEv == null) || (paramAnonymousq.UEv.SsF == 0))
              {
                localObject = new ahu();
                ((ahu)localObject).Ssu = 1;
                ((ahu)localObject).Ssv = "";
                ((ahu)localObject).Ssw = "";
                ((ahu)localObject).Ssx = a.this.NMN.NMi.netType;
                ((ahu)localObject).Ssy = 4;
                ((ahu)localObject).Ssz = 2;
                ((ahu)localObject).SsA = paramAnonymousq.UED;
                ((ahu)localObject).SsB = paramAnonymousq.UFc;
                ((ahu)localObject).SsC = paramAnonymousq.UFd;
                paramAnonymousq.UEv = new ahv();
                paramAnonymousq.UEv.SsF = 1;
                paramAnonymousq.UEv.SsG = new LinkedList();
                paramAnonymousq.UEv.SsG.add(localObject);
              }
              e.Logi(a.a(a.this), "relay conn cnt: " + paramAnonymousq.UEu.Ucd);
              try
              {
                a.this.NMN.NMi.NSl = paramAnonymousq.UEu.toByteArray();
              }
              catch (Exception localException2)
              {
                try
                {
                  a.this.NMN.NMi.NSm = paramAnonymousq.UEv.toByteArray();
                }
                catch (Exception localException2)
                {
                  try
                  {
                    for (;;)
                    {
                      if (paramAnonymousq.UFe.ThN > 0) {
                        a.this.NMN.NMi.NSn = paramAnonymousq.UFe.toByteArray();
                      }
                      a.this.NMN.akU(paramAnonymousq.UET);
                      a.this.NMN.akT(paramAnonymousq.UEW);
                      if ((paramAnonymousq.UER != null) && (paramAnonymousq.UES != null)) {
                        a.this.NMN.c(paramAnonymousq.UEQ, paramAnonymousq.UER.Tkb.toByteArray(), paramAnonymousq.UES.Tkb.toByteArray());
                      }
                      e.Logi(a.a(a.this), "ack success, try connect channel");
                      a.this.NMN.gyW();
                      AppMethodBeat.o(115213);
                      return;
                      localException1 = localException1;
                      Log.e(a.a(a.this), "relay conn info to byte array fail..");
                      continue;
                      localException2 = localException2;
                      Log.e(a.a(a.this), "direct conn info to byte array fail..");
                    }
                  }
                  catch (Exception localException3)
                  {
                    for (;;)
                    {
                      Log.e(a.a(a.this), "nic query info to byte array fail..");
                    }
                  }
                }
              }
            }
          });
          AppMethodBeat.o(115214);
          return;
          paramAnonymousq.DQe = 1;
          e.Logi(a.a(a.this), "zhengxue[LOGIC]:got no EncryptStrategy in ackresp mrdata");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.a
 * JD-Core Version:    0.7.0.1
 */