package com.tencent.wecall.talkroom.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.b.a.a.a.ac;
import com.tencent.pb.common.b.a.a.a.ap;
import com.tencent.pb.common.b.a.a.a.az;
import com.tencent.pb.common.b.a.a.a.bg;
import com.tencent.pb.common.b.a.a.a.e;
import com.tencent.pb.common.b.d;
import com.tencent.pb.common.c.b;
import com.tencent.pb.common.c.c;
import com.tencent.wecall.talkroom.model.k;

public final class e
  extends d
{
  public long HgX;
  public String SuG;
  public int SwU;
  public String xOr;
  public int yvK;
  
  public e(e parame)
  {
    AppMethodBeat.i(62542);
    this.xOr = null;
    this.yvK = 0;
    this.HgX = 0L;
    this.SwU = 0;
    this.SuG = null;
    this.xOr = parame.xOr;
    this.yvK = parame.yvK;
    this.HgX = parame.HgX;
    this.SwU = parame.SwU;
    this.SuG = parame.SuG;
    this.RCG = parame.RCG;
    this.RCI = parame.RCI;
    this.RCJ = parame.RCJ;
    this.mNetType = 1;
    AppMethodBeat.o(62542);
  }
  
  public e(String paramString1, int paramInt1, long paramLong, byte[] paramArrayOfByte, int paramInt2, int paramInt3, String paramString2)
  {
    AppMethodBeat.i(62543);
    this.xOr = null;
    this.yvK = 0;
    this.HgX = 0L;
    this.SwU = 0;
    this.SuG = null;
    b.d("MicroMsg.Voip", new Object[] { this.TAG2, "enter2", paramString1, Integer.valueOf(paramInt1), Long.valueOf(paramLong), paramString2 });
    a.e locale = new a.e();
    for (;;)
    {
      try
      {
        locale.groupId = paramString1;
        this.xOr = paramString1;
        locale.GXO = paramInt1;
        this.yvK = paramInt1;
        locale.GXP = paramLong;
        this.HgX = paramLong;
        locale.vkj = paramInt3;
        this.SwU = paramInt3;
        paramString1 = new a.az();
        paramString1.RFQ = paramString2;
        locale.RDq = paramString1;
        this.SuG = paramString2;
        b.d("MicroMsg.Voip", new Object[] { this.TAG2, "wXgroupId", locale.RDq.RFQ });
        paramString1 = new a.ap();
        if (paramArrayOfByte == null) {
          continue;
        }
        paramString1.buffer = paramArrayOfByte;
        paramString1.iLen = paramArrayOfByte.length;
        paramArrayOfByte = new a.bg();
        paramArrayOfByte.type = 3;
        paramArrayOfByte.RGJ = paramString1;
        locale.RDs = paramArrayOfByte;
        this.mNetType = 2;
        this.RCJ = paramInt2;
        locale.RDu = 2;
        locale.netType = k.lx(c.Hhs);
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
  
  public final Object cO(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(62544);
    if (paramArrayOfByte != null) {}
    for (;;)
    {
      try
      {
        paramArrayOfByte = (a.ac)com.google.a.a.e.a(new a.ac(), paramArrayOfByte, paramArrayOfByte.length);
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
  
  public final String hiV()
  {
    return "CsCmd.Cmd_V_CSEnterVoiceRoomReq";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.wecall.talkroom.a.e
 * JD-Core Version:    0.7.0.1
 */