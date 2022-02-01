package com.tencent.mm.plugin.sns.ad.timeline.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.d.i;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.ui.OnlineVideoView;
import com.tencent.mm.plugin.sns.ui.OnlineVideoView.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

public final class a
  implements OnlineVideoView.a
{
  private int oHD;
  private p yVM;
  private Reference<OnlineVideoView> zbq;
  private Reference<i> zbr;
  
  public a(p paramp, OnlineVideoView paramOnlineVideoView, i parami, int paramInt)
  {
    AppMethodBeat.i(197685);
    this.yVM = paramp;
    this.zbq = new WeakReference(paramOnlineVideoView);
    this.zbr = new WeakReference(parami);
    this.oHD = paramInt;
    AppMethodBeat.o(197685);
  }
  
  private static String PB(int paramInt)
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
    AppMethodBeat.i(197687);
    ad.d("SnsAd.OnlineAdVideoCallback", "online player onCompletion is called , the item is " + PB(this.oHD));
    p localp = this.yVM;
    i locali = (i)this.zbr.get();
    OnlineVideoView localOnlineVideoView = (OnlineVideoView)this.zbq.get();
    long l;
    if ((localp != null) && (locali != null))
    {
      l = localp.field_snsId;
      ad.d("SnsAd.OnlineAdVideoCallback", "doOnlinePlayerCompletion is called, snsId=" + q.zw(l));
      if (localp.QM(32)) {
        break label150;
      }
      ad.e("SnsAd.OnlineAdVideoCallback", "online player completion, !isAd,  snsId=" + q.zw(l));
    }
    for (;;)
    {
      if (localOnlineVideoView != null) {
        localOnlineVideoView.aB(0, true);
      }
      AppMethodBeat.o(197687);
      return;
      label150:
      locali.A(l, false);
    }
  }
  
  public final void onStart(int paramInt)
  {
    AppMethodBeat.i(197686);
    ad.d("SnsAd.OnlineAdVideoCallback", "online player onStart is called, durationSecond=" + paramInt + ", the item is " + PB(this.oHD));
    AppMethodBeat.o(197686);
  }
  
  public final void tt(int paramInt)
  {
    AppMethodBeat.i(197688);
    p localp = this.yVM;
    i locali = (i)this.zbr.get();
    OnlineVideoView localOnlineVideoView = (OnlineVideoView)this.zbq.get();
    if ((localOnlineVideoView != null) && (localp != null) && (locali != null))
    {
      long l1 = paramInt * 1000;
      long l2 = localOnlineVideoView.getDuration();
      ad.d("SnsAd.OnlineAdVideoCallback", "doOnlinePlayerPlaying is called , the second  is " + l1 + " the duration is " + l2);
      if ((localp == null) || (locali == null))
      {
        ad.e("SnsAd.OnlineAdVideoCallback", "doOnNewPlayerPlaying is called , the holder or sns info is null");
        AppMethodBeat.o(197688);
        return;
      }
      long l3 = localp.field_snsId;
      if (!localp.QM(32))
      {
        ad.w("SnsAd.OnlineAdVideoCallback", "doOnlinePlayerPlaying, the info is not Ad, snsId=" + q.zw(l3));
        AppMethodBeat.o(197688);
        return;
      }
      locali.zp(localp.field_snsId);
      locali.ak(localp.field_snsId, l1);
      if (!locali.zm(l3))
      {
        locali.d(l3, bt.HI(), false);
        locali.e(l3, (int)(l2 / 1000L), false);
        locali.aj(l3, l3);
        ad.d("SnsAd.OnlineAdVideoCallback", "doOnlinePlayerPlaying, addPlay3s, snsId=" + q.zw(l3));
      }
    }
    AppMethodBeat.o(197688);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.c.a.a
 * JD-Core Version:    0.7.0.1
 */