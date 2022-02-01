package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.b.a.a.a.an;
import com.tencent.pb.common.b.a.a.a.m;
import com.tencent.pb.common.b.d;
import com.tencent.pb.common.c.b;
import com.tencent.wecall.talkroom.model.k;

public final class h
  extends d
{
  public String groupId;
  public int roomId;
  public long ypH;
  
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
        localm.GXO = paramInt1;
        localm.GXP = paramLong;
        localm.qrD = paramInt2;
        localm.RDu = 2;
        localm.netType = k.lx(com.tencent.pb.common.c.c.Hhs);
        if (paramInt3 != 0) {
          continue;
        }
        localm.RDG = 0;
        b.w(this.TAG2, new Object[] { "NetSceneRedirect redirect type:", Integer.valueOf(localm.RDG) });
        this.mNetType = 3;
        this.RCJ = com.tencent.wecall.talkroom.model.c.hqY().brj(paramString);
      }
      catch (Exception paramString)
      {
        b.w(this.TAG2, new Object[] { "NetSceneRedirect constructor", paramString });
        continue;
      }
      c(211, localm);
      AppMethodBeat.o(175625);
      return;
      localm.RDG = 1;
    }
  }
  
  public final Object cO(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(62546);
    b.d("MicroMsg.Voip", new Object[] { this.TAG2, "data2Resp" });
    if (paramArrayOfByte != null) {}
    for (;;)
    {
      try
      {
        paramArrayOfByte = (a.an)e.a(new a.an(), paramArrayOfByte, paramArrayOfByte.length);
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
  
  public final String hiV()
  {
    return "CsCmd.Cmd_V_CSVoiceRedirectReq";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.wecall.talkroom.a.h
 * JD-Core Version:    0.7.0.1
 */