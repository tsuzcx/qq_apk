package com.tencent.mm.plugin.sns.ad.timeline.video.online;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.OnlineVideoView;
import com.tencent.mm.plugin.sns.ui.an;
import com.tencent.mm.sdk.platformtools.Log;

public class CardOnlineVideoView
  extends OnlineVideoView
{
  private View DzP;
  private String Mc;
  private volatile int mState;
  
  public CardOnlineVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(202308);
    this.mState = 0;
    init();
    AppMethodBeat.o(202308);
  }
  
  public CardOnlineVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(202309);
    this.mState = 0;
    init();
    AppMethodBeat.o(202309);
  }
  
  private void eYc()
  {
    AppMethodBeat.i(202311);
    if (this.DzP != null) {
      this.DzP.setVisibility(4);
    }
    AppMethodBeat.o(202311);
  }
  
  private void init()
  {
    AppMethodBeat.i(202310);
    this.DzP = findViewById(2131309853);
    AppMethodBeat.o(202310);
  }
  
  public final void eYd()
  {
    AppMethodBeat.i(202313);
    this.mState = 1;
    super.eYd();
    eYc();
    fO(true);
    AppMethodBeat.o(202313);
  }
  
  public String getMediaId()
  {
    return this.Mc;
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(202314);
    super.onAttachedToWindow();
    Log.d("SnsAd.CardOnlineVideoView", "the online video view is attached to window, hashcode " + hashCode());
    AppMethodBeat.o(202314);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(202316);
    Log.d("SnsAd.CardOnlineVideoView", "onDestroy is called " + this.Mc + ", hashcode " + hashCode());
    super.onDestroy();
    this.mState = 0;
    AppMethodBeat.o(202316);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(202315);
    super.onDetachedFromWindow();
    Log.d("SnsAd.CardOnlineVideoView", "the online video view detached from window, hashcode " + hashCode());
    Log.d("SnsAd.CardOnlineVideoView", "asyncStop is called " + this.Mc + ", hashcode " + hashCode());
    this.Mc = "";
    if ((this.mState == 2) || (this.mState == 0))
    {
      AppMethodBeat.o(202315);
      return;
    }
    if (this.EtL != null)
    {
      this.EtL.fgw();
      this.EtL.clear();
      this.EtL = null;
    }
    fgc();
    this.mState = 2;
    h.RTc.aX(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(202307);
        CardOnlineVideoView.this.onDestroy();
        AppMethodBeat.o(202307);
      }
    });
    AppMethodBeat.o(202315);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(202312);
    this.mState = 1;
    eYc();
    super.onResume();
    AppMethodBeat.o(202312);
  }
  
  public void setMediaId(String paramString)
  {
    this.Mc = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.video.online.CardOnlineVideoView
 * JD-Core Version:    0.7.0.1
 */