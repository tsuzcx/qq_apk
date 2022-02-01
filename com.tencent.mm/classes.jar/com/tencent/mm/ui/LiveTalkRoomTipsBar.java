package com.tencent.mm.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.a;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.view.FinderLiveOnliveWidget;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.LinkedList;

public class LiveTalkRoomTipsBar
  extends LinearLayout
{
  private RelativeLayout VYA;
  private FrameLayout VYB;
  private TextView VYC;
  private View VYD;
  public ListView VYE;
  private View VYF;
  private WeImageView VYG;
  private View VYH;
  private boolean VYI;
  private FinderLiveOnliveWidget VYJ;
  private RelativeLayout VYu;
  private com.tencent.mm.ui.chatting.e.a VYv;
  public s VYy;
  public RelativeLayout VYz;
  public Context context;
  private String mye;
  private View rcN;
  private View sBm;
  
  public LiveTalkRoomTipsBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(291740);
    this.context = paramContext;
    initView();
    AppMethodBeat.o(291740);
  }
  
  @TargetApi(11)
  public LiveTalkRoomTipsBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(291738);
    this.context = paramContext;
    initView();
    AppMethodBeat.o(291738);
  }
  
  private void atO(int paramInt)
  {
    AppMethodBeat.i(291746);
    int j = com.tencent.mm.ci.a.aY(this.context, R.f.Edge_A);
    Object localObject = new DisplayMetrics();
    ((Activity)this.context).getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
    int i = (((DisplayMetrics)localObject).heightPixels - j * 21) / 2;
    paramInt = j * ((paramInt + 1) * 8);
    localObject = this.VYE.getLayoutParams();
    if (paramInt > i) {}
    for (((ViewGroup.LayoutParams)localObject).height = i;; ((ViewGroup.LayoutParams)localObject).height = paramInt)
    {
      this.VYE.setLayoutParams((ViewGroup.LayoutParams)localObject);
      ViewGroup.LayoutParams localLayoutParams = this.VYz.getLayoutParams();
      localLayoutParams.height = ((ViewGroup.LayoutParams)localObject).height;
      this.VYz.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(291746);
      return;
    }
  }
  
  private void hHs()
  {
    AppMethodBeat.i(291748);
    this.VYz.setVisibility(8);
    setVisibility(8);
    setRootTipsBarBackground(false);
    hHu();
    AppMethodBeat.o(291748);
  }
  
  private void initView()
  {
    AppMethodBeat.i(291743);
    inflate(getContext(), R.i.live_talkroom_tipsbar, this);
    this.VYu = ((RelativeLayout)findViewById(R.h.live_tipsbar_layout));
    this.VYC = ((TextView)findViewById(R.h.live_tipsbar_title));
    this.VYA = ((RelativeLayout)findViewById(R.h.live_tipsbar_close_btn));
    this.rcN = findViewById(R.h.bottom_line);
    this.VYG = ((WeImageView)findViewById(R.h.arrow));
    this.VYH = findViewById(R.h.live_tipsbar_click_area);
    this.VYz = ((RelativeLayout)findViewById(R.h.live_tipsbar_unfold_background));
    this.VYB = ((FrameLayout)findViewById(R.h.live_tipsbar_unfold_layout));
    this.VYE = ((ListView)findViewById(R.h.live_tipsbar_listview));
    this.sBm = ad.kS(this.context).inflate(R.i.live_talkroom_tipsbar_footer, null);
    this.VYE.addFooterView(this.sBm);
    this.VYD = findViewById(R.h.live_tipsbar_list_unfold_btn);
    this.VYJ = ((FinderLiveOnliveWidget)findViewById(R.h.live_tipsbar_living_icon));
    bm(true, false);
    this.VYu.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(261886);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/LiveTalkRoomTipsBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (LiveTalkRoomTipsBar.a(LiveTalkRoomTipsBar.this).VYN != null)
        {
          int i = LiveTalkRoomTipsBar.a(LiveTalkRoomTipsBar.this).VYN.getCount();
          if (i <= 0)
          {
            Log.e("MicroMsg.LiveTalkRoomTipsBar", "click liveTipsBarLayout error, count:%d", new Object[] { Integer.valueOf(i) });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LiveTalkRoomTipsBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(261886);
            return;
          }
          if (!WeChatBrands.Business.Entries.SessionGroupLive.checkAvailable(paramAnonymousView.getContext()))
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LiveTalkRoomTipsBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(261886);
            return;
          }
          Log.i("MicroMsg.LiveTalkRoomTipsBar", "click liveTipsBarLayout, isAnchorLiving:%b, isVisitorLiving:%b, count:%s", new Object[] { Boolean.valueOf(((com.tencent.mm.live.a)h.ag(com.tencent.mm.live.a.class)).isAnchorLiving()), Boolean.valueOf(((com.tencent.mm.live.a)h.ag(com.tencent.mm.live.a.class)).isVisitorLiving()), Integer.valueOf(i) });
          if (LiveTalkRoomTipsBar.b(LiveTalkRoomTipsBar.this).getVisibility() == 8)
          {
            LiveTalkRoomTipsBar.a(LiveTalkRoomTipsBar.this, false);
            paramAnonymousView = com.tencent.mm.ui.report.b.XLO;
            com.tencent.mm.ui.report.b.a(LiveTalkRoomTipsBar.c(LiveTalkRoomTipsBar.this), LiveTalkRoomTipsBar.a(LiveTalkRoomTipsBar.this).hHx(), "", 1L, System.currentTimeMillis());
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LiveTalkRoomTipsBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(261886);
      }
    });
    this.VYA.setVisibility(8);
    this.VYA.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(275594);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/LiveTalkRoomTipsBar$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (LiveTalkRoomTipsBar.a(LiveTalkRoomTipsBar.this) != null)
        {
          LiveTalkRoomTipsBar.a(LiveTalkRoomTipsBar.this);
          s.byn(LiveTalkRoomTipsBar.d(LiveTalkRoomTipsBar.this).getTalkerUserName());
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LiveTalkRoomTipsBar$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(275594);
      }
    });
    this.VYD.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(288185);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/LiveTalkRoomTipsBar$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        LiveTalkRoomTipsBar.a(LiveTalkRoomTipsBar.this, true);
        paramAnonymousView = com.tencent.mm.ui.report.b.XLO;
        com.tencent.mm.ui.report.b.a(LiveTalkRoomTipsBar.c(LiveTalkRoomTipsBar.this), LiveTalkRoomTipsBar.a(LiveTalkRoomTipsBar.this).hHx(), "", 2L, System.currentTimeMillis());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LiveTalkRoomTipsBar$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(288185);
      }
    });
    AppMethodBeat.o(291743);
  }
  
  public final void bm(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(291744);
    Animation localAnimation;
    if (paramBoolean1)
    {
      if ((this.VYz.getVisibility() == 0) && (paramBoolean2))
      {
        localAnimation = AnimationUtils.loadAnimation(getContext(), R.a.push_up_out);
        localAnimation.setAnimationListener(new Animation.AnimationListener()
        {
          public final void onAnimationEnd(Animation paramAnonymousAnimation)
          {
            AppMethodBeat.i(291207);
            LiveTalkRoomTipsBar.b(LiveTalkRoomTipsBar.this).setVisibility(8);
            LiveTalkRoomTipsBar.this.hHr();
            AppMethodBeat.o(291207);
          }
          
          public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
          
          public final void onAnimationStart(Animation paramAnonymousAnimation) {}
        });
        this.VYz.startAnimation(localAnimation);
      }
      for (;;)
      {
        setRootTipsBarBackground(false);
        AppMethodBeat.o(291744);
        return;
        this.VYz.setVisibility(8);
        hHr();
      }
    }
    if (this.VYz.getVisibility() != 0)
    {
      this.VYz.setVisibility(0);
      setRootTipsBarBackground(true);
      if (paramBoolean2)
      {
        localAnimation = AnimationUtils.loadAnimation(getContext(), R.a.push_down_in);
        this.VYz.startAnimation(localAnimation);
        if (this.VYF != null) {
          this.VYF.startAnimation(AnimationUtils.loadAnimation(getContext(), R.a.fast_faded_in));
        }
      }
    }
    hHr();
    if (this.VYv != null) {
      this.VYv.hideVKB();
    }
    AppMethodBeat.o(291744);
  }
  
  public final void hHq()
  {
    AppMethodBeat.i(291741);
    if (this.VYy != null)
    {
      s locals = this.VYy;
      ((com.tencent.mm.live.a)h.ag(com.tencent.mm.live.a.class)).getLiveTipsBarStorage().kyz = locals.kyz;
    }
    AppMethodBeat.o(291741);
  }
  
  public final void hHr()
  {
    AppMethodBeat.i(291745);
    if (!this.VYI)
    {
      hHs();
      AppMethodBeat.o(291745);
      return;
    }
    LinkedList localLinkedList;
    Object localObject;
    if (this.VYy != null)
    {
      localLinkedList = this.VYy.hHw();
      if ((localLinkedList == null) || (localLinkedList.size() <= 0))
      {
        if (localLinkedList == null) {}
        for (localObject = "null";; localObject = "0")
        {
          Log.e("MicroMsg.LiveTalkRoomTipsBar", "showLiveTipsBar List error:%s", new Object[] { localObject });
          hHs();
          AppMethodBeat.o(291745);
          return;
        }
      }
      boolean bool1 = ((com.tencent.mm.live.a)h.ag(com.tencent.mm.live.a.class)).isAnchorLiving();
      boolean bool2 = ((com.tencent.mm.live.a)h.ag(com.tencent.mm.live.a.class)).isVisitorLiving();
      if (localLinkedList != null) {
        break label286;
      }
      localObject = "null";
      Log.i("MicroMsg.LiveTalkRoomTipsBar", "showLiveTipsBar List size:%s, isAnchorLiving:%b, isVisitorLiving:%b", new Object[] { localObject, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if (((!bool1) && (!bool2)) || (this.VYy == null) || (!this.VYy.bym(((com.tencent.mm.live.a)h.ag(com.tencent.mm.live.a.class)).getLivingRoomId()))) {
        break label309;
      }
      localObject = this.context.getString(R.l.live_tipsbar_other_lives, new Object[] { Integer.valueOf(localLinkedList.size()) });
      if (this.VYz.getVisibility() != 0) {
        break label298;
      }
      this.VYC.setText((CharSequence)localObject);
      atO(localLinkedList.size());
      setRootTipsBarBackground(true);
      this.VYy.VYN.notifyDataSetChanged();
    }
    for (;;)
    {
      setVisibility(0);
      AppMethodBeat.o(291745);
      return;
      label286:
      localObject = Integer.valueOf(localLinkedList.size());
      break;
      label298:
      this.VYC.setText((CharSequence)localObject);
      continue;
      label309:
      localObject = this.context.getString(R.l.live_tipsbar_total_lives, new Object[] { Integer.valueOf(localLinkedList.size()) });
      if (this.VYz.getVisibility() == 0)
      {
        this.VYC.setText((CharSequence)localObject);
        atO(localLinkedList.size());
        setRootTipsBarBackground(true);
        this.VYy.VYN.notifyDataSetChanged();
      }
      else
      {
        this.VYC.setText((CharSequence)localObject);
      }
    }
  }
  
  public final void hHt()
  {
    AppMethodBeat.i(291750);
    r localr = r.VYx;
    if (r.hHn()) {
      this.VYJ.eiV();
    }
    AppMethodBeat.o(291750);
  }
  
  public final void hHu()
  {
    AppMethodBeat.i(291751);
    r localr = r.VYx;
    if (r.hHn()) {
      this.VYJ.cTg();
    }
    AppMethodBeat.o(291751);
  }
  
  public void setChattingContext(com.tencent.mm.ui.chatting.e.a parama)
  {
    this.VYv = parama;
  }
  
  public void setChattingUserName(String paramString)
  {
    this.mye = paramString;
    if (this.VYy != null) {
      this.VYy.kid = paramString;
    }
  }
  
  public void setInChatRoom(boolean paramBoolean)
  {
    this.VYI = paramBoolean;
  }
  
  public void setRootTipsBarBackground(View paramView)
  {
    this.VYF = paramView;
  }
  
  public void setRootTipsBarBackground(boolean paramBoolean)
  {
    AppMethodBeat.i(291749);
    if (this.VYF != null) {
      if (paramBoolean)
      {
        this.VYF.setVisibility(0);
        this.VYF.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(279487);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/LiveTalkRoomTipsBar$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            LiveTalkRoomTipsBar.a(LiveTalkRoomTipsBar.this, true);
            paramAnonymousView = com.tencent.mm.ui.report.b.XLO;
            com.tencent.mm.ui.report.b.a(LiveTalkRoomTipsBar.c(LiveTalkRoomTipsBar.this), LiveTalkRoomTipsBar.a(LiveTalkRoomTipsBar.this).hHx(), "", 2L, System.currentTimeMillis());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LiveTalkRoomTipsBar$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(279487);
          }
        });
        if (this.rcN != null) {
          this.rcN.setVisibility(8);
        }
        if (this.VYG != null) {
          this.VYG.setVisibility(4);
        }
        if (this.VYH != null)
        {
          this.VYH.setBackgroundColor(0);
          AppMethodBeat.o(291749);
        }
      }
      else
      {
        this.VYF.setVisibility(8);
        if (this.rcN != null) {
          this.rcN.setVisibility(0);
        }
        if (this.VYG != null) {
          this.VYG.setVisibility(0);
        }
        if (this.VYH != null) {
          this.VYH.setBackgroundResource(R.g.tipsbar_small_white_bg);
        }
      }
    }
    AppMethodBeat.o(291749);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.LiveTalkRoomTipsBar
 * JD-Core Version:    0.7.0.1
 */