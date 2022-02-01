package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.b.a.a.a.ad;
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
      localf.GXO = paramInt1;
      localf.GXP = paramLong;
      localf.bDZ = paramInt2;
      this.mNetType = 2;
      this.RCJ = c.hqY().brj(paramString);
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
  
  public final Object cO(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(62537);
    if (paramArrayOfByte != null) {}
    for (;;)
    {
      try
      {
        paramArrayOfByte = (a.ad)e.a(new a.ad(), paramArrayOfByte, paramArrayOfByte.length);
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
  
  public final int getType()
  {
    return 203;
  }
  
  public final String hiV()
  {
    return "CsCmd.Cmd_V_CSExitVoiceRoomReq";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.wecall.talkroom.a.f
 * JD-Core Version:    0.7.0.1
 */