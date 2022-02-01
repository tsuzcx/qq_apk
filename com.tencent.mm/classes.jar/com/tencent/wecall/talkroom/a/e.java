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
  public String IJx;
  public int ILK;
  public int sHe;
  public String seB;
  public long ztl;
  
  public e(e parame)
  {
    AppMethodBeat.i(62542);
    this.seB = null;
    this.sHe = 0;
    this.ztl = 0L;
    this.ILK = 0;
    this.IJx = null;
    this.seB = parame.seB;
    this.sHe = parame.sHe;
    this.ztl = parame.ztl;
    this.ILK = parame.ILK;
    this.IJx = parame.IJx;
    this.IjT = parame.IjT;
    this.IjV = parame.IjV;
    this.IjW = parame.IjW;
    this.mNetType = 1;
    AppMethodBeat.o(62542);
  }
  
  public e(String paramString1, int paramInt1, long paramLong, byte[] paramArrayOfByte, int paramInt2, int paramInt3, String paramString2)
  {
    AppMethodBeat.i(62543);
    this.seB = null;
    this.sHe = 0;
    this.ztl = 0L;
    this.ILK = 0;
    this.IJx = null;
    b.d("MicroMsg.Voip", new Object[] { this.TAG2, "enter2", paramString1, Integer.valueOf(paramInt1), Long.valueOf(paramLong), paramString2 });
    a.e locale = new a.e();
    for (;;)
    {
      try
      {
        locale.groupId = paramString1;
        this.seB = paramString1;
        locale.zkT = paramInt1;
        this.sHe = paramInt1;
        locale.zkU = paramLong;
        this.ztl = paramLong;
        locale.tjk = paramInt3;
        this.ILK = paramInt3;
        paramString1 = new a.aw();
        paramString1.ImY = paramString2;
        locale.IkD = paramString1;
        this.IJx = paramString2;
        b.d("MicroMsg.Voip", new Object[] { this.TAG2, "wXgroupId", locale.IkD.ImY });
        paramString1 = new a.an();
        if (paramArrayOfByte == null) {
          continue;
        }
        paramString1.buffer = paramArrayOfByte;
        paramString1.iLen = paramArrayOfByte.length;
        paramArrayOfByte = new a.bd();
        paramArrayOfByte.type = 3;
        paramArrayOfByte.InR = paramString1;
        locale.IkF = paramArrayOfByte;
        this.mNetType = 2;
        this.IjW = paramInt2;
        locale.IkH = 2;
        locale.netType = k.kR(c.ztG);
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
  
  public final Object cC(byte[] paramArrayOfByte)
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
  
  public final String flk()
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