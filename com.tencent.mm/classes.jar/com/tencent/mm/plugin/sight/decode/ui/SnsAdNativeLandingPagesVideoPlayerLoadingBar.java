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
import com.tencent.mm.sdk.platformtools.ae;

public class SnsAdNativeLandingPagesVideoPlayerLoadingBar
  extends RelativeLayout
  implements a
{
  private View contentView;
  private boolean duq;
  private boolean kWf;
  private ImageView lvR;
  private ImageView lvS;
  private ImageView lvT;
  private ImageView lvU;
  private TextView lvV;
  private TextView lvW;
  private int lvX;
  private int lvY;
  private float lwa;
  private int lwb;
  private int lwc;
  private int lwd;
  private int lwe;
  private int mPosition;
  private b ziy;
  
  public SnsAdNativeLandingPagesVideoPlayerLoadingBar(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(116139);
    this.ziy = null;
    this.contentView = null;
    this.lvS = null;
    this.lvT = null;
    this.lvU = null;
    this.lvX = 0;
    this.mPosition = 0;
    this.lvY = 0;
    this.kWf = false;
    this.lwa = 0.0F;
    this.duq = false;
    this.lwb = -1;
    this.lwc = -1;
    this.lwd = -1;
    this.lwe = -1;
    init();
    AppMethodBeat.o(116139);
  }
  
  public SnsAdNativeLandingPagesVideoPlayerLoadingBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(116140);
    this.ziy = null;
    this.contentView = null;
    this.lvS = null;
    this.lvT = null;
    this.lvU = null;
    this.lvX = 0;
    this.mPosition = 0;
    this.lvY = 0;
    this.kWf = false;
    this.lwa = 0.0F;
    this.duq = false;
    this.lwb = -1;
    this.lwc = -1;
    this.lwd = -1;
    this.lwe = -1;
    init();
    AppMethodBeat.o(116140);
  }
  
  public SnsAdNativeLandingPagesVideoPlayerLoadingBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(116141);
    this.ziy = null;
    this.contentView = null;
    this.lvS = null;
    this.lvT = null;
    this.lvU = null;
    this.lvX = 0;
    this.mPosition = 0;
    this.lvY = 0;
    this.kWf = false;
    this.lwa = 0.0F;
    this.duq = false;
    this.lwb = -1;
    this.lwc = -1;
    this.lwd = -1;
    this.lwe = -1;
    init();
    AppMethodBeat.o(116141);
  }
  
  private void bpi()
  {
    AppMethodBeat.i(116150);
    if (this.lvX == 0)
    {
      AppMethodBeat.o(116150);
      return;
    }
    if (this.kWf)
    {
      AppMethodBeat.o(116150);
      return;
    }
    if (this.lvT == null)
    {
      AppMethodBeat.o(116150);
      return;
    }
    if (getBarLen() == 0)
    {
      AppMethodBeat.o(116150);
      return;
    }
    int i = (this.lvT.getWidth() - this.lvT.getPaddingLeft() - this.lvT.getPaddingRight()) / 2;
    this.lvV.setText(tv(this.mPosition / 60) + ":" + tv(this.mPosition % 60));
    int j = ((FrameLayout.LayoutParams)this.lvS.getLayoutParams()).leftMargin;
    int k = this.lvT.getPaddingLeft();
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.lvT.getLayoutParams();
    localLayoutParams.leftMargin = (j - k + (int)(this.mPosition * 1.0D / this.lvX * getBarLen()) - i);
    this.lvT.setLayoutParams(localLayoutParams);
    localLayoutParams = (FrameLayout.LayoutParams)this.lvR.getLayoutParams();
    localLayoutParams.width = ((int)(this.mPosition * 1.0D / this.lvX * getBarLen()));
    this.lvR.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(116150);
  }
  
  private int getBarLen()
  {
    AppMethodBeat.i(116149);
    this.lvY = this.lvS.getWidth();
    int i = this.lvY;
    AppMethodBeat.o(116149);
    return i;
  }
  
  private int getCurrentTimeByBarPoint()
  {
    AppMethodBeat.i(116146);
    int i = ((FrameLayout.LayoutParams)this.lvS.getLayoutParams()).leftMargin;
    int j = this.lvT.getPaddingLeft();
    j = (int)((((FrameLayout.LayoutParams)this.lvT.getLayoutParams()).leftMargin - (i - j)) * 1.0D / getBarLen() * this.lvX);
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
    this.lvR = ((ImageView)this.contentView.findViewById(2131303302));
    this.lvS = ((ImageView)this.contentView.findViewById(2131303301));
    this.lvT = ((ImageView)this.contentView.findViewById(2131303305));
    this.lvU = ((ImageView)this.contentView.findViewById(2131303281));
    this.lvV = ((TextView)this.contentView.findViewById(2131303283));
    this.lvW = ((TextView)this.contentView.findViewById(2131303289));
    this.lvT.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(116137);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sight/decode/ui/SnsAdNativeLandingPagesVideoPlayerLoadingBar$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
        if (paramAnonymousMotionEvent.getAction() == 0)
        {
          ae.i("MicroMsg.SnsAdNativeLandingPagesVideoPlayerLoadingBar", "ontouch down");
          SnsAdNativeLandingPagesVideoPlayerLoadingBar.a(SnsAdNativeLandingPagesVideoPlayerLoadingBar.this, false);
          SnsAdNativeLandingPagesVideoPlayerLoadingBar.a(SnsAdNativeLandingPagesVideoPlayerLoadingBar.this, paramAnonymousMotionEvent.getX());
          if (SnsAdNativeLandingPagesVideoPlayerLoadingBar.a(SnsAdNativeLandingPagesVideoPlayerLoadingBar.this) != null) {
            SnsAdNativeLandingPagesVideoPlayerLoadingBar.a(SnsAdNativeLandingPagesVideoPlayerLoadingBar.this).aqS();
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/sight/decode/ui/SnsAdNativeLandingPagesVideoPlayerLoadingBar$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
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
            SnsAdNativeLandingPagesVideoPlayerLoadingBar.h(SnsAdNativeLandingPagesVideoPlayerLoadingBar.this).setText(SnsAdNativeLandingPagesVideoPlayerLoadingBar.tv(i / 60) + ":" + SnsAdNativeLandingPagesVideoPlayerLoadingBar.tv(i % 60));
            SnsAdNativeLandingPagesVideoPlayerLoadingBar.a(SnsAdNativeLandingPagesVideoPlayerLoadingBar.this, true);
          }
          else if (SnsAdNativeLandingPagesVideoPlayerLoadingBar.i(SnsAdNativeLandingPagesVideoPlayerLoadingBar.this))
          {
            i = SnsAdNativeLandingPagesVideoPlayerLoadingBar.d(SnsAdNativeLandingPagesVideoPlayerLoadingBar.this);
            if (SnsAdNativeLandingPagesVideoPlayerLoadingBar.a(SnsAdNativeLandingPagesVideoPlayerLoadingBar.this) != null)
            {
              ae.i("MicroMsg.SnsAdNativeLandingPagesVideoPlayerLoadingBar", "current time : ".concat(String.valueOf(i)));
              SnsAdNativeLandingPagesVideoPlayerLoadingBar.a(SnsAdNativeLandingPagesVideoPlayerLoadingBar.this).nP(i);
            }
            SnsAdNativeLandingPagesVideoPlayerLoadingBar.a(SnsAdNativeLandingPagesVideoPlayerLoadingBar.this, false);
          }
        }
      }
    });
    AppMethodBeat.o(116142);
  }
  
  public static String tv(int paramInt)
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
  
  public final void dTK()
  {
    this.lvY = 0;
  }
  
  public boolean getIsPlay()
  {
    return this.duq;
  }
  
  public int getVideoTotalTime()
  {
    return this.lvX;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(116143);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramInt1 != this.lwb) || (paramInt2 != this.lwc) || (paramInt3 != this.lwd) || (paramInt4 != this.lwe)) {
      bpi();
    }
    this.lwb = paramInt1;
    this.lwc = paramInt2;
    this.lwd = paramInt3;
    this.lwe = paramInt4;
    AppMethodBeat.o(116143);
  }
  
  public final void seek(int paramInt)
  {
    AppMethodBeat.i(116147);
    this.mPosition = paramInt;
    bpi();
    AppMethodBeat.o(116147);
  }
  
  public void setIplaySeekCallback(b paramb)
  {
    this.ziy = paramb;
  }
  
  public void setIsPlay(boolean paramBoolean)
  {
    AppMethodBeat.i(116145);
    this.duq = paramBoolean;
    if (paramBoolean)
    {
      this.lvU.setImageResource(2131690795);
      AppMethodBeat.o(116145);
      return;
    }
    this.lvU.setImageResource(2131690796);
    AppMethodBeat.o(116145);
  }
  
  public void setOnPlayButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(116144);
    this.lvU.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(116144);
  }
  
  public void setVideoTotalTime(final int paramInt)
  {
    AppMethodBeat.i(116148);
    if ((this.lvT.isShown()) && (this.lvT.getWidth() == 0))
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
    this.lvX = paramInt;
    this.mPosition = 0;
    this.lvW.setText(tv(this.lvX / 60) + ":" + tv(this.lvX % 60));
    bpi();
    AppMethodBeat.o(116148);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.ui.SnsAdNativeLandingPagesVideoPlayerLoadingBar
 * JD-Core Version:    0.7.0.1
 */