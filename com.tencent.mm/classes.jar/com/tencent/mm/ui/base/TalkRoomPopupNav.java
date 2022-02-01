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
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.ui.aq;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.Iterator;
import java.util.List;

public class TalkRoomPopupNav
  extends LinearLayout
{
  private View Jai;
  private com.tencent.mm.ui.chatting.e.a Jaj;
  private WeImageView Jak;
  private LinearLayout Jea;
  private LinearLayout Jel;
  private LinearLayout Jem;
  private int Jep;
  private a JqJ;
  private LinearLayout JqK;
  public LinearLayout JqL;
  private LinearLayout JqM;
  private View JqN;
  private Button JqO;
  private WeImageView JqP;
  private WeImageView JqQ;
  private int JqR;
  private int JqS;
  Animation JqT;
  private AlphaAnimation JqU;
  private AlphaAnimation JqV;
  private View mJf;
  
  public TalkRoomPopupNav(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(33876);
    this.JqR = 0;
    this.JqS = 0;
    initView();
    AppMethodBeat.o(33876);
  }
  
  @TargetApi(11)
  public TalkRoomPopupNav(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(33875);
    this.JqR = 0;
    this.JqS = 0;
    initView();
    AppMethodBeat.o(33875);
  }
  
  private void initView()
  {
    AppMethodBeat.i(33882);
    inflate(getContext(), 2131495743, this);
    this.mJf = findViewById(2131297453);
    this.Jea = ((LinearLayout)findViewById(2131302675));
    this.JqK = ((LinearLayout)findViewById(2131307883));
    this.JqL = ((LinearLayout)findViewById(2131307318));
    this.JqM = ((LinearLayout)findViewById(2131307478));
    this.Jel = ((LinearLayout)findViewById(2131307480));
    this.Jem = ((LinearLayout)findViewById(2131307479));
    this.JqN = findViewById(2131297584);
    this.JqO = ((Button)findViewById(2131297585));
    this.Jak = ((WeImageView)findViewById(2131296937));
    this.JqP = ((WeImageView)findViewById(2131305651));
    this.JqQ = ((WeImageView)findViewById(2131305652));
    this.JqQ.setVisibility(8);
    this.Jea.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(33865);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/TalkRoomPopupNav$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (TalkRoomPopupNav.a(TalkRoomPopupNav.this) != null) {
          TalkRoomPopupNav.a(TalkRoomPopupNav.this).fzv();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/base/TalkRoomPopupNav$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(33865);
      }
    });
    if (this.Jai != null) {
      this.Jai.setVisibility(8);
    }
    this.JqR = this.Jea.getLayoutParams().height;
    this.JqS = this.JqL.getLayoutParams().height;
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((WindowManager)aj.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
    this.Jep = ((int)Math.floor((localDisplayMetrics.widthPixels - aq.fromDPToPix(getContext(), 56)) / aq.fromDPToPix(getContext(), 48)));
    AppMethodBeat.o(33882);
  }
  
  public final void G(final String paramString, List<String> paramList)
  {
    AppMethodBeat.i(193785);
    this.JqO.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(33866);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/TalkRoomPopupNav$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        TalkRoomPopupNav.b(TalkRoomPopupNav.this);
        if (TalkRoomPopupNav.a(TalkRoomPopupNav.this) != null) {
          TalkRoomPopupNav.a(TalkRoomPopupNav.this).aVB(paramString);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/base/TalkRoomPopupNav$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(33866);
      }
    });
    this.JqN.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(33867);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/TalkRoomPopupNav$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        TalkRoomPopupNav.b(TalkRoomPopupNav.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/base/TalkRoomPopupNav$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(33867);
      }
    });
    if (this.Jai != null) {
      this.Jai.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(193780);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/TalkRoomPopupNav$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          TalkRoomPopupNav.b(TalkRoomPopupNav.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/base/TalkRoomPopupNav$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(193780);
        }
      });
    }
    if (this.JqL.getVisibility() != 0)
    {
      this.JqL.setVisibility(0);
      xr(true);
      paramString = AnimationUtils.loadAnimation(getContext(), 2130772105);
      this.JqL.startAnimation(paramString);
      if (this.Jai != null) {
        this.Jai.startAnimation(AnimationUtils.loadAnimation(getContext(), 2130772047));
      }
    }
    this.JqM.setVisibility(0);
    this.JqM.removeAllViews();
    if (paramList != null)
    {
      if (paramList.size() > this.Jep)
      {
        this.Jel.setVisibility(0);
        this.Jel.removeAllViews();
      }
      if (paramList.size() > this.Jep * 2)
      {
        this.Jem.setVisibility(0);
        this.Jem.removeAllViews();
      }
    }
    paramString = paramList.iterator();
    int i = 0;
    if (paramString.hasNext())
    {
      paramList = (String)paramString.next();
      ImageView localImageView = new ImageView(getContext());
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 40), com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 40));
      localLayoutParams.rightMargin = com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 8);
      localImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
      localImageView.setLayoutParams(localLayoutParams);
      if (i < this.Jep) {
        this.JqM.addView(localImageView);
      }
      for (;;)
      {
        a.b.c(localImageView, paramList);
        i += 1;
        break;
        if ((i >= this.Jep) && (i < this.Jep * 2)) {
          this.Jel.addView(localImageView);
        } else if ((i >= this.Jep * 2) && (i < this.Jep * 3)) {
          this.Jem.addView(localImageView);
        }
      }
    }
    AppMethodBeat.o(193785);
  }
  
  public final void fzt()
  {
    AppMethodBeat.i(193782);
    if (this.JqQ != null) {
      this.JqQ.setVisibility(8);
    }
    AppMethodBeat.o(193782);
  }
  
  public final void fzu()
  {
    AppMethodBeat.i(193783);
    if (this.Jai != null) {
      this.Jai.setVisibility(8);
    }
    AppMethodBeat.o(193783);
  }
  
  public final void hO(List<String> paramList)
  {
    int k = 0;
    AppMethodBeat.i(193786);
    if ((this.JqM != null) && (this.JqM.getVisibility() == 0)) {
      this.JqM.removeAllViews();
    }
    for (int j = 1;; j = 0)
    {
      int i = j;
      if (this.Jel != null)
      {
        i = j;
        if (this.Jel.getVisibility() == 0)
        {
          this.Jel.removeAllViews();
          i = 1;
        }
      }
      j = i;
      if (this.Jem != null)
      {
        j = i;
        if (this.Jem.getVisibility() == 0)
        {
          this.Jem.removeAllViews();
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
          LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 40), com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 40));
          localLayoutParams.rightMargin = com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 8);
          localImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
          localImageView.setLayoutParams(localLayoutParams);
          if (i < this.Jep) {
            this.JqM.addView(localImageView);
          }
          for (;;)
          {
            a.b.c(localImageView, str);
            i += 1;
            break;
            if ((i >= this.Jep) && (i < this.Jep * 2)) {
              this.Jel.addView(localImageView);
            } else if ((i >= this.Jep * 2) && (i < this.Jep * 3)) {
              this.Jem.addView(localImageView);
            }
          }
        }
      }
      AppMethodBeat.o(193786);
      return;
    }
  }
  
  public void setBgViewResource(int paramInt)
  {
    AppMethodBeat.i(33879);
    if (this.Jea != null) {
      this.Jea.setBackgroundResource(paramInt);
    }
    AppMethodBeat.o(33879);
  }
  
  public void setChattingContext(com.tencent.mm.ui.chatting.e.a parama)
  {
    this.Jaj = parama;
  }
  
  public void setDialogContent(String paramString)
  {
    AppMethodBeat.i(33878);
    ((TextView)findViewById(2131306121)).setText(paramString);
    AppMethodBeat.o(33878);
  }
  
  public final void setIconRes$255f295(int paramInt)
  {
    AppMethodBeat.i(193781);
    if (this.JqP != null)
    {
      this.JqP.setImageResource(2131690422);
      this.JqP.setIconColor(paramInt);
    }
    AppMethodBeat.o(193781);
  }
  
  public void setNavContent(String paramString)
  {
    AppMethodBeat.i(33877);
    ((TextView)findViewById(2131306140)).setText(paramString);
    AppMethodBeat.o(33877);
  }
  
  public void setOnClickListener(a parama)
  {
    this.JqJ = parama;
  }
  
  public void setRootTipsBarBackground(View paramView)
  {
    this.Jai = paramView;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(33884);
    if ((this.JqU != null) && (this.JqV != null))
    {
      BackwardSupportUtil.a.a(this.JqQ, this.JqU);
      BackwardSupportUtil.a.a(this.JqQ, this.JqV);
      this.JqQ.clearAnimation();
      this.JqU = null;
      this.JqV = null;
    }
    AppMethodBeat.o(33884);
  }
  
  public final void updateView()
  {
    AppMethodBeat.i(193787);
    if (this.JqL != null)
    {
      if ((this.JqL.getVisibility() == 0) && (this.JqT == null))
      {
        xr(true);
        AppMethodBeat.o(193787);
        return;
      }
      xr(false);
    }
    AppMethodBeat.o(193787);
  }
  
  public final void xr(boolean paramBoolean)
  {
    AppMethodBeat.i(193784);
    if (this.Jai != null) {
      if (paramBoolean)
      {
        this.Jai.setVisibility(0);
        if (this.mJf != null) {
          this.mJf.setVisibility(8);
        }
        if (this.Jea != null) {
          this.Jea.setBackgroundColor(0);
        }
        if (this.Jak != null) {
          this.Jak.setVisibility(4);
        }
        if (this.Jaj != null)
        {
          this.Jaj.hideVKB();
          AppMethodBeat.o(193784);
        }
      }
      else
      {
        this.Jai.setVisibility(8);
        if (this.mJf != null) {
          this.mJf.setVisibility(0);
        }
        if (this.Jea != null) {
          this.Jea.setBackgroundResource(2131234968);
        }
        if (this.Jak != null) {
          this.Jak.setVisibility(0);
        }
      }
    }
    AppMethodBeat.o(193784);
  }
  
  public static abstract interface a
  {
    public abstract void aVB(String paramString);
    
    public abstract void fzv();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.TalkRoomPopupNav
 * JD-Core Version:    0.7.0.1
 */