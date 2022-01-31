package com.tencent.tmassistantsdk.openSDK.param.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ServiceFreeActionResponse
  extends JceStruct
{
  static byte[] cache_revertField;
  public byte[] revertField = null;
  
  public ServiceFreeActionResponse() {}
  
  public ServiceFreeActionResponse(byte[] paramArrayOfByte)
  {
    this.revertField = paramArrayOfByte;
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(76011);
    if (cache_revertField == null)
    {
      byte[] arrayOfByte = (byte[])new byte[1];
      cache_revertField = arrayOfByte;
      ((byte[])arrayOfByte)[0] = 0;
    }
    this.revertField = ((byte[])paramJceInputStream.read(cache_revertField, 0, false));
    AppMethodBeat.o(76011);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(76010);
    if (this.revertField != null) {
      paramJceOutputStream.write(this.revertField, 0);
    }
    AppMethodBeat.o(76010);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tmassistantsdk.openSDK.param.jce.ServiceFreeActionResponse
 * JD-Core Version:    0.7.0.1
 */