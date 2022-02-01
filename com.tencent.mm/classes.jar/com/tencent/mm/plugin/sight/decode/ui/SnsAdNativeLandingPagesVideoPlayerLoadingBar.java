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
import com.tencent.mm.plugin.ar.a.e;
import com.tencent.mm.plugin.ar.a.f;
import com.tencent.mm.plugin.ar.a.g;
import com.tencent.mm.sdk.platformtools.Log;

public class SnsAdNativeLandingPagesVideoPlayerLoadingBar
  extends RelativeLayout
  implements a
{
  private b PGw;
  private View contentView;
  private int cqW;
  private boolean hJg;
  private int mPosition;
  private ImageView sHm;
  private ImageView sHn;
  private ImageView sHo;
  private ImageView sHp;
  private TextView sHq;
  private TextView sHr;
  private int sHs;
  private float sHu;
  private int sHv;
  private int sHw;
  private int sHx;
  private int sHy;
  private boolean seH;
  
  public SnsAdNativeLandingPagesVideoPlayerLoadingBar(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(116139);
    this.PGw = null;
    this.contentView = null;
    this.sHn = null;
    this.sHo = null;
    this.sHp = null;
    this.cqW = 0;
    this.mPosition = 0;
    this.sHs = 0;
    this.seH = false;
    this.sHu = 0.0F;
    this.hJg = false;
    this.sHv = -1;
    this.sHw = -1;
    this.sHx = -1;
    this.sHy = -1;
    init();
    AppMethodBeat.o(116139);
  }
  
  public SnsAdNativeLandingPagesVideoPlayerLoadingBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(116140);
    this.PGw = null;
    this.contentView = null;
    this.sHn = null;
    this.sHo = null;
    this.sHp = null;
    this.cqW = 0;
    this.mPosition = 0;
    this.sHs = 0;
    this.seH = false;
    this.sHu = 0.0F;
    this.hJg = false;
    this.sHv = -1;
    this.sHw = -1;
    this.sHx = -1;
    this.sHy = -1;
    init();
    AppMethodBeat.o(116140);
  }
  
  public SnsAdNativeLandingPagesVideoPlayerLoadingBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(116141);
    this.PGw = null;
    this.contentView = null;
    this.sHn = null;
    this.sHo = null;
    this.sHp = null;
    this.cqW = 0;
    this.mPosition = 0;
    this.sHs = 0;
    this.seH = false;
    this.sHu = 0.0F;
    this.hJg = false;
    this.sHv = -1;
    this.sHw = -1;
    this.sHx = -1;
    this.sHy = -1;
    init();
    AppMethodBeat.o(116141);
  }
  
  public static String Bf(int paramInt)
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
  
  private void cxb()
  {
    AppMethodBeat.i(116150);
    if (this.cqW == 0)
    {
      AppMethodBeat.o(116150);
      return;
    }
    if (this.seH)
    {
      AppMethodBeat.o(116150);
      return;
    }
    if (this.sHo == null)
    {
      AppMethodBeat.o(116150);
      return;
    }
    if (getBarLen() == 0)
    {
      AppMethodBeat.o(116150);
      return;
    }
    int i = (this.sHo.getWidth() - this.sHo.getPaddingLeft() - this.sHo.getPaddingRight()) / 2;
    this.sHq.setText(Bf(this.mPosition / 60) + ":" + Bf(this.mPosition % 60));
    int j = ((FrameLayout.LayoutParams)this.sHn.getLayoutParams()).leftMargin;
    int k = this.sHo.getPaddingLeft();
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.sHo.getLayoutParams();
    localLayoutParams.leftMargin = (j - k + (int)(this.mPosition * 1.0D / this.cqW * getBarLen()) - i);
    this.sHo.setLayoutParams(localLayoutParams);
    localLayoutParams = (FrameLayout.LayoutParams)this.sHm.getLayoutParams();
    localLayoutParams.width = ((int)(this.mPosition * 1.0D / this.cqW * getBarLen()));
    this.sHm.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(116150);
  }
  
  private int getBarLen()
  {
    AppMethodBeat.i(116149);
    this.sHs = this.sHn.getWidth();
    int i = this.sHs;
    AppMethodBeat.o(116149);
    return i;
  }
  
  private int getCurrentTimeByBarPoint()
  {
    AppMethodBeat.i(116146);
    int i = ((FrameLayout.LayoutParams)this.sHn.getLayoutParams()).leftMargin;
    int j = this.sHo.getPaddingLeft();
    j = (int)((((FrameLayout.LayoutParams)this.sHo.getLayoutParams()).leftMargin - (i - j)) * 1.0D / getBarLen() * this.cqW);
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
    this.sHm = ((ImageView)this.contentView.findViewById(a.e.player_progress_bar_front));
    this.sHn = ((ImageView)this.contentView.findViewById(a.e.player_progress_bar_background));
    this.sHo = ((ImageView)this.contentView.findViewById(a.e.player_progress_point));
    this.sHp = ((ImageView)this.contentView.findViewById(a.e.play_btn));
    this.sHq = ((TextView)this.contentView.findViewById(a.e.play_current_time_tv));
    this.sHr = ((TextView)this.contentView.findViewById(a.e.play_total_time_tv));
    this.sHo.setOnTouchListener(new View.OnTouchListener()
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
            SnsAdNativeLandingPagesVideoPlayerLoadingBar.a(SnsAdNativeLandingPagesVideoPlayerLoadingBar.this).blc();
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
            SnsAdNativeLandingPagesVideoPlayerLoadingBar.h(SnsAdNativeLandingPagesVideoPlayerLoadingBar.this).setText(SnsAdNativeLandingPagesVideoPlayerLoadingBar.Bf(i / 60) + ":" + SnsAdNativeLandingPagesVideoPlayerLoadingBar.Bf(i % 60));
            SnsAdNativeLandingPagesVideoPlayerLoadingBar.a(SnsAdNativeLandingPagesVideoPlayerLoadingBar.this, true);
          }
          else if (SnsAdNativeLandingPagesVideoPlayerLoadingBar.i(SnsAdNativeLandingPagesVideoPlayerLoadingBar.this))
          {
            i = SnsAdNativeLandingPagesVideoPlayerLoadingBar.d(SnsAdNativeLandingPagesVideoPlayerLoadingBar.this);
            if (SnsAdNativeLandingPagesVideoPlayerLoadingBar.a(SnsAdNativeLandingPagesVideoPlayerLoadingBar.this) != null)
            {
              Log.i("MicroMsg.SnsAdNativeLandingPagesVideoPlayerLoadingBar", "current time : ".concat(String.valueOf(i)));
              SnsAdNativeLandingPagesVideoPlayerLoadingBar.a(SnsAdNativeLandingPagesVideoPlayerLoadingBar.this).tS(i);
            }
            SnsAdNativeLandingPagesVideoPlayerLoadingBar.a(SnsAdNativeLandingPagesVideoPlayerLoadingBar.this, false);
          }
        }
      }
    });
    AppMethodBeat.o(116142);
  }
  
  public final void gYF()
  {
    this.sHs = 0;
  }
  
  public boolean getIsPlay()
  {
    return this.hJg;
  }
  
  public int getVideoTotalTime()
  {
    return this.cqW;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(116143);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramInt1 != this.sHv) || (paramInt2 != this.sHw) || (paramInt3 != this.sHx) || (paramInt4 != this.sHy)) {
      cxb();
    }
    this.sHv = paramInt1;
    this.sHw = paramInt2;
    this.sHx = paramInt3;
    this.sHy = paramInt4;
    AppMethodBeat.o(116143);
  }
  
  public final void seek(int paramInt)
  {
    AppMethodBeat.i(116147);
    this.mPosition = paramInt;
    cxb();
    AppMethodBeat.o(116147);
  }
  
  public void setIplaySeekCallback(b paramb)
  {
    this.PGw = paramb;
  }
  
  public void setIsPlay(boolean paramBoolean)
  {
    AppMethodBeat.i(116145);
    this.hJg = paramBoolean;
    if (paramBoolean)
    {
      this.sHp.setImageResource(a.g.media_player_pause_btn);
      AppMethodBeat.o(116145);
      return;
    }
    this.sHp.setImageResource(a.g.media_player_play_btn);
    AppMethodBeat.o(116145);
  }
  
  public void setOnPlayButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(116144);
    this.sHp.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(116144);
  }
  
  public void setVideoTotalTime(final int paramInt)
  {
    AppMethodBeat.i(116148);
    if ((this.sHo.isShown()) && (this.sHo.getWidth() == 0))
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
    this.cqW = paramInt;
    this.mPosition = 0;
    this.sHr.setText(Bf(this.cqW / 60) + ":" + Bf(this.cqW % 60));
    cxb();
    AppMethodBeat.o(116148);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.ui.SnsAdNativeLandingPagesVideoPlayerLoadingBar
 * JD-Core Version:    0.7.0.1
 */