package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.b.a.a.a;
import com.tencent.pb.common.b.a.a.x;
import com.tencent.pb.common.b.d;

public final class b
  extends d
{
  public int nTj;
  public String nuW;
  public long tFh;
  
  public b(String paramString, int paramInt, long paramLong, String[] paramArrayOfString)
  {
    AppMethodBeat.i(128009);
    com.tencent.pb.common.c.c.d("MicroMsg.Voip", new Object[] { this.TAG2, "addmember", paramString });
    a.a locala = new a.a();
    try
    {
      locala.groupId = paramString;
      this.nuW = paramString;
      locala.twP = paramInt;
      this.nTj = paramInt;
      locala.twQ = paramLong;
      this.tFh = paramLong;
      locala.BdF = paramArrayOfString;
      locala.twP = paramInt;
      this.mNetType = 3;
      this.Bda = com.tencent.wecall.talkroom.model.c.dXv().axs(paramString);
      c(145, locala);
      AppMethodBeat.o(128009);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        com.tencent.pb.common.c.c.w(this.TAG2, new Object[] { "NetSceneAddVoiceGroupMember constructor", paramString });
      }
    }
  }
  
  public final Object ck(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(128010);
    if (paramArrayOfByte != null) {}
    for (;;)
    {
      try
      {
        paramArrayOfByte = (a.x)e.a(new a.x(), paramArrayOfByte, paramArrayOfByte.length);
        AppMethodBeat.o(128010);
        return paramArrayOfByte;
      }
      catch (Exception paramArrayOfByte)
      {
        com.tencent.pb.common.c.c.w(this.TAG2, new Object[] { "data2Resp", paramArrayOfByte.getMessage() });
        paramArrayOfByte = null;
        continue;
      }
      paramArrayOfByte = null;
    }
  }
  
  public final String dTD()
  {
    return "CsCmd.Cmd_V_CSAddVoiceGroupMemberReq";
  }
  
  public final int getType()
  {
    return 204;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.wecall.talkroom.a.b
 * JD-Core Version:    0.7.0.1
 */