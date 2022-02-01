package com.tencent.wecall.talkroom.a;

import com.google.b.a.e;
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
  public String CSB;
  public int DVO;
  public long NXM;
  
  public l(String paramString, int paramInt, long paramLong, List<a.ap> paramList)
  {
    AppMethodBeat.i(209868);
    b.d("MicroMsg.Voip", new Object[] { this.TAG2, "NetSceneSubscribeScreenSharingVideo" });
    a.i locali = new a.i();
    try
    {
      locali.groupId = paramString;
      this.CSB = paramString;
      locali.roomId = paramInt;
      this.DVO = paramInt;
      locali.DPJ = paramLong;
      this.NXM = paramLong;
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
    locali.Zff = arrayOfap;
    locali.timestamp = System.currentTimeMillis();
    b.i("MicroMsg.Voip", new Object[] { "roomId: %d, roomKey: %d, groupId: %s, timestamp: %d, memberCnt: %d", Integer.valueOf(locali.roomId), Long.valueOf(locali.DPJ), locali.groupId, Long.valueOf(locali.timestamp), Integer.valueOf(i) });
    aAc(3);
    aAd(c.iuI().bEi(paramString));
    c(259, locali);
    AppMethodBeat.o(209868);
  }
  
  public final Object dn(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(209869);
    b.d("MicroMsg.Voip", new Object[] { this.TAG2, "data2Resp" });
    if (paramArrayOfByte != null) {}
    for (;;)
    {
      try
      {
        paramArrayOfByte = (a.ah)e.a(new a.ah(), paramArrayOfByte, paramArrayOfByte.length);
        AppMethodBeat.o(209869);
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
  
  public final String ikF()
  {
    return "CsCmd.Cmd_V_CSSubscribeScreenSharingVideoReq";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.wecall.talkroom.a.l
 * JD-Core Version:    0.7.0.1
 */