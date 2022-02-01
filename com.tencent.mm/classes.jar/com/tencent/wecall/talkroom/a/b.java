package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.b.a.a.a.a;
import com.tencent.pb.common.b.a.a.a.z;
import com.tencent.pb.common.b.d;
import com.tencent.wecall.talkroom.model.c;

public final class b
  extends d
{
  public long HgX;
  public String xOr;
  public int yvK;
  
  public b(String paramString, int paramInt, long paramLong, String[] paramArrayOfString)
  {
    AppMethodBeat.i(62533);
    com.tencent.pb.common.c.b.d("MicroMsg.Voip", new Object[] { this.TAG2, "addmember", paramString });
    a.a locala = new a.a();
    try
    {
      locala.groupId = paramString;
      this.xOr = paramString;
      locala.GXO = paramInt;
      this.yvK = paramInt;
      locala.GXP = paramLong;
      this.HgX = paramLong;
      locala.RDn = paramArrayOfString;
      locala.GXO = paramInt;
      this.mNetType = 3;
      this.RCJ = c.hqY().brj(paramString);
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
  
  public final Object cO(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(62534);
    if (paramArrayOfByte != null) {}
    for (;;)
    {
      try
      {
        paramArrayOfByte = (a.z)e.a(new a.z(), paramArrayOfByte, paramArrayOfByte.length);
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
  
  public final int getType()
  {
    return 204;
  }
  
  public final String hiV()
  {
    return "CsCmd.Cmd_V_CSAddVoiceGroupMemberReq";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.wecall.talkroom.a.b
 * JD-Core Version:    0.7.0.1
 */