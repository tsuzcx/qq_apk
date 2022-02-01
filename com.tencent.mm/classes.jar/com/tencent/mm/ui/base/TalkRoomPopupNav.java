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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.a;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.aq;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.Iterator;
import java.util.List;

public class TalkRoomPopupNav
  extends LinearLayout
{
  public LinearLayout JLA;
  private LinearLayout JLB;
  private View JLC;
  private Button JLD;
  private WeImageView JLE;
  private WeImageView JLF;
  private int JLG;
  private int JLH;
  Animation JLI;
  private AlphaAnimation JLJ;
  private AlphaAnimation JLK;
  private a JLy;
  private LinearLayout JLz;
  private View JuQ;
  private com.tencent.mm.ui.chatting.e.a JuR;
  private WeImageView JuS;
  private LinearLayout JyL;
  private LinearLayout JyW;
  private LinearLayout JyX;
  private int Jza;
  private View mOh;
  
  public TalkRoomPopupNav(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(33876);
    this.JLG = 0;
    this.JLH = 0;
    initView();
    AppMethodBeat.o(33876);
  }
  
  @TargetApi(11)
  public TalkRoomPopupNav(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(33875);
    this.JLG = 0;
    this.JLH = 0;
    initView();
    AppMethodBeat.o(33875);
  }
  
  private void initView()
  {
    AppMethodBeat.i(33882);
    inflate(getContext(), 2131495743, this);
    this.mOh = findViewById(2131297453);
    this.JyL = ((LinearLayout)findViewById(2131302675));
    this.JLz = ((LinearLayout)findViewById(2131307883));
    this.JLA = ((LinearLayout)findViewById(2131307318));
    this.JLB = ((LinearLayout)findViewById(2131307478));
    this.JyW = ((LinearLayout)findViewById(2131307480));
    this.JyX = ((LinearLayout)findViewById(2131307479));
    this.JLC = findViewById(2131297584);
    this.JLD = ((Button)findViewById(2131297585));
    this.JuS = ((WeImageView)findViewById(2131296937));
    this.JLE = ((WeImageView)findViewById(2131305651));
    this.JLF = ((WeImageView)findViewById(2131305652));
    this.JLF.setVisibility(8);
    this.JyL.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(33865);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/TalkRoomPopupNav$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (TalkRoomPopupNav.a(TalkRoomPopupNav.this) != null) {
          TalkRoomPopupNav.a(TalkRoomPopupNav.this).fDx();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/base/TalkRoomPopupNav$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(33865);
      }
    });
    if (this.JuQ != null) {
      this.JuQ.setVisibility(8);
    }
    this.JLG = this.JyL.getLayoutParams().height;
    this.JLH = this.JLA.getLayoutParams().height;
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((WindowManager)ak.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
    this.Jza = ((int)Math.floor((localDisplayMetrics.widthPixels - aq.fromDPToPix(getContext(), 56)) / aq.fromDPToPix(getContext(), 48)));
    AppMethodBeat.o(33882);
  }
  
  public final void H(final String paramString, List<String> paramList)
  {
    AppMethodBeat.i(187081);
    this.JLD.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(33866);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/TalkRoomPopupNav$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        TalkRoomPopupNav.b(TalkRoomPopupNav.this);
        if (TalkRoomPopupNav.a(TalkRoomPopupNav.this) != null) {
          TalkRoomPopupNav.a(TalkRoomPopupNav.this).aXc(paramString);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/base/TalkRoomPopupNav$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(33866);
      }
    });
    this.JLC.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(33867);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/TalkRoomPopupNav$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        TalkRoomPopupNav.b(TalkRoomPopupNav.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/base/TalkRoomPopupNav$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(33867);
      }
    });
    if (this.JuQ != null) {
      this.JuQ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(187076);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/TalkRoomPopupNav$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          TalkRoomPopupNav.b(TalkRoomPopupNav.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/base/TalkRoomPopupNav$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(187076);
        }
      });
    }
    if (this.JLA.getVisibility() != 0)
    {
      this.JLA.setVisibility(0);
      xz(true);
      paramString = AnimationUtils.loadAnimation(getContext(), 2130772105);
      this.JLA.startAnimation(paramString);
      if (this.JuQ != null) {
        this.JuQ.startAnimation(AnimationUtils.loadAnimation(getContext(), 2130772047));
      }
    }
    this.JLB.setVisibility(0);
    this.JLB.removeAllViews();
    if (paramList != null)
    {
      if (paramList.size() > this.Jza)
      {
        this.JyW.setVisibility(0);
        this.JyW.removeAllViews();
      }
      if (paramList.size() > this.Jza * 2)
      {
        this.JyX.setVisibility(0);
        this.JyX.removeAllViews();
      }
    }
    paramString = paramList.iterator();
    int i = 0;
    if (paramString.hasNext())
    {
      paramList = (String)paramString.next();
      ImageView localImageView = new ImageView(getContext());
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 40), com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 40));
      localLayoutParams.rightMargin = com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 8);
      localImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
      localImageView.setLayoutParams(localLayoutParams);
      if (i < this.Jza) {
        this.JLB.addView(localImageView);
      }
      for (;;)
      {
        a.b.c(localImageView, paramList);
        i += 1;
        break;
        if ((i >= this.Jza) && (i < this.Jza * 2)) {
          this.JyW.addView(localImageView);
        } else if ((i >= this.Jza * 2) && (i < this.Jza * 3)) {
          this.JyX.addView(localImageView);
        }
      }
    }
    AppMethodBeat.o(187081);
  }
  
  public final void fDv()
  {
    AppMethodBeat.i(187078);
    if (this.JLF != null) {
      this.JLF.setVisibility(8);
    }
    AppMethodBeat.o(187078);
  }
  
  public final void fDw()
  {
    AppMethodBeat.i(187079);
    if (this.JuQ != null) {
      this.JuQ.setVisibility(8);
    }
    AppMethodBeat.o(187079);
  }
  
  public final void hY(List<String> paramList)
  {
    int k = 0;
    AppMethodBeat.i(187082);
    if ((this.JLB != null) && (this.JLB.getVisibility() == 0)) {
      this.JLB.removeAllViews();
    }
    for (int j = 1;; j = 0)
    {
      int i = j;
      if (this.JyW != null)
      {
        i = j;
        if (this.JyW.getVisibility() == 0)
        {
          this.JyW.removeAllViews();
          i = 1;
        }
      }
      j = i;
      if (this.JyX != null)
      {
        j = i;
        if (this.JyX.getVisibility() == 0)
        {
          this.JyX.removeAllViews();
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
          LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 40), com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 40));
          localLayoutParams.rightMargin = com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 8);
          localImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
          localImageView.setLayoutParams(localLayoutParams);
          if (i < this.Jza) {
            this.JLB.addView(localImageView);
          }
          for (;;)
          {
            a.b.c(localImageView, str);
            i += 1;
            break;
            if ((i >= this.Jza) && (i < this.Jza * 2)) {
              this.JyW.addView(localImageView);
            } else if ((i >= this.Jza * 2) && (i < this.Jza * 3)) {
              this.JyX.addView(localImageView);
            }
          }
        }
      }
      AppMethodBeat.o(187082);
      return;
    }
  }
  
  public void setBgViewResource(int paramInt)
  {
    AppMethodBeat.i(33879);
    if (this.JyL != null) {
      this.JyL.setBackgroundResource(paramInt);
    }
    AppMethodBeat.o(33879);
  }
  
  public void setChattingContext(com.tencent.mm.ui.chatting.e.a parama)
  {
    this.JuR = parama;
  }
  
  public void setDialogContent(String paramString)
  {
    AppMethodBeat.i(33878);
    ((TextView)findViewById(2131306121)).setText(paramString);
    AppMethodBeat.o(33878);
  }
  
  public final void setIconRes$255f295(int paramInt)
  {
    AppMethodBeat.i(187077);
    if (this.JLE != null)
    {
      this.JLE.setImageResource(2131690422);
      this.JLE.setIconColor(paramInt);
    }
    AppMethodBeat.o(187077);
  }
  
  public void setNavContent(String paramString)
  {
    AppMethodBeat.i(33877);
    ((TextView)findViewById(2131306140)).setText(paramString);
    AppMethodBeat.o(33877);
  }
  
  public void setOnClickListener(a parama)
  {
    this.JLy = parama;
  }
  
  public void setRootTipsBarBackground(View paramView)
  {
    this.JuQ = paramView;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(33884);
    if ((this.JLJ != null) && (this.JLK != null))
    {
      BackwardSupportUtil.a.a(this.JLF, this.JLJ);
      BackwardSupportUtil.a.a(this.JLF, this.JLK);
      this.JLF.clearAnimation();
      this.JLJ = null;
      this.JLK = null;
    }
    AppMethodBeat.o(33884);
  }
  
  public final void updateView()
  {
    AppMethodBeat.i(187083);
    if (this.JLA != null)
    {
      if ((this.JLA.getVisibility() == 0) && (this.JLI == null))
      {
        xz(true);
        AppMethodBeat.o(187083);
        return;
      }
      xz(false);
    }
    AppMethodBeat.o(187083);
  }
  
  public final void xz(boolean paramBoolean)
  {
    AppMethodBeat.i(187080);
    if (this.JuQ != null) {
      if (paramBoolean)
      {
        this.JuQ.setVisibility(0);
        if (this.mOh != null) {
          this.mOh.setVisibility(8);
        }
        if (this.JyL != null) {
          this.JyL.setBackgroundColor(0);
        }
        if (this.JuS != null) {
          this.JuS.setVisibility(4);
        }
        if (this.JuR != null)
        {
          this.JuR.hideVKB();
          AppMethodBeat.o(187080);
        }
      }
      else
      {
        this.JuQ.setVisibility(8);
        if (this.mOh != null) {
          this.mOh.setVisibility(0);
        }
        if (this.JyL != null) {
          this.JyL.setBackgroundResource(2131234968);
        }
        if (this.JuS != null) {
          this.JuS.setVisibility(0);
        }
      }
    }
    AppMethodBeat.o(187080);
  }
  
  public static abstract interface a
  {
    public abstract void aXc(String paramString);
    
    public abstract void fDx();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.TalkRoomPopupNav
 * JD-Core Version:    0.7.0.1
 */