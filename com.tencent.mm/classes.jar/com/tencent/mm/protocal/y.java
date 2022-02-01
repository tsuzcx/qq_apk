package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.n;
import com.tencent.mm.bx.b;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.protocal.protobuf.gdd;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.protocal.protobuf.ip;
import com.tencent.mm.protocal.protobuf.iq;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.co;

public final class y
  extends n
{
  private final a YyD;
  private final b YyE;
  private final int funcId;
  private final String uri;
  
  public y(int paramInt1, String paramString, int paramInt2, gol paramgol, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(134242);
    this.YyD = new a();
    this.YyE = new b();
    this.funcId = paramInt1;
    this.uri = paramString;
    this.YyD.funcId = paramInt1;
    this.YyD.randomKey = paramArrayOfByte;
    this.YyD.YyF.IKW = paramInt2;
    this.YyD.YyF.YKz = paramgol;
    AppMethodBeat.o(134242);
  }
  
  public final int getOptions()
  {
    return 1;
  }
  
  public final l.d getReqObjImp()
  {
    return this.YyD;
  }
  
  public final l.e getRespObj()
  {
    return this.YyE;
  }
  
  public final int getType()
  {
    return this.funcId;
  }
  
  public final String getUri()
  {
    return this.uri;
  }
  
  public static final class a
    extends l.d
    implements l.b
  {
    public ip YyF;
    int funcId;
    byte[] randomKey;
    
    public a()
    {
      AppMethodBeat.i(134238);
      this.YyF = new ip();
      AppMethodBeat.o(134238);
    }
    
    public final int getFuncId()
    {
      return this.funcId;
    }
    
    public final boolean isAxAuth()
    {
      return true;
    }
    
    public final byte[] toProtoBuf()
    {
      int j = -1;
      AppMethodBeat.i(134239);
      this.YyF.setBaseRequest(l.a(this));
      this.YyF.Jmq = q.aOY();
      this.YyF.YJV = com.tencent.mm.plugin.normsg.a.d.MtP.aeQ(0);
      this.YyF.pSi = Util.getSourceeMd5(MMApplicationContext.getContext());
      this.YyF.vgW = d.Yxf;
      this.YyF.YJY = co.jcP();
      this.YyF.yts = LocaleUtil.getApplicationLanguage();
      this.YyF.ytr = Util.getTimeZoneOffset();
      this.YyF.YJZ = ChannelUtil.channelId;
      for (;;)
      {
        try
        {
          arrayOfByte = com.tencent.mm.plugin.normsg.a.d.MtP.gtE();
          if (arrayOfByte == null) {
            continue;
          }
          i = arrayOfByte.length;
          Log.d("MicroMsg.MMReqRespAxAuth", "[debug] ccd set on axauth, len: %s", new Object[] { Integer.valueOf(i) });
          gdd localgdd = new gdd();
          localgdd.acaX = new gol().df(arrayOfByte);
          localgdd.acbb = new gol().df(com.tencent.mm.plugin.normsg.a.d.MtP.gtH());
          i = j;
          if (localgdd.acbb != null) {
            i = localgdd.acbb.abwJ;
          }
          Log.d("MicroMsg.MMReqRespAxAuth", "[debug] devtok on axauth, len: %s", new Object[] { Integer.valueOf(i) });
          this.YyF.YKb = new gol().df(localgdd.toByteArray());
        }
        finally
        {
          byte[] arrayOfByte;
          int i;
          long l;
          Log.printErrStackTrace("MicroMsg.MMReqRespAxAuth", localThrowable, "cc throws exception.", new Object[0]);
          continue;
        }
        l = UtilsJni.CreateAxEcdhCryptoEngine(this.YyF.IKW, this.randomKey, this.YyF.YKz.aaxD.Op);
        setEcdhEngine(l);
        arrayOfByte = UtilsJni.AxEcdhEncrypt(l, this.YyF.toByteArray());
        AppMethodBeat.o(134239);
        return arrayOfByte;
        i = -1;
      }
    }
  }
  
  public static final class b
    extends l.e
    implements l.c
  {
    public iq YyG;
    
    public b()
    {
      AppMethodBeat.i(134240);
      this.YyG = new iq();
      AppMethodBeat.o(134240);
    }
    
    public final int fromProtoBuf(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(134241);
      this.YyG = ((iq)new iq().parseFrom(paramArrayOfByte));
      l.a(this, this.YyG.getBaseResponse());
      int i = this.YyG.getBaseResponse().Idd;
      AppMethodBeat.o(134241);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.y
 * JD-Core Version:    0.7.0.1
 */