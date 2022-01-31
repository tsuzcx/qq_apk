package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.pb.common.b.a.a.ak;
import com.tencent.pb.common.b.a.a.l;
import com.tencent.pb.common.b.d;

public final class m
  extends d
{
  public String kWU;
  public int lvU;
  public long xdR;
  
  public m(String paramString, int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    com.tencent.pb.common.c.c.d("MicroMsg.Voip", new Object[] { this.TAG2, "hello", paramString, Integer.valueOf(paramInt1), Long.valueOf(paramLong) });
    a.l locall = new a.l();
    locall.wGw = paramInt3;
    locall.pRI = paramInt1;
    this.lvU = paramInt1;
    locall.pRJ = paramLong;
    this.xdR = paramLong;
    locall.groupId = paramString;
    this.kWU = paramString;
    locall.iEo = paramInt2;
    this.wFz = 3;
    try
    {
      this.wFA = com.tencent.wecall.talkroom.model.c.cRC().agy(paramString);
      c(147, locall);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        com.tencent.pb.common.c.c.x(this.TAG2, new Object[] { "NetSceneVoiceRoomHello constructor", paramString });
      }
    }
  }
  
  protected final Object bK(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {
      try
      {
        paramArrayOfByte = (a.ak)e.a(new a.ak(), paramArrayOfByte, paramArrayOfByte.length);
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
    return "CsCmd.Cmd_V_CSVoiceRoomHelloReq";
  }
  
  public final int getType()
  {
    return 205;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.wecall.talkroom.a.m
 * JD-Core Version:    0.7.0.1
 */