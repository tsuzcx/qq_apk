package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.pb.common.b.a.a.a;
import com.tencent.pb.common.b.a.a.x;
import com.tencent.pb.common.b.d;

public final class b
  extends d
{
  public String kWU;
  public int lvU;
  public long xdR;
  
  public b(String paramString, int paramInt, long paramLong, String[] paramArrayOfString)
  {
    com.tencent.pb.common.c.c.d("MicroMsg.Voip", new Object[] { this.TAG2, "addmember", paramString });
    a.a locala = new a.a();
    try
    {
      locala.groupId = paramString;
      this.kWU = paramString;
      locala.pRI = paramInt;
      this.lvU = paramInt;
      locala.pRJ = paramLong;
      this.xdR = paramLong;
      locala.wGe = paramArrayOfString;
      locala.pRI = paramInt;
      this.wFz = 3;
      this.wFA = com.tencent.wecall.talkroom.model.c.cRC().agy(paramString);
      c(145, locala);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        com.tencent.pb.common.c.c.x(this.TAG2, new Object[] { "NetSceneAddVoiceGroupMember constructor", paramString });
      }
    }
  }
  
  protected final Object bK(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {
      try
      {
        paramArrayOfByte = (a.x)e.a(new a.x(), paramArrayOfByte, paramArrayOfByte.length);
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
    return "CsCmd.Cmd_V_CSAddVoiceGroupMemberReq";
  }
  
  public final int getType()
  {
    return 204;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.wecall.talkroom.a.b
 * JD-Core Version:    0.7.0.1
 */