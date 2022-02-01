package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
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
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.Iterator;
import java.util.List;

public class TalkRoomPopupNav
  extends LinearLayout
{
  private View VYF;
  private WeImageView VYG;
  private com.tencent.mm.ui.chatting.e.a VYv;
  private LinearLayout WcC;
  private LinearLayout WcN;
  private LinearLayout WcO;
  private int WcR;
  private a WpG;
  private LinearLayout WpH;
  public LinearLayout WpI;
  private LinearLayout WpJ;
  private View WpK;
  private Button WpL;
  private WeImageView WpM;
  private WeImageView WpN;
  private int WpO;
  private int WpP;
  Animation WpQ;
  private AlphaAnimation WpR;
  private AlphaAnimation WpS;
  private View rcN;
  
  public TalkRoomPopupNav(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(33876);
    this.WpO = 0;
    this.WpP = 0;
    initView();
    AppMethodBeat.o(33876);
  }
  
  @TargetApi(11)
  public TalkRoomPopupNav(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(33875);
    this.WpO = 0;
    this.WpP = 0;
    initView();
    AppMethodBeat.o(33875);
  }
  
  private void initView()
  {
    AppMethodBeat.i(33882);
    inflate(getContext(), R.i.dWg, this);
    this.rcN = findViewById(R.h.bottom_line);
    this.WcC = ((LinearLayout)findViewById(R.h.dNh));
    this.WpH = ((LinearLayout)findViewById(R.h.nav_root));
    this.WpI = ((LinearLayout)findViewById(R.h.dialog_root));
    this.WpJ = ((LinearLayout)findViewById(R.h.dIL));
    this.WcN = ((LinearLayout)findViewById(R.h.dIN));
    this.WcO = ((LinearLayout)findViewById(R.h.dIM));
    this.WpK = findViewById(R.h.btn_cancel);
    this.WpL = ((Button)findViewById(R.h.duH));
    this.VYG = ((WeImageView)findViewById(R.h.arrow));
    this.WpM = ((WeImageView)findViewById(R.h.dWh));
    this.WpN = ((WeImageView)findViewById(R.h.dWi));
    this.WpN.setVisibility(8);
    this.WcC.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(33865);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/base/TalkRoomPopupNav$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (TalkRoomPopupNav.a(TalkRoomPopupNav.this) != null) {
          TalkRoomPopupNav.a(TalkRoomPopupNav.this).hKx();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/base/TalkRoomPopupNav$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(33865);
      }
    });
    if (this.VYF != null) {
      this.VYF.setVisibility(8);
    }
    this.WpO = this.WcC.getLayoutParams().height;
    this.WpP = this.WpI.getLayoutParams().height;
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((WindowManager)MMApplicationContext.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
    this.WcR = ((int)Math.floor((localDisplayMetrics.widthPixels - aw.fromDPToPix(getContext(), 56)) / aw.fromDPToPix(getContext(), 48)));
    AppMethodBeat.o(33882);
  }
  
  public final void FF(boolean paramBoolean)
  {
    AppMethodBeat.i(291861);
    if (this.VYF != null) {
      if (paramBoolean)
      {
        this.VYF.setVisibility(0);
        if (this.rcN != null) {
          this.rcN.setVisibility(8);
        }
        if (this.WcC != null) {
          this.WcC.setBackgroundColor(0);
        }
        if (this.VYG != null) {
          this.VYG.setVisibility(4);
        }
        if (this.VYv != null)
        {
          this.VYv.hideVKB();
          AppMethodBeat.o(291861);
        }
      }
      else
      {
        this.VYF.setVisibility(8);
        if (this.rcN != null) {
          this.rcN.setVisibility(0);
        }
        if (this.WcC != null) {
          this.WcC.setBackgroundResource(R.g.tipsbar_small_white_bg);
        }
        if (this.VYG != null) {
          this.VYG.setVisibility(0);
        }
      }
    }
    AppMethodBeat.o(291861);
  }
  
  public final void M(final String paramString, List<String> paramList)
  {
    AppMethodBeat.i(291862);
    this.WpL.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(33866);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/base/TalkRoomPopupNav$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        TalkRoomPopupNav.b(TalkRoomPopupNav.this);
        if (TalkRoomPopupNav.a(TalkRoomPopupNav.this) != null) {
          TalkRoomPopupNav.a(TalkRoomPopupNav.this).byE(paramString);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/base/TalkRoomPopupNav$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(33866);
      }
    });
    this.WpK.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(33867);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/base/TalkRoomPopupNav$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        TalkRoomPopupNav.b(TalkRoomPopupNav.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/base/TalkRoomPopupNav$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(33867);
      }
    });
    if (this.VYF != null) {
      this.VYF.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(279435);
          b localb = new b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/base/TalkRoomPopupNav$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          TalkRoomPopupNav.b(TalkRoomPopupNav.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/base/TalkRoomPopupNav$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(279435);
        }
      });
    }
    if (this.WpI.getVisibility() != 0)
    {
      this.WpI.setVisibility(0);
      FF(true);
      paramString = AnimationUtils.loadAnimation(getContext(), R.a.push_down_in);
      this.WpI.startAnimation(paramString);
      if (this.VYF != null) {
        this.VYF.startAnimation(AnimationUtils.loadAnimation(getContext(), R.a.fast_faded_in));
      }
    }
    this.WpJ.setVisibility(0);
    this.WpJ.removeAllViews();
    if (paramList != null)
    {
      if (paramList.size() > this.WcR)
      {
        this.WcN.setVisibility(0);
        this.WcN.removeAllViews();
      }
      if (paramList.size() > this.WcR * 2)
      {
        this.WcO.setVisibility(0);
        this.WcO.removeAllViews();
      }
    }
    paramString = paramList.iterator();
    int i = 0;
    if (paramString.hasNext())
    {
      paramList = (String)paramString.next();
      ImageView localImageView = new ImageView(getContext());
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 40), com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 40));
      localLayoutParams.rightMargin = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 8);
      localImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
      localImageView.setLayoutParams(localLayoutParams);
      if (i < this.WcR) {
        this.WpJ.addView(localImageView);
      }
      for (;;)
      {
        a.b.c(localImageView, paramList);
        i += 1;
        break;
        if ((i >= this.WcR) && (i < this.WcR * 2)) {
          this.WcN.addView(localImageView);
        } else if ((i >= this.WcR * 2) && (i < this.WcR * 3)) {
          this.WcO.addView(localImageView);
        }
      }
    }
    AppMethodBeat.o(291862);
  }
  
  public final void hKv()
  {
    AppMethodBeat.i(291858);
    if (this.WpN != null) {
      this.WpN.setVisibility(8);
    }
    AppMethodBeat.o(291858);
  }
  
  public final void hKw()
  {
    AppMethodBeat.i(291859);
    if (this.VYF != null) {
      this.VYF.setVisibility(8);
    }
    AppMethodBeat.o(291859);
  }
  
  public final void jU(List<String> paramList)
  {
    int k = 0;
    AppMethodBeat.i(291863);
    if ((this.WpJ != null) && (this.WpJ.getVisibility() == 0)) {
      this.WpJ.removeAllViews();
    }
    for (int j = 1;; j = 0)
    {
      int i = j;
      if (this.WcN != null)
      {
        i = j;
        if (this.WcN.getVisibility() == 0)
        {
          this.WcN.removeAllViews();
          i = 1;
        }
      }
      j = i;
      if (this.WcO != null)
      {
        j = i;
        if (this.WcO.getVisibility() == 0)
        {
          this.WcO.removeAllViews();
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
          LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 40), com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 40));
          localLayoutParams.rightMargin = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 8);
          localImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
          localImageView.setLayoutParams(localLayoutParams);
          if (i < this.WcR) {
            this.WpJ.addView(localImageView);
          }
          for (;;)
          {
            a.b.c(localImageView, str);
            i += 1;
            break;
            if ((i >= this.WcR) && (i < this.WcR * 2)) {
              this.WcN.addView(localImageView);
            } else if ((i >= this.WcR * 2) && (i < this.WcR * 3)) {
              this.WcO.addView(localImageView);
            }
          }
        }
      }
      AppMethodBeat.o(291863);
      return;
    }
  }
  
  public final void ms(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(291857);
    if (this.WpM != null)
    {
      this.WpM.setImageResource(paramInt1);
      this.WpM.setIconColor(paramInt2);
    }
    AppMethodBeat.o(291857);
  }
  
  public void setBgViewResource(int paramInt)
  {
    AppMethodBeat.i(33879);
    if (this.WcC != null) {
      this.WcC.setBackgroundResource(paramInt);
    }
    AppMethodBeat.o(33879);
  }
  
  public void setChattingContext(com.tencent.mm.ui.chatting.e.a parama)
  {
    this.VYv = parama;
  }
  
  public void setDialogContent(String paramString)
  {
    AppMethodBeat.i(33878);
    ((TextView)findViewById(R.h.dYg)).setText(paramString);
    AppMethodBeat.o(33878);
  }
  
  public void setNavContent(String paramString)
  {
    AppMethodBeat.i(33877);
    ((TextView)findViewById(R.h.dYj)).setText(paramString);
    AppMethodBeat.o(33877);
  }
  
  public void setOnClickListener(a parama)
  {
    this.WpG = parama;
  }
  
  public void setRootTipsBarBackground(View paramView)
  {
    this.VYF = paramView;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(33884);
    if ((this.WpR != null) && (this.WpS != null))
    {
      BackwardSupportUtil.AnimationHelper.cancelAnimation(this.WpN, this.WpR);
      BackwardSupportUtil.AnimationHelper.cancelAnimation(this.WpN, this.WpS);
      this.WpN.clearAnimation();
      this.WpR = null;
      this.WpS = null;
    }
    AppMethodBeat.o(33884);
  }
  
  public final void updateView()
  {
    AppMethodBeat.i(291864);
    if (this.WpI != null)
    {
      if ((this.WpI.getVisibility() == 0) && (this.WpQ == null))
      {
        FF(true);
        AppMethodBeat.o(291864);
        return;
      }
      FF(false);
    }
    AppMethodBeat.o(291864);
  }
  
  public static abstract interface a
  {
    public abstract void byE(String paramString);
    
    public abstract void hKx();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.TalkRoomPopupNav
 * JD-Core Version:    0.7.0.1
 */