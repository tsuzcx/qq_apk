package com.tencent.trtc;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.liteav.trtc.impl.TRTCRoomInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.ITXLivePushListener;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Set;

final class d$21
  implements Runnable
{
  d$21(WXTRTCCloud paramWXTRTCCloud, String paramString, int paramInt, Bundle paramBundle) {}
  
  public final void run()
  {
    AppMethodBeat.i(14300);
    Object localObject;
    if ((TextUtils.isEmpty(this.a)) || ((WXTRTCCloud.access$4000(this.IIP).userId != null) && (this.a.equalsIgnoreCase(WXTRTCCloud.access$4100(this.IIP).userId))))
    {
      if (WXTRTCCloud.access$4200(this.IIP) != null)
      {
        localObject = (ITXLivePushListener)WXTRTCCloud.access$4200(this.IIP).get();
        if (localObject != null) {
          ((ITXLivePushListener)localObject).onPushEvent(this.b, this.IIU);
        }
        AppMethodBeat.o(14300);
      }
    }
    else
    {
      int i = this.IIU.getInt("EVT_STREAM_TYPE", 2);
      if (WXTRTCCloud.access$4300(this.IIP).getUser(this.a) != null)
      {
        localObject = null;
        if (i != 7) {
          break label211;
        }
        if (WXTRTCCloud.access$300(this.IIP).keySet().contains(this.a)) {
          localObject = (WeakReference)WXTRTCCloud.access$300(this.IIP).get(this.a);
        }
      }
    }
    for (;;)
    {
      if (localObject != null)
      {
        localObject = (ITXLivePlayListener)((WeakReference)localObject).get();
        if (localObject != null) {
          ((ITXLivePlayListener)localObject).onPlayEvent(this.b, this.IIU);
        }
      }
      AppMethodBeat.o(14300);
      return;
      label211:
      if (WXTRTCCloud.access$200(this.IIP).keySet().contains(this.a)) {
        localObject = (WeakReference)WXTRTCCloud.access$200(this.IIP).get(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.trtc.d.21
 * JD-Core Version:    0.7.0.1
 */