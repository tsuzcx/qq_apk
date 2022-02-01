package com.tencent.mm.plugin.sns.ad.timeline.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.e.j;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.ui.OnlineVideoView;
import com.tencent.mm.plugin.sns.ui.OnlineVideoView.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

public final class a
  implements OnlineVideoView.a
{
  private int oOf;
  private p zlW;
  private Reference<OnlineVideoView> zrU;
  private Reference<j> zrV;
  
  public a(p paramp, OnlineVideoView paramOnlineVideoView, j paramj, int paramInt)
  {
    AppMethodBeat.i(219157);
    this.zlW = paramp;
    this.zrU = new WeakReference(paramOnlineVideoView);
    this.zrV = new WeakReference(paramj);
    this.oOf = paramInt;
    AppMethodBeat.o(219157);
  }
  
  private static String Qi(int paramInt)
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
    AppMethodBeat.i(219159);
    ae.d("SnsAd.OnlineAdVideoCallback", "online player onCompletion is called , the item is " + Qi(this.oOf));
    p localp = this.zlW;
    j localj = (j)this.zrV.get();
    OnlineVideoView localOnlineVideoView = (OnlineVideoView)this.zrU.get();
    long l;
    if ((localp != null) && (localj != null))
    {
      l = localp.field_snsId;
      ae.d("SnsAd.OnlineAdVideoCallback", "doOnlinePlayerCompletion is called, snsId=" + r.zV(l));
      if (localp.Rt(32)) {
        break label150;
      }
      ae.e("SnsAd.OnlineAdVideoCallback", "online player completion, !isAd,  snsId=" + r.zV(l));
    }
    for (;;)
    {
      if (localOnlineVideoView != null) {
        localOnlineVideoView.aE(0, true);
      }
      AppMethodBeat.o(219159);
      return;
      label150:
      localj.C(l, false);
    }
  }
  
  public final void onStart(int paramInt)
  {
    AppMethodBeat.i(219158);
    ae.d("SnsAd.OnlineAdVideoCallback", "online player onStart is called, durationSecond=" + paramInt + ", the item is " + Qi(this.oOf));
    AppMethodBeat.o(219158);
  }
  
  public final void tx(int paramInt)
  {
    AppMethodBeat.i(219160);
    p localp = this.zlW;
    j localj = (j)this.zrV.get();
    OnlineVideoView localOnlineVideoView = (OnlineVideoView)this.zrU.get();
    if ((localOnlineVideoView != null) && (localp != null) && (localj != null))
    {
      long l1 = paramInt * 1000;
      long l2 = localOnlineVideoView.getDuration();
      ae.d("SnsAd.OnlineAdVideoCallback", "doOnlinePlayerPlaying is called , the second  is " + l1 + " the duration is " + l2);
      if ((localp == null) || (localj == null))
      {
        ae.e("SnsAd.OnlineAdVideoCallback", "doOnNewPlayerPlaying is called , the holder or sns info is null");
        AppMethodBeat.o(219160);
        return;
      }
      long l3 = localp.field_snsId;
      if (!localp.Rt(32))
      {
        ae.w("SnsAd.OnlineAdVideoCallback", "doOnlinePlayerPlaying, the info is not Ad, snsId=" + r.zV(l3));
        AppMethodBeat.o(219160);
        return;
      }
      localj.zO(localp.field_snsId);
      localj.aj(localp.field_snsId, l1);
      if (!localj.zL(l3))
      {
        localj.d(l3, bu.HQ(), false);
        localj.e(l3, (int)(l2 / 1000L), false);
        localj.ai(l3, l3);
        ae.d("SnsAd.OnlineAdVideoCallback", "doOnlinePlayerPlaying, addPlay3s, snsId=" + r.zV(l3));
      }
    }
    AppMethodBeat.o(219160);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.c.a.a
 * JD-Core Version:    0.7.0.1
 */