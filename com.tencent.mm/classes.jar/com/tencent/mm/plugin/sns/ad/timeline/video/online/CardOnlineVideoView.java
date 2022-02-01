package com.tencent.mm.plugin.sns.ad.timeline.video.online;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.ui.OnlineVideoView;
import com.tencent.mm.plugin.sns.ui.aq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.h;

public class CardOnlineVideoView
  extends OnlineVideoView
{
  private View QcO;
  private String cY;
  private volatile int mState;
  
  public CardOnlineVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(310964);
    this.mState = 0;
    init();
    AppMethodBeat.o(310964);
  }
  
  public CardOnlineVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(310971);
    this.mState = 0;
    init();
    AppMethodBeat.o(310971);
  }
  
  private void hce()
  {
    AppMethodBeat.i(310984);
    if (this.QcO != null) {
      this.QcO.setVisibility(4);
    }
    AppMethodBeat.o(310984);
  }
  
  private void init()
  {
    AppMethodBeat.i(310980);
    this.QcO = findViewById(b.f.videoview_play_btn);
    AppMethodBeat.o(310980);
  }
  
  public final void bcl()
  {
    AppMethodBeat.i(310998);
    this.mState = 1;
    super.bcl();
    hce();
    ho(true);
    AppMethodBeat.o(310998);
  }
  
  public String getMediaId()
  {
    return this.cY;
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(311009);
    super.onAttachedToWindow();
    Log.d("SnsAd.CardOnlineVideoView", "the online video view is attached to window, hashcode " + hashCode());
    AppMethodBeat.o(311009);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(311029);
    Log.d("SnsAd.CardOnlineVideoView", "onDestroy is called " + this.cY + ", hashcode " + hashCode());
    super.onDestroy();
    this.mState = 0;
    AppMethodBeat.o(311029);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(311020);
    super.onDetachedFromWindow();
    Log.d("SnsAd.CardOnlineVideoView", "the online video view detached from window, hashcode " + hashCode());
    Log.d("SnsAd.CardOnlineVideoView", "asyncStop is called " + this.cY + ", hashcode " + hashCode());
    this.cY = "";
    if ((this.mState == 2) || (this.mState == 0))
    {
      AppMethodBeat.o(311020);
      return;
    }
    if (this.RgU != null)
    {
      this.RgU.stop();
      this.RgU = null;
    }
    if (this.RgK != null)
    {
      this.RgK.hmT();
      this.RgK.clear();
      this.RgK = null;
    }
    hmt();
    this.mState = 2;
    h.ahAA.bm(new CardOnlineVideoView.1(this));
    AppMethodBeat.o(311020);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(310993);
    this.mState = 1;
    hce();
    super.onResume();
    AppMethodBeat.o(310993);
  }
  
  public void setMediaId(String paramString)
  {
    this.cY = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.video.online.CardOnlineVideoView
 * JD-Core Version:    0.7.0.1
 */