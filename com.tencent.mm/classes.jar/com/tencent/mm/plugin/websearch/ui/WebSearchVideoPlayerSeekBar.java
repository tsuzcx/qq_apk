package com.tencent.mm.plugin.websearch.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.decode.ui.AdVideoPlayerLoadingBar;
import com.tencent.mm.plugin.sight.decode.ui.b;
import com.tencent.mm.pluginsdk.ui.g;
import com.tencent.mm.sdk.platformtools.ab;

public class WebSearchVideoPlayerSeekBar
  extends AdVideoPlayerLoadingBar
  implements g
{
  private float bTE;
  protected boolean cvm = false;
  private int uLs = -1;
  private int uLt = -1;
  private int uLu = -1;
  
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
  
  private int Jz(int paramInt)
  {
    AppMethodBeat.i(73829);
    int i = paramInt;
    if (paramInt > getBarLen()) {
      i = getBarLen();
    }
    paramInt = ((FrameLayout.LayoutParams)this.qTD.getLayoutParams()).leftMargin;
    int j = getBarPointWidth();
    AppMethodBeat.o(73829);
    return paramInt + i - (j >>> 1);
  }
  
  private int getBarPointPaddingLeft()
  {
    AppMethodBeat.i(73821);
    if (this.uLt == -1) {
      this.uLt = this.qTE.getPaddingLeft();
    }
    int i = this.uLt;
    AppMethodBeat.o(73821);
    return i;
  }
  
  private int getBarPointPaddingRight()
  {
    AppMethodBeat.i(73822);
    if (this.uLu == -1) {
      this.uLu = this.qTE.getPaddingRight();
    }
    int i = this.uLu;
    AppMethodBeat.o(73822);
    return i;
  }
  
  private int getCurProgressBarLen()
  {
    AppMethodBeat.i(73819);
    int i = this.qTC.getWidth();
    AppMethodBeat.o(73819);
    return i;
  }
  
  private int getCurTimeByProgressBar()
  {
    AppMethodBeat.i(73818);
    int i = (int)(getCurProgressBarLen() * 1.0D / getBarLen() * this.qTI);
    AppMethodBeat.o(73818);
    return i;
  }
  
  public void Ef(int paramInt)
  {
    AppMethodBeat.i(73832);
    seek(paramInt);
    AppMethodBeat.o(73832);
  }
  
  protected final int Jx(int paramInt)
  {
    AppMethodBeat.i(73823);
    if (paramInt <= 0)
    {
      AppMethodBeat.o(73823);
      return 0;
    }
    if (paramInt >= this.qTI)
    {
      paramInt = getBarLen();
      AppMethodBeat.o(73823);
      return paramInt;
    }
    paramInt = (int)(paramInt * 1.0D / this.qTI * getBarLen());
    AppMethodBeat.o(73823);
    return paramInt;
  }
  
  protected final void Jy(int paramInt)
  {
    AppMethodBeat.i(73828);
    int i;
    if (paramInt > getBarLen()) {
      i = getBarLen();
    }
    for (;;)
    {
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.qTE.getLayoutParams();
      localLayoutParams.leftMargin = Jz(i);
      this.qTE.setLayoutParams(localLayoutParams);
      localLayoutParams = (FrameLayout.LayoutParams)this.qTC.getLayoutParams();
      localLayoutParams.width = i;
      this.qTC.setLayoutParams(localLayoutParams);
      this.qTE.requestLayout();
      this.qTC.requestLayout();
      AppMethodBeat.o(73828);
      return;
      i = paramInt;
      if (paramInt < 0) {
        i = 0;
      }
    }
  }
  
  public void aFy()
  {
    AppMethodBeat.i(73827);
    if (this.qTI == 0)
    {
      AppMethodBeat.o(73827);
      return;
    }
    if (this.hPP)
    {
      AppMethodBeat.o(73827);
      return;
    }
    if (this.qTE == null)
    {
      AppMethodBeat.o(73827);
      return;
    }
    if (getBarLen() == 0)
    {
      AppMethodBeat.o(73827);
      return;
    }
    if (this.mPosition == this.qTI) {
      ab.i("MicroMsg.WebSearch.WebSearchVideoPlayerSeekBar", "test");
    }
    this.qTG.setText(ol(this.mPosition / 60) + ":" + ol(this.mPosition % 60));
    Jy(Jx(this.mPosition));
    AppMethodBeat.o(73827);
  }
  
  public int getBarLen()
  {
    AppMethodBeat.i(73824);
    int i = this.qTD.getWidth();
    AppMethodBeat.o(73824);
    return i;
  }
  
  public int getBarPointWidth()
  {
    AppMethodBeat.i(73820);
    if (this.uLs == -1) {
      this.uLs = this.qTE.getWidth();
    }
    int i = this.uLs;
    AppMethodBeat.o(73820);
    return i;
  }
  
  public int getLayoutId()
  {
    return 2130971068;
  }
  
  public ImageView getPlayBtn()
  {
    return this.qTF;
  }
  
  public TextView getPlaytimeTv()
  {
    return this.qTG;
  }
  
  public void init()
  {
    AppMethodBeat.i(73817);
    this.contentView = View.inflate(getContext(), getLayoutId(), this);
    this.qTC = ((ImageView)this.contentView.findViewById(2131821463));
    this.qTD = ((ImageView)this.contentView.findViewById(2131821461));
    this.qTE = ((ImageView)this.contentView.findViewById(2131821464));
    this.qTF = ((ImageView)this.contentView.findViewById(2131821295));
    this.qTG = ((TextView)this.contentView.findViewById(2131821459));
    this.qTH = ((TextView)this.contentView.findViewById(2131821465));
    this.qTE.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(73814);
        if (paramAnonymousMotionEvent.getAction() == 0)
        {
          ab.i("MicroMsg.WebSearch.WebSearchVideoPlayerSeekBar", "ontouch down");
          WebSearchVideoPlayerSeekBar.a(WebSearchVideoPlayerSeekBar.this);
          WebSearchVideoPlayerSeekBar.a(WebSearchVideoPlayerSeekBar.this, paramAnonymousMotionEvent.getX());
          WebSearchVideoPlayerSeekBar.b(WebSearchVideoPlayerSeekBar.this, ((FrameLayout.LayoutParams)WebSearchVideoPlayerSeekBar.b(WebSearchVideoPlayerSeekBar.this).getLayoutParams()).leftMargin);
          if (WebSearchVideoPlayerSeekBar.c(WebSearchVideoPlayerSeekBar.this) != null) {
            WebSearchVideoPlayerSeekBar.d(WebSearchVideoPlayerSeekBar.this).aFf();
          }
        }
        for (;;)
        {
          AppMethodBeat.o(73814);
          return true;
          int i;
          if (paramAnonymousMotionEvent.getAction() == 2)
          {
            float f1 = paramAnonymousMotionEvent.getX();
            ab.i("MicroMsg.WebSearch.WebSearchVideoPlayerSeekBar", "move dis %f ", new Object[] { Float.valueOf(f1 - WebSearchVideoPlayerSeekBar.e(WebSearchVideoPlayerSeekBar.this)) });
            float f2 = WebSearchVideoPlayerSeekBar.f(WebSearchVideoPlayerSeekBar.this);
            i = (int)(f1 - WebSearchVideoPlayerSeekBar.e(WebSearchVideoPlayerSeekBar.this) + f2);
            WebSearchVideoPlayerSeekBar.this.Jy(i);
            i = WebSearchVideoPlayerSeekBar.g(WebSearchVideoPlayerSeekBar.this);
            WebSearchVideoPlayerSeekBar.h(WebSearchVideoPlayerSeekBar.this).setText(WebSearchVideoPlayerSeekBar.ol(i / 60) + ":" + WebSearchVideoPlayerSeekBar.ol(i % 60));
            WebSearchVideoPlayerSeekBar.i(WebSearchVideoPlayerSeekBar.this);
            WebSearchVideoPlayerSeekBar.cZW();
          }
          else
          {
            ab.i("MicroMsg.WebSearch.WebSearchVideoPlayerSeekBar", "ontouch up");
            i = WebSearchVideoPlayerSeekBar.j(WebSearchVideoPlayerSeekBar.this);
            if (WebSearchVideoPlayerSeekBar.k(WebSearchVideoPlayerSeekBar.this)) {
              i = WebSearchVideoPlayerSeekBar.a(WebSearchVideoPlayerSeekBar.this, WebSearchVideoPlayerSeekBar.g(WebSearchVideoPlayerSeekBar.this));
            }
            if (WebSearchVideoPlayerSeekBar.l(WebSearchVideoPlayerSeekBar.this) != null)
            {
              ab.i("MicroMsg.WebSearch.WebSearchVideoPlayerSeekBar", "current time : ".concat(String.valueOf(i)));
              WebSearchVideoPlayerSeekBar.m(WebSearchVideoPlayerSeekBar.this).on(i);
            }
            WebSearchVideoPlayerSeekBar.n(WebSearchVideoPlayerSeekBar.this);
          }
        }
      }
    });
    this.qTE.addOnLayoutChangeListener(new WebSearchVideoPlayerSeekBar.2(this));
    this.qTD.addOnLayoutChangeListener(new WebSearchVideoPlayerSeekBar.3(this));
    AppMethodBeat.o(73817);
  }
  
  public final void oi(boolean paramBoolean)
  {
    AppMethodBeat.i(73833);
    setIsPlay(paramBoolean);
    AppMethodBeat.o(73833);
  }
  
  public final void seek(int paramInt)
  {
    AppMethodBeat.i(73825);
    ab.d("MicroMsg.WebSearch.WebSearchVideoPlayerSeekBar", "seek position : ".concat(String.valueOf(paramInt)));
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    paramInt = i;
    if (i >= this.qTI) {
      paramInt = this.qTI;
    }
    if (this.mPosition != paramInt)
    {
      this.mPosition = paramInt;
      aFy();
    }
    AppMethodBeat.o(73825);
  }
  
  public void setIsPlay(boolean paramBoolean)
  {
    AppMethodBeat.i(73831);
    this.cvm = paramBoolean;
    super.setIsPlay(paramBoolean);
    AppMethodBeat.o(73831);
  }
  
  public void setPlayBtnOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(73830);
    if (this.qTF != null) {
      this.qTF.setOnClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(73830);
  }
  
  public void setVideoTotalTime(int paramInt)
  {
    AppMethodBeat.i(73826);
    this.qTI = paramInt;
    this.mPosition = 0;
    this.qTH.setText(ol(this.qTI / 60) + ":" + ol(this.qTI % 60));
    aFy();
    AppMethodBeat.o(73826);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.ui.WebSearchVideoPlayerSeekBar
 * JD-Core Version:    0.7.0.1
 */