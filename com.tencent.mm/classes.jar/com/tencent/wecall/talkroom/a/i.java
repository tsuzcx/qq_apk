package com.tencent.wecall.talkroom.a;

import com.google.d.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.b.a.a.a.af;
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
      localg.UAZ = paramInt1;
      localg.UBa = paramLong;
      localg.reason = paramInt2;
      aGP(3);
      aGQ(c.ked().bGH(paramString));
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
  
  public final Object dp(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(62527);
    b.d("MicroMsg.Voip", new Object[] { this.TAG2, "data2Resp" });
    if (paramArrayOfByte != null) {}
    for (;;)
    {
      try
      {
        paramArrayOfByte = (a.af)e.a(new a.af(), paramArrayOfByte, paramArrayOfByte.length);
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
  
  public final int getType()
  {
    return 207;
  }
  
  public final String jQW()
  {
    return "CsCmd.Cmd_V_CSRejectEnterVoiceRoomReq";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.wecall.talkroom.a.i
 * JD-Core Version:    0.7.0.1
 */