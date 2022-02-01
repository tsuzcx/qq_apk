package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.voip.f.g;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.plugin.voip.model.o;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.protocal.protobuf.akl;
import com.tencent.mm.protocal.protobuf.akm;
import com.tencent.mm.protocal.protobuf.cnv;
import com.tencent.mm.protocal.protobuf.dtl;
import com.tencent.mm.protocal.protobuf.epe;
import com.tencent.mm.protocal.protobuf.epf;
import com.tencent.mm.protocal.protobuf.fzl;
import com.tencent.mm.protocal.protobuf.fzm;
import com.tencent.mm.protocal.protobuf.gbb;
import com.tencent.mm.protocal.protobuf.gbh;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.LinkedList;

public final class a
  extends n<fzl, fzm>
{
  private String TAG;
  
  public a(int paramInt1, long paramLong, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString, LinkedList<dtl> paramLinkedList)
  {
    AppMethodBeat.i(115215);
    this.TAG = "MicroMsg.NetSceneVoipAck";
    Object localObject = new c.a();
    ((c.a)localObject).otE = new fzl();
    ((c.a)localObject).otF = new fzm();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/voipack";
    ((c.a)localObject).funcId = 305;
    ((c.a)localObject).otG = 123;
    ((c.a)localObject).respCmdId = 1000000123;
    this.rr = ((c.a)localObject).bEF();
    localObject = (fzl)c.b.b(this.rr.otB);
    ((fzl)localObject).Zvz = paramInt1;
    ((fzl)localObject).ZvA = paramLong;
    ((fzl)localObject).abWS = paramInt2;
    if (paramInt2 != 1)
    {
      ((fzl)localObject).abWO = 0;
      AppMethodBeat.o(115215);
      return;
    }
    ((fzl)localObject).abWR = paramString;
    paramString = new gbh();
    paramString.vhJ = 2;
    gol localgol = new gol();
    localgol.df(paramArrayOfByte1);
    paramString.YLa = localgol;
    ((fzl)localObject).abWP = paramString;
    paramArrayOfByte1 = new gbh();
    paramArrayOfByte1.vhJ = 3;
    paramString = new gol();
    paramString.df(paramArrayOfByte2);
    paramArrayOfByte1.YLa = paramString;
    ((fzl)localObject).abWQ = paramArrayOfByte1;
    ((fzl)localObject).abWT = System.currentTimeMillis();
    ((fzl)localObject).abWX = this.UzB.UyU.getIpStack();
    ((fzl)localObject).abWO = 1;
    paramInt1 = ((com.tencent.mm.plugin.misc.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.misc.a.a.class)).aaG(2);
    g.Logi(this.TAG, "simType:" + paramInt1 + " ipstack:" + ((fzl)localObject).abWX);
    if (paramInt1 == 0) {
      paramInt1 = 0;
    }
    for (;;)
    {
      ((fzl)localObject).abWU = paramInt1;
      ((fzl)localObject).abWV = paramLinkedList.size();
      ((fzl)localObject).abWW = paramLinkedList;
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
  
  public final int getType()
  {
    return 305;
  }
  
  public final com.tencent.mm.am.h hYT()
  {
    AppMethodBeat.i(115216);
    com.tencent.mm.am.h local1 = new com.tencent.mm.am.h()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, final p paramAnonymousp)
      {
        AppMethodBeat.i(115214);
        g.Logi(a.a(a.this), "ack response:" + paramAnonymousInt1 + " errCode:" + paramAnonymousInt2 + " status:" + a.this.UzB.mStatus);
        paramAnonymousString = a.this.UzB.UyU.UFN;
        paramAnonymousString.wS((int)(System.currentTimeMillis() - paramAnonymousString.UAO));
        if (a.this.UzB.mStatus == 1)
        {
          g.Logi(a.a(a.this), "reject ok!");
          AppMethodBeat.o(115214);
          return;
        }
        if (a.this.UzB.mStatus != 3)
        {
          g.Loge(a.a(a.this), "ack response not within WAITCONNECT, ignored.");
          AppMethodBeat.o(115214);
          return;
        }
        if (paramAnonymousInt1 != 0)
        {
          if (paramAnonymousInt1 == 4)
          {
            a.this.UzB.UyU.UFN.UAh = 12;
            a.this.UzB.UyU.UFN.UAi = paramAnonymousInt2;
            a.this.UzB.S(1, paramAnonymousInt2, "");
            AppMethodBeat.o(115214);
            return;
          }
          a.this.UzB.UyU.UFN.UAh = 12;
          a.this.UzB.UyU.UFN.UAi = paramAnonymousInt2;
          a.this.UzB.S(1, -9004, "");
          AppMethodBeat.o(115214);
          return;
        }
        paramAnonymousString = (fzm)a.this.hYX();
        if (paramAnonymousString.abWO != 1)
        {
          g.Logi(a.a(a.this), "onVoipAckResp: do not use preconnect");
          AppMethodBeat.o(115214);
          return;
        }
        a.this.UzB.Uyw = true;
        a.this.UzB.UyU.UEA = 1;
        a.this.UzB.UyU.roomId = paramAnonymousString.Zvz;
        a.this.UzB.UyU.Hnt = paramAnonymousString.ZvA;
        a.this.UzB.UyU.JHb = paramAnonymousString.abWY;
        a.this.UzB.UyU.UDD = paramAnonymousString.abXc;
        a.this.UzB.UyU.UDH = paramAnonymousString.abXd;
        a.this.UzB.aqs(paramAnonymousString.abXa);
        g.Logi(a.a(a.this), "ack ok, roomid =" + a.this.UzB.UyU.roomId + ",memberid = " + a.this.UzB.UyU.JHb);
        paramAnonymousp = paramAnonymousString.abWZ;
        if (paramAnonymousp.JHp > 0)
        {
          paramAnonymousp.JHp -= 1;
          g.Logi(a.a(a.this), "zhengxue[ENCRYPT] got encryptStrategy[" + paramAnonymousp.JHp + "] from ackresp relaydata");
        }
        for (;;)
        {
          g.Logi(a.a(a.this), "ack with switchtcpcnt  =" + a.this.UzB.UyU.UDC + " RedirectReqThreshold =" + paramAnonymousp.abZh + " BothSideSwitchFlag =" + paramAnonymousp.abZi + " WifiScanInterval =" + paramAnonymousString.abXd);
          a.this.UzB.UyU.UFd = paramAnonymousp.abZi;
          if ((paramAnonymousp.abZk != null) && (paramAnonymousp.abZk.aaxD != null)) {
            a.this.UzB.UyU.UDE = paramAnonymousp.abZk.aaxD.toByteArray();
          }
          a.this.UzB.aqr(paramAnonymousp.abYM);
          a.this.UzB.cC(paramAnonymousp.abWP.YLa.aaxD.toByteArray());
          a.this.UzB.hWM();
          a.this.UzB.hWN();
          if ((paramAnonymousp.abYT != null) && (paramAnonymousp.abYT.aaxD != null) && (paramAnonymousp.abZf != null) && (paramAnonymousp.abZf.aaxD != null)) {
            a.this.UzB.a(paramAnonymousp.abYT.aaxD.toByteArray(), paramAnonymousp.abYS, paramAnonymousp.JHp, paramAnonymousp.abZf.aaxD.toByteArray());
          }
          a.this.UzB.p(paramAnonymousp.abYW, paramAnonymousp.abYX, paramAnonymousp.abYY, paramAnonymousp.abYZ, paramAnonymousp.abZa);
          a.this.UzB.cD(paramAnonymousp.abWQ.YLa.aaxD.toByteArray());
          com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(115213);
              Object localObject;
              if ((paramAnonymousp.abYF == null) || (paramAnonymousp.abYF.abtq == 0))
              {
                localObject = new epe();
                ((epe)localObject).ZrC = 0;
                ((epe)localObject).ZrD = "";
                ((epe)localObject).ZrE = "";
                ((epe)localObject).ZrF = a.this.UzB.UyU.netType;
                ((epe)localObject).ZrG = 4;
                ((epe)localObject).ZrH = 2;
                ((epe)localObject).abto = paramAnonymousp.abYN;
                ((epe)localObject).abtp = paramAnonymousp.abYV;
                paramAnonymousp.abYF = new epf();
                paramAnonymousp.abYF.abtq = 1;
                paramAnonymousp.abYF.abtr = new LinkedList();
                paramAnonymousp.abYF.abtr.add(localObject);
              }
              if ((paramAnonymousp.abYG == null) || (paramAnonymousp.abYG.ZrN == 0))
              {
                localObject = new akl();
                ((akl)localObject).ZrC = 1;
                ((akl)localObject).ZrD = "";
                ((akl)localObject).ZrE = "";
                ((akl)localObject).ZrF = a.this.UzB.UyU.netType;
                ((akl)localObject).ZrG = 4;
                ((akl)localObject).ZrH = 2;
                ((akl)localObject).ZrI = paramAnonymousp.abYO;
                ((akl)localObject).ZrJ = paramAnonymousp.abZn;
                ((akl)localObject).ZrK = paramAnonymousp.abZo;
                paramAnonymousp.abYG = new akm();
                paramAnonymousp.abYG.ZrN = 1;
                paramAnonymousp.abYG.ZrO = new LinkedList();
                paramAnonymousp.abYG.ZrO.add(localObject);
              }
              g.Logi(a.a(a.this), "relay conn cnt: " + paramAnonymousp.abYF.abtq);
              try
              {
                a.this.UzB.UyU.UFq = paramAnonymousp.abYF.toByteArray();
              }
              catch (Exception localException2)
              {
                try
                {
                  a.this.UzB.UyU.UFr = paramAnonymousp.abYG.toByteArray();
                }
                catch (Exception localException2)
                {
                  try
                  {
                    for (;;)
                    {
                      if (paramAnonymousp.abZp.aavd > 0) {
                        a.this.UzB.UyU.UFs = paramAnonymousp.abZp.toByteArray();
                      }
                      a.this.UzB.aqq(paramAnonymousp.abZe);
                      a.this.UzB.aqp(paramAnonymousp.abZh);
                      if ((paramAnonymousp.abZc != null) && (paramAnonymousp.abZd != null)) {
                        a.this.UzB.c(paramAnonymousp.abZb, paramAnonymousp.abZc.aaxD.toByteArray(), paramAnonymousp.abZd.aaxD.toByteArray());
                      }
                      g.Logi(a.a(a.this), "ack success, try connect channel");
                      a.this.UzB.hWQ();
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
          paramAnonymousp.JHp = 1;
          g.Logi(a.a(a.this), "zhengxue[LOGIC]:got no EncryptStrategy in ackresp mrdata");
        }
      }
    };
    AppMethodBeat.o(115216);
    return local1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.a
 * JD-Core Version:    0.7.0.1
 */