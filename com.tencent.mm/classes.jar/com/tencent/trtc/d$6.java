package com.tencent.trtc;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.ITXLivePlayListener;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Set;

final class d$6
  implements Runnable
{
  d$6(WXTRTCCloud paramWXTRTCCloud, byte[] paramArrayOfByte, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(14290);
    Object localObject;
    if ((this.a != null) && (this.a.length > 0))
    {
      localObject = null;
      if (!WXTRTCCloud.access$200(this.IIO).keySet().contains(this.b)) {
        break label114;
      }
      localObject = (WeakReference)WXTRTCCloud.access$200(this.IIO).get(this.b);
    }
    for (;;)
    {
      if (localObject != null)
      {
        localObject = (ITXLivePlayListener)((WeakReference)localObject).get();
        if (localObject != null)
        {
          Bundle localBundle = new Bundle();
          localBundle.putByteArray("EVT_GET_MSG", this.a);
          ((ITXLivePlayListener)localObject).onPlayEvent(2012, localBundle);
        }
      }
      AppMethodBeat.o(14290);
      return;
      label114:
      if (WXTRTCCloud.access$300(this.IIO).keySet().contains(this.b)) {
        localObject = (WeakReference)WXTRTCCloud.access$300(this.IIO).get(this.b);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.trtc.d.6
 * JD-Core Version:    0.7.0.1
 */