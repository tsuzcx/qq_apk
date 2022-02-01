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
import com.tencent.mm.pluginsdk.ui.h;
import com.tencent.mm.sdk.platformtools.Log;

public class WebSearchVideoPlayerSeekBar
  extends AdVideoPlayerLoadingBar
  implements h
{
  protected boolean dLB = false;
  private float deo;
  private int mDC = -1;
  private int mDD = -1;
  private int mDE = -1;
  
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
  
  private int afF(int paramInt)
  {
    AppMethodBeat.i(110244);
    int i = paramInt;
    if (paramInt > getBarLen()) {
      i = getBarLen();
    }
    paramInt = ((FrameLayout.LayoutParams)this.mCN.getLayoutParams()).leftMargin;
    int j = getBarPointWidth();
    AppMethodBeat.o(110244);
    return paramInt + i - (j >>> 1);
  }
  
  private int getBarPointPaddingLeft()
  {
    AppMethodBeat.i(110236);
    if (this.mDD == -1) {
      this.mDD = this.mCO.getPaddingLeft();
    }
    int i = this.mDD;
    AppMethodBeat.o(110236);
    return i;
  }
  
  private int getBarPointPaddingRight()
  {
    AppMethodBeat.i(110237);
    if (this.mDE == -1) {
      this.mDE = this.mCO.getPaddingRight();
    }
    int i = this.mDE;
    AppMethodBeat.o(110237);
    return i;
  }
  
  private int getCurProgressBarLen()
  {
    AppMethodBeat.i(110234);
    int i = this.mCM.getWidth();
    AppMethodBeat.o(110234);
    return i;
  }
  
  private int getCurTimeByProgressBar()
  {
    AppMethodBeat.i(110233);
    int i = (int)(getCurProgressBarLen() * 1.0D / getBarLen() * this.mCS);
    AppMethodBeat.o(110233);
    return i;
  }
  
  protected final int afD(int paramInt)
  {
    AppMethodBeat.i(110238);
    if (paramInt <= 0)
    {
      AppMethodBeat.o(110238);
      return 0;
    }
    if (paramInt >= this.mCS)
    {
      paramInt = getBarLen();
      AppMethodBeat.o(110238);
      return paramInt;
    }
    paramInt = (int)(paramInt * 1.0D / this.mCS * getBarLen());
    AppMethodBeat.o(110238);
    return paramInt;
  }
  
  protected final void afE(int paramInt)
  {
    AppMethodBeat.i(110243);
    int i;
    if (paramInt > getBarLen()) {
      i = getBarLen();
    }
    for (;;)
    {
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.mCO.getLayoutParams();
      localLayoutParams.leftMargin = afF(i);
      this.mCO.setLayoutParams(localLayoutParams);
      localLayoutParams = (FrameLayout.LayoutParams)this.mCM.getLayoutParams();
      localLayoutParams.width = i;
      this.mCM.setLayoutParams(localLayoutParams);
      this.mCO.requestLayout();
      this.mCM.requestLayout();
      AppMethodBeat.o(110243);
      return;
      i = paramInt;
      if (paramInt < 0) {
        i = 0;
      }
    }
  }
  
  public void bKO()
  {
    AppMethodBeat.i(110242);
    if (this.mCS == 0)
    {
      AppMethodBeat.o(110242);
      return;
    }
    if (this.mbo)
    {
      AppMethodBeat.o(110242);
      return;
    }
    if (this.mCO == null)
    {
      AppMethodBeat.o(110242);
      return;
    }
    if (getBarLen() == 0)
    {
      AppMethodBeat.o(110242);
      return;
    }
    if (this.mPosition == this.mCS) {
      Log.i("MicroMsg.WebSearch.WebSearchVideoPlayerSeekBar", "test");
    }
    this.mCQ.setText(xt(this.mPosition / 60) + ":" + xt(this.mPosition % 60));
    afE(afD(this.mPosition));
    AppMethodBeat.o(110242);
  }
  
  public int getBarLen()
  {
    AppMethodBeat.i(110239);
    int i = this.mCN.getWidth();
    AppMethodBeat.o(110239);
    return i;
  }
  
  public int getBarPointWidth()
  {
    AppMethodBeat.i(110235);
    if (this.mDC == -1) {
      this.mDC = this.mCO.getWidth();
    }
    int i = this.mDC;
    AppMethodBeat.o(110235);
    return i;
  }
  
  public int getLayoutId()
  {
    return 2131496802;
  }
  
  public ImageView getPlayBtn()
  {
    return this.mCP;
  }
  
  public TextView getPlaytimeTv()
  {
    return this.mCQ;
  }
  
  public final void hP(boolean paramBoolean)
  {
    AppMethodBeat.i(110248);
    setIsPlay(paramBoolean);
    AppMethodBeat.o(110248);
  }
  
  public void init()
  {
    AppMethodBeat.i(110232);
    this.contentView = View.inflate(getContext(), getLayoutId(), this);
    this.mCM = ((ImageView)this.contentView.findViewById(2131305975));
    this.mCN = ((ImageView)this.contentView.findViewById(2131305974));
    this.mCO = ((ImageView)this.contentView.findViewById(2131305978));
    this.mCP = ((ImageView)this.contentView.findViewById(2131305954));
    this.mCQ = ((TextView)this.contentView.findViewById(2131305956));
    this.mCR = ((TextView)this.contentView.findViewById(2131305962));
    this.mCO.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(110229);
        if (paramAnonymousMotionEvent.getAction() == 0)
        {
          Log.i("MicroMsg.WebSearch.WebSearchVideoPlayerSeekBar", "ontouch down");
          WebSearchVideoPlayerSeekBar.a(WebSearchVideoPlayerSeekBar.this);
          WebSearchVideoPlayerSeekBar.a(WebSearchVideoPlayerSeekBar.this, paramAnonymousMotionEvent.getX());
          WebSearchVideoPlayerSeekBar.b(WebSearchVideoPlayerSeekBar.this, ((FrameLayout.LayoutParams)WebSearchVideoPlayerSeekBar.b(WebSearchVideoPlayerSeekBar.this).getLayoutParams()).leftMargin);
          if (WebSearchVideoPlayerSeekBar.c(WebSearchVideoPlayerSeekBar.this) != null) {
            WebSearchVideoPlayerSeekBar.d(WebSearchVideoPlayerSeekBar.this).aJq();
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
            Log.i("MicroMsg.WebSearch.WebSearchVideoPlayerSeekBar", "move dis %f ", new Object[] { Float.valueOf(f1 - WebSearchVideoPlayerSeekBar.e(WebSearchVideoPlayerSeekBar.this)) });
            float f2 = WebSearchVideoPlayerSeekBar.f(WebSearchVideoPlayerSeekBar.this);
            i = (int)(f1 - WebSearchVideoPlayerSeekBar.e(WebSearchVideoPlayerSeekBar.this) + f2);
            WebSearchVideoPlayerSeekBar.this.afE(i);
            i = WebSearchVideoPlayerSeekBar.g(WebSearchVideoPlayerSeekBar.this);
            WebSearchVideoPlayerSeekBar.h(WebSearchVideoPlayerSeekBar.this).setText(WebSearchVideoPlayerSeekBar.xt(i / 60) + ":" + WebSearchVideoPlayerSeekBar.xt(i % 60));
            WebSearchVideoPlayerSeekBar.i(WebSearchVideoPlayerSeekBar.this);
            WebSearchVideoPlayerSeekBar.fYL();
          }
          else
          {
            Log.i("MicroMsg.WebSearch.WebSearchVideoPlayerSeekBar", "ontouch up");
            i = WebSearchVideoPlayerSeekBar.j(WebSearchVideoPlayerSeekBar.this);
            if (WebSearchVideoPlayerSeekBar.k(WebSearchVideoPlayerSeekBar.this)) {
              i = WebSearchVideoPlayerSeekBar.a(WebSearchVideoPlayerSeekBar.this, WebSearchVideoPlayerSeekBar.g(WebSearchVideoPlayerSeekBar.this));
            }
            if (WebSearchVideoPlayerSeekBar.l(WebSearchVideoPlayerSeekBar.this) != null)
            {
              Log.i("MicroMsg.WebSearch.WebSearchVideoPlayerSeekBar", "current time : ".concat(String.valueOf(i)));
              WebSearchVideoPlayerSeekBar.m(WebSearchVideoPlayerSeekBar.this).rk(i);
            }
            WebSearchVideoPlayerSeekBar.n(WebSearchVideoPlayerSeekBar.this);
          }
        }
      }
    });
    this.mCO.addOnLayoutChangeListener(new View.OnLayoutChangeListener()
    {
      public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
      {
        AppMethodBeat.i(110230);
        if (paramAnonymousInt3 - paramAnonymousInt1 != paramAnonymousInt7 - paramAnonymousInt5) {
          WebSearchVideoPlayerSeekBar.this.bKO();
        }
        AppMethodBeat.o(110230);
      }
    });
    this.mCN.addOnLayoutChangeListener(new View.OnLayoutChangeListener()
    {
      public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
      {
        AppMethodBeat.i(110231);
        if (paramAnonymousInt3 - paramAnonymousInt1 != paramAnonymousInt7 - paramAnonymousInt5) {
          WebSearchVideoPlayerSeekBar.this.bKO();
        }
        AppMethodBeat.o(110231);
      }
    });
    AppMethodBeat.o(110232);
  }
  
  public final void seek(int paramInt)
  {
    AppMethodBeat.i(110240);
    Log.d("MicroMsg.WebSearch.WebSearchVideoPlayerSeekBar", "seek position : ".concat(String.valueOf(paramInt)));
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    paramInt = i;
    if (i >= this.mCS) {
      paramInt = this.mCS;
    }
    if (this.mPosition != paramInt)
    {
      this.mPosition = paramInt;
      bKO();
    }
    AppMethodBeat.o(110240);
  }
  
  public void setIsPlay(boolean paramBoolean)
  {
    AppMethodBeat.i(110246);
    this.dLB = paramBoolean;
    super.setIsPlay(paramBoolean);
    AppMethodBeat.o(110246);
  }
  
  public void setPlayBtnOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(110245);
    if (this.mCP != null) {
      this.mCP.setOnClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(110245);
  }
  
  public void setVideoTotalTime(int paramInt)
  {
    AppMethodBeat.i(110241);
    this.mCS = paramInt;
    this.mPosition = 0;
    this.mCR.setText(xt(this.mCS / 60) + ":" + xt(this.mCS % 60));
    bKO();
    AppMethodBeat.o(110241);
  }
  
  public void xv(int paramInt)
  {
    AppMethodBeat.i(110247);
    seek(paramInt);
    AppMethodBeat.o(110247);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.ui.WebSearchVideoPlayerSeekBar
 * JD-Core Version:    0.7.0.1
 */