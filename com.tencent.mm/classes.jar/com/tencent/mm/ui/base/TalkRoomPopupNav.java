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
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public class TalkRoomPopupNav
  extends LinearLayout
{
  public LinearLayout FQJ;
  private a Gdf;
  public LinearLayout Gdg;
  private LinearLayout Gdh;
  private WeImageView Gdi;
  private WeImageView Gdj;
  public ScaleAnimation Gdk;
  public Animation Gdl;
  public int Gdm;
  public int Gdn;
  private ScaleAnimation Gdo;
  private Animation Gdp;
  private AlphaAnimation Gdq;
  private AlphaAnimation Gdr;
  public View qeH;
  
  public TalkRoomPopupNav(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(33876);
    this.Gdm = 0;
    this.Gdn = 0;
    initView();
    AppMethodBeat.o(33876);
  }
  
  @TargetApi(11)
  public TalkRoomPopupNav(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(33875);
    this.Gdm = 0;
    this.Gdn = 0;
    initView();
    AppMethodBeat.o(33875);
  }
  
  private void initView()
  {
    AppMethodBeat.i(33882);
    inflate(getContext(), 2131495743, this);
    this.FQJ = ((LinearLayout)findViewById(2131302675));
    this.Gdg = ((LinearLayout)findViewById(2131299126));
    this.Gdh = ((LinearLayout)findViewById(2131299117));
    this.qeH = findViewById(2131302670);
    this.Gdi = ((WeImageView)findViewById(2131305651));
    this.Gdj = ((WeImageView)findViewById(2131305652));
    this.Gdj.setVisibility(8);
    this.FQJ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(33865);
        if (TalkRoomPopupNav.a(TalkRoomPopupNav.this) != null) {
          TalkRoomPopupNav.a(TalkRoomPopupNav.this).eTt();
        }
        AppMethodBeat.o(33865);
      }
    });
    ((Button)findViewById(2131297584)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(33866);
        TalkRoomPopupNav.b(TalkRoomPopupNav.this);
        AppMethodBeat.o(33866);
      }
    });
    ((Button)findViewById(2131297585)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(33867);
        TalkRoomPopupNav.b(TalkRoomPopupNav.this);
        if (TalkRoomPopupNav.a(TalkRoomPopupNav.this) != null) {
          TalkRoomPopupNav.a(TalkRoomPopupNav.this).eTu();
        }
        AppMethodBeat.o(33867);
      }
    });
    this.Gdm = this.qeH.getLayoutParams().height;
    this.Gdn = this.Gdg.getLayoutParams().height;
    AppMethodBeat.o(33882);
  }
  
  public final void jo(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(191427);
    if (paramInt1 < 0)
    {
      if (this.Gdj != null) {
        this.Gdj.setVisibility(8);
      }
      AppMethodBeat.o(191427);
      return;
    }
    if (this.Gdj != null)
    {
      this.Gdj.setImageResource(paramInt1);
      this.Gdj.setIconColor(paramInt2);
      this.Gdj.setVisibility(0);
    }
    AppMethodBeat.o(191427);
  }
  
  public void setBgViewResource(int paramInt)
  {
    AppMethodBeat.i(33879);
    if (this.qeH != null) {
      this.qeH.setBackgroundResource(paramInt);
    }
    AppMethodBeat.o(33879);
  }
  
  public void setDialogContent(String paramString)
  {
    AppMethodBeat.i(33878);
    ((TextView)findViewById(2131306121)).setText(paramString);
    AppMethodBeat.o(33878);
  }
  
  public final void setIconRes$255f295(int paramInt)
  {
    AppMethodBeat.i(191426);
    if (this.Gdi != null)
    {
      this.Gdi.setImageResource(2131690422);
      this.Gdi.setIconColor(paramInt);
    }
    AppMethodBeat.o(191426);
  }
  
  public void setNavContent(String paramString)
  {
    AppMethodBeat.i(33877);
    ((TextView)findViewById(2131306140)).setText(paramString);
    AppMethodBeat.o(33877);
  }
  
  public void setOnClickListener(a parama)
  {
    this.Gdf = parama;
  }
  
  public final void start()
  {
    AppMethodBeat.i(33883);
    if ((this.Gdq == null) || (this.Gdr == null))
    {
      this.Gdq = new AlphaAnimation(0.0F, 1.0F);
      this.Gdq.setDuration(1000L);
      this.Gdq.setStartOffset(0L);
      this.Gdr = new AlphaAnimation(1.0F, 0.0F);
      this.Gdr.setDuration(1000L);
      this.Gdr.setStartOffset(0L);
      this.Gdq.setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(33873);
          if (TalkRoomPopupNav.f(TalkRoomPopupNav.this) != null) {
            TalkRoomPopupNav.g(TalkRoomPopupNav.this).startAnimation(TalkRoomPopupNav.f(TalkRoomPopupNav.this));
          }
          AppMethodBeat.o(33873);
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation) {}
      });
      this.Gdr.setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(33874);
          if (TalkRoomPopupNav.h(TalkRoomPopupNav.this) != null) {
            TalkRoomPopupNav.g(TalkRoomPopupNav.this).startAnimation(TalkRoomPopupNav.h(TalkRoomPopupNav.this));
          }
          AppMethodBeat.o(33874);
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation) {}
      });
      this.Gdj.startAnimation(this.Gdq);
    }
    AppMethodBeat.o(33883);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(33884);
    if ((this.Gdq != null) && (this.Gdr != null))
    {
      BackwardSupportUtil.a.a(this.Gdj, this.Gdq);
      BackwardSupportUtil.a.a(this.Gdj, this.Gdr);
      this.Gdj.clearAnimation();
      this.Gdq = null;
      this.Gdr = null;
    }
    AppMethodBeat.o(33884);
  }
  
  public static abstract interface a
  {
    public abstract void eTt();
    
    public abstract void eTu();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.base.TalkRoomPopupNav
 * JD-Core Version:    0.7.0.1
 */