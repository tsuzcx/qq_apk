package com.tencent.mm.plugin.sight.decode.ui;

import android.content.Context;
import android.os.Looper;
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
import com.tencent.mm.sdk.platformtools.ad;

public class AdVideoPlayerLoadingBar
  extends RelativeLayout
  implements a
{
  protected View contentView;
  public boolean kSw;
  public float lrA;
  private int lrB;
  private int lrC;
  private int lrD;
  private int lrE;
  public ImageView lrr;
  public ImageView lrs;
  public ImageView lrt;
  protected ImageView lru;
  public TextView lrv;
  protected TextView lrw;
  public int lrx;
  private int lry;
  private int lrz;
  public int mPosition;
  public b ySo;
  
  public AdVideoPlayerLoadingBar(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(133963);
    this.ySo = null;
    this.contentView = null;
    this.lrs = null;
    this.lrt = null;
    this.lru = null;
    this.lrx = 0;
    this.mPosition = 0;
    this.lry = 0;
    this.lrz = 0;
    this.kSw = false;
    this.lrA = 0.0F;
    this.lrB = -1;
    this.lrC = -1;
    this.lrD = -1;
    this.lrE = -1;
    init();
    AppMethodBeat.o(133963);
  }
  
  public AdVideoPlayerLoadingBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(133964);
    this.ySo = null;
    this.contentView = null;
    this.lrs = null;
    this.lrt = null;
    this.lru = null;
    this.lrx = 0;
    this.mPosition = 0;
    this.lry = 0;
    this.lrz = 0;
    this.kSw = false;
    this.lrA = 0.0F;
    this.lrB = -1;
    this.lrC = -1;
    this.lrD = -1;
    this.lrE = -1;
    init();
    AppMethodBeat.o(133964);
  }
  
  public AdVideoPlayerLoadingBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(133965);
    this.ySo = null;
    this.contentView = null;
    this.lrs = null;
    this.lrt = null;
    this.lru = null;
    this.lrx = 0;
    this.mPosition = 0;
    this.lry = 0;
    this.lrz = 0;
    this.kSw = false;
    this.lrA = 0.0F;
    this.lrB = -1;
    this.lrC = -1;
    this.lrD = -1;
    this.lrE = -1;
    init();
    AppMethodBeat.o(133965);
  }
  
  public static String tr(int paramInt)
  {
    AppMethodBeat.i(133977);
    if (paramInt < 10)
    {
      String str = "0".concat(String.valueOf(paramInt));
      AppMethodBeat.o(133977);
      return str;
    }
    AppMethodBeat.o(133977);
    return String.valueOf(paramInt);
  }
  
  public final void box()
  {
    AppMethodBeat.i(133973);
    this.lrw.setText(tr(this.lrx / 60) + ":" + tr(this.lrx % 60));
    boy();
    AppMethodBeat.o(133973);
  }
  
  public void boy()
  {
    AppMethodBeat.i(133976);
    if (this.lrx == 0)
    {
      AppMethodBeat.o(133976);
      return;
    }
    if (this.kSw)
    {
      AppMethodBeat.o(133976);
      return;
    }
    if (this.lrt == null)
    {
      AppMethodBeat.o(133976);
      return;
    }
    if (getBarLen() == 0)
    {
      AppMethodBeat.o(133976);
      return;
    }
    int i = (getBarPointWidth() - this.lrt.getPaddingLeft() - this.lrt.getPaddingRight()) / 2;
    this.lrv.setText(tr(this.mPosition / 60) + ":" + tr(this.mPosition % 60));
    int j = ((FrameLayout.LayoutParams)this.lrs.getLayoutParams()).leftMargin;
    int k = this.lrt.getPaddingLeft();
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.lrt.getLayoutParams();
    localLayoutParams.leftMargin = (j - k + (int)(this.mPosition * 1.0D / this.lrx * getBarLen()) - i);
    this.lrt.setLayoutParams(localLayoutParams);
    localLayoutParams = (FrameLayout.LayoutParams)this.lrr.getLayoutParams();
    localLayoutParams.width = ((int)(this.mPosition * 1.0D / this.lrx * getBarLen()));
    this.lrr.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(133976);
  }
  
  public final void dQn()
  {
    this.lry = 0;
  }
  
  public int getBarLen()
  {
    AppMethodBeat.i(133974);
    if (this.lry <= 0) {
      this.lry = this.lrs.getWidth();
    }
    int i = this.lry;
    AppMethodBeat.o(133974);
    return i;
  }
  
  protected int getBarPointWidth()
  {
    AppMethodBeat.i(133975);
    if (this.lrz <= 0) {
      this.lrz = this.lrt.getWidth();
    }
    int i = this.lrz;
    AppMethodBeat.o(133975);
    return i;
  }
  
  protected int getCurrentTimeByBarPoint()
  {
    AppMethodBeat.i(133970);
    int i = ((FrameLayout.LayoutParams)this.lrs.getLayoutParams()).leftMargin;
    int j = this.lrt.getPaddingLeft();
    i = Math.max(0, (int)((((FrameLayout.LayoutParams)this.lrt.getLayoutParams()).leftMargin - (i - j) + (getBarPointWidth() - this.lrt.getPaddingLeft() - this.lrt.getPaddingRight()) / 2) * 1.0D / getBarLen() * this.lrx));
    AppMethodBeat.o(133970);
    return i;
  }
  
  protected int getLayoutId()
  {
    return 2131495833;
  }
  
  public int getVideoTotalTime()
  {
    return this.lrx;
  }
  
  public int getmPosition()
  {
    return this.mPosition;
  }
  
  protected void init()
  {
    AppMethodBeat.i(133966);
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
        AppMethodBeat.i(133960);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sight/decode/ui/AdVideoPlayerLoadingBar$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
        if (paramAnonymousMotionEvent.getAction() == 0)
        {
          ad.i("MicroMsg.VideoPlayerLoadingBar", "ontouch down");
          AdVideoPlayerLoadingBar.this.kSw = false;
          AdVideoPlayerLoadingBar.this.lrA = paramAnonymousMotionEvent.getX();
          if (AdVideoPlayerLoadingBar.this.ySo != null) {
            AdVideoPlayerLoadingBar.this.ySo.aqD();
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/sight/decode/ui/AdVideoPlayerLoadingBar$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(133960);
          return true;
          int i;
          if (paramAnonymousMotionEvent.getAction() == 2)
          {
            float f = paramAnonymousMotionEvent.getX();
            paramAnonymousView = (FrameLayout.LayoutParams)AdVideoPlayerLoadingBar.this.lrt.getLayoutParams();
            i = paramAnonymousView.leftMargin;
            int j = (int)(f - AdVideoPlayerLoadingBar.this.lrA);
            paramAnonymousView.leftMargin = AdVideoPlayerLoadingBar.a(AdVideoPlayerLoadingBar.this, j + i);
            AdVideoPlayerLoadingBar.this.lrt.setLayoutParams(paramAnonymousView);
            i = AdVideoPlayerLoadingBar.this.getCurrentTimeByBarPoint();
            if (AdVideoPlayerLoadingBar.this.lrx > 0)
            {
              paramAnonymousView = (FrameLayout.LayoutParams)AdVideoPlayerLoadingBar.this.lrr.getLayoutParams();
              paramAnonymousView.width = ((int)(i * 1.0D / AdVideoPlayerLoadingBar.this.lrx * AdVideoPlayerLoadingBar.this.getBarLen()));
              AdVideoPlayerLoadingBar.this.lrr.setLayoutParams(paramAnonymousView);
            }
            AdVideoPlayerLoadingBar.this.lrv.setText(AdVideoPlayerLoadingBar.tr(i / 60) + ":" + AdVideoPlayerLoadingBar.tr(i % 60));
            AdVideoPlayerLoadingBar.this.kSw = true;
          }
          else if (AdVideoPlayerLoadingBar.this.kSw)
          {
            i = AdVideoPlayerLoadingBar.this.getCurrentTimeByBarPoint();
            if (AdVideoPlayerLoadingBar.this.ySo != null)
            {
              ad.i("MicroMsg.VideoPlayerLoadingBar", "current time : ".concat(String.valueOf(i)));
              AdVideoPlayerLoadingBar.this.ySo.nM(i);
            }
            AdVideoPlayerLoadingBar.this.kSw = false;
          }
        }
      }
    });
    this.lrt.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(133961);
        int i = (AdVideoPlayerLoadingBar.this.getBarPointWidth() - AdVideoPlayerLoadingBar.this.lrt.getPaddingLeft() - AdVideoPlayerLoadingBar.this.lrt.getPaddingRight()) / 2;
        int j = ((FrameLayout.LayoutParams)AdVideoPlayerLoadingBar.this.lrs.getLayoutParams()).leftMargin;
        int k = AdVideoPlayerLoadingBar.this.lrt.getPaddingLeft();
        FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)AdVideoPlayerLoadingBar.this.lrt.getLayoutParams();
        localLayoutParams.leftMargin = (j - k - i);
        AdVideoPlayerLoadingBar.this.lrt.setLayoutParams(localLayoutParams);
        AppMethodBeat.o(133961);
      }
    });
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.lrr.getLayoutParams();
    localLayoutParams.width = 0;
    this.lrr.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(133966);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(133967);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.lry = 0;
    if ((paramInt1 != this.lrB) || (paramInt2 != this.lrC) || (paramInt3 != this.lrD) || (paramInt4 != this.lrE)) {
      boy();
    }
    this.lrB = paramInt1;
    this.lrC = paramInt2;
    this.lrD = paramInt3;
    this.lrE = paramInt4;
    AppMethodBeat.o(133967);
  }
  
  public void seek(int paramInt)
  {
    AppMethodBeat.i(133971);
    this.mPosition = paramInt;
    boy();
    AppMethodBeat.o(133971);
  }
  
  public void setIplaySeekCallback(b paramb)
  {
    this.ySo = paramb;
  }
  
  public void setIsPlay(boolean paramBoolean)
  {
    AppMethodBeat.i(133969);
    if (paramBoolean)
    {
      this.lru.setImageResource(2131690795);
      AppMethodBeat.o(133969);
      return;
    }
    this.lru.setImageResource(2131690796);
    AppMethodBeat.o(133969);
  }
  
  public void setOnPlayButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(133968);
    this.lru.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(133968);
  }
  
  public void setVideoTotalTime(int paramInt)
  {
    AppMethodBeat.i(133972);
    this.lrx = paramInt;
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(133962);
          AdVideoPlayerLoadingBar.this.box();
          AppMethodBeat.o(133962);
        }
      });
      AppMethodBeat.o(133972);
      return;
    }
    box();
    AppMethodBeat.o(133972);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.ui.AdVideoPlayerLoadingBar
 * JD-Core Version:    0.7.0.1
 */