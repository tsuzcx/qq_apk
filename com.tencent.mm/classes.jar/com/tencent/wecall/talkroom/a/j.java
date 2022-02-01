package com.tencent.wecall.talkroom.a;

import com.google.b.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.b.a.a.a.ai;
import com.tencent.pb.common.b.a.a.a.aq;
import com.tencent.pb.common.b.a.a.a.j;
import com.tencent.pb.common.b.d;
import com.tencent.pb.common.c.b;
import com.tencent.wecall.talkroom.model.c;
import java.util.List;

public final class j
  extends d
{
  public String CSB;
  public int DVO;
  public long NXM;
  
  public j(String paramString, int paramInt, long paramLong, List<a.aq> paramList)
  {
    AppMethodBeat.i(183709);
    b.d("MicroMsg.Voip", new Object[] { this.TAG2, "NetSceneSubscribeGeneralVideo" });
    a.j localj = new a.j();
    try
    {
      localj.groupId = paramString;
      this.CSB = paramString;
      localj.roomId = paramInt;
      this.DVO = paramInt;
      localj.DPJ = paramLong;
      this.NXM = paramLong;
      i = paramList.size();
      arrayOfaq = null;
      if (i > 0)
      {
        arrayOfaq = new a.aq[i];
        paramInt = 0;
        while (paramInt < i)
        {
          arrayOfaq[paramInt] = ((a.aq)paramList.get(paramInt));
          paramInt += 1;
        }
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        int i;
        a.aq[] arrayOfaq;
        b.w(this.TAG2, new Object[] { "NetSceneSubscribeGeneralVideo constructor", paramString });
      }
    }
    localj.Zfg = arrayOfaq;
    localj.timestamp = System.currentTimeMillis();
    b.i("MicroMsg.Voip", new Object[] { "roomId: %d, roomKey: %d, groupId: %s, timestamp: %d, memberCnt: %d", Integer.valueOf(localj.roomId), Long.valueOf(localj.DPJ), localj.groupId, Long.valueOf(localj.timestamp), Integer.valueOf(i) });
    aAc(3);
    aAd(c.iuI().bEi(paramString));
    c(257, localj);
    AppMethodBeat.o(183709);
  }
  
  public final Object dn(byte[] paramArrayOfByte)
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
  
  public final String ikF()
  {
    return "CsCmd.Cmd_V_CSSubscribeGeneralVideoReq";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.wecall.talkroom.a.j
 * JD-Core Version:    0.7.0.1
 */