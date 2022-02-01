package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.b.a.a.a.ai;
import com.tencent.pb.common.b.a.a.a.ar;
import com.tencent.pb.common.b.a.a.a.j;
import com.tencent.pb.common.b.d;
import com.tencent.pb.common.c.b;
import com.tencent.wecall.talkroom.model.c;
import java.util.List;

public final class k
  extends d
{
  public long HgX;
  public String xOr;
  public int yvK;
  
  public k(String paramString, int paramInt, long paramLong, List<a.ar> paramList)
  {
    AppMethodBeat.i(183709);
    b.d("MicroMsg.Voip", new Object[] { this.TAG2, "NetSceneSubscribeGeneralVideo" });
    a.j localj = new a.j();
    try
    {
      localj.groupId = paramString;
      this.xOr = paramString;
      localj.roomId = paramInt;
      this.yvK = paramInt;
      localj.ypH = paramLong;
      this.HgX = paramLong;
      i = paramList.size();
      arrayOfar = null;
      if (i > 0)
      {
        arrayOfar = new a.ar[i];
        paramInt = 0;
        while (paramInt < i)
        {
          arrayOfar[paramInt] = ((a.ar)paramList.get(paramInt));
          paramInt += 1;
        }
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        int i;
        a.ar[] arrayOfar;
        b.w(this.TAG2, new Object[] { "NetSceneSubscribeGeneralVideo constructor", paramString });
      }
    }
    localj.RDE = arrayOfar;
    localj.timestamp = System.currentTimeMillis();
    b.i("MicroMsg.Voip", new Object[] { "roomId: %d, roomKey: %d, groupId: %s, timestamp: %d, memberCnt: %d", Integer.valueOf(localj.roomId), Long.valueOf(localj.ypH), localj.groupId, Long.valueOf(localj.timestamp), Integer.valueOf(i) });
    this.mNetType = 3;
    this.RCJ = c.hqY().brj(paramString);
    c(257, localj);
    AppMethodBeat.o(183709);
  }
  
  public final Object cO(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(183710);
    b.d("MicroMsg.Voip", new Object[] { this.TAG2, "data2Resp" });
    if (paramArrayOfByte != null) {}
    for (;;)
    {
      try
      {
        paramArrayOfByte = (a.ai)e.a(new a.ai(), paramArrayOfByte, paramArrayOfByte.length);
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
  
  public final int getType()
  {
    return 801;
  }
  
  public final String hiV()
  {
    return "CsCmd.Cmd_V_CSSubscribeGeneralVideoReq";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.wecall.talkroom.a.k
 * JD-Core Version:    0.7.0.1
 */