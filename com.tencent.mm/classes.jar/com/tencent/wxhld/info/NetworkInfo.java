package com.tencent.wxhld.info;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class NetworkInfo
{
  public byte[] authCode;
  public String debugIp;
  public String lkid;
  public int sessionType;
  public boolean useDefaultDebugIp;
  
  public NetworkInfo(int paramInt)
  {
    AppMethodBeat.i(212299);
    this.debugIp = null;
    this.useDefaultDebugIp = false;
    this.lkid = null;
    this.authCode = new byte[paramInt];
    AppMethodBeat.o(212299);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.wxhld.info.NetworkInfo
 * JD-Core Version:    0.7.0.1
 */