package com.tencent.wecall.talkroom.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.b.a.a.aa;
import com.tencent.pb.common.b.a.a.al;
import com.tencent.pb.common.b.a.a.at;
import com.tencent.pb.common.b.a.a.ba;
import com.tencent.pb.common.b.a.a.e;
import com.tencent.pb.common.c.c;
import com.tencent.wecall.talkroom.model.k;

public final class e
  extends com.tencent.pb.common.b.d
{
  public String BAx;
  public int BCw;
  public int nTj;
  public String nuW;
  public long tFh;
  
  public e(e parame)
  {
    AppMethodBeat.i(128015);
    this.nuW = null;
    this.nTj = 0;
    this.tFh = 0L;
    this.BCw = 0;
    this.BAx = null;
    this.nuW = parame.nuW;
    this.nTj = parame.nTj;
    this.tFh = parame.tFh;
    this.BCw = parame.BCw;
    this.BAx = parame.BAx;
    this.BcX = parame.BcX;
    this.BcZ = parame.BcZ;
    this.Bda = parame.Bda;
    this.mNetType = 1;
    AppMethodBeat.o(128015);
  }
  
  public e(String paramString1, int paramInt1, long paramLong, byte[] paramArrayOfByte, int paramInt2, int paramInt3, String paramString2)
  {
    AppMethodBeat.i(128016);
    this.nuW = null;
    this.nTj = 0;
    this.tFh = 0L;
    this.BCw = 0;
    this.BAx = null;
    c.d("MicroMsg.Voip", new Object[] { this.TAG2, "enter2", paramString1, Integer.valueOf(paramInt1), Long.valueOf(paramLong), paramString2 });
    a.e locale = new a.e();
    for (;;)
    {
      try
      {
        locale.groupId = paramString1;
        this.nuW = paramString1;
        locale.twP = paramInt1;
        this.nTj = paramInt1;
        locale.twQ = paramLong;
        this.tFh = paramLong;
        locale.BdS = paramInt3;
        this.BCw = paramInt3;
        paramString1 = new a.at();
        paramString1.Bgc = paramString2;
        locale.BdI = paramString1;
        this.BAx = paramString2;
        c.d("MicroMsg.Voip", new Object[] { this.TAG2, "wXgroupId", locale.BdI.Bgc });
        paramString1 = new a.al();
        if (paramArrayOfByte == null) {
          continue;
        }
        paramString1.buffer = paramArrayOfByte;
        paramString1.iLen = paramArrayOfByte.length;
        paramArrayOfByte = new a.ba();
        paramArrayOfByte.type = 3;
        paramArrayOfByte.BgW = paramString1;
        locale.BdK = paramArrayOfByte;
        this.mNetType = 2;
        this.Bda = paramInt2;
        locale.BdM = 2;
        locale.netType = k.jN(com.tencent.pb.common.c.d.tFk);
      }
      catch (Exception paramString1)
      {
        c.w(this.TAG2, new Object[] { "NetSceneEnterVoiceRoom constructor", paramString1 });
        continue;
      }
      c(141, locale);
      AppMethodBeat.o(128016);
      return;
      paramString1.iLen = 0;
    }
  }
  
  public final Object ck(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(128017);
    if (paramArrayOfByte != null) {}
    for (;;)
    {
      try
      {
        paramArrayOfByte = (a.aa)com.google.a.a.e.a(new a.aa(), paramArrayOfByte, paramArrayOfByte.length);
        AppMethodBeat.o(128017);
        return paramArrayOfByte;
      }
      catch (Exception paramArrayOfByte)
      {
        c.w(this.TAG2, new Object[] { "data2Resp", paramArrayOfByte.getMessage() });
        paramArrayOfByte = null;
        continue;
      }
      paramArrayOfByte = null;
    }
  }
  
  public final String dTD()
  {
    return "CsCmd.Cmd_V_CSEnterVoiceRoomReq";
  }
  
  public final int getType()
  {
    return 202;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.wecall.talkroom.a.e
 * JD-Core Version:    0.7.0.1
 */