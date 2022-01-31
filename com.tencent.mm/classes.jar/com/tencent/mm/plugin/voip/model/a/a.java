package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.voip.model.k;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.crk;
import com.tencent.mm.protocal.protobuf.crl;
import com.tencent.mm.protocal.protobuf.csu;
import com.tencent.mm.protocal.protobuf.cta;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

public final class a
  extends n<crk, crl>
{
  String TAG;
  
  public a(int paramInt1, long paramLong, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString)
  {
    AppMethodBeat.i(4695);
    this.TAG = "MicroMsg.NetSceneVoipAck";
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new crk();
    ((b.a)localObject).fsY = new crl();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/voipack";
    ((b.a)localObject).funcId = 305;
    ((b.a)localObject).reqCmdId = 123;
    ((b.a)localObject).respCmdId = 1000000123;
    this.rr = ((b.a)localObject).ado();
    localObject = (crk)this.rr.fsV.fta;
    ((crk)localObject).wQP = paramInt1;
    ((crk)localObject).wQQ = paramLong;
    ((crk)localObject).yaa = paramInt2;
    if (paramInt2 != 1)
    {
      ((crk)localObject).xZW = 0;
      AppMethodBeat.o(4695);
      return;
    }
    ((crk)localObject).xZZ = paramString;
    paramString = new cta();
    paramString.jKs = 2;
    SKBuiltinBuffer_t localSKBuiltinBuffer_t = new SKBuiltinBuffer_t();
    localSKBuiltinBuffer_t.setBuffer(paramArrayOfByte1);
    paramString.wtq = localSKBuiltinBuffer_t;
    ((crk)localObject).xZX = paramString;
    paramArrayOfByte1 = new cta();
    paramArrayOfByte1.jKs = 3;
    paramString = new SKBuiltinBuffer_t();
    paramString.setBuffer(paramArrayOfByte2);
    paramArrayOfByte1.wtq = paramString;
    ((crk)localObject).xZY = paramArrayOfByte1;
    ((crk)localObject).yab = System.currentTimeMillis();
    ((crk)localObject).xZW = 1;
    paramInt1 = ((com.tencent.mm.plugin.misc.a.a)g.E(com.tencent.mm.plugin.misc.a.a.class)).yW(2);
    ab.i(this.TAG, "simType: %s", new Object[] { Integer.valueOf(paramInt1) });
    if (paramInt1 == 0) {
      paramInt1 = 0;
    }
    for (;;)
    {
      ((crk)localObject).yac = paramInt1;
      AppMethodBeat.o(4695);
      return;
      if (paramInt1 == 1) {
        paramInt1 = 1;
      } else {
        paramInt1 = 2;
      }
    }
  }
  
  public final f cOp()
  {
    AppMethodBeat.i(4696);
    f local1 = new f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, final m paramAnonymousm)
      {
        AppMethodBeat.i(4694);
        com.tencent.mm.plugin.voip.a.a.Logi(a.this.TAG, "ack response:" + paramAnonymousInt1 + " errCode:" + paramAnonymousInt2 + " status:" + a.this.tvE.mStatus);
        if (a.this.tvE.mStatus == 1)
        {
          com.tencent.mm.plugin.voip.a.a.Logi(a.this.TAG, "reject ok!");
          AppMethodBeat.o(4694);
          return;
        }
        if (a.this.tvE.mStatus != 3)
        {
          com.tencent.mm.plugin.voip.a.a.Loge(a.this.TAG, "ack response not within WAITCONNECT, ignored.");
          AppMethodBeat.o(4694);
          return;
        }
        if (paramAnonymousInt1 != 0)
        {
          if (paramAnonymousInt1 == 4)
          {
            a.this.tvE.tvj.tBN.twb = 12;
            a.this.tvE.tvj.tBN.twc = paramAnonymousInt2;
            a.this.tvE.y(1, paramAnonymousInt2, "");
            AppMethodBeat.o(4694);
            return;
          }
          a.this.tvE.tvj.tBN.twb = 12;
          a.this.tvE.tvj.tBN.twc = paramAnonymousInt2;
          a.this.tvE.y(1, -9004, "");
          AppMethodBeat.o(4694);
          return;
        }
        paramAnonymousString = (crl)a.this.cOt();
        if (paramAnonymousString.xZW != 1)
        {
          com.tencent.mm.plugin.voip.a.a.Logi(a.this.TAG, "onVoipAckResp: do not use preconnect");
          AppMethodBeat.o(4694);
          return;
        }
        a.this.tvE.tuL = true;
        a.this.tvE.tvj.tAF = 1;
        a.this.tvE.tvj.nMZ = paramAnonymousString.wQP;
        a.this.tvE.tvj.nNa = paramAnonymousString.wQQ;
        a.this.tvE.tvj.nNh = paramAnonymousString.yad;
        a.this.tvE.tvj.tAk = paramAnonymousString.yah;
        a.this.tvE.tvj.tAn = paramAnonymousString.yai;
        a.this.tvE.Hq(paramAnonymousString.yaf);
        com.tencent.mm.plugin.voip.a.a.Logi(a.this.TAG, "ack ok, roomid =" + a.this.tvE.tvj.nMZ + ",memberid = " + a.this.tvE.tvj.nNh);
        paramAnonymousm = paramAnonymousString.yae;
        if (paramAnonymousm.nNv > 0)
        {
          paramAnonymousm.nNv -= 1;
          com.tencent.mm.plugin.voip.a.a.Logi(a.this.TAG, "zhengxue[ENCRYPT] got encryptStrategy[" + paramAnonymousm.nNv + "] from ackresp relaydata");
        }
        for (;;)
        {
          com.tencent.mm.plugin.voip.a.a.Logi(a.this.TAG, "ack with switchtcpcnt  =" + a.this.tvE.tvj.tAj + " RedirectReqThreshold =" + paramAnonymousm.ybJ + " BothSideSwitchFlag =" + paramAnonymousm.ybK + " WifiScanInterval =" + paramAnonymousString.yai);
          a.this.tvE.tvj.tBh = paramAnonymousm.ybK;
          if ((paramAnonymousm.ybM != null) && (paramAnonymousm.ybM.getBuffer() != null)) {
            a.this.tvE.tvj.tAl = paramAnonymousm.ybM.getBuffer().toByteArray();
          }
          a.this.tvE.Hp(paramAnonymousm.ybo);
          a.this.tvE.br(paramAnonymousm.xZX.wtq.getBuffer().toByteArray());
          if ((paramAnonymousm.ybv != null) && (paramAnonymousm.ybv.getBuffer() != null) && (paramAnonymousm.ybH != null) && (paramAnonymousm.ybH.getBuffer() != null)) {
            a.this.tvE.a(paramAnonymousm.ybv.getBuffer().toByteArray(), paramAnonymousm.ybu, paramAnonymousm.nNv, paramAnonymousm.ybH.getBuffer().toByteArray());
          }
          a.this.tvE.i(paramAnonymousm.yby, paramAnonymousm.ybz, paramAnonymousm.ybA, paramAnonymousm.ybB, paramAnonymousm.ybC);
          a.this.tvE.bs(paramAnonymousm.xZY.wtq.getBuffer().toByteArray());
          g.RO().ac(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(4693);
              a.this.tvE.a(paramAnonymousm.ybp, paramAnonymousm.ybq, paramAnonymousm.ybx, paramAnonymousm.ybQ);
              a.this.tvE.Ho(paramAnonymousm.ybG);
              a.this.tvE.Hn(paramAnonymousm.ybJ);
              if ((paramAnonymousm.ybE != null) && (paramAnonymousm.ybF != null)) {
                a.this.tvE.c(paramAnonymousm.ybD, paramAnonymousm.ybE.getBuffer().toByteArray(), paramAnonymousm.ybF.getBuffer().toByteArray());
              }
              com.tencent.mm.plugin.voip.a.a.Logi(a.this.TAG, "ack success, try connect channel");
              a.this.tvE.cMk();
              AppMethodBeat.o(4693);
            }
          });
          AppMethodBeat.o(4694);
          return;
          paramAnonymousm.nNv = 1;
          com.tencent.mm.plugin.voip.a.a.Logi(a.this.TAG, "zhengxue[LOGIC]:got no EncryptStrategy in ackresp mrdata");
        }
      }
    };
    AppMethodBeat.o(4696);
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