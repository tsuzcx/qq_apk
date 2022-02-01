package com.tencent.mm.plugin.sight.decode.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.aq.a.e;
import com.tencent.mm.plugin.aq.a.f;
import com.tencent.mm.plugin.aq.a.g;
import com.tencent.mm.sdk.platformtools.Log;

public class SnsAdNativeLandingPagesVideoPlayerLoadingBar
  extends RelativeLayout
  implements a
{
  private b JsU;
  private View contentView;
  private boolean fEq;
  private int mPosition;
  private boolean oZf;
  private ImageView pBZ;
  private ImageView pCa;
  private ImageView pCb;
  private ImageView pCc;
  private TextView pCd;
  private TextView pCe;
  private int pCf;
  private int pCg;
  private float pCi;
  private int pCj;
  private int pCk;
  private int pCl;
  private int pCm;
  
  public SnsAdNativeLandingPagesVideoPlayerLoadingBar(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(116139);
    this.JsU = null;
    this.contentView = null;
    this.pCa = null;
    this.pCb = null;
    this.pCc = null;
    this.pCf = 0;
    this.mPosition = 0;
    this.pCg = 0;
    this.oZf = false;
    this.pCi = 0.0F;
    this.fEq = false;
    this.pCj = -1;
    this.pCk = -1;
    this.pCl = -1;
    this.pCm = -1;
    init();
    AppMethodBeat.o(116139);
  }
  
  public SnsAdNativeLandingPagesVideoPlayerLoadingBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(116140);
    this.JsU = null;
    this.contentView = null;
    this.pCa = null;
    this.pCb = null;
    this.pCc = null;
    this.pCf = 0;
    this.mPosition = 0;
    this.pCg = 0;
    this.oZf = false;
    this.pCi = 0.0F;
    this.fEq = false;
    this.pCj = -1;
    this.pCk = -1;
    this.pCl = -1;
    this.pCm = -1;
    init();
    AppMethodBeat.o(116140);
  }
  
  public SnsAdNativeLandingPagesVideoPlayerLoadingBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(116141);
    this.JsU = null;
    this.contentView = null;
    this.pCa = null;
    this.pCb = null;
    this.pCc = null;
    this.pCf = 0;
    this.mPosition = 0;
    this.pCg = 0;
    this.oZf = false;
    this.pCi = 0.0F;
    this.fEq = false;
    this.pCj = -1;
    this.pCk = -1;
    this.pCl = -1;
    this.pCm = -1;
    init();
    AppMethodBeat.o(116141);
  }
  
  public static String AQ(int paramInt)
  {
    AppMethodBeat.i(116151);
    if (paramInt < 10)
    {
      String str = "0".concat(String.valueOf(paramInt));
      AppMethodBeat.o(116151);
      return str;
    }
    AppMethodBeat.o(116151);
    return String.valueOf(paramInt);
  }
  
  private void bWO()
  {
    AppMethodBeat.i(116150);
    if (this.pCf == 0)
    {
      AppMethodBeat.o(116150);
      return;
    }
    if (this.oZf)
    {
      AppMethodBeat.o(116150);
      return;
    }
    if (this.pCb == null)
    {
      AppMethodBeat.o(116150);
      return;
    }
    if (getBarLen() == 0)
    {
      AppMethodBeat.o(116150);
      return;
    }
    int i = (this.pCb.getWidth() - this.pCb.getPaddingLeft() - this.pCb.getPaddingRight()) / 2;
    this.pCd.setText(AQ(this.mPosition / 60) + ":" + AQ(this.mPosition % 60));
    int j = ((FrameLayout.LayoutParams)this.pCa.getLayoutParams()).leftMargin;
    int k = this.pCb.getPaddingLeft();
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.pCb.getLayoutParams();
    localLayoutParams.leftMargin = (j - k + (int)(this.mPosition * 1.0D / this.pCf * getBarLen()) - i);
    this.pCb.setLayoutParams(localLayoutParams);
    localLayoutParams = (FrameLayout.LayoutParams)this.pBZ.getLayoutParams();
    localLayoutParams.width = ((int)(this.mPosition * 1.0D / this.pCf * getBarLen()));
    this.pBZ.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(116150);
  }
  
  private int getBarLen()
  {
    AppMethodBeat.i(116149);
    this.pCg = this.pCa.getWidth();
    int i = this.pCg;
    AppMethodBeat.o(116149);
    return i;
  }
  
  private int getCurrentTimeByBarPoint()
  {
    AppMethodBeat.i(116146);
    int i = ((FrameLayout.LayoutParams)this.pCa.getLayoutParams()).leftMargin;
    int j = this.pCb.getPaddingLeft();
    j = (int)((((FrameLayout.LayoutParams)this.pCb.getLayoutParams()).leftMargin - (i - j)) * 1.0D / getBarLen() * this.pCf);
    i = j;
    if (j < 0) {
      i = 0;
    }
    AppMethodBeat.o(116146);
    return i;
  }
  
  private void init()
  {
    AppMethodBeat.i(116142);
    this.contentView = View.inflate(getContext(), a.f.sns_ad_natvie_landingpages_video_player_loading_bar, this);
    this.pBZ = ((ImageView)this.contentView.findViewById(a.e.player_progress_bar_front));
    this.pCa = ((ImageView)this.contentView.findViewById(a.e.player_progress_bar_background));
    this.pCb = ((ImageView)this.contentView.findViewById(a.e.player_progress_point));
    this.pCc = ((ImageView)this.contentView.findViewById(a.e.play_btn));
    this.pCd = ((TextView)this.contentView.findViewById(a.e.play_current_time_tv));
    this.pCe = ((TextView)this.contentView.findViewById(a.e.play_total_time_tv));
    this.pCb.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(116137);
        if (paramAnonymousMotionEvent.getAction() == 0)
        {
          Log.i("MicroMsg.SnsAdNativeLandingPagesVideoPlayerLoadingBar", "ontouch down");
          SnsAdNativeLandingPagesVideoPlayerLoadingBar.a(SnsAdNativeLandingPagesVideoPlayerLoadingBar.this, false);
          SnsAdNativeLandingPagesVideoPlayerLoadingBar.a(SnsAdNativeLandingPagesVideoPlayerLoadingBar.this, paramAnonymousMotionEvent.getX());
          if (SnsAdNativeLandingPagesVideoPlayerLoadingBar.a(SnsAdNativeLandingPagesVideoPlayerLoadingBar.this) != null) {
            SnsAdNativeLandingPagesVideoPlayerLoadingBar.a(SnsAdNativeLandingPagesVideoPlayerLoadingBar.this).aRo();
          }
        }
        for (;;)
        {
          AppMethodBeat.o(116137);
          return true;
          int i;
          if (paramAnonymousMotionEvent.getAction() == 2)
          {
            float f = paramAnonymousMotionEvent.getX();
            paramAnonymousView = (FrameLayout.LayoutParams)SnsAdNativeLandingPagesVideoPlayerLoadingBar.b(SnsAdNativeLandingPagesVideoPlayerLoadingBar.this).getLayoutParams();
            i = paramAnonymousView.leftMargin;
            int j = (int)(f - SnsAdNativeLandingPagesVideoPlayerLoadingBar.c(SnsAdNativeLandingPagesVideoPlayerLoadingBar.this));
            paramAnonymousView.leftMargin = SnsAdNativeLandingPagesVideoPlayerLoadingBar.a(SnsAdNativeLandingPagesVideoPlayerLoadingBar.this, j + i);
            SnsAdNativeLandingPagesVideoPlayerLoadingBar.b(SnsAdNativeLandingPagesVideoPlayerLoadingBar.this).setLayoutParams(paramAnonymousView);
            i = SnsAdNativeLandingPagesVideoPlayerLoadingBar.d(SnsAdNativeLandingPagesVideoPlayerLoadingBar.this);
            if (SnsAdNativeLandingPagesVideoPlayerLoadingBar.e(SnsAdNativeLandingPagesVideoPlayerLoadingBar.this) > 0)
            {
              paramAnonymousView = (FrameLayout.LayoutParams)SnsAdNativeLandingPagesVideoPlayerLoadingBar.f(SnsAdNativeLandingPagesVideoPlayerLoadingBar.this).getLayoutParams();
              paramAnonymousView.width = ((int)(i * 1.0D / SnsAdNativeLandingPagesVideoPlayerLoadingBar.e(SnsAdNativeLandingPagesVideoPlayerLoadingBar.this) * SnsAdNativeLandingPagesVideoPlayerLoadingBar.g(SnsAdNativeLandingPagesVideoPlayerLoadingBar.this)));
              SnsAdNativeLandingPagesVideoPlayerLoadingBar.f(SnsAdNativeLandingPagesVideoPlayerLoadingBar.this).setLayoutParams(paramAnonymousView);
            }
            SnsAdNativeLandingPagesVideoPlayerLoadingBar.h(SnsAdNativeLandingPagesVideoPlayerLoadingBar.this).setText(SnsAdNativeLandingPagesVideoPlayerLoadingBar.AQ(i / 60) + ":" + SnsAdNativeLandingPagesVideoPlayerLoadingBar.AQ(i % 60));
            SnsAdNativeLandingPagesVideoPlayerLoadingBar.a(SnsAdNativeLandingPagesVideoPlayerLoadingBar.this, true);
          }
          else if (SnsAdNativeLandingPagesVideoPlayerLoadingBar.i(SnsAdNativeLandingPagesVideoPlayerLoadingBar.this))
          {
            i = SnsAdNativeLandingPagesVideoPlayerLoadingBar.d(SnsAdNativeLandingPagesVideoPlayerLoadingBar.this);
            if (SnsAdNativeLandingPagesVideoPlayerLoadingBar.a(SnsAdNativeLandingPagesVideoPlayerLoadingBar.this) != null)
            {
              Log.i("MicroMsg.SnsAdNativeLandingPagesVideoPlayerLoadingBar", "current time : ".concat(String.valueOf(i)));
              SnsAdNativeLandingPagesVideoPlayerLoadingBar.a(SnsAdNativeLandingPagesVideoPlayerLoadingBar.this).tY(i);
            }
            SnsAdNativeLandingPagesVideoPlayerLoadingBar.a(SnsAdNativeLandingPagesVideoPlayerLoadingBar.this, false);
          }
        }
      }
    });
    AppMethodBeat.o(116142);
  }
  
  public final void fIM()
  {
    this.pCg = 0;
  }
  
  public boolean getIsPlay()
  {
    return this.fEq;
  }
  
  public int getVideoTotalTime()
  {
    return this.pCf;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(116143);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramInt1 != this.pCj) || (paramInt2 != this.pCk) || (paramInt3 != this.pCl) || (paramInt4 != this.pCm)) {
      bWO();
    }
    this.pCj = paramInt1;
    this.pCk = paramInt2;
    this.pCl = paramInt3;
    this.pCm = paramInt4;
    AppMethodBeat.o(116143);
  }
  
  public final void seek(int paramInt)
  {
    AppMethodBeat.i(116147);
    this.mPosition = paramInt;
    bWO();
    AppMethodBeat.o(116147);
  }
  
  public void setIplaySeekCallback(b paramb)
  {
    this.JsU = paramb;
  }
  
  public void setIsPlay(boolean paramBoolean)
  {
    AppMethodBeat.i(116145);
    this.fEq = paramBoolean;
    if (paramBoolean)
    {
      this.pCc.setImageResource(a.g.media_player_pause_btn);
      AppMethodBeat.o(116145);
      return;
    }
    this.pCc.setImageResource(a.g.media_player_play_btn);
    AppMethodBeat.o(116145);
  }
  
  public void setOnPlayButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(116144);
    this.pCc.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(116144);
  }
  
  public void setVideoTotalTime(final int paramInt)
  {
    AppMethodBeat.i(116148);
    if ((this.pCb.isShown()) && (this.pCb.getWidth() == 0))
    {
      post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(116138);
          SnsAdNativeLandingPagesVideoPlayerLoadingBar.this.setVideoTotalTime(paramInt);
          AppMethodBeat.o(116138);
        }
      });
      AppMethodBeat.o(116148);
      return;
    }
    this.pCf = paramInt;
    this.mPosition = 0;
    this.pCe.setText(AQ(this.pCf / 60) + ":" + AQ(this.pCf % 60));
    bWO();
    AppMethodBeat.o(116148);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.ui.SnsAdNativeLandingPagesVideoPlayerLoadingBar
 * JD-Core Version:    0.7.0.1
 */