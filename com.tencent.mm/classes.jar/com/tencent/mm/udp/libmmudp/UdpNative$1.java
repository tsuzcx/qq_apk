package com.tencent.mm.udp.libmmudp;

import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;

class UdpNative$1
  implements UdpNative.NativeCallBackInterface
{
  UdpNative$1(UdpNative paramUdpNative, UdpNative.NativeCallBackInterface paramNativeCallBackInterface) {}
  
  @Keep
  public void onCallBack(String paramString)
  {
    AppMethodBeat.i(152193);
    this.yTd.onCallBack(paramString);
    AppMethodBeat.o(152193);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.udp.libmmudp.UdpNative.1
 * JD-Core Version:    0.7.0.1
 */