package com.tencent.wecall.talkroom.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.b.a.a.a.ab;
import com.tencent.pb.common.b.a.a.a.an;
import com.tencent.pb.common.b.a.a.a.aw;
import com.tencent.pb.common.b.a.a.a.bd;
import com.tencent.pb.common.b.a.a.a.e;
import com.tencent.pb.common.b.d;
import com.tencent.pb.common.c.b;
import com.tencent.pb.common.c.c;
import com.tencent.wecall.talkroom.model.k;

public final class e
  extends d
{
  public long AMc;
  public String KvP;
  public int Kyc;
  public int tOL;
  public String tmu;
  
  public e(e parame)
  {
    AppMethodBeat.i(62542);
    this.tmu = null;
    this.tOL = 0;
    this.AMc = 0L;
    this.Kyc = 0;
    this.KvP = null;
    this.tmu = parame.tmu;
    this.tOL = parame.tOL;
    this.AMc = parame.AMc;
    this.Kyc = parame.Kyc;
    this.KvP = parame.KvP;
    this.JLE = parame.JLE;
    this.JLG = parame.JLG;
    this.JLH = parame.JLH;
    this.mNetType = 1;
    AppMethodBeat.o(62542);
  }
  
  public e(String paramString1, int paramInt1, long paramLong, byte[] paramArrayOfByte, int paramInt2, int paramInt3, String paramString2)
  {
    AppMethodBeat.i(62543);
    this.tmu = null;
    this.tOL = 0;
    this.AMc = 0L;
    this.Kyc = 0;
    this.KvP = null;
    b.d("MicroMsg.Voip", new Object[] { this.TAG2, "enter2", paramString1, Integer.valueOf(paramInt1), Long.valueOf(paramLong), paramString2 });
    a.e locale = new a.e();
    for (;;)
    {
      try
      {
        locale.groupId = paramString1;
        this.tmu = paramString1;
        locale.ADE = paramInt1;
        this.tOL = paramInt1;
        locale.ADF = paramLong;
        this.AMc = paramLong;
        locale.urD = paramInt3;
        this.Kyc = paramInt3;
        paramString1 = new a.aw();
        paramString1.JOI = paramString2;
        locale.JMo = paramString1;
        this.KvP = paramString2;
        b.d("MicroMsg.Voip", new Object[] { this.TAG2, "wXgroupId", locale.JMo.JOI });
        paramString1 = new a.an();
        if (paramArrayOfByte == null) {
          continue;
        }
        paramString1.buffer = paramArrayOfByte;
        paramString1.iLen = paramArrayOfByte.length;
        paramArrayOfByte = new a.bd();
        paramArrayOfByte.type = 3;
        paramArrayOfByte.JPB = paramString1;
        locale.JMq = paramArrayOfByte;
        this.mNetType = 2;
        this.JLH = paramInt2;
        locale.JMs = 2;
        locale.netType = k.lf(c.AMx);
      }
      catch (Exception paramString1)
      {
        b.w(this.TAG2, new Object[] { "NetSceneEnterVoiceRoom constructor", paramString1 });
        continue;
      }
      c(141, locale);
      AppMethodBeat.o(62543);
      return;
      paramString1.iLen = 0;
    }
  }
  
  public final Object cB(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(62544);
    if (paramArrayOfByte != null) {}
    for (;;)
    {
      try
      {
        paramArrayOfByte = (a.ab)com.google.b.a.e.a(new a.ab(), paramArrayOfByte, paramArrayOfByte.length);
        AppMethodBeat.o(62544);
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
  
  public final String fBB()
  {
    return "CsCmd.Cmd_V_CSEnterVoiceRoomReq";
  }
  
  public final int getType()
  {
    return 202;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.wecall.talkroom.a.e
 * JD-Core Version:    0.7.0.1
 */