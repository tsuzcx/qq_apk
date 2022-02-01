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
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.Iterator;
import java.util.List;

public class TalkRoomPopupNav
  extends LinearLayout
{
  private a HCU;
  private LinearLayout HCV;
  public LinearLayout HCW;
  private LinearLayout HCX;
  private View HCY;
  private Button HCZ;
  private WeImageView HDa;
  private WeImageView HDb;
  private int HDc;
  private int HDd;
  private AlphaAnimation HDe;
  private AlphaAnimation HDf;
  private View HmC;
  private com.tencent.mm.ui.chatting.d.a HmD;
  private LinearLayout HqF;
  private LinearLayout HqG;
  private int HqJ;
  private LinearLayout Hqu;
  private WeImageView Hqv;
  private View miE;
  
  public TalkRoomPopupNav(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(33876);
    this.HDc = 0;
    this.HDd = 0;
    initView();
    AppMethodBeat.o(33876);
  }
  
  @TargetApi(11)
  public TalkRoomPopupNav(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(33875);
    this.HDc = 0;
    this.HDd = 0;
    initView();
    AppMethodBeat.o(33875);
  }
  
  private void initView()
  {
    AppMethodBeat.i(33882);
    inflate(getContext(), 2131495743, this);
    this.miE = findViewById(2131297453);
    this.Hqu = ((LinearLayout)findViewById(2131302675));
    this.HCV = ((LinearLayout)findViewById(2131307883));
    this.HCW = ((LinearLayout)findViewById(2131307318));
    this.HCX = ((LinearLayout)findViewById(2131307478));
    this.HqF = ((LinearLayout)findViewById(2131307480));
    this.HqG = ((LinearLayout)findViewById(2131307479));
    this.HCY = findViewById(2131297584);
    this.HCZ = ((Button)findViewById(2131297585));
    this.Hqv = ((WeImageView)findViewById(2131296937));
    this.HDa = ((WeImageView)findViewById(2131305651));
    this.HDb = ((WeImageView)findViewById(2131305652));
    this.HDb.setVisibility(8);
    this.Hqu.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(33865);
        if (TalkRoomPopupNav.a(TalkRoomPopupNav.this) != null) {
          TalkRoomPopupNav.a(TalkRoomPopupNav.this).fjg();
        }
        AppMethodBeat.o(33865);
      }
    });
    if (this.HmC != null) {
      this.HmC.setVisibility(8);
    }
    this.HDc = this.Hqu.getLayoutParams().height;
    this.HDd = this.HCW.getLayoutParams().height;
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((WindowManager)ai.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
    this.HqJ = ((int)Math.floor((localDisplayMetrics.widthPixels - ao.fromDPToPix(getContext(), 56)) / ao.fromDPToPix(getContext(), 48)));
    AppMethodBeat.o(33882);
  }
  
  public final void E(final String paramString, List<String> paramList)
  {
    AppMethodBeat.i(196363);
    this.HCZ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(33866);
        TalkRoomPopupNav.b(TalkRoomPopupNav.this);
        if (TalkRoomPopupNav.a(TalkRoomPopupNav.this) != null) {
          TalkRoomPopupNav.a(TalkRoomPopupNav.this).aPL(paramString);
        }
        AppMethodBeat.o(33866);
      }
    });
    this.HCY.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(33867);
        TalkRoomPopupNav.b(TalkRoomPopupNav.this);
        AppMethodBeat.o(33867);
      }
    });
    if (this.HmC != null) {
      this.HmC.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(196358);
          TalkRoomPopupNav.b(TalkRoomPopupNav.this);
          AppMethodBeat.o(196358);
        }
      });
    }
    if (this.HCW.getVisibility() != 0)
    {
      this.HCW.setVisibility(0);
      wF(true);
      paramString = AnimationUtils.loadAnimation(getContext(), 2130772105);
      this.HCW.startAnimation(paramString);
      if (this.HmC != null) {
        this.HmC.startAnimation(AnimationUtils.loadAnimation(getContext(), 2130772047));
      }
    }
    this.HCX.setVisibility(0);
    this.HCX.removeAllViews();
    if (paramList != null)
    {
      if (paramList.size() > this.HqJ)
      {
        this.HqF.setVisibility(0);
        this.HqF.removeAllViews();
      }
      if (paramList.size() > this.HqJ * 2)
      {
        this.HqG.setVisibility(0);
        this.HqG.removeAllViews();
      }
    }
    paramString = paramList.iterator();
    int i = 0;
    if (paramString.hasNext())
    {
      paramList = (String)paramString.next();
      ImageView localImageView = new ImageView(getContext());
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), 40), com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), 40));
      localLayoutParams.rightMargin = com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), 8);
      localImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
      localImageView.setLayoutParams(localLayoutParams);
      if (i < this.HqJ) {
        this.HCX.addView(localImageView);
      }
      for (;;)
      {
        a.b.c(localImageView, paramList);
        i += 1;
        break;
        if ((i >= this.HqJ) && (i < this.HqJ * 2)) {
          this.HqF.addView(localImageView);
        } else if ((i >= this.HqJ * 2) && (i < this.HqJ * 3)) {
          this.HqG.addView(localImageView);
        }
      }
    }
    AppMethodBeat.o(196363);
  }
  
  public final void cL()
  {
    AppMethodBeat.i(196365);
    if (this.HCW != null)
    {
      if (this.HCW.getVisibility() == 0)
      {
        wF(true);
        AppMethodBeat.o(196365);
        return;
      }
      wF(false);
    }
    AppMethodBeat.o(196365);
  }
  
  public final void fje()
  {
    AppMethodBeat.i(196360);
    if (this.HDb != null) {
      this.HDb.setVisibility(8);
    }
    AppMethodBeat.o(196360);
  }
  
  public final void fjf()
  {
    AppMethodBeat.i(196361);
    if (this.HmC != null) {
      this.HmC.setVisibility(8);
    }
    AppMethodBeat.o(196361);
  }
  
  public final void hC(List<String> paramList)
  {
    int k = 0;
    AppMethodBeat.i(196364);
    if ((this.HCX != null) && (this.HCX.getVisibility() == 0)) {
      this.HCX.removeAllViews();
    }
    for (int j = 1;; j = 0)
    {
      int i = j;
      if (this.HqF != null)
      {
        i = j;
        if (this.HqF.getVisibility() == 0)
        {
          this.HqF.removeAllViews();
          i = 1;
        }
      }
      j = i;
      if (this.HqG != null)
      {
        j = i;
        if (this.HqG.getVisibility() == 0)
        {
          this.HqG.removeAllViews();
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
          LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), 40), com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), 40));
          localLayoutParams.rightMargin = com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), 8);
          localImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
          localImageView.setLayoutParams(localLayoutParams);
          if (i < this.HqJ) {
            this.HCX.addView(localImageView);
          }
          for (;;)
          {
            a.b.c(localImageView, str);
            i += 1;
            break;
            if ((i >= this.HqJ) && (i < this.HqJ * 2)) {
              this.HqF.addView(localImageView);
            } else if ((i >= this.HqJ * 2) && (i < this.HqJ * 3)) {
              this.HqG.addView(localImageView);
            }
          }
        }
      }
      AppMethodBeat.o(196364);
      return;
    }
  }
  
  public void setBgViewResource(int paramInt)
  {
    AppMethodBeat.i(33879);
    if (this.Hqu != null) {
      this.Hqu.setBackgroundResource(paramInt);
    }
    AppMethodBeat.o(33879);
  }
  
  public void setChattingContext(com.tencent.mm.ui.chatting.d.a parama)
  {
    this.HmD = parama;
  }
  
  public void setDialogContent(String paramString)
  {
    AppMethodBeat.i(33878);
    ((TextView)findViewById(2131306121)).setText(paramString);
    AppMethodBeat.o(33878);
  }
  
  public final void setIconRes$255f295(int paramInt)
  {
    AppMethodBeat.i(196359);
    if (this.HDa != null)
    {
      this.HDa.setImageResource(2131690422);
      this.HDa.setIconColor(paramInt);
    }
    AppMethodBeat.o(196359);
  }
  
  public void setNavContent(String paramString)
  {
    AppMethodBeat.i(33877);
    ((TextView)findViewById(2131306140)).setText(paramString);
    AppMethodBeat.o(33877);
  }
  
  public void setOnClickListener(a parama)
  {
    this.HCU = parama;
  }
  
  public void setRootTipsBarBackground(View paramView)
  {
    this.HmC = paramView;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(33884);
    if ((this.HDe != null) && (this.HDf != null))
    {
      BackwardSupportUtil.a.a(this.HDb, this.HDe);
      BackwardSupportUtil.a.a(this.HDb, this.HDf);
      this.HDb.clearAnimation();
      this.HDe = null;
      this.HDf = null;
    }
    AppMethodBeat.o(33884);
  }
  
  public final void wF(boolean paramBoolean)
  {
    AppMethodBeat.i(196362);
    if (this.HmC != null) {
      if (paramBoolean)
      {
        this.HmC.setVisibility(0);
        if (this.miE != null) {
          this.miE.setVisibility(8);
        }
        if (this.Hqu != null) {
          this.Hqu.setBackgroundColor(0);
        }
        if (this.Hqv != null) {
          this.Hqv.setVisibility(4);
        }
        if (this.HmD != null)
        {
          this.HmD.hideVKB();
          AppMethodBeat.o(196362);
        }
      }
      else
      {
        this.HmC.setVisibility(8);
        if (this.miE != null) {
          this.miE.setVisibility(0);
        }
        if (this.Hqu != null) {
          this.Hqu.setBackgroundResource(2131234968);
        }
        if (this.Hqv != null) {
          this.Hqv.setVisibility(0);
        }
      }
    }
    AppMethodBeat.o(196362);
  }
  
  public static abstract interface a
  {
    public abstract void aPL(String paramString);
    
    public abstract void fjg();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.TalkRoomPopupNav
 * JD-Core Version:    0.7.0.1
 */