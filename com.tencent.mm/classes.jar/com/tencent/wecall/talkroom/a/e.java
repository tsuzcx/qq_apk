package com.tencent.wecall.talkroom.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.b.a.a.a.ac;
import com.tencent.pb.common.b.a.a.a.ao;
import com.tencent.pb.common.b.a.a.a.ay;
import com.tencent.pb.common.b.a.a.a.bf;
import com.tencent.pb.common.b.a.a.a.e;
import com.tencent.pb.common.b.d;
import com.tencent.pb.common.c.b;
import com.tencent.pb.common.c.c;
import com.tencent.wecall.talkroom.model.j;

public final class e
  extends d
{
  public String IMR;
  public int JMX;
  public long UGt;
  public String aiab;
  public int aicr;
  
  public e(e parame)
  {
    AppMethodBeat.i(62542);
    this.IMR = null;
    this.JMX = 0;
    this.UGt = 0L;
    this.aicr = 0;
    this.aiab = null;
    this.IMR = parame.IMR;
    this.JMX = parame.JMX;
    this.UGt = parame.UGt;
    this.aicr = parame.aicr;
    this.aiab = parame.aiab;
    super.a(parame);
    AppMethodBeat.o(62542);
  }
  
  public e(String paramString1, int paramInt1, long paramLong, byte[] paramArrayOfByte, int paramInt2, int paramInt3, String paramString2)
  {
    AppMethodBeat.i(62543);
    this.IMR = null;
    this.JMX = 0;
    this.UGt = 0L;
    this.aicr = 0;
    this.aiab = null;
    b.d("MicroMsg.Voip", new Object[] { this.TAG2, "enter2", paramString1, Integer.valueOf(paramInt1), Long.valueOf(paramLong), paramString2 });
    a.e locale = new a.e();
    for (;;)
    {
      try
      {
        locale.groupId = paramString1;
        this.IMR = paramString1;
        locale.UAZ = paramInt1;
        this.JMX = paramInt1;
        locale.UBa = paramLong;
        this.UGt = paramLong;
        locale.ACR = paramInt3;
        this.aicr = paramInt3;
        paramString1 = new a.ay();
        paramString1.ahfW = paramString2;
        locale.ahdv = paramString1;
        this.aiab = paramString2;
        b.d("MicroMsg.Voip", new Object[] { this.TAG2, "wXgroupId", locale.ahdv.ahfW });
        paramString1 = new a.ao();
        if (paramArrayOfByte == null) {
          continue;
        }
        paramString1.buffer = paramArrayOfByte;
        paramString1.abwJ = paramArrayOfByte.length;
        paramArrayOfByte = new a.bf();
        paramArrayOfByte.type = 3;
        paramArrayOfByte.ahgQ = paramString1;
        locale.ahdx = paramArrayOfByte;
        aGP(2);
        aGQ(paramInt2);
        locale.ahdz = 2;
        locale.netType = j.oL(c.UMe);
      }
      catch (Exception paramString1)
      {
        b.w(this.TAG2, new Object[] { "NetSceneEnterVoiceRoom constructor", paramString1 });
        continue;
      }
      c(141, locale);
      AppMethodBeat.o(62543);
      return;
      paramString1.abwJ = 0;
    }
  }
  
  public final Object dp(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(62544);
    if (paramArrayOfByte != null) {}
    for (;;)
    {
      try
      {
        paramArrayOfByte = (a.ac)com.google.d.a.e.a(new a.ac(), paramArrayOfByte, paramArrayOfByte.length);
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
  
  public final int getType()
  {
    return 202;
  }
  
  public final String jQW()
  {
    return "CsCmd.Cmd_V_CSEnterVoiceRoomReq";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.wecall.talkroom.a.e
 * JD-Core Version:    0.7.0.1
 */