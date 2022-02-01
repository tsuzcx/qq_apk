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
  public int sHe;
  public String seB;
  public long ztl;
  
  public b(String paramString, int paramInt, long paramLong, String[] paramArrayOfString)
  {
    AppMethodBeat.i(62533);
    com.tencent.pb.common.c.b.d("MicroMsg.Voip", new Object[] { this.TAG2, "addmember", paramString });
    a.a locala = new a.a();
    try
    {
      locala.groupId = paramString;
      this.seB = paramString;
      locala.zkT = paramInt;
      this.sHe = paramInt;
      locala.zkU = paramLong;
      this.ztl = paramLong;
      locala.IkA = paramArrayOfString;
      locala.zkT = paramInt;
      this.mNetType = 3;
      this.IjW = c.fpJ().aOs(paramString);
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
  
  public final Object cC(byte[] paramArrayOfByte)
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
  
  public final String flk()
  {
    return "CsCmd.Cmd_V_CSAddVoiceGroupMemberReq";
  }
  
  public final int getType()
  {
    return 204;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.wecall.talkroom.a.b
 * JD-Core Version:    0.7.0.1
 */