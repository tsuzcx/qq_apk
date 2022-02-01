package com.tencent.wecall.talkroom.a;

import com.google.b.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.b.a.a.a.al;
import com.tencent.pb.common.b.a.a.a.l;
import com.tencent.pb.common.b.d;
import com.tencent.pb.common.c.b;
import com.tencent.wecall.talkroom.model.k;

public final class h
  extends d
{
  public String groupId;
  public int roomId;
  public long tIG;
  
  public h(String paramString, int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(175625);
    b.d("MicroMsg.Voip", new Object[] { this.TAG2, "NetSceneRejectVoiceGroup" });
    a.l locall = new a.l();
    for (;;)
    {
      try
      {
        locall.groupId = paramString;
        locall.ADE = paramInt1;
        locall.ADF = paramLong;
        locall.osF = paramInt2;
        locall.JMs = 2;
        locall.netType = k.lf(com.tencent.pb.common.c.c.AMx);
        if (paramInt3 != 0) {
          continue;
        }
        locall.JMD = 0;
        b.w(this.TAG2, new Object[] { "NetSceneRedirect redirect type:", Integer.valueOf(locall.JMD) });
        this.mNetType = 3;
        this.JLH = com.tencent.wecall.talkroom.model.c.fIe().aUe(paramString);
      }
      catch (Exception paramString)
      {
        b.w(this.TAG2, new Object[] { "NetSceneRedirect constructor", paramString });
        continue;
      }
      c(211, locall);
      AppMethodBeat.o(175625);
      return;
      locall.JMD = 1;
    }
  }
  
  public final Object cB(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(62546);
    b.d("MicroMsg.Voip", new Object[] { this.TAG2, "data2Resp" });
    if (paramArrayOfByte != null) {}
    for (;;)
    {
      try
      {
        paramArrayOfByte = (a.al)e.a(new a.al(), paramArrayOfByte, paramArrayOfByte.length);
        AppMethodBeat.o(62546);
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
  
  public final String fBB()
  {
    return "CsCmd.Cmd_V_CSVoiceRedirectReq";
  }
  
  public final int getType()
  {
    return 211;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.wecall.talkroom.a.h
 * JD-Core Version:    0.7.0.1
 */