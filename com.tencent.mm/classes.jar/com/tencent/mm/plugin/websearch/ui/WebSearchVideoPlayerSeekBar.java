package com.tencent.mm.plugin.websearch.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.decode.ui.AdVideoPlayerLoadingBar;
import com.tencent.mm.plugin.sight.decode.ui.b;
import com.tencent.mm.pluginsdk.ui.g;
import com.tencent.mm.sdk.platformtools.ad;

public class WebSearchVideoPlayerSeekBar
  extends AdVideoPlayerLoadingBar
  implements g
{
  private float cEZ;
  protected boolean dkr = false;
  private int ktS = -1;
  private int ktT = -1;
  private int ktU = -1;
  
  public WebSearchVideoPlayerSeekBar(Context paramContext)
  {
    super(paramContext);
  }
  
  public WebSearchVideoPlayerSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public WebSearchVideoPlayerSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private int So(int paramInt)
  {
    AppMethodBeat.i(110244);
    int i = paramInt;
    if (paramInt > getBarLen()) {
      i = getBarLen();
    }
    paramInt = ((FrameLayout.LayoutParams)this.ktf.getLayoutParams()).leftMargin;
    int j = getBarPointWidth();
    AppMethodBeat.o(110244);
    return paramInt + i - (j >>> 1);
  }
  
  private int getBarPointPaddingLeft()
  {
    AppMethodBeat.i(110236);
    if (this.ktT == -1) {
      this.ktT = this.ktg.getPaddingLeft();
    }
    int i = this.ktT;
    AppMethodBeat.o(110236);
    return i;
  }
  
  private int getBarPointPaddingRight()
  {
    AppMethodBeat.i(110237);
    if (this.ktU == -1) {
      this.ktU = this.ktg.getPaddingRight();
    }
    int i = this.ktU;
    AppMethodBeat.o(110237);
    return i;
  }
  
  private int getCurProgressBarLen()
  {
    AppMethodBeat.i(110234);
    int i = this.kte.getWidth();
    AppMethodBeat.o(110234);
    return i;
  }
  
  private int getCurTimeByProgressBar()
  {
    AppMethodBeat.i(110233);
    int i = (int)(getCurProgressBarLen() * 1.0D / getBarLen() * this.ktk);
    AppMethodBeat.o(110233);
    return i;
  }
  
  protected final int Sm(int paramInt)
  {
    AppMethodBeat.i(110238);
    if (paramInt <= 0)
    {
      AppMethodBeat.o(110238);
      return 0;
    }
    if (paramInt >= this.ktk)
    {
      paramInt = getBarLen();
      AppMethodBeat.o(110238);
      return paramInt;
    }
    paramInt = (int)(paramInt * 1.0D / this.ktk * getBarLen());
    AppMethodBeat.o(110238);
    return paramInt;
  }
  
  protected final void Sn(int paramInt)
  {
    AppMethodBeat.i(110243);
    int i;
    if (paramInt > getBarLen()) {
      i = getBarLen();
    }
    for (;;)
    {
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.ktg.getLayoutParams();
      localLayoutParams.leftMargin = So(i);
      this.ktg.setLayoutParams(localLayoutParams);
      localLayoutParams = (FrameLayout.LayoutParams)this.kte.getLayoutParams();
      localLayoutParams.width = i;
      this.kte.setLayoutParams(localLayoutParams);
      this.ktg.requestLayout();
      this.kte.requestLayout();
      AppMethodBeat.o(110243);
      return;
      i = paramInt;
      if (paramInt < 0) {
        i = 0;
      }
    }
  }
  
  public void bdT()
  {
    AppMethodBeat.i(110242);
    if (this.ktk == 0)
    {
      AppMethodBeat.o(110242);
      return;
    }
    if (this.jVE)
    {
      AppMethodBeat.o(110242);
      return;
    }
    if (this.ktg == null)
    {
      AppMethodBeat.o(110242);
      return;
    }
    if (getBarLen() == 0)
    {
      AppMethodBeat.o(110242);
      return;
    }
    if (this.mPosition == this.ktk) {
      ad.i("MicroMsg.WebSearch.WebSearchVideoPlayerSeekBar", "test");
    }
    this.kti.setText(rX(this.mPosition / 60) + ":" + rX(this.mPosition % 60));
    Sn(Sm(this.mPosition));
    AppMethodBeat.o(110242);
  }
  
  public int getBarLen()
  {
    AppMethodBeat.i(110239);
    int i = this.ktf.getWidth();
    AppMethodBeat.o(110239);
    return i;
  }
  
  public int getBarPointWidth()
  {
    AppMethodBeat.i(110235);
    if (this.ktS == -1) {
      this.ktS = this.ktg.getWidth();
    }
    int i = this.ktS;
    AppMethodBeat.o(110235);
    return i;
  }
  
  public int getLayoutId()
  {
    return 2131495834;
  }
  
  public ImageView getPlayBtn()
  {
    return this.kth;
  }
  
  public TextView getPlaytimeTv()
  {
    return this.kti;
  }
  
  public final void gp(boolean paramBoolean)
  {
    AppMethodBeat.i(110248);
    setIsPlay(paramBoolean);
    AppMethodBeat.o(110248);
  }
  
  public void init()
  {
    AppMethodBeat.i(110232);
    this.contentView = View.inflate(getContext(), getLayoutId(), this);
    this.kte = ((ImageView)this.contentView.findViewById(2131303302));
    this.ktf = ((ImageView)this.contentView.findViewById(2131303301));
    this.ktg = ((ImageView)this.contentView.findViewById(2131303305));
    this.kth = ((ImageView)this.contentView.findViewById(2131303281));
    this.kti = ((TextView)this.contentView.findViewById(2131303283));
    this.ktj = ((TextView)this.contentView.findViewById(2131303289));
    this.ktg.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(110229);
        if (paramAnonymousMotionEvent.getAction() == 0)
        {
          ad.i("MicroMsg.WebSearch.WebSearchVideoPlayerSeekBar", "ontouch down");
          WebSearchVideoPlayerSeekBar.a(WebSearchVideoPlayerSeekBar.this);
          WebSearchVideoPlayerSeekBar.a(WebSearchVideoPlayerSeekBar.this, paramAnonymousMotionEvent.getX());
          WebSearchVideoPlayerSeekBar.b(WebSearchVideoPlayerSeekBar.this, ((FrameLayout.LayoutParams)WebSearchVideoPlayerSeekBar.b(WebSearchVideoPlayerSeekBar.this).getLayoutParams()).leftMargin);
          if (WebSearchVideoPlayerSeekBar.c(WebSearchVideoPlayerSeekBar.this) != null) {
            WebSearchVideoPlayerSeekBar.d(WebSearchVideoPlayerSeekBar.this).bcv();
          }
        }
        for (;;)
        {
          AppMethodBeat.o(110229);
          return true;
          int i;
          if (paramAnonymousMotionEvent.getAction() == 2)
          {
            float f1 = paramAnonymousMotionEvent.getX();
            ad.i("MicroMsg.WebSearch.WebSearchVideoPlayerSeekBar", "move dis %f ", new Object[] { Float.valueOf(f1 - WebSearchVideoPlayerSeekBar.e(WebSearchVideoPlayerSeekBar.this)) });
            float f2 = WebSearchVideoPlayerSeekBar.f(WebSearchVideoPlayerSeekBar.this);
            i = (int)(f1 - WebSearchVideoPlayerSeekBar.e(WebSearchVideoPlayerSeekBar.this) + f2);
            WebSearchVideoPlayerSeekBar.this.Sn(i);
            i = WebSearchVideoPlayerSeekBar.g(WebSearchVideoPlayerSeekBar.this);
            WebSearchVideoPlayerSeekBar.h(WebSearchVideoPlayerSeekBar.this).setText(WebSearchVideoPlayerSeekBar.rX(i / 60) + ":" + WebSearchVideoPlayerSeekBar.rX(i % 60));
            WebSearchVideoPlayerSeekBar.i(WebSearchVideoPlayerSeekBar.this);
            WebSearchVideoPlayerSeekBar.eit();
          }
          else
          {
            ad.i("MicroMsg.WebSearch.WebSearchVideoPlayerSeekBar", "ontouch up");
            i = WebSearchVideoPlayerSeekBar.j(WebSearchVideoPlayerSeekBar.this);
            if (WebSearchVideoPlayerSeekBar.k(WebSearchVideoPlayerSeekBar.this)) {
              i = WebSearchVideoPlayerSeekBar.a(WebSearchVideoPlayerSeekBar.this, WebSearchVideoPlayerSeekBar.g(WebSearchVideoPlayerSeekBar.this));
            }
            if (WebSearchVideoPlayerSeekBar.l(WebSearchVideoPlayerSeekBar.this) != null)
            {
              ad.i("MicroMsg.WebSearch.WebSearchVideoPlayerSeekBar", "current time : ".concat(String.valueOf(i)));
              WebSearchVideoPlayerSeekBar.m(WebSearchVideoPlayerSeekBar.this).rZ(i);
            }
            WebSearchVideoPlayerSeekBar.n(WebSearchVideoPlayerSeekBar.this);
          }
        }
      }
    });
    this.ktg.addOnLayoutChangeListener(new View.OnLayoutChangeListener()
    {
      public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
      {
        AppMethodBeat.i(110230);
        if (paramAnonymousInt3 - paramAnonymousInt1 != paramAnonymousInt7 - paramAnonymousInt5) {
          WebSearchVideoPlayerSeekBar.this.bdT();
        }
        AppMethodBeat.o(110230);
      }
    });
    this.ktf.addOnLayoutChangeListener(new View.OnLayoutChangeListener()
    {
      public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
      {
        AppMethodBeat.i(110231);
        if (paramAnonymousInt3 - paramAnonymousInt1 != paramAnonymousInt7 - paramAnonymousInt5) {
          WebSearchVideoPlayerSeekBar.this.bdT();
        }
        AppMethodBeat.o(110231);
      }
    });
    AppMethodBeat.o(110232);
  }
  
  public void sa(int paramInt)
  {
    AppMethodBeat.i(110247);
    seek(paramInt);
    AppMethodBeat.o(110247);
  }
  
  public final void seek(int paramInt)
  {
    AppMethodBeat.i(110240);
    ad.d("MicroMsg.WebSearch.WebSearchVideoPlayerSeekBar", "seek position : ".concat(String.valueOf(paramInt)));
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    paramInt = i;
    if (i >= this.ktk) {
      paramInt = this.ktk;
    }
    if (this.mPosition != paramInt)
    {
      this.mPosition = paramInt;
      bdT();
    }
    AppMethodBeat.o(110240);
  }
  
  public void setIsPlay(boolean paramBoolean)
  {
    AppMethodBeat.i(110246);
    this.dkr = paramBoolean;
    super.setIsPlay(paramBoolean);
    AppMethodBeat.o(110246);
  }
  
  public void setPlayBtnOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(110245);
    if (this.kth != null) {
      this.kth.setOnClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(110245);
  }
  
  public void setVideoTotalTime(int paramInt)
  {
    AppMethodBeat.i(110241);
    this.ktk = paramInt;
    this.mPosition = 0;
    this.ktj.setText(rX(this.ktk / 60) + ":" + rX(this.ktk % 60));
    bdT();
    AppMethodBeat.o(110241);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.ui.WebSearchVideoPlayerSeekBar
 * JD-Core Version:    0.7.0.1
 */