package com.tencent.wecall.talkroom.a;

import com.google.d.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.b.a.a.a.am;
import com.tencent.pb.common.b.a.a.a.m;
import com.tencent.pb.common.b.d;
import com.tencent.pb.common.c.b;
import com.tencent.wecall.talkroom.model.j;

public final class h
  extends d
{
  public long Hnt;
  public String groupId;
  public int roomId;
  
  public h(String paramString, int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(175625);
    b.d("MicroMsg.Voip", new Object[] { this.TAG2, "NetSceneRejectVoiceGroup" });
    a.m localm = new a.m();
    for (;;)
    {
      try
      {
        localm.groupId = paramString;
        localm.UAZ = paramInt1;
        localm.UBa = paramLong;
        localm.wTC = paramInt2;
        localm.ahdz = 2;
        localm.netType = j.oL(com.tencent.pb.common.c.c.UMe);
        if (paramInt3 != 0) {
          continue;
        }
        localm.ahdP = 0;
        b.w(this.TAG2, new Object[] { "NetSceneRedirect redirect type:", Integer.valueOf(localm.ahdP) });
        aGP(3);
        aGQ(com.tencent.wecall.talkroom.model.c.ked().bGH(paramString));
      }
      catch (Exception paramString)
      {
        b.w(this.TAG2, new Object[] { "NetSceneRedirect constructor", paramString });
        continue;
      }
      c(211, localm);
      AppMethodBeat.o(175625);
      return;
      localm.ahdP = 1;
    }
  }
  
  public final Object dp(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(62546);
    b.d("MicroMsg.Voip", new Object[] { this.TAG2, "data2Resp" });
    if (paramArrayOfByte != null) {}
    for (;;)
    {
      try
      {
        paramArrayOfByte = (a.am)e.a(new a.am(), paramArrayOfByte, paramArrayOfByte.length);
        AppMethodBeat.o(62546);
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
    return 211;
  }
  
  public final String jQW()
  {
    return "CsCmd.Cmd_V_CSVoiceRedirectReq";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.wecall.talkroom.a.h
 * JD-Core Version:    0.7.0.1
 */