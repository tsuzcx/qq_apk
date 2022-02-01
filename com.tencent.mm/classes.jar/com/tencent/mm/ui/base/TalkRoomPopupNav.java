package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.a;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.AnimationHelper;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.Iterator;
import java.util.List;

public class TalkRoomPopupNav
  extends LinearLayout
{
  private View TwQ;
  private com.tencent.mm.ui.chatting.d.a adCQ;
  private View adDa;
  private WeImageView adDb;
  private LinearLayout adIf;
  private LinearLayout adIq;
  private LinearLayout adIr;
  private int adIu;
  private a adWU;
  private LinearLayout adWV;
  public LinearLayout adWW;
  private LinearLayout adWX;
  private Button adWY;
  private WeImageView adWZ;
  private WeImageView adXa;
  private int adXb;
  private int adXc;
  Animation adXd;
  private AlphaAnimation adXe;
  private AlphaAnimation adXf;
  private View uix;
  
  public TalkRoomPopupNav(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(33876);
    this.adXb = 0;
    this.adXc = 0;
    initView();
    AppMethodBeat.o(33876);
  }
  
  public TalkRoomPopupNav(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(33875);
    this.adXb = 0;
    this.adXc = 0;
    initView();
    AppMethodBeat.o(33875);
  }
  
  private void initView()
  {
    AppMethodBeat.i(33882);
    inflate(getContext(), R.i.fYM, this);
    this.uix = findViewById(R.h.bottom_line);
    this.adIf = ((LinearLayout)findViewById(R.h.fPb));
    this.adWV = ((LinearLayout)findViewById(R.h.nav_root));
    this.adWW = ((LinearLayout)findViewById(R.h.dialog_root));
    this.adWX = ((LinearLayout)findViewById(R.h.fKg));
    this.adIq = ((LinearLayout)findViewById(R.h.fKi));
    this.adIr = ((LinearLayout)findViewById(R.h.fKh));
    this.TwQ = findViewById(R.h.btn_cancel);
    this.adWY = ((Button)findViewById(R.h.fuZ));
    this.adDb = ((WeImageView)findViewById(R.h.arrow));
    this.adWZ = ((WeImageView)findViewById(R.h.fYN));
    this.adXa = ((WeImageView)findViewById(R.h.fYO));
    this.adXa.setVisibility(8);
    this.adIf.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(33865);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/base/TalkRoomPopupNav$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (TalkRoomPopupNav.a(TalkRoomPopupNav.this) != null) {
          TalkRoomPopupNav.a(TalkRoomPopupNav.this).jnc();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/base/TalkRoomPopupNav$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(33865);
      }
    });
    if (this.adDa != null) {
      this.adDa.setVisibility(8);
    }
    this.adXb = this.adIf.getLayoutParams().height;
    this.adXc = this.adWW.getLayoutParams().height;
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((WindowManager)MMApplicationContext.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
    this.adIu = ((int)Math.floor((localDisplayMetrics.widthPixels - bd.fromDPToPix(getContext(), 56)) / bd.fromDPToPix(getContext(), 48)));
    AppMethodBeat.o(33882);
  }
  
  public final void Lo(boolean paramBoolean)
  {
    AppMethodBeat.i(251416);
    if (this.adDa != null) {
      if (paramBoolean)
      {
        this.adDa.setVisibility(0);
        if (this.uix != null) {
          this.uix.setVisibility(8);
        }
        if (this.adIf != null) {
          this.adIf.setBackgroundColor(0);
        }
        if (this.adDb != null) {
          this.adDb.setVisibility(4);
        }
        if (this.adCQ != null)
        {
          this.adCQ.hideVKB();
          AppMethodBeat.o(251416);
        }
      }
      else
      {
        this.adDa.setVisibility(8);
        if (this.uix != null) {
          this.uix.setVisibility(0);
        }
        if (this.adIf != null) {
          this.adIf.setBackgroundResource(R.g.tipsbar_small_white_bg);
        }
        if (this.adDb != null) {
          this.adDb.setVisibility(0);
        }
      }
    }
    AppMethodBeat.o(251416);
  }
  
  public final void U(final String paramString, List<String> paramList)
  {
    AppMethodBeat.i(251422);
    this.adWY.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(33866);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/base/TalkRoomPopupNav$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        TalkRoomPopupNav.b(TalkRoomPopupNav.this);
        if (TalkRoomPopupNav.a(TalkRoomPopupNav.this) != null) {
          TalkRoomPopupNav.a(TalkRoomPopupNav.this).aBb(paramString);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/base/TalkRoomPopupNav$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(33866);
      }
    });
    this.TwQ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(33867);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/base/TalkRoomPopupNav$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        TalkRoomPopupNav.b(TalkRoomPopupNav.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/base/TalkRoomPopupNav$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(33867);
      }
    });
    if (this.adDa != null) {
      this.adDa.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(251426);
          b localb = new b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/base/TalkRoomPopupNav$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          TalkRoomPopupNav.b(TalkRoomPopupNav.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/base/TalkRoomPopupNav$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(251426);
        }
      });
    }
    if (this.adWW.getVisibility() != 0)
    {
      this.adWW.setVisibility(0);
      Lo(true);
      paramString = AnimationUtils.loadAnimation(getContext(), R.a.push_down_in);
      this.adWW.startAnimation(paramString);
      if (this.adDa != null) {
        this.adDa.startAnimation(AnimationUtils.loadAnimation(getContext(), R.a.fast_faded_in));
      }
    }
    this.adWX.setVisibility(0);
    this.adWX.removeAllViews();
    if (paramList != null)
    {
      if (paramList.size() > this.adIu)
      {
        this.adIq.setVisibility(0);
        this.adIq.removeAllViews();
      }
      if (paramList.size() > this.adIu * 2)
      {
        this.adIr.setVisibility(0);
        this.adIr.removeAllViews();
      }
    }
    paramString = paramList.iterator();
    int i = 0;
    if (paramString.hasNext())
    {
      paramList = (String)paramString.next();
      ImageView localImageView = new ImageView(getContext());
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 40), com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 40));
      localLayoutParams.rightMargin = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 8);
      localImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
      localImageView.setLayoutParams(localLayoutParams);
      if (i < this.adIu) {
        this.adWX.addView(localImageView);
      }
      for (;;)
      {
        a.b.g(localImageView, paramList);
        i += 1;
        break;
        if ((i >= this.adIu) && (i < this.adIu * 2)) {
          this.adIq.addView(localImageView);
        } else if ((i >= this.adIu * 2) && (i < this.adIu * 3)) {
          this.adIr.addView(localImageView);
        }
      }
    }
    AppMethodBeat.o(251422);
  }
  
  public final void jna()
  {
    AppMethodBeat.i(251410);
    if (this.adXa != null) {
      this.adXa.setVisibility(8);
    }
    AppMethodBeat.o(251410);
  }
  
  public final void jnb()
  {
    AppMethodBeat.i(251415);
    if (this.adDa != null) {
      this.adDa.setVisibility(8);
    }
    AppMethodBeat.o(251415);
  }
  
  public final void nj(List<String> paramList)
  {
    int k = 0;
    AppMethodBeat.i(251423);
    if ((this.adWX != null) && (this.adWX.getVisibility() == 0)) {
      this.adWX.removeAllViews();
    }
    for (int j = 1;; j = 0)
    {
      int i = j;
      if (this.adIq != null)
      {
        i = j;
        if (this.adIq.getVisibility() == 0)
        {
          this.adIq.removeAllViews();
          i = 1;
        }
      }
      j = i;
      if (this.adIr != null)
      {
        j = i;
        if (this.adIr.getVisibility() == 0)
        {
          this.adIr.removeAllViews();
          j = 1;
        }
      }
      if (j != 0)
      {
        paramList = paramList.iterator();
        i = k;
        if (paramList.hasNext())
        {
          String str = (String)paramList.next();
          ImageView localImageView = new ImageView(getContext());
          LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 40), com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 40));
          localLayoutParams.rightMargin = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 8);
          localImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
          localImageView.setLayoutParams(localLayoutParams);
          if (i < this.adIu) {
            this.adWX.addView(localImageView);
          }
          for (;;)
          {
            a.b.g(localImageView, str);
            i += 1;
            break;
            if ((i >= this.adIu) && (i < this.adIu * 2)) {
              this.adIq.addView(localImageView);
            } else if ((i >= this.adIu * 2) && (i < this.adIu * 3)) {
              this.adIr.addView(localImageView);
            }
          }
        }
      }
      AppMethodBeat.o(251423);
      return;
    }
  }
  
  public final void om(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(251407);
    if (this.adWZ != null)
    {
      this.adWZ.setImageResource(paramInt1);
      this.adWZ.setIconColor(paramInt2);
    }
    AppMethodBeat.o(251407);
  }
  
  public void setBgViewResource(int paramInt)
  {
    AppMethodBeat.i(33879);
    if (this.adIf != null) {
      this.adIf.setBackgroundResource(paramInt);
    }
    AppMethodBeat.o(33879);
  }
  
  public void setChattingContext(com.tencent.mm.ui.chatting.d.a parama)
  {
    this.adCQ = parama;
  }
  
  public void setDialogContent(String paramString)
  {
    AppMethodBeat.i(33878);
    ((TextView)findViewById(R.h.gaO)).setText(paramString);
    AppMethodBeat.o(33878);
  }
  
  public void setNavContent(String paramString)
  {
    AppMethodBeat.i(33877);
    ((TextView)findViewById(R.h.gaU)).setText(paramString);
    AppMethodBeat.o(33877);
  }
  
  public void setOnClickListener(a parama)
  {
    this.adWU = parama;
  }
  
  public void setRootTipsBarBackground(View paramView)
  {
    this.adDa = paramView;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(33884);
    if ((this.adXe != null) && (this.adXf != null))
    {
      BackwardSupportUtil.AnimationHelper.cancelAnimation(this.adXa, this.adXe);
      BackwardSupportUtil.AnimationHelper.cancelAnimation(this.adXa, this.adXf);
      this.adXa.clearAnimation();
      this.adXe = null;
      this.adXf = null;
    }
    AppMethodBeat.o(33884);
  }
  
  public final void updateView()
  {
    AppMethodBeat.i(251424);
    if (this.adWW != null)
    {
      if ((this.adWW.getVisibility() == 0) && (this.adXd == null))
      {
        Lo(true);
        AppMethodBeat.o(251424);
        return;
      }
      Lo(false);
    }
    AppMethodBeat.o(251424);
  }
  
  public static abstract interface a
  {
    public abstract void aBb(String paramString);
    
    public abstract void jnc();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.TalkRoomPopupNav
 * JD-Core Version:    0.7.0.1
 */