package com.tencent.mm.plugin.sns.ad.timeline.video.online;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.ui.OnlineVideoView;
import com.tencent.mm.plugin.sns.ui.ap;
import com.tencent.mm.sdk.platformtools.Log;

public class CardOnlineVideoView
  extends OnlineVideoView
{
  private View JLf;
  private String cY;
  private volatile int mState;
  
  public CardOnlineVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(260414);
    this.mState = 0;
    init();
    AppMethodBeat.o(260414);
  }
  
  public CardOnlineVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(260417);
    this.mState = 0;
    init();
    AppMethodBeat.o(260417);
  }
  
  private void fLI()
  {
    AppMethodBeat.i(260421);
    if (this.JLf != null) {
      this.JLf.setVisibility(4);
    }
    AppMethodBeat.o(260421);
  }
  
  private void init()
  {
    AppMethodBeat.i(260419);
    this.JLf = findViewById(i.f.videoview_play_btn);
    AppMethodBeat.o(260419);
  }
  
  public final void fLJ()
  {
    AppMethodBeat.i(260424);
    this.mState = 1;
    super.fLJ();
    fLI();
    gA(true);
    AppMethodBeat.o(260424);
  }
  
  public String getMediaId()
  {
    return this.cY;
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(260425);
    super.onAttachedToWindow();
    Log.d("SnsAd.CardOnlineVideoView", "the online video view is attached to window, hashcode " + hashCode());
    AppMethodBeat.o(260425);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(260427);
    Log.d("SnsAd.CardOnlineVideoView", "onDestroy is called " + this.cY + ", hashcode " + hashCode());
    super.onDestroy();
    this.mState = 0;
    AppMethodBeat.o(260427);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(260426);
    super.onDetachedFromWindow();
    Log.d("SnsAd.CardOnlineVideoView", "the online video view detached from window, hashcode " + hashCode());
    Log.d("SnsAd.CardOnlineVideoView", "asyncStop is called " + this.cY + ", hashcode " + hashCode());
    this.cY = "";
    if ((this.mState == 2) || (this.mState == 0))
    {
      AppMethodBeat.o(260426);
      return;
    }
    if (this.KHu != null)
    {
      this.KHu.stop();
      this.KHu = null;
    }
    if (this.KHk != null)
    {
      this.KHk.fUC();
      this.KHk.clear();
      this.KHk = null;
    }
    fTZ();
    this.mState = 2;
    h.ZvG.be(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(208610);
        CardOnlineVideoView.this.onDestroy();
        AppMethodBeat.o(208610);
      }
    });
    AppMethodBeat.o(260426);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(260423);
    this.mState = 1;
    fLI();
    super.onResume();
    AppMethodBeat.o(260423);
  }
  
  public void setMediaId(String paramString)
  {
    this.cY = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.video.online.CardOnlineVideoView
 * JD-Core Version:    0.7.0.1
 */