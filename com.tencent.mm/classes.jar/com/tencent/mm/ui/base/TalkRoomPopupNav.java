package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.a;

public class TalkRoomPopupNav
  extends LinearLayout
{
  public View mwU;
  public LinearLayout zdB;
  private a zpG;
  public LinearLayout zpH;
  private LinearLayout zpI;
  private ImageView zpJ;
  private ImageView zpK;
  public ScaleAnimation zpL;
  public Animation zpM;
  public int zpN;
  public int zpO;
  private ScaleAnimation zpP;
  private Animation zpQ;
  private AlphaAnimation zpR;
  private AlphaAnimation zpS;
  
  public TalkRoomPopupNav(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(30017);
    this.zpN = 0;
    this.zpO = 0;
    initView();
    AppMethodBeat.o(30017);
  }
  
  @TargetApi(11)
  public TalkRoomPopupNav(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(30016);
    this.zpN = 0;
    this.zpO = 0;
    initView();
    AppMethodBeat.o(30016);
  }
  
  private void initView()
  {
    AppMethodBeat.i(30023);
    inflate(getContext(), 2130970987, this);
    this.zdB = ((LinearLayout)findViewById(2131828480));
    this.zpH = ((LinearLayout)findViewById(2131828484));
    this.zpI = ((LinearLayout)findViewById(2131828486));
    this.mwU = findViewById(2131828479);
    this.zpJ = ((ImageView)findViewById(2131828481));
    this.zpK = ((ImageView)findViewById(2131828482));
    this.zpK.setVisibility(8);
    this.zdB.setOnClickListener(new TalkRoomPopupNav.1(this));
    ((Button)findViewById(2131828487)).setOnClickListener(new TalkRoomPopupNav.2(this));
    ((Button)findViewById(2131828488)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(30008);
        TalkRoomPopupNav.b(TalkRoomPopupNav.this);
        if (TalkRoomPopupNav.a(TalkRoomPopupNav.this) != null) {
          TalkRoomPopupNav.a(TalkRoomPopupNav.this).dEF();
        }
        AppMethodBeat.o(30008);
      }
    });
    this.zpN = this.mwU.getLayoutParams().height;
    this.zpO = this.zpH.getLayoutParams().height;
    AppMethodBeat.o(30023);
  }
  
  public void setBgViewResource(int paramInt)
  {
    AppMethodBeat.i(30020);
    if (this.mwU != null) {
      this.mwU.setBackgroundResource(paramInt);
    }
    AppMethodBeat.o(30020);
  }
  
  public void setDialogContent(String paramString)
  {
    AppMethodBeat.i(30019);
    ((TextView)findViewById(2131828485)).setText(paramString);
    AppMethodBeat.o(30019);
  }
  
  public void setIconAnim(int paramInt)
  {
    AppMethodBeat.i(30022);
    if (paramInt < 0)
    {
      if (this.zpK != null) {
        this.zpK.setVisibility(8);
      }
      AppMethodBeat.o(30022);
      return;
    }
    if (this.zpK != null)
    {
      this.zpK.setImageResource(paramInt);
      this.zpK.setVisibility(0);
    }
    AppMethodBeat.o(30022);
  }
  
  public void setIconRes(int paramInt)
  {
    AppMethodBeat.i(30021);
    if (this.zpJ != null) {
      this.zpJ.setImageResource(paramInt);
    }
    AppMethodBeat.o(30021);
  }
  
  public void setNavContent(String paramString)
  {
    AppMethodBeat.i(30018);
    ((TextView)findViewById(2131828483)).setText(paramString);
    AppMethodBeat.o(30018);
  }
  
  public void setOnClickListener(a parama)
  {
    this.zpG = parama;
  }
  
  public final void start()
  {
    AppMethodBeat.i(30024);
    if ((this.zpR == null) || (this.zpS == null))
    {
      this.zpR = new AlphaAnimation(0.0F, 1.0F);
      this.zpR.setDuration(1000L);
      this.zpR.setStartOffset(0L);
      this.zpS = new AlphaAnimation(1.0F, 0.0F);
      this.zpS.setDuration(1000L);
      this.zpS.setStartOffset(0L);
      this.zpR.setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(30014);
          if (TalkRoomPopupNav.f(TalkRoomPopupNav.this) != null) {
            TalkRoomPopupNav.g(TalkRoomPopupNav.this).startAnimation(TalkRoomPopupNav.f(TalkRoomPopupNav.this));
          }
          AppMethodBeat.o(30014);
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation) {}
      });
      this.zpS.setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(30015);
          if (TalkRoomPopupNav.h(TalkRoomPopupNav.this) != null) {
            TalkRoomPopupNav.g(TalkRoomPopupNav.this).startAnimation(TalkRoomPopupNav.h(TalkRoomPopupNav.this));
          }
          AppMethodBeat.o(30015);
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation) {}
      });
      this.zpK.startAnimation(this.zpR);
    }
    AppMethodBeat.o(30024);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(30025);
    if ((this.zpR != null) && (this.zpS != null))
    {
      BackwardSupportUtil.a.a(this.zpK, this.zpR);
      BackwardSupportUtil.a.a(this.zpK, this.zpS);
      this.zpK.clearAnimation();
      this.zpR = null;
      this.zpS = null;
    }
    AppMethodBeat.o(30025);
  }
  
  public static abstract interface a
  {
    public abstract void dEE();
    
    public abstract void dEF();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.base.TalkRoomPopupNav
 * JD-Core Version:    0.7.0.1
 */