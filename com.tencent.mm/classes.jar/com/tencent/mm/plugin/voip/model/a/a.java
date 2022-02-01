package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.plugin.voip.b.d;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.act;
import com.tencent.mm.protocal.protobuf.acu;
import com.tencent.mm.protocal.protobuf.bai;
import com.tencent.mm.protocal.protobuf.bxf;
import com.tencent.mm.protocal.protobuf.cny;
import com.tencent.mm.protocal.protobuf.cnz;
import com.tencent.mm.protocal.protobuf.dqw;
import com.tencent.mm.protocal.protobuf.dqx;
import com.tencent.mm.protocal.protobuf.dsm;
import com.tencent.mm.protocal.protobuf.dss;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.LinkedList;

public final class a
  extends n<dqw, dqx>
{
  String TAG;
  
  public a(int paramInt1, long paramLong, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString, LinkedList<bxf> paramLinkedList)
  {
    AppMethodBeat.i(115215);
    this.TAG = "MicroMsg.NetSceneVoipAck";
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new dqw();
    ((b.a)localObject).hvu = new dqx();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/voipack";
    ((b.a)localObject).funcId = 305;
    ((b.a)localObject).reqCmdId = 123;
    ((b.a)localObject).respCmdId = 1000000123;
    this.rr = ((b.a)localObject).aAz();
    localObject = (dqw)this.rr.hvr.hvw;
    ((dqw)localObject).Exf = paramInt1;
    ((dqw)localObject).Exg = paramLong;
    ((dqw)localObject).FYk = paramInt2;
    if (paramInt2 != 1)
    {
      ((dqw)localObject).FYg = 0;
      AppMethodBeat.o(115215);
      return;
    }
    ((dqw)localObject).FYj = paramString;
    paramString = new dss();
    paramString.ndI = 2;
    SKBuiltinBuffer_t localSKBuiltinBuffer_t = new SKBuiltinBuffer_t();
    localSKBuiltinBuffer_t.setBuffer(paramArrayOfByte1);
    paramString.DVs = localSKBuiltinBuffer_t;
    ((dqw)localObject).FYh = paramString;
    paramArrayOfByte1 = new dss();
    paramArrayOfByte1.ndI = 3;
    paramString = new SKBuiltinBuffer_t();
    paramString.setBuffer(paramArrayOfByte2);
    paramArrayOfByte1.DVs = paramString;
    ((dqw)localObject).FYi = paramArrayOfByte1;
    ((dqw)localObject).FYl = System.currentTimeMillis();
    ((dqw)localObject).FYg = 1;
    paramInt1 = ((com.tencent.mm.plugin.misc.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.misc.a.a.class)).Is(2);
    ac.i(this.TAG, "simType: %s", new Object[] { Integer.valueOf(paramInt1) });
    if (paramInt1 == 0) {
      paramInt1 = 0;
    }
    for (;;)
    {
      ((dqw)localObject).FYm = paramInt1;
      ((dqw)localObject).FYn = paramLinkedList.size();
      ((dqw)localObject).FYo = paramLinkedList;
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
  
  public final com.tencent.mm.ak.g eks()
  {
    AppMethodBeat.i(115216);
    com.tencent.mm.ak.g local1 = new com.tencent.mm.ak.g()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, final com.tencent.mm.ak.n paramAnonymousn)
      {
        AppMethodBeat.i(115214);
        d.Logi(a.this.TAG, "ack response:" + paramAnonymousInt1 + " errCode:" + paramAnonymousInt2 + " status:" + a.this.ACr.mStatus);
        if (a.this.ACr.mStatus == 1)
        {
          d.Logi(a.this.TAG, "reject ok!");
          AppMethodBeat.o(115214);
          return;
        }
        if (a.this.ACr.mStatus != 3)
        {
          d.Loge(a.this.TAG, "ack response not within WAITCONNECT, ignored.");
          AppMethodBeat.o(115214);
          return;
        }
        if (paramAnonymousInt1 != 0)
        {
          if (paramAnonymousInt1 == 4)
          {
            a.this.ACr.ABJ.AIf.ACR = 12;
            a.this.ACr.ABJ.AIf.ACS = paramAnonymousInt2;
            a.this.ACr.H(1, paramAnonymousInt2, "");
            AppMethodBeat.o(115214);
            return;
          }
          a.this.ACr.ABJ.AIf.ACR = 12;
          a.this.ACr.ABJ.AIf.ACS = paramAnonymousInt2;
          a.this.ACr.H(1, -9004, "");
          AppMethodBeat.o(115214);
          return;
        }
        paramAnonymousString = (dqx)a.this.ekw();
        if (paramAnonymousString.FYg != 1)
        {
          d.Logi(a.this.TAG, "onVoipAckResp: do not use preconnect");
          AppMethodBeat.o(115214);
          return;
        }
        a.this.ACr.ABl = true;
        a.this.ACr.ABJ.AGT = 1;
        a.this.ACr.ABJ.roomId = paramAnonymousString.Exf;
        a.this.ACr.ABJ.tIG = paramAnonymousString.Exg;
        a.this.ACr.ABJ.tIN = paramAnonymousString.FYp;
        a.this.ACr.ABJ.AGp = paramAnonymousString.FYt;
        a.this.ACr.ABJ.AGt = paramAnonymousString.FYu;
        a.this.ACr.Ss(paramAnonymousString.FYr);
        d.Logi(a.this.TAG, "ack ok, roomid =" + a.this.ACr.ABJ.roomId + ",memberid = " + a.this.ACr.ABJ.tIN);
        paramAnonymousn = paramAnonymousString.FYq;
        if (paramAnonymousn.tJb > 0)
        {
          paramAnonymousn.tJb -= 1;
          d.Logi(a.this.TAG, "zhengxue[ENCRYPT] got encryptStrategy[" + paramAnonymousn.tJb + "] from ackresp relaydata");
        }
        for (;;)
        {
          d.Logi(a.this.TAG, "ack with switchtcpcnt  =" + a.this.ACr.ABJ.AGo + " RedirectReqThreshold =" + paramAnonymousn.Gax + " BothSideSwitchFlag =" + paramAnonymousn.Gay + " WifiScanInterval =" + paramAnonymousString.FYu);
          a.this.ACr.ABJ.AHw = paramAnonymousn.Gay;
          if ((paramAnonymousn.GaA != null) && (paramAnonymousn.GaA.getBuffer() != null)) {
            a.this.ACr.ABJ.AGq = paramAnonymousn.GaA.getBuffer().toByteArray();
          }
          a.this.ACr.Sr(paramAnonymousn.Gac);
          a.this.ACr.bI(paramAnonymousn.FYh.DVs.getBuffer().toByteArray());
          a.this.ACr.eix();
          if ((paramAnonymousn.Gaj != null) && (paramAnonymousn.Gaj.getBuffer() != null) && (paramAnonymousn.Gav != null) && (paramAnonymousn.Gav.getBuffer() != null)) {
            a.this.ACr.a(paramAnonymousn.Gaj.getBuffer().toByteArray(), paramAnonymousn.Gai, paramAnonymousn.tJb, paramAnonymousn.Gav.getBuffer().toByteArray());
          }
          a.this.ACr.i(paramAnonymousn.Gam, paramAnonymousn.Gan, paramAnonymousn.Gao, paramAnonymousn.Gap, paramAnonymousn.Gaq);
          a.this.ACr.bJ(paramAnonymousn.FYi.DVs.getBuffer().toByteArray());
          com.tencent.mm.kernel.g.agU().az(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(115213);
              Object localObject;
              if ((paramAnonymousn.FZV == null) || (paramAnonymousn.FZV.FBe == 0))
              {
                localObject = new cny();
                ((cny)localObject).Evo = 0;
                ((cny)localObject).Evp = "";
                ((cny)localObject).Evq = "";
                ((cny)localObject).Evr = a.this.ACr.ABJ.netType;
                ((cny)localObject).Evs = 4;
                ((cny)localObject).Evt = 2;
                ((cny)localObject).FBc = paramAnonymousn.Gad;
                ((cny)localObject).FBd = paramAnonymousn.Gal;
                paramAnonymousn.FZV = new cnz();
                paramAnonymousn.FZV.FBe = 1;
                paramAnonymousn.FZV.FBf = new LinkedList();
                paramAnonymousn.FZV.FBf.add(localObject);
              }
              if ((paramAnonymousn.FZW == null) || (paramAnonymousn.FZW.Evz == 0))
              {
                localObject = new act();
                ((act)localObject).Evo = 1;
                ((act)localObject).Evp = "";
                ((act)localObject).Evq = "";
                ((act)localObject).Evr = a.this.ACr.ABJ.netType;
                ((act)localObject).Evs = 4;
                ((act)localObject).Evt = 2;
                ((act)localObject).Evu = paramAnonymousn.Gae;
                ((act)localObject).Evv = paramAnonymousn.GaD;
                ((act)localObject).Evw = paramAnonymousn.GaE;
                paramAnonymousn.FZW = new acu();
                paramAnonymousn.FZW.Evz = 1;
                paramAnonymousn.FZW.EvA = new LinkedList();
                paramAnonymousn.FZW.EvA.add(localObject);
              }
              d.Logi(a.this.TAG, "relay conn cnt: " + paramAnonymousn.FZV.FBe);
              try
              {
                a.this.ACr.ABJ.AHI = paramAnonymousn.FZV.toByteArray();
              }
              catch (Exception localException2)
              {
                try
                {
                  a.this.ACr.ABJ.AHJ = paramAnonymousn.FZW.toByteArray();
                }
                catch (Exception localException2)
                {
                  try
                  {
                    for (;;)
                    {
                      if (paramAnonymousn.GaF.ERm > 0) {
                        a.this.ACr.ABJ.AHK = paramAnonymousn.GaF.toByteArray();
                      }
                      a.this.ACr.Sq(paramAnonymousn.Gau);
                      a.this.ACr.Sp(paramAnonymousn.Gax);
                      if ((paramAnonymousn.Gas != null) && (paramAnonymousn.Gat != null)) {
                        a.this.ACr.c(paramAnonymousn.Gar, paramAnonymousn.Gas.getBuffer().toByteArray(), paramAnonymousn.Gat.getBuffer().toByteArray());
                      }
                      d.Logi(a.this.TAG, "ack success, try connect channel");
                      a.this.ACr.eiA();
                      AppMethodBeat.o(115213);
                      return;
                      localException1 = localException1;
                      ac.e(a.this.TAG, "relay conn info to byte array fail..");
                      continue;
                      localException2 = localException2;
                      ac.e(a.this.TAG, "direct conn info to byte array fail..");
                    }
                  }
                  catch (Exception localException3)
                  {
                    for (;;)
                    {
                      ac.e(a.this.TAG, "nic query info to byte array fail..");
                    }
                  }
                }
              }
            }
          });
          AppMethodBeat.o(115214);
          return;
          paramAnonymousn.tJb = 1;
          d.Logi(a.this.TAG, "zhengxue[LOGIC]:got no EncryptStrategy in ackresp mrdata");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.a
 * JD-Core Version:    0.7.0.1
 */