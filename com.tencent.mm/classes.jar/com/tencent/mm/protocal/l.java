package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.network.b.a;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.jr;
import com.tencent.mm.protocal.protobuf.wl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class l
{
  public static jr a(d paramd)
  {
    AppMethodBeat.i(133100);
    jr localjr = new jr();
    localjr.KOj = paramd.getClientVersion();
    localjr.Scene = paramd.getSceneStatus();
    localjr.rBx = paramd.getUin();
    localjr.KOi = b.cD(paramd.getDeviceID().getBytes());
    if (localjr.KOi.zy.length >= 16) {
      localjr.KOi = localjr.KOi.aiU(16);
    }
    localjr.KOk = b.cD(paramd.getDeviceType().getBytes());
    if (localjr.KOk.zy.length >= 132) {
      localjr.KOk = localjr.KOk.aiU(132);
    }
    localjr.KOh = b.cD(paramd.getSessionKey());
    if (localjr.KOh.zy.length >= 36) {
      localjr.KOh = localjr.KOh.aiU(36);
    }
    AppMethodBeat.o(133100);
    return localjr;
  }
  
  public static void a(e parame, BaseResponse paramBaseResponse)
  {
    AppMethodBeat.i(133101);
    if (paramBaseResponse.ErrMsg != null)
    {
      parame.setErrMsg(paramBaseResponse.ErrMsg.MTo);
      AppMethodBeat.o(133101);
      return;
    }
    parame.setErrMsg("");
    Log.e("MicroMsg.MMBase", "ErrMsg is Null!!!!!!");
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
    private b.a cgiVerifyKeys;
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
    
    public String getCgiVerifyPrivateKey()
    {
      String str = "";
      if (this.cgiVerifyKeys != null) {
        str = this.cgiVerifyKeys.jDC;
      }
      return str;
    }
    
    public String getCgiVerifyPublicKey()
    {
      String str = "";
      if (this.cgiVerifyKeys != null) {
        str = this.cgiVerifyKeys.jDD;
      }
      return str;
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
    
    public void setCGiVerifyKey(b.a parama)
    {
      this.cgiVerifyKeys = parama;
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
      Log.i("MicroMsg.MMBase.Req", "summerauths setRsaInfo cgi[%s], USE_ECDH[%b], stack[%s]", new Object[] { Integer.valueOf(getCmdId()), Boolean.valueOf(f.KyZ), Util.getStack() });
      if (f.KyZ) {
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
      Log.i("MicroMsg.MMBase.Req", "summerauths setUseECDH[%s]  cgi[%s], stack[%s]", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(getCmdId()), Util.getStack() });
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
    private wl profile;
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
    
    public wl getProfile()
    {
      return this.profile;
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
    
    public void setProfile(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(197128);
      this.profile = new wl();
      try
      {
        this.profile.parseFrom(paramArrayOfByte);
        AppMethodBeat.o(197128);
        return;
      }
      catch (Exception paramArrayOfByte)
      {
        Log.e("setProfile", paramArrayOfByte.getLocalizedMessage());
        AppMethodBeat.o(197128);
      }
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