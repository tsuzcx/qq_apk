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
  public long Clq;
  public String MlO;
  public int Mod;
  public int uRy;
  public String ukT;
  
  public e(e parame)
  {
    AppMethodBeat.i(62542);
    this.ukT = null;
    this.uRy = 0;
    this.Clq = 0L;
    this.Mod = 0;
    this.MlO = null;
    this.ukT = parame.ukT;
    this.uRy = parame.uRy;
    this.Clq = parame.Clq;
    this.Mod = parame.Mod;
    this.MlO = parame.MlO;
    this.LFn = parame.LFn;
    this.LFp = parame.LFp;
    this.LFq = parame.LFq;
    this.mNetType = 1;
    AppMethodBeat.o(62542);
  }
  
  public e(String paramString1, int paramInt1, long paramLong, byte[] paramArrayOfByte, int paramInt2, int paramInt3, String paramString2)
  {
    AppMethodBeat.i(62543);
    this.ukT = null;
    this.uRy = 0;
    this.Clq = 0L;
    this.Mod = 0;
    this.MlO = null;
    b.d("MicroMsg.Voip", new Object[] { this.TAG2, "enter2", paramString1, Integer.valueOf(paramInt1), Long.valueOf(paramLong), paramString2 });
    a.e locale = new a.e();
    for (;;)
    {
      try
      {
        locale.groupId = paramString1;
        this.ukT = paramString1;
        locale.CcE = paramInt1;
        this.uRy = paramInt1;
        locale.CcF = paramLong;
        this.Clq = paramLong;
        locale.vug = paramInt3;
        this.Mod = paramInt3;
        paramString1 = new a.aw();
        paramString1.LIu = paramString2;
        locale.LFX = paramString1;
        this.MlO = paramString2;
        b.d("MicroMsg.Voip", new Object[] { this.TAG2, "wXgroupId", locale.LFX.LIu });
        paramString1 = new a.an();
        if (paramArrayOfByte == null) {
          continue;
        }
        paramString1.buffer = paramArrayOfByte;
        paramString1.iLen = paramArrayOfByte.length;
        paramArrayOfByte = new a.bd();
        paramArrayOfByte.type = 3;
        paramArrayOfByte.LJn = paramString1;
        locale.LFZ = paramArrayOfByte;
        this.mNetType = 2;
        this.LFq = paramInt2;
        locale.LGb = 2;
        locale.netType = k.ls(c.ClL);
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
  
  public final Object cI(byte[] paramArrayOfByte)
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
  
  public final String fSQ()
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