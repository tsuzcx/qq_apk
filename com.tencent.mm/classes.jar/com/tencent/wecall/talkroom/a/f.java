package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.b.a.a.ab;
import com.tencent.pb.common.b.a.a.f;
import com.tencent.pb.common.b.d;

public final class f
  extends d
{
  public f(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(128018);
    com.tencent.pb.common.c.c.d("MicroMsg.Voip", new Object[] { this.TAG2, "eixt", paramString, Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(paramInt2) });
    a.f localf = new a.f();
    try
    {
      localf.groupId = paramString;
      localf.twP = paramInt1;
      localf.twQ = paramLong;
      localf.aXG = paramInt2;
      this.mNetType = 2;
      this.Bda = com.tencent.wecall.talkroom.model.c.dXv().axs(paramString);
      c(143, localf);
      AppMethodBeat.o(128018);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        com.tencent.pb.common.c.c.w(this.TAG2, new Object[] { "NetSceneExitVoiceRoom constructor", paramString });
      }
    }
  }
  
  public final Object ck(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(128019);
    if (paramArrayOfByte != null) {}
    for (;;)
    {
      try
      {
        paramArrayOfByte = (a.ab)e.a(new a.ab(), paramArrayOfByte, paramArrayOfByte.length);
        AppMethodBeat.o(128019);
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
    return "CsCmd.Cmd_V_CSExitVoiceRoomReq";
  }
  
  public final int getType()
  {
    return 203;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.wecall.talkroom.a.f
 * JD-Core Version:    0.7.0.1
 */