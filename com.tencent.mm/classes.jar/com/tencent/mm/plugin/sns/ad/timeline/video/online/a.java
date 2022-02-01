package com.tencent.mm.plugin.sns.ad.timeline.video.online;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.g.k;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.OnlineVideoView;
import com.tencent.mm.plugin.sns.ui.OnlineVideoView.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

public final class a
  implements OnlineVideoView.a
{
  private SnsInfo DqO;
  private Reference<OnlineVideoView> DzR;
  private Reference<k> DzS;
  private int qbU;
  
  public a(SnsInfo paramSnsInfo, OnlineVideoView paramOnlineVideoView, k paramk, int paramInt)
  {
    AppMethodBeat.i(202317);
    this.DqO = paramSnsInfo;
    this.DzR = new WeakReference(paramOnlineVideoView);
    this.DzS = new WeakReference(paramk);
    this.qbU = paramInt;
    AppMethodBeat.o(202317);
  }
  
  private static String XR(int paramInt)
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
  
  public final void onCompletion()
  {
    AppMethodBeat.i(202319);
    Log.d("SnsAd.OnlineAdVideoCallback", "online player onCompletion is called , the item is " + XR(this.qbU));
    SnsInfo localSnsInfo = this.DqO;
    k localk = (k)this.DzS.get();
    OnlineVideoView localOnlineVideoView = (OnlineVideoView)this.DzR.get();
    long l;
    if ((localSnsInfo != null) && (localk != null))
    {
      l = localSnsInfo.field_snsId;
      Log.d("SnsAd.OnlineAdVideoCallback", "doOnlinePlayerCompletion is called, snsId=" + r.Jb(l));
      if (localSnsInfo.isAd()) {
        break label148;
      }
      Log.e("SnsAd.OnlineAdVideoCallback", "online player completion, !isAd,  snsId=" + r.Jb(l));
    }
    for (;;)
    {
      if (localOnlineVideoView != null) {
        localOnlineVideoView.aT(0, true);
      }
      AppMethodBeat.o(202319);
      return;
      label148:
      localk.I(l, false);
    }
  }
  
  public final void onStart(int paramInt)
  {
    AppMethodBeat.i(202318);
    Log.d("SnsAd.OnlineAdVideoCallback", "online player onStart is called, durationSecond=" + paramInt + ", the item is " + XR(this.qbU));
    AppMethodBeat.o(202318);
  }
  
  public final void xv(int paramInt)
  {
    AppMethodBeat.i(202320);
    SnsInfo localSnsInfo = this.DqO;
    k localk = (k)this.DzS.get();
    OnlineVideoView localOnlineVideoView = (OnlineVideoView)this.DzR.get();
    if ((localOnlineVideoView != null) && (localSnsInfo != null) && (localk != null))
    {
      long l1 = paramInt * 1000;
      long l2 = localOnlineVideoView.getDuration();
      Log.d("SnsAd.OnlineAdVideoCallback", "doOnlinePlayerPlaying is called , the second  is " + l1 + " the duration is " + l2);
      if ((localSnsInfo == null) || (localk == null))
      {
        Log.e("SnsAd.OnlineAdVideoCallback", "doOnNewPlayerPlaying is called , the holder or sns info is null");
        AppMethodBeat.o(202320);
        return;
      }
      long l3 = localSnsInfo.field_snsId;
      if (!localSnsInfo.isAd())
      {
        Log.w("SnsAd.OnlineAdVideoCallback", "doOnlinePlayerPlaying, the info is not Ad, snsId=" + r.Jb(l3));
        AppMethodBeat.o(202320);
        return;
      }
      localk.IT(localSnsInfo.field_snsId);
      localk.ao(localSnsInfo.field_snsId, l1);
      if (!localk.IQ(l3))
      {
        localk.c(l3, Util.currentTicks(), false);
        localk.e(l3, (int)(l2 / 1000L), false);
        localk.an(l3, l3);
        Log.d("SnsAd.OnlineAdVideoCallback", "doOnlinePlayerPlaying, addPlay3s, snsId=" + r.Jb(l3));
      }
    }
    AppMethodBeat.o(202320);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.video.online.a
 * JD-Core Version:    0.7.0.1
 */