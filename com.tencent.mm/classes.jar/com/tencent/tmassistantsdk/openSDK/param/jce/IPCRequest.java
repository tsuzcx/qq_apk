package com.tencent.tmassistantsdk.openSDK.param.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class IPCRequest
  extends JceStruct
{
  static byte[] cache_body;
  static IPCHead cache_head;
  public byte[] body = null;
  public IPCHead head = null;
  
  public IPCRequest() {}
  
  public IPCRequest(IPCHead paramIPCHead, byte[] paramArrayOfByte)
  {
    this.head = paramIPCHead;
    this.body = paramArrayOfByte;
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(102245);
    if (cache_head == null) {
      cache_head = new IPCHead();
    }
    this.head = ((IPCHead)paramJceInputStream.read(cache_head, 0, true));
    if (cache_body == null)
    {
      byte[] arrayOfByte = (byte[])new byte[1];
      cache_body = arrayOfByte;
      ((byte[])arrayOfByte)[0] = 0;
    }
    this.body = ((byte[])paramJceInputStream.read(cache_body, 1, false));
    AppMethodBeat.o(102245);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(102244);
    paramJceOutputStream.write(this.head, 0);
    if (this.body != null) {
      paramJceOutputStream.write(this.body, 1);
    }
    AppMethodBeat.o(102244);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tmassistantsdk.openSDK.param.jce.IPCRequest
 * JD-Core Version:    0.7.0.1
 */