package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.b.a.a.a.ah;
import com.tencent.pb.common.b.a.a.a.aq;
import com.tencent.pb.common.b.a.a.a.i;
import com.tencent.pb.common.b.d;
import com.tencent.pb.common.c.b;
import com.tencent.wecall.talkroom.model.c;
import java.util.List;

public final class m
  extends d
{
  public long HgX;
  public String xOr;
  public int yvK;
  
  public m(String paramString, int paramInt, long paramLong, List<a.aq> paramList)
  {
    AppMethodBeat.i(199661);
    b.d("MicroMsg.Voip", new Object[] { this.TAG2, "NetSceneSubscribeScreenSharingVideo" });
    a.i locali = new a.i();
    try
    {
      locali.groupId = paramString;
      this.xOr = paramString;
      locali.roomId = paramInt;
      this.yvK = paramInt;
      locali.ypH = paramLong;
      this.HgX = paramLong;
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
        b.w(this.TAG2, new Object[] { "NetSceneSubscribeScreenSharingVideo constructor", paramString });
      }
    }
    locali.RDD = arrayOfaq;
    locali.timestamp = System.currentTimeMillis();
    b.i("MicroMsg.Voip", new Object[] { "roomId: %d, roomKey: %d, groupId: %s, timestamp: %d, memberCnt: %d", Integer.valueOf(locali.roomId), Long.valueOf(locali.ypH), locali.groupId, Long.valueOf(locali.timestamp), Integer.valueOf(i) });
    this.mNetType = 3;
    this.RCJ = c.hqY().brj(paramString);
    c(259, locali);
    AppMethodBeat.o(199661);
  }
  
  public final Object cO(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(199662);
    b.d("MicroMsg.Voip", new Object[] { this.TAG2, "data2Resp" });
    if (paramArrayOfByte != null) {}
    for (;;)
    {
      try
      {
        paramArrayOfByte = (a.ah)e.a(new a.ah(), paramArrayOfByte, paramArrayOfByte.length);
        AppMethodBeat.o(199662);
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
    return 802;
  }
  
  public final String hiV()
  {
    return "CsCmd.Cmd_V_CSSubscribeScreenSharingVideoReq";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.wecall.talkroom.a.m
 * JD-Core Version:    0.7.0.1
 */