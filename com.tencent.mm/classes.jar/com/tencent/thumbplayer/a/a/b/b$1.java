package com.tencent.thumbplayer.a.a.b;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.player.ITPNativePlayerMessageCallback;
import com.tencent.thumbplayer.f.a;

final class b$1
  implements ITPNativePlayerMessageCallback
{
  b$1(b paramb) {}
  
  public final void onASyncCallResult(int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(228678);
    this.ahFY.ahDA.bGe("onASyncCallResult, callType:" + paramInt1 + ", opaque:" + paramLong + ", errorType:" + paramInt2 + ", errorCode:" + paramInt3);
    b.b localb = new b.b();
    localb.ahFZ = paramInt1;
    localb.ahDx = paramLong;
    localb.hDx = paramInt2;
    localb.errorCode = paramInt3;
    Message.obtain(this.ahFY.ahFP, 1, localb).sendToTarget();
    AppMethodBeat.o(228678);
  }
  
  public final void onError(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(228708);
    this.ahFY.ahDA.bGe("onError, msgType:" + paramInt1 + ", errorCode:" + paramInt2);
    b.c localc = new b.c();
    localc.msgType = paramInt1;
    localc.errorCode = paramInt2;
    Message.obtain(this.ahFY.ahFP, 4, localc).sendToTarget();
    AppMethodBeat.o(228708);
  }
  
  public final void onInfoLong(int paramInt, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(228690);
    this.ahFY.ahDA.bGe("onInfoLong, infoType:" + paramInt + ", lParam1:" + paramLong1 + ", lParam2:" + paramLong2);
    b.d locald = new b.d();
    locald.infoType = paramInt;
    locald.lParam1 = paramLong1;
    locald.ahGa = paramLong2;
    Message.obtain(this.ahFY.ahFP, 2, locald).sendToTarget();
    AppMethodBeat.o(228690);
  }
  
  public final void onInfoObject(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(228698);
    this.ahFY.ahDA.bGe("onInfoObject, infoType:" + paramInt + ", objParam:" + paramObject);
    b.e locale = new b.e();
    locale.infoType = paramInt;
    locale.ahGb = paramObject;
    Message.obtain(this.ahFY.ahFP, 3, locale).sendToTarget();
    AppMethodBeat.o(228698);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.a.a.b.b.1
 * JD-Core Version:    0.7.0.1
 */