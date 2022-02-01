package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.voip.c.e;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.model.w;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.fdy;
import com.tencent.mm.protocal.protobuf.ffh;
import com.tencent.mm.protocal.protobuf.ffi;
import com.tencent.mm.sdk.platformtools.Log;

public final class m
  extends n<ffh, ffi>
{
  public m(int paramInt1, fdy paramfdy, byte[] paramArrayOfByte, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(115256);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new ffh();
    ((d.a)localObject).lBV = new ffi();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/voipsync";
    ((d.a)localObject).funcId = 174;
    ((d.a)localObject).lBW = 62;
    ((d.a)localObject).respCmdId = 1000000062;
    this.rr = ((d.a)localObject).bgN();
    localObject = (ffh)d.b.b(this.rr.lBR);
    ((ffh)localObject).Svu = paramInt1;
    ((ffh)localObject).UFU = paramfdy;
    ((ffh)localObject).Svv = paramLong;
    ((ffh)localObject).TWw = z.bcZ();
    ((ffh)localObject).SfH = paramInt2;
    ((ffh)localObject).SfI = new eae().dc(paramArrayOfByte);
    ((ffh)localObject).UCJ = System.currentTimeMillis();
    Log.i("MicroMsg.NetSceneVoipSync", "sync timestamp: " + ((ffh)localObject).UCJ);
    AppMethodBeat.o(115256);
  }
  
  public final i gAU()
  {
    AppMethodBeat.i(115257);
    i local1 = new i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
      {
        AppMethodBeat.i(115255);
        e.Logi("MicroMsg.NetSceneVoipSync", "onSceneEnd type:" + paramAnonymousq.getType() + " errType:" + paramAnonymousInt1 + " errCode:" + paramAnonymousInt2);
        try
        {
          if (((ffi)m.this.gAY()).Svu != m.this.NMN.NMi.roomId)
          {
            e.Loge("MicroMsg.NetSceneVoipSync", "syncOnSceneEnd: recv roomId != current roomid");
            AppMethodBeat.o(115255);
            return;
          }
        }
        catch (Exception paramAnonymousString)
        {
          if (paramAnonymousInt1 != 0)
          {
            e.Loge("MicroMsg.NetSceneVoipSync", "VoipSync Failed, type:" + paramAnonymousq.getType() + " errType:" + paramAnonymousInt1 + " errCode:" + paramAnonymousInt2);
            m.this.NMN.NMi.NSI.NNq = 11;
            m.this.NMN.NMi.NSI.NNs = paramAnonymousInt2;
            m.this.NMN.NMi.NSI.NNr = paramAnonymousInt2;
            m.this.NMN.NMi.NSI.NNI = 3;
            if (paramAnonymousInt1 == 1) {}
            for (m.this.NMN.NMi.NSI.NNC = 8;; m.this.NMN.NMi.NSI.NNC = 99)
            {
              m.this.NMN.J(1, -9004, "");
              AppMethodBeat.o(115255);
              return;
            }
          }
          m.this.NMN.NMl.p(paramAnonymousq);
          AppMethodBeat.o(115255);
        }
      }
    };
    AppMethodBeat.o(115257);
    return local1;
  }
  
  public final int gAW()
  {
    AppMethodBeat.i(234603);
    int i = ((ffh)d.b.b(this.rr.lBR)).SfH;
    AppMethodBeat.o(234603);
    return i;
  }
  
  public final int getType()
  {
    return 174;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.m
 * JD-Core Version:    0.7.0.1
 */