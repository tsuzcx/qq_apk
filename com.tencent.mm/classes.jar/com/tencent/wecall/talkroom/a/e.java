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
  public long CCU;
  public String MIL;
  public int MKZ;
  public String uwq;
  public int vdk;
  
  public e(e parame)
  {
    AppMethodBeat.i(62542);
    this.uwq = null;
    this.vdk = 0;
    this.CCU = 0L;
    this.MKZ = 0;
    this.MIL = null;
    this.uwq = parame.uwq;
    this.vdk = parame.vdk;
    this.CCU = parame.CCU;
    this.MKZ = parame.MKZ;
    this.MIL = parame.MIL;
    this.Mcr = parame.Mcr;
    this.Mct = parame.Mct;
    this.Mcu = parame.Mcu;
    this.mNetType = 1;
    AppMethodBeat.o(62542);
  }
  
  public e(String paramString1, int paramInt1, long paramLong, byte[] paramArrayOfByte, int paramInt2, int paramInt3, String paramString2)
  {
    AppMethodBeat.i(62543);
    this.uwq = null;
    this.vdk = 0;
    this.CCU = 0L;
    this.MKZ = 0;
    this.MIL = null;
    b.d("MicroMsg.Voip", new Object[] { this.TAG2, "enter2", paramString1, Integer.valueOf(paramInt1), Long.valueOf(paramLong), paramString2 });
    a.e locale = new a.e();
    for (;;)
    {
      try
      {
        locale.groupId = paramString1;
        this.uwq = paramString1;
        locale.Cuf = paramInt1;
        this.vdk = paramInt1;
        locale.Cug = paramLong;
        this.CCU = paramLong;
        locale.vGk = paramInt3;
        this.MKZ = paramInt3;
        paramString1 = new a.aw();
        paramString1.Mfy = paramString2;
        locale.Mdb = paramString1;
        this.MIL = paramString2;
        b.d("MicroMsg.Voip", new Object[] { this.TAG2, "wXgroupId", locale.Mdb.Mfy });
        paramString1 = new a.an();
        if (paramArrayOfByte == null) {
          continue;
        }
        paramString1.buffer = paramArrayOfByte;
        paramString1.iLen = paramArrayOfByte.length;
        paramArrayOfByte = new a.bd();
        paramArrayOfByte.type = 3;
        paramArrayOfByte.Mgr = paramString1;
        locale.Mdd = paramArrayOfByte;
        this.mNetType = 2;
        this.Mcu = paramInt2;
        locale.Mdf = 2;
        locale.netType = k.ly(c.CDp);
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
  
  public final Object cL(byte[] paramArrayOfByte)
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
  
  public final String fXq()
  {
    return "CsCmd.Cmd_V_CSEnterVoiceRoomReq";
  }
  
  public final int getType()
  {
    return 202;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.wecall.talkroom.a.e
 * JD-Core Version:    0.7.0.1
 */