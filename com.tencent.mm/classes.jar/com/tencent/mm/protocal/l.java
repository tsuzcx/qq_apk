package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.protocal.protobuf.hq;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class l
{
  public static hq a(d paramd)
  {
    AppMethodBeat.i(58841);
    hq localhq = new hq();
    localhq.wur = paramd.getClientVersion();
    localhq.Scene = paramd.getSceneStatus();
    localhq.lGw = paramd.getUin();
    localhq.wuq = b.bL(paramd.getDeviceID().getBytes());
    if (localhq.wuq.pW.length >= 16) {
      localhq.wuq = localhq.wuq.Mz(16);
    }
    localhq.wus = b.bL(paramd.getDeviceType().getBytes());
    if (localhq.wus.pW.length >= 132) {
      localhq.wus = localhq.wus.Mz(132);
    }
    localhq.wup = b.bL(paramd.getSessionKey());
    if (localhq.wup.pW.length >= 36) {
      localhq.wup = localhq.wup.Mz(36);
    }
    AppMethodBeat.o(58841);
    return localhq;
  }
  
  public static void a(e parame, BaseResponse paramBaseResponse)
  {
    AppMethodBeat.i(58842);
    if (paramBaseResponse.ErrMsg != null)
    {
      parame.setErrMsg(paramBaseResponse.ErrMsg.xJE);
      AppMethodBeat.o(58842);
      return;
    }
    parame.setErrMsg("");
    ab.e("MicroMsg.MMBase", "ErrMsg is Null!!!!!!");
    AppMethodBeat.o(58842);
  }
  
  public static abstract interface a
  {
    public abstract boolean a(PByteArray paramPByteArray, int paramInt1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt2);
  }
  
  public static abstract interface b
  {
    public abstract long getECDHEngine();
    
    public abstract int getFuncId();
    
    public abstract int getRouteInfo();
    
    public abstract boolean isAxAuth();
    
    public abstract boolean isRawData();
    
    public abstract byte[] toProtoBuf();
  }
  
  public static abstract interface c
  {
    public abstract int fromProtoBuf(byte[] paramArrayOfByte);
    
    public abstract boolean isRawData();
  }
  
  public static class d
  {
    private static final String TAG = "MicroMsg.MMBase.Req";
    private boolean bShortSupport;
    private long bufferSize;
    private long ecdhEngine;
    private int iClientVersion;
    private int iSceneStatus;
    private int iUin;
    private l.a mReqPackControl;
    private byte[] passKey;
    private int routeInfo;
    private aa rsaInfo;
    private String sDeviceID;
    private String sDeviceType;
    private byte[] sessionKey;
    private boolean useECDH;
    
    public d()
    {
      AppMethodBeat.i(58839);
      this.bShortSupport = true;
      this.useECDH = false;
      this.bufferSize = 0L;
      this.iUin = 0;
      this.iClientVersion = 0;
      this.sessionKey = new byte[0];
      this.sDeviceType = "";
      this.sDeviceID = "";
      this.iSceneStatus = 0;
      this.rsaInfo = new aa("", "", 0);
      this.routeInfo = 0;
      this.ecdhEngine = 0L;
      AppMethodBeat.o(58839);
    }
    
    public long getBufferSize()
    {
      return this.bufferSize;
    }
    
    public int getClientVersion()
    {
      return this.iClientVersion;
    }
    
    public int getCmdId()
    {
      return 0;
    }
    
    public String getDeviceID()
    {
      return this.sDeviceID;
    }
    
    public String getDeviceType()
    {
      return this.sDeviceType;
    }
    
    public long getECDHEngine()
    {
      return this.ecdhEngine;
    }
    
    public byte[] getPassKey()
    {
      return this.passKey;
    }
    
    public l.a getReqPackControl()
    {
      return this.mReqPackControl;
    }
    
    public int getRouteInfo()
    {
      return this.routeInfo;
    }
    
    public aa getRsaInfo()
    {
      return this.rsaInfo;
    }
    
    public int getSceneStatus()
    {
      return this.iSceneStatus;
    }
    
    public byte[] getSessionKey()
    {
      return this.sessionKey;
    }
    
    public boolean getShortSupport()
    {
      return this.bShortSupport;
    }
    
    public int getUin()
    {
      return this.iUin;
    }
    
    public boolean isAxAuth()
    {
      return false;
    }
    
    public boolean isRawData()
    {
      return false;
    }
    
    public boolean packToNetMsg(PByteArray paramPByteArray)
    {
      return false;
    }
    
    public void setBufferSize(long paramLong)
    {
      this.bufferSize = paramLong;
    }
    
    public void setClientVersion(int paramInt)
    {
      this.iClientVersion = paramInt;
    }
    
    public void setDeviceID(String paramString)
    {
      this.sDeviceID = paramString;
    }
    
    public void setDeviceType(String paramString)
    {
      this.sDeviceType = paramString;
    }
    
    public void setEcdhEngine(long paramLong)
    {
      this.ecdhEngine = paramLong;
    }
    
    public void setPassKey(byte[] paramArrayOfByte)
    {
      this.passKey = paramArrayOfByte;
    }
    
    public void setReqPackControl(l.a parama)
    {
      this.mReqPackControl = parama;
    }
    
    public void setRouteInfo(int paramInt)
    {
      this.routeInfo = paramInt;
    }
    
    public void setRsaInfo(aa paramaa)
    {
      AppMethodBeat.i(58840);
      this.rsaInfo = paramaa;
      ab.i("MicroMsg.MMBase.Req", "summerauths setRsaInfo cgi[%s], USE_ECDH[%b], stack[%s]", new Object[] { Integer.valueOf(getCmdId()), Boolean.valueOf(f.whQ), bo.dtY() });
      if (f.whQ) {
        setUseECDH(true);
      }
      AppMethodBeat.o(58840);
    }
    
    public void setSceneStatus(int paramInt)
    {
      this.iSceneStatus = paramInt;
    }
    
    public void setSessionKey(byte[] paramArrayOfByte)
    {
      if (paramArrayOfByte != null) {}
      for (;;)
      {
        this.sessionKey = paramArrayOfByte;
        return;
        paramArrayOfByte = new byte[0];
      }
    }
    
    public void setShortSupport(boolean paramBoolean)
    {
      this.bShortSupport = paramBoolean;
    }
    
    public void setUin(int paramInt)
    {
      this.iUin = paramInt;
    }
    
    public void setUseECDH(boolean paramBoolean)
    {
      AppMethodBeat.i(154768);
      this.useECDH = paramBoolean;
      ab.i("MicroMsg.MMBase.Req", "summerauths setUseECDH[%s]  cgi[%s], stack[%s]", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(getCmdId()), bo.dtY() });
      AppMethodBeat.o(154768);
    }
    
    public boolean useECDH()
    {
      return this.useECDH;
    }
  }
  
  public static class e
  {
    private long bufferSize = 0L;
    private int iHeadExtFlags = 255;
    private int iRetCode = -99;
    private String sErrMsg = "";
    
    public long getBufferSize()
    {
      return this.bufferSize;
    }
    
    public int getCmdId()
    {
      return 0;
    }
    
    public String getErrMsg()
    {
      return this.sErrMsg;
    }
    
    public int getHeadExtFlags()
    {
      return this.iHeadExtFlags;
    }
    
    public int getRetCode()
    {
      return this.iRetCode;
    }
    
    public boolean isRawData()
    {
      return false;
    }
    
    public void setBufferSize(long paramLong)
    {
      this.bufferSize = paramLong;
    }
    
    public void setErrMsg(String paramString)
    {
      this.sErrMsg = paramString;
    }
    
    public void setHeadExtFlags(int paramInt)
    {
      this.iHeadExtFlags = paramInt;
    }
    
    public void setRetCode(int paramInt)
    {
      this.iRetCode = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.l
 * JD-Core Version:    0.7.0.1
 */