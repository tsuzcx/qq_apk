package com.tencent.wecall.talkroom.a;

import com.google.b.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.b.a.a.a.ae;
import com.tencent.pb.common.b.a.a.a.g;
import com.tencent.pb.common.b.d;
import com.tencent.pb.common.c.b;
import com.tencent.wecall.talkroom.model.c;

public final class i
  extends d
{
  public i(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(62526);
    b.d("MicroMsg.Voip", new Object[] { this.TAG2, "NetSceneRejectVoiceGroup" });
    a.g localg = new a.g();
    try
    {
      localg.groupId = paramString;
      localg.Cuf = paramInt1;
      localg.Cug = paramLong;
      localg.reason = paramInt2;
      this.mNetType = 3;
      this.Mcu = c.gdW().bbF(paramString);
      c(181, localg);
      AppMethodBeat.o(62526);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        b.w(this.TAG2, new Object[] { "NetSceneRejectVoiceGroup constructor", paramString });
      }
    }
  }
  
  public final Object cL(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(62527);
    b.d("MicroMsg.Voip", new Object[] { this.TAG2, "data2Resp" });
    if (paramArrayOfByte != null) {}
    for (;;)
    {
      try
      {
        paramArrayOfByte = (a.ae)e.a(new a.ae(), paramArrayOfByte, paramArrayOfByte.length);
        AppMethodBeat.o(62527);
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
  
  public final String fXq()
  {
    return "CsCmd.Cmd_V_CSRejectEnterVoiceRoomReq";
  }
  
  public final int getType()
  {
    return 207;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.wecall.talkroom.a.i
 * JD-Core Version:    0.7.0.1
 */