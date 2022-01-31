package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.pb.common.b.a.a.ab;
import com.tencent.pb.common.b.a.a.f;
import com.tencent.pb.common.b.d;

public final class f
  extends d
{
  public f(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    com.tencent.pb.common.c.c.d("MicroMsg.Voip", new Object[] { this.TAG2, "eixt", paramString, Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(paramInt2) });
    a.f localf = new a.f();
    try
    {
      localf.groupId = paramString;
      localf.pRI = paramInt1;
      localf.pRJ = paramLong;
      localf.aQw = paramInt2;
      this.wFz = 2;
      this.wFA = com.tencent.wecall.talkroom.model.c.cRC().agy(paramString);
      c(143, localf);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        com.tencent.pb.common.c.c.x(this.TAG2, new Object[] { "NetSceneExitVoiceRoom constructor", paramString });
      }
    }
  }
  
  protected final Object bK(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {
      try
      {
        paramArrayOfByte = (a.ab)e.a(new a.ab(), paramArrayOfByte, paramArrayOfByte.length);
        return paramArrayOfByte;
      }
      catch (Exception paramArrayOfByte)
      {
        com.tencent.pb.common.c.c.x(this.TAG2, new Object[] { "data2Resp", paramArrayOfByte.getMessage() });
        return null;
      }
    }
    return null;
  }
  
  protected final String cNR()
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