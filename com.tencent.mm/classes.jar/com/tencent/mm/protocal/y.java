package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.o;
import com.tencent.mm.cd.b;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.fgr;
import com.tencent.mm.protocal.protobuf.ht;
import com.tencent.mm.protocal.protobuf.hu;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cl;

public final class y
  extends o
{
  private final a RCa;
  private final b RCb;
  private final int funcId;
  private final String uri;
  
  public y(int paramInt1, String paramString, int paramInt2, eae parameae, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(134242);
    this.RCa = new a();
    this.RCb = new b();
    this.funcId = paramInt1;
    this.uri = paramString;
    this.RCa.funcId = paramInt1;
    this.RCa.RCd = paramArrayOfByte;
    this.RCa.RCc.CQK = paramInt2;
    this.RCa.RCc.RNl = parameae;
    AppMethodBeat.o(134242);
  }
  
  public final int getOptions()
  {
    return 1;
  }
  
  public final l.d getReqObjImp()
  {
    return this.RCa;
  }
  
  public final l.e getRespObj()
  {
    return this.RCb;
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
    public ht RCc;
    byte[] RCd;
    int funcId;
    
    public a()
    {
      AppMethodBeat.i(134238);
      this.RCc = new ht();
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
      this.RCc.setBaseRequest(l.a(this));
      this.RCc.Dtb = q.auE();
      this.RCc.RMH = com.tencent.mm.plugin.normsg.a.d.GxJ.aax(0);
      this.RCc.mVB = Util.getSourceeMd5(MMApplicationContext.getContext());
      this.RCc.rVG = d.RAB;
      this.RCc.RMK = cl.hAM();
      this.RCc.vhq = LocaleUtil.getApplicationLanguage();
      this.RCc.vhp = Util.getTimeZoneOffset();
      this.RCc.RML = ChannelUtil.channelId;
      for (;;)
      {
        try
        {
          arrayOfByte = com.tencent.mm.plugin.normsg.a.d.GxJ.fjn();
          if (arrayOfByte == null) {
            continue;
          }
          i = arrayOfByte.length;
          Log.d("MicroMsg.MMReqRespAxAuth", "[debug] ccd set on axauth, len: %s", new Object[] { Integer.valueOf(i) });
          fgr localfgr = new fgr();
          localfgr.UGO = new eae().dc(arrayOfByte);
          localfgr.UGS = new eae().dc(com.tencent.mm.plugin.normsg.a.d.GxJ.fjq());
          i = j;
          if (localfgr.UGS != null) {
            i = localfgr.UGS.Ufv;
          }
          Log.d("MicroMsg.MMReqRespAxAuth", "[debug] devtok on axauth, len: %s", new Object[] { Integer.valueOf(i) });
          this.RCc.RMN = new eae().dc(localfgr.toByteArray());
        }
        catch (Throwable localThrowable)
        {
          byte[] arrayOfByte;
          int i;
          long l;
          Log.printErrStackTrace("MicroMsg.MMReqRespAxAuth", localThrowable, "cc throws exception.", new Object[0]);
          continue;
        }
        l = UtilsJni.CreateAxEcdhCryptoEngine(this.RCc.CQK, this.RCd, this.RCc.RNl.Tkb.UH);
        setEcdhEngine(l);
        arrayOfByte = UtilsJni.AxEcdhEncrypt(l, this.RCc.toByteArray());
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
    public hu RCe;
    
    public b()
    {
      AppMethodBeat.i(134240);
      this.RCe = new hu();
      AppMethodBeat.o(134240);
    }
    
    public final int fromProtoBuf(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(134241);
      this.RCe = ((hu)new hu().parseFrom(paramArrayOfByte));
      l.a(this, this.RCe.getBaseResponse());
      int i = this.RCe.getBaseResponse().CqV;
      AppMethodBeat.o(134241);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.y
 * JD-Core Version:    0.7.0.1
 */