package com.tencent.mm.plugin.sns.ad.timeline.video.online;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.g.l;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.OnlineVideoView;
import com.tencent.mm.plugin.sns.ui.OnlineVideoView.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

public final class a
  implements OnlineVideoView.c
{
  private SnsInfo PJQ;
  private Reference<OnlineVideoView> QcQ;
  private Reference<l> QcR;
  private int wCo;
  
  public a(SnsInfo paramSnsInfo, OnlineVideoView paramOnlineVideoView, l paraml, int paramInt)
  {
    AppMethodBeat.i(310965);
    this.PJQ = paramSnsInfo;
    this.QcQ = new WeakReference(paramOnlineVideoView);
    this.QcR = new WeakReference(paraml);
    this.wCo = paramInt;
    AppMethodBeat.o(310965);
  }
  
  private static String ajO(int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    default: 
      return "";
    case 1: 
      return "normal time line item";
    }
    return "base card time line item";
  }
  
  public final void Bh(int paramInt)
  {
    AppMethodBeat.i(310990);
    SnsInfo localSnsInfo = this.PJQ;
    l locall = (l)this.QcR.get();
    OnlineVideoView localOnlineVideoView = (OnlineVideoView)this.QcQ.get();
    if ((localOnlineVideoView != null) && (localSnsInfo != null) && (locall != null))
    {
      long l1 = paramInt;
      long l2 = localOnlineVideoView.getDuration();
      Log.d("SnsAd.OnlineAdVideoCallback", "doOnlinePlayerPlaying is called , the second  is " + l1 + " the duration is " + l2);
      if ((localSnsInfo == null) || (locall == null))
      {
        Log.e("SnsAd.OnlineAdVideoCallback", "doOnNewPlayerPlaying is called , the holder or sns info is null");
        AppMethodBeat.o(310990);
        return;
      }
      long l3 = localSnsInfo.field_snsId;
      if (!localSnsInfo.isAd())
      {
        Log.w("SnsAd.OnlineAdVideoCallback", "doOnlinePlayerPlaying, the info is not Ad, snsId=" + t.uA(l3));
        AppMethodBeat.o(310990);
        return;
      }
      locall.ut(localSnsInfo.field_snsId);
      locall.bj(localSnsInfo.field_snsId, l1);
      if (!locall.uq(l3))
      {
        locall.c(l3, Util.currentTicks(), false);
        locall.f(l3, (int)(l2 / 1000L), false);
        locall.bi(l3, l3);
        Log.d("SnsAd.OnlineAdVideoCallback", "doOnlinePlayerPlaying, addPlay3s, snsId=" + t.uA(l3));
      }
    }
    AppMethodBeat.o(310990);
  }
  
  public final void onCompletion()
  {
    AppMethodBeat.i(310982);
    Log.d("SnsAd.OnlineAdVideoCallback", "online player onCompletion is called , the item is " + ajO(this.wCo));
    SnsInfo localSnsInfo = this.PJQ;
    l locall = (l)this.QcR.get();
    OnlineVideoView localOnlineVideoView = (OnlineVideoView)this.QcQ.get();
    long l;
    if ((localSnsInfo != null) && (locall != null))
    {
      l = localSnsInfo.field_snsId;
      Log.d("SnsAd.OnlineAdVideoCallback", "doOnlinePlayerCompletion is called, snsId=" + t.uA(l));
      if (localSnsInfo.isAd()) {
        break label148;
      }
      Log.e("SnsAd.OnlineAdVideoCallback", "online player completion, !isAd,  snsId=" + t.uA(l));
    }
    for (;;)
    {
      if (localOnlineVideoView != null) {
        localOnlineVideoView.bJ(0, true);
      }
      AppMethodBeat.o(310982);
      return;
      label148:
      locall.S(l, false);
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(310995);
    Log.d("SnsAd.OnlineAdVideoCallback", "online player paused.");
    l locall = (l)this.QcR.get();
    SnsInfo localSnsInfo = this.PJQ;
    if ((locall != null) && (localSnsInfo != null)) {
      locall.uu(localSnsInfo.field_snsId);
    }
    AppMethodBeat.o(310995);
  }
  
  public final void onStart(int paramInt)
  {
    AppMethodBeat.i(310973);
    Log.d("SnsAd.OnlineAdVideoCallback", "online player onStart is called, durationSecond=" + paramInt + ", the item is " + ajO(this.wCo));
    AppMethodBeat.o(310973);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.video.online.a
 * JD-Core Version:    0.7.0.1
 */