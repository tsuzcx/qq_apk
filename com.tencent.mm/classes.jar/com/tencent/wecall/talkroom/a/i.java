package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.b.a.a.ad;
import com.tencent.pb.common.b.a.a.g;
import com.tencent.pb.common.b.d;

public final class i
  extends d
{
  public i(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(128023);
    com.tencent.pb.common.c.c.d("MicroMsg.Voip", new Object[] { this.TAG2, "NetSceneRejectVoiceGroup" });
    a.g localg = new a.g();
    try
    {
      localg.groupId = paramString;
      localg.twP = paramInt1;
      localg.twQ = paramLong;
      localg.aXG = paramInt2;
      this.mNetType = 3;
      this.Bda = com.tencent.wecall.talkroom.model.c.dXv().axs(paramString);
      c(181, localg);
      AppMethodBeat.o(128023);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        com.tencent.pb.common.c.c.w(this.TAG2, new Object[] { "NetSceneRejectVoiceGroup constructor", paramString });
      }
    }
  }
  
  public final Object ck(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(128024);
    com.tencent.pb.common.c.c.d("MicroMsg.Voip", new Object[] { this.TAG2, "data2Resp" });
    if (paramArrayOfByte != null) {}
    for (;;)
    {
      try
      {
        paramArrayOfByte = (a.ad)e.a(new a.ad(), paramArrayOfByte, paramArrayOfByte.length);
        AppMethodBeat.o(128024);
        return paramArrayOfByte;
      }
      catch (Exception paramArrayOfByte)
      {
        com.tencent.pb.common.c.c.w(this.TAG2, new Object[] { "data2Resp", paramArrayOfByte.getMessage() });
        paramArrayOfByte = null;
        continue;
      }
      paramArrayOfByte = null;
    }
  }
  
  public final String dTD()
  {
    return "CsCmd.Cmd_V_CSRejectEnterVoiceRoomReq";
  }
  
  public final int getType()
  {
    return 207;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.wecall.talkroom.a.i
 * JD-Core Version:    0.7.0.1
 */