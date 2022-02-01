package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.voip.b.e;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.ahj;
import com.tencent.mm.protocal.protobuf.ahk;
import com.tencent.mm.protocal.protobuf.bqy;
import com.tencent.mm.protocal.protobuf.csu;
import com.tencent.mm.protocal.protobuf.dml;
import com.tencent.mm.protocal.protobuf.dmm;
import com.tencent.mm.protocal.protobuf.eso;
import com.tencent.mm.protocal.protobuf.esp;
import com.tencent.mm.protocal.protobuf.eue;
import com.tencent.mm.protocal.protobuf.euk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.LinkedList;

public final class a
  extends n<eso, esp>
{
  String TAG;
  
  public a(int paramInt1, long paramLong, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString, LinkedList<csu> paramLinkedList)
  {
    AppMethodBeat.i(115215);
    this.TAG = "MicroMsg.NetSceneVoipAck";
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new eso();
    ((d.a)localObject).iLO = new esp();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/voipack";
    ((d.a)localObject).funcId = 305;
    ((d.a)localObject).iLP = 123;
    ((d.a)localObject).respCmdId = 1000000123;
    this.rr = ((d.a)localObject).aXF();
    localObject = (eso)this.rr.iLK.iLR;
    ((eso)localObject).LsZ = paramInt1;
    ((eso)localObject).Lta = paramLong;
    ((eso)localObject).NpM = paramInt2;
    if (paramInt2 != 1)
    {
      ((eso)localObject).NpI = 0;
      AppMethodBeat.o(115215);
      return;
    }
    ((eso)localObject).NpL = paramString;
    paramString = new euk();
    paramString.oUv = 2;
    SKBuiltinBuffer_t localSKBuiltinBuffer_t = new SKBuiltinBuffer_t();
    localSKBuiltinBuffer_t.setBuffer(paramArrayOfByte1);
    paramString.KMS = localSKBuiltinBuffer_t;
    ((eso)localObject).NpJ = paramString;
    paramArrayOfByte1 = new euk();
    paramArrayOfByte1.oUv = 3;
    paramString = new SKBuiltinBuffer_t();
    paramString.setBuffer(paramArrayOfByte2);
    paramArrayOfByte1.KMS = paramString;
    ((eso)localObject).NpK = paramArrayOfByte1;
    ((eso)localObject).NpN = System.currentTimeMillis();
    ((eso)localObject).NpI = 1;
    paramInt1 = ((com.tencent.mm.plugin.misc.a.a)g.af(com.tencent.mm.plugin.misc.a.a.class)).Qr(2);
    Log.i(this.TAG, "simType: %s", new Object[] { Integer.valueOf(paramInt1) });
    if (paramInt1 == 0) {
      paramInt1 = 0;
    }
    for (;;)
    {
      ((eso)localObject).NpO = paramInt1;
      ((eso)localObject).NpP = paramLinkedList.size();
      ((eso)localObject).NpQ = paramLinkedList;
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
  
  public final i fIF()
  {
    AppMethodBeat.i(115216);
    i local1 = new i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, final q paramAnonymousq)
      {
        AppMethodBeat.i(115214);
        e.Logi(a.this.TAG, "ack response:" + paramAnonymousInt1 + " errCode:" + paramAnonymousInt2 + " status:" + a.this.GWA.mStatus);
        if (a.this.GWA.mStatus == 1)
        {
          e.Logi(a.this.TAG, "reject ok!");
          AppMethodBeat.o(115214);
          return;
        }
        if (a.this.GWA.mStatus != 3)
        {
          e.Loge(a.this.TAG, "ack response not within WAITCONNECT, ignored.");
          AppMethodBeat.o(115214);
          return;
        }
        if (paramAnonymousInt1 != 0)
        {
          if (paramAnonymousInt1 == 4)
          {
            a.this.GWA.GVV.Hcw.GXc = 12;
            a.this.GWA.GVV.Hcw.GXd = paramAnonymousInt2;
            a.this.GWA.K(1, paramAnonymousInt2, "");
            AppMethodBeat.o(115214);
            return;
          }
          a.this.GWA.GVV.Hcw.GXc = 12;
          a.this.GWA.GVV.Hcw.GXd = paramAnonymousInt2;
          a.this.GWA.K(1, -9004, "");
          AppMethodBeat.o(115214);
          return;
        }
        paramAnonymousString = (esp)a.this.fIJ();
        if (paramAnonymousString.NpI != 1)
        {
          e.Logi(a.this.TAG, "onVoipAckResp: do not use preconnect");
          AppMethodBeat.o(115214);
          return;
        }
        a.this.GWA.GVx = true;
        a.this.GWA.GVV.Hbj = 1;
        a.this.GWA.GVV.roomId = paramAnonymousString.LsZ;
        a.this.GWA.GVV.ypH = paramAnonymousString.Lta;
        a.this.GWA.GVV.ypO = paramAnonymousString.NpR;
        a.this.GWA.GVV.HaF = paramAnonymousString.NpV;
        a.this.GWA.GVV.HaJ = paramAnonymousString.NpW;
        a.this.GWA.adl(paramAnonymousString.NpT);
        e.Logi(a.this.TAG, "ack ok, roomid =" + a.this.GWA.GVV.roomId + ",memberid = " + a.this.GWA.GVV.ypO);
        paramAnonymousq = paramAnonymousString.NpS;
        if (paramAnonymousq.yqc > 0)
        {
          paramAnonymousq.yqc -= 1;
          e.Logi(a.this.TAG, "zhengxue[ENCRYPT] got encryptStrategy[" + paramAnonymousq.yqc + "] from ackresp relaydata");
        }
        for (;;)
        {
          e.Logi(a.this.TAG, "ack with switchtcpcnt  =" + a.this.GWA.GVV.HaE + " RedirectReqThreshold =" + paramAnonymousq.NrZ + " BothSideSwitchFlag =" + paramAnonymousq.Nsa + " WifiScanInterval =" + paramAnonymousString.NpW);
          a.this.GWA.GVV.HbM = paramAnonymousq.Nsa;
          if ((paramAnonymousq.Nsc != null) && (paramAnonymousq.Nsc.getBuffer() != null)) {
            a.this.GWA.GVV.HaG = paramAnonymousq.Nsc.getBuffer().toByteArray();
          }
          a.this.GWA.adk(paramAnonymousq.NrE);
          a.this.GWA.ci(paramAnonymousq.NpJ.KMS.getBuffer().toByteArray());
          a.this.GWA.fGE();
          a.this.GWA.fGF();
          if ((paramAnonymousq.NrL != null) && (paramAnonymousq.NrL.getBuffer() != null) && (paramAnonymousq.NrX != null) && (paramAnonymousq.NrX.getBuffer() != null)) {
            a.this.GWA.a(paramAnonymousq.NrL.getBuffer().toByteArray(), paramAnonymousq.NrK, paramAnonymousq.yqc, paramAnonymousq.NrX.getBuffer().toByteArray());
          }
          a.this.GWA.k(paramAnonymousq.NrO, paramAnonymousq.NrP, paramAnonymousq.NrQ, paramAnonymousq.NrR, paramAnonymousq.NrS);
          a.this.GWA.cj(paramAnonymousq.NpK.KMS.getBuffer().toByteArray());
          g.aAk().postToWorker(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(115213);
              Object localObject;
              if ((paramAnonymousq.Nrx == null) || (paramAnonymousq.Nrx.MPZ == 0))
              {
                localObject = new dml();
                ((dml)localObject).LqX = 0;
                ((dml)localObject).LqY = "";
                ((dml)localObject).LqZ = "";
                ((dml)localObject).Lra = a.this.GWA.GVV.netType;
                ((dml)localObject).Lrb = 4;
                ((dml)localObject).Lrc = 2;
                ((dml)localObject).MPX = paramAnonymousq.NrF;
                ((dml)localObject).MPY = paramAnonymousq.NrN;
                paramAnonymousq.Nrx = new dmm();
                paramAnonymousq.Nrx.MPZ = 1;
                paramAnonymousq.Nrx.MQa = new LinkedList();
                paramAnonymousq.Nrx.MQa.add(localObject);
              }
              if ((paramAnonymousq.Nry == null) || (paramAnonymousq.Nry.Lri == 0))
              {
                localObject = new ahj();
                ((ahj)localObject).LqX = 1;
                ((ahj)localObject).LqY = "";
                ((ahj)localObject).LqZ = "";
                ((ahj)localObject).Lra = a.this.GWA.GVV.netType;
                ((ahj)localObject).Lrb = 4;
                ((ahj)localObject).Lrc = 2;
                ((ahj)localObject).Lrd = paramAnonymousq.NrG;
                ((ahj)localObject).Lre = paramAnonymousq.Nsf;
                ((ahj)localObject).Lrf = paramAnonymousq.Nsg;
                paramAnonymousq.Nry = new ahk();
                paramAnonymousq.Nry.Lri = 1;
                paramAnonymousq.Nry.Lrj = new LinkedList();
                paramAnonymousq.Nry.Lrj.add(localObject);
              }
              e.Logi(a.this.TAG, "relay conn cnt: " + paramAnonymousq.Nrx.MPZ);
              try
              {
                a.this.GWA.GVV.HbZ = paramAnonymousq.Nrx.toByteArray();
              }
              catch (Exception localException2)
              {
                try
                {
                  a.this.GWA.GVV.Hca = paramAnonymousq.Nry.toByteArray();
                }
                catch (Exception localException2)
                {
                  try
                  {
                    for (;;)
                    {
                      if (paramAnonymousq.Nsh.LYw > 0) {
                        a.this.GWA.GVV.Hcb = paramAnonymousq.Nsh.toByteArray();
                      }
                      a.this.GWA.adj(paramAnonymousq.NrW);
                      a.this.GWA.adi(paramAnonymousq.NrZ);
                      if ((paramAnonymousq.NrU != null) && (paramAnonymousq.NrV != null)) {
                        a.this.GWA.c(paramAnonymousq.NrT, paramAnonymousq.NrU.getBuffer().toByteArray(), paramAnonymousq.NrV.getBuffer().toByteArray());
                      }
                      e.Logi(a.this.TAG, "ack success, try connect channel");
                      a.this.GWA.fGI();
                      AppMethodBeat.o(115213);
                      return;
                      localException1 = localException1;
                      Log.e(a.this.TAG, "relay conn info to byte array fail..");
                      continue;
                      localException2 = localException2;
                      Log.e(a.this.TAG, "direct conn info to byte array fail..");
                    }
                  }
                  catch (Exception localException3)
                  {
                    for (;;)
                    {
                      Log.e(a.this.TAG, "nic query info to byte array fail..");
                    }
                  }
                }
              }
            }
          });
          AppMethodBeat.o(115214);
          return;
          paramAnonymousq.yqc = 1;
          e.Logi(a.this.TAG, "zhengxue[LOGIC]:got no EncryptStrategy in ackresp mrdata");
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