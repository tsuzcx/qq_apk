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
import com.tencent.mm.sdk.platformtools.ac;

public class AdVideoPlayerLoadingBar
  extends RelativeLayout
  implements a
{
  protected View contentView;
  private int kUA;
  private int kUB;
  public float kUC;
  private int kUD;
  private int kUE;
  private int kUF;
  private int kUG;
  public ImageView kUt;
  public ImageView kUu;
  public ImageView kUv;
  protected ImageView kUw;
  public TextView kUx;
  protected TextView kUy;
  public int kUz;
  public boolean kwq;
  public int mPosition;
  public b xDE;
  
  public AdVideoPlayerLoadingBar(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(133963);
    this.xDE = null;
    this.contentView = null;
    this.kUu = null;
    this.kUv = null;
    this.kUw = null;
    this.kUz = 0;
    this.mPosition = 0;
    this.kUA = 0;
    this.kUB = 0;
    this.kwq = false;
    this.kUC = 0.0F;
    this.kUD = -1;
    this.kUE = -1;
    this.kUF = -1;
    this.kUG = -1;
    init();
    AppMethodBeat.o(133963);
  }
  
  public AdVideoPlayerLoadingBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(133964);
    this.xDE = null;
    this.contentView = null;
    this.kUu = null;
    this.kUv = null;
    this.kUw = null;
    this.kUz = 0;
    this.mPosition = 0;
    this.kUA = 0;
    this.kUB = 0;
    this.kwq = false;
    this.kUC = 0.0F;
    this.kUD = -1;
    this.kUE = -1;
    this.kUF = -1;
    this.kUG = -1;
    init();
    AppMethodBeat.o(133964);
  }
  
  public AdVideoPlayerLoadingBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(133965);
    this.xDE = null;
    this.contentView = null;
    this.kUu = null;
    this.kUv = null;
    this.kUw = null;
    this.kUz = 0;
    this.mPosition = 0;
    this.kUA = 0;
    this.kUB = 0;
    this.kwq = false;
    this.kUC = 0.0F;
    this.kUD = -1;
    this.kUE = -1;
    this.kUF = -1;
    this.kUG = -1;
    init();
    AppMethodBeat.o(133965);
  }
  
  public static String sO(int paramInt)
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
  
  public final void bkM()
  {
    AppMethodBeat.i(133973);
    this.kUy.setText(sO(this.kUz / 60) + ":" + sO(this.kUz % 60));
    bkN();
    AppMethodBeat.o(133973);
  }
  
  public void bkN()
  {
    AppMethodBeat.i(133976);
    if (this.kUz == 0)
    {
      AppMethodBeat.o(133976);
      return;
    }
    if (this.kwq)
    {
      AppMethodBeat.o(133976);
      return;
    }
    if (this.kUv == null)
    {
      AppMethodBeat.o(133976);
      return;
    }
    if (getBarLen() == 0)
    {
      AppMethodBeat.o(133976);
      return;
    }
    int i = (getBarPointWidth() - this.kUv.getPaddingLeft() - this.kUv.getPaddingRight()) / 2;
    this.kUx.setText(sO(this.mPosition / 60) + ":" + sO(this.mPosition % 60));
    int j = ((FrameLayout.LayoutParams)this.kUu.getLayoutParams()).leftMargin;
    int k = this.kUv.getPaddingLeft();
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.kUv.getLayoutParams();
    localLayoutParams.leftMargin = (j - k + (int)(this.mPosition * 1.0D / this.kUz * getBarLen()) - i);
    this.kUv.setLayoutParams(localLayoutParams);
    localLayoutParams = (FrameLayout.LayoutParams)this.kUt.getLayoutParams();
    localLayoutParams.width = ((int)(this.mPosition * 1.0D / this.kUz * getBarLen()));
    this.kUt.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(133976);
  }
  
  public final void dEK()
  {
    this.kUA = 0;
  }
  
  public int getBarLen()
  {
    AppMethodBeat.i(133974);
    if (this.kUA <= 0) {
      this.kUA = this.kUu.getWidth();
    }
    int i = this.kUA;
    AppMethodBeat.o(133974);
    return i;
  }
  
  protected int getBarPointWidth()
  {
    AppMethodBeat.i(133975);
    if (this.kUB <= 0) {
      this.kUB = this.kUv.getWidth();
    }
    int i = this.kUB;
    AppMethodBeat.o(133975);
    return i;
  }
  
  protected int getCurrentTimeByBarPoint()
  {
    AppMethodBeat.i(133970);
    int i = ((FrameLayout.LayoutParams)this.kUu.getLayoutParams()).leftMargin;
    int j = this.kUv.getPaddingLeft();
    i = Math.max(0, (int)((((FrameLayout.LayoutParams)this.kUv.getLayoutParams()).leftMargin - (i - j) + (getBarPointWidth() - this.kUv.getPaddingLeft() - this.kUv.getPaddingRight()) / 2) * 1.0D / getBarLen() * this.kUz));
    AppMethodBeat.o(133970);
    return i;
  }
  
  protected int getLayoutId()
  {
    return 2131495833;
  }
  
  public int getVideoTotalTime()
  {
    return this.kUz;
  }
  
  public int getmPosition()
  {
    return this.mPosition;
  }
  
  protected void init()
  {
    AppMethodBeat.i(133966);
    this.contentView = View.inflate(getContext(), getLayoutId(), this);
    this.kUt = ((ImageView)this.contentView.findViewById(2131303302));
    this.kUu = ((ImageView)this.contentView.findViewById(2131303301));
    this.kUv = ((ImageView)this.contentView.findViewById(2131303305));
    this.kUw = ((ImageView)this.contentView.findViewById(2131303281));
    this.kUx = ((TextView)this.contentView.findViewById(2131303283));
    this.kUy = ((TextView)this.contentView.findViewById(2131303289));
    this.kUv.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(133960);
        if (paramAnonymousMotionEvent.getAction() == 0)
        {
          ac.i("MicroMsg.VideoPlayerLoadingBar", "ontouch down");
          AdVideoPlayerLoadingBar.this.kwq = false;
          AdVideoPlayerLoadingBar.this.kUC = paramAnonymousMotionEvent.getX();
          if (AdVideoPlayerLoadingBar.this.xDE != null) {
            AdVideoPlayerLoadingBar.this.xDE.anR();
          }
        }
        for (;;)
        {
          AppMethodBeat.o(133960);
          return true;
          int i;
          if (paramAnonymousMotionEvent.getAction() == 2)
          {
            float f = paramAnonymousMotionEvent.getX();
            paramAnonymousView = (FrameLayout.LayoutParams)AdVideoPlayerLoadingBar.this.kUv.getLayoutParams();
            i = paramAnonymousView.leftMargin;
            int j = (int)(f - AdVideoPlayerLoadingBar.this.kUC);
            paramAnonymousView.leftMargin = AdVideoPlayerLoadingBar.a(AdVideoPlayerLoadingBar.this, j + i);
            AdVideoPlayerLoadingBar.this.kUv.setLayoutParams(paramAnonymousView);
            i = AdVideoPlayerLoadingBar.this.getCurrentTimeByBarPoint();
            if (AdVideoPlayerLoadingBar.this.kUz > 0)
            {
              paramAnonymousView = (FrameLayout.LayoutParams)AdVideoPlayerLoadingBar.this.kUt.getLayoutParams();
              paramAnonymousView.width = ((int)(i * 1.0D / AdVideoPlayerLoadingBar.this.kUz * AdVideoPlayerLoadingBar.this.getBarLen()));
              AdVideoPlayerLoadingBar.this.kUt.setLayoutParams(paramAnonymousView);
            }
            AdVideoPlayerLoadingBar.this.kUx.setText(AdVideoPlayerLoadingBar.sO(i / 60) + ":" + AdVideoPlayerLoadingBar.sO(i % 60));
            AdVideoPlayerLoadingBar.this.kwq = true;
          }
          else if (AdVideoPlayerLoadingBar.this.kwq)
          {
            i = AdVideoPlayerLoadingBar.this.getCurrentTimeByBarPoint();
            if (AdVideoPlayerLoadingBar.this.xDE != null)
            {
              ac.i("MicroMsg.VideoPlayerLoadingBar", "current time : ".concat(String.valueOf(i)));
              AdVideoPlayerLoadingBar.this.xDE.nn(i);
            }
            AdVideoPlayerLoadingBar.this.kwq = false;
          }
        }
      }
    });
    this.kUv.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(133961);
        int i = (AdVideoPlayerLoadingBar.this.getBarPointWidth() - AdVideoPlayerLoadingBar.this.kUv.getPaddingLeft() - AdVideoPlayerLoadingBar.this.kUv.getPaddingRight()) / 2;
        int j = ((FrameLayout.LayoutParams)AdVideoPlayerLoadingBar.this.kUu.getLayoutParams()).leftMargin;
        int k = AdVideoPlayerLoadingBar.this.kUv.getPaddingLeft();
        FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)AdVideoPlayerLoadingBar.this.kUv.getLayoutParams();
        localLayoutParams.leftMargin = (j - k - i);
        AdVideoPlayerLoadingBar.this.kUv.setLayoutParams(localLayoutParams);
        AppMethodBeat.o(133961);
      }
    });
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.kUt.getLayoutParams();
    localLayoutParams.width = 0;
    this.kUt.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(133966);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(133967);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.kUA = 0;
    if ((paramInt1 != this.kUD) || (paramInt2 != this.kUE) || (paramInt3 != this.kUF) || (paramInt4 != this.kUG)) {
      bkN();
    }
    this.kUD = paramInt1;
    this.kUE = paramInt2;
    this.kUF = paramInt3;
    this.kUG = paramInt4;
    AppMethodBeat.o(133967);
  }
  
  public void seek(int paramInt)
  {
    AppMethodBeat.i(133971);
    this.mPosition = paramInt;
    bkN();
    AppMethodBeat.o(133971);
  }
  
  public void setIplaySeekCallback(b paramb)
  {
    this.xDE = paramb;
  }
  
  public void setIsPlay(boolean paramBoolean)
  {
    AppMethodBeat.i(133969);
    if (paramBoolean)
    {
      this.kUw.setImageResource(2131690795);
      AppMethodBeat.o(133969);
      return;
    }
    this.kUw.setImageResource(2131690796);
    AppMethodBeat.o(133969);
  }
  
  public void setOnPlayButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(133968);
    this.kUw.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(133968);
  }
  
  public void setVideoTotalTime(int paramInt)
  {
    AppMethodBeat.i(133972);
    this.kUz = paramInt;
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(133962);
          AdVideoPlayerLoadingBar.this.bkM();
          AppMethodBeat.o(133962);
        }
      });
      AppMethodBeat.o(133972);
      return;
    }
    bkM();
    AppMethodBeat.o(133972);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.ui.AdVideoPlayerLoadingBar
 * JD-Core Version:    0.7.0.1
 */