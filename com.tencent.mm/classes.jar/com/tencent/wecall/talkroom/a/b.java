package com.tencent.wecall.talkroom.a;

import com.google.b.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.b.a.a.a.a;
import com.tencent.pb.common.b.a.a.a.y;
import com.tencent.pb.common.b.d;
import com.tencent.wecall.talkroom.model.c;

public final class b
  extends d
{
  public long CCU;
  public String uwq;
  public int vdk;
  
  public b(String paramString, int paramInt, long paramLong, String[] paramArrayOfString)
  {
    AppMethodBeat.i(62533);
    com.tencent.pb.common.c.b.d("MicroMsg.Voip", new Object[] { this.TAG2, "addmember", paramString });
    a.a locala = new a.a();
    try
    {
      locala.groupId = paramString;
      this.uwq = paramString;
      locala.Cuf = paramInt;
      this.vdk = paramInt;
      locala.Cug = paramLong;
      this.CCU = paramLong;
      locala.McY = paramArrayOfString;
      locala.Cuf = paramInt;
      this.mNetType = 3;
      this.Mcu = c.gdW().bbF(paramString);
      c(145, locala);
      AppMethodBeat.o(62533);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        com.tencent.pb.common.c.b.w(this.TAG2, new Object[] { "NetSceneAddVoiceGroupMember constructor", paramString });
      }
    }
  }
  
  public final Object cL(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(62534);
    if (paramArrayOfByte != null) {}
    for (;;)
    {
      try
      {
        paramArrayOfByte = (a.y)e.a(new a.y(), paramArrayOfByte, paramArrayOfByte.length);
        AppMethodBeat.o(62534);
        return paramArrayOfByte;
      }
      catch (Exception paramArrayOfByte)
      {
        com.tencent.pb.common.c.b.w(this.TAG2, new Object[] { "data2Resp", paramArrayOfByte.getMessage() });
        paramArrayOfByte = null;
        continue;
      }
      paramArrayOfByte = null;
    }
  }
  
  public final String fXq()
  {
    return "CsCmd.Cmd_V_CSAddVoiceGroupMemberReq";
  }
  
  public final int getType()
  {
    return 204;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.wecall.talkroom.a.b
 * JD-Core Version:    0.7.0.1
 */