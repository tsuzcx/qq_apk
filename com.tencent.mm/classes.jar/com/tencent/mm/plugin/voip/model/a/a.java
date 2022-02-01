package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.afd;
import com.tencent.mm.protocal.protobuf.afe;
import com.tencent.mm.protocal.protobuf.bfc;
import com.tencent.mm.protocal.protobuf.ccp;
import com.tencent.mm.protocal.protobuf.ctv;
import com.tencent.mm.protocal.protobuf.ctw;
import com.tencent.mm.protocal.protobuf.dyh;
import com.tencent.mm.protocal.protobuf.dyi;
import com.tencent.mm.protocal.protobuf.dzx;
import com.tencent.mm.protocal.protobuf.ead;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import java.util.LinkedList;

public final class a
  extends n<dyh, dyi>
{
  String TAG;
  
  public a(int paramInt1, long paramLong, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString, LinkedList<ccp> paramLinkedList)
  {
    AppMethodBeat.i(115215);
    this.TAG = "MicroMsg.NetSceneVoipAck";
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new dyh();
    ((b.a)localObject).hQG = new dyi();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/voipack";
    ((b.a)localObject).funcId = 305;
    ((b.a)localObject).hQH = 123;
    ((b.a)localObject).respCmdId = 1000000123;
    this.rr = ((b.a)localObject).aDS();
    localObject = (dyh)this.rr.hQD.hQJ;
    ((dyh)localObject).Gxq = paramInt1;
    ((dyh)localObject).Gxr = paramLong;
    ((dyh)localObject).Ido = paramInt2;
    if (paramInt2 != 1)
    {
      ((dyh)localObject).Idk = 0;
      AppMethodBeat.o(115215);
      return;
    }
    ((dyh)localObject).Idn = paramString;
    paramString = new ead();
    paramString.nJA = 2;
    SKBuiltinBuffer_t localSKBuiltinBuffer_t = new SKBuiltinBuffer_t();
    localSKBuiltinBuffer_t.setBuffer(paramArrayOfByte1);
    paramString.FTj = localSKBuiltinBuffer_t;
    ((dyh)localObject).Idl = paramString;
    paramArrayOfByte1 = new ead();
    paramArrayOfByte1.nJA = 3;
    paramString = new SKBuiltinBuffer_t();
    paramString.setBuffer(paramArrayOfByte2);
    paramArrayOfByte1.FTj = paramString;
    ((dyh)localObject).Idm = paramArrayOfByte1;
    ((dyh)localObject).Idp = System.currentTimeMillis();
    ((dyh)localObject).Idk = 1;
    paramInt1 = ((com.tencent.mm.plugin.misc.a.a)g.ab(com.tencent.mm.plugin.misc.a.a.class)).Kp(2);
    ae.i(this.TAG, "simType: %s", new Object[] { Integer.valueOf(paramInt1) });
    if (paramInt1 == 0) {
      paramInt1 = 0;
    }
    for (;;)
    {
      ((dyh)localObject).Idq = paramInt1;
      ((dyh)localObject).Idr = paramLinkedList.size();
      ((dyh)localObject).Ids = paramLinkedList;
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
  
  public final com.tencent.mm.ak.f eBL()
  {
    AppMethodBeat.i(115216);
    com.tencent.mm.ak.f local1 = new com.tencent.mm.ak.f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, final com.tencent.mm.ak.n paramAnonymousn)
      {
        AppMethodBeat.i(115214);
        com.tencent.mm.plugin.voip.b.f.Logi(a.this.TAG, "ack response:" + paramAnonymousInt1 + " errCode:" + paramAnonymousInt2 + " status:" + a.this.CsR.mStatus);
        if (a.this.CsR.mStatus == 1)
        {
          com.tencent.mm.plugin.voip.b.f.Logi(a.this.TAG, "reject ok!");
          AppMethodBeat.o(115214);
          return;
        }
        if (a.this.CsR.mStatus != 3)
        {
          com.tencent.mm.plugin.voip.b.f.Loge(a.this.TAG, "ack response not within WAITCONNECT, ignored.");
          AppMethodBeat.o(115214);
          return;
        }
        if (paramAnonymousInt1 != 0)
        {
          if (paramAnonymousInt1 == 4)
          {
            a.this.CsR.Csj.CyH.Ctt = 12;
            a.this.CsR.Csj.CyH.Ctu = paramAnonymousInt2;
            a.this.CsR.J(1, paramAnonymousInt2, "");
            AppMethodBeat.o(115214);
            return;
          }
          a.this.CsR.Csj.CyH.Ctt = 12;
          a.this.CsR.Csj.CyH.Ctu = paramAnonymousInt2;
          a.this.CsR.J(1, -9004, "");
          AppMethodBeat.o(115214);
          return;
        }
        paramAnonymousString = (dyi)a.this.eBP();
        if (paramAnonymousString.Idk != 1)
        {
          com.tencent.mm.plugin.voip.b.f.Logi(a.this.TAG, "onVoipAckResp: do not use preconnect");
          AppMethodBeat.o(115214);
          return;
        }
        a.this.CsR.CrL = true;
        a.this.CsR.Csj.Cxv = 1;
        a.this.CsR.Csj.roomId = paramAnonymousString.Gxq;
        a.this.CsR.Csj.uXg = paramAnonymousString.Gxr;
        a.this.CsR.Csj.uXn = paramAnonymousString.Idt;
        a.this.CsR.Csj.CwQ = paramAnonymousString.Idx;
        a.this.CsR.Csj.CwU = paramAnonymousString.Idy;
        a.this.CsR.UR(paramAnonymousString.Idv);
        com.tencent.mm.plugin.voip.b.f.Logi(a.this.TAG, "ack ok, roomid =" + a.this.CsR.Csj.roomId + ",memberid = " + a.this.CsR.Csj.uXn);
        paramAnonymousn = paramAnonymousString.Idu;
        if (paramAnonymousn.uXB > 0)
        {
          paramAnonymousn.uXB -= 1;
          com.tencent.mm.plugin.voip.b.f.Logi(a.this.TAG, "zhengxue[ENCRYPT] got encryptStrategy[" + paramAnonymousn.uXB + "] from ackresp relaydata");
        }
        for (;;)
        {
          com.tencent.mm.plugin.voip.b.f.Logi(a.this.TAG, "ack with switchtcpcnt  =" + a.this.CsR.Csj.CwP + " RedirectReqThreshold =" + paramAnonymousn.IfB + " BothSideSwitchFlag =" + paramAnonymousn.IfC + " WifiScanInterval =" + paramAnonymousString.Idy);
          a.this.CsR.Csj.CxY = paramAnonymousn.IfC;
          if ((paramAnonymousn.IfE != null) && (paramAnonymousn.IfE.getBuffer() != null)) {
            a.this.CsR.Csj.CwR = paramAnonymousn.IfE.getBuffer().toByteArray();
          }
          a.this.CsR.UQ(paramAnonymousn.Ifg);
          a.this.CsR.bS(paramAnonymousn.Idl.FTj.getBuffer().toByteArray());
          a.this.CsR.ezP();
          if ((paramAnonymousn.Ifn != null) && (paramAnonymousn.Ifn.getBuffer() != null) && (paramAnonymousn.Ifz != null) && (paramAnonymousn.Ifz.getBuffer() != null)) {
            a.this.CsR.a(paramAnonymousn.Ifn.getBuffer().toByteArray(), paramAnonymousn.Ifm, paramAnonymousn.uXB, paramAnonymousn.Ifz.getBuffer().toByteArray());
          }
          a.this.CsR.j(paramAnonymousn.Ifq, paramAnonymousn.Ifr, paramAnonymousn.Ifs, paramAnonymousn.Ift, paramAnonymousn.Ifu);
          a.this.CsR.bT(paramAnonymousn.Idm.FTj.getBuffer().toByteArray());
          g.ajU().aw(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(115213);
              Object localObject;
              if ((paramAnonymousn.IeZ == null) || (paramAnonymousn.IeZ.HER == 0))
              {
                localObject = new ctv();
                ((ctv)localObject).Gvr = 0;
                ((ctv)localObject).Gvs = "";
                ((ctv)localObject).Gvt = "";
                ((ctv)localObject).Gvu = a.this.CsR.Csj.netType;
                ((ctv)localObject).Gvv = 4;
                ((ctv)localObject).Gvw = 2;
                ((ctv)localObject).HEP = paramAnonymousn.Ifh;
                ((ctv)localObject).HEQ = paramAnonymousn.Ifp;
                paramAnonymousn.IeZ = new ctw();
                paramAnonymousn.IeZ.HER = 1;
                paramAnonymousn.IeZ.HES = new LinkedList();
                paramAnonymousn.IeZ.HES.add(localObject);
              }
              if ((paramAnonymousn.Ifa == null) || (paramAnonymousn.Ifa.GvC == 0))
              {
                localObject = new afd();
                ((afd)localObject).Gvr = 1;
                ((afd)localObject).Gvs = "";
                ((afd)localObject).Gvt = "";
                ((afd)localObject).Gvu = a.this.CsR.Csj.netType;
                ((afd)localObject).Gvv = 4;
                ((afd)localObject).Gvw = 2;
                ((afd)localObject).Gvx = paramAnonymousn.Ifi;
                ((afd)localObject).Gvy = paramAnonymousn.IfH;
                ((afd)localObject).Gvz = paramAnonymousn.IfI;
                paramAnonymousn.Ifa = new afe();
                paramAnonymousn.Ifa.GvC = 1;
                paramAnonymousn.Ifa.GvD = new LinkedList();
                paramAnonymousn.Ifa.GvD.add(localObject);
              }
              com.tencent.mm.plugin.voip.b.f.Logi(a.this.TAG, "relay conn cnt: " + paramAnonymousn.IeZ.HER);
              try
              {
                a.this.CsR.Csj.Cyk = paramAnonymousn.IeZ.toByteArray();
              }
              catch (Exception localException2)
              {
                try
                {
                  a.this.CsR.Csj.Cyl = paramAnonymousn.Ifa.toByteArray();
                }
                catch (Exception localException2)
                {
                  try
                  {
                    for (;;)
                    {
                      if (paramAnonymousn.IfJ.GUe > 0) {
                        a.this.CsR.Csj.Cym = paramAnonymousn.IfJ.toByteArray();
                      }
                      a.this.CsR.UP(paramAnonymousn.Ify);
                      a.this.CsR.UO(paramAnonymousn.IfB);
                      if ((paramAnonymousn.Ifw != null) && (paramAnonymousn.Ifx != null)) {
                        a.this.CsR.c(paramAnonymousn.Ifv, paramAnonymousn.Ifw.getBuffer().toByteArray(), paramAnonymousn.Ifx.getBuffer().toByteArray());
                      }
                      com.tencent.mm.plugin.voip.b.f.Logi(a.this.TAG, "ack success, try connect channel");
                      a.this.CsR.ezS();
                      AppMethodBeat.o(115213);
                      return;
                      localException1 = localException1;
                      ae.e(a.this.TAG, "relay conn info to byte array fail..");
                      continue;
                      localException2 = localException2;
                      ae.e(a.this.TAG, "direct conn info to byte array fail..");
                    }
                  }
                  catch (Exception localException3)
                  {
                    for (;;)
                    {
                      ae.e(a.this.TAG, "nic query info to byte array fail..");
                    }
                  }
                }
              }
            }
          });
          AppMethodBeat.o(115214);
          return;
          paramAnonymousn.uXB = 1;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.a
 * JD-Core Version:    0.7.0.1
 */