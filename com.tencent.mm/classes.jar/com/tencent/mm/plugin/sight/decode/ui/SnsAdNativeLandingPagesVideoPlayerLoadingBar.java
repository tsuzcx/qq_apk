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
import com.tencent.mm.sdk.platformtools.ac;

public class SnsAdNativeLandingPagesVideoPlayerLoadingBar
  extends RelativeLayout
  implements a
{
  private View contentView;
  private boolean dhM;
  private int kUA;
  private float kUC;
  private int kUD;
  private int kUE;
  private int kUF;
  private int kUG;
  private ImageView kUt;
  private ImageView kUu;
  private ImageView kUv;
  private ImageView kUw;
  private TextView kUx;
  private TextView kUy;
  private int kUz;
  private boolean kwq;
  private int mPosition;
  private b xDE;
  
  public SnsAdNativeLandingPagesVideoPlayerLoadingBar(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(116139);
    this.xDE = null;
    this.contentView = null;
    this.kUu = null;
    this.kUv = null;
    this.kUw = null;
    this.kUz = 0;
    this.mPosition = 0;
    this.kUA = 0;
    this.kwq = false;
    this.kUC = 0.0F;
    this.dhM = false;
    this.kUD = -1;
    this.kUE = -1;
    this.kUF = -1;
    this.kUG = -1;
    init();
    AppMethodBeat.o(116139);
  }
  
  public SnsAdNativeLandingPagesVideoPlayerLoadingBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(116140);
    this.xDE = null;
    this.contentView = null;
    this.kUu = null;
    this.kUv = null;
    this.kUw = null;
    this.kUz = 0;
    this.mPosition = 0;
    this.kUA = 0;
    this.kwq = false;
    this.kUC = 0.0F;
    this.dhM = false;
    this.kUD = -1;
    this.kUE = -1;
    this.kUF = -1;
    this.kUG = -1;
    init();
    AppMethodBeat.o(116140);
  }
  
  public SnsAdNativeLandingPagesVideoPlayerLoadingBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(116141);
    this.xDE = null;
    this.contentView = null;
    this.kUu = null;
    this.kUv = null;
    this.kUw = null;
    this.kUz = 0;
    this.mPosition = 0;
    this.kUA = 0;
    this.kwq = false;
    this.kUC = 0.0F;
    this.dhM = false;
    this.kUD = -1;
    this.kUE = -1;
    this.kUF = -1;
    this.kUG = -1;
    init();
    AppMethodBeat.o(116141);
  }
  
  private void bkN()
  {
    AppMethodBeat.i(116150);
    if (this.kUz == 0)
    {
      AppMethodBeat.o(116150);
      return;
    }
    if (this.kwq)
    {
      AppMethodBeat.o(116150);
      return;
    }
    if (this.kUv == null)
    {
      AppMethodBeat.o(116150);
      return;
    }
    if (getBarLen() == 0)
    {
      AppMethodBeat.o(116150);
      return;
    }
    int i = (this.kUv.getWidth() - this.kUv.getPaddingLeft() - this.kUv.getPaddingRight()) / 2;
    this.kUx.setText(sO(this.mPosition / 60) + ":" + sO(this.mPosition % 60));
    int j = ((FrameLayout.LayoutParams)this.kUu.getLayoutParams()).leftMargin;
    int k = this.kUv.getPaddingLeft();
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.kUv.getLayoutParams();
    localLayoutParams.leftMargin = (j - k + (int)(this.mPosition * 1.0D / this.kUz * getBarLen()) - i);
    this.kUv.setLayoutParams(localLayoutParams);
    localLayoutParams = (FrameLayout.LayoutParams)this.kUt.getLayoutParams();
    localLayoutParams.width = ((int)(this.mPosition * 1.0D / this.kUz * getBarLen()));
    this.kUt.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(116150);
  }
  
  private int getBarLen()
  {
    AppMethodBeat.i(116149);
    this.kUA = this.kUu.getWidth();
    int i = this.kUA;
    AppMethodBeat.o(116149);
    return i;
  }
  
  private int getCurrentTimeByBarPoint()
  {
    AppMethodBeat.i(116146);
    int i = ((FrameLayout.LayoutParams)this.kUu.getLayoutParams()).leftMargin;
    int j = this.kUv.getPaddingLeft();
    j = (int)((((FrameLayout.LayoutParams)this.kUv.getLayoutParams()).leftMargin - (i - j)) * 1.0D / getBarLen() * this.kUz);
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
    this.contentView = View.inflate(getContext(), 2131495517, this);
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
        AppMethodBeat.i(116137);
        if (paramAnonymousMotionEvent.getAction() == 0)
        {
          ac.i("MicroMsg.SnsAdNativeLandingPagesVideoPlayerLoadingBar", "ontouch down");
          SnsAdNativeLandingPagesVideoPlayerLoadingBar.a(SnsAdNativeLandingPagesVideoPlayerLoadingBar.this, false);
          SnsAdNativeLandingPagesVideoPlayerLoadingBar.a(SnsAdNativeLandingPagesVideoPlayerLoadingBar.this, paramAnonymousMotionEvent.getX());
          if (SnsAdNativeLandingPagesVideoPlayerLoadingBar.a(SnsAdNativeLandingPagesVideoPlayerLoadingBar.this) != null) {
            SnsAdNativeLandingPagesVideoPlayerLoadingBar.a(SnsAdNativeLandingPagesVideoPlayerLoadingBar.this).anR();
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
            SnsAdNativeLandingPagesVideoPlayerLoadingBar.h(SnsAdNativeLandingPagesVideoPlayerLoadingBar.this).setText(SnsAdNativeLandingPagesVideoPlayerLoadingBar.sO(i / 60) + ":" + SnsAdNativeLandingPagesVideoPlayerLoadingBar.sO(i % 60));
            SnsAdNativeLandingPagesVideoPlayerLoadingBar.a(SnsAdNativeLandingPagesVideoPlayerLoadingBar.this, true);
          }
          else if (SnsAdNativeLandingPagesVideoPlayerLoadingBar.i(SnsAdNativeLandingPagesVideoPlayerLoadingBar.this))
          {
            i = SnsAdNativeLandingPagesVideoPlayerLoadingBar.d(SnsAdNativeLandingPagesVideoPlayerLoadingBar.this);
            if (SnsAdNativeLandingPagesVideoPlayerLoadingBar.a(SnsAdNativeLandingPagesVideoPlayerLoadingBar.this) != null)
            {
              ac.i("MicroMsg.SnsAdNativeLandingPagesVideoPlayerLoadingBar", "current time : ".concat(String.valueOf(i)));
              SnsAdNativeLandingPagesVideoPlayerLoadingBar.a(SnsAdNativeLandingPagesVideoPlayerLoadingBar.this).nn(i);
            }
            SnsAdNativeLandingPagesVideoPlayerLoadingBar.a(SnsAdNativeLandingPagesVideoPlayerLoadingBar.this, false);
          }
        }
      }
    });
    AppMethodBeat.o(116142);
  }
  
  public static String sO(int paramInt)
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
  
  public final void dEK()
  {
    this.kUA = 0;
  }
  
  public boolean getIsPlay()
  {
    return this.dhM;
  }
  
  public int getVideoTotalTime()
  {
    return this.kUz;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(116143);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramInt1 != this.kUD) || (paramInt2 != this.kUE) || (paramInt3 != this.kUF) || (paramInt4 != this.kUG)) {
      bkN();
    }
    this.kUD = paramInt1;
    this.kUE = paramInt2;
    this.kUF = paramInt3;
    this.kUG = paramInt4;
    AppMethodBeat.o(116143);
  }
  
  public final void seek(int paramInt)
  {
    AppMethodBeat.i(116147);
    this.mPosition = paramInt;
    bkN();
    AppMethodBeat.o(116147);
  }
  
  public void setIplaySeekCallback(b paramb)
  {
    this.xDE = paramb;
  }
  
  public void setIsPlay(boolean paramBoolean)
  {
    AppMethodBeat.i(116145);
    this.dhM = paramBoolean;
    if (paramBoolean)
    {
      this.kUw.setImageResource(2131690795);
      AppMethodBeat.o(116145);
      return;
    }
    this.kUw.setImageResource(2131690796);
    AppMethodBeat.o(116145);
  }
  
  public void setOnPlayButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(116144);
    this.kUw.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(116144);
  }
  
  public void setVideoTotalTime(final int paramInt)
  {
    AppMethodBeat.i(116148);
    if ((this.kUv.isShown()) && (this.kUv.getWidth() == 0))
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
    this.kUz = paramInt;
    this.mPosition = 0;
    this.kUy.setText(sO(this.kUz / 60) + ":" + sO(this.kUz % 60));
    bkN();
    AppMethodBeat.o(116148);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.ui.SnsAdNativeLandingPagesVideoPlayerLoadingBar
 * JD-Core Version:    0.7.0.1
 */