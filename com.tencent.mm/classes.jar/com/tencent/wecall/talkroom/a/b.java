package com.tencent.wecall.talkroom.a;

import com.google.b.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.b.a.a.a.a;
import com.tencent.pb.common.b.a.a.a.z;
import com.tencent.pb.common.b.d;
import com.tencent.wecall.talkroom.model.c;

public final class b
  extends d
{
  public String CSB;
  public int DVO;
  public long NXM;
  
  public b(String paramString, int paramInt, long paramLong, String[] paramArrayOfString)
  {
    AppMethodBeat.i(62533);
    com.tencent.pb.common.c.b.d("MicroMsg.Voip", new Object[] { this.TAG2, "addmember", paramString });
    a.a locala = new a.a();
    try
    {
      locala.groupId = paramString;
      this.CSB = paramString;
      locala.NOc = paramInt;
      this.DVO = paramInt;
      locala.NOd = paramLong;
      this.NXM = paramLong;
      locala.ZeP = paramArrayOfString;
      locala.NOc = paramInt;
      aAc(3);
      aAd(c.iuI().bEi(paramString));
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
  
  public final Object dn(byte[] paramArrayOfByte)
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
  
  public final String ikF()
  {
    return "CsCmd.Cmd_V_CSAddVoiceGroupMemberReq";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.wecall.talkroom.a.b
 * JD-Core Version:    0.7.0.1
 */