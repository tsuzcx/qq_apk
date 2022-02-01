package com.tencent.wecall.talkroom.a;

import com.google.d.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.a.a.a;
import com.tencent.pb.common.b.a.a.a.ab;
import com.tencent.pb.common.b.a.a.a.ao;
import com.tencent.pb.common.b.a.a.a.ay;
import com.tencent.pb.common.b.a.a.a.bd;
import com.tencent.pb.common.b.a.a.a.bf;
import com.tencent.pb.common.b.a.a.a.d;
import com.tencent.pb.common.c.b;
import com.tencent.pb.common.c.c;
import com.tencent.wecall.talkroom.model.j;

public final class d
  extends com.tencent.pb.common.b.d
{
  public String aiac;
  public boolean aicq;
  public int mType;
  
  public d(String paramString1, String[] paramArrayOfString, byte[] paramArrayOfByte, String paramString2, a.bd parambd, int paramInt1, int paramInt2, long paramLong, String paramString3, boolean paramBoolean, String paramString4)
  {
    AppMethodBeat.i(212269);
    this.aicq = true;
    b.d("MicroMsg.Voip", new Object[] { this.TAG2, "create" });
    a.d locald = new a.d();
    for (;;)
    {
      try
      {
        locald.ahdt = paramString1;
        this.aiac = paramString1;
        locald.ahdy = paramInt1;
        aGQ(paramInt1);
        if (parambd != null) {
          locald.ahdA = parambd;
        }
        paramString1 = new a.ay();
        paramString1.name = paramString2;
        paramString1.ahfW = paramString4;
        paramString1.ahfV = a.jRr();
        paramString1.hIY = paramInt2;
        this.mType = paramInt2;
        this.aicq = paramBoolean;
        paramString1.ahfO = paramLong;
        locald.ahdv = paramString1;
        locald.ahdC = paramArrayOfString;
        paramString1 = paramString3;
        if (paramString3 == null) {
          paramString1 = "";
        }
        locald.ahdB = paramString1;
        paramString1 = new a.ao();
        if (paramArrayOfByte == null) {
          continue;
        }
        paramString1.buffer = paramArrayOfByte;
        paramString1.abwJ = paramArrayOfByte.length;
        paramArrayOfString = new a.bf();
        paramArrayOfString.type = 3;
        paramArrayOfString.ahgQ = paramString1;
        locald.ahdx = paramArrayOfString;
        aGP(3);
        locald.ahdz = 2;
        locald.netType = j.oL(c.UMe);
      }
      catch (Exception paramString1)
      {
        b.w(this.TAG2, new Object[] { "NetSceneCreateVoiceGroup constructor", paramString1 });
        continue;
      }
      c(139, locald);
      AppMethodBeat.o(212269);
      return;
      paramString1.abwJ = 0;
    }
  }
  
  public final Object dp(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(62539);
    b.d("MicroMsg.Voip", new Object[] { this.TAG2, "data2Resp" });
    if (paramArrayOfByte != null) {}
    for (;;)
    {
      try
      {
        paramArrayOfByte = (a.ab)e.a(new a.ab(), paramArrayOfByte, paramArrayOfByte.length);
        AppMethodBeat.o(62539);
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
    return 201;
  }
  
  public final String jQW()
  {
    return "CsCmd.Cmd_V_CSCreateVoiceGroupReq";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.wecall.talkroom.a.d
 * JD-Core Version:    0.7.0.1
 */