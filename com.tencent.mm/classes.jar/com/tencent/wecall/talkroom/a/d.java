package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.a.a.a;
import com.tencent.pb.common.b.a.a.al;
import com.tencent.pb.common.b.a.a.at;
import com.tencent.pb.common.b.a.a.ay;
import com.tencent.pb.common.b.a.a.ba;
import com.tencent.pb.common.b.a.a.d;
import com.tencent.pb.common.b.a.a.z;
import com.tencent.pb.common.c.c;
import com.tencent.wecall.talkroom.model.k;

public final class d
  extends com.tencent.pb.common.b.d
{
  public String BAy;
  public boolean BCv;
  public int mType;
  
  public d(String paramString1, String[] paramArrayOfString, byte[] paramArrayOfByte, String paramString2, a.ay paramay, int paramInt1, int paramInt2, long paramLong, String paramString3, boolean paramBoolean, String paramString4)
  {
    AppMethodBeat.i(128013);
    this.BCv = true;
    c.d("MicroMsg.Voip", new Object[] { this.TAG2, "create" });
    a.d locald = new a.d();
    for (;;)
    {
      try
      {
        locald.BdG = paramString1;
        this.BAy = paramString1;
        locald.BdL = paramInt1;
        this.Bda = paramInt1;
        if (paramay != null) {
          locald.BdN = paramay;
        }
        paramString1 = new a.at();
        paramString1.name = paramString2;
        paramString1.Bgc = paramString4;
        paramString1.Bgb = a.dTX();
        paramString1.cve = paramInt2;
        this.mType = paramInt2;
        this.BCv = paramBoolean;
        paramString1.BfU = paramLong;
        locald.BdI = paramString1;
        locald.BdP = paramArrayOfString;
        paramString1 = paramString3;
        if (paramString3 == null) {
          paramString1 = "";
        }
        locald.BdO = paramString1;
        paramString1 = new a.al();
        if (paramArrayOfByte == null) {
          continue;
        }
        paramString1.buffer = paramArrayOfByte;
        paramString1.iLen = paramArrayOfByte.length;
        paramArrayOfString = new a.ba();
        paramArrayOfString.type = 3;
        paramArrayOfString.BgW = paramString1;
        locald.BdK = paramArrayOfString;
        this.mNetType = 3;
        locald.BdM = 2;
        locald.netType = k.jN(com.tencent.pb.common.c.d.tFk);
      }
      catch (Exception paramString1)
      {
        c.w(this.TAG2, new Object[] { "NetSceneCreateVoiceGroup constructor", paramString1 });
        continue;
      }
      c(139, locald);
      AppMethodBeat.o(128013);
      return;
      paramString1.iLen = 0;
    }
  }
  
  public final Object ck(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(128014);
    c.d("MicroMsg.Voip", new Object[] { this.TAG2, "data2Resp" });
    if (paramArrayOfByte != null) {}
    for (;;)
    {
      try
      {
        paramArrayOfByte = (a.z)e.a(new a.z(), paramArrayOfByte, paramArrayOfByte.length);
        AppMethodBeat.o(128014);
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
    return "CsCmd.Cmd_V_CSCreateVoiceGroupReq";
  }
  
  public final int getType()
  {
    return 201;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.wecall.talkroom.a.d
 * JD-Core Version:    0.7.0.1
 */