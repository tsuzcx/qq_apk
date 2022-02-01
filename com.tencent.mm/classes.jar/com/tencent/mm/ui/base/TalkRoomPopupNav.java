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
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.AnimationHelper;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.Iterator;
import java.util.List;

public class TalkRoomPopupNav
  extends LinearLayout
{
  private View OFk;
  private com.tencent.mm.ui.chatting.e.a OFl;
  private WeImageView OFm;
  private LinearLayout OJh;
  private LinearLayout OJs;
  private LinearLayout OJt;
  private int OJw;
  private WeImageView OWA;
  private WeImageView OWB;
  private int OWC;
  private int OWD;
  Animation OWE;
  private AlphaAnimation OWF;
  private AlphaAnimation OWG;
  private a OWu;
  private LinearLayout OWv;
  public LinearLayout OWw;
  private LinearLayout OWx;
  private View OWy;
  private Button OWz;
  private View obi;
  
  public TalkRoomPopupNav(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(33876);
    this.OWC = 0;
    this.OWD = 0;
    initView();
    AppMethodBeat.o(33876);
  }
  
  @TargetApi(11)
  public TalkRoomPopupNav(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(33875);
    this.OWC = 0;
    this.OWD = 0;
    initView();
    AppMethodBeat.o(33875);
  }
  
  private void initView()
  {
    AppMethodBeat.i(33882);
    inflate(getContext(), 2131496649, this);
    this.obi = findViewById(2131297683);
    this.OJh = ((LinearLayout)findViewById(2131305228));
    this.OWv = ((LinearLayout)findViewById(2131305229));
    this.OWw = ((LinearLayout)findViewById(2131299656));
    this.OWx = ((LinearLayout)findViewById(2131302579));
    this.OJs = ((LinearLayout)findViewById(2131302581));
    this.OJt = ((LinearLayout)findViewById(2131302580));
    this.OWy = findViewById(2131297827);
    this.OWz = ((Button)findViewById(2131297830));
    this.OFm = ((WeImageView)findViewById(2131297043));
    this.OWA = ((WeImageView)findViewById(2131308896));
    this.OWB = ((WeImageView)findViewById(2131308897));
    this.OWB.setVisibility(8);
    this.OJh.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(33865);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/TalkRoomPopupNav$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (TalkRoomPopupNav.a(TalkRoomPopupNav.this) != null) {
          TalkRoomPopupNav.a(TalkRoomPopupNav.this).gLw();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/base/TalkRoomPopupNav$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(33865);
      }
    });
    if (this.OFk != null) {
      this.OFk.setVisibility(8);
    }
    this.OWC = this.OJh.getLayoutParams().height;
    this.OWD = this.OWw.getLayoutParams().height;
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((WindowManager)MMApplicationContext.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
    this.OJw = ((int)Math.floor((localDisplayMetrics.widthPixels - at.fromDPToPix(getContext(), 56)) / at.fromDPToPix(getContext(), 48)));
    AppMethodBeat.o(33882);
  }
  
  public final void Bo(boolean paramBoolean)
  {
    AppMethodBeat.i(232764);
    if (this.OFk != null) {
      if (paramBoolean)
      {
        this.OFk.setVisibility(0);
        if (this.obi != null) {
          this.obi.setVisibility(8);
        }
        if (this.OJh != null) {
          this.OJh.setBackgroundColor(0);
        }
        if (this.OFm != null) {
          this.OFm.setVisibility(4);
        }
        if (this.OFl != null)
        {
          this.OFl.hideVKB();
          AppMethodBeat.o(232764);
        }
      }
      else
      {
        this.OFk.setVisibility(8);
        if (this.obi != null) {
          this.obi.setVisibility(0);
        }
        if (this.OJh != null) {
          this.OJh.setBackgroundResource(2131235312);
        }
        if (this.OFm != null) {
          this.OFm.setVisibility(0);
        }
      }
    }
    AppMethodBeat.o(232764);
  }
  
  public final void N(final String paramString, List<String> paramList)
  {
    AppMethodBeat.i(232765);
    this.OWz.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(33866);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/TalkRoomPopupNav$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        TalkRoomPopupNav.b(TalkRoomPopupNav.this);
        if (TalkRoomPopupNav.a(TalkRoomPopupNav.this) != null) {
          TalkRoomPopupNav.a(TalkRoomPopupNav.this).bme(paramString);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/base/TalkRoomPopupNav$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(33866);
      }
    });
    this.OWy.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(33867);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/TalkRoomPopupNav$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        TalkRoomPopupNav.b(TalkRoomPopupNav.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/base/TalkRoomPopupNav$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(33867);
      }
    });
    if (this.OFk != null) {
      this.OFk.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(232760);
          b localb = new b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/TalkRoomPopupNav$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          TalkRoomPopupNav.b(TalkRoomPopupNav.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/base/TalkRoomPopupNav$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(232760);
        }
      });
    }
    if (this.OWw.getVisibility() != 0)
    {
      this.OWw.setVisibility(0);
      Bo(true);
      paramString = AnimationUtils.loadAnimation(getContext(), 2130772129);
      this.OWw.startAnimation(paramString);
      if (this.OFk != null) {
        this.OFk.startAnimation(AnimationUtils.loadAnimation(getContext(), 2130772059));
      }
    }
    this.OWx.setVisibility(0);
    this.OWx.removeAllViews();
    if (paramList != null)
    {
      if (paramList.size() > this.OJw)
      {
        this.OJs.setVisibility(0);
        this.OJs.removeAllViews();
      }
      if (paramList.size() > this.OJw * 2)
      {
        this.OJt.setVisibility(0);
        this.OJt.removeAllViews();
      }
    }
    paramString = paramList.iterator();
    int i = 0;
    if (paramString.hasNext())
    {
      paramList = (String)paramString.next();
      ImageView localImageView = new ImageView(getContext());
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 40), com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 40));
      localLayoutParams.rightMargin = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 8);
      localImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
      localImageView.setLayoutParams(localLayoutParams);
      if (i < this.OJw) {
        this.OWx.addView(localImageView);
      }
      for (;;)
      {
        a.b.c(localImageView, paramList);
        i += 1;
        break;
        if ((i >= this.OJw) && (i < this.OJw * 2)) {
          this.OJs.addView(localImageView);
        } else if ((i >= this.OJw * 2) && (i < this.OJw * 3)) {
          this.OJt.addView(localImageView);
        }
      }
    }
    AppMethodBeat.o(232765);
  }
  
  public final void gLu()
  {
    AppMethodBeat.i(232762);
    if (this.OWB != null) {
      this.OWB.setVisibility(8);
    }
    AppMethodBeat.o(232762);
  }
  
  public final void gLv()
  {
    AppMethodBeat.i(232763);
    if (this.OFk != null) {
      this.OFk.setVisibility(8);
    }
    AppMethodBeat.o(232763);
  }
  
  public final void jc(List<String> paramList)
  {
    int k = 0;
    AppMethodBeat.i(232766);
    if ((this.OWx != null) && (this.OWx.getVisibility() == 0)) {
      this.OWx.removeAllViews();
    }
    for (int j = 1;; j = 0)
    {
      int i = j;
      if (this.OJs != null)
      {
        i = j;
        if (this.OJs.getVisibility() == 0)
        {
          this.OJs.removeAllViews();
          i = 1;
        }
      }
      j = i;
      if (this.OJt != null)
      {
        j = i;
        if (this.OJt.getVisibility() == 0)
        {
          this.OJt.removeAllViews();
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
          LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 40), com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 40));
          localLayoutParams.rightMargin = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 8);
          localImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
          localImageView.setLayoutParams(localLayoutParams);
          if (i < this.OJw) {
            this.OWx.addView(localImageView);
          }
          for (;;)
          {
            a.b.c(localImageView, str);
            i += 1;
            break;
            if ((i >= this.OJw) && (i < this.OJw * 2)) {
              this.OJs.addView(localImageView);
            } else if ((i >= this.OJw * 2) && (i < this.OJw * 3)) {
              this.OJt.addView(localImageView);
            }
          }
        }
      }
      AppMethodBeat.o(232766);
      return;
    }
  }
  
  public void setBgViewResource(int paramInt)
  {
    AppMethodBeat.i(33879);
    if (this.OJh != null) {
      this.OJh.setBackgroundResource(paramInt);
    }
    AppMethodBeat.o(33879);
  }
  
  public void setChattingContext(com.tencent.mm.ui.chatting.e.a parama)
  {
    this.OFl = parama;
  }
  
  public void setDialogContent(String paramString)
  {
    AppMethodBeat.i(33878);
    ((TextView)findViewById(2131309477)).setText(paramString);
    AppMethodBeat.o(33878);
  }
  
  public final void setIconRes$255f295(int paramInt)
  {
    AppMethodBeat.i(232761);
    if (this.OWA != null)
    {
      this.OWA.setImageResource(2131690589);
      this.OWA.setIconColor(paramInt);
    }
    AppMethodBeat.o(232761);
  }
  
  public void setNavContent(String paramString)
  {
    AppMethodBeat.i(33877);
    ((TextView)findViewById(2131309507)).setText(paramString);
    AppMethodBeat.o(33877);
  }
  
  public void setOnClickListener(a parama)
  {
    this.OWu = parama;
  }
  
  public void setRootTipsBarBackground(View paramView)
  {
    this.OFk = paramView;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(33884);
    if ((this.OWF != null) && (this.OWG != null))
    {
      BackwardSupportUtil.AnimationHelper.cancelAnimation(this.OWB, this.OWF);
      BackwardSupportUtil.AnimationHelper.cancelAnimation(this.OWB, this.OWG);
      this.OWB.clearAnimation();
      this.OWF = null;
      this.OWG = null;
    }
    AppMethodBeat.o(33884);
  }
  
  public final void updateView()
  {
    AppMethodBeat.i(232767);
    if (this.OWw != null)
    {
      if ((this.OWw.getVisibility() == 0) && (this.OWE == null))
      {
        Bo(true);
        AppMethodBeat.o(232767);
        return;
      }
      Bo(false);
    }
    AppMethodBeat.o(232767);
  }
  
  public static abstract interface a
  {
    public abstract void bme(String paramString);
    
    public abstract void gLw();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.base.TalkRoomPopupNav
 * JD-Core Version:    0.7.0.1
 */