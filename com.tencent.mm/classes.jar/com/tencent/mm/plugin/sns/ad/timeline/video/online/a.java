package com.tencent.mm.plugin.sns.ad.timeline.video.online;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.f.l;
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
  private Reference<OnlineVideoView> JLh;
  private Reference<l> JLi;
  private SnsInfo Jws;
  private int txS;
  
  public a(SnsInfo paramSnsInfo, OnlineVideoView paramOnlineVideoView, l paraml, int paramInt)
  {
    AppMethodBeat.i(209751);
    this.Jws = paramSnsInfo;
    this.JLh = new WeakReference(paramOnlineVideoView);
    this.JLi = new WeakReference(paraml);
    this.txS = paramInt;
    AppMethodBeat.o(209751);
  }
  
  private static String aff(int paramInt)
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
  
  public final void AS(int paramInt)
  {
    AppMethodBeat.i(209755);
    SnsInfo localSnsInfo = this.Jws;
    l locall = (l)this.JLi.get();
    OnlineVideoView localOnlineVideoView = (OnlineVideoView)this.JLh.get();
    if ((localOnlineVideoView != null) && (localSnsInfo != null) && (locall != null))
    {
      long l1 = paramInt;
      long l2 = localOnlineVideoView.getDuration();
      Log.d("SnsAd.OnlineAdVideoCallback", "doOnlinePlayerPlaying is called , the second  is " + l1 + " the duration is " + l2);
      if ((localSnsInfo == null) || (locall == null))
      {
        Log.e("SnsAd.OnlineAdVideoCallback", "doOnNewPlayerPlaying is called , the holder or sns info is null");
        AppMethodBeat.o(209755);
        return;
      }
      long l3 = localSnsInfo.field_snsId;
      if (!localSnsInfo.isAd())
      {
        Log.w("SnsAd.OnlineAdVideoCallback", "doOnlinePlayerPlaying, the info is not Ad, snsId=" + t.Qu(l3));
        AppMethodBeat.o(209755);
        return;
      }
      locall.Qm(localSnsInfo.field_snsId);
      locall.az(localSnsInfo.field_snsId, l1);
      if (!locall.Qj(l3))
      {
        locall.c(l3, Util.currentTicks(), false);
        locall.e(l3, (int)(l2 / 1000L), false);
        locall.ay(l3, l3);
        Log.d("SnsAd.OnlineAdVideoCallback", "doOnlinePlayerPlaying, addPlay3s, snsId=" + t.Qu(l3));
      }
    }
    AppMethodBeat.o(209755);
  }
  
  public final void onCompletion()
  {
    AppMethodBeat.i(209753);
    Log.d("SnsAd.OnlineAdVideoCallback", "online player onCompletion is called , the item is " + aff(this.txS));
    SnsInfo localSnsInfo = this.Jws;
    l locall = (l)this.JLi.get();
    OnlineVideoView localOnlineVideoView = (OnlineVideoView)this.JLh.get();
    long l;
    if ((localSnsInfo != null) && (locall != null))
    {
      l = localSnsInfo.field_snsId;
      Log.d("SnsAd.OnlineAdVideoCallback", "doOnlinePlayerCompletion is called, snsId=" + t.Qu(l));
      if (localSnsInfo.isAd()) {
        break label148;
      }
      Log.e("SnsAd.OnlineAdVideoCallback", "online player completion, !isAd,  snsId=" + t.Qu(l));
    }
    for (;;)
    {
      if (localOnlineVideoView != null) {
        localOnlineVideoView.bc(0, true);
      }
      AppMethodBeat.o(209753);
      return;
      label148:
      locall.I(l, false);
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(209757);
    Log.d("SnsAd.OnlineAdVideoCallback", "online player paused.");
    l locall = (l)this.JLi.get();
    SnsInfo localSnsInfo = this.Jws;
    if ((locall != null) && (localSnsInfo != null)) {
      locall.Qn(localSnsInfo.field_snsId);
    }
    AppMethodBeat.o(209757);
  }
  
  public final void onStart(int paramInt)
  {
    AppMethodBeat.i(209752);
    Log.d("SnsAd.OnlineAdVideoCallback", "online player onStart is called, durationSecond=" + paramInt + ", the item is " + aff(this.txS));
    AppMethodBeat.o(209752);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.video.online.a
 * JD-Core Version:    0.7.0.1
 */