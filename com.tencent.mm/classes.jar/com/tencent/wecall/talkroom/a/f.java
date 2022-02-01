package com.tencent.wecall.talkroom.a;

import com.google.b.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.b.a.a.a.ac;
import com.tencent.pb.common.b.a.a.a.f;
import com.tencent.pb.common.b.d;
import com.tencent.pb.common.c.b;
import com.tencent.wecall.talkroom.model.c;

public final class f
  extends d
{
  public f(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(62536);
    b.d("MicroMsg.Voip", new Object[] { this.TAG2, "eixt", paramString, Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(paramInt2) });
    a.f localf = new a.f();
    try
    {
      localf.groupId = paramString;
      localf.CcE = paramInt1;
      localf.CcF = paramLong;
      localf.reason = paramInt2;
      this.mNetType = 2;
      this.LFq = c.fZv().bac(paramString);
      c(143, localf);
      AppMethodBeat.o(62536);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        b.w(this.TAG2, new Object[] { "NetSceneExitVoiceRoom constructor", paramString });
      }
    }
  }
  
  public final Object cI(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(62537);
    if (paramArrayOfByte != null) {}
    for (;;)
    {
      try
      {
        paramArrayOfByte = (a.ac)e.a(new a.ac(), paramArrayOfByte, paramArrayOfByte.length);
        AppMethodBeat.o(62537);
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
  
  public final String fSQ()
  {
    return "CsCmd.Cmd_V_CSExitVoiceRoomReq";
  }
  
  public final int getType()
  {
    return 203;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.wecall.talkroom.a.f
 * JD-Core Version:    0.7.0.1
 */