package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.g;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.voip.b.c;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.model.w;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dme;
import com.tencent.mm.protocal.protobuf.dnn;
import com.tencent.mm.protocal.protobuf.dno;
import com.tencent.mm.sdk.platformtools.ad;

public final class m
  extends n<dnn, dno>
{
  public m(int paramInt1, dme paramdme, byte[] paramArrayOfByte, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(115256);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new dnn();
    ((b.a)localObject).gUV = new dno();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/voipsync";
    ((b.a)localObject).funcId = 174;
    ((b.a)localObject).reqCmdId = 62;
    ((b.a)localObject).respCmdId = 1000000062;
    this.rr = ((b.a)localObject).atI();
    localObject = (dnn)this.rr.gUS.gUX;
    ((dnn)localObject).DdZ = paramInt1;
    ((dnn)localObject).EEi = paramdme;
    ((dnn)localObject).Dea = paramLong;
    ((dnn)localObject).DZr = u.aqG();
    ((dnn)localObject).CRw = paramInt2;
    ((dnn)localObject).CRx = new SKBuiltinBuffer_t().setBuffer(paramArrayOfByte);
    ((dnn)localObject).EAY = System.currentTimeMillis();
    ad.i("MicroMsg.NetSceneVoipSync", "sync timestamp: " + ((dnn)localObject).EAY);
    AppMethodBeat.o(115256);
  }
  
  public final g dVg()
  {
    AppMethodBeat.i(115257);
    g local1 = new g()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.n paramAnonymousn)
      {
        AppMethodBeat.i(115255);
        c.Logi("MicroMsg.NetSceneVoipSync", "onSceneEnd type:" + paramAnonymousn.getType() + " errType:" + paramAnonymousInt1 + " errCode:" + paramAnonymousInt2);
        try
        {
          if (((dno)m.this.dVk()).DdZ != m.this.zjH.ziZ.roomId)
          {
            c.Loge("MicroMsg.NetSceneVoipSync", "syncOnSceneEnd: recv roomId != current roomid");
            AppMethodBeat.o(115255);
            return;
          }
        }
        catch (Exception paramAnonymousString)
        {
          if (paramAnonymousInt1 != 0)
          {
            c.Loge("MicroMsg.NetSceneVoipSync", "VoipSync Failed, type:" + paramAnonymousn.getType() + " errType:" + paramAnonymousInt1 + " errCode:" + paramAnonymousInt2);
            m.this.zjH.ziZ.zpq.zkh = 11;
            m.this.zjH.ziZ.zpq.zkj = paramAnonymousInt2;
            m.this.zjH.ziZ.zpq.zki = paramAnonymousInt2;
            m.this.zjH.ziZ.zpq.zkz = 3;
            if (paramAnonymousInt1 == 1) {}
            for (m.this.zjH.ziZ.zpq.zkt = 8;; m.this.zjH.ziZ.zpq.zkt = 99)
            {
              m.this.zjH.I(1, -9004, "");
              AppMethodBeat.o(115255);
              return;
            }
          }
          m.this.zjH.zjc.o(paramAnonymousn);
          AppMethodBeat.o(115255);
        }
      }
    };
    AppMethodBeat.o(115257);
    return local1;
  }
  
  public final int dVi()
  {
    return ((dnn)this.rr.gUS.gUX).CRw;
  }
  
  public final int getType()
  {
    return 174;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.m
 * JD-Core Version:    0.7.0.1
 */