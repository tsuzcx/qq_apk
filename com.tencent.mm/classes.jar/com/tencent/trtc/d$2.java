package com.tencent.trtc;

import android.os.Bundle;
import com.tencent.liteav.basic.module.TXCStatus;
import com.tencent.liteav.trtc.impl.TRTCRoomInfo;
import com.tencent.liteav.trtc.impl.TRTCRoomInfo.UserInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.ITXLivePushListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

final class d$2
  implements Runnable
{
  d$2(WXTRTCCloud paramWXTRTCCloud, TRTCStatistics paramTRTCStatistics) {}
  
  public final void run()
  {
    AppMethodBeat.i(14303);
    String str1 = String.format("%d%%|%d%%", new Object[] { Integer.valueOf(this.IIL.appCpu), Integer.valueOf(this.IIL.systemCpu) });
    String str2 = TXCStatus.b("18446744073709551615", 10001);
    Object localObject1 = this.IIL.localArray.iterator();
    int k;
    int m;
    int n;
    int i1;
    int i2;
    int i3;
    int j;
    Object localObject3;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (TRTCStatistics.TRTCLocalStatistics)((Iterator)localObject1).next();
      if (((TRTCStatistics.TRTCLocalStatistics)localObject2).streamType == 0)
      {
        k = ((TRTCStatistics.TRTCLocalStatistics)localObject2).width;
        m = ((TRTCStatistics.TRTCLocalStatistics)localObject2).height;
        n = ((TRTCStatistics.TRTCLocalStatistics)localObject2).frameRate;
        i1 = ((TRTCStatistics.TRTCLocalStatistics)localObject2).videoBitrate;
        i2 = ((TRTCStatistics.TRTCLocalStatistics)localObject2).audioBitrate;
        i3 = WXTRTCCloud.access$4400(this.IIM, this.IIL.rtt, this.IIL.upLoss);
        i = 0;
        if (WXTRTCCloud.access$4500(this.IIM) == 1)
        {
          j = TXCStatus.c("18446744073709551615", 4006);
          i = j;
          if (n > 0) {
            i = (int)(j * 10 / n / 10.0F + 0.5D);
          }
        }
        localObject2 = new Bundle();
        ((Bundle)localObject2).putString("CPU_USAGE", str1);
        ((Bundle)localObject2).putInt("VIDEO_WIDTH", k);
        ((Bundle)localObject2).putInt("VIDEO_HEIGHT", m);
        ((Bundle)localObject2).putInt("VIDEO_FPS", n);
        ((Bundle)localObject2).putInt("VIDEO_GOP", i);
        ((Bundle)localObject2).putInt("NET_SPEED", i2 + i1);
        ((Bundle)localObject2).putInt("VIDEO_BITRATE", i1);
        ((Bundle)localObject2).putInt("AUDIO_BITRATE", i2);
        ((Bundle)localObject2).putString("AUDIO_PLAY_INFO", "");
        ((Bundle)localObject2).putString("SERVER_IP", str2);
        ((Bundle)localObject2).putInt("NET_QUALITY_LEVEL", i3);
        if (WXTRTCCloud.access$4200(this.IIM) != null)
        {
          localObject3 = (ITXLivePushListener)WXTRTCCloud.access$4200(this.IIM).get();
          if (localObject3 != null) {
            ((ITXLivePushListener)localObject3).onNetStatus((Bundle)localObject2);
          }
        }
      }
    }
    Object localObject2 = this.IIL.remoteArray.iterator();
    String str3;
    int i4;
    int i5;
    int i6;
    int i7;
    if (((Iterator)localObject2).hasNext())
    {
      localObject1 = (TRTCStatistics.TRTCRemoteStatistics)((Iterator)localObject2).next();
      i1 = ((TRTCStatistics.TRTCRemoteStatistics)localObject1).streamType;
      str3 = ((TRTCStatistics.TRTCRemoteStatistics)localObject1).userId;
      i2 = ((TRTCStatistics.TRTCRemoteStatistics)localObject1).width;
      i3 = ((TRTCStatistics.TRTCRemoteStatistics)localObject1).height;
      i4 = ((TRTCStatistics.TRTCRemoteStatistics)localObject1).frameRate;
      i5 = ((TRTCStatistics.TRTCRemoteStatistics)localObject1).videoBitrate;
      i6 = ((TRTCStatistics.TRTCRemoteStatistics)localObject1).audioBitrate;
      m = 0;
      k = 0;
      j = 0;
      i7 = WXTRTCCloud.access$4600(this.IIM, this.IIL.rtt, ((TRTCStatistics.TRTCRemoteStatistics)localObject1).finalLoss);
      localObject1 = WXTRTCCloud.access$4700(this.IIM).getUser(str3);
      if (localObject1 == null) {
        break label844;
      }
      i = 2;
      switch (i1)
      {
      default: 
        label512:
        m = TXCStatus.c(((TRTCRoomInfo.UserInfo)localObject1).userID, 2007);
        k = TXCStatus.c(((TRTCRoomInfo.UserInfo)localObject1).userID, 6010, i);
        n = TXCStatus.c(((TRTCRoomInfo.UserInfo)localObject1).userID, 6011, i);
        j = TXCStatus.c(((TRTCRoomInfo.UserInfo)localObject1).userID, 6012, i);
      }
    }
    label844:
    for (int i = n;; i = 0)
    {
      localObject3 = new Bundle();
      ((Bundle)localObject3).putString("CPU_USAGE", str1);
      ((Bundle)localObject3).putInt("VIDEO_WIDTH", i2);
      ((Bundle)localObject3).putInt("VIDEO_HEIGHT", i3);
      ((Bundle)localObject3).putInt("VIDEO_FPS", i4);
      ((Bundle)localObject3).putInt("NET_SPEED", i6 + i5);
      ((Bundle)localObject3).putInt("VIDEO_BITRATE", i5);
      ((Bundle)localObject3).putInt("AUDIO_BITRATE", i6);
      ((Bundle)localObject3).putInt("AUDIO_CACHE", m);
      ((Bundle)localObject3).putInt("VIDEO_CACHE", k);
      ((Bundle)localObject3).putInt("V_SUM_CACHE_SIZE", i);
      ((Bundle)localObject3).putInt("V_DEC_CACHE_SIZE", j);
      ((Bundle)localObject3).putString("AUDIO_PLAY_INFO", "");
      ((Bundle)localObject3).putString("SERVER_IP", str2);
      ((Bundle)localObject3).putInt("NET_QUALITY_LEVEL", i7);
      localObject1 = null;
      if (i1 == 2) {
        if (WXTRTCCloud.access$300(this.IIM).keySet().contains(str3)) {
          localObject1 = (WeakReference)WXTRTCCloud.access$300(this.IIM).get(str3);
        }
      }
      while (localObject1 != null)
      {
        localObject1 = (ITXLivePlayListener)((WeakReference)localObject1).get();
        if (localObject1 == null) {
          break;
        }
        ((ITXLivePlayListener)localObject1).onNetStatus((Bundle)localObject3);
        break;
        i = 2;
        break label512;
        i = 3;
        break label512;
        i = 7;
        break label512;
        if (WXTRTCCloud.access$200(this.IIM).keySet().contains(str3)) {
          localObject1 = (WeakReference)WXTRTCCloud.access$200(this.IIM).get(str3);
        }
      }
      AppMethodBeat.o(14303);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.trtc.d.2
 * JD-Core Version:    0.7.0.1
 */