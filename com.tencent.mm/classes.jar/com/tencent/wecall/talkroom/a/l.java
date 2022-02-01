package com.tencent.wecall.talkroom.a;

import com.google.d.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.b.a.a.a.ah;
import com.tencent.pb.common.b.a.a.a.ap;
import com.tencent.pb.common.b.a.a.a.i;
import com.tencent.pb.common.b.d;
import com.tencent.pb.common.c.b;
import com.tencent.wecall.talkroom.model.c;
import java.util.List;

public final class l
  extends d
{
  public String IMR;
  public int JMX;
  public long UGt;
  
  public l(String paramString, int paramInt, long paramLong, List<a.ap> paramList)
  {
    AppMethodBeat.i(212274);
    b.d("MicroMsg.Voip", new Object[] { this.TAG2, "NetSceneSubscribeScreenSharingVideo" });
    a.i locali = new a.i();
    try
    {
      locali.groupId = paramString;
      this.IMR = paramString;
      locali.roomId = paramInt;
      this.JMX = paramInt;
      locali.Hnt = paramLong;
      this.UGt = paramLong;
      i = paramList.size();
      arrayOfap = null;
      if (i > 0)
      {
        arrayOfap = new a.ap[i];
        paramInt = 0;
        while (paramInt < i)
        {
          arrayOfap[paramInt] = ((a.ap)paramList.get(paramInt));
          paramInt += 1;
        }
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        int i;
        a.ap[] arrayOfap;
        b.w(this.TAG2, new Object[] { "NetSceneSubscribeScreenSharingVideo constructor", paramString });
      }
    }
    locali.ahdI = arrayOfap;
    locali.timestamp = System.currentTimeMillis();
    b.i("MicroMsg.Voip", new Object[] { "roomId: %d, roomKey: %d, groupId: %s, timestamp: %d, memberCnt: %d", Integer.valueOf(locali.roomId), Long.valueOf(locali.Hnt), locali.groupId, Long.valueOf(locali.timestamp), Integer.valueOf(i) });
    aGP(3);
    aGQ(c.ked().bGH(paramString));
    c(259, locali);
    AppMethodBeat.o(212274);
  }
  
  public final Object dp(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(212276);
    b.d("MicroMsg.Voip", new Object[] { this.TAG2, "data2Resp" });
    if (paramArrayOfByte != null) {}
    for (;;)
    {
      try
      {
        paramArrayOfByte = (a.ah)e.a(new a.ah(), paramArrayOfByte, paramArrayOfByte.length);
        AppMethodBeat.o(212276);
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
  
  public final String jQW()
  {
    return "CsCmd.Cmd_V_CSSubscribeScreenSharingVideoReq";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.wecall.talkroom.a.l
 * JD-Core Version:    0.7.0.1
 */