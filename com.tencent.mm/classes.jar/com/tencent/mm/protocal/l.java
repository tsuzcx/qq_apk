package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.protocal.protobuf.jc;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class l
{
  public static jc a(d paramd)
  {
    AppMethodBeat.i(133100);
    jc localjc = new jc();
    localjc.FUA = paramd.getClientVersion();
    localjc.Scene = paramd.getSceneStatus();
    localjc.qkC = paramd.getUin();
    localjc.FUz = b.cm(paramd.getDeviceID().getBytes());
    if (localjc.FUz.zr.length >= 16) {
      localjc.FUz = localjc.FUz.aaf(16);
    }
    localjc.FUB = b.cm(paramd.getDeviceType().getBytes());
    if (localjc.FUB.zr.length >= 132) {
      localjc.FUB = localjc.FUB.aaf(132);
    }
    localjc.FUy = b.cm(paramd.getSessionKey());
    if (localjc.FUy.zr.length >= 36) {
      localjc.FUy = localjc.FUy.aaf(36);
    }
    AppMethodBeat.o(133100);
    return localjc;
  }
  
  public static void a(e parame, BaseResponse paramBaseResponse)
  {
    AppMethodBeat.i(133101);
    if (paramBaseResponse.ErrMsg != null)
    {
      parame.setErrMsg(paramBaseResponse.ErrMsg.HId);
      AppMethodBeat.o(133101);
      return;
    }
    parame.setErrMsg("");
    ae.e("MicroMsg.MMBase", "ErrMsg is Null!!!!!!");
    AppMethodBeat.o(133101);
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
    private ac rsaInfo;
    private String sDeviceID;
    private String sDeviceType;
    private byte[] sessionKey;
    private boolean useAxSession;
    private boolean useECDH;
    
    public d()
    {
      AppMethodBeat.i(133097);
      this.bShortSupport = true;
      this.useECDH = false;
      this.useAxSession = false;
      this.bufferSize = 0L;
      this.iUin = 0;
      this.iClientVersion = 0;
      this.sessionKey = new byte[0];
      this.sDeviceType = "";
      this.sDeviceID = "";
      this.iSceneStatus = 0;
      this.rsaInfo = new ac("", "", 0);
      this.routeInfo = 0;
      this.ecdhEngine = 0L;
      AppMethodBeat.o(133097);
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
    
    public ac getRsaInfo()
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
    
    public void setRsaInfo(ac paramac)
    {
      AppMethodBeat.i(133098);
      this.rsaInfo = paramac;
      ae.i("MicroMsg.MMBase.Req", "summerauths setRsaInfo cgi[%s], USE_ECDH[%b], stack[%s]", new Object[] { Integer.valueOf(getCmdId()), Boolean.valueOf(f.FFQ), bu.fpN() });
      if (f.FFQ) {
        setUseECDH(true);
      }
      AppMethodBeat.o(133098);
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
    
    public void setUseAxsession(boolean paramBoolean)
    {
      this.useAxSession = paramBoolean;
    }
    
    public void setUseECDH(boolean paramBoolean)
    {
      AppMethodBeat.i(133099);
      this.useECDH = paramBoolean;
      ae.i("MicroMsg.MMBase.Req", "summerauths setUseECDH[%s]  cgi[%s], stack[%s]", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(getCmdId()), bu.fpN() });
      AppMethodBeat.o(133099);
    }
    
    public boolean useAxSession()
    {
      return this.useAxSession;
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
    
    public byte[] getAuthResponse()
    {
      return null;
    }
    
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