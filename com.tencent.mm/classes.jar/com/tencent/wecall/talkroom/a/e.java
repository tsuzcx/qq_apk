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
  public String CSB;
  public int DVO;
  public long NXM;
  public String ZVC;
  public int ZXS;
  
  public e(e parame)
  {
    AppMethodBeat.i(62542);
    this.CSB = null;
    this.DVO = 0;
    this.NXM = 0L;
    this.ZXS = 0;
    this.ZVC = null;
    this.CSB = parame.CSB;
    this.DVO = parame.DVO;
    this.NXM = parame.NXM;
    this.ZXS = parame.ZXS;
    this.ZVC = parame.ZVC;
    super.a(parame);
    AppMethodBeat.o(62542);
  }
  
  public e(String paramString1, int paramInt1, long paramLong, byte[] paramArrayOfByte, int paramInt2, int paramInt3, String paramString2)
  {
    AppMethodBeat.i(62543);
    this.CSB = null;
    this.DVO = 0;
    this.NXM = 0L;
    this.ZXS = 0;
    this.ZVC = null;
    b.d("MicroMsg.Voip", new Object[] { this.TAG2, "enter2", paramString1, Integer.valueOf(paramInt1), Long.valueOf(paramLong), paramString2 });
    a.e locale = new a.e();
    for (;;)
    {
      try
      {
        locale.groupId = paramString1;
        this.CSB = paramString1;
        locale.NOc = paramInt1;
        this.DVO = paramInt1;
        locale.NOd = paramLong;
        this.NXM = paramLong;
        locale.xbJ = paramInt3;
        this.ZXS = paramInt3;
        paramString1 = new a.ay();
        paramString1.Zhv = paramString2;
        locale.ZeS = paramString1;
        this.ZVC = paramString2;
        b.d("MicroMsg.Voip", new Object[] { this.TAG2, "wXgroupId", locale.ZeS.Zhv });
        paramString1 = new a.ao();
        if (paramArrayOfByte == null) {
          continue;
        }
        paramString1.buffer = paramArrayOfByte;
        paramString1.Ufv = paramArrayOfByte.length;
        paramArrayOfByte = new a.bf();
        paramArrayOfByte.type = 3;
        paramArrayOfByte.Zip = paramString1;
        locale.ZeU = paramArrayOfByte;
        aAc(2);
        aAd(paramInt2);
        locale.ZeW = 2;
        locale.netType = j.mv(c.NYh);
      }
      catch (Exception paramString1)
      {
        b.w(this.TAG2, new Object[] { "NetSceneEnterVoiceRoom constructor", paramString1 });
        continue;
      }
      c(141, locale);
      AppMethodBeat.o(62543);
      return;
      paramString1.Ufv = 0;
    }
  }
  
  public final Object dn(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(62544);
    if (paramArrayOfByte != null) {}
    for (;;)
    {
      try
      {
        paramArrayOfByte = (a.ac)com.google.b.a.e.a(new a.ac(), paramArrayOfByte, paramArrayOfByte.length);
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
  
  public final String ikF()
  {
    return "CsCmd.Cmd_V_CSEnterVoiceRoomReq";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.wecall.talkroom.a.e
 * JD-Core Version:    0.7.0.1
 */