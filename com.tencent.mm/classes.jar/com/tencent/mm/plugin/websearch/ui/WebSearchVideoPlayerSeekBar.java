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
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.sight.decode.ui.AdVideoPlayerLoadingBar;
import com.tencent.mm.pluginsdk.ui.h;
import com.tencent.mm.sdk.platformtools.ad;

public class WebSearchVideoPlayerSeekBar
  extends AdVideoPlayerLoadingBar
  implements h
{
  private float cNg;
  protected boolean dtk = false;
  private int lsg = -1;
  private int lsh = -1;
  private int lsi = -1;
  
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
  
  private int Wp(int paramInt)
  {
    AppMethodBeat.i(110244);
    int i = paramInt;
    if (paramInt > getBarLen()) {
      i = getBarLen();
    }
    paramInt = ((FrameLayout.LayoutParams)this.lrs.getLayoutParams()).leftMargin;
    int j = getBarPointWidth();
    AppMethodBeat.o(110244);
    return paramInt + i - (j >>> 1);
  }
  
  private int getBarPointPaddingLeft()
  {
    AppMethodBeat.i(110236);
    if (this.lsh == -1) {
      this.lsh = this.lrt.getPaddingLeft();
    }
    int i = this.lsh;
    AppMethodBeat.o(110236);
    return i;
  }
  
  private int getBarPointPaddingRight()
  {
    AppMethodBeat.i(110237);
    if (this.lsi == -1) {
      this.lsi = this.lrt.getPaddingRight();
    }
    int i = this.lsi;
    AppMethodBeat.o(110237);
    return i;
  }
  
  private int getCurProgressBarLen()
  {
    AppMethodBeat.i(110234);
    int i = this.lrr.getWidth();
    AppMethodBeat.o(110234);
    return i;
  }
  
  private int getCurTimeByProgressBar()
  {
    AppMethodBeat.i(110233);
    int i = (int)(getCurProgressBarLen() * 1.0D / getBarLen() * this.lrx);
    AppMethodBeat.o(110233);
    return i;
  }
  
  protected final int Wn(int paramInt)
  {
    AppMethodBeat.i(110238);
    if (paramInt <= 0)
    {
      AppMethodBeat.o(110238);
      return 0;
    }
    if (paramInt >= this.lrx)
    {
      paramInt = getBarLen();
      AppMethodBeat.o(110238);
      return paramInt;
    }
    paramInt = (int)(paramInt * 1.0D / this.lrx * getBarLen());
    AppMethodBeat.o(110238);
    return paramInt;
  }
  
  protected final void Wo(int paramInt)
  {
    AppMethodBeat.i(110243);
    int i;
    if (paramInt > getBarLen()) {
      i = getBarLen();
    }
    for (;;)
    {
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.lrt.getLayoutParams();
      localLayoutParams.leftMargin = Wp(i);
      this.lrt.setLayoutParams(localLayoutParams);
      localLayoutParams = (FrameLayout.LayoutParams)this.lrr.getLayoutParams();
      localLayoutParams.width = i;
      this.lrr.setLayoutParams(localLayoutParams);
      this.lrt.requestLayout();
      this.lrr.requestLayout();
      AppMethodBeat.o(110243);
      return;
      i = paramInt;
      if (paramInt < 0) {
        i = 0;
      }
    }
  }
  
  public void boy()
  {
    AppMethodBeat.i(110242);
    if (this.lrx == 0)
    {
      AppMethodBeat.o(110242);
      return;
    }
    if (this.kSw)
    {
      AppMethodBeat.o(110242);
      return;
    }
    if (this.lrt == null)
    {
      AppMethodBeat.o(110242);
      return;
    }
    if (getBarLen() == 0)
    {
      AppMethodBeat.o(110242);
      return;
    }
    if (this.mPosition == this.lrx) {
      ad.i("MicroMsg.WebSearch.WebSearchVideoPlayerSeekBar", "test");
    }
    this.lrv.setText(tr(this.mPosition / 60) + ":" + tr(this.mPosition % 60));
    Wo(Wn(this.mPosition));
    AppMethodBeat.o(110242);
  }
  
  public final void gS(boolean paramBoolean)
  {
    AppMethodBeat.i(110248);
    setIsPlay(paramBoolean);
    AppMethodBeat.o(110248);
  }
  
  public int getBarLen()
  {
    AppMethodBeat.i(110239);
    int i = this.lrs.getWidth();
    AppMethodBeat.o(110239);
    return i;
  }
  
  public int getBarPointWidth()
  {
    AppMethodBeat.i(110235);
    if (this.lsg == -1) {
      this.lsg = this.lrt.getWidth();
    }
    int i = this.lsg;
    AppMethodBeat.o(110235);
    return i;
  }
  
  public int getLayoutId()
  {
    return 2131495834;
  }
  
  public ImageView getPlayBtn()
  {
    return this.lru;
  }
  
  public TextView getPlaytimeTv()
  {
    return this.lrv;
  }
  
  public void init()
  {
    AppMethodBeat.i(110232);
    this.contentView = View.inflate(getContext(), getLayoutId(), this);
    this.lrr = ((ImageView)this.contentView.findViewById(2131303302));
    this.lrs = ((ImageView)this.contentView.findViewById(2131303301));
    this.lrt = ((ImageView)this.contentView.findViewById(2131303305));
    this.lru = ((ImageView)this.contentView.findViewById(2131303281));
    this.lrv = ((TextView)this.contentView.findViewById(2131303283));
    this.lrw = ((TextView)this.contentView.findViewById(2131303289));
    this.lrt.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(110229);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        a.b("com/tencent/mm/plugin/websearch/ui/WebSearchVideoPlayerSeekBar$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
        if (paramAnonymousMotionEvent.getAction() == 0)
        {
          ad.i("MicroMsg.WebSearch.WebSearchVideoPlayerSeekBar", "ontouch down");
          WebSearchVideoPlayerSeekBar.a(WebSearchVideoPlayerSeekBar.this);
          WebSearchVideoPlayerSeekBar.a(WebSearchVideoPlayerSeekBar.this, paramAnonymousMotionEvent.getX());
          WebSearchVideoPlayerSeekBar.b(WebSearchVideoPlayerSeekBar.this, ((FrameLayout.LayoutParams)WebSearchVideoPlayerSeekBar.b(WebSearchVideoPlayerSeekBar.this).getLayoutParams()).leftMargin);
          if (WebSearchVideoPlayerSeekBar.c(WebSearchVideoPlayerSeekBar.this) != null) {
            WebSearchVideoPlayerSeekBar.d(WebSearchVideoPlayerSeekBar.this).aqD();
          }
        }
        for (;;)
        {
          a.a(true, this, "com/tencent/mm/plugin/websearch/ui/WebSearchVideoPlayerSeekBar$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(110229);
          return true;
          int i;
          if (paramAnonymousMotionEvent.getAction() == 2)
          {
            float f1 = paramAnonymousMotionEvent.getX();
            ad.i("MicroMsg.WebSearch.WebSearchVideoPlayerSeekBar", "move dis %f ", new Object[] { Float.valueOf(f1 - WebSearchVideoPlayerSeekBar.e(WebSearchVideoPlayerSeekBar.this)) });
            float f2 = WebSearchVideoPlayerSeekBar.f(WebSearchVideoPlayerSeekBar.this);
            i = (int)(f1 - WebSearchVideoPlayerSeekBar.e(WebSearchVideoPlayerSeekBar.this) + f2);
            WebSearchVideoPlayerSeekBar.this.Wo(i);
            i = WebSearchVideoPlayerSeekBar.g(WebSearchVideoPlayerSeekBar.this);
            WebSearchVideoPlayerSeekBar.h(WebSearchVideoPlayerSeekBar.this).setText(WebSearchVideoPlayerSeekBar.tr(i / 60) + ":" + WebSearchVideoPlayerSeekBar.tr(i % 60));
            WebSearchVideoPlayerSeekBar.i(WebSearchVideoPlayerSeekBar.this);
            WebSearchVideoPlayerSeekBar.eME();
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
              WebSearchVideoPlayerSeekBar.m(WebSearchVideoPlayerSeekBar.this).nM(i);
            }
            WebSearchVideoPlayerSeekBar.n(WebSearchVideoPlayerSeekBar.this);
          }
        }
      }
    });
    this.lrt.addOnLayoutChangeListener(new View.OnLayoutChangeListener()
    {
      public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
      {
        AppMethodBeat.i(110230);
        if (paramAnonymousInt3 - paramAnonymousInt1 != paramAnonymousInt7 - paramAnonymousInt5) {
          WebSearchVideoPlayerSeekBar.this.boy();
        }
        AppMethodBeat.o(110230);
      }
    });
    this.lrs.addOnLayoutChangeListener(new View.OnLayoutChangeListener()
    {
      public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
      {
        AppMethodBeat.i(110231);
        if (paramAnonymousInt3 - paramAnonymousInt1 != paramAnonymousInt7 - paramAnonymousInt5) {
          WebSearchVideoPlayerSeekBar.this.boy();
        }
        AppMethodBeat.o(110231);
      }
    });
    AppMethodBeat.o(110232);
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
    if (i >= this.lrx) {
      paramInt = this.lrx;
    }
    if (this.mPosition != paramInt)
    {
      this.mPosition = paramInt;
      boy();
    }
    AppMethodBeat.o(110240);
  }
  
  public void setIsPlay(boolean paramBoolean)
  {
    AppMethodBeat.i(110246);
    this.dtk = paramBoolean;
    super.setIsPlay(paramBoolean);
    AppMethodBeat.o(110246);
  }
  
  public void setPlayBtnOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(110245);
    if (this.lru != null) {
      this.lru.setOnClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(110245);
  }
  
  public void setVideoTotalTime(int paramInt)
  {
    AppMethodBeat.i(110241);
    this.lrx = paramInt;
    this.mPosition = 0;
    this.lrw.setText(tr(this.lrx / 60) + ":" + tr(this.lrx % 60));
    boy();
    AppMethodBeat.o(110241);
  }
  
  public void tt(int paramInt)
  {
    AppMethodBeat.i(110247);
    seek(paramInt);
    AppMethodBeat.o(110247);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.ui.WebSearchVideoPlayerSeekBar
 * JD-Core Version:    0.7.0.1
 */