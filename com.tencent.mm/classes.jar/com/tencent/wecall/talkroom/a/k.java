package com.tencent.wecall.talkroom.a;

import com.google.b.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.b.a.a.a.ag;
import com.tencent.pb.common.b.a.a.a.ao;
import com.tencent.pb.common.b.a.a.a.i;
import com.tencent.pb.common.b.d;
import com.tencent.pb.common.c.b;
import com.tencent.wecall.talkroom.model.c;
import java.util.List;

public final class k
  extends d
{
  public long CCU;
  public String uwq;
  public int vdk;
  
  public k(String paramString, int paramInt, long paramLong, List<a.ao> paramList)
  {
    AppMethodBeat.i(183709);
    b.d("MicroMsg.Voip", new Object[] { this.TAG2, "NetSceneSubscribeGeneralVideo" });
    a.i locali = new a.i();
    try
    {
      locali.groupId = paramString;
      this.uwq = paramString;
      locali.roomId = paramInt;
      this.vdk = paramInt;
      locali.uXg = paramLong;
      this.CCU = paramLong;
      i = paramList.size();
      arrayOfao = null;
      if (i > 0)
      {
        arrayOfao = new a.ao[i];
        paramInt = 0;
        while (paramInt < i)
        {
          arrayOfao[paramInt] = ((a.ao)paramList.get(paramInt));
          paramInt += 1;
        }
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        int i;
        a.ao[] arrayOfao;
        b.w(this.TAG2, new Object[] { "NetSceneSubscribeGeneralVideo constructor", paramString });
      }
    }
    locali.Mdo = arrayOfao;
    locali.timestamp = System.currentTimeMillis();
    b.i("MicroMsg.Voip", new Object[] { "roomId: %d, roomKey: %d, groupId: %s, timestamp: %d, memberCnt: %d", Integer.valueOf(locali.roomId), Long.valueOf(locali.uXg), locali.groupId, Long.valueOf(locali.timestamp), Integer.valueOf(i) });
    this.mNetType = 3;
    this.Mcu = c.gdW().bbF(paramString);
    c(257, locali);
    AppMethodBeat.o(183709);
  }
  
  public final Object cL(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(183710);
    b.d("MicroMsg.Voip", new Object[] { this.TAG2, "data2Resp" });
    if (paramArrayOfByte != null) {}
    for (;;)
    {
      try
      {
        paramArrayOfByte = (a.ag)e.a(new a.ag(), paramArrayOfByte, paramArrayOfByte.length);
        AppMethodBeat.o(183710);
        return paramArrayOfByte;
      }
      catch (Exception paramArrayOfByte)
      {
        b.w(this.TAG2, new Object[] { "data2Resp", paramArrayOfByte.getMessage() });
        paramArrayOfByte = null;
        continue;
      }
      paramArrayOfByte = null;
    }
  }
  
  public final String fXq()
  {
    return "CsCmd.Cmd_V_CSSubscribeGeneralVideoReq";
  }
  
  public final int getType()
  {
    return 801;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.wecall.talkroom.a.k
 * JD-Core Version:    0.7.0.1
 */