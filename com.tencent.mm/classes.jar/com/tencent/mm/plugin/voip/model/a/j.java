package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.plugin.voip.c.e;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.elz;
import com.tencent.mm.protocal.protobuf.fdb;
import com.tencent.mm.protocal.protobuf.fek;
import com.tencent.mm.protocal.protobuf.fel;
import com.tencent.mm.protocal.protobuf.fez;
import com.tencent.mm.protocal.protobuf.ffa;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;
import java.util.LinkedList;

public final class j
  extends n<fez, ffa>
{
  public j(long paramLong1, long paramLong2, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(115247);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new fez();
    ((d.a)localObject).lBV = new ffa();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/voipspeedresult";
    ((d.a)localObject).funcId = 901;
    ((d.a)localObject).lBW = 901;
    ((d.a)localObject).respCmdId = 1000000901;
    this.rr = ((d.a)localObject).bgN();
    localObject = (fez)d.b.b(this.rr.lBR);
    ((fez)localObject).UFD = paramLong1;
    ((fez)localObject).Svv = paramLong2;
    ((fez)localObject).SmH = paramInt1;
    ((fez)localObject).UFE = new eaf().btQ(paramString1);
    ((fez)localObject).UFF = new eaf().btQ(paramString2);
    ((fez)localObject).RVy = 0.0D;
    ((fez)localObject).RVz = 0.0D;
    ((fez)localObject).Svu = paramInt2;
    ((fez)localObject).UFG = paramInt3;
    for (;;)
    {
      try
      {
        paramString1 = (fel)new fel().parseFrom(paramArrayOfByte);
        paramInt1 = 0;
        if (paramInt1 >= paramString1.UEq.size()) {
          break;
        }
        paramString2 = new elz();
        paramString2.UnZ = ((fek)paramString1.UEq.get(paramInt1)).UEa;
        paramString2.Uoa = ((fek)paramString1.UEq.get(paramInt1)).UEb;
        paramString2.Uob = ((fek)paramString1.UEq.get(paramInt1)).UEc;
        paramString2.Uoc = new fdb();
        paramString2.Uoc.Utf = ((fek)paramString1.UEq.get(paramInt1)).UEd;
        paramString2.Uoc.TVY = ((fek)paramString1.UEq.get(paramInt1)).UEe;
        paramString2.Uoc.Utg = ((fek)paramString1.UEq.get(paramInt1)).UEo;
        paramString2.Uod = ((fek)paramString1.UEq.get(paramInt1)).UEf;
        paramString2.Uoe = ((fek)paramString1.UEq.get(paramInt1)).UEg;
        paramString2.Uof = ((fek)paramString1.UEq.get(paramInt1)).UEh;
        paramString2.Uog = ((fek)paramString1.UEq.get(paramInt1)).UEj.size();
        paramInt2 = 0;
        if (paramInt2 < paramString2.Uog)
        {
          paramString2.Uoh.add(((fek)paramString1.UEq.get(paramInt1)).UEj.get(paramInt2));
          paramInt2 += 1;
          continue;
        }
        paramString2.Uoi = ((fek)paramString1.UEq.get(paramInt1)).UEk;
      }
      catch (IOException paramString1)
      {
        Log.printErrStackTrace("MicroMsg.NetSceneVoipSpeedResult", paramString1, "", new Object[0]);
        AppMethodBeat.o(115247);
        return;
      }
      paramInt2 = 0;
      while (paramInt2 < paramString2.Uoi)
      {
        paramString2.Uoj.add(((fek)paramString1.UEq.get(paramInt1)).UEl.get(paramInt2));
        paramInt2 += 1;
      }
      paramString2.Uok = ((fek)paramString1.UEq.get(paramInt1)).UEm;
      paramInt2 = 0;
      while (paramInt2 < paramString2.Uok)
      {
        paramString2.Uol.add(((fek)paramString1.UEq.get(paramInt1)).UEn.get(paramInt2));
        paramInt2 += 1;
      }
      paramString2.Uom = ((fek)paramString1.UEq.get(paramInt1)).UEp;
      ((fez)localObject).TfC.add(paramString2);
      e.Logi("MicroMsg.NetSceneVoipSpeedResult", "VoipContext NetSceneVoipSpeedResult testid:" + paramLong1 + " roomkey=" + paramLong2 + " ipstr=" + paramString2.Uoc.Utg + " client ipstr=" + paramString2.Uom);
      paramInt1 += 1;
    }
    AppMethodBeat.o(115247);
  }
  
  public final i gAU()
  {
    AppMethodBeat.i(115248);
    i local1 = new i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
      {
        AppMethodBeat.i(115246);
        e.Logi("MicroMsg.NetSceneVoipSpeedResult", "VoipContext onVoipSpeedResultResp errType=" + paramAnonymousInt1 + " errCode=" + paramAnonymousInt2 + " errMsg=" + paramAnonymousString);
        j.this.NMN.gyC();
        AppMethodBeat.o(115246);
      }
    };
    AppMethodBeat.o(115248);
    return local1;
  }
  
  public final int getType()
  {
    return 901;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.j
 * JD-Core Version:    0.7.0.1
 */